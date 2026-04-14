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

        // Wait for TDLib to assign a local path and know the file size
        val filePath = waitForPath()
        if (filePath == null) {
            return newFixedLengthResponse(Response.Status.SERVICE_UNAVAILABLE, "text/plain", "Timeout waiting for path")
        }

        // Wait to know the ACTUAL file size, otherwise ExoPlayer seeks into the void!
        var actualFileSize = waitForFileSize()
        if (actualFileSize <= 0) {
            actualFileSize = fileSize // fallback to Intent extra if it really failed
        }

        val file = File(filePath)

        // Parse the Range header: "bytes=start-end"
        val rangeHeader = session.headers["range"] ?: "bytes=0-"
        val (start, endRequested) = parseRange(rangeHeader)
        val end = if (endRequested < 0 || endRequested >= actualFileSize) actualFileSize - 1 else endRequested
        val length = end - start + 1

        Log.d(TAG, "Range: $start-$end, length=$length, actualFileSize=$actualFileSize")

        // Hint TDLib to prioritise this offset
        engine.hintDownloadOffset(fileId, start)

        val inputStream = BlockingProxyInputStream(engine, fileId, file, start, length)

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

    /** Block until TDLib assigns a local path (up to 25s) */
    private fun waitForPath(): String? {
        val deadline = System.currentTimeMillis() + 25_000L
        while (System.currentTimeMillis() < deadline) {
            localPath?.let { return it }
            Thread.sleep(100)
        }
        return null
    }

    /** Block until TDLib tells us the actual expected file size */
    private fun waitForFileSize(): Long {
        val deadline = System.currentTimeMillis() + 10_000L
        while (System.currentTimeMillis() < deadline) {
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.expectedSize > 0) {
                return state.expectedSize
            }
            Thread.sleep(100)
        }
        return 0L
    }

    private fun parseRange(rangeHeader: String): Pair<Long, Long> {
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader)
        val start = match?.groupValues?.get(1)?.toLongOrNull() ?: 0L
        val end = match?.groupValues?.get(2)?.toLongOrNull() ?: -1L
        return Pair(start, end)
    }

    /**
     * InputStream that blocks when TDLib hasn't downloaded the requested bytes yet.
     * Prevents NanoHTTPD from closing the connection prematurely, keeping ExoPlayer's buffer fed.
     */
    private class BlockingProxyInputStream(
        private val engine: TelegramEngine,
        private val fileId: Int,
        private val file: File,
        private val startOffset: Long,
        private val lengthRequested: Long,
    ) : InputStream() {
        private var currentPosition = startOffset
        private val endPosition = startOffset + lengthRequested
        private var fis: FileInputStream? = null

        init {
            openStream()
        }

        private fun openStream() {
            fis = FileInputStream(file)
            fis?.skip(currentPosition)
        }

        override fun read(): Int {
            val b = ByteArray(1)
            val read = read(b, 0, 1)
            if (read == -1) return -1
            return b[0].toInt() and 0xFF
        }

        override fun read(b: ByteArray, off: Int, len: Int): Int {
            if (currentPosition >= endPosition) return -1 // Reached the requested end

            val maxAvailableToReadRequest = minOf(len.toLong(), endPosition - currentPosition).toInt()

            // Wait until at least 1 byte is available
            while (true) {
                val state = engine.getFileStateFlow(fileId).value
                if (state == null) {
                    Thread.sleep(100)
                    continue
                }
                
                val availableOnDisk = state.downloadedPrefixSize - currentPosition
                if (availableOnDisk > 0 || state.isCompleted) {
                    break
                }
                
                Thread.sleep(100)
                // Persistently hint TDLib to continue downloading this chunk
                engine.hintDownloadOffset(fileId, currentPosition)
            }

            val state = engine.getFileStateFlow(fileId).value ?: return -1
            val availableOnDisk = state.downloadedPrefixSize - currentPosition
            val toRead = if (state.isCompleted) {
                maxAvailableToReadRequest
            } else {
                minOf(maxAvailableToReadRequest.toLong(), availableOnDisk).toInt()
            }

            if (toRead <= 0) {
                return -1
            }

            var actuallyRead = fis?.read(b, off, toRead) ?: -1
            if (actuallyRead == -1) {
                // If stream was closed or EOF prematurely, reopen and try again
                fis?.close()
                openStream()
                actuallyRead = fis?.read(b, off, toRead) ?: -1
            }
            
            if (actuallyRead != -1) {
                currentPosition += actuallyRead
            }
            
            return actuallyRead
        }

        override fun close() {
            super.close()
            fis?.close()
        }
    }
}
