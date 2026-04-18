.class public Lorg/drinkless/tdlib/TdApi$StarTransactionTypeFragmentWithdrawal;
.super Lorg/drinkless/tdlib/TdApi$StarTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactionTypeFragmentWithdrawal"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x50c5d66e


# instance fields
.field public withdrawalState:Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20149
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;)V
    .locals 0
    .param p1, "revenueWithdrawalState"    # Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;

    .line 20139
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StarTransactionType;-><init>()V

    .line 20140
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactionTypeFragmentWithdrawal;->withdrawalState:Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;

    .line 20141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20145
    const v0, -0x50c5d66e

    return v0
.end method
