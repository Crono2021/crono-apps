package com.cineflix.android;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    private TelegramManager telegramManager;
    private LocalStreamProxy streamProxy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(ExoPlayerPlugin.class);
        super.onCreate(savedInstanceState);
        configureWebView();

        WebView wv = getBridge().getWebView();

        // Inicializar Motor TDLib
        telegramManager = new TelegramManager(this, wv);
        wv.addJavascriptInterface(telegramManager, "AndroidTelegram");

        // Inicializar Proxy Local y conectar eventos UpdateFile al proxy
        streamProxy = new LocalStreamProxy(telegramManager);
        telegramManager.setStreamProxy(streamProxy);

        try {
            streamProxy.start();
            int port = streamProxy.getListeningPort();
            android.util.Log.i("MainActivity", "LocalStreamProxy iniciado en el puerto " + port);

            // Exponer el puerto via JavascriptInterface (accesible en cualquier momento,
            // sin interferir con el WebViewClient de Capacitor)
            wv.addJavascriptInterface(new Object() {
                @android.webkit.JavascriptInterface
                public int getPort() { return port; }
            }, "AndroidProxyPort");

            // Inyeccion directa tambien (cubre recargas y evaluaciones tardias)
            wv.evaluateJavascript("window.CINEFLIX_PROXY_PORT = " + port + ";", null);

        } catch (Exception e) {
            android.util.Log.e("MainActivity", "Error iniciando LocalStreamProxy", e);
        }
    }

    /**
     * Android back button: JS handles navigation first.
     */
    @Override
    public void onBackPressed() {
        WebView wv = getBridge().getWebView();
        wv.evaluateJavascript(
            "(typeof window.__cineflixBack === 'function' && window.__cineflixBack() === true)",
            value -> {
                if (!"true".equals(value)) {
                    runOnUiThread(() -> moveTaskToBack(true));
                }
            }
        );
    }

    private void configureWebView() {
        WebView wv = getBridge().getWebView();
        wv.setScrollContainer(true);
        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);
        wv.setOverScrollMode(WebView.OVER_SCROLL_NEVER);

        WebSettings settings = wv.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setTextZoom(100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (streamProxy != null) streamProxy.stop();
    }
}
