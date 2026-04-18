.class final Landroidx/media3/extractor/avi/StreamFormatChunk;
.super Ljava/lang/Object;
.source "StreamFormatChunk.java"

# interfaces
.implements Landroidx/media3/extractor/avi/AviChunk;


# static fields
.field private static final TAG:Ljava/lang/String; = "StreamFormatChunk"


# instance fields
.field public final format:Landroidx/media3/common/Format;


# direct methods
.method public constructor <init>(Landroidx/media3/common/Format;)V
    .locals 0
    .param p1, "format"    # Landroidx/media3/common/Format;

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Landroidx/media3/extractor/avi/StreamFormatChunk;->format:Landroidx/media3/common/Format;

    .line 49
    return-void
.end method

.method private static getMimeTypeFromCompression(I)Ljava/lang/String;
    .locals 1
    .param p0, "compression"    # I

    .line 126
    sparse-switch p0, :sswitch_data_0

    .line 147
    const/4 v0, 0x0

    return-object v0

    .line 145
    :sswitch_0
    const-string/jumbo v0, "video/mjpeg"

    return-object v0

    .line 130
    :sswitch_1
    const-string/jumbo v0, "video/mp43"

    return-object v0

    .line 128
    :sswitch_2
    const-string/jumbo v0, "video/mp42"

    return-object v0

    .line 134
    :sswitch_3
    const-string/jumbo v0, "video/avc"

    return-object v0

    .line 142
    :sswitch_4
    const-string/jumbo v0, "video/mp4v-es"

    return-object v0

    nop

    :sswitch_data_0
    .sparse-switch
        0x30355844 -> :sswitch_4
        0x31435641 -> :sswitch_3
        0x31637661 -> :sswitch_3
        0x3234504d -> :sswitch_2
        0x3334504d -> :sswitch_1
        0x34363248 -> :sswitch_3
        0x34504d46 -> :sswitch_4
        0x44495633 -> :sswitch_4
        0x44495658 -> :sswitch_4
        0x47504a4d -> :sswitch_0
        0x58564944 -> :sswitch_4
        0x64697678 -> :sswitch_4
        0x67706a6d -> :sswitch_0
        0x78766964 -> :sswitch_4
    .end sparse-switch
.end method

.method private static getMimeTypeFromTag(I)Ljava/lang/String;
    .locals 1
    .param p0, "tag"    # I

    .line 108
    sparse-switch p0, :sswitch_data_0

    .line 120
    const/4 v0, 0x0

    return-object v0

    .line 118
    :sswitch_0
    const-string v0, "audio/vnd.dts"

    return-object v0

    .line 116
    :sswitch_1
    const-string v0, "audio/ac3"

    return-object v0

    .line 114
    :sswitch_2
    const-string v0, "audio/mp4a-latm"

    return-object v0

    .line 112
    :sswitch_3
    const-string v0, "audio/mpeg"

    return-object v0

    .line 110
    :sswitch_4
    const-string v0, "audio/raw"

    return-object v0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_4
        0x55 -> :sswitch_3
        0xff -> :sswitch_2
        0x2000 -> :sswitch_1
        0x2001 -> :sswitch_0
    .end sparse-switch
.end method

.method private static parseBitmapInfoHeader(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/AviChunk;
    .locals 7
    .param p0, "body"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 58
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 59
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v1

    .line 60
    .local v1, "width":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v2

    .line 61
    .local v2, "height":I
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 62
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v0

    .line 63
    .local v0, "compression":I
    invoke-static {v0}, Landroidx/media3/extractor/avi/StreamFormatChunk;->getMimeTypeFromCompression(I)Ljava/lang/String;

    move-result-object v3

    .line 64
    .local v3, "mimeType":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 65
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Ignoring track with unsupported compression "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "StreamFormatChunk"

    invoke-static {v5, v4}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    const/4 v4, 0x0

    return-object v4

    .line 68
    :cond_0
    new-instance v4, Landroidx/media3/common/Format$Builder;

    invoke-direct {v4}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 69
    .local v4, "formatBuilder":Landroidx/media3/common/Format$Builder;
    invoke-virtual {v4, v1}, Landroidx/media3/common/Format$Builder;->setWidth(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroidx/media3/common/Format$Builder;->setHeight(I)Landroidx/media3/common/Format$Builder;

    move-result-object v5

    invoke-virtual {v5, v3}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    .line 70
    new-instance v5, Landroidx/media3/extractor/avi/StreamFormatChunk;

    invoke-virtual {v4}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v6

    invoke-direct {v5, v6}, Landroidx/media3/extractor/avi/StreamFormatChunk;-><init>(Landroidx/media3/common/Format;)V

    return-object v5
.end method

.method public static parseFrom(ILandroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/AviChunk;
    .locals 2
    .param p0, "trackType"    # I
    .param p1, "body"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 33
    const/4 v0, 0x2

    if-ne p0, v0, :cond_0

    .line 34
    invoke-static {p1}, Landroidx/media3/extractor/avi/StreamFormatChunk;->parseBitmapInfoHeader(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v0

    return-object v0

    .line 35
    :cond_0
    const/4 v0, 0x1

    if-ne p0, v0, :cond_1

    .line 36
    invoke-static {p1}, Landroidx/media3/extractor/avi/StreamFormatChunk;->parseWaveFormatEx(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/AviChunk;

    move-result-object v0

    return-object v0

    .line 38
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Ignoring strf box for unsupported track type: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 40
    invoke-static {p0}, Landroidx/media3/common/util/Util;->getTrackTypeString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 38
    const-string v1, "StreamFormatChunk"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const/4 v0, 0x0

    return-object v0
.end method

.method private static parseWaveFormatEx(Landroidx/media3/common/util/ParsableByteArray;)Landroidx/media3/extractor/avi/AviChunk;
    .locals 11
    .param p0, "body"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 77
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v0

    .line 78
    .local v0, "formatTag":I
    invoke-static {v0}, Landroidx/media3/extractor/avi/StreamFormatChunk;->getMimeTypeFromTag(I)Ljava/lang/String;

    move-result-object v1

    .line 79
    .local v1, "mimeType":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 80
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Ignoring track with unsupported format tag "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "StreamFormatChunk"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const/4 v2, 0x0

    return-object v2

    .line 83
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v2

    .line 84
    .local v2, "channelCount":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianInt()I

    move-result v3

    .line 85
    .local v3, "samplesPerSecond":I
    const/4 v4, 0x6

    invoke-virtual {p0, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 86
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v4

    .line 87
    .local v4, "bitsPerSample":I
    invoke-static {v4}, Landroidx/media3/common/util/Util;->getPcmEncoding(I)I

    move-result v5

    .line 88
    .local v5, "pcmEncoding":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readLittleEndianUnsignedShort()I

    move-result v6

    .line 89
    .local v6, "cbSize":I
    new-array v7, v6, [B

    .line 90
    .local v7, "codecData":[B
    const/4 v8, 0x0

    array-length v9, v7

    invoke-virtual {p0, v7, v8, v9}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 92
    new-instance v8, Landroidx/media3/common/Format$Builder;

    invoke-direct {v8}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 93
    .local v8, "formatBuilder":Landroidx/media3/common/Format$Builder;
    nop

    .line 94
    invoke-virtual {v8, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    .line 95
    invoke-virtual {v9, v2}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v9

    .line 96
    invoke-virtual {v9, v3}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    .line 97
    const-string v9, "audio/raw"

    invoke-virtual {v9, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    if-eqz v5, :cond_1

    .line 98
    invoke-virtual {v8, v5}, Landroidx/media3/common/Format$Builder;->setPcmEncoding(I)Landroidx/media3/common/Format$Builder;

    .line 100
    :cond_1
    const-string v9, "audio/mp4a-latm"

    invoke-virtual {v9, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_2

    array-length v9, v7

    if-lez v9, :cond_2

    .line 101
    invoke-static {v7}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroidx/media3/common/Format$Builder;->setInitializationData(Ljava/util/List;)Landroidx/media3/common/Format$Builder;

    .line 103
    :cond_2
    new-instance v9, Landroidx/media3/extractor/avi/StreamFormatChunk;

    invoke-virtual {v8}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v10

    invoke-direct {v9, v10}, Landroidx/media3/extractor/avi/StreamFormatChunk;-><init>(Landroidx/media3/common/Format;)V

    return-object v9
.end method


# virtual methods
.method public getType()I
    .locals 1

    .line 53
    const v0, 0x66727473

    return v0
.end method
