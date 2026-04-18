.class final Landroidx/media3/extractor/mp3/VbriSeeker;
.super Ljava/lang/Object;
.source "VbriSeeker.java"

# interfaces
.implements Landroidx/media3/extractor/mp3/Seeker;


# static fields
.field private static final TAG:Ljava/lang/String; = "VbriSeeker"


# instance fields
.field private final bitrate:I

.field private final dataEndPosition:J

.field private final durationUs:J

.field private final positions:[J

.field private final timesUs:[J


# direct methods
.method private constructor <init>([J[JJJI)V
    .locals 0
    .param p1, "timesUs"    # [J
    .param p2, "positions"    # [J
    .param p3, "durationUs"    # J
    .param p5, "dataEndPosition"    # J
    .param p7, "bitrate"    # I

    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    iput-object p1, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    .line 110
    iput-object p2, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->positions:[J

    .line 111
    iput-wide p3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->durationUs:J

    .line 112
    iput-wide p5, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->dataEndPosition:J

    .line 113
    iput p7, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->bitrate:I

    .line 114
    return-void
.end method

.method public static create(JJLandroidx/media3/extractor/MpegAudioUtil$Header;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp3/VbriSeeker;
    .locals 26
    .param p0, "inputLength"    # J
    .param p2, "position"    # J
    .param p4, "mpegAudioHeader"    # Landroidx/media3/extractor/MpegAudioUtil$Header;
    .param p5, "frame"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 52
    move-wide/from16 v0, p0

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 53
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 54
    .local v4, "numFrames":I
    const/4 v5, 0x0

    if-gtz v4, :cond_0

    .line 55
    return-object v5

    .line 57
    :cond_0
    iget v6, v2, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    .line 58
    .local v6, "sampleRate":I
    int-to-long v7, v4

    .line 60
    const/16 v9, 0x7d00

    if-lt v6, v9, :cond_1

    const/16 v9, 0x480

    goto :goto_0

    :cond_1
    const/16 v9, 0x240

    :goto_0
    int-to-long v9, v9

    const-wide/32 v11, 0xf4240

    mul-long/2addr v9, v11

    int-to-long v11, v6

    .line 59
    invoke-static/range {v7 .. v12}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v7

    .line 61
    .local v7, "durationUs":J
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v9

    .line 62
    .local v9, "entryCount":I
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v10

    .line 63
    .local v10, "scale":I
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v11

    .line 64
    .local v11, "entrySize":I
    const/4 v12, 0x2

    invoke-virtual {v3, v12}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 66
    iget v12, v2, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    int-to-long v12, v12

    add-long v14, p2, v12

    .line 68
    .local v14, "minPosition":J
    new-array v12, v9, [J

    .line 69
    .local v12, "timesUs":[J
    new-array v13, v9, [J

    .line 70
    .local v13, "positions":[J
    const/16 v16, 0x0

    move/from16 v21, v6

    move/from16 v3, v16

    move-wide/from16 v5, p2

    .end local v6    # "sampleRate":I
    .end local p2    # "position":J
    .local v3, "index":I
    .local v5, "position":J
    .local v21, "sampleRate":I
    :goto_1
    if-ge v3, v9, :cond_2

    .line 71
    int-to-long v0, v3

    mul-long/2addr v0, v7

    move-wide/from16 v22, v7

    .end local v7    # "durationUs":J
    .local v22, "durationUs":J
    int-to-long v7, v9

    div-long/2addr v0, v7

    aput-wide v0, v12, v3

    .line 74
    invoke-static {v5, v6, v14, v15}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    aput-wide v0, v13, v3

    .line 76
    packed-switch v11, :pswitch_data_0

    .line 90
    const/4 v0, 0x0

    return-object v0

    .line 87
    :pswitch_0
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    .line 88
    .local v0, "segmentSize":I
    goto :goto_2

    .line 84
    .end local v0    # "segmentSize":I
    :pswitch_1
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v0

    .line 85
    .restart local v0    # "segmentSize":I
    goto :goto_2

    .line 81
    .end local v0    # "segmentSize":I
    :pswitch_2
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    .line 82
    .restart local v0    # "segmentSize":I
    goto :goto_2

    .line 78
    .end local v0    # "segmentSize":I
    :pswitch_3
    invoke-virtual/range {p5 .. p5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 79
    .restart local v0    # "segmentSize":I
    nop

    .line 92
    :goto_2
    int-to-long v7, v0

    move/from16 v16, v0

    .end local v0    # "segmentSize":I
    .local v16, "segmentSize":I
    int-to-long v0, v10

    mul-long/2addr v7, v0

    add-long/2addr v5, v7

    .line 70
    .end local v16    # "segmentSize":I
    add-int/lit8 v3, v3, 0x1

    move-wide/from16 v0, p0

    move-wide/from16 v7, v22

    goto :goto_1

    .end local v22    # "durationUs":J
    .restart local v7    # "durationUs":J
    :cond_2
    move-wide/from16 v22, v7

    .line 94
    .end local v3    # "index":I
    .end local v7    # "durationUs":J
    .restart local v22    # "durationUs":J
    const-wide/16 v0, -0x1

    move-wide/from16 v7, p0

    cmp-long v0, v7, v0

    if-eqz v0, :cond_3

    cmp-long v0, v7, v5

    if-eqz v0, :cond_3

    .line 95
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "VBRI data size mismatch: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "VbriSeeker"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 97
    :cond_3
    new-instance v0, Landroidx/media3/extractor/mp3/VbriSeeker;

    iget v1, v2, Landroidx/media3/extractor/MpegAudioUtil$Header;->bitrate:I

    move-object v3, v13

    .end local v13    # "positions":[J
    .local v3, "positions":[J
    move-object v13, v0

    move-wide/from16 v24, v14

    .end local v14    # "minPosition":J
    .local v24, "minPosition":J
    move-object v14, v12

    move-object v15, v3

    move-wide/from16 v16, v22

    move-wide/from16 v18, v5

    move/from16 v20, v1

    invoke-direct/range {v13 .. v20}, Landroidx/media3/extractor/mp3/VbriSeeker;-><init>([J[JJJI)V

    return-object v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public getAverageBitrate()I
    .locals 1

    .line 150
    iget v0, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->bitrate:I

    return v0
.end method

.method public getDataEndPosition()J
    .locals 2

    .line 145
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->dataEndPosition:J

    return-wide v0
.end method

.method public getDurationUs()J
    .locals 2

    .line 140
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->durationUs:J

    return-wide v0
.end method

.method public getSeekPoints(J)Landroidx/media3/extractor/SeekMap$SeekPoints;
    .locals 8
    .param p1, "timeUs"    # J

    .line 123
    iget-object v0, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v0

    .line 124
    .local v0, "tableIndex":I
    new-instance v2, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    aget-wide v4, v3, v0

    iget-object v3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->positions:[J

    aget-wide v6, v3, v0

    invoke-direct {v2, v4, v5, v6, v7}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 125
    .local v2, "seekPoint":Landroidx/media3/extractor/SeekPoint;
    iget-wide v3, v2, Landroidx/media3/extractor/SeekPoint;->timeUs:J

    cmp-long v3, v3, p1

    if-gez v3, :cond_1

    iget-object v3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    array-length v3, v3

    sub-int/2addr v3, v1

    if-ne v0, v3, :cond_0

    goto :goto_0

    .line 128
    :cond_0
    new-instance v1, Landroidx/media3/extractor/SeekPoint;

    iget-object v3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    add-int/lit8 v4, v0, 0x1

    aget-wide v4, v3, v4

    iget-object v3, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->positions:[J

    add-int/lit8 v6, v0, 0x1

    aget-wide v6, v3, v6

    invoke-direct {v1, v4, v5, v6, v7}, Landroidx/media3/extractor/SeekPoint;-><init>(JJ)V

    .line 129
    .local v1, "nextSeekPoint":Landroidx/media3/extractor/SeekPoint;
    new-instance v3, Landroidx/media3/extractor/SeekMap$SeekPoints;

    invoke-direct {v3, v2, v1}, Landroidx/media3/extractor/SeekMap$SeekPoints;-><init>(Landroidx/media3/extractor/SeekPoint;Landroidx/media3/extractor/SeekPoint;)V

    return-object v3

    .line 126
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

    .line 135
    iget-object v0, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->timesUs:[J

    iget-object v1, p0, Landroidx/media3/extractor/mp3/VbriSeeker;->positions:[J

    const/4 v2, 0x1

    invoke-static {v1, p1, p2, v2, v2}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v1

    aget-wide v1, v0, v1

    return-wide v1
.end method

.method public isSeekable()Z
    .locals 1

    .line 118
    const/4 v0, 0x1

    return v0
.end method
