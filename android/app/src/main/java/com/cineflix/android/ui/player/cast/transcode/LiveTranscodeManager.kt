package com.cineflix.android.ui.player.cast.transcode

import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaCodecList
import android.media.MediaFormat
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.media3.common.C
import androidx.media3.common.DataReader
import androidx.media3.common.Format
import androidx.media3.common.MimeTypes
import androidx.media3.common.text.Cue
import androidx.media3.common.util.MediaFormatUtil
import androidx.media3.common.util.ParsableByteArray
import androidx.media3.datasource.BaseDataSource
import androidx.media3.datasource.DataSpec
import androidx.media3.extractor.DefaultExtractorInput
import androidx.media3.extractor.DefaultExtractorsFactory
import androidx.media3.extractor.Extractor
import androidx.media3.extractor.ExtractorOutput
import androidx.media3.extractor.PositionHolder
import androidx.media3.extractor.SeekMap
import androidx.media3.extractor.TrackOutput
import androidx.media3.extractor.text.CueDecoder
import androidx.media3.extractor.text.CuesWithTiming
import com.cineflix.android.ui.player.cast.MatroskaEbmlTrackPatcher
import io.github.anilbeesetti.nextlib.media3ext.ffdecoder.CineflixFfmpegAudioDecoder
import io.github.anilbeesetti.nextlib.media3ext.ffdecoder.CineflixFfmpegVideoDecoder
import java.io.EOFException
import java.io.IOException
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets
import java.util.ArrayDeque
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * Manages real-time on-phone chunk decoding & `MPEG-TS` (`H.264 <= 1080p + Stereo AAC-LC`) live
 * transcoding sessions streamed over HTTP from `LocalStreamServer` to any UPnP/DLNA Smart TV or Cast device.
 *
 * Highlights:
 *  - **Probe-tolerant shared session buffer**: Smart TVs (Samsung Orsay `UE40F6400`, Samsung Tizen `S95B`,
 *    LG webOS, Sony) frequently perform a short `GET` probe (`32-128 KB`) to inspect the MPEG-TS `PAT`/`PMT`
 *    and first `SPS/PPS/IDR` frame, close that socket, and immediately open a second `GET` socket for playback.
 *    [LiveTranscodeSession] caches the initial `2 MB` TS prefix and keeps the hardware transcoder hot across
 *    the probe->play transition so the second `GET` starts in `0ms` without re-initializing `MediaCodec`!
 *  - **Bounded `6 MB` backpressure**: Automatically paces hardware VPU + FFmpeg decoding to the TV's real-time
 *    playback rate (and sleeps at 0% CPU/GPU while the user pauses the TV!).
 *  - **Smart Video Fast-Path**: Uses 0-GPU Annex-B passthrough when source video is already 8-bit `H.264 <= 1080p`
 *    and no subtitles need burning; engages Hardware `MediaCodec` + OpenGL ES [EglTranscodeSurface] (with FFmpeg
 *    software video decoder fallback) whenever source is `HEVC/H.265`, `4K`, `10-bit`, `AV1`, `VP9`, or when
 *    live GPU subtitle burn-in (`SRT`, `ASS`/`SSA`, `WebVTT`, `PGS`) is active.
 *  - **Universal Audio**: Decodes `DTS`, `DTS-HD`, `TrueHD`, `E-AC3`, `AC3`, `FLAC`, `Opus`, `Vorbis`, `AAC`, `MP3`
 *    on the phone via bundled FFmpeg ([CineflixFfmpegAudioDecoder], with `MediaCodec` fallback), downmixes 5.1/7.1
 *    with dialogue-boosted soft-knee protection via [PcmStereoProcessor], and encodes universal ADTS `AAC-LC`.
 */
class LiveTranscodeManager(
    private val totalLogicalSizeProvider: () -> Long,
    private val directByteReader: (logicalOffset: Long, dst: ByteArray, dstOffset: Int, length: Int, isCancelled: () -> Boolean) -> Int,
    private val onDurationDiscovered: ((Long) -> Unit)? = null
) {

    companion object {
        private const val TAG = "LiveTranscodeManager"

        private const val PREFIX_PIN_BYTES = 4 * 1024 * 1024       // 4 MB pinned head for 0ms TV probe -> play handoff
        private const val MAX_BACKPRESSURE_AHEAD_BYTES = 6L * 1024L * 1024L // Pause transcoder when 6 MB ahead of TV
        private const val SLIDING_RETENTION_BYTES = 8L * 1024L * 1024L      // Retain 8 MB rolling history
        private const val IDLE_SESSION_TTL_MS = 18_000L            // Auto-release if no TV socket attached for 18s

        private const val DEFAULT_AAC_BITRATE = 192_000
        private const val DEFAULT_H264_1080P_BITRATE = 3_800_000
        private const val DEFAULT_H264_720P_BITRATE = 2_800_000

        /**
         * Largest 188-byte aligned MPEG-TS byte size that fits in a signed 32-bit integer (`<= INT32_MAX`),
         * preventing 32-bit signed integer clamping/overflow on legacy 2010-2014 Smart TVs (Samsung Orsay).
         */
        const val MAX_SAFE_32BIT_TS_SIZE_BYTES = 2_147_483_392L // 11,422,784 * 188 bytes

        fun computeTargetVideoBitrateBps(durationHintMs: Long, is1080p: Boolean = true): Int {
            val defaultRate = if (is1080p) DEFAULT_H264_1080P_BITRATE else DEFAULT_H264_720P_BITRATE
            if (durationHintMs <= 0L) return defaultRate
            val durationSec = (durationHintMs / 1000L).coerceAtLeast(60L)
            // Size target bitrate so the full movie fits within ~1.98 GB (< INT32_MAX) with 13% TS mux overhead
            val maxTotalBytesPerSec = (1_980_000_000L / durationSec).coerceAtLeast(250_000L)
            val maxElemBitsPerSec = ((maxTotalBytesPerSec.toDouble() / 1.13) * 8.0).toLong()
            val maxVideoBps = (maxElemBitsPerSec - DEFAULT_AAC_BITRATE).toInt()
            val minFloor = if (is1080p) 1_950_000 else 1_400_000
            return maxVideoBps.coerceIn(minFloor, defaultRate)
        }

        fun computeVirtualLiveTsSizeBytes(remainingDurationMs: Long, is1080p: Boolean = true): Long {
            if (remainingDurationMs <= 0L) return MAX_SAFE_32BIT_TS_SIZE_BYTES
            val remSec = (remainingDurationMs / 1000.0).coerceAtLeast(30.0)
            val videoBps = computeTargetVideoBitrateBps(remainingDurationMs, is1080p)
            val expectedBytesPerSec = ((videoBps + DEFAULT_AAC_BITRATE) / 8.0) * 1.13
            val rawBytes = (remSec * expectedBytesPerSec).toLong()
            val clamped = rawBytes.coerceIn(16L * 1024L * 1024L, MAX_SAFE_32BIT_TS_SIZE_BYTES)
            return (clamped / MpegTsMuxer.TS_PACKET_SIZE) * MpegTsMuxer.TS_PACKET_SIZE
        }
    }

    data class SessionSpec(
        val startPositionMs: Long,
        val audioOrdinal: Int?,
        val audioTrackNumber: Int?,
        val subtitleMode: MatroskaEbmlTrackPatcher.SubtitlePatchMode,
        val subtitleOrdinal: Int?,
        val subtitleTrackNumber: Int?,
        val forceVideoTranscode: Boolean,
        val baseByteOffset: Long = 0L,
        val tsPtsOffsetMs: Long = 0L,
        val durationHintMs: Long = 0L
    )

    private val sessionLock = Any()
    private var activeSession: LiveTranscodeSession? = null

    /**
     * Pre-warms or retrieves the live transcode session matching [spec] and streams `188`-byte
     * `MPEG-TS` bytes starting at [requestedStartByte] to [clientOut] until EOF or client disconnect.
     */
    fun streamToHttpClient(
        spec: SessionSpec,
        requestedStartByte: Long,
        requestedMaxBytes: Long?,
        clientOut: OutputStream
    ) {
        val session = getOrStartSession(spec)
        session.streamToClient(
            startByteOffset = requestedStartByte.coerceAtLeast(0L),
            maxBytesToDeliver = requestedMaxBytes,
            out = clientOut
        )
    }

    fun getActiveSession(): LiveTranscodeSession? = synchronized(sessionLock) {
        activeSession?.takeIf { !it.isStopped() }
    }

    fun getOrStartSession(spec: SessionSpec): LiveTranscodeSession {
        synchronized(sessionLock) {
            val current = activeSession
            if (current != null && !current.isStopped() && current.matchesReusableSpec(spec)) {
                current.touchActivity()
                return current
            }
            current?.stop()
            val created = LiveTranscodeSession(
                spec = spec,
                totalSizeProvider = totalLogicalSizeProvider,
                directByteReader = directByteReader,
                onDurationDiscovered = onDurationDiscovered
            )
            activeSession = created
            created.start()
            return created
        }
    }

    fun stopActiveSession() {
        val toStop: LiveTranscodeSession?
        synchronized(sessionLock) {
            toStop = activeSession
            activeSession = null
        }
        toStop?.stop()
    }
}

/**
 * Single live transcode worker + probe-tolerant bounded rolling stream buffer.
 */
class LiveTranscodeSession(
    val spec: LiveTranscodeManager.SessionSpec,
    private val totalSizeProvider: () -> Long,
    private val directByteReader: (logicalOffset: Long, dst: ByteArray, dstOffset: Int, length: Int, isCancelled: () -> Boolean) -> Int,
    private val onDurationDiscovered: ((Long) -> Unit)? = null
) {

    companion object {
        private const val TAG = "LiveTranscodeSession"
        private const val PREFIX_PIN_BYTES = 4 * 1024 * 1024
        private const val MAX_AHEAD_BYTES = 6L * 1024L * 1024L
        private const val RETAIN_HISTORY_BYTES = 8L * 1024L * 1024L
        private const val IDLE_NO_CLIENT_TIMEOUT_MS = 18_000L

        private const val TARGET_AAC_BITRATE = 192_000
        private const val TARGET_H264_1080P_BITRATE = 3_800_000
        private const val TARGET_H264_720P_BITRATE = 2_800_000
        private const val H264_IFRAME_INTERVAL_SEC = 2
    }

    private class TsChunk(
        val startOffset: Long,
        val bytes: ByteArray
    ) {
        val endOffsetExclusive: Long get() = startOffset + bytes.size
    }

    val baseByteOffset: Long =
        (spec.baseByteOffset.coerceAtLeast(0L) / MpegTsMuxer.TS_PACKET_SIZE) * MpegTsMuxer.TS_PACKET_SIZE

    private val bufferLock = Object()
    private val prefixChunks = ArrayList<TsChunk>()
    private var prefixPinnedBytes = 0
    private val rollingChunks = ArrayDeque<TsChunk>()

    private var totalProducedBytes = baseByteOffset
    private var activeConsumerOffset = baseByteOffset
    private var producerFinishedEof = false
    private var producerFatalError: Throwable? = null

    private val cancelled = AtomicBoolean(false)
    private val activeClientCount = AtomicInteger(0)
    private val clientGeneration = AtomicLong(0L)
    private val lastClientActivityMs = AtomicLong(System.currentTimeMillis())

    private var workerThread: Thread? = null

    fun getProducedStreamRange(): Pair<Long, Long> = synchronized(bufferLock) {
        Pair(baseByteOffset, totalProducedBytes)
    }

    fun matchesReusableSpec(other: LiveTranscodeManager.SessionSpec): Boolean {
        val otherAlignedBase =
            (other.baseByteOffset.coerceAtLeast(0L) / MpegTsMuxer.TS_PACKET_SIZE) * MpegTsMuxer.TS_PACKET_SIZE
        return abs(spec.startPositionMs - other.startPositionMs) <= 1500L &&
            abs(baseByteOffset - otherAlignedBase) <= 4L * 1024L * 1024L &&
            spec.audioOrdinal == other.audioOrdinal &&
            spec.audioTrackNumber == other.audioTrackNumber &&
            spec.subtitleMode == other.subtitleMode &&
            spec.subtitleOrdinal == other.subtitleOrdinal &&
            spec.subtitleTrackNumber == other.subtitleTrackNumber &&
            (!other.forceVideoTranscode || spec.forceVideoTranscode)
    }

    fun isStopped(): Boolean = cancelled.get()

    fun touchActivity() {
        lastClientActivityMs.set(System.currentTimeMillis())
    }

    fun start() {
        touchActivity()
        val t = Thread({
            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_DISPLAY)
            try {
                runTranscodePipeline()
            } catch (t: Throwable) {
                if (!cancelled.get()) {
                    Log.e(TAG, "❌ Live transcode pipeline error: ${t.message}", t)
                    synchronized(bufferLock) {
                        producerFatalError = t
                        bufferLock.notifyAll()
                    }
                }
            } finally {
                synchronized(bufferLock) {
                    producerFinishedEof = true
                    bufferLock.notifyAll()
                }
            }
        }, "CineflixLiveTranscoder")
        workerThread = t
        t.start()
    }

    fun stop() {
        if (!cancelled.compareAndSet(false, true)) return
        synchronized(bufferLock) {
            bufferLock.notifyAll()
        }
        workerThread?.interrupt()
    }

    fun getFatalError(): Throwable? = synchronized(bufferLock) { producerFatalError }

    /**
     * Waits up to [timeoutMs] until the transcoder has muxed at least [minBytes] of valid `0x47`
     * `MPEG-TS` packets (`PAT + PMT + IDR Keyframe + Audio`) into RAM, so `LocalStreamServer`
     * never sends an `HTTP 200 OK` header before verifying the pipeline is producing live media.
     */
    fun awaitInitialBytes(
        minBytes: Long = MpegTsMuxer.TS_PACKET_SIZE * 20L,
        timeoutMs: Long = 15_000L
    ): Boolean {
        touchActivity()
        val deadline = System.currentTimeMillis() + timeoutMs
        synchronized(bufferLock) {
            while (!cancelled.get()) {
                val producedDelta = totalProducedBytes - baseByteOffset
                if (producedDelta >= minBytes) {
                    return true
                }
                if (producerFinishedEof) {
                    return producedDelta > 0L && producerFatalError == null
                }
                val rem = deadline - System.currentTimeMillis()
                if (rem <= 0L) {
                    return producedDelta > 0L
                }
                try {
                    bufferLock.wait(min(250L, rem))
                } catch (_: InterruptedException) {
                    Thread.currentThread().interrupt()
                    return (totalProducedBytes - baseByteOffset) > 0L
                }
            }
            return (totalProducedBytes - baseByteOffset) > 0L
        }
    }

    /**
     * Streams produced `MPEG-TS` bytes to a TV HTTP socket starting from [startByteOffset].
     * Supports:
     *  - Initial bounded head probes (`Range: bytes=0-65535`, `Range: bytes=65536-262143`)
     *  - Smart TV EOF tail probes (`Range: bytes=2147417856-2147483391`) -> served in `0ms` with valid
     *    188-byte aligned ISO/IEC 13818-1 Null Packets (`PID = 0x1FFF`, `0x47 0x1F 0xFF 0x10 0xFF...`)
     *    so the TV's HTTP demuxer never deadlocks waiting for EOF on a live stream!
     *  - Full continuous streaming (`Range: bytes=0-`, `Range: bytes=65536-`, or TV-initiated `Range: bytes=reqStart-`)
     */
    fun streamToClient(
        startByteOffset: Long,
        maxBytesToDeliver: Long?,
        out: OutputStream
    ) {
        val currentProduced = synchronized(bufferLock) { totalProducedBytes }
        val isFarFutureProbe = startByteOffset > currentProduced + 2L * 1024L * 1024L || startByteOffset < baseByteOffset
        if (isFarFutureProbe && maxBytesToDeliver != null && maxBytesToDeliver <= 4L * 1024L * 1024L) {
            touchActivity()
            val nullTsSlice = MpegTsMuxer.buildNullTsPacketSlice(startByteOffset, maxBytesToDeliver.toInt())
            if (nullTsSlice.isNotEmpty()) {
                out.write(nullTsSlice)
                out.flush()
            }
            return
        }

        val isSmallBoundedProbe = maxBytesToDeliver != null && maxBytesToDeliver <= 512L * 1024L
        val myGen = if (isSmallBoundedProbe) {
            clientGeneration.get()
        } else {
            clientGeneration.incrementAndGet()
        }

        activeClientCount.incrementAndGet()
        touchActivity()

        try {
            var cursor = startByteOffset.coerceAtLeast(baseByteOffset)
            var delivered = 0L

            synchronized(bufferLock) {
                // If TV probed 0..65535 and immediately requested 65536.. while transcoder is catching up,
                // wait up to 5s for the requested near-head offset to be produced.
                if (cursor > totalProducedBytes && cursor <= totalProducedBytes + 2L * 1024L * 1024L) {
                    val waitEnd = System.currentTimeMillis() + 5000L
                    while (!cancelled.get() && !producerFinishedEof && cursor > totalProducedBytes) {
                        val rem = waitEnd - System.currentTimeMillis()
                        if (rem <= 0L) break
                        bufferLock.wait(min(250L, rem))
                    }
                }
                // If cursor is still ahead of produced bytes, align to 188-byte TS packet phase at baseByteOffset
                // so sync byte 0x47 framing stays intact.
                if (cursor > totalProducedBytes || cursor < baseByteOffset) {
                    cursor = baseByteOffset + (cursor % MpegTsMuxer.TS_PACKET_SIZE)
                }
                if (!isSmallBoundedProbe) {
                    activeConsumerOffset = cursor
                    bufferLock.notifyAll()
                }
            }

            while (!cancelled.get()) {
                if (!isSmallBoundedProbe && clientGeneration.get() != myGen) {
                    // Superseded by a newer main playback GET connection from the TV
                    break
                }
                if (maxBytesToDeliver != null && delivered >= maxBytesToDeliver) {
                    break
                }

                var sliceBytes: ByteArray? = null
                var sliceOff = 0
                var sliceLen = 0

                synchronized(bufferLock) {
                    while (!cancelled.get()) {
                        if (!isSmallBoundedProbe && clientGeneration.get() != myGen) return
                        val found = findChunkAtLocked(cursor)
                        if (found != null) {
                            val localOff = (cursor - found.startOffset).toInt()
                            var canTake = found.bytes.size - localOff
                            if (maxBytesToDeliver != null) {
                                canTake = min(canTake.toLong(), maxBytesToDeliver - delivered).toInt()
                            }
                            sliceBytes = found.bytes
                            sliceOff = localOff
                            sliceLen = canTake
                            break
                        }

                        // If cursor fell behind rolling window (unlikely), jump cleanly to earliest TS packet boundary
                        val earliestRolling = rollingChunks.peekFirst()?.startOffset ?: totalProducedBytes
                        if (cursor >= baseByteOffset + PREFIX_PIN_BYTES && cursor < earliestRolling) {
                            Log.w(TAG, "⚠️ Consumer cursor $cursor lagged behind rolling window $earliestRolling; resyncing")
                            cursor = earliestRolling
                            continue
                        }

                        if (producerFinishedEof) {
                            val err = producerFatalError
                            if (err != null && totalProducedBytes <= baseByteOffset) {
                                throw IOException("Live transcode failed before output: ${err.message}", err)
                            }
                            return
                        }

                        bufferLock.wait(300L)
                    }
                }

                val buf = sliceBytes ?: break
                if (sliceLen <= 0) break

                out.write(buf, sliceOff, sliceLen)
                out.flush()

                cursor += sliceLen
                delivered += sliceLen
                touchActivity()

                if (!isSmallBoundedProbe) {
                    synchronized(bufferLock) {
                        if (clientGeneration.get() == myGen) {
                            activeConsumerOffset = cursor
                            evictConsumedRollingChunksLocked()
                            bufferLock.notifyAll()
                        }
                    }
                }
            }
        } finally {
            touchActivity()
            activeClientCount.decrementAndGet()
            synchronized(bufferLock) {
                bufferLock.notifyAll()
            }
        }
    }

    private fun findChunkAtLocked(offset: Long): TsChunk? {
        for (i in 0 until prefixChunks.size) {
            val c = prefixChunks[i]
            if (offset >= c.startOffset && offset < c.endOffsetExclusive) {
                return c
            }
        }
        for (c in rollingChunks) {
            if (offset >= c.startOffset && offset < c.endOffsetExclusive) {
                return c
            }
        }
        return null
    }

    private fun evictConsumedRollingChunksLocked() {
        val safeEvictBefore = min(activeConsumerOffset, totalProducedBytes - RETAIN_HISTORY_BYTES)
        while (rollingChunks.isNotEmpty()) {
            val head = rollingChunks.peekFirst() ?: break
            if (head.endOffsetExclusive <= safeEvictBefore) {
                rollingChunks.pollFirst()
            } else {
                break
            }
        }
    }

    private fun publishTsBytes(data: ByteArray, offset: Int, length: Int) {
        if (length <= 0 || cancelled.get()) return
        val copy = data.copyOfRange(offset, offset + length)

        synchronized(bufferLock) {
            // Backpressure: pause transcoding when 6 MB ahead of the TV's read cursor
            while (!cancelled.get() && (totalProducedBytes - activeConsumerOffset) >= MAX_AHEAD_BYTES) {
                if (activeClientCount.get() == 0 &&
                    (System.currentTimeMillis() - lastClientActivityMs.get()) > IDLE_NO_CLIENT_TIMEOUT_MS
                ) {
                    Log.i(TAG, "🛑 Stopping idle LiveTranscodeSession (no active TV client for ${IDLE_NO_CLIENT_TIMEOUT_MS}ms)")
                    cancelled.set(true)
                    return
                }
                try {
                    bufferLock.wait(300L)
                } catch (_: InterruptedException) {
                    Thread.currentThread().interrupt()
                    return
                }
            }
            if (cancelled.get()) return

            val chunk = TsChunk(startOffset = totalProducedBytes, bytes = copy)
            totalProducedBytes += copy.size

            if (prefixPinnedBytes < PREFIX_PIN_BYTES) {
                prefixChunks.add(chunk)
                prefixPinnedBytes += copy.size
            } else {
                rollingChunks.addLast(chunk)
                evictConsumedRollingChunksLocked()
            }
            bufferLock.notifyAll()
        }
    }

    internal fun publishTsBytesForTesting(data: ByteArray, offset: Int = 0, length: Int = data.size) {
        publishTsBytes(data, offset, length)
    }

    internal fun markProducerFinishedForTesting() {
        synchronized(bufferLock) {
            producerFinishedEof = true
            bufferLock.notifyAll()
        }
    }

    // =========================================================================
    // Core On-Phone Demux + Hardware VPU / FFmpeg Transcode + MPEG-TS Pipeline
    // =========================================================================

    internal class DemuxedSample(
        val data: ByteArray,
        val timeUs: Long,
        val flags: Int
    ) {
        val isKeyFrame: Boolean get() = (flags and C.BUFFER_FLAG_KEY_FRAME) != 0
    }

    internal class CaptureTrackOutput(
        val trackId: Int,
        val trackType: Int,
        private val onSample: (CaptureTrackOutput, ByteArray, Long, Int) -> Unit
    ) : TrackOutput {
        var format: Format? = null
        private val sampleScratch = ByteArrayOutputStreamLite()
        private var nonMainBytesWritten: Int = 0
        val preSelectionBuffer = ArrayDeque<DemuxedSample>(16)
        var selectionFinalized: Boolean = false
        var enabled: Boolean = false

        override fun format(format: Format) {
            this.format = format
        }

        override fun sampleData(
            input: DataReader,
            length: Int,
            allowEndOfInput: Boolean,
            sampleDataPart: Int
        ): Int {
            // Only keep SAMPLE_DATA_PART_MAIN (0); discard SAMPLE_DATA_PART_SUPPLEMENTAL (2)
            // emitted by Media3 MatroskaExtractor on tracks with BlockAdditions / Opus BlockGroups!
            val keepMain = enabled && (sampleDataPart == TrackOutput.SAMPLE_DATA_PART_MAIN)
            val read = sampleScratch.readFrom(input, length, allowEndOfInput, keepBytes = keepMain)
            if (read > 0 && enabled && sampleDataPart != TrackOutput.SAMPLE_DATA_PART_MAIN) {
                nonMainBytesWritten += read
            }
            return read
        }

        override fun sampleData(data: ParsableByteArray, length: Int, sampleDataPart: Int) {
            if (enabled) {
                if (sampleDataPart == TrackOutput.SAMPLE_DATA_PART_MAIN) {
                    sampleScratch.write(data.data, data.position, length)
                } else {
                    nonMainBytesWritten += length
                }
            }
            data.skipBytes(length)
        }

        override fun sampleMetadata(
            timeUs: Long,
            flags: Int,
            size: Int,
            offset: Int,
            cryptoData: TrackOutput.CryptoData?
        ) {
            if (!enabled) {
                nonMainBytesWritten = 0
                sampleScratch.reset()
                return
            }
            val mainSize = (size - nonMainBytesWritten).coerceAtLeast(0)
            nonMainBytesWritten = 0
            val packet = sampleScratch.consumeSample(mainSize, offset)
            if (packet.isNotEmpty()) {
                if (!selectionFinalized) {
                    if (preSelectionBuffer.size < 48) {
                        preSelectionBuffer.addLast(DemuxedSample(packet, timeUs, flags))
                    }
                } else {
                    onSample(this, packet, timeUs, flags)
                }
            }
        }
    }

    private class ByteArrayOutputStreamLite {
        private var buf = ByteArray(65536)
        private var count = 0
        private val discardScratch = ByteArray(16384)

        fun readFrom(input: DataReader, length: Int, allowEndOfInput: Boolean, keepBytes: Boolean): Int {
            if (!keepBytes) {
                val toRead = min(length, discardScratch.size)
                val read = input.read(discardScratch, 0, toRead)
                if (read == C.RESULT_END_OF_INPUT) {
                    if (allowEndOfInput) return C.RESULT_END_OF_INPUT
                    throw EOFException()
                }
                return read
            }
            ensureCapacity(count + length)
            val read = input.read(buf, count, length)
            if (read == C.RESULT_END_OF_INPUT) {
                if (allowEndOfInput) return C.RESULT_END_OF_INPUT
                throw EOFException()
            }
            count += read
            return read
        }

        fun write(src: ByteArray, offset: Int, len: Int) {
            if (len <= 0) return
            ensureCapacity(count + len)
            src.copyInto(buf, count, offset, offset + len)
            count += len
        }

        fun consumeSample(sampleSize: Int, trailingRemainingBytes: Int): ByteArray {
            if (count <= 0 || sampleSize <= 0) {
                if (trailingRemainingBytes <= 0) count = 0
                return ByteArray(0)
            }
            val actualSize = min(sampleSize, count)
            val start = (count - trailingRemainingBytes - actualSize).coerceAtLeast(0)
            val out = buf.copyOfRange(start, min(count, start + actualSize))
            if (trailingRemainingBytes in 1 until count) {
                val tailStart = count - trailingRemainingBytes
                buf.copyInto(buf, 0, tailStart, count)
                count = trailingRemainingBytes
            } else {
                count = 0
            }
            return out
        }

        fun reset() {
            count = 0
        }

        private fun ensureCapacity(needed: Int) {
            if (needed <= buf.size) return
            var newCap = buf.size * 2
            while (newCap < needed) newCap *= 2
            buf = buf.copyOf(newCap)
        }
    }

    /**
     * Zero-TCP direct in-process `DataSource` backed by `LocalStreamServer` + `1 MB` read-ahead buffer.
     */
    private inner class DirectServerDataSource : BaseDataSource(/* isNetwork = */ false) {
        private var currentUri: Uri? = null
        private var position: Long = 0L
        private var bytesRemaining: Long = 0L
        private var opened = false

        private val readAheadBuf = ByteArray(256 * 1024) // 256 KB read-ahead slice (fits inside 512 KB RAM head cache!)
        private var bufLogicalStart = -1L
        private var bufValidLen = 0

        override fun open(dataSpec: DataSpec): Long {
            transferInitializing(dataSpec)
            currentUri = dataSpec.uri
            val totalSize = totalSizeProvider()
            if (totalSize <= 0L) throw IOException("Video stream size unavailable")
            if (dataSpec.position >= totalSize) throw EOFException("Position ${dataSpec.position} >= $totalSize")

            position = dataSpec.position
            bytesRemaining = if (dataSpec.length != C.LENGTH_UNSET.toLong()) {
                min(dataSpec.length, totalSize - position)
            } else {
                totalSize - position
            }
            opened = true
            transferStarted(dataSpec)
            return bytesRemaining
        }

        override fun read(buffer: ByteArray, offset: Int, length: Int): Int {
            if (length == 0) return 0
            if (bytesRemaining <= 0L) return C.RESULT_END_OF_INPUT
            if (cancelled.get()) throw IOException("Transcode session cancelled")

            val maxWant = min(length.toLong(), bytesRemaining).toInt()

            // Serve from 1 MB read-ahead buffer when hit
            if (bufValidLen > 0 &&
                position >= bufLogicalStart &&
                position < bufLogicalStart + bufValidLen
            ) {
                val inBufOff = (position - bufLogicalStart).toInt()
                val avail = min(maxWant, bufValidLen - inBufOff)
                readAheadBuf.copyInto(buffer, offset, inBufOff, inBufOff + avail)
                position += avail
                bytesRemaining -= avail
                bytesTransferred(avail)
                return avail
            }

            // Fill 1 MB read-ahead window (or exact remaining)
            val totalSize = totalSizeProvider()
            val fillWant = min(readAheadBuf.size.toLong(), totalSize - position).toInt()
            if (fillWant <= 0) return C.RESULT_END_OF_INPUT

            val filled = directByteReader(position, readAheadBuf, 0, fillWant) { cancelled.get() }
            if (filled <= 0) {
                if (cancelled.get()) throw IOException("Cancelled during TDLib fetch")
                return C.RESULT_END_OF_INPUT
            }
            bufLogicalStart = position
            bufValidLen = filled

            val take = min(maxWant, filled)
            readAheadBuf.copyInto(buffer, offset, 0, take)
            position += take
            bytesRemaining -= take
            bytesTransferred(take)
            return take
        }

        override fun getUri(): Uri? = currentUri

        override fun close() {
            if (opened) {
                opened = false
                transferEnded()
            }
        }
    }

    private class SubtitleTimelineCollector {
        private val cueDecoder = CueDecoder()
        private val spans = ArrayList<CuesWithTiming>()

        @Synchronized
        fun addSample(mimeType: String?, data: ByteArray, sampleTimeUs: Long) {
            if (data.isEmpty()) return
            try {
                if (mimeType == MimeTypes.APPLICATION_MEDIA3_CUES) {
                    val decoded = cueDecoder.decode(sampleTimeUs, data, 0, data.size)
                    addSpanLocked(decoded)
                    return
                }
                // Fallback for raw UTF-8 text subtitle packets (SRT / ASS)
                val rawText = String(data, StandardCharsets.UTF_8).trim()
                if (rawText.isNotEmpty()) {
                    val clean = if (rawText.contains(",")) {
                        // Matroska raw ASS block format: ReadOrder,Layer,Style,Name,MarginL,MarginR,MarginV,Effect,Text
                        val parts = rawText.split(',', limit = 9)
                        if (parts.size == 9) parts[8] else rawText
                    } else {
                        rawText
                    }
                    if (clean.isNotBlank()) {
                        val cue = Cue.Builder().setText(clean).build()
                        addSpanLocked(CuesWithTiming(listOf(cue), sampleTimeUs, 4_000_000L))
                    }
                }
            } catch (_: Throwable) {}
        }

        @Synchronized
        private fun addSpanLocked(span: CuesWithTiming) {
            if (span.cues.isEmpty()) {
                // Explicit clear-screen cue emitted at span.startTimeUs: truncate any open earlier spans
                for (i in spans.indices) {
                    val prev = spans[i]
                    val prevEnd = if (prev.endTimeUs != C.TIME_UNSET && prev.endTimeUs > prev.startTimeUs) {
                        prev.endTimeUs
                    } else {
                        prev.startTimeUs + 4_500_000L
                    }
                    if (prev.startTimeUs < span.startTimeUs && prevEnd > span.startTimeUs) {
                        spans[i] = CuesWithTiming(prev.cues, prev.startTimeUs, span.startTimeUs - prev.startTimeUs)
                    }
                }
                return
            }
            val dur = if (span.durationUs != C.TIME_UNSET && span.durationUs > 0L) {
                span.durationUs
            } else {
                4_500_000L
            }
            val normalized = CuesWithTiming(span.cues, span.startTimeUs, dur)
            spans.add(normalized)
            // Keep memory bounded over a 3-hour movie (retain most recent 250 subtitle events)
            if (spans.size > 250) {
                spans.subList(0, spans.size - 200).clear()
            }
        }

        @Synchronized
        fun getActiveCuesAt(timeUs: Long): List<Cue> {
            if (spans.isEmpty()) return emptyList()
            val out = ArrayList<Cue>(2)
            for (i in spans.indices) {
                val s = spans[i]
                val endUs = if (s.endTimeUs != C.TIME_UNSET && s.endTimeUs > s.startTimeUs) {
                    s.endTimeUs
                } else {
                    s.startTimeUs + 4_000_000L
                }
                if (timeUs in s.startTimeUs until endUs) {
                    out.addAll(s.cues)
                }
            }
            return out
        }
    }

    private data class ReadyVideoFrame(
        val annexBData: ByteArray,
        val ptsUs: Long,
        val dtsUs: Long,
        val isKeyFrame: Boolean
    )

    private data class ReadyAudioFrame(
        val rawAacData: ByteArray,
        val ptsUs: Long,
        val sampleRate: Int,
        val channels: Int
    )

    private fun runTranscodePipeline() {
        val totalFileSize = totalSizeProvider()
        if (totalFileSize <= 0L) {
            throw IOException("Cannot transcode empty stream (size=$totalFileSize)")
        }

        val fakeUri = Uri.parse("http://127.0.0.1/stream")
        val dataSource = DirectServerDataSource()

        val videoQueue = ArrayDeque<DemuxedSample>(64)
        val audioQueue = ArrayDeque<DemuxedSample>(128)
        val subtitleCollector = SubtitleTimelineCollector()

        val discoveredTracks = ArrayList<CaptureTrackOutput>()
        var tracksEnded = false
        var seekMap: SeekMap? = null

        var selectedVideoTrack: CaptureTrackOutput? = null
        var selectedAudioTrack: CaptureTrackOutput? = null
        var selectedSubtitleTrack: CaptureTrackOutput? = null

        val extractorOutput = object : ExtractorOutput {
            override fun track(id: Int, type: Int): TrackOutput {
                val existing = discoveredTracks.firstOrNull { it.trackId == id && it.trackType == type }
                if (existing != null) return existing
                val created = CaptureTrackOutput(id, type) { trackOut, bytes, timeUs, flags ->
                    when {
                        trackOut === selectedVideoTrack -> {
                            videoQueue.addLast(DemuxedSample(bytes, timeUs, flags))
                        }
                        trackOut === selectedAudioTrack -> {
                            audioQueue.addLast(DemuxedSample(bytes, timeUs, flags))
                        }
                        trackOut === selectedSubtitleTrack -> {
                            subtitleCollector.addSample(trackOut.format?.sampleMimeType, bytes, timeUs)
                        }
                    }
                }
                // Temporarily enable all tracks until endTracks() picks the exact target Video/Audio/Sub
                created.enabled = true
                discoveredTracks.add(created)
                return created
            }

            override fun endTracks() {
                tracksEnded = true
            }

            override fun seekMap(map: SeekMap) {
                seekMap = map
            }
        }

        val needSubtitleTranscoding = spec.subtitleMode == MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE
        val wantContainerSeek = spec.startPositionMs > 2_500L
        val extractorsFactory = DefaultExtractorsFactory()
            .setConstantBitrateSeekingEnabled(true)
            .setTextTrackTranscodingEnabled(needSubtitleTranscoding)
            .setMatroskaExtractorFlags(
                androidx.media3.extractor.mkv.MatroskaExtractor.FLAG_DISABLE_SEEK_FOR_CUES
            )

        var extractor: Extractor? = null
        var hwVideoDecoder: MediaCodec? = null
        var ffmpegVideoDecoder: CineflixFfmpegVideoDecoder? = null
        var videoEncoder: MediaCodec? = null
        var eglSurface: EglTranscodeSurface? = null
        var ffmpegAudioDecoder: CineflixFfmpegAudioDecoder? = null
        var hwAudioDecoder: MediaCodec? = null
        var aacEncoder: MediaCodec? = null

        try {
            var currentPos = 0L
            var openedLen = dataSource.open(DataSpec(fakeUri, 0L, C.LENGTH_UNSET.toLong()))
            var totalStreamLen = if (openedLen != C.LENGTH_UNSET.toLong()) openedLen else totalFileSize
            var extractorInput = DefaultExtractorInput(dataSource, 0L, totalStreamLen)

            // 1. Sniff container extractor (MatroskaExtractor, Mp4Extractor, AviExtractor, TsExtractor...)
            val candidates = extractorsFactory.createExtractors()
            for (cand in candidates) {
                try {
                    if (cand.sniff(extractorInput)) {
                        extractor = cand
                        break
                    }
                } catch (_: Throwable) {
                } finally {
                    extractorInput.resetPeekPosition()
                }
            }
            val activeExtractor = extractor ?: throw IOException("No Media3 Extractor matched container")
            activeExtractor.init(extractorOutput)

            val posHolder = PositionHolder()

            fun reopenInputAt(targetBytePos: Long): DefaultExtractorInput {
                dataSource.close()
                val safePos = targetBytePos.coerceIn(0L, max(0L, totalFileSize - 1L))
                val rem = dataSource.open(DataSpec(fakeUri, safePos, C.LENGTH_UNSET.toLong()))
                val streamLen = if (rem != C.LENGTH_UNSET.toLong()) safePos + rem else totalFileSize
                currentPos = safePos
                return DefaultExtractorInput(dataSource, safePos, streamLen)
            }

            // 2. Parse container headers & <Cues> / moov seek table
            var headerSteps = 0
            while (!cancelled.get()) {
                val hasMediaFormat = discoveredTracks.any {
                    it.format != null && (
                        MimeTypes.isVideo(it.format?.sampleMimeType) ||
                        MimeTypes.isAudio(it.format?.sampleMimeType)
                    )
                }
                val allEnabledHaveFormat = discoveredTracks.none { it.enabled && it.format == null }
                if (tracksEnded && seekMap != null && (allEnabledHaveFormat || (hasMediaFormat && headerSteps >= 32))) {
                    break
                }
                headerSteps++
                if (headerSteps > 300 && tracksEnded && seekMap != null) break
                val res = activeExtractor.read(extractorInput, posHolder)
                if (res == Extractor.RESULT_SEEK) {
                    extractorInput = reopenInputAt(posHolder.position)
                } else if (res == Extractor.RESULT_END_OF_INPUT) {
                    break
                }
            }
            if (cancelled.get()) return

            // 3. Select exact Video, Audio, and Subtitle tracks requested by PlayerActivity
            val videoTracks = discoveredTracks.filter {
                it.trackType == C.TRACK_TYPE_VIDEO || MimeTypes.isVideo(it.format?.sampleMimeType)
            }
            val audioTracks = discoveredTracks.filter {
                it.trackType == C.TRACK_TYPE_AUDIO || MimeTypes.isAudio(it.format?.sampleMimeType)
            }
            val textTracks = discoveredTracks.filter {
                it.trackType == C.TRACK_TYPE_TEXT ||
                    it.format?.sampleMimeType == MimeTypes.APPLICATION_MEDIA3_CUES ||
                    MimeTypes.isText(it.format?.sampleMimeType)
            }

            selectedVideoTrack = videoTracks.firstOrNull()

            selectedAudioTrack = when {
                audioTracks.isEmpty() -> null
                spec.audioTrackNumber != null -> {
                    audioTracks.firstOrNull {
                        it.trackId == spec.audioTrackNumber || it.format?.id?.toIntOrNull() == spec.audioTrackNumber
                    } ?: spec.audioOrdinal?.let { audioTracks.getOrNull(it) }
                      ?: audioTracks.firstOrNull()
                }
                spec.audioOrdinal != null -> {
                    audioTracks.getOrNull(spec.audioOrdinal) ?: audioTracks.firstOrNull()
                }
                else -> {
                    audioTracks.firstOrNull { ((it.format?.selectionFlags ?: 0) and C.SELECTION_FLAG_DEFAULT) != 0 }
                        ?: audioTracks.firstOrNull()
                }
            }

            selectedSubtitleTrack = if (spec.subtitleMode == MatroskaEbmlTrackPatcher.SubtitlePatchMode.SELECT_SINGLE && textTracks.isNotEmpty()) {
                when {
                    spec.subtitleTrackNumber != null -> {
                        textTracks.firstOrNull {
                            it.trackId == spec.subtitleTrackNumber || it.format?.id?.toIntOrNull() == spec.subtitleTrackNumber
                        } ?: spec.subtitleOrdinal?.let { textTracks.getOrNull(it) }
                    }
                    spec.subtitleOrdinal != null -> textTracks.getOrNull(spec.subtitleOrdinal)
                    else -> null
                }
            } else {
                null
            }

            // Disable all unselected tracks so zero CPU/RAM is spent buffering unused audio languages
            val targetStartUs = if (wantContainerSeek) spec.startPositionMs.coerceAtLeast(0L) * 1000L else 0L
            val sm = seekMap
            val smDurationUs = if (sm != null && sm.durationUs != C.TIME_UNSET && sm.durationUs > 0L) sm.durationUs else 0L
            if (smDurationUs > 0L) {
                try {
                    onDurationDiscovered?.invoke(smDurationUs / 1000L)
                } catch (_: Throwable) {}
            }
            val effectiveDurationUs = if (smDurationUs > 0L) {
                smDurationUs
            } else {
                (spec.durationHintMs.coerceAtLeast(0L) * 1000L)
            }
            val canContainerSeek = wantContainerSeek && (sm?.isSeekable == true || (effectiveDurationUs > 0L && totalFileSize > 1_048_576L))
            for (t in discoveredTracks) {
                val keep = (t === selectedVideoTrack || t === selectedAudioTrack || t === selectedSubtitleTrack)
                t.enabled = keep
                t.selectionFinalized = true
                if (keep && !canContainerSeek) {
                    while (t.preSelectionBuffer.isNotEmpty()) {
                        val s = t.preSelectionBuffer.pollFirst() ?: break
                        when {
                            t === selectedVideoTrack -> videoQueue.addLast(s)
                            t === selectedAudioTrack -> audioQueue.addLast(s)
                            t === selectedSubtitleTrack -> subtitleCollector.addSample(t.format?.sampleMimeType, s.data, s.timeUs)
                        }
                    }
                } else {
                    t.preSelectionBuffer.clear()
                }
            }

            // 4. Seek immediately to startPositionMs if resuming mid-movie or switching tracks/seeking!
            var seekKeyframeUs = 0L
            if (canContainerSeek) {
                videoQueue.clear()
                audioQueue.clear()
                if (sm != null && sm.isSeekable) {
                    val seekPts = sm.getSeekPoints(targetStartUs)
                    val byteOffset = seekPts.first.position
                    val timeUs = seekPts.first.timeUs
                    seekKeyframeUs = timeUs.coerceAtLeast(0L)
                    activeExtractor.seek(byteOffset, timeUs)
                    extractorInput = reopenInputAt(byteOffset)
                    Log.i(TAG, "⏩ LiveTranscoder sought source container via SeekMap to ${spec.startPositionMs}ms (keyframe=${timeUs / 1000}ms, byte=$byteOffset)")
                } else if (effectiveDurationUs > 0L && totalFileSize > 1_048_576L) {
                    val alignedOffset = findMatroskaClusterForTargetTimeUs(
                        targetTimeUs = targetStartUs,
                        durationUs = effectiveDurationUs,
                        totalFileSize = totalFileSize
                    )
                    seekKeyframeUs = targetStartUs
                    activeExtractor.seek(alignedOffset, targetStartUs)
                    extractorInput = reopenInputAt(alignedOffset)
                    Log.i(
                        TAG,
                        "⏩ LiveTranscoder sought Matroska container directly to ${spec.startPositionMs}ms without EOF Cues " +
                            "(clusterByte=$alignedOffset / $totalFileSize)"
                    )
                }
            }

            val videoFormat = selectedVideoTrack?.format
            val audioFormat = selectedAudioTrack?.format
            val hasVideo = videoFormat != null
            val hasAudio = audioFormat != null

            if (!hasVideo && !hasAudio) {
                throw IOException("Container contains neither decodable video nor audio tracks")
            }

            // 5. Decide Video Path: 0-GPU H.264 Passthrough vs Full Hardware VPU -> H.264 1080p Transcode
            val wantBurnSubtitles = selectedSubtitleTrack != null
            val is8BitH264Le1080p = videoFormat != null &&
                videoFormat.sampleMimeType == MimeTypes.VIDEO_H264 &&
                (videoFormat.width <= 0 || videoFormat.width <= 1920) &&
                (videoFormat.height <= 0 || videoFormat.height <= 1088) &&
                !isUnsupportedPassthroughAvcProfile(videoFormat)

            val transcodeVideoToH264 = hasVideo && (spec.forceVideoTranscode || wantBurnSubtitles || !is8BitH264Le1080p)

            Log.i(
                TAG,
                "🎬 LiveTranscoder starting: video=${videoFormat?.sampleMimeType} (${videoFormat?.width}x${videoFormat?.height}) " +
                "mode=${if (transcodeVideoToH264) "HW_TRANSCODE_H264" else "PASSTHROUGH_H264"}, " +
                "audio=${audioFormat?.sampleMimeType} (${audioFormat?.channelCount}ch @ ${audioFormat?.sampleRate}Hz, lang=${audioFormat?.language}), " +
                "subBurn=${selectedSubtitleTrack?.format?.language ?: "OFF"}"
            )

            // 6. Initialize Video Pipeline
            var passthroughAvcConfig = H264NalConverter.AvcConfig(emptyList(), emptyList(), 4)
            var encoderSpsList: List<ByteArray> = emptyList()
            var encoderPpsList: List<ByteArray> = emptyList()

            if (hasVideo && videoFormat != null) {
                passthroughAvcConfig = H264NalConverter.parseInitializationData(videoFormat.initializationData)
                if (transcodeVideoToH264) {
                    val (outW, outH) = EglTranscodeSurface.computeSafeH264Dimensions(
                        srcWidth = videoFormat.width,
                        srcHeight = videoFormat.height,
                        pixelWidthHeightRatio = videoFormat.pixelWidthHeightRatio,
                        rotationDegrees = videoFormat.rotationDegrees
                    )
                    val srcFps = if (videoFormat.frameRate > 1f && videoFormat.frameRate <= 120f) {
                        videoFormat.frameRate
                    } else {
                        24f
                    }
                    // Cap at 30 fps for Level 4.0 1080p universal compatibility on 2010-2014 TVs & 2x faster encode
                    val targetFps = min(30, srcFps.roundToInt().coerceAtLeast(24))
                    val is1080pOut = outW > 1280 || outH > 720
                    val remDurMs = max(0L, (effectiveDurationUs / 1000L) - spec.startPositionMs.coerceAtLeast(0L))
                    val targetBitrate = LiveTranscodeManager.computeTargetVideoBitrateBps(remDurMs, is1080pOut)

                    videoEncoder = createConfiguredH264SurfaceEncoder(outW, outH, targetBitrate, targetFps)
                    val encInputSurface = videoEncoder.createInputSurface()
                    videoEncoder.start()

                    eglSurface = EglTranscodeSurface(encInputSurface, outW, outH)

                    // Primary: Hardware MediaCodec video decoder -> GPU EglTranscodeSurface
                    // Fallback: Bundled NextLib FFmpeg software video decoder -> GPU EglTranscodeSurface
                    try {
                        hwVideoDecoder = createStartedHardwareVideoDecoder(videoFormat, eglSurface.decoderOutputSurface)
                        Log.i(TAG, "⚡ Hardware video decoder initialized: ${hwVideoDecoder.name} -> H.264 ${outW}x${outH} @ ${targetBitrate / 1000}kbps")
                    } catch (hwErr: Throwable) {
                        Log.w(TAG, "⚠️ Hardware video decoder unavailable for ${videoFormat.sampleMimeType} (${hwErr.message}); falling back to FFmpeg software decoder")
                        hwVideoDecoder?.let { safeReleaseCodec(it) }
                        hwVideoDecoder = null
                        if (!CineflixFfmpegVideoDecoder.isSupported(videoFormat)) {
                            throw IOException("Neither hardware MediaCodec nor FFmpeg supports ${videoFormat.sampleMimeType}", hwErr)
                        }
                        ffmpegVideoDecoder = CineflixFfmpegVideoDecoder(videoFormat)
                    }
                }
            }

            // 7. Initialize Audio Pipeline (FFmpeg primary -> Stereo 16-bit PCM -> Hardware AAC-LC ADTS)
            var targetAacSampleRate = 48000
            if (hasAudio && audioFormat != null) {
                val nominalRate = if (audioFormat.sampleRate > 0) audioFormat.sampleRate else 48000
                targetAacSampleRate = PcmStereoProcessor.chooseTargetAacSampleRate(nominalRate)

                if (CineflixFfmpegAudioDecoder.isSupported(audioFormat)) {
                    try {
                        ffmpegAudioDecoder = CineflixFfmpegAudioDecoder(audioFormat)
                        Log.i(TAG, "🔊 FFmpeg audio decoder initialized for ${audioFormat.sampleMimeType} -> Stereo AAC @ ${targetAacSampleRate}Hz")
                    } catch (ffErr: Throwable) {
                        Log.w(TAG, "⚠️ FFmpeg audio decoder init failed for ${audioFormat.sampleMimeType} (${ffErr.message}); falling back to hardware MediaCodec")
                        ffmpegAudioDecoder = null
                        hwAudioDecoder = createStartedHardwareAudioDecoder(audioFormat)
                    }
                } else {
                    hwAudioDecoder = createStartedHardwareAudioDecoder(audioFormat)
                    Log.i(TAG, "🔊 Hardware audio decoder initialized for ${audioFormat.sampleMimeType} -> Stereo AAC @ ${targetAacSampleRate}Hz")
                }

                aacEncoder = createStartedAacEncoder(targetAacSampleRate, channelCount = 2, bitrate = TARGET_AAC_BITRATE)
            }

            val muxer = MpegTsMuxer(
                includeVideo = hasVideo,
                includeAudio = hasAudio,
                videoStreamType = MpegTsMuxer.STREAM_TYPE_H264,
                initialMediaOffsetUs = spec.tsPtsOffsetMs.coerceAtLeast(0L) * 1000L,
                emitInitialDiscontinuity = baseByteOffset > 0L || spec.tsPtsOffsetMs > 0L
            ) { bytes, off, len ->
                publishTsBytes(bytes, off, len)
            }
            muxer.emitPsiTables()

            // 8. Cooperative Single-Thread Event Loop (EGL-bound, zero lock contention, zero buffer deadlocks)
            val codecInfo = MediaCodec.BufferInfo()
            var extractorEof = false

            var videoDecoderInputEos = !hasVideo
            var videoDecoderOutputEos = !hasVideo
            var videoEncoderOutputEos = !hasVideo
            var seenFirstInputKeyFrame = false
            var lastRenderedVideoPtsUs = Long.MIN_VALUE
            val minVideoFrameStepUs = 31_000L // Cap >32fps (e.g. 60fps -> 30fps) so 2014 Level 4.0 TVs play 1080p silkily

            // Anchor immediately on the first decoded/passthrough video frame at the sought Cluster
            val minEmitMediaTimeUs = 0L
            var anchoredMediaStartUs: Long = if (!hasVideo) minEmitMediaTimeUs else Long.MIN_VALUE

            var audioDecoderInputEos = !hasAudio
            var audioDecoderOutputEos = !hasAudio
            var aacEncoderInputEos = !hasAudio
            var aacEncoderOutputEos = !hasAudio

            val pendingStereoPcmChunks = ArrayDeque<ByteArray>(32)
            var currentPcmChunk: ByteArray? = null
            var currentPcmChunkOffset = 0
            var audioPtsBaseUs = Long.MIN_VALUE
            var totalStereoFramesFedToAac = 0L

            val readyVideoFrames = ArrayDeque<ReadyVideoFrame>(32)
            val readyAudioFrames = ArrayDeque<ReadyAudioFrame>(64)
            val videoDtsNormalizer = VideoDtsNormalizer(
                reorderWindowFrames = if (transcodeVideoToH264) 2 else 6,
                ctsLeadUs = if (transcodeVideoToH264) 45_000L else 200_000L
            )

            fun pushNormalizedVideoFrame(annexB: ByteArray, ptsUs: Long, isKey: Boolean) {
                videoDtsNormalizer.pushFrame(annexB, ptsUs, isKey) { norm ->
                    readyVideoFrames.addLast(
                        ReadyVideoFrame(
                            annexBData = norm.annexBData,
                            ptsUs = norm.ptsUs,
                            dtsUs = norm.dtsUs,
                            isKeyFrame = norm.isKeyFrame
                        )
                    )
                }
            }

            fun flushNormalizedVideoFrames() {
                videoDtsNormalizer.flushAll { norm ->
                    readyVideoFrames.addLast(
                        ReadyVideoFrame(
                            annexBData = norm.annexBData,
                            ptsUs = norm.ptsUs,
                            dtsUs = norm.dtsUs,
                            isKeyFrame = norm.isKeyFrame
                        )
                    )
                }
            }

            fun drainVideoEncoderNonBlocking() {
                val enc = videoEncoder ?: return
                while (!videoEncoderOutputEos && !cancelled.get()) {
                    val outIdx = enc.dequeueOutputBuffer(codecInfo, 0L)
                    when {
                        outIdx == MediaCodec.INFO_TRY_AGAIN_LATER -> break
                        outIdx == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED -> {
                            val newFmt = enc.outputFormat
                            val csd0 = newFmt.getByteBuffer("csd-0")?.let { copyByteBuffer(it) }
                            val csd1 = newFmt.getByteBuffer("csd-1")?.let { copyByteBuffer(it) }
                            val spsMut = mutableListOf<ByteArray>()
                            val ppsMut = mutableListOf<ByteArray>()
                            if (csd0 != null) {
                                val (s, p) = H264NalConverter.extractSpsPpsFromCodecConfig(csd0)
                                spsMut.addAll(s)
                                ppsMut.addAll(p)
                            }
                            if (csd1 != null) {
                                val (s, p) = H264NalConverter.extractSpsPpsFromCodecConfig(csd1)
                                spsMut.addAll(s)
                                ppsMut.addAll(p)
                            }
                            if (spsMut.isNotEmpty()) encoderSpsList = spsMut
                            if (ppsMut.isNotEmpty()) encoderPpsList = ppsMut
                        }
                        outIdx >= 0 -> {
                            try {
                                val isConfig = (codecInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0
                                if (isConfig && codecInfo.size > 0) {
                                    val outBuf = enc.getOutputBuffer(outIdx)
                                    if (outBuf != null) {
                                        val csdBytes = copyByteBuffer(outBuf, codecInfo.offset, codecInfo.size)
                                        val (s, p) = H264NalConverter.extractSpsPpsFromCodecConfig(csdBytes)
                                        if (s.isNotEmpty()) encoderSpsList = s
                                        if (p.isNotEmpty()) encoderPpsList = p
                                    }
                                } else if (codecInfo.size > 0) {
                                    val outBuf = enc.getOutputBuffer(outIdx)
                                    if (outBuf != null) {
                                        val rawBytes = copyByteBuffer(outBuf, codecInfo.offset, codecInfo.size)
                                        val annexB = H264NalConverter.toAnnexB(rawBytes, 4)
                                        val isKey = ((codecInfo.flags and MediaCodec.BUFFER_FLAG_KEY_FRAME) != 0) ||
                                            H264NalConverter.containsNalType(annexB, 5)
                                        pushNormalizedVideoFrame(annexB, codecInfo.presentationTimeUs, isKey)
                                    }
                                }
                                if ((codecInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                                    flushNormalizedVideoFrames()
                                    videoEncoderOutputEos = true
                                }
                            } finally {
                                enc.releaseOutputBuffer(outIdx, false)
                            }
                        }
                        else -> break
                    }
                }
            }

            fun drainAacEncoderNonBlocking() {
                val enc = aacEncoder ?: return
                while (!aacEncoderOutputEos && !cancelled.get()) {
                    val outIdx = enc.dequeueOutputBuffer(codecInfo, 0L)
                    if (outIdx >= 0) {
                        try {
                            val isConfig = (codecInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0
                            if (!isConfig && codecInfo.size > 0) {
                                val outBuf = enc.getOutputBuffer(outIdx)
                                if (outBuf != null) {
                                    val rawAac = copyByteBuffer(outBuf, codecInfo.offset, codecInfo.size)
                                    readyAudioFrames.addLast(
                                        ReadyAudioFrame(
                                            rawAacData = rawAac,
                                            ptsUs = codecInfo.presentationTimeUs,
                                            sampleRate = targetAacSampleRate,
                                            channels = 2
                                        )
                                    )
                                }
                            }
                            if ((codecInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                                aacEncoderOutputEos = true
                            }
                        } finally {
                            enc.releaseOutputBuffer(outIdx, false)
                        }
                    } else {
                        break
                    }
                }
            }

            fun enqueueDecodedPcm(pcm16Le: ByteArray, sampleRate: Int, channels: Int, sampleTimeUs: Long) {
                val gateUs = if (anchoredMediaStartUs != Long.MIN_VALUE) anchoredMediaStartUs else minEmitMediaTimeUs
                // Estimated duration of this PCM buffer
                val framesInBuf = pcm16Le.size / max(1, channels * 2)
                val durUs = if (sampleRate > 0) (framesInBuf * 1_000_000L) / sampleRate else 0L
                if (sampleTimeUs + durUs < gateUs) {
                    return
                }
                val stereoBytes = PcmStereoProcessor.toStereo16BitPcm(
                    pcm16Le = pcm16Le,
                    srcChannels = channels,
                    srcSampleRate = sampleRate,
                    targetSampleRate = targetAacSampleRate
                )
                if (stereoBytes.isNotEmpty()) {
                    if (audioPtsBaseUs == Long.MIN_VALUE) {
                        audioPtsBaseUs = max(sampleTimeUs, gateUs)
                        totalStereoFramesFedToAac = 0L
                    }
                    pendingStereoPcmChunks.addLast(stereoBytes)
                }
            }

            var hasEmittedFirstVideoFrame = !hasVideo

            fun flushInterleavedToMpegTs(forceFlushAll: Boolean) {
                while (!cancelled.get()) {
                    val vHead = readyVideoFrames.peekFirst()
                    val aHead = readyAudioFrames.peekFirst()

                    when {
                        vHead != null && aHead != null -> {
                            // Always emit the first video IDR keyframe (carrying initial PCR & SPS/PPS/IDR)
                            // before any audio PES packet!
                            if (!hasEmittedFirstVideoFrame || vHead.dtsUs <= aHead.ptsUs) {
                                readyVideoFrames.pollFirst()
                                val sps = if (transcodeVideoToH264) encoderSpsList else passthroughAvcConfig.spsList
                                val pps = if (transcodeVideoToH264) encoderPpsList else passthroughAvcConfig.ppsList
                                muxer.writeH264Sample(vHead.annexBData, vHead.ptsUs, vHead.isKeyFrame, sps, pps, vHead.dtsUs)
                                hasEmittedFirstVideoFrame = true
                            } else {
                                readyAudioFrames.pollFirst()
                                muxer.writeAacFrame(aHead.rawAacData, aHead.ptsUs, aHead.sampleRate, aHead.channels)
                            }
                        }
                        vHead != null && (!hasEmittedFirstVideoFrame || forceFlushAll || aacEncoderOutputEos || !hasAudio ||
                            (readyVideoFrames.peekLast()!!.dtsUs - vHead.dtsUs) > 650_000L) -> {
                            readyVideoFrames.pollFirst()
                            val sps = if (transcodeVideoToH264) encoderSpsList else passthroughAvcConfig.spsList
                            val pps = if (transcodeVideoToH264) encoderPpsList else passthroughAvcConfig.ppsList
                            muxer.writeH264Sample(vHead.annexBData, vHead.ptsUs, vHead.isKeyFrame, sps, pps, vHead.dtsUs)
                            hasEmittedFirstVideoFrame = true
                        }
                        aHead != null && hasEmittedFirstVideoFrame && (forceFlushAll || videoEncoderOutputEos || !hasVideo ||
                            (readyAudioFrames.peekLast()!!.ptsUs - aHead.ptsUs) > 650_000L) -> {
                            readyAudioFrames.pollFirst()
                            muxer.writeAacFrame(aHead.rawAacData, aHead.ptsUs, aHead.sampleRate, aHead.channels)
                        }
                        else -> break
                    }
                }
            }

            while (!cancelled.get() && (!videoEncoderOutputEos || !aacEncoderOutputEos)) {
                var didWork = false

                // Fast-drop pre-roll compressed audio packets while video is still seeking towards its first keyframe
                // so audioQueue never fills underMemoryCap (240) during a mid-Cluster seek!
                if (hasVideo && anchoredMediaStartUs == Long.MIN_VALUE) {
                    while (audioQueue.size > 28) {
                        audioQueue.pollFirst()
                        didWork = true
                    }
                }

                // A. Demux chunks from TDLib into bounded packet queues
                val needMoreVideo = hasVideo && videoQueue.size < 16
                val needMoreAudio = hasAudio && audioQueue.size < 32
                val underMemoryCap = (videoQueue.size + audioQueue.size) < 240
                if (!extractorEof && underMemoryCap && (needMoreVideo || needMoreAudio)) {
                    var reads = 0
                    while (reads < 10 && !extractorEof && !cancelled.get() &&
                        ((hasVideo && videoQueue.size < 16) || (hasAudio && audioQueue.size < 32)) &&
                        (videoQueue.size + audioQueue.size) < 240
                    ) {
                        reads++
                        val r = activeExtractor.read(extractorInput, posHolder)
                        if (r == Extractor.RESULT_SEEK) {
                            extractorInput = reopenInputAt(posHolder.position)
                            didWork = true
                        } else if (r == Extractor.RESULT_END_OF_INPUT) {
                            extractorEof = true
                            didWork = true
                            break
                        } else {
                            didWork = true
                        }
                    }
                }

                // B. Process Video (Passthrough OR Hardware/FFmpeg GPU Transcode)
                if (hasVideo && !videoEncoderOutputEos) {
                    if (!transcodeVideoToH264) {
                        while (videoQueue.isNotEmpty() && readyVideoFrames.size < 24) {
                            val sample = videoQueue.pollFirst() ?: break
                            didWork = true
                            val annexB = H264NalConverter.toAnnexB(sample.data, passthroughAvcConfig.nalLengthSize)
                            val isKey = sample.isKeyFrame || H264NalConverter.containsNalType(annexB, 5)
                            if (anchoredMediaStartUs == Long.MIN_VALUE) {
                                if (!isKey) continue // Always start TS stream on an IDR keyframe!
                                seenFirstInputKeyFrame = true
                                anchoredMediaStartUs = sample.timeUs
                            }
                            pushNormalizedVideoFrame(annexB, sample.timeUs, isKey)
                        }
                        if (extractorEof && videoQueue.isEmpty()) {
                            flushNormalizedVideoFrames()
                            videoDecoderInputEos = true
                            videoDecoderOutputEos = true
                            videoEncoderOutputEos = true
                        }
                    } else {
                        drainVideoEncoderNonBlocking()

                        val hwDec = hwVideoDecoder
                        val ffDec = ffmpegVideoDecoder
                        val surface = eglSurface!!

                        if (hwDec != null) {
                            // Feed compressed samples into hardware video decoder (always start on a keyframe!)
                            while (!videoDecoderInputEos && videoQueue.isNotEmpty()) {
                                val peekSample = videoQueue.peekFirst()!!
                                if (!seenFirstInputKeyFrame) {
                                    if (!peekSample.isKeyFrame) {
                                        videoQueue.pollFirst()
                                        didWork = true
                                        continue
                                    }
                                    seenFirstInputKeyFrame = true
                                    while (audioQueue.isNotEmpty() && audioQueue.peekFirst()!!.timeUs + 150_000L < peekSample.timeUs) {
                                        audioQueue.pollFirst()
                                    }
                                }
                                val inIdx = hwDec.dequeueInputBuffer(0L)
                                if (inIdx < 0) break
                                val sample = videoQueue.pollFirst()!!
                                val annexBInput = H264NalConverter.toAnnexB(sample.data, passthroughAvcConfig.nalLengthSize)
                                val inBuf = hwDec.getInputBuffer(inIdx)!!
                                inBuf.clear()
                                inBuf.put(annexBInput)
                                val flags = if (sample.isKeyFrame) MediaCodec.BUFFER_FLAG_KEY_FRAME else 0
                                hwDec.queueInputBuffer(inIdx, 0, annexBInput.size, sample.timeUs, flags)
                                didWork = true
                            }
                            if (!videoDecoderInputEos && extractorEof && videoQueue.isEmpty()) {
                                val inIdx = hwDec.dequeueInputBuffer(0L)
                                if (inIdx >= 0) {
                                    hwDec.queueInputBuffer(inIdx, 0, 0, 0L, MediaCodec.BUFFER_FLAG_END_OF_STREAM)
                                    videoDecoderInputEos = true
                                    didWork = true
                                }
                            }

                            // Drain at most 1 decoded frame per step so SurfaceTexture latches 1:1 without frame drop
                            if (!videoDecoderOutputEos && readyVideoFrames.size < 24) {
                                val outIdx = hwDec.dequeueOutputBuffer(codecInfo, 2_000L)
                                if (outIdx == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                                    didWork = true
                                } else if (outIdx >= 0) {
                                    didWork = true
                                    val isEos = (codecInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0
                                    val isCodecConfig = (codecInfo.flags and MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0
                                    // On Android Codec2 (c2.qti.*, c2.exynos.*, c2.mtk.*), Surface-bound video decoders
                                    // report codecInfo.size == 0 on valid ANativeWindow frames; only (isEos && size == 0) is empty EOS!
                                    val hasDecodedSurfaceFrame = !isCodecConfig && !(isEos && codecInfo.size == 0)
                                    val framePtsUs = codecInfo.presentationTimeUs
                                    val shouldRender = hasDecodedSurfaceFrame &&
                                        framePtsUs >= minEmitMediaTimeUs &&
                                        (lastRenderedVideoPtsUs == Long.MIN_VALUE ||
                                         (framePtsUs - lastRenderedVideoPtsUs) >= minVideoFrameStepUs ||
                                         framePtsUs < lastRenderedVideoPtsUs)

                                    hwDec.releaseOutputBuffer(outIdx, shouldRender)
                                    if (shouldRender) {
                                        if (anchoredMediaStartUs == Long.MIN_VALUE) {
                                            anchoredMediaStartUs = framePtsUs
                                        }
                                        lastRenderedVideoPtsUs = framePtsUs
                                        if (surface.awaitNewImage(900L)) {
                                            val cues = if (wantBurnSubtitles) {
                                                subtitleCollector.getActiveCuesAt(framePtsUs)
                                            } else {
                                                emptyList()
                                            }
                                            surface.drawFrameAndSwap(framePtsUs, cues)
                                            drainVideoEncoderNonBlocking()
                                        }
                                    }
                                    if (isEos) {
                                        videoDecoderOutputEos = true
                                        videoEncoder?.signalEndOfInputStream()
                                    }
                                }
                            }
                        } else if (ffDec != null) {
                            while (!videoDecoderInputEos && videoQueue.isNotEmpty()) {
                                val next = videoQueue.peekFirst()!!
                                if (!seenFirstInputKeyFrame) {
                                    if (!next.isKeyFrame) {
                                        videoQueue.pollFirst()
                                        didWork = true
                                        continue
                                    }
                                    seenFirstInputKeyFrame = true
                                    while (audioQueue.isNotEmpty() && audioQueue.peekFirst()!!.timeUs + 150_000L < next.timeUs) {
                                        audioQueue.pollFirst()
                                    }
                                }
                                if (ffDec.queueSample(next.data, 0, next.data.size, next.timeUs, next.isKeyFrame)) {
                                    videoQueue.pollFirst()
                                    didWork = true
                                } else {
                                    break
                                }
                            }
                            if (!videoDecoderInputEos && extractorEof && videoQueue.isEmpty()) {
                                if (ffDec.queueEndOfStream()) {
                                    videoDecoderInputEos = true
                                    didWork = true
                                }
                            }
                            if (!videoDecoderOutputEos && readyVideoFrames.size < 24) {
                                when (val res = ffDec.drainAndRenderOneFrame(surface.decoderOutputSurface)) {
                                    is CineflixFfmpegVideoDecoder.DrainResult.RenderedFrame -> {
                                        didWork = true
                                        val framePtsUs = res.timeUs
                                        if (surface.awaitNewImage(900L)) {
                                            if (framePtsUs >= minEmitMediaTimeUs &&
                                                (lastRenderedVideoPtsUs == Long.MIN_VALUE ||
                                                 (framePtsUs - lastRenderedVideoPtsUs) >= minVideoFrameStepUs)
                                            ) {
                                                if (anchoredMediaStartUs == Long.MIN_VALUE) {
                                                    anchoredMediaStartUs = framePtsUs
                                                }
                                                lastRenderedVideoPtsUs = framePtsUs
                                                val cues = if (wantBurnSubtitles) {
                                                    subtitleCollector.getActiveCuesAt(framePtsUs)
                                                } else {
                                                    emptyList()
                                                }
                                                surface.drawFrameAndSwap(framePtsUs, cues)
                                                drainVideoEncoderNonBlocking()
                                            }
                                        }
                                    }
                                    is CineflixFfmpegVideoDecoder.DrainResult.SkippedFrame -> {
                                        didWork = true
                                    }
                                    is CineflixFfmpegVideoDecoder.DrainResult.EndOfStream -> {
                                        didWork = true
                                        videoDecoderOutputEos = true
                                        videoEncoder?.signalEndOfInputStream()
                                    }
                                    is CineflixFfmpegVideoDecoder.DrainResult.NoneReady -> {}
                                }
                            }
                        }

                        drainVideoEncoderNonBlocking()
                    }
                }

                // C. Process Audio (FFmpeg / MediaCodec -> Stereo 16-bit PCM -> Hardware AAC-LC ADTS)
                if (hasAudio && !aacEncoderOutputEos && (!hasVideo || anchoredMediaStartUs != Long.MIN_VALUE || videoQueue.size >= 8)) {
                    drainAacEncoderNonBlocking()

                    val ffAud = ffmpegAudioDecoder
                    val hwAud = hwAudioDecoder

                    if (ffAud != null) {
                        if (!audioDecoderOutputEos && pendingStereoPcmChunks.size < 16) {
                            while (!audioDecoderInputEos && audioQueue.isNotEmpty()) {
                                val next = audioQueue.peekFirst()!!
                                if (ffAud.queueSample(next.data, 0, next.data.size, next.timeUs, next.isKeyFrame)) {
                                    audioQueue.pollFirst()
                                    didWork = true
                                } else {
                                    break
                                }
                            }
                            if (!audioDecoderInputEos && extractorEof && audioQueue.isEmpty()) {
                                if (ffAud.queueEndOfStream()) {
                                    audioDecoderInputEos = true
                                    didWork = true
                                }
                            }
                            val reachedEos = ffAud.drainPcm { pcmBytes, sr, ch, ptsUs ->
                                didWork = true
                                enqueueDecodedPcm(pcmBytes, sr, ch, ptsUs)
                            }
                            if (reachedEos) {
                                audioDecoderOutputEos = true
                                didWork = true
                            }
                        }
                    } else if (hwAud != null) {
                        if (!audioDecoderOutputEos && pendingStereoPcmChunks.size < 16) {
                            while (!audioDecoderInputEos && audioQueue.isNotEmpty()) {
                                val inIdx = hwAud.dequeueInputBuffer(0L)
                                if (inIdx < 0) break
                                val sample = audioQueue.pollFirst()!!
                                val inBuf = hwAud.getInputBuffer(inIdx)!!
                                inBuf.clear()
                                inBuf.put(sample.data)
                                hwAud.queueInputBuffer(inIdx, 0, sample.data.size, sample.timeUs, 0)
                                didWork = true
                            }
                            if (!audioDecoderInputEos && extractorEof && audioQueue.isEmpty()) {
                                val inIdx = hwAud.dequeueInputBuffer(0L)
                                if (inIdx >= 0) {
                                    hwAud.queueInputBuffer(inIdx, 0, 0, 0L, MediaCodec.BUFFER_FLAG_END_OF_STREAM)
                                    audioDecoderInputEos = true
                                    didWork = true
                                }
                            }
                            while (!audioDecoderOutputEos) {
                                val outIdx = hwAud.dequeueOutputBuffer(codecInfo, 0L)
                                if (outIdx >= 0) {
                                    didWork = true
                                    try {
                                        if (codecInfo.size > 0) {
                                            val outBuf = hwAud.getOutputBuffer(outIdx)
                                            if (outBuf != null) {
                                                val pcm = copyByteBuffer(outBuf, codecInfo.offset, codecInfo.size)
                                                val fmt = hwAud.outputFormat
                                                val sr = if (fmt.containsKey(MediaFormat.KEY_SAMPLE_RATE)) {
                                                    fmt.getInteger(MediaFormat.KEY_SAMPLE_RATE)
                                                } else targetAacSampleRate
                                                val ch = if (fmt.containsKey(MediaFormat.KEY_CHANNEL_COUNT)) {
                                                    fmt.getInteger(MediaFormat.KEY_CHANNEL_COUNT)
                                                } else 2
                                                enqueueDecodedPcm(pcm, sr, ch, codecInfo.presentationTimeUs)
                                            }
                                        }
                                        if ((codecInfo.flags and MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                                            audioDecoderOutputEos = true
                                        }
                                    } finally {
                                        hwAud.releaseOutputBuffer(outIdx, false)
                                    }
                                } else {
                                    break
                                }
                            }
                        }
                    }

                    // Feed Stereo 16-bit PCM into hardware AAC-LC encoder (4 bytes per stereo frame)
                    val aacEnc = aacEncoder
                    if (aacEnc != null && !aacEncoderInputEos && anchoredMediaStartUs != Long.MIN_VALUE) {
                        while (true) {
                            if (currentPcmChunk == null || currentPcmChunkOffset >= currentPcmChunk!!.size) {
                                currentPcmChunk = pendingStereoPcmChunks.pollFirst()
                                currentPcmChunkOffset = 0
                            }
                            val chunk = currentPcmChunk
                            if (chunk == null) {
                                if (audioDecoderOutputEos) {
                                    val inIdx = aacEnc.dequeueInputBuffer(0L)
                                    if (inIdx >= 0) {
                                        val ptsUs = (if (audioPtsBaseUs != Long.MIN_VALUE) audioPtsBaseUs else anchoredMediaStartUs) +
                                            ((totalStereoFramesFedToAac * 1_000_000L) / targetAacSampleRate)
                                        aacEnc.queueInputBuffer(inIdx, 0, 0, ptsUs, MediaCodec.BUFFER_FLAG_END_OF_STREAM)
                                        aacEncoderInputEos = true
                                        didWork = true
                                    }
                                }
                                break
                            }

                            val inIdx = aacEnc.dequeueInputBuffer(0L)
                            if (inIdx < 0) break
                            val inBuf = aacEnc.getInputBuffer(inIdx)!!
                            inBuf.clear()

                            val maxAlignedCap = inBuf.remaining() - (inBuf.remaining() % 4)
                            val remInChunk = chunk.size - currentPcmChunkOffset
                            val copyBytes = min(maxAlignedCap, remInChunk - (remInChunk % 4))
                            if (copyBytes <= 0) {
                                currentPcmChunk = null
                                continue
                            }

                            inBuf.put(chunk, currentPcmChunkOffset, copyBytes)
                            currentPcmChunkOffset += copyBytes

                            val baseUs = if (audioPtsBaseUs != Long.MIN_VALUE) audioPtsBaseUs else anchoredMediaStartUs
                            val ptsUs = baseUs + ((totalStereoFramesFedToAac * 1_000_000L) / targetAacSampleRate)
                            totalStereoFramesFedToAac += (copyBytes / 4)

                            aacEnc.queueInputBuffer(inIdx, 0, copyBytes, ptsUs, 0)
                            didWork = true
                        }
                    }

                    drainAacEncoderNonBlocking()
                }

                // D. Interleave & emit MPEG-TS packets
                flushInterleavedToMpegTs(forceFlushAll = false)

                if (!didWork) {
                    try {
                        Thread.sleep(2L)
                    } catch (_: InterruptedException) {
                        Thread.currentThread().interrupt()
                        break
                    }
                }
            }

            if (!cancelled.get()) {
                flushNormalizedVideoFrames()
                flushInterleavedToMpegTs(forceFlushAll = true)
                muxer.flush()
                Log.i(TAG, "🏁 LiveTranscodeSession completed cleanly ($totalProducedBytes TS bytes emitted)")
            }
        } finally {
            try { dataSource.close() } catch (_: Throwable) {}
            try { extractor?.release() } catch (_: Throwable) {}
            hwVideoDecoder?.let { safeReleaseCodec(it) }
            ffmpegVideoDecoder?.release()
            videoEncoder?.let { safeReleaseCodec(it) }
            eglSurface?.release()
            ffmpegAudioDecoder?.release()
            hwAudioDecoder?.let { safeReleaseCodec(it) }
            aacEncoder?.let { safeReleaseCodec(it) }
        }
    }

    private fun isUnsupportedPassthroughAvcProfile(format: Format): Boolean {
        val codecs = format.codecs?.lowercase(Locale.ROOT) ?: return false
        // avc1.6e... = High 10 Profile (110 = 0x6E), avc1.7a... = High 4:2:2, avc1.f4... = High 4:4:4
        if (codecs.startsWith("avc1.6e") || codecs.startsWith("avc1.7a") || codecs.startsWith("avc1.f4")) {
            return true
        }
        // Check H.264 level_idc > 42 (0x2A = Level 4.2); e.g. Level 5.0 (0x32) / Level 5.1 (0x33)
        if (codecs.startsWith("avc1.") && codecs.length >= 11) {
            val levelHex = codecs.substring(9, 11).toIntOrNull(16)
            if (levelHex != null && levelHex > 0x2A) {
                return true
            }
        }
        return false
    }

    private fun createStartedHardwareVideoDecoder(format: Format, outputSurface: android.view.Surface): MediaCodec {
        val mime = format.sampleMimeType ?: throw IOException("Missing video sampleMimeType")
        val mediaFormat = MediaFormatUtil.createMediaFormatFromFormat(format)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try { mediaFormat.setInteger(MediaFormat.KEY_PRIORITY, 0) } catch (_: Throwable) {}
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            // Request hardware HDR10/HLG -> 8-bit SDR tone-mapping when decoding 10-bit HEVC into SurfaceTexture
            try {
                mediaFormat.setInteger(
                    MediaFormat.KEY_COLOR_TRANSFER_REQUEST,
                    MediaFormat.COLOR_TRANSFER_SDR_VIDEO
                )
            } catch (_: Throwable) {}
        }

        // Prefer dedicated hardware decoder over Android c2.android.* software decoder
        val preferredHwName = findHardwareDecoderName(mime)
        val codec = if (preferredHwName != null) {
            MediaCodec.createByCodecName(preferredHwName)
        } else {
            MediaCodec.createDecoderByType(mime)
        }
        try {
            codec.configure(mediaFormat, outputSurface, null, 0)
            codec.start()
            return codec
        } catch (t: Throwable) {
            safeReleaseCodec(codec)
            throw t
        }
    }

    private fun findHardwareDecoderName(mimeType: String): String? {
        return try {
            val list = MediaCodecList(MediaCodecList.REGULAR_CODECS)
            for (info in list.codecInfos) {
                if (info.isEncoder) continue
                val supported = info.supportedTypes.any { it.equals(mimeType, ignoreCase = true) }
                if (!supported) continue
                val isHw = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    info.isHardwareAccelerated
                } else {
                    val lower = info.name.lowercase(Locale.ROOT)
                    !lower.startsWith("omx.google.") &&
                        !lower.startsWith("c2.android.") &&
                        !lower.contains(".sw.")
                }
                if (isHw) return info.name
            }
            null
        } catch (_: Throwable) {
            null
        }
    }

    private fun createConfiguredH264SurfaceEncoder(
        width: Int,
        height: Int,
        bitrate: Int,
        frameRate: Int
    ): MediaCodec {
        val profilesToTry = listOf(
            MediaCodecInfo.CodecProfileLevel.AVCProfileMain to MediaCodecInfo.CodecProfileLevel.AVCLevel4,
            MediaCodecInfo.CodecProfileLevel.AVCProfileHigh to MediaCodecInfo.CodecProfileLevel.AVCLevel4,
            null
        )

        var lastError: Throwable? = null
        for (profilePair in profilesToTry) {
            val encoder = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264)
            try {
                val fmt = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, width, height).apply {
                    setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface)
                    setInteger(MediaFormat.KEY_BIT_RATE, bitrate)
                    setInteger(MediaFormat.KEY_FRAME_RATE, frameRate)
                    setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, H264_IFRAME_INTERVAL_SEC)
                    if (profilePair != null) {
                        setInteger(MediaFormat.KEY_PROFILE, profilePair.first)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            setInteger(MediaFormat.KEY_LEVEL, profilePair.second)
                        }
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setInteger(MediaFormat.KEY_PRIORITY, 0)
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        // Zero B-frames -> 1-frame ultra-low encoder latency and monotonic PTS == DTS!
                        setInteger(MediaFormat.KEY_MAX_B_FRAMES, 0)
                    }
                }
                encoder.configure(fmt, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
                return encoder
            } catch (t: Throwable) {
                lastError = t
                safeReleaseCodec(encoder)
            }
        }
        throw IOException("Unable to configure hardware H.264 encoder (${width}x${height}): ${lastError?.message}", lastError)
    }

    private fun createStartedHardwareAudioDecoder(format: Format): MediaCodec {
        val mime = format.sampleMimeType ?: throw IOException("Missing audio sampleMimeType")
        val mediaFormat = MediaFormatUtil.createMediaFormatFromFormat(format)
        val codec = MediaCodec.createDecoderByType(mime)
        try {
            codec.configure(mediaFormat, null, null, 0)
            codec.start()
            return codec
        } catch (t: Throwable) {
            safeReleaseCodec(codec)
            throw t
        }
    }

    private fun createStartedAacEncoder(sampleRate: Int, channelCount: Int, bitrate: Int): MediaCodec {
        val encoder = MediaCodec.createEncoderByType(MimeTypes.AUDIO_AAC)
        try {
            val fmt = MediaFormat.createAudioFormat(MimeTypes.AUDIO_AAC, sampleRate, channelCount).apply {
                setInteger(MediaFormat.KEY_AAC_PROFILE, MediaCodecInfo.CodecProfileLevel.AACObjectLC)
                setInteger(MediaFormat.KEY_BIT_RATE, bitrate)
                setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 32768)
            }
            encoder.configure(fmt, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE)
            encoder.start()
            return encoder
        } catch (t: Throwable) {
            safeReleaseCodec(encoder)
            throw t
        }
    }

    private fun copyByteBuffer(buf: ByteBuffer, offset: Int = buf.position(), size: Int = buf.remaining()): ByteArray {
        val dup = buf.duplicate()
        dup.position(offset)
        dup.limit(offset + size)
        val out = ByteArray(size)
        dup.get(out)
        return out
    }

    private fun safeReleaseCodec(codec: MediaCodec) {
        try { codec.stop() } catch (_: Throwable) {}
        try { codec.release() } catch (_: Throwable) {}
    }

    /**
     * Locates the Matroska `<Cluster>` (`0x1F 0x43 0xB6 0x75`) matching [targetTimeUs] without reading EOF `<Cues>`.
     * Inspects each candidate `<Cluster>`'s `<Timecode>` (`0xE7`) so variable-bitrate (VBR) movies and short
     * `+10s`/`+30s` relative jumps always advance to the true target timestamp instead of landing behind.
     */
    private fun findMatroskaClusterForTargetTimeUs(
        targetTimeUs: Long,
        durationUs: Long,
        totalFileSize: Long
    ): Long {
        if (targetTimeUs <= 0L || durationUs <= 0L || totalFileSize <= 65536L) return 0L
        val targetTimeMs = targetTimeUs / 1000L
        val durationMs = (durationUs / 1000L).coerceAtLeast(1L)
        val avgBytesPerMs = totalFileSize.toDouble() / durationMs.toDouble()
        var guessOffset = ((targetTimeUs.toDouble() / durationUs.toDouble()).coerceIn(0.0, 0.985) * totalFileSize.toDouble())
            .toLong()
            .coerceIn(0L, max(0L, totalFileSize - 262_144L))

        var bestClusterOffset = findNearestMatroskaClusterOffset(guessOffset, totalFileSize)

        for (step in 0 until 2) {
            if (cancelled.get()) break
            val (clusterOff, clusterTimeMs) = findClusterAndTimecodeAtOrAfter(
                startOffset = guessOffset,
                totalFileSize = totalFileSize,
                targetTimeMs = targetTimeMs
            )
            if (clusterOff <= 0L) break
            bestClusterOffset = clusterOff
            if (clusterTimeMs < 0L) break

            val diffMs = targetTimeMs - clusterTimeMs
            if (diffMs in -6_000L..8_000L) {
                break
            }
            val effectiveBytesPerMs = if (clusterTimeMs > 5_000L && clusterOff > 262_144L) {
                (clusterOff.toDouble() / clusterTimeMs.toDouble()).coerceIn(avgBytesPerMs * 0.25, avgBytesPerMs * 3.5)
            } else {
                avgBytesPerMs
            }
            val deltaBytes = (diffMs.toDouble() * effectiveBytesPerMs).toLong()
            val nextGuess = (clusterOff + deltaBytes).coerceIn(4096L, max(4096L, totalFileSize - 262_144L))
            if (abs(nextGuess - guessOffset) < 65_536L) break
            guessOffset = nextGuess
        }

        return bestClusterOffset
    }

    private fun findClusterAndTimecodeAtOrAfter(
        startOffset: Long,
        totalFileSize: Long,
        targetTimeMs: Long
    ): Pair<Long, Long> {
        val chunkSize = 256 * 1024
        val buf = ByteArray(chunkSize)
        var scanPos = startOffset.coerceIn(0L, max(0L, totalFileSize - 65536L))
        val maxScanEnd = min(totalFileSize, scanPos + 4L * 1024L * 1024L)
        var firstFoundOffset = -1L
        var firstFoundTimeMs = -1L

        while (scanPos + 16L < maxScanEnd && !cancelled.get()) {
            val want = min(chunkSize.toLong(), totalFileSize - scanPos).toInt()
            if (want < 16) break
            val read = directByteReader(scanPos, buf, 0, want) { cancelled.get() }
            if (read < 16) break

            var i = 0
            while (i + 16 < read) {
                if (buf[i] == 0x1F.toByte() &&
                    buf[i + 1] == 0x43.toByte() &&
                    buf[i + 2] == 0xB6.toByte() &&
                    buf[i + 3] == 0x75.toByte()
                ) {
                    val sizeByte0 = buf[i + 4].toInt() and 0xFF
                    if (sizeByte0 != 0) {
                        var mask = 0x80
                        var sizeLen = 1
                        while (sizeLen <= 8 && (sizeByte0 and mask) == 0) {
                            mask = mask shr 1
                            sizeLen++
                        }
                        if (sizeLen in 1..8 && i + 4 + sizeLen < read) {
                            val childId0 = buf[i + 4 + sizeLen].toInt() and 0xFF
                            if (childId0 == 0xE7 || childId0 == 0xA3 || childId0 == 0xA0 ||
                                childId0 == 0xAB || childId0 == 0xA7 || childId0 == 0xBF || childId0 == 0xEC
                            ) {
                                val clusterGlobalOff = scanPos + i
                                val timecodeMs = MatroskaEbmlTrackPatcher.readClusterTimecodeTicks(buf, i, read)
                                if (firstFoundOffset < 0L) {
                                    firstFoundOffset = clusterGlobalOff
                                    firstFoundTimeMs = timecodeMs
                                }
                                // If this Cluster is slightly behind targetTimeMs (e.g. within 35s), keep scanning
                                // within the already-read buffer/window to pick the Cluster closest to targetTimeMs!
                                if (timecodeMs < 0L || timecodeMs >= targetTimeMs - 2_000L || (targetTimeMs - timecodeMs) > 40_000L) {
                                    return Pair(clusterGlobalOff, timecodeMs)
                                }
                                firstFoundOffset = clusterGlobalOff
                                firstFoundTimeMs = timecodeMs
                            }
                        }
                    }
                }
                i++
            }
            if (firstFoundOffset >= 0L && (firstFoundTimeMs < 0L || (targetTimeMs - firstFoundTimeMs) > 40_000L)) {
                return Pair(firstFoundOffset, firstFoundTimeMs)
            }
            if (read < 16) break
            scanPos += (read - 16)
        }
        return if (firstFoundOffset >= 0L) Pair(firstFoundOffset, firstFoundTimeMs) else Pair(startOffset, -1L)
    }

    /**
     * Scans forward from [approxByteOffset] (up to 4 MB) to locate the exact byte offset of the nearest
     * valid Matroska `<Cluster>` (`0x1F 0x43 0xB6 0x75`) element.
     * Media3's `DefaultEbmlReader` does NOT scan for `<Cluster>` sync markers after an unindexed seek:
     * if `reopenInputAt(offset)` lands on a random byte where `(byte & 0xFF) < 0x08` (which occurs 93.75%
     * of the time on compressed media), `VarintReader` returns `C.RESULT_MAX_LENGTH_EXCEEDED` and throws `EOFException`!
     */
    private fun findNearestMatroskaClusterOffset(approxByteOffset: Long, totalFileSize: Long): Long {
        if (approxByteOffset <= 0L || totalFileSize <= 65536L) return 0L
        val chunkSize = 256 * 1024
        val buf = ByteArray(chunkSize)
        var scanPos = approxByteOffset.coerceIn(0L, max(0L, totalFileSize - 65536L))
        val maxScanEnd = min(totalFileSize, scanPos + 4L * 1024L * 1024L)

        while (scanPos + 16L < maxScanEnd && !cancelled.get()) {
            val want = min(chunkSize.toLong(), totalFileSize - scanPos).toInt()
            if (want < 16) break
            val read = directByteReader(scanPos, buf, 0, want) { cancelled.get() }
            if (read < 16) break

            var i = 0
            while (i + 12 < read) {
                if (buf[i] == 0x1F.toByte() &&
                    buf[i + 1] == 0x43.toByte() &&
                    buf[i + 2] == 0xB6.toByte() &&
                    buf[i + 3] == 0x75.toByte()
                ) {
                    val sizeByte0 = buf[i + 4].toInt() and 0xFF
                    if (sizeByte0 != 0) {
                        var mask = 0x80
                        var sizeLen = 1
                        while (sizeLen <= 8 && (sizeByte0 and mask) == 0) {
                            mask = mask shr 1
                            sizeLen++
                        }
                        if (sizeLen in 1..8 && i + 4 + sizeLen < read) {
                            val childId0 = buf[i + 4 + sizeLen].toInt() and 0xFF
                            // Valid first child inside <Cluster>: Timecode (0xE7), SimpleBlock (0xA3),
                            // BlockGroup (0xA0), PrevSize (0xAB), Position (0xA7), CRC-32 (0xBF), Void (0xEC)
                            if (childId0 == 0xE7 || childId0 == 0xA3 || childId0 == 0xA0 ||
                                childId0 == 0xAB || childId0 == 0xA7 || childId0 == 0xBF || childId0 == 0xEC
                            ) {
                                return scanPos + i
                            }
                        }
                    }
                }
                i++
            }
            if (read < 16) break
            scanPos += (read - 12)
        }
        return approxByteOffset
    }
}
