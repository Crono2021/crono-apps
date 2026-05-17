package com.cineflix.android

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.app.UiModeManager
import android.content.Context
import android.os.Bundle
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

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var bridge: AndroidBridge
    private lateinit var engine: TelegramEngine
    private var isAndroidTV = false

    companion object {
        @SuppressLint("StaticFieldLeak")
        var webViewInstance: WebView? = null
    }

    private var pendingNextEpisodeArgs: Triple<String, Int, Int>? = null

    /** Receives result from PlayerActivity when an episode finishes playing */
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
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Detect if running on Android TV
        val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        isAndroidTV = uiModeManager.currentModeType == Configuration.UI_MODE_TYPE_TELEVISION
        android.util.Log.i("CineflixMain", "Android TV mode: $isAndroidTV")

        engine = TelegramEngine.getInstance(this)

        webView = WebView(this)
        webViewInstance = webView

        webView.apply {
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

            // Mapeamos AndroidBridge.kt a window.AndroidBridge en Javascript
            bridge = AndroidBridge(this@MainActivity, this, engine)
            // Connect the bridge to the ActivityResultLauncher for auto-play next episode
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
                    return assetLoader.shouldInterceptRequest(request.url)
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    val isAmazon = android.os.Build.MANUFACTURER.equals("Amazon", ignoreCase = true)
                    val tvFlag = if (isAndroidTV) "true" else "false"
                    @Suppress("DEPRECATION")
                    val vCode = try { packageManager.getPackageInfo(packageName, 0).versionCode.toLong() } catch (e: Throwable) { 2L }
                    view.evaluateJavascript(
                        "window._cineflixIsTV = $tvFlag; " +
                        "window.__appPlatform = 'android_tv'; " +
                        "window.__appVersion = $vCode; " +
                        "document.documentElement.classList.toggle('android-tv', $tvFlag); " +
                        "if ($tvFlag && !$isAmazon) { " +
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
                    android.util.Log.d("CineflixMain", "Injected OTA vars and JS fixes, TV=$tvFlag, Amazon=$isAmazon")
                }
            }

            // Utilizado para logs de console.log() de JS en el logcat de Android
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                    android.util.Log.d("CineflixWebView", "${consoleMessage.message()} -- From line "
                            + "${consoleMessage.lineNumber()} of ${consoleMessage.sourceId()}")
                    return super.onConsoleMessage(consoleMessage)
                }
            }

            // KEY FIX: Only load fresh URL if there is no saved state.
            // If savedInstanceState exists, restoreState() below will bring back the exact
            // page the user was on (catalog, episodes view, etc.) without re-running init().
            if (savedInstanceState != null) {
                restoreState(savedInstanceState)
                android.util.Log.d("CineflixMain", "WebView state restored from savedInstanceState")
            } else {
                val cacheBuster = System.currentTimeMillis()
                loadUrl("https://cineflix-production-19e3.up.railway.app/?v=$cacheBuster")
                android.util.Log.d("CineflixMain", "WebView loading remote catalog URL with cache-buster")
            }
        }

        setContentView(webView)

        // Manejar el botón de atrás del sistema
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Let JS handle back navigation first (modal → view transitions)
                val jsHandled = runCatching {
                    webView.evaluateJavascript("window.__cineflixBack ? window.__cineflixBack() : false") { result ->
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
                    if (webView.canGoBack()) webView.goBack() else finish()
                }
            }
        })
    }

    /** Save WebView navigation state so it survives background/recreation */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    /** Pause WebView timers + rendering when app goes to background */
    override fun onPause() {
        super.onPause()
        webView.onPause()
        webView.pauseTimers()
    }

    /** Resume WebView timers + rendering when app comes back to foreground */
    override fun onResume() {
        super.onResume()
        webView.resumeTimers()
        webView.onResume()
        
        pendingNextEpisodeArgs?.let { args ->
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
                        
                        var cards = document.querySelectorAll('.episode-card');
                        if (cards.length > 0) {
                            var clicked = false;
                            for (var i = 0; i < cards.length; i++) {
                                var numDiv = cards[i].querySelector('.episode-number');
                                if (numDiv) {
                                    var numText = numDiv.textContent.trim().replace('×', 'x').replace('-', 'x').toLowerCase();
                                    if (numText === expectedStr) {
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
                            clearInterval(interval);
                            try {
                                var arr = window.currentPlaylistArray;
                                if (arr && !window.currentPlayingVideoMsgId) {
                                    for (var i = 0; i < arr.length; i++) {
                                        var title = arr[i].displayTitle || arr[i].caption || arr[i].fileName || "";
                                        var match = title.match(/(\d+)[x\-×X](\d+)/);
                                        if (match && parseInt(match[1]) === $season && parseInt(match[2]) === $episode) {
                                            window.currentPlayingVideoMsgId = arr[i].msgId;
                                            break;
                                        }
                                    }
                                }
                                
                                // FORCE update the watch context to the next episode to fix ancient WebApp caches
                                // that failed to update this variable, causing Native Android to loop the same episode.
                                window.currentWatchContext = {
                                    content_id: '$contentId',
                                    season: $season,
                                    episode: nextE
                                };
                                
                                console.log('[NativeBridge] Fallback Executing pending next episode from Android');
                                window.playNextEpisodeFromNative('$contentId', $season, $episode);
                            } catch (e) {
                                console.error('[NativeBridge] JS Crash:', e.message);
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
            
            pendingNextEpisodeArgs = null
        }
    }

    override fun onDestroy() {
        webViewInstance = null
        bridge.cleanup()
        super.onDestroy()
    }
}

