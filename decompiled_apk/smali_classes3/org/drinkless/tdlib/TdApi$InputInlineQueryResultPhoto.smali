.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42f4c9e1


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public photoHeight:I

.field public photoUrl:Ljava/lang/String;

.field public photoWidth:I

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailUrl:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52732
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52733
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

    .line 52715
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52716
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->id:Ljava/lang/String;

    .line 52717
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->title:Ljava/lang/String;

    .line 52718
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->description:Ljava/lang/String;

    .line 52719
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->thumbnailUrl:Ljava/lang/String;

    .line 52720
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->photoUrl:Ljava/lang/String;

    .line 52721
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->photoWidth:I

    .line 52722
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->photoHeight:I

    .line 52723
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52724
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultPhoto;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52725
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52729
    const v0, -0x42f4c9e1

    return v0
.end method
