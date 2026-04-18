.class public Lorg/drinkless/tdlib/TdApi$MessageReplyToStory;
.super Lorg/drinkless/tdlib/TdApi$MessageReplyTo;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageReplyToStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2833f0b4


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReplyTo;-><init>()V

    .line 28585
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 28574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageReplyTo;-><init>()V

    .line 28575
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToStory;->storyPosterChatId:J

    .line 28576
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageReplyToStory;->storyId:I

    .line 28577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28581
    const v0, -0x2833f0b4

    return v0
.end method
