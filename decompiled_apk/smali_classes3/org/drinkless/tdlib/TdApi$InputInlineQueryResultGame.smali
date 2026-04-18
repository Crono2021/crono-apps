.class public Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultGame;
.super Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInlineQueryResultGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39951fd7


# instance fields
.field public gameShortName:Ljava/lang/String;

.field public id:Ljava/lang/String;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37952
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 37953
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 37941
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResult;-><init>()V

    .line 37942
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultGame;->id:Ljava/lang/String;

    .line 37943
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultGame;->gameShortName:Ljava/lang/String;

    .line 37944
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InputInlineQueryResultGame;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 37945
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37949
    const v0, 0x39951fd7

    return v0
.end method
