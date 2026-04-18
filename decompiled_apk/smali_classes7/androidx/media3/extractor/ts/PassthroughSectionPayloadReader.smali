.class public final Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;
.super Ljava/lang/Object;
.source "PassthroughSectionPayloadReader.java"

# interfaces
.implements Landroidx/media3/extractor/ts/SectionPayloadReader;


# instance fields
.field private format:Landroidx/media3/common/Format;

.field private output:Landroidx/media3/extractor/TrackOutput;

.field private timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "mimeType"    # Ljava/lang/String;

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    invoke-virtual {v0, p1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->format:Landroidx/media3/common/Format;

    .line 49
    return-void
.end method

.method private assertInitialized()V
    .locals 1
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/EnsuresNonNull;
        value = {
            "timestampAdjuster",
            "output"
        }
    .end annotation

    .line 84
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    return-void
.end method


# virtual methods
.method public consume(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 12
    .param p1, "sectionData"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 66
    invoke-direct {p0}, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->assertInitialized()V

    .line 67
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimestampAdjuster;->getLastAdjustedTimestampUs()J

    move-result-wide v8

    .line 68
    .local v8, "sampleTimestampUs":J
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    invoke-virtual {v0}, Landroidx/media3/common/util/TimestampAdjuster;->getTimestampOffsetUs()J

    move-result-wide v10

    .line 69
    .local v10, "subsampleOffsetUs":J
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v2, v8, v0

    if-eqz v2, :cond_2

    cmp-long v0, v10, v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 73
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->format:Landroidx/media3/common/Format;

    iget-wide v0, v0, Landroidx/media3/common/Format;->subsampleOffsetUs:J

    cmp-long v0, v10, v0

    if-eqz v0, :cond_1

    .line 74
    iget-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->format:Landroidx/media3/common/Format;

    invoke-virtual {v0}, Landroidx/media3/common/Format;->buildUpon()Landroidx/media3/common/Format$Builder;

    move-result-object v0

    invoke-virtual {v0, v10, v11}, Landroidx/media3/common/Format$Builder;->setSubsampleOffsetUs(J)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->format:Landroidx/media3/common/Format;

    .line 75
    iget-object v1, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v1, v0}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 77
    :cond_1
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v0

    .line 78
    .local v0, "sampleSize":I
    iget-object v1, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-interface {v1, p1, v0}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 79
    iget-object v1, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    const/4 v4, 0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-wide v2, v8

    move v5, v0

    invoke-interface/range {v1 .. v7}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 80
    return-void

    .line 71
    .end local v0    # "sampleSize":I
    :cond_2
    :goto_0
    return-void
.end method

.method public init(Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V
    .locals 2
    .param p1, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p2, "extractorOutput"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p3, "idGenerator"    # Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    .line 56
    iput-object p1, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    .line 57
    invoke-virtual {p3}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->generateNewId()V

    .line 58
    invoke-virtual {p3}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getTrackId()I

    move-result v0

    const/4 v1, 0x5

    invoke-interface {p2, v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 61
    iget-object v1, p0, Landroidx/media3/extractor/ts/PassthroughSectionPayloadReader;->format:Landroidx/media3/common/Format;

    invoke-interface {v0, v1}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 62
    return-void
.end method
