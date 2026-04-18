.class public Lorg/drinkless/tdlib/TdApi$StoryAlbums;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAlbums"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7e8e127e


# instance fields
.field public albums:[Lorg/drinkless/tdlib/TdApi$StoryAlbum;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20346
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20347
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$StoryAlbum;)V
    .locals 0
    .param p1, "storyAlbumArr"    # [Lorg/drinkless/tdlib/TdApi$StoryAlbum;

    .line 20337
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20338
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAlbums;->albums:[Lorg/drinkless/tdlib/TdApi$StoryAlbum;

    .line 20339
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20343
    const v0, -0x7e8e127e

    return v0
.end method
