.class final Landroidx/media3/extractor/mp3/IndexSeeker;
.super Ljava/lang/Object;
.source "IndexSeeker.java"

# interfaces
.implements Landroidx/media3/extractor/mp3/Seeker;


# static fields
.field static final MIN_TIME_BETWEEN_POINTS_US:J = 0x186a0L


# instance fields
.field private final averageBitrate:I

.field private final dataEndPosition:J

.field private durationUs:J

.field private final positions:Landroidx/media3/common/util/LongArray;

.field private final timesUs:Landroidx/media3/common/util/LongArray;


# direct methods
.method public constructor <init>(JJJ)V
    .locals 17
    .param p1, "durationUs"    # J
    .param p3, "dataStartPosition"    # J
    .param p5, "dataEndPosition"    # J

    .line 38
    move-object/from16 v0, p0

    move-wide/from16 v8, p1

    move-wide/from16 v10, p3

    move-wide/from16 v12, p5

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-wide v8, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->durationUs:J

    .line 40
    iput-wide v12, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->dataEndPosition:J

    .line 41
    new-instance v1, Landroidx/media3/common/util/LongArray;

    invoke-direct {v1}, Landroidx/media3/common/util/LongArray;-><init>()V

    iput-object v1, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    .line 42
    new-instance v2, Landroidx/media3/common/util/LongArray;

    invoke-direct {v2}, Landroidx/media3/common/util/LongArray;-><init>()V

    iput-object v2, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->positions:Landroidx/media3/common/util/LongArray;

    .line 43
    const-wide/16 v14, 0x0

    invoke-virtual {v1, v14, v15}, Landroidx/media3/common/util/LongArray;->add(J)V

    .line 44
    invoke-virtual {v2, v10, v11}, Landroidx/media3/common/util/LongArray;->add(J)V

    .line 45
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v1, v8, v1

    const v7, -0x7fffffff

    if-eqz v1, :cond_1

    .line 46
    sub-long v1, v10, v12

    const-wide/16 v3, 0x8

    sget-object v16, Ljava/math/RoundingMode;->HALF_UP:Ljava/math/RoundingMode;

    .line 47
    move-wide/from16 v5, p1

    move-object/from16 v7, v16

    invoke-static/range {v1 .. v7}, Landroidx/media3/common/util/Util;->scaleLargeValue(JJJLjava/math/RoundingMode;)J

    move-result-wide v1

    .line 49
    .local v1, "bitrate":J
    nop

    .line 50
    cmp-long v3, v1, v14

    if-lez v3, :cond_0

    const-wide/32 v3, 0x7fffffff

    cmp-long v3, v1, v3

    if-gtz v3, :cond_0

    long-to-int v7, v1

    goto :goto_0

    :cond_0
    const v7, -0x7fffffff

    :goto_0
    iput v7, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->averageBitrate:I

    .line 51
    .end local v1    # "bitrate":J
    goto :goto_1

    .line 52
    :cond_1
    const v1, -0x7fffffff

    iput v1, v0, Landroidx/media3/extractor/mp3/IndexSeeker;->averageBitrate:I

    .line 54
    :goto_1
    return-void
.end method


# virtual methods
.method public getAverageBitrate()I
    .locals 1

    .line 95
    iget v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->averageBitrate:I

    return v0
.end method

.method public getDataEndPosition()J
    .locals 2

    .line 66
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->dataEndPosition:J

    return-wide v0
.end method

.method public getDurationUs()J
    .locals 2

    .line 76
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->durationUs:J

    return-wide v0
.end method

.method public getSeekPoints(J)Landroidx/media3/extractor/SeekMap$SeekPoints;
    .locals 7
    .param p1, "timeUs"    # J

    .line 81
    iget-object v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    .line 82
    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor(Landroidx/media3/common/util/LongArray;JZZ)I

    move-result v0

    .line 83
    .local v0, "targetIndex":I
    new-instance v2, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v3, v0}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v3

    iget-object v5, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->positions:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v5, v0}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v5

    invoke-direct {v2, v3, v4, v5, v6}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 84
    .local v2, "seekPoint":Landroidx/media3/extractor/SeekPoint;
    iget-wide v3, v2, Landroidx/media3/extractor/SeekPoint;->timeUs:J

    cmp-long v3, v3, p1

    if-eqz v3, :cond_1

    iget-object v3, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v3}, Landroidx/media3/common/util/LongArray;->size()I

    move-result v3

    sub-int/2addr v3, v1

    if-ne v0, v3, :cond_0

    goto :goto_0

    .line 87
    :cond_0
    new-instance v1, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    add-int/lit8 v4, v0, 0x1

    .line 88
    invoke-virtual {v3, v4}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v3

    iget-object v5, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->positions:Landroidx/media3/common/util/LongArray;

    add-int/lit8 v6, v0, 0x1

    invoke-virtual {v5, v6}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v5

    invoke-direct {v1, v3, v4, v5, v6}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 89
    .local v1, "nextSeekPoint":Landroidx/media3/extractor/SeekPoint;
    new-instance v3, Landroidx/media3/extractor/SeekMap$SeekPoints;

    invoke-direct {v3, v2, v1}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;Landroidx/media3/extractor/SeekPoint;)V

    return-object v3

    .line 85
    .end local v1    # "nextSeekPoint":Landroidx/media3/extractor/SeekPoint;
    :cond_1
    :goto_0
    new-instance v1, Landroidx/media3/extractor/SeekMap$SeekPoints;

    invoke-direct {v1, v2}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;)V

    return-object v1
.end method

.method public getTimeUs(J)J
    .locals 3
    .param p1, "position"    # J

    .line 58
    iget-object v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->positions:Landroidx/media3/common/util/LongArray;

    .line 59
    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor(Landroidx/media3/common/util/LongArray;JZZ)I

    move-result v0

    .line 61
    .local v0, "targetIndex":I
    iget-object v1, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v1, v0}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v1

    return-wide v1
.end method

.method public isSeekable()Z
    .locals 1

    .line 71
    const/4 v0, 0x1

    return v0
.end method

.method public isTimeUsInIndex(J)Z
    .locals 7
    .param p1, "timeUs"    # J

    .line 121
    iget-object v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/LongArray;->size()I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/LongArray;->get(I)J

    move-result-wide v0

    .line 122
    .local v0, "lastIndexedTimeUs":J
    sub-long v3, p1, v0

    const-wide/32 v5, 0x186a0

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    return v2
.end method

.method public maybeAddSeekPoint(JJ)V
    .locals 1
    .param p1, "timeUs"    # J
    .param p3, "position"    # J

    .line 107
    invoke-virtual {p0, p1, p2}, Landroidx/media3/extractor/mp3/IndexSeeker;->isTimeUsInIndex(J)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    return-void

    .line 110
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->timesUs:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/common/util/LongArray;->add(J)V

    .line 111
    iget-object v0, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->positions:Landroidx/media3/common/util/LongArray;

    invoke-virtual {v0, p3, p4}, Landroidx/media3/common/util/LongArray;->add(J)V

    .line 112
    return-void
.end method

.method setDurationUs(J)V
    .locals 0
    .param p1, "durationUs"    # J

    .line 126
    iput-wide p1, p0, Landroidx/media3/extractor/mp3/IndexSeeker;->durationUs:J

    .line 127
    return-void
.end method
