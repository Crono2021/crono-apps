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
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    companion object {
        private const val TAG = "StreamProxy"

        // 128 KB for small metadata/index probes; 512 KB for fast initial frame; 2 MB for continuous streaming
        private const val PROBE_CHUNK_SIZE = 128L * 1024L        // 128 KB (TDLib block unit)
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB (instant first video frame: 4 blocks)
        private const val STREAM_CHUNK_SIZE = 2L * 1024L * 1024L  // 2 MB (smooth buffering)
        
        // Wipe stale TDLib cache files every 250MB to keep TV storage under control.
        // IMPORTANT: We must NEVER call cancelAndDeleteVideo() during playback â€”
        // it kills the active TDLib download, making all subsequent seeks fail.
        private const val ROLLING_GC_THRESHOLD = 250L * 1024L * 1024L
    }

    @Volatile
    private var bytesReadSinceLastWipe: Long = 0L

    /**
     * Safe GC: wipes old TDLib video/document cache files from disk
     * WITHOUT cancelling the active download. This preserves the
     * streaming session so ExoPlayer can still seek freely.
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

    private fun checkRollingGc(bytesDelivered: Int, currentPartFileId: Int) {
        // No-op during playback: cancelling or deleting TDLib downloads during active
        // streaming breaks LibVLC seeking and causes playback failure.
        // Cleanup is safely done when the user exits the player in PlayerActivity.onDestroy().
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
        Log.d(TAG, "serve() URI=${session.uri} Method=${session.method} Range=${session.headers["range"]}")

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

        // In-memory prefetch buffer â€” avoids one IPC call per byte
        private var prefetchBuffer: ByteArray? = null
        private var prefetchOffset: Long = -1L

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
                return toRead
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
            // Determine optimal chunk size:
            // - If LibVLC is probing container header at offset 0 (EBML / moov < 256KB) or small metadata/cues probe: fetch 128KB!
            // - If this is the initial video frame (prefetchBuffer == null): fetch 512KB for instant startup!
            // - For continuous streaming: fetch 2MB chunks with background prefetching.
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

            // Trigger proactive background prefetch for the NEXT chunk immediately!
            val nextOffset = alignedOffset + fetchSize
            if (desiredChunk >= FIRST_CHUNK_SIZE && nextOffset < partSize) {
                engine.hintDownloadOffset(partId, nextOffset, STREAM_CHUNK_SIZE)
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
            prefetchBuffer = chunk
            prefetchOffset = currentPosition - offsetInsideBlock
            val available = chunk.size - offsetInsideBlock
            val toRead = minOf(len, available)
            System.arraycopy(chunk, offsetInsideBlock, b, off, toRead)
            currentPosition += toRead
            return toRead
        }
    }
}







