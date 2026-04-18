.class public final Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;
.super Ljava/lang/Object;
.source "ServerSideAdInsertionUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static varargs addAdGroupToAdPlaybackState(Landroidx/media3/common/AdPlaybackState;JJ[J)Landroidx/media3/common/AdPlaybackState;
    .locals 10
    .param p0, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;
    .param p1, "fromPositionUs"    # J
    .param p3, "contentResumeOffsetUs"    # J
    .param p5, "adDurationsUs"    # [J

    .line 59
    nop

    .line 60
    const/4 v0, -0x1

    invoke-static {p1, p2, v0, p0}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v0

    .line 62
    .local v0, "adGroupInsertionPositionUs":J
    iget v2, p0, Landroidx/media3/common/AdPlaybackState;->removedAdGroupCount:I

    .line 63
    .local v2, "insertionIndex":I
    :goto_0
    iget v3, p0, Landroidx/media3/common/AdPlaybackState;->adGroupCount:I

    if-ge v2, v3, :cond_0

    .line 64
    invoke-virtual {p0, v2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v3

    iget-wide v3, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v3, v3, v5

    if-eqz v3, :cond_0

    .line 65
    invoke-virtual {p0, v2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v3

    iget-wide v3, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    cmp-long v3, v3, v0

    if-gtz v3, :cond_0

    .line 66
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 68
    :cond_0
    nop

    .line 70
    invoke-virtual {p0, v2, v0, v1}, Landroidx/media3/common/AdPlaybackState;->withNewAdGroup(IJ)Landroidx/media3/common/AdPlaybackState;

    move-result-object v3

    .line 71
    const/4 v4, 0x1

    invoke-virtual {v3, v2, v4}, Landroidx/media3/common/AdPlaybackState;->withIsServerSideInserted(IZ)Landroidx/media3/common/AdPlaybackState;

    move-result-object v3

    array-length v4, p5

    .line 72
    invoke-virtual {v3, v2, v4}, Landroidx/media3/common/AdPlaybackState;->withAdCount(II)Landroidx/media3/common/AdPlaybackState;

    move-result-object v3

    .line 73
    invoke-virtual {v3, v2, p5}, Landroidx/media3/common/AdPlaybackState;->withAdDurationsUs(I[J)Landroidx/media3/common/AdPlaybackState;

    move-result-object v3

    .line 74
    invoke-virtual {v3, v2, p3, p4}, Landroidx/media3/common/AdPlaybackState;->withContentResumeOffsetUs(IJ)Landroidx/media3/common/AdPlaybackState;

    move-result-object p0

    .line 76
    const/4 v3, 0x0

    move v9, v3

    .line 77
    .local v9, "adIndex":I
    :goto_1
    array-length v3, p5

    if-ge v9, v3, :cond_1

    aget-wide v3, p5, v9

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-nez v3, :cond_1

    .line 78
    add-int/lit8 v3, v9, 0x1

    .line 79
    .end local v9    # "adIndex":I
    .local v3, "adIndex":I
    invoke-virtual {p0, v2, v9}, Landroidx/media3/common/AdPlaybackState;->withSkippedAd(II)Landroidx/media3/common/AdPlaybackState;

    move-result-object p0

    move v9, v3

    goto :goto_1

    .line 81
    .end local v3    # "adIndex":I
    .restart local v9    # "adIndex":I
    :cond_1
    nop

    .line 82
    invoke-static {p5}, Landroidx/media3/common/util/Util;->sum([J)J

    move-result-wide v5

    .line 81
    move-object v3, p0

    move v4, v2

    move-wide v7, p3

    invoke-static/range {v3 .. v8}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->correctFollowingAdGroupTimes(Landroidx/media3/common/AdPlaybackState;IJJ)Landroidx/media3/common/AdPlaybackState;

    move-result-object v3

    return-object v3
.end method

.method private static correctFollowingAdGroupTimes(Landroidx/media3/common/AdPlaybackState;IJJ)Landroidx/media3/common/AdPlaybackState;
    .locals 7
    .param p0, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;
    .param p1, "adGroupInsertionIndex"    # I
    .param p2, "insertedAdDurationUs"    # J
    .param p4, "addedContentResumeOffsetUs"    # J

    .line 303
    neg-long v0, p2

    add-long/2addr v0, p4

    .line 304
    .local v0, "followingAdGroupTimeUsOffset":J
    add-int/lit8 v2, p1, 0x1

    .local v2, "i":I
    :goto_0
    iget v3, p0, Landroidx/media3/common/AdPlaybackState;->adGroupCount:I

    if-ge v2, v3, :cond_1

    .line 305
    invoke-virtual {p0, v2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v3

    iget-wide v3, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    .line 306
    .local v3, "adGroupTimeUs":J
    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v5, v3, v5

    if-eqz v5, :cond_0

    .line 307
    add-long v5, v3, v0

    .line 308
    invoke-virtual {p0, v2, v5, v6}, Landroidx/media3/common/AdPlaybackState;->withAdGroupTimeUs(IJ)Landroidx/media3/common/AdPlaybackState;

    move-result-object p0

    .line 304
    .end local v3    # "adGroupTimeUs":J
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 312
    .end local v2    # "i":I
    :cond_1
    return-object p0
.end method

.method public static getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I
    .locals 3
    .param p0, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;
    .param p1, "adGroupIndex"    # I

    .line 294
    invoke-virtual {p0, p1}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v0

    .line 295
    .local v0, "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    iget v1, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->count:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    iget v1, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->count:I

    :goto_0
    return v1
.end method

.method public static getMediaPeriodPositionUs(JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/AdPlaybackState;)J
    .locals 2
    .param p0, "positionUs"    # J
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 147
    invoke-virtual {p2}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 148
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    iget v1, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    invoke-static {p0, p1, v0, v1, p3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForAd(JIILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v0

    goto :goto_0

    .line 150
    :cond_0
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    invoke-static {p0, p1, v0, p3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v0

    .line 147
    :goto_0
    return-wide v0
.end method

.method public static getMediaPeriodPositionUsForAd(JIILandroidx/media3/common/AdPlaybackState;)J
    .locals 7
    .param p0, "positionUs"    # J
    .param p2, "adGroupIndex"    # I
    .param p3, "adIndexInAdGroup"    # I
    .param p4, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 196
    invoke-virtual {p4, p2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v0

    .line 197
    .local v0, "currentAdGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    iget-wide v1, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    sub-long/2addr p0, v1

    .line 198
    iget v1, p4, Landroidx/media3/common/AdPlaybackState;->removedAdGroupCount:I

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_1

    .line 199
    invoke-virtual {p4, v1}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v2

    .line 200
    .local v2, "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    invoke-static {p4, v1}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 201
    iget-object v4, v2, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v5, v4, v3

    sub-long/2addr p0, v5

    .line 200
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 203
    .end local v3    # "j":I
    :cond_0
    iget-wide v3, v2, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    add-long/2addr p0, v3

    .line 198
    .end local v2    # "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 205
    .end local v1    # "i":I
    :cond_1
    invoke-static {p4, p2}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v1

    if-ge p3, v1, :cond_2

    .line 206
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_2
    if-ge v1, p3, :cond_2

    .line 207
    iget-object v2, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v3, v2, v1

    sub-long/2addr p0, v3

    .line 206
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 210
    .end local v1    # "i":I
    :cond_2
    return-wide p0
.end method

.method public static getMediaPeriodPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J
    .locals 10
    .param p0, "positionUs"    # J
    .param p2, "nextAdGroupIndex"    # I
    .param p3, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 263
    const-wide/16 v0, 0x0

    .line 264
    .local v0, "totalAdDurationBeforePositionUs":J
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 265
    iget p2, p3, Landroidx/media3/common/AdPlaybackState;->adGroupCount:I

    .line 267
    :cond_0
    iget v2, p3, Landroidx/media3/common/AdPlaybackState;->removedAdGroupCount:I

    .local v2, "i":I
    :goto_0
    if-ge v2, p2, :cond_4

    .line 268
    invoke-virtual {p3, v2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v3

    .line 269
    .local v3, "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    const-wide/high16 v6, -0x8000000000000000L

    cmp-long v4, v4, v6

    if-eqz v4, :cond_4

    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    sub-long v6, p0, v0

    cmp-long v4, v4, v6

    if-lez v4, :cond_1

    .line 271
    goto :goto_2

    .line 273
    :cond_1
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_1
    invoke-static {p3, v2}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v5

    if-ge v4, v5, :cond_2

    .line 274
    iget-object v5, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v6, v5, v4

    add-long/2addr v0, v6

    .line 273
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 276
    .end local v4    # "j":I
    :cond_2
    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    sub-long/2addr v0, v4

    .line 277
    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    iget-wide v6, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    add-long/2addr v4, v6

    .line 278
    .local v4, "adGroupResumePositionUs":J
    sub-long v6, p0, v0

    cmp-long v6, v4, v6

    if-lez v6, :cond_3

    .line 280
    iget-wide v6, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    sub-long v8, p0, v0

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v6

    return-wide v6

    .line 267
    .end local v3    # "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    .end local v4    # "adGroupResumePositionUs":J
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 283
    .end local v2    # "i":I
    :cond_4
    :goto_2
    sub-long v2, p0, v0

    return-wide v2
.end method

.method public static getStreamPositionUs(JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/AdPlaybackState;)J
    .locals 2
    .param p0, "positionUs"    # J
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 128
    invoke-virtual {p2}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    iget v1, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adIndexInAdGroup:I

    invoke-static {p0, p1, v0, v1, p3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getStreamPositionUsForAd(JIILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v0

    goto :goto_0

    .line 131
    :cond_0
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->nextAdGroupIndex:I

    invoke-static {p0, p1, v0, p3}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getStreamPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v0

    .line 128
    :goto_0
    return-wide v0
.end method

.method public static getStreamPositionUs(Landroidx/media3/common/Player;Landroidx/media3/common/AdPlaybackState;)J
    .locals 8
    .param p0, "player"    # Landroidx/media3/common/Player;
    .param p1, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 95
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    .line 96
    .local v0, "timeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v1

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    if-eqz v1, :cond_0

    .line 97
    return-wide v2

    .line 99
    :cond_0
    nop

    .line 100
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentPeriodIndex()I

    move-result v1

    new-instance v4, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v4}, Landroidx/media3/common/Timeline$Period;-><init>()V

    invoke-virtual {v0, v1, v4}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v1

    .line 101
    .local v1, "period":Landroidx/media3/common/Timeline$Period;
    invoke-virtual {v1}, Landroidx/media3/common/Timeline$Period;->getAdsId()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, p1, Landroidx/media3/common/AdPlaybackState;->adsId:Ljava/lang/Object;

    invoke-static {v4, v5}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 102
    return-wide v2

    .line 104
    :cond_1
    invoke-interface {p0}, Landroidx/media3/common/Player;->isPlayingAd()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 105
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentAdGroupIndex()I

    move-result v2

    .line 106
    .local v2, "adGroupIndex":I
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentAdIndexInAdGroup()I

    move-result v3

    .line 107
    .local v3, "adIndexInAdGroup":I
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentPosition()J

    move-result-wide v4

    invoke-static {v4, v5}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v4

    .line 108
    .local v4, "adPositionUs":J
    invoke-static {v4, v5, v2, v3, p1}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getStreamPositionUsForAd(JIILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v6

    return-wide v6

    .line 111
    .end local v2    # "adGroupIndex":I
    .end local v3    # "adIndexInAdGroup":I
    .end local v4    # "adPositionUs":J
    :cond_2
    nop

    .line 112
    invoke-interface {p0}, Landroidx/media3/common/Player;->getCurrentPosition()J

    move-result-wide v2

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v2

    invoke-virtual {v1}, Landroidx/media3/common/Timeline$Period;->getPositionInWindowUs()J

    move-result-wide v4

    sub-long/2addr v2, v4

    .line 113
    .local v2, "periodPositionUs":J
    const/4 v4, -0x1

    invoke-static {v2, v3, v4, p1}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getStreamPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J

    move-result-wide v4

    return-wide v4
.end method

.method public static getStreamPositionUsForAd(JIILandroidx/media3/common/AdPlaybackState;)J
    .locals 7
    .param p0, "positionUs"    # J
    .param p2, "adGroupIndex"    # I
    .param p3, "adIndexInAdGroup"    # I
    .param p4, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 166
    invoke-virtual {p4, p2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v0

    .line 167
    .local v0, "currentAdGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    iget-wide v1, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    add-long/2addr p0, v1

    .line 168
    iget v1, p4, Landroidx/media3/common/AdPlaybackState;->removedAdGroupCount:I

    .local v1, "i":I
    :goto_0
    if-ge v1, p2, :cond_1

    .line 169
    invoke-virtual {p4, v1}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v2

    .line 170
    .local v2, "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    invoke-static {p4, v1}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 171
    iget-object v4, v2, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v5, v4, v3

    add-long/2addr p0, v5

    .line 170
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 173
    .end local v3    # "j":I
    :cond_0
    iget-wide v3, v2, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    sub-long/2addr p0, v3

    .line 168
    .end local v2    # "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 175
    .end local v1    # "i":I
    :cond_1
    invoke-static {p4, p2}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v1

    if-ge p3, v1, :cond_2

    .line 176
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_2
    if-ge v1, p3, :cond_2

    .line 177
    iget-object v2, v0, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v3, v2, v1

    add-long/2addr p0, v3

    .line 176
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 180
    .end local v1    # "i":I
    :cond_2
    return-wide p0
.end method

.method public static getStreamPositionUsForContent(JILandroidx/media3/common/AdPlaybackState;)J
    .locals 10
    .param p0, "positionUs"    # J
    .param p2, "nextAdGroupIndex"    # I
    .param p3, "adPlaybackState"    # Landroidx/media3/common/AdPlaybackState;

    .line 226
    const-wide/16 v0, 0x0

    .line 227
    .local v0, "totalAdDurationBeforePositionUs":J
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 228
    iget p2, p3, Landroidx/media3/common/AdPlaybackState;->adGroupCount:I

    .line 230
    :cond_0
    iget v2, p3, Landroidx/media3/common/AdPlaybackState;->removedAdGroupCount:I

    .local v2, "i":I
    :goto_0
    if-ge v2, p2, :cond_4

    .line 231
    invoke-virtual {p3, v2}, Landroidx/media3/common/AdPlaybackState;->getAdGroup(I)Landroidx/media3/common/AdPlaybackState$AdGroup;

    move-result-object v3

    .line 232
    .local v3, "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    const-wide/high16 v6, -0x8000000000000000L

    cmp-long v4, v4, v6

    if-eqz v4, :cond_4

    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    cmp-long v4, v4, p0

    if-lez v4, :cond_1

    .line 233
    goto :goto_2

    .line 235
    :cond_1
    iget-wide v4, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    add-long/2addr v4, v0

    .line 236
    .local v4, "adGroupStreamStartPositionUs":J
    const/4 v6, 0x0

    .local v6, "j":I
    :goto_1
    invoke-static {p3, v2}, Landroidx/media3/exoplayer/source/ads/ServerSideAdInsertionUtil;->getAdCountInGroup(Landroidx/media3/common/AdPlaybackState;I)I

    move-result v7

    if-ge v6, v7, :cond_2

    .line 237
    iget-object v7, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->durationsUs:[J

    aget-wide v8, v7, v6

    add-long/2addr v0, v8

    .line 236
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 239
    .end local v6    # "j":I
    :cond_2
    iget-wide v6, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    sub-long/2addr v0, v6

    .line 240
    iget-wide v6, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->timeUs:J

    iget-wide v8, v3, Landroidx/media3/common/AdPlaybackState$AdGroup;->contentResumeOffsetUs:J

    add-long/2addr v6, v8

    .line 241
    .local v6, "adGroupResumePositionUs":J
    cmp-long v8, v6, p0

    if-lez v8, :cond_3

    .line 243
    add-long v8, p0, v0

    invoke-static {v4, v5, v8, v9}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v8

    return-wide v8

    .line 230
    .end local v3    # "adGroup":Landroidx/media3/common/AdPlaybackState$AdGroup;
    .end local v4    # "adGroupStreamStartPositionUs":J
    .end local v6    # "adGroupResumePositionUs":J
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 246
    .end local v2    # "i":I
    :cond_4
    :goto_2
    add-long v2, p0, v0

    return-wide v2
.end method
