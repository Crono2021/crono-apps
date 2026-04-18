.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeSponsoredMessageEarnings;
.super Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueTransactionTypeSponsoredMessageEarnings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x71b07b55


# instance fields
.field public endDate:I

.field public startDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 24405
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 24394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 24395
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeSponsoredMessageEarnings;->startDate:I

    .line 24396
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeSponsoredMessageEarnings;->endDate:I

    .line 24397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24401
    const v0, -0x71b07b55

    return v0
.end method
