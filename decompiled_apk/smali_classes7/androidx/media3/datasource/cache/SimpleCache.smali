.class public final Landroidx/media3/datasource/cache/SimpleCache;
.super Ljava/lang/Object;
.source "SimpleCache.java"

# interfaces
.implements Landroidx/media3/datasource/cache/Cache;


# static fields
.field private static final SUBDIRECTORY_COUNT:I = 0xa

.field private static final TAG:Ljava/lang/String; = "SimpleCache"

.field private static final UID_FILE_SUFFIX:Ljava/lang/String; = ".uid"

.field private static final lockedCacheDirs:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final cacheDir:Ljava/io/File;

.field private final contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

.field private final evictor:Landroidx/media3/datasource/cache/CacheEvictor;

.field private final fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

.field private initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;

.field private final listeners:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList<",
            "Landroidx/media3/datasource/cache/Cache$Listener;",
            ">;>;"
        }
    .end annotation
.end field

.field private final random:Ljava/util/Random;

.field private released:Z

.field private totalSpace:J

.field private final touchCacheSpans:Z

.field private uid:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 65
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Landroidx/media3/datasource/cache/SimpleCache;->lockedCacheDirs:Ljava/util/HashSet;

    return-void
.end method

.method public constructor <init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;)V
    .locals 7
    .param p1, "cacheDir"    # Ljava/io/File;
    .param p2, "evictor"    # Landroidx/media3/datasource/cache/CacheEvictor;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 142
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    invoke-direct/range {v0 .. v6}, Landroidx/media3/datasource/cache/SimpleCache;-><init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/database/DatabaseProvider;[BZZ)V

    .line 149
    return-void
.end method

.method public constructor <init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/database/DatabaseProvider;)V
    .locals 7
    .param p1, "cacheDir"    # Ljava/io/File;
    .param p2, "evictor"    # Landroidx/media3/datasource/cache/CacheEvictor;
    .param p3, "databaseProvider"    # Landroidx/media3/database/DatabaseProvider;

    .line 161
    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-direct/range {v0 .. v6}, Landroidx/media3/datasource/cache/SimpleCache;-><init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/database/DatabaseProvider;[BZZ)V

    .line 168
    return-void
.end method

.method public constructor <init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/database/DatabaseProvider;[BZZ)V
    .locals 7
    .param p1, "cacheDir"    # Ljava/io/File;
    .param p2, "evictor"    # Landroidx/media3/datasource/cache/CacheEvictor;
    .param p3, "databaseProvider"    # Landroidx/media3/database/DatabaseProvider;
    .param p4, "legacyIndexSecretKey"    # [B
    .param p5, "legacyIndexEncrypt"    # Z
    .param p6, "preferLegacyIndex"    # Z

    .line 196
    new-instance v6, Landroidx/media3/datasource/cache/CachedContentIndex;

    move-object v0, v6

    move-object v1, p3

    move-object v2, p1

    move-object v3, p4

    move v4, p5

    move v5, p6

    invoke-direct/range {v0 .. v5}, Landroidx/media3/datasource/cache/CachedContentIndex;-><init>(Landroidx/media3/database/DatabaseProvider;Ljava/io/File;[BZZ)V

    .line 205
    if-eqz p3, :cond_0

    if-nez p6, :cond_0

    .line 206
    new-instance v0, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    invoke-direct {v0, p3}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;-><init>(Landroidx/media3/database/DatabaseProvider;)V

    goto :goto_0

    .line 207
    :cond_0
    const/4 v0, 0x0

    .line 196
    :goto_0
    invoke-direct {p0, p1, p2, v6, v0}, Landroidx/media3/datasource/cache/SimpleCache;-><init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/datasource/cache/CachedContentIndex;Landroidx/media3/datasource/cache/CacheFileMetadataIndex;)V

    .line 208
    return-void
.end method

.method constructor <init>(Ljava/io/File;Landroidx/media3/datasource/cache/CacheEvictor;Landroidx/media3/datasource/cache/CachedContentIndex;Landroidx/media3/datasource/cache/CacheFileMetadataIndex;)V
    .locals 3
    .param p1, "cacheDir"    # Ljava/io/File;
    .param p2, "evictor"    # Landroidx/media3/datasource/cache/CacheEvictor;
    .param p3, "contentIndex"    # Landroidx/media3/datasource/cache/CachedContentIndex;
    .param p4, "fileIndex"    # Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    .line 214
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 215
    invoke-static {p1}, Landroidx/media3/datasource/cache/SimpleCache;->lockFolder(Ljava/io/File;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 219
    iput-object p1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    .line 220
    iput-object p2, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    .line 221
    iput-object p3, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    .line 222
    iput-object p4, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    .line 223
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    .line 224
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    iput-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->random:Ljava/util/Random;

    .line 225
    invoke-interface {p2}, Landroidx/media3/datasource/cache/CacheEvictor;->requiresCacheSpanTouches()Z

    move-result v0

    iput-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->touchCacheSpans:Z

    .line 226
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J

    .line 229
    new-instance v0, Landroid/os/ConditionVariable;

    invoke-direct {v0}, Landroid/os/ConditionVariable;-><init>()V

    .line 230
    .local v0, "conditionVariable":Landroid/os/ConditionVariable;
    new-instance v1, Landroidx/media3/datasource/cache/SimpleCache$1;

    const-string v2, "ExoPlayer:SimpleCacheInit"

    invoke-direct {v1, p0, v2, v0}, Landroidx/media3/datasource/cache/SimpleCache$1;-><init>(Landroidx/media3/datasource/cache/SimpleCache;Ljava/lang/String;Landroid/os/ConditionVariable;)V

    .line 239
    invoke-virtual {v1}, Landroidx/media3/datasource/cache/SimpleCache$1;->start()V

    .line 240
    invoke-virtual {v0}, Landroid/os/ConditionVariable;->block()V

    .line 241
    return-void

    .line 216
    .end local v0    # "conditionVariable":Landroid/os/ConditionVariable;
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Another SimpleCache instance uses the folder: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic access$000(Landroidx/media3/datasource/cache/SimpleCache;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/datasource/cache/SimpleCache;

    .line 51
    invoke-direct {p0}, Landroidx/media3/datasource/cache/SimpleCache;->initialize()V

    return-void
.end method

.method static synthetic access$100(Landroidx/media3/datasource/cache/SimpleCache;)Landroidx/media3/datasource/cache/CacheEvictor;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/datasource/cache/SimpleCache;

    .line 51
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    return-object v0
.end method

.method private addSpan(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V
    .locals 4
    .param p1, "span"    # Landroidx/media3/datasource/cache/SimpleCacheSpan;

    .line 693
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v1, p1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->getOrAdd(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContent;->addSpan(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V

    .line 694
    iget-wide v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->totalSpace:J

    iget-wide v2, p1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->totalSpace:J

    .line 695
    invoke-direct {p0, p1}, Landroidx/media3/datasource/cache/SimpleCache;->notifySpanAdded(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V

    .line 696
    return-void
.end method

.method private static createCacheDirectories(Ljava/io/File;)V
    .locals 2
    .param p0, "cacheDir"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    .line 809
    invoke-virtual {p0}, Ljava/io/File;->mkdirs()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 810
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Failed to create cache directory: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 811
    .local v0, "message":Ljava/lang/String;
    const-string v1, "SimpleCache"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 812
    new-instance v1, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v1, v0}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 814
    .end local v0    # "message":Ljava/lang/String;
    :cond_1
    :goto_0
    return-void
.end method

.method private static createUid(Ljava/io/File;)J
    .locals 7
    .param p0, "directory"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 791
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    invoke-virtual {v0}, Ljava/security/SecureRandom;->nextLong()J

    move-result-wide v0

    .line 792
    .local v0, "uid":J
    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v2, v0, v2

    if-nez v2, :cond_0

    const-wide/16 v2, 0x0

    goto :goto_0

    :cond_0
    invoke-static {v0, v1}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    :goto_0
    move-wide v0, v2

    .line 794
    const/16 v2, 0x10

    invoke-static {v0, v1, v2}, Ljava/lang/Long;->toString(JI)Ljava/lang/String;

    move-result-object v2

    .line 795
    .local v2, "hexUid":Ljava/lang/String;
    new-instance v3, Ljava/io/File;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ".uid"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, p0, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 796
    .local v3, "hexUidFile":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->createNewFile()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 800
    return-wide v0

    .line 798
    :cond_1
    new-instance v4, Ljava/io/IOException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Failed to create UID file: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static delete(Ljava/io/File;Landroidx/media3/database/DatabaseProvider;)V
    .locals 7
    .param p0, "cacheDir"    # Ljava/io/File;
    .param p1, "databaseProvider"    # Landroidx/media3/database/DatabaseProvider;

    .line 99
    const-string v0, "Failed to delete file metadata: "

    const-string v1, "SimpleCache"

    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_0

    .line 100
    return-void

    .line 103
    :cond_0
    invoke-virtual {p0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 104
    .local v2, "files":[Ljava/io/File;
    if-nez v2, :cond_1

    .line 105
    invoke-virtual {p0}, Ljava/io/File;->delete()Z

    .line 106
    return-void

    .line 109
    :cond_1
    if-eqz p1, :cond_2

    .line 112
    invoke-static {v2}, Landroidx/media3/datasource/cache/SimpleCache;->loadUid([Ljava/io/File;)J

    move-result-wide v3

    .line 113
    .local v3, "uid":J
    const-wide/16 v5, -0x1

    cmp-long v5, v3, v5

    if-eqz v5, :cond_2

    .line 115
    :try_start_0
    invoke-static {p1, v3, v4}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->delete(Landroidx/media3/database/DatabaseProvider;J)V
    :try_end_0
    .catch Landroidx/media3/database/DatabaseIOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 118
    goto :goto_0

    .line 116
    :catch_0
    move-exception v5

    .line 117
    .local v5, "e":Landroidx/media3/database/DatabaseIOException;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v1, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    .end local v5    # "e":Landroidx/media3/database/DatabaseIOException;
    :goto_0
    :try_start_1
    invoke-static {p1, v3, v4}, Landroidx/media3/datasource/cache/CachedContentIndex;->delete(Landroidx/media3/database/DatabaseProvider;J)V
    :try_end_1
    .catch Landroidx/media3/database/DatabaseIOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 123
    goto :goto_1

    .line 121
    :catch_1
    move-exception v5

    .line 122
    .restart local v5    # "e":Landroidx/media3/database/DatabaseIOException;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    .end local v3    # "uid":J
    .end local v5    # "e":Landroidx/media3/database/DatabaseIOException;
    :cond_2
    :goto_1
    invoke-static {p0}, Landroidx/media3/common/util/Util;->recursiveDelete(Ljava/io/File;)V

    .line 128
    return-void
.end method

.method private getSpan(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .locals 6
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J

    .line 671
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 672
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    if-nez v0, :cond_0

    .line 673
    invoke-static {p1, p2, p3, p4, p5}, Landroidx/media3/datasource/cache/SimpleCacheSpan;->createHole(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v1

    return-object v1

    .line 676
    :cond_0
    :goto_0
    invoke-virtual {v0, p2, p3, p4, p5}, Landroidx/media3/datasource/cache/CachedContent;->getSpan(JJ)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v1

    .line 677
    .local v1, "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    iget-boolean v2, v1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->isCached:Z

    if-eqz v2, :cond_1

    iget-object v2, v1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->file:Ljava/io/File;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v2

    iget-wide v4, v1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    cmp-long v2, v2, v4

    if-eqz v2, :cond_1

    .line 680
    invoke-direct {p0}, Landroidx/media3/datasource/cache/SimpleCache;->removeStaleSpans()V

    .line 681
    goto :goto_0

    .line 683
    :cond_1
    return-object v1
.end method

.method private initialize()V
    .locals 6

    .line 519
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_0

    .line 521
    :try_start_0
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v0}, Landroidx/media3/datasource/cache/SimpleCache;->createCacheDirectories(Ljava/io/File;)V
    :try_end_0
    .catch Landroidx/media3/datasource/cache/Cache$CacheException; {:try_start_0 .. :try_end_0} :catch_0

    .line 525
    goto :goto_0

    .line 522
    :catch_0
    move-exception v0

    .line 523
    .local v0, "e":Landroidx/media3/datasource/cache/Cache$CacheException;
    iput-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;

    .line 524
    return-void

    .line 528
    .end local v0    # "e":Landroidx/media3/datasource/cache/Cache$CacheException;
    :cond_0
    :goto_0
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .line 529
    .local v0, "files":[Ljava/io/File;
    const-string v1, "SimpleCache"

    if-nez v0, :cond_1

    .line 530
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to list cache directory files: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 531
    .local v2, "message":Ljava/lang/String;
    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 532
    new-instance v1, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v1, v2}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;

    .line 533
    return-void

    .line 536
    .end local v2    # "message":Ljava/lang/String;
    :cond_1
    invoke-static {v0}, Landroidx/media3/datasource/cache/SimpleCache;->loadUid([Ljava/io/File;)J

    move-result-wide v2

    iput-wide v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J

    .line 537
    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    .line 539
    :try_start_1
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v2}, Landroidx/media3/datasource/cache/SimpleCache;->createUid(Ljava/io/File;)J

    move-result-wide v2

    iput-wide v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 545
    goto :goto_1

    .line 540
    :catch_1
    move-exception v2

    .line 541
    .local v2, "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to create cache UID: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 542
    .local v3, "message":Ljava/lang/String;
    invoke-static {v1, v3, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 543
    new-instance v1, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v1, v3, v2}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    iput-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;

    .line 544
    return-void

    .line 549
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "message":Ljava/lang/String;
    :cond_2
    :goto_1
    :try_start_2
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-wide v3, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J

    invoke-virtual {v2, v3, v4}, Landroidx/media3/datasource/cache/CachedContentIndex;->initialize(J)V

    .line 550
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    const/4 v3, 0x1

    if-eqz v2, :cond_3

    .line 551
    iget-wide v4, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J

    invoke-virtual {v2, v4, v5}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->initialize(J)V

    .line 552
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    invoke-virtual {v2}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->getAll()Ljava/util/Map;

    move-result-object v2

    .line 553
    .local v2, "fileMetadata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/datasource/cache/CacheFileMetadata;>;"
    iget-object v4, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-direct {p0, v4, v3, v0, v2}, Landroidx/media3/datasource/cache/SimpleCache;->loadDirectory(Ljava/io/File;Z[Ljava/io/File;Ljava/util/Map;)V

    .line 554
    iget-object v3, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->removeAll(Ljava/util/Set;)V

    .line 555
    .end local v2    # "fileMetadata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/datasource/cache/CacheFileMetadata;>;"
    goto :goto_2

    .line 556
    :cond_3
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    const/4 v4, 0x0

    invoke-direct {p0, v2, v3, v0, v4}, Landroidx/media3/datasource/cache/SimpleCache;->loadDirectory(Ljava/io/File;Z[Ljava/io/File;Ljava/util/Map;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    .line 563
    :goto_2
    nop

    .line 565
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v2}, Landroidx/media3/datasource/cache/CachedContentIndex;->removeEmpty()V

    .line 567
    :try_start_3
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v2}, Landroidx/media3/datasource/cache/CachedContentIndex;->store()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 570
    goto :goto_3

    .line 568
    :catch_2
    move-exception v2

    .line 569
    .local v2, "e":Ljava/io/IOException;
    const-string v3, "Storing index file failed"

    invoke-static {v1, v3, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 571
    .end local v2    # "e":Ljava/io/IOException;
    :goto_3
    return-void

    .line 558
    :catch_3
    move-exception v2

    .line 559
    .restart local v2    # "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to initialize cache indices: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 560
    .restart local v3    # "message":Ljava/lang/String;
    invoke-static {v1, v3, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 561
    new-instance v1, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v1, v3, v2}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    iput-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;

    .line 562
    return-void
.end method

.method public static declared-synchronized isCacheFolderLocked(Ljava/io/File;)Z
    .locals 3
    .param p0, "cacheFolder"    # Ljava/io/File;

    const-class v0, Landroidx/media3/datasource/cache/SimpleCache;

    monitor-enter v0

    .line 85
    :try_start_0
    sget-object v1, Landroidx/media3/datasource/cache/SimpleCache;->lockedCacheDirs:Ljava/util/HashSet;

    invoke-virtual {p0}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    .line 85
    .end local p0    # "cacheFolder":Ljava/io/File;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method private loadDirectory(Ljava/io/File;Z[Ljava/io/File;Ljava/util/Map;)V
    .locals 19
    .param p1, "directory"    # Ljava/io/File;
    .param p2, "isRoot"    # Z
    .param p3, "files"    # [Ljava/io/File;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Z[",
            "Ljava/io/File;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/CacheFileMetadata;",
            ">;)V"
        }
    .end annotation

    .line 588
    .local p4, "fileMetadata":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/media3/datasource/cache/CacheFileMetadata;>;"
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    if-eqz v1, :cond_8

    array-length v3, v1

    if-nez v3, :cond_0

    goto/16 :goto_4

    .line 597
    :cond_0
    array-length v3, v1

    const/4 v4, 0x0

    move v5, v4

    :goto_0
    if-ge v5, v3, :cond_7

    aget-object v12, v1, v5

    .line 598
    .local v12, "file":Ljava/io/File;
    invoke-virtual {v12}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v13

    .line 599
    .local v13, "fileName":Ljava/lang/String;
    if-eqz p2, :cond_1

    const/16 v6, 0x2e

    invoke-virtual {v13, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v6

    const/4 v7, -0x1

    if-ne v6, v7, :cond_1

    .line 600
    invoke-virtual {v12}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v6

    invoke-direct {v0, v12, v4, v6, v2}, Landroidx/media3/datasource/cache/SimpleCache;->loadDirectory(Ljava/io/File;Z[Ljava/io/File;Ljava/util/Map;)V

    goto :goto_3

    .line 602
    :cond_1
    if-eqz p2, :cond_2

    .line 603
    invoke-static {v13}, Landroidx/media3/datasource/cache/CachedContentIndex;->isIndexFile(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_6

    const-string v6, ".uid"

    invoke-virtual {v13, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 605
    goto :goto_3

    .line 607
    :cond_2
    const-wide/16 v6, -0x1

    .line 608
    .local v6, "length":J
    const-wide v8, -0x7fffffffffffffffL    # -4.9E-324

    .line 610
    .local v8, "lastTouchTimestamp":J
    if-eqz v2, :cond_3

    invoke-interface {v2, v13}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroidx/media3/datasource/cache/CacheFileMetadata;

    goto :goto_1

    :cond_3
    const/4 v10, 0x0

    :goto_1
    move-object v14, v10

    .line 611
    .local v14, "metadata":Landroidx/media3/datasource/cache/CacheFileMetadata;
    if-eqz v14, :cond_4

    .line 612
    iget-wide v6, v14, Landroidx/media3/datasource/cache/CacheFileMetadata;->length:J

    .line 613
    iget-wide v8, v14, Landroidx/media3/datasource/cache/CacheFileMetadata;->lastTouchTimestamp:J

    move-wide v15, v6

    move-wide/from16 v17, v8

    goto :goto_2

    .line 611
    :cond_4
    move-wide v15, v6

    move-wide/from16 v17, v8

    .line 616
    .end local v6    # "length":J
    .end local v8    # "lastTouchTimestamp":J
    .local v15, "length":J
    .local v17, "lastTouchTimestamp":J
    :goto_2
    iget-object v11, v0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    .line 617
    move-object v6, v12

    move-wide v7, v15

    move-wide/from16 v9, v17

    invoke-static/range {v6 .. v11}, Landroidx/media3/datasource/cache/SimpleCacheSpan;->createCacheEntry(Ljava/io/File;JJLandroidx/media3/datasource/cache/CachedContentIndex;)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v6

    .line 618
    .local v6, "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    if-eqz v6, :cond_5

    .line 619
    invoke-direct {v0, v6}, Landroidx/media3/datasource/cache/SimpleCache;->addSpan(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V

    goto :goto_3

    .line 621
    :cond_5
    invoke-virtual {v12}, Ljava/io/File;->delete()Z

    .line 597
    .end local v6    # "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .end local v12    # "file":Ljava/io/File;
    .end local v13    # "fileName":Ljava/lang/String;
    .end local v14    # "metadata":Landroidx/media3/datasource/cache/CacheFileMetadata;
    .end local v15    # "length":J
    .end local v17    # "lastTouchTimestamp":J
    :cond_6
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 625
    :cond_7
    return-void

    .line 590
    :cond_8
    :goto_4
    if-nez p2, :cond_9

    .line 593
    invoke-virtual/range {p1 .. p1}, Ljava/io/File;->delete()Z

    .line 595
    :cond_9
    return-void
.end method

.method private static loadUid([Ljava/io/File;)J
    .locals 7
    .param p0, "files"    # [Ljava/io/File;

    .line 773
    array-length v0, p0

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_1

    aget-object v2, p0, v1

    .line 774
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    .line 775
    .local v3, "fileName":Ljava/lang/String;
    const-string v4, ".uid"

    invoke-virtual {v3, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 777
    :try_start_0
    invoke-static {v3}, Landroidx/media3/datasource/cache/SimpleCache;->parseUid(Ljava/lang/String;)J

    move-result-wide v0
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-wide v0

    .line 778
    :catch_0
    move-exception v4

    .line 780
    .local v4, "e":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Malformed UID file: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, "SimpleCache"

    invoke-static {v6, v5}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 781
    invoke-virtual {v2}, Ljava/io/File;->delete()Z

    .line 773
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fileName":Ljava/lang/String;
    .end local v4    # "e":Ljava/lang/NumberFormatException;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 785
    :cond_1
    const-wide/16 v0, -0x1

    return-wide v0
.end method

.method private static declared-synchronized lockFolder(Ljava/io/File;)Z
    .locals 3
    .param p0, "cacheDir"    # Ljava/io/File;

    const-class v0, Landroidx/media3/datasource/cache/SimpleCache;

    monitor-enter v0

    .line 817
    :try_start_0
    sget-object v1, Landroidx/media3/datasource/cache/SimpleCache;->lockedCacheDirs:Ljava/util/HashSet;

    invoke-virtual {p0}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    move-result v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    .line 817
    .end local p0    # "cacheDir":Ljava/io/File;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method

.method private notifySpanAdded(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V
    .locals 3
    .param p1, "span"    # Landroidx/media3/datasource/cache/SimpleCacheSpan;

    .line 747
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    iget-object v1, p1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 748
    .local v0, "keyListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    if-eqz v0, :cond_0

    .line 749
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 750
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/datasource/cache/Cache$Listener;

    invoke-interface {v2, p0, p1}, Landroidx/media3/datasource/cache/Cache$Listener;->onSpanAdded(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 749
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 753
    .end local v1    # "i":I
    :cond_0
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    invoke-interface {v1, p0, p1}, Landroidx/media3/datasource/cache/CacheEvictor;->onSpanAdded(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 754
    return-void
.end method

.method private notifySpanRemoved(Landroidx/media3/datasource/cache/CacheSpan;)V
    .locals 3
    .param p1, "span"    # Landroidx/media3/datasource/cache/CacheSpan;

    .line 737
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    iget-object v1, p1, Landroidx/media3/datasource/cache/CacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 738
    .local v0, "keyListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    if-eqz v0, :cond_0

    .line 739
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 740
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/datasource/cache/Cache$Listener;

    invoke-interface {v2, p0, p1}, Landroidx/media3/datasource/cache/Cache$Listener;->onSpanRemoved(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 739
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 743
    .end local v1    # "i":I
    :cond_0
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    invoke-interface {v1, p0, p1}, Landroidx/media3/datasource/cache/CacheEvictor;->onSpanRemoved(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 744
    return-void
.end method

.method private notifySpanTouched(Landroidx/media3/datasource/cache/SimpleCacheSpan;Landroidx/media3/datasource/cache/CacheSpan;)V
    .locals 3
    .param p1, "oldSpan"    # Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .param p2, "newSpan"    # Landroidx/media3/datasource/cache/CacheSpan;

    .line 757
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    iget-object v1, p1, Landroidx/media3/datasource/cache/SimpleCacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 758
    .local v0, "keyListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    if-eqz v0, :cond_0

    .line 759
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_0

    .line 760
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/datasource/cache/Cache$Listener;

    invoke-interface {v2, p0, p1, p2}, Landroidx/media3/datasource/cache/Cache$Listener;->onSpanTouched(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 759
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 763
    .end local v1    # "i":I
    :cond_0
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    invoke-interface {v1, p0, p1, p2}, Landroidx/media3/datasource/cache/CacheEvictor;->onSpanTouched(Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/cache/CacheSpan;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 764
    return-void
.end method

.method private static parseUid(Ljava/lang/String;)J
    .locals 2
    .param p0, "fileName"    # Ljava/lang/String;

    .line 804
    const/16 v0, 0x2e

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x10

    invoke-static {v0, v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J

    move-result-wide v0

    return-wide v0
.end method

.method private removeSpanInternal(Landroidx/media3/datasource/cache/CacheSpan;)V
    .locals 5
    .param p1, "span"    # Landroidx/media3/datasource/cache/CacheSpan;

    .line 699
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v1, p1, Landroidx/media3/datasource/cache/CacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 700
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    if-eqz v0, :cond_2

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContent;->removeSpan(Landroidx/media3/datasource/cache/CacheSpan;)Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_1

    .line 703
    :cond_0
    iget-wide v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->totalSpace:J

    iget-wide v3, p1, Landroidx/media3/datasource/cache/CacheSpan;->length:J

    sub-long/2addr v1, v3

    iput-wide v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->totalSpace:J

    .line 704
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    if-eqz v1, :cond_1

    .line 705
    iget-object v1, p1, Landroidx/media3/datasource/cache/CacheSpan;->file:Ljava/io/File;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v1

    .line 707
    .local v1, "fileName":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    invoke-virtual {v2, v1}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->remove(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 712
    goto :goto_0

    .line 708
    :catch_0
    move-exception v2

    .line 711
    .local v2, "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to remove file index entry for: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "SimpleCache"

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 714
    .end local v1    # "fileName":Ljava/lang/String;
    .end local v2    # "e":Ljava/io/IOException;
    :cond_1
    :goto_0
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v2, v0, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroidx/media3/datasource/cache/CachedContentIndex;->maybeRemove(Ljava/lang/String;)V

    .line 715
    invoke-direct {p0, p1}, Landroidx/media3/datasource/cache/SimpleCache;->notifySpanRemoved(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 716
    return-void

    .line 701
    :cond_2
    :goto_1
    return-void
.end method

.method private removeStaleSpans()V
    .locals 9

    .line 723
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 724
    .local v0, "spansToBeRemoved":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/CacheSpan;>;"
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->getAll()Ljava/util/Collection;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/datasource/cache/CachedContent;

    .line 725
    .local v2, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    invoke-virtual {v2}, Landroidx/media3/datasource/cache/CachedContent;->getSpans()Ljava/util/TreeSet;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/TreeSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/datasource/cache/CacheSpan;

    .line 726
    .local v4, "span":Landroidx/media3/datasource/cache/CacheSpan;
    iget-object v5, v4, Landroidx/media3/datasource/cache/CacheSpan;->file:Ljava/io/File;

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v5

    iget-wide v7, v4, Landroidx/media3/datasource/cache/CacheSpan;->length:J

    cmp-long v5, v5, v7

    if-eqz v5, :cond_0

    .line 727
    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 729
    .end local v4    # "span":Landroidx/media3/datasource/cache/CacheSpan;
    :cond_0
    goto :goto_1

    .line 730
    .end local v2    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    :cond_1
    goto :goto_0

    .line 731
    :cond_2
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_2
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_3

    .line 732
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/datasource/cache/CacheSpan;

    invoke-direct {p0, v2}, Landroidx/media3/datasource/cache/SimpleCache;->removeSpanInternal(Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 731
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 734
    .end local v1    # "i":I
    :cond_3
    return-void
.end method

.method private touchSpan(Ljava/lang/String;Landroidx/media3/datasource/cache/SimpleCacheSpan;)Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .locals 12
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "span"    # Landroidx/media3/datasource/cache/SimpleCacheSpan;

    .line 636
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->touchCacheSpans:Z

    if-nez v0, :cond_0

    .line 637
    return-object p2

    .line 639
    :cond_0
    iget-object v0, p2, Landroidx/media3/datasource/cache/SimpleCacheSpan;->file:Ljava/io/File;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    .line 640
    .local v0, "fileName":Ljava/lang/String;
    iget-wide v7, p2, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    .line 641
    .local v7, "length":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    .line 642
    .local v9, "lastTouchTimestamp":J
    const/4 v11, 0x0

    .line 643
    .local v11, "updateFile":Z
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    if-eqz v1, :cond_1

    .line 645
    move-object v2, v0

    move-wide v3, v7

    move-wide v5, v9

    :try_start_0
    invoke-virtual/range {v1 .. v6}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->set(Ljava/lang/String;JJ)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 646
    :catch_0
    move-exception v1

    .line 647
    .local v1, "e":Ljava/io/IOException;
    const-string v2, "SimpleCache"

    const-string v3, "Failed to update index with new touch timestamp."

    invoke-static {v2, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 648
    .end local v1    # "e":Ljava/io/IOException;
    :goto_0
    goto :goto_1

    .line 652
    :cond_1
    const/4 v11, 0x1

    .line 654
    :goto_1
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    .line 655
    invoke-virtual {v1, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/datasource/cache/CachedContent;

    .line 656
    invoke-virtual {v1, p2, v9, v10, v11}, Landroidx/media3/datasource/cache/CachedContent;->setLastTouchTimestamp(Landroidx/media3/datasource/cache/SimpleCacheSpan;JZ)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v1

    .line 657
    .local v1, "newSpan":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    invoke-direct {p0, p2, v1}, Landroidx/media3/datasource/cache/SimpleCache;->notifySpanTouched(Landroidx/media3/datasource/cache/SimpleCacheSpan;Landroidx/media3/datasource/cache/CacheSpan;)V

    .line 658
    return-object v1
.end method

.method private static declared-synchronized unlockFolder(Ljava/io/File;)V
    .locals 3
    .param p0, "cacheDir"    # Ljava/io/File;

    const-class v0, Landroidx/media3/datasource/cache/SimpleCache;

    monitor-enter v0

    .line 821
    :try_start_0
    sget-object v1, Landroidx/media3/datasource/cache/SimpleCache;->lockedCacheDirs:Ljava/util/HashSet;

    invoke-virtual {p0}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 822
    monitor-exit v0

    return-void

    .line 820
    .end local p0    # "cacheDir":Ljava/io/File;
    :catchall_0
    move-exception p0

    monitor-exit v0

    throw p0
.end method


# virtual methods
.method public declared-synchronized addListener(Ljava/lang/String;Landroidx/media3/datasource/cache/Cache$Listener;)Ljava/util/NavigableSet;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "listener"    # Landroidx/media3/datasource/cache/Cache$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroidx/media3/datasource/cache/Cache$Listener;",
            ")",
            "Ljava/util/NavigableSet<",
            "Landroidx/media3/datasource/cache/CacheSpan;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    .line 278
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 279
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 282
    .local v0, "listenersForKey":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    if-nez v0, :cond_1

    .line 283
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v0, v1

    .line 284
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 286
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 287
    invoke-virtual {p0, p1}, Landroidx/media3/datasource/cache/SimpleCache;->getCachedSpans(Ljava/lang/String;)Ljava/util/NavigableSet;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 277
    .end local v0    # "listenersForKey":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "listener":Landroidx/media3/datasource/cache/Cache$Listener;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized applyContentMetadataMutations(Ljava/lang/String;Landroidx/media3/datasource/cache/ContentMetadataMutations;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "mutations"    # Landroidx/media3/datasource/cache/ContentMetadataMutations;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 500
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 501
    invoke-virtual {p0}, Landroidx/media3/datasource/cache/SimpleCache;->checkInitialization()V

    .line 503
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/datasource/cache/CachedContentIndex;->applyContentMetadataMutations(Ljava/lang/String;Landroidx/media3/datasource/cache/ContentMetadataMutations;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 505
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CachedContentIndex;->store()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 508
    nop

    .line 509
    monitor-exit p0

    return-void

    .line 506
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catch_0
    move-exception v0

    .line 507
    .local v0, "e":Ljava/io/IOException;
    :try_start_2
    new-instance v1, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v1, v0}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/Throwable;)V

    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 499
    .end local v0    # "e":Ljava/io/IOException;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "mutations":Landroidx/media3/datasource/cache/ContentMetadataMutations;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized checkInitialization()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 249
    :try_start_0
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->initializationException:Landroidx/media3/datasource/cache/Cache$CacheException;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 252
    monitor-exit p0

    return-void

    .line 250
    :cond_0
    :try_start_1
    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 248
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized commitFile(Ljava/io/File;J)V
    .locals 12
    .param p1, "file"    # Ljava/io/File;
    .param p2, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 397
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 398
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_1

    .line 399
    monitor-exit p0

    return-void

    .line 401
    :cond_1
    const-wide/16 v3, 0x0

    cmp-long v0, p2, v3

    if-nez v0, :cond_2

    .line 402
    :try_start_1
    invoke-virtual {p1}, Ljava/io/File;->delete()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 403
    monitor-exit p0

    return-void

    .line 406
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_2
    :try_start_2
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    .line 407
    invoke-static {p1, p2, p3, v0}, Landroidx/media3/datasource/cache/SimpleCacheSpan;->createCacheEntry(Ljava/io/File;JLandroidx/media3/datasource/cache/CachedContentIndex;)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;

    .line 408
    .local v0, "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    iget-object v3, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v4, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/datasource/cache/CachedContent;

    .line 409
    .local v3, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    iget-wide v4, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->position:J

    iget-wide v6, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    invoke-virtual {v3, v4, v5, v6, v7}, Landroidx/media3/datasource/cache/CachedContent;->isFullyLocked(JJ)Z

    move-result v4

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 412
    invoke-virtual {v3}, Landroidx/media3/datasource/cache/CachedContent;->getMetadata()Landroidx/media3/datasource/cache/DefaultContentMetadata;

    move-result-object v4

    invoke-static {v4}, Landroidx/media3/datasource/cache/ContentMetadata;->getContentLength(Landroidx/media3/datasource/cache/ContentMetadata;)J

    move-result-wide v4

    .line 413
    .local v4, "contentLength":J
    const-wide/16 v6, -0x1

    cmp-long v6, v4, v6

    if-eqz v6, :cond_4

    .line 414
    iget-wide v6, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->position:J

    iget-wide v8, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    add-long/2addr v6, v8

    cmp-long v6, v6, v4

    if-gtz v6, :cond_3

    goto :goto_1

    :cond_3
    move v1, v2

    :goto_1
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 417
    :cond_4
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    if-eqz v1, :cond_5

    .line 418
    invoke-virtual {p1}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 420
    .local v7, "fileName":Ljava/lang/String;
    :try_start_3
    iget-object v6, p0, Landroidx/media3/datasource/cache/SimpleCache;->fileIndex:Landroidx/media3/datasource/cache/CacheFileMetadataIndex;

    iget-wide v8, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    iget-wide v10, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->lastTouchTimestamp:J

    invoke-virtual/range {v6 .. v11}, Landroidx/media3/datasource/cache/CacheFileMetadataIndex;->set(Ljava/lang/String;JJ)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 423
    goto :goto_2

    .line 421
    :catch_0
    move-exception v1

    .line 422
    .local v1, "e":Ljava/io/IOException;
    :try_start_4
    new-instance v2, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v2, v1}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .line 425
    .end local v1    # "e":Ljava/io/IOException;
    .end local v7    # "fileName":Ljava/lang/String;
    :cond_5
    :goto_2
    invoke-direct {p0, v0}, Landroidx/media3/datasource/cache/SimpleCache;->addSpan(Landroidx/media3/datasource/cache/SimpleCacheSpan;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 427
    :try_start_5
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->store()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 430
    nop

    .line 431
    :try_start_6
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 432
    monitor-exit p0

    return-void

    .line 428
    :catch_1
    move-exception v1

    .line 429
    .restart local v1    # "e":Ljava/io/IOException;
    :try_start_7
    new-instance v2, Landroidx/media3/datasource/cache/Cache$CacheException;

    invoke-direct {v2, v1}, Landroidx/media3/datasource/cache/Cache$CacheException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 396
    .end local v0    # "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .end local v1    # "e":Ljava/io/IOException;
    .end local v3    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local v4    # "contentLength":J
    .end local p1    # "file":Ljava/io/File;
    .end local p2    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getCacheSpace()J
    .locals 2

    monitor-enter p0

    .line 321
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 322
    iget-wide v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->totalSpace:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 320
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCachedBytes(Ljava/lang/String;JJ)J
    .locals 17
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J

    monitor-enter p0

    .line 476
    const-wide/16 v0, -0x1

    cmp-long v0, p4, v0

    if-nez v0, :cond_0

    const-wide v0, 0x7fffffffffffffffL

    goto :goto_0

    :cond_0
    add-long v0, p2, p4

    .line 477
    .local v0, "endPosition":J
    :goto_0
    const-wide/16 v7, 0x0

    cmp-long v2, v0, v7

    if-gez v2, :cond_1

    .line 479
    const-wide v0, 0x7fffffffffffffffL

    move-wide v9, v0

    goto :goto_1

    .line 477
    :cond_1
    move-wide v9, v0

    .line 481
    .end local v0    # "endPosition":J
    .local v9, "endPosition":J
    :goto_1
    move-wide/from16 v0, p2

    .line 482
    .local v0, "currentPosition":J
    const-wide/16 v2, 0x0

    move-wide v11, v0

    move-wide v13, v2

    .line 483
    .end local v0    # "currentPosition":J
    .local v11, "currentPosition":J
    .local v13, "cachedBytes":J
    :goto_2
    cmp-long v0, v11, v9

    if-gez v0, :cond_3

    .line 484
    sub-long v15, v9, v11

    .line 485
    .local v15, "maxRemainingLength":J
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-wide v3, v11

    move-wide v5, v15

    :try_start_0
    invoke-virtual/range {v1 .. v6}, Landroidx/media3/datasource/cache/SimpleCache;->getCachedLength(Ljava/lang/String;JJ)J

    move-result-wide v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 486
    .local v0, "blockLength":J
    cmp-long v2, v0, v7

    if-lez v2, :cond_2

    .line 487
    add-long/2addr v13, v0

    goto :goto_3

    .line 490
    :cond_2
    neg-long v0, v0

    .line 492
    :goto_3
    add-long/2addr v11, v0

    .line 493
    .end local v0    # "blockLength":J
    .end local v15    # "maxRemainingLength":J
    goto :goto_2

    .line 475
    .end local v9    # "endPosition":J
    .end local v11    # "currentPosition":J
    .end local v13    # "cachedBytes":J
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception v0

    move-object v1, v0

    monitor-exit p0

    throw v1

    .line 494
    .restart local v9    # "endPosition":J
    .restart local v11    # "currentPosition":J
    .restart local v13    # "cachedBytes":J
    .restart local p1    # "key":Ljava/lang/String;
    .restart local p2    # "position":J
    .restart local p4    # "length":J
    :cond_3
    monitor-exit p0

    return-wide v13
.end method

.method public declared-synchronized getCachedLength(Ljava/lang/String;JJ)J
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J

    monitor-enter p0

    .line 466
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 467
    const-wide/16 v0, -0x1

    cmp-long v0, p4, v0

    if-nez v0, :cond_1

    .line 468
    const-wide p4, 0x7fffffffffffffffL

    .line 470
    :cond_1
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 471
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    if-eqz v0, :cond_2

    invoke-virtual {v0, p2, p3, p4, p5}, Landroidx/media3/datasource/cache/CachedContent;->getCachedBytesLength(JJ)J

    move-result-wide v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_2
    neg-long v1, p4

    :goto_1
    monitor-exit p0

    return-wide v1

    .line 465
    .end local v0    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getCachedSpans(Ljava/lang/String;)Ljava/util/NavigableSet;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/NavigableSet<",
            "Landroidx/media3/datasource/cache/CacheSpan;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    .line 306
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 307
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 308
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CachedContent;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    goto :goto_1

    .line 310
    :cond_1
    new-instance v1, Ljava/util/TreeSet;

    invoke-virtual {v0}, Landroidx/media3/datasource/cache/CachedContent;->getSpans()Ljava/util/TreeSet;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    goto :goto_2

    .line 309
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_2
    :goto_1
    new-instance v1, Ljava/util/TreeSet;

    invoke-direct {v1}, Ljava/util/TreeSet;-><init>()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 308
    :goto_2
    monitor-exit p0

    return-object v1

    .line 305
    .end local v0    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local p1    # "key":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getContentMetadata(Ljava/lang/String;)Landroidx/media3/datasource/cache/ContentMetadata;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    monitor-enter p0

    .line 513
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 514
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->getContentMetadata(Ljava/lang/String;)Landroidx/media3/datasource/cache/ContentMetadata;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 512
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    .end local p1    # "key":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getKeys()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    monitor-enter p0

    .line 315
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 316
    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->getKeys()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 314
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUid()J
    .locals 2

    monitor-enter p0

    .line 256
    :try_start_0
    iget-wide v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->uid:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-wide v0

    .line 256
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isCached(Ljava/lang/String;JJ)Z
    .locals 5
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J

    monitor-enter p0

    .line 459
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-nez v0, :cond_0

    move v0, v1

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 460
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 461
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    if-eqz v0, :cond_1

    invoke-virtual {v0, p2, p3, p4, p5}, Landroidx/media3/datasource/cache/CachedContent;->getCachedBytesLength(JJ)J

    move-result-wide v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v3, v3, p4

    if-ltz v3, :cond_1

    goto :goto_1

    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    move v1, v2

    :goto_1
    monitor-exit p0

    return v1

    .line 458
    .end local v0    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized release()V
    .locals 4

    monitor-enter p0

    .line 261
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    if-eqz v0, :cond_0

    .line 262
    monitor-exit p0

    return-void

    .line 264
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 265
    invoke-direct {p0}, Landroidx/media3/datasource/cache/SimpleCache;->removeStaleSpans()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 267
    const/4 v0, 0x1

    :try_start_2
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->store()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 271
    :try_start_3
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v1}, Landroidx/media3/datasource/cache/SimpleCache;->unlockFolder(Ljava/io/File;)V

    .line 272
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 273
    goto :goto_0

    .line 271
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :catchall_0
    move-exception v1

    goto :goto_1

    .line 268
    :catch_0
    move-exception v1

    .line 269
    .local v1, "e":Ljava/io/IOException;
    :try_start_4
    const-string v2, "SimpleCache"

    const-string v3, "Storing index file failed"

    invoke-static {v2, v3, v1}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 271
    .end local v1    # "e":Ljava/io/IOException;
    :try_start_5
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v1}, Landroidx/media3/datasource/cache/SimpleCache;->unlockFolder(Ljava/io/File;)V

    .line 272
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 273
    nop

    .line 274
    :goto_0
    monitor-exit p0

    return-void

    .line 271
    :goto_1
    :try_start_6
    iget-object v2, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v2}, Landroidx/media3/datasource/cache/SimpleCache;->unlockFolder(Ljava/io/File;)V

    .line 272
    iput-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    .line 273
    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 260
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized releaseHoleSpan(Landroidx/media3/datasource/cache/CacheSpan;)V
    .locals 3
    .param p1, "holeSpan"    # Landroidx/media3/datasource/cache/CacheSpan;

    monitor-enter p0

    .line 436
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 437
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v1, p1, Landroidx/media3/datasource/cache/CacheSpan;->key:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/datasource/cache/CachedContent;

    .line 438
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    iget-wide v1, p1, Landroidx/media3/datasource/cache/CacheSpan;->position:J

    invoke-virtual {v0, v1, v2}, Landroidx/media3/datasource/cache/CachedContent;->unlockRange(J)V

    .line 439
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    iget-object v2, v0, Landroidx/media3/datasource/cache/CachedContent;->key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroidx/media3/datasource/cache/CachedContentIndex;->maybeRemove(Ljava/lang/String;)V

    .line 440
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 441
    monitor-exit p0

    return-void

    .line 435
    .end local v0    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    .end local p1    # "holeSpan":Landroidx/media3/datasource/cache/CacheSpan;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeListener(Ljava/lang/String;Landroidx/media3/datasource/cache/Cache$Listener;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "listener"    # Landroidx/media3/datasource/cache/Cache$Listener;

    monitor-enter p0

    .line 292
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 293
    monitor-exit p0

    return-void

    .line 295
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 296
    .local v0, "listenersForKey":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    if-eqz v0, :cond_1

    .line 297
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 298
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 299
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->listeners:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 302
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    monitor-exit p0

    return-void

    .line 291
    .end local v0    # "listenersForKey":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/datasource/cache/Cache$Listener;>;"
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "listener":Landroidx/media3/datasource/cache/Cache$Listener;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeResource(Ljava/lang/String;)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;

    monitor-enter p0

    .line 445
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 446
    invoke-virtual {p0, p1}, Landroidx/media3/datasource/cache/SimpleCache;->getCachedSpans(Ljava/lang/String;)Ljava/util/NavigableSet;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/NavigableSet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/datasource/cache/CacheSpan;

    .line 447
    .local v1, "span":Landroidx/media3/datasource/cache/CacheSpan;
    invoke-direct {p0, v1}, Landroidx/media3/datasource/cache/SimpleCache;->removeSpanInternal(Landroidx/media3/datasource/cache/CacheSpan;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 448
    .end local v1    # "span":Landroidx/media3/datasource/cache/CacheSpan;
    goto :goto_1

    .line 449
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    monitor-exit p0

    return-void

    .line 444
    .end local p1    # "key":Ljava/lang/String;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeSpan(Landroidx/media3/datasource/cache/CacheSpan;)V
    .locals 1
    .param p1, "span"    # Landroidx/media3/datasource/cache/CacheSpan;

    monitor-enter p0

    .line 453
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 454
    invoke-direct {p0, p1}, Landroidx/media3/datasource/cache/SimpleCache;->removeSpanInternal(Landroidx/media3/datasource/cache/CacheSpan;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 455
    monitor-exit p0

    return-void

    .line 452
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    .end local p1    # "span":Landroidx/media3/datasource/cache/CacheSpan;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized startFile(Ljava/lang/String;JJ)Ljava/io/File;
    .locals 8
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 372
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 373
    invoke-virtual {p0}, Landroidx/media3/datasource/cache/SimpleCache;->checkInitialization()V

    .line 375
    iget-object v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v0, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->get(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v0

    .line 376
    .local v0, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 377
    invoke-virtual {v0, p2, p3, p4, p5}, Landroidx/media3/datasource/cache/CachedContent;->isFullyLocked(JJ)Z

    move-result v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 378
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 381
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    invoke-static {v1}, Landroidx/media3/datasource/cache/SimpleCache;->createCacheDirectories(Ljava/io/File;)V

    .line 382
    invoke-direct {p0}, Landroidx/media3/datasource/cache/SimpleCache;->removeStaleSpans()V

    .line 384
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->evictor:Landroidx/media3/datasource/cache/CacheEvictor;

    move-object v2, p0

    move-object v3, p1

    move-wide v4, p2

    move-wide v6, p4

    invoke-interface/range {v1 .. v7}, Landroidx/media3/datasource/cache/CacheEvictor;->onStartFile(Landroidx/media3/datasource/cache/Cache;Ljava/lang/String;JJ)V

    .line 386
    new-instance v2, Ljava/io/File;

    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->cacheDir:Ljava/io/File;

    iget-object v3, p0, Landroidx/media3/datasource/cache/SimpleCache;->random:Ljava/util/Random;

    const/16 v4, 0xa

    invoke-virtual {v3, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v1, v3}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 387
    .local v2, "cacheSubDir":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2

    .line 388
    invoke-static {v2}, Landroidx/media3/datasource/cache/SimpleCache;->createCacheDirectories(Ljava/io/File;)V

    .line 390
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    .line 391
    .local v6, "lastTouchTimestamp":J
    iget v3, v0, Landroidx/media3/datasource/cache/CachedContent;->id:I

    move-wide v4, p2

    invoke-static/range {v2 .. v7}, Landroidx/media3/datasource/cache/SimpleCacheSpan;->getCacheFile(Ljava/io/File;IJJ)Ljava/io/File;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 371
    .end local v0    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local v2    # "cacheSubDir":Ljava/io/File;
    .end local v6    # "lastTouchTimestamp":J
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized startReadWrite(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/CacheSpan;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;,
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 328
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 329
    invoke-virtual {p0}, Landroidx/media3/datasource/cache/SimpleCache;->checkInitialization()V

    .line 332
    :goto_1
    invoke-virtual/range {p0 .. p5}, Landroidx/media3/datasource/cache/SimpleCache;->startReadWriteNonBlocking(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/CacheSpan;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 333
    .local v0, "span":Landroidx/media3/datasource/cache/CacheSpan;
    if-eqz v0, :cond_1

    .line 334
    monitor-exit p0

    return-object v0

    .line 341
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 343
    .end local v0    # "span":Landroidx/media3/datasource/cache/CacheSpan;
    goto :goto_1

    .line 327
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized startReadWriteNonBlocking(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/CacheSpan;
    .locals 4
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "position"    # J
    .param p4, "length"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/datasource/cache/Cache$CacheException;
        }
    .end annotation

    monitor-enter p0

    .line 350
    :try_start_0
    iget-boolean v0, p0, Landroidx/media3/datasource/cache/SimpleCache;->released:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 351
    invoke-virtual {p0}, Landroidx/media3/datasource/cache/SimpleCache;->checkInitialization()V

    .line 353
    invoke-direct/range {p0 .. p5}, Landroidx/media3/datasource/cache/SimpleCache;->getSpan(Ljava/lang/String;JJ)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v0

    .line 355
    .local v0, "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    iget-boolean v1, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->isCached:Z

    if-eqz v1, :cond_1

    .line 357
    invoke-direct {p0, p1, v0}, Landroidx/media3/datasource/cache/SimpleCache;->touchSpan(Ljava/lang/String;Landroidx/media3/datasource/cache/SimpleCacheSpan;)Landroidx/media3/datasource/cache/SimpleCacheSpan;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 360
    .end local p0    # "this":Landroidx/media3/datasource/cache/SimpleCache;
    :cond_1
    :try_start_1
    iget-object v1, p0, Landroidx/media3/datasource/cache/SimpleCache;->contentIndex:Landroidx/media3/datasource/cache/CachedContentIndex;

    invoke-virtual {v1, p1}, Landroidx/media3/datasource/cache/CachedContentIndex;->getOrAdd(Ljava/lang/String;)Landroidx/media3/datasource/cache/CachedContent;

    move-result-object v1

    .line 361
    .local v1, "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    iget-wide v2, v0, Landroidx/media3/datasource/cache/SimpleCacheSpan;->length:J

    invoke-virtual {v1, p2, p3, v2, v3}, Landroidx/media3/datasource/cache/CachedContent;->lockRange(JJ)Z

    move-result v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v2, :cond_2

    .line 363
    monitor-exit p0

    return-object v0

    .line 367
    :cond_2
    monitor-exit p0

    const/4 v2, 0x0

    return-object v2

    .line 349
    .end local v0    # "span":Landroidx/media3/datasource/cache/SimpleCacheSpan;
    .end local v1    # "cachedContent":Landroidx/media3/datasource/cache/CachedContent;
    .end local p1    # "key":Ljava/lang/String;
    .end local p2    # "position":J
    .end local p4    # "length":J
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
