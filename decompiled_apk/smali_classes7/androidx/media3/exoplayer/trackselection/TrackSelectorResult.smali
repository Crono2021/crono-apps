.class public final Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;
.super Ljava/lang/Object;
.source "TrackSelectorResult.java"


# instance fields
.field public final info:Ljava/lang/Object;

.field public final length:I

.field public final rendererConfigurations:[Landroidx/media3/exoplayer/RendererConfiguration;

.field public final selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

.field public final tracks:Landroidx/media3/common/Tracks;


# direct methods
.method public constructor <init>([Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/common/Tracks;Ljava/lang/Object;)V
    .locals 1
    .param p1, "rendererConfigurations"    # [Landroidx/media3/exoplayer/RendererConfiguration;
    .param p2, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p3, "tracks"    # Landroidx/media3/common/Tracks;
    .param p4, "info"    # Ljava/lang/Object;

    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    iput-object p1, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->rendererConfigurations:[Landroidx/media3/exoplayer/RendererConfiguration;

    .line 83
    invoke-virtual {p2}, [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 84
    iput-object p3, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->tracks:Landroidx/media3/common/Tracks;

    .line 85
    iput-object p4, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->info:Ljava/lang/Object;

    .line 86
    array-length v0, p1

    iput v0, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->length:I

    .line 87
    return-void
.end method

.method public constructor <init>([Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Ljava/lang/Object;)V
    .locals 1
    .param p1, "rendererConfigurations"    # [Landroidx/media3/exoplayer/RendererConfiguration;
    .param p2, "selections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .param p3, "info"    # Ljava/lang/Object;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 65
    sget-object v0, Landroidx/media3/common/Tracks;->EMPTY:Landroidx/media3/common/Tracks;

    invoke-direct {p0, p1, p2, v0, p3}, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;-><init>([Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;Landroidx/media3/common/Tracks;Ljava/lang/Object;)V

    .line 66
    return-void
.end method


# virtual methods
.method public isEquivalent(Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;)Z
    .locals 3
    .param p1, "other"    # Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;

    .line 102
    const/4 v0, 0x0

    if-eqz p1, :cond_3

    iget-object v1, p1, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    array-length v1, v1

    iget-object v2, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    array-length v2, v2

    if-eq v1, v2, :cond_0

    goto :goto_1

    .line 105
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    array-length v2, v2

    if-ge v1, v2, :cond_2

    .line 106
    invoke-virtual {p0, p1, v1}, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->isEquivalent(Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;I)Z

    move-result v2

    if-nez v2, :cond_1

    .line 107
    return v0

    .line 105
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 110
    .end local v1    # "i":I
    :cond_2
    const/4 v0, 0x1

    return v0

    .line 103
    :cond_3
    :goto_1
    return v0
.end method

.method public isEquivalent(Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;I)Z
    .locals 3
    .param p1, "other"    # Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;
    .param p2, "index"    # I

    .line 125
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 126
    return v0

    .line 128
    :cond_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->rendererConfigurations:[Landroidx/media3/exoplayer/RendererConfiguration;

    aget-object v1, v1, p2

    iget-object v2, p1, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->rendererConfigurations:[Landroidx/media3/exoplayer/RendererConfiguration;

    aget-object v2, v2, p2

    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    aget-object v1, v1, p2

    iget-object v2, p1, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->selections:[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    aget-object v2, v2, p2

    .line 129
    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    nop

    .line 128
    :goto_0
    return v0
.end method

.method public isRendererEnabled(I)Z
    .locals 1
    .param p1, "index"    # I

    .line 91
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/TrackSelectorResult;->rendererConfigurations:[Landroidx/media3/exoplayer/RendererConfiguration;

    aget-object v0, v0, p1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
