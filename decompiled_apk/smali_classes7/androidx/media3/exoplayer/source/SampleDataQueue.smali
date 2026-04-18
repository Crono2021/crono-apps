.class Landroidx/media3/exoplayer/source/SampleDataQueue;
.super Ljava/lang/Object;
.source "SampleDataQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    }
.end annotation


# static fields
.field private static final INITIAL_SCRATCH_SIZE:I = 0x20


# instance fields
.field private final allocationLength:I

.field private final allocator:Landroidx/media3/exoplayer/upstream/Allocator;

.field private firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

.field private readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private totalBytesWritten:J

.field private writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/upstream/Allocator;)V
    .locals 4
    .param p1, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    .line 57
    invoke-interface {p1}, Landroidx/media3/exoplayer/upstream/Allocator;->getIndividualAllocationLength()I

    move-result v0

    iput v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocationLength:I

    .line 58
    new-instance v1, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v2, 0x20

    invoke-direct {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 59
    new-instance v1, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    const-wide/16 v2, 0x0

    invoke-direct {v1, v2, v3, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;-><init>(JI)V

    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 60
    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 61
    iput-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 62
    return-void
.end method

.method private clearAllocationNodes(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V
    .locals 1
    .param p1, "fromNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 212
    iget-object v0, p1, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    if-nez v0, :cond_0

    .line 213
    return-void

    .line 218
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/upstream/Allocator;->release(Landroidx/media3/exoplayer/upstream/Allocator$AllocationNode;)V

    .line 219
    invoke-virtual {p1}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->clear()Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 220
    return-void
.end method

.method private static getNodeContainingPosition(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 2
    .param p0, "allocationNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .param p1, "absolutePosition"    # J

    .line 455
    nop

    :goto_0
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 456
    iget-object p0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    goto :goto_0

    .line 458
    :cond_0
    return-object p0
.end method

.method private postAppend(I)V
    .locals 4
    .param p1, "length"    # I

    .line 245
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    int-to-long v2, p1

    add-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    .line 246
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v2, v2, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    .line 247
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 249
    :cond_0
    return-void
.end method

.method private preAppend(I)I
    .locals 6
    .param p1, "length"    # I

    .line 231
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    if-nez v0, :cond_0

    .line 232
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    .line 233
    invoke-interface {v1}, Landroidx/media3/exoplayer/upstream/Allocator;->allocate()Landroidx/media3/exoplayer/upstream/Allocation;

    move-result-object v1

    new-instance v2, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v3, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v3, v3, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    iget v5, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocationLength:I

    invoke-direct {v2, v3, v4, v5}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;-><init>(JI)V

    .line 232
    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->initialize(Landroidx/media3/exoplayer/upstream/Allocation;Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V

    .line 236
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    sub-long/2addr v0, v2

    long-to-int v0, v0

    invoke-static {p1, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    return v0
.end method

.method private static readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;JLjava/nio/ByteBuffer;I)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 5
    .param p0, "allocationNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .param p1, "absolutePosition"    # J
    .param p3, "target"    # Ljava/nio/ByteBuffer;
    .param p4, "length"    # I

    .line 403
    invoke-static {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->getNodeContainingPosition(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 404
    move v0, p4

    .line 405
    .local v0, "remaining":I
    :goto_0
    if-lez v0, :cond_1

    .line 406
    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    sub-long/2addr v1, p1

    long-to-int v1, v1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 407
    .local v1, "toCopy":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    .line 408
    .local v2, "allocation":Landroidx/media3/exoplayer/upstream/Allocation;
    iget-object v3, v2, Landroidx/media3/exoplayer/upstream/Allocation;->data:[B

    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->translateOffset(J)I

    move-result v4

    invoke-virtual {p3, v3, v4, v1}, Ljava/nio/ByteBuffer;->put([BII)Ljava/nio/ByteBuffer;

    .line 409
    sub-int/2addr v0, v1

    .line 410
    int-to-long v3, v1

    add-long/2addr p1, v3

    .line 411
    iget-wide v3, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v3, p1, v3

    if-nez v3, :cond_0

    .line 412
    iget-object p0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 414
    .end local v1    # "toCopy":I
    .end local v2    # "allocation":Landroidx/media3/exoplayer/upstream/Allocation;
    :cond_0
    goto :goto_0

    .line 415
    :cond_1
    return-object p0
.end method

.method private static readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 6
    .param p0, "allocationNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .param p1, "absolutePosition"    # J
    .param p3, "target"    # [B
    .param p4, "length"    # I

    .line 429
    invoke-static {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->getNodeContainingPosition(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 430
    move v0, p4

    .line 431
    .local v0, "remaining":I
    :goto_0
    if-lez v0, :cond_1

    .line 432
    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    sub-long/2addr v1, p1

    long-to-int v1, v1

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v1

    .line 433
    .local v1, "toCopy":I
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    .line 434
    .local v2, "allocation":Landroidx/media3/exoplayer/upstream/Allocation;
    iget-object v3, v2, Landroidx/media3/exoplayer/upstream/Allocation;->data:[B

    .line 436
    invoke-virtual {p0, p1, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->translateOffset(J)I

    move-result v4

    sub-int v5, p4, v0

    .line 434
    invoke-static {v3, v4, p3, v5, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 440
    sub-int/2addr v0, v1

    .line 441
    int-to-long v3, v1

    add-long/2addr p1, v3

    .line 442
    iget-wide v3, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v3, p1, v3

    if-nez v3, :cond_0

    .line 443
    iget-object p0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 445
    .end local v1    # "toCopy":I
    .end local v2    # "allocation":Landroidx/media3/exoplayer/upstream/Allocation;
    :cond_0
    goto :goto_0

    .line 446
    :cond_1
    return-object p0
.end method

.method private static readEncryptionData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 23
    .param p0, "allocationNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .param p1, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p2, "extrasHolder"    # Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;
    .param p3, "scratch"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 317
    move-object/from16 v0, p2

    move-object/from16 v1, p3

    iget-wide v2, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    .line 320
    .local v2, "offset":J
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 321
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v5

    move-object/from16 v6, p0

    invoke-static {v6, v2, v3, v5, v4}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v5

    .line 322
    .end local p0    # "allocationNode":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .local v5, "allocationNode":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    const-wide/16 v6, 0x1

    add-long/2addr v2, v6

    .line 323
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    .line 324
    .local v6, "signalByte":B
    and-int/lit16 v8, v6, 0x80

    if-eqz v8, :cond_0

    goto :goto_0

    :cond_0
    move v4, v7

    .line 325
    .local v4, "subsampleEncryption":Z
    :goto_0
    and-int/lit8 v8, v6, 0x7f

    .line 328
    .local v8, "ivSize":I
    move-object/from16 v9, p1

    iget-object v15, v9, Landroidx/media3/decoder/DecoderInputBuffer;->cryptoInfo:Landroidx/media3/decoder/CryptoInfo;

    .line 329
    .local v15, "cryptoInfo":Landroidx/media3/decoder/CryptoInfo;
    iget-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->iv:[B

    if-nez v10, :cond_1

    .line 330
    const/16 v10, 0x10

    new-array v10, v10, [B

    iput-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->iv:[B

    goto :goto_1

    .line 333
    :cond_1
    iget-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->iv:[B

    invoke-static {v10, v7}, Ljava/util/Arrays;->fill([BB)V

    .line 335
    :goto_1
    iget-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->iv:[B

    invoke-static {v5, v2, v3, v10, v8}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v5

    .line 336
    int-to-long v10, v8

    add-long/2addr v2, v10

    .line 340
    if-eqz v4, :cond_2

    .line 341
    const/4 v10, 0x2

    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 342
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v11

    invoke-static {v5, v2, v3, v11, v10}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v5

    .line 343
    const-wide/16 v10, 0x2

    add-long/2addr v2, v10

    .line 344
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v10

    move v14, v10

    .local v10, "subsampleCount":I
    goto :goto_2

    .line 346
    .end local v10    # "subsampleCount":I
    :cond_2
    const/4 v10, 0x1

    move v14, v10

    .line 350
    .local v14, "subsampleCount":I
    :goto_2
    iget-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->numBytesOfClearData:[I

    .line 351
    .local v10, "clearDataSizes":[I
    if-eqz v10, :cond_4

    array-length v11, v10

    if-ge v11, v14, :cond_3

    goto :goto_3

    :cond_3
    move-object/from16 v19, v10

    goto :goto_4

    .line 352
    :cond_4
    :goto_3
    new-array v10, v14, [I

    move-object/from16 v19, v10

    .line 354
    .end local v10    # "clearDataSizes":[I
    .local v19, "clearDataSizes":[I
    :goto_4
    iget-object v10, v15, Landroidx/media3/decoder/CryptoInfo;->numBytesOfEncryptedData:[I

    .line 355
    .local v10, "encryptedDataSizes":[I
    if-eqz v10, :cond_6

    array-length v11, v10

    if-ge v11, v14, :cond_5

    goto :goto_5

    :cond_5
    move-object/from16 v20, v10

    goto :goto_6

    .line 356
    :cond_6
    :goto_5
    new-array v10, v14, [I

    move-object/from16 v20, v10

    .line 358
    .end local v10    # "encryptedDataSizes":[I
    .local v20, "encryptedDataSizes":[I
    :goto_6
    if-eqz v4, :cond_8

    .line 359
    mul-int/lit8 v10, v14, 0x6

    .line 360
    .local v10, "subsampleDataLength":I
    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 361
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v11

    invoke-static {v5, v2, v3, v11, v10}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v5

    .line 362
    int-to-long v11, v10

    add-long/2addr v2, v11

    .line 363
    invoke-virtual {v1, v7}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 364
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_7
    if-ge v7, v14, :cond_7

    .line 365
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v11

    aput v11, v19, v7

    .line 366
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v11

    aput v11, v20, v7

    .line 364
    add-int/lit8 v7, v7, 0x1

    goto :goto_7

    .line 368
    .end local v7    # "i":I
    .end local v10    # "subsampleDataLength":I
    :cond_7
    goto :goto_8

    .line 369
    :cond_8
    aput v7, v19, v7

    .line 370
    iget v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    iget-wide v11, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    sub-long v11, v2, v11

    long-to-int v11, v11

    sub-int/2addr v10, v11

    aput v10, v20, v7

    .line 374
    :goto_8
    iget-object v7, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->cryptoData:Landroidx/media3/extractor/TrackOutput$CryptoData;

    invoke-static {v7}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 375
    .local v7, "cryptoData":Landroidx/media3/extractor/TrackOutput$CryptoData;
    iget-object v13, v7, Landroidx/media3/extractor/TrackOutput$CryptoData;->encryptionKey:[B

    iget-object v12, v15, Landroidx/media3/decoder/CryptoInfo;->iv:[B

    iget v11, v7, Landroidx/media3/extractor/TrackOutput$CryptoData;->cryptoMode:I

    iget v10, v7, Landroidx/media3/extractor/TrackOutput$CryptoData;->encryptedBlocks:I

    iget v1, v7, Landroidx/media3/extractor/TrackOutput$CryptoData;->clearBlocks:I

    move/from16 v17, v10

    move-object v10, v15

    move/from16 v16, v11

    move v11, v14

    move-object/from16 v18, v12

    move-object/from16 v12, v19

    move-object/from16 v21, v13

    move-object/from16 v13, v20

    move/from16 v22, v14

    .end local v14    # "subsampleCount":I
    .local v22, "subsampleCount":I
    move-object/from16 v14, v21

    move-object/from16 v21, v15

    .end local v15    # "cryptoInfo":Landroidx/media3/decoder/CryptoInfo;
    .local v21, "cryptoInfo":Landroidx/media3/decoder/CryptoInfo;
    move-object/from16 v15, v18

    move/from16 v18, v1

    invoke-virtual/range {v10 .. v18}, Landroidx/media3/decoder/CryptoInfo;->set(I[I[I[B[BIII)V

    .line 386
    iget-wide v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    sub-long v10, v2, v10

    long-to-int v1, v10

    .line 387
    .local v1, "bytesRead":I
    iget-wide v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    int-to-long v12, v1

    add-long/2addr v10, v12

    iput-wide v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    .line 388
    iget v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    sub-int/2addr v10, v1

    iput v10, v0, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 389
    return-object v5
.end method

.method private static readSampleData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 6
    .param p0, "allocationNode"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .param p1, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p2, "extrasHolder"    # Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;
    .param p3, "scratch"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 268
    invoke-virtual {p1}, Landroidx/media3/decoder/DecoderInputBuffer;->isEncrypted()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 269
    invoke-static {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readEncryptionData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 272
    :cond_0
    invoke-virtual {p1}, Landroidx/media3/decoder/DecoderInputBuffer;->hasSupplementalData()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 274
    const/4 v0, 0x4

    invoke-virtual {p3, v0}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 275
    iget-wide v1, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    invoke-virtual {p3}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    invoke-static {p0, v1, v2, v3, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;J[BI)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 276
    invoke-virtual {p3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v1

    .line 277
    .local v1, "sampleSize":I
    iget-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    const-wide/16 v4, 0x4

    add-long/2addr v2, v4

    iput-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    .line 278
    iget v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    sub-int/2addr v2, v0

    iput v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 281
    invoke-virtual {p1, v1}, Landroidx/media3/decoder/DecoderInputBuffer;->ensureSpaceForWrite(I)V

    .line 282
    iget-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    iget-object v0, p1, Landroidx/media3/decoder/DecoderInputBuffer;->data:Ljava/nio/ByteBuffer;

    invoke-static {p0, v2, v3, v0, v1}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;JLjava/nio/ByteBuffer;I)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 283
    iget-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    int-to-long v4, v1

    add-long/2addr v2, v4

    iput-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    .line 284
    iget v0, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    sub-int/2addr v0, v1

    iput v0, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 287
    iget v0, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    invoke-virtual {p1, v0}, Landroidx/media3/decoder/DecoderInputBuffer;->resetSupplementalData(I)V

    .line 288
    iget-wide v2, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    iget-object v0, p1, Landroidx/media3/decoder/DecoderInputBuffer;->supplementalData:Ljava/nio/ByteBuffer;

    iget v4, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 289
    invoke-static {p0, v2, v3, v0, v4}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;JLjava/nio/ByteBuffer;I)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 290
    .end local v1    # "sampleSize":I
    goto :goto_0

    .line 292
    :cond_1
    iget v0, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    invoke-virtual {p1, v0}, Landroidx/media3/decoder/DecoderInputBuffer;->ensureSpaceForWrite(I)V

    .line 293
    iget-wide v0, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->offset:J

    iget-object v2, p1, Landroidx/media3/decoder/DecoderInputBuffer;->data:Ljava/nio/ByteBuffer;

    iget v3, p2, Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;->size:I

    .line 294
    invoke-static {p0, v0, v1, v2, v3}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;JLjava/nio/ByteBuffer;I)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object p0

    .line 296
    :goto_0
    return-object p0
.end method


# virtual methods
.method public discardDownstreamTo(J)V
    .locals 4
    .param p1, "absolutePosition"    # J

    .line 153
    const-wide/16 v0, -0x1

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    .line 154
    return-void

    .line 156
    :cond_0
    :goto_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v0, p1, v0

    if-ltz v0, :cond_1

    .line 159
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v1, v1, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/upstream/Allocator;->release(Landroidx/media3/exoplayer/upstream/Allocation;)V

    .line 160
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    invoke-virtual {v0}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->clear()Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    goto :goto_0

    .line 162
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->startPosition:J

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v2, v2, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->startPosition:J

    cmp-long v0, v0, v2

    if-gez v0, :cond_2

    .line 165
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 167
    :cond_2
    return-void
.end method

.method public discardUpstreamSampleBytes(J)V
    .locals 6
    .param p1, "totalBytesWritten"    # J

    .line 83
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    cmp-long v0, p1, v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 84
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    .line 85
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->startPosition:J

    cmp-long v0, p1, v0

    if-nez v0, :cond_1

    goto :goto_3

    .line 93
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 94
    .local v0, "lastNodeToKeep":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    :goto_1
    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    iget-wide v3, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v1, v1, v3

    if-lez v1, :cond_2

    .line 95
    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    goto :goto_1

    .line 98
    :cond_2
    iget-object v1, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 99
    .local v1, "firstNodeToDiscard":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    invoke-direct {p0, v1}, Landroidx/media3/exoplayer/source/SampleDataQueue;->clearAllocationNodes(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V

    .line 101
    new-instance v2, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v3, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    iget v5, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocationLength:I

    invoke-direct {v2, v3, v4, v5}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;-><init>(JI)V

    iput-object v2, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 103
    nop

    .line 104
    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    iget-wide v4, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_3

    .line 105
    iget-object v2, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    goto :goto_2

    .line 106
    :cond_3
    move-object v2, v0

    :goto_2
    iput-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 107
    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    if-ne v2, v1, :cond_5

    .line 108
    iget-object v2, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iput-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    goto :goto_4

    .line 87
    .end local v0    # "lastNodeToKeep":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .end local v1    # "firstNodeToDiscard":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    :cond_4
    :goto_3
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->clearAllocationNodes(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V

    .line 88
    new-instance v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    iget v3, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocationLength:I

    invoke-direct {v0, v1, v2, v3}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;-><init>(JI)V

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 89
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 90
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 111
    :cond_5
    :goto_4
    return-void
.end method

.method public getTotalBytesWritten()J
    .locals 2

    .line 172
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    return-wide v0
.end method

.method public peekToBuffer(Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)V
    .locals 2
    .param p1, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p2, "extrasHolder"    # Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    .line 143
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v0, p1, p2, v1}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readSampleData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 144
    return-void
.end method

.method public readToBuffer(Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;)V
    .locals 2
    .param p1, "buffer"    # Landroidx/media3/decoder/DecoderInputBuffer;
    .param p2, "extrasHolder"    # Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;

    .line 130
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v0, p1, p2, v1}, Landroidx/media3/exoplayer/source/SampleDataQueue;->readSampleData(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;Landroidx/media3/decoder/DecoderInputBuffer;Landroidx/media3/exoplayer/source/SampleQueue$SampleExtrasHolder;Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 131
    return-void
.end method

.method public reset()V
    .locals 4

    .line 68
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->clearAllocationNodes(Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V

    .line 69
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocationLength:I

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v2, v3, v1}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->reset(JI)V

    .line 70
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 71
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 72
    iput-wide v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    .line 73
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->allocator:Landroidx/media3/exoplayer/upstream/Allocator;

    invoke-interface {v0}, Landroidx/media3/exoplayer/upstream/Allocator;->trim()V

    .line 74
    return-void
.end method

.method public rewind()V
    .locals 1

    .line 117
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->firstAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->readAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 118
    return-void
.end method

.method public sampleData(Landroidx/media3/common/DataReader;IZ)I
    .locals 4
    .param p1, "input"    # Landroidx/media3/common/DataReader;
    .param p2, "length"    # I
    .param p3, "allowEndOfInput"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 176
    invoke-direct {p0, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->preAppend(I)I

    move-result p2

    .line 177
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v0, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    iget-object v0, v0, Landroidx/media3/exoplayer/upstream/Allocation;->data:[B

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    .line 180
    invoke-virtual {v1, v2, v3}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->translateOffset(J)I

    move-result v1

    .line 178
    invoke-interface {p1, v0, v1, p2}, Landroidx/media3/common/DataReader;->read([BII)I

    move-result v0

    .line 182
    .local v0, "bytesAppended":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 183
    if-eqz p3, :cond_0

    .line 184
    return v1

    .line 186
    :cond_0
    new-instance v1, Ljava/io/EOFException;

    invoke-direct {v1}, Ljava/io/EOFException;-><init>()V

    throw v1

    .line 188
    :cond_1
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->postAppend(I)V

    .line 189
    return v0
.end method

.method public sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V
    .locals 5
    .param p1, "buffer"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "length"    # I

    .line 193
    nop

    :goto_0
    if-lez p2, :cond_0

    .line 194
    invoke-direct {p0, p2}, Landroidx/media3/exoplayer/source/SampleDataQueue;->preAppend(I)I

    move-result v0

    .line 195
    .local v0, "bytesAppended":I
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-object v1, v1, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    iget-object v1, v1, Landroidx/media3/exoplayer/upstream/Allocation;->data:[B

    iget-object v2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->writeAllocationNode:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    iget-wide v3, p0, Landroidx/media3/exoplayer/source/SampleDataQueue;->totalBytesWritten:J

    .line 197
    invoke-virtual {v2, v3, v4}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->translateOffset(J)I

    move-result v2

    .line 195
    invoke-virtual {p1, v1, v2, v0}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 199
    sub-int/2addr p2, v0

    .line 200
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/source/SampleDataQueue;->postAppend(I)V

    .line 201
    .end local v0    # "bytesAppended":I
    goto :goto_0

    .line 202
    :cond_0
    return-void
.end method
