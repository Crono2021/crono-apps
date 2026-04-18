.class public Lorg/drinkless/tdlib/TdApi$AddMessageReaction;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddMessageReaction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x549855ed


# instance fields
.field public chatId:J

.field public isBig:Z

.field public messageId:J

.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

.field public updateRecentReactions:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46526
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46527
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$ReactionType;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z

    .line 46513
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46514
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddMessageReaction;->chatId:J

    .line 46515
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AddMessageReaction;->messageId:J

    .line 46516
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$AddMessageReaction;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 46517
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$AddMessageReaction;->isBig:Z

    .line 46518
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$AddMessageReaction;->updateRecentReactions:Z

    .line 46519
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46523
    const v0, 0x549855ed

    return v0
.end method
