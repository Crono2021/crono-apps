.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeSuggestedReaction;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypeSuggestedReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7d4751d3


# instance fields
.field public isDark:Z

.field public isFlipped:Z

.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38040
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 38041
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;ZZ)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 38029
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 38030
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeSuggestedReaction;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 38031
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeSuggestedReaction;->isDark:Z

    .line 38032
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeSuggestedReaction;->isFlipped:Z

    .line 38033
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38037
    const v0, 0x7d4751d3

    return v0
.end method
