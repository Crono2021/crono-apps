.class public Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewInlineCallbackQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1306cb46


# instance fields
.field public chatInstance:J

.field public id:J

.field public inlineMessageId:Ljava/lang/String;

.field public payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

.field public senderUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 49205
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;JLorg/drinkless/tdlib/TdApi$CallbackQueryPayload;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "j10"    # J
    .param p8, "callbackQueryPayload"    # Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 49191
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 49192
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;->id:J

    .line 49193
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;->senderUserId:J

    .line 49194
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;->inlineMessageId:Ljava/lang/String;

    .line 49195
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;->chatInstance:J

    .line 49196
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineCallbackQuery;->payload:Lorg/drinkless/tdlib/TdApi$CallbackQueryPayload;

    .line 49197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49201
    const v0, -0x1306cb46

    return v0
.end method
