package com.cineflix.android.ui.player.cast

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.pm.ServiceInfo
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.cineflix.android.R

/**
 * Android `ForegroundService` (`foregroundServiceType="mediaPlayback"`) keeping Cineflix's
 * `LocalStreamServer`, `LiveTranscodeManager` (on-phone hardware/FFmpeg chunk decoding),
 * TDLib chunk downloads, and UPnP/DLNA or Google Cast control session alive at foreground
 * priority while the user uses other apps, turns off the screen, or browses the catalog.
 */
class CastPlaybackService : Service(), CastSessionCoordinator.StateObserver {

    companion object {
        private const val TAG = "CastPlaybackService"
        private const val CHANNEL_ID = "cineflix_cast_playback"
        private const val NOTIFICATION_ID = 42077

        const val ACTION_START_OR_UPDATE = "com.cineflix.android.cast.ACTION_START_OR_UPDATE"
        const val ACTION_TOGGLE_PLAY_PAUSE = "com.cineflix.android.cast.ACTION_TOGGLE_PLAY_PAUSE"
        const val ACTION_STOP_CAST = "com.cineflix.android.cast.ACTION_STOP_CAST"

        @Volatile
        private var isServiceRunning = false

        fun startOrUpdate(context: Context) {
            try {
                val appCtx = context.applicationContext
                val intent = Intent(appCtx, CastPlaybackService::class.java).apply {
                    action = ACTION_START_OR_UPDATE
                }
                ContextCompat.startForegroundService(appCtx, intent)
            } catch (e: Throwable) {
                Log.w(TAG, "Unable to start CastPlaybackService: ${e.message}")
            }
        }

        fun stop(context: Context) {
            try {
                val appCtx = context.applicationContext
                appCtx.stopService(Intent(appCtx, CastPlaybackService::class.java))
            } catch (e: Throwable) {
                Log.w(TAG, "Unable to stop CastPlaybackService: ${e.message}")
            }
        }
    }

    private var lastRenderedNotificationKey: String = ""

    override fun onCreate() {
        super.onCreate()
        isServiceRunning = true
        ensureNotificationChannel()
        promoteToForeground(CastSessionCoordinator.getSnapshot())
        CastSessionCoordinator.addStateObserver(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ensureNotificationChannel()
        when (intent?.action) {
            ACTION_TOGGLE_PLAY_PAUSE -> {
                promoteToForeground(CastSessionCoordinator.getSnapshot())
                CastSessionCoordinator.togglePlayPause(this)
            }
            ACTION_STOP_CAST -> {
                promoteToForeground(CastSessionCoordinator.getSnapshot())
                CastSessionCoordinator.stopCastingCompletely(this)
                stopForegroundCompat()
                stopSelf()
                return START_NOT_STICKY
            }
            else -> {
                val snap = CastSessionCoordinator.getSnapshot()
                promoteToForeground(snap)
                if (!snap.isActive) {
                    stopForegroundCompat()
                    stopSelf()
                    return START_NOT_STICKY
                }
            }
        }
        return START_STICKY
    }

    override fun onCastStateChanged(snapshot: CastSessionCoordinator.CastUiSnapshot) {
        if (!isServiceRunning) return
        if (!snapshot.isActive) {
            stopForegroundCompat()
            stopSelf()
            return
        }
        val posSec = snapshot.positionMs / 1000L
        val durSec = snapshot.durationMs / 1000L
        val stateKey = "${snapshot.tvName}|${snapshot.movieTitle}|${snapshot.isConnecting}|${snapshot.isPlaying}|${snapshot.isLiveTranscode}|$posSec|$durSec"
        if (stateKey == lastRenderedNotificationKey) return
        lastRenderedNotificationKey = stateKey

        try {
            val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager
            nm?.notify(NOTIFICATION_ID, buildNotification(snapshot))
        } catch (e: Throwable) {
            Log.w(TAG, "Notification update warning: ${e.message}")
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        isServiceRunning = false
        CastSessionCoordinator.removeStateObserver(this)
        super.onDestroy()
    }

    private fun promoteToForeground(snapshot: CastSessionCoordinator.CastUiSnapshot) {
        val notification = buildNotification(snapshot)
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startForeground(
                    NOTIFICATION_ID,
                    notification,
                    ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK
                )
            } else {
                startForeground(NOTIFICATION_ID, notification)
            }
        } catch (e: Throwable) {
            Log.w(TAG, "startForeground fallback: ${e.message}")
            try {
                startForeground(NOTIFICATION_ID, notification)
            } catch (_: Throwable) {}
        }
    }

    private fun stopForegroundCompat() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                stopForeground(STOP_FOREGROUND_REMOVE)
            } else {
                @Suppress("DEPRECATION")
                stopForeground(true)
            }
        } catch (_: Throwable) {}
    }

    private fun ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return
        val nm = getSystemService(Context.NOTIFICATION_SERVICE) as? NotificationManager ?: return
        if (nm.getNotificationChannel(CHANNEL_ID) != null) return

        val channel = NotificationChannel(
            CHANNEL_ID,
            "Reproducción en TV (Cineflix)",
            NotificationManager.IMPORTANCE_LOW
        ).apply {
            description = "Mantiene la película reproduciéndose en la TV mientras usas otras apps o ves el catálogo"
            setShowBadge(false)
            enableVibration(false)
            setSound(null, null)
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        }
        nm.createNotificationChannel(channel)
    }

    private fun buildNotification(snapshot: CastSessionCoordinator.CastUiSnapshot): Notification {
        val pendingFlags = PendingIntent.FLAG_UPDATE_CURRENT or
            (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0)

        val openPlayerIntent = CastSessionCoordinator.buildReopenPlayerIntent(this)
        val contentPendingIntent = PendingIntent.getActivity(
            this,
            101,
            openPlayerIntent,
            pendingFlags
        )

        val toggleIntent = Intent(this, CastPlaybackService::class.java).apply {
            action = ACTION_TOGGLE_PLAY_PAUSE
        }
        val togglePendingIntent = PendingIntent.getService(
            this,
            102,
            toggleIntent,
            pendingFlags
        )

        val stopIntent = Intent(this, CastPlaybackService::class.java).apply {
            action = ACTION_STOP_CAST
        }
        val stopPendingIntent = PendingIntent.getService(
            this,
            103,
            stopIntent,
            pendingFlags
        )

        val tvLabel = snapshot.tvName.ifBlank { "Smart TV" }
        val notifTitle = if (snapshot.isConnecting) {
            "📺 Conectando con $tvLabel..."
        } else {
            "📺 Emitiendo en $tvLabel"
        }

        val timeLabel = if (snapshot.durationMs > 0L) {
            "${CastSessionCoordinator.formatDurationClock(snapshot.positionMs)} / ${CastSessionCoordinator.formatDurationClock(snapshot.durationMs)}"
        } else if (snapshot.positionMs > 0L) {
            CastSessionCoordinator.formatDurationClock(snapshot.positionMs)
        } else {
            ""
        }

        val statePrefix = when {
            snapshot.isConnecting -> "Preparando emisión"
            snapshot.isPlaying -> snapshot.movieTitle
            else -> "En pausa • ${snapshot.movieTitle}"
        }
        val notifBody = if (timeLabel.isNotEmpty()) {
            "$statePrefix • $timeLabel"
        } else {
            statePrefix
        }

        val playPauseIcon = if (snapshot.isPlaying) {
            android.R.drawable.ic_media_pause
        } else {
            android.R.drawable.ic_media_play
        }
        val playPauseText = if (snapshot.isPlaying) "Pausar" else "Reanudar"

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_cast_tv_connected)
            .setColor(Color.parseColor("#7C3AED"))
            .setContentTitle(notifTitle)
            .setContentText(notifBody)
            .setSubText(if (snapshot.isLiveTranscode) "Decodificando en el móvil" else "Cineflix TV")
            .setContentIntent(contentPendingIntent)
            .setOngoing(true)
            .setOnlyAlertOnce(true)
            .setSilent(true)
            .setShowWhen(false)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setCategory(NotificationCompat.CATEGORY_TRANSPORT)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .addAction(playPauseIcon, playPauseText, togglePendingIntent)
            .addAction(android.R.drawable.ic_menu_manage, "Mando", contentPendingIntent)
            .addAction(android.R.drawable.ic_menu_close_clear_cancel, "Detener", stopPendingIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            builder.setForegroundServiceBehavior(NotificationCompat.FOREGROUND_SERVICE_IMMEDIATE)
        }

        return builder.build()
    }
}
