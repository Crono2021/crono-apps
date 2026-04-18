.class public Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PrepaidGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x108fcc71


# instance fields
.field public boostCount:I

.field public id:J

.field public paymentDate:I

.field public prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48399
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$GiveawayPrize;II)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "giveawayPrize"    # Lorg/drinkless/tdlib/TdApi$GiveawayPrize;
    .param p5, "i10"    # I
    .param p6, "i11"    # I

    .line 48385
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48386
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;->id:J

    .line 48387
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;->winnerCount:I

    .line 48388
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;->prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

    .line 48389
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;->boostCount:I

    .line 48390
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$PrepaidGiveaway;->paymentDate:I

    .line 48391
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48395
    const v0, -0x108fcc71

    return v0
.end method
