.class public Lorg/drinkless/tdlib/TdApi$MessageReaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x41350781


# instance fields
.field public isChosen:Z

.field public recentSenderIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public totalCount:I

.field public type:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public usedSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48190
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48191
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;IZLorg/drinkless/tdlib/TdApi$MessageSender;[Lorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p5, "messageSenderArr"    # [Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48177
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48178
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReaction;->type:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 48179
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$MessageReaction;->totalCount:I

    .line 48180
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageReaction;->isChosen:Z

    .line 48181
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$MessageReaction;->usedSenderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48182
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$MessageReaction;->recentSenderIds:[Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48183
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48187
    const v0, -0x41350781

    return v0
.end method
