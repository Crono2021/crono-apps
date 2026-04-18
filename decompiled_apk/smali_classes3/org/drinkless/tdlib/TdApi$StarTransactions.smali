.class public Lorg/drinkless/tdlib/TdApi$StarTransactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarTransactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x489fe2e3


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public transactions:[Lorg/drinkless/tdlib/TdApi$StarTransaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40724
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40725
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarAmount;[Lorg/drinkless/tdlib/TdApi$StarTransaction;Ljava/lang/String;)V
    .locals 0
    .param p1, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p2, "starTransactionArr"    # [Lorg/drinkless/tdlib/TdApi$StarTransaction;
    .param p3, "str"    # Ljava/lang/String;

    .line 40713
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40714
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarTransactions;->starAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 40715
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarTransactions;->transactions:[Lorg/drinkless/tdlib/TdApi$StarTransaction;

    .line 40716
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarTransactions;->nextOffset:Ljava/lang/String;

    .line 40717
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40721
    const v0, 0x489fe2e3

    return v0
.end method
