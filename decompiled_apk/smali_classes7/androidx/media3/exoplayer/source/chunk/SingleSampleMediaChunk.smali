.class public final Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;
.super Landroidx/media3/exoplayer/source/chunk/BaseMediaChunk;
.source "SingleSampleMediaChunk.java"


# instance fields
.field private loadCompleted:Z

.field private nextLoadPosition:J

.field private final sampleFormat:Landroidx/media3/common/Format;

.field private final trackType:I


# direct methods
.method public constructor <init>(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;Landroidx/media3/common/Format;ILjava/lang/Object;JJJILandroidx/media3/common/Format;)V
    .locals 16
    .param p1, "dataSource"    # Landroidx/media3/datasource/DataSource;
    .param p2, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p3, "trackFormat"    # Landroidx/media3/common/Format;
    .param p4, "trackSelectionReason"    # I
    .param p5, "trackSelectionData"    # Ljava/lang/Object;
    .param p6, "startTimeUs"    # J
    .param p8, "endTimeUs"    # J
    .param p10, "chunkIndex"    # J
    .param p12, "trackType"    # I
    .param p13, "sampleFormat"    # Landroidx/media3/common/Format;

    .line 63
    move-object/from16 v14, p0

    const-wide v10, -0x7fffffffffffffffL    # -4.9E-324

    const-wide v12, -0x7fffffffffffffffL    # -4.9E-324

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move/from16 v4, p4

    move-object/from16 v5, p5

    move-wide/from16 v6, p6

    move-wide/from16 v8, p8

    move-wide/from16 v14, p10

    invoke-direct/range {v0 .. v15}, Landroidx/media3/exoplayer/source/chunk/BaseMediaChunk;-><init>(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;Landroidx/media3/common/Format;ILjava/lang/Object;JJJJJ)V

    .line 74
    move/from16 v1, p12

    iput v1, v0, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->trackType:I

    .line 75
    move-object/from16 v2, p13

    iput-object v2, v0, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->sampleFormat:Landroidx/media3/common/Format;

    .line 76
    return-void
.end method


# virtual methods
.method public cancelLoad()V
    .locals 0

    .line 88
    return-void
.end method

.method public isLoadCompleted()Z
    .locals 1

    .line 80
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->loadCompleted:Z

    return v0
.end method

.method public load()V
    .locals 18
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 93
    move-object/from16 v1, p0

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->getOutput()Landroidx/media3/exoplayer/source/chunk/BaseMediaChunkOutput;

    move-result-object v2

    .line 94
    .local v2, "output":Landroidx/media3/exoplayer/source/chunk/BaseMediaChunkOutput;
    const-wide/16 v3, 0x0

    invoke-virtual {v2, v3, v4}, Landroidx/media3/exoplayer/source/chunk/BaseMediaChunkOutput;->setSampleOffsetUs(J)V

    .line 95
    const/4 v0, 0x0

    iget v3, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->trackType:I

    invoke-virtual {v2, v0, v3}, Landroidx/media3/exoplayer/source/chunk/BaseMediaChunkOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v3

    .line 96
    .local v3, "trackOutput":Landroidx/media3/extractor/TrackOutput;
    iget-object v0, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->sampleFormat:Landroidx/media3/common/Format;

    invoke-interface {v3, v0}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 99
    :try_start_0
    iget-object v0, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->dataSpec:Landroidx/media3/datasource/DataSpec;

    iget-wide v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    invoke-virtual {v0, v4, v5}, Landroidx/media3/datasource/DataSpec;->subrange(J)Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    .line 100
    .local v0, "loadDataSpec":Landroidx/media3/datasource/DataSpec;
    iget-object v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-virtual {v4, v0}, Landroidx/media3/datasource/StatsDataSource;->open(Landroidx/media3/datasource/DataSpec;)J

    move-result-wide v4

    .line 101
    .local v4, "length":J
    const-wide/16 v6, -0x1

    cmp-long v6, v4, v6

    if-eqz v6, :cond_0

    .line 102
    iget-wide v6, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    add-long/2addr v4, v6

    move-wide v12, v4

    goto :goto_0

    .line 101
    :cond_0
    move-wide v12, v4

    .line 104
    .end local v4    # "length":J
    .local v12, "length":J
    :goto_0
    new-instance v4, Landroidx/media3/extractor/DefaultExtractorInput;

    iget-object v7, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    iget-wide v8, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    move-object v6, v4

    move-wide v10, v12

    invoke-direct/range {v6 .. v11}, Landroidx/media3/extractor/DefaultExtractorInput;-><init>(Landroidx/media3/common/DataReader;JJ)V

    move-object v11, v4

    .line 107
    .local v11, "extractorInput":Landroidx/media3/extractor/ExtractorInput;
    const/4 v4, 0x0

    move v14, v4

    .line 108
    .local v14, "result":I
    :goto_1
    const/4 v4, -0x1

    const/4 v15, 0x1

    if-eq v14, v4, :cond_1

    .line 109
    iget-wide v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    int-to-long v6, v14

    add-long/2addr v4, v6

    iput-wide v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    .line 110
    const v4, 0x7fffffff

    invoke-interface {v3, v11, v4, v15}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/DataReader;IZ)I

    move-result v4

    move v14, v4

    goto :goto_1

    .line 112
    :cond_1
    iget-wide v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->nextLoadPosition:J

    long-to-int v10, v4

    .line 113
    .local v10, "sampleSize":I
    iget-wide v5, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->startTimeUs:J

    const/4 v7, 0x1

    const/4 v9, 0x0

    const/16 v16, 0x0

    move-object v4, v3

    move v8, v10

    move/from16 v17, v10

    .end local v10    # "sampleSize":I
    .local v17, "sampleSize":I
    move-object/from16 v10, v16

    invoke-interface/range {v4 .. v10}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 115
    .end local v0    # "loadDataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v11    # "extractorInput":Landroidx/media3/extractor/ExtractorInput;
    .end local v12    # "length":J
    .end local v14    # "result":I
    .end local v17    # "sampleSize":I
    iget-object v0, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-static {v0}, Landroidx/media3/datasource/DataSourceUtil;->closeQuietly(Landroidx/media3/datasource/DataSource;)V

    .line 116
    nop

    .line 117
    iput-boolean v15, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->loadCompleted:Z

    .line 118
    return-void

    .line 115
    :catchall_0
    move-exception v0

    iget-object v4, v1, Landroidx/media3/exoplayer/source/chunk/SingleSampleMediaChunk;->dataSource:Landroidx/media3/datasource/StatsDataSource;

    invoke-static {v4}, Landroidx/media3/datasource/DataSourceUtil;->closeQuietly(Landroidx/media3/datasource/DataSource;)V

    .line 116
    throw v0
.end method
