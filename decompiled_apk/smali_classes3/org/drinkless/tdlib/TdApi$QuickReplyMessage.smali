.class public Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "QuickReplyMessage"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4106d0fd


# instance fields
.field public canBeEdited:Z

.field public content:Lorg/drinkless/tdlib/TdApi$MessageContent;

.field public id:J

.field public mediaAlbumId:J

.field public replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

.field public replyToMessageId:J

.field public sendingState:Lorg/drinkless/tdlib/TdApi$MessageSendingState;

.field public viaBotUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52205
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSendingState;ZJJJLorg/drinkless/tdlib/TdApi$MessageContent;Lorg/drinkless/tdlib/TdApi$ReplyMarkup;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSendingState"    # Lorg/drinkless/tdlib/TdApi$MessageSendingState;
    .param p4, "z8"    # Z
    .param p5, "j9"    # J
    .param p7, "j10"    # J
    .param p9, "j11"    # J
    .param p11, "messageContent"    # Lorg/drinkless/tdlib/TdApi$MessageContent;
    .param p12, "replyMarkup"    # Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52188
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52189
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->id:J

    .line 52190
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->sendingState:Lorg/drinkless/tdlib/TdApi$MessageSendingState;

    .line 52191
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->canBeEdited:Z

    .line 52192
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->replyToMessageId:J

    .line 52193
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->viaBotUserId:J

    .line 52194
    iput-wide p9, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->mediaAlbumId:J

    .line 52195
    iput-object p11, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->content:Lorg/drinkless/tdlib/TdApi$MessageContent;

    .line 52196
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$QuickReplyMessage;->replyMarkup:Lorg/drinkless/tdlib/TdApi$ReplyMarkup;

    .line 52197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52201
    const v0, -0x4106d0fd

    return v0
.end method
