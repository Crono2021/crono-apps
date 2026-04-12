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
        val fileSize = call.getLong("fileSize") ?: run { call.reject("fileSize required"); return }
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

        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_STREAM_URL, streamUrl)
            putExtra(PlayerActivity.EXTRA_TITLE, streamId)
        }
        activity.startActivity(intent)
        call.resolve()
    }

    /**
     * Called by JS to deliver byte chunks back to the proxy server.
     * JS: Capacitor.Plugins.ExoPlayer.replyRange({ requestId, chunk: number[] })
     */
    @PluginMethod
    fun replyRange(call: PluginCall) {
        val requestId = call.getString("requestId") ?: run { call.reject("requestId required"); return }
        val chunkArray = call.getArray("chunk") ?: run { call.reject("chunk required"); return }

        // Convert JSArray of ints back to a ByteArray
        val bytes = ByteArray(chunkArray.length()) { i ->
            (chunkArray.getInt(i) and 0xFF).toByte()
        }

        // Find the proxy that owns this requestId and deliver the bytes
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
