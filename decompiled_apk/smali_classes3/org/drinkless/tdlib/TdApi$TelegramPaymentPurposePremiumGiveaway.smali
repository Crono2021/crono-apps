.class public Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;
.super Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TelegramPaymentPurposePremiumGiveaway"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d583cc1


# instance fields
.field public amount:J

.field public currency:Ljava/lang/String;

.field public monthCount:I

.field public parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

.field public winnerCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49075
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GiveawayParameters;Ljava/lang/String;JII)V
    .locals 0
    .param p1, "giveawayParameters"    # Lorg/drinkless/tdlib/TdApi$GiveawayParameters;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "j5"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I

    .line 49061
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurpose;-><init>()V

    .line 49062
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;->parameters:Lorg/drinkless/tdlib/TdApi$GiveawayParameters;

    .line 49063
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;->currency:Ljava/lang/String;

    .line 49064
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;->amount:J

    .line 49065
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;->winnerCount:I

    .line 49066
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$TelegramPaymentPurposePremiumGiveaway;->monthCount:I

    .line 49067
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49071
    const v0, -0x2d583cc1

    return v0
.end method
