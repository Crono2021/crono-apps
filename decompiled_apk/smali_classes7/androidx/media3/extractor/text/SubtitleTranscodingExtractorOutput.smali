.class public final Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;
.super Ljava/lang/Object;
.source "SubtitleTranscodingExtractorOutput.java"

# interfaces
.implements Landroidx/media3/extractor/ExtractorOutput;


# instance fields
.field private final delegate:Landroidx/media3/extractor/ExtractorOutput;

.field private final subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

.field private final textTrackOutputs:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V
    .locals 1
    .param p1, "delegate"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p2, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->delegate:Landroidx/media3/extractor/ExtractorOutput;

    .line 52
    iput-object p2, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 53
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->textTrackOutputs:Landroid/util/SparseArray;

    .line 54
    return-void
.end method


# virtual methods
.method public endTracks()V
    .locals 1

    .line 81
    iget-object v0, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->delegate:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v0}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 82
    return-void
.end method

.method public resetSubtitleParsers()V
    .locals 2

    .line 57
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->textTrackOutputs:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 58
    iget-object v1, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->textTrackOutputs:Landroid/util/SparseArray;

    invoke-virtual {v1, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;

    invoke-virtual {v1}, Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;->resetSubtitleParser()V

    .line 57
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 60
    .end local v0    # "i":I
    :cond_0
    return-void
.end method

.method public seekMap(Landroidx/media3/extractor/SeekMap;)V
    .locals 1
    .param p1, "seekMap"    # Landroidx/media3/extractor/SeekMap;

    .line 86
    iget-object v0, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->delegate:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v0, p1}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 87
    return-void
.end method

.method public track(II)Landroidx/media3/extractor/TrackOutput;
    .locals 4
    .param p1, "id"    # I
    .param p2, "type"    # I

    .line 66
    const/4 v0, 0x3

    if-eq p2, v0, :cond_0

    .line 67
    iget-object v0, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->delegate:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v0, p1, p2}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    return-object v0

    .line 69
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->textTrackOutputs:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;

    .line 70
    .local v0, "existingTrackOutput":Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;
    if-eqz v0, :cond_1

    .line 71
    return-object v0

    .line 73
    :cond_1
    new-instance v1, Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;

    iget-object v2, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->delegate:Landroidx/media3/extractor/ExtractorOutput;

    .line 74
    invoke-interface {v2, p1, p2}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v2

    iget-object v3, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;-><init>(Landroidx/media3/extractor/TrackOutput;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    .line 75
    .local v1, "trackOutput":Landroidx/media3/extractor/text/SubtitleTranscodingTrackOutput;
    iget-object v2, p0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;->textTrackOutputs:Landroid/util/SparseArray;

    invoke-virtual {v2, p1, v1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 76
    return-object v1
.end method
