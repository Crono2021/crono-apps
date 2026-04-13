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

data class CatalogItem(
    val id: String,
    val title: String,
    val payload: String,
    val type: String,        // "series" | "movie"
    val tmdbId: Int = 0,
    val posterPath: String = "",
    val overview: String = "",
    val year: String = "",
    val rating: Float = 0f,
)

data class MovieItem(
    val id: String,
    val title: String,
    val payload: String,
    val tmdbId: Int = 0,
    val posterPath: String = "",
    val overview: String = "",
    val year: String = "",
    val rating: Float = 0f,
)

enum class HomeTab { SERIES, MOVIES, TRENDING }

class HomeViewModel(private val engine: TelegramEngine) : ViewModel() {

    companion object {
        private const val CATALOG_URL = "https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/catalog.json"
        private const val MOVIES_URL  = "https://raw.githubusercontent.com/Crono2021/cineflix-catalog/main/movies.json"
        private const val TMDB_KEY    = "4cd8c9fe69bba9c8e7a7b2e5e1c0f8f3"  // Replace with real key
        private const val TMDB_BASE   = "https://api.themoviedb.org/3"
        private const val POSTER_BASE = "https://image.tmdb.org/t/p/w342"

        fun getTmdbKey(context: Context): String {
            return try {
                context.assets.open("tmdb_key.txt").bufferedReader().readText().trim()
            } catch (e: Exception) { TMDB_KEY }
        }
    }

    private val http = OkHttpClient()

    // ── State ─────────────────────────────────────────────────────────────────
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

    private val _trending = MutableStateFlow<List<CatalogItem>>(emptyList())
    val trending: StateFlow<List<CatalogItem>> = _trending.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading.asStateFlow()

    init {
        // Search filtering with 300ms debounce
        viewModelScope.launch {
            combine(_searchQuery.debounce(300), _catalog, _movies) { query, cat, mov ->
                Triple(query, cat, mov)
            }.collect { (query, cat, mov) ->
                _filteredCatalog.value = if (query.isBlank()) cat
                    else cat.filter { it.title.contains(query, ignoreCase = true) }
                _filteredMovies.value = if (query.isBlank()) mov
                    else mov.filter { it.title.contains(query, ignoreCase = true) }
            }
        }
        loadContent()
    }

    fun setTab(tab: HomeTab) { _tab.value = tab }
    fun setSearch(query: String) { _searchQuery.value = query }

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
            val arr = JSONArray(json)
            val items = (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                CatalogItem(
                    id      = o.optString("id", i.toString()),
                    title   = o.optString("title", ""),
                    payload = o.optString("payload", ""),
                    type    = o.optString("type", "series"),
                    tmdbId  = o.optInt("tmdbId", 0),
                )
            }.filter { it.title.isNotBlank() }
            _catalog.value = items
            _filteredCatalog.value = items
            // Load TMDB posters in background
            enrichCatalogWithTmdb(items)
        } catch (e: Exception) { /* use empty */ }
    }

    private suspend fun loadMovies() {
        try {
            val json = fetchJson(MOVIES_URL) ?: return
            val arr = JSONArray(json)
            val items = (0 until arr.length()).map { i ->
                val o = arr.getJSONObject(i)
                MovieItem(
                    id      = o.optString("id", i.toString()),
                    title   = o.optString("title", ""),
                    payload = o.optString("payload", ""),
                    tmdbId  = o.optInt("tmdbId", 0),
                )
            }.filter { it.title.isNotBlank() }
            _movies.value = items
            _filteredMovies.value = items
            enrichMoviesWithTmdb(items)
        } catch (e: Exception) { /* use empty */ }
    }

    private suspend fun enrichCatalogWithTmdb(items: List<CatalogItem>) {
        val enriched = items.map { item ->
            if (item.tmdbId != 0) {
                fetchTmdbSeries(item.tmdbId)?.let { tmdb ->
                    item.copy(
                        posterPath = tmdb.optString("poster_path",""),
                        overview   = tmdb.optString("overview",""),
                        year       = tmdb.optString("first_air_date","").take(4),
                        rating     = tmdb.optDouble("vote_average",0.0).toFloat(),
                    )
                } ?: item
            } else {
                searchTmdbSeries(item.title)?.let { tmdb ->
                    item.copy(
                        posterPath = tmdb.optString("poster_path",""),
                        overview   = tmdb.optString("overview",""),
                        year       = tmdb.optString("first_air_date","").take(4),
                        rating     = tmdb.optDouble("vote_average",0.0).toFloat(),
                    )
                } ?: item
            }
        }
        _catalog.value = enriched
        _filteredCatalog.value = if (_searchQuery.value.isBlank()) enriched
            else enriched.filter { it.title.contains(_searchQuery.value, ignoreCase = true) }
    }

    private suspend fun enrichMoviesWithTmdb(items: List<MovieItem>) {
        val enriched = items.map { item ->
            (if (item.tmdbId != 0) fetchTmdbMovie(item.tmdbId) else searchTmdbMovie(item.title))
                ?.let { tmdb ->
                    item.copy(
                        posterPath = tmdb.optString("poster_path",""),
                        overview   = tmdb.optString("overview",""),
                        year       = tmdb.optString("release_date","").take(4),
                        rating     = tmdb.optDouble("vote_average",0.0).toFloat(),
                    )
                } ?: item
        }
        _movies.value = enriched
        _filteredMovies.value = if (_searchQuery.value.isBlank()) enriched
            else enriched.filter { it.title.contains(_searchQuery.value, ignoreCase = true) }
    }

    fun posterUrl(path: String) = if (path.isNotEmpty()) "$POSTER_BASE$path" else null

    private suspend fun fetchTmdbSeries(tmdbId: Int): JSONObject? = withContext(Dispatchers.IO) {
        fetchJsonObj("$TMDB_BASE/tv/$tmdbId?api_key=$TMDB_KEY&language=es-ES")
    }
    private suspend fun searchTmdbSeries(title: String): JSONObject? = withContext(Dispatchers.IO) {
        val url = "$TMDB_BASE/search/tv?api_key=$TMDB_KEY&language=es-ES&query=${encode(title)}"
        fetchJsonObj(url)?.let { obj ->
            val res = obj.optJSONArray("results")
            if (res != null && res.length() > 0) res.getJSONObject(0) else null
        }
    }
    private suspend fun fetchTmdbMovie(tmdbId: Int): JSONObject? = withContext(Dispatchers.IO) {
        fetchJsonObj("$TMDB_BASE/movie/$tmdbId?api_key=$TMDB_KEY&language=es-ES")
    }
    private suspend fun searchTmdbMovie(title: String): JSONObject? = withContext(Dispatchers.IO) {
        val url = "$TMDB_BASE/search/movie?api_key=$TMDB_KEY&language=es-ES&query=${encode(title)}"
        fetchJsonObj(url)?.let { obj ->
            val res = obj.optJSONArray("results")
            if (res != null && res.length() > 0) res.getJSONObject(0) else null
        }
    }

    private fun fetchJson(url: String): String? = try {
        http.newCall(Request.Builder().url(url).build()).execute().use { it.body?.string() }
    } catch (e: Exception) { null }

    private fun fetchJsonObj(url: String): JSONObject? = try {
        val body = fetchJson(url) ?: return null
        JSONObject(body)
    } catch (e: Exception) { null }

    private fun encode(s: String) = java.net.URLEncoder.encode(s, "UTF-8")

    class Factory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(TelegramEngine.getInstance(context)) as T
        }
    }
}
