.class public Lorg/drinkless/tdlib/TdApi$GroupCall;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCall"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6ade9e5b


# instance fields
.field public canBeManaged:Z

.field public canEnableVideo:Z

.field public canSendMessages:Z

.field public canToggleCanSendMessages:Z

.field public canToggleMuteNewParticipants:Z

.field public duration:I

.field public enabledStartNotification:Z

.field public hasHiddenListeners:Z

.field public id:I

.field public inviteLink:Ljava/lang/String;

.field public isActive:Z

.field public isJoined:Z

.field public isMyVideoEnabled:Z

.field public isMyVideoPaused:Z

.field public isOwned:Z

.field public isRtmpStream:Z

.field public isVideoChat:Z

.field public isVideoRecorded:Z

.field public loadedAllParticipants:Z

.field public muteNewParticipants:Z

.field public needRejoin:Z

.field public participantCount:I

.field public recentSpeakers:[Lorg/drinkless/tdlib/TdApi$GroupCallRecentSpeaker;

.field public recordDuration:I

.field public scheduledStartDate:I

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55650
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55651
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;IZZZZZZZZIZZ[Lorg/drinkless/tdlib/TdApi$GroupCallRecentSpeaker;ZZZZZZZIZI)V
    .locals 16
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "i10"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "z10"    # Z
    .param p8, "z11"    # Z
    .param p9, "z12"    # Z
    .param p10, "z13"    # Z
    .param p11, "z14"    # Z
    .param p12, "z15"    # Z
    .param p13, "i11"    # I
    .param p14, "z16"    # Z
    .param p15, "z17"    # Z
    .param p16, "groupCallRecentSpeakerArr"    # [Lorg/drinkless/tdlib/TdApi$GroupCallRecentSpeaker;
    .param p17, "z18"    # Z
    .param p18, "z19"    # Z
    .param p19, "z20"    # Z
    .param p20, "z21"    # Z
    .param p21, "z22"    # Z
    .param p22, "z23"    # Z
    .param p23, "z24"    # Z
    .param p24, "i12"    # I
    .param p25, "z25"    # Z
    .param p26, "i13"    # I

    .line 55616
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55617
    move/from16 v1, p1

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->id:I

    .line 55618
    move-object/from16 v2, p2

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->title:Ljava/lang/String;

    .line 55619
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->inviteLink:Ljava/lang/String;

    .line 55620
    move/from16 v4, p4

    iput v4, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->scheduledStartDate:I

    .line 55621
    move/from16 v5, p5

    iput-boolean v5, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->enabledStartNotification:Z

    .line 55622
    move/from16 v6, p6

    iput-boolean v6, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isActive:Z

    .line 55623
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isVideoChat:Z

    .line 55624
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isRtmpStream:Z

    .line 55625
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isJoined:Z

    .line 55626
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->needRejoin:Z

    .line 55627
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isOwned:Z

    .line 55628
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->canBeManaged:Z

    .line 55629
    move/from16 v13, p13

    iput v13, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->participantCount:I

    .line 55630
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->hasHiddenListeners:Z

    .line 55631
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->loadedAllParticipants:Z

    .line 55632
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->recentSpeakers:[Lorg/drinkless/tdlib/TdApi$GroupCallRecentSpeaker;

    .line 55633
    move/from16 v1, p17

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isMyVideoEnabled:Z

    .line 55634
    move/from16 v1, p18

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isMyVideoPaused:Z

    .line 55635
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->canEnableVideo:Z

    .line 55636
    move/from16 v1, p20

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->muteNewParticipants:Z

    .line 55637
    move/from16 v1, p21

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->canToggleMuteNewParticipants:Z

    .line 55638
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->canSendMessages:Z

    .line 55639
    move/from16 v1, p23

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->canToggleCanSendMessages:Z

    .line 55640
    move/from16 v1, p24

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->recordDuration:I

    .line 55641
    move/from16 v1, p25

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->isVideoRecorded:Z

    .line 55642
    move/from16 v1, p26

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCall;->duration:I

    .line 55643
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55647
    const v0, -0x6ade9e5b

    return v0
.end method
