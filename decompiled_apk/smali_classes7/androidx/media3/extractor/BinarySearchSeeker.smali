.class public abstract Landroidx/media3/extractor/BinarySearchSeeker;
.super Ljava/lang/Object;
.source "BinarySearchSeeker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;,
        Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;,
        Landroidx/media3/extractor/BinarySearchSeeker$SeekTimestampConverter;,
        Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;,
        Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;,
        Landroidx/media3/extractor/BinarySearchSeeker$DefaultSeekTimestampConverter;
    }
.end annotation


# static fields
.field private static final MAX_SKIP_BYTES:J = 0x40000L


# instance fields
.field private final minimumSearchRange:I

.field protected final seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

.field protected seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

.field protected final timestampSeeker:Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;


# direct methods
.method protected constructor <init>(Landroidx/media3/extractor/BinarySearchSeeker$SeekTimestampConverter;Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;JJJJJJI)V
    .locals 17
    .param p1, "seekTimestampConverter"    # Landroidx/media3/extractor/BinarySearchSeeker$SeekTimestampConverter;
    .param p2, "timestampSeeker"    # Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;
    .param p3, "durationUs"    # J
    .param p5, "floorTimePosition"    # J
    .param p7, "ceilingTimePosition"    # J
    .param p9, "floorBytePosition"    # J
    .param p11, "ceilingBytePosition"    # J
    .param p13, "approxBytesPerFrame"    # J
    .param p15, "minimumSearchRange"    # I

    .line 131
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 132
    move-object/from16 v1, p2

    iput-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->timestampSeeker:Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;

    .line 133
    move/from16 v2, p15

    iput v2, v0, Landroidx/media3/extractor/BinarySearchSeeker;->minimumSearchRange:I

    .line 134
    new-instance v15, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    move-object v3, v15

    move-object/from16 v4, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-wide/from16 v9, p7

    move-wide/from16 v11, p9

    move-wide/from16 v13, p11

    move-object v1, v15

    move-wide/from16 v15, p13

    invoke-direct/range {v3 .. v16}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;-><init>(Landroidx/media3/extractor/BinarySearchSeeker$SeekTimestampConverter;JJJJJJ)V

    iput-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 143
    return-void
.end method


# virtual methods
.method protected createSeekParamsForTargetTimeUs(J)Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;
    .locals 19
    .param p1, "timeUs"    # J

    .line 226
    move-object/from16 v0, p0

    new-instance v16, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 228
    move-wide/from16 v14, p1

    invoke-virtual {v1, v14, v15}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->timeUsToTargetTime(J)J

    move-result-wide v4

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 229
    invoke-static {v1}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->access$1000(Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;)J

    move-result-wide v6

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 230
    invoke-static {v1}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->access$1100(Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;)J

    move-result-wide v8

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 231
    invoke-static {v1}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->access$1200(Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;)J

    move-result-wide v10

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 232
    invoke-static {v1}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->access$1300(Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;)J

    move-result-wide v12

    iget-object v1, v0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    .line 233
    invoke-static {v1}, Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;->access$1400(Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;)J

    move-result-wide v17

    move-object/from16 v1, v16

    move-wide/from16 v2, p1

    move-wide/from16 v14, v17

    invoke-direct/range {v1 .. v15}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;-><init>(JJJJJJJ)V

    .line 226
    return-object v16
.end method

.method public final getSeekMap()Landroidx/media3/extractor/SeekMap;
    .locals 1

    .line 147
    iget-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekMap:Landroidx/media3/extractor/BinarySearchSeeker$BinarySearchSeekMap;

    return-object v0
.end method

.method public handlePendingSeek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 12
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPositionHolder"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 180
    nop

    :goto_0
    iget-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    .line 181
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    .line 182
    .local v0, "seekOperationParams":Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;
    invoke-static {v0}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$100(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;)J

    move-result-wide v1

    .line 183
    .local v1, "floorPosition":J
    invoke-static {v0}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$200(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;)J

    move-result-wide v3

    .line 184
    .local v3, "ceilingPosition":J
    invoke-static {v0}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$300(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;)J

    move-result-wide v5

    .line 186
    .local v5, "searchPosition":J
    sub-long v7, v3, v1

    iget v9, p0, Landroidx/media3/extractor/BinarySearchSeeker;->minimumSearchRange:I

    int-to-long v9, v9

    cmp-long v7, v7, v9

    const/4 v8, 0x0

    if-gtz v7, :cond_0

    .line 188
    invoke-virtual {p0, v8, v1, v2}, Landroidx/media3/extractor/BinarySearchSeeker;->markSeekOperationFinished(ZJ)V

    .line 189
    invoke-virtual {p0, p1, v1, v2, p2}, Landroidx/media3/extractor/BinarySearchSeeker;->seekToPosition(Landroidx/media3/extractor/ExtractorInput;JLandroidx/media3/extractor/PositionHolder;)I

    move-result v7

    return v7

    .line 191
    :cond_0
    invoke-virtual {p0, p1, v5, v6}, Landroidx/media3/extractor/BinarySearchSeeker;->skipInputUntilPosition(Landroidx/media3/extractor/ExtractorInput;J)Z

    move-result v7

    if-nez v7, :cond_1

    .line 192
    invoke-virtual {p0, p1, v5, v6, p2}, Landroidx/media3/extractor/BinarySearchSeeker;->seekToPosition(Landroidx/media3/extractor/ExtractorInput;JLandroidx/media3/extractor/PositionHolder;)I

    move-result v7

    return v7

    .line 195
    :cond_1
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 196
    iget-object v7, p0, Landroidx/media3/extractor/BinarySearchSeeker;->timestampSeeker:Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;

    .line 197
    invoke-static {v0}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$400(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;)J

    move-result-wide v9

    invoke-interface {v7, p1, v9, v10}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;->searchForTimestamp(Landroidx/media3/extractor/ExtractorInput;J)Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;

    move-result-object v7

    .line 199
    .local v7, "timestampSearchResult":Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$500(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)I

    move-result v9

    packed-switch v9, :pswitch_data_0

    .line 220
    new-instance v8, Ljava/lang/IllegalStateException;

    const-string v9, "Invalid case"

    invoke-direct {v8, v9}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 209
    :pswitch_0
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$700(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v8

    invoke-virtual {p0, p1, v8, v9}, Landroidx/media3/extractor/BinarySearchSeeker;->skipInputUntilPosition(Landroidx/media3/extractor/ExtractorInput;J)Z

    .line 210
    nop

    .line 211
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$700(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v8

    .line 210
    const/4 v10, 0x1

    invoke-virtual {p0, v10, v8, v9}, Landroidx/media3/extractor/BinarySearchSeeker;->markSeekOperationFinished(ZJ)V

    .line 212
    nop

    .line 213
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$700(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v8

    .line 212
    invoke-virtual {p0, p1, v8, v9, p2}, Landroidx/media3/extractor/BinarySearchSeeker;->seekToPosition(Landroidx/media3/extractor/ExtractorInput;JLandroidx/media3/extractor/PositionHolder;)I

    move-result v8

    return v8

    .line 201
    :pswitch_1
    nop

    .line 202
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$600(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v8

    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$700(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v10

    .line 201
    invoke-static {v0, v8, v9, v10, v11}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$800(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;JJ)V

    .line 203
    goto :goto_1

    .line 205
    :pswitch_2
    nop

    .line 206
    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$600(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v8

    invoke-static {v7}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;->access$700(Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;)J

    move-result-wide v10

    .line 205
    invoke-static {v0, v8, v9, v10, v11}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$900(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;JJ)V

    .line 207
    nop

    .line 222
    .end local v0    # "seekOperationParams":Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;
    .end local v1    # "floorPosition":J
    .end local v3    # "ceilingPosition":J
    .end local v5    # "searchPosition":J
    .end local v7    # "timestampSearchResult":Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;
    :goto_1
    goto/16 :goto_0

    .line 217
    .restart local v0    # "seekOperationParams":Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;
    .restart local v1    # "floorPosition":J
    .restart local v3    # "ceilingPosition":J
    .restart local v5    # "searchPosition":J
    .restart local v7    # "timestampSearchResult":Landroidx/media3/extractor/BinarySearchSeeker$TimestampSearchResult;
    :pswitch_3
    invoke-virtual {p0, v8, v5, v6}, Landroidx/media3/extractor/BinarySearchSeeker;->markSeekOperationFinished(ZJ)V

    .line 218
    invoke-virtual {p0, p1, v5, v6, p2}, Landroidx/media3/extractor/BinarySearchSeeker;->seekToPosition(Landroidx/media3/extractor/ExtractorInput;JLandroidx/media3/extractor/PositionHolder;)I

    move-result v8

    return v8

    :pswitch_data_0
    .packed-switch -0x3
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final isSeeking()Z
    .locals 1

    .line 164
    iget-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected final markSeekOperationFinished(ZJ)V
    .locals 1
    .param p1, "foundTargetFrame"    # Z
    .param p2, "resultPosition"    # J

    .line 237
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    .line 238
    iget-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->timestampSeeker:Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;

    invoke-interface {v0}, Landroidx/media3/extractor/BinarySearchSeeker$TimestampSeeker;->onSeekFinished()V

    .line 239
    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/extractor/BinarySearchSeeker;->onSeekOperationFinished(ZJ)V

    .line 240
    return-void
.end method

.method protected onSeekOperationFinished(ZJ)V
    .locals 0
    .param p1, "foundTargetFrame"    # Z
    .param p2, "resultPosition"    # J

    .line 244
    return-void
.end method

.method protected final seekToPosition(Landroidx/media3/extractor/ExtractorInput;JLandroidx/media3/extractor/PositionHolder;)I
    .locals 2
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "position"    # J
    .param p4, "seekPositionHolder"    # Landroidx/media3/extractor/PositionHolder;

    .line 258
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    cmp-long v0, p2, v0

    if-nez v0, :cond_0

    .line 259
    const/4 v0, 0x0

    return v0

    .line 261
    :cond_0
    iput-wide p2, p4, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 262
    const/4 v0, 0x1

    return v0
.end method

.method public final setSeekTargetUs(J)V
    .locals 2
    .param p1, "timeUs"    # J

    .line 156
    iget-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    if-eqz v0, :cond_0

    invoke-static {v0}, Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;->access$000(Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;)J

    move-result-wide v0

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 157
    return-void

    .line 159
    :cond_0
    invoke-virtual {p0, p1, p2}, Landroidx/media3/extractor/BinarySearchSeeker;->createSeekParamsForTargetTimeUs(J)Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/BinarySearchSeeker;->seekOperationParams:Landroidx/media3/extractor/BinarySearchSeeker$SeekOperationParams;

    .line 160
    return-void
.end method

.method protected final skipInputUntilPosition(Landroidx/media3/extractor/ExtractorInput;J)Z
    .locals 4
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "position"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 248
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    sub-long v0, p2, v0

    .line 249
    .local v0, "bytesToSkip":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-ltz v2, :cond_0

    const-wide/32 v2, 0x40000

    cmp-long v2, v0, v2

    if-gtz v2, :cond_0

    .line 250
    long-to-int v2, v0

    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 251
    const/4 v2, 0x1

    return v2

    .line 253
    :cond_0
    const/4 v2, 0x0

    return v2
.end method
