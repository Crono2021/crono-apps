.class public final Landroidx/media3/common/util/ParsableBitArray;
.super Ljava/lang/Object;
.source "ParsableBitArray.java"


# annotations
.annotation runtime Lcom/google/errorprone/annotations/CheckReturnValue;
.end annotation


# instance fields
.field private bitOffset:I

.field private byteLimit:I

.field private byteOffset:I

.field public data:[B


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    sget-object v0, Landroidx/media3/common/util/Util;->EMPTY_BYTE_ARRAY:[B

    iput-object v0, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    .line 40
    return-void
.end method

.method public constructor <init>([B)V
    .locals 1
    .param p1, "data"    # [B

    .line 48
    array-length v0, p1

    invoke-direct {p0, p1, v0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([BI)V

    .line 49
    return-void
.end method

.method public constructor <init>([BI)V
    .locals 0
    .param p1, "data"    # [B
    .param p2, "limit"    # I

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    .line 59
    iput p2, p0, Landroidx/media3/common/util/ParsableBitArray;->byteLimit:I

    .line 60
    return-void
.end method

.method private assertValidOffset()V
    .locals 2

    .line 344
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    if-ltz v0, :cond_1

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteLimit:I

    if-lt v0, v1, :cond_0

    if-ne v0, v1, :cond_1

    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 346
    return-void
.end method


# virtual methods
.method public bitsLeft()I
    .locals 2

    .line 97
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteLimit:I

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    sub-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x8

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public byteAlign()V
    .locals 1

    .line 243
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    if-nez v0, :cond_0

    .line 244
    return-void

    .line 246
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 247
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 248
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 249
    return-void
.end method

.method public getBytePosition()I
    .locals 1

    .line 111
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 112
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    return v0
.end method

.method public getPosition()I
    .locals 2

    .line 102
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    mul-int/lit8 v0, v0, 0x8

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    add-int/2addr v0, v1

    return v0
.end method

.method public putInt(II)V
    .locals 11
    .param p1, "value"    # I
    .param p2, "numBits"    # I

    .line 315
    move v0, p2

    .line 316
    .local v0, "remainingBitsToRead":I
    const/16 v1, 0x20

    const/4 v2, 0x1

    if-ge p2, v1, :cond_0

    .line 317
    shl-int v1, v2, p2

    sub-int/2addr v1, v2

    and-int/2addr p1, v1

    .line 319
    :cond_0
    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    const/16 v3, 0x8

    rsub-int/lit8 v1, v1, 0x8

    invoke-static {v1, p2}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 320
    .local v1, "firstByteReadSize":I
    iget v4, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    rsub-int/lit8 v5, v4, 0x8

    sub-int/2addr v5, v1

    .line 321
    .local v5, "firstByteRightPaddingSize":I
    const v6, 0xff00

    shr-int v4, v6, v4

    shl-int v6, v2, v5

    sub-int/2addr v6, v2

    or-int/2addr v4, v6

    .line 322
    .local v4, "firstByteBitmask":I
    iget-object v6, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v7, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v8, v6, v7

    and-int/2addr v8, v4

    int-to-byte v8, v8

    aput-byte v8, v6, v7

    .line 323
    sub-int v9, p2, v1

    ushr-int v9, p1, v9

    .line 324
    .local v9, "firstByteInputBits":I
    shl-int v10, v9, v5

    or-int/2addr v8, v10

    int-to-byte v8, v8

    aput-byte v8, v6, v7

    .line 326
    sub-int/2addr v0, v1

    .line 327
    add-int/2addr v7, v2

    .line 328
    .local v7, "currentByteIndex":I
    :goto_0
    if-le v0, v3, :cond_1

    .line 329
    iget-object v6, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    add-int/lit8 v8, v7, 0x1

    .end local v7    # "currentByteIndex":I
    .local v8, "currentByteIndex":I
    add-int/lit8 v10, v0, -0x8

    ushr-int v10, p1, v10

    int-to-byte v10, v10

    aput-byte v10, v6, v7

    .line 330
    add-int/lit8 v0, v0, -0x8

    move v7, v8

    goto :goto_0

    .line 332
    .end local v8    # "currentByteIndex":I
    .restart local v7    # "currentByteIndex":I
    :cond_1
    rsub-int/lit8 v3, v0, 0x8

    .line 333
    .local v3, "lastByteRightPaddingSize":I
    iget-object v6, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    aget-byte v8, v6, v7

    shl-int v10, v2, v3

    sub-int/2addr v10, v2

    and-int/2addr v8, v10

    int-to-byte v8, v8

    aput-byte v8, v6, v7

    .line 335
    shl-int v10, v2, v0

    sub-int/2addr v10, v2

    and-int v2, p1, v10

    .line 336
    .local v2, "lastByteInput":I
    shl-int v10, v2, v3

    or-int/2addr v8, v10

    int-to-byte v8, v8

    aput-byte v8, v6, v7

    .line 338
    invoke-virtual {p0, p2}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 339
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 340
    return-void
.end method

.method public readBit()Z
    .locals 3

    .line 157
    iget-object v0, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v0, v0, v1

    const/16 v1, 0x80

    iget v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    shr-int/2addr v1, v2

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 158
    .local v0, "returnValue":Z
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 159
    return v0
.end method

.method public readBits(I)I
    .locals 7
    .param p1, "numBits"    # I

    .line 169
    const/4 v0, 0x0

    if-nez p1, :cond_0

    .line 170
    return v0

    .line 172
    :cond_0
    const/4 v1, 0x0

    .line 173
    .local v1, "returnValue":I
    iget v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    add-int/2addr v2, p1

    iput v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 174
    :goto_0
    iget v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    const/16 v3, 0x8

    if-le v2, v3, :cond_1

    .line 175
    add-int/lit8 v2, v2, -0x8

    iput v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 176
    iget-object v3, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v4, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/lit8 v5, v4, 0x1

    iput v5, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    shl-int v2, v3, v2

    or-int/2addr v1, v2

    goto :goto_0

    .line 178
    :cond_1
    iget-object v4, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v5, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v4, v4, v5

    and-int/lit16 v4, v4, 0xff

    rsub-int/lit8 v6, v2, 0x8

    shr-int/2addr v4, v6

    or-int/2addr v1, v4

    .line 179
    rsub-int/lit8 v4, p1, 0x20

    const/4 v6, -0x1

    ushr-int v4, v6, v4

    and-int/2addr v1, v4

    .line 180
    if-ne v2, v3, :cond_2

    .line 181
    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 182
    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 184
    :cond_2
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 185
    return v1
.end method

.method public readBits([BII)V
    .locals 9
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "numBits"    # I

    .line 212
    shr-int/lit8 v0, p3, 0x3

    add-int/2addr v0, p2

    .line 213
    .local v0, "to":I
    move v1, p2

    .local v1, "i":I
    :goto_0
    const/16 v2, 0xff

    const/16 v3, 0x8

    if-ge v1, v0, :cond_0

    .line 214
    iget-object v4, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v5, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/lit8 v6, v5, 0x1

    iput v6, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v5, v4, v5

    iget v7, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    shl-int/2addr v5, v7

    int-to-byte v5, v5

    aput-byte v5, p1, v1

    .line 215
    aget-byte v5, p1, v1

    aget-byte v4, v4, v6

    and-int/2addr v2, v4

    sub-int/2addr v3, v7

    shr-int/2addr v2, v3

    or-int/2addr v2, v5

    int-to-byte v2, v2

    aput-byte v2, p1, v1

    .line 213
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 218
    .end local v1    # "i":I
    :cond_0
    and-int/lit8 v1, p3, 0x7

    .line 219
    .local v1, "bitsLeft":I
    if-nez v1, :cond_1

    .line 220
    return-void

    .line 223
    :cond_1
    aget-byte v4, p1, v0

    shr-int v5, v2, v1

    and-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, p1, v0

    .line 224
    iget v4, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    add-int v5, v4, v1

    if-le v5, v3, :cond_2

    .line 226
    aget-byte v5, p1, v0

    iget-object v6, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v7, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/lit8 v8, v7, 0x1

    iput v8, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v6, v6, v7

    and-int/2addr v6, v2

    shl-int/2addr v6, v4

    or-int/2addr v5, v6

    int-to-byte v5, v5

    aput-byte v5, p1, v0

    .line 227
    sub-int/2addr v4, v3

    iput v4, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 229
    :cond_2
    iget v4, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    add-int/2addr v4, v1

    iput v4, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 230
    iget-object v5, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v6, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    aget-byte v5, v5, v6

    and-int/2addr v2, v5

    rsub-int/lit8 v5, v4, 0x8

    shr-int/2addr v2, v5

    .line 231
    .local v2, "lastDataByteTrailingBits":I
    aget-byte v5, p1, v0

    rsub-int/lit8 v7, v1, 0x8

    shl-int v7, v2, v7

    int-to-byte v7, v7

    or-int/2addr v5, v7

    int-to-byte v5, v5

    aput-byte v5, p1, v0

    .line 232
    if-ne v4, v3, :cond_3

    .line 233
    const/4 v3, 0x0

    iput v3, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 234
    add-int/lit8 v6, v6, 0x1

    iput v6, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 236
    :cond_3
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 237
    return-void
.end method

.method public readBitsToLong(I)J
    .locals 2
    .param p1, "numBits"    # I

    .line 195
    const/16 v0, 0x20

    if-gt p1, v0, :cond_0

    .line 196
    invoke-virtual {p0, p1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v0

    invoke-static {v0}, Landroidx/media3/common/util/Util;->toUnsignedLong(I)J

    move-result-wide v0

    return-wide v0

    .line 198
    :cond_0
    add-int/lit8 v1, p1, -0x20

    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v1

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v0

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->toLong(II)J

    move-result-wide v0

    return-wide v0
.end method

.method public readBytes([BII)V
    .locals 2
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .line 262
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 263
    iget-object v0, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    invoke-static {v0, v1, p1, p2, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 264
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/2addr v0, p3

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 265
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 266
    return-void
.end method

.method public readBytesAsString(I)Ljava/lang/String;
    .locals 1
    .param p1, "length"    # I

    .line 288
    sget-object v0, Lcom/google/common/base/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {p0, p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->readBytesAsString(ILjava/nio/charset/Charset;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public readBytesAsString(ILjava/nio/charset/Charset;)Ljava/lang/String;
    .locals 2
    .param p1, "length"    # I
    .param p2, "charset"    # Ljava/nio/charset/Charset;

    .line 300
    new-array v0, p1, [B

    .line 301
    .local v0, "bytes":[B
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p1}, Landroidx/media3/common/util/ParsableBitArray;->readBytes([BII)V

    .line 302
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, v0, p2}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    return-object v1
.end method

.method public reset(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 2
    .param p1, "parsableByteArray"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 78
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v1

    invoke-virtual {p0, v0, v1}, Landroidx/media3/common/util/ParsableBitArray;->reset([BI)V

    .line 79
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    mul-int/lit8 v0, v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 80
    return-void
.end method

.method public reset([B)V
    .locals 1
    .param p1, "data"    # [B

    .line 68
    array-length v0, p1

    invoke-virtual {p0, p1, v0}, Landroidx/media3/common/util/ParsableBitArray;->reset([BI)V

    .line 69
    return-void
.end method

.method public reset([BI)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "limit"    # I

    .line 89
    iput-object p1, p0, Landroidx/media3/common/util/ParsableBitArray;->data:[B

    .line 90
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 91
    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 92
    iput p2, p0, Landroidx/media3/common/util/ParsableBitArray;->byteLimit:I

    .line 93
    return-void
.end method

.method public setPosition(I)V
    .locals 1
    .param p1, "position"    # I

    .line 121
    div-int/lit8 v0, p1, 0x8

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 122
    mul-int/lit8 v0, v0, 0x8

    sub-int v0, p1, v0

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 123
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 124
    return-void
.end method

.method public skipBit()V
    .locals 2

    .line 128
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    const/16 v1, 0x8

    if-ne v0, v1, :cond_0

    .line 129
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 130
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 132
    :cond_0
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 133
    return-void
.end method

.method public skipBits(I)V
    .locals 4
    .param p1, "numBits"    # I

    .line 141
    div-int/lit8 v0, p1, 0x8

    .line 142
    .local v0, "numBytes":I
    iget v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 143
    iget v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    mul-int/lit8 v3, v0, 0x8

    sub-int v3, p1, v3

    add-int/2addr v2, v3

    iput v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 144
    const/4 v3, 0x7

    if-le v2, v3, :cond_0

    .line 145
    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 146
    add-int/lit8 v2, v2, -0x8

    iput v2, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    .line 148
    :cond_0
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 149
    return-void
.end method

.method public skipBytes(I)V
    .locals 1
    .param p1, "length"    # I

    .line 275
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->bitOffset:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 276
    iget v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    add-int/2addr v0, p1

    iput v0, p0, Landroidx/media3/common/util/ParsableBitArray;->byteOffset:I

    .line 277
    invoke-direct {p0}, Landroidx/media3/common/util/ParsableBitArray;->assertValidOffset()V

    .line 278
    return-void
.end method
