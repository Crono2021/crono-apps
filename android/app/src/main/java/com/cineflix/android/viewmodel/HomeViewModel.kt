package com.cineflix.android.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cineflix.android.TelegramEngine
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

// ── Data models ─────────────────────────────────────────────────────────────

data class CatalogItem(
    val id: String,
    val title: String,
    val payload: String,
    val type: String = "series",
    val tmdbId: Int = 0,
    val posterPath: String = "",
    val backdropPath: String = "",
    val overview: String = "",
    val year: String = "",
    val rating: Float = 0f,
    val genreIds: List<Int> = emptyList(),
)

data class MovieItem(
    val id: String,
    val title: String,
    val payload: String,
    val searchTitle: String = "",
    val tmdbId: Int = 0,
    val posterPath: String = "",
    val backdropPath: String = "",
    val overview: String = "",
    val year: String = "",
    val rating: Float = 0f,
    val genreIds: List<Int> = emptyList(),
)

/** Generic item used for HomeScreen hero + content rows */
data class HeroItem(
    val id: String,
    val title: String,
    val payload: String,
    val posterPath: String = "",
    val backdropPath: String = "",
    val backdropUrl: String = "",
    val overview: String = "",
    val year: String = "",
    val rating: Float = 0f,
    val isMovie: Boolean = false,
) {
    fun asCatalogItem() = CatalogItem(id, title, payload, posterPath = posterPath)
    fun asMovieItem()   = MovieItem(id, title, payload, posterPath = posterPath)
}

data class ContentRowData(val id: String, val title: String, val items: List<HeroItem>)

enum class HomeTab { SERIES, MOVIES }

// ── ViewModel ────────────────────────────────────────────────────────────────

class HomeViewModel(private val engine: TelegramEngine) : ViewModel() {

    companion object {
        private const val CATALOG_URL = "https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/catalog.json"
        private const val MOVIES_URL  = "https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/movies.json"
        private const val TMDB_KEY    = "4cd8c9fe69bba9c8e7a7b2e5e1c0f8f3"
        private const val TMDB_BASE   = "https://api.themoviedb.org/3"
        const val POSTER_BASE  = "https://image.tmdb.org/t/p/w342"
        const val BACKDROP_BASE= "https://image.tmdb.org/t/p/w1280"
    }

    private val http = OkHttpClient()

    // ── State ──────────────────────────────────────────────────────────────────
    private val _tab = MutableStateFlow(HomeTab.SERIES)
    val tab: StateFlow<HomeTab> = _tab.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _catalog = MutableStateFlow<List<CatalogItem>>(emptyList())
    private val _movies  = MutableStateFlow<List<MovieItem>>(emptyList())

    private val _filteredCatalog = MutableStateFlow<List<CatalogItem>>(emptyList())
    val filteredCatalog: StateFlow<List<CatalogItem>> = _filteredCatalog.asStateFlow()

    private val _filteredMovies = MutableStateFlow<List<MovieItem>>(emptyList())
    val filteredMovies: StateFlow<List<MovieItem>> = _filteredMovies.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    // Hero item (trending or first recent)
    private val _heroItem = MutableStateFlow<HeroItem?>(null)
    val heroItem: StateFlow<HeroItem?> = _heroItem.asStateFlow()

    // Horizontal content rows for series
    private val _contentRows = MutableStateFlow<List<ContentRowData>>(emptyList())
    val contentRows: StateFlow<List<ContentRowData>> = _contentRows.asStateFlow()

    // Horizontal content rows for movies
    private val _movieRows = MutableStateFlow<List<ContentRowData>>(emptyList())
    val movieRows: StateFlow<List<ContentRowData>> = _movieRows.asStateFlow()

    // Genre filter active
    private val _activeGenre = MutableStateFlow<Int?>(null)

    init {
        // Search + genre filtering
        viewModelScope.launch {
            combine(
                _searchQuery.debounce(300),
                _catalog,
                _movies,
                _activeGenre,
            ) { query, cat, mov, genre ->
                Quad(query, cat, mov, genre)
            }.collect { (query, cat, mov, genre) ->
                val filterCat: List<CatalogItem> = when {
                    query.isNotBlank() -> cat.filter { it.title.contains(query, ignoreCase = true) }
                    genre != null      -> cat.filter { it.genreIds.contains(genre) }
                    else               -> cat
                }
                val filterMov: List<MovieItem> = when {
                    query.isNotBlank() -> mov.filter { it.title.contains(query, ignoreCase = true) }
                    genre != null      -> mov.filter { it.genreIds.contains(genre) }
                    else               -> mov
                }
                _filteredCatalog.value = filterCat
                _filteredMovies.value  = filterMov
            }
        }
        loadContent()
    }

    private data class Quad<A,B,C,D>(val a:A, val b:B, val c:C, val d:D)
    private operator fun <A,B,C,D> Quad<A,B,C,D>.component1() = a
    private operator fun <A,B,C,D> Quad<A,B,C,D>.component2() = b
    private operator fun <A,B,C,D> Quad<A,B,C,D>.component3() = c
    private operator fun <A,B,C,D> Quad<A,B,C,D>.component4() = d

    fun setTab(tab: HomeTab) {
        _tab.value = tab
        _searchQuery.value = ""
    }
    fun setSearch(q: String) { _searchQuery.value = q }
    fun setGenre(id: Int?) { _activeGenre.value = id }

    // ── Load ──────────────────────────────────────────────────────────────────
    private fun loadContent() {
        viewModelScope.launch {
            _loading.value = true
            awaitAll(
                async(Dispatchers.IO) { loadCatalog() },
                async(Dispatchers.IO) { loadMovies() },
            )
            _loading.value = false
        }
    }

    private suspend fun loadCatalog() {
        try {
            val json = fetchJson(CATALOG_URL) ?: return
            val arr  = JSONArray(json)
            val rawItems = (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                CatalogItem(
                    id      = o.optString("id", i.toString()),
                    title   = o.optString("title", ""),
                    payload = o.optString("payload", ""),
                    type    = o.optString("type", "series"),
                    tmdbId  = o.optInt("tmdbId", 0),
                    year    = o.optString("year", ""),
                )
            }.filter { it.title.isNotBlank() }

            _catalog.value = rawItems
            _filteredCatalog.value = rawItems

            // Build initial rows from recent
            val recent = rawItems.filter { (it.year.toIntOrNull() ?: 0) >= 2023 }
                .sortedByDescending { it.year.toIntOrNull() ?: 0 }
                .take(30)
            val recentRow = ContentRowData("recent", "🆕 Estrenos recientes", recent.map { it.toHeroItem() })
            _contentRows.value = listOf(recentRow)

            // Set hero from first recent
            if (recent.isNotEmpty() && _heroItem.value == null) {
                _heroItem.value = recent.first().toHeroItem()
            }

            // Enrich with TMDB in background
            enrichCatalogWithTmdb(rawItems)
        } catch (e: Exception) { /* use empty */ }
    }

    private suspend fun loadMovies() {
        try {
            val json = fetchJson(MOVIES_URL) ?: return
            val arr  = JSONArray(json)
            val rawItems = (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                MovieItem(
                    id          = o.optString("id", "mv_$i"),
                    title       = o.optString("title", ""),
                    payload     = o.optString("payload", ""),
                    searchTitle = o.optString("search_title", ""),
                    tmdbId      = o.optInt("tmdbId", 0),
                    year        = o.optString("year", ""),
                )
            }.filter { it.title.isNotBlank() }

            _movies.value = rawItems
            _filteredMovies.value = rawItems

            val recent = rawItems.filter { (it.year.toIntOrNull() ?: 0) >= 2024 }
                .sortedByDescending { it.year.toIntOrNull() ?: 0 }
                .take(30)
            val recentRow = ContentRowData("mov_recent", "🆕 Estrenos recientes", recent.map { it.toHeroItem() })
            _movieRows.value = listOf(recentRow)

            enrichMoviesWithTmdb(rawItems)
        } catch (e: Exception) { /* use empty */ }
    }

    private suspend fun enrichCatalogWithTmdb(items: List<CatalogItem>) {
        val heroSet = mutableListOf<CatalogItem>()
        val genreBuckets = mutableMapOf<String, MutableList<CatalogItem>>()

        val SERIES_GENRE_ROWS = listOf(
            Triple("drama",     "🎭 Drama",     listOf(18)),
            Triple("comedy",    "😂 Comedia",   listOf(35)),
            Triple("action",    "⚡ Acción y aventura", listOf(10759)),
            Triple("scifi",     "🚀 Ciencia ficción", listOf(10765)),
            Triple("crime",     "🔍 Crimen",    listOf(80)),
            Triple("animation", "🎨 Animación", listOf(16)),
            Triple("family",    "👨‍👩‍👧 Familiar",  listOf(10751)),
        )

        val enriched = items.map { item ->
            try {
                val tmdb = if (item.tmdbId != 0) fetchTmdbSeries(item.tmdbId)
                           else searchTmdb("tv", item.title)
                if (tmdb != null) {
                    val genres = tmdb.optJSONArray("genre_ids") ?: tmdb.optJSONArray("genres")
                    val genreIds = (0 until (genres?.length() ?: 0)).map { i ->
                        if (genres?.get(i) is JSONObject) (genres.get(i) as JSONObject).optInt("id")
                        else genres?.getInt(i) ?: 0
                    }.filter { it != 0 }
                    item.copy(
                        posterPath   = tmdb.optString("poster_path",   ""),
                        backdropPath = tmdb.optString("backdrop_path", ""),
                        overview     = tmdb.optString("overview", ""),
                        year         = tmdb.optString("first_air_date", "").take(4).ifEmpty { item.year },
                        rating       = tmdb.optDouble("vote_average", 0.0).toFloat(),
                        genreIds     = genreIds,
                    )
                } else item
            } catch (_: Exception) { item }
        }

        _catalog.value = enriched
        _filteredCatalog.value = enriched

        // Rebuild rows
        val rows = mutableListOf<ContentRowData>()

        // Recent row
        val recent = enriched.filter { (it.year.toIntOrNull() ?: 0) >= 2023 }
            .sortedByDescending { it.year.toIntOrNull() ?: 0 }.take(30)
        if (recent.isNotEmpty()) rows.add(ContentRowData("recent", "🆕 Estrenos recientes", recent.map { it.toHeroItem() }))

        // Top rated as "Trending"
        val topRated = enriched.filter { it.rating > 0 }.sortedByDescending { it.rating }.take(20)
        if (topRated.isNotEmpty()) {
            rows.add(0, ContentRowData("trending", "🔥 En tendencia esta semana", topRated.map { it.toHeroItem() }))
            // Update hero to best rated
            _heroItem.value = topRated.first().toHeroItem()
        }

        // Genre rows
        SERIES_GENRE_ROWS.forEach { (id, title, ids) ->
            val genreItems = enriched.filter { it.genreIds.any { g -> ids.contains(g) } }.take(40)
            if (genreItems.size >= 4) rows.add(ContentRowData(id, title, genreItems.map { it.toHeroItem() }))
        }

        _contentRows.value = rows
    }

    private suspend fun enrichMoviesWithTmdb(items: List<MovieItem>) {
        val MOVIE_GENRE_ROWS = listOf(
            Triple("mov_action",  "⚡ Acción",         listOf(28, 12, 10752)),
            Triple("mov_comedy",  "😂 Comedia",         listOf(35)),
            Triple("mov_drama",   "🎭 Drama",            listOf(18, 36)),
            Triple("mov_horror",  "👻 Terror",           listOf(27, 9648)),
            Triple("mov_scifi",   "🚀 Ciencia Ficción", listOf(878, 14)),
            Triple("mov_crime",   "🔍 Crimen",          listOf(80, 53)),
            Triple("mov_family",  "👨‍👩‍👧 Familiar",       listOf(10751, 16)),
        )

        val enriched = items.map { item ->
            try {
                val titleToSearch = item.searchTitle.ifEmpty { item.title }
                val tmdb = if (item.tmdbId != 0) fetchTmdbMovie(item.tmdbId)
                           else searchTmdb("movie", titleToSearch)
                if (tmdb != null) {
                    val genres = tmdb.optJSONArray("genre_ids") ?: tmdb.optJSONArray("genres")
                    val genreIds = (0 until (genres?.length() ?: 0)).map { i ->
                        if (genres?.get(i) is JSONObject) (genres.get(i) as JSONObject).optInt("id")
                        else genres?.getInt(i) ?: 0
                    }.filter { it != 0 }
                    item.copy(
                        posterPath   = tmdb.optString("poster_path",   ""),
                        backdropPath = tmdb.optString("backdrop_path", ""),
                        overview     = tmdb.optString("overview", ""),
                        year         = tmdb.optString("release_date", "").take(4).ifEmpty { item.year },
                        rating       = tmdb.optDouble("vote_average", 0.0).toFloat(),
                        genreIds     = genreIds,
                    )
                } else item
            } catch (_: Exception) { item }
        }

        _movies.value = enriched
        _filteredMovies.value = enriched

        val rows = mutableListOf<ContentRowData>()

        val recent = enriched.filter { (it.year.toIntOrNull() ?: 0) >= 2024 }
            .sortedByDescending { it.year.toIntOrNull() ?: 0 }.take(30)
        if (recent.isNotEmpty()) rows.add(ContentRowData("mov_recent", "🆕 Estrenos recientes", recent.map { it.toHeroItem() }))

        val topRated = enriched.filter { it.rating > 0 }.sortedByDescending { it.rating }.take(20)
        if (topRated.isNotEmpty()) rows.add(0, ContentRowData("mov_trending", "🔥 En tendencia esta semana", topRated.map { it.toHeroItem() }))

        MOVIE_GENRE_ROWS.forEach { (id, title, ids) ->
            val genreItems = enriched.filter { it.genreIds.any { g -> ids.contains(g) } }.take(40)
            if (genreItems.size >= 4) rows.add(ContentRowData(id, title, genreItems.map { it.toHeroItem() }))
        }
        _movieRows.value = rows
    }

    fun posterUrl(path: String): String? =
        if (path.isNotEmpty()) "$POSTER_BASE$path" else null

    // ── TMDB Helpers ──────────────────────────────────────────────────────────
    private suspend fun fetchTmdbSeries(id: Int): JSONObject? = withContext(Dispatchers.IO) {
        runCatching { fetchJson("$TMDB_BASE/tv/$id?api_key=$TMDB_KEY&language=es-ES")?.let { JSONObject(it) } }.getOrNull()
    }
    private suspend fun fetchTmdbMovie(id: Int): JSONObject? = withContext(Dispatchers.IO) {
        runCatching { fetchJson("$TMDB_BASE/movie/$id?api_key=$TMDB_KEY&language=es-ES")?.let { JSONObject(it) } }.getOrNull()
    }
    private suspend fun searchTmdb(type: String, title: String): JSONObject? = withContext(Dispatchers.IO) {
        runCatching {
            val url = "$TMDB_BASE/search/$type?api_key=$TMDB_KEY&language=es-ES&query=${encode(title)}"
            val body = fetchJson(url) ?: return@runCatching null
            val results = JSONObject(body).optJSONArray("results") ?: return@runCatching null
            if (results.length() == 0) null else results.getJSONObject(0)
        }.getOrNull()
    }

    private fun fetchJson(url: String): String? = runCatching {
        http.newCall(Request.Builder().url(url).build()).execute().use { it.body?.string() }
    }.getOrNull()

    private fun encode(s: String) = java.net.URLEncoder.encode(s, "UTF-8")

    // ── Extension converters ───────────────────────────────────────────────────
    private fun CatalogItem.toHeroItem() = HeroItem(
        id          = id,
        title       = title,
        payload     = payload,
        posterPath  = posterPath,
        backdropPath= backdropPath,
        backdropUrl = if (backdropPath.isNotEmpty()) "$BACKDROP_BASE$backdropPath" else "",
        overview    = overview,
        year        = year,
        rating      = rating,
        isMovie     = false,
    )
    private fun MovieItem.toHeroItem() = HeroItem(
        id          = id,
        title       = title,
        payload     = payload,
        posterPath  = posterPath,
        backdropPath= backdropPath,
        backdropUrl = if (backdropPath.isNotEmpty()) "$BACKDROP_BASE$backdropPath" else "",
        overview    = overview,
        year        = year,
        rating      = rating,
        isMovie     = true,
    )

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HomeViewModel(TelegramEngine.getInstance(context)) as T
    }
}
