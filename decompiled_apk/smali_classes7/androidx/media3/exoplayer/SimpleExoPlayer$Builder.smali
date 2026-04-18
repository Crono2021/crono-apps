.class public final Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
.super Ljava/lang/Object;
.source "SimpleExoPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/SimpleExoPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field private final wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    new-instance v0, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-direct {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 96
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "renderersFactory"    # Landroidx/media3/exoplayer/RenderersFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    new-instance v0, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-direct {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 104
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;Landroidx/media3/exoplayer/trackselection/TrackSelector;Landroidx/media3/exoplayer/source/MediaSource$Factory;Landroidx/media3/exoplayer/LoadControl;Landroidx/media3/exoplayer/upstream/BandwidthMeter;Landroidx/media3/exoplayer/analytics/AnalyticsCollector;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "renderersFactory"    # Landroidx/media3/exoplayer/RenderersFactory;
    .param p3, "trackSelector"    # Landroidx/media3/exoplayer/trackselection/TrackSelector;
    .param p4, "mediaSourceFactory"    # Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .param p5, "loadControl"    # Landroidx/media3/exoplayer/LoadControl;
    .param p6, "bandwidthMeter"    # Landroidx/media3/exoplayer/upstream/BandwidthMeter;
    .param p7, "analyticsCollector"    # Landroidx/media3/exoplayer/analytics/AnalyticsCollector;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 142
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    new-instance v8, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    move-object v0, v8

    move-object v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p3

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    invoke-direct/range {v0 .. v7}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;Landroidx/media3/exoplayer/source/MediaSource$Factory;Landroidx/media3/exoplayer/trackselection/TrackSelector;Landroidx/media3/exoplayer/LoadControl;Landroidx/media3/exoplayer/upstream/BandwidthMeter;Landroidx/media3/exoplayer/analytics/AnalyticsCollector;)V

    move-object v0, p0

    iput-object v8, v0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 152
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;Landroidx/media3/extractor/ExtractorsFactory;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "renderersFactory"    # Landroidx/media3/exoplayer/RenderersFactory;
    .param p3, "extractorsFactory"    # Landroidx/media3/extractor/ExtractorsFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 123
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 124
    new-instance v0, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    new-instance v1, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;

    invoke-direct {v1, p1, p3}, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;-><init>(Landroid/content/Context;Landroidx/media3/extractor/ExtractorsFactory;)V

    invoke-direct {v0, p1, p2, v1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/RenderersFactory;Landroidx/media3/exoplayer/source/MediaSource$Factory;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 127
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/extractor/ExtractorsFactory;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "extractorsFactory"    # Landroidx/media3/extractor/ExtractorsFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 112
    new-instance v0, Landroidx/media3/exoplayer/ExoPlayer$Builder;

    new-instance v1, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;

    invoke-direct {v1, p1, p2}, Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;-><init>(Landroid/content/Context;Landroidx/media3/extractor/ExtractorsFactory;)V

    invoke-direct {v0, p1, v1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/source/MediaSource$Factory;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 114
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;)Landroidx/media3/exoplayer/ExoPlayer$Builder;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;

    .line 86
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    return-object v0
.end method


# virtual methods
.method public build()Landroidx/media3/exoplayer/SimpleExoPlayer;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 395
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->buildSimpleExoPlayer()Landroidx/media3/exoplayer/SimpleExoPlayer;

    move-result-object v0

    return-object v0
.end method

.method public experimentalSetForegroundModeTimeoutMs(J)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "timeoutMs"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 161
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->experimentalSetForegroundModeTimeoutMs(J)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 162
    return-object p0
.end method

.method public setAnalyticsCollector(Landroidx/media3/exoplayer/analytics/AnalyticsCollector;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "analyticsCollector"    # Landroidx/media3/exoplayer/analytics/AnalyticsCollector;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 221
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setAnalyticsCollector(Landroidx/media3/exoplayer/analytics/AnalyticsCollector;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 222
    return-object p0
.end method

.method public setAudioAttributes(Landroidx/media3/common/AudioAttributes;Z)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "audioAttributes"    # Landroidx/media3/common/AudioAttributes;
    .param p2, "handleAudioFocus"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 243
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setAudioAttributes(Landroidx/media3/common/AudioAttributes;Z)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 244
    return-object p0
.end method

.method public setBandwidthMeter(Landroidx/media3/exoplayer/upstream/BandwidthMeter;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "bandwidthMeter"    # Landroidx/media3/exoplayer/upstream/BandwidthMeter;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 201
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setBandwidthMeter(Landroidx/media3/exoplayer/upstream/BandwidthMeter;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 202
    return-object p0
.end method

.method public setClock(Landroidx/media3/common/util/Clock;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "clock"    # Landroidx/media3/common/util/Clock;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 386
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setClock(Landroidx/media3/common/util/Clock;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 387
    return-object p0
.end method

.method public setDetachSurfaceTimeoutMs(J)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "detachSurfaceTimeoutMs"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 354
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setDetachSurfaceTimeoutMs(J)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 355
    return-object p0
.end method

.method public setHandleAudioBecomingNoisy(Z)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "handleAudioBecomingNoisy"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 263
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setHandleAudioBecomingNoisy(Z)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 264
    return-object p0
.end method

.method public setLivePlaybackSpeedControl(Landroidx/media3/exoplayer/LivePlaybackSpeedControl;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "livePlaybackSpeedControl"    # Landroidx/media3/exoplayer/LivePlaybackSpeedControl;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 375
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setLivePlaybackSpeedControl(Landroidx/media3/exoplayer/LivePlaybackSpeedControl;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 376
    return-object p0
.end method

.method public setLoadControl(Landroidx/media3/exoplayer/LoadControl;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "loadControl"    # Landroidx/media3/exoplayer/LoadControl;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 191
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setLoadControl(Landroidx/media3/exoplayer/LoadControl;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 192
    return-object p0
.end method

.method public setLooper(Landroid/os/Looper;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "looper"    # Landroid/os/Looper;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 211
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setLooper(Landroid/os/Looper;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 212
    return-object p0
.end method

.method public setMediaSourceFactory(Landroidx/media3/exoplayer/source/MediaSource$Factory;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "mediaSourceFactory"    # Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 181
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setMediaSourceFactory(Landroidx/media3/exoplayer/source/MediaSource$Factory;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 182
    return-object p0
.end method

.method public setPauseAtEndOfMediaItems(Z)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "pauseAtEndOfMediaItems"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 364
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setPauseAtEndOfMediaItems(Z)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 365
    return-object p0
.end method

.method public setPriorityTaskManager(Landroidx/media3/common/PriorityTaskManager;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "priorityTaskManager"    # Landroidx/media3/common/PriorityTaskManager;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 232
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setPriorityTaskManager(Landroidx/media3/common/PriorityTaskManager;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 233
    return-object p0
.end method

.method public setReleaseTimeoutMs(J)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "releaseTimeoutMs"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 344
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setReleaseTimeoutMs(J)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 345
    return-object p0
.end method

.method public setSeekBackIncrementMs(J)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "seekBackIncrementMs"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 324
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setSeekBackIncrementMs(J)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 325
    return-object p0
.end method

.method public setSeekForwardIncrementMs(J)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "seekForwardIncrementMs"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 334
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1, p2}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setSeekForwardIncrementMs(J)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 335
    return-object p0
.end method

.method public setSeekParameters(Landroidx/media3/exoplayer/SeekParameters;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 314
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setSeekParameters(Landroidx/media3/exoplayer/SeekParameters;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 315
    return-object p0
.end method

.method public setSkipSilenceEnabled(Z)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "skipSilenceEnabled"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 273
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setSkipSilenceEnabled(Z)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 274
    return-object p0
.end method

.method public setTrackSelector(Landroidx/media3/exoplayer/trackselection/TrackSelector;)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "trackSelector"    # Landroidx/media3/exoplayer/trackselection/TrackSelector;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 171
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setTrackSelector(Landroidx/media3/exoplayer/trackselection/TrackSelector;)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 172
    return-object p0
.end method

.method public setUseLazyPreparation(Z)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "useLazyPreparation"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 304
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setUseLazyPreparation(Z)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 305
    return-object p0
.end method

.method public setVideoChangeFrameRateStrategy(I)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "videoChangeFrameRateStrategy"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 294
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setVideoChangeFrameRateStrategy(I)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 295
    return-object p0
.end method

.method public setVideoScalingMode(I)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "videoScalingMode"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 283
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setVideoScalingMode(I)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 284
    return-object p0
.end method

.method public setWakeMode(I)Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;
    .locals 1
    .param p1, "wakeMode"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 253
    iget-object v0, p0, Landroidx/media3/exoplayer/SimpleExoPlayer$Builder;->wrappedBuilder:Landroidx/media3/exoplayer/ExoPlayer$Builder;

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/ExoPlayer$Builder;->setWakeMode(I)Landroidx/media3/exoplayer/ExoPlayer$Builder;

    .line 254
    return-object p0
.end method
