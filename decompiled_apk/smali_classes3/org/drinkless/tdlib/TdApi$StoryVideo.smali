.class public Lorg/drinkless/tdlib/TdApi$StoryVideo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x562b0a45


# instance fields
.field public coverFrameTimestamp:D

.field public duration:D

.field public hasStickers:Z

.field public height:I

.field public isAnimation:Z

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public preloadPrefixSize:I

.field public thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

.field public video:Lorg/drinkless/tdlib/TdApi$File;

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53529
    return-void
.end method

.method public constructor <init>(DIIZZLorg/drinkless/tdlib/TdApi$Minithumbnail;Lorg/drinkless/tdlib/TdApi$Thumbnail;IDLorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "i9"    # I
    .param p4, "i10"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p8, "thumbnail"    # Lorg/drinkless/tdlib/TdApi$Thumbnail;
    .param p9, "i11"    # I
    .param p10, "d10"    # D
    .param p12, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 53510
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53511
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->duration:D

    .line 53512
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->width:I

    .line 53513
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->height:I

    .line 53514
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->hasStickers:Z

    .line 53515
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->isAnimation:Z

    .line 53516
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 53517
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->thumbnail:Lorg/drinkless/tdlib/TdApi$Thumbnail;

    .line 53518
    iput p9, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->preloadPrefixSize:I

    .line 53519
    iput-wide p10, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->coverFrameTimestamp:D

    .line 53520
    iput-object p12, p0, Lorg/drinkless/tdlib/TdApi$StoryVideo;->video:Lorg/drinkless/tdlib/TdApi$File;

    .line 53521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53525
    const v0, 0x562b0a45

    return v0
.end method
