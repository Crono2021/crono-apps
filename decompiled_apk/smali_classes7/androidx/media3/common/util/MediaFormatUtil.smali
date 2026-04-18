.class public final Landroidx/media3/common/util/MediaFormatUtil;
.super Ljava/lang/Object;
.source "MediaFormatUtil.java"


# static fields
.field public static final KEY_MAX_BIT_RATE:Ljava/lang/String; = "max-bitrate"

.field public static final KEY_PCM_ENCODING_EXTENDED:Ljava/lang/String; = "exo-pcm-encoding-int"

.field public static final KEY_PIXEL_WIDTH_HEIGHT_RATIO_FLOAT:Ljava/lang/String; = "exo-pixel-width-height-ratio-float"

.field private static final MAX_POWER_OF_TWO_INT:I = 0x40000000


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 487
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createFormatFromMediaFormat(Landroid/media/MediaFormat;)Landroidx/media3/common/Format;
    .locals 5
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;

    .line 73
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 75
    const-string/jumbo v1, "mime"

    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 76
    const-string v1, "language"

    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 78
    const-string v1, "max-bitrate"

    const/4 v2, -0x1

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 77
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setPeakBitrate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 80
    const-string v1, "bitrate"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 79
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setAverageBitrate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 82
    const-string v1, "codecs-string"

    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 83
    const/high16 v1, -0x40800000    # -1.0f

    invoke-static {p0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getFrameRate(Landroid/media/MediaFormat;F)F

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setFrameRate(F)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 85
    const-string/jumbo v1, "width"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 84
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setWidth(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 87
    const-string v1, "height"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 86
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setHeight(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 90
    const/high16 v1, 0x3f800000    # 1.0f

    invoke-static {p0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getPixelWidthHeightRatio(Landroid/media/MediaFormat;F)F

    move-result v1

    .line 89
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setPixelWidthHeightRatio(F)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 92
    const-string v1, "max-input-size"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 91
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setMaxInputSize(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 97
    const-string/jumbo v1, "rotation-degrees"

    const/4 v3, 0x0

    invoke-static {p0, v1, v3}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 96
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setRotationDegrees(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 99
    const/4 v1, 0x1

    invoke-static {p0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getColorInfo(Landroid/media/MediaFormat;Z)Landroidx/media3/common/ColorInfo;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setColorInfo(Landroidx/media3/common/ColorInfo;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 101
    const-string/jumbo v1, "sample-rate"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 100
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 104
    const-string v1, "channel-count"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 103
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 109
    const-string/jumbo v1, "pcm-encoding"

    invoke-static {p0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v1

    .line 108
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setPcmEncoding(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 114
    .local v0, "formatBuilder":Landroidx/media3/common/Format$Builder;
    new-instance v1, Lcom/google/common/collect/ImmutableList$Builder;

    invoke-direct {v1}, Lcom/google/common/collect/ImmutableList$Builder;-><init>()V

    .line 115
    .local v1, "csdBuffers":Lcom/google/common/collect/ImmutableList$Builder;, "Lcom/google/common/collect/ImmutableList$Builder<[B>;"
    const/4 v2, 0x0

    .line 117
    .local v2, "csdIndex":I
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "csd-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Landroid/media/MediaFormat;->getByteBuffer(Ljava/lang/String;)Ljava/nio/ByteBuffer;

    move-result-object v3

    .line 118
    .local v3, "csdByteBuffer":Ljava/nio/ByteBuffer;
    if-nez v3, :cond_0

    .line 119
    nop

    .line 129
    .end local v3    # "csdByteBuffer":Ljava/nio/ByteBuffer;
    invoke-virtual {v1}, Lcom/google/common/collect/ImmutableList$Builder;->build()Lcom/google/common/collect/ImmutableList;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    .line 131
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v3

    return-object v3

    .line 121
    .restart local v3    # "csdByteBuffer":Ljava/nio/ByteBuffer;
    :cond_0
    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v4

    new-array v4, v4, [B

    .line 122
    .local v4, "csdBufferData":[B
    invoke-virtual {v3, v4}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 123
    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->rewind()Ljava/nio/Buffer;

    .line 125
    invoke-virtual {v1, v4}, Lcom/google/common/collect/ImmutableList$Builder;->add(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;

    .line 126
    nop

    .end local v3    # "csdByteBuffer":Ljava/nio/ByteBuffer;
    .end local v4    # "csdBufferData":[B
    add-int/lit8 v2, v2, 0x1

    .line 127
    goto :goto_0
.end method

.method public static createMediaFormatFromFormat(Landroidx/media3/common/Format;)Landroid/media/MediaFormat;
    .locals 4
    .param p0, "format"    # Landroidx/media3/common/Format;

    .line 146
    new-instance v0, Landroid/media/MediaFormat;

    invoke-direct {v0}, Landroid/media/MediaFormat;-><init>()V

    .line 147
    .local v0, "result":Landroid/media/MediaFormat;
    const-string v1, "bitrate"

    iget v2, p0, Landroidx/media3/common/Format;->bitrate:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 148
    const-string v1, "max-bitrate"

    iget v2, p0, Landroidx/media3/common/Format;->peakBitrate:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 149
    const-string v1, "channel-count"

    iget v2, p0, Landroidx/media3/common/Format;->channelCount:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 151
    iget-object v1, p0, Landroidx/media3/common/Format;->colorInfo:Landroidx/media3/common/ColorInfo;

    invoke-static {v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetColorInfo(Landroid/media/MediaFormat;Landroidx/media3/common/ColorInfo;)V

    .line 153
    const-string/jumbo v1, "mime"

    iget-object v2, p0, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetString(Landroid/media/MediaFormat;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    const-string v1, "codecs-string"

    iget-object v2, p0, Landroidx/media3/common/Format;->codecs:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetString(Landroid/media/MediaFormat;Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v1, "frame-rate"

    iget v2, p0, Landroidx/media3/common/Format;->frameRate:F

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetFloat(Landroid/media/MediaFormat;Ljava/lang/String;F)V

    .line 156
    const-string/jumbo v1, "width"

    iget v2, p0, Landroidx/media3/common/Format;->width:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 157
    const-string v1, "height"

    iget v2, p0, Landroidx/media3/common/Format;->height:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 159
    iget-object v1, p0, Landroidx/media3/common/Format;->initializationData:Ljava/util/List;

    invoke-static {v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->setCsdBuffers(Landroid/media/MediaFormat;Ljava/util/List;)V

    .line 160
    iget v1, p0, Landroidx/media3/common/Format;->pcmEncoding:I

    invoke-static {v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetPcmEncoding(Landroid/media/MediaFormat;I)V

    .line 161
    const-string v1, "language"

    iget-object v2, p0, Landroidx/media3/common/Format;->language:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetString(Landroid/media/MediaFormat;Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    const-string v1, "max-input-size"

    iget v2, p0, Landroidx/media3/common/Format;->maxInputSize:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 163
    const-string/jumbo v1, "sample-rate"

    iget v2, p0, Landroidx/media3/common/Format;->sampleRate:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 164
    const-string v1, "caption-service-number"

    iget v2, p0, Landroidx/media3/common/Format;->accessibilityChannel:I

    invoke-static {v0, v1, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 165
    const-string/jumbo v1, "rotation-degrees"

    iget v2, p0, Landroidx/media3/common/Format;->rotationDegrees:I

    invoke-virtual {v0, v1, v2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 167
    iget v1, p0, Landroidx/media3/common/Format;->selectionFlags:I

    .line 168
    .local v1, "selectionFlags":I
    and-int/lit8 v2, v1, 0x4

    const-string v3, "is-autoselect"

    invoke-static {v0, v3, v2}, Landroidx/media3/common/util/MediaFormatUtil;->setBooleanAsInt(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 170
    and-int/lit8 v2, v1, 0x1

    const-string v3, "is-default"

    invoke-static {v0, v3, v2}, Landroidx/media3/common/util/MediaFormatUtil;->setBooleanAsInt(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 171
    and-int/lit8 v2, v1, 0x2

    const-string v3, "is-forced-subtitle"

    invoke-static {v0, v3, v2}, Landroidx/media3/common/util/MediaFormatUtil;->setBooleanAsInt(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 174
    const-string v2, "encoder-delay"

    iget v3, p0, Landroidx/media3/common/Format;->encoderDelay:I

    invoke-virtual {v0, v2, v3}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 175
    const-string v2, "encoder-padding"

    iget v3, p0, Landroidx/media3/common/Format;->encoderPadding:I

    invoke-virtual {v0, v2, v3}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 177
    iget v2, p0, Landroidx/media3/common/Format;->pixelWidthHeightRatio:F

    invoke-static {v0, v2}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetPixelAspectRatio(Landroid/media/MediaFormat;F)V

    .line 178
    return-object v0
.end method

.method public static getArray(Ljava/nio/ByteBuffer;)[B
    .locals 1
    .param p0, "byteBuffer"    # Ljava/nio/ByteBuffer;

    .line 367
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->remaining()I

    move-result v0

    new-array v0, v0, [B

    .line 368
    .local v0, "array":[B
    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 369
    return-object v0
.end method

.method public static getColorInfo(Landroid/media/MediaFormat;)Landroidx/media3/common/ColorInfo;
    .locals 1
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;

    .line 272
    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroidx/media3/common/util/MediaFormatUtil;->getColorInfo(Landroid/media/MediaFormat;Z)Landroidx/media3/common/ColorInfo;

    move-result-object v0

    return-object v0
.end method

.method private static getColorInfo(Landroid/media/MediaFormat;Z)Landroidx/media3/common/ColorInfo;
    .locals 8
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "allowInvalidValues"    # Z

    .line 279
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x18

    const/4 v2, 0x0

    if-ge v0, v1, :cond_0

    .line 281
    return-object v2

    .line 283
    :cond_0
    nop

    .line 284
    const-string v0, "color-standard"

    const/4 v1, -0x1

    invoke-static {p0, v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v0

    .line 286
    .local v0, "colorSpace":I
    nop

    .line 287
    const-string v3, "color-range"

    invoke-static {p0, v3, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v3

    .line 288
    .local v3, "colorRange":I
    nop

    .line 289
    const-string v4, "color-transfer"

    invoke-static {p0, v4, v1}, Landroidx/media3/common/util/MediaFormatUtil;->getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I

    move-result v4

    .line 292
    .local v4, "colorTransfer":I
    const-string v5, "hdr-static-info"

    invoke-virtual {p0, v5}, Landroid/media/MediaFormat;->getByteBuffer(Ljava/lang/String;)Ljava/nio/ByteBuffer;

    move-result-object v5

    .line 295
    .local v5, "hdrStaticInfoByteBuffer":Ljava/nio/ByteBuffer;
    if-eqz v5, :cond_1

    invoke-static {v5}, Landroidx/media3/common/util/MediaFormatUtil;->getArray(Ljava/nio/ByteBuffer;)[B

    move-result-object v6

    goto :goto_0

    :cond_1
    move-object v6, v2

    .line 297
    .local v6, "hdrStaticInfo":[B
    :goto_0
    if-nez p1, :cond_4

    .line 300
    invoke-static {v0}, Landroidx/media3/common/util/MediaFormatUtil;->isValidColorSpace(I)Z

    move-result v7

    if-nez v7, :cond_2

    .line 301
    const/4 v0, -0x1

    .line 303
    :cond_2
    invoke-static {v3}, Landroidx/media3/common/util/MediaFormatUtil;->isValidColorRange(I)Z

    move-result v7

    if-nez v7, :cond_3

    .line 304
    const/4 v3, -0x1

    .line 306
    :cond_3
    invoke-static {v4}, Landroidx/media3/common/util/MediaFormatUtil;->isValidColorTransfer(I)Z

    move-result v7

    if-nez v7, :cond_4

    .line 307
    const/4 v4, -0x1

    .line 311
    :cond_4
    if-ne v0, v1, :cond_6

    if-ne v3, v1, :cond_6

    if-ne v4, v1, :cond_6

    if-eqz v6, :cond_5

    goto :goto_1

    .line 322
    :cond_5
    return-object v2

    .line 315
    :cond_6
    :goto_1
    new-instance v1, Landroidx/media3/common/ColorInfo$Builder;

    invoke-direct {v1}, Landroidx/media3/common/ColorInfo$Builder;-><init>()V

    .line 316
    invoke-virtual {v1, v0}, Landroidx/media3/common/ColorInfo$Builder;->setColorSpace(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v1

    .line 317
    invoke-virtual {v1, v3}, Landroidx/media3/common/ColorInfo$Builder;->setColorRange(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v1

    .line 318
    invoke-virtual {v1, v4}, Landroidx/media3/common/ColorInfo$Builder;->setColorTransfer(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v1

    .line 319
    invoke-virtual {v1, v6}, Landroidx/media3/common/ColorInfo$Builder;->setHdrStaticInfo([B)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v1

    .line 320
    invoke-virtual {v1}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v1

    .line 315
    return-object v1
.end method

.method public static getFloat(Landroid/media/MediaFormat;Ljava/lang/String;F)F
    .locals 1
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # F

    .line 332
    invoke-virtual {p0, p1}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Landroid/media/MediaFormat;->getFloat(Ljava/lang/String;)F

    move-result v0

    goto :goto_0

    :cond_0
    move v0, p2

    :goto_0
    return v0
.end method

.method private static getFrameRate(Landroid/media/MediaFormat;F)F
    .locals 3
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "defaultValue"    # F

    .line 342
    move v0, p1

    .line 343
    .local v0, "frameRate":F
    const-string v1, "frame-rate"

    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 345
    :try_start_0
    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getFloat(Ljava/lang/String;)F

    move-result v1
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move v0, v1

    .line 348
    goto :goto_0

    .line 346
    :catch_0
    move-exception v2

    .line 347
    .local v2, "ex":Ljava/lang/ClassCastException;
    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v1

    int-to-float v0, v1

    .line 350
    .end local v2    # "ex":Ljava/lang/ClassCastException;
    :cond_0
    :goto_0
    return v0
.end method

.method public static getInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)I
    .locals 1
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .line 327
    invoke-virtual {p0, p1}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0, p1}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    :cond_0
    move v0, p2

    :goto_0
    return v0
.end method

.method private static getPixelWidthHeightRatio(Landroid/media/MediaFormat;F)F
    .locals 3
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "defaultValue"    # F

    .line 357
    const-string/jumbo v0, "sar-width"

    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 358
    const-string/jumbo v1, "sar-height"

    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 359
    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v0

    int-to-float v0, v0

    .line 360
    invoke-virtual {p0, v1}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v0, v1

    .line 359
    return v0

    .line 363
    :cond_0
    return p1
.end method

.method public static getTimeLapseFrameRate(Landroid/media/MediaFormat;)Ljava/lang/Integer;
    .locals 2
    .param p0, "format"    # Landroid/media/MediaFormat;

    .line 385
    const-string/jumbo v0, "time-lapse-enable"

    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 386
    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v0

    if-lez v0, :cond_0

    .line 387
    const-string/jumbo v0, "time-lapse-fps"

    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 388
    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->getInteger(Ljava/lang/String;)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0

    .line 390
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method public static isAudioFormat(Landroid/media/MediaFormat;)Z
    .locals 1
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;

    .line 379
    const-string/jumbo v0, "mime"

    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/MimeTypes;->isAudio(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static isValidColorRange(I)Z
    .locals 2
    .param p0, "colorRange"    # I

    .line 470
    const/4 v0, 0x2

    const/4 v1, 0x1

    if-eq p0, v0, :cond_1

    if-eq p0, v1, :cond_1

    const/4 v0, -0x1

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :cond_1
    :goto_0
    return v1
.end method

.method private static isValidColorSpace(I)Z
    .locals 2
    .param p0, "colorSpace"    # I

    .line 461
    const/4 v0, 0x2

    const/4 v1, 0x1

    if-eq p0, v0, :cond_1

    if-eq p0, v1, :cond_1

    const/4 v0, 0x6

    if-eq p0, v0, :cond_1

    const/4 v0, -0x1

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :cond_1
    :goto_0
    return v1
.end method

.method private static isValidColorTransfer(I)Z
    .locals 2
    .param p0, "colorTransfer"    # I

    .line 480
    const/4 v0, 0x1

    if-eq p0, v0, :cond_1

    const/4 v1, 0x3

    if-eq p0, v1, :cond_1

    const/4 v1, 0x6

    if-eq p0, v1, :cond_1

    const/4 v1, 0x7

    if-eq p0, v1, :cond_1

    const/4 v1, -0x1

    if-ne p0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :cond_1
    :goto_0
    return v0
.end method

.method public static isVideoFormat(Landroid/media/MediaFormat;)Z
    .locals 1
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;

    .line 374
    const-string/jumbo v0, "mime"

    invoke-virtual {p0, v0}, Landroid/media/MediaFormat;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/MimeTypes;->isVideo(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static maybeSetByteBuffer(Landroid/media/MediaFormat;Ljava/lang/String;[B)V
    .locals 1
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # [B

    .line 242
    if-eqz p2, :cond_0

    .line 243
    invoke-static {p2}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Landroid/media/MediaFormat;->setByteBuffer(Ljava/lang/String;Ljava/nio/ByteBuffer;)V

    .line 245
    :cond_0
    return-void
.end method

.method public static maybeSetColorInfo(Landroid/media/MediaFormat;Landroidx/media3/common/ColorInfo;)V
    .locals 2
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "colorInfo"    # Landroidx/media3/common/ColorInfo;

    .line 255
    if-eqz p1, :cond_0

    .line 256
    const-string v0, "color-transfer"

    iget v1, p1, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    invoke-static {p0, v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 257
    const-string v0, "color-standard"

    iget v1, p1, Landroidx/media3/common/ColorInfo;->colorSpace:I

    invoke-static {p0, v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 258
    const-string v0, "color-range"

    iget v1, p1, Landroidx/media3/common/ColorInfo;->colorRange:I

    invoke-static {p0, v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 259
    const-string v0, "hdr-static-info"

    iget-object v1, p1, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    invoke-static {p0, v0, v1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetByteBuffer(Landroid/media/MediaFormat;Ljava/lang/String;[B)V

    .line 261
    :cond_0
    return-void
.end method

.method public static maybeSetFloat(Landroid/media/MediaFormat;Ljava/lang/String;F)V
    .locals 1
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # F

    .line 229
    const/high16 v0, -0x40800000    # -1.0f

    cmpl-float v0, p2, v0

    if-eqz v0, :cond_0

    .line 230
    invoke-virtual {p0, p1, p2}, Landroid/media/MediaFormat;->setFloat(Ljava/lang/String;F)V

    .line 232
    :cond_0
    return-void
.end method

.method public static maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    .locals 1
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .line 215
    const/4 v0, -0x1

    if-eq p2, v0, :cond_0

    .line 216
    invoke-virtual {p0, p1, p2}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 218
    :cond_0
    return-void
.end method

.method private static maybeSetPcmEncoding(Landroid/media/MediaFormat;I)V
    .locals 2
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "exoPcmEncoding"    # I

    .line 423
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 424
    return-void

    .line 427
    :cond_0
    const-string v0, "exo-pcm-encoding-int"

    invoke-static {p0, v0, p1}, Landroidx/media3/common/util/MediaFormatUtil;->maybeSetInteger(Landroid/media/MediaFormat;Ljava/lang/String;I)V

    .line 428
    sparse-switch p1, :sswitch_data_0

    .line 453
    return-void

    .line 442
    :sswitch_0
    const/16 v0, 0x16

    .line 443
    .local v0, "mediaFormatPcmEncoding":I
    goto :goto_0

    .line 439
    .end local v0    # "mediaFormatPcmEncoding":I
    :sswitch_1
    const/16 v0, 0x15

    .line 440
    .restart local v0    # "mediaFormatPcmEncoding":I
    goto :goto_0

    .line 436
    .end local v0    # "mediaFormatPcmEncoding":I
    :sswitch_2
    const/4 v0, 0x4

    .line 437
    .restart local v0    # "mediaFormatPcmEncoding":I
    goto :goto_0

    .line 430
    .end local v0    # "mediaFormatPcmEncoding":I
    :sswitch_3
    const/4 v0, 0x3

    .line 431
    .restart local v0    # "mediaFormatPcmEncoding":I
    goto :goto_0

    .line 433
    .end local v0    # "mediaFormatPcmEncoding":I
    :sswitch_4
    const/4 v0, 0x2

    .line 434
    .restart local v0    # "mediaFormatPcmEncoding":I
    goto :goto_0

    .line 445
    .end local v0    # "mediaFormatPcmEncoding":I
    :sswitch_5
    const/4 v0, 0x0

    .line 446
    .restart local v0    # "mediaFormatPcmEncoding":I
    nop

    .line 455
    :goto_0
    const-string/jumbo v1, "pcm-encoding"

    invoke-virtual {p0, v1, v0}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 456
    return-void

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_5
        0x2 -> :sswitch_4
        0x3 -> :sswitch_3
        0x4 -> :sswitch_2
        0x15 -> :sswitch_1
        0x16 -> :sswitch_0
    .end sparse-switch
.end method

.method private static maybeSetPixelAspectRatio(Landroid/media/MediaFormat;F)V
    .locals 4
    .param p0, "mediaFormat"    # Landroid/media/MediaFormat;
    .param p1, "pixelWidthHeightRatio"    # F

    .line 404
    const-string v0, "exo-pixel-width-height-ratio-float"

    invoke-virtual {p0, v0, p1}, Landroid/media/MediaFormat;->setFloat(Ljava/lang/String;F)V

    .line 405
    const/4 v0, 0x1

    .line 406
    .local v0, "pixelAspectRatioWidth":I
    const/4 v1, 0x1

    .line 409
    .local v1, "pixelAspectRatioHeight":I
    const/high16 v2, 0x3f800000    # 1.0f

    cmpg-float v3, p1, v2

    if-gez v3, :cond_0

    .line 410
    const/high16 v1, 0x40000000    # 2.0f

    .line 411
    int-to-float v2, v1

    mul-float/2addr v2, p1

    float-to-int v0, v2

    goto :goto_0

    .line 412
    :cond_0
    cmpl-float v2, p1, v2

    if-lez v2, :cond_1

    .line 413
    const/high16 v0, 0x40000000    # 2.0f

    .line 414
    int-to-float v2, v0

    div-float/2addr v2, p1

    float-to-int v1, v2

    .line 416
    :cond_1
    :goto_0
    const-string/jumbo v2, "sar-width"

    invoke-virtual {p0, v2, v0}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 417
    const-string/jumbo v2, "sar-height"

    invoke-virtual {p0, v2, v1}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 418
    return-void
.end method

.method public static maybeSetString(Landroid/media/MediaFormat;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .line 189
    if-eqz p2, :cond_0

    .line 190
    invoke-virtual {p0, p1, p2}, Landroid/media/MediaFormat;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    :cond_0
    return-void
.end method

.method private static setBooleanAsInt(Landroid/media/MediaFormat;Ljava/lang/String;I)V
    .locals 1
    .param p0, "format"    # Landroid/media/MediaFormat;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .line 397
    if-eqz p2, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, p1, v0}, Landroid/media/MediaFormat;->setInteger(Ljava/lang/String;I)V

    .line 398
    return-void
.end method

.method public static setCsdBuffers(Landroid/media/MediaFormat;Ljava/util/List;)V
    .locals 3
    .param p0, "format"    # Landroid/media/MediaFormat;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/media/MediaFormat;",
            "Ljava/util/List<",
            "[B>;)V"
        }
    .end annotation

    .line 201
    .local p1, "csdBuffers":Ljava/util/List;, "Ljava/util/List<[B>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    if-ge v0, v1, :cond_0

    .line 202
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "csd-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [B

    invoke-static {v2}, Ljava/nio/ByteBuffer;->wrap([B)Ljava/nio/ByteBuffer;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Landroid/media/MediaFormat;->setByteBuffer(Ljava/lang/String;Ljava/nio/ByteBuffer;)V

    .line 201
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 204
    .end local v0    # "i":I
    :cond_0
    return-void
.end method
