.class public Lorg/drinkless/tdlib/TdApi$AvailableReaction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AvailableReaction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6fdbc79


# instance fields
.field public needsPremium:Z

.field public type:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23065
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;Z)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;
    .param p2, "z8"    # Z

    .line 23054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 23055
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AvailableReaction;->type:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 23056
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$AvailableReaction;->needsPremium:Z

    .line 23057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23061
    const v0, -0x6fdbc79

    return v0
.end method
