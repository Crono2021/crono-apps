.class final Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;
.super Landroidx/media3/exoplayer/source/ForwardingTimeline;
.source "ClippingMediaSource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/ClippingMediaSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ClippingTimeline"
.end annotation


# instance fields
.field private final durationUs:J

.field private final endUs:J

.field private final isDynamic:Z

.field private final startUs:J


# direct methods
.method public constructor <init>(Landroidx/media3/common/Timeline;JJ)V
    .locals 9
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "startUs"    # J
    .param p4, "endUs"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;
        }
    .end annotation

    .line 311
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/ForwardingTimeline;-><init>(Landroidx/media3/common/Timeline;)V

    .line 312
    invoke-virtual {p1}, Landroidx/media3/common/Timeline;->getPeriodCount()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_9

    .line 315
    new-instance v0, Landroidx/media3/common/Timeline$Window;

    invoke-direct {v0}, Landroidx/media3/common/Timeline$Window;-><init>()V

    invoke-virtual {p1, v1, v0}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;)Landroidx/media3/common/Timeline$Window;

    move-result-object v0

    .line 316
    .local v0, "window":Landroidx/media3/common/Timeline$Window;
    const-wide/16 v3, 0x0

    invoke-static {v3, v4, p2, p3}, Ljava/lang/Math;->max(JJ)J

    move-result-wide p2

    .line 317
    iget-boolean v5, v0, Landroidx/media3/common/Timeline$Window;->isPlaceholder:Z

    if-nez v5, :cond_1

    cmp-long v5, p2, v3

    if-eqz v5, :cond_1

    iget-boolean v5, v0, Landroidx/media3/common/Timeline$Window;->isSeekable:Z

    if-eqz v5, :cond_0

    goto :goto_0

    .line 318
    :cond_0
    new-instance v1, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    invoke-direct {v1, v2}, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;-><init>(I)V

    throw v1

    .line 320
    :cond_1
    :goto_0
    const-wide/high16 v5, -0x8000000000000000L

    cmp-long v5, p4, v5

    if-nez v5, :cond_2

    iget-wide v3, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    goto :goto_1

    :cond_2
    invoke-static {v3, v4, p4, p5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    .line 321
    .local v3, "resolvedEndUs":J
    :goto_1
    iget-wide v5, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    const-wide v7, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v5, v5, v7

    if-eqz v5, :cond_5

    .line 322
    iget-wide v5, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    cmp-long v5, v3, v5

    if-lez v5, :cond_3

    .line 323
    iget-wide v3, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    .line 325
    :cond_3
    cmp-long v5, p2, v3

    if-gtz v5, :cond_4

    goto :goto_2

    .line 326
    :cond_4
    new-instance v1, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    const/4 v2, 0x2

    invoke-direct {v1, v2}, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;-><init>(I)V

    throw v1

    .line 329
    :cond_5
    :goto_2
    iput-wide p2, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    .line 330
    iput-wide v3, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->endUs:J

    .line 331
    cmp-long v5, v3, v7

    if-nez v5, :cond_6

    move-wide v5, v7

    goto :goto_3

    :cond_6
    sub-long v5, v3, p2

    :goto_3
    iput-wide v5, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->durationUs:J

    .line 332
    iget-boolean v5, v0, Landroidx/media3/common/Timeline$Window;->isDynamic:Z

    if-eqz v5, :cond_8

    cmp-long v5, v3, v7

    if-eqz v5, :cond_7

    iget-wide v5, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    cmp-long v5, v5, v7

    if-eqz v5, :cond_8

    iget-wide v5, v0, Landroidx/media3/common/Timeline$Window;->durationUs:J

    cmp-long v5, v3, v5

    if-nez v5, :cond_8

    :cond_7
    move v1, v2

    :cond_8
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->isDynamic:Z

    .line 336
    return-void

    .line 313
    .end local v0    # "window":Landroidx/media3/common/Timeline$Window;
    .end local v3    # "resolvedEndUs":J
    :cond_9
    new-instance v0, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/source/ClippingMediaSource$IllegalClippingException;-><init>(I)V

    throw v0
.end method


# virtual methods
.method public getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;
    .locals 12
    .param p1, "periodIndex"    # I
    .param p2, "period"    # Landroidx/media3/common/Timeline$Period;
    .param p3, "setIds"    # Z

    .line 362
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->timeline:Landroidx/media3/common/Timeline;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p2, p3}, Landroidx/media3/common/Timeline;->getPeriod(ILandroidx/media3/common/Timeline$Period;Z)Landroidx/media3/common/Timeline$Period;

    .line 363
    invoke-virtual {p2}, Landroidx/media3/common/Timeline$Period;->getPositionInWindowUs()J

    move-result-wide v0

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    sub-long/2addr v0, v2

    .line 365
    .local v0, "positionInClippedWindowUs":J
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->durationUs:J

    const-wide v4, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v6, v2, v4

    if-nez v6, :cond_0

    move-wide v8, v4

    goto :goto_0

    :cond_0
    sub-long/2addr v2, v0

    move-wide v8, v2

    .line 366
    .local v8, "periodDurationUs":J
    :goto_0
    iget-object v5, p2, Landroidx/media3/common/Timeline$Period;->id:Ljava/lang/Object;

    iget-object v6, p2, Landroidx/media3/common/Timeline$Period;->uid:Ljava/lang/Object;

    const/4 v7, 0x0

    move-object v4, p2

    move-wide v10, v0

    invoke-virtual/range {v4 .. v11}, Landroidx/media3/common/Timeline$Period;->set(Ljava/lang/Object;Ljava/lang/Object;IJJ)Landroidx/media3/common/Timeline$Period;

    move-result-object v2

    return-object v2
.end method

.method public getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;
    .locals 6
    .param p1, "windowIndex"    # I
    .param p2, "window"    # Landroidx/media3/common/Timeline$Window;
    .param p3, "defaultPositionProjectionUs"    # J

    .line 340
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->timeline:Landroidx/media3/common/Timeline;

    const/4 v1, 0x0

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, p2, v2, v3}, Landroidx/media3/common/Timeline;->getWindow(ILandroidx/media3/common/Timeline$Window;J)Landroidx/media3/common/Timeline$Window;

    .line 341
    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    add-long/2addr v0, v2

    iput-wide v0, p2, Landroidx/media3/common/Timeline$Window;->positionInFirstPeriodUs:J

    .line 342
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->durationUs:J

    iput-wide v0, p2, Landroidx/media3/common/Timeline$Window;->durationUs:J

    .line 343
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->isDynamic:Z

    iput-boolean v0, p2, Landroidx/media3/common/Timeline$Window;->isDynamic:Z

    .line 344
    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 345
    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    iput-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    .line 346
    nop

    .line 347
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->endUs:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    goto :goto_0

    :cond_0
    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->endUs:J

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    :goto_0
    iput-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    .line 348
    iget-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    sub-long/2addr v0, v4

    iput-wide v0, p2, Landroidx/media3/common/Timeline$Window;->defaultPositionUs:J

    .line 350
    :cond_1
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaSource$ClippingTimeline;->startUs:J

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v0

    .line 351
    .local v0, "startMs":J
    iget-wide v4, p2, Landroidx/media3/common/Timeline$Window;->presentationStartTimeMs:J

    cmp-long v4, v4, v2

    if-eqz v4, :cond_2

    .line 352
    iget-wide v4, p2, Landroidx/media3/common/Timeline$Window;->presentationStartTimeMs:J

    add-long/2addr v4, v0

    iput-wide v4, p2, Landroidx/media3/common/Timeline$Window;->presentationStartTimeMs:J

    .line 354
    :cond_2
    iget-wide v4, p2, Landroidx/media3/common/Timeline$Window;->windowStartTimeMs:J

    cmp-long v2, v4, v2

    if-eqz v2, :cond_3

    .line 355
    iget-wide v2, p2, Landroidx/media3/common/Timeline$Window;->windowStartTimeMs:J

    add-long/2addr v2, v0

    iput-wide v2, p2, Landroidx/media3/common/Timeline$Window;->windowStartTimeMs:J

    .line 357
    :cond_3
    return-object p2
.end method
