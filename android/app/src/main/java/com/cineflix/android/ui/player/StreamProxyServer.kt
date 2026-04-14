package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import fi.iki.elonen.NanoHTTPD
import kotlinx.coroutines.*
import java.io.File
import java.io.RandomAccessFile

/**
 * StreamProxyServer — NanoHTTPD-based local HTTP server that proxies
 * Telegram video bytes to ExoPlayer using Range requests.
 *
 * COPIED from the original Cineflix Android (Capacitor) app, but adapted
 * so that TDLib (native) supplies the bytes instead of JS/GramJS.
 *
 * Flow:
 *   ExoPlayer → HTTP GET /stream (with Range header)
 *               → server reads bytes from TDLib's local file path
 *               → HTTP 206 response returned to ExoPlayer
 *
 * TDLib downloads the file progressively to local storage.
 * This server reads from that file using RandomAccessFile, waiting for
 * bytes to arrive if ExoPlayer requests a range that hasn't been downloaded yet.
 */
class StreamProxyServer(
    private val engine: TelegramEngine,
    private val fileId: Int,
    val fileSize: Long,
    private val mimeType: String,
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    companion object {
        private const val TAG = "StreamProxy"
    }

    /** Set by the caller once TDLib assigns a local file path */
    @Volatile var localPath: String? = null

    override fun serve(session: IHTTPSession): Response {
        val filePath = localPath
        if (filePath == null) {
            // Wait up to 20s for TDLib to start downloading and assign a path
            val deadline = System.currentTimeMillis() + 20_000L
            var path: String? = null
            while (System.currentTimeMillis() < deadline) {
                path = localPath
                if (path != null) break
                Thread.sleep(100)
            }
            if (path == null) {
                return newFixedLengthResponse(
                    Response.Status.SERVICE_UNAVAILABLE, "text/plain",
                    "TDLib hasn't started downloading yet"
                )
            }
            return serveFile(session, path)
        }
        return serveFile(session, filePath)
    }

    private fun serveFile(session: IHTTPSession, filePath: String): Response {
        val file = File(filePath)

        // Parse Range header: "bytes=start-end"
        val rangeHeader = session.headers["range"] ?: "bytes=0-"
        val (start, endRequested) = parseRange(rangeHeader)
        val end = if (endRequested < 0) fileSize - 1 else minOf(endRequested, fileSize - 1)
        val length = end - start + 1

        Log.d(TAG, "serve Range: $start-$end (length=$length, fileSize=$fileSize)")

        // Hint TDLib to prioritise downloading from this offset
        engine.hintDownloadOffset(fileId, start)

        // Wait for the bytes to be available on disk
        waitForBytes(file, end + 1)

        // Read the bytes
        val raf = RandomAccessFile(file, "r")
        raf.seek(start)
        val bytes = ByteArray(length.toInt().coerceAtMost(2 * 1024 * 1024)) // max 2MB per request
        val actualRead = raf.read(bytes)
        raf.close()

        if (actualRead <= 0) {
            return newFixedLengthResponse(
                Response.Status.INTERNAL_ERROR, "text/plain", "Failed to read bytes"
            )
        }

        val actualEnd = start + actualRead - 1
        val response = newFixedLengthResponse(
            Response.Status.PARTIAL_CONTENT,
            mimeType,
            bytes.inputStream(),
            actualRead.toLong()
        )
        response.addHeader("Content-Range", "bytes $start-$actualEnd/$fileSize")
        response.addHeader("Accept-Ranges", "bytes")
        response.addHeader("Content-Length", actualRead.toString())
        return response
    }

    /**
     * Block until [file] has at least [neededBytes] on disk.
     */
    private fun waitForBytes(file: File, neededBytes: Long) {
        val deadline = System.currentTimeMillis() + 60_000L
        while (System.currentTimeMillis() < deadline) {
            if (file.exists() && file.length() >= neededBytes) return
            Thread.sleep(100)
        }
        Log.w(TAG, "Timeout waiting for $neededBytes bytes (have ${file.length()})")
    }

    private fun parseRange(rangeHeader: String): Pair<Long, Long> {
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader)
        val start = match?.groupValues?.get(1)?.toLongOrNull() ?: 0L
        val end = match?.groupValues?.get(2)?.toLongOrNull() ?: -1L
        return Pair(start, end)
    }
}
