package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.util.Locale
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.math.min

/**
 * CineScreenStreamServer — Dedicated lightweight streaming server for the 16-bit retro cinema screen in WebView.
 *
 * Runs completely isolated from the main PlayerActivity / LocalStreamServer to guarantee 100% stability
 * of normal full playback while providing direct HTTP Range streaming to Android WebView's HTML5 video element.
 */
class CineScreenStreamServer(private val engine: TelegramEngine) {

    companion object {
        private const val TAG = "CineScreenStream"
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB for instant initial video frame
        private const val STREAM_CHUNK_SIZE = 2097152L           // 2 MB for smooth continuous playback
        private const val ALIGNMENT = 131072L                   // 128 KB (TDLib MTProto block alignment)
    }

    private var serverSocket: ServerSocket? = null
    private val executor: ExecutorService = Executors.newCachedThreadPool()
    private val clients = java.util.concurrent.ConcurrentHashMap.newKeySet<Socket>()

    @Volatile private var activeFileId: Int = -1
    @Volatile private var activeSize: Long = 0L
    @Volatile private var activeMime: String = "video/mp4"
    @Volatile private var isRunning: Boolean = false

    private val activeRequestId = java.util.concurrent.atomic.AtomicLong(0L)
    @Volatile private var currentStreamingSocket: Socket? = null

    var listeningPort: Int = 0
        private set

    fun start(
        fileId: Int,
        totalSize: Long,
        mimeType: String = "video/mp4"
    ): String {
        isRunning = false
        try {
            serverSocket?.close()
        } catch (_: Exception) {}
        serverSocket = null

        activeFileId = fileId
        activeSize = if (totalSize > 0) totalSize else 2_000_000_000L
        activeMime = if (mimeType.isNotBlank()) mimeType else "video/mp4"
        isRunning = true

        val s = ServerSocket(0, 16)
        serverSocket = s
        listeningPort = s.localPort

        val streamUrl = "http://127.0.0.1:$listeningPort/stream"
        activeRequestId.set(0L)
        Log.i(TAG, "🍿 CineScreenStreamServer iniciado en $streamUrl (fileId=$fileId, size=$activeSize, mime=$activeMime)")

        executor.execute {
            while (isRunning && !s.isClosed) {
                try {
                    val client = s.accept()
                    clients.add(client)
                    executor.execute {
                        try { handleClient(client) } finally { clients.remove(client) }
                    }
                } catch (e: Exception) {
                    if (isRunning) {
                        Log.d(TAG, "Accept loop info: ${e.message}")
                    }
                }
            }
        }

        return streamUrl
    }

    fun stop() {
        isRunning = false
        activeRequestId.incrementAndGet()
        currentStreamingSocket = null
        clients.forEach { try { it.close() } catch (_: Exception) {} }
        clients.clear()
        executor.shutdownNow()
        try {
            serverSocket?.close()
        } catch (_: Exception) {}
        serverSocket = null
        listeningPort = 0
        activeFileId = -1
        activeSize = 0L
        Log.i(TAG, "🛑 CineScreenStreamServer detenido")
    }

    private fun handleClient(socket: Socket) {
        socket.use { s ->
            try {
                s.tcpNoDelay = true
                s.soTimeout = 20000
                val reader = BufferedReader(InputStreamReader(s.getInputStream(), StandardCharsets.US_ASCII))
                val requestLine = reader.readLine() ?: return

                val parts = requestLine.split(" ")
                if (parts.size < 2) {
                    sendSimple(s, 400, "Bad Request")
                    return
                }

                val method = parts[0].uppercase(Locale.ROOT)
                val path = parts[1]

                var rangeHeader: String? = null
                var line: String? = reader.readLine()
                while (!line.isNullOrEmpty()) {
                    if (line.startsWith("Range:", ignoreCase = true)) {
                        rangeHeader = line.substringAfter(":").trim()
                    }
                    line = reader.readLine()
                }

                if (method == "OPTIONS") {
                    val header = "HTTP/1.1 204 No Content\r\n" +
                                 "Access-Control-Allow-Origin: *\r\n" +
                                 "Access-Control-Allow-Methods: GET, HEAD, OPTIONS\r\n" +
                                 "Access-Control-Allow-Headers: Range, Accept-Encoding, Origin, User-Agent\r\n" +
                                 "Connection: close\r\n\r\n"
                    val out = s.getOutputStream()
                    out.write(header.toByteArray(StandardCharsets.US_ASCII))
                    out.flush()
                    return
                }

                if (!path.startsWith("/stream")) {
                    sendSimple(s, 404, "Not Found")
                    return
                }

                val total = activeSize
                if (total <= 0) {
                    sendSimple(s, 503, "Stream Not Ready")
                    return
                }

                if (method == "HEAD") {
                    val header = "HTTP/1.1 200 OK\r\n" +
                                 "Access-Control-Allow-Origin: *\r\n" +
                                 "Content-Type: $activeMime\r\n" +
                                 "Content-Length: $total\r\n" +
                                 "Accept-Ranges: bytes\r\n" +
                                 "Connection: close\r\n\r\n"
                    val out = s.getOutputStream()
                    out.write(header.toByteArray(StandardCharsets.US_ASCII))
                    out.flush()
                    return
                }

                if (method != "GET") {
                    sendSimple(s, 405, "Method Not Allowed")
                    return
                }

                // GET handling
                val range = if (rangeHeader != null) {
                    parseRange(rangeHeader, total)
                } else {
                    Pair(0L, total - 1)
                }

                if (range == null) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nAccess-Control-Allow-Origin: *\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                val start = range.first
                val requestedEnd = range.second

                if (start >= total || requestedEnd < start) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nAccess-Control-Allow-Origin: *\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                serveStream(s, start, requestedEnd)
            } catch (e: Exception) {
                Log.d(TAG, "Client socket closed: ${e.message}")
            }
        }
    }

    private fun serveStream(socket: Socket, globalStart: Long, requestedEnd: Long) {
        val totalLength = (requestedEnd - globalStart) + 1
        if (totalLength <= 0) {
            sendSimple(socket, 416, "Range Not Satisfiable")
            return
        }

        val oldSocket = currentStreamingSocket
        currentStreamingSocket = socket
        if (oldSocket != null && oldSocket != socket && !oldSocket.isClosed) {
            try {
                oldSocket.close()
            } catch (_: Exception) {}
        }

        val myRequestId = activeRequestId.incrementAndGet()
        val out = socket.getOutputStream()
        val header = "HTTP/1.1 206 Partial Content\r\n" +
                     "Access-Control-Allow-Origin: *\r\n" +
                     "Content-Type: $activeMime\r\n" +
                     "Content-Length: $totalLength\r\n" +
                     "Content-Range: bytes $globalStart-$requestedEnd/$activeSize\r\n" +
                     "Accept-Ranges: bytes\r\n" +
                     "Connection: close\r\n\r\n"

        try {
            out.write(header.toByteArray(StandardCharsets.US_ASCII))
            out.flush()
        } catch (e: Exception) {
            Log.d(TAG, "Socket closed before writing header: ${e.message}")
            return
        }

        var currentPos = globalStart
        var isFirstChunk = true

        while (currentPos <= requestedEnd && isRunning && myRequestId == activeRequestId.get()) {
            val remainingInRequest = requestedEnd - currentPos + 1
            val availableInPart = maxOf(0L, activeSize - currentPos)
            val maxCanRead = minOf(remainingInRequest, availableInPart)
            if (maxCanRead <= 0) break

            if (myRequestId != activeRequestId.get() || !isRunning) break

            val targetChunkSize = if (isFirstChunk) FIRST_CHUNK_SIZE else STREAM_CHUNK_SIZE
            val bytesToReadThisRound = minOf(targetChunkSize, maxCanRead)

            val alignedOffset = currentPos - (currentPos % ALIGNMENT)
            val offsetInsideBlock = (currentPos - alignedOffset).toInt()
            val neededBytes = offsetInsideBlock + bytesToReadThisRound
            val blocks = (neededBytes + ALIGNMENT - 1) / ALIGNMENT
            val fetchSize = min(blocks * ALIGNMENT, activeSize - alignedOffset)

            var chunk: ByteArray? = null
            if (isRunning && myRequestId == activeRequestId.get()) {
                var attempts = 0
                while (attempts < 4 && isRunning && myRequestId == activeRequestId.get()) {
                    attempts++
                    chunk = engine.readBoundedVideoRange(activeFileId, alignedOffset, fetchSize)
                    if (chunk != null && chunk.size > offsetInsideBlock) {
                        break
                    }
                    if (myRequestId != activeRequestId.get() || !isRunning) break
                    try {
                        Thread.sleep(80L * attempts)
                    } catch (_: InterruptedException) {
                        Thread.currentThread().interrupt()
                        break
                    }
                }
            }

            if (myRequestId != activeRequestId.get() || !isRunning) break

            if (chunk == null || chunk.size <= offsetInsideBlock) {
                Log.e(TAG, "❌ Error al descargar chunk TDLib para pantalla cine: offset=$alignedOffset fetchSize=$fetchSize")
                break
            }

            val sliceEnd = minOf(chunk.size.toLong(), offsetInsideBlock + bytesToReadThisRound).toInt()
            val sliceSize = sliceEnd - offsetInsideBlock
            if (sliceSize <= 0) break

            try {
                out.write(chunk, offsetInsideBlock, sliceSize)
                out.flush()
            } catch (e: Exception) {
                Log.d(TAG, "Socket write error at pos=$currentPos: ${e.message}")
                break
            }

            currentPos += sliceSize
            isFirstChunk = false
        }

        if (currentStreamingSocket == socket) {
            currentStreamingSocket = null
        }
    }

    private fun parseRange(rangeHeader: String, totalSize: Long): Pair<Long, Long>? {
        if (!rangeHeader.startsWith("bytes=", ignoreCase = true)) return null
        val clean = rangeHeader.substringAfter("=").trim().substringBefore(",")
        val dashIdx = clean.indexOf('-')
        if (dashIdx < 0) return null

        val startStr = clean.substring(0, dashIdx).trim()
        val endStr = clean.substring(dashIdx + 1).trim()

        if (startStr.isEmpty()) {
            val suffix = endStr.toLongOrNull() ?: return null
            val start = maxOf(0L, totalSize - suffix)
            return Pair(start, totalSize - 1)
        }

        val start = startStr.toLongOrNull() ?: return null
        val end = if (endStr.isNotBlank()) {
            endStr.toLongOrNull() ?: (totalSize - 1)
        } else {
            totalSize - 1
        }

        return Pair(start, min(end, totalSize - 1))
    }

    private fun sendSimple(socket: Socket, code: Int, reason: String) {
        try {
            val body = "$code $reason\r\n"
            val bodyBytes = body.toByteArray(StandardCharsets.UTF_8)
            val header = "HTTP/1.1 $code $reason\r\n" +
                         "Access-Control-Allow-Origin: *\r\n" +
                         "Content-Type: text/plain; charset=utf-8\r\n" +
                         "Content-Length: ${bodyBytes.size}\r\n" +
                         "Connection: close\r\n\r\n"
            val out = socket.getOutputStream()
            out.write(header.toByteArray(StandardCharsets.US_ASCII))
            out.write(bodyBytes)
            out.flush()
        } catch (_: Exception) {}
    }
}
