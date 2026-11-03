package com.cineflix.android.ui.player.cast

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.mediarouter.media.MediaRouteSelector
import androidx.mediarouter.media.MediaRouter
import com.google.android.gms.cast.CastDevice
import com.google.android.gms.cast.CastMediaControlIntent
import com.google.android.gms.cast.framework.CastContext
import java.util.concurrent.CopyOnWriteArrayList

/**
 * Unifies Google Cast (Chromecast, Google TV, Android TV) AND native UPnP/DLNA Smart TVs
 * (Samsung Tizen, LG webOS, Hisense VIDAA, Sony Bravia, Philips, Roku) into one single
 * live-updating TV list for instant 1-tap selection.
 */
class UnifiedTvDiscoveryManager(context: Context) {

    companion object {
        private const val TAG = "UnifiedTvDiscovery"
    }

    interface Listener {
        fun onTvListChanged(devices: List<UnifiedTvDevice>, isScanning: Boolean)
    }

    private val appContext = context.applicationContext
    private val mainHandler = Handler(Looper.getMainLooper())
    private val listeners = CopyOnWriteArrayList<Listener>()

    private var mediaRouter: MediaRouter? = null
    private var routeSelector: MediaRouteSelector? = null
    private var mediaRouterCallbackRegistered = false

    private val dlnaDiscovery = DlnaDiscoveryManager(appContext)
    @Volatile private var latestDlnaDevices: List<DlnaDevice> = emptyList()
    @Volatile private var isDlnaScanning: Boolean = false

    private val mediaRouterCallback = object : MediaRouter.Callback() {
        override fun onRouteAdded(router: MediaRouter, route: MediaRouter.RouteInfo) = emitCombined()
        override fun onRouteChanged(router: MediaRouter, route: MediaRouter.RouteInfo) = emitCombined()
        override fun onRouteRemoved(router: MediaRouter, route: MediaRouter.RouteInfo) = emitCombined()
        override fun onRouteSelected(router: MediaRouter, route: MediaRouter.RouteInfo, reason: Int) = emitCombined()
        override fun onRouteUnselected(router: MediaRouter, route: MediaRouter.RouteInfo, reason: Int) = emitCombined()
    }

    private val dlnaListener = object : DlnaDiscoveryManager.Listener {
        override fun onDevicesChanged(devices: List<DlnaDevice>, isScanning: Boolean) {
            latestDlnaDevices = devices
            isDlnaScanning = isScanning
            emitCombined()
        }
    }

    init {
        dlnaDiscovery.addListener(dlnaListener)
        mainHandler.post {
            initMediaRouterOnMain()
        }
    }

    private fun initMediaRouterOnMain() {
        try {
            mediaRouter = MediaRouter.getInstance(appContext)
            val castSelector = try {
                CastContext.getSharedInstance(appContext).mergedSelector
            } catch (_: Throwable) {
                null
            }
            routeSelector = castSelector ?: MediaRouteSelector.Builder()
                .addControlCategory(
                    CastMediaControlIntent.categoryForCast(
                        CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID
                    )
                )
                .build()
        } catch (e: Throwable) {
            Log.w(TAG, "MediaRouter init warning (non-GMS device ok — DLNA still active): ${e.message}")
        }
    }

    fun addListener(listener: Listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
        mainHandler.post {
            listener.onTvListChanged(buildCombinedListOnMain(), isDlnaScanning)
        }
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    /**
     * Starts active Wi-Fi discovery across BOTH Google Cast (MediaRouter active scan) and DLNA (SSDP).
     */
    fun startActiveDiscovery(forceRefresh: Boolean = false) {
        mainHandler.post {
            if (mediaRouter == null) {
                initMediaRouterOnMain()
            }
            val router = mediaRouter
            val selector = routeSelector
            if (router != null && selector != null && !mediaRouterCallbackRegistered) {
                try {
                    router.addCallback(
                        selector,
                        mediaRouterCallback,
                        MediaRouter.CALLBACK_FLAG_PERFORM_ACTIVE_SCAN or
                            MediaRouter.CALLBACK_FLAG_REQUEST_DISCOVERY
                    )
                    mediaRouterCallbackRegistered = true
                } catch (e: Throwable) {
                    Log.w(TAG, "MediaRouter callback warning: ${e.message}")
                }
            }
            emitCombined()
        }
        dlnaDiscovery.startScan(clearCache = forceRefresh)
    }

    fun stopActiveDiscovery() {
        mainHandler.post {
            if (mediaRouterCallbackRegistered) {
                try {
                    mediaRouter?.removeCallback(mediaRouterCallback)
                } catch (_: Throwable) {}
                mediaRouterCallbackRegistered = false
            }
        }
    }

    fun destroy() {
        stopActiveDiscovery()
        dlnaDiscovery.removeListener(dlnaListener)
        dlnaDiscovery.destroy()
        listeners.clear()
    }

    private fun emitCombined() {
        mainHandler.post {
            val combined = buildCombinedListOnMain()
            val scanning = isDlnaScanning
            for (l in listeners) {
                l.onTvListChanged(combined, scanning)
            }
        }
    }

    private fun buildCombinedListOnMain(): List<UnifiedTvDevice> {
        val result = mutableListOf<UnifiedTvDevice>()

        // 1. Google Cast devices (Chromecast / Google TV / Android TV)
        val router = mediaRouter
        val selector = routeSelector
        if (router != null && selector != null) {
            try {
                for (route in router.routes) {
                    if (route.isDefault || route.isBluetooth) continue
                    if (!route.isEnabled) continue
                    if (!route.matchesSelector(selector)) continue

                    val castDevice = try {
                        route.extras?.let { CastDevice.getFromBundle(it) }
                    } catch (_: Throwable) {
                        null
                    }
                    val hostIp = try {
                        castDevice?.inetAddress?.hostAddress
                    } catch (_: Throwable) {
                        null
                    }
                    val modelSubtitle = castDevice?.modelName?.trim()?.takeIf { it.isNotEmpty() }
                    val badge = if (modelSubtitle != null) {
                        "$modelSubtitle • Google Cast"
                    } else {
                        "Chromecast / Android TV"
                    }

                    result.add(
                        UnifiedTvDevice.GoogleCastTv(
                            id = "cast:${route.id}",
                            name = route.name.ifBlank { "Google Cast TV" },
                            badge = badge,
                            hostIp = hostIp,
                            route = route
                        )
                    )
                }
            } catch (e: Throwable) {
                Log.d(TAG, "Route enumeration note: ${e.message}")
            }
        }

        // 2. Native DLNA / UPnP Smart TVs (Samsung Tizen, LG webOS, Sony, Hisense, Philips, Roku)
        for (dlna in latestDlnaDevices) {
            result.add(
                UnifiedTvDevice.DlnaSmartTv(
                    id = "dlna:${dlna.udn}",
                    name = dlna.friendlyName,
                    badge = dlna.brandBadge,
                    hostIp = dlna.host.ifBlank { null },
                    device = dlna
                )
            )
        }

        return result.sortedWith(
            compareBy<UnifiedTvDevice> { it.name.lowercase() }
                .thenBy { if (it is UnifiedTvDevice.GoogleCastTv) 0 else 1 }
        )
    }
}
