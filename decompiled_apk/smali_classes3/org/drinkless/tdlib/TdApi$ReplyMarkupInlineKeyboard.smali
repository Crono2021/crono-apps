.class public Lorg/drinkless/tdlib/TdApi$ReplyMarkupInlineKeyboard;
.super Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReplyMarkupInlineKeyboard"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x24ea099a


# instance fields
.field public rows:[[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18726
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 18727
    return-void
.end method

.method public constructor <init>([[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;)V
    .locals 0
    .param p1, "inlineKeyboardButtonArr"    # [[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;

    .line 18717
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 18718
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupInlineKeyboard;->rows:[[Lorg/drinkless/tdlib/TdApi$InlineKeyboardButton;

    .line 18719
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18723
    const v0, -0x24ea099a

    return v0
.end method
