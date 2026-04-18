.class public Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;
.super Lorg/drinkless/tdlib/TdApi$EmojiStatusType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EmojiStatusTypeUpgradedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x31f1ac0c


# instance fields
.field public backdropColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;

.field public giftName:Ljava/lang/String;

.field public giftTitle:Ljava/lang/String;

.field public modelCustomEmojiId:J

.field public symbolCustomEmojiId:J

.field public upgradedGiftId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49730
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiStatusType;-><init>()V

    .line 49731
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;JJLorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "j9"    # J
    .param p7, "j10"    # J
    .param p9, "upgradedGiftBackdropColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;

    .line 49716
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$EmojiStatusType;-><init>()V

    .line 49717
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->upgradedGiftId:J

    .line 49718
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->giftTitle:Ljava/lang/String;

    .line 49719
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->giftName:Ljava/lang/String;

    .line 49720
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->modelCustomEmojiId:J

    .line 49721
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->symbolCustomEmojiId:J

    .line 49722
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$EmojiStatusTypeUpgradedGift;->backdropColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftBackdropColors;

    .line 49723
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49727
    const v0, -0x31f1ac0c

    return v0
.end method
