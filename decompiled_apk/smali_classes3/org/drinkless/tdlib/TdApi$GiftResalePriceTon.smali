.class public Lorg/drinkless/tdlib/TdApi$GiftResalePriceTon;
.super Lorg/drinkless/tdlib/TdApi$GiftResalePrice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftResalePriceTon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x18c30cae


# instance fields
.field public toncoinCentCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResalePrice;-><init>()V

    .line 14065
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14055
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResalePrice;-><init>()V

    .line 14056
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiftResalePriceTon;->toncoinCentCount:J

    .line 14057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14061
    const v0, -0x18c30cae

    return v0
.end method
