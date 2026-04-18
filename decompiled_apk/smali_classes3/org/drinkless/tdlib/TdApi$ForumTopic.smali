.class public Lorg/drinkless/tdlib/TdApi$ForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForumTopic"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7cd93250


# instance fields
.field public draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

.field public info:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

.field public isPinned:Z

.field public lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

.field public lastReadInboxMessageId:J

.field public lastReadOutboxMessageId:J

.field public notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

.field public order:J

.field public unreadCount:I

.field public unreadMentionCount:I

.field public unreadReactionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53602
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53603
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;Lorg/drinkless/tdlib/TdApi$Message;JZIJJIILorg/drinkless/tdlib/TdApi$ChatNotificationSettings;Lorg/drinkless/tdlib/TdApi$DraftMessage;)V
    .locals 0
    .param p1, "forumTopicInfo"    # Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;
    .param p2, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p3, "j5"    # J
    .param p5, "z8"    # Z
    .param p6, "i9"    # I
    .param p7, "j9"    # J
    .param p9, "j10"    # J
    .param p11, "i10"    # I
    .param p12, "i11"    # I
    .param p13, "chatNotificationSettings"    # Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;
    .param p14, "draftMessage"    # Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 53583
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53584
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->info:Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;

    .line 53585
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->lastMessage:Lorg/drinkless/tdlib/TdApi$Message;

    .line 53586
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->order:J

    .line 53587
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->isPinned:Z

    .line 53588
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->unreadCount:I

    .line 53589
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->lastReadInboxMessageId:J

    .line 53590
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->lastReadOutboxMessageId:J

    .line 53591
    iput p11, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->unreadMentionCount:I

    .line 53592
    iput p12, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->unreadReactionCount:I

    .line 53593
    iput-object p13, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->notificationSettings:Lorg/drinkless/tdlib/TdApi$ChatNotificationSettings;

    .line 53594
    iput-object p14, p0, Lorg/drinkless/tdlib/TdApi$ForumTopic;->draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 53595
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53599
    const v0, -0x7cd93250

    return v0
.end method
