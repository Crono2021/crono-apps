.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x708341aa


# instance fields
.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public livePeriod:I

.field public location:Lorg/drinkless/tdlib/TdApi$Location;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailHeight:I

.field public thumbnailUrl:Ljava/lang/String;

.field public thumbnailWidth:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52698
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52699
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Location;ILjava/lang/String;Ljava/lang/String;IILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p3, "i9"    # I
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "str3"    # Ljava/lang/String;
    .param p6, "i10"    # I
    .param p7, "i11"    # I
    .param p8, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p9, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52681
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 52682
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->id:Ljava/lang/String;

    .line 52683
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 52684
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->livePeriod:I

    .line 52685
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->title:Ljava/lang/String;

    .line 52686
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->thumbnailUrl:Ljava/lang/String;

    .line 52687
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->thumbnailWidth:I

    .line 52688
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->thumbnailHeight:I

    .line 52689
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52690
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultLocation;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 52691
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52695
    const v0, -0x708341aa

    return v0
.end method
