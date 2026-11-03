package com.cineflix.android.ui.player.cast

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * High-reliability UPnP / DLNA MediaRenderer scanner for Android.
 *
 * Combines:
 *  1. Standard UDP multicast M-SEARCH to 239.255.255.250:1900 (with WifiManager.MulticastLock
 *     and explicit Wi-Fi interface socket binding so cellular data never hijacks UDP routing).
 *  2. Local /24 broadcast + lightweight unicast UDP M-SEARCH sweep on port 1900 so dual-band
 *     routers (2.4 GHz TV <-> 5 GHz phone) that filter multicast IGMP still discover 100% of TVs.
 *  3. Subnet-scoped process-wide warm cache so opening multiple movies consecutively shows
 *     previously discovered Smart TVs in 0 ms while refreshing in the background.
 */
class DlnaDiscoveryManager(private val context: Context) {

    companion object {
        private const val TAG = "DlnaDiscovery"
        private const val SSDP_ADDR = "239.255.255.250"
        private const val SSDP_PORT = 1900
        private const val SCAN_WINDOW_MS = 3600L

        private val SEARCH_TARGETS = listOf(
            "urn:schemas-upnp-org:device:MediaRenderer:1",
            "urn:schemas-upnp-org:device:MediaRenderer:2",
            "urn:schemas-upnp-org:service:AVTransport:1",
            "upnp:rootdevice",
            "ssdp:all"
        )

        @Volatile private var cachedSubnetPrefix: String? = null
        private val warmDevicesCache = ConcurrentHashMap<String, DlnaDevice>()
    }

    interface Listener {
        fun onDevicesChanged(devices: List<DlnaDevice>, isScanning: Boolean)
    }

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val mainHandler = Handler(Looper.getMainLooper())
    private val listeners = CopyOnWriteArrayList<Listener>()

    // Deduplicated by UDN and normalized AVTransport control URL
    private val devicesByUdn = ConcurrentHashMap<String, DlnaDevice>()
    private val seenControlUrls = ConcurrentHashMap<String, String>()
    private val inspectedLocations = ConcurrentHashMap.newKeySet<String>()
    private val fetchSemaphore = Semaphore(8)

    private val isScanning = AtomicBoolean(false)
    private var activeScanJob: Job? = null

    private val httpClient = OkHttpClient.Builder()
        .connectTimeout(2500, TimeUnit.MILLISECONDS)
        .readTimeout(3500, TimeUnit.MILLISECONDS)
        .followRedirects(true)
        .build()

    init {
        val currentSubnet = LanNetworkUtils.getBestLanIpv4(context)?.let { LanNetworkUtils.getSlash24Prefix(it) }
        if (currentSubnet != null && currentSubnet == cachedSubnetPrefix) {
            for ((keyUdn, dev) in warmDevicesCache) {
                devicesByUdn[keyUdn] = dev
                seenControlUrls[dev.avTransportControlUrl.lowercase()] = keyUdn
            }
        } else if (currentSubnet != null) {
            warmDevicesCache.clear()
            cachedSubnetPrefix = currentSubnet
        }
    }

    fun addListener(listener: Listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
        listener.onDevicesChanged(getDevicesSnapshot(), isScanning.get())
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    fun getDevicesSnapshot(): List<DlnaDevice> {
        return devicesByUdn.values.sortedBy { it.friendlyName.lowercase() }
    }

    /**
     * Triggers an immediate SSDP scan burst. If clearCache is true, re-verifies all locations.
     */
    fun startScan(clearCache: Boolean = false) {
        if (clearCache) {
            inspectedLocations.clear()
        }
        if (activeScanJob?.isActive == true) {
            return
        }
        activeScanJob = scope.launch {
            runDiscoveryCycle()
        }
    }

    fun destroy() {
        activeScanJob?.cancel()
        listeners.clear()
        scope.cancel()
    }

    private suspend fun runDiscoveryCycle() {
        isScanning.set(true)
        notifyListenersOnMain()

        val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
        val multicastLock = try {
            wifiManager?.createMulticastLock("cineflix_dlna_ssdp")?.apply {
                setReferenceCounted(false)
                acquire()
            }
        } catch (e: Throwable) {
            Log.w(TAG, "MulticastLock unavailable: ${e.message}")
            null
        }

        var socket: DatagramSocket? = null
        try {
            val lanIp = LanNetworkUtils.getBestLanIpv4(context)
            val slash24 = lanIp?.let { LanNetworkUtils.getSlash24Prefix(it) }
            if (slash24 != null && slash24 != cachedSubnetPrefix) {
                warmDevicesCache.clear()
                devicesByUdn.clear()
                seenControlUrls.clear()
                cachedSubnetPrefix = slash24
            }
            Log.i(TAG, "🔍 Starting DLNA SSDP discovery on LAN IP: ${lanIp ?: "auto"}")

            socket = createLanBoundUdpSocket(lanIp)
            socket.broadcast = true
            socket.soTimeout = 300

            val activeSocket = socket
            val multicastAddr = InetAddress.getByName(SSDP_ADDR)

            // Sender coroutine: 3 waves (multicast + broadcast + fast /24 unicast port 1900 sweep)
            val senderJob = scope.launch {
                // Wave 1 (0 ms): Multicast + Subnet Broadcast
                sendMulticastAndBroadcastWave(activeSocket, multicastAddr, slash24)

                // Wave 2 (220 ms): Fast /24 unicast UDP M-SEARCH sweep (bypasses 2.4GHz<->5GHz multicast isolation)
                delay(220)
                if (!slash24.isNullOrEmpty() && !activeSocket.isClosed) {
                    sendUnicastSubnetSweep(activeSocket, slash24, lanIp)
                }

                // Wave 3 (900 ms): Second Multicast wave for DTIM-sleeping Smart TVs
                delay(680)
                if (!activeSocket.isClosed) {
                    sendMulticastAndBroadcastWave(activeSocket, multicastAddr, slash24)
                }
            }

            val deadline = System.currentTimeMillis() + SCAN_WINDOW_MS
            val buf = ByteArray(8192)
            while (currentCoroutineContext().isActive && System.currentTimeMillis() < deadline) {
                val packet = DatagramPacket(buf, buf.size)
                try {
                    activeSocket.receive(packet)
                    val text = String(packet.data, packet.offset, packet.length, StandardCharsets.UTF_8)
                    val headers = UpnpXmlParser.parseSsdpHeaders(text)
                    val location = headers["location"]
                    if (!location.isNullOrBlank() &&
                        (location.startsWith("http://", true) || location.startsWith("https://", true))
                    ) {
                        if (inspectedLocations.add(location)) {
                            scope.launch {
                                inspectLocationUrl(location)
                            }
                        }
                    }
                } catch (_: java.net.SocketTimeoutException) {
                    // Normal 300ms poll tick
                } catch (e: Exception) {
                    if (currentCoroutineContext().isActive && !activeSocket.isClosed) {
                        Log.d(TAG, "UDP receive note: ${e.message}")
                    }
                    break
                }
            }

            senderJob.cancel()
        } catch (e: Exception) {
            Log.w(TAG, "DLNA scan cycle error: ${e.message}")
        } finally {
            try { socket?.close() } catch (_: Exception) {}
            try {
                if (multicastLock?.isHeld == true) {
                    multicastLock.release()
                }
            } catch (_: Exception) {}
            isScanning.set(false)
            notifyListenersOnMain()
        }
    }

    private fun createLanBoundUdpSocket(lanIp: String?): DatagramSocket {
        if (!lanIp.isNullOrBlank()) {
            try {
                return DatagramSocket(InetSocketAddress(InetAddress.getByName(lanIp), 0))
            } catch (e: Exception) {
                Log.w(TAG, "Fallback to wildcard DatagramSocket (${e.message})")
            }
        }
        return DatagramSocket()
    }

    private fun buildMSearchPayload(st: String): ByteArray {
        val msg = "M-SEARCH * HTTP/1.1\r\n" +
                  "HOST: $SSDP_ADDR:$SSDP_PORT\r\n" +
                  "MAN: \"ssdp:discover\"\r\n" +
                  "MX: 2\r\n" +
                  "ST: $st\r\n" +
                  "USER-AGENT: Android/14 UPnP/1.1 Cineflix/1.4\r\n\r\n"
        return msg.toByteArray(StandardCharsets.US_ASCII)
    }

    private fun sendMulticastAndBroadcastWave(
        socket: DatagramSocket,
        multicastAddr: InetAddress,
        slash24Prefix: String?
    ) {
        val broadcastAddr = try {
            if (!slash24Prefix.isNullOrEmpty()) InetAddress.getByName("$slash24Prefix.255") else null
        } catch (_: Exception) {
            null
        }

        for (st in SEARCH_TARGETS) {
            if (socket.isClosed) return
            val payload = buildMSearchPayload(st)
            try {
                socket.send(DatagramPacket(payload, payload.size, multicastAddr, SSDP_PORT))
            } catch (e: Exception) {
                Log.d(TAG, "Multicast send ($st): ${e.message}")
            }
            if (broadcastAddr != null) {
                try {
                    socket.send(DatagramPacket(payload, payload.size, broadcastAddr, SSDP_PORT))
                } catch (_: Exception) {}
            }
        }
    }

    private suspend fun sendUnicastSubnetSweep(
        socket: DatagramSocket,
        slash24Prefix: String,
        selfIp: String?
    ) {
        val avPayload = buildMSearchPayload("urn:schemas-upnp-org:service:AVTransport:1")
        val rootPayload = buildMSearchPayload("upnp:rootdevice")
        for (hostOctet in 1..254) {
            if (socket.isClosed || !currentCoroutineContext().isActive) return
            val targetIp = "$slash24Prefix.$hostOctet"
            if (targetIp == selfIp) continue
            try {
                val addr = InetAddress.getByName(targetIp)
                socket.send(DatagramPacket(avPayload, avPayload.size, addr, SSDP_PORT))
                socket.send(DatagramPacket(rootPayload, rootPayload.size, addr, SSDP_PORT))
            } catch (_: Exception) {}

            if (hostOctet % 32 == 0) {
                delay(5)
            }
        }
    }

    private suspend fun inspectLocationUrl(locationUrl: String) {
        fetchSemaphore.withPermit {
            try {
                val req = Request.Builder()
                    .url(locationUrl)
                    .header("User-Agent", "Cineflix/1.4 UPnP/1.1")
                    .header("Accept", "text/xml, application/xml, */*")
                    .get()
                    .build()

                val xml = httpClient.newCall(req).execute().use { resp ->
                    if (!resp.isSuccessful) return@withPermit
                    resp.body?.string()
                } ?: return@withPermit

                val device = UpnpXmlParser.parseDeviceDescription(xml, locationUrl) ?: return@withPermit
                registerDiscoveredDevice(device)
            } catch (e: Exception) {
                // Allow retry on subsequent manual scans if HTTP timed out while TV was waking up
                inspectedLocations.remove(locationUrl)
                Log.d(TAG, "Inspect $locationUrl failed: ${e.message}")
            }
        }
    }

    private fun registerDiscoveredDevice(device: DlnaDevice) {
        val normalizedControl = device.avTransportControlUrl.lowercase()
        val existingUdnForControl = seenControlUrls.putIfAbsent(normalizedControl, device.udn)
        val keyUdn = existingUdnForControl ?: device.udn

        warmDevicesCache[keyUdn] = device
        val previous = devicesByUdn.put(keyUdn, device)
        if (previous != device) {
            Log.i(
                TAG,
                "📺 DLNA TV detectada: '${device.friendlyName}' (${device.brandBadge}, orsay=${device.isLegacySamsungOrsay}) -> ${device.avTransportControlUrl}"
            )
            notifyListenersOnMain()
        }
    }

    private fun notifyListenersOnMain() {
        val snapshot = getDevicesSnapshot()
        val scanning = isScanning.get()
        mainHandler.post {
            for (l in listeners) {
                l.onDevicesChanged(snapshot, scanning)
            }
        }
    }
}
