.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewAlbumMediaPhoto;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewAlbumMedia;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewAlbumMediaPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x37c24c72


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$Photo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewAlbumMedia;-><init>()V

    .line 15775
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Photo;)V
    .locals 0
    .param p1, "photo"    # Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15765
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewAlbumMedia;-><init>()V

    .line 15766
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewAlbumMediaPhoto;->photo:Lorg/drinkless/tdlib/TdApi$Photo;

    .line 15767
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15771
    const v0, -0x37c24c72

    return v0
.end method
