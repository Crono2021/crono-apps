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
import androidx.webkit.WebViewAssetLoader

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var bridge: AndroidBridge
    private lateinit var engine: TelegramEngine
    private var isAndroidTV = false

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Detect if running on Android TV
        val uiModeManager = getSystemService(Context.UI_MODE_SERVICE) as UiModeManager
        isAndroidTV = uiModeManager.currentModeType == Configuration.UI_MODE_TYPE_TELEVISION
        android.util.Log.i("CineflixMain", "Android TV mode: $isAndroidTV")

        engine = TelegramEngine.getInstance(this)

        webView = WebView(this).apply {
            keepScreenOn = true
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                allowFileAccess = true
                allowContentAccess = true
                databaseEnabled = true
                mediaPlaybackRequiresUserGesture = false
                @Suppress("DEPRECATION")
                allowFileAccessFromFileURLs = true
                @Suppress("DEPRECATION")
                allowUniversalAccessFromFileURLs = true
            }

            // Mapeamos AndroidBridge.kt a window.AndroidBridge en Javascript
            bridge = AndroidBridge(this@MainActivity, this, engine)
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
                    // Inject TV flag so tv-nav.js can activate D-pad navigation
                    val tvFlag = if (isAndroidTV) "true" else "false"
                    val vCode = try { packageManager.getPackageInfo(packageName, 0).longVersionCode } catch (e: Exception) { 2L }
                    view.evaluateJavascript(
                        "window._cineflixIsTV = $tvFlag; " +
                        "window.__appPlatform = 'android_tv'; " +
                        "window.__appVersion = $vCode; " +
                        "document.documentElement.classList.toggle('android-tv', $tvFlag);",
                        null
                    )
                    android.util.Log.d("CineflixMain", "Injected OTA vars, TV=$tvFlag, v=$vCode")
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
                // Se fuerza al TV a cargar desde sus propios archivos empaquetados para evadir caídas del servidor
                loadUrl("https://appassets.androidplatform.net/assets/www/index.html")
                android.util.Log.d("CineflixMain", "WebView loading local bundled catalog (appassets)")
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
    }

    override fun onDestroy() {
        bridge.cleanup()
        super.onDestroy()
    }
}

