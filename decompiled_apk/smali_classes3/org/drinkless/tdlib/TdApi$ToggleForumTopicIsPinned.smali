.class public Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsPinned;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleForumTopicIsPinned"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x57e56693


# instance fields
.field public chatId:J

.field public forumTopicId:I

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41142
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41143
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 41131
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41132
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsPinned;->chatId:J

    .line 41133
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsPinned;->forumTopicId:I

    .line 41134
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleForumTopicIsPinned;->isPinned:Z

    .line 41135
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41139
    const v0, 0x57e56693

    return v0
.end method
