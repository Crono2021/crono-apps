.class public Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;
.super Lorg/drinkless/tdlib/TdApi$GiveawayInfo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiveawayInfoCompleted"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x328cc35c


# instance fields
.field public activationCount:I

.field public actualWinnersSelectionDate:I

.field public creationDate:I

.field public giftCode:Ljava/lang/String;

.field public isWinner:Z

.field public wasRefunded:Z

.field public winnerCount:I

.field public wonStarCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayInfo;-><init>()V

    .line 52045
    return-void
.end method

.method public constructor <init>(IIZZIILjava/lang/String;J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "i11"    # I
    .param p6, "i12"    # I
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "j5"    # J

    .line 52028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$GiveawayInfo;-><init>()V

    .line 52029
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->creationDate:I

    .line 52030
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->actualWinnersSelectionDate:I

    .line 52031
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->wasRefunded:Z

    .line 52032
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->isWinner:Z

    .line 52033
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->winnerCount:I

    .line 52034
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->activationCount:I

    .line 52035
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->giftCode:Ljava/lang/String;

    .line 52036
    iput-wide p8, p0, Lorg/drinkless/tdlib/TdApi$GiveawayInfoCompleted;->wonStarCount:J

    .line 52037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52041
    const v0, 0x328cc35c

    return v0
.end method
