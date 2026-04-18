.class public final Landroidx/media3/extractor/DefaultExtractorsFactory;
.super Ljava/lang/Object;
.source "DefaultExtractorsFactory.java"

# interfaces
.implements Landroidx/media3/extractor/ExtractorsFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;
    }
.end annotation


# static fields
.field private static final DEFAULT_EXTRACTOR_ORDER:[I

.field private static final FLAC_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

.field private static final MIDI_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;


# instance fields
.field private adtsFlags:I

.field private amrFlags:I

.field private constantBitrateSeekingAlwaysEnabled:Z

.field private constantBitrateSeekingEnabled:Z

.field private flacFlags:I

.field private fragmentedMp4Flags:I

.field private jpegFlags:I

.field private matroskaFlags:I

.field private mp3Flags:I

.field private mp4Flags:I

.field private subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

.field private textTrackTranscodingEnabled:Z

.field private tsFlags:I

.field private tsMode:I

.field private tsSubtitleFormats:Lcom/google/common/collect/ImmutableList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableList<",
            "Landroidx/media3/common/Format;",
            ">;"
        }
    .end annotation
.end field

.field private tsTimestampSearchBytes:I


# direct methods
.method public static synthetic $r8$lambda$6W2W1-5R-UwlVLNHyyNaCk7TSbw()Ljava/lang/reflect/Constructor;
    .locals 1

    invoke-static {}, Landroidx/media3/extractor/DefaultExtractorsFactory;->getFlacExtractorConstructor()Ljava/lang/reflect/Constructor;

    move-result-object v0

    return-object v0
.end method

.method public static synthetic $r8$lambda$OE87ByVhBFSLNnBVk3NnyEF73wY()Ljava/lang/reflect/Constructor;
    .locals 1

    invoke-static {}, Landroidx/media3/extractor/DefaultExtractorsFactory;->getMidiExtractorConstructor()Ljava/lang/reflect/Constructor;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 2

    .line 108
    const/16 v0, 0x14

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/extractor/DefaultExtractorsFactory;->DEFAULT_EXTRACTOR_ORDER:[I

    .line 134
    new-instance v0, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    new-instance v1, Landroidx/media3/extractor/DefaultExtractorsFactory$$ExternalSyntheticLambda0;

    invoke-direct {v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$$ExternalSyntheticLambda0;-><init>()V

    invoke-direct {v0, v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;-><init>(Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier;)V

    sput-object v0, Landroidx/media3/extractor/DefaultExtractorsFactory;->FLAC_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    .line 136
    new-instance v0, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    new-instance v1, Landroidx/media3/extractor/DefaultExtractorsFactory$$ExternalSyntheticLambda1;

    invoke-direct {v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$$ExternalSyntheticLambda1;-><init>()V

    invoke-direct {v0, v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;-><init>(Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader$ConstructorSupplier;)V

    sput-object v0, Landroidx/media3/extractor/DefaultExtractorsFactory;->MIDI_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    return-void

    :array_0
    .array-data 4
        0x5
        0x4
        0xc
        0x8
        0x3
        0xa
        0x9
        0xb
        0x6
        0x2
        0x0
        0x1
        0x7
        0x10
        0xf
        0xe
        0x11
        0x12
        0x13
        0x14
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 158
    const/4 v0, 0x1

    iput v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsMode:I

    .line 159
    const v0, 0x1b8a0

    iput v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsTimestampSearchBytes:I

    .line 160
    new-instance v0, Landroidx/media3/extractor/text/DefaultSubtitleParserFactory;

    invoke-direct {v0}, Landroidx/media3/extractor/text/DefaultSubtitleParserFactory;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 161
    return-void
.end method

.method private addExtractorsForFileType(ILjava/util/List;)V
    .locals 9
    .param p1, "fileType"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/List<",
            "Landroidx/media3/extractor/Extractor;",
            ">;)V"
        }
    .end annotation

    .line 444
    .local p2, "extractors":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/Extractor;>;"
    const/4 v0, 0x1

    const/4 v1, 0x2

    const/4 v2, 0x0

    packed-switch p1, :pswitch_data_0

    :pswitch_0
    goto/16 :goto_9

    .line 567
    :pswitch_1
    iget v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->mp4Flags:I

    and-int/lit8 v1, v0, 0x2

    if-nez v1, :cond_b

    and-int/lit8 v0, v0, 0x4

    if-nez v0, :cond_b

    .line 569
    new-instance v0, Landroidx/media3/extractor/heif/HeifExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/heif/HeifExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_9

    .line 564
    :pswitch_2
    new-instance v0, Landroidx/media3/extractor/bmp/BmpExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/bmp/BmpExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 565
    goto/16 :goto_9

    .line 561
    :pswitch_3
    new-instance v0, Landroidx/media3/extractor/webp/WebpExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/webp/WebpExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 562
    goto/16 :goto_9

    .line 558
    :pswitch_4
    new-instance v0, Landroidx/media3/extractor/png/PngExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/png/PngExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 559
    goto/16 :goto_9

    .line 552
    :pswitch_5
    new-instance v1, Landroidx/media3/extractor/avi/AviExtractor;

    .line 554
    iget-boolean v2, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    xor-int/2addr v0, v2

    iget-object v2, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v1, v0, v2}, Landroidx/media3/extractor/avi/AviExtractor;-><init>(ILandroidx/media3/extractor/text/SubtitleParser$Factory;)V

    .line 552
    invoke-interface {p2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 556
    goto/16 :goto_9

    .line 546
    :pswitch_6
    sget-object v0, Landroidx/media3/extractor/DefaultExtractorsFactory;->MIDI_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    new-array v1, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;->getExtractor([Ljava/lang/Object;)Landroidx/media3/extractor/Extractor;

    move-result-object v0

    .line 547
    .local v0, "midiExtractor":Landroidx/media3/extractor/Extractor;
    if-eqz v0, :cond_b

    .line 548
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_9

    .line 543
    .end local v0    # "midiExtractor":Landroidx/media3/extractor/Extractor;
    :pswitch_7
    new-instance v0, Landroidx/media3/extractor/jpeg/JpegExtractor;

    iget v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->jpegFlags:I

    invoke-direct {v0, v1}, Landroidx/media3/extractor/jpeg/JpegExtractor;-><init>(I)V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 544
    goto/16 :goto_9

    .line 540
    :pswitch_8
    new-instance v0, Landroidx/media3/extractor/wav/WavExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/wav/WavExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 541
    goto/16 :goto_9

    .line 527
    :pswitch_9
    iget-object v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsSubtitleFormats:Lcom/google/common/collect/ImmutableList;

    if-nez v1, :cond_0

    .line 528
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsSubtitleFormats:Lcom/google/common/collect/ImmutableList;

    .line 530
    :cond_0
    new-instance v1, Landroidx/media3/extractor/ts/TsExtractor;

    iget v3, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsMode:I

    .line 533
    iget-boolean v2, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    xor-int/lit8 v4, v2, 0x1

    iget-object v5, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    new-instance v6, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v7, 0x0

    invoke-direct {v6, v7, v8}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v7, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    iget v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsFlags:I

    iget-object v2, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsSubtitleFormats:Lcom/google/common/collect/ImmutableList;

    invoke-direct {v7, v0, v2}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(ILjava/util/List;)V

    iget v8, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsTimestampSearchBytes:I

    move-object v2, v1

    invoke-direct/range {v2 .. v8}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 530
    invoke-interface {p2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 538
    goto/16 :goto_9

    .line 524
    :pswitch_a
    new-instance v0, Landroidx/media3/extractor/ts/PsExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/PsExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 525
    goto/16 :goto_9

    .line 521
    :pswitch_b
    new-instance v0, Landroidx/media3/extractor/ogg/OggExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/ogg/OggExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 522
    goto/16 :goto_9

    .line 505
    :pswitch_c
    new-instance v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;

    iget-object v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    iget v3, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->fragmentedMp4Flags:I

    .line 509
    iget-boolean v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    if-eqz v4, :cond_1

    .line 510
    move v4, v2

    goto :goto_0

    .line 511
    :cond_1
    const/16 v4, 0x20

    :goto_0
    or-int/2addr v3, v4

    invoke-direct {v0, v1, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V

    .line 505
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 512
    new-instance v0, Landroidx/media3/extractor/mp4/Mp4Extractor;

    iget-object v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    iget v3, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->mp4Flags:I

    .line 516
    iget-boolean v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    if-eqz v4, :cond_2

    .line 517
    goto :goto_1

    .line 518
    :cond_2
    const/16 v2, 0x10

    :goto_1
    or-int/2addr v2, v3

    invoke-direct {v0, v1, v2}, Landroidx/media3/extractor/mp4/Mp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V

    .line 512
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 519
    goto/16 :goto_9

    .line 494
    :pswitch_d
    new-instance v3, Landroidx/media3/extractor/mp3/Mp3Extractor;

    iget v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->mp3Flags:I

    .line 497
    iget-boolean v5, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingEnabled:Z

    if-eqz v5, :cond_3

    .line 498
    goto :goto_2

    .line 499
    :cond_3
    move v0, v2

    :goto_2
    or-int/2addr v0, v4

    .line 500
    iget-boolean v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingAlwaysEnabled:Z

    if-eqz v4, :cond_4

    .line 501
    goto :goto_3

    .line 502
    :cond_4
    move v1, v2

    :goto_3
    or-int/2addr v0, v1

    invoke-direct {v3, v0}, Landroidx/media3/extractor/mp3/Mp3Extractor;-><init>(I)V

    .line 494
    invoke-interface {p2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 503
    goto/16 :goto_9

    .line 485
    :pswitch_e
    new-instance v0, Landroidx/media3/extractor/mkv/MatroskaExtractor;

    iget-object v3, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    iget v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->matroskaFlags:I

    .line 489
    iget-boolean v5, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    if-eqz v5, :cond_5

    .line 490
    move v1, v2

    goto :goto_4

    .line 491
    :cond_5
    nop

    :goto_4
    or-int/2addr v1, v4

    invoke-direct {v0, v3, v1}, Landroidx/media3/extractor/mkv/MatroskaExtractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V

    .line 485
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 492
    goto/16 :goto_9

    .line 482
    :pswitch_f
    new-instance v0, Landroidx/media3/extractor/flv/FlvExtractor;

    invoke-direct {v0}, Landroidx/media3/extractor/flv/FlvExtractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 483
    goto/16 :goto_9

    .line 474
    :pswitch_10
    sget-object v0, Landroidx/media3/extractor/DefaultExtractorsFactory;->FLAC_EXTENSION_LOADER:Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;

    iget v1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->flacFlags:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    filled-new-array {v1}, [Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/extractor/DefaultExtractorsFactory$ExtensionLoader;->getExtractor([Ljava/lang/Object;)Landroidx/media3/extractor/Extractor;

    move-result-object v0

    .line 475
    .local v0, "flacExtractor":Landroidx/media3/extractor/Extractor;
    if-eqz v0, :cond_6

    .line 476
    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_9

    .line 478
    :cond_6
    new-instance v1, Landroidx/media3/extractor/flac/FlacExtractor;

    iget v2, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->flacFlags:I

    invoke-direct {v1, v2}, Landroidx/media3/extractor/flac/FlacExtractor;-><init>(I)V

    invoke-interface {p2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 480
    goto :goto_9

    .line 463
    .end local v0    # "flacExtractor":Landroidx/media3/extractor/Extractor;
    :pswitch_11
    new-instance v3, Landroidx/media3/extractor/amr/AmrExtractor;

    iget v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->amrFlags:I

    .line 466
    iget-boolean v5, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingEnabled:Z

    if-eqz v5, :cond_7

    .line 467
    goto :goto_5

    .line 468
    :cond_7
    move v0, v2

    :goto_5
    or-int/2addr v0, v4

    .line 469
    iget-boolean v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingAlwaysEnabled:Z

    if-eqz v4, :cond_8

    .line 470
    goto :goto_6

    .line 471
    :cond_8
    move v1, v2

    :goto_6
    or-int/2addr v0, v1

    invoke-direct {v3, v0}, Landroidx/media3/extractor/amr/AmrExtractor;-><init>(I)V

    .line 463
    invoke-interface {p2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 472
    goto :goto_9

    .line 452
    :pswitch_12
    new-instance v3, Landroidx/media3/extractor/ts/AdtsExtractor;

    iget v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->adtsFlags:I

    .line 455
    iget-boolean v5, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingEnabled:Z

    if-eqz v5, :cond_9

    .line 456
    goto :goto_7

    .line 457
    :cond_9
    move v0, v2

    :goto_7
    or-int/2addr v0, v4

    .line 458
    iget-boolean v4, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingAlwaysEnabled:Z

    if-eqz v4, :cond_a

    .line 459
    goto :goto_8

    .line 460
    :cond_a
    move v1, v2

    :goto_8
    or-int/2addr v0, v1

    invoke-direct {v3, v0}, Landroidx/media3/extractor/ts/AdtsExtractor;-><init>(I)V

    .line 452
    invoke-interface {p2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 461
    goto :goto_9

    .line 449
    :pswitch_13
    new-instance v0, Landroidx/media3/extractor/ts/Ac4Extractor;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/Ac4Extractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 450
    goto :goto_9

    .line 446
    :pswitch_14
    new-instance v0, Landroidx/media3/extractor/ts/Ac3Extractor;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/Ac3Extractor;-><init>()V

    invoke-interface {p2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 447
    nop

    .line 577
    :cond_b
    :goto_9
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_14
        :pswitch_13
        :pswitch_12
        :pswitch_11
        :pswitch_10
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_0
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static getFlacExtractorConstructor()Ljava/lang/reflect/Constructor;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/reflect/Constructor<",
            "+",
            "Landroidx/media3/extractor/Extractor;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/reflect/InvocationTargetException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .line 593
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    .line 595
    const-string v1, "androidx.media3.decoder.flac.FlacLibrary"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    .line 596
    const-string v4, "isAvailable"

    invoke-virtual {v1, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    new-array v3, v2, [Ljava/lang/Object;

    .line 597
    const/4 v4, 0x0

    invoke-virtual {v1, v4, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 594
    invoke-virtual {v0, v1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 598
    .local v0, "isFlacNativeLibraryAvailable":Z
    if-eqz v0, :cond_0

    .line 599
    const-string v1, "androidx.media3.decoder.flac.FlacExtractor"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    const-class v3, Landroidx/media3/extractor/Extractor;

    .line 600
    invoke-virtual {v1, v3}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    sget-object v4, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v4, v3, v2

    .line 601
    invoke-virtual {v1, v3}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 599
    return-object v1

    .line 603
    :cond_0
    return-object v4
.end method

.method private static getMidiExtractorConstructor()Ljava/lang/reflect/Constructor;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/reflect/Constructor<",
            "+",
            "Landroidx/media3/extractor/Extractor;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;
        }
    .end annotation

    .line 581
    const-string v0, "androidx.media3.decoder.midi.MidiExtractor"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-class v1, Landroidx/media3/extractor/Extractor;

    .line 582
    invoke-virtual {v0, v1}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Class;

    .line 583
    invoke-virtual {v0, v1}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 581
    return-object v0
.end method


# virtual methods
.method public declared-synchronized createExtractors()[Landroidx/media3/extractor/Extractor;
    .locals 2

    monitor-enter p0

    .line 401
    :try_start_0
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p0, v0, v1}, Landroidx/media3/extractor/DefaultExtractorsFactory;->createExtractors(Landroid/net/Uri;Ljava/util/Map;)[Landroidx/media3/extractor/Extractor;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 401
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized createExtractors(Landroid/net/Uri;Ljava/util/Map;)[Landroidx/media3/extractor/Extractor;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;)[",
            "Landroidx/media3/extractor/Extractor;"
        }
    .end annotation

    .local p2, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    monitor-enter p0

    .line 407
    :try_start_0
    new-instance v0, Ljava/util/ArrayList;

    sget-object v1, Landroidx/media3/extractor/DefaultExtractorsFactory;->DEFAULT_EXTRACTOR_ORDER:[I

    array-length v2, v1

    invoke-direct {v0, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 411
    .local v0, "extractors":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/Extractor;>;"
    invoke-static {p2}, Landroidx/media3/common/FileTypes;->inferFileTypeFromResponseHeaders(Ljava/util/Map;)I

    move-result v2

    .line 412
    .local v2, "responseHeadersInferredFileType":I
    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 413
    invoke-direct {p0, v2, v0}, Landroidx/media3/extractor/DefaultExtractorsFactory;->addExtractorsForFileType(ILjava/util/List;)V

    .line 416
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    :cond_0
    invoke-static {p1}, Landroidx/media3/common/FileTypes;->inferFileTypeFromUri(Landroid/net/Uri;)I

    move-result v4

    .line 417
    .local v4, "uriInferredFileType":I
    if-eq v4, v3, :cond_1

    if-eq v4, v2, :cond_1

    .line 419
    invoke-direct {p0, v4, v0}, Landroidx/media3/extractor/DefaultExtractorsFactory;->addExtractorsForFileType(ILjava/util/List;)V

    .line 422
    :cond_1
    array-length v3, v1

    const/4 v5, 0x0

    :goto_0
    if-ge v5, v3, :cond_3

    aget v6, v1, v5

    .line 423
    .local v6, "fileType":I
    if-eq v6, v2, :cond_2

    if-eq v6, v4, :cond_2

    .line 424
    invoke-direct {p0, v6, v0}, Landroidx/media3/extractor/DefaultExtractorsFactory;->addExtractorsForFileType(ILjava/util/List;)V

    .line 422
    .end local v6    # "fileType":I
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 427
    :cond_3
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Landroidx/media3/extractor/Extractor;

    .line 428
    .local v1, "result":[Landroidx/media3/extractor/Extractor;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-ge v3, v5, :cond_5

    .line 429
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/Extractor;

    .line 430
    .local v5, "extractor":Landroidx/media3/extractor/Extractor;
    nop

    .line 436
    iget-boolean v6, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z

    if-eqz v6, :cond_4

    .line 432
    invoke-interface {v5}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v6

    instance-of v6, v6, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;

    if-nez v6, :cond_4

    .line 433
    invoke-interface {v5}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v6

    instance-of v6, v6, Landroidx/media3/extractor/mp4/Mp4Extractor;

    if-nez v6, :cond_4

    .line 434
    invoke-interface {v5}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v6

    instance-of v6, v6, Landroidx/media3/extractor/ts/TsExtractor;

    if-nez v6, :cond_4

    .line 435
    invoke-interface {v5}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v6

    instance-of v6, v6, Landroidx/media3/extractor/avi/AviExtractor;

    if-nez v6, :cond_4

    .line 436
    invoke-interface {v5}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v6

    instance-of v6, v6, Landroidx/media3/extractor/mkv/MatroskaExtractor;

    if-nez v6, :cond_4

    .line 437
    new-instance v6, Landroidx/media3/extractor/text/SubtitleTranscodingExtractor;

    iget-object v7, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v6, v5, v7}, Landroidx/media3/extractor/text/SubtitleTranscodingExtractor;-><init>(Landroidx/media3/extractor/Extractor;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    goto :goto_2

    .line 438
    :cond_4
    move-object v6, v5

    :goto_2
    aput-object v6, v1, v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 428
    .end local v5    # "extractor":Landroidx/media3/extractor/Extractor;
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 440
    .end local v3    # "i":I
    :cond_5
    monitor-exit p0

    return-object v1

    .line 406
    .end local v0    # "extractors":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/Extractor;>;"
    .end local v1    # "result":[Landroidx/media3/extractor/Extractor;
    .end local v2    # "responseHeadersInferredFileType":I
    .end local v4    # "uriInferredFileType":I
    .end local p1    # "uri":Landroid/net/Uri;
    .end local p2    # "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized experimentalSetTextTrackTranscodingEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "textTrackTranscodingEnabled"    # Z

    monitor-enter p0

    .line 373
    :try_start_0
    iput-boolean p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->textTrackTranscodingEnabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 374
    monitor-exit p0

    return-object p0

    .line 372
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "textTrackTranscodingEnabled":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public bridge synthetic experimentalSetTextTrackTranscodingEnabled(Z)Landroidx/media3/extractor/ExtractorsFactory;
    .locals 0

    .line 101
    invoke-virtual {p0, p1}, Landroidx/media3/extractor/DefaultExtractorsFactory;->experimentalSetTextTrackTranscodingEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;

    move-result-object p1

    return-object p1
.end method

.method public declared-synchronized setAdtsExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 216
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->adtsFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 217
    monitor-exit p0

    return-object p0

    .line 215
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setAmrExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 229
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->amrFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 230
    monitor-exit p0

    return-object p0

    .line 228
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setConstantBitrateSeekingAlwaysEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "constantBitrateSeekingAlwaysEnabled"    # Z

    monitor-enter p0

    .line 202
    :try_start_0
    iput-boolean p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingAlwaysEnabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 203
    monitor-exit p0

    return-object p0

    .line 201
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "constantBitrateSeekingAlwaysEnabled":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setConstantBitrateSeekingEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "constantBitrateSeekingEnabled"    # Z

    monitor-enter p0

    .line 177
    :try_start_0
    iput-boolean p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->constantBitrateSeekingEnabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 178
    monitor-exit p0

    return-object p0

    .line 176
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "constantBitrateSeekingEnabled":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setFlacExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 245
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->flacFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 246
    monitor-exit p0

    return-object p0

    .line 244
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setFragmentedMp4ExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 286
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->fragmentedMp4Flags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 287
    monitor-exit p0

    return-object p0

    .line 285
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setJpegExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 395
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->jpegFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 396
    monitor-exit p0

    return-object p0

    .line 394
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setMatroskaExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 259
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->matroskaFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 260
    monitor-exit p0

    return-object p0

    .line 258
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setMp3ExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 299
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->mp3Flags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 300
    monitor-exit p0

    return-object p0

    .line 298
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setMp4ExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 272
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->mp4Flags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 273
    monitor-exit p0

    return-object p0

    .line 271
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setSubtitleParserFactory(Landroidx/media3/extractor/text/SubtitleParser$Factory;)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    monitor-enter p0

    .line 381
    :try_start_0
    iput-object p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 382
    monitor-exit p0

    return-object p0

    .line 380
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "subtitleParserFactory":Landroidx/media3/extractor/text/SubtitleParser$Factory;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public bridge synthetic setSubtitleParserFactory(Landroidx/media3/extractor/text/SubtitleParser$Factory;)Landroidx/media3/extractor/ExtractorsFactory;
    .locals 0

    .line 101
    invoke-virtual {p0, p1}, Landroidx/media3/extractor/DefaultExtractorsFactory;->setSubtitleParserFactory(Landroidx/media3/extractor/text/SubtitleParser$Factory;)Landroidx/media3/extractor/DefaultExtractorsFactory;

    move-result-object p1

    return-object p1
.end method

.method public declared-synchronized setTextTrackTranscodingEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 1
    .param p1, "textTrackTranscodingEnabled"    # Z
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    monitor-enter p0

    .line 367
    :try_start_0
    invoke-virtual {p0, p1}, Landroidx/media3/extractor/DefaultExtractorsFactory;->experimentalSetTextTrackTranscodingEnabled(Z)Landroidx/media3/extractor/DefaultExtractorsFactory;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 367
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "textTrackTranscodingEnabled":Z
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setTsExtractorFlags(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "flags"    # I

    monitor-enter p0

    .line 327
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsFlags:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 328
    monitor-exit p0

    return-object p0

    .line 326
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "flags":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setTsExtractorMode(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "mode"    # I

    monitor-enter p0

    .line 312
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsMode:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 313
    monitor-exit p0

    return-object p0

    .line 311
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "mode":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setTsExtractorTimestampSearchBytes(I)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 0
    .param p1, "timestampSearchBytes"    # I

    monitor-enter p0

    .line 356
    :try_start_0
    iput p1, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsTimestampSearchBytes:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 357
    monitor-exit p0

    return-object p0

    .line 355
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "timestampSearchBytes":I
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method

.method public declared-synchronized setTsSubtitleFormats(Ljava/util/List;)Landroidx/media3/extractor/DefaultExtractorsFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;)",
            "Landroidx/media3/extractor/DefaultExtractorsFactory;"
        }
    .end annotation

    .local p1, "subtitleFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    monitor-enter p0

    .line 341
    :try_start_0
    invoke-static {p1}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/DefaultExtractorsFactory;->tsSubtitleFormats:Lcom/google/common/collect/ImmutableList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 342
    monitor-exit p0

    return-object p0

    .line 340
    .end local p0    # "this":Landroidx/media3/extractor/DefaultExtractorsFactory;
    .end local p1    # "subtitleFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
