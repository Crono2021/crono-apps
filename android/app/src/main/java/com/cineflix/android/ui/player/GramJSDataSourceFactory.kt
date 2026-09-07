package com.cineflix.android.ui.player

import androidx.media3.datasource.DataSource
import com.cineflix.android.GramJSStreamManager

class GramJSDataSourceFactory(
    private val playbackId: String,
    private val fileId: Int
) : DataSource.Factory {
    override fun createDataSource(): DataSource {
        val webView = GramJSStreamManager.webView 
            ?: throw IllegalStateException("WebView not available in GramJSStreamManager")
        return GramJSMemoryDataSource(webView, playbackId, fileId)
    }
}
