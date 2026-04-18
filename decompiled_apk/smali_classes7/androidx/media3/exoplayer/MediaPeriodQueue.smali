.class final Landroidx/media3/exoplayer/MediaPeriodQueue;
.super Ljava/lang/Object;
.source "MediaPeriodQueue.java"


# static fields
.field public static final INITIAL_RENDERER_POSITION_OFFSET_US:J = 0xe8d4a51000L

.field private static final MAXIMUM_BUFFER_AHEAD_PERIODS:I = 0x64


# instance fields
.field private final analyticsCollector:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

.field private final analyticsCollectorHandler:Landroidx/media3/common/util/HandlerWrapper;

.field private length:I

.field private loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

.field private final mediaPeriodHolderFactory:Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;

.field private nextWindowSequenceNumber:J

.field private oldFrontPeriodUid:Ljava/lang/Object;

.field private oldFrontPeriodWindowSequenceNumber:J

.field private final period:Landroidx/media3/common/Timeline$Period;

.field private playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

.field private reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

.field private repeatMode:I

.field private shuffleModeEnabled:Z

.field private final window:Landroidx/media3/common/Timeline$Window;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/analytics/AnalyticsCollector;Landroidx/media3/common/util/HandlerWrapper;Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;)V
    .locals 1
    .param p1, "analyticsCollector"    # Landroidx/media3/exoplayer/analytics/AnalyticsCollector;
    .param p2, "analyticsCollectorHandler"    # Landroidx/media3/common/util/HandlerWrapper;
    .param p3, "mediaPeriodHolderFactory"    # Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    iput-object p1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->analyticsCollector:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

    .line 99
    iput-object p2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->analyticsCollectorHandler:Landroidx/media3/common/util/HandlerWrapper;

    .line 100
    iput-object p3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->mediaPeriodHolderFactory:Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;

    .line 101
    new-instance v0, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v0}, Landroidx/media3/common/Timeline$Period;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 102
    new-instance v0, Landroidx/media3/common/Timeline$Window;

    invoke-direct {v0}, Landroidx/media3/common/Timeline$Window;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    .line 103
    return-void
.end method

.method private areDurationsCompatible(JJ)Z
    .locals 2
    .param p1, "previousDurationUs"    # J
    .param p3, "newDurationUs"    # J

    .line 610
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, p1, v0

    if-eqz v0, :cond_1

    cmp-long v0, p1, p3

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method private canKeepMediaPeriodHolder(Landroidx/media3/exoplayer/MediaPeriodInfo;Landroidx/media3/exoplayer/MediaPeriodInfo;)Z
    .locals 4
    .param p1, "oldInfo"    # Landroidx/media3/exoplayer/MediaPeriodInfo;
    .param p2, "newInfo"    # Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 603
    iget-wide v0, p1, Landroidx/media3/exoplayer/MediaPeriodInfo;->startPositionUs:J

    iget-wide v2, p2, Landroidx/media3/exoplayer/MediaPeriodInfo;->startPositionUs:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p1, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v1, p2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private getFirstMediaPeriodInfo(Landroidx/media3/exoplayer/PlaybackInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 7
    .param p1, "playbackInfo"    # Landroidx/media3/exoplayer/PlaybackInfo;

    .line 662
    iget-object v1, p1, Landroidx/media3/exoplayer/PlaybackInfo;->timeline:Landroidx/media3/common/Timeline;

    iget-object v2, p1, Landroidx/media3/exoplayer/PlaybackInfo;->periodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v3, p1, Landroidx/media3/exoplayer/PlaybackInfo;->requestedContentPositionUs:J

    iget-wide v5, p1, Landroidx/media3/exoplayer/PlaybackInfo;->positionUs:J

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0
.end method

.method private getFirstMediaPeriodInfoOfNextPeriod(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 27
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "mediaPeriodHolder"    # Landroidx/media3/exoplayer/MediaPeriodHolder;
    .param p3, "bufferedDurationUs"    # J

    .line 712
    move-object/from16 v7, p0

    move-object/from16 v6, p1

    move-object/from16 v14, p2

    iget-object v15, v14, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 713
    .local v15, "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    iget-object v0, v15, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-virtual {v6, v0}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v16

    .line 714
    .local v16, "currentPeriodIndex":I
    iget-object v2, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-object v3, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget v4, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->repeatMode:I

    iget-boolean v5, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->shuffleModeEnabled:Z

    .line 715
    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-virtual/range {v0 .. v5}, Landroidx/media3/common/Timeline;->getNextPeriodIndex(ILandroidx/media3/common/Timeline$Period;Landroidx/media3/common/Timeline$Window;IZ)I

    move-result v5

    .line 717
    .local v5, "nextPeriodIndex":I
    const/4 v0, -0x1

    const/4 v1, 0x0

    if-ne v5, v0, :cond_0

    .line 719
    return-object v1

    .line 721
    :cond_0
    const-wide/16 v2, 0x0

    .line 722
    .local v2, "startPositionUs":J
    const-wide/16 v8, 0x0

    .line 723
    .local v8, "contentPositionUs":J
    iget-object v0, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 724
    const/4 v4, 0x1

    invoke-virtual {v6, v5, v0, v4}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    move-result-object v0

    iget v4, v0, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 725
    .local v4, "nextWindowIndex":I
    iget-object v0, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-object v0, v0, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 726
    .local v0, "nextPeriodUid":Ljava/lang/Object;
    iget-object v10, v15, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v12, v10, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    .line 727
    .local v12, "windowSequenceNumber":J
    iget-object v10, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {v6, v4, v10}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v10

    iget v10, v10, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    if-ne v10, v5, :cond_3

    .line 731
    const-wide v17, -0x7fffffffffffffffL    # -4.9E-324

    .line 733
    .end local v8    # "contentPositionUs":J
    .local v17, "contentPositionUs":J
    iget-object v9, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget-object v10, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    const-wide v19, -0x7fffffffffffffffL    # -4.9E-324

    .line 739
    move-wide/from16 v21, v2

    .end local v2    # "startPositionUs":J
    .local v21, "startPositionUs":J
    const-wide/16 v1, 0x0

    move-wide/from16 v23, v12

    move-wide/from16 v12, p3

    .end local v12    # "windowSequenceNumber":J
    .local v23, "windowSequenceNumber":J
    invoke-static {v1, v2, v12, v13}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v1

    .line 734
    move-object/from16 v8, p1

    move v11, v4

    move-wide/from16 v12, v19

    move-object v3, v15

    .end local v15    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .local v3, "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    move-wide v14, v1

    invoke-virtual/range {v8 .. v15}, Landroidx/media3/common/Timeline;->getPeriodPositionUs(Landroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;IJJ)Landroid/util/Pair;

    move-result-object v1

    .line 740
    .local v1, "defaultPositionUs":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Object;Ljava/lang/Long;>;"
    if-nez v1, :cond_1

    .line 741
    const/4 v2, 0x0

    return-object v2

    .line 743
    :cond_1
    iget-object v0, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    .line 744
    iget-object v2, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Long;

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    .line 745
    .end local v21    # "startPositionUs":J
    .local v8, "startPositionUs":J
    invoke-virtual/range {p2 .. p2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v2

    .line 746
    .local v2, "nextMediaPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    if-eqz v2, :cond_2

    iget-object v10, v2, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    invoke-virtual {v10, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 747
    iget-object v10, v2, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v10, v10, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v12, v10, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-wide/from16 v21, v8

    move-wide/from16 v23, v12

    move-wide/from16 v25, v17

    move-object/from16 v17, v0

    move-wide/from16 v0, v25

    .end local v23    # "windowSequenceNumber":J
    .restart local v12    # "windowSequenceNumber":J
    goto :goto_0

    .line 749
    .end local v12    # "windowSequenceNumber":J
    .restart local v23    # "windowSequenceNumber":J
    :cond_2
    iget-wide v10, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->nextWindowSequenceNumber:J

    const-wide/16 v12, 0x1

    add-long/2addr v12, v10

    iput-wide v12, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->nextWindowSequenceNumber:J

    move-wide v12, v10

    move-wide/from16 v21, v8

    move-wide/from16 v23, v12

    move-wide/from16 v25, v17

    move-object/from16 v17, v0

    move-wide/from16 v0, v25

    .end local v23    # "windowSequenceNumber":J
    .restart local v12    # "windowSequenceNumber":J
    goto :goto_0

    .line 727
    .end local v1    # "defaultPositionUs":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Object;Ljava/lang/Long;>;"
    .end local v3    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .end local v17    # "contentPositionUs":J
    .local v2, "startPositionUs":J
    .local v8, "contentPositionUs":J
    .restart local v15    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    :cond_3
    move-wide/from16 v21, v2

    move-wide/from16 v23, v12

    move-object v3, v15

    .end local v2    # "startPositionUs":J
    .end local v12    # "windowSequenceNumber":J
    .end local v15    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .restart local v3    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .restart local v21    # "startPositionUs":J
    .restart local v23    # "windowSequenceNumber":J
    move-object/from16 v17, v0

    move-wide v0, v8

    .line 754
    .end local v8    # "contentPositionUs":J
    .local v0, "contentPositionUs":J
    .local v17, "nextPeriodUid":Ljava/lang/Object;
    :goto_0
    iget-object v14, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget-object v15, v7, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 755
    move-object/from16 v8, p1

    move-object/from16 v9, v17

    move-wide/from16 v10, v21

    move-wide/from16 v12, v23

    invoke-static/range {v8 .. v15}, Landroidx/media3/exoplayer/MediaPeriodQueue;->resolveMediaPeriodIdForAds(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJLandroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v8

    .line 757
    .local v8, "periodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    const-wide v9, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v2, v0, v9

    if-eqz v2, :cond_5

    iget-wide v11, v3, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    cmp-long v2, v11, v9

    if-eqz v2, :cond_5

    .line 759
    iget-object v2, v3, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v2, v2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    .line 760
    invoke-direct {v7, v2, v6}, Landroidx/media3/exoplayer/MediaPeriodQueue;->hasServerSideInsertedAds(Ljava/lang/Object;Landroidx/media3/common/Timeline;)Z

    move-result v2

    .line 762
    .local v2, "precedingPeriodHasServerSideInsertedAds":Z
    invoke-virtual {v8}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v9

    if-eqz v9, :cond_4

    if-eqz v2, :cond_4

    .line 764
    iget-wide v0, v3, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    move-wide v9, v0

    goto :goto_1

    .line 765
    :cond_4
    if-eqz v2, :cond_5

    .line 767
    iget-wide v9, v3, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    move-wide/from16 v21, v9

    move-wide v9, v0

    .end local v21    # "startPositionUs":J
    .local v9, "startPositionUs":J
    goto :goto_1

    .line 770
    .end local v2    # "precedingPeriodHasServerSideInsertedAds":Z
    .end local v9    # "startPositionUs":J
    .restart local v21    # "startPositionUs":J
    :cond_5
    move-wide v9, v0

    .end local v0    # "contentPositionUs":J
    .local v9, "contentPositionUs":J
    :goto_1
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object v2, v8

    move-object v11, v3

    move v12, v4

    .end local v3    # "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .end local v4    # "nextWindowIndex":I
    .local v11, "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .local v12, "nextWindowIndex":I
    move-wide v3, v9

    move v13, v5

    .end local v5    # "nextPeriodIndex":I
    .local v13, "nextPeriodIndex":I
    move-wide/from16 v5, v21

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0
.end method

.method private getFollowingMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 5
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "mediaPeriodHolder"    # Landroidx/media3/exoplayer/MediaPeriodHolder;
    .param p3, "rendererPositionUs"    # J

    .line 686
    iget-object v0, p2, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 690
    .local v0, "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    nop

    .line 691
    invoke-virtual {p2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getRendererOffset()J

    move-result-wide v1

    iget-wide v3, v0, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    add-long/2addr v1, v3

    sub-long/2addr v1, p3

    .line 692
    .local v1, "bufferedDurationUs":J
    iget-boolean v3, v0, Landroidx/media3/exoplayer/MediaPeriodInfo;->isLastInTimelinePeriod:Z

    if-eqz v3, :cond_0

    .line 693
    invoke-direct {p0, p1, p2, v1, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFirstMediaPeriodInfoOfNextPeriod(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v3

    goto :goto_0

    .line 694
    :cond_0
    invoke-direct {p0, p1, p2, v1, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFollowingMediaPeriodInfoOfCurrentPeriod(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v3

    .line 692
    :goto_0
    return-object v3
.end method

.method private getFollowingMediaPeriodInfoOfCurrentPeriod(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 23
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "mediaPeriodHolder"    # Landroidx/media3/exoplayer/MediaPeriodHolder;
    .param p3, "bufferedDurationUs"    # J

    .line 785
    move-object/from16 v9, p0

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    iget-object v12, v11, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 786
    .local v12, "mediaPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    iget-object v13, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 787
    .local v13, "currentPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    iget-object v0, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v1, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v10, v0, v1}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 788
    invoke-virtual {v13}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v0

    const/4 v1, -0x1

    if-eqz v0, :cond_4

    .line 789
    iget v14, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    .line 790
    .local v14, "adGroupIndex":I
    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v0, v14}, Landroidx/media3/common/Timeline$Period;->getAdCountInAdGroup(I)I

    move-result v15

    .line 791
    .local v15, "adCountInCurrentAdGroup":I
    const/4 v8, 0x0

    if-ne v15, v1, :cond_0

    .line 792
    return-object v8

    .line 794
    :cond_0
    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    .line 795
    invoke-virtual {v0, v14, v1}, Landroidx/media3/common/Timeline$Period;->getNextAdIndexToPlay(II)I

    move-result v7

    .line 796
    .local v7, "nextAdIndexInAdGroup":I
    if-ge v7, v15, :cond_1

    .line 798
    iget-object v2, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-wide v5, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    iget-wide v3, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide/from16 v16, v3

    move v3, v14

    move v4, v7

    move/from16 v18, v7

    .end local v7    # "nextAdIndexInAdGroup":I
    .local v18, "nextAdIndexInAdGroup":I
    move-wide/from16 v7, v16

    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForAd(Landroidx/media3/common/Timeline;Ljava/lang/Object;IIJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0

    .line 807
    .end local v18    # "nextAdIndexInAdGroup":I
    .restart local v7    # "nextAdIndexInAdGroup":I
    :cond_1
    move/from16 v18, v7

    .end local v7    # "nextAdIndexInAdGroup":I
    .restart local v18    # "nextAdIndexInAdGroup":I
    iget-wide v6, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    .line 808
    .local v6, "startPositionUs":J
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v6, v0

    if-nez v0, :cond_3

    .line 812
    iget-object v1, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget-object v2, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v3, v2, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 818
    const-wide/16 v8, 0x0

    move-wide/from16 v4, p3

    invoke-static {v8, v9, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v8

    .line 813
    move-object/from16 v0, p1

    const-wide v4, -0x7fffffffffffffffL    # -4.9E-324

    move-wide/from16 v19, v6

    .end local v6    # "startPositionUs":J
    .local v19, "startPositionUs":J
    move-wide v6, v8

    invoke-virtual/range {v0 .. v7}, Landroidx/media3/common/Timeline;->getPeriodPositionUs(Landroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;IJJ)Landroid/util/Pair;

    move-result-object v0

    .line 819
    .local v0, "defaultPositionUs":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Object;Ljava/lang/Long;>;"
    if-nez v0, :cond_2

    .line 820
    const/4 v1, 0x0

    return-object v1

    .line 822
    :cond_2
    iget-object v1, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    move-wide v7, v6

    .end local v19    # "startPositionUs":J
    .restart local v6    # "startPositionUs":J
    goto :goto_0

    .line 808
    .end local v0    # "defaultPositionUs":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Object;Ljava/lang/Long;>;"
    :cond_3
    move-wide/from16 v19, v6

    .end local v6    # "startPositionUs":J
    .restart local v19    # "startPositionUs":J
    move-wide/from16 v7, v19

    .line 824
    .end local v19    # "startPositionUs":J
    .local v7, "startPositionUs":J
    :goto_0
    iget-object v0, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    .line 825
    move-object/from16 v9, p0

    invoke-direct {v9, v10, v0, v1}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMinStartPositionAfterAdGroupUs(Landroidx/media3/common/Timeline;Ljava/lang/Object;I)J

    move-result-wide v5

    .line 827
    .local v5, "minStartPositionUs":J
    iget-object v2, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    .line 830
    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    iget-wide v0, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    move-wide/from16 v16, v7

    .end local v7    # "startPositionUs":J
    .local v16, "startPositionUs":J
    iget-wide v7, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    .line 827
    move-wide/from16 v19, v0

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide/from16 v21, v5

    .end local v5    # "minStartPositionUs":J
    .local v21, "minStartPositionUs":J
    move-wide/from16 v5, v19

    move-wide/from16 v19, v16

    .end local v16    # "startPositionUs":J
    .restart local v19    # "startPositionUs":J
    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForContent(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0

    .line 834
    .end local v14    # "adGroupIndex":I
    .end local v15    # "adCountInCurrentAdGroup":I
    .end local v18    # "nextAdIndexInAdGroup":I
    .end local v19    # "startPositionUs":J
    .end local v21    # "minStartPositionUs":J
    :cond_4
    iget v0, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    if-eq v0, v1, :cond_5

    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    .line 835
    invoke-virtual {v0, v1}, Landroidx/media3/common/Timeline$Period;->isLivePostrollPlaceholder(I)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 837
    invoke-direct/range {p0 .. p4}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFirstMediaPeriodInfoOfNextPeriod(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0

    .line 840
    :cond_5
    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    invoke-virtual {v0, v1}, Landroidx/media3/common/Timeline$Period;->getFirstAdIndexToPlay(I)I

    move-result v14

    .line 841
    .local v14, "adIndexInAdGroup":I
    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    .line 842
    invoke-virtual {v0, v1}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v0

    if-eqz v0, :cond_6

    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    .line 843
    invoke-virtual {v0, v1, v14}, Landroidx/media3/common/Timeline$Period;->getAdState(II)I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_6

    const/4 v0, 0x1

    goto :goto_1

    :cond_6
    const/4 v0, 0x0

    :goto_1
    move v15, v0

    .line 845
    .local v15, "isPlayedServerSideInsertedAd":Z
    iget-object v0, v9, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    invoke-virtual {v0, v1}, Landroidx/media3/common/Timeline$Period;->getAdCountInAdGroup(I)I

    move-result v0

    if-eq v14, v0, :cond_8

    if-eqz v15, :cond_7

    goto :goto_2

    .line 859
    :cond_7
    iget-object v2, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget v3, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    iget-wide v5, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    iget-wide v7, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v4, v14

    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForAd(Landroidx/media3/common/Timeline;Ljava/lang/Object;IIJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0

    .line 849
    :cond_8
    :goto_2
    iget-object v0, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget v1, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    .line 850
    invoke-direct {v9, v10, v0, v1}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMinStartPositionAfterAdGroupUs(Landroidx/media3/common/Timeline;Ljava/lang/Object;I)J

    move-result-wide v16

    .line 852
    .restart local v16    # "startPositionUs":J
    iget-object v2, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-wide v5, v12, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    iget-wide v7, v13, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide/from16 v3, v16

    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForContent(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    return-object v0
.end method

.method private getMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJ)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 13
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "requestedContentPositionUs"    # J
    .param p5, "startPositionUs"    # J

    .line 880
    move-object v0, p2

    iget-object v1, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    move-object v11, p0

    iget-object v2, v11, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move-object v12, p1

    invoke-virtual {p1, v1, v2}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 881
    invoke-virtual {p2}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 882
    iget-object v4, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget v5, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    iget v6, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    iget-wide v9, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-object v2, p0

    move-object v3, p1

    move-wide/from16 v7, p3

    invoke-direct/range {v2 .. v10}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForAd(Landroidx/media3/common/Timeline;Ljava/lang/Object;IIJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v1

    return-object v1

    .line 890
    :cond_0
    iget-object v4, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-wide v9, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    move-object v2, p0

    move-object v3, p1

    move-wide/from16 v5, p5

    move-wide/from16 v7, p3

    invoke-direct/range {v2 .. v10}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getMediaPeriodInfoForContent(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v1

    return-object v1
.end method

.method private getMediaPeriodInfoForAd(Landroidx/media3/common/Timeline;Ljava/lang/Object;IIJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 24
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;
    .param p3, "adGroupIndex"    # I
    .param p4, "adIndexInAdGroup"    # I
    .param p5, "contentPositionUs"    # J
    .param p7, "windowSequenceNumber"    # J

    .line 906
    move-object/from16 v0, p0

    new-instance v7, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-object v1, v7

    move-object/from16 v2, p2

    move/from16 v3, p3

    move/from16 v4, p4

    move-wide/from16 v5, p7

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;-><init>(Ljava/lang/Object;IIJ)V

    .line 908
    .local v1, "id":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    iget-object v2, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 910
    move-object/from16 v4, p1

    invoke-virtual {v4, v2, v3}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v2

    iget v3, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    iget v5, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    .line 911
    invoke-virtual {v2, v3, v5}, Landroidx/media3/common/Timeline$Period;->getAdDurationUs(II)J

    move-result-wide v2

    .line 913
    .local v2, "durationUs":J
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move/from16 v6, p3

    invoke-virtual {v5, v6}, Landroidx/media3/common/Timeline$Period;->getFirstAdIndexToPlay(I)I

    move-result v5

    const-wide/16 v7, 0x0

    move/from16 v14, p4

    if-ne v14, v5, :cond_0

    .line 914
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v5}, Landroidx/media3/common/Timeline$Period;->getAdResumePositionUs()J

    move-result-wide v9

    goto :goto_0

    .line 915
    :cond_0
    move-wide v9, v7

    :goto_0
    nop

    .line 916
    .local v9, "startPositionUs":J
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v11, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    .line 917
    invoke-virtual {v5, v11}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v5

    .line 918
    .local v5, "isFollowedByTransitionToSameStream":Z
    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v11, v2, v11

    if-eqz v11, :cond_1

    cmp-long v11, v9, v2

    if-ltz v11, :cond_1

    .line 920
    const-wide/16 v11, 0x1

    sub-long v11, v2, v11

    invoke-static {v7, v8, v11, v12}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v9

    move-wide/from16 v22, v9

    goto :goto_1

    .line 922
    :cond_1
    move-wide/from16 v22, v9

    .end local v9    # "startPositionUs":J
    .local v22, "startPositionUs":J
    :goto_1
    new-instance v7, Landroidx/media3/exoplayer/MediaPeriodInfo;

    const-wide v15, -0x7fffffffffffffffL    # -4.9E-324

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    move-object v8, v7

    move-object v9, v1

    move-wide/from16 v10, v22

    move-wide/from16 v12, p5

    move-wide v14, v15

    move-wide/from16 v16, v2

    move/from16 v18, v5

    invoke-direct/range {v8 .. v21}, Landroidx/media3/exoplayer/MediaPeriodInfo;-><init>(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJJJZZZZ)V

    return-object v7
.end method

.method private getMediaPeriodInfoForContent(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJJ)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 32
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;
    .param p3, "startPositionUs"    # J
    .param p5, "requestedContentPositionUs"    # J
    .param p7, "windowSequenceNumber"    # J

    .line 940
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-wide/from16 v3, p3

    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v1, v2, v5}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 941
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v5, v3, v4}, Landroidx/media3/common/Timeline$Period;->getAdGroupIndexAfterPositionUs(J)I

    move-result v5

    .line 942
    .local v5, "nextAdGroupIndex":I
    const/4 v8, -0x1

    if-eq v5, v8, :cond_0

    iget-object v9, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 943
    invoke-virtual {v9, v5}, Landroidx/media3/common/Timeline$Period;->isLivePostrollPlaceholder(I)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v9, 0x1

    goto :goto_0

    :cond_0
    const/4 v9, 0x0

    .line 944
    .local v9, "isNextAdGroupPostrollPlaceholder":Z
    :goto_0
    const/4 v10, 0x0

    .line 945
    .local v10, "clipPeriodAtContentDuration":Z
    if-ne v5, v8, :cond_2

    .line 947
    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 948
    invoke-virtual {v11}, Landroidx/media3/common/Timeline$Period;->getAdGroupCount()I

    move-result v11

    if-lez v11, :cond_1

    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 949
    invoke-virtual {v11}, Landroidx/media3/common/Timeline$Period;->getRemovedAdGroupCount()I

    move-result v12

    invoke-virtual {v11, v12}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v11

    if-eqz v11, :cond_1

    const/4 v11, 0x1

    goto :goto_1

    :cond_1
    const/4 v11, 0x0

    :goto_1
    move v10, v11

    goto :goto_2

    .line 950
    :cond_2
    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v11, v5}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v11

    if-eqz v11, :cond_3

    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 951
    invoke-virtual {v11, v5}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v11

    iget-object v13, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v13, v13, Landroidx/media3/common/Timeline$Period;->durationUs:J

    cmp-long v11, v11, v13

    if-nez v11, :cond_3

    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 952
    invoke-virtual {v11, v5}, Landroidx/media3/common/Timeline$Period;->hasPlayedAdGroup(I)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 954
    const/4 v5, -0x1

    .line 955
    const/4 v10, 0x1

    .line 958
    :cond_3
    :goto_2
    new-instance v11, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-wide/from16 v12, p7

    invoke-direct {v11, v2, v12, v13, v5}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;-><init>(Ljava/lang/Object;JI)V

    .line 959
    .local v11, "id":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    invoke-direct {v0, v11}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v15

    .line 960
    .local v15, "isLastInPeriod":Z
    invoke-direct {v0, v1, v11}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInWindow(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v28

    .line 961
    .local v28, "isLastInWindow":Z
    invoke-direct {v0, v1, v11, v15}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInTimeline(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Z)Z

    move-result v29

    .line 962
    .local v29, "isLastInTimeline":Z
    if-eq v5, v8, :cond_4

    iget-object v14, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 964
    invoke-virtual {v14, v5}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v14

    if-eqz v14, :cond_4

    if-nez v9, :cond_4

    const/16 v24, 0x1

    goto :goto_3

    :cond_4
    const/16 v24, 0x0

    .line 967
    .local v24, "isFollowedByTransitionToSameStream":Z
    :goto_3
    const-wide v16, -0x7fffffffffffffffL    # -4.9E-324

    if-eq v5, v8, :cond_5

    if-nez v9, :cond_5

    .line 968
    iget-object v8, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v8, v5}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v18

    move-wide/from16 v6, v18

    goto :goto_4

    .line 969
    :cond_5
    if-eqz v10, :cond_6

    iget-object v8, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v6, v8, Landroidx/media3/common/Timeline$Period;->durationUs:J

    goto :goto_4

    :cond_6
    move-wide/from16 v6, v16

    :goto_4
    nop

    .line 971
    .local v6, "endPositionUs":J
    cmp-long v8, v6, v16

    if-eqz v8, :cond_8

    const-wide/high16 v19, -0x8000000000000000L

    cmp-long v8, v6, v19

    if-nez v8, :cond_7

    goto :goto_5

    .line 973
    :cond_7
    move/from16 v19, v15

    move-wide v14, v6

    goto :goto_6

    .line 972
    :cond_8
    :goto_5
    iget-object v8, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move/from16 v19, v15

    .end local v15    # "isLastInPeriod":Z
    .local v19, "isLastInPeriod":Z
    iget-wide v14, v8, Landroidx/media3/common/Timeline$Period;->durationUs:J

    .line 973
    :goto_6
    move-wide/from16 v30, v14

    .line 974
    .local v30, "durationUs":J
    cmp-long v8, v30, v16

    if-eqz v8, :cond_c

    cmp-long v8, v3, v30

    if-ltz v8, :cond_c

    .line 976
    if-nez v29, :cond_a

    if-nez v10, :cond_9

    goto :goto_7

    :cond_9
    const/4 v8, 0x0

    goto :goto_8

    :cond_a
    :goto_7
    const/4 v8, 0x1

    .line 977
    .local v8, "endAtLastFrame":Z
    :goto_8
    if-eqz v8, :cond_b

    const/4 v14, 0x1

    goto :goto_9

    :cond_b
    const/4 v14, 0x0

    :goto_9
    int-to-long v14, v14

    sub-long v14, v30, v14

    const-wide/16 v0, 0x0

    invoke-static {v0, v1, v14, v15}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    .end local p3    # "startPositionUs":J
    .local v0, "startPositionUs":J
    goto :goto_a

    .line 979
    .end local v0    # "startPositionUs":J
    .end local v8    # "endAtLastFrame":Z
    .restart local p3    # "startPositionUs":J
    :cond_c
    move-wide v0, v3

    .end local p3    # "startPositionUs":J
    .restart local v0    # "startPositionUs":J
    :goto_a
    new-instance v3, Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-object v14, v3

    move/from16 v4, v19

    .end local v19    # "isLastInPeriod":Z
    .local v4, "isLastInPeriod":Z
    move-object v15, v11

    move-wide/from16 v16, v0

    move-wide/from16 v18, p5

    move-wide/from16 v20, v6

    move-wide/from16 v22, v30

    move/from16 v25, v4

    move/from16 v26, v28

    move/from16 v27, v29

    invoke-direct/range {v14 .. v27}, Landroidx/media3/exoplayer/MediaPeriodInfo;-><init>(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJJJZZZZ)V

    return-object v3
.end method

.method private getMinStartPositionAfterAdGroupUs(Landroidx/media3/common/Timeline;Ljava/lang/Object;I)J
    .locals 4
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;
    .param p3, "adGroupIndex"    # I

    .line 1015
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, p2, v0}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 1016
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v0, p3}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v0

    .line 1017
    .local v0, "startPositionUs":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    .line 1018
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v2, v2, Landroidx/media3/common/Timeline$Period;->durationUs:J

    return-wide v2

    .line 1020
    :cond_0
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v2, p3}, Landroidx/media3/common/Timeline$Period;->getContentResumeOffsetUs(I)J

    move-result-wide v2

    add-long/2addr v2, v0

    return-wide v2
.end method

.method private hasServerSideInsertedAds(Ljava/lang/Object;Landroidx/media3/common/Timeline;)Z
    .locals 7
    .param p1, "periodUid"    # Ljava/lang/Object;
    .param p2, "timeline"    # Landroidx/media3/common/Timeline;

    .line 870
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p2, p1, v0}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Timeline$Period;->getAdGroupCount()I

    move-result v0

    .line 871
    .local v0, "adGroupCount":I
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v1}, Landroidx/media3/common/Timeline$Period;->getRemovedAdGroupCount()I

    move-result v1

    .line 872
    .local v1, "firstAdGroupIndex":I
    if-lez v0, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 873
    invoke-virtual {v2, v1}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    if-gt v0, v2, :cond_0

    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    .line 874
    invoke-virtual {v3, v1}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v3

    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v3, v3, v5

    if-eqz v3, :cond_1

    :cond_0
    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    .line 872
    :goto_0
    return v2
.end method

.method private isLastInPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z
    .locals 2
    .param p1, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 992
    invoke-virtual {p1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private isLastInTimeline(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Z)Z
    .locals 8
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "isLastMediaPeriodInPeriod"    # Z

    .line 1006
    iget-object v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-virtual {p1, v0}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v0

    .line 1007
    .local v0, "periodIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, v0, v1}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v1

    iget v7, v1, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 1008
    .local v7, "windowIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {p1, v7, v1}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v1

    iget-boolean v1, v1, Landroidx/media3/common/Timeline$Window;->isDynamic:Z

    if-nez v1, :cond_0

    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-object v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget v5, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->repeatMode:I

    iget-boolean v6, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->shuffleModeEnabled:Z

    .line 1009
    move-object v1, p1

    move v2, v0

    invoke-virtual/range {v1 .. v6}, Landroidx/media3/common/Timeline;->isLastPeriod(ILandroidx/media3/common/Timeline$Period;Landroidx/media3/common/Timeline$Window;IZ)Z

    move-result v1

    if-eqz v1, :cond_0

    if-eqz p3, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 1008
    :goto_0
    return v1
.end method

.method private isLastInWindow(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z
    .locals 4
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 996
    invoke-direct {p0, p2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 997
    return v1

    .line 999
    :cond_0
    iget-object v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, v0, v2}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v0

    iget v0, v0, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 1000
    .local v0, "windowIndex":I
    iget-object v2, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-virtual {p1, v2}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v2

    .line 1001
    .local v2, "periodIndex":I
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {p1, v0, v3}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v3

    iget v3, v3, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    if-ne v3, v2, :cond_1

    const/4 v1, 0x1

    :cond_1
    return v1
.end method

.method private static isSkippableAdPeriod(Landroidx/media3/common/Timeline$Period;)Z
    .locals 9
    .param p0, "period"    # Landroidx/media3/common/Timeline$Period;

    .line 479
    invoke-virtual {p0}, Landroidx/media3/common/Timeline$Period;->getAdGroupCount()I

    move-result v0

    .line 480
    .local v0, "adGroupCount":I
    const/4 v1, 0x0

    if-eqz v0, :cond_6

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 481
    invoke-virtual {p0, v1}, Landroidx/media3/common/Timeline$Period;->isLivePostrollPlaceholder(I)Z

    move-result v3

    if-nez v3, :cond_6

    .line 482
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/common/Timeline$Period;->getRemovedAdGroupCount()I

    move-result v3

    invoke-virtual {p0, v3}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 483
    const-wide/16 v3, 0x0

    invoke-virtual {p0, v3, v4}, Landroidx/media3/common/Timeline$Period;->getAdGroupIndexForPositionUs(J)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    goto :goto_2

    .line 486
    :cond_1
    iget-wide v5, p0, Landroidx/media3/common/Timeline$Period;->durationUs:J

    cmp-long v3, v5, v3

    if-nez v3, :cond_2

    .line 487
    return v2

    .line 489
    :cond_2
    const-wide/16 v3, 0x0

    .line 490
    .local v3, "contentResumeOffsetUs":J
    nop

    .line 491
    add-int/lit8 v5, v0, -0x1

    invoke-virtual {p0, v5}, Landroidx/media3/common/Timeline$Period;->isLivePostrollPlaceholder(I)Z

    move-result v5

    if-eqz v5, :cond_3

    const/4 v5, 0x2

    goto :goto_0

    :cond_3
    move v5, v2

    :goto_0
    sub-int v5, v0, v5

    .line 492
    .local v5, "lastIndexInclusive":I
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_1
    if-gt v6, v5, :cond_4

    .line 493
    invoke-virtual {p0, v6}, Landroidx/media3/common/Timeline$Period;->getContentResumeOffsetUs(I)J

    move-result-wide v7

    add-long/2addr v3, v7

    .line 492
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 495
    .end local v6    # "i":I
    :cond_4
    iget-wide v6, p0, Landroidx/media3/common/Timeline$Period;->durationUs:J

    cmp-long v6, v6, v3

    if-gtz v6, :cond_5

    move v1, v2

    :cond_5
    return v1

    .line 484
    .end local v3    # "contentResumeOffsetUs":J
    .end local v5    # "lastIndexInclusive":I
    :cond_6
    :goto_2
    return v1
.end method

.method private notifyQueueUpdate()V
    .locals 5

    .line 536
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->builder()Lcom/google/common/collect/ImmutableList$Builder;

    move-result-object v0

    .line 537
    .local v0, "builder":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;>;"
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 538
    .local v1, "period":Landroidx/media3/exoplayer/MediaPeriodHolder;
    :goto_0
    if-eqz v1, :cond_0

    .line 539
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    invoke-virtual {v0, v2}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 540
    invoke-virtual {v1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v1

    goto :goto_0

    .line 542
    :cond_0
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-nez v2, :cond_1

    const/4 v2, 0x0

    goto :goto_1

    :cond_1
    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 543
    .local v2, "readingPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    :goto_1
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->analyticsCollectorHandler:Landroidx/media3/common/util/HandlerWrapper;

    new-instance v4, Landroidx/media3/exoplayer/MediaPeriodQueue$$ExternalSyntheticLambda0;

    invoke-direct {v4, p0, v0, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/MediaPeriodQueue;Lcom/google/common/collect/ImmutableList$Builder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V

    invoke-interface {v3, v4}, Landroidx/media3/common/util/HandlerWrapper;->post(Ljava/lang/Runnable;)Z

    .line 545
    return-void
.end method

.method private static resolveMediaPeriodIdForAds(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJLandroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 17
    .param p0, "timeline"    # Landroidx/media3/common/Timeline;
    .param p1, "periodUid"    # Ljava/lang/Object;
    .param p2, "positionUs"    # J
    .param p4, "windowSequenceNumber"    # J
    .param p6, "window"    # Landroidx/media3/common/Timeline$Window;
    .param p7, "period"    # Landroidx/media3/common/Timeline$Period;

    .line 458
    move-object/from16 v0, p0

    move-wide/from16 v1, p2

    move-object/from16 v3, p6

    move-object/from16 v4, p7

    move-object/from16 v5, p1

    invoke-virtual {v0, v5, v4}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 459
    iget v6, v4, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    invoke-virtual {v0, v6, v3}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    .line 461
    invoke-virtual/range {p0 .. p1}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v6

    .line 462
    .end local p1    # "periodUid":Ljava/lang/Object;
    .local v5, "periodUid":Ljava/lang/Object;
    .local v6, "periodIndex":I
    :goto_0
    invoke-static/range {p7 .. p7}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isSkippableAdPeriod(Landroidx/media3/common/Timeline$Period;)Z

    move-result v7

    if-eqz v7, :cond_0

    iget v7, v3, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    if-gt v6, v7, :cond_0

    .line 464
    const/4 v7, 0x1

    invoke-virtual {v0, v6, v4, v7}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 465
    iget-object v7, v4, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 463
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 467
    .end local v6    # "periodIndex":I
    :cond_0
    invoke-virtual {v0, v5, v4}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 468
    invoke-virtual {v4, v1, v2}, Landroidx/media3/common/Timeline$Period;->getAdGroupIndexForPositionUs(J)I

    move-result v6

    .line 469
    .local v6, "adGroupIndex":I
    const/4 v7, -0x1

    if-ne v6, v7, :cond_1

    .line 470
    invoke-virtual {v4, v1, v2}, Landroidx/media3/common/Timeline$Period;->getAdGroupIndexAfterPositionUs(J)I

    move-result v7

    .line 471
    .local v7, "nextAdGroupIndex":I
    new-instance v8, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-wide/from16 v13, p4

    invoke-direct {v8, v5, v13, v14, v7}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;-><init>(Ljava/lang/Object;JI)V

    return-object v8

    .line 473
    .end local v7    # "nextAdGroupIndex":I
    :cond_1
    move-wide/from16 v13, p4

    invoke-virtual {v4, v6}, Landroidx/media3/common/Timeline$Period;->getFirstAdIndexToPlay(I)I

    move-result v15

    .line 474
    .local v15, "adIndexInAdGroup":I
    new-instance v16, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-object/from16 v7, v16

    move-object v8, v5

    move v9, v6

    move v10, v15

    move-wide/from16 v11, p4

    invoke-direct/range {v7 .. v12}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;-><init>(Ljava/lang/Object;IIJ)V

    return-object v16
.end method

.method private resolvePeriodIndexToWindowSequenceNumber(Landroidx/media3/common/Timeline;Ljava/lang/Object;)J
    .locals 7
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;

    .line 557
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, p2, v0}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v0

    iget v0, v0, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 558
    .local v0, "windowIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodUid:Ljava/lang/Object;

    const/4 v2, -0x1

    if-eqz v1, :cond_0

    .line 559
    invoke-virtual {p1, v1}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v1

    .line 560
    .local v1, "oldFrontPeriodIndex":I
    if-eq v1, v2, :cond_0

    .line 561
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, v1, v3}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v3

    iget v3, v3, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 562
    .local v3, "oldFrontWindowIndex":I
    if-ne v3, v0, :cond_0

    .line 564
    iget-wide v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodWindowSequenceNumber:J

    return-wide v4

    .line 568
    .end local v1    # "oldFrontPeriodIndex":I
    .end local v3    # "oldFrontWindowIndex":I
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 569
    .local v1, "mediaPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    :goto_0
    if-eqz v1, :cond_2

    .line 570
    iget-object v3, v1, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    invoke-virtual {v3, p2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 572
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v2, v2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    return-wide v2

    .line 574
    :cond_1
    invoke-virtual {v1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v1

    goto :goto_0

    .line 576
    :cond_2
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 577
    :goto_1
    if-eqz v1, :cond_4

    .line 578
    iget-object v3, v1, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    invoke-virtual {p1, v3}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v3

    .line 579
    .local v3, "indexOfHolderInTimeline":I
    if-eq v3, v2, :cond_3

    .line 580
    iget-object v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {p1, v3, v4}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v4

    iget v4, v4, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 581
    .local v4, "holderWindowIndex":I
    if-ne v4, v0, :cond_3

    .line 583
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v5, v2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    return-wide v5

    .line 586
    .end local v4    # "holderWindowIndex":I
    :cond_3
    invoke-virtual {v1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v1

    .line 587
    .end local v3    # "indexOfHolderInTimeline":I
    goto :goto_1

    .line 589
    :cond_4
    iget-wide v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->nextWindowSequenceNumber:J

    const-wide/16 v4, 0x1

    add-long/2addr v4, v2

    iput-wide v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->nextWindowSequenceNumber:J

    .line 590
    .local v2, "windowSequenceNumber":J
    iget-object v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-nez v4, :cond_5

    .line 592
    iput-object p2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodUid:Ljava/lang/Object;

    .line 593
    iput-wide v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodWindowSequenceNumber:J

    .line 595
    :cond_5
    return-wide v2
.end method

.method private updateForPlaybackModeChange(Landroidx/media3/common/Timeline;)Z
    .locals 8
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;

    .line 621
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 622
    .local v0, "lastValidPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    if-nez v0, :cond_0

    .line 623
    const/4 v1, 0x1

    return v1

    .line 625
    :cond_0
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    invoke-virtual {p1, v1}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v1

    move v7, v1

    .line 627
    .local v7, "currentPeriodIndex":I
    :goto_0
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-object v4, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget v5, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->repeatMode:I

    iget-boolean v6, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->shuffleModeEnabled:Z

    .line 628
    move-object v1, p1

    move v2, v7

    invoke-virtual/range {v1 .. v6}, Landroidx/media3/common/Timeline;->getNextPeriodIndex(ILandroidx/media3/common/Timeline$Period;Landroidx/media3/common/Timeline$Window;IZ)I

    move-result v1

    .line 630
    .local v1, "nextPeriodIndex":I
    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v2

    if-eqz v2, :cond_1

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-boolean v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->isLastInTimelinePeriod:Z

    if-nez v2, :cond_1

    .line 632
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v0

    goto :goto_1

    .line 635
    :cond_1
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v2

    .line 636
    .local v2, "nextMediaPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    const/4 v3, -0x1

    if-eq v1, v3, :cond_4

    if-nez v2, :cond_2

    .line 637
    goto :goto_2

    .line 639
    :cond_2
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    invoke-virtual {p1, v3}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v3

    .line 640
    .local v3, "nextPeriodHolderPeriodIndex":I
    if-eq v3, v1, :cond_3

    .line 641
    goto :goto_2

    .line 643
    :cond_3
    move-object v0, v2

    .line 644
    move v7, v1

    .line 645
    .end local v1    # "nextPeriodIndex":I
    .end local v2    # "nextMediaPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    .end local v3    # "nextPeriodHolderPeriodIndex":I
    goto :goto_0

    .line 648
    :cond_4
    :goto_2
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->removeAfter(Landroidx/media3/exoplayer/MediaPeriodHolder;)Z

    move-result v1

    .line 651
    .local v1, "readingPeriodRemoved":Z
    iget-object v2, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    invoke-virtual {p0, p1, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getUpdatedMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 654
    xor-int/lit8 v2, v1, 0x1

    return v2
.end method


# virtual methods
.method public advancePlayingPeriod()Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 3

    .line 241
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 242
    return-object v1

    .line 244
    :cond_0
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-ne v0, v2, :cond_1

    .line 245
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 247
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->release()V

    .line 248
    iget v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    .line 249
    if-nez v0, :cond_2

    .line 250
    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 251
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodUid:Ljava/lang/Object;

    .line 252
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v0, v0, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iput-wide v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodWindowSequenceNumber:J

    .line 254
    :cond_2
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 255
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->notifyQueueUpdate()V

    .line 256
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    return-object v0
.end method

.method public advanceReadingPeriod()Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 1

    .line 228
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 229
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->notifyQueueUpdate()V

    .line 230
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaPeriodHolder;

    return-object v0
.end method

.method public clear()V
    .locals 3

    .line 290
    iget v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    if-nez v0, :cond_0

    .line 291
    return-void

    .line 293
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 294
    .local v0, "front":Landroidx/media3/exoplayer/MediaPeriodHolder;
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->uid:Ljava/lang/Object;

    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodUid:Ljava/lang/Object;

    .line 295
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-object v1, v1, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v1, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iput-wide v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodWindowSequenceNumber:J

    .line 296
    :goto_0
    if-eqz v0, :cond_1

    .line 297
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->release()V

    .line 298
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v0

    goto :goto_0

    .line 300
    :cond_1
    const/4 v1, 0x0

    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 301
    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 302
    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 303
    const/4 v1, 0x0

    iput v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    .line 304
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->notifyQueueUpdate()V

    .line 305
    return-void
.end method

.method public enqueueNextMediaPeriodHolder(Landroidx/media3/exoplayer/MediaPeriodInfo;)Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 4
    .param p1, "info"    # Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 180
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-nez v0, :cond_0

    .line 181
    const-wide v0, 0xe8d4a51000L

    goto :goto_0

    .line 182
    :cond_0
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getRendererOffset()J

    move-result-wide v0

    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    iget-object v2, v2, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-wide v2, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    add-long/2addr v0, v2

    iget-wide v2, p1, Landroidx/media3/exoplayer/MediaPeriodInfo;->startPositionUs:J

    sub-long/2addr v0, v2

    :goto_0
    nop

    .line 183
    .local v0, "rendererPositionOffsetUs":J
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->mediaPeriodHolderFactory:Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;

    .line 184
    invoke-interface {v2, p1, v0, v1}, Landroidx/media3/exoplayer/MediaPeriodHolder$Factory;->create(Landroidx/media3/exoplayer/MediaPeriodInfo;J)Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v2

    .line 185
    .local v2, "newPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-eqz v3, :cond_1

    .line 186
    invoke-virtual {v3, v2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->setNext(Landroidx/media3/exoplayer/MediaPeriodHolder;)V

    goto :goto_1

    .line 188
    :cond_1
    iput-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 189
    iput-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 191
    :goto_1
    const/4 v3, 0x0

    iput-object v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->oldFrontPeriodUid:Ljava/lang/Object;

    .line 192
    iput-object v2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 193
    iget v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    .line 194
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->notifyQueueUpdate()V

    .line 195
    return-object v2
.end method

.method public getLoadingPeriod()Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 1

    .line 204
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    return-object v0
.end method

.method public getNextMediaPeriodInfo(JLandroidx/media3/exoplayer/PlaybackInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 2
    .param p1, "rendererPositionUs"    # J
    .param p3, "playbackInfo"    # Landroidx/media3/exoplayer/PlaybackInfo;

    .line 167
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-nez v0, :cond_0

    .line 168
    invoke-direct {p0, p3}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFirstMediaPeriodInfo(Landroidx/media3/exoplayer/PlaybackInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    goto :goto_0

    .line 169
    :cond_0
    iget-object v0, p3, Landroidx/media3/exoplayer/PlaybackInfo;->timeline:Landroidx/media3/common/Timeline;

    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-direct {p0, v0, v1, p1, p2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFollowingMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v0

    .line 167
    :goto_0
    return-object v0
.end method

.method public getPlayingPeriod()Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 1

    .line 213
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    return-object v0
.end method

.method public getReadingPeriod()Landroidx/media3/exoplayer/MediaPeriodHolder;
    .locals 1

    .line 219
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    return-object v0
.end method

.method public getUpdatedMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;
    .locals 24
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "info"    # Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 389
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    iget-object v15, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 390
    .local v15, "id":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    invoke-direct {v0, v15}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v14

    .line 391
    .local v14, "isLastInPeriod":Z
    invoke-direct {v0, v1, v15}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInWindow(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v17

    .line 392
    .local v17, "isLastInWindow":Z
    invoke-direct {v0, v1, v15, v14}, Landroidx/media3/exoplayer/MediaPeriodQueue;->isLastInTimeline(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Z)Z

    move-result v18

    .line 393
    .local v18, "isLastInTimeline":Z
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v3, v3, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v4, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v1, v3, v4}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 395
    invoke-virtual {v15}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v3

    const/4 v4, -0x1

    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    if-nez v3, :cond_1

    iget v3, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    if-ne v3, v4, :cond_0

    goto :goto_0

    .line 397
    :cond_0
    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v7, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    invoke-virtual {v3, v7}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v7

    goto :goto_1

    .line 396
    :cond_1
    :goto_0
    move-wide v7, v5

    .line 397
    :goto_1
    move-wide/from16 v19, v7

    .line 399
    .local v19, "endPositionUs":J
    invoke-virtual {v15}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 400
    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v5, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    iget v6, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    invoke-virtual {v3, v5, v6}, Landroidx/media3/common/Timeline$Period;->getAdDurationUs(II)J

    move-result-wide v5

    move-wide v11, v5

    goto :goto_3

    .line 401
    :cond_2
    cmp-long v3, v19, v5

    if-eqz v3, :cond_4

    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v3, v19, v5

    if-nez v3, :cond_3

    goto :goto_2

    .line 403
    :cond_3
    move-wide/from16 v11, v19

    goto :goto_3

    .line 402
    :cond_4
    :goto_2
    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v3}, Landroidx/media3/common/Timeline$Period;->getDurationUs()J

    move-result-wide v5

    move-wide v11, v5

    .line 403
    :goto_3
    nop

    .line 405
    .local v11, "durationUs":J
    invoke-virtual {v15}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 406
    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v4, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    invoke-virtual {v3, v4}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v3

    move v13, v3

    goto :goto_5

    .line 407
    :cond_5
    iget v3, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    if-eq v3, v4, :cond_6

    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v4, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    .line 408
    invoke-virtual {v3, v4}, Landroidx/media3/common/Timeline$Period;->isServerSideInsertedAdGroup(I)Z

    move-result v3

    if-eqz v3, :cond_6

    const/4 v3, 0x1

    goto :goto_4

    :cond_6
    const/4 v3, 0x0

    :goto_4
    move v13, v3

    :goto_5
    nop

    .line 409
    .local v13, "isFollowedByTransitionToSameStream":Z
    new-instance v21, Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-wide v5, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->startPositionUs:J

    iget-wide v7, v2, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    move-object/from16 v3, v21

    move-object v4, v15

    move-wide/from16 v9, v19

    move/from16 v22, v14

    .end local v14    # "isLastInPeriod":Z
    .local v22, "isLastInPeriod":Z
    move-object/from16 v23, v15

    .end local v15    # "id":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .local v23, "id":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    move/from16 v15, v17

    move/from16 v16, v18

    invoke-direct/range {v3 .. v16}, Landroidx/media3/exoplayer/MediaPeriodInfo;-><init>(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJJJZZZZ)V

    return-object v21
.end method

.method public isLoading(Landroidx/media3/exoplayer/source/MediaPeriod;)Z
    .locals 1
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 133
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method synthetic lambda$notifyQueueUpdate$0$androidx-media3-exoplayer-MediaPeriodQueue(Lcom/google/common/collect/ImmutableList$Builder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V
    .locals 2
    .param p1, "builder"    # Lcom/google/common/collect/ImmutableList$Builder;
    .param p2, "readingPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 544
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->analyticsCollector:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

    invoke-virtual {p1}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Landroidx/media3/exoplayer/analytics/AnalyticsCollector;->updateMediaPeriodQueueInfo(Ljava/util/List;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V

    return-void
.end method

.method public reevaluateBuffer(J)V
    .locals 1
    .param p1, "rendererPositionUs"    # J

    .line 142
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-eqz v0, :cond_0

    .line 143
    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->reevaluateBuffer(J)V

    .line 145
    :cond_0
    return-void
.end method

.method public removeAfter(Landroidx/media3/exoplayer/MediaPeriodHolder;)Z
    .locals 3
    .param p1, "mediaPeriodHolder"    # Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 268
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 269
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    const/4 v0, 0x0

    return v0

    .line 272
    :cond_0
    const/4 v0, 0x0

    .line 273
    .local v0, "removedReading":Z
    iput-object p1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 274
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 275
    invoke-virtual {p1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object p1, v1

    check-cast p1, Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 276
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-ne p1, v1, :cond_1

    .line 277
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    iput-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 278
    const/4 v0, 0x1

    .line 280
    :cond_1
    invoke-virtual {p1}, Landroidx/media3/exoplayer/MediaPeriodHolder;->release()V

    .line 281
    iget v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    goto :goto_0

    .line 283
    :cond_2
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaPeriodHolder;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/MediaPeriodHolder;->setNext(Landroidx/media3/exoplayer/MediaPeriodHolder;)V

    .line 284
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaPeriodQueue;->notifyQueueUpdate()V

    .line 285
    return v0
.end method

.method public resolveMediaPeriodIdForAds(Landroidx/media3/common/Timeline;Ljava/lang/Object;J)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 10
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;
    .param p3, "positionUs"    # J

    .line 433
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->resolvePeriodIndexToWindowSequenceNumber(Landroidx/media3/common/Timeline;Ljava/lang/Object;)J

    move-result-wide v8

    .line 434
    .local v8, "windowSequenceNumber":J
    iget-object v6, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget-object v7, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move-object v0, p1

    move-object v1, p2

    move-wide v2, p3

    move-wide v4, v8

    invoke-static/range {v0 .. v7}, Landroidx/media3/exoplayer/MediaPeriodQueue;->resolveMediaPeriodIdForAds(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJLandroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v0

    return-object v0
.end method

.method public resolveMediaPeriodIdForAdsAfterPeriodPositionChange(Landroidx/media3/common/Timeline;Ljava/lang/Object;J)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 15
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "periodUid"    # Ljava/lang/Object;
    .param p3, "positionUs"    # J

    .line 510
    move-object v0, p0

    move-object/from16 v9, p1

    invoke-direct/range {p0 .. p2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->resolvePeriodIndexToWindowSequenceNumber(Landroidx/media3/common/Timeline;Ljava/lang/Object;)J

    move-result-wide v10

    .line 512
    .local v10, "windowSequenceNumber":J
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move-object/from16 v12, p2

    invoke-virtual {v9, v12, v1}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 513
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget v1, v1, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    invoke-virtual {v9, v1, v2}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    .line 514
    move-object/from16 v1, p2

    .line 515
    .local v1, "periodUidToPlay":Ljava/lang/Object;
    const/4 v2, 0x0

    .line 516
    .local v2, "seenAdPeriod":Z
    invoke-virtual/range {p1 .. p2}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v3

    .local v3, "i":I
    :goto_0
    iget-object v4, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget v4, v4, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    if-lt v3, v4, :cond_4

    .line 517
    iget-object v4, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    const/4 v5, 0x1

    invoke-virtual {v9, v3, v4, v5}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 518
    iget-object v4, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v4}, Landroidx/media3/common/Timeline$Period;->getAdGroupCount()I

    move-result v4

    if-lez v4, :cond_0

    goto :goto_1

    :cond_0
    const/4 v5, 0x0

    :goto_1
    move v4, v5

    .line 519
    .local v4, "isAdPeriod":Z
    or-int/2addr v2, v4

    .line 520
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v6, v5, Landroidx/media3/common/Timeline$Period;->durationUs:J

    invoke-virtual {v5, v6, v7}, Landroidx/media3/common/Timeline$Period;->getAdGroupIndexForPositionUs(J)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    .line 522
    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-object v5, v5, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 524
    :cond_1
    if-eqz v2, :cond_3

    if-eqz v4, :cond_2

    iget-object v5, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v5, v5, Landroidx/media3/common/Timeline$Period;->durationUs:J

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-eqz v5, :cond_3

    .line 526
    nop

    .line 529
    .end local v3    # "i":I
    .end local v4    # "isAdPeriod":Z
    :cond_2
    move-object v13, v1

    move v14, v2

    goto :goto_2

    .line 516
    .restart local v3    # "i":I
    :cond_3
    add-int/lit8 v3, v3, -0x1

    goto :goto_0

    :cond_4
    move-object v13, v1

    move v14, v2

    .line 529
    .end local v1    # "periodUidToPlay":Ljava/lang/Object;
    .end local v2    # "seenAdPeriod":Z
    .end local v3    # "i":I
    .local v13, "periodUidToPlay":Ljava/lang/Object;
    .local v14, "seenAdPeriod":Z
    :goto_2
    iget-object v7, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->window:Landroidx/media3/common/Timeline$Window;

    iget-object v8, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->period:Landroidx/media3/common/Timeline$Period;

    move-object/from16 v1, p1

    move-object v2, v13

    move-wide/from16 v3, p3

    move-wide v5, v10

    invoke-static/range {v1 .. v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->resolveMediaPeriodIdForAds(Landroidx/media3/common/Timeline;Ljava/lang/Object;JJLandroidx/media3/common/Timeline$Window;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v1

    return-object v1
.end method

.method public shouldLoadNextMediaPeriod()Z
    .locals 4

    .line 149
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    if-eqz v0, :cond_1

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-boolean v0, v0, Landroidx/media3/exoplayer/MediaPeriodInfo;->isFinal:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 151
    invoke-virtual {v0}, Landroidx/media3/exoplayer/MediaPeriodHolder;->isFullyBuffered()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->loading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-wide v0, v0, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->length:I

    const/16 v1, 0x64

    if-ge v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 149
    :goto_1
    return v0
.end method

.method public updateQueuedPeriods(Landroidx/media3/common/Timeline;JJ)Z
    .locals 15
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "rendererPositionUs"    # J
    .param p4, "maxRendererReadPositionUs"    # J

    .line 325
    move-object v0, p0

    move-object/from16 v1, p1

    const/4 v2, 0x0

    .line 326
    .local v2, "previousPeriodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    iget-object v3, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->playing:Landroidx/media3/exoplayer/MediaPeriodHolder;

    .line 327
    .local v3, "periodHolder":Landroidx/media3/exoplayer/MediaPeriodHolder;
    :goto_0
    const/4 v4, 0x1

    if-eqz v3, :cond_8

    .line 328
    iget-object v5, v3, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 332
    .local v5, "oldPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    if-nez v2, :cond_0

    .line 336
    invoke-virtual {p0, v1, v5}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getUpdatedMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodInfo;)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v6

    move-object v8, v6

    move-wide/from16 v6, p2

    .local v6, "newPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    goto :goto_1

    .line 338
    .end local v6    # "newPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    :cond_0
    nop

    .line 339
    move-wide/from16 v6, p2

    invoke-direct {p0, v1, v2, v6, v7}, Landroidx/media3/exoplayer/MediaPeriodQueue;->getFollowingMediaPeriodInfo(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/MediaPeriodHolder;J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v8

    .line 340
    .local v8, "newPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    if-nez v8, :cond_1

    .line 342
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->removeAfter(Landroidx/media3/exoplayer/MediaPeriodHolder;)Z

    move-result v9

    xor-int/2addr v4, v9

    return v4

    .line 344
    :cond_1
    invoke-direct {p0, v5, v8}, Landroidx/media3/exoplayer/MediaPeriodQueue;->canKeepMediaPeriodHolder(Landroidx/media3/exoplayer/MediaPeriodInfo;Landroidx/media3/exoplayer/MediaPeriodInfo;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 346
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/MediaPeriodQueue;->removeAfter(Landroidx/media3/exoplayer/MediaPeriodHolder;)Z

    move-result v9

    xor-int/2addr v4, v9

    return v4

    .line 352
    :cond_2
    :goto_1
    iget-wide v9, v5, Landroidx/media3/exoplayer/MediaPeriodInfo;->requestedContentPositionUs:J

    .line 353
    invoke-virtual {v8, v9, v10}, Landroidx/media3/exoplayer/MediaPeriodInfo;->copyWithRequestedContentPositionUs(J)Landroidx/media3/exoplayer/MediaPeriodInfo;

    move-result-object v9

    iput-object v9, v3, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    .line 356
    iget-wide v9, v5, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    iget-wide v11, v8, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    invoke-direct {p0, v9, v10, v11, v12}, Landroidx/media3/exoplayer/MediaPeriodQueue;->areDurationsCompatible(JJ)Z

    move-result v9

    if-nez v9, :cond_7

    .line 359
    invoke-virtual {v3}, Landroidx/media3/exoplayer/MediaPeriodHolder;->updateClipping()V

    .line 361
    iget-wide v9, v8, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v9, v9, v11

    if-nez v9, :cond_3

    .line 362
    const-wide v9, 0x7fffffffffffffffL

    goto :goto_2

    .line 363
    :cond_3
    iget-wide v9, v8, Landroidx/media3/exoplayer/MediaPeriodInfo;->durationUs:J

    invoke-virtual {v3, v9, v10}, Landroidx/media3/exoplayer/MediaPeriodHolder;->toRendererTime(J)J

    move-result-wide v9

    :goto_2
    nop

    .line 364
    .local v9, "newDurationInRendererTime":J
    iget-object v11, v0, Landroidx/media3/exoplayer/MediaPeriodQueue;->reading:Landroidx/media3/exoplayer/MediaPeriodHolder;

    const/4 v12, 0x0

    if-ne v3, v11, :cond_5

    iget-object v11, v3, Landroidx/media3/exoplayer/MediaPeriodHolder;->info:Landroidx/media3/exoplayer/MediaPeriodInfo;

    iget-boolean v11, v11, Landroidx/media3/exoplayer/MediaPeriodInfo;->isFollowedByTransitionToSameStream:Z

    if-nez v11, :cond_5

    const-wide/high16 v13, -0x8000000000000000L

    cmp-long v11, p4, v13

    if-eqz v11, :cond_4

    cmp-long v11, p4, v9

    if-ltz v11, :cond_5

    :cond_4
    move v11, v4

    goto :goto_3

    :cond_5
    move v11, v12

    .line 369
    .local v11, "isReadingAndReadBeyondNewDuration":Z
    :goto_3
    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/MediaPeriodQueue;->removeAfter(Landroidx/media3/exoplayer/MediaPeriodHolder;)Z

    move-result v13

    .line 370
    .local v13, "readingPeriodRemoved":Z
    if-nez v13, :cond_6

    if-nez v11, :cond_6

    goto :goto_4

    :cond_6
    move v4, v12

    :goto_4
    return v4

    .line 373
    .end local v9    # "newDurationInRendererTime":J
    .end local v11    # "isReadingAndReadBeyondNewDuration":Z
    .end local v13    # "readingPeriodRemoved":Z
    :cond_7
    move-object v2, v3

    .line 374
    invoke-virtual {v3}, Landroidx/media3/exoplayer/MediaPeriodHolder;->getNext()Landroidx/media3/exoplayer/MediaPeriodHolder;

    move-result-object v3

    .line 375
    .end local v5    # "oldPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    .end local v8    # "newPeriodInfo":Landroidx/media3/exoplayer/MediaPeriodInfo;
    goto :goto_0

    .line 376
    :cond_8
    move-wide/from16 v6, p2

    return v4
.end method

.method public updateRepeatMode(Landroidx/media3/common/Timeline;I)Z
    .locals 1
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "repeatMode"    # I

    .line 114
    iput p2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->repeatMode:I

    .line 115
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/MediaPeriodQueue;->updateForPlaybackModeChange(Landroidx/media3/common/Timeline;)Z

    move-result v0

    return v0
.end method

.method public updateShuffleModeEnabled(Landroidx/media3/common/Timeline;Z)Z
    .locals 1
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "shuffleModeEnabled"    # Z

    .line 127
    iput-boolean p2, p0, Landroidx/media3/exoplayer/MediaPeriodQueue;->shuffleModeEnabled:Z

    .line 128
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/MediaPeriodQueue;->updateForPlaybackModeChange(Landroidx/media3/common/Timeline;)Z

    move-result v0

    return v0
.end method
