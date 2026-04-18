.class public Lorg/drinkless/tdlib/TdApi$InputMessageStory;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1618ec15


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27384
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 27385
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 27374
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 27375
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageStory;->storyPosterChatId:J

    .line 27376
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageStory;->storyId:I

    .line 27377
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27381
    const v0, -0x1618ec15

    return v0
.end method
