.class public Lorg/drinkless/tdlib/TdApi$User;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "User"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6cb25545


# instance fields
.field public accentColorId:I

.field public addedToAttachmentMenu:Z

.field public backgroundCustomEmojiId:J

.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

.field public firstName:Ljava/lang/String;

.field public hasActiveStories:Z

.field public hasUnreadActiveStories:Z

.field public haveAccess:Z

.field public id:J

.field public isCloseFriend:Z

.field public isContact:Z

.field public isMutualContact:Z

.field public isPremium:Z

.field public isSupport:Z

.field public languageCode:Ljava/lang/String;

.field public lastName:Ljava/lang/String;

.field public paidMessageStarCount:J

.field public phoneNumber:Ljava/lang/String;

.field public profileAccentColorId:I

.field public profileBackgroundCustomEmojiId:J

.field public profilePhoto:Lorg/drinkless/tdlib/TdApi$ProfilePhoto;

.field public restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

.field public restrictsNewChats:Z

.field public status:Lorg/drinkless/tdlib/TdApi$UserStatus;

.field public type:Lorg/drinkless/tdlib/TdApi$UserType;

.field public upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

.field public usernames:Lorg/drinkless/tdlib/TdApi$Usernames;

.field public verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8127
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8128
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Usernames;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$UserStatus;Lorg/drinkless/tdlib/TdApi$ProfilePhoto;IJLorg/drinkless/tdlib/TdApi$UpgradedGiftColors;IJLorg/drinkless/tdlib/TdApi$EmojiStatus;ZZZLorg/drinkless/tdlib/TdApi$VerificationStatus;ZZLorg/drinkless/tdlib/TdApi$RestrictionInfo;ZZZJZLorg/drinkless/tdlib/TdApi$UserType;Ljava/lang/String;Z)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "usernames"    # Lorg/drinkless/tdlib/TdApi$Usernames;
    .param p6, "str3"    # Ljava/lang/String;
    .param p7, "userStatus"    # Lorg/drinkless/tdlib/TdApi$UserStatus;
    .param p8, "profilePhoto"    # Lorg/drinkless/tdlib/TdApi$ProfilePhoto;
    .param p9, "i9"    # I
    .param p10, "j9"    # J
    .param p12, "upgradedGiftColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;
    .param p13, "i10"    # I
    .param p14, "j10"    # J
    .param p16, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;
    .param p17, "z8"    # Z
    .param p18, "z9"    # Z
    .param p19, "z10"    # Z
    .param p20, "verificationStatus"    # Lorg/drinkless/tdlib/TdApi$VerificationStatus;
    .param p21, "z11"    # Z
    .param p22, "z12"    # Z
    .param p23, "restrictionInfo"    # Lorg/drinkless/tdlib/TdApi$RestrictionInfo;
    .param p24, "z13"    # Z
    .param p25, "z14"    # Z
    .param p26, "z15"    # Z
    .param p27, "j11"    # J
    .param p29, "z16"    # Z
    .param p30, "userType"    # Lorg/drinkless/tdlib/TdApi$UserType;
    .param p31, "str4"    # Ljava/lang/String;
    .param p32, "z17"    # Z

    .line 8091
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 8092
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$User;->id:J

    .line 8093
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$User;->firstName:Ljava/lang/String;

    .line 8094
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$User;->lastName:Ljava/lang/String;

    .line 8095
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$User;->usernames:Lorg/drinkless/tdlib/TdApi$Usernames;

    .line 8096
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$User;->phoneNumber:Ljava/lang/String;

    .line 8097
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$User;->status:Lorg/drinkless/tdlib/TdApi$UserStatus;

    .line 8098
    move-object/from16 v8, p8

    iput-object v8, v0, Lorg/drinkless/tdlib/TdApi$User;->profilePhoto:Lorg/drinkless/tdlib/TdApi$ProfilePhoto;

    .line 8099
    move/from16 v9, p9

    iput v9, v0, Lorg/drinkless/tdlib/TdApi$User;->accentColorId:I

    .line 8100
    move-wide/from16 v10, p10

    iput-wide v10, v0, Lorg/drinkless/tdlib/TdApi$User;->backgroundCustomEmojiId:J

    .line 8101
    move-object/from16 v12, p12

    iput-object v12, v0, Lorg/drinkless/tdlib/TdApi$User;->upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

    .line 8102
    move/from16 v13, p13

    iput v13, v0, Lorg/drinkless/tdlib/TdApi$User;->profileAccentColorId:I

    .line 8103
    move-wide/from16 v14, p14

    iput-wide v14, v0, Lorg/drinkless/tdlib/TdApi$User;->profileBackgroundCustomEmojiId:J

    .line 8104
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$User;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 8105
    move/from16 v2, p17

    iput-boolean v2, v0, Lorg/drinkless/tdlib/TdApi$User;->isContact:Z

    .line 8106
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->isMutualContact:Z

    .line 8107
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->isCloseFriend:Z

    .line 8108
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$User;->verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;

    .line 8109
    move/from16 v1, p21

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->isPremium:Z

    .line 8110
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->isSupport:Z

    .line 8111
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$User;->restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

    .line 8112
    move/from16 v1, p24

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->hasActiveStories:Z

    .line 8113
    move/from16 v1, p25

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->hasUnreadActiveStories:Z

    .line 8114
    move/from16 v1, p26

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->restrictsNewChats:Z

    .line 8115
    move-wide/from16 v1, p27

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$User;->paidMessageStarCount:J

    .line 8116
    move/from16 v1, p29

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->haveAccess:Z

    .line 8117
    move-object/from16 v2, p30

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$User;->type:Lorg/drinkless/tdlib/TdApi$UserType;

    .line 8118
    move-object/from16 v1, p31

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$User;->languageCode:Ljava/lang/String;

    .line 8119
    move/from16 v1, p32

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$User;->addedToAttachmentMenu:Z

    .line 8120
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8124
    const v0, 0x6cb25545

    return v0
.end method
