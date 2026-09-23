package com.cineflix.android.ui.player

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.cineflix.android.TelegramEngine
import com.cineflix.android.R
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManager
import com.google.android.gms.cast.framework.SessionManagerListener
import androidx.mediarouter.app.MediaRouteButton
import kotlinx.coroutines.*

// Media3
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.TrackSelectionOverride
import androidx.media3.common.Tracks
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private var proxyServer: StreamProxyServer? = null
    private var localStreamServer: LocalStreamServer? = null
    private var multipartParts: List<FilePart>? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    // UI
    private lateinit var playerView: PlayerView
    private lateinit var tvVideoTitle: TextView
    private lateinit var tvTimeCurrent: TextView
    private lateinit var tvTimeDuration: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var bottomBar: LinearLayout
    private lateinit var centerControls: LinearLayout
    private lateinit var btnPlayPause: ImageButton
    private lateinit var btnRewind: ImageButton
    private lateinit var btnForward: ImageButton
    private lateinit var btnResize: ImageButton
    private lateinit var btnTracks: ImageButton
    private lateinit var btnReportError: ImageButton
    private lateinit var loadingSpinner: ProgressBar
    private var currentFileId: Int = -1
    private var currentPlayUrl: String? = null
    private lateinit var castContainer: FrameLayout
    private lateinit var layoutNextEpisode: LinearLayout
    private lateinit var tvNextEpisodeCountdown: TextView
    private lateinit var layoutSkipIntro: LinearLayout

    private val titleHandler = Handler(Looper.getMainLooper())
    private val controlsHandler = Handler(Looper.getMainLooper())
    private val seekBarHandler = Handler(Looper.getMainLooper())

    private var controlsVisible = false
    private var isSeeking = false
    private var currentScaleIndex = 0
    private var wasPlaying = false
    private var savedPosition = 0L
    private var pendingResumePositionMs: Long? = null
    private var introSkipped = false
    private var nextEpisodeTriggered = false
    private var currentEffectiveFileSize: Long = 0L
    private var ioErrorRetryCount = 0
    private var lastIoErrorTimeMs = 0L

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
        const val EXTRA_MULTIPART_JSON = "multipart_json"
        const val EXTRA_FILE_ID   = "file_id"
        const val EXTRA_FILE_SIZE = "file_size"
        const val EXTRA_MIME_TYPE = "mime_type"
        const val EXTRA_TITLE     = "title"
        const val EXTRA_CHAT_ID   = "chat_id"
        const val EXTRA_MSG_ID    = "msg_id"
        
        const val EXTRA_PHONE      = "phone"
        const val EXTRA_CONTENT_ID = "content_id"
        const val EXTRA_SEASON     = "season"
        const val EXTRA_EPISODE    = "episode"
        const val EXTRA_CREDITS_START = "credits_start"

        // TheIntroDB extras
        const val EXTRA_INTRO_START_MS       = "intro_start_ms"
        const val EXTRA_INTRO_END_MS         = "intro_end_ms"
        const val EXTRA_INTRODB_CREDITS_MS   = "introdb_credits_ms"
        const val EXTRA_PROGRESS             = "progress"

        private const val TAG = "PlayerActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pantalla completa extrema
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)
        hideSystemUI()

        setContentView(R.layout.activity_player)
        
        bindViews()
        setupListeners()

        val multipartJson = intent.getStringExtra(EXTRA_MULTIPART_JSON)
        if (!multipartJson.isNullOrEmpty()) {
            try {
                val partsArray = org.json.JSONArray(multipartJson)
                val parts = mutableListOf<FilePart>()
                for (i in 0 until partsArray.length()) {
                    val obj = partsArray.getJSONObject(i)
                    parts.add(FilePart(obj.getInt("fileId"), obj.getLong("size")))
                }
                if (parts.isNotEmpty()) {
                    multipartParts = parts
                    Log.i(TAG, "Loaded multipart video with ${parts.size} parts")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to parse EXTRA_MULTIPART_JSON", e)
                Toast.makeText(this, "Error parsing multipart video data", Toast.LENGTH_LONG).show()
                finish()
                return
            }
        }
        var fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (multipartParts != null && multipartParts!!.isNotEmpty()) {
            fileId = multipartParts!![0].fileId
        }
        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        
        val phone      = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId  = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season     = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode    = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        val jsProgress = intent.getStringExtra(EXTRA_PROGRESS)
        
        val engine   = TelegramEngine.getInstance(this)

        currentMimeType = mimeType
        currentTitle = title
        currentFileId = fileId

        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                Log.e(TAG, "Uncaught exception in PlayerActivity: ${throwable.message}", throwable)
                val extra = mapOf(
                    "title" to currentTitle,
                    "fileId" to currentFileId,
                    "position" to (player?.currentPosition ?: 0L).toString()
                )
                com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
                    context = applicationContext,
                    reason = "Crash No Controlado: ${throwable.javaClass.simpleName} - ${throwable.message}",
                    extraInfo = extra,
                    throwable = throwable
                )
                Thread.sleep(1500)
            } catch (e: Exception) {
                // ignore
            }
            defaultHandler?.uncaughtException(thread, throwable)
        }

        Log.i(TAG, "▶ onCreate: fileId=$fileId fileSize=$fileSize mimeType=$mimeType title=$title contentId=$contentId")
        // Diagnostic: dump ALL TheIntroDB extras
        val dbgIntroStart = intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "(null)"
        val dbgIntroEnd   = intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "(null)"
        val dbgCreditsMs  = intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "(null)"
        val dbgCreditsStart = intent.getStringExtra(EXTRA_CREDITS_START) ?: "(null)"
        Log.i(TAG, "🔍 DIAG IntroDB: introStart='$dbgIntroStart' introEnd='$dbgIntroEnd' introDbCredits='$dbgCreditsMs' creditsStart='$dbgCreditsStart' contentId='$contentId' season='$season' episode='$episode'")

        if (fileId <= 0) {
            Toast.makeText(this, "Error: fileId inválido ($fileId)", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        var effectiveFileSize = fileSize
        if (effectiveFileSize <= 0) {
            effectiveFileSize = 2_000_000_000L
        }
        currentEffectiveFileSize = multipartParts?.sumOf { it.size }?.takeIf { it > 0 } ?: effectiveFileSize
        introSkipped = false
        nextEpisodeTriggered = false

        val useNodeJsProxy = intent.getBooleanExtra("USE_NODEJS_PROXY", false)
        var port = 0
        
        val intentPlaybackId = intent.getStringExtra("EXTRA_PLAYBACK_ID")
        val currentPlaybackId = com.cineflix.android.GramJSStreamManager.currentPlaybackId
        val playbackId = intentPlaybackId ?: currentPlaybackId
        val isGramJsActive = false // Always use LocalStreamServer (Oliyo native architecture)
        
        val localStreamUrl: String
        if (useNodeJsProxy) {
            port = 3000
            localStreamUrl = "http://127.0.0.1:3000/stream"
            Log.i(TAG, "- Using NodeJS StreamProxyServer on port 3000")
        } else if (isGramJsActive) {
            port = 8080 // Dummy port, not used for casting yet for GramJS
            localStreamUrl = "tdlib://$fileId"
            Log.i(TAG, "- Using GramJS memory proxy, completely bypassing TDLib background downloads.")
        } else {
            // LocalStreamServer (Arquitectura tipo Oliyo):
            // Servidor HTTP local embebido que atiende peticiones Range bajo demanda de forma limpia.
            // NO arrancamos StreamProxyServer ni startDownloadReturnPath para evitar colisiones TDLib
            // (error 200: Canceled by another downloadFile request).
            val lss = LocalStreamServer(engine)
            val lssUrl = lss.start(
                fileId = fileId,
                totalSize = currentEffectiveFileSize,
                mimeType = mimeType,
                multipartParts = multipartParts
            )
            localStreamServer = lss
            localStreamUrl = lssUrl
            port = lss.listeningPort
            Log.i(TAG, "✨ LocalStreamServer iniciado para reproducción: $localStreamUrl en puerto $port")
        }
        val wifiIp = getWifiIpAddress()
        castStreamUrl = if (wifiIp != null && !isGramJsActive && port > 0) "http://$wifiIp:$port/stream" else null
        
        setupCastButton()

        // 4. Iniciar ExoPlayer
        initExoPlayer()

        // 5. Apply progress and start tracking
        val p = jsProgress?.toFloatOrNull()?.toInt() ?: 0
        if (p > 5) {
            pendingResumePositionMs = p * 1000L
            playUrl(localStreamUrl)
            player?.seekTo(p * 1000L)
            Toast.makeText(this@PlayerActivity, "Reanudado en ${p/60}m", Toast.LENGTH_SHORT).show()
        } else if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            scope.launch {
                try {
                    val savedProgress = fetchSavedProgress(phone, contentId, season, episode)
                    withContext(Dispatchers.Main) {
                        if (savedProgress > 5) {
                            pendingResumePositionMs = savedProgress * 1000L
                            playUrl(localStreamUrl)
                            player?.seekTo(savedProgress * 1000L)
                            Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress/60}m", Toast.LENGTH_SHORT).show()
                        } else {
                            playUrl(localStreamUrl)
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) { playUrl(localStreamUrl) }
                }
            }
        } else {
            playUrl(localStreamUrl)
        }

        if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            startProgressTracking(phone, contentId, season, episode)
        }

        showTitle(title)
        scheduleHideControls()
        setupCastSessionListener()
    }

    private fun bindViews() {
        playerView = findViewById(R.id.video_surface)
        tvVideoTitle = findViewById(R.id.tv_video_title)
        tvTimeCurrent = findViewById(R.id.tv_time_current)
        tvTimeDuration = findViewById(R.id.tv_time_duration)
        seekBar = findViewById(R.id.seek_bar)
        bottomBar = findViewById(R.id.bottom_bar)
        centerControls = findViewById(R.id.center_controls)
        btnPlayPause = findViewById(R.id.btn_play_pause)
        btnRewind = findViewById(R.id.btn_rewind)
        btnForward = findViewById(R.id.btn_forward)
        btnResize = findViewById(R.id.btn_resize)
        btnTracks = findViewById(R.id.btn_tracks)
        btnReportError = findViewById(R.id.btn_report_error)
        loadingSpinner = findViewById(R.id.loading_spinner)
        castContainer = findViewById(R.id.cast_button_container)
        layoutNextEpisode = findViewById(R.id.layout_next_episode)
        tvNextEpisodeCountdown = findViewById(R.id.tv_next_episode_countdown)
        layoutSkipIntro = findViewById(R.id.layout_skip_intro)
    }

    private fun setupListeners() {
        btnPlayPause.setOnClickListener { togglePlayPause() }
        btnRewind.setOnClickListener { seekRelative(-10000); showControls() }
        btnForward.setOnClickListener { seekRelative(10000); showControls() }
        btnResize.setOnClickListener { toggleResizeMode() }
        btnTracks.setOnClickListener { showTrackSelectorDialog() }
        btnReportError.setOnClickListener {
            val currentPos = player?.currentPosition ?: 0L
            val duration = player?.duration ?: 0L
            val posStr = "${currentPos / 1000 / 60}:${String.format("%02d", (currentPos / 1000) % 60)}"
            val durStr = "${duration / 1000 / 60}:${String.format("%02d", (duration / 1000) % 60)}"

            val extra = mapOf(
                "title" to currentTitle,
                "fileId" to currentFileId,
                "position" to "$posStr / $durStr (${currentPos}ms)",
                "url" to (currentPlayUrl ?: "N/A"),
                "state" to "Reporte manual desde reproductor"
            )
            Toast.makeText(this@PlayerActivity, "Enviando reporte de diagnóstico al bot...", Toast.LENGTH_SHORT).show()
            com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
                context = applicationContext,
                reason = "Reporte manual del usuario durante la reproducción",
                extraInfo = extra
            ) { success, errorMsg ->
                Handler(Looper.getMainLooper()).post {
                    if (success) {
                        Toast.makeText(applicationContext, "✅ Reporte .txt enviado con éxito a @videoclubpacobot", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, "❌ No se pudo enviar al bot: ${errorMsg ?: "Error de red"}", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        setupFocusAnimation(btnPlayPause)
        setupFocusAnimation(btnRewind)
        setupFocusAnimation(btnForward)
        setupFocusAnimation(btnResize)
        setupFocusAnimation(btnTracks)
        setupFocusAnimation(btnReportError)

        seekBar.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150).start()
            } else {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start()
            }
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser && player != null) player?.seekTo(progress.toLong())
            }
            override fun onStartTrackingTouch(bar: SeekBar) { isSeeking = true }
            override fun onStopTrackingTouch(bar: SeekBar) { isSeeking = false }
        })

        playerView.setOnClickListener { toggleControls() }
        
        layoutNextEpisode.setOnClickListener {
            if (!nextEpisodeTriggered) {
                nextEpisodeTriggered = true
                triggerNextEpisode()
            }
        }
        
        layoutNextEpisode.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150).start()
                v.setBackgroundResource(R.drawable.bg_next_episode)
            } else {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start()
            }
        }

        // Skip Intro button
        layoutSkipIntro.setOnClickListener {
            val introEndMs = (intent.getStringExtra(EXTRA_INTRO_END_MS) ?: "").toLongOrNull()
            if (introEndMs != null && introEndMs > 0) {
                introSkipped = true
                layoutSkipIntro.animate().cancel()
                layoutSkipIntro.visibility = View.GONE
                val targetSeek = introEndMs + 1000L
                player?.seekTo(targetSeek)
                Log.i(TAG, "⏩ Skip Intro: seekTo($targetSeek ms)")
            }
        }

        layoutSkipIntro.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150).start()
            } else {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start()
            }
        }
    }

    private fun setupFocusAnimation(view: View) {
        view.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.animate().scaleX(1.2f).scaleY(1.2f).setDuration(150).start()
                if (v is ImageButton) {
                    v.setColorFilter(android.graphics.Color.parseColor("#7c3aed"))
                }
            } else {
                v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start()
                if (v is ImageButton) {
                    v.clearColorFilter()
                }
            }
        }
    }

    private fun initExoPlayer() {
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        val forceSoftwareAudio = prefs.getBoolean("force_software_audio", false)

        // FFmpeg via NextLib: MODE_ON = Decodificadores hardware primero para vídeo fluido y HDR;
        // fallback automático a software si un códec no está soportado.
        val mode = DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON

        val customMediaCodecSelector = androidx.media3.exoplayer.mediacodec.MediaCodecSelector { mimeType, requiresSecureDecoder, requiresTunnelingDecoder ->
            val decoders = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder)
            if (mimeType.equals(androidx.media3.common.MimeTypes.VIDEO_H265, ignoreCase = true)) {
                decoders.sortedBy { decoder ->
                    if (decoder.name.contains("exynos", ignoreCase = true)) 1 else 0
                }
            } else {
                decoders
            }
        }

        val renderersFactory = CineflixRenderersFactory(this) {
            getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE).getBoolean("force_software_audio", false)
        }
            .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
            .setEnableDecoderFallback(true)
            .setMediaCodecSelector(customMediaCodecSelector)

        val loadControl = androidx.media3.exoplayer.DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                25_000, // minBufferMs (25s: memoria controlada para TVs de 1GB RAM)
                45_000, // maxBufferMs (45s: margen seguro sin saturar Heap de Java a 149MB)
                3_500,  // bufferForPlaybackMs (3.5s: elimina las 3 pausas del círculo morado al inicio)
                5_000   // bufferForPlaybackAfterRebufferMs (5s: reanudación sólida si hay microcorte)
            )
            .setPrioritizeTimeOverSizeThresholds(true)
            .build()

        val p = ExoPlayer.Builder(this)
            .setRenderersFactory(renderersFactory)
            .setLoadControl(loadControl)
            .build()

        player = p
            
        playerView.player = player
        playerView.useController = false

        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (playbackState == Player.STATE_BUFFERING) {
                    loadingSpinner.visibility = View.VISIBLE
                } else {
                    loadingSpinner.visibility = View.GONE
                    if (playbackState == Player.STATE_READY) {
                        ioErrorRetryCount = 0
                        pendingResumePositionMs?.let { resumePos ->
                            pendingResumePositionMs = null
                            val current = player?.currentPosition ?: 0L
                            if (kotlin.math.abs(current - resumePos) > 4000L) {
                                if (player?.isCurrentMediaItemSeekable == true) {
                                    Log.i(TAG, "▶ STATE_READY reached: seeking to resume position ${resumePos}ms (current=${current}ms)")
                                    player?.seekTo(resumePos)
                                } else {
                                    Log.w(TAG, "▶ Media item is not seekable (no Cues index). Playing from start.")
                                }
                            } else {
                                Log.i(TAG, "▶ STATE_READY reached: already at resume position ${current}ms, skipping redundant seek")
                            }
                        }
                    }

                    if (playbackState == Player.STATE_ENDED) {
                        val dur = player?.duration ?: 0L
                        val pos = player?.currentPosition ?: 0L
                        // Only auto-trigger next episode if playback actually reached near the end of the video
                        if (dur > 30_000L && pos >= dur - 15_000L && !nextEpisodeTriggered) {
                            nextEpisodeTriggered = true
                            triggerNextEpisode()
                        }
                    }
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                if (isPlaying) {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
                    scheduleHideControls()
                } else {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
                }
            }

            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                if (isFinishing || isDestroyed || isCleanedUp) {
                    Log.w(TAG, "Ignoring onPlayerError during activity teardown/cleanup: ${error.message}")
                    return
                }
                Log.e(TAG, "onPlayerError: ${error.errorCodeName} - ${error.message}", error)
                val isIoError = error.errorCode == androidx.media3.common.PlaybackException.ERROR_CODE_IO_UNSPECIFIED ||
                                error.errorCode == androidx.media3.common.PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED ||
                                error.errorCode == androidx.media3.common.PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT ||
                                error.errorCodeName.startsWith("ERROR_CODE_IO_")

                val now = System.currentTimeMillis()
                if (isIoError && ioErrorRetryCount < 3) {
                    ioErrorRetryCount++
                    lastIoErrorTimeMs = now
                    val currentPos = player?.currentPosition ?: 0L
                    Log.w(TAG, "IO error detected ($ioErrorRetryCount/3). Attempting auto-recovery at position ${currentPos}ms...")
                    Toast.makeText(this@PlayerActivity, "Reconectando con el servidor ($ioErrorRetryCount/3)...", Toast.LENGTH_SHORT).show()
                    loadingSpinner.visibility = View.VISIBLE

                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!isFinishing && !isDestroyed) {
                            if (currentPos > 0) {
                                try {
                                    player?.seekTo(currentPos)
                                } catch (e: Exception) {
                                    Log.w(TAG, "Failed pre-seek: ${e.message}")
                                }
                            }
                            pendingResumePositionMs = currentPos
                            player?.prepare()
                            player?.play()
                        }
                    }, 1500L)
                    return
                }

                // Error definitivo o reintentos agotados: Generar y enviar reporte al bot
                val currentPos = player?.currentPosition ?: 0L
                val duration = player?.duration ?: 0L
                val posStr = "${currentPos / 1000 / 60}:${String.format("%02d", (currentPos / 1000) % 60)}"
                val durStr = "${duration / 1000 / 60}:${String.format("%02d", (duration / 1000) % 60)}"

                val extra = mapOf(
                    "title" to currentTitle,
                    "fileId" to currentFileId,
                    "position" to "$posStr / $durStr (${currentPos}ms)",
                    "error" to "${error.errorCodeName}: ${error.message}",
                    "retryCount" to ioErrorRetryCount,
                    "url" to (currentPlayUrl ?: "N/A")
                )

                Toast.makeText(this@PlayerActivity, "Error de reproducción. Enviando log al bot...", Toast.LENGTH_LONG).show()
                com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
                    context = applicationContext,
                    reason = "ExoPlayer Error: ${error.errorCodeName} - ${error.message}",
                    extraInfo = extra,
                    throwable = error
                ) { success, _ ->
                    Handler(Looper.getMainLooper()).post {
                        if (success) {
                            Toast.makeText(applicationContext, "Reporte de error enviado a @videoclubpacobot", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                finish()
            }
        })
    }
    private fun playUrl(url: String) {
        currentPlayUrl = url
        loadingSpinner.visibility = View.VISIBLE
        
        val engine = TelegramEngine.getInstance(this)
        val mediaItem = androidx.media3.common.MediaItem.fromUri(android.net.Uri.parse(url))
        
        if (url.startsWith("tdlib://")) {
            val intentPlaybackId = intent.getStringExtra("EXTRA_PLAYBACK_ID")
            val currentPlaybackId = com.cineflix.android.GramJSStreamManager.currentPlaybackId
            val playbackId = intentPlaybackId ?: currentPlaybackId
            
            android.util.Log.e("PlayerActivity", "=========================================================")
            android.util.Log.e("PlayerActivity", "playbackId resolution:")
            android.util.Log.e("PlayerActivity", "intent EXTRA_PLAYBACK_ID: $intentPlaybackId")
            android.util.Log.e("PlayerActivity", "GramJSStreamManager.currentPlaybackId: $currentPlaybackId")
            android.util.Log.e("PlayerActivity", "Final playbackId to use: $playbackId")
            android.util.Log.e("PlayerActivity", "=========================================================")

            val dataSourceFactory: androidx.media3.datasource.DataSource.Factory = if (playbackId.isNotEmpty()) {
                android.util.Log.i("PlayerActivity", "Using GramJSDataSourceFactory for playbackId: $playbackId")
                GramJSDataSourceFactory(playbackId, 0)
            } else {
                android.util.Log.w("PlayerActivity", "Fallback to TdlibDataSourceFactory (no playbackId)")
                TdlibDataSourceFactory(engine, multipartParts)
            }
            val mediaSource = androidx.media3.exoplayer.source.DefaultMediaSourceFactory(dataSourceFactory)
                .createMediaSource(mediaItem)
            player?.setMediaSource(mediaSource)
        } else {
            val httpDataSourceFactory = androidx.media3.datasource.DefaultHttpDataSource.Factory()
                .setConnectTimeoutMs(15000)
                .setReadTimeoutMs(25000)
                .setAllowCrossProtocolRedirects(true)
            val mediaSource = androidx.media3.exoplayer.source.DefaultMediaSourceFactory(httpDataSourceFactory)
                .createMediaSource(mediaItem)
            player?.setMediaSource(mediaSource)
        }
                player?.prepare()
        player?.play()
        
        startSeekBarUpdater()
    }

    // --- Video Scaling ---
    private fun toggleResizeMode() {
        currentScaleIndex = (currentScaleIndex + 1) % 4
        var modeName = ""

        when (currentScaleIndex) {
            0 -> {
                playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                modeName = "Original"
            }
            1 -> {
                playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH
                modeName = "Ajustar Ancho"
            }
            2 -> {
                playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                modeName = "Llenar Pantalla"
            }
            3 -> {
                playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                modeName = "Zoom"
            }
        }

        Toast.makeText(this, modeName, Toast.LENGTH_SHORT).show()
        showControls()
    }

    // --- Unified Track Selector (Optimizado para Android TV) ---
    private fun showTrackSelectorDialog() {
        val p = player ?: return
        val tracks = p.currentTracks

        val dialog = android.app.Dialog(this, R.style.Theme_Cineflix_TVDialog)
        val dialogView = layoutInflater.inflate(R.layout.dialog_track_selector, null)
        dialog.setContentView(dialogView)

        val containerAudio = dialogView.findViewById<LinearLayout>(R.id.container_audio_tracks)
        val containerSubtitles = dialogView.findViewById<LinearLayout>(R.id.container_subtitle_tracks)
        val btnClose = dialogView.findViewById<TextView>(R.id.btn_dialog_close)

        // Botón / Toggle Compatibilidad Estéreo
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        var forceSoftware = prefs.getBoolean("force_software_audio", false)

        val btnToggleStereo = dialogView.findViewById<LinearLayout>(R.id.btn_toggle_stereo)
        val tvStereoIndicator = dialogView.findViewById<TextView>(R.id.tv_stereo_indicator)
        val tvStereoState = dialogView.findViewById<TextView>(R.id.tv_stereo_state)

        fun updateStereoUi(enabled: Boolean) {
            tvStereoIndicator.text = if (enabled) "☑" else "☐"
            tvStereoIndicator.setTextColor(if (enabled) android.graphics.Color.parseColor("#A78BFA") else android.graphics.Color.parseColor("#888899"))
            tvStereoState.text = if (enabled) "ACTIVADO" else "DESACTIVADO"
            tvStereoState.setTextColor(if (enabled) android.graphics.Color.parseColor("#A78BFA") else android.graphics.Color.parseColor("#888899"))
        }
        updateStereoUi(forceSoftware)

        btnToggleStereo.setOnClickListener {
            forceSoftware = !forceSoftware
            prefs.edit().putBoolean("force_software_audio", forceSoftware).apply()
            updateStereoUi(forceSoftware)

            val currentPos = player?.currentPosition ?: 0L
            val wasPlaying = player?.isPlaying ?: true

            // Desvincular vista del player anterior para proteger el SurfaceView de TV
            playerView.player = null
            player?.stop()
            player?.release()
            player = null

            initExoPlayer()
            playerView.player = player

            val port = localStreamServer?.listeningPort ?: proxyServer?.listeningPort ?: 8080
            val url = currentPlayUrl ?: "http://127.0.0.1:$port/stream"
            pendingResumePositionMs = currentPos
            playUrl(url)

            if (!wasPlaying) {
                player?.pause()
            }

            Toast.makeText(
                this@PlayerActivity,
                if (forceSoftware) "🔊 Compatibilidad Estéreo activada (Audio FFmpeg por Software)" else "🔊 Modo Envolvente / 5.1 activado (Hardware)",
                Toast.LENGTH_SHORT
            ).show()
        }

        var selectedAudioView: View? = null
        var firstFocusableView: View? = null
        var audioCount = 0

        // Helper para nombres amigables de idioma
        fun formatLanguageName(langCode: String?): String {
            if (langCode.isNullOrBlank()) return ""
            return try {
                val loc = java.util.Locale.forLanguageTag(langCode)
                val display = loc.getDisplayLanguage(loc).ifBlank { loc.displayLanguage }
                if (display.isNotBlank()) display.replaceFirstChar { it.uppercase() } else langCode.uppercase()
            } catch (e: Exception) {
                langCode.uppercase()
            }
        }

        // --- 1. Pistas de Audio ---
        for (trackGroup in tracks.groups) {
            if (trackGroup.type == C.TRACK_TYPE_AUDIO) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    val langName = formatLanguageName(format.language)
                    val label = format.label?.trim() ?: ""
                    val name = when {
                        label.isNotBlank() && langName.isNotBlank() -> {
                            if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                        }
                        label.isNotBlank() -> label
                        langName.isNotBlank() -> langName
                        else -> "Pista de Audio ${audioCount + 1}"
                    }

                    // Badge de canales / códec
                    val badgeParts = mutableListOf<String>()
                    if (format.channelCount > 0) {
                        when (format.channelCount) {
                            6 -> badgeParts.add("5.1")
                            8 -> badgeParts.add("7.1")
                            2 -> badgeParts.add("Estéreo")
                            1 -> badgeParts.add("Mono")
                            else -> badgeParts.add("${format.channelCount} ch")
                        }
                    }
                    val mime = format.sampleMimeType ?: ""
                    when {
                        mime.contains("eac3", true) -> badgeParts.add("E-AC3")
                        mime.contains("ac3", true) -> badgeParts.add("AC3")
                        mime.contains("dts", true) -> badgeParts.add("DTS")
                        mime.contains("truehd", true) -> badgeParts.add("TrueHD")
                        mime.contains("flac", true) -> badgeParts.add("FLAC")
                        mime.contains("opus", true) -> badgeParts.add("Opus")
                        mime.contains("mp4a", true) || mime.contains("aac", true) -> badgeParts.add("AAC")
                    }
                    val badgeText = badgeParts.joinToString(" • ")

                    val isSelected = trackGroup.isTrackSelected(i)

                    val rowView = layoutInflater.inflate(R.layout.item_tv_track, containerAudio, false)
                    val tvIndicator = rowView.findViewById<TextView>(R.id.tv_track_indicator)
                    val tvName = rowView.findViewById<TextView>(R.id.tv_track_name)
                    val tvBadge = rowView.findViewById<TextView>(R.id.tv_track_badge)

                    tvName.text = name
                    if (badgeText.isNotBlank()) {
                        tvBadge.text = badgeText
                        tvBadge.visibility = View.VISIBLE
                    } else {
                        tvBadge.visibility = View.GONE
                    }

                    if (isSelected) {
                        tvIndicator.visibility = View.VISIBLE
                        selectedAudioView = rowView
                    } else {
                        tvIndicator.visibility = View.INVISIBLE
                    }

                    if (firstFocusableView == null) {
                        firstFocusableView = rowView
                    }

                    rowView.setOnClickListener {
                        p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                            .setOverrideForType(TrackSelectionOverride(trackGroup.mediaTrackGroup, i))
                            .build()
                        Toast.makeText(this@PlayerActivity, "🔊 Audio: $name", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }

                    containerAudio.addView(rowView)
                    audioCount++
                }
            }
        }

        if (audioCount == 0) {
            val emptyTv = TextView(this).apply {
                text = "Pista estándar activa"
                setTextColor(android.graphics.Color.parseColor("#888899"))
                textSize = 13f
                setPadding(dpToPx(12), dpToPx(8), dpToPx(12), dpToPx(8))
            }
            containerAudio.addView(emptyTv)
        }

        // --- 2. Pistas de Subtítulos ---
        val hasSelectedSub = tracks.groups.any { it.type == C.TRACK_TYPE_TEXT && it.isSelected }

        // Opción: "Desactivar"
        val rowDisableSub = layoutInflater.inflate(R.layout.item_tv_track, containerSubtitles, false)
        val tvDisableIndicator = rowDisableSub.findViewById<TextView>(R.id.tv_track_indicator)
        val tvDisableName = rowDisableSub.findViewById<TextView>(R.id.tv_track_name)
        val tvDisableBadge = rowDisableSub.findViewById<TextView>(R.id.tv_track_badge)
        tvDisableName.text = "Desactivar subtítulos"
        tvDisableBadge.visibility = View.GONE
        tvDisableIndicator.visibility = if (!hasSelectedSub) View.VISIBLE else View.INVISIBLE

        rowDisableSub.setOnClickListener {
            p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                .clearOverridesOfType(C.TRACK_TYPE_TEXT)
                .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                .build()
            Toast.makeText(this@PlayerActivity, "💬 Subtítulos desactivados", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        containerSubtitles.addView(rowDisableSub)

        var subCount = 0
        for (trackGroup in tracks.groups) {
            if (trackGroup.type == C.TRACK_TYPE_TEXT) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    val langName = formatLanguageName(format.language)
                    val label = format.label?.trim() ?: ""
                    val name = when {
                        label.isNotBlank() && langName.isNotBlank() -> {
                            if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                        }
                        label.isNotBlank() -> label
                        langName.isNotBlank() -> langName
                        else -> "Subtítulo ${subCount + 1}"
                    }

                    val badgeParts = mutableListOf<String>()
                    if ((format.selectionFlags and C.SELECTION_FLAG_DEFAULT) != 0) badgeParts.add("Predeterminado")
                    if ((format.selectionFlags and C.SELECTION_FLAG_FORCED) != 0) badgeParts.add("Forzado")
                    if ((format.roleFlags and C.ROLE_FLAG_DESCRIBES_VIDEO) != 0) badgeParts.add("SDH")
                    val badgeText = badgeParts.joinToString(" • ")

                    val isSelected = trackGroup.isTrackSelected(i)

                    val rowView = layoutInflater.inflate(R.layout.item_tv_track, containerSubtitles, false)
                    val tvIndicator = rowView.findViewById<TextView>(R.id.tv_track_indicator)
                    val tvName = rowView.findViewById<TextView>(R.id.tv_track_name)
                    val tvBadge = rowView.findViewById<TextView>(R.id.tv_track_badge)

                    tvName.text = name
                    if (badgeText.isNotBlank()) {
                        tvBadge.text = badgeText
                        tvBadge.visibility = View.VISIBLE
                    } else {
                        tvBadge.visibility = View.GONE
                    }

                    tvIndicator.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE

                    rowView.setOnClickListener {
                        p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                            .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, false)
                            .setOverrideForType(TrackSelectionOverride(trackGroup.mediaTrackGroup, i))
                            .build()
                        Toast.makeText(this@PlayerActivity, "💬 Subtítulos: $name", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }

                    containerSubtitles.addView(rowView)
                    subCount++
                }
            }
        }

        // --- 3. Botón Cerrar y Eventos ---
        btnClose.setOnClickListener { dialog.dismiss() }

        dialog.setOnDismissListener {
            showControls()
            btnTracks.post { btnTracks.requestFocus() }
            scheduleHideControls()
        }

        dialog.setOnShowListener {
            val viewToFocus = selectedAudioView ?: firstFocusableView ?: btnClose
            viewToFocus.post { viewToFocus.requestFocus() }
        }

        // Ajustar ancho óptimo para TV
        val displayWidth = resources.displayMetrics.widthPixels
        val targetWidth = (displayWidth * 0.85f).toInt().coerceAtMost(dpToPx(680))
        dialog.window?.setLayout(targetWidth, android.view.ViewGroup.LayoutParams.WRAP_CONTENT)

        dialog.show()
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * resources.displayMetrics.density).toInt()
    }

    // --- UI Controls ---
    private fun togglePlayPause() {
        val p = player ?: return
        if (p.isPlaying) p.pause() else p.play()
        showControls()
    }

    private fun toggleControls() {
        if (controlsVisible) hideControls() else showControls()
    }

    private fun showControls() {
        val wasHidden = !controlsVisible
        bottomBar.visibility = View.VISIBLE
        bottomBar.animate().alpha(1f).setDuration(200).start()
        centerControls.visibility = View.VISIBLE
        centerControls.animate().alpha(1f).setDuration(200).start()
        castContainer.visibility = View.VISIBLE
        castContainer.animate().alpha(1f).setDuration(200).start()
        controlsVisible = true
        
        if (wasHidden) {
            btnPlayPause.post { btnPlayPause.requestFocus() }
        }
        
        scheduleHideControls()
    }

    private fun hideControls() {
        bottomBar.animate().alpha(0f).setDuration(300).withEndAction { bottomBar.visibility = View.GONE }.start()
        centerControls.animate().alpha(0f).setDuration(300).withEndAction { centerControls.visibility = View.GONE }.start()
        castContainer.animate().alpha(0f).setDuration(300).withEndAction { castContainer.visibility = View.GONE }.start()
        controlsVisible = false
    }

    private fun scheduleHideControls() {
        controlsHandler.removeCallbacksAndMessages(null)
        controlsHandler.postDelayed({
            if (player?.isPlaying == true) hideControls()
        }, 4000)
    }

    private var _diagLoggedOnce = false

    private fun updateSeekBar() {
        if (player == null || isSeeking) return
        val time = player!!.currentPosition
        val duration = player!!.duration
        if (duration > 0 && duration != C.TIME_UNSET) {
            seekBar.max = duration.toInt()
            seekBar.progress = time.toInt()
            tvTimeCurrent.text = formatTime(time)
            tvTimeDuration.text = formatTime(duration)

            // Intro and Next Episode check
            val introStartMs = (intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "").toLongOrNull()
            val introEndMs   = (intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "").toLongOrNull()

            if (!introSkipped && introStartMs != null && introEndMs != null && introEndMs > introStartMs) {
                val isSeekable = player?.isCurrentMediaItemSeekable ?: true
                val inIntro = isSeekable && time in introStartMs until introEndMs
                if (inIntro) {
                    if (layoutSkipIntro.visibility != View.VISIBLE) {
                        layoutSkipIntro.visibility = View.VISIBLE
                        layoutSkipIntro.alpha = 0f
                        layoutSkipIntro.animate().alpha(1f).setDuration(300).start()
                        Log.i(TAG, "⏩ SHOWING Skip Intro overlay (time=$time in $introStartMs until $introEndMs)")
                        // Only steal focus if Next Episode is NOT already visible
                        if (layoutNextEpisode.visibility != View.VISIBLE) {
                            layoutSkipIntro.requestFocus()
                        }
                    }
                } else {
                    if (layoutSkipIntro.visibility == View.VISIBLE) {
                        layoutSkipIntro.animate().alpha(0f).setDuration(200).withEndAction {
                            layoutSkipIntro.visibility = View.GONE
                        }.start()
                    }
                }
            } else if (introSkipped && layoutSkipIntro.visibility == View.VISIBLE) {
                layoutSkipIntro.visibility = View.GONE
            }

            // Intro and Next Episode check
            val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
            if (contentId.startsWith("tv_")) {
                val creditsStartStr = intent.getStringExtra(EXTRA_CREDITS_START) ?: ""
                val creditsStartSeconds = creditsStartStr.toIntOrNull()
                // TheIntroDB credits fallback (already in ms)
                val introDbCreditsMs = (intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "").toLongOrNull()

                val shouldShow: Boolean
                val secondsLeft: Int

                if (creditsStartSeconds != null) {
                    // Priority 1: Manual credits trigger (value is in seconds)
                    val creditsStartMs = creditsStartSeconds * 1000L
                    shouldShow = time >= creditsStartMs
                    secondsLeft = if (time < duration) ((duration - time) / 1000).toInt() else 0
                } else if (introDbCreditsMs != null && introDbCreditsMs > 0) {
                    // Priority 2: TheIntroDB credits (value is in ms)
                    shouldShow = time >= introDbCreditsMs
                    secondsLeft = if (time < duration) ((duration - time) / 1000).toInt() else 0
                } else {
                    // Fallback: last 30 seconds
                    val timeLeft = duration - time
                    shouldShow = timeLeft in 1000..30000
                    secondsLeft = (timeLeft / 1000).toInt()
                }

                if (shouldShow) {
                    if (layoutNextEpisode.visibility != View.VISIBLE) {
                        layoutNextEpisode.visibility = View.VISIBLE
                        layoutNextEpisode.alpha = 0f
                        layoutNextEpisode.animate().alpha(1f).setDuration(300).start()
                        layoutNextEpisode.requestFocus()
                        Log.i(TAG, "▶️ SHOWING Next Episode overlay (time=$time, secondsLeft=$secondsLeft)")
                        // Hide skip intro if next episode appears (avoid visual clash)
                        if (layoutSkipIntro.visibility == View.VISIBLE) {
                            layoutSkipIntro.visibility = View.GONE
                        }
                    }
                    tvNextEpisodeCountdown.text = "Siguiente en ${secondsLeft}s"

                    // Auto-advance if countdown expires or video ends
                    if (secondsLeft <= 0 && !nextEpisodeTriggered && duration > 30_000L) {
                        nextEpisodeTriggered = true
                        Log.i(TAG, "▶️ Next Episode countdown reached 0s, auto-triggering next episode")
                        triggerNextEpisode()
                    }
                } else {
                    if (layoutNextEpisode.visibility == View.VISIBLE) {
                        layoutNextEpisode.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun startSeekBarUpdater() {
        seekBarHandler.removeCallbacksAndMessages(null)
        val updater = object : Runnable {
            override fun run() {
                updateSeekBar()
                seekBarHandler.postDelayed(this, 1000)
            }
        }
        seekBarHandler.postDelayed(updater, 1000)
    }

    private fun formatTime(ms: Long): String {
        val totalSec = ms / 1000
        val hours = totalSec / 3600
        val minutes = (totalSec % 3600) / 60
        val seconds = totalSec % 60
        return if (hours > 0) String.format("%d:%02d:%02d", hours, minutes, seconds)
        else String.format("%02d:%02d", minutes, seconds)
    }

    private fun showTitle(title: String) {
        if (title.isNotEmpty()) {
            tvVideoTitle.text = title
            tvVideoTitle.alpha = 0f
            tvVideoTitle.visibility = View.VISIBLE
            tvVideoTitle.animate().alpha(1f).setDuration(400).start()
            
            titleHandler.removeCallbacksAndMessages(null)
            titleHandler.postDelayed({
                tvVideoTitle.animate().alpha(0f).setDuration(500).withEndAction { 
                    tvVideoTitle.visibility = View.GONE 
                }.start()
            }, 2000)
        }
    }

    private fun triggerNextEpisode() {
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""

        if (contentId.startsWith("tv_")) {
            val resultIntent = Intent().apply {
                putExtra("next_episode", true)
                putExtra("content_id", contentId)
                putExtra("season", season.toIntOrNull() ?: 1)
                putExtra("episode", episode.toIntOrNull() ?: 1)
            }
            setResult(RESULT_OK, resultIntent)
        }
        finish()
    }

    private fun seekRelative(deltaMs: Long) {
        val p = player ?: return
        val current = p.currentPosition
        val duration = p.duration
        if (duration <= 0 || duration == C.TIME_UNSET) return
        val target = Math.max(0, Math.min(current + deltaMs, duration))
        p.seekTo(target)
        updateSeekBar()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val p = player ?: return super.onKeyDown(keyCode, event)

        if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE) {
            togglePlayPause()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_FAST_FORWARD) {
            seekRelative(10000)
            showControls()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_REWIND) {
            seekRelative(-10000)
            showControls()
            return true
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (!controlsVisible) {
                seekRelative(-10000)
                showControls()
                return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (!controlsVisible) {
                seekRelative(10000)
                showControls()
                return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            if (!controlsVisible) {
                togglePlayPause()
            } else {
                scheduleHideControls()
                return super.onKeyDown(keyCode, event)
            }
            return true
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_UP || keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (!controlsVisible) {
                showControls()
                return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (controlsVisible) {
                hideControls()
                return true
            }
            finish()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            toggleControls()
            return true
        }
        return super.onTouchEvent(event)
    }

    // --- Cast ---
    private fun setupCastButton() {
        try {
            castContext = CastContext.getSharedInstance(this)
            sessionManager = castContext?.sessionManager

            val btn = MediaRouteButton(this)
            castButton = btn
            btn.setAlwaysVisible(true)
            
            val castDrawable = androidx.core.content.ContextCompat.getDrawable(this, androidx.mediarouter.R.drawable.mr_button_light)
            castDrawable?.setTint(android.graphics.Color.WHITE)
            btn.setRemoteIndicatorDrawable(castDrawable)
            CastButtonFactory.setUpMediaRouteButton(this, btn)

            castContainer.addView(btn, FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT))
        } catch (e: Exception) {
            Log.e(TAG, "Cast SDK Error: ${e.message}", e)
        }
    }

    private fun setupCastSessionListener() {
        val sm = sessionManager ?: return
        val url = castStreamUrl ?: return

        castSessionListener = object : SessionManagerListener<CastSession> {
            override fun onSessionStarting(session: CastSession) {}
            override fun onSessionStartFailed(session: CastSession, error: Int) {
                Toast.makeText(this@PlayerActivity, "Error al conectar con Chromecast", Toast.LENGTH_SHORT).show()
            }
            override fun onSessionStarted(session: CastSession, sessionId: String) {
                isCasting = true
                player?.pause()

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
                Toast.makeText(this@PlayerActivity, "Enviando a Chromecast...", Toast.LENGTH_SHORT).show()
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
                isCasting = false
                player?.play()
                Toast.makeText(this@PlayerActivity, "Reproducción local reanudada", Toast.LENGTH_SHORT).show()
            }
        }

        sm.addSessionManagerListener(castSessionListener!!, CastSession::class.java)
    }

    private fun getWifiIpAddress(): String? {
        return try {
            val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
            val ip = wifiManager.connectionInfo.ipAddress
            if (ip == 0) return null
            String.format("%d.%d.%d.%d", ip and 0xff, ip shr 8 and 0xff, ip shr 16 and 0xff, ip shr 24 and 0xff)
        } catch (e: Exception) { null }
    }

    // --- Lifecycle & Progress ---
    override fun onResume() {
        super.onResume()
        hideSystemUI()
        if (wasPlaying) {
            player?.play()
        }
    }

    private fun hideSystemUI() {
        val wic = WindowCompat.getInsetsController(window, window.decorView)
        wic.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        wic.hide(WindowInsetsCompat.Type.systemBars())
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_FULLSCREEN
        )
    }

    override fun onPause() {
        super.onPause()
        wasPlaying = player?.isPlaying == true
        if (wasPlaying) {
            player?.pause()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("savedPosition", player?.currentPosition ?: 0L)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedPosition = savedInstanceState.getLong("savedPosition", 0L)
    }

    @Volatile
    private var isCleanedUp = false

    override fun onStop() {
        super.onStop()
        if (isFinishing) {
            cleanup()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        titleHandler.removeCallbacksAndMessages(null)
        controlsHandler.removeCallbacksAndMessages(null)
        seekBarHandler.removeCallbacksAndMessages(null)

        cleanup()
    }

    private fun cleanup() {
        if (isCleanedUp) return
        isCleanedUp = true

        val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        
        var finalPosition = -1L
        var finalDuration = 0L
        try {
            finalPosition = player?.currentPosition ?: -1L
            finalDuration = player?.duration ?: 0L
        } catch (e: Exception) {}

        try {
            castSessionListener?.let { sessionManager?.removeSessionManagerListener(it, CastSession::class.java) }
        } catch (_: Exception) {}

        try { proxyServer?.stop() } catch (_: Exception) {}
        proxyServer = null
        try { localStreamServer?.stop() } catch (_: Exception) {}
        localStreamServer = null

        try {
            player?.stop()
            player?.clearMediaItems()
        } catch (_: Exception) {}

        try {
            player?.release()
        } catch (e: Exception) {
            Log.w(TAG, "Exception during player.release(): ${e.message}")
        }
        player = null
        com.cineflix.android.GramJSStreamManager.currentPlaybackId = ""
        scope.cancel()

        val engine = TelegramEngine.getInstance(this)
        val fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (fileId > 0) {
            engine.cancelAndDeleteVideo(fileId)
        }
        multipartParts?.forEach { part ->
            engine.cancelAndDeleteVideo(part.fileId)
        }
        engine.optimizeStorage(30L * 1024 * 1024, immunityDelaySec = 0) // Safe: playback ended, full cleanup

        if (phone.isNotEmpty() && contentId.isNotEmpty() && finalPosition > 0) {
            CoroutineScope(Dispatchers.IO).launch {
                sendProgressPingDirect(phone, contentId, season, episode, finalPosition, finalDuration)
            }
        }
    }

    private fun startProgressTracking(phone: String, contentId: String, season: String, episode: String) {
        scope.launch {
            while (isActive) {
                delay(30_000)
                try {
                    val currentPos = player?.currentPosition ?: -1L
                    val durationMs = player?.duration ?: 0L
                    sendProgressPingDirect(phone, contentId, season, episode, currentPos, durationMs)
                } catch (e: Exception) {}
            }
        }
    }

    private suspend fun sendProgressPingDirect(phone: String, contentId: String, season: String, episode: String, currentPosition: Long, durationMs: Long) {
        if (currentPosition <= 0) return
        val progressSeconds = (currentPosition / 1000).toInt()
        val isFinished = durationMs > 0 && currentPosition >= (durationMs - 5000)

        withContext(Dispatchers.IO) {
            try {
                // Bypass SSL for older Android TV boxes with expired Let's Encrypt roots
                val trustAllCerts = arrayOf<javax.net.ssl.TrustManager>(object : javax.net.ssl.X509TrustManager {
                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? = null
                    override fun checkClientTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun checkServerTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {}
                })
                val sc = javax.net.ssl.SSLContext.getInstance("SSL")
                sc.init(null, trustAllCerts, java.security.SecureRandom())
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
                val allHostsValid = javax.net.ssl.HostnameVerifier { _, _ -> true }

                val url = java.net.URL("https://cineflixapp.duckdns.org/api/progress")
                val conn = url.openConnection() as javax.net.ssl.HttpsURLConnection
                conn.hostnameVerifier = allHostsValid
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                conn.setRequestProperty("x-user-phone", phone)
                conn.doOutput = true

                val json = org.json.JSONObject().apply {
                    val seasonVal: Any = season.toIntOrNull() ?: org.json.JSONObject.NULL
                    val episodeVal: Any = episode.toIntOrNull() ?: org.json.JSONObject.NULL
                    put("content_id", contentId)
                    put("season", seasonVal)
                    put("episode", episodeVal)
                    put("progress_seconds", progressSeconds)
                    put("is_finished", isFinished)
                }

                conn.outputStream.use { os ->
                    val input = json.toString().toByteArray(Charsets.UTF_8)
                    os.write(input, 0, input.size)
                }
                val responseCode = conn.responseCode
                android.util.Log.d("PROGRESS", "POST contentId=$contentId position=$progressSeconds response=$responseCode")
                conn.disconnect()
            } catch (e: Exception) {
                android.util.Log.e("PROGRESS", "POST error", e)
            }
        }
    }

    private suspend fun fetchSavedProgress(phone: String, contentId: String, season: String, episode: String): Int {
        return withContext(Dispatchers.IO) {
            try {
                // Bypass SSL for older Android TV boxes with expired Let's Encrypt roots
                val trustAllCerts = arrayOf<javax.net.ssl.TrustManager>(object : javax.net.ssl.X509TrustManager {
                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate>? = null
                    override fun checkClientTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun checkServerTrusted(certs: Array<java.security.cert.X509Certificate>, authType: String) {}
                })
                val sc = javax.net.ssl.SSLContext.getInstance("SSL")
                sc.init(null, trustAllCerts, java.security.SecureRandom())
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
                val allHostsValid = javax.net.ssl.HostnameVerifier { _, _ -> true }

                val url = java.net.URL("https://cineflixapp.duckdns.org/api/progress")
                val conn = url.openConnection() as javax.net.ssl.HttpsURLConnection
                conn.hostnameVerifier = allHostsValid
                conn.requestMethod = "GET"
                conn.setRequestProperty("x-user-phone", phone)
                conn.connectTimeout = 5000
                conn.readTimeout = 5000

                val responseCode = conn.responseCode
                if (responseCode == 200) {
                    val body = conn.inputStream.bufferedReader().readText()
                    android.util.Log.d("PROGRESS", "GET response=$body")
                    val arr = org.json.JSONArray(body)
                    for (i in 0 until arr.length()) {
                        val obj = arr.getJSONObject(i)
                        val matchesContent = obj.getString("content_id") == contentId
                        val objSeason = if (obj.isNull("season")) "" else obj.getInt("season").toString()
                        val objEpisode = if (obj.isNull("episode")) "" else obj.getInt("episode").toString()
                        if (matchesContent && objSeason == season && objEpisode == episode) {
                            return@withContext obj.optInt("progress", 0)
                        }
                    }
                }
                0
            } catch (e: Exception) {
                android.util.Log.e("PROGRESS", "GET error", e)
                0
            }
        }
    }
}