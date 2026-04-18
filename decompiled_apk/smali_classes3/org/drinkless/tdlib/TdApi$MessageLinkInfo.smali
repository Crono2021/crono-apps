.class public Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageLinkInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x158dde6f


# instance fields
.field public chatId:J

.field public forAlbum:Z

.field public isPublic:Z

.field public mediaTimestamp:I

.field public message:Lorg/drinkless/tdlib/TdApi$Message;

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50207
    return-void
.end method

.method public constructor <init>(ZJLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$Message;IZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "j5"    # J
    .param p4, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p5, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p6, "i9"    # I
    .param p7, "z9"    # Z

    .line 50192
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 50193
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->isPublic:Z

    .line 50194
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->chatId:J

    .line 50195
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 50196
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 50197
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->mediaTimestamp:I

    .line 50198
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$MessageLinkInfo;->forAlbum:Z

    .line 50199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50203
    const v0, 0x158dde6f

    return v0
.end method
