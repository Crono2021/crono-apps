.class public final Landroidx/media3/extractor/mp3/Mp3Extractor;
.super Ljava/lang/Object;
.source "Mp3Extractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/mp3/Mp3Extractor$Flags;
    }
.end annotation


# static fields
.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

.field public static final FLAG_DISABLE_ID3_METADATA:I = 0x8

.field public static final FLAG_ENABLE_CONSTANT_BITRATE_SEEKING:I = 0x1

.field public static final FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS:I = 0x2

.field public static final FLAG_ENABLE_INDEX_SEEKING:I = 0x4

.field private static final MAX_SNIFF_BYTES:I = 0x8000

.field private static final MAX_SYNC_BYTES:I = 0x20000

.field private static final MPEG_AUDIO_HEADER_MASK:I = -0x1f400

.field private static final REQUIRED_ID3_FRAME_PREDICATE:Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;

.field private static final SCRATCH_LENGTH:I = 0xa

.field private static final SEEK_HEADER_INFO:I = 0x496e666f

.field private static final SEEK_HEADER_UNSET:I = 0x0

.field private static final SEEK_HEADER_VBRI:I = 0x56425249

.field private static final SEEK_HEADER_XING:I = 0x58696e67


# instance fields
.field private basisTimeUs:J

.field private currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

.field private disableSeeking:Z

.field private extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private firstSamplePosition:J

.field private final flags:I

.field private final forcedFirstSampleTimestampUs:J

.field private final gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

.field private final id3Peeker:Landroidx/media3/extractor/Id3Peeker;

.field private isSeekInProgress:Z

.field private metadata:Landroidx/media3/common/Metadata;

.field private realTrackOutput:Landroidx/media3/extractor/TrackOutput;

.field private sampleBytesRemaining:I

.field private samplesRead:J

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private seekTimeUs:J

.field private seeker:Landroidx/media3/extractor/mp3/Seeker;

.field private final skippingTrackOutput:Landroidx/media3/extractor/TrackOutput;

.field private final synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

.field private synchronizedHeaderData:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 62
    new-instance v0, Landroidx/media3/extractor/mp3/Mp3Extractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/extractor/mp3/Mp3Extractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    .line 126
    new-instance v0, Landroidx/media3/extractor/mp3/Mp3Extractor$$ExternalSyntheticLambda1;

    invoke-direct {v0}, Landroidx/media3/extractor/mp3/Mp3Extractor$$ExternalSyntheticLambda1;-><init>()V

    sput-object v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->REQUIRED_ID3_FRAME_PREDICATE:Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 182
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/extractor/mp3/Mp3Extractor;-><init>(I)V

    .line 183
    return-void
.end method

.method public constructor <init>(I)V
    .locals 2
    .param p1, "flags"    # I

    .line 189
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    invoke-direct {p0, p1, v0, v1}, Landroidx/media3/extractor/mp3/Mp3Extractor;-><init>(IJ)V

    .line 190
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 2
    .param p1, "flags"    # I
    .param p2, "forcedFirstSampleTimestampUs"    # J

    .line 197
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 198
    and-int/lit8 v0, p1, 0x2

    if-eqz v0, :cond_0

    .line 199
    or-int/lit8 p1, p1, 0x1

    .line 201
    :cond_0
    iput p1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    .line 202
    iput-wide p2, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->forcedFirstSampleTimestampUs:J

    .line 203
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 204
    new-instance v0, Landroidx/media3/extractor/MpegAudioUtil$Header;

    invoke-direct {v0}, Landroidx/media3/extractor/MpegAudioUtil$Header;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    .line 205
    new-instance v0, Landroidx/media3/extractor/GaplessInfoHolder;

    invoke-direct {v0}, Landroidx/media3/extractor/GaplessInfoHolder;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    .line 206
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    .line 207
    new-instance v0, Landroidx/media3/extractor/Id3Peeker;

    invoke-direct {v0}, Landroidx/media3/extractor/Id3Peeker;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->id3Peeker:Landroidx/media3/extractor/Id3Peeker;

    .line 208
    new-instance v0, Landroidx/media3/extractor/DummyTrackOutput;

    invoke-direct {v0}, Landroidx/media3/extractor/DummyTrackOutput;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->skippingTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 209
    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 210
    return-void
.end method

.method private assertInitialized()V
    .locals 1
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/EnsuresNonNull;
        value = {
            "extractorOutput",
            "realTrackOutput"
        }
    .end annotation

    .line 590
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->realTrackOutput:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 591
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 592
    return-void
.end method

.method private computeSeeker(Landroidx/media3/extractor/ExtractorInput;)Landroidx/media3/extractor/mp3/Seeker;
    .locals 16
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 461
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->maybeReadSeekFrame(Landroidx/media3/extractor/ExtractorInput;)Landroidx/media3/extractor/mp3/Seeker;

    move-result-object v1

    .line 462
    .local v1, "seekFrameSeeker":Landroidx/media3/extractor/mp3/Seeker;
    iget-object v2, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->metadata:Landroidx/media3/common/Metadata;

    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Landroidx/media3/extractor/mp3/Mp3Extractor;->maybeHandleSeekMetadata(Landroidx/media3/common/Metadata;J)Landroidx/media3/extractor/mp3/MlltSeeker;

    move-result-object v2

    .line 464
    .local v2, "metadataSeeker":Landroidx/media3/extractor/mp3/Seeker;
    iget-boolean v3, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->disableSeeking:Z

    if-eqz v3, :cond_0

    .line 465
    new-instance v3, Landroidx/media3/extractor/mp3/Seeker$UnseekableSeeker;

    invoke-direct {v3}, Landroidx/media3/extractor/mp3/Seeker$UnseekableSeeker;-><init>()V

    return-object v3

    .line 468
    :cond_0
    const/4 v3, 0x0

    .line 469
    .local v3, "resultSeeker":Landroidx/media3/extractor/mp3/Seeker;
    iget v4, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    and-int/lit8 v4, v4, 0x4

    if-eqz v4, :cond_3

    .line 471
    const-wide/16 v4, -0x1

    .line 472
    .local v4, "dataEndPosition":J
    if-eqz v2, :cond_1

    .line 473
    invoke-interface {v2}, Landroidx/media3/extractor/mp3/Seeker;->getDurationUs()J

    move-result-wide v6

    .line 474
    .local v6, "durationUs":J
    invoke-interface {v2}, Landroidx/media3/extractor/mp3/Seeker;->getDataEndPosition()J

    move-result-wide v4

    goto :goto_0

    .line 475
    .end local v6    # "durationUs":J
    :cond_1
    if-eqz v1, :cond_2

    .line 476
    invoke-interface {v1}, Landroidx/media3/extractor/mp3/Seeker;->getDurationUs()J

    move-result-wide v6

    .line 477
    .restart local v6    # "durationUs":J
    invoke-interface {v1}, Landroidx/media3/extractor/mp3/Seeker;->getDataEndPosition()J

    move-result-wide v4

    goto :goto_0

    .line 479
    .end local v6    # "durationUs":J
    :cond_2
    iget-object v6, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->metadata:Landroidx/media3/common/Metadata;

    invoke-static {v6}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getId3TlenUs(Landroidx/media3/common/Metadata;)J

    move-result-wide v6

    .line 481
    .restart local v6    # "durationUs":J
    :goto_0
    new-instance v15, Landroidx/media3/extractor/mp3/IndexSeeker;

    .line 483
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v11

    move-object v8, v15

    move-wide v9, v6

    move-wide v13, v4

    invoke-direct/range {v8 .. v14}, Landroidx/media3/extractor/mp3/IndexSeeker;-><init>(JJJ)V

    move-object v3, v15

    .line 484
    .end local v4    # "dataEndPosition":J
    .end local v6    # "durationUs":J
    goto :goto_1

    :cond_3
    if-eqz v2, :cond_4

    .line 485
    move-object v3, v2

    goto :goto_1

    .line 486
    :cond_4
    if-eqz v1, :cond_5

    .line 487
    move-object v3, v1

    .line 490
    :cond_5
    :goto_1
    const/4 v4, 0x1

    if-eqz v3, :cond_7

    .line 491
    invoke-interface {v3}, Landroidx/media3/extractor/mp3/Seeker;->isSeekable()Z

    move-result v5

    if-nez v5, :cond_6

    iget v5, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    and-int/2addr v5, v4

    if-eqz v5, :cond_6

    goto :goto_2

    .line 497
    :cond_6
    move-object/from16 v5, p1

    goto :goto_4

    .line 492
    :cond_7
    :goto_2
    iget v5, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    and-int/lit8 v5, v5, 0x2

    if-eqz v5, :cond_8

    goto :goto_3

    :cond_8
    const/4 v4, 0x0

    .line 493
    :goto_3
    move-object/from16 v5, p1

    invoke-direct {v0, v5, v4}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getConstantBitrateSeeker(Landroidx/media3/extractor/ExtractorInput;Z)Landroidx/media3/extractor/mp3/Seeker;

    move-result-object v3

    .line 497
    :goto_4
    return-object v3
.end method

.method private computeTimeUs(J)J
    .locals 6
    .param p1, "samplesRead"    # J

    .line 361
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    const-wide/32 v2, 0xf4240

    mul-long/2addr v2, p1

    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v4, v4, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    int-to-long v4, v4

    div-long/2addr v2, v4

    add-long/2addr v0, v2

    return-wide v0
.end method

.method private getConstantBitrateSeeker(Landroidx/media3/extractor/ExtractorInput;JZ)Landroidx/media3/extractor/mp3/Seeker;
    .locals 9
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "streamLengthFallback"    # J
    .param p4, "allowSeeksIfLengthUnknown"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 578
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/4 v1, 0x4

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 579
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 580
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/media3/extractor/MpegAudioUtil$Header;->setForHeaderData(I)Z

    .line 581
    new-instance v0, Landroidx/media3/extractor/mp3/ConstantBitrateSeeker;

    .line 582
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v1

    const-wide/16 v3, -0x1

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v1

    move-wide v3, v1

    goto :goto_0

    :cond_0
    move-wide v3, p2

    .line 583
    :goto_0
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v5

    iget-object v7, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    move-object v2, v0

    move v8, p4

    invoke-direct/range {v2 .. v8}, Landroidx/media3/extractor/mp3/ConstantBitrateSeeker;-><init>(JJLandroidx/media3/extractor/MpegAudioUtil$Header;Z)V

    .line 581
    return-object v0
.end method

.method private getConstantBitrateSeeker(Landroidx/media3/extractor/ExtractorInput;Z)Landroidx/media3/extractor/mp3/Seeker;
    .locals 2
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "allowSeeksIfLengthUnknown"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 566
    const-wide/16 v0, -0x1

    invoke-direct {p0, p1, v0, v1, p2}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getConstantBitrateSeeker(Landroidx/media3/extractor/ExtractorInput;JZ)Landroidx/media3/extractor/mp3/Seeker;

    move-result-object v0

    return-object v0
.end method

.method private static getId3TlenUs(Landroidx/media3/common/Metadata;)J
    .locals 5
    .param p0, "metadata"    # Landroidx/media3/common/Metadata;

    .line 637
    if-eqz p0, :cond_1

    .line 638
    invoke-virtual {p0}, Landroidx/media3/common/Metadata;->length()I

    move-result v0

    .line 639
    .local v0, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 640
    invoke-virtual {p0, v1}, Landroidx/media3/common/Metadata;->get(I)Landroidx/media3/common/Metadata$Entry;

    move-result-object v2

    .line 641
    .local v2, "entry":Landroidx/media3/common/Metadata$Entry;
    instance-of v3, v2, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    if-eqz v3, :cond_0

    move-object v3, v2

    check-cast v3, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    iget-object v3, v3, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;->id:Ljava/lang/String;

    .line 642
    const-string v4, "TLEN"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 643
    move-object v3, v2

    check-cast v3, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;

    iget-object v3, v3, Landroidx/media3/extractor/metadata/id3/TextInformationFrame;->values:Lcom/google/common/collect/ImmutableList;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    invoke-static {v3, v4}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v3

    return-wide v3

    .line 639
    .end local v2    # "entry":Landroidx/media3/common/Metadata$Entry;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 647
    .end local v0    # "length":I
    .end local v1    # "i":I
    :cond_1
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    return-wide v0
.end method

.method private static getSeekFrameHeader(Landroidx/media3/common/util/ParsableByteArray;I)I
    .locals 2
    .param p0, "frame"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "xingBase"    # I

    .line 605
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v0

    add-int/lit8 v1, p1, 0x4

    if-lt v0, v1, :cond_1

    .line 606
    invoke-virtual {p0, p1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 607
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 608
    .local v0, "headerData":I
    const v1, 0x58696e67

    if-eq v0, v1, :cond_0

    const v1, 0x496e666f

    if-ne v0, v1, :cond_1

    .line 609
    :cond_0
    return v0

    .line 612
    .end local v0    # "headerData":I
    :cond_1
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v0

    const/16 v1, 0x28

    if-lt v0, v1, :cond_2

    .line 613
    const/16 v0, 0x24

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 614
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    const v1, 0x56425249

    if-ne v0, v1, :cond_2

    .line 615
    return v1

    .line 618
    :cond_2
    const/4 v0, 0x0

    return v0
.end method

.method private static headersMatch(IJ)Z
    .locals 4
    .param p0, "headerA"    # I
    .param p1, "headerB"    # J

    .line 596
    const v0, -0x1f400

    and-int/2addr v0, p0

    int-to-long v0, v0

    const-wide/32 v2, -0x1f400

    and-long/2addr v2, p1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method static synthetic lambda$static$0()[Landroidx/media3/extractor/Extractor;
    .locals 3

    .line 62
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/mp3/Mp3Extractor;

    invoke-direct {v1}, Landroidx/media3/extractor/mp3/Mp3Extractor;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method static synthetic lambda$static$1(IIIII)Z
    .locals 3
    .param p0, "majorVersion"    # I
    .param p1, "id0"    # I
    .param p2, "id1"    # I
    .param p3, "id2"    # I
    .param p4, "id3"    # I

    .line 128
    const/16 v0, 0x43

    const/4 v1, 0x2

    const/16 v2, 0x4d

    if-ne p1, v0, :cond_0

    const/16 v0, 0x4f

    if-ne p2, v0, :cond_0

    if-ne p3, v2, :cond_0

    if-eq p4, v2, :cond_1

    if-eq p0, v1, :cond_1

    :cond_0
    if-ne p1, v2, :cond_2

    const/16 v0, 0x4c

    if-ne p2, v0, :cond_2

    if-ne p3, v0, :cond_2

    const/16 v0, 0x54

    if-eq p4, v0, :cond_1

    if-ne p0, v1, :cond_2

    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static maybeHandleSeekMetadata(Landroidx/media3/common/Metadata;J)Landroidx/media3/extractor/mp3/MlltSeeker;
    .locals 6
    .param p0, "metadata"    # Landroidx/media3/common/Metadata;
    .param p1, "firstFramePosition"    # J

    .line 624
    if-eqz p0, :cond_1

    .line 625
    invoke-virtual {p0}, Landroidx/media3/common/Metadata;->length()I

    move-result v0

    .line 626
    .local v0, "length":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 627
    invoke-virtual {p0, v1}, Landroidx/media3/common/Metadata;->get(I)Landroidx/media3/common/Metadata$Entry;

    move-result-object v2

    .line 628
    .local v2, "entry":Landroidx/media3/common/Metadata$Entry;
    instance-of v3, v2, Landroidx/media3/extractor/metadata/id3/MlltFrame;

    if-eqz v3, :cond_0

    .line 629
    move-object v3, v2

    check-cast v3, Landroidx/media3/extractor/metadata/id3/MlltFrame;

    invoke-static {p0}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getId3TlenUs(Landroidx/media3/common/Metadata;)J

    move-result-wide v4

    invoke-static {p1, p2, v3, v4, v5}, Landroidx/media3/extractor/mp3/MlltSeeker;->create(JLandroidx/media3/extractor/metadata/id3/MlltFrame;J)Landroidx/media3/extractor/mp3/MlltSeeker;

    move-result-object v3

    return-object v3

    .line 626
    .end local v2    # "entry":Landroidx/media3/common/Metadata$Entry;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 633
    .end local v0    # "length":I
    .end local v1    # "i":I
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method private maybeReadSeekFrame(Landroidx/media3/extractor/ExtractorInput;)Landroidx/media3/extractor/mp3/Seeker;
    .locals 11
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 512
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 513
    .local v0, "frame":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    iget-object v2, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v2, v2, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    const/4 v3, 0x0

    invoke-interface {p1, v1, v3, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 515
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->version:I

    const/4 v2, 0x1

    and-int/2addr v1, v2

    const/16 v4, 0x15

    if-eqz v1, :cond_0

    .line 516
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->channels:I

    if-eq v1, v2, :cond_2

    const/16 v4, 0x24

    goto :goto_0

    .line 517
    :cond_0
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->channels:I

    if-eq v1, v2, :cond_1

    goto :goto_0

    :cond_1
    const/16 v4, 0xd

    :cond_2
    :goto_0
    move v1, v4

    .line 518
    .local v1, "xingBase":I
    invoke-static {v0, v1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getSeekFrameHeader(Landroidx/media3/common/util/ParsableByteArray;I)I

    move-result v8

    .line 520
    .local v8, "seekHeader":I
    sparse-switch v8, :sswitch_data_0

    .line 557
    const/4 v2, 0x0

    .line 558
    .local v2, "seeker":Landroidx/media3/extractor/mp3/Seeker;
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    goto/16 :goto_2

    .line 550
    .end local v2    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    :sswitch_0
    nop

    .line 551
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v2

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v4

    iget-object v6, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    move-object v7, v0

    invoke-static/range {v2 .. v7}, Landroidx/media3/extractor/mp3/VbriSeeker;->create(JJLandroidx/media3/extractor/MpegAudioUtil$Header;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp3/VbriSeeker;

    move-result-object v2

    .line 552
    .restart local v2    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    iget-object v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v3, v3, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    invoke-interface {p1, v3}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 553
    goto :goto_2

    .line 523
    .end local v2    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    :sswitch_1
    iget-object v2, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    invoke-static {v2, v0}, Landroidx/media3/extractor/mp3/XingFrame;->parse(Landroidx/media3/extractor/MpegAudioUtil$Header;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp3/XingFrame;

    move-result-object v2

    .line 524
    .local v2, "xingFrame":Landroidx/media3/extractor/mp3/XingFrame;
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    invoke-virtual {v4}, Landroidx/media3/extractor/GaplessInfoHolder;->hasGaplessInfo()Z

    move-result v4

    if-nez v4, :cond_3

    iget v4, v2, Landroidx/media3/extractor/mp3/XingFrame;->encoderDelay:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_3

    iget v4, v2, Landroidx/media3/extractor/mp3/XingFrame;->encoderPadding:I

    if-eq v4, v5, :cond_3

    .line 527
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    iget v5, v2, Landroidx/media3/extractor/mp3/XingFrame;->encoderDelay:I

    iput v5, v4, Landroidx/media3/extractor/GaplessInfoHolder;->encoderDelay:I

    .line 528
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    iget v5, v2, Landroidx/media3/extractor/mp3/XingFrame;->encoderPadding:I

    iput v5, v4, Landroidx/media3/extractor/GaplessInfoHolder;->encoderPadding:I

    .line 530
    :cond_3
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v4

    .line 531
    .local v4, "startPosition":J
    iget-object v6, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v6, v6, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    invoke-interface {p1, v6}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 536
    const v6, 0x58696e67

    if-ne v8, v6, :cond_4

    .line 537
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v6

    invoke-static {v6, v7, v2, v4, v5}, Landroidx/media3/extractor/mp3/XingSeeker;->create(JLandroidx/media3/extractor/mp3/XingFrame;J)Landroidx/media3/extractor/mp3/XingSeeker;

    move-result-object v3

    move-object v2, v3

    .local v3, "seeker":Landroidx/media3/extractor/mp3/Seeker;
    goto :goto_2

    .line 540
    .end local v3    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    :cond_4
    iget-wide v6, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    const-wide/16 v9, -0x1

    cmp-long v6, v6, v9

    if-eqz v6, :cond_5

    .line 541
    iget-wide v6, v2, Landroidx/media3/extractor/mp3/XingFrame;->dataSize:J

    add-long v9, v4, v6

    goto :goto_1

    .line 542
    :cond_5
    nop

    :goto_1
    move-wide v6, v9

    .line 545
    .local v6, "streamLength":J
    nop

    .line 546
    invoke-direct {p0, p1, v6, v7, v3}, Landroidx/media3/extractor/mp3/Mp3Extractor;->getConstantBitrateSeeker(Landroidx/media3/extractor/ExtractorInput;JZ)Landroidx/media3/extractor/mp3/Seeker;

    move-result-object v3

    .line 548
    .end local v6    # "streamLength":J
    .restart local v3    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    move-object v2, v3

    .line 560
    .end local v3    # "seeker":Landroidx/media3/extractor/mp3/Seeker;
    .end local v4    # "startPosition":J
    .local v2, "seeker":Landroidx/media3/extractor/mp3/Seeker;
    :goto_2
    return-object v2

    :sswitch_data_0
    .sparse-switch
        0x496e666f -> :sswitch_1
        0x56425249 -> :sswitch_0
        0x58696e67 -> :sswitch_1
    .end sparse-switch
.end method

.method private peekEndOfStreamOrHeader(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 8
    .param p1, "extractorInput"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 443
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 444
    invoke-interface {v0}, Landroidx/media3/extractor/mp3/Seeker;->getDataEndPosition()J

    move-result-wide v2

    .line 445
    .local v2, "dataEndPosition":J
    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    .line 446
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v4

    const-wide/16 v6, 0x4

    sub-long v6, v2, v6

    cmp-long v0, v4, v6

    if-lez v0, :cond_0

    .line 447
    return v1

    .line 451
    .end local v2    # "dataEndPosition":J
    :cond_0
    :try_start_0
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 452
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 451
    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-interface {p1, v0, v2, v3, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v0
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    xor-int/2addr v0, v1

    return v0

    .line 453
    :catch_0
    move-exception v0

    .line 454
    .local v0, "e":Ljava/io/EOFException;
    return v1
.end method

.method private readInternal(Landroidx/media3/extractor/ExtractorInput;)I
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "extractorOutput",
            "realTrackOutput"
        }
    .end annotation

    .line 273
    iget v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeaderData:I

    if-nez v0, :cond_0

    .line 275
    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0, p1, v0}, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronize(Landroidx/media3/extractor/ExtractorInput;Z)Z
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    .line 278
    goto :goto_0

    .line 276
    :catch_0
    move-exception v0

    .line 277
    .local v0, "e":Ljava/io/EOFException;
    const/4 v1, -0x1

    return v1

    .line 280
    .end local v0    # "e":Ljava/io/EOFException;
    :cond_0
    :goto_0
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    if-nez v0, :cond_3

    .line 281
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->computeSeeker(Landroidx/media3/extractor/ExtractorInput;)Landroidx/media3/extractor/mp3/Seeker;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    .line 282
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v1, v0}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 283
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget-object v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->mimeType:Ljava/lang/String;

    .line 285
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 286
    const/16 v1, 0x1000

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setMaxInputSize(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->channels:I

    .line 287
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v1, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    .line 288
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    iget v1, v1, Landroidx/media3/extractor/GaplessInfoHolder;->encoderDelay:I

    .line 289
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setEncoderDelay(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    iget v1, v1, Landroidx/media3/extractor/GaplessInfoHolder;->encoderPadding:I

    .line 290
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setEncoderPadding(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 291
    iget v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    and-int/lit8 v1, v1, 0x8

    if-eqz v1, :cond_1

    const/4 v1, 0x0

    goto :goto_1

    :cond_1
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->metadata:Landroidx/media3/common/Metadata;

    :goto_1
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setMetadata(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 292
    .local v0, "format":Landroidx/media3/common/Format$Builder;
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    invoke-interface {v1}, Landroidx/media3/extractor/mp3/Seeker;->getAverageBitrate()I

    move-result v1

    const v2, -0x7fffffff

    if-eq v1, v2, :cond_2

    .line 293
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    invoke-interface {v1}, Landroidx/media3/extractor/mp3/Seeker;->getAverageBitrate()I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setAverageBitrate(I)Landroidx/media3/common/Format$Builder;

    .line 295
    :cond_2
    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v2

    invoke-interface {v1, v2}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 296
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v1

    iput-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->firstSamplePosition:J

    .end local v0    # "format":Landroidx/media3/common/Format$Builder;
    goto :goto_2

    .line 297
    :cond_3
    iget-wide v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->firstSamplePosition:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_4

    .line 298
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    .line 299
    .local v0, "inputPosition":J
    iget-wide v2, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->firstSamplePosition:J

    cmp-long v4, v0, v2

    if-gez v4, :cond_5

    .line 301
    sub-long/2addr v2, v0

    long-to-int v2, v2

    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    goto :goto_3

    .line 297
    .end local v0    # "inputPosition":J
    :cond_4
    :goto_2
    nop

    .line 304
    :cond_5
    :goto_3
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->readSample(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    return v0
.end method

.method private readSample(Landroidx/media3/extractor/ExtractorInput;)I
    .locals 11
    .param p1, "extractorInput"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "realTrackOutput",
            "seeker"
        }
    .end annotation

    .line 309
    iget v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    const/4 v1, 0x1

    const/4 v2, -0x1

    const/4 v3, 0x0

    if-nez v0, :cond_4

    .line 310
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 311
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->peekEndOfStreamOrHeader(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 312
    return v2

    .line 314
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 315
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 316
    .local v0, "sampleHeaderData":I
    iget v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeaderData:I

    int-to-long v4, v4

    invoke-static {v0, v4, v5}, Landroidx/media3/extractor/mp3/Mp3Extractor;->headersMatch(IJ)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 317
    invoke-static {v0}, Landroidx/media3/extractor/MpegAudioUtil;->getFrameSize(I)I

    move-result v4

    if-ne v4, v2, :cond_1

    goto :goto_0

    .line 323
    :cond_1
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    invoke-virtual {v4, v0}, Landroidx/media3/extractor/MpegAudioUtil$Header;->setForHeaderData(I)Z

    .line 324
    iget-wide v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    const-wide v6, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v4, v4, v6

    if-nez v4, :cond_2

    .line 325
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v8

    invoke-interface {v4, v8, v9}, Landroidx/media3/extractor/mp3/Seeker;->getTimeUs(J)J

    move-result-wide v4

    iput-wide v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    .line 326
    iget-wide v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->forcedFirstSampleTimestampUs:J

    cmp-long v4, v4, v6

    if-eqz v4, :cond_2

    .line 327
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    const-wide/16 v5, 0x0

    invoke-interface {v4, v5, v6}, Landroidx/media3/extractor/mp3/Seeker;->getTimeUs(J)J

    move-result-wide v4

    .line 328
    .local v4, "embeddedFirstSampleTimestampUs":J
    iget-wide v6, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    iget-wide v8, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->forcedFirstSampleTimestampUs:J

    sub-long/2addr v8, v4

    add-long/2addr v6, v8

    iput-wide v6, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    .line 331
    .end local v4    # "embeddedFirstSampleTimestampUs":J
    :cond_2
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v4, v4, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    iput v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    .line 332
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    instance-of v5, v4, Landroidx/media3/extractor/mp3/IndexSeeker;

    if-eqz v5, :cond_4

    .line 333
    check-cast v4, Landroidx/media3/extractor/mp3/IndexSeeker;

    .line 336
    .local v4, "indexSeeker":Landroidx/media3/extractor/mp3/IndexSeeker;
    iget-wide v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    iget-object v7, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v7, v7, Landroidx/media3/extractor/MpegAudioUtil$Header;->samplesPerFrame:I

    int-to-long v7, v7

    add-long/2addr v5, v7

    .line 337
    invoke-direct {p0, v5, v6}, Landroidx/media3/extractor/mp3/Mp3Extractor;->computeTimeUs(J)J

    move-result-wide v5

    .line 338
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v7

    iget-object v9, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v9, v9, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    int-to-long v9, v9

    add-long/2addr v7, v9

    .line 336
    invoke-virtual {v4, v5, v6, v7, v8}, Landroidx/media3/extractor/mp3/IndexSeeker;->maybeAddSeekPoint(JJ)V

    .line 339
    iget-boolean v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->isSeekInProgress:Z

    if-eqz v5, :cond_4

    iget-wide v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seekTimeUs:J

    invoke-virtual {v4, v5, v6}, Landroidx/media3/extractor/mp3/IndexSeeker;->isTimeUsInIndex(J)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 340
    iput-boolean v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->isSeekInProgress:Z

    .line 341
    iget-object v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->realTrackOutput:Landroidx/media3/extractor/TrackOutput;

    iput-object v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    goto :goto_1

    .line 319
    .end local v4    # "indexSeeker":Landroidx/media3/extractor/mp3/IndexSeeker;
    :cond_3
    :goto_0
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 320
    iput v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeaderData:I

    .line 321
    return v3

    .line 345
    .end local v0    # "sampleHeaderData":I
    :cond_4
    :goto_1
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    iget v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    invoke-interface {v0, p1, v4, v1}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/DataReader;IZ)I

    move-result v0

    .line 346
    .local v0, "bytesAppended":I
    if-ne v0, v2, :cond_5

    .line 347
    return v2

    .line 349
    :cond_5
    iget v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    sub-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    .line 350
    if-lez v1, :cond_6

    .line 351
    return v3

    .line 353
    :cond_6
    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    iget-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    .line 354
    invoke-direct {p0, v1, v2}, Landroidx/media3/extractor/mp3/Mp3Extractor;->computeTimeUs(J)J

    move-result-wide v5

    const/4 v7, 0x1

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v8, v1, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    const/4 v9, 0x0

    const/4 v10, 0x0

    .line 353
    invoke-interface/range {v4 .. v10}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 355
    iget-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v4, v4, Landroidx/media3/extractor/MpegAudioUtil$Header;->samplesPerFrame:I

    int-to-long v4, v4

    add-long/2addr v1, v4

    iput-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    .line 356
    iput v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    .line 357
    return v3
.end method

.method private synchronize(Landroidx/media3/extractor/ExtractorInput;Z)Z
    .locals 12
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "sniffing"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 365
    const/4 v0, 0x0

    .line 366
    .local v0, "validFrameCount":I
    const/4 v1, 0x0

    .line 367
    .local v1, "candidateSynchronizedHeaderData":I
    const/4 v2, 0x0

    .line 368
    .local v2, "peekedId3Bytes":I
    const/4 v3, 0x0

    .line 369
    .local v3, "searchedBytes":I
    if-eqz p2, :cond_0

    const v4, 0x8000

    goto :goto_0

    :cond_0
    const/high16 v4, 0x20000

    .line 370
    .local v4, "searchLimitBytes":I
    :goto_0
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 371
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x1

    if-nez v5, :cond_4

    .line 374
    iget v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->flags:I

    and-int/lit8 v5, v5, 0x8

    if-nez v5, :cond_1

    move v5, v8

    goto :goto_1

    :cond_1
    move v5, v7

    .line 376
    .local v5, "parseAllId3Frames":Z
    :goto_1
    if-eqz v5, :cond_2

    move-object v9, v6

    goto :goto_2

    :cond_2
    sget-object v9, Landroidx/media3/extractor/mp3/Mp3Extractor;->REQUIRED_ID3_FRAME_PREDICATE:Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;

    .line 377
    .local v9, "id3FramePredicate":Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;
    :goto_2
    iget-object v10, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->id3Peeker:Landroidx/media3/extractor/Id3Peeker;

    invoke-virtual {v10, p1, v9}, Landroidx/media3/extractor/Id3Peeker;->peekId3Data(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;)Landroidx/media3/common/Metadata;

    move-result-object v10

    iput-object v10, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->metadata:Landroidx/media3/common/Metadata;

    .line 378
    if-eqz v10, :cond_3

    .line 379
    iget-object v11, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->gaplessInfoHolder:Landroidx/media3/extractor/GaplessInfoHolder;

    invoke-virtual {v11, v10}, Landroidx/media3/extractor/GaplessInfoHolder;->setFromMetadata(Landroidx/media3/common/Metadata;)Z

    .line 381
    :cond_3
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v10

    long-to-int v2, v10

    .line 382
    if-nez p2, :cond_4

    .line 383
    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 387
    .end local v5    # "parseAllId3Frames":Z
    .end local v9    # "id3FramePredicate":Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;
    :cond_4
    :goto_3
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->peekEndOfStreamOrHeader(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 388
    if-lez v0, :cond_5

    .line 390
    goto :goto_5

    .line 392
    :cond_5
    new-instance v5, Ljava/io/EOFException;

    invoke-direct {v5}, Ljava/io/EOFException;-><init>()V

    throw v5

    .line 394
    :cond_6
    iget-object v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5, v7}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 395
    iget-object v5, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 397
    .local v5, "headerData":I
    if-eqz v1, :cond_7

    int-to-long v9, v1

    .line 398
    invoke-static {v5, v9, v10}, Landroidx/media3/extractor/mp3/Mp3Extractor;->headersMatch(IJ)Z

    move-result v9

    if-eqz v9, :cond_8

    .line 399
    :cond_7
    invoke-static {v5}, Landroidx/media3/extractor/MpegAudioUtil;->getFrameSize(I)I

    move-result v9

    move v10, v9

    .local v10, "frameSize":I
    const/4 v11, -0x1

    if-ne v9, v11, :cond_c

    .line 401
    .end local v10    # "frameSize":I
    :cond_8
    add-int/lit8 v9, v3, 0x1

    .end local v3    # "searchedBytes":I
    .local v9, "searchedBytes":I
    if-ne v3, v4, :cond_a

    .line 402
    if-eqz p2, :cond_9

    .line 406
    return v7

    .line 403
    :cond_9
    const-string v3, "Searched too many bytes."

    invoke-static {v3, v6}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 408
    :cond_a
    const/4 v0, 0x0

    .line 409
    const/4 v1, 0x0

    .line 410
    if-eqz p2, :cond_b

    .line 411
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 412
    add-int v3, v2, v9

    invoke-interface {p1, v3}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    goto :goto_4

    .line 414
    :cond_b
    invoke-interface {p1, v8}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 427
    .end local v5    # "headerData":I
    :goto_4
    move v3, v9

    goto :goto_8

    .line 418
    .end local v9    # "searchedBytes":I
    .restart local v3    # "searchedBytes":I
    .restart local v5    # "headerData":I
    .restart local v10    # "frameSize":I
    :cond_c
    add-int/lit8 v0, v0, 0x1

    .line 419
    if-ne v0, v8, :cond_d

    .line 420
    iget-object v9, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeader:Landroidx/media3/extractor/MpegAudioUtil$Header;

    invoke-virtual {v9, v5}, Landroidx/media3/extractor/MpegAudioUtil$Header;->setForHeaderData(I)Z

    .line 421
    move v1, v5

    goto :goto_7

    .line 422
    :cond_d
    const/4 v9, 0x4

    if-ne v0, v9, :cond_f

    .line 423
    nop

    .line 429
    .end local v5    # "headerData":I
    .end local v10    # "frameSize":I
    :goto_5
    if-eqz p2, :cond_e

    .line 430
    add-int v5, v2, v3

    invoke-interface {p1, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    goto :goto_6

    .line 432
    :cond_e
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 434
    :goto_6
    iput v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeaderData:I

    .line 435
    return v8

    .line 425
    .restart local v5    # "headerData":I
    .restart local v10    # "frameSize":I
    :cond_f
    :goto_7
    add-int/lit8 v9, v10, -0x4

    invoke-interface {p1, v9}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 427
    .end local v5    # "headerData":I
    .end local v10    # "frameSize":I
    :goto_8
    goto :goto_3
.end method


# virtual methods
.method public disableSeeking()V
    .locals 1

    .line 266
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->disableSeeking:Z

    .line 267
    return-void
.end method

.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 2
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 221
    iput-object p1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 222
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-interface {p1, v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->realTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 223
    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 224
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v0}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 225
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 247
    invoke-direct {p0}, Landroidx/media3/extractor/mp3/Mp3Extractor;->assertInitialized()V

    .line 248
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->readInternal(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    .line 249
    .local v0, "readResult":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    iget-object v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    instance-of v1, v1, Landroidx/media3/extractor/mp3/IndexSeeker;

    if-eqz v1, :cond_0

    .line 251
    iget-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    invoke-direct {p0, v1, v2}, Landroidx/media3/extractor/mp3/Mp3Extractor;->computeTimeUs(J)J

    move-result-wide v1

    .line 252
    .local v1, "durationUs":J
    iget-object v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    invoke-interface {v3}, Landroidx/media3/extractor/mp3/Seeker;->getDurationUs()J

    move-result-wide v3

    cmp-long v3, v3, v1

    if-eqz v3, :cond_0

    .line 253
    iget-object v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    check-cast v3, Landroidx/media3/extractor/mp3/IndexSeeker;

    invoke-virtual {v3, v1, v2}, Landroidx/media3/extractor/mp3/IndexSeeker;->setDurationUs(J)V

    .line 254
    iget-object v3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    iget-object v4, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    invoke-interface {v3, v4}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 257
    .end local v1    # "durationUs":J
    :cond_0
    return v0
.end method

.method public release()V
    .locals 0

    .line 243
    return-void
.end method

.method public seek(JJ)V
    .locals 3
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 229
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronizedHeaderData:I

    .line 230
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->basisTimeUs:J

    .line 231
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->samplesRead:J

    .line 232
    iput v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->sampleBytesRemaining:I

    .line 233
    iput-wide p3, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seekTimeUs:J

    .line 234
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->seeker:Landroidx/media3/extractor/mp3/Seeker;

    instance-of v1, v0, Landroidx/media3/extractor/mp3/IndexSeeker;

    if-eqz v1, :cond_0

    check-cast v0, Landroidx/media3/extractor/mp3/IndexSeeker;

    invoke-virtual {v0, p3, p4}, Landroidx/media3/extractor/mp3/IndexSeeker;->isTimeUsInIndex(J)Z

    move-result v0

    if-nez v0, :cond_0

    .line 235
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->isSeekInProgress:Z

    .line 236
    iget-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->skippingTrackOutput:Landroidx/media3/extractor/TrackOutput;

    iput-object v0, p0, Landroidx/media3/extractor/mp3/Mp3Extractor;->currentTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 238
    :cond_0
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 1
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 216
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroidx/media3/extractor/mp3/Mp3Extractor;->synchronize(Landroidx/media3/extractor/ExtractorInput;Z)Z

    move-result v0

    return v0
.end method
