package com.cineflix.android.ui.player

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
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
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.theme.NetflixRed
import com.cineflix.android.ui.theme.CineflixTheme
import kotlinx.coroutines.*

/**
 * Streaming player using a custom TdLibDataSource.
 *
 * Approach (same as Telegram-FOSS / Nekogram / TVGram):
 *  1. TDLib downloads the video file progressively to local storage
 *  2. TdLibDataSource reads from the local file using RandomAccessFile
 *  3. ExoPlayer reads via TdLibDataSource — starts playing immediately
 *  4. On seek: DataSource waits for bytes + hints TDLib to prioritise offset
 *
 * No HTTP proxy. No NanoHTTPD. No cleartext HTTP issues.
 */
class PlayerActivity : ComponentActivity() {

    companion object {
        internal const val EXTRA_FILE_ID   = "file_id"
        internal const val EXTRA_FILE_SIZE = "file_size"
        internal const val EXTRA_MIME_TYPE = "mime_type"
        internal const val EXTRA_TITLE     = "title"
        internal const val EXTRA_SUBTITLE  = "subtitle"
        internal const val EXTRA_CHAT_ID   = "chat_id"
        internal const val EXTRA_MSG_ID    = "msg_id"

        fun start(
            context: Context,
            fileId: Int,
            chatId: Long,
            msgId: Long,
            fileSize: Long  = 0L,
            mimeType: String = "video/mp4",
            title: String,
            subtitle: String = "",
        ) {
            context.startActivity(Intent(context, PlayerActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                putExtra(EXTRA_FILE_ID,   fileId)
                putExtra(EXTRA_CHAT_ID,   chatId)
                putExtra(EXTRA_MSG_ID,    msgId)
                putExtra(EXTRA_FILE_SIZE, fileSize)
                putExtra(EXTRA_MIME_TYPE, mimeType)
                putExtra(EXTRA_TITLE,     title)
                putExtra(EXTRA_SUBTITLE,  subtitle)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val fileId   = intent.getIntExtra(EXTRA_FILE_ID, -1)
        val chatId   = intent.getLongExtra(EXTRA_CHAT_ID, 0L)
        val msgId    = intent.getLongExtra(EXTRA_MSG_ID, 0L)
        val fileSize = intent.getLongExtra(EXTRA_FILE_SIZE, 0L)
        val mimeType = intent.getStringExtra(EXTRA_MIME_TYPE) ?: "video/mp4"
        val title    = intent.getStringExtra(EXTRA_TITLE)    ?: ""
        val subtitle = intent.getStringExtra(EXTRA_SUBTITLE) ?: ""
        val engine   = TelegramEngine.getInstance(this)

        setContent {
            CineflixTheme {
                PlayerScreen(
                    engine   = engine,
                    fileId   = fileId,
                    chatId   = chatId,
                    msgId    = msgId,
                    fileSize = fileSize,
                    mimeType = mimeType,
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
    fileSize: Long,
    mimeType: String,
    title: String,
    subtitle: String,
    onBack: () -> Unit,
) {
    val context = LocalContext.current

    var preparing    by remember { mutableStateOf(true) }
    var errorMsg     by remember { mutableStateOf<String?>(null) }
    var showControls by remember { mutableStateOf(true) }
    var isPlaying    by remember { mutableStateOf(false) }
    var buffering    by remember { mutableStateOf(false) }
    var playerReady  by remember { mutableStateOf(false) }

    // ExoPlayer with TdLibDataSource — starts immediately, no download wait
    val exoPlayer = remember {
        val dataSourceFactory = TdLibDataSource.Factory(
            engine    = engine,
            fileId    = fileId,
            totalSize = fileSize,
        )

        val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(MediaItem.fromUri(Uri.parse("tdlib://file/$fileId")))

        ExoPlayer.Builder(context).build().apply {
            playWhenReady = true
            addListener(object : Player.Listener {
                override fun onPlaybackStateChanged(state: Int) {
                    buffering = state == Player.STATE_BUFFERING
                    if (state == Player.STATE_READY) {
                        preparing = false
                        playerReady = true
                    }
                    if (state == Player.STATE_ENDED) {
                        // Auto-back when video ends
                    }
                }
                override fun onIsPlayingChanged(playing: Boolean) {
                    isPlaying = playing
                    if (playing) preparing = false
                }
                override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                    errorMsg = "Error de reproducción: ${error.message}"
                    preparing = false
                }
            })
            setMediaSource(mediaSource)
            prepare()
        }
    }

    // Auto-hide controls
    LaunchedEffect(showControls) {
        if (showControls) {
            delay(4000)
            showControls = false
        }
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    // ── UI ───────────────────────────────────────────────────────────────────
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { showControls = !showControls },
                    onDoubleTap = { offset ->
                        val w      = size.width
                        val seekMs = if (offset.x < w / 2) -10_000L else 10_000L
                        exoPlayer.seekTo(
                            (exoPlayer.currentPosition + seekMs).coerceAtLeast(0)
                        )
                    }
                )
            }
    ) {
        // Video surface — always present
        AndroidView(
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player        = exoPlayer
                    useController = false
                }
            },
            modifier = Modifier.fillMaxSize(),
        )

        // Preparing / buffering
        if (preparing || buffering) {
            Column(
                Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator(color = NetflixRed, modifier = Modifier.size(56.dp))
                Spacer(Modifier.height(16.dp))
                Text(
                    if (preparing) "Conectando con Telegram…" else "Bufferizando…",
                    color = Color.White, fontSize = 14.sp,
                )
            }
        }

        // Error
        errorMsg?.let { err ->
            Column(
                Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(Icons.Default.Warning, null, tint = NetflixRed, modifier = Modifier.size(48.dp))
                Spacer(Modifier.height(8.dp))
                Text(err, color = Color.White, fontSize = 14.sp)
                Spacer(Modifier.height(16.dp))
                Button(onClick = onBack, colors = ButtonDefaults.buttonColors(containerColor = NetflixRed)) {
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
                title     = title,
                subtitle  = subtitle,
                isPlaying = isPlaying,
                exoPlayer = exoPlayer,
                onBack    = onBack,
            )
        }
    }
}

// ── Controls ──────────────────────────────────────────────────────────────────

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
                Icon(Icons.Default.ArrowBack, "Volver", tint = Color.White)
            }
            Spacer(Modifier.width(8.dp))
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                if (subtitle.isNotEmpty())
                    Text(subtitle, color = Color(0xFFCCCCCC), fontSize = 12.sp)
            }
        }

        // Center controls
        Row(
            Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { exoPlayer.seekTo((exoPlayer.currentPosition - 10_000).coerceAtLeast(0)) },
                modifier = Modifier.size(52.dp),
            ) {
                Icon(Icons.Default.Replay10, "-10s", tint = Color.White, modifier = Modifier.size(36.dp))
            }
            IconButton(
                onClick = { if (isPlaying) exoPlayer.pause() else exoPlayer.play() },
                modifier = Modifier.size(64.dp),
            ) {
                Icon(
                    if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    if (isPlaying) "Pausar" else "Reproducir",
                    tint = Color.White, modifier = Modifier.size(48.dp),
                )
            }
            IconButton(
                onClick = { exoPlayer.seekTo(exoPlayer.currentPosition + 10_000) },
                modifier = Modifier.size(52.dp),
            ) {
                Icon(Icons.Default.Forward10, "+10s", tint = Color.White, modifier = Modifier.size(36.dp))
            }
        }

        // Progress bar
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
                    thumbColor        = NetflixRed,
                    activeTrackColor  = NetflixRed,
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
    val s = ms / 1000; return "%d:%02d".format(s / 60, s % 60)
}
