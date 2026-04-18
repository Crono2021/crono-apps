.class public Lorg/drinkless/tdlib/TdApi$PaymentFormTypeStarSubscription;
.super Lorg/drinkless/tdlib/TdApi$PaymentFormType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaymentFormTypeStarSubscription"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x102deb5b


# instance fields
.field public pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17700
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 17701
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;)V
    .locals 0
    .param p1, "starSubscriptionPricing"    # Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 17691
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PaymentFormType;-><init>()V

    .line 17692
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaymentFormTypeStarSubscription;->pricing:Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;

    .line 17693
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17697
    const v0, 0x102deb5b

    return v0
.end method
