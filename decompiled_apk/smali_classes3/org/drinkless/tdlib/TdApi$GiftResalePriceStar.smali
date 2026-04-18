.class public Lorg/drinkless/tdlib/TdApi$GiftResalePriceStar;
.super Lorg/drinkless/tdlib/TdApi$GiftResalePrice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftResalePriceStar"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x46988a86


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14046
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResalePrice;-><init>()V

    .line 14047
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14037
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiftResalePrice;-><init>()V

    .line 14038
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiftResalePriceStar;->starCount:J

    .line 14039
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14043
    const v0, 0x46988a86

    return v0
.end method
