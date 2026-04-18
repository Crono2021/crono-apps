.class final Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;
.super Ljava/lang/Object;
.source "FlacReader.java"

# interfaces
.implements Landroidx/media3/extractor/ogg/OggSeeker;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/ogg/FlacReader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "FlacOggSeeker"
.end annotation


# instance fields
.field private firstFrameOffset:J

.field private pendingSeekGranule:J

.field private seekTable:Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;

.field private streamMetadata:Landroidx/media3/extractor/FlacStreamMetadata;


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/FlacStreamMetadata;Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;)V
    .locals 2
    .param p1, "streamMetadata"    # Landroidx/media3/extractor/FlacStreamMetadata;
    .param p2, "seekTable"    # Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    iput-object p1, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->streamMetadata:Landroidx/media3/extractor/FlacStreamMetadata;

    .line 127
    iput-object p2, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->seekTable:Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;

    .line 128
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->firstFrameOffset:J

    .line 129
    iput-wide v0, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->pendingSeekGranule:J

    .line 130
    return-void
.end method


# virtual methods
.method public createSeekMap()Landroidx/media3/extractor/SeekMap;
    .locals 4

    .line 157
    iget-wide v0, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->firstFrameOffset:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 158
    new-instance v0, Landroidx/media3/extractor/FlacSeekTableSeekMap;

    iget-object v1, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->streamMetadata:Landroidx/media3/extractor/FlacStreamMetadata;

    iget-wide v2, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->firstFrameOffset:J

    invoke-direct {v0, v1, v2, v3}, Landroidx/media3/extractor/FlacSeekTableSeekMap;-><init>(Landroidx/media3/extractor/FlacStreamMetadata;J)V

    return-object v0
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;)J
    .locals 7
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;

    .line 138
    iget-wide v0, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->pendingSeekGranule:J

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    const-wide/16 v3, -0x1

    if-ltz v2, :cond_0

    .line 139
    const-wide/16 v5, 0x2

    add-long/2addr v0, v5

    neg-long v0, v0

    .line 140
    .local v0, "result":J
    iput-wide v3, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->pendingSeekGranule:J

    .line 141
    return-wide v0

    .line 143
    .end local v0    # "result":J
    :cond_0
    return-wide v3
.end method

.method public setFirstFrameOffset(J)V
    .locals 0
    .param p1, "firstFrameOffset"    # J

    .line 133
    iput-wide p1, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->firstFrameOffset:J

    .line 134
    return-void
.end method

.method public startSeek(J)V
    .locals 4
    .param p1, "targetGranule"    # J

    .line 148
    iget-object v0, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->seekTable:Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;

    iget-object v0, v0, Landroidx/media3/extractor/FlacStreamMetadata$SeekTable;->pointSampleNumbers:[J

    .line 149
    .local v0, "seekPointGranules":[J
    nop

    .line 150
    const/4 v1, 0x1

    invoke-static {v0, p1, p2, v1, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v1

    .line 152
    .local v1, "index":I
    aget-wide v2, v0, v1

    iput-wide v2, p0, Landroidx/media3/extractor/ogg/FlacReader$FlacOggSeeker;->pendingSeekGranule:J

    .line 153
    return-void
.end method
