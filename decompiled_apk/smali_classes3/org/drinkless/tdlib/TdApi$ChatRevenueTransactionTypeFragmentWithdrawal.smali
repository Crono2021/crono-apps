.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeFragmentWithdrawal;
.super Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueTransactionTypeFragmentWithdrawal"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x137ff8cb


# instance fields
.field public state:Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;

.field public withdrawalDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 24385
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "revenueWithdrawalState"    # Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;

    .line 24374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionType;-><init>()V

    .line 24375
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeFragmentWithdrawal;->withdrawalDate:I

    .line 24376
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueTransactionTypeFragmentWithdrawal;->state:Lorg/drinkless/tdlib/TdApi$RevenueWithdrawalState;

    .line 24377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24381
    const v0, 0x137ff8cb

    return v0
.end method
