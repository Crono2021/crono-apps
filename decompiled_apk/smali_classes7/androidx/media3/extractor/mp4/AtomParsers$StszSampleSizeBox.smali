.class final Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;
.super Ljava/lang/Object;
.source "AtomParsers.java"

# interfaces
.implements Landroidx/media3/extractor/mp4/AtomParsers$SampleSizeBox;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/mp4/AtomParsers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "StszSampleSizeBox"
.end annotation


# instance fields
.field private final data:Landroidx/media3/common/util/ParsableByteArray;

.field private final fixedSampleSize:I

.field private final sampleCount:I


# direct methods
.method public constructor <init>(Landroidx/media3/extractor/mp4/Atom$LeafAtom;Landroidx/media3/common/Format;)V
    .locals 5
    .param p1, "stszAtom"    # Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .param p2, "trackFormat"    # Landroidx/media3/common/Format;

    .line 2243
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2244
    iget-object v0, p1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    iput-object v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 2245
    const/16 v1, 0xc

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 2246
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v1

    .line 2247
    .local v1, "fixedSampleSize":I
    const-string v2, "audio/raw"

    iget-object v3, p2, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2248
    iget v2, p2, Landroidx/media3/common/Format;->pcmEncoding:I

    iget v3, p2, Landroidx/media3/common/Format;->channelCount:I

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->getPcmFrameSize(II)I

    move-result v2

    .line 2249
    .local v2, "pcmFrameSize":I
    if-eqz v1, :cond_0

    rem-int v3, v1, v2

    if-eqz v3, :cond_1

    .line 2253
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Audio sample size mismatch. stsd sample size: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", stsz sample size: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "AtomParsers"

    invoke-static {v4, v3}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2259
    move v1, v2

    .line 2262
    .end local v2    # "pcmFrameSize":I
    :cond_1
    if-nez v1, :cond_2

    const/4 v2, -0x1

    goto :goto_0

    :cond_2
    move v2, v1

    :goto_0
    iput v2, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->fixedSampleSize:I

    .line 2263
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->sampleCount:I

    .line 2264
    return-void
.end method


# virtual methods
.method public getFixedSampleSize()I
    .locals 1

    .line 2273
    iget v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->fixedSampleSize:I

    return v0
.end method

.method public getSampleCount()I
    .locals 1

    .line 2268
    iget v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->sampleCount:I

    return v0
.end method

.method public readNextSampleSize()I
    .locals 2

    .line 2278
    iget v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->fixedSampleSize:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$StszSampleSizeBox;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    :cond_0
    return v0
.end method
