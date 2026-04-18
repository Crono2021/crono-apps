.class final Landroidx/media3/extractor/ts/H265Reader$SampleReader;
.super Ljava/lang/Object;
.source "H265Reader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/ts/H265Reader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "SampleReader"
.end annotation


# static fields
.field private static final FIRST_SLICE_FLAG_OFFSET:I = 0x2


# instance fields
.field private isFirstPrefixNalUnit:Z

.field private isFirstSlice:Z

.field private lookingForFirstSliceFlag:Z

.field private nalUnitBytesRead:I

.field private nalUnitHasKeyframeData:Z

.field private nalUnitPosition:J

.field private nalUnitTimeUs:J

.field private final output:Landroidx/media3/extractor/TrackOutput;

.field private readingPrefix:Z

.field private readingSample:Z

.field private sampleIsKeyframe:Z

.field private samplePosition:J

.field private sampleTimeUs:J


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/TrackOutput;)V
    .locals 0
    .param p1, "output"    # Landroidx/media3/extractor/TrackOutput;

    .line 308
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 309
    iput-object p1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 310
    return-void
.end method

.method private static isPrefixNalUnit(I)Z
    .locals 1
    .param p0, "nalUnitType"    # I

    .line 388
    const/16 v0, 0x20

    if-gt v0, p0, :cond_0

    const/16 v0, 0x23

    if-le p0, v0, :cond_1

    :cond_0
    const/16 v0, 0x27

    if-ne p0, v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static isVclBodyNalUnit(I)Z
    .locals 1
    .param p0, "nalUnitType"    # I

    .line 393
    const/16 v0, 0x20

    if-lt p0, v0, :cond_1

    const/16 v0, 0x28

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method private outputSample(I)V
    .locals 8
    .param p1, "offset"    # I

    .line 378
    iget-wide v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->sampleTimeUs:J

    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v1, v3

    if-nez v0, :cond_0

    .line 379
    return-void

    .line 381
    :cond_0
    iget-boolean v3, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->sampleIsKeyframe:Z

    .line 382
    .local v3, "flags":I
    iget-wide v4, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitPosition:J

    iget-wide v6, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->samplePosition:J

    sub-long/2addr v4, v6

    long-to-int v7, v4

    .line 383
    .local v7, "size":I
    iget-object v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->output:Landroidx/media3/extractor/TrackOutput;

    const/4 v6, 0x0

    move v4, v7

    move v5, p1

    invoke-interface/range {v0 .. v6}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 384
    return-void
.end method


# virtual methods
.method public endNalUnit(JIZ)V
    .locals 2
    .param p1, "position"    # J
    .param p3, "offset"    # I
    .param p4, "hasOutputFormat"    # Z

    .line 359
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstSlice:Z

    if-eqz v0, :cond_0

    .line 361
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitHasKeyframeData:Z

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->sampleIsKeyframe:Z

    .line 362
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    goto :goto_0

    .line 363
    :cond_0
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstPrefixNalUnit:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstSlice:Z

    if-eqz v0, :cond_3

    .line 365
    :cond_1
    if-eqz p4, :cond_2

    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingSample:Z

    if-eqz v0, :cond_2

    .line 367
    iget-wide v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitPosition:J

    sub-long v0, p1, v0

    long-to-int v0, v0

    .line 368
    .local v0, "nalUnitLength":I
    add-int v1, p3, v0

    invoke-direct {p0, v1}, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->outputSample(I)V

    .line 370
    .end local v0    # "nalUnitLength":I
    :cond_2
    iget-wide v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitPosition:J

    iput-wide v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->samplePosition:J

    .line 371
    iget-wide v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitTimeUs:J

    iput-wide v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->sampleTimeUs:J

    .line 372
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitHasKeyframeData:Z

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->sampleIsKeyframe:Z

    .line 373
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingSample:Z

    .line 375
    :cond_3
    :goto_0
    return-void
.end method

.method public readNalUnitData([BII)V
    .locals 3
    .param p1, "data"    # [B
    .param p2, "offset"    # I
    .param p3, "limit"    # I

    .line 347
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->lookingForFirstSliceFlag:Z

    if-eqz v0, :cond_2

    .line 348
    add-int/lit8 v0, p2, 0x2

    iget v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitBytesRead:I

    sub-int/2addr v0, v1

    .line 349
    .local v0, "headerOffset":I
    if-ge v0, p3, :cond_1

    .line 350
    aget-byte v1, p1, v0

    and-int/lit16 v1, v1, 0x80

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    move v1, v2

    :goto_0
    iput-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstSlice:Z

    .line 351
    iput-boolean v2, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->lookingForFirstSliceFlag:Z

    goto :goto_1

    .line 353
    :cond_1
    sub-int v2, p3, p2

    add-int/2addr v1, v2

    iput v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitBytesRead:I

    .line 356
    .end local v0    # "headerOffset":I
    :cond_2
    :goto_1
    return-void
.end method

.method public reset()V
    .locals 1

    .line 313
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->lookingForFirstSliceFlag:Z

    .line 314
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstSlice:Z

    .line 315
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstPrefixNalUnit:Z

    .line 316
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingSample:Z

    .line 317
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    .line 318
    return-void
.end method

.method public startNalUnit(JIIJZ)V
    .locals 3
    .param p1, "position"    # J
    .param p3, "offset"    # I
    .param p4, "nalUnitType"    # I
    .param p5, "pesTimeUs"    # J
    .param p7, "hasOutputFormat"    # Z

    .line 322
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstSlice:Z

    .line 323
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstPrefixNalUnit:Z

    .line 324
    iput-wide p5, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitTimeUs:J

    .line 325
    iput v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitBytesRead:I

    .line 326
    iput-wide p1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitPosition:J

    .line 328
    invoke-static {p4}, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isVclBodyNalUnit(I)Z

    move-result v1

    const/4 v2, 0x1

    if-nez v1, :cond_2

    .line 329
    iget-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingSample:Z

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    if-nez v1, :cond_1

    .line 330
    if-eqz p7, :cond_0

    .line 331
    invoke-direct {p0, p3}, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->outputSample(I)V

    .line 333
    :cond_0
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingSample:Z

    .line 335
    :cond_1
    invoke-static {p4}, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isPrefixNalUnit(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 336
    iget-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    xor-int/2addr v1, v2

    iput-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->isFirstPrefixNalUnit:Z

    .line 337
    iput-boolean v2, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->readingPrefix:Z

    .line 342
    :cond_2
    const/16 v1, 0x10

    if-lt p4, v1, :cond_3

    const/16 v1, 0x15

    if-gt p4, v1, :cond_3

    move v1, v2

    goto :goto_0

    :cond_3
    move v1, v0

    :goto_0
    iput-boolean v1, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->nalUnitHasKeyframeData:Z

    .line 343
    if-nez v1, :cond_4

    const/16 v1, 0x9

    if-gt p4, v1, :cond_5

    :cond_4
    move v0, v2

    :cond_5
    iput-boolean v0, p0, Landroidx/media3/extractor/ts/H265Reader$SampleReader;->lookingForFirstSliceFlag:Z

    .line 344
    return-void
.end method
