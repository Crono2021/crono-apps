package com.cineflix.android.ui.player

import android.app.Activity
import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Shader
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.util.LruCache
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.cineflix.android.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Subtle Prime-Style X-Ray on Pause for Cineflix's native ExoPlayer (`PlayerActivity`).
 *
 * Behaviour:
 *  - Activates after > 1,300 ms of genuine VOD pause (disabled during Live TV, El Peliculón,
 *    Picture-in-Picture, or external Casting).
 *  - Shows `🕒 Termina a las HH:MM`, director & cast circular portraits (`GET /api/xray`),
 *    and a quick filmography modal (`GET /api/xray/person-catalog`) with `+ Pendientes`
 *    (`POST/DELETE /api/watchlist`) and `ℹ Abrir ficha`.
 *  - Zero memory leaks: downsamples avatars to `96x96` px inside a tiny 16-entry `LruCache`
 *    and explicitly evicts all bitmaps, cancels all coroutines, and detaches views in [destroy].
 */
class XrayOverlayController(
    private val activity: Activity,
    private val rootContainer: FrameLayout,
    private val mediaDescriptor: MediaDescriptor,
    private val userPhone: String,
    private val isKidsProfile: Boolean = false,
    private val onPanelVisibilityChanged: ((visible: Boolean, anchoredAtTop: Boolean, firstChipView: View?) -> Unit)? = null,
    private val onWatchlistMutated: (() -> Unit)? = null,
    private val onOpenCatalogItem: (PersonCatalogItem) -> Unit
) {

    data class MediaDescriptor(
        val mediaType: String, // "movie" or "tv"
        val id: String,
        val tmdbId: Int,
        val title: String,
        val year: String,
        val season: Int,
        val episode: Int,
        val isCleanCatalogTitle: Boolean = false
    )

    data class XrayPerson(
        val id: Int,
        val roleType: String,
        val name: String,
        val character: String,
        val profilePath: String?
    )

    data class XrayPayload(
        val mediaType: String,
        val tmdbId: Int,
        val title: String,
        val episodeTitle: String,
        val year: String,
        val factLine: String,
        val people: List<XrayPerson>
    )

    data class PersonCatalogItem(
        val id: String,
        val mediaType: String,
        val title: String,
        val tmdbId: Int,
        val posterPath: String?,
        val year: String,
        val personRole: String,
        val payload: String?,
        val rawItemJson: String = ""
    )

    internal enum class PauseRevealAction {
        HIDE_AND_RESET,
        UPDATE_CLOCK_ONLY,
        NO_OP,
        SCHEDULE_REVEAL
    }

    companion object {
        private const val TAG = "CineflixXray"
        internal const val PAUSE_REVEAL_DELAY_MS = 950L
        private const val API_BASE = "https://cineflixapp.duckdns.org"
        private const val AVATAR_PX = 96

        internal fun computePauseRevealAction(
            isPausedReady: Boolean,
            suppressAll: Boolean,
            isPanelVisible: Boolean,
            isMiniPillVisible: Boolean,
            dismissedForCurrentPause: Boolean,
            revealAlreadyPending: Boolean,
            isPlaybackPaused: Boolean = isPausedReady,
            revealAttemptedForCurrentPause: Boolean = false
        ): PauseRevealAction {
            if (suppressAll || !isPlaybackPaused) {
                return PauseRevealAction.HIDE_AND_RESET
            }
            if (isPanelVisible) {
                return PauseRevealAction.UPDATE_CLOCK_ONLY
            }
            if (isMiniPillVisible ||
                dismissedForCurrentPause ||
                revealAlreadyPending ||
                revealAttemptedForCurrentPause ||
                !isPausedReady
            ) {
                return PauseRevealAction.NO_OP
            }
            return PauseRevealAction.SCHEDULE_REVEAL
        }

        internal fun shouldCompleteAsyncReveal(
            isDestroyed: Boolean,
            dismissedForCurrentPause: Boolean,
            isPlaybackPaused: Boolean,
            suppressAll: Boolean,
            requestToken: Int,
            currentToken: Int
        ): Boolean {
            return !isDestroyed &&
                !dismissedForCurrentPause &&
                isPlaybackPaused &&
                !suppressAll &&
                requestToken == currentToken
        }

        /**
         * On landscape mobile phones (`screenHeightDp < 500`), center playback controls (`72dp`)
         * and bottom seek bar (`~92dp`) leave only ~56dp between them. Anchoring X-Ray at the top
         * while controls are visible prevents covering the Play/Pause button; when controls hide
         * (or on 540dp+ TVs/tablets), X-Ray anchors cleanly at the bottom.
         */
        internal fun shouldAnchorOverlayAtTop(screenHeightDp: Int, controlsVisible: Boolean): Boolean {
            return controlsVisible && screenHeightDp in 1..499
        }

        /**
         * Preserves Cineflix's multi-profile virtual phone format (`34600000000:p2`, `34600000000:kids`)
         * while normalizing leading `+`/spaces in the base phone and rejecting placeholder tokens.
         */
        internal fun normalizeScopedUserPhone(rawPhone: String): String {
            val trimmed = rawPhone.trim()
            if (trimmed.isEmpty() ||
                trimmed.equals("unknown", ignoreCase = true) ||
                trimmed.equals("native_user", ignoreCase = true)
            ) {
                return ""
            }
            val colonIdx = trimmed.indexOf(':')
            val rawBase = (if (colonIdx >= 0) trimmed.substring(0, colonIdx) else trimmed).trim()
            val profileId = (if (colonIdx >= 0) trimmed.substring(colonIdx + 1) else "").trim()
            if (rawBase.isEmpty() ||
                rawBase.equals("unknown", ignoreCase = true) ||
                rawBase.equals("native_user", ignoreCase = true)
            ) {
                return ""
            }
            val base = if (Regex("^[+\\d\\s()\\-]{4,}$").matches(rawBase)) {
                rawBase.replace(Regex("\\D"), "")
            } else {
                rawBase.replace(Regex("[+\\s]+"), "")
            }
            if (base.isEmpty()) return ""
            return if (profileId.isNotEmpty() && !profileId.equals("default", ignoreCase = true)) {
                "$base:$profileId"
            } else {
                base
            }
        }

        internal fun sanitizeLookupTitle(rawTitle: String): String {
            if (rawTitle.isBlank()) return ""
            val primaryLine = rawTitle
                .lineSequence()
                .map { line ->
                    line
                        .replace(Regex("[\\x{1F000}-\\x{1FFFF}\\u2600-\\u27BF\\uFE0F]+"), " ")
                        .replace(Regex("^[^\\p{L}\\p{N}(\\[]+"), "")
                        .trim()
                }
                .firstOrNull { line ->
                    line.any { it.isLetterOrDigit() } &&
                        !Regex("^(?:calidad|audio|idioma|subt[íi]tulos?|formato|peso|tama[ñn]o|canal|servidor|fuente)\\s*:", RegexOption.IGNORE_CASE).containsMatchIn(line) &&
                        !Regex("^@[A-Za-z0-9_]+$").matches(line)
                } ?: return ""

            if (Regex("^(?:Cap[íi]tulo|Episodio|Ep\\.?|Temporada|Season)\\s*\\d+\\b.*$", RegexOption.IGNORE_CASE).matches(primaryLine) ||
                Regex("^\\d{1,2}[x×X]\\d{1,3}\\b.*$").matches(primaryLine) ||
                Regex("^[Ss]\\d{1,2}[Ee]\\d{1,3}\\b.*$").matches(primaryLine)
            ) {
                return ""
            }

            val hadFilenameNoise = Regex("\\.(?:mkv|mp4|avi|ts|mov|webm|m4v|flv|wmv|mpg|mpeg|ogv|3gp|7z|rar|zip)$", RegexOption.IGNORE_CASE).containsMatchIn(primaryLine) ||
                Regex("\\S\\.[a-zA-Z0-9]{2,}").containsMatchIn(primaryLine) ||
                Regex("\\b(?:2160p|1080p|720p|480p|m1080p|m720p|4K|UHD|MicroHD|BDRemux|REMUX|HDTV|BDRip|BRRip|WEBRip|WEB-DL|BluRay|HDR10?\\+?|DV|HEVC|x26[45]|H\\.?26[45]|AC3|EAC3|DDP5?\\.?1?|Atmos|DTS|Castellano|VOSE|Subtitulado)\\b", RegexOption.IGNORE_CASE).containsMatchIn(primaryLine) ||
                Regex("\\((?:Castellano|Espa[ñn]ol|Latino|Dual|VOSE?|Multi|Subtitulado|1080p|720p|2160p|m1080p|m720p|4K|UHD|MicroHD|BDRemux|HDR|HEVC|x26[45])[^)]*\\)", RegexOption.IGNORE_CASE).containsMatchIn(primaryLine) ||
                primaryLine.contains('[') || primaryLine.contains('_')

            val cleaned = primaryLine
                .replace(Regex("\\.(?:mkv|mp4|avi|ts|mov|webm|m4v|flv|wmv|mpg|mpeg|ogv|3gp|srt|7z|rar|zip)$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("@[A-Za-z0-9_]{3,}"), " ")
                .replace(Regex("\\[(19\\d{2}|20[0-3]\\d)]"), "($1)")
                .replace(Regex("\\((?:Castellano|Espa[ñn]ol|Latino|Dual|VOSE?|Multi|Subtitulado|1080p|720p|2160p|m1080p|m720p|4K|UHD|MicroHD|BDRemux|HDR|HEVC|x26[45])[^)]*\\)", RegexOption.IGNORE_CASE), "")
                .replace(Regex("\\[[^]]*]"), "")
                .replace(Regex("[._]+"), " ")
                .replace(Regex("\\b\\d{1,2}[x×X]\\d{1,3}\\b.*$"), "")
                .replace(Regex("\\b[Ss]\\d{1,2}[Ee]\\d{1,3}\\b.*$"), "")
                .replace(Regex("\\b(?:Temporada|Season)\\s*\\d+\\s*(?:[-–—·•:]|Episodio|Cap[íi]tulo|Ep\\.?).*$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("[-–—·:|]\\s*(?:Cap[íi]tulo|Episodio|Ep\\.?)\\s*\\d+\\b.*$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("\\b(?:2160p|1080p|720p|480p|m1080p|m720p|4K|UHD|MicroHD|BDRemux|REMUX|HDTV|BDRip|BRRip|WEBRip|WEB-DL|BluRay|HDR10?\\+?|DV|HEVC|x26[45]|H\\.?26[45]|AC3|EAC3|DDP5?\\.?1?|Atmos|DTS)\\b.*$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("\\b(?:Castellano|VOSE|Subtitulado)\\b.*$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("(?:[-–—·:|]\\s*|\\s+)(?:Espa[ñn]ol|Latino|Dual)\\s*$", RegexOption.IGNORE_CASE), "")
                .replace(Regex("\\s+"), " ")
                .trim()
                .replace(Regex("[-–—·:|\\s]+$"), "")
                .replace(Regex("(?<=\\S)\\s+\\((?:19\\d{2}|20[0-3]\\d)\\)$"), "")
                .replace(Regex("[-–—·:|\\s]+$"), "")
                .trim()

            return if (hadFilenameNoise) {
                cleaned
                    .replace(Regex("(?<=\\S)\\s+(?:19\\d{2}|20[0-3]\\d)$"), "")
                    .replace(Regex("[-–—·:|\\s]+$"), "")
                    .trim()
            } else {
                cleaned
            }
        }

        internal fun extractYearFromTitle(rawTitle: String): String {
            val firstLine = rawTitle.lineSequence().firstOrNull { it.isNotBlank() } ?: rawTitle
            val matches = Regex("\\b(19\\d{2}|20[0-3]\\d)\\b").findAll(firstLine).toList()
            return matches.lastOrNull()?.groupValues?.getOrNull(1) ?: ""
        }

        internal fun formatFinishClock(positionMs: Long, durationMs: Long, nowEpochMs: Long = System.currentTimeMillis()): String {
            if (durationMs <= 60_000L) return ""
            val remMs = (durationMs - positionMs.coerceAtLeast(0L)).coerceAtLeast(0L)
            if (remMs < 30_000L) return ""
            val finishDate = Date(nowEpochMs + remMs)
            val clock = SimpleDateFormat("HH:mm", Locale.getDefault()).format(finishDate)
            return "🕒 Termina a las $clock"
        }

        internal fun parseXrayResponseJson(jsonStr: String): XrayPayload? {
            if (jsonStr.isBlank()) return null
            return try {
                val root = JSONObject(jsonStr)
                if (!root.optBoolean("ok", false)) return null
                val arr = root.optJSONArray("people") ?: return null
                val people = ArrayList<XrayPerson>(arr.length())
                for (i in 0 until arr.length()) {
                    val o = arr.optJSONObject(i) ?: continue
                    val id = o.optInt("id", 0)
                    val name = o.optString("name", "").trim()
                    if (id <= 0 || name.isEmpty()) continue
                    people.add(
                        XrayPerson(
                            id = id,
                            roleType = o.optString("role_type", "cast"),
                            name = name,
                            character = o.optString("character", ""),
                            profilePath = o.optString("profile_path", "").takeIf { it.isNotBlank() && it != "null" }
                        )
                    )
                }
                if (people.isEmpty()) return null
                XrayPayload(
                    mediaType = root.optString("media_type", "movie"),
                    tmdbId = root.optInt("tmdb_id", 0),
                    title = root.optString("title", ""),
                    episodeTitle = root.optString("episode_title", ""),
                    year = root.optString("year", ""),
                    factLine = root.optString("fact_line", ""),
                    people = people
                )
            } catch (_: Throwable) {
                null
            }
        }

        internal fun parsePersonCatalogJson(jsonStr: String): List<PersonCatalogItem> {
            if (jsonStr.isBlank()) return emptyList()
            return try {
                val root = JSONObject(jsonStr)
                val arr = root.optJSONArray("items") ?: return emptyList()
                val out = ArrayList<PersonCatalogItem>(arr.length())
                for (i in 0 until arr.length()) {
                    val o = arr.optJSONObject(i) ?: continue
                    val id = o.opt("id")?.toString()?.trim().orEmpty()
                    if (id.isEmpty() || id == "null") continue
                    val mType = o.optString("media_type", "movie")
                    val title = o.optString("tmdb_name", "").ifBlank { o.optString("title", "") }.trim()
                    if (title.isEmpty()) continue
                    val poster = o.optString("tmdb_poster", "").ifBlank { o.optString("poster", "") }
                        .takeIf { it.isNotBlank() && it != "null" }
                    val payloadVal = o.optString("payload", "").ifBlank { o.optString("payload_mkv", "") }
                        .takeIf { it.isNotBlank() && it != "null" }
                    out.add(
                        PersonCatalogItem(
                            id = id,
                            mediaType = mType,
                            title = sanitizeLookupTitle(title).ifBlank { title },
                            tmdbId = o.optInt("tmdb_id", 0),
                            posterPath = poster,
                            year = o.opt("year")?.toString()?.takeIf { it != "null" }.orEmpty(),
                            personRole = o.optString("person_role", "").takeIf { it != "null" }.orEmpty(),
                            payload = payloadVal,
                            rawItemJson = o.toString()
                        )
                    )
                }
                out
            } catch (_: Throwable) {
                emptyList()
            }
        }
    }

    private val mainHandler = Handler(Looper.getMainLooper())
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val bitmapCache = object : LruCache<String, Bitmap>(16) {
        override fun sizeOf(key: String, value: Bitmap): Int = 1
    }

    @Volatile private var cachedPayload: XrayPayload? = null
    @Volatile private var prefetchAttempted = false
    @Volatile private var serverConfirmedEmpty = false
    private val fetchLock = Any()
    private var inFlightFetch: kotlinx.coroutines.Deferred<XrayPayload?>? = null
    @Volatile private var isDestroyed = false

    private var dismissedForCurrentPause = false
    private var revealAttemptedForCurrentPause = false
    private var revealPending = false
    private var latestIsPlaybackPaused = false
    private var latestSuppressAll = false
    private var revealToken = 0
    private var latestPositionMs = 0L
    private var latestDurationMs = 0L
    private var isControlsBarVisible = false
    private var firstPersonChipView: View? = null
    @Volatile private var dpadDetected = false

    private val watchlistIds = HashSet<String>()
    private var watchlistLoaded = false

    private val panelView: LinearLayout
    private val tvHeaderTitle: TextView
    private val tvEndsAt: TextView
    private val btnHideView: TextView
    private val peopleContainer: LinearLayout
    private val tvFactLine: TextView
    private val miniPillView: TextView
    private var activePersonDialog: Dialog? = null

    private val revealRunnable = Runnable {
        revealPending = false
        if (!isDestroyed && !dismissedForCurrentPause && latestIsPlaybackPaused && !latestSuppressAll) {
            revealAttemptedForCurrentPause = true
            revealPanelNow(notifyIfUnavailable = false)
        }
    }

    init {
        panelView = createPanelView()
        tvHeaderTitle = panelView.findViewWithTag("xray_title")
        tvEndsAt = panelView.findViewWithTag("xray_ends")
        btnHideView = panelView.findViewWithTag("xray_hide")
        peopleContainer = panelView.findViewWithTag("xray_people")
        tvFactLine = panelView.findViewWithTag("xray_fact")
        miniPillView = createMiniPillView()

        val panelLp = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        val pillLp = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        rootContainer.addView(panelView, panelLp)
        rootContainer.addView(miniPillView, pillLp)
        applyOverlayPositioning()
        rootContainer.post {
            if (!isDestroyed) applyOverlayPositioning()
        }
    }

    private fun isTvDevice(): Boolean {
        return (activity.resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_TYPE_MASK) ==
            android.content.res.Configuration.UI_MODE_TYPE_TELEVISION ||
            !activity.packageManager.hasSystemFeature(android.content.pm.PackageManager.FEATURE_TOUCHSCREEN)
    }

    private fun isTvOrRemoteActive(): Boolean {
        return isTvDevice() || dpadDetected
    }

    fun notifyDpadActive() {
        dpadDetected = true
    }

    private fun isAnchoredAtTopNow(): Boolean {
        val screenHeightDp = activity.resources.configuration.screenHeightDp
        return shouldAnchorOverlayAtTop(screenHeightDp, isControlsBarVisible)
    }

    private fun applyOverlayPositioning() {
        val screenHeightDp = activity.resources.configuration.screenHeightDp
        val isCompact = screenHeightDp in 1..499
        val anchorTop = shouldAnchorOverlayAtTop(screenHeightDp, isControlsBarVisible)
        val baseHorizMarginPx = if (isCompact) dp(16) else dp(24)

        var cutoutLeft = 0
        var cutoutRight = 0
        var cutoutTop = 0
        var cutoutBottom = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val dc = rootContainer.rootWindowInsets?.displayCutout
            if (dc != null) {
                cutoutLeft = dc.safeInsetLeft
                cutoutRight = dc.safeInsetRight
                cutoutTop = dc.safeInsetTop
                cutoutBottom = dc.safeInsetBottom
            }
        }

        val leftMarginPx = maxOf(baseHorizMarginPx, if (cutoutLeft > 0) cutoutLeft + dp(8) else 0)
        val rightMarginPx = maxOf(baseHorizMarginPx, if (cutoutRight > 0) cutoutRight + dp(8) else 0)
        val targetGravity = if (anchorTop) {
            Gravity.TOP or Gravity.START
        } else {
            Gravity.BOTTOM or Gravity.START
        }
        val topMarginPx = if (anchorTop) maxOf(dp(12), if (cutoutTop > 0) cutoutTop + dp(6) else 0) else 0
        val bottomMarginPx = when {
            anchorTop -> 0
            isControlsBarVisible -> dp(100)
            isCompact -> maxOf(dp(18), if (cutoutBottom > 0) cutoutBottom + dp(8) else 0)
            else -> maxOf(dp(26), if (cutoutBottom > 0) cutoutBottom + dp(8) else 0)
        }

        val containerWidthPx = rootContainer.width.takeIf { it > 0 }
            ?: activity.resources.displayMetrics.widthPixels
        val availWidthPx = (containerWidthPx - leftMarginPx - rightMarginPx).coerceAtLeast(dp(200))
        tvHeaderTitle.maxWidth = (availWidthPx - dp(255)).coerceIn(dp(72), dp(320))

        (panelView.layoutParams as? FrameLayout.LayoutParams)?.let { lp ->
            if (lp.gravity != targetGravity ||
                lp.topMargin != topMarginPx ||
                lp.bottomMargin != bottomMarginPx ||
                lp.leftMargin != leftMarginPx ||
                lp.rightMargin != rightMarginPx
            ) {
                lp.gravity = targetGravity
                lp.topMargin = topMarginPx
                lp.bottomMargin = bottomMarginPx
                lp.leftMargin = leftMarginPx
                lp.rightMargin = rightMarginPx
                panelView.layoutParams = lp
            }
        }
        (miniPillView.layoutParams as? FrameLayout.LayoutParams)?.let { lp ->
            if (lp.gravity != targetGravity ||
                lp.topMargin != topMarginPx ||
                lp.bottomMargin != bottomMarginPx ||
                lp.leftMargin != leftMarginPx ||
                lp.rightMargin != rightMarginPx
            ) {
                lp.gravity = targetGravity
                lp.topMargin = topMarginPx
                lp.bottomMargin = bottomMarginPx
                lp.leftMargin = leftMarginPx
                lp.rightMargin = rightMarginPx
                miniPillView.layoutParams = lp
            }
        }
        updatePersonChipsVerticalFocusLinks(anchorTop)
    }

    private fun updatePersonChipsVerticalFocusLinks(anchorTop: Boolean) {
        val count = peopleContainer.childCount
        val hideId = btnHideView.id
        var prevChip: View? = null
        var lastChipId = View.NO_ID
        for (i in 0 until count) {
            val child = peopleContainer.getChildAt(i) ?: continue
            if (child.id == View.NO_ID) {
                child.id = View.generateViewId()
            }
            if (anchorTop) {
                child.nextFocusUpId = hideId
                child.nextFocusDownId = if (isControlsBarVisible) R.id.btn_play_pause else View.NO_ID
            } else {
                child.nextFocusUpId = if (isControlsBarVisible) R.id.btn_play_pause else hideId
                child.nextFocusDownId = if (isControlsBarVisible) R.id.seek_bar else View.NO_ID
            }
            val prev = prevChip
            if (prev == null) {
                child.nextFocusLeftId = child.id
            } else {
                prev.nextFocusRightId = child.id
                child.nextFocusLeftId = prev.id
            }
            if (i == count - 1) {
                child.nextFocusRightId = hideId
                lastChipId = child.id
            }
            prevChip = child
        }
        val firstId = firstPersonChipView?.id ?: View.NO_ID
        btnHideView.nextFocusDownId = if (firstId != View.NO_ID) firstId else R.id.seek_bar
        btnHideView.nextFocusLeftId = if (lastChipId != View.NO_ID) lastChipId else firstId
        btnHideView.nextFocusRightId = hideId
        btnHideView.nextFocusUpId = if (!anchorTop && isControlsBarVisible) R.id.btn_play_pause else View.NO_ID
    }

    private fun getOrStartPayloadFetch(ignoreConfirmedEmpty: Boolean = false): Deferred<XrayPayload?>? {
        if (isDestroyed) return null
        if (!ignoreConfirmedEmpty && serverConfirmedEmpty) return null
        if (mediaDescriptor.id.isBlank() && mediaDescriptor.tmdbId <= 0 && mediaDescriptor.title.isBlank()) return null
        synchronized(fetchLock) {
            val active = inFlightFetch
            if (active != null && active.isActive) return active
            val created = scope.async {
                val loaded = fetchXrayPayloadFromServer()
                if (loaded != null && !isDestroyed) {
                    cachedPayload = loaded
                }
                loaded
            }
            inFlightFetch = created
            return created
        }
    }

    fun prefetchQuietly() {
        if (isDestroyed || cachedPayload != null || prefetchAttempted) return
        prefetchAttempted = true
        getOrStartPayloadFetch()
    }

    fun onControlsVisibilityChanged(visible: Boolean) {
        if (isDestroyed) return
        isControlsBarVisible = visible
        applyOverlayPositioning()
        if (panelView.visibility == View.VISIBLE) {
            onPanelVisibilityChanged?.invoke(true, isAnchoredAtTopNow(), firstPersonChipView)
        }
    }

    fun onPlaybackStateUpdated(
        isPausedReady: Boolean,
        positionMs: Long,
        durationMs: Long,
        suppressAll: Boolean,
        isPlaybackPaused: Boolean = isPausedReady
    ) {
        if (isDestroyed) return
        latestPositionMs = positionMs
        latestDurationMs = durationMs
        latestIsPlaybackPaused = isPlaybackPaused
        latestSuppressAll = suppressAll

        val action = computePauseRevealAction(
            isPausedReady = isPausedReady,
            suppressAll = suppressAll,
            isPanelVisible = panelView.visibility == View.VISIBLE,
            isMiniPillVisible = miniPillView.visibility == View.VISIBLE,
            dismissedForCurrentPause = dismissedForCurrentPause,
            revealAlreadyPending = revealPending,
            isPlaybackPaused = isPlaybackPaused,
            revealAttemptedForCurrentPause = revealAttemptedForCurrentPause
        )

        when (action) {
            PauseRevealAction.HIDE_AND_RESET -> {
                dismissedForCurrentPause = false
                revealAttemptedForCurrentPause = false
                hideAllImmediate()
            }
            PauseRevealAction.UPDATE_CLOCK_ONLY -> {
                tvEndsAt.text = formatFinishClock(positionMs, durationMs)
            }
            PauseRevealAction.NO_OP -> Unit
            PauseRevealAction.SCHEDULE_REVEAL -> {
                revealPending = true
                mainHandler.removeCallbacks(revealRunnable)
                mainHandler.postDelayed(revealRunnable, PAUSE_REVEAL_DELAY_MS)
            }
        }
    }

    /**
     * Explicit user tap/click on the player bar `✨ X-Ray` button:
     * opens X-Ray immediately (0ms wait) or collapses/focuses it if already open.
     */
    fun onUserXrayButtonClicked() {
        if (isDestroyed) return
        if (panelView.visibility == View.VISIBLE) {
            val toggleHasFocus = activity.findViewById<View>(R.id.btn_xray_toggle)?.isFocused == true
            if ((isTvOrRemoteActive() || toggleHasFocus) && !panelView.hasFocus()) {
                firstPersonChipView?.requestFocus()
                return
            }
            dismissForCurrentPause()
            return
        }
        dismissedForCurrentPause = false
        revealAttemptedForCurrentPause = false
        serverConfirmedEmpty = false
        revealPending = false
        latestIsPlaybackPaused = true
        latestSuppressAll = false
        mainHandler.removeCallbacks(revealRunnable)
        miniPillView.visibility = View.GONE
        revealPanelNow(notifyIfUnavailable = true, forceServerRecheck = true)
    }

    /**
     * Handles Back gesture / TV remote Back button cleanly:
     * 1) Closes the filmography modal first if open.
     * 2) Collapses the X-Ray panel for the current pause (`dismissedForCurrentPause = true`)
     *    so periodic `updateSeekBar()` ticks NEVER re-spawn X-Ray in a zombie loop!
     */
    fun onBackPressed(): Boolean {
        if (isDestroyed) return false
        val dialog = activePersonDialog
        if (dialog != null && dialog.isShowing) {
            try { dialog.dismiss() } catch (_: Throwable) {}
            activePersonDialog = null
            return true
        }
        if (panelView.visibility == View.VISIBLE) {
            dismissForCurrentPause()
            return true
        }
        return false
    }

    fun hasOverlayFocus(): Boolean {
        return panelView.visibility == View.VISIBLE && panelView.hasFocus()
    }

    fun focusFirstChipIfAvailable(): Boolean {
        if (panelView.visibility != View.VISIBLE) return false
        val chip = firstPersonChipView ?: return false
        return chip.requestFocus()
    }

    fun hideAllImmediate() {
        revealToken++
        revealPending = false
        mainHandler.removeCallbacks(revealRunnable)
        val wasPanelVisible = panelView.visibility == View.VISIBLE
        panelView.animate().cancel()
        panelView.visibility = View.GONE
        miniPillView.visibility = View.GONE
        try {
            activePersonDialog?.takeIf { it.isShowing }?.dismiss()
        } catch (_: Throwable) {}
        activePersonDialog = null
        if (wasPanelVisible) {
            onPanelVisibilityChanged?.invoke(false, false, null)
        }
    }

    fun isAnyOverlayVisible(): Boolean {
        return panelView.visibility == View.VISIBLE || activePersonDialog?.isShowing == true
    }

    fun trimMemory(isUiHidden: Boolean = true) {
        if (isDestroyed) return
        if (!isUiHidden && isAnyOverlayVisible()) {
            bitmapCache.evictAll()
            return
        }
        hideAllImmediate()
        peopleContainer.removeAllViews()
        firstPersonChipView = null
        bitmapCache.evictAll()
    }

    fun destroy() {
        if (isDestroyed) return
        isDestroyed = true
        hideAllImmediate()
        peopleContainer.removeAllViews()
        firstPersonChipView = null
        synchronized(fetchLock) {
            inFlightFetch?.cancel()
            inFlightFetch = null
        }
        scope.cancel()
        bitmapCache.evictAll()
        try {
            rootContainer.removeView(panelView)
            rootContainer.removeView(miniPillView)
        } catch (_: Throwable) {}
    }

    private fun revealPanelNow(notifyIfUnavailable: Boolean = false, forceServerRecheck: Boolean = false) {
        if (isDestroyed || dismissedForCurrentPause) return
        val token = ++revealToken
        revealAttemptedForCurrentPause = true
        val existing = cachedPayload
        if (existing != null) {
            renderPayloadIntoPanel(existing)
            return
        }
        val deferred = getOrStartPayloadFetch(ignoreConfirmedEmpty = forceServerRecheck)
        if (deferred == null) {
            if (notifyIfUnavailable) {
                Toast.makeText(
                    activity,
                    "✨ X-Ray sin datos de reparto para este vídeo",
                    Toast.LENGTH_SHORT
                ).show()
            }
            return
        }
        scope.launch {
            val loaded = cachedPayload ?: deferred.await()
            withContext(Dispatchers.Main) {
                if (!shouldCompleteAsyncReveal(
                        isDestroyed = isDestroyed,
                        dismissedForCurrentPause = dismissedForCurrentPause,
                        isPlaybackPaused = latestIsPlaybackPaused,
                        suppressAll = latestSuppressAll,
                        requestToken = token,
                        currentToken = revealToken
                    )
                ) {
                    return@withContext
                }
                if (loaded != null && loaded.people.isNotEmpty()) {
                    renderPayloadIntoPanel(loaded)
                } else if (notifyIfUnavailable) {
                    Toast.makeText(
                        activity,
                        "✨ X-Ray sin datos de reparto para este vídeo",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun renderPayloadIntoPanel(data: XrayPayload) {
        if (data.people.isEmpty()) return

        val cleanHead = if (data.episodeTitle.isNotBlank()) {
            "${data.title} · ${data.episodeTitle}"
        } else if (data.year.isNotBlank()) {
            "${data.title} (${data.year})"
        } else {
            data.title
        }
        tvHeaderTitle.text = cleanHead
        tvEndsAt.text = formatFinishClock(latestPositionMs, latestDurationMs)

        if (data.factLine.isNotBlank()) {
            tvFactLine.text = data.factLine
            tvFactLine.visibility = View.VISIBLE
        } else {
            tvFactLine.visibility = View.GONE
        }

        peopleContainer.removeAllViews()
        var firstChip: View? = null
        for (person in data.people.take(12)) {
            val chip = createPersonChipView(person)
            chip.id = View.generateViewId()
            if (firstChip == null) {
                firstChip = chip
            }
            peopleContainer.addView(chip)
        }
        firstPersonChipView = firstChip
        applyOverlayPositioning()

        miniPillView.visibility = View.GONE
        panelView.alpha = 0f
        panelView.visibility = View.VISIBLE
        panelView.animate().alpha(1f).setDuration(220L).start()
        onPanelVisibilityChanged?.invoke(true, isAnchoredAtTopNow(), firstPersonChipView)

        if (isTvOrRemoteActive() && !isControlsBarVisible && !panelView.hasFocus()) {
            firstChip?.post {
                if (!isDestroyed && panelView.visibility == View.VISIBLE && !isControlsBarVisible) {
                    firstChip.requestFocus()
                }
            }
        }
    }

    private fun dismissForCurrentPause() {
        val hadFocusInsidePanel = panelView.hasFocus()
        revealToken++
        dismissedForCurrentPause = true
        revealPending = false
        mainHandler.removeCallbacks(revealRunnable)
        panelView.animate().cancel()
        panelView.visibility = View.GONE
        miniPillView.visibility = View.VISIBLE
        onPanelVisibilityChanged?.invoke(false, false, null)
        if (hadFocusInsidePanel) {
            val fallbackFocus = activity.findViewById<View>(R.id.btn_xray_toggle)
                ?.takeIf { isControlsBarVisible && it.visibility == View.VISIBLE }
                ?: miniPillView
            fallbackFocus.post { fallbackFocus.requestFocus() }
        }
    }

    private fun createPanelView(): LinearLayout {
        val bg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(16).toFloat()
            setColor(Color.parseColor("#D90E0C1A"))
            setStroke(dp(1), Color.parseColor("#4D8B5CF6"))
        }

        val root = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            background = bg
            elevation = dp(12).toFloat()
            setPadding(dp(14), dp(10), dp(14), dp(10))
            isClickable = true
            isFocusable = false
            visibility = View.GONE
        }

        val header = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }

        val tagBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(6).toFloat()
            setColor(Color.parseColor("#33F59E0B"))
            setStroke(dp(1), Color.parseColor("#88F59E0B"))
        }
        val tvTag = TextView(activity).apply {
            text = "✨ X-RAY"
            setTextColor(Color.parseColor("#FDE68A"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            setTypeface(typeface, Typeface.BOLD)
            background = tagBg
            setPadding(dp(7), dp(2), dp(7), dp(2))
        }
        header.addView(tvTag)

        val tvTitle = TextView(activity).apply {
            tag = "xray_title"
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.5f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            maxWidth = dp(320)
            setPadding(dp(9), 0, dp(9), 0)
        }
        header.addView(tvTitle)

        val tvEnds = TextView(activity).apply {
            tag = "xray_ends"
            setTextColor(Color.parseColor("#A7F3D0"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            setPadding(0, 0, dp(10), 0)
        }
        header.addView(tvEnds)

        val spacer = View(activity).apply {
            layoutParams = LinearLayout.LayoutParams(0, 1, 1f)
        }
        header.addView(spacer)

        val btnHide = TextView(activity).apply {
            id = View.generateViewId()
            tag = "xray_hide"
            text = "✕"
            gravity = Gravity.CENTER
            minWidth = dp(34)
            minHeight = dp(30)
            setTextColor(Color.parseColor("#CBD5E1"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
            setTypeface(typeface, Typeface.BOLD)
            setPadding(dp(10), dp(5), dp(10), dp(5))
            contentDescription = "Ocultar X-Ray"
            isFocusable = true
            isClickable = true
            setBackgroundResource(R.drawable.bg_tv_button_selector)
            setOnClickListener { dismissForCurrentPause() }
        }
        header.addView(btnHide)
        root.addView(header)

        val hScroll = HorizontalScrollView(activity).apply {
            isHorizontalScrollBarEnabled = false
            isFocusable = false
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                topMargin = dp(8)
            }
        }

        val strip = LinearLayout(activity).apply {
            tag = "xray_people"
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        hScroll.addView(strip)
        root.addView(hScroll)

        val tvFact = TextView(activity).apply {
            tag = "xray_fact"
            setTextColor(Color.parseColor("#A1A1AA"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            visibility = View.GONE
            setPadding(0, dp(6), 0, 0)
        }
        root.addView(tvFact)

        return root
    }

    private fun createMiniPillView(): TextView {
        val normalBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(18).toFloat()
            setColor(Color.parseColor("#D9141126"))
            setStroke(dp(1), Color.parseColor("#7C3AED"))
        }
        val focusBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(18).toFloat()
            setColor(Color.parseColor("#7C3AED"))
            setStroke(dp(2), Color.WHITE)
        }
        return TextView(activity).apply {
            id = View.generateViewId()
            text = "✨ Ver X-Ray"
            setTextColor(Color.parseColor("#EDE9FE"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            setTypeface(typeface, Typeface.BOLD)
            background = normalBg
            elevation = dp(10).toFloat()
            setPadding(dp(14), dp(8), dp(14), dp(8))
            visibility = View.GONE
            isFocusable = true
            isClickable = true
            setOnFocusChangeListener { v, hasFocus ->
                v.background = if (hasFocus) focusBg else normalBg
                (v as? TextView)?.setTextColor(if (hasFocus) Color.WHITE else Color.parseColor("#EDE9FE"))
                v.scaleX = if (hasFocus) 1.05f else 1.0f
                v.scaleY = if (hasFocus) 1.05f else 1.0f
            }
            setOnClickListener {
                dismissedForCurrentPause = false
                visibility = View.GONE
                revealPanelNow()
            }
        }
    }

    private fun createPersonChipView(person: XrayPerson): View {
        val normalBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(12).toFloat()
            setColor(Color.parseColor("#26FFFFFF"))
            setStroke(dp(1), Color.parseColor("#22FFFFFF"))
        }
        val focusedBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(12).toFloat()
            setColor(Color.parseColor("#447C3AED"))
            setStroke(dp(2), Color.parseColor("#A78BFA"))
        }

        val chip = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = normalBg
            isFocusable = true
            isClickable = true
            setPadding(dp(7), dp(5), dp(10), dp(5))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                rightMargin = dp(8)
            }
            setOnFocusChangeListener { v, hasFocus ->
                v.background = if (hasFocus) focusedBg else normalBg
                v.scaleX = if (hasFocus) 1.04f else 1.0f
                v.scaleY = if (hasFocus) 1.04f else 1.0f
                if (hasFocus) {
                    (v.parent?.parent as? HorizontalScrollView)?.let { hsv ->
                        val targetScrollX = (v.left - (hsv.width - v.width) / 2).coerceAtLeast(0)
                        hsv.smoothScrollTo(targetScrollX, 0)
                    }
                }
            }
            setOnClickListener {
                openPersonCatalogModal(person)
            }
        }

        val avatarSize = dp(36)
        val avatarContainer = FrameLayout(activity).apply {
            layoutParams = LinearLayout.LayoutParams(avatarSize, avatarSize)
            background = GradientDrawable().apply {
                shape = GradientDrawable.OVAL
                setColor(Color.parseColor("#312E81"))
            }
        }

        val fallbackEmoji = TextView(activity).apply {
            text = if (person.roleType == "director") "🎬" else "👤"
            gravity = Gravity.CENTER
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        avatarContainer.addView(fallbackEmoji)

        val ivAvatar = ImageView(activity).apply {
            scaleType = ImageView.ScaleType.CENTER_CROP
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }
        avatarContainer.addView(ivAvatar)
        chip.addView(avatarContainer)

        if (!person.profilePath.isNullOrBlank()) {
            val url = if (person.profilePath.startsWith("http")) {
                person.profilePath
            } else {
                "https://image.tmdb.org/t/p/w185${person.profilePath}"
            }
            loadCircularAvatarAsync(url, ivAvatar, fallbackEmoji)
        }

        val metaCol = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(8), 0, 0, 0)
        }
        val tvName = TextView(activity).apply {
            text = person.name
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            maxWidth = dp(135)
        }
        val tvRole = TextView(activity).apply {
            text = person.character.ifBlank { if (person.roleType == "director") "Dirección" else "Reparto" }
            setTextColor(Color.parseColor("#CBD5E1"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 10.5f)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            maxWidth = dp(135)
        }
        metaCol.addView(tvName)
        metaCol.addView(tvRole)
        chip.addView(metaCol)

        return chip
    }

    private fun openPersonCatalogModal(person: XrayPerson) {
        if (isDestroyed || activity.isFinishing || activity.isDestroyed) return
        activePersonDialog?.takeIf { it.isShowing }?.dismiss()

        val dialog = Dialog(activity, R.style.Theme_Cineflix_TVDialog)
        activePersonDialog = dialog

        val cardBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(18).toFloat()
            setColor(Color.parseColor("#F5121020"))
            setStroke(dp(1), Color.parseColor("#7C3AED"))
        }

        val root = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            background = cardBg
            setPadding(dp(20), dp(16), dp(20), dp(16))
        }

        val headRow = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        val tvModalTitle = TextView(activity).apply {
            text = "🎬 En Cineflix con ${person.name}"
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }
        val btnClose = TextView(activity).apply {
            text = "✕ Cerrar"
            setTextColor(Color.parseColor("#EDE9FE"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 12.5f)
            setTypeface(typeface, Typeface.BOLD)
            setPadding(dp(12), dp(6), dp(12), dp(6))
            isFocusable = true
            isClickable = true
            setBackgroundResource(R.drawable.bg_tv_button_selector)
            setOnClickListener { dialog.dismiss() }
        }
        headRow.addView(tvModalTitle)
        headRow.addView(btnClose)
        root.addView(headRow)

        val tvStatus = TextView(activity).apply {
            text = "Buscando películas y series disponibles en Cineflix..."
            setTextColor(Color.parseColor("#A1A1AA"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
            setPadding(0, dp(14), 0, dp(8))
        }
        root.addView(tvStatus)

        val maxScrollHeightPx = (activity.resources.displayMetrics.heightPixels * 0.54f)
            .toInt()
            .coerceIn(dp(150), dp(290))
        val scroll = ScrollView(activity).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                maxScrollHeightPx
            ).apply { topMargin = dp(6) }
            visibility = View.GONE
        }
        val listContainer = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
        }
        scroll.addView(listContainer)
        root.addView(scroll)

        dialog.setContentView(root)
        dialog.setOnDismissListener {
            if (activePersonDialog === dialog) activePersonDialog = null
        }

        val targetW = (activity.resources.displayMetrics.widthPixels * 0.84f).toInt().coerceAtMost(dp(640))
        dialog.window?.setLayout(targetW, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()
        btnClose.post { btnClose.requestFocus() }

        scope.launch {
            ensureWatchlistLoaded()
            val items = fetchPersonCatalogFromServer(person.id)
            withContext(Dispatchers.Main) {
                if (isDestroyed || !dialog.isShowing) return@withContext
                if (items.isEmpty()) {
                    tvStatus.text = "No hay otros títulos indexados con ${person.name} en este momento."
                    return@withContext
                }
                tvStatus.visibility = View.GONE
                scroll.visibility = View.VISIBLE
                listContainer.removeAllViews()

                var firstBtn: View? = null
                for (item in items) {
                    val itemRow = buildPersonCatalogRow(item, dialog)
                    if (firstBtn == null) {
                        firstBtn = itemRow.findViewWithTag("xray_open_btn")
                    }
                    listContainer.addView(itemRow)
                }
                firstBtn?.post { firstBtn.requestFocus() }
            }
        }
    }

    private fun buildPersonCatalogRow(item: PersonCatalogItem, parentDialog: Dialog): View {
        val rowBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(12).toFloat()
            setColor(Color.parseColor("#1FFFFFFF"))
        }
        val row = LinearLayout(activity).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = rowBg
            setPadding(dp(12), dp(9), dp(12), dp(9))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(8) }
        }

        val infoCol = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }
        val badgeType = if (item.mediaType == "tv") "📺 Serie" else "🎬 Película"
        val tvTitle = TextView(activity).apply {
            text = item.title
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13.5f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        val subtitleParts = mutableListOf(badgeType)
        if (item.year.isNotBlank()) subtitleParts.add(item.year)
        if (item.personRole.isNotBlank()) subtitleParts.add(item.personRole)
        val tvSub = TextView(activity).apply {
            text = subtitleParts.joinToString(" · ")
            setTextColor(Color.parseColor("#A1A1AA"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        infoCol.addView(tvTitle)
        infoCol.addView(tvSub)
        row.addView(infoCol)

        val canonicalCid = (if (item.mediaType == "tv") "tv_" else "mv_") + item.id.removePrefix("tv_").removePrefix("mv_")
        val btnWatchlist = TextView(activity).apply {
            val initiallySaved = isInWatchlist(canonicalCid)
            text = if (initiallySaved) "✅ Pendientes" else "📌 + Pendientes"
            setTextColor(Color.parseColor(if (initiallySaved) "#A7F3D0" else "#EDE9FE"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            setTypeface(typeface, Typeface.BOLD)
            setPadding(dp(10), dp(6), dp(10), dp(6))
            isFocusable = true
            isClickable = true
            setBackgroundResource(R.drawable.bg_tv_button_selector)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { leftMargin = dp(8) }
            setOnClickListener {
                toggleWatchlistAsync(item, canonicalCid, this)
            }
        }
        row.addView(btnWatchlist)

        val btnOpen = TextView(activity).apply {
            tag = "xray_open_btn"
            text = "ℹ Ficha"
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            setTypeface(typeface, Typeface.BOLD)
            setPadding(dp(10), dp(6), dp(10), dp(6))
            isFocusable = true
            isClickable = true
            setBackgroundResource(R.drawable.bg_tv_button_selector)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { leftMargin = dp(6) }
            setOnClickListener {
                parentDialog.dismiss()
                onOpenCatalogItem(item)
            }
        }
        row.addView(btnOpen)

        return row
    }

    private fun isInWatchlist(canonicalCid: String): Boolean {
        val raw = canonicalCid.removePrefix("tv_").removePrefix("mv_")
        return synchronized(watchlistIds) {
            watchlistIds.contains(canonicalCid) || watchlistIds.contains(raw)
        }
    }

    private fun toggleWatchlistAsync(item: PersonCatalogItem, canonicalCid: String, buttonView: TextView) {
        val scopedPhone = normalizeScopedUserPhone(userPhone)
        if (scopedPhone.isBlank()) {
            Toast.makeText(activity, "Inicia sesión para guardar en Pendientes", Toast.LENGTH_SHORT).show()
            return
        }
        val currentlyIn = isInWatchlist(canonicalCid)
        scope.launch {
            val ok = if (currentlyIn) {
                deleteFromWatchlistServer(scopedPhone, canonicalCid)
            } else {
                postToWatchlistServer(scopedPhone, canonicalCid, item)
            }
            if (ok) {
                synchronized(watchlistIds) {
                    val raw = canonicalCid.removePrefix("tv_").removePrefix("mv_")
                    if (currentlyIn) {
                        watchlistIds.remove(canonicalCid)
                        watchlistIds.remove(raw)
                    } else {
                        watchlistIds.add(canonicalCid)
                    }
                }
                withContext(Dispatchers.Main) {
                    onWatchlistMutated?.invoke()
                    if (isDestroyed) return@withContext
                    val nowSaved = !currentlyIn
                    buttonView.text = if (nowSaved) "✅ Pendientes" else "📌 + Pendientes"
                    buttonView.setTextColor(Color.parseColor(if (nowSaved) "#A7F3D0" else "#EDE9FE"))
                    Toast.makeText(
                        activity,
                        if (nowSaved) "➕ Añadido a Pendientes" else "Quitado de Pendientes",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun ensureWatchlistLoaded() {
        if (watchlistLoaded) return
        val scopedPhone = normalizeScopedUserPhone(userPhone)
        if (scopedPhone.isBlank()) {
            watchlistLoaded = true
            return
        }
        try {
            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/watchlist").apply {
                requestMethod = "GET"
                connectTimeout = 4500
                readTimeout = 4500
                setRequestProperty("x-user-phone", scopedPhone)
            }
            try {
                if (conn.responseCode == 200) {
                    val body = conn.inputStream.bufferedReader().use { it.readText() }
                    val arr = JSONArray(body)
                    synchronized(watchlistIds) {
                        for (i in 0 until arr.length()) {
                            val cid = arr.optJSONObject(i)?.optString("content_id", "")?.trim().orEmpty()
                            if (cid.isNotEmpty()) watchlistIds.add(cid)
                        }
                    }
                    watchlistLoaded = true
                }
            } finally {
                conn.disconnect()
            }
        } catch (_: Throwable) {}
    }

    private fun postToWatchlistServer(scopedPhone: String, canonicalCid: String, item: PersonCatalogItem): Boolean {
        return try {
            val payloadJson = JSONObject().apply {
                put("content_type", if (item.mediaType == "tv") "series" else "movie")
                put("content_id", canonicalCid)
                put("title", item.title)
                if (!item.posterPath.isNullOrBlank()) put("poster", item.posterPath)
                if (!item.year.isBlank()) put("year", item.year)
                if (item.tmdbId > 0) put("tmdb_id", item.tmdbId)
                if (!item.payload.isNullOrBlank()) put("payload", item.payload)
            }.toString()

            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/watchlist").apply {
                requestMethod = "POST"
                connectTimeout = 5000
                readTimeout = 5000
                doOutput = true
                setRequestProperty("Content-Type", "application/json; charset=UTF-8")
                setRequestProperty("x-user-phone", scopedPhone)
            }
            try {
                conn.outputStream.use { it.write(payloadJson.toByteArray(Charsets.UTF_8)) }
                conn.responseCode in 200..299
            } finally {
                conn.disconnect()
            }
        } catch (_: Throwable) {
            false
        }
    }

    private fun deleteFromWatchlistServer(scopedPhone: String, canonicalCid: String): Boolean {
        return try {
            val enc = URLEncoder.encode(canonicalCid, "UTF-8")
            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/watchlist/$enc").apply {
                requestMethod = "DELETE"
                connectTimeout = 5000
                readTimeout = 5000
                setRequestProperty("x-user-phone", scopedPhone)
            }
            try {
                conn.responseCode in 200..299
            } finally {
                conn.disconnect()
            }
        } catch (_: Throwable) {
            false
        }
    }

    private fun fetchXrayPayloadFromServer(): XrayPayload? {
        return try {
            val cleanTitle = if (mediaDescriptor.isCleanCatalogTitle) {
                mediaDescriptor.title.replace(Regex("(?<=\\S)\\s+\\((?:19\\d{2}|20[0-3]\\d)\\)$"), "").trim()
            } else {
                sanitizeLookupTitle(mediaDescriptor.title)
            }
            val year = mediaDescriptor.year.ifBlank { extractYearFromTitle(mediaDescriptor.title) }
            val qs = buildString {
                append("media_type=").append(URLEncoder.encode(mediaDescriptor.mediaType, "UTF-8"))
                append("&id=").append(URLEncoder.encode(mediaDescriptor.id, "UTF-8"))
                append("&tmdb_id=").append(mediaDescriptor.tmdbId.coerceAtLeast(0))
                append("&title=").append(URLEncoder.encode(cleanTitle, "UTF-8"))
                append("&year=").append(URLEncoder.encode(year, "UTF-8"))
                append("&season=").append(mediaDescriptor.season.coerceAtLeast(1))
                append("&episode=").append(mediaDescriptor.episode.coerceAtLeast(1))
            }
            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/xray?$qs").apply {
                requestMethod = "GET"
                connectTimeout = 5000
                readTimeout = 6000
            }
            try {
                if (conn.responseCode != 200) return null
                val body = conn.inputStream.bufferedReader().use { it.readText() }
                val parsed = parseXrayResponseJson(body)
                if (parsed == null) {
                    serverConfirmedEmpty = true
                }
                parsed
            } finally {
                conn.disconnect()
            }
        } catch (e: Throwable) {
            Log.d(TAG, "X-Ray lookup skipped: ${e.message}")
            null
        }
    }

    private fun fetchPersonCatalogFromServer(personId: Int): List<PersonCatalogItem> {
        return try {
            val kidsParam = if (isKidsProfile) "&kids=1" else ""
            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection("$API_BASE/api/xray/person-catalog?person_id=$personId$kidsParam").apply {
                requestMethod = "GET"
                connectTimeout = 5000
                readTimeout = 6500
            }
            try {
                if (conn.responseCode != 200) return emptyList()
                val body = conn.inputStream.bufferedReader().use { it.readText() }
                parsePersonCatalogJson(body)
            } finally {
                conn.disconnect()
            }
        } catch (_: Throwable) {
            emptyList()
        }
    }

    private fun loadCircularAvatarAsync(url: String, targetView: ImageView, fallbackView: View) {
        val cached = bitmapCache.get(url)
        if (cached != null && !cached.isRecycled) {
            targetView.setImageBitmap(cached)
            fallbackView.visibility = View.GONE
            return
        }
        scope.launch {
            val bmp = downloadCircularThumbnail(url)
            if (bmp != null && !isDestroyed) {
                bitmapCache.put(url, bmp)
                withContext(Dispatchers.Main) {
                    if (!isDestroyed) {
                        targetView.setImageBitmap(bmp)
                        fallbackView.visibility = View.GONE
                    }
                }
            }
        }
    }

    private fun downloadCircularThumbnail(url: String): Bitmap? {
        return try {
            val conn = com.cineflix.android.util.StorageAndRamHygiene.openCompatUrlConnection(url).apply {
                connectTimeout = 4000
                readTimeout = 4500
            }
            val rawBytes = try {
                if (conn.responseCode != 200) return null
                conn.inputStream.use { it.readBytes() }
            } finally {
                conn.disconnect()
            }
            if (rawBytes.isEmpty()) return null

            val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size, bounds)
            var sampleSize = 1
            while (bounds.outWidth / sampleSize > AVATAR_PX * 2 && bounds.outHeight / sampleSize > AVATAR_PX * 2) {
                sampleSize *= 2
            }
            val decodeOpts = BitmapFactory.Options().apply {
                inSampleSize = sampleSize
                inPreferredConfig = Bitmap.Config.ARGB_8888
            }
            val decoded = BitmapFactory.decodeByteArray(rawBytes, 0, rawBytes.size, decodeOpts) ?: return null
            val square = kotlin.math.min(decoded.width, decoded.height)
            if (square <= 0) {
                decoded.recycle()
                return null
            }
            val xOff = (decoded.width - square) / 2
            val yOff = (decoded.height - square) / 2
            val cropped = Bitmap.createBitmap(decoded, xOff, yOff, square, square)
            if (cropped !== decoded) decoded.recycle()
            val scaled = Bitmap.createScaledBitmap(cropped, AVATAR_PX, AVATAR_PX, true)
            if (scaled !== cropped) cropped.recycle()

            val circle = Bitmap.createBitmap(AVATAR_PX, AVATAR_PX, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(circle)
            val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
                shader = BitmapShader(scaled, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            }
            val r = AVATAR_PX / 2f
            canvas.drawCircle(r, r, r, paint)
            scaled.recycle()
            circle
        } catch (_: Throwable) {
            null
        }
    }

    private fun dp(value: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value.toFloat(),
            activity.resources.displayMetrics
        ).toInt()
    }
}
