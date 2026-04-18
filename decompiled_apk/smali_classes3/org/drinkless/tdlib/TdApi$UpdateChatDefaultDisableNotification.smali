.class public Lorg/drinkless/tdlib/TdApi$UpdateChatDefaultDisableNotification;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatDefaultDisableNotification"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1ba96a9b


# instance fields
.field public chatId:J

.field public defaultDisableNotification:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33988
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33989
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33979
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatDefaultDisableNotification;->chatId:J

    .line 33980
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatDefaultDisableNotification;->defaultDisableNotification:Z

    .line 33981
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33985
    const v0, 0x1ba96a9b

    return v0
.end method
