.class public Lorg/drinkless/tdlib/TdApi$CreateStoryAlbum;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateStoryAlbum"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryAlbum;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ff197c9


# instance fields
.field public name:Ljava/lang/String;

.field public storyIds:[I

.field public storyPosterChatId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36499
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "iArr"    # [I

    .line 36487
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36488
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateStoryAlbum;->storyPosterChatId:J

    .line 36489
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateStoryAlbum;->name:Ljava/lang/String;

    .line 36490
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$CreateStoryAlbum;->storyIds:[I

    .line 36491
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36495
    const v0, -0x2ff197c9

    return v0
.end method
