.class public Lorg/drinkless/tdlib/TdApi$GameHighScores;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GameHighScores"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2b4261e7


# instance fields
.field public scores:[Lorg/drinkless/tdlib/TdApi$GameHighScore;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11976
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11977
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$GameHighScore;)V
    .locals 0
    .param p1, "gameHighScoreArr"    # [Lorg/drinkless/tdlib/TdApi$GameHighScore;

    .line 11967
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11968
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GameHighScores;->scores:[Lorg/drinkless/tdlib/TdApi$GameHighScore;

    .line 11969
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11973
    const v0, -0x2b4261e7

    return v0
.end method
