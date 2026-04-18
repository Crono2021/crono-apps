.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;
.super Lorg/drinkless/tdlib/TdApi$ChatStatistics;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsSupergroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x10721d9


# instance fields
.field public actionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public dayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public joinBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public joinGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public languageGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public memberCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public memberCountGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public messageContentGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public messageCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public period:Lorg/drinkless/tdlib/TdApi$DateRange;

.field public senderCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public topAdministrators:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsAdministratorActionsInfo;

.field public topInviters:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;

.field public topSenders:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;

.field public viewerCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public weekGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54924
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatistics;-><init>()V

    .line 54925
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DateRange;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;[Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;[Lorg/drinkless/tdlib/TdApi$ChatStatisticsAdministratorActionsInfo;[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;)V
    .locals 16
    .param p1, "dateRange"    # Lorg/drinkless/tdlib/TdApi$DateRange;
    .param p2, "statisticalValue"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p3, "statisticalValue2"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p4, "statisticalValue3"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p5, "statisticalValue4"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p6, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p7, "statisticalGraph2"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p8, "statisticalGraph3"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p9, "statisticalGraph4"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p10, "statisticalGraph5"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p11, "statisticalGraph6"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p12, "statisticalGraph7"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p13, "statisticalGraph8"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p14, "chatStatisticsMessageSenderInfoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;
    .param p15, "chatStatisticsAdministratorActionsInfoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatStatisticsAdministratorActionsInfo;
    .param p16, "chatStatisticsInviterInfoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;

    .line 54900
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$ChatStatistics;-><init>()V

    .line 54901
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->period:Lorg/drinkless/tdlib/TdApi$DateRange;

    .line 54902
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->memberCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 54903
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->messageCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 54904
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->viewerCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 54905
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->senderCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 54906
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->memberCountGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54907
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->joinGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54908
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->joinBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54909
    move-object/from16 v9, p9

    iput-object v9, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->languageGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54910
    move-object/from16 v10, p10

    iput-object v10, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->messageContentGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54911
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->actionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54912
    move-object/from16 v12, p12

    iput-object v12, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->dayGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54913
    move-object/from16 v13, p13

    iput-object v13, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->weekGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 54914
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->topSenders:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsMessageSenderInfo;

    .line 54915
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->topAdministrators:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsAdministratorActionsInfo;

    .line 54916
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsSupergroup;->topInviters:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInviterInfo;

    .line 54917
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54921
    const v0, -0x10721d9

    return v0
.end method
