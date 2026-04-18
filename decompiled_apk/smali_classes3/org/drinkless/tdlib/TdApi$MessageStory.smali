.class public Lorg/drinkless/tdlib/TdApi$MessageStory;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a4169c1


# instance fields
.field public storyId:I

.field public storyPosterChatId:J

.field public viaMention:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38635
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 38623
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38624
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageStory;->storyPosterChatId:J

    .line 38625
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageStory;->storyId:I

    .line 38626
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$MessageStory;->viaMention:Z

    .line 38627
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38631
    const v0, 0x5a4169c1

    return v0
.end method
