package com.cineflix.android

import android.app.Dialog
import android.util.Base64
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import androidx.media3.common.MediaItem
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin

/**
 * ExoPlayerPlugin — Puente Capacitor ↔ ExoPlayer + StreamProxy.
 * 
 * Réplica de la arquitectura de Tevegram:
 *   1. JS descarga chunks vía GramJS
 *   2. Los envía como Base64 a través del bridge
 *   3. Kotlin los escribe en disco (temp file)
 *   4. StreamProxy sirve el archivo vía HTTP 127.0.0.1
 *   5. ExoPlayer reproduce desde el proxy local
 */
@CapacitorPlugin(name = "ExoPlayer")
class ExoPlayerPlugin : Plugin() {

    companion object {
        private const val TAG = "ExoPlayerPlugin"
    }

    private var playerDialog: Dialog? = null
    private var exoPlayer: ExoPlayer? = null
    private var streamProxy: StreamProxy? = null

    override fun load() {
        super.load()
        // Iniciar StreamProxy al arrancar el plugin (como Tevegram hace en onCreate)
        streamProxy = StreamProxy(context)
        val port = streamProxy!!.start()
        Log.i(TAG, "🚀 StreamProxy iniciado en puerto $port")
    }

    /**
     * Prepara un nuevo stream. JS envía fileSize y mimeType.
     * JS: await ExoPlayer.initStream({ fileSize: 1234567890, mimeType: 'video/x-matroska' })
     */
    @PluginMethod
    fun initStream(call: PluginCall) {
        val fileSize = call.getLong("fileSize") ?: run {
            call.reject("fileSize required")
            return
        }
        val mimeType = call.getString("mimeType") ?: "video/mp4"

        streamProxy?.initStream(fileSize, mimeType)

        val result = JSObject()
        result.put("url", streamProxy?.getUrl() ?: "")
        call.resolve(result)

        Log.i(TAG, "📁 Stream preparado: ${fileSize / 1024 / 1024}MB ($mimeType)")
    }

    /**
     * Recibe un chunk de datos codificado en Base64 desde JS.
     * Lo decodifica y lo añade al archivo temporal en disco.
     * JS: await ExoPlayer.pushChunk({ data: 'base64string...' })
     */
    @PluginMethod
    fun pushChunk(call: PluginCall) {
        val base64Data = call.getString("data") ?: run {
            call.reject("data required")
            return
        }

        try {
            val bytes = Base64.decode(base64Data, Base64.NO_WRAP)
            streamProxy?.appendData(bytes)
            call.resolve()
        } catch (e: Exception) {
            Log.e(TAG, "Error decodificando chunk: ${e.message}")
            call.reject("Error decodificando: ${e.message}")
        }
    }

    /**
     * Marca la descarga como completa. Esto desbloquea cualquier
     * petición Range pendiente que esté esperando datos.
     * JS: await ExoPlayer.downloadComplete()
     */
    @PluginMethod
    fun downloadComplete(call: PluginCall) {
        streamProxy?.markComplete()
        call.resolve()
        Log.i(TAG, "✅ Descarga marcada como completa")
    }

    /**
     * Lanza ExoPlayer fullscreen apuntando al StreamProxy local.
     * JS: await ExoPlayer.play()
     */
    @PluginMethod
    fun play(call: PluginCall) {
        val streamUrl = streamProxy?.getUrl()
        if (streamUrl.isNullOrEmpty()) {
            call.reject("No hay stream activo")
            return
        }

        activity.runOnUiThread {
            showPlayerOverlay(streamUrl)
            call.resolve()
        }
    }

    private fun showPlayerOverlay(streamUrl: String) {
        // Liberar recursos anteriores
        exoPlayer?.release()
        playerDialog?.dismiss()

        // Crear dialog fullscreen
        playerDialog = Dialog(activity, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        playerDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

        // PlayerView
        val playerView = PlayerView(activity)
        playerDialog?.setContentView(playerView, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ))

        // Construir ExoPlayer
        exoPlayer = ExoPlayer.Builder(activity).build()
        playerView.player = exoPlayer

        // Listener de errores
        exoPlayer?.addListener(object : androidx.media3.common.Player.Listener {
            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                Log.e(TAG, "❌ ExoPlayer error: ${error.errorCodeName} - ${error.message}")
                android.widget.Toast.makeText(
                    context,
                    "Error: ${error.errorCodeName}",
                    android.widget.Toast.LENGTH_LONG
                ).show()
            }
        })

        // ━━ ARQUITECTURA TEVEGRAM ━━
        // Conectar ExoPlayer al StreamProxy local vía HTTP, exactamente
        // como Tevegram conecta a http://127.0.0.1:45302
        Log.i(TAG, "▶️ ExoPlayer → $streamUrl")

        val dataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(15_000)
            .setReadTimeoutMs(30_000)

        val mediaItem = MediaItem.fromUri(streamUrl)
        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(mediaItem)

        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.prepare()
        exoPlayer?.play()

        // Limpiar recursos al cerrar
        playerDialog?.setOnDismissListener {
            exoPlayer?.release()
            exoPlayer = null
        }

        playerDialog?.show()
    }

    override fun handleOnDestroy() {
        exoPlayer?.release()
        playerDialog?.dismiss()
        streamProxy?.stop()
        super.handleOnDestroy()
    }
}
