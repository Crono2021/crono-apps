.class public Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftResaleParameters"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7fd0a7da


# instance fields
.field public starCount:J

.field public toncoinCentCount:J

.field public toncoinOnly:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37710
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37711
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 37699
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37700
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;->starCount:J

    .line 37701
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;->toncoinCentCount:J

    .line 37702
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GiftResaleParameters;->toncoinOnly:Z

    .line 37703
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37707
    const v0, -0x7fd0a7da

    return v0
.end method
