.class final Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;
.super Ljava/lang/Object;
.source "PreloadMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaPeriod;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;
    }
.end annotation


# instance fields
.field private callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

.field public final mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

.field private preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

.field private prepareInternalCalled:Z

.field private prepared:Z


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 0
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 50
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;)Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    .line 34
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    return-object v0
.end method

.method static synthetic access$102(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;Z)Z
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;
    .param p1, "x1"    # Z

    .line 34
    iput-boolean p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepared:Z

    return p1
.end method

.method private static isSameAdaptionSet(Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z
    .locals 4
    .param p0, "selection"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p1, "preloadSelection"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 208
    invoke-interface {p0}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v0

    invoke-interface {p1}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_3

    .line 209
    invoke-interface {p0}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->length()I

    move-result v0

    invoke-interface {p1}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->length()I

    move-result v2

    if-eq v0, v2, :cond_0

    goto :goto_1

    .line 212
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p0}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->length()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 213
    invoke-interface {p0, v0}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getIndexInTrackGroup(I)I

    move-result v2

    invoke-interface {p1, v0}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getIndexInTrackGroup(I)I

    move-result v3

    if-eq v2, v3, :cond_1

    .line 214
    return v1

    .line 212
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 217
    .end local v0    # "i":I
    :cond_2
    const/4 v0, 0x1

    return v0

    .line 210
    :cond_3
    :goto_1
    return v1
.end method

.method private static maybeUpdatePreloadTrackSelectionHolderForReselection([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;)Z
    .locals 8
    .param p0, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p1, "preloadTrackSelectionHolder"    # Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    .line 169
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 170
    .local v0, "preloadSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    const/4 v1, 0x0

    .line 171
    .local v1, "needsReselection":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, p0

    if-ge v2, v3, :cond_6

    .line 172
    aget-object v3, p0, v2

    .line 173
    .local v3, "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    aget-object v4, v0, v2

    .line 174
    .local v4, "preloadSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    if-nez v3, :cond_0

    if-nez v4, :cond_0

    .line 175
    goto :goto_2

    .line 177
    :cond_0
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->mayRetainStreamFlags:[Z

    const/4 v6, 0x0

    aput-boolean v6, v5, v2

    .line 178
    if-nez v3, :cond_1

    .line 180
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    const/4 v6, 0x0

    aput-object v6, v5, v2

    .line 181
    const/4 v1, 0x1

    goto :goto_2

    .line 182
    :cond_1
    if-nez v4, :cond_2

    .line 184
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    aput-object v3, v5, v2

    .line 185
    const/4 v1, 0x1

    goto :goto_2

    .line 186
    :cond_2
    invoke-static {v3, v4}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->isSameAdaptionSet(Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 188
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    aput-object v3, v5, v2

    .line 189
    const/4 v1, 0x1

    goto :goto_2

    .line 190
    :cond_3
    invoke-interface {v3}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v5

    iget v5, v5, Landroidx/media3/common/TrackGroup;->type:I

    const/4 v6, 0x2

    const/4 v7, 0x1

    if-eq v5, v6, :cond_5

    .line 191
    invoke-interface {v3}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v5

    iget v5, v5, Landroidx/media3/common/TrackGroup;->type:I

    if-eq v5, v7, :cond_5

    .line 192
    invoke-interface {v3}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getSelectedIndexInTrackGroup()I

    move-result v5

    .line 193
    invoke-interface {v4}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getSelectedIndexInTrackGroup()I

    move-result v6

    if-ne v5, v6, :cond_4

    goto :goto_1

    .line 199
    :cond_4
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    aput-object v3, v5, v2

    .line 200
    const/4 v1, 0x1

    goto :goto_2

    .line 196
    :cond_5
    :goto_1
    iget-object v5, p1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->mayRetainStreamFlags:[Z

    aput-boolean v7, v5, v2

    .line 171
    .end local v3    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .end local v4    # "preloadSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 203
    .end local v2    # "i":I
    :cond_6
    return v1
.end method

.method private prepareInternal(J)V
    .locals 2
    .param p1, "positionUs"    # J

    .line 75
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternalCalled:Z

    .line 76
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    new-instance v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;

    invoke-direct {v1, p0}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;-><init>(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;)V

    invoke-interface {v0, v1, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V

    .line 90
    return-void
.end method

.method private selectTracksInternal([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J
    .locals 20
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "mayRetainStreamFlags"    # [Z
    .param p3, "streams"    # [Landroidx/media3/exoplayer/source/SampleStream;
    .param p4, "streamResetFlags"    # [Z
    .param p5, "positionUs"    # J

    .line 119
    move-object/from16 v0, p0

    move-object/from16 v8, p3

    iget-object v1, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    if-nez v1, :cond_0

    .line 121
    iget-object v1, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-wide/from16 v6, p5

    invoke-interface/range {v1 .. v7}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v1

    return-wide v1

    .line 124
    :cond_0
    array-length v2, v8

    iget-object v1, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    array-length v1, v1

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-ne v2, v1, :cond_1

    move v1, v3

    goto :goto_0

    :cond_1
    move v1, v4

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 125
    iget-object v1, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    iget-wide v1, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->trackSelectionPositionUs:J

    cmp-long v1, p5, v1

    const/4 v2, 0x0

    if-eqz v1, :cond_4

    .line 128
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v3, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    iget-object v3, v3, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    array-length v3, v3

    if-ge v1, v3, :cond_3

    .line 129
    iget-object v3, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    iget-object v3, v3, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    aget-object v3, v3, v1

    if-eqz v3, :cond_2

    .line 130
    iget-object v3, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    iget-object v3, v3, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    aget-object v3, v3, v1

    aput-object v3, v8, v1

    .line 131
    aput-boolean v4, p2, v1

    .line 128
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 134
    .end local v1    # "i":I
    :cond_3
    iput-object v2, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    .line 135
    iget-object v1, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    move-wide/from16 v6, p5

    invoke-interface/range {v1 .. v7}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v1

    return-wide v1

    .line 138
    :cond_4
    iget-object v1, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    .line 139
    .local v1, "holder":Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;
    iget-wide v5, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->trackSelectionPositionUs:J

    .line 140
    .local v5, "trackSelectionPositionUs":J
    iget-object v7, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streamResetFlags:[Z

    .line 141
    .local v7, "preloadStreamResetFlags":[Z
    move-object/from16 v9, p1

    invoke-static {v9, v1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->maybeUpdatePreloadTrackSelectionHolderForReselection([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;)Z

    move-result v10

    if-eqz v10, :cond_6

    .line 143
    array-length v10, v7

    new-array v7, v10, [Z

    .line 144
    iget-object v11, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    iget-object v12, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    iget-object v13, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->mayRetainStreamFlags:[Z

    iget-object v14, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    move-wide/from16 v18, v5

    .end local v5    # "trackSelectionPositionUs":J
    .local v18, "trackSelectionPositionUs":J
    iget-wide v4, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->trackSelectionPositionUs:J

    .line 145
    move-object v15, v7

    move-wide/from16 v16, v4

    invoke-interface/range {v11 .. v17}, Landroidx/media3/exoplayer/source/MediaPeriod;->selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v5

    .line 152
    .end local v18    # "trackSelectionPositionUs":J
    .restart local v5    # "trackSelectionPositionUs":J
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    iget-object v11, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->mayRetainStreamFlags:[Z

    array-length v11, v11

    if-ge v4, v11, :cond_7

    .line 153
    iget-object v11, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->mayRetainStreamFlags:[Z

    aget-boolean v11, v11, v4

    if-eqz v11, :cond_5

    .line 154
    aput-boolean v3, v7, v4

    .line 152
    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 141
    .end local v4    # "i":I
    :cond_6
    move-wide/from16 v18, v5

    .line 158
    :cond_7
    iget-object v3, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    iget-object v4, v1, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;->streams:[Landroidx/media3/exoplayer/source/SampleStream;

    array-length v4, v4

    const/4 v10, 0x0

    invoke-static {v3, v10, v8, v10, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 159
    array-length v3, v7

    move-object/from16 v4, p4

    invoke-static {v7, v10, v4, v10, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 161
    iput-object v2, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    .line 162
    return-wide v5
.end method


# virtual methods
.method public continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z
    .locals 1
    .param p1, "loadingInfo"    # Landroidx/media3/exoplayer/LoadingInfo;

    .line 274
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/source/MediaPeriod;->continueLoading(Landroidx/media3/exoplayer/LoadingInfo;)Z

    move-result v0

    return v0
.end method

.method public discardBuffer(JZ)V
    .locals 1
    .param p1, "positionUs"    # J
    .param p3, "toKeyframe"    # Z

    .line 244
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->discardBuffer(JZ)V

    .line 245
    return-void
.end method

.method public getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J
    .locals 2
    .param p1, "positionUs"    # J
    .param p3, "seekParameters"    # Landroidx/media3/exoplayer/SeekParameters;

    .line 259
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2, p3}, Landroidx/media3/exoplayer/source/MediaPeriod;->getAdjustedSeekPositionUs(JLandroidx/media3/exoplayer/SeekParameters;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getBufferedPositionUs()J
    .locals 2

    .line 264
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getBufferedPositionUs()J

    move-result-wide v0

    return-wide v0
.end method

.method public getNextLoadPositionUs()J
    .locals 2

    .line 269
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getNextLoadPositionUs()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;
    .locals 1

    .line 99
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->getTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v0

    return-object v0
.end method

.method public isLoading()Z
    .locals 1

    .line 279
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->isLoading()Z

    move-result v0

    return v0
.end method

.method public maybeThrowPrepareError()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 94
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->maybeThrowPrepareError()V

    .line 95
    return-void
.end method

.method preload(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V
    .locals 1
    .param p1, "callback"    # Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .param p2, "positionUs"    # J

    .line 53
    iput-object p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    .line 54
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepared:Z

    if-eqz v0, :cond_0

    .line 55
    invoke-interface {p1, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 57
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternalCalled:Z

    if-nez v0, :cond_1

    .line 58
    invoke-direct {p0, p2, p3}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternal(J)V

    .line 60
    :cond_1
    return-void
.end method

.method public prepare(Landroidx/media3/exoplayer/source/MediaPeriod$Callback;J)V
    .locals 1
    .param p1, "callback"    # Landroidx/media3/exoplayer/source/MediaPeriod$Callback;
    .param p2, "positionUs"    # J

    .line 64
    iput-object p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->callback:Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    .line 65
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepared:Z

    if-eqz v0, :cond_0

    .line 66
    invoke-interface {p1, p0}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 67
    return-void

    .line 69
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternalCalled:Z

    if-nez v0, :cond_1

    .line 70
    invoke-direct {p0, p2, p3}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternal(J)V

    .line 72
    :cond_1
    return-void
.end method

.method public readDiscontinuity()J
    .locals 2

    .line 249
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/MediaPeriod;->readDiscontinuity()J

    move-result-wide v0

    return-wide v0
.end method

.method public reevaluateBuffer(J)V
    .locals 1
    .param p1, "positionUs"    # J

    .line 284
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->reevaluateBuffer(J)V

    .line 285
    return-void
.end method

.method public seekToUs(J)J
    .locals 2
    .param p1, "positionUs"    # J

    .line 254
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->mediaPeriod:Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/MediaPeriod;->seekToUs(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public selectTracks([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J
    .locals 2
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "mayRetainStreamFlags"    # [Z
    .param p3, "streams"    # [Landroidx/media3/exoplayer/source/SampleStream;
    .param p4, "streamResetFlags"    # [Z
    .param p5, "positionUs"    # J

    .line 109
    invoke-direct/range {p0 .. p6}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->selectTracksInternal([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v0

    return-wide v0
.end method

.method selectTracksForPreloading([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;J)J
    .locals 14
    .param p1, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p2, "positionUs"    # J

    .line 222
    move-object v7, p1

    array-length v0, v7

    new-array v8, v0, [Landroidx/media3/exoplayer/source/SampleStream;

    .line 223
    .local v8, "preloadedSampleStreams":[Landroidx/media3/exoplayer/source/SampleStream;
    array-length v0, v7

    new-array v9, v0, [Z

    .line 224
    .local v9, "preloadedStreamResetFlags":[Z
    array-length v0, v7

    new-array v10, v0, [Z

    .line 225
    .local v10, "mayRetainStreamFlags":[Z
    nop

    .line 226
    move-object v0, p0

    move-object v1, p1

    move-object v2, v10

    move-object v3, v8

    move-object v4, v9

    move-wide/from16 v5, p2

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->selectTracksInternal([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)J

    move-result-wide v11

    .line 232
    .local v11, "trackSelectionPositionUs":J
    new-instance v13, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    move-object v0, v13

    move-wide v5, v11

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;-><init>([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;[Z[Landroidx/media3/exoplayer/source/SampleStream;[ZJ)V

    move-object v0, p0

    iput-object v13, v0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->preloadTrackSelectionHolder:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$PreloadTrackSelectionHolder;

    .line 239
    return-wide v11
.end method
