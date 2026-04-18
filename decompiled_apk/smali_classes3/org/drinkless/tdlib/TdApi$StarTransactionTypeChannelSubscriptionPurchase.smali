.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionPurchase;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeChannelSubscriptionPurchase"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x380eb3d1


# instance fields
.field public chatId:J

.field public subscriptionPeriod:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32448
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32449
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 32439
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionPurchase;->chatId:J

    .line 32440
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeChannelSubscriptionPurchase;->subscriptionPeriod:I

    .line 32441
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32445
    const v0, 0x380eb3d1

    return v0
.end method
