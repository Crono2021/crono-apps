.class public final Landroidx/media3/exoplayer/source/ClippingMediaPeriod;
.super Ljava/lang/Object;
.source "ClippingMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaPeriod;
.implements Landroidx/media3/exoplayer/source/MediaPeriod$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;
    }
.end annotation


# instance fields
.field private callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

.field private clippingError:Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

.field endUs:J

.field public final mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

.field private pendingInitialDiscontinuityPositionUs:J

.field private sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

.field startUs:J


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/MediaPeriod;ZJJ)V
    .locals 2
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;
    .param p2, "enableInitialDiscontinuity"    # Z
    .param p3, "startUs"    # J
    .param p5, "endUs"    # J

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 70
    const/4 v0, 0x0

    new-array v0, v0, [Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    .line 71
    if-eqz p2, :cond_0

    move-wide v0, p3

    goto :goto_0

    :cond_0
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    :goto_0
    iput-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    .line 72
    iput-wide p3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    .line 73
    iput-wide p5, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    .line 74
    return-void
.end method

.method private clipSeekParameters(JLandroidx/media3/exoplayer/SeekParameters;)Landroidx/media3/exoplayer/SeekParameters;
    .locals 10
    .param p1, "positionUs"    # J
    .param p3, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;

    .line 262
    iget-wide v0, p3, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    const-wide/16 v2, 0x0

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    sub-long v4, p1, v4

    .line 263
    invoke-static/range {v0 .. v5}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v0

    .line 265
    .local v0, "toleranceBeforeUs":J
    iget-wide v2, p3, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    const-wide/16 v4, 0x0

    .line 269
    iget-wide v6, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    const-wide/high16 v8, -0x8000000000000000L

    cmp-long v8, v6, v8

    if-nez v8, :cond_0

    const-wide v6, 0x7fffffffffffffffL

    goto :goto_0

    :cond_0
    sub-long/2addr v6, p1

    .line 266
    :goto_0
    invoke-static/range {v2 .. v7}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v2

    .line 270
    .local v2, "toleranceAfterUs":J
    iget-wide v4, p3, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    cmp-long v4, v0, v4

    if-nez v4, :cond_1

    iget-wide v4, p3, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    cmp-long v4, v2, v4

    if-nez v4, :cond_1

    .line 272
    return-object p3

    .line 274
    :cond_1
    new-instance v4, Landroidx/media3/exoplayer/SeekParameters;

    invoke-direct {v4, v0, v1, v2, v3}, Landroidx/media3/exoplayer/SeekParameters;-><init>(JJ)V

    return-object v4
.end method

.method private static shouldKeepInitialDiscontinuity(J[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z
    .locals 7
    .param p0, "startUs"    # J
    .param p2, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 289
    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 290
    array-length v0, p2

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_1

    aget-object v3, p2, v2

    .line 291
    .local v3, "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    if-eqz v3, :cond_0

    .line 292
    invoke-interface {v3}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getSelectedFormat()Landroidx/media3/common/Format;

    move-result-object v4

    .line 293
    .local v4, "selectedFormat":Landroidx/media3/common/Format;
    iget-object v5, v4, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    iget-object v6, v4, Landroidx/media3/common/Format;->codecs:Ljava/lang/String;

    invoke-static {v5, v6}, Landroidx/media3/common/MimeTypes;->allSamplesAreSyncSamples(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 295
    const/4 v0, 0x1

    return v0

    .line 290
    .end local v3    # "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .end local v4    # "selectedFormat":Landroidx/media3/common/Format;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 300
    :cond_1
    return v1
.end method


# virtual methods
.method public continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z
    .locals 1
    .param p1, "loadingInfo"    # Landroidx/media3/exoplayer/LoadingInfo;

    .line 234
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaPeriod;->continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z

    move-result v0

    return v0
.end method

.method public discardBuffer(JZ)V
    .locals 1
    .param p1, "positionUs"    # J
    .param p3, "toKeyframe"    # Z

    .line 161
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->discardBuffer(JZ)V

    .line 162
    return-void
.end method

.method public getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J
    .locals 3
    .param p1, "positionUs"    # J
    .param p3, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;

    .line 214
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    cmp-long v2, p1, v0

    if-nez v2, :cond_0

    .line 216
    return-wide v0

    .line 218
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->clipSeekParameters(JLandroidx/media3/exoplayer/SeekParameters;)Landroidx/media3/exoplayer/SeekParameters;

    move-result-object v0

    .line 219
    .local v0, "clippedSeekParameters":Landroidx/media3/exoplayer/SeekParameters;
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v1, p1, p2, v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J

    move-result-wide v1

    return-wide v1
.end method

.method public getBufferedPositionUs()J
    .locals 7

    .line 189
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getBufferedPositionUs()J

    move-result-wide v0

    .line 190
    .local v0, "bufferedPositionUs":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v4, v0, v2

    if-eqz v4, :cond_1

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    cmp-long v6, v4, v2

    if-eqz v6, :cond_0

    cmp-long v4, v0, v4

    if-ltz v4, :cond_0

    goto :goto_0

    .line 194
    :cond_0
    return-wide v0

    .line 192
    :cond_1
    :goto_0
    return-wide v2
.end method

.method public getNextLoadPositionUs()J
    .locals 7

    .line 224
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getNextLoadPositionUs()J

    move-result-wide v0

    .line 225
    .local v0, "nextLoadPositionUs":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v4, v0, v2

    if-eqz v4, :cond_1

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    cmp-long v6, v4, v2

    if-eqz v6, :cond_0

    cmp-long v4, v0, v4

    if-ltz v4, :cond_0

    goto :goto_0

    .line 229
    :cond_0
    return-wide v0

    .line 227
    :cond_1
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

    .line 114
    .local p1, "trackSelections":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaPeriod;->getStreamKeys(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;
    .locals 1

    .line 119
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v0

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .line 239
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->isLoading()Z

    move-result v0

    return v0
.end method

.method isPendingInitialDiscontinuity()Z
    .locals 4

    .line 258
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public maybeThrowPrepareError()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 106
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->clippingError:Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    if-nez v0, :cond_0

    .line 109
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->maybeThrowPrepareError()V

    .line 110
    return-void

    .line 107
    :cond_0
    throw v0
.end method

.method public onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 1
    .param p1, "source"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 254
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V

    .line 255
    return-void
.end method

.method public bridge synthetic onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V
    .locals 0

    .line 40
    check-cast p1, Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    return-void
.end method

.method public onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 1
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 246
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->clippingError:Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    if-eqz v0, :cond_0

    .line 247
    return-void

    .line 249
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 250
    return-void
.end method

.method public prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V
    .locals 1
    .param p1, "callback"    # Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .param p2, "positionUs"    # J

    .line 100
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    .line 101
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p0, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V

    .line 102
    return-void
.end method

.method public readDiscontinuity()J
    .locals 9

    .line 171
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->isPendingInitialDiscontinuity()Z

    move-result v0

    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    if-eqz v0, :cond_1

    .line 172
    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    .line 173
    .local v3, "initialDiscontinuityUs":J
    iput-wide v1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    .line 175
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->readDiscontinuity()J

    move-result-wide v5

    .line 176
    .local v5, "childDiscontinuityUs":J
    cmp-long v0, v5, v1

    if-eqz v0, :cond_0

    move-wide v0, v5

    goto :goto_0

    :cond_0
    move-wide v0, v3

    :goto_0
    return-wide v0

    .line 178
    .end local v3    # "initialDiscontinuityUs":J
    .end local v5    # "childDiscontinuityUs":J
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->readDiscontinuity()J

    move-result-wide v3

    .line 179
    .local v3, "discontinuityUs":J
    cmp-long v0, v3, v1

    if-nez v0, :cond_2

    .line 180
    return-wide v1

    .line 182
    :cond_2
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    cmp-long v0, v3, v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ltz v0, :cond_3

    move v0, v1

    goto :goto_1

    :cond_3
    move v0, v2

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 183
    iget-wide v5, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    const-wide/high16 v7, -0x8000000000000000L

    cmp-long v0, v5, v7

    if-eqz v0, :cond_5

    cmp-long v0, v3, v5

    if-gtz v0, :cond_4

    goto :goto_2

    :cond_4
    move v1, v2

    :cond_5
    :goto_2
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 184
    return-wide v3
.end method

.method public reevaluateBuffer(J)V
    .locals 1
    .param p1, "positionUs"    # J

    .line 166
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->reevaluateBuffer(J)V

    .line 167
    return-void
.end method

.method public seekToUs(J)J
    .locals 7
    .param p1, "positionUs"    # J

    .line 199
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    .line 200
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    array-length v1, v0

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v1, :cond_1

    aget-object v4, v0, v3

    .line 201
    .local v4, "sampleStream":Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;
    if-eqz v4, :cond_0

    .line 202
    invoke-virtual {v4}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->clearSentEos()V

    .line 200
    .end local v4    # "sampleStream":Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 205
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v0

    .line 206
    .local v0, "seekUs":J
    cmp-long v3, v0, p1

    if-eqz v3, :cond_2

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    cmp-long v3, v0, v3

    if-ltz v3, :cond_3

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v5, v3, v5

    if-eqz v5, :cond_2

    cmp-long v3, v0, v3

    if-gtz v3, :cond_3

    :cond_2
    const/4 v2, 0x1

    :cond_3
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 209
    return-wide v0
.end method

.method public selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J
    .locals 9
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "mayRetainStreamFlags"    # [Z
    .param p3, "streams"    # [Landroidx/media3/exoplayer/source/SampleStream;
    .param p4, "streamResetFlags"    # [Z
    .param p5, "positionUs"    # J

    .line 129
    array-length v0, p3

    new-array v0, v0, [Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    .line 130
    array-length v0, p3

    new-array v0, v0, [Landroidx/media3/exoplayer/source/SampleStream;

    .line 131
    .local v0, "childStreams":[Landroidx/media3/exoplayer/source/SampleStream;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p3

    const/4 v8, 0x0

    if-ge v1, v2, :cond_1

    .line 132
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aget-object v3, p3, v1

    check-cast v3, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aput-object v3, v2, v1

    .line 133
    if-eqz v3, :cond_0

    iget-object v8, v3, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    :cond_0
    aput-object v8, v0, v1

    .line 131
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 135
    .end local v1    # "i":I
    :cond_1
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 136
    move-object v2, p1

    move-object v3, p2

    move-object v4, v0

    move-object v5, p4

    move-wide v6, p5

    invoke-interface/range {v1 .. v7}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v1

    .line 138
    .local v1, "enablePositionUs":J
    nop

    .line 141
    nop

    .line 139
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->isPendingInitialDiscontinuity()Z

    move-result v3

    if-eqz v3, :cond_2

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    cmp-long v5, p5, v3

    if-nez v5, :cond_2

    .line 141
    invoke-static {v3, v4, p1}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->shouldKeepInitialDiscontinuity(J[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 142
    move-wide v3, v1

    goto :goto_1

    .line 143
    :cond_2
    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    :goto_1
    iput-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->pendingInitialDiscontinuityPositionUs:J

    .line 144
    cmp-long v3, v1, p5

    if-eqz v3, :cond_4

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    cmp-long v3, v1, v3

    if-ltz v3, :cond_3

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v5, v3, v5

    if-eqz v5, :cond_4

    cmp-long v3, v1, v3

    if-gtz v3, :cond_3

    goto :goto_2

    :cond_3
    const/4 v3, 0x0

    goto :goto_3

    :cond_4
    :goto_2
    const/4 v3, 0x1

    :goto_3
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 148
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_4
    array-length v4, p3

    if-ge v3, v4, :cond_8

    .line 149
    aget-object v4, v0, v3

    if-nez v4, :cond_5

    .line 150
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aput-object v8, v4, v3

    goto :goto_5

    .line 151
    :cond_5
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aget-object v4, v4, v3

    if-eqz v4, :cond_6

    iget-object v4, v4, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    aget-object v5, v0, v3

    if-eq v4, v5, :cond_7

    .line 152
    :cond_6
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    new-instance v5, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aget-object v6, v0, v3

    invoke-direct {v5, p0, v6}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;-><init>(Landroidx/media3/exoplayer/source/ClippingMediaPeriod;Landroidx/media3/exoplayer/source/SampleStream;)V

    aput-object v5, v4, v3

    .line 154
    :cond_7
    :goto_5
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->sampleStreams:[Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;

    aget-object v4, v4, v3

    aput-object v4, p3, v3

    .line 148
    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    .line 156
    .end local v3    # "i":I
    :cond_8
    return-wide v1
.end method

.method public setClippingError(Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;)V
    .locals 0
    .param p1, "clippingError"    # Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    .line 95
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->clippingError:Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    .line 96
    return-void
.end method

.method public updateClipping(JJ)V
    .locals 0
    .param p1, "startUs"    # J
    .param p3, "endUs"    # J

    .line 84
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    .line 85
    iput-wide p3, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    .line 86
    return-void
.end method
