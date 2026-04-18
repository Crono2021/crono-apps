.class public final Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;
.super Ljava/lang/Object;
.source "MediaParserChunkExtractor.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/chunk/ChunkExtractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;
    }
.end annotation


# static fields
.field public static final FACTORY:Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$Factory;

.field private static final TAG:Ljava/lang/String; = "MediaPrsrChunkExtractor"


# instance fields
.field private final dummyTrackOutput:Landroidx/media3/extractor/DummyTrackOutput;

.field private final inputReaderAdapter:Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;

.field private final mediaParser:Landroid/media/MediaParser;

.field private final outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

.field private pendingSeekUs:J

.field private sampleFormats:[Landroidx/media3/common/Format;

.field private trackOutputProvider:Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;

.field private final trackOutputProviderAdapter:Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 59
    new-instance v0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->FACTORY:Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$Factory;

    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/Format;Ljava/util/List;Landroidx/media3/exoplayer/analytics/PlayerId;)V
    .locals 6
    .param p1, "primaryTrackType"    # I
    .param p2, "manifestFormat"    # Landroidx/media3/common/Format;
    .param p4, "playerId"    # Landroidx/media3/exoplayer/analytics/PlayerId;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/media3/common/Format;",
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;",
            "Landroidx/media3/exoplayer/analytics/PlayerId;",
            ")V"
        }
    .end annotation

    .line 100
    .local p3, "closedCaptionFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 101
    new-instance v0, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    const/4 v1, 0x1

    .line 112
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 101
    invoke-direct {v0, p2, p1, v1}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;-><init>(Landroidx/media3/common/Format;IZ)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    .line 104
    new-instance v1, Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;

    invoke-direct {v1}, Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->inputReaderAdapter:Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;

    .line 105
    iget-object v1, p2, Landroidx/media3/common/Format;->containerMimeType:Ljava/lang/String;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 107
    .local v1, "mimeType":Ljava/lang/String;
    invoke-static {v1}, Landroidx/media3/common/MimeTypes;->isMatroska(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 108
    const-string v3, "android.media.mediaparser.MatroskaParser"

    goto :goto_0

    .line 109
    :cond_0
    const-string v3, "android.media.mediaparser.FragmentedMp4Parser"

    :goto_0
    nop

    .line 110
    .local v3, "parserName":Ljava/lang/String;
    invoke-virtual {v0, v3}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->setSelectedParserName(Ljava/lang/String;)V

    .line 111
    invoke-static {v3, v0}, Landroid/media/MediaParser;->createByName(Ljava/lang/String;Landroid/media/MediaParser$OutputConsumer;)Landroid/media/MediaParser;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    .line 112
    const-string v4, "android.media.mediaparser.matroska.disableCuesSeeking"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 113
    const-string v4, "android.media.mediaparser.inBandCryptoInfo"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 114
    const-string v4, "android.media.mediaparser.includeSupplementalData"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 115
    const-string v4, "android.media.mediaparser.eagerlyExposeTrackType"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 116
    const-string v4, "android.media.mediaparser.exposeDummySeekMap"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 117
    const-string v4, "android.media.mediaParser.exposeChunkIndexAsMediaFormat"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 118
    const-string v4, "android.media.mediaParser.overrideInBandCaptionDeclarations"

    invoke-virtual {v0, v4, v2}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 119
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 120
    .local v0, "closedCaptionMediaFormats":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/media/MediaFormat;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 121
    nop

    .line 122
    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/Format;

    invoke-static {v4}, Landroidx/media3/exoplayer/source/mediaparser/MediaParserUtil;->toCaptionsMediaFormat(Landroidx/media3/common/Format;)Landroid/media/MediaFormat;

    move-result-object v4

    .line 121
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 120
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 124
    .end local v2    # "i":I
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    const-string v4, "android.media.mediaParser.exposeCaptionFormats"

    invoke-virtual {v2, v4, v0}, Landroid/media/MediaParser;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Landroid/media/MediaParser;

    .line 125
    sget v2, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v4, 0x1f

    if-lt v2, v4, :cond_2

    .line 126
    iget-object v2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    invoke-static {v2, p4}, Landroidx/media3/exoplayer/source/mediaparser/MediaParserUtil;->setLogSessionIdOnMediaParser(Landroid/media/MediaParser;Landroidx/media3/exoplayer/analytics/PlayerId;)V

    .line 128
    :cond_2
    iget-object v2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    invoke-virtual {v2, p3}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->setMuxedCaptionFormats(Ljava/util/List;)V

    .line 129
    new-instance v2, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;

    const/4 v4, 0x0

    invoke-direct {v2, p0, v4}, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;-><init>(Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$1;)V

    iput-object v2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->trackOutputProviderAdapter:Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;

    .line 130
    new-instance v2, Landroidx/media3/extractor/DummyTrackOutput;

    invoke-direct {v2}, Landroidx/media3/extractor/DummyTrackOutput;-><init>()V

    iput-object v2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->dummyTrackOutput:Landroidx/media3/extractor/DummyTrackOutput;

    .line 131
    const-wide v4, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v4, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->pendingSeekUs:J

    .line 132
    return-void
.end method

.method static synthetic access$100(Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;)Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;

    .line 54
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->trackOutputProvider:Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;

    return-object v0
.end method

.method static synthetic access$200(Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;)Landroidx/media3/extractor/DummyTrackOutput;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;

    .line 54
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->dummyTrackOutput:Landroidx/media3/extractor/DummyTrackOutput;

    return-object v0
.end method

.method static synthetic access$302(Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;[Landroidx/media3/common/Format;)[Landroidx/media3/common/Format;
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;
    .param p1, "x1"    # [Landroidx/media3/common/Format;

    .line 54
    iput-object p1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->sampleFormats:[Landroidx/media3/common/Format;

    return-object p1
.end method

.method static synthetic access$400(Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;)Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;

    .line 54
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    return-object v0
.end method

.method static synthetic lambda$static$0(ILandroidx/media3/common/Format;ZLjava/util/List;Landroidx/media3/extractor/TrackOutput;Landroidx/media3/exoplayer/analytics/PlayerId;)Landroidx/media3/exoplayer/source/chunk/ChunkExtractor;
    .locals 1
    .param p0, "primaryTrackType"    # I
    .param p1, "format"    # Landroidx/media3/common/Format;
    .param p2, "enableEventMessageTrack"    # Z
    .param p3, "closedCaptionFormats"    # Ljava/util/List;
    .param p4, "playerEmsgTrackOutput"    # Landroidx/media3/extractor/TrackOutput;
    .param p5, "playerId"    # Landroidx/media3/exoplayer/analytics/PlayerId;

    .line 66
    iget-object v0, p1, Landroidx/media3/common/Format;->containerMimeType:Ljava/lang/String;

    invoke-static {v0}, Landroidx/media3/common/MimeTypes;->isText(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 68
    new-instance v0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;

    invoke-direct {v0, p0, p1, p3, p5}, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;-><init>(ILandroidx/media3/common/Format;Ljava/util/List;Landroidx/media3/exoplayer/analytics/PlayerId;)V

    return-object v0

    .line 72
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method private maybeExecutePendingSeek()V
    .locals 6

    .line 172
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->getDummySeekMap()Landroid/media/MediaParser$SeekMap;

    move-result-object v0

    .line 173
    .local v0, "dummySeekMap":Landroid/media/MediaParser$SeekMap;
    iget-wide v1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->pendingSeekUs:J

    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v1, v3

    if-eqz v5, :cond_0

    if-eqz v0, :cond_0

    .line 174
    iget-object v5, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaParser$SeekMap;->getSeekPoints(J)Landroid/util/Pair;

    move-result-object v1

    iget-object v1, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Landroid/media/MediaParser$SeekPoint;

    invoke-virtual {v5, v1}, Landroid/media/MediaParser;->seek(Landroid/media/MediaParser$SeekPoint;)V

    .line 175
    iput-wide v3, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->pendingSeekUs:J

    .line 177
    :cond_0
    return-void
.end method


# virtual methods
.method public getChunkIndex()Landroidx/media3/extractor/ChunkIndex;
    .locals 1

    .line 160
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->getChunkIndex()Landroidx/media3/extractor/ChunkIndex;

    move-result-object v0

    return-object v0
.end method

.method public getSampleFormats()[Landroidx/media3/common/Format;
    .locals 1

    .line 166
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->sampleFormats:[Landroidx/media3/common/Format;

    return-object v0
.end method

.method public init(Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;JJ)V
    .locals 2
    .param p1, "trackOutputProvider"    # Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;
    .param p2, "startTimeUs"    # J
    .param p4, "endTimeUs"    # J

    .line 139
    iput-object p1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->trackOutputProvider:Landroidx/media3/exoplayer/source/chunk/ChunkExtractor$TrackOutputProvider;

    .line 140
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    invoke-virtual {v0, p4, p5}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->setSampleTimestampUpperLimitFilterUs(J)V

    .line 141
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->outputConsumerAdapter:Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->trackOutputProviderAdapter:Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor$TrackOutputProviderAdapter;

    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/source/mediaparser/OutputConsumerAdapterV30;->setExtractorOutput(Landroidx/media3/extractor/ExtractorOutput;)V

    .line 142
    iput-wide p2, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->pendingSeekUs:J

    .line 143
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 3
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 152
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->maybeExecutePendingSeek()V

    .line 153
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->inputReaderAdapter:Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v1

    invoke-virtual {v0, p1, v1, v2}, Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;->setDataReader(Landroidx/media3/common/DataReader;J)V

    .line 154
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->inputReaderAdapter:Landroidx/media3/exoplayer/source/mediaparser/InputReaderAdapterV30;

    invoke-virtual {v0, v1}, Landroid/media/MediaParser;->advance(Landroid/media/MediaParser$SeekableInputReader;)Z

    move-result v0

    return v0
.end method

.method public release()V
    .locals 1

    .line 147
    iget-object v0, p0, Landroidx/media3/exoplayer/source/chunk/MediaParserChunkExtractor;->mediaParser:Landroid/media/MediaParser;

    invoke-virtual {v0}, Landroid/media/MediaParser;->release()V

    .line 148
    return-void
.end method
