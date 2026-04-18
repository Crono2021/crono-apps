.class public final Landroidx/media3/extractor/Id3Peeker;
.super Ljava/lang/Object;
.source "Id3Peeker.java"


# instance fields
.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 37
    return-void
.end method


# virtual methods
.method public peekId3Data(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;)Landroidx/media3/common/Metadata;
    .locals 8
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "id3FramePredicate"    # Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 53
    const/4 v0, 0x0

    .line 54
    .local v0, "peekedId3Bytes":I
    const/4 v1, 0x0

    .line 57
    .local v1, "metadata":Landroidx/media3/common/Metadata;
    :goto_0
    :try_start_0
    iget-object v2, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    const/16 v3, 0xa

    const/4 v4, 0x0

    invoke-interface {p1, v2, v4, v3}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    .line 61
    nop

    .line 62
    iget-object v2, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v2, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 63
    iget-object v2, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt24()I

    move-result v2

    const v5, 0x494433

    if-eq v2, v5, :cond_0

    .line 65
    goto :goto_2

    .line 67
    :cond_0
    iget-object v2, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v5, 0x3

    invoke-virtual {v2, v5}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 68
    iget-object v2, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readSynchSafeInt()I

    move-result v2

    .line 69
    .local v2, "framesLength":I
    add-int/lit8 v5, v2, 0xa

    .line 71
    .local v5, "tagLength":I
    if-nez v1, :cond_1

    .line 72
    new-array v6, v5, [B

    .line 73
    .local v6, "id3Data":[B
    iget-object v7, p0, Landroidx/media3/extractor/Id3Peeker;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    invoke-static {v7, v4, v6, v4, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 74
    invoke-interface {p1, v6, v3, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 76
    new-instance v3, Landroidx/media3/extractor/metadata/id3/Id3Decoder;

    invoke-direct {v3, p2}, Landroidx/media3/extractor/metadata/id3/Id3Decoder;-><init>(Landroidx/media3/extractor/metadata/id3/Id3Decoder$FramePredicate;)V

    invoke-virtual {v3, v6, v5}, Landroidx/media3/extractor/metadata/id3/Id3Decoder;->decode([BI)Landroidx/media3/common/Metadata;

    move-result-object v1

    .line 77
    .end local v6    # "id3Data":[B
    goto :goto_1

    .line 78
    :cond_1
    invoke-interface {p1, v2}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 81
    :goto_1
    add-int/2addr v0, v5

    .line 82
    .end local v2    # "framesLength":I
    .end local v5    # "tagLength":I
    goto :goto_0

    .line 58
    :catch_0
    move-exception v2

    .line 60
    .local v2, "e":Ljava/io/EOFException;
    nop

    .line 84
    .end local v2    # "e":Ljava/io/EOFException;
    :goto_2
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 85
    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 86
    return-object v1
.end method
