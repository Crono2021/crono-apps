.class public final Landroidx/media3/extractor/ts/AdtsExtractor;
.super Ljava/lang/Object;
.source "AdtsExtractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/ts/AdtsExtractor$Flags;
    }
.end annotation


# static fields
.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

.field public static final FLAG_ENABLE_CONSTANT_BITRATE_SEEKING:I = 0x1

.field public static final FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS:I = 0x2

.field private static final MAX_PACKET_SIZE:I = 0x800

.field private static final MAX_SNIFF_BYTES:I = 0x2000

.field private static final NUM_FRAMES_FOR_AVERAGE_FRAME_SIZE:I = 0x3e8


# instance fields
.field private averageFrameSize:I

.field private extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private firstFramePosition:J

.field private firstSampleTimestampUs:J

.field private final flags:I

.field private hasCalculatedAverageFrameSize:Z

.field private hasOutputSeekMap:Z

.field private final packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

.field private final reader:Landroidx/media3/extractor/ts/AdtsReader;

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private final scratchBits:Landroidx/media3/common/util/ParsableBitArray;

.field private startedPacket:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 54
    new-instance v0, Landroidx/media3/extractor/ts/AdtsExtractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/AdtsExtractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/extractor/ts/AdtsExtractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 123
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/extractor/ts/AdtsExtractor;-><init>(I)V

    .line 124
    return-void
.end method

.method public constructor <init>(I)V
    .locals 2
    .param p1, "flags"    # I

    .line 131
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 132
    and-int/lit8 v0, p1, 0x2

    if-eqz v0, :cond_0

    .line 133
    or-int/lit8 p1, p1, 0x1

    .line 135
    :cond_0
    iput p1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->flags:I

    .line 136
    new-instance v0, Landroidx/media3/extractor/ts/AdtsReader;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroidx/media3/extractor/ts/AdtsReader;-><init>(Z)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    .line 137
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x800

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 138
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    .line 139
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstFramePosition:J

    .line 141
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 142
    new-instance v1, Landroidx/media3/common/util/ParsableBitArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-direct {v1, v0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    iput-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratchBits:Landroidx/media3/common/util/ParsableBitArray;

    .line 143
    return-void
.end method

.method private calculateAverageFrameSize(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 9
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 298
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->hasCalculatedAverageFrameSize:Z

    if-eqz v0, :cond_0

    .line 299
    return-void

    .line 301
    :cond_0
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    .line 302
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 303
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v1

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-nez v1, :cond_1

    .line 305
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/AdtsExtractor;->peekId3Header(Landroidx/media3/extractor/ExtractorInput;)I

    .line 308
    :cond_1
    const/4 v1, 0x0

    .line 309
    .local v1, "numValidFrames":I
    const-wide/16 v2, 0x0

    .line 311
    .local v2, "totalValidFramesSize":J
    :goto_0
    const/4 v4, 0x1

    :try_start_0
    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 312
    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v5

    .line 311
    const/4 v6, 0x0

    const/4 v7, 0x2

    invoke-interface {p1, v5, v6, v7, v4}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 313
    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 314
    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v5

    .line 315
    .local v5, "syncBytes":I
    invoke-static {v5}, Landroidx/media3/extractor/ts/AdtsReader;->isAdtsSyncWord(I)Z

    move-result v7

    if-nez v7, :cond_2

    .line 318
    const/4 v1, 0x0

    .line 319
    goto :goto_1

    .line 322
    :cond_2
    iget-object v7, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 323
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    .line 322
    const/4 v8, 0x4

    invoke-interface {p1, v7, v6, v8, v4}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v6

    if-nez v6, :cond_3

    .line 324
    goto :goto_1

    .line 326
    :cond_3
    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratchBits:Landroidx/media3/common/util/ParsableBitArray;

    const/16 v7, 0xe

    invoke-virtual {v6, v7}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 327
    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratchBits:Landroidx/media3/common/util/ParsableBitArray;

    const/16 v7, 0xd

    invoke-virtual {v6, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v6

    .line 329
    .local v6, "currentFrameSize":I
    const/4 v7, 0x6

    if-le v6, v7, :cond_6

    .line 334
    int-to-long v7, v6

    add-long/2addr v2, v7

    .line 335
    add-int/lit8 v1, v1, 0x1

    const/16 v7, 0x3e8

    if-ne v1, v7, :cond_4

    .line 336
    goto :goto_1

    .line 338
    :cond_4
    add-int/lit8 v7, v6, -0x6

    invoke-interface {p1, v7, v4}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(IZ)Z

    move-result v7

    if-nez v7, :cond_5

    .line 339
    goto :goto_1

    .line 342
    .end local v5    # "syncBytes":I
    .end local v6    # "currentFrameSize":I
    :cond_5
    goto :goto_0

    .line 330
    .restart local v5    # "syncBytes":I
    .restart local v6    # "currentFrameSize":I
    :cond_6
    iput-boolean v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->hasCalculatedAverageFrameSize:Z

    .line 331
    const-string v7, "Malformed ADTS stream"

    const/4 v8, 0x0

    invoke-static {v7, v8}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v7

    .end local v1    # "numValidFrames":I
    .end local v2    # "totalValidFramesSize":J
    .end local p1    # "input":Landroidx/media3/extractor/ExtractorInput;
    throw v7
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    .line 348
    .end local v5    # "syncBytes":I
    .end local v6    # "currentFrameSize":I
    .restart local v1    # "numValidFrames":I
    .restart local v2    # "totalValidFramesSize":J
    .restart local p1    # "input":Landroidx/media3/extractor/ExtractorInput;
    :cond_7
    :goto_1
    goto :goto_2

    .line 343
    :catch_0
    move-exception v5

    .line 349
    :goto_2
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 350
    if-lez v1, :cond_8

    .line 351
    int-to-long v5, v1

    div-long v5, v2, v5

    long-to-int v0, v5

    iput v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    goto :goto_3

    .line 353
    :cond_8
    iput v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    .line 355
    :goto_3
    iput-boolean v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->hasCalculatedAverageFrameSize:Z

    .line 356
    return-void
.end method

.method private static getBitrateFromFrameSize(IJ)I
    .locals 4
    .param p0, "frameSize"    # I
    .param p1, "durationUsPerFrame"    # J

    .line 372
    int-to-long v0, p0

    const-wide/16 v2, 0x8

    mul-long/2addr v0, v2

    const-wide/32 v2, 0xf4240

    mul-long/2addr v0, v2

    div-long/2addr v0, p1

    long-to-int v0, v0

    return v0
.end method

.method private getConstantBitrateSeekMap(JZ)Landroidx/media3/extractor/SeekMap;
    .locals 11
    .param p1, "inputLength"    # J
    .param p3, "allowSeeksIfLengthUnknown"    # Z

    .line 359
    iget v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    invoke-virtual {v1}, Landroidx/media3/extractor/ts/AdtsReader;->getSampleDurationUs()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Landroidx/media3/extractor/ts/AdtsExtractor;->getBitrateFromFrameSize(IJ)I

    move-result v0

    .line 360
    .local v0, "bitrate":I
    new-instance v1, Landroidx/media3/extractor/ConstantBitrateSeekMap;

    iget-wide v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstFramePosition:J

    iget v9, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    move-object v3, v1

    move-wide v4, p1

    move v8, v0

    move v10, p3

    invoke-direct/range {v3 .. v10}, Landroidx/media3/extractor/ConstantBitrateSeekMap;-><init>(JJIIZ)V

    return-object v1
.end method

.method static synthetic lambda$static$0()[Landroidx/media3/extractor/Extractor;
    .locals 3

    .line 54
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/ts/AdtsExtractor;

    invoke-direct {v1}, Landroidx/media3/extractor/ts/AdtsExtractor;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method private maybeOutputSeekMap(JZ)V
    .locals 7
    .param p1, "inputLength"    # J
    .param p3, "readEndOfStream"    # Z
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "extractorOutput"
        }
    .end annotation

    .line 273
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->hasOutputSeekMap:Z

    if-eqz v0, :cond_0

    .line 274
    return-void

    .line 277
    :cond_0
    iget v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->flags:I

    const/4 v1, 0x1

    and-int/2addr v0, v1

    const/4 v2, 0x0

    if-eqz v0, :cond_1

    iget v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->averageFrameSize:I

    if-lez v0, :cond_1

    move v0, v1

    goto :goto_0

    :cond_1
    move v0, v2

    .line 279
    .local v0, "useConstantBitrateSeeking":Z
    :goto_0
    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    if-eqz v0, :cond_2

    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    .line 280
    invoke-virtual {v5}, Landroidx/media3/extractor/ts/AdtsReader;->getSampleDurationUs()J

    move-result-wide v5

    cmp-long v5, v5, v3

    if-nez v5, :cond_2

    if-nez p3, :cond_2

    .line 284
    return-void

    .line 287
    :cond_2
    if-eqz v0, :cond_4

    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    invoke-virtual {v5}, Landroidx/media3/extractor/ts/AdtsReader;->getSampleDurationUs()J

    move-result-wide v5

    cmp-long v5, v5, v3

    if-eqz v5, :cond_4

    .line 288
    iget-object v3, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    iget v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->flags:I

    and-int/lit8 v4, v4, 0x2

    if-eqz v4, :cond_3

    move v2, v1

    .line 289
    :cond_3
    invoke-direct {p0, p1, p2, v2}, Landroidx/media3/extractor/ts/AdtsExtractor;->getConstantBitrateSeekMap(JZ)Landroidx/media3/extractor/SeekMap;

    move-result-object v2

    .line 288
    invoke-interface {v3, v2}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    goto :goto_1

    .line 292
    :cond_4
    iget-object v2, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v5, Landroidx/media3/extractor/SeekMap$Unseekable;

    invoke-direct {v5, v3, v4}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {v2, v5}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 294
    :goto_1
    iput-boolean v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->hasOutputSeekMap:Z

    .line 295
    return-void
.end method

.method private peekId3Header(Landroidx/media3/extractor/ExtractorInput;)I
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 251
    const/4 v0, 0x0

    .line 253
    .local v0, "firstFramePosition":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    const/4 v2, 0x0

    const/16 v3, 0xa

    invoke-interface {p1, v1, v2, v3}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 254
    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 255
    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v1

    const v2, 0x494433

    if-eq v1, v2, :cond_1

    .line 256
    nop

    .line 263
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 264
    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 265
    iget-wide v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstFramePosition:J

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 266
    int-to-long v1, v0

    iput-wide v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstFramePosition:J

    .line 268
    :cond_0
    return v0

    .line 258
    :cond_1
    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 259
    iget-object v1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readSynchSafeInt()I

    move-result v1

    .line 260
    .local v1, "length":I
    add-int/lit8 v2, v1, 0xa

    add-int/2addr v0, v2

    .line 261
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 262
    .end local v1    # "length":I
    goto :goto_0
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 4
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 198
    iput-object p1, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 199
    iget-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    new-instance v1, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;-><init>(II)V

    invoke-virtual {v0, p1, v1}, Landroidx/media3/extractor/ts/AdtsReader;->createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V

    .line 200
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 201
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 11
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 217
    iget-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v0

    .line 220
    .local v0, "inputLength":J
    iget v2, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->flags:I

    and-int/lit8 v3, v2, 0x2

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-nez v3, :cond_1

    and-int/2addr v2, v4

    if-eqz v2, :cond_0

    const-wide/16 v2, -0x1

    cmp-long v2, v0, v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    move v2, v5

    goto :goto_1

    :cond_1
    :goto_0
    move v2, v4

    .line 224
    .local v2, "canUseConstantBitrateSeeking":Z
    :goto_1
    if-eqz v2, :cond_2

    .line 225
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/AdtsExtractor;->calculateAverageFrameSize(Landroidx/media3/extractor/ExtractorInput;)V

    .line 228
    :cond_2
    iget-object v3, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    const/16 v6, 0x800

    invoke-interface {p1, v3, v5, v6}, Landroidx/media3/extractor/ExtractorInput;->read([BII)I

    move-result v3

    .line 229
    .local v3, "bytesRead":I
    const/4 v6, -0x1

    if-ne v3, v6, :cond_3

    move v7, v4

    goto :goto_2

    :cond_3
    move v7, v5

    .line 230
    .local v7, "readEndOfStream":Z
    :goto_2
    invoke-direct {p0, v0, v1, v7}, Landroidx/media3/extractor/ts/AdtsExtractor;->maybeOutputSeekMap(JZ)V

    .line 231
    if-eqz v7, :cond_4

    .line 232
    return v6

    .line 236
    :cond_4
    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 237
    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v3}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 239
    iget-boolean v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->startedPacket:Z

    if-nez v6, :cond_5

    .line 241
    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    iget-wide v8, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstSampleTimestampUs:J

    const/4 v10, 0x4

    invoke-virtual {v6, v8, v9, v10}, Landroidx/media3/extractor/ts/AdtsReader;->packetStarted(JI)V

    .line 242
    iput-boolean v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->startedPacket:Z

    .line 246
    :cond_5
    iget-object v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    iget-object v6, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->packetBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4, v6}, Landroidx/media3/extractor/ts/AdtsReader;->consume(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 247
    return v5
.end method

.method public release()V
    .locals 0

    .line 213
    return-void
.end method

.method public seek(JJ)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 205
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->startedPacket:Z

    .line 206
    iget-object v0, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->reader:Landroidx/media3/extractor/ts/AdtsReader;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/AdtsReader;->seek()V

    .line 207
    iput-wide p3, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->firstSampleTimestampUs:J

    .line 208
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 8
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 150
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/AdtsExtractor;->peekId3Header(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    .line 153
    .local v0, "startPosition":I
    move v1, v0

    .line 154
    .local v1, "headerPosition":I
    const/4 v2, 0x0

    .line 155
    .local v2, "totalValidFramesSize":I
    const/4 v3, 0x0

    .line 157
    .local v3, "validFramesCount":I
    :goto_0
    iget-object v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    const/4 v5, 0x2

    const/4 v6, 0x0

    invoke-interface {p1, v4, v6, v5}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 158
    iget-object v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 159
    iget-object v4, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v4

    .line 160
    .local v4, "syncBytes":I
    invoke-static {v4}, Landroidx/media3/extractor/ts/AdtsReader;->isAdtsSyncWord(I)Z

    move-result v5

    if-nez v5, :cond_0

    .line 163
    const/4 v3, 0x0

    .line 164
    const/4 v2, 0x0

    .line 165
    add-int/lit8 v1, v1, 0x1

    .line 166
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 167
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    goto :goto_1

    .line 169
    :cond_0
    add-int/lit8 v3, v3, 0x1

    const/4 v5, 0x4

    if-lt v3, v5, :cond_1

    const/16 v7, 0xbc

    if-le v2, v7, :cond_1

    .line 170
    const/4 v5, 0x1

    return v5

    .line 174
    :cond_1
    iget-object v7, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    invoke-interface {p1, v7, v6, v5}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 175
    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratchBits:Landroidx/media3/common/util/ParsableBitArray;

    const/16 v7, 0xe

    invoke-virtual {v5, v7}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 176
    iget-object v5, p0, Landroidx/media3/extractor/ts/AdtsExtractor;->scratchBits:Landroidx/media3/common/util/ParsableBitArray;

    const/16 v7, 0xd

    invoke-virtual {v5, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 177
    .local v5, "frameSize":I
    const/4 v7, 0x6

    if-gt v5, v7, :cond_2

    .line 180
    const/4 v3, 0x0

    .line 181
    const/4 v2, 0x0

    .line 182
    add-int/lit8 v1, v1, 0x1

    .line 183
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 184
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    goto :goto_1

    .line 186
    :cond_2
    add-int/lit8 v7, v5, -0x6

    invoke-interface {p1, v7}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 187
    add-int/2addr v2, v5

    .line 190
    .end local v5    # "frameSize":I
    :goto_1
    sub-int v5, v1, v0

    const/16 v7, 0x2000

    if-lt v5, v7, :cond_3

    .line 191
    return v6

    .line 193
    .end local v4    # "syncBytes":I
    :cond_3
    goto :goto_0
.end method
