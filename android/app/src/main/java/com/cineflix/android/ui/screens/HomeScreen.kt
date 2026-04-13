package com.cineflix.android.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.*
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cineflix.android.ui.theme.*
import com.cineflix.android.viewmodel.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    userName: String?,
    onSeriesClick: (CatalogItem) -> Unit,
    onMovieClick: (MovieItem) -> Unit,
    onLogout: () -> Unit,
) {
    val tab           by viewModel.tab.collectAsState()
    val query         by viewModel.searchQuery.collectAsState()
    val series        by viewModel.filteredCatalog.collectAsState()
    val movies        by viewModel.filteredMovies.collectAsState()
    val loading       by viewModel.loading.collectAsState()

    Scaffold(
        containerColor = Background,
        topBar = {
            TopBar(userName = userName, onLogout = onLogout)
        }
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Search bar
            SearchBar(query = query, onQueryChange = viewModel::setSearch)
            Spacer(Modifier.height(8.dp))

            // Tabs
            TabRow(
                selectedTabIndex = tab.ordinal,
                containerColor   = SurfaceDark,
                contentColor     = CineflixRed,
                indicator        = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[tab.ordinal]),
                        color = CineflixRed,
                    )
                }
            ) {
                Tab(selected = tab == HomeTab.SERIES,
                    onClick = { viewModel.setTab(HomeTab.SERIES) },
                    text = { Text("Series", color = if (tab == HomeTab.SERIES) CineflixRed else TextMuted) })
                Tab(selected = tab == HomeTab.MOVIES,
                    onClick = { viewModel.setTab(HomeTab.MOVIES) },
                    text = { Text("Películas", color = if (tab == HomeTab.MOVIES) CineflixRed else TextMuted) })
                Tab(selected = tab == HomeTab.TRENDING,
                    onClick = { viewModel.setTab(HomeTab.TRENDING) },
                    text = { Text("Tendencia", color = if (tab == HomeTab.TRENDING) CineflixRed else TextMuted) })
            }

            if (loading) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = CineflixRed)
                }
            } else {
                AnimatedContent(targetState = tab, label = "tab_content") { currentTab ->
                    when (currentTab) {
                        HomeTab.SERIES  -> ContentGrid(
                            items = series,
                            posterUrl = viewModel::posterUrl,
                            onItemClick = { onSeriesClick(it) },
                        )
                        HomeTab.MOVIES -> MovieGrid(
                            items = movies,
                            posterUrl = viewModel::posterUrl,
                            onItemClick = { onMovieClick(it) },
                        )
                        HomeTab.TRENDING -> ContentGrid(
                            items = series.sortedByDescending { it.rating }.take(40),
                            posterUrl = viewModel::posterUrl,
                            onItemClick = { onSeriesClick(it) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(userName: String?, onLogout: () -> Unit) {
    Surface(color = SurfaceDark, shadowElevation = 4.dp) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("🎬", fontSize = 24.sp)
            Spacer(Modifier.width(8.dp))
            Text(
                "Cineflix",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                modifier = Modifier.weight(1f),
            )
            if (!userName.isNullOrEmpty()) {
                Text(userName, style = MaterialTheme.typography.bodySmall, color = TextMuted)
                Spacer(Modifier.width(8.dp))
            }
            IconButton(onClick = onLogout) {
                Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar sesión", tint = TextMuted)
            }
        }
    }
}

@Composable
private fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text("Buscar series, películas...", color = TextMuted) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextMuted) },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(Icons.Default.Clear, contentDescription = "Limpiar", tint = TextMuted)
                }
            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor    = CineflixRed,
            unfocusedBorderColor  = Color(0xFF333350),
            focusedTextColor      = TextPrimary,
            unfocusedTextColor    = TextPrimary,
            cursorColor           = CineflixRed,
            focusedContainerColor = Color(0xFF1A1A28),
            unfocusedContainerColor = Color(0xFF15151F),
        ),
        shape = RoundedCornerShape(14.dp),
    )
}

@Composable
private fun ContentGrid(
    items: List<CatalogItem>,
    posterUrl: (String) -> String?,
    onItemClick: (CatalogItem) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items, key = { it.id }) { item ->
            PosterCard(
                title     = item.title,
                posterUrl = item.posterPath.let { posterUrl(it) },
                rating    = item.rating,
                onClick   = { onItemClick(item) },
            )
        }
    }
}

@Composable
private fun MovieGrid(
    items: List<MovieItem>,
    posterUrl: (String) -> String?,
    onItemClick: (MovieItem) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        contentPadding = PaddingValues(12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(items, key = { it.id }) { item ->
            PosterCard(
                title     = item.title,
                posterUrl = item.posterPath.let { posterUrl(it) },
                rating    = item.rating,
                onClick   = { onItemClick(item) },
            )
        }
    }
}

@Composable
fun PosterCard(
    title: String,
    posterUrl: String?,
    rating: Float = 0f,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f / 3f),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = SurfaceCard),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box(Modifier.fillMaxSize()) {
            if (!posterUrl.isNullOrEmpty()) {
                AsyncImage(
                    model = posterUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
            } else {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(SurfaceMid),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("🎬", fontSize = 32.sp)
                }
            }
            // Gradient overlay at bottom
            Box(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color(0xDD000000))
                        )
                    )
            )
            // Title
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                if (rating > 0f) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null,
                            tint = CineflixGold, modifier = Modifier.size(10.dp))
                        Spacer(Modifier.width(2.dp))
                        Text("%.1f".format(rating), fontSize = 10.sp, color = CineflixGold)
                    }
                    Spacer(Modifier.height(2.dp))
                }
                Text(
                    title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelMedium,
                    color = TextPrimary,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}
