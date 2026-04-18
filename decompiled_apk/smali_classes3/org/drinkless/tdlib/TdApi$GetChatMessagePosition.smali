.class public Lorg/drinkless/tdlib/TdApi$GetChatMessagePosition;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatMessagePosition"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Count;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x578290f1


# instance fields
.field public chatId:J

.field public filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

.field public messageId:J

.field public topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43398
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43399
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageTopic;Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;J)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageTopic"    # Lorg/drinkless/tdlib/TdApi$MessageTopic;
    .param p4, "searchMessagesFilter"    # Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;
    .param p5, "j9"    # J

    .line 43386
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 43387
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessagePosition;->chatId:J

    .line 43388
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessagePosition;->topicId:Lorg/drinkless/tdlib/TdApi$MessageTopic;

    .line 43389
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessagePosition;->filter:Lorg/drinkless/tdlib/TdApi$SearchMessagesFilter;

    .line 43390
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatMessagePosition;->messageId:J

    .line 43391
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43395
    const v0, -0x578290f1

    return v0
.end method
