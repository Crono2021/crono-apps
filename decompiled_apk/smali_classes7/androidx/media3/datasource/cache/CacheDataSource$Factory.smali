.class public final Landroidx/media3/datasource/cache/CacheDataSource$Factory;
.super Ljava/lang/Object;
.source "CacheDataSource.java"

# interfaces
.implements Landroidx/media3/datasource/DataSource$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/datasource/cache/CacheDataSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Factory"
.end annotation


# instance fields
.field private cache:Landroidx/media3/datasource/cache/Cache;

.field private cacheIsReadOnly:Z

.field private cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

.field private cacheReadDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

.field private cacheWriteDataSinkFactory:Landroidx/media3/datasource/DataSink$Factory;

.field private eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

.field private flags:I

.field private upstreamDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

.field private upstreamPriority:I

.field private upstreamPriorityTaskManager:Landroidx/media3/common/PriorityTaskManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 80
    new-instance v0, Landroidx/media3/datasource/FileDataSource$Factory;

    invoke-direct {v0}, Landroidx/media3/datasource/FileDataSource$Factory;-><init>()V

    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheReadDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 81
    sget-object v0, Landroidx/media3/datasource/cache/CacheKeyFactory;->DEFAULT:Landroidx/media3/datasource/cache/CacheKeyFactory;

    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 82
    return-void
.end method

.method private createDataSourceInternal(Landroidx/media3/datasource/DataSource;II)Landroidx/media3/datasource/cache/CacheDataSource;
    .locals 15
    .param p1, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p2, "flags"    # I
    .param p3, "upstreamPriority"    # I

    .line 301
    move-object v0, p0

    iget-object v1, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/datasource/cache/Cache;

    .line 303
    .local v1, "cache":Landroidx/media3/datasource/cache/Cache;
    iget-boolean v2, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheIsReadOnly:Z

    if-nez v2, :cond_2

    if-nez p1, :cond_0

    goto :goto_0

    .line 305
    :cond_0
    iget-object v2, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheWriteDataSinkFactory:Landroidx/media3/datasource/DataSink$Factory;

    if-eqz v2, :cond_1

    .line 306
    invoke-interface {v2}, Landroidx/media3/datasource/DataSink$Factory;->createDataSink()Landroidx/media3/datasource/DataSink;

    move-result-object v2

    move-object v13, v2

    .local v2, "cacheWriteDataSink":Landroidx/media3/datasource/DataSink;
    goto :goto_1

    .line 308
    .end local v2    # "cacheWriteDataSink":Landroidx/media3/datasource/DataSink;
    :cond_1
    new-instance v2, Landroidx/media3/datasource/cache/CacheDataSink$Factory;

    invoke-direct {v2}, Landroidx/media3/datasource/cache/CacheDataSink$Factory;-><init>()V

    invoke-virtual {v2, v1}, Landroidx/media3/datasource/cache/CacheDataSink$Factory;->setCache(Landroidx/media3/datasource/cache/Cache;)Landroidx/media3/datasource/cache/CacheDataSink$Factory;

    move-result-object v2

    invoke-virtual {v2}, Landroidx/media3/datasource/cache/CacheDataSink$Factory;->createDataSink()Landroidx/media3/datasource/DataSink;

    move-result-object v2

    move-object v13, v2

    .restart local v2    # "cacheWriteDataSink":Landroidx/media3/datasource/DataSink;
    goto :goto_1

    .line 304
    .end local v2    # "cacheWriteDataSink":Landroidx/media3/datasource/DataSink;
    :cond_2
    :goto_0
    const/4 v2, 0x0

    move-object v13, v2

    .line 310
    .local v13, "cacheWriteDataSink":Landroidx/media3/datasource/DataSink;
    :goto_1
    new-instance v14, Landroidx/media3/datasource/cache/CacheDataSource;

    iget-object v2, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheReadDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 313
    invoke-interface {v2}, Landroidx/media3/datasource/DataSource$Factory;->createDataSource()Landroidx/media3/datasource/DataSource;

    move-result-object v5

    iget-object v7, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    iget-object v9, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamPriorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    iget-object v11, v0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    const/4 v12, 0x0

    move-object v2, v14

    move-object v3, v1

    move-object/from16 v4, p1

    move-object v6, v13

    move/from16 v8, p2

    move/from16 v10, p3

    invoke-direct/range {v2 .. v12}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;Landroidx/media3/datasource/cache/CacheKeyFactory;ILandroidx/media3/common/PriorityTaskManager;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;Landroidx/media3/datasource/cache/CacheDataSource$1;)V

    .line 310
    return-object v14
.end method


# virtual methods
.method public bridge synthetic createDataSource()Landroidx/media3/datasource/DataSource;
    .locals 1

    .line 66
    invoke-virtual {p0}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSource()Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    return-object v0
.end method

.method public createDataSource()Landroidx/media3/datasource/cache/CacheDataSource;
    .locals 3

    .line 256
    nop

    .line 257
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/datasource/DataSource$Factory;->createDataSource()Landroidx/media3/datasource/DataSource;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iget v1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->flags:I

    iget v2, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamPriority:I

    .line 256
    invoke-direct {p0, v0, v1, v2}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceInternal(Landroidx/media3/datasource/DataSource;II)Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    return-object v0
.end method

.method public createDataSourceForDownloading()Landroidx/media3/datasource/cache/CacheDataSource;
    .locals 3

    .line 274
    nop

    .line 275
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/datasource/DataSource$Factory;->createDataSource()Landroidx/media3/datasource/DataSource;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iget v1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->flags:I

    or-int/lit8 v1, v1, 0x1

    .line 274
    const/16 v2, -0x3e8

    invoke-direct {p0, v0, v1, v2}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceInternal(Landroidx/media3/datasource/DataSource;II)Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    return-object v0
.end method

.method public createDataSourceForRemovingDownload()Landroidx/media3/datasource/cache/CacheDataSource;
    .locals 3

    .line 295
    iget v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->flags:I

    or-int/lit8 v0, v0, 0x1

    const/16 v1, -0x3e8

    const/4 v2, 0x0

    invoke-direct {p0, v2, v0, v1}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->createDataSourceInternal(Landroidx/media3/datasource/DataSource;II)Landroidx/media3/datasource/cache/CacheDataSource;

    move-result-object v0

    return-object v0
.end method

.method public getCache()Landroidx/media3/datasource/cache/Cache;
    .locals 1

    .line 104
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cache:Landroidx/media3/datasource/cache/Cache;

    return-object v0
.end method

.method public getCacheKeyFactory()Landroidx/media3/datasource/cache/CacheKeyFactory;
    .locals 1

    .line 156
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    return-object v0
.end method

.method public getUpstreamPriorityTaskManager()Landroidx/media3/common/PriorityTaskManager;
    .locals 1

    .line 208
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamPriorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    return-object v0
.end method

.method public setCache(Landroidx/media3/datasource/cache/Cache;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;

    .line 94
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cache:Landroidx/media3/datasource/cache/Cache;

    .line 95
    return-object p0
.end method

.method public setCacheKeyFactory(Landroidx/media3/datasource/cache/CacheKeyFactory;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "cacheKeyFactory"    # Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 150
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 151
    return-object p0
.end method

.method public setCacheReadDataSourceFactory(Landroidx/media3/datasource/DataSource$Factory;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "cacheReadDataSourceFactory"    # Landroidx/media3/datasource/DataSource$Factory;

    .line 118
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheReadDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 119
    return-object p0
.end method

.method public setCacheWriteDataSinkFactory(Landroidx/media3/datasource/DataSink$Factory;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 1
    .param p1, "cacheWriteDataSinkFactory"    # Landroidx/media3/datasource/DataSink$Factory;

    .line 135
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheWriteDataSinkFactory:Landroidx/media3/datasource/DataSink$Factory;

    .line 136
    if-nez p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->cacheIsReadOnly:Z

    .line 137
    return-object p0
.end method

.method public setEventListener(Landroidx/media3/datasource/cache/CacheDataSource$EventListener;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "eventListener"    # Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    .line 250
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    .line 251
    return-object p0
.end method

.method public setFlags(I)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "flags"    # I

    .line 236
    iput p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->flags:I

    .line 237
    return-object p0
.end method

.method public setUpstreamDataSourceFactory(Landroidx/media3/datasource/DataSource$Factory;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "upstreamDataSourceFactory"    # Landroidx/media3/datasource/DataSource$Factory;

    .line 173
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamDataSourceFactory:Landroidx/media3/datasource/DataSource$Factory;

    .line 174
    return-object p0
.end method

.method public setUpstreamPriority(I)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "upstreamPriority"    # I

    .line 222
    iput p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamPriority:I

    .line 223
    return-object p0
.end method

.method public setUpstreamPriorityTaskManager(Landroidx/media3/common/PriorityTaskManager;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    .locals 0
    .param p1, "upstreamPriorityTaskManager"    # Landroidx/media3/common/PriorityTaskManager;

    .line 198
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->upstreamPriorityTaskManager:Landroidx/media3/common/PriorityTaskManager;

    .line 199
    return-object p0
.end method
