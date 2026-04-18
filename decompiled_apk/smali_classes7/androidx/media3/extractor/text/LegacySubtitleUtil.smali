.class public Landroidx/media3/extractor/text/LegacySubtitleUtil;
.super Ljava/lang/Object;
.source "LegacySubtitleUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getStartIndex(Landroidx/media3/extractor/text/Subtitle;Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;)I
    .locals 5
    .param p0, "subtitle"    # Landroidx/media3/extractor/text/Subtitle;
    .param p1, "outputOptions"    # Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;

    .line 75
    iget-wide v0, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 76
    const/4 v0, 0x0

    return v0

    .line 78
    :cond_0
    iget-wide v0, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    invoke-interface {p0, v0, v1}, Landroidx/media3/extractor/text/Subtitle;->getNextEventTimeIndex(J)I

    move-result v0

    .line 79
    .local v0, "nextEventTimeIndex":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 80
    invoke-interface {p0}, Landroidx/media3/extractor/text/Subtitle;->getEventTimeCount()I

    move-result v1

    return v1

    .line 82
    :cond_1
    if-lez v0, :cond_2

    add-int/lit8 v1, v0, -0x1

    .line 83
    invoke-interface {p0, v1}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v1

    iget-wide v3, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    cmp-long v1, v1, v3

    if-nez v1, :cond_2

    .line 84
    add-int/lit8 v0, v0, -0x1

    .line 86
    :cond_2
    return v0
.end method

.method private static outputSubtitleEvent(Landroidx/media3/extractor/text/Subtitle;ILandroidx/media3/common/util/Consumer;)V
    .locals 12
    .param p0, "subtitle"    # Landroidx/media3/extractor/text/Subtitle;
    .param p1, "eventIndex"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/text/Subtitle;",
            "I",
            "Landroidx/media3/common/util/Consumer<",
            "Landroidx/media3/extractor/text/CuesWithTiming;",
            ">;)V"
        }
    .end annotation

    .line 91
    .local p2, "output":Landroidx/media3/common/util/Consumer;, "Landroidx/media3/common/util/Consumer<Landroidx/media3/extractor/text/CuesWithTiming;>;"
    invoke-interface {p0, p1}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v6

    .line 92
    .local v6, "startTimeUs":J
    invoke-interface {p0, v6, v7}, Landroidx/media3/extractor/text/Subtitle;->getCues(J)Ljava/util/List;

    move-result-object v8

    .line 93
    .local v8, "cuesForThisStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    invoke-interface {v8}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    return-void

    .line 97
    :cond_0
    invoke-interface {p0}, Landroidx/media3/extractor/text/Subtitle;->getEventTimeCount()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-eq p1, v0, :cond_2

    .line 103
    add-int/lit8 v0, p1, 0x1

    invoke-interface {p0, v0}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v0

    invoke-interface {p0, p1}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v2

    sub-long v9, v0, v2

    .line 104
    .local v9, "durationUs":J
    const-wide/16 v0, 0x0

    cmp-long v0, v9, v0

    if-lez v0, :cond_1

    .line 105
    new-instance v11, Landroidx/media3/extractor/text/CuesWithTiming;

    move-object v0, v11

    move-object v1, v8

    move-wide v2, v6

    move-wide v4, v9

    invoke-direct/range {v0 .. v5}, Landroidx/media3/extractor/text/CuesWithTiming;-><init>(Ljava/util/List;JJ)V

    invoke-interface {p2, v11}, Landroidx/media3/common/util/Consumer;->accept(Ljava/lang/Object;)V

    .line 107
    :cond_1
    return-void

    .line 99
    .end local v9    # "durationUs":J
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0
.end method

.method public static toCuesWithTiming(Landroidx/media3/extractor/text/Subtitle;Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;Landroidx/media3/common/util/Consumer;)V
    .locals 12
    .param p0, "subtitle"    # Landroidx/media3/extractor/text/Subtitle;
    .param p1, "outputOptions"    # Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/text/Subtitle;",
            "Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;",
            "Landroidx/media3/common/util/Consumer<",
            "Landroidx/media3/extractor/text/CuesWithTiming;",
            ">;)V"
        }
    .end annotation

    .line 40
    .local p2, "output":Landroidx/media3/common/util/Consumer;, "Landroidx/media3/common/util/Consumer<Landroidx/media3/extractor/text/CuesWithTiming;>;"
    invoke-static {p0, p1}, Landroidx/media3/extractor/text/LegacySubtitleUtil;->getStartIndex(Landroidx/media3/extractor/text/Subtitle;Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;)I

    move-result v0

    .line 41
    .local v0, "startIndex":I
    const/4 v1, 0x0

    .line 42
    .local v1, "startedInMiddleOfCue":Z
    iget-wide v2, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    const-wide v4, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 43
    iget-wide v2, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    invoke-interface {p0, v2, v3}, Landroidx/media3/extractor/text/Subtitle;->getCues(J)Ljava/util/List;

    move-result-object v2

    .line 44
    .local v2, "cuesAtStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    invoke-interface {p0, v0}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v10

    .line 45
    .local v10, "firstEventTimeUs":J
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 46
    invoke-interface {p0}, Landroidx/media3/extractor/text/Subtitle;->getEventTimeCount()I

    move-result v3

    if-ge v0, v3, :cond_0

    iget-wide v3, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    cmp-long v3, v3, v10

    if-gez v3, :cond_0

    .line 48
    new-instance v3, Landroidx/media3/extractor/text/CuesWithTiming;

    iget-wide v6, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    iget-wide v4, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    sub-long v8, v10, v4

    move-object v4, v3

    move-object v5, v2

    invoke-direct/range {v4 .. v9}, Landroidx/media3/extractor/text/CuesWithTiming;-><init>(Ljava/util/List;JJ)V

    invoke-interface {p2, v3}, Landroidx/media3/common/util/Consumer;->accept(Ljava/lang/Object;)V

    .line 53
    const/4 v1, 0x1

    .line 56
    .end local v2    # "cuesAtStartTime":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    .end local v10    # "firstEventTimeUs":J
    :cond_0
    move v2, v0

    .local v2, "i":I
    :goto_0
    invoke-interface {p0}, Landroidx/media3/extractor/text/Subtitle;->getEventTimeCount()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 57
    invoke-static {p0, v2, p2}, Landroidx/media3/extractor/text/LegacySubtitleUtil;->outputSubtitleEvent(Landroidx/media3/extractor/text/Subtitle;ILandroidx/media3/common/util/Consumer;)V

    .line 56
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 59
    .end local v2    # "i":I
    :cond_1
    iget-boolean v2, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->outputAllCues:Z

    if-eqz v2, :cond_4

    .line 60
    if-eqz v1, :cond_2

    add-int/lit8 v2, v0, -0x1

    goto :goto_1

    :cond_2
    move v2, v0

    .line 61
    .local v2, "endIndex":I
    :goto_1
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_2
    if-ge v3, v2, :cond_3

    .line 62
    invoke-static {p0, v3, p2}, Landroidx/media3/extractor/text/LegacySubtitleUtil;->outputSubtitleEvent(Landroidx/media3/extractor/text/Subtitle;ILandroidx/media3/common/util/Consumer;)V

    .line 61
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 64
    .end local v3    # "i":I
    :cond_3
    if-eqz v1, :cond_4

    .line 65
    new-instance v3, Landroidx/media3/extractor/text/CuesWithTiming;

    iget-wide v4, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    .line 67
    invoke-interface {p0, v4, v5}, Landroidx/media3/extractor/text/Subtitle;->getCues(J)Ljava/util/List;

    move-result-object v5

    .line 68
    invoke-interface {p0, v2}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v6

    iget-wide v8, p1, Landroidx/media3/extractor/text/SubtitleParser$OutputOptions;->startTimeUs:J

    .line 69
    invoke-interface {p0, v2}, Landroidx/media3/extractor/text/Subtitle;->getEventTime(I)J

    move-result-wide v10

    sub-long/2addr v8, v10

    move-object v4, v3

    invoke-direct/range {v4 .. v9}, Landroidx/media3/extractor/text/CuesWithTiming;-><init>(Ljava/util/List;JJ)V

    .line 65
    invoke-interface {p2, v3}, Landroidx/media3/common/util/Consumer;->accept(Ljava/lang/Object;)V

    .line 72
    .end local v2    # "endIndex":I
    :cond_4
    return-void
.end method
