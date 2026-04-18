.class public Lorg/drinkless/tdlib/TdApi$MessageProperties;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageProperties"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38e04c40


# instance fields
.field public canAddOffer:Z

.field public canAddTasks:Z

.field public canBeApproved:Z

.field public canBeCopied:Z

.field public canBeCopiedToSecretChat:Z

.field public canBeDeclined:Z

.field public canBeDeletedForAllUsers:Z

.field public canBeDeletedOnlyForSelf:Z

.field public canBeEdited:Z

.field public canBeForwarded:Z

.field public canBePaid:Z

.field public canBePinned:Z

.field public canBeReplied:Z

.field public canBeRepliedInAnotherChat:Z

.field public canBeSaved:Z

.field public canBeSharedInStory:Z

.field public canEditMedia:Z

.field public canEditSchedulingState:Z

.field public canEditSuggestedPostInfo:Z

.field public canGetAuthor:Z

.field public canGetEmbeddingCode:Z

.field public canGetLink:Z

.field public canGetMediaTimestampLinks:Z

.field public canGetMessageThread:Z

.field public canGetReadDate:Z

.field public canGetStatistics:Z

.field public canGetVideoAdvertisements:Z

.field public canGetViewers:Z

.field public canMarkTasksAsDone:Z

.field public canRecognizeSpeech:Z

.field public canReportChat:Z

.field public canReportReactions:Z

.field public canReportSupergroupSpam:Z

.field public canSetFactCheck:Z

.field public needShowStatistics:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54736
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54737
    return-void
.end method

.method public constructor <init>(ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ)V
    .locals 16
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z
    .param p3, "z10"    # Z
    .param p4, "z11"    # Z
    .param p5, "z12"    # Z
    .param p6, "z13"    # Z
    .param p7, "z14"    # Z
    .param p8, "z15"    # Z
    .param p9, "z16"    # Z
    .param p10, "z17"    # Z
    .param p11, "z18"    # Z
    .param p12, "z19"    # Z
    .param p13, "z20"    # Z
    .param p14, "z21"    # Z
    .param p15, "z22"    # Z
    .param p16, "z23"    # Z
    .param p17, "z24"    # Z
    .param p18, "z25"    # Z
    .param p19, "z26"    # Z
    .param p20, "z27"    # Z
    .param p21, "z28"    # Z
    .param p22, "z29"    # Z
    .param p23, "z30"    # Z
    .param p24, "z31"    # Z
    .param p25, "z32"    # Z
    .param p26, "z33"    # Z
    .param p27, "z34"    # Z
    .param p28, "z35"    # Z
    .param p29, "z36"    # Z
    .param p30, "z37"    # Z
    .param p31, "z38"    # Z
    .param p32, "z39"    # Z
    .param p33, "z40"    # Z
    .param p34, "z41"    # Z
    .param p35, "z42"    # Z

    .line 54693
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54694
    move/from16 v1, p1

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canAddOffer:Z

    .line 54695
    move/from16 v2, p2

    iput-boolean v2, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canAddTasks:Z

    .line 54696
    move/from16 v3, p3

    iput-boolean v3, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeApproved:Z

    .line 54697
    move/from16 v4, p4

    iput-boolean v4, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeCopied:Z

    .line 54698
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeCopiedToSecretChat:Z

    .line 54699
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeDeclined:Z

    .line 54700
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeDeletedOnlyForSelf:Z

    .line 54701
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeDeletedForAllUsers:Z

    .line 54702
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeEdited:Z

    .line 54703
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeForwarded:Z

    .line 54704
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBePaid:Z

    .line 54705
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBePinned:Z

    .line 54706
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeReplied:Z

    .line 54707
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeRepliedInAnotherChat:Z

    .line 54708
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeSaved:Z

    .line 54709
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canBeSharedInStory:Z

    .line 54710
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canEditMedia:Z

    .line 54711
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canEditSchedulingState:Z

    .line 54712
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canEditSuggestedPostInfo:Z

    .line 54713
    move/from16 v1, p20

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetAuthor:Z

    .line 54714
    move/from16 v1, p21

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetEmbeddingCode:Z

    .line 54715
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetLink:Z

    .line 54716
    move/from16 v1, p23

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetMediaTimestampLinks:Z

    .line 54717
    move/from16 v1, p24

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetMessageThread:Z

    .line 54718
    move/from16 v1, p25

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetReadDate:Z

    .line 54719
    move/from16 v1, p26

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetStatistics:Z

    .line 54720
    move/from16 v1, p27

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetVideoAdvertisements:Z

    .line 54721
    move/from16 v1, p28

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canGetViewers:Z

    .line 54722
    move/from16 v1, p29

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canMarkTasksAsDone:Z

    .line 54723
    move/from16 v1, p30

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canRecognizeSpeech:Z

    .line 54724
    move/from16 v1, p31

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canReportChat:Z

    .line 54725
    move/from16 v1, p32

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canReportReactions:Z

    .line 54726
    move/from16 v1, p33

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canReportSupergroupSpam:Z

    .line 54727
    move/from16 v1, p34

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->canSetFactCheck:Z

    .line 54728
    move/from16 v1, p35

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$MessageProperties;->needShowStatistics:Z

    .line 54729
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54733
    const v0, 0x38e04c40

    return v0
.end method
