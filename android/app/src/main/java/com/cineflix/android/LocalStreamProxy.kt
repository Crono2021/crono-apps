package com.cineflix.android

import android.util.Log
import fi.iki.elonen.NanoHTTPD
import org.drinkless.tdlib.TdApi
import java.io.File
import java.io.InputStream
import java.io.RandomAccessFile
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class LocalStreamProxy(private val telegramManager: TelegramManager) : NanoHTTPD("127.0.0.1", 0) {

    private val TAG = "LocalStreamProxy"

    data class FileState(
        var localPath: String? = null,
        var downloadedSize: Long = 0,
        var expectedSize: Long = 0,
        var isCompleted: Boolean = false
    )

    private val activeFiles = ConcurrentHashMap<Int, FileState>()
    private val fileLocks   = ConcurrentHashMap<Int, Object>()

    fun onUpdateFile(updateFile: TdApi.UpdateFile) {
        val file  = updateFile.file
        val state = activeFiles[file.id] ?: return

        if (!file.local.path.isNullOrEmpty()) state.localPath = file.local.path
        state.downloadedSize = file.local.downloadedPrefixSize
        state.expectedSize   = file.expectedSize
        state.isCompleted    = file.local.isDownloadingCompleted

        fileLocks[file.id]?.let { lock ->
            synchronized(lock) { lock.notifyAll() }
        }
    }

    override fun serve(session: IHTTPSession): Response {
        val uri    = session.uri
        val params = session.parameters

        if (uri == "/resolve") {
            val chatId = params["chat_id"]?.firstOrNull()?.toLongOrNull()
            val msgId  = params["msg_id"]?.firstOrNull()?.toLongOrNull()

            if (chatId == null || msgId == null)
                return newFixedLengthResponse(Response.Status.BAD_REQUEST, MIME_PLAINTEXT, "Missing chat_id or msg_id")

            Log.i(TAG, "Resolving video chat=$chatId msg=$msgId")
            return serveStream(chatId, msgId, session)
        }
        return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not found")
    }

    private fun serveStream(chatId: Long, msgId: Long, session: IHTTPSession): Response {
        val client = telegramManager.getClient()
            ?: return newFixedLengthResponse(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "TDLib not init")

        // ── 1. Resolve fileId from message ──────────────────────────────────
        val latch  = CountDownLatch(1)
        var fileId = -1
        var mimeType = "video/mp4"
        var totalSize = 0L

        client.send(TdApi.GetMessage(chatId, msgId)) { result ->
            if (result is TdApi.Message) {
                when (val c = result.content) {
                    is TdApi.MessageVideo -> {
                        fileId    = c.video.video.id
                        totalSize = c.video.video.expectedSize
                        mimeType  = c.video.mimeType.ifEmpty { "video/mp4" }
                    }
                    is TdApi.MessageDocument -> {
                        fileId    = c.document.document.id
                        totalSize = c.document.document.expectedSize
                        mimeType  = c.document.mimeType.ifEmpty { "video/mp4" }  // mimeType is on Document, not File
                    }
                    else -> {}
                }
            }
            latch.countDown()
        }

        latch.await(10, TimeUnit.SECONDS)

        if (fileId == -1)
            return newFixedLengthResponse(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not a video/document")

        // ── 2. Register state tracking ───────────────────────────────────────
        activeFiles.putIfAbsent(fileId, FileState(expectedSize = totalSize))
        fileLocks.putIfAbsent(fileId, Object())

        // ── 3. Start async download (synchronous=false so we can stream progressively) ──
        client.send(TdApi.DownloadFile(fileId, 1, 0, 0, false)) {}

        // ── 4. Wait for local file path to appear ───────────────────────────
        val state = activeFiles[fileId]!!
        val lock  = fileLocks[fileId]!!

        synchronized(lock) {
            val deadline = System.currentTimeMillis() + 15_000
            while (state.localPath.isNullOrEmpty()) {
                val remaining = deadline - System.currentTimeMillis()
                if (remaining <= 0) break
                lock.wait(minOf(remaining, 500L))
            }
        }

        val localPath = state.localPath
        if (localPath.isNullOrEmpty())
            return newFixedLengthResponse(Response.Status.SERVICE_UNAVAILABLE, MIME_PLAINTEXT, "Timeout: no local path")

        // ── 5. Parse Range header ────────────────────────────────────────────
        val rangeHeader = session.headers["range"]
        val (rangeStart, rangeEndReq) = parseRange(rangeHeader, totalSize)
        val rangeEnd = if (totalSize > 0) minOf(rangeEndReq, totalSize - 1) else rangeEndReq

        Log.d(TAG, "Range $rangeStart-$rangeEnd / $totalSize | file=$localPath")

        // ── 6. Wait for enough bytes to cover rangeStart ─────────────────────
        // (We only need rangeStart bytes downloaded to begin reading)
        val neededToStart = rangeStart + 1
        if (state.downloadedSize < neededToStart && !state.isCompleted) {
            synchronized(lock) {
                val deadline2 = System.currentTimeMillis() + 60_000
                while (state.downloadedSize < neededToStart && !state.isCompleted) {
                    val remaining = deadline2 - System.currentTimeMillis()
                    if (remaining <= 0) break
                    lock.wait(minOf(remaining, 500L))
                }
            }
        }

        if (state.downloadedSize < neededToStart && !state.isCompleted)
            return newFixedLengthResponse(Response.Status.SERVICE_UNAVAILABLE, MIME_PLAINTEXT, "Not enough data yet")

        // ── 7. Serve progressively via streaming InputStream ─────────────────
        val contentLength = if (totalSize > 0) rangeEnd - rangeStart + 1 else -1L
        val isPartial = rangeHeader != null && rangeHeader.startsWith("bytes=")
        val status    = if (isPartial) Response.Status.PARTIAL_CONTENT else Response.Status.OK

        val inputStream = ProgressiveFileInputStream(localPath, rangeStart, contentLength, state, lock)

        val response = newChunkedResponse(status, mimeType, inputStream)
        if (totalSize > 0) {
            response.addHeader("Content-Length",  contentLength.toString())
            response.addHeader("Content-Range",   "bytes $rangeStart-$rangeEnd/$totalSize")
        }
        response.addHeader("Accept-Ranges",            "bytes")
        response.addHeader("Connection",               "keep-alive")
        response.addHeader("Access-Control-Allow-Origin", "*")
        return response
    }

    /**
     * InputStream that reads from a partially-downloaded file, blocking when it catches
     * up with the download head and unblocking when TDLib notifies more bytes are ready.
     */
    private class ProgressiveFileInputStream(
        filePath: String,
        startOffset: Long,
        private val totalToRead: Long,
        private val state: FileState,
        private val lock: Object
    ) : InputStream() {

        private val raf   = RandomAccessFile(File(filePath), "r").also { it.seek(startOffset) }
        private var read  = 0L
        private val buf   = ByteArray(64 * 1024) // 64 KB read chunks

        override fun read(): Int {
            val b = ByteArray(1)
            return if (read(b, 0, 1) == -1) -1 else (b[0].toInt() and 0xFF)
        }

        override fun read(b: ByteArray, off: Int, len: Int): Int {
            if (totalToRead > 0 && read >= totalToRead) return -1

            val maxLen  = if (totalToRead > 0) minOf(len.toLong(), totalToRead - read).toInt() else len
            val filePos = raf.filePointer

            // Wait until TDLib has downloaded enough bytes
            synchronized(lock) {
                val deadline = System.currentTimeMillis() + 90_000
                while (state.downloadedSize <= filePos && !state.isCompleted) {
                    val rem = deadline - System.currentTimeMillis()
                    if (rem <= 0) return -1
                    lock.wait(minOf(rem, 300L))
                }
            }
            if (state.downloadedSize <= filePos && !state.isCompleted) return -1

            val n = raf.read(b, off, minOf(maxLen, (state.downloadedSize - filePos).toInt().coerceAtLeast(1)))
            if (n > 0) read += n
            return n
        }

        override fun close() {
            runCatching { raf.close() }
        }
    }

    private fun parseRange(header: String?, fileSize: Long): Pair<Long, Long> {
        if (header == null || !header.startsWith("bytes=")) return Pair(0L, if (fileSize > 0) fileSize - 1 else Long.MAX_VALUE)
        return try {
            val parts = header.removePrefix("bytes=").split("-")
            val start = if (parts[0].isNotEmpty()) parts[0].toLong() else 0L
            val end   = if (parts.size > 1 && parts[1].isNotEmpty()) parts[1].toLong()
                        else if (fileSize > 0) fileSize - 1 else Long.MAX_VALUE
            Pair(start, end)
        } catch (e: Exception) {
            Pair(0L, if (fileSize > 0) fileSize - 1 else Long.MAX_VALUE)
        }
    }
}
