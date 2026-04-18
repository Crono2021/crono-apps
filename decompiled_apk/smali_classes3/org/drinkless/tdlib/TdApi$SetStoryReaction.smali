.class public Lorg/drinkless/tdlib/TdApi$SetStoryReaction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetStoryReaction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xef1dc09


# instance fields
.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public storyId:I

.field public storyPosterChatId:J

.field public updateRecentReactions:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45294
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45295
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$ReactionType;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p5, "z8"    # Z

    .line 45282
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45283
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetStoryReaction;->storyPosterChatId:J

    .line 45284
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetStoryReaction;->storyId:I

    .line 45285
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetStoryReaction;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 45286
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SetStoryReaction;->updateRecentReactions:Z

    .line 45287
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45291
    const v0, 0xef1dc09

    return v0
.end method
