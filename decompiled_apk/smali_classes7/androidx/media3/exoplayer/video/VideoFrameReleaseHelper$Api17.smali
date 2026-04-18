.class final Landroidx/media3/exoplayer/video/VideoFrameReleaseHelper$Api17;
.super Ljava/lang/Object;
.source "VideoFrameReleaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/video/VideoFrameReleaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api17"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 658
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isPlaceholderSurface(Landroid/view/Surface;)Z
    .locals 1
    .param p0, "surface"    # Landroid/view/Surface;

    .line 662
    instance-of v0, p0, Landroidx/media3/exoplayer/video/PlaceholderSurface;

    return v0
.end method
