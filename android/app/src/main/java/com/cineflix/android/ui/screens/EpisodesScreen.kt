package com.cineflix.android.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
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
import com.cineflix.android.viewmodel.*

/**
 * EpisodesScreen — faithful port of the web app's view-series + view-episodes.
 *
 * Layout:
 *   ┌── Sticky Topbar (← back + title) ──────────────────────────────────┐
 *   │   Seasons list (season-btn style, exact CSS match)                   │
 *   │   Episodes list (episode-card with thumb + info)                     │
 *   └──────────────────────────────────────────────────────────────────────┘
 */
@Composable
fun EpisodesScreen(
    viewModel: EpisodesViewModel,
    onBack: () -> Unit,
    onPlayEpisode: (TelegramEngine.VideoInfo, Int) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(AppBg)
    ) {
        // ── Topbar (same as .topbar with btn-back) ─────────────────────────
        Surface(
            color = TopbarBg,
            tonalElevation = 0.dp,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0x0AFFFFFF)),
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Volver",
                        tint = TextPrimary, modifier = Modifier.size(20.dp))
                }
                Spacer(Modifier.width(12.dp))
                Text(
                    state.title,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 17.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                )
            }
        }

        // ── Content ────────────────────────────────────────────────────────
        when {
            // Global loading (seasons not yet loaded)
            state.loading && state.seasons.isEmpty() -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(color = Purple, strokeWidth = 3.dp)
                        Spacer(Modifier.height(12.dp))
                        Text("Consultando temporadas...", color = TextMuted, fontSize = 13.sp)
                    }
                }
            }

            state.error != null && state.seasons.isEmpty() -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Error: ${state.error}", color = Color(0xFFF87171), textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                }
            }

            else -> {
                LazyColumn(
                    Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 40.dp),
                ) {
                    // ── Season buttons ────────────────────────────────────
                    if (state.seasons.isNotEmpty()) {
                        item {
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp, vertical = 20.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                            ) {
                                state.seasons.forEach { btn ->
                                    val isBack = btn.text.lowercase().run {
                                        contains("volver") || contains("catálogo")
                                    }
                                    if (isBack) return@forEach

                                    val isComplete = btn.text.lowercase().contains("completa")
                                    val icon = if (isComplete) "🎬" else "📺"
                                    val isActive = btn.text == state.activeSeason

                                    SeasonButton(
                                        text     = "$icon ${btn.text}",
                                        active   = isActive,
                                        onClick  = { viewModel.openSeason(btn, state.currentBotMsgId, state.botChatId) },
                                    )
                                }
                            }
                        }
                    }

                    // ── Episodes loading indicator ─────────────────────────
                    if (state.loading && state.seasons.isNotEmpty()) {
                        item {
                            Box(
                                Modifier.fillMaxWidth().padding(24.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    CircularProgressIndicator(
                                        color = Purple, strokeWidth = 2.5.dp,
                                        modifier = Modifier.size(20.dp),
                                    )
                                    Spacer(Modifier.width(10.dp))
                                    Text("Cargando episodios...", color = TextMuted, fontSize = 13.sp)
                                }
                            }
                        }
                    }

                    // ── No episodes message ────────────────────────────────
                    if (!state.loading && state.error != null && state.seasons.isNotEmpty()) {
                        item {
                            Box(
                                Modifier.fillMaxWidth().padding(40.dp),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(state.error!!, color = TextMuted, fontSize = 14.sp,
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center)
                            }
                        }
                    }

                    // ── Episode cards ──────────────────────────────────────
                    itemsIndexed(state.episodes, key = { _, ep -> ep.msgId }) { index, ep ->
                        EpisodeCard(
                            episode = ep,
                            index   = index,
                            onClick = { onPlayEpisode(ep, index) },
                        )
                    }
                }
            }
        }
    }
}

// ── Season Button — matches .season-btn CSS ────────────────────────────────
@Composable
private fun SeasonButton(text: String, active: Boolean, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        color = if (active) Color(0x26A855F7) else Color(0x0DFFFFFF),
        shape = RoundedCornerShape(14.dp),
        border = if (active) BorderStroke(1.dp, Purple.copy(alpha = 0.4f)) else null,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = TextPrimary,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 18.dp),
        )
    }
}

// ── Episode Card — matches .episode-card CSS ───────────────────────────────
@Composable
private fun EpisodeCard(
    episode: TelegramEngine.VideoInfo,
    index: Int,
    onClick: () -> Unit,
) {
    val epNum = parseEpisodeNumber(episode.fileName, index + 1)
    val title = parseEpisodeTitle(episode.fileName, episode.caption)

    Surface(
        onClick = onClick,
        color = Color(0x08FFFFFF),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, Color(0x0FFFFFFF)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            // Thumbnail (168x95 like .episode-thumb)
            Box(
                Modifier
                    .width(168.dp)
                    .height(95.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .background(Color(0xFF111120)),
                contentAlignment = Alignment.Center,
            ) {
                // Play icon (shown always since we don't have thumbnails from TDLib)
                Icon(
                    Icons.Default.PlayCircleFilled,
                    contentDescription = null,
                    tint = Purple.copy(alpha = 0.5f),
                    modifier = Modifier.size(40.dp),
                )
                // Episode number badge bottom-right
                Box(
                    Modifier
                        .align(Alignment.BottomEnd)
                        .padding(6.dp)
                        .background(Color(0xBF000000), RoundedCornerShape(4.dp))
                ) {
                    Text(
                        formatFileSize(episode.fileSize),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimary,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp),
                    )
                }
            }

            // Info
            Column(
                Modifier
                    .weight(1f)
                    .padding(start = 0.dp, end = 16.dp, top = 12.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                // Episode number (EX — purple, uppercase)
                Text(
                    epNum,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = EpisodeNum,
                    letterSpacing = 0.6.sp,
                )
                Spacer(Modifier.height(3.dp))
                // Title
                Text(
                    title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = TextTitle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 19.sp,
                )
                // Caption as overview if different from title
                if (episode.caption.isNotBlank() && episode.caption != title) {
                    Spacer(Modifier.height(3.dp))
                    Text(
                        episode.caption,
                        fontSize = 12.sp,
                        color = TextFaint,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 17.sp,
                    )
                }
            }
        }
    }
}

// ── Helpers ────────────────────────────────────────────────────────────────

private fun parseEpisodeNumber(filename: String, fallback: Int): String {
    // Try "S01E02" pattern
    val se = Regex("""[Ss](\d+)[Ee](\d+)""").find(filename)
    if (se != null) {
        val s = se.groupValues[1].toInt()
        val e = se.groupValues[2].toInt()
        return "TEMPORADA $s · EPISODIO $e"
    }
    // Try "1x02" pattern
    val xe = Regex("""(\d+)[xX](\d+)""").find(filename)
    if (xe != null) {
        val s = xe.groupValues[1].toInt()
        val e = xe.groupValues[2].toInt()
        return "T$s · EP $e"
    }
    return "EPISODIO $fallback"
}

private fun parseEpisodeTitle(filename: String, caption: String): String {
    if (caption.isNotBlank()) return caption
    // Remove extension and episode code
    return filename
        .replace(Regex("""\.[a-zA-Z0-9]{2,4}$"""), "")
        .replace(Regex("""[Ss]\d+[Ee]\d+"""), "")
        .replace(Regex("""\d+[xX]\d+"""), "")
        .replace(Regex("""\b(720p|1080p|2160p|4K|HDR|BluRay|WEB-?DL|x264|x265|HEVC)\b""", RegexOption.IGNORE_CASE), "")
        .replace(".", " ")
        .replace("-", " ")
        .replace("_", " ")
        .trim()
        .replace(Regex("""\s{2,}"""), " ")
        .ifBlank { filename }
}

private fun formatFileSize(bytes: Long): String = when {
    bytes == 0L    -> ""
    bytes < 1024L  -> "$bytes B"
    bytes < 1024L * 1024 -> "${"%.0f".format(bytes / 1024.0)} KB"
    bytes < 1024L * 1024 * 1024 -> "${"%.1f".format(bytes / (1024.0 * 1024))} MB"
    else -> "${"%.2f".format(bytes / (1024.0 * 1024 * 1024))} GB"
}
