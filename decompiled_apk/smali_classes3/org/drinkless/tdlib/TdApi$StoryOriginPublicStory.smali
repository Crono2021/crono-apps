.class public Lorg/drinkless/tdlib/TdApi$StoryOriginPublicStory;
.super Lorg/drinkless/tdlib/TdApi$StoryOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryOriginPublicStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2c379fbe


# instance fields
.field public chatId:J

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryOrigin;-><init>()V

    .line 32869
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryOrigin;-><init>()V

    .line 32859
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryOriginPublicStory;->chatId:J

    .line 32860
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StoryOriginPublicStory;->storyId:I

    .line 32861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32865
    const v0, 0x2c379fbe

    return v0
.end method
