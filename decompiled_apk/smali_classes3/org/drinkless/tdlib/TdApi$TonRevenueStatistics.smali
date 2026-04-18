.class public Lorg/drinkless/tdlib/TdApi$TonRevenueStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TonRevenueStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x21bb761a


# instance fields
.field public revenueByDayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public status:Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;

.field public usdRate:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41296
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41297
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;D)V
    .locals 0
    .param p1, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p2, "tonRevenueStatus"    # Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;
    .param p3, "d9"    # D

    .line 41285
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41286
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatistics;->revenueByDayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 41287
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatistics;->status:Lorg/drinkless/tdlib/TdApi$TonRevenueStatus;

    .line 41288
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$TonRevenueStatistics;->usdRate:D

    .line 41289
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41293
    const v0, 0x21bb761a

    return v0
.end method
