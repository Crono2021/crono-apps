.class final Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;
.super Ljava/lang/Object;
.source "CompositeMediaSource.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaSourceEventListener;
.implements Landroidx/media3/exoplayer/drm/DrmSessionEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/CompositeMediaSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ForwardingEventListener"
.end annotation


# instance fields
.field private drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

.field private final id:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

.field final synthetic this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/CompositeMediaSource;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .line 229
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    .local p2, "id":Ljava/lang/Object;, "TT;"
    iput-object p1, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 230
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->createEventDispatcher(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 231
    invoke-virtual {p1, v0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->createDrmEventDispatcher(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    move-result-object p1

    iput-object p1, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    .line 232
    iput-object p2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->id:Ljava/lang/Object;

    .line 233
    return-void
.end method

.method private maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z
    .locals 3
    .param p1, "childWindowIndex"    # I
    .param p2, "childMediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 357
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    const/4 v0, 0x0

    .line 358
    .local v0, "mediaPeriodId":Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    if-eqz p2, :cond_0

    .line 359
    iget-object v1, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->id:Ljava/lang/Object;

    invoke-virtual {v1, v2, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->getMediaPeriodIdForChildMediaPeriodId(Ljava/lang/Object;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    move-result-object v0

    .line 360
    if-nez v0, :cond_0

    .line 362
    const/4 v1, 0x0

    return v1

    .line 365
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->id:Ljava/lang/Object;

    invoke-virtual {v1, v2, p1}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->getWindowIndexForChildWindowIndex(Ljava/lang/Object;I)I

    move-result v1

    .line 366
    .local v1, "windowIndex":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    iget v2, v2, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->windowIndex:I

    if-ne v2, v1, :cond_1

    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    iget-object v2, v2, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 367
    invoke-static {v2, v0}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 368
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    invoke-virtual {v2, v1, v0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->createEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 370
    :cond_2
    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    iget v2, v2, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->windowIndex:I

    if-ne v2, v1, :cond_3

    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    iget-object v2, v2, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->mediaPeriodId:Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 371
    invoke-static {v2, v0}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 372
    :cond_3
    iget-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    invoke-virtual {v2, v1, v0}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->createDrmEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    move-result-object v2

    iput-object v2, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    .line 374
    :cond_4
    const/4 v2, 0x1

    return v2
.end method

.method private maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;
    .locals 18
    .param p1, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;
    .param p2, "childMediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 379
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    iget-object v3, v0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    iget-object v4, v0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->id:Ljava/lang/Object;

    iget-wide v5, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->mediaStartTimeMs:J

    .line 380
    invoke-virtual {v3, v4, v5, v6, v2}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->getMediaTimeForChildMediaTime(Ljava/lang/Object;JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)J

    move-result-wide v3

    .line 381
    .local v3, "mediaStartTimeMs":J
    iget-object v5, v0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->this$0:Landroidx/media3/exoplayer/source/CompositeMediaSource;

    iget-object v6, v0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->id:Ljava/lang/Object;

    iget-wide v7, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->mediaEndTimeMs:J

    .line 382
    invoke-virtual {v5, v6, v7, v8, v2}, Landroidx/media3/exoplayer/source/CompositeMediaSource;->getMediaTimeForChildMediaTime(Ljava/lang/Object;JLandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)J

    move-result-wide v5

    .line 383
    .local v5, "mediaEndTimeMs":J
    iget-wide v7, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->mediaStartTimeMs:J

    cmp-long v7, v3, v7

    if-nez v7, :cond_0

    iget-wide v7, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->mediaEndTimeMs:J

    cmp-long v7, v5, v7

    if-nez v7, :cond_0

    .line 385
    return-object v1

    .line 387
    :cond_0
    new-instance v17, Landroidx/media3/exoplayer/source/MediaLoadData;

    iget v8, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->dataType:I

    iget v9, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->trackType:I

    iget-object v10, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->trackFormat:Landroidx/media3/common/Format;

    iget v11, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->trackSelectionReason:I

    iget-object v12, v1, Landroidx/media3/exoplayer/source/MediaLoadData;->trackSelectionData:Ljava/lang/Object;

    move-object/from16 v7, v17

    move-wide v13, v3

    move-wide v15, v5

    invoke-direct/range {v7 .. v16}, Landroidx/media3/exoplayer/source/MediaLoadData;-><init>(IILandroidx/media3/common/Format;ILjava/lang/Object;JJ)V

    return-object v17
.end method


# virtual methods
.method public onDownstreamFormatChanged(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 302
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 303
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 304
    invoke-direct {p0, p3, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 303
    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->downstreamFormatChanged(Landroidx/media3/exoplayer/source/MediaLoadData;)V

    .line 306
    :cond_0
    return-void
.end method

.method public onDrmKeysLoaded(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 320
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 321
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmKeysLoaded()V

    .line 323
    :cond_0
    return-void
.end method

.method public onDrmKeysRemoved(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 342
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 343
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmKeysRemoved()V

    .line 345
    :cond_0
    return-void
.end method

.method public onDrmKeysRestored(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 335
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 336
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmKeysRestored()V

    .line 338
    :cond_0
    return-void
.end method

.method public onDrmSessionAcquired(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;I)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "state"    # I

    .line 313
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0, p3}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmSessionAcquired(I)V

    .line 316
    :cond_0
    return-void
.end method

.method public onDrmSessionManagerError(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Ljava/lang/Exception;)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "error"    # Ljava/lang/Exception;

    .line 328
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 329
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0, p3}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmSessionManagerError(Ljava/lang/Exception;)V

    .line 331
    :cond_0
    return-void
.end method

.method public onDrmSessionReleased(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)V
    .locals 1
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;

    .line 349
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 350
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->drmEventDispatcher:Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/drm/DrmSessionEventListener$EventDispatcher;->drmSessionReleased()V

    .line 352
    :cond_0
    return-void
.end method

.method public onLoadCanceled(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "loadEventData"    # Landroidx/media3/exoplayer/source/LoadEventInfo;
    .param p4, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 267
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 268
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 269
    invoke-direct {p0, p4, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 268
    invoke-virtual {v0, p3, v1}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->loadCanceled(Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V

    .line 271
    :cond_0
    return-void
.end method

.method public onLoadCompleted(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "loadEventData"    # Landroidx/media3/exoplayer/source/LoadEventInfo;
    .param p4, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 255
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 256
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 257
    invoke-direct {p0, p4, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 256
    invoke-virtual {v0, p3, v1}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->loadCompleted(Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V

    .line 259
    :cond_0
    return-void
.end method

.method public onLoadError(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;Ljava/io/IOException;Z)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "loadEventData"    # Landroidx/media3/exoplayer/source/LoadEventInfo;
    .param p4, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;
    .param p5, "error"    # Ljava/io/IOException;
    .param p6, "wasCanceled"    # Z

    .line 281
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 282
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 284
    invoke-direct {p0, p4, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 282
    invoke-virtual {v0, p3, v1, p5, p6}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->loadError(Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;Ljava/io/IOException;Z)V

    .line 288
    :cond_0
    return-void
.end method

.method public onLoadStarted(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "loadEventData"    # Landroidx/media3/exoplayer/source/LoadEventInfo;
    .param p4, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 243
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 245
    invoke-direct {p0, p4, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 244
    invoke-virtual {v0, p3, v1}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->loadStarted(Landroidx/media3/exoplayer/source/LoadEventInfo;Landroidx/media3/exoplayer/source/MediaLoadData;)V

    .line 247
    :cond_0
    return-void
.end method

.method public onUpstreamDiscarded(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/source/MediaLoadData;)V
    .locals 2
    .param p1, "windowIndex"    # I
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "mediaLoadData"    # Landroidx/media3/exoplayer/source/MediaLoadData;

    .line 293
    .local p0, "this":Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;, "Landroidx/media3/exoplayer/source/CompositeMediaSource<TT;>.ForwardingEventListener;"
    invoke-direct {p0, p1, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateEventDispatcher(ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 294
    iget-object v0, p0, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->mediaSourceEventDispatcher:Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;

    .line 295
    invoke-direct {p0, p3, p2}, Landroidx/media3/exoplayer/source/CompositeMediaSource$ForwardingEventListener;->maybeUpdateMediaLoadData(Landroidx/media3/exoplayer/source/MediaLoadData;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;)Landroidx/media3/exoplayer/source/MediaLoadData;

    move-result-object v1

    .line 294
    invoke-virtual {v0, v1}, Landroidx/media3/exoplayer/source/MediaSourceEventListener$EventDispatcher;->upstreamDiscarded(Landroidx/media3/exoplayer/source/MediaLoadData;)V

    .line 297
    :cond_0
    return-void
.end method
