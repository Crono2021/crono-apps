.class public Lorg/drinkless/tdlib/TdApi$Chat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Chat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x49e5141


# instance fields
.field public accentColorId:I

.field public actionBar:Lorg/drinkless/tdlib/TdApi$ChatActionBar;

.field public availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

.field public background:Lorg/drinkless/tdlib/TdApi$ChatBackground;

.field public backgroundCustomEmojiId:J

.field public blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

.field public businessBotManageBar:Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;

.field public canBeDeletedForAllUsers:Z

.field public canBeDeletedOnlyForSelf:Z

.field public canBeReported:Z

.field public chatLists:[Lorg/drinkless/tdlib/TdApi$ChatList;

.field public clientData:Ljava/lang/String;

.field public defaultDisableNotification:Z

.field public draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

.field public emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

.field public hasProtectedContent:Z

.field public hasScheduledMessages:Z

.field public id:J

.field public isMarkedAsUnread:Z

.field public isTranslatable:Z

.field public lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public lastReadInboxMessageId:J

.field public lastReadOutboxMessageId:J

.field public messageAutoDeleteTime:I

.field public messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

.field public pendingJoinRequests:Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;

.field public permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

.field public positions:[Lorg/drinkless/tdlib/TdApi$ChatPosition;

.field public profileAccentColorId:I

.field public profileBackgroundCustomEmojiId:J

.field public replyMarkupMessageId:J

.field public theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;

.field public title:Ljava/lang/String;

.field public type:Lorg/drinkless/tdlib/TdApi$ChatType;

.field public unreadCount:I

.field public unreadMentionCount:I

.field public unreadReactionCount:I

.field public upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

.field public videoChat:Lorg/drinkless/tdlib/TdApi$VideoChat;

.field public viewAsTopics:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55250
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55251
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatType;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;IJLorg/drinkless/tdlib/TdApi$UpgradedGiftColors;IJLorg/drinkless/tdlib/TdApi$ChatPermissions;Lorg/drinkless/tdlib/TdApi$Message;[Lorg/drinkless/tdlib/TdApi$ChatPosition;[Lorg/drinkless/tdlib/TdApi$ChatList;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$BlockList;ZZZZZZZZZIJJIILorg/drinkless/tdlib/TdApi$ChatNotificationSettings;Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;ILorg/drinkless/tdlib/TdApi$EmojiStatus;Lorg/drinkless/tdlib/TdApi$ChatBackground;Lorg/drinkless/tdlib/TdApi$ChatTheme;Lorg/drinkless/tdlib/TdApi$ChatActionBar;Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;Lorg/drinkless/tdlib/TdApi$VideoChat;Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;JLorg/drinkless/tdlib/TdApi$DraftMessage;Ljava/lang/String;)V
    .locals 16
    .param p1, "j5"    # J
    .param p3, "chatType"    # Lorg/drinkless/tdlib/TdApi$ChatType;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "chatPhotoInfo"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;
    .param p6, "i9"    # I
    .param p7, "j9"    # J
    .param p9, "upgradedGiftColors"    # Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;
    .param p10, "i10"    # I
    .param p11, "j10"    # J
    .param p13, "chatPermissions"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;
    .param p14, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p15, "chatPositionArr"    # [Lorg/drinkless/tdlib/TdApi$ChatPosition;
    .param p16, "chatListArr"    # [Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p17, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p18, "blockList"    # Lorg/drinkless/tdlib/TdApi$BlockList;
    .param p19, "z8"    # Z
    .param p20, "z9"    # Z
    .param p21, "z10"    # Z
    .param p22, "z11"    # Z
    .param p23, "z12"    # Z
    .param p24, "z13"    # Z
    .param p25, "z14"    # Z
    .param p26, "z15"    # Z
    .param p27, "z16"    # Z
    .param p28, "i11"    # I
    .param p29, "j11"    # J
    .param p31, "j12"    # J
    .param p33, "i12"    # I
    .param p34, "i13"    # I
    .param p35, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;
    .param p36, "chatAvailableReactions"    # Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;
    .param p37, "i14"    # I
    .param p38, "emojiStatus"    # Lorg/drinkless/tdlib/TdApi$EmojiStatus;
    .param p39, "chatBackground"    # Lorg/drinkless/tdlib/TdApi$ChatBackground;
    .param p40, "chatTheme"    # Lorg/drinkless/tdlib/TdApi$ChatTheme;
    .param p41, "chatActionBar"    # Lorg/drinkless/tdlib/TdApi$ChatActionBar;
    .param p42, "businessBotManageBar"    # Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;
    .param p43, "videoChat"    # Lorg/drinkless/tdlib/TdApi$VideoChat;
    .param p44, "chatJoinRequestsInfo"    # Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;
    .param p45, "j13"    # J
    .param p47, "draftMessage"    # Lorg/drinkless/tdlib/TdApi$DraftMessage;
    .param p48, "str2"    # Ljava/lang/String;

    .line 55200
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 55201
    move-wide/from16 v1, p1

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->id:J

    .line 55202
    move-object/from16 v3, p3

    iput-object v3, v0, Lorg/drinkless/tdlib/TdApi$Chat;->type:Lorg/drinkless/tdlib/TdApi$ChatType;

    .line 55203
    move-object/from16 v4, p4

    iput-object v4, v0, Lorg/drinkless/tdlib/TdApi$Chat;->title:Ljava/lang/String;

    .line 55204
    move-object/from16 v5, p5

    iput-object v5, v0, Lorg/drinkless/tdlib/TdApi$Chat;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

    .line 55205
    move/from16 v6, p6

    iput v6, v0, Lorg/drinkless/tdlib/TdApi$Chat;->accentColorId:I

    .line 55206
    move-wide/from16 v7, p7

    iput-wide v7, v0, Lorg/drinkless/tdlib/TdApi$Chat;->backgroundCustomEmojiId:J

    .line 55207
    move-object/from16 v9, p9

    iput-object v9, v0, Lorg/drinkless/tdlib/TdApi$Chat;->upgradedGiftColors:Lorg/drinkless/tdlib/TdApi$UpgradedGiftColors;

    .line 55208
    move/from16 v10, p10

    iput v10, v0, Lorg/drinkless/tdlib/TdApi$Chat;->profileAccentColorId:I

    .line 55209
    move-wide/from16 v11, p11

    iput-wide v11, v0, Lorg/drinkless/tdlib/TdApi$Chat;->profileBackgroundCustomEmojiId:J

    .line 55210
    move-object/from16 v13, p13

    iput-object v13, v0, Lorg/drinkless/tdlib/TdApi$Chat;->permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 55211
    move-object/from16 v14, p14

    iput-object v14, v0, Lorg/drinkless/tdlib/TdApi$Chat;->lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 55212
    move-object/from16 v15, p15

    iput-object v15, v0, Lorg/drinkless/tdlib/TdApi$Chat;->positions:[Lorg/drinkless/tdlib/TdApi$ChatPosition;

    .line 55213
    move-object/from16 v1, p16

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->chatLists:[Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 55214
    move-object/from16 v2, p17

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$Chat;->messageSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 55215
    move-object/from16 v1, p18

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 55216
    move/from16 v1, p19

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->hasProtectedContent:Z

    .line 55217
    move/from16 v1, p20

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->isTranslatable:Z

    .line 55218
    move/from16 v1, p21

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->isMarkedAsUnread:Z

    .line 55219
    move/from16 v1, p22

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->viewAsTopics:Z

    .line 55220
    move/from16 v1, p23

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->hasScheduledMessages:Z

    .line 55221
    move/from16 v1, p24

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->canBeDeletedOnlyForSelf:Z

    .line 55222
    move/from16 v1, p25

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->canBeDeletedForAllUsers:Z

    .line 55223
    move/from16 v1, p26

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->canBeReported:Z

    .line 55224
    move/from16 v1, p27

    iput-boolean v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->defaultDisableNotification:Z

    .line 55225
    move/from16 v1, p28

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->unreadCount:I

    .line 55226
    move-wide/from16 v1, p29

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->lastReadInboxMessageId:J

    .line 55227
    move-wide/from16 v1, p31

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->lastReadOutboxMessageId:J

    .line 55228
    move/from16 v1, p33

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->unreadMentionCount:I

    .line 55229
    move/from16 v2, p34

    iput v2, v0, Lorg/drinkless/tdlib/TdApi$Chat;->unreadReactionCount:I

    .line 55230
    move-object/from16 v1, p35

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 55231
    move-object/from16 v1, p36

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->availableReactions:Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;

    .line 55232
    move/from16 v1, p37

    iput v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->messageAutoDeleteTime:I

    .line 55233
    move-object/from16 v1, p38

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->emojiStatus:Lorg/drinkless/tdlib/TdApi$EmojiStatus;

    .line 55234
    move-object/from16 v1, p39

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->background:Lorg/drinkless/tdlib/TdApi$ChatBackground;

    .line 55235
    move-object/from16 v1, p40

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;

    .line 55236
    move-object/from16 v1, p41

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->actionBar:Lorg/drinkless/tdlib/TdApi$ChatActionBar;

    .line 55237
    move-object/from16 v1, p42

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->businessBotManageBar:Lorg/drinkless/tdlib/TdApi$BusinessBotManageBar;

    .line 55238
    move-object/from16 v1, p43

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->videoChat:Lorg/drinkless/tdlib/TdApi$VideoChat;

    .line 55239
    move-object/from16 v1, p44

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->pendingJoinRequests:Lorg/drinkless/tdlib/TdApi$ChatJoinRequestsInfo;

    .line 55240
    move-wide/from16 v1, p45

    iput-wide v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->replyMarkupMessageId:J

    .line 55241
    move-object/from16 v1, p47

    iput-object v1, v0, Lorg/drinkless/tdlib/TdApi$Chat;->draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 55242
    move-object/from16 v2, p48

    iput-object v2, v0, Lorg/drinkless/tdlib/TdApi$Chat;->clientData:Ljava/lang/String;

    .line 55243
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 55247
    const v0, -0x49e5141

    return v0
.end method
