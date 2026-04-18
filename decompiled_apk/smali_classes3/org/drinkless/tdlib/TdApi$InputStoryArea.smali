.class public Lorg/drinkless/tdlib/TdApi$InputStoryArea;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryArea"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x752ae7f


# instance fields
.field public position:Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;

.field public type:Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27444
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27445
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;)V
    .locals 0
    .param p1, "storyAreaPosition"    # Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;
    .param p2, "inputStoryAreaType"    # Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;

    .line 27434
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27435
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryArea;->position:Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;

    .line 27436
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryArea;->type:Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;

    .line 27437
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27441
    const v0, 0x752ae7f

    return v0
.end method
