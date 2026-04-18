.class final Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;
.super Landroid/os/Handler;
.source "DownloadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/offline/DownloadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "InternalHandler"
.end annotation


# static fields
.field private static final UPDATE_PROGRESS_INTERVAL_MS:I = 0x1388


# instance fields
.field private activeDownloadTaskCount:I

.field private final activeTasks:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Ljava/lang/String;",
            "Landroidx/media3/exoplayer/offline/DownloadManager$Task;",
            ">;"
        }
    .end annotation
.end field

.field private final downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

.field private final downloaderFactory:Landroidx/media3/exoplayer/offline/DownloaderFactory;

.field private final downloads:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroidx/media3/exoplayer/offline/Download;",
            ">;"
        }
    .end annotation
.end field

.field private downloadsPaused:Z

.field private hasActiveRemoveTask:Z

.field private final mainHandler:Landroid/os/Handler;

.field private maxParallelDownloads:I

.field private minRetryCount:I

.field private notMetRequirements:I

.field public released:Z

.field private final thread:Landroid/os/HandlerThread;


# direct methods
.method public static synthetic $r8$lambda$Q3DB9u8Xelz3Rx9X4s71Ymag7Ik(Landroidx/media3/exoplayer/offline/Download;Landroidx/media3/exoplayer/offline/Download;)I
    .locals 0

    invoke-static {p0, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->compareStartTimes(Landroidx/media3/exoplayer/offline/Download;Landroidx/media3/exoplayer/offline/Download;)I

    move-result p0

    return p0
.end method

.method public constructor <init>(Landroid/os/HandlerThread;Landroidx/media3/exoplayer/offline/WritableDownloadIndex;Landroidx/media3/exoplayer/offline/DownloaderFactory;Landroid/os/Handler;IIZ)V
    .locals 1
    .param p1, "thread"    # Landroid/os/HandlerThread;
    .param p2, "downloadIndex"    # Landroidx/media3/exoplayer/offline/WritableDownloadIndex;
    .param p3, "downloaderFactory"    # Landroidx/media3/exoplayer/offline/DownloaderFactory;
    .param p4, "mainHandler"    # Landroid/os/Handler;
    .param p5, "maxParallelDownloads"    # I
    .param p6, "minRetryCount"    # I
    .param p7, "downloadsPaused"    # Z

    .line 708
    invoke-virtual {p1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 709
    iput-object p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->thread:Landroid/os/HandlerThread;

    .line 710
    iput-object p2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    .line 711
    iput-object p3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloaderFactory:Landroidx/media3/exoplayer/offline/DownloaderFactory;

    .line 712
    iput-object p4, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    .line 713
    iput p5, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->maxParallelDownloads:I

    .line 714
    iput p6, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->minRetryCount:I

    .line 715
    iput-boolean p7, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadsPaused:Z

    .line 716
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    .line 717
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    .line 718
    return-void
.end method

.method private addDownload(Landroidx/media3/exoplayer/offline/DownloadRequest;I)V
    .locals 19
    .param p1, "request"    # Landroidx/media3/exoplayer/offline/DownloadRequest;
    .param p2, "stopReason"    # I

    .line 878
    move-object/from16 v0, p0

    move-object/from16 v12, p1

    move/from16 v13, p2

    iget-object v1, v12, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v14

    .line 879
    .local v14, "download":Landroidx/media3/exoplayer/offline/Download;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    .line 880
    .local v10, "nowMs":J
    if-eqz v14, :cond_0

    .line 881
    invoke-static {v14, v12, v13, v10, v11}, Landroidx/media3/exoplayer/offline/DownloadManager;->mergeRequest(Landroidx/media3/exoplayer/offline/Download;Landroidx/media3/exoplayer/offline/DownloadRequest;IJ)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v1

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;

    move-wide/from16 v17, v10

    goto :goto_1

    .line 883
    :cond_0
    new-instance v15, Landroidx/media3/exoplayer/offline/Download;

    .line 886
    if-eqz v13, :cond_1

    move v3, v2

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    move v3, v1

    :goto_0
    const-wide/16 v8, -0x1

    const/16 v16, 0x0

    move-object v1, v15

    move-object/from16 v2, p1

    move-wide v4, v10

    move-wide v6, v10

    move-wide/from16 v17, v10

    .end local v10    # "nowMs":J
    .local v17, "nowMs":J
    move/from16 v10, p2

    move/from16 v11, v16

    invoke-direct/range {v1 .. v11}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJII)V

    .line 883
    invoke-direct {v0, v15}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;

    .line 893
    :goto_1
    invoke-direct/range {p0 .. p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 894
    return-void
.end method

.method private canDownloadsRun()Z
    .locals 1

    .line 1202
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadsPaused:Z

    if-nez v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->notMetRequirements:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static compareStartTimes(Landroidx/media3/exoplayer/offline/Download;Landroidx/media3/exoplayer/offline/Download;)I
    .locals 4
    .param p0, "first"    # Landroidx/media3/exoplayer/offline/Download;
    .param p1, "second"    # Landroidx/media3/exoplayer/offline/Download;

    .line 1281
    iget-wide v0, p0, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    iget-wide v2, p1, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    invoke-static {v0, v1, v2, v3}, Landroidx/media3/common/util/Util;->compareLong(JJ)I

    move-result v0

    return v0
.end method

.method private static copyDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;
    .locals 13
    .param p0, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p1, "state"    # I
    .param p2, "stopReason"    # I

    .line 1269
    new-instance v12, Landroidx/media3/exoplayer/offline/Download;

    iget-object v1, p0, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-wide v3, p0, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    .line 1273
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-wide v7, p0, Landroidx/media3/exoplayer/offline/Download;->contentLength:J

    const/4 v10, 0x0

    iget-object v11, p0, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    move-object v0, v12

    move v2, p1

    move v9, p2

    invoke-direct/range {v0 .. v11}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJIILandroidx/media3/exoplayer/offline/DownloadProgress;)V

    .line 1269
    return-object v12
.end method

.method private getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;
    .locals 4
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "loadFromIndex"    # Z

    .line 1243
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownloadIndex(Ljava/lang/String;)I

    move-result v0

    .line 1244
    .local v0, "index":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 1245
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/Download;

    return-object v1

    .line 1247
    :cond_0
    if-eqz p2, :cond_1

    .line 1249
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v1, p1}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->getDownload(Ljava/lang/String;)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v1
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 1250
    :catch_0
    move-exception v1

    .line 1251
    .local v1, "e":Ljava/io/IOException;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Failed to load download: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "DownloadManager"

    invoke-static {v3, v2, v1}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1254
    .end local v1    # "e":Ljava/io/IOException;
    :cond_1
    const/4 v1, 0x0

    return-object v1
.end method

.method private getDownloadIndex(Ljava/lang/String;)I
    .locals 3
    .param p1, "id"    # Ljava/lang/String;

    .line 1258
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 1259
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/Download;

    .line 1260
    .local v1, "download":Landroidx/media3/exoplayer/offline/Download;
    iget-object v2, v1, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v2, v2, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1261
    return v0

    .line 1258
    .end local v1    # "download":Landroidx/media3/exoplayer/offline/Download;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1264
    .end local v0    # "i":I
    :cond_1
    const/4 v0, -0x1

    return v0
.end method

.method private initialize(I)V
    .locals 7
    .param p1, "notMetRequirements"    # I

    .line 785
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->notMetRequirements:I

    .line 786
    const/4 v0, 0x0

    .line 788
    .local v0, "cursor":Landroidx/media3/exoplayer/offline/DownloadCursor;
    const/4 v1, 0x0

    :try_start_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->setDownloadingStatesToQueued()V

    .line 789
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    const/4 v3, 0x1

    const/4 v4, 0x2

    const/4 v5, 0x5

    const/4 v6, 0x7

    filled-new-array {v1, v3, v4, v5, v6}, [I

    move-result-object v3

    .line 790
    invoke-interface {v2, v3}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->getDownloads([I)Landroidx/media3/exoplayer/offline/DownloadCursor;

    move-result-object v2

    move-object v0, v2

    .line 792
    :goto_0
    invoke-interface {v0}, Landroidx/media3/exoplayer/offline/DownloadCursor;->moveToNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 793
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-interface {v0}, Landroidx/media3/exoplayer/offline/DownloadCursor;->getDownload()Landroidx/media3/exoplayer/offline/Download;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 799
    :catchall_0
    move-exception v1

    goto :goto_1

    .line 795
    :catch_0
    move-exception v2

    .line 796
    .local v2, "e":Ljava/io/IOException;
    :try_start_1
    const-string v3, "DownloadManager"

    const-string v4, "Failed to load index."

    invoke-static {v3, v4, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 797
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 799
    .end local v2    # "e":Ljava/io/IOException;
    :cond_0
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 800
    nop

    .line 803
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 804
    .local v2, "downloadsForMessage":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/offline/Download;>;"
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    invoke-virtual {v3, v1, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 805
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 806
    return-void

    .line 799
    .end local v2    # "downloadsForMessage":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/offline/Download;>;"
    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Util;->closeQuietly(Ljava/io/Closeable;)V

    .line 800
    throw v1
.end method

.method private onContentLengthChanged(Landroidx/media3/exoplayer/offline/DownloadManager$Task;J)V
    .locals 16
    .param p1, "task"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    .param p2, "contentLength"    # J

    .line 1072
    move-object/from16 v0, p0

    invoke-static/range {p1 .. p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$200(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Landroidx/media3/exoplayer/offline/DownloadRequest;

    move-result-object v1

    iget-object v13, v1, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    .line 1073
    .local v13, "downloadId":Ljava/lang/String;
    nop

    .line 1074
    const/4 v1, 0x0

    invoke-direct {v0, v13, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object v14, v1

    check-cast v14, Landroidx/media3/exoplayer/offline/Download;

    .line 1075
    .local v14, "download":Landroidx/media3/exoplayer/offline/Download;
    iget-wide v1, v14, Landroidx/media3/exoplayer/offline/Download;->contentLength:J

    cmp-long v1, p2, v1

    if-eqz v1, :cond_1

    const-wide/16 v1, -0x1

    cmp-long v1, p2, v1

    if-nez v1, :cond_0

    goto :goto_0

    .line 1078
    :cond_0
    new-instance v15, Landroidx/media3/exoplayer/offline/Download;

    iget-object v2, v14, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget v3, v14, Landroidx/media3/exoplayer/offline/Download;->state:I

    iget-wide v4, v14, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    .line 1083
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iget v10, v14, Landroidx/media3/exoplayer/offline/Download;->stopReason:I

    iget v11, v14, Landroidx/media3/exoplayer/offline/Download;->failureReason:I

    iget-object v12, v14, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    move-object v1, v15

    move-wide/from16 v8, p2

    invoke-direct/range {v1 .. v12}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJIILandroidx/media3/exoplayer/offline/DownloadProgress;)V

    .line 1078
    invoke-direct {v0, v15}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;

    .line 1088
    return-void

    .line 1076
    :cond_1
    :goto_0
    return-void
.end method

.method private onDownloadTaskStopped(Landroidx/media3/exoplayer/offline/Download;Ljava/lang/Exception;)V
    .locals 17
    .param p1, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p2, "finalException"    # Ljava/lang/Exception;

    .line 1135
    move-object/from16 v1, p0

    move-object/from16 v0, p1

    move-object/from16 v2, p2

    new-instance v15, Landroidx/media3/exoplayer/offline/Download;

    iget-object v4, v0, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    .line 1138
    if-nez v2, :cond_0

    const/4 v3, 0x3

    goto :goto_0

    :cond_0
    const/4 v3, 0x4

    :goto_0
    move v5, v3

    iget-wide v6, v0, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    .line 1140
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    iget-wide v10, v0, Landroidx/media3/exoplayer/offline/Download;->contentLength:J

    iget v12, v0, Landroidx/media3/exoplayer/offline/Download;->stopReason:I

    .line 1143
    const/4 v14, 0x0

    if-nez v2, :cond_1

    move v13, v14

    goto :goto_1

    :cond_1
    const/4 v3, 0x1

    move v13, v3

    :goto_1
    iget-object v3, v0, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    move-object/from16 v16, v3

    move-object v3, v15

    move-object/from16 v14, v16

    invoke-direct/range {v3 .. v14}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJIILandroidx/media3/exoplayer/offline/DownloadProgress;)V

    .line 1146
    .end local p1    # "download":Landroidx/media3/exoplayer/offline/Download;
    .local v3, "download":Landroidx/media3/exoplayer/offline/Download;
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    iget-object v4, v3, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v4, v4, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-direct {v1, v4}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownloadIndex(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 1149
    :try_start_0
    iget-object v0, v1, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v0, v3}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->putDownload(Landroidx/media3/exoplayer/offline/Download;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1152
    goto :goto_2

    .line 1150
    :catch_0
    move-exception v0

    .line 1151
    .local v0, "e":Ljava/io/IOException;
    const-string v4, "DownloadManager"

    const-string v5, "Failed to update index."

    invoke-static {v4, v5, v0}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1153
    .end local v0    # "e":Ljava/io/IOException;
    :goto_2
    new-instance v0, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    new-instance v4, Ljava/util/ArrayList;

    iget-object v5, v1, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-direct {v4, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    const/4 v5, 0x0

    invoke-direct {v0, v3, v5, v4, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;-><init>(Landroidx/media3/exoplayer/offline/Download;ZLjava/util/List;Ljava/lang/Exception;)V

    .line 1156
    .local v0, "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    iget-object v4, v1, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    const/4 v5, 0x2

    invoke-virtual {v4, v5, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    invoke-virtual {v4}, Landroid/os/Message;->sendToTarget()V

    .line 1157
    return-void
.end method

.method private onRemoveTaskStopped(Landroidx/media3/exoplayer/offline/Download;)V
    .locals 5
    .param p1, "download"    # Landroidx/media3/exoplayer/offline/Download;

    .line 1160
    iget v0, p1, Landroidx/media3/exoplayer/offline/Download;->state:I

    const/4 v1, 0x7

    const/4 v2, 0x1

    if-ne v0, v1, :cond_1

    .line 1162
    iget v0, p1, Landroidx/media3/exoplayer/offline/Download;->stopReason:I

    if-nez v0, :cond_0

    const/4 v2, 0x0

    :cond_0
    move v0, v2

    .line 1163
    .local v0, "state":I
    iget v1, p1, Landroidx/media3/exoplayer/offline/Download;->stopReason:I

    invoke-direct {p0, p1, v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    .line 1164
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 1165
    .end local v0    # "state":I
    goto :goto_1

    .line 1166
    :cond_1
    iget-object v0, p1, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v0, v0, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownloadIndex(Ljava/lang/String;)I

    move-result v0

    .line 1167
    .local v0, "removeIndex":I
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 1169
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    iget-object v3, p1, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v3, v3, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-interface {v1, v3}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->removeDownload(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1172
    goto :goto_0

    .line 1170
    :catch_0
    move-exception v1

    .line 1171
    .local v1, "e":Ljava/io/IOException;
    const-string v3, "DownloadManager"

    const-string v4, "Failed to remove from database"

    invoke-static {v3, v4}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1173
    .end local v1    # "e":Ljava/io/IOException;
    :goto_0
    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    new-instance v3, Ljava/util/ArrayList;

    iget-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    const/4 v4, 0x0

    invoke-direct {v1, p1, v2, v3, v4}, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;-><init>(Landroidx/media3/exoplayer/offline/Download;ZLjava/util/List;Ljava/lang/Exception;)V

    .line 1179
    .local v1, "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 1181
    .end local v0    # "removeIndex":I
    .end local v1    # "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    :goto_1
    return-void
.end method

.method private onTaskStopped(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)V
    .locals 6
    .param p1, "task"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 1091
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$200(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Landroidx/media3/exoplayer/offline/DownloadRequest;

    move-result-object v0

    iget-object v0, v0, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    .line 1092
    .local v0, "downloadId":Ljava/lang/String;
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1094
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v1

    .line 1095
    .local v1, "isRemove":Z
    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 1096
    iput-boolean v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->hasActiveRemoveTask:Z

    goto :goto_0

    .line 1097
    :cond_0
    iget v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeDownloadTaskCount:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeDownloadTaskCount:I

    if-nez v3, :cond_1

    .line 1098
    const/16 v3, 0xb

    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->removeMessages(I)V

    .line 1101
    :cond_1
    :goto_0
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$300(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1102
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 1103
    return-void

    .line 1106
    :cond_2
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$400(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Ljava/lang/Exception;

    move-result-object v3

    .line 1107
    .local v3, "finalException":Ljava/lang/Exception;
    if-eqz v3, :cond_3

    .line 1108
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Task failed: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$200(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Landroidx/media3/exoplayer/offline/DownloadRequest;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "DownloadManager"

    invoke-static {v5, v4, v3}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1111
    :cond_3
    nop

    .line 1112
    invoke-direct {p0, v0, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/Download;

    .line 1113
    .local v2, "download":Landroidx/media3/exoplayer/offline/Download;
    iget v4, v2, Landroidx/media3/exoplayer/offline/Download;->state:I

    sparse-switch v4, :sswitch_data_0

    .line 1128
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4}, Ljava/lang/IllegalStateException;-><init>()V

    throw v4

    .line 1120
    :sswitch_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1121
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->onRemoveTaskStopped(Landroidx/media3/exoplayer/offline/Download;)V

    .line 1122
    goto :goto_1

    .line 1115
    :sswitch_1
    xor-int/lit8 v4, v1, 0x1

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1116
    invoke-direct {p0, v2, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->onDownloadTaskStopped(Landroidx/media3/exoplayer/offline/Download;Ljava/lang/Exception;)V

    .line 1117
    nop

    .line 1131
    :goto_1
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 1132
    return-void

    :sswitch_data_0
    .sparse-switch
        0x2 -> :sswitch_1
        0x5 -> :sswitch_0
        0x7 -> :sswitch_0
    .end sparse-switch
.end method

.method private putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;
    .locals 8
    .param p1, "download"    # Landroidx/media3/exoplayer/offline/Download;

    .line 1214
    iget v0, p1, Landroidx/media3/exoplayer/offline/Download;->state:I

    const/4 v1, 0x3

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eq v0, v1, :cond_0

    iget v0, p1, Landroidx/media3/exoplayer/offline/Download;->state:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    move v0, v2

    goto :goto_0

    :cond_0
    move v0, v3

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1215
    iget-object v0, p1, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v0, v0, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownloadIndex(Ljava/lang/String;)I

    move-result v0

    .line 1216
    .local v0, "changedIndex":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 1217
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1218
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    new-instance v2, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;

    invoke-direct {v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;-><init>()V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    goto :goto_2

    .line 1220
    :cond_1
    iget-wide v4, p1, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/Download;

    iget-wide v6, v1, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    cmp-long v1, v4, v6

    if-eqz v1, :cond_2

    goto :goto_1

    :cond_2
    move v2, v3

    :goto_1
    move v1, v2

    .line 1221
    .local v1, "needsSort":Z
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v2, v0, p1}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 1222
    if-eqz v1, :cond_3

    .line 1223
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    new-instance v4, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;

    invoke-direct {v4}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;-><init>()V

    invoke-static {v2, v4}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 1227
    .end local v1    # "needsSort":Z
    :cond_3
    :goto_2
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v1, p1}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->putDownload(Landroidx/media3/exoplayer/offline/Download;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1230
    goto :goto_3

    .line 1228
    :catch_0
    move-exception v1

    .line 1229
    .local v1, "e":Ljava/io/IOException;
    const-string v2, "DownloadManager"

    const-string v4, "Failed to update index."

    invoke-static {v2, v4, v1}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1231
    .end local v1    # "e":Ljava/io/IOException;
    :goto_3
    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    new-instance v2, Ljava/util/ArrayList;

    iget-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-direct {v2, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    const/4 v4, 0x0

    invoke-direct {v1, p1, v3, v2, v4}, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;-><init>(Landroidx/media3/exoplayer/offline/Download;ZLjava/util/List;Ljava/lang/Exception;)V

    .line 1237
    .local v1, "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .line 1238
    return-object p1
.end method

.method private putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;
    .locals 1
    .param p1, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p2, "state"    # I
    .param p3, "stopReason"    # I

    .line 1208
    const/4 v0, 0x3

    if-eq p2, v0, :cond_0

    const/4 v0, 0x4

    if-eq p2, v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1209
    invoke-static {p1, p2, p3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->copyDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v0

    return-object v0
.end method

.method private release()V
    .locals 4

    .line 939
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    const/4 v2, 0x1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 940
    .local v1, "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->cancel(Z)V

    .line 941
    .end local v1    # "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    goto :goto_0

    .line 943
    :cond_0
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v0}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->setDownloadingStatesToQueued()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 946
    goto :goto_1

    .line 944
    :catch_0
    move-exception v0

    .line 945
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "DownloadManager"

    const-string v3, "Failed to update index."

    invoke-static {v1, v3, v0}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 947
    .end local v0    # "e":Ljava/io/IOException;
    :goto_1
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 948
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->thread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    .line 949
    monitor-enter p0

    .line 950
    :try_start_1
    iput-boolean v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->released:Z

    .line 951
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    .line 952
    monitor-exit p0

    .line 953
    return-void

    .line 952
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private removeAllDownloads()V
    .locals 7

    .line 907
    const-string v0, "DownloadManager"

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 908
    .local v1, "terminalDownloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    :try_start_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    const/4 v3, 0x3

    const/4 v4, 0x4

    filled-new-array {v3, v4}, [I

    move-result-object v3

    invoke-interface {v2, v3}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->getDownloads([I)Landroidx/media3/exoplayer/offline/DownloadCursor;

    move-result-object v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 909
    .local v2, "cursor":Landroidx/media3/exoplayer/offline/DownloadCursor;
    :goto_0
    :try_start_1
    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/DownloadCursor;->moveToNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 910
    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/DownloadCursor;->getDownload()Landroidx/media3/exoplayer/offline/Download;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 912
    :cond_0
    if-eqz v2, :cond_1

    :try_start_2
    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/DownloadCursor;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 914
    .end local v2    # "cursor":Landroidx/media3/exoplayer/offline/DownloadCursor;
    :cond_1
    goto :goto_2

    .line 908
    .restart local v2    # "cursor":Landroidx/media3/exoplayer/offline/DownloadCursor;
    :catchall_0
    move-exception v3

    if-eqz v2, :cond_2

    :try_start_3
    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/DownloadCursor;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v4

    :try_start_4
    invoke-virtual {v3, v4}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .end local v1    # "terminalDownloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    :cond_2
    :goto_1
    throw v3
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    .line 912
    .end local v2    # "cursor":Landroidx/media3/exoplayer/offline/DownloadCursor;
    .restart local v1    # "terminalDownloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    :catch_0
    move-exception v2

    .line 913
    .local v2, "e":Ljava/io/IOException;
    const-string v3, "Failed to load downloads."

    invoke-static {v0, v3}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 915
    .end local v2    # "e":Ljava/io/IOException;
    :goto_2
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_3
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    const/4 v4, 0x5

    const/4 v5, 0x0

    if-ge v2, v3, :cond_3

    .line 916
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/exoplayer/offline/Download;

    invoke-static {v6, v4, v5}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->copyDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 915
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 918
    .end local v2    # "i":I
    :cond_3
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_4
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_4

    .line 919
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    .line 920
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/exoplayer/offline/Download;

    invoke-static {v6, v4, v5}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->copyDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v6

    .line 919
    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 918
    add-int/lit8 v2, v2, 0x1

    goto :goto_4

    .line 922
    .end local v2    # "i":I
    :cond_4
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    new-instance v3, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;

    invoke-direct {v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler$$ExternalSyntheticLambda0;-><init>()V

    invoke-static {v2, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 924
    :try_start_5
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v2}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->setStatesToRemoving()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    .line 927
    goto :goto_5

    .line 925
    :catch_1
    move-exception v2

    .line 926
    .local v2, "e":Ljava/io/IOException;
    const-string v3, "Failed to update index."

    invoke-static {v0, v3, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 928
    .end local v2    # "e":Ljava/io/IOException;
    :goto_5
    new-instance v0, Ljava/util/ArrayList;

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 929
    .local v0, "updateList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/exoplayer/offline/Download;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_6
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-ge v2, v3, :cond_5

    .line 930
    new-instance v3, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;

    iget-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    .line 932
    invoke-virtual {v4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/offline/Download;

    const/4 v6, 0x0

    invoke-direct {v3, v4, v5, v0, v6}, Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;-><init>(Landroidx/media3/exoplayer/offline/Download;ZLjava/util/List;Ljava/lang/Exception;)V

    .line 933
    .local v3, "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    iget-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    const/4 v6, 0x2

    invoke-virtual {v4, v6, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    invoke-virtual {v4}, Landroid/os/Message;->sendToTarget()V

    .line 929
    .end local v3    # "update":Landroidx/media3/exoplayer/offline/DownloadManager$DownloadUpdate;
    add-int/lit8 v2, v2, 0x1

    goto :goto_6

    .line 935
    .end local v2    # "i":I
    :cond_5
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 936
    return-void
.end method

.method private removeDownload(Ljava/lang/String;)V
    .locals 3
    .param p1, "id"    # Ljava/lang/String;

    .line 897
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v0

    .line 898
    .local v0, "download":Landroidx/media3/exoplayer/offline/Download;
    if-nez v0, :cond_0

    .line 899
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to remove nonexistent download: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "DownloadManager"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 900
    return-void

    .line 902
    :cond_0
    const/4 v1, 0x5

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    .line 903
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 904
    return-void
.end method

.method private setDownloadsPaused(Z)V
    .locals 0
    .param p1, "downloadsPaused"    # Z

    .line 809
    iput-boolean p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadsPaused:Z

    .line 810
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 811
    return-void
.end method

.method private setMaxParallelDownloads(I)V
    .locals 0
    .param p1, "maxParallelDownloads"    # I

    .line 869
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->maxParallelDownloads:I

    .line 870
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 871
    return-void
.end method

.method private setMinRetryCount(I)V
    .locals 0
    .param p1, "minRetryCount"    # I

    .line 874
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->minRetryCount:I

    .line 875
    return-void
.end method

.method private setNotMetRequirements(I)V
    .locals 0
    .param p1, "notMetRequirements"    # I

    .line 814
    iput p1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->notMetRequirements:I

    .line 815
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 816
    return-void
.end method

.method private setStopReason(Landroidx/media3/exoplayer/offline/Download;I)V
    .locals 17
    .param p1, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p2, "stopReason"    # I

    .line 846
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v14, p2

    if-nez v14, :cond_0

    .line 847
    iget v2, v1, Landroidx/media3/exoplayer/offline/Download;->state:I

    const/4 v3, 0x1

    if-ne v2, v3, :cond_3

    .line 848
    const/4 v2, 0x0

    invoke-direct {v0, v1, v2, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    goto :goto_2

    .line 850
    :cond_0
    iget v2, v1, Landroidx/media3/exoplayer/offline/Download;->stopReason:I

    if-eq v14, v2, :cond_3

    .line 851
    iget v2, v1, Landroidx/media3/exoplayer/offline/Download;->state:I

    .line 852
    .local v2, "state":I
    if-eqz v2, :cond_2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    goto :goto_0

    :cond_1
    move v15, v2

    goto :goto_1

    .line 853
    :cond_2
    :goto_0
    const/4 v2, 0x1

    move v15, v2

    .line 855
    .end local v2    # "state":I
    .local v15, "state":I
    :goto_1
    new-instance v13, Landroidx/media3/exoplayer/offline/Download;

    iget-object v3, v1, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-wide v5, v1, Landroidx/media3/exoplayer/offline/Download;->startTimeMs:J

    .line 860
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    iget-wide v9, v1, Landroidx/media3/exoplayer/offline/Download;->contentLength:J

    const/4 v12, 0x0

    iget-object v11, v1, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    move-object v2, v13

    move v4, v15

    move-object/from16 v16, v11

    move/from16 v11, p2

    move-object v1, v13

    move-object/from16 v13, v16

    invoke-direct/range {v2 .. v13}, Landroidx/media3/exoplayer/offline/Download;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;IJJJIILandroidx/media3/exoplayer/offline/DownloadProgress;)V

    .line 855
    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownload(Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/Download;

    .line 866
    .end local v15    # "state":I
    :cond_3
    :goto_2
    return-void
.end method

.method private setStopReason(Ljava/lang/String;I)V
    .locals 5
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "stopReason"    # I

    .line 819
    const-string v0, "DownloadManager"

    if-nez p1, :cond_1

    .line 820
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 821
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/Download;

    invoke-direct {p0, v2, p2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setStopReason(Landroidx/media3/exoplayer/offline/Download;I)V

    .line 820
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 825
    .end local v1    # "i":I
    :cond_0
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v1, p2}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->setStopReason(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 826
    :catch_0
    move-exception v1

    .line 827
    .local v1, "e":Ljava/io/IOException;
    const-string v2, "Failed to set manual stop reason"

    invoke-static {v0, v2, v1}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 828
    .end local v1    # "e":Ljava/io/IOException;
    :goto_1
    goto :goto_2

    .line 830
    :cond_1
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->getDownload(Ljava/lang/String;Z)Landroidx/media3/exoplayer/offline/Download;

    move-result-object v1

    .line 831
    .local v1, "download":Landroidx/media3/exoplayer/offline/Download;
    if-eqz v1, :cond_2

    .line 832
    invoke-direct {p0, v1, p2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setStopReason(Landroidx/media3/exoplayer/offline/Download;I)V

    goto :goto_2

    .line 836
    :cond_2
    :try_start_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v2, p1, p2}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->setStopReason(Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 839
    goto :goto_2

    .line 837
    :catch_1
    move-exception v2

    .line 838
    .local v2, "e":Ljava/io/IOException;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Failed to set manual stop reason: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 842
    .end local v1    # "download":Landroidx/media3/exoplayer/offline/Download;
    .end local v2    # "e":Ljava/io/IOException;
    :goto_2
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncTasks()V

    .line 843
    return-void
.end method

.method private syncDownloadingDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;I)V
    .locals 1
    .param p1, "activeTask"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    .param p2, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p3, "accumulatingDownloadTaskCount"    # I

    .line 1032
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1033
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->canDownloadsRun()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->maxParallelDownloads:I

    if-lt p3, v0, :cond_1

    .line 1034
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    .line 1035
    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->cancel(Z)V

    .line 1037
    :cond_1
    return-void
.end method

.method private syncQueuedDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    .locals 10
    .param p1, "activeTask"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    .param p2, "download"    # Landroidx/media3/exoplayer/offline/Download;

    .line 999
    const/4 v0, 0x0

    if-eqz p1, :cond_0

    .line 1002
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v1

    xor-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 1003
    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->cancel(Z)V

    .line 1004
    return-object p1

    .line 1007
    :cond_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->canDownloadsRun()Z

    move-result v1

    if-eqz v1, :cond_3

    iget v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeDownloadTaskCount:I

    iget v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->maxParallelDownloads:I

    if-lt v1, v2, :cond_1

    goto :goto_0

    .line 1012
    :cond_1
    const/4 v1, 0x2

    invoke-direct {p0, p2, v1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->putDownloadWithState(Landroidx/media3/exoplayer/offline/Download;II)Landroidx/media3/exoplayer/offline/Download;

    move-result-object p2

    .line 1013
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloaderFactory:Landroidx/media3/exoplayer/offline/DownloaderFactory;

    iget-object v1, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/offline/DownloaderFactory;->createDownloader(Landroidx/media3/exoplayer/offline/DownloadRequest;)Landroidx/media3/exoplayer/offline/Downloader;

    move-result-object v0

    .line 1014
    .local v0, "downloader":Landroidx/media3/exoplayer/offline/Downloader;
    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    iget-object v3, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v5, p2, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    const/4 v6, 0x0

    iget v7, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->minRetryCount:I

    const/4 v9, 0x0

    move-object v2, v1

    move-object v4, v0

    move-object v8, p0

    invoke-direct/range {v2 .. v9}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;Landroidx/media3/exoplayer/offline/Downloader;Landroidx/media3/exoplayer/offline/DownloadProgress;ZILandroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;Landroidx/media3/exoplayer/offline/DownloadManager$1;)V

    move-object p1, v1

    .line 1022
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    iget-object v2, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v2, v2, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1023
    iget v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeDownloadTaskCount:I

    add-int/lit8 v2, v1, 0x1

    iput v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeDownloadTaskCount:I

    if-nez v1, :cond_2

    .line 1024
    const/16 v1, 0xb

    const-wide/16 v2, 0x1388

    invoke-virtual {p0, v1, v2, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1026
    :cond_2
    invoke-virtual {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->start()V

    .line 1027
    return-object p1

    .line 1008
    .end local v0    # "downloader":Landroidx/media3/exoplayer/offline/Downloader;
    :cond_3
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method private syncRemovingDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;)V
    .locals 10
    .param p1, "activeTask"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    .param p2, "download"    # Landroidx/media3/exoplayer/offline/Download;

    .line 1040
    if-eqz p1, :cond_1

    .line 1041
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1043
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->cancel(Z)V

    .line 1047
    :cond_0
    return-void

    .line 1050
    :cond_1
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->hasActiveRemoveTask:Z

    if-eqz v0, :cond_2

    .line 1051
    return-void

    .line 1055
    :cond_2
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloaderFactory:Landroidx/media3/exoplayer/offline/DownloaderFactory;

    iget-object v1, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/offline/DownloaderFactory;->createDownloader(Landroidx/media3/exoplayer/offline/DownloadRequest;)Landroidx/media3/exoplayer/offline/Downloader;

    move-result-object v0

    .line 1056
    .local v0, "downloader":Landroidx/media3/exoplayer/offline/Downloader;
    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    iget-object v3, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v5, p2, Landroidx/media3/exoplayer/offline/Download;->progress:Landroidx/media3/exoplayer/offline/DownloadProgress;

    const/4 v6, 0x1

    iget v7, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->minRetryCount:I

    const/4 v9, 0x0

    move-object v2, v1

    move-object v4, v0

    move-object v8, p0

    invoke-direct/range {v2 .. v9}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;-><init>(Landroidx/media3/exoplayer/offline/DownloadRequest;Landroidx/media3/exoplayer/offline/Downloader;Landroidx/media3/exoplayer/offline/DownloadProgress;ZILandroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;Landroidx/media3/exoplayer/offline/DownloadManager$1;)V

    move-object p1, v1

    .line 1064
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    iget-object v2, p2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v2, v2, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-virtual {v1, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1065
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->hasActiveRemoveTask:Z

    .line 1066
    invoke-virtual {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->start()V

    .line 1067
    return-void
.end method

.method private syncStoppedDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)V
    .locals 1
    .param p1, "activeTask"    # Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 989
    if-eqz p1, :cond_0

    .line 991
    invoke-static {p1}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 992
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->cancel(Z)V

    .line 994
    :cond_0
    return-void
.end method

.method private syncTasks()V
    .locals 5

    .line 958
    const/4 v0, 0x0

    .line 959
    .local v0, "accumulatingDownloadTaskCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 960
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/Download;

    .line 961
    .local v2, "download":Landroidx/media3/exoplayer/offline/Download;
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    iget-object v4, v2, Landroidx/media3/exoplayer/offline/Download;->request:Landroidx/media3/exoplayer/offline/DownloadRequest;

    iget-object v4, v4, Landroidx/media3/exoplayer/offline/DownloadRequest;->id:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 962
    .local v3, "activeTask":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    iget v4, v2, Landroidx/media3/exoplayer/offline/Download;->state:I

    packed-switch v4, :pswitch_data_0

    .line 980
    :pswitch_0
    new-instance v4, Ljava/lang/IllegalStateException;

    invoke-direct {v4}, Ljava/lang/IllegalStateException;-><init>()V

    throw v4

    .line 975
    :pswitch_1
    invoke-direct {p0, v3, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncRemovingDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;)V

    .line 976
    goto :goto_1

    .line 970
    :pswitch_2
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 971
    invoke-direct {p0, v3, v2, v0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncDownloadingDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;I)V

    .line 972
    goto :goto_1

    .line 964
    :pswitch_3
    invoke-direct {p0, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncStoppedDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)V

    .line 965
    goto :goto_1

    .line 967
    :pswitch_4
    invoke-direct {p0, v3, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->syncQueuedDownload(Landroidx/media3/exoplayer/offline/DownloadManager$Task;Landroidx/media3/exoplayer/offline/Download;)Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    move-result-object v3

    .line 968
    nop

    .line 982
    :goto_1
    if-eqz v3, :cond_0

    invoke-static {v3}, Landroidx/media3/exoplayer/offline/DownloadManager$Task;->access$000(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 983
    add-int/lit8 v0, v0, 0x1

    .line 959
    .end local v2    # "download":Landroidx/media3/exoplayer/offline/Download;
    .end local v3    # "activeTask":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 986
    .end local v1    # "i":I
    :cond_1
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private updateProgress()V
    .locals 5

    .line 1186
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 1187
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloads:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/offline/Download;

    .line 1188
    .local v1, "download":Landroidx/media3/exoplayer/offline/Download;
    iget v2, v1, Landroidx/media3/exoplayer/offline/Download;->state:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 1190
    :try_start_0
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->downloadIndex:Landroidx/media3/exoplayer/offline/WritableDownloadIndex;

    invoke-interface {v2, v1}, Landroidx/media3/exoplayer/offline/WritableDownloadIndex;->putDownload(Landroidx/media3/exoplayer/offline/Download;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1193
    goto :goto_1

    .line 1191
    :catch_0
    move-exception v2

    .line 1192
    .local v2, "e":Ljava/io/IOException;
    const-string v3, "DownloadManager"

    const-string v4, "Failed to update index."

    invoke-static {v3, v4, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1186
    .end local v1    # "download":Landroidx/media3/exoplayer/offline/Download;
    .end local v2    # "e":Ljava/io/IOException;
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1196
    .end local v0    # "i":I
    :cond_1
    const/16 v0, 0xb

    const-wide/16 v1, 0x1388

    invoke-virtual {p0, v0, v1, v2}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1197
    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "message"    # Landroid/os/Message;

    .line 722
    const/4 v0, 0x1

    .line 723
    .local v0, "processedExternalMessage":Z
    iget v1, p1, Landroid/os/Message;->what:I

    const/4 v2, 0x1

    packed-switch v1, :pswitch_data_0

    .line 777
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1}, Ljava/lang/IllegalStateException;-><init>()V

    throw v1

    .line 774
    :pswitch_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->release()V

    .line 775
    return-void

    .line 771
    :pswitch_1
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->updateProgress()V

    .line 772
    return-void

    .line 767
    :pswitch_2
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 768
    .local v1, "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    iget v2, p1, Landroid/os/Message;->arg1:I

    iget v3, p1, Landroid/os/Message;->arg2:I

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->toLong(II)J

    move-result-wide v2

    invoke-direct {p0, v1, v2, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->onContentLengthChanged(Landroidx/media3/exoplayer/offline/DownloadManager$Task;J)V

    .line 769
    return-void

    .line 762
    .end local v1    # "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    :pswitch_3
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadManager$Task;

    .line 763
    .restart local v1    # "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->onTaskStopped(Landroidx/media3/exoplayer/offline/DownloadManager$Task;)V

    .line 764
    const/4 v0, 0x0

    .line 765
    goto :goto_1

    .line 759
    .end local v1    # "task":Landroidx/media3/exoplayer/offline/DownloadManager$Task;
    :pswitch_4
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->removeAllDownloads()V

    .line 760
    goto :goto_1

    .line 755
    :pswitch_5
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    .line 756
    .local v1, "id":Ljava/lang/String;
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->removeDownload(Ljava/lang/String;)V

    .line 757
    goto :goto_1

    .line 750
    .end local v1    # "id":Ljava/lang/String;
    :pswitch_6
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroidx/media3/exoplayer/offline/DownloadRequest;

    .line 751
    .local v1, "request":Landroidx/media3/exoplayer/offline/DownloadRequest;
    iget v3, p1, Landroid/os/Message;->arg1:I

    .line 752
    .local v3, "stopReason":I
    invoke-direct {p0, v1, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->addDownload(Landroidx/media3/exoplayer/offline/DownloadRequest;I)V

    .line 753
    goto :goto_1

    .line 746
    .end local v1    # "request":Landroidx/media3/exoplayer/offline/DownloadRequest;
    .end local v3    # "stopReason":I
    :pswitch_7
    iget v1, p1, Landroid/os/Message;->arg1:I

    .line 747
    .local v1, "minRetryCount":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setMinRetryCount(I)V

    .line 748
    goto :goto_1

    .line 742
    .end local v1    # "minRetryCount":I
    :pswitch_8
    iget v1, p1, Landroid/os/Message;->arg1:I

    .line 743
    .local v1, "maxParallelDownloads":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setMaxParallelDownloads(I)V

    .line 744
    goto :goto_1

    .line 737
    .end local v1    # "maxParallelDownloads":I
    :pswitch_9
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/String;

    .line 738
    .local v1, "id":Ljava/lang/String;
    iget v3, p1, Landroid/os/Message;->arg1:I

    .line 739
    .restart local v3    # "stopReason":I
    invoke-direct {p0, v1, v3}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setStopReason(Ljava/lang/String;I)V

    .line 740
    goto :goto_1

    .line 733
    .end local v1    # "id":Ljava/lang/String;
    .end local v3    # "stopReason":I
    :pswitch_a
    iget v1, p1, Landroid/os/Message;->arg1:I

    .line 734
    .local v1, "notMetRequirements":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setNotMetRequirements(I)V

    .line 735
    goto :goto_1

    .line 729
    .end local v1    # "notMetRequirements":I
    :pswitch_b
    iget v1, p1, Landroid/os/Message;->arg1:I

    if-eqz v1, :cond_0

    move v1, v2

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 730
    .local v1, "downloadsPaused":Z
    :goto_0
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->setDownloadsPaused(Z)V

    .line 731
    goto :goto_1

    .line 725
    .end local v1    # "downloadsPaused":Z
    :pswitch_c
    iget v1, p1, Landroid/os/Message;->arg1:I

    .line 726
    .local v1, "notMetRequirements":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->initialize(I)V

    .line 727
    nop

    .line 779
    .end local v1    # "notMetRequirements":I
    :goto_1
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->mainHandler:Landroid/os/Handler;

    .line 780
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadManager$InternalHandler;->activeTasks:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->size()I

    move-result v3

    invoke-virtual {v1, v2, v0, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v1

    .line 781
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 782
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
