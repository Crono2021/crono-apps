.class public final Landroidx/media3/common/util/ConstantRateTimestampIterator;
.super Ljava/lang/Object;
.source "ConstantRateTimestampIterator.java"

# interfaces
.implements Landroidx/media3/common/util/TimestampIterator;


# instance fields
.field private currentTimestampUs:D

.field private final durationUs:J

.field private final frameRate:F

.field private final framesDurationUs:D

.field private framesToAdd:I

.field private final startingTimestampUs:J


# direct methods
.method public constructor <init>(JF)V
    .locals 6
    .param p1, "durationUs"    # J
    .param p3, "frameRate"    # F

    .line 49
    const-wide/16 v4, 0x0

    move-object v0, p0

    move-wide v1, p1

    move v3, p3

    invoke-direct/range {v0 .. v5}, Landroidx/media3/common/util/ConstantRateTimestampIterator;-><init>(JFJ)V

    .line 50
    return-void
.end method

.method public constructor <init>(JFJ)V
    .locals 5
    .param p1, "durationUs"    # J
    .param p3, "frameRate"    # F
    .param p4, "startingTimestampUs"    # J

    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-lez v2, :cond_0

    move v2, v3

    goto :goto_0

    :cond_0
    move v2, v4

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 64
    const/4 v2, 0x0

    cmpl-float v2, p3, v2

    if-lez v2, :cond_1

    move v2, v3

    goto :goto_1

    :cond_1
    move v2, v4

    :goto_1
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 65
    cmp-long v0, p4, v0

    if-ltz v0, :cond_2

    goto :goto_2

    :cond_2
    move v3, v4

    :goto_2
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 66
    iput-wide p1, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->durationUs:J

    .line 67
    iput p3, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->frameRate:F

    .line 68
    iput-wide p4, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->startingTimestampUs:J

    .line 69
    long-to-double v0, p4

    iput-wide v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->currentTimestampUs:D

    .line 70
    long-to-float v0, p1

    const v1, 0x49742400    # 1000000.0f

    div-float/2addr v0, v1

    mul-float/2addr v0, p3

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesToAdd:I

    .line 71
    div-float/2addr v1, p3

    float-to-double v0, v1

    iput-wide v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesDurationUs:D

    .line 72
    return-void
.end method


# virtual methods
.method public copyOf()Landroidx/media3/common/util/ConstantRateTimestampIterator;
    .locals 7

    .line 90
    new-instance v6, Landroidx/media3/common/util/ConstantRateTimestampIterator;

    iget-wide v1, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->durationUs:J

    iget v3, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->frameRate:F

    iget-wide v4, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->startingTimestampUs:J

    move-object v0, v6

    invoke-direct/range {v0 .. v5}, Landroidx/media3/common/util/ConstantRateTimestampIterator;-><init>(JFJ)V

    return-object v6
.end method

.method public bridge synthetic copyOf()Landroidx/media3/common/util/TimestampIterator;
    .locals 1

    .line 30
    invoke-virtual {p0}, Landroidx/media3/common/util/ConstantRateTimestampIterator;->copyOf()Landroidx/media3/common/util/ConstantRateTimestampIterator;

    move-result-object v0

    return-object v0
.end method

.method public hasNext()Z
    .locals 1

    .line 76
    iget v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesToAdd:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public next()J
    .locals 6

    .line 81
    invoke-virtual {p0}, Landroidx/media3/common/util/ConstantRateTimestampIterator;->hasNext()Z

    move-result v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 82
    iget v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesToAdd:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesToAdd:I

    .line 83
    iget-wide v0, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->currentTimestampUs:D

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    .line 84
    .local v0, "next":J
    iget-wide v2, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->currentTimestampUs:D

    iget-wide v4, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->framesDurationUs:D

    add-double/2addr v2, v4

    iput-wide v2, p0, Landroidx/media3/common/util/ConstantRateTimestampIterator;->currentTimestampUs:D

    .line 85
    return-wide v0
.end method
