.class public Lorg/drinkless/tdlib/TdApi$UnreadReaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UnreadReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x73a4c47e


# instance fields
.field public isBig:Z

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public type:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41406
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41407
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;Lorg/drinkless/tdlib/TdApi$MessageSender;Z)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "z8"    # Z

    .line 41395
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 41396
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UnreadReaction;->type:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 41397
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UnreadReaction;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 41398
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$UnreadReaction;->isBig:Z

    .line 41399
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41403
    const v0, -0x73a4c47e

    return v0
.end method
