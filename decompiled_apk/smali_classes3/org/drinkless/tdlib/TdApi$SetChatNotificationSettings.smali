.class public Lorg/drinkless/tdlib/TdApi$SetChatNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatNotificationSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2e531ffe


# instance fields
.field public chatId:J

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31329
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatNotificationSettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 31318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31319
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatNotificationSettings;->chatId:J

    .line 31320
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 31321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31325
    const v0, 0x2e531ffe

    return v0
.end method
