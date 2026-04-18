.class public final Landroidx/media3/extractor/ts/MpegAudioReader;
.super Ljava/lang/Object;
.source "MpegAudioReader.java"

# interfaces
.implements Landroidx/media3/extractor/ts/ElementaryStreamReader;


# static fields
.field private static final HEADER_SIZE:I = 0x4

.field private static final STATE_FINDING_HEADER:I = 0x0

.field private static final STATE_READING_FRAME:I = 0x2

.field private static final STATE_READING_HEADER:I = 0x1


# instance fields
.field private formatId:Ljava/lang/String;

.field private frameBytesRead:I

.field private frameDurationUs:J

.field private frameSize:I

.field private hasOutputFormat:Z

.field private final header:Landroidx/media3/extractor/MpegAudioUtil$Header;

.field private final headerScratch:Landroidx/media3/common/util/ParsableByteArray;

.field private final language:Ljava/lang/String;

.field private lastByteWasFF:Z

.field private output:Landroidx/media3/extractor/TrackOutput;

.field private final roleFlags:I

.field private state:I

.field private timeUs:J


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 67
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroidx/media3/extractor/ts/MpegAudioReader;-><init>(Ljava/lang/String;I)V

    .line 68
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 3
    .param p1, "language"    # Ljava/lang/String;
    .param p2, "roleFlags"    # I

    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 73
    new-instance v1, Landroidx/media3/common/util/ParsableByteArray;

    const/4 v2, 0x4

    invoke-direct {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 74
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    const/4 v2, -0x1

    aput-byte v2, v1, v0

    .line 75
    new-instance v0, Landroidx/media3/extractor/MpegAudioUtil$Header;

    invoke-direct {v0}, Landroidx/media3/extractor/MpegAudioUtil$Header;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    .line 76
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    .line 77
    iput-object p1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->language:Ljava/lang/String;

    .line 78
    iput p2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->roleFlags:I

    .line 79
    return-void
.end method

.method private findHeader(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 9
    .param p1, "source"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 139
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 140
    .local v0, "data":[B
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v1

    .line 141
    .local v1, "startOffset":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v2

    .line 142
    .local v2, "endOffset":I
    move v3, v1

    .local v3, "i":I
    :goto_0
    if-ge v3, v2, :cond_3

    .line 143
    aget-byte v4, v0, v3

    const/16 v5, 0xff

    and-int/2addr v4, v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-ne v4, v5, :cond_0

    move v4, v7

    goto :goto_1

    :cond_0
    move v4, v6

    .line 144
    .local v4, "byteIsFF":Z
    :goto_1
    iget-boolean v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->lastByteWasFF:Z

    if-eqz v5, :cond_1

    aget-byte v5, v0, v3

    const/16 v8, 0xe0

    and-int/2addr v5, v8

    if-ne v5, v8, :cond_1

    move v5, v7

    goto :goto_2

    :cond_1
    move v5, v6

    .line 145
    .local v5, "found":Z
    :goto_2
    iput-boolean v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->lastByteWasFF:Z

    .line 146
    if-eqz v5, :cond_2

    .line 147
    add-int/lit8 v8, v3, 0x1

    invoke-virtual {p1, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 149
    iput-boolean v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->lastByteWasFF:Z

    .line 150
    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    aget-byte v8, v0, v3

    aput-byte v8, v6, v7

    .line 151
    const/4 v6, 0x2

    iput v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 152
    iput v7, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 153
    return-void

    .line 142
    .end local v4    # "byteIsFF":Z
    .end local v5    # "found":Z
    :cond_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 156
    .end local v3    # "i":I
    :cond_3
    invoke-virtual {p1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 157
    return-void
.end method

.method private readFrameRemainder(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 10
    .param p1, "source"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 230
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    iget v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameSize:I

    iget v2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 231
    .local v0, "bytesToRead":I
    iget-object v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v1, p1, v0}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 232
    iget v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    add-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 233
    iget v2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameSize:I

    if-ge v1, v2, :cond_0

    .line 235
    return-void

    .line 239
    :cond_0
    iget-wide v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v1, v1, v3

    const/4 v2, 0x0

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    move v1, v2

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 240
    iget-object v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-wide v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    const/4 v6, 0x1

    iget v7, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameSize:I

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-interface/range {v3 .. v9}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 241
    iget-wide v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    iget-wide v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameDurationUs:J

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    .line 242
    iput v2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 243
    iput v2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 244
    return-void
.end method

.method private readHeaderRemainder(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 9
    .param p1, "source"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "output"
        }
    .end annotation

    .line 177
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    iget v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    const/4 v2, 0x4

    rsub-int/lit8 v1, v1, 0x4

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 178
    .local v0, "bytesToRead":I
    iget-object v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    iget v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    invoke-virtual {p1, v1, v3, v0}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 179
    iget v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    add-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 180
    if-ge v1, v2, :cond_0

    .line 182
    return-void

    .line 185
    :cond_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 186
    iget-object v1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget-object v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    invoke-virtual {v1, v4}, Landroidx/media3/extractor/MpegAudioUtil$Header;->setForHeaderData(I)Z

    move-result v1

    .line 187
    .local v1, "parsedHeader":Z
    const/4 v4, 0x1

    if-nez v1, :cond_1

    .line 189
    iput v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 190
    iput v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 191
    return-void

    .line 194
    :cond_1
    iget-object v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v5, v5, Landroidx/media3/extractor/MpegAudioUtil$Header;->frameSize:I

    iput v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameSize:I

    .line 195
    iget-boolean v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->hasOutputFormat:Z

    if-nez v5, :cond_2

    .line 196
    iget-object v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v5, v5, Landroidx/media3/extractor/MpegAudioUtil$Header;->samplesPerFrame:I

    int-to-long v5, v5

    const-wide/32 v7, 0xf4240

    mul-long/2addr v5, v7

    iget-object v7, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v7, v7, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    int-to-long v7, v7

    div-long/2addr v5, v7

    iput-wide v5, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameDurationUs:J

    .line 197
    new-instance v5, Landroidx/media3/common/Format$Builder;

    invoke-direct {v5}, Landroidx/media3/common/Format$Builder;-><init>()V

    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->formatId:Ljava/lang/String;

    .line 199
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget-object v6, v6, Landroidx/media3/extractor/MpegAudioUtil$Header;->mimeType:Ljava/lang/String;

    .line 200
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    .line 201
    const/16 v6, 0x1000

    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setMaxInputSize(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v6, v6, Landroidx/media3/extractor/MpegAudioUtil$Header;->channels:I

    .line 202
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->header:Landroidx/media3/extractor/MpegAudioUtil$Header;

    iget v6, v6, Landroidx/media3/extractor/MpegAudioUtil$Header;->sampleRate:I

    .line 203
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->language:Ljava/lang/String;

    .line 204
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->roleFlags:I

    .line 205
    invoke-virtual {v5, v6}, Landroidx/media3/common/Format$Builder;->setRoleFlags(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    .line 206
    invoke-virtual {v5}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v5

    .line 207
    .local v5, "format":Landroidx/media3/common/Format;
    iget-object v6, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v6, v5}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 208
    iput-boolean v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->hasOutputFormat:Z

    .line 211
    .end local v5    # "format":Landroidx/media3/common/Format;
    :cond_2
    iget-object v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 212
    iget-object v3, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-object v4, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->headerScratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v3, v4, v2}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 213
    const/4 v2, 0x2

    iput v2, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 214
    return-void
.end method


# virtual methods
.method public consume(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 1
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 103
    iget-object v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    if-lez v0, :cond_0

    .line 105
    iget v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    packed-switch v0, :pswitch_data_0

    .line 116
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 113
    :pswitch_0
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/MpegAudioReader;->readFrameRemainder(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 114
    goto :goto_0

    .line 110
    :pswitch_1
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/MpegAudioReader;->readHeaderRemainder(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 111
    goto :goto_0

    .line 107
    :pswitch_2
    invoke-direct {p0, p1}, Landroidx/media3/extractor/ts/MpegAudioReader;->findHeader(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 108
    goto :goto_0

    .line 119
    :cond_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V
    .locals 2
    .param p1, "extractorOutput"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p2, "idGenerator"    # Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    .line 91
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->generateNewId()V

    .line 92
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getFormatId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->formatId:Ljava/lang/String;

    .line 93
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getTrackId()I

    move-result v0

    const/4 v1, 0x1

    invoke-interface {p1, v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 94
    return-void
.end method

.method public packetFinished()V
    .locals 0

    .line 124
    return-void
.end method

.method public packetStarted(JI)V
    .locals 0
    .param p1, "pesTimeUs"    # J
    .param p3, "flags"    # I

    .line 98
    iput-wide p1, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    .line 99
    return-void
.end method

.method public seek()V
    .locals 2

    .line 83
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->state:I

    .line 84
    iput v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->frameBytesRead:I

    .line 85
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->lastByteWasFF:Z

    .line 86
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/ts/MpegAudioReader;->timeUs:J

    .line 87
    return-void
.end method
