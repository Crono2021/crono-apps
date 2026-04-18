.class public Lorg/drinkless/tdlib/TdApi$StatisticalGraphData;
.super Lorg/drinkless/tdlib/TdApi$StatisticalGraph;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StatisticalGraphData"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x768cd1d4


# instance fields
.field public jsonData:Ljava/lang/String;

.field public zoomToken:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StatisticalGraph;-><init>()V

    .line 32689
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 32678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StatisticalGraph;-><init>()V

    .line 32679
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StatisticalGraphData;->jsonData:Ljava/lang/String;

    .line 32680
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StatisticalGraphData;->zoomToken:Ljava/lang/String;

    .line 32681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32685
    const v0, -0x768cd1d4

    return v0
.end method
