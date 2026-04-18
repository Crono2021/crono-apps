.class final Landroidx/media3/exoplayer/video/VideoFrameRenderControl;
.super Ljava/lang/Object;
.source "VideoFrameRenderControl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;
    }
.end annotation


# instance fields
.field private final frameRenderer:Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;

.field private lastPresentationTimeUs:J

.field private outputStreamOffsetUs:J

.field private pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

.field private final presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

.field private reportedVideoSize:Landroidx/media3/common/VideoSize;

.field private final streamOffsets:Landroidx/media3/common/util/TimedValueQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/util/TimedValueQueue<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

.field private final videoFrameReleaseInfo:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;

.field private final videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/util/TimedValueQueue<",
            "Landroidx/media3/common/VideoSize;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;)V
    .locals 2
    .param p1, "frameRenderer"    # Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;
    .param p2, "videoFrameReleaseControl"    # Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->frameRenderer:Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;

    .line 90
    iput-object p2, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    .line 91
    new-instance v0, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;

    invoke-direct {v0}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseInfo:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;

    .line 92
    new-instance v0, Landroidx/media3/common/util/TimedValueQueue;

    invoke-direct {v0}, Landroidx/media3/common/util/TimedValueQueue;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    .line 93
    new-instance v0, Landroidx/media3/common/util/TimedValueQueue;

    invoke-direct {v0}, Landroidx/media3/common/util/TimedValueQueue;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    .line 94
    new-instance v0, Landroidx/media3/common/util/LongArrayQueue;

    invoke-direct {v0}, Landroidx/media3/common/util/LongArrayQueue;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    .line 95
    sget-object v0, Landroidx/media3/common/VideoSize;->UNKNOWN:Landroidx/media3/common/VideoSize;

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->reportedVideoSize:Landroidx/media3/common/VideoSize;

    .line 96
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->lastPresentationTimeUs:J

    .line 97
    return-void
.end method

.method private dropFrame()V
    .locals 2

    .line 221
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/LongArrayQueue;->remove()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->frameRenderer:Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;

    invoke-interface {v0}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;->dropFrame()V

    .line 223
    return-void
.end method

.method private static getLastAndClear(Landroidx/media3/common/util/TimedValueQueue;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroidx/media3/common/util/TimedValueQueue<",
            "TT;>;)TT;"
        }
    .end annotation

    .line 265
    .local p0, "queue":Landroidx/media3/common/util/TimedValueQueue;, "Landroidx/media3/common/util/TimedValueQueue<TT;>;"
    invoke-virtual {p0}, Landroidx/media3/common/util/TimedValueQueue;->size()I

    move-result v0

    const/4 v1, 0x1

    if-lez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 266
    :goto_1
    invoke-virtual {p0}, Landroidx/media3/common/util/TimedValueQueue;->size()I

    move-result v0

    if-le v0, v1, :cond_1

    .line 267
    invoke-virtual {p0}, Landroidx/media3/common/util/TimedValueQueue;->pollFirst()Ljava/lang/Object;

    goto :goto_1

    .line 269
    :cond_1
    invoke-virtual {p0}, Landroidx/media3/common/util/TimedValueQueue;->pollFirst()Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private maybeUpdateOutputStreamOffset(J)Z
    .locals 5
    .param p1, "presentationTimeUs"    # J

    .line 244
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/common/util/TimedValueQueue;->pollFloor(J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 245
    .local v0, "newOutputStreamOffsetUs":Ljava/lang/Long;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    iget-wide v3, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->outputStreamOffsetUs:J

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    .line 246
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    iput-wide v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->outputStreamOffsetUs:J

    .line 247
    const/4 v1, 0x1

    return v1

    .line 249
    :cond_0
    const/4 v1, 0x0

    return v1
.end method

.method private maybeUpdateVideoSize(J)Z
    .locals 3
    .param p1, "presentationTimeUs"    # J

    .line 253
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/common/util/TimedValueQueue;->pollFloor(J)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/VideoSize;

    .line 254
    .local v0, "videoSize":Landroidx/media3/common/VideoSize;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 255
    return v1

    .line 257
    :cond_0
    sget-object v2, Landroidx/media3/common/VideoSize;->UNKNOWN:Landroidx/media3/common/VideoSize;

    invoke-virtual {v0, v2}, Landroidx/media3/common/VideoSize;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->reportedVideoSize:Landroidx/media3/common/VideoSize;

    invoke-virtual {v0, v2}, Landroidx/media3/common/VideoSize;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 258
    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->reportedVideoSize:Landroidx/media3/common/VideoSize;

    .line 259
    const/4 v1, 0x1

    return v1

    .line 261
    :cond_1
    return v1
.end method

.method private renderFrame(Z)V
    .locals 11
    .param p1, "shouldRenderImmediately"    # Z

    .line 226
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/LongArrayQueue;->remove()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v9

    .line 228
    .local v9, "presentationTimeUs":J
    invoke-direct {p0, v9, v10}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->maybeUpdateVideoSize(J)Z

    move-result v0

    .line 229
    .local v0, "videoSizeUpdated":Z
    if-eqz v0, :cond_0

    .line 230
    iget-object v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->frameRenderer:Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;

    iget-object v2, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->reportedVideoSize:Landroidx/media3/common/VideoSize;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;->onVideoSizeChanged(Landroidx/media3/common/VideoSize;)V

    .line 233
    :cond_0
    if-eqz p1, :cond_1

    .line 234
    const-wide/16 v1, -0x1

    move-wide v2, v1

    goto :goto_0

    .line 235
    :cond_1
    iget-object v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseInfo:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;->getReleaseTimeNs()J

    move-result-wide v1

    move-wide v2, v1

    :goto_0
    nop

    .line 236
    .local v2, "renderTimeNs":J
    iget-object v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->frameRenderer:Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;

    iget-wide v6, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->outputStreamOffsetUs:J

    iget-object v4, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    .line 240
    invoke-virtual {v4}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;->onFrameReleasedIsFirstFrame()Z

    move-result v8

    .line 236
    move-wide v4, v9

    invoke-interface/range {v1 .. v8}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl$FrameRenderer;->renderFrame(JJJZ)V

    .line 241
    return-void
.end method


# virtual methods
.method public flush()V
    .locals 6

    .line 101
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/LongArrayQueue;->clear()V

    .line 102
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->lastPresentationTimeUs:J

    .line 103
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimedValueQueue;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 108
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    invoke-static {v0}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->getLastAndClear(Landroidx/media3/common/util/TimedValueQueue;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 109
    .local v0, "lastStreamOffset":J
    iget-object v2, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    const-wide/16 v3, 0x0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v2, v3, v4, v5}, Landroidx/media3/common/util/TimedValueQueue;->add(JLjava/lang/Object;)V

    .line 111
    .end local v0    # "lastStreamOffset":J
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    if-nez v0, :cond_1

    .line 112
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimedValueQueue;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 117
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    invoke-static {v0}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->getLastAndClear(Landroidx/media3/common/util/TimedValueQueue;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/VideoSize;

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    goto :goto_0

    .line 121
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimedValueQueue;->clear()V

    .line 123
    :cond_2
    :goto_0
    return-void
.end method

.method public hasReleasedFrame(J)Z
    .locals 4
    .param p1, "presentationTimeUs"    # J

    .line 138
    iget-wide v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->lastPresentationTimeUs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v2, v0, v2

    if-eqz v2, :cond_0

    cmp-long v0, v0, p1

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isReady()Z
    .locals 2

    .line 127
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;->isReady(Z)Z

    move-result v0

    return v0
.end method

.method public onOutputFrameAvailableForRendering(J)V
    .locals 2
    .param p1, "presentationTimeUs"    # J

    .line 208
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    if-eqz v0, :cond_0

    .line 209
    iget-object v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoSizeChanges:Landroidx/media3/common/util/TimedValueQueue;

    invoke-virtual {v1, p1, p2, v0}, Landroidx/media3/common/util/TimedValueQueue;->add(JLjava/lang/Object;)V

    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    .line 212
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/common/util/LongArrayQueue;->add(J)V

    .line 214
    return-void
.end method

.method public onOutputSizeChanged(II)V
    .locals 2
    .param p1, "width"    # I
    .param p2, "height"    # I

    .line 196
    new-instance v0, Landroidx/media3/common/VideoSize;

    invoke-direct {v0, p1, p2}, Landroidx/media3/common/VideoSize;-><init>(II)V

    .line 197
    .local v0, "newVideoSize":Landroidx/media3/common/VideoSize;
    iget-object v1, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 198
    iput-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->pendingOutputVideoSize:Landroidx/media3/common/VideoSize;

    .line 200
    :cond_0
    return-void
.end method

.method public onStreamOffsetChange(JJ)V
    .locals 2
    .param p1, "presentationTimeUs"    # J
    .param p3, "streamOffsetUs"    # J

    .line 217
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->streamOffsets:Landroidx/media3/common/util/TimedValueQueue;

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, p1, p2, v1}, Landroidx/media3/common/util/TimedValueQueue;->add(JLjava/lang/Object;)V

    .line 218
    return-void
.end method

.method public render(JJ)V
    .locals 15
    .param p1, "positionUs"    # J
    .param p3, "elapsedRealtimeUs"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 155
    move-object v0, p0

    :goto_0
    iget-object v1, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v1}, Landroidx/media3/common/util/LongArrayQueue;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 156
    iget-object v1, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->presentationTimestampsUs:Landroidx/media3/common/util/LongArrayQueue;

    invoke-virtual {v1}, Landroidx/media3/common/util/LongArrayQueue;->element()J

    move-result-wide v13

    .line 158
    .local v13, "presentationTimeUs":J
    invoke-direct {p0, v13, v14}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->maybeUpdateOutputStreamOffset(J)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 159
    iget-object v1, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;->onProcessedStreamChange()V

    .line 162
    :cond_0
    iget-object v2, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    iget-wide v9, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->outputStreamOffsetUs:J

    const/4 v11, 0x0

    iget-object v12, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseInfo:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;

    .line 163
    move-wide v3, v13

    move-wide/from16 v5, p1

    move-wide/from16 v7, p3

    invoke-virtual/range {v2 .. v12}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;->getFrameReleaseAction(JJJJZLandroidx/media3/exoplayer/video/VideoFrameReleaseControl$FrameReleaseInfo;)I

    move-result v1

    .line 170
    .local v1, "frameReleaseAction":I
    packed-switch v1, :pswitch_data_0

    .line 189
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 172
    :pswitch_0
    return-void

    .line 178
    :pswitch_1
    iput-wide v13, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->lastPresentationTimeUs:J

    .line 179
    invoke-direct {p0}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->dropFrame()V

    .line 180
    goto :goto_2

    .line 183
    :pswitch_2
    iput-wide v13, v0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->lastPresentationTimeUs:J

    .line 184
    if-nez v1, :cond_1

    const/4 v2, 0x1

    goto :goto_1

    :cond_1
    const/4 v2, 0x0

    :goto_1
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->renderFrame(Z)V

    .line 187
    nop

    .line 191
    .end local v1    # "frameReleaseAction":I
    .end local v13    # "presentationTimeUs":J
    :goto_2
    goto :goto_0

    .line 192
    :cond_2
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public setPlaybackSpeed(F)V
    .locals 1
    .param p1, "speed"    # F

    .line 143
    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 144
    iget-object v0, p0, Landroidx/media3/exoplayer/video/VideoFrameRenderControl;->videoFrameReleaseControl:Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/video/VideoFrameReleaseControl;->setPlaybackSpeed(F)V

    .line 145
    return-void
.end method
