.class public Lorg/drinkless/tdlib/TdApi$SuggestedPostPriceTon;
.super Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedPostPriceTon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4147c43e


# instance fields
.field public toncoinCentCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;-><init>()V

    .line 20635
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20625
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;-><init>()V

    .line 20626
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostPriceTon;->toncoinCentCount:J

    .line 20627
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20631
    const v0, -0x4147c43e

    return v0
.end method
