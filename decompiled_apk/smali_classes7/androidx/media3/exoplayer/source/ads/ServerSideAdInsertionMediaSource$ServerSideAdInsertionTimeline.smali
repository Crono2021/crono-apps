.class final Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;
.super Landroidx/media3/exoplayer/source/ForwardingTimeline;
.source "ServerSideAdInsertionMediaSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ServerSideAdInsertionTimeline"
.end annotation


# instance fields
.field private final adPlaybackStates:Lcom/google/common/collect/ImmutableMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableMap<",
            "Ljava/lang/Object;",
            "Landroidx/media3/common/AdPlaybackState;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroidx/media3/common/Timeline;Lcom/google/common/collect/ImmutableMap;)V
    .locals 4
    .param p1, "contentTimeline"    # Landroidx/media3/common/Timeline;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/Timeline;",
            "Lcom/google/common/collect/ImmutableMap<",
            "Ljava/lang/Object;",
            "Landroidx/media3/common/AdPlaybackState;",
            ">;)V"
        }
    .end annotation

    .line 1019
    .local p2, "adPlaybackStates":Lcom/google/common/collect/ImmutableMap;, "Lcom/google/common/collect/ImmutableMap<Ljava/lang/Object;Landroidx/media3/common/AdPlaybackState;>;"
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/ForwardingTimeline;-><init>(Landroidx/media3/common/Timeline;)V

    .line 1020
    invoke-virtual {p1}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1021
    new-instance v0, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v0}, Landroidx/media3/common/Timeline$Period;-><init>()V

    .line 1022
    .local v0, "period":Landroidx/media3/common/Timeline$Period;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p1}, Landroidx/media3/common/Timeline;->getPeriodCount()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 1023
    invoke-virtual {p1, v2, v0, v1}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 1024
    iget-object v3, v0, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p2, v3}, Lcom/google/common/collect/ImmutableMap;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1022
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 1026
    .end local v2    # "i":I
    :cond_1
    iput-object p2, p0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->adPlaybackStates:Lcom/google/common/collect/ImmutableMap;

    .line 1027
    return-void
.end method


# virtual methods
.method public getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;
    .locals 20
    .param p1, "periodIndex"    # I
    .param p2, "period"    # Landroidx/media3/common/Timeline$Period;
    .param p3, "setIds"    # Z

    .line 1068
    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object/from16 v12, p2

    const/4 v2, 0x1

    invoke-super {v0, v1, v12, v2}, Landroidx/media3/exoplayer/source/ForwardingTimeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 1069
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->adPlaybackStates:Lcom/google/common/collect/ImmutableMap;

    iget-object v4, v12, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/AdPlaybackState;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v13, v3

    check-cast v13, Landroidx/media3/common/AdPlaybackState;

    .line 1070
    .local v13, "adPlaybackState":Landroidx/media3/common/AdPlaybackState;
    iget-wide v3, v12, Landroidx/media3/common/Timeline$Period;->durationUs:J

    .line 1071
    .local v3, "durationUs":J
    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v3, v5

    const/4 v6, -0x1

    if-nez v5, :cond_0

    .line 1072
    iget-wide v3, v13, Landroidx/media3/common/AdPlaybackState;->contentDurationUs:J

    move-wide v14, v3

    goto :goto_0

    .line 1074
    :cond_0
    nop

    .line 1075
    invoke-static {v3, v4, v6, v13}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v3

    move-wide v14, v3

    .line 1078
    .end local v3    # "durationUs":J
    .local v14, "durationUs":J
    :goto_0
    const-wide/16 v3, 0x0

    .line 1079
    .local v3, "positionInWindowUs":J
    new-instance v5, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v5}, Landroidx/media3/common/Timeline$Period;-><init>()V

    move-object v11, v5

    .line 1080
    .local v11, "innerPeriod":Landroidx/media3/common/Timeline$Period;
    const/4 v5, 0x0

    move-wide/from16 v16, v3

    .end local v3    # "positionInWindowUs":J
    .local v5, "i":I
    .local v16, "positionInWindowUs":J
    :goto_1
    add-int/lit8 v3, v1, 0x1

    if-ge v5, v3, :cond_3

    .line 1081
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->timeline:Landroidx/media3/common/Timeline;

    invoke-virtual {v3, v5, v11, v2}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 1082
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->adPlaybackStates:Lcom/google/common/collect/ImmutableMap;

    iget-object v4, v11, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/AdPlaybackState;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/AdPlaybackState;

    .line 1083
    .local v3, "innerAdPlaybackState":Landroidx/media3/common/AdPlaybackState;
    if-nez v5, :cond_1

    .line 1084
    nop

    .line 1086
    invoke-virtual {v11}, Landroidx/media3/common/Timeline$Period;->getPositionInWindowUs()J

    move-result-wide v7

    neg-long v7, v7

    .line 1085
    invoke-static {v7, v8, v6, v3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v7

    neg-long v7, v7

    move-wide/from16 v16, v7

    .line 1090
    :cond_1
    if-eq v5, v1, :cond_2

    .line 1091
    iget-wide v7, v11, Landroidx/media3/common/Timeline$Period;->durationUs:J

    .line 1092
    invoke-static {v7, v8, v6, v3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v7

    add-long v16, v16, v7

    .line 1080
    .end local v3    # "innerAdPlaybackState":Landroidx/media3/common/AdPlaybackState;
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_1

    .line 1098
    .end local v5    # "i":I
    :cond_3
    iget-object v3, v12, Landroidx/media3/common/Timeline$Period;->id:Ljava/lang/Object;

    iget-object v4, v12, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    iget v5, v12, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    iget-boolean v10, v12, Landroidx/media3/common/Timeline$Period;->isPlaceholder:Z

    move-object/from16 v2, p2

    move-wide v6, v14

    move-wide/from16 v8, v16

    move/from16 v18, v10

    move-object v10, v13

    move-object/from16 v19, v11

    .end local v11    # "innerPeriod":Landroidx/media3/common/Timeline$Period;
    .local v19, "innerPeriod":Landroidx/media3/common/Timeline$Period;
    move/from16 v11, v18

    invoke-virtual/range {v2 .. v11}, Landroidx/media3/common/Timeline$Period;->set(Ljava/lang/Object;Ljava/lang/Object;IJJLandroidx/media3/common/AdPlaybackState;Z)Landroidx/media3/common/Timeline$Period;

    .line 1106
    return-object v12
.end method

.method public getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;
    .locals 18
    .param p1, "windowIndex"    # I
    .param p2, "window"    # Landroidx/media3/common/Timeline$Window;
    .param p3, "defaultPositionProjectionUs"    # J

    .line 1031
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-super/range {p0 .. p4}, Landroidx/media3/exoplayer/source/ForwardingTimeline;->getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;

    .line 1032
    new-instance v2, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v2}, Landroidx/media3/common/Timeline$Period;-><init>()V

    .line 1033
    .local v2, "period":Landroidx/media3/common/Timeline$Period;
    iget v3, v1, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    .line 1034
    const/4 v4, 0x1

    invoke-virtual {v0, v3, v2, v4}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    move-result-object v3

    iget-object v3, v3, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 1035
    .local v3, "firstPeriodUid":Ljava/lang/Object;
    iget-object v5, v0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->adPlaybackStates:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v5, v3}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/common/AdPlaybackState;

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/common/AdPlaybackState;

    .line 1036
    .local v5, "firstAdPlaybackState":Landroidx/media3/common/AdPlaybackState;
    iget-wide v6, v1, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    .line 1037
    const/4 v8, -0x1

    invoke-static {v6, v7, v8, v5}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v6

    .line 1041
    .local v6, "positionInPeriodUs":J
    iget-wide v9, v1, Landroidx/media3/common/Timeline$Window;->durationUs:J

    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v9, v9, v11

    if-nez v9, :cond_1

    .line 1042
    iget-wide v8, v5, Landroidx/media3/common/AdPlaybackState;->contentDurationUs:J

    cmp-long v4, v8, v11

    if-eqz v4, :cond_0

    .line 1043
    iget-wide v8, v5, Landroidx/media3/common/AdPlaybackState;->contentDurationUs:J

    sub-long/2addr v8, v6

    iput-wide v8, v1, Landroidx/media3/common/Timeline$Window;->durationUs:J

    move-object v8, v2

    move-object/from16 v17, v3

    goto :goto_0

    .line 1042
    :cond_0
    move-object v8, v2

    move-object/from16 v17, v3

    goto :goto_0

    .line 1046
    :cond_1
    iget v9, v1, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    .line 1047
    invoke-super {v0, v9, v2, v4}, Landroidx/media3/exoplayer/source/ForwardingTimeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    move-result-object v4

    .line 1048
    .local v4, "originalLastPeriod":Landroidx/media3/common/Timeline$Period;
    iget-wide v9, v4, Landroidx/media3/common/Timeline$Period;->positionInWindowUs:J

    .line 1049
    .local v9, "originalLastPeriodPositionInWindowUs":J
    iget-object v11, v0, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->adPlaybackStates:Lcom/google/common/collect/ImmutableMap;

    iget-object v12, v4, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    .line 1050
    invoke-virtual {v11, v12}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/common/AdPlaybackState;

    invoke-static {v11}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/common/AdPlaybackState;

    .line 1051
    .local v11, "lastAdPlaybackState":Landroidx/media3/common/AdPlaybackState;
    iget v12, v1, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    invoke-virtual {v0, v12, v2}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionMediaSource$ServerSideAdInsertionTimeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v12

    .line 1052
    .local v12, "adjustedLastPeriod":Landroidx/media3/common/Timeline$Period;
    iget-wide v13, v1, Landroidx/media3/common/Timeline$Window;->durationUs:J

    sub-long/2addr v13, v9

    .line 1054
    .local v13, "originalWindowDurationInLastPeriodUs":J
    nop

    .line 1055
    invoke-static {v13, v14, v8, v11}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v15

    .line 1059
    .local v15, "adjustedWindowDurationInLastPeriodUs":J
    move-object v8, v2

    move-object/from16 v17, v3

    .end local v2    # "period":Landroidx/media3/common/Timeline$Period;
    .end local v3    # "firstPeriodUid":Ljava/lang/Object;
    .local v8, "period":Landroidx/media3/common/Timeline$Period;
    .local v17, "firstPeriodUid":Ljava/lang/Object;
    iget-wide v2, v12, Landroidx/media3/common/Timeline$Period;->positionInWindowUs:J

    add-long/2addr v2, v15

    iput-wide v2, v1, Landroidx/media3/common/Timeline$Window;->durationUs:J

    .line 1062
    .end local v4    # "originalLastPeriod":Landroidx/media3/common/Timeline$Period;
    .end local v9    # "originalLastPeriodPositionInWindowUs":J
    .end local v11    # "lastAdPlaybackState":Landroidx/media3/common/AdPlaybackState;
    .end local v12    # "adjustedLastPeriod":Landroidx/media3/common/Timeline$Period;
    .end local v13    # "originalWindowDurationInLastPeriodUs":J
    .end local v15    # "adjustedWindowDurationInLastPeriodUs":J
    :goto_0
    iput-wide v6, v1, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    .line 1063
    return-object v1
.end method
