.class public Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClosedVectorPath"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2329f2a9


# instance fields
.field public commands:[Lorg/drinkless/tdlib/TdApi$VectorPathCommand;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10914
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10915
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$VectorPathCommand;)V
    .locals 0
    .param p1, "vectorPathCommandArr"    # [Lorg/drinkless/tdlib/TdApi$VectorPathCommand;

    .line 10905
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10906
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;->commands:[Lorg/drinkless/tdlib/TdApi$VectorPathCommand;

    .line 10907
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10911
    const v0, 0x2329f2a9

    return v0
.end method
