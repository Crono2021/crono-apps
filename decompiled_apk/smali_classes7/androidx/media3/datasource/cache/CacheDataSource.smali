.class public final Landroidx/media3/datasource/cache/CacheDataSource;
.super Ljava/lang/Object;
.source "CacheDataSource.java"

# interfaces
.implements Landroidx/media3/datasource/DataSource;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/datasource/cache/CacheDataSource$EventListener;,
        Landroidx/media3/datasource/cache/CacheDataSource$CacheIgnoredReason;,
        Landroidx/media3/datasource/cache/CacheDataSource$Flags;,
        Landroidx/media3/datasource/cache/CacheDataSource$Factory;
    }
.end annotation


# static fields
.field public static final CACHE_IGNORED_REASON_ERROR:I = 0x0

.field public static final CACHE_IGNORED_REASON_UNSET_LENGTH:I = 0x1

.field private static final CACHE_NOT_IGNORED:I = -0x1

.field public static final FLAG_BLOCK_ON_CACHE:I = 0x1

.field public static final FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS:I = 0x4

.field public static final FLAG_IGNORE_CACHE_ON_ERROR:I = 0x2

.field private static final MIN_READ_BEFORE_CHECKING_CACHE:J = 0x19000L


# instance fields
.field private actualUri:Landroid/net/Uri;

.field private final blockOnCache:Z

.field private bytesRemaining:J

.field private final cache:Landroidx/media3/datasource/cache/Cache;

.field private final cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

.field private final cacheReadDataSource:Landroidx/media3/datasource/DataSource;

.field private final cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

.field private checkCachePosition:J

.field private currentDataSource:Landroidx/media3/datasource/DataSource;

.field private currentDataSourceBytesRead:J

.field private currentDataSpec:Landroidx/media3/datasource/DataSpec;

.field private currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

.field private currentRequestIgnoresCache:Z

.field private final eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

.field private final ignoreCacheForUnsetLengthRequests:Z

.field private final ignoreCacheOnError:Z

.field private readPosition:J

.field private requestDataSpec:Landroidx/media3/datasource/DataSpec;

.field private seenCacheError:Z

.field private totalCachedBytesRead:J

.field private final upstreamDataSource:Landroidx/media3/datasource/DataSource;


# direct methods
.method public constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;)V
    .locals 1
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;

    .line 435
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;I)V

    .line 436
    return-void
.end method

.method public constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;I)V
    .locals 7
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p3, "flags"    # I

    .line 449
    new-instance v3, Landroidx/media3/datasource/FileDataSource;

    invoke-direct {v3}, Landroidx/media3/datasource/FileDataSource;-><init>()V

    new-instance v4, Landroidx/media3/datasource/cache/CacheDataSink;

    const-wide/32 v0, 0x500000

    invoke-direct {v4, p1, v0, v1}, Landroidx/media3/datasource/cache/CacheDataSink;-><init>(Landroidx/media3/datasource/cache/Cache;J)V

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v5, p3

    invoke-direct/range {v0 .. v6}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;)V

    .line 456
    return-void
.end method

.method public constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;)V
    .locals 8
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p3, "cacheReadDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p4, "cacheWriteDataSink"    # Landroidx/media3/datasource/DataSink;
    .param p5, "flags"    # I
    .param p6, "eventListener"    # Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    .line 480
    const/4 v7, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v7}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;Landroidx/media3/datasource/cache/CacheKeyFactory;)V

    .line 488
    return-void
.end method

.method public constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;Landroidx/media3/datasource/cache/CacheKeyFactory;)V
    .locals 10
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p3, "cacheReadDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p4, "cacheWriteDataSink"    # Landroidx/media3/datasource/DataSink;
    .param p5, "flags"    # I
    .param p6, "eventListener"    # Landroidx/media3/datasource/cache/CacheDataSource$EventListener;
    .param p7, "cacheKeyFactory"    # Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 514
    const/4 v7, 0x0

    const/4 v8, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object/from16 v5, p7

    move v6, p5

    move-object/from16 v9, p6

    invoke-direct/range {v0 .. v9}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;Landroidx/media3/datasource/cache/CacheKeyFactory;ILandroidx/media3/common/PriorityTaskManager;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;)V

    .line 524
    return-void
.end method

.method private constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;Landroidx/media3/datasource/cache/CacheKeyFactory;ILandroidx/media3/common/PriorityTaskManager;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;)V
    .locals 3
    .param p1, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "upstreamDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p3, "cacheReadDataSource"    # Landroidx/media3/datasource/DataSource;
    .param p4, "cacheWriteDataSink"    # Landroidx/media3/datasource/DataSink;
    .param p5, "cacheKeyFactory"    # Landroidx/media3/datasource/cache/CacheKeyFactory;
    .param p6, "flags"    # I
    .param p7, "upstreamPriorityTaskManager"    # Landroidx/media3/common/PriorityTaskManager;
    .param p8, "upstreamPriority"    # I
    .param p9, "eventListener"    # Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    .line 535
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 536
    iput-object p1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    .line 537
    iput-object p3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheReadDataSource:Landroidx/media3/datasource/DataSource;

    .line 538
    if-eqz p5, :cond_0

    move-object v0, p5

    goto :goto_0

    :cond_0
    sget-object v0, Landroidx/media3/datasource/cache/CacheKeyFactory;->DEFAULT:Landroidx/media3/datasource/cache/CacheKeyFactory;

    :goto_0
    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    .line 539
    and-int/lit8 v0, p6, 0x1

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-eqz v0, :cond_1

    move v0, v2

    goto :goto_1

    :cond_1
    move v0, v1

    :goto_1
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->blockOnCache:Z

    .line 540
    and-int/lit8 v0, p6, 0x2

    if-eqz v0, :cond_2

    move v0, v2

    goto :goto_2

    :cond_2
    move v0, v1

    :goto_2
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->ignoreCacheOnError:Z

    .line 541
    and-int/lit8 v0, p6, 0x4

    if-eqz v0, :cond_3

    move v1, v2

    :cond_3
    iput-boolean v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->ignoreCacheForUnsetLengthRequests:Z

    .line 543
    const/4 v0, 0x0

    if-eqz p2, :cond_6

    .line 544
    if-eqz p7, :cond_4

    .line 545
    new-instance v1, Landroidx/media3/datasource/PriorityDataSource;

    invoke-direct {v1, p2, p7, p8}, Landroidx/media3/datasource/PriorityDataSource;-><init>(Landroidx/media3/datasource/DataSource;Landroidx/media3/common/PriorityTaskManager;I)V

    move-object p2, v1

    .line 549
    :cond_4
    iput-object p2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    .line 550
    nop

    .line 551
    if-eqz p4, :cond_5

    .line 552
    new-instance v0, Landroidx/media3/datasource/TeeDataSource;

    invoke-direct {v0, p2, p4}, Landroidx/media3/datasource/TeeDataSource;-><init>(Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;)V

    goto :goto_3

    .line 553
    :cond_5
    nop

    :goto_3
    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

    goto :goto_4

    .line 555
    :cond_6
    sget-object v1, Landroidx/media3/datasource/PlaceholderDataSource;->INSTANCE:Landroidx/media3/datasource/PlaceholderDataSource;

    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    .line 556
    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

    .line 558
    :goto_4
    iput-object p9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    .line 559
    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;Landroidx/media3/datasource/cache/CacheKeyFactory;ILandroidx/media3/common/PriorityTaskManager;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;Landroidx/media3/datasource/cache/CacheDataSource$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/datasource/cache/Cache;
    .param p2, "x1"    # Landroidx/media3/datasource/DataSource;
    .param p3, "x2"    # Landroidx/media3/datasource/DataSource;
    .param p4, "x3"    # Landroidx/media3/datasource/DataSink;
    .param p5, "x4"    # Landroidx/media3/datasource/cache/CacheKeyFactory;
    .param p6, "x5"    # I
    .param p7, "x6"    # Landroidx/media3/common/PriorityTaskManager;
    .param p8, "x7"    # I
    .param p9, "x8"    # Landroidx/media3/datasource/cache/CacheDataSource$EventListener;
    .param p10, "x9"    # Landroidx/media3/datasource/cache/CacheDataSource$1;

    .line 63
    invoke-direct/range {p0 .. p9}, Landroidx/media3/datasource/cache/CacheDataSource;-><init>(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSource;Landroidx/media3/datasource/DataSink;Landroidx/media3/datasource/cache/CacheKeyFactory;ILandroidx/media3/common/PriorityTaskManager;ILandroidx/media3/datasource/cache/CacheDataSource$EventListener;)V

    return-void
.end method

.method private closeCurrentSource()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 848
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    if-nez v0, :cond_0

    .line 849
    return-void

    .line 852
    :cond_0
    const/4 v1, 0x0

    :try_start_0
    invoke-interface {v0}, Landroidx/media3/datasource/DataSource;->close()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 854
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 855
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    .line 856
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

    if-eqz v0, :cond_1

    .line 857
    iget-object v2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v2, v0}, Landroidx/media3/datasource/cache/Cache;->releaseHoleSpan(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 858
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

    .line 861
    :cond_1
    return-void

    .line 854
    :catchall_0
    move-exception v0

    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 855
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    .line 856
    iget-object v2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

    if-eqz v2, :cond_2

    .line 857
    iget-object v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v3, v2}, Landroidx/media3/datasource/cache/Cache;->releaseHoleSpan(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 858
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

    .line 860
    :cond_2
    throw v0
.end method

.method private static getRedirectedUriOrDefault(Landroidx/media3/datasource/cache/Cache;Ljava/lang/String;Landroid/net/Uri;)Landroid/net/Uri;
    .locals 2
    .param p0, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultUri"    # Landroid/net/Uri;

    .line 827
    invoke-interface {p0, p1}, Landroidx/media3/datasource/cache/Cache;->getContentMetadata(Ljava/lang/String;)Landroidx/media3/datasource/cache/ContentMetadata;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/datasource/cache/ContentMetadata;->getRedirectedUri(Landroidx/media3/datasource/cache/ContentMetadata;)Landroid/net/Uri;

    move-result-object v0

    .line 828
    .local v0, "redirectedUri":Landroid/net/Uri;
    if-eqz v0, :cond_0

    move-object v1, v0

    goto :goto_0

    :cond_0
    move-object v1, p2

    :goto_0
    return-object v1
.end method

.method private handleBeforeThrow(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "exception"    # Ljava/lang/Throwable;

    .line 864
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromCache()Z

    move-result v0

    if-nez v0, :cond_0

    instance-of v0, p1, Landroidx/media3/datasource/cache/Cache$CacheException;

    if-eqz v0, :cond_1

    .line 865
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->seenCacheError:Z

    .line 867
    :cond_1
    return-void
.end method

.method private isBypassingCache()Z
    .locals 2

    .line 836
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    iget-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private isReadingFromCache()Z
    .locals 2

    .line 840
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    iget-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheReadDataSource:Landroidx/media3/datasource/DataSource;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private isReadingFromUpstream()Z
    .locals 1

    .line 832
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromCache()Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private isWritingToCache()Z
    .locals 2

    .line 844
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    iget-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private notifyBytesRead()V
    .locals 7

    .line 886
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    if-eqz v0, :cond_0

    iget-wide v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->totalCachedBytesRead:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 887
    iget-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v1}, Landroidx/media3/datasource/cache/Cache;->getCacheSpace()J

    move-result-wide v1

    iget-wide v5, p0, Landroidx/media3/datasource/cache/CacheDataSource;->totalCachedBytesRead:J

    invoke-interface {v0, v1, v2, v5, v6}, Landroidx/media3/datasource/cache/CacheDataSource$EventListener;->onCachedBytesRead(JJ)V

    .line 888
    iput-wide v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->totalCachedBytesRead:J

    .line 890
    :cond_0
    return-void
.end method

.method private notifyCacheIgnored(I)V
    .locals 1
    .param p1, "reason"    # I

    .line 880
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->eventListener:Landroidx/media3/datasource/cache/CacheDataSource$EventListener;

    if-eqz v0, :cond_0

    .line 881
    invoke-interface {v0, p1}, Landroidx/media3/datasource/cache/CacheDataSource$EventListener;->onCacheIgnored(I)V

    .line 883
    :cond_0
    return-void
.end method

.method private openNextSource(Landroidx/media3/datasource/DataSpec;Z)V
    .locals 16
    .param p1, "requestDataSpec"    # Landroidx/media3/datasource/DataSpec;
    .param p2, "checkCache"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 709
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    iget-object v0, v2, Landroidx/media3/datasource/DataSpec;->key:Ljava/lang/String;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    move-object v9, v0

    check-cast v9, Ljava/lang/String;

    .line 710
    .local v9, "key":Ljava/lang/String;
    iget-boolean v0, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentRequestIgnoresCache:Z

    if-eqz v0, :cond_0

    .line 711
    const/4 v0, 0x0

    .local v0, "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    goto :goto_0

    .line 712
    .end local v0    # "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    :cond_0
    iget-boolean v0, v1, Landroidx/media3/datasource/cache/CacheDataSource;->blockOnCache:Z

    if-eqz v0, :cond_1

    .line 714
    :try_start_0
    iget-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-wide v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    iget-wide v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    move-object v4, v9

    invoke-interface/range {v3 .. v8}, Landroidx/media3/datasource/cache/Cache;->startReadWrite(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/CacheSpan;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 718
    .restart local v0    # "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    goto :goto_0

    .line 715
    .end local v0    # "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    :catch_0
    move-exception v0

    .line 716
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->interrupt()V

    .line 717
    new-instance v3, Ljava/io/InterruptedIOException;

    invoke-direct {v3}, Ljava/io/InterruptedIOException;-><init>()V

    throw v3

    .line 720
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :cond_1
    iget-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-wide v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    iget-wide v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    move-object v4, v9

    invoke-interface/range {v3 .. v8}, Landroidx/media3/datasource/cache/Cache;->startReadWriteNonBlocking(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/CacheSpan;

    move-result-object v0

    .line 725
    .local v0, "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    :goto_0
    const-wide/16 v3, -0x1

    if-nez v0, :cond_2

    .line 728
    iget-object v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    .line 729
    .local v5, "nextDataSource":Landroidx/media3/datasource/DataSource;
    nop

    .line 730
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v6

    iget-wide v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    invoke-virtual {v6, v7, v8}, Landroidx/media3/datasource/DataSpec$Builder;->setPosition(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v6

    iget-wide v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    invoke-virtual {v6, v7, v8}, Landroidx/media3/datasource/DataSpec$Builder;->setLength(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v6

    move-object v8, v5

    move-object v5, v0

    .local v6, "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    goto/16 :goto_2

    .line 731
    .end local v5    # "nextDataSource":Landroidx/media3/datasource/DataSource;
    .end local v6    # "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_2
    iget-boolean v5, v0, Landroidx/media3/datasource/cache/CacheSpan;->isCached:Z

    if-eqz v5, :cond_4

    .line 733
    iget-object v5, v0, Landroidx/media3/datasource/cache/CacheSpan;->file:Ljava/io/File;

    invoke-static {v5}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/io/File;

    invoke-static {v5}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v5

    .line 734
    .local v5, "fileUri":Landroid/net/Uri;
    iget-wide v6, v0, Landroidx/media3/datasource/cache/CacheSpan;->position:J

    .line 735
    .local v6, "filePositionOffset":J
    iget-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    sub-long/2addr v10, v6

    .line 736
    .local v10, "positionInFile":J
    iget-wide v12, v0, Landroidx/media3/datasource/cache/CacheSpan;->length:J

    sub-long/2addr v12, v10

    .line 737
    .local v12, "length":J
    iget-wide v14, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v8, v14, v3

    if-eqz v8, :cond_3

    .line 738
    invoke-static {v12, v13, v14, v15}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v12

    .line 740
    :cond_3
    nop

    .line 742
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v8

    .line 743
    invoke-virtual {v8, v5}, Landroidx/media3/datasource/DataSpec$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v8

    .line 744
    invoke-virtual {v8, v6, v7}, Landroidx/media3/datasource/DataSpec$Builder;->setUriPositionOffset(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v8

    .line 745
    invoke-virtual {v8, v10, v11}, Landroidx/media3/datasource/DataSpec$Builder;->setPosition(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v8

    .line 746
    invoke-virtual {v8, v12, v13}, Landroidx/media3/datasource/DataSpec$Builder;->setLength(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v8

    .line 747
    invoke-virtual {v8}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v8

    .line 748
    .local v8, "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    iget-object v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cacheReadDataSource:Landroidx/media3/datasource/DataSource;

    .line 749
    .end local v6    # "filePositionOffset":J
    .end local v10    # "positionInFile":J
    .end local v12    # "length":J
    .local v5, "nextDataSource":Landroidx/media3/datasource/DataSource;
    move-object v6, v8

    move-object v8, v5

    move-object v5, v0

    goto :goto_2

    .line 752
    .end local v5    # "nextDataSource":Landroidx/media3/datasource/DataSource;
    .end local v8    # "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_4
    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CacheSpan;->isOpenEnded()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 753
    iget-wide v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .local v5, "length":J
    goto :goto_1

    .line 755
    .end local v5    # "length":J
    :cond_5
    iget-wide v5, v0, Landroidx/media3/datasource/cache/CacheSpan;->length:J

    .line 756
    .restart local v5    # "length":J
    iget-wide v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v10, v7, v3

    if-eqz v10, :cond_6

    .line 757
    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v5

    .line 760
    :cond_6
    :goto_1
    nop

    .line 761
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v7

    iget-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    invoke-virtual {v7, v10, v11}, Landroidx/media3/datasource/DataSpec$Builder;->setPosition(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v7

    invoke-virtual {v7, v5, v6}, Landroidx/media3/datasource/DataSpec$Builder;->setLength(J)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v7

    invoke-virtual {v7}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v7

    .line 762
    .local v7, "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    iget-object v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

    if-eqz v8, :cond_7

    .line 763
    iget-object v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cacheWriteDataSource:Landroidx/media3/datasource/DataSource;

    move-object v5, v0

    move-object v6, v7

    .local v8, "nextDataSource":Landroidx/media3/datasource/DataSource;
    goto :goto_2

    .line 765
    .end local v8    # "nextDataSource":Landroidx/media3/datasource/DataSource;
    :cond_7
    iget-object v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    .line 766
    .restart local v8    # "nextDataSource":Landroidx/media3/datasource/DataSource;
    iget-object v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v10, v0}, Landroidx/media3/datasource/cache/Cache;->releaseHoleSpan(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 767
    const/4 v0, 0x0

    move-object v5, v0

    move-object v6, v7

    .line 771
    .end local v0    # "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    .end local v7    # "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    .local v5, "nextSpan":Landroidx/media3/datasource/cache/CacheSpan;
    .local v6, "nextDataSpec":Landroidx/media3/datasource/DataSpec;
    :goto_2
    nop

    .line 772
    iget-boolean v0, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentRequestIgnoresCache:Z

    if-nez v0, :cond_8

    iget-object v0, v1, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    if-ne v8, v0, :cond_8

    .line 773
    iget-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    const-wide/32 v12, 0x19000

    add-long/2addr v10, v12

    goto :goto_3

    .line 774
    :cond_8
    const-wide v10, 0x7fffffffffffffffL

    :goto_3
    iput-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->checkCachePosition:J

    .line 775
    if-eqz p2, :cond_b

    .line 776
    invoke-direct/range {p0 .. p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isBypassingCache()Z

    move-result v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 777
    iget-object v0, v1, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    if-ne v8, v0, :cond_9

    .line 779
    return-void

    .line 783
    :cond_9
    :try_start_1
    invoke-direct/range {p0 .. p0}, Landroidx/media3/datasource/cache/CacheDataSource;->closeCurrentSource()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 790
    goto :goto_4

    .line 784
    :catchall_0
    move-exception v0

    move-object v3, v0

    move-object v0, v3

    .line 785
    .local v0, "e":Ljava/lang/Throwable;
    invoke-static {v5}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/datasource/cache/CacheSpan;

    invoke-virtual {v3}, Landroidx/media3/datasource/cache/CacheSpan;->isHoleSpan()Z

    move-result v3

    if-eqz v3, :cond_a

    .line 787
    iget-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v3, v5}, Landroidx/media3/datasource/cache/Cache;->releaseHoleSpan(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 789
    :cond_a
    throw v0

    .line 793
    .end local v0    # "e":Ljava/lang/Throwable;
    :cond_b
    :goto_4
    if-eqz v5, :cond_c

    invoke-virtual {v5}, Landroidx/media3/datasource/cache/CacheSpan;->isHoleSpan()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 794
    iput-object v5, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentHoleSpan:Landroidx/media3/datasource/cache/CacheSpan;

    .line 796
    :cond_c
    iput-object v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    .line 797
    iput-object v6, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 798
    const-wide/16 v10, 0x0

    iput-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSourceBytesRead:J

    .line 799
    invoke-interface {v8, v6}, Landroidx/media3/datasource/DataSource;->open(Landroidx/media3/datasource/DataSpec;)J

    move-result-wide v10

    .line 802
    .local v10, "resolvedLength":J
    new-instance v0, Landroidx/media3/datasource/cache/ContentMetadataMutations;

    invoke-direct {v0}, Landroidx/media3/datasource/cache/ContentMetadataMutations;-><init>()V

    .line 803
    .local v0, "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    iget-wide v12, v6, Landroidx/media3/datasource/DataSpec;->length:J

    cmp-long v7, v12, v3

    if-nez v7, :cond_d

    cmp-long v3, v10, v3

    if-eqz v3, :cond_d

    .line 804
    iput-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .line 805
    iget-wide v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    add-long/2addr v3, v10

    invoke-static {v0, v3, v4}, Landroidx/media3/datasource/cache/ContentMetadataMutations;->setContentLength(Landroidx/media3/datasource/cache/ContentMetadataMutations;J)Landroidx/media3/datasource/cache/ContentMetadataMutations;

    .line 807
    :cond_d
    invoke-direct/range {p0 .. p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromUpstream()Z

    move-result v3

    if-eqz v3, :cond_f

    .line 808
    invoke-interface {v8}, Landroidx/media3/datasource/DataSource;->getUri()Landroid/net/Uri;

    move-result-object v3

    iput-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    .line 809
    iget-object v3, v2, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    iget-object v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    xor-int/lit8 v3, v3, 0x1

    .line 810
    .local v3, "isRedirected":Z
    if-eqz v3, :cond_e

    iget-object v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    goto :goto_5

    :cond_e
    const/4 v4, 0x0

    :goto_5
    invoke-static {v0, v4}, Landroidx/media3/datasource/cache/ContentMetadataMutations;->setRedirectedUri(Landroidx/media3/datasource/cache/ContentMetadataMutations;Landroid/net/Uri;)Landroidx/media3/datasource/cache/ContentMetadataMutations;

    .line 812
    .end local v3    # "isRedirected":Z
    :cond_f
    invoke-direct/range {p0 .. p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isWritingToCache()Z

    move-result v3

    if-eqz v3, :cond_10

    .line 813
    iget-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v3, v9, v0}, Landroidx/media3/datasource/cache/Cache;->applyContentMetadataMutations(Ljava/lang/String;Landroidx/media3/datasource/cache/ContentMetadataMutations;)V

    .line 815
    :cond_10
    return-void
.end method

.method private setNoBytesRemainingAndMaybeStoreLength(Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 818
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .line 819
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isWritingToCache()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 820
    new-instance v0, Landroidx/media3/datasource/cache/ContentMetadataMutations;

    invoke-direct {v0}, Landroidx/media3/datasource/cache/ContentMetadataMutations;-><init>()V

    .line 821
    .local v0, "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    iget-wide v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    invoke-static {v0, v1, v2}, Landroidx/media3/datasource/cache/ContentMetadataMutations;->setContentLength(Landroidx/media3/datasource/cache/ContentMetadataMutations;J)Landroidx/media3/datasource/cache/ContentMetadataMutations;

    .line 822
    iget-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v1, p1, v0}, Landroidx/media3/datasource/cache/Cache;->applyContentMetadataMutations(Ljava/lang/String;Landroidx/media3/datasource/cache/ContentMetadataMutations;)V

    .line 824
    .end local v0    # "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    :cond_0
    return-void
.end method

.method private shouldIgnoreCacheForRequest(Landroidx/media3/datasource/DataSpec;)I
    .locals 4
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;

    .line 870
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->ignoreCacheOnError:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->seenCacheError:Z

    if-eqz v0, :cond_0

    .line 871
    const/4 v0, 0x0

    return v0

    .line 872
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->ignoreCacheForUnsetLengthRequests:Z

    if-eqz v0, :cond_1

    iget-wide v0, p1, Landroidx/media3/datasource/DataSpec;->length:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_1

    .line 873
    const/4 v0, 0x1

    return v0

    .line 875
    :cond_1
    const/4 v0, -0x1

    return v0
.end method


# virtual methods
.method public addTransferListener(Landroidx/media3/datasource/TransferListener;)V
    .locals 1
    .param p1, "transferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 573
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 574
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheReadDataSource:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0, p1}, Landroidx/media3/datasource/DataSource;->addTransferListener(Landroidx/media3/datasource/TransferListener;)V

    .line 575
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0, p1}, Landroidx/media3/datasource/DataSource;->addTransferListener(Landroidx/media3/datasource/TransferListener;)V

    .line 576
    return-void
.end method

.method public close()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 680
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->requestDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 681
    iput-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    .line 682
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    .line 683
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->notifyBytesRead()V

    .line 685
    :try_start_0
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->closeCurrentSource()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 689
    nop

    .line 690
    return-void

    .line 686
    :catchall_0
    move-exception v0

    .line 687
    .local v0, "e":Ljava/lang/Throwable;
    invoke-direct {p0, v0}, Landroidx/media3/datasource/cache/CacheDataSource;->handleBeforeThrow(Ljava/lang/Throwable;)V

    .line 688
    throw v0
.end method

.method public getCache()Landroidx/media3/datasource/cache/Cache;
    .locals 1

    .line 563
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    return-object v0
.end method

.method public getCacheKeyFactory()Landroidx/media3/datasource/cache/CacheKeyFactory;
    .locals 1

    .line 568
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    return-object v0
.end method

.method public getResponseHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .line 673
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromUpstream()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 674
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->upstreamDataSource:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0}, Landroidx/media3/datasource/DataSource;->getResponseHeaders()Ljava/util/Map;

    move-result-object v0

    goto :goto_0

    .line 675
    :cond_0
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    .line 673
    :goto_0
    return-object v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .line 667
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    return-object v0
.end method

.method public open(Landroidx/media3/datasource/DataSpec;)J
    .locals 13
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 581
    :try_start_0
    iget-object v0, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cacheKeyFactory:Landroidx/media3/datasource/cache/CacheKeyFactory;

    invoke-interface {v0, p1}, Landroidx/media3/datasource/cache/CacheKeyFactory;->buildCacheKey(Landroidx/media3/datasource/DataSpec;)Ljava/lang/String;

    move-result-object v0

    .line 582
    .local v0, "key":Ljava/lang/String;
    invoke-virtual {p1}, Landroidx/media3/datasource/DataSpec;->buildUpon()Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroidx/media3/datasource/DataSpec$Builder;->setKey(Ljava/lang/String;)Landroidx/media3/datasource/DataSpec$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/media3/datasource/DataSpec$Builder;->build()Landroidx/media3/datasource/DataSpec;

    move-result-object v1

    .line 583
    .local v1, "requestDataSpec":Landroidx/media3/datasource/DataSpec;
    iput-object v1, p0, Landroidx/media3/datasource/cache/CacheDataSource;->requestDataSpec:Landroidx/media3/datasource/DataSpec;

    .line 584
    iget-object v2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    iget-object v3, v1, Landroidx/media3/datasource/DataSpec;->uri:Landroid/net/Uri;

    invoke-static {v2, v0, v3}, Landroidx/media3/datasource/cache/CacheDataSource;->getRedirectedUriOrDefault(Landroidx/media3/datasource/cache/Cache;Ljava/lang/String;Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->actualUri:Landroid/net/Uri;

    .line 585
    iget-wide v2, p1, Landroidx/media3/datasource/DataSpec;->position:J

    iput-wide v2, p0, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    .line 587
    invoke-direct {p0, p1}, Landroidx/media3/datasource/cache/CacheDataSource;->shouldIgnoreCacheForRequest(Landroidx/media3/datasource/DataSpec;)I

    move-result v2

    .line 588
    .local v2, "reason":I
    const/4 v3, -0x1

    const/4 v4, 0x0

    if-eq v2, v3, :cond_0

    const/4 v3, 0x1

    goto :goto_0

    :cond_0
    move v3, v4

    :goto_0
    iput-boolean v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentRequestIgnoresCache:Z

    .line 589
    if-eqz v3, :cond_1

    .line 590
    invoke-direct {p0, v2}, Landroidx/media3/datasource/cache/CacheDataSource;->notifyCacheIgnored(I)V

    .line 593
    :cond_1
    iget-boolean v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->currentRequestIgnoresCache:Z

    const-wide/16 v5, 0x0

    const-wide/16 v7, -0x1

    if-eqz v3, :cond_2

    .line 594
    iput-wide v7, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    goto :goto_1

    .line 596
    :cond_2
    iget-object v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->cache:Landroidx/media3/datasource/cache/Cache;

    invoke-interface {v3, v0}, Landroidx/media3/datasource/cache/Cache;->getContentMetadata(Ljava/lang/String;)Landroidx/media3/datasource/cache/ContentMetadata;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/datasource/cache/ContentMetadata;->getContentLength(Landroidx/media3/datasource/cache/ContentMetadata;)J

    move-result-wide v9

    iput-wide v9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .line 597
    cmp-long v3, v9, v7

    if-eqz v3, :cond_4

    .line 598
    iget-wide v11, p1, Landroidx/media3/datasource/DataSpec;->position:J

    sub-long/2addr v9, v11

    iput-wide v9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .line 599
    cmp-long v3, v9, v5

    if-ltz v3, :cond_3

    goto :goto_1

    .line 600
    :cond_3
    new-instance v3, Landroidx/media3/datasource/DataSourceException;

    const/16 v4, 0x7d8

    invoke-direct {v3, v4}, Landroidx/media3/datasource/DataSourceException;-><init>(I)V

    .end local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    throw v3

    .line 605
    .restart local p1    # "dataSpec":Landroidx/media3/datasource/DataSpec;
    :cond_4
    :goto_1
    iget-wide v9, p1, Landroidx/media3/datasource/DataSpec;->length:J

    cmp-long v3, v9, v7

    if-eqz v3, :cond_6

    .line 606
    nop

    .line 607
    iget-wide v9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v3, v9, v7

    if-nez v3, :cond_5

    .line 608
    iget-wide v9, p1, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_2

    .line 609
    :cond_5
    iget-wide v11, p1, Landroidx/media3/datasource/DataSpec;->length:J

    invoke-static {v9, v10, v11, v12}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v9

    :goto_2
    iput-wide v9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    .line 611
    :cond_6
    iget-wide v9, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v3, v9, v5

    if-gtz v3, :cond_7

    cmp-long v3, v9, v7

    if-nez v3, :cond_8

    .line 612
    :cond_7
    invoke-direct {p0, v1, v4}, Landroidx/media3/datasource/cache/CacheDataSource;->openNextSource(Landroidx/media3/datasource/DataSpec;Z)V

    .line 614
    :cond_8
    iget-wide v3, p1, Landroidx/media3/datasource/DataSpec;->length:J

    cmp-long v3, v3, v7

    if-eqz v3, :cond_9

    iget-wide v3, p1, Landroidx/media3/datasource/DataSpec;->length:J

    goto :goto_3

    :cond_9
    iget-wide v3, p0, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_3
    return-wide v3

    .line 615
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "requestDataSpec":Landroidx/media3/datasource/DataSpec;
    .end local v2    # "reason":I
    :catchall_0
    move-exception v0

    .line 616
    .local v0, "e":Ljava/lang/Throwable;
    invoke-direct {p0, v0}, Landroidx/media3/datasource/cache/CacheDataSource;->handleBeforeThrow(Ljava/lang/Throwable;)V

    .line 617
    throw v0
.end method

.method public read([BII)I
    .locals 15
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 623
    move-object v1, p0

    move/from16 v2, p3

    const/4 v0, 0x0

    if-nez v2, :cond_0

    .line 624
    return v0

    .line 626
    :cond_0
    iget-wide v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    const/4 v4, -0x1

    if-nez v3, :cond_1

    .line 627
    return v4

    .line 629
    :cond_1
    iget-object v3, v1, Landroidx/media3/datasource/cache/CacheDataSource;->requestDataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/datasource/DataSpec;

    .line 630
    .local v3, "requestDataSpec":Landroidx/media3/datasource/DataSpec;
    iget-object v7, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSpec:Landroidx/media3/datasource/DataSpec;

    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/media3/datasource/DataSpec;

    .line 632
    .local v7, "currentDataSpec":Landroidx/media3/datasource/DataSpec;
    :try_start_0
    iget-wide v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    iget-wide v10, v1, Landroidx/media3/datasource/cache/CacheDataSource;->checkCachePosition:J

    cmp-long v8, v8, v10

    if-ltz v8, :cond_2

    .line 633
    const/4 v8, 0x1

    invoke-direct {p0, v3, v8}, Landroidx/media3/datasource/cache/CacheDataSource;->openNextSource(Landroidx/media3/datasource/DataSpec;Z)V

    .line 635
    :cond_2
    iget-object v8, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSource:Landroidx/media3/datasource/DataSource;

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/datasource/DataSource;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-object/from16 v9, p1

    move/from16 v10, p2

    :try_start_1
    invoke-interface {v8, v9, v10, v2}, Landroidx/media3/datasource/DataSource;->read([BII)I

    move-result v8

    .line 636
    .local v8, "bytesRead":I
    const-wide/16 v11, -0x1

    if-eq v8, v4, :cond_4

    .line 637
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromCache()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 638
    iget-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->totalCachedBytesRead:J

    int-to-long v13, v8

    add-long/2addr v4, v13

    iput-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->totalCachedBytesRead:J

    .line 640
    :cond_3
    iget-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    int-to-long v13, v8

    add-long/2addr v4, v13

    iput-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->readPosition:J

    .line 641
    iget-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSourceBytesRead:J

    int-to-long v13, v8

    add-long/2addr v4, v13

    iput-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSourceBytesRead:J

    .line 642
    iget-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v0, v4, v11

    if-eqz v0, :cond_7

    .line 643
    int-to-long v11, v8

    sub-long/2addr v4, v11

    iput-wide v4, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    goto :goto_0

    .line 645
    :cond_4
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->isReadingFromUpstream()Z

    move-result v4

    if-eqz v4, :cond_6

    iget-wide v13, v7, Landroidx/media3/datasource/DataSpec;->length:J

    cmp-long v4, v13, v11

    if-eqz v4, :cond_5

    iget-wide v13, v1, Landroidx/media3/datasource/cache/CacheDataSource;->currentDataSourceBytesRead:J

    iget-wide v11, v7, Landroidx/media3/datasource/DataSpec;->length:J

    cmp-long v4, v13, v11

    if-gez v4, :cond_6

    .line 651
    :cond_5
    iget-object v0, v3, Landroidx/media3/datasource/DataSpec;->key:Ljava/lang/String;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-direct {p0, v0}, Landroidx/media3/datasource/cache/CacheDataSource;->setNoBytesRemainingAndMaybeStoreLength(Ljava/lang/String;)V

    goto :goto_0

    .line 652
    :cond_6
    iget-wide v11, v1, Landroidx/media3/datasource/cache/CacheDataSource;->bytesRemaining:J

    cmp-long v4, v11, v5

    if-gtz v4, :cond_8

    const-wide/16 v4, -0x1

    cmp-long v4, v11, v4

    if-nez v4, :cond_7

    goto :goto_1

    .line 657
    :cond_7
    :goto_0
    return v8

    .line 653
    :cond_8
    :goto_1
    invoke-direct {p0}, Landroidx/media3/datasource/cache/CacheDataSource;->closeCurrentSource()V

    .line 654
    invoke-direct {p0, v3, v0}, Landroidx/media3/datasource/cache/CacheDataSource;->openNextSource(Landroidx/media3/datasource/DataSpec;Z)V

    .line 655
    invoke-virtual/range {p0 .. p3}, Landroidx/media3/datasource/cache/CacheDataSource;->read([BII)I

    move-result v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return v0

    .line 658
    .end local v8    # "bytesRead":I
    :catchall_0
    move-exception v0

    goto :goto_2

    :catchall_1
    move-exception v0

    move-object/from16 v9, p1

    move/from16 v10, p2

    .line 659
    .local v0, "e":Ljava/lang/Throwable;
    :goto_2
    invoke-direct {p0, v0}, Landroidx/media3/datasource/cache/CacheDataSource;->handleBeforeThrow(Ljava/lang/Throwable;)V

    .line 660
    throw v0
.end method
