.class public final Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;
.super Landroidx/media3/common/audio/BaseAudioProcessor;
.source "SilenceSkippingAudioProcessor.java"


# static fields
.field private static final AVOID_TRUNCATION_FACTOR:I = 0x3e8

.field public static final DEFAULT_MAX_SILENCE_TO_KEEP_DURATION_US:J = 0x1e8480L

.field public static final DEFAULT_MINIMUM_SILENCE_DURATION_US:J = 0x186a0L

.field public static final DEFAULT_MIN_VOLUME_TO_KEEP_PERCENTAGE:I = 0xa

.field public static final DEFAULT_PADDING_SILENCE_US:J = 0x4e20L
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final DEFAULT_SILENCE_RETENTION_RATIO:F = 0.2f

.field public static final DEFAULT_SILENCE_THRESHOLD_LEVEL:S = 0x400s

.field private static final DO_NOT_CHANGE_VOLUME:I = 0x3

.field private static final FADE_IN:I = 0x2

.field private static final FADE_OUT:I = 0x0

.field private static final MUTE:I = 0x1

.field private static final STATE_NOISY:I = 0x0

.field private static final STATE_SHORTENING_SILENCE:I = 0x1


# instance fields
.field private bytesPerFrame:I

.field private contiguousOutputBuffer:[B

.field private enabled:Z

.field private inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

.field private final maxSilenceToKeepDurationUs:J

.field private maybeSilenceBuffer:[B

.field private maybeSilenceBufferContentsSize:I

.field private maybeSilenceBufferStartIndex:I

.field private final minVolumeToKeepPercentageWhenMuting:I

.field private final minimumSilenceDurationUs:J

.field private outputSilenceFramesSinceNoise:I

.field private final silenceRetentionRatio:F

.field private final silenceThresholdLevel:S

.field private skippedFrames:J

.field private state:I


# direct methods
.method public constructor <init>()V
    .locals 8

    .line 189
    const-wide/32 v1, 0x186a0

    const v3, 0x3e4ccccd    # 0.2f

    const-wide/32 v4, 0x1e8480

    const/16 v6, 0xa

    const/16 v7, 0x400

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;-><init>(JFJIS)V

    .line 195
    return-void
.end method

.method public constructor <init>(JFJIS)V
    .locals 2
    .param p1, "minimumSilenceDurationUs"    # J
    .param p3, "silenceRetentionRatio"    # F
    .param p4, "maxSilenceToKeepDurationUs"    # J
    .param p6, "minVolumeToKeepPercentageWhenMuting"    # I
    .param p7, "silenceThresholdLevel"    # S

    .line 232
    invoke-direct {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;-><init>()V

    .line 159
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    .line 173
    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    .line 180
    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 233
    const/4 v1, 0x0

    cmpl-float v1, p3, v1

    if-ltz v1, :cond_0

    const/high16 v1, 0x3f800000    # 1.0f

    cmpg-float v1, p3, v1

    if-gtz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 234
    iput-wide p1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minimumSilenceDurationUs:J

    .line 235
    iput p3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->silenceRetentionRatio:F

    .line 236
    iput-wide p4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maxSilenceToKeepDurationUs:J

    .line 237
    iput p6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minVolumeToKeepPercentageWhenMuting:I

    .line 238
    iput-short p7, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->silenceThresholdLevel:S

    .line 239
    sget-object v0, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 240
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    .line 241
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    .line 242
    return-void
.end method

.method public constructor <init>(JJS)V
    .locals 10
    .param p1, "minimumSilenceDurationUs"    # J
    .param p3, "paddingSilenceUs"    # J
    .param p5, "silenceThresholdLevel"    # S
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 203
    long-to-float v0, p3

    long-to-float v1, p1

    div-float v5, v0, v1

    const/4 v8, 0x0

    move-object v2, p0

    move-wide v3, p1

    move-wide v6, p1

    move v9, p5

    invoke-direct/range {v2 .. v9}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;-><init>(JFJIS)V

    .line 209
    return-void
.end method

.method private alignToBytePerFrameBoundary(F)I
    .locals 1
    .param p1, "value"    # F

    .line 532
    float-to-int v0, p1

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->alignToBytePerFrameBoundary(I)I

    move-result v0

    return v0
.end method

.method private alignToBytePerFrameBoundary(I)I
    .locals 2
    .param p1, "value"    # I

    .line 524
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    div-int v1, p1, v0

    mul-int/2addr v1, v0

    return v1
.end method

.method private calculateFadeInPercentage(II)I
    .locals 3
    .param p1, "value"    # I
    .param p2, "max"    # I

    .line 677
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minVolumeToKeepPercentageWhenMuting:I

    rsub-int/lit8 v1, v0, 0x64

    mul-int/lit16 v2, p1, 0x3e8

    mul-int/2addr v1, v2

    div-int/2addr v1, p2

    div-int/lit16 v1, v1, 0x3e8

    add-int/2addr v0, v1

    return v0
.end method

.method private calculateFadeOutPercentage(II)I
    .locals 2
    .param p1, "value"    # I
    .param p2, "max"    # I

    .line 671
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minVolumeToKeepPercentageWhenMuting:I

    add-int/lit8 v0, v0, -0x64

    mul-int/lit16 v1, p1, 0x3e8

    div-int/2addr v1, p2

    mul-int/2addr v0, v1

    div-int/lit16 v0, v0, 0x3e8

    add-int/lit8 v0, v0, 0x64

    return v0
.end method

.method private calculateShortenedSilenceLength(I)I
    .locals 3
    .param p1, "silenceToShortenBytes"    # I

    .line 508
    iget-wide v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maxSilenceToKeepDurationUs:J

    .line 509
    invoke-direct {p0, v0, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->durationUsToFrames(J)I

    move-result v0

    iget v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    sub-int/2addr v0, v1

    iget v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    mul-int/2addr v0, v1

    iget-object v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v1, v1

    div-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    .line 513
    .local v0, "bytesNeededToReachMax":I
    if-ltz v0, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 515
    int-to-float v1, p1

    iget v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->silenceRetentionRatio:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    int-to-float v2, v0

    .line 516
    invoke-static {v1, v2}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 515
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->alignToBytePerFrameBoundary(F)I

    move-result v1

    return v1
.end method

.method private durationUsToFrames(J)I
    .locals 4
    .param p1, "durationUs"    # J

    .line 714
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v0, v0, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->sampleRate:I

    int-to-long v0, v0

    mul-long/2addr v0, p1

    const-wide/32 v2, 0xf4240

    div-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method private findNoiseLimit(Ljava/nio/ByteBuffer;)I
    .locals 3
    .param p1, "buffer"    # Ljava/nio/ByteBuffer;

    .line 738
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    if-lt v0, v1, :cond_1

    .line 739
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {p1, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    invoke-direct {p0, v1, v2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->isNoise(BB)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 741
    iget v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    div-int v2, v0, v1

    mul-int/2addr v2, v1

    add-int/2addr v2, v1

    return v2

    .line 738
    :cond_0
    add-int/lit8 v0, v0, -0x2

    goto :goto_0

    .line 744
    .end local v0    # "i":I
    :cond_1
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    return v0
.end method

.method private findNoisePosition(Ljava/nio/ByteBuffer;)I
    .locals 3
    .param p1, "buffer"    # Ljava/nio/ByteBuffer;

    .line 723
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 724
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {p1, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    invoke-direct {p0, v1, v2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->isNoise(BB)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 726
    iget v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    div-int v2, v0, v1

    mul-int/2addr v1, v2

    return v1

    .line 723
    :cond_0
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 729
    .end local v0    # "i":I
    :cond_1
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    return v0
.end method

.method private isNoise(BB)Z
    .locals 2
    .param p1, "mostSignificantByte"    # B
    .param p2, "leastSignificantByte"    # B

    .line 752
    invoke-static {p1, p2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->twoByteSampleToInt(BB)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v0

    iget-short v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->silenceThresholdLevel:S

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private modifyVolume([BII)V
    .locals 6
    .param p1, "sampleBuffer"    # [B
    .param p2, "size"    # I
    .param p3, "volumeChangeType"    # I

    .line 645
    const/4 v0, 0x3

    if-ne p3, v0, :cond_0

    .line 646
    return-void

    .line 649
    :cond_0
    const/4 v0, 0x0

    .local v0, "idx":I
    :goto_0
    if-ge v0, p2, :cond_3

    .line 650
    add-int/lit8 v1, v0, 0x1

    aget-byte v1, p1, v1

    .line 651
    .local v1, "mostSignificantByte":B
    aget-byte v2, p1, v0

    .line 652
    .local v2, "leastSignificantByte":B
    invoke-static {v1, v2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->twoByteSampleToInt(BB)I

    move-result v3

    .line 655
    .local v3, "sample":I
    if-nez p3, :cond_1

    .line 656
    add-int/lit8 v4, p2, -0x1

    .line 657
    invoke-direct {p0, v0, v4}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->calculateFadeOutPercentage(II)I

    move-result v4

    .local v4, "volumeModificationPercentage":I
    goto :goto_1

    .line 658
    .end local v4    # "volumeModificationPercentage":I
    :cond_1
    const/4 v4, 0x2

    if-ne p3, v4, :cond_2

    .line 659
    add-int/lit8 v4, p2, -0x1

    .line 660
    invoke-direct {p0, v0, v4}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->calculateFadeInPercentage(II)I

    move-result v4

    .restart local v4    # "volumeModificationPercentage":I
    goto :goto_1

    .line 662
    .end local v4    # "volumeModificationPercentage":I
    :cond_2
    iget v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minVolumeToKeepPercentageWhenMuting:I

    .line 665
    .restart local v4    # "volumeModificationPercentage":I
    :goto_1
    mul-int v5, v3, v4

    div-int/lit8 v5, v5, 0x64

    .line 666
    .end local v3    # "sample":I
    .local v5, "sample":I
    invoke-static {p1, v0, v5}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->sampleIntToTwoBigEndianBytes([BII)V

    .line 649
    .end local v1    # "mostSignificantByte":B
    .end local v2    # "leastSignificantByte":B
    .end local v4    # "volumeModificationPercentage":I
    .end local v5    # "sample":I
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 668
    .end local v0    # "idx":I
    :cond_3
    return-void
.end method

.method private output(Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p1, "data"    # Ljava/nio/ByteBuffer;

    .line 707
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 708
    return-void
.end method

.method private outputRange([BII)V
    .locals 4
    .param p1, "data"    # [B
    .param p2, "size"    # I
    .param p3, "rampType"    # I

    .line 537
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    rem-int v0, p2, v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    move v0, v1

    :goto_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "byteOutput size is not aligned to frame size "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 540
    invoke-direct {p0, p1, p2, p3}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->modifyVolume([BII)V

    .line 541
    invoke-virtual {p0, p2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0, p1, v1, p2}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 542
    return-void
.end method

.method private outputShortenedSilenceBuffer(Z)V
    .locals 10
    .param p1, "shouldTransitionToNoisyState"    # Z

    .line 433
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 438
    .local v0, "sizeBeforeOutput":I
    iget v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    iget-object v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v3, v2

    if-eq v1, v3, :cond_0

    if-eqz p1, :cond_7

    .line 440
    :cond_0
    iget v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    const/4 v4, 0x1

    const/4 v5, 0x0

    if-nez v3, :cond_3

    .line 443
    if-eqz p1, :cond_1

    .line 444
    const/4 v1, 0x3

    .line 445
    .local v1, "volumeChangeType":I
    iget v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 446
    .local v2, "bytesToOutput":I
    invoke-direct {p0, v2, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilence(II)V

    .line 447
    move v3, v2

    .local v3, "bytesConsumed":I
    goto :goto_1

    .line 449
    .end local v1    # "volumeChangeType":I
    .end local v2    # "bytesToOutput":I
    .end local v3    # "bytesConsumed":I
    :cond_1
    array-length v2, v2

    div-int/lit8 v2, v2, 0x2

    if-lt v1, v2, :cond_2

    move v1, v4

    goto :goto_0

    :cond_2
    move v1, v5

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 452
    const/4 v1, 0x0

    .line 453
    .restart local v1    # "volumeChangeType":I
    iget-object v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v2, v2

    div-int/lit8 v2, v2, 0x2

    .line 454
    .restart local v2    # "bytesToOutput":I
    invoke-direct {p0, v2, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilence(II)V

    .line 455
    move v3, v2

    .restart local v3    # "bytesConsumed":I
    goto :goto_1

    .line 457
    .end local v1    # "volumeChangeType":I
    .end local v2    # "bytesToOutput":I
    .end local v3    # "bytesConsumed":I
    :cond_3
    if-eqz p1, :cond_4

    .line 458
    const/4 v3, 0x2

    .line 460
    .local v3, "volumeChangeType":I
    array-length v6, v2

    div-int/lit8 v6, v6, 0x2

    sub-int/2addr v1, v6

    .line 463
    .local v1, "bytesRemainingAfterOutputtingHalfMin":I
    array-length v2, v2

    div-int/lit8 v2, v2, 0x2

    add-int/2addr v2, v1

    .line 464
    .local v2, "bytesConsumed":I
    nop

    .line 465
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->calculateShortenedSilenceLength(I)I

    move-result v6

    .line 470
    .local v6, "shortenedSilenceLength":I
    iget-object v7, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v7, v7

    div-int/lit8 v7, v7, 0x2

    add-int/2addr v7, v6

    .line 471
    .local v7, "bytesToOutput":I
    invoke-direct {p0, v7, v3}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilence(II)V

    .line 472
    .end local v1    # "bytesRemainingAfterOutputtingHalfMin":I
    .end local v6    # "shortenedSilenceLength":I
    move v1, v3

    move v3, v2

    move v2, v7

    goto :goto_1

    .line 473
    .end local v2    # "bytesConsumed":I
    .end local v3    # "volumeChangeType":I
    .end local v7    # "bytesToOutput":I
    :cond_4
    const/4 v3, 0x1

    .line 476
    .restart local v3    # "volumeChangeType":I
    array-length v2, v2

    div-int/lit8 v2, v2, 0x2

    sub-int/2addr v1, v2

    .line 478
    .local v1, "bytesConsumed":I
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->calculateShortenedSilenceLength(I)I

    move-result v2

    .line 479
    .local v2, "bytesToOutput":I
    invoke-direct {p0, v2, v3}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilence(II)V

    move v9, v3

    move v3, v1

    move v1, v9

    .line 482
    .local v1, "volumeChangeType":I
    .local v3, "bytesConsumed":I
    :goto_1
    iget v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    rem-int v6, v3, v6

    if-nez v6, :cond_5

    move v6, v4

    goto :goto_2

    :cond_5
    move v6, v5

    :goto_2
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "bytesConsumed is not aligned to frame size: %s"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroidx/media3/common/util/Assertions;->checkState(ZLjava/lang/Object;)V

    .line 486
    if-lt v0, v2, :cond_6

    goto :goto_3

    :cond_6
    move v4, v5

    :goto_3
    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 488
    iget v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    sub-int/2addr v4, v3

    iput v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 489
    iget v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    add-int/2addr v4, v3

    iput v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    .line 491
    iget-object v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v5, v5

    rem-int/2addr v4, v5

    iput v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    .line 493
    iget v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    iget v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    div-int v6, v2, v5

    add-int/2addr v4, v6

    iput v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    .line 494
    iget-wide v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->skippedFrames:J

    sub-int v4, v3, v2

    div-int/2addr v4, v5

    int-to-long v4, v4

    add-long/2addr v6, v4

    iput-wide v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->skippedFrames:J

    .line 496
    .end local v1    # "volumeChangeType":I
    .end local v2    # "bytesToOutput":I
    .end local v3    # "bytesConsumed":I
    :cond_7
    return-void
.end method

.method private outputSilence(II)V
    .locals 8
    .param p1, "sizeToOutput"    # I
    .param p2, "rampType"    # I

    .line 555
    if-nez p1, :cond_0

    .line 556
    return-void

    .line 559
    :cond_0
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-lt v0, p1, :cond_1

    move v0, v1

    goto :goto_0

    :cond_1
    move v0, v2

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 561
    const/4 v0, 0x2

    if-ne p2, v0, :cond_4

    .line 563
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    iget v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    add-int v4, v0, v3

    iget-object v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v6, v5

    if-gt v4, v6, :cond_2

    .line 566
    add-int/2addr v0, v3

    sub-int/2addr v0, p1

    iget-object v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v5, v0, v3, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_2

    .line 574
    :cond_2
    array-length v4, v5

    sub-int/2addr v4, v0

    .line 575
    .local v4, "sizeInUpperPartOfArray":I
    sub-int/2addr v3, v4

    .line 576
    .local v3, "sizeInLowerPartOfArray":I
    if-lt v3, p1, :cond_3

    .line 578
    sub-int v0, v3, p1

    iget-object v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v5, v0, v6, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_1

    .line 585
    :cond_3
    sub-int v0, p1, v3

    .line 586
    .local v0, "sizeToOutputInUpperPart":I
    array-length v6, v5

    sub-int/2addr v6, v0

    iget-object v7, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v5, v6, v7, v2, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 595
    iget-object v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    iget-object v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v5, v2, v6, v0, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 602
    .end local v0    # "sizeToOutputInUpperPart":I
    .end local v3    # "sizeInLowerPartOfArray":I
    .end local v4    # "sizeInUpperPartOfArray":I
    :goto_1
    goto :goto_2

    .line 604
    :cond_4
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    add-int v3, v0, p1

    iget-object v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v5, v4

    if-gt v3, v5, :cond_5

    .line 606
    iget-object v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v4, v0, v3, v2, p1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_2

    .line 614
    :cond_5
    array-length v3, v4

    sub-int/2addr v3, v0

    .line 616
    .local v3, "sizeToCopyInUpperPartOfArray":I
    iget-object v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v4, v0, v5, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 622
    sub-int v0, p1, v3

    .line 623
    .local v0, "amountToCopyFromLowerPartOfArray":I
    iget-object v4, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    iget-object v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-static {v4, v2, v5, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 632
    .end local v0    # "amountToCopyFromLowerPartOfArray":I
    .end local v3    # "sizeToCopyInUpperPartOfArray":I
    :goto_2
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    rem-int v0, p1, v0

    if-nez v0, :cond_6

    move v0, v1

    goto :goto_3

    :cond_6
    move v0, v2

    :goto_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "sizeToOutput is not aligned to frame size: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 635
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    iget-object v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v3, v3

    if-ge v0, v3, :cond_7

    goto :goto_4

    :cond_7
    move v1, v2

    :goto_4
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 637
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    invoke-direct {p0, v0, p1, p2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputRange([BII)V

    .line 638
    return-void
.end method

.method private processNoisy(Ljava/nio/ByteBuffer;)V
    .locals 3
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 338
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    .line 341
    .local v0, "limit":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    iget-object v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v2, v2

    add-int/2addr v1, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    invoke-virtual {p1, v1}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 342
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->findNoiseLimit(Ljava/nio/ByteBuffer;)I

    move-result v1

    .line 343
    .local v1, "noiseLimit":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v2

    if-ne v1, v2, :cond_0

    .line 345
    const/4 v2, 0x1

    iput v2, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->state:I

    goto :goto_0

    .line 347
    :cond_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v2

    invoke-static {v1, v2}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-virtual {p1, v2}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 348
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->output(Ljava/nio/ByteBuffer;)V

    .line 352
    :goto_0
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 353
    return-void
.end method

.method private static sampleIntToTwoBigEndianBytes([BII)V
    .locals 2
    .param p0, "byteArray"    # [B
    .param p1, "startIndex"    # I
    .param p2, "sample"    # I

    .line 691
    const/16 v0, 0x7fff

    if-lt p2, v0, :cond_0

    .line 692
    const/4 v0, -0x1

    aput-byte v0, p0, p1

    .line 693
    add-int/lit8 v0, p1, 0x1

    const/16 v1, 0x7f

    aput-byte v1, p0, v0

    goto :goto_0

    .line 694
    :cond_0
    const/16 v0, -0x8000

    if-gt p2, v0, :cond_1

    .line 695
    const/4 v0, 0x0

    aput-byte v0, p0, p1

    .line 696
    add-int/lit8 v0, p1, 0x1

    const/16 v1, -0x80

    aput-byte v1, p0, v0

    goto :goto_0

    .line 698
    :cond_1
    and-int/lit16 v0, p2, 0xff

    int-to-byte v0, v0

    aput-byte v0, p0, p1

    .line 699
    add-int/lit8 v0, p1, 0x1

    shr-int/lit8 v1, p2, 0x8

    int-to-byte v1, v1

    aput-byte v1, p0, v0

    .line 701
    :goto_0
    return-void
.end method

.method private shortenSilenceSilenceUntilNoise(Ljava/nio/ByteBuffer;)V
    .locals 11
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 384
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    iget-object v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v1, v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ge v0, v1, :cond_0

    move v0, v2

    goto :goto_0

    :cond_0
    move v0, v3

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 386
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v0

    .line 387
    .local v0, "limit":I
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->findNoisePosition(Ljava/nio/ByteBuffer;)I

    move-result v1

    .line 388
    .local v1, "noisePosition":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v4

    sub-int v4, v1, v4

    .line 392
    .local v4, "silenceInputSize":I
    iget v5, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    iget v6, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    add-int v7, v5, v6

    iget-object v8, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v9, v8

    if-ge v7, v9, :cond_1

    .line 394
    array-length v7, v8

    add-int v8, v6, v5

    sub-int/2addr v7, v8

    .line 397
    .local v7, "contiguousBufferRemaining":I
    add-int/2addr v5, v6

    .local v5, "indexToWriteTo":I
    goto :goto_1

    .line 400
    .end local v5    # "indexToWriteTo":I
    .end local v7    # "contiguousBufferRemaining":I
    :cond_1
    array-length v7, v8

    sub-int/2addr v7, v5

    .line 401
    .local v7, "amountInUpperPartOfBuffer":I
    sub-int/2addr v6, v7

    .line 402
    .local v6, "indexToWriteTo":I
    sub-int/2addr v5, v6

    move v7, v5

    move v5, v6

    .line 405
    .end local v6    # "indexToWriteTo":I
    .restart local v5    # "indexToWriteTo":I
    .local v7, "contiguousBufferRemaining":I
    :goto_1
    if-ge v1, v0, :cond_2

    move v6, v2

    goto :goto_2

    :cond_2
    move v6, v3

    .line 407
    .local v6, "noiseFound":Z
    :goto_2
    invoke-static {v4, v7}, Ljava/lang/Math;->min(II)I

    move-result v8

    .line 408
    .local v8, "bytesOfInput":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v9

    add-int/2addr v9, v8

    invoke-virtual {p1, v9}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 409
    iget-object v9, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    invoke-virtual {p1, v9, v5, v8}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 410
    iget v9, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    add-int/2addr v9, v8

    iput v9, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 412
    iget-object v10, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v10, v10

    if-gt v9, v10, :cond_3

    move v9, v2

    goto :goto_3

    :cond_3
    move v9, v3

    :goto_3
    invoke-static {v9}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 414
    if-eqz v6, :cond_4

    if-ge v4, v7, :cond_4

    goto :goto_4

    :cond_4
    move v2, v3

    .line 420
    .local v2, "shouldTransitionToNoisyState":Z
    :goto_4
    invoke-direct {p0, v2}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputShortenedSilenceBuffer(Z)V

    .line 422
    if-eqz v2, :cond_5

    .line 423
    iput v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->state:I

    .line 424
    iput v3, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    .line 428
    :cond_5
    invoke-virtual {p1, v0}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 429
    return-void
.end method

.method private static twoByteSampleToInt(BB)I
    .locals 2
    .param p0, "mostSignificantByte"    # B
    .param p1, "leastSignificantByte"    # B

    .line 683
    and-int/lit16 v0, p1, 0xff

    shl-int/lit8 v1, p0, 0x8

    or-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public getSkippedFrames()J
    .locals 2

    .line 260
    iget-wide v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->skippedFrames:J

    return-wide v0
.end method

.method public isActive()Z
    .locals 2

    .line 276
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v0, v0, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->sampleRate:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget-boolean v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->enabled:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method protected onConfigure(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .locals 2
    .param p1, "inputAudioFormat"    # Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;
        }
    .end annotation

    .line 266
    iget v0, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 269
    iput-object p1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 270
    iget v0, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->channelCount:I

    mul-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->bytesPerFrame:I

    .line 271
    return-object p1

    .line 267
    :cond_0
    new-instance v0, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v0, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v0
.end method

.method public onFlush()V
    .locals 3

    .line 309
    invoke-virtual {p0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->isActive()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 311
    iget-wide v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->minimumSilenceDurationUs:J

    .line 312
    invoke-direct {p0, v0, v1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->durationUsToFrames(J)I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->alignToBytePerFrameBoundary(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x2

    .line 313
    .local v0, "maybeSilenceBufferSize":I
    iget-object v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    array-length v1, v1

    if-eq v1, v0, :cond_0

    .line 314
    new-array v1, v0, [B

    iput-object v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    .line 315
    new-array v1, v0, [B

    iput-object v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    .line 318
    .end local v0    # "maybeSilenceBufferSize":I
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->state:I

    .line 319
    const-wide/16 v1, 0x0

    iput-wide v1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->skippedFrames:J

    .line 320
    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    .line 321
    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferStartIndex:I

    .line 322
    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    .line 323
    return-void
.end method

.method public onQueueEndOfStream()V
    .locals 1

    .line 299
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBufferContentsSize:I

    if-lez v0, :cond_0

    .line 302
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputShortenedSilenceBuffer(Z)V

    .line 303
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->outputSilenceFramesSinceNoise:I

    .line 305
    :cond_0
    return-void
.end method

.method public onReset()V
    .locals 1

    .line 327
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->enabled:Z

    .line 328
    sget-object v0, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->inputFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 329
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->maybeSilenceBuffer:[B

    .line 330
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->contiguousOutputBuffer:[B

    .line 331
    return-void
.end method

.method public queueInput(Ljava/nio/ByteBuffer;)V
    .locals 1
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 281
    nop

    :goto_0
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->hasRemaining()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->hasPendingOutput()Z

    move-result v0

    if-nez v0, :cond_0

    .line 282
    iget v0, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->state:I

    packed-switch v0, :pswitch_data_0

    .line 290
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 287
    :pswitch_0
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->shortenSilenceSilenceUntilNoise(Ljava/nio/ByteBuffer;)V

    .line 288
    goto :goto_0

    .line 284
    :pswitch_1
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->processNoisy(Ljava/nio/ByteBuffer;)V

    .line 285
    goto :goto_0

    .line 293
    :cond_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public setEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .line 252
    iput-boolean p1, p0, Landroidx/media3/exoplayer/audio/SilenceSkippingAudioProcessor;->enabled:Z

    .line 253
    return-void
.end method
