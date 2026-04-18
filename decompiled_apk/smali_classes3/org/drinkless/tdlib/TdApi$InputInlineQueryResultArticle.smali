.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultArticle"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x763583bc


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailHeight:I

.field public thumbnailUrl:Ljava/lang/String;

.field public thumbnailWidth:I

.field public title:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52665
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "i9"    # I
    .param p7, "i10"    # I
    .param p8, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p9, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52647
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52648
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->id:Ljava/lang/String;

    .line 52649
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->url:Ljava/lang/String;

    .line 52650
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->title:Ljava/lang/String;

    .line 52651
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->description:Ljava/lang/String;

    .line 52652
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->thumbnailUrl:Ljava/lang/String;

    .line 52653
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->thumbnailWidth:I

    .line 52654
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->thumbnailHeight:I

    .line 52655
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52656
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultArticle;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52661
    const v0, 0x763583bc

    return v0
.end method
