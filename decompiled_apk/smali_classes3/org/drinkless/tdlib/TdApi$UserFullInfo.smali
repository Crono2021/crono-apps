.class public Lorg/drinkless/tdlib/TdApi$UserFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7edf1d16


# instance fields
.field public bio:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

.field public blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

.field public botInfo:Lorg/drinkless/tdlib/TdApi$BotInfo;

.field public botVerification:Lorg/drinkless/tdlib/TdApi$BotVerification;

.field public businessInfo:Lorg/drinkless/tdlib/TdApi$BusinessInfo;

.field public canBeCalled:Z

.field public firstProfileAudio:Lorg/drinkless/tdlib/TdApi$Audio;

.field public giftCount:I

.field public giftSettings:Lorg/drinkless/tdlib/TdApi$GiftSettings;

.field public groupInCommonCount:I

.field public hasPostedToProfileStories:Z

.field public hasPrivateCalls:Z

.field public hasPrivateForwards:Z

.field public hasRestrictedVoiceAndVideoNoteMessages:Z

.field public hasSponsoredMessagesEnabled:Z

.field public incomingPaidMessageStarCount:J

.field public mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

.field public needPhoneNumberPrivacyException:Z

.field public note:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public outgoingPaidMessageStarCount:J

.field public pendingRating:Lorg/drinkless/tdlib/TdApi$UserRating;

.field public pendingRatingDate:I

.field public personalChatId:J

.field public personalPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public publicPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

.field public rating:Lorg/drinkless/tdlib/TdApi$UserRating;

.field public setChatBackground:Z

.field public supportsVideoCalls:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8203
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8204
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;Lorg/drinkless/tdlib/TdApi$ChatPhoto;Lorg/drinkless/tdlib/TdApi$ChatPhoto;Lorg/drinkless/tdlib/TdApi$BlockList;ZZZZZZZZZLorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$Birthdate;JIIJJLorg/drinkless/tdlib/TdApi$GiftSettings;Lorg/drinkless/tdlib/TdApi$BotVerification;Lorg/drinkless/tdlib/TdApi$ProfileTab;Lorg/drinkless/tdlib/TdApi$Audio;Lorg/drinkless/tdlib/TdApi$UserRating;Lorg/drinkless/tdlib/TdApi$UserRating;ILorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$BusinessInfo;Lorg/drinkless/tdlib/TdApi$BotInfo;)V
    .locals 16
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p2, "chatPhoto2"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p3, "chatPhoto3"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;
    .param p4, "blockList"    # Lorg/drinkless/tdlib/TdApi$BlockList;
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "z10"    # Z
    .param p8, "z11"    # Z
    .param p9, "z12"    # Z
    .param p10, "z13"    # Z
    .param p11, "z14"    # Z
    .param p12, "z15"    # Z
    .param p13, "z16"    # Z
    .param p14, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p15, "birthdate"    # Lorg/drinkless/tdlib/TdApi$Birthdate;
    .param p16, "j5"    # J
    .param p18, "i9"    # I
    .param p19, "i10"    # I
    .param p20, "j9"    # J
    .param p22, "j10"    # J
    .param p24, "giftSettings"    # Lorg/drinkless/tdlib/TdApi$GiftSettings;
    .param p25, "botVerification"    # Lorg/drinkless/tdlib/TdApi$BotVerification;
    .param p26, "profileTab"    # Lorg/drinkless/tdlib/TdApi$ProfileTab;
    .param p27, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;
    .param p28, "userRating"    # Lorg/drinkless/tdlib/TdApi$UserRating;
    .param p29, "userRating2"    # Lorg/drinkless/tdlib/TdApi$UserRating;
    .param p30, "i11"    # I
    .param p31, "formattedText2"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p32, "businessInfo"    # Lorg/drinkless/tdlib/TdApi$BusinessInfo;
    .param p33, "botInfo"    # Lorg/drinkless/tdlib/TdApi$BotInfo;

    .line 8165
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8166
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->personalPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 8167
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 8168
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->publicPhoto:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 8169
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 8170
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->canBeCalled:Z

    .line 8171
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->supportsVideoCalls:Z

    .line 8172
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->hasPrivateCalls:Z

    .line 8173
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->hasPrivateForwards:Z

    .line 8174
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->hasRestrictedVoiceAndVideoNoteMessages:Z

    .line 8175
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->hasPostedToProfileStories:Z

    .line 8176
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->hasSponsoredMessagesEnabled:Z

    .line 8177
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->needPhoneNumberPrivacyException:Z

    .line 8178
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->setChatBackground:Z

    .line 8179
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->bio:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 8180
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->birthdate:Lorg/drinkless/tdlib/TdApi$Birthdate;

    .line 8181
    move-wide/from16 v1, p16

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->personalChatId:J

    .line 8182
    move/from16 v1, p18

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->giftCount:I

    .line 8183
    move/from16 v2, p19

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->groupInCommonCount:I

    .line 8184
    move-wide/from16 v1, p20

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->incomingPaidMessageStarCount:J

    .line 8185
    move-wide/from16 v1, p22

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->outgoingPaidMessageStarCount:J

    .line 8186
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->giftSettings:Lorg/drinkless/tdlib/TdApi$GiftSettings;

    .line 8187
    move-object/from16 v2, p25

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->botVerification:Lorg/drinkless/tdlib/TdApi$BotVerification;

    .line 8188
    move-object/from16 v1, p26

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->mainProfileTab:Lorg/drinkless/tdlib/TdApi$ProfileTab;

    .line 8189
    move-object/from16 v1, p27

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->firstProfileAudio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 8190
    move-object/from16 v1, p28

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->rating:Lorg/drinkless/tdlib/TdApi$UserRating;

    .line 8191
    move-object/from16 v1, p29

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->pendingRating:Lorg/drinkless/tdlib/TdApi$UserRating;

    .line 8192
    move/from16 v1, p30

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->pendingRatingDate:I

    .line 8193
    move-object/from16 v1, p31

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->note:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 8194
    move-object/from16 v1, p32

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->businessInfo:Lorg/drinkless/tdlib/TdApi$BusinessInfo;

    .line 8195
    move-object/from16 v1, p33

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$UserFullInfo;->botInfo:Lorg/drinkless/tdlib/TdApi$BotInfo;

    .line 8196
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8200
    const v0, 0x7edf1d16

    return v0
.end method
