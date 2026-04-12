package com.cineflix.android;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(ExoPlayerPlugin.class);
        super.onCreate(savedInstanceState);
        configureWebView();
    }

    /**
     * Intercept Android back button: ask JS to handle navigation first.
     * JS must expose window.__cineflixBack() returning true if handled.
     * If JS returns false (or isn't ready), we minimize but do NOT exit the app.
     */
    @Override
    public void onBackPressed() {
        WebView wv = getBridge().getWebView();
        wv.evaluateJavascript(
            "(typeof window.__cineflixBack === 'function' && window.__cineflixBack() === true)",
            value -> {
                if (!"true".equals(value)) {
                    // JS didn't handle it → minimize to background (don't kill the process)
                    runOnUiThread(() -> moveTaskToBack(true));
                }
                // else: JS navigated backwards → nothing else to do
            }
        );
    }

    /**
     * Configure WebView for smooth mobile experience.
     */
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
}
