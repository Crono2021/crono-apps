package com.cineflix.android

import fi.iki.elonen.NanoHTTPD
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * StreamProxyServer — NanoHTTPD-based local HTTP server that proxies
 * Telegram byte-range requests between ExoPlayer and the JS GramJS client.
 *
 * Flow:
 *   ExoPlayer → HTTP GET /stream/{streamId} (with Range header)
 *               → onRangeRequest() lambda called → notifies JS
 *               → JS calls replyRange() → deliverChunk() called
 *               → HTTP 206 response returned to ExoPlayer
 */
class StreamProxyServer(
    private val streamId: String,
    private val fileSize: Long,
    private val mimeType: String,
    private val onRangeRequest: (requestId: String, start: Long, size: Int) -> Unit
) : NanoHTTPD(0) { // Port 0 = OS assigns a free port

    // Pending requests: requestId → CountDownLatch + result holder
    private val pendingChunks = ConcurrentHashMap<String, ChunkHolder>()

    data class ChunkHolder(
        val latch: CountDownLatch = CountDownLatch(1),
        var data: ByteArray? = null,
        var error: String? = null
    )

    /**
     * Called by ExoPlayer's HTTP client when it needs bytes.
     */
    override fun serve(session: IHTTPSession): Response {
        val path = session.uri
        if (!path.contains("stream/")) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Not found")
        }

        // Parse the Range header: "bytes=start-end"
        val rangeHeader = session.headers["range"] ?: "bytes=0-"
        val (start, endRequested) = parseRange(rangeHeader)
        val end = if (endRequested < 0) fileSize - 1 else minOf(endRequested, fileSize - 1)
        val chunkSize = (end - start + 1).toInt().coerceAtMost(64 * 1024) // 64KB per bridge call

        // Ask JS for the bytes
        val requestId = "$streamId-$start-${System.currentTimeMillis()}"
        val holder = ChunkHolder()
        pendingChunks[requestId] = holder

        onRangeRequest(requestId, start, chunkSize)

        // Wait up to 30s for JS to deliver the chunk
        val gotData = holder.latch.await(30, TimeUnit.SECONDS)

        pendingChunks.remove(requestId)

        if (!gotData || holder.error != null || holder.data == null) {
            return newFixedLengthResponse(
                Response.Status.INTERNAL_ERROR, "text/plain",
                holder.error ?: "Timeout waiting for data"
            )
        }

        val bytes = holder.data!!
        val actualEnd = start + bytes.size - 1

        val response = newFixedLengthResponse(
            Response.Status.PARTIAL_CONTENT,
            mimeType,
            bytes.inputStream(),
            bytes.size.toLong()
        )
        response.addHeader("Content-Range", "bytes $start-$actualEnd/$fileSize")
        response.addHeader("Accept-Ranges", "bytes")
        response.addHeader("Content-Length", bytes.size.toString())
        return response
    }

    /**
     * Called by ExoPlayerPlugin when JS delivers the bytes for a requestId.
     * Returns true if the requestId was found (and delivered), false otherwise.
     */
    fun deliverChunk(requestId: String, data: ByteArray): Boolean {
        val holder = pendingChunks[requestId] ?: return false
        holder.data = data
        holder.latch.countDown()
        return true
    }

    private fun parseRange(rangeHeader: String): Pair<Long, Long> {
        val match = Regex("bytes=(\\d+)-(\\d*)").find(rangeHeader)
        val start = match?.groupValues?.get(1)?.toLongOrNull() ?: 0L
        val end = match?.groupValues?.get(2)?.toLongOrNull() ?: -1L
        return Pair(start, end)
    }
}
