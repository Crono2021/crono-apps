.class public Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendInlineQueryResultMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x562f3b62


# instance fields
.field public chatId:J

.field public hideViaBot:Z

.field public options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

.field public queryId:J

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

.field public resultId:Ljava/lang/String;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51765
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;Lorg/drinkless/tdlib/TdApi$MessageSendOptions;JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p5, "messageSendOptions"    # Lorg/drinkless/tdlib/TdApi$MessageSendOptions;
    .param p6, "j9"    # J
    .param p8, "str"    # Ljava/lang/String;
    .param p9, "z8"    # Z

    .line 51749
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51750
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->chatId:J

    .line 51751
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 51752
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 51753
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

    .line 51754
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->queryId:J

    .line 51755
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->resultId:Ljava/lang/String;

    .line 51756
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$SendInlineQueryResultMessage;->hideViaBot:Z

    .line 51757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51761
    const v0, -0x562f3b62

    return v0
.end method
