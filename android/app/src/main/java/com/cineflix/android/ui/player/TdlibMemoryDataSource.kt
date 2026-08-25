package com.cineflix.android.ui.player

import android.net.Uri
import android.util.Log
import androidx.media3.common.DataReader
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSpec
import androidx.media3.datasource.HttpDataSource
import com.cineflix.android.TelegramEngine
import java.io.IOException
import kotlin.math.min

class TdlibMemoryDataSource(
    private val engine: TelegramEngine
) : BaseDataSource(true) {

    companion object {
        private const val TAG = "TdlibMemoryDataSource"
        private const val ALIGNMENT = 131072L
        private const val CHUNK_SIZE = 131072L // 128 KB
    }

    private var fileId: Int = 0
    private var dataSpec: DataSpec? = null
    private var opened = false
    
    private var bytesRemaining: Long = 0
    private var currentOffset: Long = 0
    private var bytesSinceLastClear: Long = 0
    
    private var ramBuffer: ByteArray? = null
    private var ramBufferOffset: Long = -1L

    override fun open(dataSpec: DataSpec): Long {
        try {
            val uri = dataSpec.uri
            val host = uri.host
            
            // Expected URI format: tdlib://{fileId}
            val parsedFileId = host?.toIntOrNull()
            if (parsedFileId == null) {
                throw HttpDataSource.HttpDataSourceException("Invalid File ID in URI: $uri", dataSpec, 400, 1)
            }
            this.fileId = parsedFileId
            this.dataSpec = dataSpec
            this.currentOffset = dataSpec.position

            // Wait for file state to get the total size (same logic as resolveFileSize in StreamProxyServer)
            var expectedSize = -1L
            val deadline = System.currentTimeMillis() + 10_000L
            while (System.currentTimeMillis() < deadline) {
                val state = engine.getFileStateFlow(fileId).value
                if (state != null && state.expectedSize > 0) {
                    expectedSize = state.expectedSize.toLong()
                    break
                }
                Thread.sleep(100)
            }

            var sizeToRead = -1L
            if (dataSpec.length != -1L) {
                sizeToRead = dataSpec.length
            } else if (expectedSize > 0) {
                val offset = this.currentOffset
                if (expectedSize > offset) {
                    sizeToRead = expectedSize - offset
                }
            }

            this.bytesRemaining = sizeToRead
            this.opened = true
            
            transferInitializing(dataSpec)
            transferStarted(dataSpec)
            
            Log.i(TAG, "DataSource opened for File ID: $fileId at offset: $currentOffset, totalSize: $expectedSize, bytesRemaining: $bytesRemaining")
            return this.bytesRemaining
        } catch (e: Exception) {
            throw HttpDataSource.HttpDataSourceException(
                if (e is IOException) e else IOException(e),
                dataSpec,
                400,
                1
            )
        }
    }

    override fun read(buffer: ByteArray, offset: Int, readLength: Int): Int {
        if (readLength == 0) return 0

        var lengthToRead = readLength
        val remaining = this.bytesRemaining

        if (remaining == -1L || remaining != 0L) {
            if (remaining != -1L) {
                lengthToRead = min(lengthToRead.toLong(), remaining).toInt()
            }

            val currentPos = this.currentOffset

            // Check if requested data is within RAM buffer
            val currentRamBuffer = this.ramBuffer
            if (currentRamBuffer != null) {
                val bufferStart = this.ramBufferOffset
                if (currentPos >= bufferStart && currentPos < bufferStart + currentRamBuffer.size) {
                    val bytesToCopy = min(
                        lengthToRead.toLong(), 
                        (currentRamBuffer.size - (currentPos - bufferStart))
                    ).toInt()
                    
                    System.arraycopy(
                        currentRamBuffer, 
                        (currentPos - bufferStart).toInt(), 
                        buffer, 
                        offset, 
                        bytesToCopy
                    )
                    
                    this.currentOffset += bytesToCopy
                    if (this.bytesRemaining != -1L) {
                        this.bytesRemaining -= bytesToCopy
                    }
                    bytesTransferred(bytesToCopy)
                    return bytesToCopy
                }
            }

            // Align request to CHUNK_SIZE
            val alignedOffset = currentPos - (currentPos % ALIGNMENT)
            
            // Clamp chunk size if we know the expected size to avoid out-of-bounds TDLib errors
            var chunkSizeToDownload = CHUNK_SIZE
            val state = engine.getFileStateFlow(fileId).value
            if (state != null && state.expectedSize > 0) {
                val maxAvailable = state.expectedSize - alignedOffset
                if (maxAvailable > 0 && maxAvailable < CHUNK_SIZE) {
                    chunkSizeToDownload = maxAvailable
                }
            }

            if (bytesSinceLastClear >= 20L * 1024 * 1024) {
                Log.i(TAG, "Disk quota reached (20MB). Wiping TDLib cache for fileId=$fileId")
                engine.cancelAndDeleteVideoSync(fileId, 2000)
                bytesSinceLastClear = 0L
            } else if (bytesSinceLastClear % (5L * 1024 * 1024) < CHUNK_SIZE && bytesSinceLastClear > CHUNK_SIZE) {
                // Log every ~5MB to trace the memory wipe progress
                Log.d(TAG, "Cache progress: ${bytesSinceLastClear / (1024 * 1024)}MB / 20MB")
            }

            // Retry loop in case TDLib returns a transient error or takes too long
            var fetchedBytes: ByteArray? = null
            var retries = 0
            while (retries < 3) {
                fetchedBytes = engine.downloadRangeAndRead(fileId, alignedOffset, chunkSizeToDownload)
                if (fetchedBytes != null && fetchedBytes.isNotEmpty()) {
                    break
                }
                retries++
                Thread.sleep(200) // Brief pause before retry
            }
            
            if (fetchedBytes != null && fetchedBytes.isNotEmpty()) {
                ramBuffer = fetchedBytes
                ramBufferOffset = alignedOffset
                
                if (currentPos >= ramBufferOffset && currentPos < ramBufferOffset + ramBuffer!!.size) {
                    val bufferIdx = (currentPos - ramBufferOffset).toInt()
                    val available = ramBuffer!!.size - bufferIdx
                    val toRead = min(lengthToRead.toLong(), available.toLong()).toInt()
                    
                    System.arraycopy(ramBuffer!!, bufferIdx, buffer, offset, toRead)
                    this.currentOffset += toRead
                    this.bytesSinceLastClear += toRead
                    
                    if (bytesRemaining != -1L) {
                        bytesRemaining -= toRead
                    }
                    bytesTransferred(toRead)
                    return toRead
                } else {
                    throw IOException("Fetched chunk at $alignedOffset does not contain currentPos $currentPos")
                }
            } else {
                // If we didn't hit EOF but still got null, we throw an IOException
                // so ExoPlayer knows it's a network issue and can retry.
                if (state != null && state.expectedSize > 0 && currentPos >= state.expectedSize) {
                    Log.d(TAG, "EOF reached at position=$currentPos")
                    return -1
                }
                throw IOException("Failed to fetch TDLib chunk at offset=$alignedOffset (Timeout or Error)")
            }
        }
        return -1
    }

    override fun getUri(): Uri? {
        return dataSpec?.uri
    }

    override fun close() {
        if (this.opened) {
            this.opened = false
            transferEnded()
            this.dataSpec = null
            Log.i(TAG, "DataSource closed. Wiping TDLib cache for fileId=$fileId (seek or stop)")
            engine.cancelAndDeleteVideo(fileId)
        }
    }
}
