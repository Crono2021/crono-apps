.class public Lorg/drinkless/tdlib/TdApi$StoryInteraction;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryInteraction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x29db2dde


# instance fields
.field public actorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

.field public interactionDate:I

.field public type:Lorg/drinkless/tdlib/TdApi$StoryInteractionType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45702
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45703
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;ILorg/drinkless/tdlib/TdApi$BlockList;Lorg/drinkless/tdlib/TdApi$StoryInteractionType;)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "blockList"    # Lorg/drinkless/tdlib/TdApi$BlockList;
    .param p4, "storyInteractionType"    # Lorg/drinkless/tdlib/TdApi$StoryInteractionType;

    .line 45690
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45691
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryInteraction;->actorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 45692
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$StoryInteraction;->interactionDate:I

    .line 45693
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StoryInteraction;->blockList:Lorg/drinkless/tdlib/TdApi$BlockList;

    .line 45694
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$StoryInteraction;->type:Lorg/drinkless/tdlib/TdApi$StoryInteractionType;

    .line 45695
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45699
    const v0, -0x29db2dde

    return v0
.end method
