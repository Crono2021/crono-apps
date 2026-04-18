.class public Lorg/drinkless/tdlib/TdApi$DiceStickersRegular;
.super Lorg/drinkless/tdlib/TdApi$DiceStickers;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DiceStickersRegular"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c201332


# instance fields
.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11544
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DiceStickers;-><init>()V

    .line 11545
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 11535
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DiceStickers;-><init>()V

    .line 11536
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DiceStickersRegular;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 11537
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11541
    const v0, -0x2c201332

    return v0
.end method
