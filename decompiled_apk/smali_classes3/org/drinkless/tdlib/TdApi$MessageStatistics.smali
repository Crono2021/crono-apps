.class public Lorg/drinkless/tdlib/TdApi$MessageStatistics;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageStatistics"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d31b0f9


# instance fields
.field public messageInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

.field public messageReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28624
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28625
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StatisticalGraph;Lorg/drinkless/tdlib/TdApi$StatisticalGraph;)V
    .locals 0
    .param p1, "statisticalGraph"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
    .param p2, "statisticalGraph2"    # Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 28614
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28615
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageStatistics;->messageInteractionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 28616
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageStatistics;->messageReactionGraph:Lorg/drinkless/tdlib/TdApi$StatisticalGraph;

    .line 28617
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28621
    const v0, -0x5d31b0f9

    return v0
.end method
