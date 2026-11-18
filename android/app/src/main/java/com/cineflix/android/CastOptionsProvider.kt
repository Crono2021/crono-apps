package com.cineflix.android

import android.content.Context
import com.google.android.gms.cast.CastMediaControlIntent
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider
import com.google.android.gms.cast.framework.media.CastMediaOptions

/**
 * Required by the Google Cast SDK.
 * Uses the DEFAULT_MEDIA_RECEIVER — Google's free built-in video player
 * on Chromecast. No app registration needed.
 *
 * NOTE: We explicitly disable the Cast SDK's built-in ReconnectionService and MediaNotificationService
 * because Cineflix manages its own foreground service (`CastPlaybackService`) with `mediaPlayback`
 * foreground service type. Leaving the Cast SDK's internal services enabled can trigger
 * `ForegroundServiceStartNotAllowedException` / `MissingForegroundServiceTypeException` on Android 12–15.
 */
class CastOptionsProvider : OptionsProvider {
    override fun getCastOptions(context: Context): CastOptions {
        val mediaOptions = CastMediaOptions.Builder()
            .setNotificationOptions(null)
            .setMediaSessionEnabled(false)
            .build()
        return CastOptions.Builder()
            .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
            .setEnableReconnectionService(false)
            .setCastMediaOptions(mediaOptions)
            .build()
    }

    override fun getAdditionalSessionProviders(context: Context): List<SessionProvider>? = null
}
