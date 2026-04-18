.class final Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;
.super Landroidx/media3/common/audio/BaseAudioProcessor;
.source "ChannelMappingAudioProcessor.java"


# instance fields
.field private outputChannels:[I

.field private pendingOutputChannels:[I


# direct methods
.method constructor <init>()V
    .locals 0

    .line 30
    invoke-direct {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigure(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .locals 8
    .param p1, "inputAudioFormat"    # Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;
        }
    .end annotation

    .line 51
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->pendingOutputChannels:[I

    .line 52
    .local v0, "outputChannels":[I
    if-nez v0, :cond_0

    .line 53
    sget-object v1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    return-object v1

    .line 56
    :cond_0
    iget v1, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_6

    .line 60
    iget v1, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->channelCount:I

    array-length v3, v0

    const/4 v4, 0x0

    const/4 v5, 0x1

    if-eq v1, v3, :cond_1

    move v1, v5

    goto :goto_0

    :cond_1
    move v1, v4

    .line 61
    .local v1, "active":Z
    :goto_0
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v6, v0

    if-ge v3, v6, :cond_4

    .line 62
    aget v6, v0, v3

    .line 63
    .local v6, "channelIndex":I
    iget v7, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->channelCount:I

    if-ge v6, v7, :cond_3

    .line 66
    if-eq v6, v3, :cond_2

    move v7, v5

    goto :goto_2

    :cond_2
    move v7, v4

    :goto_2
    or-int/2addr v1, v7

    .line 61
    .end local v6    # "channelIndex":I
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 64
    .restart local v6    # "channelIndex":I
    :cond_3
    new-instance v2, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v2, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v2

    .line 68
    .end local v3    # "i":I
    .end local v6    # "channelIndex":I
    :cond_4
    if-eqz v1, :cond_5

    .line 69
    new-instance v3, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v4, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->sampleRate:I

    array-length v5, v0

    invoke-direct {v3, v4, v5, v2}, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;-><init>(III)V

    goto :goto_3

    .line 70
    :cond_5
    sget-object v3, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    .line 68
    :goto_3
    return-object v3

    .line 57
    .end local v1    # "active":Z
    :cond_6
    new-instance v1, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v1, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v1
.end method

.method protected onFlush()V
    .locals 1

    .line 93
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->pendingOutputChannels:[I

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->outputChannels:[I

    .line 94
    return-void
.end method

.method protected onReset()V
    .locals 1

    .line 98
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->outputChannels:[I

    .line 99
    iput-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->pendingOutputChannels:[I

    .line 100
    return-void
.end method

.method public queueInput(Ljava/nio/ByteBuffer;)V
    .locals 10
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 75
    iget-object v0, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->outputChannels:[I

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [I

    .line 76
    .local v0, "outputChannels":[I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    .line 77
    .local v1, "position":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v2

    .line 78
    .local v2, "limit":I
    sub-int v3, v2, v1

    iget-object v4, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v4, v4, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    div-int/2addr v3, v4

    .line 79
    .local v3, "frameCount":I
    iget-object v4, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->outputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v4, v4, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    mul-int/2addr v4, v3

    .line 80
    .local v4, "outputSize":I
    invoke-virtual {p0, v4}, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v5

    .line 81
    .local v5, "buffer":Ljava/nio/ByteBuffer;
    :goto_0
    if-ge v1, v2, :cond_1

    .line 82
    array-length v6, v0

    const/4 v7, 0x0

    :goto_1
    if-ge v7, v6, :cond_0

    aget v8, v0, v7

    .line 83
    .local v8, "channelIndex":I
    mul-int/lit8 v9, v8, 0x2

    add-int/2addr v9, v1

    invoke-virtual {p1, v9}, Ljava/nio/ByteBuffer;->getShort(I)S

    move-result v9

    invoke-virtual {v5, v9}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 82
    .end local v8    # "channelIndex":I
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 85
    :cond_0
    iget-object v6, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v6, v6, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    add-int/2addr v1, v6

    goto :goto_0

    .line 87
    :cond_1
    invoke-virtual {p1, v2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 88
    invoke-virtual {v5}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 89
    return-void
.end method

.method public setChannelMap([I)V
    .locals 0
    .param p1, "outputChannels"    # [I

    .line 45
    iput-object p1, p0, Landroidx/media3/exoplayer/audio/ChannelMappingAudioProcessor;->pendingOutputChannels:[I

    .line 46
    return-void
.end method
