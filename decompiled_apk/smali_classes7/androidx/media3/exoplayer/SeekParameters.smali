.class public final Landroidx/media3/exoplayer/SeekParameters;
.super Ljava/lang/Object;
.source "SeekParameters.java"


# static fields
.field public static final CLOSEST_SYNC:Landroidx/media3/exoplayer/SeekParameters;

.field public static final DEFAULT:Landroidx/media3/exoplayer/SeekParameters;

.field public static final EXACT:Landroidx/media3/exoplayer/SeekParameters;

.field public static final NEXT_SYNC:Landroidx/media3/exoplayer/SeekParameters;

.field public static final PREVIOUS_SYNC:Landroidx/media3/exoplayer/SeekParameters;


# instance fields
.field public final toleranceAfterUs:J

.field public final toleranceBeforeUs:J


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .line 42
    new-instance v0, Landroidx/media3/exoplayer/SeekParameters;

    const-wide/16 v1, 0x0

    invoke-direct {v0, v1, v2, v1, v2}, Landroidx/media3/exoplayer/SeekParameters;-><init>(JJ)V

    sput-object v0, Landroidx/media3/exoplayer/SeekParameters;->EXACT:Landroidx/media3/exoplayer/SeekParameters;

    .line 45
    new-instance v3, Landroidx/media3/exoplayer/SeekParameters;

    const-wide v4, 0x7fffffffffffffffL

    invoke-direct {v3, v4, v5, v4, v5}, Landroidx/media3/exoplayer/SeekParameters;-><init>(JJ)V

    sput-object v3, Landroidx/media3/exoplayer/SeekParameters;->CLOSEST_SYNC:Landroidx/media3/exoplayer/SeekParameters;

    .line 49
    new-instance v3, Landroidx/media3/exoplayer/SeekParameters;

    invoke-direct {v3, v4, v5, v1, v2}, Landroidx/media3/exoplayer/SeekParameters;-><init>(JJ)V

    sput-object v3, Landroidx/media3/exoplayer/SeekParameters;->PREVIOUS_SYNC:Landroidx/media3/exoplayer/SeekParameters;

    .line 52
    new-instance v3, Landroidx/media3/exoplayer/SeekParameters;

    invoke-direct {v3, v1, v2, v4, v5}, Landroidx/media3/exoplayer/SeekParameters;-><init>(JJ)V

    sput-object v3, Landroidx/media3/exoplayer/SeekParameters;->NEXT_SYNC:Landroidx/media3/exoplayer/SeekParameters;

    .line 55
    sput-object v0, Landroidx/media3/exoplayer/SeekParameters;->DEFAULT:Landroidx/media3/exoplayer/SeekParameters;

    return-void
.end method

.method public constructor <init>(JJ)V
    .locals 5
    .param p1, "toleranceBeforeUs"    # J
    .param p3, "toleranceAfterUs"    # J

    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    const/4 v3, 0x1

    const/4 v4, 0x0

    if-ltz v2, :cond_0

    move v2, v3

    goto :goto_0

    :cond_0
    move v2, v4

    :goto_0
    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 77
    cmp-long v0, p3, v0

    if-ltz v0, :cond_1

    goto :goto_1

    :cond_1
    move v3, v4

    :goto_1
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 78
    iput-wide p1, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    .line 79
    iput-wide p3, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    .line 80
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "obj"    # Ljava/lang/Object;

    .line 119
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 120
    return v0

    .line 122
    :cond_0
    const/4 v1, 0x0

    if-eqz p1, :cond_3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_1

    goto :goto_1

    .line 125
    :cond_1
    move-object v2, p1

    check-cast v2, Landroidx/media3/exoplayer/SeekParameters;

    .line 126
    .local v2, "other":Landroidx/media3/exoplayer/SeekParameters;
    iget-wide v3, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    iget-wide v5, v2, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    cmp-long v3, v3, v5

    if-nez v3, :cond_2

    iget-wide v3, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    iget-wide v5, v2, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    cmp-long v3, v3, v5

    if-nez v3, :cond_2

    goto :goto_0

    :cond_2
    move v0, v1

    :goto_0
    return v0

    .line 123
    .end local v2    # "other":Landroidx/media3/exoplayer/SeekParameters;
    :cond_3
    :goto_1
    return v1
.end method

.method public hashCode()I
    .locals 3

    .line 132
    iget-wide v0, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    long-to-int v0, v0

    mul-int/lit8 v0, v0, 0x1f

    iget-wide v1, p0, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    long-to-int v1, v1

    add-int/2addr v0, v1

    return v0
.end method

.method public resolveSeekPositionUs(JJJ)J
    .locals 11
    .param p1, "positionUs"    # J
    .param p3, "firstSyncUs"    # J
    .param p5, "secondSyncUs"    # J

    .line 93
    move-object v0, p0

    iget-wide v3, v0, Landroidx/media3/exoplayer/SeekParameters;->toleranceBeforeUs:J

    const-wide/16 v1, 0x0

    cmp-long v5, v3, v1

    if-nez v5, :cond_0

    iget-wide v5, v0, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    cmp-long v1, v5, v1

    if-nez v1, :cond_0

    .line 94
    return-wide p1

    .line 96
    :cond_0
    const-wide/high16 v5, -0x8000000000000000L

    .line 97
    move-wide v1, p1

    invoke-static/range {v1 .. v6}, Landroidx/media3/common/util/Util;->subtractWithOverflowDefault(JJJ)J

    move-result-wide v7

    .line 98
    .local v7, "minPositionUs":J
    iget-wide v3, v0, Landroidx/media3/exoplayer/SeekParameters;->toleranceAfterUs:J

    const-wide v5, 0x7fffffffffffffffL

    invoke-static/range {v1 .. v6}, Landroidx/media3/common/util/Util;->addWithOverflowDefault(JJJ)J

    move-result-wide v1

    .line 99
    .local v1, "maxPositionUs":J
    cmp-long v3, v7, p3

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-gtz v3, :cond_1

    cmp-long v3, p3, v1

    if-gtz v3, :cond_1

    move v3, v4

    goto :goto_0

    :cond_1
    move v3, v5

    .line 100
    .local v3, "firstSyncPositionValid":Z
    :goto_0
    cmp-long v6, v7, p5

    if-gtz v6, :cond_2

    cmp-long v6, p5, v1

    if-gtz v6, :cond_2

    goto :goto_1

    :cond_2
    move v4, v5

    .line 102
    .local v4, "secondSyncPositionValid":Z
    :goto_1
    if-eqz v3, :cond_4

    if-eqz v4, :cond_4

    .line 103
    sub-long v5, p3, p1

    invoke-static {v5, v6}, Ljava/lang/Math;->abs(J)J

    move-result-wide v5

    sub-long v9, p5, p1

    invoke-static {v9, v10}, Ljava/lang/Math;->abs(J)J

    move-result-wide v9

    cmp-long v5, v5, v9

    if-gtz v5, :cond_3

    .line 104
    return-wide p3

    .line 106
    :cond_3
    return-wide p5

    .line 108
    :cond_4
    if-eqz v3, :cond_5

    .line 109
    return-wide p3

    .line 110
    :cond_5
    if-eqz v4, :cond_6

    .line 111
    return-wide p5

    .line 113
    :cond_6
    return-wide v7
.end method
