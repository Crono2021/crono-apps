.class public Lorg/drinkless/tdlib/TdApi$ReceivedGift;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReceivedGift"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41211ba3


# instance fields
.field public canBeTransferred:Z

.field public canBeUpgraded:Z

.field public collectionIds:[I

.field public date:I

.field public dropOriginalDetailsStarCount:J

.field public exportDate:I

.field public gift:Lorg/drinkless/tdlib/TdApi$SentGift;

.field public isPinned:Z

.field public isPrivate:Z

.field public isSaved:Z

.field public isUpgradeSeparate:Z

.field public nextResaleDate:I

.field public nextTransferDate:I

.field public prepaidUpgradeHash:Ljava/lang/String;

.field public prepaidUpgradeStarCount:J

.field public receivedGiftId:Ljava/lang/String;

.field public sellStarCount:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public transferStarCount:J

.field public wasRefunded:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55462
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55463
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$FormattedText;ZZZZZZILorg/drinkless/tdlib/TdApi$SentGift;[IJJZJJIIILjava/lang/String;)V
    .locals 16
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "z10"    # Z
    .param p7, "z11"    # Z
    .param p8, "z12"    # Z
    .param p9, "z13"    # Z
    .param p10, "i9"    # I
    .param p11, "sentGift"    # Lorg/drinkless/tdlib/TdApi$SentGift;
    .param p12, "iArr"    # [I
    .param p13, "j5"    # J
    .param p15, "j9"    # J
    .param p17, "z14"    # Z
    .param p18, "j10"    # J
    .param p20, "j11"    # J
    .param p22, "i10"    # I
    .param p23, "i11"    # I
    .param p24, "i12"    # I
    .param p25, "str2"    # Ljava/lang/String;

    .line 55433
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55434
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->receivedGiftId:Ljava/lang/String;

    .line 55435
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55436
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 55437
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->isPrivate:Z

    .line 55438
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->isSaved:Z

    .line 55439
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->isPinned:Z

    .line 55440
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->canBeUpgraded:Z

    .line 55441
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->canBeTransferred:Z

    .line 55442
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->wasRefunded:Z

    .line 55443
    move/from16 v10, p10

    iput v10, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->date:I

    .line 55444
    move-object/from16 v11, p11

    iput-object v11, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->gift:Lorg/drinkless/tdlib/TdApi$SentGift;

    .line 55445
    move-object/from16 v12, p12

    iput-object v12, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->collectionIds:[I

    .line 55446
    move-wide/from16 v13, p13

    iput-wide v13, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->sellStarCount:J

    .line 55447
    move-wide/from16 v1, p15

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->prepaidUpgradeStarCount:J

    .line 55448
    move/from16 v15, p17

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->isUpgradeSeparate:Z

    .line 55449
    move-wide/from16 v1, p18

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->transferStarCount:J

    .line 55450
    move-wide/from16 v1, p20

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->dropOriginalDetailsStarCount:J

    .line 55451
    move/from16 v1, p22

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->nextTransferDate:I

    .line 55452
    move/from16 v2, p23

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->nextResaleDate:I

    .line 55453
    move/from16 v1, p24

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->exportDate:I

    .line 55454
    move-object/from16 v1, p25

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$ReceivedGift;->prepaidUpgradeHash:Ljava/lang/String;

    .line 55455
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55459
    const v0, 0x41211ba3

    return v0
.end method
