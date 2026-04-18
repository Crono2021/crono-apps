.class public Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeView;
.super Lorg/drinkless/tdlib/TdApi$StoryInteractionType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteractionTypeView"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x53e337d0


# instance fields
.field public chosenReactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20472
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20473
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 20463
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryInteractionType;-><init>()V

    .line 20464
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteractionTypeView;->chosenReactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 20465
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20469
    const v0, 0x53e337d0

    return v0
.end method
