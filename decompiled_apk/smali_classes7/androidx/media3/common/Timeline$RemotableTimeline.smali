.class public final Landroidx/media3/common/Timeline$RemotableTimeline;
.super Landroidx/media3/common/Timeline;
.source "Timeline.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/Timeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "RemotableTimeline"
.end annotation


# instance fields
.field private final periods:Lcom/google/common/collect/ImmutableList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/common/Timeline$Period;",
            ">;"
        }
    .end annotation
.end field

.field private final shuffledWindowIndices:[I

.field private final windowIndicesInShuffled:[I

.field private final windows:Lcom/google/common/collect/ImmutableList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/common/Timeline$Window;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/google/common/collect/ImmutableList;Lcom/google/common/collect/ImmutableList;[I)V
    .locals 3
    .param p3, "shuffledWindowIndices"    # [I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/common/Timeline$Window;",
            ">;",
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/common/Timeline$Period;",
            ">;[I)V"
        }
    .end annotation

    .line 1547
    .local p1, "windows":Lcom/google/common/collect/ImmutableList;, "Lcom/google/common/collect/ImmutableList<Landroidx/media3/common/Timeline$Window;>;"
    .local p2, "periods":Lcom/google/common/collect/ImmutableList;, "Lcom/google/common/collect/ImmutableList<Landroidx/media3/common/Timeline$Period;>;"
    invoke-direct {p0}, Landroidx/media3/common/Timeline;-><init>()V

    .line 1548
    invoke-virtual {p1}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v0

    array-length v1, p3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 1549
    iput-object p1, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windows:Lcom/google/common/collect/ImmutableList;

    .line 1550
    iput-object p2, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->periods:Lcom/google/common/collect/ImmutableList;

    .line 1551
    iput-object p3, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->shuffledWindowIndices:[I

    .line 1552
    array-length v0, p3

    new-array v0, v0, [I

    iput-object v0, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windowIndicesInShuffled:[I

    .line 1553
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v1, p3

    if-ge v0, v1, :cond_1

    .line 1554
    iget-object v1, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windowIndicesInShuffled:[I

    aget v2, p3, v0

    aput v0, v1, v2

    .line 1553
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1556
    .end local v0    # "i":I
    :cond_1
    return-void
.end method


# virtual methods
.method public getFirstWindowIndex(Z)I
    .locals 2
    .param p1, "shuffleModeEnabled"    # Z

    .line 1629
    invoke-virtual {p0}, Landroidx/media3/common/Timeline$RemotableTimeline;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1630
    const/4 v0, -0x1

    return v0

    .line 1632
    :cond_0
    const/4 v0, 0x0

    if-eqz p1, :cond_1

    iget-object v1, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->shuffledWindowIndices:[I

    aget v0, v1, v0

    :cond_1
    return v0
.end method

.method public getIndexOfPeriod(Ljava/lang/Object;)I
    .locals 1
    .param p1, "uid"    # Ljava/lang/Object;

    .line 1656
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getLastWindowIndex(Z)I
    .locals 2
    .param p1, "shuffleModeEnabled"    # Z

    .line 1619
    invoke-virtual {p0}, Landroidx/media3/common/Timeline$RemotableTimeline;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1620
    const/4 v0, -0x1

    return v0

    .line 1622
    :cond_0
    if-eqz p1, :cond_1

    .line 1623
    iget-object v0, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->shuffledWindowIndices:[I

    invoke-virtual {p0}, Landroidx/media3/common/Timeline$RemotableTimeline;->getWindowCount()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    aget v0, v0, v1

    goto :goto_0

    .line 1624
    :cond_1
    invoke-virtual {p0}, Landroidx/media3/common/Timeline$RemotableTimeline;->getWindowCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .line 1622
    :goto_0
    return v0
.end method

.method public getNextWindowIndex(IIZ)I
    .locals 3
    .param p1, "windowIndex"    # I
    .param p2, "repeatMode"    # I
    .param p3, "shuffleModeEnabled"    # Z

    .line 1588
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 1589
    return p1

    .line 1591
    :cond_0
    invoke-virtual {p0, p3}, Landroidx/media3/common/Timeline$RemotableTimeline;->getLastWindowIndex(Z)I

    move-result v1

    if-ne p1, v1, :cond_2

    .line 1592
    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 1593
    invoke-virtual {p0, p3}, Landroidx/media3/common/Timeline$RemotableTimeline;->getFirstWindowIndex(Z)I

    move-result v0

    goto :goto_0

    .line 1594
    :cond_1
    const/4 v0, -0x1

    .line 1592
    :goto_0
    return v0

    .line 1596
    :cond_2
    if-eqz p3, :cond_3

    .line 1597
    iget-object v1, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->shuffledWindowIndices:[I

    iget-object v2, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windowIndicesInShuffled:[I

    aget v2, v2, p1

    add-int/2addr v2, v0

    aget v0, v1, v2

    goto :goto_1

    .line 1598
    :cond_3
    add-int/lit8 v0, p1, 0x1

    .line 1596
    :goto_1
    return v0
.end method

.method public getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;
    .locals 11
    .param p1, "periodIndex"    # I
    .param p2, "period"    # Landroidx/media3/common/Timeline$Period;
    .param p3, "setIds"    # Z

    .line 1642
    iget-object v0, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->periods:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v0, p1}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/Timeline$Period;

    .line 1643
    .local v0, "p":Landroidx/media3/common/Timeline$Period;
    iget-object v2, v0, Landroidx/media3/common/Timeline$Period;->id:Ljava/lang/Object;

    iget-object v3, v0, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    iget v4, v0, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    iget-wide v5, v0, Landroidx/media3/common/Timeline$Period;->durationUs:J

    iget-wide v7, v0, Landroidx/media3/common/Timeline$Period;->positionInWindowUs:J

    .line 1649
    invoke-static {v0}, Landroidx/media3/common/Timeline$Period;->access$000(Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/AdPlaybackState;

    move-result-object v9

    iget-boolean v10, v0, Landroidx/media3/common/Timeline$Period;->isPlaceholder:Z

    .line 1643
    move-object v1, p2

    invoke-virtual/range {v1 .. v10}, Landroidx/media3/common/Timeline$Period;->set(Ljava/lang/Object;Ljava/lang/Object;IJJLandroidx/media3/common/AdPlaybackState;Z)Landroidx/media3/common/Timeline$Period;

    .line 1651
    return-object p2
.end method

.method public getPeriodCount()I
    .locals 1

    .line 1637
    iget-object v0, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->periods:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v0

    return v0
.end method

.method public getPreviousWindowIndex(IIZ)I
    .locals 3
    .param p1, "windowIndex"    # I
    .param p2, "repeatMode"    # I
    .param p3, "shuffleModeEnabled"    # Z

    .line 1604
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 1605
    return p1

    .line 1607
    :cond_0
    invoke-virtual {p0, p3}, Landroidx/media3/common/Timeline$RemotableTimeline;->getFirstWindowIndex(Z)I

    move-result v1

    if-ne p1, v1, :cond_2

    .line 1608
    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 1609
    invoke-virtual {p0, p3}, Landroidx/media3/common/Timeline$RemotableTimeline;->getLastWindowIndex(Z)I

    move-result v0

    goto :goto_0

    .line 1610
    :cond_1
    const/4 v0, -0x1

    .line 1608
    :goto_0
    return v0

    .line 1612
    :cond_2
    if-eqz p3, :cond_3

    .line 1613
    iget-object v1, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->shuffledWindowIndices:[I

    iget-object v2, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windowIndicesInShuffled:[I

    aget v2, v2, p1

    sub-int/2addr v2, v0

    aget v0, v1, v2

    goto :goto_1

    .line 1614
    :cond_3
    add-int/lit8 v0, p1, -0x1

    .line 1612
    :goto_1
    return v0
.end method

.method public getUidOfPeriod(I)Ljava/lang/Object;
    .locals 1
    .param p1, "periodIndex"    # I

    .line 1661
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;
    .locals 25
    .param p1, "windowIndex"    # I
    .param p2, "window"    # Landroidx/media3/common/Timeline$Window;
    .param p3, "defaultPositionProjectionUs"    # J

    move-object/from16 v15, p2

    move-object/from16 v0, p2

    .line 1565
    move-object/from16 v13, p0

    iget-object v1, v13, Landroidx/media3/common/Timeline$RemotableTimeline;->windows:Lcom/google/common/collect/ImmutableList;

    move/from16 v14, p1

    invoke-virtual {v1, v14}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v1

    move-object v12, v1

    check-cast v12, Landroidx/media3/common/Timeline$Window;

    .line 1566
    .local v12, "w":Landroidx/media3/common/Timeline$Window;
    iget-object v1, v12, Landroidx/media3/common/Timeline$Window;->uid:Ljava/lang/Object;

    iget-object v2, v12, Landroidx/media3/common/Timeline$Window;->mediaItem:Landroidx/media3/common/MediaItem;

    iget-object v3, v12, Landroidx/media3/common/Timeline$Window;->manifest:Ljava/lang/Object;

    iget-wide v4, v12, Landroidx/media3/common/Timeline$Window;->presentationStartTimeMs:J

    iget-wide v6, v12, Landroidx/media3/common/Timeline$Window;->windowStartTimeMs:J

    iget-wide v8, v12, Landroidx/media3/common/Timeline$Window;->elapsedRealtimeEpochOffsetMs:J

    iget-boolean v10, v12, Landroidx/media3/common/Timeline$Window;->isSeekable:Z

    iget-boolean v11, v12, Landroidx/media3/common/Timeline$Window;->isDynamic:Z

    iget-object v13, v12, Landroidx/media3/common/Timeline$Window;->liveConfiguration:Landroidx/media3/common/MediaItem$LiveConfiguration;

    move-object/from16 v21, v0

    move-object v0, v12

    .end local v12    # "w":Landroidx/media3/common/Timeline$Window;
    .local v0, "w":Landroidx/media3/common/Timeline$Window;
    move-object v12, v13

    iget-wide v13, v0, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    move-object/from16 v22, v1

    move-object/from16 v23, v2

    iget-wide v1, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    move-wide v15, v1

    iget v1, v0, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    move/from16 v17, v1

    iget v1, v0, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    move/from16 v18, v1

    iget-wide v1, v0, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    move-wide/from16 v19, v1

    move-object/from16 v24, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    .end local v0    # "w":Landroidx/media3/common/Timeline$Window;
    .local v24, "w":Landroidx/media3/common/Timeline$Window;
    invoke-virtual/range {v0 .. v20}, Landroidx/media3/common/Timeline$Window;->set(Ljava/lang/Object;Landroidx/media3/common/MediaItem;Ljava/lang/Object;JJJZZLandroidx/media3/common/MediaItem$LiveConfiguration;JJIIJ)Landroidx/media3/common/Timeline$Window;

    .line 1581
    move-object/from16 v0, v24

    .end local v24    # "w":Landroidx/media3/common/Timeline$Window;
    .restart local v0    # "w":Landroidx/media3/common/Timeline$Window;
    iget-boolean v1, v0, Landroidx/media3/common/Timeline$Window;->isPlaceholder:Z

    move-object/from16 v2, p2

    iput-boolean v1, v2, Landroidx/media3/common/Timeline$Window;->isPlaceholder:Z

    .line 1582
    return-object v2
.end method

.method public getWindowCount()I
    .locals 1

    .line 1560
    iget-object v0, p0, Landroidx/media3/common/Timeline$RemotableTimeline;->windows:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableList;->size()I

    move-result v0

    return v0
.end method
