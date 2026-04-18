.class public Lorg/drinkless/tdlib/TdApi$Outline;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Outline"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x9a0658e


# instance fields
.field public paths:[Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17125
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;)V
    .locals 0
    .param p1, "closedVectorPathArr"    # [Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;

    .line 17115
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 17116
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Outline;->paths:[Lorg/drinkless/tdlib/TdApi$ClosedVectorPath;

    .line 17117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17121
    const v0, -0x9a0658e

    return v0
.end method
