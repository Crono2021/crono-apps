.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStoryAlbum;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeStoryAlbum"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x73580d69


# instance fields
.field public photoIcon:Lorg/drinkless/tdlib/TdApi$Photo;

.field public videoIcon:Lorg/drinkless/tdlib/TdApi$Video;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28045
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;Lorg/drinkless/tdlib/TdApi$Video;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;
    .param p2, "video"    # Lorg/drinkless/tdlib/TdApi$Video;

    .line 28034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 28035
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStoryAlbum;->photoIcon:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 28036
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeStoryAlbum;->videoIcon:Lorg/drinkless/tdlib/TdApi$Video;

    .line 28037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28041
    const v0, 0x73580d69

    return v0
.end method
