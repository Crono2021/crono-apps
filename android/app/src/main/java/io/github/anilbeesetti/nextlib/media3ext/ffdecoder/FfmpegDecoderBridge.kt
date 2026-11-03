package io.github.anilbeesetti.nextlib.media3ext.ffdecoder

import android.view.Surface
import androidx.media3.common.C
import androidx.media3.common.Format
import kotlin.math.max
import kotlin.math.min

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
        format,
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
        format
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
