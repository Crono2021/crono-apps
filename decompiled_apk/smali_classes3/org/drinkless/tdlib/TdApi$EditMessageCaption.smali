.class public Lorg/drinkless/tdlib/TdApi$EditMessageCaption;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditMessageCaption"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x78688dbf


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public chatId:J

.field public messageId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public showCaptionAboveMedia:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47151
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p7, "z8"    # Z

    .line 47137
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47138
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditMessageCaption;->chatId:J

    .line 47139
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$EditMessageCaption;->messageId:J

    .line 47140
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditMessageCaption;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 47141
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditMessageCaption;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 47142
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$EditMessageCaption;->showCaptionAboveMedia:Z

    .line 47143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47147
    const v0, -0x78688dbf

    return v0
.end method
