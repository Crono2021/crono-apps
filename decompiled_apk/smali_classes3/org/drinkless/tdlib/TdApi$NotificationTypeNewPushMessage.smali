.class public Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;
.super Lorg/drinkless/tdlib/TdApi$NotificationType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationTypeNewPushMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2a6b61ce


# instance fields
.field public content:Lorg/drinkless/tdlib/TdApi$PushMessageContent;

.field public isOutgoing:Z

.field public messageId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public senderName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48268
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NotificationType;-><init>()V

    .line 48269
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$PushMessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "z8"    # Z
    .param p6, "pushMessageContent"    # Lorg/drinkless/tdlib/TdApi$PushMessageContent;

    .line 48255
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NotificationType;-><init>()V

    .line 48256
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;->messageId:J

    .line 48257
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48258
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;->senderName:Ljava/lang/String;

    .line 48259
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;->isOutgoing:Z

    .line 48260
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$NotificationTypeNewPushMessage;->content:Lorg/drinkless/tdlib/TdApi$PushMessageContent;

    .line 48261
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48265
    const v0, -0x2a6b61ce

    return v0
.end method
