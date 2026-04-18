.class public Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaPosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5b601394


# instance fields
.field public cornerRadiusPercentage:D

.field public heightPercentage:D

.field public rotationAngle:D

.field public widthPercentage:D

.field public xPercentage:D

.field public yPercentage:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50795
    return-void
.end method

.method public constructor <init>(DDDDDD)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "d10"    # D
    .param p5, "d11"    # D
    .param p7, "d12"    # D
    .param p9, "d13"    # D
    .param p11, "d14"    # D

    .line 50780
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50781
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->xPercentage:D

    .line 50782
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->yPercentage:D

    .line 50783
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->widthPercentage:D

    .line 50784
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->heightPercentage:D

    .line 50785
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->rotationAngle:D

    .line 50786
    iput-wide p11, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;->cornerRadiusPercentage:D

    .line 50787
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50791
    const v0, -0x5b601394

    return v0
.end method
