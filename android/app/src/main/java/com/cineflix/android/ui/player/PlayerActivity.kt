package com.cineflix.android.ui.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.*

/**
 * Cineflix ExoPlayer fullscreen activity.
 * Launched by AndroidBridge.playVideo with a local HTTP stream URL
 * served by StreamProxyServer.
 *
 * COPIED from original Cineflix Android PlayerActivity.kt
 */
class PlayerActivity : Activity() {

    private var player: ExoPlayer? = null
    private var proxyServer: StreamProxyServer? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    companion object {
        const val EXTRA_FILE_ID   = "file_id"
        const val EXTRA_FILE_SIZE = "file_size"
        const val EXTRA_MIME_TYPE = "mime_type"
        const val EXTRA_TITLE     = "title"
        const val EXTRA_CHAT_ID   = "chat_id"
        const val EXTRA_MSG_ID    = "msg_id"

        private const val TAG = "PlayerActivity"

        fun start(
            context: Context,
            fileId: Int,
            chatId: Long,
            msgId: Long,
            fileSize: Long   = 0L,
            mimeType: String = "video/mp4",
            title: String,
        ) {
            context.startActivity(Intent(context, PlayerActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(EXTRA_FILE_ID,   fileId)
                putExtra(EXTRA_CHAT_ID,   chatId)
                putExtra(EXTRA_MSG_ID,    msgId)
                putExtra(EXTRA_FILE_SIZE, fileSize)
                putExtra(EXTRA_MIME_TYPE, mimeType)
                putExtra(EXTRA_TITLE,     title)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen immersive (exact copy from original)
        window.decorView.systemUiVisibility = (
            android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
            or android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )

        val fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val engine   = TelegramEngine.getInstance(this)

        Log.i(TAG, "▶ onCreate — fileId=$fileId fileSize=$fileSize mimeType=$mimeType title=$title")

        if (fileId <= 0) {
            Log.e(TAG, "INVALID fileId=$fileId — aborting")
            Toast.makeText(this, "Error: fileId inválido ($fileId)", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        // If fileSize is 0, try to get it from TDLib cache
        var effectiveFileSize = fileSize
        if (effectiveFileSize <= 0) {
            // Look up from fileIdCache
            for ((_, pair) in engine.fileIdCache) {
                if (pair.first == fileId) {
                    Log.w(TAG, "fileSize was 0, found fileId=$fileId in cache but no size info available")
                    break
                }
            }
            // Use a large default so Range headers work
            effectiveFileSize = 2_000_000_000L // 2 GB default
            Log.w(TAG, "Using default fileSize=$effectiveFileSize")
        }

        // 1. Start StreamProxyServer (NanoHTTPD on free port — same as original)
        val proxy = StreamProxyServer(
            engine   = engine,
            fileId   = fileId,
            fileSize = effectiveFileSize,
            mimeType = mimeType,
        )
        proxy.start()
        proxyServer = proxy
        val port = proxy.listeningPort
        Log.i(TAG, "▶ StreamProxyServer started on port $port")

        // 2. Start TDLib download in background
        scope.launch {
            try {
                Log.i(TAG, "▶ Requesting TDLib download for fileId=$fileId...")
                val path = engine.startDownloadReturnPath(fileId, priority = 32)
                if (path != null) {
                    proxy.localPath = path
                    Log.i(TAG, "▶ TDLib local path SET: $path")
                } else {
                    Log.e(TAG, "▶ TDLib returned NULL path for fileId=$fileId")
                }
            } catch (e: Exception) {
                Log.e(TAG, "▶ TDLib download error: ${e.message}", e)
            }
        }

        // 3. Setup ExoPlayer with larger timeouts for TDLib buffering
        val streamUrl = "http://127.0.0.1:$port/stream"
        Log.i(TAG, "▶ ExoPlayer stream URL: $streamUrl")

        val playerView = PlayerView(this)
        playerView.useController = true
        setContentView(playerView)

        val dataSourceFactory = androidx.media3.datasource.DefaultHttpDataSource.Factory()
            .setConnectTimeoutMs(15000)
            .setReadTimeoutMs(15000)
            .setAllowCrossProtocolRedirects(true)

        val mediaSourceFactory = androidx.media3.exoplayer.source.DefaultMediaSourceFactory(dataSourceFactory)

        val exo = ExoPlayer.Builder(this)
            .setMediaSourceFactory(mediaSourceFactory)
            .build()
            
        playerView.player = exo
        player = exo

        val mediaItem = MediaItem.fromUri(Uri.parse(streamUrl))
        exo.setMediaItem(mediaItem)
        exo.prepare()
        exo.playWhenReady = true

        exo.addListener(object : Player.Listener {
            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                Log.e(TAG, "ExoPlayer error: ${error.errorCodeName} — ${error.message}", error)
                Toast.makeText(
                    this@PlayerActivity,
                    "Error de reproducción: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        })
    }

    override fun onStop() {
        super.onStop()
        cleanup()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        cleanup()
        finish()
    }

    private fun cleanup() {
        try { player?.release() } catch (_: Exception) {}
        try { proxyServer?.stop() } catch (_: Exception) {}
        scope.cancel()
    }
}
