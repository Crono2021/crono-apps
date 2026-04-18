.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x10550459


# instance fields
.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public stickerHeight:I

.field public stickerUrl:Ljava/lang/String;

.field public stickerWidth:I

.field public thumbnailUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51464
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51465
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51450
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->id:Ljava/lang/String;

    .line 51451
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->thumbnailUrl:Ljava/lang/String;

    .line 51452
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->stickerUrl:Ljava/lang/String;

    .line 51453
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->stickerWidth:I

    .line 51454
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->stickerHeight:I

    .line 51455
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 51456
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultSticker;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51457
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51461
    const v0, 0x10550459

    return v0
.end method
