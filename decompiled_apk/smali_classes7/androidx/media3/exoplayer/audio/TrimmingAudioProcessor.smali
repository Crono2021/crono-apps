.class final Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;
.super Landroidx/media3/common/audio/BaseAudioProcessor;
.source "TrimmingAudioProcessor.java"


# static fields
.field private static final OUTPUT_ENCODING:I = 0x2


# instance fields
.field private endBuffer:[B

.field private endBufferSize:I

.field private pendingTrimStartBytes:I

.field private reconfigurationPending:Z

.field private trimEndFrames:I

.field private trimStartFrames:I

.field private trimmedFrameCount:J


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 41
    invoke-direct {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;-><init>()V

    .line 42
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    .line 43
    return-void
.end method


# virtual methods
.method public getOutput()Ljava/nio/ByteBuffer;
    .locals 4

    .line 134
    invoke-super {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;->isEnded()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    if-lez v0, :cond_0

    .line 138
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    iget-object v1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    iget v2, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v3, v2}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 139
    iput v3, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    .line 141
    :cond_0
    invoke-super {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;->getOutput()Ljava/nio/ByteBuffer;

    move-result-object v0

    return-object v0
.end method

.method public getTrimmedFrameCount()J
    .locals 2

    .line 70
    iget-wide v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    return-wide v0
.end method

.method public isEnded()Z
    .locals 1

    .line 146
    invoke-super {p0}, Landroidx/media3/common/audio/BaseAudioProcessor;->isEnded()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public onConfigure(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .locals 2
    .param p1, "inputAudioFormat"    # Landroidx/media3/common/audio/AudioProcessor$AudioFormat;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;
        }
    .end annotation

    .line 76
    iget v0, p1, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->encoding:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->reconfigurationPending:Z

    .line 80
    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimStartFrames:I

    if-nez v0, :cond_1

    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimEndFrames:I

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    sget-object v0, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->NOT_SET:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    goto :goto_1

    :cond_1
    :goto_0
    move-object v0, p1

    :goto_1
    return-object v0

    .line 77
    :cond_2
    new-instance v0, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;

    invoke-direct {v0, p1}, Landroidx/media3/common/audio/AudioProcessor$UnhandledAudioFormatException;-><init>(Landroidx/media3/common/audio/AudioProcessor$AudioFormat;)V

    throw v0
.end method

.method protected onFlush()V
    .locals 3

    .line 162
    iget-boolean v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->reconfigurationPending:Z

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 164
    iput-boolean v1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->reconfigurationPending:Z

    .line 165
    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimEndFrames:I

    iget-object v2, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v2, v2, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    mul-int/2addr v0, v2

    new-array v0, v0, [B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    .line 166
    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimStartFrames:I

    iget-object v2, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v2, v2, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    mul-int/2addr v0, v2

    iput v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->pendingTrimStartBytes:I

    .line 177
    :cond_0
    iput v1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    .line 178
    return-void
.end method

.method protected onQueueEndOfStream()V
    .locals 5

    .line 151
    iget-boolean v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->reconfigurationPending:Z

    if-eqz v0, :cond_1

    .line 153
    iget v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    if-lez v0, :cond_0

    .line 154
    iget-wide v1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    iget-object v3, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v3, v3, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    div-int/2addr v0, v3

    int-to-long v3, v0

    add-long/2addr v1, v3

    iput-wide v1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    .line 156
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    .line 158
    :cond_1
    return-void
.end method

.method protected onReset()V
    .locals 1

    .line 182
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    .line 183
    return-void
.end method

.method public queueInput(Ljava/nio/ByteBuffer;)V
    .locals 11
    .param p1, "inputBuffer"    # Ljava/nio/ByteBuffer;

    .line 85
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .line 86
    .local v0, "position":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->limit()I

    move-result v1

    .line 87
    .local v1, "limit":I
    sub-int v2, v1, v0

    .line 89
    .local v2, "remaining":I
    if-nez v2, :cond_0

    .line 90
    return-void

    .line 94
    :cond_0
    iget v3, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->pendingTrimStartBytes:I

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    .line 95
    .local v3, "trimBytes":I
    iget-wide v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    iget-object v6, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->inputAudioFormat:Landroidx/media3/common/audio/AudioProcessor$AudioFormat;

    iget v6, v6, Landroidx/media3/common/audio/AudioProcessor$AudioFormat;->bytesPerFrame:I

    div-int v6, v3, v6

    int-to-long v6, v6

    add-long/2addr v4, v6

    iput-wide v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    .line 96
    iget v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->pendingTrimStartBytes:I

    sub-int/2addr v4, v3

    iput v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->pendingTrimStartBytes:I

    .line 97
    add-int v4, v0, v3

    invoke-virtual {p1, v4}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 98
    iget v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->pendingTrimStartBytes:I

    if-lez v4, :cond_1

    .line 100
    return-void

    .line 102
    :cond_1
    sub-int/2addr v2, v3

    .line 108
    iget v4, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    add-int/2addr v4, v2

    iget-object v5, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    array-length v5, v5

    sub-int/2addr v4, v5

    .line 109
    .local v4, "remainingBytesToOutput":I
    invoke-virtual {p0, v4}, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->replaceOutputBuffer(I)Ljava/nio/ByteBuffer;

    move-result-object v5

    .line 112
    .local v5, "buffer":Ljava/nio/ByteBuffer;
    iget v6, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    const/4 v7, 0x0

    invoke-static {v4, v7, v6}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v6

    .line 113
    .local v6, "endBufferBytesToOutput":I
    iget-object v8, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    invoke-virtual {v5, v8, v7, v6}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    .line 114
    sub-int/2addr v4, v6

    .line 117
    invoke-static {v4, v7, v2}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v8

    .line 118
    .local v8, "inputBufferBytesToOutput":I
    invoke-virtual {p1}, Ljava/nio/ByteBuffer;->position()I

    move-result v9

    add-int/2addr v9, v8

    invoke-virtual {p1, v9}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 119
    invoke-virtual {v5, p1}, Ljava/nio/ByteBuffer;->put(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;

    .line 120
    invoke-virtual {p1, v1}, Ljava/nio/ByteBuffer;->limit(I)Ljava/nio/Buffer;

    .line 121
    sub-int/2addr v2, v8

    .line 124
    iget v9, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    sub-int/2addr v9, v6

    iput v9, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    .line 125
    iget-object v10, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    invoke-static {v10, v6, v10, v7, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 126
    iget-object v7, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBuffer:[B

    iget v9, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    invoke-virtual {p1, v7, v9, v2}, Ljava/nio/ByteBuffer;->get([BII)Ljava/nio/ByteBuffer;

    .line 127
    iget v7, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    add-int/2addr v7, v2

    iput v7, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->endBufferSize:I

    .line 129
    invoke-virtual {v5}, Ljava/nio/ByteBuffer;->flip()Ljava/nio/Buffer;

    .line 130
    return-void
.end method

.method public resetTrimmedFrameCount()V
    .locals 2

    .line 62
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimmedFrameCount:J

    .line 63
    return-void
.end method

.method public setTrimFrameCount(II)V
    .locals 0
    .param p1, "trimStartFrames"    # I
    .param p2, "trimEndFrames"    # I

    .line 56
    iput p1, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimStartFrames:I

    .line 57
    iput p2, p0, Landroidx/media3/exoplayer/audio/TrimmingAudioProcessor;->trimEndFrames:I

    .line 58
    return-void
.end method
