package com.cineflix.android

import android.app.Dialog
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

/**
 * ExoPlayerPlugin — Lanza el reproductor apuntando al LocalStreamProxy (TDLib).
 */
@CapacitorPlugin(name = "ExoPlayer")
class ExoPlayerPlugin : Plugin() {

    companion object {
        private const val TAG = "ExoPlayerPlugin"
    }

    private var playerDialog: Dialog? = null
    private var exoPlayer: ExoPlayer? = null

    @PluginMethod
    fun play(call: PluginCall) {
        val streamUrl = call.getString("url")
        if (streamUrl.isNullOrEmpty()) {
            call.reject("url is required")
            return
        }

        Log.i(TAG, "▶️ Lanzando ExoPlayer → $streamUrl")

        activity.runOnUiThread {
            showPlayerOverlay(streamUrl)
            call.resolve()
        }
    }

    private fun showPlayerOverlay(streamUrl: String) {
        exoPlayer?.release()
        playerDialog?.dismiss()

        playerDialog = Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        playerDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val playerView = PlayerView(activity)
        playerDialog?.setContentView(playerView, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))

        // Timeout alto porque TDLib puede tardar en descargar la primera parte (especialmente 4K)
        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(30_000)   // 30s to connect to local proxy
            .setReadTimeoutMs(120_000)     // 120s read — TDLib may take time to deliver first bytes
            .setDefaultRequestProperties(mapOf("Cache-Control" to "no-cache"))

        val mediaItem = MediaItem.fromUri(streamUrl)
        // Usamos Progressive porque los archivos de Telegram son webm, mp4 o mkv, no HLS (M3U8).
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mediaItem)

        exoPlayer = ExoPlayer.Builder(activity)
            .setHandleAudioBecomingNoisy(true)
            .build()
        playerView.player = exoPlayer

        exoPlayer?.addListener(object : Player.Listener {
            override fun onPlayerError(error: PlaybackException) {
                Log.e(TAG, "❌ ExoPlayer error: ${error.errorCodeName} - ${error.message}")
                activity.runOnUiThread {
                    android.widget.Toast.makeText(
                        context,
                        "Error ${error.errorCodeName}: ${error.message}",
                        android.widget.Toast.LENGTH_LONG
                    ).show()
                }
            }
        })

        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.prepare()
        exoPlayer?.playWhenReady = true

        playerDialog?.setOnDismissListener {
            exoPlayer?.release()
            exoPlayer = null
        }

        playerDialog?.show()
    }

    override fun handleOnDestroy() {
        exoPlayer?.release()
        playerDialog?.dismiss()
        super.handleOnDestroy()
    }
}
