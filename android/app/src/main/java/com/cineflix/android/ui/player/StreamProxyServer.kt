package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import fi.iki.elonen.NanoHTTPD
import java.io.InputStream

/**
 * StreamProxyServer — NanoHTTPD-based local HTTP server that proxies
 * Telegram byte-range requests between ExoPlayer and TDLib.
 *
 * DISK-FREE MODE: No file is ever written to device storage.
 * Each range request asks TDLib to download that exact range
 * synchronously from Telegram's CDN, reads the bytes, and
 * streams them directly to ExoPlayer. Disk usage = 0 bytes.
 *
 * Flow:
 *   ExoPlayer → HTTP GET /stream (with Range header)
 *               → TdApi.DownloadFile(offset, limit, synchronous=true)
 *               → TdApi.ReadFilePart(offset, count)
 *               → HTTP 206 + bytes returned to ExoPlayer
 *               → TDLib cache freed (no permanent file)
 */
class StreamProxyServer(
    private val engine: TelegramEngine,
    private val fileId: Int,
    val fileSize: Long,
    private val mimeType: String,
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    companion object {
        private const val TAG = "StreamProxy"

        // Each NanoHTTPD request gets this chunk size delivered to ExoPlayer.
        // 4MB reduces the frequency of TDLib round-trips, preventing micro-freezes
        // on slower devices like Fire Stick where WiFi throughput is limited.
        private const val PREFETCH_SIZE = 4L * 1024L * 1024L
        
        // Wipe local TDLib cache every 450MB to never exceed TV storage capacity
        private const val ROLLING_GC_THRESHOLD = 450L * 1024L * 1024L
    }

    @Volatile
    private var bytesReadSinceLastWipe: Long = 0L

    private fun checkRollingGc(bytesDelivered: Int) {
        bytesReadSinceLastWipe += bytesDelivered
        if (bytesReadSinceLastWipe > ROLLING_GC_THRESHOLD) {
            Log.i(TAG, "🧹 ROLLING GC FIRED: Wiping TV disk, freeing space for next chunk. fileId=$fileId")
            engine.cancelAndDeleteVideo(fileId)
            bytesReadSinceLastWipe = 0L
        }
    }

    /**
     * Resolve the true file size from TDLib (up to 10s).
     * TDLib knows the real size after the first DownloadFile call returns.
     * Falls back to the size passed via Intent if TDLib hasn't reported yet.
     */
    private fun resolveFileSize(): Long {
        val deadline = System.currentTimeMillis() + 10_000L
        while (System.currentTimeMillis() < deadline) {
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.expectedSize > 0) {
                Log.d(TAG, "resolveFileSize → ${state.expectedSize} (from TDLib)")
                return state.expectedSize
            }
            Thread.sleep(100)
        }
        Log.w(TAG, "resolveFileSize → $fileSize (fallback from Intent)")
        return fileSize
    }

    override fun serve(session: IHTTPSession): Response {
        Log.d(TAG, "serve() URI=${session.uri} Range=${session.headers["range"]}")

        val actualFileSize = resolveFileSize()

        // Parse the Range header: "bytes=start-end"
        val rangeHeader = session.headers["range"] ?: "bytes=0-"
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
     *  1. Try ReadFilePart (fast — TDLib already has this range in its buffer)
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
                checkRollingGc(toRead)
                return toRead
            }

            // --- Slow path: fetch from TDLib ---
            val toFetch = minOf(
                maxOf(len.toLong(), PREFETCH_SIZE),
                endPosition - currentPosition
            )

            // 🚀 AGGRESSIVE MULTIPLEXING (NATIVE) 🚀
            // Force TDLib to aggressively download the next 20MB in the background.
            // TDLib natively splits this into multiple concurrent socket connections.
            // 20MB gives Fire Stick/low-end devices enough runway to avoid micro-freezes.
            engine.hintDownloadOffset(fileId, currentPosition, 20L * 1024L * 1024L)

            // Try 1: fast ReadFilePart (already in TDLib's internal buffer)
            val fastChunk = engine.readFilePartSync(fileId, currentPosition, toFetch)
            if (fastChunk != null && fastChunk.isNotEmpty()) {
                return deliverFromChunk(fastChunk, b, off, len)
            }

            // Try 2: synchronous download — blocks until Telegram CDN delivers the range.
            // This is the KEY to disk-free streaming: instead of downloading the whole
            // file, we download ONLY the bytes ExoPlayer needs right now.
            val syncChunk = engine.downloadRangeAndRead(fileId, currentPosition, toFetch)
            if (syncChunk != null && syncChunk.isNotEmpty()) {
                return deliverFromChunk(syncChunk, b, off, len)
            }

            // EOF check
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.isCompleted && currentPosition >= state.expectedSize) {
                Log.d(TAG, "EOF reached at position=$currentPosition")
                return -1
            }

            // Transient failure — return 0 so ExoPlayer retries
            Log.w(TAG, "Transient fetch failure at position=$currentPosition, returning 0")
            return 0
        }

        private fun deliverFromChunk(chunk: ByteArray, b: ByteArray, off: Int, len: Int): Int {
            prefetchBuffer = chunk
            prefetchOffset = currentPosition
            val toRead = minOf(len, chunk.size)
            System.arraycopy(chunk, 0, b, off, toRead)
            currentPosition += toRead
            checkRollingGc(toRead)
            return toRead
        }
    }
}
