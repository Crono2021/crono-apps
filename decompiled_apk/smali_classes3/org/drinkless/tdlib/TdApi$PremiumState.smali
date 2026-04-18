.class public Lorg/drinkless/tdlib/TdApi$PremiumState;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x699fd402


# instance fields
.field public animations:[Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;

.field public businessAnimations:[Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;

.field public paymentOptions:[Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;

.field public state:Lorg/drinkless/tdlib/TdApi$FormattedText;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44695
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;[Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;[Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;[Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "premiumStatePaymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;
    .param p3, "premiumFeaturePromotionAnimationArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;
    .param p4, "businessFeaturePromotionAnimationArr"    # [Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;

    .line 44682
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44683
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumState;->state:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 44684
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumState;->paymentOptions:[Lorg/drinkless/tdlib/TdApi$PremiumStatePaymentOption;

    .line 44685
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PremiumState;->animations:[Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;

    .line 44686
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PremiumState;->businessAnimations:[Lorg/drinkless/tdlib/TdApi$BusinessFeaturePromotionAnimation;

    .line 44687
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44691
    const v0, 0x699fd402

    return v0
.end method
