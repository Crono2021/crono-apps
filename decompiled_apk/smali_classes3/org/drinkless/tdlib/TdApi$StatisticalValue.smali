.class public Lorg/drinkless/tdlib/TdApi$StatisticalValue;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StatisticalValue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x626d6a76


# instance fields
.field public growthRatePercentage:D

.field public previousValue:D

.field public value:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40769
    return-void
.end method

.method public constructor <init>(DDD)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "d10"    # D
    .param p5, "d11"    # D

    .line 40757
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 40758
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StatisticalValue;->value:D

    .line 40759
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StatisticalValue;->previousValue:D

    .line 40760
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$StatisticalValue;->growthRatePercentage:D

    .line 40761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40765
    const v0, 0x626d6a76

    return v0
.end method
