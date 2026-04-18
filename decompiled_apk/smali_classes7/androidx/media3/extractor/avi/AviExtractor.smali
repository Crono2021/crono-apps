.class public final Landroidx/media3/extractor/avi/AviExtractor;
.super Ljava/lang/Object;
.source "AviExtractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;,
        Landroidx/media3/extractor/avi/AviExtractor$AviSeekMap;,
        Landroidx/media3/extractor/avi/AviExtractor$Flags;
    }
.end annotation


# static fields
.field private static final AVIIF_KEYFRAME:I = 0x10

.field public static final FLAG_EMIT_RAW_SUBTITLE_DATA:I = 0x1

.field public static final FOURCC_AVI_:I = 0x20495641

.field public static final FOURCC_JUNK:I = 0x4b4e554a

.field public static final FOURCC_LIST:I = 0x5453494c

.field public static final FOURCC_RIFF:I = 0x46464952

.field public static final FOURCC_auds:I = 0x73647561

.field public static final FOURCC_avih:I = 0x68697661

.field public static final FOURCC_hdrl:I = 0x6c726468

.field public static final FOURCC_idx1:I = 0x31786469

.field public static final FOURCC_movi:I = 0x69766f6d

.field public static final FOURCC_strf:I = 0x66727473

.field public static final FOURCC_strh:I = 0x68727473

.field public static final FOURCC_strl:I = 0x6c727473

.field public static final FOURCC_strn:I = 0x6e727473

.field public static final FOURCC_txts:I = 0x73747874

.field public static final FOURCC_vids:I = 0x73646976

.field private static final RELOAD_MINIMUM_SEEK_DISTANCE:J = 0x40000L

.field private static final STATE_FINDING_IDX1_HEADER:I = 0x4

.field private static final STATE_FINDING_MOVI_HEADER:I = 0x3

.field private static final STATE_READING_HDRL_BODY:I = 0x2

.field private static final STATE_READING_HDRL_HEADER:I = 0x1

.field private static final STATE_READING_IDX1_BODY:I = 0x5

.field private static final STATE_READING_SAMPLES:I = 0x6

.field private static final STATE_SKIPPING_TO_HDRL:I = 0x0

.field private static final TAG:Ljava/lang/String; = "AviExtractor"


# instance fields
.field private aviHeader:Landroidx/media3/extractor/avi/AviMainHeaderChunk;

.field private final chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

.field private chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

.field private currentChunkReader:Landroidx/media3/extractor/avi/ChunkReader;

.field private durationUs:J

.field private extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private hdrlSize:I

.field private idx1BodySize:I

.field private moviEnd:J

.field private moviStart:J

.field private final parseSubtitlesDuringExtraction:Z

.field private pendingReposition:J

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private seekMapHasBeenOutput:Z

.field private state:I

.field private final subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;


# direct methods
.method public constructor <init>()V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 169
    const/4 v0, 0x1

    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {p0, v0, v1}, Landroidx/media3/extractor/avi/AviExtractor;-><init>(ILandroidx/media3/extractor/text/SubtitleParser$Factory;)V

    .line 170
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/extractor/text/SubtitleParser$Factory;)V
    .locals 3
    .param p1, "extractorFlags"    # I
    .param p2, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 179
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 180
    iput-object p2, p0, Landroidx/media3/extractor/avi/AviExtractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 181
    and-int/lit8 v0, p1, 0x1

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    iput-boolean v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->parseSubtitlesDuringExtraction:Z

    .line 182
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v2, 0xc

    invoke-direct {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 183
    new-instance v0, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    const/4 v2, 0x0

    invoke-direct {v0, v2}, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;-><init>(Landroidx/media3/extractor/avi/AviExtractor$1;)V

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    .line 184
    new-instance v0, Landroidx/media3/extractor/DummyExtractorOutput;

    invoke-direct {v0}, Landroidx/media3/extractor/DummyExtractorOutput;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 185
    new-array v0, v1, [Landroidx/media3/extractor/avi/ChunkReader;

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    .line 186
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    .line 187
    iput-wide v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviEnd:J

    .line 188
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->hdrlSize:I

    .line 189
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->durationUs:J

    .line 190
    return-void
.end method

.method static synthetic access$100(Landroidx/media3/extractor/avi/AviExtractor;)[Landroidx/media3/extractor/avi/ChunkReader;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/avi/AviExtractor;

    .line 53
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    return-object v0
.end method

.method private static alignInputToEvenPosition(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 4
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 541
    invoke-interface {p0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    const-wide/16 v2, 0x1

    and-long/2addr v0, v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 542
    const/4 v0, 0x1

    invoke-interface {p0, v0}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 544
    :cond_0
    return-void
.end method

.method private getChunkReader(I)Landroidx/media3/extractor/avi/ChunkReader;
    .locals 5
    .param p1, "chunkId"    # I

    .line 448
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    array-length v1, v0

    const/4 v2, 0x0

    :goto_0
    if-ge v2, v1, :cond_1

    aget-object v3, v0, v2

    .line 449
    .local v3, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    invoke-virtual {v3, p1}, Landroidx/media3/extractor/avi/ChunkReader;->handlesChunkId(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 450
    return-object v3

    .line 448
    .end local v3    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 453
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method private parseHdrlBody(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 8
    .param p1, "hrdlBody"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 370
    const v0, 0x6c726468

    invoke-static {v0, p1}, Landroidx/media3/extractor/avi/ListChunk;->parseFrom(ILandroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/ListChunk;

    move-result-object v1

    .line 371
    .local v1, "headerList":Landroidx/media3/extractor/avi/ListChunk;
    invoke-virtual {v1}, Landroidx/media3/extractor/avi/ListChunk;->getType()I

    move-result v2

    const/4 v3, 0x0

    if-ne v2, v0, :cond_4

    .line 375
    const-class v0, Landroidx/media3/extractor/avi/AviMainHeaderChunk;

    invoke-virtual {v1, v0}, Landroidx/media3/extractor/avi/ListChunk;->getChild(Ljava/lang/Class;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/avi/AviMainHeaderChunk;

    .line 376
    .local v0, "aviHeader":Landroidx/media3/extractor/avi/AviMainHeaderChunk;
    if-eqz v0, :cond_3

    .line 380
    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->aviHeader:Landroidx/media3/extractor/avi/AviMainHeaderChunk;

    .line 382
    iget v2, v0, Landroidx/media3/extractor/avi/AviMainHeaderChunk;->totalFrames:I

    int-to-long v2, v2

    iget v4, v0, Landroidx/media3/extractor/avi/AviMainHeaderChunk;->frameDurationUs:I

    int-to-long v4, v4

    mul-long/2addr v2, v4

    iput-wide v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->durationUs:J

    .line 383
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 384
    .local v2, "chunkReaderList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/extractor/avi/ChunkReader;>;"
    const/4 v3, 0x0

    .line 385
    .local v3, "streamId":I
    iget-object v4, v1, Landroidx/media3/extractor/avi/ListChunk;->children:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v4}, Lcom/google/common/collect/ImmutableList;->iterator()Lcom/google/common/collect/UnmodifiableIterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/avi/AviChunk;

    .line 386
    .local v5, "aviChunk":Landroidx/media3/extractor/avi/AviChunk;
    invoke-interface {v5}, Landroidx/media3/extractor/avi/AviChunk;->getType()I

    move-result v6

    const v7, 0x6c727473

    if-ne v6, v7, :cond_1

    .line 387
    move-object v6, v5

    check-cast v6, Landroidx/media3/extractor/avi/ListChunk;

    .line 391
    .local v6, "streamList":Landroidx/media3/extractor/avi/ListChunk;
    add-int/lit8 v7, v3, 0x1

    .end local v3    # "streamId":I
    .local v7, "streamId":I
    invoke-direct {p0, v6, v3}, Landroidx/media3/extractor/avi/AviExtractor;->processStreamList(Landroidx/media3/extractor/avi/ListChunk;I)Landroidx/media3/extractor/avi/ChunkReader;

    move-result-object v3

    .line 392
    .local v3, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    if-eqz v3, :cond_0

    .line 393
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 396
    .end local v3    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    .end local v5    # "aviChunk":Landroidx/media3/extractor/avi/AviChunk;
    .end local v6    # "streamList":Landroidx/media3/extractor/avi/ListChunk;
    :cond_0
    move v3, v7

    .end local v7    # "streamId":I
    .local v3, "streamId":I
    :cond_1
    goto :goto_0

    .line 397
    :cond_2
    const/4 v4, 0x0

    new-array v4, v4, [Landroidx/media3/extractor/avi/ChunkReader;

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v4

    check-cast v4, [Landroidx/media3/extractor/avi/ChunkReader;

    iput-object v4, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    .line 398
    iget-object v4, p0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v4}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 399
    return-void

    .line 377
    .end local v2    # "chunkReaderList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/extractor/avi/ChunkReader;>;"
    .end local v3    # "streamId":I
    :cond_3
    const-string v2, "AviHeader not found"

    invoke-static {v2, v3}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v2

    throw v2

    .line 372
    .end local v0    # "aviHeader":Landroidx/media3/extractor/avi/AviMainHeaderChunk;
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected header list type "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 373
    invoke-virtual {v1}, Landroidx/media3/extractor/avi/ListChunk;->getType()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 372
    invoke-static {v0, v3}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method private parseIdx1Body(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 9
    .param p1, "body"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 403
    invoke-direct {p0, p1}, Landroidx/media3/extractor/avi/AviExtractor;->peekSeekOffset(Landroidx/media3/common/util/ParsableByteArray;)J

    move-result-wide v0

    .line 404
    .local v0, "seekOffset":J
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v2

    const/16 v3, 0x10

    if-lt v2, v3, :cond_2

    .line 405
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v2

    .line 406
    .local v2, "chunkId":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v4

    .line 407
    .local v4, "flags":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v5

    int-to-long v5, v5

    add-long/2addr v5, v0

    .line 408
    .local v5, "offset":J
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    .line 409
    invoke-direct {p0, v2}, Landroidx/media3/extractor/avi/AviExtractor;->getChunkReader(I)Landroidx/media3/extractor/avi/ChunkReader;

    move-result-object v7

    .line 410
    .local v7, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    if-nez v7, :cond_0

    .line 412
    goto :goto_0

    .line 414
    :cond_0
    and-int/lit8 v8, v4, 0x10

    if-ne v8, v3, :cond_1

    .line 415
    invoke-virtual {v7, v5, v6}, Landroidx/media3/extractor/avi/ChunkReader;->appendKeyFrameToIndex(J)V

    .line 417
    :cond_1
    invoke-virtual {v7}, Landroidx/media3/extractor/avi/ChunkReader;->incrementIndexChunkCount()V

    .line 418
    .end local v2    # "chunkId":I
    .end local v4    # "flags":I
    .end local v5    # "offset":J
    .end local v7    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    goto :goto_0

    .line 419
    :cond_2
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    array-length v3, v2

    const/4 v4, 0x0

    :goto_1
    if-ge v4, v3, :cond_3

    aget-object v5, v2, v4

    .line 420
    .local v5, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    invoke-virtual {v5}, Landroidx/media3/extractor/avi/ChunkReader;->compactIndex()V

    .line 419
    .end local v5    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 422
    :cond_3
    const/4 v2, 0x1

    iput-boolean v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->seekMapHasBeenOutput:Z

    .line 423
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v3, Landroidx/media3/extractor/avi/AviExtractor$AviSeekMap;

    iget-wide v4, p0, Landroidx/media3/extractor/avi/AviExtractor;->durationUs:J

    invoke-direct {v3, p0, v4, v5}, Landroidx/media3/extractor/avi/AviExtractor$AviSeekMap;-><init>(Landroidx/media3/extractor/avi/AviExtractor;J)V

    invoke-interface {v2, v3}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 424
    return-void
.end method

.method private peekSeekOffset(Landroidx/media3/common/util/ParsableByteArray;)J
    .locals 8
    .param p1, "idx1Body"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 431
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    const/16 v1, 0x10

    const-wide/16 v2, 0x0

    if-ge v0, v1, :cond_0

    .line 433
    return-wide v2

    .line 435
    :cond_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 436
    .local v0, "startingPosition":I
    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 437
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v1

    .line 441
    .local v1, "offset":I
    int-to-long v4, v1

    iget-wide v6, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    cmp-long v4, v4, v6

    if-lez v4, :cond_1

    goto :goto_0

    :cond_1
    const-wide/16 v2, 0x8

    add-long/2addr v2, v6

    .line 442
    .local v2, "seekOffset":J
    :goto_0
    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 443
    return-wide v2
.end method

.method private processStreamList(Landroidx/media3/extractor/avi/ListChunk;I)Landroidx/media3/extractor/avi/ChunkReader;
    .locals 21
    .param p1, "streamList"    # Landroidx/media3/extractor/avi/ListChunk;
    .param p2, "streamId"    # I

    .line 497
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v9, p2

    const-class v2, Landroidx/media3/extractor/avi/AviStreamHeaderChunk;

    invoke-virtual {v1, v2}, Landroidx/media3/extractor/avi/ListChunk;->getChild(Ljava/lang/Class;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v2

    move-object v10, v2

    check-cast v10, Landroidx/media3/extractor/avi/AviStreamHeaderChunk;

    .line 498
    .local v10, "aviStreamHeaderChunk":Landroidx/media3/extractor/avi/AviStreamHeaderChunk;
    const-class v2, Landroidx/media3/extractor/avi/StreamFormatChunk;

    invoke-virtual {v1, v2}, Landroidx/media3/extractor/avi/ListChunk;->getChild(Ljava/lang/Class;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v2

    move-object v11, v2

    check-cast v11, Landroidx/media3/extractor/avi/StreamFormatChunk;

    .line 499
    .local v11, "streamFormatChunk":Landroidx/media3/extractor/avi/StreamFormatChunk;
    const-string v2, "AviExtractor"

    const/4 v3, 0x0

    if-nez v10, :cond_0

    .line 500
    const-string v4, "Missing Stream Header"

    invoke-static {v2, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    return-object v3

    .line 503
    :cond_0
    if-nez v11, :cond_1

    .line 504
    const-string v4, "Missing Stream Format"

    invoke-static {v2, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 505
    return-object v3

    .line 507
    :cond_1
    invoke-virtual {v10}, Landroidx/media3/extractor/avi/AviStreamHeaderChunk;->getDurationUs()J

    move-result-wide v12

    .line 508
    .local v12, "durationUs":J
    iget-object v14, v11, Landroidx/media3/extractor/avi/StreamFormatChunk;->format:Landroidx/media3/common/Format;

    .line 509
    .local v14, "streamFormat":Landroidx/media3/common/Format;
    invoke-virtual {v14}, Landroidx/media3/common/Format;->buildUpon()Landroidx/media3/common/Format$Builder;

    move-result-object v15

    .line 510
    .local v15, "builder":Landroidx/media3/common/Format$Builder;
    invoke-virtual {v15, v9}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    .line 511
    iget v8, v10, Landroidx/media3/extractor/avi/AviStreamHeaderChunk;->suggestedBufferSize:I

    .line 512
    .local v8, "suggestedBufferSize":I
    if-eqz v8, :cond_2

    .line 513
    invoke-virtual {v15, v8}, Landroidx/media3/common/Format$Builder;->setMaxInputSize(I)Landroidx/media3/common/Format$Builder;

    .line 515
    :cond_2
    const-class v2, Landroidx/media3/extractor/avi/StreamNameChunk;

    invoke-virtual {v1, v2}, Landroidx/media3/extractor/avi/ListChunk;->getChild(Ljava/lang/Class;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v2

    move-object v7, v2

    check-cast v7, Landroidx/media3/extractor/avi/StreamNameChunk;

    .line 516
    .local v7, "streamName":Landroidx/media3/extractor/avi/StreamNameChunk;
    if-eqz v7, :cond_3

    .line 517
    iget-object v2, v7, Landroidx/media3/extractor/avi/StreamNameChunk;->name:Ljava/lang/String;

    invoke-virtual {v15, v2}, Landroidx/media3/common/Format$Builder;->setLabel(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    .line 519
    :cond_3
    iget-object v2, v14, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    invoke-static {v2}, Landroidx/media3/common/MimeTypes;->getTrackType(Ljava/lang/String;)I

    move-result v5

    .line 520
    .local v5, "trackType":I
    const/4 v2, 0x1

    if-eq v5, v2, :cond_5

    const/4 v2, 0x2

    if-ne v5, v2, :cond_4

    goto :goto_0

    .line 530
    :cond_4
    return-object v3

    .line 521
    :cond_5
    :goto_0
    iget-object v2, v0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v2, v9, v5}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v6

    .line 522
    .local v6, "trackOutput":Landroidx/media3/extractor/TrackOutput;
    invoke-virtual {v15}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v2

    invoke-interface {v6, v2}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 523
    new-instance v16, Landroidx/media3/extractor/avi/ChunkReader;

    iget v4, v10, Landroidx/media3/extractor/avi/AviStreamHeaderChunk;->length:I

    move-object/from16 v2, v16

    move/from16 v3, p2

    move/from16 v17, v4

    move v4, v5

    move/from16 v18, v5

    move-object/from16 v19, v6

    .end local v5    # "trackType":I
    .end local v6    # "trackOutput":Landroidx/media3/extractor/TrackOutput;
    .local v18, "trackType":I
    .local v19, "trackOutput":Landroidx/media3/extractor/TrackOutput;
    move-wide v5, v12

    move-object/from16 v20, v7

    .end local v7    # "streamName":Landroidx/media3/extractor/avi/StreamNameChunk;
    .local v20, "streamName":Landroidx/media3/extractor/avi/StreamNameChunk;
    move/from16 v7, v17

    move/from16 v17, v8

    .end local v8    # "suggestedBufferSize":I
    .local v17, "suggestedBufferSize":I
    move-object/from16 v8, v19

    invoke-direct/range {v2 .. v8}, Landroidx/media3/extractor/avi/ChunkReader;-><init>(IIJILandroidx/media3/extractor/TrackOutput;)V

    .line 526
    .local v2, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    iput-wide v12, v0, Landroidx/media3/extractor/avi/AviExtractor;->durationUs:J

    .line 527
    return-object v2
.end method

.method private readMoviChunks(Landroidx/media3/extractor/ExtractorInput;)I
    .locals 8
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 457
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviEnd:J

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    .line 458
    const/4 v0, -0x1

    return v0

    .line 459
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->currentChunkReader:Landroidx/media3/extractor/avi/ChunkReader;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 460
    invoke-virtual {v0, p1}, Landroidx/media3/extractor/avi/ChunkReader;->onChunkData(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 461
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->currentChunkReader:Landroidx/media3/extractor/avi/ChunkReader;

    goto :goto_1

    .line 464
    :cond_1
    invoke-static {p1}, Landroidx/media3/extractor/avi/AviExtractor;->alignInputToEvenPosition(Landroidx/media3/extractor/ExtractorInput;)V

    .line 465
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/16 v2, 0xc

    invoke-interface {p1, v0, v1, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 466
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 467
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    .line 468
    .local v0, "chunkType":I
    const v3, 0x5453494c

    const/16 v4, 0x8

    if-ne v0, v3, :cond_3

    .line 469
    iget-object v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v3, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 470
    iget-object v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v3

    .line 471
    .local v3, "listType":I
    const v5, 0x69766f6d

    if-ne v3, v5, :cond_2

    goto :goto_0

    :cond_2
    move v2, v4

    :goto_0
    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 472
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 473
    return v1

    .line 475
    .end local v3    # "listType":I
    :cond_3
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v2

    .line 476
    .local v2, "size":I
    const v3, 0x4b4e554a    # 1.352225E7f

    if-ne v0, v3, :cond_4

    .line 477
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v3

    int-to-long v5, v2

    add-long/2addr v3, v5

    const-wide/16 v5, 0x8

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 478
    return v1

    .line 480
    :cond_4
    invoke-interface {p1, v4}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 481
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 482
    invoke-direct {p0, v0}, Landroidx/media3/extractor/avi/AviExtractor;->getChunkReader(I)Landroidx/media3/extractor/avi/ChunkReader;

    move-result-object v3

    .line 483
    .local v3, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    if-nez v3, :cond_5

    .line 485
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v4

    int-to-long v6, v2

    add-long/2addr v4, v6

    iput-wide v4, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 486
    return v1

    .line 488
    :cond_5
    invoke-virtual {v3, v2}, Landroidx/media3/extractor/avi/ChunkReader;->onChunkStart(I)V

    .line 489
    iput-object v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->currentChunkReader:Landroidx/media3/extractor/avi/ChunkReader;

    .line 492
    .end local v0    # "chunkType":I
    .end local v2    # "size":I
    .end local v3    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    :cond_6
    :goto_1
    return v1
.end method

.method private resolvePendingReposition(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)Z
    .locals 9
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 352
    const/4 v0, 0x0

    .line 353
    .local v0, "needSeek":Z
    iget-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-eqz v1, :cond_2

    .line 354
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v1

    .line 355
    .local v1, "currentPosition":J
    iget-wide v5, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    cmp-long v7, v5, v1

    if-ltz v7, :cond_1

    const-wide/32 v7, 0x40000

    add-long/2addr v7, v1

    cmp-long v7, v5, v7

    if-lez v7, :cond_0

    goto :goto_0

    .line 362
    :cond_0
    sub-long/2addr v5, v1

    long-to-int v5, v5

    invoke-interface {p1, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    goto :goto_1

    .line 357
    :cond_1
    :goto_0
    iput-wide v5, p2, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 358
    const/4 v0, 0x1

    .line 365
    .end local v1    # "currentPosition":J
    :cond_2
    :goto_1
    iput-wide v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 366
    return v0
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 2
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 196
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 197
    nop

    .line 198
    iget-boolean v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->parseSubtitlesDuringExtraction:Z

    if-eqz v0, :cond_0

    .line 199
    new-instance v0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;

    iget-object v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v0, p1, v1}, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;-><init>(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    goto :goto_0

    .line 200
    :cond_0
    move-object v0, p1

    :goto_0
    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 201
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 202
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 13
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 217
    invoke-direct {p0, p1, p2}, Landroidx/media3/extractor/avi/AviExtractor;->resolvePendingReposition(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 218
    return v1

    .line 220
    :cond_0
    iget v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    const/4 v2, 0x0

    const/4 v3, 0x6

    const/4 v4, 0x4

    const/16 v5, 0xc

    const/4 v6, 0x0

    packed-switch v0, :pswitch_data_0

    .line 314
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 312
    :pswitch_0
    invoke-direct {p0, p1}, Landroidx/media3/extractor/avi/AviExtractor;->readMoviChunks(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    return v0

    .line 305
    :pswitch_1
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    iget v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->idx1BodySize:I

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 306
    .local v0, "idx1Body":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    iget v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->idx1BodySize:I

    invoke-interface {p1, v1, v6, v2}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 307
    invoke-direct {p0, v0}, Landroidx/media3/extractor/avi/AviExtractor;->parseIdx1Body(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 308
    iput v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 309
    iget-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    iput-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 310
    return v6

    .line 292
    .end local v0    # "idx1Body":Landroidx/media3/common/util/ParsableByteArray;
    :pswitch_2
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/16 v1, 0x8

    invoke-interface {p1, v0, v6, v1}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 293
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 294
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    .line 295
    .local v0, "idx1Fourcc":I
    iget-object v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v1

    .line 296
    .local v1, "boxSize":I
    const v2, 0x31786469

    if-ne v0, v2, :cond_1

    .line 297
    const/4 v2, 0x5

    iput v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 298
    iput v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->idx1BodySize:I

    goto :goto_0

    .line 301
    :cond_1
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v2

    int-to-long v4, v1

    add-long/2addr v2, v4

    iput-wide v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 303
    :goto_0
    return v6

    .line 253
    .end local v0    # "idx1Fourcc":I
    .end local v1    # "boxSize":I
    :pswitch_3
    iget-wide v7, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    const-wide/16 v9, -0x1

    cmp-long v0, v7, v9

    if-eqz v0, :cond_2

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v7

    iget-wide v9, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    cmp-long v0, v7, v9

    if-eqz v0, :cond_2

    .line 254
    iput-wide v9, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 255
    return v6

    .line 257
    :cond_2
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-interface {p1, v0, v6, v5}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 258
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 259
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 260
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v2}, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->populateFrom(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 261
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    .line 262
    .local v0, "listType":I
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v2, v2, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->chunkType:I

    const v7, 0x46464952

    if-ne v2, v7, :cond_3

    .line 265
    invoke-interface {p1, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 266
    return v6

    .line 268
    :cond_3
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v2, v2, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->chunkType:I

    const v5, 0x5453494c

    const-wide/16 v7, 0x8

    if-ne v2, v5, :cond_7

    const v2, 0x69766f6d

    if-eq v0, v2, :cond_4

    goto :goto_1

    .line 273
    :cond_4
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v9

    iput-wide v9, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviStart:J

    .line 275
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v2, v2, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->size:I

    int-to-long v11, v2

    add-long/2addr v9, v11

    add-long/2addr v9, v7

    iput-wide v9, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviEnd:J

    .line 276
    iget-boolean v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->seekMapHasBeenOutput:Z

    if-nez v2, :cond_6

    .line 277
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->aviHeader:Landroidx/media3/extractor/avi/AviMainHeaderChunk;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/avi/AviMainHeaderChunk;

    invoke-virtual {v2}, Landroidx/media3/extractor/avi/AviMainHeaderChunk;->hasIndex()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 278
    iput v4, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 279
    iget-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->moviEnd:J

    iput-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 280
    return v6

    .line 282
    :cond_5
    iget-object v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v4, Landroidx/media3/extractor/SeekMap$Unseekable;

    iget-wide v7, p0, Landroidx/media3/extractor/avi/AviExtractor;->durationUs:J

    invoke-direct {v4, v7, v8}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {v2, v4}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 283
    iput-boolean v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->seekMapHasBeenOutput:Z

    .line 288
    :cond_6
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v1

    const-wide/16 v4, 0xc

    add-long/2addr v1, v4

    iput-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 289
    iput v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 290
    return v6

    .line 270
    :cond_7
    :goto_1
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v1

    iget-object v3, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v3, v3, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->size:I

    int-to-long v3, v3

    add-long/2addr v1, v3

    add-long/2addr v1, v7

    iput-wide v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 271
    return v6

    .line 246
    .end local v0    # "listType":I
    :pswitch_4
    iget v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->hdrlSize:I

    sub-int/2addr v0, v4

    .line 247
    .local v0, "bytesToRead":I
    new-instance v1, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v1, v0}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 248
    .local v1, "hdrlBody":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    invoke-interface {p1, v2, v6, v0}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 249
    invoke-direct {p0, v1}, Landroidx/media3/extractor/avi/AviExtractor;->parseHdrlBody(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 250
    const/4 v2, 0x3

    iput v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 251
    return v6

    .line 233
    .end local v0    # "bytesToRead":I
    .end local v1    # "hdrlBody":Landroidx/media3/common/util/ParsableByteArray;
    :pswitch_5
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-interface {p1, v0, v6, v5}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 234
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 235
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget-object v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v1}, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->populateWithListHeaderFrom(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 236
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v0, v0, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->listType:I

    const v1, 0x6c726468

    if-ne v0, v1, :cond_8

    .line 241
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v0, v0, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->size:I

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->hdrlSize:I

    .line 242
    const/4 v0, 0x2

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 243
    return v6

    .line 237
    :cond_8
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "hdrl expected, found: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkHeaderHolder:Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;

    iget v1, v1, Landroidx/media3/extractor/avi/AviExtractor$ChunkHeaderHolder;->listType:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v2}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 224
    :pswitch_6
    invoke-virtual {p0, p1}, Landroidx/media3/extractor/avi/AviExtractor;->sniff(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 225
    invoke-interface {p1, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 230
    iput v1, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 231
    return v6

    .line 227
    :cond_9
    const-string v0, "AVI Header List not found"

    invoke-static {v0, v2}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public release()V
    .locals 0

    .line 340
    return-void
.end method

.method public seek(JJ)V
    .locals 5
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 320
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->pendingReposition:J

    .line 321
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->currentChunkReader:Landroidx/media3/extractor/avi/ChunkReader;

    .line 322
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    array-length v1, v0

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v1, :cond_0

    aget-object v4, v0, v3

    .line 323
    .local v4, "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    invoke-virtual {v4, p1, p2}, Landroidx/media3/extractor/avi/ChunkReader;->seekToPosition(J)V

    .line 322
    .end local v4    # "chunkReader":Landroidx/media3/extractor/avi/ChunkReader;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 325
    :cond_0
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-nez v0, :cond_2

    .line 326
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->chunkReaders:[Landroidx/media3/extractor/avi/ChunkReader;

    array-length v0, v0

    if-nez v0, :cond_1

    .line 328
    iput v2, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    goto :goto_1

    .line 330
    :cond_1
    const/4 v0, 0x3

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 332
    :goto_1
    return-void

    .line 334
    :cond_2
    const/4 v0, 0x6

    iput v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->state:I

    .line 335
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 3
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 206
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/16 v1, 0xc

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 207
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 208
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    const v1, 0x46464952

    if-eq v0, v1, :cond_0

    .line 209
    return v2

    .line 211
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 212
    iget-object v0, p0, Landroidx/media3/extractor/avi/AviExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    const v1, 0x20495641

    if-ne v0, v1, :cond_1

    const/4 v2, 0x1

    :cond_1
    return v2
.end method
