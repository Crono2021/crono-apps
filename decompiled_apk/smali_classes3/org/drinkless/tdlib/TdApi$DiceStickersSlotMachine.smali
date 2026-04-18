.class public Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;
.super Lorg/drinkless/tdlib/TdApi$DiceStickers;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DiceStickersSlotMachine"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x165d7354


# instance fields
.field public background:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public centerReel:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public leftReel:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public lever:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public rightReel:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DiceStickers;-><init>()V

    .line 46943
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p2, "sticker2"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p3, "sticker3"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p4, "sticker4"    # Lorg/drinkless/tdlib/TdApi$Sticker;
    .param p5, "sticker5"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46929
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DiceStickers;-><init>()V

    .line 46930
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;->background:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46931
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;->lever:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46932
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;->leftReel:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46933
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;->centerReel:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46934
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersSlotMachine;->rightReel:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 46935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46939
    const v0, -0x165d7354

    return v0
.end method
