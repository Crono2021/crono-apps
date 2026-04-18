.class public Lorg/drinkless/tdlib/TdApi$SetChatDraftMessage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatDraftMessage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x211e02cf


# instance fields
.field public chatId:J

.field public draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40219
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$DraftMessage;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "draftMessage"    # Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 40207
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40208
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatDraftMessage;->chatId:J

    .line 40209
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatDraftMessage;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 40210
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetChatDraftMessage;->draftMessage:Lorg/drinkless/tdlib/TdApi$DraftMessage;

    .line 40211
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40215
    const v0, -0x211e02cf

    return v0
.end method
