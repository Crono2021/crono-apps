.class public Lorg/drinkless/tdlib/TdApi$CloseStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CloseStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5c9faaeb


# instance fields
.field public storyId:I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24605
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 24594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24595
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CloseStory;->storyPosterChatId:J

    .line 24596
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$CloseStory;->storyId:I

    .line 24597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24601
    const v0, 0x5c9faaeb

    return v0
.end method
