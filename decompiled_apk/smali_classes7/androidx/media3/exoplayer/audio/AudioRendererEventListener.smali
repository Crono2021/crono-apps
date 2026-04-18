.class public interface abstract Landroidx/media3/exoplayer/audio/AudioRendererEventListener;
.super Ljava/lang/Object;
.source "AudioRendererEventListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/audio/AudioRendererEventListener$EventDispatcher;
    }
.end annotation


# virtual methods
.method public onAudioCodecError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "audioCodecError"    # Ljava/lang/Exception;

    .line 132
    return-void
.end method

.method public onAudioDecoderInitialized(Ljava/lang/String;JJ)V
    .locals 0
    .param p1, "decoderName"    # Ljava/lang/String;
    .param p2, "initializedTimestampMs"    # J
    .param p4, "initializationDurationMs"    # J

    .line 60
    return-void
.end method

.method public onAudioDecoderReleased(Ljava/lang/String;)V
    .locals 0
    .param p1, "decoderName"    # Ljava/lang/String;

    .line 103
    return-void
.end method

.method public onAudioDisabled(Landroidx/media3/exoplayer/DecoderCounters;)V
    .locals 0
    .param p1, "counters"    # Landroidx/media3/exoplayer/DecoderCounters;

    .line 110
    return-void
.end method

.method public onAudioEnabled(Landroidx/media3/exoplayer/DecoderCounters;)V
    .locals 0
    .param p1, "counters"    # Landroidx/media3/exoplayer/DecoderCounters;

    .line 49
    return-void
.end method

.method public onAudioInputFormatChanged(Landroidx/media3/common/Format;)V
    .locals 0
    .param p1, "format"    # Landroidx/media3/common/Format;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 66
    return-void
.end method

.method public onAudioInputFormatChanged(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/DecoderReuseEvaluation;)V
    .locals 0
    .param p1, "format"    # Landroidx/media3/common/Format;
    .param p2, "decoderReuseEvaluation"    # Landroidx/media3/exoplayer/DecoderReuseEvaluation;

    .line 77
    return-void
.end method

.method public onAudioPositionAdvancing(J)V
    .locals 0
    .param p1, "playoutStartSystemTimeMs"    # J

    .line 86
    return-void
.end method

.method public onAudioSinkError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "audioSinkError"    # Ljava/lang/Exception;

    .line 151
    return-void
.end method

.method public onAudioTrackInitialized(Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;)V
    .locals 0
    .param p1, "audioTrackConfig"    # Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;

    .line 159
    return-void
.end method

.method public onAudioTrackReleased(Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;)V
    .locals 0
    .param p1, "audioTrackConfig"    # Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;

    .line 167
    return-void
.end method

.method public onAudioUnderrun(IJJ)V
    .locals 0
    .param p1, "bufferSize"    # I
    .param p2, "bufferSizeMs"    # J
    .param p4, "elapsedSinceLastFeedMs"    # J

    .line 96
    return-void
.end method

.method public onSkipSilenceEnabledChanged(Z)V
    .locals 0
    .param p1, "skipSilenceEnabled"    # Z

    .line 117
    return-void
.end method
