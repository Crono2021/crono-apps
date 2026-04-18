.class public final Landroidx/media3/exoplayer/offline/ProgressiveDownloader;
.super Ljava/lang/Object;
.source "ProgressiveDownloader.java"

# interfaces
.implements Landroidx/media3/exoplayer/offline/Downloader;


# instance fields
.field private final cacheWriter:Landroidx/media3/datasource/cache/CacheWriter;

.field private final dataSource:Landroidx/media3/datasource/cache/CacheDataSource;

.field private final dataSpec:Landroidx/media3/datasource/DataSpec;

.field private volatile downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/util/RunnableFutureTask<",
            "Ljava/lang/Void;",
            "Ljava/io/IOException;",
            ">;"
        }
    .end annotation
.end field

.field private final executor:Ljava/util/concurrent/Executor;

.field private volatile isCanceled:Z

.field private final priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

.field private progressListener:Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;


# direct methods
.method public static synthetic $r8$lambda$W_vYdyyILarXH18GMHpFmLUxauA(Landroidx/media3/exoplayer/offline/ProgressiveDownloader;JJJ)V
    .locals 0

    invoke-direct/range {p0 .. p6}, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->onProgress(JJJ)V

    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/MediaItem;Landroidx/media3/datasource/cache/CacheDataSource$Factory;)V
    .locals 1
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;
    .param p2, "cacheDataSourceFactory"    # Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    .line 60
    new-instance v0, Landroidx/media3/exoplayer/offline/DefaultDownloaderFactory$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/exoplayer/offline/DefaultDownloaderFactory$$ExternalSyntheticLambda0;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;-><init>(Landroidx/media3/common/MediaItem;Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;)V

    .line 61
    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/MediaItem;Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;)V
    .locals 5
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;
    .param p2, "cacheDataSourceFactory"    # Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .param p3, "executor"    # Ljava/util/concurrent/Executor;

    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    invoke-static {p3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/concurrent/Executor;

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->executor:Ljava/util/concurrent/Executor;

    .line 76
    iget-object v0, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    new-instance v0, Landroidx/media3/datasource/DataSpec$Builder;

    invoke-direct {v0}, Landroidx/media3/datasource/DataSpec$Builder;-><init>()V

    iget-object v1, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    iget-object v1, v1, Landroidx/media3/common/MediaItem$LocalConfiguration;->uri:Landroid/net/Uri;

    .line 79
    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    iget-object v1, p1, Landroidx/media3/common/MediaItem;->localConfiguration:Landroidx/media3/common/MediaItem$LocalConfiguration;

    iget-object v1, v1, Landroidx/media3/common/MediaItem$LocalConfiguration;->customCacheKey:Ljava/lang/String;

    .line 80
    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setKey(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 81
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/DataSpec$Builder;->setFlags(I)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v0

    .line 82
    invoke-virtual {v0}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->dataSpec:Landroidx/media3/datasource/DataSpec;

    .line 83
    invoke-virtual {p2}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceForDownloading()Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->dataSource:Landroidx/media3/datasource/cache/CacheDataSource;

    .line 85
    new-instance v2, Landroidx/media3/exoplayer/offline/ProgressiveDownloader$$ExternalSyntheticLambda0;

    invoke-direct {v2, p0}, Landroidx/media3/exoplayer/offline/ProgressiveDownloader$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/offline/ProgressiveDownloader;)V

    .line 86
    .local v2, "progressListener":Landroidx/media3/datasource/cache/CacheWriter$ProgressListener;
    new-instance v3, Landroidx/media3/datasource/cache/CacheWriter;

    const/4 v4, 0x0

    invoke-direct {v3, v1, v0, v4, v2}, Landroidx/media3/datasource/cache/CacheWriter;-><init>(Landroidx/media3/datasource/cache/CacheDataSource;Landroidx/media3/datasource/DataSpec;[BLandroidx/media3/datasource/cache/CacheWriter$ProgressListener;)V

    iput-object v3, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->cacheWriter:Landroidx/media3/datasource/cache/CacheWriter;

    .line 88
    invoke-virtual {p2}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->getUpstreamPriorityTaskManager()Landroidx/media3/common/PriorityTaskManager;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    .line 89
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/offline/ProgressiveDownloader;)Landroidx/media3/datasource/cache/CacheWriter;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/offline/ProgressiveDownloader;

    .line 39
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->cacheWriter:Landroidx/media3/datasource/cache/CacheWriter;

    return-object v0
.end method

.method private onProgress(JJJ)V
    .locals 6
    .param p1, "contentLength"    # J
    .param p3, "bytesCached"    # J
    .param p5, "newBytesCached"    # J

    .line 159
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->progressListener:Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;

    if-nez v0, :cond_0

    .line 160
    return-void

    .line 163
    :cond_0
    const-wide/16 v1, -0x1

    cmp-long v1, p1, v1

    if-eqz v1, :cond_2

    const-wide/16 v1, 0x0

    cmp-long v1, p1, v1

    if-nez v1, :cond_1

    goto :goto_0

    .line 165
    :cond_1
    long-to-float v1, p3

    const/high16 v2, 0x42c80000    # 100.0f

    mul-float/2addr v1, v2

    long-to-float v2, p1

    div-float/2addr v1, v2

    move v5, v1

    goto :goto_1

    .line 164
    :cond_2
    :goto_0
    const/high16 v1, -0x40800000    # -1.0f

    move v5, v1

    .line 165
    :goto_1
    nop

    .line 166
    .local v5, "percentDownloaded":F
    move-wide v1, p1

    move-wide v3, p3

    invoke-interface/range {v0 .. v5}, Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;->onProgress(JJF)V

    .line 167
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 2

    .line 146
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->isCanceled:Z

    .line 147
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    .line 148
    .local v1, "downloadRunnable":Landroidx/media3/common/util/RunnableFutureTask;, "Landroidx/media3/common/util/RunnableFutureTask<Ljava/lang/Void;Ljava/io/IOException;>;"
    if-eqz v1, :cond_0

    .line 149
    invoke-virtual {v1, v0}, Landroidx/media3/common/util/RunnableFutureTask;->cancel(Z)Z

    .line 151
    :cond_0
    return-void
.end method

.method public download(Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;)V
    .locals 5
    .param p1, "progressListener"    # Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .line 94
    iput-object p1, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->progressListener:Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;

    .line 95
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    const/16 v1, -0x3e8

    if-eqz v0, :cond_0

    .line 96
    invoke-virtual {v0, v1}, Landroidx/media3/common/PriorityTaskManager;->add(I)V

    .line 99
    :cond_0
    const/4 v0, 0x0

    .line 100
    .local v0, "finished":Z
    :goto_0
    if-nez v0, :cond_5

    :try_start_0
    iget-boolean v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->isCanceled:Z

    if-nez v2, :cond_5

    .line 102
    new-instance v2, Landroidx/media3/exoplayer/offline/ProgressiveDownloader$1;

    invoke-direct {v2, p0}, Landroidx/media3/exoplayer/offline/ProgressiveDownloader$1;-><init>(Landroidx/media3/exoplayer/offline/ProgressiveDownloader;)V

    iput-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    .line 115
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v2, :cond_1

    .line 116
    invoke-virtual {v2, v1}, Landroidx/media3/common/PriorityTaskManager;->proceed(I)V

    .line 118
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->executor:Ljava/util/concurrent/Executor;

    iget-object v3, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    invoke-interface {v2, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 120
    :try_start_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v2}, Landroidx/media3/common/util/RunnableFutureTask;->get()Ljava/lang/Object;
    :try_end_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 121
    const/4 v0, 0x1

    .line 132
    :goto_1
    goto :goto_0

    .line 122
    :catch_0
    move-exception v2

    .line 123
    .local v2, "e":Ljava/util/concurrent/ExecutionException;
    :try_start_2
    invoke-virtual {v2}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Throwable;

    .line 124
    .local v3, "cause":Ljava/lang/Throwable;
    instance-of v4, v3, Landroidx/media3/common/PriorityTaskManager$PriorityTooLowException;

    if-eqz v4, :cond_2

    goto :goto_1

    .line 126
    :cond_2
    instance-of v4, v3, Ljava/io/IOException;

    if-nez v4, :cond_3

    .line 130
    invoke-static {v3}, Landroidx/media3/common/util/Util;->sneakyThrow(Ljava/lang/Throwable;)V

    goto :goto_1

    .line 127
    :cond_3
    move-object v4, v3

    check-cast v4, Ljava/io/IOException;

    .end local p1    # "progressListener":Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    throw v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 137
    .end local v0    # "finished":Z
    .end local v2    # "e":Ljava/util/concurrent/ExecutionException;
    .end local v3    # "cause":Ljava/lang/Throwable;
    .restart local p1    # "progressListener":Landroidx/media3/exoplayer/offline/Downloader$ProgressListener;
    :catchall_0
    move-exception v0

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v2}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 138
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v2, :cond_4

    .line 139
    invoke-virtual {v2, v1}, Landroidx/media3/common/PriorityTaskManager;->remove(I)V

    .line 141
    :cond_4
    throw v0

    .line 137
    :cond_5
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->downloadRunnable:Landroidx/media3/common/util/RunnableFutureTask;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/common/util/RunnableFutureTask;

    invoke-virtual {v0}, Landroidx/media3/common/util/RunnableFutureTask;->blockUntilFinished()V

    .line 138
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->priorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    if-eqz v0, :cond_6

    .line 139
    invoke-virtual {v0, v1}, Landroidx/media3/common/PriorityTaskManager;->remove(I)V

    .line 142
    :cond_6
    return-void
.end method

.method public remove()V
    .locals 3

    .line 155
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->dataSource:Landroidx/media3/datasource/cache/CacheDataSource;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CacheDataSource;->getCache()Landroidx/media3/datasource/cache/Cache;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->dataSource:Landroidx/media3/datasource/cache/CacheDataSource;

    invoke-virtual {v1}, Landroidx/media3/datasource/cache/CacheDataSource;->getCacheKeyFactory()Landroidx/media3/datasource/cache/CacheKeyFactory;

    move-result-object v1

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/ProgressiveDownloader;->dataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-interface {v1, v2}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/media3/datasource/cache/Cache;->removeResource(Ljava/lang/String;)V

    .line 156
    return-void
.end method
