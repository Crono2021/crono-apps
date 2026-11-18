package com.cineflix.android.ui.player

import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.util.LruCache
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.cineflix.android.util.StorageAndRamHygiene
import org.json.JSONArray
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URLEncoder
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Synchronized Credits Continuity & Pay-TV Squeeze-Back Controller for `PlayerActivity`.
 *
 * Implements Cineflix's 3-Lock Verified Credits Engine + 16:9 (~58% screen) Squeeze-Back frame:
 *  - Never cuts without a verified credits mark (`episode_metadata` or `TheIntroDB`).
 *  - Lock 1: `creditsStartSec` must fall in the final 15–18% of `realDurationSec` (`>= 82%`).
 *  - Lock 2 (anti post-credits Marvel/Pixar/Anime): if `realDurationSec - creditsEndSec > 20s`
 *    or server flagged mid/post-credits, NEVER trim; squeeze during credits and expand back to
 *    100% fullscreen for the post-credits scene itself.
 *  - Lock 3: always leave `+15s` musical buffer after `creditsStartSec` before ending the slot.
 *  - Zero SurfaceView Z-order conflict: resizes `videoSurface` into the top-left 16:9 (~58%)
 *    window and places non-overlapping Continuity (`⏭ A CONTINUACIÓN`) & Live Zapping
 *    (`🔥 AHORA EN OTROS CANALES`) panels around it with a transparent-center gold frame.
 */
class LiveTvSqueezeBackController(
    private val activity: Activity,
    private val rootContainer: FrameLayout,
    private val videoSurface: View,
    private val descriptor: LiveSlotDescriptor,
    private val onRequestPreloadNext: (channelId: String) -> Unit,
    private val onZapToChannel: (channelId: String) -> Unit,
    private val onSqueezeVisibilityChanged: (visible: Boolean) -> Unit = {}
) {

    data class LiveSlotDescriptor(
        val channelId: String,
        val mediaType: String, // "movie" | "tv"
        val itemId: String,
        val tmdbId: Int,
        val season: Int,
        val episode: Int,
        val isKidsProfile: Boolean,
        val isPremiereChannel: Boolean,
        val manualCreditsStartSec: Int?,
        val introDbCreditsMs: Long?,
        val initialContinuityJson: String,
        val initialUpNextJson: String,
        val initialOtherChannelsJson: String
    )

    data class ContinuityPlan(
        val broadcastDurationSec: Int,
        val realDurationSec: Int,
        val creditsStartSec: Int?,
        val creditsEndSec: Int?,
        val creditsTrimmed: Boolean,
        val hasPostCredits: Boolean,
        val creditsVerified: Boolean,
        val lockStatus: String,
        val squeezeStartSec: Int?,
        val squeezeEndSec: Int?,
        val postCreditsSceneStartSec: Int?,
        val finalTailSqueezeStartSec: Int?
    )

    data class UpNextSummary(
        val mediaType: String,
        val tmdbId: Int,
        val season: Int,
        val episode: Int,
        val epCode: String,
        val title: String,
        val year: String,
        val rating: String,
        val overview: String,
        val posterPath: String,
        val logoPath: String = "",
        val castLine: String = "",
        val episodeName: String = ""
    )

    data class OtherChannelCardData(
        val channelId: String,
        val number: Int,
        val name: String,
        val icon: String,
        val programTitle: String,
        val progressPct: Int,
        val remainingMin: Int,
        val viewers: Int
    )

    data class SqueezeGeometry(
        val padX: Int,
        val padY: Int,
        val gap: Int,
        val videoLeft: Int,
        val videoTop: Int,
        val videoWidth: Int,
        val videoHeight: Int,
        val rightLeft: Int,
        val rightTop: Int,
        val rightWidth: Int,
        val rightHeight: Int,
        val bottomLeft: Int,
        val bottomTop: Int,
        val bottomWidth: Int,
        val bottomHeight: Int
    )

    companion object {
        private const val TAG = "LiveTvSqueezeBack"
        private const val API_BASE = "https://cineflixapp.duckdns.org"
        internal const val CREDITS_MIN_RATIO = 0.82
        internal const val POST_CREDITS_GAP_SEC = 20
        internal const val CREDITS_BUFFER_SEC = 15

        internal fun evaluateContinuityPlan(
            serverContinuityJson: String?,
            realDurationSec: Int,
            mediaType: String,
            manualCreditsStartSec: Int? = null,
            introDbCreditsMs: Long? = null
        ): ContinuityPlan {
            val srvObj = if (!serverContinuityJson.isNullOrBlank()) {
                runCatching { JSONObject(serverContinuityJson) }.getOrNull()
            } else null

            val resolvedRealDur = when {
                realDurationSec in 300..28800 -> realDurationSec
                srvObj != null && srvObj.optInt("realDurationSec", 0) in 300..28800 ->
                    srvObj.optInt("realDurationSec", 0)
                else -> 0
            }

            if (resolvedRealDur < 300) {
                val fallbackDur = srvObj?.optInt("broadcastDurationSec", 0)?.takeIf { it >= 300 } ?: 0
                return ContinuityPlan(
                    broadcastDurationSec = fallbackDur,
                    realDurationSec = 0,
                    creditsStartSec = null,
                    creditsEndSec = null,
                    creditsTrimmed = false,
                    hasPostCredits = false,
                    creditsVerified = false,
                    lockStatus = "no_real_duration",
                    squeezeStartSec = null,
                    squeezeEndSec = null,
                    postCreditsSceneStartSec = null,
                    finalTailSqueezeStartSec = null
                )
            }

            // Lock 1: credits_start must fall in the final 15–18% of realDurationSec (>= 82%)
            val minCreditsStartSec = floor(resolvedRealDur * CREDITS_MIN_RATIO).toInt()
            val maxCreditsStartSec = resolvedRealDur - 6
            val isTv = mediaType.equals("tv", ignoreCase = true)
            val unverifiedTail = if (isTv || resolvedRealDur < 3300) 30 else 45
            val defaultSqzStart = max(60, resolvedRealDur - unverifiedTail)

            val srvVerified = srvObj?.optBoolean("creditsVerified", false) == true
            val srvStart = srvObj?.takeIf { !it.isNull("creditsStartSec") }?.optInt("creditsStartSec", 0)?.takeIf { it > 0 }
            val srvEnd = srvObj?.takeIf { !it.isNull("creditsEndSec") }?.optInt("creditsEndSec", 0)?.takeIf { it > 0 }
            val srvHasPost = srvObj?.optBoolean("hasPostCredits", false) == true
            val srvFinalTail = srvObj?.takeIf { !it.isNull("finalTailSqueezeStartSec") }
                ?.optInt("finalTailSqueezeStartSec", 0)?.takeIf { it > 0 }

            var rejectedLock1 = false
            var candidateStart: Int? = null
            var serverAuthorizedCut = false

            if (srvVerified && srvStart != null) {
                if (srvStart in minCreditsStartSec..maxCreditsStartSec) {
                    candidateStart = srvStart
                    serverAuthorizedCut = true
                } else {
                    rejectedLock1 = true
                }
            }
            if (candidateStart == null && manualCreditsStartSec != null && manualCreditsStartSec > 0) {
                if (manualCreditsStartSec in minCreditsStartSec..maxCreditsStartSec) {
                    candidateStart = manualCreditsStartSec
                } else {
                    rejectedLock1 = true
                }
            }
            if (candidateStart == null && introDbCreditsMs != null && introDbCreditsMs > 0L) {
                val idbSec = (introDbCreditsMs / 1000L).toInt()
                if (idbSec in minCreditsStartSec..maxCreditsStartSec) {
                    candidateStart = idbSec
                } else {
                    rejectedLock1 = true
                }
            }

            if (candidateStart != null) {
                // Reject edition mismatch if external credits_end exceeds physical realDurationSec by >30s
                if (srvEnd != null && srvEnd > resolvedRealDur + 30) {
                    return ContinuityPlan(
                        broadcastDurationSec = resolvedRealDur,
                        realDurationSec = resolvedRealDur,
                        creditsStartSec = null,
                        creditsEndSec = null,
                        creditsTrimmed = false,
                        hasPostCredits = false,
                        creditsVerified = false,
                        lockStatus = "rejected_edition_mismatch",
                        squeezeStartSec = defaultSqzStart,
                        squeezeEndSec = resolvedRealDur,
                        postCreditsSceneStartSec = null,
                        finalTailSqueezeStartSec = null
                    )
                }

                // Lock 2: anti post-credits (>20s left after credits_end or server flagged post/mid-credits)
                val hasPostAfterEnd = srvEnd != null && (resolvedRealDur - srvEnd) > POST_CREDITS_GAP_SEC
                val hasPostCredits = srvHasPost || hasPostAfterEnd
                if (hasPostCredits) {
                    val sceneStart = if (srvEnd != null && srvEnd > candidateStart && (resolvedRealDur - srvEnd) > POST_CREDITS_GAP_SEC) {
                        min(resolvedRealDur, srvEnd)
                    } else null
                    val tailStart = srvFinalTail ?: max(sceneStart ?: 0, resolvedRealDur - 18)
                    return ContinuityPlan(
                        broadcastDurationSec = resolvedRealDur,
                        realDurationSec = resolvedRealDur,
                        creditsStartSec = candidateStart,
                        creditsEndSec = srvEnd,
                        creditsTrimmed = false,
                        hasPostCredits = true,
                        creditsVerified = true,
                        lockStatus = "blocked_lock2_post_credits",
                        squeezeStartSec = candidateStart,
                        squeezeEndSec = sceneStart ?: resolvedRealDur,
                        postCreditsSceneStartSec = sceneStart,
                        finalTailSqueezeStartSec = tailStart.takeIf { it < resolvedRealDur }
                    )
                }

                // Only cut when server EPG continuity verified the mark (prevents cutting local-only
                // introDbCreditsMs lacking credits_end before /api/live-tv/report-timing responds)
                if (serverAuthorizedCut) {
                    val maxUnboundedTail = if (isTv) 300 else 780
                    if (srvEnd == null && (resolvedRealDur - candidateStart) > maxUnboundedTail) {
                        return ContinuityPlan(
                            broadcastDurationSec = resolvedRealDur,
                            realDurationSec = resolvedRealDur,
                            creditsStartSec = null,
                            creditsEndSec = null,
                            creditsTrimmed = false,
                            hasPostCredits = false,
                            creditsVerified = false,
                            lockStatus = "blocked_unbounded_credits_tail",
                            squeezeStartSec = defaultSqzStart,
                            squeezeEndSec = resolvedRealDur,
                            postCreditsSceneStartSec = null,
                            finalTailSqueezeStartSec = null
                        )
                    }
                    // Lock 3: always leave +15s musical buffer after credits_start
                    val trimmedEnd = min(resolvedRealDur, candidateStart + CREDITS_BUFFER_SEC)
                    val didTrim = trimmedEnd < resolvedRealDur
                    return ContinuityPlan(
                        broadcastDurationSec = trimmedEnd,
                        realDurationSec = resolvedRealDur,
                        creditsStartSec = candidateStart,
                        creditsEndSec = srvEnd,
                        creditsTrimmed = didTrim,
                        hasPostCredits = false,
                        creditsVerified = true,
                        lockStatus = if (didTrim) "trimmed_verified_3locks" else "credits_within_buffer",
                        squeezeStartSec = if (didTrim) candidateStart else max(60, resolvedRealDur - 20),
                        squeezeEndSec = trimmedEnd,
                        postCreditsSceneStartSec = null,
                        finalTailSqueezeStartSec = null
                    )
                }

                // Local-only mark while awaiting server confirmation: Squeeze-Back visually without cutting early
                return ContinuityPlan(
                    broadcastDurationSec = resolvedRealDur,
                    realDurationSec = resolvedRealDur,
                    creditsStartSec = candidateStart,
                    creditsEndSec = null,
                    creditsTrimmed = false,
                    hasPostCredits = false,
                    creditsVerified = false,
                    lockStatus = "local_mark_awaiting_server",
                    squeezeStartSec = candidateStart,
                    squeezeEndSec = resolvedRealDur,
                    postCreditsSceneStartSec = null,
                    finalTailSqueezeStartSec = null
                )
            }

            return ContinuityPlan(
                broadcastDurationSec = resolvedRealDur,
                realDurationSec = resolvedRealDur,
                creditsStartSec = null,
                creditsEndSec = null,
                creditsTrimmed = false,
                hasPostCredits = false,
                creditsVerified = false,
                lockStatus = if (rejectedLock1) "rejected_lock1_early" else "no_verified_mark",
                squeezeStartSec = defaultSqzStart,
                squeezeEndSec = resolvedRealDur,
                postCreditsSceneStartSec = null,
                finalTailSqueezeStartSec = null
            )
        }

        internal fun isInSqueezeWindow(playheadSec: Int, plan: ContinuityPlan): Boolean {
            if (plan.realDurationSec < 300) return false
            val sStart = plan.squeezeStartSec
            val sEnd = plan.squeezeEndSec
            if (sStart != null && sEnd != null && playheadSec >= sStart && playheadSec < sEnd) {
                return true
            }
            val tailStart = plan.finalTailSqueezeStartSec
            if (plan.hasPostCredits && tailStart != null && playheadSec >= tailStart && playheadSec < plan.broadcastDurationSec) {
                return true
            }
            return false
        }

        internal fun shouldTriggerSynchronizedCut(playheadSec: Int, plan: ContinuityPlan): Boolean {
            return plan.creditsTrimmed && plan.broadcastDurationSec >= 300 && playheadSec >= plan.broadcastDurationSec
        }

        internal fun computeSqueezeGeometry(
            containerWidthPx: Int,
            containerHeightPx: Int,
            padXPx: Int,
            padYPx: Int,
            gapPx: Int,
            compactHeight: Boolean = false
        ): SqueezeGeometry {
            val cw = max(320, containerWidthPx)
            val ch = max(240, containerHeightPx)
            val widthRatio = if (compactHeight) 0.54f else 0.58f
            val maxHeightRatio = if (compactHeight) 0.53f else 0.59f
            var vidW = (cw * widthRatio).roundToInt()
            var vidH = (vidW * 9f / 16f).roundToInt()
            val maxVidH = (ch * maxHeightRatio).roundToInt()
            if (vidH > maxVidH) {
                vidH = maxVidH
                vidW = (vidH * 16f / 9f).roundToInt()
            }
            val rightLeft = padXPx + vidW + gapPx
            val rightWidth = max(140, cw - rightLeft - padXPx)
            val bottomTop = padYPx + vidH + gapPx
            val bottomHeight = max(72, ch - bottomTop - padYPx)
            return SqueezeGeometry(
                padX = padXPx,
                padY = padYPx,
                gap = gapPx,
                videoLeft = padXPx,
                videoTop = padYPx,
                videoWidth = vidW,
                videoHeight = vidH,
                rightLeft = rightLeft,
                rightTop = padYPx,
                rightWidth = rightWidth,
                rightHeight = vidH,
                bottomLeft = padXPx,
                bottomTop = bottomTop,
                bottomWidth = max(200, cw - padXPx * 2),
                bottomHeight = bottomHeight
            )
        }

        internal fun parseUpNextJson(rawJson: String?): UpNextSummary? {
            if (rawJson.isNullOrBlank()) return null
            return runCatching {
                val root = JSONObject(rawJson)
                val mv = root.optJSONObject("movie") ?: root
                val rawTitle = mv.optString("tmdb_name", "").ifBlank { mv.optString("title", "") }
                    .replace(Regex("\\s*\\(\\d{4}\\)\\s*$"), "")
                    .trim()
                if (rawTitle.isBlank()) return null
                val mType = mv.optString("media_type", "movie")
                val rat = mv.optDouble("tmdb_rating", 0.0)
                UpNextSummary(
                    mediaType = mType,
                    tmdbId = mv.optInt("tmdb_id", 0),
                    season = max(1, mv.optInt("season", 1)),
                    episode = max(1, mv.optInt("episode", 1)),
                    epCode = mv.optString("ep_code", ""),
                    title = rawTitle,
                    year = mv.optString("year", "").takeIf { it != "null" }.orEmpty(),
                    rating = if (rat > 0.0) String.format(java.util.Locale.US, "★ %.1f", rat) else "",
                    overview = mv.optString("tmdb_overview", "").takeIf { it != "null" }.orEmpty(),
                    posterPath = mv.optString("tmdb_poster", "").ifBlank { mv.optString("tmdb_backdrop", "") }
                        .takeIf { it != "null" }.orEmpty()
                )
            }.getOrNull()
        }

        internal fun parseOtherChannelsJson(rawJson: String?): List<OtherChannelCardData> {
            if (rawJson.isNullOrBlank()) return emptyList()
            return runCatching {
                val arr = JSONArray(rawJson)
                val out = mutableListOf<OtherChannelCardData>()
                for (i in 0 until min(3, arr.length())) {
                    val o = arr.optJSONObject(i) ?: continue
                    val cid = o.optString("channelId", "")
                    if (cid.isBlank()) continue
                    out.add(
                        OtherChannelCardData(
                            channelId = cid,
                            number = o.optInt("number", 0),
                            name = o.optString("name", ""),
                            icon = o.optString("icon", ""),
                            programTitle = o.optString("programTitle", ""),
                            progressPct = o.optInt("progressPct", 20).coerceIn(2, 100),
                            remainingMin = max(1, o.optInt("remainingMin", 15)),
                            viewers = max(0, o.optInt("viewers", 0))
                        )
                    )
                }
                out
            }.getOrDefault(emptyList())
        }
    }

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())
    private val mainHandler = Handler(Looper.getMainLooper())
    private val posterCache = object : LruCache<String, Bitmap>(6) {
        override fun entryRemoved(evicted: Boolean, key: String?, oldValue: Bitmap?, newValue: Bitmap?) {}
    }

    @Volatile private var serverContinuityJson: String = descriptor.initialContinuityJson
    @Volatile private var currentPlan: ContinuityPlan = evaluateContinuityPlan(
        serverContinuityJson = descriptor.initialContinuityJson,
        realDurationSec = 0,
        mediaType = descriptor.mediaType,
        manualCreditsStartSec = descriptor.manualCreditsStartSec,
        introDbCreditsMs = descriptor.introDbCreditsMs
    )
    private var upNextSummary: UpNextSummary? = parseUpNextJson(descriptor.initialUpNextJson)
    private var otherChannels: List<OtherChannelCardData> = parseOtherChannelsJson(descriptor.initialOtherChannelsJson)

    private var durationReported = false
    private var reportInFlight = false
    private var reportRetryAfterElapsedMs = 0L
    private var preCreditsContinuitySynced = false
    private var epgRefreshed = false
    private var preloadRequested = false
    private var preloadStatusMessage: String = "⏳ Precargando siguiente emisión en 2º plano…"
    private var cutDispatched = false
    private var isSqueezed = false
    private var isDestroyed = false
    private var lastLayoutCw = 0
    private var lastLayoutCh = 0
    private var lastLayoutCompact = false
    private var lastKnownRealDurSec = 0

    private var surfaceAnimator: ValueAnimator? = null
    private var overlayRoot: FrameLayout? = null
    private var videoBorderFrame: View? = null
    private var liveAudioBadge: TextView? = null
    private var rightPanel: LinearLayout? = null
    private var bottomStrip: LinearLayout? = null
    private var stripHeaderTv: TextView? = null
    private var tvCountdown: TextView? = null
    private var tvPostCreditsBadge: TextView? = null
    private var ivNextPoster: ImageView? = null
    private var ivNextLogo: ImageView? = null
    private var tvNextTitle: TextView? = null
    private var tvNextSub: TextView? = null
    private var tvNextSynopsis: TextView? = null
    private var tvNextCast: TextView? = null
    private var tvPreloadStatus: TextView? = null
    private var channelCardsRow: LinearLayout? = null
    private val channelCardViews = mutableListOf<View>()

    fun isSqueezeVisible(): Boolean = isSqueezed && overlayRoot?.visibility == View.VISIBLE

    fun hasSqueezeFocus(): Boolean {
        if (!isSqueezeVisible()) return false
        val focused = activity.currentFocus ?: return false
        return channelCardViews.any { it === focused }
    }

    fun focusFirstChannelCardIfAvailable(): Boolean {
        if (!isSqueezeVisible()) return false
        val first = channelCardViews.firstOrNull { it.visibility == View.VISIBLE } ?: return false
        return first.requestFocus()
    }

    /**
     * Evaluates the effective broadcast end in milliseconds once the real container duration is known,
     * allowing `PlayerActivity` to detect if an uncalibrated EPG fallback offset is already past EOF.
     */
    fun resolveEffectiveBroadcastEndMs(realDurationMs: Long): Long {
        val realDurSec = if (realDurationMs in 300_000L..28_800_000L) (realDurationMs / 1000L).toInt() else 0
        if (realDurSec < 300) return realDurationMs.coerceAtLeast(0L)
        lastKnownRealDurSec = realDurSec
        val plan = evaluateContinuityPlan(
            serverContinuityJson = serverContinuityJson,
            realDurationSec = realDurSec,
            mediaType = descriptor.mediaType,
            manualCreditsStartSec = descriptor.manualCreditsStartSec,
            introDbCreditsMs = descriptor.introDbCreditsMs
        )
        currentPlan = plan
        return if (plan.creditsTrimmed && plan.broadcastDurationSec >= 300) {
            plan.broadcastDurationSec * 1000L
        } else {
            realDurationMs
        }
    }

    /**
     * Synchronously reports `realDurSec` to `/api/live-tv/report-timing` on an IO thread (bounded by 1.5s)
     * so `server.js` immediately updates the slot length and rotates past-EOF slots before advancing!
     */
    fun reportTimingBlockingIo(realDurSec: Int) {
        if (realDurSec !in 300..28800 || descriptor.itemId.isBlank()) return
        var conn: HttpURLConnection? = null
        try {
            conn = StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/live-tv/report-timing").apply {
                requestMethod = "POST"
                connectTimeout = 1400
                readTimeout = 1500
                doOutput = true
                setRequestProperty("Content-Type", "application/json; charset=UTF-8")
            }
            val payload = JSONObject().apply {
                put("media_type", descriptor.mediaType)
                put("id", descriptor.itemId)
                put("tmdb_id", descriptor.tmdbId)
                put("season", descriptor.season)
                put("episode", descriptor.episode)
                put("duration_sec", realDurSec)
                put("channel_id", descriptor.channelId)
            }.toString()
            OutputStreamWriter(conn.outputStream, Charsets.UTF_8).use { it.write(payload) }
            if (conn.responseCode in 200..299) {
                val respStr = conn.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
                runCatching {
                    val obj = JSONObject(respStr)
                    if (obj.optBoolean("ok", false)) {
                        durationReported = true
                        obj.optJSONObject("continuity")?.let { contObj ->
                            serverContinuityJson = contObj.toString()
                        }
                    }
                }
            }
        } catch (_: Throwable) {
        } finally {
            runCatching { conn?.disconnect() }
        }
    }

    /**
     * Called once per second from `PlayerActivity.updateSeekBar()`.
     * Returns `true` when the synchronized broadcast end (`credits_start + 15s`) is reached
     * and `PlayerActivity` should immediately advance to the next program.
     */
    fun onPlaybackTick(positionMs: Long, durationMs: Long, isInPipMode: Boolean): Boolean {
        if (isDestroyed) return false
        val realDurSec = if (durationMs in 300_000L..28_800_000L) (durationMs / 1000L).toInt() else 0
        if (realDurSec >= 300) {
            lastKnownRealDurSec = realDurSec
        }
        val nowElapsed = android.os.SystemClock.elapsedRealtime()
        if (realDurSec >= 300 && !durationReported && !reportInFlight && nowElapsed >= reportRetryAfterElapsedMs) {
            reportTimingToServerAsync(realDurSec)
        }

        val playheadSec = max(0, (positionMs / 1000L).toInt())
        if (realDurSec >= 300 && !preCreditsContinuitySynced && playheadSec >= floor(realDurSec * 0.79).toInt()) {
            preCreditsContinuitySynced = true
            syncActiveChannelContinuityFromEpgAsync(realDurSec)
        }

        currentPlan = evaluateContinuityPlan(
            serverContinuityJson = serverContinuityJson,
            realDurationSec = realDurSec,
            mediaType = descriptor.mediaType,
            manualCreditsStartSec = descriptor.manualCreditsStartSec,
            introDbCreditsMs = descriptor.introDbCreditsMs
        )

        if (!cutDispatched && shouldTriggerSynchronizedCut(playheadSec, currentPlan)) {
            cutDispatched = true
            restoreFullscreenImmediate()
            return true
        }

        if (currentPlan.broadcastDurationSec >= 300) {
            val remToCut = currentPlan.broadcastDurationSec - playheadSec
            if (remToCut in 1..24) {
                triggerPreloadAndFreshEpgOnce()
            }
        }

        if (isInPipMode) {
            if (isSqueezed) restoreFullscreenImmediate()
            return false
        }

        if (isInSqueezeWindow(playheadSec, currentPlan)) {
            triggerPreloadAndFreshEpgOnce()
            val remSec = max(1, currentPlan.broadcastDurationSec - playheadSec)
            enterOrUpdateSqueezeUi(remSec, currentPlan)
        } else if (isSqueezed) {
            exitSqueezeAnimated()
        }
        return false
    }

    fun restoreFullscreenImmediate() {
        val wasSqueezed = isSqueezed
        surfaceAnimator?.cancel()
        surfaceAnimator = null
        isSqueezed = false
        lastLayoutCw = 0
        lastLayoutCh = 0
        overlayRoot?.visibility = View.GONE
        val lp = (videoSurface.layoutParams as? FrameLayout.LayoutParams)
            ?: FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        lp.width = FrameLayout.LayoutParams.MATCH_PARENT
        lp.height = FrameLayout.LayoutParams.MATCH_PARENT
        lp.leftMargin = 0
        lp.topMargin = 0
        lp.rightMargin = 0
        lp.bottomMargin = 0
        lp.gravity = Gravity.CENTER
        videoSurface.layoutParams = lp
        if (wasSqueezed && !isDestroyed) {
            onSqueezeVisibilityChanged(false)
        }
    }

    fun destroy() {
        if (isDestroyed) return
        isDestroyed = true
        mainHandler.removeCallbacksAndMessages(null)
        restoreFullscreenImmediate()
        overlayRoot?.let { rootContainer.removeView(it) }
        overlayRoot = null
        channelCardViews.clear()
        posterCache.evictAll()
        scope.cancel()
    }

    private fun triggerPreloadAndFreshEpgOnce() {
        if (!preloadRequested) {
            preloadRequested = true
            preloadStatusMessage = "⏳ Precargando siguiente emisión en 2º plano…"
            tvPreloadStatus?.text = preloadStatusMessage
            onRequestPreloadNext(descriptor.channelId)
        }
        if (!epgRefreshed) {
            epgRefreshed = true
            refreshLiveEpgAndContinuityMetaAsync()
        }
    }

    private fun doesEpgMovieMatchCurrentDescriptor(mvObj: JSONObject?): Boolean {
        if (mvObj == null) return false
        val epgId = mvObj.optString("id", "").trim()
        val epgTmdb = mvObj.optInt("tmdb_id", 0)
        val sameBase = (descriptor.itemId.isNotBlank() && epgId == descriptor.itemId) ||
            (descriptor.tmdbId > 0 && epgTmdb == descriptor.tmdbId)
        if (!sameBase) return false
        if (descriptor.mediaType.equals("tv", ignoreCase = true)) {
            val s = mvObj.optInt("season", 0)
            val e = mvObj.optInt("episode", 0)
            if (descriptor.season > 0 && s > 0 && s != descriptor.season) return false
            if (descriptor.episode > 0 && e > 0 && e != descriptor.episode) return false
        }
        return true
    }

    private fun syncActiveChannelContinuityFromEpgAsync(realDurSec: Int) {
        scope.launch {
            val kidsParam = if (descriptor.isKidsProfile) "?kids=1" else ""
            val epgRaw = withContext(Dispatchers.IO) {
                httpGetText("$API_BASE/api/live-tv/epg$kidsParam")
            }
            if (isDestroyed || epgRaw.isNullOrBlank()) return@launch
            runCatching {
                val chs = JSONObject(epgRaw).optJSONArray("channels") ?: return@runCatching
                for (i in 0 until chs.length()) {
                    val c = chs.optJSONObject(i) ?: continue
                    if (c.optString("id", "") != descriptor.channelId) continue
                    val nowObj = c.optJSONObject("now") ?: break
                    if (doesEpgMovieMatchCurrentDescriptor(nowObj.optJSONObject("movie"))) {
                        nowObj.optJSONObject("continuity")?.let { contObj ->
                            serverContinuityJson = contObj.toString()
                            currentPlan = evaluateContinuityPlan(
                                serverContinuityJson = serverContinuityJson,
                                realDurationSec = realDurSec,
                                mediaType = descriptor.mediaType,
                                manualCreditsStartSec = descriptor.manualCreditsStartSec,
                                introDbCreditsMs = descriptor.introDbCreditsMs
                            )
                        }
                    }
                    break
                }
            }
        }
    }

    private fun reportTimingToServerAsync(realDurSec: Int) {
        if (descriptor.itemId.isBlank()) {
            durationReported = true
            return
        }
        reportInFlight = true
        scope.launch {
            val respStr = withContext(Dispatchers.IO) {
                var conn: HttpURLConnection? = null
                try {
                    conn = StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/live-tv/report-timing").apply {
                        requestMethod = "POST"
                        connectTimeout = 4000
                        readTimeout = 4500
                        doOutput = true
                        setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                    }
                    val payload = JSONObject().apply {
                        put("media_type", descriptor.mediaType)
                        put("id", descriptor.itemId)
                        put("tmdb_id", descriptor.tmdbId)
                        put("season", descriptor.season)
                        put("episode", descriptor.episode)
                        put("duration_sec", realDurSec)
                        put("channel_id", descriptor.channelId)
                    }.toString()
                    OutputStreamWriter(conn.outputStream, Charsets.UTF_8).use { it.write(payload) }
                    if (conn.responseCode in 200..299) {
                        conn.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
                    } else null
                } catch (_: Throwable) {
                    null
                } finally {
                    try { conn?.disconnect() } catch (_: Throwable) {}
                }
            }
            reportInFlight = false
            if (isDestroyed) return@launch
            var succeeded = false
            if (!respStr.isNullOrBlank()) {
                runCatching {
                    val obj = JSONObject(respStr)
                    if (obj.optBoolean("ok", false)) {
                        succeeded = true
                        val contObj = obj.optJSONObject("continuity")
                        if (contObj != null) {
                            serverContinuityJson = contObj.toString()
                            currentPlan = evaluateContinuityPlan(
                                serverContinuityJson = serverContinuityJson,
                                realDurationSec = realDurSec,
                                mediaType = descriptor.mediaType,
                                manualCreditsStartSec = descriptor.manualCreditsStartSec,
                                introDbCreditsMs = descriptor.introDbCreditsMs
                            )
                        }
                    }
                }
            }
            if (succeeded) {
                durationReported = true
            } else {
                reportRetryAfterElapsedMs = android.os.SystemClock.elapsedRealtime() + 15_000L
            }
        }
    }

    private fun refreshLiveEpgAndContinuityMetaAsync() {
        scope.launch {
            val kidsParam = if (descriptor.isKidsProfile) "?kids=1" else ""
            val epgRaw = withContext(Dispatchers.IO) {
                httpGetText("$API_BASE/api/live-tv/epg$kidsParam")
            }
            if (!isDestroyed && !epgRaw.isNullOrBlank()) {
                runCatching {
                    val root = JSONObject(epgRaw)
                    val chs = root.optJSONArray("channels") ?: JSONArray()
                    val freshOthers = mutableListOf<OtherChannelCardData>()
                    for (i in 0 until chs.length()) {
                        val c = chs.optJSONObject(i) ?: continue
                        val cid = c.optString("id", "")
                        if (cid == descriptor.channelId) {
                            val nowObj = c.optJSONObject("now")
                            val sameNow = doesEpgMovieMatchCurrentDescriptor(nowObj?.optJSONObject("movie"))
                            if (sameNow) {
                                nowObj?.optJSONObject("continuity")?.let { contObj ->
                                    serverContinuityJson = contObj.toString()
                                    if (lastKnownRealDurSec >= 300) {
                                        currentPlan = evaluateContinuityPlan(
                                            serverContinuityJson = serverContinuityJson,
                                            realDurationSec = lastKnownRealDurSec,
                                            mediaType = descriptor.mediaType,
                                            manualCreditsStartSec = descriptor.manualCreditsStartSec,
                                            introDbCreditsMs = descriptor.introDbCreditsMs
                                        )
                                    }
                                }
                            }
                            val candidateNextObj = if (sameNow || nowObj == null) {
                                c.optJSONArray("upNext")?.optJSONObject(0)
                            } else {
                                nowObj
                            }
                            if (candidateNextObj != null) {
                                parseUpNextJson(candidateNextObj.toString())?.let { parsed ->
                                    val prev = upNextSummary
                                    val sameNext = prev != null &&
                                        prev.tmdbId == parsed.tmdbId &&
                                        prev.season == parsed.season &&
                                        prev.episode == parsed.episode
                                    upNextSummary = if (sameNext && prev != null) {
                                        parsed.copy(
                                            logoPath = prev.logoPath,
                                            castLine = prev.castLine,
                                            episodeName = prev.episodeName,
                                            overview = prev.overview.ifBlank { parsed.overview }
                                        )
                                    } else {
                                        parsed
                                    }
                                }
                            }
                            continue
                        }
                        val nowObj = c.optJSONObject("now") ?: continue
                        val mvObj = nowObj.optJSONObject("movie") ?: continue
                        val rawT = mvObj.optString("tmdb_name", "").ifBlank { mvObj.optString("title", "") }
                            .replace(Regex("\\s*\\(\\d{4}\\)\\s*$"), "").trim()
                        val epCode = mvObj.optString("ep_code", "")
                        val dispT = if (epCode.isNotBlank()) "$epCode · $rawT" else rawT
                        val remSec = max(60, nowObj.optInt("remainingSec", 900))
                        freshOthers.add(
                            OtherChannelCardData(
                                channelId = cid,
                                number = c.optInt("number", 0),
                                name = c.optString("name", ""),
                                icon = c.optString("icon", ""),
                                programTitle = dispT,
                                progressPct = nowObj.optInt("progressPct", 25).coerceIn(2, 100),
                                remainingMin = max(1, ceil(remSec / 60.0).toInt()),
                                viewers = max(0, c.optInt("viewers", 0))
                            )
                        )
                    }
                    freshOthers.sortWith(compareByDescending<OtherChannelCardData> { it.viewers }.thenBy { it.number })
                    if (freshOthers.isNotEmpty()) {
                        otherChannels = freshOthers.take(3)
                    }
                }
            }

            val nextSnap = upNextSummary
            if (!isDestroyed && nextSnap != null && nextSnap.tmdbId > 0) {
                val q = buildString {
                    append("$API_BASE/api/live-tv/continuity-meta?media_type=")
                    append(URLEncoder.encode(nextSnap.mediaType, "UTF-8"))
                    append("&tmdb_id=").append(nextSnap.tmdbId)
                    if (nextSnap.mediaType == "tv") {
                        append("&season=").append(nextSnap.season)
                        append("&episode=").append(nextSnap.episode)
                    }
                }
                val metaRaw = withContext(Dispatchers.IO) { httpGetText(q) }
                if (!isDestroyed && !metaRaw.isNullOrBlank()) {
                    runCatching {
                        val m = JSONObject(metaRaw)
                        if (m.optBoolean("ok", false)) {
                            val logoPath = m.optString("logo_path", "").takeIf { it != "null" }.orEmpty()
                            val castArr = m.optJSONArray("cast")
                            val names = mutableListOf<String>()
                            if (castArr != null) {
                                for (k in 0 until min(3, castArr.length())) {
                                    val nm = castArr.optString(k, "")
                                    if (nm.isNotBlank()) names.add(nm)
                                }
                            }
                            if (nextSnap.mediaType == "tv") {
                                val epName = m.optString("episode_name", "")
                                val epOv = m.optString("episode_overview", "")
                                val creator = m.optString("creator", "").takeIf { it != "null" }.orEmpty()
                                val tvParts = mutableListOf<String>()
                                if (creator.isNotBlank()) tvParts.add("Creada por $creator")
                                if (names.isNotEmpty()) tvParts.add("Con ${names.joinToString(", ")}")
                                upNextSummary = nextSnap.copy(
                                    logoPath = logoPath.ifBlank { nextSnap.logoPath },
                                    episodeName = epName,
                                    overview = epOv.ifBlank { nextSnap.overview },
                                    castLine = tvParts.joinToString(" · ")
                                )
                            } else {
                                val dir = m.optString("director", "").takeIf { it != "null" }.orEmpty()
                                val parts = mutableListOf<String>()
                                if (dir.isNotBlank()) parts.add("Dir. $dir")
                                if (names.isNotEmpty()) parts.add("Con ${names.joinToString(", ")}")
                                upNextSummary = nextSnap.copy(
                                    logoPath = logoPath.ifBlank { nextSnap.logoPath },
                                    castLine = parts.joinToString(" · ")
                                )
                            }
                        }
                    }
                }
            }

            val logoPath = upNextSummary?.logoPath.orEmpty()
            if (!isDestroyed && logoPath.isNotBlank()) {
                val logoUrl = if (logoPath.startsWith("http")) logoPath else "https://image.tmdb.org/t/p/w500$logoPath"
                val logoBmp = posterCache.get(logoUrl)
                    ?: withContext(Dispatchers.IO) { downloadDownsampledBitmap(logoUrl, 360, 120, preserveAlpha = true) }
                if (!isDestroyed && logoBmp != null) {
                    posterCache.put(logoUrl, logoBmp)
                    ivNextLogo?.setImageBitmap(logoBmp)
                    ivNextLogo?.visibility = View.VISIBLE
                    tvNextTitle?.visibility = View.GONE
                }
            }

            val posterPath = upNextSummary?.posterPath.orEmpty()
            if (!isDestroyed && posterPath.isNotBlank()) {
                val fullUrl = if (posterPath.startsWith("http")) posterPath else "https://image.tmdb.org/t/p/w342$posterPath"
                val bmp = posterCache.get(fullUrl) ?: withContext(Dispatchers.IO) { downloadDownsampledBitmap(fullUrl, 180, 270) }
                if (!isDestroyed && bmp != null) {
                    posterCache.put(fullUrl, bmp)
                    ivNextPoster?.setImageBitmap(bmp)
                    ivNextPoster?.visibility = View.VISIBLE
                }
            }

            if (!isDestroyed) {
                preloadStatusMessage = "⚡ Siguiente emisión precargada · Transición sincronizada"
                tvPreloadStatus?.text = preloadStatusMessage
            }

            if (!isDestroyed && isSqueezed) {
                bindUpNextTexts()
                rebuildChannelCardsRow()
            }
        }
    }

    private fun isCompactHeightLayout(chPx: Int): Boolean {
        val density = activity.resources.displayMetrics.density.takeIf { it > 0f } ?: 1f
        val chDp = chPx / density
        val fontScale = activity.resources.configuration.fontScale
        return chDp <= 440f || (chDp <= 500f && fontScale >= 1.15f)
    }

    private fun enterOrUpdateSqueezeUi(remainingSec: Int, plan: ContinuityPlan) {
        val cw = rootContainer.width.takeIf { it > 0 } ?: activity.resources.displayMetrics.widthPixels
        val ch = rootContainer.height.takeIf { it > 0 } ?: activity.resources.displayMetrics.heightPixels
        val compact = isCompactHeightLayout(ch)
        val geo = computeSqueezeGeometry(
            containerWidthPx = cw,
            containerHeightPx = ch,
            padXPx = dpToPx(if (compact) 12 else 18),
            padYPx = dpToPx(if (compact) 10 else 16),
            gapPx = dpToPx(if (compact) 9 else 14),
            compactHeight = compact
        )

        ensureOverlayViewsCreated()
        val dimsChanged = cw != lastLayoutCw || ch != lastLayoutCh || compact != lastLayoutCompact
        if (dimsChanged) {
            val prevCompact = lastLayoutCompact
            lastLayoutCw = cw
            lastLayoutCh = ch
            lastLayoutCompact = compact
            applyCompactMetricsIfNeeded(compact)
            layoutOverlayRegions(geo)
            if (isSqueezed) {
                if (prevCompact != compact) {
                    rebuildChannelCardsRow()
                }
                animateVideoSurfaceTo(
                    targetLeft = geo.videoLeft,
                    targetTop = geo.videoTop,
                    targetWidth = geo.videoWidth,
                    targetHeight = geo.videoHeight,
                    fullScreenOnEnd = false
                )
            }
        }
        updateCountdownText(remainingSec)
        tvPostCreditsBadge?.visibility = if (plan.hasPostCredits) View.VISIBLE else View.GONE
        tvNextSynopsis?.maxLines = when {
            compact && plan.hasPostCredits -> 1
            compact || plan.hasPostCredits -> 2
            else -> 3
        }

        if (!isSqueezed) {
            isSqueezed = true
            onSqueezeVisibilityChanged(true)
            bindUpNextTexts()
            rebuildChannelCardsRow()
            overlayRoot?.alpha = 0f
            overlayRoot?.visibility = View.VISIBLE
            overlayRoot?.animate()?.alpha(1f)?.setDuration(380L)?.start()
            animateVideoSurfaceTo(
                targetLeft = geo.videoLeft,
                targetTop = geo.videoTop,
                targetWidth = geo.videoWidth,
                targetHeight = geo.videoHeight,
                fullScreenOnEnd = false
            )
            val logoPath = upNextSummary?.logoPath.orEmpty()
            if (logoPath.isNotBlank()) {
                val logoUrl = if (logoPath.startsWith("http")) logoPath else "https://image.tmdb.org/t/p/w500$logoPath"
                posterCache.get(logoUrl)?.let {
                    ivNextLogo?.setImageBitmap(it)
                    ivNextLogo?.visibility = View.VISIBLE
                    tvNextTitle?.visibility = View.GONE
                }
            }
            val posterPath = upNextSummary?.posterPath.orEmpty()
            if (posterPath.isNotBlank()) {
                val fullUrl = if (posterPath.startsWith("http")) posterPath else "https://image.tmdb.org/t/p/w342$posterPath"
                posterCache.get(fullUrl)?.let {
                    ivNextPoster?.setImageBitmap(it)
                    ivNextPoster?.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun exitSqueezeAnimated() {
        if (!isSqueezed) return
        isSqueezed = false
        lastLayoutCw = 0
        lastLayoutCh = 0
        onSqueezeVisibilityChanged(false)
        val cw = rootContainer.width.takeIf { it > 0 } ?: activity.resources.displayMetrics.widthPixels
        val ch = rootContainer.height.takeIf { it > 0 } ?: activity.resources.displayMetrics.heightPixels
        overlayRoot?.animate()?.alpha(0f)?.setDuration(300L)?.withEndAction {
            if (!isSqueezed) overlayRoot?.visibility = View.GONE
        }?.start()
        animateVideoSurfaceTo(
            targetLeft = 0,
            targetTop = 0,
            targetWidth = cw,
            targetHeight = ch,
            fullScreenOnEnd = true
        )
    }

    private fun animateVideoSurfaceTo(
        targetLeft: Int,
        targetTop: Int,
        targetWidth: Int,
        targetHeight: Int,
        fullScreenOnEnd: Boolean
    ) {
        surfaceAnimator?.cancel()
        val cw = rootContainer.width.takeIf { it > 0 } ?: activity.resources.displayMetrics.widthPixels
        val ch = rootContainer.height.takeIf { it > 0 } ?: activity.resources.displayMetrics.heightPixels
        val curLp = (videoSurface.layoutParams as? FrameLayout.LayoutParams)
            ?: FrameLayout.LayoutParams(cw, ch)
        val startLeft = curLp.leftMargin
        val startTop = curLp.topMargin
        val startW = if (curLp.width > 0) curLp.width else cw
        val startH = if (curLp.height > 0) curLp.height else ch

        surfaceAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            duration = 420L
            interpolator = DecelerateInterpolator()
            addUpdateListener { anim ->
                val f = anim.animatedFraction
                val lp = (videoSurface.layoutParams as? FrameLayout.LayoutParams)
                    ?: FrameLayout.LayoutParams(targetWidth, targetHeight)
                lp.gravity = Gravity.TOP or Gravity.START
                lp.leftMargin = (startLeft + (targetLeft - startLeft) * f).roundToInt()
                lp.topMargin = (startTop + (targetTop - startTop) * f).roundToInt()
                lp.width = max(1, (startW + (targetWidth - startW) * f).roundToInt())
                lp.height = max(1, (startH + (targetHeight - startH) * f).roundToInt())
                videoSurface.layoutParams = lp
            }
            if (fullScreenOnEnd) {
                addListener(object : android.animation.AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: android.animation.Animator) {
                        if (!isSqueezed) {
                            restoreFullscreenImmediate()
                        }
                    }
                })
            }
            start()
        }
    }

    private fun ensureOverlayViewsCreated() {
        if (overlayRoot != null) return

        val root = FrameLayout(activity).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            visibility = View.GONE
            elevation = dpToPx(6).toFloat()
            translationZ = dpToPx(6).toFloat()
        }

        // Transparent-fill gold frame around the 16:9 hardware SurfaceView window (never occludes SurfaceView!)
        val vBorder = View(activity).apply {
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dpToPx(10).toFloat()
                setColor(Color.TRANSPARENT)
                setStroke(dpToPx(2), Color.parseColor("#CCF5D061"))
            }
        }
        videoBorderFrame = vBorder
        root.addView(vBorder)

        val audioTv = TextView(activity).apply {
            text = "🔴 EN DIRECTO · AUDIO ACTIVO"
            setTextColor(Color.parseColor("#FEF08A"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dpToPx(9), dpToPx(4), dpToPx(9), dpToPx(4))
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dpToPx(999).toFloat()
                setColor(Color.parseColor("#CC060912"))
                setStroke(dpToPx(1), Color.parseColor("#88F5D061"))
            }
        }
        liveAudioBadge = audioTv
        root.addView(audioTv)

        // Right Continuity Panel: ⏭ A CONTINUACIÓN
        val rPanel = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dpToPx(14), dpToPx(12), dpToPx(14), dpToPx(12))
            background = GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                intArrayOf(Color.parseColor("#F20E1322"), Color.parseColor("#F7080B15"))
            ).apply {
                cornerRadius = dpToPx(14).toFloat()
                setStroke(dpToPx(1), Color.parseColor("#70F5D061"))
            }
        }

        val kickerRow = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val kickerBadge = TextView(activity).apply {
            text = if (descriptor.isPremiereChannel) "🎟 CIERRE DE SESIÓN" else "⏭ A CONTINUACIÓN"
            setTextColor(Color.parseColor("#140C02"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dpToPx(9), dpToPx(3), dpToPx(9), dpToPx(3))
            background = GradientDrawable().apply {
                cornerRadius = dpToPx(999).toFloat()
                setColor(Color.parseColor("#F5D061"))
            }
        }
        kickerRow.addView(kickerBadge)
        kickerRow.addView(View(activity), LinearLayout.LayoutParams(0, 0, 1f))

        val cdTv = TextView(activity).apply {
            text = "EN 00:15"
            setTextColor(Color.parseColor("#FECACA"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dpToPx(9), dpToPx(3), dpToPx(9), dpToPx(3))
            background = GradientDrawable().apply {
                cornerRadius = dpToPx(999).toFloat()
                setColor(Color.parseColor("#38EF4444"))
                setStroke(dpToPx(1), Color.parseColor("#99F87171"))
            }
        }
        tvCountdown = cdTv
        kickerRow.addView(cdTv)
        rPanel.addView(kickerRow)

        val postBadge = TextView(activity).apply {
            text = "🎬 ¡OJO! Incluye escena post-créditos · No se recorta"
            setTextColor(Color.parseColor("#A7F3D0"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(dpToPx(8), dpToPx(4), dpToPx(8), dpToPx(4))
            visibility = View.GONE
            background = GradientDrawable().apply {
                cornerRadius = dpToPx(8).toFloat()
                setColor(Color.parseColor("#2E10B981"))
                setStroke(dpToPx(1), Color.parseColor("#8834D399"))
            }
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dpToPx(6) }
        }
        tvPostCreditsBadge = postBadge
        rPanel.addView(postBadge)

        val bodyRow = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.TOP
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            ).apply { topMargin = dpToPx(8) }
        }

        val posterIv = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            visibility = View.GONE
            layoutParams = LinearLayout.LayoutParams(dpToPx(64), dpToPx(96)).apply {
                rightMargin = dpToPx(10)
            }
        }
        ivNextPoster = posterIv
        bodyRow.addView(posterIv)

        val textCol = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }
        val logoIv = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.FIT_START
            adjustViewBounds = true
            maxHeight = dpToPx(42)
            visibility = View.GONE
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                dpToPx(38)
            ).apply { bottomMargin = dpToPx(2) }
        }
        ivNextLogo = logoIv
        textCol.addView(logoIv)

        val nTitle = TextView(activity).apply {
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 2
            ellipsize = TextUtils.TruncateAt.END
        }
        tvNextTitle = nTitle
        textCol.addView(nTitle)

        val nSub = TextView(activity).apply {
            setTextColor(Color.parseColor("#FDE68A"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dpToPx(2) }
        }
        tvNextSub = nSub
        textCol.addView(nSub)

        val nSyn = TextView(activity).apply {
            setTextColor(Color.parseColor("#CBD5E1"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            maxLines = 3
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dpToPx(4) }
        }
        tvNextSynopsis = nSyn
        textCol.addView(nSyn)

        val nCast = TextView(activity).apply {
            setTextColor(Color.parseColor("#94A3B8"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            visibility = View.GONE
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { topMargin = dpToPx(4) }
        }
        tvNextCast = nCast
        textCol.addView(nCast)

        bodyRow.addView(textCol)
        rPanel.addView(bodyRow)

        val preloadTv = TextView(activity).apply {
            text = preloadStatusMessage
            setTextColor(Color.parseColor("#86EFAC"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        tvPreloadStatus = preloadTv
        rPanel.addView(preloadTv)

        rightPanel = rPanel
        root.addView(rPanel)

        // Bottom Strip: 🔥 AHORA EN OTROS CANALES (3 focusable live channel zapping cards)
        val bStrip = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.BOTTOM
        }
        val stripHeader = TextView(activity).apply {
            text = "🔥 AHORA EN OTROS CANALES  ·  Zapping directo"
            setTextColor(Color.parseColor("#FDE68A"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dpToPx(6) }
        }
        stripHeaderTv = stripHeader
        bStrip.addView(stripHeader)

        val cardsRow = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }
        channelCardsRow = cardsRow
        bStrip.addView(cardsRow)

        bottomStrip = bStrip
        root.addView(bStrip)

        rootContainer.addView(root)
        overlayRoot = root
    }

    private fun applyCompactMetricsIfNeeded(compact: Boolean) {
        rightPanel?.setPadding(
            dpToPx(if (compact) 10 else 14),
            dpToPx(if (compact) 8 else 12),
            dpToPx(if (compact) 10 else 14),
            dpToPx(if (compact) 8 else 12)
        )
        ivNextPoster?.layoutParams = LinearLayout.LayoutParams(
            dpToPx(if (compact) 46 else 64),
            dpToPx(if (compact) 68 else 96)
        ).apply {
            rightMargin = dpToPx(if (compact) 8 else 10)
        }
        ivNextLogo?.maxHeight = dpToPx(if (compact) 28 else 42)
        ivNextLogo?.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            dpToPx(if (compact) 26 else 38)
        ).apply { bottomMargin = dpToPx(2) }
        tvNextTitle?.setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compact) 13.5f else 15f)
        tvNextTitle?.maxLines = if (compact) 1 else 2
        stripHeaderTv?.setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compact) 10.5f else 11.5f)
        (stripHeaderTv?.layoutParams as? LinearLayout.LayoutParams)?.let { lp ->
            lp.bottomMargin = dpToPx(if (compact) 4 else 6)
            stripHeaderTv?.layoutParams = lp
        }
    }

    private fun layoutOverlayRegions(geo: SqueezeGeometry) {
        videoBorderFrame?.layoutParams = FrameLayout.LayoutParams(geo.videoWidth, geo.videoHeight).apply {
            gravity = Gravity.TOP or Gravity.START
            leftMargin = geo.videoLeft
            topMargin = geo.videoTop
        }
        liveAudioBadge?.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            leftMargin = geo.videoLeft + dpToPx(10)
            topMargin = geo.videoTop + dpToPx(10)
        }
        rightPanel?.layoutParams = FrameLayout.LayoutParams(geo.rightWidth, geo.rightHeight).apply {
            gravity = Gravity.TOP or Gravity.START
            leftMargin = geo.rightLeft
            topMargin = geo.rightTop
        }
        bottomStrip?.layoutParams = FrameLayout.LayoutParams(geo.bottomWidth, geo.bottomHeight).apply {
            gravity = Gravity.TOP or Gravity.START
            leftMargin = geo.bottomLeft
            topMargin = geo.bottomTop
        }
    }

    private fun bindUpNextTexts() {
        tvPreloadStatus?.text = preloadStatusMessage
        val next = upNextSummary
        if (next == null) {
            ivNextLogo?.visibility = View.GONE
            tvNextTitle?.visibility = View.VISIBLE
            tvNextTitle?.text = if (descriptor.isPremiereChannel) {
                "El Peliculón · Sesión VIP"
            } else {
                "Emisión continua 24/7"
            }
            tvNextSub?.visibility = View.GONE
            tvNextSynopsis?.text = "Elige cualquiera de los canales en directo de abajo para seguir disfrutando de Cineflix TV."
            tvNextCast?.visibility = View.GONE
            return
        }
        tvNextTitle?.text = next.title
        if (ivNextLogo?.visibility == View.VISIBLE) {
            tvNextTitle?.visibility = View.GONE
        } else {
            tvNextTitle?.visibility = View.VISIBLE
        }
        val subParts = mutableListOf<String>()
        if (next.epCode.isNotBlank()) {
            subParts.add(if (next.episodeName.isNotBlank()) "${next.epCode} — ${next.episodeName}" else next.epCode)
        }
        if (next.year.isNotBlank()) subParts.add(next.year)
        if (next.rating.isNotBlank()) subParts.add(next.rating)
        val subLine = subParts.joinToString(" · ")
        tvNextSub?.text = subLine
        tvNextSub?.visibility = if (subLine.isNotBlank()) View.VISIBLE else View.GONE

        tvNextSynopsis?.text = next.overview.ifBlank {
            "Siguiente emisión sincronizada para todos los espectadores de este canal."
        }
        if (next.castLine.isNotBlank()) {
            tvNextCast?.text = next.castLine
            tvNextCast?.visibility = View.VISIBLE
        } else {
            tvNextCast?.visibility = View.GONE
        }
    }

    private fun rebuildChannelCardsRow() {
        val row = channelCardsRow ?: return
        val prevFocusedIdx = channelCardViews.indexOfFirst { it === activity.currentFocus }
        row.removeAllViews()
        channelCardViews.clear()
        if (otherChannels.isEmpty()) return

        val compact = lastLayoutCompact
        val cardPadH = dpToPx(if (compact) 9 else 11)
        val cardPadV = dpToPx(if (compact) 5 else 8)

        for ((idx, chItem) in otherChannels.take(3).withIndex()) {
            val normalBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dpToPx(11).toFloat()
                setColor(Color.parseColor("#EB0B0F1A"))
                setStroke(dpToPx(1), Color.parseColor("#33FFFFFF"))
            }
            val focusBg = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = dpToPx(11).toFloat()
                setColor(Color.parseColor("#F51A2238"))
                setStroke(dpToPx(2), Color.parseColor("#FACC15"))
            }

            val card = LinearLayout(activity).apply {
                id = View.generateViewId()
                orientation = LinearLayout.VERTICAL
                isFocusable = true
                isClickable = true
                background = normalBg
                setPadding(cardPadH, cardPadV, cardPadH, cardPadV)
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                    if (idx > 0) leftMargin = dpToPx(if (compact) 6 else 8)
                }
                setOnFocusChangeListener { v, hasFocus ->
                    v.background = if (hasFocus) focusBg else normalBg
                }
                setOnClickListener {
                    restoreFullscreenImmediate()
                    onZapToChannel(chItem.channelId)
                }
            }

            val chLine = TextView(activity).apply {
                val iconPref = if (chItem.icon.isNotBlank()) "${chItem.icon} " else ""
                val viewersSuffix = if (chItem.viewers > 0) "  ·  👥 ${chItem.viewers}" else ""
                text = "${chItem.number} · $iconPref${chItem.name}$viewersSuffix"
                setTextColor(Color.parseColor("#FDE68A"))
                setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compact) 10f else 10.5f)
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
            }
            card.addView(chLine)

            val progLine = TextView(activity).apply {
                text = chItem.programTitle
                setTextColor(Color.WHITE)
                setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compact) 11f else 12f)
                typeface = Typeface.DEFAULT_BOLD
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { topMargin = dpToPx(if (compact) 1 else 2) }
            }
            card.addView(progLine)

            val metaLine = TextView(activity).apply {
                text = "▶ Cambiar canal  ·  Quedan ${chItem.remainingMin}m"
                setTextColor(Color.parseColor("#CBD5E1"))
                setTextSize(TypedValue.COMPLEX_UNIT_SP, if (compact) 9.5f else 10f)
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { topMargin = dpToPx(if (compact) 1 else 2) }
            }
            card.addView(metaLine)

            val barTrack = FrameLayout(activity).apply {
                background = GradientDrawable().apply {
                    cornerRadius = dpToPx(99).toFloat()
                    setColor(Color.parseColor("#26FFFFFF"))
                }
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    dpToPx(3)
                ).apply { topMargin = dpToPx(if (compact) 3 else 5) }
            }
            val barFill = View(activity).apply {
                background = GradientDrawable(
                    GradientDrawable.Orientation.LEFT_RIGHT,
                    intArrayOf(Color.parseColor("#EF4444"), Color.parseColor("#F5D061"))
                ).apply { cornerRadius = dpToPx(99).toFloat() }
                layoutParams = FrameLayout.LayoutParams(0, FrameLayout.LayoutParams.MATCH_PARENT)
            }
            barTrack.addView(barFill)
            barTrack.post {
                val fullW = barTrack.width
                if (fullW > 0) {
                    val flp = barFill.layoutParams
                    flp.width = max(dpToPx(4), (fullW * chItem.progressPct / 100f).roundToInt())
                    barFill.layoutParams = flp
                }
            }
            card.addView(barTrack)

            row.addView(card)
            channelCardViews.add(card)
        }

        for (i in channelCardViews.indices) {
            if (i > 0) channelCardViews[i].nextFocusLeftId = channelCardViews[i - 1].id
            if (i < channelCardViews.lastIndex) channelCardViews[i].nextFocusRightId = channelCardViews[i + 1].id
        }

        if (prevFocusedIdx >= 0 && channelCardViews.isNotEmpty()) {
            val restoreIdx = min(prevFocusedIdx, channelCardViews.lastIndex)
            channelCardViews[restoreIdx].requestFocus()
        }
    }

    private fun updateCountdownText(remainingSec: Int) {
        val s = max(0, remainingSec)
        val mm = s / 60
        val ss = s % 60
        tvCountdown?.text = String.format(java.util.Locale.US, "EN %02d:%02d", mm, ss)
    }

    private fun httpGetText(urlStr: String): String? {
        var conn: HttpURLConnection? = null
        return try {
            conn = StorageAndRamHygiene.openCompatUrlConnection(urlStr).apply {
                requestMethod = "GET"
                connectTimeout = 4000
                readTimeout = 4500
                setRequestProperty("Accept", "application/json")
            }
            if (conn.responseCode in 200..299) {
                conn.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
            } else null
        } catch (_: Throwable) {
            null
        } finally {
            try { conn?.disconnect() } catch (_: Throwable) {}
        }
    }

    private fun downloadDownsampledBitmap(
        urlStr: String,
        reqWidth: Int,
        reqHeight: Int,
        preserveAlpha: Boolean = false
    ): Bitmap? {
        var conn: HttpURLConnection? = null
        return try {
            conn = StorageAndRamHygiene.openCompatUrlConnection(urlStr).apply {
                connectTimeout = 4000
                readTimeout = 4500
            }
            if (conn.responseCode !in 200..299) return null
            val bytes = conn.inputStream.use { it.readBytes() }
            val boundsOpts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size, boundsOpts)
            var sampleSize = 1
            while ((boundsOpts.outWidth / sampleSize) > reqWidth * 2 || (boundsOpts.outHeight / sampleSize) > reqHeight * 2) {
                sampleSize *= 2
            }
            val decodeOpts = BitmapFactory.Options().apply {
                inSampleSize = max(1, sampleSize)
                inPreferredConfig = if (preserveAlpha) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565
            }
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size, decodeOpts)
        } catch (e: Throwable) {
            Log.d(TAG, "Poster load skipped: ${e.message}")
            null
        } finally {
            try { conn?.disconnect() } catch (_: Throwable) {}
        }
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            activity.resources.displayMetrics
        ).roundToInt()
    }
}
