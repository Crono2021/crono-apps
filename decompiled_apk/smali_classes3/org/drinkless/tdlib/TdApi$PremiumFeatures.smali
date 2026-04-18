.class public Lorg/drinkless/tdlib/TdApi$PremiumFeatures;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumFeatures"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6fc4b43c


# instance fields
.field public features:[Lorg/drinkless/tdlib/TdApi$PremiumFeature;

.field public limits:[Lorg/drinkless/tdlib/TdApi$PremiumLimit;

.field public paymentLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38965
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PremiumFeature;[Lorg/drinkless/tdlib/TdApi$PremiumLimit;Lorg/drinkless/tdlib/TdApi$InternalLinkType;)V
    .locals 0
    .param p1, "premiumFeatureArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumFeature;
    .param p2, "premiumLimitArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumLimit;
    .param p3, "internalLinkType"    # Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 38953
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 38954
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumFeatures;->features:[Lorg/drinkless/tdlib/TdApi$PremiumFeature;

    .line 38955
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PremiumFeatures;->limits:[Lorg/drinkless/tdlib/TdApi$PremiumLimit;

    .line 38956
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PremiumFeatures;->paymentLink:Lorg/drinkless/tdlib/TdApi$InternalLinkType;

    .line 38957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38961
    const v0, 0x6fc4b43c

    return v0
.end method
