.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeSuggestedReaction;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeSuggestedReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6a06d84


# instance fields
.field public isDark:Z

.field public isFlipped:Z

.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 45679
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;IZZ)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 45666
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 45667
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeSuggestedReaction;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 45668
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeSuggestedReaction;->totalCount:I

    .line 45669
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeSuggestedReaction;->isDark:Z

    .line 45670
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeSuggestedReaction;->isFlipped:Z

    .line 45671
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45675
    const v0, -0x6a06d84

    return v0
.end method
