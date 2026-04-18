.class public abstract Landroidx/media3/exoplayer/offline/SegmentDownloader;
.super Ljava/lang/Object;
.source "SegmentDownloader.java"

# interfaces
.implements Landroidx/media3/exoplayer/offline/Downloader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;,
        Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;,
        Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<M::",
        "Landroidx/media3/exoplayer/offline/FilterableManifest<",
        "TM;>;>",
        "Ljava/lang/Object;",
        "Landroidx/media3/exoplayer/offline/Downloader;"
    }
.end annotation


# static fields
.field private static final BUFFER_SIZE_BYTES:I = 0x20000

.field public static final DEFAULT_MAX_MERGED_SEGMENT_START_TIME_DIFF_MS:J = 0x4e20L


# instance fields
.field private final activeRunnables:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/media3/common/util/RunnableFutureTask<",
            "**>;>;"
        }
    .end annotation
.end field

.field private final cache:Landroidx/media3/datasource/cache/Cache;

.field private final cacheDataSourceFactory:Landroidx/media3/datasource/cache/CacheDataSource$Factory;

.field private final cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

.field private final executor:Ljava/util/concurrent/Executor;

.field private volatile isCanceled:Z

.field private final manifestDataSpec:Landroidx/media3/datasource/DataSpec;

.field private final manifestParser:Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser<",
            "TM;>;"
        }
    .end annotation
.end field

.field private final maxMergedSegmentStartTimeDiffUs:J

.field private final priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

.field private final streamKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/media3/common/StreamKey;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroidx/media3/common/MediaItem;Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;)V
    .locals 7
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;
    .param p3, "cacheDataSourceFactory"    # Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .param p4, "executor"    # Ljava/util/concurrent/Executor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/MediaItem;",
            "Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser<",
            "TM;>;",
            "Landroidx/media3/datasource/cache/CacheDataSource$Factory;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 114
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    .local p2, "manifestParser":Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;, "Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser<TM;>;"
    const-wide/16 v5, 0x4e20

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/offline/SegmentDownloader;-><init>(Landroidx/media3/common/MediaItem;Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;J)V

    .line 120
    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/MediaItem;Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;J)V
    .locals 2
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;
    .param p3, "cacheDataSourceFactory"    # Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .param p4, "executor"    # Ljava/util/concurrent/Executor;
    .param p5, "maxMergedSegmentStartTimeDiffMs"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/MediaItem;",
            "Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser<",
            "TM;>;",
            "Landroidx/media3/datasource/cache/CacheDataSource$Factory;",
            "Ljava/util/concurrent/Executor;",
            "J)V"
        }
    .end annotation

    .line 139
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    .local p2, "manifestParser":Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;, "Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser<TM;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 140
    iget-object v0, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    iget-object v0, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    iget-object v0, v0, Landroidx/media3/common/MediaItem$LocalConfiguration;->uri:Landroid/net/Uri;

    invoke-static {v0}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->getCompressibleDataSpec(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 142
    iput-object p2, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestParser:Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;

    .line 143
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    iget-object v1, v1, Landroidx/media3/common/MediaItem$LocalConfiguration;->streamKeys:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->streamKeys:Ljava/util/ArrayList;

    .line 144
    iput-object p3, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheDataSourceFactory:Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    .line 145
    iput-object p4, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->executor:Ljava/util/concurrent/Executor;

    .line 146
    invoke-virtual {p3}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->getCache()Landroidx/media3/datasource/cache/Cache;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/datasource/cache/Cache;

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    .line 147
    invoke-virtual {p3}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->getCacheKeyFactory()Landroidx/media3/datasource/cache/CacheKeyFactory;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 148
    invoke-virtual {p3}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->getUpstreamPriorityTaskManager()Landroidx/media3/common/PriorityTaskManager;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    .line 150
    invoke-static {p5, p6}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->maxMergedSegmentStartTimeDiffUs:J

    .line 151
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/offline/SegmentDownloader;)Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/offline/SegmentDownloader;

    .line 55
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestParser:Landroidx/media3/exoplayer/upstream/ParsingLoadable$Parser;

    return-object v0
.end method

.method private addActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroidx/media3/common/util/RunnableFutureTask<",
            "TT;*>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .line 425
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    .local p1, "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    monitor-enter v0

    .line 426
    :try_start_0
    iget-boolean v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->isCanceled:Z

    if-nez v1, :cond_0

    .line 429
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 430
    monitor-exit v0

    .line 431
    return-void

    .line 427
    :cond_0
    new-instance v1, Ljava/lang/InterruptedException;

    invoke-direct {v1}, Ljava/lang/InterruptedException;-><init>()V

    .end local p1    # "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    throw v1

    .line 430
    .restart local p1    # "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static canMergeSegments(Landroidx/media3/datasource/DataSpec;Landroidx/media3/datasource/DataSpec;)Z
    .locals 4
    .param p0, "dataSpec1"    # Landroidx/media3/datasource/DataSpec;
    .param p1, "dataSpec2"    # Landroidx/media3/datasource/DataSpec;

    .line 475
    iget-object v0, p0, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    iget-object v1, p1, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-wide v0, p0, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Landroidx/media3/datasource/DataSpec;->position:J

    iget-wide v2, p0, Landroidx/media3/datasource/DataSpec;->length:J

    add-long/2addr v0, v2

    iget-wide v2, p1, Landroidx/media3/datasource/DataSpec;->position:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/datasource/DataSpec;->key:Ljava/lang/String;

    iget-object v1, p1, Landroidx/media3/datasource/DataSpec;->key:Ljava/lang/String;

    .line 478
    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/datasource/DataSpec;->flags:I

    iget v1, p1, Landroidx/media3/datasource/DataSpec;->flags:I

    if-ne v0, v1, :cond_0

    iget v0, p0, Landroidx/media3/datasource/DataSpec;->httpMethod:I

    iget v1, p1, Landroidx/media3/datasource/DataSpec;->httpMethod:I

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Landroidx/media3/datasource/DataSpec;->httpRequestHeaders:Ljava/util/Map;

    iget-object v1, p1, Landroidx/media3/datasource/DataSpec;->httpRequestHeaders:Ljava/util/Map;

    .line 481
    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 475
    :goto_0
    return v0
.end method

.method protected static getCompressibleDataSpec(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec;
    .locals 2
    .param p0, "uri"    # Landroid/net/Uri;

    .line 420
    new-instance v0, Landroidx/media3/datasource/DataSpec$Builder;

    invoke-direct {v0}, Landroidx/media3/datasource/DataSpec$Builder;-><init>()V

    invoke-virtual {v0, p0}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setFlags(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    return-object v0
.end method

.method private static mergeSegments(Ljava/util/List;Landroidx/media3/datasource/cache/CacheKeyFactory;J)V
    .locals 16
    .param p1, "keyFactory"    # Landroidx/media3/datasource/cache/CacheKeyFactory;
    .param p2, "maxMergedSegmentStartTimeDiffUs"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;",
            ">;",
            "Landroidx/media3/datasource/cache/CacheKeyFactory;",
            "J)V"
        }
    .end annotation

    .line 447
    .local p0, "segments":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    move-object/from16 v0, p0

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 448
    .local v1, "lastIndexByCacheKey":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Integer;>;"
    const/4 v2, 0x0

    .line 449
    .local v2, "nextOutIndex":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface/range {p0 .. p0}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_4

    .line 450
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    .line 451
    .local v4, "segment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    iget-object v5, v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    move-object/from16 v6, p1

    invoke-interface {v6, v5}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v5

    .line 452
    .local v5, "cacheKey":Ljava/lang/String;
    invoke-virtual {v1, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    .line 453
    .local v7, "lastIndex":Ljava/lang/Integer;
    if-nez v7, :cond_0

    const/4 v8, 0x0

    goto :goto_1

    :cond_0
    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    .line 454
    .local v8, "lastSegment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    :goto_1
    if-eqz v8, :cond_3

    iget-wide v9, v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->startTimeUs:J

    iget-wide v11, v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->startTimeUs:J

    add-long v11, v11, p2

    cmp-long v9, v9, v11

    if-gtz v9, :cond_3

    iget-object v9, v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    iget-object v10, v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 456
    invoke-static {v9, v10}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->canMergeSegments(Landroidx/media3/datasource/DataSpec;Landroidx/media3/datasource/DataSpec;)Z

    move-result v9

    if-nez v9, :cond_1

    goto :goto_3

    .line 462
    :cond_1
    iget-object v9, v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    iget-wide v9, v9, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v11, -0x1

    cmp-long v9, v9, v11

    if-nez v9, :cond_2

    .line 463
    goto :goto_2

    .line 464
    :cond_2
    iget-object v9, v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    iget-wide v9, v9, Landroidx/media3/datasource/DataSpec;->length:J

    iget-object v11, v4, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    iget-wide v11, v11, Landroidx/media3/datasource/DataSpec;->length:J

    add-long/2addr v11, v9

    :goto_2
    move-wide v9, v11

    .line 465
    .local v9, "mergedLength":J
    iget-object v11, v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    const-wide/16 v12, 0x0

    invoke-virtual {v11, v12, v13, v9, v10}, Landroidx/media3/datasource/DataSpec;->subrange(JJ)Landroidx/media3/datasource/DataSpec;

    move-result-object v11

    .line 466
    .local v11, "mergedDataSpec":Landroidx/media3/datasource/DataSpec;
    nop

    .line 467
    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/Integer;

    invoke-virtual {v12}, Ljava/lang/Integer;->intValue()I

    move-result v12

    new-instance v13, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    iget-wide v14, v8, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->startTimeUs:J

    invoke-direct {v13, v14, v15, v11}, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;-><init>(JLandroidx/media3/datasource/DataSpec;)V

    .line 466
    invoke-interface {v0, v12, v13}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 457
    .end local v9    # "mergedLength":J
    .end local v11    # "mergedDataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_3
    :goto_3
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v1, v5, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 458
    invoke-interface {v0, v2, v4}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 459
    add-int/lit8 v2, v2, 0x1

    .line 449
    .end local v4    # "segment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    .end local v5    # "cacheKey":Ljava/lang/String;
    .end local v7    # "lastIndex":Ljava/lang/Integer;
    .end local v8    # "lastSegment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    :goto_4
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_0

    :cond_4
    move-object/from16 v6, p1

    .line 471
    .end local v3    # "i":I
    invoke-interface/range {p0 .. p0}, Ljava/util/List;->size()I

    move-result v3

    invoke-static {v0, v2, v3}, Landroidx/media3/common/util/Util;->removeRange(Ljava/util/List;II)V

    .line 472
    return-void
.end method

.method private removeActiveRunnable(I)V
    .locals 2
    .param p1, "index"    # I

    .line 440
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    monitor-enter v0

    .line 441
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 442
    monitor-exit v0

    .line 443
    return-void

    .line 442
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private removeActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/RunnableFutureTask<",
            "**>;)V"
        }
    .end annotation

    .line 434
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    .local p1, "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<**>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    monitor-enter v0

    .line 435
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 436
    monitor-exit v0

    .line 437
    return-void

    .line 436
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public cancel()V
    .locals 4

    .line 297
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    monitor-enter v0

    .line 298
    const/4 v1, 0x1

    :try_start_0
    iput-boolean v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->isCanceled:Z

    .line 299
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 300
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v3, v1}, Landroidx/media3/common/util/RunnableFutureTask;->cancel(Z)Z

    .line 299
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 302
    .end local v2    # "i":I
    :cond_0
    monitor-exit v0

    .line 303
    return-void

    .line 302
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public final download(Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;)V
    .locals 30
    .param p1, "progressListener"    # Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .line 156
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    move-object/from16 v1, p0

    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    move-object v2, v0

    .line 157
    .local v2, "pendingSegments":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    move-object v3, v0

    .line 158
    .local v3, "recycledRunnables":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;>;"
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    const/16 v4, -0x3e8

    if-eqz v0, :cond_0

    .line 159
    invoke-virtual {v0, v4}, Landroidx/media3/common/PriorityTaskManager;->add(I)V

    .line 162
    :cond_0
    const/4 v5, 0x1

    :try_start_0
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheDataSourceFactory:Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceForDownloading()Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    move-object v6, v0

    .line 164
    .local v6, "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestDataSpec:Landroidx/media3/datasource/DataSpec;

    const/4 v7, 0x0

    invoke-virtual {v1, v6, v0, v7}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->getManifest(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;Z)Landroidx/media3/exoplayer/offline/FilterableManifest;

    move-result-object v0

    .line 165
    .local v0, "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    iget-object v8, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->streamKeys:Ljava/util/ArrayList;

    invoke-virtual {v8}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_1

    .line 166
    iget-object v8, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->streamKeys:Ljava/util/ArrayList;

    invoke-interface {v0, v8}, Landroidx/media3/exoplayer/offline/FilterableManifest;->copy(Ljava/util/List;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/exoplayer/offline/FilterableManifest;

    move-object v0, v8

    goto :goto_0

    .line 165
    :cond_1
    move-object v8, v0

    .line 168
    .end local v0    # "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    .local v8, "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    :goto_0
    invoke-virtual {v1, v6, v8, v7}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->getSegments(Landroidx/media3/datasource/DataSource;Landroidx/media3/exoplayer/offline/FilterableManifest;Z)Ljava/util/List;

    move-result-object v0

    move-object v7, v0

    .line 172
    .local v7, "segments":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    invoke-static {v7}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 173
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    iget-wide v9, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->maxMergedSegmentStartTimeDiffUs:J

    invoke-static {v7, v0, v9, v10}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->mergeSegments(Ljava/util/List;Landroidx/media3/datasource/cache/CacheKeyFactory;J)V

    .line 176
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v15

    .line 177
    .local v15, "totalSegments":I
    const/4 v0, 0x0

    .line 178
    .local v0, "segmentsDownloaded":I
    const-wide/16 v9, 0x0

    .line 179
    .local v9, "contentLength":J
    const-wide/16 v11, 0x0

    .line 180
    .local v11, "bytesDownloaded":J
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v13

    sub-int/2addr v13, v5

    move-wide/from16 v19, v9

    move-wide/from16 v21, v11

    move v9, v0

    .end local v0    # "segmentsDownloaded":I
    .end local v11    # "bytesDownloaded":J
    .local v9, "segmentsDownloaded":I
    .local v13, "i":I
    .local v19, "contentLength":J
    .local v21, "bytesDownloaded":J
    :goto_1
    if-ltz v13, :cond_7

    .line 181
    invoke-interface {v7, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    iget-object v0, v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 182
    .local v0, "dataSpec":Landroidx/media3/datasource/DataSpec;
    iget-object v10, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    invoke-interface {v10, v0}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v10

    .line 183
    .local v10, "cacheKey":Ljava/lang/String;
    iget-wide v11, v0, Landroidx/media3/datasource/DataSpec;->length:J

    .line 184
    .local v11, "segmentLength":J
    const-wide/16 v16, -0x1

    cmp-long v14, v11, v16

    if-nez v14, :cond_3

    .line 185
    iget-object v14, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    .line 186
    invoke-interface {v14, v10}, Landroidx/media3/datasource/cache/Cache;->getContentMetadata(Ljava/lang/String;)Landroidx/media3/datasource/cache/ContentMetadata;

    move-result-object v14

    invoke-static {v14}, Landroidx/media3/datasource/cache/ContentMetadata;->getContentLength(Landroidx/media3/datasource/cache/ContentMetadata;)J

    move-result-wide v23

    .line 187
    .local v23, "resourceLength":J
    cmp-long v14, v23, v16

    if-eqz v14, :cond_2

    .line 188
    move-object/from16 v29, v6

    .end local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .local v29, "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    iget-wide v5, v0, Landroidx/media3/datasource/DataSpec;->position:J

    sub-long v11, v23, v5

    goto :goto_2

    .line 187
    .end local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .restart local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :cond_2
    move-object/from16 v29, v6

    .end local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .restart local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    goto :goto_2

    .line 184
    .end local v23    # "resourceLength":J
    .end local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .restart local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :cond_3
    move-object/from16 v29, v6

    .line 191
    .end local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .restart local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :goto_2
    iget-object v5, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    move-object v14, v5

    iget-wide v4, v0, Landroidx/media3/datasource/DataSpec;->position:J

    .line 192
    move-object/from16 v23, v14

    move-object/from16 v24, v10

    move-wide/from16 v25, v4

    move-wide/from16 v27, v11

    invoke-interface/range {v23 .. v28}, Landroidx/media3/datasource/cache/Cache;->getCachedBytes(Ljava/lang/String;JJ)J

    move-result-wide v4

    .line 193
    .local v4, "segmentBytesDownloaded":J
    add-long v21, v21, v4

    .line 194
    cmp-long v14, v11, v16

    if-eqz v14, :cond_5

    .line 195
    cmp-long v14, v11, v4

    if-nez v14, :cond_4

    .line 197
    add-int/lit8 v9, v9, 0x1

    .line 198
    invoke-interface {v7, v13}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 200
    :cond_4
    cmp-long v14, v19, v16

    if-eqz v14, :cond_6

    .line 201
    add-long v19, v19, v11

    goto :goto_3

    .line 204
    :cond_5
    const-wide/16 v16, -0x1

    move-wide/from16 v19, v16

    .line 180
    .end local v0    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v4    # "segmentBytesDownloaded":J
    .end local v10    # "cacheKey":Ljava/lang/String;
    .end local v11    # "segmentLength":J
    :cond_6
    :goto_3
    add-int/lit8 v13, v13, -0x1

    move-object/from16 v6, v29

    const/16 v4, -0x3e8

    const/4 v5, 0x1

    goto :goto_1

    .end local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .restart local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :cond_7
    move-object/from16 v29, v6

    .line 211
    .end local v6    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .end local v13    # "i":I
    .restart local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    if-eqz p1, :cond_8

    .line 212
    new-instance v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;

    move-object v11, v0

    move-object/from16 v12, p1

    move-wide/from16 v13, v19

    move-wide/from16 v16, v21

    move/from16 v18, v9

    invoke-direct/range {v11 .. v18}, Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;-><init>(Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;JIJI)V

    goto :goto_4

    .line 218
    :cond_8
    const/4 v0, 0x0

    :goto_4
    move-object v4, v0

    .line 219
    .local v4, "progressNotifier":Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;
    invoke-virtual {v2, v7}, Ljava/util/ArrayDeque;->addAll(Ljava/util/Collection;)Z

    .line 220
    :goto_5
    iget-boolean v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->isCanceled:Z

    if-nez v0, :cond_10

    invoke-virtual {v2}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_10

    .line 222
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v0, :cond_9

    .line 223
    const/16 v5, -0x3e8

    invoke-virtual {v0, v5}, Landroidx/media3/common/PriorityTaskManager;->proceed(I)V

    .line 229
    :cond_9
    invoke-virtual {v3}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 230
    invoke-virtual {v3}, Ljava/util/ArrayDeque;->removeFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;

    .line 231
    .local v0, "recycledRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    iget-object v5, v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->dataSource:Landroidx/media3/datasource/cache/CacheDataSource;

    .line 232
    .local v5, "segmentDataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    iget-object v10, v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->temporaryBuffer:[B

    move-object v0, v10

    .line 233
    .local v0, "temporaryBuffer":[B
    move-object v10, v5

    move-object v5, v0

    goto :goto_6

    .line 234
    .end local v0    # "temporaryBuffer":[B
    .end local v5    # "segmentDataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :cond_a
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheDataSourceFactory:Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceForDownloading()Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    move-object v5, v0

    .line 235
    .restart local v5    # "segmentDataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    const/high16 v0, 0x20000

    new-array v0, v0, [B

    move-object v10, v5

    move-object v5, v0

    .line 237
    .local v5, "temporaryBuffer":[B
    .local v10, "segmentDataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :goto_6
    invoke-virtual {v2}, Ljava/util/ArrayDeque;->removeFirst()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    move-object v11, v0

    .line 238
    .local v11, "segment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    new-instance v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;

    invoke-direct {v0, v11, v10, v4, v5}, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;-><init>(Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;Landroidx/media3/datasource/cache/CacheDataSource;Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;[B)V

    move-object v12, v0

    .line 241
    .local v12, "downloadRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    invoke-direct {v1, v12}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->addActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V

    .line 242
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->executor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, v12}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 245
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v13, 0x1

    sub-int/2addr v0, v13

    move v13, v0

    .local v13, "j":I
    :goto_7
    if-ltz v13, :cond_f

    .line 246
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v0, v13}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;

    move-object v14, v0

    .line 250
    .local v14, "activeRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    invoke-virtual {v2}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    invoke-virtual {v14}, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->isDone()Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_d

    .line 252
    :cond_b
    :try_start_1
    invoke-virtual {v14}, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->get()Ljava/lang/Object;

    .line 253
    invoke-direct {v1, v13}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(I)V

    .line 254
    invoke-virtual {v3, v14}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 268
    goto :goto_8

    .line 255
    :catch_0
    move-exception v0

    .line 256
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    :try_start_2
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/Throwable;

    move-object/from16 v17, v16

    .line 257
    .local v17, "cause":Ljava/lang/Throwable;
    move-object/from16 v6, v17

    move-object/from16 v17, v0

    .end local v0    # "e":Ljava/util/concurrent/ExecutionException;
    .local v6, "cause":Ljava/lang/Throwable;
    .local v17, "e":Ljava/util/concurrent/ExecutionException;
    instance-of v0, v6, Landroidx/media3/common/PriorityTaskManager$PriorityTooLowException;

    if-eqz v0, :cond_c

    .line 259
    iget-object v0, v14, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->segment:Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    invoke-virtual {v2, v0}, Ljava/util/ArrayDeque;->addFirst(Ljava/lang/Object;)V

    .line 260
    invoke-direct {v1, v13}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(I)V

    .line 261
    invoke-virtual {v3, v14}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V

    goto :goto_8

    .line 262
    :cond_c
    instance-of v0, v6, Ljava/io/IOException;

    if-nez v0, :cond_e

    .line 266
    invoke-static {v6}, Landroidx/media3/common/util/Util;->sneakyThrow(Ljava/lang/Throwable;)V

    .line 245
    .end local v6    # "cause":Ljava/lang/Throwable;
    .end local v14    # "activeRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    .end local v17    # "e":Ljava/util/concurrent/ExecutionException;
    :cond_d
    :goto_8
    add-int/lit8 v13, v13, -0x1

    goto :goto_7

    .line 263
    .restart local v6    # "cause":Ljava/lang/Throwable;
    .restart local v14    # "activeRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    .restart local v17    # "e":Ljava/util/concurrent/ExecutionException;
    :cond_e
    move-object v0, v6

    check-cast v0, Ljava/io/IOException;

    .end local v2    # "pendingSegments":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    .end local v3    # "recycledRunnables":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;>;"
    .end local p1    # "progressListener":Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    throw v0

    .line 274
    .end local v6    # "cause":Ljava/lang/Throwable;
    .end local v13    # "j":I
    .end local v14    # "activeRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    .end local v17    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v2    # "pendingSegments":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    .restart local v3    # "recycledRunnables":Ljava/util/ArrayDeque;, "Ljava/util/ArrayDeque<Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;>;"
    .restart local p1    # "progressListener":Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    :cond_f
    invoke-virtual {v12}, Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;->blockUntilStarted()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 275
    .end local v5    # "temporaryBuffer":[B
    .end local v10    # "segmentDataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    .end local v11    # "segment":Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;
    .end local v12    # "downloadRunnable":Landroidx/media3/exoplayer/offline/SegmentDownloader$SegmentDownloadRunnable;
    goto/16 :goto_5

    .line 280
    .end local v4    # "progressNotifier":Landroidx/media3/exoplayer/offline/SegmentDownloader$ProgressNotifier;
    .end local v7    # "segments":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    .end local v8    # "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    .end local v9    # "segmentsDownloaded":I
    .end local v15    # "totalSegments":I
    .end local v19    # "contentLength":J
    .end local v21    # "bytesDownloaded":J
    .end local v29    # "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :cond_10
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_9
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-ge v0, v4, :cond_11

    .line 281
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/util/RunnableFutureTask;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Landroidx/media3/common/util/RunnableFutureTask;->cancel(Z)Z

    .line 280
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    :cond_11
    const/4 v5, 0x1

    .line 285
    .end local v0    # "i":I
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    sub-int/2addr v0, v5

    .restart local v0    # "i":I
    :goto_a
    if-ltz v0, :cond_12

    .line 286
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v4}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 287
    invoke-direct {v1, v0}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(I)V

    .line 285
    add-int/lit8 v0, v0, -0x1

    goto :goto_a

    .line 289
    .end local v0    # "i":I
    :cond_12
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v0, :cond_13

    .line 290
    const/16 v4, -0x3e8

    invoke-virtual {v0, v4}, Landroidx/media3/common/PriorityTaskManager;->remove(I)V

    .line 293
    :cond_13
    return-void

    .line 280
    :catchall_0
    move-exception v0

    const/4 v4, 0x0

    .local v4, "i":I
    :goto_b
    iget-object v5, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v4, v5, :cond_14

    .line 281
    iget-object v5, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/common/util/RunnableFutureTask;

    const/4 v7, 0x1

    invoke-virtual {v5, v7}, Landroidx/media3/common/util/RunnableFutureTask;->cancel(Z)Z

    .line 280
    add-int/lit8 v4, v4, 0x1

    goto :goto_b

    :cond_14
    const/4 v7, 0x1

    .line 285
    .end local v4    # "i":I
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    sub-int/2addr v4, v7

    .restart local v4    # "i":I
    :goto_c
    if-ltz v4, :cond_15

    .line 286
    iget-object v5, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->activeRunnables:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v5}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 287
    invoke-direct {v1, v4}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(I)V

    .line 285
    add-int/lit8 v4, v4, -0x1

    goto :goto_c

    .line 289
    .end local v4    # "i":I
    :cond_15
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v4, :cond_16

    .line 290
    const/16 v5, -0x3e8

    invoke-virtual {v4, v5}, Landroidx/media3/common/PriorityTaskManager;->remove(I)V

    .line 292
    :cond_16
    throw v0
.end method

.method protected final execute(Landroidx/media3/common/util/RunnableFutureTask;Z)Ljava/lang/Object;
    .locals 3
    .param p2, "removing"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroidx/media3/common/util/RunnableFutureTask<",
            "TT;*>;Z)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 359
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    .local p1, "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    if-eqz p2, :cond_1

    .line 360
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->run()V

    .line 362
    :try_start_0
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->get()Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    .line 363
    :catch_0
    move-exception v0

    .line 364
    .local v0, "e":Ljava/util/concurrent/ExecutionException;
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    .line 365
    .local v1, "cause":Ljava/lang/Throwable;
    instance-of v2, v1, Ljava/io/IOException;

    if-nez v2, :cond_0

    .line 369
    invoke-static {v0}, Landroidx/media3/common/util/Util;->sneakyThrow(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 366
    :cond_0
    move-object v2, v1

    check-cast v2, Ljava/io/IOException;

    throw v2

    .line 374
    .end local v0    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v1    # "cause":Ljava/lang/Throwable;
    :cond_1
    :goto_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->isCanceled:Z

    if-nez v0, :cond_5

    .line 378
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v0, :cond_2

    .line 379
    const/16 v1, -0x3e8

    invoke-virtual {v0, v1}, Landroidx/media3/common/PriorityTaskManager;->proceed(I)V

    .line 381
    :cond_2
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->addActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V

    .line 382
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->executor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 384
    :try_start_1
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->get()Ljava/lang/Object;

    move-result-object v0
    :try_end_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 397
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 398
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V

    .line 384
    return-object v0

    .line 397
    :catchall_0
    move-exception v0

    goto :goto_2

    .line 385
    :catch_1
    move-exception v0

    .line 386
    .restart local v0    # "e":Ljava/util/concurrent/ExecutionException;
    :try_start_2
    invoke-virtual {v0}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Throwable;

    .line 387
    .restart local v1    # "cause":Ljava/lang/Throwable;
    instance-of v2, v1, Landroidx/media3/common/PriorityTaskManager$PriorityTooLowException;

    if-eqz v2, :cond_3

    goto :goto_1

    .line 389
    :cond_3
    instance-of v2, v1, Ljava/io/IOException;

    if-nez v2, :cond_4

    .line 393
    invoke-static {v0}, Landroidx/media3/common/util/Util;->sneakyThrow(Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 397
    .end local v0    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v1    # "cause":Ljava/lang/Throwable;
    :goto_1
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 398
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V

    .line 399
    goto :goto_0

    .line 390
    .restart local v0    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v1    # "cause":Ljava/lang/Throwable;
    :cond_4
    :try_start_3
    move-object v2, v1

    check-cast v2, Ljava/io/IOException;

    .end local p1    # "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    .end local p2    # "removing":Z
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 397
    .end local v0    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v1    # "cause":Ljava/lang/Throwable;
    .restart local p1    # "runnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<TT;*>;"
    .restart local p2    # "removing":Z
    :goto_2
    invoke-virtual {p1}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 398
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->removeActiveRunnable(Landroidx/media3/common/util/RunnableFutureTask;)V

    .line 399
    throw v0

    .line 375
    :cond_5
    new-instance v0, Ljava/lang/InterruptedException;

    invoke-direct {v0}, Ljava/lang/InterruptedException;-><init>()V

    throw v0
.end method

.method protected final getManifest(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;Z)Landroidx/media3/exoplayer/offline/FilterableManifest;
    .locals 1
    .param p1, "dataSource"    # Landroidx/media3/datasource/DataSource;
    .param p2, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p3, "removing"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/datasource/DataSource;",
            "Landroidx/media3/datasource/DataSpec;",
            "Z)TM;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Ljava/io/IOException;
        }
    .end annotation

    .line 338
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    new-instance v0, Landroidx/media3/exoplayer/offline/SegmentDownloader$1;

    invoke-direct {v0, p0, p1, p2}, Landroidx/media3/exoplayer/offline/SegmentDownloader$1;-><init>(Landroidx/media3/exoplayer/offline/SegmentDownloader;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;)V

    invoke-virtual {p0, v0, p3}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->execute(Landroidx/media3/common/util/RunnableFutureTask;Z)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/offline/FilterableManifest;

    return-object v0
.end method

.method protected abstract getSegments(Landroidx/media3/datasource/DataSource;Landroidx/media3/exoplayer/offline/FilterableManifest;Z)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/datasource/DataSource;",
            "TM;Z)",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation
.end method

.method public final remove()V
    .locals 7

    .line 307
    .local p0, "this":Landroidx/media3/exoplayer/offline/SegmentDownloader;, "Landroidx/media3/exoplayer/offline/SegmentDownloader<TM;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheDataSourceFactory:Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceForRemovingDownload()Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    .line 309
    .local v0, "dataSource":Landroidx/media3/datasource/cache/CacheDataSource;
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestDataSpec:Landroidx/media3/datasource/DataSpec;

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->getManifest(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSpec;Z)Landroidx/media3/exoplayer/offline/FilterableManifest;

    move-result-object v1

    .line 310
    .local v1, "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    invoke-virtual {p0, v0, v1, v2}, Landroidx/media3/exoplayer/offline/SegmentDownloader;->getSegments(Landroidx/media3/datasource/DataSource;Landroidx/media3/exoplayer/offline/FilterableManifest;Z)Ljava/util/List;

    move-result-object v2

    .line 311
    .local v2, "segments":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    if-ge v3, v4, :cond_0

    .line 312
    iget-object v4, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-object v5, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;

    iget-object v6, v6, Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;->dataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-interface {v5, v6}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Landroidx/media3/datasource/cache/Cache;->removeResource(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 311
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .end local v1    # "manifest":Landroidx/media3/exoplayer/offline/FilterableManifest;, "TM;"
    .end local v2    # "segments":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/SegmentDownloader$Segment;>;"
    .end local v3    # "i":I
    :cond_0
    goto :goto_1

    .line 320
    :catchall_0
    move-exception v1

    goto :goto_3

    .line 316
    :catch_0
    move-exception v1

    .line 320
    :goto_1
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    iget-object v3, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestDataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-interface {v2, v3}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroidx/media3/datasource/cache/Cache;->removeResource(Ljava/lang/String;)V

    .line 321
    goto :goto_2

    .line 314
    :catch_1
    move-exception v1

    .line 315
    .local v1, "e":Ljava/lang/InterruptedException;
    :try_start_1
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->interrupt()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v1    # "e":Ljava/lang/InterruptedException;
    goto :goto_1

    .line 322
    :goto_2
    return-void

    .line 320
    :goto_3
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-object v3, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    iget-object v4, p0, Landroidx/media3/exoplayer/offline/SegmentDownloader;->manifestDataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-interface {v3, v4}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Landroidx/media3/datasource/cache/Cache;->removeResource(Ljava/lang/String;)V

    .line 321
    throw v1
.end method
