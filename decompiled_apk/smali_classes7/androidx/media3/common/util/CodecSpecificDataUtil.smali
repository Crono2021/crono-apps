.class public final Landroidx/media3/common/util/CodecSpecificDataUtil;
.super Ljava/lang/Object;
.source "CodecSpecificDataUtil.java"


# static fields
.field private static final EXTENDED_PAR:I = 0xf

.field private static final HEVC_GENERAL_PROFILE_SPACE_STRINGS:[Ljava/lang/String;

.field private static final NAL_START_CODE:[B

.field private static final RECTANGULAR:I = 0x0

.field private static final VISUAL_OBJECT_LAYER:I = 0x1

.field private static final VISUAL_OBJECT_LAYER_START:I = 0x20


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 32
    const/4 v0, 0x4

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    .line 33
    const-string v0, "B"

    const-string v1, "C"

    const-string v2, ""

    const-string v3, "A"

    filled-new-array {v2, v3, v0, v1}, [Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/util/CodecSpecificDataUtil;->HEVC_GENERAL_PROFILE_SPACE_STRINGS:[Ljava/lang/String;

    return-void

    nop

    :array_0
    .array-data 1
        0x0t
        0x0t
        0x0t
        0x1t
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 292
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static buildAvcCodecString(III)Ljava/lang/String;
    .locals 3
    .param p0, "profileIdc"    # I
    .param p1, "constraintsFlagsAndReservedZero2Bits"    # I
    .param p2, "levelIdc"    # I

    .line 175
    nop

    .line 176
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    filled-new-array {v0, v1, v2}, [Ljava/lang/Object;

    move-result-object v0

    .line 175
    const-string v1, "avc1.%02X%02X%02X"

    invoke-static {v1, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static buildCea708InitializationData(Z)Ljava/util/List;
    .locals 3
    .param p0, "isWideAspectRatio"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "Ljava/util/List<",
            "[B>;"
        }
    .end annotation

    .line 66
    const/4 v0, 0x0

    const/4 v1, 0x1

    new-array v2, v1, [B

    if-eqz p0, :cond_0

    aput-byte v1, v2, v0

    goto :goto_0

    :cond_0
    aput-byte v0, v2, v0

    :goto_0
    invoke-static {v2}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static buildHevcCodecString(IZII[II)Ljava/lang/String;
    .locals 5
    .param p0, "generalProfileSpace"    # I
    .param p1, "generalTierFlag"    # Z
    .param p2, "generalProfileIdc"    # I
    .param p3, "generalProfileCompatibilityFlags"    # I
    .param p4, "constraintBytes"    # [I
    .param p5, "generalLevelIdc"    # I

    .line 187
    new-instance v0, Ljava/lang/StringBuilder;

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/Object;

    sget-object v2, Landroidx/media3/common/util/CodecSpecificDataUtil;->HEVC_GENERAL_PROFILE_SPACE_STRINGS:[Ljava/lang/String;

    aget-object v2, v2, p0

    const/4 v3, 0x0

    aput-object v2, v1, v3

    .line 192
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v3, 0x1

    aput-object v2, v1, v3

    .line 193
    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v3, 0x2

    aput-object v2, v1, v3

    .line 194
    if-eqz p1, :cond_0

    const/16 v2, 0x48

    goto :goto_0

    :cond_0
    const/16 v2, 0x4c

    :goto_0
    invoke-static {v2}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v2

    const/4 v3, 0x3

    aput-object v2, v1, v3

    .line 195
    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    const/4 v3, 0x4

    aput-object v2, v1, v3

    .line 189
    const-string v2, "hvc1.%s%d.%X.%c%d"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 197
    .local v0, "builder":Ljava/lang/StringBuilder;
    array-length v1, p4

    .line 198
    .local v1, "trailingZeroIndex":I
    :goto_1
    if-lez v1, :cond_1

    add-int/lit8 v2, v1, -0x1

    aget v2, p4, v2

    if-nez v2, :cond_1

    .line 199
    add-int/lit8 v1, v1, -0x1

    goto :goto_1

    .line 201
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    if-ge v2, v1, :cond_2

    .line 202
    aget v3, p4, v2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    filled-new-array {v3}, [Ljava/lang/Object;

    move-result-object v3

    const-string v4, ".%02X"

    invoke-static {v4, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 204
    .end local v2    # "i":I
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static buildNalUnit([BII)[B
    .locals 4
    .param p0, "data"    # [B
    .param p1, "offset"    # I
    .param p2, "length"    # I

    .line 216
    sget-object v0, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    array-length v1, v0

    add-int/2addr v1, p2

    new-array v1, v1, [B

    .line 217
    .local v1, "nalUnit":[B
    const/4 v2, 0x0

    array-length v3, v0

    invoke-static {v0, v2, v1, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 218
    array-length v0, v0

    invoke-static {p0, p1, v1, v0, p2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 219
    return-object v1
.end method

.method private static findNalStartCode([BI)I
    .locals 3
    .param p0, "data"    # [B
    .param p1, "index"    # I

    .line 264
    array-length v0, p0

    sget-object v1, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    array-length v1, v1

    sub-int/2addr v0, v1

    .line 265
    .local v0, "endIndex":I
    move v1, p1

    .local v1, "i":I
    :goto_0
    if-gt v1, v0, :cond_1

    .line 266
    invoke-static {p0, v1}, Landroidx/media3/common/util/CodecSpecificDataUtil;->isNalStartCode([BI)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 267
    return v1

    .line 265
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 270
    .end local v1    # "i":I
    :cond_1
    const/4 v1, -0x1

    return v1
.end method

.method public static getVideoResolutionFromMpeg4VideoConfig([B)Landroid/util/Pair;
    .locals 11
    .param p0, "videoSpecificConfig"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 92
    const/4 v0, 0x0

    .line 93
    .local v0, "offset":I
    const/4 v1, 0x0

    .line 94
    .local v1, "foundVOL":Z
    new-instance v2, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v2, p0}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    .line 95
    .local v2, "scratchBytes":Landroidx/media3/common/util/ParsableByteArray;
    :goto_0
    add-int/lit8 v3, v0, 0x3

    array-length v4, p0

    const/4 v5, 0x2

    const/4 v6, 0x1

    if-ge v3, v4, :cond_2

    .line 96
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v3

    if-ne v3, v6, :cond_1

    add-int/lit8 v3, v0, 0x3

    aget-byte v3, p0, v3

    and-int/lit16 v3, v3, 0xf0

    const/16 v4, 0x20

    if-eq v3, v4, :cond_0

    goto :goto_1

    .line 102
    :cond_0
    const/4 v1, 0x1

    .line 103
    goto :goto_2

    .line 98
    :cond_1
    :goto_1
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v3

    sub-int/2addr v3, v5

    invoke-virtual {v2, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 99
    add-int/lit8 v0, v0, 0x1

    .line 100
    goto :goto_0

    .line 106
    :cond_2
    :goto_2
    const-string v3, "Invalid input: VOL not found."

    invoke-static {v1, v3}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 108
    new-instance v3, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v3, p0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    .line 110
    .local v3, "scratchBits":Landroidx/media3/common/util/ParsableBitArray;
    add-int/lit8 v4, v0, 0x4

    const/16 v7, 0x8

    mul-int/2addr v4, v7

    invoke-virtual {v3, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 111
    invoke-virtual {v3, v6}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 112
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 114
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v4

    const/4 v8, 0x4

    if-eqz v4, :cond_3

    .line 115
    invoke-virtual {v3, v8}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 116
    const/4 v4, 0x3

    invoke-virtual {v3, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 119
    :cond_3
    invoke-virtual {v3, v8}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v4

    .line 120
    .local v4, "aspectRatioInfo":I
    const/16 v8, 0xf

    if-ne v4, v8, :cond_4

    .line 121
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 122
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 125
    :cond_4
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 126
    invoke-virtual {v3, v5}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 127
    invoke-virtual {v3, v6}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 128
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 129
    const/16 v7, 0x4f

    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 133
    :cond_5
    invoke-virtual {v3, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 134
    .local v5, "videoObjectLayerShape":I
    const/4 v7, 0x0

    if-nez v5, :cond_6

    move v8, v6

    goto :goto_3

    :cond_6
    move v8, v7

    :goto_3
    const-string v9, "Only supports rectangular video object layer shape."

    invoke-static {v8, v9}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 138
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v8

    invoke-static {v8}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 139
    const/16 v8, 0x10

    invoke-virtual {v3, v8}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v8

    .line 140
    .local v8, "vopTimeIncrementResolution":I
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v9

    invoke-static {v9}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 142
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v9

    if-eqz v9, :cond_9

    .line 143
    if-lez v8, :cond_7

    move v7, v6

    :cond_7
    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 144
    add-int/lit8 v8, v8, -0x1

    .line 145
    const/4 v7, 0x0

    .line 146
    .local v7, "numBitsToSkip":I
    :goto_4
    if-lez v8, :cond_8

    .line 147
    add-int/lit8 v7, v7, 0x1

    .line 148
    shr-int/lit8 v8, v8, 0x1

    goto :goto_4

    .line 150
    :cond_8
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 153
    .end local v7    # "numBitsToSkip":I
    :cond_9
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v7

    invoke-static {v7}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 154
    const/16 v7, 0xd

    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v9

    .line 155
    .local v9, "videoObjectLayerWidth":I
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v10

    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 156
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v7

    .line 157
    .local v7, "videoObjectLayerHeight":I
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v10

    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 159
    invoke-virtual {v3, v6}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 161
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-static {v6, v10}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v6

    return-object v6
.end method

.method private static isNalStartCode([BI)Z
    .locals 4
    .param p0, "data"    # [B
    .param p1, "index"    # I

    .line 281
    array-length v0, p0

    sub-int/2addr v0, p1

    sget-object v1, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    array-length v1, v1

    const/4 v2, 0x0

    if-gt v0, v1, :cond_0

    .line 282
    return v2

    .line 284
    :cond_0
    const/4 v0, 0x0

    .local v0, "j":I
    :goto_0
    sget-object v1, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    array-length v3, v1

    if-ge v0, v3, :cond_2

    .line 285
    add-int v3, p1, v0

    aget-byte v3, p0, v3

    aget-byte v1, v1, v0

    if-eq v3, v1, :cond_1

    .line 286
    return v2

    .line 284
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 289
    .end local v0    # "j":I
    :cond_2
    const/4 v0, 0x1

    return v0
.end method

.method public static parseAlacAudioSpecificConfig([B)Landroid/util/Pair;
    .locals 5
    .param p0, "audioSpecificConfig"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B)",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 50
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0, p0}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    .line 51
    .local v0, "byteArray":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 52
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v1

    .line 53
    .local v1, "channelCount":I
    const/16 v2, 0x14

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 54
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v2

    .line 55
    .local v2, "sampleRate":I
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v3

    return-object v3
.end method

.method public static parseCea708InitializationData(Ljava/util/List;)Z
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "[B>;)Z"
        }
    .end annotation

    .line 78
    .local p0, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 79
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    array-length v0, v0

    if-ne v0, v2, :cond_0

    .line 80
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    aget-byte v0, v0, v1

    if-ne v0, v2, :cond_0

    move v1, v2

    goto :goto_0

    :cond_0
    nop

    .line 78
    :goto_0
    return v1
.end method

.method public static splitNalUnits([B)[[B
    .locals 9
    .param p0, "data"    # [B

    .line 235
    const/4 v0, 0x0

    invoke-static {p0, v0}, Landroidx/media3/common/util/CodecSpecificDataUtil;->isNalStartCode([BI)Z

    move-result v1

    if-nez v1, :cond_0

    .line 237
    const/4 v0, 0x0

    return-object v0

    .line 239
    :cond_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 240
    .local v1, "starts":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v2, 0x0

    .line 242
    .local v2, "nalUnitIndex":I
    :cond_1
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    sget-object v3, Landroidx/media3/common/util/CodecSpecificDataUtil;->NAL_START_CODE:[B

    array-length v3, v3

    add-int/2addr v3, v2

    invoke-static {p0, v3}, Landroidx/media3/common/util/CodecSpecificDataUtil;->findNalStartCode([BI)I

    move-result v2

    .line 244
    const/4 v3, -0x1

    if-ne v2, v3, :cond_1

    .line 245
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    new-array v3, v3, [[B

    .line 246
    .local v3, "split":[[B
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_3

    .line 247
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    .line 248
    .local v5, "startIndex":I
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v6, v6, -0x1

    if-ge v4, v6, :cond_2

    add-int/lit8 v6, v4, 0x1

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    goto :goto_1

    :cond_2
    array-length v6, p0

    .line 249
    .local v6, "endIndex":I
    :goto_1
    sub-int v7, v6, v5

    new-array v7, v7, [B

    .line 250
    .local v7, "nal":[B
    array-length v8, v7

    invoke-static {p0, v5, v7, v0, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 251
    aput-object v7, v3, v4

    .line 246
    .end local v5    # "startIndex":I
    .end local v6    # "endIndex":I
    .end local v7    # "nal":[B
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 253
    .end local v4    # "i":I
    :cond_3
    return-object v3
.end method
