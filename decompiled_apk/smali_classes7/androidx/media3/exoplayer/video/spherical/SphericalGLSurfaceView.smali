.class public final Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;
.super Landroid/opengl/GLSurfaceView;
.source "SphericalGLSurfaceView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$Renderer;,
        Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;
    }
.end annotation


# static fields
.field private static final FIELD_OF_VIEW_DEGREES:I = 0x5a

.field private static final PX_PER_DEGREES:F = 25.0f

.field static final UPRIGHT_ROLL:F = 3.1415927f

.field private static final Z_FAR:F = 100.0f

.field private static final Z_NEAR:F = 0.1f


# instance fields
.field private isOrientationListenerRegistered:Z

.field private isStarted:Z

.field private final mainHandler:Landroid/os/Handler;

.field private final orientationListener:Landroidx/media3/exoplayer/video/spherical/OrientationListener;

.field private final orientationSensor:Landroid/hardware/Sensor;

.field private final scene:Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

.field private final sensorManager:Landroid/hardware/SensorManager;

.field private surface:Landroid/view/Surface;

.field private surfaceTexture:Landroid/graphics/SurfaceTexture;

.field private final touchTracker:Landroidx/media3/exoplayer/video/spherical/TouchTracker;

.field private useSensorRotation:Z

.field private final videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/CopyOnWriteArrayList<",
            "Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 95
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 96
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .line 99
    invoke-direct {p0, p1, p2}, Landroid/opengl/GLSurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 100
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    .line 101
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->mainHandler:Landroid/os/Handler;

    .line 104
    nop

    .line 105
    const-string/jumbo v0, "sensor"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/SensorManager;

    iput-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->sensorManager:Landroid/hardware/SensorManager;

    .line 106
    const/4 v1, 0x0

    .line 107
    .local v1, "orientationSensor":Landroid/hardware/Sensor;
    sget v2, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v3, 0x12

    if-lt v2, v3, :cond_0

    .line 112
    const/16 v2, 0xf

    invoke-virtual {v0, v2}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v1

    .line 114
    :cond_0
    if-nez v1, :cond_1

    .line 115
    const/16 v2, 0xb

    invoke-virtual {v0, v2}, Landroid/hardware/SensorManager;->getDefaultSensor(I)Landroid/hardware/Sensor;

    move-result-object v1

    .line 117
    :cond_1
    iput-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->orientationSensor:Landroid/hardware/Sensor;

    .line 119
    new-instance v0, Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

    invoke-direct {v0}, Landroidx/media3/exoplayer/video/spherical/SceneRenderer;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->scene:Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

    .line 120
    new-instance v2, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$Renderer;

    invoke-direct {v2, p0, v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$Renderer;-><init>(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;Landroidx/media3/exoplayer/video/spherical/SceneRenderer;)V

    move-object v0, v2

    .line 122
    .local v0, "renderer":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$Renderer;
    new-instance v2, Landroidx/media3/exoplayer/video/spherical/TouchTracker;

    const/high16 v3, 0x41c80000    # 25.0f

    invoke-direct {v2, p1, v0, v3}, Landroidx/media3/exoplayer/video/spherical/TouchTracker;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/video/spherical/TouchTracker$Listener;F)V

    iput-object v2, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->touchTracker:Landroidx/media3/exoplayer/video/spherical/TouchTracker;

    .line 123
    const-string/jumbo v3, "window"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/WindowManager;

    .line 124
    .local v3, "windowManager":Landroid/view/WindowManager;
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/view/WindowManager;

    invoke-interface {v4}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v4

    .line 125
    .local v4, "display":Landroid/view/Display;
    new-instance v5, Landroidx/media3/exoplayer/video/spherical/OrientationListener;

    const/4 v6, 0x2

    new-array v7, v6, [Landroidx/media3/exoplayer/video/spherical/OrientationListener$Listener;

    const/4 v8, 0x0

    aput-object v2, v7, v8

    const/4 v8, 0x1

    aput-object v0, v7, v8

    invoke-direct {v5, v4, v7}, Landroidx/media3/exoplayer/video/spherical/OrientationListener;-><init>(Landroid/view/Display;[Landroidx/media3/exoplayer/video/spherical/OrientationListener$Listener;)V

    iput-object v5, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->orientationListener:Landroidx/media3/exoplayer/video/spherical/OrientationListener;

    .line 126
    iput-boolean v8, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->useSensorRotation:Z

    .line 128
    invoke-virtual {p0, v6}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->setEGLContextClientVersion(I)V

    .line 129
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->setRenderer(Landroid/opengl/GLSurfaceView$Renderer;)V

    .line 130
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 131
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;Landroid/graphics/SurfaceTexture;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;
    .param p1, "x1"    # Landroid/graphics/SurfaceTexture;

    .line 59
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;)V

    return-void
.end method

.method private onSurfaceTextureAvailable(Landroid/graphics/SurfaceTexture;)V
    .locals 2
    .param p1, "newSurfaceTexture"    # Landroid/graphics/SurfaceTexture;

    .line 236
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->mainHandler:Landroid/os/Handler;

    new-instance v1, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0, p1}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;Landroid/graphics/SurfaceTexture;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 248
    return-void
.end method

.method private static releaseSurface(Landroid/graphics/SurfaceTexture;Landroid/view/Surface;)V
    .locals 0
    .param p0, "oldSurfaceTexture"    # Landroid/graphics/SurfaceTexture;
    .param p1, "oldSurface"    # Landroid/view/Surface;

    .line 252
    if-eqz p0, :cond_0

    .line 253
    invoke-virtual {p0}, Landroid/graphics/SurfaceTexture;->release()V

    .line 255
    :cond_0
    if-eqz p1, :cond_1

    .line 256
    invoke-virtual {p1}, Landroid/view/Surface;->release()V

    .line 258
    :cond_1
    return-void
.end method

.method private updateOrientationListenerRegistration()V
    .locals 5

    .line 221
    iget-boolean v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->useSensorRotation:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->isStarted:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    move v0, v1

    .line 222
    .local v0, "enabled":Z
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->orientationSensor:Landroid/hardware/Sensor;

    if-eqz v2, :cond_3

    iget-boolean v3, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->isOrientationListenerRegistered:Z

    if-ne v0, v3, :cond_1

    goto :goto_2

    .line 225
    :cond_1
    if-eqz v0, :cond_2

    .line 226
    iget-object v3, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->sensorManager:Landroid/hardware/SensorManager;

    iget-object v4, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->orientationListener:Landroidx/media3/exoplayer/video/spherical/OrientationListener;

    invoke-virtual {v3, v4, v2, v1}, Landroid/hardware/SensorManager;->registerListener(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z

    goto :goto_1

    .line 229
    :cond_2
    iget-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->sensorManager:Landroid/hardware/SensorManager;

    iget-object v2, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->orientationListener:Landroidx/media3/exoplayer/video/spherical/OrientationListener;

    invoke-virtual {v1, v2}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 231
    :goto_1
    iput-boolean v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->isOrientationListenerRegistered:Z

    .line 232
    return-void

    .line 223
    :cond_3
    :goto_2
    return-void
.end method


# virtual methods
.method public addVideoSurfaceListener(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;

    .line 139
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->add(Ljava/lang/Object;)Z

    .line 140
    return-void
.end method

.method public getCameraMotionListener()Landroidx/media3/exoplayer/video/spherical/CameraMotionListener;
    .locals 1

    .line 167
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->scene:Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

    return-object v0
.end method

.method public getVideoFrameMetadataListener()Landroidx/media3/exoplayer/video/VideoFrameMetadataListener;
    .locals 1

    .line 162
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->scene:Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

    return-object v0
.end method

.method public getVideoSurface()Landroid/view/Surface;
    .locals 1

    .line 157
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surface:Landroid/view/Surface;

    return-object v0
.end method

.method synthetic lambda$onDetachedFromWindow$0$androidx-media3-exoplayer-video-spherical-SphericalGLSurfaceView()V
    .locals 3

    .line 208
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surface:Landroid/view/Surface;

    .line 209
    .local v0, "oldSurface":Landroid/view/Surface;
    if-eqz v0, :cond_0

    .line 210
    iget-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v1}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;

    .line 211
    .local v2, "videoSurfaceListener":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;
    invoke-interface {v2, v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;->onVideoSurfaceDestroyed(Landroid/view/Surface;)V

    .line 212
    .end local v2    # "videoSurfaceListener":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;
    goto :goto_0

    .line 214
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surfaceTexture:Landroid/graphics/SurfaceTexture;

    invoke-static {v1, v0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->releaseSurface(Landroid/graphics/SurfaceTexture;Landroid/view/Surface;)V

    .line 215
    const/4 v1, 0x0

    iput-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 216
    iput-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surface:Landroid/view/Surface;

    .line 217
    return-void
.end method

.method synthetic lambda$onSurfaceTextureAvailable$1$androidx-media3-exoplayer-video-spherical-SphericalGLSurfaceView(Landroid/graphics/SurfaceTexture;)V
    .locals 5
    .param p1, "newSurfaceTexture"    # Landroid/graphics/SurfaceTexture;

    .line 238
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 239
    .local v0, "oldSurfaceTexture":Landroid/graphics/SurfaceTexture;
    iget-object v1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surface:Landroid/view/Surface;

    .line 240
    .local v1, "oldSurface":Landroid/view/Surface;
    new-instance v2, Landroid/view/Surface;

    invoke-direct {v2, p1}, Landroid/view/Surface;-><init>(Landroid/graphics/SurfaceTexture;)V

    .line 241
    .local v2, "newSurface":Landroid/view/Surface;
    iput-object p1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surfaceTexture:Landroid/graphics/SurfaceTexture;

    .line 242
    iput-object v2, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->surface:Landroid/view/Surface;

    .line 243
    iget-object v3, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v3}, Ljava/util/concurrent/CopyOnWriteArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;

    .line 244
    .local v4, "videoSurfaceListener":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;
    invoke-interface {v4, v2}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;->onVideoSurfaceCreated(Landroid/view/Surface;)V

    .line 245
    .end local v4    # "videoSurfaceListener":Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;
    goto :goto_0

    .line 246
    :cond_0
    invoke-static {v0, v1}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->releaseSurface(Landroid/graphics/SurfaceTexture;Landroid/view/Surface;)V

    .line 247
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 2

    .line 203
    invoke-super {p0}, Landroid/opengl/GLSurfaceView;->onDetachedFromWindow()V

    .line 206
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->mainHandler:Landroid/os/Handler;

    new-instance v1, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$$ExternalSyntheticLambda1;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 218
    return-void
.end method

.method public onPause()V
    .locals 1

    .line 195
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->isStarted:Z

    .line 196
    invoke-direct {p0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->updateOrientationListenerRegistration()V

    .line 197
    invoke-super {p0}, Landroid/opengl/GLSurfaceView;->onPause()V

    .line 198
    return-void
.end method

.method public onResume()V
    .locals 1

    .line 188
    invoke-super {p0}, Landroid/opengl/GLSurfaceView;->onResume()V

    .line 189
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->isStarted:Z

    .line 190
    invoke-direct {p0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->updateOrientationListenerRegistration()V

    .line 191
    return-void
.end method

.method public removeVideoSurfaceListener(Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;)V
    .locals 1
    .param p1, "listener"    # Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView$VideoSurfaceListener;

    .line 148
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->videoSurfaceListeners:Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/CopyOnWriteArrayList;->remove(Ljava/lang/Object;)Z

    .line 149
    return-void
.end method

.method public setDefaultStereoMode(I)V
    .locals 1
    .param p1, "stereoMode"    # I

    .line 177
    iget-object v0, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->scene:Landroidx/media3/exoplayer/video/spherical/SceneRenderer;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/video/spherical/SceneRenderer;->setDefaultStereoMode(I)V

    .line 178
    return-void
.end method

.method public setUseSensorRotation(Z)V
    .locals 0
    .param p1, "useSensorRotation"    # Z

    .line 182
    iput-boolean p1, p0, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->useSensorRotation:Z

    .line 183
    invoke-direct {p0}, Landroidx/media3/exoplayer/video/spherical/SphericalGLSurfaceView;->updateOrientationListenerRegistration()V

    .line 184
    return-void
.end method
