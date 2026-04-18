.class public Lorg/drinkless/tdlib/TdApi$EditMessageText;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditMessageText"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xbb2e1b7


# instance fields
.field public chatId:J

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43207
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p6, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 43194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43195
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditMessageText;->chatId:J

    .line 43196
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$EditMessageText;->messageId:J

    .line 43197
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditMessageText;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 43198
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditMessageText;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 43199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43203
    const v0, 0xbb2e1b7

    return v0
.end method
