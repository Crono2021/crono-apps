package com.cineflix.android

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.app.UiModeManager
import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
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
        init {
            try {
                System.loadLibrary("c++_shared")
            } catch (e: Throwable) {
                android.util.Log.e("Cineflix", "Failed to load native libraries", e)
            }
        }
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
        
        bridge = AndroidBridge(this, webView, engine)


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

                    // Inyectar protección indestructible del spinner de carga en fichas
                    view.evaluateJavascript(
                        """
                        (function() {
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

                            window._clearCardLoadingOverlays = function() {
                                window.__forceClearCardOverlays = true;
                                window.__activeLoadingPoster = null;
                                window.__activeLoadingCardId = null;
                                if (safetyTimer) { clearTimeout(safetyTimer); safetyTimer = null; }
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

                            setInterval(function() {
                                if (window.__forceClearCardOverlays) return;
                                var target = window.__activeLoadingPoster;
                                if (!target && window.__activeLoadingCardId) {
                                    var card = document.querySelector('[data-id="' + window.__activeLoadingCardId + '"]');
                                    if (card) {
                                        target = card.querySelector('.series-card-poster') || card;
                                        window.__activeLoadingPoster = target;
                                    }
                                }
                                if (target && document.body.contains(target)) {
                                    if (!target.querySelector('.card-loading-overlay')) {
                                        var ov = document.createElement('div');
                                        ov.className = 'card-loading-overlay';
                                        ov.innerHTML = '<div class="spinner"></div>';
                                        target.appendChild(ov);
                                    }
                                }
                            }, 40);

                            // Proteger la posición de scroll del carrusel Seguir Viendo para que no salte al inicio en sincronizaciones
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
                            setInterval(patchContinueWatching, 500);
                        })();
                        """.trimIndent(),
                        null
                    )
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
                loadUrl("https://cineflixapp.duckdns.org/?v=$cacheBuster")
                android.util.Log.d("CineflixMain", "WebView loading remote catalog URL with cache-buster")
            }
        }
        
        // Fix white flash on startup
        webView.setBackgroundColor(android.graphics.Color.BLACK)

        setContentView(webView)

        // OTA: comprobar actualizaciones al abrir la app
        OtaUpdateManager(this).checkForUpdate()

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

    /**
     * Intercept D-pad keys BEFORE the WebView's native focus engine processes them.
     * The WebView has its own D-pad navigation that moves focus between tabindex elements,
     * which fights with tv-nav.js's spatial navigation. By consuming D-pad events here
     * and injecting them as JavaScript KeyboardEvents, tv-nav.js becomes the sole owner
     * of D-pad navigation.
     */
    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (isAndroidTV && (event.action == KeyEvent.ACTION_DOWN || event.action == KeyEvent.ACTION_UP)) {
            val jsKeyCode = when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_UP -> 38
                KeyEvent.KEYCODE_DPAD_DOWN -> 40
                KeyEvent.KEYCODE_DPAD_LEFT -> 37
                KeyEvent.KEYCODE_DPAD_RIGHT -> 39
                KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> 13
                else -> null
            }
            if (jsKeyCode != null) {
                val jsKey = when (jsKeyCode) {
                    38 -> "ArrowUp"
                    40 -> "ArrowDown"
                    37 -> "ArrowLeft"
                    39 -> "ArrowRight"
                    13 -> "Enter"
                    else -> ""
                }
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

    /** Only pause WebView timers + rendering when activity is fully stopped (backgrounded) */
    override fun onStop() {
        super.onStop()
        webView.onPause()
        webView.pauseTimers()
    }

    /** Resume WebView timers + rendering when app comes back to foreground */
    override fun onResume() {
        super.onResume()
        webView.resumeTimers()
        webView.onResume()
        webView.evaluateJavascript("if (typeof window._clearCardLoadingOverlays === 'function') window._clearCardLoadingOverlays();", null)
        webView.evaluateJavascript("if (typeof window.fetchWatchProgress === 'function') window.fetchWatchProgress();", null)
        
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

