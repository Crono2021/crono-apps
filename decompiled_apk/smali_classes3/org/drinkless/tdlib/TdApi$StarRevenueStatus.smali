.class public Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarRevenueStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x779532e8


# instance fields
.field public availableAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public currentAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public nextWithdrawalIn:I

.field public totalAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

.field public withdrawalEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48840
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48841
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StarAmount;Lorg/drinkless/tdlib/TdApi$StarAmount;Lorg/drinkless/tdlib/TdApi$StarAmount;ZI)V
    .locals 0
    .param p1, "starAmount"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p2, "starAmount2"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p3, "starAmount3"    # Lorg/drinkless/tdlib/TdApi$StarAmount;
    .param p4, "z8"    # Z
    .param p5, "i9"    # I

    .line 48827
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48828
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;->totalAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 48829
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;->currentAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 48830
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;->availableAmount:Lorg/drinkless/tdlib/TdApi$StarAmount;

    .line 48831
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;->withdrawalEnabled:Z

    .line 48832
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;->nextWithdrawalIn:I

    .line 48833
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48837
    const v0, 0x779532e8

    return v0
.end method
