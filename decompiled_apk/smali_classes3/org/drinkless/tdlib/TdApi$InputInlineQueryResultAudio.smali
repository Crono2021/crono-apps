.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b1c35d4


# instance fields
.field public audioDuration:I

.field public audioUrl:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public performer:Ljava/lang/String;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51405
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51389
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51390
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->id:Ljava/lang/String;

    .line 51391
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->title:Ljava/lang/String;

    .line 51392
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->performer:Ljava/lang/String;

    .line 51393
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->audioUrl:Ljava/lang/String;

    .line 51394
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->audioDuration:I

    .line 51395
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 51396
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAudio;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51401
    const v0, 0x4b1c35d4    # 1.0237396E7f

    return v0
.end method
