.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeFragmentRefund;
.super Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueTransactionTypeFragmentRefund"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58bbac01


# instance fields
.field public refundDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 10339
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 10329
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 10330
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeFragmentRefund;->refundDate:I

    .line 10331
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10335
    const v0, -0x58bbac01

    return v0
.end method
