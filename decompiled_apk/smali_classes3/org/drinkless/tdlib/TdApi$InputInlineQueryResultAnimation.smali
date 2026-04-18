.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58ccadea


# instance fields
.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailMimeType:Ljava/lang/String;

.field public thumbnailUrl:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public videoDuration:I

.field public videoHeight:I

.field public videoMimeType:Ljava/lang/String;

.field public videoUrl:Ljava/lang/String;

.field public videoWidth:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53679
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "str6"    # Ljava/lang/String;
    .param p7, "i9"    # I
    .param p8, "i10"    # I
    .param p9, "i11"    # I
    .param p10, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p11, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 53659
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53660
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->id:Ljava/lang/String;

    .line 53661
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->title:Ljava/lang/String;

    .line 53662
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->thumbnailUrl:Ljava/lang/String;

    .line 53663
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->thumbnailMimeType:Ljava/lang/String;

    .line 53664
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->videoUrl:Ljava/lang/String;

    .line 53665
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->videoMimeType:Ljava/lang/String;

    .line 53666
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->videoDuration:I

    .line 53667
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->videoWidth:I

    .line 53668
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->videoHeight:I

    .line 53669
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 53670
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultAnimation;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 53671
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53675
    const v0, -0x58ccadea

    return v0
.end method
