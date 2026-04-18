.class public Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarSubscriptionPricing"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x695d77aa


# instance fields
.field public period:I

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32309
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 32298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32299
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;->period:I

    .line 32300
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$StarSubscriptionPricing;->starCount:J

    .line 32301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32305
    const v0, -0x695d77aa

    return v0
.end method
