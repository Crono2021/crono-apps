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
    private lateinit var loadingSpinner: ProgressBar
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
        
        const val EXTRA_PHONE      = "phone"
        const val EXTRA_CONTENT_ID = "content_id"
        const val EXTRA_SEASON     = "season"
        const val EXTRA_EPISODE    = "episode"
        const val EXTRA_CREDITS_START = "credits_start"

        // TheIntroDB extras
        const val EXTRA_INTRO_START_MS       = "intro_start_ms"
        const val EXTRA_INTRO_END_MS         = "intro_end_ms"
        const val EXTRA_INTRODB_CREDITS_MS   = "introdb_credits_ms"

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

        val fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        
        val phone      = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId  = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season     = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode    = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        
        val engine   = TelegramEngine.getInstance(this)

        currentMimeType = mimeType
        currentTitle = title

        Log.i(TAG, "▶ onCreate — fileId=$fileId fileSize=$fileSize mimeType=$mimeType title=$title contentId=$contentId")
        // ── Diagnostic: dump ALL TheIntroDB extras ──
        val dbgIntroStart = intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "(null)"
        val dbgIntroEnd   = intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "(null)"
        val dbgCreditsMs  = intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "(null)"
        val dbgCreditsStart = intent.getStringExtra(EXTRA_CREDITS_START) ?: "(null)"
        Log.w(TAG, "🎬 DIAG IntroDB extras — introStart='$dbgIntroStart' introEnd='$dbgIntroEnd' introDbCredits='$dbgCreditsMs' creditsStart='$dbgCreditsStart' contentId='$contentId' season='$season' episode='$episode'")

        if (fileId <= 0) {
            Toast.makeText(this, "Error: fileId inválido ($fileId)", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        var effectiveFileSize = fileSize
        if (effectiveFileSize <= 0) {
            effectiveFileSize = 2_000_000_000L
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
                engine.startDownloadReturnPath(fileId, priority = 32)
                engine.hintDownloadOffset(fileId, 0L, 20L * 1024L * 1024L)
            } catch (e: Exception) {
                Log.e(TAG, "▶ TDLib registration error: ${e.message}", e)
            }
        }

        // 3. Build stream URLs
        val localStreamUrl = "http://127.0.0.1:$port/stream"
        val wifiIp = getWifiIpAddress()
        castStreamUrl = if (wifiIp != null) "http://$wifiIp:$port/stream" else null
        
        setupCastButton()

        // 4. Iniciar ExoPlayer
        initExoPlayer()
        playUrl(localStreamUrl)

        // 5. Fetch saved progress y trackear
        if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            scope.launch {
                try {
                    val savedProgress = fetchSavedProgress(phone, contentId, season, episode)
                    if (savedProgress > 30) {
                        withContext(Dispatchers.Main) {
                            // Delay to ensure buffer starts before seek
                            Handler(Looper.getMainLooper()).postDelayed({
                                player?.let {
                                    it.seekTo(savedProgress * 1000L)
                                    Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress/60}m", Toast.LENGTH_SHORT).show()
                                }
                            }, 1000)
                        }
                    }
                } catch (e: Exception) {}
            }
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
        btnTracks.setOnClickListener { showTrackSelectorBottomSheet() }

        setupFocusAnimation(btnPlayPause)
        setupFocusAnimation(btnRewind)
        setupFocusAnimation(btnForward)
        setupFocusAnimation(btnResize)
        setupFocusAnimation(btnTracks)

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
            triggerNextEpisode()
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
                player?.seekTo(introEndMs)
                layoutSkipIntro.visibility = View.GONE
                Log.i(TAG, "⏭ Skip Intro → seekTo($introEndMs ms)")
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
        val forceSoftware = prefs.getBoolean("force_software_audio", false)
        val mode = if (forceSoftware) DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER 
                   else DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON

        val renderersFactory = DefaultRenderersFactory(this)
            .setExtensionRendererMode(mode)

        player = ExoPlayer.Builder(this)
            .setRenderersFactory(renderersFactory)
            .build()
            
        playerView.player = player
        playerView.useController = false

        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (playbackState == Player.STATE_BUFFERING) {
                    loadingSpinner.visibility = View.VISIBLE
                } else {
                    loadingSpinner.visibility = View.GONE
                }

                if (playbackState == Player.STATE_ENDED) {
                    triggerNextEpisode()
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
                Toast.makeText(this@PlayerActivity, "Error de reproducción", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }

    private fun playUrl(url: String) {
        loadingSpinner.visibility = View.VISIBLE
        val mediaItem = MediaItem.fromUri(Uri.parse(url))
        player?.setMediaItem(mediaItem)
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

    // --- Unified Track Selector ---
    private fun showTrackSelectorBottomSheet() {
        val p = player ?: return
        
        val bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog(this)
        
        // Layout principal
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(android.graphics.Color.parseColor("#1A1A1A"))
            setPadding(0, dpToPx(16), 0, dpToPx(16))
        }

        // Layout horizontal para columnas
        val columnsLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            weightSum = 2f
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        }

        // --- COLUMNA AUDIO ---
        val audioColumn = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply { setMargins(dpToPx(16), 0, dpToPx(8), 0) }
        }
        val audioTitle = TextView(this).apply {
            text = "\uD83D\uDD0A AUDIO"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 14f
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            setPadding(0, 0, 0, dpToPx(8))
        }
        audioColumn.addView(audioTitle)

        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        val forceSoftware = prefs.getBoolean("force_software_audio", false)

        val cbForceSoftware = android.widget.CheckBox(this).apply {
            text = "Compatibilidad Estéreo"
            setTextColor(android.graphics.Color.LTGRAY)
            textSize = 12f
            buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
            isChecked = forceSoftware
            setPadding(0, 0, 0, dpToPx(8))
            setOnClickListener {
                val newState = isChecked
                prefs.edit().putBoolean("force_software_audio", newState).apply()
                val currentPos = player?.currentPosition ?: 0L
                player?.release()
                player = null
                initExoPlayer()
                val port = proxyServer?.listeningPort ?: 8080
                playUrl("http://127.0.0.1:$port/stream")
                player?.seekTo(currentPos)
                bottomSheetDialog.dismiss()
                Toast.makeText(this@PlayerActivity, if (newState) "Audio por software forzado" else "Passthrough activado", Toast.LENGTH_SHORT).show()
            }
        }
        audioColumn.addView(cbForceSoftware)

        val audioGroup = android.widget.RadioGroup(this)
        val tracks = p.currentTracks

        var audioIdCounter = 0
        for (trackGroup in tracks.groups) {
            if (trackGroup.type == C.TRACK_TYPE_AUDIO) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    var name = format.language ?: "Pista ${audioIdCounter + 1}"
                    if (format.label != null) {
                        name = format.label!!
                    }
                    val isSelected = trackGroup.isTrackSelected(i)

                    val rb = android.widget.RadioButton(this).apply {
                        text = name
                        setTextColor(android.graphics.Color.WHITE)
                        buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                        isChecked = isSelected
                        setPadding(0, dpToPx(8), 0, dpToPx(8))
                        setOnClickListener { 
                            p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                                .setOverrideForType(TrackSelectionOverride(trackGroup.mediaTrackGroup, i))
                                .build()
                            bottomSheetDialog.dismiss() 
                        }
                    }
                    audioGroup.addView(rb)
                    audioIdCounter++
                }
            }
        }
        audioColumn.addView(audioGroup)

        // Separador central
        val separator = View(this).apply {
            setBackgroundColor(android.graphics.Color.parseColor("#333333"))
            layoutParams = LinearLayout.LayoutParams(dpToPx(1), LinearLayout.LayoutParams.MATCH_PARENT)
        }

        // --- COLUMNA SUBTÍTULOS ---
        val subColumn = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply { setMargins(dpToPx(8), 0, dpToPx(16), 0) }
        }
        val subTitle = TextView(this).apply {
            text = "\uD83D\uDCAC SUBTÍTULOS"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 14f
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            setPadding(0, 0, 0, dpToPx(16))
        }
        subColumn.addView(subTitle)

        val subGroup = android.widget.RadioGroup(this)
        
        val hasSelectedSub = tracks.groups.any { it.type == C.TRACK_TYPE_TEXT && it.isSelected }

        val rbSubDisable = android.widget.RadioButton(this).apply {
            text = "Desactivar"
            setTextColor(android.graphics.Color.WHITE)
            buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
            isChecked = !hasSelectedSub
            setPadding(0, dpToPx(8), 0, dpToPx(8))
            setOnClickListener { 
                p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                    .clearOverridesOfType(C.TRACK_TYPE_TEXT)
                    .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                    .build()
                bottomSheetDialog.dismiss() 
            }
        }
        subGroup.addView(rbSubDisable)

        var subIdCounter = 0
        for (trackGroup in tracks.groups) {
            if (trackGroup.type == C.TRACK_TYPE_TEXT) {
                for (i in 0 until trackGroup.length) {
                    val format = trackGroup.getTrackFormat(i)
                    var name = format.language ?: "Sub ${subIdCounter + 1}"
                    if (format.label != null) {
                        name = format.label!!
                    }
                    val isSelected = trackGroup.isTrackSelected(i)

                    val rb = android.widget.RadioButton(this).apply {
                        text = name
                        setTextColor(android.graphics.Color.WHITE)
                        buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                        isChecked = isSelected
                        setPadding(0, dpToPx(8), 0, dpToPx(8))
                        setOnClickListener { 
                            p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                                .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, false)
                                .setOverrideForType(TrackSelectionOverride(trackGroup.mediaTrackGroup, i))
                                .build()
                            bottomSheetDialog.dismiss() 
                        }
                    }
                    subGroup.addView(rb)
                    subIdCounter++
                }
            }
        }
        subColumn.addView(subGroup)

        columnsLayout.addView(audioColumn)
        columnsLayout.addView(separator)
        columnsLayout.addView(subColumn)

        // ScrollView para contenido largo
        val scrollView = android.widget.ScrollView(this).apply {
            addView(columnsLayout)
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f)
        }
        mainLayout.addView(scrollView)

        // Botón cerrar
        val btnClose = TextView(this).apply {
            text = "Cerrar"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 16f
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            setPadding(0, dpToPx(20), 0, dpToPx(8))
            isFocusable = true
            isClickable = true
            setOnFocusChangeListener { view, hasFocus ->
                view.setBackgroundColor(if (hasFocus) android.graphics.Color.parseColor("#7c3aed") else android.graphics.Color.TRANSPARENT)
            }
            setOnClickListener { bottomSheetDialog.dismiss() }
        }
        mainLayout.addView(btnClose)

        bottomSheetDialog.setContentView(mainLayout)
        (mainLayout.parent as? View)?.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        
        bottomSheetDialog.setOnDismissListener {
            btnPlayPause.requestFocus()
        }
        
        bottomSheetDialog.setOnShowListener { dialog ->
            val d = dialog as com.google.android.material.bottomsheet.BottomSheetDialog
            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            if (bottomSheet != null) {
                val behavior = com.google.android.material.bottomsheet.BottomSheetBehavior.from(bottomSheet)
                behavior.state = com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
                behavior.skipCollapsed = true
            }
        }
        
        bottomSheetDialog.show()
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

            // ── Skip Intro overlay ──────────────────────────────────────
            val introStartMs = (intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "").toLongOrNull()
            val introEndMs   = (intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "").toLongOrNull()

            // ── DIAGNOSTIC LOG (once per session) ──
            if (!_diagLoggedOnce && time > 1000) {
                _diagLoggedOnce = true
                val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
                val creditsStr = intent.getStringExtra(EXTRA_CREDITS_START) ?: "(null)"
                val introDbCr = intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "(null)"
                Log.w(TAG, "🔍 DIAG updateSeekBar — time=$time dur=$duration introStartMs=$introStartMs introEndMs=$introEndMs contentId='$contentId' creditsStart='$creditsStr' introDbCreditsMs='$introDbCr' isTvPrefix=${contentId.startsWith("tv_")}")
            }

            if (introStartMs != null && introEndMs != null && introEndMs > introStartMs) {
                val inIntro = time in introStartMs..introEndMs
                if (inIntro) {
                    if (layoutSkipIntro.visibility != View.VISIBLE) {
                        layoutSkipIntro.visibility = View.VISIBLE
                        layoutSkipIntro.alpha = 0f
                        layoutSkipIntro.animate().alpha(1f).setDuration(300).start()
                        Log.i(TAG, "🎬 SHOWING Skip Intro overlay (time=$time in $introStartMs..$introEndMs)")
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
            }

            // ── Next Episode overlay ────────────────────────────────────
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
                        Log.i(TAG, "🎬 SHOWING Next Episode overlay (time=$time, secondsLeft=$secondsLeft)")
                        // Hide skip intro if next episode appears (avoid visual clash)
                        if (layoutSkipIntro.visibility == View.VISIBLE) {
                            layoutSkipIntro.visibility = View.GONE
                        }
                    }
                    tvNextEpisodeCountdown.text = "Siguiente en ${secondsLeft}s"
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

    override fun onDestroy() {
        super.onDestroy()
        titleHandler.removeCallbacksAndMessages(null)
        controlsHandler.removeCallbacksAndMessages(null)
        seekBarHandler.removeCallbacksAndMessages(null)

        cleanup()
    }

    private fun cleanup() {
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

        player?.release()
        player = null

        try { proxyServer?.stop() } catch (_: Exception) {}
        scope.cancel()

        val fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (fileId > 0) {
            TelegramEngine.getInstance(this).cancelAndDeleteVideo(fileId)
        }

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
                val url = java.net.URL("https://cineflix-production-19e3.up.railway.app/api/progress")
                val conn = url.openConnection() as java.net.HttpURLConnection
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
                conn.disconnect()
            } catch (e: Exception) {}
        }
    }

    private suspend fun fetchSavedProgress(phone: String, contentId: String, season: String, episode: String): Int {
        return withContext(Dispatchers.IO) {
            try {
                val url = java.net.URL("https://cineflix-production-19e3.up.railway.app/api/progress")
                val conn = url.openConnection() as java.net.HttpURLConnection
                conn.requestMethod = "GET"
                conn.setRequestProperty("x-user-phone", phone)
                conn.connectTimeout = 5000
                conn.readTimeout = 5000

                if (conn.responseCode == 200) {
                    val body = conn.inputStream.bufferedReader().readText()
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
            } catch (e: Exception) { 0 }
        }
    }
}
