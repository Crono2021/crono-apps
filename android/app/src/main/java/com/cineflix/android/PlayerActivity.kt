package com.cineflix.android

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

/**
 * Cineflix ExoPlayer fullscreen activity.
 * Launched by ExoPlayerPlugin with a local HTTP stream URL
 * served by StreamProxyServer.
 */
class PlayerActivity : Activity() {

    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView

    companion object {
        const val EXTRA_STREAM_URL = "stream_url"
        const val EXTRA_TITLE = "title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen immersive layout
        window.decorView.systemUiVisibility = (
            android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
            or android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )

        val streamUrl = intent.getStringExtra(EXTRA_STREAM_URL) ?: run { finish(); return }

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
        player.release()
    }

    override fun onBackPressed() {
        player.release()
        finish()
    }
}
