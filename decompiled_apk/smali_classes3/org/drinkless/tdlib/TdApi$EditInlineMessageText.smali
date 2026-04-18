.class public Lorg/drinkless/tdlib/TdApi$EditInlineMessageText;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditInlineMessageText"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x32fd3e1b


# instance fields
.field public inlineMessageId:Ljava/lang/String;

.field public inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36762
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36763
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
    .param p3, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 36751
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36752
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageText;->inlineMessageId:Ljava/lang/String;

    .line 36753
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageText;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 36754
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditInlineMessageText;->inputMessageContent:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 36755
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36759
    const v0, -0x32fd3e1b

    return v0
.end method
