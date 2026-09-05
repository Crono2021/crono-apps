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

// LibVLC
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.util.VLCVideoLayout

class PlayerActivity : AppCompatActivity() {

    private var libVLC: LibVLC? = null
    private var mediaPlayer: MediaPlayer? = null
    private var proxyServer: StreamProxyServer? = null
    private var multipartParts: List<FilePart>? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    // UI
    private lateinit var vlcVideoLayout: VLCVideoLayout
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

    private var controlsVisible = false
    private var isSeeking = false
    private var wasPlaying = false
    private var savedPosition = 0L

    // Aspect Ratio Scaling
    private val scaleTypes = arrayOf(
        MediaPlayer.ScaleType.SURFACE_BEST_FIT to "Mejor Ajuste (Original)",
        MediaPlayer.ScaleType.SURFACE_FIT_SCREEN to "Ajustar Pantalla",
        MediaPlayer.ScaleType.SURFACE_FILL to "Llenar Pantalla",
        MediaPlayer.ScaleType.SURFACE_16_9 to "16:9",
        MediaPlayer.ScaleType.SURFACE_4_3 to "4:3"
    )
    private var currentScaleIndex = 0

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
        const val EXTRA_STREAM_URL    = "stream_url"
        const val EXTRA_MULTIPART_JSON = "multipart_json"
        const val EXTRA_FILE_ID       = "file_id"
        const val EXTRA_FILE_SIZE     = "file_size"
        const val EXTRA_MIME_TYPE     = "mime_type"
        const val EXTRA_TITLE         = "title"
        const val EXTRA_CHAT_ID       = "chat_id"
        const val EXTRA_MSG_ID        = "msg_id"
        
        const val EXTRA_PHONE         = "phone"
        const val EXTRA_CONTENT_ID    = "content_id"
        const val EXTRA_SEASON        = "season"
        const val EXTRA_EPISODE       = "episode"
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
        window.decorView.setBackgroundColor(android.graphics.Color.BLACK)
        hideSystemUI()

        setContentView(R.layout.activity_player)
        
        bindViews()
        setupListeners()

        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val phone      = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId  = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season     = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode    = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        val jsProgress = intent.getStringExtra(EXTRA_PROGRESS)

        currentMimeType = mimeType
        currentTitle = title

        // 1. Check direct stream URL mode (e.g. GramJS proxy mode)
        val streamUrlExtra = intent.getStringExtra(EXTRA_STREAM_URL)
        if (!streamUrlExtra.isNullOrEmpty()) {
            Log.i(TAG, "▶ Direct stream mode — URL: $streamUrlExtra")
            initLibVlc()
            handleProgressAndPlay(streamUrlExtra, jsProgress, phone, contentId, season, episode)
            showTitle(title)
            scheduleHideControls()
            setupCastSessionListener()
            return
        }

        // 2. Parse multipart JSON if present
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

        var fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (multipartParts != null && multipartParts!!.isNotEmpty()) {
            fileId = multipartParts!![0].fileId
        }

        if (fileId <= 0) {
            Toast.makeText(this, "Error: fileId inválido ($fileId)", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val multipartTotalSize = multipartParts?.sumOf { it.size } ?: 0L
        val effectiveFileSize = if (multipartTotalSize > 0L) multipartTotalSize else fileSize

        val engine = TelegramEngine.getInstance(this)

        // 3. Start local StreamProxyServer (NanoHTTPD)
        val proxy = StreamProxyServer(
            engine   = engine,
            fileId   = fileId,
            fileSize = effectiveFileSize,
            mimeType = mimeType,
            multipartParts = multipartParts,
        )
        proxy.start()
        proxyServer = proxy
        val port = proxy.listeningPort
        Log.i(TAG, "▶ StreamProxyServer started on port $port for LibVLC (fileSize=$effectiveFileSize)")

        // 4. Determine file extension so LibVLC prioritizes demuxer immediately
        val ext = if (mimeType.contains("matroska", ignoreCase = true) || mimeType.contains("mkv", ignoreCase = true)) {
            ".mkv"
        } else if (mimeType.contains("mp4", ignoreCase = true)) {
            ".mp4"
        } else {
            ".mkv"
        }

        val localStreamUrl = "http://127.0.0.1:$port/stream$ext"
        val wifiIp = getWifiIpAddress()
        castStreamUrl = if (wifiIp != null) "http://$wifiIp:$port/stream$ext" else null

        setupCastButton()

        // 5. Iniciar LibVLC
        initLibVlc()

        // 6. Apply progress and start tracking
        handleProgressAndPlay(localStreamUrl, jsProgress, phone, contentId, season, episode)

        showTitle(title)
        scheduleHideControls()
        setupCastSessionListener()
    }

    private fun handleProgressAndPlay(
        streamUrl: String,
        jsProgress: String?,
        phone: String,
        contentId: String,
        season: String,
        episode: String
    ) {
        if (jsProgress != null) {
            // JavaScript provided progress (either 0 or resume timestamp) - trust it immediately!
            val p = jsProgress.toFloatOrNull()?.toInt() ?: 0
            if (p > 5) {
                playUrl(streamUrl, resumeSeconds = p.toLong())
                Toast.makeText(this@PlayerActivity, "Reanudado en ${p/60}m", Toast.LENGTH_SHORT).show()
            } else {
                playUrl(streamUrl)
            }
        } else if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            // Fallback: fast fetch with 1s timeout to avoid delaying playback start
            scope.launch {
                try {
                    val savedProgress = kotlinx.coroutines.withTimeoutOrNull(1000L) {
                        fetchSavedProgress(phone, contentId, season, episode)
                    } ?: 0
                    withContext(Dispatchers.Main) {
                        if (savedProgress > 5) {
                            playUrl(streamUrl, resumeSeconds = savedProgress.toLong())
                            Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress/60}m", Toast.LENGTH_SHORT).show()
                        } else {
                            playUrl(streamUrl)
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) { playUrl(streamUrl) }
                }
            }
        } else {
            playUrl(streamUrl)
        }

        if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            startProgressTracking(phone, contentId, season, episode)
        }
    }

    private fun bindViews() {
        vlcVideoLayout = findViewById(R.id.video_surface)
        vlcVideoLayout.setBackgroundColor(android.graphics.Color.BLACK)
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
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer?.time = progress.toLong()
                }
            }
            override fun onStartTrackingTouch(bar: SeekBar) { isSeeking = true }
            override fun onStopTrackingTouch(bar: SeekBar) { isSeeking = false }
        })

        vlcVideoLayout.setOnClickListener { toggleControls() }
        
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
                mediaPlayer?.time = introEndMs
                layoutSkipIntro.visibility = View.GONE
                Log.i(TAG, "Skip Intro -> seekTo($introEndMs ms)")
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

    private fun initLibVlc() {
        val options = ArrayList<String>().apply {
            // Audio output: use default Android AudioTrack sink (avoids OpenSL ES sample rate issues on Android 14/Samsung)
            add("--audio-time-stretch")

            // Hardware decoding: try MediaCodec first; if it exceeds chip capabilities (e.g. HEVC 10-bit),
            // LibVLC automatically and seamlessly falls back to FFmpeg software decoding (libhevc)!
            add("--avcodec-hw=any")

            // Network caching for local HTTP proxy (2000ms ensures smooth playback over Telegram CDN latency)
            add("--network-caching=2000")
            add("--file-caching=2000")
            add("--live-caching=2000")

            // Performance optimizations for TV multi-core CPUs
            add("--avcodec-skiploopfilter=1")
            add("--avcodec-fast")
            add("--avcodec-threads=0")
            add("--no-video-title-show")
            add("--drop-late-frames")
            add("--skip-frames")
        }

        libVLC = LibVLC(this, options)
        mediaPlayer = MediaPlayer(libVLC)
        mediaPlayer?.attachViews(vlcVideoLayout, null, true, false)

        // Configuración de audio: Modo PCM universal (estéreo/envolvente por software) por defecto.
        // El passthrough digital bitstream (5.1/7.1 directo) solo se activa si el usuario lo solicita explícitamente en ajustes.
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        val enablePassthrough = prefs.getBoolean("enable_audio_passthrough", false)
        mediaPlayer?.setAudioDigitalOutputEnabled(enablePassthrough)
        Log.i(TAG, "LibVLC digital audio passthrough (bitstream 5.1/7.1): $enablePassthrough")

        mediaPlayer?.setEventListener { event ->
            when (event.type) {
                MediaPlayer.Event.Buffering -> {
                    if (event.buffering < 100f) {
                        loadingSpinner.visibility = View.VISIBLE
                    } else {
                        loadingSpinner.visibility = View.GONE
                    }
                }
                MediaPlayer.Event.Playing -> {
                    loadingSpinner.visibility = View.GONE
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_pause)
                    scheduleHideControls()
                }
                MediaPlayer.Event.Paused -> {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
                }
                MediaPlayer.Event.Stopped -> {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
                }
                MediaPlayer.Event.EndReached -> {
                    triggerNextEpisode()
                }
                MediaPlayer.Event.EncounteredError -> {
                    loadingSpinner.visibility = View.GONE
                    Log.e(TAG, "LibVLC EncounteredError during playback")
                    if (!isFallbackRetrying && lastPlayedUrl != null) {
                        isFallbackRetrying = true
                        Log.w(TAG, "EncounteredError: reintentando automáticamente con decodificación software FFmpeg y audio seguro PCM")
                        mediaPlayer?.setAudioDigitalOutputEnabled(false)
                        val currentTime = mediaPlayer?.time?.let { if (it > 0) it / 1000L else 0L } ?: lastResumeSeconds
                        playUrl(lastPlayedUrl!!, resumeSeconds = currentTime, forceSoftware = true)
                    } else {
                        Toast.makeText(this@PlayerActivity, "Error en reproducción", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
                MediaPlayer.Event.TimeChanged -> {
                    if (loadingSpinner.visibility == View.VISIBLE && event.timeChanged > 300) {
                        loadingSpinner.visibility = View.GONE
                    }
                    updateProgress(event.timeChanged)
                }
                MediaPlayer.Event.LengthChanged -> {
                    val duration = event.lengthChanged
                    if (duration > 0) {
                        seekBar.max = duration.toInt()
                        tvTimeDuration.text = formatTime(duration)
                    }
                }
            }
        }
    }

    private var isFallbackRetrying = false
    private var lastPlayedUrl: String? = null
    private var lastResumeSeconds: Long = 0L

    private fun playUrl(url: String, resumeSeconds: Long = 0L, forceSoftware: Boolean = false) {
        lastPlayedUrl = url
        lastResumeSeconds = resumeSeconds
        loadingSpinner.visibility = View.GONE
        
        val vlc = libVLC ?: return
        val mp = mediaPlayer ?: return

        try {
            val media = Media(vlc, Uri.parse(url)).apply {
                if (forceSoftware) {
                    setHWDecoderEnabled(false, false)
                    addOption(":codec=all")
                    Log.i(TAG, "playUrl: fallback pure SOFTWARE decoding (libhevc/FFmpeg)")
                } else {
                    setHWDecoderEnabled(true, false)
                }
                addOption(":network-caching=2000")
                addOption(":file-caching=2000")
                addOption(":live-caching=2000")
                addOption(":no-video-title-show")
                addOption(":http-reconnect=true")
                if (resumeSeconds > 5) {
                    addOption(":start-time=$resumeSeconds")
                }
            }
            mp.media = media
            media.release()
            mp.play()
        } catch (e: Exception) {
            Log.e(TAG, "Error playing URL: $url", e)
            Toast.makeText(this, "Error al iniciar reproducción", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    // --- Video Scaling ---
    private fun toggleResizeMode() {
        currentScaleIndex = (currentScaleIndex + 1) % scaleTypes.size
        val (scaleType, name) = scaleTypes[currentScaleIndex]
        mediaPlayer?.videoScale = scaleType
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        showControls()
    }

    // --- Unified Audio & Subtitles Selector ---
    private fun showTrackSelectorBottomSheet() {
        val mp = mediaPlayer ?: return
        
        val bottomSheetDialog = com.google.android.material.bottomsheet.BottomSheetDialog(this)
        
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(android.graphics.Color.parseColor("#1A1A1A"))
            setPadding(0, dpToPx(16), 0, dpToPx(16))
        }

        val columnsLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            weightSum = 2f
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        }

        // --- COLUMNA AUDIO ---
        val audioColumn = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(dpToPx(16), 0, dpToPx(8), 0)
            }
        }
        val audioTitle = TextView(this).apply {
            text = "🔊 AUDIO"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 14f
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            setPadding(0, 0, 0, dpToPx(8))
        }
        audioColumn.addView(audioTitle)

        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        val isPassthroughEnabled = prefs.getBoolean("enable_audio_passthrough", false)

        val cbPassthrough = android.widget.CheckBox(this).apply {
            text = "Passthrough Digital (Receptor 5.1 / HDMI ARC)"
            setTextColor(android.graphics.Color.LTGRAY)
            textSize = 12f
            buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
            isChecked = isPassthroughEnabled
            isFocusable = true
            setPadding(0, 0, 0, dpToPx(8))
            setOnCheckedChangeListener { _, isChecked ->
                prefs.edit().putBoolean("enable_audio_passthrough", isChecked).apply()
                mp.setAudioDigitalOutputEnabled(isChecked)
                val currentTrack = mp.audioTrack
                if (currentTrack != -1) {
                    mp.audioTrack = -1
                    mp.audioTrack = currentTrack
                }
                Toast.makeText(
                    this@PlayerActivity,
                    if (isChecked) "Passthrough digital (5.1 directo) activado" else "Modo estéreo/PCM estándar activado",
                    Toast.LENGTH_SHORT
                ).show()
            }
            setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    v.animate().scaleX(1.05f).scaleY(1.05f).setDuration(150).start()
                    (v as? android.widget.CheckBox)?.setTextColor(android.graphics.Color.WHITE)
                } else {
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150).start()
                    (v as? android.widget.CheckBox)?.setTextColor(android.graphics.Color.LTGRAY)
                }
            }
        }
        audioColumn.addView(cbPassthrough)

        val audioGroup = android.widget.RadioGroup(this)
        val audioTracks = mp.audioTracks
        val currentAudioId = mp.audioTrack

        if (audioTracks != null) {
            for (track in audioTracks) {
                if (track.id == -1) continue // Skip disabled audio
                val rb = android.widget.RadioButton(this).apply {
                    text = track.name
                    setTextColor(android.graphics.Color.WHITE)
                    buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                    isChecked = (track.id == currentAudioId)
                    setPadding(0, dpToPx(8), 0, dpToPx(8))
                    setOnClickListener {
                        mp.audioTrack = track.id
                        bottomSheetDialog.dismiss()
                    }
                }
                audioGroup.addView(rb)
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
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(dpToPx(8), 0, dpToPx(16), 0)
            }
        }
        val subTitle = TextView(this).apply {
            text = "💬 SUBTÍTULOS"
            setTextColor(android.graphics.Color.WHITE)
            textSize = 14f
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = android.view.Gravity.CENTER
            setPadding(0, 0, 0, dpToPx(16))
        }
        subColumn.addView(subTitle)

        val subGroup = android.widget.RadioGroup(this)
        val spuTracks = mp.spuTracks
        val currentSpuId = mp.spuTrack

        // Opción Desactivar
        val rbSubDisable = android.widget.RadioButton(this).apply {
            text = "Desactivar"
            setTextColor(android.graphics.Color.WHITE)
            buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
            isChecked = (currentSpuId == -1 || currentSpuId == 0)
            setPadding(0, dpToPx(8), 0, dpToPx(8))
            setOnClickListener {
                mp.spuTrack = -1
                bottomSheetDialog.dismiss()
            }
        }
        subGroup.addView(rbSubDisable)

        if (spuTracks != null) {
            for (track in spuTracks) {
                if (track.id == -1) continue
                val rb = android.widget.RadioButton(this).apply {
                    text = track.name
                    setTextColor(android.graphics.Color.WHITE)
                    buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                    isChecked = (track.id == currentSpuId)
                    setPadding(0, dpToPx(8), 0, dpToPx(8))
                    setOnClickListener {
                        mp.spuTrack = track.id
                        bottomSheetDialog.dismiss()
                    }
                }
                subGroup.addView(rb)
            }
        }
        subColumn.addView(subGroup)

        columnsLayout.addView(audioColumn)
        columnsLayout.addView(separator)
        columnsLayout.addView(subColumn)

        val scrollView = android.widget.ScrollView(this).apply {
            addView(columnsLayout)
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1f)
        }
        mainLayout.addView(scrollView)

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
        val mp = mediaPlayer ?: return
        if (mp.isPlaying) mp.pause() else mp.play()
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
            if (mediaPlayer?.isPlaying == true) hideControls()
        }, 4000)
    }

    private fun updateProgress(time: Long) {
        if (isSeeking) return
        val duration = mediaPlayer?.length ?: 0L
        if (duration > 0) {
            seekBar.max = duration.toInt()
            seekBar.progress = time.toInt()
            tvTimeCurrent.text = formatTime(time)
            tvTimeDuration.text = formatTime(duration)

            // Skip Intro overlay logic
            val introStartMs = (intent.getStringExtra(EXTRA_INTRO_START_MS) ?: "").toLongOrNull()
            val introEndMs   = (intent.getStringExtra(EXTRA_INTRO_END_MS)   ?: "").toLongOrNull()

            if (introStartMs != null && introEndMs != null && introEndMs > introStartMs) {
                val inIntro = time in introStartMs..introEndMs
                if (inIntro) {
                    if (layoutSkipIntro.visibility != View.VISIBLE) {
                        layoutSkipIntro.visibility = View.VISIBLE
                        layoutSkipIntro.alpha = 0f
                        layoutSkipIntro.animate().alpha(1f).setDuration(300).start()
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

            // Next Episode overlay logic
            val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
            if (contentId.startsWith("tv_")) {
                val creditsStartStr = intent.getStringExtra(EXTRA_CREDITS_START)
                val creditsStartSeconds = creditsStartStr?.toIntOrNull()
                val introDbCreditsMs = (intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "").toLongOrNull()

                val shouldShow: Boolean
                val secondsLeft: Int

                if (creditsStartSeconds != null) {
                    val creditsStartMs = creditsStartSeconds * 1000L
                    shouldShow = time >= creditsStartMs
                    secondsLeft = if (time < duration) ((duration - time) / 1000).toInt() else 0
                } else if (introDbCreditsMs != null && introDbCreditsMs > 0) {
                    shouldShow = time >= introDbCreditsMs
                    secondsLeft = if (time < duration) ((duration - time) / 1000).toInt() else 0
                } else {
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
        val mp = mediaPlayer ?: return
        val current = mp.time
        val duration = mp.length
        if (duration <= 0) return
        val target = Math.max(0L, Math.min(current + deltaMs, duration))
        mp.time = target
        updateProgress(target)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
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
        // Skip Cast SDK on Android TV / Leanback (the TV is already the display)
        val isTv = packageManager.hasSystemFeature(android.content.pm.PackageManager.FEATURE_LEANBACK)
        if (isTv) return

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
                mediaPlayer?.pause()

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
                    .setCurrentTime(mediaPlayer?.time ?: 0L)
                    .build()

                session.remoteMediaClient?.load(loadRequest)
                Toast.makeText(this@PlayerActivity, "Enviando a Chromecast...", Toast.LENGTH_SHORT).show()
            }
            override fun onSessionResuming(session: CastSession, sessionId: String) {}
            override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
                isCasting = true
                mediaPlayer?.pause()
            }
            override fun onSessionResumeFailed(session: CastSession, error: Int) {}
            override fun onSessionSuspended(session: CastSession, reason: Int) {}
            override fun onSessionEnding(session: CastSession) {}
            override fun onSessionEnded(session: CastSession, error: Int) {
                isCasting = false
                mediaPlayer?.play()
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
            mediaPlayer?.play()
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
        wasPlaying = mediaPlayer?.isPlaying == true
        if (wasPlaying) {
            mediaPlayer?.pause()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("savedPosition", mediaPlayer?.time ?: 0L)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedPosition = savedInstanceState.getLong("savedPosition", 0L)
    }

    override fun onDestroy() {
        super.onDestroy()
        titleHandler.removeCallbacksAndMessages(null)
        controlsHandler.removeCallbacksAndMessages(null)
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
            finalPosition = mediaPlayer?.time ?: -1L
            finalDuration = mediaPlayer?.length ?: 0L
        } catch (_: Exception) {}

        try {
            castSessionListener?.let { sessionManager?.removeSessionManagerListener(it, CastSession::class.java) }
        } catch (_: Exception) {}

        try {
            mediaPlayer?.stop()
            mediaPlayer?.detachViews()
            mediaPlayer?.release()
            mediaPlayer = null
        } catch (e: Exception) {
            Log.e(TAG, "Error releasing mediaPlayer", e)
        }

        try {
            libVLC?.release()
            libVLC = null
        } catch (e: Exception) {
            Log.e(TAG, "Error releasing libVLC", e)
        }

        try { proxyServer?.stop() } catch (_: Exception) {}
        scope.cancel()

        val fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)
        if (!multipartParts.isNullOrEmpty()) {
            for (part in multipartParts!!) {
                TelegramEngine.getInstance(this).cancelAndDeleteVideo(part.fileId)
            }
        } else if (fileId > 0) {
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
                    val currentPos = mediaPlayer?.time ?: -1L
                    val durationMs = mediaPlayer?.length ?: 0L
                    if (currentPos > 0) {
                        sendProgressPingDirect(phone, contentId, season, episode, currentPos, durationMs)
                    }
                } catch (e: Exception) {}
            }
        }
    }

    private suspend fun sendProgressPingDirect(phone: String, contentId: String, season: String, episode: String, currentPosition: Long, durationMs: Long) {
        if (currentPosition <= 0) return
        val progressSeconds = (currentPosition / 1000).toInt()
        val isFinished = durationMs > 0 && currentPosition >= (durationMs - 5000)

        val fileTitle = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val fileChatId = intent.getStringExtra(EXTRA_CHAT_ID) ?: ""
        val fileMsgId = intent.getStringExtra(EXTRA_MSG_ID) ?: ""
        val fileId = intent.getIntExtra(EXTRA_FILE_ID, -1)

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
                    if (fileTitle.isNotEmpty()) put("file_title", fileTitle)
                    if (fileChatId.isNotEmpty()) put("file_chat_id", fileChatId)
                    if (fileMsgId.isNotEmpty()) put("file_msg_id", fileMsgId)
                    if (fileId > 0) put("file_id", fileId)
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