.class public Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumFeaturePromotionAnimation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x766254e4


# instance fields
.field public animation:Lorg/drinkless/tdlib/TdApi$Animation;

.field public feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29369
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PremiumFeature;Lorg/drinkless/tdlib/TdApi$Animation;)V
    .locals 0
    .param p1, "premiumFeature"    # Lorg/drinkless/tdlib/TdApi$PremiumFeature;
    .param p2, "animation"    # Lorg/drinkless/tdlib/TdApi$Animation;

    .line 29358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29359
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;->feature:Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 29360
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumFeaturePromotionAnimation;->animation:Lorg/drinkless/tdlib/TdApi$Animation;

    .line 29361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29365
    const v0, -0x766254e4

    return v0
.end method
