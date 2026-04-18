.class public Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonRevenueStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x55aeb92e


# instance fields
.field public availableAmount:J

.field public balanceAmount:J

.field public totalAmount:J

.field public withdrawalEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45894
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45895
    return-void
.end method

.method public constructor <init>(JJJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "z8"    # Z

    .line 45882
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45883
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;->totalAmount:J

    .line 45884
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;->balanceAmount:J

    .line 45885
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;->availableAmount:J

    .line 45886
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;->withdrawalEnabled:Z

    .line 45887
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45891
    const v0, -0x55aeb92e

    return v0
.end method
