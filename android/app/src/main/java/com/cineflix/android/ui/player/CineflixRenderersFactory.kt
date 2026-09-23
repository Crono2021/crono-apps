package com.cineflix.android.ui.player

import android.content.Context
import android.os.Handler
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.Renderer
import androidx.media3.exoplayer.audio.AudioRendererEventListener
import androidx.media3.exoplayer.audio.AudioSink
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.media3.exoplayer.video.VideoRendererEventListener
import io.github.anilbeesetti.nextlib.media3ext.ffdecoder.NextRenderersFactory
import java.util.ArrayList

/**
 * Custom RenderersFactory para Cineflix:
 * 1. Garantiza que el vídeo SIEMPRE use decodificación por hardware (MediaCodec) primero (EXTENSION_RENDERER_MODE_ON).
 *    Esto evita que el decodificador de vídeo por software de NextLib intente procesar vídeo 1080p/4K por CPU,
 *    eliminando de raíz las líneas verdes y el error ERROR_CODE_DECODER_INIT_FAILED.
 * 2. Permite conmutar la preferencia del decodificador de AUDIO:
 *    - Cuando isSoftwareAudioPreferred() es true: pone FfmpegAudioRenderer primero (decodificación por software
 *      de cualquier códec AC3, EAC3, DTS, TrueHD a PCM estéreo limpio sin problemas de passthrough).
 *    - Cuando es false: pone MediaCodecAudioRenderer primero (reproducción por hardware / passthrough 5.1).
 */
class CineflixRenderersFactory(
    context: Context,
    private val isSoftwareAudioPreferred: () -> Boolean
) : NextRenderersFactory(context) {

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
        // VÍDEO: SIEMPRE hardware primero (EXTENSION_RENDERER_MODE_ON).
        super.buildVideoRenderers(
            context,
            DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON,
            mediaCodecSelector,
            enableDecoderFallback,
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
        val audioMode = if (isSoftwareAudioPreferred()) {
            DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
        } else {
            DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON
        }
        super.buildAudioRenderers(
            context,
            audioMode,
            mediaCodecSelector,
            enableDecoderFallback,
            audioSink,
            eventHandler,
            eventListener,
            out
        )
    }
}
