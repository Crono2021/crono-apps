.class public Lorg/drinkless/tdlib/TdApi$MessageGift;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c92f64a


# instance fields
.field public canBeUpgraded:Z

.field public gift:Lorg/drinkless/tdlib/TdApi$Gift;

.field public isPrepaidUpgrade:Z

.field public isPrivate:Z

.field public isSaved:Z

.field public isUpgradeSeparate:Z

.field public prepaidUpgradeHash:Ljava/lang/String;

.field public prepaidUpgradeStarCount:J

.field public receivedGiftId:Ljava/lang/String;

.field public receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public sellStarCount:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public upgradedReceivedGiftId:Ljava/lang/String;

.field public wasConverted:Z

.field public wasRefunded:Z

.field public wasUpgraded:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55352
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 55353
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Gift;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$MessageSender;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$FormattedText;JJZZZZZZZZLjava/lang/String;Ljava/lang/String;)V
    .locals 16
    .param p1, "gift"    # Lorg/drinkless/tdlib/TdApi$Gift;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "messageSender2"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p6, "j5"    # J
    .param p8, "j9"    # J
    .param p10, "z8"    # Z
    .param p11, "z9"    # Z
    .param p12, "z10"    # Z
    .param p13, "z11"    # Z
    .param p14, "z12"    # Z
    .param p15, "z13"    # Z
    .param p16, "z14"    # Z
    .param p17, "z15"    # Z
    .param p18, "str2"    # Ljava/lang/String;
    .param p19, "str3"    # Ljava/lang/String;

    .line 55327
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 55328
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->gift:Lorg/drinkless/tdlib/TdApi$Gift;

    .line 55329
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55330
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->receiverId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55331
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->receivedGiftId:Ljava/lang/String;

    .line 55332
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 55333
    move-wide/from16 v6, p6

    iput-wide v6, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->sellStarCount:J

    .line 55334
    move-wide/from16 v8, p8

    iput-wide v8, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->prepaidUpgradeStarCount:J

    .line 55335
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->isUpgradeSeparate:Z

    .line 55336
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->isPrivate:Z

    .line 55337
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->isSaved:Z

    .line 55338
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->isPrepaidUpgrade:Z

    .line 55339
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->canBeUpgraded:Z

    .line 55340
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->wasConverted:Z

    .line 55341
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->wasUpgraded:Z

    .line 55342
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->wasRefunded:Z

    .line 55343
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->upgradedReceivedGiftId:Ljava/lang/String;

    .line 55344
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$MessageGift;->prepaidUpgradeHash:Ljava/lang/String;

    .line 55345
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55349
    const v0, -0x5c92f64a

    return v0
.end method
