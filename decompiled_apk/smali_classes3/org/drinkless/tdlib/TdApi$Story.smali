.class public Lorg/drinkless/tdlib/TdApi$Story;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Story"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x56b03f0d


# instance fields
.field public albumIds:[I

.field public areas:[Lorg/drinkless/tdlib/TdApi$StoryArea;

.field public canBeAddedToAlbum:Z

.field public canBeDeleted:Z

.field public canBeEdited:Z

.field public canBeForwarded:Z

.field public canBeReplied:Z

.field public canGetInteractions:Z

.field public canGetStatistics:Z

.field public canToggleIsPostedToChatPage:Z

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public chosenReactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public content:Lorg/drinkless/tdlib/TdApi$StoryContent;

.field public date:I

.field public hasExpiredViewers:Z

.field public id:I

.field public interactionInfo:Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;

.field public isBeingEdited:Z

.field public isBeingPosted:Z

.field public isEdited:Z

.field public isPostedToChatPage:Z

.field public isVisibleOnlyForSelf:Z

.field public posterChatId:J

.field public posterId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

.field public repostInfo:Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55719
    return-void
.end method

.method public constructor <init>(IJLorg/drinkless/tdlib/TdApi$MessageSender;IZZZZZZZZZZZZZZLorg/drinkless/tdlib/TdApi$StoryRepostInfo;Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;Lorg/drinkless/tdlib/TdApi$ReactionType;Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;Lorg/drinkless/tdlib/TdApi$StoryContent;[Lorg/drinkless/tdlib/TdApi$StoryArea;Lorg/drinkless/tdlib/TdApi$FormattedText;[I)V
    .locals 16
    .param p1, "i9"    # I
    .param p2, "j5"    # J
    .param p4, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p5, "i10"    # I
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "z10"    # Z
    .param p9, "z11"    # Z
    .param p10, "z12"    # Z
    .param p11, "z13"    # Z
    .param p12, "z14"    # Z
    .param p13, "z15"    # Z
    .param p14, "z16"    # Z
    .param p15, "z17"    # Z
    .param p16, "z18"    # Z
    .param p17, "z19"    # Z
    .param p18, "z20"    # Z
    .param p19, "z21"    # Z
    .param p20, "storyRepostInfo"    # Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;
    .param p21, "storyInteractionInfo"    # Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;
    .param p22, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p23, "storyPrivacySettings"    # Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;
    .param p24, "storyContent"    # Lorg/drinkless/tdlib/TdApi$StoryContent;
    .param p25, "storyAreaArr"    # [Lorg/drinkless/tdlib/TdApi$StoryArea;
    .param p26, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p27, "iArr"    # [I

    .line 55684
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55685
    move/from16 v1, p1

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->id:I

    .line 55686
    move-wide/from16 v2, p2

    iput-wide v2, v0, Lorg/drinkless/tdlib/TdApi$Story;->posterChatId:J

    .line 55687
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$Story;->posterId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55688
    move/from16 v5, p5

    iput v5, v0, Lorg/drinkless/tdlib/TdApi$Story;->date:I

    .line 55689
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$Story;->isBeingPosted:Z

    .line 55690
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$Story;->isBeingEdited:Z

    .line 55691
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$Story;->isEdited:Z

    .line 55692
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$Story;->isPostedToChatPage:Z

    .line 55693
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$Story;->isVisibleOnlyForSelf:Z

    .line 55694
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$Story;->canBeAddedToAlbum:Z

    .line 55695
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Story;->canBeDeleted:Z

    .line 55696
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$Story;->canBeEdited:Z

    .line 55697
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$Story;->canBeForwarded:Z

    .line 55698
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$Story;->canBeReplied:Z

    .line 55699
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->canToggleIsPostedToChatPage:Z

    .line 55700
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->canGetStatistics:Z

    .line 55701
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->canGetInteractions:Z

    .line 55702
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->hasExpiredViewers:Z

    .line 55703
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->repostInfo:Lorg/drinkless/tdlib/TdApi$StoryRepostInfo;

    .line 55704
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->interactionInfo:Lorg/drinkless/tdlib/TdApi$StoryInteractionInfo;

    .line 55705
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->chosenReactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 55706
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 55707
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->content:Lorg/drinkless/tdlib/TdApi$StoryContent;

    .line 55708
    move-object/from16 v1, p25

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->areas:[Lorg/drinkless/tdlib/TdApi$StoryArea;

    .line 55709
    move-object/from16 v1, p26

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 55710
    move-object/from16 v1, p27

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Story;->albumIds:[I

    .line 55711
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55715
    const v0, 0x56b03f0d

    return v0
.end method
