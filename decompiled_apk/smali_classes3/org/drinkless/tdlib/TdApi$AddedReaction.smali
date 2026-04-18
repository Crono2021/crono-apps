.class public Lorg/drinkless/tdlib/TdApi$AddedReaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddedReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b04819d


# instance fields
.field public date:I

.field public isOutgoing:Z

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public type:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42318
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42319
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;Lorg/drinkless/tdlib/TdApi$MessageSender;ZI)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "z8"    # Z
    .param p4, "i9"    # I

    .line 42306
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42307
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AddedReaction;->type:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 42308
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AddedReaction;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 42309
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AddedReaction;->isOutgoing:Z

    .line 42310
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$AddedReaction;->date:I

    .line 42311
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42315
    const v0, 0x4b04819d    # 8683933.0f

    return v0
.end method
