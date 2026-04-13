package com.cineflix.android

import android.app.Dialog
import android.util.Base64
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.PlayerView
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

/**
 * ExoPlayerPlugin — Puente Capacitor ↔ ExoPlayer con HLS local.
 *
 * Arquitectura:
 *   1. JS: initStream(fileSize, mimeType)  → prepara HlsProxy (NanoHTTPD) + temp file
 *   2. JS: play()                          → lanza ExoPlayer → GET /stream.m3u8
 *   3. JS: pushChunk(base64)               → escribe bytes → NanoHTTPD sirve /segment/N
 *   4. JS: downloadComplete()              → añade #EXT-X-ENDLIST al M3U8
 *
 * Ventaja sobre ProgressiveMediaSource:
 *   HlsMediaSource tiene retry automático y espera segmentos → no hay NETWORK_CONNECTION_FAILED
 */
@CapacitorPlugin(name = "ExoPlayer")
class ExoPlayerPlugin : Plugin() {

    companion object {
        private const val TAG = "ExoPlayerPlugin"
    }

    private var playerDialog: Dialog? = null
    private var exoPlayer: ExoPlayer? = null
    private var hlsProxy: HlsProxy? = null

    override fun load() {
        super.load()
        // Iniciar NanoHTTPD al cargar el plugin
        hlsProxy = HlsProxy(context)
        try {
            hlsProxy!!.start()
            Log.i(TAG, "🚀 HlsProxy iniciado en puerto ${hlsProxy!!.getPort()}")
        } catch (e: Exception) {
            Log.e(TAG, "Error iniciando HlsProxy: ${e.message}")
        }
    }

    /**
     * Prepara un nuevo stream.
     * JS: await ExoPlayer.initStream({ fileSize: 1234567890, mimeType: 'video/x-matroska' })
     *
     * NOTA: JS envía números como Double a través del JSON bridge.
     * getLong() no convierte Double→Long, usamos getDouble() como fallback.
     */
    @PluginMethod
    fun initStream(call: PluginCall) {
        val fileSize = call.getLong("fileSize")
            ?: call.getDouble("fileSize")?.toLong()
            ?: run {
                call.reject("fileSize required")
                return
            }
        val mimeType = call.getString("mimeType") ?: "video/mp4"

        hlsProxy?.initStream(fileSize, mimeType)

        val result = JSObject()
        result.put("url", hlsProxy?.getM3u8Url() ?: "")
        result.put("port", hlsProxy?.getPort() ?: 0)
        call.resolve(result)

        Log.i(TAG, "📁 Stream preparado: ${fileSize / 1024 / 1024}MB ($mimeType)")
        Log.i(TAG, "📋 M3U8 URL: ${hlsProxy?.getM3u8Url()}")
    }

    /**
     * Recibe un chunk de datos en Base64 y lo escribe al archivo temporal.
     * JS: await ExoPlayer.pushChunk({ data: 'base64string' })
     */
    @PluginMethod
    fun pushChunk(call: PluginCall) {
        val base64Data = call.getString("data") ?: run {
            call.reject("data required")
            return
        }

        try {
            val bytes = Base64.decode(base64Data, Base64.NO_WRAP)
            hlsProxy?.appendData(bytes)
            call.resolve()
        } catch (e: Exception) {
            Log.e(TAG, "Error decodificando chunk: ${e.message}")
            call.reject("Error: ${e.message}")
        }
    }

    /**
     * Marca la descarga como completa.
     * JS: await ExoPlayer.downloadComplete()
     */
    @PluginMethod
    fun downloadComplete(call: PluginCall) {
        hlsProxy?.markComplete()
        call.resolve()
        Log.i(TAG, "✅ Descarga marcada completa")
    }

    /**
     * Lanza ExoPlayer fullscreen con HLS apuntando al proxy local.
     * JS: ExoPlayer.play({})
     */
    @PluginMethod
    fun play(call: PluginCall) {
        val m3u8Url = hlsProxy?.getM3u8Url()
        if (m3u8Url.isNullOrEmpty()) {
            call.reject("No hay stream activo (HlsProxy no iniciado)")
            return
        }

        Log.i(TAG, "▶️ Lanzando ExoPlayer → $m3u8Url")

        activity.runOnUiThread {
            showPlayerOverlay(m3u8Url)
            call.resolve()
        }
    }

    private fun showPlayerOverlay(m3u8Url: String) {
        // Limpiar anterior
        exoPlayer?.release()
        playerDialog?.dismiss()

        // Dialog fullscreen
        playerDialog = Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        playerDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        val playerView = PlayerView(activity)
        playerDialog?.setContentView(playerView, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))

        // DataSource factory con timeouts generosos para el proxy local
        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(30_000)    // 30s — el proxy puede tardar en tener el primer segmento
            .setReadTimeoutMs(60_000)       // 60s — segmentos grandes pueden tardarse
            .setDefaultRequestProperties(mapOf("Cache-Control" to "no-cache"))

        // ━━ HlsMediaSource — robusto, retry automático, espera segmentos ━━
        val mediaItem = MediaItem.fromUri(m3u8Url)
        val mediaSource = HlsMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mediaItem)

        // Construir ExoPlayer
        exoPlayer = ExoPlayer.Builder(activity)
            .setHandleAudioBecomingNoisy(true)  // pausa al desconectar auriculares
            .build()
        playerView.player = exoPlayer

        // Listener de errores con log detallado
        exoPlayer?.addListener(object : Player.Listener {
            override fun onPlayerError(error: PlaybackException) {
                Log.e(TAG, "❌ ExoPlayer error: ${error.errorCodeName} - ${error.message}")
                Log.e(TAG, "   Causa: ${error.cause?.message}")
                activity.runOnUiThread {
                    android.widget.Toast.makeText(
                        context,
                        "Error ${error.errorCodeName}: ${error.message}",
                        android.widget.Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onPlaybackStateChanged(state: Int) {
                val stateName = when (state) {
                    Player.STATE_IDLE -> "IDLE"
                    Player.STATE_BUFFERING -> "BUFFERING"
                    Player.STATE_READY -> "READY"
                    Player.STATE_ENDED -> "ENDED"
                    else -> "UNKNOWN"
                }
                Log.i(TAG, "⏯ ExoPlayer state: $stateName")
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
        Log.i(TAG, "🎬 Dialog mostrado")
    }

    override fun handleOnDestroy() {
        exoPlayer?.release()
        playerDialog?.dismiss()
        try { hlsProxy?.stop() } catch (_: Exception) {}
        hlsProxy?.cleanup()
        super.handleOnDestroy()
    }
}
