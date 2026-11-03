package com.cineflix.android.ui.player

import android.util.Log
import com.cineflix.android.TelegramEngine
import com.cineflix.android.ui.player.cast.DlnaDevice
import com.cineflix.android.ui.player.cast.DlnaSoapBuilder
import com.cineflix.android.ui.player.cast.MatroskaEbmlTrackPatcher
import com.cineflix.android.ui.player.cast.MatroskaSubtitleSrtExtractor
import com.cineflix.android.ui.player.cast.transcode.LiveTranscodeManager
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.ServerSocket
import java.net.Socket
import java.nio.charset.StandardCharsets
import java.util.Locale
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.min

/**
 * LocalStreamServer — Ultra-lightweight local HTTP server inspired by Oliyo.
 *
 * Uses raw Java ServerSocket to serve byte-range requests directly to ExoPlayer/LibVLC,
 * Google Cast (Chromecast / Android TV), and native UPnP/DLNA Smart TVs (Samsung Tizen,
 * Samsung Orsay 2010-2014, LG webOS, Sony Bravia, Hisense, Roku).
 *
 * Optimizations for Instant Startup & Smart TV Casting:
 *  1. Initial probe/header requests (<512KB) use fast 256KB-512KB chunks for instant response (<100ms).
 *  2. Checks TDLib cache (readFilePartSync) before downloading to serve repeat ranges in 0ms.
 *  3. Binds to wildcard (0.0.0.0) on a free dynamic port, allowing local ExoPlayer (127.0.0.1),
 *     Google Cast ($wifiIp), and DLNA Smart TVs ($wifiIp) to use the same fast server.
 *  4. Serves full DLNA 1.5 headers (transferMode.dlna.org, contentFeatures.dlna.org), Samsung Orsay
 *     legacy `video/x-mkv` compatibility (`/stream/cineflix_orsay.mkv`), CORS headers, proper HTTP 200
 *     vs HTTP 206, magic-byte container detection, parallel tail-probe tolerance, and zero-transcoding
 *     in-place Matroska EBML `<Tracks>` patching so Audio & Subtitle selection from the phone controls
 *     what the Smart TV plays with 0 byte-size change.
 */
class LocalStreamServer(private val engine: TelegramEngine) {

    data class ContainerSpec(
        val extension: String,
        val mimeType: String
    )

    data class DlnaStreamPlan(
        val primaryUrl: String,
        val primaryMime: String,
        val isPrimaryLiveTranscode: Boolean = false,
        val primaryBaseOffsetMs: Long = 0L,
        val subtitleSrtUrl: String? = null,
        val fallbackUrl: String? = null,
        val fallbackMime: String? = null,
        val isFallbackLiveTranscode: Boolean = false,
        val fallbackBaseOffsetMs: Long = 0L,
        val isHevcVideo: Boolean = false
    )

    companion object {
        private const val TAG = "LocalStreamServer"
        private const val PROBE_CHUNK_SIZE = 256L * 1024L        // 256 KB for instant header / probe reads
        private const val FIRST_CHUNK_SIZE = 512L * 1024L        // 512 KB for instant initial video frame
        private const val STREAM_CHUNK_SIZE = 2097152L           // 2 MB for smooth continuous playback
        private const val ALIGNMENT = 131072L                   // 128 KB (TDLib MTProto block alignment)
        private const val STORAGE_SAMPLE_BYTES = 8L * 1024L * 1024L
        private const val PARALLEL_PROBE_MAX_BYTES = 4L * 1024L * 1024L // <= 4 MB tail/index probes run in parallel
        private const val MAX_MATROSKA_HEADER_INSPECT_BYTES = 1024L * 1024L // 1 MB max EBML Tracks scan
        const val VIRTUAL_LIVE_TS_SIZE_BYTES = LiveTranscodeManager.MAX_SAFE_32BIT_TS_SIZE_BYTES // 11,422,784 * 188 bytes (< INT32_MAX)

        internal fun extractMp4MvhdDurationMs(header: ByteArray?): Long {
            if (header == null || header.size < 32) return 0L
            val limit = header.size
            var pos = 0
            while (pos + 8 <= limit) {
                val rawSize = readBeU32(header, pos)
                val boxType = String(header, pos + 4, 4, StandardCharsets.ISO_8859_1)
                val headerLen: Int
                val boxEndLong: Long
                when (rawSize) {
                    1L -> {
                        if (pos + 16 > limit) break
                        headerLen = 16
                        boxEndLong = pos.toLong() + readBeU64(header, pos + 8)
                    }
                    0L -> {
                        headerLen = 8
                        boxEndLong = limit.toLong()
                    }
                    else -> {
                        if (rawSize < 8L) break
                        headerLen = 8
                        boxEndLong = pos.toLong() + rawSize
                    }
                }
                if (boxType == "moov") {
                    val moovEnd = minOf(limit.toLong(), boxEndLong).toInt()
                    var childPos = pos + headerLen
                    while (childPos + 8 <= moovEnd) {
                        val cSize = readBeU32(header, childPos)
                        val cType = String(header, childPos + 4, 4, StandardCharsets.ISO_8859_1)
                        val cHeadLen = if (cSize == 1L) 16 else 8
                        val cEndLong = when (cSize) {
                            1L -> if (childPos + 16 <= moovEnd) childPos.toLong() + readBeU64(header, childPos + 8) else break
                            0L -> moovEnd.toLong()
                            else -> if (cSize >= 8L) childPos.toLong() + cSize else break
                        }
                        val cPayload = childPos + cHeadLen
                        if (cType == "mvhd" && cPayload + 20 <= minOf(moovEnd.toLong(), cEndLong).toInt()) {
                            val version = header[cPayload].toInt() and 0xFF
                            if (version == 0 && cPayload + 20 <= limit) {
                                val timescale = readBeU32(header, cPayload + 12)
                                val duration = readBeU32(header, cPayload + 16)
                                if (timescale > 0L && duration > 0L && duration != 0xFFFFFFFFL) {
                                    return (duration * 1000L) / timescale
                                }
                            } else if (version == 1 && cPayload + 32 <= limit) {
                                val timescale = readBeU32(header, cPayload + 20)
                                val duration = readBeU64(header, cPayload + 24)
                                if (timescale > 0L && duration > 0L) {
                                    return (duration * 1000L) / timescale
                                }
                            }
                        }
                        if (cEndLong <= childPos || cEndLong > moovEnd) break
                        childPos = cEndLong.toInt()
                    }
                    return 0L
                }
                if (boxEndLong <= pos || boxEndLong > limit) break
                pos = boxEndLong.toInt()
            }
            return 0L
        }

        private fun readBeU32(b: ByteArray, off: Int): Long {
            return ((b[off].toLong() and 0xFFL) shl 24) or
                ((b[off + 1].toLong() and 0xFFL) shl 16) or
                ((b[off + 2].toLong() and 0xFFL) shl 8) or
                (b[off + 3].toLong() and 0xFFL)
        }

        private fun readBeU64(b: ByteArray, off: Int): Long {
            return (readBeU32(b, off) shl 32) or (readBeU32(b, off + 4) and 0xFFFFFFFFL)
        }

        fun sniffContainerFromHeader(header: ByteArray?, fallbackMime: String = "video/mp4"): ContainerSpec {
            if (header != null && header.size >= 12) {
                // 1. Matroska / WebM EBML magic: 1A 45 DF A3
                if (header[0] == 0x1A.toByte() &&
                    header[1] == 0x45.toByte() &&
                    header[2] == 0xDF.toByte() &&
                    header[3] == 0xA3.toByte()
                ) {
                    val asciiHead = String(header, 0, minOf(header.size, 64), StandardCharsets.ISO_8859_1)
                        .lowercase(Locale.ROOT)
                    return if (asciiHead.contains("webm")) {
                        ContainerSpec("webm", "video/webm")
                    } else {
                        ContainerSpec("mkv", "video/x-matroska")
                    }
                }
                // 2. ISO BMFF (MP4 / MOV / M4V): bytes 4..7 == "ftyp" or "moov" / "mdat"
                val boxType = String(header, 4, 4, StandardCharsets.US_ASCII)
                if (boxType == "ftyp" || boxType == "moov" || boxType == "mdat" || boxType == "wide") {
                    return ContainerSpec("mp4", "video/mp4")
                }
                // 3. AVI: "RIFF" .... "AVI "
                val riff = String(header, 0, 4, StandardCharsets.US_ASCII)
                val avi = String(header, 8, 4, StandardCharsets.US_ASCII)
                if (riff == "RIFF" && avi == "AVI ") {
                    return ContainerSpec("avi", "video/x-msvideo")
                }
                // 4. MPEG-TS: 0x47 sync byte
                if (header[0] == 0x47.toByte() && (header.size <= 188 || header[188] == 0x47.toByte())) {
                    return ContainerSpec("ts", "video/mp2t")
                }
            }

            val lower = fallbackMime.lowercase(Locale.ROOT)
            return when {
                lower.contains("matroska") || lower.contains("mkv") -> ContainerSpec("mkv", "video/x-matroska")
                lower.contains("webm") -> ContainerSpec("webm", "video/webm")
                lower.contains("avi") -> ContainerSpec("avi", "video/x-msvideo")
                lower.contains("mp2t") -> ContainerSpec("ts", "video/mp2t")
                else -> ContainerSpec("mp4", "video/mp4")
            }
        }
    }

    private var serverSocket: ServerSocket? = null
    private val executor: ExecutorService = Executors.newCachedThreadPool()
    private val clients = java.util.concurrent.ConcurrentHashMap.newKeySet<Socket>()

    @Volatile private var activeFileId: Int = -1
    @Volatile private var activeSize: Long = 0L
    @Volatile private var activeMime: String = "video/mp4"
    @Volatile private var detectedContainer: ContainerSpec? = null
    @Volatile private var activeParts: List<FilePart>? = null
    @Volatile private var bytesStreamedSinceGc: Long = 0L
    @Volatile private var isRunning: Boolean = false
    @Volatile private var knownDurationMs: Long = 0L
    @Volatile var onDurationDiscovered: ((Long) -> Unit)? = null
    @Volatile var onRemoteTvLiveSeek: ((Long) -> Unit)? = null

    fun getKnownDurationMs(): Long = knownDurationMs

    fun updateKnownDurationMs(durMs: Long) {
        if (durMs <= 0L) return
        val prev = knownDurationMs
        knownDurationMs = durMs
        if (prev != durMs) {
            try {
                onDurationDiscovered?.invoke(durMs)
            } catch (_: Throwable) {}
        }
    }

    private class TailCacheSlice(
        val startOffset: Long,
        val bytes: ByteArray
    )

    // Matroska EBML exact-size track selection state & RAM header/Cues caches for instant TV track switching
    private val trackPatchLock = Any()
    @Volatile private var matroskaHeaderAttempted: Boolean = false
    @Volatile private var matroskaHeaderInfo: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo? = null
    @Volatile private var selectedCastAudioTrackNum: Int? = null
    @Volatile private var selectedCastAudioOrdinal: Int? = null
    @Volatile private var selectedCastSubtitleMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode =
        MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
    @Volatile private var selectedCastSubtitleTrackNum: Int? = null
    @Volatile private var selectedCastSubtitleOrdinal: Int? = null
    @Volatile private var forceStereoCompatibility: Boolean = false
    @Volatile private var activeCastRegionPatch: MatroskaEbmlTrackPatcher.EbmlRegionPatch? = null
    @Volatile private var activeCastClusterBlockSwapper: MatroskaEbmlTrackPatcher.ClusterBlockSwapper? = null
    @Volatile private var activeCastSubtitleSrtUrl: String? = null
    @Volatile private var activeCastSubtitleTrackNum: Int = -1
    @Volatile private var activeCastSubtitleStartMs: Long = 0L
    @Volatile private var cachedHeadPrefix: ByteArray? = null
    @Volatile private var cachedTailSlice: TailCacheSlice? = null
    private val castTrackEpoch = AtomicLong(0L)
    private val liveTranscodeEpoch = AtomicLong(0L)

    private val matroskaSubtitleExtractor = MatroskaSubtitleSrtExtractor(
        totalLogicalSizeProvider = {
            if (prepareArchive()) activeSize else 0L
        },
        directByteReader = { logicalOffset, dst, dstOffset, length ->
            readLogicalRangeDirect(logicalOffset, dst, dstOffset, length) { !isRunning }
        }
    )

    private val liveTranscodeManager = LiveTranscodeManager(
        totalLogicalSizeProvider = {
            if (prepareArchive()) activeSize else 0L
        },
        directByteReader = ::readLogicalRangeDirect,
        onDurationDiscovered = { durMs ->
            updateKnownDurationMs(durMs)
        }
    )

    private val activeRequestId = AtomicLong(0L)
    private val lastRemoteMediaWriteAtMs = AtomicLong(0L)
    private val totalRemoteMediaBytesSent = AtomicLong(0L)
    @Volatile private var currentStreamingSocket: Socket? = null
    private var storedSevenZip = false
    private var archiveError: ((String) -> Unit)? = null
    @Volatile private var archiveReady = false
    @Volatile private var archiveFailure: String? = null
    private var archiveTotal = 0L
    private var videoOffset = 0L

    var listeningPort: Int = 0
        private set

    fun start(
        fileId: Int,
        totalSize: Long,
        mimeType: String = "video/mp4",
        multipartParts: List<FilePart>? = null,
        storedSevenZip: Boolean = false,
        archiveError: ((String) -> Unit)? = null
    ): String {
        // Close previous socket without wiping cache during startup
        isRunning = false
        liveTranscodeManager.stopActiveSession()
        try {
            serverSocket?.close()
        } catch (_: Exception) {}
        serverSocket = null

        activeFileId = fileId
        activeSize = if (totalSize > 0) totalSize else 2_000_000_000L
        activeMime = if (mimeType.isNotBlank()) mimeType else "video/mp4"
        detectedContainer = null
        activeParts = multipartParts
        this.storedSevenZip = storedSevenZip
        this.archiveError = archiveError
        archiveReady = false
        archiveFailure = null
        archiveTotal = activeSize
        videoOffset = 0L
        bytesStreamedSinceGc = 0L
        knownDurationMs = 0L
        lastRemoteMediaWriteAtMs.set(0L)
        totalRemoteMediaBytesSent.set(0L)

        synchronized(trackPatchLock) {
            matroskaHeaderAttempted = false
            matroskaHeaderInfo = null
            selectedCastAudioTrackNum = null
            selectedCastAudioOrdinal = null
            selectedCastSubtitleMode = MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL
            selectedCastSubtitleTrackNum = null
            selectedCastSubtitleOrdinal = null
            forceStereoCompatibility = false
            activeCastRegionPatch = null
            activeCastClusterBlockSwapper = null
            activeCastSubtitleSrtUrl = null
            activeCastSubtitleTrackNum = -1
            activeCastSubtitleStartMs = 0L
            cachedHeadPrefix = null
            cachedTailSlice = null
            castTrackEpoch.set(0L)
        }
        matroskaSubtitleExtractor.reset()

        isRunning = true

        // Bind to all local interfaces (0.0.0.0) so 127.0.0.1, Google Cast, and DLNA Smart TVs all work
        val s = ServerSocket(0, 24)
        serverSocket = s
        listeningPort = s.localPort

        val streamUrl = "http://127.0.0.1:$listeningPort/stream"
        activeRequestId.set(0L)
        com.cineflix.android.util.ErrorLogCollector.log(TAG, "start: fileId=$fileId size=$activeSize port=$listeningPort parts=${multipartParts?.size ?: 1}")
        Log.i(TAG, "🚀 LocalStreamServer iniciado en $streamUrl (size=$activeSize, mime=$activeMime, parts=${multipartParts?.size ?: 1})")

        executor.execute {
            while (isRunning && !s.isClosed) {
                try {
                    val client = s.accept()
                    clients.add(client)
                    executor.execute {
                        try { handleClient(client) } finally { clients.remove(client) }
                    }
                } catch (e: Exception) {
                    if (isRunning) {
                        Log.d(TAG, "Accept loop info: ${e.message}")
                    }
                }
            }
        }

        return streamUrl
    }

    /**
     * Updates the Audio and/or Subtitle track filter applied to remote Smart TV / Cast HTTP streams
     * (leaving local `127.0.0.1` `/stream` unpatched so ExoPlayer always retains all tracks).
     * Returns the new monotonic `castTrackEpoch` used to cache-bust TV URLs (`?te=<epoch>`).
     */
    fun updateCastTrackSelection(
        audioTrackNumber: Int?,
        audioOrdinal: Int?,
        subtitleMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode,
        subtitleTrackNumber: Int?,
        subtitleOrdinal: Int?,
        forceStereo: Boolean = false
    ): Long {
        val epoch = castTrackEpoch.incrementAndGet()
        synchronized(trackPatchLock) {
            selectedCastAudioTrackNum = audioTrackNumber
            selectedCastAudioOrdinal = audioOrdinal
            selectedCastSubtitleMode = subtitleMode
            selectedCastSubtitleTrackNum = subtitleTrackNumber
            selectedCastSubtitleOrdinal = subtitleOrdinal
            forceStereoCompatibility = forceStereo
            rebuildRegionPatchLocked()
        }
        Log.i(
            TAG,
            "🎛️ Cast track filter updated (epoch=$epoch): audio=#${audioTrackNumber ?: "?"}/ord=${audioOrdinal ?: "?"}, " +
            "subMode=$subtitleMode (#${subtitleTrackNumber ?: "?"}/ord=${subtitleOrdinal ?: "?"}), forceStereo=$forceStereo"
        )
        return epoch
    }

    private fun hasActiveTrackOverride(): Boolean {
        return selectedCastAudioTrackNum != null ||
            selectedCastAudioOrdinal != null ||
            selectedCastSubtitleMode != MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED
    }

    private fun rebuildRegionPatchLocked() {
        val info = matroskaHeaderInfo
        if (info == null || !hasActiveTrackOverride()) {
            activeCastRegionPatch = null
            activeCastClusterBlockSwapper = null
            return
        }
        val swapPair = MatroskaEbmlTrackPatcher.resolveAudioTrackNumberSwap(
            info = info,
            selectedAudioTrackNumber = selectedCastAudioTrackNum,
            selectedAudioOrdinal = selectedCastAudioOrdinal
        )
        val subSwapPair = if (selectedCastSubtitleMode == MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE) {
            MatroskaEbmlTrackPatcher.resolveSubtitleTrackNumberSwap(
                info = info,
                subtitleMode = selectedCastSubtitleMode,
                selectedSubtitleTrackNumber = selectedCastSubtitleTrackNum,
                selectedSubtitleOrdinal = selectedCastSubtitleOrdinal
            )
        } else {
            null
        }
        activeCastRegionPatch = MatroskaEbmlTrackPatcher.buildTracksRegionPatch(
            info = info,
            selectedAudioTrackNumber = selectedCastAudioTrackNum,
            selectedAudioOrdinal = selectedCastAudioOrdinal,
            subtitleMode = selectedCastSubtitleMode,
            selectedSubtitleTrackNumber = selectedCastSubtitleTrackNum,
            selectedSubtitleOrdinal = selectedCastSubtitleOrdinal,
            swapAudioTrackNumbers = (swapPair != null),
            swapSubtitleTrackNumbers = (subSwapPair != null)
        )
        activeCastClusterBlockSwapper = if (activeCastRegionPatch != null && (swapPair != null || subSwapPair != null)) {
            MatroskaEbmlTrackPatcher.ClusterBlockSwapper(
                tracksElementEnd = info.tracksElementEnd,
                firstClusterOffset = info.firstClusterOffset,
                trackA = swapPair?.first ?: -1,
                trackB = swapPair?.second ?: -1,
                subTrackA = subSwapPair?.first ?: -1,
                subTrackB = subSwapPair?.second ?: -1
            )
        } else {
            null
        }
        Log.i(
            TAG,
            "🧬 Rebuilt exact-size EBML <Tracks> region patch (${activeCastRegionPatch?.replacementBytes?.size ?: 0} bytes, " +
                "audioSwap=${swapPair?.let { "${it.first}<->${it.second}" } ?: "none"}, " +
                "subSwap=${subSwapPair?.let { "${it.first}<->${it.second}" } ?: "none"}) for Smart TV"
        )
    }

    /**
     * Parses and returns the Matroska `<Tracks>` metadata (cached after first inspection).
     * Must be called from a background thread / coroutine.
     */
    fun getOrParseMatroskaHeaderInfo(): MatroskaEbmlTrackPatcher.MatroskaHeaderInfo? {
        return ensureMatroskaHeaderParsed()
    }

    fun stopLiveTranscode() {
        liveTranscodeManager.stopActiveSession()
    }

    private fun cancelActiveDirectStreamSockets() {
        activeRequestId.incrementAndGet()
        val oldSocket = currentStreamingSocket
        currentStreamingSocket = null
        if (oldSocket != null && !oldSocket.isClosed) {
            try {
                oldSocket.close()
            } catch (_: Exception) {}
        }
    }

    /**
     * Builds a live on-phone transcoded `MPEG-TS` (`video/mp2t`, `H.264 <= 1080p + Stereo AAC-LC`) URL
     * starting at [startPositionMs], optionally pre-warming the phone's hardware `MediaCodec` + FFmpeg
     * transcode pipeline so `PAT + PMT + IDR Keyframe #1` are ready in RAM before the TV's `GET` arrives.
     */
    fun buildLiveTranscodeUrl(
        lanIp: String,
        startPositionMs: Long,
        isOrsayTv: Boolean = false,
        forceVideoTranscode: Boolean = false,
        prewarmSession: Boolean = true
    ): String {
        val safeStartMs = startPositionMs.coerceAtLeast(0L)
        val sid = liveTranscodeEpoch.incrementAndGet()
        val te = castTrackEpoch.get()
        val vFlag = if (forceVideoTranscode) 1 else 0
        val orsayFlag = if (isOrsayTv) 1 else 0

        if (prewarmSession) {
            cancelActiveDirectStreamSockets()
            val spec = buildCurrentTranscodeSpec(safeStartMs, forceVideoTranscode)
            liveTranscodeManager.getOrStartSession(spec)
        }
        return "http://$lanIp:$listeningPort/stream/live_transcode.ts?sid=$sid&te=$te&startMs=$safeStartMs&v=$vFlag&orsay=$orsayFlag"
    }

    private fun buildCurrentTranscodeSpec(
        startPositionMs: Long,
        forceVideoTranscode: Boolean,
        baseByteOffset: Long = 0L,
        tsPtsOffsetMs: Long = 0L
    ): LiveTranscodeManager.SessionSpec {
        return synchronized(trackPatchLock) {
            LiveTranscodeManager.SessionSpec(
                startPositionMs = startPositionMs.coerceAtLeast(0L),
                audioOrdinal = selectedCastAudioOrdinal,
                audioTrackNumber = selectedCastAudioTrackNum,
                subtitleMode = selectedCastSubtitleMode,
                subtitleOrdinal = selectedCastSubtitleOrdinal,
                subtitleTrackNumber = selectedCastSubtitleTrackNum,
                forceVideoTranscode = forceVideoTranscode,
                baseByteOffset = baseByteOffset.coerceAtLeast(0L),
                tsPtsOffsetMs = tsPtsOffsetMs.coerceAtLeast(0L),
                durationHintMs = knownDurationMs
            )
        }
    }

    /**
     * Builds the optimal DLNA URL + MIME plan for [targetDevice]:
     *  1. **On-Phone Real-Time Decoding / `MPEG-TS` Live Transcoding (`/stream/live_transcode.ts`)** when:
     *     - [forceLiveTranscode] is explicitly requested, OR
     *     - [targetDevice] is a 2010-2014 legacy Samsung Orsay TV (`UE40F6400`), guaranteeing 100% playback
     *       of `HEVC/H.265`, `4K`, `10-bit`, `MKV`, and `MP4` with full Audio & Subtitle selection, OR
     *     - Container/video is `WebM` / `AVI` / `AV1` / `VP9`, OR
     *     - Selected audio track requires FFmpeg decoding (`DTS`, `TrueHD`, `FLAC`, `Opus`, `Vorbis`, `PCM`)
     *       or the user explicitly switched Audio language from the phone on a multi-audio file, OR
     *     - Selected subtitle requires GPU burn-in (e.g. Blu-ray `PGS`/`VobSub` or embedded MP4 subtitles).
     *  2. **Zero-CPU Direct Stream (`/stream/cineflix.mkv` or `.mp4`)** for modern Smart TVs (`Samsung S95B`,
     *     `LG webOS`, `Sony Bravia`, `Hisense`) when video & default audio are natively supported, WITH
     *     automatic safety-net `fallbackUrl` pointing to on-phone live `MPEG-TS` transcoding!
     */
    fun buildLanDlnaStreamPlan(
        lanIp: String,
        targetDevice: DlnaDevice? = null,
        durationHintMs: Long = 0L,
        startPositionMs: Long = 0L,
        forceLiveTranscode: Boolean = false,
        forceAudioTranscode: Boolean = false,
        forceSubtitleBurnIn: Boolean = false
    ): DlnaStreamPlan {
        if (durationHintMs > 0L) {
            updateKnownDurationMs(durationHintMs)
        }
        val safeStartMs = startPositionMs.coerceAtLeast(0L)
        val spec = ensureContainerSpecDetected()
        val mkvInfo = if (spec.extension == "mkv") {
            ensureMatroskaHeaderParsed()
        } else {
            if (spec.extension == "mp4" && knownDurationMs <= 0L) {
                try {
                    val head = readLogicalVideoPrefix(minOf(FIRST_CHUNK_SIZE, activeSize).toInt())
                    val mp4Dur = extractMp4MvhdDurationMs(head)
                    if (mp4Dur > 0L) {
                        updateKnownDurationMs(mp4Dur)
                    }
                } catch (_: Exception) {}
            }
            null
        }
        val isHevc = mkvInfo?.hasHevcVideo == true
        val isOrsay = targetDevice?.isLegacySamsungOrsay == true

        val defaultMkvAudio = mkvInfo?.let { info ->
            info.audioTracks.firstOrNull { it.isDefault } ?: info.audioTracks.firstOrNull()
        }
        val activeMkvAudio = mkvInfo?.let { info ->
            val wantNum = selectedCastAudioTrackNum
            val wantOrd = selectedCastAudioOrdinal
            when {
                wantNum != null -> info.audioTracks.firstOrNull { it.trackNumber == wantNum }
                    ?: wantOrd?.let { info.audioTracks.getOrNull(it) }
                wantOrd != null -> info.audioTracks.getOrNull(wantOrd)
                else -> defaultMkvAudio
            }
        }
        val activeMkvSub = when (selectedCastSubtitleMode) {
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL -> null
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE -> {
                mkvInfo?.let { info ->
                    val wantNum = selectedCastSubtitleTrackNum
                    val wantOrd = selectedCastSubtitleOrdinal
                    when {
                        wantNum != null -> info.subtitleTracks.firstOrNull { it.trackNumber == wantNum }
                            ?: wantOrd?.let { info.subtitleTracks.getOrNull(it) }
                        wantOrd != null -> info.subtitleTracks.getOrNull(wantOrd)
                        else -> info.subtitleTracks.firstOrNull { !it.isImageSubtitle }
                    }
                }
            }
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED -> null
        }

        // For MKV containers, MatroskaEbmlTrackPatcher + ClusterBlockSwapper rewrites both the
        // <Tracks> header and every <Cluster> <SimpleBlock>/<Block> TrackNumber in-place at 0% CPU,
        // so switching between TV-compatible 5.1 AC3 / E-AC3 / AAC audio tracks stays on Direct Stream
        // with TRUE 5.1 Surround! Only MP4/non-MKV secondary audio tracks, exotic codecs (DTS/TrueHD/FLAC/Opus),
        // or user-enabled Stereo Compatibility ("Compatibilidad Estéreo") trigger live MPEG-TS transcoding.
        val hasNonMkvMultiAudioSelection = if (mkvInfo != null) {
            false
        } else {
            val ord = selectedCastAudioOrdinal
            ord != null && ord > 0
        }

        val audioNeedsPhoneDecode = forceAudioTranscode ||
            forceStereoCompatibility ||
            hasNonMkvMultiAudioSelection ||
            (activeMkvAudio?.requiresTvAudioTranscode == true)

        // For MKV text subtitles (S_TEXT/UTF8, S_TEXT/ASS), MatroskaEbmlTrackPatcher + ClusterBlockSwapper
        // patches <Tracks> and swaps the subtitle TrackNumber in <Cluster> in-place at 0% CPU on Direct Stream!
        // Only bitmap subtitles (Blu-ray PGS / VobSub) or explicit forceSubtitleBurnIn require GPU burn-in.
        val subNeedsGpuBurnIn = forceSubtitleBurnIn ||
            (activeMkvSub?.isImageSubtitle == true)

        val containerOrVideoNeedsTranscode = isOrsay ||
            spec.extension == "webm" ||
            spec.extension == "avi" ||
            (mkvInfo?.hasExoticVideoCodec == true)

        val usePrimaryLiveTranscode = forceLiveTranscode ||
            containerOrVideoNeedsTranscode ||
            audioNeedsPhoneDecode ||
            subNeedsGpuBurnIn

        val epoch = castTrackEpoch.get()
        val hasActiveTextSub = mkvInfo != null && activeMkvSub != null && !activeMkvSub.isImageSubtitle
        val directBaseName = when {
            hasActiveTextSub -> "cineflix_e${epoch}_t${activeMkvSub!!.trackNumber}"
            epoch > 0L -> "cineflix_e${epoch}"
            else -> "cineflix"
        }
        val primaryDirectUrl = "http://$lanIp:$listeningPort/stream/$directBaseName.${spec.extension}"

        if (usePrimaryLiveTranscode) {
            val needGpuVideoEncode = isHevc ||
                (mkvInfo?.hasExoticVideoCodec == true) ||
                spec.extension == "webm" ||
                (activeMkvSub?.isImageSubtitle == true) ||
                forceSubtitleBurnIn

            val liveUrl = buildLiveTranscodeUrl(
                lanIp = lanIp,
                startPositionMs = safeStartMs,
                isOrsayTv = isOrsay,
                forceVideoTranscode = needGpuVideoEncode,
                prewarmSession = true
            )
            // If primary used H.264 passthrough (v=0) and TV still had trouble (e.g. Level 5.1 / 10-bit H.264),
            // fallback forces full GPU H.264 Level 4.0 hardware re-encode (v=1).
            // Otherwise, if full GPU encode (v=1) was already primary and the TV wasn't Orsay, keep Direct Stream
            // as a last-resort fallback so playback never dead-ends.
            val fallbackUrl: String?
            val fallbackMime: String?
            val isFallbackLive: Boolean
            if (!needGpuVideoEncode) {
                fallbackUrl = buildLiveTranscodeUrl(
                    lanIp = lanIp,
                    startPositionMs = safeStartMs,
                    isOrsayTv = isOrsay,
                    forceVideoTranscode = true,
                    prewarmSession = false
                )
                fallbackMime = "video/mp2t"
                isFallbackLive = true
            } else if (!isOrsay && !containerOrVideoNeedsTranscode) {
                fallbackUrl = primaryDirectUrl
                fallbackMime = spec.mimeType
                isFallbackLive = false
            } else {
                fallbackUrl = null
                fallbackMime = null
                isFallbackLive = false
            }

            return DlnaStreamPlan(
                primaryUrl = liveUrl,
                primaryMime = "video/mp2t",
                isPrimaryLiveTranscode = true,
                primaryBaseOffsetMs = safeStartMs,
                fallbackUrl = fallbackUrl,
                fallbackMime = fallbackMime,
                isFallbackLiveTranscode = isFallbackLive,
                fallbackBaseOffsetMs = if (isFallbackLive) safeStartMs else 0L,
                isHevcVideo = isHevc
            )
        }

        // Fast 0-CPU Direct Stream path for modern Smart TVs with universal Phone Live Transcode fallback!
        liveTranscodeManager.stopActiveSession()

        val subtitleSrtUrl: String? = if (hasActiveTextSub && activeMkvSub != null) {
            // Stop any previous Direct Stream socket before pre-warming SRT cues so there is zero lock contention on BoundedVideoCache
            cancelActiveDirectStreamSockets()
            val srtBytes = matroskaSubtitleExtractor.prewarmAndBuildSrtBytes(
                info = mkvInfo!!,
                targetTrackNumber = activeMkvSub.trackNumber,
                startPositionMs = safeStartMs,
                baseOffsetMs = 0L,
                maxBudgetMs = 3500L
            )
            // Share the exact same base filename as primaryDirectUrl (`cineflix_eX_tY.mkv` <-> `cineflix_eX_tY.srt`)
            val subUrl = "http://$lanIp:$listeningPort/stream/$directBaseName.srt"
            activeCastSubtitleSrtUrl = subUrl
            activeCastSubtitleTrackNum = activeMkvSub.trackNumber
            activeCastSubtitleStartMs = safeStartMs
            Log.i(
                TAG,
                "💬 Prepared external DLNA SRT for track #${activeMkvSub.trackNumber} ('${activeMkvSub.name}', " +
                    "lang='${activeMkvSub.language}', forced=${activeMkvSub.isForced}, " +
                    "cues=${matroskaSubtitleExtractor.getHarvestedCueCount(activeMkvSub.trackNumber)}): ${srtBytes.size} bytes -> $subUrl"
            )
            subUrl
        } else {
            activeCastSubtitleSrtUrl = null
            activeCastSubtitleTrackNum = -1
            activeCastSubtitleStartMs = 0L
            null
        }

        val safetyFallbackLiveUrl = buildLiveTranscodeUrl(
            lanIp = lanIp,
            startPositionMs = safeStartMs,
            isOrsayTv = false,
            forceVideoTranscode = true,
            prewarmSession = false
        )

        return DlnaStreamPlan(
            primaryUrl = primaryDirectUrl,
            primaryMime = spec.mimeType,
            isPrimaryLiveTranscode = false,
            primaryBaseOffsetMs = 0L,
            subtitleSrtUrl = subtitleSrtUrl,
            fallbackUrl = safetyFallbackLiveUrl,
            fallbackMime = "video/mp2t",
            isFallbackLiveTranscode = true,
            fallbackBaseOffsetMs = safeStartMs,
            isHevcVideo = isHevc
        )
    }

    /**
     * Sniffs the real container magic bytes (0ms cache hit if first block was already read by ExoPlayer)
     * and returns the standard `(streamUrl, mimeType)` pair for DLNA Smart TVs.
     */
    fun resolveLanDlnaStreamSpec(lanIp: String): Pair<String, String> {
        val plan = buildLanDlnaStreamPlan(lanIp)
        return Pair(plan.primaryUrl, plan.primaryMime)
    }

    /**
     * Returns the LAN URL tailored for Google Cast's Default Media Receiver (`cast.mp4` route
     * serves `Content-Type: video/mp4` + CORS headers so Chromium's HTMLMediaElement passes
     * `canPlayType` while FFmpegDemuxer natively demuxes both MP4 and MKV).
     */
    fun resolveLanGoogleCastUrl(lanIp: String): String {
        val epoch = castTrackEpoch.get()
        val query = if (epoch > 0L) "?te=$epoch" else ""
        return "http://$lanIp:$listeningPort/stream/cast.mp4$query"
    }

    /**
     * Pre-warms and returns a WebVTT (`.vtt`) subtitle URL for Google Cast's Default Media Receiver
     * when an embedded Matroska text subtitle track is active, or `null` if subtitles are disabled.
     */
    fun resolveLanGoogleCastSubtitleVttUrl(lanIp: String, startPositionMs: Long = 0L): String? {
        val mkvInfo = ensureMatroskaHeaderParsed() ?: return null
        val subMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode
        val subNum: Int?
        val subOrd: Int?
        synchronized(trackPatchLock) {
            subMode = selectedCastSubtitleMode
            subNum = selectedCastSubtitleTrackNum
            subOrd = selectedCastSubtitleOrdinal
        }
        val activeMkvSub = when (subMode) {
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.DISABLE_ALL -> null
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE -> {
                mkvInfo.subtitleTracks.firstOrNull { subNum != null && it.trackNumber == subNum }
                    ?: subOrd?.let { mkvInfo.subtitleTracks.getOrNull(it) }
                    ?: mkvInfo.subtitleTracks.firstOrNull { !it.isImageSubtitle && it.isDefault }
                    ?: mkvInfo.subtitleTracks.firstOrNull { !it.isImageSubtitle }
            }
            MatroskaEbmlTrackPatcher.SubtitlePatchMode.UNCHANGED -> null
        } ?: return null
        if (activeMkvSub.isImageSubtitle) return null

        val safeStartMs = startPositionMs.coerceAtLeast(0L)
        val epoch = castTrackEpoch.get()
        matroskaSubtitleExtractor.prewarmAndBuildSrtBytes(
            info = mkvInfo,
            targetTrackNumber = activeMkvSub.trackNumber,
            startPositionMs = safeStartMs,
            baseOffsetMs = 0L,
            maxBudgetMs = 3000L
        )
        activeCastSubtitleTrackNum = activeMkvSub.trackNumber
        activeCastSubtitleStartMs = safeStartMs
        return "http://$lanIp:$listeningPort/stream/cineflix_e${epoch}_t${activeMkvSub.trackNumber}.vtt"
    }

    fun getEffectiveSizeBytes(): Long = activeSize

    fun getActiveFileId(): Int = activeFileId

    fun getActiveMultipartParts(): List<FilePart>? = activeParts

    private fun recordRemoteMediaBytesSent(byteCount: Int) {
        if (byteCount > 0) {
            totalRemoteMediaBytesSent.addAndGet(byteCount.toLong())
            lastRemoteMediaWriteAtMs.set(System.currentTimeMillis())
        }
    }

    /**
     * Returns true when a remote Smart TV / Cast client has consumed > 256 KB of media bytes
     * from this server and received payload data within the last [windowMs] milliseconds.
     */
    fun isRemoteClientActivelyStreaming(windowMs: Long = 10_000L): Boolean {
        if (!isRunning) return false
        val lastWrite = lastRemoteMediaWriteAtMs.get()
        if (lastWrite <= 0L) return false
        return totalRemoteMediaBytesSent.get() > 256L * 1024L &&
            (System.currentTimeMillis() - lastWrite) <= windowMs
    }

    private fun ensureContainerSpecDetected(): ContainerSpec {
        detectedContainer?.let { return it }
        if (!prepareArchive()) {
            return sniffContainerFromHeader(null, activeMime)
        }
        try {
            val head = readLogicalVideoPrefix(256)
            if (head != null && head.size >= 12) {
                val sniffed = sniffContainerFromHeader(head, activeMime)
                detectedContainer = sniffed
                activeMime = sniffed.mimeType
                Log.i(TAG, "🔍 Container auto-detected: .${sniffed.extension} (${sniffed.mimeType})")
                return sniffed
            }
        } catch (e: Exception) {
            Log.w(TAG, "Container sniff fallback to activeMime=$activeMime: ${e.message}")
        }
        val fallback = sniffContainerFromHeader(null, activeMime)
        detectedContainer = fallback
        return fallback
    }

    private fun ensureMatroskaHeaderParsed(): MatroskaEbmlTrackPatcher.MatroskaHeaderInfo? {
        matroskaHeaderInfo?.let { return it }
        if (matroskaHeaderAttempted) return null

        val spec = ensureContainerSpecDetected()
        if (spec.extension != "mkv") {
            synchronized(trackPatchLock) {
                matroskaHeaderAttempted = true
            }
            return null
        }

        try {
            val initialLen = minOf(FIRST_CHUNK_SIZE, activeSize).toInt()
            var prefix = readLogicalVideoPrefix(initialLen)
            if (prefix != null) {
                val neededBytes = MatroskaEbmlTrackPatcher.getRequiredBytesIfTruncated(prefix)
                if (neededBytes != null &&
                    neededBytes > prefix.size &&
                    neededBytes <= minOf(MAX_MATROSKA_HEADER_INSPECT_BYTES, activeSize)
                ) {
                    prefix = readLogicalVideoPrefix(neededBytes.toInt()) ?: prefix
                }
                val parsed = MatroskaEbmlTrackPatcher.parseHeader(prefix)
                if (parsed != null) {
                    if (parsed.durationMs > 0L) {
                        updateKnownDurationMs(parsed.durationMs)
                    }
                    if (parsed.segmentEndOffset > activeSize && activeParts.isNullOrEmpty() && !storedSevenZip) {
                        activeSize = parsed.segmentEndOffset
                        Log.i(TAG, "📏 Updated exact Matroska file size from EBML <Segment>: activeSize=$activeSize bytes")
                    }
                    matroskaSubtitleExtractor.harvestFromRawSlice(
                        sourceBuffer = prefix,
                        sliceOffset = 0,
                        sliceLength = prefix.size,
                        rangeGlobalStart = 0L,
                        info = parsed
                    )
                }
                synchronized(trackPatchLock) {
                    matroskaHeaderAttempted = true
                    matroskaHeaderInfo = parsed
                    if (parsed != null) {
                        Log.i(
                            TAG,
                            "🎬 Matroska EBML Tracks parsed: video=${parsed.videoTracks.size} (hevc=${parsed.hasHevcVideo}), " +
                            "audio=${parsed.audioTracks.size}, subs=${parsed.subtitleTracks.size}, endOffset=${parsed.tracksElementEnd}"
                        )
                        rebuildRegionPatchLocked()
                    }
                }
                return parsed
            }
        } catch (e: Exception) {
            Log.w(TAG, "Matroska header parse skipped: ${e.message}")
        }

        synchronized(trackPatchLock) {
            matroskaHeaderAttempted = true
        }
        return null
    }

    /**
     * Reads [requestedBytes] starting at logical video byte 0 (`videoOffset + 0`) across part boundaries
     * using 128 KB TDLib alignment, pinning up to 512 KB in `cachedHeadPrefix` for 0ms TV reloads.
     */
    private fun readLogicalVideoPrefix(requestedBytes: Int): ByteArray? {
        if (!isRunning || activeSize <= 0L || requestedBytes <= 0) return null
        val targetLen = minOf(requestedBytes.toLong(), activeSize).toInt()
        val existingHead = cachedHeadPrefix
        if (existingHead != null && existingHead.size >= targetLen) {
            return if (existingHead.size == targetLen) existingHead else existingHead.copyOf(targetLen)
        }

        val out = ByteArray(targetLen)
        var done = 0
        while (done < targetLen && isRunning) {
            val (partFileId, localOffset) = resolvePart(videoOffset + done)
            val partSize = activeParts?.find { it.fileId == partFileId }?.size ?: activeSize
            val canTake = minOf((targetLen - done).toLong(), partSize - localOffset).toInt()
            if (canTake <= 0) break

            val alignedOffset = localOffset - (localOffset % ALIGNMENT)
            val skip = (localOffset - alignedOffset).toInt()
            val blocks = ((skip + canTake + ALIGNMENT - 1) / ALIGNMENT)
            val fetchSize = min(blocks * ALIGNMENT, partSize - alignedOffset)
            if (fetchSize <= skip) break

            val data = engine.readBoundedVideoRange(partFileId, alignedOffset, fetchSize) ?: return null
            val available = data.size - skip
            if (available <= 0) return null
            val copyCount = minOf(canTake, available)
            data.copyInto(out, done, skip, skip + copyCount)
            done += copyCount
            if (copyCount < canTake) break
        }
        val result = if (done == targetLen) out else if (done > 0) out.copyOf(done) else null
        if (result != null && result.isNotEmpty()) {
            val cap = minOf(result.size, FIRST_CHUNK_SIZE.toInt())
            val prev = cachedHeadPrefix
            if (prev == null || cap > prev.size) {
                cachedHeadPrefix = if (result.size == cap) result.copyOf() else result.copyOf(cap)
            }
        }
        return result
    }

    /**
     * Direct in-process unpatched logical video reader for [LiveTranscodeManager].
     * Reuses `cachedHeadPrefix` (`0ms` RAM `<Tracks>`) and `cachedTailSlice` (`0ms` RAM `<Cues>`/`moov`)
     * and pins tail reads near EOF so Media3's `MatroskaExtractor` / `Mp4Extractor` seeks instantaneously.
     */
    private fun readLogicalRangeDirect(
        logicalOffset: Long,
        dst: ByteArray,
        dstOffset: Int,
        length: Int,
        isCancelled: () -> Boolean
    ): Int {
        if (!isRunning || isCancelled() || activeSize <= 0L || logicalOffset < 0L || logicalOffset >= activeSize || length <= 0) {
            return -1
        }
        val targetLen = minOf(length.toLong(), activeSize - logicalOffset).toInt()
        var done = 0

        while (done < targetLen && isRunning && !isCancelled()) {
            val curPos = logicalOffset + done
            val rem = targetLen - done

            // Fast-path 1: Pinned 512 KB RAM header prefix (return immediately in 0ms without blocking on TDLib!)
            val headMem = cachedHeadPrefix
            if (headMem != null && curPos < headMem.size) {
                val take = minOf(rem.toLong(), headMem.size.toLong() - curPos).toInt()
                if (take > 0) {
                    headMem.copyInto(dst, dstOffset + done, curPos.toInt(), curPos.toInt() + take)
                    done += take
                    return done
                }
            }

            // Fast-path 2: Pinned <=4 MB RAM EOF <Cues> / moov tail slice
            val tailMem = cachedTailSlice
            if (tailMem != null && curPos >= tailMem.startOffset && curPos < tailMem.startOffset + tailMem.bytes.size) {
                val inTail = (curPos - tailMem.startOffset).toInt()
                val take = minOf(rem.toLong(), (tailMem.bytes.size - inTail).toLong()).toInt()
                if (take > 0) {
                    tailMem.bytes.copyInto(dst, dstOffset + done, inTail, inTail + take)
                    done += take
                    return done
                }
            }

            val (partFileId, localOffset) = resolvePart(curPos + videoOffset)
            val partSize = activeParts?.find { it.fileId == partFileId }?.size ?: activeSize
            val canTake = minOf(rem.toLong(), partSize - localOffset).toInt()
            if (canTake <= 0) break

            val alignedOffset = localOffset - (localOffset % ALIGNMENT)
            val skip = (localOffset - alignedOffset).toInt()
            val blocks = ((skip + canTake + ALIGNMENT - 1) / ALIGNMENT)
            val fetchSize = min(blocks * ALIGNMENT, partSize - alignedOffset)
            if (fetchSize <= skip) break

            var chunk: ByteArray? = null
            var attempts = 0
            while (attempts < 20 && isRunning && !isCancelled()) {
                attempts++
                chunk = engine.readBoundedVideoRange(partFileId, alignedOffset, fetchSize)
                if (chunk != null && chunk.size > skip) break
                if (!isRunning || isCancelled()) break
                try {
                    Thread.sleep(minOf(250L, 60L * attempts))
                } catch (_: InterruptedException) {
                    Thread.currentThread().interrupt()
                    break
                }
            }
            if (chunk == null || chunk.size <= skip) break

            val copyCount = minOf(canTake, chunk.size - skip)
            chunk.copyInto(dst, dstOffset + done, skip, skip + copyCount)

            if (curPos == 0L) {
                val cap = minOf(copyCount, FIRST_CHUNK_SIZE.toInt())
                val prevHead = cachedHeadPrefix
                if (prevHead == null || cap > prevHead.size) {
                    cachedHeadPrefix = chunk.copyOfRange(skip, skip + cap)
                }
            } else if (curPos >= maxOf(0L, activeSize - PARALLEL_PROBE_MAX_BYTES) &&
                curPos + copyCount == activeSize &&
                copyCount <= PARALLEL_PROBE_MAX_BYTES.toInt()
            ) {
                val prevTail = cachedTailSlice
                if (prevTail == null || curPos < prevTail.startOffset) {
                    cachedTailSlice = TailCacheSlice(
                        startOffset = curPos,
                        bytes = chunk.copyOfRange(skip, skip + copyCount)
                    )
                }
            }

            done += copyCount
            if (copyCount < canTake) break
        }
        if (done > 16 && logicalOffset >= maxOf(0L, activeSize - PARALLEL_PROBE_MAX_BYTES)) {
            val fullSlice = dst.copyOfRange(dstOffset, dstOffset + done)
            val prevTail = cachedTailSlice
            if (prevTail == null ||
                (logicalOffset + done == activeSize && logicalOffset < prevTail.startOffset) ||
                fullSlice.size > prevTail.bytes.size
            ) {
                cachedTailSlice = TailCacheSlice(
                    startOffset = logicalOffset,
                    bytes = fullSlice
                )
            }
            matroskaHeaderInfo?.let { mkvInfo ->
                matroskaSubtitleExtractor.onPotentialCuesSliceRead(
                    sourceBuffer = fullSlice,
                    sliceOffset = 0,
                    sliceLength = fullSlice.size,
                    rangeGlobalStart = logicalOffset,
                    info = mkvInfo
                )
            }
        }
        return if (done > 0) done else -1
    }

    fun stop() {
        isRunning = false
        liveTranscodeManager.stopActiveSession()
        activeRequestId.incrementAndGet()
        lastRemoteMediaWriteAtMs.set(0L)
        totalRemoteMediaBytesSent.set(0L)
        currentStreamingSocket = null
        clients.forEach { try { it.close() } catch (_: Exception) {} }
        clients.clear()
        executor.shutdownNow()
        try {
            serverSocket?.close()
        } catch (_: Exception) {}
        serverSocket = null
        listeningPort = 0
        activeFileId = -1
        activeSize = 0L
        detectedContainer = null
        activeParts = null
        synchronized(trackPatchLock) {
            matroskaHeaderInfo = null
            activeCastRegionPatch = null
            activeCastClusterBlockSwapper = null
            activeCastSubtitleSrtUrl = null
            activeCastSubtitleTrackNum = -1
            activeCastSubtitleStartMs = 0L
            forceStereoCompatibility = false
            cachedHeadPrefix = null
            cachedTailSlice = null
        }
        matroskaSubtitleExtractor.reset()

        // Full storage purge when player stops
        try {
            engine.optimizeStorage(30L * 1024L * 1024L, immunityDelaySec = 0)
        } catch (_: Exception) {}
        com.cineflix.android.util.ErrorLogCollector.log(TAG, "stop: LocalStreamServer stopped")
        Log.i(TAG, "🛑 LocalStreamServer detenido y almacenamiento optimizado")
    }

    private fun handleClient(socket: Socket) {
        socket.use { s ->
            try {
                s.tcpNoDelay = true
                s.soTimeout = 25000
                val reader = BufferedReader(InputStreamReader(s.getInputStream(), StandardCharsets.US_ASCII))
                val requestLine = reader.readLine() ?: return

                val parts = requestLine.split(" ")
                if (parts.size < 2) {
                    sendSimple(s, 400, "Bad Request")
                    return
                }

                val method = parts[0].uppercase(Locale.ROOT)
                val rawPath = parts[1]
                val path = rawPath.substringBefore('?')

                var rangeHeader: String? = null
                var wantsSamsungMediaInfo = false
                var wantsSamsungCaptionInfo = false
                var line: String? = reader.readLine()
                while (!line.isNullOrEmpty()) {
                    if (line.startsWith("Range:", ignoreCase = true)) {
                        rangeHeader = line.substringAfter(":").trim()
                    } else if (line.startsWith("getMediaInfo.sec:", ignoreCase = true)) {
                        wantsSamsungMediaInfo = true
                    } else if (line.startsWith("getCaptionInfo.sec:", ignoreCase = true)) {
                        wantsSamsungCaptionInfo = true
                    }
                    line = reader.readLine()
                }

                val isOrsayMkvRoute = path.endsWith("_orsay.mkv", ignoreCase = true)
                val isLiveTranscodeRoute = path.startsWith("/stream/live_transcode", ignoreCase = true)
                val isSubtitleSrtRoute = path.endsWith(".srt", ignoreCase = true) ||
                    path.endsWith(".vtt", ignoreCase = true) ||
                    path.endsWith(".smi", ignoreCase = true)
                val isRemoteCastRoute = !path.equals("/stream", ignoreCase = true)
                val captionSrtUrl = if (isRemoteCastRoute && !isLiveTranscodeRoute && !isSubtitleSrtRoute) {
                    activeCastSubtitleSrtUrl
                } else {
                    null
                }

                if (method == "OPTIONS") {
                    val queryParams = parseQueryParams(rawPath)
                    val isOrsayLive = queryParams["orsay"] == "1"
                    val header = "HTTP/1.1 204 No Content\r\n" +
                                 (if (isLiveTranscodeRoute) {
                                     buildLiveTranscodeDlnaHeaders(isOrsayLive, wantsSamsungMediaInfo)
                                 } else {
                                     buildCommonDlnaAndCorsHeaders(isOrsayMkvRoute, wantsSamsungMediaInfo, captionSrtUrl)
                                 }) +
                                 "Connection: close\r\n\r\n"
                    val out = s.getOutputStream()
                    out.write(header.toByteArray(StandardCharsets.US_ASCII))
                    out.flush()
                    return
                }

                if (!path.startsWith("/stream")) {
                    sendSimple(s, 404, "Not Found")
                    return
                }

                if (!prepareArchive()) {
                    sendSimple(s, 422, "Unsupported Archive")
                    return
                }
                val total = activeSize
                if (total <= 0) {
                    sendSimple(s, 503, "Stream Not Ready")
                    return
                }

                if (isSubtitleSrtRoute) {
                    handleSubtitleSrtHttpClient(
                        socket = s,
                        method = method,
                        path = path,
                        rawPath = rawPath,
                        rangeHeader = rangeHeader
                    )
                    return
                }

                if (isLiveTranscodeRoute) {
                    handleLiveTranscodeHttpClient(
                        socket = s,
                        method = method,
                        rawPath = rawPath,
                        rangeHeader = rangeHeader,
                        wantsSamsungMediaInfo = wantsSamsungMediaInfo
                    )
                    return
                }

                val responseMime = resolveResponseMimeForPath(path)

                if (method == "HEAD") {
                    val header = "HTTP/1.1 200 OK\r\n" +
                                 "Content-Type: $responseMime\r\n" +
                                 "Content-Length: $total\r\n" +
                                 "Accept-Ranges: bytes\r\n" +
                                 buildCommonDlnaAndCorsHeaders(isOrsayMkvRoute, wantsSamsungMediaInfo, captionSrtUrl) +
                                 "Connection: close\r\n\r\n"
                    val out = s.getOutputStream()
                    out.write(header.toByteArray(StandardCharsets.US_ASCII))
                    out.flush()
                    Log.d(
                        TAG,
                        "HEAD 200 OK path=$path mime=$responseMime (size=$total, captionSec=$wantsSamsungCaptionInfo, srt=${captionSrtUrl != null})"
                    )
                    return
                }

                if (method != "GET") {
                    sendSimple(s, 405, "Method Not Allowed")
                    return
                }

                val hasRangeHeader = rangeHeader != null
                val range = if (hasRangeHeader) {
                    parseRange(rangeHeader!!, total)
                } else {
                    Pair(0L, total - 1)
                }

                if (range == null) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\n" +
                              "Content-Range: bytes */$total\r\n" +
                              buildCommonDlnaAndCorsHeaders(isOrsayMkvRoute, wantsSamsungMediaInfo, captionSrtUrl) +
                              "Connection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                val start = range.first
                val requestedEnd = range.second

                if (start >= total || requestedEnd < start) {
                    val err = "HTTP/1.1 416 Range Not Satisfiable\r\n" +
                              "Content-Range: bytes */$total\r\n" +
                              buildCommonDlnaAndCorsHeaders(isOrsayMkvRoute, wantsSamsungMediaInfo, captionSrtUrl) +
                              "Connection: close\r\n\r\n"
                    s.getOutputStream().write(err.toByteArray(StandardCharsets.US_ASCII))
                    s.getOutputStream().flush()
                    return
                }

                serveStream(
                    socket = s,
                    globalStart = start,
                    requestedEnd = requestedEnd,
                    hasRangeHeader = hasRangeHeader,
                    responseMime = responseMime,
                    isRemoteCastRoute = isRemoteCastRoute,
                    isOrsayMkvRoute = isOrsayMkvRoute,
                    wantsSamsungMediaInfo = wantsSamsungMediaInfo,
                    captionInfoSrtUrl = captionSrtUrl
                )
            } catch (e: Exception) {
                // Client disconnection or socket timeout is normal during seeking
                Log.d(TAG, "Client socket closed: ${e.message}")
            }
        }
    }

    private fun handleLiveTranscodeHttpClient(
        socket: Socket,
        method: String,
        rawPath: String,
        rangeHeader: String?,
        wantsSamsungMediaInfo: Boolean
    ) {
        val params = parseQueryParams(rawPath)
        val startMs = params["startMs"]?.toLongOrNull()?.coerceAtLeast(0L) ?: 0L
        val forceVideoTranscode = params["v"] == "1"
        val isOrsay = params["orsay"] == "1"
        if (knownDurationMs <= 0L) {
            ensureMatroskaHeaderParsed()
        }
        val remainingDurMs = if (knownDurationMs > startMs) knownDurationMs - startMs else knownDurationMs
        val dlnaHeaders = buildLiveTranscodeDlnaHeaders(isOrsay, wantsSamsungMediaInfo, remainingDurMs)
        val virtualTotalSize = LiveTranscodeManager.computeVirtualLiveTsSizeBytes(remainingDurMs, is1080p = true)

        val out = socket.getOutputStream()
        if (method == "HEAD") {
            val headResp = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: video/mp2t\r\n" +
                "Content-Length: $virtualTotalSize\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Cache-Control: no-cache, no-store\r\n" +
                dlnaHeaders +
                "Connection: close\r\n\r\n"
            out.write(headResp.toByteArray(StandardCharsets.US_ASCII))
            out.flush()
            Log.d(TAG, "HEAD 200 OK live_transcode.ts (startMs=$startMs, v=$forceVideoTranscode, orsay=$isOrsay, size=$virtualTotalSize)")
            return
        }

        if (method != "GET") {
            sendSimple(socket, 405, "Method Not Allowed")
            return
        }

        // Stop any previous Direct Stream HTTP worker so it stops competing for BoundedVideoCache / TDLib
        cancelActiveDirectStreamSockets()

        // Disable socket read timeout while streaming live TS (allows indefinite TV Pause without drop)
        try {
            socket.soTimeout = 0
        } catch (_: Exception) {}

        val parsedRange = if (rangeHeader != null) parseRange(rangeHeader, virtualTotalSize) else null
        val hasRange = parsedRange != null
        val reqStart = parsedRange?.first ?: 0L
        val reqEnd = parsedRange?.second ?: (virtualTotalSize - 1L)
        val contentLen = (reqEnd - reqStart + 1L).coerceAtLeast(1L)
        val maxBytesToDeliver = if (contentLen <= 4L * 1024L * 1024L && contentLen < virtualTotalSize) {
            contentLen
        } else {
            null
        }
        val isFarEofProbe = reqStart > 4L * 1024L * 1024L && maxBytesToDeliver != null

        // Detect TV-remote-initiated HTTP byte-range seeks (open-ended GET with Range: bytes=reqStart- outside current produced window)
        val activeSession = liveTranscodeManager.getActiveSession()
        val isTvRemoteByteSeek = if (hasRange && maxBytesToDeliver == null && remainingDurMs > 0L && virtualTotalSize > 0L) {
            if (activeSession != null) {
                val (curBase, curEnd) = activeSession.getProducedStreamRange()
                reqStart > curEnd + 2L * 1024L * 1024L || (curBase > 0L && reqStart + 512L * 1024L < curBase)
            } else {
                reqStart > 4L * 1024L * 1024L
            }
        } else {
            false
        }

        val effectiveStartMs: Long
        val effectiveBaseByteOffset: Long
        val effectiveTsPtsOffsetMs: Long
        if (isTvRemoteByteSeek) {
            val seekRatio = (reqStart.toDouble() / virtualTotalSize.toDouble()).coerceIn(0.0, 0.985)
            val seekDeltaMs = (seekRatio * remainingDurMs.toDouble()).toLong().coerceAtLeast(0L)
            effectiveStartMs = if (knownDurationMs > 10_000L) {
                (startMs + seekDeltaMs).coerceIn(0L, knownDurationMs - 5_000L)
            } else {
                startMs + seekDeltaMs
            }
            effectiveBaseByteOffset = reqStart
            effectiveTsPtsOffsetMs = (effectiveStartMs - startMs).coerceAtLeast(0L)
            Log.i(
                TAG,
                "⏩ TV-remote byte-range seek detected on live_transcode.ts: reqStart=$reqStart/$virtualTotalSize " +
                    "(${String.format(Locale.US, "%.1f%%", seekRatio * 100.0)}) -> moviePos=${effectiveStartMs}ms"
            )
            try {
                onRemoteTvLiveSeek?.invoke(effectiveStartMs)
            } catch (_: Throwable) {}
        } else {
            effectiveStartMs = activeSession?.spec?.startPositionMs ?: startMs
            effectiveBaseByteOffset = activeSession?.baseByteOffset ?: 0L
            effectiveTsPtsOffsetMs = activeSession?.spec?.tsPtsOffsetMs ?: 0L
        }

        var spec = buildCurrentTranscodeSpec(
            startPositionMs = effectiveStartMs,
            forceVideoTranscode = forceVideoTranscode,
            baseByteOffset = effectiveBaseByteOffset,
            tsPtsOffsetMs = effectiveTsPtsOffsetMs
        )
        var session = liveTranscodeManager.getOrStartSession(spec)
        if (!isFarEofProbe) {
            if (!session.awaitInitialBytes() && !forceVideoTranscode) {
                Log.w(TAG, "⚠️ Live MPEG-TS passthrough session produced 0 initial bytes; retrying with full hardware video transcode (v=1)")
                spec = buildCurrentTranscodeSpec(
                    startPositionMs = effectiveStartMs,
                    forceVideoTranscode = true,
                    baseByteOffset = effectiveBaseByteOffset,
                    tsPtsOffsetMs = effectiveTsPtsOffsetMs
                )
                session = liveTranscodeManager.getOrStartSession(spec)
            }
            if (!session.awaitInitialBytes()) {
                Log.e(
                    TAG,
                    "❌ Live MPEG-TS session produced 0 initial bytes (startMs=$effectiveStartMs, v=${spec.forceVideoTranscode}): " +
                        "${session.getFatalError()?.message ?: "timeout"}",
                    session.getFatalError()
                )
                sendSimple(socket, 500, "Live Transcode Failed")
                return
            }
        }

        val getHeader = if (hasRange) {
            "HTTP/1.1 206 Partial Content\r\n" +
                "Content-Type: video/mp2t\r\n" +
                "Content-Length: $contentLen\r\n" +
                "Content-Range: bytes $reqStart-$reqEnd/$virtualTotalSize\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Cache-Control: no-cache, no-store\r\n" +
                dlnaHeaders +
                "Connection: close\r\n\r\n"
        } else {
            "HTTP/1.1 200 OK\r\n" +
                "Content-Type: video/mp2t\r\n" +
                "Content-Length: $virtualTotalSize\r\n" +
                "Accept-Ranges: bytes\r\n" +
                "Cache-Control: no-cache, no-store\r\n" +
                dlnaHeaders +
                "Connection: close\r\n\r\n"
        }

        out.write(getHeader.toByteArray(StandardCharsets.US_ASCII))
        out.flush()

        Log.i(
            TAG,
            "⚡ Serving live MPEG-TS transcode to Smart TV (startMs=$startMs, v=$forceVideoTranscode, " +
                "orsay=$isOrsay, clientRange=${rangeHeader ?: "none"}, reqStart=$reqStart, maxBytes=${maxBytesToDeliver ?: "unlimited"})"
        )
        val trackedOut = object : java.io.OutputStream() {
            override fun write(b: Int) {
                out.write(b)
                if (!isFarEofProbe) recordRemoteMediaBytesSent(1)
            }

            override fun write(b: ByteArray, off: Int, len: Int) {
                out.write(b, off, len)
                if (!isFarEofProbe) recordRemoteMediaBytesSent(len)
            }

            override fun flush() {
                out.flush()
            }
        }
        liveTranscodeManager.streamToHttpClient(
            spec = spec,
            requestedStartByte = reqStart,
            requestedMaxBytes = maxBytesToDeliver,
            clientOut = trackedOut
        )
    }

    private fun buildLiveTranscodeDlnaHeaders(
        isOrsay: Boolean,
        wantsSamsungMediaInfo: Boolean,
        durationMs: Long = knownDurationMs
    ): String {
        val dlnaFlags = if (isOrsay) {
            DlnaSoapBuilder.DLNA_ORSAY_LIVE_TS_FLAGS
        } else {
            DlnaSoapBuilder.DLNA_LIVE_TS_FLAGS
        }
        val secMediaInfo = if (durationMs > 0L) {
            "MediaInfo.sec: SEC_Duration=$durationMs;\r\n"
        } else {
            ""
        }
        return "Access-Control-Allow-Origin: *\r\n" +
               "Access-Control-Allow-Methods: GET, HEAD, OPTIONS\r\n" +
               "Access-Control-Allow-Headers: Range, Accept-Encoding, Origin, User-Agent, getcontentFeatures.dlna.org, transferMode.dlna.org, getMediaInfo.sec\r\n" +
               "Access-Control-Expose-Headers: Content-Length, Content-Range, Content-Type, Accept-Ranges\r\n" +
               "transferMode.dlna.org: Streaming\r\n" +
               "contentFeatures.dlna.org: $dlnaFlags\r\n" +
               secMediaInfo
    }

    private fun parseQueryParams(rawPath: String): Map<String, String> {
        val qIdx = rawPath.indexOf('?')
        if (qIdx < 0 || qIdx + 1 >= rawPath.length) return emptyMap()
        val query = rawPath.substring(qIdx + 1)
        val map = HashMap<String, String>()
        for (pair in query.split('&')) {
            val eq = pair.indexOf('=')
            if (eq > 0) {
                map[pair.substring(0, eq)] = pair.substring(eq + 1)
            }
        }
        return map
    }

    private fun resolveResponseMimeForPath(path: String): String {
        val lower = path.lowercase(Locale.ROOT)
        return when {
            lower.endsWith("/cast.mp4") -> "video/mp4"
            lower.endsWith("_orsay.mkv") -> "video/x-mkv"
            lower.endsWith(".mkv") -> "video/x-matroska"
            lower.endsWith(".webm") -> "video/webm"
            lower.endsWith(".avi") -> "video/x-msvideo"
            lower.endsWith(".ts") -> "video/mp2t"
            lower.endsWith(".mp4") -> "video/mp4"
            else -> detectedContainer?.mimeType ?: activeMime
        }
    }

    private fun handleSubtitleSrtHttpClient(
        socket: Socket,
        method: String,
        path: String,
        rawPath: String,
        rangeHeader: String?
    ) {
        val params = parseQueryParams(rawPath)
        val pathTrackMatch = Regex("""_t(\d+)(?:_|\.)""", RegexOption.IGNORE_CASE)
            .find(path)?.groupValues?.getOrNull(1)?.toIntOrNull()
        val info = ensureMatroskaHeaderParsed()
        val targetTrackNum = params["track"]?.toIntOrNull()
            ?: pathTrackMatch
            ?: activeCastSubtitleTrackNum.takeIf { it > 0 }
            ?: selectedCastSubtitleTrackNum
            ?: selectedCastSubtitleOrdinal?.let { info?.subtitleTracks?.getOrNull(it)?.trackNumber }
            ?: info?.subtitleTracks?.firstOrNull { !it.isImageSubtitle && it.isForced }?.trackNumber
            ?: info?.subtitleTracks?.firstOrNull { !it.isImageSubtitle && it.isDefault }?.trackNumber
            ?: info?.subtitleTracks?.firstOrNull { !it.isImageSubtitle }?.trackNumber
            ?: -1

        val startMs = params["startMs"]?.toLongOrNull()?.coerceAtLeast(0L)
            ?: activeCastSubtitleStartMs.coerceAtLeast(0L)
        val baseOffsetMs = params["baseOffsetMs"]?.toLongOrNull()?.coerceAtLeast(0L) ?: 0L
        val isWebVtt = path.endsWith(".vtt", ignoreCase = true)
        val isSami = path.endsWith(".smi", ignoreCase = true)
        val contentType = when {
            isWebVtt -> "text/vtt; charset=utf-8"
            isSami -> "smi/caption"
            else -> "text/srt"
        }

        val subBytes = when {
            isWebVtt -> matroskaSubtitleExtractor.getOrBuildVttBytes(
                info = info,
                targetTrackNumber = targetTrackNum,
                startPositionMs = startMs,
                baseOffsetMs = baseOffsetMs
            )
            isSami -> matroskaSubtitleExtractor.getOrBuildSmiBytes(
                info = info,
                targetTrackNumber = targetTrackNum,
                startPositionMs = startMs,
                baseOffsetMs = baseOffsetMs
            )
            else -> matroskaSubtitleExtractor.getOrBuildSrtBytes(
                info = info,
                targetTrackNumber = targetTrackNum,
                startPositionMs = startMs,
                baseOffsetMs = baseOffsetMs
            )
        }
        val totalLen = subBytes.size.toLong()
        val out = socket.getOutputStream()
        val subDlnaHeaders =
            "Access-Control-Allow-Origin: *\r\n" +
            "Access-Control-Allow-Methods: GET, HEAD, OPTIONS\r\n" +
            "Access-Control-Allow-Headers: Range, Accept-Encoding, Origin, User-Agent, getcontentFeatures.dlna.org, transferMode.dlna.org\r\n" +
            "Access-Control-Expose-Headers: Content-Length, Content-Range, Content-Type, Accept-Ranges\r\n" +
            "transferMode.dlna.org: Interactive\r\n" +
            "contentFeatures.dlna.org: ${DlnaSoapBuilder.DLNA_STREAMING_FLAGS}\r\n"

        if (method == "HEAD") {
            val headResp = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: $contentType\r\n" +
                "Content-Length: $totalLen\r\n" +
                "Accept-Ranges: bytes\r\n" +
                subDlnaHeaders +
                "Connection: close\r\n\r\n"
            out.write(headResp.toByteArray(StandardCharsets.US_ASCII))
            out.flush()
            Log.d(TAG, "HEAD 200 OK $path (track=$targetTrackNum, size=$totalLen bytes)")
            return
        }

        if (method != "GET") {
            sendSimple(socket, 405, "Method Not Allowed")
            return
        }

        val parsedRange = if (rangeHeader != null && totalLen > 0L) parseRange(rangeHeader, totalLen) else null
        if (parsedRange != null) {
            val rStart = parsedRange.first.toInt()
            val rEnd = parsedRange.second.toInt()
            val rLen = (rEnd - rStart + 1).coerceAtLeast(0)
            val getHeader = "HTTP/1.1 206 Partial Content\r\n" +
                "Content-Type: $contentType\r\n" +
                "Content-Length: $rLen\r\n" +
                "Content-Range: bytes $rStart-$rEnd/$totalLen\r\n" +
                "Accept-Ranges: bytes\r\n" +
                subDlnaHeaders +
                "Connection: close\r\n\r\n"
            out.write(getHeader.toByteArray(StandardCharsets.US_ASCII))
            if (rLen > 0) {
                out.write(subBytes, rStart, rLen)
            }
            out.flush()
            Log.i(TAG, "💬 Served Subtitle 206 $path (track=$targetTrackNum, range=$rStart-$rEnd/$totalLen)")
        } else {
            val getHeader = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: $contentType\r\n" +
                "Content-Length: $totalLen\r\n" +
                "Accept-Ranges: bytes\r\n" +
                subDlnaHeaders +
                "Connection: close\r\n\r\n"
            out.write(getHeader.toByteArray(StandardCharsets.US_ASCII))
            out.write(subBytes)
            out.flush()
            Log.i(TAG, "💬 Served Subtitle 200 $path (track=$targetTrackNum, size=$totalLen bytes)")
        }
    }

    private fun buildCommonDlnaAndCorsHeaders(
        isOrsayMkvRoute: Boolean = false,
        wantsSamsungMediaInfo: Boolean = false,
        captionInfoSrtUrl: String? = null
    ): String {
        val dlnaFlags = if (isOrsayMkvRoute) {
            DlnaSoapBuilder.DLNA_ORSAY_STREAMING_FLAGS
        } else {
            DlnaSoapBuilder.DLNA_STREAMING_FLAGS
        }
        val secMediaInfo = if ((wantsSamsungMediaInfo || isOrsayMkvRoute) && knownDurationMs > 0L) {
            "MediaInfo.sec: SEC_Duration=$knownDurationMs;\r\n"
        } else {
            ""
        }
        val secCaptionInfo = if (!captionInfoSrtUrl.isNullOrBlank()) {
            "CaptionInfo.sec: $captionInfoSrtUrl\r\n"
        } else {
            ""
        }
        return "Access-Control-Allow-Origin: *\r\n" +
               "Access-Control-Allow-Methods: GET, HEAD, OPTIONS\r\n" +
               "Access-Control-Allow-Headers: Range, Accept-Encoding, Origin, User-Agent, getcontentFeatures.dlna.org, transferMode.dlna.org, getMediaInfo.sec, getCaptionInfo.sec\r\n" +
               "Access-Control-Expose-Headers: Content-Length, Content-Range, Accept-Ranges, CaptionInfo.sec\r\n" +
               "transferMode.dlna.org: Streaming\r\n" +
               "contentFeatures.dlna.org: $dlnaFlags\r\n" +
               secMediaInfo +
               secCaptionInfo
    }

    private fun resolvePart(globalOffset: Long): Pair<Int, Long> {
        val parts = activeParts
        if (parts.isNullOrEmpty()) return Pair(activeFileId, globalOffset)
        var accumulated = 0L
        for (p in parts) {
            if (globalOffset < accumulated + p.size) {
                return Pair(p.fileId, globalOffset - accumulated)
            }
            accumulated += p.size
        }
        val lastPart = parts.last()
        return Pair(lastPart.fileId, globalOffset - (accumulated - lastPart.size))
    }

    // Runs on HTTP workers, never the UI thread. Header reads use the same bounded cache
    // and TDLib alignment as playback; no full extraction or second disk cache is created.
    @Synchronized
    private fun prepareArchive(): Boolean {
        if (!storedSevenZip || archiveReady) return true
        if (archiveFailure != null || !isRunning) return false
        try {
            val video = StoredSevenZip.inspect(archiveTotal, ::readArchiveBytes)
            if (!isRunning) return false
            videoOffset = video.offset
            activeSize = video.size
            activeMime = when (video.name.substringAfterLast('.').lowercase(Locale.ROOT)) {
                "mkv" -> "video/x-matroska"
                "avi" -> "video/x-msvideo"
                "ts" -> "video/mp2t"
                "mov" -> "video/quicktime"
                else -> "video/mp4"
            }
            archiveReady = true
            Log.i(TAG, "7z Copy mapped: offset=$videoOffset videoBytes=$activeSize archiveBytes=$archiveTotal")
            return true
        } catch (e: Exception) {
            archiveFailure = e.message ?: "No se pudo leer el índice 7z"
            Log.e(TAG, "7z preflight failed", e)
            archiveError?.invoke(archiveFailure!!)
            return false
        }
    }

    private fun readArchiveBytes(offset: Long, count: Int): ByteArray {
        require(offset >= 0 && count > 0 && offset <= archiveTotal - count)
        val result = ByteArray(count)
        var done = 0
        while (done < count) {
            check(isRunning) { "Reproducción cancelada" }
            val (id, local) = resolvePart(offset + done)
            val size = activeParts?.first { it.fileId == id }?.size ?: archiveTotal
            val take = minOf((count - done).toLong(), size - local).toInt()
            check(take > 0) { "Parte 7z incompleta" }
            val aligned = local - local % ALIGNMENT
            val skip = (local - aligned).toInt()
            val fetch = minOf(((skip + take + ALIGNMENT - 1) / ALIGNMENT) * ALIGNMENT, size - aligned)
            val data = engine.readBoundedVideoRange(id, aligned, fetch)
                ?: throw java.io.IOException("No se pudo descargar el índice 7z; comprueba la conexión y las partes")
            check(data.size >= skip + take) { "Lectura 7z incompleta" }
            data.copyInto(result, done, skip, skip + take)
            done += take
        }
        return result
    }

    private fun serveStream(
        socket: Socket,
        globalStart: Long,
        requestedEnd: Long,
        hasRangeHeader: Boolean,
        responseMime: String,
        isRemoteCastRoute: Boolean,
        isOrsayMkvRoute: Boolean,
        wantsSamsungMediaInfo: Boolean,
        captionInfoSrtUrl: String? = null
    ) {
        val totalLength = (requestedEnd - globalStart) + 1
        if (totalLength <= 0) {
            sendSimple(socket, 416, "Range Not Satisfiable")
            return
        }

        // Ensure EBML track region patch is ready if this is a remote TV header request and user selected a track
        if (isRemoteCastRoute && hasActiveTrackOverride() && !matroskaHeaderAttempted) {
            ensureMatroskaHeaderParsed()
        }
        val requestRegionPatch = if (isRemoteCastRoute) activeCastRegionPatch else null
        val requestClusterSwapper = if (isRemoteCastRoute) activeCastClusterBlockSwapper else null

        // Smart TV DLNA players (Samsung Tizen, Samsung Orsay, LG webOS, Sony) often issue a small bounded
        // tail/header Range probe (e.g. 64KB..1MB near EOF to parse MKV Cues / MP4 moov)
        // in parallel with their primary open-ended video stream. Do NOT kill the primary
        // stream socket when serving a small bounded metadata probe!
        val isParallelBoundedProbe = hasRangeHeader &&
            totalLength <= PARALLEL_PROBE_MAX_BYTES &&
            totalLength < activeSize

        val myRequestId: Long
        if (isParallelBoundedProbe) {
            myRequestId = activeRequestId.get()
        } else {
            val oldSocket = currentStreamingSocket
            currentStreamingSocket = socket
            if (oldSocket != null && oldSocket != socket && !oldSocket.isClosed) {
                try {
                    oldSocket.close()
                } catch (_: Exception) {}
            }
            myRequestId = activeRequestId.incrementAndGet()
        }

        val reqStartTime = System.currentTimeMillis()
        com.cineflix.android.util.ErrorLogCollector.log(
            TAG,
            "Req #$myRequestId (probe=$isParallelBoundedProbe, cast=$isRemoteCastRoute) start: range=$globalStart-$requestedEnd ($totalLength bytes)"
        )

        val out = socket.getOutputStream()
        val commonHeaders = buildCommonDlnaAndCorsHeaders(isOrsayMkvRoute, wantsSamsungMediaInfo, captionInfoSrtUrl)
        val header = if (hasRangeHeader) {
            "HTTP/1.1 206 Partial Content\r\n" +
            "Content-Type: $responseMime\r\n" +
            "Content-Length: $totalLength\r\n" +
            "Content-Range: bytes $globalStart-$requestedEnd/$activeSize\r\n" +
            "Accept-Ranges: bytes\r\n" +
            commonHeaders +
            "Connection: close\r\n\r\n"
        } else {
            "HTTP/1.1 200 OK\r\n" +
            "Content-Type: $responseMime\r\n" +
            "Content-Length: $totalLength\r\n" +
            "Accept-Ranges: bytes\r\n" +
            commonHeaders +
            "Connection: close\r\n\r\n"
        }

        try {
            out.write(header.toByteArray(StandardCharsets.US_ASCII))
            out.flush()
        } catch (e: Exception) {
            Log.d(TAG, "Socket closed before writing header: ${e.message}")
            com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId closed before header: ${e.message}")
            return
        }

        Log.d(TAG, "HTTP ${if (hasRangeHeader) 206 else 200} stream start (probe=$isParallelBoundedProbe, mime=$responseMime): $globalStart-$requestedEnd/$activeSize ($totalLength bytes)")

        var currentPos = globalStart
        var isFirstChunk = true

        fun shouldContinue(): Boolean {
            if (!isRunning) return false
            return isParallelBoundedProbe || (myRequestId == activeRequestId.get())
        }

        while (currentPos <= requestedEnd && shouldContinue()) {
            val (partFileId, localOffset) = resolvePart(currentPos + videoOffset)
            val partSize = activeParts?.find { it.fileId == partFileId }?.size ?: activeSize
            val availableInPart = maxOf(0L, partSize - localOffset)
            val remainingInRequest = requestedEnd - currentPos + 1
            val maxCanReadFromPart = minOf(remainingInRequest, availableInPart)
            if (maxCanReadFromPart <= 0) break

            if (!shouldContinue()) {
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId superseded before fetch at pos=$currentPos")
                break
            }

            // Instant first chunk: 256KB for bounded probes, 512KB for initial frame/seek, then 2MB for continuous streaming
            val targetChunkSize = when {
                isParallelBoundedProbe -> PROBE_CHUNK_SIZE
                isFirstChunk -> FIRST_CHUNK_SIZE
                else -> STREAM_CHUNK_SIZE
            }

            // 0ms RAM Fast-Path #1: Pinned 512 KB header prefix (serves TV <Tracks> reloads without moving TDLib window!)
            val headMem = cachedHeadPrefix
            if (headMem != null && currentPos < headMem.size) {
                val availInHead = headMem.size.toLong() - currentPos
                val take = minOf(remainingInRequest, minOf(availInHead, targetChunkSize)).toInt()
                if (take > 0) {
                    val sliceOff = currentPos.toInt()
                    val patched = applyCastMatroskaPatches(
                        sourceBuffer = headMem,
                        sliceOffset = sliceOff,
                        sliceLength = take,
                        rangeGlobalStart = currentPos,
                        regionPatch = requestRegionPatch,
                        clusterSwapper = requestClusterSwapper
                    )
                    try {
                        if (patched != null) {
                            out.write(patched, 0, patched.size)
                        } else {
                            out.write(headMem, sliceOff, take)
                        }
                        out.flush()
                        if (isRemoteCastRoute && !isParallelBoundedProbe) {
                            recordRemoteMediaBytesSent(take)
                        }
                    } catch (e: Exception) {
                        Log.d(TAG, "Client socket closed during RAM head write: ${e.message}")
                        break
                    }
                    currentPos += take
                    isFirstChunk = false
                    continue
                }
            }

            // 0ms RAM Fast-Path #2: Pinned EOF <Cues> / moov tail slice (serves TV seek-table probes instantly!)
            val tailMem = cachedTailSlice
            if (tailMem != null &&
                currentPos >= tailMem.startOffset &&
                currentPos < tailMem.startOffset + tailMem.bytes.size
            ) {
                val localOff = (currentPos - tailMem.startOffset).toInt()
                val availInTail = (tailMem.bytes.size - localOff).toLong()
                val take = minOf(remainingInRequest, minOf(availInTail, targetChunkSize)).toInt()
                if (take > 0) {
                    val patched = applyCastMatroskaPatches(
                        sourceBuffer = tailMem.bytes,
                        sliceOffset = localOff,
                        sliceLength = take,
                        rangeGlobalStart = currentPos,
                        regionPatch = requestRegionPatch,
                        clusterSwapper = requestClusterSwapper
                    )
                    try {
                        if (patched != null) {
                            out.write(patched, 0, patched.size)
                        } else {
                            out.write(tailMem.bytes, localOff, take)
                        }
                        out.flush()
                        if (isRemoteCastRoute && !isParallelBoundedProbe) {
                            recordRemoteMediaBytesSent(take)
                        }
                    } catch (e: Exception) {
                        Log.d(TAG, "Client socket closed during RAM tail write: ${e.message}")
                        break
                    }
                    currentPos += take
                    isFirstChunk = false
                    continue
                }
            }

            val bytesToReadThisRound = minOf(targetChunkSize, maxCanReadFromPart)

            // Align offset to 128KB (131072 bytes) as required by Telegram TDLib
            val alignedOffset = localOffset - (localOffset % ALIGNMENT)
            val offsetInsideBlock = (localOffset - alignedOffset).toInt()
            val neededBytes = offsetInsideBlock + bytesToReadThisRound
            val blocks = (neededBytes + ALIGNMENT - 1) / ALIGNMENT
            val fetchSize = min(blocks * ALIGNMENT, partSize - alignedOffset)

            // All reads go through the same bounded window, including cache hits.
            var chunk: ByteArray? = null
            if (shouldContinue()) {
                var attempts = 0
                while (attempts < 4 && shouldContinue()) {
                    attempts++
                    chunk = engine.readBoundedVideoRange(partFileId, alignedOffset, fetchSize)
                    if (chunk != null && chunk.size > offsetInsideBlock) {
                        break
                    }
                    if (!shouldContinue()) break
                    try {
                        Thread.sleep(80L * attempts)
                    } catch (_: InterruptedException) {
                        Thread.currentThread().interrupt()
                        break
                    }
                }
            }

            if (!shouldContinue()) {
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId superseded after fetch at pos=$currentPos")
                break
            }

            if (chunk == null || chunk.size <= offsetInsideBlock) {
                Log.e(TAG, "❌ Error al descargar chunk TDLib: offset=$alignedOffset fetchSize=$fetchSize")
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId fetch error: offset=$alignedOffset fetchSize=$fetchSize")
                break
            }

            // Opportunistically cache true container type from offset 0 read at zero cost
            if (detectedContainer == null && globalStart == 0L && currentPos == 0L && chunk.size >= offsetInsideBlock + 16) {
                val headLen = minOf(256, chunk.size - offsetInsideBlock)
                val head = chunk.copyOfRange(offsetInsideBlock, offsetInsideBlock + headLen)
                val sniffed = sniffContainerFromHeader(head, activeMime)
                detectedContainer = sniffed
                activeMime = sniffed.mimeType
            }

            val sliceEnd = minOf(chunk.size.toLong(), offsetInsideBlock + bytesToReadThisRound).toInt()
            val sliceSize = sliceEnd - offsetInsideBlock
            if (sliceSize <= 0) break

            // Pin first 512 KB header prefix & last <=1 MB EOF <Cues> slice in RAM for 0ms Smart TV track-switch reloads
            if (currentPos == 0L) {
                val cap = minOf(sliceSize, FIRST_CHUNK_SIZE.toInt())
                val prevHead = cachedHeadPrefix
                if (prevHead == null || cap > prevHead.size) {
                    cachedHeadPrefix = chunk.copyOfRange(offsetInsideBlock, offsetInsideBlock + cap)
                }
            } else if (currentPos >= maxOf(0L, activeSize - PARALLEL_PROBE_MAX_BYTES) &&
                currentPos + sliceSize == activeSize &&
                sliceSize <= PARALLEL_PROBE_MAX_BYTES.toInt()
            ) {
                val prevTail = cachedTailSlice
                if (prevTail == null || currentPos < prevTail.startOffset) {
                    cachedTailSlice = TailCacheSlice(
                        startOffset = currentPos,
                        bytes = chunk.copyOfRange(offsetInsideBlock, offsetInsideBlock + sliceSize)
                    )
                }
            }

            // Passively harvest any Matroska subtitle cues (and <Cues> index near EOF) in this slice at 0 extra I/O cost
            matroskaHeaderInfo?.let { mkvInfo ->
                if (currentPos >= maxOf(0L, activeSize - PARALLEL_PROBE_MAX_BYTES) ||
                    (mkvInfo.cuesOffset > 0L &&
                        currentPos + sliceSize > mkvInfo.cuesOffset &&
                        currentPos <= mkvInfo.cuesOffset + 512_000L)
                ) {
                    matroskaSubtitleExtractor.onPotentialCuesSliceRead(
                        sourceBuffer = chunk,
                        sliceOffset = offsetInsideBlock,
                        sliceLength = sliceSize,
                        rangeGlobalStart = currentPos,
                        info = mkvInfo
                    )
                }
                matroskaSubtitleExtractor.harvestFromRawSlice(
                    sourceBuffer = chunk,
                    sliceOffset = offsetInsideBlock,
                    sliceLength = sliceSize,
                    rangeGlobalStart = currentPos,
                    info = mkvInfo
                )
            }

            val patchedCopy = applyCastMatroskaPatches(
                sourceBuffer = chunk,
                sliceOffset = offsetInsideBlock,
                sliceLength = sliceSize,
                rangeGlobalStart = currentPos,
                regionPatch = requestRegionPatch,
                clusterSwapper = requestClusterSwapper
            )

            try {
                if (patchedCopy != null) {
                    out.write(patchedCopy, 0, patchedCopy.size)
                } else {
                    out.write(chunk, offsetInsideBlock, sliceSize)
                }
                out.flush()
                if (isRemoteCastRoute && !isParallelBoundedProbe) {
                    recordRemoteMediaBytesSent(sliceSize)
                }
            } catch (e: Exception) {
                // Client disconnection or seek is normal during video streaming
                Log.d(TAG, "Client socket closed during stream: ${e.message}")
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId client disconnected at pos=$currentPos: ${e.message}")
                break
            }

            if (isFirstChunk) {
                val elapsed = System.currentTimeMillis() - reqStartTime
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Req #$myRequestId first chunk delivered ($sliceSize bytes) in ${elapsed}ms")
            }

            currentPos += sliceSize
            isFirstChunk = false

            // Diagnostics only: actual enforcement lives in the engine's shared window.
            bytesStreamedSinceGc += sliceSize
            if (bytesStreamedSinceGc >= STORAGE_SAMPLE_BYTES) {
                bytesStreamedSinceGc = 0L
                engine.logStreamStorage("delivered fileId=$partFileId offset=$currentPos")
            }
        }

        if (!isParallelBoundedProbe && currentStreamingSocket == socket) {
            currentStreamingSocket = null
        }
    }

    private fun applyCastMatroskaPatches(
        sourceBuffer: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        rangeGlobalStart: Long,
        regionPatch: MatroskaEbmlTrackPatcher.EbmlRegionPatch?,
        clusterSwapper: MatroskaEbmlTrackPatcher.ClusterBlockSwapper?
    ): ByteArray? {
        val headerPatched = if (regionPatch != null) {
            MatroskaEbmlTrackPatcher.applyRegionPatchToRange(
                sourceBuffer = sourceBuffer,
                sliceOffset = sliceOffset,
                sliceLength = sliceLength,
                rangeGlobalStart = rangeGlobalStart,
                patch = regionPatch
            )
        } else {
            null
        }
        if (clusterSwapper == null) return headerPatched

        return if (headerPatched != null) {
            clusterSwapper.patchSliceIfNeeded(
                sourceBuffer = headerPatched,
                sliceOffset = 0,
                sliceLength = headerPatched.size,
                rangeGlobalStart = rangeGlobalStart
            ) ?: headerPatched
        } else {
            clusterSwapper.patchSliceIfNeeded(
                sourceBuffer = sourceBuffer,
                sliceOffset = sliceOffset,
                sliceLength = sliceLength,
                rangeGlobalStart = rangeGlobalStart
            )
        }
    }

    private fun parseRange(rangeHeader: String, totalSize: Long): Pair<Long, Long>? {
        if (!rangeHeader.startsWith("bytes=", ignoreCase = true)) return null
        val clean = rangeHeader.substringAfter("=").trim().substringBefore(",")
        val dashIdx = clean.indexOf('-')
        if (dashIdx < 0) return null

        val startStr = clean.substring(0, dashIdx).trim()
        val endStr = clean.substring(dashIdx + 1).trim()

        if (startStr.isEmpty()) {
            // Suffix range: bytes=-500000 (last 500000 bytes)
            val suffix = endStr.toLongOrNull() ?: return null
            val start = maxOf(0L, totalSize - suffix)
            return Pair(start, totalSize - 1)
        }

        val start = startStr.toLongOrNull() ?: return null
        val end = if (endStr.isNotBlank()) {
            endStr.toLongOrNull() ?: (totalSize - 1)
        } else {
            totalSize - 1
        }

        return Pair(start, min(end, totalSize - 1))
    }

    private fun sendSimple(socket: Socket, code: Int, reason: String) {
        try {
            val body = "$code $reason\r\n"
            val bodyBytes = body.toByteArray(StandardCharsets.UTF_8)
            val header = "HTTP/1.1 $code $reason\r\n" +
                         "Content-Type: text/plain; charset=utf-8\r\n" +
                         "Content-Length: ${bodyBytes.size}\r\n" +
                         buildCommonDlnaAndCorsHeaders() +
                         "Connection: close\r\n\r\n"
            val out = socket.getOutputStream()
            out.write(header.toByteArray(StandardCharsets.US_ASCII))
            out.write(bodyBytes)
            out.flush()
        } catch (_: Exception) {}
    }
}
