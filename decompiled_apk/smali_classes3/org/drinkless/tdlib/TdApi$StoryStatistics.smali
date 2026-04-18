.class public Lorg/drinkless/tdlib/TdApi$StoryStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46448b6b


# instance fields
.field public storyInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public storyReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32908
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32909
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;)V
    .locals 0
    .param p1, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p2, "statisticalGraph2"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 32898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32899
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryStatistics;->storyInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 32900
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StoryStatistics;->storyReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 32901
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32905
    const v0, 0x46448b6b

    return v0
.end method
