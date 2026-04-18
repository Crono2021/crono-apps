.class final Landroidx/media3/extractor/mp4/AtomParsers;
.super Ljava/lang/Object;
.source "AtomParsers.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;,
        Landroidx/media3/extractor/mp4/AtomParsers$StsdData;,
        Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;,
        Landroidx/media3/extractor/mp4/AtomParsers$Stz2SampleSizeBox;,
        Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;,
        Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;,
        Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    }
.end annotation


# static fields
.field private static final MAX_GAPLESS_TRIM_SIZE_SAMPLES:I = 0x4

.field private static final TAG:Ljava/lang/String; = "AtomParsers"

.field private static final TYPE_clcp:I = 0x636c6370

.field private static final TYPE_mdta:I = 0x6d647461

.field private static final TYPE_meta:I = 0x6d657461

.field private static final TYPE_nclc:I = 0x6e636c63

.field private static final TYPE_nclx:I = 0x6e636c78

.field private static final TYPE_sbtl:I = 0x7362746c

.field private static final TYPE_soun:I = 0x736f756e

.field private static final TYPE_subt:I = 0x73756274

.field private static final TYPE_text:I = 0x74657874

.field private static final TYPE_vide:I = 0x76696465

.field private static final opusMagic:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 104
    const-string v0, "OpusHead"

    invoke-static {v0}, Landroidx/media3/common/util/Util;->getUtf8Bytes(Ljava/lang/String;)[B

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/mp4/AtomParsers;->opusMagic:[B

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 2120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2122
    return-void
.end method

.method private static allocateHdrStaticInfo()Ljava/nio/ByteBuffer;
    .locals 2

    .line 1519
    const/16 v0, 0x19

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    sget-object v1, Ljava/nio/ByteOrder;->LITTLE_ENDIAN:Ljava/nio/ByteOrder;

    invoke-virtual {v0, v1}, Ljava/nio/ByteBuffer;->order(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;

    move-result-object v0

    return-object v0
.end method

.method private static canApplyEditWithGaplessInfo([JJJJ)Z
    .locals 7
    .param p0, "timestamps"    # [J
    .param p1, "duration"    # J
    .param p3, "editStartTime"    # J
    .param p5, "editEndTime"    # J

    .line 2110
    array-length v0, p0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    .line 2111
    .local v0, "lastIndex":I
    const/4 v2, 0x4

    const/4 v3, 0x0

    invoke-static {v2, v3, v0}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v4

    .line 2112
    .local v4, "latestDelayIndex":I
    array-length v5, p0

    sub-int/2addr v5, v2

    .line 2113
    invoke-static {v5, v3, v0}, Landroidx/media3/common/util/Util;->constrainValue(III)I

    move-result v2

    .line 2114
    .local v2, "earliestPaddingIndex":I
    aget-wide v5, p0, v3

    cmp-long v5, v5, p3

    if-gtz v5, :cond_0

    aget-wide v5, p0, v4

    cmp-long v5, p3, v5

    if-gez v5, :cond_0

    aget-wide v5, p0, v2

    cmp-long v5, v5, p5

    if-gez v5, :cond_0

    cmp-long v5, p5, p1

    if-gtz v5, :cond_0

    goto :goto_0

    :cond_0
    move v1, v3

    :goto_0
    return v1
.end method

.method private static canTrimSamplesWithTimestampChange(I)Z
    .locals 1
    .param p0, "trackType"    # I

    .line 776
    const/4 v0, 0x1

    if-eq p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static findBoxPosition(Landroidx/media3/common/util/ParsableByteArray;III)I
    .locals 6
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "boxType"    # I
    .param p2, "parentBoxPosition"    # I
    .param p3, "parentBoxSize"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1896
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 1897
    .local v0, "childAtomPosition":I
    const/4 v1, 0x1

    const/4 v2, 0x0

    if-lt v0, p2, :cond_0

    move v3, v1

    goto :goto_0

    :cond_0
    move v3, v2

    :goto_0
    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1898
    :goto_1
    sub-int v3, v0, p2

    if-ge v3, p3, :cond_3

    .line 1899
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1900
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v3

    .line 1901
    .local v3, "childAtomSize":I
    if-lez v3, :cond_1

    move v4, v1

    goto :goto_2

    :cond_1
    move v4, v2

    :goto_2
    const-string v5, "childAtomSize must be positive"

    invoke-static {v4, v5}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1902
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 1903
    .local v4, "childType":I
    if-ne v4, p1, :cond_2

    .line 1904
    return v0

    .line 1906
    :cond_2
    add-int/2addr v0, v3

    .line 1907
    .end local v3    # "childAtomSize":I
    .end local v4    # "childType":I
    goto :goto_1

    .line 1908
    :cond_3
    const/4 v1, -0x1

    return v1
.end method

.method private static getTrackTypeForHdlr(I)I
    .locals 1
    .param p0, "hdlr"    # I

    .line 903
    const v0, 0x736f756e

    if-ne p0, v0, :cond_0

    .line 904
    const/4 v0, 0x1

    return v0

    .line 905
    :cond_0
    const v0, 0x76696465

    if-ne p0, v0, :cond_1

    .line 906
    const/4 v0, 0x2

    return v0

    .line 907
    :cond_1
    const v0, 0x74657874

    if-eq p0, v0, :cond_4

    const v0, 0x7362746c

    if-eq p0, v0, :cond_4

    const v0, 0x73756274

    if-eq p0, v0, :cond_4

    const v0, 0x636c6370

    if-ne p0, v0, :cond_2

    goto :goto_0

    .line 909
    :cond_2
    const v0, 0x6d657461

    if-ne p0, v0, :cond_3

    .line 910
    const/4 v0, 0x5

    return v0

    .line 912
    :cond_3
    const/4 v0, -0x1

    return v0

    .line 908
    :cond_4
    :goto_0
    const/4 v0, 0x3

    return v0
.end method

.method public static maybeSkipRemainingMetaAtomHeaderBytes(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 3
    .param p0, "meta"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 282
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 287
    .local v0, "endPosition":I
    const/4 v1, 0x4

    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 288
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    const v2, 0x68646c72    # 4.3148E24f

    if-eq v1, v2, :cond_0

    .line 289
    add-int/lit8 v0, v0, 0x4

    .line 291
    :cond_0
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 292
    return-void
.end method

.method private static parseAudioSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIILjava/lang/String;ZLandroidx/media3/common/DrmInitData;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;I)V
    .locals 27
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "atomType"    # I
    .param p2, "position"    # I
    .param p3, "size"    # I
    .param p4, "trackId"    # I
    .param p5, "language"    # Ljava/lang/String;
    .param p6, "isQuickTime"    # Z
    .param p7, "drmInitData"    # Landroidx/media3/common/DrmInitData;
    .param p8, "out"    # Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    .param p9, "entryIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1587
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p3

    move/from16 v3, p4

    move-object/from16 v4, p5

    move-object/from16 v5, p7

    move-object/from16 v6, p8

    add-int/lit8 v7, v1, 0x8

    const/16 v8, 0x8

    add-int/2addr v7, v8

    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1589
    const/4 v7, 0x0

    .line 1590
    .local v7, "quickTimeSoundDescriptionVersion":I
    const/4 v9, 0x6

    if-eqz p6, :cond_0

    .line 1591
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v7

    .line 1592
    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    goto :goto_0

    .line 1594
    :cond_0
    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1599
    :goto_0
    const/4 v10, 0x0

    .line 1600
    .local v10, "sampleRateMlp":I
    const/4 v11, -0x1

    .line 1601
    .local v11, "pcmEncoding":I
    const/4 v12, 0x0

    .line 1602
    .local v12, "codecs":Ljava/lang/String;
    const/4 v13, 0x0

    .line 1604
    .local v13, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    const/16 v14, 0x10

    const/4 v15, 0x2

    const/4 v9, 0x4

    const/4 v8, 0x1

    if-eqz v7, :cond_d

    if-ne v7, v8, :cond_1

    goto/16 :goto_7

    .line 1616
    :cond_1
    if-ne v7, v15, :cond_c

    .line 1617
    invoke-virtual {v0, v14}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1619
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readDouble()D

    move-result-wide v19

    invoke-static/range {v19 .. v20}, Ljava/lang/Math;->round(D)J

    move-result-wide v14

    long-to-int v14, v14

    .line 1620
    .local v14, "sampleRate":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v15

    .line 1622
    .local v15, "channelCount":I
    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1623
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v8

    .line 1624
    .local v8, "bitsPerSample":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v16

    .line 1625
    .local v16, "formatSpecificFlags":I
    and-int/lit8 v20, v16, 0x1

    if-eqz v20, :cond_2

    const/16 v20, 0x1

    goto :goto_1

    :cond_2
    const/16 v20, 0x0

    .line 1626
    .local v20, "isFloat":Z
    :goto_1
    and-int/lit8 v23, v16, 0x2

    if-eqz v23, :cond_3

    const/16 v23, 0x1

    goto :goto_2

    :cond_3
    const/16 v23, 0x0

    .line 1627
    .local v23, "isBigEndian":Z
    :goto_2
    if-nez v20, :cond_a

    .line 1628
    const/16 v9, 0x8

    if-ne v8, v9, :cond_4

    .line 1629
    const/4 v9, 0x3

    move v11, v9

    .end local v11    # "pcmEncoding":I
    .local v9, "pcmEncoding":I
    goto :goto_6

    .line 1630
    .end local v9    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    :cond_4
    const/16 v9, 0x10

    if-ne v8, v9, :cond_6

    .line 1631
    if-eqz v23, :cond_5

    const/high16 v9, 0x10000000

    goto :goto_3

    :cond_5
    const/4 v9, 0x2

    :goto_3
    move v11, v9

    .end local v11    # "pcmEncoding":I
    .restart local v9    # "pcmEncoding":I
    goto :goto_6

    .line 1632
    .end local v9    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    :cond_6
    const/16 v9, 0x18

    if-ne v8, v9, :cond_8

    .line 1633
    if-eqz v23, :cond_7

    const/high16 v9, 0x50000000

    goto :goto_4

    :cond_7
    const/16 v9, 0x15

    :goto_4
    move v11, v9

    .end local v11    # "pcmEncoding":I
    .restart local v9    # "pcmEncoding":I
    goto :goto_6

    .line 1634
    .end local v9    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    :cond_8
    const/16 v9, 0x20

    if-ne v8, v9, :cond_b

    .line 1635
    if-eqz v23, :cond_9

    const/high16 v9, 0x60000000

    goto :goto_5

    :cond_9
    const/16 v9, 0x16

    :goto_5
    move v11, v9

    .end local v11    # "pcmEncoding":I
    .restart local v9    # "pcmEncoding":I
    goto :goto_6

    .line 1637
    .end local v9    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    :cond_a
    const/16 v9, 0x20

    if-ne v8, v9, :cond_b

    .line 1638
    const/4 v9, 0x4

    move v11, v9

    .line 1640
    :cond_b
    :goto_6
    const/16 v9, 0x8

    invoke-virtual {v0, v9}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1641
    .end local v8    # "bitsPerSample":I
    .end local v16    # "formatSpecificFlags":I
    .end local v20    # "isFloat":Z
    .end local v23    # "isBigEndian":Z
    goto :goto_8

    .line 1643
    .end local v14    # "sampleRate":I
    .end local v15    # "channelCount":I
    :cond_c
    return-void

    .line 1605
    :cond_d
    :goto_7
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v15

    .line 1606
    .restart local v15    # "channelCount":I
    const/4 v8, 0x6

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1608
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedFixedPoint1616()I

    move-result v14

    .line 1610
    .restart local v14    # "sampleRate":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v8

    const/4 v9, 0x4

    sub-int/2addr v8, v9

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1611
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    .line 1613
    const/4 v8, 0x1

    if-ne v7, v8, :cond_e

    .line 1614
    const/16 v8, 0x10

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1646
    :cond_e
    :goto_8
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v8

    .line 1647
    .local v8, "childPosition":I
    const v9, 0x656e6361

    move/from16 v16, v7

    .end local v7    # "quickTimeSoundDescriptionVersion":I
    .local v16, "quickTimeSoundDescriptionVersion":I
    move/from16 v7, p1

    if-ne v7, v9, :cond_11

    .line 1649
    nop

    .line 1650
    invoke-static {v0, v1, v2}, Landroidx/media3/extractor/mp4/AtomParsers;->parseSampleEntryEncryptionData(Landroidx/media3/common/util/ParsableByteArray;II)Landroid/util/Pair;

    move-result-object v9

    .line 1651
    .local v9, "sampleEntryEncryptionData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    if-eqz v9, :cond_10

    .line 1652
    iget-object v7, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    .line 1654
    .end local p1    # "atomType":I
    .local v7, "atomType":I
    if-nez v5, :cond_f

    .line 1655
    move/from16 p1, v7

    const/4 v7, 0x0

    goto :goto_9

    .line 1656
    :cond_f
    move/from16 p1, v7

    .end local v7    # "atomType":I
    .restart local p1    # "atomType":I
    iget-object v7, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v7, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    iget-object v7, v7, Landroidx/media3/extractor/mp4/TrackEncryptionBox;->schemeType:Ljava/lang/String;

    invoke-virtual {v5, v7}, Landroidx/media3/common/DrmInitData;->copyWithSchemeType(Ljava/lang/String;)Landroidx/media3/common/DrmInitData;

    move-result-object v7

    :goto_9
    move-object v5, v7

    .line 1657
    .end local p7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .local v5, "drmInitData":Landroidx/media3/common/DrmInitData;
    iget-object v7, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->trackEncryptionBoxes:[Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-object/from16 p7, v5

    .end local v5    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .restart local p7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    iget-object v5, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    aput-object v5, v7, p9

    move/from16 v5, p1

    move-object/from16 v7, p7

    goto :goto_a

    .line 1651
    :cond_10
    move-object v7, v5

    move/from16 v5, p1

    .line 1659
    .end local p1    # "atomType":I
    .end local p7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .local v5, "atomType":I
    .local v7, "drmInitData":Landroidx/media3/common/DrmInitData;
    :goto_a
    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    goto :goto_b

    .line 1647
    .end local v5    # "atomType":I
    .end local v7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .end local v9    # "sampleEntryEncryptionData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    .restart local p1    # "atomType":I
    .restart local p7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    :cond_11
    move-object v7, v5

    move/from16 v5, p1

    .line 1667
    .end local p1    # "atomType":I
    .end local p7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .restart local v5    # "atomType":I
    .restart local v7    # "drmInitData":Landroidx/media3/common/DrmInitData;
    :goto_b
    const/4 v9, 0x0

    .line 1668
    .local v9, "mimeType":Ljava/lang/String;
    move/from16 v20, v8

    .end local v8    # "childPosition":I
    .local v20, "childPosition":I
    const v8, 0x61632d33

    move-object/from16 p1, v9

    .end local v9    # "mimeType":Ljava/lang/String;
    .local p1, "mimeType":Ljava/lang/String;
    const/4 v9, -0x1

    if-ne v5, v8, :cond_12

    .line 1669
    const-string v8, "audio/ac3"

    .end local p1    # "mimeType":Ljava/lang/String;
    .local v8, "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1670
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_12
    const v8, 0x65632d33

    if-ne v5, v8, :cond_13

    .line 1671
    const-string v8, "audio/eac3"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1672
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_13
    const v8, 0x61632d34

    if-ne v5, v8, :cond_14

    .line 1673
    const-string v8, "audio/ac4"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1674
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_14
    const v8, 0x64747363

    if-ne v5, v8, :cond_15

    .line 1675
    const-string v8, "audio/vnd.dts"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1676
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_15
    const v8, 0x64747368

    if-eq v5, v8, :cond_28

    const v8, 0x6474736c

    if-ne v5, v8, :cond_16

    goto/16 :goto_d

    .line 1678
    :cond_16
    const v8, 0x64747365

    if-ne v5, v8, :cond_17

    .line 1679
    const-string v8, "audio/vnd.dts.hd;profile=lbr"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1680
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_17
    const v8, 0x64747378

    if-ne v5, v8, :cond_18

    .line 1681
    const-string v8, "audio/vnd.dts.uhd;profile=p2"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1682
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_18
    const v8, 0x73616d72

    if-ne v5, v8, :cond_19

    .line 1683
    const-string v8, "audio/3gpp"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1684
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_19
    const v8, 0x73617762

    if-ne v5, v8, :cond_1a

    .line 1685
    const-string v8, "audio/amr-wb"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto/16 :goto_e

    .line 1686
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_1a
    const v8, 0x736f7774

    if-ne v5, v8, :cond_1b

    .line 1687
    const-string v8, "audio/raw"

    .line 1688
    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    const/4 v11, 0x2

    goto/16 :goto_e

    .line 1689
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_1b
    const v8, 0x74776f73

    if-ne v5, v8, :cond_1c

    .line 1690
    const-string v8, "audio/raw"

    .line 1691
    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    const/high16 v11, 0x10000000

    goto/16 :goto_e

    .line 1692
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_1c
    const v8, 0x6c70636d

    if-ne v5, v8, :cond_1d

    .line 1693
    const-string v8, "audio/raw"

    .line 1694
    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    if-ne v11, v9, :cond_29

    .line 1695
    const/4 v11, 0x2

    goto :goto_e

    .line 1697
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_1d
    const v8, 0x2e6d7032

    if-eq v5, v8, :cond_27

    const v8, 0x2e6d7033

    if-ne v5, v8, :cond_1e

    goto :goto_c

    .line 1699
    :cond_1e
    const v8, 0x6d686131

    if-ne v5, v8, :cond_1f

    .line 1700
    const-string v8, "audio/mha1"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1701
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_1f
    const v8, 0x6d686d31

    if-ne v5, v8, :cond_20

    .line 1702
    const-string v8, "audio/mhm1"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1703
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_20
    const v8, 0x616c6163

    if-ne v5, v8, :cond_21

    .line 1704
    const-string v8, "audio/alac"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1705
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_21
    const v8, 0x616c6177

    if-ne v5, v8, :cond_22

    .line 1706
    const-string v8, "audio/g711-alaw"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1707
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_22
    const v8, 0x756c6177

    if-ne v5, v8, :cond_23

    .line 1708
    const-string v8, "audio/g711-mlaw"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1709
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_23
    const v8, 0x4f707573

    if-ne v5, v8, :cond_24

    .line 1710
    const-string v8, "audio/opus"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1711
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_24
    const v8, 0x664c6143

    if-ne v5, v8, :cond_25

    .line 1712
    const-string v8, "audio/flac"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1713
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_25
    const v8, 0x6d6c7061

    if-ne v5, v8, :cond_26

    .line 1714
    const-string v8, "audio/true-hd"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1713
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_26
    move-object/from16 v8, p1

    goto :goto_e

    .line 1698
    :cond_27
    :goto_c
    const-string v8, "audio/mpeg"

    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    goto :goto_e

    .line 1677
    .end local v8    # "mimeType":Ljava/lang/String;
    .restart local p1    # "mimeType":Ljava/lang/String;
    :cond_28
    :goto_d
    const-string v8, "audio/vnd.dts.hd"

    .line 1717
    .end local p1    # "mimeType":Ljava/lang/String;
    .restart local v8    # "mimeType":Ljava/lang/String;
    :cond_29
    :goto_e
    const/16 v21, 0x0

    move v9, v15

    move v15, v14

    move-object v14, v13

    move-object v13, v12

    move-object v12, v8

    move/from16 v8, v20

    move/from16 v20, v5

    move-object/from16 v5, v21

    .line 1718
    .local v5, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v8, "childPosition":I
    .local v9, "channelCount":I
    .local v12, "mimeType":Ljava/lang/String;
    .local v13, "codecs":Ljava/lang/String;
    .local v14, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .local v15, "sampleRate":I
    .local v20, "atomType":I
    :goto_f
    move-object/from16 v21, v14

    .end local v14    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .local v21, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    sub-int v14, v8, v1

    if-ge v14, v2, :cond_42

    .line 1719
    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1720
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v14

    .line 1721
    .local v14, "childAtomSize":I
    if-lez v14, :cond_2a

    const/4 v1, 0x1

    goto :goto_10

    :cond_2a
    const/4 v1, 0x0

    :goto_10
    const-string v2, "childAtomSize must be positive"

    invoke-static {v1, v2}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1722
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1723
    .local v1, "childAtomType":I
    const v2, 0x6d686143

    if-ne v1, v2, :cond_2d

    .line 1727
    add-int/lit8 v2, v8, 0x8

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1728
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1729
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v23

    .line 1730
    .local v23, "mpeghProfileLevelIndication":I
    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1732
    const-string v2, "audio/mhm1"

    invoke-static {v12, v2}, Ljava/util/Objects;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2b

    .line 1733
    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    filled-new-array {v2}, [Ljava/lang/Object;

    move-result-object v2

    move/from16 v24, v11

    .end local v11    # "pcmEncoding":I
    .local v24, "pcmEncoding":I
    const-string/jumbo v11, "mhm1.%02X"

    invoke-static {v11, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_11

    .line 1734
    .end local v24    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    :cond_2b
    move/from16 v24, v11

    .end local v11    # "pcmEncoding":I
    .restart local v24    # "pcmEncoding":I
    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    filled-new-array {v2}, [Ljava/lang/Object;

    move-result-object v2

    const-string/jumbo v11, "mha1.%02X"

    invoke-static {v11, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    :goto_11
    nop

    .line 1735
    .end local v13    # "codecs":Ljava/lang/String;
    .local v2, "codecs":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v11

    .line 1736
    .local v11, "mpegh3daConfigLength":I
    new-array v13, v11, [B

    .line 1737
    .local v13, "initializationDataBytes":[B
    move-object/from16 v25, v2

    const/4 v2, 0x0

    .end local v2    # "codecs":Ljava/lang/String;
    .local v25, "codecs":Ljava/lang/String;
    invoke-virtual {v0, v13, v2, v11}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1739
    if-nez v5, :cond_2c

    .line 1740
    invoke-static {v13}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    goto :goto_12

    .line 1744
    :cond_2c
    invoke-interface {v5, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v26

    move-object/from16 v2, v26

    check-cast v2, [B

    invoke-static {v13, v2}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    .line 1746
    .end local v11    # "mpegh3daConfigLength":I
    .end local v13    # "initializationDataBytes":[B
    .end local v23    # "mpeghProfileLevelIndication":I
    :goto_12
    move-object/from16 v13, v25

    const/16 v19, 0x2

    move/from16 v25, v10

    goto/16 :goto_19

    .end local v24    # "pcmEncoding":I
    .end local v25    # "codecs":Ljava/lang/String;
    .local v11, "pcmEncoding":I
    .local v13, "codecs":Ljava/lang/String;
    :cond_2d
    move/from16 v24, v11

    .end local v11    # "pcmEncoding":I
    .restart local v24    # "pcmEncoding":I
    const v2, 0x6d686150

    if-ne v1, v2, :cond_30

    .line 1749
    add-int/lit8 v2, v8, 0x8

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1750
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v2

    .line 1751
    .local v2, "numCompatibleSets":I
    if-lez v2, :cond_2f

    .line 1752
    new-array v11, v2, [B

    .line 1753
    .local v11, "mpeghCompatibleProfileLevelSet":[B
    move-object/from16 v23, v13

    const/4 v13, 0x0

    .end local v13    # "codecs":Ljava/lang/String;
    .local v23, "codecs":Ljava/lang/String;
    invoke-virtual {v0, v11, v13, v2}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1754
    if-nez v5, :cond_2e

    .line 1755
    invoke-static {v11}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    goto :goto_13

    .line 1759
    :cond_2e
    nop

    .line 1760
    invoke-interface {v5, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v25

    move-object/from16 v13, v25

    check-cast v13, [B

    invoke-static {v13, v11}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    goto :goto_13

    .line 1751
    .end local v11    # "mpeghCompatibleProfileLevelSet":[B
    .end local v23    # "codecs":Ljava/lang/String;
    .restart local v13    # "codecs":Ljava/lang/String;
    :cond_2f
    move-object/from16 v23, v13

    .line 1763
    .end local v2    # "numCompatibleSets":I
    .end local v13    # "codecs":Ljava/lang/String;
    .restart local v23    # "codecs":Ljava/lang/String;
    :goto_13
    move/from16 v25, v10

    move-object/from16 v13, v23

    const/16 v19, 0x2

    goto/16 :goto_19

    .end local v23    # "codecs":Ljava/lang/String;
    .restart local v13    # "codecs":Ljava/lang/String;
    :cond_30
    move-object/from16 v23, v13

    .end local v13    # "codecs":Ljava/lang/String;
    .restart local v23    # "codecs":Ljava/lang/String;
    const v2, 0x65736473

    if-eq v1, v2, :cond_3c

    if-eqz p6, :cond_31

    const v11, 0x77617665

    if-ne v1, v11, :cond_31

    move/from16 v25, v10

    const/16 v19, 0x2

    goto/16 :goto_16

    .line 1791
    :cond_31
    const v2, 0x64616333

    if-ne v1, v2, :cond_32

    .line 1792
    add-int/lit8 v2, v8, 0x8

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1793
    nop

    .line 1794
    invoke-static/range {p4 .. p4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v4, v7}, Landroidx/media3/extractor/Ac3Util;->parseAc3AnnexFFormat(Landroidx/media3/common/util/ParsableByteArray;Ljava/lang/String;Ljava/lang/String;Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format;

    move-result-object v2

    iput-object v2, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    move/from16 v25, v10

    const/16 v19, 0x2

    goto/16 :goto_15

    .line 1795
    :cond_32
    const v2, 0x64656333

    if-ne v1, v2, :cond_33

    .line 1796
    add-int/lit8 v2, v8, 0x8

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1797
    nop

    .line 1798
    invoke-static/range {p4 .. p4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v4, v7}, Landroidx/media3/extractor/Ac3Util;->parseEAc3AnnexFFormat(Landroidx/media3/common/util/ParsableByteArray;Ljava/lang/String;Ljava/lang/String;Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format;

    move-result-object v2

    iput-object v2, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    move/from16 v25, v10

    const/16 v19, 0x2

    goto/16 :goto_15

    .line 1799
    :cond_33
    const v2, 0x64616334

    if-ne v1, v2, :cond_34

    .line 1800
    add-int/lit8 v2, v8, 0x8

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1801
    nop

    .line 1802
    invoke-static/range {p4 .. p4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2, v4, v7}, Landroidx/media3/extractor/Ac4Util;->parseAc4AnnexEFormat(Landroidx/media3/common/util/ParsableByteArray;Ljava/lang/String;Ljava/lang/String;Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format;

    move-result-object v2

    iput-object v2, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    move/from16 v25, v10

    const/16 v19, 0x2

    goto/16 :goto_15

    .line 1803
    :cond_34
    const v2, 0x646d6c70

    if-ne v1, v2, :cond_36

    .line 1804
    if-lez v10, :cond_35

    .line 1809
    move v2, v10

    .line 1813
    .end local v15    # "sampleRate":I
    .local v2, "sampleRate":I
    const/4 v9, 0x2

    move v15, v2

    move/from16 v25, v10

    move-object/from16 v13, v23

    const/16 v19, 0x2

    goto/16 :goto_19

    .line 1805
    .end local v2    # "sampleRate":I
    .restart local v15    # "sampleRate":I
    :cond_35
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Invalid sample rate for Dolby TrueHD MLP stream: "

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v11, 0x0

    invoke-static {v2, v11}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v2

    throw v2

    .line 1814
    :cond_36
    const/4 v11, 0x0

    const v2, 0x64647473

    if-eq v1, v2, :cond_3a

    const v2, 0x75647473

    if-ne v1, v2, :cond_37

    move/from16 v25, v10

    const/16 v19, 0x2

    goto/16 :goto_14

    .line 1824
    :cond_37
    const v2, 0x644f7073

    if-ne v1, v2, :cond_38

    .line 1827
    add-int/lit8 v2, v14, -0x8

    .line 1828
    .local v2, "childAtomBodySize":I
    sget-object v13, Landroidx/media3/extractor/mp4/AtomParsers;->opusMagic:[B

    array-length v11, v13

    add-int/2addr v11, v2

    invoke-static {v13, v11}, Ljava/util/Arrays;->copyOf([BI)[B

    move-result-object v11

    .line 1829
    .local v11, "headerBytes":[B
    move/from16 v25, v10

    .end local v10    # "sampleRateMlp":I
    .local v25, "sampleRateMlp":I
    add-int/lit8 v10, v8, 0x8

    invoke-virtual {v0, v10}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1830
    array-length v10, v13

    invoke-virtual {v0, v11, v10, v2}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1831
    invoke-static {v11}, Landroidx/media3/extractor/OpusUtil;->buildInitializationData([B)Ljava/util/List;

    move-result-object v2

    .line 1832
    .end local v5    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .end local v11    # "headerBytes":[B
    .local v2, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    move-object v5, v2

    move-object/from16 v13, v23

    const/16 v19, 0x2

    goto/16 :goto_19

    .end local v2    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .end local v25    # "sampleRateMlp":I
    .restart local v5    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v10    # "sampleRateMlp":I
    :cond_38
    move/from16 v25, v10

    .end local v10    # "sampleRateMlp":I
    .restart local v25    # "sampleRateMlp":I
    const v2, 0x64664c61

    if-ne v1, v2, :cond_39

    .line 1833
    add-int/lit8 v2, v14, -0xc

    .line 1834
    .local v2, "childAtomBodySize":I
    add-int/lit8 v10, v2, 0x4

    new-array v10, v10, [B

    .line 1835
    .local v10, "initializationDataBytes":[B
    const/16 v11, 0x66

    const/4 v13, 0x0

    aput-byte v11, v10, v13

    .line 1836
    const/16 v11, 0x4c

    const/4 v13, 0x1

    aput-byte v11, v10, v13

    .line 1837
    const/16 v11, 0x61

    const/16 v19, 0x2

    aput-byte v11, v10, v19

    .line 1838
    const/4 v11, 0x3

    const/16 v22, 0x43

    aput-byte v22, v10, v11

    .line 1839
    add-int/lit8 v11, v8, 0xc

    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1840
    const/4 v11, 0x4

    invoke-virtual {v0, v10, v11, v2}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1841
    invoke-static {v10}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    .line 1842
    .end local v5    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .end local v10    # "initializationDataBytes":[B
    .local v2, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    move-object v5, v2

    move-object/from16 v13, v23

    goto/16 :goto_19

    .end local v2    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v5    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    :cond_39
    const/4 v11, 0x4

    const/4 v13, 0x1

    const/16 v19, 0x2

    const v10, 0x616c6163

    if-ne v1, v10, :cond_3b

    .line 1843
    add-int/lit8 v2, v14, -0xc

    .line 1844
    .local v2, "childAtomBodySize":I
    new-array v10, v2, [B

    .line 1845
    .restart local v10    # "initializationDataBytes":[B
    add-int/lit8 v11, v8, 0xc

    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1846
    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11, v2}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1849
    nop

    .line 1850
    invoke-static {v10}, Landroidx/media3/common/util/CodecSpecificDataUtil;->parseAlacAudioSpecificConfig([B)Landroid/util/Pair;

    move-result-object v11

    .line 1851
    .local v11, "audioSpecificConfig":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    iget-object v13, v11, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v13, Ljava/lang/Integer;

    invoke-virtual {v13}, Ljava/lang/Integer;->intValue()I

    move-result v13

    .line 1852
    .end local v15    # "sampleRate":I
    .local v13, "sampleRate":I
    iget-object v15, v11, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v15, Ljava/lang/Integer;

    invoke-virtual {v15}, Ljava/lang/Integer;->intValue()I

    move-result v9

    .line 1853
    invoke-static {v10}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    move v15, v13

    move-object/from16 v13, v23

    goto/16 :goto_19

    .line 1814
    .end local v2    # "childAtomBodySize":I
    .end local v11    # "audioSpecificConfig":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    .end local v13    # "sampleRate":I
    .end local v25    # "sampleRateMlp":I
    .local v10, "sampleRateMlp":I
    .restart local v15    # "sampleRate":I
    :cond_3a
    move/from16 v25, v10

    const/16 v19, 0x2

    .line 1815
    .end local v10    # "sampleRateMlp":I
    .restart local v25    # "sampleRateMlp":I
    :goto_14
    new-instance v2, Landroidx/media3/common/Format$Builder;

    invoke-direct {v2}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 1817
    invoke-virtual {v2, v3}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1818
    invoke-virtual {v2, v12}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1819
    invoke-virtual {v2, v9}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1820
    invoke-virtual {v2, v15}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1821
    invoke-virtual {v2, v7}, Landroidx/media3/common/Format$Builder;->setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1822
    invoke-virtual {v2, v4}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v2

    .line 1823
    invoke-virtual {v2}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v2

    iput-object v2, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    .line 1855
    .end local v25    # "sampleRateMlp":I
    .restart local v10    # "sampleRateMlp":I
    :cond_3b
    :goto_15
    move-object/from16 v13, v23

    .end local v10    # "sampleRateMlp":I
    .restart local v25    # "sampleRateMlp":I
    goto :goto_19

    .line 1763
    .end local v25    # "sampleRateMlp":I
    .restart local v10    # "sampleRateMlp":I
    :cond_3c
    move/from16 v25, v10

    const/16 v19, 0x2

    .line 1766
    .end local v10    # "sampleRateMlp":I
    .restart local v25    # "sampleRateMlp":I
    :goto_16
    if-ne v1, v2, :cond_3d

    .line 1767
    move v2, v8

    goto :goto_17

    .line 1768
    :cond_3d
    invoke-static {v0, v2, v8, v14}, Landroidx/media3/extractor/mp4/AtomParsers;->findBoxPosition(Landroidx/media3/common/util/ParsableByteArray;III)I

    move-result v2

    :goto_17
    nop

    .line 1769
    .local v2, "esdsAtomPosition":I
    const/4 v10, -0x1

    if-eq v2, v10, :cond_41

    .line 1770
    invoke-static {v0, v2}, Landroidx/media3/extractor/mp4/AtomParsers;->parseEsdsFromParent(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    move-result-object v11

    .line 1771
    .end local v21    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .local v11, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    invoke-static {v11}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$300(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)Ljava/lang/String;

    move-result-object v12

    .line 1772
    invoke-static {v11}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$400(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)[B

    move-result-object v13

    .line 1773
    .local v13, "initializationDataBytes":[B
    if-eqz v13, :cond_40

    .line 1774
    const-string v10, "audio/vorbis"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3e

    .line 1775
    nop

    .line 1776
    invoke-static {v13}, Landroidx/media3/extractor/VorbisUtil;->parseVorbisCsdFromEsdsInitializationData([B)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    move-object/from16 v13, v23

    goto :goto_18

    .line 1778
    :cond_3e
    const-string v10, "audio/mp4a-latm"

    invoke-virtual {v10, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3f

    .line 1781
    nop

    .line 1782
    invoke-static {v13}, Landroidx/media3/extractor/AacUtil;->parseAudioSpecificConfig([B)Landroidx/media3/extractor/AacUtil$Config;

    move-result-object v10

    .line 1783
    .local v10, "aacConfig":Landroidx/media3/extractor/AacUtil$Config;
    iget v15, v10, Landroidx/media3/extractor/AacUtil$Config;->sampleRateHz:I

    .line 1784
    iget v9, v10, Landroidx/media3/extractor/AacUtil$Config;->channelCount:I

    .line 1785
    iget-object v0, v10, Landroidx/media3/extractor/AacUtil$Config;->codecs:Ljava/lang/String;

    move-object/from16 v23, v0

    .line 1787
    .end local v10    # "aacConfig":Landroidx/media3/extractor/AacUtil$Config;
    :cond_3f
    invoke-static {v13}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    move-object/from16 v13, v23

    goto :goto_18

    .line 1773
    :cond_40
    move-object/from16 v13, v23

    goto :goto_18

    .line 1769
    .end local v11    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .end local v13    # "initializationDataBytes":[B
    .restart local v21    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    :cond_41
    move-object/from16 v11, v21

    move-object/from16 v13, v23

    .line 1791
    .end local v2    # "esdsAtomPosition":I
    .end local v21    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .end local v23    # "codecs":Ljava/lang/String;
    .restart local v11    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .local v13, "codecs":Ljava/lang/String;
    :goto_18
    move-object/from16 v21, v11

    .line 1855
    .end local v11    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .restart local v21    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    :goto_19
    add-int/2addr v8, v14

    .line 1856
    .end local v1    # "childAtomType":I
    .end local v14    # "childAtomSize":I
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p3

    move-object/from16 v14, v21

    move/from16 v11, v24

    move/from16 v10, v25

    goto/16 :goto_f

    .line 1858
    .end local v24    # "pcmEncoding":I
    .end local v25    # "sampleRateMlp":I
    .local v10, "sampleRateMlp":I
    .local v11, "pcmEncoding":I
    :cond_42
    move/from16 v25, v10

    move/from16 v24, v11

    move-object/from16 v23, v13

    .end local v10    # "sampleRateMlp":I
    .end local v11    # "pcmEncoding":I
    .end local v13    # "codecs":Ljava/lang/String;
    .restart local v23    # "codecs":Ljava/lang/String;
    .restart local v24    # "pcmEncoding":I
    .restart local v25    # "sampleRateMlp":I
    iget-object v0, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    if-nez v0, :cond_44

    if-eqz v12, :cond_44

    .line 1859
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 1861
    invoke-virtual {v0, v3}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1862
    invoke-virtual {v0, v12}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1863
    move-object/from16 v13, v23

    .end local v23    # "codecs":Ljava/lang/String;
    .restart local v13    # "codecs":Ljava/lang/String;
    invoke-virtual {v0, v13}, Landroidx/media3/common/Format$Builder;->setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1864
    invoke-virtual {v0, v9}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1865
    invoke-virtual {v0, v15}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1866
    move/from16 v11, v24

    .end local v24    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    invoke-virtual {v0, v11}, Landroidx/media3/common/Format$Builder;->setPcmEncoding(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1867
    invoke-virtual {v0, v5}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1868
    invoke-virtual {v0, v7}, Landroidx/media3/common/Format$Builder;->setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1869
    invoke-virtual {v0, v4}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1871
    .local v0, "formatBuilder":Landroidx/media3/common/Format$Builder;
    if-eqz v21, :cond_43

    .line 1872
    nop

    .line 1873
    invoke-static/range {v21 .. v21}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$600(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J

    move-result-wide v1

    invoke-static {v1, v2}, Lcom/google/common/primitives/Ints;->saturatedCast(J)I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setAverageBitrate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1874
    invoke-static/range {v21 .. v21}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$500(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J

    move-result-wide v17

    invoke-static/range {v17 .. v18}, Lcom/google/common/primitives/Ints;->saturatedCast(J)I

    move-result v2

    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setPeakBitrate(I)Landroidx/media3/common/Format$Builder;

    .line 1877
    :cond_43
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v1

    iput-object v1, v6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    goto :goto_1a

    .line 1858
    .end local v0    # "formatBuilder":Landroidx/media3/common/Format$Builder;
    .end local v11    # "pcmEncoding":I
    .end local v13    # "codecs":Ljava/lang/String;
    .restart local v23    # "codecs":Ljava/lang/String;
    .restart local v24    # "pcmEncoding":I
    :cond_44
    move-object/from16 v13, v23

    move/from16 v11, v24

    .line 1879
    .end local v23    # "codecs":Ljava/lang/String;
    .end local v24    # "pcmEncoding":I
    .restart local v11    # "pcmEncoding":I
    .restart local v13    # "codecs":Ljava/lang/String;
    :goto_1a
    return-void
.end method

.method private static parseAv1c(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/ColorInfo;
    .locals 23
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 1399
    new-instance v0, Landroidx/media3/common/ColorInfo$Builder;

    invoke-direct {v0}, Landroidx/media3/common/ColorInfo$Builder;-><init>()V

    .line 1400
    .local v0, "colorInfo":Landroidx/media3/common/ColorInfo$Builder;
    new-instance v1, Landroidx/media3/common/util/ParsableBitArray;

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    invoke-direct {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;-><init>([B)V

    .line 1401
    .local v1, "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v2

    const/16 v3, 0x8

    mul-int/2addr v2, v3

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->setPosition(I)V

    .line 1405
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBytes(I)V

    .line 1406
    const/4 v4, 0x3

    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v5

    .line 1407
    .local v5, "seqProfile":I
    const/4 v6, 0x6

    invoke-virtual {v1, v6}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1408
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v6

    .line 1409
    .local v6, "highBitdepth":Z
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v7

    .line 1410
    .local v7, "twelveBit":Z
    const/16 v8, 0xc

    const/16 v9, 0xa

    const/4 v10, 0x2

    if-ne v5, v10, :cond_2

    if-eqz v6, :cond_2

    .line 1411
    if-eqz v7, :cond_0

    move v11, v8

    goto :goto_0

    :cond_0
    move v11, v9

    :goto_0
    invoke-virtual {v0, v11}, Landroidx/media3/common/ColorInfo$Builder;->setLumaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    .line 1412
    if-eqz v7, :cond_1

    move v9, v8

    :cond_1
    invoke-virtual {v0, v9}, Landroidx/media3/common/ColorInfo$Builder;->setChromaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    goto :goto_3

    .line 1413
    :cond_2
    if-gt v5, v10, :cond_5

    .line 1414
    if-eqz v6, :cond_3

    move v11, v9

    goto :goto_1

    :cond_3
    move v11, v3

    :goto_1
    invoke-virtual {v0, v11}, Landroidx/media3/common/ColorInfo$Builder;->setLumaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    .line 1415
    if-eqz v6, :cond_4

    goto :goto_2

    :cond_4
    move v9, v3

    :goto_2
    invoke-virtual {v0, v9}, Landroidx/media3/common/ColorInfo$Builder;->setChromaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    .line 1419
    :cond_5
    :goto_3
    const/16 v9, 0xd

    invoke-virtual {v1, v9}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1422
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 1423
    const/4 v11, 0x4

    invoke-virtual {v1, v11}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v12

    .line 1424
    .local v12, "obuType":I
    const-string v13, "AtomParsers"

    if-eq v12, v2, :cond_6

    .line 1425
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unsupported obu_type: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1426
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1428
    :cond_6
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v14

    if-eqz v14, :cond_7

    .line 1429
    const-string v2, "Unsupported obu_extension_flag"

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1430
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1432
    :cond_7
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v14

    .line 1433
    .local v14, "obuHasSizeField":Z
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 1435
    if-eqz v14, :cond_8

    invoke-virtual {v1, v3}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v15

    const/16 v9, 0x7f

    if-le v15, v9, :cond_8

    .line 1436
    const-string v2, "Excessive obu_size"

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1437
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1440
    :cond_8
    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v9

    .line 1441
    .local v9, "obuSeqHeaderSeqProfile":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 1442
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v15

    if-eqz v15, :cond_9

    .line 1443
    const-string v2, "Unsupported reduced_still_picture_header"

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1444
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1446
    :cond_9
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v15

    if-eqz v15, :cond_a

    .line 1447
    const-string v2, "Unsupported timing_info_present_flag"

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1448
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1450
    :cond_a
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v15

    if-eqz v15, :cond_b

    .line 1451
    const-string v2, "Unsupported initial_display_delay_present_flag"

    invoke-static {v13, v2}, Landroidx/media3/common/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1452
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v2

    return-object v2

    .line 1454
    :cond_b
    const/4 v13, 0x5

    invoke-virtual {v1, v13}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v15

    .line 1455
    .local v15, "operatingPointsCountMinus1":I
    const/16 v17, 0x0

    move/from16 v3, v17

    .local v3, "i":I
    :goto_4
    const/4 v4, 0x7

    if-gt v3, v15, :cond_d

    .line 1456
    invoke-virtual {v1, v8}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1457
    invoke-virtual {v1, v13}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v8

    .line 1458
    .local v8, "seqLevelIdx":I
    if-le v8, v4, :cond_c

    .line 1459
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 1455
    .end local v8    # "seqLevelIdx":I
    :cond_c
    add-int/lit8 v3, v3, 0x1

    const/4 v4, 0x3

    const/16 v8, 0xc

    goto :goto_4

    .line 1462
    .end local v3    # "i":I
    :cond_d
    invoke-virtual {v1, v11}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 1463
    .local v3, "frameWidthBitsMinus1":I
    invoke-virtual {v1, v11}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v8

    .line 1464
    .local v8, "frameHeightBitsMinus1":I
    add-int/lit8 v11, v3, 0x1

    invoke-virtual {v1, v11}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1465
    add-int/lit8 v11, v8, 0x1

    invoke-virtual {v1, v11}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1466
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v11

    if-eqz v11, :cond_e

    .line 1467
    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1469
    :cond_e
    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1470
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v4

    .line 1471
    .local v4, "enableOrderHint":Z
    if-eqz v4, :cond_f

    .line 1472
    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1475
    :cond_f
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v11

    if-eqz v11, :cond_10

    .line 1476
    move v11, v10

    goto :goto_5

    .line 1477
    :cond_10
    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v11

    :goto_5
    nop

    .line 1478
    .local v11, "seqForceScreenContentTools":I
    if-lez v11, :cond_11

    .line 1479
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v13

    if-nez v13, :cond_11

    .line 1480
    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1483
    :cond_11
    if-eqz v4, :cond_12

    .line 1484
    const/4 v13, 0x3

    invoke-virtual {v1, v13}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    goto :goto_6

    .line 1483
    :cond_12
    const/4 v13, 0x3

    .line 1486
    :goto_6
    invoke-virtual {v1, v13}, Landroidx/media3/common/util/ParsableBitArray;->skipBits(I)V

    .line 1488
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v13

    .line 1489
    .local v13, "colorConfigHighBitdepth":Z
    if-ne v9, v10, :cond_13

    if-eqz v13, :cond_13

    .line 1490
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->skipBit()V

    .line 1493
    :cond_13
    if-eq v9, v2, :cond_14

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v17

    if-eqz v17, :cond_14

    move/from16 v17, v2

    goto :goto_7

    :cond_14
    const/16 v17, 0x0

    .line 1495
    .local v17, "monochrome":Z
    :goto_7
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableBitArray;->readBit()Z

    move-result v19

    if-eqz v19, :cond_18

    .line 1496
    const/16 v10, 0x8

    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v2

    .line 1497
    .local v2, "colorPrimaries":I
    move/from16 v20, v3

    .end local v3    # "frameWidthBitsMinus1":I
    .local v20, "frameWidthBitsMinus1":I
    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v3

    .line 1498
    .local v3, "transferCharacteristics":I
    invoke-virtual {v1, v10}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v10

    .line 1500
    .local v10, "matrixCoefficients":I
    if-nez v17, :cond_15

    move/from16 v21, v4

    const/4 v4, 0x1

    .end local v4    # "enableOrderHint":Z
    .local v21, "enableOrderHint":Z
    if-ne v2, v4, :cond_16

    const/16 v4, 0xd

    if-ne v3, v4, :cond_16

    if-nez v10, :cond_16

    .line 1504
    const/4 v4, 0x1

    const/16 v16, 0x1

    goto :goto_8

    .line 1500
    .end local v21    # "enableOrderHint":Z
    .restart local v4    # "enableOrderHint":Z
    :cond_15
    move/from16 v21, v4

    .line 1505
    .end local v4    # "enableOrderHint":Z
    .restart local v21    # "enableOrderHint":Z
    :cond_16
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Landroidx/media3/common/util/ParsableBitArray;->readBits(I)I

    move-result v16

    :goto_8
    move/from16 v18, v16

    .line 1506
    .local v18, "colorRange":I
    nop

    .line 1507
    invoke-static {v2}, Landroidx/media3/common/ColorInfo;->isoColorPrimariesToColorSpace(I)I

    move-result v4

    invoke-virtual {v0, v4}, Landroidx/media3/common/ColorInfo$Builder;->setColorSpace(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v4

    .line 1508
    move-object/from16 v22, v1

    move/from16 v16, v2

    move/from16 v1, v18

    const/4 v2, 0x1

    .end local v2    # "colorPrimaries":I
    .end local v18    # "colorRange":I
    .local v1, "colorRange":I
    .local v16, "colorPrimaries":I
    .local v22, "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    if-ne v1, v2, :cond_17

    goto :goto_9

    :cond_17
    const/4 v2, 0x2

    :goto_9
    invoke-virtual {v4, v2}, Landroidx/media3/common/ColorInfo$Builder;->setColorRange(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v2

    .line 1510
    invoke-static {v3}, Landroidx/media3/common/ColorInfo;->isoTransferCharacteristicsToColorTransfer(I)I

    move-result v4

    .line 1509
    invoke-virtual {v2, v4}, Landroidx/media3/common/ColorInfo$Builder;->setColorTransfer(I)Landroidx/media3/common/ColorInfo$Builder;

    goto :goto_a

    .line 1495
    .end local v10    # "matrixCoefficients":I
    .end local v16    # "colorPrimaries":I
    .end local v20    # "frameWidthBitsMinus1":I
    .end local v21    # "enableOrderHint":Z
    .end local v22    # "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    .local v1, "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    .local v3, "frameWidthBitsMinus1":I
    .restart local v4    # "enableOrderHint":Z
    :cond_18
    move-object/from16 v22, v1

    move/from16 v20, v3

    move/from16 v21, v4

    .line 1512
    .end local v1    # "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    .end local v3    # "frameWidthBitsMinus1":I
    .end local v4    # "enableOrderHint":Z
    .restart local v20    # "frameWidthBitsMinus1":I
    .restart local v21    # "enableOrderHint":Z
    .restart local v22    # "bitArray":Landroidx/media3/common/util/ParsableBitArray;
    :goto_a
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v1

    return-object v1
.end method

.method static parseCommonEncryptionSinfFromParent(Landroidx/media3/common/util/ParsableByteArray;II)Landroid/util/Pair;
    .locals 9
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I
    .param p2, "size"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "II)",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Landroidx/media3/extractor/mp4/TrackEncryptionBox;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1995
    add-int/lit8 v0, p1, 0x8

    .line 1996
    .local v0, "childPosition":I
    const/4 v1, -0x1

    .line 1997
    .local v1, "schemeInformationBoxPosition":I
    const/4 v2, 0x0

    .line 1998
    .local v2, "schemeInformationBoxSize":I
    const/4 v3, 0x0

    .line 1999
    .local v3, "schemeType":Ljava/lang/String;
    const/4 v4, 0x0

    .line 2000
    .local v4, "dataFormat":Ljava/lang/Integer;
    :goto_0
    sub-int v5, v0, p1

    if-ge v5, p2, :cond_3

    .line 2001
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 2002
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 2003
    .local v5, "childAtomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v6

    .line 2004
    .local v6, "childAtomType":I
    const v7, 0x66726d61

    if-ne v6, v7, :cond_0

    .line 2005
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    goto :goto_1

    .line 2006
    :cond_0
    const v7, 0x7363686d

    if-ne v6, v7, :cond_1

    .line 2007
    const/4 v7, 0x4

    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 2009
    invoke-virtual {p0, v7}, Landroidx/media3/common/util/ParsableByteArray;->readString(I)Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 2010
    :cond_1
    const v7, 0x73636869

    if-ne v6, v7, :cond_2

    .line 2011
    move v1, v0

    .line 2012
    move v2, v5

    .line 2014
    :cond_2
    :goto_1
    add-int/2addr v0, v5

    .line 2015
    .end local v5    # "childAtomSize":I
    .end local v6    # "childAtomType":I
    goto :goto_0

    .line 2017
    :cond_3
    const-string v5, "cenc"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 2018
    const-string v5, "cbc1"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 2019
    const-string v5, "cens"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 2020
    const-string v5, "cbcs"

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    goto :goto_2

    .line 2031
    :cond_4
    const/4 v5, 0x0

    return-object v5

    .line 2021
    :cond_5
    :goto_2
    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eqz v4, :cond_6

    move v7, v5

    goto :goto_3

    :cond_6
    move v7, v6

    :goto_3
    const-string v8, "frma atom is mandatory"

    invoke-static {v7, v8}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 2022
    const/4 v7, -0x1

    if-eq v1, v7, :cond_7

    move v7, v5

    goto :goto_4

    :cond_7
    move v7, v6

    :goto_4
    const-string/jumbo v8, "schi atom is mandatory"

    invoke-static {v7, v8}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 2025
    nop

    .line 2026
    invoke-static {p0, v1, v2, v3}, Landroidx/media3/extractor/mp4/AtomParsers;->parseSchiFromParent(Landroidx/media3/common/util/ParsableByteArray;IILjava/lang/String;)Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-result-object v7

    .line 2028
    .local v7, "encryptionBox":Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    if-eqz v7, :cond_8

    goto :goto_5

    :cond_8
    move v5, v6

    :goto_5
    const-string/jumbo v6, "tenc atom is mandatory"

    invoke-static {v5, v6}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 2029
    invoke-static {v7}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    invoke-static {v4, v5}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v5

    return-object v5
.end method

.method private static parseEdts(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)Landroid/util/Pair;
    .locals 11
    .param p0, "edtsAtom"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/mp4/Atom$ContainerAtom;",
            ")",
            "Landroid/util/Pair<",
            "[J[J>;"
        }
    .end annotation

    .line 1543
    const v0, 0x656c7374

    invoke-virtual {p0, v0}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v0

    .line 1544
    .local v0, "elstAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-nez v0, :cond_0

    .line 1545
    const/4 v1, 0x0

    return-object v1

    .line 1547
    :cond_0
    iget-object v1, v0, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 1548
    .local v1, "elstData":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1549
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 1550
    .local v2, "fullAtom":I
    invoke-static {v2}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v3

    .line 1551
    .local v3, "version":I
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v4

    .line 1552
    .local v4, "entryCount":I
    new-array v5, v4, [J

    .line 1553
    .local v5, "editListDurations":[J
    new-array v6, v4, [J

    .line 1554
    .local v6, "editListMediaTimes":[J
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v4, :cond_4

    .line 1555
    nop

    .line 1556
    const/4 v8, 0x1

    if-ne v3, v8, :cond_1

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v9

    goto :goto_1

    :cond_1
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v9

    :goto_1
    aput-wide v9, v5, v7

    .line 1557
    if-ne v3, v8, :cond_2

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v9

    goto :goto_2

    :cond_2
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v9

    int-to-long v9, v9

    :goto_2
    aput-wide v9, v6, v7

    .line 1558
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v9

    .line 1559
    .local v9, "mediaRateInteger":I
    if-ne v9, v8, :cond_3

    .line 1563
    const/4 v8, 0x2

    invoke-virtual {v1, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1554
    .end local v9    # "mediaRateInteger":I
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 1561
    .restart local v9    # "mediaRateInteger":I
    :cond_3
    new-instance v8, Ljava/lang/IllegalArgumentException;

    const-string v10, "Unsupported media rate."

    invoke-direct {v8, v10}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1565
    .end local v7    # "i":I
    .end local v9    # "mediaRateInteger":I
    :cond_4
    invoke-static {v5, v6}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v7

    return-object v7
.end method

.method private static parseEsdsFromParent(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .locals 20
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I

    .line 1913
    move-object/from16 v0, p0

    add-int/lit8 v1, p1, 0x8

    const/4 v2, 0x4

    add-int/2addr v1, v2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1915
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1916
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/mp4/AtomParsers;->parseExpandableClassSize(Landroidx/media3/common/util/ParsableByteArray;)I

    .line 1917
    const/4 v3, 0x2

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1919
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v4

    .line 1920
    .local v4, "flags":I
    and-int/lit16 v5, v4, 0x80

    if-eqz v5, :cond_0

    .line 1921
    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1923
    :cond_0
    and-int/lit8 v5, v4, 0x40

    if-eqz v5, :cond_1

    .line 1924
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v5

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1926
    :cond_1
    and-int/lit8 v5, v4, 0x20

    if-eqz v5, :cond_2

    .line 1927
    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1931
    :cond_2
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1932
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/mp4/AtomParsers;->parseExpandableClassSize(Landroidx/media3/common/util/ParsableByteArray;)I

    .line 1935
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v3

    .line 1936
    .local v3, "objectTypeIndication":I
    invoke-static {v3}, Landroidx/media3/common/MimeTypes;->getMimeTypeFromMp4ObjectType(I)Ljava/lang/String;

    move-result-object v12

    .line 1937
    .local v12, "mimeType":Ljava/lang/String;
    const-string v5, "audio/mpeg"

    invoke-virtual {v5, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 1938
    const-string v5, "audio/vnd.dts"

    invoke-virtual {v5, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_6

    .line 1939
    const-string v5, "audio/vnd.dts.hd"

    invoke-virtual {v5, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    goto :goto_2

    .line 1947
    :cond_3
    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1948
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v13

    .line 1949
    .local v13, "peakBitrate":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v15

    .line 1952
    .local v15, "bitrate":J
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1953
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/mp4/AtomParsers;->parseExpandableClassSize(Landroidx/media3/common/util/ParsableByteArray;)I

    move-result v1

    .line 1954
    .local v1, "initializationDataSize":I
    new-array v2, v1, [B

    .line 1955
    .local v2, "initializationData":[B
    const/4 v5, 0x0

    invoke-virtual {v0, v2, v5, v1}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1958
    new-instance v17, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    .line 1961
    const-wide/16 v5, 0x0

    cmp-long v7, v15, v5

    const-wide/16 v8, -0x1

    if-lez v7, :cond_4

    move-wide v10, v15

    goto :goto_0

    :cond_4
    move-wide v10, v8

    .line 1962
    :goto_0
    cmp-long v5, v13, v5

    if-lez v5, :cond_5

    move-wide/from16 v18, v13

    goto :goto_1

    :cond_5
    move-wide/from16 v18, v8

    :goto_1
    move-object/from16 v5, v17

    move-object v6, v12

    move-object v7, v2

    move-wide v8, v10

    move-wide/from16 v10, v18

    invoke-direct/range {v5 .. v11}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;-><init>(Ljava/lang/String;[BJJ)V

    .line 1958
    return-object v17

    .line 1940
    .end local v1    # "initializationDataSize":I
    .end local v2    # "initializationData":[B
    .end local v13    # "peakBitrate":J
    .end local v15    # "bitrate":J
    :cond_6
    :goto_2
    new-instance v1, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    const/4 v7, 0x0

    const-wide/16 v8, -0x1

    const-wide/16 v10, -0x1

    move-object v5, v1

    move-object v6, v12

    invoke-direct/range {v5 .. v11}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;-><init>(Ljava/lang/String;[BJJ)V

    return-object v1
.end method

.method private static parseExpandableClassSize(Landroidx/media3/common/util/ParsableByteArray;)I
    .locals 4
    .param p0, "data"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 2098
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 2099
    .local v0, "currentByte":I
    and-int/lit8 v1, v0, 0x7f

    .line 2100
    .local v1, "size":I
    :goto_0
    and-int/lit16 v2, v0, 0x80

    const/16 v3, 0x80

    if-ne v2, v3, :cond_0

    .line 2101
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v0

    .line 2102
    shl-int/lit8 v2, v1, 0x7

    and-int/lit8 v3, v0, 0x7f

    or-int v1, v2, v3

    goto :goto_0

    .line 2104
    :cond_0
    return v1
.end method

.method private static parseHdlr(Landroidx/media3/common/util/ParsableByteArray;)I
    .locals 1
    .param p0, "hdlr"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 897
    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 898
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    return v0
.end method

.method private static parseIlst(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/common/Metadata;
    .locals 2
    .param p0, "ilst"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "limit"    # I

    .line 798
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 799
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 800
    .local v0, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/common/Metadata$Entry;>;"
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v1

    if-ge v1, p1, :cond_1

    .line 801
    invoke-static {p0}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseIlstElement(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/Metadata$Entry;

    move-result-object v1

    .line 802
    .local v1, "entry":Landroidx/media3/common/Metadata$Entry;
    if-eqz v1, :cond_0

    .line 803
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 805
    .end local v1    # "entry":Landroidx/media3/common/Metadata$Entry;
    :cond_0
    goto :goto_0

    .line 806
    :cond_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x0

    goto :goto_1

    :cond_2
    new-instance v1, Landroidx/media3/common/Metadata;

    invoke-direct {v1, v0}, Landroidx/media3/common/Metadata;-><init>(Ljava/util/List;)V

    :goto_1
    return-object v1
.end method

.method private static parseMdhd(Landroidx/media3/common/util/ParsableByteArray;)Landroid/util/Pair;
    .locals 7
    .param p0, "mdhd"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            ")",
            "Landroid/util/Pair<",
            "Ljava/lang/Long;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 924
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 925
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 926
    .local v1, "fullAtom":I
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v2

    .line 927
    .local v2, "version":I
    if-nez v2, :cond_0

    move v3, v0

    goto :goto_0

    :cond_0
    const/16 v3, 0x10

    :goto_0
    invoke-virtual {p0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 928
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v3

    .line 929
    .local v3, "timescale":J
    if-nez v2, :cond_1

    const/4 v0, 0x4

    :cond_1
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 930
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    .line 931
    .local v0, "languageCode":I
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    shr-int/lit8 v6, v0, 0xa

    and-int/lit8 v6, v6, 0x1f

    add-int/lit8 v6, v6, 0x60

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    shr-int/lit8 v6, v0, 0x5

    and-int/lit8 v6, v6, 0x1f

    add-int/lit8 v6, v6, 0x60

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    and-int/lit8 v6, v0, 0x1f

    add-int/lit8 v6, v6, 0x60

    int-to-char v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 936
    .local v5, "language":Ljava/lang/String;
    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-static {v6, v5}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v6

    return-object v6
.end method

.method public static parseMdtaFromMeta(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)Landroidx/media3/common/Metadata;
    .locals 15
    .param p0, "meta"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 223
    const v0, 0x68646c72    # 4.3148E24f

    invoke-virtual {p0, v0}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v0

    .line 224
    .local v0, "hdlrAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    const v1, 0x6b657973

    invoke-virtual {p0, v1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v1

    .line 225
    .local v1, "keysAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    const v2, 0x696c7374

    invoke-virtual {p0, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v2

    .line 226
    .local v2, "ilstAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    const/4 v3, 0x0

    if-eqz v0, :cond_6

    if-eqz v1, :cond_6

    if-eqz v2, :cond_6

    iget-object v4, v0, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 229
    invoke-static {v4}, Landroidx/media3/extractor/mp4/AtomParsers;->parseHdlr(Landroidx/media3/common/util/ParsableByteArray;)I

    move-result v4

    const v5, 0x6d647461

    if-eq v4, v5, :cond_0

    goto/16 :goto_4

    .line 235
    :cond_0
    iget-object v4, v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 236
    .local v4, "keys":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v5, 0xc

    invoke-virtual {v4, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 237
    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 238
    .local v5, "entryCount":I
    new-array v6, v5, [Ljava/lang/String;

    .line 239
    .local v6, "keyNames":[Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    if-ge v7, v5, :cond_1

    .line 240
    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v8

    .line 241
    .local v8, "entrySize":I
    const/4 v9, 0x4

    invoke-virtual {v4, v9}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 242
    add-int/lit8 v9, v8, -0x8

    .line 243
    .local v9, "keySize":I
    invoke-virtual {v4, v9}, Landroidx/media3/common/util/ParsableByteArray;->readString(I)Ljava/lang/String;

    move-result-object v10

    aput-object v10, v6, v7

    .line 239
    .end local v8    # "entrySize":I
    .end local v9    # "keySize":I
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 247
    .end local v7    # "i":I
    :cond_1
    iget-object v7, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 248
    .local v7, "ilst":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 249
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 250
    .local v9, "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/common/Metadata$Entry;>;"
    :goto_1
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v10

    if-le v10, v8, :cond_4

    .line 251
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v10

    .line 252
    .local v10, "atomPosition":I
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v11

    .line 253
    .local v11, "atomSize":I
    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v12

    add-int/lit8 v12, v12, -0x1

    .line 254
    .local v12, "keyIndex":I
    if-ltz v12, :cond_3

    array-length v13, v6

    if-ge v12, v13, :cond_3

    .line 255
    aget-object v13, v6, v12

    .line 257
    .local v13, "key":Ljava/lang/String;
    add-int v14, v10, v11

    .line 258
    invoke-static {v7, v14, v13}, Landroidx/media3/extractor/mp4/MetadataUtil;->parseMdtaMetadataEntryFromIlst(Landroidx/media3/common/util/ParsableByteArray;ILjava/lang/String;)Landroidx/media3/container/MdtaMetadataEntry;

    move-result-object v14

    .line 259
    .local v14, "entry":Landroidx/media3/common/Metadata$Entry;
    if-eqz v14, :cond_2

    .line 260
    invoke-virtual {v9, v14}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 262
    .end local v13    # "key":Ljava/lang/String;
    .end local v14    # "entry":Landroidx/media3/common/Metadata$Entry;
    :cond_2
    goto :goto_2

    .line 263
    :cond_3
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Skipped metadata with unknown key index: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    const-string v14, "AtomParsers"

    invoke-static {v14, v13}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 265
    :goto_2
    add-int v13, v10, v11

    invoke-virtual {v7, v13}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 266
    .end local v10    # "atomPosition":I
    .end local v11    # "atomSize":I
    .end local v12    # "keyIndex":I
    goto :goto_1

    .line 267
    :cond_4
    invoke-virtual {v9}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_5

    goto :goto_3

    :cond_5
    new-instance v3, Landroidx/media3/common/Metadata;

    invoke-direct {v3, v9}, Landroidx/media3/common/Metadata;-><init>(Ljava/util/List;)V

    :goto_3
    return-object v3

    .line 231
    .end local v4    # "keys":Landroidx/media3/common/util/ParsableByteArray;
    .end local v5    # "entryCount":I
    .end local v6    # "keyNames":[Ljava/lang/String;
    .end local v7    # "ilst":Landroidx/media3/common/util/ParsableByteArray;
    .end local v9    # "entries":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/common/Metadata$Entry;>;"
    :cond_6
    :goto_4
    return-object v3
.end method

.method private static parseMetaDataSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIILandroidx/media3/extractor/mp4/AtomParsers$StsdData;)V
    .locals 2
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "atomType"    # I
    .param p2, "position"    # I
    .param p3, "trackId"    # I
    .param p4, "out"    # Landroidx/media3/extractor/mp4/AtomParsers$StsdData;

    .line 1524
    add-int/lit8 v0, p2, 0x8

    add-int/lit8 v0, v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1525
    const v0, 0x6d657474

    if-ne p1, v0, :cond_0

    .line 1526
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    .line 1527
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v0

    .line 1528
    .local v0, "mimeType":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1529
    new-instance v1, Landroidx/media3/common/Format$Builder;

    invoke-direct {v1}, Landroidx/media3/common/Format$Builder;-><init>()V

    invoke-virtual {v1, p3}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v1

    iput-object v1, p4, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    .line 1532
    .end local v0    # "mimeType":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static parseMvhd(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/container/Mp4TimestampData;
    .locals 17
    .param p0, "mvhd"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 198
    const/16 v0, 0x8

    move-object/from16 v1, p0

    invoke-virtual {v1, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 199
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 200
    .local v0, "fullAtom":I
    invoke-static {v0}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v2

    .line 203
    .local v2, "version":I
    if-nez v2, :cond_0

    .line 204
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v3

    .line 205
    .local v3, "creationTimestampSeconds":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v5

    .local v5, "modificationTimestampSeconds":J
    goto :goto_0

    .line 207
    .end local v3    # "creationTimestampSeconds":J
    .end local v5    # "modificationTimestampSeconds":J
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v3

    .line 208
    .restart local v3    # "creationTimestampSeconds":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readLong()J

    move-result-wide v5

    .line 211
    .restart local v5    # "modificationTimestampSeconds":J
    :goto_0
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v14

    .line 212
    .local v14, "timescale":J
    new-instance v16, Landroidx/media3/container/Mp4TimestampData;

    move-object/from16 v7, v16

    move-wide v8, v3

    move-wide v10, v5

    move-wide v12, v14

    invoke-direct/range {v7 .. v13}, Landroidx/media3/container/Mp4TimestampData;-><init>(JJJ)V

    return-object v16
.end method

.method private static parsePaspFromParent(Landroidx/media3/common/util/ParsableByteArray;I)F
    .locals 4
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I

    .line 1569
    add-int/lit8 v0, p1, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1570
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    .line 1571
    .local v0, "hSpacing":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v1

    .line 1572
    .local v1, "vSpacing":I
    int-to-float v2, v0

    int-to-float v3, v1

    div-float/2addr v2, v3

    return v2
.end method

.method private static parseProjFromParent(Landroidx/media3/common/util/ParsableByteArray;II)[B
    .locals 5
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I
    .param p2, "size"    # I

    .line 2083
    add-int/lit8 v0, p1, 0x8

    .line 2084
    .local v0, "childPosition":I
    :goto_0
    sub-int v1, v0, p1

    if-ge v1, p2, :cond_1

    .line 2085
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 2086
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 2087
    .local v1, "childAtomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 2088
    .local v2, "childAtomType":I
    const v3, 0x70726f6a

    if-ne v2, v3, :cond_0

    .line 2089
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v3

    add-int v4, v0, v1

    invoke-static {v3, v0, v4}, Ljava/util/Arrays;->copyOfRange([BII)[B

    move-result-object v3

    return-object v3

    .line 2091
    :cond_0
    add-int/2addr v0, v1

    .line 2092
    .end local v1    # "childAtomSize":I
    .end local v2    # "childAtomType":I
    goto :goto_0

    .line 2093
    :cond_1
    const/4 v1, 0x0

    return-object v1
.end method

.method private static parseSampleEntryEncryptionData(Landroidx/media3/common/util/ParsableByteArray;II)Landroid/util/Pair;
    .locals 4
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I
    .param p2, "size"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "II)",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Landroidx/media3/extractor/mp4/TrackEncryptionBox;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1973
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 1974
    .local v0, "childPosition":I
    :goto_0
    sub-int v1, v0, p1

    if-ge v1, p2, :cond_2

    .line 1975
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1976
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1977
    .local v1, "childAtomSize":I
    if-lez v1, :cond_0

    const/4 v2, 0x1

    goto :goto_1

    :cond_0
    const/4 v2, 0x0

    :goto_1
    const-string v3, "childAtomSize must be positive"

    invoke-static {v2, v3}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1978
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 1979
    .local v2, "childAtomType":I
    const v3, 0x73696e66

    if-ne v2, v3, :cond_1

    .line 1981
    nop

    .line 1982
    invoke-static {p0, v0, v1}, Landroidx/media3/extractor/mp4/AtomParsers;->parseCommonEncryptionSinfFromParent(Landroidx/media3/common/util/ParsableByteArray;II)Landroid/util/Pair;

    move-result-object v3

    .line 1983
    .local v3, "result":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    if-eqz v3, :cond_1

    .line 1984
    return-object v3

    .line 1987
    .end local v3    # "result":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    :cond_1
    add-int/2addr v0, v1

    .line 1988
    .end local v1    # "childAtomSize":I
    .end local v2    # "childAtomType":I
    goto :goto_0

    .line 1989
    :cond_2
    const/4 v1, 0x0

    return-object v1
.end method

.method private static parseSchiFromParent(Landroidx/media3/common/util/ParsableByteArray;IILjava/lang/String;)Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    .locals 22
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "position"    # I
    .param p2, "size"    # I
    .param p3, "schemeType"    # Ljava/lang/String;

    .line 2038
    move-object/from16 v0, p0

    add-int/lit8 v1, p1, 0x8

    .line 2039
    .local v1, "childPosition":I
    :goto_0
    sub-int v2, v1, p1

    move/from16 v3, p2

    if-ge v2, v3, :cond_4

    .line 2040
    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 2041
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 2042
    .local v2, "childAtomSize":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 2043
    .local v4, "childAtomType":I
    const v5, 0x74656e63

    if-ne v4, v5, :cond_3

    .line 2044
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 2045
    .local v5, "fullAtom":I
    invoke-static {v5}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v6

    .line 2046
    .local v6, "version":I
    const/4 v7, 0x1

    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 2047
    const/4 v8, 0x0

    .line 2048
    .local v8, "defaultCryptByteBlock":I
    const/4 v9, 0x0

    .line 2049
    .local v9, "defaultSkipByteBlock":I
    if-nez v6, :cond_0

    .line 2050
    invoke-virtual {v0, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    goto :goto_1

    .line 2052
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v10

    .line 2053
    .local v10, "patternByte":I
    and-int/lit16 v11, v10, 0xf0

    shr-int/lit8 v8, v11, 0x4

    .line 2054
    and-int/lit8 v9, v10, 0xf

    .line 2056
    .end local v10    # "patternByte":I
    :goto_1
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v10

    const/4 v11, 0x0

    if-ne v10, v7, :cond_1

    goto :goto_2

    :cond_1
    move v7, v11

    .line 2057
    .local v7, "defaultIsProtected":Z
    :goto_2
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v10

    .line 2058
    .local v10, "defaultPerSampleIvSize":I
    const/16 v12, 0x10

    new-array v15, v12, [B

    .line 2059
    .local v15, "defaultKeyId":[B
    array-length v12, v15

    invoke-virtual {v0, v15, v11, v12}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 2060
    const/4 v12, 0x0

    .line 2061
    .local v12, "constantIv":[B
    if-eqz v7, :cond_2

    if-nez v10, :cond_2

    .line 2062
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v13

    .line 2063
    .local v13, "constantIvSize":I
    new-array v12, v13, [B

    .line 2064
    invoke-virtual {v0, v12, v11, v13}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    move-object/from16 v19, v12

    goto :goto_3

    .line 2066
    .end local v13    # "constantIvSize":I
    :cond_2
    move-object/from16 v19, v12

    .end local v12    # "constantIv":[B
    .local v19, "constantIv":[B
    :goto_3
    new-instance v20, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-object/from16 v11, v20

    move v12, v7

    move-object/from16 v13, p3

    move v14, v10

    move-object/from16 v21, v15

    .end local v15    # "defaultKeyId":[B
    .local v21, "defaultKeyId":[B
    move/from16 v16, v8

    move/from16 v17, v9

    move-object/from16 v18, v19

    invoke-direct/range {v11 .. v18}, Landroidx/media3/extractor/mp4/TrackEncryptionBox;-><init>(ZLjava/lang/String;I[BII[B)V

    return-object v20

    .line 2075
    .end local v5    # "fullAtom":I
    .end local v6    # "version":I
    .end local v7    # "defaultIsProtected":Z
    .end local v8    # "defaultCryptByteBlock":I
    .end local v9    # "defaultSkipByteBlock":I
    .end local v10    # "defaultPerSampleIvSize":I
    .end local v19    # "constantIv":[B
    .end local v21    # "defaultKeyId":[B
    :cond_3
    add-int/2addr v1, v2

    .line 2076
    .end local v2    # "childAtomSize":I
    .end local v4    # "childAtomType":I
    goto :goto_0

    .line 2077
    :cond_4
    const/4 v2, 0x0

    return-object v2
.end method

.method private static parseStbl(Landroidx/media3/extractor/mp4/Track;Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/GaplessInfoHolder;)Landroidx/media3/extractor/mp4/TrackSampleTable;
    .locals 80
    .param p0, "track"    # Landroidx/media3/extractor/mp4/Track;
    .param p1, "stblAtom"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p2, "gaplessInfoHolder"    # Landroidx/media3/extractor/GaplessInfoHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 396
    move-object/from16 v9, p0

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    const v0, 0x7374737a

    invoke-virtual {v10, v0}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v12

    .line 397
    .local v12, "stszAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    const/4 v0, 0x0

    if-eqz v12, :cond_0

    .line 398
    new-instance v1, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;

    iget-object v2, v9, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    invoke-direct {v1, v12, v2}, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;-><init>(Landroidx/media3/extractor/mp4/Atom$LeafAtom;Landroidx/media3/common/Format;)V

    move-object v13, v1

    .local v1, "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    goto :goto_0

    .line 400
    .end local v1    # "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    :cond_0
    const v1, 0x73747a32

    invoke-virtual {v10, v1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v1

    .line 401
    .local v1, "stz2Atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v1, :cond_31

    .line 405
    new-instance v2, Landroidx/media3/extractor/mp4/AtomParsers$Stz2SampleSizeBox;

    invoke-direct {v2, v1}, Landroidx/media3/extractor/mp4/AtomParsers$Stz2SampleSizeBox;-><init>(Landroidx/media3/extractor/mp4/Atom$LeafAtom;)V

    move-object v13, v2

    .line 408
    .end local v1    # "stz2Atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v13, "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    :goto_0
    invoke-interface {v13}, Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;->getSampleCount()I

    move-result v14

    .line 409
    .local v14, "sampleCount":I
    const/4 v1, 0x0

    if-nez v14, :cond_1

    .line 410
    new-instance v15, Landroidx/media3/extractor/mp4/TrackSampleTable;

    new-array v2, v1, [J

    new-array v3, v1, [I

    const/4 v4, 0x0

    new-array v5, v1, [J

    new-array v6, v1, [I

    const-wide/16 v7, 0x0

    move-object v0, v15

    move-object/from16 v1, p0

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    return-object v15

    .line 421
    :cond_1
    const/4 v2, 0x0

    .line 422
    .local v2, "chunkOffsetsAreLongs":Z
    const v3, 0x7374636f

    invoke-virtual {v10, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v3

    .line 423
    .local v3, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-nez v3, :cond_2

    .line 424
    const/4 v2, 0x1

    .line 425
    const v4, 0x636f3634

    invoke-virtual {v10, v4}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v4

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v3, v4

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move v15, v2

    move-object v7, v3

    goto :goto_1

    .line 423
    :cond_2
    move v15, v2

    move-object v7, v3

    .line 427
    .end local v2    # "chunkOffsetsAreLongs":Z
    .end local v3    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v7, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v15, "chunkOffsetsAreLongs":Z
    :goto_1
    iget-object v8, v7, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 429
    .local v8, "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    const v2, 0x73747363

    invoke-virtual {v10, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget-object v6, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 431
    .local v6, "stsc":Landroidx/media3/common/util/ParsableByteArray;
    const v2, 0x73747473

    invoke-virtual {v10, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget-object v5, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 433
    .local v5, "stts":Landroidx/media3/common/util/ParsableByteArray;
    const v2, 0x73747373

    invoke-virtual {v10, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v4

    .line 434
    .local v4, "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v4, :cond_3

    iget-object v2, v4, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    goto :goto_2

    :cond_3
    move-object v2, v0

    .line 436
    .local v2, "stss":Landroidx/media3/common/util/ParsableByteArray;
    :goto_2
    const v3, 0x63747473

    invoke-virtual {v10, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v3

    .line 437
    .local v3, "cttsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v3, :cond_4

    iget-object v0, v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 440
    .local v0, "ctts":Landroidx/media3/common/util/ParsableByteArray;
    :cond_4
    new-instance v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;

    invoke-direct {v1, v6, v8, v15}, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;-><init>(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/common/util/ParsableByteArray;Z)V

    .line 443
    .local v1, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    move-object/from16 v17, v3

    .end local v3    # "cttsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v17, "cttsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    const/16 v3, 0xc

    invoke-virtual {v5, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 444
    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v18

    const/4 v3, 0x1

    add-int/lit8 v18, v18, -0x1

    .line 445
    .local v18, "remainingTimestampDeltaChanges":I
    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v20

    .line 446
    .local v20, "remainingSamplesAtTimestampDelta":I
    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v3

    .line 449
    .local v3, "timestampDeltaInTimeUnits":I
    const/16 v22, 0x0

    .line 450
    .local v22, "remainingSamplesAtTimestampOffset":I
    const/16 v23, 0x0

    .line 451
    .local v23, "remainingTimestampOffsetChanges":I
    const/16 v24, 0x0

    .line 452
    .local v24, "timestampOffset":I
    if-eqz v0, :cond_5

    .line 453
    move-object/from16 v25, v4

    const/16 v4, 0xc

    .end local v4    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v25, "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 454
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v23

    goto :goto_3

    .line 452
    .end local v25    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v4    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :cond_5
    move-object/from16 v25, v4

    .line 457
    .end local v4    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v25    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :goto_3
    const/4 v4, -0x1

    .line 458
    .local v4, "nextSynchronizationSampleIndex":I
    const/16 v26, 0x0

    .line 459
    .local v26, "remainingSynchronizationSamples":I
    if-eqz v2, :cond_7

    .line 460
    move/from16 v27, v4

    const/16 v4, 0xc

    .end local v4    # "nextSynchronizationSampleIndex":I
    .local v27, "nextSynchronizationSampleIndex":I
    invoke-virtual {v2, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 461
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v26

    .line 462
    if-lez v26, :cond_6

    .line 463
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v4

    const/16 v19, 0x1

    add-int/lit8 v4, v4, -0x1

    move-object/from16 v19, v2

    .end local v27    # "nextSynchronizationSampleIndex":I
    .restart local v4    # "nextSynchronizationSampleIndex":I
    goto :goto_4

    .line 466
    .end local v4    # "nextSynchronizationSampleIndex":I
    .restart local v27    # "nextSynchronizationSampleIndex":I
    :cond_6
    const/4 v2, 0x0

    move-object/from16 v19, v2

    move/from16 v4, v27

    goto :goto_4

    .line 459
    .end local v27    # "nextSynchronizationSampleIndex":I
    .restart local v4    # "nextSynchronizationSampleIndex":I
    :cond_7
    move/from16 v27, v4

    .end local v4    # "nextSynchronizationSampleIndex":I
    .restart local v27    # "nextSynchronizationSampleIndex":I
    move-object/from16 v19, v2

    .line 471
    .end local v2    # "stss":Landroidx/media3/common/util/ParsableByteArray;
    .end local v27    # "nextSynchronizationSampleIndex":I
    .restart local v4    # "nextSynchronizationSampleIndex":I
    .local v19, "stss":Landroidx/media3/common/util/ParsableByteArray;
    :goto_4
    invoke-interface {v13}, Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;->getFixedSampleSize()I

    move-result v2

    .line 472
    .local v2, "fixedSampleSize":I
    move/from16 v27, v4

    .end local v4    # "nextSynchronizationSampleIndex":I
    .restart local v27    # "nextSynchronizationSampleIndex":I
    iget-object v4, v9, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget-object v4, v4, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    .line 473
    .local v4, "sampleMimeType":Ljava/lang/String;
    move-object/from16 v28, v6

    .end local v6    # "stsc":Landroidx/media3/common/util/ParsableByteArray;
    .local v28, "stsc":Landroidx/media3/common/util/ParsableByteArray;
    const/4 v6, -0x1

    if-eq v2, v6, :cond_9

    .line 475
    const-string v6, "audio/raw"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_8

    .line 476
    const-string v6, "audio/g711-mlaw"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_8

    .line 477
    const-string v6, "audio/g711-alaw"

    invoke-virtual {v6, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    :cond_8
    if-nez v18, :cond_9

    if-nez v23, :cond_9

    if-nez v26, :cond_9

    const/4 v6, 0x1

    goto :goto_5

    :cond_9
    const/4 v6, 0x0

    :goto_5
    move/from16 v29, v6

    .line 484
    .local v29, "rechunkFixedSizeSamples":Z
    const/4 v6, 0x0

    .line 487
    .local v6, "maximumSize":I
    const-wide/16 v30, 0x0

    .line 490
    .local v30, "timestampTimeUnits":J
    if-eqz v29, :cond_b

    .line 491
    move-object/from16 v32, v4

    .end local v4    # "sampleMimeType":Ljava/lang/String;
    .local v32, "sampleMimeType":Ljava/lang/String;
    iget v4, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->length:I

    new-array v4, v4, [J

    .line 492
    .local v4, "chunkOffsetsBytes":[J
    move/from16 v33, v6

    .end local v6    # "maximumSize":I
    .local v33, "maximumSize":I
    iget v6, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->length:I

    new-array v6, v6, [I

    .line 493
    .local v6, "chunkSampleCounts":[I
    :goto_6
    invoke-virtual {v1}, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->moveNext()Z

    move-result v34

    if-eqz v34, :cond_a

    .line 494
    move-object/from16 v34, v7

    .end local v7    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v34, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v7, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->index:I

    iget-wide v10, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->offset:J

    aput-wide v10, v4, v7

    .line 495
    iget v7, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->index:I

    iget v10, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->numSamples:I

    aput v10, v6, v7

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    move-object/from16 v7, v34

    goto :goto_6

    .line 497
    .end local v34    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v7    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :cond_a
    move-object/from16 v34, v7

    .end local v7    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v34    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    int-to-long v10, v3

    .line 498
    invoke-static {v2, v4, v6, v10, v11}, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker;->rechunk(I[J[IJ)Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;

    move-result-object v7

    .line 500
    .local v7, "rechunkedResults":Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;
    iget-object v10, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->offsets:[J

    .line 501
    .local v10, "offsets":[J
    iget-object v11, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->sizes:[I

    .line 502
    .local v11, "sizes":[I
    move/from16 v35, v2

    .end local v2    # "fixedSampleSize":I
    .local v35, "fixedSampleSize":I
    iget v2, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->maximumSize:I

    .line 503
    .end local v33    # "maximumSize":I
    .local v2, "maximumSize":I
    move/from16 v33, v2

    .end local v2    # "maximumSize":I
    .restart local v33    # "maximumSize":I
    iget-object v2, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->timestamps:[J

    .line 504
    .local v2, "timestamps":[J
    move-object/from16 v36, v2

    .end local v2    # "timestamps":[J
    .local v36, "timestamps":[J
    iget-object v2, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->flags:[I

    .line 505
    .local v2, "flags":[I
    iget-wide v6, v7, Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;->duration:J

    .line 506
    .end local v4    # "chunkOffsetsBytes":[J
    .end local v7    # "rechunkedResults":Landroidx/media3/extractor/mp4/FixedSampleSizeRechunker$Results;
    .local v6, "duration":J
    move-object/from16 v37, v5

    move-wide/from16 v42, v6

    move-object v6, v9

    move v7, v14

    move/from16 v38, v24

    move-wide/from16 v39, v30

    move-object v14, v1

    move-object v9, v2

    move/from16 v24, v15

    move/from16 v30, v23

    move/from16 v31, v26

    move-object/from16 v15, v36

    move-object/from16 v36, v0

    move/from16 v23, v20

    move/from16 v26, v22

    move-object/from16 v20, v12

    move/from16 v22, v18

    move-object/from16 v18, v8

    move-object v12, v11

    move-object v11, v10

    move v10, v3

    goto/16 :goto_13

    .line 507
    .end local v10    # "offsets":[J
    .end local v11    # "sizes":[I
    .end local v32    # "sampleMimeType":Ljava/lang/String;
    .end local v33    # "maximumSize":I
    .end local v34    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v35    # "fixedSampleSize":I
    .end local v36    # "timestamps":[J
    .local v2, "fixedSampleSize":I
    .local v4, "sampleMimeType":Ljava/lang/String;
    .local v6, "maximumSize":I
    .local v7, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :cond_b
    move/from16 v35, v2

    move-object/from16 v32, v4

    move/from16 v33, v6

    move-object/from16 v34, v7

    .end local v2    # "fixedSampleSize":I
    .end local v4    # "sampleMimeType":Ljava/lang/String;
    .end local v6    # "maximumSize":I
    .end local v7    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v32    # "sampleMimeType":Ljava/lang/String;
    .restart local v33    # "maximumSize":I
    .restart local v34    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v35    # "fixedSampleSize":I
    new-array v2, v14, [J

    .line 508
    .local v2, "offsets":[J
    new-array v4, v14, [I

    .line 509
    .local v4, "sizes":[I
    new-array v6, v14, [J

    .line 510
    .local v6, "timestamps":[J
    new-array v7, v14, [I

    .line 511
    .local v7, "flags":[I
    const-wide/16 v10, 0x0

    .line 512
    .local v10, "offset":J
    const/16 v36, 0x0

    .line 514
    .local v36, "remainingSamplesInChunk":I
    const/16 v37, 0x0

    move/from16 v9, v37

    move/from16 v76, v18

    move-object/from16 v18, v8

    move/from16 v8, v76

    move/from16 v77, v20

    move-object/from16 v20, v12

    move/from16 v12, v77

    move/from16 v78, v24

    move/from16 v24, v15

    move/from16 v15, v26

    move/from16 v26, v23

    move/from16 v79, v27

    move/from16 v27, v22

    move-wide/from16 v22, v10

    move/from16 v10, v79

    move/from16 v11, v33

    move/from16 v33, v78

    .end local v23    # "remainingTimestampOffsetChanges":I
    .local v8, "remainingTimestampDeltaChanges":I
    .local v9, "i":I
    .local v10, "nextSynchronizationSampleIndex":I
    .local v11, "maximumSize":I
    .local v12, "remainingSamplesAtTimestampDelta":I
    .local v15, "remainingSynchronizationSamples":I
    .local v18, "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    .local v20, "stszAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v22, "offset":J
    .local v24, "chunkOffsetsAreLongs":Z
    .local v26, "remainingTimestampOffsetChanges":I
    .local v27, "remainingSamplesAtTimestampOffset":I
    .local v33, "timestampOffset":I
    :goto_7
    move-object/from16 v37, v5

    .end local v5    # "stts":Landroidx/media3/common/util/ParsableByteArray;
    .local v37, "stts":Landroidx/media3/common/util/ParsableByteArray;
    const-string v5, "AtomParsers"

    if-ge v9, v14, :cond_15

    .line 516
    const/16 v38, 0x1

    .line 517
    .local v38, "chunkDataComplete":Z
    :goto_8
    if-nez v36, :cond_c

    invoke-virtual {v1}, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->moveNext()Z

    move-result v39

    move/from16 v38, v39

    if-eqz v39, :cond_c

    .line 518
    move/from16 v39, v14

    move/from16 v40, v15

    .end local v14    # "sampleCount":I
    .end local v15    # "remainingSynchronizationSamples":I
    .local v39, "sampleCount":I
    .local v40, "remainingSynchronizationSamples":I
    iget-wide v14, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->offset:J

    .line 519
    .end local v22    # "offset":J
    .local v14, "offset":J
    move-wide/from16 v22, v14

    .end local v14    # "offset":J
    .restart local v22    # "offset":J
    iget v14, v1, Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;->numSamples:I

    move/from16 v36, v14

    move/from16 v14, v39

    move/from16 v15, v40

    .end local v36    # "remainingSamplesInChunk":I
    .local v14, "remainingSamplesInChunk":I
    goto :goto_8

    .line 517
    .end local v39    # "sampleCount":I
    .end local v40    # "remainingSynchronizationSamples":I
    .local v14, "sampleCount":I
    .restart local v15    # "remainingSynchronizationSamples":I
    .restart local v36    # "remainingSamplesInChunk":I
    :cond_c
    move/from16 v39, v14

    move/from16 v40, v15

    .line 521
    .end local v14    # "sampleCount":I
    .end local v15    # "remainingSynchronizationSamples":I
    .restart local v39    # "sampleCount":I
    .restart local v40    # "remainingSynchronizationSamples":I
    if-nez v38, :cond_d

    .line 522
    const-string v14, "Unexpected end of chunk data"

    invoke-static {v5, v14}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    move v14, v9

    .line 524
    .end local v39    # "sampleCount":I
    .restart local v14    # "sampleCount":I
    invoke-static {v2, v14}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v2

    .line 525
    invoke-static {v4, v14}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v4

    .line 526
    invoke-static {v6, v14}, Ljava/util/Arrays;->copyOf([JI)[J

    move-result-object v6

    .line 527
    invoke-static {v7, v14}, Ljava/util/Arrays;->copyOf([II)[I

    move-result-object v7

    .line 528
    move-object/from16 v41, v2

    move-object v2, v6

    move/from16 v39, v14

    move-object v14, v1

    move/from16 v1, v36

    goto/16 :goto_d

    .line 532
    .end local v14    # "sampleCount":I
    .restart local v39    # "sampleCount":I
    :cond_d
    if-eqz v0, :cond_f

    move/from16 v15, v27

    .line 533
    .end local v27    # "remainingSamplesAtTimestampOffset":I
    .local v15, "remainingSamplesAtTimestampOffset":I
    :goto_9
    if-nez v15, :cond_e

    if-lez v26, :cond_e

    .line 534
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v15

    .line 540
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v33

    .line 541
    add-int/lit8 v26, v26, -0x1

    goto :goto_9

    .line 543
    :cond_e
    add-int/lit8 v15, v15, -0x1

    move/from16 v27, v15

    move/from16 v5, v33

    goto :goto_a

    .line 532
    .end local v15    # "remainingSamplesAtTimestampOffset":I
    .restart local v27    # "remainingSamplesAtTimestampOffset":I
    :cond_f
    move/from16 v5, v33

    .line 546
    .end local v33    # "timestampOffset":I
    .local v5, "timestampOffset":I
    :goto_a
    aput-wide v22, v2, v9

    .line 547
    invoke-interface {v13}, Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;->readNextSampleSize()I

    move-result v14

    aput v14, v4, v9

    .line 548
    aget v14, v4, v9

    if-le v14, v11, :cond_10

    .line 549
    aget v11, v4, v9

    .line 551
    :cond_10
    int-to-long v14, v5

    add-long v14, v30, v14

    aput-wide v14, v6, v9

    .line 554
    if-nez v19, :cond_11

    const/4 v14, 0x1

    goto :goto_b

    :cond_11
    const/4 v14, 0x0

    :goto_b
    aput v14, v7, v9

    .line 555
    if-ne v9, v10, :cond_12

    .line 556
    const/4 v14, 0x1

    aput v14, v7, v9

    .line 557
    add-int/lit8 v15, v40, -0x1

    .line 558
    .end local v40    # "remainingSynchronizationSamples":I
    .local v15, "remainingSynchronizationSamples":I
    if-lez v15, :cond_13

    .line 559
    invoke-static/range {v19 .. v19}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    check-cast v21, Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual/range {v21 .. v21}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v21

    add-int/lit8 v10, v21, -0x1

    goto :goto_c

    .line 555
    .end local v15    # "remainingSynchronizationSamples":I
    .restart local v40    # "remainingSynchronizationSamples":I
    :cond_12
    move/from16 v15, v40

    .line 564
    .end local v40    # "remainingSynchronizationSamples":I
    .restart local v15    # "remainingSynchronizationSamples":I
    :cond_13
    :goto_c
    move-object v14, v1

    move-object/from16 v41, v2

    .end local v1    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .end local v2    # "offsets":[J
    .local v14, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .local v41, "offsets":[J
    int-to-long v1, v3

    add-long v30, v30, v1

    .line 565
    add-int/lit8 v12, v12, -0x1

    .line 566
    if-nez v12, :cond_14

    if-lez v8, :cond_14

    .line 567
    invoke-virtual/range {v37 .. v37}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v1

    .line 574
    .end local v12    # "remainingSamplesAtTimestampDelta":I
    .local v1, "remainingSamplesAtTimestampDelta":I
    invoke-virtual/range {v37 .. v37}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v3

    .line 575
    add-int/lit8 v8, v8, -0x1

    move v12, v1

    .line 578
    .end local v1    # "remainingSamplesAtTimestampDelta":I
    .restart local v12    # "remainingSamplesAtTimestampDelta":I
    :cond_14
    aget v1, v4, v9

    int-to-long v1, v1

    add-long v22, v22, v1

    .line 579
    nop

    .end local v38    # "chunkDataComplete":Z
    add-int/lit8 v36, v36, -0x1

    .line 514
    add-int/lit8 v9, v9, 0x1

    move/from16 v33, v5

    move-object v1, v14

    move-object/from16 v5, v37

    move/from16 v14, v39

    move-object/from16 v2, v41

    goto/16 :goto_7

    .end local v5    # "timestampOffset":I
    .end local v39    # "sampleCount":I
    .end local v41    # "offsets":[J
    .local v1, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v2    # "offsets":[J
    .local v14, "sampleCount":I
    .restart local v33    # "timestampOffset":I
    :cond_15
    move-object/from16 v41, v2

    move/from16 v39, v14

    move/from16 v40, v15

    move-object v14, v1

    .end local v1    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .end local v2    # "offsets":[J
    .end local v15    # "remainingSynchronizationSamples":I
    .local v14, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v39    # "sampleCount":I
    .restart local v40    # "remainingSynchronizationSamples":I
    .restart local v41    # "offsets":[J
    move-object v2, v6

    move/from16 v1, v36

    .line 581
    .end local v6    # "timestamps":[J
    .end local v9    # "i":I
    .end local v36    # "remainingSamplesInChunk":I
    .local v1, "remainingSamplesInChunk":I
    .local v2, "timestamps":[J
    :goto_d
    move-object v15, v2

    move v9, v3

    move/from16 v6, v33

    .end local v2    # "timestamps":[J
    .end local v3    # "timestampDeltaInTimeUnits":I
    .end local v33    # "timestampOffset":I
    .local v6, "timestampOffset":I
    .local v9, "timestampDeltaInTimeUnits":I
    .local v15, "timestamps":[J
    int-to-long v2, v6

    add-long v2, v30, v2

    .line 585
    .local v2, "duration":J
    const/16 v33, 0x1

    .line 586
    .local v33, "isCttsValid":Z
    if-eqz v0, :cond_17

    .line 587
    :goto_e
    if-lez v26, :cond_17

    .line 588
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v36

    if-eqz v36, :cond_16

    .line 589
    const/16 v33, 0x0

    .line 590
    goto :goto_f

    .line 592
    :cond_16
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    .line 593
    add-int/lit8 v26, v26, -0x1

    goto :goto_e

    .line 596
    :cond_17
    :goto_f
    if-nez v40, :cond_19

    if-nez v12, :cond_19

    if-nez v1, :cond_19

    if-nez v8, :cond_19

    if-nez v27, :cond_19

    if-nez v33, :cond_18

    goto :goto_10

    :cond_18
    move-object/from16 v36, v0

    move-wide/from16 v42, v2

    move/from16 v38, v6

    move/from16 v2, v27

    move/from16 v3, v40

    move-object/from16 v6, p0

    goto :goto_12

    .line 602
    :cond_19
    :goto_10
    move-object/from16 v36, v0

    .end local v0    # "ctts":Landroidx/media3/common/util/ParsableByteArray;
    .local v36, "ctts":Landroidx/media3/common/util/ParsableByteArray;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    move-wide/from16 v42, v2

    .end local v2    # "duration":J
    .local v42, "duration":J
    const-string v2, "Inconsistent stbl box for track "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    move v2, v6

    move-object/from16 v6, p0

    .end local v6    # "timestampOffset":I
    .local v2, "timestampOffset":I
    iget v3, v6, Landroidx/media3/extractor/mp4/Track;->id:I

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ": remainingSynchronizationSamples "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    move/from16 v3, v40

    .end local v40    # "remainingSynchronizationSamples":I
    .local v3, "remainingSynchronizationSamples":I
    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    move/from16 v38, v2

    .end local v2    # "timestampOffset":I
    .local v38, "timestampOffset":I
    const-string v2, ", remainingSamplesAtTimestampDelta "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", remainingSamplesInChunk "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", remainingTimestampDeltaChanges "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", remainingSamplesAtTimestampOffset "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    move/from16 v2, v27

    .end local v27    # "remainingSamplesAtTimestampOffset":I
    .local v2, "remainingSamplesAtTimestampOffset":I
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 616
    if-nez v33, :cond_1a

    const-string v27, ", ctts invalid"

    goto :goto_11

    :cond_1a
    const-string v27, ""

    :goto_11
    move/from16 v40, v1

    move-object/from16 v1, v27

    .end local v1    # "remainingSamplesInChunk":I
    .local v40, "remainingSamplesInChunk":I
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 602
    invoke-static {v5, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 619
    .end local v22    # "offset":J
    .end local v33    # "isCttsValid":Z
    .end local v40    # "remainingSamplesInChunk":I
    :goto_12
    move/from16 v22, v8

    move/from16 v27, v10

    move/from16 v33, v11

    move/from16 v23, v12

    move-object/from16 v11, v41

    move-object v12, v4

    move v10, v9

    move-object v9, v7

    move/from16 v7, v39

    move-wide/from16 v39, v30

    move/from16 v31, v3

    move/from16 v30, v26

    move/from16 v26, v2

    .end local v2    # "remainingSamplesAtTimestampOffset":I
    .end local v3    # "remainingSynchronizationSamples":I
    .end local v4    # "sizes":[I
    .end local v8    # "remainingTimestampDeltaChanges":I
    .end local v41    # "offsets":[J
    .local v7, "sampleCount":I
    .local v9, "flags":[I
    .local v10, "timestampDeltaInTimeUnits":I
    .local v11, "offsets":[J
    .local v12, "sizes":[I
    .local v22, "remainingTimestampDeltaChanges":I
    .local v23, "remainingSamplesAtTimestampDelta":I
    .local v26, "remainingSamplesAtTimestampOffset":I
    .local v27, "nextSynchronizationSampleIndex":I
    .local v30, "remainingTimestampOffsetChanges":I
    .local v31, "remainingSynchronizationSamples":I
    .local v33, "maximumSize":I
    .local v39, "timestampTimeUnits":J
    :goto_13
    const-wide/32 v2, 0xf4240

    iget-wide v4, v6, Landroidx/media3/extractor/mp4/Track;->timescale:J

    move-wide/from16 v0, v42

    invoke-static/range {v0 .. v5}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v51

    .line 621
    .local v51, "durationUs":J
    iget-object v0, v6, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    const-wide/32 v1, 0xf4240

    if-nez v0, :cond_1b

    .line 622
    iget-wide v3, v6, Landroidx/media3/extractor/mp4/Track;->timescale:J

    invoke-static {v15, v1, v2, v3, v4}, Landroidx/media3/common/util/Util;->scaleLargeTimestampsInPlace([JJJ)V

    .line 623
    new-instance v16, Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move-object v2, v11

    move-object v3, v12

    move/from16 v4, v33

    move-object v5, v15

    move-object v8, v6

    move-object v6, v9

    move/from16 v41, v10

    move-object/from16 v53, v13

    move v13, v7

    move-object v10, v8

    move-object/from16 v76, v34

    move-object/from16 v34, v18

    move-object/from16 v18, v76

    .end local v7    # "sampleCount":I
    .end local v10    # "timestampDeltaInTimeUnits":I
    .local v13, "sampleCount":I
    .local v18, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v34, "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    .local v41, "timestampDeltaInTimeUnits":I
    .local v53, "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    move-wide/from16 v7, v51

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    return-object v16

    .line 634
    .end local v41    # "timestampDeltaInTimeUnits":I
    .end local v53    # "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    .restart local v7    # "sampleCount":I
    .restart local v10    # "timestampDeltaInTimeUnits":I
    .local v13, "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    .local v18, "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    .local v34, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :cond_1b
    move/from16 v41, v10

    move-object/from16 v53, v13

    move-object v10, v6

    move v13, v7

    move-object/from16 v76, v34

    move-object/from16 v34, v18

    move-object/from16 v18, v76

    .end local v7    # "sampleCount":I
    .end local v10    # "timestampDeltaInTimeUnits":I
    .local v13, "sampleCount":I
    .local v18, "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v34, "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    .restart local v41    # "timestampDeltaInTimeUnits":I
    .restart local v53    # "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v0, v0

    const-wide/16 v3, 0x0

    const/4 v5, 0x1

    if-ne v0, v5, :cond_1e

    iget v0, v10, Landroidx/media3/extractor/mp4/Track;->type:I

    if-ne v0, v5, :cond_1e

    array-length v0, v15

    const/4 v5, 0x2

    if-lt v0, v5, :cond_1e

    .line 637
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [J

    const/4 v5, 0x0

    aget-wide v54, v0, v5

    .line 638
    .local v54, "editStartTime":J
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    aget-wide v44, v0, v5

    iget-wide v5, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    iget-wide v7, v10, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    .line 640
    move-wide/from16 v46, v5

    move-wide/from16 v48, v7

    invoke-static/range {v44 .. v49}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v5

    add-long v56, v54, v5

    .line 642
    .local v56, "editEndTime":J
    move-object/from16 v44, v15

    move-wide/from16 v45, v42

    move-wide/from16 v47, v54

    move-wide/from16 v49, v56

    invoke-static/range {v44 .. v50}, Landroidx/media3/extractor/mp4/AtomParsers;->canApplyEditWithGaplessInfo([JJJJ)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 643
    sub-long v58, v42, v56

    .line 644
    .local v58, "paddingTimeUnits":J
    const/4 v0, 0x0

    aget-wide v5, v15, v0

    sub-long v44, v54, v5

    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget v0, v0, Landroidx/media3/common/Format;->sampleRate:I

    int-to-long v5, v0

    iget-wide v7, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 645
    move-wide/from16 v46, v5

    move-wide/from16 v48, v7

    invoke-static/range {v44 .. v49}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v7

    .line 647
    .local v7, "encoderDelay":J
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget v0, v0, Landroidx/media3/common/Format;->sampleRate:I

    int-to-long v5, v0

    iget-wide v1, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 648
    move-wide/from16 v44, v58

    move-wide/from16 v46, v5

    move-wide/from16 v48, v1

    invoke-static/range {v44 .. v49}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v5

    .line 649
    .local v5, "encoderPadding":J
    cmp-long v0, v7, v3

    if-nez v0, :cond_1c

    cmp-long v0, v5, v3

    if-eqz v0, :cond_1e

    :cond_1c
    const-wide/32 v0, 0x7fffffff

    cmp-long v2, v7, v0

    if-gtz v2, :cond_1d

    cmp-long v0, v5, v0

    if-gtz v0, :cond_1d

    .line 652
    long-to-int v0, v7

    move-object/from16 v4, p2

    iput v0, v4, Landroidx/media3/extractor/GaplessInfoHolder;->encoderDelay:I

    .line 653
    long-to-int v0, v5

    iput v0, v4, Landroidx/media3/extractor/GaplessInfoHolder;->encoderPadding:I

    .line 654
    iget-wide v0, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    const-wide/32 v2, 0xf4240

    invoke-static {v15, v2, v3, v0, v1}, Landroidx/media3/common/util/Util;->scaleLargeTimestampsInPlace([JJJ)V

    .line 655
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    const/4 v1, 0x0

    aget-wide v44, v0, v1

    const-wide/32 v46, 0xf4240

    iget-wide v0, v10, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    .line 656
    move-wide/from16 v48, v0

    invoke-static/range {v44 .. v49}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v44

    .line 658
    .local v44, "editedDurationUs":J
    new-instance v16, Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move-object v2, v11

    move-object v3, v12

    move/from16 v4, v33

    move-wide/from16 v46, v5

    .end local v5    # "encoderPadding":J
    .local v46, "encoderPadding":J
    move-object v5, v15

    move-object v6, v9

    move-wide/from16 v48, v7

    .end local v7    # "encoderDelay":J
    .local v48, "encoderDelay":J
    move-wide/from16 v7, v44

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    return-object v16

    .line 649
    .end local v44    # "editedDurationUs":J
    .end local v46    # "encoderPadding":J
    .end local v48    # "encoderDelay":J
    .restart local v5    # "encoderPadding":J
    .restart local v7    # "encoderDelay":J
    :cond_1d
    move-wide/from16 v46, v5

    move-wide/from16 v48, v7

    .line 664
    .end local v5    # "encoderPadding":J
    .end local v7    # "encoderDelay":J
    .end local v54    # "editStartTime":J
    .end local v56    # "editEndTime":J
    .end local v58    # "paddingTimeUnits":J
    :cond_1e
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v0, v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_20

    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    const/4 v1, 0x0

    aget-wide v5, v0, v1

    cmp-long v0, v5, v3

    if-nez v0, :cond_20

    .line 668
    iget-object v0, v10, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [J

    aget-wide v44, v0, v1

    .line 669
    .local v44, "editStartTime":J
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_14
    array-length v1, v15

    if-ge v0, v1, :cond_1f

    .line 670
    aget-wide v1, v15, v0

    sub-long v3, v1, v44

    const-wide/32 v5, 0xf4240

    iget-wide v7, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 671
    invoke-static/range {v3 .. v8}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v1

    aput-wide v1, v15, v0

    .line 669
    add-int/lit8 v0, v0, 0x1

    goto :goto_14

    .line 674
    .end local v0    # "i":I
    :cond_1f
    sub-long v1, v42, v44

    const-wide/32 v3, 0xf4240

    iget-wide v5, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 675
    invoke-static/range {v1 .. v6}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v46

    .line 676
    .end local v51    # "durationUs":J
    .local v46, "durationUs":J
    new-instance v16, Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    move-object v2, v11

    move-object v3, v12

    move/from16 v4, v33

    move-object v5, v15

    move-object v6, v9

    move-wide/from16 v7, v46

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    return-object v16

    .line 681
    .end local v44    # "editStartTime":J
    .end local v46    # "durationUs":J
    .restart local v51    # "durationUs":J
    :cond_20
    iget v0, v10, Landroidx/media3/extractor/mp4/Track;->type:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_21

    const/4 v0, 0x1

    goto :goto_15

    :cond_21
    const/4 v0, 0x0

    :goto_15
    move v7, v0

    .line 684
    .local v7, "omitClippedSample":Z
    const/4 v0, 0x0

    .line 685
    .local v0, "editedSampleCount":I
    const/4 v1, 0x0

    .line 686
    .local v1, "nextSampleIndex":I
    const/4 v2, 0x0

    .line 687
    .local v2, "copyMetadata":Z
    iget-object v5, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v5, v5

    new-array v8, v5, [I

    .line 688
    .local v8, "startIndices":[I
    iget-object v5, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v5, v5

    new-array v6, v5, [I

    .line 689
    .local v6, "endIndices":[I
    iget-object v5, v10, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object/from16 v44, v5

    check-cast v44, [J

    .line 690
    .local v44, "editListMediaTimes":[J
    const/4 v5, 0x0

    move/from16 v76, v5

    move v5, v0

    move v0, v2

    move v2, v1

    move/from16 v1, v76

    .local v0, "copyMetadata":Z
    .local v1, "i":I
    .local v2, "nextSampleIndex":I
    .local v5, "editedSampleCount":I
    :goto_16
    iget-object v3, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v3, v3

    if-ge v1, v3, :cond_26

    .line 691
    aget-wide v3, v44, v1

    .line 692
    .local v3, "editMediaTime":J
    const-wide/16 v47, -0x1

    cmp-long v47, v3, v47

    if-eqz v47, :cond_25

    .line 693
    move-object/from16 v47, v14

    .end local v14    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .local v47, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    iget-object v14, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    aget-wide v54, v14, v1

    move-object v14, v11

    move-object/from16 v48, v12

    .end local v11    # "offsets":[J
    .end local v12    # "sizes":[I
    .local v14, "offsets":[J
    .local v48, "sizes":[I
    iget-wide v11, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    move/from16 v49, v13

    move-object/from16 v50, v14

    .end local v13    # "sampleCount":I
    .end local v14    # "offsets":[J
    .local v49, "sampleCount":I
    .local v50, "offsets":[J
    iget-wide v13, v10, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    .line 694
    move-wide/from16 v56, v11

    move-wide/from16 v58, v13

    invoke-static/range {v54 .. v59}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v11

    .line 703
    .local v11, "editDuration":J
    nop

    .line 704
    const/4 v13, 0x1

    invoke-static {v15, v3, v4, v13, v13}, Landroidx/media3/common/util/Util;->binarySearchFloor([JJZZ)I

    move-result v14

    aput v14, v8, v1

    .line 706
    add-long v13, v3, v11

    .line 707
    move-wide/from16 v54, v3

    const/4 v3, 0x0

    .end local v3    # "editMediaTime":J
    .local v54, "editMediaTime":J
    invoke-static {v15, v13, v14, v7, v3}, Landroidx/media3/common/util/Util;->binarySearchCeil([JJZZ)I

    move-result v4

    aput v4, v6, v1

    .line 712
    :goto_17
    aget v4, v8, v1

    aget v13, v6, v1

    if-ge v4, v13, :cond_22

    aget v4, v8, v1

    aget v4, v9, v4

    const/4 v13, 0x1

    and-int/2addr v4, v13

    if-nez v4, :cond_23

    .line 718
    aget v4, v8, v1

    add-int/2addr v4, v13

    aput v4, v8, v1

    goto :goto_17

    .line 712
    :cond_22
    const/4 v13, 0x1

    .line 720
    :cond_23
    aget v4, v6, v1

    aget v14, v8, v1

    sub-int/2addr v4, v14

    add-int/2addr v5, v4

    .line 721
    aget v4, v8, v1

    if-eq v2, v4, :cond_24

    move v4, v13

    goto :goto_18

    :cond_24
    move v4, v3

    :goto_18
    or-int/2addr v0, v4

    .line 722
    aget v2, v6, v1

    goto :goto_19

    .line 692
    .end local v47    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .end local v48    # "sizes":[I
    .end local v49    # "sampleCount":I
    .end local v50    # "offsets":[J
    .end local v54    # "editMediaTime":J
    .restart local v3    # "editMediaTime":J
    .local v11, "offsets":[J
    .restart local v12    # "sizes":[I
    .restart local v13    # "sampleCount":I
    .local v14, "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    :cond_25
    move-wide/from16 v54, v3

    move-object/from16 v50, v11

    move-object/from16 v48, v12

    move/from16 v49, v13

    move-object/from16 v47, v14

    const/4 v3, 0x0

    const/4 v13, 0x1

    .line 690
    .end local v3    # "editMediaTime":J
    .end local v11    # "offsets":[J
    .end local v12    # "sizes":[I
    .end local v13    # "sampleCount":I
    .end local v14    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v47    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v48    # "sizes":[I
    .restart local v49    # "sampleCount":I
    .restart local v50    # "offsets":[J
    :goto_19
    add-int/lit8 v1, v1, 0x1

    move-object/from16 v14, v47

    move-object/from16 v12, v48

    move/from16 v13, v49

    move-object/from16 v11, v50

    const-wide/16 v3, 0x0

    goto :goto_16

    .end local v47    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .end local v48    # "sizes":[I
    .end local v49    # "sampleCount":I
    .end local v50    # "offsets":[J
    .restart local v11    # "offsets":[J
    .restart local v12    # "sizes":[I
    .restart local v13    # "sampleCount":I
    .restart local v14    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    :cond_26
    move-object/from16 v50, v11

    move-object/from16 v48, v12

    move/from16 v49, v13

    move-object/from16 v47, v14

    const/4 v3, 0x0

    const/4 v13, 0x1

    .line 725
    .end local v1    # "i":I
    .end local v11    # "offsets":[J
    .end local v12    # "sizes":[I
    .end local v13    # "sampleCount":I
    .end local v14    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v47    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .restart local v48    # "sizes":[I
    .restart local v49    # "sampleCount":I
    .restart local v50    # "offsets":[J
    move/from16 v14, v49

    .end local v49    # "sampleCount":I
    .local v14, "sampleCount":I
    if-eq v5, v14, :cond_27

    goto :goto_1a

    :cond_27
    move v13, v3

    :goto_1a
    or-int v11, v0, v13

    .line 728
    .end local v0    # "copyMetadata":Z
    .local v11, "copyMetadata":Z
    if-eqz v11, :cond_28

    new-array v0, v5, [J

    goto :goto_1b

    :cond_28
    move-object/from16 v0, v50

    :goto_1b
    move-object v12, v0

    .line 729
    .local v12, "editedOffsets":[J
    if-eqz v11, :cond_29

    new-array v0, v5, [I

    goto :goto_1c

    :cond_29
    move-object/from16 v0, v48

    :goto_1c
    move-object v13, v0

    .line 730
    .local v13, "editedSizes":[I
    if-eqz v11, :cond_2a

    move v1, v3

    goto :goto_1d

    :cond_2a
    move/from16 v1, v33

    :goto_1d
    move v0, v1

    .line 731
    .local v0, "editedMaximumSize":I
    if-eqz v11, :cond_2b

    new-array v1, v5, [I

    goto :goto_1e

    :cond_2b
    move-object v1, v9

    :goto_1e
    move-object v4, v1

    .line 732
    .local v4, "editedFlags":[I
    new-array v3, v5, [J

    .line 733
    .local v3, "editedTimestamps":[J
    const-wide/16 v54, 0x0

    .line 734
    .local v54, "pts":J
    const/4 v1, 0x0

    .line 735
    .local v1, "sampleIndex":I
    const/16 v16, 0x0

    move-wide/from16 v60, v54

    move/from16 v76, v16

    move/from16 v16, v0

    move/from16 v0, v76

    .end local v54    # "pts":J
    .local v0, "i":I
    .local v16, "editedMaximumSize":I
    .local v60, "pts":J
    :goto_1f
    move/from16 v21, v2

    .end local v2    # "nextSampleIndex":I
    .local v21, "nextSampleIndex":I
    iget-object v2, v10, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v2, v2

    if-ge v0, v2, :cond_30

    .line 736
    iget-object v2, v10, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    aget-wide v62, v2, v0

    .line 737
    .local v62, "editMediaTime":J
    aget v2, v8, v0

    .line 738
    .local v2, "startIndex":I
    move/from16 v49, v5

    .end local v5    # "editedSampleCount":I
    .local v49, "editedSampleCount":I
    aget v5, v6, v0

    .line 739
    .local v5, "endIndex":I
    if-eqz v11, :cond_2c

    .line 740
    move-object/from16 v64, v6

    .end local v6    # "endIndices":[I
    .local v64, "endIndices":[I
    sub-int v6, v5, v2

    .line 741
    .local v6, "count":I
    move/from16 v65, v14

    move-object/from16 v14, v50

    .end local v50    # "offsets":[J
    .local v14, "offsets":[J
    .local v65, "sampleCount":I
    invoke-static {v14, v2, v12, v1, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 742
    move-object/from16 v14, v48

    .end local v48    # "sizes":[I
    .local v14, "sizes":[I
    .restart local v50    # "offsets":[J
    invoke-static {v14, v2, v13, v1, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 743
    invoke-static {v9, v2, v4, v1, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_20

    .line 739
    .end local v64    # "endIndices":[I
    .end local v65    # "sampleCount":I
    .local v6, "endIndices":[I
    .local v14, "sampleCount":I
    .restart local v48    # "sizes":[I
    :cond_2c
    move-object/from16 v64, v6

    move/from16 v65, v14

    move-object/from16 v14, v48

    .line 745
    .end local v6    # "endIndices":[I
    .end local v48    # "sizes":[I
    .local v14, "sizes":[I
    .restart local v64    # "endIndices":[I
    .restart local v65    # "sampleCount":I
    :goto_20
    move v6, v2

    move/from16 v48, v2

    move/from16 v2, v16

    .end local v16    # "editedMaximumSize":I
    .local v2, "editedMaximumSize":I
    .local v6, "j":I
    .local v48, "startIndex":I
    :goto_21
    if-ge v6, v5, :cond_2f

    .line 746
    const-wide/32 v56, 0xf4240

    move-object/from16 v66, v4

    move/from16 v67, v5

    .end local v4    # "editedFlags":[I
    .end local v5    # "endIndex":I
    .local v66, "editedFlags":[I
    .local v67, "endIndex":I
    iget-wide v4, v10, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    move-wide/from16 v54, v60

    move-wide/from16 v58, v4

    invoke-static/range {v54 .. v59}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v4

    .line 747
    .local v4, "ptsUs":J
    aget-wide v54, v15, v6

    sub-long v68, v54, v62

    const-wide/32 v70, 0xf4240

    move/from16 v74, v7

    move-object/from16 v75, v8

    .end local v7    # "omitClippedSample":Z
    .end local v8    # "startIndices":[I
    .local v74, "omitClippedSample":Z
    .local v75, "startIndices":[I
    iget-wide v7, v10, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 748
    move-wide/from16 v72, v7

    invoke-static/range {v68 .. v73}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v7

    .line 750
    .local v7, "timeInSegmentUs":J
    move-object/from16 v68, v9

    .end local v9    # "flags":[I
    .local v68, "flags":[I
    iget v9, v10, Landroidx/media3/extractor/mp4/Track;->type:I

    invoke-static {v9}, Landroidx/media3/extractor/mp4/AtomParsers;->canTrimSamplesWithTimestampChange(I)Z

    move-result v9

    if-eqz v9, :cond_2d

    .line 751
    const-wide/16 v9, 0x0

    invoke-static {v9, v10, v7, v8}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v7

    goto :goto_22

    .line 750
    :cond_2d
    const-wide/16 v9, 0x0

    .line 753
    :goto_22
    add-long v45, v4, v7

    aput-wide v45, v3, v1

    .line 754
    if-eqz v11, :cond_2e

    aget v9, v13, v1

    if-le v9, v2, :cond_2e

    .line 755
    aget v2, v14, v6

    .line 757
    :cond_2e
    nop

    .end local v4    # "ptsUs":J
    .end local v7    # "timeInSegmentUs":J
    add-int/lit8 v1, v1, 0x1

    .line 745
    add-int/lit8 v6, v6, 0x1

    move-object/from16 v10, p0

    move-object/from16 v4, v66

    move/from16 v5, v67

    move-object/from16 v9, v68

    move/from16 v7, v74

    move-object/from16 v8, v75

    goto :goto_21

    .end local v66    # "editedFlags":[I
    .end local v67    # "endIndex":I
    .end local v68    # "flags":[I
    .end local v74    # "omitClippedSample":Z
    .end local v75    # "startIndices":[I
    .local v4, "editedFlags":[I
    .restart local v5    # "endIndex":I
    .local v7, "omitClippedSample":Z
    .restart local v8    # "startIndices":[I
    .restart local v9    # "flags":[I
    :cond_2f
    move-object/from16 v66, v4

    move/from16 v67, v5

    move/from16 v74, v7

    move-object/from16 v75, v8

    move-object/from16 v68, v9

    .line 759
    .end local v4    # "editedFlags":[I
    .end local v5    # "endIndex":I
    .end local v6    # "j":I
    .end local v7    # "omitClippedSample":Z
    .end local v8    # "startIndices":[I
    .end local v9    # "flags":[I
    .restart local v66    # "editedFlags":[I
    .restart local v67    # "endIndex":I
    .restart local v68    # "flags":[I
    .restart local v74    # "omitClippedSample":Z
    .restart local v75    # "startIndices":[I
    const-wide/16 v4, 0x0

    move-object/from16 v9, p0

    iget-object v6, v9, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    aget-wide v7, v6, v0

    add-long v60, v60, v7

    .line 735
    .end local v48    # "startIndex":I
    .end local v62    # "editMediaTime":J
    .end local v67    # "endIndex":I
    add-int/lit8 v0, v0, 0x1

    move/from16 v16, v2

    move-object v10, v9

    move-object/from16 v48, v14

    move/from16 v2, v21

    move/from16 v5, v49

    move-object/from16 v6, v64

    move/from16 v14, v65

    move-object/from16 v4, v66

    move-object/from16 v9, v68

    move/from16 v7, v74

    move-object/from16 v8, v75

    goto/16 :goto_1f

    .end local v2    # "editedMaximumSize":I
    .end local v49    # "editedSampleCount":I
    .end local v64    # "endIndices":[I
    .end local v65    # "sampleCount":I
    .end local v66    # "editedFlags":[I
    .end local v68    # "flags":[I
    .end local v74    # "omitClippedSample":Z
    .end local v75    # "startIndices":[I
    .restart local v4    # "editedFlags":[I
    .local v5, "editedSampleCount":I
    .local v6, "endIndices":[I
    .restart local v7    # "omitClippedSample":Z
    .restart local v8    # "startIndices":[I
    .restart local v9    # "flags":[I
    .local v14, "sampleCount":I
    .restart local v16    # "editedMaximumSize":I
    .local v48, "sizes":[I
    :cond_30
    move-object/from16 v66, v4

    move/from16 v49, v5

    move-object/from16 v64, v6

    move/from16 v74, v7

    move-object/from16 v75, v8

    move-object/from16 v68, v9

    move-object v9, v10

    move/from16 v65, v14

    move-object/from16 v14, v48

    .line 761
    .end local v0    # "i":I
    .end local v4    # "editedFlags":[I
    .end local v5    # "editedSampleCount":I
    .end local v6    # "endIndices":[I
    .end local v7    # "omitClippedSample":Z
    .end local v8    # "startIndices":[I
    .end local v9    # "flags":[I
    .end local v48    # "sizes":[I
    .local v14, "sizes":[I
    .restart local v49    # "editedSampleCount":I
    .restart local v64    # "endIndices":[I
    .restart local v65    # "sampleCount":I
    .restart local v66    # "editedFlags":[I
    .restart local v68    # "flags":[I
    .restart local v74    # "omitClippedSample":Z
    .restart local v75    # "startIndices":[I
    const-wide/32 v56, 0xf4240

    iget-wide v4, v9, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    .line 762
    move-wide/from16 v54, v60

    move-wide/from16 v58, v4

    invoke-static/range {v54 .. v59}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v45

    .line 763
    .local v45, "editedDurationUs":J
    new-instance v10, Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-object v0, v10

    move/from16 v48, v1

    .end local v1    # "sampleIndex":I
    .local v48, "sampleIndex":I
    move-object/from16 v1, p0

    move-object v2, v12

    move-object/from16 v54, v3

    .end local v3    # "editedTimestamps":[J
    .local v54, "editedTimestamps":[J
    move-object v3, v13

    move-object/from16 v55, v66

    .end local v66    # "editedFlags":[I
    .local v55, "editedFlags":[I
    move/from16 v4, v16

    move-object/from16 v5, v54

    move-object/from16 v56, v64

    .end local v64    # "endIndices":[I
    .local v56, "endIndices":[I
    move-object/from16 v6, v55

    move/from16 v57, v74

    move-object/from16 v58, v75

    .end local v74    # "omitClippedSample":Z
    .end local v75    # "startIndices":[I
    .local v57, "omitClippedSample":Z
    .local v58, "startIndices":[I
    move-wide/from16 v7, v45

    invoke-direct/range {v0 .. v8}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    return-object v10

    .line 402
    .end local v11    # "copyMetadata":Z
    .end local v13    # "editedSizes":[I
    .end local v14    # "sizes":[I
    .end local v15    # "timestamps":[J
    .end local v16    # "editedMaximumSize":I
    .end local v17    # "cttsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v18    # "chunkOffsetsAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v19    # "stss":Landroidx/media3/common/util/ParsableByteArray;
    .end local v20    # "stszAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v21    # "nextSampleIndex":I
    .end local v22    # "remainingTimestampDeltaChanges":I
    .end local v23    # "remainingSamplesAtTimestampDelta":I
    .end local v24    # "chunkOffsetsAreLongs":Z
    .end local v25    # "stssAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v26    # "remainingSamplesAtTimestampOffset":I
    .end local v27    # "nextSynchronizationSampleIndex":I
    .end local v28    # "stsc":Landroidx/media3/common/util/ParsableByteArray;
    .end local v29    # "rechunkFixedSizeSamples":Z
    .end local v30    # "remainingTimestampOffsetChanges":I
    .end local v31    # "remainingSynchronizationSamples":I
    .end local v32    # "sampleMimeType":Ljava/lang/String;
    .end local v33    # "maximumSize":I
    .end local v34    # "chunkOffsets":Landroidx/media3/common/util/ParsableByteArray;
    .end local v35    # "fixedSampleSize":I
    .end local v36    # "ctts":Landroidx/media3/common/util/ParsableByteArray;
    .end local v37    # "stts":Landroidx/media3/common/util/ParsableByteArray;
    .end local v38    # "timestampOffset":I
    .end local v39    # "timestampTimeUnits":J
    .end local v41    # "timestampDeltaInTimeUnits":I
    .end local v42    # "duration":J
    .end local v44    # "editListMediaTimes":[J
    .end local v45    # "editedDurationUs":J
    .end local v47    # "chunkIterator":Landroidx/media3/extractor/mp4/AtomParsers$ChunkIterator;
    .end local v48    # "sampleIndex":I
    .end local v49    # "editedSampleCount":I
    .end local v50    # "offsets":[J
    .end local v51    # "durationUs":J
    .end local v53    # "sampleSizeBox":Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;
    .end local v54    # "editedTimestamps":[J
    .end local v55    # "editedFlags":[I
    .end local v56    # "endIndices":[I
    .end local v57    # "omitClippedSample":Z
    .end local v58    # "startIndices":[I
    .end local v60    # "pts":J
    .end local v65    # "sampleCount":I
    .end local v68    # "flags":[I
    .local v1, "stz2Atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v12, "stszAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :cond_31
    const-string v2, "Track has no sample table size information"

    invoke-static {v2, v0}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method private static parseStsd(Landroidx/media3/common/util/ParsableByteArray;IILjava/lang/String;Landroidx/media3/common/DrmInitData;Z)Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    .locals 18
    .param p0, "stsd"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "trackId"    # I
    .param p2, "rotationDegrees"    # I
    .param p3, "language"    # Ljava/lang/String;
    .param p4, "drmInitData"    # Landroidx/media3/common/DrmInitData;
    .param p5, "isQuickTime"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 958
    move-object/from16 v10, p0

    move/from16 v11, p1

    const/16 v0, 0xc

    invoke-virtual {v10, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 959
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v12

    .line 960
    .local v12, "numberOfEntries":I
    new-instance v0, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;

    invoke-direct {v0, v12}, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;-><init>(I)V

    move-object v13, v0

    .line 961
    .local v13, "out":Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    const/4 v0, 0x0

    move v14, v0

    .local v14, "i":I
    :goto_0
    if-ge v14, v12, :cond_9

    .line 962
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v15

    .line 963
    .local v15, "childStartPosition":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v16

    .line 964
    .local v16, "childAtomSize":I
    if-lez v16, :cond_0

    const/4 v0, 0x1

    goto :goto_1

    :cond_0
    const/4 v0, 0x0

    :goto_1
    const-string v1, "childAtomSize must be positive"

    invoke-static {v0, v1}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 965
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v9

    .line 966
    .local v9, "childAtomType":I
    const v0, 0x61766331

    if-eq v9, v0, :cond_8

    const v0, 0x61766333

    if-eq v9, v0, :cond_8

    const v0, 0x656e6376

    if-eq v9, v0, :cond_8

    const v0, 0x6d317620

    if-eq v9, v0, :cond_8

    const v0, 0x6d703476

    if-eq v9, v0, :cond_8

    const v0, 0x68766331

    if-eq v9, v0, :cond_8

    const v0, 0x68657631

    if-eq v9, v0, :cond_8

    const v0, 0x73323633

    if-eq v9, v0, :cond_8

    const v0, 0x48323633

    if-eq v9, v0, :cond_8

    const v0, 0x76703038

    if-eq v9, v0, :cond_8

    const v0, 0x76703039

    if-eq v9, v0, :cond_8

    const v0, 0x61763031

    if-eq v9, v0, :cond_8

    const v0, 0x64766176

    if-eq v9, v0, :cond_8

    const v0, 0x64766131

    if-eq v9, v0, :cond_8

    const v0, 0x64766865

    if-eq v9, v0, :cond_8

    const v0, 0x64766831

    if-ne v9, v0, :cond_1

    move/from16 v17, v9

    goto/16 :goto_4

    .line 992
    :cond_1
    const v0, 0x6d703461

    if-eq v9, v0, :cond_7

    const v0, 0x656e6361

    if-eq v9, v0, :cond_7

    const v0, 0x61632d33

    if-eq v9, v0, :cond_7

    const v0, 0x65632d33

    if-eq v9, v0, :cond_7

    const v0, 0x61632d34

    if-eq v9, v0, :cond_7

    const v0, 0x6d6c7061

    if-eq v9, v0, :cond_7

    const v0, 0x64747363

    if-eq v9, v0, :cond_7

    const v0, 0x64747365

    if-eq v9, v0, :cond_7

    const v0, 0x64747368

    if-eq v9, v0, :cond_7

    const v0, 0x6474736c

    if-eq v9, v0, :cond_7

    const v0, 0x64747378

    if-eq v9, v0, :cond_7

    const v0, 0x73616d72

    if-eq v9, v0, :cond_7

    const v0, 0x73617762

    if-eq v9, v0, :cond_7

    const v0, 0x6c70636d

    if-eq v9, v0, :cond_7

    const v0, 0x736f7774

    if-eq v9, v0, :cond_7

    const v0, 0x74776f73

    if-eq v9, v0, :cond_7

    const v0, 0x2e6d7032

    if-eq v9, v0, :cond_7

    const v0, 0x2e6d7033

    if-eq v9, v0, :cond_7

    const v0, 0x6d686131

    if-eq v9, v0, :cond_7

    const v0, 0x6d686d31

    if-eq v9, v0, :cond_7

    const v0, 0x616c6163

    if-eq v9, v0, :cond_7

    const v0, 0x616c6177

    if-eq v9, v0, :cond_7

    const v0, 0x756c6177

    if-eq v9, v0, :cond_7

    const v0, 0x4f707573

    if-eq v9, v0, :cond_7

    const v0, 0x664c6143

    if-ne v9, v0, :cond_2

    goto :goto_3

    .line 1028
    :cond_2
    const v0, 0x54544d4c

    if-eq v9, v0, :cond_6

    const v0, 0x74783367

    if-eq v9, v0, :cond_6

    const v0, 0x77767474

    if-eq v9, v0, :cond_6

    const v0, 0x73747070

    if-eq v9, v0, :cond_6

    const v0, 0x63363038

    if-ne v9, v0, :cond_3

    goto :goto_2

    .line 1035
    :cond_3
    const v0, 0x6d657474

    if-ne v9, v0, :cond_4

    .line 1036
    invoke-static {v10, v9, v15, v11, v13}, Landroidx/media3/extractor/mp4/AtomParsers;->parseMetaDataSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIILandroidx/media3/extractor/mp4/AtomParsers$StsdData;)V

    move/from16 v17, v9

    goto/16 :goto_5

    .line 1037
    :cond_4
    const v0, 0x63616d6d

    if-ne v9, v0, :cond_5

    .line 1038
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 1040
    invoke-virtual {v0, v11}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1041
    const-string v1, "application/x-camera-motion"

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1042
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v0

    iput-object v0, v13, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    move/from16 v17, v9

    goto :goto_5

    .line 1037
    :cond_5
    move/from16 v17, v9

    goto :goto_5

    .line 1033
    :cond_6
    :goto_2
    move-object/from16 v0, p0

    move v1, v9

    move v2, v15

    move/from16 v3, v16

    move/from16 v4, p1

    move-object/from16 v5, p3

    move-object v6, v13

    invoke-static/range {v0 .. v6}, Landroidx/media3/extractor/mp4/AtomParsers;->parseTextSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIILjava/lang/String;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;)V

    move/from16 v17, v9

    goto :goto_5

    .line 1017
    :cond_7
    :goto_3
    move-object/from16 v0, p0

    move v1, v9

    move v2, v15

    move/from16 v3, v16

    move/from16 v4, p1

    move-object/from16 v5, p3

    move/from16 v6, p5

    move-object/from16 v7, p4

    move-object v8, v13

    move/from16 v17, v9

    .end local v9    # "childAtomType":I
    .local v17, "childAtomType":I
    move v9, v14

    invoke-static/range {v0 .. v9}, Landroidx/media3/extractor/mp4/AtomParsers;->parseAudioSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIILjava/lang/String;ZLandroidx/media3/common/DrmInitData;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;I)V

    goto :goto_5

    .line 966
    .end local v17    # "childAtomType":I
    .restart local v9    # "childAtomType":I
    :cond_8
    move/from16 v17, v9

    .line 982
    .end local v9    # "childAtomType":I
    .restart local v17    # "childAtomType":I
    :goto_4
    move-object/from16 v0, p0

    move/from16 v1, v17

    move v2, v15

    move/from16 v3, v16

    move/from16 v4, p1

    move/from16 v5, p2

    move-object/from16 v6, p4

    move-object v7, v13

    move v8, v14

    invoke-static/range {v0 .. v8}, Landroidx/media3/extractor/mp4/AtomParsers;->parseVideoSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIIILandroidx/media3/common/DrmInitData;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;I)V

    .line 1044
    :goto_5
    add-int v0, v15, v16

    invoke-virtual {v10, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 961
    .end local v15    # "childStartPosition":I
    .end local v16    # "childAtomSize":I
    .end local v17    # "childAtomType":I
    add-int/lit8 v14, v14, 0x1

    goto/16 :goto_0

    .line 1046
    .end local v14    # "i":I
    :cond_9
    return-object v13
.end method

.method private static parseTextSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIILjava/lang/String;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;)V
    .locals 7
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "atomType"    # I
    .param p2, "position"    # I
    .param p3, "atomSize"    # I
    .param p4, "trackId"    # I
    .param p5, "language"    # Ljava/lang/String;
    .param p6, "out"    # Landroidx/media3/extractor/mp4/AtomParsers$StsdData;

    .line 1057
    add-int/lit8 v0, p2, 0x8

    add-int/lit8 v0, v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1060
    const/4 v0, 0x0

    .line 1061
    .local v0, "initializationData":Lcom/google/common/collect/ImmutableList;, "Lcom/google/common/collect/ImmutableList<[B>;"
    const-wide v1, 0x7fffffffffffffffL

    .line 1064
    .local v1, "subsampleOffsetUs":J
    const v3, 0x54544d4c

    if-ne p1, v3, :cond_0

    .line 1065
    const-string v3, "application/ttml+xml"

    .local v3, "mimeType":Ljava/lang/String;
    goto :goto_0

    .line 1066
    .end local v3    # "mimeType":Ljava/lang/String;
    :cond_0
    const v3, 0x74783367

    if-ne p1, v3, :cond_1

    .line 1067
    const-string v3, "application/x-quicktime-tx3g"

    .line 1068
    .restart local v3    # "mimeType":Ljava/lang/String;
    add-int/lit8 v4, p3, -0x8

    add-int/lit8 v4, v4, -0x8

    .line 1069
    .local v4, "sampleDescriptionLength":I
    new-array v5, v4, [B

    .line 1070
    .local v5, "sampleDescriptionData":[B
    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6, v4}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1071
    invoke-static {v5}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    .line 1072
    .end local v4    # "sampleDescriptionLength":I
    .end local v5    # "sampleDescriptionData":[B
    goto :goto_0

    .end local v3    # "mimeType":Ljava/lang/String;
    :cond_1
    const v3, 0x77767474

    if-ne p1, v3, :cond_2

    .line 1073
    const-string v3, "application/x-mp4-vtt"

    .restart local v3    # "mimeType":Ljava/lang/String;
    goto :goto_0

    .line 1074
    .end local v3    # "mimeType":Ljava/lang/String;
    :cond_2
    const v3, 0x73747070

    if-ne p1, v3, :cond_3

    .line 1075
    const-string v3, "application/ttml+xml"

    .line 1076
    .restart local v3    # "mimeType":Ljava/lang/String;
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 1077
    .end local v3    # "mimeType":Ljava/lang/String;
    :cond_3
    const v3, 0x63363038

    if-ne p1, v3, :cond_4

    .line 1079
    const-string v3, "application/x-mp4-cea-608"

    .line 1080
    .restart local v3    # "mimeType":Ljava/lang/String;
    const/4 v4, 0x1

    iput v4, p6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->requiredSampleTransformation:I

    .line 1086
    :goto_0
    new-instance v4, Landroidx/media3/common/Format$Builder;

    invoke-direct {v4}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 1088
    invoke-virtual {v4, p4}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v4

    .line 1089
    invoke-virtual {v4, v3}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v4

    .line 1090
    invoke-virtual {v4, p5}, Landroidx/media3/common/Format$Builder;->setLanguage(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v4

    .line 1091
    invoke-virtual {v4, v1, v2}, Landroidx/media3/common/Format$Builder;->setSubsampleOffsetUs(J)Landroidx/media3/common/Format$Builder;

    move-result-object v4

    .line 1092
    invoke-virtual {v4, v0}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v4

    .line 1093
    invoke-virtual {v4}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v4

    iput-object v4, p6, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    .line 1094
    return-void

    .line 1083
    .end local v3    # "mimeType":Ljava/lang/String;
    :cond_4
    new-instance v3, Ljava/lang/IllegalStateException;

    invoke-direct {v3}, Ljava/lang/IllegalStateException;-><init>()V

    throw v3
.end method

.method private static parseTkhd(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;
    .locals 15
    .param p0, "tkhd"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 837
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 838
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 839
    .local v1, "fullAtom":I
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v2

    .line 841
    .local v2, "version":I
    const/16 v3, 0x10

    if-nez v2, :cond_0

    move v4, v0

    goto :goto_0

    :cond_0
    move v4, v3

    :goto_0
    invoke-virtual {p0, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 842
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 844
    .local v4, "trackId":I
    const/4 v5, 0x4

    invoke-virtual {p0, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 845
    const/4 v6, 0x1

    .line 846
    .local v6, "durationUnknown":Z
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v7

    .line 847
    .local v7, "durationPosition":I
    if-nez v2, :cond_1

    move v0, v5

    .line 848
    .local v0, "durationByteCount":I
    :cond_1
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    if-ge v8, v0, :cond_3

    .line 849
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v9

    add-int v10, v7, v8

    aget-byte v9, v9, v10

    const/4 v10, -0x1

    if-eq v9, v10, :cond_2

    .line 850
    const/4 v6, 0x0

    .line 851
    goto :goto_2

    .line 848
    :cond_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 855
    .end local v8    # "i":I
    :cond_3
    :goto_2
    if-eqz v6, :cond_4

    .line 856
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 857
    const-wide v8, -0x7fffffffffffffffL    # -4.9E-324

    .local v8, "duration":J
    goto :goto_4

    .line 859
    .end local v8    # "duration":J
    :cond_4
    if-nez v2, :cond_5

    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v8

    goto :goto_3

    :cond_5
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v8

    .line 860
    .restart local v8    # "duration":J
    :goto_3
    const-wide/16 v10, 0x0

    cmp-long v10, v8, v10

    if-nez v10, :cond_6

    .line 863
    const-wide v8, -0x7fffffffffffffffL    # -4.9E-324

    .line 867
    :cond_6
    :goto_4
    invoke-virtual {p0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 868
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v3

    .line 869
    .local v3, "a00":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    .line 870
    .local v10, "a01":I
    invoke-virtual {p0, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 871
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 872
    .local v5, "a10":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v11

    .line 875
    .local v11, "a11":I
    const/high16 v12, 0x10000

    .line 876
    .local v12, "fixedOne":I
    if-nez v3, :cond_7

    if-ne v10, v12, :cond_7

    neg-int v13, v12

    if-ne v5, v13, :cond_7

    if-nez v11, :cond_7

    .line 877
    const/16 v13, 0x5a

    .local v13, "rotationDegrees":I
    goto :goto_5

    .line 878
    .end local v13    # "rotationDegrees":I
    :cond_7
    if-nez v3, :cond_8

    neg-int v13, v12

    if-ne v10, v13, :cond_8

    if-ne v5, v12, :cond_8

    if-nez v11, :cond_8

    .line 879
    const/16 v13, 0x10e

    .restart local v13    # "rotationDegrees":I
    goto :goto_5

    .line 880
    .end local v13    # "rotationDegrees":I
    :cond_8
    neg-int v13, v12

    if-ne v3, v13, :cond_9

    if-nez v10, :cond_9

    if-nez v5, :cond_9

    neg-int v13, v12

    if-ne v11, v13, :cond_9

    .line 881
    const/16 v13, 0xb4

    .restart local v13    # "rotationDegrees":I
    goto :goto_5

    .line 884
    .end local v13    # "rotationDegrees":I
    :cond_9
    const/4 v13, 0x0

    .line 887
    .restart local v13    # "rotationDegrees":I
    :goto_5
    new-instance v14, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;

    invoke-direct {v14, v4, v8, v9, v13}, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;-><init>(IJI)V

    return-object v14
.end method

.method private static parseTrak(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/mp4/Atom$LeafAtom;JLandroidx/media3/common/DrmInitData;ZZ)Landroidx/media3/extractor/mp4/Track;
    .locals 34
    .param p0, "trak"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p1, "mvhd"    # Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .param p2, "duration"    # J
    .param p4, "drmInitData"    # Landroidx/media3/common/DrmInitData;
    .param p5, "ignoreEditLists"    # Z
    .param p6, "isQuickTime"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 316
    move-object/from16 v0, p0

    const v1, 0x6d646961

    invoke-virtual {v0, v1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 318
    .local v1, "mdia":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    nop

    .line 319
    const v2, 0x68646c72    # 4.3148E24f

    invoke-virtual {v1, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget-object v2, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v2}, Landroidx/media3/extractor/mp4/AtomParsers;->parseHdlr(Landroidx/media3/common/util/ParsableByteArray;)I

    move-result v2

    invoke-static {v2}, Landroidx/media3/extractor/mp4/AtomParsers;->getTrackTypeForHdlr(I)I

    move-result v2

    .line 320
    .local v2, "trackType":I
    const/4 v3, -0x1

    const/4 v4, 0x0

    if-ne v2, v3, :cond_0

    .line 321
    return-object v4

    .line 324
    :cond_0
    const v3, 0x746b6864

    invoke-virtual {v0, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget-object v3, v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v3}, Landroidx/media3/extractor/mp4/AtomParsers;->parseTkhd(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;

    move-result-object v18

    .line 325
    .local v18, "tkhdData":Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;
    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v3, p2, v5

    if-nez v3, :cond_1

    .line 326
    invoke-static/range {v18 .. v18}, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;->access$000(Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;)J

    move-result-wide v7

    move-wide/from16 v19, v7

    .end local p2    # "duration":J
    .local v7, "duration":J
    goto :goto_0

    .line 325
    .end local v7    # "duration":J
    .restart local p2    # "duration":J
    :cond_1
    move-wide/from16 v19, p2

    .line 328
    .end local p2    # "duration":J
    .local v19, "duration":J
    :goto_0
    move-object/from16 v15, p1

    iget-object v3, v15, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v3}, Landroidx/media3/extractor/mp4/AtomParsers;->parseMvhd(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/container/Mp4TimestampData;

    move-result-object v3

    iget-wide v7, v3, Landroidx/media3/container/Mp4TimestampData;->timescale:J

    .line 330
    .local v7, "movieTimescale":J
    cmp-long v3, v19, v5

    if-nez v3, :cond_2

    .line 331
    const-wide v5, -0x7fffffffffffffffL    # -4.9E-324

    move-wide/from16 v21, v5

    .local v5, "durationUs":J
    goto :goto_1

    .line 333
    .end local v5    # "durationUs":J
    :cond_2
    const-wide/32 v11, 0xf4240

    move-wide/from16 v9, v19

    move-wide v13, v7

    invoke-static/range {v9 .. v14}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v5

    move-wide/from16 v21, v5

    .line 335
    .local v21, "durationUs":J
    :goto_1
    nop

    .line 337
    const v3, 0x6d696e66

    invoke-virtual {v1, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 338
    const v5, 0x7374626c

    invoke-virtual {v3, v5}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v3

    .line 336
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v14, v3

    check-cast v14, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 340
    .local v14, "stbl":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    nop

    .line 341
    const v3, 0x6d646864

    invoke-virtual {v1, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v3

    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget-object v3, v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v3}, Landroidx/media3/extractor/mp4/AtomParsers;->parseMdhd(Landroidx/media3/common/util/ParsableByteArray;)Landroid/util/Pair;

    move-result-object v13

    .line 342
    .local v13, "mdhdData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/String;>;"
    const v3, 0x73747364

    invoke-virtual {v14, v3}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v12

    .line 343
    .local v12, "stsd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v12, :cond_5

    .line 347
    iget-object v3, v12, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 350
    invoke-static/range {v18 .. v18}, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;->access$100(Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;)I

    move-result v24

    .line 351
    invoke-static/range {v18 .. v18}, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;->access$200(Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;)I

    move-result v25

    iget-object v5, v13, Landroid/util/Pair;->second:Ljava/lang/Object;

    move-object/from16 v26, v5

    check-cast v26, Ljava/lang/String;

    .line 348
    move-object/from16 v23, v3

    move-object/from16 v27, p4

    move/from16 v28, p6

    invoke-static/range {v23 .. v28}, Landroidx/media3/extractor/mp4/AtomParsers;->parseStsd(Landroidx/media3/common/util/ParsableByteArray;IILjava/lang/String;Landroidx/media3/common/DrmInitData;Z)Landroidx/media3/extractor/mp4/AtomParsers$StsdData;

    move-result-object v10

    .line 355
    .local v10, "stsdData":Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    const/4 v3, 0x0

    .line 356
    .local v3, "editListDurations":[J
    const/4 v5, 0x0

    .line 357
    .local v5, "editListMediaTimes":[J
    if-nez p5, :cond_3

    .line 358
    const v6, 0x65647473

    invoke-virtual {v0, v6}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v6

    .line 359
    .local v6, "edtsAtom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    if-eqz v6, :cond_3

    .line 360
    invoke-static {v6}, Landroidx/media3/extractor/mp4/AtomParsers;->parseEdts(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)Landroid/util/Pair;

    move-result-object v9

    .line 361
    .local v9, "edtsData":Landroid/util/Pair;, "Landroid/util/Pair<[J[J>;"
    if-eqz v9, :cond_3

    .line 362
    iget-object v11, v9, Landroid/util/Pair;->first:Ljava/lang/Object;

    move-object v3, v11

    check-cast v3, [J

    .line 363
    iget-object v11, v9, Landroid/util/Pair;->second:Ljava/lang/Object;

    move-object v5, v11

    check-cast v5, [J

    move-object/from16 v23, v3

    move-object/from16 v24, v5

    goto :goto_2

    .line 367
    .end local v6    # "edtsAtom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .end local v9    # "edtsData":Landroid/util/Pair;, "Landroid/util/Pair<[J[J>;"
    :cond_3
    move-object/from16 v23, v3

    move-object/from16 v24, v5

    .end local v3    # "editListDurations":[J
    .end local v5    # "editListMediaTimes":[J
    .local v23, "editListDurations":[J
    .local v24, "editListMediaTimes":[J
    :goto_2
    iget-object v3, v10, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    if-nez v3, :cond_4

    .line 368
    move-wide/from16 v27, v7

    move-object/from16 v30, v10

    move-object/from16 v31, v12

    move-object/from16 v32, v13

    move-object/from16 v33, v14

    goto :goto_3

    .line 369
    :cond_4
    new-instance v25, Landroidx/media3/extractor/mp4/Track;

    .line 370
    invoke-static/range {v18 .. v18}, Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;->access$100(Landroidx/media3/extractor/mp4/AtomParsers$TkhdData;)I

    move-result v4

    iget-object v3, v13, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Long;

    .line 372
    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v16

    iget-object v11, v10, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    iget v9, v10, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->requiredSampleTransformation:I

    iget-object v6, v10, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->trackEncryptionBoxes:[Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    iget v5, v10, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->nalUnitLengthFieldLength:I

    move-object/from16 v3, v25

    move/from16 v26, v5

    move v5, v2

    move-object/from16 v29, v6

    move-wide/from16 v27, v7

    .end local v7    # "movieTimescale":J
    .local v27, "movieTimescale":J
    move-wide/from16 v6, v16

    move/from16 v16, v9

    move-wide/from16 v8, v27

    move-object/from16 v30, v10

    move-object/from16 v17, v11

    .end local v10    # "stsdData":Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    .local v30, "stsdData":Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    move-wide/from16 v10, v21

    move-object/from16 v31, v12

    .end local v12    # "stsd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v31, "stsd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    move-object/from16 v12, v17

    move-object/from16 v32, v13

    .end local v13    # "mdhdData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/String;>;"
    .local v32, "mdhdData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/String;>;"
    move/from16 v13, v16

    move-object/from16 v33, v14

    .end local v14    # "stbl":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .local v33, "stbl":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    move-object/from16 v14, v29

    move/from16 v15, v26

    move-object/from16 v16, v23

    move-object/from16 v17, v24

    invoke-direct/range {v3 .. v17}, Landroidx/media3/extractor/mp4/Track;-><init>(IIJJJLandroidx/media3/common/Format;I[Landroidx/media3/extractor/mp4/TrackEncryptionBox;I[J[J)V

    move-object/from16 v4, v25

    .line 367
    :goto_3
    return-object v4

    .line 344
    .end local v23    # "editListDurations":[J
    .end local v24    # "editListMediaTimes":[J
    .end local v27    # "movieTimescale":J
    .end local v30    # "stsdData":Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    .end local v31    # "stsd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v32    # "mdhdData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/String;>;"
    .end local v33    # "stbl":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .restart local v7    # "movieTimescale":J
    .restart local v12    # "stsd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v13    # "mdhdData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Ljava/lang/String;>;"
    .restart local v14    # "stbl":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    :cond_5
    const-string v3, "Malformed sample table (stbl) missing sample description (stsd)"

    invoke-static {v3, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3
.end method

.method public static parseTraks(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/GaplessInfoHolder;JLandroidx/media3/common/DrmInitData;ZZLcom/google/common/base/Function;)Ljava/util/List;
    .locals 11
    .param p0, "moov"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p1, "gaplessInfoHolder"    # Landroidx/media3/extractor/GaplessInfoHolder;
    .param p2, "duration"    # J
    .param p4, "drmInitData"    # Landroidx/media3/common/DrmInitData;
    .param p5, "ignoreEditLists"    # Z
    .param p6, "isQuickTime"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/mp4/Atom$ContainerAtom;",
            "Landroidx/media3/extractor/GaplessInfoHolder;",
            "J",
            "Landroidx/media3/common/DrmInitData;",
            "ZZ",
            "Lcom/google/common/base/Function<",
            "Landroidx/media3/extractor/mp4/Track;",
            "Landroidx/media3/extractor/mp4/Track;",
            ">;)",
            "Ljava/util/List<",
            "Landroidx/media3/extractor/mp4/TrackSampleTable;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 129
    .local p7, "modifyTrackFunction":Lcom/google/common/base/Function;, "Lcom/google/common/base/Function<Landroidx/media3/extractor/mp4/Track;Landroidx/media3/extractor/mp4/Track;>;"
    move-object v0, p0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 130
    .local v1, "trackSampleTables":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/mp4/TrackSampleTable;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->containerChildren:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_2

    .line 131
    iget-object v3, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->containerChildren:Ljava/util/List;

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 132
    .local v3, "atom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    iget v4, v3, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->type:I

    const v5, 0x7472616b

    if-eq v4, v5, :cond_0

    .line 133
    move-object v7, p1

    move-object/from16 v5, p7

    goto :goto_1

    .line 136
    :cond_0
    nop

    .line 140
    const v4, 0x6d766864

    invoke-virtual {p0, v4}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v4

    invoke-static {v4}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v5, v4

    check-cast v5, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 138
    move-object v4, v3

    move-wide v6, p2

    move-object v8, p4

    move/from16 v9, p5

    move/from16 v10, p6

    invoke-static/range {v4 .. v10}, Landroidx/media3/extractor/mp4/AtomParsers;->parseTrak(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/mp4/Atom$LeafAtom;JLandroidx/media3/common/DrmInitData;ZZ)Landroidx/media3/extractor/mp4/Track;

    move-result-object v4

    .line 137
    move-object/from16 v5, p7

    invoke-interface {v5, v4}, Lcom/google/common/base/Function;->apply(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/extractor/mp4/Track;

    .line 145
    .local v4, "track":Landroidx/media3/extractor/mp4/Track;
    if-nez v4, :cond_1

    .line 146
    move-object v7, p1

    goto :goto_1

    .line 148
    :cond_1
    nop

    .line 151
    const v6, 0x6d646961

    invoke-virtual {v3, v6}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v6

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 152
    const v7, 0x6d696e66

    invoke-virtual {v6, v7}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v6

    .line 150
    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 153
    const v7, 0x7374626c

    invoke-virtual {v6, v7}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v6

    .line 149
    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 154
    .local v6, "stblAtom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    move-object v7, p1

    invoke-static {v4, v6, p1}, Landroidx/media3/extractor/mp4/AtomParsers;->parseStbl(Landroidx/media3/extractor/mp4/Track;Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/GaplessInfoHolder;)Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-result-object v8

    .line 155
    .local v8, "trackSampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 130
    .end local v3    # "atom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .end local v4    # "track":Landroidx/media3/extractor/mp4/Track;
    .end local v6    # "stblAtom":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .end local v8    # "trackSampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_2
    move-object v7, p1

    move-object/from16 v5, p7

    .line 157
    .end local v2    # "i":I
    return-object v1
.end method

.method public static parseUdta(Landroidx/media3/extractor/mp4/Atom$LeafAtom;)Landroidx/media3/common/Metadata;
    .locals 7
    .param p0, "udtaAtom"    # Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 167
    iget-object v0, p0, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 168
    .local v0, "udtaData":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 169
    new-instance v2, Landroidx/media3/common/Metadata;

    const/4 v3, 0x0

    new-array v3, v3, [Landroidx/media3/common/Metadata$Entry;

    invoke-direct {v2, v3}, Landroidx/media3/common/Metadata;-><init>([Landroidx/media3/common/Metadata$Entry;)V

    .line 170
    .local v2, "metadata":Landroidx/media3/common/Metadata;
    :goto_0
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v3

    if-lt v3, v1, :cond_3

    .line 171
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v3

    .line 172
    .local v3, "atomPosition":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 173
    .local v4, "atomSize":I
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    .line 174
    .local v5, "atomType":I
    const v6, 0x6d657461

    if-ne v5, v6, :cond_0

    .line 175
    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 176
    add-int v6, v3, v4

    .line 177
    invoke-static {v0, v6}, Landroidx/media3/extractor/mp4/AtomParsers;->parseUdtaMeta(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/common/Metadata;

    move-result-object v6

    invoke-virtual {v2, v6}, Landroidx/media3/common/Metadata;->copyWithAppendedEntriesFrom(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Metadata;

    move-result-object v2

    goto :goto_1

    .line 178
    :cond_0
    const v6, 0x736d7461

    if-ne v5, v6, :cond_1

    .line 179
    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 180
    add-int v6, v3, v4

    .line 182
    invoke-static {v0, v6}, Landroidx/media3/extractor/mp4/SmtaAtomUtil;->parseSmta(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/common/Metadata;

    move-result-object v6

    .line 181
    invoke-virtual {v2, v6}, Landroidx/media3/common/Metadata;->copyWithAppendedEntriesFrom(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Metadata;

    move-result-object v2

    goto :goto_1

    .line 183
    :cond_1
    const v6, -0x56878686

    if-ne v5, v6, :cond_2

    .line 184
    invoke-static {v0}, Landroidx/media3/extractor/mp4/AtomParsers;->parseXyz(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/Metadata;

    move-result-object v6

    invoke-virtual {v2, v6}, Landroidx/media3/common/Metadata;->copyWithAppendedEntriesFrom(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Metadata;

    move-result-object v2

    .line 186
    :cond_2
    :goto_1
    add-int v6, v3, v4

    invoke-virtual {v0, v6}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 187
    .end local v3    # "atomPosition":I
    .end local v4    # "atomSize":I
    .end local v5    # "atomType":I
    goto :goto_0

    .line 188
    :cond_3
    return-object v2
.end method

.method private static parseUdtaMeta(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/common/Metadata;
    .locals 4
    .param p0, "meta"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "limit"    # I

    .line 781
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 782
    invoke-static {p0}, Landroidx/media3/extractor/mp4/AtomParsers;->maybeSkipRemainingMetaAtomHeaderBytes(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 783
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    if-ge v0, p1, :cond_1

    .line 784
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 785
    .local v0, "atomPosition":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 786
    .local v1, "atomSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 787
    .local v2, "atomType":I
    const v3, 0x696c7374

    if-ne v2, v3, :cond_0

    .line 788
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 789
    add-int v3, v0, v1

    invoke-static {p0, v3}, Landroidx/media3/extractor/mp4/AtomParsers;->parseIlst(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/common/Metadata;

    move-result-object v3

    return-object v3

    .line 791
    :cond_0
    add-int v3, v0, v1

    invoke-virtual {p0, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 792
    .end local v0    # "atomPosition":I
    .end local v1    # "atomSize":I
    .end local v2    # "atomType":I
    goto :goto_0

    .line 793
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method private static parseVideoSampleEntry(Landroidx/media3/common/util/ParsableByteArray;IIIIILandroidx/media3/common/DrmInitData;Landroidx/media3/extractor/mp4/AtomParsers$StsdData;I)V
    .locals 42
    .param p0, "parent"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "atomType"    # I
    .param p2, "position"    # I
    .param p3, "size"    # I
    .param p4, "trackId"    # I
    .param p5, "rotationDegrees"    # I
    .param p6, "drmInitData"    # Landroidx/media3/common/DrmInitData;
    .param p7, "out"    # Landroidx/media3/extractor/mp4/AtomParsers$StsdData;
    .param p8, "entryIndex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1109
    move-object/from16 v0, p0

    move/from16 v1, p2

    move/from16 v2, p3

    move-object/from16 v3, p6

    move-object/from16 v4, p7

    add-int/lit8 v5, v1, 0x8

    add-int/lit8 v5, v5, 0x8

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1111
    const/16 v5, 0x10

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1112
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v5

    .line 1113
    .local v5, "width":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v6

    .line 1114
    .local v6, "height":I
    const/4 v7, 0x0

    .line 1115
    .local v7, "pixelWidthHeightRatioFromPasp":Z
    const/high16 v8, 0x3f800000    # 1.0f

    .line 1117
    .local v8, "pixelWidthHeightRatio":F
    const/16 v9, 0x8

    .line 1118
    .local v9, "bitdepthLuma":I
    const/16 v10, 0x8

    .line 1119
    .local v10, "bitdepthChroma":I
    const/16 v11, 0x32

    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1121
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v11

    .line 1122
    .local v11, "childPosition":I
    const v12, 0x656e6376

    move/from16 v14, p1

    if-ne v14, v12, :cond_2

    .line 1124
    nop

    .line 1125
    invoke-static {v0, v1, v2}, Landroidx/media3/extractor/mp4/AtomParsers;->parseSampleEntryEncryptionData(Landroidx/media3/common/util/ParsableByteArray;II)Landroid/util/Pair;

    move-result-object v12

    .line 1126
    .local v12, "sampleEntryEncryptionData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    if-eqz v12, :cond_1

    .line 1127
    iget-object v15, v12, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v15, Ljava/lang/Integer;

    invoke-virtual {v15}, Ljava/lang/Integer;->intValue()I

    move-result v14

    .line 1129
    .end local p1    # "atomType":I
    .local v14, "atomType":I
    if-nez v3, :cond_0

    .line 1130
    const/4 v15, 0x0

    goto :goto_0

    .line 1131
    :cond_0
    iget-object v15, v12, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v15, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    iget-object v15, v15, Landroidx/media3/extractor/mp4/TrackEncryptionBox;->schemeType:Ljava/lang/String;

    invoke-virtual {v3, v15}, Landroidx/media3/common/DrmInitData;->copyWithSchemeType(Ljava/lang/String;)Landroidx/media3/common/DrmInitData;

    move-result-object v15

    :goto_0
    move-object v3, v15

    .line 1132
    .end local p6    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .local v3, "drmInitData":Landroidx/media3/common/DrmInitData;
    iget-object v15, v4, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->trackEncryptionBoxes:[Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    iget-object v13, v12, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v13, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    aput-object v13, v15, p8

    .line 1134
    :cond_1
    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1141
    .end local v12    # "sampleEntryEncryptionData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/TrackEncryptionBox;>;"
    :cond_2
    const/4 v12, 0x0

    .line 1142
    .local v12, "mimeType":Ljava/lang/String;
    const v13, 0x6d317620

    if-ne v14, v13, :cond_3

    .line 1143
    const-string/jumbo v12, "video/mpeg"

    goto :goto_1

    .line 1144
    :cond_3
    const v13, 0x48323633

    if-ne v14, v13, :cond_4

    .line 1145
    const-string/jumbo v12, "video/3gpp"

    .line 1148
    :cond_4
    :goto_1
    const/4 v13, 0x0

    .line 1149
    .local v13, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    const/4 v15, 0x0

    .line 1150
    .local v15, "codecs":Ljava/lang/String;
    const/16 v17, 0x0

    .line 1151
    .local v17, "projectionData":[B
    const/16 v18, -0x1

    .line 1152
    .local v18, "stereoMode":I
    const/16 v19, 0x0

    .line 1155
    .local v19, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    const/16 v20, -0x1

    .line 1156
    .local v20, "colorSpace":I
    const/16 v21, -0x1

    .line 1157
    .local v21, "colorRange":I
    const/16 v22, -0x1

    .line 1159
    .local v22, "colorTransfer":I
    const/16 v23, 0x0

    move/from16 v24, v21

    move-object/from16 v21, v13

    move/from16 v13, v22

    move/from16 v39, v20

    move-object/from16 v20, v3

    move/from16 v3, v39

    move/from16 v40, v18

    move/from16 v18, v9

    move/from16 v9, v40

    move-object/from16 v41, v17

    move/from16 v17, v10

    move-object/from16 v10, v41

    .line 1161
    .end local v22    # "colorTransfer":I
    .local v3, "colorSpace":I
    .local v9, "stereoMode":I
    .local v10, "projectionData":[B
    .local v13, "colorTransfer":I
    .local v17, "bitdepthChroma":I
    .local v18, "bitdepthLuma":I
    .local v20, "drmInitData":Landroidx/media3/common/DrmInitData;
    .local v21, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v23, "hdrStaticInfo":Ljava/nio/ByteBuffer;
    .local v24, "colorRange":I
    :goto_2
    move/from16 v22, v9

    .end local v9    # "stereoMode":I
    .local v22, "stereoMode":I
    sub-int v9, v11, v1

    if-ge v9, v2, :cond_2b

    .line 1162
    invoke-virtual {v0, v11}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1163
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v9

    .line 1164
    .local v9, "childStartPosition":I
    move-object/from16 p1, v10

    .end local v10    # "projectionData":[B
    .local p1, "projectionData":[B
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    .line 1165
    .local v10, "childAtomSize":I
    if-nez v10, :cond_5

    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v25

    move/from16 p6, v8

    .end local v8    # "pixelWidthHeightRatio":F
    .local p6, "pixelWidthHeightRatio":F
    sub-int v8, v25, v1

    if-ne v8, v2, :cond_6

    .line 1167
    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v28, v7

    move/from16 v33, v11

    move v5, v13

    move/from16 v29, v14

    move-object/from16 v32, v15

    const/4 v2, 0x0

    goto/16 :goto_19

    .line 1165
    .end local p6    # "pixelWidthHeightRatio":F
    .restart local v8    # "pixelWidthHeightRatio":F
    :cond_5
    move/from16 p6, v8

    .line 1169
    .end local v8    # "pixelWidthHeightRatio":F
    .restart local p6    # "pixelWidthHeightRatio":F
    :cond_6
    if-lez v10, :cond_7

    const/4 v8, 0x1

    goto :goto_3

    :cond_7
    const/4 v8, 0x0

    :goto_3
    const-string v1, "childAtomSize must be positive"

    invoke-static {v8, v1}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1170
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1171
    .local v1, "childAtomType":I
    const v8, 0x61766343

    if-ne v1, v8, :cond_a

    .line 1172
    if-nez v12, :cond_8

    const/4 v8, 0x1

    goto :goto_4

    :cond_8
    const/4 v8, 0x0

    :goto_4
    const/4 v2, 0x0

    invoke-static {v8, v2}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1173
    const-string/jumbo v2, "video/avc"

    .line 1174
    .end local v12    # "mimeType":Ljava/lang/String;
    .local v2, "mimeType":Ljava/lang/String;
    add-int/lit8 v8, v9, 0x8

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1175
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/AvcConfig;->parse(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/AvcConfig;

    move-result-object v8

    .line 1176
    .local v8, "avcConfig":Landroidx/media3/extractor/AvcConfig;
    iget-object v12, v8, Landroidx/media3/extractor/AvcConfig;->initializationData:Ljava/util/List;

    .line 1177
    .end local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v12, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    move-object/from16 v25, v2

    .end local v2    # "mimeType":Ljava/lang/String;
    .local v25, "mimeType":Ljava/lang/String;
    iget v2, v8, Landroidx/media3/extractor/AvcConfig;->nalUnitLengthFieldLength:I

    iput v2, v4, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->nalUnitLengthFieldLength:I

    .line 1178
    if-nez v7, :cond_9

    .line 1179
    iget v2, v8, Landroidx/media3/extractor/AvcConfig;->pixelWidthHeightRatio:F

    .end local p6    # "pixelWidthHeightRatio":F
    .local v2, "pixelWidthHeightRatio":F
    goto :goto_5

    .line 1178
    .end local v2    # "pixelWidthHeightRatio":F
    .restart local p6    # "pixelWidthHeightRatio":F
    :cond_9
    move/from16 v2, p6

    .line 1181
    .end local p6    # "pixelWidthHeightRatio":F
    .restart local v2    # "pixelWidthHeightRatio":F
    :goto_5
    iget-object v15, v8, Landroidx/media3/extractor/AvcConfig;->codecs:Ljava/lang/String;

    .line 1182
    iget v3, v8, Landroidx/media3/extractor/AvcConfig;->colorSpace:I

    .line 1183
    move/from16 p6, v2

    .end local v2    # "pixelWidthHeightRatio":F
    .restart local p6    # "pixelWidthHeightRatio":F
    iget v2, v8, Landroidx/media3/extractor/AvcConfig;->colorRange:I

    .line 1184
    .end local v24    # "colorRange":I
    .local v2, "colorRange":I
    iget v13, v8, Landroidx/media3/extractor/AvcConfig;->colorTransfer:I

    .line 1185
    move/from16 v21, v2

    .end local v2    # "colorRange":I
    .local v21, "colorRange":I
    iget v2, v8, Landroidx/media3/extractor/AvcConfig;->bitdepthLuma:I

    .line 1186
    .end local v18    # "bitdepthLuma":I
    .local v2, "bitdepthLuma":I
    iget v8, v8, Landroidx/media3/extractor/AvcConfig;->bitdepthChroma:I

    .line 1187
    .end local v17    # "bitdepthChroma":I
    .local v8, "bitdepthChroma":I
    move-object/from16 v4, p1

    move/from16 v18, v2

    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v17, v8

    move/from16 v33, v11

    move/from16 v29, v14

    move/from16 v24, v21

    const/4 v2, 0x0

    move/from16 v8, p6

    move-object/from16 v21, v12

    move-object/from16 v12, v25

    goto/16 :goto_18

    .end local v2    # "bitdepthLuma":I
    .end local v8    # "bitdepthChroma":I
    .end local v25    # "mimeType":Ljava/lang/String;
    .local v12, "mimeType":Ljava/lang/String;
    .restart local v17    # "bitdepthChroma":I
    .restart local v18    # "bitdepthLuma":I
    .local v21, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v24    # "colorRange":I
    :cond_a
    const v2, 0x68766343

    if-ne v1, v2, :cond_d

    .line 1188
    if-nez v12, :cond_b

    const/4 v8, 0x1

    goto :goto_6

    :cond_b
    const/4 v8, 0x0

    :goto_6
    const/4 v2, 0x0

    invoke-static {v8, v2}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1189
    const-string/jumbo v2, "video/hevc"

    .line 1190
    .end local v12    # "mimeType":Ljava/lang/String;
    .local v2, "mimeType":Ljava/lang/String;
    add-int/lit8 v8, v9, 0x8

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1191
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/HevcConfig;->parse(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/HevcConfig;

    move-result-object v8

    .line 1192
    .local v8, "hevcConfig":Landroidx/media3/extractor/HevcConfig;
    iget-object v12, v8, Landroidx/media3/extractor/HevcConfig;->initializationData:Ljava/util/List;

    .line 1193
    .end local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v12, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    move-object/from16 v25, v2

    .end local v2    # "mimeType":Ljava/lang/String;
    .restart local v25    # "mimeType":Ljava/lang/String;
    iget v2, v8, Landroidx/media3/extractor/HevcConfig;->nalUnitLengthFieldLength:I

    iput v2, v4, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->nalUnitLengthFieldLength:I

    .line 1194
    if-nez v7, :cond_c

    .line 1195
    iget v2, v8, Landroidx/media3/extractor/HevcConfig;->pixelWidthHeightRatio:F

    .end local p6    # "pixelWidthHeightRatio":F
    .local v2, "pixelWidthHeightRatio":F
    goto :goto_7

    .line 1194
    .end local v2    # "pixelWidthHeightRatio":F
    .restart local p6    # "pixelWidthHeightRatio":F
    :cond_c
    move/from16 v2, p6

    .line 1197
    .end local p6    # "pixelWidthHeightRatio":F
    .restart local v2    # "pixelWidthHeightRatio":F
    :goto_7
    iget-object v15, v8, Landroidx/media3/extractor/HevcConfig;->codecs:Ljava/lang/String;

    .line 1198
    iget v3, v8, Landroidx/media3/extractor/HevcConfig;->colorSpace:I

    .line 1199
    move/from16 p6, v2

    .end local v2    # "pixelWidthHeightRatio":F
    .restart local p6    # "pixelWidthHeightRatio":F
    iget v2, v8, Landroidx/media3/extractor/HevcConfig;->colorRange:I

    .line 1200
    .end local v24    # "colorRange":I
    .local v2, "colorRange":I
    iget v13, v8, Landroidx/media3/extractor/HevcConfig;->colorTransfer:I

    .line 1201
    move/from16 v21, v2

    .end local v2    # "colorRange":I
    .local v21, "colorRange":I
    iget v2, v8, Landroidx/media3/extractor/HevcConfig;->bitdepthLuma:I

    .line 1202
    .end local v18    # "bitdepthLuma":I
    .local v2, "bitdepthLuma":I
    iget v8, v8, Landroidx/media3/extractor/HevcConfig;->bitdepthChroma:I

    .line 1203
    .end local v17    # "bitdepthChroma":I
    .local v8, "bitdepthChroma":I
    move-object/from16 v4, p1

    move/from16 v18, v2

    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v17, v8

    move/from16 v33, v11

    move/from16 v29, v14

    move/from16 v24, v21

    const/4 v2, 0x0

    move/from16 v8, p6

    move-object/from16 v21, v12

    move-object/from16 v12, v25

    goto/16 :goto_18

    .end local v2    # "bitdepthLuma":I
    .end local v8    # "bitdepthChroma":I
    .end local v25    # "mimeType":Ljava/lang/String;
    .local v12, "mimeType":Ljava/lang/String;
    .restart local v17    # "bitdepthChroma":I
    .restart local v18    # "bitdepthLuma":I
    .local v21, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v24    # "colorRange":I
    :cond_d
    const v2, 0x64766343

    if-eq v1, v2, :cond_29

    const v2, 0x64767643

    if-ne v1, v2, :cond_e

    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v28, v7

    move/from16 v33, v11

    move v5, v13

    move/from16 v29, v14

    move-object/from16 v32, v15

    const/4 v2, 0x0

    goto/16 :goto_16

    .line 1209
    :cond_e
    const v2, 0x76706343

    if-ne v1, v2, :cond_13

    .line 1210
    if-nez v12, :cond_f

    const/4 v2, 0x1

    goto :goto_8

    :cond_f
    const/4 v2, 0x0

    :goto_8
    const/4 v8, 0x0

    invoke-static {v2, v8}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1211
    const v2, 0x76703038

    if-ne v14, v2, :cond_10

    const-string/jumbo v2, "video/x-vnd.on2.vp8"

    goto :goto_9

    :cond_10
    const-string/jumbo v2, "video/x-vnd.on2.vp9"

    .line 1212
    .end local v12    # "mimeType":Ljava/lang/String;
    .local v2, "mimeType":Ljava/lang/String;
    :goto_9
    add-int/lit8 v8, v9, 0xc

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1214
    const/4 v8, 0x2

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1215
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v8

    .line 1216
    .local v8, "byte3":I
    shr-int/lit8 v12, v8, 0x4

    .line 1217
    .end local v18    # "bitdepthLuma":I
    .local v12, "bitdepthLuma":I
    move/from16 v17, v12

    .line 1218
    and-int/lit8 v18, v8, 0x1

    if-eqz v18, :cond_11

    const/16 v25, 0x1

    goto :goto_a

    :cond_11
    const/16 v25, 0x0

    :goto_a
    move/from16 v18, v25

    .line 1219
    .local v18, "fullRangeFlag":Z
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v25

    .line 1220
    .local v25, "colorPrimaries":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v28

    .line 1221
    .local v28, "transferCharacteristics":I
    invoke-static/range {v25 .. v25}, Landroidx/media3/common/ColorInfo;->isoColorPrimariesToColorSpace(I)I

    move-result v3

    .line 1222
    if-eqz v18, :cond_12

    const/16 v26, 0x1

    goto :goto_b

    :cond_12
    const/16 v26, 0x2

    :goto_b
    move/from16 v24, v26

    .line 1223
    nop

    .line 1224
    invoke-static/range {v28 .. v28}, Landroidx/media3/common/ColorInfo;->isoTransferCharacteristicsToColorTransfer(I)I

    move-result v8

    .line 1225
    .end local v13    # "colorTransfer":I
    .end local v18    # "fullRangeFlag":Z
    .end local v25    # "colorPrimaries":I
    .end local v28    # "transferCharacteristics":I
    .local v8, "colorTransfer":I
    move-object/from16 v4, p1

    move/from16 v31, v5

    move/from16 v30, v6

    move v13, v8

    move/from16 v33, v11

    move/from16 v18, v12

    move/from16 v29, v14

    move/from16 v8, p6

    move-object v12, v2

    const/4 v2, 0x0

    goto/16 :goto_18

    .end local v2    # "mimeType":Ljava/lang/String;
    .end local v8    # "colorTransfer":I
    .local v12, "mimeType":Ljava/lang/String;
    .restart local v13    # "colorTransfer":I
    .local v18, "bitdepthLuma":I
    :cond_13
    const v2, 0x61763143

    if-ne v1, v2, :cond_14

    .line 1226
    const-string/jumbo v2, "video/av01"

    .line 1227
    .end local v12    # "mimeType":Ljava/lang/String;
    .restart local v2    # "mimeType":Ljava/lang/String;
    add-int/lit8 v8, v9, 0x8

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1228
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/mp4/AtomParsers;->parseAv1c(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/ColorInfo;

    move-result-object v8

    .line 1230
    .local v8, "colorInfo":Landroidx/media3/common/ColorInfo;
    iget v12, v8, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    .line 1231
    .end local v18    # "bitdepthLuma":I
    .local v12, "bitdepthLuma":I
    move-object/from16 v25, v2

    .end local v2    # "mimeType":Ljava/lang/String;
    .local v25, "mimeType":Ljava/lang/String;
    iget v2, v8, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    .line 1232
    .end local v17    # "bitdepthChroma":I
    .local v2, "bitdepthChroma":I
    iget v3, v8, Landroidx/media3/common/ColorInfo;->colorSpace:I

    .line 1233
    move/from16 v17, v2

    .end local v2    # "bitdepthChroma":I
    .restart local v17    # "bitdepthChroma":I
    iget v2, v8, Landroidx/media3/common/ColorInfo;->colorRange:I

    .line 1234
    .end local v24    # "colorRange":I
    .local v2, "colorRange":I
    iget v8, v8, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    .line 1235
    .end local v13    # "colorTransfer":I
    .local v8, "colorTransfer":I
    move-object/from16 v4, p1

    move/from16 v24, v2

    move/from16 v31, v5

    move/from16 v30, v6

    move v13, v8

    move/from16 v33, v11

    move/from16 v18, v12

    move/from16 v29, v14

    move-object/from16 v12, v25

    const/4 v2, 0x0

    move/from16 v8, p6

    goto/16 :goto_18

    .end local v2    # "colorRange":I
    .end local v8    # "colorTransfer":I
    .end local v25    # "mimeType":Ljava/lang/String;
    .local v12, "mimeType":Ljava/lang/String;
    .restart local v13    # "colorTransfer":I
    .restart local v18    # "bitdepthLuma":I
    .restart local v24    # "colorRange":I
    :cond_14
    const v2, 0x636c6c69

    if-ne v1, v2, :cond_16

    .line 1236
    if-nez v23, :cond_15

    .line 1237
    invoke-static {}, Landroidx/media3/extractor/mp4/AtomParsers;->allocateHdrStaticInfo()Ljava/nio/ByteBuffer;

    move-result-object v23

    move-object/from16 v2, v23

    goto :goto_c

    .line 1236
    :cond_15
    move-object/from16 v2, v23

    .line 1241
    .end local v23    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    .local v2, "hdrStaticInfo":Ljava/nio/ByteBuffer;
    :goto_c
    const/16 v8, 0x15

    invoke-virtual {v2, v8}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 1242
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v8

    invoke-virtual {v2, v8}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1243
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v8

    invoke-virtual {v2, v8}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    move-object/from16 v4, p1

    move/from16 v8, p6

    move-object/from16 v23, v2

    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v33, v11

    move/from16 v29, v14

    const/4 v2, 0x0

    goto/16 :goto_18

    .line 1244
    .end local v2    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    .restart local v23    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    :cond_16
    const v2, 0x6d646376

    if-ne v1, v2, :cond_18

    .line 1245
    if-nez v23, :cond_17

    .line 1246
    invoke-static {}, Landroidx/media3/extractor/mp4/AtomParsers;->allocateHdrStaticInfo()Ljava/nio/ByteBuffer;

    move-result-object v23

    move-object/from16 v2, v23

    goto :goto_d

    .line 1245
    :cond_17
    move-object/from16 v2, v23

    .line 1250
    .end local v23    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    .restart local v2    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    :goto_d
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v8

    .line 1251
    .local v8, "displayPrimariesGX":S
    move/from16 v28, v7

    .end local v7    # "pixelWidthHeightRatioFromPasp":Z
    .local v28, "pixelWidthHeightRatioFromPasp":Z
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v7

    .line 1252
    .local v7, "displayPrimariesGY":S
    move/from16 v29, v14

    .end local v14    # "atomType":I
    .local v29, "atomType":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v14

    .line 1253
    .local v14, "displayPrimariesBX":S
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v4

    .line 1254
    .local v4, "displayPrimariesBY":S
    move/from16 v30, v6

    .end local v6    # "height":I
    .local v30, "height":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v6

    .line 1255
    .local v6, "displayPrimariesRX":S
    move/from16 v31, v5

    .end local v5    # "width":I
    .local v31, "width":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v5

    .line 1256
    .local v5, "displayPrimariesRY":S
    move-object/from16 v32, v15

    .end local v15    # "codecs":Ljava/lang/String;
    .local v32, "codecs":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v15

    .line 1257
    .local v15, "whitePointX":S
    move/from16 v33, v11

    .end local v11    # "childPosition":I
    .local v33, "childPosition":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v11

    .line 1258
    .local v11, "whitePointY":S
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v34

    .line 1259
    .local v34, "maxDisplayMasteringLuminance":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v36

    .line 1261
    .local v36, "minDisplayMasteringLuminance":J
    move/from16 v38, v13

    const/4 v13, 0x1

    .end local v13    # "colorTransfer":I
    .local v38, "colorTransfer":I
    invoke-virtual {v2, v13}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 1262
    invoke-virtual {v2, v6}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1263
    invoke-virtual {v2, v5}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1264
    invoke-virtual {v2, v8}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1265
    invoke-virtual {v2, v7}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1266
    invoke-virtual {v2, v14}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1267
    invoke-virtual {v2, v4}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1268
    invoke-virtual {v2, v15}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1269
    invoke-virtual {v2, v11}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1270
    const-wide/16 v25, 0x2710

    move/from16 v23, v4

    move/from16 v27, v5

    .end local v4    # "displayPrimariesBY":S
    .end local v5    # "displayPrimariesRY":S
    .local v23, "displayPrimariesBY":S
    .local v27, "displayPrimariesRY":S
    div-long v4, v34, v25

    long-to-int v4, v4

    int-to-short v4, v4

    invoke-virtual {v2, v4}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1271
    div-long v4, v36, v25

    long-to-int v4, v4

    int-to-short v4, v4

    invoke-virtual {v2, v4}, Ljava/nio/ByteBuffer;->putShort(S)Ljava/nio/ByteBuffer;

    .line 1272
    .end local v6    # "displayPrimariesRX":S
    .end local v7    # "displayPrimariesGY":S
    .end local v8    # "displayPrimariesGX":S
    .end local v11    # "whitePointY":S
    .end local v14    # "displayPrimariesBX":S
    .end local v15    # "whitePointX":S
    .end local v23    # "displayPrimariesBY":S
    .end local v27    # "displayPrimariesRY":S
    .end local v34    # "maxDisplayMasteringLuminance":J
    .end local v36    # "minDisplayMasteringLuminance":J
    move-object/from16 v4, p1

    move/from16 v8, p6

    move-object/from16 v23, v2

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v13, v38

    const/4 v2, 0x0

    goto/16 :goto_18

    .end local v2    # "hdrStaticInfo":Ljava/nio/ByteBuffer;
    .end local v28    # "pixelWidthHeightRatioFromPasp":Z
    .end local v29    # "atomType":I
    .end local v30    # "height":I
    .end local v31    # "width":I
    .end local v32    # "codecs":Ljava/lang/String;
    .end local v33    # "childPosition":I
    .end local v38    # "colorTransfer":I
    .local v5, "width":I
    .local v6, "height":I
    .local v7, "pixelWidthHeightRatioFromPasp":Z
    .local v11, "childPosition":I
    .restart local v13    # "colorTransfer":I
    .local v14, "atomType":I
    .local v15, "codecs":Ljava/lang/String;
    .local v23, "hdrStaticInfo":Ljava/nio/ByteBuffer;
    :cond_18
    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v28, v7

    move/from16 v33, v11

    move/from16 v38, v13

    move/from16 v29, v14

    move-object/from16 v32, v15

    const/4 v13, 0x1

    .end local v5    # "width":I
    .end local v6    # "height":I
    .end local v7    # "pixelWidthHeightRatioFromPasp":Z
    .end local v11    # "childPosition":I
    .end local v13    # "colorTransfer":I
    .end local v14    # "atomType":I
    .end local v15    # "codecs":Ljava/lang/String;
    .restart local v28    # "pixelWidthHeightRatioFromPasp":Z
    .restart local v29    # "atomType":I
    .restart local v30    # "height":I
    .restart local v31    # "width":I
    .restart local v32    # "codecs":Ljava/lang/String;
    .restart local v33    # "childPosition":I
    .restart local v38    # "colorTransfer":I
    const v2, 0x64323633

    if-ne v1, v2, :cond_1a

    .line 1273
    if-nez v12, :cond_19

    move v8, v13

    goto :goto_e

    :cond_19
    const/4 v8, 0x0

    :goto_e
    const/4 v2, 0x0

    invoke-static {v8, v2}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1274
    const-string/jumbo v2, "video/3gpp"

    move-object/from16 v4, p1

    move/from16 v8, p6

    move-object v12, v2

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v13, v38

    const/4 v2, 0x0

    .end local v12    # "mimeType":Ljava/lang/String;
    .local v2, "mimeType":Ljava/lang/String;
    goto/16 :goto_18

    .line 1275
    .end local v2    # "mimeType":Ljava/lang/String;
    .restart local v12    # "mimeType":Ljava/lang/String;
    :cond_1a
    const v2, 0x65736473

    if-ne v1, v2, :cond_1d

    .line 1276
    if-nez v12, :cond_1b

    move v8, v13

    goto :goto_f

    :cond_1b
    const/4 v8, 0x0

    :goto_f
    const/4 v2, 0x0

    invoke-static {v8, v2}, Landroidx/media3/extractor/ExtractorUtil;->checkContainerInput(ZLjava/lang/String;)V

    .line 1277
    invoke-static {v0, v9}, Landroidx/media3/extractor/mp4/AtomParsers;->parseEsdsFromParent(Landroidx/media3/common/util/ParsableByteArray;I)Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    move-result-object v4

    .line 1278
    .end local v19    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .local v4, "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    invoke-static {v4}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$300(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)Ljava/lang/String;

    move-result-object v5

    .line 1279
    .end local v12    # "mimeType":Ljava/lang/String;
    .local v5, "mimeType":Ljava/lang/String;
    invoke-static {v4}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$400(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)[B

    move-result-object v6

    .line 1280
    .local v6, "initializationDataBytes":[B
    if-eqz v6, :cond_1c

    .line 1281
    invoke-static {v6}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v13

    .end local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v13, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    goto :goto_10

    .line 1280
    .end local v13    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    :cond_1c
    move-object/from16 v13, v21

    .line 1283
    .end local v6    # "initializationDataBytes":[B
    .end local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v13    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    :goto_10
    move/from16 v8, p6

    move-object/from16 v19, v4

    move-object v12, v5

    move-object/from16 v21, v13

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v13, v38

    move-object/from16 v4, p1

    goto/16 :goto_18

    .end local v4    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .end local v5    # "mimeType":Ljava/lang/String;
    .end local v13    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .restart local v12    # "mimeType":Ljava/lang/String;
    .restart local v19    # "esdsData":Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
    .restart local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    :cond_1d
    const/4 v2, 0x0

    const v4, 0x70617370

    if-ne v1, v4, :cond_1e

    .line 1284
    invoke-static {v0, v9}, Landroidx/media3/extractor/mp4/AtomParsers;->parsePaspFromParent(Landroidx/media3/common/util/ParsableByteArray;I)F

    move-result v4

    .line 1285
    .end local p6    # "pixelWidthHeightRatio":F
    .local v4, "pixelWidthHeightRatio":F
    const/4 v5, 0x1

    move v8, v4

    move v7, v5

    move-object/from16 v15, v32

    move/from16 v13, v38

    move-object/from16 v4, p1

    .end local v28    # "pixelWidthHeightRatioFromPasp":Z
    .local v5, "pixelWidthHeightRatioFromPasp":Z
    goto/16 :goto_18

    .line 1286
    .end local v4    # "pixelWidthHeightRatio":F
    .end local v5    # "pixelWidthHeightRatioFromPasp":Z
    .restart local v28    # "pixelWidthHeightRatioFromPasp":Z
    .restart local p6    # "pixelWidthHeightRatio":F
    :cond_1e
    const v4, 0x73763364

    if-ne v1, v4, :cond_1f

    .line 1287
    invoke-static {v0, v9, v10}, Landroidx/media3/extractor/mp4/AtomParsers;->parseProjFromParent(Landroidx/media3/common/util/ParsableByteArray;II)[B

    move-result-object v4

    move/from16 v8, p6

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v13, v38

    .end local p1    # "projectionData":[B
    .local v4, "projectionData":[B
    goto/16 :goto_18

    .line 1288
    .end local v4    # "projectionData":[B
    .restart local p1    # "projectionData":[B
    :cond_1f
    const v4, 0x73743364

    if-ne v1, v4, :cond_21

    .line 1289
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v4

    .line 1290
    .local v4, "version":I
    const/4 v5, 0x3

    invoke-virtual {v0, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1291
    if-nez v4, :cond_20

    .line 1292
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v5

    .line 1293
    .local v5, "layout":I
    packed-switch v5, :pswitch_data_0

    goto :goto_11

    .line 1304
    :pswitch_0
    const/4 v6, 0x3

    .line 1305
    .end local v22    # "stereoMode":I
    .local v6, "stereoMode":I
    goto :goto_12

    .line 1301
    .end local v6    # "stereoMode":I
    .restart local v22    # "stereoMode":I
    :pswitch_1
    const/4 v6, 0x2

    .line 1302
    .end local v22    # "stereoMode":I
    .restart local v6    # "stereoMode":I
    goto :goto_12

    .line 1298
    .end local v6    # "stereoMode":I
    .restart local v22    # "stereoMode":I
    :pswitch_2
    const/4 v6, 0x1

    .line 1299
    .end local v22    # "stereoMode":I
    .restart local v6    # "stereoMode":I
    goto :goto_12

    .line 1295
    .end local v6    # "stereoMode":I
    .restart local v22    # "stereoMode":I
    :pswitch_3
    const/4 v6, 0x0

    .line 1296
    .end local v22    # "stereoMode":I
    .restart local v6    # "stereoMode":I
    goto :goto_12

    .line 1310
    .end local v4    # "version":I
    .end local v5    # "layout":I
    .end local v6    # "stereoMode":I
    .restart local v22    # "stereoMode":I
    :cond_20
    :goto_11
    move/from16 v6, v22

    .end local v22    # "stereoMode":I
    .restart local v6    # "stereoMode":I
    :goto_12
    move-object/from16 v4, p1

    move/from16 v8, p6

    move/from16 v22, v6

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v13, v38

    goto/16 :goto_18

    .end local v6    # "stereoMode":I
    .restart local v22    # "stereoMode":I
    :cond_21
    const v4, 0x636f6c72

    if-ne v1, v4, :cond_27

    .line 1317
    const/4 v4, -0x1

    if-ne v3, v4, :cond_26

    move/from16 v5, v38

    .end local v38    # "colorTransfer":I
    .local v5, "colorTransfer":I
    if-ne v5, v4, :cond_28

    .line 1318
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 1319
    .local v4, "colorType":I
    const v6, 0x6e636c78

    if-eq v4, v6, :cond_23

    const v6, 0x6e636c63

    if-ne v4, v6, :cond_22

    goto :goto_13

    .line 1337
    :cond_22
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unsupported color type: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v4}, Landroidx/media3/extractor/mp4/Atom;->getAtomTypeString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "AtomParsers"

    invoke-static {v7, v6}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_15

    .line 1322
    :cond_23
    :goto_13
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v6

    .line 1323
    .local v6, "colorPrimaries":I
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v7

    .line 1324
    .local v7, "transferCharacteristics":I
    const/4 v8, 0x2

    invoke-virtual {v0, v8}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1330
    const/16 v11, 0x13

    if-ne v10, v11, :cond_24

    .line 1331
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v11

    and-int/lit16 v11, v11, 0x80

    if-eqz v11, :cond_24

    move/from16 v25, v13

    goto :goto_14

    :cond_24
    const/16 v25, 0x0

    :goto_14
    move/from16 v11, v25

    .line 1332
    .local v11, "fullRangeFlag":Z
    invoke-static {v6}, Landroidx/media3/common/ColorInfo;->isoColorPrimariesToColorSpace(I)I

    move-result v3

    .line 1333
    if-eqz v11, :cond_25

    move v8, v13

    .line 1334
    .end local v24    # "colorRange":I
    .local v8, "colorRange":I
    :cond_25
    nop

    .line 1335
    invoke-static {v7}, Landroidx/media3/common/ColorInfo;->isoTransferCharacteristicsToColorTransfer(I)I

    move-result v5

    .line 1336
    .end local v6    # "colorPrimaries":I
    .end local v7    # "transferCharacteristics":I
    .end local v11    # "fullRangeFlag":Z
    move-object/from16 v4, p1

    move v13, v5

    move/from16 v24, v8

    move/from16 v7, v28

    move-object/from16 v15, v32

    move/from16 v8, p6

    goto :goto_18

    .line 1317
    .end local v4    # "colorType":I
    .end local v5    # "colorTransfer":I
    .end local v8    # "colorRange":I
    .restart local v24    # "colorRange":I
    .restart local v38    # "colorTransfer":I
    :cond_26
    move/from16 v5, v38

    .end local v38    # "colorTransfer":I
    .restart local v5    # "colorTransfer":I
    goto :goto_15

    .line 1310
    .end local v5    # "colorTransfer":I
    .restart local v38    # "colorTransfer":I
    :cond_27
    move/from16 v5, v38

    .line 1341
    .end local v38    # "colorTransfer":I
    .restart local v5    # "colorTransfer":I
    :cond_28
    :goto_15
    move-object/from16 v4, p1

    move/from16 v8, p6

    move v13, v5

    move/from16 v7, v28

    move-object/from16 v15, v32

    goto :goto_18

    .line 1203
    .end local v28    # "pixelWidthHeightRatioFromPasp":Z
    .end local v29    # "atomType":I
    .end local v30    # "height":I
    .end local v31    # "width":I
    .end local v32    # "codecs":Ljava/lang/String;
    .end local v33    # "childPosition":I
    .local v5, "width":I
    .local v6, "height":I
    .local v7, "pixelWidthHeightRatioFromPasp":Z
    .local v11, "childPosition":I
    .local v13, "colorTransfer":I
    .restart local v14    # "atomType":I
    .restart local v15    # "codecs":Ljava/lang/String;
    :cond_29
    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v28, v7

    move/from16 v33, v11

    move v5, v13

    move/from16 v29, v14

    move-object/from16 v32, v15

    const/4 v2, 0x0

    .line 1204
    .end local v6    # "height":I
    .end local v7    # "pixelWidthHeightRatioFromPasp":Z
    .end local v11    # "childPosition":I
    .end local v13    # "colorTransfer":I
    .end local v14    # "atomType":I
    .end local v15    # "codecs":Ljava/lang/String;
    .local v5, "colorTransfer":I
    .restart local v28    # "pixelWidthHeightRatioFromPasp":Z
    .restart local v29    # "atomType":I
    .restart local v30    # "height":I
    .restart local v31    # "width":I
    .restart local v32    # "codecs":Ljava/lang/String;
    .restart local v33    # "childPosition":I
    :goto_16
    invoke-static/range {p0 .. p0}, Landroidx/media3/extractor/DolbyVisionConfig;->parse(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/DolbyVisionConfig;

    move-result-object v4

    .line 1205
    .local v4, "dolbyVisionConfig":Landroidx/media3/extractor/DolbyVisionConfig;
    if-eqz v4, :cond_2a

    .line 1206
    iget-object v15, v4, Landroidx/media3/extractor/DolbyVisionConfig;->codecs:Ljava/lang/String;

    .line 1207
    .end local v32    # "codecs":Ljava/lang/String;
    .restart local v15    # "codecs":Ljava/lang/String;
    const-string/jumbo v12, "video/dolby-vision"

    goto :goto_17

    .line 1205
    .end local v15    # "codecs":Ljava/lang/String;
    .restart local v32    # "codecs":Ljava/lang/String;
    :cond_2a
    move-object/from16 v15, v32

    .line 1209
    .end local v4    # "dolbyVisionConfig":Landroidx/media3/extractor/DolbyVisionConfig;
    .end local v32    # "codecs":Ljava/lang/String;
    .restart local v15    # "codecs":Ljava/lang/String;
    :goto_17
    move-object/from16 v4, p1

    move/from16 v8, p6

    move v13, v5

    move/from16 v7, v28

    .line 1341
    .end local v5    # "colorTransfer":I
    .end local v28    # "pixelWidthHeightRatioFromPasp":Z
    .end local p1    # "projectionData":[B
    .end local p6    # "pixelWidthHeightRatio":F
    .local v4, "projectionData":[B
    .restart local v7    # "pixelWidthHeightRatioFromPasp":Z
    .local v8, "pixelWidthHeightRatio":F
    .restart local v13    # "colorTransfer":I
    :goto_18
    add-int v11, v33, v10

    .line 1342
    .end local v1    # "childAtomType":I
    .end local v9    # "childStartPosition":I
    .end local v10    # "childAtomSize":I
    .end local v33    # "childPosition":I
    .restart local v11    # "childPosition":I
    move/from16 v1, p2

    move/from16 v2, p3

    move-object v10, v4

    move/from16 v9, v22

    move/from16 v14, v29

    move/from16 v6, v30

    move/from16 v5, v31

    move-object/from16 v4, p7

    goto/16 :goto_2

    .line 1161
    .end local v4    # "projectionData":[B
    .end local v29    # "atomType":I
    .end local v30    # "height":I
    .end local v31    # "width":I
    .local v5, "width":I
    .restart local v6    # "height":I
    .local v10, "projectionData":[B
    .restart local v14    # "atomType":I
    :cond_2b
    move/from16 v31, v5

    move/from16 v30, v6

    move/from16 v28, v7

    move/from16 p6, v8

    move-object/from16 p1, v10

    move/from16 v33, v11

    move v5, v13

    move/from16 v29, v14

    move-object/from16 v32, v15

    const/4 v2, 0x0

    .line 1345
    .end local v6    # "height":I
    .end local v7    # "pixelWidthHeightRatioFromPasp":Z
    .end local v8    # "pixelWidthHeightRatio":F
    .end local v10    # "projectionData":[B
    .end local v11    # "childPosition":I
    .end local v13    # "colorTransfer":I
    .end local v14    # "atomType":I
    .end local v15    # "codecs":Ljava/lang/String;
    .local v5, "colorTransfer":I
    .restart local v28    # "pixelWidthHeightRatioFromPasp":Z
    .restart local v29    # "atomType":I
    .restart local v30    # "height":I
    .restart local v31    # "width":I
    .restart local v32    # "codecs":Ljava/lang/String;
    .restart local v33    # "childPosition":I
    .restart local p1    # "projectionData":[B
    .restart local p6    # "pixelWidthHeightRatio":F
    :goto_19
    if-nez v12, :cond_2c

    .line 1346
    return-void

    .line 1349
    :cond_2c
    new-instance v1, Landroidx/media3/common/Format$Builder;

    invoke-direct {v1}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 1351
    move/from16 v4, p4

    invoke-virtual {v1, v4}, Landroidx/media3/common/Format$Builder;->setId(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1352
    invoke-virtual {v1, v12}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1353
    move-object/from16 v15, v32

    .end local v32    # "codecs":Ljava/lang/String;
    .restart local v15    # "codecs":Ljava/lang/String;
    invoke-virtual {v1, v15}, Landroidx/media3/common/Format$Builder;->setCodecs(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1354
    move/from16 v6, v31

    .end local v31    # "width":I
    .local v6, "width":I
    invoke-virtual {v1, v6}, Landroidx/media3/common/Format$Builder;->setWidth(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1355
    move/from16 v7, v30

    .end local v30    # "height":I
    .local v7, "height":I
    invoke-virtual {v1, v7}, Landroidx/media3/common/Format$Builder;->setHeight(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1356
    move/from16 v8, p6

    .end local p6    # "pixelWidthHeightRatio":F
    .restart local v8    # "pixelWidthHeightRatio":F
    invoke-virtual {v1, v8}, Landroidx/media3/common/Format$Builder;->setPixelWidthHeightRatio(F)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1357
    move/from16 v9, p5

    invoke-virtual {v1, v9}, Landroidx/media3/common/Format$Builder;->setRotationDegrees(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1358
    move-object/from16 v10, p1

    .end local p1    # "projectionData":[B
    .restart local v10    # "projectionData":[B
    invoke-virtual {v1, v10}, Landroidx/media3/common/Format$Builder;->setProjectionData([B)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1359
    move/from16 v11, v22

    .end local v22    # "stereoMode":I
    .local v11, "stereoMode":I
    invoke-virtual {v1, v11}, Landroidx/media3/common/Format$Builder;->setStereoMode(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1360
    move-object/from16 v13, v21

    .end local v21    # "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    .local v13, "initializationData":Ljava/util/List;, "Ljava/util/List<[B>;"
    invoke-virtual {v1, v13}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1361
    move-object/from16 v14, v20

    .end local v20    # "drmInitData":Landroidx/media3/common/DrmInitData;
    .local v14, "drmInitData":Landroidx/media3/common/DrmInitData;
    invoke-virtual {v1, v14}, Landroidx/media3/common/Format$Builder;->setDrmInitData(Landroidx/media3/common/DrmInitData;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    new-instance v2, Landroidx/media3/common/ColorInfo$Builder;

    invoke-direct {v2}, Landroidx/media3/common/ColorInfo$Builder;-><init>()V

    .line 1366
    invoke-virtual {v2, v3}, Landroidx/media3/common/ColorInfo$Builder;->setColorSpace(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v2

    .line 1367
    move/from16 v0, v24

    .end local v24    # "colorRange":I
    .local v0, "colorRange":I
    invoke-virtual {v2, v0}, Landroidx/media3/common/ColorInfo$Builder;->setColorRange(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v2

    .line 1368
    invoke-virtual {v2, v5}, Landroidx/media3/common/ColorInfo$Builder;->setColorTransfer(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v2

    .line 1369
    if-eqz v23, :cond_2d

    invoke-virtual/range {v23 .. v23}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v16

    move/from16 v20, v0

    move-object/from16 v0, v16

    goto :goto_1a

    :cond_2d
    move/from16 v20, v0

    const/4 v0, 0x0

    .end local v0    # "colorRange":I
    .local v20, "colorRange":I
    :goto_1a
    invoke-virtual {v2, v0}, Landroidx/media3/common/ColorInfo$Builder;->setHdrStaticInfo([B)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 1370
    move/from16 v2, v18

    .end local v18    # "bitdepthLuma":I
    .local v2, "bitdepthLuma":I
    invoke-virtual {v0, v2}, Landroidx/media3/common/ColorInfo$Builder;->setLumaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 1371
    move/from16 v16, v2

    move/from16 v2, v17

    .end local v17    # "bitdepthChroma":I
    .local v2, "bitdepthChroma":I
    .local v16, "bitdepthLuma":I
    invoke-virtual {v0, v2}, Landroidx/media3/common/ColorInfo$Builder;->setChromaBitdepth(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 1372
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v0

    .line 1364
    invoke-virtual {v1, v0}, Landroidx/media3/common/Format$Builder;->setColorInfo(Landroidx/media3/common/ColorInfo;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 1374
    .local v0, "formatBuilder":Landroidx/media3/common/Format$Builder;
    if-eqz v19, :cond_2e

    .line 1375
    nop

    .line 1376
    invoke-static/range {v19 .. v19}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$600(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J

    move-result-wide v17

    invoke-static/range {v17 .. v18}, Lcom/google/common/primitives/Ints;->saturatedCast(J)I

    move-result v1

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setAverageBitrate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 1377
    invoke-static/range {v19 .. v19}, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->access$500(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J

    move-result-wide v17

    move/from16 v21, v2

    .end local v2    # "bitdepthChroma":I
    .local v21, "bitdepthChroma":I
    invoke-static/range {v17 .. v18}, Lcom/google/common/primitives/Ints;->saturatedCast(J)I

    move-result v2

    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setPeakBitrate(I)Landroidx/media3/common/Format$Builder;

    goto :goto_1b

    .line 1374
    .end local v21    # "bitdepthChroma":I
    .restart local v2    # "bitdepthChroma":I
    :cond_2e
    move/from16 v21, v2

    .line 1380
    .end local v2    # "bitdepthChroma":I
    .restart local v21    # "bitdepthChroma":I
    :goto_1b
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v1

    move-object/from16 v2, p7

    iput-object v1, v2, Landroidx/media3/extractor/mp4/AtomParsers$StsdData;->format:Landroidx/media3/common/Format;

    .line 1381
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static parseXyz(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/common/Metadata;
    .locals 11
    .param p0, "xyzBox"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 812
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readShort()S

    move-result v0

    .line 813
    .local v0, "length":I
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 814
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->readString(I)Ljava/lang/String;

    move-result-object v1

    .line 816
    .local v1, "location":Ljava/lang/String;
    const/16 v2, 0x2b

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v2

    .line 817
    .local v2, "plusSignIndex":I
    const/16 v3, 0x2d

    invoke-virtual {v1, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 818
    .local v3, "minusSignIndex":I
    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v4

    .line 820
    .local v4, "latitudeEndIndex":I
    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {v1, v5, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    .line 821
    .local v6, "latitude":F
    nop

    .line 822
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v7

    const/4 v8, 0x1

    sub-int/2addr v7, v8

    invoke-virtual {v1, v4, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    .line 823
    .local v7, "longitude":F
    new-instance v9, Landroidx/media3/common/Metadata;

    new-array v8, v8, [Landroidx/media3/common/Metadata$Entry;

    new-instance v10, Landroidx/media3/container/Mp4LocationData;

    invoke-direct {v10, v6, v7}, Landroidx/media3/container/Mp4LocationData;-><init>(FF)V

    aput-object v10, v8, v5

    invoke-direct {v9, v8}, Landroidx/media3/common/Metadata;-><init>([Landroidx/media3/common/Metadata$Entry;)V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v9

    .line 824
    .end local v6    # "latitude":F
    .end local v7    # "longitude":F
    :catch_0
    move-exception v5

    goto :goto_0

    :catch_1
    move-exception v5

    .line 826
    .local v5, "exception":Ljava/lang/RuntimeException;
    :goto_0
    const/4 v6, 0x0

    return-object v6
.end method
