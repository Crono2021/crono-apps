.class public Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftUpgradePrice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x367c64ac


# instance fields
.field public date:I

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26965
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 26954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26955
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;->date:I

    .line 26956
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GiftUpgradePrice;->starCount:J

    .line 26957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26961
    const v0, -0x367c64ac

    return v0
.end method
