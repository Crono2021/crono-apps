.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStoryAlbum;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeStoryAlbum"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x13d47ad8


# instance fields
.field public storyAlbumId:I

.field public storyAlbumOwnerUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27804
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27805
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 27794
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27795
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStoryAlbum;->storyAlbumOwnerUsername:Ljava/lang/String;

    .line 27796
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeStoryAlbum;->storyAlbumId:I

    .line 27797
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27801
    const v0, -0x13d47ad8

    return v0
.end method
