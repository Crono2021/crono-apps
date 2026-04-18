.class public final Landroidx/media3/extractor/DtsUtil;
.super Ljava/lang/Object;
.source "DtsUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/DtsUtil$DtsHeader;,
        Landroidx/media3/extractor/DtsUtil$FrameType;,
        Landroidx/media3/extractor/DtsUtil$DtsAudioMimeType;
    }
.end annotation


# static fields
.field private static final CHANNELS_BY_AMODE:[I

.field public static final DTS_EXPRESS_MAX_RATE_BITS_PER_SECOND:I = 0xbb800

.field public static final DTS_HD_MAX_RATE_BYTES_PER_SECOND:I = 0x225510

.field public static final DTS_MAX_RATE_BYTES_PER_SECOND:I = 0x2ee00

.field private static final FIRST_BYTE_14B_BE:B = 0x1ft

.field private static final FIRST_BYTE_14B_LE:B = -0x1t

.field private static final FIRST_BYTE_BE:B = 0x7ft

.field private static final FIRST_BYTE_EXTSS_BE:B = 0x64t

.field private static final FIRST_BYTE_EXTSS_LE:B = 0x25t

.field private static final FIRST_BYTE_LE:B = -0x2t

.field private static final FIRST_BYTE_UHD_FTOC_NONSYNC_BE:B = 0x71t

.field private static final FIRST_BYTE_UHD_FTOC_NONSYNC_LE:B = -0x18t

.field private static final FIRST_BYTE_UHD_FTOC_SYNC_BE:B = 0x40t

.field private static final FIRST_BYTE_UHD_FTOC_SYNC_LE:B = -0xet

.field public static final FRAME_TYPE_CORE:I = 0x1

.field public static final FRAME_TYPE_EXTENSION_SUBSTREAM:I = 0x2

.field public static final FRAME_TYPE_UHD_NON_SYNC:I = 0x4

.field public static final FRAME_TYPE_UHD_SYNC:I = 0x3

.field public static final FRAME_TYPE_UNKNOWN:I = 0x0

.field private static final SAMPLE_RATE_BY_INDEX:[I

.field private static final SAMPLE_RATE_BY_SFREQ:[I

.field private static final SYNC_VALUE_14B_BE:I = 0x1fffe800

.field private static final SYNC_VALUE_14B_LE:I = -0xe0ff18

.field private static final SYNC_VALUE_BE:I = 0x7ffe8001

.field private static final SYNC_VALUE_EXTSS_BE:I = 0x64582025

.field private static final SYNC_VALUE_EXTSS_LE:I = 0x25205864

.field private static final SYNC_VALUE_LE:I = -0x180fe80

.field private static final SYNC_VALUE_UHD_FTOC_NONSYNC_BE:I = 0x71c442e8

.field private static final SYNC_VALUE_UHD_FTOC_NONSYNC_LE:I = -0x17bd3b8f

.field private static final SYNC_VALUE_UHD_FTOC_SYNC_BE:I = 0x40411bf2

.field private static final SYNC_VALUE_UHD_FTOC_SYNC_LE:I = -0xde4bec0

.field private static final TWICE_BITRATE_KBPS_BY_RATE:[I

.field private static final UHD_AUDIO_CHUNK_ID_LENGTH_TABLE:[I

.field private static final UHD_AUDIO_CHUNK_SIZE_LENGTH_TABLE:[I

.field private static final UHD_FTOC_PAYLOAD_LENGTH_TABLE:[I

.field private static final UHD_HEADER_SIZE_LENGTH_TABLE:[I

.field private static final UHD_METADATA_CHUNK_SIZE_LENGTH_TABLE:[I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .line 192
    const/16 v0, 0x10

    new-array v1, v0, [I

    fill-array-data v1, :array_0

    sput-object v1, Landroidx/media3/extractor/DtsUtil;->CHANNELS_BY_AMODE:[I

    .line 196
    new-array v1, v0, [I

    fill-array-data v1, :array_1

    sput-object v1, Landroidx/media3/extractor/DtsUtil;->SAMPLE_RATE_BY_SFREQ:[I

    .line 203
    const/16 v1, 0x1d

    new-array v1, v1, [I

    fill-array-data v1, :array_2

    sput-object v1, Landroidx/media3/extractor/DtsUtil;->TWICE_BITRATE_KBPS_BY_RATE:[I

    .line 213
    new-array v1, v0, [I

    fill-array-data v1, :array_3

    sput-object v1, Landroidx/media3/extractor/DtsUtil;->SAMPLE_RATE_BY_INDEX:[I

    .line 223
    const/4 v1, 0x5

    const/16 v2, 0x8

    const/16 v3, 0xa

    const/16 v4, 0xc

    filled-new-array {v1, v2, v3, v4}, [I

    move-result-object v5

    sput-object v5, Landroidx/media3/extractor/DtsUtil;->UHD_FTOC_PAYLOAD_LENGTH_TABLE:[I

    .line 226
    const/16 v5, 0xf

    const/4 v6, 0x6

    const/16 v7, 0x9

    filled-new-array {v6, v7, v4, v5}, [I

    move-result-object v5

    sput-object v5, Landroidx/media3/extractor/DtsUtil;->UHD_METADATA_CHUNK_SIZE_LENGTH_TABLE:[I

    .line 229
    const/4 v5, 0x2

    const/4 v8, 0x4

    filled-new-array {v5, v8, v6, v2}, [I

    move-result-object v5

    sput-object v5, Landroidx/media3/extractor/DtsUtil;->UHD_AUDIO_CHUNK_ID_LENGTH_TABLE:[I

    .line 232
    const/16 v5, 0xb

    const/16 v6, 0xd

    filled-new-array {v7, v5, v6, v0}, [I

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/DtsUtil;->UHD_AUDIO_CHUNK_SIZE_LENGTH_TABLE:[I

    .line 235
    filled-new-array {v1, v2, v3, v4}, [I

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/DtsUtil;->UHD_HEADER_SIZE_LENGTH_TABLE:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x1
        0x2
        0x2
        0x2
        0x2
        0x3
        0x3
        0x4
        0x4
        0x5
        0x6
        0x6
        0x6
        0x7
        0x8
        0x8
    .end array-data

    :array_1
    .array-data 4
        -0x1
        0x1f40
        0x3e80
        0x7d00
        -0x1
        -0x1
        0x2b11
        0x5622
        0xac44
        -0x1
        -0x1
        0x2ee0
        0x5dc0
        0xbb80
        -0x1
        -0x1
    .end array-data

    :array_2
    .array-data 4
        0x40
        0x70
        0x80
        0xc0
        0xe0
        0x100
        0x180
        0x1c0
        0x200
        0x280
        0x300
        0x380
        0x400
        0x480
        0x500
        0x600
        0x780
        0x800
        0x900
        0xa00
        0xa80
        0xb00
        0xb07
        0xb80
        0xc00
        0xf00
        0x1000
        0x1800
        0x1e00
    .end array-data

    :array_3
    .array-data 4
        0x1f40
        0x3e80
        0x7d00
        0xfa00
        0x1f400
        0x5622
        0xac44
        0x15888
        0x2b110
        0x56220
        0x2ee0
        0x5dc0
        0xbb80
        0x17700
        0x2ee00
        0x5dc00
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 758
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static checkCrc([BI)V
    .locals 5
    .param p0, "frame"    # [B
    .param p1, "sizeInBytes"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 685
    const v0, 0xffff

    .line 686
    .local v0, "initialValue":I
    add-int/lit8 v1, p1, -0x2

    aget-byte v1, p0, v1

    shl-int/lit8 v1, v1, 0x8

    and-int/2addr v1, v0

    add-int/lit8 v2, p1, -0x1

    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xff

    or-int/2addr v1, v2

    .line 688
    .local v1, "extractedCrc":I
    const/4 v2, 0x0

    add-int/lit8 v3, p1, -0x2

    invoke-static {p0, v2, v3, v0}, Landroidx/media3/common/util/Util;->crc16([BIII)I

    move-result v2

    .line 689
    .local v2, "calculatedCrc":I
    if-ne v1, v2, :cond_0

    .line 693
    return-void

    .line 690
    :cond_0
    const-string v3, "CRC check failed"

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3
.end method

.method public static getDtsFrameSize([B)I
    .locals 5
    .param p0, "data"    # [B

    .line 371
    const/4 v0, 0x0

    .line 372
    .local v0, "uses14BitPerWord":Z
    const/4 v1, 0x0

    aget-byte v1, p0, v1

    const/4 v2, 0x6

    const/4 v3, 0x7

    const/4 v4, 0x4

    sparse-switch v1, :sswitch_data_0

    .line 386
    const/4 v1, 0x5

    aget-byte v1, p0, v1

    and-int/lit8 v1, v1, 0x3

    shl-int/lit8 v1, v1, 0xc

    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/2addr v2, v4

    or-int/2addr v1, v2

    aget-byte v2, p0, v3

    and-int/lit16 v2, v2, 0xf0

    shr-int/2addr v2, v4

    or-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    .local v1, "fsize":I
    goto :goto_0

    .line 374
    .end local v1    # "fsize":I
    :sswitch_0
    aget-byte v1, p0, v2

    and-int/lit8 v1, v1, 0x3

    shl-int/lit8 v1, v1, 0xc

    aget-byte v2, p0, v3

    and-int/lit16 v2, v2, 0xff

    shl-int/2addr v2, v4

    or-int/2addr v1, v2

    const/16 v2, 0x8

    aget-byte v2, p0, v2

    and-int/lit8 v2, v2, 0x3c

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    .line 375
    .restart local v1    # "fsize":I
    const/4 v0, 0x1

    .line 376
    goto :goto_0

    .line 381
    .end local v1    # "fsize":I
    :sswitch_1
    aget-byte v1, p0, v3

    and-int/lit8 v1, v1, 0x3

    shl-int/lit8 v1, v1, 0xc

    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xff

    shl-int/2addr v2, v4

    or-int/2addr v1, v2

    const/16 v2, 0x9

    aget-byte v2, p0, v2

    and-int/lit8 v2, v2, 0x3c

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    .line 382
    .restart local v1    # "fsize":I
    const/4 v0, 0x1

    .line 383
    goto :goto_0

    .line 378
    .end local v1    # "fsize":I
    :sswitch_2
    aget-byte v1, p0, v4

    and-int/lit8 v1, v1, 0x3

    shl-int/lit8 v1, v1, 0xc

    aget-byte v3, p0, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/2addr v3, v4

    or-int/2addr v1, v3

    aget-byte v2, p0, v2

    and-int/lit16 v2, v2, 0xf0

    shr-int/2addr v2, v4

    or-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    .line 379
    .restart local v1    # "fsize":I
    nop

    .line 390
    :goto_0
    if-eqz v0, :cond_0

    mul-int/lit8 v2, v1, 0x10

    div-int/lit8 v2, v2, 0xe

    goto :goto_1

    :cond_0
    move v2, v1

    :goto_1
    return v2

    :sswitch_data_0
    .sparse-switch
        -0x2 -> :sswitch_2
        -0x1 -> :sswitch_1
        0x1f -> :sswitch_0
    .end sparse-switch
.end method

.method public static getFrameType(I)I
    .locals 1
    .param p0, "word"    # I

    .line 242
    const v0, 0x7ffe8001

    if-eq p0, v0, :cond_7

    const v0, -0x180fe80

    if-eq p0, v0, :cond_7

    const v0, 0x1fffe800

    if-eq p0, v0, :cond_7

    const v0, -0xe0ff18

    if-ne p0, v0, :cond_0

    goto :goto_3

    .line 247
    :cond_0
    const v0, 0x64582025

    if-eq p0, v0, :cond_6

    const v0, 0x25205864

    if-ne p0, v0, :cond_1

    goto :goto_2

    .line 249
    :cond_1
    const v0, 0x40411bf2

    if-eq p0, v0, :cond_5

    const v0, -0xde4bec0

    if-ne p0, v0, :cond_2

    goto :goto_1

    .line 251
    :cond_2
    const v0, 0x71c442e8

    if-eq p0, v0, :cond_4

    const v0, -0x17bd3b8f

    if-ne p0, v0, :cond_3

    goto :goto_0

    .line 254
    :cond_3
    const/4 v0, 0x0

    return v0

    .line 252
    :cond_4
    :goto_0
    const/4 v0, 0x4

    return v0

    .line 250
    :cond_5
    :goto_1
    const/4 v0, 0x3

    return v0

    .line 248
    :cond_6
    :goto_2
    const/4 v0, 0x2

    return v0

    .line 246
    :cond_7
    :goto_3
    const/4 v0, 0x1

    return v0
.end method

.method private static getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;
    .locals 4
    .param p0, "frame"    # [B

    .line 720
    const/4 v0, 0x0

    aget-byte v1, p0, v0

    const/16 v2, 0x7f

    if-eq v1, v2, :cond_3

    aget-byte v1, p0, v0

    const/16 v2, 0x64

    if-eq v1, v2, :cond_3

    aget-byte v1, p0, v0

    const/16 v2, 0x40

    if-eq v1, v2, :cond_3

    aget-byte v1, p0, v0

    const/16 v2, 0x71

    if-ne v1, v2, :cond_0

    goto :goto_2

    .line 728
    :cond_0
    array-length v1, p0

    invoke-static {p0, v1}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object p0

    .line 729
    invoke-static {p0}, Landroidx/media3/extractor/DtsUtil;->isLittleEndianFrameHeader([B)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 731
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    add-int/lit8 v2, v2, -0x1

    if-ge v1, v2, :cond_1

    .line 732
    aget-byte v2, p0, v1

    .line 733
    .local v2, "temp":B
    add-int/lit8 v3, v1, 0x1

    aget-byte v3, p0, v3

    aput-byte v3, p0, v1

    .line 734
    add-int/lit8 v3, v1, 0x1

    aput-byte v2, p0, v3

    .line 731
    .end local v2    # "temp":B
    add-int/lit8 v1, v1, 0x2

    goto :goto_0

    .line 737
    .end local v1    # "i":I
    :cond_1
    new-instance v1, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v1, p0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    .line 738
    .local v1, "frameBits":Landroidx/media3/common/util/ParsableBitArray;
    aget-byte v0, p0, v0

    const/16 v2, 0x1f

    if-ne v0, v2, :cond_2

    .line 740
    new-instance v0, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v0, p0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    .line 741
    .local v0, "scratchBits":Landroidx/media3/common/util/ParsableBitArray;
    :goto_1
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->bitsLeft()I

    move-result v2

    const/16 v3, 0x10

    if-lt v2, v3, :cond_2

    .line 742
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 743
    const/16 v2, 0xe

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    invoke-virtual {v1, v3, v2}, Landroidx/media3/common/util/ParsableBitArray;->putInt(II)V

    goto :goto_1

    .line 746
    .end local v0    # "scratchBits":Landroidx/media3/common/util/ParsableBitArray;
    :cond_2
    invoke-virtual {v1, p0}, Landroidx/media3/common/util/ParsableBitArray;->reset([B)V

    .line 747
    return-object v1

    .line 725
    .end local v1    # "frameBits":Landroidx/media3/common/util/ParsableBitArray;
    :cond_3
    :goto_2
    new-instance v0, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v0, p0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    return-object v0
.end method

.method private static isLittleEndianFrameHeader([B)Z
    .locals 3
    .param p0, "frameHeader"    # [B

    .line 751
    const/4 v0, 0x0

    aget-byte v1, p0, v0

    const/4 v2, -0x2

    if-eq v1, v2, :cond_0

    aget-byte v1, p0, v0

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    aget-byte v1, p0, v0

    const/16 v2, 0x25

    if-eq v1, v2, :cond_0

    aget-byte v1, p0, v0

    const/16 v2, -0xe

    if-eq v1, v2, :cond_0

    aget-byte v1, p0, v0

    const/16 v2, -0x18

    if-ne v1, v2, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    return v0
.end method

.method public static parseDtsAudioSampleCount(Ljava/nio/ByteBuffer;)I
    .locals 3
    .param p0, "buffer"    # Ljava/nio/ByteBuffer;

    .line 332
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->getInt(I)I

    move-result v1

    const v2, -0xde4bec0

    if-eq v1, v2, :cond_2

    .line 333
    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->getInt(I)I

    move-result v1

    const v2, -0x17bd3b8f

    if-ne v1, v2, :cond_0

    goto :goto_1

    .line 337
    :cond_0
    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->getInt(I)I

    move-result v0

    const v1, 0x25205864

    if-ne v0, v1, :cond_1

    .line 340
    const/16 v0, 0x1000

    return v0

    .line 344
    :cond_1
    invoke-virtual {p0}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    .line 346
    .local v0, "position":I
    invoke-virtual {p0, v0}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    sparse-switch v1, :sswitch_data_0

    .line 358
    add-int/lit8 v1, v0, 0x4

    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    and-int/lit8 v1, v1, 0x1

    shl-int/lit8 v1, v1, 0x6

    add-int/lit8 v2, v0, 0x5

    invoke-virtual {p0, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    and-int/lit16 v2, v2, 0xfc

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    .local v1, "nblks":I
    goto :goto_0

    .line 354
    .end local v1    # "nblks":I
    :sswitch_0
    add-int/lit8 v1, v0, 0x5

    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    and-int/lit8 v1, v1, 0x7

    shl-int/lit8 v1, v1, 0x4

    add-int/lit8 v2, v0, 0x6

    invoke-virtual {p0, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    and-int/lit8 v2, v2, 0x3c

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    .line 355
    .restart local v1    # "nblks":I
    goto :goto_0

    .line 351
    .end local v1    # "nblks":I
    :sswitch_1
    add-int/lit8 v1, v0, 0x4

    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    and-int/lit8 v1, v1, 0x7

    shl-int/lit8 v1, v1, 0x4

    add-int/lit8 v2, v0, 0x7

    invoke-virtual {p0, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    and-int/lit8 v2, v2, 0x3c

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    .line 352
    .restart local v1    # "nblks":I
    goto :goto_0

    .line 348
    .end local v1    # "nblks":I
    :sswitch_2
    add-int/lit8 v1, v0, 0x5

    invoke-virtual {p0, v1}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v1

    and-int/lit8 v1, v1, 0x1

    shl-int/lit8 v1, v1, 0x6

    add-int/lit8 v2, v0, 0x4

    invoke-virtual {p0, v2}, Ljava/nio/ByteBuffer;->get(I)B

    move-result v2

    and-int/lit16 v2, v2, 0xfc

    shr-int/lit8 v2, v2, 0x2

    or-int/2addr v1, v2

    .line 349
    .restart local v1    # "nblks":I
    nop

    .line 360
    :goto_0
    add-int/lit8 v2, v1, 0x1

    mul-int/lit8 v2, v2, 0x20

    return v2

    .line 336
    .end local v0    # "position":I
    .end local v1    # "nblks":I
    :cond_2
    :goto_1
    const/16 v0, 0x400

    return v0

    nop

    :sswitch_data_0
    .sparse-switch
        -0x2 -> :sswitch_2
        -0x1 -> :sswitch_1
        0x1f -> :sswitch_0
    .end sparse-switch
.end method

.method public static parseDtsAudioSampleCount([B)I
    .locals 5
    .param p0, "data"    # [B

    .line 307
    const/4 v0, 0x0

    aget-byte v0, p0, v0

    const/4 v1, 0x7

    const/4 v2, 0x6

    const/4 v3, 0x5

    const/4 v4, 0x4

    sparse-switch v0, :sswitch_data_0

    .line 319
    aget-byte v0, p0, v4

    and-int/lit8 v0, v0, 0x1

    shl-int/2addr v0, v2

    aget-byte v1, p0, v3

    and-int/lit16 v1, v1, 0xfc

    shr-int/lit8 v1, v1, 0x2

    or-int/2addr v0, v1

    .local v0, "nblks":I
    goto :goto_0

    .line 315
    .end local v0    # "nblks":I
    :sswitch_0
    aget-byte v0, p0, v3

    and-int/2addr v0, v1

    shl-int/2addr v0, v4

    aget-byte v1, p0, v2

    and-int/lit8 v1, v1, 0x3c

    shr-int/lit8 v1, v1, 0x2

    or-int/2addr v0, v1

    .line 316
    .restart local v0    # "nblks":I
    goto :goto_0

    .line 312
    .end local v0    # "nblks":I
    :sswitch_1
    aget-byte v0, p0, v4

    and-int/2addr v0, v1

    shl-int/2addr v0, v4

    aget-byte v1, p0, v1

    and-int/lit8 v1, v1, 0x3c

    shr-int/lit8 v1, v1, 0x2

    or-int/2addr v0, v1

    .line 313
    .restart local v0    # "nblks":I
    goto :goto_0

    .line 309
    .end local v0    # "nblks":I
    :sswitch_2
    aget-byte v0, p0, v3

    and-int/lit8 v0, v0, 0x1

    shl-int/2addr v0, v2

    aget-byte v1, p0, v4

    and-int/lit16 v1, v1, 0xfc

    shr-int/lit8 v1, v1, 0x2

    or-int/2addr v0, v1

    .line 310
    .restart local v0    # "nblks":I
    nop

    .line 321
    :goto_0
    add-int/lit8 v1, v0, 0x1

    mul-int/lit8 v1, v1, 0x20

    return v1

    nop

    :sswitch_data_0
    .sparse-switch
        -0x2 -> :sswitch_2
        -0x1 -> :sswitch_1
        0x1f -> :sswitch_0
    .end sparse-switch
.end method

.method public static parseDtsFormat([BLjava/lang/String;Ljava/lang/String;ILandroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format;
    .locals 9
    .param p0, "frame"    # [B
    .param p1, "trackId"    # Ljava/lang/String;
    .param p2, "language"    # Ljava/lang/String;
    .param p3, "roleFlags"    # I
    .param p4, "drmInitData"    # Landroidx/media3/common/DrmInitData;

    .line 274
    invoke-static {p0}, Landroidx/media3/extractor/DtsUtil;->getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;

    move-result-object v0

    .line 275
    .local v0, "frameBits":Landroidx/media3/common/util/ParsableBitArray;
    const/16 v1, 0x3c

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 276
    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    .line 277
    .local v1, "amode":I
    sget-object v2, Landroidx/media3/extractor/DtsUtil;->CHANNELS_BY_AMODE:[I

    aget v2, v2, v1

    .line 278
    .local v2, "channelCount":I
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 279
    .local v3, "sfreq":I
    sget-object v4, Landroidx/media3/extractor/DtsUtil;->SAMPLE_RATE_BY_SFREQ:[I

    aget v4, v4, v3

    .line 280
    .local v4, "sampleRate":I
    const/4 v5, 0x5

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 282
    .local v5, "rate":I
    sget-object v6, Landroidx/media3/extractor/DtsUtil;->TWICE_BITRATE_KBPS_BY_RATE:[I

    array-length v7, v6

    const/4 v8, 0x2

    if-lt v5, v7, :cond_0

    .line 283
    const/4 v6, -0x1

    goto :goto_0

    .line 284
    :cond_0
    aget v6, v6, v5

    mul-int/lit16 v6, v6, 0x3e8

    div-int/2addr v6, v8

    :goto_0
    nop

    .line 285
    .local v6, "bitrate":I
    const/16 v7, 0xa

    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 286
    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v7

    if-lez v7, :cond_1

    const/4 v7, 0x1

    goto :goto_1

    :cond_1
    const/4 v7, 0x0

    :goto_1
    add-int/2addr v2, v7

    .line 287
    new-instance v7, Landroidx/media3/common/Format$Builder;

    invoke-direct {v7}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 288
    invoke-virtual {v7, p1}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 289
    const-string v8, "audio/vnd.dts"

    invoke-virtual {v7, v8}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 290
    invoke-virtual {v7, v6}, Landroidx/media3/common/Format$Builder;->setAverageBitrate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 291
    invoke-virtual {v7, v2}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 292
    invoke-virtual {v7, v4}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 293
    invoke-virtual {v7, p4}, Landroidx/media3/common/Format$Builder;->setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 294
    invoke-virtual {v7, p2}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 295
    invoke-virtual {v7, p3}, Landroidx/media3/common/Format$Builder;->setRoleFlags(I)Landroidx/media3/common/Format$Builder;

    move-result-object v7

    .line 296
    invoke-virtual {v7}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v7

    .line 287
    return-object v7
.end method

.method public static parseDtsHdHeader([B)Landroidx/media3/extractor/DtsUtil$DtsHeader;
    .locals 24
    .param p0, "header"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 401
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/DtsUtil;->getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;

    move-result-object v0

    .line 402
    .local v0, "headerBits":Landroidx/media3/common/util/ParsableBitArray;
    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 404
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    .line 407
    .local v2, "extensionSubstreamIndex":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v3

    if-nez v3, :cond_0

    .line 408
    const/16 v3, 0x8

    .line 409
    .local v3, "headerSizeInBits":I
    const/16 v4, 0x10

    .local v4, "extensionSubstreamFrameSizeBits":I
    goto :goto_0

    .line 411
    .end local v3    # "headerSizeInBits":I
    .end local v4    # "extensionSubstreamFrameSizeBits":I
    :cond_0
    const/16 v3, 0xc

    .line 412
    .restart local v3    # "headerSizeInBits":I
    const/16 v4, 0x14

    .line 414
    .restart local v4    # "extensionSubstreamFrameSizeBits":I
    :goto_0
    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 415
    nop

    .line 416
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    const/4 v6, 0x1

    add-int/2addr v5, v6

    .line 422
    .local v5, "extensionSubstreamFrameSize":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v16

    .line 423
    .local v16, "staticFieldsPresent":Z
    const/16 v7, 0x8

    if-eqz v16, :cond_6

    .line 424
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v8

    .line 425
    .local v8, "referenceClockCode":I
    const/4 v9, 0x3

    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v10

    add-int/2addr v10, v6

    mul-int/lit16 v10, v10, 0x200

    .line 427
    .local v10, "extensionSubstreamFrameDurationCode":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v11

    if-eqz v11, :cond_1

    .line 428
    const/16 v11, 0x24

    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 431
    :cond_1
    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v11

    add-int/2addr v11, v6

    .line 432
    .local v11, "audioPresentationsCount":I
    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v9

    add-int/2addr v9, v6

    .line 433
    .local v9, "assetsCount":I
    if-ne v11, v6, :cond_5

    if-ne v9, v6, :cond_5

    .line 439
    add-int/lit8 v12, v2, 0x1

    .line 440
    invoke-virtual {v0, v12}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v12

    .line 442
    .local v12, "activeExtensionSubstreamMask":I
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_1
    add-int/lit8 v14, v2, 0x1

    if-ge v13, v14, :cond_3

    .line 443
    shr-int v14, v12, v13

    and-int/2addr v14, v6

    if-ne v14, v6, :cond_2

    .line 444
    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 442
    :cond_2
    add-int/lit8 v13, v13, 0x1

    goto :goto_1

    .line 448
    .end local v13    # "i":I
    :cond_3
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v13

    if-eqz v13, :cond_4

    .line 449
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 450
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v13

    add-int/2addr v13, v6

    shl-int/2addr v13, v1

    .line 451
    .local v13, "mixerOutputMaskBits":I
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    add-int/2addr v1, v6

    .line 453
    .local v1, "mixerOutputConfigurationCount":I
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_2
    if-ge v14, v1, :cond_4

    .line 454
    invoke-virtual {v0, v13}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 453
    add-int/lit8 v14, v14, 0x1

    goto :goto_2

    .line 457
    .end local v1    # "mixerOutputConfigurationCount":I
    .end local v11    # "audioPresentationsCount":I
    .end local v12    # "activeExtensionSubstreamMask":I
    .end local v13    # "mixerOutputMaskBits":I
    .end local v14    # "i":I
    :cond_4
    move v1, v8

    move v15, v10

    goto :goto_3

    .line 434
    .restart local v11    # "audioPresentationsCount":I
    :cond_5
    const-string v1, "Multiple audio presentations or assets not supported"

    invoke-static {v1}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v1

    throw v1

    .line 460
    .end local v8    # "referenceClockCode":I
    .end local v9    # "assetsCount":I
    .end local v10    # "extensionSubstreamFrameDurationCode":I
    .end local v11    # "audioPresentationsCount":I
    :cond_6
    const/4 v8, -0x1

    .line 461
    .restart local v8    # "referenceClockCode":I
    const/4 v10, 0x0

    move v1, v8

    move v15, v10

    .line 465
    .end local v8    # "referenceClockCode":I
    .local v1, "referenceClockCode":I
    .local v15, "extensionSubstreamFrameDurationCode":I
    :goto_3
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 466
    const v8, -0x7fffffff

    .line 467
    .local v8, "sampleRate":I
    const/4 v9, -0x1

    .line 470
    .local v9, "channelCount":I
    const/16 v10, 0xc

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 471
    if-eqz v16, :cond_a

    .line 472
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v10

    const/4 v11, 0x4

    if-eqz v10, :cond_7

    .line 473
    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 475
    :cond_7
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v10

    if-eqz v10, :cond_8

    .line 476
    const/16 v10, 0x18

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 478
    :cond_8
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v10

    if-eqz v10, :cond_9

    .line 479
    const/16 v10, 0xa

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v10

    add-int/2addr v10, v6

    .line 480
    .local v10, "infoTextByteSize":I
    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->skipBytes(I)V

    .line 482
    .end local v10    # "infoTextByteSize":I
    :cond_9
    const/4 v10, 0x5

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 483
    sget-object v10, Landroidx/media3/extractor/DtsUtil;->SAMPLE_RATE_BY_INDEX:[I

    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v11

    aget v8, v10, v11

    .line 484
    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v7

    add-int/lit8 v9, v7, 0x1

    move v6, v8

    move/from16 v17, v9

    goto :goto_4

    .line 471
    :cond_a
    move v6, v8

    move/from16 v17, v9

    .line 488
    .end local v8    # "sampleRate":I
    .end local v9    # "channelCount":I
    .local v6, "sampleRate":I
    .local v17, "channelCount":I
    :goto_4
    const-wide v7, -0x7fffffffffffffffL    # -4.9E-324

    .line 489
    .local v7, "frameDurationUs":J
    if-eqz v16, :cond_b

    .line 492
    packed-switch v1, :pswitch_data_0

    .line 503
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Unsupported reference clock code in DTS HD header: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    invoke-static {v9, v10}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v9

    throw v9

    .line 500
    :pswitch_0
    const v9, 0xbb80

    .line 501
    .local v9, "referenceClockFrequency":I
    goto :goto_5

    .line 497
    .end local v9    # "referenceClockFrequency":I
    :pswitch_1
    const v9, 0xac44

    .line 498
    .restart local v9    # "referenceClockFrequency":I
    goto :goto_5

    .line 494
    .end local v9    # "referenceClockFrequency":I
    :pswitch_2
    const/16 v9, 0x7d00

    .line 495
    .restart local v9    # "referenceClockFrequency":I
    nop

    .line 508
    :goto_5
    int-to-long v10, v15

    const-wide/32 v20, 0xf4240

    int-to-long v12, v9

    .line 509
    move-wide/from16 v18, v10

    move-wide/from16 v22, v12

    invoke-static/range {v18 .. v23}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v7

    move-wide/from16 v18, v7

    goto :goto_6

    .line 489
    .end local v9    # "referenceClockFrequency":I
    :cond_b
    move-wide/from16 v18, v7

    .line 512
    .end local v7    # "frameDurationUs":J
    .local v18, "frameDurationUs":J
    :goto_6
    new-instance v20, Landroidx/media3/extractor/DtsUtil$DtsHeader;

    const-string v8, "audio/vnd.dts.hd;profile=lbr"

    const/4 v14, 0x0

    const/16 v21, 0x0

    move-object/from16 v7, v20

    move/from16 v9, v17

    move v10, v6

    move v11, v5

    move-wide/from16 v12, v18

    move/from16 v22, v15

    .end local v15    # "extensionSubstreamFrameDurationCode":I
    .local v22, "extensionSubstreamFrameDurationCode":I
    move-object/from16 v15, v21

    invoke-direct/range {v7 .. v15}, Landroidx/media3/extractor/DtsUtil$DtsHeader;-><init>(Ljava/lang/String;IIIJILandroidx/media3/extractor/DtsUtil$1;)V

    return-object v20

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static parseDtsHdHeaderSize([B)I
    .locals 3
    .param p0, "headerPrefix"    # [B

    .line 529
    invoke-static {p0}, Landroidx/media3/extractor/DtsUtil;->getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;

    move-result-object v0

    .line 530
    .local v0, "headerPrefixBits":Landroidx/media3/common/util/ParsableBitArray;
    const/16 v1, 0x2a

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 532
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v1, 0xc

    goto :goto_0

    :cond_0
    const/16 v1, 0x8

    .line 534
    .local v1, "headerBits":I
    :goto_0
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    return v2
.end method

.method public static parseDtsUhdHeader([BLjava/util/concurrent/atomic/AtomicInteger;)Landroidx/media3/extractor/DtsUtil$DtsHeader;
    .locals 25
    .param p0, "header"    # [B
    .param p1, "uhdAudioChunkId"    # Ljava/util/concurrent/atomic/AtomicInteger;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 551
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/DtsUtil;->getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;

    move-result-object v0

    .line 552
    .local v0, "headerBits":Landroidx/media3/common/util/ParsableBitArray;
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    .line 553
    .local v1, "syncWord":I
    const v2, 0x40411bf2

    const/4 v4, 0x1

    if-ne v1, v2, :cond_0

    move v2, v4

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    .line 555
    .local v2, "syncFrameFlag":Z
    :goto_0
    sget-object v5, Landroidx/media3/extractor/DtsUtil;->UHD_FTOC_PAYLOAD_LENGTH_TABLE:[I

    .line 556
    invoke-static {v0, v5, v4}, Landroidx/media3/extractor/DtsUtil;->parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I

    move-result v5

    add-int/2addr v5, v4

    .line 561
    .local v5, "ftocPayloadInBytes":I
    const v6, -0x7fffffff

    .line 562
    .local v6, "sampleRate":I
    const-wide v7, -0x7fffffffffffffffL    # -4.9E-324

    .line 563
    .local v7, "frameDurationUs":J
    if-eqz v2, :cond_3

    .line 565
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 571
    move-object/from16 v9, p0

    invoke-static {v9, v5}, Landroidx/media3/extractor/DtsUtil;->checkCrc([BI)V

    .line 573
    const/4 v10, 0x2

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v11

    .line 576
    .local v11, "baseDurationIndex":I
    const/4 v12, 0x0

    packed-switch v11, :pswitch_data_0

    .line 587
    move/from16 v24, v11

    .end local v11    # "baseDurationIndex":I
    .local v24, "baseDurationIndex":I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported base duration index in DTS UHD header: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v4, v24

    .end local v24    # "baseDurationIndex":I
    .local v4, "baseDurationIndex":I
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v12}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 584
    .end local v4    # "baseDurationIndex":I
    .restart local v11    # "baseDurationIndex":I
    :pswitch_0
    const/16 v13, 0x180

    .line 585
    .local v13, "baseDuration":I
    goto :goto_1

    .line 581
    .end local v13    # "baseDuration":I
    :pswitch_1
    const/16 v13, 0x1e0

    .line 582
    .restart local v13    # "baseDuration":I
    goto :goto_1

    .line 578
    .end local v13    # "baseDuration":I
    :pswitch_2
    const/16 v13, 0x200

    .line 579
    .restart local v13    # "baseDuration":I
    nop

    .line 592
    :goto_1
    nop

    .line 593
    const/4 v14, 0x3

    invoke-virtual {v0, v14}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v14

    add-int/2addr v14, v4

    mul-int/2addr v14, v13

    .line 594
    .local v14, "frameDurationInClockPeriods":I
    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v15

    .line 596
    .local v15, "clockRateIndex":I
    packed-switch v15, :pswitch_data_1

    .line 607
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unsupported clock rate index in DTS UHD header: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v12}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 604
    :pswitch_3
    const v12, 0xbb80

    .line 605
    .local v12, "clockRateHertz":I
    goto :goto_2

    .line 601
    .end local v12    # "clockRateHertz":I
    :pswitch_4
    const v12, 0xac44

    .line 602
    .restart local v12    # "clockRateHertz":I
    goto :goto_2

    .line 598
    .end local v12    # "clockRateHertz":I
    :pswitch_5
    const/16 v12, 0x7d00

    .line 599
    .restart local v12    # "clockRateHertz":I
    nop

    .line 612
    :goto_2
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v16

    if-eqz v16, :cond_1

    .line 614
    const/16 v3, 0x24

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 616
    :cond_1
    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    shl-int v3, v4, v3

    .line 617
    .local v3, "sampleRateMultiplier":I
    mul-int v6, v12, v3

    .line 618
    move/from16 v23, v5

    .end local v5    # "ftocPayloadInBytes":I
    .local v23, "ftocPayloadInBytes":I
    int-to-long v4, v14

    const-wide/32 v19, 0xf4240

    move/from16 v24, v11

    .end local v11    # "baseDurationIndex":I
    .restart local v24    # "baseDurationIndex":I
    int-to-long v10, v12

    .line 619
    move-wide/from16 v17, v4

    move-wide/from16 v21, v10

    invoke-static/range {v17 .. v22}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v7

    goto :goto_3

    .line 566
    .end local v3    # "sampleRateMultiplier":I
    .end local v12    # "clockRateHertz":I
    .end local v13    # "baseDuration":I
    .end local v14    # "frameDurationInClockPeriods":I
    .end local v15    # "clockRateIndex":I
    .end local v23    # "ftocPayloadInBytes":I
    .end local v24    # "baseDurationIndex":I
    .restart local v5    # "ftocPayloadInBytes":I
    :cond_2
    const-string v3, "Only supports full channel mask-based audio presentation"

    invoke-static {v3}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 563
    :cond_3
    move-object/from16 v9, p0

    move/from16 v23, v5

    .line 625
    .end local v5    # "ftocPayloadInBytes":I
    .restart local v23    # "ftocPayloadInBytes":I
    :goto_3
    const/4 v3, 0x0

    .line 626
    .local v3, "chunkPayloadBytes":I
    if-eqz v2, :cond_4

    const/4 v10, 0x1

    goto :goto_4

    :cond_4
    const/4 v10, 0x0

    :goto_4
    move v4, v10

    .line 627
    .local v4, "numOfMetadataChunks":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_5
    if-ge v5, v4, :cond_5

    .line 628
    sget-object v10, Landroidx/media3/extractor/DtsUtil;->UHD_METADATA_CHUNK_SIZE_LENGTH_TABLE:[I

    .line 629
    const/4 v11, 0x1

    invoke-static {v0, v10, v11}, Landroidx/media3/extractor/DtsUtil;->parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I

    move-result v12

    .line 631
    .local v12, "metadataChunkSize":I
    add-int/2addr v3, v12

    .line 627
    .end local v12    # "metadataChunkSize":I
    add-int/lit8 v5, v5, 0x1

    goto :goto_5

    .line 636
    .end local v5    # "i":I
    :cond_5
    const/4 v5, 0x1

    .line 637
    .local v5, "numAudioChunks":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_6
    if-ge v11, v5, :cond_8

    .line 639
    if-eqz v2, :cond_6

    .line 640
    sget-object v12, Landroidx/media3/extractor/DtsUtil;->UHD_AUDIO_CHUNK_ID_LENGTH_TABLE:[I

    .line 641
    const/4 v10, 0x1

    invoke-static {v0, v12, v10}, Landroidx/media3/extractor/DtsUtil;->parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I

    move-result v12

    .line 640
    move-object/from16 v15, p1

    invoke-virtual {v15, v12}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    goto :goto_7

    .line 639
    :cond_6
    move-object/from16 v15, p1

    const/4 v10, 0x1

    .line 645
    :goto_7
    invoke-virtual/range {p1 .. p1}, Ljava/util/concurrent/atomic/AtomicInteger;->get()I

    move-result v12

    if-eqz v12, :cond_7

    .line 646
    sget-object v12, Landroidx/media3/extractor/DtsUtil;->UHD_AUDIO_CHUNK_SIZE_LENGTH_TABLE:[I

    invoke-static {v0, v12, v10}, Landroidx/media3/extractor/DtsUtil;->parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I

    move-result v12

    goto :goto_8

    .line 648
    :cond_7
    const/4 v12, 0x0

    :goto_8
    nop

    .line 649
    .local v12, "audioChunkSize":I
    add-int/2addr v3, v12

    .line 637
    .end local v12    # "audioChunkSize":I
    add-int/lit8 v11, v11, 0x1

    goto :goto_6

    :cond_8
    move-object/from16 v15, p1

    .line 652
    .end local v11    # "i":I
    add-int v19, v23, v3

    .line 653
    .local v19, "frameSize":I
    new-instance v20, Landroidx/media3/extractor/DtsUtil$DtsHeader;

    const-string v11, "audio/vnd.dts.uhd;profile=p2"

    const/4 v12, 0x2

    const/16 v17, 0x0

    const/16 v18, 0x0

    move-object/from16 v10, v20

    move v13, v6

    move/from16 v14, v19

    move-wide v15, v7

    invoke-direct/range {v10 .. v18}, Landroidx/media3/extractor/DtsUtil$DtsHeader;-><init>(Ljava/lang/String;IIIJILandroidx/media3/extractor/DtsUtil$1;)V

    return-object v20

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_5
        :pswitch_4
        :pswitch_3
    .end packed-switch
.end method

.method public static parseDtsUhdHeaderSize([B)I
    .locals 3
    .param p0, "headerPrefix"    # [B

    .line 674
    invoke-static {p0}, Landroidx/media3/extractor/DtsUtil;->getNormalizedFrame([B)Landroidx/media3/common/util/ParsableBitArray;

    move-result-object v0

    .line 675
    .local v0, "headerPrefixBits":Landroidx/media3/common/util/ParsableBitArray;
    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 676
    sget-object v1, Landroidx/media3/extractor/DtsUtil;->UHD_HEADER_SIZE_LENGTH_TABLE:[I

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroidx/media3/extractor/DtsUtil;->parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I

    move-result v1

    add-int/2addr v1, v2

    return v1
.end method

.method private static parseUnsignedVarInt(Landroidx/media3/common/util/ParsableBitArray;[IZ)I
    .locals 5
    .param p0, "frameBits"    # Landroidx/media3/common/util/ParsableBitArray;
    .param p1, "lengths"    # [I
    .param p2, "extractAndAddFlag"    # Z

    .line 701
    const/4 v0, 0x0

    .line 702
    .local v0, "index":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    const/4 v2, 0x3

    if-ge v1, v2, :cond_0

    .line 703
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 704
    add-int/lit8 v0, v0, 0x1

    .line 702
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 710
    .end local v1    # "i":I
    :cond_0
    const/4 v1, 0x0

    .line 711
    .local v1, "value":I
    if-eqz p2, :cond_1

    .line 712
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v0, :cond_1

    .line 713
    aget v3, p1, v2

    const/4 v4, 0x1

    shl-int v3, v4, v3

    add-int/2addr v1, v3

    .line 712
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 716
    .end local v2    # "i":I
    :cond_1
    aget v2, p1, v0

    invoke-virtual {p0, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    add-int/2addr v2, v1

    return v2
.end method
