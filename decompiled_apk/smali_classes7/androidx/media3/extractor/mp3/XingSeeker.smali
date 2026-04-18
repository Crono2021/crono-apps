.class final Landroidx/media3/extractor/mp3/XingSeeker;
.super Ljava/lang/Object;
.source "XingSeeker.java"

# interfaces
.implements Landroidx/media3/extractor/mp3/Seeker;


# static fields
.field private static final TAG:Ljava/lang/String; = "XingSeeker"


# instance fields
.field private final bitrate:I

.field private final dataEndPosition:J

.field private final dataSize:J

.field private final dataStartPosition:J

.field private final durationUs:J

.field private final tableOfContents:[J

.field private final xingFrameSize:I


# direct methods
.method private constructor <init>(JIJI)V
    .locals 10
    .param p1, "dataStartPosition"    # J
    .param p3, "xingFrameSize"    # I
    .param p4, "durationUs"    # J
    .param p6, "bitrate"    # I

    .line 92
    const-wide/16 v7, -0x1

    const/4 v9, 0x0

    move-object v0, p0

    move-wide v1, p1

    move v3, p3

    move-wide v4, p4

    move/from16 v6, p6

    invoke-direct/range {v0 .. v9}, Landroidx/media3/extractor/mp3/XingSeeker;-><init>(JIJIJ[J)V

    .line 99
    return-void
.end method

.method private constructor <init>(JIJIJ[J)V
    .locals 3
    .param p1, "dataStartPosition"    # J
    .param p3, "xingFrameSize"    # I
    .param p4, "durationUs"    # J
    .param p6, "bitrate"    # I
    .param p7, "dataSize"    # J
    .param p9, "tableOfContents"    # [J

    .line 107
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 108
    iput-wide p1, p0, Landroidx/media3/extractor/mp3/XingSeeker;->dataStartPosition:J

    .line 109
    iput p3, p0, Landroidx/media3/extractor/mp3/XingSeeker;->xingFrameSize:I

    .line 110
    iput-wide p4, p0, Landroidx/media3/extractor/mp3/XingSeeker;->durationUs:J

    .line 111
    iput p6, p0, Landroidx/media3/extractor/mp3/XingSeeker;->bitrate:I

    .line 112
    iput-wide p7, p0, Landroidx/media3/extractor/mp3/XingSeeker;->dataSize:J

    .line 113
    iput-object p9, p0, Landroidx/media3/extractor/mp3/XingSeeker;->tableOfContents:[J

    .line 114
    const-wide/16 v0, -0x1

    cmp-long v2, p7, v0

    if-nez v2, :cond_0

    goto :goto_0

    :cond_0
    add-long v0, p1, p7

    :goto_0
    iput-wide v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->dataEndPosition:J

    .line 115
    return-void
.end method

.method public static create(JLandroidx/media3/extractor/mp3/XingFrame;J)Landroidx/media3/extractor/mp3/XingSeeker;
    .locals 16
    .param p0, "inputLength"    # J
    .param p2, "xingFrame"    # Landroidx/media3/extractor/mp3/XingFrame;
    .param p3, "position"    # J

    .line 45
    move-wide/from16 v0, p0

    move-object/from16 v2, p2

    iget-wide v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->frameCount:J

    const-wide/16 v5, -0x1

    cmp-long v3, v3, v5

    if-nez v3, :cond_0

    iget-wide v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->frameCount:J

    const-wide/16 v7, 0x0

    cmp-long v3, v3, v7

    if-nez v3, :cond_0

    .line 47
    const/4 v3, 0x0

    return-object v3

    .line 52
    :cond_0
    iget-wide v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->frameCount:J

    iget-object v7, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v7, v7, Landroidx/media3/extractor/MpegAudioUtil$Header;->samplesPerFrame:I

    int-to-long v7, v7

    mul-long/2addr v3, v7

    const-wide/16 v7, 0x1

    sub-long/2addr v3, v7

    iget-object v7, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v7, v7, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    .line 53
    invoke-static {v3, v4, v7}, Landroidx/media3/common/util/Util;->sampleCountToDurationUs(JI)J

    move-result-wide v13

    .line 56
    .local v13, "durationUs":J
    iget-wide v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_3

    iget-object v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->tableOfContents:[J

    if-nez v3, :cond_1

    goto :goto_0

    .line 62
    :cond_1
    cmp-long v3, v0, v5

    if-eqz v3, :cond_2

    iget-wide v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    add-long v3, p3, v3

    cmp-long v3, v0, v3

    if-eqz v3, :cond_2

    .line 63
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "XING data size mismatch: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-wide v4, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    add-long v4, p3, v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "XingSeeker"

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    :cond_2
    new-instance v15, Landroidx/media3/extractor/mp3/XingSeeker;

    iget-object v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v6, v3, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    iget-object v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v9, v3, Landroidx/media3/extractor/MpegAudioUtil$Header;->bitrate:I

    iget-wide v10, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    iget-object v12, v2, Landroidx/media3/extractor/mp3/XingFrame;->tableOfContents:[J

    move-object v3, v15

    move-wide/from16 v4, p3

    move-wide v7, v13

    invoke-direct/range {v3 .. v12}, Landroidx/media3/extractor/mp3/XingSeeker;-><init>(JIJIJ[J)V

    return-object v15

    .line 58
    :cond_3
    :goto_0
    new-instance v10, Landroidx/media3/extractor/mp3/XingSeeker;

    iget-object v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v6, v3, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    iget-object v3, v2, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v9, v3, Landroidx/media3/extractor/MpegAudioUtil$Header;->bitrate:I

    move-object v3, v10

    move-wide/from16 v4, p3

    move-wide v7, v13

    invoke-direct/range {v3 .. v9}, Landroidx/media3/extractor/mp3/XingSeeker;-><init>(JIJI)V

    return-object v10
.end method

.method private getTimeUsForTableIndex(I)J
    .locals 4
    .param p1, "tableIndex"    # I

    .line 193
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->durationUs:J

    int-to-long v2, p1

    mul-long/2addr v0, v2

    const-wide/16 v2, 0x64

    div-long/2addr v0, v2

    return-wide v0
.end method


# virtual methods
.method public getAverageBitrate()I
    .locals 1

    .line 183
    iget v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->bitrate:I

    return v0
.end method

.method public getDataEndPosition()J
    .locals 2

    .line 178
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->dataEndPosition:J

    return-wide v0
.end method

.method public getDurationUs()J
    .locals 2

    .line 173
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->durationUs:J

    return-wide v0
.end method

.method public getSeekPoints(J)Landroidx/media3/extractor/SeekMap$SeekPoints;
    .locals 18
    .param p1, "timeUs"    # J

    .line 124
    move-object/from16 v0, p0

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/extractor/mp3/XingSeeker;->isSeekable()Z

    move-result v1

    if-nez v1, :cond_0

    .line 125
    new-instance v1, Landroidx/media3/extractor/SeekMap$SeekPoints;

    new-instance v2, Landroidx/media3/extractor/SeekPoint;

    iget-wide v3, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataStartPosition:J

    iget v5, v0, Landroidx/media3/extractor/mp3/XingSeeker;->xingFrameSize:I

    int-to-long v5, v5

    add-long/2addr v3, v5

    const-wide/16 v5, 0x0

    invoke-direct {v2, v5, v6, v3, v4}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    invoke-direct {v1, v2}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;)V

    return-object v1

    .line 127
    :cond_0
    const-wide/16 v9, 0x0

    iget-wide v11, v0, Landroidx/media3/extractor/mp3/XingSeeker;->durationUs:J

    move-wide/from16 v7, p1

    invoke-static/range {v7 .. v12}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v1

    .line 128
    .end local p1    # "timeUs":J
    .local v1, "timeUs":J
    long-to-double v3, v1

    const-wide/high16 v5, 0x4059000000000000L    # 100.0

    mul-double/2addr v3, v5

    iget-wide v7, v0, Landroidx/media3/extractor/mp3/XingSeeker;->durationUs:J

    long-to-double v7, v7

    div-double/2addr v3, v7

    .line 130
    .local v3, "percent":D
    const-wide/16 v7, 0x0

    cmpg-double v7, v3, v7

    const-wide/high16 v8, 0x4070000000000000L    # 256.0

    if-gtz v7, :cond_1

    .line 131
    const-wide/16 v5, 0x0

    .local v5, "scaledPosition":D
    goto :goto_1

    .line 132
    .end local v5    # "scaledPosition":D
    :cond_1
    cmpl-double v5, v3, v5

    if-ltz v5, :cond_2

    .line 133
    const-wide/high16 v5, 0x4070000000000000L    # 256.0

    .restart local v5    # "scaledPosition":D
    goto :goto_1

    .line 135
    .end local v5    # "scaledPosition":D
    :cond_2
    double-to-int v5, v3

    .line 136
    .local v5, "prevTableIndex":I
    iget-object v6, v0, Landroidx/media3/extractor/mp3/XingSeeker;->tableOfContents:[J

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [J

    .line 137
    .local v6, "tableOfContents":[J
    aget-wide v10, v6, v5

    long-to-double v10, v10

    .line 138
    .local v10, "prevScaledPosition":D
    const/16 v7, 0x63

    if-ne v5, v7, :cond_3

    move-wide v12, v8

    goto :goto_0

    :cond_3
    add-int/lit8 v7, v5, 0x1

    aget-wide v12, v6, v7

    long-to-double v12, v12

    .line 140
    .local v12, "nextScaledPosition":D
    :goto_0
    int-to-double v14, v5

    sub-double v14, v3, v14

    .line 141
    .local v14, "interpolateFraction":D
    sub-double v16, v12, v10

    mul-double v16, v16, v14

    add-double v16, v10, v16

    move-wide/from16 v5, v16

    .line 144
    .end local v6    # "tableOfContents":[J
    .end local v10    # "prevScaledPosition":D
    .end local v12    # "nextScaledPosition":D
    .end local v14    # "interpolateFraction":D
    .local v5, "scaledPosition":D
    :goto_1
    div-double v7, v5, v8

    iget-wide v9, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataSize:J

    long-to-double v9, v9

    mul-double/2addr v7, v9

    invoke-static {v7, v8}, Ljava/lang/Math;->round(D)J

    move-result-wide v7

    .line 146
    .local v7, "positionOffset":J
    iget v9, v0, Landroidx/media3/extractor/mp3/XingSeeker;->xingFrameSize:I

    int-to-long v11, v9

    iget-wide v9, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataSize:J

    const-wide/16 v13, 0x1

    sub-long v13, v9, v13

    move-wide v9, v7

    invoke-static/range {v9 .. v14}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v7

    .line 147
    new-instance v9, Landroidx/media3/extractor/SeekMap$SeekPoints;

    new-instance v10, Landroidx/media3/extractor/SeekPoint;

    iget-wide v11, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataStartPosition:J

    add-long/2addr v11, v7

    invoke-direct {v10, v1, v2, v11, v12}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    invoke-direct {v9, v10}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;)V

    return-object v9
.end method

.method public getTimeUs(J)J
    .locals 20
    .param p1, "position"    # J

    .line 152
    move-object/from16 v0, p0

    iget-wide v1, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataStartPosition:J

    sub-long v1, p1, v1

    .line 153
    .local v1, "positionOffset":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/extractor/mp3/XingSeeker;->isSeekable()Z

    move-result v3

    if-eqz v3, :cond_3

    iget v3, v0, Landroidx/media3/extractor/mp3/XingSeeker;->xingFrameSize:I

    int-to-long v3, v3

    cmp-long v3, v1, v3

    if-gtz v3, :cond_0

    move-wide v15, v1

    goto :goto_2

    .line 156
    :cond_0
    iget-object v3, v0, Landroidx/media3/extractor/mp3/XingSeeker;->tableOfContents:[J

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [J

    .line 157
    .local v3, "tableOfContents":[J
    long-to-double v4, v1

    const-wide/high16 v6, 0x4070000000000000L    # 256.0

    mul-double/2addr v4, v6

    iget-wide v6, v0, Landroidx/media3/extractor/mp3/XingSeeker;->dataSize:J

    long-to-double v6, v6

    div-double/2addr v4, v6

    .line 158
    .local v4, "scaledPosition":D
    double-to-long v6, v4

    const/4 v8, 0x1

    invoke-static {v3, v6, v7, v8, v8}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v6

    .line 159
    .local v6, "prevTableIndex":I
    invoke-direct {v0, v6}, Landroidx/media3/extractor/mp3/XingSeeker;->getTimeUsForTableIndex(I)J

    move-result-wide v7

    .line 160
    .local v7, "prevTimeUs":J
    aget-wide v9, v3, v6

    .line 161
    .local v9, "prevScaledPosition":J
    add-int/lit8 v11, v6, 0x1

    invoke-direct {v0, v11}, Landroidx/media3/extractor/mp3/XingSeeker;->getTimeUsForTableIndex(I)J

    move-result-wide v11

    .line 162
    .local v11, "nextTimeUs":J
    const/16 v13, 0x63

    if-ne v6, v13, :cond_1

    const-wide/16 v13, 0x100

    goto :goto_0

    :cond_1
    add-int/lit8 v13, v6, 0x1

    aget-wide v13, v3, v13

    .line 165
    .local v13, "nextScaledPosition":J
    :goto_0
    cmp-long v15, v9, v13

    if-nez v15, :cond_2

    .line 166
    const-wide/16 v15, 0x0

    move-object/from16 v17, v3

    move-wide/from16 v18, v1

    move-wide v0, v15

    move-wide/from16 v15, v18

    goto :goto_1

    .line 167
    :cond_2
    move-wide v15, v1

    .end local v1    # "positionOffset":J
    .local v15, "positionOffset":J
    long-to-double v0, v9

    sub-double v0, v4, v0

    move-object/from16 v17, v3

    .end local v3    # "tableOfContents":[J
    .local v17, "tableOfContents":[J
    sub-long v2, v13, v9

    long-to-double v2, v2

    div-double/2addr v0, v2

    :goto_1
    nop

    .line 168
    .local v0, "interpolateFraction":D
    sub-long v2, v11, v7

    long-to-double v2, v2

    mul-double/2addr v2, v0

    invoke-static {v2, v3}, Ljava/lang/Math;->round(D)J

    move-result-wide v2

    add-long/2addr v2, v7

    return-wide v2

    .line 153
    .end local v0    # "interpolateFraction":D
    .end local v4    # "scaledPosition":D
    .end local v6    # "prevTableIndex":I
    .end local v7    # "prevTimeUs":J
    .end local v9    # "prevScaledPosition":J
    .end local v11    # "nextTimeUs":J
    .end local v13    # "nextScaledPosition":J
    .end local v15    # "positionOffset":J
    .end local v17    # "tableOfContents":[J
    .restart local v1    # "positionOffset":J
    :cond_3
    move-wide v15, v1

    .line 154
    .end local v1    # "positionOffset":J
    .restart local v15    # "positionOffset":J
    :goto_2
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public isSeekable()Z
    .locals 1

    .line 119
    iget-object v0, p0, Landroidx/media3/extractor/mp3/XingSeeker;->tableOfContents:[J

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
