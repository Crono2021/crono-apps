.class public Lorg/drinkless/tdlib/TdApi$AvailableReactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvailableReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36641872


# instance fields
.field public allowCustomEmoji:Z

.field public areTags:Z

.field public popularReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

.field public recentReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

.field public topReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

.field public unavailabilityReason:Lorg/drinkless/tdlib/TdApi$ReactionUnavailabilityReason;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49395
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$AvailableReaction;[Lorg/drinkless/tdlib/TdApi$AvailableReaction;[Lorg/drinkless/tdlib/TdApi$AvailableReaction;ZZLorg/drinkless/tdlib/TdApi$ReactionUnavailabilityReason;)V
    .locals 0
    .param p1, "availableReactionArr"    # [Lorg/drinkless/tdlib/TdApi$AvailableReaction;
    .param p2, "availableReactionArr2"    # [Lorg/drinkless/tdlib/TdApi$AvailableReaction;
    .param p3, "availableReactionArr3"    # [Lorg/drinkless/tdlib/TdApi$AvailableReaction;
    .param p4, "z8"    # Z
    .param p5, "z9"    # Z
    .param p6, "reactionUnavailabilityReason"    # Lorg/drinkless/tdlib/TdApi$ReactionUnavailabilityReason;

    .line 49380
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49381
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->topReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

    .line 49382
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->recentReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

    .line 49383
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->popularReactions:[Lorg/drinkless/tdlib/TdApi$AvailableReaction;

    .line 49384
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->allowCustomEmoji:Z

    .line 49385
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->areTags:Z

    .line 49386
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$AvailableReactions;->unavailabilityReason:Lorg/drinkless/tdlib/TdApi$ReactionUnavailabilityReason;

    .line 49387
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49391
    const v0, 0x36641872

    return v0
.end method
