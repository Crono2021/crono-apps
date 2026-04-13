package com.cineflix.android

import android.content.Intent
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin
import java.util.concurrent.ConcurrentHashMap

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

    // Map of active stream proxies: streamId -> StreamProxyServer
    private val proxyServers = ConcurrentHashMap<String, StreamProxyServer>()

    /**
     * Called by JS to register a new stream before playing.
     * JS: await Capacitor.Plugins.ExoPlayer.registerStream({ streamId, fileSize, mimeType })
     */
    @PluginMethod
    fun registerStream(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.reject("streamId required"); return }
        
        val fileSize = call.getLong("fileSize")
            ?: call.getInt("fileSize")?.toLong()
            ?: call.getDouble("fileSize")?.toLong()
            ?: call.getString("fileSize")?.toLongOrNull()
            ?: run { call.reject("fileSize required. Payload: " + call.data.toString()); return }
            
        val mimeType = call.getString("mimeType") ?: "video/mp4"

        // Start a local HTTP proxy server for this stream
        val proxy = StreamProxyServer(
            streamId = streamId,
            fileSize = fileSize,
            mimeType = mimeType,
            onRangeRequest = { requestId, start, size ->
                // Ask JS for the bytes
                val eventData = JSObject().apply {
                    put("requestId", requestId)
                    put("streamId", streamId)
                    put("start", start)
                    put("size", size)
                }
                notifyListeners("fetchRange", eventData)
            }
        )
        proxy.start()
        proxyServers[streamId] = proxy

        val result = JSObject()
        result.put("port", proxy.listeningPort)
        call.resolve(result)
    }

    /**
     * Called by JS to launch ExoPlayer fullscreen with the registered stream.
     * JS: await Capacitor.Plugins.ExoPlayer.play({ streamId })
     */
    @PluginMethod
    fun play(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.reject("streamId required"); return }
        val proxy = proxyServers[streamId] ?: run { call.reject("Stream not registered"); return }

        val streamUrl = "http://127.0.0.1:${proxy.listeningPort}/stream/$streamId"

        val mimeType = call.getString("mimeType") ?: "video/*"

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(android.net.Uri.parse(streamUrl), mimeType)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        
        try {
            // Lanza el seleccionador nativo o el reproductor por defecto (ej. VLC)
            val chooser = Intent.createChooser(intent, "Abrir película con...")
            chooser.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(chooser)
            call.resolve()
        } catch (e: Exception) {
            call.reject("No hay ninguna app en el dispositivo capaz de reproducir vídeo: ${e.message}")
        }
    }

    /**
     * Called by JS to deliver byte chunks back to the proxy server.
     * JS: Capacitor.Plugins.ExoPlayer.replyRange({ requestId, chunk: number[] })
     */
    @PluginMethod
    fun replyRange(call: PluginCall) {
        val requestId = call.getString("requestId") ?: run { call.reject("requestId required"); return }
        val base64 = call.getString("chunk") ?: ""

        // Decode Base64 to bytes (much faster than JSON number arrays)
        val bytes = if (base64.isNotEmpty()) {
            android.util.Base64.decode(base64, android.util.Base64.DEFAULT)
        } else {
            ByteArray(0)
        }

        for (proxy in proxyServers.values) {
            if (proxy.deliverChunk(requestId, bytes)) break
        }
        call.resolve()
    }

    /**
     * Called by JS to stop a proxy and free resources.
     */
    @PluginMethod
    fun stopStream(call: PluginCall) {
        val streamId = call.getString("streamId") ?: run { call.resolve(); return }
        proxyServers.remove(streamId)?.stop()
        call.resolve()
    }
}
