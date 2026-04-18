.class public Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;
.super Ljava/lang/Object;
.source "DefaultAudioTrackBufferSizeProvider.java"

# interfaces
.implements Landroidx/media3/exoplayer/audio/DefaultAudioSink$AudioTrackBufferSizeProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;
    }
.end annotation


# static fields
.field private static final AC3_BUFFER_MULTIPLICATION_FACTOR:I = 0x2

.field private static final DTSHD_BUFFER_MULTIPLICATION_FACTOR:I = 0x4

.field private static final MAX_PCM_BUFFER_DURATION_US:I = 0xb71b0

.field private static final MIN_PCM_BUFFER_DURATION_US:I = 0x3d090

.field private static final OFFLOAD_BUFFER_DURATION_US:I = 0x2faf080

.field private static final PASSTHROUGH_BUFFER_DURATION_US:I = 0x3d090

.field private static final PCM_BUFFER_MULTIPLICATION_FACTOR:I = 0x4


# instance fields
.field public final ac3BufferMultiplicationFactor:I

.field public final dtshdBufferMultiplicationFactor:I

.field protected final maxPcmBufferDurationUs:I

.field protected final minPcmBufferDurationUs:I

.field protected final offloadBufferDurationUs:I

.field protected final passthroughBufferDurationUs:I

.field protected final pcmBufferMultiplicationFactor:I


# direct methods
.method protected constructor <init>(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)V
    .locals 1
    .param p1, "builder"    # Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;

    .line 196
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 197
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$000(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->minPcmBufferDurationUs:I

    .line 198
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$100(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->maxPcmBufferDurationUs:I

    .line 199
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$200(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->pcmBufferMultiplicationFactor:I

    .line 200
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$300(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->passthroughBufferDurationUs:I

    .line 201
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$400(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->offloadBufferDurationUs:I

    .line 202
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$500(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->ac3BufferMultiplicationFactor:I

    .line 203
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;->access$600(Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider$Builder;)I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->dtshdBufferMultiplicationFactor:I

    .line 204
    return-void
.end method

.method protected static durationUsToBytes(III)I
    .locals 4
    .param p0, "durationUs"    # I
    .param p1, "samplingRate"    # I
    .param p2, "frameSize"    # I

    .line 280
    int-to-long v0, p0

    int-to-long v2, p1

    mul-long/2addr v0, v2

    int-to-long v2, p2

    mul-long/2addr v0, v2

    const-wide/32 v2, 0xf4240

    div-long/2addr v0, v2

    invoke-static {v0, v1}, Lcom/google/common/primitives/Ints;->checkedCast(J)I

    move-result v0

    return v0
.end method

.method protected static getMaximumEncodedRateBytesPerSecond(I)I
    .locals 1
    .param p0, "encoding"    # I

    .line 284
    packed-switch p0, :pswitch_data_0

    .line 324
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 311
    :pswitch_1
    const v0, 0xf906

    return v0

    .line 303
    :pswitch_2
    const v0, 0x52080

    return v0

    .line 294
    :pswitch_3
    const v0, 0x3e800

    return v0

    .line 296
    :pswitch_4
    const/16 v0, 0x1f40

    return v0

    .line 309
    :pswitch_5
    const v0, 0x2ebae4

    return v0

    .line 292
    :pswitch_6
    const/16 v0, 0x1b58

    return v0

    .line 290
    :pswitch_7
    const/16 v0, 0x3e80

    return v0

    .line 288
    :pswitch_8
    const v0, 0x186a0

    return v0

    .line 286
    :pswitch_9
    const v0, 0x9c40

    return v0

    .line 307
    :pswitch_a
    const v0, 0x225510

    return v0

    .line 305
    :pswitch_b
    const v0, 0x2ee00

    return v0

    .line 301
    :pswitch_c
    const v0, 0xbb800

    return v0

    .line 298
    :pswitch_d
    const v0, 0x13880

    return v0

    :pswitch_data_0
    .packed-switch 0x5
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_0
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_c
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method protected get1xBufferSizeInBytes(IIIIII)I
    .locals 1
    .param p1, "minBufferSizeInBytes"    # I
    .param p2, "encoding"    # I
    .param p3, "outputMode"    # I
    .param p4, "pcmFrameSize"    # I
    .param p5, "sampleRate"    # I
    .param p6, "bitrate"    # I

    .line 234
    packed-switch p3, :pswitch_data_0

    .line 242
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 238
    :pswitch_0
    invoke-virtual {p0, p2, p6}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->getPassthroughBufferSizeInBytes(II)I

    move-result v0

    return v0

    .line 240
    :pswitch_1
    invoke-virtual {p0, p2}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->getOffloadBufferSizeInBytes(I)I

    move-result v0

    return v0

    .line 236
    :pswitch_2
    invoke-virtual {p0, p1, p5, p4}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->getPcmBufferSizeInBytes(III)I

    move-result v0

    return v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public getBufferSizeInBytes(IIIIIID)I
    .locals 3
    .param p1, "minBufferSizeInBytes"    # I
    .param p2, "encoding"    # I
    .param p3, "outputMode"    # I
    .param p4, "pcmFrameSize"    # I
    .param p5, "sampleRate"    # I
    .param p6, "bitrate"    # I
    .param p7, "maxAudioTrackPlaybackSpeed"    # D

    .line 215
    nop

    .line 216
    invoke-virtual/range {p0 .. p6}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->get1xBufferSizeInBytes(IIIIII)I

    move-result v0

    .line 219
    .local v0, "bufferSize":I
    int-to-double v1, v0

    mul-double/2addr v1, p7

    double-to-int v0, v1

    .line 221
    invoke-static {p1, v0}, Ljava/lang/Math;->max(II)I

    move-result v0

    .line 223
    add-int v1, v0, p4

    add-int/lit8 v1, v1, -0x1

    div-int/2addr v1, p4

    mul-int/2addr v1, p4

    return v1
.end method

.method protected getOffloadBufferSizeInBytes(I)I
    .locals 5
    .param p1, "encoding"    # I

    .line 275
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->getMaximumEncodedRateBytesPerSecond(I)I

    move-result v0

    .line 276
    .local v0, "maxByteRate":I
    iget v1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->offloadBufferDurationUs:I

    int-to-long v1, v1

    int-to-long v3, v0

    mul-long/2addr v1, v3

    const-wide/32 v3, 0xf4240

    div-long/2addr v1, v3

    invoke-static {v1, v2}, Lcom/google/common/primitives/Ints;->checkedCast(J)I

    move-result v1

    return v1
.end method

.method protected getPassthroughBufferSizeInBytes(II)I
    .locals 6
    .param p1, "encoding"    # I
    .param p2, "bitrate"    # I

    .line 256
    iget v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->passthroughBufferDurationUs:I

    .line 257
    .local v0, "bufferSizeUs":I
    const/4 v1, 0x5

    const/16 v2, 0x8

    if-ne p1, v1, :cond_0

    .line 258
    iget v1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->ac3BufferMultiplicationFactor:I

    mul-int/2addr v0, v1

    goto :goto_0

    .line 259
    :cond_0
    if-ne p1, v2, :cond_1

    .line 263
    iget v1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->dtshdBufferMultiplicationFactor:I

    mul-int/2addr v0, v1

    .line 267
    :cond_1
    :goto_0
    const/4 v1, -0x1

    if-eq p2, v1, :cond_2

    .line 268
    sget-object v1, Ljava/math/RoundingMode;->CEILING:Ljava/math/RoundingMode;

    invoke-static {p2, v2, v1}, Lcom/google/common/math/IntMath;->divide(IILjava/math/RoundingMode;)I

    move-result v1

    goto :goto_1

    .line 269
    :cond_2
    invoke-static {p1}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->getMaximumEncodedRateBytesPerSecond(I)I

    move-result v1

    :goto_1
    nop

    .line 270
    .local v1, "byteRate":I
    int-to-long v2, v0

    int-to-long v4, v1

    mul-long/2addr v2, v4

    const-wide/32 v4, 0xf4240

    div-long/2addr v2, v4

    invoke-static {v2, v3}, Lcom/google/common/primitives/Ints;->checkedCast(J)I

    move-result v2

    return v2
.end method

.method protected getPcmBufferSizeInBytes(III)I
    .locals 4
    .param p1, "minBufferSizeInBytes"    # I
    .param p2, "samplingRate"    # I
    .param p3, "frameSize"    # I

    .line 248
    iget v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->pcmBufferMultiplicationFactor:I

    mul-int/2addr v0, p1

    .line 249
    .local v0, "targetBufferSize":I
    iget v1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->minPcmBufferDurationUs:I

    invoke-static {v1, p2, p3}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->durationUsToBytes(III)I

    move-result v1

    .line 250
    .local v1, "minAppBufferSize":I
    iget v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->maxPcmBufferDurationUs:I

    invoke-static {v2, p2, p3}, Landroidx/media3/exoplayer/audio/DefaultAudioTrackBufferSizeProvider;->durationUsToBytes(III)I

    move-result v2

    .line 251
    .local v2, "maxAppBufferSize":I
    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v3

    return v3
.end method
