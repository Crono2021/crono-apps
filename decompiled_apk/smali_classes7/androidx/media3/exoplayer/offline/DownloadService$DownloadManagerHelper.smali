.class final Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;
.super Ljava/lang/Object;
.source "DownloadService.java"

# interfaces
.implements Landroidx/media3/exoplayer/offline/DownloadManager$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/offline/DownloadService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "DownloadManagerHelper"
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

.field private downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

.field private final foregroundAllowed:Z

.field private scheduledRequirements:Landroidx/media3/exoplayer/scheduler/Requirements;

.field private final scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

.field private final serviceClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class<",
            "+",
            "Landroidx/media3/exoplayer/offline/DownloadService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/offline/DownloadManager;ZLandroidx/media3/exoplayer/scheduler/Scheduler;Ljava/lang/Class;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p3, "foregroundAllowed"    # Z
    .param p4, "scheduler"    # Landroidx/media3/exoplayer/scheduler/Scheduler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroidx/media3/exoplayer/offline/DownloadManager;",
            "Z",
            "Landroidx/media3/exoplayer/scheduler/Scheduler;",
            "Ljava/lang/Class<",
            "+",
            "Landroidx/media3/exoplayer/offline/DownloadService;",
            ">;)V"
        }
    .end annotation

    .line 959
    .local p5, "serviceClass":Ljava/lang/Class;, "Ljava/lang/Class<+Landroidx/media3/exoplayer/offline/DownloadService;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 960
    iput-object p1, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    .line 961
    iput-object p2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    .line 962
    iput-boolean p3, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->foregroundAllowed:Z

    .line 963
    iput-object p4, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

    .line 964
    iput-object p5, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->serviceClass:Ljava/lang/Class;

    .line 965
    invoke-virtual {p2, p0}, Landroidx/media3/exoplayer/offline/DownloadManager;->addListener(Landroidx/media3/exoplayer/offline/DownloadManager$Listener;)V

    .line 966
    invoke-virtual {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->updateScheduler()Z

    .line 967
    return-void
.end method

.method synthetic constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/offline/DownloadManager;ZLandroidx/media3/exoplayer/scheduler/Scheduler;Ljava/lang/Class;Landroidx/media3/exoplayer/offline/DownloadService$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Context;
    .param p2, "x1"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p3, "x2"    # Z
    .param p4, "x3"    # Landroidx/media3/exoplayer/scheduler/Scheduler;
    .param p5, "x4"    # Ljava/lang/Class;
    .param p6, "x5"    # Landroidx/media3/exoplayer/offline/DownloadService$1;

    .line 943
    invoke-direct/range {p0 .. p5}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/offline/DownloadManager;ZLandroidx/media3/exoplayer/scheduler/Scheduler;Ljava/lang/Class;)V

    return-void
.end method

.method static synthetic access$100(Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;)Landroidx/media3/exoplayer/offline/DownloadManager;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;

    .line 943
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    return-object v0
.end method

.method private cancelScheduler()V
    .locals 2
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "scheduler"
        }
    .end annotation

    .line 1104
    new-instance v0, Landroidx/media3/exoplayer/scheduler/Requirements;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/scheduler/Requirements;-><init>(I)V

    .line 1105
    .local v0, "canceledRequirements":Landroidx/media3/exoplayer/scheduler/Requirements;
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->schedulerNeedsUpdate(Landroidx/media3/exoplayer/scheduler/Requirements;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1106
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

    invoke-interface {v1}, Landroidx/media3/exoplayer/scheduler/Scheduler;->cancel()Z

    .line 1107
    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduledRequirements:Landroidx/media3/exoplayer/scheduler/Requirements;

    .line 1109
    :cond_0
    return-void
.end method

.method private restartService()V
    .locals 4

    .line 1116
    iget-boolean v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->foregroundAllowed:Z

    const-string v1, "DownloadService"

    if-eqz v0, :cond_0

    .line 1118
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->serviceClass:Ljava/lang/Class;

    const-string v3, "androidx.media3.exoplayer.downloadService.action.RESTART"

    invoke-static {v0, v2, v3}, Landroidx/media3/exoplayer/offline/DownloadService;->access$900(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1119
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    invoke-static {v2, v0}, Landroidx/media3/common/util/Util;->startForegroundService(Landroid/content/Context;Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1125
    nop

    .end local v0    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 1120
    :catch_0
    move-exception v0

    .line 1124
    .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v2, "Failed to restart (foreground launch restriction)"

    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1125
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    goto :goto_0

    .line 1130
    :cond_0
    :try_start_1
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->serviceClass:Ljava/lang/Class;

    const-string v3, "androidx.media3.exoplayer.downloadService.action.INIT"

    invoke-static {v0, v2, v3}, Landroidx/media3/exoplayer/offline/DownloadService;->access$900(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1131
    .local v0, "intent":Landroid/content/Intent;
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    invoke-virtual {v2, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1136
    nop

    .end local v0    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 1132
    :catch_1
    move-exception v0

    .line 1135
    .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v2, "Failed to restart (process is idle)"

    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1138
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :goto_0
    return-void
.end method

.method private schedulerNeedsUpdate(Landroidx/media3/exoplayer/scheduler/Requirements;)Z
    .locals 1
    .param p1, "requirements"    # Landroidx/media3/exoplayer/scheduler/Requirements;

    .line 1099
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduledRequirements:Landroidx/media3/exoplayer/scheduler/Requirements;

    invoke-static {v0, p1}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    xor-int/lit8 v0, v0, 0x1

    return v0
.end method

.method private serviceMayNeedRestart()Z
    .locals 1

    .line 1112
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-eqz v0, :cond_1

    invoke-static {v0}, Landroidx/media3/exoplayer/offline/DownloadService;->access$800(Landroidx/media3/exoplayer/offline/DownloadService;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method


# virtual methods
.method public attachService(Landroidx/media3/exoplayer/offline/DownloadService;)V
    .locals 2
    .param p1, "downloadService"    # Landroidx/media3/exoplayer/offline/DownloadService;

    .line 970
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 971
    iput-object p1, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    .line 972
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->isInitialized()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 978
    invoke-static {}, Landroidx/media3/common/util/Util;->createHandlerForCurrentOrMainLooper()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0, p1}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;Landroidx/media3/exoplayer/offline/DownloadService;)V

    .line 979
    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    .line 982
    :cond_1
    return-void
.end method

.method public detachService(Landroidx/media3/exoplayer/offline/DownloadService;)V
    .locals 1
    .param p1, "downloadService"    # Landroidx/media3/exoplayer/offline/DownloadService;

    .line 985
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 986
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    .line 987
    return-void
.end method

.method synthetic lambda$attachService$0$androidx-media3-exoplayer-offline-DownloadService$DownloadManagerHelper(Landroidx/media3/exoplayer/offline/DownloadService;)V
    .locals 1
    .param p1, "downloadService"    # Landroidx/media3/exoplayer/offline/DownloadService;

    .line 980
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->getCurrentDownloads()Ljava/util/List;

    move-result-object v0

    invoke-static {p1, v0}, Landroidx/media3/exoplayer/offline/DownloadService;->access$300(Landroidx/media3/exoplayer/offline/DownloadService;Ljava/util/List;)V

    return-void
.end method

.method public onDownloadChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/offline/Download;Ljava/lang/Exception;)V
    .locals 2
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p2, "download"    # Landroidx/media3/exoplayer/offline/Download;
    .param p3, "finalException"    # Ljava/lang/Exception;

    .line 1042
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-eqz v0, :cond_0

    .line 1043
    invoke-static {v0, p2}, Landroidx/media3/exoplayer/offline/DownloadService;->access$400(Landroidx/media3/exoplayer/offline/DownloadService;Landroidx/media3/exoplayer/offline/Download;)V

    .line 1045
    :cond_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->serviceMayNeedRestart()Z

    move-result v0

    if-eqz v0, :cond_1

    iget v0, p2, Landroidx/media3/exoplayer/offline/Download;->state:I

    invoke-static {v0}, Landroidx/media3/exoplayer/offline/DownloadService;->access$500(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1050
    const-string v0, "DownloadService"

    const-string v1, "DownloadService wasn\'t running. Restarting."

    invoke-static {v0, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1051
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->restartService()V

    .line 1053
    :cond_1
    return-void
.end method

.method public onDownloadRemoved(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/offline/Download;)V
    .locals 1
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p2, "download"    # Landroidx/media3/exoplayer/offline/Download;

    .line 1057
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-eqz v0, :cond_0

    .line 1058
    invoke-static {v0}, Landroidx/media3/exoplayer/offline/DownloadService;->access$600(Landroidx/media3/exoplayer/offline/DownloadService;)V

    .line 1060
    :cond_0
    return-void
.end method

.method public final onIdle(Landroidx/media3/exoplayer/offline/DownloadManager;)V
    .locals 1
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;

    .line 1064
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-eqz v0, :cond_0

    .line 1065
    invoke-static {v0}, Landroidx/media3/exoplayer/offline/DownloadService;->access$700(Landroidx/media3/exoplayer/offline/DownloadService;)V

    .line 1067
    :cond_0
    return-void
.end method

.method public onInitialized(Landroidx/media3/exoplayer/offline/DownloadManager;)V
    .locals 2
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;

    .line 1034
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadService:Landroidx/media3/exoplayer/offline/DownloadService;

    if-eqz v0, :cond_0

    .line 1035
    invoke-virtual {p1}, Landroidx/media3/exoplayer/offline/DownloadManager;->getCurrentDownloads()Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/offline/DownloadService;->access$300(Landroidx/media3/exoplayer/offline/DownloadService;Ljava/util/List;)V

    .line 1037
    :cond_0
    return-void
.end method

.method public onRequirementsStateChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Landroidx/media3/exoplayer/scheduler/Requirements;I)V
    .locals 0
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p2, "requirements"    # Landroidx/media3/exoplayer/scheduler/Requirements;
    .param p3, "notMetRequirements"    # I

    .line 1074
    invoke-virtual {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->updateScheduler()Z

    .line 1075
    return-void
.end method

.method public onWaitingForRequirementsChanged(Landroidx/media3/exoplayer/offline/DownloadManager;Z)V
    .locals 3
    .param p1, "downloadManager"    # Landroidx/media3/exoplayer/offline/DownloadManager;
    .param p2, "waitingForRequirements"    # Z

    .line 1080
    if-nez p2, :cond_1

    .line 1081
    invoke-virtual {p1}, Landroidx/media3/exoplayer/offline/DownloadManager;->getDownloadsPaused()Z

    move-result v0

    if-nez v0, :cond_1

    .line 1082
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->serviceMayNeedRestart()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1086
    invoke-virtual {p1}, Landroidx/media3/exoplayer/offline/DownloadManager;->getCurrentDownloads()Ljava/util/List;

    move-result-object v0

    .line 1087
    .local v0, "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 1088
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/offline/Download;

    iget v2, v2, Landroidx/media3/exoplayer/offline/Download;->state:I

    if-nez v2, :cond_0

    .line 1089
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->restartService()V

    .line 1090
    return-void

    .line 1087
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1094
    .end local v0    # "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public updateScheduler()Z
    .locals 8

    .line 998
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/offline/DownloadManager;->isWaitingForRequirements()Z

    move-result v0

    .line 999
    .local v0, "waitingForRequirements":Z
    iget-object v1, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

    if-nez v1, :cond_0

    .line 1000
    xor-int/lit8 v1, v0, 0x1

    return v1

    .line 1003
    :cond_0
    const/4 v1, 0x1

    if-nez v0, :cond_1

    .line 1004
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->cancelScheduler()V

    .line 1005
    return v1

    .line 1008
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->downloadManager:Landroidx/media3/exoplayer/offline/DownloadManager;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/offline/DownloadManager;->getRequirements()Landroidx/media3/exoplayer/scheduler/Requirements;

    move-result-object v2

    .line 1009
    .local v2, "requirements":Landroidx/media3/exoplayer/scheduler/Requirements;
    iget-object v3, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

    invoke-interface {v3, v2}, Landroidx/media3/exoplayer/scheduler/Scheduler;->getSupportedRequirements(Landroidx/media3/exoplayer/scheduler/Requirements;)Landroidx/media3/exoplayer/scheduler/Requirements;

    move-result-object v3

    .line 1010
    .local v3, "supportedRequirements":Landroidx/media3/exoplayer/scheduler/Requirements;
    invoke-virtual {v3, v2}, Landroidx/media3/exoplayer/scheduler/Requirements;->equals(Ljava/lang/Object;)Z

    move-result v4

    const/4 v5, 0x0

    if-nez v4, :cond_2

    .line 1011
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->cancelScheduler()V

    .line 1012
    return v5

    .line 1015
    :cond_2
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->schedulerNeedsUpdate(Landroidx/media3/exoplayer/scheduler/Requirements;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 1016
    return v1

    .line 1019
    :cond_3
    iget-object v4, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 1020
    .local v4, "servicePackage":Ljava/lang/String;
    iget-object v6, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduler:Landroidx/media3/exoplayer/scheduler/Scheduler;

    const-string v7, "androidx.media3.exoplayer.downloadService.action.RESTART"

    invoke-interface {v6, v2, v4, v7}, Landroidx/media3/exoplayer/scheduler/Scheduler;->schedule(Landroidx/media3/exoplayer/scheduler/Requirements;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 1021
    iput-object v2, p0, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->scheduledRequirements:Landroidx/media3/exoplayer/scheduler/Requirements;

    .line 1022
    return v1

    .line 1024
    :cond_4
    const-string v1, "DownloadService"

    const-string v6, "Failed to schedule restart"

    invoke-static {v1, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1025
    invoke-direct {p0}, Landroidx/media3/exoplayer/offline/DownloadService$DownloadManagerHelper;->cancelScheduler()V

    .line 1026
    return v5
.end method
