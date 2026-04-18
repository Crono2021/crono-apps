.class public Lorg/drinkless/tdlib/TdApi$SetDirectMessagesChatTopicIsMarkedAsUnread;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDirectMessagesChatTopicIsMarkedAsUnread"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5d8f0913


# instance fields
.field public chatId:J

.field public isMarkedAsUnread:Z

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40328
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40329
    return-void
.end method

.method public constructor <init>(JJZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z

    .line 40317
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40318
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetDirectMessagesChatTopicIsMarkedAsUnread;->chatId:J

    .line 40319
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetDirectMessagesChatTopicIsMarkedAsUnread;->topicId:J

    .line 40320
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SetDirectMessagesChatTopicIsMarkedAsUnread;->isMarkedAsUnread:Z

    .line 40321
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40325
    const v0, 0x5d8f0913

    return v0
.end method
