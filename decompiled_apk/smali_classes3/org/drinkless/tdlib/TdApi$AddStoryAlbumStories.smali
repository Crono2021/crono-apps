.class public Lorg/drinkless/tdlib/TdApi$AddStoryAlbumStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AddStoryAlbumStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryAlbum;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x200c8b38


# instance fields
.field public chatId:J

.field public storyAlbumId:I

.field public storyIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35509
    return-void
.end method

.method public constructor <init>(JI[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "iArr"    # [I

    .line 35497
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 35498
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AddStoryAlbumStories;->chatId:J

    .line 35499
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$AddStoryAlbumStories;->storyAlbumId:I

    .line 35500
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$AddStoryAlbumStories;->storyIds:[I

    .line 35501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35505
    const v0, -0x200c8b38

    return v0
.end method
