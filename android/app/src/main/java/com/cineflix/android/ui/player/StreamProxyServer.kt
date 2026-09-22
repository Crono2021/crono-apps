package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import fi.iki.elonen.NanoHTTPD
import java.io.InputStream

/**
 * StreamProxyServer â€” NanoHTTPD-based local HTTP server that proxies
 * Telegram byte-range requests between ExoPlayer and TDLib.
 *
 * DISK-FREE MODE: No file is ever written to device storage.
 * Each range request asks TDLib to download that exact range
 * synchronously from Telegram's CDN, reads the bytes, and
 * streams them directly to ExoPlayer. Disk usage = 0 bytes.
 *
 * Flow:
 *   ExoPlayer â†’ HTTP GET /stream (with Range header)
 *               â†’ TdApi.DownloadFile(offset, limit, synchronous=true)
 *               â†’ TdApi.ReadFilePart(offset, count)
 *               â†’ HTTP 206 + bytes returned to ExoPlayer
 *               â†’ TDLib cache freed (no permanent file)
 */
data class FilePart(val fileId: Int, val size: Long)

class StreamProxyServer(
    private val engine: TelegramEngine,
    private val fileId: Int,
    val fileSize: Long,
    private val mimeType: String,
    private val multipartParts: List<FilePart>? = null,
    val playbackId: String = "",
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    companion object {
        private const val TAG = "StreamProxy"

        // 512 KB for small metadata/index probes and fast initial frame; 2 MB for continuous streaming
        private const val PROBE_CHUNK_SIZE = 512L * 1024L        // 512 KB (MTProto standard block)
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB (instant first video frame / seek: 1 block)
        private const val STREAM_CHUNK_SIZE = 2L * 1024L * 1024L  // 2 MB (smooth buffering: 4 blocks)
        
        // Wipe stale TDLib cache files every 250MB to keep TV storage under control.
        // IMPORTANT: We must NEVER call cancelAndDeleteVideo() during playback â€”
        // it kills the active TDLib download, making all subsequent seeks fail.
        private const val ROLLING_GC_THRESHOLD = 250L * 1024L * 1024L
    }

    @Volatile
    private var bytesReadSinceLastWipe: Long = 0L

    @Volatile
    var lastChunkReceivedTime: Long = System.currentTimeMillis()

    /**
     * Rolling GC: after every 200 MB streamed, call TDLib optimizeStorage
     * to clean old cache files. Without this, TDLib accumulates GB of
     * temporary files on disk and the TV storage fills up, causing stutters.
     * Mirrors TdlibMemoryDataSource.checkRollingQuota().
     */
    private fun checkRollingGc(bytesDelivered: Int, currentPartFileId: Int) {
        if (playbackId.isNotEmpty()) return // GramJS is 100% in-memory, no disk cache!
        bytesReadSinceLastWipe += bytesDelivered
        if (bytesReadSinceLastWipe >= ROLLING_GC_THRESHOLD) {
            bytesReadSinceLastWipe = 0L
            Log.i(TAG, "🧹 ROLLING GC TRIGGERED (250MB): Optimizing TDLib disk cache for fileId=$currentPartFileId")
            try {
                engine.optimizeStorage(30L * 1024L * 1024L, immunityDelaySec = 10)
            } catch (e: Exception) {
                Log.w(TAG, "Error in checkRollingGc: ${e.message}")
            }
        }
    }

    /**
     * Maps a global byte offset to (partFileId, localOffset) for multipart files.
     */
    private fun resolvePart(globalOffset: Long): Pair<Int, Long> {
        if (multipartParts.isNullOrEmpty()) return Pair(fileId, globalOffset)
        var accumulated = 0L
        for (part in multipartParts) {
            if (globalOffset < accumulated + part.size) {
                return Pair(part.fileId, globalOffset - accumulated)
            }
            accumulated += part.size
        }
        val lastPart = multipartParts.last()
        return Pair(lastPart.fileId, globalOffset - (accumulated - lastPart.size))
    }

    @Volatile
    private var resolvedFileSize: Long? = null

    /**
     * Resolve the true file size from TDLib (up to 10s).
     * TDLib knows the real size after the first DownloadFile call returns.
     * Falls back to the size passed via Intent if TDLib hasn't reported yet.
     * Caches the result to prevent ExoPlayer/LibVLC from restarting playback due to size mismatch.
     */
    private fun resolveFileSize(): Long {
        if (!multipartParts.isNullOrEmpty()) {
            val total = multipartParts.sumOf { it.size }
            if (total > 0L) return total
            return fileSize
        }
        resolvedFileSize?.let { return it }

        if (fileSize > 0L) {
            resolvedFileSize = fileSize
            return fileSize
        }

        val deadline = System.currentTimeMillis() + 5_000L
        while (System.currentTimeMillis() < deadline) {
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.expectedSize > 0) {
                Log.d(TAG, "resolveFileSize -> ${state.expectedSize} (from TDLib)")
                resolvedFileSize = state.expectedSize
                return state.expectedSize
            }
            Thread.sleep(100)
        }
        val fallback = if (fileSize > 0L) fileSize else 2_000_000_000L
        Log.w(TAG, "resolveFileSize -> $fallback (fallback)")
        resolvedFileSize = fallback
        return fallback
    }

    override fun serve(session: IHTTPSession): Response {
        Log.i(TAG, "🌐 [NanoHTTPD Proxy] serve() URI=${session.uri} Method=${session.method} Range=${session.headers["range"]}")

        // --- CORS preflight support for WebView fetch() ---
        if (session.method == Method.OPTIONS) {
            val response = newFixedLengthResponse(Response.Status.OK, "text/plain", "OK")
            response.addHeader("Access-Control-Allow-Origin", "*")
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
            response.addHeader("Access-Control-Allow-Headers", "*")
            return response
        }

        // --- High-Speed Binary Chunk Delivery Endpoint (Zero Base64) ---
        if (session.uri == "/deliverChunk" && session.method == Method.POST) {
            val reqId = session.parameters["id"]?.firstOrNull() ?: session.parms["id"]
            val pending = com.cineflix.android.GramJSStreamManager.activeRequests.remove(reqId)
            if (pending != null) {
                val contentLength = session.headers["content-length"]?.toIntOrNull() ?: 0
                val buffer = ByteArray(contentLength)
                var totalRead = 0
                val input = session.inputStream
                while (totalRead < contentLength) {
                    val read = input.read(buffer, totalRead, contentLength - totalRead)
                    if (read == -1) break
                    totalRead += read
                }
                val actualBytes = if (totalRead == contentLength) buffer else buffer.copyOf(totalRead)
                pending.deferred.complete(Result.success(actualBytes))
                val response = newFixedLengthResponse(Response.Status.OK, "text/plain", "OK")
                response.addHeader("Access-Control-Allow-Origin", "*")
                return response
            }
            val notFound = newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Unknown requestId")
            notFound.addHeader("Access-Control-Allow-Origin", "*")
            return notFound
        }

        // --- Error Delivery Endpoint ---
        if (session.uri == "/deliverChunkError" && session.method == Method.POST) {
            val reqId = session.parameters["id"]?.firstOrNull() ?: session.parms["id"]
            val err = session.parameters["error"]?.firstOrNull() ?: session.parms["error"] ?: "Unknown error"
            Log.d(TAG, "⚠️ Received deliverChunkError: reqId=$reqId error=$err")
            val pending = com.cineflix.android.GramJSStreamManager.activeRequests.remove(reqId)
            pending?.deferred?.complete(Result.failure(java.io.IOException(err)))
            val response = newFixedLengthResponse(Response.Status.OK, "text/plain", "OK")
            response.addHeader("Access-Control-Allow-Origin", "*")
            return response
        }

        val actualFileSize = resolveFileSize()

        if (session.method == Method.HEAD) {
            val response = newFixedLengthResponse(
                Response.Status.OK,
                mimeType,
                null,
                actualFileSize
            )
            response.addHeader("Accept-Ranges", "bytes")
            return response
        }
        val rangeHeader = session.headers["range"]

        if (rangeHeader == null) {
            Log.d(TAG, "Serving full file (no Range header) of $actualFileSize bytes")
            val inputStream = DiskFreeInputStream(engine, fileId, 0L, actualFileSize, actualFileSize)
            val response = newFixedLengthResponse(
                Response.Status.OK,
                mimeType,
                inputStream,
                actualFileSize
            )
            response.addHeader("Accept-Ranges", "bytes")
            return response
        }

        // Parse the Range header: "bytes=start-end"
        val (start, endRequested) = parseRange(rangeHeader)
        val end = if (endRequested < 0 || endRequested >= actualFileSize) actualFileSize - 1 else endRequested
        val length = end - start + 1

        Log.d(TAG, "Serving bytes $start-$end ($length bytes) of $actualFileSize total")

        val inputStream = DiskFreeInputStream(engine, fileId, start, length, actualFileSize)

        val response = newFixedLengthResponse(
            Response.Status.PARTIAL_CONTENT,
            mimeType,
            inputStream,
            length
        )
        response.addHeader("Content-Range", "bytes $start-$end/$actualFileSize")
        response.addHeader("Accept-Ranges", "bytes")
        return response
    }

    private fun parseRange(rangeHeader: String): Pair<Long, Long> {
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader)
        val start = match?.groupValues?.get(1)?.toLongOrNull() ?: 0L
        val end   = match?.groupValues?.get(2)?.toLongOrNull() ?: -1L
        return Pair(start, end)
    }

    /**
     * InputStream that fetches bytes on-demand directly from TDLib.
     * Never reads from a local file. TDLib manages its own internal
     * temporary buffer, but our app never holds the full file.
     *
     * Strategy:
     *  1. Try ReadFilePart (fast â€” TDLib already has this range in its buffer)
     *  2. If not cached: DownloadFile(synchronous=true) then ReadFilePart
     *     This blocks until Telegram CDN delivers the bytes, then returns them.
     *  3. Serves bytes from an in-memory prefetch buffer (2MB) to reduce IPC calls.
     */
    private inner class DiskFreeInputStream(
        private val engine: TelegramEngine,
        private val fileId: Int,
        private val startOffset: Long,
        private val lengthRequested: Long,
        private val totalFileSize: Long,
    ) : InputStream() {

        private var currentPosition = startOffset
        private val endPosition     = startOffset + lengthRequested

        // In-memory prefetch buffer — avoids one IPC call per byte
        private var prefetchBuffer: ByteArray? = null
        private var prefetchOffset: Long = -1L
        @Volatile private var currentReqId: String? = null

        override fun read(): Int {
            val b = ByteArray(1)
            return if (read(b, 0, 1) == -1) -1 else b[0].toInt() and 0xFF
        }

        override fun read(b: ByteArray, off: Int, len: Int): Int {
            if (currentPosition >= endPosition) return -1

            // --- Fast path: data is in the prefetch buffer ---
            val pb = prefetchBuffer
            if (pb != null &&
                currentPosition >= prefetchOffset &&
                currentPosition < prefetchOffset + pb.size
            ) {
                val bufferIdx = (currentPosition - prefetchOffset).toInt()
                val available = pb.size - bufferIdx
                val toRead    = minOf(len, available)
                System.arraycopy(pb, bufferIdx, b, off, toRead)
                currentPosition += toRead
                checkRollingGc(toRead, resolvePart(currentPosition - toRead).first)
                return toRead
            }

            if (playbackId.isNotEmpty()) {
                // --- GramJS in-memory streaming mode (0 bytes disk, global multipart support) ---
                val ALIGNMENT = 524288L // 512 KB alignment for MTProto
                val alignedOffset = currentPosition - (currentPosition % ALIGNMENT)
                val offsetInsideBlock = (currentPosition - alignedOffset).toInt()
                val requestRemaining = endPosition - currentPosition

                val desiredChunk = if (requestRemaining <= 512L * 1024L || (currentPosition < 512L * 1024L && prefetchBuffer == null)) {
                    PROBE_CHUNK_SIZE
                } else if (prefetchBuffer == null) {
                    FIRST_CHUNK_SIZE
                } else {
                    STREAM_CHUNK_SIZE
                }

                val neededBytes = offsetInsideBlock.toLong() + minOf(requestRemaining, desiredChunk)
                val blocks = ((neededBytes + ALIGNMENT - 1) / ALIGNMENT)
                val maxRemaining = maxOf(0L, totalFileSize - alignedOffset)
                if (maxRemaining <= 0L) return -1
                val fetchSize = minOf(blocks * ALIGNMENT, maxRemaining)

                val reqId = java.util.UUID.randomUUID().toString()
                currentReqId = reqId
                val deferred = kotlinx.coroutines.CompletableDeferred<Result<ByteArray>>()
                com.cineflix.android.GramJSStreamManager.activeRequests[reqId] = com.cineflix.android.PendingGramJSRequest(
                    generation = 0,
                    virtualOffset = alignedOffset,
                    deferred = deferred
                )
                val port = listeningPort
                val js = "if(window.fetchGramJSBlock) window.fetchGramJSBlock('$reqId', '$playbackId', $alignedOffset, $fetchSize, $port);"
                val startTime = System.currentTimeMillis()
                android.os.Handler(android.os.Looper.getMainLooper()).post {
                    com.cineflix.android.GramJSStreamManager.webView?.evaluateJavascript(js, null)
                }

                val result = try {
                    kotlinx.coroutines.runBlocking {
                        kotlinx.coroutines.withTimeoutOrNull(30_000L) {
                            deferred.await()
                        }
                    }
                } finally {
                    com.cineflix.android.GramJSStreamManager.activeRequests.remove(reqId)
                    if (currentReqId == reqId) {
                        currentReqId = null
                    }
                }

                val elapsed = System.currentTimeMillis() - startTime
                if (result != null && result.isSuccess) {
                    val chunk = result.getOrThrow()
                    com.cineflix.android.util.ErrorLogCollector.log(TAG, "⚡ GramJS chunk: offset=$alignedOffset size=${chunk.size} (requested=$fetchSize) in ${elapsed}ms")
                    if (chunk.size > offsetInsideBlock) {
                        return deliverFromChunk(chunk, offsetInsideBlock, b, off, len)
                    }
                }

                // If failed, cancelled, or timed out, notify JS immediately
                android.os.Handler(android.os.Looper.getMainLooper()).post {
                    com.cineflix.android.GramJSStreamManager.webView?.evaluateJavascript("if(window.cancelGramJSRequest) window.cancelGramJSRequest('$reqId');", null)
                }

                val err = result?.exceptionOrNull()?.message ?: "Timeout (30s) at offset $alignedOffset"
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "❌ GramJS in-memory fetch failed: $err after ${elapsed}ms")
                Log.e(TAG, "❌ GramJS in-memory fetch failed: $err")
                throw java.io.IOException("GramJS fetch failed: $err")
            }

            // --- Slow path: fetch from TDLib with 128KB (131072) alignment ---
            val (partId, localOffset) = resolvePart(currentPosition)
            val partSize = multipartParts?.find { it.fileId == partId }?.size ?: totalFileSize

            if (localOffset >= partSize) {
                Log.d(TAG, "EOF reached for partId=$partId at localOffset=$localOffset")
                return -1
            }

            // TDLib requires offset to be an exact multiple of 131072 (128 KB)
            val ALIGNMENT = 131072L
            val alignedOffset = localOffset - (localOffset % ALIGNMENT)
            val offsetInsideBlock = (localOffset - alignedOffset).toInt()

            val maxFromPart = maxOf(0L, partSize - alignedOffset)
            if (maxFromPart <= 0L) return -1

            val requestRemaining = endPosition - currentPosition
            val desiredChunk = if (requestRemaining <= 512L * 1024L || (localOffset < 256L * 1024L && prefetchBuffer == null)) {
                PROBE_CHUNK_SIZE
            } else if (prefetchBuffer == null) {
                FIRST_CHUNK_SIZE
            } else {
                STREAM_CHUNK_SIZE
            }

            val neededBytes = offsetInsideBlock.toLong() + minOf(requestRemaining, desiredChunk)
            val blocks = ((neededBytes + ALIGNMENT - 1) / ALIGNMENT)
            val fetchSize = minOf(blocks * ALIGNMENT, maxFromPart)

            // --- TDLib Fallback (Legacy disk cache) ---
            // Trigger proactive background prefetch for upcoming chunks (16 MB rolling window)
            val nextOffset = alignedOffset + fetchSize
            if (desiredChunk >= FIRST_CHUNK_SIZE && nextOffset < partSize) {
                val remainingInPart = partSize - nextOffset
                val prefetchSize = minOf(16L * 1024L * 1024L, remainingInPart)
                engine.hintDownloadOffset(partId, nextOffset, prefetchSize)
            }

            // 1. Check if TDLib already has this chunk in memory/cache
            val fastChunk = engine.readFilePartSync(partId, alignedOffset, fetchSize)
            if (fastChunk != null && fastChunk.size > offsetInsideBlock) {
                return deliverFromChunk(fastChunk, offsetInsideBlock, b, off, len)
            }

            // 2. Download synchronously from Telegram CDN
            var chunk: ByteArray? = null
            var retries = 0
            while (retries < 5) {
                chunk = engine.downloadRangeAndRead(partId, alignedOffset, fetchSize)
                if (chunk != null && chunk.size > offsetInsideBlock) {
                    break
                }
                retries++
                Thread.sleep(100)
            }

            if (chunk != null && chunk.size > offsetInsideBlock) {
                return deliverFromChunk(chunk, offsetInsideBlock, b, off, len)
            }

            // EOF check: check TDLib's reported file size
            val state = engine.getFileStateFlow(partId).value
            if (state != null && state.expectedSize > 0 && localOffset >= state.expectedSize) {
                Log.d(TAG, "EOF confirmed from state at position=$currentPosition")
                return -1
            }

            throw java.io.IOException("TDLib failed to fetch data at position=$currentPosition (partId=$partId, localOffset=$localOffset) after retries")
        }

        private fun deliverFromChunk(chunk: ByteArray, offsetInsideBlock: Int, b: ByteArray, off: Int, len: Int): Int {
            lastChunkReceivedTime = System.currentTimeMillis()
            prefetchBuffer = chunk
            prefetchOffset = currentPosition - offsetInsideBlock
            val available = chunk.size - offsetInsideBlock
            val toRead = minOf(len, available)
            System.arraycopy(chunk, offsetInsideBlock, b, off, toRead)
            val partId = resolvePart(currentPosition).first
            currentPosition += toRead
            checkRollingGc(toRead, partId)
            return toRead
        }

        override fun close() {
            prefetchBuffer = null
            val req = currentReqId
            if (req != null) {
                currentReqId = null
                val pending = com.cineflix.android.GramJSStreamManager.activeRequests.remove(req)
                pending?.deferred?.complete(Result.failure(java.io.IOException("Stream closed")))
                android.os.Handler(android.os.Looper.getMainLooper()).post {
                    com.cineflix.android.GramJSStreamManager.webView?.evaluateJavascript("if(window.cancelGramJSRequest) window.cancelGramJSRequest('$req');", null)
                }
            }
            super.close()
        }
    }
}







