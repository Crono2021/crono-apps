package com.cineflix.android.ui.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.theme.Background
import com.cineflix.android.ui.theme.CineflixRed
import com.cineflix.android.ui.theme.CineflixTheme
import kotlinx.coroutines.*
import java.io.File

/**
 * TVGram-style player:
 *  1. TelegramEngine.downloadAndGetPath(fileId) → waits for file.local.path from TDLib
 *  2. ExoPlayer.setMediaItem(Uri.fromFile(File(localPath))) — reads file:// directly
 *
 * No HTTP proxy. No NanoHTTPD. No race conditions.
 */
class PlayerActivity : ComponentActivity() {

    companion object {
        private const val EXTRA_FILE_ID   = "file_id"
        private const val EXTRA_TITLE     = "title"
        private const val EXTRA_SUBTITLE  = "subtitle"
        private const val EXTRA_CHAT_ID   = "chat_id"
        private const val EXTRA_MSG_ID    = "msg_id"

        fun start(
            context: Context,
            fileId: Int,
            chatId: Long,
            msgId: Long,
            title: String,
            subtitle: String = "",
        ) {
            context.startActivity(Intent(context, PlayerActivity::class.java).apply {
                putExtra(EXTRA_FILE_ID,  fileId)
                putExtra(EXTRA_CHAT_ID,  chatId)
                putExtra(EXTRA_MSG_ID,   msgId)
                putExtra(EXTRA_TITLE,    title)
                putExtra(EXTRA_SUBTITLE, subtitle)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Force landscape + fullscreen
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        val chatId   = intent.getLongExtra(EXTRA_CHAT_ID, 0L)
        val msgId    = intent.getLongExtra(EXTRA_MSG_ID, 0L)
        val title    = intent.getStringExtra(EXTRA_TITLE) ?: ""
        val subtitle = intent.getStringExtra(EXTRA_SUBTITLE) ?: ""
        val engine   = TelegramEngine.getInstance(this)

        setContent {
            CineflixTheme {
                PlayerScreen(
                    engine   = engine,
                    fileId   = fileId,
                    chatId   = chatId,
                    msgId    = msgId,
                    title    = title,
                    subtitle = subtitle,
                    onBack   = { finish() },
                )
            }
        }
    }
}

@OptIn(UnstableApi::class)
@Composable
private fun PlayerScreen(
    engine: TelegramEngine,
    fileId: Int,
    chatId: Long,
    msgId: Long,
    title: String,
    subtitle: String,
    onBack: () -> Unit,
) {
    val context = LocalContext.current
    val scope   = rememberCoroutineScope()

    var localPath   by remember { mutableStateOf<String?>(null) }
    var errorMsg    by remember { mutableStateOf<String?>(null) }
    var preparing   by remember { mutableStateOf(true) }
    var showControls by remember { mutableStateOf(true) }
    var isPlaying   by remember { mutableStateOf(false) }
    var buffering   by remember { mutableStateOf(false) }

    // ExoPlayer instance
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            playWhenReady = true
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    buffering = state == Player.STATE_BUFFERING
                    isPlaying = playWhenReady && state == Player.STATE_READY
                }
                override fun onIsPlayingChanged(playing: Boolean) { isPlaying = playing }
            })
        }
    }

    // Load file via TVGram approach
    LaunchedEffect(fileId) {
        try {
            preparing = true
            // If there's a cached path from the pre-warm, we get it immediately
            val path = engine.downloadAndGetPath(fileId, priority = 32)
            localPath = path
            preparing = false
            // Tell TDLib we're reading from the beginning with high priority
            exoPlayer.setMediaItem(MediaItem.fromUri(
                android.net.Uri.fromFile(File(path))
            ))
            exoPlayer.prepare()
        } catch (e: Exception) {
            errorMsg  = "Error al iniciar la reproducción: ${e.message}"
            preparing = false
        }
    }

    // Auto-hide controls
    LaunchedEffect(showControls) {
        if (showControls) {
            delay(3500)
            showControls = false
        }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { showControls = !showControls },
                    onDoubleTap = { offset ->
                        // Double-tap left/right to seek ±10s
                        val w = size.width
                        val seekMs = if (offset.x < w / 2) -10_000L else 10_000L
                        exoPlayer.seekTo(
                            (exoPlayer.currentPosition + seekMs).coerceAtLeast(0)
                        )
                        // Hint TDLib on seek forward
                        if (seekMs > 0) {
                            val newPosBytes = (exoPlayer.currentPosition / 1000.0 *
                                    (exoPlayer.contentDuration.coerceAtLeast(1)) *
                                    exoPlayer.duration.coerceAtLeast(1) / 1000).toLong()
                            engine.hintDownloadOffset(fileId, newPosBytes.coerceAtLeast(0))
                        }
                    }
                )
            }
    ) {
        // Video surface
        if (!localPath.isNullOrEmpty()) {
            AndroidView(
                factory = { ctx ->
                    PlayerView(ctx).apply {
                        player = exoPlayer
                        useController = false  // We draw our own controls
                    }
                },
                modifier = Modifier.fillMaxSize(),
            )
        }

        // Preparing spinner
        if (preparing) {
            Column(
                Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator(color = CineflixRed, modifier = Modifier.size(56.dp))
                Spacer(Modifier.height(16.dp))
                Text("Iniciando reproducción...", color = Color.White, fontSize = 14.sp)
                Text("TDLib descargando...", color = Color(0xFF999999), fontSize = 12.sp)
            }
        }

        // Buffering (after file ready but ExoPlayer is buffering)
        if (!preparing && buffering) {
            CircularProgressIndicator(
                color = CineflixRed,
                modifier = Modifier.align(Alignment.Center).size(48.dp),
            )
        }

        // Error
        errorMsg?.let { err ->
            Column(
                Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(Icons.Default.Warning, contentDescription = null, tint = CineflixRed, modifier = Modifier.size(48.dp))
                Spacer(Modifier.height(8.dp))
                Text(err, color = Color.White, fontSize = 14.sp)
                Spacer(Modifier.height(16.dp))
                Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = CineflixRed)) {
                    Text("Volver")
                }
            }
        }

        // Controls overlay
        AnimatedVisibility(
            visible = showControls && !preparing && errorMsg == null,
            enter   = fadeIn(),
            exit    = fadeOut(),
        ) {
            PlayerControls(
                title      = title,
                subtitle   = subtitle,
                isPlaying  = isPlaying,
                exoPlayer  = exoPlayer,
                onBack     = onBack,
            )
        }
    }
}

@Composable
private fun PlayerControls(
    title: String,
    subtitle: String,
    isPlaying: Boolean,
    exoPlayer: ExoPlayer,
    onBack: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0x88000000))
    ) {
        // Top bar
        Row(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = onBack) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Volver", tint = Color.White)
            }
            Spacer(Modifier.width(8.dp))
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                if (subtitle.isNotEmpty()) {
                    Text(subtitle, color = Color(0xFFCCCCCC), fontSize = 12.sp)
                }
            }
        }

        // Center play/pause
        Row(
            Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { exoPlayer.seekTo((exoPlayer.currentPosition - 10_000).coerceAtLeast(0)) },
                modifier = Modifier.size(52.dp),
            ) {
                Icon(Icons.Default.Replay10, contentDescription = "-10s", tint = Color.White, modifier = Modifier.size(36.dp))
            }
            IconButton(
                onClick = { if (isPlaying) exoPlayer.pause() else exoPlayer.play() },
                modifier = Modifier.size(64.dp),
            ) {
                Icon(
                    if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pausar" else "Reproducir",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp),
                )
            }
            IconButton(
                onClick = { exoPlayer.seekTo(exoPlayer.currentPosition + 10_000) },
                modifier = Modifier.size(52.dp),
            ) {
                Icon(Icons.Default.Forward10, contentDescription = "+10s", tint = Color.White, modifier = Modifier.size(36.dp))
            }
        }

        // Bottom progress bar
        var position by remember { mutableStateOf(0L) }
        var duration by remember { mutableStateOf(0L) }
        LaunchedEffect(isPlaying) {
            while (true) {
                position = exoPlayer.currentPosition
                duration = exoPlayer.contentDuration.coerceAtLeast(0)
                delay(500)
            }
        }

        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Slider(
                value = if (duration > 0) position.toFloat() / duration else 0f,
                onValueChange = { v -> exoPlayer.seekTo((v * duration).toLong()) },
                colors = SliderDefaults.colors(
                    thumbColor = CineflixRed,
                    activeTrackColor = CineflixRed,
                    inactiveTrackColor = Color(0xFF555555),
                ),
            )
            Row(Modifier.fillMaxWidth()) {
                Text(formatMs(position), color = Color.White, fontSize = 12.sp)
                Spacer(Modifier.weight(1f))
                Text(formatMs(duration), color = Color(0xFFAAAAAA), fontSize = 12.sp)
            }
        }
    }
}

private fun formatMs(ms: Long): String {
    val totalSec = ms / 1000
    val m = totalSec / 60
    val s = totalSec % 60
    return "%d:%02d".format(m, s)
}
