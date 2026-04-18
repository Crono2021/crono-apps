.class public Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatRevenueStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x636318bb


# instance fields
.field public revenueAmount:Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;

.field public revenueByHourGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public revenueGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public usdRate:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42822
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42823
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;D)V
    .locals 0
    .param p1, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p2, "statisticalGraph2"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p3, "chatRevenueAmount"    # Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;
    .param p4, "d9"    # D

    .line 42810
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42811
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;->revenueByHourGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 42812
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;->revenueGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 42813
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;->revenueAmount:Lorg/drinkless/tdlib/TdApi$ChatRevenueAmount;

    .line 42814
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ChatRevenueStatistics;->usdRate:D

    .line 42815
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42819
    const v0, 0x636318bb

    return v0
.end method
