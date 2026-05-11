package com.cineflix.android.ui.player

import android.app.AlertDialog
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
import android.view.SurfaceView
import android.view.View
import android.view.WindowManager
import android.widget.Button
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
import org.videolan.libvlc.LibVLC
import org.videolan.libvlc.Media
import org.videolan.libvlc.MediaPlayer
import org.videolan.libvlc.interfaces.IVLCVout
import com.cineflix.android.R

class PlayerActivity : AppCompatActivity(), IVLCVout.Callback {

    private var libVLC: LibVLC? = null
    private var mediaPlayer: MediaPlayer? = null
    private var proxyServer: StreamProxyServer? = null
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    // UI
    private lateinit var surfaceView: SurfaceView
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

    private val titleHandler = Handler(Looper.getMainLooper())
    private val controlsHandler = Handler(Looper.getMainLooper())
    private val seekBarHandler = Handler(Looper.getMainLooper())

    private var controlsVisible = true
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

        // 4. Iniciar VLC
        initVLC()
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
                                if (mediaPlayer != null) {
                                    mediaPlayer?.time = savedProgress * 1000L
                                    Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress/60}m", Toast.LENGTH_SHORT).show()
                                }
                            }, 2500)
                        }
                    }
                } catch (e: Exception) {}
            }
            startProgressTracking(phone, contentId, season, episode)
        }

        showTitle(title)
        scheduleHideControls()
        setupCastSessionListener()

        // 7. Progress tracking
        if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            startProgressTracking(phone, contentId, season, episode)
        }
    }

    private fun bindViews() {
        surfaceView = findViewById(R.id.video_surface)
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
    }

    private fun setupListeners() {
        btnPlayPause.setOnClickListener { togglePlayPause() }
        btnRewind.setOnClickListener { seekRelative(-10000); showControls() }
        btnForward.setOnClickListener { seekRelative(10000); showControls() }
        btnResize.setOnClickListener { toggleResizeMode() }
        btnTracks.setOnClickListener { showTrackSelectorBottomSheet() }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser && mediaPlayer != null) mediaPlayer?.position = progress / 1000f
            }
            override fun onStartTrackingTouch(bar: SeekBar) { isSeeking = true }
            override fun onStopTrackingTouch(bar: SeekBar) { isSeeking = false }
        })

        surfaceView.setOnClickListener { toggleControls() }
    }

    private fun initVLC() {
        val options = arrayListOf(
            "--aout=opensles",
            "--audio-time-stretch",
            "-vvv",
            "--avcodec-skiploopfilter=1",
            "--avcodec-skip-frame=0",
            "--avcodec-skip-idct=0",
            "--network-caching=5000" // Aumentado a 5s para Telegram
        )

        libVLC = LibVLC(this, options)
        mediaPlayer = MediaPlayer(libVLC)

        val vlcVout = mediaPlayer?.vlcVout
        vlcVout?.setVideoView(surfaceView)
        vlcVout?.addCallback(this)
        vlcVout?.attachViews()

        mediaPlayer?.setEventListener { event ->
            when (event.type) {
                MediaPlayer.Event.Playing -> {
                    if (savedPosition > 0L) {
                        mediaPlayer?.time = savedPosition
                        savedPosition = 0L
                    }
                    runOnUiThread { 
                        loadingSpinner.visibility = View.GONE
                        btnPlayPause.setImageResource(android.R.drawable.ic_media_pause) 
                    }
                }
                MediaPlayer.Event.Paused -> runOnUiThread {
                    btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
                }
                MediaPlayer.Event.Buffering -> {
                    val buf = event.buffering
                    runOnUiThread { loadingSpinner.visibility = if (buf < 100f) View.VISIBLE else View.GONE }
                }
                MediaPlayer.Event.EndReached -> runOnUiThread { finish() }
                MediaPlayer.Event.EncounteredError -> runOnUiThread {
                    Toast.makeText(this, "Error de reproducción", Toast.LENGTH_SHORT).show()
                    finish()
                }
                MediaPlayer.Event.Vout -> runOnUiThread { updateVideoSurface() }
                MediaPlayer.Event.TimeChanged, MediaPlayer.Event.LengthChanged -> runOnUiThread { updateSeekBar() }
            }
        }
    }

    private fun playUrl(url: String) {
        loadingSpinner.visibility = View.VISIBLE
        val media = Media(libVLC, Uri.parse(url))
        media.setHWDecoderEnabled(true, false)
        media.addOption(":network-caching=5000")
        media.addOption(":clock-jitter=0")
        media.addOption(":clock-synchro=0")
        mediaPlayer?.media = media
        media.release()
        mediaPlayer?.play()
        
        startSeekBarUpdater()
    }

    // --- VLC Size/Aspect Ratio ---
    private fun updateVideoSurface() {
        val mp = mediaPlayer ?: return
        val vlcVout = mp.vlcVout
        var sw = surfaceView.width
        var sh = surfaceView.height
        if (sw == 0 || sh == 0) {
            sw = window.decorView.width
            sh = window.decorView.height
        }
        vlcVout.setWindowSize(sw, sh)
        mp.aspectRatio = null
        mp.scale = 0f
    }

    private fun toggleResizeMode() {
        val mp = mediaPlayer ?: return
        val dm = android.util.DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(dm)
        val sw = dm.widthPixels
        val sh = dm.heightPixels
        if (sw == 0 || sh == 0) return

        currentScaleIndex = (currentScaleIndex + 1) % 4
        var modeName = ""

        when (currentScaleIndex) {
            0 -> {
                mp.aspectRatio = null
                mp.scale = 0f
                modeName = "Ajustar (Fit)"
            }
            1 -> {
                mp.scale = 0f
                mp.aspectRatio = "$sw:$sh"
                modeName = "Llenar (Fill)"
            }
            2 -> {
                mp.aspectRatio = null
                mp.scale = 2.0f
                modeName = "Zoom (Cortar bordes)"
            }
            3 -> {
                mp.aspectRatio = "16:9"
                mp.scale = 0f
                modeName = "16:9 Forzado"
            }
        }
        Toast.makeText(this, modeName, Toast.LENGTH_SHORT).show()
        showControls()
    }

    // --- Unified Track Selector ---
    private fun showTrackSelectorBottomSheet() {
        val mp = mediaPlayer ?: return
        
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
            setPadding(0, 0, 0, dpToPx(16))
        }
        audioColumn.addView(audioTitle)

        val audioGroup = android.widget.RadioGroup(this)
        val audioTracks = mp.audioTracks
        val currentAudioId = mp.audioTrack

        if (audioTracks != null) {
            for (track in audioTracks) {
                if (track.id == -1 || track.name.equals("Disable", ignoreCase = true)) continue
                val rb = android.widget.RadioButton(this).apply {
                    text = track.name
                    setTextColor(android.graphics.Color.WHITE)
                    buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                    isChecked = track.id == currentAudioId
                    setPadding(0, dpToPx(8), 0, dpToPx(8))
                    setOnClickListener { mp.audioTrack = track.id; bottomSheetDialog.dismiss() }
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
        val spuTracks = mp.spuTracks
        val currentSpuId = mp.spuTrack
        
        // Disable subtitle option
        val rbSubDisable = android.widget.RadioButton(this).apply {
            text = "Desactivar"
            setTextColor(android.graphics.Color.WHITE)
            buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
            isChecked = currentSpuId == -1
            setPadding(0, dpToPx(8), 0, dpToPx(8))
            setOnClickListener { mp.spuTrack = -1; bottomSheetDialog.dismiss() }
        }
        subGroup.addView(rbSubDisable)

        if (spuTracks != null) {
            for (track in spuTracks) {
                if (track.id == -1 || track.name.equals("Disable", ignoreCase = true)) continue
                val rb = android.widget.RadioButton(this).apply {
                    text = track.name
                    setTextColor(android.graphics.Color.WHITE)
                    buttonTintList = android.content.res.ColorStateList.valueOf(android.graphics.Color.parseColor("#7c3aed"))
                    isChecked = track.id == currentSpuId
                    setPadding(0, dpToPx(8), 0, dpToPx(8))
                    setOnClickListener { mp.spuTrack = track.id; bottomSheetDialog.dismiss() }
                }
                subGroup.addView(rb)
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
            setOnClickListener { bottomSheetDialog.dismiss() }
        }
        mainLayout.addView(btnClose)

        bottomSheetDialog.setContentView(mainLayout)
        (mainLayout.parent as? View)?.setBackgroundColor(android.graphics.Color.TRANSPARENT)
        
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
        bottomBar.visibility = View.VISIBLE
        bottomBar.animate().alpha(1f).setDuration(200).start()
        centerControls.visibility = View.VISIBLE
        centerControls.animate().alpha(1f).setDuration(200).start()
        castContainer.visibility = View.VISIBLE
        castContainer.animate().alpha(1f).setDuration(200).start()
        controlsVisible = true
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

    private fun updateSeekBar() {
        if (mediaPlayer == null || isSeeking) return
        val time = mediaPlayer!!.time
        val duration = mediaPlayer!!.length
        if (duration > 0) {
            seekBar.max = 1000
            seekBar.progress = (mediaPlayer!!.position * 1000).toInt()
            tvTimeCurrent.text = formatTime(time)
            tvTimeDuration.text = formatTime(duration)
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
            
            // Ocultar título automáticamente después de 2 segundos, independientemente de los controles
            titleHandler.removeCallbacksAndMessages(null)
            titleHandler.postDelayed({
                tvVideoTitle.animate().alpha(0f).setDuration(500).withEndAction { 
                    tvVideoTitle.visibility = View.GONE 
                }.start()
            }, 2000)
        }
    }

    private fun seekRelative(deltaMs: Long) {
        val mp = mediaPlayer ?: return
        val current = mp.time
        val duration = mp.length
        if (duration <= 0) return
        val target = Math.max(0, Math.min(current + deltaMs, duration))
        mp.time = target
        updateSeekBar()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val mp = mediaPlayer ?: return super.onKeyDown(keyCode, event)
        when (keyCode) {
            KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> {
                togglePlayPause()
                return true
            }
            KeyEvent.KEYCODE_DPAD_RIGHT -> {
                seekRelative(10000)
                showControls()
                return true
            }
            KeyEvent.KEYCODE_DPAD_LEFT -> {
                seekRelative(-10000)
                showControls()
                return true
            }
            KeyEvent.KEYCODE_DPAD_UP -> {
                seekRelative(60000)
                showControls()
                return true
            }
            KeyEvent.KEYCODE_DPAD_DOWN -> {
                seekRelative(-60000)
                showControls()
                return true
            }
            KeyEvent.KEYCODE_BACK -> {
                if (controlsVisible) {
                    hideControls()
                    return true
                }
                finish()
                return true
            }
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
            finalPosition = mediaPlayer?.time ?: -1L
            finalDuration = mediaPlayer?.length ?: 0L
        } catch (e: Exception) {}

        try {
            castSessionListener?.let { sessionManager?.removeSessionManagerListener(it, CastSession::class.java) }
        } catch (_: Exception) {}

        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer?.vlcVout?.removeCallback(this)
            mediaPlayer?.release()
        }
        libVLC?.release()

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

        // Final ping
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        if (phone.isNotEmpty() && contentId.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                sendProgressPing(phone, contentId, season, episode)
            }
        }
    }

    private var progressTrackingJob: Job? = null

    private fun startProgressTracking(phone: String, contentId: String, season: String, episode: String) {
        progressTrackingJob = scope.launch {
            while (isActive) {
                delay(30_000) // Every 30 seconds
                sendProgressPing(phone, contentId, season, episode)
            }
        }
    }

    private fun sendProgressPing(phone: String, contentId: String, season: String, episode: String) {
        val currentPosition = player?.currentPosition ?: return
        if (currentPosition <= 0) return
        
        val progressSeconds = (currentPosition / 1000).toInt()
        val durationMs = player?.duration ?: 0
        val isFinished = durationMs > 0 && currentPosition >= (durationMs - 5000)

        try {
            val url = java.net.URL("https://cineflix-production-19e3.up.railway.app/api/progress")
            val conn = url.openConnection() as java.net.HttpURLConnection
            conn.requestMethod = "POST"
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            conn.setRequestProperty("x-user-phone", phone)
            conn.doOutput = true

            val json = org.json.JSONObject().apply {
                put("content_id", contentId)
                put("season", if (season.isEmpty()) org.json.JSONObject.NULL else season.toIntOrNull() ?: org.json.JSONObject.NULL)
                put("episode", if (episode.isEmpty()) org.json.JSONObject.NULL else episode.toIntOrNull() ?: org.json.JSONObject.NULL)
                put("progress_seconds", progressSeconds)
                put("is_finished", isFinished)
            }

            conn.outputStream.use { os ->
                val input = json.toString().toByteArray(Charsets.UTF_8)
                os.write(input, 0, input.size)
            }

            val responseCode = conn.responseCode
            if (responseCode == 200) {
                Log.d(TAG, "Watch progress synced: $progressSeconds s")
            } else {
                Log.e(TAG, "Watch progress sync failed: HTTP $responseCode")
            }
            conn.disconnect()
        } catch (e: Exception) {
            Log.e(TAG, "Error sending watch progress: ${e.message}")
        }
    }

    private fun startProgressTracking(phone: String, contentId: String, season: String, episode: String) {
        scope.launch {
            while (isActive) {
                delay(30_000)
                try {
                    val currentPos = mediaPlayer?.time ?: -1L
                    val durationMs = mediaPlayer?.length ?: 0L
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
                    put("content_id", contentId)
                    put("season", if (season.isEmpty()) org.json.JSONObject.NULL else season.toIntOrNull() ?: org.json.JSONObject.NULL)
                    put("episode", if (episode.isEmpty()) org.json.JSONObject.NULL else episode.toIntOrNull() ?: org.json.JSONObject.NULL)
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

    override fun onSurfacesCreated(vlcVout: IVLCVout) {}
    override fun onSurfacesDestroyed(vlcVout: IVLCVout) {}
}
