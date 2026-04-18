.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x40aa31da


# instance fields
.field public actorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public chatId:J

.field public date:I

.field public messageId:J

.field public newReactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public oldReactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50906
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50907
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$MessageSender;I[Lorg/drinkless/tdlib/TdApi$ReactionType;[Lorg/drinkless/tdlib/TdApi$ReactionType;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p6, "i9"    # I
    .param p7, "reactionTypeArr"    # [Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p8, "reactionTypeArr2"    # [Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 50892
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50893
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->chatId:J

    .line 50894
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->messageId:J

    .line 50895
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->actorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 50896
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->date:I

    .line 50897
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->oldReactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 50898
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageReaction;->newReactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 50899
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50903
    const v0, 0x40aa31da

    return v0
.end method
