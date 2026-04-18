.class public Lorg/drinkless/tdlib/TdApi$StoryArea;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryArea"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3600f8a2


# instance fields
.field public position:Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;

.field public type:Lorg/drinkless/tdlib/TdApi$StoryAreaType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32769
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;Lorg/drinkless/tdlib/TdApi$StoryAreaType;)V
    .locals 0
    .param p1, "storyAreaPosition"    # Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;
    .param p2, "storyAreaType"    # Lorg/drinkless/tdlib/TdApi$StoryAreaType;

    .line 32758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 32759
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryArea;->position:Lorg/drinkless/tdlib/TdApi$StoryAreaPosition;

    .line 32760
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StoryArea;->type:Lorg/drinkless/tdlib/TdApi$StoryAreaType;

    .line 32761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32765
    const v0, -0x3600f8a2

    return v0
.end method
