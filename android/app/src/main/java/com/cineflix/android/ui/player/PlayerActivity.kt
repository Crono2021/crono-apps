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
import androidx.core.view.ViewCompat
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
import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.Rational
import android.util.TypedValue
import android.view.Gravity
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.Timeline
import androidx.media3.common.TrackSelectionOverride
import androidx.media3.common.Tracks
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.upstream.DefaultAllocator
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.cineflix.android.MainActivity
import com.cineflix.android.util.StorageAndRamHygiene
import java.lang.ref.WeakReference

private typealias CachedTrackOption = CastSessionCoordinator.CastTrackOption

class PlayerActivity : AppCompatActivity() {

    private var player: ExoPlayer? = null
    private var playerAllocator: DefaultAllocator? = null
    private var proxyServer: StreamProxyServer? = null
    private var localStreamServer: LocalStreamServer? = null
    private var multipartParts: List<FilePart>? = null
    private var xrayController: XrayOverlayController? = null
    private var liveTvSqueezeController: LiveTvSqueezeBackController? = null
    private lateinit var rootFrame: FrameLayout
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Unhandled coroutine exception in PlayerActivity", throwable)
    }
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)
    private var streamStartupJob: Job? = null

    // Live TV, PiP Mini-TV & Saturday 22:00h "El Peliculón" strict sync state
    private var isLiveTvMode = false
    private var hadLiveTvSession = false
    private var isPremiereSyncLocked = false
    private var liveTvChannelId = ""
    private var liveTvChannelLabel = ""
    private var liveTvProgramDisplayTitle = ""
    private var liveTvFichaItemId = ""
    private var liveTvFichaTmdbId = 0
    private var liveTvFichaYear = ""
    private var liveTvFichaMediaType = "movie"
    private var liveTvFichaCleanTitle = ""
    private var liveTvFichaPosterPath = ""
    private var liveTvFichaPayload = ""
    private var liveTvFichaRawJson = ""
    private var liveTvTunedAtEpochMs = 0L
    private var liveTvBaseOffsetSec = 0L
    private var lastPremiereLockToastAtMs = 0L
    private var lastPremiereAutoResyncAtMs = 0L
    private var liveTvTopBar: LinearLayout? = null
    private var tvLiveTvBadgeText: TextView? = null
    private var tvLiveTvProgramTitle: TextView? = null
    private var btnLiveFicha: TextView? = null
    private var btnLiveChPrev: TextView? = null
    private var btnLiveChNext: TextView? = null
    private var btnLiveGuide: TextView? = null
    private var liveTvAutoAdvancePending = false
    private var liveTvZapPending = false
    private var isActivityPausedForLifecycle = false
    private var enteringPipUntilElapsedMs = 0L
    private var isLiveTvTopBarCompactTwoRow = false
    private var activePlayerListener: Player.Listener? = null
    private var isReleasingOrRecoveringPlayer = false
    private var hasRenderedLiveVideoFrame = false
    private var mutedPendingInitialLiveSeek = false
    private var hasSeenDpadInput = false

    private fun isTvOrDpadActive(): Boolean {
        return StorageAndRamHygiene.isTelevision(this) || hasSeenDpadInput
    }
    private var lastPastEofAdvanceSlotKey = ""
    private var castEndedAndSynced = false
    private val liveTvAutoAdvanceTimeoutRunnable = Runnable {
        if (liveTvAutoAdvancePending && !isFinishing && !isDestroyed) {
            Log.w(TAG, "Live TV 24/7 auto-advance timed out waiting for next slot; finishing cleanly")
            liveTvAutoAdvancePending = false
            isLiveTvMode = false
            hadLiveTvSession = false
            com.cineflix.android.MainActivity.stopLiveTvFromPlayer(reopenGrid = false)
            finish()
        }
    }
    private val liveTvZapTimeoutRunnable = Runnable {
        if (liveTvZapPending && !isFinishing && !isDestroyed) {
            liveTvZapPending = false
            if (player?.playbackState == Player.STATE_READY) {
                loadingSpinner.visibility = View.GONE
            }
            Toast.makeText(this, "⚠️ El canal tardó demasiado en responder", Toast.LENGTH_SHORT).show()
        }
    }

    // Background idle memory/cache reclamation (e.g. Android TV Home / Standby button)
    private var releasedWhileBackgrounded = false
    private val backgroundReleaseHandler = Handler(Looper.getMainLooper())
    private val backgroundIdleReleaseRunnable = Runnable {
        releaseHeavyResourcesWhileBackgrounded()
    }

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
    private lateinit var btnXrayToggle: TextView
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
    @Volatile private var lastKnownLocalPositionMs: Long = 0L
    @Volatile private var lastKnownLocalDurationMs: Long = 0L
    private var ioErrorRetryCount = 0
    private var decoderErrorRetryCount = 0
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
    private val googleCastLoadGeneration = java.util.concurrent.atomic.AtomicInteger(0)
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

        // Live TV PiP, Saturday Premiere Sync & Native X-Ray extras
        const val EXTRA_IS_LIVE_TV              = "is_live_tv"
        const val EXTRA_LIVE_TV_CHANNEL_ID      = "live_tv_channel_id"
        const val EXTRA_LIVE_TV_CHANNEL_LABEL   = "live_tv_channel_label"
        const val EXTRA_LIVE_TV_PROGRAM_TITLE   = "live_tv_program_title"
        const val EXTRA_LIVE_TV_ITEM_ID         = "live_tv_item_id"
        const val EXTRA_LIVE_TV_POSTER_PATH     = "live_tv_poster_path"
        const val EXTRA_LIVE_TV_PAYLOAD         = "live_tv_payload"
        const val EXTRA_LIVE_TV_RAW_ITEM_JSON   = "live_tv_raw_item_json"
        const val EXTRA_LIVE_TV_CONTINUITY_JSON = "live_tv_continuity_json"
        const val EXTRA_LIVE_TV_UP_NEXT_JSON    = "live_tv_up_next_json"
        const val EXTRA_LIVE_TV_OTHER_CHANNELS_JSON = "live_tv_other_channels_json"
        const val EXTRA_LIVE_TV_TUNED_AT_MS     = "live_tv_tuned_at_ms"
        const val EXTRA_LIVE_TV_BASE_OFFSET_SEC = "live_tv_base_offset_sec"
        const val EXTRA_IS_PREMIERE_LOCKED      = "is_premiere_locked"
        const val EXTRA_LIVE_TV_EXPAND_FROM_PIP = "live_tv_expand_from_pip"
        const val EXTRA_EXPAND_EXISTING_PIP     = "expand_existing_pip"
        const val EXTRA_XRAY_TMDB_ID            = "xray_tmdb_id"
        const val EXTRA_XRAY_YEAR               = "xray_year"
        const val EXTRA_XRAY_MEDIA_TYPE         = "xray_media_type"
        const val EXTRA_XRAY_CLEAN_TITLE        = "xray_clean_title"
        const val EXTRA_IS_KIDS_PROFILE         = "is_kids_profile"

        private const val TAG = "PlayerActivity"
        private const val BACKGROUND_IDLE_RELEASE_MS = 45_000L
        private const val LIVE_TV_AUTO_ADVANCE_TIMEOUT_MS = 35_000L

        @Volatile private var crashHandlerInstalled = false
        @Volatile private var activePlayerRef: WeakReference<PlayerActivity>? = null
        @Volatile private var lastLaunchDispatchedAtElapsedMs: Long = 0L

        internal fun shouldLockSeekForPlayback(
            isLiveTvMode: Boolean,
            isPremiereSyncLocked: Boolean
        ): Boolean = isLiveTvMode || isPremiereSyncLocked

        internal fun shouldLockPauseForPlayback(
            isLiveTvMode: Boolean,
            isPremiereSyncLocked: Boolean
        ): Boolean = isLiveTvMode || isPremiereSyncLocked

        internal data class LiveTvFichaSnapshot(
            val channelId: String,
            val channelLabel: String,
            val isPremiereLocked: Boolean,
            val programDisplayTitle: String,
            val itemId: String,
            val tmdbId: Int,
            val year: String,
            val mediaType: String,
            val cleanTitle: String,
            val posterPath: String,
            val payload: String,
            val rawItemJson: String
        )

        internal fun applyNativeZapTargetToFichaState(
            previousChannelId: String,
            previousChannelLabel: String,
            target: MainActivity.Companion.NativeZapTarget
        ): LiveTvFichaSnapshot {
            val resolvedChId = target.channelId.ifBlank { previousChannelId }
            val resolvedChLabel = target.channelLabel.ifBlank { previousChannelLabel }
            val resolvedPremiere = target.isPremiereLocked ||
                resolvedChId.equals("ch_premiere_sabado", ignoreCase = true)
            val resolvedMediaType = target.mediaType.trim().lowercase().let {
                if (it == "tv" || it == "movie") it else "movie"
            }
            val resolvedYear = target.year.trim().takeIf { it != "null" }.orEmpty()
            val resolvedCleanTitle = target.cleanTitle.trim().takeIf { it != "null" }.orEmpty()
            val resolvedDispTitle = formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = target.programTitle,
                cleanTitle = resolvedCleanTitle,
                year = resolvedYear,
                mediaType = resolvedMediaType
            )
            return LiveTvFichaSnapshot(
                channelId = resolvedChId,
                channelLabel = resolvedChLabel,
                isPremiereLocked = resolvedPremiere,
                programDisplayTitle = resolvedDispTitle,
                itemId = target.itemId.trim().takeIf { it != "null" }.orEmpty(),
                tmdbId = target.tmdbId.coerceAtLeast(0),
                year = resolvedYear,
                mediaType = resolvedMediaType,
                cleanTitle = resolvedCleanTitle,
                posterPath = target.posterPath.trim().takeIf { it != "null" }.orEmpty(),
                payload = target.payload.trim().takeIf { it != "null" }.orEmpty(),
                rawItemJson = target.rawItemJson.trim().takeIf { it != "null" }.orEmpty()
            )
        }

        internal fun formatLiveTvProgramDisplayTitle(
            explicitProgramTitle: String? = null,
            cleanTitle: String? = null,
            rawTitle: String? = null,
            year: String? = null,
            mediaType: String? = null,
            season: String? = null,
            episode: String? = null
        ): String {
            val safeYear = year?.trim()?.takeIf { it.matches(Regex("\\d{4}")) }
                ?: XrayOverlayController.extractYearFromTitle(rawTitle.orEmpty()).takeIf { it.matches(Regex("\\d{4}")) }

            val explicit = explicitProgramTitle?.trim().orEmpty()
            if (explicit.isNotEmpty() && explicit != "null") {
                return if (safeYear != null && !explicit.contains("($safeYear)")) {
                    val epSplitIdx = explicit.indexOf(" · T")
                    if (epSplitIdx > 0) {
                        explicit.substring(0, epSplitIdx).trimEnd() + " ($safeYear)" + explicit.substring(epSplitIdx)
                    } else {
                        "$explicit ($safeYear)"
                    }
                } else {
                    explicit
                }
            }

            val baseCandidate = cleanTitle?.trim()?.takeIf { it.isNotEmpty() && it != "null" }
                ?: XrayOverlayController.sanitizeLookupTitle(rawTitle.orEmpty()).ifBlank { rawTitle.orEmpty().trim() }
            if (baseCandidate.isEmpty()) return ""

            var built = baseCandidate.replace(Regex("\\s*\\(\\d{4}\\)\\s*$"), "").trim()
            if (built.isEmpty()) built = baseCandidate
            if (safeYear != null && !built.contains("($safeYear)")) {
                built = "$built ($safeYear)"
            }
            val isTv = mediaType.equals("tv", ignoreCase = true)
            val sNum = season?.trim()?.toIntOrNull() ?: 0
            val eNum = episode?.trim()?.toIntOrNull() ?: 0
            if (isTv && sNum > 0 && eNum > 0 && !Regex("\\b(?:T\\d+[·.]?E\\d+|\\d+x\\d+)\\b", RegexOption.IGNORE_CASE).containsMatchIn(built)) {
                built = "$built · T${sNum}·E${eNum}"
            }
            return built
        }

        internal fun shouldIgnoreDuplicateNewIntent(
            attachOnly: Boolean,
            newFileId: Int,
            currentFileId: Int,
            sameMultipart: Boolean,
            sameLiveMode: Boolean,
            sameLiveChannel: Boolean,
            releasedWhileBackgrounded: Boolean,
            liveTvAutoAdvancePending: Boolean,
            liveTvZapPending: Boolean
        ): Boolean {
            if (attachOnly) return true
            return newFileId > 0 &&
                newFileId == currentFileId &&
                sameMultipart &&
                sameLiveMode &&
                sameLiveChannel &&
                !releasedWhileBackgrounded &&
                !liveTvAutoAdvancePending &&
                !liveTvZapPending
        }

        fun markLaunchDispatched() {
            lastLaunchDispatchedAtElapsedMs = android.os.SystemClock.elapsedRealtime()
        }

        fun isPlaybackOrLaunchActive(): Boolean {
            val nowElapsed = android.os.SystemClock.elapsedRealtime()
            if (lastLaunchDispatchedAtElapsedMs > 0L && (nowElapsed - lastLaunchDispatchedAtElapsedMs) in 0L..5_000L) {
                return true
            }
            val instance = activePlayerRef?.get() ?: return false
            return !instance.isFinishing &&
                !instance.isDestroyed &&
                !instance.isCleanedUp &&
                !instance.releasedWhileBackgrounded
        }

        fun canExpandActiveLiveTvPip(expectedChannelId: String = ""): Boolean {
            val instance = activePlayerRef?.get() ?: return false
            if (instance.isFinishing || instance.isDestroyed || instance.isCleanedUp || instance.releasedWhileBackgrounded) {
                return false
            }
            if (!instance.isLiveTvMode || instance.isAnyCastActive()) return false
            if (expectedChannelId.isNotBlank() &&
                instance.liveTvChannelId.isNotBlank() &&
                !instance.liveTvChannelId.equals(expectedChannelId, ignoreCase = true)
            ) {
                return false
            }
            return instance.isInPipModeCompat()
        }

        fun finishActiveLiveTvInstanceIfAny() {
            val instance = activePlayerRef?.get() ?: return
            Handler(Looper.getMainLooper()).post {
                if (!instance.isFinishing && !instance.isDestroyed && (instance.isLiveTvMode || instance.hadLiveTvSession)) {
                    instance.liveTvAutoAdvancePending = false
                    instance.liveTvZapPending = false
                    instance.backgroundReleaseHandler.removeCallbacks(instance.liveTvAutoAdvanceTimeoutRunnable)
                    instance.backgroundReleaseHandler.removeCallbacks(instance.liveTvZapTimeoutRunnable)
                    instance.isLiveTvMode = false
                    instance.hadLiveTvSession = false
                    instance.finish()
                }
            }
        }

        /**
         * When `PlayerActivity` is already docked in a 16:9 Picture-in-Picture window over `#cf-livetv-view`
         * and the user zaps to another Live TV channel (without clicking "Volver al directo" to expand),
         * switches the stream directly in-process on the existing PiP instance so Android WindowManager
         * never yanks the user out of the guide or spawns a duplicate Activity!
         */
        fun dispatchNewIntentToActivePipIfStayInPip(newIntent: Intent): Boolean {
            val instance = activePlayerRef?.get() ?: return false
            if (instance.isFinishing || instance.isDestroyed || instance.isCleanedUp) return false
            if (!instance.isInPipModeCompat() || instance.isAnyCastActive()) return false
            val isLive = newIntent.getBooleanExtra(EXTRA_IS_LIVE_TV, false) ||
                newIntent.getBooleanExtra(EXTRA_IS_PREMIERE_LOCKED, false)
            val expandFromPip = newIntent.getBooleanExtra(EXTRA_LIVE_TV_EXPAND_FROM_PIP, false)
            if (!isLive || expandFromPip) return false

            if (Looper.myLooper() == Looper.getMainLooper()) {
                instance.onNewIntent(newIntent)
            } else {
                Handler(Looper.getMainLooper()).post {
                    if (!instance.isFinishing && !instance.isDestroyed && !instance.isCleanedUp) {
                        instance.onNewIntent(newIntent)
                    }
                }
            }
            return true
        }

        private fun installGlobalCrashHandlerOnce(appContext: Context) {
            if (crashHandlerInstalled) return
            crashHandlerInstalled = true
            val safeAppCtx = appContext.applicationContext
            val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
            Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
                try {
                    Log.e(TAG, "Uncaught exception in PlayerActivity: ${throwable.message}", throwable)
                    val active = activePlayerRef?.get()
                    val extra = mapOf(
                        "title" to (active?.currentTitle ?: "N/A"),
                        "fileId" to (active?.currentFileId ?: -1),
                        "position" to (active?.lastKnownLocalPositionMs?.toString() ?: "0")
                    )
                    com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
                        context = safeAppCtx,
                        reason = "Crash No Controlado: ${throwable.javaClass.simpleName} - ${throwable.message}",
                        extraInfo = extra,
                        throwable = throwable
                    )
                    Thread.sleep(1500)
                } catch (_: Throwable) {
                    // ignore
                }
                defaultHandler?.uncaughtException(thread, throwable)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activePlayerRef = WeakReference(this)

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
                when {
                    xrayController?.onBackPressed() == true -> return
                    isAnyCastActive() -> returnToCatalogWhileCasting()
                    isLiveTvMode && tryEnterLiveTvPictureInPicture() -> return
                    else -> finish()
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
                    val partFid = obj.optInt("fileId", 0)
                    val partSize = obj.getLong("size")
                    val partMsgId = obj.optLong("msgId", 0L)
                    require((partFid > 0 || partMsgId != 0L) && partSize > 0) { "Parte no válida" }
                    require(partSize <= Long.MAX_VALUE - totalPartsSize) { "Tamaño excesivo" }
                    totalPartsSize += partSize
                    parts.add(FilePart(partFid, partSize, partMsgId))
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
        val initialFileId = multipartParts?.firstOrNull()?.fileId ?: intent.getIntExtra(EXTRA_FILE_ID, -1)
        val initialFileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
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
        currentFileId = initialFileId
        forceCastStereoSession = false
        getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("force_software_audio", true)
            .apply()

        val attachRequested = intent.getBooleanExtra(EXTRA_ATTACH_ACTIVE_CAST, false)
        if (CastSessionCoordinator.isCastingActive &&
            (attachRequested || CastSessionCoordinator.isSameActiveMedia(initialFileId, multipartParts))
        ) {
            val activeServer = CastSessionCoordinator.activeStreamServer
            val activeMedia = CastSessionCoordinator.activeMedia
            if (activeServer != null && activeMedia != null && activeServer.listeningPort > 0) {
                attachToRunningCastSession(activeServer, activeMedia)
                return
            }
        }

        installGlobalCrashHandlerOnce(applicationContext)

        Log.i(TAG, "▶ onCreate: fileId=$initialFileId fileSize=$initialFileSize mimeType=$mimeType title=$title contentId=$contentId")
        val chatId = intent.getLongExtra(EXTRA_CHAT_ID, 0L)
        val msgId  = intent.getLongExtra(EXTRA_MSG_ID, 0L)
        val useNodeJsProxy = intent.getBooleanExtra("USE_NODEJS_PROXY", false)

        introSkipped = false
        nextEpisodeTriggered = false
        hasRenderedLiveVideoFrame = false
        mutedPendingInitialLiveSeek = false
        loadingSpinner.visibility = View.VISIBLE

        applySpecialPlaybackModesFromIntent(intent, phone, contentId, season, episode, title)
        setupUnifiedCastEngine()
        initExoPlayer()
        showTitle(title)
        scheduleHideControls()

        val initialPartsSnapshot = multipartParts
        streamStartupJob?.cancel()
        streamStartupJob = scope.launch {
            var resolvedParts = initialPartsSnapshot
            var resolvedFileId = initialFileId
            var resolvedFileSize = initialFileSize

            if (!resolvedParts.isNullOrEmpty()) {
                val validated = engine.ensureValidMultipartParts(resolvedParts, chatId)
                if (validated == null || validated.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        if (!isFinishing && !isDestroyed) {
                            Toast.makeText(this@PlayerActivity, "Error: no se pudieron resolver las partes del vídeo", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
                    return@launch
                }
                resolvedParts = validated
                resolvedFileId = validated[0].fileId
            } else {
                val verified = engine.ensureValidFileId(resolvedFileId, chatId, msgId, resolvedFileSize)
                if (verified != null && verified.first > 0) {
                    resolvedFileId = verified.first
                    if (resolvedFileSize <= 0L && verified.second > 0L) {
                        resolvedFileSize = verified.second
                    }
                }
                if (resolvedFileId > 0 && resolvedFileSize <= 0L) {
                    val tdSize = engine.resolveFileSizeForFileId(resolvedFileId)
                    if (tdSize > 0L) {
                        resolvedFileSize = tdSize
                        Log.i(TAG, "📏 Resolved exact TDLib file size for fileId=$resolvedFileId: $resolvedFileSize bytes")
                    }
                }
            }

            if (!isActive) return@launch
            if (resolvedFileId <= 0) {
                withContext(Dispatchers.Main) {
                    if (!isFinishing && !isDestroyed) {
                        Toast.makeText(this@PlayerActivity, "Error: fileId inválido ($resolvedFileId)", Toast.LENGTH_LONG).show()
                        finish()
                    }
                }
                return@launch
            }

            withContext(Dispatchers.Main) {
                if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext

                multipartParts = resolvedParts
                currentFileId = resolvedFileId
                val effectiveFileSize = if (resolvedFileSize > 0L) resolvedFileSize else 2_000_000_000L
                currentEffectiveFileSize = resolvedParts?.sumOf { it.size }?.takeIf { it > 0L } ?: effectiveFileSize

                val autoContinueCastTarget: CastSessionCoordinator.AutoContinueCastTarget? =
                    if (CastSessionCoordinator.isCastingActive &&
                        !CastSessionCoordinator.isSameActiveMedia(resolvedFileId, resolvedParts)
                    ) {
                        Log.i(TAG, "🔄 Switching active TV cast to newly selected catalog movie: title=$title fileId=$resolvedFileId")
                        CastSessionCoordinator.prepareForMovieReplacement(this@PlayerActivity, resolvedFileId, resolvedParts)
                    } else {
                        null
                    }

                val ramBudget = StorageAndRamHygiene.resolvePlayerRamBudget(this@PlayerActivity)
                val port: Int
                val localStreamUrl: String
                var inspectedDurMs = 0L
                if (useNodeJsProxy) {
                    port = 3000
                    localStreamUrl = "http://127.0.0.1:3000/stream"
                    Log.i(TAG, "- Using NodeJS StreamProxyServer on port 3000")
                } else {
                    val lss = LocalStreamServer(engine, localPrefetchBufferBytes = ramBudget.localServerPrefetchBytes)
                    val lssUrl = lss.start(
                        fileId = resolvedFileId,
                        totalSize = currentEffectiveFileSize,
                        mimeType = mimeType,
                        multipartParts = resolvedParts,
                        storedSevenZip = storedSevenZip,
                        archiveError = { message ->
                            runOnUiThread {
                                if (!isFinishing && !isDestroyed) {
                                    Toast.makeText(this@PlayerActivity, message, Toast.LENGTH_LONG).show()
                                    finish()
                                }
                            }
                        }
                    )
                    localStreamServer = lss
                    localStreamUrl = lssUrl
                    port = lss.listeningPort
                    Log.i(TAG, "✨ LocalStreamServer iniciado para reproducción: $localStreamUrl en puerto $port (localPrefetch=${ramBudget.localServerPrefetchBytes / 1024}KB)")
                    inspectedDurMs = withTimeoutOrNull(4_500L) {
                        withContext(Dispatchers.IO) { lss.inspectInitialDurationMs() }
                    } ?: 0L
                    if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext
                    if (inspectedDurMs > 0L) {
                        lastKnownLocalDurationMs = inspectedDurMs
                        CastSessionCoordinator.updateKnownDurationMs(inspectedDurMs)
                    }
                    val updatedSz = lss.getEffectiveSizeBytes()
                    if (updatedSz > currentEffectiveFileSize && resolvedParts.isNullOrEmpty()) {
                        currentEffectiveFileSize = updatedSz
                    }
                    prewarmMatroskaTrackCatalog(lss)
                }
                currentPlayUrl = localStreamUrl
                val wifiIp = LanNetworkUtils.getBestLanIpv4(this@PlayerActivity)
                castStreamUrl = if (wifiIp != null && port > 0) "http://$wifiIp:$port/stream/cast.mp4" else null

                val p = jsProgress?.toFloatOrNull()?.toInt() ?: 0
                if (autoContinueCastTarget != null) {
                    loadingSpinner.visibility = View.VISIBLE
                    startSeekBarUpdater()
                    if (p > 5) {
                        startNewMovieOnConnectedTv(autoContinueCastTarget, p * 1000L)
                    } else if (!isLiveTvMode && phone.isNotEmpty() && contentId.isNotEmpty()) {
                        scope.launch {
                            val savedProgress = try {
                                fetchSavedProgress(phone, contentId, season, episode)
                            } catch (_: Exception) {
                                0
                            }
                            withContext(Dispatchers.Main) {
                                if (!isFinishing && !isDestroyed && !isCleanedUp) {
                                    val resumeMs = if (savedProgress > 5) savedProgress * 1000L else 0L
                                    startNewMovieOnConnectedTv(autoContinueCastTarget, resumeMs)
                                }
                            }
                        }
                    } else {
                        startNewMovieOnConnectedTv(autoContinueCastTarget, 0L)
                    }
                } else if (p > 5) {
                    var resumeMs = p * 1000L
                    if (isLiveTvMode && inspectedDurMs >= 300_000L) {
                        val sqz = liveTvSqueezeController
                        val effEndMs = sqz?.resolveEffectiveBroadcastEndMs(inspectedDurMs) ?: inspectedDurMs
                        if (resumeMs >= effEndMs - 3_000L) {
                            val eofKey = "$liveTvChannelId:$resolvedFileId"
                            if (lastPastEofAdvanceSlotKey != eofKey) {
                                lastPastEofAdvanceSlotKey = eofKey
                                val realDurSec = (inspectedDurMs / 1000L).toInt()
                                Log.i(TAG, "⏭ Live TV offset ${resumeMs}ms >= effectiveEnd ${effEndMs}ms; reporting real duration (${realDurSec}s) & advancing slot")
                                com.cineflix.android.util.ErrorLogCollector.log("Player", "Live TV offset ${resumeMs}ms >= ${effEndMs}ms; reporting ${realDurSec}s and advancing")
                                withTimeoutOrNull(1_800L) {
                                    withContext(Dispatchers.IO) { sqz?.reportTimingBlockingIo(realDurSec) }
                                }
                                if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext
                                triggerLiveTvNextProgram()
                                return@withContext
                            } else {
                                resumeMs = (resumeMs % inspectedDurMs).coerceIn(0L, (effEndMs - 20_000L).coerceAtLeast(0L))
                            }
                        }
                    }
                    pendingResumePositionMs = resumeMs
                    playUrl(localStreamUrl, resumeMs)
                    if (!isLiveTvMode) {
                        Toast.makeText(this@PlayerActivity, "Reanudado en ${p / 60}m", Toast.LENGTH_SHORT).show()
                    }
                } else if (!isLiveTvMode && phone.isNotEmpty() && contentId.isNotEmpty()) {
                    scope.launch {
                        try {
                            val savedProgress = fetchSavedProgress(phone, contentId, season, episode)
                            withContext(Dispatchers.Main) {
                                if (!isFinishing && !isDestroyed && !isCleanedUp) {
                                    if (savedProgress > 5) {
                                        val resumeMs = savedProgress * 1000L
                                        pendingResumePositionMs = resumeMs
                                        playUrl(localStreamUrl, resumeMs)
                                        Toast.makeText(this@PlayerActivity, "Reanudado en ${savedProgress / 60}m", Toast.LENGTH_SHORT).show()
                                    } else {
                                        playUrl(localStreamUrl, 0L)
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            withContext(Dispatchers.Main) {
                                if (!isFinishing && !isDestroyed && !isCleanedUp) {
                                    playUrl(localStreamUrl, 0L)
                                }
                            }
                        }
                    }
                } else {
                    playUrl(localStreamUrl, 0L)
                }

                if (!isLiveTvMode) {
                    ensureLocalProgressTrackingStarted(phone, contentId, season, episode)
                }
            }
        }
    }

    private fun bindViews() {
        playerView = findViewById(R.id.video_surface)
        rootFrame = playerView.parent as FrameLayout
        tvVideoTitle = findViewById(R.id.tv_video_title)
        tvTimeCurrent = findViewById(R.id.tv_time_current)
        tvTimeDuration = findViewById(R.id.tv_time_duration)
        seekBar = findViewById(R.id.seek_bar)
        bottomBar = findViewById(R.id.bottom_bar)
        centerControls = findViewById(R.id.center_controls)
        bottomBar.elevation = dpToPx(16).toFloat()
        bottomBar.translationZ = dpToPx(16).toFloat()
        centerControls.elevation = dpToPx(16).toFloat()
        centerControls.translationZ = dpToPx(16).toFloat()
        btnPlayPause = findViewById(R.id.btn_play_pause)
        btnRewind = findViewById(R.id.btn_rewind)
        btnForward = findViewById(R.id.btn_forward)
        btnResize = findViewById(R.id.btn_resize)
        btnTracks = findViewById(R.id.btn_tracks)
        btnReportError = findViewById(R.id.btn_report_error)
        loadingSpinner = findViewById(R.id.loading_spinner)
        btnXrayToggle = findViewById(R.id.btn_xray_toggle)
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

        applyTvIconFocusHighlight(
            findViewById(R.id.btn_prev),
            btnRewind,
            btnPlayPause,
            btnForward,
            findViewById(R.id.btn_next),
            btnCastBottom,
            btnTracks,
            btnResize,
            btnReportError
        )
        btnXrayToggle.setOnFocusChangeListener { v, hasFocus ->
            v.scaleX = if (hasFocus) 1.07f else 1.0f
            v.scaleY = if (hasFocus) 1.07f else 1.0f
            scheduleHideControls()
        }
    }

    private fun applyTvIconFocusHighlight(vararg views: View?) {
        for (view in views) {
            val v = view ?: continue
            val origBg = v.background
            val focusRing = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(Color.parseColor("#597C3AED"))
                setStroke(dpToPx(2), Color.WHITE)
            }
            v.setOnFocusChangeListener { target, hasFocus ->
                target.background = if (hasFocus) focusRing else origBg
                target.scaleX = if (hasFocus) 1.14f else 1.0f
                target.scaleY = if (hasFocus) 1.14f else 1.0f
                scheduleHideControls()
            }
        }
    }

    private fun setupListeners() {
        btnPlayPause.setOnClickListener { togglePlayPause() }
        btnRewind.setOnClickListener { seekRelative(-10000); showControls() }
        btnForward.setOnClickListener { seekRelative(10000); showControls() }
        btnResize.setOnClickListener { toggleResizeMode() }
        btnTracks.setOnClickListener { showTrackSelectorDialog() }
        btnXrayToggle.setOnClickListener {
            if (isLiveTvMode || isPremiereSyncLocked || isAnyCastActive()) return@setOnClickListener
            val p = player
            if (p != null && (p.isPlaying || p.playWhenReady)) {
                p.pause()
                btnPlayPause.setImageResource(android.R.drawable.ic_media_play)
            }
            showControls()
            xrayController?.onUserXrayButtonClicked()
        }
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
        setupFocusAnimation(btnXrayToggle)
        setupFocusAnimation(btnCastBottom)
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
                if (isLiveSeekLocked()) {
                    notifyLiveSeekLockedToast()
                    updateSeekBar()
                    return
                }
                tvTimeCurrent.text = formatTime(progress.toLong())
                if (!isSeeking) {
                    // Triggered via D-Pad / keyboard navigation while SeekBar has focus
                    executeOrDebounceSeek(progress.toLong(), debounceMs = 400L)
                }
            }
            override fun onStartTrackingTouch(bar: SeekBar) {
                if (isLiveSeekLocked()) {
                    notifyLiveSeekLockedToast()
                    return
                }
                isSeeking = true
                seekDebounceHandler.removeCallbacks(seekDebounceRunnable)
                pendingSeekTargetMs = null
                notifyXrayPlaybackState()
                controlsHandler.removeCallbacksAndMessages(null)
            }
            override fun onStopTrackingTouch(bar: SeekBar) {
                if (isLiveSeekLocked()) {
                    isSeeking = false
                    notifyLiveSeekLockedToast()
                    updateSeekBar()
                    return
                }
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
            if (isLiveSeekLocked()) return@setOnClickListener
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

    private fun releaseLocalExoPlayerAndTrimAllocator() {
        isReleasingOrRecoveringPlayer = true
        try {
            val p = player
            activePlayerListener?.let { listener ->
                runCatching { p?.removeListener(listener) }
            }
            activePlayerListener = null
            mutedPendingInitialLiveSeek = false
            playerView.player = null
            p?.pause()
            p?.stop()
            p?.clearMediaItems()
            p?.release()
        } catch (e: Exception) {
            Log.w(TAG, "Exception releasing ExoPlayer: ${e.message}")
        } finally {
            player = null
            isReleasingOrRecoveringPlayer = false
        }
        try {
            playerAllocator?.trim()
        } catch (_: Exception) {}
        playerAllocator = null
    }

    private fun initExoPlayer() {
        if (player != null || playerAllocator != null) {
            releaseLocalExoPlayerAndTrimAllocator()
        }
        val renderersFactory = CineflixRenderersFactory(this) {
            getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE).getBoolean("force_software_audio", true)
        }
            .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
            .setEnableDecoderFallback(true)
            .setMediaCodecSelector(androidx.media3.exoplayer.mediacodec.MediaCodecSelector.DEFAULT)

        val ramBudget = StorageAndRamHygiene.resolvePlayerRamBudget(this)
        val allocator = DefaultAllocator(/* trimOnReset = */ true, C.DEFAULT_BUFFER_SEGMENT_SIZE)
        playerAllocator = allocator

        val loadControl = androidx.media3.exoplayer.DefaultLoadControl.Builder()
            .setAllocator(allocator)
            .setBufferDurationsMs(
                ramBudget.minBufferMs,
                ramBudget.maxBufferMs,
                ramBudget.bufferForPlaybackMs,
                ramBudget.bufferForPlaybackAfterRebufferMs
            )
            .setTargetBufferBytes(ramBudget.exoTargetBufferBytes)
            .setPrioritizeTimeOverSizeThresholds(ramBudget.prioritizeTimeOverSizeThresholds)
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

        val listener = object : Player.Listener {
            override fun onRenderedFirstFrame() {
                hasRenderedLiveVideoFrame = true
                if (mutedPendingInitialLiveSeek && pendingResumePositionMs == null) {
                    mutedPendingInitialLiveSeek = false
                    player?.volume = 1f
                }
            }

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
                    if (!isInPipModeCompat()) {
                        loadingSpinner.visibility = View.VISIBLE
                    }
                    notifyXrayPlaybackState()
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
                        if (isLivePauseLocked() && !isActivityPausedForLifecycle && !isAnyCastActive() &&
                            player?.playWhenReady == false && !isFinishing && !isDestroyed
                        ) {
                            player?.play()
                        }
                        xrayController?.prefetchQuietly()
                        notifyXrayPlaybackState()
                    }

                    if (playbackState == Player.STATE_ENDED) {
                        xrayController?.hideAllImmediate()
                        val dur = player?.duration ?: 0L
                        val pos = player?.currentPosition ?: 0L
                        val reachedNaturalEnd = pos >= 20_000L &&
                            (dur <= 0L || dur == C.TIME_UNSET || pos >= dur - 90_000L)
                        // Only auto-trigger next episode/program if playback actually reached near the end of the video
                        if (!isLiveTvMode && reachedNaturalEnd && !nextEpisodeTriggered) {
                            nextEpisodeTriggered = true
                            com.cineflix.android.util.ErrorLogCollector.log("Player", "Auto next episode triggered at pos=$pos/$dur")
                            triggerNextEpisode()
                        } else if (isLiveTvMode && reachedNaturalEnd && !nextEpisodeTriggered) {
                            nextEpisodeTriggered = true
                            com.cineflix.android.util.ErrorLogCollector.log("Player", "Live TV slot ended at pos=$pos/$dur; chaining next slot")
                            triggerLiveTvNextProgram()
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
                notifyXrayPlaybackState()
            }

            override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                if (isAnyCastActive() || isReleasingOrRecoveringPlayer) return
                if (!playWhenReady &&
                    isLivePauseLocked() &&
                    !isActivityPausedForLifecycle &&
                    !liveTvAutoAdvancePending &&
                    !liveTvZapPending &&
                    (player?.mediaItemCount ?: 0) > 0 &&
                    reason != Player.PLAY_WHEN_READY_CHANGE_REASON_END_OF_MEDIA_ITEM &&
                    !isFinishing &&
                    !isDestroyed
                ) {
                    // Recover silently from transient audio-focus or system MediaSession pauses without emitting
                    // false-positive "no se puede pausar" toasts (explicit user pauses already toast in togglePlayPause / keydown)
                    val delayMs = if (reason == Player.PLAY_WHEN_READY_CHANGE_REASON_AUDIO_FOCUS_LOSS) 220L else 0L
                    if (delayMs > 0L) {
                        Handler(Looper.getMainLooper()).postDelayed({
                            if (!isFinishing && !isDestroyed && !isAnyCastActive() && !isReleasingOrRecoveringPlayer &&
                                isLivePauseLocked() && !isActivityPausedForLifecycle &&
                                !liveTvAutoAdvancePending && !liveTvZapPending &&
                                (player?.mediaItemCount ?: 0) > 0 &&
                                player?.playWhenReady == false
                            ) {
                                player?.play()
                            }
                        }, delayMs)
                    } else {
                        player?.play()
                    }
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
                    val currentPos = (player?.currentPosition ?: lastKnownLocalPositionMs).coerceAtLeast(0L)
                    Log.w(TAG, "IO error detected ($ioErrorRetryCount/3). Attempting auto-recovery at position ${currentPos}ms...")
                    Toast.makeText(this@PlayerActivity, "Reconectando con el servidor ($ioErrorRetryCount/3)...", Toast.LENGTH_SHORT).show()
                    loadingSpinner.visibility = View.VISIBLE

                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!isFinishing && !isDestroyed && !isAnyCastActive()) {
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

                // Auto-recovery for audio/video decoder, parser, or mid-stream seek errors
                if (!isIoError && decoderErrorRetryCount < 2) {
                    decoderErrorRetryCount++
                    val currentPos = (pendingResumePositionMs ?: player?.currentPosition ?: lastKnownLocalPositionMs).coerceAtLeast(0L)
                    val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                    val nextSwPref = if (decoderErrorRetryCount == 1) {
                        !prefs.getBoolean("force_software_audio", true)
                    } else {
                        true
                    }
                    Log.w(TAG, "Decoder/parser error (${error.errorCodeName}, retry $decoderErrorRetryCount/2, swAudio=$nextSwPref). Recovering at ${currentPos}ms...")
                    prefs.edit().putBoolean("force_software_audio", nextSwPref).apply()
                    loadingSpinner.visibility = View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed({
                        if (!isFinishing && !isDestroyed && !isAnyCastActive()) {
                            try {
                                releaseLocalExoPlayerAndTrimAllocator()
                                initExoPlayer()
                                playerView.player = player
                                val port = localStreamServer?.listeningPort ?: proxyServer?.listeningPort ?: 8080
                                val url = currentPlayUrl ?: "http://127.0.0.1:$port/stream"
                                pendingResumePositionMs = currentPos
                                // On retry 2, prepare from byte 0 so codecs initialize on keyframe 0 before seeking
                                val prepStartMs = if (decoderErrorRetryCount >= 2) 0L else currentPos
                                if (prepStartMs == 0L && currentPos > 0L) {
                                    mutedPendingInitialLiveSeek = true
                                    player?.volume = 0f
                                }
                                playUrl(url, prepStartMs)
                            } catch (re: Exception) {
                                Log.e(TAG, "Decoder recovery failed: ${re.message}", re)
                            }
                        }
                    }, 350L)
                    return
                }

                // Error definitivo o reintentos agotados: Generar y enviar reporte al bot + servidor HTTPS
                val currentPos = player?.currentPosition ?: 0L
                val duration = (player?.duration?.takeIf { it > 0 && it != C.TIME_UNSET } ?: lastKnownLocalDurationMs).coerceAtLeast(0L)
                val posStr = "${currentPos / 1000 / 60}:${String.format("%02d", (currentPos / 1000) % 60)}"
                val durStr = "${duration / 1000 / 60}:${String.format("%02d", (duration / 1000) % 60)}"

                val extra = mapOf(
                    "title" to currentTitle,
                    "liveTv" to "$isLiveTvMode (ch=$liveTvChannelId)",
                    "fileId" to currentFileId,
                    "fileSize" to currentEffectiveFileSize,
                    "position" to "$posStr / $durStr (${currentPos}ms, pendingResume=${pendingResumePositionMs ?: 0L}ms)",
                    "error" to "${error.errorCodeName}: ${error.message} (cause=${error.cause?.javaClass?.simpleName}: ${error.cause?.message})",
                    "retryCount" to "io=$ioErrorRetryCount, dec=$decoderErrorRetryCount",
                    "url" to (currentPlayUrl ?: "N/A")
                )

                Toast.makeText(this@PlayerActivity, "Error de reproducción (${error.errorCodeName}). Enviando log...", Toast.LENGTH_LONG).show()
                com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
                    context = applicationContext,
                    reason = "ExoPlayer Error: ${error.errorCodeName} - ${error.message}",
                    extraInfo = extra,
                    throwable = error
                ) { success, _ ->
                    Handler(Looper.getMainLooper()).post {
                        val msg = if (success) {
                            "✅ Log de diagnóstico enviado a @videoclubpacobot"
                        } else {
                            "📡 Diagnóstico guardado en el servidor de Cineflix"
                        }
                        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
                    }
                }
                finish()
            }
        }
        activePlayerListener = listener
        p.addListener(listener)
    }
    private fun tryApplyPendingResumeSeek() {
        val resumePos = pendingResumePositionMs ?: return
        val p = player ?: return
        if (p.playbackState != Player.STATE_READY && p.playbackState != Player.STATE_BUFFERING) return

        val knownDur = when {
            p.duration > 60_000L && p.duration != C.TIME_UNSET -> p.duration
            lastKnownLocalDurationMs > 60_000L -> lastKnownLocalDurationMs
            else -> 0L
        }
        if (isLiveTvMode && knownDur >= 300_000L) {
            val sqz = liveTvSqueezeController
            val effEndMs = sqz?.resolveEffectiveBroadcastEndMs(knownDur) ?: knownDur
            if (resumePos >= effEndMs - 3_000L) {
                pendingResumePositionMs = null
                if (mutedPendingInitialLiveSeek) {
                    mutedPendingInitialLiveSeek = false
                    p.volume = 1f
                }
                val eofKey = "$liveTvChannelId:$currentFileId"
                if (lastPastEofAdvanceSlotKey != eofKey) {
                    lastPastEofAdvanceSlotKey = eofKey
                    val durSec = (knownDur / 1000L).toInt()
                    Log.i(TAG, "⏭ tryApplyPendingResumeSeek: Live TV resumePos=${resumePos}ms >= effEnd=${effEndMs}ms; reporting & advancing")
                    scope.launch {
                        withTimeoutOrNull(1_800L) {
                            withContext(Dispatchers.IO) { sqz?.reportTimingBlockingIo(durSec) }
                        }
                        withContext(Dispatchers.Main) {
                            if (!isFinishing && !isDestroyed && isLiveTvMode) {
                                triggerLiveTvNextProgram()
                            }
                        }
                    }
                    return
                }
            }
        }

        val clampedResumePos = if (knownDur > 10_000L && resumePos >= knownDur - 3_000L) {
            (knownDur - 5_000L).coerceAtLeast(0L)
        } else {
            resumePos
        }

        val current = p.currentPosition.coerceAtLeast(0L)
        if (kotlin.math.abs(current - clampedResumePos) <= 4000L) {
            pendingResumePositionMs = null
            if (mutedPendingInitialLiveSeek) {
                mutedPendingInitialLiveSeek = false
                p.volume = 1f
            }
            Log.i(TAG, "▶ Local player already at resume position ${current}ms (target=${clampedResumePos}ms)")
            return
        }
        if (p.isCurrentMediaItemSeekable) {
            pendingResumePositionMs = null
            Log.i(TAG, "▶ Seeking local player to resume position ${clampedResumePos}ms (current=${current}ms)")
            com.cineflix.android.util.ErrorLogCollector.log("Player", "Resume seek to ${clampedResumePos}ms (current=${current}ms)")
            p.seekTo(clampedResumePos)
            if (mutedPendingInitialLiveSeek) {
                mutedPendingInitialLiveSeek = false
                p.volume = 1f
            }
        } else if (p.playbackState == Player.STATE_READY) {
            Log.w(TAG, "▶ STATE_READY awaiting seek index for pendingResumePositionMs=${clampedResumePos}ms")
        }
    }

    private fun playUrl(url: String, startPositionMs: Long = pendingResumePositionMs ?: 0L) {
        currentPlayUrl = url
        loadingSpinner.visibility = View.VISIBLE
        var safeStartMs = startPositionMs.coerceAtLeast(0L)
        val knownDur = lastKnownLocalDurationMs
        if (knownDur > 10_000L && safeStartMs >= knownDur - 3_000L) {
            safeStartMs = (knownDur - 5_000L).coerceAtLeast(0L)
        }

        val deferSeekUntilDurationKnown = isLiveTvMode && safeStartMs > 0L && knownDur <= 0L
        if (deferSeekUntilDurationKnown) {
            pendingResumePositionMs = safeStartMs
            mutedPendingInitialLiveSeek = true
            player?.volume = 0f
        } else if (safeStartMs > 0L) {
            pendingResumePositionMs = safeStartMs
        } else if (!mutedPendingInitialLiveSeek) {
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

        if (safeStartMs > 0L && !deferSeekUntilDurationKnown) {
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
        val (effSubMode, effSubTrackNum, effSubOrdinal) = resolveEffectiveSubtitleSelection()
        val effectiveAudioTrackNum = userSelectedAudioTrackNum
            ?: userSelectedAudioOrdinal?.let { cachedAudioOptions.getOrNull(it)?.matroskaTrackNumber }
        localStreamServer?.updateCastTrackSelection(
            audioTrackNumber = effectiveAudioTrackNum,
            audioOrdinal = userSelectedAudioOrdinal,
            subtitleMode = effSubMode,
            subtitleTrackNumber = effSubTrackNum,
            subtitleOrdinal = effSubOrdinal,
            forceStereo = forceCastStereoSession
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
            prefs.getBoolean("force_software_audio", true)
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

                // Desvincular vista del player anterior y recortar su DefaultAllocator antes de recrear
                releaseLocalExoPlayerAndTrimAllocator()

                initExoPlayer()
                playerView.player = player

                val port = localStreamServer?.listeningPort ?: proxyServer?.listeningPort ?: 8080
                val url = currentPlayUrl ?: "http://127.0.0.1:$port/stream"
                pendingResumePositionMs = currentPos
                playUrl(url, currentPos)

                if (!wasPlayingLocal && !isLivePauseLocked()) {
                    player?.pause()
                }
                dialog.dismiss()
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

                if (!isAnyCastActive() && p != null) {
                    syncTrackSelectionToStreamServer()
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

            if (!isAnyCastActive() && p != null) {
                syncTrackSelectionToStreamServer()
                p.trackSelectionParameters = p.trackSelectionParameters.buildUpon()
                    .clearOverridesOfType(C.TRACK_TYPE_TEXT)
                    .setTrackTypeDisabled(C.TRACK_TYPE_TEXT, true)
                    .build()
            }

            when {
                isGoogleCasting -> applyGoogleCastSubtitleChangeInPlace("💬 Subtítulos desactivados")
                isAnyCastActive() -> reloadActiveCastForTrackChange("💬 Subtítulos desactivados")
                else -> Toast.makeText(this@PlayerActivity, "💬 Subtítulos desactivados", Toast.LENGTH_SHORT).show()
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

                if (!isAnyCastActive() && p != null) {
                    syncTrackSelectionToStreamServer()
                    applyStoredTrackOverridesToExoPlayerIfNeeded(p.currentTracks)
                }

                when {
                    isGoogleCasting -> applyGoogleCastSubtitleChangeInPlace("💬 Subtítulos: ${opt.name}")
                    isAnyCastActive() -> reloadActiveCastForTrackChange("💬 Subtítulos: ${opt.name}")
                    else -> Toast.makeText(this@PlayerActivity, "💬 Subtítulos: ${opt.name}", Toast.LENGTH_SHORT).show()
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
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return lastKnownLocalPositionMs.coerceAtLeast(0L)
        }
        val pos = player?.currentPosition?.coerceAtLeast(0L) ?: lastKnownLocalPositionMs.coerceAtLeast(0L)
        lastKnownLocalPositionMs = pos
        return pos
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
        if (Looper.myLooper() != Looper.getMainLooper()) {
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
                localStreamServer?.notifyGoogleCastSeekForSubtitles(safeTarget) { nextSlot ->
                    runOnUiThread {
                        if (!isFinishing && !isDestroyed && isGoogleCasting) {
                            sessionManager?.currentCastSession?.remoteMediaClient?.setActiveMediaTracks(longArrayOf(nextSlot))
                        }
                    }
                }
            }
            else -> player?.seekTo(safeTarget)
        }
    }

    private fun togglePlayPause() {
        when {
            isLivePauseLocked() -> {
                notifyLivePauseLockedToast()
                if (!isAnyCastActive() && player?.isPlaying == false && player?.playbackState == Player.STATE_READY) {
                    player?.play()
                }
            }
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
        if (isInPipModeCompat()) return
        if (controlsVisible) hideControls() else showControls()
    }

    private fun showControls() {
        if (isInPipModeCompat()) return
        val wasHidden = !controlsVisible
        bottomBar.visibility = View.VISIBLE
        bottomBar.animate().alpha(1f).setDuration(200).start()
        if (isLivePauseLocked()) {
            centerControls.animate().cancel()
            centerControls.visibility = View.GONE
        } else {
            centerControls.visibility = View.VISIBLE
            centerControls.animate().alpha(1f).setDuration(200).start()
        }
        if (isLiveTvMode) {
            liveTvTopBar?.let { bar ->
                bar.visibility = View.VISIBLE
                bar.animate().alpha(1f).setDuration(200).start()
            }
        }
        controlsVisible = true
        xrayController?.onControlsVisibilityChanged(true)

        if (wasHidden) {
            val targetFocus: View = if (isLivePauseLocked()) {
                btnLiveFicha?.takeIf { it.visibility == View.VISIBLE }
                    ?: btnLiveChNext
                    ?: btnTracks
            } else {
                btnPlayPause
            }
            targetFocus.post { targetFocus.requestFocus() }
        }

        scheduleHideControls()
    }

    private fun hideControls() {
        if (isAnyCastActive()) {
            // Keep remote controls handy when phone is acting as TV remote, unless user explicitly taps
        }
        bottomBar.animate().alpha(0f).setDuration(300).withEndAction { bottomBar.visibility = View.GONE }.start()
        centerControls.animate().alpha(0f).setDuration(300).withEndAction { centerControls.visibility = View.GONE }.start()
        liveTvTopBar?.animate()?.alpha(0f)?.setDuration(300)?.withEndAction {
            liveTvTopBar?.visibility = View.GONE
        }?.start()
        controlsVisible = false
        xrayController?.onControlsVisibilityChanged(false)
        if (isLiveTvMode && isTvOrDpadActive() && liveTvSqueezeController?.isSqueezeVisible() == true) {
            rootFrame.post {
                if (!controlsVisible) {
                    liveTvSqueezeController?.focusFirstChannelCardIfAvailable()
                }
            }
        }
    }

    private fun hideControlsImmediateForPip() {
        controlsHandler.removeCallbacksAndMessages(null)
        titleHandler.removeCallbacksAndMessages(null)
        bottomBar.animate().cancel()
        centerControls.animate().cancel()
        tvVideoTitle.animate().cancel()
        liveTvTopBar?.animate()?.cancel()
        bottomBar.visibility = View.GONE
        centerControls.visibility = View.GONE
        tvVideoTitle.visibility = View.GONE
        liveTvTopBar?.visibility = View.GONE
        layoutSkipIntro.visibility = View.GONE
        layoutNextEpisode.visibility = View.GONE
        controlsVisible = false
        xrayController?.onControlsVisibilityChanged(false)
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

        // Strict live sync enforcement for Saturday 22:00h "El Peliculón"
        if (isPremiereSyncLocked && liveTvTunedAtEpochMs > 0L && !isAnyCastActive() &&
            player?.playbackState == Player.STATE_READY
        ) {
            val elapsedSec = ((System.currentTimeMillis() - liveTvTunedAtEpochMs).coerceAtLeast(0L)) / 1000L
            val expectedMs = (liveTvBaseOffsetSec + elapsedSec) * 1000L
            val withinBounds = duration <= 0L || duration == C.TIME_UNSET || expectedMs < (duration - 5_000L)
            if (withinBounds && (player?.isCurrentMediaItemSeekable == true)) {
                val driftMs = kotlin.math.abs(time - expectedMs)
                val now = System.currentTimeMillis()
                if (driftMs > 9_500L && now - lastPremiereAutoResyncAtMs > 12_000L) {
                    lastPremiereAutoResyncAtMs = now
                    Log.i(TAG, "🔒 El Peliculón auto-resync: pos=${time}ms expected=${expectedMs}ms drift=${driftMs}ms")
                    player?.seekTo(expectedMs)
                    if (player?.isPlaying == false) player?.play()
                }
            }
        }

        if (isLiveTvMode && !liveTvAutoAdvancePending && !liveTvZapPending &&
            pendingResumePositionMs == null && (isAnyCastActive() || player?.playbackState == Player.STATE_READY)
        ) {
            val cleanDurMs = if (duration > 0L && duration != C.TIME_UNSET) duration else 0L
            val shouldCutSynchronized = liveTvSqueezeController?.onPlaybackTick(
                positionMs = time,
                durationMs = cleanDurMs,
                isInPipMode = isInPipModeCompat() || isAnyCastActive()
            ) == true
            if (shouldCutSynchronized && !nextEpisodeTriggered) {
                nextEpisodeTriggered = true
                Log.i(TAG, "✂️ Synchronized 3-lock Live TV credits cut reached at pos=${time}ms/${cleanDurMs}ms; advancing slot")
                com.cineflix.android.util.ErrorLogCollector.log("Player", "Live TV 3-lock credits cut at pos=$time/$cleanDurMs")
                triggerLiveTvNextProgram()
                return
            }
        }

        if (duration > 0 && duration != C.TIME_UNSET) {
            seekBar.max = duration.toInt()
            seekBar.progress = time.toInt()
            tvTimeCurrent.text = formatTime(time)
            tvTimeDuration.text = formatTime(duration)

            if (!isLiveTvMode && !isPremiereSyncLocked && !isInPipModeCompat()) {
                // Intro check
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

                // Next Episode check
                val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
                if (contentId.startsWith("tv_")) {
                    val creditsStartStr = intent.getStringExtra(EXTRA_CREDITS_START) ?: ""
                    val creditsStartSeconds = creditsStartStr.toIntOrNull()
                    val introDbCreditsMs = (intent.getStringExtra(EXTRA_INTRODB_CREDITS_MS) ?: "").toLongOrNull()

                    val shouldShow: Boolean
                    val secondsLeft: Int

                    if (creditsStartSeconds != null && creditsStartSeconds > 0) {
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
                            Log.i(TAG, "▶️ SHOWING Next Episode overlay (time=$time, secondsLeft=$secondsLeft)")
                            if (layoutSkipIntro.visibility == View.VISIBLE) {
                                layoutSkipIntro.visibility = View.GONE
                            }
                        }
                        tvNextEpisodeCountdown.text = "Siguiente en ${secondsLeft}s"

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
        if (player?.isPlaying == false || player?.playWhenReady == false) {
            notifyXrayPlaybackState()
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
        if (isInPipModeCompat()) return
        val suppressDuplicateRawTitle = isLiveTvMode && title == currentTitle && liveTvProgramDisplayTitle.isNotBlank()
        if (title.isNotEmpty() || isLiveTvMode) {
            if (suppressDuplicateRawTitle || title.isEmpty()) {
                tvVideoTitle.animate().cancel()
                tvVideoTitle.visibility = View.GONE
            } else {
                tvVideoTitle.text = title
                tvVideoTitle.alpha = 0f
                tvVideoTitle.visibility = View.VISIBLE
                tvVideoTitle.animate().alpha(1f).setDuration(400).start()
            }
            if (isLiveTvMode) {
                liveTvTopBar?.let { bar ->
                    bar.visibility = View.VISIBLE
                    bar.alpha = 0f
                    bar.animate().alpha(1f).setDuration(350).start()
                }
            }

            titleHandler.removeCallbacksAndMessages(null)
            titleHandler.postDelayed({
                if (tvVideoTitle.visibility == View.VISIBLE) {
                    tvVideoTitle.animate().alpha(0f).setDuration(500).withEndAction {
                        tvVideoTitle.visibility = View.GONE
                    }.start()
                }
                if (!controlsVisible) {
                    liveTvTopBar?.animate()?.alpha(0f)?.setDuration(400)?.withEndAction {
                        liveTvTopBar?.visibility = View.GONE
                    }?.start()
                }
            }, 3000)
        }
    }

    private fun triggerNextEpisode() {
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""

        if (contentId.startsWith("tv_")) {
            val sNum = season.toIntOrNull() ?: 1
            val eNum = episode.toIntOrNull() ?: 1
            MainActivity.deliverNextEpisodeFromPlayer(contentId, sNum, eNum)
            val resultIntent = Intent().apply {
                putExtra("next_episode", true)
                putExtra("content_id", contentId)
                putExtra("season", sNum)
                putExtra("episode", eNum)
            }
            setResult(RESULT_OK, resultIntent)
        }
        finish()
    }

    private fun triggerLiveTvNextProgram() {
        if (liveTvAutoAdvancePending) return
        liveTvSqueezeController?.destroy()
        liveTvSqueezeController = null

        if (isPremiereSyncLocked || liveTvChannelId.equals("ch_premiere_sabado", ignoreCase = true)) {
            Log.i(TAG, "🎬 Saturday Premiere finished naturally; stopping Live TV mode and closing player")
            MainActivity.stopLiveTvFromPlayer(reopenGrid = true)
            hadLiveTvSession = false
            isLiveTvMode = false
            finish()
            return
        }

        val dispatched = MainActivity.advanceLiveTvProgramFromPlayer(liveTvChannelId)
        if (!dispatched) {
            Log.w(TAG, "Live TV 24/7 auto-advance could not reach WebView; finishing player cleanly")
            isLiveTvMode = false
            finish()
            return
        }

        liveTvAutoAdvancePending = true
        Log.i(TAG, "📺 Live TV 24/7 slot ended; advancing seamlessly to next program on channel=$liveTvChannelId (pip=${isInPipModeCompat()})")

        // Immediately reclaim buffers & TDLib disk chunks of the finished episode/movie
        streamStartupJob?.cancel()
        streamStartupJob = null
        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null
        xrayController?.hideAllImmediate()

        if (!isAnyCastActive()) {
            val finishedFileId = currentFileId
            val finishedParts = multipartParts
            val finishedServer = localStreamServer
            localStreamServer = null
            currentFileId = -1
            multipartParts = null

            try {
                player?.stop()
                player?.clearMediaItems()
                playerAllocator?.trim()
            } catch (_: Exception) {}
            try {
                finishedServer?.stop()
            } catch (_: Exception) {}

            val idsToRelease = buildSet {
                if (finishedFileId > 0) add(finishedFileId)
                finishedParts?.forEach { if (it.fileId > 0) add(it.fileId) }
            }
            val engine = TelegramEngine.getInstance(this)
            engine.purgeAllStreamingCaches(idsToRelease)
        }

        if (!isInPipModeCompat()) {
            loadingSpinner.visibility = View.VISIBLE
            showTitle("📺 Continuando emisión en directo...")
        } else {
            loadingSpinner.visibility = View.GONE
            hideControlsImmediateForPip()
        }

        backgroundReleaseHandler.removeCallbacks(liveTvAutoAdvanceTimeoutRunnable)
        backgroundReleaseHandler.postDelayed(liveTvAutoAdvanceTimeoutRunnable, LIVE_TV_AUTO_ADVANCE_TIMEOUT_MS)
    }

    private fun isLiveSeekLocked(): Boolean = shouldLockSeekForPlayback(isLiveTvMode, isPremiereSyncLocked)
    private fun isLivePauseLocked(): Boolean = shouldLockPauseForPlayback(isLiveTvMode, isPremiereSyncLocked)

    private fun executeOrDebounceSeek(targetMs: Long, debounceMs: Long = 400L) {
        if (!isAnyCastActive() && player == null) return
        if (isLiveSeekLocked()) {
            notifyLiveSeekLockedToast()
            return
        }
        val duration = getCurrentEffectiveDurationMs()
        val safeTarget = if (duration > 0 && duration != C.TIME_UNSET) {
            Math.max(0L, Math.min(targetMs, duration))
        } else {
            Math.max(0L, targetMs)
        }

        pendingSeekTargetMs = safeTarget
        notifyXrayPlaybackState()
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
        if (isLiveSeekLocked()) {
            notifyLiveSeekLockedToast()
            return
        }
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

    private fun applySpecialPlaybackModesFromIntent(
        srcIntent: Intent,
        phone: String,
        contentId: String,
        season: String,
        episode: String,
        title: String
    ) {
        isLiveTvMode = srcIntent.getBooleanExtra(EXTRA_IS_LIVE_TV, false)
        liveTvChannelId = srcIntent.getStringExtra(EXTRA_LIVE_TV_CHANNEL_ID).orEmpty().trim()
        liveTvChannelLabel = srcIntent.getStringExtra(EXTRA_LIVE_TV_CHANNEL_LABEL).orEmpty().trim()
        liveTvTunedAtEpochMs = srcIntent.getLongExtra(EXTRA_LIVE_TV_TUNED_AT_MS, 0L)
        liveTvBaseOffsetSec = srcIntent.getLongExtra(EXTRA_LIVE_TV_BASE_OFFSET_SEC, 0L)
        isPremiereSyncLocked = srcIntent.getBooleanExtra(EXTRA_IS_PREMIERE_LOCKED, false) ||
            liveTvChannelId.equals("ch_premiere_sabado", ignoreCase = true)

        if (isPremiereSyncLocked) {
            isLiveTvMode = true
            if (liveTvTunedAtEpochMs <= 0L) {
                liveTvTunedAtEpochMs = System.currentTimeMillis()
            }
            if (liveTvBaseOffsetSec <= 0L) {
                liveTvBaseOffsetSec = (srcIntent.getStringExtra(EXTRA_PROGRESS)?.toFloatOrNull()?.toLong() ?: 0L)
                    .coerceAtLeast(0L)
            }
        }
        hadLiveTvSession = isLiveTvMode

        val explicitType = srcIntent.getStringExtra(EXTRA_XRAY_MEDIA_TYPE).orEmpty().lowercase()
        val resolvedMediaType = when {
            explicitType == "tv" || explicitType == "movie" -> explicitType
            contentId.startsWith("tv_") || season.isNotBlank() -> "tv"
            else -> "movie"
        }
        val cleanLookupId = contentId.removePrefix("tv_").removePrefix("mv_").removePrefix("movie_").trim()
        val resolvedItemId = srcIntent.getStringExtra(EXTRA_LIVE_TV_ITEM_ID).orEmpty().trim().ifBlank { cleanLookupId }
        val resolvedTmdbId = srcIntent.getIntExtra(EXTRA_XRAY_TMDB_ID, 0)
        val explicitCleanTitle = srcIntent.getStringExtra(EXTRA_XRAY_CLEAN_TITLE)?.takeIf { it.isNotBlank() && it != "null" }
        val resolvedCleanTitle = explicitCleanTitle ?: XrayOverlayController.sanitizeLookupTitle(title)
        val resolvedYear = srcIntent.getStringExtra(EXTRA_XRAY_YEAR)?.takeIf { it.isNotBlank() && it != "null" }
            ?: XrayOverlayController.extractYearFromTitle(title)
        val explicitProgramTitle = srcIntent.getStringExtra(EXTRA_LIVE_TV_PROGRAM_TITLE)?.takeIf { it.isNotBlank() && it != "null" }

        liveTvFichaMediaType = resolvedMediaType
        liveTvFichaItemId = resolvedItemId
        liveTvFichaTmdbId = resolvedTmdbId
        liveTvFichaCleanTitle = resolvedCleanTitle
        liveTvFichaYear = resolvedYear
        liveTvFichaPosterPath = srcIntent.getStringExtra(EXTRA_LIVE_TV_POSTER_PATH).orEmpty().trim()
        liveTvFichaPayload = srcIntent.getStringExtra(EXTRA_LIVE_TV_PAYLOAD).orEmpty().trim()
        liveTvFichaRawJson = srcIntent.getStringExtra(EXTRA_LIVE_TV_RAW_ITEM_JSON).orEmpty().trim()
        liveTvProgramDisplayTitle = formatLiveTvProgramDisplayTitle(
            explicitProgramTitle = explicitProgramTitle,
            cleanTitle = resolvedCleanTitle,
            rawTitle = title,
            year = resolvedYear,
            mediaType = resolvedMediaType,
            season = season,
            episode = episode
        )

        // Configure Live TV top bar (🔴 EN DIRECTO + channel + content title e.g. Epic Movie (2007) + ℹ Ficha + Ch-/Ch+ + 📋 Guía)
        val titleLp = tvVideoTitle.layoutParams as? FrameLayout.LayoutParams
        if (isLiveTvMode) {
            val bar = ensureLiveTvTopBar()
            updateLiveTvTopBarUi()
            if (titleLp != null) {
                titleLp.topMargin = dpToPx(if (isLiveTvTopBarCompactTwoRow) 114 else 84)
                tvVideoTitle.layoutParams = titleLp
            }
            if (isInPipModeCompat()) {
                bar.visibility = View.GONE
            }
        } else {
            liveTvTopBar?.visibility = View.GONE
            if (titleLp != null) {
                titleLp.topMargin = dpToPx(32)
                tvVideoTitle.layoutParams = titleLp
            }
        }

        // Disable pause / rewind / fast-forward / scrubbing across ALL Live TV broadcasts
        if (isLiveSeekLocked()) {
            btnRewind.visibility = View.GONE
            btnForward.visibility = View.GONE
            btnPlayPause.visibility = View.GONE
            btnPlayPause.isFocusable = false
            btnPlayPause.isClickable = false
            centerControls.visibility = View.GONE
            seekBar.isEnabled = false
            seekBar.isFocusable = false
            seekBar.isClickable = false
            seekBar.thumb?.mutate()?.alpha = 0
            seekBar.alpha = 0.55f
            layoutSkipIntro.visibility = View.GONE
            layoutNextEpisode.visibility = View.GONE
        } else {
            btnRewind.visibility = View.VISIBLE
            btnForward.visibility = View.VISIBLE
            btnPlayPause.visibility = View.VISIBLE
            btnPlayPause.isFocusable = true
            btnPlayPause.isClickable = true
            btnPlayPause.alpha = 1.0f
            seekBar.isEnabled = true
            seekBar.isFocusable = true
            seekBar.isClickable = true
            seekBar.thumb?.mutate()?.alpha = 255
            seekBar.alpha = 1.0f
        }

        // Configure Synchronized Credits Continuity & Pay-TV Squeeze-Back (Live TV only)
        liveTvSqueezeController?.destroy()
        liveTvSqueezeController = null
        if (isLiveTvMode) {
            val isKids = srcIntent.getBooleanExtra(EXTRA_IS_KIDS_PROFILE, false)
            val slotDesc = LiveTvSqueezeBackController.LiveSlotDescriptor(
                channelId = liveTvChannelId,
                mediaType = resolvedMediaType,
                itemId = resolvedItemId,
                tmdbId = resolvedTmdbId,
                season = season.toIntOrNull() ?: 0,
                episode = episode.toIntOrNull() ?: 0,
                isKidsProfile = isKids,
                isPremiereChannel = isPremiereSyncLocked,
                manualCreditsStartSec = srcIntent.getStringExtra(EXTRA_CREDITS_START)?.toIntOrNull(),
                introDbCreditsMs = srcIntent.getStringExtra(EXTRA_INTRODB_CREDITS_MS)?.toLongOrNull(),
                initialContinuityJson = srcIntent.getStringExtra(EXTRA_LIVE_TV_CONTINUITY_JSON).orEmpty(),
                initialUpNextJson = srcIntent.getStringExtra(EXTRA_LIVE_TV_UP_NEXT_JSON).orEmpty(),
                initialOtherChannelsJson = srcIntent.getStringExtra(EXTRA_LIVE_TV_OTHER_CHANNELS_JSON).orEmpty()
            )
            liveTvSqueezeController = LiveTvSqueezeBackController(
                activity = this,
                rootContainer = rootFrame,
                videoSurface = playerView,
                descriptor = slotDesc,
                onRequestPreloadNext = { chId ->
                    MainActivity.preloadNextLiveTvProgramFromPlayer(chId)
                },
                onZapToChannel = { targetChId ->
                    triggerLiveTvSpecificChannelZap(targetChId)
                },
                onSqueezeVisibilityChanged = { visible ->
                    if (visible) {
                        if (controlsVisible) hideControls()
                        if (tvVideoTitle.visibility == View.VISIBLE) {
                            titleHandler.removeCallbacksAndMessages(null)
                            tvVideoTitle.animate().cancel()
                            tvVideoTitle.visibility = View.GONE
                        }
                        if (isTvOrDpadActive()) {
                            rootFrame.post {
                                if (!controlsVisible) {
                                    liveTvSqueezeController?.focusFirstChannelCardIfAvailable()
                                }
                            }
                        }
                    }
                }
            )
        }

        // Configure Prime-style Native X-Ray on Pause + Bottom-bar Toggle (VOD only; never in Live TV / Premiere)
        xrayController?.destroy()
        xrayController = null
        resetXrayFocusAndToggleUi()
        if (!isLiveTvMode && !isPremiereSyncLocked) {
            btnXrayToggle.visibility = View.VISIBLE
            btnCastBottom.nextFocusLeftId = R.id.btn_xray_toggle
            seekBar.nextFocusDownId = R.id.btn_xray_toggle

            val isKids = srcIntent.getBooleanExtra(EXTRA_IS_KIDS_PROFILE, false)

            val descriptor = XrayOverlayController.MediaDescriptor(
                mediaType = resolvedMediaType,
                id = cleanLookupId,
                tmdbId = resolvedTmdbId,
                title = resolvedCleanTitle,
                year = resolvedYear,
                season = season.toIntOrNull() ?: 0,
                episode = episode.toIntOrNull() ?: 0,
                isCleanCatalogTitle = explicitCleanTitle != null
            )
            xrayController = XrayOverlayController(
                activity = this,
                rootContainer = rootFrame,
                mediaDescriptor = descriptor,
                userPhone = phone,
                isKidsProfile = isKids,
                onPanelVisibilityChanged = { visible, anchoredAtTop, firstChip ->
                    btnXrayToggle.setTextColor(
                        Color.parseColor(if (visible) "#A7F3D0" else "#FDE68A")
                    )
                    if (visible && anchoredAtTop && tvVideoTitle.visibility == View.VISIBLE) {
                        titleHandler.removeCallbacksAndMessages(null)
                        tvVideoTitle.animate().cancel()
                        tvVideoTitle.visibility = View.GONE
                    }
                    val chipId = firstChip?.id ?: View.NO_ID
                    if (visible && chipId != View.NO_ID) {
                        if (anchoredAtTop) {
                            btnPlayPause.nextFocusUpId = chipId
                            btnRewind.nextFocusUpId = chipId
                            btnForward.nextFocusUpId = chipId
                            btnPlayPause.nextFocusDownId = R.id.seek_bar
                            btnRewind.nextFocusDownId = R.id.seek_bar
                            btnForward.nextFocusDownId = R.id.seek_bar
                            seekBar.nextFocusUpId = R.id.btn_play_pause
                        } else {
                            btnPlayPause.nextFocusUpId = View.NO_ID
                            btnRewind.nextFocusUpId = View.NO_ID
                            btnForward.nextFocusUpId = View.NO_ID
                            btnPlayPause.nextFocusDownId = chipId
                            btnRewind.nextFocusDownId = chipId
                            btnForward.nextFocusDownId = chipId
                            seekBar.nextFocusUpId = chipId
                        }
                    } else {
                        resetCenterAndSeekFocusLinks()
                    }
                },
                onWatchlistMutated = {
                    MainActivity.notifyWatchlistMutatedFromPlayer()
                },
                onOpenCatalogItem = { targetItem ->
                    MainActivity.deliverOpenCatalogItemFromPlayer(
                        mediaType = targetItem.mediaType,
                        itemId = targetItem.id,
                        tmdbId = targetItem.tmdbId,
                        title = targetItem.title,
                        year = targetItem.year,
                        posterPath = targetItem.posterPath,
                        payload = targetItem.payload,
                        rawItemJson = targetItem.rawItemJson
                    )
                    val res = Intent().apply {
                        putExtra("open_catalog_item", true)
                        putExtra("media_type", targetItem.mediaType)
                        putExtra("item_id", targetItem.id)
                        putExtra("tmdb_id", targetItem.tmdbId)
                        putExtra("title", targetItem.title)
                        putExtra("year", targetItem.year)
                        putExtra("poster_path", targetItem.posterPath ?: "")
                        putExtra("payload", targetItem.payload ?: "")
                        putExtra("raw_item_json", targetItem.rawItemJson)
                    }
                    setResult(RESULT_OK, res)
                    finish()
                }
            )
            xrayController?.onControlsVisibilityChanged(controlsVisible)
        } else {
            btnXrayToggle.visibility = View.GONE
            btnCastBottom.nextFocusLeftId = View.NO_ID
            seekBar.nextFocusDownId = R.id.btn_cast_bottom
        }
    }

    private fun resetCenterAndSeekFocusLinks() {
        if (isLiveSeekLocked()) {
            val topTargetId = btnLiveFicha?.takeIf { it.visibility == View.VISIBLE }?.id
                ?: btnLiveChNext?.id
                ?: View.NO_ID
            val downTargetFromTop = R.id.btn_tracks
            btnLiveFicha?.nextFocusDownId = downTargetFromTop
            btnLiveChPrev?.nextFocusDownId = downTargetFromTop
            btnLiveChNext?.nextFocusDownId = downTargetFromTop
            btnLiveGuide?.nextFocusDownId = downTargetFromTop

            btnCastBottom.nextFocusUpId = topTargetId
            btnTracks.nextFocusUpId = topTargetId
            btnResize.nextFocusUpId = topTargetId
            btnReportError.nextFocusUpId = topTargetId
        } else {
            btnPlayPause.nextFocusUpId = View.NO_ID
            btnRewind.nextFocusUpId = View.NO_ID
            btnForward.nextFocusUpId = View.NO_ID
            btnPlayPause.nextFocusDownId = R.id.seek_bar
            btnRewind.nextFocusDownId = R.id.seek_bar
            btnForward.nextFocusDownId = R.id.seek_bar
            seekBar.nextFocusUpId = R.id.btn_play_pause

            btnCastBottom.nextFocusUpId = R.id.seek_bar
            btnTracks.nextFocusUpId = R.id.seek_bar
            btnResize.nextFocusUpId = R.id.seek_bar
            btnReportError.nextFocusUpId = R.id.seek_bar
        }
    }

    private fun resetXrayFocusAndToggleUi() {
        btnXrayToggle.setTextColor(Color.parseColor("#FDE68A"))
        resetCenterAndSeekFocusLinks()
    }

    private fun canOpenCurrentLiveProgramFicha(): Boolean {
        return liveTvFichaItemId.isNotBlank() ||
            liveTvFichaTmdbId > 0 ||
            liveTvFichaCleanTitle.isNotBlank() ||
            liveTvFichaRawJson.isNotBlank() ||
            currentTitle.isNotBlank()
    }

    private fun updateLiveTvTopBarUi() {
        val chText = liveTvChannelLabel.ifBlank { "Cineflix TV" }
        tvLiveTvBadgeText?.text = if (isPremiereSyncLocked) {
            "🔴 EN DIRECTO  •  $chText  •  🔒 Sincronizado"
        } else {
            "🔴 EN DIRECTO  •  $chText"
        }
        val progText = liveTvProgramDisplayTitle.ifBlank {
            formatLiveTvProgramDisplayTitle(
                cleanTitle = liveTvFichaCleanTitle,
                rawTitle = currentTitle,
                year = liveTvFichaYear,
                mediaType = liveTvFichaMediaType
            )
        }
        tvLiveTvProgramTitle?.let { pTv ->
            pTv.text = progText
            pTv.visibility = if (progText.isNotBlank()) View.VISIBLE else View.GONE
        }
        btnLiveFicha?.let { fichaBtn ->
            val canOpen = canOpenCurrentLiveProgramFicha()
            fichaBtn.visibility = if (canOpen) View.VISIBLE else View.GONE
            if (canOpen) {
                btnLiveChPrev?.nextFocusLeftId = fichaBtn.id
                fichaBtn.nextFocusRightId = btnLiveChPrev?.id ?: View.NO_ID
            } else {
                btnLiveChPrev?.nextFocusLeftId = View.NO_ID
            }
        }
        resetCenterAndSeekFocusLinks()
    }

    private fun openCurrentLiveProgramFicha() {
        if (!canOpenCurrentLiveProgramFicha()) return
        val fallbackCleanTitle = liveTvFichaCleanTitle.ifBlank {
            XrayOverlayController.sanitizeLookupTitle(currentTitle).ifBlank { currentTitle.trim() }
        }
        val fallbackYear = liveTvFichaYear.ifBlank {
            XrayOverlayController.extractYearFromTitle(currentTitle)
        }
        liveTvAutoAdvancePending = false
        liveTvZapPending = false
        backgroundReleaseHandler.removeCallbacks(liveTvAutoAdvanceTimeoutRunnable)
        backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
        liveTvSqueezeController?.destroy()
        liveTvSqueezeController = null
        isLiveTvMode = false
        hadLiveTvSession = false
        MainActivity.stopLiveTvFromPlayer(reopenGrid = false, onlyIfNotTuning = false)

        MainActivity.deliverOpenCatalogItemFromPlayer(
            mediaType = liveTvFichaMediaType,
            itemId = liveTvFichaItemId,
            tmdbId = liveTvFichaTmdbId,
            title = fallbackCleanTitle,
            year = fallbackYear,
            posterPath = liveTvFichaPosterPath.takeIf { it.isNotBlank() },
            payload = liveTvFichaPayload.takeIf { it.isNotBlank() },
            rawItemJson = liveTvFichaRawJson
        )
        val res = Intent().apply {
            putExtra("open_catalog_item", true)
            putExtra("media_type", liveTvFichaMediaType)
            putExtra("item_id", liveTvFichaItemId)
            putExtra("tmdb_id", liveTvFichaTmdbId)
            putExtra("title", fallbackCleanTitle)
            putExtra("year", fallbackYear)
            putExtra("poster_path", liveTvFichaPosterPath)
            putExtra("payload", liveTvFichaPayload)
            putExtra("raw_item_json", liveTvFichaRawJson)
        }
        setResult(RESULT_OK, res)
        finish()
    }

    private fun triggerLiveTvChannelZap(delta: Int) {
        if (!isLiveTvMode) return
        val step = if (delta >= 0) 1 else -1
        liveTvSqueezeController?.restoreFullscreenImmediate()
        liveTvZapPending = true
        backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
        backgroundReleaseHandler.postDelayed(liveTvZapTimeoutRunnable, 25_000L)

        if (!isInPipModeCompat()) {
            loadingSpinner.visibility = View.VISIBLE
            showTitle(if (step >= 0) "📺 Cambiando a Canal +..." else "📺 Cambiando a Canal -...")
            if (controlsVisible) {
                scheduleHideControls()
            }
        }

        MainActivity.zapLiveTvFromPlayer(step, liveTvChannelId) { target ->
            if (isFinishing || isDestroyed || !isLiveTvMode) return@zapLiveTvFromPlayer
            applyResolvedZapTargetToUi(target)
        }
    }

    private fun triggerLiveTvSpecificChannelZap(targetChannelId: String) {
        if (!isLiveTvMode || targetChannelId.isBlank()) return
        liveTvSqueezeController?.restoreFullscreenImmediate()
        liveTvZapPending = true
        backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
        backgroundReleaseHandler.postDelayed(liveTvZapTimeoutRunnable, 25_000L)

        if (!isInPipModeCompat()) {
            loadingSpinner.visibility = View.VISIBLE
            showTitle("📺 Cambiando de canal...")
            if (controlsVisible) {
                scheduleHideControls()
            }
        }

        MainActivity.zapToSpecificLiveTvChannelFromPlayer(targetChannelId) { target ->
            if (isFinishing || isDestroyed || !isLiveTvMode) return@zapToSpecificLiveTvChannelFromPlayer
            applyResolvedZapTargetToUi(target)
        }
    }

    private fun applyResolvedZapTargetToUi(target: MainActivity.Companion.NativeZapTarget) {
        val updated = applyNativeZapTargetToFichaState(
            previousChannelId = liveTvChannelId,
            previousChannelLabel = liveTvChannelLabel,
            target = target
        )
        liveTvChannelId = updated.channelId
        liveTvChannelLabel = updated.channelLabel
        isPremiereSyncLocked = updated.isPremiereLocked
        liveTvFichaItemId = updated.itemId
        liveTvFichaTmdbId = updated.tmdbId
        liveTvFichaYear = updated.year
        liveTvFichaMediaType = updated.mediaType
        liveTvFichaCleanTitle = updated.cleanTitle
        liveTvFichaPosterPath = updated.posterPath
        liveTvFichaPayload = updated.payload
        liveTvFichaRawJson = updated.rawItemJson
        liveTvProgramDisplayTitle = updated.programDisplayTitle
        updateLiveTvTopBarUi()
        if (!isInPipModeCompat()) {
            val banner = when {
                updated.channelLabel.isNotBlank() && liveTvProgramDisplayTitle.isNotBlank() ->
                    "📺 ${updated.channelLabel} — $liveTvProgramDisplayTitle"
                liveTvProgramDisplayTitle.isNotBlank() -> "📺 $liveTvProgramDisplayTitle"
                updated.channelLabel.isNotBlank() -> "📺 ${updated.channelLabel}"
                else -> ""
            }
            if (banner.isNotBlank()) {
                showTitle(banner)
            }
        }
    }

    private fun ensureLiveTvTopBar(): LinearLayout {
        liveTvTopBar?.let { return it }
        val swDp = resources.configuration.screenWidthDp
        val fontScale = resources.configuration.fontScale
        val compactTwoRow = !StorageAndRamHygiene.isTelevision(this) &&
            ((swDp in 1..679) || (fontScale > 1.15f && swDp in 1..779))
        isLiveTvTopBarCompactTwoRow = compactTwoRow

        val bar = LinearLayout(this).apply {
            orientation = if (compactTwoRow) LinearLayout.VERTICAL else LinearLayout.HORIZONTAL
            gravity = if (compactTwoRow) Gravity.START else Gravity.CENTER_VERTICAL
            isClickable = true
            elevation = dpToPx(16).toFloat()
            translationZ = dpToPx(16).toFloat()
            setPadding(
                dpToPx(if (compactTwoRow) 12 else 14),
                dpToPx(if (compactTwoRow) 8 else 9),
                dpToPx(if (compactTwoRow) 12 else 14),
                dpToPx(if (compactTwoRow) 8 else 9)
            )
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dpToPx(14).toFloat()
                setColor(Color.parseColor("#D90D0E14"))
                setStroke(dpToPx(1), Color.parseColor("#33FFFFFF"))
            }
            visibility = View.GONE
        }

        val infoColumn = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = if (compactTwoRow) {
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            } else {
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                    rightMargin = dpToPx(10)
                }
            }
        }

        val badgeTv = TextView(this).apply {
            setTextColor(Color.parseColor("#E2E8F0"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compactTwoRow) 11f else 11.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            isSingleLine = true
            ellipsize = android.text.TextUtils.TruncateAt.END
        }
        tvLiveTvBadgeText = badgeTv
        infoColumn.addView(badgeTv)

        val progTv = TextView(this).apply {
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compactTwoRow) 13.5f else 14.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            isSingleLine = true
            ellipsize = android.text.TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dpToPx(2)
            }
        }
        tvLiveTvProgramTitle = progTv
        infoColumn.addView(progTv)

        bar.addView(infoColumn)

        fun makeActionChip(
            label: String,
            highlighted: Boolean = false,
            firstInRow: Boolean = false,
            onClick: () -> Unit
        ): TextView {
            return TextView(this).apply {
                id = View.generateViewId()
                text = label
                val normalTextColor = if (highlighted) Color.parseColor("#FEF08A") else Color.WHITE
                setTextColor(normalTextColor)
                setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compactTwoRow) 11.5f else 12f)
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1
                isSingleLine = true
                isFocusable = true
                isClickable = true
                setPadding(
                    dpToPx(if (compactTwoRow) 9 else 11),
                    dpToPx(if (compactTwoRow) 5 else 6),
                    dpToPx(if (compactTwoRow) 9 else 11),
                    dpToPx(if (compactTwoRow) 5 else 6)
                )
                val normalBg = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = dpToPx(10).toFloat()
                    if (highlighted) {
                        setColor(Color.parseColor("#2EFACC15"))
                        setStroke(dpToPx(1), Color.parseColor("#88FACC15"))
                    } else {
                        setColor(Color.parseColor("#26FFFFFF"))
                        setStroke(dpToPx(1), Color.parseColor("#40FFFFFF"))
                    }
                }
                val focusBg = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = dpToPx(10).toFloat()
                    setColor(Color.parseColor("#E50914"))
                    setStroke(dpToPx(2), Color.WHITE)
                }
                background = normalBg
                setOnFocusChangeListener { v, hasFocus ->
                    v.background = if (hasFocus) focusBg else normalBg
                    (v as? TextView)?.setTextColor(if (hasFocus) Color.WHITE else normalTextColor)
                    scheduleHideControls()
                }
                setOnClickListener {
                    scheduleHideControls()
                    onClick()
                }
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    leftMargin = if (compactTwoRow && firstInRow) 0 else dpToPx(6)
                }
            }
        }

        val fichaChip = makeActionChip("ℹ Ficha", highlighted = true, firstInRow = true) {
            openCurrentLiveProgramFicha()
        }
        val prevChip = makeActionChip("⏮ CH-") {
            triggerLiveTvChannelZap(-1)
        }
        val nextChip = makeActionChip("CH+ ⏭") {
            triggerLiveTvChannelZap(1)
        }
        val guideChip = makeActionChip("📋 Guía") {
            if (!tryEnterLiveTvPictureInPicture()) {
                finish()
            }
        }
        fichaChip.nextFocusRightId = prevChip.id
        prevChip.nextFocusLeftId = fichaChip.id
        prevChip.nextFocusRightId = nextChip.id
        nextChip.nextFocusLeftId = prevChip.id
        nextChip.nextFocusRightId = guideChip.id
        guideChip.nextFocusLeftId = nextChip.id

        btnLiveFicha = fichaChip
        btnLiveChPrev = prevChip
        btnLiveChNext = nextChip
        btnLiveGuide = guideChip

        if (compactTwoRow) {
            val actionsRow = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = dpToPx(6)
                }
            }
            actionsRow.addView(fichaChip)
            actionsRow.addView(prevChip)
            actionsRow.addView(nextChip)
            actionsRow.addView(guideChip)
            bar.addView(actionsRow)
        } else {
            bar.addView(fichaChip)
            bar.addView(prevChip)
            bar.addView(nextChip)
            bar.addView(guideChip)
        }

        val baseSideMargin = dpToPx(if (compactTwoRow) 14 else 20)
        val baseTopMargin = dpToPx(if (compactTwoRow) 12 else 16)
        val lp = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.TOP
            leftMargin = baseSideMargin
            rightMargin = baseSideMargin
            topMargin = baseTopMargin
        }
        ViewCompat.setOnApplyWindowInsetsListener(bar) { v, insets ->
            val cutout = insets.getInsets(WindowInsetsCompat.Type.displayCutout())
            val curLp = v.layoutParams as? FrameLayout.LayoutParams
            if (curLp != null) {
                val safeLeft = maxOf(baseSideMargin, cutout.left + dpToPx(10))
                val safeRight = maxOf(baseSideMargin, cutout.right + dpToPx(10))
                val safeTop = maxOf(baseTopMargin, cutout.top + dpToPx(6))
                if (curLp.leftMargin != safeLeft || curLp.rightMargin != safeRight || curLp.topMargin != safeTop) {
                    curLp.leftMargin = safeLeft
                    curLp.rightMargin = safeRight
                    curLp.topMargin = safeTop
                    v.layoutParams = curLp
                }
            }
            insets
        }
        rootFrame.addView(bar, lp)
        ViewCompat.requestApplyInsets(bar)
        liveTvTopBar = bar
        return bar
    }

    private fun notifyPremiereSyncLockedToast() {
        val now = System.currentTimeMillis()
        if (now - lastPremiereLockToastAtMs < 2500L) return
        lastPremiereLockToastAtMs = now
        Toast.makeText(
            this,
            "🔒 El Peliculón en directo: reproducción sincronizada para todos",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun notifyLiveSeekLockedToast() {
        if (isPremiereSyncLocked) {
            notifyPremiereSyncLockedToast()
            return
        }
        val now = System.currentTimeMillis()
        if (now - lastPremiereLockToastAtMs < 2500L) return
        lastPremiereLockToastAtMs = now
        Toast.makeText(
            this,
            "📺 Emisión en directo: no se puede avanzar ni retroceder",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun notifyLivePauseLockedToast() {
        if (!isAnyCastActive() && (!hasRenderedLiveVideoFrame || player?.playbackState != Player.STATE_READY)) {
            return
        }
        if (isReleasingOrRecoveringPlayer || isFinishing || isDestroyed) return
        if (isPremiereSyncLocked) {
            notifyPremiereSyncLockedToast()
            return
        }
        val now = System.currentTimeMillis()
        if (now - lastPremiereLockToastAtMs < 2500L) return
        lastPremiereLockToastAtMs = now
        Toast.makeText(
            this,
            "📺 Emisión en directo: no se puede pausar",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun isInPipModeCompat(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInPictureInPictureMode
    }

    private fun notifyXrayPlaybackState() {
        val ctrl = xrayController ?: return
        val p = player
        val isPlaybackPaused = p != null && !p.playWhenReady &&
            p.playbackState != Player.STATE_IDLE &&
            p.playbackState != Player.STATE_ENDED
        val isPausedReady = isPlaybackPaused &&
            p.playbackState == Player.STATE_READY && !p.isPlaying
        val suppress = isLiveTvMode || isPremiereSyncLocked || isAnyCastActive() || isInPipModeCompat() || isSeeking || pendingSeekTargetMs != null
        ctrl.onPlaybackStateUpdated(
            isPausedReady = isPausedReady,
            positionMs = getCurrentEffectivePositionMs(),
            durationMs = getCurrentEffectiveDurationMs(),
            suppressAll = suppress,
            isPlaybackPaused = isPlaybackPaused
        )
    }

    private fun tryEnterLiveTvPictureInPicture(): Boolean {
        if (!isLiveTvMode || isAnyCastActive() || isFinishing || isDestroyed) return false
        if (isInPipModeCompat()) return true
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)) return false
        return try {
            liveTvSqueezeController?.restoreFullscreenImmediate()
            xrayController?.hideAllImmediate()
            hideControlsImmediateForPip()
            enteringPipUntilElapsedMs = android.os.SystemClock.elapsedRealtime() + 1500L
            val params = PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16, 9))
                .build()
            val entered = enterPictureInPictureMode(params)
            if (!entered) {
                enteringPipUntilElapsedMs = 0L
            }
            entered
        } catch (e: Throwable) {
            enteringPipUntilElapsedMs = 0L
            Log.w(TAG, "Picture-in-Picture unavailable: ${e.message}")
            false
        }
    }

    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        if (isLiveTvMode && !isAnyCastActive() && !isInPipModeCompat()) {
            tryEnterLiveTvPictureInPicture()
        }
    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            enteringPipUntilElapsedMs = 0L
            isActivityPausedForLifecycle = false
            backgroundReleaseHandler.removeCallbacks(backgroundIdleReleaseRunnable)
            loadingSpinner.visibility = View.GONE
            liveTvSqueezeController?.restoreFullscreenImmediate()
            xrayController?.hideAllImmediate()
            hideControlsImmediateForPip()
            if (isLivePauseLocked() && !isAnyCastActive() && player?.playWhenReady == false) {
                player?.play()
            }
        } else {
            hideSystemUI()
            // If user tapped [X] Close on the PiP window, lifecycle is STOPPED/CREATED -> finish cleanly!
            if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) && !isFinishing) {
                isLiveTvMode = false
                finish()
            } else if (isLiveTvMode) {
                showTitle(currentTitle)
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_DPAD_UP ||
            keyCode == KeyEvent.KEYCODE_DPAD_DOWN ||
            keyCode == KeyEvent.KEYCODE_DPAD_LEFT ||
            keyCode == KeyEvent.KEYCODE_DPAD_RIGHT ||
            keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
            keyCode == KeyEvent.KEYCODE_ENTER ||
            keyCode == KeyEvent.KEYCODE_CHANNEL_UP ||
            keyCode == KeyEvent.KEYCODE_CHANNEL_DOWN ||
            keyCode == KeyEvent.KEYCODE_INFO ||
            keyCode == KeyEvent.KEYCODE_GUIDE
        ) {
            hasSeenDpadInput = true
            xrayController?.notifyDpadActive()
        }
        if (!isAnyCastActive() && player == null) return super.onKeyDown(keyCode, event)

        if (isLiveTvMode && !isAnyCastActive()) {
            if (keyCode == KeyEvent.KEYCODE_CHANNEL_UP || keyCode == KeyEvent.KEYCODE_PAGE_UP) {
                triggerLiveTvChannelZap(1)
                return true
            }
            if (keyCode == KeyEvent.KEYCODE_CHANNEL_DOWN || keyCode == KeyEvent.KEYCODE_PAGE_DOWN) {
                triggerLiveTvChannelZap(-1)
                return true
            }
            if (keyCode == KeyEvent.KEYCODE_GUIDE || keyCode == KeyEvent.KEYCODE_TV_CONTENTS_MENU) {
                if (!tryEnterLiveTvPictureInPicture()) finish()
                return true
            }
            if (keyCode == KeyEvent.KEYCODE_INFO) {
                if (!controlsVisible) {
                    showControls()
                } else {
                    openCurrentLiveProgramFicha()
                }
                return true
            }
        }

        if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE ||
            keyCode == KeyEvent.KEYCODE_SPACE ||
            (isLivePauseLocked() && keyCode == KeyEvent.KEYCODE_HEADSETHOOK)
        ) {
            togglePlayPause()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_PAUSE || keyCode == KeyEvent.KEYCODE_MEDIA_STOP) {
            if (isLivePauseLocked()) {
                notifyLivePauseLockedToast()
                if (!isAnyCastActive() && player?.isPlaying == false && player?.playbackState == Player.STATE_READY) {
                    player?.play()
                }
                showControls()
                return true
            }
            player?.pause()
            showControls()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY) {
            player?.play()
            showControls()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_FAST_FORWARD ||
            keyCode == KeyEvent.KEYCODE_MEDIA_STEP_FORWARD ||
            (isLiveSeekLocked() && keyCode == KeyEvent.KEYCODE_MEDIA_NEXT)
        ) {
            seekRelative(10000)
            showControls()
            return true
        }
        if (keyCode == KeyEvent.KEYCODE_MEDIA_REWIND ||
            keyCode == KeyEvent.KEYCODE_MEDIA_STEP_BACKWARD ||
            (isLiveSeekLocked() && keyCode == KeyEvent.KEYCODE_MEDIA_PREVIOUS)
        ) {
            seekRelative(-10000)
            showControls()
            return true
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
            if (!controlsVisible && liveTvSqueezeController?.isSqueezeVisible() == true) {
                if (liveTvSqueezeController?.hasSqueezeFocus() == true) {
                    return super.onKeyDown(keyCode, event)
                }
                if (liveTvSqueezeController?.focusFirstChannelCardIfAvailable() == true) return true
            }
            if (!controlsVisible && xrayController?.isAnyOverlayVisible() != true) {
                if (!isLiveSeekLocked()) {
                    seekRelative(-10000)
                }
                showControls()
                return true
            }
            if (!controlsVisible && xrayController?.isAnyOverlayVisible() == true && xrayController?.hasOverlayFocus() != true) {
                if (xrayController?.focusFirstChipIfAvailable() == true) return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            if (!controlsVisible && liveTvSqueezeController?.isSqueezeVisible() == true) {
                if (liveTvSqueezeController?.hasSqueezeFocus() == true) {
                    return super.onKeyDown(keyCode, event)
                }
                if (liveTvSqueezeController?.focusFirstChannelCardIfAvailable() == true) return true
            }
            if (!controlsVisible && xrayController?.isAnyOverlayVisible() != true) {
                if (!isLiveSeekLocked()) {
                    seekRelative(10000)
                }
                showControls()
                return true
            }
            if (!controlsVisible && xrayController?.isAnyOverlayVisible() == true && xrayController?.hasOverlayFocus() != true) {
                if (xrayController?.focusFirstChipIfAvailable() == true) return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            if (liveTvSqueezeController?.hasSqueezeFocus() == true) {
                return super.onKeyDown(keyCode, event)
            }
            if (!controlsVisible && liveTvSqueezeController?.isSqueezeVisible() == true) {
                if (liveTvSqueezeController?.focusFirstChannelCardIfAvailable() == true) return true
            }
            if (!controlsVisible && xrayController?.hasOverlayFocus() != true) {
                if (isLivePauseLocked()) {
                    showControls()
                } else {
                    togglePlayPause()
                }
                return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }

        if (keyCode == KeyEvent.KEYCODE_DPAD_UP || keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (!controlsVisible && keyCode == KeyEvent.KEYCODE_DPAD_DOWN &&
                liveTvSqueezeController?.isSqueezeVisible() == true
            ) {
                if (liveTvSqueezeController?.hasSqueezeFocus() != true &&
                    liveTvSqueezeController?.focusFirstChannelCardIfAvailable() == true
                ) {
                    return true
                }
            }
            if (!controlsVisible) {
                showControls()
                return true
            }
            scheduleHideControls()
            return super.onKeyDown(keyCode, event)
        }

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (xrayController?.onBackPressed() == true) {
                return true
            }
            if (isAnyCastActive()) {
                returnToCatalogWhileCasting()
                return true
            }
            if (controlsVisible) {
                hideControls()
                return true
            }
            if (isLiveTvMode && tryEnterLiveTvPictureInPicture()) {
                return true
            }
            finish()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN && !isInPipModeCompat()) {
            toggleControls()
            return true
        }
        return super.onTouchEvent(event)
    }

    // --- Unified 1-Tap Cast (Google Cast + Native DLNA Smart TVs: Samsung Tizen, LG webOS, etc.) ---
    private fun ensureCastDiscoveryInitialized(startScan: Boolean = false) {
        if (castContext == null && sessionManager == null) {
            try {
                castContext = CastContext.getSharedInstance(this)
                sessionManager = castContext?.sessionManager
            } catch (e: Throwable) {
                Log.w(TAG, "Google Cast SDK unavailable (DLNA Smart TV discovery remains 100% active): ${e.message}")
            }
            setupCastSessionListener()
        }
        val discovery = unifiedTvDiscovery ?: UnifiedTvDiscoveryManager(this).also {
            unifiedTvDiscovery = it
        }
        if (startScan) {
            discovery.startActiveDiscovery(forceRefresh = false)
        }
    }

    private fun setupUnifiedCastEngine() {
        setupDlnaControllerListener()

        // Pre-warm Wi-Fi discovery on phones/tablets so TVs are ready in 0ms when tapping Cast;
        // on Android TV boxes, defer loading Google Play Services Cast Dynamite (~15-22 MB) & MediaRouter
        // until the user actually taps the Cast button (or re-attaches to an active Cast session).
        val eagerInit = !StorageAndRamHygiene.isTelevision(this) ||
            isAnyCastActive() ||
            CastSessionCoordinator.isCastingActive ||
            intent.getBooleanExtra(EXTRA_ATTACH_ACTIVE_CAST, false)
        if (eagerInit) {
            ensureCastDiscoveryInitialized(startScan = true)
        }
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
                localStreamServer = null
                castEndedAndSynced = true
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
                castEndedAndSynced = true
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
                castEndedAndSynced = true
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
        val targetHost = try {
            session.castDevice?.inetAddress?.hostAddress
        } catch (_: Throwable) {
            null
        }
        val lanIp = LanNetworkUtils.getBestLanIpv4(this, targetHost)
        val lss = localStreamServer
        if ((lanIp == null || lss == null || lss.listeningPort <= 0) && castStreamUrl == null) {
            Toast.makeText(this, "Conéctate a una red Wi-Fi para enviar a la TV", Toast.LENGTH_LONG).show()
            return
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
        val resumeAtMs = lastCastPositionMs
        val loadGen = googleCastLoadGeneration.incrementAndGet()

        Thread {
            if (lss != null) {
                try {
                    lss.getOrParseMatroskaHeaderInfo()
                } catch (_: Exception) {}
            }
            if (loadGen != googleCastLoadGeneration.get()) return@Thread
            syncTrackSelectionToStreamServer()
            // Pre-warm subtitles BEFORE closing the old video socket so Chromecast never auto-reconnects
            // on the old stream while subtitle cues are being extracted!
            val vttUrl = if (lanIp != null && lss != null) {
                try {
                    lss.resolveLanGoogleCastSubtitleVttUrl(lanIp, resumeAtMs)
                } catch (_: Exception) {
                    null
                }
            } else {
                null
            }
            if (loadGen != googleCastLoadGeneration.get()) return@Thread
            val streamUrl = when {
                lanIp != null && lss != null && lss.listeningPort > 0 -> lss.resolveLanGoogleCastUrl(lanIp)
                else -> castStreamUrl ?: return@Thread
            }
            val slotUrls = if (lanIp != null && lss != null && lss.listeningPort > 0) {
                lss.buildGoogleCastSubtitleTrackSlots(lanIp)
            } else {
                emptyList()
            }
            val durHint = getCurrentEffectiveDurationMs()

            runOnUiThread {
                if (isFinishing || isDestroyed || loadGen != googleCastLoadGeneration.get()) return@runOnUiThread
                val mediaInfoBuilder = MediaInfo.Builder(streamUrl)
                    .setContentType("video/mp4")
                    .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                    .setMetadata(metadata)
                if (durHint > 0L) {
                    mediaInfoBuilder.setStreamDuration(durHint)
                }
                if (slotUrls.isNotEmpty()) {
                    val vttTracks = slotUrls.map { (slotId, slotUrl) ->
                        com.google.android.gms.cast.MediaTrack.Builder(
                            slotId,
                            com.google.android.gms.cast.MediaTrack.TYPE_TEXT
                        )
                            .setName("Subtítulos")
                            .setSubtype(com.google.android.gms.cast.MediaTrack.SUBTYPE_SUBTITLES)
                            .setContentId(slotUrl)
                            .setContentType("text/vtt")
                            .setLanguage("es")
                            .build()
                    }
                    mediaInfoBuilder.setMediaTracks(vttTracks)
                } else if (!vttUrl.isNullOrBlank()) {
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
        ensureCastDiscoveryInitialized(startScan = false)
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
            if (StorageAndRamHygiene.isTelevision(this) && !isAnyCastActive()) {
                unifiedTvDiscovery?.stopActiveDiscovery()
            }
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
     * Toggles or switches subtitles on an active Google Cast session in-place using pre-registered
     * WebVTT `MediaTrack` slots (`1L..24L`) via `RemoteMediaClient.setActiveMediaTracks` —
     * zero video reload, zero socket drop, and zero audio interruption!
     */
    private fun applyGoogleCastSubtitleChangeInPlace(toastLabel: String) {
        val lss = localStreamServer ?: return
        val session = sessionManager?.currentCastSession
        if (session == null || !session.isConnected) {
            reloadActiveCastForTrackChange(toastLabel)
            return
        }
        val (effSubMode, effSubTrackNum, effSubOrdinal) = resolveEffectiveSubtitleSelection()
        syncCurrentTracksToCoordinator()
        val curPosMs = getCurrentEffectivePositionMs()
        Toast.makeText(this, toastLabel, Toast.LENGTH_SHORT).show()

        lss.updateCastSubtitleSelectionInPlace(
            subtitleMode = effSubMode,
            subtitleTrackNumber = effSubTrackNum,
            subtitleOrdinal = effSubOrdinal,
            currentPositionMs = curPosMs
        ) { nextSlot ->
            runOnUiThread {
                if (isFinishing || isDestroyed || !isGoogleCasting) return@runOnUiThread
                val rmc = sessionManager?.currentCastSession?.remoteMediaClient ?: return@runOnUiThread
                try {
                    if (nextSlot != null && nextSlot > 0L) {
                        rmc.setActiveMediaTracks(longArrayOf(nextSlot))
                    } else {
                        rmc.setActiveMediaTracks(longArrayOf())
                    }
                } catch (_: Throwable) {}
            }
        }
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

        if (!isLiveTvMode) {
            val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
            val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
            val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
            val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""
            ensureLocalProgressTrackingStarted(phone, contentId, season, episode)
        }

        Log.i(TAG, "📱 Resuming playback locally on phone after casting at advanced position ${resumePosMs}ms")
        resumeLocalPlayerAfterCast(resumePosMs)
        Toast.makeText(
            this,
            "📱 Reanudando aquí en ${formatTime(resumePosMs)}",
            Toast.LENGTH_SHORT
        ).show()
    }

    /**
     * Releases local ExoPlayer decoders & heap buffers while casting so the Smart TV
     * gets 100% of Wi-Fi + TDLib bandwidth and the device reclaims ~32-64 MB of RAM immediately.
     */
    private fun parkLocalPlayerForCasting(positionMs: Long) {
        xrayController?.hideAllImmediate()
        player?.currentTracks?.let { snapshotExoTracksCatalog(it) }
        val dur = player?.duration ?: 0L
        if (dur > 0L && dur != C.TIME_UNSET) {
            lastKnownLocalDurationMs = dur
        }
        lastCastPositionMs = positionMs.coerceAtLeast(0L)
        releaseLocalExoPlayerAndTrimAllocator()
    }

    private fun resumeLocalPlayerAfterCast(resumePosMs: Long) {
        layoutCastStatusCard.visibility = View.GONE
        val url = localStreamServer?.let {
            if (it.listeningPort > 0) "http://127.0.0.1:${it.listeningPort}/stream" else null
        } ?: currentPlayUrl ?: return

        if (player == null) {
            initExoPlayer()
        }
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

        val reattachIntent = CastSessionCoordinator.buildReopenPlayerIntent(this)
        setIntent(reattachIntent)
        applySpecialPlaybackModesFromIntent(
            srcIntent = reattachIntent,
            phone = activeMedia.phone,
            contentId = activeMedia.contentId,
            season = activeMedia.season,
            episode = activeMedia.episode,
            title = currentTitle
        )
        setupUnifiedCastEngine()

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

        if (!isLiveTvMode) {
            ensureLocalProgressTrackingStarted(
                activeMedia.phone,
                activeMedia.contentId,
                activeMedia.season,
                activeMedia.episode
            )
        }
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
                    if (player == null) initExoPlayer()
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
            storedSevenZip = storedSevenZipArchive,
            isLiveTv = isLiveTvMode,
            isPremiereLocked = isPremiereSyncLocked,
            liveTvChannelId = liveTvChannelId,
            liveTvChannelLabel = liveTvChannelLabel,
            liveTvProgramTitle = liveTvProgramDisplayTitle,
            liveTvItemId = liveTvFichaItemId,
            liveTvTmdbId = liveTvFichaTmdbId,
            liveTvYear = liveTvFichaYear,
            liveTvMediaType = liveTvFichaMediaType,
            liveTvCleanTitle = liveTvFichaCleanTitle,
            liveTvPosterPath = liveTvFichaPosterPath,
            liveTvPayload = liveTvFichaPayload,
            liveTvRawItemJson = liveTvFichaRawJson,
            liveTvTunedAtMs = liveTvTunedAtEpochMs,
            liveTvBaseOffsetSec = liveTvBaseOffsetSec
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
        if (newIntent.getBooleanExtra(EXTRA_EXPAND_EXISTING_PIP, false)) {
            if (!isInPipModeCompat()) {
                showTitle(currentTitle)
                showControls()
            }
            updateSeekBar()
            return
        }
        val attachOnly = newIntent.getBooleanExtra(EXTRA_ATTACH_ACTIVE_CAST, false)
        val newFileId = newIntent.getIntExtra(EXTRA_FILE_ID, -1)
        val sameMultipart = newIntent.getStringExtra(EXTRA_MULTIPART_JSON).orEmpty() ==
            intent.getStringExtra(EXTRA_MULTIPART_JSON).orEmpty()
        val sameLiveMode = newIntent.getBooleanExtra(EXTRA_IS_LIVE_TV, false) == isLiveTvMode
        val sameLiveChannel = newIntent.getStringExtra(EXTRA_LIVE_TV_CHANNEL_ID).orEmpty() == liveTvChannelId
        if (shouldIgnoreDuplicateNewIntent(
                attachOnly = attachOnly,
                newFileId = newFileId,
                currentFileId = currentFileId,
                sameMultipart = sameMultipart,
                sameLiveMode = sameLiveMode,
                sameLiveChannel = sameLiveChannel,
                releasedWhileBackgrounded = releasedWhileBackgrounded,
                liveTvAutoAdvancePending = liveTvAutoAdvancePending,
                liveTvZapPending = liveTvZapPending
            )
        ) {
            if (!isInPipModeCompat()) {
                showControls()
            }
            updateSeekBar()
            return
        }
        if (isAnyCastActive()) {
            liveTvAutoAdvancePending = false
            liveTvZapPending = false
            backgroundReleaseHandler.removeCallbacks(liveTvAutoAdvanceTimeoutRunnable)
            backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
            isDetachingKeepCastAlive = true
            setIntent(newIntent)
            recreate()
            return
        }
        switchStreamInPlace(newIntent)
    }

    private fun switchStreamInPlace(newIntent: Intent) {
        liveTvAutoAdvancePending = false
        liveTvZapPending = false
        castEndedAndSynced = false
        val wasLiveTvSession = hadLiveTvSession
        backgroundReleaseHandler.removeCallbacks(liveTvAutoAdvanceTimeoutRunnable)
        backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
        val engine = TelegramEngine.getInstance(this)
        var newParts: List<FilePart>? = null
        var newStored7z = false
        val mpJson = newIntent.getStringExtra(EXTRA_MULTIPART_JSON)
        if (!mpJson.isNullOrEmpty()) {
            try {
                val arr = org.json.JSONArray(mpJson)
                val parsed = mutableListOf<FilePart>()
                var sum = 0L
                for (i in 0 until arr.length()) {
                    val obj = arr.getJSONObject(i)
                    val archive = obj.optString("archive", "")
                    require(archive == "" || archive == "7z-copy")
                    if (i == 0) newStored7z = archive == "7z-copy"
                    require(newStored7z == (archive == "7z-copy"))
                    val pid = obj.optInt("fileId", 0)
                    val psz = obj.getLong("size")
                    val pMsgId = obj.optLong("msgId", 0L)
                    require((pid > 0 || pMsgId != 0L) && psz > 0 && psz <= Long.MAX_VALUE - sum)
                    sum += psz
                    parsed.add(FilePart(pid, psz, pMsgId))
                }
                if (parsed.isNotEmpty()) newParts = parsed
            } catch (e: Exception) {
                Log.e(TAG, "switchStreamInPlace multipart parse error", e)
                return
            }
        }

        val initialNextFileId = newParts?.firstOrNull()?.fileId ?: newIntent.getIntExtra(EXTRA_FILE_ID, -1)
        val initialNextFileSize = newIntent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val chatId = newIntent.getLongExtra(EXTRA_CHAT_ID, 0L)
        val msgId = newIntent.getLongExtra(EXTRA_MSG_ID, 0L)

        // Cancel any previous in-flight resolution & tear down previous stream immediately
        streamStartupJob?.cancel()
        val prevFileId = currentFileId
        val prevParts = multipartParts
        val prevServer = localStreamServer
        localStreamServer = null

        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null
        try {
            player?.stop()
            player?.clearMediaItems()
            playerAllocator?.trim()
        } catch (_: Exception) {}
        try { prevServer?.stop() } catch (_: Exception) {}

        val prevIdsToPurge = mutableSetOf<Int>()
        if (prevFileId > 0 && prevFileId != initialNextFileId) {
            prevIdsToPurge.add(prevFileId)
        }
        prevParts?.forEach { part ->
            if (newParts?.any { it.fileId == part.fileId } != true && part.fileId != initialNextFileId && part.fileId > 0) {
                prevIdsToPurge.add(part.fileId)
            }
        }
        if (prevIdsToPurge.isNotEmpty()) {
            engine.releaseSpecificVideoFiles(prevIdsToPurge)
        }

        // Reset per-item state
        cachedAudioOptions = emptyList()
        cachedSubtitleOptions = emptyList()
        exoCurrentlySelectedAudioOrdinal = null
        exoCurrentlySelectedSubtitleOrdinal = null
        userSelectedAudioOrdinal = null
        userSelectedAudioTrackNum = null
        userSubtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
        userSelectedSubtitleOrdinal = null
        userSelectedSubtitleTrackNum = null
        lastKnownLocalPositionMs = 0L
        lastKnownLocalDurationMs = 0L
        introSkipped = false
        nextEpisodeTriggered = false
        hasRenderedLiveVideoFrame = false
        mutedPendingInitialLiveSeek = false
        releasedWhileBackgrounded = false
        ioErrorRetryCount = 0
        decoderErrorRetryCount = 0

        setIntent(newIntent)
        multipartParts = newParts
        storedSevenZipArchive = newStored7z
        currentFileId = initialNextFileId
        currentMimeType = newIntent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        currentTitle = newIntent.getStringExtra(EXTRA_TITLE) ?: ""

        val phone = newIntent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = newIntent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = newIntent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = newIntent.getStringExtra(EXTRA_EPISODE) ?: ""
        applySpecialPlaybackModesFromIntent(newIntent, phone, contentId, season, episode, currentTitle)
        if (wasLiveTvSession && !isLiveTvMode) {
            com.cineflix.android.MainActivity.stopLiveTvFromPlayer(reopenGrid = false, onlyIfNotTuning = true)
        }

        if (!isInPipModeCompat()) {
            loadingSpinner.visibility = View.VISIBLE
            showTitle(currentTitle)
            scheduleHideControls()
        } else {
            loadingSpinner.visibility = View.GONE
            hideControlsImmediateForPip()
        }

        val initialPartsSnapshot = newParts
        streamStartupJob = scope.launch {
            var resolvedParts = initialPartsSnapshot
            var nextFileId = initialNextFileId
            var nextFileSize = initialNextFileSize

            if (!resolvedParts.isNullOrEmpty()) {
                val validated = engine.ensureValidMultipartParts(resolvedParts, chatId)
                if (validated == null || validated.isEmpty()) {
                    withContext(Dispatchers.Main) {
                        if (!isFinishing && !isDestroyed) {
                            Toast.makeText(this@PlayerActivity, "Error: no se pudieron resolver las partes del vídeo", Toast.LENGTH_SHORT).show()
                        }
                    }
                    return@launch
                }
                resolvedParts = validated
                nextFileId = validated[0].fileId
            } else {
                val verified = engine.ensureValidFileId(nextFileId, chatId, msgId, nextFileSize)
                if (verified != null && verified.first > 0) {
                    nextFileId = verified.first
                    if (nextFileSize <= 0L && verified.second > 0L) {
                        nextFileSize = verified.second
                    }
                }
                if (nextFileId > 0 && nextFileSize <= 0L) {
                    val tdSize = engine.resolveFileSizeForFileId(nextFileId)
                    if (tdSize > 0L) nextFileSize = tdSize
                }
            }

            if (!isActive) return@launch
            if (nextFileId <= 0) {
                withContext(Dispatchers.Main) {
                    if (!isFinishing && !isDestroyed) {
                        Toast.makeText(this@PlayerActivity, "Error: fileId inválido ($nextFileId)", Toast.LENGTH_SHORT).show()
                    }
                }
                return@launch
            }

            withContext(Dispatchers.Main) {
                if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext

                multipartParts = resolvedParts
                currentFileId = nextFileId
                val effSize = if (nextFileSize > 0L) nextFileSize else 2_000_000_000L
                currentEffectiveFileSize = resolvedParts?.sumOf { it.size }?.takeIf { it > 0L } ?: effSize

                val ramBudget = StorageAndRamHygiene.resolvePlayerRamBudget(this@PlayerActivity)
                val lss = LocalStreamServer(engine, localPrefetchBufferBytes = ramBudget.localServerPrefetchBytes)
                val lssUrl = lss.start(
                    fileId = nextFileId,
                    totalSize = currentEffectiveFileSize,
                    mimeType = currentMimeType,
                    multipartParts = multipartParts,
                    storedSevenZip = storedSevenZipArchive,
                    archiveError = { message ->
                        runOnUiThread {
                            if (!isFinishing && !isDestroyed) {
                                Toast.makeText(this@PlayerActivity, message, Toast.LENGTH_LONG).show()
                                finish()
                            }
                        }
                    }
                )
                localStreamServer = lss
                currentPlayUrl = lssUrl
                val wifiIp = LanNetworkUtils.getBestLanIpv4(this@PlayerActivity)
                castStreamUrl = if (wifiIp != null && lss.listeningPort > 0) {
                    "http://$wifiIp:${lss.listeningPort}/stream/cast.mp4"
                } else {
                    null
                }
                val inspectedDurMs = withTimeoutOrNull(4_500L) {
                    withContext(Dispatchers.IO) { lss.inspectInitialDurationMs() }
                } ?: 0L
                if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext
                if (inspectedDurMs > 0L) {
                    lastKnownLocalDurationMs = inspectedDurMs
                    CastSessionCoordinator.updateKnownDurationMs(inspectedDurMs)
                }
                val updatedSz = lss.getEffectiveSizeBytes()
                if (updatedSz > currentEffectiveFileSize && multipartParts.isNullOrEmpty()) {
                    currentEffectiveFileSize = updatedSz
                }
                prewarmMatroskaTrackCatalog(lss)

                if (player == null) {
                    initExoPlayer()
                }

                val startSec = newIntent.getStringExtra(EXTRA_PROGRESS)?.toFloatOrNull()?.toInt() ?: 0
                var startMs = if (startSec > 2) startSec * 1000L else 0L
                if (isLiveTvMode && startMs > 0L && inspectedDurMs >= 300_000L) {
                    val sqz = liveTvSqueezeController
                    val effEndMs = sqz?.resolveEffectiveBroadcastEndMs(inspectedDurMs) ?: inspectedDurMs
                    if (startMs >= effEndMs - 3_000L) {
                        val eofKey = "$liveTvChannelId:$nextFileId"
                        if (lastPastEofAdvanceSlotKey != eofKey) {
                            lastPastEofAdvanceSlotKey = eofKey
                            val realDurSec = (inspectedDurMs / 1000L).toInt()
                            withTimeoutOrNull(1_800L) {
                                withContext(Dispatchers.IO) { sqz?.reportTimingBlockingIo(realDurSec) }
                            }
                            if (!isActive || isFinishing || isDestroyed || isCleanedUp) return@withContext
                            triggerLiveTvNextProgram()
                            return@withContext
                        } else {
                            startMs = (startMs % inspectedDurMs).coerceIn(0L, (effEndMs - 20_000L).coerceAtLeast(0L))
                        }
                    }
                }
                playUrl(lssUrl, startMs)
                if (!isLiveTvMode) {
                    ensureLocalProgressTrackingStarted(phone, contentId, season, episode)
                }
                if (isInPipModeCompat()) {
                    loadingSpinner.visibility = View.GONE
                    hideControlsImmediateForPip()
                }
            }
        }
    }

    private fun updateCastUiIndicators() {
        val active = isAnyCastActive()
        val iconRes = if (active) R.drawable.ic_cast_tv_connected else R.drawable.ic_cast_tv
        btnCastBottom.setImageResource(iconRes)
        if (active) {
            layoutCastStatusCard.visibility = View.VISIBLE
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
        isActivityPausedForLifecycle = false
        activePlayerRef = WeakReference(this)
        backgroundReleaseHandler.removeCallbacks(backgroundIdleReleaseRunnable)
        if (!isInPipModeCompat()) {
            hideSystemUI()
        }
        if (!StorageAndRamHygiene.isTelevision(this) || isAnyCastActive()) {
            unifiedTvDiscovery?.startActiveDiscovery(forceRefresh = false)
        }

        if (releasedWhileBackgrounded && !isAnyCastActive()) {
            releasedWhileBackgrounded = false
            rebuildStreamAfterBackgroundRelease()
            return
        }

        if (!isAnyCastActive() && !isReleasingOrRecoveringPlayer &&
            (player?.mediaItemCount ?: 0) > 0 &&
            (wasPlaying || isLivePauseLocked())
        ) {
            if (isLiveTvMode && liveTvTunedAtEpochMs > 0L &&
                player?.playbackState == Player.STATE_READY &&
                player?.isCurrentMediaItemSeekable == true
            ) {
                val elapsedSec = ((System.currentTimeMillis() - liveTvTunedAtEpochMs).coerceAtLeast(0L)) / 1000L
                val expectedMs = (liveTvBaseOffsetSec + elapsedSec) * 1000L
                val duration = getCurrentEffectiveDurationMs()
                val withinBounds = duration <= 0L || duration == C.TIME_UNSET || expectedMs < (duration - 5_000L)
                if (withinBounds && kotlin.math.abs(getCurrentEffectivePositionMs() - expectedMs) > 8_000L) {
                    player?.seekTo(expectedMs)
                }
            }
            player?.play()
        }
    }

    private fun rebuildStreamAfterBackgroundRelease() {
        if (currentFileId <= 0 && multipartParts.isNullOrEmpty()) {
            if (isLiveTvMode) {
                triggerLiveTvNextProgram()
            }
            return
        }
        val engine = TelegramEngine.getInstance(this)
        val useNodeJsProxy = intent.getBooleanExtra("USE_NODEJS_PROXY", false)
        val resumeUrl: String
        if (useNodeJsProxy) {
            resumeUrl = "http://127.0.0.1:3000/stream"
        } else {
            val ramBudget = StorageAndRamHygiene.resolvePlayerRamBudget(this)
            val lss = LocalStreamServer(engine, localPrefetchBufferBytes = ramBudget.localServerPrefetchBytes)
            val lssUrl = lss.start(
                fileId = currentFileId,
                totalSize = currentEffectiveFileSize,
                mimeType = currentMimeType,
                multipartParts = multipartParts,
                storedSevenZip = storedSevenZipArchive,
                archiveError = { message ->
                    runOnUiThread {
                        if (!isFinishing && !isDestroyed) {
                            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
                }
            )
            localStreamServer = lss
            prewarmMatroskaTrackCatalog(lss)
            val wifiIp = LanNetworkUtils.getBestLanIpv4(this)
            castStreamUrl = if (wifiIp != null && lss.listeningPort > 0) {
                "http://$wifiIp:${lss.listeningPort}/stream/cast.mp4"
            } else {
                null
            }
            resumeUrl = lssUrl
        }
        currentPlayUrl = resumeUrl
        if (player == null) {
            initExoPlayer()
        }
        val resumeMs = if (isLiveTvMode && liveTvTunedAtEpochMs > 0L) {
            val elapsedSec = ((System.currentTimeMillis() - liveTvTunedAtEpochMs).coerceAtLeast(0L)) / 1000L
            (liveTvBaseOffsetSec + elapsedSec) * 1000L
        } else {
            savedPosition.coerceAtLeast(0L)
        }
        playUrl(resumeUrl, resumeMs)
        if (!wasPlaying && !isPremiereSyncLocked && !isLiveTvMode) {
            player?.pause()
        }
    }

    private fun releaseHeavyResourcesWhileBackgrounded() {
        if (releasedWhileBackgrounded || isCleanedUp || isFinishing || isDestroyed) return
        if (isAnyCastActive() || isInPipModeCompat()) return

        Log.i(TAG, "🧹 Reclaiming ExoPlayer + LocalStreamServer + TDLib cache while PlayerActivity is idle in background")
        liveTvAutoAdvancePending = false
        liveTvZapPending = false
        backgroundReleaseHandler.removeCallbacks(liveTvAutoAdvanceTimeoutRunnable)
        backgroundReleaseHandler.removeCallbacks(liveTvZapTimeoutRunnable)
        streamStartupJob?.cancel()
        streamStartupJob = null
        savedPosition = getCurrentEffectivePositionMs()
        xrayController?.trimMemory(isUiHidden = true)
        unifiedTvDiscovery?.stopActiveDiscovery()
        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null

        releaseLocalExoPlayerAndTrimAllocator()

        val ownedServer = localStreamServer
        localStreamServer = null
        try { ownedServer?.stop() } catch (_: Exception) {}

        val engine = TelegramEngine.getInstance(this)
        val idsToPurge = buildSet {
            if (currentFileId > 0) add(currentFileId)
            multipartParts?.forEach { if (it.fileId > 0) add(it.fileId) }
        }
        engine.purgeAllStreamingCaches(idsToPurge)
        val appCacheDir = applicationContext.cacheDir
        StorageAndRamHygiene.launchBackgroundHygiene {
            StorageAndRamHygiene.cleanEphemeralCacheArtifacts(appCacheDir)
        }
        MainActivity.trimWebViewMemoryFromBackgroundIfIdle()
        releasedWhileBackgrounded = true
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        try { playerAllocator?.trim() } catch (_: Exception) {}
        val isUiHidden = !lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)
        if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW) {
            xrayController?.trimMemory(isUiHidden = isUiHidden)
        }
        if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN &&
            !lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) &&
            !isAnyCastActive() &&
            !isInPipModeCompat() &&
            !isFinishing
        ) {
            backgroundReleaseHandler.removeCallbacks(backgroundIdleReleaseRunnable)
            releaseHeavyResourcesWhileBackgrounded()
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
        if (isInPipModeCompat() || (isLiveTvMode && android.os.SystemClock.elapsedRealtime() < enteringPipUntilElapsedMs)) {
            // Keep Live TV playing smoothly inside (or while entering) the floating Picture-in-Picture window!
            return
        }
        isActivityPausedForLifecycle = true
        wasPlaying = player?.isPlaying == true
        if (wasPlaying) {
            player?.pause()
        }
        // Flush watch progress immediately so Android TV Home/Standby never loses progress
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: ""
        val contentId = intent.getStringExtra(EXTRA_CONTENT_ID) ?: ""
        val season = intent.getStringExtra(EXTRA_SEASON) ?: ""
        val episode = intent.getStringExtra(EXTRA_EPISODE) ?: ""
        val pos = getCurrentEffectivePositionMs()
        val dur = getCurrentEffectiveDurationMs()
        if (!isLiveTvMode && !hadLiveTvSession && !castEndedAndSynced && phone.isNotEmpty() && contentId.isNotEmpty() && pos > 0L) {
            scope.launch {
                sendProgressPingDirect(phone, contentId, season, episode, pos, dur)
            }
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
        backgroundReleaseHandler.removeCallbacks(backgroundIdleReleaseRunnable)
        if (!isInPipModeCompat() && !isAnyCastActive()) {
            unifiedTvDiscovery?.stopActiveDiscovery()
        }
        if (isFinishing) {
            cleanup()
        } else if (!isAnyCastActive() && !isInPipModeCompat()) {
            backgroundReleaseHandler.postDelayed(backgroundIdleReleaseRunnable, BACKGROUND_IDLE_RELEASE_MS)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        backgroundReleaseHandler.removeCallbacksAndMessages(null)
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
        val wasLiveSession = hadLiveTvSession
        liveTvAutoAdvancePending = false
        liveTvZapPending = false
        streamStartupJob?.cancel()
        streamStartupJob = null
        backgroundReleaseHandler.removeCallbacksAndMessages(null)
        titleHandler.removeCallbacksAndMessages(null)
        controlsHandler.removeCallbacksAndMessages(null)
        seekBarHandler.removeCallbacksAndMessages(null)
        seekDebounceHandler.removeCallbacksAndMessages(null)
        pendingSeekTargetMs = null

        val newerActivePlayer = activePlayerRef?.get()?.takeIf {
            it !== this && !it.isFinishing && !it.isDestroyed
        }
        if (activePlayerRef?.get() === this) {
            activePlayerRef = null
        }

        if (wasLiveSession && newerActivePlayer == null && !isChangingConfigurations && !isDetachingKeepCastAlive) {
            hadLiveTvSession = false
            com.cineflix.android.MainActivity.stopLiveTvFromPlayer(reopenGrid = false, onlyIfNotTuning = true)
        }

        try { liveTvSqueezeController?.destroy() } catch (_: Exception) {}
        liveTvSqueezeController = null

        try { xrayController?.destroy() } catch (_: Exception) {}
        xrayController = null

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

        releaseLocalExoPlayerAndTrimAllocator()
        cachedAudioOptions = emptyList()
        cachedSubtitleOptions = emptyList()

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
        if (CastSessionCoordinator.isCastingActive && newerActivePlayer == null) {
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

        val engine = TelegramEngine.getInstance(this)
        val fileId = currentFileId.takeIf { it > 0 } ?: intent.getIntExtra(EXTRA_FILE_ID, -1)
        val idsToPurge = buildSet {
            if (fileId > 0) add(fileId)
            multipartParts?.forEach { if (it.fileId > 0) add(it.fileId) }
        }
        if (newerActivePlayer != null) {
            val activeIds = buildSet {
                if (newerActivePlayer.currentFileId > 0) add(newerActivePlayer.currentFileId)
                newerActivePlayer.multipartParts?.forEach { if (it.fileId > 0) add(it.fileId) }
            }
            val safeUnusedIds = idsToPurge - activeIds
            if (safeUnusedIds.isNotEmpty()) {
                engine.releaseSpecificVideoFiles(safeUnusedIds)
            }
        } else {
            com.cineflix.android.GramJSStreamManager.currentPlaybackId = ""
            engine.purgeAllStreamingCaches(idsToPurge)
            val appCacheDir = applicationContext.cacheDir
            StorageAndRamHygiene.launchBackgroundHygiene {
                StorageAndRamHygiene.cleanEphemeralCacheArtifacts(appCacheDir)
            }
        }

        if (!isLiveTvMode && !wasLiveSession && !castEndedAndSynced && phone.isNotEmpty() && contentId.isNotEmpty() && finalPosition > 0) {
            StorageAndRamHygiene.launchBackgroundHygiene {
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
            var conn: java.net.HttpURLConnection? = null
            try {
                conn = StorageAndRamHygiene.openCompatUrlConnection("https://cineflixapp.duckdns.org/api/progress")
                conn.requestMethod = "POST"
                conn.connectTimeout = 5000
                conn.readTimeout = 5000
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
            } catch (e: Exception) {
                android.util.Log.e("PROGRESS", "POST error", e)
            } finally {
                try { conn?.disconnect() } catch (_: Exception) {}
            }
        }
    }

    private suspend fun fetchSavedProgress(phone: String, contentId: String, season: String, episode: String): Int {
        return withContext(Dispatchers.IO) {
            var conn: java.net.HttpURLConnection? = null
            try {
                conn = StorageAndRamHygiene.openCompatUrlConnection("https://cineflixapp.duckdns.org/api/progress")
                conn.requestMethod = "GET"
                conn.setRequestProperty("x-user-phone", phone)
                conn.connectTimeout = 5000
                conn.readTimeout = 5000

                val responseCode = conn.responseCode
                if (responseCode == 200) {
                    val body = conn.inputStream.bufferedReader().use { it.readText() }
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
            } finally {
                try { conn?.disconnect() } catch (_: Exception) {}
            }
        }
    }
}
