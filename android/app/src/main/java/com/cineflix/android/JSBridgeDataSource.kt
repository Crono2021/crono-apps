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

    // Native Memory Buffer for Extreme Network Efficiency
    private var bufferCache: ByteArray? = null
    private var bufferCacheStart: Long = -1L

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

        // 1. FAST PATH: Satisfy ExoPlayer read entirely or partially directly from our Native RAM Cache!
        if (bufferCache != null && currentPosition >= bufferCacheStart && currentPosition < bufferCacheStart + bufferCache!!.size) {
            val positionInCache = (currentPosition - bufferCacheStart).toInt()
            val availableInCache = bufferCache!!.size - positionInCache
            
            // Serve instantly from RAM (avoids JavaScript Capacitor Bridge latency entirely)
            val actualRead = minOf(length, availableInCache, bytesRemaining.toInt())
            System.arraycopy(bufferCache!!, positionInCache, buffer, offset, actualRead)
            
            currentPosition += actualRead
            bytesRemaining -= actualRead
            return actualRead
        }

        // 2. CACHE MISS: Fetch a stable chunk (128KB) from Telegram to populate the cache
        // ExoPlayer requests 8KB, but we steal 128KB in one go to prevent network thrashing, keeping it under Capacitor's JSON bridge stress limits
        val prefetchSize = minOf(bytesRemaining, 128L * 1024L).toInt()

        val requestId = "$streamId-$currentPosition-${System.currentTimeMillis()}"
        val holder = ChunkHolder()
        pendingChunks[requestId] = holder

        // Ask JavaScript for bytes asynchronously
        onRangeRequest(requestId, currentPosition, prefetchSize)

        // Block ExoPlayer's loader thread until JS delivers the big chunk
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

        // Save the newly fetched big block entirely into the Native RAM Cache
        bufferCache = chunk
        bufferCacheStart = currentPosition

        // 3. Serve literally just what ExoPlayer wants right now out of this new cache
        val actualRead = minOf(length, chunk.size, bytesRemaining.toInt())
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
