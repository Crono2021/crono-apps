.class public Lorg/drinkless/tdlib/TdApi$MessageDice;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageDice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42817239


# instance fields
.field public emoji:Ljava/lang/String;

.field public finalState:Lorg/drinkless/tdlib/TdApi$DiceStickers;

.field public initialState:Lorg/drinkless/tdlib/TdApi$DiceStickers;

.field public successAnimationFrameNumber:I

.field public value:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48035
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DiceStickers;Lorg/drinkless/tdlib/TdApi$DiceStickers;Ljava/lang/String;II)V
    .locals 0
    .param p1, "diceStickers"    # Lorg/drinkless/tdlib/TdApi$DiceStickers;
    .param p2, "diceStickers2"    # Lorg/drinkless/tdlib/TdApi$DiceStickers;
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "i10"    # I

    .line 48021
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 48022
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageDice;->initialState:Lorg/drinkless/tdlib/TdApi$DiceStickers;

    .line 48023
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageDice;->finalState:Lorg/drinkless/tdlib/TdApi$DiceStickers;

    .line 48024
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageDice;->emoji:Ljava/lang/String;

    .line 48025
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$MessageDice;->value:I

    .line 48026
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$MessageDice;->successAnimationFrameNumber:I

    .line 48027
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48031
    const v0, 0x42817239

    return v0
.end method
