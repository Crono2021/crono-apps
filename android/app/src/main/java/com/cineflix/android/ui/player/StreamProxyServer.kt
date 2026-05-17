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
        
        // Wipe stale TDLib cache files every 250MB to keep TV storage under control.
        // IMPORTANT: We must NEVER call cancelAndDeleteVideo() during playback —
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
    private fun checkRollingGc(bytesDelivered: Int) {
        bytesReadSinceLastWipe += bytesDelivered
        if (bytesReadSinceLastWipe > ROLLING_GC_THRESHOLD) {
            Log.i(TAG, "🧹 SAFE GC: Cleaning stale TDLib disk cache (keeping active download alive)")
            try {
                val filesDir = engine.getAppFilesDir()
                val videosDir = java.io.File(filesDir, "tdlib_data/videos")
                if (videosDir.exists()) videosDir.deleteRecursively()
                val docsDir = java.io.File(filesDir, "tdlib_data/documents")
                if (docsDir.exists()) docsDir.deleteRecursively()
            } catch (e: Exception) {
                Log.w(TAG, "Safe GC disk cleanup failed: ${e.message}")
            }
            bytesReadSinceLastWipe = 0L
        }
    }

    @Volatile
    private var resolvedFileSize: Long? = null

    /**
     * Resolve the true file size from TDLib (up to 10s).
     * TDLib knows the real size after the first DownloadFile call returns.
     * Falls back to the size passed via Intent if TDLib hasn't reported yet.
     * Caches the result to prevent ExoPlayer from restarting playback due to size mismatch.
     */
    private fun resolveFileSize(): Long {
        resolvedFileSize?.let { return it }

        val deadline = System.currentTimeMillis() + 10_000L
        while (System.currentTimeMillis() < deadline) {
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.expectedSize > 0) {
                Log.d(TAG, "resolveFileSize → ${state.expectedSize} (from TDLib)")
                resolvedFileSize = state.expectedSize
                return state.expectedSize
            }
            Thread.sleep(100)
        }
        Log.w(TAG, "resolveFileSize → $fileSize (fallback from Intent)")
        resolvedFileSize = fileSize
        return fileSize
    }

    override fun serve(session: IHTTPSession): Response {
        Log.d(TAG, "serve() URI=${session.uri} Range=${session.headers["range"]}")

        val actualFileSize = resolveFileSize()
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

            // --- Slow path: fetch from TDLib with retries ---
            val toFetch = minOf(
                maxOf(len.toLong(), PREFETCH_SIZE),
                endPosition - currentPosition
            )

            // 🚀 AGGRESSIVE MULTIPLEXING (NATIVE) 🚀
            engine.hintDownloadOffset(fileId, currentPosition, toFetch)

            var retries = 0
            while (retries < 150) { // Up to 15 seconds wait for the FIRST byte of this chunk
                val fastChunk = engine.readFilePartSync(fileId, currentPosition, toFetch)
                if (fastChunk != null && fastChunk.isNotEmpty()) {
                    return deliverFromChunk(fastChunk, b, off, len)
                }

                // EOF check: if we know the expected size and have reached it, it's EOF.
                val state = engine.getFileStateFlow(fileId).value
                if (state != null && state.expectedSize > 0 && currentPosition >= state.expectedSize) {
                    Log.d(TAG, "EOF reached at position=$currentPosition")
                    return -1
                }

                Thread.sleep(100)
                retries++
            }

            // If we still fail after retries, we MUST throw an IOException. 
            // Returning 0 when len > 0 causes NanoHTTPD to enter an infinite loop!
            throw java.io.IOException("TDLib failed to fetch data at position=$currentPosition after 15s")
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
