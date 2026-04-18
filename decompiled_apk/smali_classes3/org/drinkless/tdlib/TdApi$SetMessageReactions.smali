.class public Lorg/drinkless/tdlib/TdApi$SetMessageReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetMessageReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x16344764


# instance fields
.field public chatId:J

.field public isBig:Z

.field public messageId:J

.field public reactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45246
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45247
    return-void
.end method

.method public constructor <init>(JJ[Lorg/drinkless/tdlib/TdApi$ReactionType;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "reactionTypeArr"    # [Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p6, "z8"    # Z

    .line 45234
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45235
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetMessageReactions;->chatId:J

    .line 45236
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetMessageReactions;->messageId:J

    .line 45237
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$SetMessageReactions;->reactionTypes:[Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 45238
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SetMessageReactions;->isBig:Z

    .line 45239
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45243
    const v0, -0x16344764

    return v0
.end method
