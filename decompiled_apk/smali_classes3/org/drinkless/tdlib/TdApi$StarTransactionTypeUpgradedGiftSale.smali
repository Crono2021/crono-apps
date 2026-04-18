.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeUpgradedGiftSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeUpgradedGiftSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2cfb3195


# instance fields
.field public commissionPerMille:I

.field public commissionStarAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45486
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45487
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UpgradedGift;ILorg/drinkless/tdlib/TdApi$StarAmount;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p4, "i9"    # I
    .param p5, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 45474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 45475
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeUpgradedGiftSale;->userId:J

    .line 45476
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeUpgradedGiftSale;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 45477
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeUpgradedGiftSale;->commissionPerMille:I

    .line 45478
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeUpgradedGiftSale;->commissionStarAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 45479
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45483
    const v0, 0x2cfb3195

    return v0
.end method
