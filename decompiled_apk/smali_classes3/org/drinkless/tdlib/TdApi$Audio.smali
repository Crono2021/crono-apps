.class public Lorg/drinkless/tdlib/TdApi$Audio;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Audio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x9eb0b79


# instance fields
.field public albumCoverMinithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public albumCoverThumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public audio:Lorg/drinkless/tdlib/TdApi$File;

.field public duration:I

.field public externalAlbumCovers:[Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public fileName:Ljava/lang/String;

.field public mimeType:Ljava/lang/String;

.field public performer:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52529
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Minithumbnail;Lorg/drinkless/tdlib/TdApi$Thumbnail;[Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;
    .param p4, "str3"    # Ljava/lang/String;
    .param p5, "str4"    # Ljava/lang/String;
    .param p6, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p7, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p8, "thumbnailArr"    # [Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p9, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 52511
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52512
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Audio;->duration:I

    .line 52513
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Audio;->title:Ljava/lang/String;

    .line 52514
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Audio;->performer:Ljava/lang/String;

    .line 52515
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Audio;->fileName:Ljava/lang/String;

    .line 52516
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Audio;->mimeType:Ljava/lang/String;

    .line 52517
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Audio;->albumCoverMinithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 52518
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$Audio;->albumCoverThumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 52519
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$Audio;->externalAlbumCovers:[Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 52520
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$Audio;->audio:Lorg/drinkless/tdlib/TdApi$File;

    .line 52521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52525
    const v0, -0x9eb0b79

    return v0
.end method
