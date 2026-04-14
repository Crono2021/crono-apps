package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import fi.iki.elonen.NanoHTTPD
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

/**
 * StreamProxyServer — NanoHTTPD-based local HTTP server that proxies
 * Telegram byte-range requests between ExoPlayer and TDLib.
 *
 * COPIED from original Cineflix Android StreamProxyServer.kt
 * Adapted: TDLib writes to a local file; this server reads from it.
 *
 * Flow:
 *   ExoPlayer → HTTP GET /stream (with Range header)
 *               → server reads from TDLib local file
 *               → HTTP 206 response returned to ExoPlayer
 */
class StreamProxyServer(
    private val engine: TelegramEngine,
    private val fileId: Int,
    val fileSize: Long,
    private val mimeType: String,
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    companion object {
        private const val TAG = "StreamProxy"
        private const val CHUNK_SIZE = 64 * 1024 // 64KB chunks, same as original
    }

    /** Set by PlayerActivity once TDLib assigns a local file path */
    @Volatile var localPath: String? = null

    override fun serve(session: IHTTPSession): Response {
        Log.d(TAG, "serve() called, URI=${session.uri}, Range=${session.headers["range"]}")

        // Wait for TDLib to assign a local path
        val filePath = waitForPath()
        if (filePath == null) {
            Log.e(TAG, "Timeout waiting for TDLib local path")
            return newFixedLengthResponse(
                Response.Status.SERVICE_UNAVAILABLE, "text/plain",
                "TDLib hasn't started downloading yet"
            )
        }

        val file = File(filePath)
        val state = engine.getFileStateFlow(fileId).value
        val actualFileSize = if (state != null && state.expectedSize > 0) state.expectedSize else fileSize

        // Parse the Range header: "bytes=start-end" (same as original)
        val rangeHeader = session.headers["range"] ?: "bytes=0-"
        val (start, endRequested) = parseRange(rangeHeader)
        val end = if (endRequested < 0) actualFileSize - 1 else minOf(endRequested, actualFileSize - 1)
        val chunkSize = (end - start + 1).toInt().coerceAtMost(CHUNK_SIZE)

        Log.d(TAG, "Range: $start-$end, chunkSize=$chunkSize, actualFileSize=$actualFileSize")

        // Hint TDLib to prioritise this offset
        engine.hintDownloadOffset(fileId, start)

        // Wait for the needed bytes to be on disk
        val neededBytes = start + chunkSize
        waitForBytes(file, neededBytes)

        // Read the chunk from the local file
        val bytes = readChunk(file, start, chunkSize)
        if (bytes == null || bytes.isEmpty()) {
            Log.e(TAG, "Failed to read chunk at offset $start")
            return newFixedLengthResponse(
                Response.Status.INTERNAL_ERROR, "text/plain", "Failed to read bytes"
            )
        }

        val actualEnd = start + bytes.size - 1
        Log.d(TAG, "Serving ${bytes.size} bytes ($start-$actualEnd/$actualFileSize)")

        val response = newFixedLengthResponse(
            Response.Status.PARTIAL_CONTENT,
            mimeType,
            bytes.inputStream(),
            bytes.size.toLong()
        )
        response.addHeader("Content-Range", "bytes $start-$actualEnd/$actualFileSize")
        response.addHeader("Accept-Ranges", "bytes")
        response.addHeader("Content-Length", bytes.size.toString())
        return response
    }

    private fun readChunk(file: File, offset: Long, size: Int): ByteArray? {
        return try {
            val fis = FileInputStream(file)
            fis.skip(offset)
            val buf = ByteArray(size)
            val read = fis.read(buf)
            fis.close()
            if (read <= 0) null
            else if (read < size) buf.copyOf(read)
            else buf
        } catch (e: Exception) {
            Log.e(TAG, "readChunk error: ${e.message}")
            null
        }
    }

    /** Block until TDLib assigns a local path (up to 25s) */
    private fun waitForPath(): String? {
        val deadline = System.currentTimeMillis() + 25_000L
        while (System.currentTimeMillis() < deadline) {
            localPath?.let { return it }
            Thread.sleep(100)
        }
        return null
    }

    /** Block until TDLib guarantees the needed bytes are downloaded linearly from the start */
    private fun waitForBytes(file: File, neededBytes: Long) {
        val deadline = System.currentTimeMillis() + 60_000L
        while (System.currentTimeMillis() < deadline) {
            val state = engine.getFileStateFlow(fileId).value
            val isReady = state != null && (state.isCompleted || state.downloadedPrefixSize >= neededBytes)
            
            // If the chunk is fully linearly downloaded, or the file completed
            if (isReady && file.exists()) {
                return
            }
            
            // Also accept if expected size is small and it's already fully downloaded via downloadedSize
            if (state != null && state.expectedSize > 0 && state.downloadedSize >= state.expectedSize) {
                return
            }

            Thread.sleep(100)
        }
        val finalState = engine.getFileStateFlow(fileId).value
        Log.w(TAG, "Timeout waiting for $neededBytes bytes. State: $finalState")
    }

    private fun parseRange(rangeHeader: String): Pair<Long, Long> {
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader)
        val start = match?.groupValues?.get(1)?.toLongOrNull() ?: 0L
        val end = match?.groupValues?.get(2)?.toLongOrNull() ?: -1L
        return Pair(start, end)
    }
}
