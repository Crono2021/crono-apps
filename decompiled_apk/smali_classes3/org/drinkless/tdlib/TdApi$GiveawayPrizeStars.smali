.class public Lorg/drinkless/tdlib/TdApi$GiveawayPrizeStars;
.super Lorg/drinkless/tdlib/TdApi$GiveawayPrize;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayPrizeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6ab3e05c


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14172
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayPrize;-><init>()V

    .line 14173
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14163
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayPrize;-><init>()V

    .line 14164
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayPrizeStars;->starCount:J

    .line 14165
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14169
    const v0, -0x6ab3e05c

    return v0
.end method
