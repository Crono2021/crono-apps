.class public Lorg/drinkless/tdlib/TdApi$SetDefaultReactionType;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetDefaultReactionType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x65038a3d


# instance fields
.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19680
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19681
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 19671
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19672
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetDefaultReactionType;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 19673
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19677
    const v0, 0x65038a3d

    return v0
.end method
