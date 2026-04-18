.class public Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNotificationGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5251a122


# instance fields
.field public addedNotifications:[Lorg/drinkless/tdlib/TdApi$Notification;

.field public chatId:J

.field public notificationGroupId:I

.field public notificationSettingsChatId:J

.field public notificationSoundId:J

.field public removedNotificationIds:[I

.field public totalCount:I

.field public type:Lorg/drinkless/tdlib/TdApi$NotificationGroupType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52428
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52429
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$NotificationGroupType;JJJI[Lorg/drinkless/tdlib/TdApi$Notification;[I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "notificationGroupType"    # Lorg/drinkless/tdlib/TdApi$NotificationGroupType;
    .param p3, "j5"    # J
    .param p5, "j9"    # J
    .param p7, "j10"    # J
    .param p9, "i10"    # I
    .param p10, "notificationArr"    # [Lorg/drinkless/tdlib/TdApi$Notification;
    .param p11, "iArr"    # [I

    .line 52412
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52413
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->notificationGroupId:I

    .line 52414
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->type:Lorg/drinkless/tdlib/TdApi$NotificationGroupType;

    .line 52415
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->chatId:J

    .line 52416
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->notificationSettingsChatId:J

    .line 52417
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->notificationSoundId:J

    .line 52418
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->totalCount:I

    .line 52419
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->addedNotifications:[Lorg/drinkless/tdlib/TdApi$Notification;

    .line 52420
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$UpdateNotificationGroup;->removedNotificationIds:[I

    .line 52421
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52425
    const v0, 0x5251a122

    return v0
.end method
