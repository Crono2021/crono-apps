.class public Lorg/drinkless/tdlib/TdApi$GetForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetForumTopic"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ForumTopic;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x731fbd90


# instance fields
.field public chatId:J

.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26105
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 26094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26095
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopic;->chatId:J

    .line 26096
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetForumTopic;->forumTopicId:I

    .line 26097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26101
    const v0, 0x731fbd90

    return v0
.end method
