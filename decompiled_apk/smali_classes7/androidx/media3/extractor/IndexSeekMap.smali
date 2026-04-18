.class public final Landroidx/media3/extractor/IndexSeekMap;
.super Ljava/lang/Object;
.source "IndexSeekMap.java"

# interfaces
.implements Landroidx/media3/extractor/SeekMap;


# instance fields
.field private final durationUs:J

.field private final isSeekable:Z

.field private final positions:[J

.field private final timesUs:[J


# direct methods
.method public constructor <init>([J[JJ)V
    .locals 8
    .param p1, "positions"    # [J
    .param p2, "timesUs"    # [J
    .param p3, "durationUs"    # J

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    array-length v0, p1

    array-length v1, p2

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-ne v0, v1, :cond_0

    move v0, v3

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 46
    array-length v0, p2

    .line 47
    .local v0, "length":I
    if-lez v0, :cond_1

    move v1, v3

    goto :goto_1

    :cond_1
    move v1, v2

    :goto_1
    iput-boolean v1, p0, Landroidx/media3/extractor/IndexSeekMap;->isSeekable:Z

    .line 48
    if-eqz v1, :cond_2

    aget-wide v4, p2, v2

    const-wide/16 v6, 0x0

    cmp-long v1, v4, v6

    if-lez v1, :cond_2

    .line 50
    add-int/lit8 v1, v0, 0x1

    new-array v1, v1, [J

    iput-object v1, p0, Landroidx/media3/extractor/IndexSeekMap;->positions:[J

    .line 51
    add-int/lit8 v4, v0, 0x1

    new-array v4, v4, [J

    iput-object v4, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    .line 52
    invoke-static {p1, v2, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 53
    invoke-static {p2, v2, v4, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_2

    .line 55
    :cond_2
    iput-object p1, p0, Landroidx/media3/extractor/IndexSeekMap;->positions:[J

    .line 56
    iput-object p2, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    .line 58
    :goto_2
    iput-wide p3, p0, Landroidx/media3/extractor/IndexSeekMap;->durationUs:J

    .line 59
    return-void
.end method


# virtual methods
.method public getDurationUs()J
    .locals 2

    .line 68
    iget-wide v0, p0, Landroidx/media3/extractor/IndexSeekMap;->durationUs:J

    return-wide v0
.end method

.method public getSeekPoints(J)Landroidx/media3/extractor/SeekMap$SeekPoints;
    .locals 8
    .param p1, "timeUs"    # J

    .line 73
    iget-boolean v0, p0, Landroidx/media3/extractor/IndexSeekMap;->isSeekable:Z

    if-nez v0, :cond_0

    .line 74
    new-instance v0, Landroidx/media3/extractor/SeekMap$SeekPoints;

    sget-object v1, Landroidx/media3/extractor/SeekPoint;->START:Landroidx/media3/extractor/SeekPoint;

    invoke-direct {v0, v1}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;)V

    return-object v0

    .line 76
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    .line 77
    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v0

    .line 78
    .local v0, "targetIndex":I
    new-instance v2, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    aget-wide v4, v3, v0

    iget-object v3, p0, Landroidx/media3/extractor/IndexSeekMap;->positions:[J

    aget-wide v6, v3, v0

    invoke-direct {v2, v4, v5, v6, v7}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 79
    .local v2, "leftSeekPoint":Landroidx/media3/extractor/SeekPoint;
    iget-wide v3, v2, Landroidx/media3/extractor/SeekPoint;->timeUs:J

    cmp-long v3, v3, p1

    if-eqz v3, :cond_2

    iget-object v3, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    array-length v3, v3

    sub-int/2addr v3, v1

    if-ne v0, v3, :cond_1

    goto :goto_0

    .line 82
    :cond_1
    new-instance v1, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/IndexSeekMap;->timesUs:[J

    add-int/lit8 v4, v0, 0x1

    aget-wide v4, v3, v4

    iget-object v3, p0, Landroidx/media3/extractor/IndexSeekMap;->positions:[J

    add-int/lit8 v6, v0, 0x1

    aget-wide v6, v3, v6

    invoke-direct {v1, v4, v5, v6, v7}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 84
    .local v1, "rightSeekPoint":Landroidx/media3/extractor/SeekPoint;
    new-instance v3, Landroidx/media3/extractor/SeekMap$SeekPoints;

    invoke-direct {v3, v2, v1}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;Landroidx/media3/extractor/SeekPoint;)V

    return-object v3

    .line 80
    .end local v1    # "rightSeekPoint":Landroidx/media3/extractor/SeekPoint;
    :cond_2
    :goto_0
    new-instance v1, Landroidx/media3/extractor/SeekMap$SeekPoints;

    invoke-direct {v1, v2}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;)V

    return-object v1
.end method

.method public isSeekable()Z
    .locals 1

    .line 63
    iget-boolean v0, p0, Landroidx/media3/extractor/IndexSeekMap;->isSeekable:Z

    return v0
.end method
