.class public Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicMessageByDate;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetDirectMessagesChatTopicMessageByDate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d8609cf


# instance fields
.field public chatId:J

.field public date:I

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37312
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37313
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 37301
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37302
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicMessageByDate;->chatId:J

    .line 37303
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicMessageByDate;->topicId:J

    .line 37304
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicMessageByDate;->date:I

    .line 37305
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37309
    const v0, 0x6d8609cf

    return v0
.end method
