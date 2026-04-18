.class public final Landroidx/media3/common/audio/ToInt16PcmAudioProcessor;
.super Landroidx/media3/common/audio/BaseAudioProcessor;
.source "ToInt16PcmAudioProcessor.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40
    invoke-direct {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;-><init>()V

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
    const/4 v1, 0x3

    const/4 v2, 0x2

    if-eq v0, v1, :cond_1

    if-eq v0, v2, :cond_1

    const/high16 v1, 0x10000000

    if-eq v0, v1, :cond_1

    const/16 v1, 0x15

    if-eq v0, v1, :cond_1

    const/high16 v1, 0x50000000

    if-eq v0, v1, :cond_1

    const/16 v1, 0x16

    if-eq v0, v1, :cond_1

    const/high16 v1, 0x60000000

    if-eq v0, v1, :cond_1

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    goto :goto_0

    .line 54
    :cond_0
    new-instance v1, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v1, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v1

    .line 56
    :cond_1
    :goto_0
    if-eq v0, v2, :cond_2

    .line 57
    new-instance v1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v3, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->sampleRate:I

    iget v4, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->channelCount:I

    invoke-direct {v1, v3, v4, v2}, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;-><init>(III)V

    goto :goto_1

    .line 59
    :cond_2
    sget-object v1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 56
    :goto_1
    return-object v1
.end method

.method public queueInput(Ljava/nio/ByteBuffer;)V
    .locals 9
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 65
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .line 66
    .local v0, "position":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    .line 67
    .local v1, "limit":I
    sub-int v2, v1, v0

    .line 69
    .local v2, "size":I
    iget-object v3, p0, Landroidx/media3/common/audio/ToInt16PcmAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v3, v3, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    sparse-switch v3, :sswitch_data_0

    .line 89
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3}, Ljava/lang/IllegalStateException;-><init>()V

    throw v3

    .line 74
    :sswitch_0
    move v3, v2

    .line 75
    .local v3, "resampledSize":I
    goto :goto_0

    .line 78
    .end local v3    # "resampledSize":I
    :sswitch_1
    div-int/lit8 v3, v2, 0x3

    mul-int/lit8 v3, v3, 0x2

    .line 79
    .restart local v3    # "resampledSize":I
    goto :goto_0

    .line 83
    .end local v3    # "resampledSize":I
    :sswitch_2
    div-int/lit8 v3, v2, 0x2

    .line 84
    .restart local v3    # "resampledSize":I
    goto :goto_0

    .line 71
    .end local v3    # "resampledSize":I
    :sswitch_3
    mul-int/lit8 v3, v2, 0x2

    .line 72
    .restart local v3    # "resampledSize":I
    nop

    .line 93
    :goto_0
    invoke-virtual {p0, v3}, Landroidx/media3/common/audio/ToInt16PcmAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v4

    .line 94
    .local v4, "buffer":Ljava/nio/ByteBuffer;
    iget-object v5, p0, Landroidx/media3/common/audio/ToInt16PcmAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v5, v5, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    sparse-switch v5, :sswitch_data_1

    .line 155
    new-instance v5, Ljava/lang/IllegalStateException;

    invoke-direct {v5}, Ljava/lang/IllegalStateException;-><init>()V

    throw v5

    .line 132
    :sswitch_4
    move v5, v0

    .local v5, "i":I
    :goto_1
    if-ge v5, v1, :cond_0

    .line 133
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 134
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 132
    add-int/lit8 v5, v5, 0x4

    goto :goto_1

    .line 136
    .end local v5    # "i":I
    :cond_0
    goto/16 :goto_8

    .line 118
    :sswitch_5
    move v5, v0

    .restart local v5    # "i":I
    :goto_2
    if-ge v5, v1, :cond_1

    .line 119
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 120
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 118
    add-int/lit8 v5, v5, 0x3

    goto :goto_2

    .line 122
    .end local v5    # "i":I
    :cond_1
    goto/16 :goto_8

    .line 104
    :sswitch_6
    move v5, v0

    .restart local v5    # "i":I
    :goto_3
    if-ge v5, v1, :cond_2

    .line 105
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 106
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 104
    add-int/lit8 v5, v5, 0x2

    goto :goto_3

    .line 108
    .end local v5    # "i":I
    :cond_2
    goto/16 :goto_8

    .line 125
    :sswitch_7
    move v5, v0

    .restart local v5    # "i":I
    :goto_4
    if-ge v5, v1, :cond_3

    .line 126
    add-int/lit8 v6, v5, 0x2

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 127
    add-int/lit8 v6, v5, 0x3

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 125
    add-int/lit8 v5, v5, 0x4

    goto :goto_4

    .line 129
    .end local v5    # "i":I
    :cond_3
    goto :goto_8

    .line 111
    :sswitch_8
    move v5, v0

    .restart local v5    # "i":I
    :goto_5
    if-ge v5, v1, :cond_4

    .line 112
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 113
    add-int/lit8 v6, v5, 0x2

    invoke-virtual {p1, v6}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 111
    add-int/lit8 v5, v5, 0x3

    goto :goto_5

    .line 115
    .end local v5    # "i":I
    :cond_4
    goto :goto_8

    .line 140
    :sswitch_9
    move v5, v0

    .restart local v5    # "i":I
    :goto_6
    if-ge v5, v1, :cond_5

    .line 143
    nop

    .line 144
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->getFloat(I)F

    move-result v6

    const/high16 v7, -0x40800000    # -1.0f

    const/high16 v8, 0x3f800000    # 1.0f

    invoke-static {v6, v7, v8}, Landroidx/media3/common/util/Util;->constrainValue(FFF)F

    move-result v6

    .line 145
    .local v6, "floatValue":F
    const v7, 0x46fffe00    # 32767.0f

    mul-float/2addr v7, v6

    float-to-int v7, v7

    int-to-short v7, v7

    .line 146
    .local v7, "shortValue":S
    and-int/lit16 v8, v7, 0xff

    int-to-byte v8, v8

    invoke-virtual {v4, v8}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 147
    shr-int/lit8 v8, v7, 0x8

    and-int/lit16 v8, v8, 0xff

    int-to-byte v8, v8

    invoke-virtual {v4, v8}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 140
    .end local v6    # "floatValue":F
    .end local v7    # "shortValue":S
    add-int/lit8 v5, v5, 0x4

    goto :goto_6

    .line 149
    .end local v5    # "i":I
    :cond_5
    goto :goto_8

    .line 97
    :sswitch_a
    move v5, v0

    .restart local v5    # "i":I
    :goto_7
    if-ge v5, v1, :cond_6

    .line 98
    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 99
    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v6

    and-int/lit16 v6, v6, 0xff

    add-int/lit8 v6, v6, -0x80

    int-to-byte v6, v6

    invoke-virtual {v4, v6}, Ljava/nio/ByteBuffer;->put(B)Ljava/nio/ByteBuffer;

    .line 97
    add-int/lit8 v5, v5, 0x1

    goto :goto_7

    .line 101
    .end local v5    # "i":I
    :cond_6
    nop

    .line 157
    :goto_8
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v5

    invoke-virtual {p1, v5}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 158
    invoke-virtual {v4}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 159
    return-void

    nop

    :sswitch_data_0
    .sparse-switch
        0x3 -> :sswitch_3
        0x4 -> :sswitch_2
        0x15 -> :sswitch_1
        0x16 -> :sswitch_2
        0x10000000 -> :sswitch_0
        0x50000000 -> :sswitch_1
        0x60000000 -> :sswitch_2
    .end sparse-switch

    :sswitch_data_1
    .sparse-switch
        0x3 -> :sswitch_a
        0x4 -> :sswitch_9
        0x15 -> :sswitch_8
        0x16 -> :sswitch_7
        0x10000000 -> :sswitch_6
        0x50000000 -> :sswitch_5
        0x60000000 -> :sswitch_4
    .end sparse-switch
.end method
