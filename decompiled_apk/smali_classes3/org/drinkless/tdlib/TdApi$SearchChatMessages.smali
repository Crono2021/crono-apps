.class public Lorg/drinkless/tdlib/TdApi$SearchChatMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchChatMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundChatMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3fec2b64


# instance fields
.field public chatId:J

.field public filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

.field public fromMessageId:J

.field public limit:I

.field public offset:I

.field public query:Ljava/lang/String;

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52236
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52237
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$MessageSender;JIILorg/drinkless/tdlib/TdApi$SearchMessagesFilter;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p6, "j9"    # J
    .param p8, "i9"    # I
    .param p9, "i10"    # I
    .param p10, "searchMessagesFilter"    # Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 52220
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 52221
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->chatId:J

    .line 52222
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 52223
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->query:Ljava/lang/String;

    .line 52224
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 52225
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->fromMessageId:J

    .line 52226
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->offset:I

    .line 52227
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->limit:I

    .line 52228
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$SearchChatMessages;->filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 52229
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52233
    const v0, 0x3fec2b64

    return v0
.end method
