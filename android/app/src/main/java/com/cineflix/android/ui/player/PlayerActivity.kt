package com.cineflix.android.ui.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.cineflix.android.TelegramEngine
import androidx.appcompat.app.AppCompatActivity

import kotlinx.coroutines.*

import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManager
import com.google.android.gms.cast.framework.SessionManagerListener
import androidx.mediarouter.app.MediaRouteButton

/**
 * Cineflix ExoPlayer fullscreen activity with Chromecast support.
 *
 * When the user taps the Cast button:
 *   1. ExoPlayer pauses
 *   2. The stream URL (using WiFi IP) is sent to the Chromecast
 *   3. The StreamProxyServer stays alive — Chromecast pulls bytes from it
 *
 * When the user disconnects Cast:
 *   1. ExoPlayer resumes playback
 */
class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private var playerView: PlayerView? = null
    private var proxyServer: StreamProxyServer? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    // Cast
    private var castContext: CastContext? = null
    private var sessionManager: SessionManager? = null
    private var castStreamUrl: String? = null
    private var currentMimeType: String = "video/mp4"
    private var currentTitle: String = ""
    private var castSessionListener: SessionManagerListener<CastSession>? = null
    private var isCasting = false
    private var castButton: MediaRouteButton? = null

    companion object {
        const val EXTRA_FILE_ID   = "file_id"
        const val EXTRA_FILE_SIZE = "file_size"
        const val EXTRA_MIME_TYPE = "mime_type"
        const val EXTRA_TITLE     = "title"
        const val EXTRA_CHAT_ID   = "chat_id"
        const val EXTRA_MSG_ID    = "msg_id"

        private const val TAG = "PlayerActivity"
    }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Fullscreen immersive
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )

        // Keep screen on during playback
        window.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val engine   = TelegramEngine.getInstance(this)

        currentMimeType = mimeType
        currentTitle = title

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
            for ((_, pair) in engine.fileIdCache) {
                if (pair.first == fileId) {
                    Log.w(TAG, "fileSize was 0, found fileId=$fileId in cache but no size info available")
                    break
                }
            }
            effectiveFileSize = 2_000_000_000L
            Log.w(TAG, "Using default fileSize=$effectiveFileSize")
        }

        // 1. Start StreamProxyServer
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

        // 2. Register file with TDLib
        scope.launch {
            try {
                Log.i(TAG, "▶ Registering fileId=$fileId with TDLib (disk-free mode)...")
                engine.startDownloadReturnPath(fileId, priority = 32)
                // Kick off aggressive pre-fetch immediately — don't wait for ExoPlayer's first request.
                // This gives TDLib a head start on Fire Stick and other slow devices.
                engine.hintDownloadOffset(fileId, 0L, 20L * 1024L * 1024L)
                Log.i(TAG, "▶ TDLib registration complete + 20MB pre-hint sent for fileId=$fileId")
            } catch (e: Exception) {
                Log.e(TAG, "▶ TDLib registration error: ${e.message}", e)
            }
        }

        // 3. Build stream URLs
        val localStreamUrl = "http://127.0.0.1:$port/stream"
        val wifiIp = getWifiIpAddress()
        castStreamUrl = if (wifiIp != null) "http://$wifiIp:$port/stream" else null
        Log.i(TAG, "▶ ExoPlayer URL: $localStreamUrl")
        Log.i(TAG, "▶ Cast URL: $castStreamUrl")

        // 4. Setup UI: FrameLayout with PlayerView + Cast button overlay
        val rootLayout = FrameLayout(this)

        playerView = PlayerView(this).apply {
            useController = true
            setShowSubtitleButton(true)
            
            // Habilitar el botón de Pantalla Completa nativo de ExoPlayer
            // Lo usaremos para alternar entre "Ajustar (con bordes)" y "Rellenar/Zoom (sin bordes)"
            setFullscreenButtonClickListener { isFullScreen ->
                if (isFullScreen) {
                    this.resizeMode = androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                } else {
                    this.resizeMode = androidx.media3.ui.AspectRatioFrameLayout.RESIZE_MODE_FIT
                }
            }
        }
        
        // Sincronizar visibilidad de controles con el botón de Chromecast
        playerView?.setControllerVisibilityListener(
            androidx.media3.ui.PlayerView.ControllerVisibilityListener { visibility ->
                castButton?.visibility = visibility
            }
        )

        rootLayout.addView(playerView, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))

        // Cast button overlay (top-right corner)
        setupCastButton(rootLayout)

        setContentView(rootLayout)

        // 5. Setup ExoPlayer
        val loadControl = androidx.media3.exoplayer.DefaultLoadControl.Builder()
            .setAllocator(androidx.media3.exoplayer.upstream.DefaultAllocator(true, androidx.media3.common.C.DEFAULT_BUFFER_SEGMENT_SIZE))
            // minBuffer=30s, maxBuffer=60s, bufferForPlayback=8s, bufferForPlaybackAfterRebuffer=12s
            // Generous buffers prevent micro-freezes on Fire Stick and low-end devices
            .setBufferDurationsMs(30000, 60000, 8000, 12000)
            .setPrioritizeTimeOverSizeThresholds(true)
            .build()

        val trackSelector = androidx.media3.exoplayer.trackselection.DefaultTrackSelector(this)
        trackSelector.parameters = trackSelector.buildUponParameters()
            .setSelectUndeterminedTextLanguage(false)
            .build()

        val dataSourceFactory = androidx.media3.datasource.DefaultHttpDataSource.Factory()
            .setConnectTimeoutMs(60000)
            .setReadTimeoutMs(60000)
            .setAllowCrossProtocolRedirects(true)

        val mediaSourceFactory = androidx.media3.exoplayer.source.DefaultMediaSourceFactory(dataSourceFactory)

        val renderersFactory = androidx.media3.exoplayer.DefaultRenderersFactory(this)
            .setExtensionRendererMode(androidx.media3.exoplayer.DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)

        val exo = ExoPlayer.Builder(this)
            .setRenderersFactory(renderersFactory)
            .setMediaSourceFactory(mediaSourceFactory)
            .setLoadControl(loadControl)
            .setTrackSelector(trackSelector)
            .build()

        playerView?.player = exo
        player = exo

        val mediaItem = MediaItem.fromUri(Uri.parse(localStreamUrl))
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

        // 6. Setup Cast session listener
        setupCastSessionListener()
    }

    // ─────────────────────────────────────────────────────────────────────
    // Cast Integration
    // ─────────────────────────────────────────────────────────────────────

    private fun setupCastButton(rootLayout: FrameLayout) {
        try {
            castContext = CastContext.getSharedInstance(this)
            sessionManager = castContext?.sessionManager

            // ContextThemeWrapper ensures the button gets the AppCompat styling it needs
            val btn = MediaRouteButton(this)
            castButton = btn
            
            // Force the button to always show (disabled/grayed if no devices found)
            btn.setAlwaysVisible(true)
            
            // Set the cast icon color to white so it's visible on the dark video layout
            val castDrawable = androidx.core.content.ContextCompat.getDrawable(this, androidx.mediarouter.R.drawable.mr_button_light)
            castDrawable?.setTint(android.graphics.Color.WHITE)
            btn.setRemoteIndicatorDrawable(castDrawable)
            CastButtonFactory.setUpMediaRouteButton(this, btn)

            val params = FrameLayout.LayoutParams(
                dpToPx(48),
                dpToPx(48)
            ).apply {
                gravity = Gravity.TOP or Gravity.END
                setMargins(0, dpToPx(24), dpToPx(24), 0)
            }
            rootLayout.addView(btn, params)

            Log.i(TAG, "▶ Cast button added successfully")
        } catch (e: Exception) {
            // Google Play Services not available or crashes rendering Cast button
            // Typical on Android TV (Receiver only) or stripped-down devices.
            // Failing silently is perfectly fine as casting from a TV to another TV isn't standard anyway.
            Log.e(TAG, "Cast SDK Error: ${e.message}", e)
        }
    }

    private fun setupCastSessionListener() {
        val sm = sessionManager ?: return
        val url = castStreamUrl ?: return

        castSessionListener = object : SessionManagerListener<CastSession> {
            override fun onSessionStarting(session: CastSession) {}
            override fun onSessionStartFailed(session: CastSession, error: Int) {
                Log.e(TAG, "Cast session start failed: $error")
                Toast.makeText(this@PlayerActivity, "Error al conectar con Chromecast", Toast.LENGTH_SHORT).show()
            }

            override fun onSessionStarted(session: CastSession, sessionId: String) {
                Log.i(TAG, "▶ Cast session started → sending stream to Chromecast")
                isCasting = true

                // Pause local ExoPlayer
                player?.pause()

                // Send stream URL to Chromecast
                val metadata = MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE).apply {
                    putString(MediaMetadata.KEY_TITLE, currentTitle)
                }
                val mediaInfo = MediaInfo.Builder(url)
                    .setContentType(currentMimeType)
                    .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                    .setMetadata(metadata)
                    .build()

                val loadRequest = MediaLoadRequestData.Builder()
                    .setMediaInfo(mediaInfo)
                    .setAutoplay(true)
                    .setCurrentTime(player?.currentPosition ?: 0L)
                    .build()

                session.remoteMediaClient?.load(loadRequest)

                Toast.makeText(this@PlayerActivity, "📺 Enviando a Chromecast...", Toast.LENGTH_SHORT).show()
            }

            override fun onSessionResuming(session: CastSession, sessionId: String) {}
            override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
                isCasting = true
                player?.pause()
            }
            override fun onSessionResumeFailed(session: CastSession, error: Int) {}

            override fun onSessionSuspended(session: CastSession, reason: Int) {}

            override fun onSessionEnding(session: CastSession) {}
            override fun onSessionEnded(session: CastSession, error: Int) {
                Log.i(TAG, "▶ Cast session ended → resuming local playback")
                isCasting = false

                // Resume local ExoPlayer
                player?.play()
                Toast.makeText(this@PlayerActivity, "📱 Reproducción local reanudada", Toast.LENGTH_SHORT).show()
            }
        }

        sm.addSessionManagerListener(castSessionListener!!, CastSession::class.java)
    }

    // ─────────────────────────────────────────────────────────────────────
    // WiFi IP Helper
    // ─────────────────────────────────────────────────────────────────────

    private fun getWifiIpAddress(): String? {
        return try {
            val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val ip = wifiManager.connectionInfo.ipAddress
            if (ip == 0) return null
            String.format(
                "%d.%d.%d.%d",
                ip and 0xff,
                ip shr 8 and 0xff,
                ip shr 16 and 0xff,
                ip shr 24 and 0xff
            )
        } catch (e: Exception) {
            Log.w(TAG, "Could not get WiFi IP: ${e.message}")
            null
        }
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    // ─────────────────────────────────────────────────────────────────────
    // Lifecycle
    // ─────────────────────────────────────────────────────────────────────

    override fun onStop() {
        super.onStop()
        if (!isCasting) {
            cleanup()
        }
        // If casting, DON'T cleanup — the proxy must stay alive for the Chromecast
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (isCasting) {
            // Disconnect cast session first, then cleanup
            try {
                castContext?.sessionManager?.endCurrentSession(true)
            } catch (_: Exception) {}
        }
        cleanup()
        finish()
    }

    override fun dispatchKeyEvent(event: android.view.KeyEvent): Boolean {
        if (event.keyCode == android.view.KeyEvent.KEYCODE_BACK && event.action == android.view.KeyEvent.ACTION_UP) {
            if (playerView?.isControllerFullyVisible == true) {
                playerView?.hideController()
                return true
            }
        }
        return super.dispatchKeyEvent(event)
    }

    private fun cleanup() {
        // Remove Cast listener
        try {
            castSessionListener?.let {
                sessionManager?.removeSessionManagerListener(it, CastSession::class.java)
            }
        } catch (_: Exception) {}

        try { player?.release() } catch (_: Exception) {}
        try { proxyServer?.stop() } catch (_: Exception) {}
        scope.cancel()

        // Eagerly delete TDLib downloaded video chunks
        val fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (fileId > 0) {
            val engine = TelegramEngine.getInstance(this)
            engine.cancelAndDeleteVideo(fileId)
        }
    }
}
