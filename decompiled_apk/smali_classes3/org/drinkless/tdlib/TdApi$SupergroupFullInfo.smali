.class public Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SupergroupFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1da9c301


# instance fields
.field public administratorCount:I

.field public bannedCount:I

.field public botCommands:[Lorg/drinkless/tdlib/TdApi$BotCommands;

.field public botVerification:Lorg/drinkless/tdlib/TdApi$BotVerification;

.field public canEnablePaidMessages:Z

.field public canEnablePaidReaction:Z

.field public canGetMembers:Z

.field public canGetRevenueStatistics:Z

.field public canGetStarRevenueStatistics:Z

.field public canGetStatistics:Z

.field public canHaveSponsoredMessages:Z

.field public canHideMembers:Z

.field public canSendGift:Z

.field public canSetLocation:Z

.field public canSetStickerSet:Z

.field public canToggleAggressiveAntiSpam:Z

.field public customEmojiStickerSetId:J

.field public description:Ljava/lang/String;

.field public directMessagesChatId:J

.field public giftCount:I

.field public hasAggressiveAntiSpamEnabled:Z

.field public hasHiddenMembers:Z

.field public hasPaidMediaAllowed:Z

.field public hasPinnedStories:Z

.field public inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

.field public isAllHistoryAvailable:Z

.field public linkedChatId:J

.field public location:Lorg/drinkless/tdlib/TdApi$ChatLocation;

.field public mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

.field public memberCount:I

.field public myBoostCount:I

.field public outgoingPaidMessageStarCount:J

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public restrictedCount:I

.field public slowModeDelay:I

.field public slowModeDelayExpiresIn:D

.field public stickerSetId:J

.field public unrestrictBoostCount:I

.field public upgradedFromBasicGroupId:J

.field public upgradedFromMaxMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 7355
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 7356
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;Ljava/lang/String;IIIIJJIDZZZZZZZZZZZZZZZZZIIIJJJLorg/drinkless/tdlib/TdApi$ChatLocation;Lorg/drinkless/tdlib/TdApi$ChatInviteLink;[Lorg/drinkless/tdlib/TdApi$BotCommands;Lorg/drinkless/tdlib/TdApi$BotVerification;Lorg/drinkless/tdlib/TdApi$ProfileTab;JJ)V
    .locals 16
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "i11"    # I
    .param p6, "i12"    # I
    .param p7, "j5"    # J
    .param p9, "j9"    # J
    .param p11, "i13"    # I
    .param p12, "d9"    # D
    .param p14, "z8"    # Z
    .param p15, "z9"    # Z
    .param p16, "z10"    # Z
    .param p17, "z11"    # Z
    .param p18, "z12"    # Z
    .param p19, "z13"    # Z
    .param p20, "z14"    # Z
    .param p21, "z15"    # Z
    .param p22, "z16"    # Z
    .param p23, "z17"    # Z
    .param p24, "z18"    # Z
    .param p25, "z19"    # Z
    .param p26, "z20"    # Z
    .param p27, "z21"    # Z
    .param p28, "z22"    # Z
    .param p29, "z23"    # Z
    .param p30, "z24"    # Z
    .param p31, "i14"    # I
    .param p32, "i15"    # I
    .param p33, "i16"    # I
    .param p34, "j10"    # J
    .param p36, "j11"    # J
    .param p38, "j12"    # J
    .param p40, "chatLocation"    # Lorg/drinkless/tdlib/TdApi$ChatLocation;
    .param p41, "chatInviteLink"    # Lorg/drinkless/tdlib/TdApi$ChatInviteLink;
    .param p42, "botCommandsArr"    # [Lorg/drinkless/tdlib/TdApi$BotCommands;
    .param p43, "botVerification"    # Lorg/drinkless/tdlib/TdApi$BotVerification;
    .param p44, "profileTab"    # Lorg/drinkless/tdlib/TdApi$ProfileTab;
    .param p45, "j13"    # J
    .param p47, "j14"    # J

    .line 7307
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 7308
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 7309
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->description:Ljava/lang/String;

    .line 7310
    move/from16 v3, p3

    iput v3, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->memberCount:I

    .line 7311
    move/from16 v4, p4

    iput v4, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->administratorCount:I

    .line 7312
    move/from16 v5, p5

    iput v5, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->restrictedCount:I

    .line 7313
    move/from16 v6, p6

    iput v6, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->bannedCount:I

    .line 7314
    move-wide/from16 v7, p7

    iput-wide v7, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->linkedChatId:J

    .line 7315
    move-wide/from16 v9, p9

    iput-wide v9, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->directMessagesChatId:J

    .line 7316
    move/from16 v11, p11

    iput v11, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->slowModeDelay:I

    .line 7317
    move-wide/from16 v12, p12

    iput-wide v12, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->slowModeDelayExpiresIn:D

    .line 7318
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canEnablePaidMessages:Z

    .line 7319
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canEnablePaidReaction:Z

    .line 7320
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canGetMembers:Z

    .line 7321
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->hasHiddenMembers:Z

    .line 7322
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canHideMembers:Z

    .line 7323
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canSetStickerSet:Z

    .line 7324
    move/from16 v1, p20

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canSetLocation:Z

    .line 7325
    move/from16 v1, p21

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canGetStatistics:Z

    .line 7326
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canGetRevenueStatistics:Z

    .line 7327
    move/from16 v1, p23

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canGetStarRevenueStatistics:Z

    .line 7328
    move/from16 v1, p24

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canSendGift:Z

    .line 7329
    move/from16 v1, p25

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canToggleAggressiveAntiSpam:Z

    .line 7330
    move/from16 v1, p26

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->isAllHistoryAvailable:Z

    .line 7331
    move/from16 v1, p27

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->canHaveSponsoredMessages:Z

    .line 7332
    move/from16 v1, p28

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->hasAggressiveAntiSpamEnabled:Z

    .line 7333
    move/from16 v1, p29

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->hasPaidMediaAllowed:Z

    .line 7334
    move/from16 v1, p30

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->hasPinnedStories:Z

    .line 7335
    move/from16 v1, p31

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->giftCount:I

    .line 7336
    move/from16 v1, p32

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->myBoostCount:I

    .line 7337
    move/from16 v1, p33

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->unrestrictBoostCount:I

    .line 7338
    move-wide/from16 v1, p34

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->outgoingPaidMessageStarCount:J

    .line 7339
    move-wide/from16 v1, p36

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->stickerSetId:J

    .line 7340
    move-wide/from16 v1, p38

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->customEmojiStickerSetId:J

    .line 7341
    move-object/from16 v1, p40

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->location:Lorg/drinkless/tdlib/TdApi$ChatLocation;

    .line 7342
    move-object/from16 v2, p41

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->inviteLink:Lorg/drinkless/tdlib/TdApi$ChatInviteLink;

    .line 7343
    move-object/from16 v1, p42

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->botCommands:[Lorg/drinkless/tdlib/TdApi$BotCommands;

    .line 7344
    move-object/from16 v1, p43

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->botVerification:Lorg/drinkless/tdlib/TdApi$BotVerification;

    .line 7345
    move-object/from16 v1, p44

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 7346
    move-wide/from16 v1, p45

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->upgradedFromBasicGroupId:J

    .line 7347
    move-wide/from16 v1, p47

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;->upgradedFromMaxMessageId:J

    .line 7348
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 7352
    const v0, -0x1da9c301    # -9.879996E20f

    return v0
.end method
