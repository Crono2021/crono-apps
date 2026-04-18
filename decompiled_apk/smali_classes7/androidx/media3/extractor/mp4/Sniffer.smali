.class final Landroidx/media3/extractor/mp4/Sniffer;
.super Ljava/lang/Object;
.source "Sniffer.java"


# static fields
.field public static final BRAND_HEIC:I = 0x68656963

.field public static final BRAND_QUICKTIME:I = 0x71742020

.field private static final COMPATIBLE_BRANDS:[I

.field private static final SEARCH_LENGTH:I = 0x1000


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 38
    const/16 v0, 0x1d

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/extractor/mp4/Sniffer;->COMPATIBLE_BRANDS:[I

    return-void

    :array_0
    .array-data 4
        0x69736f6d
        0x69736f32
        0x69736f33
        0x69736f34
        0x69736f35
        0x69736f36
        0x69736f39
        0x61766331
        0x68766331
        0x68657631
        0x61763031
        0x6d703431
        0x6d703432
        0x33673261
        0x33673262
        0x33677236
        0x33677336
        0x33676536
        0x33676736
        0x4d345620    # 1.8909645E8f
        0x4d344120    # 1.8901043E8f
        0x66347620
        0x6b646469
        0x4d345650
        0x71742020
        0x4d534e56    # 2.215704E8f
        0x64627931
        0x69736d6c
        0x70696666
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .line 233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 235
    return-void
.end method

.method private static isCompatibleBrand(IZ)Z
    .locals 6
    .param p0, "brand"    # I
    .param p1, "acceptHeic"    # Z

    .line 219
    ushr-int/lit8 v0, p0, 0x8

    const v1, 0x336770

    const/4 v2, 0x1

    if-ne v0, v1, :cond_0

    .line 221
    return v2

    .line 222
    :cond_0
    const v0, 0x68656963

    if-ne p0, v0, :cond_1

    if-eqz p1, :cond_1

    .line 223
    return v2

    .line 225
    :cond_1
    sget-object v0, Landroidx/media3/extractor/mp4/Sniffer;->COMPATIBLE_BRANDS:[I

    array-length v1, v0

    const/4 v3, 0x0

    move v4, v3

    :goto_0
    if-ge v4, v1, :cond_3

    aget v5, v0, v4

    .line 226
    .local v5, "compatibleBrand":I
    if-ne v5, p0, :cond_2

    .line 227
    return v2

    .line 225
    .end local v5    # "compatibleBrand":I
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 230
    :cond_3
    return v3
.end method

.method public static sniffFragmented(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 2
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 80
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Landroidx/media3/extractor/mp4/Sniffer;->sniffInternal(Landroidx/media3/extractor/ExtractorInput;ZZ)Z

    move-result v0

    return v0
.end method

.method private static sniffInternal(Landroidx/media3/extractor/ExtractorInput;ZZ)Z
    .locals 24
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "fragmented"    # Z
    .param p2, "acceptHeic"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 111
    move-object/from16 v0, p0

    invoke-interface/range {p0 .. p0}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v1

    .line 114
    .local v1, "inputLength":J
    const-wide/16 v3, -0x1

    cmp-long v5, v1, v3

    const-wide/16 v6, 0x1000

    if-eqz v5, :cond_1

    cmp-long v5, v1, v6

    if-lez v5, :cond_0

    goto :goto_0

    .line 116
    :cond_0
    move-wide v6, v1

    goto :goto_1

    .line 115
    :cond_1
    :goto_0
    nop

    .line 116
    :goto_1
    long-to-int v5, v6

    .line 118
    .local v5, "bytesToSearch":I
    new-instance v6, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v7, 0x40

    invoke-direct {v6, v7}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 119
    .local v6, "buffer":Landroidx/media3/common/util/ParsableByteArray;
    const/4 v7, 0x0

    .line 120
    .local v7, "bytesSearched":I
    const/4 v8, 0x0

    .line 121
    .local v8, "foundGoodFileType":Z
    const/4 v9, 0x0

    .line 122
    .local v9, "isFragmented":Z
    :goto_2
    const/4 v10, 0x1

    const/4 v11, 0x0

    if-ge v7, v5, :cond_13

    .line 124
    const/16 v12, 0x8

    .line 125
    .local v12, "headerSize":I
    invoke-virtual {v6, v12}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 126
    nop

    .line 127
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v13

    invoke-interface {v0, v13, v11, v12, v10}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v13

    .line 128
    .local v13, "success":Z
    if-nez v13, :cond_2

    .line 130
    move/from16 v4, p2

    move-wide/from16 v20, v1

    move v3, v11

    goto/16 :goto_9

    .line 132
    :cond_2
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v14

    .line 133
    .local v14, "atomSize":J
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    .line 134
    .local v10, "atomType":I
    const-wide/16 v16, 0x1

    cmp-long v16, v14, v16

    const/16 v11, 0x8

    if-nez v16, :cond_3

    .line 136
    const/16 v12, 0x10

    .line 137
    nop

    .line 138
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    .line 137
    invoke-interface {v0, v3, v11, v11}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 139
    const/16 v3, 0x10

    invoke-virtual {v6, v3}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 140
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v14

    goto :goto_3

    .line 141
    :cond_3
    const-wide/16 v3, 0x0

    cmp-long v3, v14, v3

    if-nez v3, :cond_5

    .line 143
    invoke-interface/range {p0 .. p0}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v3

    .line 144
    .local v3, "fileEndPosition":J
    const-wide/16 v18, -0x1

    cmp-long v16, v3, v18

    if-eqz v16, :cond_4

    .line 145
    invoke-interface/range {p0 .. p0}, Landroidx/media3/extractor/ExtractorInput;->getPeekPosition()J

    move-result-wide v20

    sub-long v20, v3, v20

    move-wide/from16 v22, v3

    .end local v3    # "fileEndPosition":J
    .local v22, "fileEndPosition":J
    int-to-long v3, v12

    add-long v14, v20, v3

    goto :goto_3

    .line 144
    .end local v22    # "fileEndPosition":J
    .restart local v3    # "fileEndPosition":J
    :cond_4
    move-wide/from16 v22, v3

    .line 149
    .end local v3    # "fileEndPosition":J
    :cond_5
    :goto_3
    int-to-long v3, v12

    cmp-long v3, v14, v3

    if-gez v3, :cond_6

    .line 151
    const/4 v3, 0x0

    return v3

    .line 153
    :cond_6
    add-int/2addr v7, v12

    .line 155
    const v3, 0x6d6f6f76

    if-ne v10, v3, :cond_8

    .line 158
    long-to-int v3, v14

    add-int/2addr v5, v3

    .line 159
    const-wide/16 v3, -0x1

    cmp-long v11, v1, v3

    if-eqz v11, :cond_7

    int-to-long v3, v5

    cmp-long v3, v3, v1

    if-lez v3, :cond_7

    .line 161
    long-to-int v5, v1

    const-wide/16 v3, -0x1

    goto :goto_2

    .line 122
    .end local v10    # "atomType":I
    .end local v12    # "headerSize":I
    .end local v13    # "success":Z
    .end local v14    # "atomSize":J
    :cond_7
    const-wide/16 v3, -0x1

    goto :goto_2

    .line 167
    .restart local v10    # "atomType":I
    .restart local v12    # "headerSize":I
    .restart local v13    # "success":Z
    .restart local v14    # "atomSize":J
    :cond_8
    const v3, 0x6d6f6f66

    if-eq v10, v3, :cond_12

    const v3, 0x6d766578

    if-ne v10, v3, :cond_9

    move/from16 v4, p2

    move-wide/from16 v20, v1

    const/4 v3, 0x0

    goto/16 :goto_8

    .line 173
    :cond_9
    const v3, 0x6d646174

    if-ne v10, v3, :cond_a

    .line 176
    const/4 v8, 0x1

    .line 179
    :cond_a
    int-to-long v3, v7

    add-long/2addr v3, v14

    move-wide/from16 v20, v1

    .end local v1    # "inputLength":J
    .local v20, "inputLength":J
    int-to-long v1, v12

    sub-long/2addr v3, v1

    int-to-long v1, v5

    cmp-long v1, v3, v1

    if-ltz v1, :cond_b

    .line 181
    move/from16 v4, p2

    const/4 v3, 0x0

    goto :goto_9

    .line 184
    :cond_b
    int-to-long v1, v12

    sub-long v1, v14, v1

    long-to-int v1, v1

    .line 185
    .local v1, "atomDataSize":I
    add-int/2addr v7, v1

    .line 186
    const v2, 0x66747970

    if-ne v10, v2, :cond_11

    .line 188
    if-ge v1, v11, :cond_c

    .line 189
    const/4 v2, 0x0

    return v2

    .line 191
    :cond_c
    const/4 v2, 0x0

    invoke-virtual {v6, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 192
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    invoke-interface {v0, v3, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 193
    div-int/lit8 v2, v1, 0x4

    .line 194
    .local v2, "brandsCount":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_4
    if-ge v3, v2, :cond_f

    .line 195
    const/4 v4, 0x1

    if-ne v3, v4, :cond_d

    .line 197
    const/4 v11, 0x4

    invoke-virtual {v6, v11}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    move/from16 v4, p2

    goto :goto_5

    .line 198
    :cond_d
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v11

    move/from16 v4, p2

    invoke-static {v11, v4}, Landroidx/media3/extractor/mp4/Sniffer;->isCompatibleBrand(IZ)Z

    move-result v11

    if-eqz v11, :cond_e

    .line 199
    const/4 v8, 0x1

    .line 200
    goto :goto_6

    .line 194
    :cond_e
    :goto_5
    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    :cond_f
    move/from16 v4, p2

    .line 203
    .end local v3    # "i":I
    :goto_6
    if-nez v8, :cond_10

    .line 205
    const/4 v3, 0x0

    return v3

    .line 207
    .end local v2    # "brandsCount":I
    :cond_10
    goto :goto_7

    :cond_11
    move/from16 v4, p2

    if-eqz v1, :cond_10

    .line 209
    invoke-interface {v0, v1}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 211
    .end local v1    # "atomDataSize":I
    .end local v10    # "atomType":I
    .end local v12    # "headerSize":I
    .end local v13    # "success":Z
    .end local v14    # "atomSize":J
    :goto_7
    move-wide/from16 v1, v20

    const-wide/16 v3, -0x1

    goto/16 :goto_2

    .line 167
    .end local v20    # "inputLength":J
    .local v1, "inputLength":J
    .restart local v10    # "atomType":I
    .restart local v12    # "headerSize":I
    .restart local v13    # "success":Z
    .restart local v14    # "atomSize":J
    :cond_12
    move/from16 v4, p2

    move-wide/from16 v20, v1

    const/4 v3, 0x0

    .line 169
    .end local v1    # "inputLength":J
    .restart local v20    # "inputLength":J
    :goto_8
    const/4 v9, 0x1

    .line 170
    goto :goto_9

    .line 122
    .end local v10    # "atomType":I
    .end local v12    # "headerSize":I
    .end local v13    # "success":Z
    .end local v14    # "atomSize":J
    .end local v20    # "inputLength":J
    .restart local v1    # "inputLength":J
    :cond_13
    move/from16 v4, p2

    move-wide/from16 v20, v1

    move v3, v11

    .line 212
    .end local v1    # "inputLength":J
    .restart local v20    # "inputLength":J
    :goto_9
    if-eqz v8, :cond_14

    move/from16 v1, p1

    if-ne v1, v9, :cond_15

    const/4 v10, 0x1

    goto :goto_a

    :cond_14
    move/from16 v1, p1

    :cond_15
    move v10, v3

    :goto_a
    return v10
.end method

.method public static sniffUnfragmented(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 1
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 92
    const/4 v0, 0x0

    invoke-static {p0, v0, v0}, Landroidx/media3/extractor/mp4/Sniffer;->sniffInternal(Landroidx/media3/extractor/ExtractorInput;ZZ)Z

    move-result v0

    return v0
.end method

.method public static sniffUnfragmented(Landroidx/media3/extractor/ExtractorInput;Z)Z
    .locals 1
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "acceptHeic"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 106
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Landroidx/media3/extractor/mp4/Sniffer;->sniffInternal(Landroidx/media3/extractor/ExtractorInput;ZZ)Z

    move-result v0

    return v0
.end method
