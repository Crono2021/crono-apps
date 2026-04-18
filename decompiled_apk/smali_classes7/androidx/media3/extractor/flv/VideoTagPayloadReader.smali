.class final Landroidx/media3/extractor/flv/VideoTagPayloadReader;
.super Landroidx/media3/extractor/flv/TagPayloadReader;
.source "VideoTagPayloadReader.java"


# static fields
.field private static final AVC_PACKET_TYPE_AVC_NALU:I = 0x1

.field private static final AVC_PACKET_TYPE_SEQUENCE_HEADER:I = 0x0

.field private static final VIDEO_CODEC_AVC:I = 0x7

.field private static final VIDEO_FRAME_KEYFRAME:I = 0x1

.field private static final VIDEO_FRAME_VIDEO_INFO:I = 0x5


# instance fields
.field private frameType:I

.field private hasOutputFormat:Z

.field private hasOutputKeyframe:Z

.field private final nalLength:Landroidx/media3/common/util/ParsableByteArray;

.field private final nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

.field private nalUnitLengthFieldLength:I


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/TrackOutput;)V
    .locals 2
    .param p1, "output"    # Landroidx/media3/extractor/TrackOutput;

    .line 55
    invoke-direct {p0, p1}, Landroidx/media3/extractor/flv/TagPayloadReader;-><init>(Landroidx/media3/extractor/TrackOutput;)V

    .line 56
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    sget-object v1, Landroidx/media3/container/NalUnitUtil;->NAL_START_CODE:[B

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    iput-object v0, p0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    .line 57
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x4

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalLength:Landroidx/media3/common/util/ParsableByteArray;

    .line 58
    return-void
.end method


# virtual methods
.method protected parseHeader(Landroidx/media3/common/util/ParsableByteArray;)Z
    .locals 6
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/extractor/flv/TagPayloadReader$UnsupportedFormatException;
        }
    .end annotation

    .line 67
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 68
    .local v0, "header":I
    shr-int/lit8 v1, v0, 0x4

    and-int/lit8 v1, v1, 0xf

    .line 69
    .local v1, "frameType":I
    and-int/lit8 v2, v0, 0xf

    .line 71
    .local v2, "videoCodec":I
    const/4 v3, 0x7

    if-ne v2, v3, :cond_1

    .line 74
    iput v1, p0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->frameType:I

    .line 75
    const/4 v3, 0x5

    if-eq v1, v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    :goto_0
    return v3

    .line 72
    :cond_1
    new-instance v3, Landroidx/media3/extractor/flv/TagPayloadReader$UnsupportedFormatException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Video format not supported: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Landroidx/media3/extractor/flv/TagPayloadReader$UnsupportedFormatException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method protected parsePayload(Landroidx/media3/common/util/ParsableByteArray;J)Z
    .locals 19
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "timeUs"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 80
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v2

    .line 81
    .local v2, "packetType":I
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt24()I

    move-result v3

    .line 83
    .local v3, "compositionTimeMs":I
    int-to-long v4, v3

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    add-long v4, p2, v4

    .line 85
    .end local p2    # "timeUs":J
    .local v4, "timeUs":J
    const/4 v13, 0x1

    const/4 v6, 0x0

    if-nez v2, :cond_0

    iget-boolean v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputFormat:Z

    if-nez v7, :cond_0

    .line 86
    new-instance v7, Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v8

    new-array v8, v8, [B

    invoke-direct {v7, v8}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    .line 87
    .local v7, "videoSequence":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v8

    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v9

    invoke-virtual {v1, v8, v6, v9}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 88
    invoke-static {v7}, Landroidx/media3/extractor/AvcConfig;->parse(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/AvcConfig;

    move-result-object v8

    .line 89
    .local v8, "avcConfig":Landroidx/media3/extractor/AvcConfig;
    iget v9, v8, Landroidx/media3/extractor/AvcConfig;->nalUnitLengthFieldLength:I

    iput v9, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalUnitLengthFieldLength:I

    .line 91
    new-instance v9, Landroidx/media3/common/Format$Builder;

    invoke-direct {v9}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 93
    const-string/jumbo v10, "video/avc"

    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    iget-object v10, v8, Landroidx/media3/extractor/AvcConfig;->codecs:Ljava/lang/String;

    .line 94
    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    iget v10, v8, Landroidx/media3/extractor/AvcConfig;->width:I

    .line 95
    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setWidth(I)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    iget v10, v8, Landroidx/media3/extractor/AvcConfig;->height:I

    .line 96
    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setHeight(I)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    iget v10, v8, Landroidx/media3/extractor/AvcConfig;->pixelWidthHeightRatio:F

    .line 97
    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setPixelWidthHeightRatio(F)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    iget-object v10, v8, Landroidx/media3/extractor/AvcConfig;->initializationData:Ljava/util/List;

    .line 98
    invoke-virtual {v9, v10}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    .line 99
    invoke-virtual {v9}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v9

    .line 100
    .local v9, "format":Landroidx/media3/common/Format;
    iget-object v10, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v10, v9}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 101
    iput-boolean v13, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputFormat:Z

    .line 102
    return v6

    .line 103
    .end local v7    # "videoSequence":Landroidx/media3/common/util/ParsableByteArray;
    .end local v8    # "avcConfig":Landroidx/media3/extractor/AvcConfig;
    .end local v9    # "format":Landroidx/media3/common/Format;
    :cond_0
    if-ne v2, v13, :cond_5

    iget-boolean v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputFormat:Z

    if-eqz v7, :cond_5

    .line 104
    iget v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->frameType:I

    if-ne v7, v13, :cond_1

    move v7, v13

    goto :goto_0

    :cond_1
    move v7, v6

    :goto_0
    move v14, v7

    .line 105
    .local v14, "isKeyframe":Z
    iget-boolean v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputKeyframe:Z

    if-nez v7, :cond_2

    if-nez v14, :cond_2

    .line 106
    return v6

    .line 111
    :cond_2
    iget-object v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalLength:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v15

    .line 112
    .local v15, "nalLengthData":[B
    aput-byte v6, v15, v6

    .line 113
    aput-byte v6, v15, v13

    .line 114
    const/4 v7, 0x2

    aput-byte v6, v15, v7

    .line 115
    iget v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalUnitLengthFieldLength:I

    const/4 v8, 0x4

    rsub-int/lit8 v12, v7, 0x4

    .line 119
    .local v12, "nalUnitLengthFieldLengthDiff":I
    const/4 v7, 0x0

    move/from16 v16, v7

    .line 121
    .local v16, "bytesWritten":I
    :goto_1
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v7

    if-lez v7, :cond_3

    .line 123
    iget-object v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalLength:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    iget v9, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalUnitLengthFieldLength:I

    invoke-virtual {v1, v7, v12, v9}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 124
    iget-object v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalLength:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 125
    iget-object v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalLength:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v7

    .line 128
    .local v7, "bytesToWrite":I
    iget-object v9, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v9, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 129
    iget-object v9, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-object v10, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v9, v10, v8}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 130
    add-int/lit8 v16, v16, 0x4

    .line 133
    iget-object v9, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v9, v1, v7}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 134
    add-int v16, v16, v7

    goto :goto_1

    .line 136
    .end local v7    # "bytesToWrite":I
    :cond_3
    iget-object v7, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 137
    if-eqz v14, :cond_4

    move v9, v13

    goto :goto_2

    :cond_4
    move v9, v6

    :goto_2
    const/4 v11, 0x0

    const/16 v17, 0x0

    .line 136
    move-object v6, v7

    move-wide v7, v4

    move/from16 v10, v16

    move/from16 v18, v12

    .end local v12    # "nalUnitLengthFieldLengthDiff":I
    .local v18, "nalUnitLengthFieldLengthDiff":I
    move-object/from16 v12, v17

    invoke-interface/range {v6 .. v12}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 138
    iput-boolean v13, v0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputKeyframe:Z

    .line 139
    return v13

    .line 141
    .end local v14    # "isKeyframe":Z
    .end local v15    # "nalLengthData":[B
    .end local v16    # "bytesWritten":I
    .end local v18    # "nalUnitLengthFieldLengthDiff":I
    :cond_5
    return v6
.end method

.method public seek()V
    .locals 1

    .line 62
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/flv/VideoTagPayloadReader;->hasOutputKeyframe:Z

    .line 63
    return-void
.end method
