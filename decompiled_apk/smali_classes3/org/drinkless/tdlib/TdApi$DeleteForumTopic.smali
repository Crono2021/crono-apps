.class public Lorg/drinkless/tdlib/TdApi$DeleteForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteForumTopic"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e6f2087


# instance fields
.field public chatId:J

.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25105
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 25094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25095
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteForumTopic;->chatId:J

    .line 25096
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteForumTopic;->forumTopicId:I

    .line 25097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25101
    const v0, -0x7e6f2087

    return v0
.end method
