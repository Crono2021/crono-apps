.class final Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;
.super Ljava/lang/Object;
.source "ExoPlayerImpl.java"

# interfaces
.implements Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;
.implements Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;
.implements Landroidx/media3/exoplayer/PlayerMessage$Target;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/ExoPlayerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "FrameMetadataListener"
.end annotation


# static fields
.field public static final MSG_SET_CAMERA_MOTION_LISTENER:I = 0x8

.field public static final MSG_SET_SPHERICAL_SURFACE_VIEW:I = 0x2710

.field public static final MSG_SET_VIDEO_FRAME_METADATA_LISTENER:I = 0x7


# instance fields
.field private cameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

.field private internalCameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

.field private internalVideoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

.field private videoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 3293
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/exoplayer/ExoPlayerImpl$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/exoplayer/ExoPlayerImpl$1;

    .line 3293
    invoke-direct {p0}, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(ILjava/lang/Object;)V
    .locals 2
    .param p1, "messageType"    # I
    .param p2, "message"    # Ljava/lang/Object;

    .line 3311
    sparse-switch p1, :sswitch_data_0

    goto :goto_0

    .line 3319
    :sswitch_0
    move-object v0, p2

    check-cast v0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;

    .line 3320
    .local v0, "surfaceView":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;
    if-nez v0, :cond_0

    .line 3321
    const/4 v1, 0x0

    iput-object v1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalVideoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    .line 3322
    iput-object v1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalCameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    goto :goto_0

    .line 3324
    :cond_0
    invoke-virtual {v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->getVideoFrameMetadataListener()Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalVideoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    .line 3325
    invoke-virtual {v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->getCameraMotionListener()Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalCameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    .line 3327
    goto :goto_0

    .line 3316
    .end local v0    # "surfaceView":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;
    :sswitch_1
    move-object v0, p2

    check-cast v0, Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    iput-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->cameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    .line 3317
    goto :goto_0

    .line 3313
    :sswitch_2
    move-object v0, p2

    check-cast v0, Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    iput-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->videoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    .line 3314
    nop

    .line 3340
    :goto_0
    return-void

    nop

    :sswitch_data_0
    .sparse-switch
        0x7 -> :sswitch_2
        0x8 -> :sswitch_1
        0x2710 -> :sswitch_0
    .end sparse-switch
.end method

.method public onCameraMotion(J[F)V
    .locals 1
    .param p1, "timeUs"    # J
    .param p3, "rotation"    # [F

    .line 3364
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalCameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    if-eqz v0, :cond_0

    .line 3365
    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;->onCameraMotion(J[F)V

    .line 3367
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->cameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    if-eqz v0, :cond_1

    .line 3368
    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;->onCameraMotion(J[F)V

    .line 3370
    :cond_1
    return-void
.end method

.method public onCameraMotionReset()V
    .locals 1

    .line 3374
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalCameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    if-eqz v0, :cond_0

    .line 3375
    invoke-interface {v0}, Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;->onCameraMotionReset()V

    .line 3377
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->cameraMotionListener:Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;

    if-eqz v0, :cond_1

    .line 3378
    invoke-interface {v0}, Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;->onCameraMotionReset()V

    .line 3380
    :cond_1
    return-void
.end method

.method public onVideoFrameAboutToBeRendered(JJLandroidx/media3/common/Format;Landroid/media/MediaFormat;)V
    .locals 8
    .param p1, "presentationTimeUs"    # J
    .param p3, "releaseTimeNs"    # J
    .param p5, "format"    # Landroidx/media3/common/Format;
    .param p6, "mediaFormat"    # Landroid/media/MediaFormat;

    .line 3350
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->internalVideoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    if-eqz v0, :cond_0

    .line 3351
    move-wide v1, p1

    move-wide v3, p3

    move-object v5, p5

    move-object v6, p6

    invoke-interface/range {v0 .. v6}, Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;->onVideoFrameAboutToBeRendered(JJLandroidx/media3/common/Format;Landroid/media/MediaFormat;)V

    .line 3354
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$FrameMetadataListener;->videoFrameMetadataListener:Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;

    if-eqz v1, :cond_1

    .line 3355
    move-wide v2, p1

    move-wide v4, p3

    move-object v6, p5

    move-object v7, p6

    invoke-interface/range {v1 .. v7}, Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;->onVideoFrameAboutToBeRendered(JJLandroidx/media3/common/Format;Landroid/media/MediaFormat;)V

    .line 3358
    :cond_1
    return-void
.end method
