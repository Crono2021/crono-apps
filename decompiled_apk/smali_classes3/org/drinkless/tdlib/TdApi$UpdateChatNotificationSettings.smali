.class public Lorg/drinkless/tdlib/TdApi$UpdateChatNotificationSettings;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatNotificationSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2fdf4baa


# instance fields
.field public chatId:J

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34149
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatNotificationSettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 34138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34139
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatNotificationSettings;->chatId:J

    .line 34140
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatNotificationSettings;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 34141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34145
    const v0, -0x2fdf4baa

    return v0
.end method
