package com.cineflix.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var bridge: AndroidBridge
    private lateinit var engine: TelegramEngine

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        engine = TelegramEngine.getInstance(this)

        webView = WebView(this).apply {
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                allowFileAccess = true
                allowContentAccess = true
                databaseEnabled = true
                mediaPlaybackRequiresUserGesture = false
            }

            // Mapeamos AndroidBridge.kt a window.AndroidBridge en Javascript
            bridge = AndroidBridge(this@MainActivity, this, engine)
            addJavascriptInterface(bridge, "AndroidBridge")

            // Evitar que abra el navegador externo
            webViewClient = WebViewClient()

            // Utilizado para logs de console.log() de JS en el logcat de Android
            webChromeClient = object : WebChromeClient() {
                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                    android.util.Log.d("CineflixWebView", "${consoleMessage.message()} -- From line "
                            + "${consoleMessage.lineNumber()} of ${consoleMessage.sourceId()}")
                    return super.onConsoleMessage(consoleMessage)
                }
            }

            // Cargamos la app web empaquetada localmente (generada por Vite)
            loadUrl("file:///android_asset/www/index.html")
        }

        setContentView(webView)

        // Manejar el botón de atrás del sistema
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }

    override fun onDestroy() {
        bridge.cleanup()
        super.onDestroy()
    }
}
