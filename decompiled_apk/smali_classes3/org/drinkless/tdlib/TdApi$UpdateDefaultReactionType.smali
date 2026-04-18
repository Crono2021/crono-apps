.class public Lorg/drinkless/tdlib/TdApi$UpdateDefaultReactionType;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateDefaultReactionType"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4b615105


# instance fields
.field public reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21692
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21693
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ReactionType;)V
    .locals 0
    .param p1, "reactionType"    # Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 21683
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21684
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateDefaultReactionType;->reactionType:Lorg/drinkless/tdlib/TdApi$ReactionType;

    .line 21685
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21689
    const v0, 0x4b615105    # 1.4766341E7f

    return v0
.end method
