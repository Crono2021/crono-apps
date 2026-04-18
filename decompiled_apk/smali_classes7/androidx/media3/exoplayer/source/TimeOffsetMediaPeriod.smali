.class final Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;
.super Ljava/lang/Object;
.source "TimeOffsetMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaPeriod;
.implements Landroidx/media3/exoplayer/source/MediaPeriod$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;
    }
.end annotation


# instance fields
.field private callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

.field private final mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

.field private final timeOffsetUs:J


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/MediaPeriod;J)V
    .locals 0
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;
    .param p2, "timeOffsetUs"    # J

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 49
    iput-wide p2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    .line 50
    return-void
.end method


# virtual methods
.method public continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z
    .locals 6
    .param p1, "loadingInfo"    # Landroidx/media3/exoplayer/LoadingInfo;

    .line 151
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 153
    invoke-virtual {p1}, Landroidx/media3/exoplayer/LoadingInfo;->buildUpon()Landroidx/media3/exoplayer/LoadingInfo$Builder;

    move-result-object v1

    iget-wide v2, p1, Landroidx/media3/exoplayer/LoadingInfo;->playbackPositionUs:J

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long/2addr v2, v4

    .line 154
    invoke-virtual {v1, v2, v3}, Landroidx/media3/exoplayer/LoadingInfo$Builder;->setPlaybackPositionUs(J)Landroidx/media3/exoplayer/LoadingInfo$Builder;

    move-result-object v1

    .line 155
    invoke-virtual {v1}, Landroidx/media3/exoplayer/LoadingInfo$Builder;->build()Landroidx/media3/exoplayer/LoadingInfo;

    move-result-object v1

    .line 151
    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/source/MediaPeriod;->continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z

    move-result v0

    return v0
.end method

.method public discardBuffer(JZ)V
    .locals 3
    .param p1, "positionUs"    # J
    .param p3, "toKeyframe"    # Z

    .line 111
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v1, p1, v1

    invoke-interface {v0, v1, v2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->discardBuffer(JZ)V

    .line 112
    return-void
.end method

.method public getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J
    .locals 4
    .param p1, "positionUs"    # J
    .param p3, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;

    .line 129
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v1, p1, v1

    invoke-interface {v0, v1, v2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v0, v2

    return-wide v0
.end method

.method public getBufferedPositionUs()J
    .locals 5

    .line 135
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getBufferedPositionUs()J

    move-result-wide v0

    .line 136
    .local v0, "bufferedPositionUs":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v4, v0, v2

    if-nez v4, :cond_0

    .line 137
    goto :goto_0

    .line 138
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v2, v0

    .line 136
    :goto_0
    return-wide v2
.end method

.method public getNextLoadPositionUs()J
    .locals 5

    .line 143
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getNextLoadPositionUs()J

    move-result-wide v0

    .line 144
    .local v0, "nextLoadPositionUs":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v4, v0, v2

    if-nez v4, :cond_0

    .line 145
    goto :goto_0

    .line 146
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v2, v0

    .line 144
    :goto_0
    return-wide v2
.end method

.method public getStreamKeys(Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;",
            ">;)",
            "Ljava/util/List<",
            "Landroidx/media3/common/StreamKey;",
            ">;"
        }
    .end annotation

    .line 75
    .local p1, "trackSelections":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaPeriod;->getStreamKeys(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;
    .locals 1

    .line 70
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v0

    return-object v0
.end method

.method public getWrappedMediaPeriod()Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 1

    .line 54
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .line 160
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->isLoading()Z

    move-result v0

    return v0
.end method

.method public maybeThrowPrepareError()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 65
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->maybeThrowPrepareError()V

    .line 66
    return-void
.end method

.method public onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 1
    .param p1, "source"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 175
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V

    .line 176
    return-void
.end method

.method public bridge synthetic onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V
    .locals 0

    .line 33
    check-cast p1, Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    return-void
.end method

.method public onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 1
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 170
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 171
    return-void
.end method

.method public prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V
    .locals 3
    .param p1, "callback"    # Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .param p2, "positionUs"    # J

    .line 59
    iput-object p1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    .line 60
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v1, p2, v1

    invoke-interface {v0, p0, v1, v2}, Landroidx/media3/exoplayer/source/MediaPeriod;->prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V

    .line 61
    return-void
.end method

.method public readDiscontinuity()J
    .locals 5

    .line 116
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->readDiscontinuity()J

    move-result-wide v0

    .line 117
    .local v0, "discontinuityPositionUs":J
    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v4, v0, v2

    if-nez v4, :cond_0

    .line 118
    goto :goto_0

    .line 119
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v2, v0

    .line 117
    :goto_0
    return-wide v2
.end method

.method public reevaluateBuffer(J)V
    .locals 3
    .param p1, "positionUs"    # J

    .line 165
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v1, p1, v1

    invoke-interface {v0, v1, v2}, Landroidx/media3/exoplayer/source/MediaPeriod;->reevaluateBuffer(J)V

    .line 166
    return-void
.end method

.method public seekToUs(J)J
    .locals 4
    .param p1, "positionUs"    # J

    .line 124
    iget-object v0, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v1, p1, v1

    invoke-interface {v0, v1, v2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v0, v2

    return-wide v0
.end method

.method public selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J
    .locals 9
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "mayRetainStreamFlags"    # [Z
    .param p3, "streams"    # [Landroidx/media3/exoplayer/source/SampleStream;
    .param p4, "streamResetFlags"    # [Z
    .param p5, "positionUs"    # J

    .line 85
    array-length v0, p3

    new-array v0, v0, [Landroidx/media3/exoplayer/source/SampleStream;

    .line 86
    .local v0, "childStreams":[Landroidx/media3/exoplayer/source/SampleStream;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p3

    const/4 v8, 0x0

    if-ge v1, v2, :cond_1

    .line 87
    aget-object v2, p3, v1

    check-cast v2, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;

    .line 88
    .local v2, "sampleStream":Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;->getChildStream()Landroidx/media3/exoplayer/source/SampleStream;

    move-result-object v8

    :cond_0
    aput-object v8, v0, v1

    .line 86
    .end local v2    # "sampleStream":Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 90
    .end local v1    # "i":I
    :cond_1
    iget-object v1, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    sub-long v6, p5, v2

    .line 91
    move-object v2, p1

    move-object v3, p2

    move-object v4, v0

    move-object v5, p4

    invoke-interface/range {v1 .. v7}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v1

    .line 97
    .local v1, "startPositionUs":J
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v4, p3

    if-ge v3, v4, :cond_5

    .line 98
    aget-object v4, v0, v3

    .line 99
    .local v4, "childStream":Landroidx/media3/exoplayer/source/SampleStream;
    if-nez v4, :cond_2

    .line 100
    aput-object v8, p3, v3

    goto :goto_2

    .line 101
    :cond_2
    aget-object v5, p3, v3

    if-eqz v5, :cond_3

    aget-object v5, p3, v3

    check-cast v5, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;

    .line 102
    invoke-virtual {v5}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;->getChildStream()Landroidx/media3/exoplayer/source/SampleStream;

    move-result-object v5

    if-eq v5, v4, :cond_4

    .line 103
    :cond_3
    new-instance v5, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;

    iget-wide v6, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    invoke-direct {v5, v4, v6, v7}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod$TimeOffsetSampleStream;-><init>(Landroidx/media3/exoplayer/source/SampleStream;J)V

    aput-object v5, p3, v3

    .line 97
    .end local v4    # "childStream":Landroidx/media3/exoplayer/source/SampleStream;
    :cond_4
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 106
    .end local v3    # "i":I
    :cond_5
    iget-wide v3, p0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->timeOffsetUs:J

    add-long/2addr v3, v1

    return-wide v3
.end method
