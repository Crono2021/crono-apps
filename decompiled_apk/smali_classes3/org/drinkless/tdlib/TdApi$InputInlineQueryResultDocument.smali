.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x227fd0cd


# instance fields
.field public description:Ljava/lang/String;

.field public documentUrl:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public mimeType:Ljava/lang/String;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailHeight:I

.field public thumbnailUrl:Ljava/lang/String;

.field public thumbnailWidth:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53312
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53313
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "str6"    # Ljava/lang/String;
    .param p7, "i9"    # I
    .param p8, "i10"    # I
    .param p9, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p10, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 53294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53295
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->id:Ljava/lang/String;

    .line 53296
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->title:Ljava/lang/String;

    .line 53297
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->description:Ljava/lang/String;

    .line 53298
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->documentUrl:Ljava/lang/String;

    .line 53299
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->mimeType:Ljava/lang/String;

    .line 53300
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->thumbnailUrl:Ljava/lang/String;

    .line 53301
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->thumbnailWidth:I

    .line 53302
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->thumbnailHeight:I

    .line 53303
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 53304
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultDocument;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 53305
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53309
    const v0, 0x227fd0cd

    return v0
.end method
