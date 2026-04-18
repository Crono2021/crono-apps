.class public Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AutoDownloadSettings"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3b1813e0


# instance fields
.field public isAutoDownloadEnabled:Z

.field public maxOtherFileSize:J

.field public maxPhotoFileSize:I

.field public maxVideoFileSize:J

.field public preloadLargeVideos:Z

.field public preloadNextAudio:Z

.field public preloadStories:Z

.field public useLessDataForCalls:Z

.field public videoUploadBitrate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 52562
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52563
    return-void
.end method

.method public constructor <init>(ZIJJIZZZZ)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "i9"    # I
    .param p3, "j5"    # J
    .param p5, "j9"    # J
    .param p7, "i10"    # I
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z
    .param p10, "z11"    # Z
    .param p11, "z12"    # Z

    .line 52545
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 52546
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->isAutoDownloadEnabled:Z

    .line 52547
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->maxPhotoFileSize:I

    .line 52548
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->maxVideoFileSize:J

    .line 52549
    iput-wide p5, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->maxOtherFileSize:J

    .line 52550
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->videoUploadBitrate:I

    .line 52551
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->preloadLargeVideos:Z

    .line 52552
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->preloadNextAudio:Z

    .line 52553
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->preloadStories:Z

    .line 52554
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$AutoDownloadSettings;->useLessDataForCalls:Z

    .line 52555
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 52559
    const v0, 0x3b1813e0

    return v0
.end method
