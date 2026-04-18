.class public Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DirectMessagesChatTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x69ffe41d


# instance fields
.field public canSendUnpaidMessages:Z

.field public chatId:J

.field public draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

.field public id:J

.field public isMarkedAsUnread:Z

.field public lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public lastReadInboxMessageId:J

.field public lastReadOutboxMessageId:J

.field public order:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public unreadCount:J

.field public unreadReactionCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54558
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54559
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageSender;JZZJJJJLorg/drinkless/tdlib/TdApi$Message;Lorg/drinkless/tdlib/TdApi$DraftMessage;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p6, "j10"    # J
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z
    .param p10, "j11"    # J
    .param p12, "j12"    # J
    .param p14, "j13"    # J
    .param p16, "j14"    # J
    .param p18, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p19, "draftMessage"    # Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 54538
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54539
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->chatId:J

    .line 54540
    move-wide/from16 v3, p3

    iput-wide v3, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->id:J

    .line 54541
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 54542
    move-wide/from16 v6, p6

    iput-wide v6, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->order:J

    .line 54543
    move/from16 v8, p8

    iput-boolean v8, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->canSendUnpaidMessages:Z

    .line 54544
    move/from16 v9, p9

    iput-boolean v9, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->isMarkedAsUnread:Z

    .line 54545
    move-wide/from16 v10, p10

    iput-wide v10, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->unreadCount:J

    .line 54546
    move-wide/from16 v12, p12

    iput-wide v12, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->lastReadInboxMessageId:J

    .line 54547
    move-wide/from16 v14, p14

    iput-wide v14, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->lastReadOutboxMessageId:J

    .line 54548
    move-wide/from16 v1, p16

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->unreadReactionCount:J

    .line 54549
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 54550
    move-object/from16 v2, p19

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$DirectMessagesChatTopic;->draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 54551
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54555
    const v0, 0x69ffe41d

    return v0
.end method
