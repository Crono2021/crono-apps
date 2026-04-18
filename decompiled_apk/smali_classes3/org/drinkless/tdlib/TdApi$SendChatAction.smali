.class public Lorg/drinkless/tdlib/TdApi$SendChatAction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendChatAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5e94c7d4


# instance fields
.field public action:Lorg/drinkless/tdlib/TdApi$ChatAction;

.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45151
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatAction;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "chatAction"    # Lorg/drinkless/tdlib/TdApi$ChatAction;

    .line 45138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45139
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendChatAction;->chatId:J

    .line 45140
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendChatAction;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 45141
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendChatAction;->businessConnectionId:Ljava/lang/String;

    .line 45142
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SendChatAction;->action:Lorg/drinkless/tdlib/TdApi$ChatAction;

    .line 45143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45147
    const v0, -0x5e94c7d4

    return v0
.end method
