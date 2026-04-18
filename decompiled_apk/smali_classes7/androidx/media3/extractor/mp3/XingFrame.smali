.class final Landroidx/media3/extractor/mp3/XingFrame;
.super Ljava/lang/Object;
.source "XingFrame.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "XingHeader"


# instance fields
.field public final dataSize:J

.field public final encoderDelay:I

.field public final encoderPadding:I

.field public final frameCount:J

.field public final header:Landroidx/media3/extractor/MpegAudioUtil$Header;

.field public final tableOfContents:[J


# direct methods
.method private constructor <init>(Landroidx/media3/extractor/MpegAudioUtil$Header;JJ[JII)V
    .locals 0
    .param p1, "header"    # Landroidx/media3/extractor/MpegAudioUtil$Header;
    .param p2, "frameCount"    # J
    .param p4, "dataSize"    # J
    .param p6, "tableOfContents"    # [J
    .param p7, "encoderDelay"    # I
    .param p8, "encoderPadding"    # I

    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    iput-object p1, p0, Landroidx/media3/extractor/mp3/XingFrame;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    .line 65
    iput-wide p2, p0, Landroidx/media3/extractor/mp3/XingFrame;->frameCount:J

    .line 66
    iput-wide p4, p0, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    .line 67
    iput-object p6, p0, Landroidx/media3/extractor/mp3/XingFrame;->tableOfContents:[J

    .line 68
    iput p7, p0, Landroidx/media3/extractor/mp3/XingFrame;->encoderDelay:I

    .line 69
    iput p8, p0, Landroidx/media3/extractor/mp3/XingFrame;->encoderPadding:I

    .line 70
    return-void
.end method

.method public static parse(Landroidx/media3/extractor/MpegAudioUtil$Header;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp3/XingFrame;
    .locals 20
    .param p0, "mpegAudioHeader"    # Landroidx/media3/extractor/MpegAudioUtil$Header;
    .param p1, "frame"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 84
    move-object/from16 v9, p0

    move-object/from16 v10, p1

    iget v11, v9, Landroidx/media3/extractor/MpegAudioUtil$Header;->samplesPerFrame:I

    .line 85
    .local v11, "samplesPerFrame":I
    iget v12, v9, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    .line 87
    .local v12, "sampleRate":I
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v13

    .line 88
    .local v13, "flags":I
    and-int/lit8 v0, v13, 0x1

    if-eqz v0, :cond_0

    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    goto :goto_0

    :cond_0
    const/4 v0, -0x1

    :goto_0
    move v14, v0

    .line 89
    .local v14, "frameCount":I
    and-int/lit8 v0, v13, 0x2

    if-eqz v0, :cond_1

    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v0

    goto :goto_1

    :cond_1
    const-wide/16 v0, -0x1

    :goto_1
    move-wide v4, v0

    .line 92
    .local v4, "dataSize":J
    and-int/lit8 v0, v13, 0x4

    const/4 v1, 0x4

    if-ne v0, v1, :cond_3

    .line 93
    const/16 v0, 0x64

    new-array v2, v0, [J

    .line 94
    .local v2, "tableOfContents":[J
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_2
    if-ge v3, v0, :cond_2

    .line 95
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v6

    int-to-long v6, v6

    aput-wide v6, v2, v3

    .line 94
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    :cond_2
    move-object v15, v2

    .end local v3    # "i":I
    goto :goto_3

    .line 98
    .end local v2    # "tableOfContents":[J
    :cond_3
    const/4 v2, 0x0

    move-object v15, v2

    .line 101
    .local v15, "tableOfContents":[J
    :goto_3
    and-int/lit8 v0, v13, 0x8

    if-eqz v0, :cond_4

    .line 102
    invoke-virtual {v10, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 109
    :cond_4
    const/16 v8, 0x15

    .line 110
    .local v8, "bytesToSkipBeforeEncoderDelayAndPadding":I
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    add-int/lit8 v1, v8, 0x3

    if-lt v0, v1, :cond_5

    .line 111
    invoke-virtual {v10, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 112
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v0

    .line 113
    .local v0, "encoderDelayAndPadding":I
    const v1, 0xfff000

    and-int/2addr v1, v0

    shr-int/lit8 v1, v1, 0xc

    .line 114
    .local v1, "encoderDelay":I
    and-int/lit16 v0, v0, 0xfff

    .line 115
    .local v0, "encoderPadding":I
    move/from16 v16, v0

    move/from16 v17, v1

    goto :goto_4

    .line 116
    .end local v0    # "encoderPadding":I
    .end local v1    # "encoderDelay":I
    :cond_5
    const/4 v1, -0x1

    .line 117
    .restart local v1    # "encoderDelay":I
    const/4 v0, -0x1

    move/from16 v16, v0

    move/from16 v17, v1

    .line 120
    .end local v1    # "encoderDelay":I
    .local v16, "encoderPadding":I
    .local v17, "encoderDelay":I
    :goto_4
    new-instance v18, Landroidx/media3/extractor/mp3/XingFrame;

    int-to-long v2, v14

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    move-object v6, v15

    move/from16 v7, v17

    move/from16 v19, v8

    .end local v8    # "bytesToSkipBeforeEncoderDelayAndPadding":I
    .local v19, "bytesToSkipBeforeEncoderDelayAndPadding":I
    move/from16 v8, v16

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp3/XingFrame;-><init>(Landroidx/media3/extractor/MpegAudioUtil$Header;JJ[JII)V

    return-object v18
.end method
