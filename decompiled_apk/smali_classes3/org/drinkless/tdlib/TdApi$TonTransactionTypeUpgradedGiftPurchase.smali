.class public Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftPurchase;
.super Lorg/drinkless/tdlib/TdApi$TonTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransactionTypeUpgradedGiftPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x77a5f463


# instance fields
.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 33609
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UpgradedGift;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 33598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 33599
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftPurchase;->userId:J

    .line 33600
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftPurchase;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 33601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33605
    const v0, -0x77a5f463

    return v0
.end method
