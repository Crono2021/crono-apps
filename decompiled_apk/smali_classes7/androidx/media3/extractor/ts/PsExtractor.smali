.class public final Landroidx/media3/extractor/ts/PsExtractor;
.super Ljava/lang/Object;
.source "PsExtractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/ts/PsExtractor$PesReader;
    }
.end annotation


# static fields
.field public static final AUDIO_STREAM:I = 0xc0

.field public static final AUDIO_STREAM_MASK:I = 0xe0

.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

.field private static final MAX_SEARCH_LENGTH:J = 0x100000L

.field private static final MAX_SEARCH_LENGTH_AFTER_AUDIO_AND_VIDEO_FOUND:J = 0x2000L

.field private static final MAX_STREAM_ID_PLUS_ONE:I = 0x100

.field static final MPEG_PROGRAM_END_CODE:I = 0x1b9

.field static final PACKET_START_CODE_PREFIX:I = 0x1

.field static final PACK_START_CODE:I = 0x1ba

.field public static final PRIVATE_STREAM_1:I = 0xbd

.field static final SYSTEM_HEADER_START_CODE:I = 0x1bb

.field public static final VIDEO_STREAM:I = 0xe0

.field public static final VIDEO_STREAM_MASK:I = 0xf0


# instance fields
.field private final durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

.field private foundAllTracks:Z

.field private foundAudioTrack:Z

.field private foundVideoTrack:Z

.field private hasOutputSeekMap:Z

.field private lastTrackPosition:J

.field private output:Landroidx/media3/extractor/ExtractorOutput;

.field private psBinarySearchSeeker:Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

.field private final psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

.field private final psPayloadReaders:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/ts/PsExtractor$PesReader;",
            ">;"
        }
    .end annotation
.end field

.field private final timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 43
    new-instance v0, Landroidx/media3/extractor/ts/PsExtractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/PsExtractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/extractor/ts/PsExtractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 79
    new-instance v0, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v1, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    invoke-direct {p0, v0}, Landroidx/media3/extractor/ts/PsExtractor;-><init>(Landroidx/media3/common/util/TimestampAdjuster;)V

    .line 80
    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/util/TimestampAdjuster;)V
    .locals 2
    .param p1, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;

    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    iput-object p1, p0, Landroidx/media3/extractor/ts/PsExtractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    .line 84
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x1000

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 85
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->psPayloadReaders:Landroid/util/SparseArray;

    .line 86
    new-instance v0, Landroidx/media3/extractor/ts/PsDurationReader;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/PsDurationReader;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    .line 87
    return-void
.end method

.method static synthetic lambda$static$0()[Landroidx/media3/extractor/Extractor;
    .locals 3

    .line 43
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/ts/PsExtractor;

    invoke-direct {v1}, Landroidx/media3/extractor/ts/PsExtractor;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method private maybeOutputSeekMap(J)V
    .locals 7
    .param p1, "inputLength"    # J
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 296
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->hasOutputSeekMap:Z

    if-nez v0, :cond_1

    .line 297
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->hasOutputSeekMap:Z

    .line 298
    iget-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/PsDurationReader;->getDurationUs()J

    move-result-wide v0

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 299
    new-instance v0, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

    iget-object v1, p0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    .line 301
    invoke-virtual {v1}, Landroidx/media3/extractor/ts/PsDurationReader;->getScrTimestampAdjuster()Landroidx/media3/common/util/TimestampAdjuster;

    move-result-object v2

    iget-object v1, p0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    .line 302
    invoke-virtual {v1}, Landroidx/media3/extractor/ts/PsDurationReader;->getDurationUs()J

    move-result-wide v3

    move-object v1, v0

    move-wide v5, p1

    invoke-direct/range {v1 .. v6}, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;-><init>(Landroidx/media3/common/util/TimestampAdjuster;JJ)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->psBinarySearchSeeker:Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

    .line 304
    iget-object v1, p0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;->getSeekMap()Landroidx/media3/extractor/SeekMap;

    move-result-object v0

    invoke-interface {v1, v0}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    goto :goto_0

    .line 306
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v1, Landroidx/media3/extractor/SeekMap$Unseekable;

    iget-object v2, p0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    invoke-virtual {v2}, Landroidx/media3/extractor/ts/PsDurationReader;->getDurationUs()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 309
    :cond_1
    :goto_0
    return-void
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 0
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 135
    iput-object p1, p0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    .line 136
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 20
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 175
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    iget-object v3, v0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v3

    .line 178
    .local v3, "inputLength":J
    const-wide/16 v5, -0x1

    cmp-long v7, v3, v5

    const/4 v8, 0x1

    const/4 v9, 0x0

    if-eqz v7, :cond_0

    move v7, v8

    goto :goto_0

    :cond_0
    move v7, v9

    .line 179
    .local v7, "canReadDuration":Z
    :goto_0
    if-eqz v7, :cond_1

    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    invoke-virtual {v10}, Landroidx/media3/extractor/ts/PsDurationReader;->isDurationReadFinished()Z

    move-result v10

    if-nez v10, :cond_1

    .line 180
    iget-object v5, v0, Landroidx/media3/extractor/ts/PsExtractor;->durationReader:Landroidx/media3/extractor/ts/PsDurationReader;

    invoke-virtual {v5, v1, v2}, Landroidx/media3/extractor/ts/PsDurationReader;->readDuration(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I

    move-result v5

    return v5

    .line 182
    :cond_1
    invoke-direct {v0, v3, v4}, Landroidx/media3/extractor/ts/PsExtractor;->maybeOutputSeekMap(J)V

    .line 183
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psBinarySearchSeeker:Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

    if-eqz v10, :cond_2

    invoke-virtual {v10}, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;->isSeeking()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 184
    iget-object v5, v0, Landroidx/media3/extractor/ts/PsExtractor;->psBinarySearchSeeker:Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

    invoke-virtual {v5, v1, v2}, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;->handlePendingSeek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I

    move-result v5

    return v5

    .line 187
    :cond_2
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 189
    cmp-long v10, v3, v5

    if-eqz v10, :cond_3

    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v10

    sub-long v10, v3, v10

    goto :goto_1

    :cond_3
    move-wide v10, v5

    .line 190
    .local v10, "peekBytesLeft":J
    :goto_1
    cmp-long v5, v10, v5

    const/4 v6, -0x1

    if-eqz v5, :cond_4

    const-wide/16 v12, 0x4

    cmp-long v5, v10, v12

    if-gez v5, :cond_4

    .line 191
    return v6

    .line 194
    :cond_4
    iget-object v5, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v5

    const/4 v12, 0x4

    invoke-interface {v1, v5, v9, v12, v8}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v5

    if-nez v5, :cond_5

    .line 195
    return v6

    .line 198
    :cond_5
    iget-object v5, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5, v9}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 199
    iget-object v5, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 200
    .local v5, "nextStartCode":I
    const/16 v12, 0x1b9

    if-ne v5, v12, :cond_6

    .line 201
    return v6

    .line 202
    :cond_6
    const/16 v6, 0x1ba

    if-ne v5, v6, :cond_7

    .line 204
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    const/16 v8, 0xa

    invoke-interface {v1, v6, v9, v8}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 207
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    const/16 v8, 0x9

    invoke-virtual {v6, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 210
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v6

    and-int/lit8 v6, v6, 0x7

    .line 213
    .local v6, "packStuffingLength":I
    add-int/lit8 v8, v6, 0xe

    invoke-interface {v1, v8}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 214
    return v9

    .line 215
    .end local v6    # "packStuffingLength":I
    :cond_7
    const/16 v6, 0x1bb

    const/4 v12, 0x2

    if-ne v5, v6, :cond_8

    .line 217
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    invoke-interface {v1, v6, v9, v12}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 220
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v9}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 221
    iget-object v6, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v6

    .line 222
    .local v6, "systemHeaderLength":I
    add-int/lit8 v8, v6, 0x6

    invoke-interface {v1, v8}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 223
    return v9

    .line 224
    .end local v6    # "systemHeaderLength":I
    :cond_8
    and-int/lit16 v6, v5, -0x100

    shr-int/lit8 v6, v6, 0x8

    if-eq v6, v8, :cond_9

    .line 225
    invoke-interface {v1, v8}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 226
    return v9

    .line 231
    :cond_9
    and-int/lit16 v6, v5, 0xff

    .line 234
    .local v6, "streamId":I
    iget-object v13, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v13, v6}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/media3/extractor/ts/PsExtractor$PesReader;

    .line 235
    .local v13, "payloadReader":Landroidx/media3/extractor/ts/PsExtractor$PesReader;
    iget-boolean v14, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundAllTracks:Z

    if-nez v14, :cond_10

    .line 236
    if-nez v13, :cond_d

    .line 237
    const/4 v14, 0x0

    .line 238
    .local v14, "elementaryStreamReader":Landroidx/media3/extractor/ts/ElementaryStreamReader;
    const/16 v15, 0xbd

    if-ne v6, v15, :cond_a

    .line 242
    new-instance v15, Landroidx/media3/extractor/ts/Ac3Reader;

    invoke-direct {v15}, Landroidx/media3/extractor/ts/Ac3Reader;-><init>()V

    move-object v14, v15

    .line 243
    iput-boolean v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundAudioTrack:Z

    .line 244
    move-wide/from16 v16, v10

    .end local v10    # "peekBytesLeft":J
    .local v16, "peekBytesLeft":J
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v9

    iput-wide v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->lastTrackPosition:J

    goto :goto_2

    .line 245
    .end local v16    # "peekBytesLeft":J
    .restart local v10    # "peekBytesLeft":J
    :cond_a
    move-wide/from16 v16, v10

    .end local v10    # "peekBytesLeft":J
    .restart local v16    # "peekBytesLeft":J
    and-int/lit16 v9, v6, 0xe0

    const/16 v10, 0xc0

    if-ne v9, v10, :cond_b

    .line 246
    new-instance v9, Landroidx/media3/extractor/ts/MpegAudioReader;

    invoke-direct {v9}, Landroidx/media3/extractor/ts/MpegAudioReader;-><init>()V

    move-object v14, v9

    .line 247
    iput-boolean v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundAudioTrack:Z

    .line 248
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v9

    iput-wide v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->lastTrackPosition:J

    goto :goto_2

    .line 249
    :cond_b
    and-int/lit16 v9, v6, 0xf0

    const/16 v10, 0xe0

    if-ne v9, v10, :cond_c

    .line 250
    new-instance v9, Landroidx/media3/extractor/ts/H262Reader;

    invoke-direct {v9}, Landroidx/media3/extractor/ts/H262Reader;-><init>()V

    move-object v14, v9

    .line 251
    iput-boolean v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundVideoTrack:Z

    .line 252
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v9

    iput-wide v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->lastTrackPosition:J

    .line 254
    :cond_c
    :goto_2
    if-eqz v14, :cond_e

    .line 255
    new-instance v9, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    const/16 v10, 0x100

    invoke-direct {v9, v6, v10}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;-><init>(II)V

    .line 256
    .local v9, "idGenerator":Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v14, v10, v9}, Landroidx/media3/extractor/ts/ElementaryStreamReader;->createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V

    .line 257
    new-instance v10, Landroidx/media3/extractor/ts/PsExtractor$PesReader;

    iget-object v11, v0, Landroidx/media3/extractor/ts/PsExtractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-direct {v10, v14, v11}, Landroidx/media3/extractor/ts/PsExtractor$PesReader;-><init>(Landroidx/media3/extractor/ts/ElementaryStreamReader;Landroidx/media3/common/util/TimestampAdjuster;)V

    .line 258
    .end local v13    # "payloadReader":Landroidx/media3/extractor/ts/PsExtractor$PesReader;
    .local v10, "payloadReader":Landroidx/media3/extractor/ts/PsExtractor$PesReader;
    iget-object v11, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v11, v6, v10}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    move-object v13, v10

    goto :goto_3

    .line 236
    .end local v9    # "idGenerator":Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;
    .end local v14    # "elementaryStreamReader":Landroidx/media3/extractor/ts/ElementaryStreamReader;
    .end local v16    # "peekBytesLeft":J
    .local v10, "peekBytesLeft":J
    .restart local v13    # "payloadReader":Landroidx/media3/extractor/ts/PsExtractor$PesReader;
    :cond_d
    move-wide/from16 v16, v10

    .line 262
    .end local v10    # "peekBytesLeft":J
    .restart local v16    # "peekBytesLeft":J
    :cond_e
    :goto_3
    iget-boolean v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundAudioTrack:Z

    if-eqz v9, :cond_f

    iget-boolean v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundVideoTrack:Z

    if-eqz v9, :cond_f

    .line 263
    iget-wide v9, v0, Landroidx/media3/extractor/ts/PsExtractor;->lastTrackPosition:J

    const-wide/16 v18, 0x2000

    add-long v9, v9, v18

    goto :goto_4

    .line 264
    :cond_f
    const-wide/32 v9, 0x100000

    :goto_4
    nop

    .line 265
    .local v9, "maxSearchPosition":J
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v18

    cmp-long v11, v18, v9

    if-lez v11, :cond_11

    .line 266
    iput-boolean v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->foundAllTracks:Z

    .line 267
    iget-object v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v8}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    goto :goto_5

    .line 235
    .end local v9    # "maxSearchPosition":J
    .end local v16    # "peekBytesLeft":J
    .restart local v10    # "peekBytesLeft":J
    :cond_10
    move-wide/from16 v16, v10

    .line 272
    .end local v10    # "peekBytesLeft":J
    .restart local v16    # "peekBytesLeft":J
    :cond_11
    :goto_5
    iget-object v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v8}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v8

    const/4 v9, 0x0

    invoke-interface {v1, v8, v9, v12}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 273
    iget-object v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v8, v9}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 274
    iget-object v8, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v8}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v8

    .line 275
    .local v8, "payloadLength":I
    add-int/lit8 v9, v8, 0x6

    .line 277
    .local v9, "pesLength":I
    if-nez v13, :cond_12

    .line 279
    invoke-interface {v1, v9}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    goto :goto_6

    .line 281
    :cond_12
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v10, v9}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 283
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v10}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v10

    const/4 v11, 0x0

    invoke-interface {v1, v10, v11, v9}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 284
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v11, 0x6

    invoke-virtual {v10, v11}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 285
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v13, v10}, Landroidx/media3/extractor/ts/PsExtractor$PesReader;->consume(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 286
    iget-object v10, v0, Landroidx/media3/extractor/ts/PsExtractor;->psPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v10}, Landroidx/media3/common/util/ParsableByteArray;->capacity()I

    move-result v11

    invoke-virtual {v10, v11}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 289
    :goto_6
    const/4 v10, 0x0

    return v10
.end method

.method public release()V
    .locals 0

    .line 171
    return-void
.end method

.method public seek(JJ)V
    .locals 7
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 145
    iget-object v0, p0, Landroidx/media3/extractor/ts/PsExtractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimestampAdjuster;->getTimestampOffsetUs()J

    move-result-wide v0

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    const/4 v1, 0x0

    const/4 v4, 0x1

    if-nez v0, :cond_0

    move v0, v4

    goto :goto_0

    :cond_0
    move v0, v1

    .line 146
    .local v0, "resetTimestampAdjuster":Z
    :goto_0
    if-nez v0, :cond_2

    .line 147
    iget-object v5, p0, Landroidx/media3/extractor/ts/PsExtractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-virtual {v5}, Landroidx/media3/common/util/TimestampAdjuster;->getFirstSampleTimestampUs()J

    move-result-wide v5

    .line 151
    .local v5, "adjusterFirstSampleTimestampUs":J
    cmp-long v2, v5, v2

    if-eqz v2, :cond_1

    const-wide/16 v2, 0x0

    cmp-long v2, v5, v2

    if-eqz v2, :cond_1

    cmp-long v2, v5, p3

    if-eqz v2, :cond_1

    move v1, v4

    :cond_1
    move v0, v1

    .line 156
    .end local v5    # "adjusterFirstSampleTimestampUs":J
    :cond_2
    if-eqz v0, :cond_3

    .line 157
    iget-object v1, p0, Landroidx/media3/extractor/ts/PsExtractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-virtual {v1, p3, p4}, Landroidx/media3/common/util/TimestampAdjuster;->reset(J)V

    .line 160
    :cond_3
    iget-object v1, p0, Landroidx/media3/extractor/ts/PsExtractor;->psBinarySearchSeeker:Landroidx/media3/extractor/ts/PsBinarySearchSeeker;

    if-eqz v1, :cond_4

    .line 161
    invoke-virtual {v1, p3, p4}, Landroidx/media3/extractor/ts/PsBinarySearchSeeker;->setSeekTargetUs(J)V

    .line 163
    :cond_4
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v2, p0, Landroidx/media3/extractor/ts/PsExtractor;->psPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v2

    if-ge v1, v2, :cond_5

    .line 164
    iget-object v2, p0, Landroidx/media3/extractor/ts/PsExtractor;->psPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v2, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/ts/PsExtractor$PesReader;

    invoke-virtual {v2}, Landroidx/media3/extractor/ts/PsExtractor$PesReader;->seek()V

    .line 163
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 166
    .end local v1    # "i":I
    :cond_5
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 9
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 93
    const/16 v0, 0xe

    new-array v1, v0, [B

    .line 94
    .local v1, "scratch":[B
    const/4 v2, 0x0

    invoke-interface {p1, v1, v2, v0}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 97
    aget-byte v0, v1, v2

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    const/4 v3, 0x1

    aget-byte v4, v1, v3

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x10

    or-int/2addr v0, v4

    const/4 v4, 0x2

    aget-byte v5, v1, v4

    and-int/lit16 v5, v5, 0xff

    const/16 v6, 0x8

    shl-int/2addr v5, v6

    or-int/2addr v0, v5

    const/4 v5, 0x3

    aget-byte v7, v1, v5

    and-int/lit16 v7, v7, 0xff

    or-int/2addr v0, v7

    const/16 v7, 0x1ba

    if-eq v7, v0, :cond_0

    .line 102
    return v2

    .line 105
    :cond_0
    const/4 v0, 0x4

    aget-byte v7, v1, v0

    and-int/lit16 v7, v7, 0xc4

    const/16 v8, 0x44

    if-eq v7, v8, :cond_1

    .line 106
    return v2

    .line 109
    :cond_1
    const/4 v7, 0x6

    aget-byte v7, v1, v7

    and-int/2addr v7, v0

    if-eq v7, v0, :cond_2

    .line 110
    return v2

    .line 113
    :cond_2
    aget-byte v7, v1, v6

    and-int/2addr v7, v0

    if-eq v7, v0, :cond_3

    .line 114
    return v2

    .line 117
    :cond_3
    const/16 v0, 0x9

    aget-byte v0, v1, v0

    and-int/2addr v0, v3

    if-eq v0, v3, :cond_4

    .line 118
    return v2

    .line 121
    :cond_4
    const/16 v0, 0xc

    aget-byte v0, v1, v0

    and-int/2addr v0, v5

    if-eq v0, v5, :cond_5

    .line 122
    return v2

    .line 125
    :cond_5
    const/16 v0, 0xd

    aget-byte v0, v1, v0

    and-int/lit8 v0, v0, 0x7

    .line 126
    .local v0, "packStuffingLength":I
    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 128
    invoke-interface {p1, v1, v2, v5}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 129
    aget-byte v5, v1, v2

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x10

    aget-byte v7, v1, v3

    and-int/lit16 v7, v7, 0xff

    shl-int/lit8 v6, v7, 0x8

    or-int/2addr v5, v6

    aget-byte v4, v1, v4

    and-int/lit16 v4, v4, 0xff

    or-int/2addr v4, v5

    if-ne v3, v4, :cond_6

    move v2, v3

    :cond_6
    return v2
.end method
