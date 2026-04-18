.class public Lorg/drinkless/tdlib/TdApi$StarRevenueStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarRevenueStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42d26da9


# instance fields
.field public revenueByDayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public status:Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;

.field public usdRate:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40615
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;D)V
    .locals 0
    .param p1, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p2, "starRevenueStatus"    # Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;
    .param p3, "d9"    # D

    .line 40603
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40604
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatistics;->revenueByDayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 40605
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatistics;->status:Lorg/drinkless/tdlib/TdApi$StarRevenueStatus;

    .line 40606
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StarRevenueStatistics;->usdRate:D

    .line 40607
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40611
    const v0, -0x42d26da9

    return v0
.end method
