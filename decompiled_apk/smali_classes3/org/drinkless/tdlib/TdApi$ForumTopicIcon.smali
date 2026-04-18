.class public Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForumTopicIcon"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30cd5e6d


# instance fields
.field public color:I

.field public customEmojiId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25585
    return-void
.end method

.method public constructor <init>(IJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "j5"    # J

    .line 25574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25575
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;->color:I

    .line 25576
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;->customEmojiId:J

    .line 25577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25581
    const v0, -0x30cd5e6d

    return v0
.end method
