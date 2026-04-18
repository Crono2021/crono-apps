.class public Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetDirectMessagesChatTopicHistory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Messages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3db438c4


# instance fields
.field public chatId:J

.field public fromMessageId:J

.field public limit:I

.field public offset:I

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47411
    return-void
.end method

.method public constructor <init>(JJJII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "j10"    # J
    .param p7, "i9"    # I
    .param p8, "i10"    # I

    .line 47397
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47398
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;->chatId:J

    .line 47399
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;->topicId:J

    .line 47400
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;->fromMessageId:J

    .line 47401
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;->offset:I

    .line 47402
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$GetDirectMessagesChatTopicHistory;->limit:I

    .line 47403
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47407
    const v0, 0x3db438c4

    return v0
.end method
