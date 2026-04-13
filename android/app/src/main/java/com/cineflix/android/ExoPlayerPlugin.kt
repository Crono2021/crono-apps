package com.cineflix.android

import android.content.Intent
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import java.util.concurrent.ConcurrentHashMap

// New imports for Dialog-based overlay
import android.app.Dialog
import android.view.ViewGroup
import android.view.Window
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

/**
 * ExoPlayerPlugin — Capacitor bridge between JS and the native ExoPlayer.
 *
 * JS interface:
 *   window.Capacitor.Plugins.ExoPlayer.registerStream({ streamId, fileSize, mimeType })
 *   window.Capacitor.Plugins.ExoPlayer.play({ streamId })
 *   window.Capacitor.Plugins.ExoPlayer.replyRange({ requestId, chunk: number[] })
 *
 * Events emitted to JS:
 *   ExoPlayer:fetchRange  { requestId, streamId, start, size }
 *   ExoPlayer:playbackEnded  {}
 */
@CapacitorPlugin(name = "ExoPlayer")
class ExoPlayerPlugin : Plugin() {

    // Map of active stream sizes (since DataSources are created on-the-fly by ExoPlayer's Factory)
    private val streamSizes = ConcurrentHashMap<String, Long>()
    private val activeDataSources = ConcurrentHashMap<String, MutableList<JSBridgeDataSource>>()

    @PluginMethod
    fun registerStream(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.reject("streamId required"); return }
        
        // Resilient parsing logic against JS type bridge
        val fileSizeStr = call.getString("fileSize") 
            ?: call.getInt("fileSize")?.toString() 
            ?: call.getDouble("fileSize")?.toLong()?.toString() 
            ?: "0"
            
        val fileSize = fileSizeStr.toLongOrNull() ?: 0L

        streamSizes[streamId] = fileSize
        activeDataSources[streamId] = mutableListOf()

        call.resolve()
    }

    /**
     * Called by JS to launch ExoPlayer fullscreen with the registered stream.
     * JS: await Capacitor.Plugins.ExoPlayer.play({ streamId })
     */
    @PluginMethod
    fun play(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.reject("streamId required"); return }
        if (!streamSizes.containsKey(streamId)) {
            call.reject("Stream no registrado")
            return
        }

        activity.runOnUiThread {
            showPlayerOverlay(streamId)
            call.resolve()
        }
    }

    private var playerDialog: Dialog? = null
    private var exoPlayer: ExoPlayer? = null

    private fun showPlayerOverlay(streamId: String) {
        // Destroy previous if any
        exoPlayer?.release()
        playerDialog?.dismiss()

        // Create a fullscreen dialog
        playerDialog = Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        playerDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        // Initialize PlayerView
        val playerView = PlayerView(activity)
        playerDialog?.setContentView(playerView, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))

        // Build and bind ExoPlayer
        exoPlayer = ExoPlayer.Builder(activity).build()
        playerView.player = exoPlayer

        // Handle errors with detailed codes exactly as before
        exoPlayer?.addListener(object : androidx.media3.common.Player.Listener {
            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                android.widget.Toast.makeText(
                    context,
                    "Error: ${error.errorCodeName} - ${error.message}",
                    android.widget.Toast.LENGTH_LONG
                ).show()
            }
        })

        // Define the Custom Native JS Bridge Factory
        val factory = androidx.media3.datasource.DataSource.Factory {
            val fileSize = streamSizes[streamId] ?: 0L
            val ds = JSBridgeDataSource(streamId, fileSize) { requestId, start, size ->
                val eventData = JSObject().apply {
                    put("requestId", requestId)
                    put("streamId", streamId)
                    put("start", start)
                    put("size", size)
                }
                notifyListeners("fetchRange", eventData)
            }
            activeDataSources[streamId]?.add(ds)
            ds
        }

        // Bridge directly using ProgressiveMediaSource (completely bypasses HTTP)
        val mediaItem = MediaItem.fromUri(android.net.Uri.parse("custombridge://$streamId"))
        val mediaSource = androidx.media3.exoplayer.source.ProgressiveMediaSource.Factory(factory)
            .createMediaSource(mediaItem)

        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.prepare()
        exoPlayer?.play()

        // Ensure resources are uncoupled when the user closes the video dialog
        playerDialog?.setOnDismissListener {
            exoPlayer?.release()
            exoPlayer = null
        }

        playerDialog?.show()
    }

    /**
     * Called by JS to deliver byte chunks back to the native custom DataSource.
     * JS: Capacitor.Plugins.ExoPlayer.replyRange({ requestId, chunk: string })
     */
    @PluginMethod
    fun replyRange(call: PluginCall) {
        val requestId = call.getString("requestId") ?: run { call.reject("requestId required"); return }
        val base64 = call.getString("chunk") ?: ""

        val bytes = if (base64.isNotEmpty()) {
            android.util.Base64.decode(base64, android.util.Base64.NO_WRAP)
        } else {
            ByteArray(0)
        }

        var delivered = false
        for (list in activeDataSources.values) {
            for (ds in list) {
                if (ds.deliverChunk(requestId, bytes)) {
                    delivered = true
                    break
                }
            }
            if (delivered) break
        }
        
        call.resolve()
    }

    @PluginMethod
    fun stopStream(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.resolve(); return }
        activeDataSources.remove(streamId)
        streamSizes.remove(streamId)
        call.resolve()
    }
}
