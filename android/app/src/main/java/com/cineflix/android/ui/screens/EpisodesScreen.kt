package com.cineflix.android.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
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
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.theme.*
import com.cineflix.android.viewmodel.CatalogItem
import com.cineflix.android.viewmodel.EpisodesViewModel
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodesScreen(
    item: CatalogItem,
    posterUrl: String?,
    viewModel: EpisodesViewModel,
    onPlayEpisode: (TelegramEngine.VideoInfo) -> Unit,
    onBack: () -> Unit,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(item) {
        viewModel.openSeries(item.title, item.payload)
    }

    Scaffold(
        containerColor = Background,
        topBar = {
            TopAppBar(
                title = { Text(state.title, color = TextPrimary, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = TextPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SurfaceDark),
            )
        }
    ) { paddingValues ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            // Hero poster
            item {
                HeroHeader(title = item.title, overview = item.overview, posterUrl = posterUrl)
            }

            // Season buttons
            if (state.seasons.isNotEmpty()) {
                item {
                    SeasonSelector(
                        seasons       = state.seasons,
                        activeSeason  = state.activeSeason,
                        onSeasonClick = { btn -> viewModel.openSeason(btn, state.currentBotMsgId) },
                    )
                }
            }

            // Loading indicator
            if (state.loading) {
                item {
                    Box(Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            CircularProgressIndicator(color = CineflixRed)
                            Spacer(Modifier.height(12.dp))
                            Text("Cargando episodios...", color = TextMuted, fontSize = 14.sp)
                        }
                    }
                }
            }

            // Error
            state.error?.let { err ->
                item {
                    Box(Modifier.fillMaxWidth().padding(32.dp), contentAlignment = Alignment.Center) {
                        Text(err, color = TextMuted, fontSize = 14.sp)
                    }
                }
            }

            // Episodes list
            itemsIndexed(state.episodes, key = { _, ep -> ep.msgId }) { index, episode ->
                EpisodeItem(
                    index   = index + 1,
                    episode = episode,
                    onClick = { onPlayEpisode(episode) },
                )
            }
        }
    }
}

@Composable
private fun HeroHeader(title: String, overview: String, posterUrl: String?) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(260.dp)
    ) {
        if (!posterUrl.isNullOrEmpty()) {
            AsyncImage(
                model = posterUrl,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
        } else {
            Box(Modifier.fillMaxSize().background(SurfaceMid), contentAlignment = Alignment.Center) {
                Text("🎬", fontSize = 64.sp)
            }
        }
        // Gradient overlay
        Box(
            Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(listOf(Color.Transparent, Background)))
        )
        // Text info
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold, color = TextPrimary)
            if (overview.isNotEmpty()) {
                Spacer(Modifier.height(4.dp))
                Text(overview, style = MaterialTheme.typography.bodySmall, color = TextSecondary, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
private fun SeasonSelector(
    seasons: List<TelegramEngine.SeasonButton>,
    activeSeason: String?,
    onSeasonClick: (TelegramEngine.SeasonButton) -> Unit,
) {
    Column(Modifier.padding(vertical = 12.dp)) {
        Text("Temporadas", style = MaterialTheme.typography.titleMedium, color = TextSecondary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(seasons, key = { it.dataBase64 }) { btn ->
                val selected = btn.text == activeSeason
                FilterChip(
                    selected = selected,
                    onClick = { onSeasonClick(btn) },
                    label = { Text(btn.text, fontSize = 13.sp) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor  = CineflixRed,
                        selectedLabelColor      = Color.White,
                        containerColor          = SurfaceCard,
                        labelColor              = TextSecondary,
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = selected,
                        selectedBorderColor = CineflixRed,
                        borderColor = Color(0xFF444466),
                    )
                )
            }
        }
    }
}

@Composable
private fun EpisodeItem(index: Int, episode: TelegramEngine.VideoInfo, onClick: () -> Unit) {
    val title = episode.caption.ifEmpty { episode.fileName }
    val sizemb = "%.1f MB".format(episode.fileSize / 1_000_000.0)

    Surface(
        onClick = onClick,
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Episode number badge
            Box(
                Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(SurfaceCard),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    index.toString(),
                    color = CineflixRed,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    title,
                    color = TextPrimary,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                )
                Spacer(Modifier.height(2.dp))
                Text(sizemb, color = TextMuted, fontSize = 12.sp)
            }
            Spacer(Modifier.width(8.dp))
            Icon(Icons.Default.PlayArrow, contentDescription = "Reproducir",
                tint = CineflixRed, modifier = Modifier.size(28.dp))
        }
    }
    Divider(color = Color(0xFF222238), thickness = 0.5.dp, modifier = Modifier.padding(horizontal = 16.dp))
}
