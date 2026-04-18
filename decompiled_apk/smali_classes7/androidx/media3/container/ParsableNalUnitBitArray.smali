.class public final Landroidx/media3/container/ParsableNalUnitBitArray;
.super Ljava/lang/Object;
.source "ParsableNalUnitBitArray.java"


# instance fields
.field private bitOffset:I

.field private byteLimit:I

.field private byteOffset:I

.field private data:[B


# direct methods
.method public constructor <init>([BII)V
    .locals 0
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "limit"    # I

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/container/ParsableNalUnitBitArray;->reset([BII)V

    .line 45
    return-void
.end method

.method private assertValidOffset()V
    .locals 2

    .line 212
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    if-ltz v0, :cond_1

    iget v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    if-lt v0, v1, :cond_0

    if-ne v0, v1, :cond_1

    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 214
    return-void
.end method

.method private readExpGolombCodeNum()I
    .locals 3

    .line 195
    const/4 v0, 0x0

    .line 196
    .local v0, "leadingZeros":I
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->readBit()Z

    move-result v1

    if-nez v1, :cond_0

    .line 197
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 199
    :cond_0
    const/4 v1, 0x1

    shl-int v2, v1, v0

    sub-int/2addr v2, v1

    if-lez v0, :cond_1

    invoke-virtual {p0, v0}, Landroidx/media3/container/ParsableNalUnitBitArray;->readBits(I)I

    move-result v1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    :goto_1
    add-int/2addr v2, v1

    return v2
.end method

.method private shouldSkipByte(I)Z
    .locals 3
    .param p1, "offset"    # I

    .line 203
    const/4 v0, 0x2

    if-gt v0, p1, :cond_0

    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    if-ge p1, v0, :cond_0

    iget-object v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->data:[B

    aget-byte v1, v0, p1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_0

    add-int/lit8 v1, p1, -0x2

    aget-byte v1, v0, v1

    if-nez v1, :cond_0

    add-int/lit8 v1, p1, -0x1

    aget-byte v0, v0, v1

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method


# virtual methods
.method public canReadBits(I)Z
    .locals 7
    .param p1, "numBits"    # I

    .line 103
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 104
    .local v0, "oldByteOffset":I
    div-int/lit8 v1, p1, 0x8

    .line 105
    .local v1, "numBytes":I
    iget v2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    add-int/2addr v2, v1

    .line 106
    .local v2, "newByteOffset":I
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    add-int/2addr v3, p1

    mul-int/lit8 v4, v1, 0x8

    sub-int/2addr v3, v4

    .line 107
    .local v3, "newBitOffset":I
    const/4 v4, 0x7

    if-le v3, v4, :cond_0

    .line 108
    add-int/lit8 v2, v2, 0x1

    .line 109
    add-int/lit8 v3, v3, -0x8

    .line 111
    :cond_0
    add-int/lit8 v4, v0, 0x1

    .local v4, "i":I
    :goto_0
    const/4 v5, 0x1

    if-gt v4, v2, :cond_2

    iget v6, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    if-ge v2, v6, :cond_2

    .line 112
    invoke-direct {p0, v4}, Landroidx/media3/container/ParsableNalUnitBitArray;->shouldSkipByte(I)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 114
    add-int/lit8 v2, v2, 0x1

    .line 115
    add-int/lit8 v4, v4, 0x2

    .line 111
    :cond_1
    add-int/2addr v4, v5

    goto :goto_0

    .line 118
    .end local v4    # "i":I
    :cond_2
    iget v4, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    if-lt v2, v4, :cond_4

    if-ne v2, v4, :cond_3

    if-nez v3, :cond_3

    goto :goto_1

    :cond_3
    const/4 v5, 0x0

    :cond_4
    :goto_1
    return v5
.end method

.method public canReadExpGolombCodedNum()Z
    .locals 7

    .line 163
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 164
    .local v0, "initialByteOffset":I
    iget v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 165
    .local v1, "initialBitOffset":I
    const/4 v2, 0x0

    .line 166
    .local v2, "leadingZeros":I
    :goto_0
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    iget v4, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    if-ge v3, v4, :cond_0

    invoke-virtual {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->readBit()Z

    move-result v3

    if-nez v3, :cond_0

    .line 167
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 169
    :cond_0
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    iget v4, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-ne v3, v4, :cond_1

    move v3, v6

    goto :goto_1

    :cond_1
    move v3, v5

    .line 170
    .local v3, "hitLimit":Z
    :goto_1
    iput v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 171
    iput v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 172
    if-nez v3, :cond_2

    mul-int/lit8 v4, v2, 0x2

    add-int/2addr v4, v6

    invoke-virtual {p0, v4}, Landroidx/media3/container/ParsableNalUnitBitArray;->canReadBits(I)Z

    move-result v4

    if-eqz v4, :cond_2

    move v5, v6

    :cond_2
    return v5
.end method

.method public readBit()Z
    .locals 3

    .line 127
    iget-object v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->data:[B

    iget v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    aget-byte v0, v0, v1

    const/16 v1, 0x80

    iget v2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    shr-int/2addr v1, v2

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 128
    .local v0, "returnValue":Z
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->skipBit()V

    .line 129
    return v0
.end method

.method public readBits(I)I
    .locals 8
    .param p1, "numBits"    # I

    .line 139
    const/4 v0, 0x0

    .line 140
    .local v0, "returnValue":I
    iget v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    add-int/2addr v1, p1

    iput v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 141
    :goto_0
    iget v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    const/4 v2, 0x2

    const/4 v3, 0x1

    const/16 v4, 0x8

    if-le v1, v4, :cond_1

    .line 142
    add-int/lit8 v1, v1, -0x8

    iput v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 143
    iget-object v4, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->data:[B

    iget v5, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    aget-byte v4, v4, v5

    and-int/lit16 v4, v4, 0xff

    shl-int v1, v4, v1

    or-int/2addr v0, v1

    .line 144
    add-int/lit8 v1, v5, 0x1

    invoke-direct {p0, v1}, Landroidx/media3/container/ParsableNalUnitBitArray;->shouldSkipByte(I)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_1

    :cond_0
    move v2, v3

    :goto_1
    add-int/2addr v5, v2

    iput v5, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    goto :goto_0

    .line 146
    :cond_1
    iget-object v5, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->data:[B

    iget v6, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    rsub-int/lit8 v7, v1, 0x8

    shr-int/2addr v5, v7

    or-int/2addr v0, v5

    .line 147
    rsub-int/lit8 v5, p1, 0x20

    const/4 v7, -0x1

    ushr-int v5, v7, v5

    and-int/2addr v0, v5

    .line 148
    if-ne v1, v4, :cond_3

    .line 149
    const/4 v1, 0x0

    iput v1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 150
    add-int/lit8 v1, v6, 0x1

    invoke-direct {p0, v1}, Landroidx/media3/container/ParsableNalUnitBitArray;->shouldSkipByte(I)Z

    move-result v1

    if-eqz v1, :cond_2

    goto :goto_2

    :cond_2
    move v2, v3

    :goto_2
    add-int/2addr v6, v2

    iput v6, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 152
    :cond_3
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->assertValidOffset()V

    .line 153
    return v0
.end method

.method public readSignedExpGolombCodedInt()I
    .locals 3

    .line 190
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->readExpGolombCodeNum()I

    move-result v0

    .line 191
    .local v0, "codeNum":I
    rem-int/lit8 v1, v0, 0x2

    if-nez v1, :cond_0

    const/4 v1, -0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x1

    :goto_0
    add-int/lit8 v2, v0, 0x1

    div-int/lit8 v2, v2, 0x2

    mul-int/2addr v1, v2

    return v1
.end method

.method public readUnsignedExpGolombCodedInt()I
    .locals 1

    .line 181
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->readExpGolombCodeNum()I

    move-result v0

    return v0
.end method

.method public reset([BII)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "limit"    # I

    .line 55
    iput-object p1, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->data:[B

    .line 56
    iput p2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 57
    iput p3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteLimit:I

    .line 58
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 59
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->assertValidOffset()V

    .line 60
    return-void
.end method

.method public skipBit()V
    .locals 3

    .line 64
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    const/4 v1, 0x1

    add-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    const/16 v2, 0x8

    if-ne v0, v2, :cond_1

    .line 65
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 66
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    add-int/lit8 v2, v0, 0x1

    invoke-direct {p0, v2}, Landroidx/media3/container/ParsableNalUnitBitArray;->shouldSkipByte(I)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x2

    :cond_0
    add-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 68
    :cond_1
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->assertValidOffset()V

    .line 69
    return-void
.end method

.method public skipBits(I)V
    .locals 5
    .param p1, "numBits"    # I

    .line 77
    iget v0, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 78
    .local v0, "oldByteOffset":I
    div-int/lit8 v1, p1, 0x8

    .line 79
    .local v1, "numBytes":I
    iget v2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    add-int/2addr v2, v1

    iput v2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 80
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    mul-int/lit8 v4, v1, 0x8

    sub-int v4, p1, v4

    add-int/2addr v3, v4

    iput v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 81
    const/4 v4, 0x7

    if-le v3, v4, :cond_0

    .line 82
    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 83
    add-int/lit8 v3, v3, -0x8

    iput v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->bitOffset:I

    .line 85
    :cond_0
    add-int/lit8 v2, v0, 0x1

    .local v2, "i":I
    :goto_0
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    if-gt v2, v3, :cond_2

    .line 86
    invoke-direct {p0, v2}, Landroidx/media3/container/ParsableNalUnitBitArray;->shouldSkipByte(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 88
    iget v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Landroidx/media3/container/ParsableNalUnitBitArray;->byteOffset:I

    .line 89
    add-int/lit8 v2, v2, 0x2

    .line 85
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 92
    .end local v2    # "i":I
    :cond_2
    invoke-direct {p0}, Landroidx/media3/container/ParsableNalUnitBitArray;->assertValidOffset()V

    .line 93
    return-void
.end method
