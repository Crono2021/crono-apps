.class public Lorg/drinkless/tdlib/TdApi$RemoveStoryAlbumStories;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RemoveStoryAlbumStories"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryAlbum;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x715c4551


# instance fields
.field public chatId:J

.field public storyAlbumId:I

.field public storyIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39515
    return-void
.end method

.method public constructor <init>(JI[I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "iArr"    # [I

    .line 39503
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39504
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$RemoveStoryAlbumStories;->chatId:J

    .line 39505
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$RemoveStoryAlbumStories;->storyAlbumId:I

    .line 39506
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$RemoveStoryAlbumStories;->storyIds:[I

    .line 39507
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39511
    const v0, 0x715c4551

    return v0
.end method
