.class public Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;
.super Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReplyMarkupShowKeyboard"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2f2d4530


# instance fields
.field public inputFieldPlaceholder:Ljava/lang/String;

.field public isPersistent:Z

.field public isPersonal:Z

.field public oneTime:Z

.field public resizeKeyboard:Z

.field public rows:[[Lorg/drinkless/tdlib/TdApi$KeyboardButton;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50570
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 50571
    return-void
.end method

.method public constructor <init>([[Lorg/drinkless/tdlib/TdApi$KeyboardButton;ZZZZLjava/lang/String;)V
    .locals 0
    .param p1, "keyboardButtonArr"    # [[Lorg/drinkless/tdlib/TdApi$KeyboardButton;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "str"    # Ljava/lang/String;

    .line 50556
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 50557
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->rows:[[Lorg/drinkless/tdlib/TdApi$KeyboardButton;

    .line 50558
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->isPersistent:Z

    .line 50559
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->resizeKeyboard:Z

    .line 50560
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->oneTime:Z

    .line 50561
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->isPersonal:Z

    .line 50562
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupShowKeyboard;->inputFieldPlaceholder:Ljava/lang/String;

    .line 50563
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50567
    const v0, -0x2f2d4530

    return v0
.end method
