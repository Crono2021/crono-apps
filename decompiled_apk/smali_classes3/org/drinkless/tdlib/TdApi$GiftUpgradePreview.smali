.class public Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftUpgradePreview"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13ab95a9


# instance fields
.field public backdrops:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

.field public models:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

.field public nextPrices:[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;

.field public prices:[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;

.field public symbols:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47645
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;)V
    .locals 0
    .param p1, "upgradedGiftModelArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;
    .param p2, "upgradedGiftSymbolArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;
    .param p3, "upgradedGiftBackdropArr"    # [Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;
    .param p4, "giftUpgradePriceArr"    # [Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;
    .param p5, "giftUpgradePriceArr2"    # [Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;

    .line 47631
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 47632
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;->models:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftModel;

    .line 47633
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;->symbols:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftSymbol;

    .line 47634
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;->backdrops:[Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdrop;

    .line 47635
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;->prices:[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;

    .line 47636
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePreview;->nextPrices:[Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;

    .line 47637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47641
    const v0, -0x13ab95a9

    return v0
.end method
