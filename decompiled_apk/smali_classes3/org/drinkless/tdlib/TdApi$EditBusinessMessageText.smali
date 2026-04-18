.class public Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessMessageText"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x447eee64


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47099
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 47085
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47086
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;->businessConnectionId:Ljava/lang/String;

    .line 47087
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;->chatId:J

    .line 47088
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;->messageId:J

    .line 47089
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 47090
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageText;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 47091
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47095
    const v0, -0x447eee64

    return v0
.end method
