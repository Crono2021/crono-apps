.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStory;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeStory"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e5442db


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28025
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 28014
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28015
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStory;->storyPosterChatId:J

    .line 28016
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStory;->storyId:I

    .line 28017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28021
    const v0, 0x3e5442db

    return v0
.end method
