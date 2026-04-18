.class public Lorg/drinkless/tdlib/TdApi$GetCallbackQueryMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCallbackQueryMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42df6e8e


# instance fields
.field public callbackQueryId:J

.field public chatId:J

.field public messageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37202
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37203
    return-void
.end method

.method public constructor <init>(JJJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J

    .line 37191
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37192
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryMessage;->chatId:J

    .line 37193
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryMessage;->messageId:J

    .line 37194
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetCallbackQueryMessage;->callbackQueryId:J

    .line 37195
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37199
    const v0, -0x42df6e8e

    return v0
.end method
