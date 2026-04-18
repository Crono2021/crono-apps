.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x66c344e7


# instance fields
.field public description:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public mimeType:Ljava/lang/String;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailUrl:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public videoDuration:I

.field public videoHeight:I

.field public videoUrl:Ljava/lang/String;

.field public videoWidth:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53716
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53717
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

    .line 53697
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 53698
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->id:Ljava/lang/String;

    .line 53699
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->title:Ljava/lang/String;

    .line 53700
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->description:Ljava/lang/String;

    .line 53701
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->thumbnailUrl:Ljava/lang/String;

    .line 53702
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->videoUrl:Ljava/lang/String;

    .line 53703
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->mimeType:Ljava/lang/String;

    .line 53704
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->videoWidth:I

    .line 53705
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->videoHeight:I

    .line 53706
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->videoDuration:I

    .line 53707
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 53708
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVideo;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 53709
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53713
    const v0, 0x66c344e7

    return v0
.end method
