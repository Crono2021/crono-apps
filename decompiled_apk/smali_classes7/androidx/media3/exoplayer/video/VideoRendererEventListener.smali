.class public interface abstract Landroidx/media3/exoplayer/video/VideoRendererEventListener;
.super Ljava/lang/Object;
.source "VideoRendererEventListener.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/video/VideoRendererEventListener$EventDispatcher;
    }
.end annotation


# virtual methods
.method public onDroppedFrames(IJ)V
    .locals 0
    .param p1, "count"    # I
    .param p2, "elapsedMs"    # J

    .line 89
    return-void
.end method

.method public onRenderedFirstFrame(Ljava/lang/Object;J)V
    .locals 0
    .param p1, "output"    # Ljava/lang/Object;
    .param p2, "renderTimeMs"    # J

    .line 127
    return-void
.end method

.method public onVideoCodecError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "videoCodecError"    # Ljava/lang/Exception;

    .line 156
    return-void
.end method

.method public onVideoDecoderInitialized(Ljava/lang/String;JJ)V
    .locals 0
    .param p1, "decoderName"    # Ljava/lang/String;
    .param p2, "initializedTimestampMs"    # J
    .param p4, "initializationDurationMs"    # J

    .line 60
    return-void
.end method

.method public onVideoDecoderReleased(Ljava/lang/String;)V
    .locals 0
    .param p1, "decoderName"    # Ljava/lang/String;

    .line 134
    return-void
.end method

.method public onVideoDisabled(Landroidx/media3/exoplayer/DecoderCounters;)V
    .locals 0
    .param p1, "counters"    # Landroidx/media3/exoplayer/DecoderCounters;

    .line 141
    return-void
.end method

.method public onVideoEnabled(Landroidx/media3/exoplayer/DecoderCounters;)V
    .locals 0
    .param p1, "counters"    # Landroidx/media3/exoplayer/DecoderCounters;

    .line 49
    return-void
.end method

.method public onVideoFrameProcessingOffset(JI)V
    .locals 0
    .param p1, "totalProcessingOffsetUs"    # J
    .param p3, "frameCount"    # I

    .line 109
    return-void
.end method

.method public onVideoInputFormatChanged(Landroidx/media3/common/Format;)V
    .locals 0
    .param p1, "format"    # Landroidx/media3/common/Format;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 66
    return-void
.end method

.method public onVideoInputFormatChanged(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/DecoderReuseEvaluation;)V
    .locals 0
    .param p1, "format"    # Landroidx/media3/common/Format;
    .param p2, "decoderReuseEvaluation"    # Landroidx/media3/exoplayer/DecoderReuseEvaluation;

    .line 77
    return-void
.end method

.method public onVideoSizeChanged(Landroidx/media3/common/VideoSize;)V
    .locals 0
    .param p1, "videoSize"    # Landroidx/media3/common/VideoSize;

    .line 117
    return-void
.end method
