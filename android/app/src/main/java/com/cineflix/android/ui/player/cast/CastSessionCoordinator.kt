package com.cineflix.android.ui.player.cast

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.util.Log
import androidx.mediarouter.media.MediaRouter
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.player.FilePart
import com.cineflix.android.ui.player.LocalStreamServer
import com.cineflix.android.ui.player.PlayerActivity
import com.cineflix.android.util.StorageAndRamHygiene
import com.google.android.gms.cast.MediaStatus
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import kotlinx.coroutines.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.util.concurrent.CopyOnWriteArraySet

/**
 * Process-wide coordinator that owns the active Smart TV / Chromecast session, `LocalStreamServer`,
 * `WakeLock`/`WifiLock`, and cloud `/api/progress` synchronization so casting continues seamlessly
 * inside [CastPlaybackService] (`ForegroundService`) when the user:
 *  - Switches to other Android apps or turns off the phone screen,
 *  - Navigates back to `MainActivity` to browse the Cineflix catalog, or
 *  - Picks another movie from the catalog to replace what is playing on the TV.
 */
object CastSessionCoordinator {

    private const val TAG = "CastSessionCoordinator"

    enum class CastMode {
        NONE,
        DLNA,
        GOOGLE_CAST
    }

    data class CastMediaMetadata(
        val fileId: Int,
        val multipartParts: List<FilePart>?,
        val multipartJson: String?,
        val fileSize: Long,
        val mimeType: String,
        val title: String,
        val chatId: Long,
        val msgId: Long,
        val phone: String,
        val contentId: String,
        val season: String,
        val episode: String,
        val creditsStart: String,
        val introStartMs: String,
        val introEndMs: String,
        val introDbCreditsMs: String,
        val storedSevenZip: Boolean,
        val isLiveTv: Boolean = false,
        val isPremiereLocked: Boolean = false,
        val liveTvChannelId: String = "",
        val liveTvChannelLabel: String = "",
        val liveTvProgramTitle: String = "",
        val liveTvItemId: String = "",
        val liveTvTmdbId: Int = 0,
        val liveTvYear: String = "",
        val liveTvMediaType: String = "movie",
        val liveTvCleanTitle: String = "",
        val liveTvPosterPath: String = "",
        val liveTvPayload: String = "",
        val liveTvRawItemJson: String = "",
        val liveTvTunedAtMs: Long = 0L,
        val liveTvBaseOffsetSec: Long = 0L
    ) {
        val isLiveBroadcastLocked: Boolean
            get() = isLiveTv || isPremiereLocked
    }

    data class CastTrackOption(
        val ordinal: Int,
        val matroskaTrackNumber: Int?,
        val name: String,
        val badge: String,
        val isDefault: Boolean,
        val isForced: Boolean,
        val isDtsOrTrueHd: Boolean = false,
        val requiresAudioTranscode: Boolean = false,
        val isImageSubtitle: Boolean = false,
        val codecShort: String = ""
    )

    data class SavedTrackSelectionState(
        val audioOptions: List<CastTrackOption> = emptyList(),
        val subtitleOptions: List<CastTrackOption> = emptyList(),
        val exoAudioOrdinal: Int? = null,
        val exoSubtitleOrdinal: Int? = null,
        val userAudioOrdinal: Int? = null,
        val userAudioTrackNum: Int? = null,
        val lastWorkingAudioOrdinal: Int? = null,
        val lastWorkingAudioTrackNum: Int? = null,
        val userSubtitleMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode =
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL,
        val userSubtitleOrdinal: Int? = null,
        val userSubtitleTrackNum: Int? = null
    )

    data class CastUiSnapshot(
        val isActive: Boolean,
        val mode: CastMode,
        val tvName: String,
        val deviceId: String?,
        val movieTitle: String,
        val subtitleText: String,
        val isConnecting: Boolean,
        val isPlaying: Boolean,
        val isLiveTranscode: Boolean,
        val positionMs: Long,
        val durationMs: Long,
        val isLiveTv: Boolean = false
    )

    sealed class AutoContinueCastTarget {
        data class Dlna(val device: DlnaDevice, val deviceId: String) : AutoContinueCastTarget()
        data class GoogleCast(val tvName: String, val deviceId: String?) : AutoContinueCastTarget()
    }

    interface StateObserver {
        fun onCastStateChanged(snapshot: CastUiSnapshot)
    }

    interface PlayerUiListener {
        fun onDlnaConnecting(device: DlnaDevice)
        fun onDlnaPlaybackStarted(device: DlnaDevice)
        fun onDlnaProgressUpdated(device: DlnaDevice, positionMs: Long, durationMs: Long, isPlaying: Boolean)
        fun onDlnaPlaybackEndedNaturally(device: DlnaDevice, finalPositionMs: Long, durationMs: Long)
        fun onDlnaError(device: DlnaDevice, message: String)
        fun onDlnaTrackReloadFailed(device: DlnaDevice)
        fun onGoogleCastNaturalEnd()
        fun onExternalCastStopped()
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "Unhandled coroutine exception in CastSessionCoordinator", throwable)
    }
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob() + coroutineExceptionHandler)
    private val stateObservers = CopyOnWriteArraySet<StateObserver>()

    val dlnaController = DlnaCastController()

    @Volatile var appContext: Context? = null
        private set

    @Volatile var playerUiListener: PlayerUiListener? = null

    @Volatile var activeStreamServer: LocalStreamServer? = null
        private set

    @Volatile var activeMedia: CastMediaMetadata? = null
        private set

    @Volatile private var savedTrackState: SavedTrackSelectionState = SavedTrackSelectionState()

    @Volatile var castMode: CastMode = CastMode.NONE
        private set

    @Volatile var activeDlnaDevice: DlnaDevice? = null
        private set

    @Volatile var activeCastDeviceId: String? = null
        private set

    @Volatile var activeCastTvName: String = ""
        private set

    @Volatile var statusSubtitle: String = ""
        private set

    @Volatile var isConnecting: Boolean = false
        private set

    @Volatile var isPlaying: Boolean = false
        private set

    @Volatile var currentPositionMs: Long = 0L
        private set

    @Volatile var durationMs: Long = 0L
        private set

    // Google Cast accurate position & wall-clock fallback tracking
    @Volatile private var googleCastAnchorPosMs: Long = 0L
    @Volatile private var googleCastLastTickWallMs: Long = 0L
    @Volatile private var lastGoogleCastSeekAtMs: Long = 0L
    @Volatile private var castStartedAtWallMs: Long = 0L
    @Volatile private var attachedRmc: RemoteMediaClient? = null
    private val rmcProgressListener = RemoteMediaClient.ProgressListener { progressMs, streamDurMs ->
        if (castMode != CastMode.GOOGLE_CAST) return@ProgressListener
        val now = System.currentTimeMillis()
        if (streamDurMs > 0L) {
            durationMs = streamDurMs
        }
        val seekSettle = lastGoogleCastSeekAtMs > 0L && (now - lastGoogleCastSeekAtMs) < 3500L
        if (progressMs > 0L) {
            val isStalePreSeek = seekSettle &&
                progressMs < googleCastAnchorPosMs &&
                (googleCastAnchorPosMs - progressMs) > 15_000L
            if (!isStalePreSeek) {
                currentPositionMs = progressMs
                googleCastAnchorPosMs = progressMs
                googleCastLastTickWallMs = now
            }
        }
    }

    private var tickerJob: Job? = null
    private var progressSyncJob: Job? = null
    private var castWakeLock: PowerManager.WakeLock? = null
    private var castWifiLock: WifiManager.WifiLock? = null

    val isCastingActive: Boolean
        get() = castMode != CastMode.NONE

    val isDlnaCasting: Boolean
        get() = castMode == CastMode.DLNA

    val isGoogleCasting: Boolean
        get() = castMode == CastMode.GOOGLE_CAST

    init {
        dlnaController.remoteStreamActiveProvider = {
            activeStreamServer?.isRemoteClientActivelyStreaming() == true
        }
        dlnaController.listener = object : DlnaCastController.Listener {
            override fun onConnecting(device: DlnaDevice) {
                if (castMode != CastMode.DLNA) return
                activeDlnaDevice = device
                activeCastTvName = device.friendlyName
                isConnecting = true
                isPlaying = false
                statusSubtitle = "Conectando con ${device.friendlyName}..."
                broadcastSnapshot()
                playerUiListener?.onDlnaConnecting(device)
            }

            override fun onPlaybackStarted(device: DlnaDevice) {
                if (castMode != CastMode.DLNA) return
                activeDlnaDevice = device
                activeCastTvName = device.friendlyName
                isConnecting = false
                isPlaying = true
                statusSubtitle = if (dlnaController.isCurrentSessionLiveTranscode) {
                    "Decodificando en el móvil • ${device.friendlyName}"
                } else {
                    device.brandBadge
                }
                broadcastSnapshot()
                playerUiListener?.onDlnaPlaybackStarted(device)
            }

            override fun onProgressUpdated(
                device: DlnaDevice,
                positionMs: Long,
                durationMs: Long,
                isPlaying: Boolean
            ) {
                if (castMode != CastMode.DLNA) return
                this@CastSessionCoordinator.currentPositionMs = positionMs.coerceAtLeast(0L)
                if (durationMs > 0L) {
                    this@CastSessionCoordinator.durationMs = durationMs
                }
                this@CastSessionCoordinator.isConnecting = false
                this@CastSessionCoordinator.isPlaying = isPlaying
                val modeLabel = if (dlnaController.isCurrentSessionLiveTranscode) {
                    "Decodificando en el móvil"
                } else {
                    device.brandBadge
                }
                statusSubtitle = if (isPlaying) {
                    "Reproduciendo • $modeLabel"
                } else {
                    "En pausa • $modeLabel"
                }
                broadcastSnapshot()
                playerUiListener?.onDlnaProgressUpdated(device, positionMs, this@CastSessionCoordinator.durationMs, isPlaying)
            }

            override fun onPlaybackEndedNaturally(
                device: DlnaDevice,
                finalPositionMs: Long,
                durationMs: Long
            ) {
                if (castMode != CastMode.DLNA) return
                currentPositionMs = finalPositionMs.coerceAtLeast(currentPositionMs)
                if (durationMs > 0L) {
                    this@CastSessionCoordinator.durationMs = durationMs
                }
                val resolvedDur = this@CastSessionCoordinator.durationMs
                val ui = playerUiListener
                val ctx = appContext
                if (ctx != null) {
                    stopCastingCompletely(ctx, markFinished = true, notifyAttachedPlayerToClose = false)
                } else {
                    val srv = activeStreamServer
                    activeStreamServer = null
                    activeMedia = null
                    savedTrackState = SavedTrackSelectionState()
                    castMode = CastMode.NONE
                    activeDlnaDevice = null
                    activeCastDeviceId = null
                    activeCastTvName = ""
                    isConnecting = false
                    isPlaying = false
                    stopBackgroundJobsAndService()
                    broadcastSnapshot()
                    scope.launch { runCatching { srv?.stop() } }
                }
                ui?.onDlnaPlaybackEndedNaturally(device, finalPositionMs, resolvedDur)
            }

            override fun onPlaybackStopped(device: DlnaDevice, lastPositionMs: Long) {
                // Handled explicitly by detachCastToLocalPlayback / stopCastingCompletely / TV switch
            }

            override fun onError(device: DlnaDevice, message: String) {
                if (castMode != CastMode.DLNA) return
                activeStreamServer?.stopLiveTranscode()
                val ui = playerUiListener
                if (ui != null) {
                    val resumeAt = getEffectivePositionMs(appContext)
                    currentPositionMs = resumeAt
                    castMode = CastMode.NONE
                    activeDlnaDevice = null
                    activeCastDeviceId = null
                    activeCastTvName = ""
                    isConnecting = false
                    isPlaying = false
                    // Keep activeStreamServer intact so PlayerActivity resumes locally
                    activeStreamServer = null
                    activeMedia = null
                    stopBackgroundJobsAndService()
                    broadcastSnapshot()
                    ui.onDlnaError(device, message)
                } else {
                    Log.e(TAG, "DLNA error while PlayerActivity detached: $message")
                    appContext?.let { ctx ->
                        stopCastingCompletely(ctx, markFinished = false, notifyAttachedPlayerToClose = false)
                    }
                }
            }

            override fun onTrackReloadFailed(device: DlnaDevice) {
                if (castMode != CastMode.DLNA) return
                playerUiListener?.onDlnaTrackReloadFailed(device)
            }
        }
    }

    fun addStateObserver(observer: StateObserver) {
        stateObservers.add(observer)
        observer.onCastStateChanged(getSnapshot())
    }

    fun removeStateObserver(observer: StateObserver) {
        stateObservers.remove(observer)
    }

    fun getSnapshot(): CastUiSnapshot {
        val active = isCastingActive
        val media = activeMedia
        val liveTitle = if (media?.isLiveBroadcastLocked == true && media.liveTvProgramTitle.isNotBlank()) {
            media.liveTvProgramTitle
        } else {
            media?.title?.ifBlank { "Cineflix" } ?: "Cineflix"
        }
        return CastUiSnapshot(
            isActive = active,
            mode = castMode,
            tvName = activeCastTvName,
            deviceId = activeCastDeviceId,
            movieTitle = liveTitle,
            subtitleText = statusSubtitle,
            isConnecting = isConnecting,
            isPlaying = isPlaying,
            isLiveTranscode = castMode == CastMode.DLNA && dlnaController.isCurrentSessionLiveTranscode,
            positionMs = if (active) getEffectivePositionMs(appContext) else 0L,
            durationMs = if (active) getEffectiveDurationMs(appContext) else 0L,
            isLiveTv = active && (media?.isLiveBroadcastLocked == true)
        )
    }

    private fun broadcastSnapshot() {
        mainHandler.post {
            val snap = getSnapshot()
            for (obs in stateObservers) {
                try {
                    obs.onCastStateChanged(snap)
                } catch (_: Throwable) {}
            }
        }
    }

    fun isSameActiveMedia(fileId: Int, multipartParts: List<FilePart>?): Boolean {
        if (!isCastingActive) return false
        val media = activeMedia ?: return false
        val server = activeStreamServer ?: return false
        if (server.listeningPort <= 0) return false
        if (!multipartParts.isNullOrEmpty() && !media.multipartParts.isNullOrEmpty()) {
            return multipartParts.map { it.fileId } == media.multipartParts.map { it.fileId }
        }
        return fileId > 0 && media.fileId == fileId
    }

    fun updateSavedTrackState(state: SavedTrackSelectionState) {
        savedTrackState = state
    }

    fun getSavedTrackState(): SavedTrackSelectionState = savedTrackState

    fun updateKnownDurationMs(durMs: Long) {
        if (durMs > 0L) {
            durationMs = durMs
            dlnaController.updateKnownDurationMs(durMs)
            activeStreamServer?.updateKnownDurationMs(durMs)
            broadcastSnapshot()
        }
    }

    private fun bindStreamServerCallbacks(streamServer: LocalStreamServer) {
        streamServer.onDurationDiscovered = { discoveredMs ->
            if (discoveredMs > 0L) {
                durationMs = discoveredMs
                dlnaController.updateKnownDurationMs(discoveredMs)
                broadcastSnapshot()
            }
        }
        streamServer.onRemoteTvLiveSeek = { targetMovieMs ->
            if (castMode == CastMode.DLNA) {
                dlnaController.onTvInitiatedLiveSeek(targetMovieMs)
                currentPositionMs = targetMovieMs.coerceAtLeast(0L)
                broadcastSnapshot()
            }
        }
        val serverDur = streamServer.getKnownDurationMs()
        if (serverDur > 0L) {
            durationMs = serverDur
            dlnaController.updateKnownDurationMs(serverDur)
        }
    }

    fun beginDlnaCastSession(
        context: Context,
        streamServer: LocalStreamServer,
        media: CastMediaMetadata,
        trackState: SavedTrackSelectionState,
        device: DlnaDevice,
        deviceId: String,
        startPosMs: Long,
        knownDurationMs: Long
    ) {
        val appCtx = context.applicationContext
        appContext = appCtx
        detachRemoteMediaClientProgressListener()

        activeStreamServer = streamServer
        activeMedia = media
        savedTrackState = trackState
        castMode = CastMode.DLNA
        activeDlnaDevice = device
        activeCastDeviceId = deviceId
        activeCastTvName = device.friendlyName
        currentPositionMs = startPosMs.coerceAtLeast(0L)
        val effectiveDur = if (knownDurationMs > 0L) knownDurationMs else streamServer.getKnownDurationMs()
        durationMs = effectiveDur.coerceAtLeast(0L)
        if (effectiveDur > 0L) {
            dlnaController.updateKnownDurationMs(effectiveDur)
            streamServer.updateKnownDurationMs(effectiveDur)
        }
        bindStreamServerCallbacks(streamServer)
        isConnecting = true
        isPlaying = false
        castStartedAtWallMs = System.currentTimeMillis()
        statusSubtitle = "Conectando con ${device.friendlyName}..."

        acquireCastLocks(appCtx)
        startBackgroundTickerAndProgressSync(appCtx)
        CastPlaybackService.startOrUpdate(appCtx)
        broadcastSnapshot()
    }

    fun beginGoogleCastConnecting(
        context: Context,
        streamServer: LocalStreamServer,
        media: CastMediaMetadata,
        trackState: SavedTrackSelectionState,
        tvName: String,
        deviceId: String?,
        startPosMs: Long,
        knownDurationMs: Long
    ) {
        val appCtx = context.applicationContext
        appContext = appCtx
        val safeStart = startPosMs.coerceAtLeast(0L)

        activeStreamServer = streamServer
        activeMedia = media
        savedTrackState = trackState
        castMode = CastMode.GOOGLE_CAST
        activeDlnaDevice = null
        activeCastDeviceId = deviceId
        activeCastTvName = tvName.ifBlank { "Google Cast TV" }
        currentPositionMs = safeStart
        googleCastAnchorPosMs = safeStart
        googleCastLastTickWallMs = System.currentTimeMillis()
        lastGoogleCastSeekAtMs = 0L
        val effectiveDur = if (knownDurationMs > 0L) knownDurationMs else streamServer.getKnownDurationMs()
        durationMs = effectiveDur.coerceAtLeast(0L)
        if (effectiveDur > 0L) {
            streamServer.updateKnownDurationMs(effectiveDur)
        }
        bindStreamServerCallbacks(streamServer)
        isConnecting = true
        isPlaying = false
        castStartedAtWallMs = System.currentTimeMillis()
        statusSubtitle = "Iniciando Google Cast..."

        acquireCastLocks(appCtx)
        startBackgroundTickerAndProgressSync(appCtx)
        CastPlaybackService.startOrUpdate(appCtx)
        broadcastSnapshot()
    }

    fun attachGoogleCastMediaLoaded(
        context: Context,
        session: CastSession,
        startPosMs: Long,
        knownDurationMs: Long
    ) {
        val appCtx = context.applicationContext
        appContext = appCtx
        val safeStart = startPosMs.coerceAtLeast(0L)
        castMode = CastMode.GOOGLE_CAST
        activeDlnaDevice = null
        activeCastTvName = session.castDevice?.friendlyName?.ifBlank { null }
            ?: activeCastTvName.ifBlank { "Chromecast / Android TV" }
        activeCastDeviceId = session.castDevice?.deviceId?.let { "cast_dev:$it" } ?: activeCastDeviceId
        currentPositionMs = safeStart
        googleCastAnchorPosMs = safeStart
        googleCastLastTickWallMs = System.currentTimeMillis()
        lastGoogleCastSeekAtMs = System.currentTimeMillis()
        if (knownDurationMs > 0L) {
            durationMs = maxOf(durationMs, knownDurationMs)
        }
        isConnecting = false
        isPlaying = true
        statusSubtitle = "Reproduciendo por Google Cast"

        detachRemoteMediaClientProgressListener()
        session.remoteMediaClient?.let { rmc ->
            attachedRmc = rmc
            try {
                rmc.addProgressListener(rmcProgressListener, 1000L)
            } catch (_: Throwable) {}
        }

        acquireCastLocks(appCtx)
        startBackgroundTickerAndProgressSync(appCtx)
        CastPlaybackService.startOrUpdate(appCtx)
        broadcastSnapshot()
    }

    fun notifyGoogleCastSeek(targetMs: Long) {
        val safe = targetMs.coerceAtLeast(0L)
        val now = System.currentTimeMillis()
        currentPositionMs = safe
        googleCastAnchorPosMs = safe
        googleCastLastTickWallMs = now
        lastGoogleCastSeekAtMs = now
        broadcastSnapshot()
    }

    fun notifyDlnaSeek(targetMs: Long) {
        val safe = targetMs.coerceAtLeast(0L)
        currentPositionMs = safe
        dlnaController.notifyPendingSeek(safe)
        broadcastSnapshot()
    }

    private fun detachRemoteMediaClientProgressListener() {
        val prev = attachedRmc
        attachedRmc = null
        if (prev != null) {
            mainHandler.post {
                try {
                    prev.removeProgressListener(rmcProgressListener)
                } catch (_: Throwable) {}
            }
        }
    }

    fun getEffectivePositionMs(context: Context? = appContext): Long {
        return when (castMode) {
            CastMode.DLNA -> {
                val pos = dlnaController.getAccuratePositionMs()
                currentPositionMs = pos
                pos
            }
            CastMode.GOOGLE_CAST -> {
                val now = System.currentTimeMillis()
                val seekSettle = lastGoogleCastSeekAtMs > 0L && (now - lastGoogleCastSeekAtMs) < 3500L
                val rmc = getGoogleCastRemoteMediaClient(context)
                val approx = if (rmc != null) {
                    try {
                        if (rmc.mediaStatus != null) rmc.approximateStreamPosition else -1L
                    } catch (_: Throwable) {
                        -1L
                    }
                } else {
                    -1L
                }
                val rmcPlaying = if (rmc != null) {
                    try {
                        rmc.isPlaying
                    } catch (_: Throwable) {
                        isPlaying
                    }
                } else {
                    isPlaying
                }

                if (approx > 0L) {
                    val isStalePreSeek = seekSettle &&
                        approx < googleCastAnchorPosMs &&
                        (googleCastAnchorPosMs - approx) > 15_000L
                    if (!isStalePreSeek) {
                        currentPositionMs = approx
                        googleCastAnchorPosMs = approx
                        googleCastLastTickWallMs = now
                    }
                } else if (rmcPlaying && !seekSettle && googleCastLastTickWallMs > 0L) {
                    val delta = (now - googleCastLastTickWallMs).coerceIn(0L, 3000L)
                    if (delta > 0L) {
                        googleCastAnchorPosMs += delta
                        googleCastLastTickWallMs = now
                        val dur = durationMs
                        currentPositionMs = if (dur > 0L) {
                            googleCastAnchorPosMs.coerceAtMost(dur)
                        } else {
                            googleCastAnchorPosMs
                        }
                    }
                }
                currentPositionMs.coerceAtLeast(0L)
            }
            CastMode.NONE -> currentPositionMs.coerceAtLeast(0L)
        }
    }

    fun getEffectiveDurationMs(context: Context? = appContext): Long {
        return when (castMode) {
            CastMode.DLNA -> {
                val d = dlnaController.currentDurationMs
                if (d > 0L) {
                    durationMs = d
                    d
                } else {
                    durationMs
                }
            }
            CastMode.GOOGLE_CAST -> {
                val rmc = getGoogleCastRemoteMediaClient(context)
                val d = if (rmc != null) {
                    try {
                        rmc.streamDuration
                    } catch (_: Throwable) {
                        0L
                    }
                } else {
                    0L
                }
                if (d > 0L) {
                    durationMs = d
                    d
                } else {
                    durationMs
                }
            }
            CastMode.NONE -> durationMs
        }
    }

    private fun getGoogleCastRemoteMediaClient(context: Context?): RemoteMediaClient? {
        // RemoteMediaClient methods (getMediaStatus, getApproximateStreamPosition, isPlaying, getStreamDuration)
        // strictly enforce Preconditions.checkMainThread("Must be called from the main thread.").
        // Never return a RemoteMediaClient instance to a non-main thread!
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return null
        }
        val ctx = context ?: appContext ?: return attachedRmc
        return try {
            CastContext.getSharedInstance(ctx).sessionManager.currentCastSession?.remoteMediaClient ?: attachedRmc
        } catch (_: Throwable) {
            attachedRmc
        }
    }

    fun togglePlayPause(context: Context) {
        mainHandler.post {
            val media = activeMedia
            if (media?.isLiveBroadcastLocked == true) {
                val msg = if (media.isPremiereLocked) {
                    "🔒 El Peliculón en directo: reproducción sincronizada para todos"
                } else {
                    "📺 Emisión en directo: no se puede pausar"
                }
                android.widget.Toast.makeText(context.applicationContext, msg, android.widget.Toast.LENGTH_SHORT).show()
                when (castMode) {
                    CastMode.DLNA -> {
                        if (!isPlaying) dlnaController.resume()
                    }
                    CastMode.GOOGLE_CAST -> {
                        val rmc = getGoogleCastRemoteMediaClient(context)
                        if (rmc != null && rmc.isPaused) {
                            try { rmc.play() } catch (_: Throwable) {}
                        }
                    }
                    CastMode.NONE -> {}
                }
                return@post
            }
            when (castMode) {
                CastMode.DLNA -> {
                    dlnaController.togglePlayPause()
                }
                CastMode.GOOGLE_CAST -> {
                    val rmc = getGoogleCastRemoteMediaClient(context)
                    if (rmc != null) {
                        // Snapshot accurate position right before toggling playback
                        getEffectivePositionMs(context)
                        googleCastLastTickWallMs = System.currentTimeMillis()
                        rmc.togglePlayback()
                        isPlaying = !isPlaying
                        broadcastSnapshot()
                    }
                }
                CastMode.NONE -> {}
            }
        }
    }

    /**
     * Used when the user taps "📱 Ver aquí": captures the latest advanced TV position, stops TV playback
     * and [CastPlaybackService], and returns `(LocalStreamServer, resumePositionMs)` back to `PlayerActivity`
     * so phone playback resumes immediately at the exact advanced timestamp without re-downloading.
     */
    fun detachCastToLocalPlayback(context: Context): Pair<LocalStreamServer?, Long> {
        val appCtx = context.applicationContext
        val server = activeStreamServer
        val media = activeMedia
        val resumePos = getEffectivePositionMs(appCtx)
        val dur = getEffectiveDurationMs(appCtx)

        if (castMode == CastMode.DLNA) {
            dlnaController.stopSession(notifyListener = false)
            server?.stopLiveTranscode()
        } else if (castMode == CastMode.GOOGLE_CAST) {
            detachRemoteMediaClientProgressListener()
            try {
                CastContext.getSharedInstance(appCtx).sessionManager.endCurrentSession(true)
                MediaRouter.getInstance(appCtx).unselect(MediaRouter.UNSELECT_REASON_STOPPED)
            } catch (_: Throwable) {}
        }

        activeStreamServer = null
        activeMedia = null
        savedTrackState = SavedTrackSelectionState()
        castMode = CastMode.NONE
        activeDlnaDevice = null
        activeCastDeviceId = null
        activeCastTvName = ""
        statusSubtitle = ""
        isConnecting = false
        isPlaying = false

        stopBackgroundJobsAndService()
        broadcastSnapshot()

        if (media != null && !media.isLiveBroadcastLocked && media.phone.isNotEmpty() && media.contentId.isNotEmpty() && resumePos > 0L) {
            scope.launch {
                sendProgressPingDirect(media.phone, media.contentId, media.season, media.episode, resumePos, dur)
            }
        }

        return Pair(server, resumePos)
    }

    /**
     * Called when `PlayerActivity` launches with a NEW movie selected from the catalog while an existing
     * cast session is active. Saves the old movie's watch progress, stops the old `LocalStreamServer` and
     * cleans up old TDLib temp files, and returns the connected TV target so the new movie automatically
     * plays on the same TV.
     */
    fun prepareForMovieReplacement(
        context: Context,
        newFileId: Int,
        newParts: List<FilePart>?
    ): AutoContinueCastTarget? {
        if (!isCastingActive) return null
        val appCtx = context.applicationContext
        val oldMedia = activeMedia
        val oldServer = activeStreamServer
        val finalPos = getEffectivePositionMs(appCtx)
        val finalDur = getEffectiveDurationMs(appCtx)

        val target: AutoContinueCastTarget? = when (castMode) {
            CastMode.DLNA -> {
                val dev = activeDlnaDevice ?: dlnaController.activeDevice
                if (dev != null) {
                    AutoContinueCastTarget.Dlna(dev, activeCastDeviceId ?: "dlna:${dev.udn}")
                } else {
                    null
                }
            }
            CastMode.GOOGLE_CAST -> {
                AutoContinueCastTarget.GoogleCast(activeCastTvName, activeCastDeviceId)
            }
            CastMode.NONE -> null
        }

        if (castMode == CastMode.DLNA) {
            dlnaController.stopSession(notifyListener = false)
        } else if (castMode == CastMode.GOOGLE_CAST) {
            detachRemoteMediaClientProgressListener()
        }

        activeStreamServer = null
        activeMedia = null
        savedTrackState = SavedTrackSelectionState()
        currentPositionMs = 0L
        durationMs = 0L

        val oldServerIds = buildSet {
            val fid = oldServer?.getActiveFileId() ?: -1
            if (fid > 0) add(fid)
            oldServer?.getActiveMultipartParts()?.forEach { if (it.fileId > 0) add(it.fileId) }
        }
        try {
            oldServer?.stop()
        } catch (_: Throwable) {}

        val protectedIds = HashSet<Int>().apply {
            if (newFileId > 0) add(newFileId)
            newParts?.forEach { if (it.fileId > 0) add(it.fileId) }
        }
        cleanupTdlibFiles(appCtx, oldMedia, protectedIds, optimize = false, extraFileIds = oldServerIds)

        if (oldMedia != null && !oldMedia.isLiveBroadcastLocked && oldMedia.phone.isNotEmpty() && oldMedia.contentId.isNotEmpty() && finalPos > 0L) {
            scope.launch {
                sendProgressPingDirect(oldMedia.phone, oldMedia.contentId, oldMedia.season, oldMedia.episode, finalPos, finalDur)
            }
        }

        return target
    }

    /**
     * Completely stops TV casting, saves final watch progress to `/api/progress`, stops `LocalStreamServer`,
     * purges TDLib temporary video chunks, releases `WakeLock`/`WifiLock`, and stops [CastPlaybackService].
     */
    fun stopCastingCompletely(
        context: Context,
        markFinished: Boolean = false,
        notifyAttachedPlayerToClose: Boolean = true
    ) {
        val appCtx = context.applicationContext
        appContext = appCtx
        val media = activeMedia
        val server = activeStreamServer
        val serverIds = buildSet {
            val fid = server?.getActiveFileId() ?: -1
            if (fid > 0) add(fid)
            server?.getActiveMultipartParts()?.forEach { if (it.fileId > 0) add(it.fileId) }
        }
        val finalDur = getEffectiveDurationMs(appCtx)
        val rawPos = getEffectivePositionMs(appCtx)
        val finalPos = if (markFinished && finalDur > 0L) finalDur else rawPos
        val modeWas = castMode
        val attachedUi = playerUiListener

        castMode = CastMode.NONE
        activeStreamServer = null
        activeMedia = null
        savedTrackState = SavedTrackSelectionState()
        activeDlnaDevice = null
        activeCastDeviceId = null
        activeCastTvName = ""
        statusSubtitle = ""
        isConnecting = false
        isPlaying = false
        currentPositionMs = 0L
        durationMs = 0L

        if (modeWas == CastMode.DLNA) {
            dlnaController.stopSession(notifyListener = false)
        } else if (modeWas == CastMode.GOOGLE_CAST) {
            detachRemoteMediaClientProgressListener()
            mainHandler.post {
                try {
                    CastContext.getSharedInstance(appCtx).sessionManager.endCurrentSession(true)
                    MediaRouter.getInstance(appCtx).unselect(MediaRouter.UNSELECT_REASON_STOPPED)
                } catch (_: Throwable) {}
            }
        }

        stopBackgroundJobsAndService()
        broadcastSnapshot()

        scope.launch {
            try {
                server?.stop()
            } catch (_: Throwable) {}
            cleanupTdlibFiles(appCtx, media, emptySet(), optimize = true, extraFileIds = serverIds)
            if (media != null && !media.isLiveBroadcastLocked && media.phone.isNotEmpty() && media.contentId.isNotEmpty() && finalPos > 0L) {
                sendProgressPingDirect(media.phone, media.contentId, media.season, media.episode, finalPos, finalDur)
            }
        }

        if (notifyAttachedPlayerToClose && attachedUi != null) {
            mainHandler.post {
                try {
                    attachedUi.onExternalCastStopped()
                } catch (_: Throwable) {}
            }
        }
    }

    fun triggerImmediateProgressSync() {
        val media = activeMedia ?: return
        if (media.isLiveBroadcastLocked || media.phone.isEmpty() || media.contentId.isEmpty()) return
        val pos = getEffectivePositionMs(appContext)
        val dur = getEffectiveDurationMs(appContext)
        if (pos <= 0L) return
        scope.launch {
            sendProgressPingDirect(media.phone, media.contentId, media.season, media.episode, pos, dur)
        }
    }

    fun buildReopenPlayerIntent(context: Context): Intent {
        val media = activeMedia
        return Intent(context, PlayerActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra(PlayerActivity.EXTRA_ATTACH_ACTIVE_CAST, true)
            if (media != null) {
                if (!media.multipartJson.isNullOrEmpty()) {
                    putExtra(PlayerActivity.EXTRA_MULTIPART_JSON, media.multipartJson)
                }
                putExtra(PlayerActivity.EXTRA_FILE_ID, media.fileId)
                putExtra(PlayerActivity.EXTRA_FILE_SIZE, media.fileSize)
                putExtra(PlayerActivity.EXTRA_MIME_TYPE, media.mimeType)
                putExtra(PlayerActivity.EXTRA_TITLE, media.title)
                putExtra(PlayerActivity.EXTRA_CHAT_ID, media.chatId)
                putExtra(PlayerActivity.EXTRA_MSG_ID, media.msgId)
                putExtra(PlayerActivity.EXTRA_PHONE, media.phone)
                putExtra(PlayerActivity.EXTRA_CONTENT_ID, media.contentId)
                putExtra(PlayerActivity.EXTRA_SEASON, media.season)
                putExtra(PlayerActivity.EXTRA_EPISODE, media.episode)
                putExtra(PlayerActivity.EXTRA_CREDITS_START, media.creditsStart)
                putExtra(PlayerActivity.EXTRA_INTRO_START_MS, media.introStartMs)
                putExtra(PlayerActivity.EXTRA_INTRO_END_MS, media.introEndMs)
                putExtra(PlayerActivity.EXTRA_INTRODB_CREDITS_MS, media.introDbCreditsMs)
                if (media.isLiveBroadcastLocked) {
                    putExtra(PlayerActivity.EXTRA_IS_LIVE_TV, true)
                    putExtra(PlayerActivity.EXTRA_IS_PREMIERE_LOCKED, media.isPremiereLocked)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_CHANNEL_ID, media.liveTvChannelId)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_CHANNEL_LABEL, media.liveTvChannelLabel)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_PROGRAM_TITLE, media.liveTvProgramTitle)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_ITEM_ID, media.liveTvItemId)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_POSTER_PATH, media.liveTvPosterPath)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_PAYLOAD, media.liveTvPayload)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_RAW_ITEM_JSON, media.liveTvRawItemJson)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_TUNED_AT_MS, media.liveTvTunedAtMs)
                    putExtra(PlayerActivity.EXTRA_LIVE_TV_BASE_OFFSET_SEC, media.liveTvBaseOffsetSec)
                    if (media.liveTvTmdbId > 0) putExtra(PlayerActivity.EXTRA_XRAY_TMDB_ID, media.liveTvTmdbId)
                    if (media.liveTvYear.isNotBlank()) putExtra(PlayerActivity.EXTRA_XRAY_YEAR, media.liveTvYear)
                    if (media.liveTvMediaType.isNotBlank()) putExtra(PlayerActivity.EXTRA_XRAY_MEDIA_TYPE, media.liveTvMediaType)
                    if (media.liveTvCleanTitle.isNotBlank()) putExtra(PlayerActivity.EXTRA_XRAY_CLEAN_TITLE, media.liveTvCleanTitle)
                }
            }
        }
    }

    private fun startBackgroundTickerAndProgressSync(context: Context) {
        if (tickerJob?.isActive != true) {
            tickerJob = scope.launch {
                while (isActive && isCastingActive) {
                    delay(1000L)
                    if (!isCastingActive) break
                    mainHandler.post {
                        pollGoogleCastAndRefreshSnapshot(context)
                    }
                }
            }
        }

        if (progressSyncJob?.isActive != true) {
            progressSyncJob = scope.launch {
                while (isActive && isCastingActive) {
                    delay(30_000L)
                    if (!isCastingActive) break
                    val media = activeMedia ?: continue
                    if (!media.isLiveBroadcastLocked && media.phone.isNotEmpty() && media.contentId.isNotEmpty()) {
                        val pos = getEffectivePositionMs(context)
                        val dur = getEffectiveDurationMs(context)
                        sendProgressPingDirect(media.phone, media.contentId, media.season, media.episode, pos, dur)
                    }
                }
            }
        }
    }

    private fun pollGoogleCastAndRefreshSnapshot(context: Context) {
        if (!isCastingActive) return
        if (castMode == CastMode.GOOGLE_CAST) {
            val session = try {
                CastContext.getSharedInstance(context).sessionManager.currentCastSession
            } catch (_: Throwable) {
                null
            }
            val rmc = session?.remoteMediaClient
            if (rmc != null) {
                if (attachedRmc !== rmc) {
                    detachRemoteMediaClientProgressListener()
                    attachedRmc = rmc
                    try {
                        rmc.addProgressListener(rmcProgressListener, 1000L)
                    } catch (_: Throwable) {}
                }
                if (activeMedia?.isLiveBroadcastLocked == true && rmc.isPaused) {
                    try { rmc.play() } catch (_: Throwable) {}
                }
                isConnecting = false
                isPlaying = rmc.isPlaying || rmc.isBuffering
                statusSubtitle = when {
                    rmc.isBuffering -> "Cargando búfer en la TV..."
                    rmc.isPaused -> "En pausa en la TV"
                    rmc.isPlaying -> "Reproduciendo por Google Cast"
                    else -> "Conectado por Google Cast"
                }
                getEffectivePositionMs(context)
                getEffectiveDurationMs(context)

                // Seamlessly advance Google Cast WebVTT subtitle track slot when new cues are harvested
                // or playback approaches the end of the previous VTT window (0ms video interruption!)
                val server = activeStreamServer
                if (server != null && rmc.isPlaying) {
                    val nextSubSlot = server.pollNextGoogleCastSubtitleSlotIfNeeded(currentPositionMs)
                    if (nextSubSlot > 0L) {
                        try {
                            rmc.setActiveMediaTracks(longArrayOf(nextSubSlot))
                            Log.i(TAG, "💬 Auto-advanced Google Cast VTT subtitle slot -> #$nextSubSlot at pos=${currentPositionMs}ms")
                        } catch (_: Throwable) {}
                    }
                }

                // Detect natural playback completion on Chromecast / Android TV
                if (rmc.playerState == MediaStatus.PLAYER_STATE_IDLE &&
                    rmc.idleReason == MediaStatus.IDLE_REASON_FINISHED
                ) {
                    val ui = playerUiListener
                    if (ui != null) {
                        ui.onGoogleCastNaturalEnd()
                    } else {
                        stopCastingCompletely(context, markFinished = true, notifyAttachedPlayerToClose = false)
                    }
                    return
                }
            } else if (!isConnecting &&
                playerUiListener == null &&
                System.currentTimeMillis() - castStartedAtWallMs > 8000L &&
                session == null
            ) {
                // Cast session ended externally (e.g. from TV remote) while PlayerActivity was closed
                stopCastingCompletely(context, markFinished = false, notifyAttachedPlayerToClose = false)
                return
            }
        }
        broadcastSnapshot()
    }

    private fun stopBackgroundJobsAndService() {
        tickerJob?.cancel()
        tickerJob = null
        progressSyncJob?.cancel()
        progressSyncJob = null
        detachRemoteMediaClientProgressListener()
        releaseCastLocks()
        appContext?.let { CastPlaybackService.stop(it) }
    }

    private fun cleanupTdlibFiles(
        context: Context,
        media: CastMediaMetadata?,
        protectedFileIds: Set<Int>,
        optimize: Boolean,
        extraFileIds: Set<Int> = emptySet()
    ) {
        try {
            val engine = TelegramEngine.getInstance(context)
            val idsToPurge = buildSet {
                if (media != null) {
                    if (media.fileId > 0 && !protectedFileIds.contains(media.fileId)) {
                        add(media.fileId)
                    }
                    media.multipartParts?.forEach { part ->
                        if (part.fileId > 0 && !protectedFileIds.contains(part.fileId)) {
                            add(part.fileId)
                        }
                    }
                }
                extraFileIds.forEach { fid ->
                    if (fid > 0 && !protectedFileIds.contains(fid)) {
                        add(fid)
                    }
                }
            }
            if (optimize) {
                engine.purgeAllStreamingCaches(idsToPurge)
                StorageAndRamHygiene.cleanEphemeralCacheArtifacts(context.cacheDir)
            } else {
                engine.releaseSpecificVideoFiles(idsToPurge)
            }
        } catch (e: Throwable) {
            Log.w(TAG, "TDLib cleanup warning: ${e.message}")
        }
    }

    private fun acquireCastLocks(context: Context) {
        try {
            if (castWakeLock == null) {
                val pm = context.getSystemService(Context.POWER_SERVICE) as? PowerManager
                castWakeLock = pm?.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "Cineflix:CastForegroundWakeLock")?.apply {
                    setReferenceCounted(false)
                }
            }
            if (castWakeLock?.isHeld == false) {
                castWakeLock?.acquire(4L * 60L * 60L * 1000L)
            }
        } catch (e: Throwable) {
            Log.w(TAG, "WakeLock warning: ${e.message}")
        }

        try {
            if (castWifiLock == null) {
                val wm = context.getSystemService(Context.WIFI_SERVICE) as? WifiManager
                @Suppress("DEPRECATION")
                val lockMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    WifiManager.WIFI_MODE_FULL_LOW_LATENCY
                } else {
                    WifiManager.WIFI_MODE_FULL_HIGH_PERF
                }
                castWifiLock = wm?.createWifiLock(lockMode, "Cineflix:CastForegroundWifiLock")?.apply {
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

    suspend fun sendProgressPingDirect(
        phone: String,
        contentId: String,
        season: String,
        episode: String,
        currentPosition: Long,
        durationMs: Long
    ) {
        if (currentPosition <= 0L || phone.isBlank() || contentId.isBlank()) return
        val progressSeconds = (currentPosition / 1000L).toInt()
        val isFinished = durationMs > 0L && currentPosition >= (durationMs - 5000L)

        withContext(Dispatchers.IO) {
            var conn: HttpURLConnection? = null
            try {
                conn = StorageAndRamHygiene.openCompatUrlConnection("https://cineflixapp.duckdns.org/api/progress")
                conn.requestMethod = "POST"
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                conn.setRequestProperty("x-user-phone", phone)
                conn.connectTimeout = 6000
                conn.readTimeout = 6000
                conn.doOutput = true

                val json = JSONObject().apply {
                    val seasonVal: Any = season.toIntOrNull() ?: JSONObject.NULL
                    val episodeVal: Any = episode.toIntOrNull() ?: JSONObject.NULL
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
                Log.d("PROGRESS", "Cast POST contentId=$contentId position=$progressSeconds response=$responseCode")
            } catch (e: Exception) {
                Log.e("PROGRESS", "Cast POST error: ${e.message}")
            } finally {
                try { conn?.disconnect() } catch (_: Exception) {}
            }
        }
    }

    fun formatDurationClock(ms: Long): String {
        val totalSec = (ms.coerceAtLeast(0L)) / 1000L
        val hours = totalSec / 3600L
        val minutes = (totalSec % 3600L) / 60L
        val seconds = totalSec % 60L
        return if (hours > 0L) {
            String.format("%d:%02d:%02d", hours, minutes, seconds)
        } else {
            String.format("%02d:%02d", minutes, seconds)
        }
    }
}
