.class public Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessMessageCaption"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessage;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fdebd3d


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public chatId:J

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public showCaptionAboveMedia:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49619
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "j9"    # J
    .param p6, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p7, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p8, "z8"    # Z

    .line 49604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49605
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->businessConnectionId:Ljava/lang/String;

    .line 49606
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->chatId:J

    .line 49607
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->messageId:J

    .line 49608
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 49609
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 49610
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessMessageCaption;->showCaptionAboveMedia:Z

    .line 49611
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49615
    const v0, -0x3fdebd3d

    return v0
.end method
