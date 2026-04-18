.class final Landroidx/media3/extractor/mp4/TrackSampleTable;
.super Ljava/lang/Object;
.source "TrackSampleTable.java"


# instance fields
.field public final durationUs:J

.field public final flags:[I

.field public final maximumSize:I

.field public final offsets:[J

.field public final sampleCount:I

.field public final sizes:[I

.field public final timestampsUs:[J

.field public final track:Landroidx/media3/extractor/mp4/Track;


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V
    .locals 4
    .param p1, "track"    # Landroidx/media3/extractor/mp4/Track;
    .param p2, "offsets"    # [J
    .param p3, "sizes"    # [I
    .param p4, "maximumSize"    # I
    .param p5, "timestampsUs"    # [J
    .param p6, "flags"    # [I
    .param p7, "durationUs"    # J

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    array-length v0, p3

    array-length v1, p5

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-ne v0, v1, :cond_0

    move v0, v3

    goto :goto_0

    :cond_0
    move v0, v2

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 58
    array-length v0, p2

    array-length v1, p5

    if-ne v0, v1, :cond_1

    move v0, v3

    goto :goto_1

    :cond_1
    move v0, v2

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 59
    array-length v0, p6

    array-length v1, p5

    if-ne v0, v1, :cond_2

    move v2, v3

    :cond_2
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 61
    iput-object p1, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    .line 62
    iput-object p2, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->offsets:[J

    .line 63
    iput-object p3, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->sizes:[I

    .line 64
    iput p4, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->maximumSize:I

    .line 65
    iput-object p5, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->timestampsUs:[J

    .line 66
    iput-object p6, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->flags:[I

    .line 67
    iput-wide p7, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->durationUs:J

    .line 68
    array-length v0, p2

    iput v0, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->sampleCount:I

    .line 69
    array-length v0, p6

    if-lez v0, :cond_3

    .line 70
    array-length v0, p6

    sub-int/2addr v0, v3

    aget v1, p6, v0

    const/high16 v2, 0x20000000

    or-int/2addr v1, v2

    aput v1, p6, v0

    .line 72
    :cond_3
    return-void
.end method


# virtual methods
.method public getIndexOfEarlierOrEqualSynchronizationSample(J)I
    .locals 4
    .param p1, "timeUs"    # J

    .line 84
    iget-object v0, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->timestampsUs:[J

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, p1, p2, v2, v1}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v0

    .line 85
    .local v0, "startIndex":I
    move v1, v0

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 86
    iget-object v3, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->flags:[I

    aget v3, v3, v1

    and-int/2addr v3, v2

    if-eqz v3, :cond_0

    .line 87
    return v1

    .line 85
    :cond_0
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 90
    .end local v1    # "i":I
    :cond_1
    const/4 v1, -0x1

    return v1
.end method

.method public getIndexOfLaterOrEqualSynchronizationSample(J)I
    .locals 4
    .param p1, "timeUs"    # J

    .line 101
    iget-object v0, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->timestampsUs:[J

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-static {v0, p1, p2, v2, v1}, Landroidx/media3/common/util/Util;->binarySearchCeil([JJZZ)I

    move-result v0

    .line 102
    .local v0, "startIndex":I
    move v1, v0

    .local v1, "i":I
    :goto_0
    iget-object v3, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->timestampsUs:[J

    array-length v3, v3

    if-ge v1, v3, :cond_1

    .line 103
    iget-object v3, p0, Landroidx/media3/extractor/mp4/TrackSampleTable;->flags:[I

    aget v3, v3, v1

    and-int/2addr v3, v2

    if-eqz v3, :cond_0

    .line 104
    return v1

    .line 102
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 107
    .end local v1    # "i":I
    :cond_1
    const/4 v1, -0x1

    return v1
.end method
