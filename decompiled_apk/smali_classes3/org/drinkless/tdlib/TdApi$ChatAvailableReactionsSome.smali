.class public Lorg/drinkless/tdlib/TdApi$ChatAvailableReactionsSome;
.super Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatAvailableReactionsSome"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x9172a81


# instance fields
.field public maxReactionCount:I

.field public reactions:[Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;-><init>()V

    .line 23565
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ReactionType;I)V
    .locals 0
    .param p1, "reactionTypeArr"    # [Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "i9"    # I

    .line 23554
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactions;-><init>()V

    .line 23555
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactionsSome;->reactions:[Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 23556
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$ChatAvailableReactionsSome;->maxReactionCount:I

    .line 23557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23561
    const v0, 0x9172a81

    return v0
.end method
