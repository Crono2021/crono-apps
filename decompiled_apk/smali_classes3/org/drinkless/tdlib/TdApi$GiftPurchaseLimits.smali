.class public Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftPurchaseLimits"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x61185759


# instance fields
.field public remainingCount:I

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26925
    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I

    .line 26914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26915
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;->totalCount:I

    .line 26916
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GiftPurchaseLimits;->remainingCount:I

    .line 26917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26921
    const v0, -0x61185759

    return v0
.end method
