.class public Lorg/drinkless/tdlib/TdApi$EditStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x152d6614


# instance fields
.field public areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 47202
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47203
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$InputStoryContent;Lorg/drinkless/tdlib/TdApi$InputStoryAreas;Lorg/drinkless/tdlib/TdApi$FormattedText;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "inputStoryContent"    # Lorg/drinkless/tdlib/TdApi$InputStoryContent;
    .param p5, "inputStoryAreas"    # Lorg/drinkless/tdlib/TdApi$InputStoryAreas;
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 47189
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 47190
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditStory;->storyPosterChatId:J

    .line 47191
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$EditStory;->storyId:I

    .line 47192
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditStory;->content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 47193
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditStory;->areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

    .line 47194
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditStory;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 47195
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 47199
    const v0, 0x152d6614

    return v0
.end method
