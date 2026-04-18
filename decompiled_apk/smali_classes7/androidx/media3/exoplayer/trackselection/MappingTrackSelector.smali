.class public abstract Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;
.super Landroidx/media3/exoplayer/trackselection/TrackSelector;
.source "MappingTrackSelector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    }
.end annotation


# instance fields
.field private currentMappedTrackInfo:Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 58
    invoke-direct {p0}, Landroidx/media3/exoplayer/trackselection/TrackSelector;-><init>()V

    return-void
.end method

.method private static findRenderer([Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/common/TrackGroup;[IZ)I
    .locals 8
    .param p0, "rendererCapabilities"    # [Landroidx/media3/exoplayer/RendererCapabilities;
    .param p1, "group"    # Landroidx/media3/common/TrackGroup;
    .param p2, "rendererTrackGroupCounts"    # [I
    .param p3, "preferUnassociatedRenderer"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 503
    array-length v0, p0

    .line 504
    .local v0, "bestRendererIndex":I
    const/4 v1, 0x0

    .line 505
    .local v1, "bestFormatSupportLevel":I
    const/4 v2, 0x1

    .line 506
    .local v2, "bestRendererIsUnassociated":Z
    const/4 v3, 0x0

    .local v3, "rendererIndex":I
    :goto_0
    array-length v4, p0

    if-ge v3, v4, :cond_4

    .line 507
    aget-object v4, p0, v3

    .line 508
    .local v4, "rendererCapability":Landroidx/media3/exoplayer/RendererCapabilities;
    const/4 v5, 0x0

    .line 509
    .local v5, "formatSupportLevel":I
    const/4 v6, 0x0

    .local v6, "trackIndex":I
    :goto_1
    iget v7, p1, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v6, v7, :cond_0

    .line 511
    nop

    .line 513
    invoke-virtual {p1, v6}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v7

    invoke-interface {v4, v7}, Landroidx/media3/exoplayer/RendererCapabilities;->supportsFormat(Landroidx/media3/common/Format;)I

    move-result v7

    .line 512
    invoke-static {v7}, Landroidx/media3/exoplayer/RendererCapabilities;->getFormatSupport(I)I

    move-result v7

    .line 514
    .local v7, "trackFormatSupportLevel":I
    invoke-static {v5, v7}, Ljava/lang/Math;->max(II)I

    move-result v5

    .line 509
    .end local v7    # "trackFormatSupportLevel":I
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 516
    .end local v6    # "trackIndex":I
    :cond_0
    aget v6, p2, v3

    if-nez v6, :cond_1

    const/4 v6, 0x1

    goto :goto_2

    :cond_1
    const/4 v6, 0x0

    .line 517
    .local v6, "rendererIsUnassociated":Z
    :goto_2
    if-gt v5, v1, :cond_2

    if-ne v5, v1, :cond_3

    if-eqz p3, :cond_3

    if-nez v2, :cond_3

    if-eqz v6, :cond_3

    .line 522
    :cond_2
    move v0, v3

    .line 523
    move v1, v5

    .line 524
    move v2, v6

    .line 506
    .end local v4    # "rendererCapability":Landroidx/media3/exoplayer/RendererCapabilities;
    .end local v5    # "formatSupportLevel":I
    .end local v6    # "rendererIsUnassociated":Z
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 527
    .end local v3    # "rendererIndex":I
    :cond_4
    return v0
.end method

.method private static getFormatSupport(Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/common/TrackGroup;)[I
    .locals 3
    .param p0, "rendererCapabilities"    # Landroidx/media3/exoplayer/RendererCapabilities;
    .param p1, "group"    # Landroidx/media3/common/TrackGroup;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 541
    iget v0, p1, Landroidx/media3/common/TrackGroup;->length:I

    new-array v0, v0, [I

    .line 542
    .local v0, "formatSupport":[I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p1, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v1, v2, :cond_0

    .line 543
    invoke-virtual {p1, v1}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v2

    invoke-interface {p0, v2}, Landroidx/media3/exoplayer/RendererCapabilities;->supportsFormat(Landroidx/media3/common/Format;)I

    move-result v2

    aput v2, v0, v1

    .line 542
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 545
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method

.method private static getMixedMimeTypeAdaptationSupports([Landroidx/media3/exoplayer/RendererCapabilities;)[I
    .locals 3
    .param p0, "rendererCapabilities"    # [Landroidx/media3/exoplayer/RendererCapabilities;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 559
    array-length v0, p0

    new-array v0, v0, [I

    .line 560
    .local v0, "mixedMimeTypeAdaptationSupport":[I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_0

    .line 561
    aget-object v2, p0, v1

    invoke-interface {v2}, Landroidx/media3/exoplayer/RendererCapabilities;->supportsMixedMimeTypeAdaptation()I

    move-result v2

    aput v2, v0, v1

    .line 560
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 563
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method


# virtual methods
.method public final getCurrentMappedTrackInfo()Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .locals 1

    .line 340
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->currentMappedTrackInfo:Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    return-object v0
.end method

.method public final onSelectionActivated(Ljava/lang/Object;)V
    .locals 1
    .param p1, "info"    # Ljava/lang/Object;

    .line 347
    move-object v0, p1

    check-cast v0, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->currentMappedTrackInfo:Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    .line 348
    return-void
.end method

.method protected abstract selectTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/Timeline;)Landroid/util/Pair;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I[I",
            "Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;",
            "Landroidx/media3/common/Timeline;",
            ")",
            "Landroid/util/Pair<",
            "[",
            "Landroidx/media3/exoplayer/RendererConfiguration;",
            "[",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation
.end method

.method public final selectTracks([Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/Timeline;)Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;
    .locals 18
    .param p1, "rendererCapabilities"    # [Landroidx/media3/exoplayer/RendererCapabilities;
    .param p2, "trackGroups"    # Landroidx/media3/exoplayer/source/TrackGroupArray;
    .param p3, "periodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p4, "timeline"    # Landroidx/media3/common/Timeline;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 360
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    array-length v2, v0

    const/4 v3, 0x1

    add-int/2addr v2, v3

    new-array v2, v2, [I

    .line 361
    .local v2, "rendererTrackGroupCounts":[I
    array-length v4, v0

    add-int/2addr v4, v3

    new-array v4, v4, [[Landroidx/media3/common/TrackGroup;

    .line 362
    .local v4, "rendererTrackGroups":[[Landroidx/media3/common/TrackGroup;
    array-length v5, v0

    add-int/2addr v5, v3

    new-array v5, v5, [[[I

    .line 363
    .local v5, "rendererFormatSupports":[[[I
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    array-length v7, v4

    if-ge v6, v7, :cond_0

    .line 364
    iget v7, v1, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    new-array v7, v7, [Landroidx/media3/common/TrackGroup;

    aput-object v7, v4, v6

    .line 365
    iget v7, v1, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    new-array v7, v7, [[I

    aput-object v7, v5, v6

    .line 363
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 370
    .end local v6    # "i":I
    :cond_0
    nop

    .line 371
    invoke-static/range {p1 .. p1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->getMixedMimeTypeAdaptationSupports([Landroidx/media3/exoplayer/RendererCapabilities;)[I

    move-result-object v13

    .line 375
    .local v13, "rendererMixedMimeTypeAdaptationSupports":[I
    const/4 v6, 0x0

    .local v6, "groupIndex":I
    :goto_1
    iget v7, v1, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    if-ge v6, v7, :cond_3

    .line 376
    invoke-virtual {v1, v6}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v7

    .line 378
    .local v7, "group":Landroidx/media3/common/TrackGroup;
    iget v8, v7, Landroidx/media3/common/TrackGroup;->type:I

    const/4 v9, 0x5

    if-ne v8, v9, :cond_1

    move v8, v3

    goto :goto_2

    :cond_1
    const/4 v8, 0x0

    .line 379
    .local v8, "preferUnassociatedRenderer":Z
    :goto_2
    nop

    .line 380
    invoke-static {v0, v7, v2, v8}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->findRenderer([Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/common/TrackGroup;[IZ)I

    move-result v9

    .line 385
    .local v9, "rendererIndex":I
    array-length v10, v0

    if-ne v9, v10, :cond_2

    .line 386
    iget v10, v7, Landroidx/media3/common/TrackGroup;->length:I

    new-array v10, v10, [I

    goto :goto_3

    .line 387
    :cond_2
    aget-object v10, v0, v9

    invoke-static {v10, v7}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->getFormatSupport(Landroidx/media3/exoplayer/RendererCapabilities;Landroidx/media3/common/TrackGroup;)[I

    move-result-object v10

    :goto_3
    nop

    .line 389
    .local v10, "rendererFormatSupport":[I
    aget v11, v2, v9

    .line 390
    .local v11, "rendererTrackGroupCount":I
    aget-object v12, v4, v9

    aput-object v7, v12, v11

    .line 391
    aget-object v12, v5, v9

    aput-object v10, v12, v11

    .line 392
    aget v12, v2, v9

    add-int/2addr v12, v3

    aput v12, v2, v9

    .line 375
    .end local v7    # "group":Landroidx/media3/common/TrackGroup;
    .end local v8    # "preferUnassociatedRenderer":Z
    .end local v9    # "rendererIndex":I
    .end local v10    # "rendererFormatSupport":[I
    .end local v11    # "rendererTrackGroupCount":I
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 396
    .end local v6    # "groupIndex":I
    :cond_3
    array-length v3, v0

    new-array v3, v3, [Landroidx/media3/exoplayer/source/TrackGroupArray;

    .line 397
    .local v3, "rendererTrackGroupArrays":[Landroidx/media3/exoplayer/source/TrackGroupArray;
    array-length v6, v0

    new-array v14, v6, [Ljava/lang/String;

    .line 398
    .local v14, "rendererNames":[Ljava/lang/String;
    array-length v6, v0

    new-array v15, v6, [I

    .line 399
    .local v15, "rendererTrackTypes":[I
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_4
    array-length v7, v0

    if-ge v6, v7, :cond_4

    .line 400
    aget v7, v2, v6

    .line 401
    .local v7, "rendererTrackGroupCount":I
    new-instance v8, Landroidx/media3/exoplayer/source/TrackGroupArray;

    aget-object v9, v4, v6

    .line 403
    invoke-static {v9, v7}, Landroidx/media3/common/util/Util;->nullSafeArrayCopy([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Landroidx/media3/common/TrackGroup;

    invoke-direct {v8, v9}, Landroidx/media3/exoplayer/source/TrackGroupArray;-><init>([Landroidx/media3/common/TrackGroup;)V

    aput-object v8, v3, v6

    .line 404
    aget-object v8, v5, v6

    .line 405
    invoke-static {v8, v7}, Landroidx/media3/common/util/Util;->nullSafeArrayCopy([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [[I

    aput-object v8, v5, v6

    .line 406
    aget-object v8, v0, v6

    invoke-interface {v8}, Landroidx/media3/exoplayer/RendererCapabilities;->getName()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v14, v6

    .line 407
    aget-object v8, v0, v6

    invoke-interface {v8}, Landroidx/media3/exoplayer/RendererCapabilities;->getTrackType()I

    move-result v8

    aput v8, v15, v6

    .line 399
    .end local v7    # "rendererTrackGroupCount":I
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 411
    .end local v6    # "i":I
    :cond_4
    array-length v6, v0

    aget v11, v2, v6

    .line 412
    .local v11, "unmappedTrackGroupCount":I
    new-instance v12, Landroidx/media3/exoplayer/source/TrackGroupArray;

    array-length v6, v0

    aget-object v6, v4, v6

    .line 414
    invoke-static {v6, v11}, Landroidx/media3/common/util/Util;->nullSafeArrayCopy([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Landroidx/media3/common/TrackGroup;

    invoke-direct {v12, v6}, Landroidx/media3/exoplayer/source/TrackGroupArray;-><init>([Landroidx/media3/common/TrackGroup;)V

    .line 418
    .local v12, "unmappedTrackGroupArray":Landroidx/media3/exoplayer/source/TrackGroupArray;
    new-instance v16, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;

    move-object/from16 v6, v16

    move-object v7, v14

    move-object v8, v15

    move-object v9, v3

    move-object v10, v13

    move/from16 v17, v11

    .end local v11    # "unmappedTrackGroupCount":I
    .local v17, "unmappedTrackGroupCount":I
    move-object v11, v5

    invoke-direct/range {v6 .. v12}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;-><init>([Ljava/lang/String;[I[Landroidx/media3/exoplayer/source/TrackGroupArray;[I[[[ILandroidx/media3/exoplayer/source/TrackGroupArray;)V

    move-object/from16 v11, v16

    .line 427
    .local v11, "mappedTrackInfo":Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    nop

    .line 428
    move-object/from16 v6, p0

    move-object v7, v11

    move-object v8, v5

    move-object v9, v13

    move-object/from16 v10, p3

    move-object v0, v11

    .end local v11    # "mappedTrackInfo":Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .local v0, "mappedTrackInfo":Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    move-object/from16 v11, p4

    invoke-virtual/range {v6 .. v11}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->selectTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/Timeline;)Landroid/util/Pair;

    move-result-object v6

    .line 435
    .local v6, "result":Landroid/util/Pair;, "Landroid/util/Pair<[Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;>;"
    iget-object v7, v6, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v7, [Landroidx/media3/exoplayer/trackselection/TrackSelection;

    invoke-static {v0, v7}, Landroidx/media3/exoplayer/trackselection/TrackSelectionUtil;->buildTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[Landroidx/media3/exoplayer/trackselection/TrackSelection;)Landroidx/media3/common/Tracks;

    move-result-object v7

    .line 437
    .local v7, "tracks":Landroidx/media3/common/Tracks;
    new-instance v8, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;

    iget-object v9, v6, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v9, [Landroidx/media3/exoplayer/RendererConfiguration;

    iget-object v10, v6, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v10, [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    invoke-direct {v8, v9, v10, v7, v0}, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;-><init>([Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/common/Tracks;Ljava/lang/Object;)V

    return-object v8
.end method
