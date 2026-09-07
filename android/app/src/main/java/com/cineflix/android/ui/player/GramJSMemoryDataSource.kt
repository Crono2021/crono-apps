package com.cineflix.android.ui.player

import android.net.Uri
import android.util.Log
import android.webkit.WebView
import androidx.media3.common.C
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSpec
import com.cineflix.android.GramJSStreamManager
import com.cineflix.android.PendingGramJSRequest
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.IOException
import java.util.UUID
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock
import kotlin.math.min

data class CachedChunk(
    val virtualOffset: Long,
    val data: ByteArray,
    var readOffset: Int = 0
)

class GramJSMemoryDataSource(
    private val webView: WebView,
    private val playbackId: String,
    private val fileId: Int
) : BaseDataSource(true) {

    companion object {
        private const val TAG = "GramJSDataSource"
        private const val CHUNK_SIZE = 2 * 1024 * 1024
        private const val TARGET_BUFFER_BYTES = 16L * 1024 * 1024
        private const val MAX_BUFFER_BYTES = 32L * 1024 * 1024
    }

    private val lock = ReentrantLock()
    private val dataAvailable = lock.newCondition()
    
    private val chunks = mutableListOf<CachedChunk>()
    private var playbackGeneration = 0
    private var currentVirtualPosition = 0L
    private var currentBufferedBytes = 0L
    private var isClosed = false
    private var eofReached = false
    private var currentUri: Uri? = null

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var prefetchJob: Job? = null

    override fun open(dataSpec: DataSpec): Long {
        currentUri = dataSpec.uri
        
        lock.withLock {
            playbackGeneration++
            currentVirtualPosition = dataSpec.position
            chunks.clear()
            currentBufferedBytes = 0L
            isClosed = false
            eofReached = false
            dataAvailable.signalAll()
        }

        cancelAllPendingRequests(playbackGeneration - 1)
        
        transferInitializing(dataSpec)
        transferStarted(dataSpec)
        
        startPrefetchWorker(playbackGeneration)
        
        return if (dataSpec.length == C.LENGTH_UNSET.toLong()) {
            C.LENGTH_UNSET.toLong()
        } else {
            dataSpec.length
        }
    }

    private fun cancelAllPendingRequests(upToGeneration: Int) {
        val requestsToCancel = GramJSStreamManager.activeRequests
            .filterValues { it.generation <= upToGeneration }
            .keys
            
        requestsToCancel.forEach { reqId ->
            GramJSStreamManager.activeRequests.remove(reqId)?.deferred?.cancel()
            webView.post { 
                webView.evaluateJavascript("window.cancelGramJSBlock('');", null) 
            }
        }
    }

    private fun startPrefetchWorker(generation: Int) {
        prefetchJob?.cancel()
        prefetchJob = scope.launch {
            var workerFetchOffset = currentVirtualPosition
            
            while (isActive) {
                var shouldFetch = false
                
                lock.withLock {
                    if (playbackGeneration != generation || isClosed || eofReached) return@launch
                    if (currentBufferedBytes < TARGET_BUFFER_BYTES) {
                        shouldFetch = true
                    }
                }

                if (shouldFetch) {
                    val requestId = UUID.randomUUID().toString()
                    val deferred = CompletableDeferred<Result<ByteArray>>()
                    
                    GramJSStreamManager.activeRequests[requestId] = PendingGramJSRequest(
                        generation = generation,
                        virtualOffset = workerFetchOffset,
                        deferred = deferred
                    )

                    val js = buildFetchJavascript(requestId, playbackId, workerFetchOffset, CHUNK_SIZE)
                    withContext(Dispatchers.Main) {
                        webView.evaluateJavascript(js, null)
                    }

                    try {
                        val result = deferred.await()
                        
                        lock.withLock {
                            if (playbackGeneration != generation || isClosed) return@launch
                            
                            if (result.isSuccess) {
                                val bytes = result.getOrThrow()
                                
                                if (bytes.isEmpty()) {
                                    eofReached = true
                                    dataAvailable.signalAll()
                                } else {
                                    // Drop chunks that arrive too late or belong to a past offset
                                    if (workerFetchOffset >= currentVirtualPosition) {
                                        if (currentBufferedBytes + bytes.size <= MAX_BUFFER_BYTES) {
                                            chunks.add(CachedChunk(workerFetchOffset, bytes))
                                            currentBufferedBytes += bytes.size
                                            workerFetchOffset += bytes.size
                                            dataAvailable.signalAll()
                                        } else {
                                            // Edge case: memory bounded, just skip adding and wait for read
                                            Log.w(TAG, "Buffer full despite Target constraint")
                                        }
                                    } else {
                                        // Request arrived but player already seeked past it
                                        workerFetchOffset = currentVirtualPosition
                                    }
                                }
                            } else {
                                Log.e(TAG, "JS Fetch Error: " + result.exceptionOrNull()?.message)
                            }
                        }
                        if (!result.isSuccess) {
                            delay(1000)
                        }
                    } catch (e: CancellationException) {
                        break
                    } catch (e: Exception) {
                        delay(1000)
                    }
                } else {
                    delay(50) // Wait for reader to consume
                }
            }
        }
    }

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (length == 0) return 0

        lock.withLock {
            while (true) {
                if (isClosed) throw IOException("DataSource is closed")

                val chunk = chunks.firstOrNull { 
                    it.virtualOffset + it.readOffset <= currentVirtualPosition && 
                    it.virtualOffset + it.data.size > currentVirtualPosition 
                }

                if (chunk != null) {
                    val offsetInChunk = (currentVirtualPosition - chunk.virtualOffset).toInt()
                    val bytesAvailable = chunk.data.size - offsetInChunk
                    val bytesToCopy = min(length, bytesAvailable)

                    System.arraycopy(chunk.data, offsetInChunk, buffer, offset, bytesToCopy)
                    
                    currentVirtualPosition += bytesToCopy
                    chunk.readOffset = offsetInChunk + bytesToCopy

                    if (chunk.readOffset == chunk.data.size) {
                        chunks.remove(chunk)
                        currentBufferedBytes -= chunk.data.size
                    }
                    
                    bytesTransferred(bytesToCopy)
                    return bytesToCopy
                } else {
                    if (eofReached) {
                        return C.RESULT_END_OF_INPUT
                    }
                    dataAvailable.await()
                }
            }
        }
    }

    override fun close() {
        lock.withLock {
            isClosed = true
            chunks.clear()
            currentBufferedBytes = 0L
            dataAvailable.signalAll()
        }
        
        prefetchJob?.cancel()
        cancelAllPendingRequests(playbackGeneration)
        
        currentUri = null
        transferEnded()
    }

    override fun getUri(): Uri? = currentUri

    private fun buildFetchJavascript(
        requestId: String,
        playbackId: String,
        start: Long,
        size: Int
    ): String {
        val requestJson = JSONObject.quote(requestId)
        val playbackJson = JSONObject.quote(playbackId)

        return "window.fetchGramJSBlock($requestJson, $playbackJson, $start, $size);"
    }
}
