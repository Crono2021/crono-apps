.class public Lorg/drinkless/tdlib/TdApi$GetStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Story;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x77de970e


# instance fields
.field public onlyLocal:Z

.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37534
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37535
    return-void
.end method

.method public constructor <init>(JIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "z8"    # Z

    .line 37523
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37524
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetStory;->storyPosterChatId:J

    .line 37525
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetStory;->storyId:I

    .line 37526
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GetStory;->onlyLocal:Z

    .line 37527
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37531
    const v0, -0x77de970e

    return v0
.end method
