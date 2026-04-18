.class public final Landroidx/media3/extractor/Ac4Util;
.super Ljava/lang/Object;
.source "Ac4Util.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;
    }
.end annotation


# static fields
.field public static final AC40_SYNCWORD:I = 0xac40

.field public static final AC41_SYNCWORD:I = 0xac41

.field private static final CHANNEL_COUNT_2:I = 0x2

.field public static final HEADER_SIZE_FOR_PARSER:I = 0x10

.field public static final MAX_RATE_BYTES_PER_SECOND:I = 0x52080

.field private static final SAMPLE_COUNT:[I

.field public static final SAMPLE_HEADER_SIZE:I = 0x7


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 87
    const/16 v0, 0xe

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/extractor/Ac4Util;->SAMPLE_COUNT:[I

    return-void

    :array_0
    .array-data 4
        0x7d2
        0x7d0
        0x780
        0x641
        0x640
        0x3e9
        0x3e8
        0x3c0
        0x320
        0x320
        0x1e0
        0x190
        0x190
        0x800
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 258
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getAc4SampleHeader(ILandroidx/media3/common/util/ParsableByteArray;)V
    .locals 3
    .param p0, "size"    # I
    .param p1, "buffer"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 234
    const/4 v0, 0x7

    invoke-virtual {p1, v0}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 235
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 236
    .local v0, "data":[B
    const/4 v1, 0x0

    const/16 v2, -0x54

    aput-byte v2, v0, v1

    .line 237
    const/4 v1, 0x1

    const/16 v2, 0x40

    aput-byte v2, v0, v1

    .line 238
    const/4 v1, 0x2

    const/4 v2, -0x1

    aput-byte v2, v0, v1

    .line 239
    const/4 v1, 0x3

    aput-byte v2, v0, v1

    .line 240
    shr-int/lit8 v1, p0, 0x10

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    const/4 v2, 0x4

    aput-byte v1, v0, v2

    .line 241
    shr-int/lit8 v1, p0, 0x8

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    const/4 v2, 0x5

    aput-byte v1, v0, v2

    .line 242
    and-int/lit16 v1, p0, 0xff

    int-to-byte v1, v1

    const/4 v2, 0x6

    aput-byte v1, v0, v2

    .line 243
    return-void
.end method

.method public static parseAc4AnnexEFormat(Landroidx/media3/common/util/ParsableByteArray;Ljava/lang/String;Ljava/lang/String;Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format;
    .locals 3
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "trackId"    # Ljava/lang/String;
    .param p2, "language"    # Ljava/lang/String;
    .param p3, "drmInitData"    # Landroidx/media3/common/DrmInitData;

    .line 117
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 118
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v1

    and-int/lit8 v1, v1, 0x20

    shr-int/lit8 v1, v1, 0x5

    if-ne v1, v0, :cond_0

    const v0, 0xbb80

    goto :goto_0

    :cond_0
    const v0, 0xac44

    .line 119
    .local v0, "sampleRate":I
    :goto_0
    new-instance v1, Landroidx/media3/common/Format$Builder;

    invoke-direct {v1}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 120
    invoke-virtual {v1, p1}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 121
    const-string v2, "audio/ac4"

    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 122
    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 123
    invoke-virtual {v1, v0}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 124
    invoke-virtual {v1, p3}, Landroidx/media3/common/Format$Builder;->setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 125
    invoke-virtual {v1, p2}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 126
    invoke-virtual {v1}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v1

    .line 119
    return-object v1
.end method

.method public static parseAc4SyncframeAudioSampleCount(Ljava/nio/ByteBuffer;)I
    .locals 3
    .param p0, "buffer"    # Ljava/nio/ByteBuffer;

    .line 224
    const/16 v0, 0x10

    new-array v0, v0, [B

    .line 225
    .local v0, "bufferBytes":[B
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    .line 226
    .local v1, "position":I
    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 227
    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 228
    new-instance v2, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v2, v0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    invoke-static {v2}, Landroidx/media3/extractor/Ac4Util;->parseAc4SyncframeInfo(Landroidx/media3/common/util/ParsableBitArray;)Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;

    move-result-object v2

    iget v2, v2, Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;->sampleCount:I

    return v2
.end method

.method public static parseAc4SyncframeInfo(Landroidx/media3/common/util/ParsableBitArray;)Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;
    .locals 17
    .param p0, "data"    # Landroidx/media3/common/util/ParsableBitArray;

    .line 137
    move-object/from16 v0, p0

    const/4 v1, 0x0

    .line 138
    .local v1, "headerSize":I
    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 139
    .local v3, "syncWord":I
    const/4 v4, 0x2

    add-int/2addr v1, v4

    .line 140
    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    .line 141
    .local v2, "frameSize":I
    add-int/2addr v1, v4

    .line 142
    const v5, 0xffff

    if-ne v2, v5, :cond_0

    .line 143
    const/16 v5, 0x18

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    .line 144
    add-int/lit8 v1, v1, 0x3

    .line 146
    :cond_0
    add-int/2addr v2, v1

    .line 147
    const v5, 0xac41

    if-ne v3, v5, :cond_1

    .line 148
    add-int/lit8 v2, v2, 0x2

    .line 150
    :cond_1
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 151
    .local v5, "bitstreamVersion":I
    const/4 v6, 0x3

    if-ne v5, v6, :cond_2

    .line 152
    invoke-static {v0, v4}, Landroidx/media3/extractor/Ac4Util;->readVariableBits(Landroidx/media3/common/util/ParsableBitArray;I)I

    move-result v7

    add-int/2addr v5, v7

    move v12, v5

    goto :goto_0

    .line 151
    :cond_2
    move v12, v5

    .line 154
    .end local v5    # "bitstreamVersion":I
    .local v12, "bitstreamVersion":I
    :goto_0
    const/16 v5, 0xa

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v13

    .line 155
    .local v13, "sequenceCounter":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 156
    invoke-virtual {v0, v6}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    if-lez v5, :cond_3

    .line 157
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 160
    :cond_3
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v4

    const v5, 0xbb80

    const v7, 0xac44

    if-eqz v4, :cond_4

    move v4, v5

    goto :goto_1

    :cond_4
    move v4, v7

    .line 161
    .local v4, "sampleRate":I
    :goto_1
    const/4 v8, 0x4

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v14

    .line 162
    .local v14, "frameRateIndex":I
    const/4 v8, 0x0

    .line 163
    .local v8, "sampleCount":I
    if-ne v4, v7, :cond_5

    const/16 v7, 0xd

    if-ne v14, v7, :cond_5

    .line 164
    sget-object v5, Landroidx/media3/extractor/Ac4Util;->SAMPLE_COUNT:[I

    aget v8, v5, v14

    move v15, v8

    goto :goto_3

    .line 165
    :cond_5
    if-ne v4, v5, :cond_9

    sget-object v5, Landroidx/media3/extractor/Ac4Util;->SAMPLE_COUNT:[I

    array-length v7, v5

    if-ge v14, v7, :cond_9

    .line 166
    aget v8, v5, v14

    .line 167
    rem-int/lit8 v5, v13, 0x5

    const/16 v7, 0xb

    const/16 v9, 0x8

    packed-switch v5, :pswitch_data_0

    goto :goto_2

    .line 180
    :pswitch_0
    if-eq v14, v6, :cond_6

    if-eq v14, v9, :cond_6

    if-ne v14, v7, :cond_9

    .line 181
    :cond_6
    add-int/lit8 v8, v8, 0x1

    move v15, v8

    goto :goto_3

    .line 175
    :pswitch_1
    if-eq v14, v9, :cond_7

    if-ne v14, v7, :cond_9

    .line 176
    :cond_7
    add-int/lit8 v8, v8, 0x1

    move v15, v8

    goto :goto_3

    .line 170
    :pswitch_2
    if-eq v14, v6, :cond_8

    if-ne v14, v9, :cond_9

    .line 171
    :cond_8
    add-int/lit8 v8, v8, 0x1

    move v15, v8

    goto :goto_3

    .line 188
    :cond_9
    :goto_2
    move v15, v8

    .end local v8    # "sampleCount":I
    .local v15, "sampleCount":I
    :goto_3
    new-instance v16, Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;

    const/4 v7, 0x2

    const/4 v11, 0x0

    move-object/from16 v5, v16

    move v6, v12

    move v8, v4

    move v9, v2

    move v10, v15

    invoke-direct/range {v5 .. v11}, Landroidx/media3/extractor/Ac4Util$SyncFrameInfo;-><init>(IIIIILandroidx/media3/extractor/Ac4Util$1;)V

    return-object v16

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method public static parseAc4SyncframeSize([BI)I
    .locals 4
    .param p0, "data"    # [B
    .param p1, "syncword"    # I

    .line 199
    array-length v0, p0

    const/4 v1, 0x7

    if-ge v0, v1, :cond_0

    .line 200
    const/4 v0, -0x1

    return v0

    .line 202
    :cond_0
    const/4 v0, 0x2

    .line 203
    .local v0, "headerSize":I
    const/4 v1, 0x2

    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x8

    const/4 v3, 0x3

    aget-byte v3, p0, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    .line 204
    .local v2, "frameSize":I
    add-int/2addr v0, v1

    .line 205
    const v1, 0xffff

    if-ne v2, v1, :cond_1

    .line 206
    const/4 v1, 0x4

    aget-byte v1, p0, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x10

    const/4 v3, 0x5

    aget-byte v3, p0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x8

    or-int/2addr v1, v3

    const/4 v3, 0x6

    aget-byte v3, p0, v3

    and-int/lit16 v3, v3, 0xff

    or-int v2, v1, v3

    .line 207
    add-int/lit8 v0, v0, 0x3

    .line 209
    :cond_1
    const v1, 0xac41

    if-ne p1, v1, :cond_2

    .line 210
    add-int/lit8 v0, v0, 0x2

    .line 212
    :cond_2
    add-int/2addr v2, v0

    .line 213
    return v2
.end method

.method private static readVariableBits(Landroidx/media3/common/util/ParsableBitArray;I)I
    .locals 2
    .param p0, "data"    # Landroidx/media3/common/util/ParsableBitArray;
    .param p1, "bitsPerRead"    # I

    .line 246
    const/4 v0, 0x0

    .line 248
    .local v0, "value":I
    :goto_0
    invoke-virtual {p0, p1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    add-int/2addr v0, v1

    .line 249
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v1

    if-nez v1, :cond_0

    .line 250
    nop

    .line 255
    return v0

    .line 252
    :cond_0
    add-int/lit8 v0, v0, 0x1

    .line 253
    shl-int/2addr v0, p1

    goto :goto_0
.end method
