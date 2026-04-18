.class final Landroidx/media3/exoplayer/source/IcyDataSource;
.super Ljava/lang/Object;
.source "IcyDataSource.java"

# interfaces
.implements Landroidx/media3/datasource/DataSource;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/IcyDataSource$Listener;
    }
.end annotation


# instance fields
.field private bytesUntilMetadata:I

.field private final listener:Landroidx/media3/exoplayer/source/IcyDataSource$Listener;

.field private final metadataIntervalBytes:I

.field private final metadataLengthByteHolder:[B

.field private final upstream:Landroidx/media3/datasource/DataSource;


# direct methods
.method public constructor <init>(Landroidx/media3/datasource/DataSource;ILandroidx/media3/exoplayer/source/IcyDataSource$Listener;)V
    .locals 2
    .param p1, "upstream"    # Landroidx/media3/datasource/DataSource;
    .param p2, "metadataIntervalBytes"    # I
    .param p3, "listener"    # Landroidx/media3/exoplayer/source/IcyDataSource$Listener;

    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 62
    const/4 v0, 0x1

    if-lez p2, :cond_0

    move v1, v0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 63
    iput-object p1, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    .line 64
    iput p2, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->metadataIntervalBytes:I

    .line 65
    iput-object p3, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->listener:Landroidx/media3/exoplayer/source/IcyDataSource$Listener;

    .line 66
    new-array v0, v0, [B

    iput-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->metadataLengthByteHolder:[B

    .line 67
    iput p2, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    .line 68
    return-void
.end method

.method private readMetadata()Z
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 121
    iget-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->metadataLengthByteHolder:[B

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-interface {v0, v1, v2, v3}, Landroidx/media3/datasource/DataSource;->read([BII)I

    move-result v0

    .line 122
    .local v0, "bytesRead":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 123
    return v2

    .line 125
    :cond_0
    iget-object v4, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->metadataLengthByteHolder:[B

    aget-byte v4, v4, v2

    and-int/lit16 v4, v4, 0xff

    shl-int/lit8 v4, v4, 0x4

    .line 126
    .local v4, "metadataLength":I
    if-nez v4, :cond_1

    .line 127
    return v3

    .line 130
    :cond_1
    const/4 v5, 0x0

    .line 131
    .local v5, "offset":I
    move v6, v4

    .line 132
    .local v6, "lengthRemaining":I
    new-array v7, v4, [B

    .line 133
    .local v7, "metadata":[B
    :goto_0
    if-lez v6, :cond_3

    .line 134
    iget-object v8, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    invoke-interface {v8, v7, v5, v6}, Landroidx/media3/datasource/DataSource;->read([BII)I

    move-result v0

    .line 135
    if-ne v0, v1, :cond_2

    .line 136
    return v2

    .line 138
    :cond_2
    add-int/2addr v5, v0

    .line 139
    sub-int/2addr v6, v0

    goto :goto_0

    .line 143
    :cond_3
    :goto_1
    if-lez v4, :cond_4

    add-int/lit8 v1, v4, -0x1

    aget-byte v1, v7, v1

    if-nez v1, :cond_4

    .line 144
    add-int/lit8 v4, v4, -0x1

    goto :goto_1

    .line 147
    :cond_4
    if-lez v4, :cond_5

    .line 148
    iget-object v1, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->listener:Landroidx/media3/exoplayer/source/IcyDataSource$Listener;

    new-instance v2, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v2, v7, v4}, Landroidx/media3/common/util/ParsableByteArray;-><init>([BI)V

    invoke-interface {v1, v2}, Landroidx/media3/exoplayer/source/IcyDataSource$Listener;->onIcyMetadata(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 150
    :cond_5
    return v3
.end method


# virtual methods
.method public addTransferListener(Landroidx/media3/datasource/TransferListener;)V
    .locals 1
    .param p1, "transferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 72
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    iget-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0, p1}, Landroidx/media3/datasource/DataSource;->addTransferListener(Landroidx/media3/datasource/TransferListener;)V

    .line 74
    return-void
.end method

.method public close()V
    .locals 1

    .line 110
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getResponseHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .line 105
    iget-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0}, Landroidx/media3/datasource/DataSource;->getResponseHeaders()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .line 100
    iget-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    invoke-interface {v0}, Landroidx/media3/datasource/DataSource;->getUri()Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public open(Landroidx/media3/datasource/DataSpec;)J
    .locals 1
    .param p1, "dataSpec"    # Landroidx/media3/datasource/DataSpec;

    .line 78
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public read([BII)I
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 83
    iget v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    const/4 v1, -0x1

    if-nez v0, :cond_1

    .line 84
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/IcyDataSource;->readMetadata()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 85
    iget v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->metadataIntervalBytes:I

    iput v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    goto :goto_0

    .line 87
    :cond_0
    return v1

    .line 90
    :cond_1
    :goto_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->upstream:Landroidx/media3/datasource/DataSource;

    iget v2, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    invoke-static {v2, p3}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-interface {v0, p1, p2, v2}, Landroidx/media3/datasource/DataSource;->read([BII)I

    move-result v0

    .line 91
    .local v0, "bytesRead":I
    if-eq v0, v1, :cond_2

    .line 92
    iget v1, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    sub-int/2addr v1, v0

    iput v1, p0, Landroidx/media3/exoplayer/source/IcyDataSource;->bytesUntilMetadata:I

    .line 94
    :cond_2
    return v0
.end method
