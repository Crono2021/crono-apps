package com.cineflix.android.ui.player

import androidx.media3.datasource.DataSource
import com.cineflix.android.TelegramEngine

class TdlibDataSourceFactory(
    private val engine: TelegramEngine,
    private val fileParts: List<FilePart>? = null
) : DataSource.Factory {
    override fun createDataSource(): DataSource {
        return TdlibMemoryDataSource(engine, fileParts)
    }
}
