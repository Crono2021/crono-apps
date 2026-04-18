.class public Lorg/drinkless/tdlib/TdApi$VectorPathCommandCubicBezierCurve;
.super Lorg/drinkless/tdlib/TdApi$VectorPathCommand;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "VectorPathCommandCubicBezierCurve"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x494c3e3a


# instance fields
.field public endControlPoint:Lorg/drinkless/tdlib/TdApi$Point;

.field public endPoint:Lorg/drinkless/tdlib/TdApi$Point;

.field public startControlPoint:Lorg/drinkless/tdlib/TdApi$Point;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$VectorPathCommand;-><init>()V

    .line 42089
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Point;Lorg/drinkless/tdlib/TdApi$Point;Lorg/drinkless/tdlib/TdApi$Point;)V
    .locals 0
    .param p1, "point"    # Lorg/drinkless/tdlib/TdApi$Point;
    .param p2, "point2"    # Lorg/drinkless/tdlib/TdApi$Point;
    .param p3, "point3"    # Lorg/drinkless/tdlib/TdApi$Point;

    .line 42077
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$VectorPathCommand;-><init>()V

    .line 42078
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$VectorPathCommandCubicBezierCurve;->startControlPoint:Lorg/drinkless/tdlib/TdApi$Point;

    .line 42079
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$VectorPathCommandCubicBezierCurve;->endControlPoint:Lorg/drinkless/tdlib/TdApi$Point;

    .line 42080
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$VectorPathCommandCubicBezierCurve;->endPoint:Lorg/drinkless/tdlib/TdApi$Point;

    .line 42081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42085
    const v0, 0x494c3e3a    # 836579.6f

    return v0
.end method
