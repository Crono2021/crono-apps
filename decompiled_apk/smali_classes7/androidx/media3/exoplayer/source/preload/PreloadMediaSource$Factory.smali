.class public final Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;
.super Ljava/lang/Object;
.source "PreloadMediaSource.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaSource$Factory;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Factory"
.end annotation


# instance fields
.field private final allocator:Landroidx/media3/exoplayer/upstream/Allocator;

.field private final bandwidthMeter:Landroidx/media3/exoplayer/upstream/BandwidthMeter;

.field private final mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

.field private final preloadControl:Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;

.field private final preloadLooper:Landroid/os/Looper;

.field private final rendererCapabilities:[Landroidx/media3/exoplayer/RendererCapabilities;

.field private final trackSelector:Landroidx/media3/exoplayer/trackselection/TrackSelector;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/MediaSource$Factory;Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;Landroidx/media3/exoplayer/trackselection/TrackSelector;Landroidx/media3/exoplayer/upstream/BandwidthMeter;[Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/exoplayer/upstream/Allocator;Landroid/os/Looper;)V
    .locals 1
    .param p1, "mediaSourceFactory"    # Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .param p2, "preloadControl"    # Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;
    .param p3, "trackSelector"    # Landroidx/media3/exoplayer/trackselection/TrackSelector;
    .param p4, "bandwidthMeter"    # Landroidx/media3/exoplayer/upstream/BandwidthMeter;
    .param p5, "rendererCapabilities"    # [Landroidx/media3/exoplayer/RendererCapabilities;
    .param p6, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p7, "preloadLooper"    # Landroid/os/Looper;

    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 129
    iput-object p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    .line 130
    iput-object p2, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadControl:Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;

    .line 131
    iput-object p3, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->trackSelector:Landroidx/media3/exoplayer/trackselection/TrackSelector;

    .line 132
    iput-object p4, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->bandwidthMeter:Landroidx/media3/exoplayer/upstream/BandwidthMeter;

    .line 133
    array-length v0, p5

    invoke-static {p5, v0}, Ljava/util/Arrays;->copyOf([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/media3/exoplayer/RendererCapabilities;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->rendererCapabilities:[Landroidx/media3/exoplayer/RendererCapabilities;

    .line 134
    iput-object p6, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    .line 135
    iput-object p7, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadLooper:Landroid/os/Looper;

    .line 136
    return-void
.end method


# virtual methods
.method public bridge synthetic createMediaSource(Landroidx/media3/common/MediaItem;)Landroidx/media3/exoplayer/source/MediaSource;
    .locals 0

    .line 92
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->createMediaSource(Landroidx/media3/common/MediaItem;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;

    move-result-object p1

    return-object p1
.end method

.method public createMediaSource(Landroidx/media3/common/MediaItem;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;
    .locals 10
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;

    .line 164
    new-instance v9, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;

    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    .line 165
    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaSource$Factory;->createMediaSource(Landroidx/media3/common/MediaItem;)Landroidx/media3/exoplayer/source/MediaSource;

    move-result-object v1

    iget-object v2, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadControl:Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;

    iget-object v3, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->trackSelector:Landroidx/media3/exoplayer/trackselection/TrackSelector;

    iget-object v4, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->bandwidthMeter:Landroidx/media3/exoplayer/upstream/BandwidthMeter;

    iget-object v5, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->rendererCapabilities:[Landroidx/media3/exoplayer/RendererCapabilities;

    iget-object v6, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    iget-object v7, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadLooper:Landroid/os/Looper;

    const/4 v8, 0x0

    move-object v0, v9

    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;-><init>(Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;Landroidx/media3/exoplayer/trackselection/TrackSelector;Landroidx/media3/exoplayer/upstream/BandwidthMeter;[Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/exoplayer/upstream/Allocator;Landroid/os/Looper;Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$1;)V

    .line 164
    return-object v9
.end method

.method public createMediaSource(Landroidx/media3/exoplayer/source/MediaSource;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;
    .locals 10
    .param p1, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;

    .line 175
    new-instance v9, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadControl:Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;

    iget-object v3, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->trackSelector:Landroidx/media3/exoplayer/trackselection/TrackSelector;

    iget-object v4, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->bandwidthMeter:Landroidx/media3/exoplayer/upstream/BandwidthMeter;

    iget-object v5, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->rendererCapabilities:[Landroidx/media3/exoplayer/RendererCapabilities;

    iget-object v6, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    iget-object v7, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->preloadLooper:Landroid/os/Looper;

    const/4 v8, 0x0

    move-object v0, v9

    move-object v1, p1

    invoke-direct/range {v0 .. v8}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource;-><init>(Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$PreloadControl;Landroidx/media3/exoplayer/trackselection/TrackSelector;Landroidx/media3/exoplayer/upstream/BandwidthMeter;[Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/exoplayer/upstream/Allocator;Landroid/os/Looper;Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$1;)V

    return-object v9
.end method

.method public getSupportedTypes()[I
    .locals 1

    .line 159
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaSource$Factory;->getSupportedTypes()[I

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic setCmcdConfigurationFactory(Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;)Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .locals 0

    .line 92
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->setCmcdConfigurationFactory(Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;

    move-result-object p1

    return-object p1
.end method

.method public setCmcdConfigurationFactory(Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;
    .locals 1
    .param p1, "cmcdConfigurationFactory"    # Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;

    .line 140
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaSource$Factory;->setCmcdConfigurationFactory(Landroidx/media3/exoplayer/upstream/CmcdConfiguration$Factory;)Landroidx/media3/exoplayer/source/MediaSource$Factory;

    .line 141
    return-object p0
.end method

.method public bridge synthetic setDrmSessionManagerProvider(Landroidx/media3/exoplayer/drm/DrmSessionManagerProvider;)Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .locals 0

    .line 92
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->setDrmSessionManagerProvider(Landroidx/media3/exoplayer/drm/DrmSessionManagerProvider;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;

    move-result-object p1

    return-object p1
.end method

.method public setDrmSessionManagerProvider(Landroidx/media3/exoplayer/drm/DrmSessionManagerProvider;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;
    .locals 1
    .param p1, "drmSessionManagerProvider"    # Landroidx/media3/exoplayer/drm/DrmSessionManagerProvider;

    .line 147
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaSource$Factory;->setDrmSessionManagerProvider(Landroidx/media3/exoplayer/drm/DrmSessionManagerProvider;)Landroidx/media3/exoplayer/source/MediaSource$Factory;

    .line 148
    return-object p0
.end method

.method public bridge synthetic setLoadErrorHandlingPolicy(Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;)Landroidx/media3/exoplayer/source/MediaSource$Factory;
    .locals 0

    .line 92
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->setLoadErrorHandlingPolicy(Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;

    move-result-object p1

    return-object p1
.end method

.method public setLoadErrorHandlingPolicy(Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;)Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;
    .locals 1
    .param p1, "loadErrorHandlingPolicy"    # Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;

    .line 153
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaSource$Factory;->mediaSourceFactory:Landroidx/media3/exoplayer/source/MediaSource$Factory;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaSource$Factory;->setLoadErrorHandlingPolicy(Landroidx/media3/exoplayer/upstream/LoadErrorHandlingPolicy;)Landroidx/media3/exoplayer/source/MediaSource$Factory;

    .line 154
    return-object p0
.end method
