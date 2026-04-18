.class public Lorg/drinkless/tdlib/TdApi$ToggleChatGiftNotifications;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatGiftNotifications"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7b58fba2


# instance fields
.field public areEnabled:Z

.field public chatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33089
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33079
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatGiftNotifications;->chatId:J

    .line 33080
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatGiftNotifications;->areEnabled:Z

    .line 33081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33085
    const v0, -0x7b58fba2

    return v0
.end method
