.class public Lorg/drinkless/tdlib/TdApi$UnpinAllDirectMessagesChatTopicMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UnpinAllDirectMessagesChatTopicMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x55845bc


# instance fields
.field public chatId:J

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33668
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33669
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 33658
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33659
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UnpinAllDirectMessagesChatTopicMessages;->chatId:J

    .line 33660
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UnpinAllDirectMessagesChatTopicMessages;->topicId:J

    .line 33661
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33665
    const v0, 0x55845bc

    return v0
.end method
