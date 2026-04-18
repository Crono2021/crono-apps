.class public Lorg/drinkless/tdlib/TdApi$Supergroup;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Supergroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36b8a9e6


# instance fields
.field public boostLevel:I

.field public date:I

.field public hasActiveStories:Z

.field public hasAutomaticTranslation:Z

.field public hasDirectMessagesGroup:Z

.field public hasForumTabs:Z

.field public hasLinkedChat:Z

.field public hasLocation:Z

.field public hasUnreadActiveStories:Z

.field public id:J

.field public isAdministeredDirectMessagesGroup:Z

.field public isBroadcastGroup:Z

.field public isChannel:Z

.field public isDirectMessagesGroup:Z

.field public isForum:Z

.field public isSlowModeEnabled:Z

.field public joinByRequest:Z

.field public joinToSendMessages:Z

.field public memberCount:I

.field public paidMessageStarCount:J

.field public restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

.field public showMessageSender:Z

.field public signMessages:Z

.field public status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

.field public usernames:Lorg/drinkless/tdlib/TdApi$Usernames;

.field public verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55786
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55787
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$Usernames;ILorg/drinkless/tdlib/TdApi$ChatMemberStatus;IIZZZZZZZZZZZZZLorg/drinkless/tdlib/TdApi$VerificationStatus;ZZLorg/drinkless/tdlib/TdApi$RestrictionInfo;JZZ)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "usernames"    # Lorg/drinkless/tdlib/TdApi$Usernames;
    .param p4, "i9"    # I
    .param p5, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
    .param p6, "i10"    # I
    .param p7, "i11"    # I
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z
    .param p10, "z10"    # Z
    .param p11, "z11"    # Z
    .param p12, "z12"    # Z
    .param p13, "z13"    # Z
    .param p14, "z14"    # Z
    .param p15, "z15"    # Z
    .param p16, "z16"    # Z
    .param p17, "z17"    # Z
    .param p18, "z18"    # Z
    .param p19, "z19"    # Z
    .param p20, "z20"    # Z
    .param p21, "verificationStatus"    # Lorg/drinkless/tdlib/TdApi$VerificationStatus;
    .param p22, "z21"    # Z
    .param p23, "z22"    # Z
    .param p24, "restrictionInfo"    # Lorg/drinkless/tdlib/TdApi$RestrictionInfo;
    .param p25, "j9"    # J
    .param p27, "z23"    # Z
    .param p28, "z24"    # Z

    .line 55752
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55753
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->id:J

    .line 55754
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->usernames:Lorg/drinkless/tdlib/TdApi$Usernames;

    .line 55755
    move/from16 v4, p4

    iput v4, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->date:I

    .line 55756
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 55757
    move/from16 v6, p6

    iput v6, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->memberCount:I

    .line 55758
    move/from16 v7, p7

    iput v7, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->boostLevel:I

    .line 55759
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasAutomaticTranslation:Z

    .line 55760
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasLinkedChat:Z

    .line 55761
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasLocation:Z

    .line 55762
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->signMessages:Z

    .line 55763
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->showMessageSender:Z

    .line 55764
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->joinToSendMessages:Z

    .line 55765
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->joinByRequest:Z

    .line 55766
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isSlowModeEnabled:Z

    .line 55767
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isChannel:Z

    .line 55768
    move/from16 v2, p17

    iput-boolean v2, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isBroadcastGroup:Z

    .line 55769
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isForum:Z

    .line 55770
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isDirectMessagesGroup:Z

    .line 55771
    move/from16 v1, p20

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->isAdministeredDirectMessagesGroup:Z

    .line 55772
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->verificationStatus:Lorg/drinkless/tdlib/TdApi$VerificationStatus;

    .line 55773
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasDirectMessagesGroup:Z

    .line 55774
    move/from16 v1, p23

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasForumTabs:Z

    .line 55775
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

    .line 55776
    move-wide/from16 v1, p25

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->paidMessageStarCount:J

    .line 55777
    move/from16 v1, p27

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasActiveStories:Z

    .line 55778
    move/from16 v2, p28

    iput-boolean v2, v0, Lorg/drinkless/tdlib/TdApi$Supergroup;->hasUnreadActiveStories:Z

    .line 55779
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55783
    const v0, 0x36b8a9e6

    return v0
.end method
