.class public Lorg/drinkless/tdlib/TdApi$Message;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Message"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1e206dd0


# instance fields
.field public authorSignature:Ljava/lang/String;

.field public autoDeleteIn:D

.field public canBeSaved:Z

.field public chatId:J

.field public containsUnreadMention:Z

.field public content:Lorg/drinkless/tdlib/TdApi$MessageContent;

.field public date:I

.field public editDate:I

.field public effectId:J

.field public factCheck:Lorg/drinkless/tdlib/TdApi$FactCheck;

.field public forwardInfo:Lorg/drinkless/tdlib/TdApi$MessageForwardInfo;

.field public hasTimestampedMedia:Z

.field public id:J

.field public importInfo:Lorg/drinkless/tdlib/TdApi$MessageImportInfo;

.field public interactionInfo:Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;

.field public isChannelPost:Z

.field public isFromOffline:Z

.field public isOutgoing:Z

.field public isPaidStarSuggestedPost:Z

.field public isPaidTonSuggestedPost:Z

.field public isPinned:Z

.field public mediaAlbumId:J

.field public paidMessageStarCount:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$MessageReplyTo;

.field public restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

.field public schedulingState:Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;

.field public selfDestructIn:D

.field public selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

.field public senderBoostCount:I

.field public senderBusinessBotUserId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public sendingState:Lorg/drinkless/tdlib/TdApi$MessageSendingState;

.field public suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

.field public unreadReactions:[Lorg/drinkless/tdlib/TdApi$UnreadReaction;

.field public viaBotUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55015
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;JLorg/drinkless/tdlib/TdApi$MessageSendingState;Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;ZZZZZZZZZIILorg/drinkless/tdlib/TdApi$MessageForwardInfo;Lorg/drinkless/tdlib/TdApi$MessageImportInfo;Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;[Lorg/drinkless/tdlib/TdApi$UnreadReaction;Lorg/drinkless/tdlib/TdApi$FactCheck;Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;Lorg/drinkless/tdlib/TdApi$MessageReplyTo;Lorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;DDJJIJLjava/lang/String;JJLorg/drinkless/tdlib/TdApi$RestrictionInfo;Lorg/drinkless/tdlib/TdApi$MessageContent;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "j9"    # J
    .param p6, "messageSendingState"    # Lorg/drinkless/tdlib/TdApi$MessageSendingState;
    .param p7, "messageSchedulingState"    # Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z
    .param p10, "z10"    # Z
    .param p11, "z11"    # Z
    .param p12, "z12"    # Z
    .param p13, "z13"    # Z
    .param p14, "z14"    # Z
    .param p15, "z15"    # Z
    .param p16, "z16"    # Z
    .param p17, "i9"    # I
    .param p18, "i10"    # I
    .param p19, "messageForwardInfo"    # Lorg/drinkless/tdlib/TdApi$MessageForwardInfo;
    .param p20, "messageImportInfo"    # Lorg/drinkless/tdlib/TdApi$MessageImportInfo;
    .param p21, "messageInteractionInfo"    # Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;
    .param p22, "unreadReactionArr"    # [Lorg/drinkless/tdlib/TdApi$UnreadReaction;
    .param p23, "factCheck"    # Lorg/drinkless/tdlib/TdApi$FactCheck;
    .param p24, "suggestedPostInfo"    # Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;
    .param p25, "messageReplyTo"    # Lorg/drinkless/tdlib/TdApi$MessageReplyTo;
    .param p26, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p27, "messageSelfDestructType"    # Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;
    .param p28, "d9"    # D
    .param p30, "d10"    # D
    .param p32, "j10"    # J
    .param p34, "j11"    # J
    .param p36, "i11"    # I
    .param p37, "j12"    # J
    .param p39, "str"    # Ljava/lang/String;
    .param p40, "j13"    # J
    .param p42, "j14"    # J
    .param p44, "restrictionInfo"    # Lorg/drinkless/tdlib/TdApi$RestrictionInfo;
    .param p45, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;
    .param p46, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 54969
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54970
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->id:J

    .line 54971
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$Message;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 54972
    move-wide/from16 v4, p4

    iput-wide v4, v0, Lorg/drinkless/tdlib/TdApi$Message;->chatId:J

    .line 54973
    move-object/from16 v6, p6

    iput-object v6, v0, Lorg/drinkless/tdlib/TdApi$Message;->sendingState:Lorg/drinkless/tdlib/TdApi$MessageSendingState;

    .line 54974
    move-object/from16 v7, p7

    iput-object v7, v0, Lorg/drinkless/tdlib/TdApi$Message;->schedulingState:Lorg/drinkless/tdlib/TdApi$MessageSchedulingState;

    .line 54975
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$Message;->isOutgoing:Z

    .line 54976
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$Message;->isPinned:Z

    .line 54977
    move/from16 v10, p10

    iput-boolean v10, v0, Lorg/drinkless/tdlib/TdApi$Message;->isFromOffline:Z

    .line 54978
    move/from16 v11, p11

    iput-boolean v11, v0, Lorg/drinkless/tdlib/TdApi$Message;->canBeSaved:Z

    .line 54979
    move/from16 v12, p12

    iput-boolean v12, v0, Lorg/drinkless/tdlib/TdApi$Message;->hasTimestampedMedia:Z

    .line 54980
    move/from16 v13, p13

    iput-boolean v13, v0, Lorg/drinkless/tdlib/TdApi$Message;->isChannelPost:Z

    .line 54981
    move/from16 v14, p14

    iput-boolean v14, v0, Lorg/drinkless/tdlib/TdApi$Message;->isPaidStarSuggestedPost:Z

    .line 54982
    move/from16 v15, p15

    iput-boolean v15, v0, Lorg/drinkless/tdlib/TdApi$Message;->isPaidTonSuggestedPost:Z

    .line 54983
    move/from16 v1, p16

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->containsUnreadMention:Z

    .line 54984
    move/from16 v2, p17

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$Message;->date:I

    .line 54985
    move/from16 v1, p18

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->editDate:I

    .line 54986
    move-object/from16 v1, p19

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->forwardInfo:Lorg/drinkless/tdlib/TdApi$MessageForwardInfo;

    .line 54987
    move-object/from16 v1, p20

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->importInfo:Lorg/drinkless/tdlib/TdApi$MessageImportInfo;

    .line 54988
    move-object/from16 v1, p21

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->interactionInfo:Lorg/drinkless/tdlib/TdApi$MessageInteractionInfo;

    .line 54989
    move-object/from16 v1, p22

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->unreadReactions:[Lorg/drinkless/tdlib/TdApi$UnreadReaction;

    .line 54990
    move-object/from16 v1, p23

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->factCheck:Lorg/drinkless/tdlib/TdApi$FactCheck;

    .line 54991
    move-object/from16 v1, p24

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->suggestedPostInfo:Lorg/drinkless/tdlib/TdApi$SuggestedPostInfo;

    .line 54992
    move-object/from16 v1, p25

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->replyTo:Lorg/drinkless/tdlib/TdApi$MessageReplyTo;

    .line 54993
    move-object/from16 v1, p26

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 54994
    move-object/from16 v1, p27

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->selfDestructType:Lorg/drinkless/tdlib/TdApi$MessageSelfDestructType;

    .line 54995
    move-wide/from16 v1, p28

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->selfDestructIn:D

    .line 54996
    move-wide/from16 v1, p30

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->autoDeleteIn:D

    .line 54997
    move-wide/from16 v1, p32

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->viaBotUserId:J

    .line 54998
    move-wide/from16 v1, p34

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->senderBusinessBotUserId:J

    .line 54999
    move/from16 v1, p36

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->senderBoostCount:I

    .line 55000
    move-wide/from16 v1, p37

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->paidMessageStarCount:J

    .line 55001
    move-object/from16 v1, p39

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->authorSignature:Ljava/lang/String;

    .line 55002
    move-wide/from16 v1, p40

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->mediaAlbumId:J

    .line 55003
    move-wide/from16 v1, p42

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->effectId:J

    .line 55004
    move-object/from16 v1, p44

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->restrictionInfo:Lorg/drinkless/tdlib/TdApi$RestrictionInfo;

    .line 55005
    move-object/from16 v2, p45

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$Message;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 55006
    move-object/from16 v1, p46

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Message;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 55007
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55011
    const v0, 0x1e206dd0

    return v0
.end method
