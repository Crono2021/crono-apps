.class public Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;
.super Lorg/drinkless/tdlib/TdApi$ChatStatistics;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatStatisticsChannel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x51f7262c


# instance fields
.field public enabledNotificationsPercentage:D

.field public instantViewInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public joinBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public joinGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public languageGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public meanMessageReactionCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public meanMessageShareCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public meanMessageViewCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public meanStoryReactionCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public meanStoryShareCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public meanStoryViewCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public memberCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

.field public memberCountGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public messageInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public messageReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public muteGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public period:Lorg/drinkless/tdlib/TdApi$DateRange;

.field public recentInteractions:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;

.field public storyInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public storyReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public viewCountByHourGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public viewCountBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55582
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatStatistics;-><init>()V

    .line 55583
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DateRange;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;Lorg/drinkless/tdlib/TdApi$StatisticalValue;DLorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;)V
    .locals 16
    .param p1, "dateRange"    # Lorg/drinkless/tdlib/TdApi$DateRange;
    .param p2, "statisticalValue"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p3, "statisticalValue2"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p4, "statisticalValue3"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p5, "statisticalValue4"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p6, "statisticalValue5"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p7, "statisticalValue6"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p8, "statisticalValue7"    # Lorg/drinkless/tdlib/TdApi$StatisticalValue;
    .param p9, "d9"    # D
    .param p11, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p12, "statisticalGraph2"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p13, "statisticalGraph3"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p14, "statisticalGraph4"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p15, "statisticalGraph5"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p16, "statisticalGraph6"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p17, "statisticalGraph7"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p18, "statisticalGraph8"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p19, "statisticalGraph9"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p20, "statisticalGraph10"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p21, "statisticalGraph11"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p22, "statisticalGraph12"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p23, "chatStatisticsInteractionInfoArr"    # [Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;

    .line 55552
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$ChatStatistics;-><init>()V

    .line 55553
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->period:Lorg/drinkless/tdlib/TdApi$DateRange;

    .line 55554
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->memberCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55555
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanMessageViewCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55556
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanMessageShareCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55557
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanMessageReactionCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55558
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanStoryViewCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55559
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanStoryShareCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55560
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->meanStoryReactionCount:Lorg/drinkless/tdlib/TdApi$StatisticalValue;

    .line 55561
    move-wide/from16 v9, p9

    iput-wide v9, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->enabledNotificationsPercentage:D

    .line 55562
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->memberCountGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55563
    move-object/from16 v12, p12

    iput-object v12, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->joinGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55564
    move-object/from16 v13, p13

    iput-object v13, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->muteGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55565
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->viewCountByHourGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55566
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->viewCountBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55567
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->joinBySourceGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55568
    move-object/from16 v1, p17

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->languageGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55569
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->messageInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55570
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->messageReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55571
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->storyInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55572
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->storyReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55573
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->instantViewInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 55574
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ChatStatisticsChannel;->recentInteractions:[Lorg/drinkless/tdlib/TdApi$ChatStatisticsInteractionInfo;

    .line 55575
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55579
    const v0, -0x51f7262c

    return v0
.end method
