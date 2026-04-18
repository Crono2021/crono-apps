.class public Lorg/drinkless/tdlib/TdApi$ToggleStoryIsPostedToChatPage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleStoryIsPostedToChatPage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7fa95e94


# instance fields
.field public isPostedToChatPage:Z

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41208
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41209
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 41197
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41198
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleStoryIsPostedToChatPage;->storyPosterChatId:J

    .line 41199
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleStoryIsPostedToChatPage;->storyId:I

    .line 41200
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleStoryIsPostedToChatPage;->isPostedToChatPage:Z

    .line 41201
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41205
    const v0, -0x7fa95e94

    return v0
.end method
