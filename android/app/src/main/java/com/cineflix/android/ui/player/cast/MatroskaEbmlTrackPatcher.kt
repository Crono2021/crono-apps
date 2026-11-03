package com.cineflix.android.ui.player.cast

import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.util.Locale

/**
 * Zero-transcoding, zero-size-change Matroska (.mkv) EBML `<Tracks>` parser and exact-length region rebuilder.
 *
 * Why Smart TVs (Samsung Tizen S95B, Samsung Orsay, LG webOS, Sony, Hisense) need non-destructive Audio
 * `<Tracks>` rewriting rather than turning unselected Audio `<TrackEntry>` elements into `<Void>`:
 *  1. Inside every Matroska `<Cluster>`, audio `<SimpleBlock>` (`0xA3`) frames for ALL audio `TrackNumber`s
 *     are densely interleaved (~32-48 blocks/sec). Erasing an Audio `<TrackEntry>` (`0xAE -> 0xEC` `<Void>`)
 *     leaves thousands of unregistered `TrackNumber` blocks in `<Cluster>` / `<Cues>`, causing Samsung Tizen's
 *     hardware demuxer (`SavsMatroskaParser` / `MMPlayer`) to stall during pre-roll and exit DLNA DMR.
 *  2. `mkvmerge` omits `FlagDefault` (`0x88`) when `FlagDefault == 1` (the RFC 9559 schema default), and Smart
 *     TVs configured in Spanish (`"spa"`) also auto-prefer audio tracks tagged `Language = "spa"` over `FlagDefault`.
 *
 * How this solves both Audio and Subtitles with 0 byte-length change and 0 `<Cluster>`/`<Cues>` offset shift:
 *  - Rebuilds `[tracksElementStart, tracksElementEnd)` to the EXACT same byte count (`totalTracksBytes`):
 *    - **Audio**: Keeps ALL Audio `<TrackEntry>` (`0xAE`) elements valid and registered with their original
 *      `TrackNumber`, `CodecID`, `CodecPrivate`, and `Audio` settings. Places the user-chosen Audio `<TrackEntry>`
 *      **FIRST** with explicit `FlagDefault = 1`, and places all other Audio `<TrackEntry>` elements **AFTER** it
 *      with explicit `FlagDefault = 0` (`0x88 0x81 0x00`) and `Language` cleared to `"und"` (omitted) so the TV's
 *      system language preference never overrides the user's explicit selection.
 *    - **Subtitles**: Supports `DISABLE_ALL` (omits subtitle entries into trailing `<Void>`) and `SELECT_SINGLE`
 *      (isolates chosen subtitle track and explicitly writes `FlagDefault = 1` and `FlagForced = 1`).
 *    - Pads any remaining byte slack inside `<Tracks>` with a valid EBML `<Void>` (`0xEC`) element (or +1 byte
 *      VINT Data Size widening when `slack == 1`), keeping `Content-Length` and every seek offset 100% identical!
 */
object MatroskaEbmlTrackPatcher {

    const val TRACK_TYPE_VIDEO = 1
    const val TRACK_TYPE_AUDIO = 2
    const val TRACK_TYPE_SUBTITLE = 0x11 // 17

    private const val ID_EBML = 0x1A45DFA3L
    private const val ID_SEGMENT = 0x18538067L
    private const val ID_SEEK_HEAD = 0x114D9B74L
    private const val ID_SEEK = 0x4DBBL
    private const val ID_SEEK_ID = 0x53ABL
    private const val ID_SEEK_POSITION = 0x53ACL
    private const val ID_INFO = 0x1549A966L
    private const val ID_TIMESTAMP_SCALE = 0x2AD7B1L
    private const val ID_DURATION = 0x4489L
    private const val ID_TRACKS = 0x1654AE6BL
    private const val ID_CUES = 0x1C53BB6BL
    private const val ID_CUE_POINT = 0xBBL
    private const val ID_CUE_TRACK_POSITIONS = 0xB7L
    private const val ID_CUE_TRACK = 0xF7L
    private const val ID_CLUSTER = 0x1F43B675L
    private const val ID_CRC32 = 0xBFL
    private const val ID_VOID = 0xECL

    private const val ID_TIMECODE = 0xE7L
    private const val ID_SIMPLE_BLOCK = 0xA3L
    private const val ID_BLOCK_GROUP = 0xA0L
    private const val ID_BLOCK = 0xA1L
    private const val ID_CLUSTER_POSITION = 0xA7L
    private const val ID_CLUSTER_PREV_SIZE = 0xABL

    private const val ID_TRACK_ENTRY = 0xAEL
    private const val ID_TRACK_NUMBER = 0xD7L
    private const val ID_TRACK_UID = 0x73C5L
    private const val ID_TRACK_TYPE = 0x83L
    private const val ID_FLAG_ENABLED = 0xB9L
    private const val ID_FLAG_DEFAULT = 0x88L
    private const val ID_FLAG_FORCED = 0x55AAL
    private const val ID_NAME = 0x536EL
    private const val ID_LANGUAGE = 0x22B59CL
    private const val ID_LANGUAGE_BCP47 = 0x22B59DL
    private const val ID_CODEC_ID = 0x86L
    private const val ID_AUDIO_SETTINGS = 0xE1L
    private const val ID_AUDIO_CHANNELS = 0x9FL
    private const val ID_CONTENT_ENCODINGS = 0x6D80L
    private const val ID_CONTENT_ENCODING = 0x6240L
    private const val ID_CONTENT_COMPRESSION = 0x5034L
    private const val ID_CONTENT_COMP_ALGO = 0x4254L
    private const val ID_CONTENT_COMP_SETTINGS = 0x4255L

    private const val UNKNOWN_SIZE = -1L

    private val TRACKS_ID_BYTES = byteArrayOf(0x16, 0x54, 0xAE.toByte(), 0x6B)
    private val FLAG_ENABLED_FALSE_BYTES = byteArrayOf(0xB9.toByte(), 0x81.toByte(), 0x00)
    private val FLAG_DEFAULT_TRUE_BYTES = byteArrayOf(0x88.toByte(), 0x81.toByte(), 0x01)
    private val FLAG_DEFAULT_FALSE_BYTES = byteArrayOf(0x88.toByte(), 0x81.toByte(), 0x00)
    private val FLAG_FORCED_TRUE_BYTES = byteArrayOf(0x55, 0xAA.toByte(), 0x81.toByte(), 0x01)

    enum class SubtitlePatchMode {
        UNCHANGED,
        DISABLE_ALL,
        SELECT_SINGLE
    }

    /**
     * Exact-size contiguous replacement for `[startOffset, startOffset + replacementBytes.size)`.
     */
    data class EbmlRegionPatch(
        val startOffset: Long,
        val replacementBytes: ByteArray
    ) {
        val endOffsetExclusive: Long
            get() = startOffset + replacementBytes.size
    }

    data class MatroskaTrackInfo(
        val trackNumber: Int,
        val trackType: Int,
        val ordinalInType: Int,
        val entryIdOffset: Long,
        val entryEndOffset: Long,
        val rawEntryBytes: ByteArray,
        val rawPayloadBytes: ByteArray,
        val isDefault: Boolean,
        val isForced: Boolean,
        val language: String,
        val name: String,
        val codecId: String,
        val channels: Int,
        val contentCompAlgo: Int = -1,
        val contentCompSettings: ByteArray = ByteArray(0),
        val isEnabled: Boolean = true
    ) {
        val isDtsOrTrueHd: Boolean
            get() {
                val c = codecId.uppercase(Locale.ROOT)
                return c.startsWith("A_DTS") || c.startsWith("A_TRUEHD") || c.contains("MLP")
            }

        val requiresTvAudioTranscode: Boolean
            get() {
                val c = codecId.uppercase(Locale.ROOT)
                return isDtsOrTrueHd ||
                    c.startsWith("A_FLAC") ||
                    c.startsWith("A_OPUS") ||
                    c.startsWith("A_VORBIS") ||
                    c.startsWith("A_PCM") ||
                    c.startsWith("A_ALAC")
            }

        val isImageSubtitle: Boolean
            get() {
                val c = codecId.uppercase(Locale.ROOT)
                return c.contains("PGS") || c.contains("VOBSUB") || c.contains("DVBSUB")
            }

        val codecShortName: String
            get() {
                val c = codecId.uppercase(Locale.ROOT)
                return when {
                    c.contains("EAC3") -> "E-AC3"
                    c.contains("AC3") -> "AC3"
                    c.contains("DTS") -> "DTS"
                    c.contains("TRUEHD") || c.contains("MLP") -> "TrueHD"
                    c.contains("FLAC") -> "FLAC"
                    c.contains("OPUS") -> "Opus"
                    c.contains("AAC") -> "AAC"
                    c.contains("VORBIS") -> "Vorbis"
                    c.contains("MP3") || c.contains("MPEG/L3") -> "MP3"
                    c.contains("PCM") -> "PCM"
                    c.contains("ASS") || c.contains("SSA") -> "ASS"
                    c.contains("UTF8") -> "SRT"
                    c.contains("PGS") -> "PGS"
                    c.contains("VOBSUB") -> "VobSub"
                    else -> ""
                }
            }

        val codecBadge: String
            get() {
                val parts = mutableListOf<String>()
                if (trackType == TRACK_TYPE_AUDIO && channels > 0) {
                    when (channels) {
                        6 -> parts.add("5.1")
                        8 -> parts.add("7.1")
                        2 -> parts.add("Estéreo")
                        1 -> parts.add("Mono")
                        else -> parts.add("$channels ch")
                    }
                }
                val shortCodec = codecShortName
                if (shortCodec.isNotEmpty()) {
                    parts.add(shortCodec)
                }
                if (trackType == TRACK_TYPE_SUBTITLE) {
                    if (isDefault) parts.add("Predeterminado")
                    if (isForced) parts.add("Forzado")
                }
                return parts.joinToString(" • ")
            }
    }

    data class MatroskaHeaderInfo(
        val tracksElementStart: Long,
        val tracksElementEnd: Long,
        val tracksSizeVintLength: Int,
        val tracksCrcIdOffsets: List<Long>,
        val videoTracks: List<MatroskaTrackInfo>,
        val audioTracks: List<MatroskaTrackInfo>,
        val subtitleTracks: List<MatroskaTrackInfo>,
        val otherTrackEntries: List<ByteArray> = emptyList(),
        val firstClusterOffset: Long = -1L,
        val segmentPayloadStart: Long = 0L,
        val segmentEndOffset: Long = -1L,
        val timestampScaleNs: Long = 1_000_000L,
        val durationMs: Long = 0L,
        val cuesOffset: Long = -1L,
        val chainedSeekHeadOffset: Long = -1L
    ) {
        val hasHevcVideo: Boolean
            get() = videoTracks.any {
                it.codecId.contains("HEVC", ignoreCase = true) ||
                it.codecId.contains("MPEGH", ignoreCase = true)
            }

        val hasExoticVideoCodec: Boolean
            get() = videoTracks.any { vt ->
                val c = vt.codecId.uppercase(Locale.ROOT)
                c.isNotEmpty() &&
                    !c.contains("AVC") &&
                    !c.contains("HEVC") &&
                    !c.contains("MPEGH")
            }
    }

    private data class VintRead(
        val value: Long,
        val byteLength: Int
    )

    /**
     * If `<Tracks>` starts inside [prefix] but its payload extends beyond `prefix.size`,
     * returns the exact required byte count (`tracksElementEnd`) so the caller can fetch a
     * larger header slice (up to e.g. 1 MB) and parse `<Tracks>` completely.
     */
    fun getRequiredBytesIfTruncated(prefix: ByteArray): Long? {
        if (prefix.size < 16 || !hasEbmlMagic(prefix)) return null
        val limit = prefix.size

        val ebmlId = readElementId(prefix, 0, limit) ?: return null
        if (ebmlId.value != ID_EBML) return null
        val ebmlSize = readDataSize(prefix, ebmlId.byteLength, limit) ?: return null
        if (ebmlSize.value == UNKNOWN_SIZE) return null
        val segOffset = ebmlId.byteLength + ebmlSize.byteLength + ebmlSize.value.toInt()
        if (segOffset < 0 || segOffset >= limit) return null

        val segId = readElementId(prefix, segOffset, limit) ?: return null
        if (segId.value != ID_SEGMENT) return null
        val segSize = readDataSize(prefix, segOffset + segId.byteLength, limit) ?: return null
        var pos = segOffset + segId.byteLength + segSize.byteLength
        val segEnd = if (segSize.value == UNKNOWN_SIZE) {
            limit.toLong()
        } else {
            minOf(limit.toLong(), pos.toLong() + segSize.value)
        }.toInt()

        while (pos < segEnd) {
            val elId = readElementId(prefix, pos, segEnd) ?: return null
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(prefix, sizePos, segEnd) ?: return null
            val payloadStart = sizePos + elSize.byteLength
            if (elSize.value == UNKNOWN_SIZE) return null

            val elEndLong = payloadStart.toLong() + elSize.value
            if (elId.value == ID_TRACKS) {
                return if (elEndLong > prefix.size) elEndLong else null
            }
            if (elId.value == ID_CLUSTER) {
                return null
            }
            if (elEndLong > segEnd || elEndLong <= pos) {
                return null
            }
            pos = elEndLong.toInt()
        }
        return null
    }

    /**
     * Parses Matroska `<Tracks>` metadata and exact raw `<TrackEntry>` slices from a header buffer starting at offset 0.
     * Returns `null` if the buffer is not Matroska/WebM or if `<Tracks>` is not completely contained in [headerBytes].
     */
    fun parseHeader(headerBytes: ByteArray): MatroskaHeaderInfo? {
        if (headerBytes.size < 32 || !hasEbmlMagic(headerBytes)) return null
        val limit = headerBytes.size

        val ebmlId = readElementId(headerBytes, 0, limit) ?: return null
        if (ebmlId.value != ID_EBML) return null
        val ebmlSize = readDataSize(headerBytes, ebmlId.byteLength, limit) ?: return null
        if (ebmlSize.value < 0) return null

        val segStartLong = ebmlId.byteLength.toLong() + ebmlSize.byteLength + ebmlSize.value
        if (segStartLong <= 0 || segStartLong >= limit) return null
        val segStart = segStartLong.toInt()

        val segId = readElementId(headerBytes, segStart, limit) ?: return null
        if (segId.value != ID_SEGMENT) return null
        val segSize = readDataSize(headerBytes, segStart + segId.byteLength, limit) ?: return null
        val segPayloadStart = segStart + segId.byteLength + segSize.byteLength
        val segmentEndOffset = if (segSize.value > 0L && segSize.value != UNKNOWN_SIZE) {
            segPayloadStart.toLong() + segSize.value
        } else {
            -1L
        }
        var pos = segPayloadStart
        val segLimit = if (segSize.value == UNKNOWN_SIZE) {
            limit
        } else {
            minOf(limit.toLong(), pos.toLong() + segSize.value).toInt()
        }

        var timestampScaleNs = 1_000_000L
        var durationMs = 0L
        var cuesOffset = -1L
        var chainedSeekHeadOffset = -1L

        while (pos < segLimit) {
            val elId = readElementId(headerBytes, pos, segLimit) ?: return null
            val sizeOffset = pos + elId.byteLength
            val elSize = readDataSize(headerBytes, sizeOffset, segLimit) ?: return null
            if (elSize.value < 0) return null

            val payloadStart = sizeOffset + elSize.byteLength
            val elEndLong = payloadStart.toLong() + elSize.value

            if (elId.value == ID_SEEK_HEAD && elEndLong <= limit) {
                val (parsedCuesOff, parsedChainedOff) = parseSeekHeadForOffsets(
                    buf = headerBytes,
                    start = payloadStart,
                    end = elEndLong.toInt(),
                    segmentPayloadStart = segPayloadStart.toLong()
                )
                if (parsedCuesOff > 0L) {
                    cuesOffset = parsedCuesOff
                }
                if (parsedChainedOff > 0L && parsedChainedOff != pos.toLong()) {
                    chainedSeekHeadOffset = parsedChainedOff
                }
            } else if (elId.value == ID_INFO && elEndLong <= limit) {
                val (parsedScale, parsedDurMs) = parseInfoScaleAndDuration(
                    buf = headerBytes,
                    start = payloadStart,
                    end = elEndLong.toInt()
                )
                if (parsedScale > 0L) {
                    timestampScaleNs = parsedScale
                }
                if (parsedDurMs > 0L) {
                    durationMs = parsedDurMs
                }
            } else if (elId.value == ID_TRACKS) {
                if (elEndLong > limit) {
                    return null
                }
                var clusterOff = -1L
                var scanPos = elEndLong.toInt()
                while (scanPos < segLimit) {
                    val nextId = readElementId(headerBytes, scanPos, segLimit) ?: break
                    if (nextId.value == ID_CLUSTER) {
                        clusterOff = scanPos.toLong()
                        break
                    }
                    val nextSizeOff = scanPos + nextId.byteLength
                    val nextSize = readDataSize(headerBytes, nextSizeOff, segLimit) ?: break
                    if (nextSize.value < 0) break
                    val nextPayloadStart = nextSizeOff + nextSize.byteLength
                    val nextEnd = nextPayloadStart.toLong() + nextSize.value
                    if (nextEnd <= scanPos || nextEnd > segLimit) break
                    if (nextId.value == ID_SEEK_HEAD && cuesOffset <= 0L) {
                        val (parsedCuesOff, parsedChainedOff) = parseSeekHeadForOffsets(
                            buf = headerBytes,
                            start = nextPayloadStart,
                            end = nextEnd.toInt(),
                            segmentPayloadStart = segPayloadStart.toLong()
                        )
                        if (parsedCuesOff > 0L) {
                            cuesOffset = parsedCuesOff
                        }
                        if (parsedChainedOff > 0L && chainedSeekHeadOffset <= 0L) {
                            chainedSeekHeadOffset = parsedChainedOff
                        }
                    } else if (nextId.value == ID_INFO) {
                        val (parsedScale, parsedDurMs) = parseInfoScaleAndDuration(
                            buf = headerBytes,
                            start = nextPayloadStart,
                            end = nextEnd.toInt()
                        )
                        if (parsedScale > 0L) {
                            timestampScaleNs = parsedScale
                        }
                        if (parsedDurMs > 0L) {
                            durationMs = parsedDurMs
                        }
                    }
                    scanPos = nextEnd.toInt()
                }
                return parseTracksElement(
                    buf = headerBytes,
                    tracksElementStart = pos.toLong(),
                    tracksSizeVintLength = elSize.byteLength,
                    payloadStart = payloadStart,
                    payloadEnd = elEndLong.toInt(),
                    firstClusterOffset = clusterOff,
                    segmentPayloadStart = segPayloadStart.toLong(),
                    segmentEndOffset = segmentEndOffset,
                    timestampScaleNs = timestampScaleNs,
                    durationMs = durationMs,
                    cuesOffset = cuesOffset,
                    chainedSeekHeadOffset = chainedSeekHeadOffset
                )
            }

            if (elId.value == ID_CLUSTER) {
                return null
            }

            if (elEndLong <= pos || elEndLong > segLimit) {
                return null
            }
            pos = elEndLong.toInt()
        }

        return null
    }

    /**
     * Parses a `<SeekHead>` (`0x114D9B74`) element starting at byte 0 of [buf] and returns the absolute
     * file offset of `<Cues>` (`0x1C53BB6B`), or `-1L` if not present.
     */
    fun parseSeekHeadSliceForCuesOffset(
        buf: ByteArray,
        limit: Int,
        segmentPayloadStart: Long
    ): Long {
        if (limit < 12) return -1L
        val idRead = readElementId(buf, 0, limit) ?: return -1L
        if (idRead.value != ID_SEEK_HEAD) return -1L
        val sizeRead = readDataSize(buf, idRead.byteLength, limit) ?: return -1L
        if (sizeRead.value < 0L) return -1L
        val payloadStart = idRead.byteLength + sizeRead.byteLength
        val payloadEnd = minOf(limit.toLong(), payloadStart.toLong() + sizeRead.value).toInt()
        return parseSeekHeadForOffsets(buf, payloadStart, payloadEnd, segmentPayloadStart).first
    }

    private fun parseSeekHeadForOffsets(
        buf: ByteArray,
        start: Int,
        end: Int,
        segmentPayloadStart: Long
    ): Pair<Long, Long> {
        var cuesOff = -1L
        var chainedSeekHeadOff = -1L
        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            val valEnd = valEndLong.toInt()
            if (elId.value == ID_SEEK) {
                var seekId = 0L
                var seekPos = -1L
                var sub = valStart
                while (sub < valEnd) {
                    val cId = readElementId(buf, sub, valEnd) ?: break
                    val cSizePos = sub + cId.byteLength
                    val cSize = readDataSize(buf, cSizePos, valEnd) ?: break
                    if (cSize.value < 0) break
                    val cValStart = cSizePos + cSize.byteLength
                    val cValEndLong = cValStart.toLong() + cSize.value
                    if (cValEndLong > valEnd || cValEndLong <= sub) break
                    val cLen = cSize.value.toInt()
                    when (cId.value) {
                        ID_SEEK_ID -> seekId = readUnsignedInt(buf, cValStart, cLen)
                        ID_SEEK_POSITION -> seekPos = readUnsignedInt(buf, cValStart, cLen)
                    }
                    sub = cValEndLong.toInt()
                }
                if (seekPos >= 0L) {
                    when (seekId) {
                        ID_CUES -> cuesOff = segmentPayloadStart + seekPos
                        ID_SEEK_HEAD -> chainedSeekHeadOff = segmentPayloadStart + seekPos
                    }
                }
            }
            pos = valEnd
        }
        return Pair(cuesOff, chainedSeekHeadOff)
    }

    private fun parseInfoScaleAndDuration(buf: ByteArray, start: Int, end: Int): Pair<Long, Long> {
        var scaleNs = 1_000_000L
        var rawDuration = -1.0
        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            val valLen = elSize.value.toInt()
            when (elId.value) {
                ID_TIMESTAMP_SCALE -> {
                    val scale = readUnsignedInt(buf, valStart, valLen)
                    if (scale > 0L) scaleNs = scale
                }
                ID_DURATION -> {
                    if (valLen == 4) {
                        val bits = readUnsignedInt(buf, valStart, 4).toInt()
                        rawDuration = java.lang.Float.intBitsToFloat(bits).toDouble()
                    } else if (valLen == 8) {
                        val bits = readUnsignedInt(buf, valStart, 8)
                        rawDuration = java.lang.Double.longBitsToDouble(bits)
                    }
                }
            }
            pos = valEndLong.toInt()
        }
        val durationMs = if (rawDuration > 0.0 && rawDuration.isFinite()) {
            ((rawDuration * scaleNs.toDouble()) / 1_000_000.0).toLong().coerceAtLeast(0L)
        } else {
            0L
        }
        return Pair(scaleNs, durationMs)
    }

    /**
     * Reads the `<Timecode>` (`0xE7`) child element inside a Matroska `<Cluster>` (`0x1F43B675`)
     * starting at [clusterOffset] within [buf] (up to [limit]), returning the raw timecode in
     * `TimestampScale` ticks, or `-1L` if not present within the buffer slice.
     */
    fun readClusterTimecodeTicks(buf: ByteArray, clusterOffset: Int, limit: Int): Long {
        if (clusterOffset < 0 || clusterOffset + 8 > limit) return -1L
        if (buf[clusterOffset] != 0x1F.toByte() ||
            buf[clusterOffset + 1] != 0x43.toByte() ||
            buf[clusterOffset + 2] != 0xB6.toByte() ||
            buf[clusterOffset + 3] != 0x75.toByte()
        ) {
            return -1L
        }
        val clusterSize = readDataSize(buf, clusterOffset + 4, limit) ?: return -1L
        var pos = clusterOffset + 4 + clusterSize.byteLength
        val scanEnd = minOf(limit, pos + 96)
        while (pos < scanEnd) {
            val childId = readElementId(buf, pos, limit) ?: return -1L
            val childSizePos = pos + childId.byteLength
            val childSize = readDataSize(buf, childSizePos, limit) ?: return -1L
            if (childSize.value < 0) return -1L
            val valStart = childSizePos + childSize.byteLength
            val valLen = childSize.value.toInt()
            if (childId.value == ID_TIMECODE) {
                if (valLen !in 1..8 || valStart + valLen > limit) return -1L
                return readUnsignedInt(buf, valStart, valLen)
            }
            if (childId.value == ID_SIMPLE_BLOCK || childId.value == ID_BLOCK_GROUP) {
                // Timecode always precedes blocks in standard Matroska Clusters
                return -1L
            }
            val nextPos = valStart.toLong() + childSize.value
            if (nextPos <= pos || nextPos > limit) return -1L
            pos = nextPos.toInt()
        }
        return -1L
    }

    private fun parseTracksElement(
        buf: ByteArray,
        tracksElementStart: Long,
        tracksSizeVintLength: Int,
        payloadStart: Int,
        payloadEnd: Int,
        firstClusterOffset: Long = -1L,
        segmentPayloadStart: Long = 0L,
        segmentEndOffset: Long = -1L,
        timestampScaleNs: Long = 1_000_000L,
        durationMs: Long = 0L,
        cuesOffset: Long = -1L,
        chainedSeekHeadOffset: Long = -1L
    ): MatroskaHeaderInfo? {
        val tracksCrcOffsets = mutableListOf<Long>()
        val videoList = mutableListOf<MatroskaTrackInfo>()
        val audioList = mutableListOf<MatroskaTrackInfo>()
        val subtitleList = mutableListOf<MatroskaTrackInfo>()
        val otherEntries = mutableListOf<ByteArray>()

        var pos = payloadStart
        while (pos < payloadEnd) {
            val childId = readElementId(buf, pos, payloadEnd) ?: return null
            val sizePos = pos + childId.byteLength
            val childSize = readDataSize(buf, sizePos, payloadEnd) ?: return null
            if (childSize.value < 0) return null

            val childPayloadStart = sizePos + childSize.byteLength
            val childEndLong = childPayloadStart.toLong() + childSize.value
            if (childEndLong > payloadEnd || childEndLong <= pos) return null
            val childEnd = childEndLong.toInt()

            when (childId.value) {
                ID_CRC32 -> {
                    if (childId.byteLength == 1) {
                        tracksCrcOffsets.add(pos.toLong())
                    }
                }
                ID_TRACK_ENTRY -> {
                    if (childId.byteLength == 1) {
                        val parsed = parseTrackEntry(
                            buf = buf,
                            entryStart = pos,
                            payloadStart = childPayloadStart,
                            payloadEnd = childEnd,
                            currentVideoCount = videoList.size,
                            currentAudioCount = audioList.size,
                            currentSubCount = subtitleList.size
                        )
                        if (parsed != null) {
                            when (parsed.trackType) {
                                TRACK_TYPE_VIDEO -> videoList.add(parsed)
                                TRACK_TYPE_AUDIO -> audioList.add(parsed)
                                TRACK_TYPE_SUBTITLE -> subtitleList.add(parsed)
                                else -> otherEntries.add(parsed.rawEntryBytes)
                            }
                        } else {
                            otherEntries.add(buf.copyOfRange(pos, childEnd))
                        }
                    }
                }
            }

            pos = childEnd
        }

        return MatroskaHeaderInfo(
            tracksElementStart = tracksElementStart,
            tracksElementEnd = payloadEnd.toLong(),
            tracksSizeVintLength = tracksSizeVintLength,
            tracksCrcIdOffsets = tracksCrcOffsets,
            videoTracks = videoList,
            audioTracks = audioList,
            subtitleTracks = subtitleList,
            otherTrackEntries = otherEntries,
            firstClusterOffset = firstClusterOffset,
            segmentPayloadStart = segmentPayloadStart,
            segmentEndOffset = segmentEndOffset,
            timestampScaleNs = timestampScaleNs,
            durationMs = durationMs,
            cuesOffset = cuesOffset,
            chainedSeekHeadOffset = chainedSeekHeadOffset
        )
    }

    private fun parseTrackEntry(
        buf: ByteArray,
        entryStart: Int,
        payloadStart: Int,
        payloadEnd: Int,
        currentVideoCount: Int,
        currentAudioCount: Int,
        currentSubCount: Int
    ): MatroskaTrackInfo? {
        var trackNumber = 0
        var trackType = 0
        var isEnabled = true // RFC 9559: Matroska default for FlagEnabled when omitted is 1 (true)
        var isDefault = true // RFC 9559: Matroska default for FlagDefault when omitted is 1 (true)
        var isForced = false // RFC 9559: Matroska default for FlagForced when omitted is 0 (false)
        var name = ""
        var langIso = ""
        var langBcp47 = ""
        var codecId = ""
        var channels = 0
        var contentCompAlgo = -1
        var contentCompSettings = ByteArray(0)

        var pos = payloadStart
        while (pos < payloadEnd) {
            val elId = readElementId(buf, pos, payloadEnd) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, payloadEnd) ?: break
            if (elSize.value < 0) break

            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > payloadEnd || valEndLong <= pos) break
            val valEnd = valEndLong.toInt()
            val valLen = elSize.value.toInt()

            when (elId.value) {
                ID_TRACK_NUMBER -> {
                    trackNumber = readUnsignedInt(buf, valStart, valLen).toInt()
                }
                ID_TRACK_TYPE -> {
                    trackType = readUnsignedInt(buf, valStart, valLen).toInt()
                }
                ID_FLAG_ENABLED -> {
                    isEnabled = readUnsignedInt(buf, valStart, valLen) != 0L
                }
                ID_FLAG_DEFAULT -> {
                    isDefault = readUnsignedInt(buf, valStart, valLen) != 0L
                }
                ID_FLAG_FORCED -> {
                    isForced = readUnsignedInt(buf, valStart, valLen) != 0L
                }
                ID_NAME -> {
                    if (valLen > 0) {
                        name = String(buf, valStart, valLen, StandardCharsets.UTF_8).trim('\u0000', ' ')
                    }
                }
                ID_LANGUAGE -> {
                    if (valLen > 0) {
                        langIso = String(buf, valStart, valLen, StandardCharsets.US_ASCII).trim('\u0000', ' ')
                    }
                }
                ID_LANGUAGE_BCP47 -> {
                    if (valLen > 0) {
                        langBcp47 = String(buf, valStart, valLen, StandardCharsets.US_ASCII).trim('\u0000', ' ')
                    }
                }
                ID_CODEC_ID -> {
                    if (valLen > 0) {
                        codecId = String(buf, valStart, valLen, StandardCharsets.US_ASCII).trim('\u0000', ' ')
                    }
                }
                ID_AUDIO_SETTINGS -> {
                    channels = parseAudioChannels(buf, valStart, valEnd)
                }
                ID_CONTENT_ENCODINGS -> {
                    val (algo, settings) = parseContentEncodings(buf, valStart, valEnd)
                    if (algo >= 0) {
                        contentCompAlgo = algo
                        contentCompSettings = settings
                    }
                }
            }

            pos = valEnd
        }

        if (trackType == 0) return null
        val ordinal = when (trackType) {
            TRACK_TYPE_VIDEO -> currentVideoCount
            TRACK_TYPE_AUDIO -> currentAudioCount
            TRACK_TYPE_SUBTITLE -> currentSubCount
            else -> 0
        }
        val effectiveLang = langBcp47.ifBlank {
            if (langIso.equals("und", ignoreCase = true)) "" else langIso
        }

        return MatroskaTrackInfo(
            trackNumber = trackNumber,
            trackType = trackType,
            ordinalInType = ordinal,
            entryIdOffset = entryStart.toLong(),
            entryEndOffset = payloadEnd.toLong(),
            rawEntryBytes = buf.copyOfRange(entryStart, payloadEnd),
            rawPayloadBytes = buf.copyOfRange(payloadStart, payloadEnd),
            isDefault = isDefault,
            isForced = isForced,
            language = effectiveLang,
            name = name,
            codecId = codecId,
            channels = channels,
            contentCompAlgo = contentCompAlgo,
            contentCompSettings = contentCompSettings,
            isEnabled = isEnabled
        )
    }

    private fun parseContentEncodings(buf: ByteArray, start: Int, end: Int): Pair<Int, ByteArray> {
        var algo = -1
        var settings = ByteArray(0)
        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            val valEnd = valEndLong.toInt()
            if (elId.value == ID_CONTENT_ENCODING) {
                var encPos = valStart
                while (encPos < valEnd) {
                    val cId = readElementId(buf, encPos, valEnd) ?: break
                    val cSizePos = encPos + cId.byteLength
                    val cSize = readDataSize(buf, cSizePos, valEnd) ?: break
                    if (cSize.value < 0) break
                    val cValStart = cSizePos + cSize.byteLength
                    val cValEndLong = cValStart.toLong() + cSize.value
                    if (cValEndLong > valEnd || cValEndLong <= encPos) break
                    val cValEnd = cValEndLong.toInt()
                    if (cId.value == ID_CONTENT_COMPRESSION) {
                        // RFC 9559: Default ContentCompAlgo inside ContentCompression when omitted is 0 (zlib)
                        algo = 0
                        var compPos = cValStart
                        while (compPos < cValEnd) {
                            val subId = readElementId(buf, compPos, cValEnd) ?: break
                            val subSizePos = compPos + subId.byteLength
                            val subSize = readDataSize(buf, subSizePos, cValEnd) ?: break
                            if (subSize.value < 0) break
                            val subValStart = subSizePos + subSize.byteLength
                            val subValEndLong = subValStart.toLong() + subSize.value
                            if (subValEndLong > cValEnd || subValEndLong <= compPos) break
                            val subLen = subSize.value.toInt()
                            when (subId.value) {
                                ID_CONTENT_COMP_ALGO -> algo = readUnsignedInt(buf, subValStart, subLen).toInt()
                                ID_CONTENT_COMP_SETTINGS -> {
                                    if (subLen > 0) {
                                        settings = buf.copyOfRange(subValStart, subValStart + subLen)
                                    }
                                }
                            }
                            compPos = subValEndLong.toInt()
                        }
                    }
                    encPos = cValEnd
                }
            }
            pos = valEnd
        }
        return Pair(algo, settings)
    }

    private fun parseAudioChannels(buf: ByteArray, start: Int, end: Int): Int {
        var pos = start
        while (pos < end) {
            val elId = readElementId(buf, pos, end) ?: break
            val sizePos = pos + elId.byteLength
            val elSize = readDataSize(buf, sizePos, end) ?: break
            if (elSize.value < 0) break
            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > end || valEndLong <= pos) break
            if (elId.value == ID_AUDIO_CHANNELS) {
                return readUnsignedInt(buf, valStart, elSize.value.toInt()).toInt()
            }
            pos = valEndLong.toInt()
        }
        return 0
    }

    /**
     * Determines the 1-byte EBML `<TrackNumber>` swap pair `(chosenTrackNumber, primarySlotTrackNumber)`
     * when a non-primary audio track is selected in a multi-audio Matroska file.
     *
     * Many Smart TV hardware demuxers (`SavsMatroskaParser` on Samsung Tizen, `LG webOS`, `Sony Bravia`)
     * index `<TrackEntry>` objects by `TrackNumber` (`1, 2, 3...`) and play the lowest-numbered audio track
     * regardless of `<TrackEntry>` ordering in `<Tracks>`.
     * Swapping `<TrackNumber>` (`1..126`, 1-byte VINT `0x81..0xFE`) in `<Tracks>` AND swapping the 1-byte
     * `TrackNumber` VINT at the start of `<SimpleBlock>` (`0xA3`) / `<Block>` (`0xA1`) payloads in `<Cluster>`s
     * makes the user's selected audio track the lowest `TrackNumber` with **0 byte-length change** and
     * **TRUE discrete 5.1 Surround** (`AC3` / `E-AC3`)!
     */
    fun resolveAudioTrackNumberSwap(
        info: MatroskaHeaderInfo?,
        selectedAudioTrackNumber: Int? = null,
        selectedAudioOrdinal: Int? = null
    ): Pair<Int, Int>? {
        if (info == null || info.audioTracks.size < 2) return null
        val chosenAudio: MatroskaTrackInfo = when {
            selectedAudioTrackNumber != null ->
                info.audioTracks.firstOrNull { it.trackNumber == selectedAudioTrackNumber }
                    ?: selectedAudioOrdinal?.let { info.audioTracks.getOrNull(it) }
            selectedAudioOrdinal != null ->
                info.audioTracks.getOrNull(selectedAudioOrdinal)
            else -> null
        } ?: return null

        val primarySlotAudio = info.audioTracks.minByOrNull {
            if (it.trackNumber > 0) it.trackNumber else Int.MAX_VALUE
        } ?: info.audioTracks.first()

        val chosenNum = chosenAudio.trackNumber
        val primaryNum = primarySlotAudio.trackNumber
        if (chosenNum == primaryNum || chosenNum !in 1..126 || primaryNum !in 1..126) {
            return null
        }
        return Pair(chosenNum, primaryNum)
    }

    /**
     * Determines the 1-byte EBML `<TrackNumber>` swap pair `(chosenSubtitleTrackNumber, primarySubtitleTrackNumber)`
     * when a non-primary subtitle track is selected in a multi-subtitle Matroska file.
     */
    fun resolveSubtitleTrackNumberSwap(
        info: MatroskaHeaderInfo?,
        subtitleMode: SubtitlePatchMode = SubtitlePatchMode.SELECT_SINGLE,
        selectedSubtitleTrackNumber: Int? = null,
        selectedSubtitleOrdinal: Int? = null
    ): Pair<Int, Int>? {
        if (info == null || subtitleMode != SubtitlePatchMode.SELECT_SINGLE || info.subtitleTracks.size < 2) {
            return null
        }
        val chosenSub: MatroskaTrackInfo = when {
            selectedSubtitleTrackNumber != null ->
                info.subtitleTracks.firstOrNull { it.trackNumber == selectedSubtitleTrackNumber }
                    ?: selectedSubtitleOrdinal?.let { info.subtitleTracks.getOrNull(it) }
            selectedSubtitleOrdinal != null ->
                info.subtitleTracks.getOrNull(selectedSubtitleOrdinal)
            else -> null
        } ?: return null

        val primarySlotSub = info.subtitleTracks.minByOrNull {
            if (it.trackNumber > 0) it.trackNumber else Int.MAX_VALUE
        } ?: info.subtitleTracks.first()

        val chosenNum = chosenSub.trackNumber
        val primaryNum = primarySlotSub.trackNumber
        if (chosenNum == primaryNum || chosenNum !in 1..126 || primaryNum !in 1..126) {
            return null
        }
        return Pair(chosenNum, primaryNum)
    }

    /**
     * Rebuilds the `<Tracks>` EBML region `[tracksElementStart, tracksElementEnd)` with exact byte-length
     * preservation so the Smart TV plays the selected Audio and/or Subtitle track without breaking `<Cluster>`
     * demuxing or shifting a single file offset.
     *
     * Returns `null` if neither Audio nor Subtitles are overridden (or if no changes apply).
     */
    fun buildTracksRegionPatch(
        info: MatroskaHeaderInfo,
        selectedAudioTrackNumber: Int? = null,
        selectedAudioOrdinal: Int? = null,
        subtitleMode: SubtitlePatchMode = SubtitlePatchMode.UNCHANGED,
        selectedSubtitleTrackNumber: Int? = null,
        selectedSubtitleOrdinal: Int? = null,
        swapAudioTrackNumbers: Boolean = false,
        swapSubtitleTrackNumbers: Boolean = false
    ): EbmlRegionPatch? {
        val chosenAudio: MatroskaTrackInfo? = when {
            selectedAudioTrackNumber != null ->
                info.audioTracks.firstOrNull { it.trackNumber == selectedAudioTrackNumber }
                    ?: selectedAudioOrdinal?.let { info.audioTracks.getOrNull(it) }
            selectedAudioOrdinal != null ->
                info.audioTracks.getOrNull(selectedAudioOrdinal)
            else -> null
        }

        val hasAudioOverride = chosenAudio != null && info.audioTracks.isNotEmpty()
        val hasSubtitleOverride = subtitleMode != SubtitlePatchMode.UNCHANGED
        if (!hasAudioOverride && !hasSubtitleOverride) {
            return null
        }

        val totalTargetBytesLong = info.tracksElementEnd - info.tracksElementStart
        if (totalTargetBytesLong <= 8L || totalTargetBytesLong > 4L * 1024L * 1024L) {
            return null
        }
        val totalTargetBytes = totalTargetBytesLong.toInt()
        val origSizeVintLen = info.tracksSizeVintLength
        val origPayloadCapacity = totalTargetBytes - 4 - origSizeVintLen
        if (origPayloadCapacity <= 0) return null

        val chosenSub: MatroskaTrackInfo? = if (subtitleMode == SubtitlePatchMode.SELECT_SINGLE) {
            when {
                selectedSubtitleTrackNumber != null ->
                    info.subtitleTracks.firstOrNull { it.trackNumber == selectedSubtitleTrackNumber }
                        ?: selectedSubtitleOrdinal?.let { info.subtitleTracks.getOrNull(it) }
                selectedSubtitleOrdinal != null ->
                    info.subtitleTracks.getOrNull(selectedSubtitleOrdinal)
                else -> info.subtitleTracks.firstOrNull()
            }
        } else {
            null
        }

        val audioSwapPair = if (swapAudioTrackNumbers) {
            resolveAudioTrackNumberSwap(info, selectedAudioTrackNumber, selectedAudioOrdinal)
        } else {
            null
        }
        val subtitleSwapPair = if (swapSubtitleTrackNumbers) {
            resolveSubtitleTrackNumberSwap(info, subtitleMode, selectedSubtitleTrackNumber, selectedSubtitleOrdinal)
        } else {
            null
        }

        // Try 3 progressive compactness levels so we ALWAYS fit inside `origPayloadCapacity`:
        //  - Level 0 (standard): explicit FlagDefault=1 (3B) on chosen tracks, FlagForced=1 (4B) on chosen sub,
        //    explicit FlagDefault=0 (3B) + neutralized Language ("und", saves 7-16B) on unselected tracks.
        //  - Level 1 (compact): strip <CRC-32> on video/audio entries when needed and strip Name on unselected tracks.
        //  - Level 2 (ultra-compact): omit FlagDefault on chosen audio/sub (RFC 9559 default = 1) and isolate chosen sub.
        for (compactLevel in 0..2) {
            val entries = buildOrderedTrackEntryByteList(
                info = info,
                chosenAudio = chosenAudio,
                audioSwapPair = audioSwapPair,
                subtitleMode = subtitleMode,
                chosenSub = chosenSub,
                subtitleSwapPair = subtitleSwapPair,
                compactLevel = compactLevel
            )
            val assembled = tryAssembleTracksWithExactTotalSize(
                entryPayloadsAndRaw = entries,
                totalTargetBytes = totalTargetBytes,
                origTracksSizeVintLen = origSizeVintLen
            )
            if (assembled != null) {
                return EbmlRegionPatch(
                    startOffset = info.tracksElementStart,
                    replacementBytes = assembled
                )
            }
        }

        return null
    }

    /**
     * Checks if [patch] overlaps `[rangeGlobalStart, rangeGlobalStart + sliceLength)`.
     * If it overlaps, returns a fresh `ByteArray(sliceLength)` with the patched `<Tracks>` bytes overlaid
     * (never mutating [sourceBuffer]). If it does not overlap (99.999% of the movie), returns `null` in O(1).
     */
    fun applyRegionPatchToRange(
        sourceBuffer: ByteArray,
        sliceOffset: Int,
        sliceLength: Int,
        rangeGlobalStart: Long,
        patch: EbmlRegionPatch?
    ): ByteArray? {
        if (patch == null || sliceLength <= 0) return null
        val sliceGlobalEnd = rangeGlobalStart + sliceLength
        if (sliceGlobalEnd <= patch.startOffset || rangeGlobalStart >= patch.endOffsetExclusive) {
            return null
        }

        val copy = sourceBuffer.copyOfRange(sliceOffset, sliceOffset + sliceLength)
        val overlapStart = maxOf(rangeGlobalStart, patch.startOffset)
        val overlapEnd = minOf(sliceGlobalEnd, patch.endOffsetExclusive)
        val count = (overlapEnd - overlapStart).toInt()
        if (count > 0) {
            val srcPos = (overlapStart - patch.startOffset).toInt()
            val dstPos = (overlapStart - rangeGlobalStart).toInt()
            System.arraycopy(patch.replacementBytes, srcPos, copy, dstPos, count)
        }
        return copy
    }

    /**
     * Represents a `<TrackEntry>` to serialize: either verbatim raw entry bytes (`isRawEntry = true`)
     * or a rebuilt `<TrackEntry>` payload (`isRawEntry = false`, wrapped with `0xAE` + VINT size).
     */
    private class TrackEntrySpec(
        val bytes: ByteArray,
        val isRawEntry: Boolean
    )

    private fun buildOrderedTrackEntryByteList(
        info: MatroskaHeaderInfo,
        chosenAudio: MatroskaTrackInfo?,
        audioSwapPair: Pair<Int, Int>?,
        subtitleMode: SubtitlePatchMode,
        chosenSub: MatroskaTrackInfo?,
        subtitleSwapPair: Pair<Int, Int>?,
        compactLevel: Int
    ): List<TrackEntrySpec> {
        val list = mutableListOf<TrackEntrySpec>()
        val hasSubOverride = subtitleMode != SubtitlePatchMode.UNCHANGED

        // 1. Video tracks (strip <CRC-32>/<Void>/<Name>/<Language> when needed to free headroom for subtitle flags)
        for (video in info.videoTracks) {
            if (hasSubOverride && compactLevel >= 1) {
                val vidPayload = rewriteTrackEntryPayload(
                    rawPayload = video.rawPayloadBytes,
                    overrideTrackNumber = null,
                    explicitFlagEnabled = null,
                    explicitFlagDefault = if (video.isDefault) null else false,
                    explicitFlagForced = if (video.isForced) true else null,
                    neutralizeLanguage = true,
                    stripName = true,
                    stripBcp47 = true,
                    compactTrackUid = compactLevel >= 1
                )
                list.add(TrackEntrySpec(vidPayload, isRawEntry = false))
            } else {
                list.add(TrackEntrySpec(video.rawEntryBytes, isRawEntry = true))
            }
        }

        // 2. Audio tracks: ALL kept registered in <Tracks>! Chosen audio placed FIRST with FlagDefault=1
        //    (and swapped into the lowest TrackNumber slot when audioSwapPair != null);
        //    unselected audio placed AFTER with explicit FlagDefault=0 and neutralized Language ("und").
        if (chosenAudio != null && info.audioTracks.isNotEmpty()) {
            val chosenOverrideNum = if (audioSwapPair != null && chosenAudio.trackNumber == audioSwapPair.first) {
                audioSwapPair.second
            } else {
                null
            }
            val chosenPayload = rewriteTrackEntryPayload(
                rawPayload = chosenAudio.rawPayloadBytes,
                overrideTrackNumber = chosenOverrideNum,
                explicitFlagEnabled = null, // omitted = true (1) per RFC 9559
                explicitFlagDefault = if (compactLevel <= 1) true else null, // null = omitted = true per RFC 9559
                explicitFlagForced = if (chosenAudio.isForced) true else null,
                neutralizeLanguage = false,
                stripName = compactLevel >= 1,
                stripBcp47 = compactLevel >= 1,
                compactTrackUid = compactLevel >= 1
            )
            list.add(TrackEntrySpec(chosenPayload, isRawEntry = false))

            for (audio in info.audioTracks) {
                if (audio === chosenAudio) continue
                val otherOverrideNum = if (audioSwapPair != null && audio.trackNumber == audioSwapPair.second) {
                    audioSwapPair.first
                } else {
                    null
                }
                val otherPayload = rewriteTrackEntryPayload(
                    rawPayload = audio.rawPayloadBytes,
                    overrideTrackNumber = otherOverrideNum,
                    explicitFlagEnabled = null,  // omitted = true (1) so hardware demuxers never reject Cluster blocks for this track
                    explicitFlagDefault = false, // MUST explicitly write 0x88 0x81 0x00!
                    explicitFlagForced = null,   // omitted = false (0) per RFC 9559
                    neutralizeLanguage = true,   // omit Language/LanguageBCP47 -> "und"
                    stripName = compactLevel >= 1,
                    stripBcp47 = true,
                    compactTrackUid = compactLevel >= 1
                )
                list.add(TrackEntrySpec(otherPayload, isRawEntry = false))
            }
        } else if (hasSubOverride && compactLevel >= 1) {
            for (audio in info.audioTracks) {
                val audPayload = rewriteTrackEntryPayload(
                    rawPayload = audio.rawPayloadBytes,
                    overrideTrackNumber = null,
                    explicitFlagEnabled = null,
                    explicitFlagDefault = if (audio.isDefault) null else false,
                    explicitFlagForced = if (audio.isForced) true else null,
                    neutralizeLanguage = false,
                    stripName = true,
                    stripBcp47 = true,
                    compactTrackUid = compactLevel >= 1
                )
                list.add(TrackEntrySpec(audPayload, isRawEntry = false))
            }
        } else {
            for (audio in info.audioTracks) {
                list.add(TrackEntrySpec(audio.rawEntryBytes, isRawEntry = true))
            }
        }

        // 3. Subtitle tracks: ALL kept registered in <Tracks> across every compactLevel and SubtitlePatchMode
        //    so hardware Matroska demuxers never encounter unregistered subtitle TrackNumbers in <Cluster>!
        when (subtitleMode) {
            SubtitlePatchMode.UNCHANGED -> {
                for (sub in info.subtitleTracks) {
                    list.add(TrackEntrySpec(sub.rawEntryBytes, isRawEntry = true))
                }
            }
            SubtitlePatchMode.DISABLE_ALL -> {
                for (sub in info.subtitleTracks) {
                    val disabledSubPayload = rewriteTrackEntryPayload(
                        rawPayload = sub.rawPayloadBytes,
                        overrideTrackNumber = null,
                        explicitFlagEnabled = if (compactLevel <= 1) false else null,
                        explicitFlagDefault = false,
                        explicitFlagForced = null,
                        neutralizeLanguage = true,
                        stripName = true,
                        stripBcp47 = true,
                        compactTrackUid = true
                    )
                    list.add(TrackEntrySpec(disabledSubPayload, isRawEntry = false))
                }
            }
            SubtitlePatchMode.SELECT_SINGLE -> {
                if (chosenSub != null) {
                    val chosenSubOverrideNum = if (subtitleSwapPair != null && chosenSub.trackNumber == subtitleSwapPair.first) {
                        subtitleSwapPair.second
                    } else {
                        null
                    }
                    val subPayload = rewriteTrackEntryPayload(
                        rawPayload = chosenSub.rawPayloadBytes,
                        overrideTrackNumber = chosenSubOverrideNum,
                        explicitFlagEnabled = null,
                        explicitFlagDefault = true,
                        explicitFlagForced = true,
                        neutralizeLanguage = false,
                        stripName = compactLevel >= 2,
                        stripBcp47 = compactLevel >= 1,
                        compactTrackUid = compactLevel >= 1
                    )
                    list.add(TrackEntrySpec(subPayload, isRawEntry = false))

                    for (sub in info.subtitleTracks) {
                        if (sub === chosenSub) continue
                        val otherSubOverrideNum = if (subtitleSwapPair != null && sub.trackNumber == subtitleSwapPair.second) {
                            subtitleSwapPair.first
                        } else {
                            null
                        }
                        val otherSubPayload = rewriteTrackEntryPayload(
                            rawPayload = sub.rawPayloadBytes,
                            overrideTrackNumber = otherSubOverrideNum,
                            explicitFlagEnabled = if (compactLevel <= 1) false else null,
                            explicitFlagDefault = false,
                            explicitFlagForced = null,
                            neutralizeLanguage = true,
                            stripName = true,
                            stripBcp47 = true,
                            compactTrackUid = true
                        )
                        list.add(TrackEntrySpec(otherSubPayload, isRawEntry = false))
                    }
                } else {
                    for (sub in info.subtitleTracks) {
                        list.add(TrackEntrySpec(sub.rawEntryBytes, isRawEntry = true))
                    }
                }
            }
        }

        // 4. Any non-AV/Sub track entries preserved verbatim
        for (other in info.otherTrackEntries) {
            list.add(TrackEntrySpec(other, isRawEntry = true))
        }

        return list
    }

    /**
     * Rewrites the inner children of a single `<TrackEntry>` (`rawPayload`), preserving all codec/timing/audio/video
     * children byte-for-byte while normalizing `TrackNumber`, `FlagEnabled`, `FlagDefault`, `FlagForced`, `CRC-32`, and `Language`.
     */
    private fun rewriteTrackEntryPayload(
        rawPayload: ByteArray,
        overrideTrackNumber: Int? = null,
        explicitFlagEnabled: Boolean? = null,
        explicitFlagDefault: Boolean?,
        explicitFlagForced: Boolean?,
        neutralizeLanguage: Boolean,
        stripName: Boolean,
        stripBcp47: Boolean = false,
        compactTrackUid: Boolean = false
    ): ByteArray {
        val out = ByteArrayOutputStream(rawPayload.size + 8)
        var flagsEmitted = false
        var effectiveTrackNum = overrideTrackNumber ?: 0
        var pos = 0
        val limit = rawPayload.size

        fun emitFlagsIfPending() {
            if (flagsEmitted) return
            flagsEmitted = true
            if (explicitFlagEnabled == false) {
                out.write(FLAG_ENABLED_FALSE_BYTES)
            }
            when (explicitFlagDefault) {
                true -> out.write(FLAG_DEFAULT_TRUE_BYTES)
                false -> out.write(FLAG_DEFAULT_FALSE_BYTES)
                null -> {} // omitted => RFC 9559 default FlagDefault = 1
            }
            if (explicitFlagForced == true) {
                out.write(FLAG_FORCED_TRUE_BYTES)
            }
        }

        while (pos < limit) {
            val elId = readElementId(rawPayload, pos, limit)
            val sizePos = if (elId != null) pos + elId.byteLength else -1
            val elSize = if (elId != null) readDataSize(rawPayload, sizePos, limit) else null
            if (elId == null || elSize == null || elSize.value < 0) {
                // Defensive copy of any trailing bytes if malformed
                emitFlagsIfPending()
                out.write(rawPayload, pos, limit - pos)
                break
            }

            val valStart = sizePos + elSize.byteLength
            val valEndLong = valStart.toLong() + elSize.value
            if (valEndLong > limit || valEndLong <= pos) {
                emitFlagsIfPending()
                out.write(rawPayload, pos, limit - pos)
                break
            }
            val valEnd = valEndLong.toInt()

            when (elId.value) {
                ID_CRC32,
                ID_VOID,
                ID_FLAG_DEFAULT,
                ID_FLAG_FORCED -> {
                    // Stripped / replaced by canonical flags emitted right after TrackType
                }
                ID_FLAG_ENABLED -> {
                    // Stripped / replaced by explicitFlagEnabled (or omitted => RFC 9559 default FlagEnabled = 1)
                }
                ID_TRACK_NUMBER -> {
                    if (effectiveTrackNum <= 0 && elSize.value in 1..4) {
                        effectiveTrackNum = readUnsignedInt(rawPayload, valStart, elSize.value.toInt()).toInt()
                    }
                    if (overrideTrackNumber != null && overrideTrackNumber in 1..255) {
                        out.write(ID_TRACK_NUMBER.toInt())
                        out.write(0x81)
                        out.write(overrideTrackNumber and 0xFF)
                    } else {
                        out.write(rawPayload, pos, valEnd - pos)
                    }
                }
                ID_TRACK_UID -> {
                    if (compactTrackUid && elSize.value > 1L) {
                        val uidByte = if (effectiveTrackNum in 1..255) {
                            effectiveTrackNum and 0xFF
                        } else {
                            (rawPayload[valEnd - 1].toInt() and 0x7F).let { if (it == 0) 1 else it }
                        }
                        out.write(0x73)
                        out.write(0xC5)
                        out.write(0x81)
                        out.write(uidByte)
                    } else {
                        out.write(rawPayload, pos, valEnd - pos)
                    }
                }
                ID_LANGUAGE -> {
                    if (!neutralizeLanguage) {
                        out.write(rawPayload, pos, valEnd - pos)
                    }
                }
                ID_LANGUAGE_BCP47 -> {
                    if (!neutralizeLanguage && !stripBcp47) {
                        out.write(rawPayload, pos, valEnd - pos)
                    }
                }
                ID_NAME -> {
                    if (!stripName) {
                        out.write(rawPayload, pos, valEnd - pos)
                    }
                }
                ID_TRACK_TYPE -> {
                    out.write(rawPayload, pos, valEnd - pos)
                    emitFlagsIfPending()
                }
                else -> {
                    out.write(rawPayload, pos, valEnd - pos)
                }
            }

            pos = valEnd
        }

        emitFlagsIfPending()
        return out.toByteArray()
    }

    /**
     * Wraps [entryPayloadsAndRaw] inside `<Tracks>` (`0x1654AE6B`) so the returned `ByteArray` has
     * EXACT length [totalTargetBytes], or returns `null` if the children exceed [totalTargetBytes].
     */
    private fun tryAssembleTracksWithExactTotalSize(
        entryPayloadsAndRaw: List<TrackEntrySpec>,
        totalTargetBytes: Int,
        origTracksSizeVintLen: Int
    ): ByteArray? {
        // Compute minimum byte size of all serialized <TrackEntry> elements
        var baseChildrenLen = 0
        var firstRebuiltSpecIdx = -1
        for ((idx, spec) in entryPayloadsAndRaw.withIndex()) {
            if (spec.isRawEntry) {
                baseChildrenLen += spec.bytes.size
            } else {
                if (firstRebuiltSpecIdx == -1) firstRebuiltSpecIdx = idx
                val minWidth = minVintWidthForSize(spec.bytes.size)
                baseChildrenLen += 1 + minWidth + spec.bytes.size
            }
        }

        val origPayloadCapacity = totalTargetBytes - 4 - origTracksSizeVintLen
        if (baseChildrenLen > origPayloadCapacity) {
            return null
        }

        var slack = origPayloadCapacity - baseChildrenLen
        var effectiveTracksSizeVintLen = origTracksSizeVintLen
        var widenFirstRebuiltEntryByOne = false

        // EBML <Void> requires >= 2 bytes, so if slack == 1 we absorb that exact 1 byte via non-shortest VINT Data Size
        if (slack == 1) {
            if (origTracksSizeVintLen < 8 && canEncodeVintSizeInWidth(baseChildrenLen, origTracksSizeVintLen + 1)) {
                effectiveTracksSizeVintLen = origTracksSizeVintLen + 1
                slack = 0
            } else if (firstRebuiltSpecIdx >= 0) {
                val payloadLen = entryPayloadsAndRaw[firstRebuiltSpecIdx].bytes.size
                val minW = minVintWidthForSize(payloadLen)
                if (minW < 8 && canEncodeVintSizeInWidth(payloadLen, minW + 1)) {
                    widenFirstRebuiltEntryByOne = true
                    slack = 0
                } else {
                    return null
                }
            } else {
                return null
            }
        }

        val finalTracksPayloadSize = totalTargetBytes - 4 - effectiveTracksSizeVintLen
        if (!canEncodeVintSizeInWidth(finalTracksPayloadSize, effectiveTracksSizeVintLen)) {
            return null
        }

        val out = ByteArrayOutputStream(totalTargetBytes)
        out.write(TRACKS_ID_BYTES)
        out.write(encodeVintSizeWithExactWidth(finalTracksPayloadSize, effectiveTracksSizeVintLen))

        for ((idx, spec) in entryPayloadsAndRaw.withIndex()) {
            if (spec.isRawEntry) {
                out.write(spec.bytes)
            } else {
                val payloadLen = spec.bytes.size
                val minW = minVintWidthForSize(payloadLen)
                val w = if (widenFirstRebuiltEntryByOne && idx == firstRebuiltSpecIdx) minW + 1 else minW
                out.write(ID_TRACK_ENTRY.toInt())
                out.write(encodeVintSizeWithExactWidth(payloadLen, w))
                out.write(spec.bytes)
            }
        }

        if (slack >= 2) {
            out.write(buildEbmlVoidOfExactSize(slack))
        }

        val result = out.toByteArray()
        return if (result.size == totalTargetBytes) result else null
    }

    /**
     * Builds a valid RFC 8794 EBML `<Void>` (`0xEC`) element of ANY exact byte length `totalBytes >= 2`
     * (including boundary sizes like `2`, `128`, `129`, `130`, `16385`, `16386`, etc.).
     */
    internal fun buildEbmlVoidOfExactSize(totalBytes: Int): ByteArray {
        require(totalBytes >= 2) { "EBML <Void> requires at least 2 bytes, got $totalBytes" }
        val vintWidth = when {
            totalBytes <= 128 -> 1        // payload 0..126
            totalBytes <= 16385 -> 2      // payload 126..16382 (covers 129 via 2-byte VINT size=126!)
            totalBytes <= 2097153 -> 3    // payload 16382..2097149
            else -> 4                     // payload up to 268 MB
        }
        val payloadLen = totalBytes - 1 - vintWidth
        val out = ByteArray(totalBytes)
        out[0] = ID_VOID.toByte()
        val sizeBytes = encodeVintSizeWithExactWidth(payloadLen, vintWidth)
        System.arraycopy(sizeBytes, 0, out, 1, vintWidth)
        return out
    }

    private fun minVintWidthForSize(size: Int): Int {
        require(size >= 0)
        for (w in 1..8) {
            if (canEncodeVintSizeInWidth(size, w)) return w
        }
        return 8
    }

    private fun canEncodeVintSizeInWidth(size: Int, width: Int): Boolean {
        if (size < 0 || width !in 1..8) return false
        if (width == 8) return true
        // All-1s payload ((1L shl (7 * width)) - 1) is reserved for UNKNOWN_SIZE in EBML
        val maxVal = (1L shl (7 * width)) - 2L
        return size.toLong() <= maxVal
    }

    private fun encodeVintSizeWithExactWidth(size: Int, width: Int): ByteArray {
        require(canEncodeVintSizeInWidth(size, width)) { "Cannot encode VINT size=$size in width=$width" }
        val out = ByteArray(width)
        val v = size.toLong()
        val marker = 1L shl (8 - width)
        val firstByteMask = marker - 1L
        val topShift = 8 * (width - 1)
        out[0] = (marker or ((v shr topShift) and firstByteMask)).toByte()
        for (i in 1 until width) {
            val shift = 8 * (width - 1 - i)
            out[i] = ((v shr shift) and 0xFFL).toByte()
        }
        return out
    }

    private fun hasEbmlMagic(buf: ByteArray): Boolean {
        return buf.size >= 4 &&
            buf[0] == 0x1A.toByte() &&
            buf[1] == 0x45.toByte() &&
            buf[2] == 0xDF.toByte() &&
            buf[3] == 0xA3.toByte()
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

    /**
     * Stateful, zero-size-change `<Cluster>` (`0x1F43B675`) & `<Cues>` (`0x1C53BB6B`) stream filter that swaps the
     * 1-byte EBML `TrackNumber` VINT (`0x81..0xFE`) at the start of `<SimpleBlock>` (`0xA3`) and `<Block>` (`0xA1`)
     * payloads (as well as 1-byte `<CueTrack>` (`0xF7`) entries inside `<Cues>`) between [trackA] and [trackB]
     * (and optional [subTrackA] and [subTrackB]), and neutralizes `<CRC-32>` (`0xBF -> 0xEC` `<Void>`).
     *
     * Handles:
     *  - Sequential HTTP chunk streaming with 16-byte seam stitching when a block header straddles two chunks.
     *  - Straddling block payloads whose body extends across one or more chunks (`knownBoundaries`).
     *  - Arbitrary mid-movie HTTP `Range:` seeks via verified `<Cluster>` (`0x1F 0x43 0xB6 0x75`) or `<Cues>` (`0x1C 0x53 0xBB 0x6B`) sync.
     */
    class ClusterBlockSwapper(
        val tracksElementEnd: Long,
        val firstClusterOffset: Long,
        val trackA: Int,
        val trackB: Int,
        val subTrackA: Int = -1,
        val subTrackB: Int = -1
    ) {
        private val hasAudioSwap: Boolean = trackA in 1..126 && trackB in 1..126 && trackA != trackB
        private val hasSubSwap: Boolean = subTrackA in 1..126 && subTrackB in 1..126 && subTrackA != subTrackB
        private val vintTrackA: Byte = (0x80 or (trackA and 0x7F)).toByte()
        private val vintTrackB: Byte = (0x80 or (trackB and 0x7F)).toByte()
        private val vintSubTrackA: Byte = (0x80 or (subTrackA and 0x7F)).toByte()
        private val vintSubTrackB: Byte = (0x80 or (subTrackB and 0x7F)).toByte()
        private val rawTrackA: Byte = (trackA and 0x7F).toByte()
        private val rawTrackB: Byte = (trackB and 0x7F).toByte()
        private val rawSubTrackA: Byte = (subTrackA and 0x7F).toByte()
        private val rawSubTrackB: Byte = (subTrackB and 0x7F).toByte()

        private val knownBoundaries = java.util.concurrent.ConcurrentSkipListSet<Long>()
        private val seamLock = Any()
        private var seamChunkEndOffset: Long = -1L
        private var seamElementGlobalStart: Long = -1L
        private var seamTailBytes: ByteArray = ByteArray(0)

        init {
            if (tracksElementEnd > 0L) {
                knownBoundaries.add(tracksElementEnd)
            }
            if (firstClusterOffset > 0L) {
                knownBoundaries.add(firstClusterOffset)
            }
        }

        private fun addBoundary(globalOffset: Long) {
            if (globalOffset <= tracksElementEnd) return
            if (knownBoundaries.size > 4096) {
                // Keep earliest head boundaries and recent boundaries
                val poll = knownBoundaries.pollFirst()
                if (poll != null && poll == tracksElementEnd) {
                    knownBoundaries.add(tracksElementEnd)
                }
            }
            knownBoundaries.add(globalOffset)
        }

        /**
         * Returns a patched copy of `sourceBuffer[sliceOffset until sliceOffset + sliceLength]` with
         * `TrackNumber`s [trackA] <-> [trackB] (and optional [subTrackA] <-> [subTrackB]) swapped inside
         * `<Cluster>` blocks and `<Cues>` `<CueTrack>` entries, or `null` if no bytes in this slice required modification.
         * Never mutates [sourceBuffer].
         */
        fun patchSliceIfNeeded(
            sourceBuffer: ByteArray,
            sliceOffset: Int,
            sliceLength: Int,
            rangeGlobalStart: Long
        ): ByteArray? {
            if (sliceLength <= 0 || (!hasAudioSwap && !hasSubSwap)) return null
            val sliceGlobalEnd = rangeGlobalStart + sliceLength
            if (sliceGlobalEnd <= tracksElementEnd) return null

            var mutated: ByteArray? = null
            fun writableBuffer(): ByteArray {
                var m = mutated
                if (m == null) {
                    m = sourceBuffer.copyOfRange(sliceOffset, sliceOffset + sliceLength)
                    mutated = m
                }
                return m
            }

            // 1. Check if the previous consecutive HTTP chunk ended mid-header across the seam
            synchronized(seamLock) {
                if (seamChunkEndOffset == rangeGlobalStart &&
                    seamElementGlobalStart in (rangeGlobalStart - 16L) until rangeGlobalStart &&
                    seamTailBytes.isNotEmpty()
                ) {
                    val tailLen = seamTailBytes.size
                    val headTake = minOf(16, sliceLength)
                    val seamBuf = ByteArray(tailLen + headTake)
                    System.arraycopy(seamTailBytes, 0, seamBuf, 0, tailLen)
                    System.arraycopy(sourceBuffer, sliceOffset, seamBuf, tailLen, headTake)

                    val elId = readElementId(seamBuf, 0, seamBuf.size)
                    val sizePos = if (elId != null) elId.byteLength else -1
                    val elSize = if (elId != null) readDataSize(seamBuf, sizePos, seamBuf.size) else null

                    if (elId != null && elSize != null) {
                        val headerLen = elId.byteLength + elSize.byteLength
                        val payloadGlobalStart = seamElementGlobalStart + headerLen
                        when {
                            elId.value == ID_CLUSTER ||
                                elId.value == ID_CUES ||
                                (elId.value == ID_BLOCK_GROUP && elId.byteLength == 1) ||
                                (elId.value == ID_CUE_POINT && elId.byteLength == 1) ||
                                (elId.value == ID_CUE_TRACK_POSITIONS && elId.byteLength == 1) -> {
                                addBoundary(payloadGlobalStart)
                            }
                            (elId.value == ID_SIMPLE_BLOCK || elId.value == ID_BLOCK) &&
                                elId.byteLength == 1 && elSize.value >= 4L -> {
                                if (payloadGlobalStart >= rangeGlobalStart && payloadGlobalStart < sliceGlobalEnd) {
                                    val localTrackIdx = (payloadGlobalStart - rangeGlobalStart).toInt()
                                    val b = sourceBuffer[sliceOffset + localTrackIdx]
                                    if (hasAudioSwap && b == vintTrackA) {
                                        writableBuffer()[localTrackIdx] = vintTrackB
                                    } else if (hasAudioSwap && b == vintTrackB) {
                                        writableBuffer()[localTrackIdx] = vintTrackA
                                    } else if (hasSubSwap && b == vintSubTrackA) {
                                        writableBuffer()[localTrackIdx] = vintSubTrackB
                                    } else if (hasSubSwap && b == vintSubTrackB) {
                                        writableBuffer()[localTrackIdx] = vintSubTrackA
                                    }
                                }
                                addBoundary(payloadGlobalStart + elSize.value)
                            }
                            elId.value == ID_CUE_TRACK && elId.byteLength == 1 && elSize.value == 1L -> {
                                if (payloadGlobalStart >= rangeGlobalStart && payloadGlobalStart < sliceGlobalEnd) {
                                    val localTrackIdx = (payloadGlobalStart - rangeGlobalStart).toInt()
                                    val b = sourceBuffer[sliceOffset + localTrackIdx]
                                    if (hasAudioSwap && b == rawTrackA) {
                                        writableBuffer()[localTrackIdx] = rawTrackB
                                    } else if (hasAudioSwap && b == rawTrackB) {
                                        writableBuffer()[localTrackIdx] = rawTrackA
                                    } else if (hasSubSwap && b == rawSubTrackA) {
                                        writableBuffer()[localTrackIdx] = rawSubTrackB
                                    } else if (hasSubSwap && b == rawSubTrackB) {
                                        writableBuffer()[localTrackIdx] = rawSubTrackA
                                    }
                                }
                                addBoundary(payloadGlobalStart + elSize.value)
                            }
                            elSize.value >= 0L -> {
                                addBoundary(payloadGlobalStart + elSize.value)
                            }
                        }
                    }
                    seamChunkEndOffset = -1L
                    seamElementGlobalStart = -1L
                    seamTailBytes = ByteArray(0)
                }
            }

            // 2. Locate first known element boundary inside this slice, or scan for a <Cluster> / <Cues> magic header
            val effectiveStartGlobal = maxOf(rangeGlobalStart, tracksElementEnd)
            val knownStart = knownBoundaries.ceiling(effectiveStartGlobal)
            var localPos: Int = if (knownStart != null && knownStart < sliceGlobalEnd) {
                (knownStart - rangeGlobalStart).toInt()
            } else {
                val searchFrom = (effectiveStartGlobal - rangeGlobalStart).toInt().coerceAtLeast(0)
                findValidClusterOffset(sourceBuffer, sliceOffset, sliceLength, searchFrom)
            }

            if (localPos < 0 || localPos >= sliceLength) {
                return mutated
            }

            // 3. Step through EBML elements inside the slice
            while (localPos in 0 until sliceLength) {
                val bufPos = sliceOffset + localPos
                val bufLimit = sliceOffset + sliceLength
                val remaining = bufLimit - bufPos

                val elId = readElementId(sourceBuffer, bufPos, bufLimit)
                val sizePos = if (elId != null) bufPos + elId.byteLength else -1
                val elSize = if (elId != null && sizePos < bufLimit) readDataSize(sourceBuffer, sizePos, bufLimit) else null

                if (elId == null || elSize == null) {
                    if (remaining <= 14) {
                        synchronized(seamLock) {
                            seamChunkEndOffset = sliceGlobalEnd
                            seamElementGlobalStart = rangeGlobalStart + localPos
                            seamTailBytes = sourceBuffer.copyOfRange(bufPos, bufLimit)
                        }
                        break
                    }
                    val resynced = findValidClusterOffset(sourceBuffer, sliceOffset, sliceLength, localPos + 1)
                    if (resynced < 0) break
                    localPos = resynced
                    continue
                }

                val headerLen = elId.byteLength + elSize.byteLength
                val payloadLocalPos = localPos + headerLen
                val payloadGlobalPos = rangeGlobalStart + payloadLocalPos

                // Master elements whose children contain blocks or cue track positions: step inside!
                if (elId.value == ID_CLUSTER ||
                    elId.value == ID_CUES ||
                    (elId.value == ID_BLOCK_GROUP && elId.byteLength == 1) ||
                    (elId.value == ID_CUE_POINT && elId.byteLength == 1) ||
                    (elId.value == ID_CUE_TRACK_POSITIONS && elId.byteLength == 1)
                ) {
                    if (elId.value == ID_CLUSTER || elId.value == ID_CUES) {
                        addBoundary(rangeGlobalStart + localPos)
                        addBoundary(payloadGlobalPos)
                    } else if (elSize.value > 0L) {
                        val endOfMaster = payloadGlobalPos + elSize.value
                        if (endOfMaster >= sliceGlobalEnd) {
                            addBoundary(endOfMaster)
                        }
                    }
                    if (payloadGlobalPos >= sliceGlobalEnd) {
                        addBoundary(payloadGlobalPos)
                    }
                    localPos = payloadLocalPos
                    continue
                }

                if (elSize.value < 0L) {
                    val resynced = findValidClusterOffset(sourceBuffer, sliceOffset, sliceLength, localPos + 1)
                    if (resynced < 0) break
                    localPos = resynced
                    continue
                }

                // Neutralize <CRC-32> (0xBF -> 0xEC <Void>) inside <Cluster> / <BlockGroup> / <Cues>
                if (elId.value == ID_CRC32 && elId.byteLength == 1 && elSize.value == 4L) {
                    writableBuffer()[localPos] = ID_VOID.toByte()
                    val nextGlobal = payloadGlobalPos + 4L
                    if (nextGlobal >= sliceGlobalEnd) {
                        addBoundary(nextGlobal)
                        break
                    }
                    localPos = (nextGlobal - rangeGlobalStart).toInt()
                    continue
                }

                // <CueTrack> (0xF7) inside <CueTrackPositions>: 1-byte raw unsigned integer TrackNumber!
                if (elId.value == ID_CUE_TRACK && elId.byteLength == 1 && elSize.value == 1L) {
                    if (payloadLocalPos >= sliceLength) {
                        synchronized(seamLock) {
                            seamChunkEndOffset = sliceGlobalEnd
                            seamElementGlobalStart = rangeGlobalStart + localPos
                            seamTailBytes = sourceBuffer.copyOfRange(bufPos, bufLimit)
                        }
                        break
                    }
                    val trackByte = sourceBuffer[sliceOffset + payloadLocalPos]
                    if (hasAudioSwap && trackByte == rawTrackA) {
                        writableBuffer()[payloadLocalPos] = rawTrackB
                    } else if (hasAudioSwap && trackByte == rawTrackB) {
                        writableBuffer()[payloadLocalPos] = rawTrackA
                    } else if (hasSubSwap && trackByte == rawSubTrackA) {
                        writableBuffer()[payloadLocalPos] = rawSubTrackB
                    } else if (hasSubSwap && trackByte == rawSubTrackB) {
                        writableBuffer()[payloadLocalPos] = rawSubTrackA
                    }
                    val nextGlobal = payloadGlobalPos + 1L
                    if (nextGlobal >= sliceGlobalEnd) {
                        addBoundary(nextGlobal)
                        break
                    }
                    localPos = (nextGlobal - rangeGlobalStart).toInt()
                    continue
                }

                // <SimpleBlock> (0xA3) or <Block> (0xA1): first payload byte is TrackNumber VINT!
                if ((elId.value == ID_SIMPLE_BLOCK || elId.value == ID_BLOCK) &&
                    elId.byteLength == 1 &&
                    elSize.value >= 4L
                ) {
                    if (payloadLocalPos >= sliceLength) {
                        // Header ended right at slice boundary before the TrackNumber byte; stitch on next chunk!
                        synchronized(seamLock) {
                            seamChunkEndOffset = sliceGlobalEnd
                            seamElementGlobalStart = rangeGlobalStart + localPos
                            seamTailBytes = sourceBuffer.copyOfRange(bufPos, bufLimit)
                        }
                        break
                    }
                    val trackByte = sourceBuffer[sliceOffset + payloadLocalPos]
                    if (hasAudioSwap && trackByte == vintTrackA) {
                        writableBuffer()[payloadLocalPos] = vintTrackB
                    } else if (hasAudioSwap && trackByte == vintTrackB) {
                        writableBuffer()[payloadLocalPos] = vintTrackA
                    } else if (hasSubSwap && trackByte == vintSubTrackA) {
                        writableBuffer()[payloadLocalPos] = vintSubTrackB
                    } else if (hasSubSwap && trackByte == vintSubTrackB) {
                        writableBuffer()[payloadLocalPos] = vintSubTrackA
                    }
                    val nextGlobal = payloadGlobalPos + elSize.value
                    if (nextGlobal >= sliceGlobalEnd) {
                        addBoundary(nextGlobal)
                        break
                    }
                    localPos = (nextGlobal - rangeGlobalStart).toInt()
                    continue
                }

                // Any other element (Timecode 0xE7, PrevSize 0xAB, Position 0xA7, CueTime 0xB3, Void 0xEC, etc.)
                val nextGlobal = payloadGlobalPos + elSize.value
                if (nextGlobal <= rangeGlobalStart + localPos) {
                    val resynced = findValidClusterOffset(sourceBuffer, sliceOffset, sliceLength, localPos + 1)
                    if (resynced < 0) break
                    localPos = resynced
                    continue
                }
                if (nextGlobal >= sliceGlobalEnd) {
                    addBoundary(nextGlobal)
                    break
                }
                localPos = (nextGlobal - rangeGlobalStart).toInt()
            }

            return mutated
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
                } else if (buf[i] == 0x1C.toByte() &&
                    buf[i + 1] == 0x53.toByte() &&
                    buf[i + 2] == 0xBB.toByte() &&
                    buf[i + 3] == 0x6B.toByte()
                ) {
                    val cuesSize = readDataSize(buf, i + 4, endLimit)
                    if (cuesSize != null && cuesSize.value > 4L) {
                        val firstChildPos = i + 4 + cuesSize.byteLength
                        if (firstChildPos + 2 < endLimit) {
                            val childId = readElementId(buf, firstChildPos, endLimit)
                            if (childId != null && (childId.value == ID_CUE_POINT || childId.value == ID_CRC32 || childId.value == ID_VOID)) {
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
    }
}
