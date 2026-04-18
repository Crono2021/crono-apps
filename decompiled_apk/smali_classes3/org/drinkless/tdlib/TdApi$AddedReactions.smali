.class public Lorg/drinkless/tdlib/TdApi$AddedReactions;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddedReactions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xd7ddcb0


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public reactions:[Lorg/drinkless/tdlib/TdApi$AddedReaction;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35530
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35531
    return-void
.end method

.method public constructor <init>(I[Lorg/drinkless/tdlib/TdApi$AddedReaction;Ljava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "addedReactionArr"    # [Lorg/drinkless/tdlib/TdApi$AddedReaction;
    .param p3, "str"    # Ljava/lang/String;

    .line 35519
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35520
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$AddedReactions;->totalCount:I

    .line 35521
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$AddedReactions;->reactions:[Lorg/drinkless/tdlib/TdApi$AddedReaction;

    .line 35522
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$AddedReactions;->nextOffset:Ljava/lang/String;

    .line 35523
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35527
    const v0, 0xd7ddcb0

    return v0
.end method
