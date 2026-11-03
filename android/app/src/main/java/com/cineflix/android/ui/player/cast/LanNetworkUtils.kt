package com.cineflix.android.ui.player.cast

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import java.net.DatagramSocket
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.Collections

/**
 * Reliable LAN IPv4 resolution across Android 5..15 (API 21..35),
 * including dual-SIM mobile data + Wi-Fi, hotspots, Ethernet, and active VPNs.
 */
object LanNetworkUtils {

    /**
     * Resolves the exact local IPv4 address that the OS kernel routes to [targetHost]
     * (when provided), falling back to active Wi-Fi/Ethernet interfaces.
     */
    fun getBestLanIpv4(context: Context, targetHost: String? = null): String? {
        // 1. Exact kernel route probe via zero-packet connected UDP socket (bypasses VPN ambiguity)
        if (!targetHost.isNullOrBlank()) {
            try {
                DatagramSocket().use { socket ->
                    socket.connect(InetAddress.getByName(targetHost.trim()), 1900)
                    val localAddr = socket.localAddress
                    if (localAddr is Inet4Address && !localAddr.isLoopbackAddress) {
                        val ip = localAddr.hostAddress
                        if (!ip.isNullOrBlank() && ip != "0.0.0.0") {
                            return ip
                        }
                    }
                }
            } catch (_: Exception) {}
        }

        // 2. Scan active Wi-Fi / Ethernet NetworkInterfaces (wlan*, eth*, ap*, swlan*, rndis*)
        findPreferredInterfaceIpv4()?.let { return it }

        // 3. ConnectivityManager LinkProperties (Wi-Fi / Ethernet transport)
        try {
            val cm = context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
            if (cm != null) {
                @Suppress("DEPRECATION")
                val networks = cm.allNetworks
                for (net in networks) {
                    val caps = cm.getNetworkCapabilities(net) ?: continue
                    val isLan = caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                                caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                    if (!isLan) continue
                    val lp = cm.getLinkProperties(net) ?: continue
                    for (la in lp.linkAddresses) {
                        val addr = la.address
                        if (addr is Inet4Address && !addr.isLoopbackAddress) {
                            val ip = addr.hostAddress
                            if (!ip.isNullOrBlank() && ip != "0.0.0.0") {
                                return ip
                            }
                        }
                    }
                }
            }
        } catch (_: Exception) {}

        // 4. Legacy WifiManager fallback
        return try {
            val wm = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as? WifiManager
            @Suppress("DEPRECATION")
            val ipInt = wm?.connectionInfo?.ipAddress ?: 0
            if (ipInt == 0) null
            else String.format(
                java.util.Locale.US,
                "%d.%d.%d.%d",
                ipInt and 0xff,
                ipInt shr 8 and 0xff,
                ipInt shr 16 and 0xff,
                ipInt shr 24 and 0xff
            )
        } catch (_: Exception) {
            null
        }
    }

    private fun findPreferredInterfaceIpv4(): String? {
        return try {
            val interfaces = Collections.list(NetworkInterface.getNetworkInterfaces())
            var bestCandidate: String? = null
            var bestScore = -1

            for (nif in interfaces) {
                if (!nif.isUp || nif.isLoopback) continue
                val name = nif.name.lowercase(java.util.Locale.ROOT)
                // Ignore cellular / VPN / tunnel interfaces
                if (name.startsWith("rmnet") || name.startsWith("ccmni") ||
                    name.startsWith("tun") || name.startsWith("ppp") ||
                    name.startsWith("clat") || name.startsWith("dummy")) {
                    continue
                }

                for (addr in Collections.list(nif.inetAddresses)) {
                    if (addr !is Inet4Address || addr.isLoopbackAddress || addr.isLinkLocalAddress) continue
                    val ip = addr.hostAddress ?: continue
                    if (!isPrivateLanIpv4(ip)) continue

                    val score = when {
                        name.startsWith("wlan") || name.startsWith("swlan") -> 100
                        name.startsWith("eth") -> 90
                        name.startsWith("ap") || name.startsWith("softap") -> 80
                        else -> 50
                    }
                    if (score > bestScore) {
                        bestScore = score
                        bestCandidate = ip
                    }
                }
            }
            bestCandidate
        } catch (_: Exception) {
            null
        }
    }

    fun isPrivateLanIpv4(ip: String): Boolean {
        val parts = ip.split('.')
        if (parts.size != 4) return false
        val a = parts[0].toIntOrNull() ?: return false
        val b = parts[1].toIntOrNull() ?: return false
        return when {
            a == 192 && b == 168 -> true
            a == 10 -> true
            a == 172 && b in 16..31 -> true
            else -> false
        }
    }

    /**
     * Returns the /24 prefix (e.g. "192.168.1") if [ip] is a private LAN IPv4 address.
     */
    fun getSlash24Prefix(ip: String): String? {
        if (!isPrivateLanIpv4(ip)) return null
        val idx = ip.lastIndexOf('.')
        return if (idx > 0) ip.substring(0, idx) else null
    }
}
