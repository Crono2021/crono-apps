.class public Lorg/drinkless/tdlib/TdApi$EditBusinessStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Story;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1c2a5f3c


# instance fields
.field public areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

.field public privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49647
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$InputStoryContent;Lorg/drinkless/tdlib/TdApi$InputStoryAreas;Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "inputStoryContent"    # Lorg/drinkless/tdlib/TdApi$InputStoryContent;
    .param p5, "inputStoryAreas"    # Lorg/drinkless/tdlib/TdApi$InputStoryAreas;
    .param p6, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p7, "storyPrivacySettings"    # Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 49632
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49633
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->storyPosterChatId:J

    .line 49634
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->storyId:I

    .line 49635
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 49636
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

    .line 49637
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 49638
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessStory;->privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 49639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49643
    const v0, 0x1c2a5f3c

    return v0
.end method
