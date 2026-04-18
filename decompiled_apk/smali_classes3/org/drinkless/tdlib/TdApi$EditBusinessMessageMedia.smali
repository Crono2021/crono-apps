.class public Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessMessageMedia"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x39eb888


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47072
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47073
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 47059
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47060
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;->businessConnectionId:Ljava/lang/String;

    .line 47061
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;->chatId:J

    .line 47062
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;->messageId:J

    .line 47063
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 47064
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageMedia;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 47065
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47069
    const v0, -0x39eb888

    return v0
.end method
