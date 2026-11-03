package com.cineflix.android.ui.player.cast

import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

/**
 * Controls direct UPnP / DLNA AVTransport:1 video playback on Smart TVs
 * (Samsung Tizen 2015-2026, Samsung Orsay 2010-2014, LG webOS, Sony Bravia, Hisense VIDAA, Philips, TCL, Roku).
 *
 * Features:
 *  - 3-tier SetAVTransportURI handshake (Full DIDL-Lite -> video/x-mkv fallback -> empty metadata fallback)
 *    with 25s timeout to accommodate first-time Samsung Tizen "Permitir dispositivo" TV prompt.
 *  - Automatic runtime fallback to legacy Samsung Orsay `video/x-mkv` HTTP endpoint if an unlabelled
 *    legacy TV accepts SetAVTransportURI on `video/x-matroska` and then immediately aborts HTTP playback.
 *  - Automatic post-PLAYING Seek(REL_TIME) so resuming a movie or live-switching Audio/Subtitles jumps
 *    to the exact second.
 *  - 1.5s non-blocking GetPositionInfo / GetTransportInfo polling to keep PlayerActivity's SeekBar,
 *    clock, and Cineflix cloud watch progress synchronized in real time.
 */
class DlnaCastController {

    companion object {
        private const val TAG = "DlnaCastController"
        private val XML_MEDIA_TYPE = "text/xml; charset=\"utf-8\"".toMediaType()
    }

    interface Listener {
        fun onConnecting(device: DlnaDevice)
        fun onPlaybackStarted(device: DlnaDevice)
        fun onProgressUpdated(device: DlnaDevice, positionMs: Long, durationMs: Long, isPlaying: Boolean)
        fun onPlaybackEndedNaturally(device: DlnaDevice, finalPositionMs: Long, durationMs: Long)
        fun onPlaybackStopped(device: DlnaDevice, lastPositionMs: Long)
        fun onError(device: DlnaDevice, message: String)
        fun onTrackReloadFailed(device: DlnaDevice) {}
    }

    var listener: Listener? = null

    /**
     * Optional callback supplied by `LocalStreamServer` returning true when the Smart TV
     * is actively pulling media payload chunks over HTTP (protects position tracking on TVs
     * whose UPnP `GetTransportInfo` or `GetPositionInfo` returns vendor states / `NOT_IMPLEMENTED`).
     */
    var remoteStreamActiveProvider: (() -> Boolean)? = null

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val mainHandler: Handler? = try {
        Looper.getMainLooper()?.let { Handler(it) }
    } catch (_: Throwable) {
        null
    }
    private val sessionEpoch = AtomicLong(0L)

    private fun postToMain(block: () -> Unit) {
        val h = mainHandler
        if (h != null) {
            h.post(block)
        } else {
            block()
        }
    }

    // Generous read timeout for initial SetAVTransportURI / Play (Samsung Tizen first-time permission popup)
    private val controlHttpClient = OkHttpClient.Builder()
        .connectTimeout(8, TimeUnit.SECONDS)
        .readTimeout(25, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    // Fast non-blocking timeout for background 1.5s position polling
    private val pollHttpClient = OkHttpClient.Builder()
        .connectTimeout(3, TimeUnit.SECONDS)
        .readTimeout(4, TimeUnit.SECONDS)
        .build()

    // Short read timeout for RenderingControl:1 SetTransforms calls (Philips Android TV DMRs apply
    // X_Philips.com_Codepage=UTF-8 in ~2ms on the UI thread before entering a 15s JNI semaphore wait)
    private val renderingControlHttpClient = OkHttpClient.Builder()
        .connectTimeout(2, TimeUnit.SECONDS)
        .readTimeout(1200, TimeUnit.MILLISECONDS)
        .build()

    @Volatile var activeDevice: DlnaDevice? = null
        private set

    @Volatile var currentPositionMs: Long = 0L
        private set

    @Volatile var currentDurationMs: Long = 0L
        private set

    @Volatile var isRemotePlaying: Boolean = false
        private set

    @Volatile var isCurrentSessionLiveTranscode: Boolean = false
        private set

    @Volatile var currentBaseOffsetMs: Long = 0L
        private set

    @Volatile private var knownContainerDurationMs: Long = 0L
    @Volatile private var tvLiveSeekAnchorMovieMs: Long = -1L
    @Volatile private var tvLiveSeekAtWallMs: Long = 0L
    @Volatile private var wallClockAnchorPosMs: Long = 0L
    @Volatile private var accumulatedPlayingWallMs: Long = 0L
    @Volatile private var lastManualSeekAtMs: Long = 0L
    @Volatile private var lastPositionUpdateWallMs: Long = 0L
    @Volatile private var isAwaitingInitialSeek: Boolean = false

    private var pollJob: Job? = null

    val isActive: Boolean
        get() = activeDevice != null

    fun updateKnownDurationMs(durMs: Long) {
        if (durMs > 0L) {
            knownContainerDurationMs = durMs
            currentDurationMs = durMs
        }
    }

    fun notifyPendingSeek(targetMs: Long) {
        val safe = clampToKnownDuration(targetMs.coerceAtLeast(0L))
        currentPositionMs = safe
        wallClockAnchorPosMs = safe
        accumulatedPlayingWallMs = 0L
        lastManualSeekAtMs = System.currentTimeMillis()
        lastPositionUpdateWallMs = System.currentTimeMillis()
        if (isCurrentSessionLiveTranscode) {
            currentBaseOffsetMs = safe
            tvLiveSeekAnchorMovieMs = -1L
            tvLiveSeekAtWallMs = 0L
            pollJob?.cancel()
        }
    }

    fun onTvInitiatedLiveSeek(targetMovieMs: Long) {
        val safe = clampToKnownDuration(targetMovieMs.coerceAtLeast(0L))
        tvLiveSeekAnchorMovieMs = safe
        tvLiveSeekAtWallMs = System.currentTimeMillis()
        currentPositionMs = safe
        wallClockAnchorPosMs = safe
        accumulatedPlayingWallMs = 0L
        lastPositionUpdateWallMs = System.currentTimeMillis()
        val dev = activeDevice
        val dur = currentDurationMs
        val playing = isRemotePlaying
        if (dev != null) {
            postToMain {
                listener?.onProgressUpdated(dev, safe, dur, playing)
            }
        }
    }

    /**
     * Returns the most accurate playback position in milliseconds, interpolating sub-poll
     * elapsed wall-clock time (up to 2.5s) while the TV is actively playing.
     */
    fun getAccuratePositionMs(): Long {
        val base = currentPositionMs.coerceAtLeast(0L)
        if (!isActive || !isRemotePlaying || isAwaitingInitialSeek) {
            return base
        }
        val lastTick = lastPositionUpdateWallMs
        if (lastTick <= 0L) return base
        val subPollDelta = (System.currentTimeMillis() - lastTick).coerceIn(0L, 2500L)
        val estimated = base + subPollDelta
        val dur = currentDurationMs
        return if (dur > 0L) estimated.coerceAtMost(dur) else estimated
    }

    private fun clampToKnownDuration(posMs: Long): Long {
        val safe = posMs.coerceAtLeast(0L)
        val dur = currentDurationMs
        return if (dur > 0L) safe.coerceAtMost(dur) else safe
    }

    fun startSession(
        device: DlnaDevice,
        streamUrl: String,
        title: String,
        mimeType: String,
        fileSizeBytes: Long,
        startPositionMs: Long,
        durationHintMs: Long = 0L,
        subtitleSrtUrl: String? = null,
        fallbackStreamUrl: String? = null,
        fallbackMimeType: String? = null,
        isHevcVideo: Boolean = false,
        isTrackReload: Boolean = false,
        isLiveTranscode: Boolean = false,
        basePositionOffsetMs: Long = 0L,
        isFallbackLiveTranscode: Boolean = false,
        fallbackBaseOffsetMs: Long = 0L
    ) {
        val previousDevice = activeDevice
        val myEpoch = sessionEpoch.incrementAndGet()
        pollJob?.cancel()

        val safeBaseOffset = if (isLiveTranscode) basePositionOffsetMs.coerceAtLeast(0L) else 0L
        val effectiveSubtitleSrtUrl = if (isLiveTranscode) null else subtitleSrtUrl
        val initialAnchor = if (isLiveTranscode) safeBaseOffset else startPositionMs.coerceAtLeast(0L)

        activeDevice = device
        isCurrentSessionLiveTranscode = isLiveTranscode
        currentBaseOffsetMs = safeBaseOffset
        tvLiveSeekAnchorMovieMs = -1L
        tvLiveSeekAtWallMs = 0L
        currentPositionMs = initialAnchor
        wallClockAnchorPosMs = initialAnchor
        accumulatedPlayingWallMs = 0L
        lastManualSeekAtMs = 0L
        lastPositionUpdateWallMs = System.currentTimeMillis()
        isAwaitingInitialSeek = !isLiveTranscode && startPositionMs > 3000L
        if (durationHintMs > 0L) {
            knownContainerDurationMs = durationHintMs
        }
        currentDurationMs = knownContainerDurationMs.coerceAtLeast(0L)
        isRemotePlaying = false

        postToMain { listener?.onConnecting(device) }

        scope.launch {
            // If switching directly from TV #1 to TV #2, stop TV #1 cleanly in parallel
            if (previousDevice != null && previousDevice.avTransportControlUrl != device.avTransportControlUrl) {
                launch {
                    sendSoapAction(
                        client = pollHttpClient,
                        controlUrl = previousDevice.avTransportControlUrl,
                        action = "Stop",
                        soapXml = DlnaSoapBuilder.buildStopSoap()
                    )
                }
            }

            // Best-effort pre-Stop on target TV (resets stuck TRANSITIONING / previous URI states)
            sendSoapAction(
                client = pollHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "Stop",
                soapXml = DlnaSoapBuilder.buildStopSoap()
            )

            if (sessionEpoch.get() != myEpoch) return@launch

            val effectiveFullDurationMs = if (knownContainerDurationMs > 0L) knownContainerDurationMs else durationHintMs
            val effectiveRemainingDurationMs = if (isLiveTranscode && effectiveFullDurationMs > safeBaseOffset) {
                effectiveFullDurationMs - safeBaseOffset
            } else {
                effectiveFullDurationMs
            }
            val effectiveFileSizeBytes = if (isLiveTranscode) {
                com.cineflix.android.ui.player.cast.transcode.LiveTranscodeManager.computeVirtualLiveTsSizeBytes(
                    remainingDurationMs = effectiveRemainingDurationMs,
                    is1080p = true
                )
            } else {
                fileSizeBytes
            }

            // Multi-tier SetAVTransportURI handshake for universal Smart TV compatibility
            val setUriResult = executeResilientSetUri(
                device = device,
                streamUrl = streamUrl,
                title = title,
                mimeType = mimeType,
                fileSizeBytes = effectiveFileSizeBytes,
                durationHintMs = effectiveRemainingDurationMs,
                subtitleSrtUrl = effectiveSubtitleSrtUrl,
                isLiveTranscode = isLiveTranscode
            )

            if (sessionEpoch.get() != myEpoch) return@launch

            if (!setUriResult.success) {
                if (!fallbackStreamUrl.isNullOrBlank() && !fallbackMimeType.isNullOrBlank() && fallbackStreamUrl != streamUrl) {
                    Log.w(
                        TAG,
                        "⚠️ Primary SetAVTransportURI failed on ${device.friendlyName}, retrying fallback ($fallbackMimeType, live=$isFallbackLiveTranscode)..."
                    )
                    startSession(
                        device = device,
                        streamUrl = fallbackStreamUrl,
                        title = title,
                        mimeType = fallbackMimeType,
                        fileSizeBytes = if (isFallbackLiveTranscode) 0L else fileSizeBytes,
                        startPositionMs = if (isFallbackLiveTranscode) 0L else startPositionMs,
                        durationHintMs = durationHintMs,
                        subtitleSrtUrl = if (isFallbackLiveTranscode) null else subtitleSrtUrl,
                        fallbackStreamUrl = null,
                        fallbackMimeType = null,
                        isHevcVideo = isHevcVideo,
                        isTrackReload = isTrackReload,
                        isLiveTranscode = isFallbackLiveTranscode,
                        basePositionOffsetMs = if (isFallbackLiveTranscode) fallbackBaseOffsetMs else 0L
                    )
                    return@launch
                }
                Log.e(TAG, "❌ SetAVTransportURI failed on ${device.friendlyName}: ${setUriResult.errorDetail}")
                activeDevice = null
                isCurrentSessionLiveTranscode = false
                currentBaseOffsetMs = 0L
                postToMain {
                    listener?.onError(
                        device,
                        "No se pudo iniciar vídeo en ${device.friendlyName} (${setUriResult.errorDetail})"
                    )
                }
                return@launch
            }

            // Send Play (Speed = 1)
            val playRes = sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "Play",
                soapXml = DlnaSoapBuilder.buildPlaySoap()
            )

            if (sessionEpoch.get() != myEpoch) return@launch

            if (!playRes.success) {
                // One brief retry after 500ms (some LG webOS / Hisense TVs need 500ms after SetAVTransportURI)
                delay(500)
                val retryPlay = sendSoapAction(
                    client = controlHttpClient,
                    controlUrl = device.avTransportControlUrl,
                    action = "Play",
                    soapXml = DlnaSoapBuilder.buildPlaySoap()
                )
                if (!retryPlay.success && sessionEpoch.get() == myEpoch) {
                    Log.e(TAG, "❌ Play SOAP failed on ${device.friendlyName}: ${retryPlay.errorDetail}")
                    activeDevice = null
                    isCurrentSessionLiveTranscode = false
                    currentBaseOffsetMs = 0L
                    postToMain {
                        listener?.onError(
                            device,
                            "La TV ${device.friendlyName} rechazó la orden Play (${retryPlay.errorDetail})"
                        )
                    }
                    return@launch
                }
            }

            isRemotePlaying = true
            lastPositionUpdateWallMs = System.currentTimeMillis()
            Log.i(
                TAG,
                "✅ DLNA playback started on ${device.friendlyName} -> $streamUrl ($mimeType, liveTranscode=$isLiveTranscode, baseOffsetMs=$safeBaseOffset)"
            )
            postToMain { listener?.onPlaybackStarted(device) }

            startPollingAndInitialSeekLoop(
                device = device,
                myEpoch = myEpoch,
                initialSeekMs = startPositionMs,
                title = title,
                fileSizeBytes = fileSizeBytes,
                durationHintMs = durationHintMs,
                subtitleSrtUrl = subtitleSrtUrl,
                activeStreamUrl = streamUrl,
                fallbackStreamUrl = fallbackStreamUrl,
                fallbackMimeType = fallbackMimeType,
                isHevcVideo = isHevcVideo,
                isTrackReload = isTrackReload,
                isLiveTranscode = isLiveTranscode,
                basePositionOffsetMs = safeBaseOffset,
                isFallbackLiveTranscode = isFallbackLiveTranscode,
                fallbackBaseOffsetMs = fallbackBaseOffsetMs
            )
        }
    }

    fun togglePlayPause() {
        if (isRemotePlaying) pause() else resume()
    }

    fun pause() {
        val dev = activeDevice ?: return
        val myEpoch = sessionEpoch.get()
        currentPositionMs = getAccuratePositionMs()
        wallClockAnchorPosMs = currentPositionMs
        accumulatedPlayingWallMs = 0L
        lastPositionUpdateWallMs = System.currentTimeMillis()
        isRemotePlaying = false
        postToMain {
            listener?.onProgressUpdated(dev, currentPositionMs, currentDurationMs, false)
        }
        scope.launch {
            if (sessionEpoch.get() != myEpoch) return@launch
            sendSoapAction(
                client = controlHttpClient,
                controlUrl = dev.avTransportControlUrl,
                action = "Pause",
                soapXml = DlnaSoapBuilder.buildPauseSoap()
            )
        }
    }

    fun resume() {
        val dev = activeDevice ?: return
        val myEpoch = sessionEpoch.get()
        wallClockAnchorPosMs = currentPositionMs
        accumulatedPlayingWallMs = 0L
        lastPositionUpdateWallMs = System.currentTimeMillis()
        isRemotePlaying = true
        postToMain {
            listener?.onProgressUpdated(dev, currentPositionMs, currentDurationMs, true)
        }
        scope.launch {
            if (sessionEpoch.get() != myEpoch) return@launch
            sendSoapAction(
                client = controlHttpClient,
                controlUrl = dev.avTransportControlUrl,
                action = "Play",
                soapXml = DlnaSoapBuilder.buildPlaySoap()
            )
        }
    }

    fun seekTo(targetMs: Long) {
        val dev = activeDevice ?: return
        val myEpoch = sessionEpoch.get()
        val safeTarget = targetMs.coerceAtLeast(0L)
        currentPositionMs = safeTarget
        wallClockAnchorPosMs = safeTarget
        accumulatedPlayingWallMs = 0L
        lastManualSeekAtMs = System.currentTimeMillis()
        lastPositionUpdateWallMs = System.currentTimeMillis()
        postToMain {
            listener?.onProgressUpdated(dev, currentPositionMs, currentDurationMs, isRemotePlaying)
        }
        scope.launch {
            if (sessionEpoch.get() != myEpoch) return@launch
            val res = sendSoapAction(
                client = controlHttpClient,
                controlUrl = dev.avTransportControlUrl,
                action = "Seek",
                soapXml = DlnaSoapBuilder.buildSeekSoap(safeTarget)
            )
            Log.i(TAG, "⏩ DLNA Seek to ${DlnaSoapBuilder.formatMsToRelTime(safeTarget)} -> ok=${res.success}")
        }
    }

    /**
     * Stops playback on the active TV and ends the DLNA session, returning the last known position (ms).
     */
    fun stopSession(notifyListener: Boolean = true): Long {
        val dev = activeDevice
        val finalPos = getAccuratePositionMs()
        currentPositionMs = finalPos
        sessionEpoch.incrementAndGet()
        pollJob?.cancel()
        pollJob = null
        activeDevice = null
        isRemotePlaying = false
        isAwaitingInitialSeek = false
        isCurrentSessionLiveTranscode = false
        currentBaseOffsetMs = 0L

        if (dev != null) {
            CoroutineScope(Dispatchers.IO).launch {
                sendSoapAction(
                    client = pollHttpClient,
                    controlUrl = dev.avTransportControlUrl,
                    action = "Stop",
                    soapXml = DlnaSoapBuilder.buildStopSoap()
                )
            }
            if (notifyListener) {
                postToMain { listener?.onPlaybackStopped(dev, finalPos) }
            }
        }
        return finalPos
    }

    fun destroy() {
        stopSession(notifyListener = false)
        listener = null
        remoteStreamActiveProvider = null
        scope.cancel()
    }

    private fun startPollingAndInitialSeekLoop(
        device: DlnaDevice,
        myEpoch: Long,
        initialSeekMs: Long,
        title: String,
        fileSizeBytes: Long,
        durationHintMs: Long,
        subtitleSrtUrl: String?,
        activeStreamUrl: String,
        fallbackStreamUrl: String?,
        fallbackMimeType: String?,
        isHevcVideo: Boolean,
        isTrackReload: Boolean,
        isLiveTranscode: Boolean,
        basePositionOffsetMs: Long,
        isFallbackLiveTranscode: Boolean,
        fallbackBaseOffsetMs: Long
    ) {
        pollJob?.cancel()
        pollJob = scope.launch {
            var pendingInitialSeek = !isLiveTranscode && initialSeekMs > 3000L
            isAwaitingInitialSeek = pendingInitialSeek
            var initialSeekExecutedAtMs = 0L
            var hasSeenPlayingState = false
            var consecutiveStoppedBeforePlay = 0
            var subtitleTransformSynced = isLiveTranscode || device.renderingControlUrl.isNullOrBlank()
            var subtitleTransformAttempts = 0
            var subtitleTransformLastSyncMs = 0L
            var subtitleTransformFollowUpDone = false
            var maxObservedPosMs = if (isLiveTranscode) basePositionOffsetMs else initialSeekMs.coerceAtLeast(0L)
            val loopStartTime = System.currentTimeMillis()
            var lastPollWallMs = loopStartTime

            while (isActive && sessionEpoch.get() == myEpoch && activeDevice == device) {
                val fastStartupPoll = pendingInitialSeek ||
                    (!hasSeenPlayingState && System.currentTimeMillis() - loopStartTime < 7500L)
                delay(if (fastStartupPoll) 500L else 1500L)
                if (!isActive || sessionEpoch.get() != myEpoch) break

                val nowWallMs = System.currentTimeMillis()
                val deltaWallMs = (nowWallMs - lastPollWallMs).coerceIn(0L, 5000L)
                lastPollWallMs = nowWallMs

                val transportRes = sendSoapAction(
                    client = pollHttpClient,
                    controlUrl = device.avTransportControlUrl,
                    action = "GetTransportInfo",
                    soapXml = DlnaSoapBuilder.buildGetTransportInfoSoap()
                )
                val transportState = if (transportRes.success) {
                    UpnpXmlParser.parseTransportStateResponse(transportRes.responseXml)?.uppercase()
                } else {
                    null
                }
                val elapsedSinceStartMs = nowWallMs - loopStartTime
                val streamActivelyFlowing = try {
                    remoteStreamActiveProvider?.invoke() == true
                } catch (_: Throwable) {
                    false
                }

                if (transportState == "PLAYING") {
                    hasSeenPlayingState = true
                    consecutiveStoppedBeforePlay = 0
                    isRemotePlaying = true
                } else if (transportState == "PAUSED_PLAYBACK" || transportState == "PAUSED") {
                    hasSeenPlayingState = true
                    consecutiveStoppedBeforePlay = 0
                    isRemotePlaying = false
                } else if (!hasSeenPlayingState && (transportState == "STOPPED" || transportState == "NO_MEDIA_PRESENT")) {
                    if (streamActivelyFlowing) {
                        // TV is actively pulling media bytes from LocalStreamServer while reporting STOPPED during initial buffer
                        consecutiveStoppedBeforePlay = 0
                    } else {
                        consecutiveStoppedBeforePlay++
                    }
                    val minStoppedPolls = when {
                        isLiveTranscode -> 14
                        device.isConfirmedModernTizen -> 8
                        else -> 5
                    }
                    val minElapsedMs = when {
                        isLiveTranscode -> 14_000L
                        device.isConfirmedModernTizen -> 9_500L
                        else -> 5_000L
                    }

                    if (!fallbackStreamUrl.isNullOrBlank() &&
                        !fallbackMimeType.isNullOrBlank() &&
                        fallbackStreamUrl != activeStreamUrl &&
                        !streamActivelyFlowing &&
                        consecutiveStoppedBeforePlay >= minStoppedPolls &&
                        elapsedSinceStartMs >= minElapsedMs
                    ) {
                        Log.w(
                            TAG,
                            "⚠️ ${device.friendlyName} entered $transportState before PLAYING; auto-falling back to $fallbackMimeType (live=$isFallbackLiveTranscode)..."
                        )
                        startSession(
                            device = device,
                            streamUrl = fallbackStreamUrl,
                            title = title,
                            mimeType = fallbackMimeType,
                            fileSizeBytes = if (isFallbackLiveTranscode) 0L else fileSizeBytes,
                            startPositionMs = if (isFallbackLiveTranscode) 0L else initialSeekMs,
                            durationHintMs = durationHintMs,
                            subtitleSrtUrl = if (isFallbackLiveTranscode) null else subtitleSrtUrl,
                            fallbackStreamUrl = null,
                            fallbackMimeType = null,
                            isHevcVideo = isHevcVideo,
                            isTrackReload = isTrackReload,
                            isLiveTranscode = isFallbackLiveTranscode,
                            basePositionOffsetMs = if (isFallbackLiveTranscode) fallbackBaseOffsetMs else 0L
                        )
                        return@launch
                    }
                    val reloadMinPolls = if (isLiveTranscode) 14 else 7
                    val reloadMinElapsedMs = if (isLiveTranscode) 14_000L else 6_500L
                    if (isTrackReload &&
                        fallbackStreamUrl == null &&
                        !streamActivelyFlowing &&
                        consecutiveStoppedBeforePlay >= reloadMinPolls &&
                        elapsedSinceStartMs >= reloadMinElapsedMs
                    ) {
                        Log.w(TAG, "⚠️ Track reload rejected by ${device.friendlyName}; triggering automatic rollback")
                        postToMain {
                            listener?.onTrackReloadFailed(device)
                        }
                        return@launch
                    }
                } else if (streamActivelyFlowing && isRemotePlaying) {
                    // TV is actively pulling media bytes from LocalStreamServer even though GetTransportInfo
                    // returned a vendor/transitioning state or failed HTTP 500.
                    hasSeenPlayingState = true
                    consecutiveStoppedBeforePlay = 0
                }

                // Execute deferred initial resume seek right after TV enters PLAYING state (Direct Stream only)
                if (pendingInitialSeek &&
                    (transportState == "PLAYING" ||
                     (System.currentTimeMillis() - loopStartTime > 4500L &&
                      transportState != "TRANSITIONING" &&
                      transportState != "STOPPED" &&
                      transportState != "NO_MEDIA_PRESENT"))
                ) {
                    pendingInitialSeek = false
                    isAwaitingInitialSeek = false
                    initialSeekExecutedAtMs = System.currentTimeMillis()
                    wallClockAnchorPosMs = initialSeekMs.coerceAtLeast(0L)
                    accumulatedPlayingWallMs = 0L
                    Log.i(TAG, "⏩ Performing initial resume seek on ${device.friendlyName} to ${initialSeekMs}ms")
                    sendSoapAction(
                        client = controlHttpClient,
                        controlUrl = device.avTransportControlUrl,
                        action = "Seek",
                        soapXml = DlnaSoapBuilder.buildSeekSoap(initialSeekMs)
                    )
                    delay(600)
                    lastPollWallMs = System.currentTimeMillis()
                }

                // Activate or disable embedded MKV subtitles on UPnP DMRs that gate subtitle visibility
                // behind RenderingControl:1#SetTransforms (e.g. Philips Android TV MediaRenderer mode).
                // On track reloads (isTrackReload=true), wait at least 1400ms after Play (and 900ms after
                // initial Seek) so the TV's new ExoPlayer instance has finished onPrepared and refreshed
                // mSubtitleCache, then perform one follow-up re-sync ~2.2s later to catch late preparations.
                val reloadReadyForSubtitleSync = !isTrackReload || (
                    elapsedSinceStartMs >= 1400L &&
                        (initialSeekExecutedAtMs == 0L || nowWallMs - initialSeekExecutedAtMs >= 900L)
                    )
                if (!pendingInitialSeek &&
                    reloadReadyForSubtitleSync &&
                    (hasSeenPlayingState || streamActivelyFlowing)
                ) {
                    if (!subtitleTransformSynced) {
                        subtitleTransformAttempts++
                        val synced = syncRenderingControlSubtitles(
                            device = device,
                            myEpoch = myEpoch,
                            wantSubtitlesEnabled = !subtitleSrtUrl.isNullOrBlank(),
                            attempt = subtitleTransformAttempts
                        )
                        if (synced || subtitleTransformAttempts >= 8) {
                            subtitleTransformSynced = true
                            subtitleTransformLastSyncMs = System.currentTimeMillis()
                        }
                    } else if (!subtitleTransformFollowUpDone &&
                        subtitleTransformLastSyncMs > 0L &&
                        nowWallMs - subtitleTransformLastSyncMs >= 2200L
                    ) {
                        subtitleTransformFollowUpDone = true
                        syncRenderingControlSubtitles(
                            device = device,
                            myEpoch = myEpoch,
                            wantSubtitlesEnabled = !subtitleSrtUrl.isNullOrBlank(),
                            attempt = subtitleTransformAttempts + 1
                        )
                    }
                }

                if (isRemotePlaying && !pendingInitialSeek &&
                    (hasSeenPlayingState || streamActivelyFlowing || (isLiveTranscode && elapsedSinceStartMs >= 2000L))
                ) {
                    accumulatedPlayingWallMs += deltaWallMs
                }

                val posRes = sendSoapAction(
                    client = pollHttpClient,
                    controlUrl = device.avTransportControlUrl,
                    action = "GetPositionInfo",
                    soapXml = DlnaSoapBuilder.buildGetPositionInfoSoap()
                )
                val snap = if (posRes.success && sessionEpoch.get() == myEpoch) {
                    UpnpXmlParser.parsePositionInfoResponse(posRes.responseXml)
                } else {
                    null
                }

                if (sessionEpoch.get() == myEpoch) {
                    val knownDur = if (knownContainerDurationMs > 0L) knownContainerDurationMs else durationHintMs
                    if (isLiveTranscode) {
                        if (knownDur > 0L) {
                            currentDurationMs = knownDur
                        } else if (snap != null && snap.durationMs > 0L && snap.durationMs !in 9_560_000L..9_565_000L) {
                            currentDurationMs = basePositionOffsetMs + snap.durationMs
                        }

                        val nowMs = System.currentTimeMillis()
                        val tvSeekAnchor = tvLiveSeekAnchorMovieMs
                        val tvSeekRecent = tvSeekAnchor >= 0L && (nowMs - tvLiveSeekAtWallMs) < 4000L

                        if (snap != null && snap.hasValidRelTime && snap.positionMs > 0L) {
                            hasSeenPlayingState = true
                            consecutiveStoppedBeforePlay = 0
                            val candidateFromBase = basePositionOffsetMs + snap.positionMs
                            val effectivePos = if (tvSeekAnchor >= 0L) {
                                if (tvSeekRecent && kotlin.math.abs(candidateFromBase - tvSeekAnchor) > 15_000L) {
                                    // Ignore stale pre-seek RelTime while new HTTP byte-range transcode boots
                                    wallClockAnchorPosMs + accumulatedPlayingWallMs
                                } else if (tvSeekAnchor > basePositionOffsetMs + 15_000L &&
                                    snap.positionMs < (tvSeekAnchor - basePositionOffsetMs) - 15_000L
                                ) {
                                    // TV firmware reset its internal RelTime timer to 0 after HTTP byte-range seek
                                    tvSeekAnchor + snap.positionMs
                                } else {
                                    candidateFromBase
                                }
                            } else {
                                candidateFromBase
                            }
                            if (!tvSeekRecent || kotlin.math.abs(candidateFromBase - tvSeekAnchor) <= 15_000L) {
                                wallClockAnchorPosMs = effectivePos - snap.positionMs
                                accumulatedPlayingWallMs = snap.positionMs
                            }
                            currentPositionMs = clampToKnownDuration(effectivePos)
                            lastPositionUpdateWallMs = nowMs
                        } else if ((hasSeenPlayingState || streamActivelyFlowing) && accumulatedPlayingWallMs > 0L) {
                            currentPositionMs = clampToKnownDuration(wallClockAnchorPosMs + accumulatedPlayingWallMs)
                            lastPositionUpdateWallMs = nowMs
                        }
                        if ((hasSeenPlayingState || streamActivelyFlowing) && currentPositionMs > maxObservedPosMs) {
                            maxObservedPosMs = currentPositionMs
                        }
                    } else {
                        if (snap != null && snap.durationMs > 0L && snap.durationMs !in 9_560_000L..9_565_000L) {
                            currentDurationMs = snap.durationMs
                        } else if (knownDur > 0L && currentDurationMs <= 0L) {
                            currentDurationMs = knownDur
                        }
                        val nowForSettle = System.currentTimeMillis()
                        val seekSettleActive =
                            (initialSeekExecutedAtMs > 0L && nowForSettle - initialSeekExecutedAtMs < 3500L) ||
                            (lastManualSeekAtMs > 0L && nowForSettle - lastManualSeekAtMs < 3500L)

                        if (snap != null && snap.hasValidRelTime && snap.positionMs > 0L) {
                            hasSeenPlayingState = true
                            consecutiveStoppedBeforePlay = 0
                            val isStalePreSeekValue = seekSettleActive &&
                                snap.positionMs < wallClockAnchorPosMs &&
                                (wallClockAnchorPosMs - snap.positionMs) > 15_000L
                            if (!pendingInitialSeek && !isStalePreSeekValue) {
                                currentPositionMs = snap.positionMs
                                wallClockAnchorPosMs = snap.positionMs
                                accumulatedPlayingWallMs = 0L
                                lastPositionUpdateWallMs = nowForSettle
                                if (snap.positionMs > maxObservedPosMs) {
                                    maxObservedPosMs = snap.positionMs
                                }
                            }
                        } else if (!pendingInitialSeek && (hasSeenPlayingState || streamActivelyFlowing) && accumulatedPlayingWallMs > 0L) {
                            // Firmware returned RelTime=00:00:00 / NOT_IMPLEMENTED / SOAP fault during Direct Stream:
                            // advance smoothly from the anchor position so SeekBar and "Ver aquí" always advance!
                            currentPositionMs = clampToKnownDuration(wallClockAnchorPosMs + accumulatedPlayingWallMs)
                            lastPositionUpdateWallMs = nowForSettle
                            if (currentPositionMs > maxObservedPosMs) {
                                maxObservedPosMs = currentPositionMs
                            }
                        }
                    }
                }

                val posToReport = currentPositionMs
                val durToReport = currentDurationMs
                val playingToReport = isRemotePlaying
                postToMain {
                    if (sessionEpoch.get() == myEpoch) {
                        listener?.onProgressUpdated(device, posToReport, durToReport, playingToReport)
                    }
                }

                // Natural EOF detection when TV reaches end of movie and enters STOPPED
                if (hasSeenPlayingState &&
                    transportState == "STOPPED" &&
                    durToReport > 30_000L &&
                    maxObservedPosMs >= (durToReport - 15_000L)
                ) {
                    Log.i(TAG, "🏁 Natural DLNA playback end detected on ${device.friendlyName}")
                    activeDevice = null
                    isRemotePlaying = false
                    isAwaitingInitialSeek = false
                    isCurrentSessionLiveTranscode = false
                    currentBaseOffsetMs = 0L
                    postToMain {
                        listener?.onPlaybackEndedNaturally(device, maxObservedPosMs, durToReport)
                    }
                    break
                }
            }
        }
    }

    private fun executeResilientSetUri(
        device: DlnaDevice,
        streamUrl: String,
        title: String,
        mimeType: String,
        fileSizeBytes: Long,
        durationHintMs: Long,
        subtitleSrtUrl: String?,
        isLiveTranscode: Boolean = false
    ): SoapCallResult {
        if (isLiveTranscode) {
            val liveTsFlags = if (device.isLegacySamsungOrsay) {
                DlnaSoapBuilder.DLNA_ORSAY_LIVE_TS_FLAGS
            } else {
                DlnaSoapBuilder.DLNA_LIVE_TS_FLAGS
            }
            val genericLiveFlags = if (device.isLegacySamsungOrsay) {
                DlnaSoapBuilder.DLNA_ORSAY_GENERIC_LIVE_FLAGS
            } else {
                DlnaSoapBuilder.DLNA_GENERIC_LIVE_FLAGS
            }
            // Tier 1: 188-byte ISO MPEG-TS with standard video/mp2t + DLNA.ORG_OP=01
            val didlTs1 = DlnaSoapBuilder.buildDidlLiteMetadata(
                streamUrl = streamUrl,
                title = title,
                mimeType = mimeType.ifBlank { "video/mp2t" },
                fileSizeBytes = fileSizeBytes,
                durationMs = durationHintMs,
                subtitleSrtUrl = null,
                dlnaFlags = liveTsFlags
            )
            val res1 = sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "SetAVTransportURI",
                soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, didlTs1)
            )
            if (res1.success) return res1

            // Tier 2: DLNA Certified MPEG-TS MIME alias (video/vnd.dlna.mpeg-tts)
            Log.w(TAG, "Live TS SetAVTransportURI Tier 1 failed (${res1.errorDetail}), retrying with video/vnd.dlna.mpeg-tts...")
            val didlTs2 = DlnaSoapBuilder.buildDidlLiteMetadata(
                streamUrl = streamUrl,
                title = title,
                mimeType = "video/vnd.dlna.mpeg-tts",
                fileSizeBytes = fileSizeBytes,
                durationMs = durationHintMs,
                subtitleSrtUrl = null,
                dlnaFlags = liveTsFlags
            )
            val res2 = sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "SetAVTransportURI",
                soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, didlTs2)
            )
            if (res2.success) return res2

            // Tier 3: Universal MPEG MIME alias (video/mpeg) + generic live streaming flags
            Log.w(TAG, "Live TS SetAVTransportURI Tier 2 failed (${res2.errorDetail}), retrying with video/mpeg...")
            val didlTs3 = DlnaSoapBuilder.buildDidlLiteMetadata(
                streamUrl = streamUrl,
                title = title,
                mimeType = "video/mpeg",
                fileSizeBytes = fileSizeBytes,
                durationMs = durationHintMs,
                subtitleSrtUrl = null,
                dlnaFlags = genericLiveFlags
            )
            val res3 = sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "SetAVTransportURI",
                soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, didlTs3)
            )
            if (res3.success) return res3

            // Tier 4: Minimal empty CurrentURIMetaData fallback
            Log.w(TAG, "Live TS SetAVTransportURI Tier 3 failed (${res3.errorDetail}), retrying with empty metadata...")
            return sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "SetAVTransportURI",
                soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, "")
            )
        }

        val dlnaFlags = if (device.isLegacySamsungOrsay || mimeType.equals("video/x-mkv", ignoreCase = true)) {
            DlnaSoapBuilder.DLNA_ORSAY_STREAMING_FLAGS
        } else {
            DlnaSoapBuilder.DLNA_STREAMING_FLAGS
        }

        // Tier 1: Rich DIDL-Lite with detected MIME (e.g. video/x-matroska, video/x-mkv, or video/mp4)
        val didlPrimary = DlnaSoapBuilder.buildDidlLiteMetadata(
            streamUrl = streamUrl,
            title = title,
            mimeType = mimeType,
            fileSizeBytes = fileSizeBytes,
            durationMs = durationHintMs,
            subtitleSrtUrl = subtitleSrtUrl,
            dlnaFlags = dlnaFlags
        )
        val res1 = sendSoapAction(
            client = controlHttpClient,
            controlUrl = device.avTransportControlUrl,
            action = "SetAVTransportURI",
            soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, didlPrimary)
        )
        if (res1.success) return res1

        // Tier 2: Legacy Samsung MKV MIME alias (video/x-mkv)
        if (mimeType.contains("matroska", ignoreCase = true)) {
            Log.w(TAG, "SetAVTransportURI Tier 1 failed (${res1.errorDetail}), retrying with video/x-mkv...")
            val didlMkvAlias = DlnaSoapBuilder.buildDidlLiteMetadata(
                streamUrl = streamUrl,
                title = title,
                mimeType = "video/x-mkv",
                fileSizeBytes = fileSizeBytes,
                durationMs = durationHintMs,
                subtitleSrtUrl = subtitleSrtUrl,
                dlnaFlags = DlnaSoapBuilder.DLNA_ORSAY_STREAMING_FLAGS
            )
            val res2 = sendSoapAction(
                client = controlHttpClient,
                controlUrl = device.avTransportControlUrl,
                action = "SetAVTransportURI",
                soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, didlMkvAlias)
            )
            if (res2.success) return res2
        }

        // Tier 3: Minimal empty CurrentURIMetaData fallback
        Log.w(TAG, "SetAVTransportURI DIDL failed (${res1.errorDetail}), retrying with empty metadata...")
        return sendSoapAction(
            client = controlHttpClient,
            controlUrl = device.avTransportControlUrl,
            action = "SetAVTransportURI",
            soapXml = DlnaSoapBuilder.buildSetAvTransportUriSoap(streamUrl, "")
        )
    }

    private fun syncRenderingControlSubtitles(
        device: DlnaDevice,
        myEpoch: Long,
        wantSubtitlesEnabled: Boolean,
        attempt: Int
    ): Boolean {
        val rcUrl = device.renderingControlUrl?.takeIf { it.isNotBlank() } ?: return true
        if (sessionEpoch.get() != myEpoch) return true

        val allowedRes = sendSoapAction(
            client = pollHttpClient,
            controlUrl = rcUrl,
            action = "GetAllowedTransforms",
            soapXml = DlnaSoapBuilder.buildGetAllowedTransformsSoap(),
            serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
        )
        if (!allowedRes.success) {
            // UPnP 401 Invalid Action means this TV does not implement GetAllowedTransforms (e.g. Samsung/LG)
            if (allowedRes.errorDetail.contains("401")) {
                return true
            }
            return false
        }

        val allowed = UpnpXmlParser.parseAllowedTransformsResponse(allowedRes.responseXml) ?: return false
        if (!wantSubtitlesEnabled) {
            val offSoap = DlnaSoapBuilder.buildSetTransformsSoap("Subtitle", DlnaSoapBuilder.DLNA_SUBTITLE_OFF_VALUE)
            // Send Subtitle=OFF twice so if Philips Android TV's VideoPlayerActivity had SET_TRANSFORM_PROGRESS=true
            // stuck from a prior Codepage transform, the first call clears the flag and the second call applies OFF.
            sendSoapAction(
                client = renderingControlHttpClient,
                controlUrl = rcUrl,
                action = "SetTransforms",
                soapXml = offSoap,
                serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
            )
            if (sessionEpoch.get() != myEpoch) return true
            val offRes = sendSoapAction(
                client = renderingControlHttpClient,
                controlUrl = rcUrl,
                action = "SetTransforms",
                soapXml = offSoap,
                serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
            )
            Log.i(
                TAG,
                "💬 DLNA RenderingControl SetTransforms(Subtitle=OFF, attempt=$attempt, allowed=${allowed.subtitleValues.size}) on ${device.friendlyName} -> ok=${offRes.success}"
            )
            // If the TV's player has not finished onPrepared / populated subtitleValues yet, keep polling up to attempt 6
            // so we ALSO re-send Subtitle_[0] right after onPrepared finishes (preventing embedded MKV auto-selection).
            if (allowed.subtitleValues.isEmpty() && attempt < 6) {
                return false
            }
            return true
        }

        if (allowed.subtitleValues.isEmpty()) {
            // TV's ExoPlayer has not finished onPrepared / populated mSubtitleCache yet; retry on next poll
            return false
        }

        // Send X_Philips.com_Codepage=UTF-8 BEFORE Subtitle!
        // In Philips Android TV's VideoPlayerActivity.setTransform(type, val), type=102 (Codepage) sets
        // SET_TRANSFORM_PROGRESS=true and never resets it, whereas type=101 (Subtitle) resets
        // SET_TRANSFORM_PROGRESS=false via Handler(what=5). Sending Codepage first and then sending
        // Subtitle twice guarantees the first Subtitle call clears SET_TRANSFORM_PROGRESS=false and
        // the second Subtitle call executes selectDLNASubtitleTrack(0) and resets SET_TRANSFORM_PROGRESS=false.
        val utf8Value = allowed.codepageValues.firstOrNull {
            it.equals("UTF-8", ignoreCase = true) || it.equals("UTF8", ignoreCase = true)
        }
        if (utf8Value != null) {
            val cpRes = sendSoapAction(
                client = renderingControlHttpClient,
                controlUrl = rcUrl,
                action = "SetTransforms",
                soapXml = DlnaSoapBuilder.buildSetTransformsSoap("X_Philips.com_Codepage", utf8Value),
                serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
            )
            Log.i(
                TAG,
                "🔤 DLNA RenderingControl SetTransforms(Codepage='$utf8Value') on ${device.friendlyName} -> ok=${cpRes.success}"
            )
        }

        if (sessionEpoch.get() != myEpoch) return true

        // MatroskaEbmlTrackPatcher + ClusterBlockSwapper always place the user-selected subtitle track
        // at index 0 of <Tracks>, so allowed.subtitleValues.first() is always the exact chosen track.
        val targetSubValue = allowed.subtitleValues.first()
        val subSoap = DlnaSoapBuilder.buildSetTransformsSoap("Subtitle", targetSubValue)
        val subRes1 = sendSoapAction(
            client = pollHttpClient,
            controlUrl = rcUrl,
            action = "SetTransforms",
            soapXml = subSoap,
            serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
        )
        if (sessionEpoch.get() != myEpoch) return true
        val subRes2 = sendSoapAction(
            client = renderingControlHttpClient,
            controlUrl = rcUrl,
            action = "SetTransforms",
            soapXml = subSoap,
            serviceType = DlnaSoapBuilder.RENDERING_CONTROL_SERVICE_TYPE
        )
        val subSuccess = subRes1.success || subRes2.success
        Log.i(
            TAG,
            "💬 DLNA RenderingControl SetTransforms(Subtitle='$targetSubValue') on ${device.friendlyName} -> ok=$subSuccess (${subRes2.errorDetail})"
        )
        return subSuccess
    }

    private data class SoapCallResult(
        val success: Boolean,
        val httpCode: Int,
        val responseXml: String,
        val errorDetail: String = ""
    )

    private fun sendSoapAction(
        client: OkHttpClient,
        controlUrl: String,
        action: String,
        soapXml: String,
        serviceType: String = DlnaSoapBuilder.AV_TRANSPORT_SERVICE_TYPE
    ): SoapCallResult {
        return try {
            val req = Request.Builder()
                .url(controlUrl)
                .header("Content-Type", "text/xml; charset=\"utf-8\"")
                .header("SOAPAction", "\"$serviceType#$action\"")
                .header("User-Agent", "Android/14 UPnP/1.1 Cineflix/1.4")
                .header("Connection", "close")
                .post(soapXml.toRequestBody(XML_MEDIA_TYPE))
                .build()

            client.newCall(req).execute().use { resp ->
                val bodyStr = resp.body?.string().orEmpty()
                if (resp.isSuccessful) {
                    SoapCallResult(true, resp.code, bodyStr)
                } else {
                    val upnpErr = UpnpXmlParser.parseUpnpErrorCode(bodyStr)
                    val detail = if (upnpErr != null) "UPnP $upnpErr" else "HTTP ${resp.code}"
                    SoapCallResult(false, resp.code, bodyStr, detail)
                }
            }
        } catch (e: Exception) {
            SoapCallResult(false, -1, "", e.message ?: e.javaClass.simpleName)
        }
    }
}
