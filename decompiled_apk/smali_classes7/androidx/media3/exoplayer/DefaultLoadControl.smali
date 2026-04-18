.class public Landroidx/media3/exoplayer/DefaultLoadControl;
.super Ljava/lang/Object;
.source "DefaultLoadControl.java"

# interfaces
.implements Landroidx/media3/exoplayer/LoadControl;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/DefaultLoadControl$Builder;
    }
.end annotation


# static fields
.field public static final DEFAULT_AUDIO_BUFFER_SIZE:I = 0xc80000

.field public static final DEFAULT_BACK_BUFFER_DURATION_MS:I = 0x0

.field public static final DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS:I = 0x1388

.field public static final DEFAULT_BUFFER_FOR_PLAYBACK_MS:I = 0x9c4

.field public static final DEFAULT_CAMERA_MOTION_BUFFER_SIZE:I = 0x20000

.field public static final DEFAULT_IMAGE_BUFFER_SIZE:I = 0x20000

.field public static final DEFAULT_MAX_BUFFER_MS:I = 0xc350

.field public static final DEFAULT_METADATA_BUFFER_SIZE:I = 0x20000

.field public static final DEFAULT_MIN_BUFFER_MS:I = 0xc350

.field public static final DEFAULT_MIN_BUFFER_SIZE:I = 0xc80000

.field public static final DEFAULT_MUXED_BUFFER_SIZE:I = 0x89a0000

.field public static final DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS:Z = false

.field public static final DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME:Z = false

.field public static final DEFAULT_TARGET_BUFFER_BYTES:I = -0x1

.field public static final DEFAULT_TEXT_BUFFER_SIZE:I = 0x20000

.field public static final DEFAULT_VIDEO_BUFFER_SIZE:I = 0x7d00000


# instance fields
.field private final allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

.field private final backBufferDurationUs:J

.field private final bufferForPlaybackAfterRebufferUs:J

.field private final bufferForPlaybackUs:J

.field private isLoading:Z

.field private final maxBufferUs:J

.field private final minBufferUs:J

.field private final prioritizeTimeOverSizeThresholds:Z

.field private final retainBackBufferFromKeyframe:Z

.field private targetBufferBytes:I

.field private final targetBufferBytesOverwrite:I


# direct methods
.method public constructor <init>()V
    .locals 10

    .line 271
    new-instance v1, Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    const/4 v0, 0x1

    const/high16 v2, 0x10000

    invoke-direct {v1, v0, v2}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;-><init>(ZI)V

    const v2, 0xc350

    const v3, 0xc350

    const/16 v4, 0x9c4

    const/16 v5, 0x1388

    const/4 v6, -0x1

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v9}, Landroidx/media3/exoplayer/DefaultLoadControl;-><init>(Landroidx/media3/exoplayer/upstream/DefaultAllocator;IIIIIZIZ)V

    .line 281
    return-void
.end method

.method protected constructor <init>(Landroidx/media3/exoplayer/upstream/DefaultAllocator;IIIIIZIZ)V
    .locals 5
    .param p1, "allocator"    # Landroidx/media3/exoplayer/upstream/DefaultAllocator;
    .param p2, "minBufferMs"    # I
    .param p3, "maxBufferMs"    # I
    .param p4, "bufferForPlaybackMs"    # I
    .param p5, "bufferForPlaybackAfterRebufferMs"    # I
    .param p6, "targetBufferBytes"    # I
    .param p7, "prioritizeTimeOverSizeThresholds"    # Z
    .param p8, "backBufferDurationMs"    # I
    .param p9, "retainBackBufferFromKeyframe"    # Z

    .line 292
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 293
    const/4 v0, 0x0

    const-string v1, "bufferForPlaybackMs"

    const-string v2, "0"

    invoke-static {p4, v0, v1, v2}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 294
    const-string v3, "bufferForPlaybackAfterRebufferMs"

    invoke-static {p5, v0, v3, v2}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 296
    const-string/jumbo v4, "minBufferMs"

    invoke-static {p2, p4, v4, v1}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 297
    invoke-static {p2, p5, v4, v3}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 302
    const-string v1, "maxBufferMs"

    invoke-static {p3, p2, v1, v4}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 303
    const-string v1, "backBufferDurationMs"

    invoke-static {p8, v0, v1, v2}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    .line 305
    iput-object p1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    .line 306
    int-to-long v0, p2

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->minBufferUs:J

    .line 307
    int-to-long v0, p3

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->maxBufferUs:J

    .line 308
    int-to-long v0, p4

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->bufferForPlaybackUs:J

    .line 309
    int-to-long v0, p5

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->bufferForPlaybackAfterRebufferUs:J

    .line 310
    iput p6, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytesOverwrite:I

    .line 311
    nop

    .line 312
    const/4 v0, -0x1

    if-eq p6, v0, :cond_0

    .line 313
    move v0, p6

    goto :goto_0

    .line 314
    :cond_0
    const/high16 v0, 0xc80000

    :goto_0
    iput v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytes:I

    .line 315
    iput-boolean p7, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->prioritizeTimeOverSizeThresholds:Z

    .line 316
    int-to-long v0, p8

    invoke-static {v0, v1}, Landroidx/media3/common/util/Util;->msToUs(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->backBufferDurationUs:J

    .line 317
    iput-boolean p9, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->retainBackBufferFromKeyframe:Z

    .line 318
    return-void
.end method

.method static synthetic access$000(IILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # I
    .param p1, "x1"    # I
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/String;

    .line 38
    invoke-static {p0, p1, p2, p3}, Landroidx/media3/exoplayer/DefaultLoadControl;->assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static assertGreaterOrEqual(IILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "value1"    # I
    .param p1, "value2"    # I
    .param p2, "name1"    # Ljava/lang/String;
    .param p3, "name2"    # Ljava/lang/String;

    .line 465
    if-lt p0, p1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " cannot be less than "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 466
    return-void
.end method

.method private static getDefaultBufferSize(I)I
    .locals 1
    .param p0, "trackType"    # I

    .line 441
    const/high16 v0, 0x20000

    packed-switch p0, :pswitch_data_0

    .line 460
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 453
    :pswitch_1
    return v0

    .line 451
    :pswitch_2
    return v0

    .line 455
    :pswitch_3
    return v0

    .line 449
    :pswitch_4
    return v0

    .line 447
    :pswitch_5
    const/high16 v0, 0x7d00000

    return v0

    .line 445
    :pswitch_6
    const/high16 v0, 0xc80000

    return v0

    .line 443
    :pswitch_7
    const/high16 v0, 0x89a0000

    return v0

    .line 457
    :pswitch_8
    const/4 v0, 0x0

    return v0

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_8
        :pswitch_0
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private reset(Z)V
    .locals 2
    .param p1, "resetAllocator"    # Z

    .line 430
    nop

    .line 431
    iget v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytesOverwrite:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 432
    const/high16 v0, 0xc80000

    goto :goto_0

    .line 433
    :cond_0
    nop

    :goto_0
    iput v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytes:I

    .line 434
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->isLoading:Z

    .line 435
    if-eqz p1, :cond_1

    .line 436
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;->reset()V

    .line 438
    :cond_1
    return-void
.end method


# virtual methods
.method protected calculateTargetBufferBytes([Landroidx/media3/exoplayer/Renderer;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)I
    .locals 3
    .param p1, "renderers"    # [Landroidx/media3/exoplayer/Renderer;
    .param p2, "trackSelectionArray"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 420
    const/4 v0, 0x0

    .line 421
    .local v0, "targetBufferSize":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p1

    if-ge v1, v2, :cond_1

    .line 422
    aget-object v2, p2, v1

    if-eqz v2, :cond_0

    .line 423
    aget-object v2, p1, v1

    invoke-interface {v2}, Landroidx/media3/exoplayer/Renderer;->getTrackType()I

    move-result v2

    invoke-static {v2}, Landroidx/media3/exoplayer/DefaultLoadControl;->getDefaultBufferSize(I)I

    move-result v2

    add-int/2addr v0, v2

    .line 421
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 426
    .end local v1    # "i":I
    :cond_1
    const/high16 v1, 0xc80000

    invoke-static {v1, v0}, Ljava/lang/Math;->max(II)I

    move-result v1

    return v1
.end method

.method public getAllocator()Landroidx/media3/exoplayer/upstream/Allocator;
    .locals 1

    .line 351
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    return-object v0
.end method

.method public getBackBufferDurationUs()J
    .locals 2

    .line 356
    iget-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->backBufferDurationUs:J

    return-wide v0
.end method

.method public onPrepared()V
    .locals 1

    .line 322
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/DefaultLoadControl;->reset(Z)V

    .line 323
    return-void
.end method

.method public onReleased()V
    .locals 1

    .line 346
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/DefaultLoadControl;->reset(Z)V

    .line 347
    return-void
.end method

.method public onStopped()V
    .locals 1

    .line 341
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/DefaultLoadControl;->reset(Z)V

    .line 342
    return-void
.end method

.method public onTracksSelected(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;[Landroidx/media3/exoplayer/Renderer;Landroidx/media3/exoplayer/source/TrackGroupArray;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)V
    .locals 2
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "renderers"    # [Landroidx/media3/exoplayer/Renderer;
    .param p4, "trackGroups"    # Landroidx/media3/exoplayer/source/TrackGroupArray;
    .param p5, "trackSelections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 332
    nop

    .line 333
    iget v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytesOverwrite:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 334
    invoke-virtual {p0, p3, p5}, Landroidx/media3/exoplayer/DefaultLoadControl;->calculateTargetBufferBytes([Landroidx/media3/exoplayer/Renderer;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)I

    move-result v0

    goto :goto_0

    .line 335
    :cond_0
    nop

    :goto_0
    iput v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytes:I

    .line 336
    iget-object v1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    invoke-virtual {v1, v0}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;->setTargetBufferSize(I)V

    .line 337
    return-void
.end method

.method public retainBackBufferFromKeyframe()Z
    .locals 1

    .line 361
    iget-boolean v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->retainBackBufferFromKeyframe:Z

    return v0
.end method

.method public shouldContinueLoading(JJF)Z
    .locals 10
    .param p1, "playbackPositionUs"    # J
    .param p3, "bufferedDurationUs"    # J
    .param p5, "playbackSpeed"    # F

    .line 367
    iget-object v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;->getTotalBytesAllocated()I

    move-result v0

    iget v1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytes:I

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-lt v0, v1, :cond_0

    move v0, v2

    goto :goto_0

    :cond_0
    move v0, v3

    .line 368
    .local v0, "targetBufferSizeReached":Z
    :goto_0
    iget-wide v4, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->minBufferUs:J

    .line 369
    .local v4, "minBufferUs":J
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v1, p5, v1

    if-lez v1, :cond_1

    .line 372
    nop

    .line 373
    invoke-static {v4, v5, p5}, Landroidx/media3/common/util/Util;->getMediaDurationForPlayoutDuration(JF)J

    move-result-wide v6

    .line 374
    .local v6, "mediaDurationMinBufferUs":J
    iget-wide v8, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->maxBufferUs:J

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v4

    .line 377
    .end local v6    # "mediaDurationMinBufferUs":J
    :cond_1
    const-wide/32 v6, 0x7a120

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v4

    .line 378
    cmp-long v1, p3, v4

    if-gez v1, :cond_4

    .line 379
    iget-boolean v1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->prioritizeTimeOverSizeThresholds:Z

    if-nez v1, :cond_3

    if-nez v0, :cond_2

    goto :goto_1

    :cond_2
    move v2, v3

    :cond_3
    :goto_1
    iput-boolean v2, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->isLoading:Z

    .line 380
    if-nez v2, :cond_6

    cmp-long v1, p3, v6

    if-gez v1, :cond_6

    .line 381
    const-string v1, "DefaultLoadControl"

    const-string v2, "Target buffer size reached with less than 500ms of buffered media data."

    invoke-static {v1, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 385
    :cond_4
    iget-wide v1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->maxBufferUs:J

    cmp-long v1, p3, v1

    if-gez v1, :cond_5

    if-eqz v0, :cond_6

    .line 386
    :cond_5
    iput-boolean v3, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->isLoading:Z

    .line 388
    :cond_6
    :goto_2
    iget-boolean v1, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->isLoading:Z

    return v1
.end method

.method public shouldStartPlayback(Landroidx/media3/common/Timeline;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;JFZJ)Z
    .locals 4
    .param p1, "timeline"    # Landroidx/media3/common/Timeline;
    .param p2, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p3, "bufferedDurationUs"    # J
    .param p5, "playbackSpeed"    # F
    .param p6, "rebuffering"    # Z
    .param p7, "targetLiveOffsetUs"    # J

    .line 399
    invoke-static {p3, p4, p5}, Landroidx/media3/common/util/Util;->getPlayoutDurationForMediaDuration(JF)J

    move-result-wide p3

    .line 400
    if-eqz p6, :cond_0

    iget-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->bufferForPlaybackAfterRebufferUs:J

    goto :goto_0

    :cond_0
    iget-wide v0, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->bufferForPlaybackUs:J

    .line 401
    .local v0, "minBufferDurationUs":J
    :goto_0
    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v2, p7, v2

    if-eqz v2, :cond_1

    .line 402
    const-wide/16 v2, 0x2

    div-long v2, p7, v2

    invoke-static {v2, v3, v0, v1}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    .line 404
    :cond_1
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_3

    cmp-long v2, p3, v0

    if-gez v2, :cond_3

    iget-boolean v2, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->prioritizeTimeOverSizeThresholds:Z

    if-nez v2, :cond_2

    iget-object v2, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->allocator:Landroidx/media3/exoplayer/upstream/DefaultAllocator;

    .line 407
    invoke-virtual {v2}, Landroidx/media3/exoplayer/upstream/DefaultAllocator;->getTotalBytesAllocated()I

    move-result v2

    iget v3, p0, Landroidx/media3/exoplayer/DefaultLoadControl;->targetBufferBytes:I

    if-lt v2, v3, :cond_2

    goto :goto_1

    :cond_2
    const/4 v2, 0x0

    goto :goto_2

    :cond_3
    :goto_1
    const/4 v2, 0x1

    .line 404
    :goto_2
    return v2
.end method
