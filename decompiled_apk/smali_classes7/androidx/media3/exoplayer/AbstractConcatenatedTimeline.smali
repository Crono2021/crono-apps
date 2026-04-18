.class public abstract Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;
.super Landroidx/media3/common/Timeline;
.source "AbstractConcatenatedTimeline.java"


# instance fields
.field private final childCount:I

.field private final isAtomic:Z

.field private final shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;


# direct methods
.method public constructor <init>(ZLandroidx/media3/exoplayer/source/ShuffleOrder;)V
    .locals 1
    .param p1, "isAtomic"    # Z
    .param p2, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 75
    invoke-direct {p0}, Landroidx/media3/common/Timeline;-><init>()V

    .line 76
    iput-boolean p1, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->isAtomic:Z

    .line 77
    iput-object p2, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 78
    invoke-interface {p2}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->childCount:I

    .line 79
    return-void
.end method

.method public static getChildPeriodUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "concatenatedUid"    # Ljava/lang/Object;

    .line 53
    move-object v0, p0

    check-cast v0, Landroid/util/Pair;

    iget-object v0, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    return-object v0
.end method

.method public static getChildTimelineUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "concatenatedUid"    # Ljava/lang/Object;

    .line 42
    move-object v0, p0

    check-cast v0, Landroid/util/Pair;

    iget-object v0, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    return-object v0
.end method

.method public static getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "childTimelineUid"    # Ljava/lang/Object;
    .param p1, "childPeriodOrWindowUid"    # Ljava/lang/Object;

    .line 64
    invoke-static {p0, p1}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v0

    return-object v0
.end method

.method private getNextChildIndex(IZ)I
    .locals 1
    .param p1, "childIndex"    # I
    .param p2, "shuffleModeEnabled"    # Z

    .line 320
    if-eqz p2, :cond_0

    .line 321
    iget-object v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getNextIndex(I)I

    move-result v0

    goto :goto_0

    .line 322
    :cond_0
    iget v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->childCount:I

    add-int/lit8 v0, v0, -0x1

    if-ge p1, v0, :cond_1

    add-int/lit8 v0, p1, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, -0x1

    .line 320
    :goto_0
    return v0
.end method

.method private getPreviousChildIndex(IZ)I
    .locals 1
    .param p1, "childIndex"    # I
    .param p2, "shuffleModeEnabled"    # Z

    .line 326
    if-eqz p2, :cond_0

    .line 327
    iget-object v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getPreviousIndex(I)I

    move-result v0

    goto :goto_0

    .line 328
    :cond_0
    if-lez p1, :cond_1

    add-int/lit8 v0, p1, -0x1

    goto :goto_0

    :cond_1
    const/4 v0, -0x1

    .line 326
    :goto_0
    return v0
.end method


# virtual methods
.method protected abstract getChildIndexByChildUid(Ljava/lang/Object;)I
.end method

.method protected abstract getChildIndexByPeriodIndex(I)I
.end method

.method protected abstract getChildIndexByWindowIndex(I)I
.end method

.method protected abstract getChildUidByChildIndex(I)Ljava/lang/Object;
.end method

.method protected abstract getFirstPeriodIndexByChildIndex(I)I
.end method

.method public getFirstWindowIndex(Z)I
    .locals 3
    .param p1, "shuffleModeEnabled"    # Z

    .line 177
    iget v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->childCount:I

    const/4 v1, -0x1

    if-nez v0, :cond_0

    .line 178
    return v1

    .line 180
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->isAtomic:Z

    if-eqz v0, :cond_1

    .line 181
    const/4 p1, 0x0

    .line 184
    :cond_1
    if-eqz p1, :cond_2

    iget-object v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getFirstIndex()I

    move-result v0

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    .line 185
    .local v0, "firstChildIndex":I
    :cond_3
    :goto_0
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 186
    invoke-direct {p0, v0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getNextChildIndex(IZ)I

    move-result v0

    .line 187
    if-ne v0, v1, :cond_3

    .line 189
    return v1

    .line 192
    :cond_4
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 193
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroidx/media3/common/Timeline;->getFirstWindowIndex(Z)I

    move-result v2

    add-int/2addr v1, v2

    .line 192
    return v1
.end method

.method protected abstract getFirstWindowIndexByChildIndex(I)I
.end method

.method public final getIndexOfPeriod(Ljava/lang/Object;)I
    .locals 5
    .param p1, "uid"    # Ljava/lang/Object;

    .line 244
    instance-of v0, p1, Landroid/util/Pair;

    const/4 v1, -0x1

    if-nez v0, :cond_0

    .line 245
    return v1

    .line 247
    :cond_0
    invoke-static {p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildTimelineUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 248
    .local v0, "childUid":Ljava/lang/Object;
    invoke-static {p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildPeriodUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 249
    .local v2, "childPeriodUid":Ljava/lang/Object;
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByChildUid(Ljava/lang/Object;)I

    move-result v3

    .line 250
    .local v3, "childIndex":I
    if-ne v3, v1, :cond_1

    .line 251
    return v1

    .line 253
    :cond_1
    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroidx/media3/common/Timeline;->getIndexOfPeriod(Ljava/lang/Object;)I

    move-result v4

    .line 254
    .local v4, "periodIndexInChild":I
    if-ne v4, v1, :cond_2

    .line 255
    goto :goto_0

    .line 256
    :cond_2
    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstPeriodIndexByChildIndex(I)I

    move-result v1

    add-int/2addr v1, v4

    .line 254
    :goto_0
    return v1
.end method

.method public getLastWindowIndex(Z)I
    .locals 3
    .param p1, "shuffleModeEnabled"    # Z

    .line 156
    iget v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->childCount:I

    const/4 v1, -0x1

    if-nez v0, :cond_0

    .line 157
    return v1

    .line 159
    :cond_0
    iget-boolean v2, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->isAtomic:Z

    if-eqz v2, :cond_1

    .line 160
    const/4 p1, 0x0

    .line 163
    :cond_1
    if-eqz p1, :cond_2

    iget-object v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLastIndex()I

    move-result v0

    goto :goto_0

    :cond_2
    add-int/lit8 v0, v0, -0x1

    .line 164
    .local v0, "lastChildIndex":I
    :cond_3
    :goto_0
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 165
    invoke-direct {p0, v0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getPreviousChildIndex(IZ)I

    move-result v0

    .line 166
    if-ne v0, v1, :cond_3

    .line 168
    return v1

    .line 171
    :cond_4
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 172
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroidx/media3/common/Timeline;->getLastWindowIndex(Z)I

    move-result v2

    add-int/2addr v1, v2

    .line 171
    return v1
.end method

.method public getNextWindowIndex(IIZ)I
    .locals 7
    .param p1, "windowIndex"    # I
    .param p2, "repeatMode"    # I
    .param p3, "shuffleModeEnabled"    # Z

    .line 84
    iget-boolean v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->isAtomic:Z

    const/4 v1, 0x2

    if-eqz v0, :cond_1

    .line 86
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, p2

    :goto_0
    move p2, v0

    .line 87
    const/4 p3, 0x0

    .line 90
    :cond_1
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByWindowIndex(I)I

    move-result v0

    .line 91
    .local v0, "childIndex":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v2

    .line 92
    .local v2, "firstWindowIndexInChild":I
    nop

    .line 93
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v3

    sub-int v4, p1, v2

    .line 96
    if-ne p2, v1, :cond_2

    const/4 v5, 0x0

    goto :goto_1

    :cond_2
    move v5, p2

    .line 94
    :goto_1
    invoke-virtual {v3, v4, v5, p3}, Landroidx/media3/common/Timeline;->getNextWindowIndex(IIZ)I

    move-result v3

    .line 98
    .local v3, "nextWindowIndexInChild":I
    const/4 v4, -0x1

    if-eq v3, v4, :cond_3

    .line 99
    add-int v1, v2, v3

    return v1

    .line 102
    :cond_3
    invoke-direct {p0, v0, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getNextChildIndex(IZ)I

    move-result v5

    .line 103
    .local v5, "nextChildIndex":I
    :goto_2
    if-eq v5, v4, :cond_4

    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 104
    invoke-direct {p0, v5, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getNextChildIndex(IZ)I

    move-result v5

    goto :goto_2

    .line 106
    :cond_4
    if-eq v5, v4, :cond_5

    .line 107
    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 108
    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v4

    invoke-virtual {v4, p3}, Landroidx/media3/common/Timeline;->getFirstWindowIndex(Z)I

    move-result v4

    add-int/2addr v1, v4

    .line 107
    return v1

    .line 111
    :cond_5
    if-ne p2, v1, :cond_6

    .line 112
    invoke-virtual {p0, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndex(Z)I

    move-result v1

    return v1

    .line 114
    :cond_6
    return v4
.end method

.method public final getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;
    .locals 5
    .param p1, "periodIndex"    # I
    .param p2, "period"    # Landroidx/media3/common/Timeline$Period;
    .param p3, "setIds"    # Z

    .line 228
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByPeriodIndex(I)I

    move-result v0

    .line 229
    .local v0, "childIndex":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 230
    .local v1, "firstWindowIndexInChild":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstPeriodIndexByChildIndex(I)I

    move-result v2

    .line 231
    .local v2, "firstPeriodIndexInChild":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v3

    sub-int v4, p1, v2

    .line 232
    invoke-virtual {v3, v4, p2, p3}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 233
    iget v3, p2, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    add-int/2addr v3, v1

    iput v3, p2, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 234
    if-eqz p3, :cond_0

    .line 235
    nop

    .line 237
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildUidByChildIndex(I)Ljava/lang/Object;

    move-result-object v3

    iget-object v4, p2, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 236
    invoke-static {v3, v4}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p2, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    .line 239
    :cond_0
    return-object p2
.end method

.method public final getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;
    .locals 5
    .param p1, "periodUid"    # Ljava/lang/Object;
    .param p2, "period"    # Landroidx/media3/common/Timeline$Period;

    .line 216
    invoke-static {p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildTimelineUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 217
    .local v0, "childUid":Ljava/lang/Object;
    invoke-static {p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildPeriodUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 218
    .local v1, "childPeriodUid":Ljava/lang/Object;
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByChildUid(Ljava/lang/Object;)I

    move-result v2

    .line 219
    .local v2, "childIndex":I
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v3

    .line 220
    .local v3, "firstWindowIndexInChild":I
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v4

    invoke-virtual {v4, v1, p2}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    .line 221
    iget v4, p2, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    add-int/2addr v4, v3

    iput v4, p2, Landroidx/media3/common/Timeline$Period;->windowIndex:I

    .line 222
    iput-object p1, p2, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    .line 223
    return-object p2
.end method

.method public getPreviousWindowIndex(IIZ)I
    .locals 7
    .param p1, "windowIndex"    # I
    .param p2, "repeatMode"    # I
    .param p3, "shuffleModeEnabled"    # Z

    .line 120
    iget-boolean v0, p0, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->isAtomic:Z

    const/4 v1, 0x2

    if-eqz v0, :cond_1

    .line 122
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, p2

    :goto_0
    move p2, v0

    .line 123
    const/4 p3, 0x0

    .line 126
    :cond_1
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByWindowIndex(I)I

    move-result v0

    .line 127
    .local v0, "childIndex":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v2

    .line 128
    .local v2, "firstWindowIndexInChild":I
    nop

    .line 129
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v3

    sub-int v4, p1, v2

    .line 132
    if-ne p2, v1, :cond_2

    const/4 v5, 0x0

    goto :goto_1

    :cond_2
    move v5, p2

    .line 130
    :goto_1
    invoke-virtual {v3, v4, v5, p3}, Landroidx/media3/common/Timeline;->getPreviousWindowIndex(IIZ)I

    move-result v3

    .line 134
    .local v3, "previousWindowIndexInChild":I
    const/4 v4, -0x1

    if-eq v3, v4, :cond_3

    .line 135
    add-int v1, v2, v3

    return v1

    .line 138
    :cond_3
    invoke-direct {p0, v0, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getPreviousChildIndex(IZ)I

    move-result v5

    .line 139
    .local v5, "previousChildIndex":I
    :goto_2
    if-eq v5, v4, :cond_4

    .line 140
    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 141
    invoke-direct {p0, v5, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getPreviousChildIndex(IZ)I

    move-result v5

    goto :goto_2

    .line 143
    :cond_4
    if-eq v5, v4, :cond_5

    .line 144
    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 145
    invoke-virtual {p0, v5}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v4

    invoke-virtual {v4, p3}, Landroidx/media3/common/Timeline;->getLastWindowIndex(Z)I

    move-result v4

    add-int/2addr v1, v4

    .line 144
    return v1

    .line 148
    :cond_5
    if-ne p2, v1, :cond_6

    .line 149
    invoke-virtual {p0, p3}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getLastWindowIndex(Z)I

    move-result v1

    return v1

    .line 151
    :cond_6
    return v4
.end method

.method protected abstract getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;
.end method

.method public final getUidOfPeriod(I)Ljava/lang/Object;
    .locals 4
    .param p1, "periodIndex"    # I

    .line 261
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByPeriodIndex(I)I

    move-result v0

    .line 262
    .local v0, "childIndex":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstPeriodIndexByChildIndex(I)I

    move-result v1

    .line 263
    .local v1, "firstPeriodIndexInChild":I
    nop

    .line 264
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v2

    sub-int v3, p1, v1

    invoke-virtual {v2, v3}, Landroidx/media3/common/Timeline;->getUidOfPeriod(I)Ljava/lang/Object;

    move-result-object v2

    .line 265
    .local v2, "periodUidInChild":Ljava/lang/Object;
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildUidByChildIndex(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3, v2}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    return-object v3
.end method

.method public final getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;
    .locals 6
    .param p1, "windowIndex"    # I
    .param p2, "window"    # Landroidx/media3/common/Timeline$Window;
    .param p3, "defaultPositionProjectionUs"    # J

    .line 198
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildIndexByWindowIndex(I)I

    move-result v0

    .line 199
    .local v0, "childIndex":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstWindowIndexByChildIndex(I)I

    move-result v1

    .line 200
    .local v1, "firstWindowIndexInChild":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getFirstPeriodIndexByChildIndex(I)I

    move-result v2

    .line 201
    .local v2, "firstPeriodIndexInChild":I
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getTimelineByChildIndex(I)Landroidx/media3/common/Timeline;

    move-result-object v3

    sub-int v4, p1, v1

    .line 202
    invoke-virtual {v3, v4, p2, p3, p4}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;

    .line 203
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getChildUidByChildIndex(I)Ljava/lang/Object;

    move-result-object v3

    .line 205
    .local v3, "childUid":Ljava/lang/Object;
    nop

    .line 206
    sget-object v4, Landroidx/media3/common/Timeline$Window;->SINGLE_WINDOW_UID:Ljava/lang/Object;

    iget-object v5, p2, Landroidx/media3/common/Timeline$Window;->uid:Ljava/lang/Object;

    invoke-virtual {v4, v5}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 207
    move-object v4, v3

    goto :goto_0

    .line 208
    :cond_0
    iget-object v4, p2, Landroidx/media3/common/Timeline$Window;->uid:Ljava/lang/Object;

    invoke-static {v3, v4}, Landroidx/media3/exoplayer/AbstractConcatenatedTimeline;->getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    :goto_0
    iput-object v4, p2, Landroidx/media3/common/Timeline$Window;->uid:Ljava/lang/Object;

    .line 209
    iget v4, p2, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    add-int/2addr v4, v2

    iput v4, p2, Landroidx/media3/common/Timeline$Window;->firstPeriodIndex:I

    .line 210
    iget v4, p2, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    add-int/2addr v4, v2

    iput v4, p2, Landroidx/media3/common/Timeline$Window;->lastPeriodIndex:I

    .line 211
    return-object p2
.end method
