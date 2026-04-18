.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposeStarGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c79a391


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

.field public starCount:J

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49100
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49101
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiveawayParameters;Ljava/lang/String;JIJ)V
    .locals 0
    .param p1, "giveawayParameters"    # Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "i9"    # I
    .param p6, "j9"    # J

    .line 49087
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49088
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;->parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

    .line 49089
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;->currency:Ljava/lang/String;

    .line 49090
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;->amount:J

    .line 49091
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;->winnerCount:I

    .line 49092
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposeStarGiveaway;->starCount:J

    .line 49093
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49097
    const v0, 0x3c79a391

    return v0
.end method
