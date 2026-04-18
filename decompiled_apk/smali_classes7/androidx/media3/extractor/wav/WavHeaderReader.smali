.class final Landroidx/media3/extractor/wav/WavHeaderReader;
.super Ljava/lang/Object;
.source "WavHeaderReader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "WavHeaderReader"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 191
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 193
    return-void
.end method

.method public static checkFileType(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 6
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 45
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 46
    .local v0, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    invoke-static {p0, v0}, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->peek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v1

    .line 47
    .local v1, "chunkHeader":Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    iget v2, v1, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    const v3, 0x52494646

    const/4 v4, 0x0

    if-eq v2, v3, :cond_0

    iget v2, v1, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    const v3, 0x52463634

    if-eq v2, v3, :cond_0

    .line 48
    return v4

    .line 51
    :cond_0
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    const/4 v3, 0x4

    invoke-interface {p0, v2, v4, v3}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 52
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 53
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 54
    .local v2, "formType":I
    const v3, 0x57415645

    if-eq v2, v3, :cond_1

    .line 55
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unsupported form type: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v5, "WavHeaderReader"

    invoke-static {v5, v3}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    return v4

    .line 59
    :cond_1
    const/4 v3, 0x1

    return v3
.end method

.method public static readFormat(Landroidx/media3/extractor/ExtractorInput;)Landroidx/media3/extractor/wav/WavFormat;
    .locals 20
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 97
    move-object/from16 v0, p0

    new-instance v1, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v2, 0x10

    invoke-direct {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 99
    .local v1, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    const v3, 0x666d7420

    invoke-static {v3, v0, v1}, Landroidx/media3/extractor/wav/WavHeaderReader;->skipToChunk(ILandroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v3

    .line 100
    .local v3, "chunkHeader":Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    iget-wide v4, v3, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    const-wide/16 v6, 0x10

    cmp-long v4, v4, v6

    const/4 v5, 0x0

    if-ltz v4, :cond_0

    const/4 v4, 0x1

    goto :goto_0

    :cond_0
    move v4, v5

    :goto_0
    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 101
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    invoke-interface {v0, v4, v5, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 102
    invoke-virtual {v1, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 103
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v4

    .line 104
    .local v4, "audioFormatType":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v14

    .line 105
    .local v14, "numChannels":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedIntToInt()I

    move-result v15

    .line 106
    .local v15, "frameRateHz":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedIntToInt()I

    move-result v16

    .line 107
    .local v16, "averageBytesPerSecond":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v17

    .line 108
    .local v17, "blockSize":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v18

    .line 110
    .local v18, "bitsPerSample":I
    iget-wide v6, v3, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    long-to-int v6, v6

    add-int/lit8 v2, v6, -0x10

    .line 112
    .local v2, "bytesLeft":I
    if-lez v2, :cond_1

    .line 113
    new-array v6, v2, [B

    .line 114
    .local v6, "extraData":[B
    invoke-interface {v0, v6, v5, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    move-object v5, v6

    goto :goto_1

    .line 116
    .end local v6    # "extraData":[B
    :cond_1
    sget-object v6, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    move-object v5, v6

    .line 119
    .local v5, "extraData":[B
    :goto_1
    invoke-interface/range {p0 .. p0}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v6

    invoke-interface/range {p0 .. p0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v8

    sub-long/2addr v6, v8

    long-to-int v6, v6

    invoke-interface {v0, v6}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 120
    new-instance v19, Landroidx/media3/extractor/wav/WavFormat;

    move-object/from16 v6, v19

    move v7, v4

    move v8, v14

    move v9, v15

    move/from16 v10, v16

    move/from16 v11, v17

    move/from16 v12, v18

    move-object v13, v5

    invoke-direct/range {v6 .. v13}, Landroidx/media3/extractor/wav/WavFormat;-><init>(IIIIII[B)V

    return-object v19
.end method

.method public static readRf64SampleDataSize(Landroidx/media3/extractor/ExtractorInput;)J
    .locals 7
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 73
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 74
    .local v0, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    invoke-static {p0, v0}, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->peek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v2

    .line 75
    .local v2, "chunkHeader":Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    iget v3, v2, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    const v4, 0x64733634

    if-eq v3, v4, :cond_0

    .line 76
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 77
    const-wide/16 v3, -0x1

    return-wide v3

    .line 79
    :cond_0
    invoke-interface {p0, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 80
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 81
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    invoke-interface {p0, v4, v3, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 82
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianLong()J

    move-result-wide v3

    .line 83
    .local v3, "sampleDataSize":J
    iget-wide v5, v2, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    long-to-int v5, v5

    add-int/2addr v5, v1

    invoke-interface {p0, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 84
    return-wide v3
.end method

.method private static skipToChunk(ILandroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    .locals 7
    .param p0, "chunkId"    # I
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "scratch"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 171
    invoke-static {p1, p2}, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->peek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v0

    .line 172
    .local v0, "chunkHeader":Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    :goto_0
    iget v1, v0, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    if-eq v1, p0, :cond_2

    .line 173
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Ignoring unknown WAV chunk: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "WavHeaderReader"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-wide/16 v1, 0x8

    iget-wide v3, v0, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    add-long/2addr v3, v1

    .line 178
    .local v3, "bytesToSkip":J
    iget-wide v1, v0, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    const-wide/16 v5, 0x2

    rem-long/2addr v1, v5

    const-wide/16 v5, 0x0

    cmp-long v1, v1, v5

    if-eqz v1, :cond_0

    .line 179
    const-wide/16 v1, 0x1

    add-long/2addr v3, v1

    .line 181
    :cond_0
    const-wide/32 v1, 0x7fffffff

    cmp-long v1, v3, v1

    if-gtz v1, :cond_1

    .line 185
    long-to-int v1, v3

    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 186
    invoke-static {p1, p2}, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->peek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v0

    .line 187
    .end local v3    # "bytesToSkip":J
    goto :goto_0

    .line 182
    .restart local v3    # "bytesToSkip":J
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Chunk is too large (~2GB+) to skip; id: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, v0, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->id:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v1

    throw v1

    .line 188
    .end local v3    # "bytesToSkip":J
    :cond_2
    return-object v0
.end method

.method public static skipToSampleData(Landroidx/media3/extractor/ExtractorInput;)Landroid/util/Pair;
    .locals 7
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/ExtractorInput;",
            ")",
            "Landroid/util/Pair<",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 144
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 146
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 148
    .local v0, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    const v2, 0x64617461

    invoke-static {v2, p0, v0}, Landroidx/media3/extractor/wav/WavHeaderReader;->skipToChunk(ILandroidx/media3/extractor/ExtractorInput;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;

    move-result-object v2

    .line 150
    .local v2, "chunkHeader":Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;
    invoke-interface {p0, v1}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 152
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v3

    .line 153
    .local v3, "dataStartPosition":J
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    iget-wide v5, v2, Landroidx/media3/extractor/wav/WavHeaderReader$ChunkHeader;->size:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-static {v1, v5}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v1

    return-object v1
.end method
