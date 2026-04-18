.class public final Landroidx/media3/extractor/ts/LatmReader;
.super Ljava/lang/Object;
.source "LatmReader.java"

# interfaces
.implements Landroidx/media3/extractor/ts/ElementaryStreamReader;


# static fields
.field private static final INITIAL_BUFFER_SIZE:I = 0x400

.field private static final STATE_FINDING_SYNC_1:I = 0x0

.field private static final STATE_FINDING_SYNC_2:I = 0x1

.field private static final STATE_READING_HEADER:I = 0x2

.field private static final STATE_READING_SAMPLE:I = 0x3

.field private static final SYNC_BYTE_FIRST:I = 0x56

.field private static final SYNC_BYTE_SECOND:I = 0xe0


# instance fields
.field private audioMuxVersionA:I

.field private bytesRead:I

.field private channelCount:I

.field private codecs:Ljava/lang/String;

.field private format:Landroidx/media3/common/Format;

.field private formatId:Ljava/lang/String;

.field private frameLengthType:I

.field private final language:Ljava/lang/String;

.field private numSubframes:I

.field private otherDataLenBits:J

.field private otherDataPresent:Z

.field private output:Landroidx/media3/extractor/TrackOutput;

.field private final roleFlags:I

.field private final sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

.field private final sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

.field private sampleDurationUs:J

.field private sampleRateHz:I

.field private sampleSize:I

.field private secondHeaderByte:I

.field private state:I

.field private streamMuxRead:Z

.field private timeUs:J


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .locals 2
    .param p1, "language"    # Ljava/lang/String;
    .param p2, "roleFlags"    # I

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    iput-object p1, p0, Landroidx/media3/extractor/ts/LatmReader;->language:Ljava/lang/String;

    .line 86
    iput p2, p0, Landroidx/media3/extractor/ts/LatmReader;->roleFlags:I

    .line 87
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x400

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 88
    new-instance v1, Landroidx/media3/common/util/ParsableBitArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-direct {v1, v0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    iput-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

    .line 89
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    .line 90
    return-void
.end method

.method private static latmGetValue(Landroidx/media3/common/util/ParsableBitArray;)J
    .locals 3
    .param p0, "data"    # Landroidx/media3/common/util/ParsableBitArray;

    .line 332
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v0

    .line 333
    .local v0, "bytesForValue":I
    add-int/lit8 v1, v0, 0x1

    mul-int/lit8 v1, v1, 0x8

    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    int-to-long v1, v1

    return-wide v1
.end method

.method private parseAudioMuxElement(Landroidx/media3/common/util/ParsableBitArray;)V
    .locals 4
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 167
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v0

    .line 168
    .local v0, "useSameStreamMux":Z
    if-nez v0, :cond_0

    .line 169
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/extractor/ts/LatmReader;->streamMuxRead:Z

    .line 170
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/LatmReader;->parseStreamMuxConfig(Landroidx/media3/common/util/ParsableBitArray;)V

    goto :goto_0

    .line 171
    :cond_0
    iget-boolean v1, p0, Landroidx/media3/extractor/ts/LatmReader;->streamMuxRead:Z

    if-nez v1, :cond_1

    .line 172
    return-void

    .line 175
    :cond_1
    :goto_0
    iget v1, p0, Landroidx/media3/extractor/ts/LatmReader;->audioMuxVersionA:I

    const/4 v2, 0x0

    if-nez v1, :cond_4

    .line 176
    iget v1, p0, Landroidx/media3/extractor/ts/LatmReader;->numSubframes:I

    if-nez v1, :cond_3

    .line 179
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/LatmReader;->parsePayloadLengthInfo(Landroidx/media3/common/util/ParsableBitArray;)I

    move-result v1

    .line 180
    .local v1, "muxSlotLengthBytes":I
    invoke-direct {p0, p1, v1}, Landroidx/media3/extractor/ts/LatmReader;->parsePayloadMux(Landroidx/media3/common/util/ParsableBitArray;I)V

    .line 181
    iget-boolean v2, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataPresent:Z

    if-eqz v2, :cond_2

    .line 182
    iget-wide v2, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataLenBits:J

    long-to-int v2, v2

    invoke-virtual {p1, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 184
    .end local v1    # "muxSlotLengthBytes":I
    :cond_2
    nop

    .line 188
    return-void

    .line 177
    :cond_3
    invoke-static {v2, v2}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v1

    throw v1

    .line 186
    :cond_4
    invoke-static {v2, v2}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v1

    throw v1
.end method

.method private parseAudioSpecificConfig(Landroidx/media3/common/util/ParsableBitArray;)I
    .locals 3
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 283
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->bitsLeft()I

    move-result v0

    .line 284
    .local v0, "bitsLeft":I
    const/4 v1, 0x1

    invoke-static {p1, v1}, Landroidx/media3/extractor/AacUtil;->parseAudioSpecificConfig(Landroidx/media3/common/util/ParsableBitArray;Z)Landroidx/media3/extractor/AacUtil$Config;

    move-result-object v1

    .line 285
    .local v1, "config":Landroidx/media3/extractor/AacUtil$Config;
    iget-object v2, v1, Landroidx/media3/extractor/AacUtil$Config;->codecs:Ljava/lang/String;

    iput-object v2, p0, Landroidx/media3/extractor/ts/LatmReader;->codecs:Ljava/lang/String;

    .line 286
    iget v2, v1, Landroidx/media3/extractor/AacUtil$Config;->sampleRateHz:I

    iput v2, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleRateHz:I

    .line 287
    iget v2, v1, Landroidx/media3/extractor/AacUtil$Config;->channelCount:I

    iput v2, p0, Landroidx/media3/extractor/ts/LatmReader;->channelCount:I

    .line 288
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->bitsLeft()I

    move-result v2

    sub-int v2, v0, v2

    return v2
.end method

.method private parseFrameLength(Landroidx/media3/common/util/ParsableBitArray;)V
    .locals 1
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;

    .line 260
    const/4 v0, 0x3

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->frameLengthType:I

    .line 261
    packed-switch v0, :pswitch_data_0

    .line 278
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 275
    :pswitch_1
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 276
    goto :goto_0

    .line 271
    :pswitch_2
    const/4 v0, 0x6

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 272
    goto :goto_0

    .line 266
    :pswitch_3
    const/16 v0, 0x9

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 267
    goto :goto_0

    .line 263
    :pswitch_4
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 264
    nop

    .line 280
    :goto_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method private parsePayloadLengthInfo(Landroidx/media3/common/util/ParsableBitArray;)I
    .locals 3
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 292
    const/4 v0, 0x0

    .line 294
    .local v0, "muxSlotLengthBytes":I
    iget v1, p0, Landroidx/media3/extractor/ts/LatmReader;->frameLengthType:I

    if-nez v1, :cond_1

    .line 297
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    .line 298
    .local v1, "tmp":I
    add-int/2addr v0, v1

    .line 299
    const/16 v2, 0xff

    if-eq v1, v2, :cond_0

    .line 300
    return v0

    .line 302
    .end local v1    # "tmp":I
    :cond_1
    const/4 v1, 0x0

    invoke-static {v1, v1}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v1

    throw v1
.end method

.method private parsePayloadMux(Landroidx/media3/common/util/ParsableBitArray;I)V
    .locals 10
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .param p2, "muxLengthBytes"    # I
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 309
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->getPosition()I

    move-result v0

    .line 310
    .local v0, "bitPosition":I
    and-int/lit8 v1, v0, 0x7

    const/4 v2, 0x0

    if-nez v1, :cond_0

    .line 312
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    shr-int/lit8 v3, v0, 0x3

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    goto :goto_0

    .line 316
    :cond_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    mul-int/lit8 v3, p2, 0x8

    invoke-virtual {p1, v1, v2, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits([BII)V

    .line 317
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 319
    :goto_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-object v3, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v1, v3, p2}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 321
    iget-wide v3, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v1, v3, v5

    if-eqz v1, :cond_1

    const/4 v2, 0x1

    :cond_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 322
    iget-object v3, p0, Landroidx/media3/extractor/ts/LatmReader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-wide v4, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    const/4 v6, 0x1

    const/4 v8, 0x0

    const/4 v9, 0x0

    move v7, p2

    invoke-interface/range {v3 .. v9}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 323
    iget-wide v1, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    iget-wide v3, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDurationUs:J

    add-long/2addr v1, v3

    iput-wide v1, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    .line 324
    return-void
.end method

.method private parseStreamMuxConfig(Landroidx/media3/common/util/ParsableBitArray;)V
    .locals 13
    .param p1, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 193
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    .line 194
    .local v1, "audioMuxVersion":I
    const/4 v2, 0x0

    if-ne v1, v0, :cond_0

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    goto :goto_0

    :cond_0
    move v3, v2

    :goto_0
    iput v3, p0, Landroidx/media3/extractor/ts/LatmReader;->audioMuxVersionA:I

    .line 195
    const/4 v4, 0x0

    if-nez v3, :cond_9

    .line 196
    if-ne v1, v0, :cond_1

    .line 197
    invoke-static {p1}, Landroidx/media3/extractor/ts/LatmReader;->latmGetValue(Landroidx/media3/common/util/ParsableBitArray;)J

    .line 199
    :cond_1
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 202
    const/4 v3, 0x6

    invoke-virtual {p1, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    iput v3, p0, Landroidx/media3/extractor/ts/LatmReader;->numSubframes:I

    .line 203
    const/4 v3, 0x4

    invoke-virtual {p1, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 204
    .local v3, "numProgram":I
    const/4 v5, 0x3

    invoke-virtual {p1, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 205
    .local v5, "numLayer":I
    if-nez v3, :cond_7

    if-nez v5, :cond_7

    .line 208
    const/16 v4, 0x8

    if-nez v1, :cond_3

    .line 209
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->getPosition()I

    move-result v6

    .line 210
    .local v6, "startPosition":I
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/LatmReader;->parseAudioSpecificConfig(Landroidx/media3/common/util/ParsableBitArray;)I

    move-result v7

    .line 211
    .local v7, "readBits":I
    invoke-virtual {p1, v6}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 212
    add-int/lit8 v8, v7, 0x7

    div-int/2addr v8, v4

    new-array v8, v8, [B

    .line 213
    .local v8, "initData":[B
    invoke-virtual {p1, v8, v2, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits([BII)V

    .line 214
    new-instance v2, Landroidx/media3/common/Format$Builder;

    invoke-direct {v2}, Landroidx/media3/common/Format$Builder;-><init>()V

    iget-object v9, p0, Landroidx/media3/extractor/ts/LatmReader;->formatId:Ljava/lang/String;

    .line 216
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 217
    const-string v9, "audio/mp4a-latm"

    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    iget-object v9, p0, Landroidx/media3/extractor/ts/LatmReader;->codecs:Ljava/lang/String;

    .line 218
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    iget v9, p0, Landroidx/media3/extractor/ts/LatmReader;->channelCount:I

    .line 219
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    iget v9, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleRateHz:I

    .line 220
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 221
    invoke-static {v8}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v9

    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    iget-object v9, p0, Landroidx/media3/extractor/ts/LatmReader;->language:Ljava/lang/String;

    .line 222
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    iget v9, p0, Landroidx/media3/extractor/ts/LatmReader;->roleFlags:I

    .line 223
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setRoleFlags(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 224
    invoke-virtual {v2}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v2

    .line 225
    .local v2, "format":Landroidx/media3/common/Format;
    iget-object v9, p0, Landroidx/media3/extractor/ts/LatmReader;->format:Landroidx/media3/common/Format;

    invoke-virtual {v2, v9}, Landroidx/media3/common/Format;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_2

    .line 226
    iput-object v2, p0, Landroidx/media3/extractor/ts/LatmReader;->format:Landroidx/media3/common/Format;

    .line 227
    iget v9, v2, Landroidx/media3/common/Format;->sampleRate:I

    int-to-long v9, v9

    const-wide/32 v11, 0x3d090000

    div-long/2addr v11, v9

    iput-wide v11, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDurationUs:J

    .line 228
    iget-object v9, p0, Landroidx/media3/extractor/ts/LatmReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v9, v2}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 230
    .end local v2    # "format":Landroidx/media3/common/Format;
    .end local v6    # "startPosition":I
    .end local v7    # "readBits":I
    .end local v8    # "initData":[B
    :cond_2
    goto :goto_1

    .line 231
    :cond_3
    invoke-static {p1}, Landroidx/media3/extractor/ts/LatmReader;->latmGetValue(Landroidx/media3/common/util/ParsableBitArray;)J

    move-result-wide v6

    long-to-int v2, v6

    .line 232
    .local v2, "ascLen":I
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/LatmReader;->parseAudioSpecificConfig(Landroidx/media3/common/util/ParsableBitArray;)I

    move-result v6

    .line 233
    .local v6, "bitsRead":I
    sub-int v7, v2, v6

    invoke-virtual {p1, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 235
    .end local v2    # "ascLen":I
    .end local v6    # "bitsRead":I
    :goto_1
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/LatmReader;->parseFrameLength(Landroidx/media3/common/util/ParsableBitArray;)V

    .line 236
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v2

    iput-boolean v2, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataPresent:Z

    .line 237
    const-wide/16 v6, 0x0

    iput-wide v6, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataLenBits:J

    .line 238
    if-eqz v2, :cond_5

    .line 239
    if-ne v1, v0, :cond_4

    .line 240
    invoke-static {p1}, Landroidx/media3/extractor/ts/LatmReader;->latmGetValue(Landroidx/media3/common/util/ParsableBitArray;)J

    move-result-wide v6

    iput-wide v6, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataLenBits:J

    goto :goto_2

    .line 244
    :cond_4
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v0

    .line 245
    .local v0, "otherDataLenEsc":Z
    iget-wide v6, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataLenBits:J

    shl-long/2addr v6, v4

    invoke-virtual {p1, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    int-to-long v8, v2

    add-long/2addr v6, v8

    iput-wide v6, p0, Landroidx/media3/extractor/ts/LatmReader;->otherDataLenBits:J

    .line 246
    if-nez v0, :cond_4

    .line 249
    .end local v0    # "otherDataLenEsc":Z
    :cond_5
    :goto_2
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v0

    .line 250
    .local v0, "crcCheckPresent":Z
    if-eqz v0, :cond_6

    .line 251
    invoke-virtual {p1, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 253
    .end local v0    # "crcCheckPresent":Z
    .end local v3    # "numProgram":I
    .end local v5    # "numLayer":I
    :cond_6
    nop

    .line 257
    return-void

    .line 206
    .restart local v3    # "numProgram":I
    .restart local v5    # "numLayer":I
    :cond_7
    invoke-static {v4, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 200
    .end local v3    # "numProgram":I
    .end local v5    # "numLayer":I
    :cond_8
    invoke-static {v4, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 255
    :cond_9
    invoke-static {v4, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method private resetBufferForSize(I)V
    .locals 2
    .param p1, "newSize"    # I

    .line 327
    iget-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, p1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 328
    iget-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->reset([B)V

    .line 329
    return-void
.end method


# virtual methods
.method public consume(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 5
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 113
    iget-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 115
    :cond_0
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    if-lez v0, :cond_3

    .line 116
    iget v0, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    const/16 v1, 0x56

    const/4 v2, 0x0

    packed-switch v0, :pswitch_data_0

    .line 150
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 140
    :pswitch_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    iget v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleSize:I

    iget v3, p0, Landroidx/media3/extractor/ts/LatmReader;->bytesRead:I

    sub-int/2addr v1, v3

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 141
    .local v0, "bytesToRead":I
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

    iget-object v1, v1, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v3, p0, Landroidx/media3/extractor/ts/LatmReader;->bytesRead:I

    invoke-virtual {p1, v1, v3, v0}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 142
    iget v1, p0, Landroidx/media3/extractor/ts/LatmReader;->bytesRead:I

    add-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/extractor/ts/LatmReader;->bytesRead:I

    .line 143
    iget v3, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleSize:I

    if-ne v1, v3, :cond_0

    .line 144
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 145
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleBitArray:Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {p0, v1}, Landroidx/media3/extractor/ts/LatmReader;->parseAudioMuxElement(Landroidx/media3/common/util/ParsableBitArray;)V

    .line 146
    iput v2, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    goto :goto_0

    .line 132
    .end local v0    # "bytesToRead":I
    :pswitch_1
    iget v0, p0, Landroidx/media3/extractor/ts/LatmReader;->secondHeaderByte:I

    and-int/lit16 v0, v0, -0xe1

    shl-int/lit8 v0, v0, 0x8

    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v1

    or-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleSize:I

    .line 133
    iget-object v1, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleDataBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    array-length v1, v1

    if-le v0, v1, :cond_1

    .line 134
    iget v0, p0, Landroidx/media3/extractor/ts/LatmReader;->sampleSize:I

    invoke-direct {p0, v0}, Landroidx/media3/extractor/ts/LatmReader;->resetBufferForSize(I)V

    .line 136
    :cond_1
    iput v2, p0, Landroidx/media3/extractor/ts/LatmReader;->bytesRead:I

    .line 137
    const/4 v0, 0x3

    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    .line 138
    goto :goto_0

    .line 123
    :pswitch_2
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 124
    .local v0, "secondByte":I
    and-int/lit16 v3, v0, 0xe0

    const/16 v4, 0xe0

    if-ne v3, v4, :cond_2

    .line 125
    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->secondHeaderByte:I

    .line 126
    const/4 v1, 0x2

    iput v1, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    goto :goto_0

    .line 127
    :cond_2
    if-eq v0, v1, :cond_0

    .line 128
    iput v2, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    goto :goto_0

    .line 118
    .end local v0    # "secondByte":I
    :pswitch_3
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    if-ne v0, v1, :cond_0

    .line 119
    const/4 v0, 0x1

    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    goto :goto_0

    .line 153
    :cond_3
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V
    .locals 2
    .param p1, "extractorOutput"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p2, "idGenerator"    # Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    .line 101
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->generateNewId()V

    .line 102
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getTrackId()I

    move-result v0

    const/4 v1, 0x1

    invoke-interface {p1, v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 103
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getFormatId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/LatmReader;->formatId:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public packetFinished()V
    .locals 0

    .line 158
    return-void
.end method

.method public packetStarted(JI)V
    .locals 0
    .param p1, "pesTimeUs"    # J
    .param p3, "flags"    # I

    .line 108
    iput-wide p1, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    .line 109
    return-void
.end method

.method public seek()V
    .locals 3

    .line 94
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/ts/LatmReader;->state:I

    .line 95
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v1, p0, Landroidx/media3/extractor/ts/LatmReader;->timeUs:J

    .line 96
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/LatmReader;->streamMuxRead:Z

    .line 97
    return-void
.end method
