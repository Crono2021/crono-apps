.class public Lorg/drinkless/tdlib/TdApi$GameHighScore;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GameHighScore"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x146fcf1e


# instance fields
.field public position:I

.field public score:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37115
    return-void
.end method

.method public constructor <init>(IJI)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "i10"    # I

    .line 37103
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 37104
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GameHighScore;->position:I

    .line 37105
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$GameHighScore;->userId:J

    .line 37106
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GameHighScore;->score:I

    .line 37107
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37111
    const v0, 0x146fcf1e

    return v0
.end method
