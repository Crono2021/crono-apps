package com.cineflix.android.ui.player

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
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
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.cineflix.android.TelegramEngine
import com.cineflix.android.R
import com.cineflix.android.ui.player.cast.CastSessionCoordinator
import com.cineflix.android.ui.player.cast.DlnaCastController
import com.cineflix.android.ui.player.cast.DlnaDevice
import com.cineflix.android.ui.player.cast.LanNetworkUtils
import com.cineflix.android.ui.player.cast.MatroskaEbmlTrackPatcher
import com.cineflix.android.ui.player.cast.UnifiedTvDevice
import com.cineflix.android.ui.player.cast.UnifiedTvDiscoveryManager
import com.google.android.gms.cast.MediaInfo
import com.google.android.gms.cast.MediaLoadRequestData
import com.google.android.gms.cast.MediaMetadata
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManager
import com.google.android.gms.cast.framework.SessionManagerListener
import androidx.mediarouter.media.MediaRouter
import kotlinx.coroutines.*

// Media3
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.Timeline
import androidx.media3.common.TrackSelectionOverride
import androidx.media3.common.Tracks
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView

private typealias CachedTrackOption = CastSessionCoordinator.CastTrackOption

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
    private lateinit var btnCastUnified: ImageButton
    private lateinit var btnCastBottom: ImageButton
    private lateinit var layoutCastStatusCard: LinearLayout
    private lateinit var tvCastActiveTitle: TextView
    private lateinit var tvCastActiveSubtitle: TextView
    private lateinit var btnCastCardCatalog: TextView
    private lateinit var btnCastCardSwitch: TextView
    private lateinit var btnCastCardStop: TextView
    private lateinit var layoutNextEpisode: LinearLayout
    private lateinit var tvNextEpisodeCountdown: TextView
    private lateinit var layoutSkipIntro: LinearLayout

    private val titleHandler = Handler(Looper.getMainLooper())
    private val controlsHandler = Handler(Looper.getMainLooper())
    private val seekBarHandler = Handler(Looper.getMainLooper())
    private val seekDebounceHandler = Handler(Looper.getMainLooper())
    private var pendingSeekTargetMs: Long? = null
    private val seekDebounceRunnable = Runnable {
        val target = pendingSeekTargetMs ?: return@Runnable
        pendingSeekTargetMs = null
        Log.i(TAG, "Debounced seek executing: target=${target}ms (current=${getCurrentEffectivePositionMs()}ms, cast=${isAnyCastActive()})")
        com.cineflix.android.util.ErrorLogCollector.log("Player", "Debounced seek executed to ${target}ms")
        performEffectiveSeek(target)
    }

    private var controlsVisible = false
    private var isSeeking = false
    private var currentScaleIndex = 0
    private var wasPlaying = false
    private var savedPosition = 0L
    private var pendingResumePositionMs: Long? = null
    private var introSkipped = false
    private var nextEpisodeTriggered = false
    private var currentEffectiveFileSize: Long = 0L
    private var lastKnownLocalDurationMs: Long = 0L
    private var ioErrorRetryCount = 0
    private var lastIoErrorTimeMs = 0L

    // Unified Cast (Google Cast + Native DLNA Smart TVs: Samsung Tizen, LG webOS, Sony, Hisense, Roku)
    private var castContext: CastContext? = null
    private var sessionManager: SessionManager? = null
    private var castStreamUrl: String? = null
    private var currentMimeType: String = "video/mp4"
    private var currentTitle: String = ""
    private var castSessionListener: SessionManagerListener<CastSession>? = null
    private var isGoogleCasting = false
    private var isDlnaCasting = false
    private var activeCastDeviceId: String? = null
    private var activeCastTvName: String = ""
    private var lastCastPositionMs: Long = 0L
    private var pendingGoogleCastStartMs: Long = 0L
    private var pendingGoogleCastRouteAfterEnd: MediaRouter.RouteInfo? = null
    private var suppressLocalResumeOnCastEnd = false
    private var unifiedTvDiscovery: UnifiedTvDiscoveryManager? = null
    private val dlnaController: DlnaCastController
        get() = CastSessionCoordinator.dlnaController
    private var castUiListener: CastSessionCoordinator.PlayerUiListener? = null
    private var activeCastDialog: android.app.Dialog? = null
    private var castWakeLock: PowerManager.WakeLock? = null
    private var castWifiLock: WifiManager.WifiLock? = null
    private var storedSevenZipArchive = false
    private var isDetachingKeepCastAlive = false
    private var localProgressTrackingStarted = false


    private var cachedAudioOptions: List<CachedTrackOption> = emptyList()
    private var cachedSubtitleOptions: List<CachedTrackOption> = emptyList()
    private var exoCurrentlySelectedAudioOrdinal: Int? = null
    private var exoCurrentlySelectedSubtitleOrdinal: Int? = null

    private var userSelectedAudioOrdinal: Int? = null
    private var userSelectedAudioTrackNum: Int? = null
    private var lastWorkingCastAudioOrdinal: Int? = null
    private var lastWorkingCastAudioTrackNum: Int? = null
    private var userSubtitleMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode =
        MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
    private var userSelectedSubtitleOrdinal: Int? = null
    private var userSelectedSubtitleTrackNum: Int? = null
    private var isApplyingStoredExoTrackOverrides = false
    private var forceCastStereoSession = false

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
        const val EXTRA_ATTACH_ACTIVE_CAST   = "attach_active_cast"

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

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isAnyCastActive()) {
                    returnToCatalogWhileCasting()
                } else {
                    finish()
                }
            }
        })

        val multipartJson = intent.getStringExtra(EXTRA_MULTIPART_JSON)
        var storedSevenZip = false
        if (!multipartJson.isNullOrEmpty()) {
            try {
                val partsArray = org.json.JSONArray(multipartJson)
                val parts = mutableListOf<FilePart>()
                var totalPartsSize = 0L
                for (i in 0 until partsArray.length()) {
                    val obj = partsArray.getJSONObject(i)
                    val archive = obj.optString("archive", "")
                    require(archive == "" || archive == "7z-copy") { "Formato de archivo no compatible" }
                    if (i == 0) storedSevenZip = archive == "7z-copy"
                    require(storedSevenZip == (archive == "7z-copy")) { "Partes de formatos diferentes" }
                    require(obj.getInt("fileId") > 0 && obj.getLong("size") > 0) { "Parte no válida" }
                    require(obj.getLong("size") <= Long.MAX_VALUE - totalPartsSize) { "Tamaño excesivo" }
                    totalPartsSize += obj.getLong("size")
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

        storedSevenZipArchive = storedSevenZip
        currentMimeType = mimeType
        currentTitle = title
        currentFileId = fileId
        forceCastStereoSession = false
        getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("force_software_audio", false)
            .apply()

        val attachRequested = intent.getBooleanExtra(EXTRA_ATTACH_ACTIVE_CAST, false)
        if (CastSessionCoordinator.isCastingActive &&
            (attachRequested || CastSessionCoordinator.isSameActiveMedia(fileId, multipartParts))
        ) {
            val activeServer = CastSessionCoordinator.activeStreamServer
            val activeMedia = CastSessionCoordinator.activeMedia
            if (activeServer != null && activeMedia != null && activeServer.listeningPort > 0) {
                attachToRunningCastSession(activeServer, activeMedia)
                return
            }
        }

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
        var resolvedFileSize = fileSize
        if (fileId <= 0) {
            val chatId = intent.getLongExtra(EXTRA_CHAT_ID, 0L)
            val msgId  = intent.getLongExtra(EXTRA_MSG_ID, 0L)
            if (chatId != 0L && msgId != 0L) {
                Log.w(TAG, "⚠️ fileId was <= 0, attempting native TDLib resolution for chatId=$chatId, msgId=$msgId...")
                val resolved = kotlinx.coroutines.runBlocking {
                    engine.resolveFileIdForMessage(chatId, msgId)
                }
                if (resolved != null && resolved.first > 0) {
                    fileId = resolved.first
                    currentFileId = fileId
                    if (resolvedFileSize <= 0 && resolved.second > 0) {
                        resolvedFileSize = resolved.second
                    }
                    Log.i(TAG, "✅ Successfully resolved fileId=$fileId (size=$resolvedFileSize) from TDLib for msgId=$msgId")
                }
            }
        }

        if (fileId <= 0) {
            Toast.makeText(this, "Error: fileId inválido ($fileId)", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        if (resolvedFileSize <= 0L && multipartParts.isNullOrEmpty()) {
            val tdSize = kotlinx.coroutines.runBlocking {
                engine.resolveFileSizeForFileId(fileId)
            }
            if (tdSize > 0L) {
                resolvedFileSize = tdSize
                Log.i(TAG, "📏 Resolved exact TDLib file size for fileId=$fileId: $resolvedFileSize bytes")
            }
        }

        var effectiveFileSize = resolvedFileSize
        if (effectiveFileSize <= 0) {
            effectiveFileSize = 2_000_000_000L
        }
        currentEffectiveFileSize = multipartParts?.sumOf { it.size }?.takeIf { it > 0 } ?: effectiveFileSize
        introSkipped = false
        nextEpisodeTriggered = false

        val autoContinueCastTarget: CastSessionCoordinator.AutoContinueCastTarget? =
            if (CastSessionCoordinator.isCastingActive &&
                !CastSessionCoordinator.isSameActiveMedia(fileId, multipartParts)
            ) {
                Log.i(TAG, "🔄 Switching active TV cast to newly selected catalog movie: title=$title fileId=$fileId")
                CastSessionCoordinator.prepareForMovieReplacement(this, fileId, multipartParts)
            } else {
                null
            }

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
                multipartParts = multipartParts,
                storedSevenZip = storedSevenZip,
                archiveError = { message -> runOnUiThread {
                    if (!isFinishing && !isDestroyed) {
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                        finish()
                    }
                } }
            )
            localStreamServer = lss
            localStreamUrl = lssUrl
            port = lss.listeningPort
            Log.i(TAG, "✨ LocalStreamServer iniciado para reproducción: $localStreamUrl en puerto $port")
            prewarmMatroskaTrackCatalog(lss)
        }
        currentPlayUrl = localStreamUrl
        val wifiIp = LanNetworkUtils.getBestLanIpv4(this)
        castStreamUrl = if (wifiIp != null && !isGramJsActive && port > 0) "http://$wifiIp:$port/stream/cast.mp4" else null
        
        setupUnifiedCastEngine()

        // 4. Iniciar ExoPlayer
        initExoPlayer()

        // 5. Apply progress and start tracking (or auto-cast onto already-connected TV)
        val p = jsProgress?.toFloatOrNull()?.toInt() ?: 0
        if (autoContinueCastTarget != null) {
            loadingSpinner.visibility = View.VISIBLE
            startSeekBarUpdater()
            if (p > 5) {
                startNewMovieOnConnectedTv(autoContinueCastTarget, p * 1000L)
            } else if (phone.isNotEmpty() && contentId.isNotEmpty()) {
                scope.launch {
                    val savedProgress = try {
                        fetchSavedProgress(phone, contentId, season, episode)
                    } catch (_: Exception) {
                        0
                    }
                    withContext(Dispatchers.Main) {
                        val resumeMs = if (savedProgress > 5) savedProgress * 1000L else 0L
                        startNewMovieOnConnectedTv(autoContinueCastTarget, resumeMs)
                    }
                }
            } else {
                startNewMovieOnConnectedTv(autoContinueCastTarget, 0L)
            }
        } else if (p > 5) {
            val resumeMs = p * 1000L
            pendingResumePositionMs = resumeMs
            playUrl(localStreamUrl, resumeMs)
            Toast.makeText(this@PlayerActivity, "Reanudado en ${p/60}m", Toast.LENGTH_SHORT).show()
        } else if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            scope.launch {
                try {
                    val savedProgress = fetchSavedProgress(phone, contentId, season, episode)
                    withContext(Dispatchers.Main) {
                        if (savedProgress > 5) {
                            val resumeMs = savedProgress * 1000L
                            pendingResumePositionMs = resumeMs
                            playUrl(localStreamUrl, resumeMs)
                            Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress/60}m", Toast.LENGTH_SHORT).show()
                        } else {
                            playUrl(localStreamUrl, 0L)
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) { playUrl(localStreamUrl, 0L) }
                }
            }
        } else {
            playUrl(localStreamUrl, 0L)
        }

        ensureLocalProgressTrackingStarted(phone, contentId, season, episode)

        showTitle(title)
        scheduleHideControls()
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
        btnCastUnified = findViewById(R.id.btn_cast_unified)
        btnCastBottom = findViewById(R.id.btn_cast_bottom)
        layoutCastStatusCard = findViewById(R.id.layout_cast_status_card)
        tvCastActiveTitle = findViewById(R.id.tv_cast_active_title)
        tvCastActiveSubtitle = findViewById(R.id.tv_cast_active_subtitle)
        btnCastCardCatalog = findViewById(R.id.btn_cast_card_catalog)
        btnCastCardSwitch = findViewById(R.id.btn_cast_card_switch)
        btnCastCardStop = findViewById(R.id.btn_cast_card_stop)
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
        btnCastUnified.setOnClickListener { showUnifiedCastDialog() }
        btnCastBottom.setOnClickListener { showUnifiedCastDialog() }
        btnCastCardCatalog.setOnClickListener { returnToCatalogWhileCasting() }
        btnCastCardSwitch.setOnClickListener { showUnifiedCastDialog() }
        btnCastCardStop.setOnClickListener { disconnectCastAndResumeLocally() }
        btnReportError.setOnClickListener {
            val currentPos = getCurrentEffectivePositionMs()
            val duration = getCurrentEffectiveDurationMs()
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
        setupFocusAnimation(btnCastBottom)
        setupFocusAnimation(btnCastUnified)
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
                if (!fromUser) return
                tvTimeCurrent.text = formatTime(progress.toLong())
                if (!isSeeking) {
                    // Triggered via D-Pad / keyboard navigation while SeekBar has focus
                    executeOrDebounceSeek(progress.toLong(), debounceMs = 400L)
                }
            }
            override fun onStartTrackingTouch(bar: SeekBar) {
                isSeeking = true
                seekDebounceHandler.removeCallbacks(seekDebounceRunnable)
                pendingSeekTargetMs = null
                controlsHandler.removeCallbacksAndMessages(null)
            }
            override fun onStopTrackingTouch(bar: SeekBar) {
                isSeeking = false
                val target = bar.progress.toLong()
                seekDebounceHandler.removeCallbacks(seekDebounceRunnable)
                pendingSeekTargetMs = null
                com.cineflix.android.util.ErrorLogCollector.log("Player", "User seek (touch release) to ${target}ms")
                performEffectiveSeek(target)
                scheduleHideControls()
            }
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
                performEffectiveSeek(targetSeek)
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

        val renderersFactory = CineflixRenderersFactory(this) {
            getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE).getBoolean("force_software_audio", false)
        }
            .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
            .setEnableDecoderFallback(true)
            .setMediaCodecSelector(androidx.media3.exoplayer.mediacodec.MediaCodecSelector.DEFAULT)

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

        // Siempre empezar con los subtítulos desactivados tanto en reproducción local como emitiendo
        if (userSubtitleMode != MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE) {
            p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                .clearOverridesOfType(C.TRACK_TYPE_TEXT)
                .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                .build()
        }

        player = p
            
        playerView.player = player
        playerView.useController = false

        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (isAnyCastActive()) return
                val stateStr = when (playbackState) {
                    Player.STATE_IDLE -> "IDLE"
                    Player.STATE_BUFFERING -> "BUFFERING"
                    Player.STATE_READY -> "READY"
                    Player.STATE_ENDED -> "ENDED"
                    else -> "UNKNOWN($playbackState)"
                }
                Log.i("StreamPlayback", "state=$stateStr positionMs=${player?.currentPosition} bufferMs=${player?.totalBufferedDuration}")
                com.cineflix.android.util.ErrorLogCollector.log("Player", "state=$stateStr pos=${player?.currentPosition}ms buf=${player?.totalBufferedDuration}ms")
                if (playbackState == Player.STATE_BUFFERING) {
                    loadingSpinner.visibility = View.VISIBLE
                } else {
                    loadingSpinner.visibility = View.GONE
                    if (playbackState == Player.STATE_READY) {
                        ioErrorRetryCount = 0
                        val dur = player?.duration ?: 0L
                        if (dur > 0L && dur != C.TIME_UNSET) {
                            lastKnownLocalDurationMs = dur
                            CastSessionCoordinator.updateKnownDurationMs(dur)
                        }
                        tryApplyPendingResumeSeek()
                    }

                    if (playbackState == Player.STATE_ENDED) {
                        val dur = player?.duration ?: 0L
                        val pos = player?.currentPosition ?: 0L
                        // Only auto-trigger next episode if playback actually reached near the end of the video
                        if (dur > 30_000L && pos >= dur - 15_000L && !nextEpisodeTriggered) {
                            nextEpisodeTriggered = true
                            com.cineflix.android.util.ErrorLogCollector.log("Player", "Auto next episode triggered at pos=$pos/$dur")
                            triggerNextEpisode()
                        }
                    }
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                if (isAnyCastActive()) return
                Log.i("StreamPlayback", "playing=$isPlaying positionMs=${player?.currentPosition} bufferMs=${player?.totalBufferedDuration}")
                com.cineflix.android.util.ErrorLogCollector.log("Player", "isPlaying=$isPlaying pos=${player?.currentPosition}ms")
                if (isPlaying) {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
                    scheduleHideControls()
                } else {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
                }
            }

            override fun onTimelineChanged(timeline: Timeline, reason: Int) {
                if (isAnyCastActive()) return
                val dur = player?.duration ?: 0L
                if (dur > 0L && dur != C.TIME_UNSET) {
                    lastKnownLocalDurationMs = dur
                    CastSessionCoordinator.updateKnownDurationMs(dur)
                }
                tryApplyPendingResumeSeek()
            }

            override fun onTracksChanged(tracks: Tracks) {
                if (isAnyCastActive()) return
                snapshotExoTracksCatalog(tracks)
                applyStoredTrackOverridesToExoPlayerIfNeeded(tracks)
                syncTrackSelectionToStreamServer()
            }

            override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                if (isFinishing || isDestroyed || isCleanedUp || isAnyCastActive()) {
                    Log.w(TAG, "Ignoring onPlayerError during activity teardown/cleanup/casting: ${error.message}")
                    return
                }
                Log.e(TAG, "onPlayerError: ${error.errorCodeName} - ${error.message}", error)
                com.cineflix.android.util.ErrorLogCollector.log("Player", "ERROR: ${error.errorCodeName} - ${error.message}")
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
    private fun tryApplyPendingResumeSeek() {
        val resumePos = pendingResumePositionMs ?: return
        val p = player ?: return
        if (p.playbackState != Player.STATE_READY && p.playbackState != Player.STATE_BUFFERING) return
        val current = p.currentPosition.coerceAtLeast(0L)
        if (kotlin.math.abs(current - resumePos) <= 4000L) {
            pendingResumePositionMs = null
            Log.i(TAG, "▶ Local player already at resume position ${current}ms (target=${resumePos}ms)")
            return
        }
        if (p.isCurrentMediaItemSeekable) {
            pendingResumePositionMs = null
            Log.i(TAG, "▶ Seeking local player to resume position ${resumePos}ms (current=${current}ms)")
            com.cineflix.android.util.ErrorLogCollector.log("Player", "Resume seek to ${resumePos}ms (current=${current}ms)")
            p.seekTo(resumePos)
        } else if (p.playbackState == Player.STATE_READY) {
            Log.w(TAG, "▶ STATE_READY awaiting seek index for pendingResumePositionMs=${resumePos}ms")
        }
    }

    private fun playUrl(url: String, startPositionMs: Long = pendingResumePositionMs ?: 0L) {
        currentPlayUrl = url
        loadingSpinner.visibility = View.VISIBLE
        val safeStartMs = startPositionMs.coerceAtLeast(0L)
        if (safeStartMs > 0L) {
            pendingResumePositionMs = safeStartMs
        } else {
            pendingResumePositionMs = null
        }

        val engine = TelegramEngine.getInstance(this)
        val mediaItem = androidx.media3.common.MediaItem.fromUri(android.net.Uri.parse(url))

        val mediaSource = if (url.startsWith("tdlib://")) {
            val intentPlaybackId = intent.getStringExtra("EXTRA_PLAYBACK_ID")
            val currentPlaybackId = com.cineflix.android.GramJSStreamManager.currentPlaybackId
            val playbackId = intentPlaybackId ?: currentPlaybackId

            val dataSourceFactory: androidx.media3.datasource.DataSource.Factory = if (playbackId.isNotEmpty()) {
                GramJSDataSourceFactory(playbackId, 0)
            } else {
                TdlibDataSourceFactory(engine, multipartParts)
            }
            androidx.media3.exoplayer.source.DefaultMediaSourceFactory(dataSourceFactory)
                .createMediaSource(mediaItem)
        } else {
            val httpDataSourceFactory = androidx.media3.datasource.DefaultHttpDataSource.Factory()
                .setConnectTimeoutMs(15000)
                .setReadTimeoutMs(25000)
                .setAllowCrossProtocolRedirects(true)
            androidx.media3.exoplayer.source.DefaultMediaSourceFactory(httpDataSourceFactory)
                .createMediaSource(mediaItem)
        }

        if (safeStartMs > 0L) {
            Log.i(TAG, "▶ Preparing local ExoPlayer directly at startPositionMs=${safeStartMs}ms")
            player?.setMediaSource(mediaSource, safeStartMs)
        } else {
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

    private fun formatLanguageName(langCode: String?): String {
        if (langCode.isNullOrBlank()) return ""
        return try {
            val loc = java.util.Locale.forLanguageTag(langCode)
            val display = loc.getDisplayLanguage(loc).ifBlank { loc.displayLanguage }
            if (display.isNotBlank()) display.replaceFirstChar { it.uppercase() } else langCode.uppercase()
        } catch (e: Exception) {
            langCode.uppercase()
        }
    }

    private fun prewarmMatroskaTrackCatalog(lss: LocalStreamServer) {
        lss.onDurationDiscovered = { discoveredMs ->
            if (discoveredMs > 0L) {
                Handler(Looper.getMainLooper()).post {
                    if (!isFinishing && !isDestroyed) {
                        lastKnownLocalDurationMs = discoveredMs
                        CastSessionCoordinator.updateKnownDurationMs(discoveredMs)
                        updateSeekBar()
                    }
                }
            }
        }
        scope.launch {
            val mkvInfo = lss.getOrParseMatroskaHeaderInfo() ?: return@launch
            val fallbackAudios = mkvInfo.audioTracks.mapIndexed { idx, t ->
                val langName = formatLanguageName(t.language)
                val label = t.name.trim()
                val name = when {
                    label.isNotBlank() && langName.isNotBlank() ->
                        if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                    label.isNotBlank() -> label
                    langName.isNotBlank() -> langName
                    else -> "Pista de Audio ${idx + 1}"
                }
                CachedTrackOption(
                    ordinal = idx,
                    matroskaTrackNumber = t.trackNumber.takeIf { it > 0 },
                    name = name,
                    badge = t.codecBadge,
                    isDefault = t.isDefault,
                    isForced = t.isForced,
                    isDtsOrTrueHd = t.isDtsOrTrueHd,
                    requiresAudioTranscode = t.requiresTvAudioTranscode,
                    codecShort = t.codecShortName
                )
            }
            val fallbackSubs = mkvInfo.subtitleTracks.mapIndexed { idx, t ->
                val langName = formatLanguageName(t.language)
                val label = t.name.trim()
                val name = when {
                    label.isNotBlank() && langName.isNotBlank() ->
                        if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                    label.isNotBlank() -> label
                    langName.isNotBlank() -> langName
                    else -> "Subtítulo ${idx + 1}"
                }
                CachedTrackOption(
                    ordinal = idx,
                    matroskaTrackNumber = t.trackNumber.takeIf { it > 0 },
                    name = name,
                    badge = t.codecBadge,
                    isDefault = t.isDefault,
                    isForced = t.isForced,
                    isDtsOrTrueHd = false,
                    isImageSubtitle = t.isImageSubtitle,
                    codecShort = t.codecShortName
                )
            }
            withContext(Dispatchers.Main) {
                val updatedServerSize = lss.getEffectiveSizeBytes()
                if (updatedServerSize > currentEffectiveFileSize && multipartParts.isNullOrEmpty()) {
                    currentEffectiveFileSize = updatedServerSize
                }
                val headerDurMs = if (mkvInfo.durationMs > 0L) mkvInfo.durationMs else lss.getKnownDurationMs()
                if (headerDurMs > 0L) {
                    lastKnownLocalDurationMs = headerDurMs
                    CastSessionCoordinator.updateKnownDurationMs(headerDurMs)
                    updateSeekBar()
                }
                if (cachedAudioOptions.isEmpty() && fallbackAudios.isNotEmpty()) {
                    cachedAudioOptions = fallbackAudios
                } else if (cachedAudioOptions.size == fallbackAudios.size && fallbackAudios.isNotEmpty()) {
                    cachedAudioOptions = cachedAudioOptions.mapIndexed { idx, existing ->
                        val mkvOpt = fallbackAudios[idx]
                        existing.copy(
                            matroskaTrackNumber = mkvOpt.matroskaTrackNumber ?: existing.matroskaTrackNumber,
                            isDtsOrTrueHd = existing.isDtsOrTrueHd || mkvOpt.isDtsOrTrueHd,
                            requiresAudioTranscode = existing.requiresAudioTranscode || mkvOpt.requiresAudioTranscode,
                            codecShort = existing.codecShort.ifBlank { mkvOpt.codecShort }
                        )
                    }
                }
                if (cachedSubtitleOptions.isEmpty() && fallbackSubs.isNotEmpty()) {
                    cachedSubtitleOptions = fallbackSubs
                } else if (cachedSubtitleOptions.size == fallbackSubs.size && fallbackSubs.isNotEmpty()) {
                    cachedSubtitleOptions = cachedSubtitleOptions.mapIndexed { idx, existing ->
                        val mkvOpt = fallbackSubs[idx]
                        existing.copy(
                            matroskaTrackNumber = mkvOpt.matroskaTrackNumber ?: existing.matroskaTrackNumber,
                            isImageSubtitle = existing.isImageSubtitle || mkvOpt.isImageSubtitle,
                            codecShort = existing.codecShort.ifBlank { mkvOpt.codecShort }
                        )
                    }
                }
                syncTrackSelectionToStreamServer()
                syncCurrentTracksToCoordinator()
            }
        }
    }

    private fun snapshotExoTracksCatalog(tracks: Tracks) {
        if (tracks.groups.isEmpty()) return
        val audios = mutableListOf<CachedTrackOption>()
        val subs = mutableListOf<CachedTrackOption>()
        var selectedAudioOrd: Int? = null
        var selectedSubOrd: Int? = null

        for (trackGroup in tracks.groups) {
            if (trackGroup.type == C.TRACK_TYPE_AUDIO) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    val ord = audios.size
                    val langName = formatLanguageName(format.language)
                    val label = format.label?.trim() ?: ""
                    val name = when {
                        label.isNotBlank() && langName.isNotBlank() ->
                            if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                        label.isNotBlank() -> label
                        langName.isNotBlank() -> langName
                        else -> "Pista de Audio ${ord + 1}"
                    }
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
                    val codecs = format.codecs ?: ""
                    val combinedCodec = "$mime $codecs"
                    val shortCodec = when {
                        combinedCodec.contains("eac3", true) || combinedCodec.contains("ec-3", true) -> "E-AC3"
                        combinedCodec.contains("ac3", true) || combinedCodec.contains("ac-3", true) -> "AC3"
                        combinedCodec.contains("dts", true) -> "DTS"
                        combinedCodec.contains("true-hd", true) || combinedCodec.contains("truehd", true) || combinedCodec.contains("mlp", true) -> "TrueHD"
                        combinedCodec.contains("flac", true) -> "FLAC"
                        combinedCodec.contains("opus", true) -> "Opus"
                        combinedCodec.contains("mp4a", true) || combinedCodec.contains("aac", true) -> "AAC"
                        combinedCodec.contains("vorbis", true) -> "Vorbis"
                        combinedCodec.contains("alac", true) -> "ALAC"
                        combinedCodec.contains("pcm", true) || combinedCodec.contains("raw", true) -> "PCM"
                        combinedCodec.contains("mpeg", true) || combinedCodec.contains("mp3", true) -> "MP3"
                        else -> ""
                    }
                    if (shortCodec.isNotEmpty()) {
                        badgeParts.add(shortCodec)
                    }
                    val isDtsOrTrueHd = shortCodec == "DTS" || shortCodec == "TrueHD"
                    val requiresTranscode = isDtsOrTrueHd ||
                        shortCodec == "FLAC" ||
                        shortCodec == "Opus" ||
                        shortCodec == "Vorbis" ||
                        shortCodec == "ALAC" ||
                        shortCodec == "PCM"
                    val isDef = (format.selectionFlags and C.SELECTION_FLAG_DEFAULT) != 0
                    val isForc = (format.selectionFlags and C.SELECTION_FLAG_FORCED) != 0
                    if (trackGroup.isTrackSelected(i)) {
                        selectedAudioOrd = ord
                    }
                    val prevOpt = cachedAudioOptions.getOrNull(ord)
                    audios.add(
                        CachedTrackOption(
                            ordinal = ord,
                            matroskaTrackNumber = format.id?.toIntOrNull() ?: prevOpt?.matroskaTrackNumber,
                            name = name,
                            badge = badgeParts.joinToString(" • "),
                            isDefault = isDef,
                            isForced = isForc,
                            isDtsOrTrueHd = isDtsOrTrueHd || (prevOpt?.isDtsOrTrueHd == true),
                            requiresAudioTranscode = requiresTranscode || (prevOpt?.requiresAudioTranscode == true),
                            codecShort = shortCodec.ifBlank { prevOpt?.codecShort.orEmpty() }
                        )
                    )
                }
            } else if (trackGroup.type == C.TRACK_TYPE_TEXT) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    val ord = subs.size
                    val langName = formatLanguageName(format.language)
                    val label = format.label?.trim() ?: ""
                    val name = when {
                        label.isNotBlank() && langName.isNotBlank() ->
                            if (label.contains(langName, ignoreCase = true)) label else "$langName ($label)"
                        label.isNotBlank() -> label
                        langName.isNotBlank() -> langName
                        else -> "Subtítulo ${ord + 1}"
                    }
                    val isDef = (format.selectionFlags and C.SELECTION_FLAG_DEFAULT) != 0
                    val isForc = (format.selectionFlags and C.SELECTION_FLAG_FORCED) != 0
                    val badgeParts = mutableListOf<String>()
                    if (isDef) badgeParts.add("Predeterminado")
                    if (isForc) badgeParts.add("Forzado")
                    if ((format.roleFlags and C.ROLE_FLAG_DESCRIBES_VIDEO) != 0) badgeParts.add("SDH")
                    if (trackGroup.isTrackSelected(i)) {
                        selectedSubOrd = ord
                    }
                    val prevSubOpt = cachedSubtitleOptions.getOrNull(ord)
                    val subCodecStr = "${format.sampleMimeType ?: ""} ${format.codecs ?: ""}"
                    val isImgSub = subCodecStr.contains("pgs", true) ||
                        subCodecStr.contains("vobsub", true) ||
                        subCodecStr.contains("dvbsubs", true) ||
                        (prevSubOpt?.isImageSubtitle == true)
                    subs.add(
                        CachedTrackOption(
                            ordinal = ord,
                            matroskaTrackNumber = format.id?.toIntOrNull() ?: prevSubOpt?.matroskaTrackNumber,
                            name = name,
                            badge = badgeParts.joinToString(" • "),
                            isDefault = isDef,
                            isForced = isForc,
                            isImageSubtitle = isImgSub,
                            codecShort = prevSubOpt?.codecShort.orEmpty()
                        )
                    )
                }
            }
        }

        if (audios.isNotEmpty()) {
            cachedAudioOptions = audios
            exoCurrentlySelectedAudioOrdinal = selectedAudioOrd
        }
        if (subs.isNotEmpty()) {
            cachedSubtitleOptions = subs
            exoCurrentlySelectedSubtitleOrdinal =
                if (userSubtitleMode == MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL) null else selectedSubOrd
        }
    }

    private fun resolveEffectiveSubtitleSelection(): Triple<MatroskaEbmlTrackPatcher.SubtitlePatchMode, Int?, Int?> {
        return when (userSubtitleMode) {
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL,
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED -> {
                Triple(MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL, null, null)
            }
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE -> {
                val ord = userSelectedSubtitleOrdinal ?: exoCurrentlySelectedSubtitleOrdinal
                val trackNum = userSelectedSubtitleTrackNum
                    ?: ord?.let { cachedSubtitleOptions.getOrNull(it)?.matroskaTrackNumber }
                if (ord != null || trackNum != null) {
                    Triple(MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE, trackNum, ord)
                } else {
                    Triple(MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL, null, null)
                }
            }
        }
    }

    private fun syncTrackSelectionToStreamServer() {
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        val forceStereoCast = if (isAnyCastActive()) {
            forceCastStereoSession
        } else {
            prefs.getBoolean("force_software_audio", false)
        }
        val defaultAudioOrd = cachedAudioOptions.firstOrNull { it.isDefault }?.ordinal ?: 0
        val currentAudioOpt = userSelectedAudioOrdinal?.let { cachedAudioOptions.getOrNull(it) }
        val isDefaultNativeAudio = userSelectedAudioOrdinal != null &&
            userSelectedAudioOrdinal == defaultAudioOrd &&
            currentAudioOpt?.requiresAudioTranscode != true
        val (effSubMode, effSubTrackNum, effSubOrdinal) = resolveEffectiveSubtitleSelection()
        localStreamServer?.updateCastTrackSelection(
            audioTrackNumber = if (isDefaultNativeAudio) null else userSelectedAudioTrackNum,
            audioOrdinal = if (isDefaultNativeAudio) null else userSelectedAudioOrdinal,
            subtitleMode = effSubMode,
            subtitleTrackNumber = effSubTrackNum,
            subtitleOrdinal = effSubOrdinal,
            forceStereo = forceStereoCast
        )
        syncCurrentTracksToCoordinator()
    }

    private fun applyStoredTrackOverridesToExoPlayerIfNeeded(tracks: Tracks) {
        val p = player ?: return
        if (isApplyingStoredExoTrackOverrides) return
        val wantAudioOrd = userSelectedAudioOrdinal
        val subMode = userSubtitleMode
        val wantSubOrd = userSelectedSubtitleOrdinal
        if (wantAudioOrd == null && subMode == MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED) return

        var builder = p.trackSelectionParameters.buildUpon()
        var changed = false

        if (wantAudioOrd != null) {
            var audioIdx = 0
            for (group in tracks.groups) {
                if (group.type == C.TRACK_TYPE_AUDIO) {
                    for (i in 0 until group.length) {
                        if (audioIdx == wantAudioOrd && !group.isTrackSelected(i)) {
                            builder = builder.setOverrideForType(TrackSelectionOverride(group.mediaTrackGroup, i))
                            changed = true
                        }
                        audioIdx++
                    }
                }
            }
        }

        when (subMode) {
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL -> {
                val anySubSelected = tracks.groups.any { it.type == C.TRACK_TYPE_TEXT && it.isSelected }
                if (anySubSelected || !p.trackSelectionParameters.disabledTrackTypes.contains(C.TRACK_TYPE_TEXT)) {
                    builder = builder.clearOverridesOfType(C.TRACK_TYPE_TEXT)
                        .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                    changed = true
                }
            }
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE -> {
                if (wantSubOrd != null) {
                    var subIdx = 0
                    for (group in tracks.groups) {
                        if (group.type == C.TRACK_TYPE_TEXT) {
                            for (i in 0 until group.length) {
                                if (subIdx == wantSubOrd && !group.isTrackSelected(i)) {
                                    builder = builder.setTrackTypeDisabled(C.TRACK_TYPE_TEXT, false)
                                        .setOverrideForType(TrackSelectionOverride(group.mediaTrackGroup, i))
                                    changed = true
                                }
                                subIdx++
                            }
                        }
                    }
                }
            }
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED -> {}
        }

        if (changed) {
            isApplyingStoredExoTrackOverrides = true
            try {
                p.trackSelectionParameters = builder.build()
            } finally {
                isApplyingStoredExoTrackOverrides = false
            }
        }
    }

    // --- Unified Track Selector (Controla móvil local Y TV por DLNA / Cast en directo) ---
    private fun showTrackSelectorDialog() {
        val p = player
        if (!isAnyCastActive() && p != null) {
            snapshotExoTracksCatalog(p.currentTracks)
        }

        val dialog = android.app.Dialog(this, R.style.Theme_Cineflix_TVDialog)
        val dialogView = layoutInflater.inflate(R.layout.dialog_track_selector, null)
        dialog.setContentView(dialogView)

        val containerAudio = dialogView.findViewById<LinearLayout>(R.id.container_audio_tracks)
        val containerSubtitles = dialogView.findViewById<LinearLayout>(R.id.container_subtitle_tracks)
        val btnClose = dialogView.findViewById<TextView>(R.id.btn_dialog_close)

        // Botón / Toggle Compatibilidad Estéreo
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        var forceSoftware = if (isAnyCastActive()) {
            forceCastStereoSession
        } else {
            prefs.getBoolean("force_software_audio", false)
        }

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
            if (isAnyCastActive()) {
                forceCastStereoSession = forceSoftware
            } else {
                prefs.edit().putBoolean("force_software_audio", forceSoftware).apply()
            }
            updateStereoUi(forceSoftware)

            if (!isAnyCastActive()) {
                val currentPos = player?.currentPosition ?: 0L
                val wasPlayingLocal = player?.isPlaying ?: true

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

                if (!wasPlayingLocal) {
                    player?.pause()
                }
            } else {
                syncTrackSelectionToStreamServer()
                dialog.dismiss()
                reloadActiveCastForTrackChange(
                    if (forceSoftware) "🔊 Compatibilidad Estéreo (Móvil)" else "🔊 Audio 5.1 Directo"
                )
            }

            Toast.makeText(
                this@PlayerActivity,
                if (forceSoftware) "🔊 Compatibilidad Estéreo activada (Decodif. móvil)" else "🔊 Modo Envolvente / 5.1 Directo activado",
                Toast.LENGTH_SHORT
            ).show()
        }

        var selectedAudioView: View? = null
        var firstFocusableView: View? = null

        val activeAudioOrdinal: Int = userSelectedAudioOrdinal
            ?: exoCurrentlySelectedAudioOrdinal
            ?: cachedAudioOptions.firstOrNull { it.isDefault }?.ordinal
            ?: 0

        val activeSubtitleOrdinal: Int? = resolveEffectiveSubtitleSelection().third

        // --- 1. Pistas de Audio ---
        val activeOrsayTv = isDlnaCasting && dlnaController.activeDevice?.isLegacySamsungOrsay == true

        for (opt in cachedAudioOptions) {
            val isSelected = opt.ordinal == activeAudioOrdinal
            val phoneDecodeBadge = isDlnaCasting && (
                opt.requiresAudioTranscode ||
                    activeOrsayTv ||
                    forceCastStereoSession
                )

            val rowView = layoutInflater.inflate(R.layout.item_tv_track, containerAudio, false)
            val tvIndicator = rowView.findViewById<TextView>(R.id.tv_track_indicator)
            val tvName = rowView.findViewById<TextView>(R.id.tv_track_name)
            val tvBadge = rowView.findViewById<TextView>(R.id.tv_track_badge)

            tvName.text = opt.name
            val effectiveBadge = when {
                phoneDecodeBadge && opt.badge.isNotBlank() -> "${opt.badge} • Decodif. móvil"
                phoneDecodeBadge -> "Decodif. móvil"
                else -> opt.badge
            }
            if (effectiveBadge.isNotBlank()) {
                tvBadge.text = effectiveBadge
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
                if (isAnyCastActive()) {
                    lastWorkingCastAudioOrdinal = activeAudioOrdinal
                    lastWorkingCastAudioTrackNum = cachedAudioOptions.getOrNull(activeAudioOrdinal)?.matroskaTrackNumber
                }
                userSelectedAudioOrdinal = opt.ordinal
                userSelectedAudioTrackNum = opt.matroskaTrackNumber
                exoCurrentlySelectedAudioOrdinal = opt.ordinal
                syncTrackSelectionToStreamServer()

                if (!isAnyCastActive() && p != null) {
                    applyStoredTrackOverridesToExoPlayerIfNeeded(p.currentTracks)
                }

                if (isAnyCastActive()) {
                    reloadActiveCastForTrackChange("🔊 Audio: ${opt.name}")
                } else {
                    Toast.makeText(this@PlayerActivity, "🔊 Audio: ${opt.name}", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }

            containerAudio.addView(rowView)
        }

        if (cachedAudioOptions.isEmpty()) {
            val emptyTv = TextView(this).apply {
                text = "Pista estándar activa"
                setTextColor(android.graphics.Color.parseColor("#888899"))
                textSize = 13f
                setPadding(dpToPx(12), dpToPx(8), dpToPx(12), dpToPx(8))
            }
            containerAudio.addView(emptyTv)
        }

        // --- 2. Pistas de Subtítulos ---
        val rowDisableSub = layoutInflater.inflate(R.layout.item_tv_track, containerSubtitles, false)
        val tvDisableIndicator = rowDisableSub.findViewById<TextView>(R.id.tv_track_indicator)
        val tvDisableName = rowDisableSub.findViewById<TextView>(R.id.tv_track_name)
        val tvDisableBadge = rowDisableSub.findViewById<TextView>(R.id.tv_track_badge)
        tvDisableName.text = "Desactivar subtítulos"
        tvDisableBadge.visibility = View.GONE
        tvDisableIndicator.visibility = if (activeSubtitleOrdinal == null) View.VISIBLE else View.INVISIBLE

        rowDisableSub.setOnClickListener {
            userSubtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
            userSelectedSubtitleOrdinal = null
            userSelectedSubtitleTrackNum = null
            exoCurrentlySelectedSubtitleOrdinal = null
            syncTrackSelectionToStreamServer()

            if (!isAnyCastActive() && p != null) {
                p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                    .clearOverridesOfType(C.TRACK_TYPE_TEXT)
                    .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                    .build()
            }

            if (isAnyCastActive()) {
                reloadActiveCastForTrackChange("💬 Subtítulos desactivados")
            } else {
                Toast.makeText(this@PlayerActivity, "💬 Subtítulos desactivados", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }
        containerSubtitles.addView(rowDisableSub)

        for (opt in cachedSubtitleOptions) {
            val isSelected = activeSubtitleOrdinal == opt.ordinal

            val rowView = layoutInflater.inflate(R.layout.item_tv_track, containerSubtitles, false)
            val tvIndicator = rowView.findViewById<TextView>(R.id.tv_track_indicator)
            val tvName = rowView.findViewById<TextView>(R.id.tv_track_name)
            val tvBadge = rowView.findViewById<TextView>(R.id.tv_track_badge)

            tvName.text = opt.name
            if (opt.badge.isNotBlank()) {
                tvBadge.text = opt.badge
                tvBadge.visibility = View.VISIBLE
            } else {
                tvBadge.visibility = View.GONE
            }

            tvIndicator.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE

            rowView.setOnClickListener {
                userSubtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE
                userSelectedSubtitleOrdinal = opt.ordinal
                userSelectedSubtitleTrackNum = opt.matroskaTrackNumber
                exoCurrentlySelectedSubtitleOrdinal = opt.ordinal
                syncTrackSelectionToStreamServer()

                if (!isAnyCastActive() && p != null) {
                    applyStoredTrackOverridesToExoPlayerIfNeeded(p.currentTracks)
                }

                if (isAnyCastActive()) {
                    reloadActiveCastForTrackChange("💬 Subtítulos: ${opt.name}")
                } else {
                    Toast.makeText(this@PlayerActivity, "💬 Subtítulos: ${opt.name}", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }

            containerSubtitles.addView(rowView)
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
    private fun isAnyCastActive(): Boolean = isDlnaCasting || isGoogleCasting || CastSessionCoordinator.isCastingActive

    private fun getCurrentEffectivePositionMs(): Long {
        val pending = pendingSeekTargetMs
        if (pending != null) {
            return pending
        }
        if (isDlnaCasting || isGoogleCasting || CastSessionCoordinator.isCastingActive) {
            val pos = CastSessionCoordinator.getEffectivePositionMs(this)
            lastCastPositionMs = pos
            return pos
        }
        return player?.currentPosition?.coerceAtLeast(0L) ?: 0L
    }

    private fun getCurrentEffectiveDurationMs(): Long {
        val serverDur = localStreamServer?.getKnownDurationMs() ?: 0L
        if (serverDur > 0L) {
            lastKnownLocalDurationMs = serverDur
        }
        if (isDlnaCasting || isGoogleCasting || CastSessionCoordinator.isCastingActive) {
            val castDur = CastSessionCoordinator.getEffectiveDurationMs(this)
            if (castDur > 0L && castDur !in 9_560_000L..9_565_000L) {
                lastKnownLocalDurationMs = castDur
                return castDur
            }
            if (serverDur > 0L) return serverDur
            return lastKnownLocalDurationMs
        }
        val localDur = player?.duration ?: 0L
        if (localDur > 0L && localDur != C.TIME_UNSET) {
            lastKnownLocalDurationMs = localDur
            return localDur
        }
        return lastKnownLocalDurationMs
    }

    private fun performEffectiveSeek(targetMs: Long) {
        val safeTarget = targetMs.coerceAtLeast(0L)
        lastCastPositionMs = safeTarget
        when {
            isDlnaCasting -> {
                CastSessionCoordinator.notifyDlnaSeek(safeTarget)
                val activeDev = dlnaController.activeDevice
                if (dlnaController.isCurrentSessionLiveTranscode && activeDev != null) {
                    loadingSpinner.visibility = View.VISIBLE
                    tvCastActiveSubtitle.text = "Avanzando a ${formatTime(safeTarget)} • Decodificando en el móvil..."
                    launchDlnaStreamForCurrentState(
                        device = activeDev,
                        startPosMs = safeTarget,
                        isTrackReload = false,
                        forceLiveTranscode = true
                    )
                } else {
                    dlnaController.seekTo(safeTarget)
                }
            }
            isGoogleCasting -> {
                CastSessionCoordinator.notifyGoogleCastSeek(safeTarget)
                val seekOpts = MediaSeekOptions.Builder().setPosition(safeTarget).build()
                sessionManager?.currentCastSession?.remoteMediaClient?.seek(seekOpts)
            }
            else -> player?.seekTo(safeTarget)
        }
    }

    private fun togglePlayPause() {
        when {
            isDlnaCasting || isGoogleCasting || CastSessionCoordinator.isCastingActive -> {
                CastSessionCoordinator.togglePlayPause(this)
            }
            else -> {
                val p = player ?: return
                if (p.isPlaying) p.pause() else p.play()
            }
        }
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
        if (isAnyCastActive()) {
            // Keep remote controls handy when phone is acting as TV remote, unless user explicitly taps
        }
        bottomBar.animate().alpha(0f).setDuration(300).withEndAction { bottomBar.visibility = View.GONE }.start()
        centerControls.animate().alpha(0f).setDuration(300).withEndAction { centerControls.visibility = View.GONE }.start()
        if (!isAnyCastActive()) {
            castContainer.animate().alpha(0f).setDuration(300).withEndAction { castContainer.visibility = View.GONE }.start()
        }
        controlsVisible = false
    }

    private fun scheduleHideControls() {
        controlsHandler.removeCallbacksAndMessages(null)
        controlsHandler.postDelayed({
            if (!isAnyCastActive() && player?.isPlaying == true) hideControls()
        }, 4000)
    }

    private var _diagLoggedOnce = false

    private fun updateSeekBar() {
        if (isSeeking) return
        if (!isAnyCastActive() && player == null) return

        if (isGoogleCasting) {
            val rmc = sessionManager?.currentCastSession?.remoteMediaClient
            if (rmc != null) {
                val castPlaying = rmc.isPlaying || rmc.isBuffering
                btnPlayPause.setImageResource(
                    if (castPlaying) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play
                )
                tvCastActiveSubtitle.text = when {
                    rmc.isBuffering -> "Cargando búfer en la TV..."
                    rmc.isPaused -> "En pausa en la TV"
                    rmc.isPlaying -> "Reproduciendo por Google Cast"
                    else -> "Conectado por Google Cast"
                }
            }
        }

        val time = getCurrentEffectivePositionMs()
        val duration = getCurrentEffectiveDurationMs()
        if (duration > 0 && duration != C.TIME_UNSET) {
            seekBar.max = duration.toInt()
            seekBar.progress = time.toInt()
            tvTimeCurrent.text = formatTime(time)
            tvTimeDuration.text = formatTime(duration)

            // Intro and Next Episode check
            val introStartMs = (intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "").toLongOrNull()
            val introEndMs   = (intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "").toLongOrNull()

            if (!introSkipped && introStartMs != null && introEndMs != null && introEndMs > introStartMs) {
                val isSeekable = isAnyCastActive() || (player?.isCurrentMediaItemSeekable ?: true)
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

    private fun executeOrDebounceSeek(targetMs: Long, debounceMs: Long = 400L) {
        if (!isAnyCastActive() && player == null) return
        val duration = getCurrentEffectiveDurationMs()
        val safeTarget = if (duration > 0 && duration != C.TIME_UNSET) {
            Math.max(0L, Math.min(targetMs, duration))
        } else {
            Math.max(0L, targetMs)
        }

        pendingSeekTargetMs = safeTarget
        lastCastPositionMs = safeTarget
        if (isDlnaCasting) {
            CastSessionCoordinator.notifyDlnaSeek(safeTarget)
        } else if (isGoogleCasting) {
            CastSessionCoordinator.notifyGoogleCastSeek(safeTarget)
        }
        if (duration > 0 && duration != C.TIME_UNSET) {
            seekBar.max = duration.toInt()
        }
        seekBar.progress = safeTarget.toInt()
        tvTimeCurrent.text = formatTime(safeTarget)

        seekDebounceHandler.removeCallbacks(seekDebounceRunnable)
        seekDebounceHandler.postDelayed(seekDebounceRunnable, debounceMs)
    }

    private fun seekRelative(deltaMs: Long) {
        if (!isAnyCastActive() && player == null) return
        val duration = getCurrentEffectiveDurationMs()
        val isLiveCast = isDlnaCasting && dlnaController.isCurrentSessionLiveTranscode
        val effectiveDeltaMs = if (isLiveCast && kotlin.math.abs(deltaMs) == 10_000L) {
            if (deltaMs > 0) 30_000L else -30_000L
        } else {
            deltaMs
        }
        val basePos = pendingSeekTargetMs ?: getCurrentEffectivePositionMs()
        val rawTarget = Math.max(0L, basePos + effectiveDeltaMs)
        val target = if (duration > 0 && duration != C.TIME_UNSET) {
            Math.min(rawTarget, duration)
        } else {
            rawTarget
        }
        if (isLiveCast) {
            tvCastActiveSubtitle.text = "⏩ Saltando a ${formatTime(target)} • Decodificando en el móvil..."
        }
        executeOrDebounceSeek(target, debounceMs = if (isLiveCast) 650L else 400L)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (!isAnyCastActive() && player == null) return super.onKeyDown(keyCode, event)

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
            if (isAnyCastActive()) {
                returnToCatalogWhileCasting()
                return true
            }
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

    // --- Unified 1-Tap Cast (Google Cast + Native DLNA Smart TVs: Samsung Tizen, LG webOS, etc.) ---
    private fun setupUnifiedCastEngine() {
        try {
            castContext = CastContext.getSharedInstance(this)
            sessionManager = castContext?.sessionManager
        } catch (e: Throwable) {
            Log.w(TAG, "Google Cast SDK unavailable (DLNA Smart TV discovery remains 100% active): ${e.message}")
        }

        setupCastSessionListener()
        setupDlnaControllerListener()

        // Pre-warm Wi-Fi discovery immediately so all TVs (Android TV + Samsung Tizen + LG webOS)
        // are already ready in 0ms when the user taps the Cast button!
        val discovery = UnifiedTvDiscoveryManager(this)
        unifiedTvDiscovery = discovery
        discovery.startActiveDiscovery(forceRefresh = false)
        updateCastUiIndicators()
    }

    private fun setupDlnaControllerListener() {
        val listener = object : CastSessionCoordinator.PlayerUiListener {
            override fun onDlnaConnecting(device: DlnaDevice) {
                if (isFinishing || isDestroyed) return
                loadingSpinner.visibility = View.VISIBLE
                layoutCastStatusCard.visibility = View.VISIBLE
                tvCastActiveTitle.text = "📺 Conectando con ${device.friendlyName}..."
                tvCastActiveSubtitle.text = "Si tu TV pide permiso la primera vez, pulsa Permitir"
                updateCastUiIndicators()
            }

            override fun onDlnaPlaybackStarted(device: DlnaDevice) {
                if (isFinishing || isDestroyed) return
                loadingSpinner.visibility = View.GONE
                layoutCastStatusCard.visibility = View.VISIBLE
                tvCastActiveTitle.text = "📺 Emitiendo en ${device.friendlyName}"
                tvCastActiveSubtitle.text = if (dlnaController.isCurrentSessionLiveTranscode) {
                    "Decodificando en el móvil • ${device.friendlyName}"
                } else {
                    device.brandBadge
                }
                btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
                updateCastUiIndicators()
                showControls()
                Toast.makeText(
                    this@PlayerActivity,
                    "📺 Reproduciendo en ${device.friendlyName}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onDlnaProgressUpdated(
                device: DlnaDevice,
                positionMs: Long,
                durationMs: Long,
                isPlaying: Boolean
            ) {
                if (!isDlnaCasting || isFinishing || isDestroyed) return
                lastCastPositionMs = positionMs
                if (durationMs > 0L) {
                    lastKnownLocalDurationMs = durationMs
                }
                btnPlayPause.setImageResource(
                    if (isPlaying) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play
                )
                val modeLabel = if (dlnaController.isCurrentSessionLiveTranscode) {
                    "Decodificando en el móvil"
                } else {
                    device.brandBadge
                }
                tvCastActiveSubtitle.text = if (isPlaying) {
                    "Reproduciendo • $modeLabel"
                } else {
                    "En pausa • $modeLabel"
                }
                updateSeekBar()
            }

            override fun onDlnaPlaybackEndedNaturally(
                device: DlnaDevice,
                finalPositionMs: Long,
                durationMs: Long
            ) {
                isDlnaCasting = false
                activeCastDeviceId = null
                activeCastTvName = ""
                releaseCastLocks()
                updateCastUiIndicators()

                val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
                if (contentId.startsWith("tv_") && !nextEpisodeTriggered) {
                    nextEpisodeTriggered = true
                    triggerNextEpisode()
                } else {
                    finish()
                }
            }

            override fun onDlnaError(device: DlnaDevice, message: String) {
                if (isFinishing || isDestroyed) return
                loadingSpinner.visibility = View.GONE
                Toast.makeText(this@PlayerActivity, message, Toast.LENGTH_LONG).show()
                val resumeAt = lastCastPositionMs
                isDlnaCasting = false
                activeCastDeviceId = null
                activeCastTvName = ""
                releaseCastLocks()
                updateCastUiIndicators()
                resumeLocalPlayerAfterCast(resumeAt)
            }

            override fun onDlnaTrackReloadFailed(device: DlnaDevice) {
                if (isFinishing || isDestroyed) return
                val resumePosMs = getCurrentEffectivePositionMs()
                if (!dlnaController.isCurrentSessionLiveTranscode) {
                    Toast.makeText(
                        this@PlayerActivity,
                        "⚡ Decodificando pista en el móvil para ${device.friendlyName}...",
                        Toast.LENGTH_SHORT
                    ).show()
                    launchDlnaStreamForCurrentState(
                        device = device,
                        startPosMs = resumePosMs,
                        isTrackReload = false,
                        forceLiveTranscode = true
                    )
                    return
                }

                val fallbackOrd = lastWorkingCastAudioOrdinal
                if (fallbackOrd != null && fallbackOrd != userSelectedAudioOrdinal) {
                    val fallbackOpt = cachedAudioOptions.getOrNull(fallbackOrd)
                    userSelectedAudioOrdinal = fallbackOrd
                    userSelectedAudioTrackNum = fallbackOpt?.matroskaTrackNumber ?: lastWorkingCastAudioTrackNum
                    exoCurrentlySelectedAudioOrdinal = fallbackOrd
                    lastWorkingCastAudioOrdinal = null
                    syncTrackSelectionToStreamServer()
                    Toast.makeText(
                        this@PlayerActivity,
                        "⚠️ ${device.friendlyName} no admite esa pista; volviendo a ${fallbackOpt?.name ?: "la pista anterior"}.",
                        Toast.LENGTH_LONG
                    ).show()
                    launchDlnaStreamForCurrentState(
                        device = device,
                        startPosMs = resumePosMs,
                        isTrackReload = false
                    )
                } else {
                    val (_, safePos) = CastSessionCoordinator.detachCastToLocalPlayback(this@PlayerActivity)
                    onDlnaError(device, "${device.friendlyName} no pudo reproducir la pista seleccionada.")
                    if (safePos > 0L) {
                        lastCastPositionMs = safePos
                    }
                }
            }

            override fun onGoogleCastNaturalEnd() {
                isGoogleCasting = false
                activeCastDeviceId = null
                activeCastTvName = ""
                CastSessionCoordinator.stopCastingCompletely(
                    this@PlayerActivity,
                    markFinished = true,
                    notifyAttachedPlayerToClose = false
                )
                localStreamServer = null
                updateCastUiIndicators()
                val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
                if (contentId.startsWith("tv_") && !nextEpisodeTriggered) {
                    nextEpisodeTriggered = true
                    triggerNextEpisode()
                } else {
                    finish()
                }
            }

            override fun onExternalCastStopped() {
                // Triggered when user taps "Detener" from ForegroundService notification while PlayerActivity is open
                isDlnaCasting = false
                isGoogleCasting = false
                activeCastDeviceId = null
                activeCastTvName = ""
                localStreamServer = null
                finish()
            }
        }
        castUiListener = listener
        CastSessionCoordinator.playerUiListener = listener
    }

    private fun setupCastSessionListener() {
        val sm = sessionManager ?: return

        castSessionListener = object : SessionManagerListener<CastSession> {
            override fun onSessionStarting(session: CastSession) {
                loadingSpinner.visibility = View.VISIBLE
            }

            override fun onSessionStartFailed(session: CastSession, error: Int) {
                loadingSpinner.visibility = View.GONE
                Toast.makeText(this@PlayerActivity, "Error al conectar con Google Cast ($error)", Toast.LENGTH_SHORT).show()
                if (!isDlnaCasting) {
                    val (server, resumeAt) = CastSessionCoordinator.detachCastToLocalPlayback(this@PlayerActivity)
                    if (server != null) localStreamServer = server
                    isGoogleCasting = false
                    activeCastDeviceId = null
                    releaseCastLocks()
                    updateCastUiIndicators()
                    resumeLocalPlayerAfterCast(maxOf(resumeAt, lastCastPositionMs))
                }
            }

            override fun onSessionStarted(session: CastSession, sessionId: String) {
                if (isDlnaCasting) {
                    dlnaController.stopSession(notifyListener = false)
                    localStreamServer?.stopLiveTranscode()
                    isDlnaCasting = false
                }
                val resumeAt = if (pendingGoogleCastStartMs > 0L) {
                    pendingGoogleCastStartMs
                } else {
                    lastCastPositionMs.takeIf { it > 0L } ?: getCurrentEffectivePositionMs()
                }
                pendingGoogleCastStartMs = 0L
                loadMediaIntoGoogleCastSession(session, resumeAt)
            }

            override fun onSessionResuming(session: CastSession, sessionId: String) {}

            override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
                if (isDlnaCasting) return
                isGoogleCasting = true
                activeCastTvName = session.castDevice?.friendlyName ?: "Google Cast TV"
                activeCastDeviceId = session.castDevice?.deviceId?.let { "cast_dev:$it" } ?: activeCastDeviceId
                val curPos = getCurrentEffectivePositionMs()
                acquireCastLocks()
                parkLocalPlayerForCasting(curPos)
                localStreamServer?.let { lss ->
                    CastSessionCoordinator.beginGoogleCastConnecting(
                        context = this@PlayerActivity,
                        streamServer = lss,
                        media = buildCurrentCastMediaMetadata(),
                        trackState = buildCurrentTrackSelectionState(),
                        tvName = activeCastTvName,
                        deviceId = activeCastDeviceId,
                        startPosMs = curPos,
                        knownDurationMs = lastKnownLocalDurationMs
                    )
                    CastSessionCoordinator.attachGoogleCastMediaLoaded(
                        context = this@PlayerActivity,
                        session = session,
                        startPosMs = curPos,
                        knownDurationMs = lastKnownLocalDurationMs
                    )
                }
                updateCastUiIndicators()
            }

            override fun onSessionResumeFailed(session: CastSession, error: Int) {}
            override fun onSessionSuspended(session: CastSession, reason: Int) {}
            override fun onSessionEnding(session: CastSession) {}

            override fun onSessionEnded(session: CastSession, error: Int) {
                val nextRoute = pendingGoogleCastRouteAfterEnd
                pendingGoogleCastRouteAfterEnd = null
                if (nextRoute != null) {
                    Handler(Looper.getMainLooper()).post {
                        try {
                            nextRoute.select()
                        } catch (e: Exception) {
                            Log.e(TAG, "Failed selecting switched Cast route: ${e.message}")
                        }
                    }
                    return
                }

                val (handedServer, coordinatorPos) = if (CastSessionCoordinator.isGoogleCasting) {
                    CastSessionCoordinator.detachCastToLocalPlayback(this@PlayerActivity)
                } else {
                    Pair(null, lastCastPositionMs)
                }
                if (handedServer != null) {
                    localStreamServer = handedServer
                }
                val resumePos = if (coordinatorPos > 0L) coordinatorPos else lastCastPositionMs
                isGoogleCasting = false
                if (!isDlnaCasting) {
                    activeCastDeviceId = null
                    activeCastTvName = ""
                    releaseCastLocks()
                    updateCastUiIndicators()
                    if (!suppressLocalResumeOnCastEnd && !isFinishing && !isDestroyed && !isCleanedUp) {
                        resumeLocalPlayerAfterCast(resumePos)
                        Toast.makeText(this@PlayerActivity, "Reproducción local reanudada", Toast.LENGTH_SHORT).show()
                    }
                }
                suppressLocalResumeOnCastEnd = false
            }
        }

        sm.addSessionManagerListener(castSessionListener!!, CastSession::class.java)
    }

    private fun loadMediaIntoGoogleCastSession(session: CastSession, startPosMs: Long) {
        syncTrackSelectionToStreamServer()
        val targetHost = try {
            session.castDevice?.inetAddress?.hostAddress
        } catch (_: Throwable) {
            null
        }
        val lanIp = LanNetworkUtils.getBestLanIpv4(this, targetHost)
        val lss = localStreamServer
        val streamUrl = when {
            lanIp != null && lss != null && lss.listeningPort > 0 -> lss.resolveLanGoogleCastUrl(lanIp)
            castStreamUrl != null -> castStreamUrl!!
            else -> {
                Toast.makeText(this, "Conéctate a una red Wi-Fi para enviar a la TV", Toast.LENGTH_LONG).show()
                return
            }
        }

        requestNotificationPermissionIfNeeded()
        isGoogleCasting = true
        lastCastPositionMs = startPosMs.coerceAtLeast(0L)
        activeCastTvName = session.castDevice?.friendlyName?.ifBlank { null } ?: activeCastTvName.ifBlank { "Chromecast / Android TV" }
        acquireCastLocks()
        parkLocalPlayerForCasting(lastCastPositionMs)

        if (lss != null) {
            if (!CastSessionCoordinator.isGoogleCasting || CastSessionCoordinator.activeStreamServer !== lss) {
                CastSessionCoordinator.beginGoogleCastConnecting(
                    context = this,
                    streamServer = lss,
                    media = buildCurrentCastMediaMetadata(),
                    trackState = buildCurrentTrackSelectionState(),
                    tvName = activeCastTvName,
                    deviceId = activeCastDeviceId,
                    startPosMs = lastCastPositionMs,
                    knownDurationMs = lastKnownLocalDurationMs
                )
            }
            CastSessionCoordinator.attachGoogleCastMediaLoaded(
                context = this,
                session = session,
                startPosMs = lastCastPositionMs,
                knownDurationMs = lastKnownLocalDurationMs
            )
        }

        loadingSpinner.visibility = View.GONE
        layoutCastStatusCard.visibility = View.VISIBLE
        tvCastActiveTitle.text = "📺 Emitiendo en $activeCastTvName"
        tvCastActiveSubtitle.text = "Reproduciendo por Google Cast"
        updateCastUiIndicators()

        val metadata = MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE).apply {
            putString(MediaMetadata.KEY_TITLE, currentTitle.ifBlank { "Cineflix" })
        }
        val durHint = getCurrentEffectiveDurationMs()
        val resumeAtMs = lastCastPositionMs

        Thread {
            val vttUrl = if (lanIp != null && lss != null) {
                try {
                    lss.resolveLanGoogleCastSubtitleVttUrl(lanIp, resumeAtMs)
                } catch (_: Exception) {
                    null
                }
            } else {
                null
            }

            runOnUiThread {
                if (isFinishing || isDestroyed) return@runOnUiThread
                val mediaInfoBuilder = MediaInfo.Builder(streamUrl)
                    .setContentType("video/mp4")
                    .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                    .setMetadata(metadata)
                if (durHint > 0L) {
                    mediaInfoBuilder.setStreamDuration(durHint)
                }
                if (!vttUrl.isNullOrBlank()) {
                    val vttTrack = com.google.android.gms.cast.MediaTrack.Builder(
                        1L,
                        com.google.android.gms.cast.MediaTrack.TYPE_TEXT
                    )
                        .setName("Subtítulos")
                        .setSubtype(com.google.android.gms.cast.MediaTrack.SUBTYPE_SUBTITLES)
                        .setContentId(vttUrl)
                        .setContentType("text/vtt")
                        .setLanguage("es")
                        .build()
                    mediaInfoBuilder.setMediaTracks(listOf(vttTrack))
                }
                val mediaInfo = mediaInfoBuilder.build()

                val loadRequestBuilder = MediaLoadRequestData.Builder()
                    .setMediaInfo(mediaInfo)
                    .setAutoplay(true)
                    .setCurrentTime(resumeAtMs)
                if (!vttUrl.isNullOrBlank()) {
                    loadRequestBuilder.setActiveTrackIds(longArrayOf(1L))
                } else {
                    loadRequestBuilder.setActiveTrackIds(longArrayOf())
                }

                session.remoteMediaClient?.load(loadRequestBuilder.build())
                Toast.makeText(this, "📺 Enviando a $activeCastTvName...", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun showUnifiedCastDialog() {
        activeCastDialog?.takeIf { it.isShowing }?.dismiss()

        val dialog = android.app.Dialog(this, R.style.Theme_Cineflix_TVDialog)
        activeCastDialog = dialog
        val view = layoutInflater.inflate(R.layout.dialog_cast_tv_picker, null)
        dialog.setContentView(view)

        val pbScanning = view.findViewById<ProgressBar>(R.id.pb_cast_scanning)
        val tvStatus = view.findViewById<TextView>(R.id.tv_cast_scan_status)
        val btnRescan = view.findViewById<TextView>(R.id.btn_cast_rescan)
        val containerDevices = view.findViewById<LinearLayout>(R.id.container_cast_devices)
        val btnDisconnect = view.findViewById<TextView>(R.id.btn_cast_disconnect)
        val btnClose = view.findViewById<TextView>(R.id.btn_cast_dialog_close)

        btnDisconnect.visibility = if (isAnyCastActive()) View.VISIBLE else View.GONE
        btnDisconnect.setOnClickListener {
            dialog.dismiss()
            disconnectCastAndResumeLocally()
        }
        btnClose.setOnClickListener { dialog.dismiss() }
        btnRescan.setOnClickListener {
            pbScanning.visibility = View.VISIBLE
            tvStatus.text = "Buscando todos los televisores en tu Wi-Fi..."
            unifiedTvDiscovery?.startActiveDiscovery(forceRefresh = true)
        }

        var initialFocusAssigned = false

        fun renderDeviceList(devices: List<UnifiedTvDevice>, isScanning: Boolean) {
            pbScanning.visibility = if (isScanning) View.VISIBLE else View.GONE
            val lanIp = LanNetworkUtils.getBestLanIpv4(this)

            when {
                lanIp == null -> {
                    tvStatus.text = "⚠️ No hay conexión Wi-Fi activa. Conecta el móvil al mismo Wi-Fi que tu TV."
                }
                devices.isEmpty() && isScanning -> {
                    tvStatus.text = "Buscando televisores en tu Wi-Fi (Android TV, Chromecast, Samsung, LG...)..."
                }
                devices.isEmpty() -> {
                    tvStatus.text = "No se detectaron televisores encendidos en este Wi-Fi ($lanIp). Pulsa 🔄 Buscar."
                }
                else -> {
                    val suffix = if (isScanning) " • buscando más..." else ""
                    tvStatus.text = "Toca tu televisor para enviar el vídeo al instante (${devices.size} en Wi-Fi$suffix):"
                }
            }

            containerDevices.removeAllViews()
            var firstRow: View? = null

            for (tv in devices) {
                val row = layoutInflater.inflate(R.layout.item_cast_tv_device, containerDevices, false)
                val tvDot = row.findViewById<TextView>(R.id.tv_cast_device_dot)
                val tvName = row.findViewById<TextView>(R.id.tv_cast_device_name)
                val tvSubtitle = row.findViewById<TextView>(R.id.tv_cast_device_subtitle)
                val tvRightStatus = row.findViewById<TextView>(R.id.tv_cast_device_status)

                val isThisTvActive = when (tv) {
                    is UnifiedTvDevice.DlnaSmartTv -> isDlnaCasting && dlnaController.activeDevice?.udn == tv.device.udn
                    is UnifiedTvDevice.GoogleCastTv -> isGoogleCasting && (activeCastDeviceId == tv.id || tv.route.isSelected)
                }

                tvName.text = tv.name
                tvSubtitle.text = tv.badge
                if (isThisTvActive) {
                    tvDot.text = "●"
                    tvDot.setTextColor(android.graphics.Color.parseColor("#34D399"))
                    tvRightStatus.text = "Emitiendo"
                    tvRightStatus.setTextColor(android.graphics.Color.parseColor("#34D399"))
                } else {
                    tvDot.text = "📺"
                    tvRightStatus.text = "Enviar ›"
                    tvRightStatus.setTextColor(android.graphics.Color.parseColor("#DDD6FE"))
                }

                row.setOnClickListener {
                    dialog.dismiss()
                    onTvSelectedFromPicker(tv)
                }

                if (firstRow == null) firstRow = row
                containerDevices.addView(row)
            }

            if (!initialFocusAssigned && firstRow != null) {
                initialFocusAssigned = true
                firstRow?.post { firstRow.requestFocus() }
            }
        }

        val discoveryListener = object : UnifiedTvDiscoveryManager.Listener {
            override fun onTvListChanged(devices: List<UnifiedTvDevice>, isScanning: Boolean) {
                if (dialog.isShowing && !isFinishing && !isDestroyed) {
                    renderDeviceList(devices, isScanning)
                }
            }
        }

        unifiedTvDiscovery?.addListener(discoveryListener)
        unifiedTvDiscovery?.startActiveDiscovery(forceRefresh = false)

        dialog.setOnDismissListener {
            unifiedTvDiscovery?.removeListener(discoveryListener)
            if (activeCastDialog === dialog) {
                activeCastDialog = null
            }
            showControls()
            scheduleHideControls()
        }

        val displayWidth = resources.displayMetrics.widthPixels
        val targetWidth = (displayWidth * 0.86f).toInt().coerceAtMost(dpToPx(560))
        dialog.window?.setLayout(targetWidth, android.view.ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()
    }

    private fun onTvSelectedFromPicker(tv: UnifiedTvDevice) {
        when (tv) {
            is UnifiedTvDevice.DlnaSmartTv -> connectToDlnaSmartTv(tv)
            is UnifiedTvDevice.GoogleCastTv -> connectToGoogleCastTv(tv)
        }
    }

    private fun launchDlnaStreamForCurrentState(
        device: DlnaDevice,
        startPosMs: Long,
        isTrackReload: Boolean,
        forceLiveTranscode: Boolean = false
    ) {
        val lss = localStreamServer ?: return
        val lanIp = LanNetworkUtils.getBestLanIpv4(this, device.host)
        if (lanIp.isNullOrBlank()) {
            Toast.makeText(this, "Conecta el móvil a la misma red Wi-Fi que ${device.friendlyName}", Toast.LENGTH_LONG).show()
            return
        }
        val safeStartMs = startPosMs.coerceAtLeast(0L)
        val durHintMs = getCurrentEffectiveDurationMs()

        val defaultAudioOrd = cachedAudioOptions.firstOrNull { it.isDefault }?.ordinal ?: 0
        val currentAudioOrd = userSelectedAudioOrdinal
            ?: exoCurrentlySelectedAudioOrdinal
            ?: defaultAudioOrd
        val activeAudioOpt = cachedAudioOptions.getOrNull(currentAudioOrd)
        val forceAudioTranscode = (activeAudioOpt?.requiresAudioTranscode == true) || forceCastStereoSession

        val (_, _, effSubOrd) = resolveEffectiveSubtitleSelection()
        val activeSubOpt = effSubOrd?.let { cachedSubtitleOptions.getOrNull(it) }
        val forceSubtitleBurnIn = (activeSubOpt?.isImageSubtitle == true)

        syncTrackSelectionToStreamServer()

        scope.launch {
            val plan = lss.buildLanDlnaStreamPlan(
                lanIp = lanIp,
                targetDevice = device,
                durationHintMs = durHintMs,
                startPositionMs = safeStartMs,
                forceLiveTranscode = forceLiveTranscode,
                forceAudioTranscode = forceAudioTranscode,
                forceSubtitleBurnIn = forceSubtitleBurnIn
            )
            val resolvedDurMs = lss.getKnownDurationMs().takeIf { it > 0L } ?: durHintMs
            if (resolvedDurMs > 0L) {
                lastKnownLocalDurationMs = resolvedDurMs
                CastSessionCoordinator.updateKnownDurationMs(resolvedDurMs)
            }
            val effectiveSize = lss.getEffectiveSizeBytes()
            Log.i(
                TAG,
                "📡 Launching DLNA stream on '${device.friendlyName}' (orsay=${device.isLegacySamsungOrsay}, " +
                "live=${plan.isPrimaryLiveTranscode}, reload=$isTrackReload, dur=${resolvedDurMs}ms) -> ${plan.primaryUrl} (${plan.primaryMime}, start=${safeStartMs}ms)"
            )
            dlnaController.startSession(
                device = device,
                streamUrl = plan.primaryUrl,
                title = currentTitle.ifBlank { "Cineflix" },
                mimeType = plan.primaryMime,
                fileSizeBytes = effectiveSize,
                startPositionMs = if (plan.isPrimaryLiveTranscode) 0L else safeStartMs,
                durationHintMs = resolvedDurMs,
                subtitleSrtUrl = plan.subtitleSrtUrl,
                fallbackStreamUrl = plan.fallbackUrl,
                fallbackMimeType = plan.fallbackMime,
                isHevcVideo = plan.isHevcVideo,
                isTrackReload = isTrackReload,
                isLiveTranscode = plan.isPrimaryLiveTranscode,
                basePositionOffsetMs = plan.primaryBaseOffsetMs,
                isFallbackLiveTranscode = plan.isFallbackLiveTranscode,
                fallbackBaseOffsetMs = plan.fallbackBaseOffsetMs
            )
        }
    }

    private fun connectToDlnaSmartTv(tv: UnifiedTvDevice.DlnaSmartTv) {
        val resumePosMs = getCurrentEffectivePositionMs()
        connectToDlnaDeviceDirect(tv.device, tv.id, resumePosMs)
    }

    private fun connectToDlnaDeviceDirect(device: DlnaDevice, deviceId: String, resumePosMs: Long) {
        val lss = localStreamServer
        if (lss == null || lss.listeningPort <= 0) {
            Toast.makeText(this, "Servidor local de streaming aún no preparado", Toast.LENGTH_SHORT).show()
            return
        }
        val lanIp = LanNetworkUtils.getBestLanIpv4(this, device.host)
        if (lanIp.isNullOrBlank()) {
            Toast.makeText(this, "Conecta el móvil a la misma red Wi-Fi que ${device.friendlyName}", Toast.LENGTH_LONG).show()
            return
        }

        requestNotificationPermissionIfNeeded()

        // End any active Google Cast session cleanly without resuming local ExoPlayer
        if (isGoogleCasting || sessionManager?.currentCastSession != null) {
            suppressLocalResumeOnCastEnd = true
            isGoogleCasting = false
            try {
                sessionManager?.endCurrentSession(true)
                MediaRouter.getInstance(this).unselect(MediaRouter.UNSELECT_REASON_STOPPED)
            } catch (_: Throwable) {}
        }

        isDlnaCasting = true
        activeCastDeviceId = deviceId
        activeCastTvName = device.friendlyName
        lastCastPositionMs = resumePosMs.coerceAtLeast(0L)
        acquireCastLocks()
        parkLocalPlayerForCasting(lastCastPositionMs)

        val currentAudioOrd = userSelectedAudioOrdinal
            ?: exoCurrentlySelectedAudioOrdinal
            ?: cachedAudioOptions.firstOrNull { it.isDefault }?.ordinal
            ?: 0
        lastWorkingCastAudioOrdinal = userSelectedAudioOrdinal ?: currentAudioOrd
        lastWorkingCastAudioTrackNum = cachedAudioOptions.getOrNull(lastWorkingCastAudioOrdinal ?: 0)?.matroskaTrackNumber

        CastSessionCoordinator.beginDlnaCastSession(
            context = this,
            streamServer = lss,
            media = buildCurrentCastMediaMetadata(),
            trackState = buildCurrentTrackSelectionState(),
            device = device,
            deviceId = deviceId,
            startPosMs = lastCastPositionMs,
            knownDurationMs = lastKnownLocalDurationMs
        )
        updateCastUiIndicators()

        launchDlnaStreamForCurrentState(
            device = device,
            startPosMs = lastCastPositionMs,
            isTrackReload = false
        )
    }

    /**
     * Reloads the active Smart TV (DLNA or Google Cast) stream at the exact current playback position
     * when the user changes Audio language or Subtitles from the phone during an active cast session.
     */
    private fun reloadActiveCastForTrackChange(toastLabel: String) {
        if (localStreamServer == null) return
        val resumePosMs = getCurrentEffectivePositionMs()

        if (isDlnaCasting) {
            val activeDev = dlnaController.activeDevice ?: return
            Toast.makeText(
                this,
                "$toastLabel • Aplicando en ${activeDev.friendlyName}...",
                Toast.LENGTH_SHORT
            ).show()
            launchDlnaStreamForCurrentState(
                device = activeDev,
                startPosMs = resumePosMs,
                isTrackReload = true
            )
            return
        }

        if (isGoogleCasting) {
            val session = sessionManager?.currentCastSession
            if (session != null && session.isConnected) {
                Toast.makeText(
                    this,
                    "$toastLabel • Aplicando en $activeCastTvName...",
                    Toast.LENGTH_SHORT
                ).show()
                loadMediaIntoGoogleCastSession(session, resumePosMs)
            }
        }
    }

    private fun connectToGoogleCastTv(tv: UnifiedTvDevice.GoogleCastTv) {
        val lss = localStreamServer
        if (lss == null || lss.listeningPort <= 0) {
            Toast.makeText(this, "Servidor local de streaming aún no preparado", Toast.LENGTH_SHORT).show()
            return
        }
        val lanIp = LanNetworkUtils.getBestLanIpv4(this, tv.hostIp)
        if (lanIp.isNullOrBlank()) {
            Toast.makeText(this, "Conecta el móvil a la misma red Wi-Fi que ${tv.name}", Toast.LENGTH_LONG).show()
            return
        }

        requestNotificationPermissionIfNeeded()
        val resumePosMs = getCurrentEffectivePositionMs()

        if (isDlnaCasting) {
            dlnaController.stopSession(notifyListener = false)
            localStreamServer?.stopLiveTranscode()
            isDlnaCasting = false
        }

        isGoogleCasting = true
        activeCastDeviceId = tv.id
        activeCastTvName = tv.name
        lastCastPositionMs = resumePosMs
        pendingGoogleCastStartMs = resumePosMs
        acquireCastLocks()
        parkLocalPlayerForCasting(resumePosMs)

        CastSessionCoordinator.beginGoogleCastConnecting(
            context = this,
            streamServer = lss,
            media = buildCurrentCastMediaMetadata(),
            trackState = buildCurrentTrackSelectionState(),
            tvName = tv.name,
            deviceId = tv.id,
            startPosMs = resumePosMs,
            knownDurationMs = lastKnownLocalDurationMs
        )

        layoutCastStatusCard.visibility = View.VISIBLE
        tvCastActiveTitle.text = "📺 Conectando con ${tv.name}..."
        tvCastActiveSubtitle.text = "Iniciando Google Cast..."
        loadingSpinner.visibility = View.VISIBLE
        updateCastUiIndicators()

        val currentSession = sessionManager?.currentCastSession
        try {
            if (currentSession != null && currentSession.isConnected && tv.route.isSelected) {
                pendingGoogleCastStartMs = 0L
                loadMediaIntoGoogleCastSession(currentSession, resumePosMs)
            } else if (currentSession != null && currentSession.isConnected) {
                suppressLocalResumeOnCastEnd = true
                pendingGoogleCastRouteAfterEnd = tv.route
                sessionManager?.endCurrentSession(true)
            } else {
                tv.route.select()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Google Cast route select error: ${e.message}", e)
            CastSessionCoordinator.detachCastToLocalPlayback(this)
            isGoogleCasting = false
            loadingSpinner.visibility = View.GONE
            Toast.makeText(this, "No se pudo conectar con ${tv.name}", Toast.LENGTH_SHORT).show()
            resumeLocalPlayerAfterCast(resumePosMs)
        }
    }

    private fun disconnectCastAndResumeLocally() {
        suppressLocalResumeOnCastEnd = true
        val fallbackPos = getCurrentEffectivePositionMs()
        val (handedOffServer, coordinatorResumePosMs) = CastSessionCoordinator.detachCastToLocalPlayback(this)
        if (handedOffServer != null) {
            localStreamServer = handedOffServer
        }
        val resumePosMs = if (coordinatorResumePosMs > 0L || fallbackPos == 0L) {
            coordinatorResumePosMs
        } else {
            fallbackPos
        }.coerceAtLeast(0L)

        isDlnaCasting = false
        isGoogleCasting = false
        activeCastDeviceId = null
        activeCastTvName = ""
        lastCastPositionMs = resumePosMs
        loadingSpinner.visibility = View.GONE
        releaseCastLocks()
        updateCastUiIndicators()

        val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        ensureLocalProgressTrackingStarted(phone, contentId, season, episode)

        Log.i(TAG, "📱 Resuming playback locally on phone after casting at advanced position ${resumePosMs}ms")
        resumeLocalPlayerAfterCast(resumePosMs)
        Toast.makeText(
            this,
            "📱 Reanudando aquí en ${formatTime(resumePosMs)}",
            Toast.LENGTH_SHORT
        ).show()
    }

    /**
     * Stops local ExoPlayer decoding & HTTP 127.0.0.1 buffering while casting so the Smart TV
     * gets 100% of Wi-Fi + TDLib bandwidth and the phone uses minimal battery.
     */
    private fun parkLocalPlayerForCasting(positionMs: Long) {
        player?.currentTracks?.let { snapshotExoTracksCatalog(it) }
        val dur = player?.duration ?: 0L
        if (dur > 0L && dur != C.TIME_UNSET) {
            lastKnownLocalDurationMs = dur
        }
        lastCastPositionMs = positionMs.coerceAtLeast(0L)
        try {
            player?.pause()
            player?.stop()
        } catch (_: Exception) {}
    }

    private fun resumeLocalPlayerAfterCast(resumePosMs: Long) {
        layoutCastStatusCard.visibility = View.GONE
        val url = localStreamServer?.let {
            if (it.listeningPort > 0) "http://127.0.0.1:${it.listeningPort}/stream" else null
        } ?: currentPlayUrl ?: return

        val safePos = resumePosMs.coerceAtLeast(0L)
        pendingResumePositionMs = safePos
        playUrl(url, safePos)
    }

    private fun attachToRunningCastSession(
        activeServer: LocalStreamServer,
        activeMedia: CastSessionCoordinator.CastMediaMetadata
    ) {
        Log.i(TAG, "🔗 Re-attaching PlayerActivity to ongoing ForegroundService cast session: ${activeMedia.title}")
        localStreamServer = activeServer
        multipartParts = activeMedia.multipartParts
        storedSevenZipArchive = activeMedia.storedSevenZip
        currentFileId = activeMedia.fileId
        currentMimeType = activeMedia.mimeType
        currentTitle = activeMedia.title
        currentEffectiveFileSize = activeServer.getEffectiveSizeBytes().takeIf { it > 0L } ?: activeMedia.fileSize
        currentPlayUrl = "http://127.0.0.1:${activeServer.listeningPort}/stream"

        val wifiIp = LanNetworkUtils.getBestLanIpv4(this)
        castStreamUrl = if (wifiIp != null && activeServer.listeningPort > 0) {
            "http://$wifiIp:${activeServer.listeningPort}/stream/cast.mp4"
        } else {
            null
        }

        val savedTracks = CastSessionCoordinator.getSavedTrackState()
        cachedAudioOptions = savedTracks.audioOptions
        cachedSubtitleOptions = savedTracks.subtitleOptions
        exoCurrentlySelectedAudioOrdinal = savedTracks.exoAudioOrdinal
        exoCurrentlySelectedSubtitleOrdinal = savedTracks.exoSubtitleOrdinal
        userSelectedAudioOrdinal = savedTracks.userAudioOrdinal
        userSelectedAudioTrackNum = savedTracks.userAudioTrackNum
        lastWorkingCastAudioOrdinal = savedTracks.lastWorkingAudioOrdinal
        lastWorkingCastAudioTrackNum = savedTracks.lastWorkingAudioTrackNum
        userSubtitleMode = savedTracks.userSubtitleMode
        userSelectedSubtitleOrdinal = savedTracks.userSubtitleOrdinal
        userSelectedSubtitleTrackNum = savedTracks.userSubtitleTrackNum
        if (cachedAudioOptions.isEmpty() && cachedSubtitleOptions.isEmpty()) {
            prewarmMatroskaTrackCatalog(activeServer)
        }

        val snap = CastSessionCoordinator.getSnapshot()
        isDlnaCasting = snap.mode == CastSessionCoordinator.CastMode.DLNA
        isGoogleCasting = snap.mode == CastSessionCoordinator.CastMode.GOOGLE_CAST
        activeCastDeviceId = snap.deviceId
        activeCastTvName = snap.tvName
        lastCastPositionMs = snap.positionMs
        if (snap.durationMs > 0L) {
            lastKnownLocalDurationMs = snap.durationMs
        }

        setupUnifiedCastEngine()
        initExoPlayer()

        loadingSpinner.visibility = if (snap.isConnecting) View.VISIBLE else View.GONE
        layoutCastStatusCard.visibility = View.VISIBLE
        tvCastActiveTitle.text = if (snap.isConnecting) {
            "📺 Conectando con ${snap.tvName}..."
        } else {
            "📺 Emitiendo en ${snap.tvName}"
        }
        tvCastActiveSubtitle.text = snap.subtitleText.ifBlank { "Reproduciendo en TV" }
        btnPlayPause.setImageResource(
            if (snap.isPlaying) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play
        )

        ensureLocalProgressTrackingStarted(
            activeMedia.phone,
            activeMedia.contentId,
            activeMedia.season,
            activeMedia.episode
        )
        updateCastUiIndicators()
        updateSeekBar()
        startSeekBarUpdater()
        showTitle(currentTitle)
        showControls()
    }

    private fun startNewMovieOnConnectedTv(
        target: CastSessionCoordinator.AutoContinueCastTarget,
        startPosMs: Long
    ) {
        val safeStart = startPosMs.coerceAtLeast(0L)
        when (target) {
            is CastSessionCoordinator.AutoContinueCastTarget.Dlna -> {
                connectToDlnaDeviceDirect(target.device, target.deviceId, safeStart)
            }
            is CastSessionCoordinator.AutoContinueCastTarget.GoogleCast -> {
                val currentSession = sessionManager?.currentCastSession
                if (currentSession != null && currentSession.isConnected) {
                    activeCastDeviceId = target.deviceId
                    activeCastTvName = target.tvName
                    lastCastPositionMs = safeStart
                    loadMediaIntoGoogleCastSession(currentSession, safeStart)
                } else {
                    val url = currentPlayUrl ?: return
                    playUrl(url, safeStart)
                }
            }
        }
    }

    private fun returnToCatalogWhileCasting() {
        if (!isAnyCastActive()) {
            finish()
            return
        }
        syncCurrentTracksToCoordinator()
        CastSessionCoordinator.triggerImmediateProgressSync()
        val tvLabel = activeCastTvName.ifBlank { "la TV" }
        Toast.makeText(
            applicationContext,
            "📺 Sigue en $tvLabel • Navega por el catálogo o usa otras apps",
            Toast.LENGTH_SHORT
        ).show()
        isDetachingKeepCastAlive = true
        finish()
    }

    private fun requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                try {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                        9401
                    )
                } catch (_: Throwable) {}
            }
        }
    }

    private fun buildCurrentCastMediaMetadata(): CastSessionCoordinator.CastMediaMetadata {
        val activeMedia = CastSessionCoordinator.activeMedia
        return CastSessionCoordinator.CastMediaMetadata(
            fileId = currentFileId,
            multipartParts = multipartParts,
            multipartJson = intent.getStringExtra(EXTRA_MULTIPART_JSON) ?: activeMedia?.multipartJson,
            fileSize = currentEffectiveFileSize,
            mimeType = currentMimeType,
            title = currentTitle,
            chatId = intent.getLongExtra(EXTRA_CHAT_ID, activeMedia?.chatId ?: 0L),
            msgId = intent.getLongExtra(EXTRA_MSG_ID, activeMedia?.msgId ?: 0L),
            phone = intent.getStringExtra(EXTRA_PHONE) ?: activeMedia?.phone.orEmpty(),
            contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: activeMedia?.contentId.orEmpty(),
            season = intent.getStringExtra(EXTRA_SEASON) ?: activeMedia?.season.orEmpty(),
            episode = intent.getStringExtra(EXTRA_EPISODE) ?: activeMedia?.episode.orEmpty(),
            creditsStart = intent.getStringExtra(EXTRA_CREDITS_START) ?: activeMedia?.creditsStart.orEmpty(),
            introStartMs = intent.getStringExtra(EXTRA_INTRO_START_MS) ?: activeMedia?.introStartMs.orEmpty(),
            introEndMs = intent.getStringExtra(EXTRA_INTRO_END_MS) ?: activeMedia?.introEndMs.orEmpty(),
            introDbCreditsMs = intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: activeMedia?.introDbCreditsMs.orEmpty(),
            storedSevenZip = storedSevenZipArchive
        )
    }

    private fun buildCurrentTrackSelectionState(): CastSessionCoordinator.SavedTrackSelectionState {
        return CastSessionCoordinator.SavedTrackSelectionState(
            audioOptions = cachedAudioOptions,
            subtitleOptions = cachedSubtitleOptions,
            exoAudioOrdinal = exoCurrentlySelectedAudioOrdinal,
            exoSubtitleOrdinal = exoCurrentlySelectedSubtitleOrdinal,
            userAudioOrdinal = userSelectedAudioOrdinal,
            userAudioTrackNum = userSelectedAudioTrackNum,
            lastWorkingAudioOrdinal = lastWorkingCastAudioOrdinal,
            lastWorkingAudioTrackNum = lastWorkingCastAudioTrackNum,
            userSubtitleMode = userSubtitleMode,
            userSubtitleOrdinal = userSelectedSubtitleOrdinal,
            userSubtitleTrackNum = userSelectedSubtitleTrackNum
        )
    }

    private fun syncCurrentTracksToCoordinator() {
        if (CastSessionCoordinator.isCastingActive) {
            CastSessionCoordinator.updateSavedTrackState(buildCurrentTrackSelectionState())
        }
    }

    override fun onNewIntent(newIntent: Intent) {
        super.onNewIntent(newIntent)
        val attachOnly = newIntent.getBooleanExtra(EXTRA_ATTACH_ACTIVE_CAST, false)
        val newFileId = newIntent.getIntExtra(EXTRA_FILE_ID, -1)
        if (attachOnly || (newFileId > 0 && newFileId == currentFileId)) {
            showControls()
            updateSeekBar()
            return
        }
        if (isAnyCastActive()) {
            isDetachingKeepCastAlive = true
        }
        setIntent(newIntent)
        recreate()
    }

    private fun updateCastUiIndicators() {
        val active = isAnyCastActive()
        val iconRes = if (active) R.drawable.ic_cast_tv_connected else R.drawable.ic_cast_tv
        btnCastUnified.setImageResource(iconRes)
        btnCastBottom.setImageResource(iconRes)
        if (active) {
            layoutCastStatusCard.visibility = View.VISIBLE
            castContainer.visibility = View.VISIBLE
            castContainer.alpha = 1f
        } else {
            layoutCastStatusCard.visibility = View.GONE
        }
    }

    private fun acquireCastLocks() {
        try {
            if (castWakeLock == null) {
                val pm = applicationContext.getSystemService(Context.POWER_SERVICE) as? PowerManager
                castWakeLock = pm?.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Cineflix:CastStreamWakeLock")?.apply {
                    setReferenceCounted(false)
                }
            }
            if (castWakeLock?.isHeld == false) {
                // 4-hour max safety timeout so WakeLock can never leak indefinitely
                castWakeLock?.acquire(4L * 60L * 60L * 1000L)
            }
        } catch (e: Throwable) {
            Log.w(TAG, "WakeLock warning: ${e.message}")
        }

        try {
            if (castWifiLock == null) {
                val wm = applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
                @Suppress("DEPRECATION")
                val lockMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    WifiManager.WIFI_MODE_FULL_LOW_LATENCY
                } else {
                    WifiManager.WIFI_MODE_FULL_HIGH_PERF
                }
                castWifiLock = wm?.createWifiLock(lockMode, "Cineflix:CastWifiLock")?.apply {
                    setReferenceCounted(false)
                }
            }
            if (castWifiLock?.isHeld == false) {
                castWifiLock?.acquire()
            }
        } catch (e: Throwable) {
            Log.w(TAG, "WifiLock warning: ${e.message}")
        }
    }

    private fun releaseCastLocks() {
        try {
            if (castWakeLock?.isHeld == true) {
                castWakeLock?.release()
            }
        } catch (_: Throwable) {}
        try {
            if (castWifiLock?.isHeld == true) {
                castWifiLock?.release()
            }
        } catch (_: Throwable) {}
    }

    // --- Lifecycle & Progress ---
    override fun onResume() {
        super.onResume()
        hideSystemUI()
        unifiedTvDiscovery?.startActiveDiscovery(forceRefresh = false)
        if (!isAnyCastActive() && wasPlaying) {
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
        if (isAnyCastActive()) {
            // Keep LocalStreamServer & WakeLock/WifiLock streaming smoothly to the TV while screen is off!
            wasPlaying = false
            return
        }
        wasPlaying = player?.isPlaying == true
        if (wasPlaying) {
            player?.pause()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("savedPosition", getCurrentEffectivePositionMs())
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
        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null

        cleanup()
    }

    private fun cleanup() {
        if (isCleanedUp) return
        isCleanedUp = true
        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null

        if (CastSessionCoordinator.playerUiListener === castUiListener) {
            CastSessionCoordinator.playerUiListener = null
        }
        castUiListener = null

        var finalPosition = -1L
        var finalDuration = 0L
        try {
            finalPosition = getCurrentEffectivePositionMs()
            finalDuration = getCurrentEffectiveDurationMs()
        } catch (_: Exception) {}

        try { activeCastDialog?.dismiss() } catch (_: Exception) {}
        activeCastDialog = null

        try { unifiedTvDiscovery?.destroy() } catch (_: Exception) {}
        unifiedTvDiscovery = null

        try {
            castSessionListener?.let { sessionManager?.removeSessionManagerListener(it, CastSession::class.java) }
        } catch (_: Exception) {}

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
        releaseCastLocks()
        scope.cancel()

        // If user pressed Back / "📚 Catálogo" while casting, CastPlaybackService keeps the TV stream alive!
        if (isDetachingKeepCastAlive && CastSessionCoordinator.isCastingActive) {
            syncCurrentTracksToCoordinator()
            localStreamServer = null
            Log.i(TAG, "📺 PlayerActivity detached cleanly; CastPlaybackService continues TV playback in background")
            return
        }

        // If casting was still active during non-detached termination, delegate full cleanup to coordinator
        if (CastSessionCoordinator.isCastingActive) {
            localStreamServer = null
            CastSessionCoordinator.stopCastingCompletely(this, notifyAttachedPlayerToClose = false)
            return
        }

        val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""

        isDlnaCasting = false
        isGoogleCasting = false

        val ownedServer = localStreamServer
        localStreamServer = null
        try { proxyServer?.stop() } catch (_: Exception) {}
        proxyServer = null
        try { ownedServer?.stop() } catch (_: Exception) {}
        com.cineflix.android.GramJSStreamManager.currentPlaybackId = ""

        if (ownedServer != null) {
            val engine = TelegramEngine.getInstance(this)
            val fileId = currentFileId.takeIf { it > 0 } ?: intent.getIntExtra(EXTRA_FILE_ID, -1)
            if (fileId > 0) {
                engine.cancelAndDeleteVideo(fileId)
            }
            multipartParts?.forEach { part ->
                engine.cancelAndDeleteVideo(part.fileId)
            }
            engine.optimizeStorage(30L * 1024 * 1024, immunityDelaySec = 0)
        }

        if (phone.isNotEmpty() && contentId.isNotEmpty() && finalPosition > 0) {
            CoroutineScope(Dispatchers.IO).launch {
                sendProgressPingDirect(phone, contentId, season, episode, finalPosition, finalDuration)
            }
        }
    }

    private fun ensureLocalProgressTrackingStarted(
        phone: String,
        contentId: String,
        season: String,
        episode: String
    ) {
        if (localProgressTrackingStarted || phone.isEmpty() || contentId.isEmpty()) return
        localProgressTrackingStarted = true
        startProgressTracking(phone, contentId, season, episode)
    }

    private fun startProgressTracking(phone: String, contentId: String, season: String, episode: String) {
        scope.launch {
            while (isActive) {
                delay(30_000)
                if (isAnyCastActive()) continue
                try {
                    val currentPos = getCurrentEffectivePositionMs()
                    val durationMs = getCurrentEffectiveDurationMs()
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
