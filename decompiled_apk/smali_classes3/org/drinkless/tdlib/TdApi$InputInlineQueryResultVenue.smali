.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultVenue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2049c13d


# instance fields
.field public id:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public thumbnailHeight:I

.field public thumbnailUrl:Ljava/lang/String;

.field public thumbnailWidth:I

.field public venue:Lorg/drinkless/tdlib/TdApi$Venue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51494
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51495
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Venue;Ljava/lang/String;IILorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "venue"    # Lorg/drinkless/tdlib/TdApi$Venue;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51479
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 51480
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->id:Ljava/lang/String;

    .line 51481
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->venue:Lorg/drinkless/tdlib/TdApi$Venue;

    .line 51482
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->thumbnailUrl:Ljava/lang/String;

    .line 51483
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->thumbnailWidth:I

    .line 51484
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->thumbnailHeight:I

    .line 51485
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 51486
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultVenue;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51487
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51491
    const v0, 0x2049c13d

    return v0
.end method
