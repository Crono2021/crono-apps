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


data class PartLocation(val fileId: Int, val localOffset: Long, val bytesRemainingInPart: Long, val partSize: Long)

class TdlibMemoryDataSource(
    private val engine: TelegramEngine,
    private val fileParts: List<FilePart>? = null
) : BaseDataSource(true) {

    companion object {
        private const val TAG = "TdlibMemoryDataSource"
        private const val ALIGNMENT = 131072L
        private const val PROBE_CHUNK_SIZE = 128L * 1024L        // 128 KB for headers / small probes
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB for instant initial frame
        private const val STREAM_CHUNK_SIZE = 2L * 1024L * 1024L  // 2 MB for smooth continuous playback
    }

    private var effectiveParts: List<FilePart> = emptyList()
    private var totalSize: Long = -1L

    private var dataSpec: DataSpec? = null
    private var opened = false
    
    private var bytesRemaining: Long = 0
    private var currentOffset: Long = 0
    private var bytesSinceLastClear: Long = 0
    
    private var ramBuffer: ByteArray? = null
    private var ramBufferOffset: Long = -1L
    private var ramBufferFileId: Int = -1

    override fun open(dataSpec: DataSpec): Long {
        try {
            if (Thread.currentThread().isInterrupted) {
                throw java.io.InterruptedIOException("DataSource open interrupted")
            }
            val uri = dataSpec.uri
            val host = uri.host
            
            // Expected URI format: tdlib://{fileId}
            val parsedFileId = host?.toIntOrNull()
            
            if (fileParts != null && fileParts.isNotEmpty()) {
                effectiveParts = fileParts
                totalSize = fileParts.sumOf { it.size }
            } else {
                if (parsedFileId == null) {
                    throw HttpDataSource.HttpDataSourceException("Invalid File ID in URI: $uri", dataSpec, 400, 1)
                }
                
                var expectedSize = -1L
                val deadline = System.currentTimeMillis() + 10_000L
                while (System.currentTimeMillis() < deadline) {
                    if (Thread.currentThread().isInterrupted) {
                        throw java.io.InterruptedIOException("DataSource open wait interrupted")
                    }
                    val state = engine.getFileStateFlow(parsedFileId).value
                    if (state != null && state.expectedSize > 0) {
                        expectedSize = state.expectedSize.toLong()
                        break
                    }
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        Thread.currentThread().interrupt()
                        throw java.io.InterruptedIOException("DataSource open sleep interrupted")
                    }
                }
                
                if (expectedSize > 0) {
                    effectiveParts = listOf(FilePart(parsedFileId, expectedSize))
                    totalSize = expectedSize
                } else {
                    effectiveParts = listOf(FilePart(parsedFileId, Long.MAX_VALUE))
                    totalSize = -1L
                }
            }

            this.dataSpec = dataSpec
            this.currentOffset = dataSpec.position

            var sizeToRead = -1L
            if (dataSpec.length != -1L) {
                sizeToRead = dataSpec.length
            } else if (totalSize > 0) {
                if (totalSize > this.currentOffset) {
                    sizeToRead = totalSize - this.currentOffset
                }
            } else if (dataSpec.length == -1L && totalSize == -1L) {
                sizeToRead = -1L // Unknown length
            }

            if (totalSize > 0 && this.currentOffset > totalSize) {
                throw HttpDataSource.HttpDataSourceException("Position out of range", dataSpec, 416, 1)
            }

            this.bytesRemaining = sizeToRead
            this.opened = true
            
            transferInitializing(dataSpec)
            transferStarted(dataSpec)
            
            Log.i(TAG, "DataSource opened. position=${dataSpec.position}, totalSize=$totalSize, parts=$effectiveParts, bytesRemaining=$bytesRemaining")
            return this.bytesRemaining
        } catch (e: Exception) {
            if (e is IOException) throw e
            throw HttpDataSource.HttpDataSourceException(
                IOException(e),
                dataSpec,
                400,
                1
            )
        }
    }

    private fun getPartForOffset(globalOffset: Long): PartLocation? {
        var cumulative = 0L
        for (part in effectiveParts) {
            if (globalOffset < cumulative + part.size) {
                val localOffset = globalOffset - cumulative
                val bytesRemaining = part.size - localOffset
                return PartLocation(part.fileId, localOffset, bytesRemaining, part.size)
            }
            cumulative += part.size
        }
        return null // EOF or out of bounds
    }

    override fun read(buffer: ByteArray, offset: Int, readLength: Int): Int {
        if (readLength == 0) return 0
        if (this.bytesRemaining == 0L) return -1
        
        val currentPos = this.currentOffset
        if (totalSize > 0 && currentPos >= totalSize) {
            return -1 // EOF Reached logically across all parts
        }

        val partLoc = getPartForOffset(currentPos) ?: return -1
        
        val activeFileId = partLoc.fileId
        val localOffset = partLoc.localOffset
        val bytesUntilPartEnd = partLoc.bytesRemainingInPart
        
        var lengthToRead = readLength
        if (this.bytesRemaining != -1L) {
            lengthToRead = min(lengthToRead.toLong(), this.bytesRemaining).toInt()
        }
        
        // Truncate lengthToRead to part boundary so we don't cross parts in a single read
        if (bytesUntilPartEnd > 0) {
            lengthToRead = min(lengthToRead.toLong(), bytesUntilPartEnd).toInt()
        }

        // Check if requested data is within RAM buffer
        if (ramBuffer != null && ramBufferFileId == activeFileId) {
            val bufferStart = this.ramBufferOffset
            if (localOffset >= bufferStart && localOffset < bufferStart + ramBuffer!!.size) {
                val bytesToCopy = min(
                    lengthToRead.toLong(), 
                    (ramBuffer!!.size - (localOffset - bufferStart))
                ).toInt()
                
                System.arraycopy(
                    ramBuffer!!, 
                    (localOffset - bufferStart).toInt(), 
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

        // Determine optimal chunk size
        val desiredChunk = if (localOffset < 256L * 1024L && ramBuffer == null) {
            PROBE_CHUNK_SIZE
        } else if (ramBuffer == null) {
            FIRST_CHUNK_SIZE
        } else {
            STREAM_CHUNK_SIZE
        }

        // Align request to ALIGNMENT (128 KB boundary)
        val alignedOffset = localOffset - (localOffset % ALIGNMENT)
        val maxAvailable = partLoc.partSize - alignedOffset
        if (maxAvailable <= 0L) return -1

        val blocks = ((desiredChunk + ALIGNMENT - 1) / ALIGNMENT)
        val chunkSizeToDownload = minOf(blocks * ALIGNMENT, maxAvailable)

        // 1. Proactive background prefetch for the NEXT chunk immediately!
        val nextOffset = alignedOffset + chunkSizeToDownload
        if (desiredChunk >= FIRST_CHUNK_SIZE && nextOffset < partLoc.partSize) {
            engine.hintDownloadOffset(activeFileId, nextOffset, STREAM_CHUNK_SIZE)
        }

        // 2. Fast-path: Check if TDLib already downloaded this chunk in memory/disk cache
        var fetchedBytes: ByteArray? = engine.readFilePartSync(activeFileId, alignedOffset, chunkSizeToDownload)

        // 3. Download synchronously from Telegram CDN if not yet in cache
        if (fetchedBytes == null || fetchedBytes.isEmpty()) {
            var retries = 0
            while (retries < 5) {
                if (Thread.currentThread().isInterrupted) {
                    throw java.io.InterruptedIOException("DataSource read interrupted")
                }
                try {
                    fetchedBytes = engine.downloadRangeAndRead(activeFileId, alignedOffset, chunkSizeToDownload)
                    if (fetchedBytes != null && fetchedBytes.isNotEmpty()) {
                        break
                    }
                } catch (e: InterruptedException) {
                    Thread.currentThread().interrupt()
                    throw java.io.InterruptedIOException("DataSource read interrupted: ${e.message}")
                }
                if (Thread.currentThread().isInterrupted) {
                    throw java.io.InterruptedIOException("DataSource thread interrupted")
                }
                retries++
                try {
                    Thread.sleep(150L * retries)
                } catch (e: InterruptedException) {
                    Thread.currentThread().interrupt()
                    throw java.io.InterruptedIOException("DataSource sleep interrupted")
                }
            }
        }
        
        if (fetchedBytes != null && fetchedBytes.isNotEmpty()) {
            ramBuffer = fetchedBytes
            ramBufferOffset = alignedOffset
            ramBufferFileId = activeFileId
            
            if (localOffset >= ramBufferOffset && localOffset < ramBufferOffset + ramBuffer!!.size) {
                val bufferIdx = (localOffset - ramBufferOffset).toInt()
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
                throw IOException("Fetched chunk at $alignedOffset does not contain localOffset $localOffset")
            }
        } else {
            if (Thread.currentThread().isInterrupted) {
                throw java.io.InterruptedIOException("DataSource read interrupted after retries")
            }
            // EOF check for part
            val state = engine.getFileStateFlow(activeFileId).value
            if (state != null && state.expectedSize > 0 && localOffset >= state.expectedSize) {
                Log.d(TAG, "EOF reached at part localOffset=$localOffset")
                return -1
            }
            throw IOException("Failed to fetch TDLib chunk at offset=$alignedOffset (Timeout or Error)")
        }
    }

    override fun getUri(): Uri? {
        return dataSpec?.uri
    }

    override fun close() {
        if (this.opened) {
            this.opened = false
            transferEnded()
            this.dataSpec = null
            ramBuffer = null
            ramBufferOffset = -1L
            ramBufferFileId = -1
            Log.d(TAG, "DataSource closed safely without terminating TDLib download")
        }
    }
}
