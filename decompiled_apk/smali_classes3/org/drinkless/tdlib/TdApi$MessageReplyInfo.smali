.class public Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReplyInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7ccb5c77


# instance fields
.field public lastMessageId:J

.field public lastReadInboxMessageId:J

.field public lastReadOutboxMessageId:J

.field public recentReplierIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public replyCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48216
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48217
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$MessageSender;JJJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "j5"    # J
    .param p5, "j9"    # J
    .param p7, "j10"    # J

    .line 48203
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48204
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;->replyCount:I

    .line 48205
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;->recentReplierIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48206
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;->lastReadInboxMessageId:J

    .line 48207
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;->lastReadOutboxMessageId:J

    .line 48208
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyInfo;->lastMessageId:J

    .line 48209
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48213
    const v0, -0x7ccb5c77

    return v0
.end method
