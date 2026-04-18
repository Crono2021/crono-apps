.class public Lorg/drinkless/tdlib/TdApi$LaunchPrepaidGiveaway;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LaunchPrepaidGiveaway"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x261d783a


# instance fields
.field public giveawayId:J

.field public parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

.field public starCount:J

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44046
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44047
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$GiveawayParameters;IJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "giveawayParameters"    # Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
    .param p4, "i9"    # I
    .param p5, "j9"    # J

    .line 44034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 44035
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$LaunchPrepaidGiveaway;->giveawayId:J

    .line 44036
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$LaunchPrepaidGiveaway;->parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

    .line 44037
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$LaunchPrepaidGiveaway;->winnerCount:I

    .line 44038
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$LaunchPrepaidGiveaway;->starCount:J

    .line 44039
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44043
    const v0, 0x261d783a

    return v0
.end method
