.class final Landroidx/media3/exoplayer/source/MergingMediaPeriod;
.super Ljava/lang/Object;
.source "MergingMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaPeriod;
.implements Landroidx/media3/exoplayer/source/MediaPeriod$Callback;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/MergingMediaPeriod$ForwardingTrackSelection;
    }
.end annotation


# instance fields
.field private callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

.field private final childTrackGroupByMergedTrackGroup:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Landroidx/media3/common/TrackGroup;",
            "Landroidx/media3/common/TrackGroup;",
            ">;"
        }
    .end annotation
.end field

.field private final childrenPendingPreparation:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/source/MediaPeriod;",
            ">;"
        }
    .end annotation
.end field

.field private compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

.field private final compositeSequenceableLoaderFactory:Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;

.field private enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

.field private final periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

.field private final streamPeriodIndices:Ljava/util/IdentityHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/IdentityHashMap<",
            "Landroidx/media3/exoplayer/source/SampleStream;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private trackGroups:Landroidx/media3/exoplayer/source/TrackGroupArray;


# direct methods
.method public varargs constructor <init>(Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;[J[Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 6
    .param p1, "compositeSequenceableLoaderFactory"    # Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;
    .param p2, "periodTimeOffsetsUs"    # [J
    .param p3, "periods"    # [Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoaderFactory:Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;

    .line 59
    iput-object p3, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    .line 61
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childTrackGroupByMergedTrackGroup:Ljava/util/HashMap;

    .line 62
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;->empty()Landroidx/media3/exoplayer/source/SequenceableLoader;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    .line 63
    new-instance v0, Ljava/util/IdentityHashMap;

    invoke-direct {v0}, Ljava/util/IdentityHashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->streamPeriodIndices:Ljava/util/IdentityHashMap;

    .line 64
    const/4 v0, 0x0

    new-array v0, v0, [Landroidx/media3/exoplayer/source/MediaPeriod;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 65
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p3

    if-ge v0, v1, :cond_1

    .line 66
    aget-wide v1, p2, v0

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    .line 67
    iget-object v1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    new-instance v2, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;

    aget-object v3, p3, v0

    aget-wide v4, p2, v0

    invoke-direct {v2, v3, v4, v5}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;-><init>(Landroidx/media3/exoplayer/source/MediaPeriod;J)V

    aput-object v2, v1, v0

    .line 65
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 70
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method static synthetic lambda$selectTracks$0(Landroidx/media3/exoplayer/source/MediaPeriod;)Ljava/util/List;
    .locals 1
    .param p0, "period"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 177
    invoke-interface {p0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/TrackGroupArray;->getTrackTypes()Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z
    .locals 3
    .param p1, "loadingInfo"    # Landroidx/media3/exoplayer/LoadingInfo;

    .line 195
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 197
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 198
    .local v0, "childrenPendingPreparationSize":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 199
    iget-object v2, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v2, p1}, Landroidx/media3/exoplayer/source/MediaPeriod;->continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z

    .line 198
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 201
    .end local v1    # "i":I
    :cond_0
    const/4 v1, 0x0

    return v1

    .line 203
    .end local v0    # "childrenPendingPreparationSize":I
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/SequenceableLoader;->continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z

    move-result v0

    return v0
.end method

.method public discardBuffer(JZ)V
    .locals 4
    .param p1, "positionUs"    # J
    .param p3, "toKeyframe"    # Z

    .line 183
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 184
    .local v3, "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    invoke-interface {v3, p1, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->discardBuffer(JZ)V

    .line 183
    .end local v3    # "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 186
    :cond_0
    return-void
.end method

.method public getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J
    .locals 3
    .param p1, "positionUs"    # J
    .param p3, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;

    .line 266
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v1, v0

    const/4 v2, 0x0

    if-lez v1, :cond_0

    aget-object v0, v0, v2

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    aget-object v0, v0, v2

    .line 267
    .local v0, "queryPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    :goto_0
    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J

    move-result-wide v1

    return-wide v1
.end method

.method public getBufferedPositionUs()J
    .locals 2

    .line 249
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/SequenceableLoader;->getBufferedPositionUs()J

    move-result-wide v0

    return-wide v0
.end method

.method public getChildPeriod(I)Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 2
    .param p1, "index"    # I

    .line 78
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    aget-object v0, v0, p1

    instance-of v1, v0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;

    if-eqz v1, :cond_0

    .line 79
    check-cast v0, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->getWrappedMediaPeriod()Landroidx/media3/exoplayer/source/MediaPeriod;

    move-result-object v0

    goto :goto_0

    .line 80
    :cond_0
    nop

    .line 78
    :goto_0
    return-object v0
.end method

.method public getNextLoadPositionUs()J
    .locals 2

    .line 214
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/SequenceableLoader;->getNextLoadPositionUs()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;
    .locals 1

    .line 101
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->trackGroups:Landroidx/media3/exoplayer/source/TrackGroupArray;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/TrackGroupArray;

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .line 209
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/SequenceableLoader;->isLoading()Z

    move-result v0

    return v0
.end method

.method public maybeThrowPrepareError()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 94
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 95
    .local v3, "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    invoke-interface {v3}, Landroidx/media3/exoplayer/source/MediaPeriod;->maybeThrowPrepareError()V

    .line 94
    .end local v3    # "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 97
    :cond_0
    return-void
.end method

.method public onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 1
    .param p1, "ignored"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 310
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V

    .line 311
    return-void
.end method

.method public bridge synthetic onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V
    .locals 0

    .line 41
    check-cast p1, Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    return-void
.end method

.method public onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 14
    .param p1, "preparedPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 274
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 275
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 276
    return-void

    .line 278
    :cond_0
    const/4 v0, 0x0

    .line 279
    .local v0, "totalTrackGroupCount":I
    iget-object v1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v2, v1

    const/4 v3, 0x0

    :goto_0
    if-ge v3, v2, :cond_1

    aget-object v4, v1, v3

    .line 280
    .local v4, "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    invoke-interface {v4}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v5

    iget v5, v5, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    add-int/2addr v0, v5

    .line 279
    .end local v4    # "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 282
    :cond_1
    new-array v1, v0, [Landroidx/media3/common/TrackGroup;

    .line 283
    .local v1, "trackGroupArray":[Landroidx/media3/common/TrackGroup;
    const/4 v2, 0x0

    .line 284
    .local v2, "trackGroupIndex":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    iget-object v4, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v5, v4

    if-ge v3, v5, :cond_5

    .line 285
    aget-object v4, v4, v3

    invoke-interface {v4}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v4

    .line 286
    .local v4, "periodTrackGroups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    iget v5, v4, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    .line 287
    .local v5, "periodTrackGroupCount":I
    const/4 v6, 0x0

    .local v6, "j":I
    :goto_2
    if-ge v6, v5, :cond_4

    .line 288
    invoke-virtual {v4, v6}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v7

    .line 289
    .local v7, "childTrackGroup":Landroidx/media3/common/TrackGroup;
    iget v8, v7, Landroidx/media3/common/TrackGroup;->length:I

    new-array v8, v8, [Landroidx/media3/common/Format;

    .line 290
    .local v8, "mergedFormats":[Landroidx/media3/common/Format;
    const/4 v9, 0x0

    .local v9, "k":I
    :goto_3
    iget v10, v7, Landroidx/media3/common/TrackGroup;->length:I

    const-string v11, ":"

    if-ge v9, v10, :cond_3

    .line 291
    invoke-virtual {v7, v9}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v10

    .line 292
    .local v10, "originalFormat":Landroidx/media3/common/Format;
    nop

    .line 294
    invoke-virtual {v10}, Landroidx/media3/common/Format;->buildUpon()Landroidx/media3/common/Format$Builder;

    move-result-object v12

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 295
    iget-object v13, v10, Landroidx/media3/common/Format;->id:Ljava/lang/String;

    if-nez v13, :cond_2

    const-string v13, ""

    goto :goto_4

    :cond_2
    iget-object v13, v10, Landroidx/media3/common/Format;->id:Ljava/lang/String;

    :goto_4
    invoke-virtual {v11, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v12, v11}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v11

    .line 296
    invoke-virtual {v11}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v11

    aput-object v11, v8, v9

    .line 290
    .end local v10    # "originalFormat":Landroidx/media3/common/Format;
    add-int/lit8 v9, v9, 0x1

    goto :goto_3

    .line 298
    .end local v9    # "k":I
    :cond_3
    new-instance v9, Landroidx/media3/common/TrackGroup;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, v7, Landroidx/media3/common/TrackGroup;->id:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10, v8}, Landroidx/media3/common/TrackGroup;-><init>(Ljava/lang/String;[Landroidx/media3/common/Format;)V

    .line 300
    .local v9, "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    iget-object v10, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childTrackGroupByMergedTrackGroup:Ljava/util/HashMap;

    invoke-virtual {v10, v9, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    add-int/lit8 v10, v2, 0x1

    .end local v2    # "trackGroupIndex":I
    .local v10, "trackGroupIndex":I
    aput-object v9, v1, v2

    .line 287
    .end local v7    # "childTrackGroup":Landroidx/media3/common/TrackGroup;
    .end local v8    # "mergedFormats":[Landroidx/media3/common/Format;
    .end local v9    # "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    add-int/lit8 v6, v6, 0x1

    move v2, v10

    goto :goto_2

    .line 284
    .end local v4    # "periodTrackGroups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .end local v5    # "periodTrackGroupCount":I
    .end local v6    # "j":I
    .end local v10    # "trackGroupIndex":I
    .restart local v2    # "trackGroupIndex":I
    :cond_4
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 304
    .end local v3    # "i":I
    :cond_5
    new-instance v3, Landroidx/media3/exoplayer/source/TrackGroupArray;

    invoke-direct {v3, v1}, Landroidx/media3/exoplayer/source/TrackGroupArray;-><init>([Landroidx/media3/common/TrackGroup;)V

    iput-object v3, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->trackGroups:Landroidx/media3/exoplayer/source/TrackGroupArray;

    .line 305
    iget-object v3, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    invoke-interface {v3, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 306
    return-void
.end method

.method public prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V
    .locals 4
    .param p1, "callback"    # Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .param p2, "positionUs"    # J

    .line 85
    iput-object p1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    .line 86
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childrenPendingPreparation:Ljava/util/ArrayList;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-static {v0, v1}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 87
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_0

    aget-object v3, v0, v2

    .line 88
    .local v3, "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    invoke-interface {v3, p0, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V

    .line 87
    .end local v3    # "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 90
    :cond_0
    return-void
.end method

.method public readDiscontinuity()J
    .locals 17

    .line 219
    move-object/from16 v0, p0

    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    .line 220
    .local v1, "discontinuityUs":J
    iget-object v3, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v4, v3

    const/4 v5, 0x0

    move v6, v5

    :goto_0
    if-ge v6, v4, :cond_8

    aget-object v7, v3, v6

    .line 221
    .local v7, "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    invoke-interface {v7}, Landroidx/media3/exoplayer/source/MediaPeriod;->readDiscontinuity()J

    move-result-wide v8

    .line 222
    .local v8, "otherDiscontinuityUs":J
    const-wide v10, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v12, v8, v10

    const-string v13, "Unexpected child seekToUs result."

    if-eqz v12, :cond_5

    .line 223
    cmp-long v10, v1, v10

    if-nez v10, :cond_3

    .line 224
    move-wide v1, v8

    .line 226
    iget-object v10, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v11, v10

    move v12, v5

    :goto_1
    if-ge v12, v11, :cond_2

    aget-object v14, v10, v12

    .line 227
    .local v14, "previousPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    if-ne v14, v7, :cond_0

    .line 228
    goto :goto_2

    .line 230
    :cond_0
    invoke-interface {v14, v1, v2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v15

    cmp-long v15, v15, v1

    if-nez v15, :cond_1

    .line 226
    .end local v14    # "previousPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 231
    .restart local v14    # "previousPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    :cond_1
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3, v13}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 226
    .end local v14    # "previousPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    :cond_2
    :goto_2
    goto :goto_3

    .line 234
    :cond_3
    cmp-long v10, v8, v1

    if-nez v10, :cond_4

    goto :goto_3

    .line 235
    :cond_4
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "Conflicting discontinuities."

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 237
    :cond_5
    cmp-long v10, v1, v10

    if-eqz v10, :cond_7

    .line 239
    invoke-interface {v7, v1, v2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v10

    cmp-long v10, v10, v1

    if-nez v10, :cond_6

    goto :goto_3

    .line 240
    :cond_6
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3, v13}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 220
    .end local v7    # "period":Landroidx/media3/exoplayer/source/MediaPeriod;
    .end local v8    # "otherDiscontinuityUs":J
    :cond_7
    :goto_3
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 244
    :cond_8
    return-wide v1
.end method

.method public reevaluateBuffer(J)V
    .locals 1
    .param p1, "positionUs"    # J

    .line 190
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/SequenceableLoader;->reevaluateBuffer(J)V

    .line 191
    return-void
.end method

.method public seekToUs(J)J
    .locals 3
    .param p1, "positionUs"    # J

    .line 254
    iget-object v0, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide p1

    .line 256
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v2, v1

    if-ge v0, v2, :cond_1

    .line 257
    aget-object v1, v1, v0

    invoke-interface {v1, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v1

    cmp-long v1, v1, p1

    if-nez v1, :cond_0

    .line 256
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 258
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "Unexpected child seekToUs result."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 261
    .end local v0    # "i":I
    :cond_1
    return-wide p1
.end method

.method public selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J
    .locals 19
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "mayRetainStreamFlags"    # [Z
    .param p3, "streams"    # [Landroidx/media3/exoplayer/source/SampleStream;
    .param p4, "streamResetFlags"    # [Z
    .param p5, "positionUs"    # J

    .line 112
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    array-length v3, v1

    new-array v3, v3, [I

    .line 113
    .local v3, "streamChildIndices":[I
    array-length v4, v1

    new-array v4, v4, [I

    .line 114
    .local v4, "selectionChildIndices":[I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    array-length v6, v1

    const/4 v7, 0x0

    const/4 v8, 0x0

    if-ge v5, v6, :cond_3

    .line 115
    aget-object v6, v2, v5

    if-nez v6, :cond_0

    goto :goto_1

    :cond_0
    iget-object v6, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->streamPeriodIndices:Ljava/util/IdentityHashMap;

    aget-object v7, v2, v5

    invoke-virtual {v6, v7}, Ljava/util/IdentityHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    move-object v7, v6

    check-cast v7, Ljava/lang/Integer;

    :goto_1
    move-object v6, v7

    .line 116
    .local v6, "streamChildIndex":Ljava/lang/Integer;
    const/4 v7, -0x1

    if-nez v6, :cond_1

    move v9, v7

    goto :goto_2

    :cond_1
    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v9

    :goto_2
    aput v9, v3, v5

    .line 117
    aget-object v9, v1, v5

    if-eqz v9, :cond_2

    .line 118
    aget-object v7, v1, v5

    invoke-interface {v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v7

    .line 120
    .local v7, "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    iget-object v9, v7, Landroidx/media3/common/TrackGroup;->id:Ljava/lang/String;

    iget-object v10, v7, Landroidx/media3/common/TrackGroup;->id:Ljava/lang/String;

    .line 121
    const-string v11, ":"

    invoke-virtual {v10, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v10

    invoke-virtual {v9, v8, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    aput v8, v4, v5

    .line 122
    .end local v7    # "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    goto :goto_3

    .line 123
    :cond_2
    aput v7, v4, v5

    .line 114
    .end local v6    # "streamChildIndex":Ljava/lang/Integer;
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 126
    .end local v5    # "i":I
    :cond_3
    iget-object v5, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->streamPeriodIndices:Ljava/util/IdentityHashMap;

    invoke-virtual {v5}, Ljava/util/IdentityHashMap;->clear()V

    .line 128
    array-length v5, v1

    new-array v5, v5, [Landroidx/media3/exoplayer/source/SampleStream;

    .line 129
    .local v5, "newStreams":[Landroidx/media3/exoplayer/source/SampleStream;
    array-length v6, v1

    new-array v6, v6, [Landroidx/media3/exoplayer/source/SampleStream;

    .line 130
    .local v6, "childStreams":[Landroidx/media3/exoplayer/source/SampleStream;
    array-length v9, v1

    new-array v14, v9, [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 131
    .local v14, "childSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    new-instance v9, Ljava/util/ArrayList;

    iget-object v10, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v10, v10

    invoke-direct {v9, v10}, Ljava/util/ArrayList;-><init>(I)V

    move-object v15, v9

    .line 132
    .local v15, "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    const/4 v9, 0x0

    move-wide/from16 v16, p5

    move v13, v9

    .end local p5    # "positionUs":J
    .local v13, "i":I
    .local v16, "positionUs":J
    :goto_4
    iget-object v9, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    array-length v9, v9

    if-ge v13, v9, :cond_e

    .line 133
    const/4 v9, 0x0

    .local v9, "j":I
    :goto_5
    array-length v10, v1

    if-ge v9, v10, :cond_6

    .line 134
    aget v10, v3, v9

    if-ne v10, v13, :cond_4

    aget-object v10, v2, v9

    goto :goto_6

    :cond_4
    move-object v10, v7

    :goto_6
    aput-object v10, v6, v9

    .line 135
    aget v10, v4, v9

    if-ne v10, v13, :cond_5

    .line 136
    aget-object v10, v1, v9

    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 137
    .local v10, "mergedTrackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    invoke-interface {v10}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v11

    .line 138
    .local v11, "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    iget-object v12, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->childTrackGroupByMergedTrackGroup:Ljava/util/HashMap;

    .line 139
    invoke-virtual {v12, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroidx/media3/common/TrackGroup;

    invoke-static {v12}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroidx/media3/common/TrackGroup;

    .line 140
    .local v12, "childTrackGroup":Landroidx/media3/common/TrackGroup;
    new-instance v8, Landroidx/media3/exoplayer/source/MergingMediaPeriod$ForwardingTrackSelection;

    invoke-direct {v8, v10, v12}, Landroidx/media3/exoplayer/source/MergingMediaPeriod$ForwardingTrackSelection;-><init>(Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/common/TrackGroup;)V

    aput-object v8, v14, v9

    .line 141
    .end local v10    # "mergedTrackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .end local v11    # "mergedTrackGroup":Landroidx/media3/common/TrackGroup;
    .end local v12    # "childTrackGroup":Landroidx/media3/common/TrackGroup;
    goto :goto_7

    .line 142
    :cond_5
    aput-object v7, v14, v9

    .line 133
    :goto_7
    add-int/lit8 v9, v9, 0x1

    const/4 v8, 0x0

    goto :goto_5

    .line 145
    .end local v9    # "j":I
    :cond_6
    iget-object v8, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    aget-object v9, v8, v13

    .line 146
    move-object v10, v14

    move-object/from16 v11, p2

    move-object v12, v6

    move v8, v13

    .end local v13    # "i":I
    .local v8, "i":I
    move-object/from16 v13, p4

    move-object/from16 v18, v14

    move-object v7, v15

    .end local v14    # "childSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .end local v15    # "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    .local v7, "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    .local v18, "childSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    move-wide/from16 v14, v16

    invoke-interface/range {v9 .. v15}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v9

    .line 148
    .local v9, "selectPositionUs":J
    if-nez v8, :cond_7

    .line 149
    move-wide v11, v9

    move-wide/from16 v16, v11

    .end local v16    # "positionUs":J
    .local v11, "positionUs":J
    goto :goto_8

    .line 150
    .end local v11    # "positionUs":J
    .restart local v16    # "positionUs":J
    :cond_7
    cmp-long v11, v9, v16

    if-nez v11, :cond_d

    .line 153
    :goto_8
    const/4 v11, 0x0

    .line 154
    .local v11, "periodEnabled":Z
    const/4 v12, 0x0

    .local v12, "j":I
    :goto_9
    array-length v13, v1

    if-ge v12, v13, :cond_b

    .line 155
    aget v13, v4, v12

    if-ne v13, v8, :cond_9

    .line 157
    aget-object v13, v6, v12

    invoke-static {v13}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/media3/exoplayer/source/SampleStream;

    .line 158
    .local v13, "childStream":Landroidx/media3/exoplayer/source/SampleStream;
    aget-object v14, v6, v12

    aput-object v14, v5, v12

    .line 159
    const/4 v11, 0x1

    .line 160
    iget-object v14, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->streamPeriodIndices:Ljava/util/IdentityHashMap;

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    invoke-virtual {v14, v13, v15}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 161
    .end local v13    # "childStream":Landroidx/media3/exoplayer/source/SampleStream;
    :cond_8
    goto :goto_b

    :cond_9
    aget v13, v3, v12

    if-ne v13, v8, :cond_8

    .line 163
    aget-object v13, v6, v12

    if-nez v13, :cond_a

    const/4 v13, 0x1

    goto :goto_a

    :cond_a
    const/4 v13, 0x0

    :goto_a
    invoke-static {v13}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 154
    :goto_b
    add-int/lit8 v12, v12, 0x1

    goto :goto_9

    .line 166
    .end local v12    # "j":I
    :cond_b
    if-eqz v11, :cond_c

    .line 167
    iget-object v12, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->periods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    aget-object v12, v12, v8

    invoke-virtual {v7, v12}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 132
    .end local v9    # "selectPositionUs":J
    .end local v11    # "periodEnabled":Z
    :cond_c
    add-int/lit8 v13, v8, 0x1

    move-object v15, v7

    move-object/from16 v14, v18

    const/4 v7, 0x0

    const/4 v8, 0x0

    .end local v8    # "i":I
    .local v13, "i":I
    goto/16 :goto_4

    .line 151
    .end local v13    # "i":I
    .restart local v8    # "i":I
    .restart local v9    # "selectPositionUs":J
    :cond_d
    new-instance v11, Ljava/lang/IllegalStateException;

    const-string v12, "Children enabled at different positions."

    invoke-direct {v11, v12}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 132
    .end local v7    # "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    .end local v8    # "i":I
    .end local v9    # "selectPositionUs":J
    .end local v18    # "childSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .restart local v13    # "i":I
    .restart local v14    # "childSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .restart local v15    # "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    :cond_e
    move-object v7, v15

    .line 171
    .end local v13    # "i":I
    .end local v15    # "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    .restart local v7    # "enabledPeriodsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/source/MediaPeriod;>;"
    array-length v8, v5

    const/4 v9, 0x0

    invoke-static {v5, v9, v2, v9, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 173
    new-array v8, v9, [Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Landroidx/media3/exoplayer/source/MediaPeriod;

    iput-object v8, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->enabledPeriods:[Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 174
    iget-object v8, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoaderFactory:Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;

    new-instance v9, Landroidx/media3/exoplayer/source/MergingMediaPeriod$$ExternalSyntheticLambda0;

    invoke-direct {v9}, Landroidx/media3/exoplayer/source/MergingMediaPeriod$$ExternalSyntheticLambda0;-><init>()V

    .line 177
    invoke-static {v7, v9}, Lcom/google/common/collect/Lists;->transform(Ljava/util/List;Lcom/google/common/base/Function;)Ljava/util/List;

    move-result-object v9

    .line 175
    invoke-interface {v8, v7, v9}, Landroidx/media3/exoplayer/source/CompositeSequenceableLoaderFactory;->create(Ljava/util/List;Ljava/util/List;)Landroidx/media3/exoplayer/source/SequenceableLoader;

    move-result-object v8

    iput-object v8, v0, Landroidx/media3/exoplayer/source/MergingMediaPeriod;->compositeSequenceableLoader:Landroidx/media3/exoplayer/source/SequenceableLoader;

    .line 178
    return-wide v16
.end method
