.class public final Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;
.super Landroidx/media3/exoplayer/source/CompositeMediaSource;
.source "ConcatenatingMediaSource2.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/media3/exoplayer/source/CompositeMediaSource<",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# static fields
.field private static final MSG_UPDATE_TIMELINE:I


# instance fields
.field private mediaItem:Landroidx/media3/common/MediaItem;

.field private final mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/IdentityHashMap<",
            "Landroidx/media3/exoplayer/source/MediaPeriod;",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceHolders:Lcom/google/common/collect/ImmutableList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private playbackThreadHandler:Landroid/os/Handler;

.field private timelineUpdateScheduled:Z


# direct methods
.method public static synthetic $r8$lambda$4rcHX9TiKL5YuulNUMgCdk6MXNY(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;Landroid/os/Message;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->handleMessage(Landroid/os/Message;)Z

    move-result p0

    return p0
.end method

.method private constructor <init>(Landroidx/media3/common/MediaItem;Lcom/google/common/collect/ImmutableList;)V
    .locals 1
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/MediaItem;",
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;",
            ">;)V"
        }
    .end annotation

    .line 236
    .local p2, "mediaSourceHolders":Lcom/google/common/collect/ImmutableList;, "Lcom/google/common/collect/ImmutableList<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;>;"
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;-><init>()V

    .line 237
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaItem:Landroidx/media3/common/MediaItem;

    .line 238
    iput-object p2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    .line 239
    new-instance v0, Ljava/util/IdentityHashMap;

    invoke-direct {v0}, Ljava/util/IdentityHashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    .line 240
    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/common/MediaItem;Lcom/google/common/collect/ImmutableList;Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/common/MediaItem;
    .param p2, "x1"    # Lcom/google/common/collect/ImmutableList;
    .param p3, "x2"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$1;

    .line 59
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;-><init>(Landroidx/media3/common/MediaItem;Lcom/google/common/collect/ImmutableList;)V

    return-void
.end method

.method static synthetic access$100(Ljava/lang/Object;)I
    .locals 1
    .param p0, "x0"    # Ljava/lang/Object;

    .line 59
    invoke-static {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildIndex(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method static synthetic access$200(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Ljava/lang/Object;

    .line 59
    invoke-static {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # I
    .param p1, "x1"    # Ljava/lang/Object;

    .line 59
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getPeriodUid(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private disableUnusedMediaSources()V
    .locals 3

    .line 395
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 396
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1, v0}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    .line 397
    .local v1, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    iget v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    if-nez v2, :cond_0

    .line 398
    iget v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->index:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->disableChildSource(Ljava/lang/Object;)V

    .line 395
    .end local v1    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 401
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method private static getChildIndex(Ljava/lang/Object;)I
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 505
    move-object v0, p0

    check-cast v0, Landroid/util/Pair;

    iget-object v0, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method private static getChildIndexFromChildWindowSequenceNumber(JI)I
    .locals 2
    .param p0, "childWindowSequenceNumber"    # J
    .param p2, "childCount"    # I

    .line 523
    int-to-long v0, p2

    rem-long v0, p0, v0

    long-to-int v0, v0

    return v0
.end method

.method private static getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 511
    move-object v0, p0

    check-cast v0, Landroid/util/Pair;

    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    return-object v0
.end method

.method private static getChildWindowSequenceNumber(JII)J
    .locals 4
    .param p0, "windowSequenceNumber"    # J
    .param p2, "childCount"    # I
    .param p3, "childIndex"    # I

    .line 517
    int-to-long v0, p2

    mul-long/2addr v0, p0

    int-to-long v2, p3

    add-long/2addr v0, v2

    return-wide v0
.end method

.method private static getPeriodUid(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "childIndex"    # I
    .param p1, "childPeriodUid"    # Ljava/lang/Object;

    .line 499
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v0

    return-object v0
.end method

.method private static getWindowSequenceNumberFromChildWindowSequenceNumber(JI)J
    .locals 2
    .param p0, "childWindowSequenceNumber"    # J
    .param p2, "childCount"    # I

    .line 529
    int-to-long v0, p2

    div-long v0, p0, v0

    return-wide v0
.end method

.method private handleMessage(Landroid/os/Message;)Z
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .line 373
    iget v0, p1, Landroid/os/Message;->what:I

    if-nez v0, :cond_0

    .line 374
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->updateTimeline()V

    .line 376
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method private maybeCreateConcatenatedTimeline()Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;
    .locals 39

    .line 405
    move-object/from16 v0, p0

    new-instance v1, Landroidx/media3/common/Timeline$Window;

    invoke-direct {v1}, Landroidx/media3/common/Timeline$Window;-><init>()V

    .line 406
    .local v1, "window":Landroidx/media3/common/Timeline$Window;
    new-instance v2, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v2}, Landroidx/media3/common/Timeline$Period;-><init>()V

    .line 407
    .local v2, "period":Landroidx/media3/common/Timeline$Period;
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->builder()Lcom/google/common/collect/ImmutableList$Builder;

    move-result-object v3

    .line 408
    .local v3, "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->builder()Lcom/google/common/collect/ImmutableList$Builder;

    move-result-object v4

    .line 409
    .local v4, "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->builder()Lcom/google/common/collect/ImmutableList$Builder;

    move-result-object v5

    .line 410
    .local v5, "periodOffsetsInWindowUsBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Long;>;"
    const/4 v6, 0x0

    .line 411
    .local v6, "periodCount":I
    const/4 v7, 0x1

    .line 412
    .local v7, "isSeekable":Z
    const/4 v8, 0x0

    .line 413
    .local v8, "isDynamic":Z
    const-wide/16 v9, 0x0

    .line 414
    .local v9, "durationUs":J
    const-wide/16 v11, 0x0

    .line 415
    .local v11, "defaultPositionUs":J
    const-wide/16 v13, 0x0

    .line 416
    .local v13, "nextPeriodOffsetInWindowUs":J
    const/4 v15, 0x1

    .line 417
    .local v15, "manifestsAreIdentical":Z
    const/16 v16, 0x0

    .line 418
    .local v16, "hasInitialManifest":Z
    const/16 v17, 0x0

    .line 419
    .local v17, "initialManifest":Ljava/lang/Object;
    move/from16 v18, v6

    .end local v6    # "periodCount":I
    .local v18, "periodCount":I
    iget-object v6, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v6}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v6

    .line 420
    .local v6, "mediaSourceHoldersCount":I
    const/16 v19, 0x0

    move-wide/from16 v31, v13

    move/from16 v13, v19

    .local v13, "i":I
    .local v31, "nextPeriodOffsetInWindowUs":J
    :goto_0
    if-ge v13, v6, :cond_12

    .line 421
    iget-object v14, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v14, v13}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    .line 422
    .local v14, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    iget-object v0, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    .line 423
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v20

    move/from16 v33, v6

    .end local v6    # "mediaSourceHoldersCount":I
    .local v33, "mediaSourceHoldersCount":I
    const/4 v6, 0x1

    move-wide/from16 v34, v11

    .end local v11    # "defaultPositionUs":J
    .local v34, "defaultPositionUs":J
    xor-int/lit8 v11, v20, 0x1

    const-string v12, "Can\'t concatenate empty child Timeline."

    invoke-static {v11, v12}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 424
    invoke-virtual {v3, v0}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 425
    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v4, v11}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 426
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->getPeriodCount()I

    move-result v11

    .line 427
    .local v11, "periodCountInMediaSourceHolder":I
    add-int v18, v18, v11

    .line 428
    const/4 v12, 0x0

    .local v12, "j":I
    :goto_1
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v6

    if-ge v12, v6, :cond_11

    .line 429
    invoke-virtual {v0, v12, v1}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    .line 430
    if-nez v16, :cond_0

    .line 431
    iget-object v6, v1, Landroidx/media3/common/Timeline$Window;->manifest:Ljava/lang/Object;

    .line 432
    .end local v17    # "initialManifest":Ljava/lang/Object;
    .local v6, "initialManifest":Ljava/lang/Object;
    const/16 v16, 0x1

    goto :goto_2

    .line 430
    .end local v6    # "initialManifest":Ljava/lang/Object;
    .restart local v17    # "initialManifest":Ljava/lang/Object;
    :cond_0
    move-object/from16 v6, v17

    .line 434
    .end local v17    # "initialManifest":Ljava/lang/Object;
    .restart local v6    # "initialManifest":Ljava/lang/Object;
    :goto_2
    const/16 v17, 0x0

    if-eqz v15, :cond_1

    move/from16 v21, v11

    .end local v11    # "periodCountInMediaSourceHolder":I
    .local v21, "periodCountInMediaSourceHolder":I
    iget-object v11, v1, Landroidx/media3/common/Timeline$Window;->manifest:Ljava/lang/Object;

    .line 435
    invoke-static {v6, v11}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_2

    const/4 v11, 0x1

    goto :goto_3

    .line 434
    .end local v21    # "periodCountInMediaSourceHolder":I
    .restart local v11    # "periodCountInMediaSourceHolder":I
    :cond_1
    move/from16 v21, v11

    .line 435
    .end local v11    # "periodCountInMediaSourceHolder":I
    .restart local v21    # "periodCountInMediaSourceHolder":I
    :cond_2
    move/from16 v11, v17

    :goto_3
    move v15, v11

    .line 437
    move-object v11, v3

    move-object/from16 v36, v4

    .end local v3    # "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .end local v4    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .local v11, "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .local v36, "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    iget-wide v3, v1, Landroidx/media3/common/Timeline$Window;->durationUs:J

    .line 438
    .local v3, "windowDurationUs":J
    const-wide v22, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v24, v3, v22

    if-nez v24, :cond_4

    .line 439
    move-wide/from16 v24, v3

    .end local v3    # "windowDurationUs":J
    .local v24, "windowDurationUs":J
    iget-wide v3, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->initialPlaceholderDurationUs:J

    cmp-long v3, v3, v22

    if-nez v3, :cond_3

    .line 441
    const/4 v3, 0x0

    return-object v3

    .line 443
    :cond_3
    const/4 v3, 0x0

    iget-wide v3, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->initialPlaceholderDurationUs:J

    .end local v24    # "windowDurationUs":J
    .restart local v3    # "windowDurationUs":J
    goto :goto_4

    .line 438
    :cond_4
    move-wide/from16 v24, v3

    .line 445
    :goto_4
    add-long/2addr v9, v3

    .line 446
    move-object/from16 v24, v6

    .end local v6    # "initialManifest":Ljava/lang/Object;
    .local v24, "initialManifest":Ljava/lang/Object;
    iget v6, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->index:I

    if-nez v6, :cond_5

    if-nez v12, :cond_5

    .line 447
    move-wide/from16 v25, v9

    .end local v9    # "durationUs":J
    .local v25, "durationUs":J
    iget-wide v9, v1, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    .line 448
    .end local v34    # "defaultPositionUs":J
    .local v9, "defaultPositionUs":J
    move-wide/from16 v27, v9

    .end local v9    # "defaultPositionUs":J
    .local v27, "defaultPositionUs":J
    iget-wide v9, v1, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    neg-long v9, v9

    move-wide/from16 v31, v9

    move-wide/from16 v34, v27

    .end local v31    # "nextPeriodOffsetInWindowUs":J
    .local v9, "nextPeriodOffsetInWindowUs":J
    goto :goto_5

    .line 446
    .end local v25    # "durationUs":J
    .end local v27    # "defaultPositionUs":J
    .local v9, "durationUs":J
    .restart local v31    # "nextPeriodOffsetInWindowUs":J
    .restart local v34    # "defaultPositionUs":J
    :cond_5
    move-wide/from16 v25, v9

    .line 451
    .end local v9    # "durationUs":J
    .restart local v25    # "durationUs":J
    :goto_5
    iget-boolean v6, v1, Landroidx/media3/common/Timeline$Window;->isSeekable:Z

    if-nez v6, :cond_7

    iget-boolean v6, v1, Landroidx/media3/common/Timeline$Window;->isPlaceholder:Z

    if-eqz v6, :cond_6

    goto :goto_6

    :cond_6
    move/from16 v6, v17

    goto :goto_7

    :cond_7
    :goto_6
    const/4 v6, 0x1

    :goto_7
    and-int/2addr v7, v6

    .line 452
    iget-boolean v6, v1, Landroidx/media3/common/Timeline$Window;->isDynamic:Z

    or-int/2addr v8, v6

    .line 454
    iget v6, v1, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    .local v6, "k":I
    :goto_8
    iget v9, v1, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    if-gt v6, v9, :cond_10

    .line 455
    invoke-static/range {v31 .. v32}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 456
    const/4 v9, 0x1

    invoke-virtual {v0, v6, v2, v9}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 457
    iget-wide v9, v2, Landroidx/media3/common/Timeline$Period;->durationUs:J

    .line 458
    .local v9, "periodDurationUs":J
    cmp-long v27, v9, v22

    if-nez v27, :cond_9

    .line 459
    move-object/from16 v27, v0

    .end local v0    # "timeline":Landroidx/media3/common/Timeline;
    .local v27, "timeline":Landroidx/media3/common/Timeline;
    iget v0, v1, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    move/from16 v28, v7

    .end local v7    # "isSeekable":Z
    .local v28, "isSeekable":Z
    iget v7, v1, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    if-ne v0, v7, :cond_8

    const/4 v0, 0x1

    goto :goto_9

    :cond_8
    move/from16 v0, v17

    :goto_9
    const-string v7, "Can\'t apply placeholder duration to multiple periods with unknown duration in a single window."

    invoke-static {v0, v7}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 463
    move v0, v8

    .end local v8    # "isDynamic":Z
    .local v0, "isDynamic":Z
    iget-wide v7, v1, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    add-long v9, v3, v7

    goto :goto_a

    .line 458
    .end local v27    # "timeline":Landroidx/media3/common/Timeline;
    .end local v28    # "isSeekable":Z
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    .restart local v7    # "isSeekable":Z
    .restart local v8    # "isDynamic":Z
    :cond_9
    move-object/from16 v27, v0

    move/from16 v28, v7

    move v0, v8

    .line 465
    .end local v7    # "isSeekable":Z
    .end local v8    # "isDynamic":Z
    .local v0, "isDynamic":Z
    .restart local v27    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v28    # "isSeekable":Z
    :goto_a
    const-wide/16 v7, 0x0

    .line 466
    .local v7, "timeOffsetUsForPeriod":J
    move/from16 v29, v0

    .end local v0    # "isDynamic":Z
    .local v29, "isDynamic":Z
    iget v0, v1, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    if-ne v6, v0, :cond_b

    iget v0, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->index:I

    if-nez v0, :cond_a

    if-eqz v12, :cond_b

    :cond_a
    const/4 v0, 0x1

    goto :goto_b

    :cond_b
    move/from16 v0, v17

    .line 468
    .local v0, "isFirstPeriodInNonFirstWindow":Z
    :goto_b
    if-eqz v0, :cond_c

    cmp-long v30, v9, v22

    if-eqz v30, :cond_c

    .line 469
    move-wide/from16 v37, v3

    .end local v3    # "windowDurationUs":J
    .local v37, "windowDurationUs":J
    iget-wide v3, v1, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    neg-long v7, v3

    .line 470
    add-long/2addr v9, v7

    goto :goto_c

    .line 468
    .end local v37    # "windowDurationUs":J
    .restart local v3    # "windowDurationUs":J
    :cond_c
    move-wide/from16 v37, v3

    .line 472
    .end local v3    # "windowDurationUs":J
    .restart local v37    # "windowDurationUs":J
    :goto_c
    iget-object v3, v2, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 473
    .local v3, "periodUid":Ljava/lang/Object;
    iget v4, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    if-eqz v4, :cond_f

    iget-object v4, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->periodTimeOffsetsByUid:Ljava/util/HashMap;

    .line 475
    invoke-virtual {v4, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_e

    iget-object v4, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->periodTimeOffsetsByUid:Ljava/util/HashMap;

    .line 476
    invoke-virtual {v4, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    move/from16 v30, v0

    .end local v0    # "isFirstPeriodInNonFirstWindow":Z
    .local v30, "isFirstPeriodInNonFirstWindow":Z
    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    goto :goto_d

    :cond_d
    move/from16 v0, v17

    goto :goto_e

    .line 475
    .end local v30    # "isFirstPeriodInNonFirstWindow":Z
    .restart local v0    # "isFirstPeriodInNonFirstWindow":Z
    :cond_e
    move/from16 v30, v0

    .end local v0    # "isFirstPeriodInNonFirstWindow":Z
    .restart local v30    # "isFirstPeriodInNonFirstWindow":Z
    goto :goto_d

    .line 473
    .end local v30    # "isFirstPeriodInNonFirstWindow":Z
    .restart local v0    # "isFirstPeriodInNonFirstWindow":Z
    :cond_f
    move/from16 v30, v0

    .line 476
    .end local v0    # "isFirstPeriodInNonFirstWindow":Z
    .restart local v30    # "isFirstPeriodInNonFirstWindow":Z
    :goto_d
    const/4 v0, 0x1

    .line 473
    :goto_e
    const-string v4, "Can\'t handle windows with changing offset in first period."

    invoke-static {v0, v4}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 478
    iget-object v0, v14, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->periodTimeOffsetsByUid:Ljava/util/HashMap;

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 479
    add-long v31, v31, v9

    .line 454
    .end local v3    # "periodUid":Ljava/lang/Object;
    .end local v7    # "timeOffsetUsForPeriod":J
    .end local v9    # "periodDurationUs":J
    .end local v30    # "isFirstPeriodInNonFirstWindow":Z
    add-int/lit8 v6, v6, 0x1

    move-object/from16 v0, v27

    move/from16 v7, v28

    move/from16 v8, v29

    move-wide/from16 v3, v37

    goto/16 :goto_8

    .end local v27    # "timeline":Landroidx/media3/common/Timeline;
    .end local v28    # "isSeekable":Z
    .end local v29    # "isDynamic":Z
    .end local v37    # "windowDurationUs":J
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    .local v3, "windowDurationUs":J
    .local v7, "isSeekable":Z
    .restart local v8    # "isDynamic":Z
    :cond_10
    move-object/from16 v27, v0

    move-wide/from16 v37, v3

    move/from16 v28, v7

    move/from16 v29, v8

    .line 428
    .end local v0    # "timeline":Landroidx/media3/common/Timeline;
    .end local v3    # "windowDurationUs":J
    .end local v6    # "k":I
    .end local v7    # "isSeekable":Z
    .end local v8    # "isDynamic":Z
    .restart local v27    # "timeline":Landroidx/media3/common/Timeline;
    .restart local v28    # "isSeekable":Z
    .restart local v29    # "isDynamic":Z
    add-int/lit8 v12, v12, 0x1

    move-object v3, v11

    move/from16 v11, v21

    move-object/from16 v17, v24

    move-wide/from16 v9, v25

    move-object/from16 v4, v36

    const/4 v6, 0x1

    goto/16 :goto_1

    .end local v21    # "periodCountInMediaSourceHolder":I
    .end local v24    # "initialManifest":Ljava/lang/Object;
    .end local v25    # "durationUs":J
    .end local v27    # "timeline":Landroidx/media3/common/Timeline;
    .end local v28    # "isSeekable":Z
    .end local v29    # "isDynamic":Z
    .end local v36    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .restart local v0    # "timeline":Landroidx/media3/common/Timeline;
    .local v3, "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .restart local v4    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .restart local v7    # "isSeekable":Z
    .restart local v8    # "isDynamic":Z
    .local v9, "durationUs":J
    .local v11, "periodCountInMediaSourceHolder":I
    .restart local v17    # "initialManifest":Ljava/lang/Object;
    :cond_11
    move-object/from16 v27, v0

    move-object/from16 v36, v4

    move/from16 v21, v11

    move-object v11, v3

    .line 420
    .end local v0    # "timeline":Landroidx/media3/common/Timeline;
    .end local v3    # "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .end local v4    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .end local v12    # "j":I
    .end local v14    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    .local v11, "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .restart local v36    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    add-int/lit8 v13, v13, 0x1

    move-object/from16 v0, p0

    move/from16 v6, v33

    move-wide/from16 v11, v34

    goto/16 :goto_0

    .end local v33    # "mediaSourceHoldersCount":I
    .end local v34    # "defaultPositionUs":J
    .end local v36    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .restart local v3    # "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .restart local v4    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .local v6, "mediaSourceHoldersCount":I
    .local v11, "defaultPositionUs":J
    :cond_12
    move-object/from16 v36, v4

    move/from16 v33, v6

    move-wide/from16 v34, v11

    move-object v11, v3

    .line 483
    .end local v3    # "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .end local v4    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    .end local v6    # "mediaSourceHoldersCount":I
    .end local v13    # "i":I
    .local v11, "timelinesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/common/Timeline;>;"
    .restart local v33    # "mediaSourceHoldersCount":I
    .restart local v34    # "defaultPositionUs":J
    .restart local v36    # "firstPeriodIndicesBuilder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Ljava/lang/Integer;>;"
    new-instance v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;

    .line 484
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getMediaItem()Landroidx/media3/common/MediaItem;

    move-result-object v20

    .line 485
    invoke-virtual {v11}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v21

    .line 486
    invoke-virtual/range {v36 .. v36}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v22

    .line 487
    invoke-virtual {v5}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v23

    .line 492
    if-eqz v15, :cond_13

    move-object/from16 v30, v17

    goto :goto_f

    :cond_13
    const/16 v30, 0x0

    :goto_f
    move-object/from16 v19, v0

    move/from16 v24, v7

    move/from16 v25, v8

    move-wide/from16 v26, v9

    move-wide/from16 v28, v34

    invoke-direct/range {v19 .. v30}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;-><init>(Landroidx/media3/common/MediaItem;Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;ZZJJLjava/lang/Object;)V

    .line 483
    return-object v0
.end method

.method private scheduleTimelineUpdate()V
    .locals 2

    .line 380
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->timelineUpdateScheduled:Z

    if-nez v0, :cond_0

    .line 381
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->playbackThreadHandler:Landroid/os/Handler;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 382
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->timelineUpdateScheduled:Z

    .line 384
    :cond_0
    return-void
.end method

.method private updateTimeline()V
    .locals 1

    .line 387
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->timelineUpdateScheduled:Z

    .line 388
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->maybeCreateConcatenatedTimeline()Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;

    move-result-object v0

    .line 389
    .local v0, "timeline":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;
    if-eqz v0, :cond_0

    .line 390
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->refreshSourceInfo(Landroidx/media3/common/Timeline;)V

    .line 392
    :cond_0
    return-void
.end method


# virtual methods
.method public canUpdateMediaItem(Landroidx/media3/common/MediaItem;)Z
    .locals 1
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;

    .line 255
    const/4 v0, 0x1

    return v0
.end method

.method public createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 9
    .param p1, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p2, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p3, "startPositionUs"    # J

    .line 282
    iget-object v0, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildIndex(Ljava/lang/Object;)I

    move-result v0

    .line 283
    .local v0, "holderIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1, v0}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    .line 284
    .local v1, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    iget-object v2, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    .line 285
    invoke-static {v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v2

    iget-wide v3, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-object v5, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    .line 288
    invoke-virtual {v5}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v5

    iget v6, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->index:I

    .line 287
    invoke-static {v3, v4, v5, v6}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildWindowSequenceNumber(JII)J

    move-result-wide v3

    .line 286
    invoke-virtual {v2, v3, v4}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithWindowSequenceNumber(J)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v2

    .line 289
    .local v2, "childMediaPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    iget v3, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->index:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->enableChildSource(Ljava/lang/Object;)V

    .line 290
    iget v3, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    add-int/lit8 v3, v3, 0x1

    iput v3, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    .line 292
    invoke-virtual {p1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 293
    const-wide/16 v3, 0x0

    goto :goto_0

    .line 294
    :cond_0
    iget-object v3, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->periodTimeOffsetsByUid:Ljava/util/HashMap;

    iget-object v4, v2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    :goto_0
    nop

    .line 295
    .local v3, "timeOffsetUs":J
    new-instance v5, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;

    iget-object v6, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    sub-long v7, p3, v3

    .line 297
    invoke-virtual {v6, v2, p2, v7, v8}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MaskingMediaPeriod;

    move-result-object v6

    invoke-direct {v5, v6, v3, v4}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;-><init>(Landroidx/media3/exoplayer/source/MediaPeriod;J)V

    .line 300
    .local v5, "mediaPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    iget-object v6, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v6, v5, v1}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->disableUnusedMediaSources()V

    .line 302
    return-object v5
.end method

.method protected enableInternal()V
    .locals 0

    .line 278
    return-void
.end method

.method public getInitialTimeline()Landroidx/media3/common/Timeline;
    .locals 1

    .line 245
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->maybeCreateConcatenatedTimeline()Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$ConcatenatedTimeline;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized getMediaItem()Landroidx/media3/common/MediaItem;
    .locals 1

    monitor-enter p0

    .line 250
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaItem:Landroidx/media3/common/MediaItem;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 250
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getMediaPeriodIdForChildMediaPeriodId(Ljava/lang/Integer;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 5
    .param p1, "childSourceId"    # Ljava/lang/Integer;
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 335
    iget-wide v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    .line 337
    invoke-virtual {v2}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v2

    .line 336
    invoke-static {v0, v1, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getChildIndexFromChildWindowSequenceNumber(JI)I

    move-result v0

    .line 338
    .local v0, "childIndex":I
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 341
    const/4 v1, 0x0

    return-object v1

    .line 343
    :cond_0
    iget-wide v1, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-object v3, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    .line 345
    invoke-virtual {v3}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v3

    .line 344
    invoke-static {v1, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getWindowSequenceNumberFromChildWindowSequenceNumber(JI)J

    move-result-wide v1

    .line 346
    .local v1, "windowSequenceNumber":J
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget-object v4, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {v3, v4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getPeriodUid(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 347
    .local v3, "periodUid":Ljava/lang/Object;
    nop

    .line 348
    invoke-virtual {p2, v3}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v4

    .line 349
    invoke-virtual {v4, v1, v2}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithWindowSequenceNumber(J)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v4

    .line 347
    return-object v4
.end method

.method protected bridge synthetic getMediaPeriodIdForChildMediaPeriodId(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 0

    .line 58
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getMediaPeriodIdForChildMediaPeriodId(Ljava/lang/Integer;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object p1

    return-object p1
.end method

.method protected getMediaTimeForChildMediaTime(Ljava/lang/Integer;JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)J
    .locals 3
    .param p1, "childSourceId"    # Ljava/lang/Integer;
    .param p2, "mediaTimeMs"    # J
    .param p4, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 360
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, p2, v0

    if-eqz v0, :cond_2

    if-eqz p4, :cond_2

    invoke-virtual {p4}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 364
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    .line 365
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->periodTimeOffsetsByUid:Ljava/util/HashMap;

    iget-object v1, p4, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 366
    .local v0, "timeOffsetUs":Ljava/lang/Long;
    if-nez v0, :cond_1

    .line 367
    return-wide p2

    .line 369
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v1

    add-long/2addr v1, p2

    return-wide v1

    .line 361
    .end local v0    # "timeOffsetUs":Ljava/lang/Long;
    :cond_2
    :goto_0
    return-wide p2
.end method

.method protected bridge synthetic getMediaTimeForChildMediaTime(Ljava/lang/Object;JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)J
    .locals 0

    .line 58
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getMediaTimeForChildMediaTime(Ljava/lang/Integer;JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)J

    move-result-wide p1

    return-wide p1
.end method

.method protected getWindowIndexForChildWindowIndex(Ljava/lang/Integer;I)I
    .locals 1
    .param p1, "childSourceId"    # Ljava/lang/Integer;
    .param p2, "windowIndex"    # I

    .line 354
    const/4 v0, 0x0

    return v0
.end method

.method protected bridge synthetic getWindowIndexForChildWindowIndex(Ljava/lang/Object;I)I
    .locals 0

    .line 58
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->getWindowIndexForChildWindowIndex(Ljava/lang/Integer;I)I

    move-result p1

    return p1
.end method

.method protected onChildSourceInfoRefreshed(Ljava/lang/Integer;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V
    .locals 0
    .param p1, "childSourceId"    # Ljava/lang/Integer;
    .param p2, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;
    .param p3, "newTimeline"    # Landroidx/media3/common/Timeline;

    .line 328
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->scheduleTimelineUpdate()V

    .line 329
    return-void
.end method

.method protected bridge synthetic onChildSourceInfoRefreshed(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V
    .locals 0

    .line 58
    check-cast p1, Ljava/lang/Integer;

    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->onChildSourceInfoRefreshed(Ljava/lang/Integer;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V

    return-void
.end method

.method protected prepareSourceInternal(Landroidx/media3/datasource/TransferListener;)V
    .locals 4
    .param p1, "mediaTransferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 265
    invoke-super {p0, p1}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->prepareSourceInternal(Landroidx/media3/datasource/TransferListener;)V

    .line 266
    new-instance v0, Landroid/os/Handler;

    new-instance v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;)V

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Handler$Callback;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->playbackThreadHandler:Landroid/os/Handler;

    .line 267
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 268
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceHolders:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v1, v0}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    .line 269
    .local v1, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {p0, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->prepareChildSource(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 267
    .end local v1    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 271
    .end local v0    # "i":I
    :cond_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->scheduleTimelineUpdate()V

    .line 272
    return-void
.end method

.method public releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 3
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 307
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v0, p1}, Ljava/util/IdentityHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;

    .line 308
    .local v0, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;
    iget-object v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    move-object v2, p1

    check-cast v2, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/source/TimeOffsetMediaPeriod;->getWrappedMediaPeriod()Landroidx/media3/exoplayer/source/MediaPeriod;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 309
    iget v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2$MediaSourceHolder;->activeMediaPeriods:I

    .line 310
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v1}, Ljava/util/IdentityHashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 311
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->disableUnusedMediaSources()V

    .line 313
    :cond_0
    return-void
.end method

.method protected releaseSourceInternal()V
    .locals 2

    .line 317
    invoke-super {p0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->releaseSourceInternal()V

    .line 318
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->playbackThreadHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 319
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 320
    iput-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->playbackThreadHandler:Landroid/os/Handler;

    .line 322
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->timelineUpdateScheduled:Z

    .line 323
    return-void
.end method

.method public declared-synchronized updateMediaItem(Landroidx/media3/common/MediaItem;)V
    .locals 0
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;

    monitor-enter p0

    .line 260
    :try_start_0
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;->mediaItem:Landroidx/media3/common/MediaItem;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 261
    monitor-exit p0

    return-void

    .line 259
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource2;
    .end local p1    # "mediaItem":Landroidx/media3/common/MediaItem;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
