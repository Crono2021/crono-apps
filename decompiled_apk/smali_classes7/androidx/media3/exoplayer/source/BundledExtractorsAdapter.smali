.class public final Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;
.super Ljava/lang/Object;
.source "BundledExtractorsAdapter.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/ProgressiveMediaExtractor;


# instance fields
.field private extractor:Landroidx/media3/extractor/Extractor;

.field private extractorInput:Landroidx/media3/extractor/ExtractorInput;

.field private final extractorsFactory:Landroidx/media3/extractor/ExtractorsFactory;


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/ExtractorsFactory;)V
    .locals 0
    .param p1, "extractorsFactory"    # Landroidx/media3/extractor/ExtractorsFactory;

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    iput-object p1, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorsFactory:Landroidx/media3/extractor/ExtractorsFactory;

    .line 56
    return-void
.end method


# virtual methods
.method public disableSeekingOnMp3Streams()V
    .locals 2

    .line 111
    iget-object v0, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-nez v0, :cond_0

    .line 112
    return-void

    .line 114
    :cond_0
    invoke-interface {v0}, Landroidx/media3/extractor/Extractor;->getUnderlyingImplementation()Landroidx/media3/extractor/Extractor;

    move-result-object v0

    .line 115
    .local v0, "underlyingExtractor":Landroidx/media3/extractor/Extractor;
    instance-of v1, v0, Landroidx/media3/extractor/mp3/Mp3Extractor;

    if-eqz v1, :cond_1

    .line 116
    move-object v1, v0

    check-cast v1, Landroidx/media3/extractor/mp3/Mp3Extractor;

    invoke-virtual {v1}, Landroidx/media3/extractor/mp3/Mp3Extractor;->disableSeeking()V

    .line 118
    :cond_1
    return-void
.end method

.method public getCurrentInputPosition()J
    .locals 2

    .line 122
    iget-object v0, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorInput:Landroidx/media3/extractor/ExtractorInput;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    goto :goto_0

    :cond_0
    const-wide/16 v0, -0x1

    :goto_0
    return-wide v0
.end method

.method public init(Landroidx/media3/common/DataReader;Landroid/net/Uri;Ljava/util/Map;JJLandroidx/media3/extractor/ExtractorOutput;)V
    .locals 13
    .param p1, "dataReader"    # Landroidx/media3/common/DataReader;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p4, "position"    # J
    .param p6, "length"    # J
    .param p8, "output"    # Landroidx/media3/extractor/ExtractorOutput;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/DataReader;",
            "Landroid/net/Uri;",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;JJ",
            "Landroidx/media3/extractor/ExtractorOutput;",
            ")V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 67
    .local p3, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    move-object v1, p0

    new-instance v0, Landroidx/media3/extractor/DefaultExtractorInput;

    move-object v2, v0

    move-object v3, p1

    move-wide/from16 v4, p4

    move-wide/from16 v6, p6

    invoke-direct/range {v2 .. v7}, Landroidx/media3/extractor/DefaultExtractorInput;-><init>(Landroidx/media3/common/DataReader;JJ)V

    .line 68
    .local v2, "extractorInput":Landroidx/media3/extractor/ExtractorInput;
    iput-object v2, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorInput:Landroidx/media3/extractor/ExtractorInput;

    .line 69
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-eqz v0, :cond_0

    .line 70
    return-void

    .line 72
    :cond_0
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorsFactory:Landroidx/media3/extractor/ExtractorsFactory;

    move-object v3, p2

    move-object/from16 v4, p3

    invoke-interface {v0, p2, v4}, Landroidx/media3/extractor/ExtractorsFactory;->createExtractors(Landroid/net/Uri;Ljava/util/Map;)[Landroidx/media3/extractor/Extractor;

    move-result-object v5

    .line 73
    .local v5, "extractors":[Landroidx/media3/extractor/Extractor;
    array-length v0, v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-ne v0, v7, :cond_1

    .line 74
    aget-object v0, v5, v6

    iput-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    goto/16 :goto_4

    .line 76
    :cond_1
    array-length v8, v5

    move v9, v6

    :goto_0
    if-ge v9, v8, :cond_a

    aget-object v10, v5, v9

    .line 78
    .local v10, "extractor":Landroidx/media3/extractor/Extractor;
    :try_start_0
    invoke-interface {v10, v2}, Landroidx/media3/extractor/Extractor;->sniff(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 79
    iput-object v10, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 85
    if-nez v10, :cond_2

    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v8

    cmp-long v0, v8, p4

    if-nez v0, :cond_3

    :cond_2
    move v6, v7

    :cond_3
    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 86
    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 80
    goto :goto_3

    .line 85
    :cond_4
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-nez v0, :cond_5

    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v11

    cmp-long v0, v11, p4

    if-nez v0, :cond_8

    :cond_5
    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v8, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-nez v8, :cond_6

    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v8

    cmp-long v8, v8, p4

    if-nez v8, :cond_7

    :cond_6
    move v6, v7

    :cond_7
    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 86
    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 87
    throw v0

    .line 82
    :catch_0
    move-exception v0

    .line 85
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-nez v0, :cond_9

    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v11

    cmp-long v0, v11, p4

    if-nez v0, :cond_8

    goto :goto_1

    :cond_8
    move v0, v6

    goto :goto_2

    :cond_9
    :goto_1
    move v0, v7

    :goto_2
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 86
    invoke-interface {v2}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 87
    nop

    .line 76
    .end local v10    # "extractor":Landroidx/media3/extractor/Extractor;
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 89
    :cond_a
    :goto_3
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    if-eqz v0, :cond_b

    .line 97
    :goto_4
    iget-object v0, v1, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    move-object/from16 v6, p8

    invoke-interface {v0, v6}, Landroidx/media3/extractor/Extractor;->init(Landroidx/media3/extractor/ExtractorOutput;)V

    .line 98
    return-void

    .line 90
    :cond_b
    move-object/from16 v6, p8

    new-instance v0, Landroidx/media3/exoplayer/source/UnrecognizedInputFormatException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "None of the available extractors ("

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 92
    invoke-static {v5}, Landroidx/media3/common/util/Util;->getCommaDelimitedSimpleClassNames([Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ") could read the stream."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 94
    invoke-static {p2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/net/Uri;

    invoke-direct {v0, v7, v8}, Landroidx/media3/exoplayer/source/UnrecognizedInputFormatException;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    throw v0
.end method

.method public read(Landroidx/media3/extractor/PositionHolder;)I
    .locals 2
    .param p1, "positionHolder"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 132
    iget-object v0, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/Extractor;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorInput:Landroidx/media3/extractor/ExtractorInput;

    .line 133
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/extractor/ExtractorInput;

    invoke-interface {v0, v1, p1}, Landroidx/media3/extractor/Extractor;->read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I

    move-result v0

    .line 132
    return v0
.end method

.method public release()V
    .locals 2

    .line 102
    iget-object v0, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 103
    invoke-interface {v0}, Landroidx/media3/extractor/Extractor;->release()V

    .line 104
    iput-object v1, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    .line 106
    :cond_0
    iput-object v1, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractorInput:Landroidx/media3/extractor/ExtractorInput;

    .line 107
    return-void
.end method

.method public seek(JJ)V
    .locals 1
    .param p1, "position"    # J
    .param p3, "seekTimeUs"    # J

    .line 127
    iget-object v0, p0, Landroidx/media3/exoplayer/source/BundledExtractorsAdapter;->extractor:Landroidx/media3/extractor/Extractor;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/Extractor;

    invoke-interface {v0, p1, p2, p3, p4}, Landroidx/media3/extractor/Extractor;->seek(JJ)V

    .line 128
    return-void
.end method
