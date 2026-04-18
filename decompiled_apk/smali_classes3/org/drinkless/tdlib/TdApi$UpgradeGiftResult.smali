.class public Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradeGiftResult"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3986f34a


# instance fields
.field public canBeTransferred:Z

.field public dropOriginalDetailsStarCount:J

.field public exportDate:I

.field public gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

.field public isSaved:Z

.field public nextResaleDate:I

.field public nextTransferDate:I

.field public receivedGiftId:Ljava/lang/String;

.field public transferStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53106
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53107
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$UpgradedGift;Ljava/lang/String;ZZJJIII)V
    .locals 0
    .param p1, "upgradedGift"    # Lorg/drinkless/tdlib/TdApi$UpgradedGift;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "j5"    # J
    .param p7, "j9"    # J
    .param p9, "i9"    # I
    .param p10, "i10"    # I
    .param p11, "i11"    # I

    .line 53089
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53090
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->gift:Lorg/drinkless/tdlib/TdApi$UpgradedGift;

    .line 53091
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->receivedGiftId:Ljava/lang/String;

    .line 53092
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->isSaved:Z

    .line 53093
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->canBeTransferred:Z

    .line 53094
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->transferStarCount:J

    .line 53095
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->dropOriginalDetailsStarCount:J

    .line 53096
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->nextTransferDate:I

    .line 53097
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->nextResaleDate:I

    .line 53098
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$UpgradeGiftResult;->exportDate:I

    .line 53099
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53103
    const v0, 0x3986f34a

    return v0
.end method
