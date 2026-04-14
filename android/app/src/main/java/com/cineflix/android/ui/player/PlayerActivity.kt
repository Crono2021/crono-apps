package com.cineflix.android.ui.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.*

/**
 * Cineflix ExoPlayer fullscreen activity.
 *
 * SAME architecture as the original Cineflix Android (Capacitor) app:
 *   1. Start StreamProxyServer (NanoHTTPD) on a free port
 *   2. Start TDLib download in background → sets localPath on server
 *   3. ExoPlayer connects to http://127.0.0.1:{port}/stream
 *   4. Server reads from TDLib local file (waits for bytes if needed)
 *   5. Streaming starts immediately, no full download required
 */
class PlayerActivity : Activity() {

    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView
    private var proxyServer: StreamProxyServer? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    companion object {
        const val EXTRA_FILE_ID   = "file_id"
        const val EXTRA_FILE_SIZE = "file_size"
        const val EXTRA_MIME_TYPE = "mime_type"
        const val EXTRA_TITLE     = "title"
        const val EXTRA_SUBTITLE  = "subtitle"
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
            subtitle: String = "",
        ) {
            context.startActivity(Intent(context, PlayerActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(EXTRA_FILE_ID,   fileId)
                putExtra(EXTRA_CHAT_ID,   chatId)
                putExtra(EXTRA_MSG_ID,    msgId)
                putExtra(EXTRA_FILE_SIZE, fileSize)
                putExtra(EXTRA_MIME_TYPE, mimeType)
                putExtra(EXTRA_TITLE,     title)
                putExtra(EXTRA_SUBTITLE,  subtitle)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen immersive
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

        if (fileId <= 0 || fileSize <= 0) {
            Log.e(TAG, "Invalid fileId=$fileId or fileSize=$fileSize")
            android.widget.Toast.makeText(this, "Error: fileId o fileSize inválidos", android.widget.Toast.LENGTH_LONG).show()
            finish()
            return
        }

        // 1. Start StreamProxyServer (same as original app)
        val proxy = StreamProxyServer(
            engine   = engine,
            fileId   = fileId,
            fileSize = fileSize,
            mimeType = mimeType,
        )
        proxy.start()
        proxyServer = proxy
        val port = proxy.listeningPort
        Log.d(TAG, "StreamProxyServer started on port $port")

        // 2. Start TDLib download in background — non-blocking
        scope.launch {
            try {
                val path = engine.startDownloadReturnPath(fileId, priority = 32)
                if (path != null) {
                    proxy.localPath = path
                    Log.d(TAG, "TDLib local path assigned: $path")
                } else {
                    Log.e(TAG, "TDLib did not return a local path")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Download error: ${e.message}")
            }
        }

        // 3. Setup ExoPlayer with the stream URL (same as original app)
        val streamUrl = "http://127.0.0.1:$port/stream"

        playerView = PlayerView(this)
        playerView.useController = true
        setContentView(playerView)

        player = ExoPlayer.Builder(this).build()
        playerView.player = player

        val mediaItem = MediaItem.fromUri(Uri.parse(streamUrl))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true

        player.addListener(object : Player.Listener {
            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                Log.e(TAG, "ExoPlayer error: ${error.message}", error)
                android.widget.Toast.makeText(
                    this@PlayerActivity,
                    "Error de reproducción: ${error.message}",
                    android.widget.Toast.LENGTH_LONG
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
        try { player.release() } catch (_: Exception) {}
        try { proxyServer?.stop() } catch (_: Exception) {}
        scope.cancel()
    }
}
