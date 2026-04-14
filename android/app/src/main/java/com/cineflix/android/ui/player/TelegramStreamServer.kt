package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import fi.iki.elonen.NanoHTTPD
import java.io.File
import java.io.RandomAccessFile

/**
 * Local HTTP proxy for progressive TDLib video streaming.
 *
 * TDLib writes the video file sequentially to disk as it downloads.
 * This server serves that file via HTTP with Range-request support so
 * ExoPlayer can start playback immediately — without waiting for the full download.
 *
 * Flow:
 *   1. PlayerActivity calls startServer() → server listens on 127.0.0.1:PORT
 *   2. TDLib begins downloading → engine calls setLocalPath(path)
 *   3. ExoPlayer hits GET /video → server waits for localPath, serves bytes
 *   4. ExoPlayer seeks → issues new Range request → server hints TDLib offset
 */
class TelegramStreamServer(
    private val engine: TelegramEngine,
    private val fileId: Int,
    val totalSize: Long,
    private val mimeType: String,
    port: Int = PORT,
) : NanoHTTPD("127.0.0.1", port) {

    companion object {
        private const val TAG = "TelegramStream"
        const val PORT = 8765
    }

    /** Set by TelegramEngine as soon as TDLib assigns a local file path */
    @Volatile var localPath: String? = null

    override fun serve(session: IHTTPSession): Response {
        // ------------------------------------------------------------------
        // 1. Wait until TDLib has started writing the file (path is assigned)
        // ------------------------------------------------------------------
        val filePath = waitForPath() ?: return newFixedLengthResponse(
            Response.Status.SERVICE_UNAVAILABLE, "text/plain",
            "TDLib download not started within timeout"
        )
        val file = File(filePath)
        val knownSize = if (totalSize > 0) totalSize else 1L

        // Always advertise range support
        val rangeHeader = session.headers["range"]

        if (rangeHeader != null && rangeHeader.startsWith("bytes=")) {
            // ----------------------------------------------------------------
            // 2. Partial (Range) request
            // ----------------------------------------------------------------
            val parts = rangeHeader.removePrefix("bytes=").split("-")
            val start = parts[0].toLongOrNull() ?: 0L
            val end   = if (parts.size > 1 && parts[1].isNotEmpty())
                            parts[1].toLongOrNull() ?: (knownSize - 1)
                        else
                            (knownSize - 1)
            val length = end - start + 1

            // Hint TDLib to prioritise this region
            engine.hintDownloadOffset(fileId, start)

            // Wait for at least the start byte to be available
            waitForBytes(file, start + 1)

            val raf = RandomAccessFile(file, "r")
            raf.seek(start)
            val stream = ProgressiveStream(raf, file, length)

            val response = newFixedLengthResponse(
                Response.Status.PARTIAL_CONTENT, mimeType, stream, length
            )
            response.addHeader("Content-Range",  "bytes $start-$end/$knownSize")
            response.addHeader("Accept-Ranges",  "bytes")
            response.addHeader("Content-Length", length.toString())
            return response
        }

        // ----------------------------------------------------------------
        // 3. Full (non-Range) request — serve as much as available so far,
        //    let ExoPlayer figure out seeking afterwards
        // ----------------------------------------------------------------
        engine.hintDownloadOffset(fileId, 0)
        waitForBytes(file, minOf(256 * 1024L, knownSize))   // wait for 256 KB

        val raf = RandomAccessFile(file, "r")
        val stream = ProgressiveStream(raf, file, knownSize)
        val response = newFixedLengthResponse(Response.Status.OK, mimeType, stream, knownSize)
        response.addHeader("Accept-Ranges", "bytes")
        return response
    }

    // ──────────────────────────────────────────────────────────────────────────

    /** Block until TDLib assigns a local path (usually < 1 second) */
    private fun waitForPath(): String? {
        val deadline = System.currentTimeMillis() + 25_000L
        while (System.currentTimeMillis() < deadline) {
            localPath?.let { return it }
            Thread.sleep(100)
        }
        Log.e(TAG, "Timeout waiting for TDLib local path (fileId=$fileId)")
        return null
    }

    /** Block until [file] has at least [neededBytes] on disk */
    private fun waitForBytes(file: File, neededBytes: Long) {
        val deadline = System.currentTimeMillis() + 60_000L
        while (System.currentTimeMillis() < deadline) {
            if (file.exists() && file.length() >= neededBytes) return
            Thread.sleep(150)
        }
        Log.w(TAG, "Timeout waiting for $neededBytes bytes (have ${file.length()})")
    }

    // ──────────────────────────────────────────────────────────────────────────

    /**
     * InputStream that reads from a RandomAccessFile while the file is still
     * being written by TDLib.  If read() hits EOF before the requested length
     * is consumed, it polls until more bytes arrive (up to 60 s).
     */
    private inner class ProgressiveStream(
        private val raf: RandomAccessFile,
        private val file: File,
        remaining: Long,
    ) : java.io.InputStream() {

        private var left = remaining

        override fun read(buf: ByteArray, off: Int, len: Int): Int {
            if (left <= 0L) return -1
            val want = minOf(len.toLong(), left, 64 * 1024L).toInt()

            // Wait until the file has enough bytes at the current position
            val deadline = System.currentTimeMillis() + 60_000L
            val endPos   = raf.filePointer + want
            while (file.length() < endPos) {
                if (System.currentTimeMillis() > deadline) return -1
                Thread.sleep(150)
            }

            val got = raf.read(buf, off, want)
            if (got > 0) left -= got
            return got
        }

        override fun read(): Int {
            val b = ByteArray(1)
            return if (read(b, 0, 1) < 0) -1 else (b[0].toInt() and 0xFF)
        }

        override fun close() = raf.close()
    }
}
