.class public Lorg/drinkless/tdlib/TdApi$UpdateChatAction;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatAction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x43fff014


# instance fields
.field public action:Lorg/drinkless/tdlib/TdApi$ChatAction;

.field public chatId:J

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45990
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 45991
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$ChatAction;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p5, "chatAction"    # Lorg/drinkless/tdlib/TdApi$ChatAction;

    .line 45978
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 45979
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAction;->chatId:J

    .line 45980
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAction;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 45981
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAction;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 45982
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatAction;->action:Lorg/drinkless/tdlib/TdApi$ChatAction;

    .line 45983
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45987
    const v0, 0x43fff014

    return v0
.end method
