package com.cineflix.android.ui.player.cast

import androidx.mediarouter.media.MediaRouter
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.xml.sax.InputSource
import java.io.StringReader
import java.net.URI
import java.util.Locale
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Discovered UPnP / DLNA Smart TV capable of direct AVTransport video playback
 * (Samsung Tizen 2015-2026, Samsung Orsay 2010-2014, LG webOS, Sony Bravia, Hisense VIDAA, Philips, TCL, Roku).
 */
data class DlnaDevice(
    val udn: String,
    val friendlyName: String,
    val manufacturer: String,
    val modelName: String,
    val locationUrl: String,
    val host: String,
    val avTransportControlUrl: String,
    val renderingControlUrl: String? = null,
    val isLegacySamsungOrsay: Boolean = detectLegacySamsungOrsay(manufacturer, modelName, friendlyName, ""),
    val isConfirmedModernTizen: Boolean = detectModernSamsungTizen(manufacturer, modelName, friendlyName, ""),
    val isSamsungNoDtsTizen: Boolean = detectSamsungNoDtsTizen(manufacturer, modelName, friendlyName, "")
) {
    val isSamsung: Boolean
        get() {
            val combined = "$manufacturer $modelName $friendlyName".lowercase(Locale.ROOT)
            return isLegacySamsungOrsay || combined.contains("samsung") || combined.contains("tizen")
        }

    val brandBadge: String
        get() {
            val combined = "$manufacturer $modelName $friendlyName".lowercase(Locale.ROOT)
            return when {
                isLegacySamsungOrsay -> "Samsung Smart TV (Compat.) • Directo"
                combined.contains("samsung") || combined.contains("tizen") -> "Samsung Smart TV • Directo"
                combined.contains("lg") || combined.contains("webos") -> "LG webOS TV • Directo"
                combined.contains("sony") || combined.contains("bravia") -> "Sony Bravia • Directo"
                combined.contains("hisense") || combined.contains("vidaa") -> "Hisense Smart TV • Directo"
                combined.contains("philips") -> "Philips Smart TV • Directo"
                combined.contains("tcl") -> "TCL Smart TV • Directo"
                combined.contains("panasonic") || combined.contains("viera") -> "Panasonic TV • Directo"
                combined.contains("roku") -> "Roku TV • Directo"
                else -> "Smart TV • Directo"
            }
        }

    companion object {
        // Matches 2010-2014 Samsung Orsay pre-Tizen chassis codes:
        // e.g. UE40F6400 (2013/2014), UE46ES6100 (2012), UE40D6500 (2011), UN55H6400 (2014)
        // Does NOT match Tizen (2015+ J/JU/JS/K/KS/KU/MU/NU/RU/TU/AU/BU/CU/DU/QE/QN/S95B).
        private val SAMSUNG_ORSAY_MODEL_REGEX = Regex(
            "\\b(?:UE|UN|UA|LE|LN|LA|PS|PN|HG)\\d{2,3}(?:C|D|E|ES|EH|F|FH|H|HU)\\d{3,4}[A-Z0-9]*\\b",
            RegexOption.IGNORE_CASE
        )
        private val SAMSUNG_ORSAY_YEAR_CAP_REGEX = Regex("\\bY201[0-4]\\b", RegexOption.IGNORE_CASE)
        private val MODERN_TIZEN_YEAR_CAP_REGEX = Regex("\\bY20(?:1[6-9]|2[0-9])\\b", RegexOption.IGNORE_CASE)
        private val MODERN_TIZEN_MODEL_REGEX = Regex(
            "\\b(?:QE\\d{2,3}|QN\\d{2,3}|(?:UE|UN|UA)\\d{2,3}(?:K|KS|KU|M|MU|NU|RU|TU|AU|BU|CU|DU|LS))[A-Z0-9]*\\b|\\bS(?:85|90|95)[B-Z]\\b",
            RegexOption.IGNORE_CASE
        )
        private val SAMSUNG_2015_2017_DTS_YEAR_REGEX = Regex("\\bY201[5-7]\\b", RegexOption.IGNORE_CASE)
        private val SAMSUNG_2018_PLUS_NO_DTS_YEAR_REGEX = Regex("\\bY20(?:1[8-9]|2[0-9])\\b", RegexOption.IGNORE_CASE)
        private val SAMSUNG_2018_PLUS_NO_DTS_MODEL_REGEX = Regex(
            "\\b(?:QN\\d{2,3}|(?:QE|UE|UN|UA)\\d{2,3}(?:NU|RU|TU|AU|BU|CU|DU|S8|S9|Q[6-9]\\d|QN|LS))[A-Z0-9]*\\b|\\bS(?:85|90|95)[B-Z]\\b",
            RegexOption.IGNORE_CASE
        )

        fun detectLegacySamsungOrsay(
            manufacturer: String,
            modelName: String,
            friendlyName: String,
            rawXml: String = ""
        ): Boolean {
            val combinedMeta = "$manufacturer $modelName $friendlyName"
            if (combinedMeta.contains("tizen", ignoreCase = true) ||
                rawXml.contains("tizen", ignoreCase = true) ||
                MODERN_TIZEN_YEAR_CAP_REGEX.containsMatchIn(rawXml) ||
                MODERN_TIZEN_MODEL_REGEX.containsMatchIn(combinedMeta)
            ) {
                return false
            }

            val isSamsungVendor = combinedMeta.contains("samsung", ignoreCase = true) ||
                rawXml.contains("samsung", ignoreCase = true) ||
                rawXml.contains("sec.co.kr", ignoreCase = true)

            if (SAMSUNG_ORSAY_MODEL_REGEX.containsMatchIn(combinedMeta)) {
                return true
            }
            if (!isSamsungVendor) return false

            return SAMSUNG_ORSAY_MODEL_REGEX.containsMatchIn(rawXml) ||
                SAMSUNG_ORSAY_YEAR_CAP_REGEX.containsMatchIn(rawXml)
        }

        fun detectModernSamsungTizen(
            manufacturer: String,
            modelName: String,
            friendlyName: String,
            rawXml: String = ""
        ): Boolean {
            val combinedMeta = "$manufacturer $modelName $friendlyName"
            if (detectLegacySamsungOrsay(manufacturer, modelName, friendlyName, rawXml)) {
                return false
            }
            return combinedMeta.contains("tizen", ignoreCase = true) ||
                rawXml.contains("tizen", ignoreCase = true) ||
                MODERN_TIZEN_YEAR_CAP_REGEX.containsMatchIn(rawXml) ||
                MODERN_TIZEN_MODEL_REGEX.containsMatchIn(combinedMeta) ||
                MODERN_TIZEN_MODEL_REGEX.containsMatchIn(rawXml)
        }

        /**
         * Samsung removed hardware DTS and Dolby TrueHD decoding on all 2018+ Tizen Smart TVs
         * (NU / RU / TU / AU / BU / CU / DU / Q60-Q95 / QN / S85-S95 OLED).
         */
        fun detectSamsungNoDtsTizen(
            manufacturer: String,
            modelName: String,
            friendlyName: String,
            rawXml: String = ""
        ): Boolean {
            if (detectLegacySamsungOrsay(manufacturer, modelName, friendlyName, rawXml)) {
                return false
            }
            if (SAMSUNG_2015_2017_DTS_YEAR_REGEX.containsMatchIn(rawXml)) {
                return false
            }
            val combinedMeta = "$manufacturer $modelName $friendlyName"
            val isSamsung = combinedMeta.contains("samsung", ignoreCase = true) ||
                combinedMeta.contains("tizen", ignoreCase = true) ||
                rawXml.contains("samsung", ignoreCase = true) ||
                rawXml.contains("tizen", ignoreCase = true) ||
                MODERN_TIZEN_MODEL_REGEX.containsMatchIn(combinedMeta)
            if (!isSamsung) return false

            return SAMSUNG_2018_PLUS_NO_DTS_YEAR_REGEX.containsMatchIn(rawXml) ||
                SAMSUNG_2018_PLUS_NO_DTS_MODEL_REGEX.containsMatchIn(combinedMeta) ||
                SAMSUNG_2018_PLUS_NO_DTS_MODEL_REGEX.containsMatchIn(rawXml)
        }
    }
}

/**
 * Unified TV item displayed in the 1-tap "Enviar a TV" selector dialog.
 * Combines Google Cast (Chromecast / Android TV / Google TV) and native DLNA Smart TVs.
 */
sealed class UnifiedTvDevice {
    abstract val id: String
    abstract val name: String
    abstract val badge: String
    abstract val hostIp: String?

    data class GoogleCastTv(
        override val id: String,
        override val name: String,
        override val badge: String = "Chromecast / Android TV",
        override val hostIp: String? = null,
        val route: MediaRouter.RouteInfo
    ) : UnifiedTvDevice()

    data class DlnaSmartTv(
        override val id: String,
        override val name: String,
        override val badge: String,
        override val hostIp: String?,
        val device: DlnaDevice
    ) : UnifiedTvDevice()
}

data class DlnaPositionSnapshot(
    val positionMs: Long,
    val durationMs: Long,
    val relTimeRaw: String,
    val trackDurationRaw: String,
    val hasValidRelTime: Boolean = false
)

data class DlnaAllowedTransforms(
    val subtitleValues: List<String> = emptyList(),
    val codepageValues: List<String> = emptyList()
)

/**
 * Pure, dependency-free UPnP Device Description & SOAP XML parser.
 * Hardened against Smart TV firmware quirks (UTF-8 BOM, trailing NULs, bare ampersands,
 * nested <deviceList> MediaRenderers, <URLBase>, and relative controlURLs without leading '/').
 */
object UpnpXmlParser {

    private val BARE_AMP_REGEX = Regex("&(?!(?:amp|lt|gt|quot|apos|#\\d+|#x[0-9a-fA-F]+);)")

    fun sanitizeXml(raw: String): String {
        val trimmed = raw
            .trimStart('\uFEFF', ' ', '\t', '\r', '\n')
            .trimEnd('\u0000', ' ', '\t', '\r', '\n')
        return BARE_AMP_REGEX.replace(trimmed, "&amp;")
    }

    /**
     * Parses a UPnP device description XML document fetched from [locationUrl].
     * Returns a [DlnaDevice] ONLY if the device (or one of its embedded sub-devices)
     * exposes an `AVTransport` control service (ignoring routers / gateways / DMS-only servers).
     */
    fun parseDeviceDescription(rawXml: String, locationUrl: String): DlnaDevice? {
        if (rawXml.isBlank()) return null
        val cleanXml = sanitizeXml(rawXml)
        val doc = parseDom(cleanXml) ?: return null
        val root = doc.documentElement ?: return null

        val urlBaseText = findDirectChildText(root, "URLBase")?.trim().orEmpty()
        val effectiveBaseUrl = if (urlBaseText.startsWith("http://", true) || urlBaseText.startsWith("https://", true)) {
            urlBaseText
        } else {
            locationUrl.trim()
        }

        val host = try {
            URI(locationUrl.trim()).host ?: ""
        } catch (_: Exception) {
            ""
        }

        val rootDeviceEl = findDirectChildElements(root, "device").firstOrNull() ?: return null
        val fallbackName = findDirectChildText(rootDeviceEl, "friendlyName")?.trim().orEmpty()
        val fallbackManufacturer = findDirectChildText(rootDeviceEl, "manufacturer")?.trim().orEmpty()
        val fallbackModel = findDirectChildText(rootDeviceEl, "modelName")?.trim().orEmpty()
        val fallbackUdn = findDirectChildText(rootDeviceEl, "UDN")?.trim().orEmpty()

        val allDevices = mutableListOf<Element>()
        collectDeviceElements(rootDeviceEl, allDevices)

        for (devEl in allDevices) {
            var avControlRaw: String? = null
            var rcControlRaw: String? = null

            val serviceListEl = findDirectChildElements(devEl, "serviceList").firstOrNull()
            if (serviceListEl != null) {
                for (svcEl in findDirectChildElements(serviceListEl, "service")) {
                    val svcType = findDirectChildText(svcEl, "serviceType")?.trim().orEmpty()
                    val svcId = findDirectChildText(svcEl, "serviceId")?.trim().orEmpty()
                    val controlUrl = findDirectChildText(svcEl, "controlURL")?.trim().orEmpty()
                    if (controlUrl.isEmpty()) continue

                    if (avControlRaw == null &&
                        (svcType.contains("AVTransport", ignoreCase = true) ||
                         svcId.contains("AVTransport", ignoreCase = true))
                    ) {
                        avControlRaw = controlUrl
                    } else if (rcControlRaw == null &&
                        (svcType.contains("RenderingControl", ignoreCase = true) ||
                         svcId.contains("RenderingControl", ignoreCase = true))
                    ) {
                        rcControlRaw = controlUrl
                    }
                }
            }

            if (!avControlRaw.isNullOrBlank()) {
                val resolvedAvUrl = resolveUpnpUrl(effectiveBaseUrl, avControlRaw!!) ?: continue
                val resolvedRcUrl = rcControlRaw?.let { resolveUpnpUrl(effectiveBaseUrl, it) }

                val friendlyName = findDirectChildText(devEl, "friendlyName")?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: fallbackName.ifEmpty { "Smart TV ($host)" }
                val manufacturer = findDirectChildText(devEl, "manufacturer")?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: fallbackManufacturer
                val modelName = findDirectChildText(devEl, "modelName")?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: fallbackModel
                val udn = findDirectChildText(devEl, "UDN")?.trim()
                    ?.takeIf { it.isNotEmpty() }
                    ?: fallbackUdn.ifEmpty { "dlna:$resolvedAvUrl" }

                val isOrsay = DlnaDevice.detectLegacySamsungOrsay(
                    manufacturer = manufacturer,
                    modelName = modelName,
                    friendlyName = friendlyName,
                    rawXml = cleanXml
                )
                val isModernTizen = DlnaDevice.detectModernSamsungTizen(
                    manufacturer = manufacturer,
                    modelName = modelName,
                    friendlyName = friendlyName,
                    rawXml = cleanXml
                )
                val isNoDtsTizen = DlnaDevice.detectSamsungNoDtsTizen(
                    manufacturer = manufacturer,
                    modelName = modelName,
                    friendlyName = friendlyName,
                    rawXml = cleanXml
                )

                return DlnaDevice(
                    udn = udn,
                    friendlyName = friendlyName,
                    manufacturer = manufacturer,
                    modelName = modelName,
                    locationUrl = locationUrl.trim(),
                    host = host,
                    avTransportControlUrl = resolvedAvUrl,
                    renderingControlUrl = resolvedRcUrl,
                    isLegacySamsungOrsay = isOrsay,
                    isConfirmedModernTizen = isModernTizen,
                    isSamsungNoDtsTizen = isNoDtsTizen
                )
            }
        }

        return null
    }

    /**
     * Resolves relative UPnP control URLs (`"/upnp/control/AVTransport1"`, `"smp_22_"`, or full `"http://..."`)
     * accurately against [baseUrl].
     */
    fun resolveUpnpUrl(baseUrl: String, controlPath: String): String? {
        val trimmedPath = controlPath.trim()
        if (trimmedPath.isEmpty()) return null
        if (trimmedPath.startsWith("http://", ignoreCase = true) ||
            trimmedPath.startsWith("https://", ignoreCase = true)
        ) {
            return trimmedPath
        }
        return try {
            val baseUri = URI(baseUrl.trim())
            if (trimmedPath.startsWith("/")) {
                URI(
                    baseUri.scheme,
                    null,
                    baseUri.host,
                    baseUri.port,
                    trimmedPath,
                    null,
                    null
                ).toString()
            } else {
                val basePath = baseUri.path ?: "/"
                val dirPath = if (basePath.endsWith("/")) {
                    basePath
                } else {
                    val lastSlash = basePath.lastIndexOf('/')
                    if (lastSlash >= 0) basePath.substring(0, lastSlash + 1) else "/"
                }
                URI(
                    baseUri.scheme,
                    null,
                    baseUri.host,
                    baseUri.port,
                    dirPath + trimmedPath,
                    null,
                    null
                ).toString()
            }
        } catch (_: Exception) {
            null
        }
    }

    fun parsePositionInfoResponse(rawSoapXml: String): DlnaPositionSnapshot? {
        if (rawSoapXml.isBlank()) return null
        val doc = parseDom(sanitizeXml(rawSoapXml)) ?: return null
        val relTime = findAnyElementText(doc.documentElement, "RelTime")?.trim().orEmpty()
        val trackDur = findAnyElementText(doc.documentElement, "TrackDuration")?.trim().orEmpty()
        return DlnaPositionSnapshot(
            positionMs = DlnaSoapBuilder.parseDurationToMs(relTime),
            durationMs = DlnaSoapBuilder.parseDurationToMs(trackDur),
            relTimeRaw = relTime,
            trackDurationRaw = trackDur,
            hasValidRelTime = DlnaSoapBuilder.hasValidDurationFormat(relTime)
        )
    }

    fun parseTransportStateResponse(rawSoapXml: String): String? {
        if (rawSoapXml.isBlank()) return null
        val doc = parseDom(sanitizeXml(rawSoapXml)) ?: return null
        return findAnyElementText(doc.documentElement, "CurrentTransportState")?.trim()
    }

    fun parseUpnpErrorCode(rawSoapXml: String): Int? {
        if (rawSoapXml.isBlank()) return null
        val doc = parseDom(sanitizeXml(rawSoapXml)) ?: return null
        return findAnyElementText(doc.documentElement, "errorCode")?.trim()?.toIntOrNull()
    }

    /**
     * Parses UPnP `RenderingControl:1#GetAllowedTransforms` SOAP response (`CurrentAllowedTransformSettings`),
     * extracting `<allowedValue>` items for `<transform name="Subtitle">` and `<transform name="X_Philips.com_Codepage">`.
     */
    fun parseAllowedTransformsResponse(rawSoapXml: String): DlnaAllowedTransforms? {
        if (rawSoapXml.isBlank()) return null
        val outerDoc = parseDom(sanitizeXml(rawSoapXml)) ?: return null
        val innerXml = findAnyElementText(outerDoc.documentElement, "CurrentAllowedTransformSettings")?.trim()
        if (innerXml.isNullOrBlank()) return null
        val innerDoc = parseDom(sanitizeXml(innerXml)) ?: return null
        val root = innerDoc.documentElement ?: return null

        val subtitleValues = mutableListOf<String>()
        val codepageValues = mutableListOf<String>()

        for (transformEl in findDirectChildElements(root, "transform")) {
            val nameAttr = transformEl.getAttribute("name")?.trim().orEmpty()
            val values = mutableListOf<String>()
            for (listEl in findDirectChildElements(transformEl, "allowedValueList")) {
                for (valEl in findDirectChildElements(listEl, "allowedValue")) {
                    val v = valEl.textContent?.trim().orEmpty()
                    if (v.isNotEmpty()) {
                        values.add(v)
                    }
                }
            }
            if (values.isEmpty()) {
                for (valEl in findDirectChildElements(transformEl, "allowedValue")) {
                    val v = valEl.textContent?.trim().orEmpty()
                    if (v.isNotEmpty()) {
                        values.add(v)
                    }
                }
            }
            when {
                nameAttr.equals("Subtitle", ignoreCase = true) -> {
                    for (v in values) {
                        if (!v.equals(DlnaSoapBuilder.DLNA_SUBTITLE_OFF_VALUE, ignoreCase = true) &&
                            !v.equals("Off", ignoreCase = true) &&
                            !v.equals("None", ignoreCase = true)
                        ) {
                            subtitleValues.add(v)
                        }
                    }
                }
                nameAttr.contains("Codepage", ignoreCase = true) ||
                    nameAttr.contains("Charset", ignoreCase = true) -> codepageValues.addAll(values)
            }
        }

        return DlnaAllowedTransforms(
            subtitleValues = subtitleValues,
            codepageValues = codepageValues
        )
    }

    /**
     * Extracts headers from a raw UDP SSDP HTTP-like packet (`M-SEARCH` 200 OK or `NOTIFY`).
     */
    fun parseSsdpHeaders(packetText: String): Map<String, String> {
        val result = mutableMapOf<String, String>()
        val lines = packetText.split("\r\n", "\n")
        for (i in 1 until lines.size) {
            val line = lines[i].trim()
            if (line.isEmpty()) continue
            val colon = line.indexOf(':')
            if (colon <= 0) continue
            val key = line.substring(0, colon).trim().lowercase(Locale.ROOT)
            val value = line.substring(colon + 1).trim()
            if (value.isNotEmpty()) {
                result[key] = value
            }
        }
        return result
    }

    private fun parseDom(xml: String): org.w3c.dom.Document? {
        return try {
            val dbf = DocumentBuilderFactory.newInstance().apply {
                isNamespaceAware = true
                try { setFeature("http://xml.org/sax/features/external-general-entities", false) } catch (_: Throwable) {}
                try { setFeature("http://xml.org/sax/features/external-parameter-entities", false) } catch (_: Throwable) {}
                try { setFeature("http://apache.org/xml/features/disallow-doctype-decl", true) } catch (_: Throwable) {}
            }
            val builder = dbf.newDocumentBuilder()
            builder.parse(InputSource(StringReader(xml)))
        } catch (_: Exception) {
            null
        }
    }

    private fun collectDeviceElements(deviceEl: Element, out: MutableList<Element>) {
        out.add(deviceEl)
        for (listEl in findDirectChildElements(deviceEl, "deviceList")) {
            for (childDev in findDirectChildElements(listEl, "device")) {
                collectDeviceElements(childDev, out)
            }
        }
    }

    private fun localTagName(node: Node): String {
        val ln = node.localName
        if (!ln.isNullOrEmpty()) return ln
        val raw = node.nodeName ?: ""
        return raw.substringAfter(':')
    }

    private fun findDirectChildElements(parent: Element, localName: String): List<Element> {
        val list = mutableListOf<Element>()
        val children = parent.childNodes ?: return list
        for (i in 0 until children.length) {
            val n = children.item(i)
            if (n is Element && localTagName(n).equals(localName, ignoreCase = true)) {
                list.add(n)
            }
        }
        return list
    }

    private fun findDirectChildText(parent: Element, localName: String): String? {
        return findDirectChildElements(parent, localName).firstOrNull()?.textContent
    }

    private fun findAnyElementText(root: Element?, localName: String): String? {
        if (root == null) return null
        if (localTagName(root).equals(localName, ignoreCase = true)) {
            return root.textContent
        }
        val children = root.childNodes ?: return null
        for (i in 0 until children.length) {
            val n = children.item(i)
            if (n is Element) {
                val hit = findAnyElementText(n, localName)
                if (hit != null) return hit
            }
        }
        return null
    }
}

/**
 * Generates standards-compliant UPnP AVTransport:1 SOAP 1.1 envelopes & DIDL-Lite metadata
 * tested against Samsung Tizen (2015-2026), Samsung Orsay (2010-2014), LG webOS, Sony Bravia,
 * Hisense VIDAA, and Roku.
 */
object DlnaSoapBuilder {

    const val AV_TRANSPORT_SERVICE_TYPE = "urn:schemas-upnp-org:service:AVTransport:1"
    const val RENDERING_CONTROL_SERVICE_TYPE = "urn:schemas-upnp-org:service:RenderingControl:1"
    const val DLNA_SUBTITLE_OFF_VALUE = "Subtitle_[0]"
    const val DLNA_STREAMING_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=0;DLNA.ORG_FLAGS=01700000000000000000000000000000"
    // Samsung Orsay (C/D/E/F/H 2010-2014) byte-seekable streaming flags (matches MiniDLNA ESamsungSeriesCDE)
    const val DLNA_ORSAY_STREAMING_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=0;DLNA.ORG_FLAGS=01500000000000000000000000000000"

    // Live on-phone transcoded 188-byte ISO MPEG-TS (H.264 + AAC-LC) streaming flags (DLNA.ORG_OP=01, CI=1)
    // Omit DLNA.ORG_PN so Samsung Tizen does not invoke its strict AVC_TS_MP_HD_AAC_MULT5_ISO resolution/profile
    // validator on cinema widescreen aspect ratios (e.g. 1920x800, 1280x534) or High/Baseline H.264 profiles.
    const val DLNA_LIVE_TS_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=1;DLNA.ORG_FLAGS=01700000000000000000000000000000"
    const val DLNA_ORSAY_LIVE_TS_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=1;DLNA.ORG_FLAGS=01500000000000000000000000000000"
    const val DLNA_GENERIC_LIVE_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=1;DLNA.ORG_FLAGS=01700000000000000000000000000000"
    const val DLNA_ORSAY_GENERIC_LIVE_FLAGS =
        "DLNA.ORG_OP=01;DLNA.ORG_CI=1;DLNA.ORG_FLAGS=01500000000000000000000000000000"

    fun escapeXml(text: String): String {
        val sb = StringBuilder(text.length + 16)
        for (ch in text) {
            when (ch) {
                '&' -> sb.append("&amp;")
                '<' -> sb.append("&lt;")
                '>' -> sb.append("&gt;")
                '"' -> sb.append("&quot;")
                '\'' -> sb.append("&apos;")
                else -> sb.append(ch)
            }
        }
        return sb.toString()
    }

    fun buildDidlLiteMetadata(
        streamUrl: String,
        title: String,
        mimeType: String,
        fileSizeBytes: Long = 0L,
        durationMs: Long = 0L,
        subtitleSrtUrl: String? = null,
        dlnaFlags: String = if (mimeType.equals("video/x-mkv", ignoreCase = true)) {
            DLNA_ORSAY_STREAMING_FLAGS
        } else {
            DLNA_STREAMING_FLAGS
        }
    ): String {
        val safeTitle = escapeXml(title.ifBlank { "Cineflix" })
        val safeUrl = escapeXml(streamUrl)
        val safeMime = escapeXml(mimeType.ifBlank { "video/mp4" })
        val protocolInfo = "http-get:*:$safeMime:$dlnaFlags"

        val sizeAttr = if (fileSizeBytes > 0L) " size=\"$fileSizeBytes\"" else ""
        val durAttr = if (durationMs > 0L) " duration=\"${formatMsToRelTime(durationMs)}\"" else ""

        val subXml = if (!subtitleSrtUrl.isNullOrBlank()) {
            val safeSub = escapeXml(subtitleSrtUrl)
            val smiUrl = if (subtitleSrtUrl.endsWith(".srt", ignoreCase = true)) {
                subtitleSrtUrl.dropLast(4) + ".smi"
            } else {
                "$subtitleSrtUrl.smi"
            }
            val safeSmi = escapeXml(smiUrl)
            "<res protocolInfo=\"http-get:*:text/srt:*\">$safeSub</res>" +
            "<res protocolInfo=\"http-get:*:smi/caption:*\">$safeSmi</res>" +
            "<sec:CaptionInfoEx sec:type=\"srt\">$safeSub</sec:CaptionInfoEx>" +
            "<sec:CaptionInfo sec:type=\"srt\">$safeSub</sec:CaptionInfo>"
        } else {
            ""
        }

        return "<DIDL-Lite xmlns=\"urn:schemas-upnp-org:metadata-1-0/DIDL-Lite/\" " +
               "xmlns:dc=\"http://purl.org/dc/elements/1.1/\" " +
               "xmlns:upnp=\"urn:schemas-upnp-org:metadata-1-0/upnp/\" " +
               "xmlns:dlna=\"urn:schemas-dlna-org:metadata-1-0/\" " +
               "xmlns:sec=\"http://www.sec.co.kr/\">" +
               "<item id=\"0\" parentID=\"-1\" restricted=\"1\">" +
               "<dc:title>$safeTitle</dc:title>" +
               "<upnp:class>object.item.videoItem.movie</upnp:class>" +
               "<res protocolInfo=\"$protocolInfo\"$sizeAttr$durAttr>$safeUrl</res>" +
               subXml +
               "</item>" +
               "</DIDL-Lite>"
    }

    fun buildSetAvTransportUriSoap(streamUrl: String, didlMetadata: String): String {
        return wrapSoapEnvelope(
            action = "SetAVTransportURI",
            innerArgsXml = "<InstanceID>0</InstanceID>" +
                           "<CurrentURI>${escapeXml(streamUrl)}</CurrentURI>" +
                           "<CurrentURIMetaData>${escapeXml(didlMetadata)}</CurrentURIMetaData>"
        )
    }

    fun buildPlaySoap(): String {
        return wrapSoapEnvelope(
            action = "Play",
            innerArgsXml = "<InstanceID>0</InstanceID><Speed>1</Speed>"
        )
    }

    fun buildPauseSoap(): String {
        return wrapSoapEnvelope(
            action = "Pause",
            innerArgsXml = "<InstanceID>0</InstanceID>"
        )
    }

    fun buildStopSoap(): String {
        return wrapSoapEnvelope(
            action = "Stop",
            innerArgsXml = "<InstanceID>0</InstanceID>"
        )
    }

    fun buildSeekSoap(targetMs: Long): String {
        val relTime = formatMsToRelTime(targetMs.coerceAtLeast(0L))
        return wrapSoapEnvelope(
            action = "Seek",
            innerArgsXml = "<InstanceID>0</InstanceID><Unit>REL_TIME</Unit><Target>$relTime</Target>"
        )
    }

    fun buildGetPositionInfoSoap(): String {
        return wrapSoapEnvelope(
            action = "GetPositionInfo",
            innerArgsXml = "<InstanceID>0</InstanceID>"
        )
    }

    fun buildGetTransportInfoSoap(): String {
        return wrapSoapEnvelope(
            action = "GetTransportInfo",
            innerArgsXml = "<InstanceID>0</InstanceID>"
        )
    }

    fun buildGetAllowedTransformsSoap(): String {
        return wrapSoapEnvelope(
            action = "GetAllowedTransforms",
            innerArgsXml = "<InstanceID>0</InstanceID>",
            serviceType = RENDERING_CONTROL_SERVICE_TYPE
        )
    }

    fun buildSetTransformsSoap(transformName: String, transformValue: String): String {
        val innerTransformXml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<TransformSettings xmlns=\"urn:schemas-upnp-org:av:TransformSettings\" " +
            "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
            "xsi:schemaLocation=\"urn:schemas-upnp-org:av:TransformSettings http://www.upnp.org/schemas/av/avs.xsd\">" +
            "<transform name=\"${escapeXml(transformName)}\"><value>${escapeXml(transformValue)}</value></transform>" +
            "</TransformSettings>"
        return wrapSoapEnvelope(
            action = "SetTransforms",
            innerArgsXml = "<InstanceID>0</InstanceID>" +
                           "<DesiredTransformValues>${escapeXml(innerTransformXml)}</DesiredTransformValues>",
            serviceType = RENDERING_CONTROL_SERVICE_TYPE
        )
    }

    private fun wrapSoapEnvelope(
        action: String,
        innerArgsXml: String,
        serviceType: String = AV_TRANSPORT_SERVICE_TYPE
    ): String {
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
               "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
               "s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
               "<s:Body>" +
               "<u:$action xmlns:u=\"$serviceType\">" +
               innerArgsXml +
               "</u:$action>" +
               "</s:Body>" +
               "</s:Envelope>"
    }

    /**
     * Formats milliseconds into UPnP `HH:MM:SS` relative time string.
     */
    fun formatMsToRelTime(ms: Long): String {
        val safeSec = (ms.coerceAtLeast(0L)) / 1000L
        val hours = safeSec / 3600L
        val minutes = (safeSec % 3600L) / 60L
        val seconds = safeSec % 60L
        return String.format(Locale.US, "%02d:%02d:%02d", hours, minutes, seconds)
    }

    fun hasValidDurationFormat(raw: String?): Boolean {
        if (raw.isNullOrBlank()) return false
        val clean = raw.trim()
        if (clean.equals("NOT_IMPLEMENTED", ignoreCase = true) || clean.startsWith("-")) return false
        val parts = clean.split(':')
        if (parts.size != 3) return false
        val hours = parts[0].trim().toLongOrNull() ?: return false
        val minutes = parts[1].trim().toLongOrNull() ?: return false
        val secParts = parts[2].trim().split('.')
        val seconds = secParts[0].toLongOrNull() ?: return false
        return hours >= 0L && minutes >= 0L && seconds >= 0L
    }

    /**
     * Parses UPnP duration / RelTime (`"01:42:15"`, `"01:42:15.500"`, `"0:05:12"`) into milliseconds.
     * Returns 0L for `"NOT_IMPLEMENTED"`, empty, or invalid strings.
     */
    fun parseDurationToMs(raw: String?): Long {
        if (raw.isNullOrBlank()) return 0L
        val clean = raw.trim()
        if (clean.equals("NOT_IMPLEMENTED", ignoreCase = true) || clean.startsWith("-")) return 0L
        val parts = clean.split(':')
        if (parts.size != 3) return 0L
        val hours = parts[0].trim().toLongOrNull() ?: return 0L
        val minutes = parts[1].trim().toLongOrNull() ?: return 0L
        val secParts = parts[2].trim().split('.')
        val seconds = secParts[0].toLongOrNull() ?: return 0L
        val millis = if (secParts.size > 1) {
            secParts[1].padEnd(3, '0').take(3).toLongOrNull() ?: 0L
        } else {
            0L
        }
        return ((hours * 3600L + minutes * 60L + seconds) * 1000L) + millis
    }
}
