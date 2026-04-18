.class public Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftSale;
.super Lorg/drinkless/tdlib/TdApi$TonTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonTransactionTypeUpgradedGiftSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59d5fb20


# instance fields
.field public commissionPerMille:I

.field public commissionToncoinAmount:J

.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45918
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 45919
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UpgradedGift;IJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p4, "i9"    # I
    .param p5, "j9"    # J

    .line 45906
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TonTransactionType;-><init>()V

    .line 45907
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftSale;->userId:J

    .line 45908
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftSale;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 45909
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftSale;->commissionPerMille:I

    .line 45910
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$TonTransactionTypeUpgradedGiftSale;->commissionToncoinAmount:J

    .line 45911
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45915
    const v0, -0x59d5fb20

    return v0
.end method
