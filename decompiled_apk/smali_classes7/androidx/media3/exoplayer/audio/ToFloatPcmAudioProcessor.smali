.class final Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;
.super Landroidx/media3/common/audio/BaseAudioProcessor;
.source "ToFloatPcmAudioProcessor.java"


# static fields
.field private static final FLOAT_NAN_AS_INT:I

.field private static final PCM_32_BIT_INT_TO_PCM_32_BIT_FLOAT_FACTOR:D = 4.656612875245797E-10


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 39
    const/high16 v0, 0x7fc00000    # Float.NaN

    invoke-static {v0}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v0

    sput v0, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->FLOAT_NAN_AS_INT:I

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .line 37
    invoke-direct {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;-><init>()V

    return-void
.end method

.method private static writePcm32BitFloat(ILjava/nio/ByteBuffer;)V
    .locals 4
    .param p0, "pcm32BitInt"    # I
    .param p1, "buffer"    # Ljava/nio/ByteBuffer;

    .line 127
    const-wide v0, 0x3e00000000200000L    # 4.656612875245797E-10

    int-to-double v2, p0

    mul-double/2addr v2, v0

    double-to-float v0, v2

    .line 128
    .local v0, "pcm32BitFloat":F
    invoke-static {v0}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    .line 129
    .local v1, "floatBits":I
    sget v2, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->FLOAT_NAN_AS_INT:I

    if-ne v1, v2, :cond_0

    .line 130
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    .line 132
    :cond_0
    invoke-virtual {p1, v1}, Ljava/nio/ByteBuffer;->putInt(I)Ljava/nio/ByteBuffer;

    .line 133
    return-void
.end method


# virtual methods
.method public onConfigure(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .locals 5
    .param p1, "inputAudioFormat"    # Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;
        }
    .end annotation

    .line 45
    iget v0, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    .line 46
    .local v0, "encoding":I
    invoke-static {v0}, Landroidx/media3/common/util/Util;->isEncodingHighResolutionPcm(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 49
    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    .line 50
    new-instance v2, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v3, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->sampleRate:I

    iget v4, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->channelCount:I

    invoke-direct {v2, v3, v4, v1}, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;-><init>(III)V

    goto :goto_0

    .line 52
    :cond_0
    sget-object v2, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 49
    :goto_0
    return-object v2

    .line 47
    :cond_1
    new-instance v1, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v1, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v1
.end method

.method public queueInput(Ljava/nio/ByteBuffer;)V
    .locals 7
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 57
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .line 58
    .local v0, "position":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    .line 59
    .local v1, "limit":I
    sub-int v2, v1, v0

    .line 62
    .local v2, "size":I
    iget-object v3, p0, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v3, v3, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    sparse-switch v3, :sswitch_data_0

    .line 113
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3}, Ljava/lang/IllegalStateException;-><init>()V

    throw v3

    .line 95
    :sswitch_0
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 96
    .local v3, "buffer":Ljava/nio/ByteBuffer;
    move v4, v0

    .local v4, "i":I
    :goto_0
    if-ge v4, v1, :cond_0

    .line 97
    add-int/lit8 v5, v4, 0x3

    .line 98
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    add-int/lit8 v6, v4, 0x2

    .line 99
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x8

    or-int/2addr v5, v6

    add-int/lit8 v6, v4, 0x1

    .line 100
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x10

    or-int/2addr v5, v6

    .line 101
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    or-int/2addr v5, v6

    .line 102
    .local v5, "pcm32BitInteger":I
    invoke-static {v5, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->writePcm32BitFloat(ILjava/nio/ByteBuffer;)V

    .line 96
    .end local v5    # "pcm32BitInteger":I
    add-int/lit8 v4, v4, 0x4

    goto :goto_0

    .line 104
    .end local v4    # "i":I
    :cond_0
    goto/16 :goto_4

    .line 74
    .end local v3    # "buffer":Ljava/nio/ByteBuffer;
    :sswitch_1
    div-int/lit8 v3, v2, 0x3

    mul-int/lit8 v3, v3, 0x4

    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 75
    .restart local v3    # "buffer":Ljava/nio/ByteBuffer;
    move v4, v0

    .restart local v4    # "i":I
    :goto_1
    if-ge v4, v1, :cond_1

    .line 76
    add-int/lit8 v5, v4, 0x2

    .line 77
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x8

    add-int/lit8 v6, v4, 0x1

    .line 78
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x10

    or-int/2addr v5, v6

    .line 79
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    or-int/2addr v5, v6

    .line 80
    .restart local v5    # "pcm32BitInteger":I
    invoke-static {v5, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->writePcm32BitFloat(ILjava/nio/ByteBuffer;)V

    .line 75
    .end local v5    # "pcm32BitInteger":I
    add-int/lit8 v4, v4, 0x3

    goto :goto_1

    .line 82
    .end local v4    # "i":I
    :cond_1
    goto :goto_4

    .line 84
    .end local v3    # "buffer":Ljava/nio/ByteBuffer;
    :sswitch_2
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 85
    .restart local v3    # "buffer":Ljava/nio/ByteBuffer;
    move v4, v0

    .restart local v4    # "i":I
    :goto_2
    if-ge v4, v1, :cond_2

    .line 86
    nop

    .line 87
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    add-int/lit8 v6, v4, 0x1

    .line 88
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x8

    or-int/2addr v5, v6

    add-int/lit8 v6, v4, 0x2

    .line 89
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x10

    or-int/2addr v5, v6

    add-int/lit8 v6, v4, 0x3

    .line 90
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    or-int/2addr v5, v6

    .line 91
    .restart local v5    # "pcm32BitInteger":I
    invoke-static {v5, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->writePcm32BitFloat(ILjava/nio/ByteBuffer;)V

    .line 85
    .end local v5    # "pcm32BitInteger":I
    add-int/lit8 v4, v4, 0x4

    goto :goto_2

    .line 93
    .end local v4    # "i":I
    :cond_2
    goto :goto_4

    .line 64
    .end local v3    # "buffer":Ljava/nio/ByteBuffer;
    :sswitch_3
    div-int/lit8 v3, v2, 0x3

    mul-int/lit8 v3, v3, 0x4

    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 65
    .restart local v3    # "buffer":Ljava/nio/ByteBuffer;
    move v4, v0

    .restart local v4    # "i":I
    :goto_3
    if-ge v4, v1, :cond_3

    .line 66
    nop

    .line 67
    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v5

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x8

    add-int/lit8 v6, v4, 0x1

    .line 68
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x10

    or-int/2addr v5, v6

    add-int/lit8 v6, v4, 0x2

    .line 69
    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    shl-int/lit8 v6, v6, 0x18

    or-int/2addr v5, v6

    .line 70
    .restart local v5    # "pcm32BitInteger":I
    invoke-static {v5, v3}, Landroidx/media3/exoplayer/audio/ToFloatPcmAudioProcessor;->writePcm32BitFloat(ILjava/nio/ByteBuffer;)V

    .line 65
    .end local v5    # "pcm32BitInteger":I
    add-int/lit8 v4, v4, 0x3

    goto :goto_3

    .line 72
    .end local v4    # "i":I
    :cond_3
    nop

    .line 116
    :goto_4
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v4

    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 117
    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 118
    return-void

    nop

    :sswitch_data_0
    .sparse-switch
        0x15 -> :sswitch_3
        0x16 -> :sswitch_2
        0x50000000 -> :sswitch_1
        0x60000000 -> :sswitch_0
    .end sparse-switch
.end method
