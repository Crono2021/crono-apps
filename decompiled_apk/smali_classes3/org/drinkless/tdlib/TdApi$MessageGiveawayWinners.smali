.class public Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiveawayWinners"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7d15df3d


# instance fields
.field public actualWinnersSelectionDate:I

.field public additionalChatCount:I

.field public boostedChatId:J

.field public giveawayMessageId:J

.field public onlyNewMembers:Z

.field public prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

.field public prizeDescription:Ljava/lang/String;

.field public unclaimedPrizeCount:I

.field public wasRefunded:Z

.field public winnerCount:I

.field public winnerUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53755
    return-void
.end method

.method public constructor <init>(JJIIZZLorg/drinkless/tdlib/TdApi$GiveawayPrize;Ljava/lang/String;I[JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z
    .param p9, "giveawayPrize"    # Lorg/drinkless/tdlib/TdApi$GiveawayPrize;
    .param p10, "str"    # Ljava/lang/String;
    .param p11, "i11"    # I
    .param p12, "jArr"    # [J
    .param p13, "i12"    # I

    .line 53735
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 53736
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->boostedChatId:J

    .line 53737
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->giveawayMessageId:J

    .line 53738
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->additionalChatCount:I

    .line 53739
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->actualWinnersSelectionDate:I

    .line 53740
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->onlyNewMembers:Z

    .line 53741
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->wasRefunded:Z

    .line 53742
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->prize:Lorg/drinkless/tdlib/TdApi$GiveawayPrize;

    .line 53743
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->prizeDescription:Ljava/lang/String;

    .line 53744
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->winnerCount:I

    .line 53745
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->winnerUserIds:[J

    .line 53746
    iput p13, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayWinners;->unclaimedPrizeCount:I

    .line 53747
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53751
    const v0, 0x7d15df3d

    return v0
.end method
