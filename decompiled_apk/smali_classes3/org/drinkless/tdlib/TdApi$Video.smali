.class public Lorg/drinkless/tdlib/TdApi$Video;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Video"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x31a460cc


# instance fields
.field public duration:I

.field public fileName:Ljava/lang/String;

.field public hasStickers:Z

.field public height:I

.field public mimeType:Ljava/lang/String;

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public supportsStreaming:Z

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public video:Lorg/drinkless/tdlib/TdApi$File;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53564
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53565
    return-void
.end method

.method public constructor <init>(IIILjava/lang/String;Ljava/lang/String;ZZLorg/drinkless/tdlib/TdApi$Minithumbnail;Lorg/drinkless/tdlib/TdApi$Thumbnail;Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "i11"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "str2"    # Ljava/lang/String;
    .param p6, "z8"    # Z
    .param p7, "z9"    # Z
    .param p8, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p9, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p10, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 53546
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53547
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Video;->duration:I

    .line 53548
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$Video;->width:I

    .line 53549
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$Video;->height:I

    .line 53550
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Video;->fileName:Ljava/lang/String;

    .line 53551
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Video;->mimeType:Ljava/lang/String;

    .line 53552
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$Video;->hasStickers:Z

    .line 53553
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$Video;->supportsStreaming:Z

    .line 53554
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$Video;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 53555
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$Video;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 53556
    iput-object p10, p0, Lorg/drinkless/tdlib/TdApi$Video;->video:Lorg/drinkless/tdlib/TdApi$File;

    .line 53557
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53561
    const v0, 0x31a460cc

    return v0
.end method
