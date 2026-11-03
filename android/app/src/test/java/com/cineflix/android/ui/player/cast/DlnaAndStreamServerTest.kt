package com.cineflix.android.ui.player.cast

import com.cineflix.android.ui.player.LocalStreamServer
import com.cineflix.android.ui.player.cast.transcode.EglTranscodeSurface
import com.cineflix.android.ui.player.cast.transcode.H264NalConverter
import com.cineflix.android.ui.player.cast.transcode.MpegTsMuxer
import com.cineflix.android.ui.player.cast.transcode.PcmStereoProcessor
import com.cineflix.android.ui.player.cast.transcode.VideoDtsNormalizer
import org.junit.Assert.*
import org.junit.Test
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader
import java.net.InetAddress
import java.net.ServerSocket
import java.nio.charset.StandardCharsets
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class DlnaAndStreamServerTest {

    @Test
    fun parsesSamsungTizenNestedMediaRendererAndRelativeControlUrl() {
        val tizenXml = """
            <?xml version="1.0"?>
            <root xmlns="urn:schemas-upnp-org:device-1-0">
              <device>
                <deviceType>urn:samsung.com:device:RemoteControlReceiver:1</deviceType>
                <friendlyName>[TV] Samsung QLED 65</friendlyName>
                <manufacturer>Samsung Electronics</manufacturer>
                <modelName>QE65Q80T</modelName>
                <UDN>uuid:root-samsung-tv-1</UDN>
                <deviceList>
                  <device>
                    <deviceType>urn:schemas-upnp-org:device:MediaRenderer:1</deviceType>
                    <friendlyName>[TV] Samsung QLED 65</friendlyName>
                    <manufacturer>Samsung Electronics</manufacturer>
                    <modelName>QE65Q80T</modelName>
                    <UDN>uuid:dmr-samsung-tv-1</UDN>
                    <serviceList>
                      <service>
                        <serviceType>urn:schemas-upnp-org:service:AVTransport:1</serviceType>
                        <serviceId>urn:upnp-org:serviceId:AVTransport</serviceId>
                        <controlURL>smp_22_</controlURL>
                      </service>
                    </serviceList>
                  </device>
                </deviceList>
              </device>
            </root>
        """.trimIndent()

        val dev = UpnpXmlParser.parseDeviceDescription(tizenXml, "http://192.168.1.55:7676/smp_15_")
        assertNotNull(dev)
        assertEquals("uuid:dmr-samsung-tv-1", dev!!.udn)
        assertEquals("[TV] Samsung QLED 65", dev.friendlyName)
        assertEquals("192.168.1.55", dev.host)
        assertEquals("http://192.168.1.55:7676/smp_22_", dev.avTransportControlUrl)
        assertEquals("Samsung Smart TV • Directo", dev.brandBadge)
    }

    @Test
    fun parsesLgWebOsWithBomBareAmpersandAndUrlBase() {
        val lgXml = "\uFEFF<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<root xmlns=\"urn:schemas-upnp-org:device-1-0\">" +
            "<URLBase>http://192.168.1.88:1474/</URLBase>" +
            "<device>" +
            "<deviceType>urn:schemas-upnp-org:device:MediaRenderer:1</deviceType>" +
            "<friendlyName>LG webOS TV & Sound OLED55C3</friendlyName>" +
            "<manufacturer>LG Electronics</manufacturer>" +
            "<modelName>OLED55C36LC</modelName>" +
            "<UDN>uuid:lg-webos-c3</UDN>" +
            "<serviceList>" +
            "<service>" +
            "<serviceType>urn:schemas-upnp-org:service:AVTransport:1</serviceType>" +
            "<serviceId>urn:upnp-org:serviceId:AVTransport</serviceId>" +
            "<controlURL>/AVTransport/uuid:lg-webos-c3/control.xml</controlURL>" +
            "</service>" +
            "</serviceList>" +
            "</device>" +
            "</root>\u0000"

        val dev = UpnpXmlParser.parseDeviceDescription(lgXml, "http://192.168.1.88:1474/desc.xml")
        assertNotNull(dev)
        assertEquals("LG webOS TV & Sound OLED55C3", dev!!.friendlyName)
        assertEquals("http://192.168.1.88:1474/AVTransport/uuid:lg-webos-c3/control.xml", dev.avTransportControlUrl)
        assertEquals("LG webOS TV • Directo", dev.brandBadge)
    }

    @Test
    fun ignoresRoutersWithoutAvTransportService() {
        val routerXml = """
            <?xml version="1.0"?>
            <root xmlns="urn:schemas-upnp-org:device-1-0">
              <device>
                <deviceType>urn:schemas-upnp-org:device:InternetGatewayDevice:1</deviceType>
                <friendlyName>Movistar Fibra Router</friendlyName>
                <UDN>uuid:router-1</UDN>
                <serviceList>
                  <service>
                    <serviceType>urn:schemas-upnp-org:service:WANIPConnection:1</serviceType>
                    <controlURL>/ctl/IPConn</controlURL>
                  </service>
                </serviceList>
              </device>
            </root>
        """.trimIndent()

        assertNull(UpnpXmlParser.parseDeviceDescription(routerXml, "http://192.168.1.1:5000/rootDesc.xml"))
    }

    @Test
    fun sniffsMkvWebmMp4AviAndTsMagicBytesAccurately() {
        val mkvBytes = byteArrayOf(
            0x1A, 0x45, 0xDF.toByte(), 0xA3.toByte(),
            0x9F.toByte(), 0x42, 0x86.toByte(), 0x81.toByte(),
            0x01, 0x42, 0xF7.toByte(), 0x81.toByte(),
            'm'.code.toByte(), 'a'.code.toByte(), 't'.code.toByte(), 'r'.code.toByte()
        )
        val mkvSpec = LocalStreamServer.sniffContainerFromHeader(mkvBytes, "video/mp4")
        assertEquals("mkv", mkvSpec.extension)
        assertEquals("video/x-matroska", mkvSpec.mimeType)

        val mp4Bytes = byteArrayOf(
            0x00, 0x00, 0x00, 0x18,
            'f'.code.toByte(), 't'.code.toByte(), 'y'.code.toByte(), 'p'.code.toByte(),
            'i'.code.toByte(), 's'.code.toByte(), 'o'.code.toByte(), 'm'.code.toByte()
        )
        val mp4Spec = LocalStreamServer.sniffContainerFromHeader(mp4Bytes, "video/x-matroska")
        assertEquals("mp4", mp4Spec.extension)
        assertEquals("video/mp4", mp4Spec.mimeType)
    }

    @Test
    fun formatsAndParsesUpnpDurationAndDidlMetadataCleanly() {
        assertEquals("01:25:09", DlnaSoapBuilder.formatMsToRelTime(5_109_400L))
        assertEquals(5_109_500L, DlnaSoapBuilder.parseDurationToMs("01:25:09.500"))
        assertEquals(0L, DlnaSoapBuilder.parseDurationToMs("NOT_IMPLEMENTED"))

        val didl = DlnaSoapBuilder.buildDidlLiteMetadata(
            streamUrl = "http://192.168.1.33:41234/stream/cineflix.mkv",
            title = "Spider-Man & Venom <4K>",
            mimeType = "video/x-matroska",
            fileSizeBytes = 4_294_967_296L,
            durationMs = 7_200_000L
        )
        assertTrue(didl.contains("Spider-Man &amp; Venom &lt;4K&gt;"))
        assertTrue(didl.contains("http-get:*:video/x-matroska:DLNA.ORG_OP=01"))
        assertTrue(didl.contains("duration=\"02:00:00\""))

        val soap = DlnaSoapBuilder.buildSetAvTransportUriSoap(
            "http://192.168.1.33:41234/stream/cineflix.mkv",
            didl
        )
        assertNotNull(UpnpXmlParser.parsePositionInfoResponse(soap))
    }

    @Test
    fun parsesPositionInfoAndTransportInfoSoapResponses() {
        val posSoap = """
            <?xml version="1.0"?>
            <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
              <s:Body>
                <u:GetPositionInfoResponse xmlns:u="urn:schemas-upnp-org:service:AVTransport:1">
                  <Track>1</Track>
                  <TrackDuration>02:10:00</TrackDuration>
                  <RelTime>00:45:30</RelTime>
                </u:GetPositionInfoResponse>
              </s:Body>
            </s:Envelope>
        """.trimIndent()

        val snap = UpnpXmlParser.parsePositionInfoResponse(posSoap)
        assertNotNull(snap)
        assertEquals(2_730_000L, snap!!.positionMs)
        assertEquals(7_800_000L, snap.durationMs)

        val transportSoap = """
            <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
              <s:Body>
                <u:GetTransportInfoResponse xmlns:u="urn:schemas-upnp-org:service:AVTransport:1">
                  <CurrentTransportState>PLAYING</CurrentTransportState>
                </u:GetTransportInfoResponse>
              </s:Body>
            </s:Envelope>
        """.trimIndent()
        assertEquals("PLAYING", UpnpXmlParser.parseTransportStateResponse(transportSoap))

        val allowedTransformsSoap = """
            <?xml version="1.0" encoding="utf-8"?>
            <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/" s:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">
              <s:Body>
                <u:GetAllowedTransformsResponse xmlns:u="urn:schemas-upnp-org:service:RenderingControl:1">
                  <CurrentAllowedTransformSettings>&lt;TransformSettings xmlns=&quot;urn:schemas-upnp-org:av:rc-transformSettings&quot;&gt;&lt;transform name=&quot;Subtitle&quot; shared=&quot;0&quot;&gt;&lt;friendlyName&gt;Subtitle&lt;/friendlyName&gt;&lt;allowedValueList&gt;&lt;allowedValue&gt;Subtitle_[0]&lt;/allowedValue&gt;&lt;allowedValue&gt;Espa&#241;ol&lt;/allowedValue&gt;&lt;allowedValue&gt;Idioma original&lt;/allowedValue&gt;&lt;/allowedValueList&gt;&lt;/transform&gt;&lt;transform name=&quot;X_Philips.com_Codepage&quot; shared=&quot;0&quot;&gt;&lt;friendlyName&gt;CharacterSet&lt;/friendlyName&gt;&lt;allowedValueList&gt;&lt;allowedValue&gt;Defecto&lt;/allowedValue&gt;&lt;allowedValue&gt;UTF-8&lt;/allowedValue&gt;&lt;/allowedValueList&gt;&lt;/transform&gt;&lt;/TransformSettings&gt;</CurrentAllowedTransformSettings>
                </u:GetAllowedTransformsResponse>
              </s:Body>
            </s:Envelope>
        """.trimIndent()
        val parsedTransforms = UpnpXmlParser.parseAllowedTransformsResponse(allowedTransformsSoap)
        assertNotNull(parsedTransforms)
        assertEquals(listOf("Español", "Idioma original"), parsedTransforms!!.subtitleValues)
        assertEquals(listOf("Defecto", "UTF-8"), parsedTransforms.codepageValues)

        val setSubSoap = DlnaSoapBuilder.buildSetTransformsSoap("Subtitle", "Español")
        assertTrue(setSubSoap.contains("name=&quot;Subtitle&quot;"))
        assertTrue(setSubSoap.contains("&lt;value&gt;Español&lt;/value&gt;"))
    }

    @Test
    fun executesFullSoapHandshakeWithTier2FallbackAndInitialResumeSeek() {
        val receivedActions = CopyOnWriteArrayList<String>()
        val receivedSetTransforms = CopyOnWriteArrayList<String>()
        val seekLatch = CountDownLatch(1)
        val setTransformsLatch = CountDownLatch(2)
        val setUriAttempts = AtomicInteger(0)
        val lastSeekTarget = java.util.concurrent.atomic.AtomicReference("")
        val serverRunning = AtomicBoolean(true)

        val serverSocket = ServerSocket(0, 16, InetAddress.getByName("127.0.0.1"))
        val pool = Executors.newCachedThreadPool()
        pool.execute {
            while (serverRunning.get() && !serverSocket.isClosed) {
                try {
                    val client = serverSocket.accept()
                    pool.execute {
                        client.use { sock ->
                            val reader = BufferedReader(InputStreamReader(sock.getInputStream(), StandardCharsets.ISO_8859_1))
                            val reqLine = reader.readLine() ?: return@use
                            if (reqLine.isEmpty()) return@use
                            var soapActionHeader = ""
                            var contentLength = 0
                            var line = reader.readLine()
                            while (!line.isNullOrEmpty()) {
                                if (line.startsWith("SOAPAction:", ignoreCase = true)) {
                                    soapActionHeader = line.substringAfter(':').trim()
                                } else if (line.startsWith("Content-Length:", ignoreCase = true)) {
                                    contentLength = line.substringAfter(':').trim().toIntOrNull() ?: 0
                                }
                                line = reader.readLine()
                            }
                            val bodyChars = CharArray(contentLength)
                            var readTotal = 0
                            while (readTotal < contentLength) {
                                val r = reader.read(bodyChars, readTotal, contentLength - readTotal)
                                if (r < 0) break
                                readTotal += r
                            }
                            val reqBody = String(
                                String(bodyChars, 0, readTotal).toByteArray(StandardCharsets.ISO_8859_1),
                                StandardCharsets.UTF_8
                            )
                            val action = soapActionHeader.substringAfter('#').trim('"')
                            receivedActions.add(action)

                            val (statusCode, respXml) = when (action) {
                                "SetAVTransportURI" -> {
                                    val attempt = setUriAttempts.incrementAndGet()
                                    if (attempt == 1) {
                                        500 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><s:Fault><detail><UPnPError><errorCode>714</errorCode></UPnPError></detail></s:Fault></s:Body></s:Envelope>"
                                    } else {
                                        val okMkv = reqBody.contains("video/x-mkv")
                                        if (okMkv) {
                                            200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:SetAVTransportURIResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                        } else {
                                            500 to "<s:Envelope/>"
                                        }
                                    }
                                }
                                "GetTransportInfo" -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetTransportInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><CurrentTransportState>PLAYING</CurrentTransportState></u:GetTransportInfoResponse></s:Body></s:Envelope>"
                                }
                                "Seek" -> {
                                    lastSeekTarget.set(reqBody.substringAfter("<Target>").substringBefore("</Target>"))
                                    seekLatch.countDown()
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:SeekResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                }
                                "GetPositionInfo" -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetPositionInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><TrackDuration>02:00:00</TrackDuration><RelTime>00:10:00</RelTime></u:GetPositionInfoResponse></s:Body></s:Envelope>"
                                }
                                "GetAllowedTransforms" -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetAllowedTransformsResponse xmlns:u=\"urn:schemas-upnp-org:service:RenderingControl:1\"><CurrentAllowedTransformSettings>&lt;TransformSettings xmlns=&quot;urn:schemas-upnp-org:av:rc-transformSettings&quot;&gt;&lt;transform name=&quot;Subtitle&quot; shared=&quot;0&quot;&gt;&lt;friendlyName&gt;Subtitle&lt;/friendlyName&gt;&lt;allowedValueList&gt;&lt;allowedValue&gt;Subtitle_[0]&lt;/allowedValue&gt;&lt;allowedValue&gt;Espa&#241;ol&lt;/allowedValue&gt;&lt;allowedValue&gt;Idioma original&lt;/allowedValue&gt;&lt;/allowedValueList&gt;&lt;/transform&gt;&lt;transform name=&quot;X_Philips.com_Codepage&quot; shared=&quot;0&quot;&gt;&lt;friendlyName&gt;CharacterSet&lt;/friendlyName&gt;&lt;allowedValueList&gt;&lt;allowedValue&gt;Defecto&lt;/allowedValue&gt;&lt;allowedValue&gt;UTF-8&lt;/allowedValue&gt;&lt;/allowedValueList&gt;&lt;/transform&gt;&lt;/TransformSettings&gt;</CurrentAllowedTransformSettings></u:GetAllowedTransformsResponse></s:Body></s:Envelope>"
                                }
                                "SetTransforms" -> {
                                    receivedSetTransforms.add(reqBody)
                                    setTransformsLatch.countDown()
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:SetTransformsResponse xmlns:u=\"urn:schemas-upnp-org:service:RenderingControl:1\"/></s:Body></s:Envelope>"
                                }
                                else -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:${action}Response xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                }
                            }

                            val bodyBytes = respXml.toByteArray(StandardCharsets.UTF_8)
                            val reason = if (statusCode == 200) "OK" else "Internal Server Error"
                            val header = "HTTP/1.1 $statusCode $reason\r\n" +
                                         "Content-Type: text/xml; charset=\"utf-8\"\r\n" +
                                         "Content-Length: ${bodyBytes.size}\r\n" +
                                         "Connection: close\r\n\r\n"
                            val out = sock.getOutputStream()
                            out.write(header.toByteArray(StandardCharsets.US_ASCII))
                            out.write(bodyBytes)
                            out.flush()
                        }
                    }
                } catch (_: Exception) {
                    break
                }
            }
        }

        val port = serverSocket.localPort
        val device = DlnaDevice(
            udn = "uuid:mock-tizen",
            friendlyName = "Samsung Mock TV",
            manufacturer = "Samsung",
            modelName = "Tizen",
            locationUrl = "http://127.0.0.1:$port/dmr",
            host = "127.0.0.1",
            avTransportControlUrl = "http://127.0.0.1:$port/upnp/control/AVTransport1",
            renderingControlUrl = "http://127.0.0.1:$port/upnp/control/RenderingControl1"
        )

        val controller = DlnaCastController()
        try {
            controller.startSession(
                device = device,
                streamUrl = "http://127.0.0.1:49999/stream/cineflix.mkv",
                title = "Spider-Man Test",
                mimeType = "video/x-matroska",
                fileSizeBytes = 4_000_000_000L,
                startPositionMs = 600_000L, // 10:00
                durationHintMs = 7_200_000L,
                subtitleSrtUrl = "http://127.0.0.1:49999/stream/cineflix.srt"
            )

            assertTrue("Expected initial resume Seek within 5s", seekLatch.await(5, TimeUnit.SECONDS))
            assertTrue("Expected RenderingControl SetTransforms (Subtitle + Codepage) within 5s", setTransformsLatch.await(5, TimeUnit.SECONDS))
            assertEquals("00:10:00", lastSeekTarget.get())
            assertEquals(2, setUriAttempts.get())
            assertTrue(receivedActions.contains("Stop"))
            assertTrue(receivedActions.contains("SetAVTransportURI"))
            assertTrue(receivedActions.contains("Play"))
            assertTrue(receivedActions.contains("Seek"))
            assertTrue(receivedActions.contains("GetAllowedTransforms"))
            assertTrue(receivedActions.contains("SetTransforms"))
            assertTrue(receivedSetTransforms.any { it.contains("name=&quot;Subtitle&quot;") && it.contains("&lt;value&gt;Español&lt;/value&gt;") })
            assertTrue(receivedSetTransforms.any { it.contains("name=&quot;X_Philips.com_Codepage&quot;") && it.contains("&lt;value&gt;UTF-8&lt;/value&gt;") })
        } finally {
            serverRunning.set(false)
            controller.destroy()
            try { serverSocket.close() } catch (_: Exception) {}
            pool.shutdownNow()
        }
    }

    @Test
    fun detectsLegacySamsungOrsayWithoutAffectingModernTizen() {
        val orsayF6400Xml = """
            <?xml version="1.0"?>
            <root xmlns="urn:schemas-upnp-org:device-1-0" xmlns:sec="http://www.sec.co.kr/dlna">
              <device>
                <deviceType>urn:schemas-upnp-org:device:MediaRenderer:1</deviceType>
                <friendlyName>[TV]Samsung LED40</friendlyName>
                <manufacturer>Samsung Electronics</manufacturer>
                <modelName>UE40F6400</modelName>
                <UDN>uuid:orsay-ue40f6400</UDN>
                <sec:ProductCap>Resolution:1920X1080,Y2013</sec:ProductCap>
                <serviceList>
                  <service>
                    <serviceType>urn:schemas-upnp-org:service:AVTransport:1</serviceType>
                    <controlURL>/upnp/control/AVTransport1</controlURL>
                  </service>
                </serviceList>
              </device>
            </root>
        """.trimIndent()

        val orsayDev = UpnpXmlParser.parseDeviceDescription(orsayF6400Xml, "http://192.168.1.40:7676/smp_15_")
        assertNotNull(orsayDev)
        assertTrue("UE40F6400 (2013/2014) must be flagged as legacy Samsung Orsay", orsayDev!!.isLegacySamsungOrsay)
        assertFalse(orsayDev.isConfirmedModernTizen)
        assertFalse(orsayDev.isSamsungNoDtsTizen)
        assertTrue(orsayDev.isSamsung)
        assertEquals("Samsung Smart TV (Compat.) • Directo", orsayDev.brandBadge)

        // Modern Samsung S95B (2022 Tizen OLED) & CU7105 (2023 Tizen Crystal UHD) must NOT be flagged as Orsay
        val s95bXml = """
            <?xml version="1.0"?>
            <root xmlns="urn:schemas-upnp-org:device-1-0" xmlns:sec="http://www.sec.co.kr/dlna">
              <device>
                <deviceType>urn:schemas-upnp-org:device:MediaRenderer:1</deviceType>
                <friendlyName>Samsung S95B 65 OLED</friendlyName>
                <manufacturer>Samsung Electronics</manufacturer>
                <modelName>QE65S95B</modelName>
                <UDN>uuid:tizen-s95b-2022</UDN>
                <sec:ProductCap>Tizen,Y2022</sec:ProductCap>
                <serviceList>
                  <service>
                    <serviceType>urn:schemas-upnp-org:service:AVTransport:1</serviceType>
                    <controlURL>/upnp/control/AVTransport1</controlURL>
                  </service>
                </serviceList>
              </device>
            </root>
        """.trimIndent()

        val s95bDev = UpnpXmlParser.parseDeviceDescription(s95bXml, "http://192.168.1.95:9197/dmr")
        assertNotNull(s95bDev)
        assertFalse("Samsung S95B (2022 Tizen) must NOT use Orsay mode", s95bDev!!.isLegacySamsungOrsay)
        assertTrue("Samsung S95B (2022 Tizen) must be recognized as modern Tizen", s95bDev.isConfirmedModernTizen)
        assertTrue("Samsung S95B (2022 Tizen) must be flagged as 2018+ no-DTS Samsung", s95bDev.isSamsungNoDtsTizen)
        assertEquals("Samsung Smart TV • Directo", s95bDev.brandBadge)

        assertFalse(
            "Samsung UE55CU7105 (2023 Crystal UHD) must NOT use Orsay mode",
            DlnaDevice.detectLegacySamsungOrsay("Samsung Electronics", "UE55CU7105", "[TV] Samsung 7 Series")
        )
        assertTrue(
            "Samsung UE55CU7105 (2023 Crystal UHD) must be recognized as modern Tizen",
            DlnaDevice.detectModernSamsungTizen("Samsung Electronics", "UE55CU7105", "[TV] Samsung 7 Series")
        )
        assertTrue(
            "Samsung UE55CU7105 (2023 Crystal UHD) must be flagged as 2018+ no-DTS Samsung",
            DlnaDevice.detectSamsungNoDtsTizen("Samsung Electronics", "UE55CU7105", "[TV] Samsung 7 Series")
        )
        assertFalse(
            "Samsung UE55JU6800 (2015 Tizen 4K) must NOT be hardcoded as H.264-only Orsay",
            DlnaDevice.detectLegacySamsungOrsay("Samsung Electronics", "UE55JU6800", "[TV] Samsung JU6800")
        )
    }

    @Test
    fun patchesMatroskaEbmlTracksInPlacePreservingExactByteLengthAndBoundaryRanges() {
        // Test BOTH with <CRC-32> AND without <CRC-32> (tightest byte budget, realistic mkvmerge omitted FlagDefault!)
        for (includeCrc32 in listOf(true, false)) {
            val mkvBytes = buildSyntheticMultiTrackMatroska(includeCrc = includeCrc32)

            val parsed = MatroskaEbmlTrackPatcher.parseHeader(mkvBytes)
            assertNotNull("Expected synthetic Matroska header (crc=$includeCrc32) to parse cleanly", parsed)
            val info = parsed!!

            assertEquals(1, info.videoTracks.size)
            assertEquals("V_MPEG4/ISO/AVC", info.videoTracks[0].codecId)
            assertFalse(info.hasHevcVideo)

            assertEquals(2, info.audioTracks.size)
            assertEquals(2, info.audioTracks[0].trackNumber)
            assertEquals("spa", info.audioTracks[0].language)
            assertEquals("Castellano", info.audioTracks[0].name)
            assertEquals(6, info.audioTracks[0].channels)
            assertTrue("Omitted FlagDefault in mkvmerge must parse as isDefault=true", info.audioTracks[0].isDefault)

            assertEquals(3, info.audioTracks[1].trackNumber)
            assertEquals("eng", info.audioTracks[1].language)
            assertEquals("English", info.audioTracks[1].name)
            assertEquals(6, info.audioTracks[1].channels)
            assertFalse(info.audioTracks[1].isDefault)

            assertEquals(2, info.subtitleTracks.size)
            assertEquals(4, info.subtitleTracks[0].trackNumber)
            assertTrue(info.subtitleTracks[0].isDefault)
            assertTrue(info.subtitleTracks[0].isForced)
            assertEquals(5, info.subtitleTracks[1].trackNumber)
            assertFalse(info.subtitleTracks[1].isDefault)
            assertFalse("Omitted FlagForced in mkvmerge must parse as isForced=false", info.subtitleTracks[1].isForced)

            // 1. Select Audio #3 (English, ordinal=1) and Subtitle #5 (English Full, ordinal=1)
            val regionPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                info = info,
                selectedAudioTrackNumber = null,
                selectedAudioOrdinal = 1,
                subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE,
                selectedSubtitleTrackNumber = null,
                selectedSubtitleOrdinal = 1
            )
            assertNotNull("Expected non-null <Tracks> region patch (crc=$includeCrc32)", regionPatch)

            val fullPatched = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = mkvBytes,
                sliceOffset = 0,
                sliceLength = mkvBytes.size,
                rangeGlobalStart = 0L,
                patch = regionPatch
            )
            assertNotNull(fullPatched)
            assertEquals("Exact-size <Tracks> rebuild MUST preserve total file byte count", mkvBytes.size, fullPatched!!.size)

            // Every single byte of <Cluster> after tracksElementEnd must remain 100% untouched
            val clusterStart = info.tracksElementEnd.toInt()
            assertArrayEquals(
                mkvBytes.copyOfRange(clusterStart, mkvBytes.size),
                fullPatched.copyOfRange(clusterStart, fullPatched.size)
            )

            // Re-parse patched stream:
            //  - BOTH Audio TrackNumber=3 AND TrackNumber=2 MUST remain registered in <Tracks> (zero orphan SimpleBlocks!)
            //  - Audio #3 (English) is FIRST with FlagDefault=1 and Language="eng"
            //  - Audio #2 (Castellano) is SECOND with explicit FlagDefault=0 and Language="" ("und")
            //  - Subtitle #5 is isolated with BOTH FlagDefault=1 AND FlagForced=1
            val reparsed = MatroskaEbmlTrackPatcher.parseHeader(fullPatched)
            assertNotNull("Rebuilt <Tracks> (crc=$includeCrc32) must re-parse cleanly", reparsed)
            assertEquals(1, reparsed!!.videoTracks.size)
            assertEquals(2, reparsed.audioTracks.size)

            assertEquals(3, reparsed.audioTracks[0].trackNumber)
            assertEquals("eng", reparsed.audioTracks[0].language)
            assertTrue("Chosen audio track must be FIRST and have FlagDefault=1", reparsed.audioTracks[0].isDefault)
            assertEquals(6, reparsed.audioTracks[0].channels)

            assertEquals(2, reparsed.audioTracks[1].trackNumber)
            assertFalse("Unselected audio track MUST have explicit FlagDefault=0", reparsed.audioTracks[1].isDefault)
            assertEquals(
                "Unselected audio track must have neutralized Language ('und' -> '') so Spanish TVs don't override user choice",
                "",
                reparsed.audioTracks[1].language
            )
            assertEquals(6, reparsed.audioTracks[1].channels)

            assertEquals(2, reparsed.subtitleTracks.size)
            assertEquals(5, reparsed.subtitleTracks[0].trackNumber)
            assertEquals("eng", reparsed.subtitleTracks[0].language)
            assertTrue("Selected subtitle track must have FlagDefault=1", reparsed.subtitleTracks[0].isDefault)
            assertTrue("Selected subtitle track must have FlagForced=1", reparsed.subtitleTracks[0].isForced)
            assertEquals(4, reparsed.subtitleTracks[1].trackNumber)
            assertFalse("Unselected subtitle track must have FlagDefault=0", reparsed.subtitleTracks[1].isDefault)
            assertFalse("Unselected subtitle track must have FlagForced=0", reparsed.subtitleTracks[1].isForced)
            assertEquals("", reparsed.subtitleTracks[1].language)
            assertTrue("Patched <Tracks> must have 0 remaining active CRC-32 elements", reparsed.tracksCrcIdOffsets.isEmpty())

            // 2. Verify Audio-only switch (SubtitlePatchMode.UNCHANGED — tightest possible byte budget!)
            val audioOnlyPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                info = info,
                selectedAudioOrdinal = 1,
                subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED
            )
            assertNotNull("Audio-only switch with UNCHANGED subtitles must fit exact <Tracks> budget (crc=$includeCrc32)", audioOnlyPatch)
            val audioOnlyBytes = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = mkvBytes,
                sliceOffset = 0,
                sliceLength = mkvBytes.size,
                rangeGlobalStart = 0L,
                patch = audioOnlyPatch
            )!!
            assertEquals(mkvBytes.size, audioOnlyBytes.size)
            val reparsedAudioOnly = MatroskaEbmlTrackPatcher.parseHeader(audioOnlyBytes)!!
            assertEquals(2, reparsedAudioOnly.audioTracks.size)
            assertEquals(3, reparsedAudioOnly.audioTracks[0].trackNumber)
            assertTrue(reparsedAudioOnly.audioTracks[0].isDefault)
            assertEquals(2, reparsedAudioOnly.audioTracks[1].trackNumber)
            assertFalse(reparsedAudioOnly.audioTracks[1].isDefault)
            assertEquals(2, reparsedAudioOnly.subtitleTracks.size)

            // 3. Verify arbitrary split HTTP Range requests produce the exact same bytes as full-buffer patching
            val splitBoundaries = listOf(0, 19, 63, 117, 181, mkvBytes.size)
            val reassembled = ByteArrayOutputStream(mkvBytes.size)
            for (i in 0 until splitBoundaries.size - 1) {
                val start = splitBoundaries[i]
                val end = splitBoundaries[i + 1]
                val len = end - start
                val patchedSlice = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                    sourceBuffer = mkvBytes,
                    sliceOffset = start,
                    sliceLength = len,
                    rangeGlobalStart = start.toLong(),
                    patch = regionPatch
                ) ?: mkvBytes.copyOfRange(start, end)
                reassembled.write(patchedSlice)
            }
            assertArrayEquals(
                "Chunked HTTP Range patching across arbitrary boundaries must match full-file patching byte-for-byte",
                fullPatched,
                reassembled.toByteArray()
            )

            // Ranges inside media <Cluster> (after tracksElementEnd) must return null (zero-copy fast path)
            val clusterPatch = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = mkvBytes,
                sliceOffset = clusterStart,
                sliceLength = mkvBytes.size - clusterStart,
                rangeGlobalStart = clusterStart.toLong(),
                patch = regionPatch
            )
            assertNull("Media Cluster ranges must take zero-copy fast path (null)", clusterPatch)

            // 4. Verify SubtitlePatchMode.DISABLE_ALL hides all embedded subtitles while keeping all audio tracks
            val disableSubsPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                info = info,
                selectedAudioOrdinal = 0,
                subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
            )
            val subsDisabledBytes = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = mkvBytes,
                sliceOffset = 0,
                sliceLength = mkvBytes.size,
                rangeGlobalStart = 0L,
                patch = disableSubsPatch
            )!!
            val reparsedNoSubs = MatroskaEbmlTrackPatcher.parseHeader(subsDisabledBytes)!!
            assertEquals(2, reparsedNoSubs.audioTracks.size)
            assertEquals(2, reparsedNoSubs.audioTracks[0].trackNumber)
            assertEquals("spa", reparsedNoSubs.audioTracks[0].language)
            assertTrue(reparsedNoSubs.audioTracks[0].isDefault)
            assertEquals(3, reparsedNoSubs.audioTracks[1].trackNumber)
            assertFalse(reparsedNoSubs.audioTracks[1].isDefault)
            assertEquals("DISABLE_ALL must keep all subtitle <TrackEntry>s registered in <Tracks>", 2, reparsedNoSubs.subtitleTracks.size)
            for (sub in reparsedNoSubs.subtitleTracks) {
                assertFalse("DISABLE_ALL subtitle track must have FlagDefault=0", sub.isDefault)
                assertFalse("DISABLE_ALL subtitle track must have FlagForced=0", sub.isForced)
                assertEquals("DISABLE_ALL subtitle track must have neutralized Language", "", sub.language)
            }
        }

        // 5. Verify EBML <Void> exact-size builder across all VINT width boundaries (including 128, 129, 130, 16385, 16386)
        for (voidSize in listOf(2, 3, 127, 128, 129, 130, 512, 16384, 16385, 16386)) {
            val voidBytes = MatroskaEbmlTrackPatcher.buildEbmlVoidOfExactSize(voidSize)
            assertEquals("Expected exact <Void> byte length for $voidSize", voidSize, voidBytes.size)
            assertEquals(0xEC.toByte(), voidBytes[0])
        }
    }

    private fun buildSyntheticMultiTrackMatroska(includeCrc: Boolean = true): ByteArray {
        val out = ByteArrayOutputStream()

        // 1. <EBML> root header (0x1A45DFA3) with <DocType> = "matroska"
        val docType = ebmlElement(byteArrayOf(0x42, 0x82.toByte()), "matroska".toByteArray(StandardCharsets.US_ASCII))
        out.write(ebmlElement(byteArrayOf(0x1A, 0x45, 0xDF.toByte(), 0xA3.toByte()), docType))

        // 2. <Segment> (0x18538067) with unknown streaming size (0x01FFFFFFFFFFFFFF)
        out.write(byteArrayOf(0x18, 0x53, 0x80.toByte(), 0x67))
        out.write(
            byteArrayOf(
                0x01,
                0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(),
                0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
            )
        )

        // 3. <Tracks> (0x1654AE6B) with realistic mkvmerge omission of default FlagEnabled/FlagDefault/FlagForced!
        val tracksPayload = ByteArrayOutputStream()
        if (includeCrc) {
            tracksPayload.write(
                ebmlElement(
                    byteArrayOf(0xBF.toByte()),
                    byteArrayOf(0xDE.toByte(), 0xAD.toByte(), 0xBE.toByte(), 0xEF.toByte())
                )
            )
        }
        // Video #1 (H.264, FlagDefault omitted = 1)
        tracksPayload.write(
            buildTrackEntry(
                trackNumber = 1,
                trackType = MatroskaEbmlTrackPatcher.TRACK_TYPE_VIDEO,
                flagEnabled = null,
                flagDefault = null,
                flagForced = null,
                language = "und",
                name = "Video 1080p",
                codecId = "V_MPEG4/ISO/AVC",
                channels = 0
            )
        )
        // Audio #2 (Castellano E-AC3 5.1, FlagDefault OMITTED = 1, just like real mkvmerge!)
        tracksPayload.write(
            buildTrackEntry(
                trackNumber = 2,
                trackType = MatroskaEbmlTrackPatcher.TRACK_TYPE_AUDIO,
                flagEnabled = null,
                flagDefault = null,
                flagForced = null,
                language = "spa",
                name = "Castellano",
                codecId = "A_EAC3",
                channels = 6
            )
        )
        // Audio #3 (English AC3 5.1, FlagDefault=0)
        tracksPayload.write(
            buildTrackEntry(
                trackNumber = 3,
                trackType = MatroskaEbmlTrackPatcher.TRACK_TYPE_AUDIO,
                flagEnabled = null,
                flagDefault = 0,
                flagForced = null,
                language = "eng",
                name = "English",
                codecId = "A_AC3",
                channels = 6
            )
        )
        // Subtitle #4 (Castellano Forzados SRT, FlagDefault omitted = 1, FlagForced=1)
        tracksPayload.write(
            buildTrackEntry(
                trackNumber = 4,
                trackType = MatroskaEbmlTrackPatcher.TRACK_TYPE_SUBTITLE,
                flagEnabled = null,
                flagDefault = null,
                flagForced = 1,
                language = "spa",
                name = "Forzados",
                codecId = "S_TEXT/UTF8",
                channels = 0
            )
        )
        // Subtitle #5 (English Full SRT, FlagDefault=0, FlagForced OMITTED = 0, just like real mkvmerge!)
        tracksPayload.write(
            buildTrackEntry(
                trackNumber = 5,
                trackType = MatroskaEbmlTrackPatcher.TRACK_TYPE_SUBTITLE,
                flagEnabled = null,
                flagDefault = 0,
                flagForced = null,
                language = "eng",
                name = "English Full",
                codecId = "S_TEXT/UTF8",
                channels = 0
            )
        )
        out.write(
            ebmlElement(
                byteArrayOf(0x16, 0x54, 0xAE.toByte(), 0x6B),
                tracksPayload.toByteArray()
            )
        )

        // 4. <Cluster> (0x1F43B675) with mock media payload
        val mockClusterData = ByteArray(48) { idx -> (idx + 1).toByte() }
        out.write(
            ebmlElement(
                byteArrayOf(0x1F, 0x43, 0xB6.toByte(), 0x75),
                mockClusterData
            )
        )

        return out.toByteArray()
    }

    private fun buildTrackEntry(
        trackNumber: Int,
        trackType: Int,
        flagEnabled: Int?,
        flagDefault: Int?,
        flagForced: Int?,
        language: String,
        name: String,
        codecId: String,
        channels: Int
    ): ByteArray {
        val entry = ByteArrayOutputStream()
        entry.write(ebmlElement(byteArrayOf(0xD7.toByte()), byteArrayOf(trackNumber.toByte())))
        entry.write(ebmlElement(byteArrayOf(0x83.toByte()), byteArrayOf(trackType.toByte())))
        if (flagEnabled != null) {
            entry.write(ebmlElement(byteArrayOf(0xB9.toByte()), byteArrayOf(flagEnabled.toByte())))
        }
        if (flagDefault != null) {
            entry.write(ebmlElement(byteArrayOf(0x88.toByte()), byteArrayOf(flagDefault.toByte())))
        }
        if (flagForced != null) {
            entry.write(ebmlElement(byteArrayOf(0x55, 0xAA.toByte()), byteArrayOf(flagForced.toByte())))
        }
        entry.write(
            ebmlElement(
                byteArrayOf(0x22, 0xB5.toByte(), 0x9C.toByte()),
                language.toByteArray(StandardCharsets.US_ASCII)
            )
        )
        entry.write(
            ebmlElement(
                byteArrayOf(0x53, 0x6E),
                name.toByteArray(StandardCharsets.UTF_8)
            )
        )
        entry.write(
            ebmlElement(
                byteArrayOf(0x86.toByte()),
                codecId.toByteArray(StandardCharsets.US_ASCII)
            )
        )
        if (channels > 0) {
            val audioSettings = ebmlElement(byteArrayOf(0x9F.toByte()), byteArrayOf(channels.toByte()))
            entry.write(ebmlElement(byteArrayOf(0xE1.toByte()), audioSettings))
        }
        return ebmlElement(byteArrayOf(0xAE.toByte()), entry.toByteArray())
    }

    private fun ebmlElement(idBytes: ByteArray, payload: ByteArray): ByteArray {
        val size = payload.size
        val sizeBytes = when {
            size < 127 -> byteArrayOf((0x80 or size).toByte())
            size < 16383 -> byteArrayOf(
                (0x40 or (size shr 8)).toByte(),
                (size and 0xFF).toByte()
            )
            else -> throw IllegalArgumentException("Payload too large for test helper: $size")
        }
        val out = ByteArrayOutputStream(idBytes.size + sizeBytes.size + payload.size)
        out.write(idBytes)
        out.write(sizeBytes)
        out.write(payload)
        return out.toByteArray()
    }

    @Test
    fun muxesIso188ByteMpegTsWithValidPatPmtCrc32AudSpsPpsAndAdtsAac() {
        val tsOut = ByteArrayOutputStream()
        val muxer = MpegTsMuxer(includeVideo = true, includeAudio = true) { buf, off, len ->
            tsOut.write(buf, off, len)
        }

        val fakeSps = byteArrayOf(0x67, 0x64, 0x00, 0x28, 0xAC.toByte(), 0xD9.toByte(), 0x40, 0x78)
        val fakePps = byteArrayOf(0x68, 0xEB.toByte(), 0xE3.toByte(), 0xCB.toByte())
        // 4-byte length-prefixed IDR slice (NAL type 5 -> 0x65)
        val lengthPrefixedIdr = byteArrayOf(
            0x00, 0x00, 0x00, 0x06,
            0x65, 0x88.toByte(), 0x84.toByte(), 0x21, 0xA0.toByte(), 0x0F
        )
        val annexBIdr = H264NalConverter.toAnnexB(lengthPrefixedIdr, nalLengthSize = 4)
        assertTrue("Converted IDR sample must contain NAL type 5", H264NalConverter.containsNalType(annexBIdr, 5))

        muxer.writeH264Sample(
            annexBNalsWithoutAud = annexBIdr,
            ptsUs = 0L,
            isKeyFrame = true,
            spsList = listOf(fakeSps),
            ppsList = listOf(fakePps)
        )
        val fakeRawAac = ByteArray(128) { idx -> (idx xor 0x5A).toByte() }
        muxer.writeAacFrame(
            rawAacData = fakeRawAac,
            ptsUs = 0L,
            sampleRate = 48000,
            channelCount = 2
        )

        val tsBytes = tsOut.toByteArray()
        assertTrue("Expected at least 4 TS packets (PAT, PMT, Video, Audio)", tsBytes.size >= 4 * 188)
        assertEquals("MPEG-TS output must be strictly 188-byte aligned", 0, tsBytes.size % 188)

        val totalPackets = tsBytes.size / 188
        var sawPat = false
        var sawPmt = false
        var sawVideoPid = false
        var sawAudioPid = false

        for (p in 0 until totalPackets) {
            val base = p * 188
            assertEquals("Every 188-byte TS packet must start with 0x47 sync byte", 0x47.toByte(), tsBytes[base])
            val pid = ((tsBytes[base + 1].toInt() and 0x1F) shl 8) or (tsBytes[base + 2].toInt() and 0xFF)
            when (pid) {
                MpegTsMuxer.PID_PAT -> {
                    sawPat = true
                    // PAT section starts at base + 5, total length = 12 + 4 CRC = 16 bytes; MPEG-2 CRC over section+CRC MUST be 0!
                    assertEquals(0, MpegTsMuxer.computeMpeg2Crc32(tsBytes, base + 5, 16))
                }
                MpegTsMuxer.PID_PMT -> {
                    sawPmt = true
                    // PMT with 1 video + 1 audio stream: 12 + (2 * 5) + 4 CRC = 26 bytes; MPEG-2 CRC over section+CRC MUST be 0!
                    assertEquals(0, MpegTsMuxer.computeMpeg2Crc32(tsBytes, base + 5, 26))
                }
                MpegTsMuxer.PID_VIDEO -> sawVideoPid = true
                MpegTsMuxer.PID_AUDIO -> sawAudioPid = true
            }
        }

        assertTrue("Expected PAT packet on PID 0x0000", sawPat)
        assertTrue("Expected PMT packet on PID 0x1000", sawPmt)
        assertTrue("Expected H.264 Video PES packet on PID 0x0100", sawVideoPid)
        assertTrue("Expected ADTS AAC Audio PES packet on PID 0x0101", sawAudioPid)

        // Verify AUD (00 00 00 01 09 F0) and SPS (00 00 00 01 67 64) were injected into the TS video payload
        assertTrue(containsSubArray(tsBytes, byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x09, 0xF0.toByte())))
        assertTrue(containsSubArray(tsBytes, byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x67, 0x64)))
        // Verify 7-byte ADTS header (0xFF 0xF1) for 48kHz Stereo AAC-LC
        val adts = MpegTsMuxer.buildAdtsHeader(rawAacLength = 128, sampleRate = 48000, channelCount = 2)
        assertEquals(7, adts.size)
        assertEquals(0xFF.toByte(), adts[0])
        assertEquals(0xF1.toByte(), adts[1])
        assertTrue(containsSubArray(tsBytes, adts))
    }

    @Test
    fun parsesIsoAvccConfigDownmixes51And71PcmAndComputesSafe1080pDimensions() {
        // 1. ISO 14496-15 avcC record parser
        val sps = byteArrayOf(0x67, 0x64, 0x00, 0x1F, 0xAC.toByte())
        val pps = byteArrayOf(0x68, 0xEE.toByte(), 0x3C)
        val avcc = ByteArrayOutputStream().apply {
            write(byteArrayOf(0x01, 0x64, 0x00, 0x1F, 0xFF.toByte(), 0xE1.toByte()))
            write(byteArrayOf(0x00, sps.size.toByte()))
            write(sps)
            write(byteArrayOf(0x01, 0x00, pps.size.toByte()))
            write(pps)
        }.toByteArray()

        val parsedAvc = H264NalConverter.parseInitializationData(listOf(avcc))
        assertEquals(4, parsedAvc.nalLengthSize)
        assertEquals(1, parsedAvc.spsList.size)
        assertEquals(1, parsedAvc.ppsList.size)
        assertArrayEquals(sps, parsedAvc.spsList[0])
        assertArrayEquals(pps, parsedAvc.ppsList[0])

        // 2. 5.1 (6ch) @ 96kHz -> Stereo (2ch) @ 48kHz PCM downmixer + resampler
        val inFrames96k = 200
        val pcm51At96k = ByteArray(inFrames96k * 6 * 2)
        for (f in 0 until inFrames96k) {
            val base = f * 12
            // Center channel dialogue = +10000 (0x2710 LE -> 0x10, 0x27)
            pcm51At96k[base + 4] = 0x10
            pcm51At96k[base + 5] = 0x27
        }
        val targetRate = PcmStereoProcessor.chooseTargetAacSampleRate(96000)
        assertEquals(48000, targetRate)
        val stereo48k = PcmStereoProcessor.toStereo16BitPcm(
            pcm16Le = pcm51At96k,
            srcChannels = 6,
            srcSampleRate = 96000,
            targetSampleRate = targetRate
        )
        // 200 frames @ 96kHz -> 100 stereo frames @ 48kHz = 400 bytes
        assertEquals(100 * 4, stereo48k.size)
        val left0 = (stereo48k[0].toInt() and 0xFF) or (stereo48k[1].toInt() shl 8)
        val right0 = (stereo48k[2].toInt() and 0xFF) or (stereo48k[3].toInt() shl 8)
        assertEquals("Center dialogue must be balanced equally into Left and Right", left0, right0)
        assertTrue("Center dialogue must be clearly audible (~8500)", left0 in 8000..9000)

        // 3. Safe 8-aligned H.264 Level 4.0 dimensions (<= 1920x1080)
        assertEquals(1920 to 1080, EglTranscodeSurface.computeSafeH264Dimensions(3840, 2160))
        assertEquals(1280 to 720, EglTranscodeSurface.computeSafeH264Dimensions(1280, 720))
        val (uwW, uwH) = EglTranscodeSurface.computeSafeH264Dimensions(3840, 1606)
        assertEquals(1920, uwW)
        assertEquals(0, uwH % 8)
        assertTrue(uwH in 800..808)
    }

    @Test
    fun dlnaControllerLiveTranscodeModeRetriesMpegTtsMimeSkipsInitialSeekAndOffsetsPosition() {
        val serverSocket = ServerSocket(0, 16, InetAddress.getByName("127.0.0.1"))
        val receivedActions = CopyOnWriteArrayList<String>()
        val setUriAttempts = AtomicInteger(0)
        val progressUpdatedLatch = CountDownLatch(1)
        val serverRunning = AtomicBoolean(true)

        val pool = Executors.newCachedThreadPool()
        pool.execute {
            while (serverRunning.get() && !serverSocket.isClosed) {
                try {
                    val sock = serverSocket.accept()
                    pool.execute {
                        sock.use {
                            val reader = BufferedReader(InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))
                            var contentLength = 0
                            var soapAction = ""
                            while (true) {
                                val line = reader.readLine() ?: break
                                if (line.isEmpty()) break
                                if (line.startsWith("Content-Length:", ignoreCase = true)) {
                                    contentLength = line.substringAfter(":").trim().toIntOrNull() ?: 0
                                } else if (line.startsWith("SOAPAction:", ignoreCase = true)) {
                                    soapAction = line.substringAfter(":").trim().trim('"')
                                }
                            }
                            val bodyChars = CharArray(contentLength)
                            var readTotal = 0
                            while (readTotal < contentLength) {
                                val n = reader.read(bodyChars, readTotal, contentLength - readTotal)
                                if (n <= 0) break
                                readTotal += n
                            }
                            val reqBody = String(bodyChars, 0, readTotal)
                            val action = soapAction.substringAfter("#")
                            receivedActions.add(action)

                            val (statusCode, respXml) = when (action) {
                                "SetAVTransportURI" -> {
                                    val attempt = setUriAttempts.incrementAndGet()
                                    if (attempt == 1 && reqBody.contains("video/mp2t")) {
                                        // Simulate legacy Orsay / Bravia rejecting video/mp2t with UPnP 714
                                        500 to """
                                            <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
                                              <s:Body><s:Fault><detail>
                                                <UPnPError xmlns="urn:schemas-upnp-org:control-1-0">
                                                  <errorCode>714</errorCode>
                                                </UPnPError>
                                              </detail></s:Fault></s:Body>
                                            </s:Envelope>
                                        """.trimIndent()
                                    } else {
                                        assertTrue("Tier 2 must retry with video/vnd.dlna.mpeg-tts", reqBody.contains("video/vnd.dlna.mpeg-tts"))
                                        assertTrue("Live TS DIDL must include DLNA.ORG_OP=01;DLNA.ORG_CI=1", reqBody.contains("DLNA.ORG_OP=01;DLNA.ORG_CI=1"))
                                        assertFalse("Live TS DIDL must omit restrictive AVC_TS_MP_HD_AAC_MULT5_ISO profile", reqBody.contains("AVC_TS_MP_HD_AAC_MULT5_ISO"))
                                        assertTrue("Live TS DIDL must include virtual byte size attribute", reqBody.contains("size="))
                                        200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:SetAVTransportURIResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                    }
                                }
                                "GetTransportInfo" -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetTransportInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><CurrentTransportState>PLAYING</CurrentTransportState><CurrentTransportStatus>OK</CurrentTransportStatus><CurrentSpeed>1</CurrentSpeed></u:GetTransportInfoResponse></s:Body></s:Envelope>"
                                }
                                "GetPositionInfo" -> {
                                    // TV reports 00:01:30 (90,000ms) into the live transcoded TS stream
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetPositionInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><TrackDuration>00:00:00</TrackDuration><RelTime>00:01:30</RelTime></u:GetPositionInfoResponse></s:Body></s:Envelope>"
                                }
                                else -> {
                                    200 to "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:${action}Response xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                }
                            }

                            val bodyBytes = respXml.toByteArray(StandardCharsets.UTF_8)
                            val reason = if (statusCode == 200) "OK" else "Internal Server Error"
                            val header = "HTTP/1.1 $statusCode $reason\r\n" +
                                "Content-Type: text/xml; charset=\"utf-8\"\r\n" +
                                "Content-Length: ${bodyBytes.size}\r\n" +
                                "Connection: close\r\n\r\n"
                            val out = sock.getOutputStream()
                            out.write(header.toByteArray(StandardCharsets.US_ASCII))
                            out.write(bodyBytes)
                            out.flush()
                        }
                    }
                } catch (_: Exception) {
                    break
                }
            }
        }

        val port = serverSocket.localPort
        val orsayDevice = DlnaDevice(
            udn = "uuid:orsay-ue40f6400",
            friendlyName = "Samsung UE40F6400",
            manufacturer = "Samsung Electronics",
            modelName = "UE40F6400",
            locationUrl = "http://127.0.0.1:$port/smp_15_",
            host = "127.0.0.1",
            avTransportControlUrl = "http://127.0.0.1:$port/upnp/control/AVTransport1"
        )

        val controller = DlnaCastController()
        val observedPos = AtomicInteger(0)
        val observedDur = AtomicInteger(0)
        controller.listener = object : DlnaCastController.Listener {
            override fun onConnecting(device: DlnaDevice) {}
            override fun onPlaybackStarted(device: DlnaDevice) {}
            override fun onProgressUpdated(device: DlnaDevice, positionMs: Long, durationMs: Long, isPlaying: Boolean) {
                if (positionMs >= 1_890_000L) {
                    observedPos.set(positionMs.toInt())
                    observedDur.set(durationMs.toInt())
                    progressUpdatedLatch.countDown()
                }
            }
            override fun onPlaybackEndedNaturally(device: DlnaDevice, finalPositionMs: Long, durationMs: Long) {}
            override fun onPlaybackStopped(device: DlnaDevice, lastPositionMs: Long) {}
            override fun onError(device: DlnaDevice, message: String) {}
        }

        try {
            controller.startSession(
                device = orsayDevice,
                streamUrl = "http://127.0.0.1:49999/stream/live_transcode.ts?sid=1&startMs=1800000&v=1&orsay=1",
                title = "Dune Part Two (HEVC -> Phone H.264)",
                mimeType = "video/mp2t",
                fileSizeBytes = 15_000_000_000L,
                startPositionMs = 0L,
                durationHintMs = 7_200_000L,
                isLiveTranscode = true,
                basePositionOffsetMs = 1_800_000L // Started transcoding at 30:00
            )

            assertTrue("Expected live-transcode progress update within 5s", progressUpdatedLatch.await(5, TimeUnit.SECONDS))
            assertEquals(2, setUriAttempts.get())
            assertFalse("Live transcode mode must NEVER send UPnP Seek SOAP on startup", receivedActions.contains("Seek"))
            assertEquals("Expected basePositionOffsetMs (30:00) + RelTime (01:30) = 31:30 (1,890,000ms)", 1_890_000, observedPos.get())
            assertEquals("Expected full movie durationHintMs (2h = 7,200,000ms) preserved", 7_200_000, observedDur.get())
        } finally {
            serverRunning.set(false)
            controller.destroy()
            try { serverSocket.close() } catch (_: Exception) {}
            pool.shutdownNow()
        }
    }

    @Test
    fun formatsRealAndroidDeviceIdentityWithoutSamsungS24Spoofing() {
        assertEquals(
            "Samsung Galaxy A54 5G",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("samsung", "SM-A546B", "Galaxy A54 5G")
        )
        assertEquals(
            "Xiaomi Redmi Note 13 Pro",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("Xiaomi", "2312DRA50G", "Redmi Note 13 Pro")
        )
        assertEquals(
            "Google Pixel 8a",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("Google", "Pixel 8a", "Pixel 8a")
        )
        assertEquals(
            "OPPO Reno10 5G",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("OPPO", "CPH2525", "OPPO Reno10 5G")
        )
        assertEquals(
            "Sony BRAVIA 4K VH2 (Salón)",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("Sony", "BRAVIA 4K VH2", "Salón", isTelevision = true)
        )
        assertEquals(
            "Amazon Fire TV (AFTKM)",
            com.cineflix.android.TelegramEngine.formatRealAndroidDeviceModel("Amazon", "AFTKM", null, isTelevision = true)
        )
        assertEquals(
            "Android 15",
            com.cineflix.android.TelegramEngine.formatRealAndroidSystemVersion("15", 35)
        )
    }

    @Test
    fun dlnaControllerAdvancesPositionWhenTvReturnsNotImplementedOrZeroRelTime() {
        // 1. Verify UpnpXmlParser distinguishes NOT_IMPLEMENTED from valid HH:MM:SS timestamps
        val notImplXml = """
            <s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
              <s:Body><u:GetPositionInfoResponse xmlns:u="urn:schemas-upnp-org:service:AVTransport:1">
                <TrackDuration>02:00:00</TrackDuration>
                <RelTime>NOT_IMPLEMENTED</RelTime>
              </u:GetPositionInfoResponse></s:Body>
            </s:Envelope>
        """.trimIndent()
        val notImplSnap = UpnpXmlParser.parsePositionInfoResponse(notImplXml)
        assertNotNull(notImplSnap)
        assertFalse(notImplSnap!!.hasValidRelTime)
        assertEquals(7_200_000L, notImplSnap.durationMs)

        val zeroRelXml = notImplXml.replace("NOT_IMPLEMENTED", "00:00:00")
        val zeroSnap = UpnpXmlParser.parsePositionInfoResponse(zeroRelXml)
        assertNotNull(zeroSnap)
        assertTrue(zeroSnap!!.hasValidRelTime)
        assertEquals(0L, zeroSnap.positionMs)

        // 2. Direct Stream (startPositionMs = 600_000L = 10:00) where TV always replies RelTime=NOT_IMPLEMENTED
        run {
            val serverSocket = ServerSocket(0, 16, InetAddress.getByName("127.0.0.1"))
            val serverRunning = AtomicBoolean(true)
            val pool = Executors.newCachedThreadPool()
            pool.execute {
                while (serverRunning.get() && !serverSocket.isClosed) {
                    try {
                        val sock = serverSocket.accept()
                        pool.execute {
                            sock.use {
                                val reader = BufferedReader(InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))
                                var contentLength = 0
                                var soapAction = ""
                                while (true) {
                                    val line = reader.readLine() ?: break
                                    if (line.isEmpty()) break
                                    if (line.startsWith("Content-Length:", ignoreCase = true)) {
                                        contentLength = line.substringAfter(":").trim().toIntOrNull() ?: 0
                                    } else if (line.startsWith("SOAPAction:", ignoreCase = true)) {
                                        soapAction = line.substringAfter(":").trim().trim('"')
                                    }
                                }
                                val bodyChars = CharArray(contentLength)
                                var readTotal = 0
                                while (readTotal < contentLength) {
                                    val n = reader.read(bodyChars, readTotal, contentLength - readTotal)
                                    if (n <= 0) break
                                    readTotal += n
                                }
                                val action = soapAction.substringAfter("#")
                                val respXml = when (action) {
                                    "GetTransportInfo" ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetTransportInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><CurrentTransportState>PLAYING</CurrentTransportState></u:GetTransportInfoResponse></s:Body></s:Envelope>"
                                    "GetPositionInfo" ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetPositionInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><TrackDuration>02:00:00</TrackDuration><RelTime>NOT_IMPLEMENTED</RelTime></u:GetPositionInfoResponse></s:Body></s:Envelope>"
                                    else ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:${action}Response xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                }
                                val bodyBytes = respXml.toByteArray(StandardCharsets.UTF_8)
                                val header = "HTTP/1.1 200 OK\r\nContent-Type: text/xml; charset=\"utf-8\"\r\nContent-Length: ${bodyBytes.size}\r\nConnection: close\r\n\r\n"
                                val out = sock.getOutputStream()
                                out.write(header.toByteArray(StandardCharsets.US_ASCII))
                                out.write(bodyBytes)
                                out.flush()
                            }
                        }
                    } catch (_: Exception) {
                        break
                    }
                }
            }

            val port = serverSocket.localPort
            val device = DlnaDevice(
                udn = "uuid:not-impl-tv",
                friendlyName = "Hisense Mock TV",
                manufacturer = "Hisense",
                modelName = "VIDAA",
                locationUrl = "http://127.0.0.1:$port/dmr",
                host = "127.0.0.1",
                avTransportControlUrl = "http://127.0.0.1:$port/ctl"
            )
            val advancedLatch = CountDownLatch(1)
            val controller = DlnaCastController()
            controller.remoteStreamActiveProvider = { true }
            controller.listener = object : DlnaCastController.Listener {
                override fun onConnecting(device: DlnaDevice) {}
                override fun onPlaybackStarted(device: DlnaDevice) {}
                override fun onProgressUpdated(device: DlnaDevice, positionMs: Long, durationMs: Long, isPlaying: Boolean) {
                    if (positionMs >= 600_900L) {
                        advancedLatch.countDown()
                    }
                }
                override fun onPlaybackEndedNaturally(device: DlnaDevice, finalPositionMs: Long, durationMs: Long) {}
                override fun onPlaybackStopped(device: DlnaDevice, lastPositionMs: Long) {}
                override fun onError(device: DlnaDevice, message: String) {}
            }

            try {
                controller.startSession(
                    device = device,
                    streamUrl = "http://127.0.0.1:49999/stream/cineflix.mkv",
                    title = "Resume Advancement Direct Test",
                    mimeType = "video/x-matroska",
                    fileSizeBytes = 2_000_000_000L,
                    startPositionMs = 600_000L,
                    durationHintMs = 7_200_000L
                )
                assertTrue(
                    "Direct Stream position must advance past startPositionMs even when TV returns RelTime=NOT_IMPLEMENTED",
                    advancedLatch.await(6, TimeUnit.SECONDS)
                )
                assertTrue(controller.getAccuratePositionMs() >= 600_900L)
            } finally {
                serverRunning.set(false)
                controller.destroy()
                try { serverSocket.close() } catch (_: Exception) {}
                pool.shutdownNow()
            }
        }

        // 3. Live Transcode (basePositionOffsetMs = 600_000L) where TV stays in vendor/TRANSITIONING state
        //    and returns RelTime=00:00:00 while actively pulling HTTP MPEG-TS bytes from LocalStreamServer
        run {
            val serverSocket = ServerSocket(0, 16, InetAddress.getByName("127.0.0.1"))
            val serverRunning = AtomicBoolean(true)
            val pool = Executors.newCachedThreadPool()
            pool.execute {
                while (serverRunning.get() && !serverSocket.isClosed) {
                    try {
                        val sock = serverSocket.accept()
                        pool.execute {
                            sock.use {
                                val reader = BufferedReader(InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))
                                var contentLength = 0
                                var soapAction = ""
                                while (true) {
                                    val line = reader.readLine() ?: break
                                    if (line.isEmpty()) break
                                    if (line.startsWith("Content-Length:", ignoreCase = true)) {
                                        contentLength = line.substringAfter(":").trim().toIntOrNull() ?: 0
                                    } else if (line.startsWith("SOAPAction:", ignoreCase = true)) {
                                        soapAction = line.substringAfter(":").trim().trim('"')
                                    }
                                }
                                val bodyChars = CharArray(contentLength)
                                var readTotal = 0
                                while (readTotal < contentLength) {
                                    val n = reader.read(bodyChars, readTotal, contentLength - readTotal)
                                    if (n <= 0) break
                                    readTotal += n
                                }
                                val action = soapAction.substringAfter("#")
                                val respXml = when (action) {
                                    "GetTransportInfo" ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetTransportInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><CurrentTransportState>TRANSITIONING</CurrentTransportState></u:GetTransportInfoResponse></s:Body></s:Envelope>"
                                    "GetPositionInfo" ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:GetPositionInfoResponse xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"><TrackDuration>00:00:00</TrackDuration><RelTime>00:00:00</RelTime></u:GetPositionInfoResponse></s:Body></s:Envelope>"
                                    else ->
                                        "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\"><s:Body><u:${action}Response xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\"/></s:Body></s:Envelope>"
                                }
                                val bodyBytes = respXml.toByteArray(StandardCharsets.UTF_8)
                                val header = "HTTP/1.1 200 OK\r\nContent-Type: text/xml; charset=\"utf-8\"\r\nContent-Length: ${bodyBytes.size}\r\nConnection: close\r\n\r\n"
                                val out = sock.getOutputStream()
                                out.write(header.toByteArray(StandardCharsets.US_ASCII))
                                out.write(bodyBytes)
                                out.flush()
                            }
                        }
                    } catch (_: Exception) {
                        break
                    }
                }
            }

            val port = serverSocket.localPort
            val device = DlnaDevice(
                udn = "uuid:orsay-zero-rel",
                friendlyName = "Samsung UE40F6400",
                manufacturer = "Samsung Electronics",
                modelName = "UE40F6400",
                locationUrl = "http://127.0.0.1:$port/dmr",
                host = "127.0.0.1",
                avTransportControlUrl = "http://127.0.0.1:$port/ctl"
            )
            val advancedLatch = CountDownLatch(1)
            val controller = DlnaCastController()
            controller.remoteStreamActiveProvider = { true }
            controller.listener = object : DlnaCastController.Listener {
                override fun onConnecting(device: DlnaDevice) {}
                override fun onPlaybackStarted(device: DlnaDevice) {}
                override fun onProgressUpdated(device: DlnaDevice, positionMs: Long, durationMs: Long, isPlaying: Boolean) {
                    if (positionMs >= 600_800L) {
                        advancedLatch.countDown()
                    }
                }
                override fun onPlaybackEndedNaturally(device: DlnaDevice, finalPositionMs: Long, durationMs: Long) {}
                override fun onPlaybackStopped(device: DlnaDevice, lastPositionMs: Long) {}
                override fun onError(device: DlnaDevice, message: String) {}
            }

            try {
                controller.startSession(
                    device = device,
                    streamUrl = "http://127.0.0.1:49999/stream/live_transcode.ts?sid=1&startMs=600000",
                    title = "Live Transcode Advancement Test",
                    mimeType = "video/mp2t",
                    fileSizeBytes = 0L,
                    startPositionMs = 0L,
                    durationHintMs = 7_200_000L,
                    isLiveTranscode = true,
                    basePositionOffsetMs = 600_000L
                )
                assertTrue(
                    "Live Transcode position must advance past basePositionOffsetMs when HTTP stream is actively flowing",
                    advancedLatch.await(5, TimeUnit.SECONDS)
                )
                assertTrue(controller.getAccuratePositionMs() >= 600_800L)
            } finally {
                serverRunning.set(false)
                controller.destroy()
                try { serverSocket.close() } catch (_: Exception) {}
                pool.shutdownNow()
            }
        }
    }

    @Test
    fun normalizesBFramePtsDtsMonotonicityInMpegTsMuxerAndRestoresDirectStreamOnDefaultAudio() {
        // 1. Verify VideoDtsNormalizer + MpegTsMuxer on decode-ordered H.264 stream with pyramidal B-frames:
        //    Decode order PTS (23.976fps): I0(0ms), P4(166.833ms), B2(83.416ms), B1(41.708ms), B3(125.125ms), P5(208.541ms)
        val tsOut = ByteArrayOutputStream()
        val muxer = MpegTsMuxer(includeVideo = true, includeAudio = true) { buf, off, len ->
            tsOut.write(buf, off, len)
        }
        val normalizer = VideoDtsNormalizer(reorderWindowFrames = 4, ctsLeadUs = 200_000L)
        val fakeSps = byteArrayOf(0x67, 0x64, 0x00, 0x28, 0xAC.toByte(), 0xD9.toByte(), 0x40, 0x78)
        val fakePps = byteArrayOf(0x68, 0xEB.toByte(), 0xE3.toByte(), 0xCB.toByte())
        val annexBIdr = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte(), 0x84.toByte(), 0x21)
        val annexBNonIdr = byteArrayOf(0x00, 0x00, 0x00, 0x01, 0x41, 0x9A.toByte(), 0x24, 0x0F)

        val bFramePtsSequenceUs = longArrayOf(
            0L,         // Frame 0: IDR (display 0)
            166_833L,   // Frame 1: P   (display 4)
            83_416L,    // Frame 2: Bref(display 2)
            41_708L,    // Frame 3: B   (display 1)
            125_125L,   // Frame 4: B   (display 3)
            208_541L    // Frame 5: P   (display 5)
        )
        val emitSample: (VideoDtsNormalizer.NormalizedVideoFrame) -> Unit = { sample ->
            assertTrue(
                "VideoDtsNormalizer must guarantee PTS (${sample.ptsUs}) >= DTS (${sample.dtsUs})",
                sample.ptsUs >= sample.dtsUs
            )
            muxer.writeH264Sample(
                annexBNalsWithoutAud = sample.annexBData,
                ptsUs = sample.ptsUs,
                dtsUs = sample.dtsUs,
                isKeyFrame = sample.isKeyFrame,
                spsList = if (sample.isKeyFrame) listOf(fakeSps) else emptyList(),
                ppsList = if (sample.isKeyFrame) listOf(fakePps) else emptyList()
            )
        }
        for ((idx, ptsUs) in bFramePtsSequenceUs.withIndex()) {
            normalizer.pushFrame(
                annexBData = if (idx == 0) annexBIdr else annexBNonIdr,
                ptsUs = ptsUs,
                isKeyFrame = (idx == 0),
                onFrameReady = emitSample
            )
        }
        normalizer.flushAll(emitSample)

        // Inspect all emitted PID_VIDEO PUSI TS packets and verify ISO/IEC 13818-1 PES PTS >= DTS & monotonic DTS
        val tsBytes = tsOut.toByteArray()
        assertEquals(0, tsBytes.size % 188)
        val totalPackets = tsBytes.size / 188
        var videoPesCount = 0
        var prevDtsTicks = -1L

        for (p in 0 until totalPackets) {
            val base = p * 188
            val pusi = (tsBytes[base + 1].toInt() and 0x40) != 0
            val pid = ((tsBytes[base + 1].toInt() and 0x1F) shl 8) or (tsBytes[base + 2].toInt() and 0xFF)
            if (pid == MpegTsMuxer.PID_VIDEO && pusi) {
                val afc = (tsBytes[base + 3].toInt() ushr 4) and 0x03
                val payloadOffset = if (afc == 3 || afc == 2) {
                    base + 5 + (tsBytes[base + 4].toInt() and 0xFF)
                } else {
                    base + 4
                }
                // Verify PES start code 00 00 01 E0 and PTS_DTS_flags == 0xC0
                assertEquals(0x00.toByte(), tsBytes[payloadOffset])
                assertEquals(0x00.toByte(), tsBytes[payloadOffset + 1])
                assertEquals(0x01.toByte(), tsBytes[payloadOffset + 2])
                assertEquals(0xE0.toByte(), tsBytes[payloadOffset + 3])
                assertEquals(0xC0.toByte(), (tsBytes[payloadOffset + 7].toInt() and 0xC0).toByte())

                val ptsTicks = MpegTsMuxer.decodeTimestamp33(tsBytes, payloadOffset + 9)
                val dtsTicks = MpegTsMuxer.decodeTimestamp33(tsBytes, payloadOffset + 14)

                assertTrue(
                    "PES packet #$videoPesCount must obey ISO/IEC 13818-1 PTS ($ptsTicks) >= DTS ($dtsTicks)",
                    ptsTicks >= dtsTicks
                )
                assertTrue(
                    "PES packet #$videoPesCount must have strictly increasing DTS ($dtsTicks > $prevDtsTicks)",
                    dtsTicks > prevDtsTicks
                )
                prevDtsTicks = dtsTicks
                videoPesCount++
            }
        }
        assertEquals("All 6 H.264 frames must be emitted as PES packets", 6, videoPesCount)

        // 2. Verify Matroska multi-audio default vs secondary track detection (switching to Audio #2 and back to #1)
        val mkvBytes = buildSyntheticMultiTrackMatroska(includeCrc = true)
        val info = MatroskaEbmlTrackPatcher.parseHeader(mkvBytes)
        assertNotNull(info)
        val defaultAudio = info!!.audioTracks.firstOrNull { it.isDefault } ?: info.audioTracks.firstOrNull()
        assertNotNull(defaultAudio)
        assertEquals(2, defaultAudio!!.trackNumber) // Track #2 (Castellano) is default

        // Selecting ordinal 1 (Track #3 English) is a non-default multi-audio choice -> requires phone decode
        val secondAudio = info.audioTracks.getOrNull(1)
        assertNotNull(secondAudio)
        assertNotEquals(defaultAudio.trackNumber, secondAudio!!.trackNumber)

        // Selecting back ordinal 0 (Track #2 Castellano) matches defaultAudio.trackNumber -> restores Direct Stream!
        val restoredAudio = info.audioTracks.getOrNull(0)
        assertNotNull(restoredAudio)
        assertEquals(defaultAudio.trackNumber, restoredAudio!!.trackNumber)
    }

    @Test
    fun swapsMatroskaAudioTrackNumbersInHeaderAndClusterSimpleBlocksForTrue51DirectStream() {
        val baseMkv = buildSyntheticMultiTrackMatroska(includeCrc = true)
        val baseInfo = MatroskaEbmlTrackPatcher.parseHeader(baseMkv)!!

        // Build a realistic <Cluster> containing <CRC-32>, <Timecode>, and <SimpleBlock>/<BlockGroup> for Tracks #1, #2, #3
        val clusterPayload = ByteArrayOutputStream()
        // <CRC-32> (0xBF 0x84 DE AD BE EF) -> 6 bytes at start of Cluster payload
        clusterPayload.write(byteArrayOf(0xBF.toByte(), 0x84.toByte(), 0xDE.toByte(), 0xAD.toByte(), 0xBE.toByte(), 0xEF.toByte()))
        // <Timecode> (0xE7 0x81 0x00) -> 3 bytes
        clusterPayload.write(byteArrayOf(0xE7.toByte(), 0x81.toByte(), 0x00))
        // <SimpleBlock> #1: Video Track #1 (0x81), timecode=0x0000, flags=0x80, payload=4 bytes
        val videoBlockPayload = byteArrayOf(0x81.toByte(), 0x00, 0x00, 0x80.toByte(), 0x11, 0x22, 0x33, 0x44)
        clusterPayload.write(ebmlElement(byteArrayOf(0xA3.toByte()), videoBlockPayload))
        // <SimpleBlock> #2: Audio Track #2 Castellano E-AC3 5.1 (0x82)
        val audio2BlockPayload = byteArrayOf(0x82.toByte(), 0x00, 0x10, 0x80.toByte(), 0x55, 0x66, 0x77, 0x88.toByte())
        clusterPayload.write(ebmlElement(byteArrayOf(0xA3.toByte()), audio2BlockPayload))
        // <SimpleBlock> #3: Audio Track #3 English AC3 5.1 (0x83)
        val audio3BlockPayload = byteArrayOf(0x83.toByte(), 0x00, 0x20, 0x80.toByte(), 0x99.toByte(), 0xAA.toByte(), 0xBB.toByte(), 0xCC.toByte())
        clusterPayload.write(ebmlElement(byteArrayOf(0xA3.toByte()), audio3BlockPayload))
        // <BlockGroup> (0xA0) containing <Block> (0xA1) for Audio Track #3 (0x83)
        val blockGroupInner = ebmlElement(
            byteArrayOf(0xA1.toByte()),
            byteArrayOf(0x83.toByte(), 0x00, 0x30, 0x00, 0xDD.toByte(), 0xEE.toByte())
        )
        clusterPayload.write(ebmlElement(byteArrayOf(0xA0.toByte()), blockGroupInner))

        val clusterElement = ebmlElement(
            byteArrayOf(0x1F, 0x43, 0xB6.toByte(), 0x75),
            clusterPayload.toByteArray()
        )
        val fullMkv = ByteArrayOutputStream().apply {
            write(baseMkv, 0, baseInfo.tracksElementEnd.toInt())
            write(clusterElement)
        }.toByteArray()

        val info = MatroskaEbmlTrackPatcher.parseHeader(fullMkv)!!
        assertEquals(info.tracksElementEnd, info.firstClusterOffset)

        // User selects English AC3 5.1 (ordinal 1 -> TrackNumber=3)
        val swapPair = MatroskaEbmlTrackPatcher.resolveAudioTrackNumberSwap(
            info = info,
            selectedAudioTrackNumber = null,
            selectedAudioOrdinal = 1
        )
        assertNotNull("Selecting secondary audio Track #3 must resolve swap Pair(3, 2)", swapPair)
        assertEquals(3 to 2, swapPair)

        val regionPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
            info = info,
            selectedAudioOrdinal = 1,
            subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED,
            swapAudioTrackNumbers = true
        )
        assertNotNull(regionPatch)

        // 1. Verify header + cluster patching on full buffer
        val headerPatched = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
            sourceBuffer = fullMkv,
            sliceOffset = 0,
            sliceLength = fullMkv.size,
            rangeGlobalStart = 0L,
            patch = regionPatch
        )!!
        val fullSwapper = MatroskaEbmlTrackPatcher.ClusterBlockSwapper(
            tracksElementEnd = info.tracksElementEnd,
            firstClusterOffset = info.firstClusterOffset,
            trackA = swapPair!!.first,
            trackB = swapPair.second
        )
        val fullySwapped = fullSwapper.patchSliceIfNeeded(
            sourceBuffer = headerPatched,
            sliceOffset = 0,
            sliceLength = headerPatched.size,
            rangeGlobalStart = 0L
        )!!
        assertEquals(fullMkv.size, fullySwapped.size)

        // Re-parse <Tracks>: English AC3 5.1 is now TrackNumber=2 (first & default), Castellano is TrackNumber=3 (disabled)
        val reparsed = MatroskaEbmlTrackPatcher.parseHeader(fullySwapped)!!
        assertEquals(2, reparsed.audioTracks[0].trackNumber)
        assertEquals("eng", reparsed.audioTracks[0].language)
        assertEquals("A_AC3", reparsed.audioTracks[0].codecId)
        assertEquals(6, reparsed.audioTracks[0].channels)
        assertTrue(reparsed.audioTracks[0].isDefault)

        assertEquals(3, reparsed.audioTracks[1].trackNumber)
        assertEquals("A_EAC3", reparsed.audioTracks[1].codecId)
        assertFalse(reparsed.audioTracks[1].isDefault)

        // Verify <Cluster> payload bytes:
        // Cluster header is 4-byte ID (1F 43 B6 75) + 1-byte size VINT = 5 bytes
        val cBase = info.firstClusterOffset.toInt() + 5
        // <CRC-32> (0xBF) at cBase must be neutralized to <Void> (0xEC)
        assertEquals(0xEC.toByte(), fullySwapped[cBase])
        // Video <SimpleBlock> TrackNumber at cBase + 6 (CRC) + 3 (Timecode) + 2 (A3 + size) = cBase + 11 must remain 0x81 (#1)
        assertEquals(0x81.toByte(), fullySwapped[cBase + 11])
        // First Audio <SimpleBlock> (was Track #2 = 0x82) at cBase + 11 + 8 + 2 = cBase + 21 must now be 0x83 (#3)!
        assertEquals(0x83.toByte(), fullySwapped[cBase + 21])
        // Second Audio <SimpleBlock> (was Track #3 = 0x83) at cBase + 21 + 8 + 2 = cBase + 31 must now be 0x82 (#2)!
        assertEquals(0x82.toByte(), fullySwapped[cBase + 31])
        // <BlockGroup> <Block> (was Track #3 = 0x83) at cBase + 31 + 8 + 2 (A0+size) + 2 (A1+size) = cBase + 43 must now be 0x82 (#2)!
        assertEquals(0x82.toByte(), fullySwapped[cBase + 43])

        // 2. Verify tiny chunked HTTP streaming (splitting right across <SimpleBlock> headers) produces identical bytes!
        val chunkedSwapper = MatroskaEbmlTrackPatcher.ClusterBlockSwapper(
            tracksElementEnd = info.tracksElementEnd,
            firstClusterOffset = info.firstClusterOffset,
            trackA = swapPair.first,
            trackB = swapPair.second
        )
        val reassembled = ByteArrayOutputStream(fullMkv.size)
        var pos = 0
        val stepSizes = intArrayOf(7, 13, 5, 3, 2, 1, 4, 9, 11)
        var stepIdx = 0
        while (pos < fullMkv.size) {
            val step = minOf(stepSizes[stepIdx % stepSizes.size], fullMkv.size - pos)
            stepIdx++
            val hPatched = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = fullMkv,
                sliceOffset = pos,
                sliceLength = step,
                rangeGlobalStart = pos.toLong(),
                patch = regionPatch
            )
            val cPatched = if (hPatched != null) {
                chunkedSwapper.patchSliceIfNeeded(hPatched, 0, hPatched.size, pos.toLong()) ?: hPatched
            } else {
                chunkedSwapper.patchSliceIfNeeded(fullMkv, pos, step, pos.toLong())
                    ?: fullMkv.copyOfRange(pos, pos + step)
            }
            reassembled.write(cPatched)
            pos += step
        }
        assertArrayEquals(
            "Chunked streaming across 1..13 byte boundaries must match full-file TrackNumber swapping byte-for-byte",
            fullySwapped,
            reassembled.toByteArray()
        )

        // 3. Verify Subtitle-only selection (chosenAudio == null) swaps Subtitle TrackNumbers (5 <-> 4)
        //    and NEVER drops any <TrackEntry> from <Tracks> even with 0 bytes of initial slack!
        for (includeCrc in listOf(true, false)) {
            val tightMkv = buildSyntheticMultiTrackMatroska(includeCrc = includeCrc)
            val tightInfo = MatroskaEbmlTrackPatcher.parseHeader(tightMkv)!!
            val subSwap = MatroskaEbmlTrackPatcher.resolveSubtitleTrackNumberSwap(
                info = tightInfo,
                selectedSubtitleOrdinal = 1
            )
            assertEquals(5 to 4, subSwap)

            val subOnlyPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                info = tightInfo,
                selectedAudioTrackNumber = null,
                selectedAudioOrdinal = null,
                subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE,
                selectedSubtitleOrdinal = 1,
                swapSubtitleTrackNumbers = true
            )
            assertNotNull("Subtitle-only patch (crc=$includeCrc) must succeed with 0 slack", subOnlyPatch)
            val subPatchedBytes = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = tightMkv,
                sliceOffset = 0,
                sliceLength = tightMkv.size,
                rangeGlobalStart = 0L,
                patch = subOnlyPatch
            )!!
            assertEquals(tightMkv.size, subPatchedBytes.size)
            val reparsedSub = MatroskaEbmlTrackPatcher.parseHeader(subPatchedBytes)!!
            assertEquals(1, reparsedSub.videoTracks.size)
            assertEquals(2, reparsedSub.audioTracks.size)
            assertEquals("ALL subtitle <TrackEntry>s MUST remain in <Tracks> (crc=$includeCrc)", 2, reparsedSub.subtitleTracks.size)
            assertEquals("Selected subtitle #5 must be swapped into lowest subtitle TrackNumber=4", 4, reparsedSub.subtitleTracks[0].trackNumber)
            assertTrue(reparsedSub.subtitleTracks[0].isDefault)
            assertTrue(reparsedSub.subtitleTracks[0].isForced)
            assertEquals("Unselected subtitle #4 must be swapped into TrackNumber=5", 5, reparsedSub.subtitleTracks[1].trackNumber)
            assertFalse(reparsedSub.subtitleTracks[1].isDefault)
            assertFalse(reparsedSub.subtitleTracks[1].isForced)
            assertEquals("", reparsedSub.subtitleTracks[1].language)

            // 4. Verify DISABLE_ALL also keeps 100% of subtitle <TrackEntry>s in <Tracks> with FlagDefault=0, FlagForced=0
            val disablePatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                info = tightInfo,
                selectedAudioTrackNumber = null,
                selectedAudioOrdinal = null,
                subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
            )
            assertNotNull("DISABLE_ALL patch (crc=$includeCrc) must succeed with 0 slack", disablePatch)
            val disabledBytes = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = tightMkv,
                sliceOffset = 0,
                sliceLength = tightMkv.size,
                rangeGlobalStart = 0L,
                patch = disablePatch
            )!!
            val reparsedDisabled = MatroskaEbmlTrackPatcher.parseHeader(disabledBytes)!!
            assertEquals("DISABLE_ALL must keep all subtitle <TrackEntry>s registered in <Tracks>", 2, reparsedDisabled.subtitleTracks.size)
            for (sub in reparsedDisabled.subtitleTracks) {
                assertFalse(sub.isDefault)
                assertFalse(sub.isForced)
                assertEquals("", sub.language)
            }
        }
    }

    @Test
    fun servesInstantNullTsPacketsOnSmartTvEofTailProbesAndStripsDuplicateAudNals() {
        // 1. Verify MpegTsMuxer.buildNullTsPacketSlice for Smart TV EOF Range probes (both 188-aligned and 64KB tail probes)
        assertEquals(0L, LocalStreamServer.VIRTUAL_LIVE_TS_SIZE_BYTES % MpegTsMuxer.TS_PACKET_SIZE)
        val probeStart = LocalStreamServer.VIRTUAL_LIVE_TS_SIZE_BYTES - (188L * 348L)
        assertEquals(0L, probeStart % MpegTsMuxer.TS_PACKET_SIZE)
        val nullSlice = MpegTsMuxer.buildNullTsPacketSlice(globalStartOffset = probeStart, length = 188 * 20)
        assertEquals(188 * 20, nullSlice.size)
        for (p in 0 until 20) {
            val base = p * 188
            assertEquals(0x47.toByte(), nullSlice[base])
            val pid = ((nullSlice[base + 1].toInt() and 0x1F) shl 8) or (nullSlice[base + 2].toInt() and 0xFF)
            assertEquals("EOF tail probe must return ISO/IEC 13818-1 PID_NULL (0x1FFF)", MpegTsMuxer.PID_NULL, pid)
            assertEquals(0x10.toByte(), nullSlice[base + 3])
        }

        // 2. Verify H264NalConverter.stripAudNals strips embedded AUD NALs so MpegTsMuxer places AUD strictly first before SPS/PPS
        val annexBWithAud = byteArrayOf(
            0x00, 0x00, 0x00, 0x01, 0x09, 0xF0.toByte(), // Embedded AUD (NAL type 9)
            0x00, 0x00, 0x00, 0x01, 0x65, 0x88.toByte(), 0x84.toByte(), 0x21 // IDR slice (NAL type 5)
        )
        val stripped = H264NalConverter.stripAudNals(annexBWithAud)
        assertFalse("Embedded AUD must be stripped before SPS/PPS prepending", H264NalConverter.containsNalType(stripped, 9))
        assertTrue("IDR slice must be preserved", H264NalConverter.containsNalType(stripped, 5))

        // 3. Verify LiveTranscodeSession.CaptureTrackOutput ignores TrackOutput.SAMPLE_DATA_PART_SUPPLEMENTAL
        var emittedBytes: ByteArray? = null
        val captureTrack = com.cineflix.android.ui.player.cast.transcode.LiveTranscodeSession.CaptureTrackOutput(
            trackId = 1,
            trackType = androidx.media3.common.C.TRACK_TYPE_AUDIO
        ) { _, packet, _, _ ->
            emittedBytes = packet
        }
        captureTrack.enabled = true
        captureTrack.selectionFinalized = true
        val mainAudioFrame = byteArrayOf(0x0B, 0x77, 0x12, 0x34, 0x56, 0x78)
        val supplementalBlockAdditions = byteArrayOf(0xDE.toByte(), 0xAD.toByte(), 0xBE.toByte(), 0xEF.toByte())
        captureTrack.sampleData(
            androidx.media3.common.util.ParsableByteArray(mainAudioFrame),
            mainAudioFrame.size,
            androidx.media3.extractor.TrackOutput.SAMPLE_DATA_PART_MAIN
        )
        captureTrack.sampleData(
            androidx.media3.common.util.ParsableByteArray(supplementalBlockAdditions),
            supplementalBlockAdditions.size,
            androidx.media3.extractor.TrackOutput.SAMPLE_DATA_PART_SUPPLEMENTAL
        )
        captureTrack.sampleMetadata(
            1_000_000L,
            androidx.media3.common.C.BUFFER_FLAG_KEY_FRAME,
            mainAudioFrame.size + supplementalBlockAdditions.size,
            0,
            null
        )
        assertNotNull(emittedBytes)
        assertArrayEquals(
            "Supplemental Matroska BlockAdditions bytes must never corrupt the main audio frame payload",
            mainAudioFrame,
            emittedBytes!!
        )
    }

    @Test
    fun extractsMatroskaUtf8AndZlibCompressedAssSubtitlesToSrtAndPlacesPrimaryVideoResFirstInDidl() {
        // 1. Verify DIDL-Lite places the primary video <res> strictly BEFORE the external text/srt & smi/caption <res> and <sec:CaptionInfoEx>
        val didl = DlnaSoapBuilder.buildDidlLiteMetadata(
            streamUrl = "http://192.168.1.50:41234/stream/cineflix_e2_t3.mkv",
            title = "Alien: Romulus",
            mimeType = "video/x-matroska",
            fileSizeBytes = 3_500_000_000L,
            durationMs = 7_140_000L,
            subtitleSrtUrl = "http://192.168.1.50:41234/stream/cineflix_e2_t3.srt"
        )
        val videoResIdx = didl.indexOf("http-get:*:video/x-matroska:")
        val srtResIdx = didl.indexOf("http-get:*:text/srt:*")
        val smiResIdx = didl.indexOf("http-get:*:smi/caption:*")
        val captionExIdx = didl.indexOf("<sec:CaptionInfoEx sec:type=\"srt\">")
        assertTrue("Primary video <res> must exist", videoResIdx > 0)
        assertTrue("External SRT <res> must exist", srtResIdx > 0)
        assertTrue("External smi/caption <res> must exist", smiResIdx > 0)
        assertTrue("Samsung <sec:CaptionInfoEx> must exist", captionExIdx > 0)
        assertTrue(
            "Primary video <res> must be <res>[0] (strictly before text/srt and smi/caption <res>)",
            videoResIdx < srtResIdx && videoResIdx < smiResIdx && videoResIdx < captionExIdx
        )

        // 2. Verify cleanMatroskaSubtitlePayload on S_TEXT/ASS (including vector drawing stripping) and S_TEXT/UTF8
        val assPayload = "14,0,Default,Sign,0,0,0,,{\\an8\\pos(960,120)}{\\i1}¡Cuidado con el xenomorfo!{\\i0}\\NSegunda línea{\\p1}m 0 0 l 100 0 100 100{\\p0}"
            .toByteArray(StandardCharsets.UTF_8)
        assertEquals(
            "¡Cuidado con el xenomorfo!\r\nSegunda línea",
            MatroskaSubtitleSrtExtractor.cleanMatroskaSubtitlePayload(assPayload, "S_TEXT/ASS")
        )

        // 3. Build a synthetic Matroska (.mkv) file with:
        //    - Track 1: V_MPEG4/ISO/AVC
        //    - Track 2: A_AC3 (5.1)
        //    - Track 3: S_TEXT/UTF8 (Spanish Forced)
        //    - Track 4: S_TEXT/ASS compressed with zlib (ContentCompAlgo = 0, Spanish Full)
        //    - <Cluster> containing <BlockGroup> (0xA0 -> <Block> 0xA1 + <BlockDuration> 0x9B) for Track 3 & Track 4
        //    - <Cues> (0x1C53BB6B) starting with mkvmerge's 6-byte <CRC-32> (0xBF 0x84 ...) before <CuePoint> (0xBB)
        val deflater = java.util.zip.Deflater()
        val rawAssLine = "1,0,Default,,0,0,0,,{\\an2}Subtítulo completo comprimido con zlib\\NLínea 2".toByteArray(StandardCharsets.UTF_8)
        deflater.setInput(rawAssLine)
        deflater.finish()
        val compressedAssBytes = ByteArray(256)
        val compressedAssLen = deflater.deflate(compressedAssBytes)
        deflater.end()
        val zlibAssPayload = compressedAssBytes.copyOf(compressedAssLen)

        val mkvOut = ByteArrayOutputStream()
        // EBML Header
        mkvOut.write(byteArrayOf(0x1A, 0x45, 0xDF.toByte(), 0xA3.toByte(), 0x84.toByte(), 0x42, 0x86.toByte(), 0x81.toByte(), 0x01))
        // Segment (unknown size 0x01FFFFFFFFFFFFFF)
        mkvOut.write(byteArrayOf(
            0x18, 0x53, 0x80.toByte(), 0x67,
            0x01, 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte(), 0xFF.toByte()
        ))
        val segmentPayloadStart = mkvOut.size().toLong()

        // <Info> (TimestampScale = 1,000,000 ns)
        mkvOut.write(byteArrayOf(
            0x15, 0x49, 0xA9.toByte(), 0x66, 0x87.toByte(),
            0x2A, 0xD7.toByte(), 0xB1.toByte(), 0x83.toByte(), 0x0F, 0x42, 0x40
        ))

        // <Tracks>
        val tracksPayload = ByteArrayOutputStream()
        // Track 1: Video
        val t1 = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x01,
            0x83.toByte(), 0x81.toByte(), 0x01,
            0x86.toByte(), 0x8F.toByte()
        ) + "V_MPEG4/ISO/AVC".toByteArray(StandardCharsets.US_ASCII)
        tracksPayload.write(0xAE)
        tracksPayload.write(0x80 or t1.size)
        tracksPayload.write(t1)

        // Track 3: S_TEXT/UTF8 (Spanish Forced)
        val t3 = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x03,
            0x83.toByte(), 0x81.toByte(), 0x11,
            0x88.toByte(), 0x81.toByte(), 0x01,
            0x55, 0xAA.toByte(), 0x81.toByte(), 0x01,
            0x22, 0xB5.toByte(), 0x9C.toByte(), 0x83.toByte(), 's'.code.toByte(), 'p'.code.toByte(), 'a'.code.toByte(),
            0x86.toByte(), 0x8B.toByte()
        ) + "S_TEXT/UTF8".toByteArray(StandardCharsets.US_ASCII)
        tracksPayload.write(0xAE)
        tracksPayload.write(0x80 or t3.size)
        tracksPayload.write(t3)

        // Track 4: S_TEXT/ASS with ContentEncodings -> ContentEncoding -> ContentCompression (zlib algo 0)
        val contentEncodings = byteArrayOf(
            0x6D, 0x80.toByte(), 0x8A.toByte(),
            0x62, 0x40, 0x87.toByte(),
            0x50, 0x34, 0x84.toByte(),
            0x42, 0x54, 0x81.toByte(), 0x00
        )
        val t4 = byteArrayOf(
            0xD7.toByte(), 0x81.toByte(), 0x04,
            0x83.toByte(), 0x81.toByte(), 0x11,
            0x88.toByte(), 0x81.toByte(), 0x00,
            0x22, 0xB5.toByte(), 0x9C.toByte(), 0x83.toByte(), 's'.code.toByte(), 'p'.code.toByte(), 'a'.code.toByte(),
            0x86.toByte(), 0x8A.toByte()
        ) + "S_TEXT/ASS".toByteArray(StandardCharsets.US_ASCII) + contentEncodings
        tracksPayload.write(0xAE)
        tracksPayload.write(0x80 or t4.size)
        tracksPayload.write(t4)

        val tracksBytes = tracksPayload.toByteArray()
        mkvOut.write(byteArrayOf(0x16, 0x54, 0xAE.toByte(), 0x6B))
        mkvOut.write(0x80 or tracksBytes.size)
        mkvOut.write(tracksBytes)

        // <Cluster> at 2000ms
        val clusterStartOffset = mkvOut.size().toLong()
        val clusterPayload = ByteArrayOutputStream()
        // <Timecode> = 2000 (0x07D0)
        clusterPayload.write(byteArrayOf(0xE7.toByte(), 0x82.toByte(), 0x07, 0xD0.toByte()))

        // Track 3 <BlockGroup> at relative position inside cluster
        val track3RelPos = clusterPayload.size().toLong()
        val utf8SubText = " CARTEL: ESTACIÓN ROMULUS ".trim().toByteArray(StandardCharsets.UTF_8)
        val block3Payload = ByteArrayOutputStream()
        block3Payload.write(byteArrayOf(0x83.toByte(), 0x01, 0xF4.toByte(), 0x80.toByte())) // Track 3, relTime=+500ms (total 2500ms)
        block3Payload.write(utf8SubText)
        val b3Bytes = block3Payload.toByteArray()
        val bg3Payload = ByteArrayOutputStream()
        bg3Payload.write(0xA1)
        bg3Payload.write(0x80 or b3Bytes.size)
        bg3Payload.write(b3Bytes)
        // <BlockDuration> = 3000ms (0x0BB8)
        bg3Payload.write(byteArrayOf(0x9B.toByte(), 0x82.toByte(), 0x0B, 0xB8.toByte()))
        val bg3Bytes = bg3Payload.toByteArray()
        clusterPayload.write(0xA0)
        clusterPayload.write(0x80 or bg3Bytes.size)
        clusterPayload.write(bg3Bytes)

        // Track 4 <BlockGroup> (zlib-compressed ASS) at relative position inside cluster
        val track4RelPos = clusterPayload.size().toLong()
        val block4Payload = ByteArrayOutputStream()
        block4Payload.write(byteArrayOf(0x84.toByte(), 0x03, 0xE8.toByte(), 0x80.toByte())) // Track 4, relTime=+1000ms (total 3000ms)
        block4Payload.write(zlibAssPayload)
        val b4Bytes = block4Payload.toByteArray()
        val bg4Payload = ByteArrayOutputStream()
        bg4Payload.write(0xA1)
        bg4Payload.write(0x80 or b4Bytes.size)
        bg4Payload.write(b4Bytes)
        bg4Payload.write(byteArrayOf(0x9B.toByte(), 0x82.toByte(), 0x0F, 0xA0.toByte())) // duration 4000ms
        val bg4Bytes = bg4Payload.toByteArray()
        clusterPayload.write(0xA0)
        clusterPayload.write(0x80 or bg4Bytes.size)
        clusterPayload.write(bg4Bytes)

        val clusterPayloadBytes = clusterPayload.toByteArray()
        mkvOut.write(byteArrayOf(0x1F, 0x43, 0xB6.toByte(), 0x75))
        // 4-byte VINT size for Cluster
        val cLen = clusterPayloadBytes.size
        mkvOut.write(byteArrayOf(
            (0x10 or ((cLen ushr 24) and 0x0F)).toByte(),
            ((cLen ushr 16) and 0xFF).toByte(),
            ((cLen ushr 8) and 0xFF).toByte(),
            (cLen and 0xFF).toByte()
        ))
        mkvOut.write(clusterPayloadBytes)

        // <Cues> (0x1C53BB6B) starting with mkvmerge's 6-byte <CRC-32> (0xBF 0x84 ...) before <CuePoint> (0xBB)
        val cuesStartOffset = mkvOut.size().toLong()
        val clusterSegmentPos = (clusterStartOffset - segmentPayloadStart).toInt()
        val cuesPayload = ByteArrayOutputStream()
        cuesPayload.write(byteArrayOf(0xBF.toByte(), 0x84.toByte(), 0x12, 0x34, 0x56, 0x78))
        // CuePoint 1: Track 3 at 2500ms (0x09C4)
        val cp1 = byteArrayOf(
            0xB3.toByte(), 0x82.toByte(), 0x09, 0xC4.toByte(),
            0xB7.toByte(), 0x89.toByte(),
            0xF7.toByte(), 0x81.toByte(), 0x03,
            0xF1.toByte(), 0x81.toByte(), clusterSegmentPos.toByte(),
            0xF0.toByte(), 0x81.toByte(), track3RelPos.toByte()
        )
        cuesPayload.write(0xBB)
        cuesPayload.write(0x80 or cp1.size)
        cuesPayload.write(cp1)

        // CuePoint 2: Track 4 at 3000ms (0x0BB8)
        val cp2 = byteArrayOf(
            0xB3.toByte(), 0x82.toByte(), 0x0B, 0xB8.toByte(),
            0xB7.toByte(), 0x89.toByte(),
            0xF7.toByte(), 0x81.toByte(), 0x04,
            0xF1.toByte(), 0x81.toByte(), clusterSegmentPos.toByte(),
            0xF0.toByte(), 0x81.toByte(), track4RelPos.toByte()
        )
        cuesPayload.write(0xBB)
        cuesPayload.write(0x80 or cp2.size)
        cuesPayload.write(cp2)

        val cuesBytes = cuesPayload.toByteArray()
        mkvOut.write(byteArrayOf(0x1C, 0x53, 0xBB.toByte(), 0x6B))
        mkvOut.write(0x80 or cuesBytes.size)
        mkvOut.write(cuesBytes)

        val fullMkvBytes = mkvOut.toByteArray()
        val headerInfo = MatroskaEbmlTrackPatcher.parseHeader(fullMkvBytes)
        assertNotNull(headerInfo)
        assertEquals(2, headerInfo!!.subtitleTracks.size)
        assertEquals(-1, headerInfo.subtitleTracks[0].contentCompAlgo)
        assertEquals(0, headerInfo.subtitleTracks[1].contentCompAlgo)

        val extractor = MatroskaSubtitleSrtExtractor(
            totalLogicalSizeProvider = { fullMkvBytes.size.toLong() },
            directByteReader = { logicalOffset, dst, dstOffset, length ->
                val start = logicalOffset.toInt()
                if (start < 0 || start >= fullMkvBytes.size) -1
                else {
                    // Simulate short reads across cached slices (64 bytes max per call) to verify readFully loop
                    val take = minOf(minOf(length, 64), fullMkvBytes.size - start)
                    System.arraycopy(fullMkvBytes, start, dst, dstOffset, take)
                    take
                }
            }
        )

        val srtTrack3 = String(
            extractor.prewarmAndBuildSrtBytes(headerInfo, targetTrackNumber = 3, startPositionMs = 0L),
            StandardCharsets.UTF_8
        )
        assertTrue("Expected Forced UTF-8 subtitle cue in SRT", srtTrack3.contains("00:00:02,500 --> 00:00:05,500"))
        assertTrue("Expected Forced UTF-8 text in SRT", srtTrack3.contains("CARTEL: ESTACIÓN ROMULUS"))

        val srtTrack4 = String(
            extractor.prewarmAndBuildSrtBytes(headerInfo, targetTrackNumber = 4, startPositionMs = 0L),
            StandardCharsets.UTF_8
        )
        assertTrue("Expected Full zlib-ASS subtitle cue in SRT", srtTrack4.contains("00:00:03,000 --> 00:00:07,000"))
        assertTrue("Expected decompressed & cleaned ASS text in SRT", srtTrack4.contains("Subtítulo completo comprimido con zlib\r\nLínea 2"))

        val smiTrack4 = String(
            extractor.getOrBuildSmiBytes(headerInfo, targetTrackNumber = 4, startPositionMs = 0L),
            StandardCharsets.UTF_8
        )
        assertTrue("Expected valid <SAMI> document for smi/caption TVs", smiTrack4.contains("<SAMI>") && smiTrack4.contains("<SYNC Start=3000>"))
        assertTrue("Expected SAMI line break in subtitle text", smiTrack4.contains("Subtítulo completo comprimido con zlib<br>Línea 2"))

        val didlWithSub = DlnaSoapBuilder.buildDidlLiteMetadata(
            streamUrl = "http://192.168.1.50:41234/stream/cineflix_e1_t4.mkv",
            title = "Resident Evil (2026)",
            mimeType = "video/x-matroska",
            subtitleSrtUrl = "http://192.168.1.50:41234/stream/cineflix_e1_t4.srt"
        )
        assertTrue("DIDL-Lite text/srt resource must point to .srt", didlWithSub.contains("<res protocolInfo=\"http-get:*:text/srt:*\">http://192.168.1.50:41234/stream/cineflix_e1_t4.srt</res>"))
        assertTrue("DIDL-Lite smi/caption resource must point to .smi", didlWithSub.contains("<res protocolInfo=\"http-get:*:smi/caption:*\">http://192.168.1.50:41234/stream/cineflix_e1_t4.smi</res>"))

        // 4. Verify ClusterBlockSwapper also swaps <CueTrack> (0xF7) inside <Cues> (0x1C53BB6B) and neutralizes <CRC-32> (0xBF -> 0xEC)
        val swapper = MatroskaEbmlTrackPatcher.ClusterBlockSwapper(
            tracksElementEnd = headerInfo.tracksElementEnd,
            firstClusterOffset = headerInfo.firstClusterOffset,
            trackA = -1,
            trackB = -1,
            subTrackA = 4,
            subTrackB = 3
        )
        val patchedCuesSlice = swapper.patchSliceIfNeeded(
            sourceBuffer = fullMkvBytes,
            sliceOffset = cuesStartOffset.toInt(),
            sliceLength = fullMkvBytes.size - cuesStartOffset.toInt(),
            rangeGlobalStart = cuesStartOffset
        )
        assertNotNull("Expected ClusterBlockSwapper to patch <Cues> slice", patchedCuesSlice)
        assertEquals("Expected <Cues> <CRC-32> (0xBF) neutralized to <Void> (0xEC)", 0xEC.toByte(), patchedCuesSlice!![5])
        val reparsedCues = extractor.parseCuesFromSlice(
            buf = patchedCuesSlice,
            limit = patchedCuesSlice.size,
            segmentPayloadStart = segmentPayloadStart,
            timestampScaleNs = headerInfo.timestampScaleNs
        )
        assertEquals(2, reparsedCues.size)
        assertEquals("CuePoint 1 track 3 must be swapped to 4", 4, reparsedCues[0].positions[0].trackNumber)
        assertEquals("CuePoint 2 track 4 must be swapped to 3", 3, reparsedCues[1].positions[0].trackNumber)

        // 5. If real >2GB channel .mkv files exist locally, verify segmentEndOffset, <Tracks> patching, and .srt/.smi extraction
        val candidateFiles = listOf(
            java.io.File("C:/Users/crono/Downloads/Telegram Desktop/Tierra de mafiosos S02E07 1080p _.mkv"),
            java.io.File("C:/Users/crono/Downloads/Telegram Desktop/Las chicas están bien (2023).mkv"),
            java.io.File("C:/Users/crono/Downloads/Telegram Desktop/White Boy Rick (2018).mkv")
        )
        for (mkvFile in candidateFiles) {
            if (!mkvFile.exists() || !mkvFile.isFile) continue
            java.io.RandomAccessFile(mkvFile, "r").use { raf ->
                val headBuf = ByteArray(65536)
                val headRead = raf.read(headBuf)
                assertTrue(headRead > 1024)
                val info = MatroskaEbmlTrackPatcher.parseHeader(headBuf.copyOf(headRead))
                assertNotNull("Must parse header of ${mkvFile.name}", info)
                assertEquals(
                    "segmentEndOffset must match exact >2GB file size for ${mkvFile.name}",
                    raf.length(),
                    info!!.segmentEndOffset
                )
                assertTrue("Must have subtitle tracks in ${mkvFile.name}", info.subtitleTracks.isNotEmpty())

                for (sub in info.subtitleTracks) {
                    val patch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
                        info = info,
                        selectedAudioTrackNumber = info.audioTracks.lastOrNull()?.trackNumber,
                        subtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE,
                        selectedSubtitleTrackNumber = sub.trackNumber,
                        swapAudioTrackNumbers = true,
                        swapSubtitleTrackNumbers = true
                    )
                    assertNotNull("Must build exact-size <Tracks> patch for ${mkvFile.name} sub #${sub.trackNumber}", patch)
                    val patchedHeader = MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                        sourceBuffer = headBuf,
                        sliceOffset = 0,
                        sliceLength = headRead,
                        rangeGlobalStart = 0L,
                        patch = patch
                    )!!
                    val reparsed = MatroskaEbmlTrackPatcher.parseHeader(patchedHeader)!!
                    val firstSub = reparsed.subtitleTracks.first()
                    assertTrue("Patched chosen subtitle in ${mkvFile.name} must have FlagDefault=1", firstSub.isDefault)
                    assertTrue("Patched chosen subtitle in ${mkvFile.name} must have FlagForced=1", firstSub.isForced)
                }

                // Simulate 2GB default size bug (`totalLogicalSizeProvider = { 2_000_000_000L }`) and verify
                // segmentEndOffset still allows reading <Cues> at 2.8GB..4.04GB and extracting real subtitles!
                val realExtractor = MatroskaSubtitleSrtExtractor(
                    totalLogicalSizeProvider = { 2_000_000_000L },
                    directByteReader = { logicalOffset, dst, dstOffset, length ->
                        if (logicalOffset < 0L || logicalOffset >= raf.length()) -1
                        else {
                            val canRead = minOf(length.toLong(), raf.length() - logicalOffset).toInt()
                            raf.seek(logicalOffset)
                            raf.read(dst, dstOffset, canRead)
                        }
                    }
                )
                for (sub in info.subtitleTracks) {
                    val srt = String(
                        realExtractor.prewarmAndBuildSrtBytes(info, sub.trackNumber, startPositionMs = 0L),
                        StandardCharsets.UTF_8
                    )
                    val smi = String(
                        realExtractor.getOrBuildSmiBytes(info, sub.trackNumber, startPositionMs = 0L),
                        StandardCharsets.UTF_8
                    )
                    assertTrue(
                        "Expected real harvested cues (> 0) for ${mkvFile.name} track #${sub.trackNumber} ('${sub.name}')",
                        realExtractor.getHarvestedCueCount(sub.trackNumber) > 0
                    )
                    assertTrue("SRT must contain real dialogue for ${mkvFile.name} track #${sub.trackNumber}", srt.length > 60)
                    assertTrue("SAMI must contain <SAMI> and <SYNC for ${mkvFile.name} track #${sub.trackNumber}", smi.contains("<SAMI>") && smi.contains("<SYNC Start="))
                }
            }
        }
    }

    private fun containsSubArray(haystack: ByteArray, needle: ByteArray): Boolean {
        if (needle.isEmpty() || haystack.size < needle.size) return false
        outer@ for (i in 0..(haystack.size - needle.size)) {
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) continue@outer
            }
            return true
        }
        return false
    }
}
