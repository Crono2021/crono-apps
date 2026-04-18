.class public Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumSubscription;
.super Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StorePaymentPurposePremiumSubscription"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b558114


# instance fields
.field public isRestore:Z

.field public isUpgrade:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 32749
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 32738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StorePaymentPurpose;-><init>()V

    .line 32739
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumSubscription;->isRestore:Z

    .line 32740
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$StorePaymentPurposePremiumSubscription;->isUpgrade:Z

    .line 32741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32745
    const v0, 0x4b558114    # 1.3992212E7f

    return v0
.end method
