package com.cineflix.android

import android.util.Log
import fi.iki.elonen.NanoHTTPD
import org.drinkless.tdlib.Client
import org.drinkless.tdlib.TdApi
import java.io.File
import java.io.RandomAccessFile
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.math.min

class LocalStreamProxy(private val telegramManager: TelegramManager) : NanoHTTPD("127.0.0.1", 0) {

    private val TAG = "LocalStreamProxy"
    
    // Almacena la info de los archivos en proceso
    data class FileState(var localPath: String? = null, var downloadedSize: Long = 0, var expectedSize: Long = 0, var isCompleted: Boolean = false)
    
    private val activeFiles = ConcurrentHashMap<Int, FileState>()
    private val fileLocks = ConcurrentHashMap<Int, Object>()

    init {
        // Obtenemos actualizaciones de archivos desde TDLib
        telegramManager.getClient()?.send(TdApi.SetLogStream(TdApi.LogStreamEmpty())) {}
    }

    // Método para ser llamado desde UpdateFile en TelegramManager (o registrado)
    fun onUpdateFile(updateFile: TdApi.UpdateFile) {
        val file = updateFile.file
        val state = activeFiles[file.id] ?: return
        
        state.localPath = file.local.path
        state.downloadedSize = file.local.downloadedPrefixSize
        state.expectedSize = file.expectedSize
        state.isCompleted = file.local.isDownloadingCompleted
        
        // Notificar a cualquier hilo esperando bytes
        fileLocks[file.id]?.let { lock ->
            synchronized(lock) { lock.notifyAll() }
        }
    }

    override fun serve(session: IHTTPSession): Response {
        val uri = session.uri
        val params = session.parameters
        
        if (uri == "/resolve") {
            val chatId = params["chat_id"]?.firstOrNull()?.toLongOrNull()
            val msgId = params["msg_id"]?.firstOrNull()?.toLongOrNull()
            
            if (chatId == null || msgId == null) {
                return newFixedLengthResponse(Response.Status.BAD_REQUEST, MIME_PLAINTEXT, "Missing chat_id or msg_id")
            }
            
            Log.i(TAG, "Resolving video for chat $chatId, msg $msgId")
            return serveStream(chatId, msgId, session)
        }
        
        return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not found")
    }

    private fun serveStream(chatId: Long, msgId: Long, session: IHTTPSession): Response {
        val client = telegramManager.getClient()
            ?: return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "TDLib not strictly initialized")
            
        // 1. GetMessage para obtener el fileId
        val latch = CountDownLatch(1)
        var fileId: Int? = null
        var videoSize = 0L
        
        client.send(TdApi.GetMessage(chatId, msgId)) { result ->
            if (result is TdApi.Message) {
                val content = result.content
                if (content is TdApi.MessageVideo) {
                    fileId = content.video.video.id
                    videoSize = content.video.video.expectedSize
                } else if (content is TdApi.MessageDocument) {
                    fileId = content.document.document.id
                    videoSize = content.document.document.expectedSize
                }
            }
            latch.countDown()
        }
        
        latch.await(5, TimeUnit.SECONDS)
        
        if (fileId == null) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Message is not a video/document")
        }
        
        val fId = fileId!!
        
        // Registrar en activeFiles
        activeFiles.putIfAbsent(fId, FileState(expectedSize = videoSize))
        fileLocks.putIfAbsent(fId, Object())
        
        // 2. Iniciar descarga
        client.send(TdApi.DownloadFile(fId, 1, 0, 0, true)) {}
        
        // Esperar a tener la ruta local y algunos bytes
        val lock = fileLocks[fId]!!
        var state = activeFiles[fId]!!
        
        synchronized(lock) {
            val startWait = System.currentTimeMillis()
            while (state.localPath.isNullOrEmpty() && (System.currentTimeMillis() - startWait < 10000)) {
                lock.wait(1000)
                state = activeFiles[fId]!!
            }
        }
        
        val localPath = state.localPath
        if (localPath.isNullOrEmpty()) {
            return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "Timeout waiting for TDLib to create local file")
        }
        
        // 3. Servir progresivo
        val rangeHeader = session.headers["range"]
        val (rangeStart, rangeEndConfig) = parseRange(rangeHeader, videoSize)
        val rangeEnd = minOf(rangeEndConfig, videoSize - 1)
        
        Log.d(TAG, "Serving range: $rangeStart-$rangeEnd (Total: $videoSize) File: $localPath")
        
        // Esperar que TDLib descargue hasta rangeEnd
        val neededBytes = minOf(rangeEnd + 1, videoSize)
        if (!waitForBytes(fId, neededBytes)) {
             if (state.downloadedSize == 0L) {
                 return newFixedLengthResponse(Response.Status.SERVICE_UNAVAILABLE, MIME_PLAINTEXT, "No data yet")
             }
        }
        
        val serveEnd = minOf(rangeEnd, state.downloadedSize - 1)
        val serveLength = serveEnd - rangeStart + 1
        
        if (serveLength <= 0) {
            return newFixedLengthResponse(Response.Status.RANGE_NOT_SATISFIABLE, MIME_PLAINTEXT, "Satisfiable error")
        }
        
        return try {
            val file = File(localPath)
            val raf = RandomAccessFile(file, "r")
            raf.seek(rangeStart)
            
            val buf = ByteArray(serveLength.toInt())
            raf.readFully(buf)
            raf.close()
            
            val isPartial = rangeHeader != null && rangeHeader.startsWith("bytes=")
            val status = if (isPartial) Response.Status.PARTIAL_CONTENT else Response.Status.OK

            val response = newFixedLengthResponse(status, "video/mp4", buf.inputStream(), serveLength)
            response.addHeader("Content-Range", "bytes $rangeStart-$serveEnd/$videoSize")
            response.addHeader("Accept-Ranges", "bytes")
            response.addHeader("Connection", "keep-alive")
            response.addHeader("Access-Control-Allow-Origin", "*")
            response
        } catch (e: Exception) {
            Log.e(TAG, "Stream error", e)
            newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, e.message)
        }
    }
    
    private fun waitForBytes(fileId: Int, needed: Long): Boolean {
        val state = activeFiles[fileId] ?: return false
        val lock = fileLocks[fileId] ?: return false
        
        if (needed <= state.downloadedSize || state.isCompleted) return true
        
        val deadline = System.currentTimeMillis() + 90000L // 90s max
        synchronized(lock) {
            while (state.downloadedSize < needed && !state.isCompleted) {
                val remaining = deadline - System.currentTimeMillis()
                if (remaining <= 0) return false
                lock.wait(minOf(remaining, 500L))
            }
        }
        return state.downloadedSize >= needed || state.isCompleted
    }
    
    private fun parseRange(rangeHeader: String?, fileSize: Long): Pair<Long, Long> {
        if (rangeHeader == null || !rangeHeader.startsWith("bytes=")) {
            return Pair(0L, fileSize - 1)
        }
        return try {
            val range = rangeHeader.removePrefix("bytes=")
            val parts = range.split("-")
            val start = if (parts[0].isNotEmpty()) parts[0].toLong() else 0L
            val end = if (parts.size > 1 && parts[1].isNotEmpty()) {
                minOf(parts[1].toLong(), fileSize - 1)
            } else {
                fileSize - 1
            }
            Pair(start, end)
        } catch (e: Exception) {
            Pair(0L, fileSize - 1)
        }
    }
}
