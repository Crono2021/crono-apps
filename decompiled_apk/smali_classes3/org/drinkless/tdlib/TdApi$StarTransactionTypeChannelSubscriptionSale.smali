.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionSale;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelSubscriptionSale"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1ed837e


# instance fields
.field public subscriptionPeriod:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32469
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32459
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionSale;->userId:J

    .line 32460
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionSale;->subscriptionPeriod:I

    .line 32461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32465
    const v0, -0x1ed837e

    return v0
.end method
