.class final Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;
.super Landroid/media/AudioDeviceCallback;
.source "ExoPlayerImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/ExoPlayerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "NoSuitableOutputPlaybackSuppressionAudioDeviceCallback"
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;


# direct methods
.method private constructor <init>(Landroidx/media3/exoplayer/ExoPlayerImpl;)V
    .locals 0

    .line 3452
    iput-object p1, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    invoke-direct {p0}, Landroid/media/AudioDeviceCallback;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/exoplayer/ExoPlayerImpl;Landroidx/media3/exoplayer/ExoPlayerImpl$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/exoplayer/ExoPlayerImpl;
    .param p2, "x1"    # Landroidx/media3/exoplayer/ExoPlayerImpl$1;

    .line 3452
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;-><init>(Landroidx/media3/exoplayer/ExoPlayerImpl;)V

    return-void
.end method


# virtual methods
.method public onAudioDevicesAdded([Landroid/media/AudioDeviceInfo;)V
    .locals 4
    .param p1, "addedDevices"    # [Landroid/media/AudioDeviceInfo;

    .line 3457
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    invoke-static {v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$2800(Landroidx/media3/exoplayer/ExoPlayerImpl;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    .line 3458
    invoke-static {v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$2900(Landroidx/media3/exoplayer/ExoPlayerImpl;)Landroidx/media3/exoplayer/PlaybackInfo;

    move-result-object v0

    iget v0, v0, Landroidx/media3/exoplayer/PlaybackInfo;->playbackSuppressionReason:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 3460
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    .line 3461
    invoke-static {v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$2900(Landroidx/media3/exoplayer/ExoPlayerImpl;)Landroidx/media3/exoplayer/PlaybackInfo;

    move-result-object v1

    iget-boolean v1, v1, Landroidx/media3/exoplayer/PlaybackInfo;->playWhenReady:Z

    .line 3460
    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$3000(Landroidx/media3/exoplayer/ExoPlayerImpl;ZII)V

    .line 3465
    :cond_0
    return-void
.end method

.method public onAudioDevicesRemoved([Landroid/media/AudioDeviceInfo;)V
    .locals 4
    .param p1, "removedDevices"    # [Landroid/media/AudioDeviceInfo;

    .line 3469
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    invoke-static {v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$2800(Landroidx/media3/exoplayer/ExoPlayerImpl;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3470
    iget-object v0, p0, Landroidx/media3/exoplayer/ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback;->this$0:Landroidx/media3/exoplayer/ExoPlayerImpl;

    .line 3471
    invoke-static {v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$2900(Landroidx/media3/exoplayer/ExoPlayerImpl;)Landroidx/media3/exoplayer/PlaybackInfo;

    move-result-object v1

    iget-boolean v1, v1, Landroidx/media3/exoplayer/PlaybackInfo;->playWhenReady:Z

    .line 3470
    const/4 v2, 0x1

    const/4 v3, 0x3

    invoke-static {v0, v1, v2, v3}, Landroidx/media3/exoplayer/ExoPlayerImpl;->access$3000(Landroidx/media3/exoplayer/ExoPlayerImpl;ZII)V

    .line 3475
    :cond_0
    return-void
.end method
