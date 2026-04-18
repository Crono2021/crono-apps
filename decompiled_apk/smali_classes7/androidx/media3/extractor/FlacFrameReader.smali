.class public final Landroidx/media3/extractor/FlacFrameReader;
.super Ljava/lang/Object;
.source "FlacFrameReader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 336
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static checkAndReadBlockSizeSamples(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;I)Z
    .locals 2
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "blockSizeKey"    # I

    .line 280
    invoke-static {p0, p2}, Landroidx/media3/extractor/FlacFrameReader;->readFrameBlockSizeSamplesFromKey(Landroidx/media3/common/util/ParsableByteArray;I)I

    move-result v0

    .line 281
    .local v0, "blockSizeSamples":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget v1, p1, Landroidx/media3/extractor/FlacStreamMetadata;->maxBlockSizeSamples:I

    if-gt v0, v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method private static checkAndReadCrc(Landroidx/media3/common/util/ParsableByteArray;I)Z
    .locals 5
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "frameStartPosition"    # I

    .line 329
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 330
    .local v0, "crc":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v1

    .line 331
    .local v1, "frameEndPosition":I
    nop

    .line 332
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    add-int/lit8 v3, v1, -0x1

    const/4 v4, 0x0

    invoke-static {v2, p1, v3, v4}, Landroidx/media3/common/util/Util;->crc8([BIII)I

    move-result v2

    .line 333
    .local v2, "expectedCrc":I
    if-ne v0, v2, :cond_0

    const/4 v4, 0x1

    :cond_0
    return v4
.end method

.method private static checkAndReadFirstSampleNumber(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;ZLandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z
    .locals 4
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "isBlockSizeVariable"    # Z
    .param p3, "sampleNumberHolder"    # Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;

    .line 255
    :try_start_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUtf8EncodedLong()J

    move-result-wide v0
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 258
    .local v0, "utf8Value":J
    nop

    .line 260
    nop

    .line 261
    if-eqz p2, :cond_0

    move-wide v2, v0

    goto :goto_0

    :cond_0
    iget v2, p1, Landroidx/media3/extractor/FlacStreamMetadata;->maxBlockSizeSamples:I

    int-to-long v2, v2

    mul-long/2addr v2, v0

    :goto_0
    iput-wide v2, p3, Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;->sampleNumber:J

    .line 262
    const/4 v2, 0x1

    return v2

    .line 256
    .end local v0    # "utf8Value":J
    :catch_0
    move-exception v0

    .line 257
    .local v0, "e":Ljava/lang/NumberFormatException;
    const/4 v1, 0x0

    return v1
.end method

.method public static checkAndReadFrameHeader(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;ILandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z
    .locals 17
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "frameStartMarker"    # I
    .param p3, "sampleNumberHolder"    # Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;

    .line 57
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v2

    .line 59
    .local v2, "frameStartPosition":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v3

    .line 60
    .local v3, "frameHeaderBytes":J
    const/16 v5, 0x10

    ushr-long v6, v3, v5

    move/from16 v8, p2

    int-to-long v9, v8

    cmp-long v6, v6, v9

    const/4 v7, 0x0

    if-eqz v6, :cond_0

    .line 61
    return v7

    .line 64
    :cond_0
    ushr-long v5, v3, v5

    const-wide/16 v9, 0x1

    and-long/2addr v5, v9

    cmp-long v5, v5, v9

    const/4 v6, 0x1

    if-nez v5, :cond_1

    move v5, v6

    goto :goto_0

    :cond_1
    move v5, v7

    .line 65
    .local v5, "isBlockSizeVariable":Z
    :goto_0
    const/16 v11, 0xc

    shr-long v11, v3, v11

    const-wide/16 v13, 0xf

    and-long/2addr v11, v13

    long-to-int v11, v11

    .line 66
    .local v11, "blockSizeKey":I
    const/16 v12, 0x8

    shr-long v15, v3, v12

    and-long v7, v15, v13

    long-to-int v7, v7

    .line 67
    .local v7, "sampleRateKey":I
    const/4 v8, 0x4

    shr-long v15, v3, v8

    and-long/2addr v13, v15

    long-to-int v8, v13

    .line 68
    .local v8, "channelAssignmentKey":I
    shr-long v13, v3, v6

    const-wide/16 v15, 0x7

    and-long/2addr v13, v15

    long-to-int v13, v13

    .line 69
    .local v13, "bitsPerSampleKey":I
    and-long v14, v3, v9

    cmp-long v9, v14, v9

    if-nez v9, :cond_2

    move v9, v6

    goto :goto_1

    :cond_2
    const/4 v9, 0x0

    .line 70
    .local v9, "reservedBit":Z
    :goto_1
    invoke-static {v8, v1}, Landroidx/media3/extractor/FlacFrameReader;->checkChannelAssignment(ILandroidx/media3/extractor/FlacStreamMetadata;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 71
    invoke-static {v13, v1}, Landroidx/media3/extractor/FlacFrameReader;->checkBitsPerSample(ILandroidx/media3/extractor/FlacStreamMetadata;)Z

    move-result v10

    if-eqz v10, :cond_3

    if-nez v9, :cond_3

    .line 73
    move-object/from16 v10, p3

    invoke-static {v0, v1, v5, v10}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadFirstSampleNumber(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;ZLandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z

    move-result v14

    if-eqz v14, :cond_5

    .line 75
    invoke-static {v0, v1, v11}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadBlockSizeSamples(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;I)Z

    move-result v14

    if-eqz v14, :cond_5

    .line 76
    invoke-static {v0, v1, v7}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadSampleRate(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;I)Z

    move-result v14

    if-eqz v14, :cond_5

    .line 77
    invoke-static {v0, v2}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadCrc(Landroidx/media3/common/util/ParsableByteArray;I)Z

    move-result v14

    if-eqz v14, :cond_5

    move v12, v6

    goto :goto_3

    .line 71
    :cond_3
    move-object/from16 v10, p3

    goto :goto_2

    .line 70
    :cond_4
    move-object/from16 v10, p3

    .line 77
    :cond_5
    :goto_2
    const/4 v12, 0x0

    .line 70
    :goto_3
    return v12
.end method

.method private static checkAndReadSampleRate(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;I)Z
    .locals 5
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "sampleRateKey"    # I

    .line 298
    iget v0, p1, Landroidx/media3/extractor/FlacStreamMetadata;->sampleRate:I

    .line 299
    .local v0, "expectedSampleRate":I
    const/4 v1, 0x1

    if-nez p2, :cond_0

    .line 300
    return v1

    .line 301
    :cond_0
    const/16 v2, 0xb

    const/4 v3, 0x0

    if-gt p2, v2, :cond_2

    .line 302
    iget v2, p1, Landroidx/media3/extractor/FlacStreamMetadata;->sampleRateLookupKey:I

    if-ne p2, v2, :cond_1

    goto :goto_0

    :cond_1
    move v1, v3

    :goto_0
    return v1

    .line 303
    :cond_2
    const/16 v2, 0xc

    if-ne p2, v2, :cond_4

    .line 304
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v2

    mul-int/lit16 v2, v2, 0x3e8

    if-ne v2, v0, :cond_3

    goto :goto_1

    :cond_3
    move v1, v3

    :goto_1
    return v1

    .line 305
    :cond_4
    const/16 v2, 0xe

    if-gt p2, v2, :cond_7

    .line 306
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v4

    .line 307
    .local v4, "sampleRate":I
    if-ne p2, v2, :cond_5

    .line 308
    mul-int/lit8 v4, v4, 0xa

    .line 310
    :cond_5
    if-ne v4, v0, :cond_6

    goto :goto_2

    :cond_6
    move v1, v3

    :goto_2
    return v1

    .line 312
    .end local v4    # "sampleRate":I
    :cond_7
    return v3
.end method

.method private static checkBitsPerSample(ILandroidx/media3/extractor/FlacStreamMetadata;)Z
    .locals 2
    .param p0, "bitsPerSampleKey"    # I
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;

    .line 227
    const/4 v0, 0x1

    if-nez p0, :cond_0

    .line 228
    return v0

    .line 230
    :cond_0
    iget v1, p1, Landroidx/media3/extractor/FlacStreamMetadata;->bitsPerSampleLookupKey:I

    if-ne p0, v1, :cond_1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static checkChannelAssignment(ILandroidx/media3/extractor/FlacStreamMetadata;)Z
    .locals 4
    .param p0, "channelAssignmentKey"    # I
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;

    .line 209
    const/4 v0, 0x7

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-gt p0, v0, :cond_1

    .line 210
    iget v0, p1, Landroidx/media3/extractor/FlacStreamMetadata;->channels:I

    sub-int/2addr v0, v2

    if-ne p0, v0, :cond_0

    move v1, v2

    :cond_0
    return v1

    .line 211
    :cond_1
    const/16 v0, 0xa

    if-gt p0, v0, :cond_3

    .line 212
    iget v0, p1, Landroidx/media3/extractor/FlacStreamMetadata;->channels:I

    const/4 v3, 0x2

    if-ne v0, v3, :cond_2

    move v1, v2

    :cond_2
    return v1

    .line 214
    :cond_3
    return v1
.end method

.method public static checkFrameHeaderFromPeek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/FlacStreamMetadata;ILandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z
    .locals 9
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "frameStartMarker"    # I
    .param p3, "sampleNumberHolder"    # Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 99
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v0

    .line 101
    .local v0, "originalPeekPosition":J
    const/4 v2, 0x2

    new-array v3, v2, [B

    .line 102
    .local v3, "frameStartBytes":[B
    const/4 v4, 0x0

    invoke-interface {p0, v3, v4, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 103
    aget-byte v5, v3, v4

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x8

    const/4 v6, 0x1

    aget-byte v6, v3, v6

    and-int/lit16 v6, v6, 0xff

    or-int/2addr v5, v6

    .line 104
    .local v5, "frameStart":I
    if-eq v5, p2, :cond_0

    .line 105
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 106
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v6

    sub-long v6, v0, v6

    long-to-int v2, v6

    invoke-interface {p0, v2}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 107
    return v4

    .line 110
    :cond_0
    new-instance v6, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v7, 0x10

    invoke-direct {v6, v7}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 111
    .local v6, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    nop

    .line 112
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    .line 111
    invoke-static {v3, v4, v7, v4, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 114
    nop

    .line 116
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    .line 115
    const/16 v7, 0xe

    invoke-static {p0, v4, v2, v7}, Landroidx/media3/extractor/ExtractorUtil;->peekToLength(Landroidx/media3/extractor/ExtractorInput;[BII)I

    move-result v2

    .line 117
    .local v2, "totalBytesPeeked":I
    invoke-virtual {v6, v2}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 119
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 120
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v7

    sub-long v7, v0, v7

    long-to-int v4, v7

    invoke-interface {p0, v4}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 122
    invoke-static {v6, p1, p2, p3}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadFrameHeader(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;ILandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z

    move-result v4

    return v4
.end method

.method public static getFirstSampleNumber(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/FlacStreamMetadata;)J
    .locals 8
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "flacStreamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 142
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 143
    const/4 v0, 0x1

    invoke-interface {p0, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 144
    new-array v1, v0, [B

    .line 145
    .local v1, "blockingStrategyByte":[B
    const/4 v2, 0x0

    invoke-interface {p0, v1, v2, v0}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 146
    aget-byte v3, v1, v2

    and-int/2addr v3, v0

    if-ne v3, v0, :cond_0

    goto :goto_0

    :cond_0
    move v0, v2

    .line 147
    .local v0, "isBlockSizeVariable":Z
    :goto_0
    const/4 v3, 0x2

    invoke-interface {p0, v3}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 149
    if-eqz v0, :cond_1

    const/4 v3, 0x7

    goto :goto_1

    :cond_1
    const/4 v3, 0x6

    .line 150
    .local v3, "maxUtf8SampleNumberSize":I
    :goto_1
    new-instance v4, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v4, v3}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 151
    .local v4, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    nop

    .line 152
    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v5

    invoke-static {p0, v5, v2, v3}, Landroidx/media3/extractor/ExtractorUtil;->peekToLength(Landroidx/media3/extractor/ExtractorInput;[BII)I

    move-result v2

    .line 153
    .local v2, "totalBytesPeeked":I
    invoke-virtual {v4, v2}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 154
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 156
    new-instance v5, Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;

    invoke-direct {v5}, Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;-><init>()V

    .line 157
    .local v5, "sampleNumberHolder":Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;
    invoke-static {v4, p1, v0, v5}, Landroidx/media3/extractor/FlacFrameReader;->checkAndReadFirstSampleNumber(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/FlacStreamMetadata;ZLandroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 162
    iget-wide v6, v5, Landroidx/media3/extractor/FlacFrameReader$SampleNumberHolder;->sampleNumber:J

    return-wide v6

    .line 159
    :cond_2
    const/4 v6, 0x0

    invoke-static {v6, v6}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v6

    throw v6
.end method

.method public static readFrameBlockSizeSamplesFromKey(Landroidx/media3/common/util/ParsableByteArray;I)I
    .locals 2
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "blockSizeKey"    # I

    .line 174
    packed-switch p1, :pswitch_data_0

    .line 196
    const/4 v0, -0x1

    return v0

    .line 194
    :pswitch_0
    add-int/lit8 v0, p1, -0x8

    const/16 v1, 0x100

    shl-int v0, v1, v0

    return v0

    .line 185
    :pswitch_1
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    return v0

    .line 183
    :pswitch_2
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    return v0

    .line 181
    :pswitch_3
    add-int/lit8 v0, p1, -0x2

    const/16 v1, 0x240

    shl-int v0, v1, v0

    return v0

    .line 176
    :pswitch_4
    const/16 v0, 0xc0

    return v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
