.class final Landroidx/media3/exoplayer/ExoPlayerImpl$Api31;
.super Ljava/lang/Object;
.source "ExoPlayerImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/ExoPlayerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api31"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 3385
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static registerMediaMetricsListener(Landroid/content/Context;Landroidx/media3/exoplayer/ExoPlayerImpl;Z)Landroidx/media3/exoplayer/analytics/PlayerId;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "player"    # Landroidx/media3/exoplayer/ExoPlayerImpl;
    .param p2, "usePlatformDiagnostics"    # Z

    .line 3390
    invoke-static {p0}, Landroidx/media3/exoplayer/analytics/MediaMetricsListener;->create(Landroid/content/Context;)Landroidx/media3/exoplayer/analytics/MediaMetricsListener;

    move-result-object v0

    .line 3391
    .local v0, "listener":Landroidx/media3/exoplayer/analytics/MediaMetricsListener;
    if-nez v0, :cond_0

    .line 3392
    const-string v1, "ExoPlayerImpl"

    const-string v2, "MediaMetricsService unavailable."

    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 3393
    new-instance v1, Landroidx/media3/exoplayer/analytics/PlayerId;

    sget-object v2, Landroid/media/metrics/LogSessionId;->LOG_SESSION_ID_NONE:Landroid/media/metrics/LogSessionId;

    invoke-direct {v1, v2}, Landroidx/media3/exoplayer/analytics/PlayerId;-><init>(Landroid/media/metrics/LogSessionId;)V

    return-object v1

    .line 3395
    :cond_0
    if-eqz p2, :cond_1

    .line 3396
    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/ExoPlayerImpl;->addAnalyticsListener(Landroidx/media3/exoplayer/analytics/AnalyticsListener;)V

    .line 3398
    :cond_1
    new-instance v1, Landroidx/media3/exoplayer/analytics/PlayerId;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/analytics/MediaMetricsListener;->getLogSessionId()Landroid/media/metrics/LogSessionId;

    move-result-object v2

    invoke-direct {v1, v2}, Landroidx/media3/exoplayer/analytics/PlayerId;-><init>(Landroid/media/metrics/LogSessionId;)V

    return-object v1
.end method
