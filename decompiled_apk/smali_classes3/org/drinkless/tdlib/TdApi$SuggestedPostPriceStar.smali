.class public Lorg/drinkless/tdlib/TdApi$SuggestedPostPriceStar;
.super Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedPostPriceStar"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xce75bc7


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20616
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;-><init>()V

    .line 20617
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20607
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedPostPrice;-><init>()V

    .line 20608
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedPostPriceStar;->starCount:J

    .line 20609
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20613
    const v0, 0xce75bc7

    return v0
.end method
