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
 * LocalStreamServer — Ultra-lightweight local HTTP server inspired by Oliyo.
 *
 * Uses raw Java ServerSocket to serve byte-range requests directly to ExoPlayer/LibVLC.
 * Each range request is translated directly into a synchronous TdApi.DownloadFile(offset, limit, true)
 * followed by TdApi.ReadFilePart, completely eliminating intermediate proxy overhead and continuous
 * background disk thrashing.
 *
 * Optimizations for Instant Startup:
 *  1. Initial probe/header requests (<512KB) use fast 256KB-512KB chunks for instant response (<100ms).
 *  2. Checks TDLib cache (readFilePartSync) before downloading to serve repeat ranges in 0ms.
 *  3. Binds to wildcard (0.0.0.0) on a free dynamic port, allowing both local ExoPlayer (127.0.0.1)
 *     and Google Cast ($wifiIp) to use the same fast server without running a second proxy.
 *
 * The engine serializes cache reads/downloads/purges in a shared 32 MiB disk window.
 * Socket writes use owned RAM copies, so a purge cannot invalidate an in-flight response.
 */
class LocalStreamServer(private val engine: TelegramEngine) {

    companion object {
        private const val TAG = "LocalStreamServer"
        private const val PROBE_CHUNK_SIZE = 256L * 1024L        // 256 KB for instant header / probe reads
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB for instant initial video frame
        private const val STREAM_CHUNK_SIZE = 2097152L           // 2 MB for smooth continuous playback
        private const val ALIGNMENT = 131072L                   // 128 KB (TDLib MTProto block alignment)
        private const val STORAGE_SAMPLE_BYTES = 8L * 1024L * 1024L
    }

    private var serverSocket: ServerSocket? = null
    private val executor: ExecutorService = Executors.newCachedThreadPool()
    private val clients = java.util.concurrent.ConcurrentHashMap.newKeySet<Socket>()

    @Volatile private var activeFileId: Int = -1
    @Volatile private var activeSize: Long = 0L
    @Volatile private var activeMime: String = "video/mp4"
    @Volatile private var activeParts: List<FilePart>? = null
    @Volatile private var bytesStreamedSinceGc: Long = 0L
    @Volatile private var isRunning: Boolean = false

    private val activeRequestId = java.util.concurrent.atomic.AtomicLong(0L)
    @Volatile private var currentStreamingSocket: Socket? = null

    var listeningPort: Int = 0
        private set

    fun start(
        fileId: Int,
        totalSize: Long,
        mimeType: String = "video/mp4",
        multipartParts: List<FilePart>? = null
    ): String {
        // Close previous socket without wiping cache during startup
        isRunning = false
        try {
            serverSocket?.close()
        } catch (_: Exception) {}
        serverSocket = null

        activeFileId = fileId
        activeSize = if (totalSize > 0) totalSize else 2_000_000_000L
        activeMime = if (mimeType.isNotBlank()) mimeType else "video/mp4"
        activeParts = multipartParts
        bytesStreamedSinceGc = 0L
        isRunning = true

        // Bind to all local interfaces (0.0.0.0) so both 127.0.0.1 and Cast work
        val s = ServerSocket(0, 16)
        serverSocket = s
        listeningPort = s.localPort

        val streamUrl = "http://127.0.0.1:$listeningPort/stream"
        activeRequestId.set(0L)
        com.cineflix.android.util.ErrorLogCollector.log(TAG, "start: fileId=$fileId size=$activeSize port=$listeningPort parts=${multipartParts?.size ?: 1}")
        Log.i(TAG, "🚀 LocalStreamServer iniciado en $streamUrl (size=$activeSize, mime=$activeMime, parts=${multipartParts?.size ?: 1})")

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
        activeParts = null

        // Full storage purge when player stops
        try {
            engine.optimizeStorage(30L * 1024L * 1024L, immunityDelaySec = 0)
        } catch (_: Exception) {}
        com.cineflix.android.util.ErrorLogCollector.log(TAG, "stop: LocalStreamServer stopped")
        Log.i(TAG, "🛑 LocalStreamServer detenido y almacenamiento optimizado")
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
                                 "Content-Type: $activeMime\r\n" +
                                 "Content-Length: $total\r\n" +
                                 "Accept-Ranges: bytes\r\n" +
                                 "Connection: close\r\n\r\n"
                    val out = s.getOutputStream()
                    out.write(header.toByteArray(StandardCharsets.US_ASCII))
                    out.flush()
                    Log.d(TAG, "HEAD 200 OK (size=$total)")
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
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                val start = range.first
                val requestedEnd = range.second

                if (start >= total || requestedEnd < start) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                serveStream(s, start, requestedEnd)
            } catch (e: Exception) {
                // Client disconnection or socket timeout is normal during seeking
                Log.d(TAG, "Client socket closed: ${e.message}")
            }
        }
    }

    private fun resolvePart(globalOffset: Long): Pair<Int, Long> {
        val parts = activeParts
        if (parts.isNullOrEmpty()) return Pair(activeFileId, globalOffset)
        var accumulated = 0L
        for (p in parts) {
            if (globalOffset < accumulated + p.size) {
                return Pair(p.fileId, globalOffset - accumulated)
            }
            accumulated += p.size
        }
        val lastPart = parts.last()
        return Pair(lastPart.fileId, globalOffset - (accumulated - lastPart.size))
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
        val reqStartTime = System.currentTimeMillis()
        com.cineflix.android.util.ErrorLogCollector.log(
            TAG,
            "Req #$myRequestId start: range=$globalStart-$requestedEnd ($totalLength bytes)"
        )

        val out = socket.getOutputStream()
        val header = "HTTP/1.1 206 Partial Content\r\n" +
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
            com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId closed before header: ${e.message}")
            return
        }

        Log.d(TAG, "HTTP 206 stream start: $globalStart-$requestedEnd/$activeSize ($totalLength bytes)")

        var currentPos = globalStart
        var isFirstChunk = true

        while (currentPos <= requestedEnd && isRunning && myRequestId == activeRequestId.get()) {
            val (partFileId, localOffset) = resolvePart(currentPos)
            val partSize = activeParts?.find { it.fileId == partFileId }?.size ?: activeSize
            val availableInPart = maxOf(0L, partSize - localOffset)
            val remainingInRequest = requestedEnd - currentPos + 1
            val maxCanReadFromPart = minOf(remainingInRequest, availableInPart)
            if (maxCanReadFromPart <= 0) break

            if (myRequestId != activeRequestId.get() || !isRunning) {
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId superseded before fetch at pos=$currentPos")
                break
            }

            // Instant first chunk: 512KB for initial load or seek, then 2MB for continuous streaming
            val targetChunkSize = if (isFirstChunk) {
                FIRST_CHUNK_SIZE
            } else {
                STREAM_CHUNK_SIZE
            }
            val bytesToReadThisRound = minOf(targetChunkSize, maxCanReadFromPart)

            // Align offset to 128KB (131072 bytes) as required by Telegram TDLib
            val alignedOffset = localOffset - (localOffset % ALIGNMENT)
            val offsetInsideBlock = (localOffset - alignedOffset).toInt()
            val neededBytes = offsetInsideBlock + bytesToReadThisRound
            val blocks = (neededBytes + ALIGNMENT - 1) / ALIGNMENT
            val fetchSize = min(blocks * ALIGNMENT, partSize - alignedOffset)

            // All reads go through the same bounded window, including cache hits.
            var chunk: ByteArray? = null
            if (isRunning && myRequestId == activeRequestId.get()) {
                var attempts = 0
                while (attempts < 4 && isRunning && myRequestId == activeRequestId.get()) {
                    attempts++
                    chunk = engine.readBoundedVideoRange(partFileId, alignedOffset, fetchSize)
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

            if (myRequestId != activeRequestId.get() || !isRunning) {
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId superseded after fetch at pos=$currentPos")
                break
            }

            if (chunk == null || chunk.size <= offsetInsideBlock) {
                Log.e(TAG, "❌ Error al descargar chunk TDLib: offset=$alignedOffset fetchSize=$fetchSize")
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId fetch error: offset=$alignedOffset fetchSize=$fetchSize")
                break
            }

            val sliceEnd = minOf(chunk.size.toLong(), offsetInsideBlock + bytesToReadThisRound).toInt()
            val sliceSize = sliceEnd - offsetInsideBlock
            if (sliceSize <= 0) break

            try {
                out.write(chunk, offsetInsideBlock, sliceSize)
                out.flush()
            } catch (e: Exception) {
                // Client disconnection or seek is normal during video streaming
                Log.d(TAG, "Client socket closed during stream: ${e.message}")
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId client disconnected at pos=$currentPos: ${e.message}")
                break
            }

            if (isFirstChunk) {
                val elapsed = System.currentTimeMillis() - reqStartTime
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId first chunk delivered ($sliceSize bytes) in ${elapsed}ms")
            }

            currentPos += sliceSize
            isFirstChunk = false

            // Diagnostics only: actual enforcement lives in the engine's shared window.
            bytesStreamedSinceGc += sliceSize
            if (bytesStreamedSinceGc >= STORAGE_SAMPLE_BYTES) {
                bytesStreamedSinceGc = 0L
                engine.logStreamStorage("delivered fileId=$partFileId offset=$currentPos")
            }
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
            // Suffix range: bytes=-500000 (last 500000 bytes)
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
