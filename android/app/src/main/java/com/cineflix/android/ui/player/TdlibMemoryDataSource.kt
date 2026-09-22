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
        private const val STREAM_CHUNK_SIZE = 1024L * 1024L      // 1 MB for smooth continuous playback without CPU/IO spikes
        private const val PREFETCH_WINDOW = 32L * 1024L * 1024L  // 32 MB sliding window ahead
        private const val ROLLING_QUOTA_BYTES = 200L * 1024L * 1024L // 200 MB rolling window
    }

    private var effectiveParts: List<FilePart> = emptyList()
    private var totalSize: Long = -1L

    private var dataSpec: DataSpec? = null
    private var opened = false
    
    private var bytesRemaining: Long = 0
    private var currentOffset: Long = 0
    private var bytesSinceLastClear: Long = 0

    // Dual-chunk RAM cache (Current + Previous to absorb demux back-seeks)
    private var currBuffer: ByteArray? = null
    private var currBufferOffset: Long = -1L
    private var currBufferFileId: Int = -1

    private var prevBuffer: ByteArray? = null
    private var prevBufferOffset: Long = -1L
    private var prevBufferFileId: Int = -1

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

    private fun checkRollingQuota(activeFileId: Int) {
        if (this.bytesSinceLastClear >= ROLLING_QUOTA_BYTES) {
            this.bytesSinceLastClear = 0L
            Log.i(TAG, "🧹 ROLLING GC TRIGGERED (200MB): Optimizing TDLib disk cache for fileId=$activeFileId")
            com.cineflix.android.util.ErrorLogCollector.log(TAG, "🧹 ROLLING GC (200MB): Calling optimizeStorage(30MB, immunity=120s) for fileId=$activeFileId")
            try {
                engine.optimizeStorage(30L * 1024L * 1024L, immunityDelaySec = 120)
            } catch (e: Exception) {
                Log.w(TAG, "Error in checkRollingQuota: ${e.message}")
            }
        }
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

        // 1. Fast path: check current RAM buffer
        val cb = currBuffer
        if (cb != null && currBufferFileId == activeFileId &&
            localOffset >= currBufferOffset && localOffset < currBufferOffset + cb.size
        ) {
            val bufferIdx = (localOffset - currBufferOffset).toInt()
            val available = cb.size - bufferIdx
            val toRead = min(lengthToRead.toLong(), available.toLong()).toInt()

            System.arraycopy(cb, bufferIdx, buffer, offset, toRead)
            this.currentOffset += toRead
            this.bytesSinceLastClear += toRead
            checkRollingQuota(activeFileId)

            if (this.bytesRemaining != -1L) {
                this.bytesRemaining -= toRead
            }
            bytesTransferred(toRead)
            return toRead
        }

        // 2. Backward seek check: check previous RAM buffer (handles demuxer interleaved packet reads)
        val pb = prevBuffer
        if (pb != null && prevBufferFileId == activeFileId &&
            localOffset >= prevBufferOffset && localOffset < prevBufferOffset + pb.size
        ) {
            val bufferIdx = (localOffset - prevBufferOffset).toInt()
            val available = pb.size - bufferIdx
            val toRead = min(lengthToRead.toLong(), available.toLong()).toInt()

            System.arraycopy(pb, bufferIdx, buffer, offset, toRead)
            this.currentOffset += toRead
            this.bytesSinceLastClear += toRead
            checkRollingQuota(activeFileId)

            if (this.bytesRemaining != -1L) {
                this.bytesRemaining -= toRead
            }
            bytesTransferred(toRead)
            return toRead
        }

        // 3. Cache miss: determine chunk size
        val desiredChunk = if (localOffset < 256L * 1024L && currBuffer == null) {
            PROBE_CHUNK_SIZE
        } else if (currBuffer == null) {
            FIRST_CHUNK_SIZE
        } else {
            STREAM_CHUNK_SIZE
        }

        val alignedOffset = localOffset - (localOffset % ALIGNMENT)
        val maxAvailable = partLoc.partSize - alignedOffset
        if (maxAvailable <= 0L) return -1

        val blocks = ((desiredChunk + ALIGNMENT - 1) / ALIGNMENT)
        val chunkSizeToDownload = minOf(blocks * ALIGNMENT, maxAvailable)

        // 4. Fast-path: check if TDLib has this chunk in disk/cache (e.g. from background prefetch!)
        var fetchedBytes: ByteArray? = null
        val candidateSizes = listOf(chunkSizeToDownload, 512L * 1024L, 256L * 1024L)
            .filter { it <= chunkSizeToDownload && it >= ALIGNMENT }
            .distinct()

        for (candidate in candidateSizes) {
            fetchedBytes = engine.readFilePartSync(activeFileId, alignedOffset, candidate)
            if (fetchedBytes != null && fetchedBytes.isNotEmpty()) {
                Log.d(TAG, "⚡ Cache HIT from TDLib: offset=$alignedOffset size=${fetchedBytes.size}")
                break
            }
        }

        // 5. If not in cache, download synchronously from Telegram CDN
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
            val actualFetchedSize = fetchedBytes.size.toLong()
            // Shift current to previous to maintain 2-chunk window
            prevBuffer = currBuffer
            prevBufferOffset = currBufferOffset
            prevBufferFileId = currBufferFileId

            currBuffer = fetchedBytes
            currBufferOffset = alignedOffset
            currBufferFileId = activeFileId

            // 6. PIPELINED PREFETCH: Keep TDLib prefetching a 32MB sliding window in the background!
            val nextOffset = alignedOffset + actualFetchedSize
            if (desiredChunk >= FIRST_CHUNK_SIZE && nextOffset < partLoc.partSize) {
                val remainingInPart = partLoc.partSize - nextOffset
                val prefetchSize = minOf(PREFETCH_WINDOW, remainingInPart)
                engine.hintDownloadOffset(activeFileId, nextOffset, prefetchSize)
            }

            if (localOffset >= currBufferOffset && localOffset < currBufferOffset + currBuffer!!.size) {
                val bufferIdx = (localOffset - currBufferOffset).toInt()
                val available = currBuffer!!.size - bufferIdx
                val toRead = min(lengthToRead.toLong(), available.toLong()).toInt()

                System.arraycopy(currBuffer!!, bufferIdx, buffer, offset, toRead)
                this.currentOffset += toRead
                this.bytesSinceLastClear += toRead
                checkRollingQuota(activeFileId)

                if (this.bytesRemaining != -1L) {
                    this.bytesRemaining -= toRead
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
            val state = engine.getFileStateFlow(activeFileId).value
            if (state != null && state.expectedSize > 0 && localOffset >= state.expectedSize) {
                Log.d(TAG, "EOF reached at part localOffset=$localOffset")
                return -1
            }
            com.cineflix.android.util.ErrorLogCollector.log(TAG, "FATAL: Failed to fetch TDLib chunk at offset=$alignedOffset for fileId=$activeFileId (5 retries exhausted)")
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
            currBuffer = null
            currBufferOffset = -1L
            currBufferFileId = -1
            prevBuffer = null
            prevBufferOffset = -1L
            prevBufferFileId = -1
            Log.d(TAG, "DataSource closed safely without terminating TDLib download")
        }
    }
}
