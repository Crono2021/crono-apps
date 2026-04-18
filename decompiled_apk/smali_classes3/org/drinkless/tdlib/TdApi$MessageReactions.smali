.class public Lorg/drinkless/tdlib/TdApi$MessageReactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x57f97761


# instance fields
.field public areTags:Z

.field public canGetAddedReactions:Z

.field public paidReactors:[Lorg/drinkless/tdlib/TdApi$PaidReactor;

.field public reactions:[Lorg/drinkless/tdlib/TdApi$MessageReaction;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44310
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44311
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$MessageReaction;Z[Lorg/drinkless/tdlib/TdApi$PaidReactor;Z)V
    .locals 0
    .param p1, "messageReactionArr"    # [Lorg/drinkless/tdlib/TdApi$MessageReaction;
    .param p2, "z8"    # Z
    .param p3, "paidReactorArr"    # [Lorg/drinkless/tdlib/TdApi$PaidReactor;
    .param p4, "z9"    # Z

    .line 44298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44299
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReactions;->reactions:[Lorg/drinkless/tdlib/TdApi$MessageReaction;

    .line 44300
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageReactions;->areTags:Z

    .line 44301
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$MessageReactions;->paidReactors:[Lorg/drinkless/tdlib/TdApi$PaidReactor;

    .line 44302
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageReactions;->canGetAddedReactions:Z

    .line 44303
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44307
    const v0, 0x57f97761

    return v0
.end method
