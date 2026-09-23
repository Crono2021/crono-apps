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
 * Safe Rolling GC:
 * Every 200MB streamed, triggers engine.optimizeStorage(30MB, immunity=10s) which safely frees
 * older cached chunks from TDLib disk cache WITHOUT calling cancelAndDeleteVideoSync or aborting
 * active downloads, preventing the dreaded 50-second freeze.
 */
class LocalStreamServer(private val engine: TelegramEngine) {

    companion object {
        private const val TAG = "LocalStreamServer"
        private const val PROBE_CHUNK_SIZE = 256L * 1024L        // 256 KB for instant header / probe reads
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB for instant initial video frame
        private const val STREAM_CHUNK_SIZE = 2097152L           // 2 MB for smooth continuous playback
        private const val ALIGNMENT = 131072L                   // 128 KB (TDLib MTProto block alignment)
        private const val ROLLING_GC_THRESHOLD = 200L * 1024L * 1024L // 200 MB
    }

    private var serverSocket: ServerSocket? = null
    private val executor: ExecutorService = Executors.newCachedThreadPool()

    @Volatile private var activeFileId: Int = -1
    @Volatile private var activeSize: Long = 0L
    @Volatile private var activeMime: String = "video/mp4"
    @Volatile private var activeParts: List<FilePart>? = null
    @Volatile private var bytesStreamedSinceGc: Long = 0L
    @Volatile private var isRunning: Boolean = false

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
        Log.i(TAG, "🚀 LocalStreamServer iniciado en $streamUrl (size=$activeSize, mime=$activeMime, parts=${multipartParts?.size ?: 1})")

        executor.execute {
            while (isRunning && !s.isClosed) {
                try {
                    val client = s.accept()
                    executor.execute { handleClient(client) }
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
        Log.i(TAG, "🛑 LocalStreamServer detenido y almacenamiento optimizado")
    }

    private fun handleClient(socket: Socket) {
        socket.use { s ->
            try {
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
                if (rangeHeader == null) {
                    serveRange(s, 0L, FIRST_CHUNK_SIZE)
                    return
                }

                val range = parseRange(rangeHeader, total)
                if (range == null) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                val start = range.first
                val requestedEnd = range.second

                // Adaptive chunk sizing for instant start:
                val maxChunkToServe = if (start < 512L * 1024L) {
                    FIRST_CHUNK_SIZE
                } else {
                    STREAM_CHUNK_SIZE
                }

                val end = min(requestedEnd, min(start + maxChunkToServe - 1, total - 1))
                val length = (end - start) + 1

                if (start >= total || length <= 0) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\nContent-Range: bytes */$total\r\nConnection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                serveRange(s, start, length)
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

    private fun serveRange(socket: Socket, globalStart: Long, length: Long) {
        val (partFileId, localOffset) = resolvePart(globalStart)
        val partSize = activeParts?.find { it.fileId == partFileId }?.size ?: activeSize
        val availableInPart = maxOf(0L, partSize - localOffset)
        val actualLength = min(length, availableInPart)

        if (actualLength <= 0) {
            sendSimple(socket, 416, "Range Not Satisfiable")
            return
        }

        // Align offset to 128KB (131072 bytes) as required by Telegram TDLib
        val alignedOffset = localOffset - (localOffset % ALIGNMENT)
        val offsetInsideBlock = (localOffset - alignedOffset).toInt()
        val neededBytes = offsetInsideBlock + actualLength
        val blocks = (neededBytes + ALIGNMENT - 1) / ALIGNMENT
        val fetchSize = min(blocks * ALIGNMENT, partSize - alignedOffset)

        // 1. Fast cache hit: check if TDLib already has this range in memory/disk
        var chunk = engine.readFilePartSync(partFileId, alignedOffset, fetchSize)
        if (chunk != null && chunk.size > offsetInsideBlock) {
            deliverSlice(socket, chunk, globalStart, offsetInsideBlock, actualLength)
            return
        }

        // 2. Fetch synchronously from Telegram CDN
        var attempts = 0
        while (attempts < 4 && isRunning) {
            attempts++
            chunk = engine.downloadRangeAndRead(partFileId, alignedOffset, fetchSize)
            if (chunk != null && chunk.size > offsetInsideBlock) {
                break
            }
            try {
                Thread.sleep(80L * attempts)
            } catch (_: InterruptedException) {
                Thread.currentThread().interrupt()
                break
            }
        }

        if (chunk == null || chunk.size <= offsetInsideBlock) {
            Log.e(TAG, "❌ Error al descargar chunk TDLib: offset=$alignedOffset fetchSize=$fetchSize")
            sendSimple(socket, 504, "Gateway Timeout")
            return
        }

        deliverSlice(socket, chunk, globalStart, offsetInsideBlock, actualLength)
    }

    private fun deliverSlice(socket: Socket, chunk: ByteArray, globalStart: Long, offsetInsideBlock: Int, actualLength: Long) {
        val sliceEnd = min(chunk.size.toLong(), offsetInsideBlock + actualLength).toInt()
        val sliceSize = sliceEnd - offsetInsideBlock
        val slice = if (offsetInsideBlock == 0 && sliceSize == chunk.size) {
            chunk
        } else {
            chunk.copyOfRange(offsetInsideBlock, sliceEnd)
        }

        val out = socket.getOutputStream()
        val header = "HTTP/1.1 206 Partial Content\r\n" +
                     "Content-Type: $activeMime\r\n" +
                     "Content-Length: ${slice.size}\r\n" +
                     "Content-Range: bytes $globalStart-${globalStart + slice.size - 1}/$activeSize\r\n" +
                     "Accept-Ranges: bytes\r\n" +
                     "Connection: close\r\n\r\n"

        out.write(header.toByteArray(StandardCharsets.US_ASCII))
        out.write(slice)
        out.flush()

        Log.d(TAG, "HTTP 206: range $globalStart-${globalStart + slice.size - 1}/$activeSize (${slice.size} bytes)")

        // Safe Rolling GC check: frees older chunks without killing active streaming
        bytesStreamedSinceGc += slice.size
        if (bytesStreamedSinceGc >= ROLLING_GC_THRESHOLD) {
            bytesStreamedSinceGc = 0L
            Log.i(TAG, "🧹 ROLLING GC SEGURO (200MB): Invocando optimizeStorage(30MB, immunity=10s)")
            try {
                engine.optimizeStorage(30L * 1024L * 1024L, immunityDelaySec = 10)
            } catch (e: Exception) {
                Log.w(TAG, "Error ejecutando optimizeStorage: ${e.message}")
            }
        }
    }

    private fun parseRange(rangeHeader: String, totalSize: Long): Pair<Long, Long>? {
        if (!rangeHeader.startsWith("bytes=", ignoreCase = true)) return null
        val clean = rangeHeader.substringAfter("=").trim().substringBefore(",")
        val dashIdx = clean.indexOf('-')
        if (dashIdx < 0) return null

        val startStr = clean.substring(0, dashIdx).trim()
        val endStr = clean.substring(dashIdx + 1).trim()

        val start = startStr.toLongOrNull() ?: return null
        val end = if (endStr.isNotBlank()) {
            endStr.toLongOrNull() ?: (totalSize - 1)
        } else {
            min(totalSize - 1, start + STREAM_CHUNK_SIZE - 1)
        }

        return Pair(start, end)
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
