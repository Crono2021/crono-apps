package com.cineflix.android

import android.net.Uri
import androidx.media3.common.C
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.TransferListener
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.io.IOException

class JSBridgeDataSource(
    private val streamId: String,
    private val fileSize: Long,
    private val onRangeRequest: (requestId: String, start: Long, size: Int) -> Unit
) : DataSource {

    private var uri: Uri? = null
    private var bytesRemaining: Long = 0
    private var currentPosition: Long = 0
    private var opened = false

    // Pending requests: requestId → CountDownLatch + result holder
    val pendingChunks = ConcurrentHashMap<String, ChunkHolder>()

    data class ChunkHolder(
        val latch: CountDownLatch = CountDownLatch(1),
        var data: ByteArray? = null,
        var error: String? = null
    )

    override fun addTransferListener(transferListener: TransferListener) {
        // No-op for now
    }

    @Throws(IOException::class)
    override fun open(dataSpec: DataSpec): Long {
        uri = dataSpec.uri
        currentPosition = dataSpec.position
        
        // Calculate remaining bytes based on the exact file size known natively
        bytesRemaining = if (dataSpec.length != C.LENGTH_UNSET.toLong()) {
            dataSpec.length
        } else {
            fileSize - currentPosition
        }
        
        opened = true
        return bytesRemaining
    }

    @Throws(IOException::class)
    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (length == 0) return 0
        if (bytesRemaining == 0L) return C.RESULT_END_OF_INPUT

        // Coerce the read length to at most 128KB per JS bridge call for extreme stability and speed
        val bytesToRead = minOf(length.toLong(), bytesRemaining, 128L * 1024L).toInt()

        val requestId = "$streamId-$currentPosition-${System.currentTimeMillis()}"
        val holder = ChunkHolder()
        pendingChunks[requestId] = holder

        // Ask JavaScript for bytes asynchronously
        onRangeRequest(requestId, currentPosition, bytesToRead)

        // Block ExoPlayer's loader thread until JS delivers the chunk
        val gotData = holder.latch.await(30, TimeUnit.SECONDS)
        pendingChunks.remove(requestId)

        if (!gotData) {
            throw IOException("Timeout esperando bloques de Javascript (posible suspensión en segundo plano o desconexión)")
        }

        if (holder.error != null) {
            throw IOException("Javascript error: ${holder.error}")
        }

        val chunk = holder.data ?: return C.RESULT_END_OF_INPUT

        if (chunk.isEmpty()) {
            return C.RESULT_END_OF_INPUT
        }

        // Copy received JS chunk into ExoPlayer's native memory buffer
        val actualRead = minOf(chunk.size, buffer.size - offset)
        System.arraycopy(chunk, 0, buffer, offset, actualRead)

        currentPosition += actualRead
        bytesRemaining -= actualRead

        return actualRead
    }

    override fun getUri(): Uri? = uri

    override fun close() {
        opened = false
        pendingChunks.clear()
    }

    fun deliverChunk(requestId: String, data: ByteArray): Boolean {
        val holder = pendingChunks[requestId] ?: return false
        holder.data = data
        holder.latch.countDown()
        return true
    }
}
