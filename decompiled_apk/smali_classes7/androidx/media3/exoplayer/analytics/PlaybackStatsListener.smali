.class public final Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;
.super Ljava/lang/Object;
.source "PlaybackStatsListener.java"

# interfaces
.implements Landroidx/media3/exoplayer/analytics/AnalyticsListener;
.implements Landroidx/media3/exoplayer/analytics/PlaybackSessionManager$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;,
        Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    }
.end annotation


# instance fields
.field private audioFormat:Landroidx/media3/common/Format;

.field private bandwidthBytes:J

.field private bandwidthTimeMs:J

.field private final callback:Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;

.field private discontinuityFromPositionMs:J

.field private discontinuityFromSession:Ljava/lang/String;

.field private discontinuityReason:I

.field private droppedFrames:I

.field private finishedPlaybackStats:Landroidx/media3/exoplayer/analytics/PlaybackStats;

.field private final keepHistory:Z

.field private nonFatalException:Ljava/lang/Exception;

.field private final period:Landroidx/media3/common/Timeline$Period;

.field private final playbackStatsTrackers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;",
            ">;"
        }
    .end annotation
.end field

.field private final sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

.field private final sessionStartEventTimes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;",
            ">;"
        }
    .end annotation
.end field

.field private videoFormat:Landroidx/media3/common/Format;

.field private videoSize:Landroidx/media3/common/VideoSize;


# direct methods
.method public constructor <init>(ZLandroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;)V
    .locals 2
    .param p1, "keepHistory"    # Z
    .param p2, "callback"    # Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;

    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 104
    iput-object p2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->callback:Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;

    .line 105
    iput-boolean p1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->keepHistory:Z

    .line 106
    new-instance v0, Landroidx/media3/exoplayer/analytics/DefaultPlaybackSessionManager;

    invoke-direct {v0}, Landroidx/media3/exoplayer/analytics/DefaultPlaybackSessionManager;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    .line 107
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    .line 108
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionStartEventTimes:Ljava/util/Map;

    .line 109
    sget-object v1, Landroidx/media3/exoplayer/analytics/PlaybackStats;->EMPTY:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    iput-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->finishedPlaybackStats:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    .line 110
    new-instance v1, Landroidx/media3/common/Timeline$Period;

    invoke-direct {v1}, Landroidx/media3/common/Timeline$Period;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->period:Landroidx/media3/common/Timeline$Period;

    .line 111
    sget-object v1, Landroidx/media3/common/VideoSize;->UNKNOWN:Landroidx/media3/common/VideoSize;

    iput-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoSize:Landroidx/media3/common/VideoSize;

    .line 112
    invoke-interface {v0, p0}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->setListener(Landroidx/media3/exoplayer/analytics/PlaybackSessionManager$Listener;)V

    .line 113
    return-void
.end method

.method private findBestEventTime(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;)Landroid/util/Pair;
    .locals 30
    .param p1, "events"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;
    .param p2, "session"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 302
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    const/4 v3, 0x0

    .line 303
    .local v3, "eventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    const/4 v4, 0x0

    .line 304
    .local v4, "belongsToPlayback":Z
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->size()I

    move-result v6

    if-ge v5, v6, :cond_3

    .line 305
    invoke-virtual {v1, v5}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->get(I)I

    move-result v6

    .line 306
    .local v6, "event":I
    invoke-virtual {v1, v6}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->getEventTime(I)Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    move-result-object v7

    .line 307
    .local v7, "newEventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    iget-object v8, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-interface {v8, v7, v2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->belongsToSession(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;)Z

    move-result v8

    .line 308
    .local v8, "newBelongsToPlayback":Z
    if-eqz v3, :cond_1

    if-eqz v8, :cond_0

    if-eqz v4, :cond_1

    :cond_0
    if-ne v8, v4, :cond_2

    iget-wide v9, v7, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->realtimeMs:J

    iget-wide v11, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->realtimeMs:J

    cmp-long v9, v9, v11

    if-lez v9, :cond_2

    .line 313
    :cond_1
    move-object v3, v7

    .line 314
    move v4, v8

    .line 304
    .end local v6    # "event":I
    .end local v7    # "newEventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .end local v8    # "newBelongsToPlayback":Z
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 317
    .end local v5    # "i":I
    :cond_3
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 318
    if-nez v4, :cond_5

    iget-object v5, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    if-eqz v5, :cond_5

    iget-object v5, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    invoke-virtual {v5}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->isAd()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 320
    iget-object v5, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->timeline:Landroidx/media3/common/Timeline;

    iget-object v6, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v6, v6, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->period:Landroidx/media3/common/Timeline$Period;

    .line 323
    invoke-virtual {v5, v6, v7}, Landroidx/media3/common/Timeline;->getPeriodByUid(Ljava/lang/Object;Landroidx/media3/common/Timeline$Period;)Landroidx/media3/common/Timeline$Period;

    move-result-object v5

    iget-object v6, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget v6, v6, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    .line 324
    invoke-virtual {v5, v6}, Landroidx/media3/common/Timeline$Period;->getAdGroupTimeUs(I)J

    move-result-wide v5

    .line 325
    .local v5, "contentPeriodPositionUs":J
    const-wide/high16 v7, -0x8000000000000000L

    cmp-long v7, v5, v7

    if-nez v7, :cond_4

    .line 326
    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->period:Landroidx/media3/common/Timeline$Period;

    iget-wide v5, v7, Landroidx/media3/common/Timeline$Period;->durationUs:J

    .line 328
    :cond_4
    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->period:Landroidx/media3/common/Timeline$Period;

    invoke-virtual {v7}, Landroidx/media3/common/Timeline$Period;->getPositionInWindowUs()J

    move-result-wide v7

    add-long/2addr v7, v5

    .line 329
    .local v7, "contentWindowPositionUs":J
    new-instance v24, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    iget-wide v10, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->realtimeMs:J

    iget-object v12, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->timeline:Landroidx/media3/common/Timeline;

    iget v13, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->windowIndex:I

    new-instance v14, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v9, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-object v9, v9, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    iget-object v15, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move/from16 v25, v4

    move-wide/from16 v26, v5

    .end local v4    # "belongsToPlayback":Z
    .end local v5    # "contentPeriodPositionUs":J
    .local v25, "belongsToPlayback":Z
    .local v26, "contentPeriodPositionUs":J
    iget-wide v4, v15, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-object v6, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget v6, v6, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->adGroupIndex:I

    invoke-direct {v14, v9, v4, v5, v6}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;-><init>(Ljava/lang/Object;JI)V

    .line 338
    invoke-static {v7, v8}, Landroidx/media3/common/util/Util;->usToMs(J)J

    move-result-wide v15

    iget-object v4, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->timeline:Landroidx/media3/common/Timeline;

    iget v5, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->currentWindowIndex:I

    iget-object v6, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->currentMediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-wide/from16 v28, v7

    .end local v7    # "contentWindowPositionUs":J
    .local v28, "contentWindowPositionUs":J
    iget-wide v7, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->currentPlaybackPositionMs:J

    iget-wide v1, v3, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;->totalBufferedDurationMs:J

    move-object/from16 v9, v24

    move-object/from16 v17, v4

    move/from16 v18, v5

    move-object/from16 v19, v6

    move-wide/from16 v20, v7

    move-wide/from16 v22, v1

    invoke-direct/range {v9 .. v23}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;-><init>(JLandroidx/media3/common/Timeline;ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JLandroidx/media3/common/Timeline;ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JJ)V

    move-object/from16 v3, v24

    .line 344
    iget-object v1, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    move-object/from16 v2, p2

    invoke-interface {v1, v3, v2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->belongsToSession(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;)Z

    move-result v4

    .end local v25    # "belongsToPlayback":Z
    .restart local v4    # "belongsToPlayback":Z
    goto :goto_1

    .line 318
    .end local v26    # "contentPeriodPositionUs":J
    .end local v28    # "contentWindowPositionUs":J
    :cond_5
    move/from16 v25, v4

    .line 346
    .end local v4    # "belongsToPlayback":Z
    .restart local v25    # "belongsToPlayback":Z
    move/from16 v4, v25

    .end local v25    # "belongsToPlayback":Z
    .restart local v4    # "belongsToPlayback":Z
    :goto_1
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v1

    return-object v1
.end method

.method private hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z
    .locals 2
    .param p1, "events"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;
    .param p2, "session"    # Ljava/lang/String;
    .param p3, "event"    # I

    .line 350
    invoke-virtual {p1, p3}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->contains(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    .line 351
    invoke-virtual {p1, p3}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->getEventTime(I)Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->belongsToSession(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 350
    :goto_0
    return v0
.end method

.method private maybeAddSessions(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;)V
    .locals 5
    .param p1, "events"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;

    .line 288
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    .line 289
    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->get(I)I

    move-result v1

    .line 290
    .local v1, "event":I
    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->getEventTime(I)Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    move-result-object v2

    .line 291
    .local v2, "eventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    if-nez v1, :cond_0

    .line 292
    iget-object v3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-interface {v3, v2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->updateSessionsWithTimelineChange(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;)V

    goto :goto_1

    .line 293
    :cond_0
    const/16 v3, 0xb

    if-ne v1, v3, :cond_1

    .line 294
    iget-object v3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    iget v4, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityReason:I

    invoke-interface {v3, v2, v4}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->updateSessionsWithDiscontinuity(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;I)V

    goto :goto_1

    .line 296
    :cond_1
    iget-object v3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-interface {v3, v2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->updateSessions(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;)V

    .line 288
    .end local v1    # "event":I
    .end local v2    # "eventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 299
    .end local v0    # "i":I
    :cond_2
    return-void
.end method


# virtual methods
.method public getCombinedPlaybackStats()Landroidx/media3/exoplayer/analytics/PlaybackStats;
    .locals 7

    .line 124
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    new-array v0, v0, [Landroidx/media3/exoplayer/analytics/PlaybackStats;

    .line 125
    .local v0, "allPendingPlaybackStats":[Landroidx/media3/exoplayer/analytics/PlaybackStats;
    iget-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->finishedPlaybackStats:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    const/4 v2, 0x0

    aput-object v1, v0, v2

    .line 126
    const/4 v1, 0x1

    .line 127
    .local v1, "index":I
    iget-object v3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    .line 128
    .local v4, "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    add-int/lit8 v5, v1, 0x1

    .end local v1    # "index":I
    .local v5, "index":I
    invoke-virtual {v4, v2}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->build(Z)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v6

    aput-object v6, v0, v1

    .line 129
    .end local v4    # "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    move v1, v5

    goto :goto_0

    .line 130
    .end local v5    # "index":I
    .restart local v1    # "index":I
    :cond_0
    invoke-static {v0}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->merge([Landroidx/media3/exoplayer/analytics/PlaybackStats;)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v2

    return-object v2
.end method

.method public getPlaybackStats()Landroidx/media3/exoplayer/analytics/PlaybackStats;
    .locals 3

    .line 141
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-interface {v0}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->getActiveSessionId()Ljava/lang/String;

    move-result-object v0

    .line 144
    .local v0, "activeSessionId":Ljava/lang/String;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    iget-object v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    .line 145
    .local v2, "activeStatsTracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    :goto_0
    if-nez v2, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    invoke-virtual {v2, v1}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->build(Z)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v1

    :goto_1
    return-object v1
.end method

.method public onAdPlaybackStarted(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "contentSessionId"    # Ljava/lang/String;
    .param p3, "adSessionId"    # Ljava/lang/String;

    .line 165
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->onInterruptedByAd()V

    .line 166
    return-void
.end method

.method public onBandwidthEstimate(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;IJJ)V
    .locals 2
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "totalLoadTimeMs"    # I
    .param p3, "totalBytesLoaded"    # J
    .param p5, "bitrateEstimate"    # J

    .line 223
    int-to-long v0, p2

    iput-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->bandwidthTimeMs:J

    .line 224
    iput-wide p3, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->bandwidthBytes:J

    .line 225
    return-void
.end method

.method public onDownstreamFormatChanged(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 229
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaLoadData;->trackType:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    iget v0, p2, Landroidx/media3/exoplayer/source/MediaLoadData;->trackType:I

    if-nez v0, :cond_0

    goto :goto_0

    .line 232
    :cond_0
    iget v0, p2, Landroidx/media3/exoplayer/source/MediaLoadData;->trackType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 233
    iget-object v0, p2, Landroidx/media3/exoplayer/source/MediaLoadData;->trackFormat:Landroidx/media3/common/Format;

    iput-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->audioFormat:Landroidx/media3/common/Format;

    goto :goto_1

    .line 231
    :cond_1
    :goto_0
    iget-object v0, p2, Landroidx/media3/exoplayer/source/MediaLoadData;->trackFormat:Landroidx/media3/common/Format;

    iput-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoFormat:Landroidx/media3/common/Format;

    .line 235
    :cond_2
    :goto_1
    return-void
.end method

.method public onDrmSessionManagerError(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/Exception;)V
    .locals 0
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "error"    # Ljava/lang/Exception;

    .line 217
    iput-object p2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->nonFatalException:Ljava/lang/Exception;

    .line 218
    return-void
.end method

.method public onDroppedVideoFrames(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;IJ)V
    .locals 0
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "droppedFrames"    # I
    .param p3, "elapsedMs"    # J

    .line 202
    iput p2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->droppedFrames:I

    .line 203
    return-void
.end method

.method public onEvents(Landroidx/media3/common/Player;Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;)V
    .locals 35
    .param p1, "player"    # Landroidx/media3/common/Player;
    .param p2, "events"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;

    .line 244
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual/range {p2 .. p2}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->size()I

    move-result v2

    if-nez v2, :cond_0

    .line 245
    return-void

    .line 247
    :cond_0
    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->maybeAddSessions(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;)V

    .line 248
    iget-object v2, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    const/4 v4, 0x0

    if-eqz v3, :cond_c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 249
    .local v3, "session":Ljava/lang/String;
    invoke-direct {v0, v1, v3}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->findBestEventTime(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v5

    .line 250
    .local v5, "eventTimeAndBelongsToPlayback":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/Boolean;>;"
    iget-object v6, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v6, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    .line 251
    .local v6, "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    const/16 v7, 0xb

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v26

    .line 252
    .local v26, "hasDiscontinuityToPlayback":Z
    const/16 v7, 0x3fa

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v27

    .line 253
    .local v27, "hasDroppedFrames":Z
    const/16 v7, 0x3f3

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v28

    .line 254
    .local v28, "hasAudioUnderrun":Z
    const/16 v7, 0x3e8

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v29

    .line 255
    .local v29, "startedLoading":Z
    const/16 v7, 0xa

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v30

    .line 256
    .local v30, "hasFatalError":Z
    nop

    .line 257
    const/16 v7, 0x3eb

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v7

    const/4 v8, 0x0

    if-nez v7, :cond_2

    .line 258
    const/16 v7, 0x400

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v7

    if-eqz v7, :cond_1

    goto :goto_1

    :cond_1
    move v7, v8

    goto :goto_2

    :cond_2
    :goto_1
    const/4 v7, 0x1

    :goto_2
    move/from16 v31, v7

    .line 259
    .local v31, "hasNonFatalException":Z
    const/16 v7, 0x3ee

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v32

    .line 260
    .local v32, "hasBandwidthData":Z
    const/16 v7, 0x3ec

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v33

    .line 261
    .local v33, "hasFormatData":Z
    const/16 v7, 0x19

    invoke-direct {v0, v1, v3, v7}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->hasEvent(Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;Ljava/lang/String;I)Z

    move-result v34

    .line 262
    .local v34, "hasVideoSize":Z
    iget-object v7, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    move-object v9, v7

    check-cast v9, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    iget-object v7, v5, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v7, Ljava/lang/Boolean;

    .line 265
    invoke-virtual {v7}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v10

    .line 266
    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromSession:Ljava/lang/String;

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    iget-wide v11, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromPositionMs:J

    goto :goto_3

    :cond_3
    const-wide v11, -0x7fffffffffffffffL    # -4.9E-324

    .line 268
    :goto_3
    if-eqz v27, :cond_4

    iget v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->droppedFrames:I

    move v14, v7

    goto :goto_4

    :cond_4
    move v14, v8

    .line 271
    :goto_4
    if-eqz v30, :cond_5

    invoke-interface/range {p1 .. p1}, Landroidx/media3/common/Player;->getPlayerError()Landroidx/media3/common/PlaybackException;

    move-result-object v7

    move-object/from16 v17, v7

    goto :goto_5

    :cond_5
    move-object/from16 v17, v4

    .line 272
    :goto_5
    if-eqz v31, :cond_6

    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->nonFatalException:Ljava/lang/Exception;

    move-object/from16 v18, v7

    goto :goto_6

    :cond_6
    move-object/from16 v18, v4

    .line 273
    :goto_6
    if-eqz v32, :cond_7

    iget-wide v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->bandwidthTimeMs:J

    move-wide/from16 v19, v7

    goto :goto_7

    :cond_7
    const-wide/16 v19, 0x0

    .line 274
    :goto_7
    if-eqz v32, :cond_8

    iget-wide v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->bandwidthBytes:J

    move-wide/from16 v21, v7

    goto :goto_8

    :cond_8
    const-wide/16 v21, 0x0

    .line 275
    :goto_8
    if-eqz v33, :cond_9

    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoFormat:Landroidx/media3/common/Format;

    move-object/from16 v23, v7

    goto :goto_9

    :cond_9
    move-object/from16 v23, v4

    .line 276
    :goto_9
    if-eqz v33, :cond_a

    iget-object v7, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->audioFormat:Landroidx/media3/common/Format;

    move-object/from16 v24, v7

    goto :goto_a

    :cond_a
    move-object/from16 v24, v4

    .line 277
    :goto_a
    if-eqz v34, :cond_b

    iget-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoSize:Landroidx/media3/common/VideoSize;

    :cond_b
    move-object/from16 v25, v4

    .line 262
    move-object v7, v6

    move-object/from16 v8, p1

    move/from16 v13, v26

    move/from16 v15, v28

    move/from16 v16, v29

    invoke-virtual/range {v7 .. v25}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->onEvents(Landroidx/media3/common/Player;Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;ZJZIZZLandroidx/media3/common/PlaybackException;Ljava/lang/Exception;JJLandroidx/media3/common/Format;Landroidx/media3/common/Format;Landroidx/media3/common/VideoSize;)V

    .line 278
    .end local v3    # "session":Ljava/lang/String;
    .end local v5    # "eventTimeAndBelongsToPlayback":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/Boolean;>;"
    .end local v6    # "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    .end local v26    # "hasDiscontinuityToPlayback":Z
    .end local v27    # "hasDroppedFrames":Z
    .end local v28    # "hasAudioUnderrun":Z
    .end local v29    # "startedLoading":Z
    .end local v30    # "hasFatalError":Z
    .end local v31    # "hasNonFatalException":Z
    .end local v32    # "hasBandwidthData":Z
    .end local v33    # "hasFormatData":Z
    .end local v34    # "hasVideoSize":Z
    goto/16 :goto_0

    .line 279
    :cond_c
    iput-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoFormat:Landroidx/media3/common/Format;

    .line 280
    iput-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->audioFormat:Landroidx/media3/common/Format;

    .line 281
    iput-object v4, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromSession:Ljava/lang/String;

    .line 282
    const/16 v2, 0x404

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->contains(I)Z

    move-result v3

    if-eqz v3, :cond_d

    .line 283
    iget-object v3, v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/analytics/AnalyticsListener$Events;->getEventTime(I)Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    move-result-object v2

    invoke-interface {v3, v2}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->finishAllSessions(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;)V

    .line 285
    :cond_d
    return-void
.end method

.method public onLoadError(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;Ljava/io/IOException;Z)V
    .locals 0
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "loadEventInfo"    # Landroidx/media3/exoplayer/source/LoadEventInfo;
    .param p3, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;
    .param p4, "error"    # Ljava/io/IOException;
    .param p5, "wasCanceled"    # Z

    .line 212
    iput-object p4, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->nonFatalException:Ljava/lang/Exception;

    .line 213
    return-void
.end method

.method public onPositionDiscontinuity(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Landroidx/media3/common/Player$PositionInfo;Landroidx/media3/common/Player$PositionInfo;I)V
    .locals 2
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "oldPosition"    # Landroidx/media3/common/Player$PositionInfo;
    .param p3, "newPosition"    # Landroidx/media3/common/Player$PositionInfo;
    .param p4, "reason"    # I

    .line 193
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromSession:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 194
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionManager:Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;

    invoke-interface {v0}, Landroidx/media3/exoplayer/analytics/PlaybackSessionManager;->getActiveSessionId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromSession:Ljava/lang/String;

    .line 195
    iget-wide v0, p2, Landroidx/media3/common/Player$PositionInfo;->positionMs:J

    iput-wide v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromPositionMs:J

    .line 197
    :cond_0
    iput p4, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityReason:I

    .line 198
    return-void
.end method

.method public onSessionActive(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;)V
    .locals 1
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "sessionId"    # Ljava/lang/String;

    .line 159
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->onForeground()V

    .line 160
    return-void
.end method

.method public onSessionCreated(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;)V
    .locals 2
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "sessionId"    # Ljava/lang/String;

    .line 152
    new-instance v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    iget-boolean v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->keepHistory:Z

    invoke-direct {v0, v1, p1}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;-><init>(ZLandroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;)V

    .line 153
    .local v0, "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    iget-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v1, p2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    iget-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionStartEventTimes:Ljava/util/Map;

    invoke-interface {v1, p2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    return-void
.end method

.method public onSessionFinished(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Ljava/lang/String;Z)V
    .locals 9
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "sessionId"    # Ljava/lang/String;
    .param p3, "automaticTransitionToNextPlayback"    # Z

    .line 171
    iget-object v0, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->playbackStatsTrackers:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;

    .line 172
    .local v0, "tracker":Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;
    iget-object v1, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->sessionStartEventTimes:Ljava/util/Map;

    invoke-interface {v1, p2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;

    .line 174
    .local v1, "startEventTime":Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    iget-object v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromSession:Ljava/lang/String;

    invoke-virtual {p2, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 175
    iget-wide v2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->discontinuityFromPositionMs:J

    goto :goto_0

    .line 176
    :cond_0
    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    :goto_0
    nop

    .line 177
    .local v2, "discontinuityFromPositionMs":J
    invoke-virtual {v0, p1, p3, v2, v3}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->onFinished(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;ZJ)V

    .line 178
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$PlaybackStatsTracker;->build(Z)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v5

    .line 179
    .local v5, "playbackStats":Landroidx/media3/exoplayer/analytics/PlaybackStats;
    const/4 v6, 0x2

    new-array v6, v6, [Landroidx/media3/exoplayer/analytics/PlaybackStats;

    const/4 v7, 0x0

    iget-object v8, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->finishedPlaybackStats:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    aput-object v8, v6, v7

    aput-object v5, v6, v4

    invoke-static {v6}, Landroidx/media3/exoplayer/analytics/PlaybackStats;->merge([Landroidx/media3/exoplayer/analytics/PlaybackStats;)Landroidx/media3/exoplayer/analytics/PlaybackStats;

    move-result-object v4

    iput-object v4, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->finishedPlaybackStats:Landroidx/media3/exoplayer/analytics/PlaybackStats;

    .line 180
    iget-object v4, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->callback:Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;

    if-eqz v4, :cond_1

    .line 181
    invoke-interface {v4, v1, v5}, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener$Callback;->onPlaybackStatsReady(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Landroidx/media3/exoplayer/analytics/PlaybackStats;)V

    .line 183
    :cond_1
    return-void
.end method

.method public onVideoSizeChanged(Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;Landroidx/media3/common/VideoSize;)V
    .locals 0
    .param p1, "eventTime"    # Landroidx/media3/exoplayer/analytics/AnalyticsListener$EventTime;
    .param p2, "videoSize"    # Landroidx/media3/common/VideoSize;

    .line 239
    iput-object p2, p0, Landroidx/media3/exoplayer/analytics/PlaybackStatsListener;->videoSize:Landroidx/media3/common/VideoSize;

    .line 240
    return-void
.end method
