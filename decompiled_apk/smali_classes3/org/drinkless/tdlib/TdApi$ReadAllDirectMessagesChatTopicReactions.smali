.class public Lorg/drinkless/tdlib/TdApi$ReadAllDirectMessagesChatTopicReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadAllDirectMessagesChatTopicReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x44d2cc46


# instance fields
.field public chatId:J

.field public topicId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29728
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29729
    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J

    .line 29718
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29719
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReadAllDirectMessagesChatTopicReactions;->chatId:J

    .line 29720
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$ReadAllDirectMessagesChatTopicReactions;->topicId:J

    .line 29721
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29725
    const v0, 0x44d2cc46

    return v0
.end method
