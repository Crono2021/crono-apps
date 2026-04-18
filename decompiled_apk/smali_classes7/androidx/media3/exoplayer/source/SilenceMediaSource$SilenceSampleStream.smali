.class final Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;
.super Ljava/lang/Object;
.source "SilenceMediaSource.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/SampleStream;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/SilenceMediaSource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SilenceSampleStream"
.end annotation


# instance fields
.field private final durationBytes:J

.field private positionBytes:J

.field private sentFormat:Z


# direct methods
.method public constructor <init>(J)V
    .locals 2
    .param p1, "durationUs"    # J

    .line 285
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 286
    invoke-static {p1, p2}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$300(J)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->durationBytes:J

    .line 287
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->seekTo(J)V

    .line 288
    return-void
.end method


# virtual methods
.method public isReady()Z
    .locals 1

    .line 296
    const/4 v0, 0x1

    return v0
.end method

.method public maybeThrowError()V
    .locals 0

    .line 300
    return-void
.end method

.method public readData(Landroidx/media3/exoplayer/FormatHolder;Landroidx/media3/decoder/DecoderInputBuffer;I)I
    .locals 9
    .param p1, "formatHolder"    # Landroidx/media3/exoplayer/FormatHolder;
    .param p2, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p3, "readFlags"    # I

    .line 305
    iget-boolean v0, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->sentFormat:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_4

    and-int/lit8 v0, p3, 0x2

    if-eqz v0, :cond_0

    goto :goto_0

    .line 311
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->durationBytes:J

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    sub-long/2addr v2, v4

    .line 312
    .local v2, "bytesRemaining":J
    const-wide/16 v6, 0x0

    cmp-long v0, v2, v6

    const/4 v6, -0x4

    if-nez v0, :cond_1

    .line 313
    const/4 v0, 0x4

    invoke-virtual {p2, v0}, Landroidx/media3/decoder/DecoderInputBuffer;->addFlag(I)V

    .line 314
    return v6

    .line 317
    :cond_1
    invoke-static {v4, v5}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$400(J)J

    move-result-wide v4

    iput-wide v4, p2, Landroidx/media3/decoder/DecoderInputBuffer;->timeUs:J

    .line 318
    invoke-virtual {p2, v1}, Landroidx/media3/decoder/DecoderInputBuffer;->addFlag(I)V

    .line 319
    invoke-static {}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$500()[B

    move-result-object v0

    array-length v0, v0

    int-to-long v0, v0

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    long-to-int v0, v0

    .line 320
    .local v0, "bytesToWrite":I
    and-int/lit8 v1, p3, 0x4

    if-nez v1, :cond_2

    .line 321
    invoke-virtual {p2, v0}, Landroidx/media3/decoder/DecoderInputBuffer;->ensureSpaceForWrite(I)V

    .line 322
    iget-object v1, p2, Landroidx/media3/decoder/DecoderInputBuffer;->data:Ljava/nio/ByteBuffer;

    invoke-static {}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$500()[B

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v1, v4, v5, v0}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    .line 324
    :cond_2
    and-int/lit8 v1, p3, 0x1

    if-nez v1, :cond_3

    .line 325
    iget-wide v4, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    int-to-long v7, v0

    add-long/2addr v4, v7

    iput-wide v4, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    .line 327
    :cond_3
    return v6

    .line 306
    .end local v0    # "bytesToWrite":I
    .end local v2    # "bytesRemaining":J
    :cond_4
    :goto_0
    invoke-static {}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$200()Landroidx/media3/common/Format;

    move-result-object v0

    iput-object v0, p1, Landroidx/media3/exoplayer/FormatHolder;->format:Landroidx/media3/common/Format;

    .line 307
    iput-boolean v1, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->sentFormat:Z

    .line 308
    const/4 v0, -0x5

    return v0
.end method

.method public seekTo(J)V
    .locals 6
    .param p1, "positionUs"    # J

    .line 291
    invoke-static {p1, p2}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$300(J)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    iget-wide v4, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->durationBytes:J

    invoke-static/range {v0 .. v5}, Landroidx/media3/common/util/Util;->constrainValue(JJJ)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    .line 292
    return-void
.end method

.method public skipData(J)I
    .locals 6
    .param p1, "positionUs"    # J

    .line 332
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    .line 333
    .local v0, "oldPositionBytes":J
    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->seekTo(J)V

    .line 334
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;->positionBytes:J

    sub-long/2addr v2, v0

    invoke-static {}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->access$500()[B

    move-result-object v4

    array-length v4, v4

    int-to-long v4, v4

    div-long/2addr v2, v4

    long-to-int v2, v2

    return v2
.end method
