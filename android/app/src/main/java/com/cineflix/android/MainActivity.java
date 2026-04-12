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
     * Configure the WebView for a smooth mobile experience:
     * - Enable touch scrolling and DOM storage
     * - Allow media autoplay (needed for video element fallback)
     * - Disable overscroll glow effect
     */
    private void configureWebView() {
        WebView wv = getBridge().getWebView();

        // Allow scrolling with finger
        wv.setScrollContainer(true);
        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);
        wv.setOverScrollMode(WebView.OVER_SCROLL_NEVER);

        WebSettings settings = wv.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false); // allow autoplay
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        // Enable text zoom reset (prevents tiny text on some devices)
        settings.setTextZoom(100);
    }
}
