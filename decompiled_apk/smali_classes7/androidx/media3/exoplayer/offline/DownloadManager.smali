.class public final Landroidx/media3/exoplayer/offline/DownloadManager;
.super Ljava/lang/Object;
.source "DownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;,
        Landroidx/media3/exoplayer/offline/DownloadManager$Listener;,
        Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;,
        Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    }
.end annotation


# static fields
.field public static final DEFAULT_MAX_PARALLEL_DOWNLOADS:I = 0x3

.field public static final DEFAULT_MIN_RETRY_COUNT:I = 0x5

.field public static final DEFAULT_REQUIREMENTS:Landroidx/media3/exoplayer/scheduler/Requirements;

.field private static final MSG_ADD_DOWNLOAD:I = 0x6

.field private static final MSG_CONTENT_LENGTH_CHANGED:I = 0xa

.field private static final MSG_DOWNLOAD_UPDATE:I = 0x2

.field private static final MSG_INITIALIZE:I = 0x0

.field private static final MSG_INITIALIZED:I = 0x0

.field private static final MSG_PROCESSED:I = 0x1

.field private static final MSG_RELEASE:I = 0xc

.field private static final MSG_REMOVE_ALL_DOWNLOADS:I = 0x8

.field private static final MSG_REMOVE_DOWNLOAD:I = 0x7

.field private static final MSG_SET_DOWNLOADS_PAUSED:I = 0x1

.field private static final MSG_SET_MAX_PARALLEL_DOWNLOADS:I = 0x4

.field private static final MSG_SET_MIN_RETRY_COUNT:I = 0x5

.field private static final MSG_SET_NOT_MET_REQUIREMENTS:I = 0x2

.field private static final MSG_SET_STOP_REASON:I = 0x3

.field private static final MSG_TASK_STOPPED:I = 0x9

.field private static final MSG_UPDATE_PROGRESS:I = 0xb

.field private static final TAG:Ljava/lang/String; = "DownloadManager"


# instance fields
.field private activeTaskCount:I

.field private final applicationHandler:Landroid/os/Handler;

.field private final context:Landroid/content/Context;

.field private final downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

.field private downloads:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/Download;",
            ">;"
        }
    .end annotation
.end field

.field private downloadsPaused:Z

.field private initialized:Z

.field private final internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

.field private final listeners:Ljava/util/concurrent/CopyOnWriteArraySet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArraySet<",
            "Landroidx/media3/exoplayer/offline/DownloadManager$Listener;",
            ">;"
        }
    .end annotation
.end field

.field private maxParallelDownloads:I

.field private minRetryCount:I

.field private notMetRequirements:I

.field private pendingMessages:I

.field private final requirementsListener:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;

.field private requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

.field private waitingForRequirements:Z


# direct methods
.method public static synthetic $r8$lambda$BgKJ2Nse_hhWOJ980vXMskcdoes(Landroidx/media3/exoplayer/offline/DownloadManager;Landroid/os/Message;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/DownloadManager;->handleMainMessage(Landroid/os/Message;)Z

    move-result p0

    return p0
.end method

.method public static synthetic $r8$lambda$ikpIoLH372to4xbvRelHGL5TPQ4(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;I)V
    .locals 0

    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/offline/DownloadManager;->onRequirementsStateChanged(Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;I)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    .line 156
    new-instance v0, Landroidx/media3/exoplayer/scheduler/Requirements;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/scheduler/Requirements;-><init>(I)V

    sput-object v0, Landroidx/media3/exoplayer/offline/DownloadManager;->DEFAULT_REQUIREMENTS:Landroidx/media3/exoplayer/scheduler/Requirements;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/database/DatabaseProvider;Landroidx/media3/datasource/cache/Cache;Landroidx/media3/datasource/DataSource$Factory;Ljava/util/concurrent/Executor;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "databaseProvider"    # Landroidx/media3/database/DatabaseProvider;
    .param p3, "cache"    # Landroidx/media3/datasource/cache/Cache;
    .param p4, "upstreamFactory"    # Landroidx/media3/datasource/DataSource$Factory;
    .param p5, "executor"    # Ljava/util/concurrent/Executor;

    .line 218
    new-instance v0, Landroidx/media3/exoplayer/offline/DefaultDownloadIndex;

    invoke-direct {v0, p2}, Landroidx/media3/exoplayer/offline/DefaultDownloadIndex;-><init>(Landroidx/media3/database/DatabaseProvider;)V

    new-instance v1, Landroidx/media3/exoplayer/offline/DefaultDownloaderFactory;

    new-instance v2, Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    invoke-direct {v2}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;-><init>()V

    .line 223
    invoke-virtual {v2, p3}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->setCache(Landroidx/media3/datasource/cache/Cache;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    move-result-object v2

    .line 224
    invoke-virtual {v2, p4}, Landroidx/media3/datasource/cache/CacheDataSource$Factory;->setUpstreamDataSourceFactory(Landroidx/media3/datasource/DataSource$Factory;)Landroidx/media3/datasource/cache/CacheDataSource$Factory;

    move-result-object v2

    invoke-direct {v1, v2, p5}, Landroidx/media3/exoplayer/offline/DefaultDownloaderFactory;-><init>(Landroidx/media3/datasource/cache/CacheDataSource$Factory;Ljava/util/concurrent/Executor;)V

    .line 218
    invoke-direct {p0, p1, v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/offline/WritableDownloadIndex;Landroidx/media3/exoplayer/offline/DownloaderFactory;)V

    .line 226
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/offline/WritableDownloadIndex;Landroidx/media3/exoplayer/offline/DownloaderFactory;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "downloadIndex"    # Landroidx/media3/exoplayer/offline/WritableDownloadIndex;
    .param p3, "downloaderFactory"    # Landroidx/media3/exoplayer/offline/DownloaderFactory;

    .line 236
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 237
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->context:Landroid/content/Context;

    .line 238
    iput-object p2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    .line 240
    const/4 v0, 0x3

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->maxParallelDownloads:I

    .line 241
    const/4 v0, 0x5

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->minRetryCount:I

    .line 242
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    .line 243
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    .line 244
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v1}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    .line 247
    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadManager$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/offline/DownloadManager$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/offline/DownloadManager;)V

    invoke-static {v1}, Landroidx/media3/common/util/Util;->createHandlerForCurrentOrMainLooper(Landroid/os/Handler$Callback;)Landroid/os/Handler;

    move-result-object v1

    .line 248
    .local v1, "mainHandler":Landroid/os/Handler;
    iput-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->applicationHandler:Landroid/os/Handler;

    .line 249
    new-instance v3, Landroid/os/HandlerThread;

    const-string v2, "ExoPlayer:DownloadManager"

    invoke-direct {v3, v2}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 250
    .local v3, "internalThread":Landroid/os/HandlerThread;
    invoke-virtual {v3}, Landroid/os/HandlerThread;->start()V

    .line 251
    new-instance v10, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    iget v7, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->maxParallelDownloads:I

    iget v8, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->minRetryCount:I

    iget-boolean v9, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    move-object v2, v10

    move-object v4, p2

    move-object v5, p3

    move-object v6, v1

    invoke-direct/range {v2 .. v9}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;-><init>(Landroid/os/HandlerThread;Landroidx/media3/exoplayer/offline/WritableDownloadIndex;Landroidx/media3/exoplayer/offline/DownloaderFactory;Landroid/os/Handler;IIZ)V

    iput-object v10, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 262
    new-instance v2, Landroidx/media3/exoplayer/offline/DownloadManager$$ExternalSyntheticLambda1;

    invoke-direct {v2, p0}, Landroidx/media3/exoplayer/offline/DownloadManager$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/exoplayer/offline/DownloadManager;)V

    .line 263
    .local v2, "requirementsListener":Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;
    iput-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsListener:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;

    .line 264
    new-instance v4, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    sget-object v5, Landroidx/media3/exoplayer/offline/DownloadManager;->DEFAULT_REQUIREMENTS:Landroidx/media3/exoplayer/scheduler/Requirements;

    invoke-direct {v4, p1, v2, v5}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;Landroidx/media3/exoplayer/scheduler/Requirements;)V

    iput-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    .line 266
    invoke-virtual {v4}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->start()I

    move-result v4

    iput v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    .line 268
    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 269
    nop

    .line 270
    const/4 v0, 0x0

    invoke-virtual {v10, v0, v4, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    .line 271
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 272
    return-void
.end method

.method private handleMainMessage(Landroid/os/Message;)Z
    .locals 2
    .param p1, "message"    # Landroid/os/Message;

    .line 595
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 610
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 601
    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    .line 602
    .local v0, "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->onDownloadUpdate(Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;)V

    .line 603
    goto :goto_0

    .line 605
    .end local v0    # "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    :pswitch_1
    iget v0, p1, Landroid/os/Message;->arg1:I

    .line 606
    .local v0, "processedMessageCount":I
    iget v1, p1, Landroid/os/Message;->arg2:I

    .line 607
    .local v1, "activeTaskCount":I
    invoke-direct {p0, v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager;->onMessageProcessed(II)V

    .line 608
    goto :goto_0

    .line 597
    .end local v0    # "processedMessageCount":I
    .end local v1    # "activeTaskCount":I
    :pswitch_2
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    .line 598
    .local v0, "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->onInitialized(Ljava/util/List;)V

    .line 599
    nop

    .line 612
    .end local v0    # "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    :goto_0
    const/4 v0, 0x1

    return v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method static mergeRequest(Landroidx/media3/exoplayer/offline/Download;Landroidx/media3/exoplayer/offline/DownloadRequest;IJ)Landroidx/media3/exoplayer/offline/Download;
    .locals 16
    .param p0, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p1, "request"    # Landroidx/media3/exoplayer/offline/DownloadRequest;
    .param p2, "stopReason"    # I
    .param p3, "nowMs"    # J

    .line 657
    move-object/from16 v0, p0

    iget v1, v0, Landroidx/media3/exoplayer/offline/Download;->state:I

    .line 662
    .local v1, "state":I
    const/4 v2, 0x5

    if-eq v1, v2, :cond_1

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/exoplayer/offline/Download;->isTerminalState()Z

    move-result v3

    if-eqz v3, :cond_0

    goto :goto_0

    :cond_0
    iget-wide v3, v0, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    move-wide v8, v3

    goto :goto_1

    :cond_1
    :goto_0
    move-wide/from16 v8, p3

    .line 663
    .local v8, "startTimeMs":J
    :goto_1
    if-eq v1, v2, :cond_4

    const/4 v2, 0x7

    if-ne v1, v2, :cond_2

    goto :goto_2

    .line 665
    :cond_2
    if-eqz p2, :cond_3

    .line 666
    const/4 v1, 0x1

    goto :goto_3

    .line 668
    :cond_3
    const/4 v1, 0x0

    goto :goto_3

    .line 664
    :cond_4
    :goto_2
    const/4 v1, 0x7

    .line 670
    :goto_3
    new-instance v2, Landroidx/media3/exoplayer/offline/Download;

    iget-object v3, v0, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    .line 671
    move-object/from16 v4, p1

    invoke-virtual {v3, v4}, Landroidx/media3/exoplayer/offline/DownloadRequest;->copyWithMergedRequest(Landroidx/media3/exoplayer/offline/DownloadRequest;)Landroidx/media3/exoplayer/offline/DownloadRequest;

    move-result-object v6

    const-wide/16 v12, -0x1

    const/4 v15, 0x0

    move-object v5, v2

    move v7, v1

    move-wide/from16 v10, p3

    move/from16 v14, p2

    invoke-direct/range {v5 .. v15}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJII)V

    .line 670
    return-object v2
.end method

.method private notifyWaitingForRequirementsChanged()V
    .locals 3

    .line 586
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 587
    .local v1, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    iget-boolean v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->waitingForRequirements:Z

    invoke-interface {v1, p0, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onWaitingForRequirementsChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Z)V

    .line 588
    .end local v1    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    .line 589
    :cond_0
    return-void
.end method

.method private onDownloadUpdate(Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;)V
    .locals 5
    .param p1, "update"    # Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    .line 628
    iget-object v0, p1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;->downloads:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    .line 629
    iget-object v0, p1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;->download:Landroidx/media3/exoplayer/offline/Download;

    .line 630
    .local v0, "updatedDownload":Landroidx/media3/exoplayer/offline/Download;
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->updateWaitingForRequirements()Z

    move-result v1

    .line 631
    .local v1, "waitingForRequirementsChanged":Z
    iget-boolean v2, p1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;->isRemove:Z

    if-eqz v2, :cond_1

    .line 632
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v2}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 633
    .local v3, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    invoke-interface {v3, p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onDownloadRemoved(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/offline/Download;)V

    .line 634
    .end local v3    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    :cond_0
    goto :goto_2

    .line 636
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v2}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 637
    .restart local v3    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    iget-object v4, p1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;->finalException:Ljava/lang/Exception;

    invoke-interface {v3, p0, v0, v4}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onDownloadChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/offline/Download;Ljava/lang/Exception;)V

    .line 638
    .end local v3    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_1

    .line 640
    :cond_2
    :goto_2
    if-eqz v1, :cond_3

    .line 641
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->notifyWaitingForRequirementsChanged()V

    .line 643
    :cond_3
    return-void
.end method

.method private onInitialized(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/Download;",
            ">;)V"
        }
    .end annotation

    .line 616
    .local p1, "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->initialized:Z

    .line 617
    invoke-static {p1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    .line 618
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->updateWaitingForRequirements()Z

    move-result v0

    .line 619
    .local v0, "waitingForRequirementsChanged":Z
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 620
    .local v2, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    invoke-interface {v2, p0}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onInitialized(Landroidx/media3/exoplayer/offline/DownloadManager;)V

    .line 621
    .end local v2    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    .line 622
    :cond_0
    if-eqz v0, :cond_1

    .line 623
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->notifyWaitingForRequirementsChanged()V

    .line 625
    :cond_1
    return-void
.end method

.method private onMessageProcessed(II)V
    .locals 2
    .param p1, "processedMessageCount"    # I
    .param p2, "activeTaskCount"    # I

    .line 646
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    sub-int/2addr v0, p1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 647
    iput p2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->activeTaskCount:I

    .line 648
    invoke-virtual {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->isIdle()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 649
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 650
    .local v1, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    invoke-interface {v1, p0}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onIdle(Landroidx/media3/exoplayer/offline/DownloadManager;)V

    .line 651
    .end local v1    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    .line 653
    :cond_0
    return-void
.end method

.method private onRequirementsStateChanged(Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;I)V
    .locals 4
    .param p1, "requirementsWatcher"    # Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;
    .param p2, "notMetRequirements"    # I

    .line 553
    invoke-virtual {p1}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->getRequirements()Landroidx/media3/exoplayer/scheduler/Requirements;

    move-result-object v0

    .line 554
    .local v0, "requirements":Landroidx/media3/exoplayer/scheduler/Requirements;
    iget v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    if-eq v1, p2, :cond_0

    .line 555
    iput p2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    .line 556
    iget v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 557
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 558
    const/4 v2, 0x2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p2, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v1

    .line 559
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 561
    :cond_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->updateWaitingForRequirements()Z

    move-result v1

    .line 562
    .local v1, "waitingForRequirementsChanged":Z
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v2}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 563
    .local v3, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    invoke-interface {v3, p0, v0, p2}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onRequirementsStateChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/scheduler/Requirements;I)V

    .line 564
    .end local v3    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    .line 565
    :cond_1
    if-eqz v1, :cond_2

    .line 566
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->notifyWaitingForRequirementsChanged()V

    .line 568
    :cond_2
    return-void
.end method

.method private setDownloadsPaused(Z)V
    .locals 3
    .param p1, "downloadsPaused"    # Z

    .line 533
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    if-ne v0, p1, :cond_0

    .line 534
    return-void

    .line 536
    :cond_0
    iput-boolean p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    .line 537
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    const/4 v1, 0x1

    add-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 538
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 539
    const/4 v2, 0x0

    invoke-virtual {v0, v1, p1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    .line 540
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 541
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->updateWaitingForRequirements()Z

    move-result v0

    .line 542
    .local v0, "waitingForRequirementsChanged":Z
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArraySet;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 543
    .local v2, "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    invoke-interface {v2, p0, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Listener;->onDownloadsPausedChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Z)V

    .line 544
    .end local v2    # "listener":Landroidx/media3/exoplayer/offline/DownloadManager$Listener;
    goto :goto_0

    .line 545
    :cond_1
    if-eqz v0, :cond_2

    .line 546
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->notifyWaitingForRequirementsChanged()V

    .line 548
    :cond_2
    return-void
.end method

.method private updateWaitingForRequirements()Z
    .locals 3

    .line 571
    const/4 v0, 0x0

    .line 572
    .local v0, "waitingForRequirements":Z
    iget-boolean v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    if-nez v1, :cond_1

    iget v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    if-eqz v1, :cond_1

    .line 573
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 574
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/Download;

    iget v2, v2, Landroidx/media3/exoplayer/offline/Download;->state:I

    if-nez v2, :cond_0

    .line 575
    const/4 v0, 0x1

    .line 576
    goto :goto_1

    .line 573
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 580
    .end local v1    # "i":I
    :cond_1
    :goto_1
    iget-boolean v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->waitingForRequirements:Z

    if-eq v1, v0, :cond_2

    const/4 v1, 0x1

    goto :goto_2

    :cond_2
    const/4 v1, 0x0

    .line 581
    .local v1, "waitingForRequirementsChanged":Z
    :goto_2
    iput-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->waitingForRequirements:Z

    .line 582
    return v1
.end method


# virtual methods
.method public addDownload(Landroidx/media3/exoplayer/offline/DownloadRequest;)V
    .locals 1
    .param p1, "request"    # Landroidx/media3/exoplayer/offline/DownloadRequest;

    .line 465
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->addDownload(Landroidx/media3/exoplayer/offline/DownloadRequest;I)V

    .line 466
    return-void
.end method

.method public addDownload(Landroidx/media3/exoplayer/offline/DownloadRequest;I)V
    .locals 3
    .param p1, "request"    # Landroidx/media3/exoplayer/offline/DownloadRequest;
    .param p2, "stopReason"    # I

    .line 476
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 477
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 478
    const/4 v1, 0x6

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p2, v2, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 479
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 480
    return-void
.end method

.method public addListener(Landroidx/media3/exoplayer/offline/DownloadManager$Listener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 316
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->add(Ljava/lang/Object;)Z

    .line 318
    return-void
.end method

.method public getApplicationLooper()Landroid/os/Looper;
    .locals 1

    .line 279
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->applicationHandler:Landroid/os/Handler;

    invoke-virtual {v0}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentDownloads()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/Download;",
            ">;"
        }
    .end annotation

    .line 417
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    return-object v0
.end method

.method public getDownloadIndex()Landroidx/media3/exoplayer/offline/DownloadIndex;
    .locals 1

    .line 408
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    return-object v0
.end method

.method public getDownloadsPaused()Z
    .locals 1

    .line 422
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloadsPaused:Z

    return v0
.end method

.method public getMaxParallelDownloads()I
    .locals 1

    .line 360
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->maxParallelDownloads:I

    return v0
.end method

.method public getMinRetryCount()I
    .locals 1

    .line 385
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->minRetryCount:I

    return v0
.end method

.method public getNotMetRequirements()I
    .locals 1

    .line 340
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    return v0
.end method

.method public getRequirements()Landroidx/media3/exoplayer/scheduler/Requirements;
    .locals 1

    .line 331
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->getRequirements()Landroidx/media3/exoplayer/scheduler/Requirements;

    move-result-object v0

    return-object v0
.end method

.method public isIdle()Z
    .locals 1

    .line 293
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->activeTaskCount:I

    if-nez v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isInitialized()Z
    .locals 1

    .line 284
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->initialized:Z

    return v0
.end method

.method public isWaitingForRequirements()Z
    .locals 1

    .line 307
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->waitingForRequirements:Z

    return v0
.end method

.method public pauseDownloads()V
    .locals 1

    .line 441
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->setDownloadsPaused(Z)V

    .line 442
    return-void
.end method

.method public release()V
    .locals 4

    .line 503
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    monitor-enter v0

    .line 504
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    iget-boolean v1, v1, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->released:Z

    if-eqz v1, :cond_0

    .line 505
    monitor-exit v0

    return-void

    .line 507
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    const/16 v2, 0xc

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->sendEmptyMessage(I)Z

    .line 508
    const/4 v1, 0x0

    .line 509
    .local v1, "wasInterrupted":Z
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    iget-boolean v2, v2, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->released:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v2, :cond_1

    .line 511
    :try_start_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    invoke-virtual {v2}, Ljava/lang/Object;->wait()V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 512
    :catch_0
    move-exception v2

    .line 513
    .local v2, "e":Ljava/lang/InterruptedException;
    const/4 v1, 0x1

    .line 514
    .end local v2    # "e":Ljava/lang/InterruptedException;
    :goto_1
    goto :goto_0

    .line 516
    :cond_1
    if-eqz v1, :cond_2

    .line 518
    :try_start_2
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->interrupt()V

    .line 520
    :cond_2
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->applicationHandler:Landroid/os/Handler;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 521
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->stop()V

    .line 523
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->downloads:Ljava/util/List;

    .line 524
    const/4 v2, 0x0

    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 525
    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->activeTaskCount:I

    .line 526
    iput-boolean v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->initialized:Z

    .line 527
    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->notMetRequirements:I

    .line 528
    iput-boolean v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->waitingForRequirements:Z

    .line 529
    .end local v1    # "wasInterrupted":Z
    monitor-exit v0

    .line 530
    return-void

    .line 529
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1
.end method

.method public removeAllDownloads()V
    .locals 2

    .line 494
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 495
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 496
    return-void
.end method

.method public removeDownload(Ljava/lang/String;)V
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .line 488
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 489
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    const/4 v1, 0x7

    invoke-virtual {v0, v1, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 490
    return-void
.end method

.method public removeListener(Landroidx/media3/exoplayer/offline/DownloadManager$Listener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/exoplayer/offline/DownloadManager$Listener;

    .line 326
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->listeners:Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArraySet;->remove(Ljava/lang/Object;)Z

    .line 327
    return-void
.end method

.method public resumeDownloads()V
    .locals 1

    .line 433
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->setDownloadsPaused(Z)V

    .line 434
    return-void
.end method

.method public setMaxParallelDownloads(I)V
    .locals 3
    .param p1, "maxParallelDownloads"    # I

    .line 369
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-lez p1, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 370
    iget v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->maxParallelDownloads:I

    if-ne v2, p1, :cond_1

    .line 371
    return-void

    .line 373
    :cond_1
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->maxParallelDownloads:I

    .line 374
    iget v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/2addr v2, v0

    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 375
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 376
    const/4 v2, 0x4

    invoke-virtual {v0, v2, p1, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    .line 377
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 378
    return-void
.end method

.method public setMinRetryCount(I)V
    .locals 3
    .param p1, "minRetryCount"    # I

    .line 395
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ltz p1, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 396
    iget v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->minRetryCount:I

    if-ne v2, p1, :cond_1

    .line 397
    return-void

    .line 399
    :cond_1
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->minRetryCount:I

    .line 400
    iget v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/2addr v2, v0

    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 401
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 402
    const/4 v2, 0x5

    invoke-virtual {v0, v2, p1, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    .line 403
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 404
    return-void
.end method

.method public setRequirements(Landroidx/media3/exoplayer/scheduler/Requirements;)V
    .locals 3
    .param p1, "requirements"    # Landroidx/media3/exoplayer/scheduler/Requirements;

    .line 349
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->getRequirements()Landroidx/media3/exoplayer/scheduler/Requirements;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/scheduler/Requirements;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 350
    return-void

    .line 352
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->stop()V

    .line 353
    new-instance v0, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->context:Landroid/content/Context;

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsListener:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;

    invoke-direct {v0, v1, v2, p1}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/scheduler/RequirementsWatcher$Listener;Landroidx/media3/exoplayer/scheduler/Requirements;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    .line 354
    invoke-virtual {v0}, Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;->start()I

    move-result v0

    .line 355
    .local v0, "notMetRequirements":I
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->requirementsWatcher:Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;

    invoke-direct {p0, v1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->onRequirementsStateChanged(Landroidx/media3/exoplayer/scheduler/RequirementsWatcher;I)V

    .line 356
    return-void
.end method

.method public setStopReason(Ljava/lang/String;I)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "stopReason"    # I

    .line 453
    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->pendingMessages:I

    .line 454
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager;->internalHandler:Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;

    .line 455
    const/4 v1, 0x3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p2, v2, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 456
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 457
    return-void
.end method
