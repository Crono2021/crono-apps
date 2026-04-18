.class public final Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
.super Landroidx/media3/exoplayer/source/CompositeMediaSource;
.source "ConcatenatingMediaSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$FakeMediaSource;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;,
        Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/media3/exoplayer/source/CompositeMediaSource<",
        "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
        ">;"
    }
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# static fields
.field private static final MSG_ADD:I = 0x0

.field private static final MSG_MOVE:I = 0x2

.field private static final MSG_ON_COMPLETION:I = 0x5

.field private static final MSG_REMOVE:I = 0x1

.field private static final MSG_SET_SHUFFLE_ORDER:I = 0x3

.field private static final MSG_UPDATE_TIMELINE:I = 0x4

.field private static final PLACEHOLDER_MEDIA_ITEM:Landroidx/media3/common/MediaItem;


# instance fields
.field private final enabledMediaSourceHolders:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final isAtomic:Z

.field private final mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/IdentityHashMap<",
            "Landroidx/media3/exoplayer/source/MediaPeriod;",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceByUid:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Object;",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourceHolders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private final mediaSourcesPublic:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;"
        }
    .end annotation
.end field

.field private nextTimelineUpdateOnCompletionActions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;",
            ">;"
        }
    .end annotation
.end field

.field private final pendingOnCompletionActions:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;",
            ">;"
        }
    .end annotation
.end field

.field private playbackThreadHandler:Landroid/os/Handler;

.field private shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

.field private timelineUpdateScheduled:Z

.field private final useLazyPreparation:Z


# direct methods
.method public static synthetic $r8$lambda$AhFP8_Da86SSkED5yzGwK0UeGmw(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;Landroid/os/Message;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->handleMessage(Landroid/os/Message;)Z

    move-result p0

    return p0
.end method

.method static constructor <clinit>()V
    .locals 2

    .line 70
    new-instance v0, Landroidx/media3/common/MediaItem$Builder;

    invoke-direct {v0}, Landroidx/media3/common/MediaItem$Builder;-><init>()V

    sget-object v1, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 71
    invoke-virtual {v0, v1}, Landroidx/media3/common/MediaItem$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/common/MediaItem$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/MediaItem$Builder;->build()Landroidx/media3/common/MediaItem;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->PLACEHOLDER_MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    .line 70
    return-void
.end method

.method public varargs constructor <init>(ZLandroidx/media3/exoplayer/source/ShuffleOrder;[Landroidx/media3/exoplayer/source/MediaSource;)V
    .locals 1
    .param p1, "isAtomic"    # Z
    .param p2, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .param p3, "mediaSources"    # [Landroidx/media3/exoplayer/source/MediaSource;

    .line 123
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;-><init>(ZZLandroidx/media3/exoplayer/source/ShuffleOrder;[Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 124
    return-void
.end method

.method public varargs constructor <init>(ZZLandroidx/media3/exoplayer/source/ShuffleOrder;[Landroidx/media3/exoplayer/source/MediaSource;)V
    .locals 3
    .param p1, "isAtomic"    # Z
    .param p2, "useLazyPreparation"    # Z
    .param p3, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .param p4, "mediaSources"    # [Landroidx/media3/exoplayer/source/MediaSource;

    .line 141
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;-><init>()V

    .line 142
    array-length v0, p4

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v0, :cond_0

    aget-object v2, p4, v1

    .line 143
    .local v2, "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    .end local v2    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 145
    :cond_0
    invoke-interface {p3}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v0

    if-lez v0, :cond_1

    invoke-interface {p3}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    goto :goto_1

    :cond_1
    move-object v0, p3

    :goto_1
    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 146
    new-instance v0, Ljava/util/IdentityHashMap;

    invoke-direct {v0}, Ljava/util/IdentityHashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    .line 147
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByUid:Ljava/util/Map;

    .line 148
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    .line 149
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    .line 150
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->nextTimelineUpdateOnCompletionActions:Ljava/util/Set;

    .line 151
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->pendingOnCompletionActions:Ljava/util/Set;

    .line 152
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    .line 153
    iput-boolean p1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->isAtomic:Z

    .line 154
    iput-boolean p2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->useLazyPreparation:Z

    .line 155
    invoke-static {p4}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSources(Ljava/util/Collection;)V

    .line 156
    return-void
.end method

.method public varargs constructor <init>(Z[Landroidx/media3/exoplayer/source/MediaSource;)V
    .locals 2
    .param p1, "isAtomic"    # Z
    .param p2, "mediaSources"    # [Landroidx/media3/exoplayer/source/MediaSource;

    .line 111
    new-instance v0, Landroidx/media3/exoplayer/source/ShuffleOrder$DefaultShuffleOrder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroidx/media3/exoplayer/source/ShuffleOrder$DefaultShuffleOrder;-><init>(I)V

    invoke-direct {p0, p1, v0, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;-><init>(ZLandroidx/media3/exoplayer/source/ShuffleOrder;[Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 112
    return-void
.end method

.method public varargs constructor <init>([Landroidx/media3/exoplayer/source/MediaSource;)V
    .locals 1
    .param p1, "mediaSources"    # [Landroidx/media3/exoplayer/source/MediaSource;

    .line 101
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;-><init>(Z[Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 102
    return-void
.end method

.method static synthetic access$100()Landroidx/media3/common/MediaItem;
    .locals 1

    .line 61
    sget-object v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->PLACEHOLDER_MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    return-object v0
.end method

.method private addMediaSourceInternal(ILandroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V
    .locals 4
    .param p1, "newIndex"    # I
    .param p2, "newMediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 789
    if-lez p1, :cond_0

    .line 790
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    add-int/lit8 v1, p1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 791
    .local v0, "previousHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iget-object v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v1

    .line 792
    .local v1, "previousTimeline":Landroidx/media3/common/Timeline;
    iget v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 793
    invoke-virtual {v1}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v3

    add-int/2addr v2, v3

    .line 792
    invoke-virtual {p2, p1, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->reset(II)V

    .line 794
    .end local v0    # "previousHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .end local v1    # "previousTimeline":Landroidx/media3/common/Timeline;
    goto :goto_0

    .line 795
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p2, p1, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->reset(II)V

    .line 797
    :goto_0
    iget-object v0, p2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v0

    .line 798
    .local v0, "newTimeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v0}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v1

    const/4 v2, 0x1

    invoke-direct {p0, p1, v2, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->correctOffsets(III)V

    .line 799
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1, p1, p2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 800
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByUid:Ljava/util/Map;

    iget-object v2, p2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-interface {v1, v2, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 801
    iget-object v1, p2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {p0, p2, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->prepareChildSource(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 802
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v1}, Ljava/util/IdentityHashMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 803
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v1, p2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 805
    :cond_1
    invoke-virtual {p0, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->disableChildSource(Ljava/lang/Object;)V

    .line 807
    :goto_1
    return-void
.end method

.method private addMediaSourcesInternal(ILjava/util/Collection;)V
    .locals 3
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;",
            ">;)V"
        }
    .end annotation

    .line 783
    .local p2, "mediaSourceHolders":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;>;"
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 784
    .local v1, "mediaSourceHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    add-int/lit8 v2, p1, 0x1

    .end local p1    # "index":I
    .local v2, "index":I
    invoke-direct {p0, p1, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSourceInternal(ILandroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V

    .line 785
    .end local v1    # "mediaSourceHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    move p1, v2

    goto :goto_0

    .line 786
    .end local v2    # "index":I
    .restart local p1    # "index":I
    :cond_0
    return-void
.end method

.method private addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 7
    .param p1, "index"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/MediaSource;",
            ">;",
            "Landroid/os/Handler;",
            "Ljava/lang/Runnable;",
            ")V"
        }
    .end annotation

    .line 588
    .local p2, "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p3, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    if-nez p4, :cond_1

    move v3, v0

    goto :goto_1

    :cond_1
    move v3, v1

    :goto_1
    if-ne v2, v3, :cond_2

    goto :goto_2

    :cond_2
    move v0, v1

    :goto_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 589
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 590
    .local v0, "playbackThreadHandler":Landroid/os/Handler;
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/exoplayer/source/MediaSource;

    .line 591
    .local v3, "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 592
    .end local v3    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    goto :goto_3

    .line 593
    :cond_3
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {p2}, Ljava/util/Collection;->size()I

    move-result v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 594
    .local v2, "mediaSourceHolders":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;>;"
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/source/MediaSource;

    .line 595
    .local v4, "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    new-instance v5, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    iget-boolean v6, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->useLazyPreparation:Z

    invoke-direct {v5, v4, v6}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;-><init>(Landroidx/media3/exoplayer/source/MediaSource;Z)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 596
    .end local v4    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    goto :goto_4

    .line 597
    :cond_4
    iget-object v3, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v3, p1, v2}, Ljava/util/List;->addAll(ILjava/util/Collection;)Z

    .line 598
    if-eqz v0, :cond_5

    invoke-interface {p2}, Ljava/util/Collection;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_5

    .line 600
    invoke-direct {p0, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->createOnCompletionAction(Landroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    move-result-object v3

    .line 601
    .local v3, "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    new-instance v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    invoke-direct {v4, p1, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;-><init>(ILjava/lang/Object;Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 602
    invoke-virtual {v0, v1, v4}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 603
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .end local v3    # "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    goto :goto_5

    .line 604
    :cond_5
    if-eqz p4, :cond_6

    if-eqz p3, :cond_6

    .line 605
    invoke-virtual {p3, p4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_6

    .line 604
    :cond_6
    :goto_5
    nop

    .line 607
    :goto_6
    return-void
.end method

.method private correctOffsets(III)V
    .locals 3
    .param p1, "startIndex"    # I
    .param p2, "childIndexUpdate"    # I
    .param p3, "windowOffsetUpdate"    # I

    .line 848
    move v0, p1

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 849
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 850
    .local v1, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iget v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    add-int/2addr v2, p2

    iput v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    .line 851
    iget v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    add-int/2addr v2, p3

    iput v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 848
    .end local v1    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 853
    .end local v0    # "i":I
    :cond_0
    return-void
.end method

.method private createOnCompletionAction(Landroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    .locals 2
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .line 682
    if-eqz p1, :cond_1

    if-nez p2, :cond_0

    goto :goto_0

    .line 685
    :cond_0
    new-instance v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    invoke-direct {v0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;-><init>(Landroid/os/Handler;Ljava/lang/Runnable;)V

    .line 686
    .local v0, "handlerAndRunnable":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->pendingOnCompletionActions:Ljava/util/Set;

    invoke-interface {v1, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 687
    return-object v0

    .line 683
    .end local v0    # "handlerAndRunnable":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method private disableUnusedMediaSources()V
    .locals 3

    .line 869
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 870
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 871
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 872
    .local v1, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iget-object v2, v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 873
    invoke-virtual {p0, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->disableChildSource(Ljava/lang/Object;)V

    .line 874
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 876
    .end local v1    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    :cond_0
    goto :goto_0

    .line 877
    :cond_1
    return-void
.end method

.method private declared-synchronized dispatchOnCompletionActions(Ljava/util/Set;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set<",
            "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;",
            ">;)V"
        }
    .end annotation

    .local p1, "onCompletionActions":Ljava/util/Set;, "Ljava/util/Set<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;>;"
    monitor-enter p0

    .line 775
    :try_start_0
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    .line 776
    .local v1, "pendingAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;->dispatch()V

    .line 777
    .end local v1    # "pendingAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    goto :goto_0

    .line 778
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->pendingOnCompletionActions:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 779
    monitor-exit p0

    return-void

    .line 774
    .end local p1    # "onCompletionActions":Ljava/util/Set;, "Ljava/util/Set<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method private enableMediaSource(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V
    .locals 1
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 864
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 865
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enableChildSource(Ljava/lang/Object;)V

    .line 866
    return-void
.end method

.method private static getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 886
    invoke-static {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;->getChildPeriodUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getMediaSourceHolderUid(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "periodUid"    # Ljava/lang/Object;

    .line 881
    invoke-static {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;->getChildTimelineUidFromConcatenatedUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static getPeriodUid(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "holder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .param p1, "childPeriodUid"    # Ljava/lang/Object;

    .line 890
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-static {v0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;->getConcatenatedUid(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private getPlaybackThreadHandlerOnPlaybackThread()Landroid/os/Handler;
    .locals 1

    .line 770
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Handler;

    return-object v0
.end method

.method private handleMessage(Landroid/os/Message;)Z
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .line 694
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    packed-switch v0, :pswitch_data_0

    .line 737
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 733
    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Set;

    .line 734
    .local v0, "actions":Ljava/util/Set;, "Ljava/util/Set<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;>;"
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->dispatchOnCompletionActions(Ljava/util/Set;)V

    .line 735
    goto/16 :goto_2

    .line 730
    .end local v0    # "actions":Ljava/util/Set;, "Ljava/util/Set<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;>;"
    :pswitch_1
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->updateTimelineAndScheduleOnCompletionActions()V

    .line 731
    goto/16 :goto_2

    .line 724
    :pswitch_2
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 725
    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 726
    .local v0, "shuffleOrderMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Landroidx/media3/exoplayer/source/ShuffleOrder;>;"
    iget-object v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v2, Landroidx/media3/exoplayer/source/ShuffleOrder;

    iput-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 727
    iget-object v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->onCompletionAction:Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 728
    goto/16 :goto_2

    .line 717
    .end local v0    # "shuffleOrderMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Landroidx/media3/exoplayer/source/ShuffleOrder;>;"
    :pswitch_3
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 718
    .local v0, "moveMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/lang/Integer;>;"
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    iget v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    iget v4, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    add-int/2addr v4, v1

    invoke-interface {v2, v3, v4}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndRemove(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 719
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-interface {v2, v3, v1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 720
    iget v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    iget-object v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    invoke-direct {p0, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->moveMediaSourceInternal(II)V

    .line 721
    iget-object v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->onCompletionAction:Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 722
    goto :goto_2

    .line 703
    .end local v0    # "moveMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/lang/Integer;>;"
    :pswitch_4
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 704
    .local v0, "removeMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/lang/Integer;>;"
    iget v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    .line 705
    .local v2, "fromIndex":I
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 706
    .local v3, "toIndex":I
    if-nez v2, :cond_0

    iget-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v4}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v4

    if-ne v3, v4, :cond_0

    .line 707
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v4}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v4

    iput-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    goto :goto_0

    .line 709
    :cond_0
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v4, v2, v3}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndRemove(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v4

    iput-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 711
    :goto_0
    add-int/lit8 v4, v3, -0x1

    .local v4, "index":I
    :goto_1
    if-lt v4, v2, :cond_1

    .line 712
    invoke-direct {p0, v4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removeMediaSourceInternal(I)V

    .line 711
    add-int/lit8 v4, v4, -0x1

    goto :goto_1

    .line 714
    .end local v4    # "index":I
    :cond_1
    iget-object v4, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->onCompletionAction:Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    invoke-direct {p0, v4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 715
    goto :goto_2

    .line 696
    .end local v0    # "removeMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/lang/Integer;>;"
    .end local v2    # "fromIndex":I
    .end local v3    # "toIndex":I
    :pswitch_5
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 697
    invoke-static {v0}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 698
    .local v0, "addMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/util/Collection<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;>;>;"
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    iget v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    iget-object v4, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v4, Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->size()I

    move-result v4

    invoke-interface {v2, v3, v4}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 699
    iget v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->index:I

    iget-object v3, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->customData:Ljava/lang/Object;

    check-cast v3, Ljava/util/Collection;

    invoke-direct {p0, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSourcesInternal(ILjava/util/Collection;)V

    .line 700
    iget-object v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;->onCompletionAction:Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 701
    nop

    .line 739
    .end local v0    # "addMessage":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;, "Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData<Ljava/util/Collection<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;>;>;"
    :goto_2
    return v1

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private maybeReleaseChildSource(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V
    .locals 1
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 857
    iget-boolean v0, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->isRemoved:Z

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 858
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 859
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->releaseChildSource(Ljava/lang/Object;)V

    .line 861
    :cond_0
    return-void
.end method

.method private moveMediaSourceInternal(II)V
    .locals 6
    .param p1, "currentIndex"    # I
    .param p2, "newIndex"    # I

    .line 833
    invoke-static {p1, p2}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 834
    .local v0, "startIndex":I
    invoke-static {p1, p2}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 835
    .local v1, "endIndex":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    iget v2, v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 836
    .local v2, "windowOffset":I
    iget-object v3, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-interface {v3, p2, v4}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 837
    move v3, v0

    .local v3, "i":I
    :goto_0
    if-gt v3, v1, :cond_0

    .line 838
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v4, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 839
    .local v4, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iput v3, v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    .line 840
    iput v2, v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    .line 841
    iget-object v5, v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v5}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v5

    invoke-virtual {v5}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v5

    add-int/2addr v2, v5

    .line 837
    .end local v4    # "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 843
    .end local v3    # "i":I
    :cond_0
    return-void
.end method

.method private movePublicMediaSource(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 4
    .param p1, "currentIndex"    # I
    .param p2, "newIndex"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;

    .line 635
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p3, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    if-nez p4, :cond_1

    move v3, v0

    goto :goto_1

    :cond_1
    move v3, v1

    :goto_1
    if-ne v2, v3, :cond_2

    goto :goto_2

    :cond_2
    move v0, v1

    :goto_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 636
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 637
    .local v0, "playbackThreadHandler":Landroid/os/Handler;
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-interface {v1, p2, v2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 638
    if-eqz v0, :cond_3

    .line 640
    invoke-direct {p0, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->createOnCompletionAction(Landroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    move-result-object v1

    .line 641
    .local v1, "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    new-instance v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 642
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v2, p1, v3, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;-><init>(ILjava/lang/Object;Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    const/4 v3, 0x2

    invoke-virtual {v0, v3, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    .line 643
    invoke-virtual {v2}, Landroid/os/Message;->sendToTarget()V

    .end local v1    # "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    goto :goto_3

    .line 644
    :cond_3
    if-eqz p4, :cond_4

    if-eqz p3, :cond_4

    .line 645
    invoke-virtual {p3, p4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_4

    .line 644
    :cond_4
    :goto_3
    nop

    .line 647
    :goto_4
    return-void
.end method

.method private removeMediaSourceInternal(I)V
    .locals 4
    .param p1, "index"    # I

    .line 824
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 825
    .local v0, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByUid:Ljava/util/Map;

    iget-object v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->uid:Ljava/lang/Object;

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 826
    iget-object v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v1}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->getTimeline()Landroidx/media3/common/Timeline;

    move-result-object v1

    .line 827
    .local v1, "oldTimeline":Landroidx/media3/common/Timeline;
    invoke-virtual {v1}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v2

    neg-int v2, v2

    const/4 v3, -0x1

    invoke-direct {p0, p1, v3, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->correctOffsets(III)V

    .line 828
    const/4 v2, 0x1

    iput-boolean v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->isRemoved:Z

    .line 829
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->maybeReleaseChildSource(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V

    .line 830
    return-void
.end method

.method private removePublicMediaSources(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 5
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;

    .line 615
    const/4 v0, 0x0

    const/4 v1, 0x1

    if-nez p3, :cond_0

    move v2, v1

    goto :goto_0

    :cond_0
    move v2, v0

    :goto_0
    if-nez p4, :cond_1

    move v3, v1

    goto :goto_1

    :cond_1
    move v3, v0

    :goto_1
    if-ne v2, v3, :cond_2

    move v0, v1

    :cond_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 616
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 617
    .local v0, "playbackThreadHandler":Landroid/os/Handler;
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-static {v2, p1, p2}, Landroidx/media3/common/util/Util;->removeRange(Ljava/util/List;II)V

    .line 618
    if-eqz v0, :cond_3

    .line 620
    invoke-direct {p0, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->createOnCompletionAction(Landroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    move-result-object v2

    .line 621
    .local v2, "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    new-instance v3, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    .line 622
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-direct {v3, p1, v4, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;-><init>(ILjava/lang/Object;Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    invoke-virtual {v0, v1, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 623
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .end local v2    # "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    goto :goto_2

    .line 624
    :cond_3
    if-eqz p4, :cond_4

    if-eqz p3, :cond_4

    .line 625
    invoke-virtual {p3, p4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_3

    .line 624
    :cond_4
    :goto_2
    nop

    .line 627
    :goto_3
    return-void
.end method

.method private scheduleTimelineUpdate()V
    .locals 1

    .line 743
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 744
    return-void
.end method

.method private scheduleTimelineUpdate(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V
    .locals 2
    .param p1, "onCompletionAction"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    .line 747
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->timelineUpdateScheduled:Z

    if-nez v0, :cond_0

    .line 748
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getPlaybackThreadHandlerOnPlaybackThread()Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 749
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->timelineUpdateScheduled:Z

    .line 751
    :cond_0
    if-eqz p1, :cond_1

    .line 752
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->nextTimelineUpdateOnCompletionActions:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 754
    :cond_1
    return-void
.end method

.method private setPublicShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 5
    .param p1, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "onCompletionAction"    # Ljava/lang/Runnable;

    .line 652
    const/4 v0, 0x1

    const/4 v1, 0x0

    if-nez p2, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    if-nez p3, :cond_1

    move v3, v0

    goto :goto_1

    :cond_1
    move v3, v1

    :goto_1
    if-ne v2, v3, :cond_2

    goto :goto_2

    :cond_2
    move v0, v1

    :goto_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 653
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 654
    .local v0, "playbackThreadHandler":Landroid/os/Handler;
    if-eqz v0, :cond_4

    .line 655
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getSize()I

    move-result v2

    .line 656
    .local v2, "size":I
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v3

    if-eq v3, v2, :cond_3

    .line 657
    nop

    .line 659
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v3

    .line 660
    invoke-interface {v3, v1, v2}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object p1

    .line 663
    :cond_3
    invoke-direct {p0, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->createOnCompletionAction(Landroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;

    move-result-object v3

    .line 664
    .local v3, "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    new-instance v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;

    invoke-direct {v4, v1, p1, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MessageData;-><init>(ILjava/lang/Object;Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;)V

    .line 665
    const/4 v1, 0x3

    invoke-virtual {v0, v1, v4}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 668
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 669
    .end local v2    # "size":I
    .end local v3    # "callbackAction":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;
    goto :goto_4

    .line 670
    :cond_4
    nop

    .line 671
    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v1

    if-lez v1, :cond_5

    invoke-interface {p1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v1

    goto :goto_3

    :cond_5
    move-object v1, p1

    :goto_3
    iput-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 672
    if-eqz p3, :cond_6

    if-eqz p2, :cond_6

    .line 673
    invoke-virtual {p2, p3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 676
    :cond_6
    :goto_4
    return-void
.end method

.method private updateMediaSourceInternal(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/common/Timeline;)V
    .locals 4
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .param p2, "timeline"    # Landroidx/media3/common/Timeline;

    .line 810
    iget v0, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 811
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    iget v1, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    add-int/lit8 v1, v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 812
    .local v0, "nextHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    nop

    .line 813
    invoke-virtual {p2}, Landroidx/media3/common/Timeline;->getWindowCount()I

    move-result v1

    iget v2, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    iget v3, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    sub-int/2addr v2, v3

    sub-int/2addr v1, v2

    .line 815
    .local v1, "windowOffsetUpdate":I
    if-eqz v1, :cond_0

    .line 816
    iget v2, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->childIndex:I

    add-int/lit8 v2, v2, 0x1

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->correctOffsets(III)V

    .line 820
    .end local v0    # "nextHolder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .end local v1    # "windowOffsetUpdate":I
    :cond_0
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate()V

    .line 821
    return-void
.end method

.method private updateTimelineAndScheduleOnCompletionActions()V
    .locals 5

    .line 757
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->timelineUpdateScheduled:Z

    .line 758
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->nextTimelineUpdateOnCompletionActions:Ljava/util/Set;

    .line 759
    .local v0, "onCompletionActions":Ljava/util/Set;, "Ljava/util/Set<Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$HandlerAndRunnable;>;"
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iput-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->nextTimelineUpdateOnCompletionActions:Ljava/util/Set;

    .line 760
    new-instance v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    iget-object v3, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    iget-boolean v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->isAtomic:Z

    invoke-direct {v1, v2, v3, v4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;-><init>(Ljava/util/Collection;Landroidx/media3/exoplayer/source/ShuffleOrder;Z)V

    invoke-virtual {p0, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->refreshSourceInfo(Landroidx/media3/common/Timeline;)V

    .line 761
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getPlaybackThreadHandlerOnPlaybackThread()Landroid/os/Handler;

    move-result-object v1

    .line 762
    const/4 v2, 0x5

    invoke-virtual {v1, v2, v0}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    .line 763
    invoke-virtual {v1}, Landroid/os/Message;->sendToTarget()V

    .line 764
    return-void
.end method


# virtual methods
.method public declared-synchronized addMediaSource(ILandroidx/media3/exoplayer/source/MediaSource;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;

    monitor-enter p0

    .line 205
    nop

    .line 207
    :try_start_0
    invoke-static {p2}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 205
    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 210
    monitor-exit p0

    return-void

    .line 204
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    .end local p2    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSource(ILandroidx/media3/exoplayer/source/MediaSource;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 224
    nop

    .line 225
    :try_start_0
    invoke-static {p2}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    .line 224
    invoke-direct {p0, p1, v0, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 226
    monitor-exit p0

    return-void

    .line 223
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    .end local p2    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    .end local p3    # "handler":Landroid/os/Handler;
    .end local p4    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSource(Landroidx/media3/exoplayer/source/MediaSource;)V
    .locals 1
    .param p1, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;

    monitor-enter p0

    .line 181
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-virtual {p0, v0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSource(ILandroidx/media3/exoplayer/source/MediaSource;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 182
    monitor-exit p0

    return-void

    .line 180
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSource(Landroidx/media3/exoplayer/source/MediaSource;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 194
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-virtual {p0, v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSource(ILandroidx/media3/exoplayer/source/MediaSource;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 195
    monitor-exit p0

    return-void

    .line 193
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "mediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    .end local p2    # "handler":Landroid/os/Handler;
    .end local p3    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSources(ILjava/util/Collection;)V
    .locals 1
    .param p1, "index"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/MediaSource;",
            ">;)V"
        }
    .end annotation

    .local p2, "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    monitor-enter p0

    .line 266
    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0, p1, p2, v0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 267
    monitor-exit p0

    return-void

    .line 265
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    .end local p2    # "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "index"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/MediaSource;",
            ">;",
            "Landroid/os/Handler;",
            "Ljava/lang/Runnable;",
            ")V"
        }
    .end annotation

    .local p2, "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    monitor-enter p0

    .line 285
    :try_start_0
    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 286
    monitor-exit p0

    return-void

    .line 284
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    .end local p2    # "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    .end local p3    # "handler":Landroid/os/Handler;
    .end local p4    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSources(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/MediaSource;",
            ">;)V"
        }
    .end annotation

    .local p1, "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    monitor-enter p0

    .line 235
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    .line 236
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 235
    const/4 v1, 0x0

    invoke-direct {p0, v0, p1, v1, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 240
    monitor-exit p0

    return-void

    .line 234
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized addMediaSources(Ljava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 1
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "onCompletionAction"    # Ljava/lang/Runnable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection<",
            "Landroidx/media3/exoplayer/source/MediaSource;",
            ">;",
            "Landroid/os/Handler;",
            "Ljava/lang/Runnable;",
            ")V"
        }
    .end annotation

    .local p1, "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    monitor-enter p0

    .line 254
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-direct {p0, v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addPublicMediaSources(ILjava/util/Collection;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 255
    monitor-exit p0

    return-void

    .line 253
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "mediaSources":Ljava/util/Collection;, "Ljava/util/Collection<Landroidx/media3/exoplayer/source/MediaSource;>;"
    .end local p2    # "handler":Landroid/os/Handler;
    .end local p3    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized clear()V
    .locals 2

    monitor-enter p0

    .line 403
    :try_start_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getSize()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removeMediaSourceRange(II)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 404
    monitor-exit p0

    return-void

    .line 402
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clear(Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 414
    :try_start_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getSize()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p0, v1, v0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removeMediaSourceRange(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 415
    monitor-exit p0

    return-void

    .line 413
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "handler":Landroid/os/Handler;
    .end local p2    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 6
    .param p1, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p2, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p3, "startPositionUs"    # J

    .line 485
    iget-object v0, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getMediaSourceHolderUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 486
    .local v0, "mediaSourceHolderUid":Ljava/lang/Object;
    iget-object v1, p1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getChildPeriodUid(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v1

    .line 487
    .local v1, "childMediaPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByUid:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 488
    .local v2, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    if-nez v2, :cond_0

    .line 490
    new-instance v3, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    new-instance v4, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$FakeMediaSource;

    const/4 v5, 0x0

    invoke-direct {v4, v5}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$FakeMediaSource;-><init>(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$1;)V

    iget-boolean v5, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->useLazyPreparation:Z

    invoke-direct {v3, v4, v5}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;-><init>(Landroidx/media3/exoplayer/source/MediaSource;Z)V

    move-object v2, v3

    .line 491
    const/4 v3, 0x1

    iput-boolean v3, v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->isRemoved:Z

    .line 492
    iget-object v3, v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {p0, v2, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->prepareChildSource(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource;)V

    .line 494
    :cond_0
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enableMediaSource(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V

    .line 495
    iget-object v3, v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 496
    iget-object v3, v2, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    .line 497
    invoke-virtual {v3, v1, p2, p3, p4}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MaskingMediaPeriod;

    move-result-object v3

    .line 498
    .local v3, "mediaPeriod":Landroidx/media3/exoplayer/source/MediaPeriod;
    iget-object v4, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v4, v3, v2}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 499
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->disableUnusedMediaSources()V

    .line 500
    return-object v3
.end method

.method protected disableInternal()V
    .locals 1

    .line 517
    invoke-super {p0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->disableInternal()V

    .line 518
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 519
    return-void
.end method

.method protected enableInternal()V
    .locals 0

    .line 481
    return-void
.end method

.method public declared-synchronized getInitialTimeline()Landroidx/media3/common/Timeline;
    .locals 4

    monitor-enter p0

    .line 161
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->getLength()I

    move-result v0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 164
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 163
    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    .line 165
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    .line 164
    const/4 v2, 0x0

    invoke-interface {v0, v2, v1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    goto :goto_0

    .line 166
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    :goto_0
    nop

    .line 167
    .local v0, "shuffleOrder":Landroidx/media3/exoplayer/source/ShuffleOrder;
    new-instance v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    iget-boolean v3, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->isAtomic:Z

    invoke-direct {v1, v2, v0, v3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$ConcatenatedTimeline;-><init>(Ljava/util/Collection;Landroidx/media3/exoplayer/source/ShuffleOrder;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v1

    .line 160
    .end local v0    # "shuffleOrder":Landroidx/media3/exoplayer/source/ShuffleOrder;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getMediaItem()Landroidx/media3/common/MediaItem;
    .locals 1

    .line 460
    sget-object v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->PLACEHOLDER_MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    return-object v0
.end method

.method protected getMediaPeriodIdForChildMediaPeriodId(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 5
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 557
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 560
    iget-object v1, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    iget-wide v1, v1, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    iget-wide v3, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->windowSequenceNumber:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 562
    iget-object v1, p2, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->periodUid:Ljava/lang/Object;

    invoke-static {p1, v1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getPeriodUid(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 563
    .local v1, "periodUid":Ljava/lang/Object;
    invoke-virtual {p2, v1}, Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;->copyWithPeriodUid(Ljava/lang/Object;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v2

    return-object v2

    .line 557
    .end local v1    # "periodUid":Ljava/lang/Object;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 566
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic getMediaPeriodIdForChildMediaPeriodId(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .locals 0

    .line 59
    check-cast p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getMediaPeriodIdForChildMediaPeriodId(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object p1

    return-object p1
.end method

.method public declared-synchronized getMediaSource(I)Landroidx/media3/exoplayer/source/MediaSource;
    .locals 1
    .param p1, "index"    # I

    monitor-enter p0

    .line 429
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 429
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized getSize()I
    .locals 1

    monitor-enter p0

    .line 419
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    .line 419
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected getWindowIndexForChildWindowIndex(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;I)I
    .locals 1
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .param p2, "windowIndex"    # I

    .line 577
    iget v0, p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->firstWindowIndexInChild:I

    add-int/2addr v0, p2

    return v0
.end method

.method protected bridge synthetic getWindowIndexForChildWindowIndex(Ljava/lang/Object;I)I
    .locals 0

    .line 59
    check-cast p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getWindowIndexForChildWindowIndex(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;I)I

    move-result p1

    return p1
.end method

.method public isSingleWindow()Z
    .locals 1

    .line 172
    const/4 v0, 0x0

    return v0
.end method

.method public declared-synchronized moveMediaSource(II)V
    .locals 1
    .param p1, "currentIndex"    # I
    .param p2, "newIndex"    # I

    monitor-enter p0

    .line 380
    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0, p1, p2, v0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->movePublicMediaSource(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 382
    monitor-exit p0

    return-void

    .line 379
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "currentIndex":I
    .end local p2    # "newIndex":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized moveMediaSource(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "currentIndex"    # I
    .param p2, "newIndex"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 398
    :try_start_0
    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->movePublicMediaSource(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 399
    monitor-exit p0

    return-void

    .line 397
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "currentIndex":I
    .end local p2    # "newIndex":I
    .end local p3    # "handler":Landroid/os/Handler;
    .end local p4    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method protected onChildSourceInfoRefreshed(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V
    .locals 0
    .param p1, "mediaSourceHolder"    # Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    .param p2, "mediaSource"    # Landroidx/media3/exoplayer/source/MediaSource;
    .param p3, "timeline"    # Landroidx/media3/common/Timeline;

    .line 545
    invoke-direct {p0, p1, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->updateMediaSourceInternal(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/common/Timeline;)V

    .line 546
    return-void
.end method

.method protected bridge synthetic onChildSourceInfoRefreshed(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V
    .locals 0

    .line 59
    check-cast p1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->onChildSourceInfoRefreshed(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;Landroidx/media3/exoplayer/source/MediaSource;Landroidx/media3/common/Timeline;)V

    return-void
.end method

.method protected declared-synchronized prepareSourceInternal(Landroidx/media3/datasource/TransferListener;)V
    .locals 3
    .param p1, "mediaTransferListener"    # Landroidx/media3/datasource/TransferListener;

    monitor-enter p0

    .line 466
    :try_start_0
    invoke-super {p0, p1}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->prepareSourceInternal(Landroidx/media3/datasource/TransferListener;)V

    .line 467
    new-instance v0, Landroid/os/Handler;

    new-instance v1, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$$ExternalSyntheticLambda0;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;)V

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Handler$Callback;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 468
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 469
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->updateTimelineAndScheduleOnCompletionActions()V

    goto :goto_0

    .line 471
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    const/4 v2, 0x0

    invoke-interface {v0, v2, v1}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndInsert(II)Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 472
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourcesPublic:Ljava/util/List;

    invoke-direct {p0, v2, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->addMediaSourcesInternal(ILjava/util/Collection;)V

    .line 473
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->scheduleTimelineUpdate()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 475
    :goto_0
    monitor-exit p0

    return-void

    .line 465
    .end local p1    # "mediaTransferListener":Landroidx/media3/datasource/TransferListener;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 3
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 505
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    .line 506
    invoke-virtual {v0, p1}, Ljava/util/IdentityHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;

    .line 507
    .local v0, "holder":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;
    iget-object v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->mediaSource:Landroidx/media3/exoplayer/source/MaskingMediaSource;

    invoke-virtual {v1, p1}, Landroidx/media3/exoplayer/source/MaskingMediaSource;->releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 508
    iget-object v1, v0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;->activeMediaPeriodIds:Ljava/util/List;

    move-object v2, p1

    check-cast v2, Landroidx/media3/exoplayer/source/MaskingMediaPeriod;

    iget-object v2, v2, Landroidx/media3/exoplayer/source/MaskingMediaPeriod;->id:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    invoke-interface {v1, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 509
    iget-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByMediaPeriod:Ljava/util/IdentityHashMap;

    invoke-virtual {v1}, Ljava/util/IdentityHashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 510
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->disableUnusedMediaSources()V

    .line 512
    :cond_0
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->maybeReleaseChildSource(Landroidx/media3/exoplayer/source/ConcatenatingMediaSource$MediaSourceHolder;)V

    .line 513
    return-void
.end method

.method protected declared-synchronized releaseSourceInternal()V
    .locals 2

    monitor-enter p0

    .line 523
    :try_start_0
    invoke-super {p0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->releaseSourceInternal()V

    .line 524
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceHolders:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 525
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->enabledMediaSourceHolders:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 526
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->mediaSourceByUid:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 527
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/ShuffleOrder;->cloneAndClear()Landroidx/media3/exoplayer/source/ShuffleOrder;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->shuffleOrder:Landroidx/media3/exoplayer/source/ShuffleOrder;

    .line 528
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    if-eqz v0, :cond_0

    .line 529
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 530
    iput-object v1, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->playbackThreadHandler:Landroid/os/Handler;

    .line 532
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->timelineUpdateScheduled:Z

    .line 533
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->nextTimelineUpdateOnCompletionActions:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 534
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->pendingOnCompletionActions:Ljava/util/Set;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->dispatchOnCompletionActions(Ljava/util/Set;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 535
    monitor-exit p0

    return-void

    .line 522
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeMediaSource(I)Landroidx/media3/exoplayer/source/MediaSource;
    .locals 3
    .param p1, "index"    # I

    monitor-enter p0

    .line 302
    :try_start_0
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getMediaSource(I)Landroidx/media3/exoplayer/source/MediaSource;

    move-result-object v0

    .line 303
    .local v0, "removedMediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    add-int/lit8 v1, p1, 0x1

    const/4 v2, 0x0

    invoke-direct {p0, p1, v1, v2, v2}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removePublicMediaSources(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 304
    monitor-exit p0

    return-object v0

    .line 301
    .end local v0    # "removedMediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeMediaSource(ILandroid/os/Handler;Ljava/lang/Runnable;)Landroidx/media3/exoplayer/source/MediaSource;
    .locals 2
    .param p1, "index"    # I
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 325
    :try_start_0
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->getMediaSource(I)Landroidx/media3/exoplayer/source/MediaSource;

    move-result-object v0

    .line 326
    .local v0, "removedMediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    add-int/lit8 v1, p1, 0x1

    invoke-direct {p0, p1, v1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removePublicMediaSources(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 327
    monitor-exit p0

    return-object v0

    .line 324
    .end local v0    # "removedMediaSource":Landroidx/media3/exoplayer/source/MediaSource;
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "index":I
    .end local p2    # "handler":Landroid/os/Handler;
    .end local p3    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeMediaSourceRange(II)V
    .locals 1
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I

    monitor-enter p0

    .line 345
    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0, p1, p2, v0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removePublicMediaSources(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 347
    monitor-exit p0

    return-void

    .line 344
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "fromIndex":I
    .end local p2    # "toIndex":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized removeMediaSourceRange(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "fromIndex"    # I
    .param p2, "toIndex"    # I
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 368
    :try_start_0
    invoke-direct {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->removePublicMediaSources(IILandroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 369
    monitor-exit p0

    return-void

    .line 367
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "fromIndex":I
    .end local p2    # "toIndex":I
    .end local p3    # "handler":Landroid/os/Handler;
    .end local p4    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;)V
    .locals 1
    .param p1, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;

    monitor-enter p0

    .line 438
    const/4 v0, 0x0

    :try_start_0
    invoke-direct {p0, p1, v0, v0}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->setPublicShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 439
    monitor-exit p0

    return-void

    .line 437
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "shuffleOrder":Landroidx/media3/exoplayer/source/ShuffleOrder;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;Landroid/os/Handler;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "shuffleOrder"    # Landroidx/media3/exoplayer/source/ShuffleOrder;
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "onCompletionAction"    # Ljava/lang/Runnable;

    monitor-enter p0

    .line 451
    :try_start_0
    invoke-direct {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;->setPublicShuffleOrder(Landroidx/media3/exoplayer/source/ShuffleOrder;Landroid/os/Handler;Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 452
    monitor-exit p0

    return-void

    .line 450
    .end local p0    # "this":Landroidx/media3/exoplayer/source/ConcatenatingMediaSource;
    .end local p1    # "shuffleOrder":Landroidx/media3/exoplayer/source/ShuffleOrder;
    .end local p2    # "handler":Landroid/os/Handler;
    .end local p3    # "onCompletionAction":Ljava/lang/Runnable;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
