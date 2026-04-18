.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentStory;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x23bd824f


# instance fields
.field public isMention:Z

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29629
    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "z9"    # Z

    .line 29618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29619
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentStory;->isMention:Z

    .line 29620
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentStory;->isPinned:Z

    .line 29621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29625
    const v0, 0x23bd824f

    return v0
.end method
