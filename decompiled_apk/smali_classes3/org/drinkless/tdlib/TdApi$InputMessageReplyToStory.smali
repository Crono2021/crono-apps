.class public Lorg/drinkless/tdlib/TdApi$InputMessageReplyToStory;
.super Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageReplyToStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66bfbf10


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 27365
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 27354
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;-><init>()V

    .line 27355
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToStory;->storyPosterChatId:J

    .line 27356
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$InputMessageReplyToStory;->storyId:I

    .line 27357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27361
    const v0, -0x66bfbf10

    return v0
.end method
