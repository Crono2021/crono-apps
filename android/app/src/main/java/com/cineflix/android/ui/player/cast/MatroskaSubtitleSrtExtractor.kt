package com.cineflix.android.ui.player.cast

import android.util.Log
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListMap
import java.util.concurrent.ConcurrentSkipListSet
import java.util.zip.Inflater

/**
 * Extracts embedded Matroska (`.mkv`) text subtitle tracks (`S_TEXT/UTF8`, `S_TEXT/ASS`, `S_TEXT/SSA`,
 * `S_TEXT/WEBVTT`, including `zlib`-compressed or header-stripped tracks) and formats them into
 * standard UTF-8 SubRip (`.srt`) files for Samsung Tizen / Orsay and UPnP DLNA Smart TVs.
 *
 * Why this is essential for Samsung Smart TVs over UPnP `SetAVTransportURI`:
 *  - Samsung's DLNA MediaRenderer (`MMPlayer` / `SavsMatroskaParser`) ignores internal `.mkv` subtitle
 *    tracks during HTTP Direct Stream and only renders subtitles when delivered as an external `.srt`
 *    via `<sec:CaptionInfoEx sec:type="srt">`, `<sec:CaptionInfo sec:type="srt">`,
 *    `<res protocolInfo="http-get:*:text/srt:*">`, and the `CaptionInfo.sec` HTTP header.
 *
 * Three non-destructive extraction paths work together:
 *  1. **Targeted `<Cues>` (`0x1C53BB6B`) Direct Block Reader**:
 *     `mkvmerge` indexes every subtitle block in `<Cues>` (`CueTrack`, `CueClusterPosition`,
 *     `CueRelativePosition`, `CueDuration`). Grouping those positions by 128 KB TDLib block reads all
 *     Forced ("Forzados") subtitles across the entire movie and a wide window of Full ("Completos")
 *     subtitles from `startPositionMs` forward in `< 2.5s` before `SetAVTransportURI` is sent.
 *  2. **Sequential `<Cluster>` (`0x1F43B675`) Window Scanner**:
 *     When a file's `<Cues>` only indexes Video keyframes (or has no `<Cues>`), locates the `<Cluster>`
 *     at `startPositionMs` and scans sequential `<Cluster>`s, simultaneously extracting all subtitle tracks
 *     and pre-warming `BoundedVideoCache` for instant TV video startup.
 *  3. **Zero-Cost Passive Live Stream Sniffer (`harvestFromRawSlice`)**:
 *     Inspects every `.mkv` chunk read by `LocalStreamServer` in RAM (`< 0.5ms`, 0 extra I/O) and
 *     harvests all `<BlockGroup>` / `<SimpleBlock>` subtitle frames across chunk boundaries.
 */
class MatroskaSubtitleSrtExtractor(
    private val totalLogicalSizeProvider: () -> Long,
    private val directByteReader: (logicalOffset: Long, dst: ByteArray, dstOffset: Int, length: Int) -> Int
) {

    data class SrtCue(
        val startMs: Long,
        val endMs: Long,
        val text: String
    )

    data class MatroskaCueTrackPos(
        val trackNumber: Int,
        val clusterOffset: Long,
        val relativeOffset: Long = -1L,
        val durationMs: Long = 0L
    )

    data class MatroskaCuePoint(
        val timeMs: Long,
        val positions: List<MatroskaCueTrackPos>
    )

    private data class VintRead(
        val value: Long,
        val byteLength: Int
    )

    companion object {
        private const val TAG = "MkvSubSrtExtractor"

        private const val ID_CUES = 0x1C53BB6BL
        private const val ID_CUE_POINT = 0xBBL
        private const val ID_CUE_TIME = 0xB3L
        private const val ID_CUE_TRACK_POSITIONS = 0xB7L
        private const val ID_CUE_TRACK = 0xF7L
        private const val ID_CUE_CLUSTER_POSITION = 0xF1L
        private const val ID_CUE_RELATIVE_POSITION = 0xF0L
        private const val ID_CUE_DURATION = 0xB2L

        private const val ID_CLUSTER = 0x1F43B675L
        private const val ID_TIMECODE = 0xE7L
        private const val ID_SIMPLE_BLOCK = 0xA3L
        private const val ID_BLOCK_GROUP = 0xA0L
        private const val ID_BLOCK = 0xA1L
        private const val ID_BLOCK_DURATION = 0x9BL
        private const val ID_CRC32 = 0xBFL
        private const val ID_VOID = 0xECL
        private const val ID_CLUSTER_POSITION = 0xA7L
        private const val ID_CLUSTER_PREV_SIZE = 0xABL

        private const val UNKNOWN_SIZE = -1L
        private const val TDLIB_BLOCK_SIZE = 131_072L // 128 KB
        private const val MAX_TAIL_CUES_SCAN_BYTES = 2 * 1024 * 1024 // 2 MB

        private val ASS_DRAWING_BLOCK_REGEX = Regex(
            """\{\\p[1-9]\d*[^}]*\}.*?(\{\\p0[^}]*\}|$)""",
            setOf(RegexOption.DOT_MATCHES_ALL)
        )
        private val ASS_OVERRIDE_TAG_REGEX = Regex("""\{[^}]*\}""")
        private val HTML_TAG_REGEX = Regex("""</?(?:font|i|b|u|s|c)\b[^>]*>""", RegexOption.IGNORE_CASE)

        /**
         * Converts raw Matroska subtitle block payload (`S_TEXT/UTF8`, `S_TEXT/ASS`, `S_TEXT/SSA`, `S_TEXT/WEBVTT`)
         * into clean multi-line UTF-8 text suitable for `.srt`. Returns empty string if the cue has no visible text
         * (e.g. pure ASS vector drawing `{\p1}...` or empty spacer).
         */
        fun cleanMatroskaSubtitlePayload(rawBytes: ByteArray, codecId: String): String {
            if (rawBytes.isEmpty()) return ""
            var rawText = String(rawBytes, StandardCharsets.UTF_8)
                .trim('\u0000', '\uFEFF', ' ', '\t', '\r', '\n')
            if (rawText.isEmpty()) return ""

            val upperCodec = codecId.uppercase(Locale.ROOT)
            val isAssOrSsa = upperCodec.contains("ASS") || upperCodec.contains("SSA")

            if (isAssOrSsa || rawText.startsWith("Dialogue:", ignoreCase = true)) {
                rawText = extractAssDialogueText(rawText)
                if (rawText.isEmpty()) return ""
            }

            // Strip ASS vector drawing polygons ({\p1}m 0 0 l 100 0...{\p0})
            if (rawText.contains("\\p")) {
                rawText = ASS_DRAWING_BLOCK_REGEX.replace(rawText, "")
                if (rawText.isBlank()) return ""
            }

            // Convert ASS line breaks (\N, \n) and hard spaces (\h)
            rawText = rawText
                .replace("\\N", "\n")
                .replace("\\n", "\n")
                .replace("\\h", " ")

            // Strip ASS override tags {...} and HTML tags
            if (rawText.contains('{')) {
                rawText = ASS_OVERRIDE_TAG_REGEX.replace(rawText, "")
            }
            if (rawText.contains('<')) {
                rawText = HTML_TAG_REGEX.replace(rawText, "")
            }

            val cleanedLines = rawText
                .lines()
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return cleanedLines.joinToString("\r\n")
        }

        private fun extractAssDialogueText(line: String): String {
            val trimmed = line.trim()
            if (trimmed.startsWith("Dialogue:", ignoreCase = true)) {
                // Standalone ASS format: Dialogue: Layer,Start,End,Style,Name,MarginL,MarginR,MarginV,Effect,Text (9 commas)
                val afterPrefix = trimmed.substringAfter(':').trimStart()
                val parts = afterPrefix.split(',', limit = 10)
                if (parts.size == 10) return parts[9]
            }
            // Matroska S_TEXT/ASS block format: ReadOrder,Layer,Style,Name,MarginL,MarginR,MarginV,Effect,Text (8 commas)
            val firstComma = trimmed.indexOf(',')
            if (firstComma > 0 && trimmed.substring(0, firstComma).all { it.isDigit() || it == '-' }) {
                val parts = trimmed.split(',', limit = 9)
                if (parts.size == 9) return parts[8]
                if (parts.size >= 4) return parts.last()
            }
            return trimmed
        }

        fun decompressTrackPayloadIfNeeded(
            rawPayload: ByteArray,
            contentCompAlgo: Int,
            contentCompSettings: ByteArray
        ): ByteArray {
            if (rawPayload.isEmpty() || contentCompAlgo < 0) return rawPayload
            return when (contentCompAlgo) {
                0 -> {
                    // zlib decompression (try standard zlib wrapper first, then nowrap raw deflate)
                    inflateBytes(rawPayload, nowrap = false)
                        ?: inflateBytes(rawPayload, nowrap = true)
                        ?: rawPayload
                }
                3 -> {
                    // Header stripping: prepend contentCompSettings
                    if (contentCompSettings.isEmpty()) {
                        rawPayload
                    } else {
                        val out = ByteArray(contentCompSettings.size + rawPayload.size)
                        System.arraycopy(contentCompSettings, 0, out, 0, contentCompSettings.size)
                        System.arraycopy(rawPayload, 0, out, contentCompSettings.size, rawPayload.size)
                        out
                    }
                }
                else -> rawPayload
            }
        }

        private fun inflateBytes(compressed: ByteArray, nowrap: Boolean): ByteArray? {
            val inflater = Inflater(nowrap)
            return try {
                inflater.setInput(compressed)
                val out = ByteArrayOutputStream(maxOf(128, compressed.size * 3))
                val buf = ByteArray(1024)
                var loops = 0
                while (!inflater.finished() && loops < 256) {
                    loops++
                    val count = inflater.inflate(buf)
                    if (count > 0) {
                        out.write(buf, 0, count)
                    } else if (inflater.needsInput() || inflater.needsDictionary()) {
                        break
                    }
                }
                val res = out.toByteArray()
                if (res.isNotEmpty()) res else null
            } catch (_: Exception) {
                null
            } finally {
                try {
                    inflater.end()
                } catch (_: Exception) {}
            }
        }

        fun formatSrtTimestamp(ms: Long): String {
            val safe = ms.coerceAtLeast(0L)
            val hours = safe / 3_600_000L
            val minutes = (safe % 3_600_000L) / 60_000L
            val seconds = (safe % 60_000L) / 1_000L
            val millis = safe % 1_000L
            return String.format(Locale.US, "%02d:%02d:%02d,%03d", hours, minutes, seconds, millis)
        }

        fun formatVttTimestamp(ms: Long): String {
            val safe = ms.coerceAtLeast(0L)
            val hours = safe / 3_600_000L
            val minutes = (safe % 3_600_000L) / 60_000L
            val seconds = (safe % 60_000L) / 1_000L
            val millis = safe % 1_000L
            return String.format(Locale.US, "%02d:%02d:%02d.%03d", hours, minutes, seconds, millis)
        }

        /**
         * Formats a sorted collection of [SrtCue]s into a standard UTF-8 SubRip (`.srt`) string.
         * Always produces at least 1 valid `.srt` block so strict Samsung Tizen / Orsay DLNA `.srt`
         * parsers never fail on an empty file when a Forced track has no cues in the current window.
         */
        fun formatCuesToSrt(cues: Collection<SrtCue>, baseOffsetMs: Long = 0L): String {
            val filtered = cues
                .mapNotNull { cue ->
                    val adjStart = cue.startMs - baseOffsetMs
                    val adjEnd = cue.endMs - baseOffsetMs
                    if (adjEnd <= 0L || cue.text.isBlank()) {
                        null
                    } else {
                        val safeStart = adjStart.coerceAtLeast(0L)
                        val safeEnd = maxOf(safeStart + 600L, adjEnd)
                        SrtCue(safeStart, safeEnd, cue.text)
                    }
                }
                .sortedBy { it.startMs }

            if (filtered.isEmpty()) {
                return "1\r\n00:00:00,000 --> 00:00:00,001\r\n \r\n\r\n"
            }

            val sb = StringBuilder(filtered.size * 64)
            var seq = 1
            for (i in filtered.indices) {
                val cur = filtered[i]
                val nextStart = if (i + 1 < filtered.size) filtered[i + 1].startMs else Long.MAX_VALUE
                // Prevent overlapping end timestamps which some hardware TV .srt renderers reject
                val effectiveEnd = if (cur.endMs > nextStart && nextStart > cur.startMs + 200L) {
                    nextStart - 20L
                } else {
                    cur.endMs
                }
                if (effectiveEnd <= cur.startMs) continue
                sb.append(seq++)
                sb.append("\r\n")
                sb.append(formatSrtTimestamp(cur.startMs))
                sb.append(" --> ")
                sb.append(formatSrtTimestamp(effectiveEnd))
                sb.append("\r\n")
                sb.append(cur.text)
                sb.append("\r\n\r\n")
            }

            if (sb.isEmpty()) {
                return "1\r\n00:00:00,000 --> 00:00:00,001\r\n \r\n\r\n"
            }
            return sb.toString()
        }

        fun formatCuesToWebVtt(cues: Collection<SrtCue>, baseOffsetMs: Long = 0L): String {
            val filtered = cues
                .mapNotNull { cue ->
                    val adjStart = cue.startMs - baseOffsetMs
                    val adjEnd = cue.endMs - baseOffsetMs
                    if (adjEnd <= 0L || cue.text.isBlank()) {
                        null
                    } else {
                        val safeStart = adjStart.coerceAtLeast(0L)
                        val safeEnd = maxOf(safeStart + 600L, adjEnd)
                        SrtCue(safeStart, safeEnd, cue.text)
                    }
                }
                .sortedBy { it.startMs }

            val sb = StringBuilder(maxOf(128, filtered.size * 64))
            sb.append("WEBVTT\r\n\r\n")
            var seq = 1
            for (i in filtered.indices) {
                val cur = filtered[i]
                val nextStart = if (i + 1 < filtered.size) filtered[i + 1].startMs else Long.MAX_VALUE
                val effectiveEnd = if (cur.endMs > nextStart && nextStart > cur.startMs + 200L) {
                    nextStart - 20L
                } else {
                    cur.endMs
                }
                if (effectiveEnd <= cur.startMs) continue
                sb.append(seq++)
                sb.append("\r\n")
                sb.append(formatVttTimestamp(cur.startMs))
                sb.append(" --> ")
                sb.append(formatVttTimestamp(effectiveEnd))
                sb.append("\r\n")
                sb.append(cur.text)
                sb.append("\r\n\r\n")
            }
            return sb.toString()
        }

        /**
         * Formats a sorted collection of [SrtCue]s into a standard SAMI (`.smi` / `smi/caption`) document
         * for LG webOS and Samsung Smart TVs that prioritize `<res protocolInfo="http-get:*:smi/caption:*">`.
         */
        fun formatCuesToSami(cues: Collection<SrtCue>, baseOffsetMs: Long = 0L): String {
            val filtered = cues
                .mapNotNull { cue ->
                    val adjStart = cue.startMs - baseOffsetMs
                    val adjEnd = cue.endMs - baseOffsetMs
                    if (adjEnd <= 0L || cue.text.isBlank()) {
                        null
                    } else {
                        val safeStart = adjStart.coerceAtLeast(0L)
                        val safeEnd = maxOf(safeStart + 600L, adjEnd)
                        SrtCue(safeStart, safeEnd, cue.text)
                    }
                }
                .sortedBy { it.startMs }

            val sb = StringBuilder(maxOf(256, filtered.size * 96))
            sb.append("<SAMI>\r\n<HEAD>\r\n<TITLE>Cineflix</TITLE>\r\n<STYLE TYPE=\"text/css\">\r\n<!--\r\n")
            sb.append("P { margin-left:2pt; margin-right:2pt; margin-bottom:1pt; margin-top:1pt; text-align:center; font-size:20pt; color:#FFFFFF; }\r\n")
            sb.append(".SUBTTL { Name:'Subtitles'; Lang:es-ES; SAMIType:CC; }\r\n")
            sb.append("-->\r\n</STYLE>\r\n</HEAD>\r\n<BODY>\r\n")

            if (filtered.isEmpty()) {
                sb.append("<SYNC Start=0><P Class=SUBTTL>&nbsp;\r\n")
            } else {
                for (i in filtered.indices) {
                    val cur = filtered[i]
                    val nextStart = if (i + 1 < filtered.size) filtered[i + 1].startMs else Long.MAX_VALUE
                    val effectiveEnd = if (cur.endMs > nextStart && nextStart > cur.startMs + 200L) {
                        nextStart - 20L
                    } else {
                        cur.endMs
                    }
                    if (effectiveEnd <= cur.startMs) continue
                    val htmlText = cur.text
                        .replace("&", "&amp;")
                        .replace("<", "&lt;")
                        .replace(">", "&gt;")
                        .replace("\r\n", "<br>")
                        .replace("\n", "<br>")
                    sb.append("<SYNC Start=").append(cur.startMs).append("><P Class=SUBTTL>").append(htmlText).append("\r\n")
                    if (effectiveEnd < nextStart) {
                        sb.append("<SYNC Start=").append(effectiveEnd).append("><P Class=SUBTTL>&nbsp;\r\n")
                    }
                }
            }
            sb.append("</BODY>\r\n</SAMI>\r\n")
            return sb.toString()
        }
    }

    private val cuesByTrack = ConcurrentHashMap<Int, ConcurrentSkipListMap<Long, SrtCue>>()
    private val prewarmedTrackStartMs = ConcurrentHashMap<Int, Long>()
    private val knownClusterBoundaries = ConcurrentSkipListSet<Long>()
    private val clusterTimecodeByStartOffset = ConcurrentHashMap<Long, Long>()
    @Volatile private var parsedCues: List<MatroskaCuePoint>? = null
    @Volatile private var cuesParseAttempted: Boolean = false
    @Volatile private var lastPrewarmedTrackNumber: Int = -1
    @Volatile private var lastPrewarmedStartMs: Long = -1L
    @Volatile private var cachedSrtTrackNumber: Int = -1
    @Volatile private var cachedSrtBaseOffsetMs: Long = -1L
    @Volatile private var cachedSrtBytes: ByteArray? = null

    private val streamHarvestLock = Any()
    private var activeStreamClusterStart: Long = -1L
    private var activeStreamClusterTimecodeTicks: Long = 0L

    fun reset() {
        cuesByTrack.clear()
        prewarmedTrackStartMs.clear()
        knownClusterBoundaries.clear()
        clusterTimecodeByStartOffset.clear()
        parsedCues = null
        cuesParseAttempted = false
        lastPrewarmedTrackNumber = -1
        lastPrewarmedStartMs = -1L
        cachedSrtTrackNumber = -1
        cachedSrtBaseOffsetMs = -1L
        cachedSrtBytes = null
        synchronized(streamHarvestLock) {
            activeStreamClusterStart = -1L
            activeStreamClusterTimecodeTicks = 0L
        }
    }

    fun getHarvestedCueCount(trackNumber: Int): Int {
        return cuesByTrack[trackNumber]?.size ?: 0
    }

    private fun readFully(logicalOffset: Long, dst: ByteArray, length: Int): Int {
        var done = 0
        while (done < length) {
            val got = directByteReader(logicalOffset + done, dst, done, length - done)
            if (got <= 0) break
            done += got
        }
        return done
    }

    private fun recordCue(trackNumber: Int, startMs: Long, endMs: Long, text: String) {
        if (text.isBlank() || startMs < 0L) return
        val safeEnd = if (endMs > startMs) endMs else startMs + estimateDurationMs(text)
        val trackMap = cuesByTrack.getOrPut(trackNumber) { ConcurrentSkipListMap() }
        val existing = trackMap[startMs]
        if (existing == null) {
            trackMap[startMs] = SrtCue(startMs, safeEnd, text)
            if (cachedSrtTrackNumber == trackNumber) {
                cachedSrtBytes = null
            }
        } else if (!existing.text.contains(text)) {
            val mergedText = existing.text + "\r\n" + text
            val mergedEnd = maxOf(existing.endMs, safeEnd)
            trackMap[startMs] = SrtCue(startMs, mergedEnd, mergedText)
            if (cachedSrtTrackNumber == trackNumber) {
                cachedSrtBytes = null
            }
        } else if (safeEnd > existing.endMs) {
            trackMap[startMs] = SrtCue(startMs, safeEnd, existing.text)
            if (cachedSrtTrackNumber == trackNumber) {
                cachedSrtBytes = null
            }
        }
    }

    private fun estimateDurationMs(text: String): Long {
        return (2200L + text.length * 55L).coerceIn(2000L, 6000L)
    }

    /**
     * Zero-I/O passive `<Cues>` (`0x1C53BB6B`) sniffer called whenever `LocalStreamServer` reads
     * a tail slice (e.g. when ExoPlayer or the Smart TV probes the end of the `.mkv` file).
     */
    fun onPotentialCuesSliceRead(
        sourceBuffer: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        rangeGlobalStart: Long,
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo?
    ) {
        if (parsedCues != null || info == null || sliceLength <= 16) return
        try {
            val sliceCopy = if (sliceOffset == 0 && sliceLength == sourceBuffer.size) {
                sourceBuffer
            } else {
                sourceBuffer.copyOfRange(sliceOffset, sliceOffset + sliceLength)
            }
            val parsed = parseCuesFromSlice(
                buf = sliceCopy,
                limit = sliceCopy.size,
                segmentPayloadStart = info.segmentPayloadStart,
                timestampScaleNs = info.timestampScaleNs
            )
            if (parsed.isNotEmpty()) {
                parsedCues = parsed
                cuesParseAttempted = true
                Log.i(TAG, "⚡ Passively captured ${parsed.size} Matroska <CuePoint> entries from stream read at offset=$rangeGlobalStart ($sliceLength bytes)")
            }
        } catch (_: Exception) {}
    }

    /**
     * Zero-I/O passive harvester called whenever `LocalStreamServer` reads a raw `.mkv` slice
     * (from `cachedHeadPrefix`, `cachedTailSlice`, or `serveStream` chunks).
     */
    fun harvestFromRawSlice(
        sourceBuffer: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        rangeGlobalStart: Long,
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo?
    ) {
        if (info == null || info.subtitleTracks.isEmpty() || sliceLength <= 8) return
        val sliceGlobalEnd = rangeGlobalStart + sliceLength
        if (sliceGlobalEnd <= info.tracksElementEnd) return

        val subTracksByNum = HashMap<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>(info.subtitleTracks.size * 2)
        for (st in info.subtitleTracks) {
            if (!st.isImageSubtitle && st.trackNumber > 0) {
                subTracksByNum[st.trackNumber] = st
            }
        }
        if (subTracksByNum.isEmpty()) return

        if (info.firstClusterOffset > 0L) {
            knownClusterBoundaries.add(info.firstClusterOffset)
        }

        try {
            harvestClustersInBuffer(
                buf = sourceBuffer,
                sliceOffset = sliceOffset,
                sliceLength = sliceLength,
                rangeGlobalStart = rangeGlobalStart,
                info = info,
                subTracksByNum = subTracksByNum
            )
        } catch (_: Exception) {}
    }

    /**
     * Steps through `<Cluster>` and its child elements in `buf[sliceOffset until sliceOffset + sliceLength]`,
     * harvesting any subtitle `<SimpleBlock>` / `<BlockGroup>` and returning the next global offset
     * for sequential scanning.
     */
    private fun harvestClustersInBuffer(
        buf: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        rangeGlobalStart: Long,
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo,
        subTracksByNum: Map<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>
    ): Long {
        val sliceGlobalEnd = rangeGlobalStart + sliceLength
        val effectiveStartGlobal = maxOf(rangeGlobalStart, info.tracksElementEnd)
        val knownStart = knownClusterBoundaries.ceiling(effectiveStartGlobal)

        var localPos: Int = if (knownStart != null && knownStart < sliceGlobalEnd) {
            (knownStart - rangeGlobalStart).toInt()
        } else {
            val searchFrom = (effectiveStartGlobal - rangeGlobalStart).toInt().coerceAtLeast(0)
            findValidClusterOffset(buf, sliceOffset, sliceLength, searchFrom)
        }

        if (localPos < 0 || localPos >= sliceLength) return sliceGlobalEnd

        val scaleNs = info.timestampScaleNs.coerceAtLeast(1L)
        var currentClusterTimeTicks = synchronized(streamHarvestLock) { activeStreamClusterTimecodeTicks }

        while (localPos in 0 until sliceLength) {
            val bufPos = sliceOffset + localPos
            val bufLimit = sliceOffset + sliceLength
            val remaining = bufLimit - bufPos
            val elId = readElementId(buf, bufPos, bufLimit)
            val sizePos = if (elId != null) bufPos + elId.byteLength else -1
            val elSize = if (elId != null && sizePos < bufLimit) readDataSize(buf, sizePos, bufLimit) else null

            if (elId == null || elSize == null) {
                if (remaining <= 14 && localPos > 0) {
                    // Element header straddles the end of this chunk; re-read from this exact element start on next chunk
                    addBoundary(rangeGlobalStart + localPos)
                    return rangeGlobalStart + localPos
                }
                val resynced = findValidClusterOffset(buf, sliceOffset, sliceLength, localPos + 1)
                if (resynced < 0) break
                localPos = resynced
                continue
            }

            val headerLen = elId.byteLength + elSize.byteLength
            val payloadLocalPos = localPos + headerLen
            val payloadGlobalPos = rangeGlobalStart + payloadLocalPos

            if (elId.value == ID_CLUSTER) {
                val clusterGlobalStart = rangeGlobalStart + localPos
                addBoundary(clusterGlobalStart)
                addBoundary(payloadGlobalPos)
                // Do NOT add (payloadGlobalPos + elSize.value) to knownClusterBoundaries, because
                // knownClusterBoundaries.ceiling() must step into the children inside the <Cluster>,
                // not jump over the entire <Cluster> when a child block straddles a chunk boundary!
                clusterTimecodeByStartOffset[clusterGlobalStart]?.let {
                    currentClusterTimeTicks = it
                }
                synchronized(streamHarvestLock) {
                    activeStreamClusterStart = clusterGlobalStart
                }
                localPos = payloadLocalPos
                continue
            }

            if (elSize.value < 0L) {
                val resynced = findValidClusterOffset(buf, sliceOffset, sliceLength, localPos + 1)
                if (resynced < 0) break
                localPos = resynced
                continue
            }

            val nextGlobal = payloadGlobalPos + elSize.value
            if (nextGlobal <= rangeGlobalStart + localPos) {
                val resynced = findValidClusterOffset(buf, sliceOffset, sliceLength, localPos + 1)
                if (resynced < 0) break
                localPos = resynced
                continue
            }
            if (nextGlobal >= sliceGlobalEnd) {
                addBoundary(nextGlobal)
            }

            if (nextGlobal > sliceGlobalEnd) {
                // Element body extends past the end of `buf`:
                // If it's small enough to potentially be a subtitle block (<= 64 KB) and we haven't stuck at 0,
                // re-align the next sequential chunk to the start of this element so it is parsed in full!
                return if (elSize.value <= 65_536L && localPos > 0) {
                    rangeGlobalStart + localPos
                } else {
                    nextGlobal
                }
            }

            val payloadEndBufPos = sliceOffset + payloadLocalPos + elSize.value.toInt()
            if (payloadEndBufPos <= bufLimit && elSize.value <= Int.MAX_VALUE) {
                when (elId.value) {
                    ID_TIMECODE -> {
                        if (elId.byteLength == 1 && elSize.value in 0..8) {
                            currentClusterTimeTicks = readUnsignedInt(buf, sliceOffset + payloadLocalPos, elSize.value.toInt())
                            synchronized(streamHarvestLock) {
                                activeStreamClusterTimecodeTicks = currentClusterTimeTicks
                                if (activeStreamClusterStart > 0L) {
                                    clusterTimecodeByStartOffset[activeStreamClusterStart] = currentClusterTimeTicks
                                }
                            }
                        }
                    }
                    ID_SIMPLE_BLOCK -> {
                        if (elId.byteLength == 1 && elSize.value >= 4L) {
                            parseSimpleOrRawBlockIfSubtitle(
                                buf = buf,
                                blockPayloadStart = sliceOffset + payloadLocalPos,
                                blockPayloadEnd = payloadEndBufPos,
                                clusterTimeTicks = currentClusterTimeTicks,
                                explicitDurationTicks = -1L,
                                scaleNs = scaleNs,
                                subTracksByNum = subTracksByNum
                            )
                        }
                    }
                    ID_BLOCK_GROUP -> {
                        if (elId.byteLength == 1 && elSize.value >= 6L) {
                            parseBlockGroupIfSubtitle(
                                buf = buf,
                                groupPayloadStart = sliceOffset + payloadLocalPos,
                                groupPayloadEnd = payloadEndBufPos,
                                clusterTimeTicks = currentClusterTimeTicks,
                                scaleNs = scaleNs,
                                subTracksByNum = subTracksByNum
                            )
                        }
                    }
                }
            }

            if (nextGlobal >= sliceGlobalEnd) return nextGlobal
            localPos = (nextGlobal - rangeGlobalStart).toInt()
        }
        return sliceGlobalEnd
    }

    private fun parseBlockGroupIfSubtitle(
        buf: ByteArray,
        groupPayloadStart: Int,
        groupPayloadEnd: Int,
        clusterTimeTicks: Long,
        scaleNs: Long,
        subTracksByNum: Map<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>,
        overrideCueTimeMs: Long = -1L,
        overrideCueDurationMs: Long = 0L
    ) {
        var blockPayloadStart = -1
        var blockPayloadEnd = -1
        var durationTicks = -1L

        var pos = groupPayloadStart
        while (pos < groupPayloadEnd) {
            val cId = readElementId(buf, pos, groupPayloadEnd) ?: break
            val cSizePos = pos + cId.byteLength
            val cSize = readDataSize(buf, cSizePos, groupPayloadEnd) ?: break
            if (cSize.value < 0L) break
            val cValStart = cSizePos + cSize.byteLength
            val cValEndLong = cValStart.toLong() + cSize.value
            if (cValEndLong > groupPayloadEnd || cValEndLong <= pos) break
            val cValEnd = cValEndLong.toInt()

            when (cId.value) {
                ID_BLOCK -> {
                    if (cId.byteLength == 1 && cSize.value >= 4L) {
                        // Fast check on TrackNumber VINT before recording
                        val trackVint = readDataSize(buf, cValStart, cValEnd)
                        if (trackVint == null || !subTracksByNum.containsKey(trackVint.value.toInt())) {
                            return
                        }
                        blockPayloadStart = cValStart
                        blockPayloadEnd = cValEnd
                    }
                }
                ID_BLOCK_DURATION -> {
                    if (cId.byteLength == 1 && cSize.value in 0..8) {
                        durationTicks = readUnsignedInt(buf, cValStart, cSize.value.toInt())
                    }
                }
            }
            pos = cValEnd
        }

        if (blockPayloadStart >= 0 && blockPayloadEnd > blockPayloadStart) {
            parseSimpleOrRawBlockIfSubtitle(
                buf = buf,
                blockPayloadStart = blockPayloadStart,
                blockPayloadEnd = blockPayloadEnd,
                clusterTimeTicks = clusterTimeTicks,
                explicitDurationTicks = durationTicks,
                scaleNs = scaleNs,
                subTracksByNum = subTracksByNum,
                overrideCueTimeMs = overrideCueTimeMs,
                overrideCueDurationMs = overrideCueDurationMs
            )
        }
    }

    private fun parseSimpleOrRawBlockIfSubtitle(
        buf: ByteArray,
        blockPayloadStart: Int,
        blockPayloadEnd: Int,
        clusterTimeTicks: Long,
        explicitDurationTicks: Long,
        scaleNs: Long,
        subTracksByNum: Map<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>,
        overrideCueTimeMs: Long = -1L,
        overrideCueDurationMs: Long = 0L
    ) {
        val trackVint = readDataSize(buf, blockPayloadStart, blockPayloadEnd) ?: return
        val trackNum = trackVint.value.toInt()
        val trackInfo = subTracksByNum[trackNum] ?: return

        val headerEnd = blockPayloadStart + trackVint.byteLength + 3
        if (headerEnd > blockPayloadEnd) return

        val timeHi = buf[blockPayloadStart + trackVint.byteLength].toInt()
        val timeLo = buf[blockPayloadStart + trackVint.byteLength + 1].toInt() and 0xFF
        val relTimecodeTicks = ((timeHi shl 8) or timeLo).toShort().toLong()
        val flags = buf[blockPayloadStart + trackVint.byteLength + 2].toInt() and 0xFF
        val lacing = (flags and 0x06) shr 1
        if (lacing != 0) return

        val rawFrame = buf.copyOfRange(headerEnd, blockPayloadEnd)
        val decompressed = decompressTrackPayloadIfNeeded(
            rawPayload = rawFrame,
            contentCompAlgo = trackInfo.contentCompAlgo,
            contentCompSettings = trackInfo.contentCompSettings
        )
        val cleanText = cleanMatroskaSubtitlePayload(decompressed, trackInfo.codecId)
        if (cleanText.isEmpty()) return

        val startMs = if (overrideCueTimeMs >= 0L) {
            overrideCueTimeMs
        } else {
            val totalTicks = (clusterTimeTicks + relTimecodeTicks).coerceAtLeast(0L)
            (totalTicks * scaleNs) / 1_000_000L
        }

        val durationMs = when {
            explicitDurationTicks > 0L -> (explicitDurationTicks * scaleNs) / 1_000_000L
            overrideCueDurationMs > 0L -> overrideCueDurationMs
            else -> estimateDurationMs(cleanText)
        }
        recordCue(trackNum, startMs, startMs + durationMs.coerceAtLeast(500L), cleanText)
    }

    private fun isTrackPrewarmedForWindow(targetTrackNumber: Int, startPositionMs: Long): Boolean {
        val prevStart = prewarmedTrackStartMs[targetTrackNumber] ?: return false
        return kotlin.math.abs(startPositionMs - prevStart) < 30_000L &&
            getHarvestedCueCount(targetTrackNumber) > 0
    }

    /**
     * Pre-warms and builds the UTF-8 `.srt` bytes for [targetTrackNumber] starting around [startPositionMs].
     * Called inside `LocalStreamServer.buildLanDlnaStreamPlan` BEFORE `SetAVTransportURI` is sent to the TV
     * so `/stream/cineflix_eX_tY.srt` is served in 0ms from RAM with zero TDLib contention during video startup.
     */
    fun prewarmAndBuildSrtBytes(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo,
        targetTrackNumber: Int,
        startPositionMs: Long,
        baseOffsetMs: Long = 0L,
        maxBudgetMs: Long = 3500L
    ): ByteArray {
        val existingBytes = cachedSrtBytes
        if (existingBytes != null &&
            cachedSrtTrackNumber == targetTrackNumber &&
            cachedSrtBaseOffsetMs == baseOffsetMs &&
            isTrackPrewarmedForWindow(targetTrackNumber, startPositionMs)
        ) {
            return existingBytes
        }

        extractSrtCuesForTrack(
            info = info,
            targetTrackNumber = targetTrackNumber,
            startPositionMs = startPositionMs,
            maxBudgetMs = maxBudgetMs
        )

        val srtString = formatCuesToSrt(
            cues = cuesByTrack[targetTrackNumber]?.values ?: emptyList(),
            baseOffsetMs = baseOffsetMs
        )
        val bytes = srtString.toByteArray(StandardCharsets.UTF_8)
        if (getHarvestedCueCount(targetTrackNumber) > 0) {
            cachedSrtTrackNumber = targetTrackNumber
            cachedSrtBaseOffsetMs = baseOffsetMs
            cachedSrtBytes = bytes
            lastPrewarmedTrackNumber = targetTrackNumber
            lastPrewarmedStartMs = startPositionMs
            prewarmedTrackStartMs[targetTrackNumber] = startPositionMs
        }
        return bytes
    }

    fun getOrBuildSrtBytes(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo?,
        targetTrackNumber: Int,
        startPositionMs: Long = 0L,
        baseOffsetMs: Long = 0L
    ): ByteArray {
        val fast = cachedSrtBytes
        if (fast != null &&
            cachedSrtTrackNumber == targetTrackNumber &&
            cachedSrtBaseOffsetMs == baseOffsetMs &&
            isTrackPrewarmedForWindow(targetTrackNumber, startPositionMs)
        ) {
            return fast
        }
        if (info != null && targetTrackNumber > 0) {
            return prewarmAndBuildSrtBytes(
                info = info,
                targetTrackNumber = targetTrackNumber,
                startPositionMs = startPositionMs,
                baseOffsetMs = baseOffsetMs,
                maxBudgetMs = 3500L
            )
        }
        val fallback = formatCuesToSrt(
            cues = cuesByTrack[targetTrackNumber]?.values ?: emptyList(),
            baseOffsetMs = baseOffsetMs
        ).toByteArray(StandardCharsets.UTF_8)
        return fallback
    }

    fun getOrBuildVttBytes(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo?,
        targetTrackNumber: Int,
        startPositionMs: Long = 0L,
        baseOffsetMs: Long = 0L
    ): ByteArray {
        if (info != null && targetTrackNumber > 0 && !isTrackPrewarmedForWindow(targetTrackNumber, startPositionMs)) {
            prewarmAndBuildSrtBytes(
                info = info,
                targetTrackNumber = targetTrackNumber,
                startPositionMs = startPositionMs,
                baseOffsetMs = baseOffsetMs,
                maxBudgetMs = 3500L
            )
        }
        val vttString = formatCuesToWebVtt(
            cues = cuesByTrack[targetTrackNumber]?.values ?: emptyList(),
            baseOffsetMs = baseOffsetMs
        )
        return vttString.toByteArray(StandardCharsets.UTF_8)
    }

    fun getOrBuildSmiBytes(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo?,
        targetTrackNumber: Int,
        startPositionMs: Long = 0L,
        baseOffsetMs: Long = 0L
    ): ByteArray {
        if (info != null && targetTrackNumber > 0 && !isTrackPrewarmedForWindow(targetTrackNumber, startPositionMs)) {
            prewarmAndBuildSrtBytes(
                info = info,
                targetTrackNumber = targetTrackNumber,
                startPositionMs = startPositionMs,
                baseOffsetMs = baseOffsetMs,
                maxBudgetMs = 3500L
            )
        }
        val smiString = formatCuesToSami(
            cues = cuesByTrack[targetTrackNumber]?.values ?: emptyList(),
            baseOffsetMs = baseOffsetMs
        )
        return smiString.toByteArray(StandardCharsets.UTF_8)
    }

    private fun extractSrtCuesForTrack(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo,
        targetTrackNumber: Int,
        startPositionMs: Long,
        maxBudgetMs: Long
    ) {
        val targetSub = info.subtitleTracks.firstOrNull { it.trackNumber == targetTrackNumber } ?: return
        if (targetSub.isImageSubtitle) return

        val subTracksByNum = HashMap<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>(info.subtitleTracks.size * 2)
        for (st in info.subtitleTracks) {
            if (!st.isImageSubtitle && st.trackNumber > 0) {
                subTracksByNum[st.trackNumber] = st
            }
        }

        // Parse <Cues> BEFORE starting the block-extraction deadline so downloading <Cues> from EOF
        // never consumes the time budget needed to read subtitle blocks!
        val cues = ensureCuesParsed(info)
        val deadlineMs = System.currentTimeMillis() + maxBudgetMs

        // 1. Targeted extraction via <Cues> (0x1C53BB6B) if <Cues> indexed the subtitle track
        val subCueEntries = ArrayList<Pair<MatroskaCuePoint, MatroskaCueTrackPos>>()
        for (cp in cues) {
            for (pos in cp.positions) {
                if (pos.trackNumber == targetTrackNumber && pos.clusterOffset > 0L) {
                    subCueEntries.add(Pair(cp, pos))
                }
            }
        }

        if (subCueEntries.isNotEmpty()) {
            val minTargetTimeMs = (startPositionMs - 30_000L).coerceAtLeast(0L)
            val forwardEntries = subCueEntries.filter { it.first.timeMs >= minTargetTimeMs }
            val earlierEntries = subCueEntries.filter { it.first.timeMs < minTargetTimeMs }
            val orderedEntries = forwardEntries + earlierEntries

            // Group cues by 128 KB TDLib block so multiple cues in the same block take 1 read
            val blockMap = LinkedHashMap<Long, MutableList<Pair<MatroskaCuePoint, MatroskaCueTrackPos>>>()
            for (entry in orderedEntries) {
                val pos = entry.second
                val approxFileOffset = if (pos.relativeOffset >= 0L) {
                    pos.clusterOffset + 4L + pos.relativeOffset
                } else {
                    pos.clusterOffset
                }
                val alignedBlock = approxFileOffset - (approxFileOffset % TDLIB_BLOCK_SIZE)
                blockMap.getOrPut(alignedBlock) { ArrayList() }.add(entry)
            }

            val totalSize = maxOf(totalLogicalSizeProvider(), info.segmentEndOffset)
            var blocksRead = 0
            val minGuaranteedBlocks = 24
            val maxBlocksToRead = 140
            val scaleNs = info.timestampScaleNs.coerceAtLeast(1L)

            for ((alignedOffset, entriesInBlock) in blockMap) {
                if (blocksRead >= maxBlocksToRead ||
                    (blocksRead >= minGuaranteedBlocks && System.currentTimeMillis() >= deadlineMs)
                ) {
                    break
                }
                // Check if all cues in this block were already harvested
                val trackMap = cuesByTrack[targetTrackNumber]
                if (trackMap != null && entriesInBlock.all { trackMap.containsKey(it.first.timeMs) }) {
                    continue
                }

                // Read 128 KB (or 256 KB if a block straddles the 128 KB seam)
                val maxEntryEndApprox = entriesInBlock.maxOf { (_, p) ->
                    if (p.relativeOffset >= 0L) p.clusterOffset + 4L + p.relativeOffset + 8192L
                    else p.clusterOffset + TDLIB_BLOCK_SIZE
                }
                val readLen = if (maxEntryEndApprox > alignedOffset + TDLIB_BLOCK_SIZE &&
                    alignedOffset + 2 * TDLIB_BLOCK_SIZE <= totalSize
                ) {
                    (2 * TDLIB_BLOCK_SIZE).toInt()
                } else {
                    minOf(TDLIB_BLOCK_SIZE, totalSize - alignedOffset).toInt()
                }
                if (readLen <= 16) continue

                val buf = ByteArray(readLen)
                val got = readFully(alignedOffset, buf, readLen)
                if (got <= 16) continue
                blocksRead++

                // First harvest any full <Cluster> headers present in this chunk
                harvestClustersInBuffer(
                    buf = buf,
                    sliceOffset = 0,
                    sliceLength = got,
                    rangeGlobalStart = alignedOffset,
                    info = info,
                    subTracksByNum = subTracksByNum
                )

                // Then resolve each targeted <CueTrackPositions> directly using CueClusterPosition + CueRelativePosition
                for ((cuePoint, cuePos) in entriesInBlock) {
                    if (cuePos.relativeOffset >= 0L) {
                        extractTargetedCueAtRelativePosition(
                            buf = buf,
                            bufLen = got,
                            bufGlobalStart = alignedOffset,
                            cuePoint = cuePoint,
                            cuePos = cuePos,
                            scaleNs = scaleNs,
                            subTracksByNum = subTracksByNum
                        )
                    }
                }
            }

            val harvestedViaCues = getHarvestedCueCount(targetTrackNumber)
            Log.i(
                TAG,
                "✅ Extracted $harvestedViaCues SRT cues for track #$targetTrackNumber " +
                    "via <Cues> (${subCueEntries.size} indexed cues, $blocksRead TDLib blocks read)"
            )
            if (harvestedViaCues > 0) {
                return
            }
        }

        // 2. Sequential <Cluster> scan when <Cues> only indexed Video keyframes (or had no subtitle entries)
        val totalSize = maxOf(totalLogicalSizeProvider(), info.segmentEndOffset)
        if (totalSize <= 0L) return

        val startClusterOffset = resolveStartClusterOffsetForTime(info, cues, startPositionMs)
        if (startClusterOffset <= 0L || startClusterOffset >= totalSize) return

        val chunkSize = 512 * 1024 // 512 KB sequential reads
        val minGuaranteedBytes = 2L * 1024L * 1024L
        val maxSequentialBytes = 16L * 1024L * 1024L // up to 16 MB window
        var curOffset = startClusterOffset
        var scannedBytes = 0L
        val buf = ByteArray(chunkSize)

        while (curOffset < totalSize &&
            scannedBytes < maxSequentialBytes &&
            (scannedBytes < minGuaranteedBytes || System.currentTimeMillis() < deadlineMs)
        ) {
            val toRead = minOf(chunkSize.toLong(), totalSize - curOffset).toInt()
            if (toRead <= 16) break
            val got = readFully(curOffset, buf, toRead)
            if (got <= 16) break

            val nextOffset = harvestClustersInBuffer(
                buf = buf,
                sliceOffset = 0,
                sliceLength = got,
                rangeGlobalStart = curOffset,
                info = info,
                subTracksByNum = subTracksByNum
            )
            scannedBytes += got
            curOffset = if (nextOffset > curOffset && nextOffset <= curOffset + got + 8L * 1024L * 1024L) {
                nextOffset
            } else {
                curOffset + got
            }
        }

        Log.i(
            TAG,
            "✅ Extracted ${getHarvestedCueCount(targetTrackNumber)} SRT cues for track #$targetTrackNumber " +
                "via sequential <Cluster> scan (${scannedBytes / 1024} KB from offset=$startClusterOffset)"
        )
    }

    private fun extractTargetedCueAtRelativePosition(
        buf: ByteArray,
        bufLen: Int,
        bufGlobalStart: Long,
        cuePoint: MatroskaCuePoint,
        cuePos: MatroskaCueTrackPos,
        scaleNs: Long,
        subTracksByNum: Map<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>
    ) {
        val targetTrack = cuePos.trackNumber
        // If the <Cluster> header itself is inside [bufGlobalStart, bufGlobalStart + bufLen),
        // we know the exact <Cluster> Data Size VINT length!
        val exactVintWidth: Int? = if (cuePos.clusterOffset >= bufGlobalStart &&
            cuePos.clusterOffset + 12 <= bufGlobalStart + bufLen
        ) {
            val localClusterOff = (cuePos.clusterOffset - bufGlobalStart).toInt()
            if (buf[localClusterOff] == 0x1F.toByte() &&
                buf[localClusterOff + 1] == 0x43.toByte() &&
                buf[localClusterOff + 2] == 0xB6.toByte() &&
                buf[localClusterOff + 3] == 0x75.toByte()
            ) {
                readDataSize(buf, localClusterOff + 4, bufLen)?.byteLength
            } else {
                null
            }
        } else {
            null
        }

        val candidateWidths = if (exactVintWidth != null) {
            intArrayOf(exactVintWidth)
        } else {
            // Try common mkvmerge / FFmpeg <Cluster> VINT widths (4, 8, 3, 2, 1, 5, 6, 7)
            intArrayOf(4, 8, 3, 2, 1, 5, 6, 7)
        }

        for (vintW in candidateWidths) {
            val blockGlobalOffset = cuePos.clusterOffset + 4L + vintW + cuePos.relativeOffset
            if (blockGlobalOffset < bufGlobalStart || blockGlobalOffset + 6 >= bufGlobalStart + bufLen) {
                continue
            }
            val localPos = (blockGlobalOffset - bufGlobalStart).toInt()
            val elId = readElementId(buf, localPos, bufLen) ?: continue
            if (elId.byteLength != 1 || (elId.value != ID_BLOCK_GROUP && elId.value != ID_SIMPLE_BLOCK)) {
                continue
            }
            val elSize = readDataSize(buf, localPos + 1, bufLen) ?: continue
            if (elSize.value < 4L || elSize.value > 256_000L) continue
            val payloadStart = localPos + 1 + elSize.byteLength
            val payloadEndLong = payloadStart.toLong() + elSize.value
            if (payloadEndLong > bufLen || payloadEndLong <= payloadStart) continue
            val payloadEnd = payloadEndLong.toInt()

            if (elId.value == ID_SIMPLE_BLOCK) {
                val tv = readDataSize(buf, payloadStart, payloadEnd) ?: continue
                if (tv.value.toInt() != targetTrack) continue
                parseSimpleOrRawBlockIfSubtitle(
                    buf = buf,
                    blockPayloadStart = payloadStart,
                    blockPayloadEnd = payloadEnd,
                    clusterTimeTicks = 0L,
                    explicitDurationTicks = -1L,
                    scaleNs = scaleNs,
                    subTracksByNum = subTracksByNum,
                    overrideCueTimeMs = cuePoint.timeMs,
                    overrideCueDurationMs = cuePos.durationMs
                )
                harvestConsecutiveSubtitleBlocks(buf, payloadEnd, bufLen, cuePoint.timeMs, cuePos.durationMs, scaleNs, subTracksByNum)
                return
            } else if (elId.value == ID_BLOCK_GROUP) {
                // Verify inner <Block> (0xA1) belongs to targetTrack before committing
                if (blockGroupMatchesTrack(buf, payloadStart, payloadEnd, targetTrack)) {
                    parseBlockGroupIfSubtitle(
                        buf = buf,
                        groupPayloadStart = payloadStart,
                        groupPayloadEnd = payloadEnd,
                        clusterTimeTicks = 0L,
                        scaleNs = scaleNs,
                        subTracksByNum = subTracksByNum,
                        overrideCueTimeMs = cuePoint.timeMs,
                        overrideCueDurationMs = cuePos.durationMs
                    )
                    harvestConsecutiveSubtitleBlocks(buf, payloadEnd, bufLen, cuePoint.timeMs, cuePos.durationMs, scaleNs, subTracksByNum)
                    return
                }
            }
        }
    }

    /**
     * Harvests up to 4 immediately adjacent subtitle blocks following a `<Cues>`-indexed subtitle block
     * (e.g. when a sign translation and spoken dialogue occur at the exact same timestamp).
     */
    private fun harvestConsecutiveSubtitleBlocks(
        buf: ByteArray,
        startPos: Int,
        bufLen: Int,
        cueTimeMs: Long,
        cueDurationMs: Long,
        scaleNs: Long,
        subTracksByNum: Map<Int, MatroskaEbmlTrackPatcher.MatroskaTrackInfo>
    ) {
        var cur = startPos
        var count = 0
        while (cur + 6 < bufLen && count < 4) {
            val elId = readElementId(buf, cur, bufLen) ?: break
            if (elId.byteLength != 1 || (elId.value != ID_BLOCK_GROUP && elId.value != ID_SIMPLE_BLOCK)) break
            val elSize = readDataSize(buf, cur + 1, bufLen) ?: break
            if (elSize.value < 4L || elSize.value > 65_536L) break
            val pStart = cur + 1 + elSize.byteLength
            val pEndLong = pStart.toLong() + elSize.value
            if (pEndLong > bufLen || pEndLong <= pStart) break
            val pEnd = pEndLong.toInt()
            if (elId.value == ID_SIMPLE_BLOCK) {
                val tv = readDataSize(buf, pStart, pEnd) ?: break
                if (!subTracksByNum.containsKey(tv.value.toInt())) break
                parseSimpleOrRawBlockIfSubtitle(buf, pStart, pEnd, 0L, -1L, scaleNs, subTracksByNum, cueTimeMs, cueDurationMs)
            } else {
                parseBlockGroupIfSubtitle(buf, pStart, pEnd, 0L, scaleNs, subTracksByNum, cueTimeMs, cueDurationMs)
            }
            cur = pEnd
            count++
        }
    }

    private fun blockGroupMatchesTrack(
        buf: ByteArray,
        groupPayloadStart: Int,
        groupPayloadEnd: Int,
        targetTrack: Int
    ): Boolean {
        var pos = groupPayloadStart
        while (pos < groupPayloadEnd) {
            val cId = readElementId(buf, pos, groupPayloadEnd) ?: return false
            val cSizePos = pos + cId.byteLength
            val cSize = readDataSize(buf, cSizePos, groupPayloadEnd) ?: return false
            if (cSize.value < 0L) return false
            val cValStart = cSizePos + cSize.byteLength
            val cValEndLong = cValStart.toLong() + cSize.value
            if (cValEndLong > groupPayloadEnd || cValEndLong <= pos) return false
            if (cId.value == ID_BLOCK && cId.byteLength == 1 && cSize.value >= 4L) {
                val tv = readDataSize(buf, cValStart, cValEndLong.toInt()) ?: return false
                return tv.value.toInt() == targetTrack
            }
            pos = cValEndLong.toInt()
        }
        return false
    }

    private fun resolveStartClusterOffsetForTime(
        info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo,
        cues: List<MatroskaCuePoint>,
        startPositionMs: Long
    ): Long {
        if (startPositionMs <= 5_000L || cues.isEmpty()) {
            return if (info.firstClusterOffset > 0L) info.firstClusterOffset else info.tracksElementEnd
        }
        val targetMs = (startPositionMs - 10_000L).coerceAtLeast(0L)
        var bestClusterOffset = if (info.firstClusterOffset > 0L) info.firstClusterOffset else info.tracksElementEnd
        for (cp in cues) {
            val firstCluster = cp.positions.firstOrNull { it.clusterOffset > 0L }?.clusterOffset ?: continue
            if (cp.timeMs <= targetMs) {
                bestClusterOffset = firstCluster
            } else {
                break
            }
        }
        return bestClusterOffset
    }

    private fun ensureCuesParsed(info: MatroskaEbmlTrackPatcher.MatroskaHeaderInfo): List<MatroskaCuePoint> {
        parsedCues?.let { if (it.isNotEmpty()) return it }

        val totalSize = maxOf(totalLogicalSizeProvider(), info.segmentEndOffset)
        if (totalSize <= 64L) return emptyList()
        if (cuesParseAttempted && parsedCues != null) return parsedCues!!
        cuesParseAttempted = true

        try {
            var resolvedCuesOffset = info.cuesOffset
            if (resolvedCuesOffset !in 1 until totalSize && info.chainedSeekHeadOffset in 1 until totalSize) {
                val seekLen = minOf(65_536L, totalSize - info.chainedSeekHeadOffset).toInt()
                if (seekLen > 12) {
                    val seekBuf = ByteArray(seekLen)
                    val gotSeek = readFully(info.chainedSeekHeadOffset, seekBuf, seekLen)
                    if (gotSeek > 12) {
                        val chainedCues = MatroskaEbmlTrackPatcher.parseSeekHeadSliceForCuesOffset(
                            buf = seekBuf,
                            limit = gotSeek,
                            segmentPayloadStart = info.segmentPayloadStart
                        )
                        if (chainedCues in 1 until totalSize) {
                            resolvedCuesOffset = chainedCues
                        }
                    }
                }
            }

            if (resolvedCuesOffset in 1 until totalSize) {
                val readLen = minOf(MAX_TAIL_CUES_SCAN_BYTES.toLong(), totalSize - resolvedCuesOffset).toInt()
                if (readLen > 12) {
                    val cuesBuf = ByteArray(readLen)
                    val got = readFully(resolvedCuesOffset, cuesBuf, readLen)
                    if (got > 12) {
                        val parsed = parseCuesFromSlice(
                            buf = cuesBuf,
                            limit = got,
                            segmentPayloadStart = info.segmentPayloadStart,
                            timestampScaleNs = info.timestampScaleNs
                        )
                        if (parsed.isNotEmpty()) {
                            parsedCues = parsed
                            Log.i(TAG, "📑 Parsed ${parsed.size} Matroska <CuePoint> entries from SeekHead offset=$resolvedCuesOffset ($got bytes)")
                            return parsed
                        }
                    }
                }
            }

            // Fallback: scan the tail of the file (up to 2 MB) for <Cues> (0x1C53BB6B)
            val tailLen = minOf(MAX_TAIL_CUES_SCAN_BYTES.toLong(), totalSize).toInt()
            val tailStart = (totalSize - tailLen).coerceAtLeast(0L)
            val tailBuf = ByteArray(tailLen)
            val gotTail = readFully(tailStart, tailBuf, tailLen)
            if (gotTail > 12) {
                val parsed = parseCuesFromSlice(
                    buf = tailBuf,
                    limit = gotTail,
                    segmentPayloadStart = info.segmentPayloadStart,
                    timestampScaleNs = info.timestampScaleNs
                )
                parsedCues = parsed
                Log.i(TAG, "📑 Parsed ${parsed.size} Matroska <CuePoint> entries from tail offset=$tailStart ($gotTail bytes)")
                return parsed
            }
        } catch (e: Exception) {
            Log.w(TAG, "Matroska <Cues> parse skipped: ${e.message}")
        }
        return emptyList()
    }

    fun parseCuesFromSlice(
        buf: ByteArray,
        limit: Int,
        segmentPayloadStart: Long,
        timestampScaleNs: Long
    ): List<MatroskaCuePoint> {
        val cuesStart = findCuesElementOffset(buf, limit)
        if (cuesStart < 0) return emptyList()

        val idRead = readElementId(buf, cuesStart, limit) ?: return emptyList()
        if (idRead.value != ID_CUES) return emptyList()
        val sizeRead = readDataSize(buf, cuesStart + idRead.byteLength, limit) ?: return emptyList()
        val payloadStart = cuesStart + idRead.byteLength + sizeRead.byteLength
        val payloadEnd = if (sizeRead.value == UNKNOWN_SIZE) {
            limit
        } else {
            minOf(limit.toLong(), payloadStart.toLong() + sizeRead.value).toInt()
        }

        val scaleNs = timestampScaleNs.coerceAtLeast(1L)
        val result = ArrayList<MatroskaCuePoint>(256)
        var pos = payloadStart
        while (pos < payloadEnd) {
            val cId = readElementId(buf, pos, payloadEnd) ?: break
            val cSizePos = pos + cId.byteLength
            val cSize = readDataSize(buf, cSizePos, payloadEnd) ?: break
            if (cSize.value < 0L) break
            val cValStart = cSizePos + cSize.byteLength
            val cValEndLong = cValStart.toLong() + cSize.value
            if (cValEndLong > payloadEnd || cValEndLong <= pos) break
            val cValEnd = cValEndLong.toInt()

            if (cId.value == ID_CUE_POINT && cId.byteLength == 1) {
                parseSingleCuePoint(buf, cValStart, cValEnd, segmentPayloadStart, scaleNs)?.let {
                    result.add(it)
                }
            }
            pos = cValEnd
        }
        return result
    }

    private fun parseSingleCuePoint(
        buf: ByteArray,
        start: Int,
        end: Int,
        segmentPayloadStart: Long,
        scaleNs: Long
    ): MatroskaCuePoint? {
        var cueTimeTicks = -1L
        val trackPositions = ArrayList<MatroskaCueTrackPos>(2)

        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0L) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            val valEnd = valEndLong.toInt()
            val valLen = elSize.value.toInt()

            when (elId.value) {
                ID_CUE_TIME -> {
                    if (valLen in 0..8) {
                        cueTimeTicks = readUnsignedInt(buf, valStart, valLen)
                    }
                }
                ID_CUE_TRACK_POSITIONS -> {
                    parseCueTrackPositions(buf, valStart, valEnd, segmentPayloadStart, scaleNs)?.let {
                        trackPositions.add(it)
                    }
                }
            }
            pos = valEnd
        }

        if (cueTimeTicks < 0L || trackPositions.isEmpty()) return null
        val timeMs = (cueTimeTicks * scaleNs) / 1_000_000L
        return MatroskaCuePoint(timeMs = timeMs, positions = trackPositions)
    }

    private fun parseCueTrackPositions(
        buf: ByteArray,
        start: Int,
        end: Int,
        segmentPayloadStart: Long,
        scaleNs: Long
    ): MatroskaCueTrackPos? {
        var trackNum = 0
        var clusterPos = -1L
        var relativePos = -1L
        var durationTicks = 0L

        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0L) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            val valEnd = valEndLong.toInt()
            val valLen = elSize.value.toInt()

            if (valLen in 0..8) {
                when (elId.value) {
                    ID_CUE_TRACK -> trackNum = readUnsignedInt(buf, valStart, valLen).toInt()
                    ID_CUE_CLUSTER_POSITION -> clusterPos = readUnsignedInt(buf, valStart, valLen)
                    ID_CUE_RELATIVE_POSITION -> relativePos = readUnsignedInt(buf, valStart, valLen)
                    ID_CUE_DURATION -> durationTicks = readUnsignedInt(buf, valStart, valLen)
                }
            }
            pos = valEnd
        }

        if (trackNum <= 0 || clusterPos < 0L) return null
        val durationMs = if (durationTicks > 0L) (durationTicks * scaleNs) / 1_000_000L else 0L
        return MatroskaCueTrackPos(
            trackNumber = trackNum,
            clusterOffset = segmentPayloadStart + clusterPos,
            relativeOffset = relativePos,
            durationMs = durationMs
        )
    }

    /**
     * Locates `<Cues>` (`0x1C 0x53 0xBB 0x6B`) inside [buf].
     * Note: `mkvmerge` (MKVToolNix) ALWAYS writes a 6-byte `<CRC-32>` (`0xBF 0x84 <4 bytes>`)
     * as the first child of `<Cues>` before the first `<CuePoint>` (`0xBB`), so we accept
     * `0xBB` (`<CuePoint>`), `0xBF` (`<CRC-32>`), or `0xEC` (`<Void>`) as the first child!
     */
    private fun findCuesElementOffset(buf: ByteArray, limit: Int): Int {
        var i = 0
        while (i + 7 < limit) {
            if (buf[i] == 0x1C.toByte() &&
                buf[i + 1] == 0x53.toByte() &&
                buf[i + 2] == 0xBB.toByte() &&
                buf[i + 3] == 0x6B.toByte()
            ) {
                val cuesSize = readDataSize(buf, i + 4, limit)
                if (cuesSize != null && (cuesSize.value == UNKNOWN_SIZE || cuesSize.value >= 5L)) {
                    val firstChildPos = i + 4 + cuesSize.byteLength
                    if (firstChildPos + 2 < limit) {
                        val firstChildByte = buf[firstChildPos].toInt() and 0xFF
                        if (firstChildByte == 0xBB || firstChildByte == 0xBF || firstChildByte == 0xEC) {
                            return i
                        }
                    }
                }
            }
            i++
        }
        return -1
    }

    private fun addBoundary(globalOffset: Long) {
        if (globalOffset <= 0L) return
        if (knownClusterBoundaries.size > 4096) {
            knownClusterBoundaries.pollFirst()
        }
        knownClusterBoundaries.add(globalOffset)
    }

    private fun findValidClusterOffset(
        buf: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        startLocalPos: Int
    ): Int {
        val endLimit = sliceOffset + sliceLength
        var i = sliceOffset + startLocalPos.coerceAtLeast(0)
        while (i + 7 < endLimit) {
            if (buf[i] == 0x1F.toByte() &&
                buf[i + 1] == 0x43.toByte() &&
                buf[i + 2] == 0xB6.toByte() &&
                buf[i + 3] == 0x75.toByte()
            ) {
                val clusterSize = readDataSize(buf, i + 4, endLimit)
                if (clusterSize != null && (clusterSize.value == UNKNOWN_SIZE || clusterSize.value > 4L)) {
                    val firstChildPos = i + 4 + clusterSize.byteLength
                    if (firstChildPos + 2 < endLimit) {
                        val childId = readElementId(buf, firstChildPos, endLimit)
                        if (childId != null && isValidClusterChildId(childId.value)) {
                            val childSizePos = firstChildPos + childId.byteLength
                            val childSize = readDataSize(buf, childSizePos, endLimit)
                            if (childSize != null && childSize.value >= 0L) {
                                return i - sliceOffset
                            }
                        }
                    }
                }
            }
            i++
        }
        return -1
    }

    private fun isValidClusterChildId(id: Long): Boolean {
        return id == ID_TIMECODE ||
            id == ID_SIMPLE_BLOCK ||
            id == ID_BLOCK_GROUP ||
            id == ID_CRC32 ||
            id == ID_VOID ||
            id == ID_CLUSTER_POSITION ||
            id == ID_CLUSTER_PREV_SIZE
    }

    private fun readElementId(buf: ByteArray, pos: Int, limit: Int): VintRead? {
        if (pos < 0 || pos >= limit) return null
        val b0 = buf[pos].toInt() and 0xFF
        val len = when {
            (b0 and 0x80) != 0 -> 1
            (b0 and 0x40) != 0 -> 2
            (b0 and 0x20) != 0 -> 3
            (b0 and 0x10) != 0 -> 4
            else -> return null
        }
        if (pos + len > limit) return null
        var value = b0.toLong()
        for (i in 1 until len) {
            value = (value shl 8) or (buf[pos + i].toLong() and 0xFFL)
        }
        return VintRead(value, len)
    }

    private fun readDataSize(buf: ByteArray, pos: Int, limit: Int): VintRead? {
        if (pos < 0 || pos >= limit) return null
        val b0 = buf[pos].toInt() and 0xFF
        if (b0 == 0) return null
        var len = 1
        var mask = 0x80
        while (len <= 8 && (b0 and mask) == 0) {
            len++
            mask = mask shr 1
        }
        if (len > 8 || pos + len > limit) return null

        var value = (b0 and (mask - 1)).toLong()
        var allOnes = (b0 and (mask - 1)) == (mask - 1)
        for (i in 1 until len) {
            val b = buf[pos + i].toInt() and 0xFF
            if (b != 0xFF) allOnes = false
            value = (value shl 8) or b.toLong()
        }
        return if (allOnes) VintRead(UNKNOWN_SIZE, len) else VintRead(value, len)
    }

    private fun readUnsignedInt(buf: ByteArray, pos: Int, len: Int): Long {
        if (len < 0 || len > 8 || pos + len > buf.size) return 0L
        var v = 0L
        for (i in 0 until len) {
            v = (v shl 8) or (buf[pos + i].toLong() and 0xFFL)
        }
        return v
    }
}
