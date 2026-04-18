.class public Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateForumTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2bbe0b03


# instance fields
.field public chatId:J

.field public forumTopicId:I

.field public isPinned:Z

.field public lastReadInboxMessageId:J

.field public lastReadOutboxMessageId:J

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

.field public unreadMentionCount:I

.field public unreadReactionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52396
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52397
    return-void
.end method

.method public constructor <init>(JIZJJIILorg/drinkless/tdlib/TdApi$ChatNotificationSettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z
    .param p5, "j9"    # J
    .param p7, "j10"    # J
    .param p9, "i10"    # I
    .param p10, "i11"    # I
    .param p11, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 52380
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 52381
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->chatId:J

    .line 52382
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->forumTopicId:I

    .line 52383
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->isPinned:Z

    .line 52384
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->lastReadInboxMessageId:J

    .line 52385
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->lastReadOutboxMessageId:J

    .line 52386
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->unreadMentionCount:I

    .line 52387
    iput p10, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->unreadReactionCount:I

    .line 52388
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$UpdateForumTopic;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 52389
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52393
    const v0, 0x2bbe0b03

    return v0
.end method
