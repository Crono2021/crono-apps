.class public Landroidx/media3/exoplayer/source/SampleQueue;
.super Ljava/lang/Object;
.source "SampleQueue.java"

# interfaces
.implements Landroidx/media3/extractor/TrackOutput;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;,
        Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;,
        Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;
    }
.end annotation


# static fields
.field static final SAMPLE_CAPACITY_INCREMENT:I = 0x3e8

.field private static final TAG:Ljava/lang/String; = "SampleQueue"


# instance fields
.field private absoluteFirstIndex:I

.field private allSamplesAreSyncSamples:Z

.field private capacity:I

.field private cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

.field private currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

.field private downstreamFormat:Landroidx/media3/common/Format;

.field private final drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

.field private final drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

.field private final extrasHolder:Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

.field private flags:[I

.field private isLastSampleQueued:Z

.field private largestDiscardedTimestampUs:J

.field private largestQueuedTimestampUs:J

.field private length:I

.field private loggedUnexpectedNonSyncSample:Z

.field private offsets:[J

.field private pendingSplice:Z

.field private readPosition:I

.field private relativeFirstIndex:I

.field private final sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

.field private sampleOffsetUs:J

.field private final sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/exoplayer/source/SpannedData<",
            "Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private sizes:[I

.field private sourceIds:[J

.field private startTimeUs:J

.field private timesUs:[J

.field private unadjustedUpstreamFormat:Landroidx/media3/common/Format;

.field private upstreamFormat:Landroidx/media3/common/Format;

.field private upstreamFormatAdjustmentRequired:Z

.field private upstreamFormatChangeListener:Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;

.field private upstreamFormatRequired:Z

.field private upstreamKeyframeRequired:Z

.field private upstreamSourceId:J


# direct methods
.method protected constructor <init>(Landroidx/media3/exoplayer/upstream/Allocator;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V
    .locals 2
    .param p1, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p2, "drmSessionManager"    # Landroidx/media3/exoplayer/drm/DrmSessionManager;
    .param p3, "drmEventDispatcher"    # Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 166
    iput-object p2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

    .line 167
    iput-object p3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    .line 168
    new-instance v0, Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-direct {v0, p1}, Landroidx/media3/exoplayer/source/SampleDataQueue;-><init>(Landroidx/media3/exoplayer/upstream/Allocator;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    .line 169
    new-instance v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    invoke-direct {v0}, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->extrasHolder:Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    .line 170
    const/16 v0, 0x3e8

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    .line 171
    new-array v1, v0, [J

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    .line 172
    new-array v1, v0, [J

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    .line 173
    new-array v1, v0, [J

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    .line 174
    new-array v1, v0, [I

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    .line 175
    new-array v1, v0, [I

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    .line 176
    new-array v0, v0, [Landroidx/media3/extractor/TrackOutput$CryptoData;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 177
    new-instance v0, Landroidx/media3/exoplayer/source/SpannedData;

    new-instance v1, Landroidx/media3/exoplayer/source/SampleQueue$$ExternalSyntheticLambda0;

    invoke-direct {v1}, Landroidx/media3/exoplayer/source/SampleQueue$$ExternalSyntheticLambda0;-><init>()V

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/source/SpannedData;-><init>(Landroidx/media3/common/util/Consumer;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    .line 179
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    .line 180
    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    .line 181
    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    .line 182
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatRequired:Z

    .line 183
    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamKeyframeRequired:Z

    .line 184
    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    .line 185
    return-void
.end method

.method private declared-synchronized attemptSplice(J)Z
    .locals 5
    .param p1, "timeUs"    # J

    monitor-enter p0

    .line 886
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_1

    .line 887
    iget-wide v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v0, p1, v3

    if-lez v0, :cond_0

    goto :goto_0

    :cond_0
    move v1, v2

    :goto_0
    monitor-exit p0

    return v1

    .line 889
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getLargestReadTimestampUs()J

    move-result-wide v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    cmp-long v0, v3, p1

    if-ltz v0, :cond_2

    .line 890
    monitor-exit p0

    return v2

    .line 892
    :cond_2
    :try_start_2
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleQueue;->countUnreadSamplesBefore(J)I

    move-result v0

    .line 893
    .local v0, "retainCount":I
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    add-int/2addr v2, v0

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/SampleQueue;->discardUpstreamSampleMetadata(I)J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 894
    monitor-exit p0

    return v1

    .line 885
    .end local v0    # "retainCount":I
    .end local p1    # "timeUs":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method private declared-synchronized commitSample(JIJILandroidx/media3/extractor/TrackOutput$CryptoData;)V
    .locals 15
    .param p1, "timeUs"    # J
    .param p3, "sampleFlags"    # I
    .param p4, "offset"    # J
    .param p6, "size"    # I
    .param p7, "cryptoData"    # Landroidx/media3/extractor/TrackOutput$CryptoData;

    move-object v1, p0

    move-wide/from16 v2, p1

    monitor-enter p0

    .line 813
    :try_start_0
    iget v0, v1, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-lez v0, :cond_1

    .line 815
    sub-int/2addr v0, v4

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    .line 816
    .local v0, "previousSampleRelativeIndex":I
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    aget-wide v7, v6, v0

    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    aget v6, v6, v0

    int-to-long v9, v6

    add-long/2addr v7, v9

    cmp-long v6, v7, p4

    if-gtz v6, :cond_0

    move v6, v4

    goto :goto_0

    :cond_0
    move v6, v5

    :goto_0
    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 820
    .end local v0    # "previousSampleRelativeIndex":I
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    const/high16 v0, 0x20000000

    and-int v0, p3, v0

    if-eqz v0, :cond_2

    move v0, v4

    goto :goto_1

    :cond_2
    move v0, v5

    :goto_1
    iput-boolean v0, v1, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    .line 821
    iget-wide v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    invoke-static {v6, v7, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v6

    iput-wide v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    .line 823
    iget v0, v1, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    .line 824
    .local v0, "relativeEndIndex":I
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aput-wide v2, v6, v0

    .line 825
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    aput-wide p4, v6, v0

    .line 826
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    aput p6, v6, v0

    .line 827
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    aput p3, v6, v0

    .line 828
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    aput-object p7, v6, v0

    .line 829
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    iget-wide v7, v1, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamSourceId:J

    aput-wide v7, v6, v0

    .line 831
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v6}, Landroidx/media3/exoplayer/source/SpannedData;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_3

    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    .line 832
    invoke-virtual {v6}, Landroidx/media3/exoplayer/source/SpannedData;->getEndValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    iget-object v6, v6, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->format:Landroidx/media3/common/Format;

    iget-object v7, v1, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    invoke-virtual {v6, v7}, Landroidx/media3/common/Format;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_5

    .line 833
    :cond_3
    iget-object v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/common/Format;

    .line 835
    .local v6, "upstreamFormat":Landroidx/media3/common/Format;
    iget-object v7, v1, Landroidx/media3/exoplayer/source/SampleQueue;->drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

    if-eqz v7, :cond_4

    .line 836
    iget-object v8, v1, Landroidx/media3/exoplayer/source/SampleQueue;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-interface {v7, v8, v6}, Landroidx/media3/exoplayer/drm/DrmSessionManager;->preacquireSession(Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;Landroidx/media3/common/Format;)Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;

    move-result-object v7

    goto :goto_2

    .line 837
    :cond_4
    sget-object v7, Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;->EMPTY:Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;

    :goto_2
    nop

    .line 839
    .local v7, "drmSessionReference":Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;
    iget-object v8, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    .line 840
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getWriteIndex()I

    move-result v9

    new-instance v10, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    const/4 v11, 0x0

    invoke-direct {v10, v6, v7, v11}, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;-><init>(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;Landroidx/media3/exoplayer/source/SampleQueue$1;)V

    .line 839
    invoke-virtual {v8, v9, v10}, Landroidx/media3/exoplayer/source/SpannedData;->appendSpan(ILjava/lang/Object;)V

    .line 843
    .end local v6    # "upstreamFormat":Landroidx/media3/common/Format;
    .end local v7    # "drmSessionReference":Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;
    :cond_5
    iget v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    add-int/2addr v6, v4

    iput v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    .line 844
    iget v4, v1, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    if-ne v6, v4, :cond_6

    .line 846
    add-int/lit16 v6, v4, 0x3e8

    .line 847
    .local v6, "newCapacity":I
    new-array v7, v6, [J

    .line 848
    .local v7, "newSourceIds":[J
    new-array v8, v6, [J

    .line 849
    .local v8, "newOffsets":[J
    new-array v9, v6, [J

    .line 850
    .local v9, "newTimesUs":[J
    new-array v10, v6, [I

    .line 851
    .local v10, "newFlags":[I
    new-array v11, v6, [I

    .line 852
    .local v11, "newSizes":[I
    new-array v12, v6, [Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 853
    .local v12, "newCryptoDatas":[Landroidx/media3/extractor/TrackOutput$CryptoData;
    iget v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    sub-int/2addr v4, v13

    .line 854
    .local v4, "beforeWrap":I
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    invoke-static {v14, v13, v8, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 855
    iget-object v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    iget v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    invoke-static {v13, v14, v9, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 856
    iget-object v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    iget v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    invoke-static {v13, v14, v10, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 857
    iget-object v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    iget v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    invoke-static {v13, v14, v11, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 858
    iget-object v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    iget v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    invoke-static {v13, v14, v12, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 859
    iget-object v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    iget v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    invoke-static {v13, v14, v7, v5, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 860
    iget v13, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    .line 861
    .local v13, "afterWrap":I
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    invoke-static {v14, v5, v8, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 862
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    invoke-static {v14, v5, v9, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 863
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    invoke-static {v14, v5, v10, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 864
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    invoke-static {v14, v5, v11, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 865
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    invoke-static {v14, v5, v12, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 866
    iget-object v14, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    invoke-static {v14, v5, v7, v4, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 867
    iput-object v8, v1, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    .line 868
    iput-object v9, v1, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    .line 869
    iput-object v10, v1, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    .line 870
    iput-object v11, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    .line 871
    iput-object v12, v1, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 872
    iput-object v7, v1, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    .line 873
    iput v5, v1, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    .line 874
    iput v6, v1, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 876
    .end local v4    # "beforeWrap":I
    .end local v6    # "newCapacity":I
    .end local v7    # "newSourceIds":[J
    .end local v8    # "newOffsets":[J
    .end local v9    # "newTimesUs":[J
    .end local v10    # "newFlags":[I
    .end local v11    # "newSizes":[I
    .end local v12    # "newCryptoDatas":[Landroidx/media3/extractor/TrackOutput$CryptoData;
    .end local v13    # "afterWrap":I
    :cond_6
    monitor-exit p0

    return-void

    .line 812
    .end local v0    # "relativeEndIndex":I
    .end local p1    # "timeUs":J
    .end local p3    # "sampleFlags":I
    .end local p4    # "offset":J
    .end local p6    # "size":I
    .end local p7    # "cryptoData":Landroidx/media3/extractor/TrackOutput$CryptoData;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private countUnreadSamplesBefore(J)I
    .locals 5
    .param p1, "timeUs"    # J

    .line 1037
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    .line 1038
    .local v0, "count":I
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    add-int/lit8 v1, v1, -0x1

    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v1

    .line 1039
    .local v1, "relativeSampleIndex":I
    :cond_0
    :goto_0
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    if-le v0, v2, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v3, v2, v1

    cmp-long v2, v3, p1

    if-ltz v2, :cond_1

    .line 1040
    add-int/lit8 v0, v0, -0x1

    .line 1041
    add-int/lit8 v1, v1, -0x1

    .line 1042
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 1043
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    add-int/lit8 v1, v2, -0x1

    goto :goto_0

    .line 1046
    :cond_1
    return v0
.end method

.method public static createWithDrm(Landroidx/media3/exoplayer/upstream/Allocator;Landroid/os/Looper;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)Landroidx/media3/exoplayer/source/SampleQueue;
    .locals 3
    .param p0, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p1, "playbackLooper"    # Landroid/os/Looper;
    .param p2, "drmSessionManager"    # Landroidx/media3/exoplayer/drm/DrmSessionManager;
    .param p3, "drmEventDispatcher"    # Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 155
    sget-object v0, Landroidx/media3/exoplayer/analytics/PlayerId;->UNSET:Landroidx/media3/exoplayer/analytics/PlayerId;

    invoke-interface {p2, p1, v0}, Landroidx/media3/exoplayer/drm/DrmSessionManager;->setPlayer(Landroid/os/Looper;Landroidx/media3/exoplayer/analytics/PlayerId;)V

    .line 156
    new-instance v0, Landroidx/media3/exoplayer/source/SampleQueue;

    .line 158
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/drm/DrmSessionManager;

    .line 159
    invoke-static {p3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-direct {v0, p0, v1, v2}, Landroidx/media3/exoplayer/source/SampleQueue;-><init>(Landroidx/media3/exoplayer/upstream/Allocator;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V

    .line 156
    return-object v0
.end method

.method public static createWithDrm(Landroidx/media3/exoplayer/upstream/Allocator;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)Landroidx/media3/exoplayer/source/SampleQueue;
    .locals 3
    .param p0, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p1, "drmSessionManager"    # Landroidx/media3/exoplayer/drm/DrmSessionManager;
    .param p2, "drmEventDispatcher"    # Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    .line 138
    new-instance v0, Landroidx/media3/exoplayer/source/SampleQueue;

    .line 140
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/drm/DrmSessionManager;

    .line 141
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-direct {v0, p0, v1, v2}, Landroidx/media3/exoplayer/source/SampleQueue;-><init>(Landroidx/media3/exoplayer/upstream/Allocator;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V

    .line 138
    return-object v0
.end method

.method public static createWithoutDrm(Landroidx/media3/exoplayer/upstream/Allocator;)Landroidx/media3/exoplayer/source/SampleQueue;
    .locals 2
    .param p0, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;

    .line 118
    new-instance v0, Landroidx/media3/exoplayer/source/SampleQueue;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1, v1}, Landroidx/media3/exoplayer/source/SampleQueue;-><init>(Landroidx/media3/exoplayer/upstream/Allocator;Landroidx/media3/exoplayer/drm/DrmSessionManager;Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V

    return-object v0
.end method

.method private declared-synchronized discardSampleMetadataTo(JZZ)J
    .locals 10
    .param p1, "timeUs"    # J
    .param p3, "toKeyframe"    # Z
    .param p4, "stopAtReadPosition"    # Z

    monitor-enter p0

    .line 772
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    const-wide/16 v1, -0x1

    if-eqz v0, :cond_3

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    iget v5, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    aget-wide v6, v3, v5

    cmp-long v3, p1, v6

    if-gez v3, :cond_0

    goto :goto_1

    .line 775
    :cond_0
    if-eqz p4, :cond_1

    iget v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    if-eq v3, v0, :cond_1

    add-int/lit8 v0, v3, 0x1

    move v6, v0

    goto :goto_0

    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    move v6, v0

    .line 776
    .local v6, "searchLength":I
    :goto_0
    move-object v4, p0

    move-wide v7, p1

    move v9, p3

    invoke-direct/range {v4 .. v9}, Landroidx/media3/exoplayer/source/SampleQueue;->findSampleBefore(IIJZ)I

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 777
    .local v0, "discardCount":I
    const/4 v3, -0x1

    if-ne v0, v3, :cond_2

    .line 778
    monitor-exit p0

    return-wide v1

    .line 780
    :cond_2
    :try_start_1
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSamples(I)J

    move-result-wide v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-wide v1

    .line 773
    .end local v0    # "discardCount":I
    .end local v6    # "searchLength":I
    :cond_3
    :goto_1
    monitor-exit p0

    return-wide v1

    .line 771
    .end local p1    # "timeUs":J
    .end local p3    # "toKeyframe":Z
    .end local p4    # "stopAtReadPosition":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method private declared-synchronized discardSampleMetadataToEnd()J
    .locals 2

    monitor-enter p0

    .line 791
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 792
    monitor-exit p0

    const-wide/16 v0, -0x1

    return-wide v0

    .line 794
    :cond_0
    :try_start_1
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSamples(I)J

    move-result-wide v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 790
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private discardSamples(I)J
    .locals 6
    .param p1, "discardCount"    # I

    .line 1057
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    .line 1058
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/SampleQueue;->getLargestTimestamp(I)J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    .line 1059
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    sub-int/2addr v0, p1

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    .line 1060
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    add-int/2addr v0, p1

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    .line 1061
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    add-int/2addr v1, p1

    iput v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    .line 1062
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    if-lt v1, v2, :cond_0

    .line 1063
    sub-int/2addr v1, v2

    iput v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    .line 1065
    :cond_0
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    sub-int/2addr v1, p1

    iput v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    .line 1066
    if-gez v1, :cond_1

    .line 1067
    const/4 v1, 0x0

    iput v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    .line 1069
    :cond_1
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v1, v0}, Landroidx/media3/exoplayer/source/SpannedData;->discardTo(I)V

    .line 1071
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-nez v0, :cond_3

    .line 1072
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    if-nez v0, :cond_2

    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    :cond_2
    add-int/lit8 v0, v0, -0x1

    .line 1073
    .local v0, "relativeLastDiscardIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    aget-wide v2, v1, v0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    aget v1, v1, v0

    int-to-long v4, v1

    add-long/2addr v2, v4

    return-wide v2

    .line 1075
    .end local v0    # "relativeLastDiscardIndex":I
    :cond_3
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    aget-wide v1, v0, v1

    return-wide v1
.end method

.method private discardUpstreamSampleMetadata(I)J
    .locals 8
    .param p1, "discardFromIndex"    # I

    .line 898
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getWriteIndex()I

    move-result v0

    sub-int/2addr v0, p1

    .line 899
    .local v0, "discardCount":I
    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ltz v0, :cond_0

    iget v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    iget v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    sub-int/2addr v3, v4

    if-gt v0, v3, :cond_0

    move v3, v2

    goto :goto_0

    :cond_0
    move v3, v1

    :goto_0
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 900
    iget v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    sub-int/2addr v3, v0

    iput v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    .line 901
    iget-wide v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    invoke-direct {p0, v3}, Landroidx/media3/exoplayer/source/SampleQueue;->getLargestTimestamp(I)J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    iput-wide v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    .line 902
    if-nez v0, :cond_1

    iget-boolean v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    if-eqz v3, :cond_1

    move v1, v2

    :cond_1
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    .line 903
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v1, p1}, Landroidx/media3/exoplayer/source/SpannedData;->discardFrom(I)V

    .line 904
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-eqz v1, :cond_2

    .line 905
    sub-int/2addr v1, v2

    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v1

    .line 906
    .local v1, "relativeLastWriteIndex":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    aget-wide v3, v2, v1

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    aget v2, v2, v1

    int-to-long v5, v2

    add-long/2addr v3, v5

    return-wide v3

    .line 908
    .end local v1    # "relativeLastWriteIndex":I
    :cond_2
    const-wide/16 v1, 0x0

    return-wide v1
.end method

.method private findSampleAfter(IIJZ)I
    .locals 5
    .param p1, "relativeStartIndex"    # I
    .param p2, "length"    # I
    .param p3, "timeUs"    # J
    .param p5, "allowTimeBeyondBuffer"    # Z

    .line 1016
    move v0, p1

    .line 1017
    .local v0, "searchIndex":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_2

    .line 1018
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v3, v2, v0

    cmp-long v2, v3, p3

    if-ltz v2, :cond_0

    .line 1019
    return v1

    .line 1021
    :cond_0
    add-int/lit8 v0, v0, 0x1

    .line 1022
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    if-ne v0, v2, :cond_1

    .line 1023
    const/4 v0, 0x0

    .line 1017
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1026
    .end local v1    # "i":I
    :cond_2
    if-eqz p5, :cond_3

    move v1, p2

    goto :goto_1

    :cond_3
    const/4 v1, -0x1

    :goto_1
    return v1
.end method

.method private findSampleBefore(IIJZ)I
    .locals 6
    .param p1, "relativeStartIndex"    # I
    .param p2, "length"    # I
    .param p3, "timeUs"    # J
    .param p5, "keyframe"    # Z

    .line 982
    const/4 v0, -0x1

    .line 983
    .local v0, "sampleCountToTarget":I
    move v1, p1

    .line 984
    .local v1, "searchIndex":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, p2, :cond_3

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v4, v3, v1

    cmp-long v3, v4, p3

    if-gtz v3, :cond_3

    .line 985
    if-eqz p5, :cond_0

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    aget v3, v3, v1

    and-int/lit8 v3, v3, 0x1

    if-eqz v3, :cond_1

    .line 987
    :cond_0
    move v0, v2

    .line 988
    cmp-long v3, v4, p3

    if-nez v3, :cond_1

    .line 991
    goto :goto_1

    .line 994
    :cond_1
    add-int/lit8 v1, v1, 0x1

    .line 995
    iget v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    if-ne v1, v3, :cond_2

    .line 996
    const/4 v1, 0x0

    .line 984
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 999
    .end local v2    # "i":I
    :cond_3
    :goto_1
    return v0
.end method

.method private getLargestTimestamp(I)J
    .locals 7
    .param p1, "length"    # I

    .line 1088
    if-nez p1, :cond_0

    .line 1089
    const-wide/high16 v0, -0x8000000000000000L

    return-wide v0

    .line 1091
    :cond_0
    const-wide/high16 v0, -0x8000000000000000L

    .line 1092
    .local v0, "largestTimestampUs":J
    add-int/lit8 v2, p1, -0x1

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v2

    .line 1093
    .local v2, "relativeSampleIndex":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, p1, :cond_3

    .line 1094
    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v5, v4, v2

    invoke-static {v0, v1, v5, v6}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    .line 1095
    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    aget v4, v4, v2

    and-int/lit8 v4, v4, 0x1

    if-eqz v4, :cond_1

    .line 1096
    goto :goto_1

    .line 1098
    :cond_1
    add-int/lit8 v2, v2, -0x1

    .line 1099
    const/4 v4, -0x1

    if-ne v2, v4, :cond_2

    .line 1100
    iget v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    add-int/lit8 v4, v4, -0x1

    move v2, v4

    .line 1093
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 1103
    .end local v3    # "i":I
    :cond_3
    :goto_1
    return-wide v0
.end method

.method private getRelativeIndex(I)I
    .locals 2
    .param p1, "offset"    # I

    .line 1112
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    add-int/2addr v0, p1

    .line 1113
    .local v0, "relativeIndex":I
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->capacity:I

    if-ge v0, v1, :cond_0

    move v1, v0

    goto :goto_0

    :cond_0
    sub-int v1, v0, v1

    :goto_0
    return v1
.end method

.method private hasNextSample()Z
    .locals 2

    .line 912
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method static synthetic lambda$new$0(Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;)V
    .locals 1
    .param p0, "metadata"    # Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    .line 178
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->drmSessionReference:Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;

    invoke-interface {v0}, Landroidx/media3/exoplayer/drm/DrmSessionManager$DrmSessionReference;->release()V

    return-void
.end method

.method private mayReadSample(I)Z
    .locals 2
    .param p1, "relativeReadIndex"    # I

    .line 960
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    if-eqz v0, :cond_1

    .line 961
    invoke-interface {v0}, Landroidx/media3/exoplayer/drm/DrmSession;->getState()I

    move-result v0

    const/4 v1, 0x4

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    aget v0, v0, p1

    const/high16 v1, 0x40000000    # 2.0f

    and-int/2addr v0, v1

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 963
    invoke-interface {v0}, Landroidx/media3/exoplayer/drm/DrmSession;->playClearSamplesWithoutKeys()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 960
    :goto_1
    return v0
.end method

.method private onFormatResult(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/FormatHolder;)V
    .locals 6
    .param p1, "newFormat"    # Landroidx/media3/common/Format;
    .param p2, "outputFormatHolder"    # Landroidx/media3/exoplayer/FormatHolder;

    .line 923
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;

    if-nez v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 925
    .local v1, "isFirstFormat":Z
    :goto_0
    if-nez v0, :cond_1

    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    iget-object v0, v0, Landroidx/media3/common/Format;->drmInitData:Landroidx/media3/common/DrmInitData;

    .line 926
    .local v0, "oldDrmInitData":Landroidx/media3/common/DrmInitData;
    :goto_1
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;

    .line 927
    iget-object v2, p1, Landroidx/media3/common/Format;->drmInitData:Landroidx/media3/common/DrmInitData;

    .line 929
    .local v2, "newDrmInitData":Landroidx/media3/common/DrmInitData;
    nop

    .line 930
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

    if-eqz v3, :cond_2

    .line 931
    invoke-interface {v3, p1}, Landroidx/media3/exoplayer/drm/DrmSessionManager;->getCryptoType(Landroidx/media3/common/Format;)I

    move-result v3

    invoke-virtual {p1, v3}, Landroidx/media3/common/Format;->copyWithCryptoType(I)Landroidx/media3/common/Format;

    move-result-object v3

    goto :goto_2

    .line 932
    :cond_2
    move-object v3, p1

    :goto_2
    iput-object v3, p2, Landroidx/media3/exoplayer/FormatHolder;->format:Landroidx/media3/common/Format;

    .line 933
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    iput-object v3, p2, Landroidx/media3/exoplayer/FormatHolder;->drmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 934
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

    if-nez v3, :cond_3

    .line 936
    return-void

    .line 938
    :cond_3
    if-nez v1, :cond_4

    invoke-static {v0, v2}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 940
    return-void

    .line 944
    :cond_4
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 945
    .local v3, "previousSession":Landroidx/media3/exoplayer/drm/DrmSession;
    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmSessionManager:Landroidx/media3/exoplayer/drm/DrmSessionManager;

    iget-object v5, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-interface {v4, v5, p1}, Landroidx/media3/exoplayer/drm/DrmSessionManager;->acquireSession(Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;Landroidx/media3/common/Format;)Landroidx/media3/exoplayer/drm/DrmSession;

    move-result-object v4

    iput-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 946
    iput-object v4, p2, Landroidx/media3/exoplayer/FormatHolder;->drmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 948
    if-eqz v3, :cond_5

    .line 949
    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-interface {v3, v4}, Landroidx/media3/exoplayer/drm/DrmSession;->release(Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V

    .line 951
    :cond_5
    return-void
.end method

.method private declared-synchronized peekSampleMetadata(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;ZZLandroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)I
    .locals 8
    .param p1, "formatHolder"    # Landroidx/media3/exoplayer/FormatHolder;
    .param p2, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p3, "formatRequired"    # Z
    .param p4, "loadingFinished"    # Z
    .param p5, "extrasHolder"    # Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    monitor-enter p0

    .line 705
    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p2, Landroidx/media3/decoder/DecoderInputBuffer;->waitingForKeys:Z

    .line 706
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->hasNextSample()Z

    move-result v0

    const/4 v1, -0x5

    const/4 v2, -0x3

    const/4 v3, -0x4

    if-nez v0, :cond_4

    .line 707
    if-nez p4, :cond_3

    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    if-eqz v0, :cond_0

    goto :goto_0

    .line 711
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    if-eqz v0, :cond_2

    if-nez p3, :cond_1

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;

    if-eq v0, v3, :cond_2

    .line 712
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/Format;

    invoke-direct {p0, v0, p1}, Landroidx/media3/exoplayer/source/SampleQueue;->onFormatResult(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/FormatHolder;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 713
    monitor-exit p0

    return v1

    .line 715
    :cond_2
    monitor-exit p0

    return v2

    .line 708
    :cond_3
    :goto_0
    const/4 v0, 0x4

    :try_start_1
    invoke-virtual {p2, v0}, Landroidx/media3/decoder/DecoderInputBuffer;->setFlags(I)V

    .line 709
    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p2, Landroidx/media3/decoder/DecoderInputBuffer;->timeUs:J
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 710
    monitor-exit p0

    return v3

    .line 719
    :cond_4
    :try_start_2
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getReadIndex()I

    move-result v4

    invoke-virtual {v0, v4}, Landroidx/media3/exoplayer/source/SpannedData;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->format:Landroidx/media3/common/Format;

    .line 720
    .local v0, "format":Landroidx/media3/common/Format;
    if-nez p3, :cond_a

    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;

    if-eq v0, v4, :cond_5

    goto :goto_1

    .line 725
    :cond_5
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v1

    .line 726
    .local v1, "relativeReadIndex":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/source/SampleQueue;->mayReadSample(I)Z

    move-result v4

    const/4 v5, 0x1

    if-nez v4, :cond_6

    .line 727
    iput-boolean v5, p2, Landroidx/media3/decoder/DecoderInputBuffer;->waitingForKeys:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 728
    monitor-exit p0

    return v2

    .line 731
    :cond_6
    :try_start_3
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->flags:[I

    aget v2, v2, v1

    invoke-virtual {p2, v2}, Landroidx/media3/decoder/DecoderInputBuffer;->setFlags(I)V

    .line 732
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    iget v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    sub-int/2addr v4, v5

    if-ne v2, v4, :cond_8

    if-nez p4, :cond_7

    iget-boolean v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    if-eqz v2, :cond_8

    .line 733
    :cond_7
    const/high16 v2, 0x20000000

    invoke-virtual {p2, v2}, Landroidx/media3/decoder/DecoderInputBuffer;->addFlag(I)V

    .line 735
    :cond_8
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v4, v2, v1

    iput-wide v4, p2, Landroidx/media3/decoder/DecoderInputBuffer;->timeUs:J

    .line 736
    iget-wide v4, p2, Landroidx/media3/decoder/DecoderInputBuffer;->timeUs:J

    iget-wide v6, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    cmp-long v2, v4, v6

    if-gez v2, :cond_9

    .line 737
    const/high16 v2, -0x80000000

    invoke-virtual {p2, v2}, Landroidx/media3/decoder/DecoderInputBuffer;->addFlag(I)V

    .line 739
    :cond_9
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sizes:[I

    aget v2, v2, v1

    iput v2, p5, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 740
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->offsets:[J

    aget-wide v4, v2, v1

    iput-wide v4, p5, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    .line 741
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->cryptoDatas:[Landroidx/media3/extractor/TrackOutput$CryptoData;

    aget-object v2, v2, v1

    iput-object v2, p5, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->cryptoData:Landroidx/media3/extractor/TrackOutput$CryptoData;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 743
    monitor-exit p0

    return v3

    .line 721
    .end local v1    # "relativeReadIndex":I
    :cond_a
    :goto_1
    :try_start_4
    invoke-direct {p0, v0, p1}, Landroidx/media3/exoplayer/source/SampleQueue;->onFormatResult(Landroidx/media3/common/Format;Landroidx/media3/exoplayer/FormatHolder;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 722
    monitor-exit p0

    return v1

    .line 704
    .end local v0    # "format":Landroidx/media3/common/Format;
    .end local p1    # "formatHolder":Landroidx/media3/exoplayer/FormatHolder;
    .end local p2    # "buffer":Landroidx/media3/decoder/DecoderInputBuffer;
    .end local p3    # "formatRequired":Z
    .end local p4    # "loadingFinished":Z
    .end local p5    # "extrasHolder":Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method private releaseDrmSessionReferences()V
    .locals 2

    .line 798
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    if-eqz v0, :cond_0

    .line 799
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/drm/DrmSession;->release(Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;)V

    .line 800
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    .line 803
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;

    .line 805
    :cond_0
    return-void
.end method

.method private declared-synchronized rewind()V
    .locals 1

    monitor-enter p0

    .line 692
    const/4 v0, 0x0

    :try_start_0
    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    .line 693
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->rewind()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 694
    monitor-exit p0

    return-void

    .line 691
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized setUpstreamFormat(Landroidx/media3/common/Format;)Z
    .locals 4
    .param p1, "format"    # Landroidx/media3/common/Format;

    monitor-enter p0

    .line 747
    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatRequired:Z

    .line 748
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    invoke-static {p1, v1}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 752
    monitor-exit p0

    return v0

    .line 755
    :cond_0
    :try_start_1
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/SpannedData;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    .line 756
    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/SpannedData;->getEndValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    iget-object v1, v1, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->format:Landroidx/media3/common/Format;

    invoke-virtual {v1, p1}, Landroidx/media3/common/Format;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 760
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/SpannedData;->getEndValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    iget-object v1, v1, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->format:Landroidx/media3/common/Format;

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    goto :goto_0

    .line 762
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    .line 764
    :goto_0
    iget-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    iget-object v2, v2, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    iget-object v3, v3, Landroidx/media3/common/Format;->codecs:Ljava/lang/String;

    .line 765
    invoke-static {v2, v3}, Landroidx/media3/common/MimeTypes;->allSamplesAreSyncSamples(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    and-int/2addr v1, v2

    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    .line 766
    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->loggedUnexpectedNonSyncSample:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 767
    monitor-exit p0

    const/4 v0, 0x1

    return v0

    .line 746
    .end local p1    # "format":Landroidx/media3/common/Format;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method


# virtual methods
.method public declared-synchronized discardSampleMetadataToRead()J
    .locals 2

    monitor-enter p0

    .line 784
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 785
    monitor-exit p0

    const-wide/16 v0, -0x1

    return-wide v0

    .line 787
    :cond_0
    :try_start_1
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSamples(I)J

    move-result-wide v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 783
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final discardTo(JZZ)V
    .locals 3
    .param p1, "timeUs"    # J
    .param p3, "toKeyframe"    # Z
    .param p4, "stopAtReadPosition"    # Z

    .line 546
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    .line 547
    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSampleMetadataTo(JZZ)J

    move-result-wide v1

    .line 546
    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->discardDownstreamTo(J)V

    .line 548
    return-void
.end method

.method public final discardToEnd()V
    .locals 3

    .line 557
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSampleMetadataToEnd()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->discardDownstreamTo(J)V

    .line 558
    return-void
.end method

.method public final discardToRead()V
    .locals 3

    .line 552
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardSampleMetadataToRead()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->discardDownstreamTo(J)V

    .line 553
    return-void
.end method

.method public final discardUpstreamFrom(J)V
    .locals 2
    .param p1, "timeUs"    # J

    .line 278
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-nez v0, :cond_0

    .line 279
    return-void

    .line 281
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getLargestReadTimestampUs()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-lez v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 282
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleQueue;->countUnreadSamplesBefore(J)I

    move-result v0

    .line 283
    .local v0, "retainCount":I
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    add-int/2addr v1, v0

    invoke-virtual {p0, v1}, Landroidx/media3/exoplayer/source/SampleQueue;->discardUpstreamSamples(I)V

    .line 284
    return-void
.end method

.method public final discardUpstreamSamples(I)V
    .locals 3
    .param p1, "discardFromIndex"    # I

    .line 267
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/SampleQueue;->discardUpstreamSampleMetadata(I)J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->discardUpstreamSampleBytes(J)V

    .line 268
    return-void
.end method

.method public final format(Landroidx/media3/common/Format;)V
    .locals 3
    .param p1, "format"    # Landroidx/media3/common/Format;

    .line 589
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/SampleQueue;->getAdjustedUpstreamFormat(Landroidx/media3/common/Format;)Landroidx/media3/common/Format;

    move-result-object v0

    .line 590
    .local v0, "adjustedUpstreamFormat":Landroidx/media3/common/Format;
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatAdjustmentRequired:Z

    .line 591
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->unadjustedUpstreamFormat:Landroidx/media3/common/Format;

    .line 592
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->setUpstreamFormat(Landroidx/media3/common/Format;)Z

    move-result v1

    .line 593
    .local v1, "upstreamFormatChanged":Z
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatChangeListener:Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    .line 594
    invoke-interface {v2, v0}, Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;->onUpstreamFormatChanged(Landroidx/media3/common/Format;)V

    .line 596
    :cond_0
    return-void
.end method

.method protected getAdjustedUpstreamFormat(Landroidx/media3/common/Format;)Landroidx/media3/common/Format;
    .locals 5
    .param p1, "format"    # Landroidx/media3/common/Format;

    .line 678
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleOffsetUs:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p1, Landroidx/media3/common/Format;->subsampleOffsetUs:J

    const-wide v2, 0x7fffffffffffffffL

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 679
    nop

    .line 681
    invoke-virtual {p1}, Landroidx/media3/common/Format;->buildUpon()Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget-wide v1, p1, Landroidx/media3/common/Format;->subsampleOffsetUs:J

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleOffsetUs:J

    add-long/2addr v1, v3

    .line 682
    invoke-virtual {v0, v1, v2}, Landroidx/media3/common/Format$Builder;->setSubsampleOffsetUs(J)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 683
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object p1

    .line 685
    :cond_0
    return-object p1
.end method

.method public final getFirstIndex()I
    .locals 1

    .line 310
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    return v0
.end method

.method public final declared-synchronized getFirstTimestampUs()J
    .locals 3

    monitor-enter p0

    .line 374
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-nez v0, :cond_0

    const-wide/high16 v0, -0x8000000000000000L

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    aget-wide v1, v0, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-wide v0, v1

    :goto_0
    monitor-exit p0

    return-wide v0

    .line 374
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getLargestQueuedTimestampUs()J
    .locals 2

    monitor-enter p0

    .line 346
    :try_start_0
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 346
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final declared-synchronized getLargestReadTimestampUs()J
    .locals 4

    monitor-enter p0

    .line 356
    :try_start_0
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/SampleQueue;->getLargestTimestamp(I)J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 356
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final getReadIndex()I
    .locals 2

    .line 315
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    add-int/2addr v0, v1

    return v0
.end method

.method public final declared-synchronized getSkipCount(JZ)I
    .locals 8
    .param p1, "timeUs"    # J
    .param p3, "allowEndOfQueue"    # Z

    monitor-enter p0

    .line 509
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    .line 510
    .local v0, "relativeReadIndex":I
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->hasNextSample()Z

    move-result v1

    const/4 v7, 0x0

    if-eqz v1, :cond_3

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v2, v1, v0

    cmp-long v1, p1, v2

    if-gez v1, :cond_0

    goto :goto_0

    .line 513
    :cond_0
    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    cmp-long v1, p1, v1

    if-lez v1, :cond_1

    if-eqz p3, :cond_1

    .line 514
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    sub-int/2addr v1, v2

    monitor-exit p0

    return v1

    .line 516
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    :try_start_1
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    sub-int v3, v1, v2

    const/4 v6, 0x1

    .line 517
    move-object v1, p0

    move v2, v0

    move-wide v4, p1

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/source/SampleQueue;->findSampleBefore(IIJZ)I

    move-result v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 518
    .local v1, "offset":I
    const/4 v2, -0x1

    if-ne v1, v2, :cond_2

    .line 519
    monitor-exit p0

    return v7

    .line 521
    :cond_2
    monitor-exit p0

    return v1

    .line 511
    .end local v1    # "offset":I
    :cond_3
    :goto_0
    monitor-exit p0

    return v7

    .line 508
    .end local v0    # "relativeReadIndex":I
    .end local p1    # "timeUs":J
    .end local p3    # "allowEndOfQueue":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public final declared-synchronized getUpstreamFormat()Landroidx/media3/common/Format;
    .locals 1

    monitor-enter p0

    .line 332
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatRequired:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-object v0

    .line 332
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final getWriteIndex()I
    .locals 2

    .line 257
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    add-int/2addr v0, v1

    return v0
.end method

.method protected final invalidateUpstreamFormatAdjustment()V
    .locals 1

    .line 663
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatAdjustmentRequired:Z

    .line 664
    return-void
.end method

.method public final declared-synchronized isLastSampleQueued()Z
    .locals 1

    monitor-enter p0

    .line 369
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 369
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isReady(Z)Z
    .locals 3
    .param p1, "loadingFinished"    # Z

    monitor-enter p0

    .line 391
    :try_start_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->hasNextSample()Z

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_2

    .line 392
    if-nez p1, :cond_1

    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    if-eqz v0, :cond_0

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eq v0, v2, :cond_0

    goto :goto_0

    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_0
    const/4 v1, 0x0

    :cond_1
    :goto_0
    monitor-exit p0

    return v1

    .line 396
    :cond_2
    :try_start_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->getReadIndex()I

    move-result v2

    invoke-virtual {v0, v2}, Landroidx/media3/exoplayer/source/SpannedData;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleQueue$SharedSampleMetadata;->format:Landroidx/media3/common/Format;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->downstreamFormat:Landroidx/media3/common/Format;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eq v0, v2, :cond_3

    .line 398
    monitor-exit p0

    return v1

    .line 400
    :cond_3
    :try_start_2
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->mayReadSample(I)Z

    move-result v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return v0

    .line 390
    .end local p1    # "loadingFinished":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public maybeThrowError()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 303
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroidx/media3/exoplayer/drm/DrmSession;->getState()I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    goto :goto_0

    .line 304
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->currentDrmSession:Landroidx/media3/exoplayer/drm/DrmSession;

    invoke-interface {v0}, Landroidx/media3/exoplayer/drm/DrmSession;->getError()Landroidx/media3/exoplayer/drm/DrmSession$DrmSessionException;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/drm/DrmSession$DrmSessionException;

    throw v0

    .line 306
    :cond_1
    :goto_0
    return-void
.end method

.method public final declared-synchronized peekSourceId()J
    .locals 4

    monitor-enter p0

    .line 325
    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    .line 326
    .local v0, "relativeReadIndex":I
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->hasNextSample()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sourceIds:[J

    aget-wide v2, v1, v0

    goto :goto_0

    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamSourceId:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-wide v2

    .line 324
    .end local v0    # "relativeReadIndex":I
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public preRelease()V
    .locals 0

    .line 291
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->discardToEnd()V

    .line 292
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->releaseDrmSessionReferences()V

    .line 293
    return-void
.end method

.method public read(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;IZ)I
    .locals 9
    .param p1, "formatHolder"    # Landroidx/media3/exoplayer/FormatHolder;
    .param p2, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p3, "readFlags"    # I
    .param p4, "loadingFinished"    # Z

    .line 427
    and-int/lit8 v0, p3, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_0

    move v6, v2

    goto :goto_0

    :cond_0
    move v6, v1

    :goto_0
    iget-object v8, p0, Landroidx/media3/exoplayer/source/SampleQueue;->extrasHolder:Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    .line 428
    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move v7, p4

    invoke-direct/range {v3 .. v8}, Landroidx/media3/exoplayer/source/SampleQueue;->peekSampleMetadata(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;ZZLandroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)I

    move-result v0

    .line 434
    .local v0, "result":I
    const/4 v3, -0x4

    if-ne v0, v3, :cond_4

    invoke-virtual {p2}, Landroidx/media3/decoder/DecoderInputBuffer;->isEndOfStream()Z

    move-result v3

    if-nez v3, :cond_4

    .line 435
    and-int/lit8 v3, p3, 0x1

    if-eqz v3, :cond_1

    move v1, v2

    .line 436
    .local v1, "peek":Z
    :cond_1
    and-int/lit8 v3, p3, 0x4

    if-nez v3, :cond_3

    .line 437
    if-eqz v1, :cond_2

    .line 438
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->extrasHolder:Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    invoke-virtual {v3, p2, v4}, Landroidx/media3/exoplayer/source/SampleDataQueue;->peekToBuffer(Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)V

    goto :goto_1

    .line 440
    :cond_2
    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    iget-object v4, p0, Landroidx/media3/exoplayer/source/SampleQueue;->extrasHolder:Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    invoke-virtual {v3, p2, v4}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readToBuffer(Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)V

    .line 443
    :cond_3
    :goto_1
    if-nez v1, :cond_4

    .line 444
    iget v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    add-int/2addr v3, v2

    iput v3, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    .line 447
    .end local v1    # "peek":Z
    :cond_4
    return v0
.end method

.method public release()V
    .locals 1

    .line 192
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->reset(Z)V

    .line 193
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->releaseDrmSessionReferences()V

    .line 194
    return-void
.end method

.method public final reset()V
    .locals 1

    .line 198
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->reset(Z)V

    .line 199
    return-void
.end method

.method public reset(Z)V
    .locals 4
    .param p1, "resetUpstreamFormat"    # Z

    .line 211
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->reset()V

    .line 212
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    .line 213
    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    .line 214
    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->relativeFirstIndex:I

    .line 215
    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    .line 216
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamKeyframeRequired:Z

    .line 217
    const-wide/high16 v2, -0x8000000000000000L

    iput-wide v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    .line 218
    iput-wide v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestDiscardedTimestampUs:J

    .line 219
    iput-wide v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    .line 220
    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->isLastSampleQueued:Z

    .line 221
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sharedSampleMetadata:Landroidx/media3/exoplayer/source/SpannedData;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/SpannedData;->clear()V

    .line 222
    if-eqz p1, :cond_0

    .line 223
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->unadjustedUpstreamFormat:Landroidx/media3/common/Format;

    .line 224
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    .line 225
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatRequired:Z

    .line 226
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    .line 228
    :cond_0
    return-void
.end method

.method public final sampleData(Landroidx/media3/common/DataReader;IZI)I
    .locals 1
    .param p1, "input"    # Landroidx/media3/common/DataReader;
    .param p2, "length"    # I
    .param p3, "allowEndOfInput"    # Z
    .param p4, "sampleDataPart"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 602
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/SampleDataQueue;->sampleData(Landroidx/media3/common/DataReader;IZ)I

    move-result v0

    return v0
.end method

.method public final sampleData(Landroidx/media3/common/util/ParsableByteArray;II)V
    .locals 1
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "length"    # I
    .param p3, "sampleDataPart"    # I

    .line 608
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 609
    return-void
.end method

.method public sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V
    .locals 17
    .param p1, "timeUs"    # J
    .param p3, "flags"    # I
    .param p4, "size"    # I
    .param p5, "offset"    # I
    .param p6, "cryptoData"    # Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 618
    move-object/from16 v8, p0

    iget-boolean v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatAdjustmentRequired:Z

    if-eqz v0, :cond_0

    .line 619
    iget-object v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->unadjustedUpstreamFormat:Landroidx/media3/common/Format;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/Format;

    invoke-virtual {v8, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->format(Landroidx/media3/common/Format;)V

    .line 622
    :cond_0
    and-int/lit8 v0, p3, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_1

    move v0, v2

    goto :goto_0

    :cond_1
    move v0, v1

    :goto_0
    move v9, v0

    .line 623
    .local v9, "isKeyframe":Z
    iget-boolean v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamKeyframeRequired:Z

    if-eqz v0, :cond_3

    .line 624
    if-nez v9, :cond_2

    .line 625
    return-void

    .line 627
    :cond_2
    iput-boolean v1, v8, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamKeyframeRequired:Z

    .line 630
    :cond_3
    iget-wide v3, v8, Landroidx/media3/exoplayer/source/SampleQueue;->sampleOffsetUs:J

    add-long v10, p1, v3

    .line 631
    .end local p1    # "timeUs":J
    .local v10, "timeUs":J
    iget-boolean v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    if-eqz v0, :cond_6

    .line 632
    iget-wide v3, v8, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    cmp-long v0, v10, v3

    if-gez v0, :cond_4

    .line 635
    return-void

    .line 637
    :cond_4
    and-int/lit8 v0, p3, 0x1

    if-nez v0, :cond_6

    .line 640
    iget-boolean v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->loggedUnexpectedNonSyncSample:Z

    if-nez v0, :cond_5

    .line 641
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Overriding unexpected non-sync sample for format: "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, v8, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormat:Landroidx/media3/common/Format;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v3, "SampleQueue"

    invoke-static {v3, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 642
    iput-boolean v2, v8, Landroidx/media3/exoplayer/source/SampleQueue;->loggedUnexpectedNonSyncSample:Z

    .line 644
    :cond_5
    or-int/lit8 v0, p3, 0x1

    move v12, v0

    .end local p3    # "flags":I
    .local v0, "flags":I
    goto :goto_1

    .line 647
    .end local v0    # "flags":I
    .restart local p3    # "flags":I
    :cond_6
    move/from16 v12, p3

    .end local p3    # "flags":I
    .local v12, "flags":I
    :goto_1
    iget-boolean v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->pendingSplice:Z

    if-eqz v0, :cond_9

    .line 648
    if-eqz v9, :cond_8

    invoke-direct {v8, v10, v11}, Landroidx/media3/exoplayer/source/SampleQueue;->attemptSplice(J)Z

    move-result v0

    if-nez v0, :cond_7

    goto :goto_2

    .line 651
    :cond_7
    iput-boolean v1, v8, Landroidx/media3/exoplayer/source/SampleQueue;->pendingSplice:Z

    goto :goto_3

    .line 649
    :cond_8
    :goto_2
    return-void

    .line 654
    :cond_9
    :goto_3
    iget-object v0, v8, Landroidx/media3/exoplayer/source/SampleQueue;->sampleDataQueue:Landroidx/media3/exoplayer/source/SampleDataQueue;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->getTotalBytesWritten()J

    move-result-wide v0

    move/from16 v13, p4

    int-to-long v2, v13

    sub-long/2addr v0, v2

    move/from16 v14, p5

    int-to-long v2, v14

    sub-long v15, v0, v2

    .line 655
    .local v15, "absoluteOffset":J
    move-object/from16 v0, p0

    move-wide v1, v10

    move v3, v12

    move-wide v4, v15

    move/from16 v6, p4

    move-object/from16 v7, p6

    invoke-direct/range {v0 .. v7}, Landroidx/media3/exoplayer/source/SampleQueue;->commitSample(JIJILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 656
    return-void
.end method

.method public final declared-synchronized seekTo(I)Z
    .locals 3
    .param p1, "sampleIndex"    # I

    monitor-enter p0

    .line 457
    :try_start_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->rewind()V

    .line 458
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->absoluteFirstIndex:I

    if-lt p1, v0, :cond_1

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    add-int/2addr v1, v0

    if-le p1, v1, :cond_0

    goto :goto_0

    .line 461
    :cond_0
    const-wide/high16 v1, -0x8000000000000000L

    iput-wide v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    .line 462
    sub-int v0, p1, v0

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 463
    monitor-exit p0

    const/4 v0, 0x1

    return v0

    .line 459
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    :goto_0
    monitor-exit p0

    const/4 v0, 0x0

    return v0

    .line 456
    .end local p1    # "sampleIndex":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public final declared-synchronized seekTo(JZ)Z
    .locals 8
    .param p1, "timeUs"    # J
    .param p3, "allowTimeBeyondBuffer"    # Z

    monitor-enter p0

    .line 478
    :try_start_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->rewind()V

    .line 479
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleQueue;->getRelativeIndex(I)I

    move-result v0

    .line 480
    .local v0, "relativeReadIndex":I
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->hasNextSample()Z

    move-result v1

    const/4 v7, 0x0

    if-eqz v1, :cond_3

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->timesUs:[J

    aget-wide v2, v1, v0

    cmp-long v1, p1, v2

    if-ltz v1, :cond_3

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->largestQueuedTimestampUs:J

    cmp-long v1, p1, v1

    if-lez v1, :cond_0

    if-nez p3, :cond_0

    goto :goto_1

    .line 486
    :cond_0
    iget-boolean v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->allSamplesAreSyncSamples:Z

    if-eqz v1, :cond_1

    .line 487
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    sub-int v3, v1, v2

    move-object v1, p0

    move v2, v0

    move-wide v4, p1

    move v6, p3

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/source/SampleQueue;->findSampleAfter(IIJZ)I

    move-result v1

    goto :goto_0

    .line 489
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    :cond_1
    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    sub-int v3, v1, v2

    const/4 v6, 0x1

    move-object v1, p0

    move v2, v0

    move-wide v4, p1

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/source/SampleQueue;->findSampleBefore(IIJZ)I

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    nop

    .line 491
    .local v1, "offset":I
    const/4 v2, -0x1

    if-ne v1, v2, :cond_2

    .line 492
    monitor-exit p0

    return v7

    .line 494
    :cond_2
    :try_start_1
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    .line 495
    iget v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    add-int/2addr v2, v1

    iput v2, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 496
    monitor-exit p0

    const/4 v2, 0x1

    return v2

    .line 483
    .end local v1    # "offset":I
    :cond_3
    :goto_1
    monitor-exit p0

    return v7

    .line 477
    .end local v0    # "relativeReadIndex":I
    .end local p1    # "timeUs":J
    .end local p3    # "allowTimeBeyondBuffer":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public final setSampleOffsetUs(J)V
    .locals 2
    .param p1, "sampleOffsetUs"    # J

    .line 569
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleOffsetUs:J

    cmp-long v0, v0, p1

    if-eqz v0, :cond_0

    .line 570
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->sampleOffsetUs:J

    .line 571
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SampleQueue;->invalidateUpstreamFormatAdjustment()V

    .line 573
    :cond_0
    return-void
.end method

.method public final setStartTimeUs(J)V
    .locals 0
    .param p1, "startTimeUs"    # J

    .line 238
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->startTimeUs:J

    .line 239
    return-void
.end method

.method public final setUpstreamFormatChangeListener(Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;)V
    .locals 0
    .param p1, "listener"    # Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;

    .line 582
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamFormatChangeListener:Landroidx/media3/exoplayer/source/SampleQueue$UpstreamFormatChangedListener;

    .line 583
    return-void
.end method

.method public final declared-synchronized skip(I)V
    .locals 2
    .param p1, "count"    # I

    monitor-enter p0

    .line 531
    if-ltz p1, :cond_0

    :try_start_0
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    add-int/2addr v0, p1

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->length:I

    if-gt v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    .line 530
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SampleQueue;
    .end local p1    # "count":I
    :catchall_0
    move-exception p1

    goto :goto_1

    .line 531
    .restart local p1    # "count":I
    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 532
    iget v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I

    add-int/2addr v0, p1

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->readPosition:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 533
    monitor-exit p0

    return-void

    .line 530
    .end local p1    # "count":I
    :goto_1
    monitor-exit p0

    throw p1
.end method

.method public final sourceId(J)V
    .locals 0
    .param p1, "sourceId"    # J

    .line 247
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleQueue;->upstreamSourceId:J

    .line 248
    return-void
.end method

.method public final splice()V
    .locals 1

    .line 252
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/SampleQueue;->pendingSplice:Z

    .line 253
    return-void
.end method
