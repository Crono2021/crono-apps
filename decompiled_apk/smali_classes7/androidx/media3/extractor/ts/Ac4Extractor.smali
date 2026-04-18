.class public final Landroidx/media3/extractor/ts/Ac4Extractor;
.super Ljava/lang/Object;
.source "Ac4Extractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# static fields
.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

.field private static final FRAME_HEADER_SIZE:I = 0x7

.field private static final MAX_SNIFF_BYTES:I = 0x2000

.field private static final READ_BUFFER_SIZE:I = 0x4000


# instance fields
.field private final reader:Landroidx/media3/extractor/ts/Ac4Reader;

.field private final sampleData:Landroidx/media3/common/util/ParsableByteArray;

.field private startedPacket:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 42
    new-instance v0, Landroidx/media3/extractor/ts/Ac4Extractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/Ac4Extractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/extractor/ts/Ac4Extractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    new-instance v0, Landroidx/media3/extractor/ts/Ac4Reader;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/Ac4Reader;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->reader:Landroidx/media3/extractor/ts/Ac4Reader;

    .line 67
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x4000

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->sampleData:Landroidx/media3/common/util/ParsableByteArray;

    .line 68
    return-void
.end method

.method static synthetic lambda$static$0()[Landroidx/media3/extractor/Extractor;
    .locals 3

    .line 42
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/ts/Ac4Extractor;

    invoke-direct {v1}, Landroidx/media3/extractor/ts/Ac4Extractor;-><init>()V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 4
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 119
    iget-object v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->reader:Landroidx/media3/extractor/ts/Ac4Reader;

    new-instance v1, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;-><init>(II)V

    invoke-virtual {v0, p1, v1}, Landroidx/media3/extractor/ts/Ac4Reader;->createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V

    .line 121
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 122
    new-instance v0, Landroidx/media3/extractor/SeekMap$Unseekable;

    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    invoke-direct {v0, v1, v2}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 123
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 6
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 138
    iget-object v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->sampleData:Landroidx/media3/common/util/ParsableByteArray;

    .line 139
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/16 v1, 0x4000

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->read([BII)I

    move-result v0

    .line 140
    .local v0, "bytesRead":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 141
    return v1

    .line 145
    :cond_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->sampleData:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 146
    iget-object v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->sampleData:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1, v0}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 148
    iget-boolean v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->startedPacket:Z

    if-nez v1, :cond_1

    .line 150
    iget-object v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->reader:Landroidx/media3/extractor/ts/Ac4Reader;

    const-wide/16 v3, 0x0

    const/4 v5, 0x4

    invoke-virtual {v1, v3, v4, v5}, Landroidx/media3/extractor/ts/Ac4Reader;->packetStarted(JI)V

    .line 151
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->startedPacket:Z

    .line 155
    :cond_1
    iget-object v1, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->reader:Landroidx/media3/extractor/ts/Ac4Reader;

    iget-object v3, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->sampleData:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1, v3}, Landroidx/media3/extractor/ts/Ac4Reader;->consume(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 156
    return v2
.end method

.method public release()V
    .locals 0

    .line 134
    return-void
.end method

.method public seek(JJ)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 127
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->startedPacket:Z

    .line 128
    iget-object v0, p0, Landroidx/media3/extractor/ts/Ac4Extractor;->reader:Landroidx/media3/extractor/ts/Ac4Reader;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/Ac4Reader;->seek()V

    .line 129
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

    .line 75
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 76
    .local v0, "scratch":Landroidx/media3/common/util/ParsableByteArray;
    const/4 v2, 0x0

    .line 78
    .local v2, "startPosition":I
    :goto_0
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {p1, v3, v4, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 79
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 80
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v3

    const v5, 0x494433

    if-eq v3, v5, :cond_4

    .line 81
    nop

    .line 88
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 89
    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 91
    move v1, v2

    .line 92
    .local v1, "headerPosition":I
    const/4 v3, 0x0

    .line 94
    .local v3, "validFramesCount":I
    :goto_1
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v5

    const/4 v6, 0x7

    invoke-interface {p1, v5, v4, v6}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 95
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 96
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v5

    .line 97
    .local v5, "syncBytes":I
    const v6, 0xac40

    if-eq v5, v6, :cond_1

    const v6, 0xac41

    if-eq v5, v6, :cond_1

    .line 98
    const/4 v3, 0x0

    .line 99
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 100
    add-int/lit8 v1, v1, 0x1

    sub-int v6, v1, v2

    const/16 v7, 0x2000

    if-lt v6, v7, :cond_0

    .line 101
    return v4

    .line 103
    :cond_0
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    goto :goto_2

    .line 105
    :cond_1
    add-int/lit8 v3, v3, 0x1

    const/4 v6, 0x4

    if-lt v3, v6, :cond_2

    .line 106
    const/4 v4, 0x1

    return v4

    .line 108
    :cond_2
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    invoke-static {v6, v5}, Landroidx/media3/extractor/Ac4Util;->parseAc4SyncframeSize([BI)I

    move-result v6

    .line 109
    .local v6, "frameSize":I
    const/4 v7, -0x1

    if-ne v6, v7, :cond_3

    .line 110
    return v4

    .line 112
    :cond_3
    add-int/lit8 v7, v6, -0x7

    invoke-interface {p1, v7}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 114
    .end local v5    # "syncBytes":I
    .end local v6    # "frameSize":I
    :goto_2
    goto :goto_1

    .line 83
    .end local v1    # "headerPosition":I
    .end local v3    # "validFramesCount":I
    :cond_4
    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 84
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readSynchSafeInt()I

    move-result v3

    .line 85
    .local v3, "length":I
    add-int/lit8 v4, v3, 0xa

    add-int/2addr v2, v4

    .line 86
    invoke-interface {p1, v3}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 87
    .end local v3    # "length":I
    goto :goto_0
.end method
