.class public Lorg/drinkless/tdlib/TdApi$UserRating;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserRating"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1fb66583


# instance fields
.field public currentLevelRating:J

.field public isMaximumLevelReached:Z

.field public level:I

.field public nextLevelRating:J

.field public rating:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49230
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49231
    return-void
.end method

.method public constructor <init>(IZJJJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "j5"    # J
    .param p5, "j9"    # J
    .param p7, "j10"    # J

    .line 49217
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49218
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UserRating;->level:I

    .line 49219
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$UserRating;->isMaximumLevelReached:Z

    .line 49220
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UserRating;->rating:J

    .line 49221
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UserRating;->currentLevelRating:J

    .line 49222
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UserRating;->nextLevelRating:J

    .line 49223
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49227
    const v0, 0x1fb66583

    return v0
.end method
