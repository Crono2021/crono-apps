.class public Lorg/drinkless/tdlib/TdApi$GetChatNotificationSettingsExceptions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatNotificationSettingsExceptions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chats;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xbfe0e11


# instance fields
.field public compareSound:Z

.field public scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25864
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25865
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;Z)V
    .locals 0
    .param p1, "notificationSettingsScope"    # Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;
    .param p2, "z8"    # Z

    .line 25854
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25855
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatNotificationSettingsExceptions;->scope:Lorg/drinkless/tdlib/TdApi$NotificationSettingsScope;

    .line 25856
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$GetChatNotificationSettingsExceptions;->compareSound:Z

    .line 25857
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25861
    const v0, 0xbfe0e11

    return v0
.end method
