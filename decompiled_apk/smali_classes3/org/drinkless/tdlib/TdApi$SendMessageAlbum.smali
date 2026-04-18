.class public Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendMessageAlbum"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x58ba59f4


# instance fields
.field public chatId:J

.field public inputMessageContents:[Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48632
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48633
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;Lorg/drinkless/tdlib/TdApi$MessageSendOptions;[Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p5, "messageSendOptions"    # Lorg/drinkless/tdlib/TdApi$MessageSendOptions;
    .param p6, "inputMessageContentArr"    # [Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 48619
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 48620
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;->chatId:J

    .line 48621
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 48622
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 48623
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;->options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

    .line 48624
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$SendMessageAlbum;->inputMessageContents:[Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 48625
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48629
    const v0, -0x58ba59f4

    return v0
.end method
