.class public final Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;
.super Ljava/lang/Object;
.source "DownloadNotificationHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/offline/DownloadNotificationHelper$Api31;
    }
.end annotation


# static fields
.field private static final NULL_STRING_ID:I


# instance fields
.field private final notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "channelId"    # Ljava/lang/String;

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    new-instance v0, Landroidx/core/app/NotificationCompat$Builder;

    .line 51
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p2}, Landroidx/core/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 52
    return-void
.end method

.method private buildEndStateNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;I)Landroid/app/Notification;
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "smallIcon"    # I
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "message"    # Ljava/lang/String;
    .param p5, "titleStringId"    # I

    .line 198
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x1

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move/from16 v5, p5

    invoke-direct/range {v0 .. v10}, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->buildNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;IIIZZZ)Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method private buildNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;IIIZZZ)Landroid/app/Notification;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "smallIcon"    # I
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "message"    # Ljava/lang/String;
    .param p5, "titleStringId"    # I
    .param p6, "maxProgress"    # I
    .param p7, "currentProgress"    # I
    .param p8, "indeterminateProgress"    # Z
    .param p9, "ongoing"    # Z
    .param p10, "showWhen"    # Z

    .line 222
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0, p2}, Landroidx/core/app/NotificationCompat$Builder;->setSmallIcon(I)Landroidx/core/app/NotificationCompat$Builder;

    .line 223
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 224
    const/4 v1, 0x0

    if-nez p5, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, p5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 223
    :goto_0
    invoke-virtual {v0, v2}, Landroidx/core/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$Builder;

    .line 225
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0, p3}, Landroidx/core/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroidx/core/app/NotificationCompat$Builder;

    .line 226
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    .line 227
    if-nez p4, :cond_1

    goto :goto_1

    :cond_1
    new-instance v1, Landroidx/core/app/NotificationCompat$BigTextStyle;

    invoke-direct {v1}, Landroidx/core/app/NotificationCompat$BigTextStyle;-><init>()V

    invoke-virtual {v1, p4}, Landroidx/core/app/NotificationCompat$BigTextStyle;->bigText(Ljava/lang/CharSequence;)Landroidx/core/app/NotificationCompat$BigTextStyle;

    move-result-object v1

    .line 226
    :goto_1
    invoke-virtual {v0, v1}, Landroidx/core/app/NotificationCompat$Builder;->setStyle(Landroidx/core/app/NotificationCompat$Style;)Landroidx/core/app/NotificationCompat$Builder;

    .line 228
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0, p6, p7, p8}, Landroidx/core/app/NotificationCompat$Builder;->setProgress(IIZ)Landroidx/core/app/NotificationCompat$Builder;

    .line 229
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0, p9}, Landroidx/core/app/NotificationCompat$Builder;->setOngoing(Z)Landroidx/core/app/NotificationCompat$Builder;

    .line 230
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0, p10}, Landroidx/core/app/NotificationCompat$Builder;->setShowWhen(Z)Landroidx/core/app/NotificationCompat$Builder;

    .line 231
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x1f

    if-lt v0, v1, :cond_2

    .line 232
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-static {v0}, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper$Api31;->setForegroundServiceBehavior(Landroidx/core/app/NotificationCompat$Builder;)V

    .line 234
    :cond_2
    iget-object v0, p0, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->notificationBuilder:Landroidx/core/app/NotificationCompat$Builder;

    invoke-virtual {v0}, Landroidx/core/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public buildDownloadCompletedNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;)Landroid/app/Notification;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "smallIcon"    # I
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "message"    # Ljava/lang/String;

    .line 170
    sget v6, Landroidx/media3/exoplayer/R$string;->exo_download_completed:I

    .line 171
    .local v6, "titleStringId":I
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, v6

    invoke-direct/range {v0 .. v5}, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->buildEndStateNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;I)Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method public buildDownloadFailedNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;)Landroid/app/Notification;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "smallIcon"    # I
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "message"    # Ljava/lang/String;

    .line 188
    sget v6, Landroidx/media3/exoplayer/R$string;->exo_download_failed:I

    .line 189
    .local v6, "titleStringId":I
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, v6

    invoke-direct/range {v0 .. v5}, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->buildEndStateNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;I)Landroid/app/Notification;

    move-result-object v0

    return-object v0
.end method

.method public buildProgressNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;Ljava/util/List;I)Landroid/app/Notification;
    .locals 24
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "smallIcon"    # I
    .param p3, "contentIntent"    # Landroid/app/PendingIntent;
    .param p4, "message"    # Ljava/lang/String;
    .param p6, "notMetRequirements"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Landroid/app/PendingIntent;",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/offline/Download;",
            ">;I)",
            "Landroid/app/Notification;"
        }
    .end annotation

    .line 72
    .local p5, "downloads":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/offline/Download;>;"
    const/4 v0, 0x0

    .line 73
    .local v0, "totalPercentage":F
    const/4 v1, 0x0

    .line 74
    .local v1, "downloadTaskCount":I
    const/4 v2, 0x1

    .line 75
    .local v2, "allDownloadPercentagesUnknown":Z
    const/4 v3, 0x0

    .line 76
    .local v3, "haveDownloadedBytes":Z
    const/4 v4, 0x0

    .line 77
    .local v4, "haveDownloadingTasks":Z
    const/4 v5, 0x0

    .line 78
    .local v5, "haveQueuedTasks":Z
    const/4 v6, 0x0

    .line 79
    .local v6, "haveRemovingTasks":Z
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface/range {p5 .. p5}, Ljava/util/List;->size()I

    move-result v8

    const/4 v9, 0x0

    const/4 v10, 0x1

    if-ge v7, v8, :cond_2

    .line 80
    move-object/from16 v8, p5

    invoke-interface {v8, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Landroidx/media3/exoplayer/offline/Download;

    .line 81
    .local v11, "download":Landroidx/media3/exoplayer/offline/Download;
    iget v12, v11, Landroidx/media3/exoplayer/offline/Download;->state:I

    sparse-switch v12, :sswitch_data_0

    goto :goto_1

    .line 83
    :sswitch_0
    const/4 v6, 0x1

    .line 84
    goto :goto_1

    .line 90
    :sswitch_1
    const/4 v4, 0x1

    .line 91
    invoke-virtual {v11}, Landroidx/media3/exoplayer/offline/Download;->getPercentDownloaded()F

    move-result v12

    .line 92
    .local v12, "downloadPercentage":F
    const/high16 v13, -0x40800000    # -1.0f

    cmpl-float v13, v12, v13

    if-eqz v13, :cond_0

    .line 93
    const/4 v2, 0x0

    .line 94
    add-float/2addr v0, v12

    .line 96
    :cond_0
    invoke-virtual {v11}, Landroidx/media3/exoplayer/offline/Download;->getBytesDownloaded()J

    move-result-wide v13

    const-wide/16 v15, 0x0

    cmp-long v13, v13, v15

    if-lez v13, :cond_1

    move v9, v10

    :cond_1
    or-int/2addr v3, v9

    .line 97
    add-int/lit8 v1, v1, 0x1

    .line 98
    goto :goto_1

    .line 86
    .end local v12    # "downloadPercentage":F
    :sswitch_2
    const/4 v5, 0x1

    .line 87
    nop

    .line 79
    .end local v11    # "download":Landroidx/media3/exoplayer/offline/Download;
    :goto_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    :cond_2
    move-object/from16 v8, p5

    .line 109
    .end local v7    # "i":I
    const/4 v7, 0x1

    .line 110
    .local v7, "showProgress":Z
    if-eqz v4, :cond_3

    .line 111
    sget v11, Landroidx/media3/exoplayer/R$string;->exo_download_downloading:I

    move/from16 v22, v11

    .local v11, "titleStringId":I
    goto :goto_2

    .line 112
    .end local v11    # "titleStringId":I
    :cond_3
    if-eqz v5, :cond_6

    if-eqz p6, :cond_6

    .line 113
    const/4 v7, 0x0

    .line 114
    and-int/lit8 v11, p6, 0x2

    if-eqz v11, :cond_4

    .line 117
    sget v11, Landroidx/media3/exoplayer/R$string;->exo_download_paused_for_wifi:I

    move/from16 v22, v11

    .restart local v11    # "titleStringId":I
    goto :goto_2

    .line 118
    .end local v11    # "titleStringId":I
    :cond_4
    and-int/lit8 v11, p6, 0x1

    if-eqz v11, :cond_5

    .line 119
    sget v11, Landroidx/media3/exoplayer/R$string;->exo_download_paused_for_network:I

    move/from16 v22, v11

    .restart local v11    # "titleStringId":I
    goto :goto_2

    .line 121
    .end local v11    # "titleStringId":I
    :cond_5
    sget v11, Landroidx/media3/exoplayer/R$string;->exo_download_paused:I

    move/from16 v22, v11

    .restart local v11    # "titleStringId":I
    goto :goto_2

    .line 123
    .end local v11    # "titleStringId":I
    :cond_6
    if-eqz v6, :cond_7

    .line 124
    sget v11, Landroidx/media3/exoplayer/R$string;->exo_download_removing:I

    move/from16 v22, v11

    .restart local v11    # "titleStringId":I
    goto :goto_2

    .line 127
    .end local v11    # "titleStringId":I
    :cond_7
    const/4 v11, 0x0

    move/from16 v22, v11

    .line 130
    .local v22, "titleStringId":I
    :goto_2
    const/4 v11, 0x0

    .line 131
    .local v11, "maxProgress":I
    const/4 v12, 0x0

    .line 132
    .local v12, "currentProgress":I
    const/4 v13, 0x0

    .line 133
    .local v13, "indeterminateProgress":Z
    if-eqz v7, :cond_a

    .line 134
    const/16 v11, 0x64

    .line 135
    if-eqz v4, :cond_9

    .line 136
    int-to-float v14, v1

    div-float v14, v0, v14

    float-to-int v12, v14

    .line 137
    if-eqz v2, :cond_8

    if-eqz v3, :cond_8

    move v9, v10

    :cond_8
    move v13, v9

    move v9, v11

    move v10, v12

    move/from16 v23, v13

    goto :goto_3

    .line 139
    :cond_9
    const/4 v13, 0x1

    move v9, v11

    move v10, v12

    move/from16 v23, v13

    goto :goto_3

    .line 133
    :cond_a
    move v9, v11

    move v10, v12

    move/from16 v23, v13

    .line 143
    .end local v11    # "maxProgress":I
    .end local v12    # "currentProgress":I
    .end local v13    # "indeterminateProgress":Z
    .local v9, "maxProgress":I
    .local v10, "currentProgress":I
    .local v23, "indeterminateProgress":Z
    :goto_3
    const/16 v20, 0x1

    const/16 v21, 0x0

    move-object/from16 v11, p0

    move-object/from16 v12, p1

    move/from16 v13, p2

    move-object/from16 v14, p3

    move-object/from16 v15, p4

    move/from16 v16, v22

    move/from16 v17, v9

    move/from16 v18, v10

    move/from16 v19, v23

    invoke-direct/range {v11 .. v21}, Landroidx/media3/exoplayer/offline/DownloadNotificationHelper;->buildNotification(Landroid/content/Context;ILandroid/app/PendingIntent;Ljava/lang/String;IIIZZZ)Landroid/app/Notification;

    move-result-object v11

    return-object v11

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_2
        0x2 -> :sswitch_1
        0x5 -> :sswitch_0
        0x7 -> :sswitch_1
    .end sparse-switch
.end method
