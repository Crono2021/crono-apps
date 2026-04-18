.class public Lorg/drinkless/tdlib/TdApi$ForwardMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForwardMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xec67cde


# instance fields
.field public chatId:J

.field public fromChatId:J

.field public messageIds:[J

.field public options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

.field public removeCaption:Z

.field public sendCopy:Z

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51285
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;J[JLorg/drinkless/tdlib/TdApi$MessageSendOptions;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "j9"    # J
    .param p6, "jArr"    # [J
    .param p7, "messageSendOptions"    # Lorg/drinkless/tdlib/TdApi$MessageSendOptions;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z

    .line 51269
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51270
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->chatId:J

    .line 51271
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 51272
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->fromChatId:J

    .line 51273
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->messageIds:[J

    .line 51274
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->options:Lorg/drinkless/tdlib/TdApi$MessageSendOptions;

    .line 51275
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->sendCopy:Z

    .line 51276
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ForwardMessages;->removeCaption:Z

    .line 51277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51281
    const v0, -0xec67cde

    return v0
.end method
