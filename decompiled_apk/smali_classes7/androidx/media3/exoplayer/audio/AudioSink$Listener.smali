.class public interface abstract Landroidx/media3/exoplayer/audio/AudioSink$Listener;
.super Ljava/lang/Object;
.source "AudioSink.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/AudioSink;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public onAudioCapabilitiesChanged()V
    .locals 0

    .line 140
    return-void
.end method

.method public onAudioSinkError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "audioSinkError"    # Ljava/lang/Exception;

    .line 137
    return-void
.end method

.method public onAudioTrackInitialized(Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;)V
    .locals 0
    .param p1, "audioTrackConfig"    # Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;

    .line 147
    return-void
.end method

.method public onAudioTrackReleased(Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;)V
    .locals 0
    .param p1, "audioTrackConfig"    # Landroidx/media3/exoplayer/audio/AudioSink$AudioTrackConfig;

    .line 154
    return-void
.end method

.method public onOffloadBufferEmptying()V
    .locals 0

    .line 112
    return-void
.end method

.method public onOffloadBufferFull()V
    .locals 0

    .line 115
    return-void
.end method

.method public onPositionAdvancing(J)V
    .locals 0
    .param p1, "playoutStartSystemTimeMs"    # J

    .line 88
    return-void
.end method

.method public abstract onPositionDiscontinuity()V
.end method

.method public onSilenceSkipped()V
    .locals 0

    .line 157
    return-void
.end method

.method public abstract onSkipSilenceEnabledChanged(Z)V
.end method

.method public abstract onUnderrun(IJJ)V
.end method
