package com.cineflix.android.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cineflix.android.ui.theme.*
import com.cineflix.android.viewmodel.*

/**
 * HomeScreen: Faithful Compose port of the original Netflix-style web UI.
 *   - Sticky topbar with title + search + logout
 *   - Main nav tabs: 📺 Series / 🎬 Películas
 *   - Genre filter chips (scrollable horizontal)
 *   - Hero section (backdrop + gradient overlay + title + "Ver ahora" button)
 *   - Horizontal scrollable content rows by genre
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    userName: String?,
    onSeriesClick: (CatalogItem) -> Unit,
    onMovieClick: (MovieItem) -> Unit,
    onLogout: () -> Unit,
) {
    val tab      by viewModel.tab.collectAsState()
    val query    by viewModel.searchQuery.collectAsState()
    val series   by viewModel.filteredCatalog.collectAsState()
    val movies   by viewModel.filteredMovies.collectAsState()
    val loading  by viewModel.loading.collectAsState()
    val hero     by viewModel.heroItem.collectAsState()
    val heroRows by viewModel.contentRows.collectAsState()
    val movieRows by viewModel.movieRows.collectAsState()

    // Outer vertically-scrollable column (like view-catalog overflow-y: auto)
    Column(
        Modifier
            .fillMaxSize()
            .background(AppBg)
            .verticalScroll(rememberScrollState())
    ) {
        // ── Sticky Topbar ─────────────────────────────────────────────────
        TopBar(
            query    = query,
            onQuery  = viewModel::setSearch,
            tab      = tab,
            onTab    = viewModel::setTab,
            onLogout = onLogout,
        )

        // ── Genre Tabs ────────────────────────────────────────────────────
        GenreTabs(
            isMovies  = tab == HomeTab.MOVIES,
            onGenre   = viewModel::setGenre,
        )

        when {
            // ── Search Results ─────────────────────────────────────────────
            query.isNotBlank() -> {
                val items = if (tab == HomeTab.MOVIES) movies else series
                val count = items.size
                Text(
                    "$count resultado${if (count != 1) "s" else ""}",
                    color = TextMuted, fontSize = 13.sp,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                )
                if (tab == HomeTab.MOVIES) {
                    CatalogGrid(movies, onMovieClick, viewModel::posterUrl)
                } else {
                    CatalogGrid(series, onSeriesClick, viewModel::posterUrl)
                }
            }

            loading -> {
                Box(
                    Modifier.fillMaxWidth().height(300.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = Purple, strokeWidth = 3.dp)
                        Spacer(Modifier.height(12.dp))
                        Text("Cargando catálogo...", color = TextMuted, fontSize = 13.sp)
                    }
                }
            }

            else -> {
                // ── Hero Section ───────────────────────────────────────────
                if (hero != null) {
                    HeroSection(
                        item     = hero!!,
                        onPlay   = {
                            if (tab == HomeTab.MOVIES) onMovieClick(hero!!.asMovieItem())
                            else onSeriesClick(hero!!.asCatalogItem())
                        },
                        isMovies = tab == HomeTab.MOVIES,
                    )
                }

                // ── Content Rows ───────────────────────────────────────────
                val rows = if (tab == HomeTab.MOVIES) movieRows else heroRows
                rows.forEach { row ->
                    ContentRow(
                        title    = row.title,
                        items    = row.items,
                        onClick  = { item ->
                            if (tab == HomeTab.MOVIES) onMovieClick(item.asMovieItem())
                            else onSeriesClick(item.asCatalogItem())
                        },
                        posterUrl = viewModel::posterUrl,
                    )
                }
            }
        }
        Spacer(Modifier.height(40.dp))
    }
}

// ── Topbar ─────────────────────────────────────────────────────────────────
@Composable
private fun TopBar(
    query: String,
    onQuery: (String) -> Unit,
    tab: HomeTab,
    onTab: (HomeTab) -> Unit,
    onLogout: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(TopbarBg)
            .border(BorderStroke(0.5.dp, Color(0x0FFFFFFF)), shape = RectangleShape),
    ) {
        // First row: title + search + logout button
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Cine en Castellano HD",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(end = 12.dp),
            )
            // Search input
            OutlinedTextField(
                value = query,
                onValueChange = onQuery,
                placeholder = { Text("🔍 Buscar...", color = TextMuted, fontSize = 13.sp) },
                singleLine = true,
                modifier = Modifier.weight(1f).height(44.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor    = Purple,
                    unfocusedBorderColor  = Color(0x1AFFFFFF),
                    focusedTextColor      = Color.White,
                    unfocusedTextColor    = Color.White,
                    cursorColor           = Purple,
                    focusedContainerColor = Color(0x14FFFFFF),
                    unfocusedContainerColor = Color(0x14FFFFFF),
                ),
                shape = RoundedCornerShape(20.dp),
            )
            Spacer(Modifier.width(8.dp))
            // Logout button (like .btn-icon with ⏻)
            IconButton(
                onClick = onLogout,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0x0AFFFFFF)),
            ) {
                Icon(Icons.Default.PowerSettingsNew, contentDescription = "Cerrar sesión",
                    tint = Color(0xFFF87171), modifier = Modifier.size(20.dp))
            }
        }

        // Main nav tabs: 📺 Series / 🎬 Películas
        Row(
            Modifier
                .fillMaxWidth()
                .background(Surface1)
                .padding(horizontal = 16.dp),
        ) {
            NavTab("📺 Series", tab == HomeTab.SERIES) { onTab(HomeTab.SERIES) }
            NavTab("🎬 Películas", tab == HomeTab.MOVIES) { onTab(HomeTab.MOVIES) }
        }
    }
}

@Composable
private fun NavTab(text: String, active: Boolean, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 10.dp),
    ) {
        Text(
            text,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = if (active) PurpleMedium else Color(0x80FFFFFF),
        )
        if (active) {
            Spacer(
                Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(2.dp)
                    .offset(y = 10.dp)
                    .background(PurpleMedium, RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
            )
        }
    }
}

// ── Genre Tabs ─────────────────────────────────────────────────────────────
private val SERIES_GENRES = listOf(
    "✦ Todos" to null,
    "🎭 Drama" to 18,
    "😂 Comedia" to 35,
    "⚡ Acción" to 10759,
    "🚀 Sci-Fi" to 10765,
    "🔍 Crimen" to 80,
    "🎨 Animación" to 16,
    "👨‍👩‍👧 Familiar" to 10751,
)
private val MOVIE_GENRES = listOf(
    "✶ Todas" to null,
    "⚡ Acción" to 28,
    "😂 Comedia" to 35,
    "🎭 Drama" to 18,
    "👻 Terror" to 27,
    "🚀 Sci-Fi" to 878,
    "🔍 Crimen" to 80,
    "👨‍👩‍👧 Familiar" to 10751,
)

@Composable
private fun GenreTabs(isMovies: Boolean, onGenre: (Int?) -> Unit) {
    var active by remember { mutableStateOf<Int?>(null) }
    val genres = if (isMovies) MOVIE_GENRES else SERIES_GENRES

    // Reset on tab switch
    LaunchedEffect(isMovies) { active = null }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xF20A0A12))
            .border(BorderStroke(0.5.dp, Color(0x0DFFFFFF)), RectangleShape),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(genres) { (label, id) ->
            GenreChip(
                label   = label,
                selected = active == id,
                onClick = { active = id; onGenre(id) },
            )
        }
    }
}

@Composable
private fun GenreChip(label: String, selected: Boolean, onClick: () -> Unit) {
    val containerColor = if (selected) Color.White else Color(0x0DFFFFFF)
    val textColor = if (selected) AppBg else TextFaint
    val borderColor = if (selected) Color.White else Color(0x1FFFFFFF)

    Surface(
        onClick = onClick,
        color = containerColor,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, borderColor),
        modifier = Modifier,
    ) {
        Text(
            label,
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = textColor,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
        )
    }
}

// ── Hero Section ───────────────────────────────────────────────────────────
@Composable
private fun HeroSection(
    item: HeroItem,
    onPlay: () -> Unit,
    isMovies: Boolean,
) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(340.dp)
    ) {
        // Backdrop image
        AsyncImage(
            model = item.backdropUrl,
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )
        // Double gradient overlay (left + bottom) — same as web CSS
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xEB0A0A12), Color(0x800A0A12), Color.Transparent),
                        endX = 600f,
                    )
                )
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Transparent, Color(0x990A0A12), AppBg),
                        startY = 150f,
                    )
                )
        )

        // Content
        Column(
            Modifier
                .align(Alignment.BottomStart)
                .padding(start = 24.dp, end = 80.dp, bottom = 28.dp),
        ) {
            // Badge 🔥 Tendencia / 🎬 En cartelera
            Surface(
                color = NetflixRed,
                shape = RoundedCornerShape(4.dp),
            ) {
                Text(
                    if (isMovies) "🎬 En cartelera" else "🔥 Tendencia",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 10.sp,
                    color = Color.White,
                    letterSpacing = 0.8.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                )
            }
            Spacer(Modifier.height(8.dp))

            Text(
                item.title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                color = Color.White,
                lineHeight = 30.sp,
                maxLines = 2,
            )

            if (item.rating > 0f || item.year.isNotEmpty()) {
                Spacer(Modifier.height(6.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    if (item.rating > 0f) {
                        Text("★ ${"%.1f".format(item.rating)}", color = RatingYellow,
                            fontWeight = FontWeight.Bold, fontSize = 13.sp)
                    }
                    if (item.year.isNotEmpty()) {
                        Text(item.year, color = TextFaint, fontSize = 13.sp)
                    }
                }
            }

            if (item.overview.isNotEmpty()) {
                Spacer(Modifier.height(8.dp))
                Text(
                    item.overview,
                    color = Color(0xFFD4D4D8),
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onPlay,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.height(40.dp),
            ) {
                Text("▶ Ver ahora", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            }
        }
    }
}

// ── Content Row (horizontal scroll, like .row-cards) ──────────────────────
@Composable
private fun ContentRow(
    title: String,
    items: List<HeroItem>,
    onClick: (HeroItem) -> Unit,
    posterUrl: (String) -> String?,
) {
    if (items.isEmpty()) return
    Column(Modifier.padding(top = 8.dp)) {
        Text(
            title,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = TextTitle,
            modifier = Modifier.padding(start = 20.dp, bottom = 8.dp),
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(items, key = { it.id }) { item ->
                SeriesCard(
                    title     = item.title,
                    year      = item.year,
                    posterUrl = item.posterPath.let { posterUrl(it) },
                    onClick   = { onClick(item) },
                    cardWidth = 140.dp,
                )
            }
        }
    }
}

// ── Catalog Grid (search results) ─────────────────────────────────────────
@Composable
private fun <T : Any> CatalogGrid(
    items: List<T>,
    onItemClick: (T) -> Unit,
    posterUrl: (String) -> String?,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth().heightIn(max = 2000.dp),
    ) {
        items(items, key = { item ->
            when (item) {
                is CatalogItem -> item.id
                is MovieItem -> item.id
                else -> item.hashCode()
            }
        }) { item ->
            when (item) {
                is CatalogItem -> SeriesCard(
                    title = item.title, year = item.year,
                    posterUrl = item.posterPath.let { posterUrl(it) },
                    onClick = { onItemClick(item) },
                )
                is MovieItem -> SeriesCard(
                    title = item.title, year = item.year,
                    posterUrl = item.posterPath.let { posterUrl(it) },
                    onClick = { onItemClick(item) },
                )
            }
        }
    }
}

// ── Series Card — matches .series-card CSS exactly ─────────────────────────
@Composable
fun SeriesCard(
    title: String,
    year: String,
    posterUrl: String?,
    onClick: () -> Unit,
    cardWidth: androidx.compose.ui.unit.Dp = 150.dp,
) {
    val displayTitle = title.replace(Regex("\\s*\\(\\d{4}\\)\\s*$"), "").trim()

    Card(
        onClick = onClick,
        modifier = Modifier.width(cardWidth),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Surface3),
        border = BorderStroke(1.dp, Color(0x0FFFFFFF)),
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Column {
            // Poster (2:3 ratio like .series-card-poster)
            Box(
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            ) {
                if (!posterUrl.isNullOrEmpty()) {
                    AsyncImage(
                        model = posterUrl,
                        contentDescription = displayTitle,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                    )
                } else {
                    // Placeholder: linear-gradient(135deg, #1e1b4b, #312e81) + first letter
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFF1E1B4B), Color(0xFF312E81))
                                )
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            displayTitle.firstOrNull()?.uppercaseChar()?.toString() ?: "?",
                            fontSize = 36.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0x40FFFFFF),
                        )
                    }
                }
            }
            // Meta
            Column(Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
                Text(
                    displayTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = TextTitle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 16.sp,
                )
                if (year.isNotEmpty()) {
                    Text(year, fontSize = 11.sp, color = TextYear, fontWeight = FontWeight.Medium, modifier = Modifier.padding(top = 2.dp))
                }
            }
        }
    }
}
