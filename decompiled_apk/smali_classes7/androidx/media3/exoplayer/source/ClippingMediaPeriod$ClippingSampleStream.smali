.class final Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;
.super Ljava/lang/Object;
.source "ClippingMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/SampleStream;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/ClippingMediaPeriod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "ClippingSampleStream"
.end annotation


# instance fields
.field public final childStream:Landroidx/media3/exoplayer/source/SampleStream;

.field private sentEos:Z

.field final synthetic this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/source/ClippingMediaPeriod;Landroidx/media3/exoplayer/source/SampleStream;)V
    .locals 0
    .param p2, "childStream"    # Landroidx/media3/exoplayer/source/SampleStream;

    .line 310
    iput-object p1, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 311
    iput-object p2, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    .line 312
    return-void
.end method


# virtual methods
.method public clearSentEos()V
    .locals 1

    .line 315
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->sentEos:Z

    .line 316
    return-void
.end method

.method public isReady()Z
    .locals 1

    .line 320
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->isPendingInitialDiscontinuity()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/SampleStream;->isReady()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public maybeThrowError()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 325
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    invoke-interface {v0}, Landroidx/media3/exoplayer/source/SampleStream;->maybeThrowError()V

    .line 326
    return-void
.end method

.method public readData(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;I)I
    .locals 15
    .param p1, "formatHolder"    # Landroidx/media3/exoplayer/FormatHolder;
    .param p2, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p3, "readFlags"    # I

    .line 331
    move-object v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    iget-object v3, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    invoke-virtual {v3}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->isPendingInitialDiscontinuity()Z

    move-result v3

    const/4 v4, -0x3

    if-eqz v3, :cond_0

    .line 332
    return v4

    .line 334
    :cond_0
    iget-boolean v3, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->sentEos:Z

    const/4 v5, 0x4

    const/4 v6, -0x4

    if-eqz v3, :cond_1

    .line 335
    invoke-virtual {v2, v5}, Landroidx/media3/decoder/DecoderInputBuffer;->setFlags(I)V

    .line 336
    return v6

    .line 338
    :cond_1
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    invoke-virtual {v3}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->getBufferedPositionUs()J

    move-result-wide v7

    .line 339
    .local v7, "bufferedPositionUs":J
    iget-object v3, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    move/from16 v9, p3

    invoke-interface {v3, v1, v2, v9}, Landroidx/media3/exoplayer/source/SampleStream;->readData(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;I)I

    move-result v3

    .line 340
    .local v3, "result":I
    const/4 v10, -0x5

    const-wide/high16 v11, -0x8000000000000000L

    if-ne v3, v10, :cond_6

    .line 341
    iget-object v4, v1, Landroidx/media3/exoplayer/FormatHolder;->format:Landroidx/media3/common/Format;

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/Format;

    .line 342
    .local v4, "format":Landroidx/media3/common/Format;
    iget v5, v4, Landroidx/media3/common/Format;->encoderDelay:I

    if-nez v5, :cond_2

    iget v5, v4, Landroidx/media3/common/Format;->encoderPadding:I

    if-eqz v5, :cond_5

    .line 344
    :cond_2
    iget-object v5, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    iget-wide v5, v5, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->startUs:J

    const-wide/16 v13, 0x0

    cmp-long v5, v5, v13

    const/4 v6, 0x0

    if-eqz v5, :cond_3

    move v5, v6

    goto :goto_0

    :cond_3
    iget v5, v4, Landroidx/media3/common/Format;->encoderDelay:I

    .line 345
    .local v5, "encoderDelay":I
    :goto_0
    iget-object v13, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    iget-wide v13, v13, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    cmp-long v11, v13, v11

    if-eqz v11, :cond_4

    goto :goto_1

    :cond_4
    iget v6, v4, Landroidx/media3/common/Format;->encoderPadding:I

    .line 346
    .local v6, "encoderPadding":I
    :goto_1
    nop

    .line 348
    invoke-virtual {v4}, Landroidx/media3/common/Format;->buildUpon()Landroidx/media3/common/Format$Builder;

    move-result-object v11

    .line 349
    invoke-virtual {v11, v5}, Landroidx/media3/common/Format$Builder;->setEncoderDelay(I)Landroidx/media3/common/Format$Builder;

    move-result-object v11

    .line 350
    invoke-virtual {v11, v6}, Landroidx/media3/common/Format$Builder;->setEncoderPadding(I)Landroidx/media3/common/Format$Builder;

    move-result-object v11

    .line 351
    invoke-virtual {v11}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v11

    iput-object v11, v1, Landroidx/media3/exoplayer/FormatHolder;->format:Landroidx/media3/common/Format;

    .line 353
    .end local v5    # "encoderDelay":I
    .end local v6    # "encoderPadding":I
    :cond_5
    return v10

    .line 355
    .end local v4    # "format":Landroidx/media3/common/Format;
    :cond_6
    iget-object v10, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    iget-wide v13, v10, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    cmp-long v10, v13, v11

    if-eqz v10, :cond_9

    if-ne v3, v6, :cond_7

    iget-wide v13, v2, Landroidx/media3/decoder/DecoderInputBuffer;->timeUs:J

    iget-object v10, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    iget-wide v5, v10, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->endUs:J

    cmp-long v5, v13, v5

    if-gez v5, :cond_8

    :cond_7
    if-ne v3, v4, :cond_9

    cmp-long v4, v7, v11

    if-nez v4, :cond_9

    iget-boolean v4, v2, Landroidx/media3/decoder/DecoderInputBuffer;->waitingForKeys:Z

    if-nez v4, :cond_9

    .line 360
    :cond_8
    invoke-virtual/range {p2 .. p2}, Landroidx/media3/decoder/DecoderInputBuffer;->clear()V

    .line 361
    const/4 v4, 0x4

    invoke-virtual {v2, v4}, Landroidx/media3/decoder/DecoderInputBuffer;->setFlags(I)V

    .line 362
    const/4 v4, 0x1

    iput-boolean v4, v0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->sentEos:Z

    .line 363
    const/4 v4, -0x4

    return v4

    .line 365
    :cond_9
    return v3
.end method

.method public skipData(J)I
    .locals 1
    .param p1, "positionUs"    # J

    .line 370
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->this$0:Landroidx/media3/exoplayer/source/ClippingMediaPeriod;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/ClippingMediaPeriod;->isPendingInitialDiscontinuity()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 371
    const/4 v0, -0x3

    return v0

    .line 373
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/ClippingMediaPeriod$ClippingSampleStream;->childStream:Landroidx/media3/exoplayer/source/SampleStream;

    invoke-interface {v0, p1, p2}, Landroidx/media3/exoplayer/source/SampleStream;->skipData(J)I

    move-result v0

    return v0
.end method
