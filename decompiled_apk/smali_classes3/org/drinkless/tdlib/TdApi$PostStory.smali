.class public Lorg/drinkless/tdlib/TdApi$PostStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PostStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Story;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66db3bde


# instance fields
.field public activePeriod:I

.field public albumIds:[I

.field public areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

.field public caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public chatId:J

.field public content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

.field public fromStoryFullId:Lorg/drinkless/tdlib/TdApi$StoryFullId;

.field public isPostedToChatPage:Z

.field public privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

.field public protectContent:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53456
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 53457
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$InputStoryContent;Lorg/drinkless/tdlib/TdApi$InputStoryAreas;Lorg/drinkless/tdlib/TdApi$FormattedText;Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;[IILorg/drinkless/tdlib/TdApi$StoryFullId;ZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "inputStoryContent"    # Lorg/drinkless/tdlib/TdApi$InputStoryContent;
    .param p4, "inputStoryAreas"    # Lorg/drinkless/tdlib/TdApi$InputStoryAreas;
    .param p5, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p6, "storyPrivacySettings"    # Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;
    .param p7, "iArr"    # [I
    .param p8, "i9"    # I
    .param p9, "storyFullId"    # Lorg/drinkless/tdlib/TdApi$StoryFullId;
    .param p10, "z8"    # Z
    .param p11, "z9"    # Z

    .line 53438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 53439
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->chatId:J

    .line 53440
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->content:Lorg/drinkless/tdlib/TdApi$InputStoryContent;

    .line 53441
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->areas:Lorg/drinkless/tdlib/TdApi$InputStoryAreas;

    .line 53442
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->caption:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 53443
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->privacySettings:Lorg/drinkless/tdlib/TdApi$StoryPrivacySettings;

    .line 53444
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->albumIds:[I

    .line 53445
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->activePeriod:I

    .line 53446
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->fromStoryFullId:Lorg/drinkless/tdlib/TdApi$StoryFullId;

    .line 53447
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->isPostedToChatPage:Z

    .line 53448
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$PostStory;->protectContent:Z

    .line 53449
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53453
    const v0, -0x66db3bde

    return v0
.end method
