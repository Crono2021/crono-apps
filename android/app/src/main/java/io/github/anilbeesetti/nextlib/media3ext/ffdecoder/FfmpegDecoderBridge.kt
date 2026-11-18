package io.github.anilbeesetti.nextlib.media3ext.ffdecoder

import android.os.Handler
import android.view.Surface
import androidx.media3.common.C
import androidx.media3.common.Format
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.TraceUtil
import androidx.media3.common.util.Util
import androidx.media3.decoder.CryptoConfig
import androidx.media3.exoplayer.RendererCapabilities
import androidx.media3.exoplayer.audio.AudioRendererEventListener
import androidx.media3.exoplayer.audio.AudioSink
import androidx.media3.exoplayer.audio.DecoderAudioRenderer
import kotlin.math.max
import kotlin.math.min

/**
 * Sanitizes a Media3 [Format] before passing it to NextLib's [FfmpegAudioDecoder] so that:
 * 1. `audio/vorbis` with `< 2` `initializationData` entries never triggers an uncaught
 *    `IndexOutOfBoundsException` inside `FfmpegAudioDecoder.getVorbisExtraData()`.
 * 2. Self-contained frame codecs (`audio/eac3`, `audio/eac3-joc`, `audio/ac3`, `audio/vnd.dts`,
 *    `audio/vnd.dts.hd`, `audio/true-hd`, `audio/mpeg`) have any non-standard Matroska CodecPrivate
 *    bytes stripped so `avcodec_open2` never fails on bogus extradata.
 */
internal fun sanitizeAudioFormatForFfmpeg(format: Format): Format {
    val mime = format.sampleMimeType ?: return format
    val initData = format.initializationData
    return when (mime) {
        MimeTypes.AUDIO_VORBIS -> {
            if (initData.size < 2) {
                // FfmpegAudioDecoder.getVorbisExtraData(initializationData) unconditionally indexes
                // initializationData[0] and initializationData[1]; if fewer than 2 exist, clear to
                // empty so getExtraData() safely returns null instead of throwing IndexOutOfBoundsException.
                format.buildUpon().setInitializationData(emptyList()).build()
            } else {
                format
            }
        }
        MimeTypes.AUDIO_E_AC3,
        MimeTypes.AUDIO_E_AC3_JOC,
        MimeTypes.AUDIO_AC3,
        MimeTypes.AUDIO_DTS,
        MimeTypes.AUDIO_DTS_HD,
        MimeTypes.AUDIO_DTS_EXPRESS,
        MimeTypes.AUDIO_TRUEHD,
        MimeTypes.AUDIO_MPEG -> {
            if (initData.isNotEmpty()) {
                format.buildUpon().setInitializationData(emptyList()).build()
            } else {
                format
            }
        }
        else -> format
    }
}

/**
 * Sanitizes a Media3 [Format] before passing it to NextLib's [FfmpegVideoDecoder] so that
 * `video/avc` with a single `avcC` `initializationData` entry never triggers an uncaught
 * `IndexOutOfBoundsException` inside `FfmpegVideoDecoder.getExtraData()` (which unconditionally
 * accesses `initializationData.get(0)` AND `initializationData.get(1)` when `initializationData`
 * is non-empty).
 */
internal fun sanitizeVideoFormatForFfmpeg(format: Format): Format {
    val mime = format.sampleMimeType ?: return format
    val initData = format.initializationData
    if (mime == MimeTypes.VIDEO_H264 && initData.size == 1) {
        val avcC = initData[0]
        return format.buildUpon()
            .setInitializationData(listOf(avcC, ByteArray(0)))
            .build()
    }
    return format
}

/**
 * Safe replacement for NextLib's [FfmpegAudioRenderer] that:
 * 1. Forces 16-bit integer PCM output (`C.ENCODING_PCM_16BIT`, `outputFloat = false`) for ALL codecs
 *    including 5.1/7.1 `E-AC3`, `AC3`, `DTS`, `TrueHD`, `Opus`, `FLAC`, and `AAC`, avoiding the
 *    `FfmpegAudioRenderer.shouldOutputFloat` bug where `audio/eac3` 5.1 output 6-channel 32-bit float PCM
 *    that fails on many Android `AudioTrack` / `DefaultAudioSink` configurations.
 * 2. Sanitizes `Format.initializationData` via [sanitizeAudioFormatForFfmpeg] before creating
 *    [FfmpegAudioDecoder] so malformed Matroska `CodecPrivate` data never crashes the player.
 */
fun createCineflixSafeFfmpegAudioRenderer(
    eventHandler: Handler? = null,
    eventListener: AudioRendererEventListener? = null,
    audioSink: AudioSink
): androidx.media3.exoplayer.Renderer {
    return CineflixSafeFfmpegAudioRenderer(eventHandler, eventListener, audioSink)
}

private class CineflixSafeFfmpegAudioRenderer(
    eventHandler: Handler? = null,
    eventListener: AudioRendererEventListener? = null,
    audioSink: AudioSink
) : DecoderAudioRenderer<FfmpegAudioDecoder>(eventHandler, eventListener, audioSink) {

    companion object {
        private const val TAG = "CineflixFfmpegAudioRenderer"
        private const val NUM_BUFFERS = 16
        private const val DEFAULT_INPUT_BUFFER_SIZE = 16 * 1024
    }

    override fun getName(): String = TAG

    override fun supportsFormatInternal(format: Format): Int {
        val mimeType = format.sampleMimeType ?: return C.FORMAT_UNSUPPORTED_TYPE
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isAudio(mimeType)) {
            return C.FORMAT_UNSUPPORTED_TYPE
        }
        if (format.cryptoType != C.CRYPTO_TYPE_NONE) {
            return C.FORMAT_UNSUPPORTED_DRM
        }
        if (!FfmpegLibrary.supportsFormat(mimeType)) {
            return C.FORMAT_UNSUPPORTED_SUBTYPE
        }
        val channels = if (format.channelCount != Format.NO_VALUE && format.channelCount > 0) {
            format.channelCount
        } else {
            2
        }
        val sampleRate = if (format.sampleRate != Format.NO_VALUE && format.sampleRate > 0) {
            format.sampleRate
        } else {
            48_000
        }
        val pcm16Format = Util.getPcmFormat(C.ENCODING_PCM_16BIT, channels, sampleRate)
        if (!sinkSupportsFormat(pcm16Format)) {
            // Even if raw N-channel isn't directly supported, ChannelMixingAudioProcessor downmixes 1..8 -> 2
            val stereoFormat = Util.getPcmFormat(C.ENCODING_PCM_16BIT, 2, sampleRate)
            if (!sinkSupportsFormat(stereoFormat)) {
                return C.FORMAT_UNSUPPORTED_SUBTYPE
            }
        }
        return C.FORMAT_HANDLED or
            RendererCapabilities.ADAPTIVE_SEAMLESS or
            RendererCapabilities.TUNNELING_SUPPORTED
    }

    override fun supportsMixedMimeTypeAdaptation(): Int = RendererCapabilities.ADAPTIVE_NOT_SEAMLESS

    override fun createDecoder(format: Format, cryptoConfig: CryptoConfig?): FfmpegAudioDecoder {
        TraceUtil.beginSection("createFfmpegAudioDecoder")
        try {
            val initialInputBufferSize = if (format.maxInputSize != Format.NO_VALUE && format.maxInputSize > 0) {
                max(format.maxInputSize, DEFAULT_INPUT_BUFFER_SIZE)
            } else {
                DEFAULT_INPUT_BUFFER_SIZE
            }
            val safeFormat = sanitizeAudioFormatForFfmpeg(format)
            return FfmpegAudioDecoder(
                safeFormat,
                NUM_BUFFERS,
                NUM_BUFFERS,
                initialInputBufferSize,
                /* outputFloat = */ false
            )
        } finally {
            TraceUtil.endSection()
        }
    }

    override fun getOutputFormat(decoder: FfmpegAudioDecoder): Format {
        return Util.getPcmFormat(
            decoder.encoding,
            decoder.channelCount,
            decoder.sampleRate
        )
    }
}

/**
 * Compile-time type-safe bridge into NextLib's bundled FFmpeg (`libavcodec` + `libswresample` + `libswscale`)
 * package-private `SimpleDecoder` implementations ([FfmpegAudioDecoder] and [FfmpegVideoDecoder]).
 *
 * Used by Cineflix's real-time on-phone chunk transcoder so ANY audio codec (`DTS`, `DTS-HD`, `TrueHD`,
 * `E-AC3`, `AC3`, `FLAC`, `Opus`, `Vorbis`, `AAC`, `MP3`, `ALAC`) and ANY exotic video codec (`HEVC 10-bit`,
 * `AV1`, `VP9`, `Hi10p`, `MPEG-2`) can be decoded directly on the phone while streaming live `MPEG-TS`
 * to legacy or codec-restricted Smart TVs.
 */
class CineflixFfmpegAudioDecoder(format: Format) {

    companion object {
        private const val NUM_BUFFERS = 16
        private const val DEFAULT_INPUT_BUFFER_SIZE = 16 * 1024

        fun isSupported(format: Format): Boolean {
            val mime = format.sampleMimeType ?: return false
            return try {
                FfmpegLibrary.isAvailable() && FfmpegLibrary.supportsFormat(mime)
            } catch (_: Throwable) {
                false
            }
        }
    }

    private val initialInputSize = if (format.maxInputSize != Format.NO_VALUE && format.maxInputSize > 0) {
        max(format.maxInputSize, DEFAULT_INPUT_BUFFER_SIZE)
    } else {
        DEFAULT_INPUT_BUFFER_SIZE
    }

    private val decoder = FfmpegAudioDecoder(
        sanitizeAudioFormatForFfmpeg(format),
        NUM_BUFFERS,
        NUM_BUFFERS,
        initialInputSize,
        /* outputFloat = */ false // Always output 16-bit signed little-endian PCM (C.ENCODING_PCM_16BIT)
    )

    private val paddingSize: Int = try {
        max(0, FfmpegLibrary.getInputBufferPaddingSize())
    } catch (_: Throwable) {
        64
    }

    val channelCount: Int
        get() = decoder.channelCount

    val sampleRate: Int
        get() = decoder.sampleRate

    val pcmEncoding: Int
        get() = decoder.encoding

    fun setOutputStartTimeUs(startTimeUs: Long) {
        decoder.setOutputStartTimeUs(startTimeUs)
    }

    /**
     * Attempts to queue one compressed audio sample. Returns `false` if all input buffers are currently
     * full (caller should call [drainPcm] and retry).
     */
    fun queueSample(
        data: ByteArray,
        offset: Int = 0,
        length: Int = data.size,
        timeUs: Long,
        isKeyFrame: Boolean = true
    ): Boolean {
        val inBuf = decoder.dequeueInputBuffer() ?: return false
        inBuf.clear()
        inBuf.timeUs = timeUs
        if (isKeyFrame) {
            inBuf.addFlag(C.BUFFER_FLAG_KEY_FRAME)
        }
        inBuf.ensureSpaceForWrite(length + paddingSize)
        val buf = inBuf.data!!
        buf.put(data, offset, length)
        if (paddingSize > 0 && buf.remaining() >= paddingSize) {
            val lim = buf.position()
            for (i in 0 until paddingSize) {
                buf.put(lim + i, 0)
            }
        }
        inBuf.flip()
        decoder.queueInputBuffer(inBuf)
        return true
    }

    /**
     * Queues End-Of-Stream marker. Returns `false` if no input buffer is currently free.
     */
    fun queueEndOfStream(): Boolean {
        val inBuf = decoder.dequeueInputBuffer() ?: return false
        inBuf.clear()
        inBuf.addFlag(C.BUFFER_FLAG_END_OF_STREAM)
        decoder.queueInputBuffer(inBuf)
        return true
    }

    /**
     * Drains all currently decoded 16-bit PCM buffers.
     * Returns `true` if the End-Of-Stream output buffer was reached.
     */
    fun drainPcm(
        onPcmChunk: (pcm16LeBytes: ByteArray, sampleRate: Int, channelCount: Int, timeUs: Long) -> Unit
    ): Boolean {
        while (true) {
            val outBuf = decoder.dequeueOutputBuffer() ?: return false
            try {
                if (outBuf.isEndOfStream) {
                    return true
                }
                if (!outBuf.shouldBeSkipped) {
                    val byteBuf = outBuf.data
                    if (byteBuf != null && byteBuf.remaining() > 0) {
                        val bytes = ByteArray(byteBuf.remaining())
                        byteBuf.get(bytes)
                        val sr = decoder.sampleRate
                        val ch = decoder.channelCount
                        if (sr > 0 && ch > 0) {
                            onPcmChunk(bytes, sr, ch, outBuf.timeUs)
                        }
                    }
                }
            } finally {
                outBuf.release()
            }
        }
    }

    fun flush() {
        decoder.flush()
    }

    fun release() {
        try {
            decoder.release()
        } catch (_: Throwable) {}
    }
}

/**
 * Software FFmpeg video decoder fallback rendering directly into an Android [Surface]
 * (e.g. `EglTranscodeSurface.decoderInputSurface`) when a phone lacks a hardware `MediaCodec`
 * decoder for an exotic video profile (such as `Hi10p`, `AV1`, or `MPEG-2`).
 */
class CineflixFfmpegVideoDecoder(format: Format) {

    companion object {
        private const val NUM_INPUT_BUFFERS = 6
        private const val NUM_OUTPUT_BUFFERS = 6
        private const val DEFAULT_VIDEO_INPUT_SIZE = 786_432 // 768 KB

        fun isSupported(format: Format): Boolean {
            val mime = format.sampleMimeType ?: return false
            return try {
                FfmpegLibrary.isAvailable() && FfmpegLibrary.supportsFormat(mime)
            } catch (_: Throwable) {
                false
            }
        }
    }

    private val initialInputSize = if (format.maxInputSize != Format.NO_VALUE && format.maxInputSize > 0) {
        max(format.maxInputSize, DEFAULT_VIDEO_INPUT_SIZE)
    } else {
        DEFAULT_VIDEO_INPUT_SIZE
    }

    private val threads = min(4, max(2, Runtime.getRuntime().availableProcessors()))

    private val decoder = FfmpegVideoDecoder(
        NUM_INPUT_BUFFERS,
        NUM_OUTPUT_BUFFERS,
        initialInputSize,
        threads,
        sanitizeVideoFormatForFfmpeg(format)
    ).apply {
        setOutputMode(C.VIDEO_OUTPUT_MODE_SURFACE_YUV)
    }

    private val paddingSize: Int = try {
        max(0, FfmpegLibrary.getInputBufferPaddingSize())
    } catch (_: Throwable) {
        64
    }

    fun setOutputStartTimeUs(startTimeUs: Long) {
        decoder.setOutputStartTimeUs(startTimeUs)
    }

    fun queueSample(
        data: ByteArray,
        offset: Int = 0,
        length: Int = data.size,
        timeUs: Long,
        isKeyFrame: Boolean
    ): Boolean {
        val inBuf = decoder.dequeueInputBuffer() ?: return false
        inBuf.clear()
        inBuf.format = null
        inBuf.timeUs = timeUs
        if (isKeyFrame) {
            inBuf.addFlag(C.BUFFER_FLAG_KEY_FRAME)
        }
        inBuf.ensureSpaceForWrite(length + paddingSize)
        val buf = inBuf.data!!
        buf.put(data, offset, length)
        if (paddingSize > 0 && buf.remaining() >= paddingSize) {
            val lim = buf.position()
            for (i in 0 until paddingSize) {
                buf.put(lim + i, 0)
            }
        }
        inBuf.flip()
        decoder.queueInputBuffer(inBuf)
        return true
    }

    fun queueEndOfStream(): Boolean {
        val inBuf = decoder.dequeueInputBuffer() ?: return false
        inBuf.clear()
        inBuf.addFlag(C.BUFFER_FLAG_END_OF_STREAM)
        decoder.queueInputBuffer(inBuf)
        return true
    }

    sealed class DrainResult {
        object NoneReady : DrainResult()
        object SkippedFrame : DrainResult()
        data class RenderedFrame(val timeUs: Long) : DrainResult()
        object EndOfStream : DrainResult()
    }

    /**
     * Dequeues at most ONE decoded video frame and renders it onto [targetSurface] so the caller
     * can immediately latch `SurfaceTexture.awaitNewImage()` + `drawImage(timeUs)` in lockstep
     * without dropping intermediate frames.
     */
    fun drainAndRenderOneFrame(targetSurface: Surface): DrainResult {
        val outBuf = decoder.dequeueOutputBuffer() ?: return DrainResult.NoneReady
        try {
            if (outBuf.isEndOfStream) {
                return DrainResult.EndOfStream
            }
            if (outBuf.shouldBeSkipped) {
                return DrainResult.SkippedFrame
            }
            val ptsUs = outBuf.timeUs
            decoder.renderToSurface(outBuf, targetSurface)
            return DrainResult.RenderedFrame(ptsUs)
        } finally {
            outBuf.release()
        }
    }

    fun flush() {
        decoder.flush()
    }

    fun release() {
        try {
            decoder.release()
        } catch (_: Throwable) {}
    }
}
