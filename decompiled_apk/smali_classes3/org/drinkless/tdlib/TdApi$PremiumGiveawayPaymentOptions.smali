.class public Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOptions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumGiveawayPaymentOptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5e9dc4bf


# instance fields
.field public options:[Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17826
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17827
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;)V
    .locals 0
    .param p1, "premiumGiveawayPaymentOptionArr"    # [Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;

    .line 17817
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17818
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOptions;->options:[Lorg/drinkless/tdlib/TdApi$PremiumGiveawayPaymentOption;

    .line 17819
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17823
    const v0, -0x5e9dc4bf

    return v0
.end method
