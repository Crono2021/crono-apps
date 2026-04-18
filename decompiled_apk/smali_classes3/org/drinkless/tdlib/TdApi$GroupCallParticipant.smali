.class public Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallParticipant"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7abca1eb


# instance fields
.field public audioSourceId:I

.field public bio:Ljava/lang/String;

.field public canBeMutedForAllUsers:Z

.field public canBeMutedForCurrentUser:Z

.field public canBeUnmutedForAllUsers:Z

.field public canBeUnmutedForCurrentUser:Z

.field public canUnmuteSelf:Z

.field public isCurrentUser:Z

.field public isHandRaised:Z

.field public isMutedForAllUsers:Z

.field public isMutedForCurrentUser:Z

.field public isSpeaking:Z

.field public order:Ljava/lang/String;

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public screenSharingAudioSourceId:I

.field public screenSharingVideoInfo:Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;

.field public videoInfo:Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;

.field public volumeLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55302
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55303
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;IILorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;Ljava/lang/String;ZZZZZZZZZZILjava/lang/String;)V
    .locals 16
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "groupCallParticipantVideoInfo"    # Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;
    .param p5, "groupCallParticipantVideoInfo2"    # Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;
    .param p6, "str"    # Ljava/lang/String;
    .param p7, "z8"    # Z
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z
    .param p10, "z11"    # Z
    .param p11, "z12"    # Z
    .param p12, "z13"    # Z
    .param p13, "z14"    # Z
    .param p14, "z15"    # Z
    .param p15, "z16"    # Z
    .param p16, "z17"    # Z
    .param p17, "i11"    # I
    .param p18, "str2"    # Ljava/lang/String;

    .line 55276
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55277
    move-object/from16 v1, p1

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55278
    move/from16 v2, p2

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->audioSourceId:I

    .line 55279
    move/from16 v3, p3

    iput v3, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->screenSharingAudioSourceId:I

    .line 55280
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->videoInfo:Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;

    .line 55281
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->screenSharingVideoInfo:Lorg/drinkless/tdlib/TdApi$GroupCallParticipantVideoInfo;

    .line 55282
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->bio:Ljava/lang/String;

    .line 55283
    move/from16 v7, p7

    iput-boolean v7, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->isCurrentUser:Z

    .line 55284
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->isSpeaking:Z

    .line 55285
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->isHandRaised:Z

    .line 55286
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->canBeMutedForAllUsers:Z

    .line 55287
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->canBeUnmutedForAllUsers:Z

    .line 55288
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->canBeMutedForCurrentUser:Z

    .line 55289
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->canBeUnmutedForCurrentUser:Z

    .line 55290
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->isMutedForAllUsers:Z

    .line 55291
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->isMutedForCurrentUser:Z

    .line 55292
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->canUnmuteSelf:Z

    .line 55293
    move/from16 v1, p17

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->volumeLevel:I

    .line 55294
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$GroupCallParticipant;->order:Ljava/lang/String;

    .line 55295
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55299
    const v0, 0x7abca1eb

    return v0
.end method
