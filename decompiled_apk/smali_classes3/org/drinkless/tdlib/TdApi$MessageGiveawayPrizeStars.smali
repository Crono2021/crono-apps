.class public Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGiveawayPrizeStars"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x55f0a21d


# instance fields
.field public boostedChatId:J

.field public giveawayMessageId:J

.field public isUnclaimed:Z

.field public starCount:J

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

.field public transactionId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50178
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 50179
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;JJZLorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "j9"    # J
    .param p6, "j10"    # J
    .param p8, "z8"    # Z
    .param p9, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 50164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 50165
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->starCount:J

    .line 50166
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->transactionId:Ljava/lang/String;

    .line 50167
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->boostedChatId:J

    .line 50168
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->giveawayMessageId:J

    .line 50169
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->isUnclaimed:Z

    .line 50170
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$MessageGiveawayPrizeStars;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 50171
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50175
    const v0, -0x55f0a21d

    return v0
.end method
