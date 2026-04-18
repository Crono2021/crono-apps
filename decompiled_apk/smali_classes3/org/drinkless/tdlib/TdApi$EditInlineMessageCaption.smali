.class public Lorg/drinkless/tdlib/TdApi$EditInlineMessageCaption;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditInlineMessageCaption"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x540744f8


# instance fields
.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public inlineMessageId:Ljava/lang/String;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public showCaptionAboveMedia:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43135
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$FormattedText;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "z8"    # Z

    .line 43122
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43123
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageCaption;->inlineMessageId:Ljava/lang/String;

    .line 43124
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageCaption;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 43125
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageCaption;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 43126
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageCaption;->showCaptionAboveMedia:Z

    .line 43127
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43131
    const v0, 0x540744f8

    return v0
.end method
