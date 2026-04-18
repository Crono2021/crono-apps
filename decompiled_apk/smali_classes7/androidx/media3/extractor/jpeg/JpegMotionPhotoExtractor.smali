.class final Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;
.super Ljava/lang/Object;
.source "JpegMotionPhotoExtractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# static fields
.field private static final EXIF_HEADER:J = 0x45786966L

.field private static final EXIF_ID_CODE_LENGTH:I = 0x6

.field private static final HEADER_XMP_APP1:Ljava/lang/String; = "http://ns.adobe.com/xap/1.0/"

.field private static final MARKER_APP0:I = 0xffe0

.field private static final MARKER_APP1:I = 0xffe1

.field private static final MARKER_SOI:I = 0xffd8

.field private static final MARKER_SOS:I = 0xffda

.field private static final STATE_ENDED:I = 0x6

.field private static final STATE_READING_MARKER:I = 0x0

.field private static final STATE_READING_MOTION_PHOTO_VIDEO:I = 0x5

.field private static final STATE_READING_SEGMENT:I = 0x2

.field private static final STATE_READING_SEGMENT_LENGTH:I = 0x1

.field private static final STATE_SNIFFING_MOTION_PHOTO_VIDEO:I = 0x4


# instance fields
.field private extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private lastExtractorInput:Landroidx/media3/extractor/ExtractorInput;

.field private marker:I

.field private motionPhotoMetadata:Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

.field private mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

.field private mp4ExtractorStartOffsetExtractorInput:Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

.field private mp4StartPosition:J

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private segmentLength:I

.field private state:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 96
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    .line 97
    return-void
.end method

.method private advancePeekPositionToNextSegment(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 3
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 191
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 192
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 193
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    sub-int/2addr v0, v1

    .line 194
    .local v0, "segmentLength":I
    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 195
    return-void
.end method

.method private endReading()V
    .locals 4

    .line 271
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v0}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 272
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v1, Landroidx/media3/extractor/SeekMap$Unseekable;

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 273
    const/4 v0, 0x6

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 274
    return-void
.end method

.method private static getMotionPhotoMetadata(Ljava/lang/String;J)Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;
    .locals 2
    .param p0, "xmpString"    # Ljava/lang/String;
    .param p1, "inputLength"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 303
    const-wide/16 v0, -0x1

    cmp-long v0, p1, v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 304
    return-object v1

    .line 309
    :cond_0
    nop

    .line 310
    invoke-static {p0}, Landroidx/media3/extractor/jpeg/XmpMotionPhotoDescriptionParser;->parse(Ljava/lang/String;)Landroidx/media3/extractor/jpeg/MotionPhotoDescription;

    move-result-object v0

    .line 311
    .local v0, "motionPhotoDescription":Landroidx/media3/extractor/jpeg/MotionPhotoDescription;
    if-nez v0, :cond_1

    .line 312
    return-object v1

    .line 314
    :cond_1
    invoke-virtual {v0, p1, p2}, Landroidx/media3/extractor/jpeg/MotionPhotoDescription;->getMotionPhotoMetadata(J)Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    move-result-object v1

    return-object v1
.end method

.method private outputImageTrack(Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;)V
    .locals 5
    .param p1, "motionPhotoMetadata"    # Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    .line 277
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 278
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/ExtractorOutput;

    const/16 v1, 0x400

    const/4 v2, 0x4

    invoke-interface {v0, v1, v2}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    .line 279
    .local v0, "imageTrackOutput":Landroidx/media3/extractor/TrackOutput;
    new-instance v1, Landroidx/media3/common/Format$Builder;

    invoke-direct {v1}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 281
    const-string v2, "image/jpeg"

    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setContainerMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    new-instance v2, Landroidx/media3/common/Metadata;

    const/4 v3, 0x1

    new-array v3, v3, [Landroidx/media3/common/Metadata$Entry;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-direct {v2, v3}, Landroidx/media3/common/Metadata;-><init>([Landroidx/media3/common/Metadata$Entry;)V

    .line 282
    invoke-virtual {v1, v2}, Landroidx/media3/common/Format$Builder;->setMetadata(Landroidx/media3/common/Metadata;)Landroidx/media3/common/Format$Builder;

    move-result-object v1

    .line 283
    invoke-virtual {v1}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v1

    .line 279
    invoke-interface {v0, v1}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 284
    return-void
.end method

.method private peekMarker(Landroidx/media3/extractor/ExtractorInput;)I
    .locals 3
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 185
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 186
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 187
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    return v0
.end method

.method private readMarker(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 4
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 198
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 199
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 200
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->marker:I

    .line 201
    const v1, 0xffda

    if-ne v0, v1, :cond_1

    .line 202
    iget-wide v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 203
    const/4 v0, 0x4

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    goto :goto_0

    .line 205
    :cond_0
    invoke-direct {p0}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->endReading()V

    goto :goto_0

    .line 207
    :cond_1
    const v1, 0xffd0

    if-lt v0, v1, :cond_2

    const v1, 0xffd9

    if-le v0, v1, :cond_3

    :cond_2
    const v1, 0xff01

    if-eq v0, v1, :cond_3

    .line 208
    const/4 v0, 0x1

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 210
    :cond_3
    :goto_0
    return-void
.end method

.method private readSegment(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 220
    iget v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->marker:I

    const v1, 0xffe1

    const/4 v2, 0x0

    if-ne v0, v1, :cond_1

    .line 221
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    iget v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->segmentLength:I

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 222
    .local v0, "payload":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v1

    iget v3, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->segmentLength:I

    invoke-interface {p1, v1, v2, v3}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 223
    iget-object v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->motionPhotoMetadata:Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    if-nez v1, :cond_0

    .line 224
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v1

    const-string v3, "http://ns.adobe.com/xap/1.0/"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 225
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v1

    .line 226
    .local v1, "xmpString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 227
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v3

    invoke-static {v1, v3, v4}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->getMotionPhotoMetadata(Ljava/lang/String;J)Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    move-result-object v3

    iput-object v3, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->motionPhotoMetadata:Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    .line 228
    if-eqz v3, :cond_0

    .line 229
    iget-wide v3, v3, Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;->videoStartPosition:J

    iput-wide v3, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    .line 233
    .end local v0    # "payload":Landroidx/media3/common/util/ParsableByteArray;
    .end local v1    # "xmpString":Ljava/lang/String;
    :cond_0
    goto :goto_0

    .line 234
    :cond_1
    iget v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->segmentLength:I

    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 236
    :goto_0
    iput v2, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 237
    return-void
.end method

.method private readSegmentLength(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 3
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 213
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 214
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 215
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    sub-int/2addr v0, v1

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->segmentLength:I

    .line 216
    iput v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 217
    return-void
.end method

.method private sniffMotionPhotoVideo(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 6
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 241
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 243
    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 242
    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-interface {p1, v0, v1, v2, v2}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BIIZ)Z

    move-result v0

    .line 244
    .local v0, "peekedData":Z
    if-nez v0, :cond_0

    .line 245
    invoke-direct {p0}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->endReading()V

    goto :goto_0

    .line 247
    :cond_0
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->resetPeekPosition()V

    .line 248
    iget-object v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    if-nez v1, :cond_1

    .line 249
    new-instance v1, Landroidx/media3/extractor/mp4/Mp4Extractor;

    sget-object v2, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    const/16 v3, 0x8

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/mp4/Mp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V

    iput-object v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    .line 253
    :cond_1
    new-instance v1, Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    iget-wide v2, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    invoke-direct {v1, p1, v2, v3}, Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;-><init>(Landroidx/media3/extractor/ExtractorInput;J)V

    iput-object v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4ExtractorStartOffsetExtractorInput:Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    .line 255
    iget-object v2, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    invoke-virtual {v2, v1}, Landroidx/media3/extractor/mp4/Mp4Extractor;->sniff(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 256
    iget-object v1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    new-instance v2, Landroidx/media3/extractor/jpeg/StartOffsetExtractorOutput;

    iget-wide v3, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    iget-object v5, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 257
    invoke-static {v5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/ExtractorOutput;

    invoke-direct {v2, v3, v4, v5}, Landroidx/media3/extractor/jpeg/StartOffsetExtractorOutput;-><init>(JLandroidx/media3/extractor/ExtractorOutput;)V

    .line 256
    invoke-virtual {v1, v2}, Landroidx/media3/extractor/mp4/Mp4Extractor;->init(Landroidx/media3/extractor/ExtractorOutput;)V

    .line 258
    invoke-direct {p0}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->startReadingMotionPhoto()V

    goto :goto_0

    .line 260
    :cond_2
    invoke-direct {p0}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->endReading()V

    .line 263
    :goto_0
    return-void
.end method

.method private startReadingMotionPhoto()V
    .locals 1

    .line 266
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->motionPhotoMetadata:Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;

    invoke-direct {p0, v0}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->outputImageTrack(Landroidx/media3/extractor/metadata/mp4/MotionPhotoMetadata;)V

    .line 267
    const/4 v0, 0x5

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 268
    return-void
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 0
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 124
    iput-object p1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 125
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 7
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 130
    iget v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    packed-switch v0, :pswitch_data_0

    .line 163
    :pswitch_0
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 161
    :pswitch_1
    const/4 v0, -0x1

    return v0

    .line 148
    :pswitch_2
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4ExtractorStartOffsetExtractorInput:Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->lastExtractorInput:Landroidx/media3/extractor/ExtractorInput;

    if-eq p1, v0, :cond_1

    .line 149
    :cond_0
    iput-object p1, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->lastExtractorInput:Landroidx/media3/extractor/ExtractorInput;

    .line 150
    new-instance v0, Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    iget-wide v2, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    invoke-direct {v0, p1, v2, v3}, Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;-><init>(Landroidx/media3/extractor/ExtractorInput;J)V

    iput-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4ExtractorStartOffsetExtractorInput:Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    .line 154
    :cond_1
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    .line 155
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Mp4Extractor;

    iget-object v2, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4ExtractorStartOffsetExtractorInput:Landroidx/media3/extractor/jpeg/StartOffsetExtractorInput;

    invoke-virtual {v0, v2, p2}, Landroidx/media3/extractor/mp4/Mp4Extractor;->read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I

    move-result v0

    .line 156
    .local v0, "readResult":I
    if-ne v0, v1, :cond_2

    .line 157
    iget-wide v1, p2, Landroidx/media3/extractor/PositionHolder;->position:J

    iget-wide v3, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    add-long/2addr v1, v3

    iput-wide v1, p2, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 159
    :cond_2
    return v0

    .line 141
    .end local v0    # "readResult":I
    :pswitch_3
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v3

    iget-wide v5, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4StartPosition:J

    cmp-long v0, v3, v5

    if-eqz v0, :cond_3

    .line 142
    iput-wide v5, p2, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 143
    return v1

    .line 145
    :cond_3
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->sniffMotionPhotoVideo(Landroidx/media3/extractor/ExtractorInput;)V

    .line 146
    return v2

    .line 138
    :pswitch_4
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->readSegment(Landroidx/media3/extractor/ExtractorInput;)V

    .line 139
    return v2

    .line 135
    :pswitch_5
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->readSegmentLength(Landroidx/media3/extractor/ExtractorInput;)V

    .line 136
    return v2

    .line 132
    :pswitch_6
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->readMarker(Landroidx/media3/extractor/ExtractorInput;)V

    .line 133
    return v2

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public release()V
    .locals 1

    .line 179
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    if-eqz v0, :cond_0

    .line 180
    invoke-virtual {v0}, Landroidx/media3/extractor/mp4/Mp4Extractor;->release()V

    .line 182
    :cond_0
    return-void
.end method

.method public seek(JJ)V
    .locals 2
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 169
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    .line 170
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    .line 171
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    goto :goto_0

    .line 172
    :cond_0
    iget v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->state:I

    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    .line 173
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->mp4Extractor:Landroidx/media3/extractor/mp4/Mp4Extractor;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Mp4Extractor;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroidx/media3/extractor/mp4/Mp4Extractor;->seek(JJ)V

    .line 175
    :cond_1
    :goto_0
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 102
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->peekMarker(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    const v1, 0xffd8

    const/4 v2, 0x0

    if-eq v0, v1, :cond_0

    .line 103
    return v2

    .line 105
    :cond_0
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->peekMarker(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->marker:I

    .line 109
    const v1, 0xffe0

    if-ne v0, v1, :cond_1

    .line 110
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->advancePeekPositionToNextSegment(Landroidx/media3/extractor/ExtractorInput;)V

    .line 111
    invoke-direct {p0, p1}, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->peekMarker(Landroidx/media3/extractor/ExtractorInput;)I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->marker:I

    .line 113
    :cond_1
    iget v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->marker:I

    const v1, 0xffe1

    if-eq v0, v1, :cond_2

    .line 114
    return v2

    .line 116
    :cond_2
    const/4 v0, 0x2

    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->advancePeekPosition(I)V

    .line 117
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 118
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 119
    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v0

    const-wide/32 v3, 0x45786966    # 5.758429993E-315

    cmp-long v0, v0, v3

    if-nez v0, :cond_3

    iget-object v0, p0, Landroidx/media3/extractor/jpeg/JpegMotionPhotoExtractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v0

    if-nez v0, :cond_3

    const/4 v2, 0x1

    :cond_3
    return v2
.end method
