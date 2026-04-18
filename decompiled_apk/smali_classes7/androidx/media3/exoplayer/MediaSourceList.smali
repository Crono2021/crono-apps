.class final Landroidx/media3/exoplayer/MediaSourceList;
.super Ljava/lang/Object;
.source "MediaSourceList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;,
        Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;,
        Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;,
        Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "MediaSourceList"


# instance fields
.field private final childSources:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap<",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;",
            ">;"
        }
    .end annotation
.end field

.field private final enabledMediaSourceHolders:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final eventHandler:Landroidx/media3/common/util/HandlerWrapper;

.field private final eventListener:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

.field private isPrepared:Z

.field private final mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/IdentityHashMap<",
            "Landroidx/media3/exoplayer/source/MediaPeriod;",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceByUid:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Object;",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceHolders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceListInfoListener:Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;

.field private mediaTransferListener:Landroidx/media3/datasource/TransferListener;

.field private final playerId:Landroidx/media3/exoplayer/analytics/PlayerId;

.field private shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;Landroidx/media3/exoplayer/analytics/AnalyticsCollector;Landroidx/media3/common/util/HandlerWrapper;Landroidx/media3/exoplayer/analytics/PlayerId;)V
    .locals 2
    .param p1, "listener"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;
    .param p2, "analyticsCollector"    # Landroidx/media3/exoplayer/analytics/AnalyticsCollector;
    .param p3, "analyticsCollectorHandler"    # Landroidx/media3/common/util/HandlerWrapper;
    .param p4, "playerId"    # Landroidx/media3/exoplayer/analytics/PlayerId;

    .line 109
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 110
    iput-object p4, p0, Landroidx/media3/exoplayer/MediaSourceList;->playerId:Landroidx/media3/exoplayer/analytics/PlayerId;

    .line 111
    iput-object p1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceListInfoListener:Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;

    .line 112
    new-instance v0, Landroidx/media3/exoplayer/source/ShuffleOrder$DefaultShuffleOrder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/source/ShuffleOrder$DefaultShuffleOrder;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 113
    new-instance v0, Ljava/util/IdentityHashMap;

    invoke-direct {v0}, Ljava/util/IdentityHashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    .line 114
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByUid:Ljava/util/Map;

    .line 115
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    .line 116
    iput-object p2, p0, Landroidx/media3/exoplayer/MediaSourceList;->eventListener:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

    .line 117
    iput-object p3, p0, Landroidx/media3/exoplayer/MediaSourceList;->eventHandler:Landroidx/media3/common/util/HandlerWrapper;

    .line 118
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    .line 119
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    .line 120
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/MediaSourceList;)Landroidx/media3/common/util/HandlerWrapper;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/MediaSourceList;

    .line 64
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->eventHandler:Landroidx/media3/common/util/HandlerWrapper;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .param p1, "x1"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 64
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/MediaSourceList;->getMediaPeriodIdForChildMediaPeriodId(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;I)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .param p1, "x1"    # I

    .line 64
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/MediaSourceList;->getWindowIndexForChildWindowIndex(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;I)I

    move-result v0

    return v0
.end method

.method static synthetic access$300(Landroidx/media3/exoplayer/MediaSourceList;)Landroidx/media3/exoplayer/analytics/AnalyticsCollector;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/MediaSourceList;

    .line 64
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->eventListener:Landroidx/media3/exoplayer/analytics/AnalyticsCollector;

    return-object v0
.end method

.method private correctOffsets(II)V
    .locals 3
    .param p1, "startIndex"    # I
    .param p2, "windowOffsetUpdate"    # I

    .line 438
    move v0, p1

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 439
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 440
    .local v1, "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iget v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    add-int/2addr v2, p2

    iput v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 438
    .end local v1    # "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 442
    .end local v0    # "i":I
    :cond_0
    return-void
.end method

.method private disableChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V
    .locals 3
    .param p1, "holder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 417
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    .line 418
    .local v0, "disabledChild":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    if-eqz v0, :cond_0

    .line 419
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->caller:Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/MediaSource;->disable(Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;)V

    .line 421
    :cond_0
    return-void
.end method

.method private disableUnusedMediaSources()V
    .locals 3

    .line 406
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 407
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 408
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 409
    .local v1, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 410
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->disableChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 411
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 413
    .end local v1    # "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    :cond_0
    goto :goto_0

    .line 414
    :cond_1
    return-void
.end method

.method private enableMediaSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V
    .locals 3
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 398
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 399
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    .line 400
    .local v0, "enabledChild":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    if-eqz v0, :cond_0

    .line 401
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->caller:Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/MediaSource;->enable(Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;)V

    .line 403
    :cond_0
    return-void
.end method

.method private static getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 495
    invoke-static {p0}, Landroidx/media3/exoplayer/PlaylistTimeline;->getChildPeriodUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getMediaPeriodIdForChildMediaPeriodId(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 5
    .param p0, "mediaSourceHolder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .param p1, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 449
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 452
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v1, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-wide v3, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 454
    iget-object v1, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {p0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->getPeriodUid(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 455
    .local v1, "periodUid":Ljava/lang/Object;
    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v2

    return-object v2

    .line 449
    .end local v1    # "periodUid":Ljava/lang/Object;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 458
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method private static getMediaSourceHolderUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 490
    invoke-static {p0}, Landroidx/media3/exoplayer/PlaylistTimeline;->getChildTimelineUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getPeriodUid(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "holder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .param p1, "childPeriodUid"    # Ljava/lang/Object;

    .line 499
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-static {v0, p1}, Landroidx/media3/exoplayer/PlaylistTimeline;->getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getWindowIndexForChildWindowIndex(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;I)I
    .locals 1
    .param p0, "mediaSourceHolder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .param p1, "windowIndex"    # I

    .line 463
    iget v0, p0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    add-int/2addr v0, p1

    return v0
.end method

.method private maybeReleaseChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V
    .locals 3
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 479
    iget-boolean v0, p1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->isRemoved:Z

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 480
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    .line 481
    .local v0, "removedChild":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->caller:Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/MediaSource;->releaseSource(Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;)V

    .line 482
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->eventListener:Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/MediaSource;->removeEventListener(Landroidx/media3/exoplayer/source/MediaSourceEventListener;)V

    .line 483
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v2, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->eventListener:Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/MediaSource;->removeDrmEventListener(Landroidx/media3/exoplayer/drm/DrmSessionEventListener;)V

    .line 484
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 486
    .end local v0    # "removedChild":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    :cond_0
    return-void
.end method

.method private prepareChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V
    .locals 5
    .param p1, "holder"    # Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 467
    iget-object v0, p1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    .line 468
    .local v0, "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    new-instance v1, Landroidx/media3/exoplayer/MediaSourceList$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/MediaSourceList$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/MediaSourceList;)V

    .line 470
    .local v1, "caller":Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;
    new-instance v2, Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;

    invoke-direct {v2, p0, p1}, Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;-><init>(Landroidx/media3/exoplayer/MediaSourceList;Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 471
    .local v2, "eventListener":Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    new-instance v4, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    invoke-direct {v4, v0, v1, v2}, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;-><init>(Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;)V

    invoke-virtual {v3, p1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 472
    invoke-static {}, Landroidx/media3/common/util/Util;->createHandlerForCurrentOrMainLooper()Landroid/os/Handler;

    move-result-object v3

    invoke-interface {v0, v3, v2}, Landroidx/media3/exoplayer/source/MediaSource;->addEventListener(Landroid/os/Handler;Landroidx/media3/exoplayer/source/MediaSourceEventListener;)V

    .line 473
    invoke-static {}, Landroidx/media3/common/util/Util;->createHandlerForCurrentOrMainLooper()Landroid/os/Handler;

    move-result-object v3

    invoke-interface {v0, v3, v2}, Landroidx/media3/exoplayer/source/MediaSource;->addDrmEventListener(Landroid/os/Handler;Landroidx/media3/exoplayer/drm/DrmSessionEventListener;)V

    .line 474
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaTransferListener:Landroidx/media3/datasource/TransferListener;

    iget-object v4, p0, Landroidx/media3/exoplayer/MediaSourceList;->playerId:Landroidx/media3/exoplayer/analytics/PlayerId;

    invoke-interface {v0, v1, v3, v4}, Landroidx/media3/exoplayer/source/MediaSource;->prepareSource(Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;Landroidx/media3/datasource/TransferListener;Landroidx/media3/exoplayer/analytics/PlayerId;)V

    .line 475
    return-void
.end method

.method private removeMediaSourcesInternal(II)V
    .locals 4
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I

    .line 424
    add-int/lit8 v0, p2, -0x1

    .local v0, "index":I
    :goto_0
    if-lt v0, p1, :cond_1

    .line 425
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 426
    .local v1, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByUid:Ljava/util/Map;

    iget-object v3, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-interface {v2, v3}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 427
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v2

    .line 428
    .local v2, "oldTimeline":Landroidx/media3/common/Timeline;
    nop

    .line 429
    invoke-virtual {v2}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v3

    neg-int v3, v3

    .line 428
    invoke-direct {p0, v0, v3}, Landroidx/media3/exoplayer/MediaSourceList;->correctOffsets(II)V

    .line 430
    const/4 v3, 0x1

    iput-boolean v3, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->isRemoved:Z

    .line 431
    iget-boolean v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    if-eqz v3, :cond_0

    .line 432
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->maybeReleaseChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 424
    .end local v1    # "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .end local v2    # "oldTimeline":Landroidx/media3/common/Timeline;
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 435
    .end local v0    # "index":I
    :cond_1
    return-void
.end method


# virtual methods
.method public addMediaSources(ILjava/util/List;Landroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 6
    .param p1, "index"    # I
    .param p3, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;",
            "Landroidx/media3/exoplayer/source/ShuffleOrder;",
            ")",
            "Landroidx/media3/common/Timeline;"
        }
    .end annotation

    .line 145
    .local p2, "holders":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;>;"
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 146
    iput-object p3, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 147
    move v0, p1

    .local v0, "insertionIndex":I
    :goto_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v1, p1

    if-ge v0, v1, :cond_3

    .line 148
    sub-int v1, v0, p1

    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 149
    .local v1, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    if-lez v0, :cond_0

    .line 150
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    add-int/lit8 v3, v0, -0x1

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 151
    .local v2, "previousHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v3}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v3

    .line 152
    .local v3, "previousTimeline":Landroidx/media3/common/Timeline;
    iget v4, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 154
    invoke-virtual {v3}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v5

    add-int/2addr v4, v5

    .line 152
    invoke-virtual {v1, v4}, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->reset(I)V

    .line 155
    .end local v2    # "previousHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .end local v3    # "previousTimeline":Landroidx/media3/common/Timeline;
    goto :goto_1

    .line 156
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->reset(I)V

    .line 158
    :goto_1
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v2}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v2

    .line 159
    .local v2, "newTimeline":Landroidx/media3/common/Timeline;
    nop

    .line 161
    invoke-virtual {v2}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v3

    .line 159
    invoke-direct {p0, v0, v3}, Landroidx/media3/exoplayer/MediaSourceList;->correctOffsets(II)V

    .line 162
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v3, v0, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 163
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByUid:Ljava/util/Map;

    iget-object v4, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-interface {v3, v4, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 164
    iget-boolean v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    if-eqz v3, :cond_2

    .line 165
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->prepareChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 166
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v3}, Ljava/util/IdentityHashMap;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 167
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v3, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 169
    :cond_1
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->disableChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 147
    .end local v1    # "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    .end local v2    # "newTimeline":Landroidx/media3/common/Timeline;
    :cond_2
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 174
    .end local v0    # "insertionIndex":I
    :cond_3
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public clear(Landroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 2
    .param p1, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 277
    if-eqz p1, :cond_0

    move-object v0, p1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 278
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->getSize()I

    move-result v1

    invoke-direct {p0, v0, v1}, Landroidx/media3/exoplayer/MediaSourceList;->removeMediaSourcesInternal(II)V

    .line 279
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 5
    .param p1, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p2, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p3, "startPositionUs"    # J

    .line 331
    iget-object v0, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/exoplayer/MediaSourceList;->getMediaSourceHolderUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 332
    .local v0, "mediaSourceHolderUid":Ljava/lang/Object;
    iget-object v1, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    .line 333
    invoke-static {v1}, Landroidx/media3/exoplayer/MediaSourceList;->getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v1

    .line 334
    .local v1, "childMediaPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByUid:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 335
    .local v2, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/MediaSourceList;->enableMediaSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 336
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 337
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    .line 338
    invoke-virtual {v3, v1, p2, p3, p4}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MaskingMediaPeriod;

    move-result-object v3

    .line 339
    .local v3, "mediaPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    iget-object v4, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v4, v3, v2}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 340
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaSourceList;->disableUnusedMediaSources()V

    .line 341
    return-object v3
.end method

.method public createTimeline()Landroidx/media3/common/Timeline;
    .locals 4

    .line 378
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 379
    sget-object v0, Landroidx/media3/common/Timeline;->EMPTY:Landroidx/media3/common/Timeline;

    return-object v0

    .line 381
    :cond_0
    const/4 v0, 0x0

    .line 382
    .local v0, "windowOffset":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 383
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 384
    .local v2, "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iput v0, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 385
    iget-object v3, v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v3}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v3

    invoke-virtual {v3}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v3

    add-int/2addr v0, v3

    .line 382
    .end local v2    # "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 387
    .end local v1    # "i":I
    :cond_1
    new-instance v1, Landroidx/media3/exoplayer/PlaylistTimeline;

    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-direct {v1, v2, v3}, Landroidx/media3/exoplayer/PlaylistTimeline;-><init>(Ljava/util/Collection;Landroidx/media3/exoplayer/source/ShuffleOrder;)V

    return-object v1
.end method

.method public getShuffleOrder()Landroidx/media3/exoplayer/source/ShuffleOrder;
    .locals 1

    .line 392
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    .line 289
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public isPrepared()Z
    .locals 1

    .line 284
    iget-boolean v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    return v0
.end method

.method synthetic lambda$prepareChildSource$0$androidx-media3-exoplayer-MediaSourceList(Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V
    .locals 1
    .param p1, "source"    # Landroidx/media3/exoplayer/source/MediaSource;
    .param p2, "timeline"    # Landroidx/media3/common/Timeline;

    .line 469
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceListInfoListener:Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;

    invoke-interface {v0}, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceListInfoRefreshListener;->onPlaylistUpdateRequested()V

    return-void
.end method

.method public moveMediaSource(IILandroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 1
    .param p1, "currentIndex"    # I
    .param p2, "newIndex"    # I
    .param p3, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 213
    add-int/lit8 v0, p1, 0x1

    invoke-virtual {p0, p1, v0, p2, p3}, Landroidx/media3/exoplayer/MediaSourceList;->moveMediaSourceRange(IIILandroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public moveMediaSourceRange(IIILandroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 7
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I
    .param p3, "newFromIndex"    # I
    .param p4, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 235
    const/4 v0, 0x1

    if-ltz p1, :cond_0

    if-gt p1, p2, :cond_0

    .line 236
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->getSize()I

    move-result v1

    if-gt p2, v1, :cond_0

    if-ltz p3, :cond_0

    move v1, v0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 235
    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 237
    iput-object p4, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 238
    if-eq p1, p2, :cond_3

    if-ne p1, p3, :cond_1

    goto :goto_2

    .line 241
    :cond_1
    invoke-static {p1, p3}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 242
    .local v1, "startIndex":I
    sub-int v2, p2, p1

    add-int/2addr v2, p3

    sub-int/2addr v2, v0

    .line 243
    .local v2, "newEndIndex":I
    add-int/lit8 v0, p2, -0x1

    invoke-static {v2, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 244
    .local v0, "endIndex":I
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    iget v3, v3, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 245
    .local v3, "windowOffset":I
    iget-object v4, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-static {v4, p1, p2, p3}, Landroidx/media3/common/util/Util;->moveItems(Ljava/util/List;III)V

    .line 246
    move v4, v1

    .local v4, "i":I
    :goto_1
    if-gt v4, v0, :cond_2

    .line 247
    iget-object v5, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v5, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 248
    .local v5, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iput v3, v5, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 249
    iget-object v6, v5, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v6}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v6

    invoke-virtual {v6}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v6

    add-int/2addr v3, v6

    .line 246
    .end local v5    # "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 251
    .end local v4    # "i":I
    :cond_2
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v4

    return-object v4

    .line 239
    .end local v0    # "endIndex":I
    .end local v1    # "startIndex":I
    .end local v2    # "newEndIndex":I
    .end local v3    # "windowOffset":I
    :cond_3
    :goto_2
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public prepare(Landroidx/media3/datasource/TransferListener;)V
    .locals 4
    .param p1, "mediaTransferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 311
    iget-boolean v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    const/4 v1, 0x1

    xor-int/2addr v0, v1

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 312
    iput-object p1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaTransferListener:Landroidx/media3/datasource/TransferListener;

    .line 313
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 314
    iget-object v2, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 315
    .local v2, "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/MediaSourceList;->prepareChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 316
    iget-object v3, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 313
    .end local v2    # "mediaSourceHolder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 318
    .end local v0    # "i":I
    :cond_0
    iput-boolean v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    .line 319
    return-void
.end method

.method public release()V
    .locals 5

    .line 361
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;

    .line 363
    .local v1, "childSource":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    :try_start_0
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v3, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->caller:Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;

    invoke-interface {v2, v3}, Landroidx/media3/exoplayer/source/MediaSource;->releaseSource(Landroidx/media3/exoplayer/source/MediaSource$MediaSourceCaller;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 367
    goto :goto_1

    .line 364
    :catch_0
    move-exception v2

    .line 366
    .local v2, "e":Ljava/lang/RuntimeException;
    const-string v3, "MediaSourceList"

    const-string v4, "Failed to release child source."

    invoke-static {v3, v4, v2}, Landroidx/media3/common/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 368
    .end local v2    # "e":Ljava/lang/RuntimeException;
    :goto_1
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v3, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->eventListener:Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;

    invoke-interface {v2, v3}, Landroidx/media3/exoplayer/source/MediaSource;->removeEventListener(Landroidx/media3/exoplayer/source/MediaSourceEventListener;)V

    .line 369
    iget-object v2, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->mediaSource:Landroidx/media3/exoplayer/source/MediaSource;

    iget-object v3, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;->eventListener:Landroidx/media3/exoplayer/MediaSourceList$ForwardingEventListener;

    invoke-interface {v2, v3}, Landroidx/media3/exoplayer/source/MediaSource;->removeDrmEventListener(Landroidx/media3/exoplayer/drm/DrmSessionEventListener;)V

    .line 370
    .end local v1    # "childSource":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceAndListener;
    goto :goto_0

    .line 371
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->childSources:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 372
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 373
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->isPrepared:Z

    .line 374
    return-void
.end method

.method public releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 3
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 350
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v0, p1}, Ljava/util/IdentityHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    .line 351
    .local v0, "holder":Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v1, p1}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 352
    iget-object v1, v0, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    move-object v2, p1

    check-cast v2, Landroidx/media3/exoplayer/source/MaskingMediaPeriod;

    iget-object v2, v2, Landroidx/media3/exoplayer/source/MaskingMediaPeriod;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    invoke-interface {v1, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 353
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v1}, Ljava/util/IdentityHashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 354
    invoke-direct {p0}, Landroidx/media3/exoplayer/MediaSourceList;->disableUnusedMediaSources()V

    .line 356
    :cond_0
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/MediaSourceList;->maybeReleaseChildSource(Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;)V

    .line 357
    return-void
.end method

.method public removeMediaSourceRange(IILandroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 1
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I
    .param p3, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 194
    if-ltz p1, :cond_0

    if-gt p1, p2, :cond_0

    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->getSize()I

    move-result v0

    if-gt p2, v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 195
    iput-object p3, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 196
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/MediaSourceList;->removeMediaSourcesInternal(II)V

    .line 197
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public setMediaSources(Ljava/util/List;Landroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 2
    .param p2, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;",
            ">;",
            "Landroidx/media3/exoplayer/source/ShuffleOrder;",
            ")",
            "Landroidx/media3/common/Timeline;"
        }
    .end annotation

    .line 130
    .local p1, "holders":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;>;"
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    invoke-direct {p0, v1, v0}, Landroidx/media3/exoplayer/MediaSourceList;->removeMediaSourcesInternal(II)V

    .line 131
    iget-object v0, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-virtual {p0, v0, p1, p2}, Landroidx/media3/exoplayer/MediaSourceList;->addMediaSources(ILjava/util/List;Landroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method

.method public setShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;)Landroidx/media3/common/Timeline;
    .locals 3
    .param p1, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 298
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->getSize()I

    move-result v0

    .line 299
    .local v0, "size":I
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v1

    if-eq v1, v0, :cond_0

    .line 300
    nop

    .line 302
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v1

    .line 303
    const/4 v2, 0x0

    invoke-interface {v1, v2, v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object p1

    .line 305
    :cond_0
    iput-object p1, p0, Landroidx/media3/exoplayer/MediaSourceList;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 306
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v1

    return-object v1
.end method

.method public updateMediaSourcesWithMediaItems(IILjava/util/List;)Landroidx/media3/common/Timeline;
    .locals 4
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Ljava/util/List<",
            "Landroidx/media3/common/MediaItem;",
            ">;)",
            "Landroidx/media3/common/Timeline;"
        }
    .end annotation

    .line 267
    .local p3, "mediaItems":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/MediaItem;>;"
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-ltz p1, :cond_0

    if-gt p1, p2, :cond_0

    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->getSize()I

    move-result v2

    if-gt p2, v2, :cond_0

    move v2, v1

    goto :goto_0

    :cond_0
    move v2, v0

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 268
    invoke-interface {p3}, Ljava/util/List;->size()I

    move-result v2

    sub-int v3, p2, p1

    if-ne v2, v3, :cond_1

    move v0, v1

    :cond_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 269
    move v0, p1

    .local v0, "i":I
    :goto_1
    if-ge v0, p2, :cond_2

    .line 270
    iget-object v1, p0, Landroidx/media3/exoplayer/MediaSourceList;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;

    iget-object v1, v1, Landroidx/media3/exoplayer/MediaSourceList$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    sub-int v2, v0, p1

    invoke-interface {p3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/MediaItem;

    invoke-virtual {v1, v2}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->updateMediaItem(Landroidx/media3/common/MediaItem;)V

    .line 269
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 272
    .end local v0    # "i":I
    :cond_2
    invoke-virtual {p0}, Landroidx/media3/exoplayer/MediaSourceList;->createTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    return-object v0
.end method
