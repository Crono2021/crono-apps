package com.cineflix.android

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.app.UiModeManager
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.TypedValue
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.cineflix.android.ui.player.PlayerActivity
import com.cineflix.android.ui.player.cast.CastSessionCoordinator
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.webkit.WebViewAssetLoader
import androidx.lifecycle.lifecycleScope
import com.cineflix.android.util.StorageAndRamHygiene
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var bridge: AndroidBridge
    private lateinit var engine: TelegramEngine
    private var isAndroidTV = false
    private lateinit var castMiniBar: LinearLayout
    private lateinit var tvMiniCastTitle: TextView
    private lateinit var tvMiniCastSubtitle: TextView
    private lateinit var btnMiniCastPlayPause: ImageButton
    private var wasMiniBarVisible = false
    @Volatile private var shouldClearWebViewMemoryCacheOnLoad = false
    @Volatile private var headlessLiveTvPumpDeadlineElapsedMs = 0L
    private val mainIdleHandler = Handler(Looper.getMainLooper())
    private val headlessTuneRePauseRunnable = Runnable {
        if (android.os.SystemClock.elapsedRealtime() < headlessLiveTvPumpDeadlineElapsedMs) {
            return@Runnable
        }
        if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) &&
            ::webView.isInitialized &&
            (!::bridge.isInitialized || !bridge.isCineScreenActive())
        ) {
            runCatching {
                webView.onPause()
                webView.clearCache(false)
            }
        }
    }
    private val headlessLiveTvPumpRunnable = object : Runnable {
        override fun run() {
            val nowElapsed = android.os.SystemClock.elapsedRealtime()
            if (!::webView.isInitialized || nowElapsed >= headlessLiveTvPumpDeadlineElapsedMs) {
                headlessLiveTvPumpDeadlineElapsedMs = 0L
                scheduleRePauseIfStopped(900L)
                return
            }
            val self = this
            webView.evaluateJavascript(
                "(function(){ return (typeof window.__cfPumpLiveTvTunePoll === 'function') ? window.__cfPumpLiveTvTunePoll() : 'IDLE'; })()"
            ) { rawRes ->
                val status = rawRes?.trim()?.removeSurrounding("\"") ?: "IDLE"
                if (status == "RUNNING" || status == "TUNING" || status == "PRELOADING") {
                    if (android.os.SystemClock.elapsedRealtime() < headlessLiveTvPumpDeadlineElapsedMs) {
                        mainIdleHandler.postDelayed(self, 160L)
                    } else {
                        headlessLiveTvPumpDeadlineElapsedMs = 0L
                        scheduleRePauseIfStopped(900L)
                    }
                } else {
                    headlessLiveTvPumpDeadlineElapsedMs = 0L
                    scheduleRePauseIfStopped(1200L)
                }
            }
        }
    }
    private val cineScreenBackgroundReleaseRunnable = Runnable {
        if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) &&
            ::bridge.isInitialized && bridge.isCineScreenActive()
        ) {
            android.util.Log.i("CineflixMain", "🧹 Stopping idle background CineScreen stream after 45s in background")
            if (::webView.isInitialized) {
                runCatching {
                    webView.evaluateJavascript(
                        "(function(){ var v = document.getElementById('cine-screen-video'); if (v) { try { v.pause(); v.removeAttribute('src'); v.load(); } catch(_){} } })();",
                        null
                    )
                    webView.clearCache(false)
                }
            }
            bridge.stopCineScreenStream()
            performIdleBackgroundHygiene()
        }
    }

    private fun wakeWebViewTemporarilyIfStopped(timeoutMs: Long = 36_000L) {
        if (!::webView.isInitialized) return
        mainIdleHandler.removeCallbacks(headlessTuneRePauseRunnable)
        if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            runCatching { webView.onResume() }
            mainIdleHandler.postDelayed(headlessTuneRePauseRunnable, timeoutMs)
        }
    }

    private fun startHeadlessLiveTvPollPump(timeoutMs: Long = 28_000L) {
        if (!::webView.isInitialized) return
        headlessLiveTvPumpDeadlineElapsedMs = android.os.SystemClock.elapsedRealtime() + timeoutMs
        wakeWebViewTemporarilyIfStopped(timeoutMs + 4_000L)
        mainIdleHandler.removeCallbacks(headlessLiveTvPumpRunnable)
        mainIdleHandler.postDelayed(headlessLiveTvPumpRunnable, 160L)
    }

    private fun stopHeadlessLiveTvPollPump() {
        headlessLiveTvPumpDeadlineElapsedMs = 0L
        mainIdleHandler.removeCallbacks(headlessLiveTvPumpRunnable)
    }

    private fun scheduleRePauseIfStopped(delayMs: Long = 800L) {
        if (!::webView.isInitialized) return
        if (android.os.SystemClock.elapsedRealtime() < headlessLiveTvPumpDeadlineElapsedMs) return
        mainIdleHandler.removeCallbacks(headlessTuneRePauseRunnable)
        if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            mainIdleHandler.postDelayed(headlessTuneRePauseRunnable, delayMs)
        }
    }

    data class OpenCatalogItemRequest(
        val mediaType: String,
        val itemId: String,
        val tmdbId: Int,
        val title: String,
        val year: String = "",
        val posterPath: String = "",
        val payload: String = "",
        val rawItemJson: String = ""
    )

    private val castStateObserver = object : CastSessionCoordinator.StateObserver {
        override fun onCastStateChanged(snapshot: CastSessionCoordinator.CastUiSnapshot) {
            updateCastMiniBar(snapshot)
        }
    }

    companion object {
        private const val CINESCREEN_BACKGROUND_IDLE_MS = 45_000L

        init {
            try {
                System.loadLibrary("c++_shared")
            } catch (e: Throwable) {
                android.util.Log.e("Cineflix", "Failed to load native libraries", e)
            }
        }
        @SuppressLint("StaticFieldLeak")
        var webViewInstance: WebView? = null
        @Volatile
        private var mainActivityRef: java.lang.ref.WeakReference<MainActivity>? = null

        @Volatile
        private var pendingInProcessNextEpisode: Triple<String, Int, Int>? = null

        @Volatile
        private var pendingInProcessOpenCatalogItem: OpenCatalogItemRequest? = null

        @Volatile
        private var pendingWatchlistRefreshFromPlayer: Boolean = false

        fun notifyWatchlistMutatedFromPlayer() {
            pendingWatchlistRefreshFromPlayer = true
        }

        fun trimWebViewMemoryFromBackgroundIfIdle() {
            val wv = webViewInstance ?: return
            wv.post {
                runCatching { wv.clearCache(false) }
            }
        }

        fun scheduleRePauseWebViewAfterHeadlessLaunch() {
            val act = mainActivityRef?.get() ?: return
            act.runOnUiThread {
                act.scheduleRePauseIfStopped(800L)
            }
        }

        fun deliverNextEpisodeFromPlayer(contentId: String, season: Int, episode: Int) {
            pendingInProcessNextEpisode = Triple(contentId, season, episode)
        }

        fun deliverOpenCatalogItemFromPlayer(
            mediaType: String,
            itemId: String,
            tmdbId: Int,
            title: String,
            year: String = "",
            posterPath: String? = null,
            payload: String? = null,
            rawItemJson: String? = null
        ) {
            pendingInProcessOpenCatalogItem = OpenCatalogItemRequest(
                mediaType = mediaType,
                itemId = itemId,
                tmdbId = tmdbId,
                title = title,
                year = year,
                posterPath = posterPath.orEmpty(),
                payload = payload.orEmpty(),
                rawItemJson = rawItemJson.orEmpty()
            )
        }

        data class NativeZapTarget(
            val channelId: String,
            val channelLabel: String,
            val programTitle: String,
            val isPremiereLocked: Boolean,
            val itemId: String = "",
            val tmdbId: Int = 0,
            val year: String = "",
            val mediaType: String = "",
            val cleanTitle: String = "",
            val posterPath: String = "",
            val payload: String = "",
            val rawItemJson: String = ""
        )

        internal fun parseNativeZapResponseJson(rawJson: String?): NativeZapTarget? {
            if (rawJson.isNullOrBlank() || rawJson == "null") return null
            return try {
                val unquoted = if (rawJson.startsWith("\"") && rawJson.endsWith("\"")) {
                    org.json.JSONArray("[$rawJson]").getString(0)
                } else {
                    rawJson
                }
                val obj = org.json.JSONObject(unquoted)
                if (!obj.optBoolean("ok", false) || obj.optBoolean("loadingEpg", false)) {
                    null
                } else {
                    NativeZapTarget(
                        channelId = obj.optString("channelId", ""),
                        channelLabel = obj.optString("channelLabel", ""),
                        programTitle = obj.optString("programTitle", ""),
                        isPremiereLocked = obj.optBoolean("isPremiereLocked", false),
                        itemId = obj.optString("itemId", ""),
                        tmdbId = obj.optInt("tmdbId", 0),
                        year = obj.optString("year", ""),
                        mediaType = obj.optString("mediaType", ""),
                        cleanTitle = obj.optString("cleanTitle", ""),
                        posterPath = obj.optString("posterPath", ""),
                        payload = obj.optString("payload", ""),
                        rawItemJson = obj.optString("rawItemJson", "")
                    )
                }
            } catch (_: Throwable) {
                null
            }
        }

        internal fun mapAndroidTvRemoteKey(keyCode: Int): Pair<Int, String>? {
            return when (keyCode) {
                KeyEvent.KEYCODE_DPAD_UP -> Pair(38, "ArrowUp")
                KeyEvent.KEYCODE_DPAD_DOWN -> Pair(40, "ArrowDown")
                KeyEvent.KEYCODE_DPAD_LEFT -> Pair(37, "ArrowLeft")
                KeyEvent.KEYCODE_DPAD_RIGHT -> Pair(39, "ArrowRight")
                KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> Pair(13, "Enter")
                KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE, KeyEvent.KEYCODE_MEDIA_PLAY, KeyEvent.KEYCODE_MEDIA_PAUSE -> Pair(179, "MediaPlayPause")
                KeyEvent.KEYCODE_MEDIA_FAST_FORWARD, KeyEvent.KEYCODE_MEDIA_NEXT -> Pair(228, "MediaFastForward")
                KeyEvent.KEYCODE_MEDIA_REWIND, KeyEvent.KEYCODE_MEDIA_PREVIOUS -> Pair(227, "MediaRewind")
                KeyEvent.KEYCODE_MENU -> Pair(82, "Menu")
                KeyEvent.KEYCODE_CHANNEL_UP, KeyEvent.KEYCODE_PAGE_UP -> Pair(427, "ChannelUp")
                KeyEvent.KEYCODE_CHANNEL_DOWN, KeyEvent.KEYCODE_PAGE_DOWN -> Pair(428, "ChannelDown")
                else -> null
            }
        }

        fun zapLiveTvFromPlayer(
            delta: Int,
            currentChannelId: String = "",
            onTargetResolved: ((NativeZapTarget) -> Unit)? = null
        ) {
            val wv = webViewInstance ?: return
            val chJs = org.json.JSONObject.quote(currentChannelId)
            val step = if (delta >= 0) 1 else -1
            wv.post {
                mainActivityRef?.get()?.startHeadlessLiveTvPollPump(28_000L)
                val btnId = if (step >= 0) "btn-ltv-apk-next" else "btn-ltv-apk-prev"
                val keyName = if (step >= 0) "ChannelUp" else "ChannelDown"
                val keyCode = if (step >= 0) 427 else 428
                wv.evaluateJavascript(
                    """
                    (function() {
                        window._cfHeadlessNativeTune = true;
                        window.__cfNextLiveTuneExpandPip = false;
                        if (typeof window.__cfZapLiveTvFromNative === 'function') {
                            return window.__cfZapLiveTvFromNative($step, $chJs);
                        }
                        var btn = document.getElementById('$btnId');
                        if (btn) { btn.click(); return '{"ok":true}'; }
                        document.dispatchEvent(new KeyboardEvent('keydown', {
                            key: '$keyName', keyCode: $keyCode, code: '$keyName', bubbles: true, cancelable: true
                        }));
                        return '{"ok":true}';
                    })();
                    """.trimIndent()
                ) { rawJson ->
                    if (onTargetResolved != null) {
                        val parsed = parseNativeZapResponseJson(rawJson)
                        if (parsed != null) {
                            onTargetResolved(parsed)
                        }
                    }
                }
            }
        }

        fun zapToSpecificLiveTvChannelFromPlayer(
            channelId: String,
            onTargetResolved: ((NativeZapTarget) -> Unit)? = null
        ) {
            val wv = webViewInstance ?: return
            if (channelId.isBlank()) return
            val chJs = org.json.JSONObject.quote(channelId)
            wv.post {
                mainActivityRef?.get()?.startHeadlessLiveTvPollPump(28_000L)
                wv.evaluateJavascript(
                    """
                    (function() {
                        window._cfHeadlessNativeTune = true;
                        window.__cfNextLiveTuneExpandPip = false;
                        if (typeof window.__cfTuneLiveTvByChannelIdFromNative === 'function') {
                            return window.__cfTuneLiveTvByChannelIdFromNative($chJs);
                        }
                        return '{"ok":false}';
                    })();
                    """.trimIndent()
                ) { rawJson ->
                    if (onTargetResolved != null) {
                        val parsed = parseNativeZapResponseJson(rawJson)
                        if (parsed != null) {
                            onTargetResolved(parsed)
                        }
                    }
                }
            }
        }

        fun preloadNextLiveTvProgramFromPlayer(channelId: String) {
            val wv = webViewInstance ?: return
            val chJs = org.json.JSONObject.quote(channelId)
            wv.post {
                mainActivityRef?.get()?.startHeadlessLiveTvPollPump(12_500L)
                wv.evaluateJavascript(
                    """
                    (function() {
                        if (typeof window.__cfPreloadNextLiveTvFromNative === 'function') {
                            return window.__cfPreloadNextLiveTvFromNative($chJs);
                        }
                        return '{"ok":false}';
                    })();
                    """.trimIndent(),
                    null
                )
            }
        }

        fun stopLiveTvFromPlayer(reopenGrid: Boolean = true, onlyIfNotTuning: Boolean = false) {
            val wv = webViewInstance ?: return
            val reopenFlag = if (reopenGrid) "true" else "false"
            val idleGuardFlag = if (onlyIfNotTuning) "true" else "false"
            wv.post {
                if (!onlyIfNotTuning) {
                    mainActivityRef?.get()?.stopHeadlessLiveTvPollPump()
                }
                wv.evaluateJavascript(
                    """
                    (function() {
                        if ($idleGuardFlag && typeof window.__cfStopLiveTvFromNativeExit === 'function') {
                            window.__cfStopLiveTvFromNativeExit();
                            return;
                        }
                        if (typeof window.__cfStopLiveTvMode === 'function') {
                            window.__cfStopLiveTvMode($reopenFlag);
                        } else if ($reopenFlag) {
                            var b = document.getElementById('btn-ltv-apk-stop');
                            if (b) b.click();
                        } else {
                            window.__cfLiveTvActive = false;
                            window.__cfLiveTvMeta = null;
                        }
                    })();
                    """.trimIndent(),
                    null
                )
            }
        }

        fun advanceLiveTvProgramFromPlayer(channelId: String): Boolean {
            val wv = webViewInstance ?: return false
            val chJs = org.json.JSONObject.quote(channelId)
            wv.post {
                mainActivityRef?.get()?.startHeadlessLiveTvPollPump(32_000L)
                wv.evaluateJavascript(
                    """
                    (function() {
                        window._cfHeadlessNativeTune = true;
                        window.__cfNextLiveTuneExpandPip = false;
                        if (typeof window.__cfAdvanceLiveTvSlot === 'function') {
                            window.__cfAdvanceLiveTvSlot({
                                channelId: $chJs,
                                headlessNative: true,
                                expandFromPip: false
                            });
                            return;
                        }
                        var resumeBtn = document.getElementById('btn-ltv-apk-resume');
                        if (resumeBtn) {
                            window.__cfNextLiveTuneExpandPip = false;
                            resumeBtn.click();
                        }
                    })();
                    """.trimIndent(),
                    null
                )
            }
            return true
        }
    }

    private var pendingNextEpisodeArgs: Triple<String, Int, Int>? = null
    private var pendingOpenCatalogItem: OpenCatalogItemRequest? = null

    /** Receives result from PlayerActivity when an episode finishes playing or X-Ray opens a ficha */
    private val playerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            if (data?.getBooleanExtra("next_episode", false) == true) {
                val contentId = data.getStringExtra("content_id") ?: ""
                val season = data.getIntExtra("season", 1)
                val episode = data.getIntExtra("episode", 1)
                android.util.Log.i("CineflixMain", "Auto-play: next episode after $contentId S${season}E${episode}")
                pendingNextEpisodeArgs = Triple(contentId, season, episode)
            } else if (data?.getBooleanExtra("open_catalog_item", false) == true) {
                pendingOpenCatalogItem = OpenCatalogItemRequest(
                    mediaType = data.getStringExtra("media_type") ?: "movie",
                    itemId = data.getStringExtra("item_id") ?: "",
                    tmdbId = data.getIntExtra("tmdb_id", 0),
                    title = data.getStringExtra("title") ?: "",
                    year = data.getStringExtra("year") ?: "",
                    posterPath = data.getStringExtra("poster_path") ?: "",
                    payload = data.getStringExtra("payload") ?: "",
                    rawItemJson = data.getStringExtra("raw_item_json") ?: ""
                )
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Detect if running on Android TV or non-touchscreen AOSP HDMI TV box
        isAndroidTV = StorageAndRamHygiene.isTelevision(this)
        android.util.Log.i("CineflixMain", "Android TV mode: $isAndroidTV")

        engine = TelegramEngine.getInstance(this)

        val appDataDir = applicationContext.dataDir ?: filesDir.parentFile ?: filesDir
        val prefs = getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        if (!StorageAndRamHygiene.isWebViewInitializedInProcess() &&
            prefs.getBoolean(StorageAndRamHygiene.PREF_PENDING_PRE_WEBVIEW_PURGE, false)
        ) {
            prefs.edit().putBoolean(StorageAndRamHygiene.PREF_PENDING_PRE_WEBVIEW_PURGE, false).apply()
            StorageAndRamHygiene.stageWebViewCachesForAsyncDeletion(appDataDir, cacheDir)
        }

        // Mark WebView active BEFORE instantiating WebView(this) so background coroutines never
        // unlink live Chromium SimpleCache / Code Cache / GPUCache files while FDs are open.
        StorageAndRamHygiene.markWebViewInitialized()
        webView = WebView(this)
        webViewInstance = webView
        mainActivityRef = java.lang.ref.WeakReference(this)

        // Proactive disk hygiene on startup (off-main-thread, SimpleCache-safe):
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                StorageAndRamHygiene.cleanStagedWebViewTrash(cacheDir, appDataDir)
                StorageAndRamHygiene.cleanEphemeralCacheArtifacts(cacheDir)
                val webViewQuota = if (isAndroidTV) {
                    StorageAndRamHygiene.DEFAULT_TV_WEBVIEW_CACHE_CAP_BYTES
                } else {
                    StorageAndRamHygiene.DEFAULT_MOBILE_WEBVIEW_CACHE_CAP_BYTES
                }
                val (overQuota, _) = StorageAndRamHygiene.enforceWebViewCacheQuota(
                    dataDir = appDataDir,
                    cacheDir = cacheDir,
                    maxCacheBytes = webViewQuota,
                    isWebViewActive = true
                )
                if (overQuota) {
                    shouldClearWebViewMemoryCacheOnLoad = true
                    withContext(Dispatchers.Main) {
                        if (::webView.isInitialized) {
                            runCatching { webView.clearCache(true) }
                        }
                    }
                    delay(1500L)
                    if (StorageAndRamHygiene.measureWebViewDisposableCacheBytes(appDataDir, cacheDir) > webViewQuota) {
                        prefs.edit().putBoolean(StorageAndRamHygiene.PREF_PENDING_PRE_WEBVIEW_PURGE, true).apply()
                    }
                }
            } catch (e: Throwable) {
                android.util.Log.w("CineflixMain", "Startup storage hygiene warning: ${e.message}")
            }
        }

        WebView.setWebContentsDebuggingEnabled(false)
        webView.apply {
            isFocusable = true
            isFocusableInTouchMode = true
            keepScreenOn = true
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                allowFileAccess = true
                allowContentAccess = true
                databaseEnabled = true
                mediaPlaybackRequiresUserGesture = false
                setSupportZoom(false)
                builtInZoomControls = false
                displayZoomControls = false
                @Suppress("DEPRECATION")
                allowFileAccessFromFileURLs = true
                @Suppress("DEPRECATION")
                allowUniversalAccessFromFileURLs = true
            }

            // Instantiate AndroidBridge ONCE (avoids leaked CoroutineScope + duplicate authState collectors)
            bridge = AndroidBridge(this@MainActivity, this, engine)
            bridge.setPlayerLauncher { intent -> playerLauncher.launch(intent) }
            addJavascriptInterface(bridge, "AndroidBridge")

            // Usar WebViewAssetLoader crea un servidor HTTP interno virtual para evadir CORS/ES Modules
            val assetLoader = WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(this@MainActivity))
                .build()

            webViewClient = object : WebViewClient() {
                override fun shouldInterceptRequest(
                    view: WebView,
                    request: WebResourceRequest
                ): WebResourceResponse? {
                    val path = request.url.path ?: ""
                    val cineflixOrigin = request.url.scheme == "https" &&
                        request.url.host == "cineflixapp.duckdns.org"
                    if (cineflixOrigin && path.startsWith("/assets/index-") &&
                        (path.endsWith(".js") || path.endsWith(".css"))) {
                        try {
                            val assetFiles = assets.list("www/assets") ?: emptyArray()
                            val requestedJs = path.substringAfterLast('/')
                            val localJs = assetFiles.firstOrNull { it == requestedJs }
                            if (localJs != null) {
                                android.util.Log.i("CineflixMain", "⚡ Intercepted $path -> serving local APK asset www/assets/$localJs")
                                val stream = assets.open("www/assets/$localJs")
                                val mime = if (path.endsWith(".css")) "text/css" else "application/javascript"
                                return WebResourceResponse(mime, "UTF-8", stream)
                            }
                        } catch (e: Throwable) {
                            android.util.Log.e("CineflixMain", "Failed to intercept JS asset: ${e.message}")
                        }
                    }
                    if (cineflixOrigin && path == "/lab-assets/enhancements-es5.js") {
                        val ver = request.url.getQueryParameter("v").orEmpty()
                        if (ver.isEmpty() ||
                            ver == "tizen24_v5_master34" ||
                            ver == "tizen24_v5_master35" ||
                            ver == "tizen24_v5_master36" ||
                            ver == "tizen24_v5_master36_r2" ||
                            ver == "tizen24_v5_master37" ||
                            ver.startsWith("tizen24_v5_master38")
                        ) {
                            try {
                                val stream = assets.open("www/lab-assets/enhancements-es5.js")
                                android.util.Log.i("CineflixMain", "⚡ Intercepted $path?v=$ver -> serving local APK master38 enhancements-es5.js")
                                return WebResourceResponse("application/javascript", "UTF-8", stream)
                            } catch (e: Throwable) {
                                android.util.Log.w("CineflixMain", "Local enhancements-es5.js fallback note: ${e.message}")
                            }
                        }
                    }
                    return assetLoader.shouldInterceptRequest(request.url)
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    if (shouldClearWebViewMemoryCacheOnLoad) {
                        shouldClearWebViewMemoryCacheOnLoad = false
                        runCatching { view.clearCache(false) }
                    }

                    val isAmazon = android.os.Build.MANUFACTURER.equals("Amazon", ignoreCase = true)
                    val tvFlag = if (isAndroidTV) "true" else "false"
                    val platformStr = if (isAndroidTV) "android_tv" else "android"
                    val vCode = try {
                        val pi = packageManager.getPackageInfo(packageName, 0)
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) pi.longVersionCode else @Suppress("DEPRECATION") pi.versionCode.toLong()
                    } catch (e: Throwable) { 2L }
                    val devModelJs = org.json.JSONObject.quote(TelegramEngine.resolveDeviceModel(this@MainActivity))
                    val sysVerJs = org.json.JSONObject.quote(TelegramEngine.resolveSystemVersion())
                    view.evaluateJavascript(
                        "window._cineflixIsTV = $tvFlag; " +
                        "window.__appPlatform = '$platformStr'; " +
                        "window.__appVersion = $vCode; " +
                        "window.__cineflixDeviceModel = $devModelJs; " +
                        "window.__cineflixSystemVersion = $sysVerJs; " +
                        "document.documentElement.classList.toggle('android-tv', $tvFlag); " +
                        "if ($tvFlag && !$isAmazon && !window.__cfTvKeyBlurGuardBound) { " +
                        "  window.__cfTvKeyBlurGuardBound = true; " +
                        "  window.addEventListener('keydown', function(e) { " +
                        "    if ((e.keyCode === 13 || e.key === 'Enter') && document.activeElement && (document.activeElement.tagName === 'INPUT' || document.activeElement.tagName === 'TEXTAREA')) { " +
                        "      e.preventDefault(); " +
                        "    } " +
                        "  }, true); " +
                        "  window.addEventListener('blur', function(e) { " +
                        "    if (e.target && (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA')) { " +
                        "       if (window.cineflixTvNav && window.cineflixTvNav.inputMode) { " +
                        "           e.stopImmediatePropagation(); " +
                        "           setTimeout(function() { e.target.focus(); }, 50); " +
                        "       } " +
                        "    } " +
                        "  }, true); " +
                        "}",
                        null
                    )

                    // Run WebView storage hygiene (unregister unused ServiceWorkers, purge CacheStorage & stale v1/v2/v3 IDB keys)
                    view.evaluateJavascript(StorageAndRamHygiene.buildWebViewStorageHygieneJs(forceCompactIdb = false), null)

                    // Inyectar enlace de teclado virtual para pantalla de login en Android TV (idempotente)
                    if (isAndroidTV) {
                        injectTvVirtualKeyboardBinding(view)
                    }

                    // Inyectar inicio automático de QR login oficial de Telegram solo si falta el QR y no hay otro en curso
                    view.evaluateJavascript(
                        """
                        (function() {
                            function ensureQr() {
                                var loginView = document.getElementById('view-login');
                                if (!loginView || !loginView.classList.contains('active')) return;
                                var stepPhone = document.getElementById('step-phone');
                                if (stepPhone && !stepPhone.classList.contains('active')) return;
                                var btnPhone = document.getElementById('btn-phone');
                                if (btnPhone && btnPhone.disabled) return;
                                var qrBox = document.getElementById('remote-qr-canvas');
                                if (qrBox && qrBox.querySelector('svg, canvas')) return;
                                if (window.__cfQrInitInFlight) return;
                                var remoteSec = document.getElementById('remote-login-section');
                                if (remoteSec && remoteSec.style.display !== 'none') {
                                    if (typeof window.initTelegramQrLogin === 'function') {
                                        window.initTelegramQrLogin();
                                    }
                                }
                            }
                            setTimeout(ensureQr, 1500);
                        })();
                        """.trimIndent(),
                        null
                    )

                    // Inyectar protección del spinner de carga (con timer bajo demanda — 0% CPU en reposo)
                    // + sincronización nativa de Live TV PiP, El Peliculón y X-Ray + botón de limpieza opcional
                    view.evaluateJavascript(
                        """
                        (function() {
                            if (window.__cfSpinnerGuardBound) return;
                            window.__cfSpinnerGuardBound = true;

                            if (!document.getElementById('card-spinner-injected-style')) {
                                var s = document.createElement('style');
                                s.id = 'card-spinner-injected-style';
                                s.textContent = '.card-loading-overlay { position: absolute !important; inset: 0 !important; background: rgba(0,0,0,0.65) !important; display: flex !important; align-items: center !important; justify-content: center !important; z-index: 9999 !important; border-radius: inherit !important; pointer-events: none !important; opacity: 1 !important; visibility: visible !important; } .card-loading-overlay .spinner { width: 40px !important; height: 40px !important; border: 3.5px solid rgba(255, 255, 255, 0.25) !important; border-top-color: #ffffff !important; border-radius: 50% !important; animation: cardSpinAnim 0.8s linear infinite !important; margin: 0 !important; box-sizing: border-box !important; display: block !important; } @keyframes cardSpinAnim { to { transform: rotate(360deg); } } .row-cards { -webkit-overflow-scrolling: touch !important; }';
                                document.head.appendChild(s);
                            }

                            window.__forceClearCardOverlays = false;
                            window.__activeLoadingPoster = null;
                            window.__activeLoadingCardId = null;
                            var safetyTimer = null;
                            var overlayGuardTimer = null;

                            function stopOverlayGuardTimer() {
                                if (overlayGuardTimer) {
                                    clearInterval(overlayGuardTimer);
                                    overlayGuardTimer = null;
                                }
                            }

                            function startOverlayGuardTimerIfNeeded() {
                                if (overlayGuardTimer) return;
                                overlayGuardTimer = setInterval(function() {
                                    if (window.__forceClearCardOverlays) return;
                                    var target = window.__activeLoadingPoster;
                                    if (!target && window.__activeLoadingCardId) {
                                        var card = document.querySelector('[data-id="' + window.__activeLoadingCardId + '"]');
                                        if (card) {
                                            target = card.querySelector('.series-card-poster') || card;
                                            window.__activeLoadingPoster = target;
                                        }
                                    }
                                    if (!target && !window.__activeLoadingCardId) {
                                        stopOverlayGuardTimer();
                                        return;
                                    }
                                    if (target && document.body.contains(target)) {
                                        if (!target.querySelector('.card-loading-overlay')) {
                                            var ov = document.createElement('div');
                                            ov.className = 'card-loading-overlay';
                                            ov.innerHTML = '<div class="spinner"></div>';
                                            target.appendChild(ov);
                                        }
                                    }
                                }, 80);
                            }

                            window._clearCardLoadingOverlays = function() {
                                window.__forceClearCardOverlays = true;
                                window.__activeLoadingPoster = null;
                                window.__activeLoadingCardId = null;
                                if (safetyTimer) { clearTimeout(safetyTimer); safetyTimer = null; }
                                stopOverlayGuardTimer();
                                document.querySelectorAll('.card-loading-overlay').forEach(function(el) {
                                    if (el.parentNode) el.parentNode.removeChild(el);
                                });
                                window.__forceClearCardOverlays = false;
                            };

                            var origRemove = Element.prototype.remove;
                            Element.prototype.remove = function() {
                                if (this.classList && this.classList.contains('card-loading-overlay')) {
                                    if (!window.__forceClearCardOverlays) {
                                        return;
                                    }
                                }
                                return origRemove.apply(this, arguments);
                            };

                            var origRemoveChild = Node.prototype.removeChild;
                            Node.prototype.removeChild = function(child) {
                                if (child && child.classList && child.classList.contains('card-loading-overlay')) {
                                    if (!window.__forceClearCardOverlays) {
                                        return child;
                                    }
                                }
                                return origRemoveChild.apply(this, arguments);
                            };

                            function onOverlaySeen(overlay) {
                                if (window.__forceClearCardOverlays) return;
                                var poster = overlay.parentElement;
                                if (!poster) return;
                                window.__activeLoadingPoster = poster;
                                var card = poster.closest('.series-card, .movie-card, .content-row .card, .row-cards > div');
                                if (card && card.dataset && card.dataset.id) {
                                    window.__activeLoadingCardId = card.dataset.id;
                                }
                                startOverlayGuardTimerIfNeeded();
                                if (safetyTimer) clearTimeout(safetyTimer);
                                safetyTimer = setTimeout(function() {
                                    window._clearCardLoadingOverlays();
                                }, 45000);
                            }

                            try {
                                var observer = new MutationObserver(function(mutations) {
                                    if (window.__forceClearCardOverlays) return;
                                    for (var i = 0; i < mutations.length; i++) {
                                        var added = mutations[i].addedNodes;
                                        for (var j = 0; j < added.length; j++) {
                                            var node = added[j];
                                            if (node && node.nodeType === 1) {
                                                if (node.classList && node.classList.contains('card-loading-overlay')) {
                                                    onOverlaySeen(node);
                                                } else if (node.querySelector) {
                                                    var found = node.querySelector('.card-loading-overlay');
                                                    if (found) onOverlaySeen(found);
                                                }
                                            }
                                        }
                                    }
                                });
                                observer.observe(document.body || document.documentElement, { childList: true, subtree: true });
                            } catch(e) {}

                            // Proteger la posición de scroll del carrusel Seguir Viendo
                            window.__savedSeriesCarouselScroll = 0;
                            window.__savedMoviesCarouselScroll = 0;

                            document.addEventListener('scroll', function(e) {
                                if (e.target && e.target.classList && e.target.classList.contains('row-cards')) {
                                    var parentSeries = e.target.closest('#continue-watching-series');
                                    if (parentSeries) {
                                        window.__savedSeriesCarouselScroll = e.target.scrollLeft;
                                    }
                                    var parentMovies = e.target.closest('#continue-watching-movies');
                                    if (parentMovies) {
                                        window.__savedMoviesCarouselScroll = e.target.scrollLeft;
                                    }
                                }
                            }, true);

                            function patchContinueWatching() {
                                if (window.renderContinueWatchingRow && !window.__patchedContinueWatchingRow) {
                                    window.__patchedContinueWatchingRow = true;
                                    var origRender = window.renderContinueWatchingRow;
                                    window.renderContinueWatchingRow = function() {
                                        var sCards = document.querySelector('#continue-watching-series .row-cards');
                                        if (sCards && sCards.scrollLeft > 0) window.__savedSeriesCarouselScroll = sCards.scrollLeft;
                                        var mCards = document.querySelector('#continue-watching-movies .row-cards');
                                        if (mCards && mCards.scrollLeft > 0) window.__savedMoviesCarouselScroll = mCards.scrollLeft;

                                        var res = origRender.apply(this, arguments);
                                        var restoreScroll = function() {
                                            if (window.__savedSeriesCarouselScroll > 0) {
                                                var sc = document.querySelector('#continue-watching-series .row-cards');
                                                if (sc && Math.abs(sc.scrollLeft - window.__savedSeriesCarouselScroll) > 5) {
                                                    sc.scrollLeft = window.__savedSeriesCarouselScroll;
                                                }
                                            }
                                            if (window.__savedMoviesCarouselScroll > 0) {
                                                var mc = document.querySelector('#continue-watching-movies .row-cards');
                                                if (mc && Math.abs(mc.scrollLeft - window.__savedMoviesCarouselScroll) > 5) {
                                                    mc.scrollLeft = window.__savedMoviesCarouselScroll;
                                                }
                                            }
                                        };
                                        if (res && typeof res.then === 'function') {
                                            return res.then(function(val) {
                                                restoreScroll();
                                                setTimeout(restoreScroll, 50);
                                                return val;
                                            });
                                        } else {
                                            restoreScroll();
                                            setTimeout(restoreScroll, 50);
                                            return res;
                                        }
                                    };
                                }
                            }
                            patchContinueWatching();
                            var cwPatchTimer = setInterval(function() {
                                patchContinueWatching();
                                if (window.__patchedContinueWatchingRow) clearInterval(cwPatchTimer);
                            }, 500);

                            // ── Native Playback Metadata Bridge (Live TV PiP + El Peliculón + X-Ray) ──
                            function findItemByCid(list, rawNumericId) {
                                if (!Array.isArray(list) || !rawNumericId) return null;
                                for (var i = 0; i < list.length; i++) {
                                    var it = list[i];
                                    if (it && String(it.id || '').replace(/^(mv_|tv_)/, '') === rawNumericId) {
                                        return it;
                                    }
                                }
                                return null;
                            }

                            function snapshotAndPushPlaybackMeta(opts) {
                                if (!window.AndroidBridge || typeof window.AndroidBridge.setNextPlaybackMetadata !== 'function') return;
                                try {
                                    var isLive = !!window.__cfLiveTvActive;
                                    if (isLive && !window._cfHeadlessNativeTune) {
                                        var ltvViewActive = document.getElementById('cf-livetv-view');
                                        var ltvApkBar = document.getElementById('cf-ltv-apk-bar');
                                        var bodyEl = document.body;
                                        var genuinelyLive = (bodyEl && (bodyEl.classList.contains('cf-livetv-tuning') || bodyEl.classList.contains('cf-ltv-minitv-mode'))) ||
                                            (ltvViewActive && ltvViewActive.classList.contains('active')) ||
                                            (ltvApkBar && !ltvApkBar.classList.contains('hidden'));
                                        if (!genuinelyLive) {
                                            isLive = false;
                                            window.__cfLiveTvActive = false;
                                            window.__cfLiveTvMeta = null;
                                        }
                                    }
                                    var ltvMeta = isLive ? (window.__cfLiveTvMeta || null) : null;
                                    var chId = (ltvMeta && ltvMeta.channelId) ? String(ltvMeta.channelId) : '';
                                    var chLabel = (ltvMeta && ltvMeta.channelLabel) ? String(ltvMeta.channelLabel) : '';
                                    var tunedAtMs = (ltvMeta && ltvMeta.tunedAtMs) ? Number(ltvMeta.tunedAtMs) : 0;
                                    var baseOffsetSec = (ltvMeta && ltvMeta.baseOffsetSec) ? Number(ltvMeta.baseOffsetSec) : 0;
                                    var isPrem = !!(ltvMeta && ltvMeta.isPremiereLocked);
                                    var expandPip = false;
                                    if (opts && typeof opts.expandFromPip === 'boolean') {
                                        expandPip = opts.expandFromPip;
                                    } else if (typeof window.__cfNextLiveTuneExpandPip === 'boolean') {
                                        expandPip = window.__cfNextLiveTuneExpandPip;
                                        if (ltvMeta) ltvMeta.expandFromPip = expandPip;
                                    } else if (ltvMeta && typeof ltvMeta.expandFromPip === 'boolean') {
                                        expandPip = ltvMeta.expandFromPip;
                                    }
                                    window.__cfNextLiveTuneExpandPip = null;

                                    if (isLive && !chLabel) {
                                        var apkKick = document.querySelector('#cf-ltv-apk-bar .cf-ltv-apk-kicker');
                                        var tuneOv = document.getElementById('cf-livetv-tuning-overlay');
                                        var heroPill = document.querySelector('#cf-ltv-hero-body .cf-ltv-ch-pill');
                                        var rawTxt = (tuneOv && !tuneOv.classList.contains('hidden') && tuneOv.textContent)
                                            ? tuneOv.textContent
                                            : ((apkKick && apkKick.textContent) ? apkKick.textContent : ((heroPill && heroPill.textContent) ? heroPill.textContent : ''));
                                        var mCh = rawTxt.match(/CANAL\s+\d+\s*[·•-]\s*([^\n·•]+)/i);
                                        if (mCh) {
                                            chLabel = mCh[0].replace(/\s+/g, ' ').trim();
                                        }
                                        if (/CANAL\s+100\b|EL\s+PELICUL[ÓO]N/i.test(rawTxt)) {
                                            chId = 'ch_premiere_sabado';
                                            isPrem = true;
                                        }
                                    }

                                    var appBridge = window.__cineflixAppBridge || null;
                                    var appState = null;
                                    if (appBridge && typeof appBridge.getCurrentState === 'function') {
                                        try { appState = appBridge.getCurrentState(); } catch (_) { appState = null; }
                                    }
                                    var myContentView = document.getElementById('view-my-content');
                                    var isMyContentActive = !!(myContentView && myContentView.classList.contains('active'));
                                    var ctx = isMyContentActive ? null : (window.currentWatchContext || null);
                                    var ctxCid = (ctx && ctx.content_id) ? String(ctx.content_id) : '';
                                    var rawCidNum = ctxCid.replace(/^(mv_|tv_)/, '');
                                    var isTvCtx = ctxCid.indexOf('tv_') === 0 || (ctx && ctx.season != null && ctx.episode != null);
                                    var matchesCid = function(it) {
                                        if (!it) return false;
                                        if (!rawCidNum) return true;
                                        return String(it.id || '').replace(/^(mv_|tv_)/, '') === rawCidNum;
                                    };

                                    var lastModal = window.__cfLastModalItem || window._currentModalItem || null;
                                    var lastModalData = (lastModal && lastModal.data) ? lastModal.data : null;
                                    var lastModalMatches = matchesCid(lastModalData);

                                    var curItem = null;
                                    if (isTvCtx) {
                                        var stSer = (appState && matchesCid(appState.currentSeries)) ? appState.currentSeries : null;
                                        var winSer = matchesCid(window.currentSeries) ? window.currentSeries : null;
                                        curItem = stSer ||
                                            findItemByCid(appState && appState.catalog, rawCidNum) ||
                                            winSer ||
                                            (lastModalMatches && lastModal.type === 'series' ? lastModalData : null) || null;
                                    } else if (ctxCid.indexOf('mv_') === 0) {
                                        var stMov = (appState && matchesCid(appState.currentMovie)) ? appState.currentMovie : null;
                                        var winMov = matchesCid(window.currentMovie) ? window.currentMovie : null;
                                        curItem = stMov ||
                                            findItemByCid(appState && appState.moviesCatalog, rawCidNum) ||
                                            winMov ||
                                            (lastModalMatches && lastModal.type === 'movie' ? lastModalData : null) || null;
                                    } else if (!isMyContentActive && appState) {
                                        curItem = appState.currentMovie || appState.currentSeries ||
                                            (lastModalMatches ? lastModalData : null) || null;
                                    }

                                    var tmdbId = 0;
                                    var yr = '';
                                    var mType = isTvCtx ? 'tv' : (ctxCid.indexOf('mv_') === 0 ? 'movie' : '');
                                    var cTitle = '';
                                    if (curItem) {
                                        tmdbId = Number(curItem.tmdb_id || curItem.tmdbId || 0) || 0;
                                        yr = curItem.year ? String(curItem.year) : '';
                                        cTitle = String(curItem.tmdb_name || curItem.title || '').trim();
                                        if (!mType) {
                                            mType = (curItem.media_type === 'tv' || curItem.payload || curItem.payload_mkv) ? 'tv' : 'movie';
                                        }
                                    } else if (ctxCid.indexOf('mv_') === 0) {
                                        var mModalTitleEl = document.getElementById('modal-movie-title');
                                        var mModalYearEl = document.getElementById('modal-movie-year');
                                        if (mModalTitleEl && mModalTitleEl.textContent) {
                                            cTitle = String(mModalTitleEl.textContent).trim();
                                        }
                                        if (mModalYearEl && mModalYearEl.textContent) {
                                            yr = String(mModalYearEl.textContent).trim();
                                        }
                                    } else if (!isMyContentActive && isTvCtx && window.currentSeriesTitle) {
                                        cTitle = String(window.currentSeriesTitle).replace(/\s*\(\d{4}\)\s*$/, '').trim();
                                    }
                                    if (!tmdbId && !isMyContentActive && isTvCtx && appState && appState.currentTmdb && appState.currentTmdb.id && appState.currentSeries && matchesCid(appState.currentSeries)) {
                                        tmdbId = Number(appState.currentTmdb.id) || 0;
                                    }
                                    var activeProf = (appState && appState.currentProfile) || window.currentProfile || null;
                                    if (!activeProf) {
                                        try {
                                            var savedProfRaw = localStorage.getItem('cineflix_current_profile');
                                            if (savedProfRaw) activeProf = JSON.parse(savedProfRaw);
                                        } catch (_) {}
                                    }
                                    var isKids = !!(activeProf && activeProf.is_kids);

                                    if (isLive && baseOffsetSec <= 0 && ctx && ctx.progress) {
                                        baseOffsetSec = Number(ctx.progress) || 0;
                                    }

                                    var progTitle = '';
                                    var ltvItemId = '';
                                    var ltvPoster = '';
                                    var ltvPayload = '';
                                    var ltvRawJson = '';
                                    var ltvContinuityJson = '';
                                    var ltvUpNextJson = '';
                                    var ltvOtherChannelsJson = '';
                                    if (isLive && ltvMeta) {
                                        if (ltvMeta.programTitle) progTitle = String(ltvMeta.programTitle);
                                        if (ltvMeta.itemId) ltvItemId = String(ltvMeta.itemId);
                                        if (ltvMeta.posterPath) ltvPoster = String(ltvMeta.posterPath);
                                        if (ltvMeta.payload) ltvPayload = String(ltvMeta.payload);
                                        if (ltvMeta.rawItemJson) ltvRawJson = String(ltvMeta.rawItemJson);
                                        if (ltvMeta.continuityJson) ltvContinuityJson = String(ltvMeta.continuityJson);
                                        if (ltvMeta.upNextJson) ltvUpNextJson = String(ltvMeta.upNextJson);
                                        if (ltvMeta.otherChannelsJson) ltvOtherChannelsJson = String(ltvMeta.otherChannelsJson);
                                        if (ltvMeta.tmdbId) tmdbId = Number(ltvMeta.tmdbId) || tmdbId;
                                        if (ltvMeta.year) yr = String(ltvMeta.year);
                                        if (ltvMeta.mediaType) mType = String(ltvMeta.mediaType);
                                        if (ltvMeta.cleanTitle) cTitle = String(ltvMeta.cleanTitle);
                                    } else if (curItem) {
                                        ltvItemId = String(curItem.id || '').replace(/^(mv_|tv_)/, '');
                                        ltvPoster = String(curItem.tmdb_poster || curItem.poster || '');
                                        ltvPayload = String(curItem.payload || curItem.payload_mkv || '');
                                    }

                                    window.AndroidBridge.setNextPlaybackMetadata(JSON.stringify({
                                        isLiveTv: isLive,
                                        channelId: chId,
                                        channelLabel: chLabel,
                                        programTitle: progTitle,
                                        itemId: ltvItemId,
                                        posterPath: ltvPoster,
                                        payload: ltvPayload,
                                        rawItemJson: ltvRawJson,
                                        continuityJson: ltvContinuityJson,
                                        upNextJson: ltvUpNextJson,
                                        otherChannelsJson: ltvOtherChannelsJson,
                                        tunedAtMs: tunedAtMs || (isLive ? Date.now() : 0),
                                        baseOffsetSec: baseOffsetSec,
                                        isPremiereLocked: isPrem,
                                        expandFromPip: expandPip,
                                        tmdbId: tmdbId,
                                        year: yr,
                                        mediaType: mType,
                                        cleanTitle: cTitle,
                                        isKids: isKids
                                    }));
                                } catch (eMeta) {}
                            }
                            window.__pushNativePlaybackMeta = snapshotAndPushPlaybackMeta;

                            // Preserve last opened movie/series detail item across closeSeriesDetail() on master34
                            try {
                                var descModal = Object.getOwnPropertyDescriptor(window, '_currentModalItem');
                                if (!descModal || descModal.configurable) {
                                    var _modalBacking = window._currentModalItem || null;
                                    if (_modalBacking && _modalBacking.data) window.__cfLastModalItem = _modalBacking;
                                    Object.defineProperty(window, '_currentModalItem', {
                                        configurable: true,
                                        enumerable: true,
                                        get: function() { return _modalBacking; },
                                        set: function(v) {
                                            _modalBacking = v;
                                            if (v && v.data) {
                                                window.__cfLastModalItem = v;
                                            }
                                        }
                                    });
                                }
                            } catch (_) {}

                            // Hook window.currentWatchContext assignments so async VOD launches (Continue Watching, Hero, etc.)
                            // always push fresh metadata right before streamVideoNative() invokes AndroidBridge!
                            try {
                                var descCw = Object.getOwnPropertyDescriptor(window, 'currentWatchContext');
                                if (!descCw || descCw.configurable) {
                                    var _cwBacking = window.currentWatchContext || null;
                                    Object.defineProperty(window, 'currentWatchContext', {
                                        configurable: true,
                                        enumerable: true,
                                        get: function() { return _cwBacking; },
                                        set: function(v) {
                                            _cwBacking = v;
                                            if (v || !window.__cfLiveTvActive) {
                                                try { snapshotAndPushPlaybackMeta(); } catch (_) {}
                                                if (v) {
                                                    setTimeout(function() { try { snapshotAndPushPlaybackMeta(); } catch (_) {} }, 0);
                                                }
                                            }
                                        }
                                    });
                                }
                            } catch (_) {}

                            // Capture phase: track intent before target handlers mutate state (e.g. expand PiP vs close PiP)
                            window.addEventListener('click', function(ev) {
                                var tgt = ev.target;
                                if (!tgt || !tgt.closest) return;
                                if (tgt.closest('#btn-ltv-apk-resume, #btn-ltv-hero-watch, .cf-ltv-ch-cell, .cf-ltv-now-card, .cf-ltv-next-card, .cf-ltv-hot-card, .cf-ltv-row, #btn-sat-prem-cta')) {
                                    window.__cfNextLiveTuneExpandPip = true;
                                } else if (tgt.closest('#btn-ltv-apk-prev, #btn-ltv-apk-next')) {
                                    window.__cfNextLiveTuneExpandPip = false;
                                }
                                var notProgrammaticLiveTune = !window.__cfLiveTvProgrammaticLaunch &&
                                    (!document.body || (!document.body.classList.contains('cf-livetv-tuning') && !document.body.classList.contains('cf-livetv-preloading')));
                                var myContentCardTap = notProgrammaticLiveTune && tgt.closest('#mycontent-grid .series-card, #view-my-content .series-card');
                                if (myContentCardTap) {
                                    window.currentWatchContext = null;
                                    window.currentMovie = null;
                                }
                                var stopLtvNav = tgt.closest('#btn-ltv-apk-stop, #nav-movies, #nav-series, #nav-platforms, #nav-favorites, #nav-cine, #nav-mycontent, #app-brand-title, #btn-profile-switch, #btn-logout, #mobile-bottom-nav .mobile-nav-btn:not(#mobile-nav-livetv)');
                                var manualVodTap = notProgrammaticLiveTune &&
                                    (myContentCardTap || tgt.closest('.movie-file-item, .episode-card-h, .episode-card, #movie-detail-play, #series-detail-play, #series-hero-play, #movies-hero-play-btn, #hero-play-btn, .cw-card, [data-cw-id], #continue-watching-series .series-card, #continue-watching-movies .series-card, #continue-grid .series-card, #continue-results .series-card, #series-resume-modal button, #movie-resume-modal button'));
                                if (stopLtvNav) {
                                    if (typeof window.__cfStopLiveTvMode === 'function') {
                                        try { window.__cfStopLiveTvMode(false); } catch (_) {}
                                    } else {
                                        window.__cfLiveTvActive = false;
                                        window.__cfLiveTvMeta = null;
                                    }
                                    if (window.AndroidBridge && typeof window.AndroidBridge.closeLiveTvPip === 'function') {
                                        try { window.AndroidBridge.closeLiveTvPip(); } catch (_) {}
                                    }
                                } else if (manualVodTap) {
                                    // Clear Live TV flags & PiP without invoking closeHiddenDetailModalsQuietly() in capture phase
                                    // so clicking ▶ Reproducir or .movie-file-item inside Ficha modal opens VOD cleanly!
                                    window.__cfLiveTvActive = false;
                                    window.__cfLiveTvMeta = null;
                                    if (window.AndroidBridge && typeof window.AndroidBridge.closeLiveTvPip === 'function') {
                                        try { window.AndroidBridge.closeLiveTvPip(); } catch (_) {}
                                    }
                                }
                            }, true);

                            // Bubble phase: runs synchronously AFTER card/button onclick & oneShotApkPatch have set
                            // window.currentWatchContext, progress=seekVal, and __cfLiveTvMeta, BEFORE async playVideo* fires!
                            window.addEventListener('click', function(ev) {
                                var tgt = ev.target;
                                if (!tgt || !tgt.closest) return;
                                if (tgt.closest('.movie-file-item, .episode-card-h, .episode-card, #movie-detail-play, #series-detail-play, #series-hero-play, #movies-hero-play-btn, #hero-play-btn, #btn-ltv-apk-resume, .cw-card, [data-cw-id], #continue-watching-series .series-card, #continue-watching-movies .series-card, #continue-grid .series-card, #continue-results .series-card, #mycontent-grid .series-card, #view-my-content .series-card, #series-resume-modal button')) {
                                    snapshotAndPushPlaybackMeta();
                                }
                            }, false);

                            function patchPlayNextEpisodeMeta() {
                                if (typeof window.playNextEpisodeFromNative === 'function' && !window.__patchedPlayNextEpMeta) {
                                    window.__patchedPlayNextEpMeta = true;
                                    var origPlayNext = window.playNextEpisodeFromNative;
                                    window.playNextEpisodeFromNative = function() {
                                        var res = origPlayNext.apply(this, arguments);
                                        setTimeout(function() { snapshotAndPushPlaybackMeta(); }, 0);
                                        return res;
                                    };
                                }
                            }
                            patchPlayNextEpisodeMeta();
                            var pneTimer = setInterval(function() {
                                patchPlayNextEpisodeMeta();
                                if (window.__patchedPlayNextEpMeta) clearInterval(pneTimer);
                            }, 800);

                            // Inject discrete "🧹 Liberar caché" shortcut inside #modal-profiles-screen so TV users can verify/clean anytime
                            function injectCleanCacheShortcut() {
                                var profModal = document.getElementById('modal-profiles-screen');
                                if (!profModal || document.getElementById('btn-cf-native-clean-cache')) return;
                                if (!window.AndroidBridge || typeof window.AndroidBridge.performDeepCacheCleanup !== 'function') return;
                                var host = profModal.querySelector('.profiles-actions, .profiles-footer') || profModal.firstElementChild || profModal;
                                var btn = document.createElement('button');
                                btn.id = 'btn-cf-native-clean-cache';
                                btn.type = 'button';
                                btn.className = 'focusable';
                                btn.tabIndex = 0;
                                btn.textContent = '🧹 Optimizar espacio (sin cerrar sesión)';
                                btn.style.cssText = 'margin:14px auto 4px;display:inline-flex;align-items:center;gap:6px;padding:8px 16px;border-radius:999px;border:1px solid rgba(255,255,255,0.22);background:rgba(255,255,255,0.08);color:#e2e8f0;font-size:0.8rem;font-weight:700;cursor:pointer;';
                                btn.onclick = function(ev) {
                                    ev.preventDefault();
                                    ev.stopPropagation();
                                    try { window.AndroidBridge.performDeepCacheCleanup(); } catch (_) {}
                                };
                                host.appendChild(btn);
                            }
                            setTimeout(injectCleanCacheShortcut, 1800);
                        })();
                        """.trimIndent(),
                        null
                    )
                }
            }

            // Utilizado para logs de console.log() de JS en el logcat de Android
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                    return super.onConsoleMessage(consoleMessage)
                }
            }

            val cacheBuster = System.currentTimeMillis()
            loadUrl("https://cineflixapp.duckdns.org/?v=$cacheBuster")
            android.util.Log.d("CineflixMain", "WebView loading remote catalog URL with cache-buster")
        }

        // Fix white flash on startup
        webView.setBackgroundColor(Color.BLACK)

        val rootContainer = FrameLayout(this).apply {
            setBackgroundColor(Color.BLACK)
        }
        rootContainer.addView(
            webView,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )
        castMiniBar = createCastMiniBarView()
        val miniBarLp = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            leftMargin = dpToPx(12)
            rightMargin = dpToPx(12)
            bottomMargin = dpToPx(14)
        }
        rootContainer.addView(castMiniBar, miniBarLp)

        setContentView(rootContainer)

        // OTA: comprobar actualizaciones al abrir la app
        OtaUpdateManager(this).checkForUpdate()

        // Manejar el botón de atrás del sistema
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            private var lastBackPressTime = 0L
            private var jsBackInFlight = false

            override fun handleOnBackPressed() {
                val now = System.currentTimeMillis()
                // Salida de emergencia nativa: si JS está colgado sin responder a la pulsación anterior
                // y el usuario pulsa Atrás de nuevo en menos de 1.5s, cerrar SIEMPRE la app.
                if (jsBackInFlight && now - lastBackPressTime < 1500) {
                    finish()
                    return
                }
                lastBackPressTime = now
                jsBackInFlight = true

                // Let JS handle back navigation first (VK → OTP/2FA → modal → view transitions)
                val jsHandled = runCatching {
                    webView.evaluateJavascript("window.__cineflixBack ? window.__cineflixBack() : false") { result ->
                        jsBackInFlight = false
                        if (result != "true") {
                            // JS didn't handle it — fall back to WebView history or finish
                            if (webView.canGoBack()) {
                                webView.goBack()
                            } else {
                                finish()
                            }
                        }
                    }
                }.isSuccess

                if (!jsHandled) {
                    jsBackInFlight = false
                    if (webView.canGoBack()) webView.goBack() else finish()
                }
            }
        })
    }

    /** Do NOT save frozen WebView state — ensure fresh clean boot on process recreation */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    /**
     * Intercept D-pad keys BEFORE the WebView's native focus engine processes them.
     * The WebView has its own D-pad navigation that moves focus between tabindex elements,
     * which fights with tv-nav.js's spatial navigation. By consuming D-pad events here
     * and injecting them as JavaScript KeyboardEvents, tv-nav.js becomes the sole owner
     * of D-pad navigation.
     */
    private fun injectTvVirtualKeyboardBinding(targetWebView: WebView = webView) {
        targetWebView.evaluateJavascript(
            """
            (function() {
                function bindVK() {
                    ['search-input', 'input-phone', 'input-otp', 'input-2fa'].forEach(function(id) {
                        var el = document.getElementById(id);
                        if (el && !el._vkAttached) {
                            el._vkAttached = true;
                            el.addEventListener('click', function(e) {
                                if (typeof window.openVirtualKeyboard === 'function') {
                                    e.preventDefault();
                                    el.blur();
                                    window.openVirtualKeyboard(el);
                                }
                            });
                        }
                    });
                    if (window.cineflixTvNav && !window.cineflixTvNav._vkConfirmPatched) {
                        window.cineflixTvNav._vkConfirmPatched = true;
                        var orig = window.cineflixTvNav.confirm;
                        window.cineflixTvNav.confirm = function() {
                            var f = this.focused;
                            if (f && (f.id === 'input-phone' || f.id === 'input-otp' || f.id === 'input-2fa' || f.id === 'search-input')) {
                                if (typeof window.openVirtualKeyboard === 'function') {
                                    window.openVirtualKeyboard(f);
                                    return;
                                }
                            }
                            return orig.apply(this, arguments);
                        };
                    }
                }
                bindVK();
                if (!window.__cfVkBound) {
                    window.__cfVkBound = true;
                    setInterval(bindVK, 1500);
                }
            })();
            """.trimIndent(),
            null
        )
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (!isAndroidTV && event.action == KeyEvent.ACTION_DOWN) {
            val isRemoteDpad = when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_UP,
                KeyEvent.KEYCODE_DPAD_DOWN,
                KeyEvent.KEYCODE_DPAD_LEFT,
                KeyEvent.KEYCODE_DPAD_RIGHT,
                KeyEvent.KEYCODE_DPAD_CENTER -> true
                else -> false
            }
            if (isRemoteDpad) {
                val dev = runCatching { event.device }.getOrNull()
                val isAlphaKeyboard = dev?.keyboardType == android.view.InputDevice.KEYBOARD_TYPE_ALPHABETIC
                val devNameLower = dev?.name?.lowercase(java.util.Locale.ROOT).orEmpty()
                val isDedicatedRemoteName = devNameLower.isNotEmpty() &&
                    Regex("(?:\\bir\\b|sunxi-ir|meson-ir|aml_keypad|cec|hdmi|remote|tv_?remote|rc[-_ ]?core|gpio[-_ ]?keys)").containsMatchIn(devNameLower)
                val hasTelephony = runCatching {
                    packageManager.hasSystemFeature(android.content.pm.PackageManager.FEATURE_TELEPHONY)
                }.getOrDefault(true)
                if (StorageAndRamHygiene.shouldUpgradeToTvModeOnDpad(
                        isRemoteDpadKey = true,
                        isAlphabeticKeyboard = isAlphaKeyboard,
                        hasTelephony = hasTelephony,
                        isDedicatedRemoteDeviceName = isDedicatedRemoteName
                    )
                ) {
                    isAndroidTV = true
                    StorageAndRamHygiene.markTelevisionDetectedAtRuntime()
                    android.util.Log.i("CineflixMain", "Remote D-pad detected (dev='${dev?.name}') -> upgrading to Android TV mode")
                    webView.evaluateJavascript(
                        "(function(){ window._cineflixIsTV = true; window.__appPlatform = 'android_tv'; document.documentElement.classList.add('android-tv', 'is-tv'); if (document.body) document.body.classList.add('android-tv', 'is-tv'); })();",
                        null
                    )
                    injectTvVirtualKeyboardBinding(webView)
                }
            }
        }
        if (isAndroidTV && (event.action == KeyEvent.ACTION_DOWN || event.action == KeyEvent.ACTION_UP)) {
            val mapped = mapAndroidTvRemoteKey(event.keyCode)
            if (mapped != null) {
                val (jsKeyCode, jsKey) = mapped
                val eventType = if (event.action == KeyEvent.ACTION_DOWN) "keydown" else "keyup"
                val repeat = if (event.action == KeyEvent.ACTION_DOWN && event.repeatCount > 0) "true" else "false"
                webView.evaluateJavascript(
                    "document.dispatchEvent(new KeyboardEvent('$eventType', " +
                    "{key:'$jsKey', keyCode:$jsKeyCode, code:'$jsKey', repeat:$repeat, bubbles:true, cancelable:true}))",
                    null
                )
                return true // Consume the event — WebView never sees it
            }
        }
        return super.dispatchKeyEvent(event)
    }

    /** Do NOT pause WebView timers in onPause because PlayerActivity is translucent and runs on top */
    override fun onPause() {
        super.onPause()
    }

    /** Only pause WebView rendering when activity is fully stopped (backgrounded) */
    override fun onStop() {
        CastSessionCoordinator.removeStateObserver(castStateObserver)
        super.onStop()
        mainIdleHandler.removeCallbacks(headlessTuneRePauseRunnable)
        // NEVER call webView.pauseTimers() — it pauses the V8/Chromium timer loop process-wide,
        // which permanently freezes timers, WebSockets, and animations on Android TV when resumed.
        if (android.os.SystemClock.elapsedRealtime() >= headlessLiveTvPumpDeadlineElapsedMs) {
            webView.onPause()
        }

        val cineActive = ::bridge.isInitialized && bridge.isCineScreenActive()
        if (::webView.isInitialized && !cineActive) {
            // Reclaim Chromium decoded-bitmap & HTTP RAM cache immediately when leaving MainActivity
            runCatching { webView.clearCache(false) }
        }

        mainIdleHandler.removeCallbacks(cineScreenBackgroundReleaseRunnable)
        if (cineActive) {
            if (!PlayerActivity.isPlaybackOrLaunchActive() && !CastSessionCoordinator.isCastingActive) {
                mainIdleHandler.postDelayed(cineScreenBackgroundReleaseRunnable, CINESCREEN_BACKGROUND_IDLE_MS)
            }
        } else if (!PlayerActivity.isPlaybackOrLaunchActive() && !CastSessionCoordinator.isCastingActive) {
            // Android TV Home button / app backgrounded with no active video: empty streaming & ephemeral caches
            performIdleBackgroundHygiene()
        }
    }

    /** Resume WebView rendering and ensure focus and TV navigation flags are restored */
    override fun onResume() {
        super.onResume()
        mainActivityRef = java.lang.ref.WeakReference(this)
        mainIdleHandler.removeCallbacks(headlessTuneRePauseRunnable)
        mainIdleHandler.removeCallbacks(cineScreenBackgroundReleaseRunnable)
        webView.onResume()
        CastSessionCoordinator.addStateObserver(castStateObserver)

        if (isAndroidTV) {
            webView.isFocusable = true
            webView.isFocusableInTouchMode = true
            webView.requestFocus()

            // Ensure TV flags and spatial focus are restored on resume
            webView.evaluateJavascript(
                """
                (function() {
                    window._cineflixIsTV = true;
                    window.__appPlatform = 'android_tv';
                    document.documentElement.classList.add('android-tv');
                    document.body.classList.add('is-tv');
                    if (window.cineflixTvNav) {
                        setTimeout(function() {
                            window.cineflixTvNav.restoreFocus();
                        }, 100);
                    }
                })();
                """.trimIndent(),
                null
            )
        }

        webView.evaluateJavascript("if (typeof window._clearCardLoadingOverlays === 'function') window._clearCardLoadingOverlays();", null)
        webView.evaluateJavascript("if (typeof window.fetchWatchProgress === 'function') window.fetchWatchProgress();", null)
        if (pendingWatchlistRefreshFromPlayer) {
            pendingWatchlistRefreshFromPlayer = false
            webView.evaluateJavascript(
                "if (window.cineflixEnhancements && typeof window.cineflixEnhancements.refreshWatchlist === 'function') window.cineflixEnhancements.refreshWatchlist();",
                null
            )
        }
        
        val nextEpReq = pendingInProcessNextEpisode ?: pendingNextEpisodeArgs
        pendingInProcessNextEpisode = null
        pendingNextEpisodeArgs = null
        nextEpReq?.let { args ->
            val contentId = args.first
            val season = args.second
            val episode = args.third
            android.util.Log.i("CineflixMain", "Setting up JS polling for next episode: S${season}E${episode}")
            
            // Robust execution: JS polling ensures execution only when JS is awake.
            // Automatically clicks the UI card for the next episode, avoiding cached state bugs.
            val script = """
                (function() {
                    var attempts = 0;
                    var interval = setInterval(function() {
                        attempts++;
                        
                        var nextE = $episode + 1;
                        var expectedStr = $season + 'x' + (nextE < 10 ? '0' + nextE : nextE);
                        
                        var directEpCard = document.querySelector('.episode-card-h[data-id="ep_' + $season + '_' + nextE + '"]');
                        if (directEpCard) {
                            console.log('[NativeBridge] Clicking next .episode-card-h:', expectedStr);
                            directEpCard.click();
                            clearInterval(interval);
                            return;
                        }

                        var cards = document.querySelectorAll('.episode-card-h, .episode-card');
                        if (cards.length > 0) {
                            var clicked = false;
                            for (var i = 0; i < cards.length; i++) {
                                var numDiv = cards[i].querySelector('.episode-number, .ep-number, .ep-title');
                                if (numDiv) {
                                    var numText = numDiv.textContent.trim().replace('×', 'x').replace('-', 'x').toLowerCase();
                                    if (numText === expectedStr || numText.indexOf(expectedStr + ' ') === 0) {
                                        console.log('[NativeBridge] Clicking next episode card:', expectedStr);
                                        cards[i].click();
                                        clicked = true;
                                        break;
                                    }
                                }
                            }
                            
                            if (clicked) {
                                clearInterval(interval);
                                return;
                            }
                        }
                        
                        // Fallback
                        if (typeof window.playNextEpisodeFromNative === 'function') {
                            var arr = window.currentPlaylistArray;
                            if ((arr && arr.length > 0) || attempts > 15) {
                                clearInterval(interval);
                                try {
                                    if (arr) {
                                        var found = false;
                                        if (window.currentPlayingVideoMsgId) {
                                            found = arr.some(function(v) { return v.msgId === window.currentPlayingVideoMsgId; });
                                        }
                                        if (!found) {
                                            for (var i = 0; i < arr.length; i++) {
                                                var title = arr[i].displayTitle || arr[i].caption || arr[i].fileName || "";
                                                var match = title.match(/(\d+)[x\-×X](\d+)/);
                                                if (match && parseInt(match[1]) === $season && parseInt(match[2]) === $episode) {
                                                    window.currentPlayingVideoMsgId = arr[i].msgId;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    
                                    window.currentWatchContext = {
                                        content_id: '$contentId',
                                        season: $season,
                                        episode: nextE
                                    };
                                    
                                    console.log('[NativeBridge] Fallback Executing pending next episode from Android S$season E' + nextE);
                                    window.playNextEpisodeFromNative('$contentId', $season, $episode);
                                } catch (e) {
                                    console.error('[NativeBridge] JS Crash:', e.message);
                                }
                                return;
                            }
                        } else if (attempts > 50) {
                            clearInterval(interval);
                            console.warn('[NativeBridge] Failed to find playNextEpisodeFromNative');
                        }
                    }, 100);
                })();
            """.trimIndent()

            webView.postDelayed({
                webView.evaluateJavascript(script, null)
            }, 300)
        }

        val openCatalogReq = pendingInProcessOpenCatalogItem ?: pendingOpenCatalogItem
        pendingInProcessOpenCatalogItem = null
        pendingOpenCatalogItem = null
        openCatalogReq?.let { req ->
            val mediaTypeJs = org.json.JSONObject.quote(req.mediaType)
            val itemIdJs = org.json.JSONObject.quote(req.itemId)
            val titleJs = org.json.JSONObject.quote(req.title)
            val yearJs = org.json.JSONObject.quote(req.year)
            val posterJs = org.json.JSONObject.quote(req.posterPath)
            val payloadJs = org.json.JSONObject.quote(req.payload)
            val rawJsonJs = org.json.JSONObject.quote(req.rawItemJson)
            val tmdbId = req.tmdbId
            val openScript = """
                (function() {
                    try {
                        if (window.__cfLiveTvActive) {
                            if (typeof window.__cfStopLiveTvMode === 'function') {
                                window.__cfStopLiveTvMode(false);
                            } else {
                                var stopBtn = document.getElementById('btn-ltv-apk-stop');
                                if (stopBtn) stopBtn.click();
                            }
                        }
                        var mType = $mediaTypeJs;
                        var rawId = String($itemIdJs || '').replace(/^(mv_|tv_)/, '');
                        var tId = $tmdbId;
                        var ttl = $titleJs;
                        var yr = $yearJs;
                        var pst = $posterJs;
                        var pld = $payloadJs;
                        var rawItemStr = $rawJsonJs;
                        var parsedRaw = null;
                        if (rawItemStr) {
                            try { parsedRaw = JSON.parse(rawItemStr); } catch (_) {}
                        }
                        var b = window.__cineflixAppBridge || window;
                        var st = {};
                        if (b && typeof b.getCurrentState === 'function') {
                            try { st = b.getCurrentState() || {}; } catch (_) { st = {}; }
                        }
                        var list = (mType === 'tv') ? (st.catalog || window.allSeries || []) : (st.moviesCatalog || window.allMovies || []);
                        var found = null;
                        var normLookupTitle = String(ttl || '').toLowerCase().replace(/\s*\(\d{4}\)\s*$/, '').trim();
                        for (var i = 0; i < list.length; i++) {
                            var it = list[i];
                            if (!it) continue;
                            var cid = String(it.id || '').replace(/^(mv_|tv_)/, '');
                            if ((rawId && cid === rawId) || (tId > 0 && Number(it.tmdb_id || it.tmdbId) === tId)) {
                                found = it;
                                break;
                            }
                            if (!found && !rawId && !tId && normLookupTitle) {
                                var candName = String(it.tmdb_name || it.title || '').toLowerCase().replace(/\s*\(\d{4}\)\s*$/, '').trim();
                                if (candName && candName === normLookupTitle) {
                                    found = it;
                                }
                            }
                        }
                        var targetObj = found || parsedRaw || {
                            id: rawId,
                            tmdb_id: tId,
                            title: ttl,
                            tmdb_name: ttl,
                            year: yr || null,
                            poster: pst || null,
                            tmdb_poster: pst || null,
                            payload: pld || null,
                            media_type: mType
                        };
                        if (window.cineflixEnhancements && typeof window.cineflixEnhancements.openLiveTvItemFicha === 'function') {
                            window.cineflixEnhancements.openLiveTvItemFicha(targetObj);
                        } else if (mType === 'tv' && typeof b.openSeriesDetail === 'function') {
                            b.openSeriesDetail(targetObj);
                        } else if (typeof b.openMovieDetail === 'function') {
                            b.openMovieDetail(targetObj);
                        }
                    } catch (e) {
                        console.warn('[NativeBridge] X-Ray open catalog item failed:', e);
                    }
                })();
            """.trimIndent()
            webView.postDelayed({
                webView.evaluateJavascript(openScript, null)
            }, 250)
        }
    }

    private fun performIdleBackgroundHygiene() {
        val appCtx = applicationContext
        val appCacheDir = appCtx.cacheDir
        val dataDir = appCtx.dataDir ?: appCtx.filesDir.parentFile ?: appCtx.filesDir
        val tvMode = isAndroidTV
        val eng = if (::engine.isInitialized) engine else null

        StorageAndRamHygiene.launchBackgroundHygiene {
            try {
                if (!PlayerActivity.isPlaybackOrLaunchActive() &&
                    !CastSessionCoordinator.isCastingActive &&
                    (!::bridge.isInitialized || !bridge.isCineScreenActive())
                ) {
                    eng?.purgeAllStreamingCaches()
                }
                StorageAndRamHygiene.cleanEphemeralCacheArtifacts(appCacheDir)
                val webViewQuota = if (tvMode) {
                    StorageAndRamHygiene.DEFAULT_TV_WEBVIEW_CACHE_CAP_BYTES
                } else {
                    StorageAndRamHygiene.DEFAULT_MOBILE_WEBVIEW_CACHE_CAP_BYTES
                }
                val (overQuota, _) = StorageAndRamHygiene.enforceWebViewCacheQuota(
                    dataDir = dataDir,
                    cacheDir = appCacheDir,
                    maxCacheBytes = webViewQuota,
                    isWebViewActive = true
                )
                if (overQuota) {
                    withContext(Dispatchers.Main) {
                        if (::webView.isInitialized) {
                            runCatching { webView.clearCache(true) }
                        }
                    }
                    delay(1500L)
                    if (StorageAndRamHygiene.measureWebViewDisposableCacheBytes(dataDir, appCacheDir) > webViewQuota) {
                        appCtx.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                            .edit()
                            .putBoolean(StorageAndRamHygiene.PREF_PENDING_PRE_WEBVIEW_PURGE, true)
                            .apply()
                    }
                }
            } catch (e: Throwable) {
                android.util.Log.w("CineflixMain", "Background hygiene warning: ${e.message}")
            }
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN ||
            level >= android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW
        ) {
            if (::webView.isInitialized && (!::bridge.isInitialized || !bridge.isCineScreenActive())) {
                runCatching { webView.clearCache(false) }
            }
            performIdleBackgroundHygiene()
        }
    }

    override fun onDestroy() {
        mainIdleHandler.removeCallbacksAndMessages(null)
        CastSessionCoordinator.removeStateObserver(castStateObserver)
        if (mainActivityRef?.get() === this) {
            mainActivityRef = null
        }
        if (webViewInstance === webView) {
            webViewInstance = null
        }
        if (::bridge.isInitialized) {
            bridge.cleanup()
        }
        if (::webView.isInitialized) {
            try {
                webView.stopLoading()
                webView.removeJavascriptInterface("AndroidBridge")
                webView.webChromeClient = null
                (webView.parent as? android.view.ViewGroup)?.removeView(webView)
                webView.destroy()
            } catch (_: Throwable) {}
        }
        super.onDestroy()
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

    private fun openActiveCastRemotePlayer() {
        if (!CastSessionCoordinator.isCastingActive) return
        val intent = CastSessionCoordinator.buildReopenPlayerIntent(this)
        playerLauncher.launch(intent)
    }

    private fun createCastMiniBarView(): LinearLayout {
        val cardBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dpToPx(16).toFloat()
            setColor(Color.parseColor("#F2131022"))
            setStroke(dpToPx(1), Color.parseColor("#7C3AED"))
        }

        val bar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            background = cardBg
            elevation = dpToPx(12).toFloat()
            setPadding(dpToPx(14), dpToPx(10), dpToPx(10), dpToPx(10))
            visibility = View.GONE
            isClickable = true
            isFocusable = true
            setOnClickListener { openActiveCastRemotePlayer() }
        }

        val badgeTv = TextView(this).apply {
            text = "📺"
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            setPadding(0, 0, dpToPx(10), 0)
        }
        bar.addView(badgeTv)

        val textCol = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            setOnClickListener { openActiveCastRemotePlayer() }
        }

        tvMiniCastTitle = TextView(this).apply {
            text = "Cineflix"
            setTextColor(Color.WHITE)
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 13.5f)
            setTypeface(typeface, Typeface.BOLD)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        tvMiniCastSubtitle = TextView(this).apply {
            text = "Emitiendo en Smart TV"
            setTextColor(Color.parseColor("#34D399"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
        }
        textCol.addView(tvMiniCastTitle)
        textCol.addView(tvMiniCastSubtitle)
        bar.addView(textCol)

        val mandoBg = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dpToPx(10).toFloat()
            setColor(Color.parseColor("#3B1D7A"))
        }
        val btnOpenRemote = TextView(this).apply {
            text = "Mando"
            setTextColor(Color.parseColor("#EDE9FE"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11.5f)
            setTypeface(typeface, Typeface.BOLD)
            background = mandoBg
            setPadding(dpToPx(10), dpToPx(6), dpToPx(10), dpToPx(6))
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                leftMargin = dpToPx(8)
                rightMargin = dpToPx(4)
            }
            setOnClickListener { openActiveCastRemotePlayer() }
        }
        bar.addView(btnOpenRemote)

        btnMiniCastPlayPause = ImageButton(this).apply {
            setImageResource(android.R.drawable.ic_media_pause)
            setBackgroundColor(Color.TRANSPARENT)
            setColorFilter(Color.WHITE)
            contentDescription = "Pausar o reanudar TV"
            val size = dpToPx(38)
            layoutParams = LinearLayout.LayoutParams(size, size)
            setPadding(dpToPx(7), dpToPx(7), dpToPx(7), dpToPx(7))
            setOnClickListener {
                CastSessionCoordinator.togglePlayPause(this@MainActivity)
            }
        }
        bar.addView(btnMiniCastPlayPause)

        val btnMiniStop = TextView(this).apply {
            text = "✕"
            gravity = Gravity.CENTER
            setTextColor(Color.parseColor("#FCA5A5"))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 15f)
            setTypeface(typeface, Typeface.BOLD)
            val size = dpToPx(36)
            layoutParams = LinearLayout.LayoutParams(size, size)
            setOnClickListener {
                CastSessionCoordinator.stopCastingCompletely(this@MainActivity)
                webView.postDelayed({
                    webView.evaluateJavascript(
                        "if (typeof window.fetchWatchProgress === 'function') window.fetchWatchProgress();",
                        null
                    )
                }, 700L)
            }
        }
        bar.addView(btnMiniStop)

        return bar
    }

    private fun updateCastMiniBar(snapshot: CastSessionCoordinator.CastUiSnapshot) {
        if (!::castMiniBar.isInitialized) return
        if (!snapshot.isActive) {
            castMiniBar.visibility = View.GONE
            if (wasMiniBarVisible) {
                wasMiniBarVisible = false
                webView.evaluateJavascript(
                    "(function(){ if (document && document.body) document.body.style.paddingBottom = ''; })();",
                    null
                )
            }
            return
        }

        castMiniBar.visibility = View.VISIBLE
        if (!wasMiniBarVisible) {
            wasMiniBarVisible = true
            webView.evaluateJavascript(
                "(function(){ if (document && document.body) document.body.style.paddingBottom = '88px'; })();",
                null
            )
        }

        tvMiniCastTitle.text = snapshot.movieTitle
        val tvLabel = snapshot.tvName.ifBlank { "Smart TV" }
        val posClock = CastSessionCoordinator.formatDurationClock(snapshot.positionMs)
        val timePart = if (snapshot.durationMs > 0L) {
            "$posClock / ${CastSessionCoordinator.formatDurationClock(snapshot.durationMs)}"
        } else {
            posClock
        }
        tvMiniCastSubtitle.text = when {
            snapshot.isConnecting -> "Conectando con $tvLabel..."
            snapshot.isLiveTv -> "🔴 En directo • $tvLabel"
            snapshot.isPlaying -> "$tvLabel • $timePart"
            else -> "En pausa • $tvLabel • $timePart"
        }
        if (snapshot.isLiveTv) {
            btnMiniCastPlayPause.visibility = View.GONE
        } else {
            btnMiniCastPlayPause.visibility = View.VISIBLE
            btnMiniCastPlayPause.setImageResource(
                if (snapshot.isPlaying) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play
            )
        }
    }
}

