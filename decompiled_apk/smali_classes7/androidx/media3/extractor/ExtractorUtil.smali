.class public final Landroidx/media3/extractor/ExtractorUtil;
.super Ljava/lang/Object;
.source "ExtractorUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkContainerInput(ZLjava/lang/String;)V
    .locals 1
    .param p0, "expression"    # Z
    .param p1, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .annotation runtime Lorg/checkerframework/dataflow/qual/Pure;
    .end annotation

    .line 37
    if-eqz p0, :cond_0

    .line 40
    return-void

    .line 38
    :cond_0
    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method public static peekFullyQuietly(Landroidx/media3/extractor/ExtractorInput;[BIIZ)Z
    .locals 2
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "output"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .param p4, "allowEndOfInput"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 115
    :try_start_0
    invoke-interface {p0, p1, p2, p3, p4}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v0
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    return v0

    .line 116
    :catch_0
    move-exception v0

    .line 117
    .local v0, "e":Ljava/io/EOFException;
    if-eqz p4, :cond_0

    .line 118
    const/4 v1, 0x0

    return v1

    .line 120
    :cond_0
    throw v0
.end method

.method public static peekToLength(Landroidx/media3/extractor/ExtractorInput;[BII)I
    .locals 3
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "target"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 57
    const/4 v0, 0x0

    .line 58
    .local v0, "totalBytesPeeked":I
    :goto_0
    if-ge v0, p3, :cond_1

    .line 59
    add-int v1, p2, v0

    sub-int v2, p3, v0

    invoke-interface {p0, p1, v1, v2}, Landroidx/media3/extractor/ExtractorInput;->peek([BII)I

    move-result v1

    .line 60
    .local v1, "bytesPeeked":I
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 61
    goto :goto_1

    .line 63
    :cond_0
    add-int/2addr v0, v1

    .line 64
    .end local v1    # "bytesPeeked":I
    goto :goto_0

    .line 65
    :cond_1
    :goto_1
    return v0
.end method

.method public static readFullyQuietly(Landroidx/media3/extractor/ExtractorInput;[BII)Z
    .locals 2
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "output"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 76
    :try_start_0
    invoke-interface {p0, p1, p2, p3}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    .line 79
    nop

    .line 80
    const/4 v0, 0x1

    return v0

    .line 77
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/io/EOFException;
    const/4 v1, 0x0

    return v1
.end method

.method public static skipFullyQuietly(Landroidx/media3/extractor/ExtractorInput;I)Z
    .locals 2
    .param p0, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 90
    :try_start_0
    invoke-interface {p0, p1}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V
    :try_end_0
    .catch Ljava/io/EOFException; {:try_start_0 .. :try_end_0} :catch_0

    .line 93
    nop

    .line 94
    const/4 v0, 0x1

    return v0

    .line 91
    :catch_0
    move-exception v0

    .line 92
    .local v0, "e":Ljava/io/EOFException;
    const/4 v1, 0x0

    return v1
.end method
