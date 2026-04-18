.class public Landroidx/media3/ui/PlayerNotificationManager;
.super Ljava/lang/Object;
.source "PlayerNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;,
        Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;,
        Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;,
        Landroidx/media3/ui/PlayerNotificationManager$PlayerListener;,
        Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;,
        Landroidx/media3/ui/PlayerNotificationManager$BitmapCallback;,
        Landroidx/media3/ui/PlayerNotificationManager$Priority;,
        Landroidx/media3/ui/PlayerNotificationManager$Visibility;,
        Landroidx/media3/ui/PlayerNotificationManager$Builder;
    }
.end annotation


# static fields
.field private static final ACTION_DISMISS:Ljava/lang/String; = "androidx.media3.ui.notification.dismiss"

.field public static final ACTION_FAST_FORWARD:Ljava/lang/String; = "androidx.media3.ui.notification.ffwd"

.field public static final ACTION_NEXT:Ljava/lang/String; = "androidx.media3.ui.notification.next"

.field public static final ACTION_PAUSE:Ljava/lang/String; = "androidx.media3.ui.notification.pause"

.field public static final ACTION_PLAY:Ljava/lang/String; = "androidx.media3.ui.notification.play"

.field public static final ACTION_PREVIOUS:Ljava/lang/String; = "androidx.media3.ui.notification.prev"

.field public static final ACTION_REWIND:Ljava/lang/String; = "androidx.media3.ui.notification.rewind"

.field public static final ACTION_STOP:Ljava/lang/String; = "androidx.media3.ui.notification.stop"

.field public static final EXTRA_INSTANCE_ID:Ljava/lang/String; = "INSTANCE_ID"

.field private static final MSG_START_OR_UPDATE_NOTIFICATION:I = 0x0

.field private static final MSG_UPDATE_NOTIFICATION_BITMAP:I = 0x1

.field private static instanceIdCounter:I


# instance fields
.field private badgeIconType:I

.field private builder:Landroidx/core/app/NotificationCompat$Builder;

.field private builderActions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/core/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation
.end field

.field private final channelId:Ljava/lang/String;

.field private color:I

.field private colorized:Z

.field private final context:Landroid/content/Context;

.field private currentNotificationTag:I

.field private final customActionReceiver:Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;

.field private final customActions:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/core/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation
.end field

.field private defaults:I

.field private final dismissPendingIntent:Landroid/app/PendingIntent;

.field private groupKey:Ljava/lang/String;

.field private final instanceId:I

.field private final intentFilter:Landroid/content/IntentFilter;

.field private isNotificationStarted:Z

.field private final mainHandler:Landroid/os/Handler;

.field private final mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

.field private mediaSessionToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

.field private final notificationBroadcastReceiver:Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;

.field private final notificationId:I

.field private final notificationListener:Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;

.field private final notificationManager:Landroidx/core/app/NotificationManagerCompat;

.field private final playbackActions:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/core/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation
.end field

.field private player:Landroidx/media3/common/Player;

.field private final playerListener:Landroidx/media3/common/Player$Listener;

.field private priority:I

.field private showPlayButtonIfSuppressed:Z

.field private smallIconResourceId:I

.field private useChronometer:Z

.field private useFastForwardAction:Z

.field private useFastForwardActionInCompactView:Z

.field private useNextAction:Z

.field private useNextActionInCompactView:Z

.field private usePlayPauseActions:Z

.field private usePreviousAction:Z

.field private usePreviousActionInCompactView:Z

.field private useRewindAction:Z

.field private useRewindActionInCompactView:Z

.field private useStopAction:Z

.field private visibility:I


# direct methods
.method public static synthetic $r8$lambda$28qL8gvrlgHsbHlyXukrsPxQ--g(Landroidx/media3/ui/PlayerNotificationManager;Landroid/os/Message;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->handleMessage(Landroid/os/Message;)Z

    move-result p0

    return p0
.end method

.method protected constructor <init>(Landroid/content/Context;Ljava/lang/String;ILandroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;IIIIIIIILjava/lang/String;)V
    .locals 17
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "channelId"    # Ljava/lang/String;
    .param p3, "notificationId"    # I
    .param p4, "mediaDescriptionAdapter"    # Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;
    .param p5, "notificationListener"    # Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;
    .param p6, "customActionReceiver"    # Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;
    .param p7, "smallIconResourceId"    # I
    .param p8, "playActionIconResourceId"    # I
    .param p9, "pauseActionIconResourceId"    # I
    .param p10, "stopActionIconResourceId"    # I
    .param p11, "rewindActionIconResourceId"    # I
    .param p12, "fastForwardActionIconResourceId"    # I
    .param p13, "previousActionIconResourceId"    # I
    .param p14, "nextActionIconResourceId"    # I
    .param p15, "groupKey"    # Ljava/lang/String;

    .line 747
    move-object/from16 v0, p0

    move-object/from16 v1, p6

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 748
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v11

    .line 749
    .end local p1    # "context":Landroid/content/Context;
    .local v11, "context":Landroid/content/Context;
    iput-object v11, v0, Landroidx/media3/ui/PlayerNotificationManager;->context:Landroid/content/Context;

    .line 750
    move-object/from16 v12, p2

    iput-object v12, v0, Landroidx/media3/ui/PlayerNotificationManager;->channelId:Ljava/lang/String;

    .line 751
    move/from16 v13, p3

    iput v13, v0, Landroidx/media3/ui/PlayerNotificationManager;->notificationId:I

    .line 752
    move-object/from16 v14, p4

    iput-object v14, v0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    .line 753
    move-object/from16 v15, p5

    iput-object v15, v0, Landroidx/media3/ui/PlayerNotificationManager;->notificationListener:Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;

    .line 754
    iput-object v1, v0, Landroidx/media3/ui/PlayerNotificationManager;->customActionReceiver:Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;

    .line 755
    move/from16 v10, p7

    iput v10, v0, Landroidx/media3/ui/PlayerNotificationManager;->smallIconResourceId:I

    .line 756
    move-object/from16 v9, p15

    iput-object v9, v0, Landroidx/media3/ui/PlayerNotificationManager;->groupKey:Ljava/lang/String;

    .line 757
    sget v3, Landroidx/media3/ui/PlayerNotificationManager;->instanceIdCounter:I

    add-int/lit8 v2, v3, 0x1

    sput v2, Landroidx/media3/ui/PlayerNotificationManager;->instanceIdCounter:I

    iput v3, v0, Landroidx/media3/ui/PlayerNotificationManager;->instanceId:I

    .line 762
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    new-instance v4, Landroidx/media3/ui/PlayerNotificationManager$$ExternalSyntheticLambda0;

    invoke-direct {v4, v0}, Landroidx/media3/ui/PlayerNotificationManager$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/ui/PlayerNotificationManager;)V

    invoke-static {v2, v4}, Landroidx/media3/common/util/Util;->createHandler(Landroid/os/Looper;Landroid/os/Handler$Callback;)Landroid/os/Handler;

    move-result-object v8

    .line 763
    .local v8, "mainHandler":Landroid/os/Handler;
    iput-object v8, v0, Landroidx/media3/ui/PlayerNotificationManager;->mainHandler:Landroid/os/Handler;

    .line 764
    invoke-static {v11}, Landroidx/core/app/NotificationManagerCompat;->from(Landroid/content/Context;)Landroidx/core/app/NotificationManagerCompat;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->notificationManager:Landroidx/core/app/NotificationManagerCompat;

    .line 765
    new-instance v2, Landroidx/media3/ui/PlayerNotificationManager$PlayerListener;

    const/4 v4, 0x0

    invoke-direct {v2, v0, v4}, Landroidx/media3/ui/PlayerNotificationManager$PlayerListener;-><init>(Landroidx/media3/ui/PlayerNotificationManager;Landroidx/media3/ui/PlayerNotificationManager$1;)V

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->playerListener:Landroidx/media3/common/Player$Listener;

    .line 766
    new-instance v2, Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;

    invoke-direct {v2, v0, v4}, Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;-><init>(Landroidx/media3/ui/PlayerNotificationManager;Landroidx/media3/ui/PlayerNotificationManager$1;)V

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->notificationBroadcastReceiver:Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;

    .line 767
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->intentFilter:Landroid/content/IntentFilter;

    .line 768
    const/4 v2, 0x1

    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousAction:Z

    .line 769
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->useNextAction:Z

    .line 770
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->usePlayPauseActions:Z

    .line 771
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->showPlayButtonIfSuppressed:Z

    .line 772
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindAction:Z

    .line 773
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardAction:Z

    .line 774
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->colorized:Z

    .line 775
    iput-boolean v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->useChronometer:Z

    .line 776
    const/4 v4, 0x0

    iput v4, v0, Landroidx/media3/ui/PlayerNotificationManager;->color:I

    .line 777
    iput v4, v0, Landroidx/media3/ui/PlayerNotificationManager;->defaults:I

    .line 778
    const/4 v4, -0x1

    iput v4, v0, Landroidx/media3/ui/PlayerNotificationManager;->priority:I

    .line 779
    iput v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->badgeIconType:I

    .line 780
    iput v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->visibility:I

    .line 783
    nop

    .line 784
    move-object v2, v11

    move/from16 v4, p8

    move/from16 v5, p9

    move/from16 v6, p10

    move/from16 v7, p11

    move-object/from16 v16, v8

    .end local v8    # "mainHandler":Landroid/os/Handler;
    .local v16, "mainHandler":Landroid/os/Handler;
    move/from16 v8, p12

    move/from16 v9, p13

    move/from16 v10, p14

    invoke-static/range {v2 .. v10}, Landroidx/media3/ui/PlayerNotificationManager;->createPlaybackActions(Landroid/content/Context;IIIIIIII)Ljava/util/Map;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->playbackActions:Ljava/util/Map;

    .line 794
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 795
    .local v3, "action":Ljava/lang/String;
    iget-object v4, v0, Landroidx/media3/ui/PlayerNotificationManager;->intentFilter:Landroid/content/IntentFilter;

    invoke-virtual {v4, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 796
    .end local v3    # "action":Ljava/lang/String;
    goto :goto_0

    .line 797
    :cond_0
    nop

    .line 798
    if-eqz v1, :cond_1

    .line 799
    iget v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->instanceId:I

    invoke-interface {v1, v11, v2}, Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;->createCustomActions(Landroid/content/Context;I)Ljava/util/Map;

    move-result-object v2

    goto :goto_1

    .line 800
    :cond_1
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v2

    :goto_1
    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->customActions:Ljava/util/Map;

    .line 801
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 802
    .restart local v3    # "action":Ljava/lang/String;
    iget-object v4, v0, Landroidx/media3/ui/PlayerNotificationManager;->intentFilter:Landroid/content/IntentFilter;

    invoke-virtual {v4, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 803
    .end local v3    # "action":Ljava/lang/String;
    goto :goto_2

    .line 804
    :cond_2
    iget v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->instanceId:I

    const-string v3, "androidx.media3.ui.notification.dismiss"

    invoke-static {v3, v11, v2}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v2

    iput-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->dismissPendingIntent:Landroid/app/PendingIntent;

    .line 805
    iget-object v2, v0, Landroidx/media3/ui/PlayerNotificationManager;->intentFilter:Landroid/content/IntentFilter;

    invoke-virtual {v2, v3}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 806
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/ui/PlayerNotificationManager;Landroid/graphics/Bitmap;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;
    .param p1, "x1"    # Landroid/graphics/Bitmap;
    .param p2, "x2"    # I

    .line 181
    invoke-direct {p0, p1, p2}, Landroidx/media3/ui/PlayerNotificationManager;->postUpdateNotificationBitmap(Landroid/graphics/Bitmap;I)V

    return-void
.end method

.method static synthetic access$1000(Landroidx/media3/ui/PlayerNotificationManager;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->customActions:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$400(Landroidx/media3/ui/PlayerNotificationManager;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    invoke-direct {p0}, Landroidx/media3/ui/PlayerNotificationManager;->postStartOrUpdateNotification()V

    return-void
.end method

.method static synthetic access$500(Landroidx/media3/ui/PlayerNotificationManager;)Landroidx/media3/common/Player;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    return-object v0
.end method

.method static synthetic access$600(Landroidx/media3/ui/PlayerNotificationManager;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    return v0
.end method

.method static synthetic access$700(Landroidx/media3/ui/PlayerNotificationManager;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->instanceId:I

    return v0
.end method

.method static synthetic access$800(Landroidx/media3/ui/PlayerNotificationManager;Z)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;
    .param p1, "x1"    # Z

    .line 181
    invoke-direct {p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->stopNotification(Z)V

    return-void
.end method

.method static synthetic access$900(Landroidx/media3/ui/PlayerNotificationManager;)Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/ui/PlayerNotificationManager;

    .line 181
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->customActionReceiver:Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;

    return-object v0
.end method

.method private static createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;
    .locals 3
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "instanceId"    # I

    .line 1526
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 1527
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "INSTANCE_ID"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1530
    sget v1, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v2, 0x17

    if-lt v1, v2, :cond_0

    .line 1531
    const/high16 v1, 0xc000000

    .local v1, "pendingFlags":I
    goto :goto_0

    .line 1533
    .end local v1    # "pendingFlags":I
    :cond_0
    const/high16 v1, 0x8000000

    .line 1536
    .restart local v1    # "pendingFlags":I
    :goto_0
    invoke-static {p1, p2, v0, v1}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    return-object v2
.end method

.method private static createPlaybackActions(Landroid/content/Context;IIIIIIII)Ljava/util/Map;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "instanceId"    # I
    .param p2, "playActionIconResourceId"    # I
    .param p3, "pauseActionIconResourceId"    # I
    .param p4, "stopActionIconResourceId"    # I
    .param p5, "rewindActionIconResourceId"    # I
    .param p6, "fastForwardActionIconResourceId"    # I
    .param p7, "previousActionIconResourceId"    # I
    .param p8, "nextActionIconResourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "IIIIIIII)",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/core/app/NotificationCompat$Action;",
            ">;"
        }
    .end annotation

    .line 1477
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1478
    .local v0, "actions":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroidx/core/app/NotificationCompat$Action;>;"
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_play_description:I

    .line 1482
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1483
    const-string v3, "androidx.media3.ui.notification.play"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p2, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1478
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1484
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_pause_description:I

    .line 1488
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1489
    const-string v3, "androidx.media3.ui.notification.pause"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p3, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1484
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1490
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_stop_description:I

    .line 1494
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1495
    const-string v3, "androidx.media3.ui.notification.stop"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p4, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1490
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1496
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_rewind_description:I

    .line 1500
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1501
    const-string v3, "androidx.media3.ui.notification.rewind"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p5, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1496
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1502
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_fastforward_description:I

    .line 1506
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1507
    const-string v3, "androidx.media3.ui.notification.ffwd"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p6, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1502
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1508
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_previous_description:I

    .line 1512
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1513
    const-string v3, "androidx.media3.ui.notification.prev"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p7, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1508
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1514
    new-instance v1, Landroidx/core/app/NotificationCompat$Action;

    sget v2, Landroidx/media3/ui/R$string;->exo_controls_next_description:I

    .line 1518
    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 1519
    const-string v3, "androidx.media3.ui.notification.next"

    invoke-static {v3, p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->createBroadcastIntent(Ljava/lang/String;Landroid/content/Context;I)Landroid/app/PendingIntent;

    move-result-object v4

    invoke-direct {v1, p8, v2, v4}, Landroidx/core/app/NotificationCompat$Action;-><init>(ILjava/lang/CharSequence;Landroid/app/PendingIntent;)V

    .line 1514
    invoke-interface {v0, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1520
    return-object v0
.end method

.method private handleMessage(Landroid/os/Message;)Z
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .line 1450
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 1462
    const/4 v0, 0x0

    return v0

    .line 1457
    :pswitch_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->currentNotificationTag:I

    iget v1, p1, Landroid/os/Message;->arg1:I

    if-ne v0, v1, :cond_0

    .line 1458
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Landroid/graphics/Bitmap;

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerNotificationManager;->startOrUpdateNotification(Landroidx/media3/common/Player;Landroid/graphics/Bitmap;)V

    goto :goto_0

    .line 1452
    :pswitch_1
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    if-eqz v0, :cond_0

    .line 1453
    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroidx/media3/ui/PlayerNotificationManager;->startOrUpdateNotification(Landroidx/media3/common/Player;Landroid/graphics/Bitmap;)V

    .line 1464
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private postStartOrUpdateNotification()V
    .locals 2

    .line 1437
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->mainHandler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1438
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->mainHandler:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 1440
    :cond_0
    return-void
.end method

.method private postUpdateNotificationBitmap(Landroid/graphics/Bitmap;I)V
    .locals 3
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;
    .param p2, "notificationTag"    # I

    .line 1443
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->mainHandler:Landroid/os/Handler;

    .line 1444
    const/4 v1, 0x1

    const/4 v2, -0x1

    invoke-virtual {v0, v1, p2, v2, p1}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 1446
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 1447
    return-void
.end method

.method private static setLargeIcon(Landroidx/core/app/NotificationCompat$Builder;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p0, "builder"    # Landroidx/core/app/NotificationCompat$Builder;
    .param p1, "largeIcon"    # Landroid/graphics/Bitmap;

    .line 1541
    invoke-virtual {p0, p1}, Landroidx/core/app/NotificationCompat$Builder;->setLargeIcon(Landroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1542
    return-void
.end method

.method private startOrUpdateNotification(Landroidx/media3/common/Player;Landroid/graphics/Bitmap;)V
    .locals 7
    .param p1, "player"    # Landroidx/media3/common/Player;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;

    .line 1197
    invoke-virtual {p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->getOngoing(Landroidx/media3/common/Player;)Z

    move-result v0

    .line 1198
    .local v0, "ongoing":Z
    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->builder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {p0, p1, v1, v0, p2}, Landroidx/media3/ui/PlayerNotificationManager;->createNotification(Landroidx/media3/common/Player;Landroidx/core/app/NotificationCompat$Builder;ZLandroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->builder:Landroidx/core/app/NotificationCompat$Builder;

    .line 1199
    const/4 v2, 0x0

    if-nez v1, :cond_0

    .line 1200
    invoke-direct {p0, v2}, Landroidx/media3/ui/PlayerNotificationManager;->stopNotification(Z)V

    .line 1201
    return-void

    .line 1203
    :cond_0
    invoke-virtual {v1}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v1

    .line 1204
    .local v1, "notification":Landroid/app/Notification;
    iget-object v3, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationManager:Landroidx/core/app/NotificationManagerCompat;

    iget v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationId:I

    invoke-virtual {v3, v4, v1}, Landroidx/core/app/NotificationManagerCompat;->notify(ILandroid/app/Notification;)V

    .line 1205
    iget-boolean v3, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    if-nez v3, :cond_1

    .line 1206
    iget-object v3, p0, Landroidx/media3/ui/PlayerNotificationManager;->context:Landroid/content/Context;

    iget-object v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationBroadcastReceiver:Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;

    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->intentFilter:Landroid/content/IntentFilter;

    invoke-static {v3, v4, v5}, Landroidx/media3/common/util/Util;->registerReceiverNotExported(Landroid/content/Context;Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 1208
    :cond_1
    iget-object v3, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationListener:Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;

    const/4 v4, 0x1

    if-eqz v3, :cond_4

    .line 1211
    iget v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationId:I

    if-nez v0, :cond_2

    iget-boolean v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    if-nez v6, :cond_3

    :cond_2
    move v2, v4

    :cond_3
    invoke-interface {v3, v5, v1, v2}, Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;->onNotificationPosted(ILandroid/app/Notification;Z)V

    .line 1214
    :cond_4
    iput-boolean v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    .line 1215
    return-void
.end method

.method private stopNotification(Z)V
    .locals 2
    .param p1, "dismissedByUser"    # Z

    .line 1218
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    if-eqz v0, :cond_0

    .line 1219
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    .line 1220
    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->mainHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->removeMessages(I)V

    .line 1221
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationManager:Landroidx/core/app/NotificationManagerCompat;

    iget v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationId:I

    invoke-virtual {v0, v1}, Landroidx/core/app/NotificationManagerCompat;->cancel(I)V

    .line 1222
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->context:Landroid/content/Context;

    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationBroadcastReceiver:Landroidx/media3/ui/PlayerNotificationManager$NotificationBroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 1223
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationListener:Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;

    if-eqz v0, :cond_0

    .line 1224
    iget v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->notificationId:I

    invoke-interface {v0, v1, p1}, Landroidx/media3/ui/PlayerNotificationManager$NotificationListener;->onNotificationCancelled(IZ)V

    .line 1227
    :cond_0
    return-void
.end method


# virtual methods
.method protected createNotification(Landroidx/media3/common/Player;Landroidx/core/app/NotificationCompat$Builder;ZLandroid/graphics/Bitmap;)Landroidx/core/app/NotificationCompat$Builder;
    .locals 9
    .param p1, "player"    # Landroidx/media3/common/Player;
    .param p2, "builder"    # Landroidx/core/app/NotificationCompat$Builder;
    .param p3, "ongoing"    # Z
    .param p4, "largeIcon"    # Landroid/graphics/Bitmap;

    .line 1247
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 1248
    const/16 v0, 0x11

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1249
    invoke-interface {p1}, Landroidx/media3/common/Player;->getCurrentTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1250
    iput-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->builderActions:Ljava/util/List;

    .line 1251
    return-object v1

    .line 1254
    :cond_0
    invoke-virtual {p0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->getActions(Landroidx/media3/common/Player;)Ljava/util/List;

    move-result-object v0

    .line 1255
    .local v0, "actionNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(I)V

    .line 1256
    .local v3, "actions":Ljava/util/List;, "Ljava/util/List<Landroidx/core/app/NotificationCompat$Action;>;"
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_3

    .line 1257
    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 1260
    .local v5, "actionName":Ljava/lang/String;
    iget-object v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->playbackActions:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 1261
    iget-object v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->playbackActions:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/core/app/NotificationCompat$Action;

    goto :goto_1

    .line 1262
    :cond_1
    iget-object v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->customActions:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/core/app/NotificationCompat$Action;

    :goto_1
    nop

    .line 1263
    .local v6, "action":Landroidx/core/app/NotificationCompat$Action;
    if-eqz v6, :cond_2

    .line 1264
    invoke-interface {v3, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1256
    .end local v5    # "actionName":Ljava/lang/String;
    .end local v6    # "action":Landroidx/core/app/NotificationCompat$Action;
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1268
    .end local v4    # "i":I
    :cond_3
    if-eqz p2, :cond_4

    iget-object v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->builderActions:Ljava/util/List;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 1269
    :cond_4
    new-instance v4, Landroidx/core/app/NotificationCompat$Builder;

    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->context:Landroid/content/Context;

    iget-object v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->channelId:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    move-object p2, v4

    .line 1270
    iput-object v3, p0, Landroidx/media3/ui/PlayerNotificationManager;->builderActions:Ljava/util/List;

    .line 1271
    const/4 v4, 0x0

    .restart local v4    # "i":I
    :goto_2
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_5

    .line 1272
    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/core/app/NotificationCompat$Action;

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->addAction(Landroidx/core/app/NotificationCompat$Action;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1271
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 1276
    .end local v4    # "i":I
    :cond_5
    new-instance v4, Landroidx/media/app/NotificationCompat$MediaStyle;

    invoke-direct {v4}, Landroidx/media/app/NotificationCompat$MediaStyle;-><init>()V

    .line 1277
    .local v4, "mediaStyle":Landroidx/media/app/NotificationCompat$MediaStyle;
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaSessionToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

    if-eqz v5, :cond_6

    .line 1278
    invoke-virtual {v4, v5}, Landroidx/media/app/NotificationCompat$MediaStyle;->setMediaSession(Landroid/support/v4/media/session/MediaSessionCompat$Token;)Landroidx/media/app/NotificationCompat$MediaStyle;

    .line 1280
    :cond_6
    invoke-virtual {p0, v0, p1}, Landroidx/media3/ui/PlayerNotificationManager;->getActionIndicesForCompactView(Ljava/util/List;Landroidx/media3/common/Player;)[I

    move-result-object v5

    invoke-virtual {v4, v5}, Landroidx/media/app/NotificationCompat$MediaStyle;->setShowActionsInCompactView([I)Landroidx/media/app/NotificationCompat$MediaStyle;

    .line 1282
    xor-int/lit8 v5, p3, 0x1

    invoke-virtual {v4, v5}, Landroidx/media/app/NotificationCompat$MediaStyle;->setShowCancelButton(Z)Landroidx/media/app/NotificationCompat$MediaStyle;

    .line 1283
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->dismissPendingIntent:Landroid/app/PendingIntent;

    invoke-virtual {v4, v5}, Landroidx/media/app/NotificationCompat$MediaStyle;->setCancelButtonIntent(Landroid/app/PendingIntent;)Landroidx/media/app/NotificationCompat$MediaStyle;

    .line 1284
    invoke-virtual {p2, v4}, Landroidx/core/app/NotificationCompat$Builder;->setStyle(Landroidx/core/app/NotificationCompat$Style;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1287
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->dismissPendingIntent:Landroid/app/PendingIntent;

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setDeleteIntent(Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1290
    iget v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->badgeIconType:I

    .line 1291
    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setBadgeIconType(I)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    .line 1292
    invoke-virtual {v5, p3}, Landroidx/core/app/NotificationCompat$Builder;->setOngoing(Z)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->color:I

    .line 1293
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setColor(I)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget-boolean v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->colorized:Z

    .line 1294
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setColorized(Z)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->smallIconResourceId:I

    .line 1295
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setSmallIcon(I)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->visibility:I

    .line 1296
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setVisibility(I)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->priority:I

    .line 1297
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setPriority(I)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    iget v6, p0, Landroidx/media3/ui/PlayerNotificationManager;->defaults:I

    .line 1298
    invoke-virtual {v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setDefaults(I)Landroidx/core/app/NotificationCompat$Builder;

    .line 1301
    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v6, 0x15

    if-lt v5, v6, :cond_7

    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->useChronometer:Z

    if-eqz v5, :cond_7

    .line 1303
    const/16 v5, 0x10

    invoke-interface {p1, v5}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1304
    invoke-interface {p1}, Landroidx/media3/common/Player;->isPlaying()Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1305
    invoke-interface {p1}, Landroidx/media3/common/Player;->isPlayingAd()Z

    move-result v5

    if-nez v5, :cond_7

    .line 1306
    invoke-interface {p1}, Landroidx/media3/common/Player;->isCurrentMediaItemDynamic()Z

    move-result v5

    if-nez v5, :cond_7

    .line 1307
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlaybackParameters()Landroidx/media3/common/PlaybackParameters;

    move-result-object v5

    iget v5, v5, Landroidx/media3/common/PlaybackParameters;->speed:F

    const/high16 v6, 0x3f800000    # 1.0f

    cmpl-float v5, v5, v6

    if-nez v5, :cond_7

    .line 1308
    nop

    .line 1309
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-interface {p1}, Landroidx/media3/common/Player;->getContentPosition()J

    move-result-wide v7

    sub-long/2addr v5, v7

    invoke-virtual {p2, v5, v6}, Landroidx/core/app/NotificationCompat$Builder;->setWhen(J)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    .line 1310
    invoke-virtual {v5, v2}, Landroidx/core/app/NotificationCompat$Builder;->setShowWhen(Z)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v5

    .line 1311
    invoke-virtual {v5, v2}, Landroidx/core/app/NotificationCompat$Builder;->setUsesChronometer(Z)Landroidx/core/app/NotificationCompat$Builder;

    goto :goto_3

    .line 1313
    :cond_7
    const/4 v5, 0x0

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setShowWhen(Z)Landroidx/core/app/NotificationCompat$Builder;

    move-result-object v6

    invoke-virtual {v6, v5}, Landroidx/core/app/NotificationCompat$Builder;->setUsesChronometer(Z)Landroidx/core/app/NotificationCompat$Builder;

    .line 1317
    :goto_3
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    invoke-interface {v5, p1}, Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;->getCurrentContentTitle(Landroidx/media3/common/Player;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1318
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    invoke-interface {v5, p1}, Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;->getCurrentContentText(Landroidx/media3/common/Player;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1319
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    invoke-interface {v5, p1}, Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;->getCurrentSubText(Landroidx/media3/common/Player;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroidx/core/app/NotificationCompat$Builder;->setSubText(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1320
    if-nez p4, :cond_8

    .line 1321
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    new-instance v6, Landroidx/media3/ui/PlayerNotificationManager$BitmapCallback;

    iget v7, p0, Landroidx/media3/ui/PlayerNotificationManager;->currentNotificationTag:I

    add-int/2addr v7, v2

    iput v7, p0, Landroidx/media3/ui/PlayerNotificationManager;->currentNotificationTag:I

    invoke-direct {v6, p0, v7, v1}, Landroidx/media3/ui/PlayerNotificationManager$BitmapCallback;-><init>(Landroidx/media3/ui/PlayerNotificationManager;ILandroidx/media3/ui/PlayerNotificationManager$1;)V

    .line 1322
    invoke-interface {v5, p1, v6}, Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;->getCurrentLargeIcon(Landroidx/media3/common/Player;Landroidx/media3/ui/PlayerNotificationManager$BitmapCallback;)Landroid/graphics/Bitmap;

    move-result-object p4

    .line 1325
    :cond_8
    invoke-static {p2, p4}, Landroidx/media3/ui/PlayerNotificationManager;->setLargeIcon(Landroidx/core/app/NotificationCompat$Builder;Landroid/graphics/Bitmap;)V

    .line 1326
    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaDescriptionAdapter:Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;

    invoke-interface {v1, p1}, Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;->createCurrentContentIntent(Landroidx/media3/common/Player;)Landroid/app/PendingIntent;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroidx/core/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1328
    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->groupKey:Ljava/lang/String;

    if-eqz v1, :cond_9

    .line 1329
    invoke-virtual {p2, v1}, Landroidx/core/app/NotificationCompat$Builder;->setGroup(Ljava/lang/String;)Landroidx/core/app/NotificationCompat$Builder;

    .line 1332
    :cond_9
    invoke-virtual {p2, v2}, Landroidx/core/app/NotificationCompat$Builder;->setOnlyAlertOnce(Z)Landroidx/core/app/NotificationCompat$Builder;

    .line 1333
    return-object p2
.end method

.method protected getActionIndicesForCompactView(Ljava/util/List;Landroidx/media3/common/Player;)[I
    .locals 9
    .param p2, "player"    # Landroidx/media3/common/Player;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;",
            "Landroidx/media3/common/Player;",
            ")[I"
        }
    .end annotation

    .line 1401
    .local p1, "actionNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v0, "androidx.media3.ui.notification.pause"

    invoke-interface {p1, v0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 1402
    .local v0, "pauseActionIndex":I
    const-string v1, "androidx.media3.ui.notification.play"

    invoke-interface {p1, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    .line 1404
    .local v1, "playActionIndex":I
    iget-boolean v2, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousActionInCompactView:Z

    const/4 v3, -0x1

    if-eqz v2, :cond_0

    .line 1405
    const-string v2, "androidx.media3.ui.notification.prev"

    invoke-interface {p1, v2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v2

    goto :goto_0

    .line 1406
    :cond_0
    iget-boolean v2, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindActionInCompactView:Z

    if-eqz v2, :cond_1

    const-string v2, "androidx.media3.ui.notification.rewind"

    invoke-interface {p1, v2}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v2

    goto :goto_0

    :cond_1
    move v2, v3

    :goto_0
    nop

    .line 1408
    .local v2, "leftSideActionIndex":I
    iget-boolean v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextActionInCompactView:Z

    if-eqz v4, :cond_2

    .line 1409
    const-string v4, "androidx.media3.ui.notification.next"

    invoke-interface {p1, v4}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v4

    goto :goto_1

    .line 1410
    :cond_2
    iget-boolean v4, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardActionInCompactView:Z

    if-eqz v4, :cond_3

    const-string v4, "androidx.media3.ui.notification.ffwd"

    invoke-interface {p1, v4}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v4

    goto :goto_1

    :cond_3
    move v4, v3

    :goto_1
    nop

    .line 1412
    .local v4, "rightSideActionIndex":I
    const/4 v5, 0x3

    new-array v5, v5, [I

    .line 1413
    .local v5, "actionIndices":[I
    const/4 v6, 0x0

    .line 1414
    .local v6, "actionCounter":I
    if-eq v2, v3, :cond_4

    .line 1415
    add-int/lit8 v7, v6, 0x1

    .end local v6    # "actionCounter":I
    .local v7, "actionCounter":I
    aput v2, v5, v6

    move v6, v7

    .line 1417
    .end local v7    # "actionCounter":I
    .restart local v6    # "actionCounter":I
    :cond_4
    iget-boolean v7, p0, Landroidx/media3/ui/PlayerNotificationManager;->showPlayButtonIfSuppressed:Z

    invoke-static {p2, v7}, Landroidx/media3/common/util/Util;->shouldShowPlayButton(Landroidx/media3/common/Player;Z)Z

    move-result v7

    .line 1418
    .local v7, "shouldShowPlayButton":Z
    if-eq v0, v3, :cond_5

    if-nez v7, :cond_5

    .line 1419
    add-int/lit8 v8, v6, 0x1

    .end local v6    # "actionCounter":I
    .local v8, "actionCounter":I
    aput v0, v5, v6

    move v6, v8

    goto :goto_2

    .line 1420
    .end local v8    # "actionCounter":I
    .restart local v6    # "actionCounter":I
    :cond_5
    if-eq v1, v3, :cond_6

    if-eqz v7, :cond_6

    .line 1421
    add-int/lit8 v8, v6, 0x1

    .end local v6    # "actionCounter":I
    .restart local v8    # "actionCounter":I
    aput v1, v5, v6

    move v6, v8

    .line 1423
    .end local v8    # "actionCounter":I
    .restart local v6    # "actionCounter":I
    :cond_6
    :goto_2
    if-eq v4, v3, :cond_7

    .line 1424
    add-int/lit8 v3, v6, 0x1

    .end local v6    # "actionCounter":I
    .local v3, "actionCounter":I
    aput v4, v5, v6

    move v6, v3

    .line 1426
    .end local v3    # "actionCounter":I
    .restart local v6    # "actionCounter":I
    :cond_7
    invoke-static {v5, v6}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v3

    return-object v3
.end method

.method protected getActions(Landroidx/media3/common/Player;)Ljava/util/List;
    .locals 6
    .param p1, "player"    # Landroidx/media3/common/Player;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/Player;",
            ")",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 1356
    const/4 v0, 0x7

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v0

    .line 1357
    .local v0, "enablePrevious":Z
    const/16 v1, 0xb

    invoke-interface {p1, v1}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v1

    .line 1358
    .local v1, "enableRewind":Z
    const/16 v2, 0xc

    invoke-interface {p1, v2}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v2

    .line 1359
    .local v2, "enableFastForward":Z
    const/16 v3, 0x9

    invoke-interface {p1, v3}, Landroidx/media3/common/Player;->isCommandAvailable(I)Z

    move-result v3

    .line 1361
    .local v3, "enableNext":Z
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 1362
    .local v4, "stringActions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousAction:Z

    if-eqz v5, :cond_0

    if-eqz v0, :cond_0

    .line 1363
    const-string v5, "androidx.media3.ui.notification.prev"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1365
    :cond_0
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindAction:Z

    if-eqz v5, :cond_1

    if-eqz v1, :cond_1

    .line 1366
    const-string v5, "androidx.media3.ui.notification.rewind"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1368
    :cond_1
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePlayPauseActions:Z

    if-eqz v5, :cond_3

    .line 1369
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->showPlayButtonIfSuppressed:Z

    invoke-static {p1, v5}, Landroidx/media3/common/util/Util;->shouldShowPlayButton(Landroidx/media3/common/Player;Z)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1370
    const-string v5, "androidx.media3.ui.notification.play"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1372
    :cond_2
    const-string v5, "androidx.media3.ui.notification.pause"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1375
    :cond_3
    :goto_0
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardAction:Z

    if-eqz v5, :cond_4

    if-eqz v2, :cond_4

    .line 1376
    const-string v5, "androidx.media3.ui.notification.ffwd"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1378
    :cond_4
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextAction:Z

    if-eqz v5, :cond_5

    if-eqz v3, :cond_5

    .line 1379
    const-string v5, "androidx.media3.ui.notification.next"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1381
    :cond_5
    iget-object v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->customActionReceiver:Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;

    if-eqz v5, :cond_6

    .line 1382
    invoke-interface {v5, p1}, Landroidx/media3/ui/PlayerNotificationManager$CustomActionReceiver;->getCustomActions(Landroidx/media3/common/Player;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 1384
    :cond_6
    iget-boolean v5, p0, Landroidx/media3/ui/PlayerNotificationManager;->useStopAction:Z

    if-eqz v5, :cond_7

    .line 1385
    const-string v5, "androidx.media3.ui.notification.stop"

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1387
    :cond_7
    return-object v4
.end method

.method protected getOngoing(Landroidx/media3/common/Player;)Z
    .locals 2
    .param p1, "player"    # Landroidx/media3/common/Player;

    .line 1431
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlaybackState()I

    move-result v0

    .line 1432
    .local v0, "playbackState":I
    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 1433
    :cond_0
    invoke-interface {p1}, Landroidx/media3/common/Player;->getPlayWhenReady()Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    .line 1432
    :goto_0
    return v1
.end method

.method public final invalidate()V
    .locals 1

    .line 1187
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->isNotificationStarted:Z

    if-eqz v0, :cond_0

    .line 1188
    invoke-direct {p0}, Landroidx/media3/ui/PlayerNotificationManager;->postStartOrUpdateNotification()V

    .line 1190
    :cond_0
    return-void
.end method

.method public final setBadgeIconType(I)V
    .locals 1
    .param p1, "badgeIconType"    # I

    .line 1030
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->badgeIconType:I

    if-ne v0, p1, :cond_0

    .line 1031
    return-void

    .line 1033
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 1040
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1037
    :pswitch_0
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->badgeIconType:I

    .line 1038
    nop

    .line 1042
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1043
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final setColor(I)V
    .locals 1
    .param p1, "color"    # I

    .line 1082
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->color:I

    if-eq v0, p1, :cond_0

    .line 1083
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->color:I

    .line 1084
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1086
    :cond_0
    return-void
.end method

.method public final setColorized(Z)V
    .locals 1
    .param p1, "colorized"    # Z

    .line 1054
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->colorized:Z

    if-eq v0, p1, :cond_0

    .line 1055
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->colorized:Z

    .line 1056
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1058
    :cond_0
    return-void
.end method

.method public final setDefaults(I)V
    .locals 1
    .param p1, "defaults"    # I

    .line 1068
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->defaults:I

    if-eq v0, p1, :cond_0

    .line 1069
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->defaults:I

    .line 1070
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1072
    :cond_0
    return-void
.end method

.method public final setMediaSessionToken(Landroid/support/v4/media/session/MediaSessionCompat$Token;)V
    .locals 1
    .param p1, "token"    # Landroid/support/v4/media/session/MediaSessionCompat$Token;

    .line 1016
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaSessionToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

    invoke-static {v0, p1}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1017
    iput-object p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->mediaSessionToken:Landroid/support/v4/media/session/MediaSessionCompat$Token;

    .line 1018
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1020
    :cond_0
    return-void
.end method

.method public final setPlayer(Landroidx/media3/common/Player;)V
    .locals 4
    .param p1, "player"    # Landroidx/media3/common/Player;

    .line 823
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne v0, v1, :cond_0

    move v0, v2

    goto :goto_0

    :cond_0
    move v0, v3

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 824
    if-eqz p1, :cond_2

    invoke-interface {p1}, Landroidx/media3/common/Player;->getApplicationLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    if-ne v0, v1, :cond_1

    goto :goto_1

    :cond_1
    move v2, v3

    :cond_2
    :goto_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 825
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    if-ne v0, p1, :cond_3

    .line 826
    return-void

    .line 828
    :cond_3
    if-eqz v0, :cond_4

    .line 829
    iget-object v1, p0, Landroidx/media3/ui/PlayerNotificationManager;->playerListener:Landroidx/media3/common/Player$Listener;

    invoke-interface {v0, v1}, Landroidx/media3/common/Player;->removeListener(Landroidx/media3/common/Player$Listener;)V

    .line 830
    if-nez p1, :cond_4

    .line 831
    invoke-direct {p0, v3}, Landroidx/media3/ui/PlayerNotificationManager;->stopNotification(Z)V

    .line 834
    :cond_4
    iput-object p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->player:Landroidx/media3/common/Player;

    .line 835
    if-eqz p1, :cond_5

    .line 836
    iget-object v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->playerListener:Landroidx/media3/common/Player$Listener;

    invoke-interface {p1, v0}, Landroidx/media3/common/Player;->addListener(Landroidx/media3/common/Player$Listener;)V

    .line 837
    invoke-direct {p0}, Landroidx/media3/ui/PlayerNotificationManager;->postStartOrUpdateNotification()V

    .line 839
    :cond_5
    return-void
.end method

.method public final setPriority(I)V
    .locals 1
    .param p1, "priority"    # I

    .line 1103
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->priority:I

    if-ne v0, p1, :cond_0

    .line 1104
    return-void

    .line 1106
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 1115
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1112
    :pswitch_0
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->priority:I

    .line 1113
    nop

    .line 1117
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1118
    return-void

    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public setShowPlayButtonIfPlaybackIsSuppressed(Z)V
    .locals 1
    .param p1, "showPlayButtonIfSuppressed"    # Z

    .line 991
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->showPlayButtonIfSuppressed:Z

    if-eq v0, p1, :cond_0

    .line 992
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->showPlayButtonIfSuppressed:Z

    .line 993
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 995
    :cond_0
    return-void
.end method

.method public final setSmallIcon(I)V
    .locals 1
    .param p1, "smallIconResourceId"    # I

    .line 1128
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->smallIconResourceId:I

    if-eq v0, p1, :cond_0

    .line 1129
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->smallIconResourceId:I

    .line 1130
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1132
    :cond_0
    return-void
.end method

.method public final setUseChronometer(Z)V
    .locals 1
    .param p1, "useChronometer"    # Z

    .line 1153
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useChronometer:Z

    if-eq v0, p1, :cond_0

    .line 1154
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useChronometer:Z

    .line 1155
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1157
    :cond_0
    return-void
.end method

.method public final setUseFastForwardAction(Z)V
    .locals 1
    .param p1, "useFastForwardAction"    # Z

    .line 911
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardAction:Z

    if-eq v0, p1, :cond_0

    .line 912
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardAction:Z

    .line 913
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 915
    :cond_0
    return-void
.end method

.method public final setUseFastForwardActionInCompactView(Z)V
    .locals 1
    .param p1, "useFastForwardActionInCompactView"    # Z

    .line 941
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardActionInCompactView:Z

    if-eq v0, p1, :cond_1

    .line 942
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardActionInCompactView:Z

    .line 943
    if-eqz p1, :cond_0

    .line 944
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextActionInCompactView:Z

    .line 946
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 948
    :cond_1
    return-void
.end method

.method public final setUseNextAction(Z)V
    .locals 1
    .param p1, "useNextAction"    # Z

    .line 847
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextAction:Z

    if-eq v0, p1, :cond_0

    .line 848
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextAction:Z

    .line 849
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 851
    :cond_0
    return-void
.end method

.method public final setUseNextActionInCompactView(Z)V
    .locals 1
    .param p1, "useNextActionInCompactView"    # Z

    .line 876
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextActionInCompactView:Z

    if-eq v0, p1, :cond_1

    .line 877
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useNextActionInCompactView:Z

    .line 878
    if-eqz p1, :cond_0

    .line 879
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useFastForwardActionInCompactView:Z

    .line 881
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 883
    :cond_1
    return-void
.end method

.method public final setUsePlayPauseActions(Z)V
    .locals 1
    .param p1, "usePlayPauseActions"    # Z

    .line 975
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePlayPauseActions:Z

    if-eq v0, p1, :cond_0

    .line 976
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePlayPauseActions:Z

    .line 977
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 979
    :cond_0
    return-void
.end method

.method public final setUsePreviousAction(Z)V
    .locals 1
    .param p1, "usePreviousAction"    # Z

    .line 859
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousAction:Z

    if-eq v0, p1, :cond_0

    .line 860
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousAction:Z

    .line 861
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 863
    :cond_0
    return-void
.end method

.method public final setUsePreviousActionInCompactView(Z)V
    .locals 1
    .param p1, "usePreviousActionInCompactView"    # Z

    .line 896
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousActionInCompactView:Z

    if-eq v0, p1, :cond_1

    .line 897
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousActionInCompactView:Z

    .line 898
    if-eqz p1, :cond_0

    .line 899
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindActionInCompactView:Z

    .line 901
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 903
    :cond_1
    return-void
.end method

.method public final setUseRewindAction(Z)V
    .locals 1
    .param p1, "useRewindAction"    # Z

    .line 923
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindAction:Z

    if-eq v0, p1, :cond_0

    .line 924
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindAction:Z

    .line 925
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 927
    :cond_0
    return-void
.end method

.method public final setUseRewindActionInCompactView(Z)V
    .locals 1
    .param p1, "useRewindActionInCompactView"    # Z

    .line 960
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindActionInCompactView:Z

    if-eq v0, p1, :cond_1

    .line 961
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useRewindActionInCompactView:Z

    .line 962
    if-eqz p1, :cond_0

    .line 963
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->usePreviousActionInCompactView:Z

    .line 965
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 967
    :cond_1
    return-void
.end method

.method public final setUseStopAction(Z)V
    .locals 1
    .param p1, "useStopAction"    # Z

    .line 1003
    iget-boolean v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->useStopAction:Z

    if-ne v0, p1, :cond_0

    .line 1004
    return-void

    .line 1006
    :cond_0
    iput-boolean p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->useStopAction:Z

    .line 1007
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1008
    return-void
.end method

.method public final setVisibility(I)V
    .locals 1
    .param p1, "visibility"    # I

    .line 1170
    iget v0, p0, Landroidx/media3/ui/PlayerNotificationManager;->visibility:I

    if-ne v0, p1, :cond_0

    .line 1171
    return-void

    .line 1173
    :cond_0
    packed-switch p1, :pswitch_data_0

    .line 1180
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 1177
    :pswitch_0
    iput p1, p0, Landroidx/media3/ui/PlayerNotificationManager;->visibility:I

    .line 1178
    nop

    .line 1182
    invoke-virtual {p0}, Landroidx/media3/ui/PlayerNotificationManager;->invalidate()V

    .line 1183
    return-void

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
