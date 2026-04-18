.class public final Landroidx/media3/extractor/ts/H263Reader;
.super Ljava/lang/Object;
.source "H263Reader.java"

# interfaces
.implements Landroidx/media3/extractor/ts/ElementaryStreamReader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;,
        Landroidx/media3/extractor/ts/H263Reader$SampleReader;
    }
.end annotation


# static fields
.field private static final PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO:[F

.field private static final START_CODE_VALUE_GROUP_OF_VOP:I = 0xb3

.field private static final START_CODE_VALUE_MAX_VIDEO_OBJECT:I = 0x1f

.field private static final START_CODE_VALUE_UNSET:I = -0x1

.field private static final START_CODE_VALUE_USER_DATA:I = 0xb2

.field private static final START_CODE_VALUE_VISUAL_OBJECT:I = 0xb5

.field private static final START_CODE_VALUE_VISUAL_OBJECT_SEQUENCE:I = 0xb0

.field private static final START_CODE_VALUE_VOP:I = 0xb6

.field private static final TAG:Ljava/lang/String; = "H263Reader"

.field private static final VIDEO_OBJECT_LAYER_SHAPE_RECTANGULAR:I


# instance fields
.field private final csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

.field private formatId:Ljava/lang/String;

.field private hasOutputFormat:Z

.field private output:Landroidx/media3/extractor/TrackOutput;

.field private pesTimeUs:J

.field private final prefixFlags:[Z

.field private sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

.field private totalBytesWritten:J

.field private final userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

.field private final userDataParsable:Landroidx/media3/common/util/ParsableByteArray;

.field private final userDataReader:Landroidx/media3/extractor/ts/UserDataReader;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 63
    const/4 v0, 0x7

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/extractor/ts/H263Reader;->PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO:[F

    return-void

    nop

    :array_0
    .array-data 4
        0x3f800000    # 1.0f
        0x3f800000    # 1.0f
        0x3f8ba2e9
        0x3f68ba2f
        0x3fba2e8c
        0x3f9b26ca
        0x3f800000    # 1.0f
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .line 89
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroidx/media3/extractor/ts/H263Reader;-><init>(Landroidx/media3/extractor/ts/UserDataReader;)V

    .line 90
    return-void
.end method

.method constructor <init>(Landroidx/media3/extractor/ts/UserDataReader;)V
    .locals 4
    .param p1, "userDataReader"    # Landroidx/media3/extractor/ts/UserDataReader;

    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 93
    iput-object p1, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataReader:Landroidx/media3/extractor/ts/UserDataReader;

    .line 94
    const/4 v0, 0x4

    new-array v0, v0, [Z

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->prefixFlags:[Z

    .line 95
    new-instance v0, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    .line 96
    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v2, p0, Landroidx/media3/extractor/ts/H263Reader;->pesTimeUs:J

    .line 97
    if-eqz p1, :cond_0

    .line 98
    new-instance v0, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    const/16 v2, 0xb2

    invoke-direct {v0, v2, v1}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;-><init>(II)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    .line 99
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0}, Landroidx/media3/common/util/ParsableByteArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataParsable:Landroidx/media3/common/util/ParsableByteArray;

    goto :goto_0

    .line 101
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    .line 102
    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataParsable:Landroidx/media3/common/util/ParsableByteArray;

    .line 104
    :goto_0
    return-void
.end method

.method private static parseCsdBuffer(Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;ILjava/lang/String;)Landroidx/media3/common/Format;
    .locals 10
    .param p0, "csdBuffer"    # Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;
    .param p1, "volStartPosition"    # I
    .param p2, "formatId"    # Ljava/lang/String;

    .line 232
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->data:[B

    iget v1, p0, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->length:I

    invoke-static {v0, v1}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v0

    .line 233
    .local v0, "csdData":[B
    new-instance v1, Landroidx/media3/common/util/ParsableBitArray;

    invoke-direct {v1, v0}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    .line 234
    .local v1, "buffer":Landroidx/media3/common/util/ParsableBitArray;
    invoke-virtual {v1, p1}, Landroidx/media3/common/util/ParsableBitArray;->skipBytes(I)V

    .line 237
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBytes(I)V

    .line 238
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 239
    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 240
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v4

    const/4 v5, 0x3

    if-eqz v4, :cond_0

    .line 241
    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 242
    invoke-virtual {v1, v5}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 245
    :cond_0
    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    .line 246
    .local v2, "aspectRatioInfo":I
    const-string v4, "Invalid aspect ratio"

    const-string v6, "H263Reader"

    const/16 v7, 0xf

    if-ne v2, v7, :cond_2

    .line 247
    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v8

    .line 248
    .local v8, "parWidth":I
    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 249
    .local v3, "parHeight":I
    if-nez v3, :cond_1

    .line 250
    invoke-static {v6, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    const/high16 v4, 0x3f800000    # 1.0f

    .local v4, "pixelWidthHeightRatio":F
    goto :goto_0

    .line 253
    .end local v4    # "pixelWidthHeightRatio":F
    :cond_1
    int-to-float v4, v8

    int-to-float v9, v3

    div-float/2addr v4, v9

    .line 255
    .end local v3    # "parHeight":I
    .end local v8    # "parWidth":I
    .restart local v4    # "pixelWidthHeightRatio":F
    :goto_0
    goto :goto_1

    .end local v4    # "pixelWidthHeightRatio":F
    :cond_2
    sget-object v3, Landroidx/media3/extractor/ts/H263Reader;->PIXEL_WIDTH_HEIGHT_RATIO_BY_ASPECT_RATIO_INFO:[F

    array-length v8, v3

    if-ge v2, v8, :cond_3

    .line 256
    aget v4, v3, v2

    .restart local v4    # "pixelWidthHeightRatio":F
    goto :goto_1

    .line 258
    .end local v4    # "pixelWidthHeightRatio":F
    :cond_3
    invoke-static {v6, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    const/high16 v4, 0x3f800000    # 1.0f

    .line 261
    .restart local v4    # "pixelWidthHeightRatio":F
    :goto_1
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v3

    const/4 v8, 0x2

    if-eqz v3, :cond_4

    .line 262
    invoke-virtual {v1, v8}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 263
    const/4 v3, 0x1

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 264
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 265
    invoke-virtual {v1, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 266
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 267
    invoke-virtual {v1, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 268
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 269
    invoke-virtual {v1, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 270
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 271
    invoke-virtual {v1, v5}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 272
    const/16 v3, 0xb

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 273
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 274
    invoke-virtual {v1, v7}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 275
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 278
    :cond_4
    invoke-virtual {v1, v8}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 279
    .local v3, "videoObjectLayerShape":I
    if-eqz v3, :cond_5

    .line 280
    const-string v5, "Unhandled video object layer shape"

    invoke-static {v6, v5}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    :cond_5
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 283
    const/16 v5, 0x10

    invoke-virtual {v1, v5}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 284
    .local v5, "vopTimeIncrementResolution":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 285
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v7

    if-eqz v7, :cond_8

    .line 286
    if-nez v5, :cond_6

    .line 287
    const-string v7, "Invalid vop_increment_time_resolution"

    invoke-static {v6, v7}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    .line 289
    :cond_6
    add-int/lit8 v5, v5, -0x1

    .line 290
    const/4 v6, 0x0

    .line 291
    .local v6, "numBits":I
    :goto_2
    if-lez v5, :cond_7

    .line 292
    add-int/lit8 v6, v6, 0x1

    .line 293
    shr-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 295
    :cond_7
    invoke-virtual {v1, v6}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 298
    .end local v6    # "numBits":I
    :cond_8
    :goto_3
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 299
    const/16 v6, 0xd

    invoke-virtual {v1, v6}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v7

    .line 300
    .local v7, "videoObjectLayerWidth":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 301
    invoke-virtual {v1, v6}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v6

    .line 302
    .local v6, "videoObjectLayerHeight":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 303
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 304
    new-instance v8, Landroidx/media3/common/Format$Builder;

    invoke-direct {v8}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 305
    invoke-virtual {v8, p2}, Landroidx/media3/common/Format$Builder;->setId(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 306
    const-string/jumbo v9, "video/mp4v-es"

    invoke-virtual {v8, v9}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 307
    invoke-virtual {v8, v7}, Landroidx/media3/common/Format$Builder;->setWidth(I)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 308
    invoke-virtual {v8, v6}, Landroidx/media3/common/Format$Builder;->setHeight(I)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 309
    invoke-virtual {v8, v4}, Landroidx/media3/common/Format$Builder;->setPixelWidthHeightRatio(F)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 310
    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v8

    .line 311
    invoke-virtual {v8}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v8

    .line 304
    return-object v8
.end method


# virtual methods
.method public consume(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 13
    .param p1, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 140
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 143
    .local v0, "offset":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v1

    .line 144
    .local v1, "limit":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    .line 147
    .local v2, "dataArray":[B
    iget-wide v3, p0, Landroidx/media3/extractor/ts/H263Reader;->totalBytesWritten:J

    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v5

    int-to-long v5, v5

    add-long/2addr v3, v5

    iput-wide v3, p0, Landroidx/media3/extractor/ts/H263Reader;->totalBytesWritten:J

    .line 148
    iget-object v3, p0, Landroidx/media3/extractor/ts/H263Reader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v4

    invoke-interface {v3, p1, v4}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 151
    :goto_0
    iget-object v3, p0, Landroidx/media3/extractor/ts/H263Reader;->prefixFlags:[Z

    invoke-static {v2, v0, v1, v3}, Landroidx/media3/container/NalUnitUtil;->findNalUnit([BII[Z)I

    move-result v3

    .line 153
    .local v3, "startCodeOffset":I
    if-ne v3, v1, :cond_2

    .line 155
    iget-boolean v4, p0, Landroidx/media3/extractor/ts/H263Reader;->hasOutputFormat:Z

    if-nez v4, :cond_0

    .line 156
    iget-object v4, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    invoke-virtual {v4, v2, v0, v1}, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->onData([BII)V

    .line 158
    :cond_0
    iget-object v4, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    invoke-virtual {v4, v2, v0, v1}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;->onData([BII)V

    .line 159
    iget-object v4, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    if-eqz v4, :cond_1

    .line 160
    invoke-virtual {v4, v2, v0, v1}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->appendToNalUnit([BII)V

    .line 162
    :cond_1
    return-void

    .line 166
    :cond_2
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    add-int/lit8 v5, v3, 0x3

    aget-byte v4, v4, v5

    and-int/lit16 v4, v4, 0xff

    .line 169
    .local v4, "startCodeValue":I
    sub-int v5, v3, v0

    .line 171
    .local v5, "lengthToStartCode":I
    iget-boolean v6, p0, Landroidx/media3/extractor/ts/H263Reader;->hasOutputFormat:Z

    const/4 v7, 0x1

    if-nez v6, :cond_5

    .line 172
    if-lez v5, :cond_3

    .line 173
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    invoke-virtual {v6, v2, v0, v3}, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->onData([BII)V

    .line 177
    :cond_3
    if-gez v5, :cond_4

    neg-int v6, v5

    goto :goto_1

    :cond_4
    const/4 v6, 0x0

    .line 178
    .local v6, "bytesAlreadyPassed":I
    :goto_1
    iget-object v8, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    invoke-virtual {v8, v4, v6}, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->onStartCode(II)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 180
    iget-object v8, p0, Landroidx/media3/extractor/ts/H263Reader;->output:Landroidx/media3/extractor/TrackOutput;

    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    iget v10, v9, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->volStartPosition:I

    iget-object v11, p0, Landroidx/media3/extractor/ts/H263Reader;->formatId:Ljava/lang/String;

    .line 181
    invoke-static {v11}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    invoke-static {v9, v10, v11}, Landroidx/media3/extractor/ts/H263Reader;->parseCsdBuffer(Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;ILjava/lang/String;)Landroidx/media3/common/Format;

    move-result-object v9

    .line 180
    invoke-interface {v8, v9}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 182
    iput-boolean v7, p0, Landroidx/media3/extractor/ts/H263Reader;->hasOutputFormat:Z

    .line 186
    .end local v6    # "bytesAlreadyPassed":I
    :cond_5
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    invoke-virtual {v6, v2, v0, v3}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;->onData([BII)V

    .line 188
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    if-eqz v6, :cond_8

    .line 189
    const/4 v8, 0x0

    .line 190
    .local v8, "bytesAlreadyPassed":I
    if-lez v5, :cond_6

    .line 191
    invoke-virtual {v6, v2, v0, v3}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->appendToNalUnit([BII)V

    goto :goto_2

    .line 193
    :cond_6
    neg-int v8, v5

    .line 196
    :goto_2
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    invoke-virtual {v6, v8}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->endNalUnit(I)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 197
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    iget-object v6, v6, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->nalData:[B

    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    iget v9, v9, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->nalLength:I

    invoke-static {v6, v9}, Landroidx/media3/container/NalUnitUtil;->unescapeStream([BI)I

    move-result v6

    .line 198
    .local v6, "unescapedLength":I
    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataParsable:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v9}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/media3/common/util/ParsableByteArray;

    iget-object v10, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    iget-object v10, v10, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->nalData:[B

    invoke-virtual {v9, v10, v6}, Landroidx/media3/common/util/ParsableByteArray;->reset([BI)V

    .line 199
    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataReader:Landroidx/media3/extractor/ts/UserDataReader;

    invoke-static {v9}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/media3/extractor/ts/UserDataReader;

    iget-wide v10, p0, Landroidx/media3/extractor/ts/H263Reader;->pesTimeUs:J

    iget-object v12, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataParsable:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v9, v10, v11, v12}, Landroidx/media3/extractor/ts/UserDataReader;->consume(JLandroidx/media3/common/util/ParsableByteArray;)V

    .line 202
    .end local v6    # "unescapedLength":I
    :cond_7
    const/16 v6, 0xb2

    if-ne v4, v6, :cond_8

    .line 203
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    add-int/lit8 v9, v3, 0x2

    aget-byte v6, v6, v9

    if-ne v6, v7, :cond_8

    .line 204
    iget-object v6, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    invoke-virtual {v6, v4}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->startNalUnit(I)V

    .line 208
    .end local v8    # "bytesAlreadyPassed":I
    :cond_8
    sub-int v6, v1, v3

    .line 209
    .local v6, "bytesWrittenPastPosition":I
    iget-wide v7, p0, Landroidx/media3/extractor/ts/H263Reader;->totalBytesWritten:J

    int-to-long v9, v6

    sub-long/2addr v7, v9

    .line 210
    .local v7, "absolutePosition":J
    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    iget-boolean v10, p0, Landroidx/media3/extractor/ts/H263Reader;->hasOutputFormat:Z

    invoke-virtual {v9, v7, v8, v6, v10}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;->onDataEnd(JIZ)V

    .line 212
    iget-object v9, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    iget-wide v10, p0, Landroidx/media3/extractor/ts/H263Reader;->pesTimeUs:J

    invoke-virtual {v9, v4, v10, v11}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;->onStartCode(IJ)V

    .line 214
    add-int/lit8 v0, v3, 0x3

    .line 215
    .end local v3    # "startCodeOffset":I
    .end local v4    # "startCodeValue":I
    .end local v5    # "lengthToStartCode":I
    .end local v6    # "bytesWrittenPastPosition":I
    .end local v7    # "absolutePosition":J
    goto/16 :goto_0
.end method

.method public createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V
    .locals 2
    .param p1, "extractorOutput"    # Landroidx/media3/extractor/ExtractorOutput;
    .param p2, "idGenerator"    # Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;

    .line 122
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->generateNewId()V

    .line 123
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getFormatId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->formatId:Ljava/lang/String;

    .line 124
    invoke-virtual {p2}, Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;->getTrackId()I

    move-result v0

    const/4 v1, 0x2

    invoke-interface {p1, v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->output:Landroidx/media3/extractor/TrackOutput;

    .line 125
    new-instance v0, Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    iget-object v1, p0, Landroidx/media3/extractor/ts/H263Reader;->output:Landroidx/media3/extractor/TrackOutput;

    invoke-direct {v0, v1}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;-><init>(Landroidx/media3/extractor/TrackOutput;)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    .line 126
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userDataReader:Landroidx/media3/extractor/ts/UserDataReader;

    if-eqz v0, :cond_0

    .line 127
    invoke-virtual {v0, p1, p2}, Landroidx/media3/extractor/ts/UserDataReader;->createTracks(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/ts/TsPayloadReader$TrackIdGenerator;)V

    .line 129
    :cond_0
    return-void
.end method

.method public packetFinished()V
    .locals 0

    .line 221
    return-void
.end method

.method public packetStarted(JI)V
    .locals 0
    .param p1, "pesTimeUs"    # J
    .param p3, "flags"    # I

    .line 134
    iput-wide p1, p0, Landroidx/media3/extractor/ts/H263Reader;->pesTimeUs:J

    .line 135
    return-void
.end method

.method public seek()V
    .locals 2

    .line 108
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->prefixFlags:[Z

    invoke-static {v0}, Landroidx/media3/container/NalUnitUtil;->clearPrefixFlags([Z)V

    .line 109
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->csdBuffer:Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/H263Reader$CsdBuffer;->reset()V

    .line 110
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->sampleReader:Landroidx/media3/extractor/ts/H263Reader$SampleReader;

    if-eqz v0, :cond_0

    .line 111
    invoke-virtual {v0}, Landroidx/media3/extractor/ts/H263Reader$SampleReader;->reset()V

    .line 113
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/ts/H263Reader;->userData:Landroidx/media3/extractor/ts/NalUnitTargetBuffer;

    if-eqz v0, :cond_1

    .line 114
    invoke-virtual {v0}, Landroidx/media3/extractor/ts/NalUnitTargetBuffer;->reset()V

    .line 116
    :cond_1
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroidx/media3/extractor/ts/H263Reader;->totalBytesWritten:J

    .line 117
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/ts/H263Reader;->pesTimeUs:J

    .line 118
    return-void
.end method
