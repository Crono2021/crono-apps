package com.cineflix.android.ui.player

import android.net.Uri
import android.util.Log
import android.webkit.WebView
import androidx.media3.common.C
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSpec
import com.cineflix.android.GramJSStreamManager
import org.json.JSONObject
import java.io.IOException
import java.util.UUID
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.math.min

class GramJSMemoryDataSource(
    private val webView: WebView,
    private val playbackId: String,
    private val fileId: Int
) : BaseDataSource(true) {

    companion object {
        private const val TAG = "GramJSDataSource"
        private const val BLOCK_SIZE = 512L * 1024L // 512 KiB
        private const val TIMEOUT_MS = 10_000L // 10 seconds
    }

    private var currentPosition = 0L
    private var opened = false
    private var currentUri: Uri? = null

    override fun open(dataSpec: DataSpec): Long {
        currentUri = dataSpec.uri
        currentPosition = dataSpec.position
        opened = true
        transferInitializing(dataSpec)
        transferStarted(dataSpec)
        
        return if (dataSpec.length == C.LENGTH_UNSET.toLong()) {
            C.LENGTH_UNSET.toLong()
        } else {
            dataSpec.length
        }
    }

    override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
        if (!opened || length == 0) return 0

        val requestSize = minOf(length.toLong(), BLOCK_SIZE).toInt()

        val bytes = requestRange(currentPosition, requestSize) 
            ?: throw IOException("GramJS fetch failed or timed out for position $currentPosition")

        if (bytes.isEmpty()) {
            return C.RESULT_END_OF_INPUT
        }

        val copyLength = min(bytes.size, length)

        System.arraycopy(bytes, 0, buffer, offset, copyLength)
        currentPosition += copyLength
        bytesTransferred(copyLength)
        
        Log.d(TAG, "[ExoPlayer] read=$copyLength")

        return copyLength
    }

    override fun close() {
        opened = false
        currentUri = null
        transferEnded()
    }

    override fun getUri(): Uri? = currentUri

    private fun requestRange(start: Long, size: Int): ByteArray? {
        val requestId = UUID.randomUUID().toString()
        val latch = CountDownLatch(1)

        if (GramJSStreamManager.currentPlaybackId != playbackId) {
            Log.w(TAG, "Playback ID mismatch before request (seek/stop). current=${GramJSStreamManager.currentPlaybackId}, expected=$playbackId")
            return null
        }

        GramJSStreamManager.latches[requestId] = latch

        try {
            val js = buildFetchJavascript(requestId, playbackId, start, size)

            Log.d(TAG, "[GramJS] request $requestId start=$start size=$size")

            webView.post {
                try {
                    webView.evaluateJavascript(js, null)
                } catch (e: Exception) {
                    GramJSStreamManager.errors[requestId] = "evaluateJavascript failed: ${e.message}"
                    latch.countDown()
                }
            }

            if (!latch.await(TIMEOUT_MS, TimeUnit.MILLISECONDS)) {
                Log.e(TAG, "[GramJS] timeout for request $requestId")
                return null
            }

            if (GramJSStreamManager.currentPlaybackId != playbackId) {
                Log.w(TAG, "Playback ID mismatch after request (seek). Discarding chunk.")
                return null
            }

            GramJSStreamManager.errors.remove(requestId)?.let {
                Log.e(TAG, "[GramJS] request failed: $it")
                return null
            }

            val resultBytes = GramJSStreamManager.pendingChunks.remove(requestId)
            Log.d(TAG, "[Bridge] received $requestId bytes=${resultBytes?.size ?: 0}")
            return resultBytes

        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            return null
        } finally {
            GramJSStreamManager.pendingChunks.remove(requestId)
            GramJSStreamManager.errors.remove(requestId)
            GramJSStreamManager.latches.remove(requestId)
        }
    }

    private fun buildFetchJavascript(
        requestId: String,
        playbackId: String,
        start: Long,
        size: Int
    ): String {
        val requestJson = JSONObject.quote(requestId)
        val playbackJson = JSONObject.quote(playbackId)

        return """
            window.fetchGramJSBlock(
                $requestJson,
                $playbackJson,
                $start,
                $size
            );
        """.trimIndent()
    }
}
