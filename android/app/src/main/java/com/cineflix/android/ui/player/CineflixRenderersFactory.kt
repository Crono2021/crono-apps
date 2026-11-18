package com.cineflix.android.ui.player

import android.content.Context
import android.os.Handler
import androidx.media3.common.MimeTypes
import androidx.media3.common.audio.ChannelMixingAudioProcessor
import androidx.media3.common.audio.ChannelMixingMatrix
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.Renderer
import androidx.media3.exoplayer.audio.AudioRendererEventListener
import androidx.media3.exoplayer.audio.AudioSink
import androidx.media3.exoplayer.audio.DefaultAudioSink
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.media3.exoplayer.video.VideoRendererEventListener
import io.github.anilbeesetti.nextlib.media3ext.ffdecoder.createCineflixSafeFfmpegAudioRenderer
import io.github.anilbeesetti.nextlib.media3ext.ffdecoder.NextRenderersFactory
import java.util.ArrayList

/**
 * Custom RenderersFactory para Cineflix:
 * 1. Garantiza que el vídeo SIEMPRE use decodificación por hardware (`MediaCodec`) con fallback automático
 *    de Dolby Vision (`video/dolby-vision`) a HEVC (`video/hevc`) o AVC (`video/avc`) cuando el teléfono
 *    no dispone de decodificador Dolby Vision dedicado, y desactiva `FfmpegVideoRenderer` en ExoPlayer
 *    (`EXTENSION_RENDERER_MODE_OFF`) para evitar que perfiles 1080p/4K 10-bit caigan a CPU o provoquen
 *    crashes nativos / `IndexOutOfBoundsException`.
 * 2. Usa [CineflixSafeFfmpegAudioRenderer] (con salida PCM 16-bit garantizada y matrices de downmix 5.1/7.1 -> estéreo
 *    en `DefaultAudioSink`) para decodificar cualquier pista `E-AC3`, `AC3`, `DTS`, `TrueHD`, `Opus`, `FLAC` o `AAC`
 *    sin depender de implementaciones `MediaCodec` defectuosas del fabricante al cambiar de idioma.
 */
class CineflixRenderersFactory(
    context: Context,
    private val isSoftwareAudioPreferred: () -> Boolean
) : NextRenderersFactory(context) {

    companion object {
        internal fun createStereoDownmixMatrix(inputChannelCount: Int): ChannelMixingMatrix {
            val coeffs = when (inputChannelCount) {
                1 -> floatArrayOf(
                    1.0f, 1.0f // Mono -> L, R
                )
                2 -> floatArrayOf(
                    1.0f, 0.0f, // FL -> L
                    0.0f, 1.0f  // FR -> R
                )
                3 -> floatArrayOf(
                    0.5858f, 0.0f,    // FL -> L
                    0.0f,    0.5858f, // FR -> R
                    0.4142f, 0.4142f  // FC -> L, R
                )
                4 -> floatArrayOf(
                    0.5858f, 0.0f,    // FL -> L
                    0.0f,    0.5858f, // FR -> R
                    0.4142f, 0.0f,    // BL -> L
                    0.0f,    0.4142f  // BR -> R
                )
                5 -> floatArrayOf(
                    0.45f, 0.0f,  // FL -> L
                    0.0f,  0.45f, // FR -> R
                    0.40f, 0.40f, // FC -> L, R
                    0.32f, 0.0f,  // SL -> L
                    0.0f,  0.32f  // SR -> R
                )
                6 -> floatArrayOf(
                    0.42f, 0.0f,  // FL -> L
                    0.0f,  0.42f, // FR -> R
                    0.42f, 0.42f, // FC -> L, R (diálogos claros)
                    0.15f, 0.15f, // LFE -> L, R
                    0.30f, 0.0f,  // SL -> L
                    0.0f,  0.30f  // SR -> R
                )
                7 -> floatArrayOf(
                    0.38f, 0.0f,  // FL -> L
                    0.0f,  0.38f, // FR -> R
                    0.38f, 0.38f, // FC -> L, R
                    0.12f, 0.12f, // LFE -> L, R
                    0.20f, 0.20f, // BC -> L, R
                    0.25f, 0.0f,  // SL -> L
                    0.0f,  0.25f  // SR -> R
                )
                8 -> floatArrayOf(
                    0.36f, 0.0f,  // FL -> L
                    0.0f,  0.36f, // FR -> R
                    0.38f, 0.38f, // FC -> L, R
                    0.12f, 0.12f, // LFE -> L, R
                    0.22f, 0.0f,  // BL -> L
                    0.0f,  0.22f, // BR -> R
                    0.22f, 0.0f,  // SL -> L
                    0.0f,  0.22f  // SR -> R
                )
                else -> FloatArray(inputChannelCount * 2) { idx ->
                    val inCh = idx / 2
                    val outCh = idx % 2
                    when {
                        inCh == 0 && outCh == 0 -> 0.4f
                        inCh == 1 && outCh == 1 -> 0.4f
                        inCh == 2 -> 0.35f
                        inCh % 2 == outCh -> 0.2f
                        else -> 0.0f
                    }
                }
            }
            return ChannelMixingMatrix(inputChannelCount, 2, coeffs)
        }

        internal fun createConfiguredChannelMixingProcessor(): ChannelMixingAudioProcessor {
            return ChannelMixingAudioProcessor().apply {
                for (inputCh in 1..16) {
                    putChannelMixingMatrix(createStereoDownmixMatrix(inputCh))
                }
            }
        }
    }

    override fun buildAudioSink(
        context: Context,
        enableFloatOutput: Boolean,
        enableAudioTrackPlaybackParams: Boolean
    ): AudioSink {
        val mixingProcessor = createConfiguredChannelMixingProcessor()
        return DefaultAudioSink.Builder(context)
            .setEnableFloatOutput(false)
            .setEnableAudioTrackPlaybackParams(enableAudioTrackPlaybackParams)
            .setAudioProcessors(arrayOf(mixingProcessor))
            .build()
    }

    override fun buildVideoRenderers(
        context: Context,
        extensionRendererMode: Int,
        mediaCodecSelector: MediaCodecSelector,
        enableDecoderFallback: Boolean,
        eventHandler: Handler,
        eventListener: VideoRendererEventListener,
        allowedVideoJoiningTimeMs: Long,
        out: ArrayList<Renderer>
    ) {
        // Fallback transparentemente de Dolby Vision a HEVC por hardware si el móvil no tiene
        // decodificador Dolby Vision dedicado, evitando que ExoPlayer caiga a FfmpegVideoRenderer (CPU)
        // o falle con ERROR_CODE_DECODER_INIT_FAILED.
        val dvFallbackSelector = MediaCodecSelector { mimeType, requiresSecureDecoder, requiresTunnelingDecoder ->
            val primary = mediaCodecSelector.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder)
            if (primary.isNotEmpty() || mimeType != MimeTypes.VIDEO_DOLBY_VISION) {
                primary
            } else {
                val hevcDecoders = mediaCodecSelector.getDecoderInfos(
                    MimeTypes.VIDEO_H265,
                    requiresSecureDecoder,
                    requiresTunnelingDecoder
                )
                if (hevcDecoders.isNotEmpty()) {
                    hevcDecoders
                } else {
                    mediaCodecSelector.getDecoderInfos(
                        MimeTypes.VIDEO_H264,
                        requiresSecureDecoder,
                        requiresTunnelingDecoder
                    )
                }
            }
        }

        // Pasamos EXTENSION_RENDERER_MODE_OFF a super.buildVideoRenderers para que NextRenderersFactory
        // NO añada FfmpegVideoRenderer al reproductor principal (evitando bloqueos por CPU en 4K/1080p DV/HEVC
        // y el bug de IndexOutOfBoundsException en FfmpegVideoDecoder.getExtraData).
        super.buildVideoRenderers(
            context,
            DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF,
            dvFallbackSelector,
            true,
            eventHandler,
            eventListener,
            allowedVideoJoiningTimeMs,
            out
        )
    }

    override fun buildAudioRenderers(
        context: Context,
        extensionRendererMode: Int,
        mediaCodecSelector: MediaCodecSelector,
        enableDecoderFallback: Boolean,
        audioSink: AudioSink,
        eventHandler: Handler,
        eventListener: AudioRendererEventListener,
        out: ArrayList<Renderer>
    ) {
        val preferSw = isSoftwareAudioPreferred()
        if (preferSw) {
            out.add(createCineflixSafeFfmpegAudioRenderer(eventHandler, eventListener, audioSink))
            out.add(
                MediaCodecAudioRenderer(
                    context,
                    getCodecAdapterFactory(),
                    mediaCodecSelector,
                    true,
                    eventHandler,
                    eventListener,
                    audioSink
                )
            )
        } else {
            out.add(
                MediaCodecAudioRenderer(
                    context,
                    getCodecAdapterFactory(),
                    mediaCodecSelector,
                    true,
                    eventHandler,
                    eventListener,
                    audioSink
                )
            )
            out.add(createCineflixSafeFfmpegAudioRenderer(eventHandler, eventListener, audioSink))
        }
    }
}
