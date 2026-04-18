.class public Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;
.super Ljava/lang/Object;
.source "FragmentedMp4Extractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;,
        Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;,
        Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$Flags;
    }
.end annotation


# static fields
.field private static final EMSG_FORMAT:Landroidx/media3/common/Format;

.field private static final EXTRA_TRACKS_BASE_ID:I = 0x64

.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_EMIT_RAW_SUBTITLE_DATA:I = 0x20

.field public static final FLAG_ENABLE_EMSG_TRACK:I = 0x4

.field public static final FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME:I = 0x1

.field public static final FLAG_WORKAROUND_IGNORE_EDIT_LISTS:I = 0x10

.field public static final FLAG_WORKAROUND_IGNORE_TFDT_BOX:I = 0x2

.field private static final PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE:[B

.field private static final SAMPLE_GROUP_TYPE_seig:I = 0x73656967

.field private static final STATE_READING_ATOM_HEADER:I = 0x0

.field private static final STATE_READING_ATOM_PAYLOAD:I = 0x1

.field private static final STATE_READING_ENCRYPTION_DATA:I = 0x2

.field private static final STATE_READING_SAMPLE_CONTINUE:I = 0x4

.field private static final STATE_READING_SAMPLE_START:I = 0x3

.field private static final TAG:Ljava/lang/String; = "FragmentedMp4Extractor"


# instance fields
.field private final additionalEmsgTrackOutput:Landroidx/media3/extractor/TrackOutput;

.field private atomData:Landroidx/media3/common/util/ParsableByteArray;

.field private final atomHeader:Landroidx/media3/common/util/ParsableByteArray;

.field private atomHeaderBytesRead:I

.field private atomSize:J

.field private atomType:I

.field private ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

.field private final closedCaptionFormats:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;"
        }
    .end annotation
.end field

.field private final containerAtoms:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque<",
            "Landroidx/media3/extractor/mp4/Atom$ContainerAtom;",
            ">;"
        }
    .end annotation
.end field

.field private currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

.field private durationUs:J

.field private emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

.field private endOfMdatPosition:J

.field private final eventMessageEncoder:Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;

.field private extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

.field private final flags:I

.field private haveOutputSeekMap:Z

.field private final nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

.field private final nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

.field private final nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

.field private parserState:I

.field private pendingMetadataSampleBytes:I

.field private final pendingMetadataSampleInfos:Ljava/util/ArrayDeque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayDeque<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;",
            ">;"
        }
    .end annotation
.end field

.field private pendingSeekTimeUs:J

.field private processSeiNalUnitPayload:Z

.field private sampleBytesWritten:I

.field private sampleCurrentNalBytesRemaining:I

.field private sampleSize:I

.field private final scratch:Landroidx/media3/common/util/ParsableByteArray;

.field private final scratchBytes:[B

.field private segmentIndexEarliestPresentationTimeUs:J

.field private final sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

.field private final subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

.field private final timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

.field private final trackBundles:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 135
    new-instance v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    .line 147
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE:[B

    .line 151
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 152
    const-string v1, "application/x-emsg"

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v0

    sput-object v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->EMSG_FORMAT:Landroidx/media3/common/Format;

    .line 151
    return-void

    :array_0
    .array-data 1
        -0x5et
        0x39t
        0x4ft
        0x52t
        0x5at
        -0x65t
        0x4ft
        0x14t
        -0x5et
        0x44t
        0x6ct
        0x42t
        0x7ct
        0x64t
        -0x73t
        -0xct
    .end array-data
.end method

.method public constructor <init>()V
    .locals 7
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 220
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    const/16 v2, 0x20

    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 225
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 220
    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 227
    return-void
.end method

.method public constructor <init>(I)V
    .locals 7
    .param p1, "flags"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 250
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    or-int/lit8 v2, p1, 0x20

    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 255
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 250
    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 257
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;)V
    .locals 7
    .param p1, "flags"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 282
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    or-int/lit8 v2, p1, 0x20

    const/4 v4, 0x0

    .line 287
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 282
    move-object v0, p0

    move-object v3, p2

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 289
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;)V
    .locals 7
    .param p1, "flags"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p3, "sideloadedTrack"    # Landroidx/media3/extractor/mp4/Track;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 300
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    or-int/lit8 v2, p1, 0x20

    .line 305
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 300
    move-object v0, p0

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 307
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;)V
    .locals 7
    .param p1, "flags"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p3, "sideloadedTrack"    # Landroidx/media3/extractor/mp4/Track;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/media3/common/util/TimestampAdjuster;",
            "Landroidx/media3/extractor/mp4/Track;",
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;)V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 319
    .local p4, "closedCaptionFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    or-int/lit8 v2, p1, 0x20

    const/4 v6, 0x0

    move-object v0, p0

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 326
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V
    .locals 7
    .param p1, "flags"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p3, "sideloadedTrack"    # Landroidx/media3/extractor/mp4/Track;
    .param p5, "additionalEmsgTrackOutput"    # Landroidx/media3/extractor/TrackOutput;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroidx/media3/common/util/TimestampAdjuster;",
            "Landroidx/media3/extractor/mp4/Track;",
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;",
            "Landroidx/media3/extractor/TrackOutput;",
            ")V"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 339
    .local p4, "closedCaptionFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    sget-object v1, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    or-int/lit8 v2, p1, 0x20

    move-object v0, p0

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 346
    return-void
.end method

.method public constructor <init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V
    .locals 7
    .param p1, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 236
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 241
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 236
    move-object v0, p0

    move-object v1, p1

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 243
    return-void
.end method

.method public constructor <init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V
    .locals 7
    .param p1, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;
    .param p2, "flags"    # I

    .line 267
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 272
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v5

    const/4 v6, 0x0

    .line 267
    move-object v0, p0

    move-object v1, p1

    move v2, p2

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V

    .line 274
    return-void
.end method

.method public constructor <init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/mp4/Track;Ljava/util/List;Landroidx/media3/extractor/TrackOutput;)V
    .locals 3
    .param p1, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;
    .param p2, "flags"    # I
    .param p3, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p4, "sideloadedTrack"    # Landroidx/media3/extractor/mp4/Track;
    .param p6, "additionalEmsgTrackOutput"    # Landroidx/media3/extractor/TrackOutput;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/text/SubtitleParser$Factory;",
            "I",
            "Landroidx/media3/common/util/TimestampAdjuster;",
            "Landroidx/media3/extractor/mp4/Track;",
            "Ljava/util/List<",
            "Landroidx/media3/common/Format;",
            ">;",
            "Landroidx/media3/extractor/TrackOutput;",
            ")V"
        }
    .end annotation

    .line 369
    .local p5, "closedCaptionFormats":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/Format;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 370
    iput-object p1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 371
    iput p2, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->flags:I

    .line 372
    iput-object p3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    .line 373
    iput-object p4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    .line 374
    invoke-static {p5}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->closedCaptionFormats:Ljava/util/List;

    .line 375
    iput-object p6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->additionalEmsgTrackOutput:Landroidx/media3/extractor/TrackOutput;

    .line 376
    new-instance v0, Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;

    invoke-direct {v0}, Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->eventMessageEncoder:Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;

    .line 377
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x10

    invoke-direct {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    .line 378
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    sget-object v2, Landroidx/media3/container/NalUnitUtil;->NAL_START_CODE:[B

    invoke-direct {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    .line 379
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/4 v2, 0x5

    invoke-direct {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

    .line 380
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v0}, Landroidx/media3/common/util/ParsableByteArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 381
    new-array v0, v1, [B

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->scratchBytes:[B

    .line 382
    new-instance v1, Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {v1, v0}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    iput-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    .line 383
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    .line 384
    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    .line 385
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    .line 386
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->durationUs:J

    .line 387
    iput-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingSeekTimeUs:J

    .line 388
    iput-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->segmentIndexEarliestPresentationTimeUs:J

    .line 389
    sget-object v0, Landroidx/media3/extractor/ExtractorOutput;->PLACEHOLDER:Landroidx/media3/extractor/ExtractorOutput;

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 390
    const/4 v0, 0x0

    new-array v1, v0, [Landroidx/media3/extractor/TrackOutput;

    iput-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    .line 391
    new-array v0, v0, [Landroidx/media3/extractor/TrackOutput;

    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    .line 392
    return-void
.end method

.method private static checkNonNegative(I)I
    .locals 2
    .param p0, "value"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1215
    if-ltz p0, :cond_0

    .line 1219
    return p0

    .line 1216
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unexpected negative value: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method private enterReadingAtomHeaderState()V
    .locals 1

    .line 471
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 472
    iput v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    .line 473
    return-void
.end method

.method private getDefaultSampleValues(Landroid/util/SparseArray;I)Landroidx/media3/extractor/mp4/DefaultSampleValues;
    .locals 2
    .param p2, "trackId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/DefaultSampleValues;",
            ">;I)",
            "Landroidx/media3/extractor/mp4/DefaultSampleValues;"
        }
    .end annotation

    .line 678
    .local p1, "defaultSampleValuesArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/DefaultSampleValues;>;"
    invoke-virtual {p1}, Landroid/util/SparseArray;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 681
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    return-object v0

    .line 683
    :cond_0
    invoke-virtual {p1, p2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    return-object v0
.end method

.method private static getDrmInitDataFromAtoms(Ljava/util/List;)Landroidx/media3/common/DrmInitData;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/extractor/mp4/Atom$LeafAtom;",
            ">;)",
            "Landroidx/media3/common/DrmInitData;"
        }
    .end annotation

    .line 1675
    .local p0, "leafChildren":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/mp4/Atom$LeafAtom;>;"
    const/4 v0, 0x0

    .line 1676
    .local v0, "schemeDatas":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroidx/media3/common/DrmInitData$SchemeData;>;"
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v1

    .line 1677
    .local v1, "leafChildrenSize":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_3

    .line 1678
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 1679
    .local v3, "child":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v4, v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v5, 0x70737368    # 3.013775E29f

    if-ne v4, v5, :cond_2

    .line 1680
    if-nez v0, :cond_0

    .line 1681
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move-object v0, v4

    .line 1683
    :cond_0
    iget-object v4, v3, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    .line 1684
    .local v4, "psshData":[B
    invoke-static {v4}, Landroidx/media3/extractor/mp4/PsshAtomUtil;->parseUuid([B)Ljava/util/UUID;

    move-result-object v5

    .line 1685
    .local v5, "uuid":Ljava/util/UUID;
    if-nez v5, :cond_1

    .line 1686
    const-string v6, "FragmentedMp4Extractor"

    const-string v7, "Skipped pssh atom (failed to extract uuid)"

    invoke-static {v6, v7}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 1688
    :cond_1
    new-instance v6, Landroidx/media3/common/DrmInitData$SchemeData;

    const-string/jumbo v7, "video/mp4"

    invoke-direct {v6, v5, v7, v4}, Landroidx/media3/common/DrmInitData$SchemeData;-><init>(Ljava/util/UUID;Ljava/lang/String;[B)V

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1677
    .end local v3    # "child":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v4    # "psshData":[B
    .end local v5    # "uuid":Ljava/util/UUID;
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 1692
    .end local v2    # "i":I
    :cond_3
    if-nez v0, :cond_4

    const/4 v2, 0x0

    goto :goto_2

    :cond_4
    new-instance v2, Landroidx/media3/common/DrmInitData;

    invoke-direct {v2, v0}, Landroidx/media3/common/DrmInitData;-><init>(Ljava/util/List;)V

    :goto_2
    return-object v2
.end method

.method private static getNextTrackBundle(Landroid/util/SparseArray;)Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;",
            ">;)",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;"
        }
    .end annotation

    .line 1650
    .local p0, "trackBundles":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;>;"
    const/4 v0, 0x0

    .line 1651
    .local v0, "nextTrackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    const-wide v1, 0x7fffffffffffffffL

    .line 1653
    .local v1, "nextSampleOffset":J
    invoke-virtual {p0}, Landroid/util/SparseArray;->size()I

    move-result v3

    .line 1654
    .local v3, "trackBundlesSize":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_3

    .line 1655
    invoke-virtual {p0, v4}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1656
    .local v5, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    invoke-static {v5}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->access$000(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;)Z

    move-result v6

    if-nez v6, :cond_0

    iget v6, v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentSampleIndex:I

    iget-object v7, v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget v7, v7, Landroidx/media3/extractor/mp4/TrackSampleTable;->sampleCount:I

    if-eq v6, v7, :cond_2

    .line 1658
    :cond_0
    invoke-static {v5}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->access$000(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;)Z

    move-result v6

    if-eqz v6, :cond_1

    iget v6, v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentTrackRunIndex:I

    iget-object v7, v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    iget v7, v7, Landroidx/media3/extractor/mp4/TrackFragment;->trunCount:I

    if-ne v6, v7, :cond_1

    goto :goto_1

    .line 1662
    :cond_1
    invoke-virtual {v5}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getCurrentSampleOffset()J

    move-result-wide v6

    .line 1663
    .local v6, "sampleOffset":J
    cmp-long v8, v6, v1

    if-gez v8, :cond_2

    .line 1664
    move-object v0, v5

    .line 1665
    move-wide v1, v6

    .line 1654
    .end local v5    # "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .end local v6    # "sampleOffset":J
    :cond_2
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1669
    .end local v4    # "i":I
    :cond_3
    return-object v0
.end method

.method private initExtraTracks()V
    .locals 7

    .line 707
    const/16 v0, 0x64

    .line 709
    .local v0, "nextExtraTrackId":I
    const/4 v1, 0x2

    new-array v1, v1, [Landroidx/media3/extractor/TrackOutput;

    iput-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    .line 710
    const/4 v2, 0x0

    .line 711
    .local v2, "emsgTrackOutputCount":I
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->additionalEmsgTrackOutput:Landroidx/media3/extractor/TrackOutput;

    if-eqz v3, :cond_0

    .line 712
    add-int/lit8 v4, v2, 0x1

    .end local v2    # "emsgTrackOutputCount":I
    .local v4, "emsgTrackOutputCount":I
    aput-object v3, v1, v2

    move v2, v4

    .line 714
    .end local v4    # "emsgTrackOutputCount":I
    .restart local v2    # "emsgTrackOutputCount":I
    :cond_0
    iget v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->flags:I

    and-int/lit8 v3, v3, 0x4

    if-eqz v3, :cond_1

    .line 715
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "emsgTrackOutputCount":I
    .local v3, "emsgTrackOutputCount":I
    iget-object v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    add-int/lit8 v5, v0, 0x1

    .line 716
    .end local v0    # "nextExtraTrackId":I
    .local v5, "nextExtraTrackId":I
    const/4 v6, 0x5

    invoke-interface {v4, v0, v6}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    aput-object v0, v1, v2

    move v2, v3

    move v0, v5

    .line 718
    .end local v3    # "emsgTrackOutputCount":I
    .end local v5    # "nextExtraTrackId":I
    .restart local v0    # "nextExtraTrackId":I
    .restart local v2    # "emsgTrackOutputCount":I
    :cond_1
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    invoke-static {v1, v2}, Landroidx/media3/common/util/Util;->nullSafeArrayCopy([Ljava/lang/Object;I)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Landroidx/media3/extractor/TrackOutput;

    iput-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    .line 719
    array-length v3, v1

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v3, :cond_2

    aget-object v5, v1, v4

    .line 720
    .local v5, "eventMessageTrackOutput":Landroidx/media3/extractor/TrackOutput;
    sget-object v6, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->EMSG_FORMAT:Landroidx/media3/common/Format;

    invoke-interface {v5, v6}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 719
    .end local v5    # "eventMessageTrackOutput":Landroidx/media3/extractor/TrackOutput;
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 723
    :cond_2
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->closedCaptionFormats:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Landroidx/media3/extractor/TrackOutput;

    iput-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    .line 724
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v3, v3

    if-ge v1, v3, :cond_3

    .line 725
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    add-int/lit8 v4, v0, 0x1

    .end local v0    # "nextExtraTrackId":I
    .local v4, "nextExtraTrackId":I
    const/4 v5, 0x3

    invoke-interface {v3, v0, v5}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v0

    .line 726
    .local v0, "output":Landroidx/media3/extractor/TrackOutput;
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->closedCaptionFormats:Ljava/util/List;

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/Format;

    invoke-interface {v0, v3}, Landroidx/media3/extractor/TrackOutput;->format(Landroidx/media3/common/Format;)V

    .line 727
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    aput-object v0, v3, v1

    .line 724
    .end local v0    # "output":Landroidx/media3/extractor/TrackOutput;
    add-int/lit8 v1, v1, 0x1

    move v0, v4

    goto :goto_1

    .line 729
    .end local v1    # "i":I
    .end local v4    # "nextExtraTrackId":I
    .local v0, "nextExtraTrackId":I
    :cond_3
    return-void
.end method

.method private static isEdtsListDurationForEntireMediaTimeline(Landroidx/media3/extractor/mp4/Track;)Z
    .locals 13
    .param p0, "track"    # Landroidx/media3/extractor/mp4/Track;

    .line 1101
    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    const/4 v1, 0x0

    if-eqz v0, :cond_3

    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    array-length v0, v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_3

    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    if-nez v0, :cond_0

    goto :goto_0

    .line 1106
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    aget-wide v3, v0, v1

    const-wide/16 v5, 0x0

    cmp-long v0, v3, v5

    if-nez v0, :cond_1

    .line 1107
    return v2

    .line 1109
    :cond_1
    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListDurations:[J

    aget-wide v3, v0, v1

    iget-object v0, p0, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    aget-wide v5, v0, v1

    add-long v7, v3, v5

    const-wide/32 v9, 0xf4240

    iget-wide v11, p0, Landroidx/media3/extractor/mp4/Track;->movieTimescale:J

    .line 1110
    invoke-static/range {v7 .. v12}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v3

    .line 1114
    .local v3, "editListEndMediaTimeUs":J
    iget-wide v5, p0, Landroidx/media3/extractor/mp4/Track;->durationUs:J

    cmp-long v0, v3, v5

    if-ltz v0, :cond_2

    move v1, v2

    :cond_2
    return v1

    .line 1104
    .end local v3    # "editListEndMediaTimeUs":J
    :cond_3
    :goto_0
    return v1
.end method

.method static synthetic lambda$newFactory$0(Landroidx/media3/extractor/text/SubtitleParser$Factory;)[Landroidx/media3/extractor/Extractor;
    .locals 3
    .param p0, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 82
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;

    invoke-direct {v1, p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method static synthetic lambda$static$1()[Landroidx/media3/extractor/Extractor;
    .locals 4

    .line 137
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;

    sget-object v2, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    const/16 v3, 0x20

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;I)V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method public static newFactory(Landroidx/media3/extractor/text/SubtitleParser$Factory;)Landroidx/media3/extractor/ExtractorsFactory;
    .locals 1
    .param p0, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 82
    new-instance v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda1;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    return-object v0
.end method

.method private onContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V
    .locals 2
    .param p1, "container"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 604
    iget v0, p1, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->type:I

    const v1, 0x6d6f6f76

    if-ne v0, v1, :cond_0

    .line 605
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->onMoovContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V

    goto :goto_0

    .line 606
    :cond_0
    iget v0, p1, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->type:I

    const v1, 0x6d6f6f66

    if-ne v0, v1, :cond_1

    .line 607
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->onMoofContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V

    goto :goto_0

    .line 608
    :cond_1
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 609
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    invoke-virtual {v0, p1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->add(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V

    .line 611
    :cond_2
    :goto_0
    return-void
.end method

.method private onEmsgLeafAtomRead(Landroidx/media3/common/util/ParsableByteArray;)V
    .locals 34
    .param p1, "atom"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 733
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-object v2, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v2, v2

    if-nez v2, :cond_0

    .line 734
    return-void

    .line 736
    :cond_0
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 737
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 738
    .local v2, "fullAtom":I
    invoke-static {v2}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v3

    .line 742
    .local v3, "version":I
    const-wide v4, -0x7fffffffffffffffL    # -4.9E-324

    .line 743
    .local v4, "presentationTimeDeltaUs":J
    const-wide v6, -0x7fffffffffffffffL    # -4.9E-324

    .line 746
    .local v6, "sampleTimeUs":J
    const-wide v8, -0x7fffffffffffffffL    # -4.9E-324

    packed-switch v3, :pswitch_data_0

    .line 771
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Skipping unsupported emsg version: "

    invoke-virtual {v1, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v8, "FragmentedMp4Extractor"

    invoke-static {v8, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 772
    return-void

    .line 761
    :pswitch_0
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v16

    .line 762
    .local v16, "timescale":J
    nop

    .line 763
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v10

    const-wide/32 v12, 0xf4240

    move-wide/from16 v14, v16

    invoke-static/range {v10 .. v15}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v6

    .line 764
    nop

    .line 765
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v10

    const-wide/16 v12, 0x3e8

    invoke-static/range {v10 .. v15}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v10

    .line 766
    .local v10, "durationMs":J
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v12

    .line 767
    .local v12, "id":J
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Ljava/lang/String;

    .line 768
    .local v14, "schemeIdUri":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/lang/String;

    .line 769
    .local v15, "value":Ljava/lang/String;
    move-wide/from16 v18, v10

    move-wide/from16 v20, v12

    move-object/from16 v22, v14

    move-object/from16 v23, v15

    move-wide/from16 v24, v16

    goto :goto_0

    .line 748
    .end local v10    # "durationMs":J
    .end local v12    # "id":J
    .end local v14    # "schemeIdUri":Ljava/lang/String;
    .end local v15    # "value":Ljava/lang/String;
    .end local v16    # "timescale":J
    :pswitch_1
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    move-object v14, v10

    check-cast v14, Ljava/lang/String;

    .line 749
    .restart local v14    # "schemeIdUri":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readNullTerminatedString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    move-object v15, v10

    check-cast v15, Ljava/lang/String;

    .line 750
    .restart local v15    # "value":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v10

    .line 751
    .local v10, "timescale":J
    nop

    .line 752
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v16

    const-wide/32 v18, 0xf4240

    move-wide/from16 v20, v10

    invoke-static/range {v16 .. v21}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v4

    .line 753
    iget-wide v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->segmentIndexEarliestPresentationTimeUs:J

    cmp-long v16, v12, v8

    if-eqz v16, :cond_1

    .line 754
    add-long v6, v12, v4

    .line 756
    :cond_1
    nop

    .line 757
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    move-wide/from16 v20, v10

    invoke-static/range {v16 .. v21}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v12

    .line 758
    .local v12, "durationMs":J
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v16

    .line 759
    .local v16, "id":J
    move-wide/from16 v24, v10

    move-wide/from16 v18, v12

    move-object/from16 v22, v14

    move-object/from16 v23, v15

    move-wide/from16 v20, v16

    .line 775
    .end local v10    # "timescale":J
    .end local v12    # "durationMs":J
    .end local v14    # "schemeIdUri":Ljava/lang/String;
    .end local v15    # "value":Ljava/lang/String;
    .end local v16    # "id":J
    .local v18, "durationMs":J
    .local v20, "id":J
    .local v22, "schemeIdUri":Ljava/lang/String;
    .local v23, "value":Ljava/lang/String;
    .local v24, "timescale":J
    :goto_0
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v10

    new-array v15, v10, [B

    .line 776
    .local v15, "messageData":[B
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v10

    const/4 v13, 0x0

    invoke-virtual {v1, v15, v13, v10}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 777
    new-instance v26, Landroidx/media3/extractor/metadata/emsg/EventMessage;

    move-object/from16 v10, v26

    move-object/from16 v11, v22

    move-object/from16 v12, v23

    move v8, v13

    move-wide/from16 v13, v18

    move-object v9, v15

    .end local v15    # "messageData":[B
    .local v9, "messageData":[B
    move-wide/from16 v15, v20

    move-object/from16 v17, v9

    invoke-direct/range {v10 .. v17}, Landroidx/media3/extractor/metadata/emsg/EventMessage;-><init>(Ljava/lang/String;Ljava/lang/String;JJ[B)V

    .line 778
    .local v10, "eventMessage":Landroidx/media3/extractor/metadata/emsg/EventMessage;
    new-instance v11, Landroidx/media3/common/util/ParsableByteArray;

    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->eventMessageEncoder:Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;

    .line 779
    invoke-virtual {v12, v10}, Landroidx/media3/extractor/metadata/emsg/EventMessageEncoder;->encode(Landroidx/media3/extractor/metadata/emsg/EventMessage;)[B

    move-result-object v12

    invoke-direct {v11, v12}, Landroidx/media3/common/util/ParsableByteArray;-><init>([B)V

    .line 780
    .local v11, "encodedEventMessage":Landroidx/media3/common/util/ParsableByteArray;
    invoke-virtual {v11}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v12

    .line 783
    .local v12, "sampleSize":I
    iget-object v13, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v14, v13

    move v15, v8

    :goto_1
    if-ge v15, v14, :cond_2

    aget-object v1, v13, v15

    .line 784
    .local v1, "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    invoke-virtual {v11, v8}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 785
    invoke-interface {v1, v11, v12}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 783
    .end local v1    # "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    add-int/lit8 v15, v15, 0x1

    move-object/from16 v1, p1

    goto :goto_1

    .line 789
    :cond_2
    const-wide v13, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v1, v6, v13

    if-nez v1, :cond_3

    .line 792
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    new-instance v8, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;

    const/4 v13, 0x1

    invoke-direct {v8, v4, v5, v13, v12}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;-><init>(JZI)V

    invoke-virtual {v1, v8}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V

    .line 795
    iget v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    add-int/2addr v1, v12

    iput v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    goto :goto_3

    .line 796
    :cond_3
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    .line 800
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    new-instance v13, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;

    invoke-direct {v13, v6, v7, v8, v12}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;-><init>(JZI)V

    invoke-virtual {v1, v13}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V

    .line 802
    iget v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    add-int/2addr v1, v12

    iput v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    goto :goto_3

    .line 803
    :cond_4
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    if-eqz v1, :cond_5

    invoke-virtual {v1}, Landroidx/media3/common/util/TimestampAdjuster;->isInitialized()Z

    move-result v1

    if-nez v1, :cond_5

    .line 807
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    new-instance v13, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;

    invoke-direct {v13, v6, v7, v8, v12}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;-><init>(JZI)V

    invoke-virtual {v1, v13}, Ljava/util/ArrayDeque;->addLast(Ljava/lang/Object;)V

    .line 809
    iget v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    add-int/2addr v1, v12

    iput v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    goto :goto_3

    .line 812
    :cond_5
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    if-eqz v1, :cond_6

    .line 813
    invoke-virtual {v1, v6, v7}, Landroidx/media3/common/util/TimestampAdjuster;->adjustSampleTimestamp(J)J

    move-result-wide v6

    .line 815
    :cond_6
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v13, v1

    :goto_2
    if-ge v8, v13, :cond_7

    aget-object v14, v1, v8

    .line 816
    .local v14, "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    const/16 v30, 0x1

    const/16 v32, 0x0

    const/16 v33, 0x0

    move-object/from16 v27, v14

    move-wide/from16 v28, v6

    move/from16 v31, v12

    invoke-interface/range {v27 .. v33}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 815
    .end local v14    # "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 820
    :cond_7
    :goto_3
    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private onLeafAtomRead(Landroidx/media3/extractor/mp4/Atom$LeafAtom;J)V
    .locals 3
    .param p1, "leaf"    # Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .param p2, "inputPosition"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 591
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 592
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    invoke-virtual {v0, p1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->add(Landroidx/media3/extractor/mp4/Atom$LeafAtom;)V

    goto :goto_1

    .line 593
    :cond_0
    iget v0, p1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v1, 0x73696478

    if-ne v0, v1, :cond_1

    .line 594
    iget-object v0, p1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v0, p2, p3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSidx(Landroidx/media3/common/util/ParsableByteArray;J)Landroid/util/Pair;

    move-result-object v0

    .line 595
    .local v0, "result":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Landroidx/media3/extractor/ChunkIndex;>;"
    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    iput-wide v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->segmentIndexEarliestPresentationTimeUs:J

    .line 596
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    iget-object v2, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v2, Landroidx/media3/extractor/SeekMap;

    invoke-interface {v1, v2}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 597
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->haveOutputSeekMap:Z

    .end local v0    # "result":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Long;Landroidx/media3/extractor/ChunkIndex;>;"
    goto :goto_0

    .line 598
    :cond_1
    iget v0, p1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v1, 0x656d7367

    if-ne v0, v1, :cond_2

    .line 599
    iget-object v0, p1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-direct {p0, v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->onEmsgLeafAtomRead(Landroidx/media3/common/util/ParsableByteArray;)V

    goto :goto_1

    .line 598
    :cond_2
    :goto_0
    nop

    .line 601
    :goto_1
    return-void
.end method

.method private onMoofContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V
    .locals 8
    .param p1, "moof"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 687
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    iget v2, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->flags:I

    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->scratchBytes:[B

    invoke-static {p1, v0, v1, v2, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseMoof(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroid/util/SparseArray;ZI[B)V

    .line 689
    iget-object v0, p1, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-static {v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->getDrmInitDataFromAtoms(Ljava/util/List;)Landroidx/media3/common/DrmInitData;

    move-result-object v0

    .line 690
    .local v0, "drmInitData":Landroidx/media3/common/DrmInitData;
    if-eqz v0, :cond_1

    .line 691
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    .line 692
    .local v1, "trackCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v1, :cond_1

    .line 693
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v3, v2}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    invoke-virtual {v3, v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->updateDrmInitData(Landroidx/media3/common/DrmInitData;)V

    .line 692
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 697
    .end local v1    # "trackCount":I
    .end local v2    # "i":I
    :cond_1
    iget-wide v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingSeekTimeUs:J

    const-wide v3, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v1, v1, v3

    if-eqz v1, :cond_3

    .line 698
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v1}, Landroid/util/SparseArray;->size()I

    move-result v1

    .line 699
    .restart local v1    # "trackCount":I
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_2
    if-ge v2, v1, :cond_2

    .line 700
    iget-object v5, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v5, v2}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingSeekTimeUs:J

    invoke-virtual {v5, v6, v7}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->seek(J)V

    .line 699
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 702
    .end local v2    # "i":I
    :cond_2
    iput-wide v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingSeekTimeUs:J

    .line 704
    .end local v1    # "trackCount":I
    :cond_3
    return-void
.end method

.method private onMoovContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V
    .locals 18
    .param p1, "moov"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 614
    move-object/from16 v0, p0

    move-object/from16 v9, p1

    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    const/4 v10, 0x0

    const/4 v11, 0x1

    if-nez v1, :cond_0

    move v1, v11

    goto :goto_0

    :cond_0
    move v1, v10

    :goto_0
    const-string v2, "Unexpected moov box."

    invoke-static {v1, v2}, Landroidx/media3/common/util/Assertions;->checkState(ZLjava/lang/Object;)V

    .line 616
    iget-object v1, v9, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-static {v1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->getDrmInitDataFromAtoms(Ljava/util/List;)Landroidx/media3/common/DrmInitData;

    move-result-object v12

    .line 619
    .local v12, "drmInitData":Landroidx/media3/common/DrmInitData;
    const v1, 0x6d766578

    invoke-virtual {v9, v1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getContainerAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    move-result-object v1

    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    move-object v13, v1

    check-cast v13, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 620
    .local v13, "mvex":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    new-instance v1, Landroid/util/SparseArray;

    invoke-direct {v1}, Landroid/util/SparseArray;-><init>()V

    move-object v14, v1

    .line 621
    .local v14, "defaultSampleValuesArray":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/DefaultSampleValues;>;"
    const-wide v1, -0x7fffffffffffffffL    # -4.9E-324

    .line 622
    .local v1, "duration":J
    iget-object v3, v13, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v15

    .line 623
    .local v15, "mvexChildrenSize":I
    const/4 v3, 0x0

    move-wide/from16 v16, v1

    .end local v1    # "duration":J
    .local v3, "i":I
    .local v16, "duration":J
    :goto_1
    if-ge v3, v15, :cond_3

    .line 624
    iget-object v1, v13, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 625
    .local v1, "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v2, v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v4, 0x74726578

    if-ne v2, v4, :cond_1

    .line 626
    iget-object v2, v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTrex(Landroidx/media3/common/util/ParsableByteArray;)Landroid/util/Pair;

    move-result-object v2

    .line 627
    .local v2, "trexData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/DefaultSampleValues;>;"
    iget-object v4, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iget-object v5, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-virtual {v14, v4, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .end local v2    # "trexData":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Landroidx/media3/extractor/mp4/DefaultSampleValues;>;"
    goto :goto_2

    .line 628
    :cond_1
    iget v2, v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v4, 0x6d656864

    if-ne v2, v4, :cond_2

    .line 629
    iget-object v2, v1, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseMehd(Landroidx/media3/common/util/ParsableByteArray;)J

    move-result-wide v4

    move-wide/from16 v16, v4

    .end local v16    # "duration":J
    .local v4, "duration":J
    goto :goto_3

    .line 628
    .end local v4    # "duration":J
    .restart local v16    # "duration":J
    :cond_2
    :goto_2
    nop

    .line 623
    .end local v1    # "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :goto_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 634
    .end local v3    # "i":I
    :cond_3
    new-instance v2, Landroidx/media3/extractor/GaplessInfoHolder;

    invoke-direct {v2}, Landroidx/media3/extractor/GaplessInfoHolder;-><init>()V

    iget v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->flags:I

    and-int/lit8 v1, v1, 0x10

    if-eqz v1, :cond_4

    move v6, v11

    goto :goto_4

    :cond_4
    move v6, v10

    :goto_4
    const/4 v7, 0x0

    new-instance v8, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda2;

    invoke-direct {v8, v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$$ExternalSyntheticLambda2;-><init>(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;)V

    .line 635
    move-object/from16 v1, p1

    move-wide/from16 v3, v16

    move-object v5, v12

    invoke-static/range {v1 .. v8}, Landroidx/media3/extractor/mp4/AtomParsers;->parseTraks(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/GaplessInfoHolder;JLandroidx/media3/common/DrmInitData;ZZLcom/google/common/base/Function;)Ljava/util/List;

    move-result-object v1

    .line 644
    .local v1, "sampleTables":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/mp4/TrackSampleTable;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .line 645
    .local v2, "trackCount":I
    iget-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v3}, Landroid/util/SparseArray;->size()I

    move-result v3

    if-nez v3, :cond_6

    .line 647
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_5
    if-ge v3, v2, :cond_5

    .line 648
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/extractor/mp4/TrackSampleTable;

    .line 649
    .local v4, "sampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    iget-object v5, v4, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    .line 650
    .local v5, "track":Landroidx/media3/extractor/mp4/Track;
    new-instance v6, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget-object v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    iget v8, v5, Landroidx/media3/extractor/mp4/Track;->type:I

    .line 652
    invoke-interface {v7, v3, v8}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v7

    iget v8, v5, Landroidx/media3/extractor/mp4/Track;->id:I

    .line 654
    invoke-direct {v0, v14, v8}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->getDefaultSampleValues(Landroid/util/SparseArray;I)Landroidx/media3/extractor/mp4/DefaultSampleValues;

    move-result-object v8

    invoke-direct {v6, v7, v4, v8}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;-><init>(Landroidx/media3/extractor/TrackOutput;Landroidx/media3/extractor/mp4/TrackSampleTable;Landroidx/media3/extractor/mp4/DefaultSampleValues;)V

    .line 655
    .local v6, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    iget-object v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    iget v8, v5, Landroidx/media3/extractor/mp4/Track;->id:I

    invoke-virtual {v7, v8, v6}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 656
    iget-wide v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->durationUs:J

    iget-wide v10, v5, Landroidx/media3/extractor/mp4/Track;->durationUs:J

    invoke-static {v7, v8, v10, v11}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v7

    iput-wide v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->durationUs:J

    .line 647
    .end local v4    # "sampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    .end local v5    # "track":Landroidx/media3/extractor/mp4/Track;
    .end local v6    # "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    add-int/lit8 v3, v3, 0x1

    goto :goto_5

    .line 658
    .end local v3    # "i":I
    :cond_5
    iget-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v3}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    goto :goto_7

    .line 660
    :cond_6
    iget-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v3}, Landroid/util/SparseArray;->size()I

    move-result v3

    if-ne v3, v2, :cond_7

    move v10, v11

    :cond_7
    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 661
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_6
    if-ge v3, v2, :cond_8

    .line 662
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/extractor/mp4/TrackSampleTable;

    .line 663
    .restart local v4    # "sampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    iget-object v5, v4, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    .line 664
    .restart local v5    # "track":Landroidx/media3/extractor/mp4/Track;
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    iget v7, v5, Landroidx/media3/extractor/mp4/Track;->id:I

    .line 665
    invoke-virtual {v6, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget v7, v5, Landroidx/media3/extractor/mp4/Track;->id:I

    .line 666
    invoke-direct {v0, v14, v7}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->getDefaultSampleValues(Landroid/util/SparseArray;I)Landroidx/media3/extractor/mp4/DefaultSampleValues;

    move-result-object v7

    invoke-virtual {v6, v4, v7}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->reset(Landroidx/media3/extractor/mp4/TrackSampleTable;Landroidx/media3/extractor/mp4/DefaultSampleValues;)V

    .line 661
    .end local v4    # "sampleTable":Landroidx/media3/extractor/mp4/TrackSampleTable;
    .end local v5    # "track":Landroidx/media3/extractor/mp4/Track;
    add-int/lit8 v3, v3, 0x1

    goto :goto_6

    .line 669
    .end local v3    # "i":I
    :cond_8
    :goto_7
    return-void
.end method

.method private outputPendingMetadataSamples(J)V
    .locals 15
    .param p1, "sampleTimeUs"    # J

    .line 1621
    move-object v0, p0

    :goto_0
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 1622
    iget-object v1, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->removeFirst()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;

    .line 1623
    .local v1, "metadataSampleInfo":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;
    iget v2, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    iget v3, v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;->size:I

    sub-int/2addr v2, v3

    iput v2, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    .line 1624
    iget-wide v2, v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;->sampleTimeUs:J

    .line 1625
    .local v2, "metadataSampleTimeUs":J
    iget-boolean v4, v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;->sampleTimeIsRelative:Z

    if-eqz v4, :cond_0

    .line 1628
    add-long v2, v2, p1

    .line 1630
    :cond_0
    iget-object v4, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    if-eqz v4, :cond_1

    .line 1631
    invoke-virtual {v4, v2, v3}, Landroidx/media3/common/util/TimestampAdjuster;->adjustSampleTimestamp(J)J

    move-result-wide v2

    .line 1633
    :cond_1
    iget-object v11, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->emsgTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v12, v11

    const/4 v4, 0x0

    move v13, v4

    :goto_1
    if-ge v13, v12, :cond_2

    aget-object v14, v11, v13

    .line 1634
    .local v14, "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    const/4 v7, 0x1

    iget v8, v1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;->size:I

    iget v9, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    const/4 v10, 0x0

    move-object v4, v14

    move-wide v5, v2

    invoke-interface/range {v4 .. v10}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 1633
    .end local v14    # "emsgTrackOutput":Landroidx/media3/extractor/TrackOutput;
    add-int/lit8 v13, v13, 0x1

    goto :goto_1

    .line 1641
    .end local v1    # "metadataSampleInfo":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$MetadataSampleInfo;
    .end local v2    # "metadataSampleTimeUs":J
    :cond_2
    goto :goto_0

    .line 1642
    :cond_3
    return-void
.end method

.method private static parseMehd(Landroidx/media3/common/util/ParsableByteArray;)J
    .locals 4
    .param p0, "mehd"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 842
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 843
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 844
    .local v0, "fullAtom":I
    invoke-static {v0}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v1

    .line 845
    .local v1, "version":I
    if-nez v1, :cond_0

    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v2

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v2

    :goto_0
    return-wide v2
.end method

.method private static parseMoof(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroid/util/SparseArray;ZI[B)V
    .locals 5
    .param p0, "moof"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p2, "haveSideloadedTrack"    # Z
    .param p3, "flags"    # I
    .param p4, "extendedTypeScratch"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/mp4/Atom$ContainerAtom;",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;",
            ">;ZI[B)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 855
    .local p1, "trackBundles":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;>;"
    iget-object v0, p0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->containerChildren:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 856
    .local v0, "moofContainerChildrenSize":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 857
    iget-object v2, p0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->containerChildren:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    .line 859
    .local v2, "child":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    iget v3, v2, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->type:I

    const v4, 0x74726166

    if-ne v3, v4, :cond_0

    .line 860
    invoke-static {v2, p1, p2, p3, p4}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTraf(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroid/util/SparseArray;ZI[B)V

    .line 856
    .end local v2    # "child":Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 863
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method private static parseSaio(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V
    .locals 8
    .param p0, "saio"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1008
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1009
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1010
    .local v1, "fullAtom":I
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v2

    .line 1011
    .local v2, "flags":I
    and-int/lit8 v3, v2, 0x1

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 1012
    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1015
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v0

    .line 1016
    .local v0, "entryCount":I
    if-ne v0, v4, :cond_2

    .line 1022
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v3

    .line 1023
    .local v3, "version":I
    iget-wide v4, p1, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    .line 1024
    if-nez v3, :cond_1

    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v6

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v6

    :goto_0
    add-long/2addr v4, v6

    iput-wide v4, p1, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    .line 1025
    return-void

    .line 1018
    .end local v3    # "version":I
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unexpected saio entry count: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v4}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3
.end method

.method private static parseSaiz(Landroidx/media3/extractor/mp4/TrackEncryptionBox;Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V
    .locals 12
    .param p0, "encryptionBox"    # Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    .param p1, "saiz"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 963
    iget v0, p0, Landroidx/media3/extractor/mp4/TrackEncryptionBox;->perSampleIvSize:I

    .line 964
    .local v0, "vectorSize":I
    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 965
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 966
    .local v2, "fullAtom":I
    invoke-static {v2}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v3

    .line 967
    .local v3, "flags":I
    and-int/lit8 v4, v3, 0x1

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 968
    invoke-virtual {p1, v1}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 970
    :cond_0
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v1

    .line 972
    .local v1, "defaultSampleInfoSize":I
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v4

    .line 973
    .local v4, "sampleCount":I
    iget v6, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    if-gt v4, v6, :cond_6

    .line 982
    const/4 v6, 0x0

    .line 983
    .local v6, "totalSize":I
    const/4 v7, 0x0

    if-nez v1, :cond_3

    .line 984
    iget-object v8, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleHasSubsampleEncryptionTable:[Z

    .line 985
    .local v8, "sampleHasSubsampleEncryptionTable":[Z
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    if-ge v9, v4, :cond_2

    .line 986
    invoke-virtual {p1}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v10

    .line 987
    .local v10, "sampleInfoSize":I
    add-int/2addr v6, v10

    .line 988
    if-le v10, v0, :cond_1

    move v11, v5

    goto :goto_1

    :cond_1
    move v11, v7

    :goto_1
    aput-boolean v11, v8, v9

    .line 985
    .end local v10    # "sampleInfoSize":I
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 990
    .end local v8    # "sampleHasSubsampleEncryptionTable":[Z
    .end local v9    # "i":I
    :cond_2
    goto :goto_3

    .line 991
    :cond_3
    if-le v1, v0, :cond_4

    goto :goto_2

    :cond_4
    move v5, v7

    .line 992
    .local v5, "subsampleEncryption":Z
    :goto_2
    mul-int v8, v1, v4

    add-int/2addr v6, v8

    .line 993
    iget-object v8, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleHasSubsampleEncryptionTable:[Z

    invoke-static {v8, v7, v4, v5}, Ljava/util/Arrays;->fill([ZIIZ)V

    .line 995
    .end local v5    # "subsampleEncryption":Z
    :goto_3
    iget-object v5, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleHasSubsampleEncryptionTable:[Z

    iget v8, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    invoke-static {v5, v4, v8, v7}, Ljava/util/Arrays;->fill([ZIIZ)V

    .line 996
    if-lez v6, :cond_5

    .line 997
    invoke-virtual {p2, v6}, Landroidx/media3/extractor/mp4/TrackFragment;->initEncryptionData(I)V

    .line 999
    :cond_5
    return-void

    .line 974
    .end local v6    # "totalSize":I
    :cond_6
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Saiz sample count "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " is greater than fragment sample count"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static {v5, v6}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v5

    throw v5
.end method

.method private static parseSampleGroups(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Ljava/lang/String;Landroidx/media3/extractor/mp4/TrackFragment;)V
    .locals 22
    .param p0, "traf"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p1, "schemeType"    # Ljava/lang/String;
    .param p2, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1278
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    const/4 v2, 0x0

    .line 1279
    .local v2, "sbgp":Landroidx/media3/common/util/ParsableByteArray;
    const/4 v3, 0x0

    .line 1280
    .local v3, "sgpd":Landroidx/media3/common/util/ParsableByteArray;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    iget-object v5, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_2

    .line 1281
    iget-object v5, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v5, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 1282
    .local v5, "leafAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget-object v6, v5, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 1283
    .local v6, "leafAtomData":Landroidx/media3/common/util/ParsableByteArray;
    iget v7, v5, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v8, 0x73626770

    const v9, 0x73656967

    const/16 v10, 0xc

    if-ne v7, v8, :cond_0

    .line 1284
    invoke-virtual {v6, v10}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1285
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v7

    if-ne v7, v9, :cond_1

    .line 1286
    move-object v2, v6

    goto :goto_1

    .line 1288
    :cond_0
    iget v7, v5, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    const v8, 0x73677064

    if-ne v7, v8, :cond_1

    .line 1289
    invoke-virtual {v6, v10}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1290
    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v7

    if-ne v7, v9, :cond_1

    .line 1291
    move-object v3, v6

    .line 1280
    .end local v5    # "leafAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v6    # "leafAtomData":Landroidx/media3/common/util/ParsableByteArray;
    :cond_1
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1295
    .end local v4    # "i":I
    :cond_2
    if-eqz v2, :cond_d

    if-nez v3, :cond_3

    goto/16 :goto_5

    .line 1299
    :cond_3
    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1300
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    invoke-static {v5}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v5

    .line 1301
    .local v5, "sbgpVersion":I
    const/4 v6, 0x4

    invoke-virtual {v2, v6}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1302
    const/4 v7, 0x1

    if-ne v5, v7, :cond_4

    .line 1303
    invoke-virtual {v2, v6}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1305
    :cond_4
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v8

    if-ne v8, v7, :cond_c

    .line 1310
    invoke-virtual {v3, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1311
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    invoke-static {v4}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v4

    .line 1312
    .local v4, "sgpdVersion":I
    invoke-virtual {v3, v6}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1313
    if-ne v4, v7, :cond_6

    .line 1314
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-eqz v8, :cond_5

    goto :goto_2

    .line 1315
    :cond_5
    const-string v6, "Variable length description in sgpd found (unsupported)"

    invoke-static {v6}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v6

    throw v6

    .line 1318
    :cond_6
    const/4 v8, 0x2

    if-lt v4, v8, :cond_7

    .line 1319
    invoke-virtual {v3, v6}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1321
    :cond_7
    :goto_2
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v8

    const-wide/16 v10, 0x1

    cmp-long v8, v8, v10

    if-nez v8, :cond_b

    .line 1327
    invoke-virtual {v3, v7}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1328
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v8

    .line 1329
    .local v8, "patternByte":I
    and-int/lit16 v9, v8, 0xf0

    shr-int/lit8 v6, v9, 0x4

    .line 1330
    .local v6, "cryptByteBlock":I
    and-int/lit8 v9, v8, 0xf

    .line 1331
    .local v9, "skipByteBlock":I
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v10

    const/4 v11, 0x0

    if-ne v10, v7, :cond_8

    move v10, v7

    goto :goto_3

    :cond_8
    move v10, v11

    :goto_3
    move/from16 v18, v10

    .line 1332
    .local v18, "isProtected":Z
    if-nez v18, :cond_9

    .line 1333
    return-void

    .line 1335
    :cond_9
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v19

    .line 1336
    .local v19, "perSampleIvSize":I
    const/16 v10, 0x10

    new-array v15, v10, [B

    .line 1337
    .local v15, "keyId":[B
    array-length v10, v15

    invoke-virtual {v3, v15, v11, v10}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1338
    const/4 v10, 0x0

    .line 1339
    .local v10, "constantIv":[B
    if-nez v19, :cond_a

    .line 1340
    invoke-virtual {v3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v12

    .line 1341
    .local v12, "constantIvSize":I
    new-array v10, v12, [B

    .line 1342
    invoke-virtual {v3, v10, v11, v12}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    move-object/from16 v20, v10

    goto :goto_4

    .line 1339
    .end local v12    # "constantIvSize":I
    :cond_a
    move-object/from16 v20, v10

    .line 1344
    .end local v10    # "constantIv":[B
    .local v20, "constantIv":[B
    :goto_4
    iput-boolean v7, v1, Landroidx/media3/extractor/mp4/TrackFragment;->definesEncryptionData:Z

    .line 1345
    new-instance v7, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-object v10, v7

    move/from16 v11, v18

    move-object/from16 v12, p1

    move/from16 v13, v19

    move-object v14, v15

    move-object/from16 v21, v15

    .end local v15    # "keyId":[B
    .local v21, "keyId":[B
    move v15, v6

    move/from16 v16, v9

    move-object/from16 v17, v20

    invoke-direct/range {v10 .. v17}, Landroidx/media3/extractor/mp4/TrackEncryptionBox;-><init>(ZLjava/lang/String;I[BII[B)V

    iput-object v7, v1, Landroidx/media3/extractor/mp4/TrackFragment;->trackEncryptionBox:Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    .line 1354
    return-void

    .line 1322
    .end local v6    # "cryptByteBlock":I
    .end local v8    # "patternByte":I
    .end local v9    # "skipByteBlock":I
    .end local v18    # "isProtected":Z
    .end local v19    # "perSampleIvSize":I
    .end local v20    # "constantIv":[B
    .end local v21    # "keyId":[B
    :cond_b
    const-string v6, "Entry count in sgpd != 1 (unsupported)."

    invoke-static {v6}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v6

    throw v6

    .line 1306
    .end local v4    # "sgpdVersion":I
    :cond_c
    const-string v4, "Entry count in sbgp != 1 (unsupported)."

    invoke-static {v4}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v4

    throw v4

    .line 1296
    .end local v5    # "sbgpVersion":I
    :cond_d
    :goto_5
    return-void
.end method

.method private static parseSenc(Landroidx/media3/common/util/ParsableByteArray;ILandroidx/media3/extractor/mp4/TrackFragment;)V
    .locals 7
    .param p0, "senc"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "offset"    # I
    .param p2, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1245
    add-int/lit8 v0, p1, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1246
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 1247
    .local v0, "fullAtom":I
    invoke-static {v0}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v1

    .line 1249
    .local v1, "flags":I
    and-int/lit8 v2, v1, 0x1

    if-nez v2, :cond_3

    .line 1255
    and-int/lit8 v2, v1, 0x2

    const/4 v3, 0x0

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    move v2, v3

    .line 1256
    .local v2, "subsampleEncryption":Z
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v4

    .line 1257
    .local v4, "sampleCount":I
    if-nez v4, :cond_1

    .line 1259
    iget-object v5, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleHasSubsampleEncryptionTable:[Z

    iget v6, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    invoke-static {v5, v3, v6, v3}, Ljava/util/Arrays;->fill([ZIIZ)V

    .line 1260
    return-void

    .line 1261
    :cond_1
    iget v5, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    if-ne v4, v5, :cond_2

    .line 1270
    iget-object v5, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleHasSubsampleEncryptionTable:[Z

    invoke-static {v5, v3, v4, v2}, Ljava/util/Arrays;->fill([ZIIZ)V

    .line 1271
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v3

    invoke-virtual {p2, v3}, Landroidx/media3/extractor/mp4/TrackFragment;->initEncryptionData(I)V

    .line 1272
    invoke-virtual {p2, p0}, Landroidx/media3/extractor/mp4/TrackFragment;->fillEncryptionData(Landroidx/media3/common/util/ParsableByteArray;)V

    .line 1273
    return-void

    .line 1262
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Senc sample count "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " is different from fragment sample count"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v5, p2, Landroidx/media3/extractor/mp4/TrackFragment;->sampleCount:I

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v5, 0x0

    invoke-static {v3, v5}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 1251
    .end local v2    # "subsampleEncryption":Z
    .end local v4    # "sampleCount":I
    :cond_3
    const-string v2, "Overriding TrackEncryptionBox parameters is unsupported."

    invoke-static {v2}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v2

    throw v2
.end method

.method private static parseSenc(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V
    .locals 1
    .param p0, "senc"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1240
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSenc(Landroidx/media3/common/util/ParsableByteArray;ILandroidx/media3/extractor/mp4/TrackFragment;)V

    .line 1241
    return-void
.end method

.method private static parseSidx(Landroidx/media3/common/util/ParsableByteArray;J)Landroid/util/Pair;
    .locals 32
    .param p0, "atom"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "inputPosition"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "J)",
            "Landroid/util/Pair<",
            "Ljava/lang/Long;",
            "Landroidx/media3/extractor/ChunkIndex;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1366
    move-object/from16 v0, p0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1367
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1368
    .local v1, "fullAtom":I
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v2

    .line 1370
    .local v2, "version":I
    const/4 v3, 0x4

    invoke-virtual {v0, v3}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1371
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v10

    .line 1373
    .local v10, "timescale":J
    move-wide/from16 v4, p1

    .line 1374
    .local v4, "offset":J
    if-nez v2, :cond_0

    .line 1375
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v6

    .line 1376
    .local v6, "earliestPresentationTime":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v8

    add-long/2addr v4, v8

    move-wide v12, v4

    move-wide v14, v6

    goto :goto_0

    .line 1378
    .end local v6    # "earliestPresentationTime":J
    :cond_0
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v6

    .line 1379
    .restart local v6    # "earliestPresentationTime":J
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v8

    add-long/2addr v4, v8

    move-wide v12, v4

    move-wide v14, v6

    .line 1381
    .end local v4    # "offset":J
    .end local v6    # "earliestPresentationTime":J
    .local v12, "offset":J
    .local v14, "earliestPresentationTime":J
    :goto_0
    const-wide/32 v6, 0xf4240

    .line 1382
    move-wide v4, v14

    move-wide v8, v10

    invoke-static/range {v4 .. v9}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v16

    .line 1384
    .local v16, "earliestPresentationTimeUs":J
    const/4 v4, 0x2

    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1386
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedShort()I

    move-result v8

    .line 1387
    .local v8, "referenceCount":I
    new-array v9, v8, [I

    .line 1388
    .local v9, "sizes":[I
    new-array v6, v8, [J

    .line 1389
    .local v6, "offsets":[J
    new-array v7, v8, [J

    .line 1390
    .local v7, "durationsUs":[J
    new-array v4, v8, [J

    .line 1392
    .local v4, "timesUs":[J
    move-wide/from16 v18, v14

    .line 1393
    .local v18, "time":J
    move-wide/from16 v20, v16

    .line 1394
    .local v20, "timeUs":J
    const/4 v5, 0x0

    move-wide/from16 v22, v20

    move-wide/from16 v20, v18

    move-wide/from16 v18, v12

    move v12, v5

    .local v12, "i":I
    .local v18, "offset":J
    .local v20, "time":J
    .local v22, "timeUs":J
    :goto_1
    if-ge v12, v8, :cond_2

    .line 1395
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v13

    .line 1397
    .local v13, "firstInt":I
    const/high16 v5, -0x80000000

    and-int v24, v13, v5

    .line 1398
    .local v24, "type":I
    if-nez v24, :cond_1

    .line 1402
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v25

    .line 1404
    .local v25, "referenceDuration":J
    const v5, 0x7fffffff

    and-int/2addr v5, v13

    aput v5, v9, v12

    .line 1405
    aput-wide v18, v6, v12

    .line 1409
    aput-wide v22, v4, v12

    .line 1410
    add-long v20, v20, v25

    .line 1411
    const-wide/32 v27, 0xf4240

    move-object v3, v4

    .end local v4    # "timesUs":[J
    .local v3, "timesUs":[J
    move-wide/from16 v4, v20

    move/from16 v29, v1

    move/from16 v30, v2

    move-object v1, v6

    move-object v2, v7

    .end local v6    # "offsets":[J
    .end local v7    # "durationsUs":[J
    .local v1, "offsets":[J
    .local v2, "durationsUs":[J
    .local v29, "fullAtom":I
    .local v30, "version":I
    move-wide/from16 v6, v27

    move/from16 v27, v8

    move/from16 v28, v13

    move-object v13, v9

    .end local v8    # "referenceCount":I
    .end local v9    # "sizes":[I
    .local v13, "sizes":[I
    .local v27, "referenceCount":I
    .local v28, "firstInt":I
    move-wide v8, v10

    invoke-static/range {v4 .. v9}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v22

    .line 1412
    aget-wide v4, v3, v12

    sub-long v4, v22, v4

    aput-wide v4, v2, v12

    .line 1414
    const/4 v4, 0x4

    invoke-virtual {v0, v4}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 1415
    aget v5, v13, v12

    int-to-long v5, v5

    add-long v18, v18, v5

    .line 1394
    .end local v24    # "type":I
    .end local v25    # "referenceDuration":J
    .end local v28    # "firstInt":I
    add-int/lit8 v12, v12, 0x1

    move-object v6, v1

    move-object v7, v2

    move-object v9, v13

    move/from16 v8, v27

    move/from16 v1, v29

    move/from16 v2, v30

    move/from16 v31, v4

    move-object v4, v3

    move/from16 v3, v31

    goto :goto_1

    .line 1399
    .end local v3    # "timesUs":[J
    .end local v27    # "referenceCount":I
    .end local v29    # "fullAtom":I
    .end local v30    # "version":I
    .local v1, "fullAtom":I
    .local v2, "version":I
    .restart local v4    # "timesUs":[J
    .restart local v6    # "offsets":[J
    .restart local v7    # "durationsUs":[J
    .restart local v8    # "referenceCount":I
    .restart local v9    # "sizes":[I
    .local v13, "firstInt":I
    .restart local v24    # "type":I
    :cond_1
    move-object v3, v4

    .end local v4    # "timesUs":[J
    .restart local v3    # "timesUs":[J
    const-string v4, "Unhandled indirect reference"

    const/4 v5, 0x0

    invoke-static {v4, v5}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v4

    throw v4

    .line 1394
    .end local v3    # "timesUs":[J
    .end local v13    # "firstInt":I
    .end local v24    # "type":I
    .restart local v4    # "timesUs":[J
    :cond_2
    move/from16 v29, v1

    move/from16 v30, v2

    move-object v3, v4

    move-object v1, v6

    move-object v2, v7

    move-object v13, v9

    .line 1418
    .end local v4    # "timesUs":[J
    .end local v6    # "offsets":[J
    .end local v7    # "durationsUs":[J
    .end local v9    # "sizes":[I
    .end local v12    # "i":I
    .local v1, "offsets":[J
    .local v2, "durationsUs":[J
    .restart local v3    # "timesUs":[J
    .local v13, "sizes":[I
    .restart local v29    # "fullAtom":I
    .restart local v30    # "version":I
    nop

    .line 1419
    invoke-static/range {v16 .. v17}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    new-instance v5, Landroidx/media3/extractor/ChunkIndex;

    invoke-direct {v5, v13, v1, v2, v3}, Landroidx/media3/extractor/ChunkIndex;-><init>([I[J[J[J)V

    .line 1418
    invoke-static {v4, v5}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v4

    return-object v4
.end method

.method private static parseTfdt(Landroidx/media3/common/util/ParsableByteArray;)J
    .locals 4
    .param p0, "tfdt"    # Landroidx/media3/common/util/ParsableByteArray;

    .line 1091
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1092
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 1093
    .local v0, "fullAtom":I
    invoke-static {v0}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomVersion(I)I

    move-result v1

    .line 1094
    .local v1, "version":I
    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v2

    goto :goto_0

    :cond_0
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v2

    :goto_0
    return-wide v2
.end method

.method private static parseTfhd(Landroidx/media3/common/util/ParsableByteArray;Landroid/util/SparseArray;Z)Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .locals 11
    .param p0, "tfhd"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p2, "haveSideloadedTrack"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;",
            ">;Z)",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;"
        }
    .end annotation

    .line 1042
    .local p1, "trackBundles":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;>;"
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1043
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 1044
    .local v0, "fullAtom":I
    invoke-static {v0}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v1

    .line 1045
    .local v1, "atomFlags":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 1048
    .local v2, "trackId":I
    if-eqz p2, :cond_0

    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v3

    goto :goto_0

    :cond_0
    invoke-virtual {p1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    :goto_0
    check-cast v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1049
    .local v3, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    if-nez v3, :cond_1

    .line 1050
    const/4 v4, 0x0

    return-object v4

    .line 1052
    :cond_1
    and-int/lit8 v4, v1, 0x1

    if-eqz v4, :cond_2

    .line 1053
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v4

    .line 1054
    .local v4, "baseDataPosition":J
    iget-object v6, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    iput-wide v4, v6, Landroidx/media3/extractor/mp4/TrackFragment;->dataPosition:J

    .line 1055
    iget-object v6, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    iput-wide v4, v6, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    .line 1058
    .end local v4    # "baseDataPosition":J
    :cond_2
    iget-object v4, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->defaultSampleValues:Landroidx/media3/extractor/mp4/DefaultSampleValues;

    .line 1060
    .local v4, "defaultSampleValues":Landroidx/media3/extractor/mp4/DefaultSampleValues;
    and-int/lit8 v5, v1, 0x2

    if-eqz v5, :cond_3

    .line 1061
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    goto :goto_1

    .line 1062
    :cond_3
    iget v5, v4, Landroidx/media3/extractor/mp4/DefaultSampleValues;->sampleDescriptionIndex:I

    :goto_1
    nop

    .line 1064
    .local v5, "defaultSampleDescriptionIndex":I
    and-int/lit8 v6, v1, 0x8

    if-eqz v6, :cond_4

    .line 1065
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v6

    goto :goto_2

    .line 1066
    :cond_4
    iget v6, v4, Landroidx/media3/extractor/mp4/DefaultSampleValues;->duration:I

    :goto_2
    nop

    .line 1068
    .local v6, "defaultSampleDuration":I
    and-int/lit8 v7, v1, 0x10

    if-eqz v7, :cond_5

    .line 1069
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v7

    goto :goto_3

    .line 1070
    :cond_5
    iget v7, v4, Landroidx/media3/extractor/mp4/DefaultSampleValues;->size:I

    :goto_3
    nop

    .line 1072
    .local v7, "defaultSampleSize":I
    and-int/lit8 v8, v1, 0x20

    if-eqz v8, :cond_6

    .line 1073
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v8

    goto :goto_4

    .line 1074
    :cond_6
    iget v8, v4, Landroidx/media3/extractor/mp4/DefaultSampleValues;->flags:I

    :goto_4
    nop

    .line 1075
    .local v8, "defaultSampleFlags":I
    iget-object v9, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    new-instance v10, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-direct {v10, v5, v6, v7, v8}, Landroidx/media3/extractor/mp4/DefaultSampleValues;-><init>(IIII)V

    iput-object v10, v9, Landroidx/media3/extractor/mp4/TrackFragment;->header:Landroidx/media3/extractor/mp4/DefaultSampleValues;

    .line 1081
    return-object v3
.end method

.method private static parseTraf(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroid/util/SparseArray;ZI[B)V
    .locals 18
    .param p0, "traf"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p2, "haveSideloadedTrack"    # Z
    .param p3, "flags"    # I
    .param p4, "extendedTypeScratch"    # [B
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/extractor/mp4/Atom$ContainerAtom;",
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;",
            ">;ZI[B)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 873
    .local p1, "trackBundles":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;>;"
    move-object/from16 v0, p0

    move/from16 v1, p3

    const v2, 0x74666864

    invoke-virtual {v0, v2}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v2

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 874
    .local v2, "tfhd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget-object v3, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    move-object/from16 v4, p1

    move/from16 v5, p2

    invoke-static {v3, v4, v5}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTfhd(Landroidx/media3/common/util/ParsableByteArray;Landroid/util/SparseArray;Z)Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    move-result-object v3

    .line 875
    .local v3, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    if-nez v3, :cond_0

    .line 876
    return-void

    .line 879
    :cond_0
    iget-object v6, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    .line 880
    .local v6, "fragment":Landroidx/media3/extractor/mp4/TrackFragment;
    iget-wide v7, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTime:J

    .line 881
    .local v7, "fragmentDecodeTime":J
    iget-boolean v9, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTimeIncludesMoov:Z

    .line 882
    .local v9, "fragmentDecodeTimeIncludesMoov":Z
    invoke-virtual {v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->resetFragmentInfo()V

    .line 883
    const/4 v10, 0x1

    invoke-static {v3, v10}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->access$002(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;Z)Z

    .line 884
    const v11, 0x74666474

    invoke-virtual {v0, v11}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v11

    .line 885
    .local v11, "tfdtAtom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v11, :cond_1

    and-int/lit8 v12, v1, 0x2

    if-nez v12, :cond_1

    .line 886
    iget-object v12, v11, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v12}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTfdt(Landroidx/media3/common/util/ParsableByteArray;)J

    move-result-wide v12

    iput-wide v12, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTime:J

    .line 887
    iput-boolean v10, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTimeIncludesMoov:Z

    goto :goto_0

    .line 889
    :cond_1
    iput-wide v7, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTime:J

    .line 890
    iput-boolean v9, v6, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTimeIncludesMoov:Z

    .line 893
    :goto_0
    invoke-static {v0, v3, v1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTruns(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;I)V

    .line 896
    iget-object v10, v3, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v10, v10, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    iget-object v12, v6, Landroidx/media3/extractor/mp4/TrackFragment;->header:Landroidx/media3/extractor/mp4/DefaultSampleValues;

    .line 898
    invoke-static {v12}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    iget v12, v12, Landroidx/media3/extractor/mp4/DefaultSampleValues;->sampleDescriptionIndex:I

    .line 897
    invoke-virtual {v10, v12}, Landroidx/media3/extractor/mp4/Track;->getSampleDescriptionEncryptionBox(I)Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-result-object v10

    .line 900
    .local v10, "encryptionBox":Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    const v12, 0x7361697a

    invoke-virtual {v0, v12}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v12

    .line 901
    .local v12, "saiz":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v12, :cond_2

    .line 902
    invoke-static {v10}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    iget-object v14, v12, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v13, v14, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSaiz(Landroidx/media3/extractor/mp4/TrackEncryptionBox;Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V

    .line 905
    :cond_2
    const v13, 0x7361696f

    invoke-virtual {v0, v13}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v13

    .line 906
    .local v13, "saio":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v13, :cond_3

    .line 907
    iget-object v14, v13, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v14, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSaio(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V

    .line 910
    :cond_3
    const v14, 0x73656e63

    invoke-virtual {v0, v14}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->getLeafAtomOfType(I)Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    move-result-object v14

    .line 911
    .local v14, "senc":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    if-eqz v14, :cond_4

    .line 912
    iget-object v15, v14, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v15, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSenc(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;)V

    .line 915
    :cond_4
    if-eqz v10, :cond_5

    iget-object v15, v10, Landroidx/media3/extractor/mp4/TrackEncryptionBox;->schemeType:Ljava/lang/String;

    goto :goto_1

    :cond_5
    const/4 v15, 0x0

    :goto_1
    invoke-static {v0, v15, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSampleGroups(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Ljava/lang/String;Landroidx/media3/extractor/mp4/TrackFragment;)V

    .line 917
    iget-object v15, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v15

    .line 918
    .local v15, "leafChildrenSize":I
    const/16 v16, 0x0

    move/from16 v1, v16

    .local v1, "i":I
    :goto_2
    if-ge v1, v15, :cond_7

    .line 919
    move-object/from16 v16, v2

    .end local v2    # "tfhd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .local v16, "tfhd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget-object v2, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 920
    .local v2, "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v0, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    move-object/from16 v17, v3

    .end local v3    # "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .local v17, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    const v3, 0x75756964

    if-ne v0, v3, :cond_6

    .line 921
    iget-object v0, v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    move-object/from16 v3, p4

    invoke-static {v0, v6, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseUuid(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;[B)V

    goto :goto_3

    .line 920
    :cond_6
    move-object/from16 v3, p4

    .line 918
    .end local v2    # "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    :goto_3
    add-int/lit8 v1, v1, 0x1

    move-object/from16 v0, p0

    move-object/from16 v2, v16

    move-object/from16 v3, v17

    goto :goto_2

    .line 924
    .end local v1    # "i":I
    .end local v16    # "tfhd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v17    # "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .local v2, "tfhd":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .restart local v3    # "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    :cond_7
    return-void
.end method

.method private static parseTrex(Landroidx/media3/common/util/ParsableByteArray;)Landroid/util/Pair;
    .locals 7
    .param p0, "trex"    # Landroidx/media3/common/util/ParsableByteArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/common/util/ParsableByteArray;",
            ")",
            "Landroid/util/Pair<",
            "Ljava/lang/Integer;",
            "Landroidx/media3/extractor/mp4/DefaultSampleValues;",
            ">;"
        }
    .end annotation

    .line 824
    const/16 v0, 0xc

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 825
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    .line 826
    .local v0, "trackId":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .line 827
    .local v1, "defaultSampleDescriptionIndex":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v2

    .line 828
    .local v2, "defaultSampleDuration":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v3

    .line 829
    .local v3, "defaultSampleSize":I
    invoke-virtual {p0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v4

    .line 831
    .local v4, "defaultSampleFlags":I
    nop

    .line 832
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    new-instance v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-direct {v6, v1, v2, v3, v4}, Landroidx/media3/extractor/mp4/DefaultSampleValues;-><init>(IIII)V

    .line 831
    invoke-static {v5, v6}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v5

    return-object v5
.end method

.method private static parseTrun(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;IILandroidx/media3/common/util/ParsableByteArray;I)I
    .locals 37
    .param p0, "trackBundle"    # Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .param p1, "index"    # I
    .param p2, "flags"    # I
    .param p3, "trun"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p4, "trackRunStart"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1134
    move-object/from16 v0, p0

    const/16 v1, 0x8

    move-object/from16 v2, p3

    invoke-virtual {v2, v1}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1135
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v1

    .line 1136
    .local v1, "fullAtom":I
    invoke-static {v1}, Landroidx/media3/extractor/mp4/Atom;->parseFullAtomFlags(I)I

    move-result v3

    .line 1138
    .local v3, "atomFlags":I
    iget-object v4, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v4, v4, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    .line 1139
    .local v4, "track":Landroidx/media3/extractor/mp4/Track;
    iget-object v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    .line 1140
    .local v5, "fragment":Landroidx/media3/extractor/mp4/TrackFragment;
    iget-object v6, v5, Landroidx/media3/extractor/mp4/TrackFragment;->header:Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-static {v6}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    .line 1142
    .local v6, "defaultSampleValues":Landroidx/media3/extractor/mp4/DefaultSampleValues;
    iget-object v7, v5, Landroidx/media3/extractor/mp4/TrackFragment;->trunLength:[I

    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v8

    aput v8, v7, p1

    .line 1143
    iget-object v7, v5, Landroidx/media3/extractor/mp4/TrackFragment;->trunDataPosition:[J

    iget-wide v8, v5, Landroidx/media3/extractor/mp4/TrackFragment;->dataPosition:J

    aput-wide v8, v7, p1

    .line 1144
    and-int/lit8 v7, v3, 0x1

    if-eqz v7, :cond_0

    .line 1145
    iget-object v7, v5, Landroidx/media3/extractor/mp4/TrackFragment;->trunDataPosition:[J

    aget-wide v8, v7, p1

    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    int-to-long v10, v10

    add-long/2addr v8, v10

    aput-wide v8, v7, p1

    .line 1148
    :cond_0
    and-int/lit8 v7, v3, 0x4

    const/4 v8, 0x0

    if-eqz v7, :cond_1

    const/4 v7, 0x1

    goto :goto_0

    :cond_1
    move v7, v8

    .line 1149
    .local v7, "firstSampleFlagsPresent":Z
    :goto_0
    iget v10, v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;->flags:I

    .line 1150
    .local v10, "firstSampleFlags":I
    if-eqz v7, :cond_2

    .line 1151
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v10

    .line 1154
    :cond_2
    and-int/lit16 v11, v3, 0x100

    if-eqz v11, :cond_3

    const/4 v11, 0x1

    goto :goto_1

    :cond_3
    move v11, v8

    .line 1155
    .local v11, "sampleDurationsPresent":Z
    :goto_1
    and-int/lit16 v12, v3, 0x200

    if-eqz v12, :cond_4

    const/4 v12, 0x1

    goto :goto_2

    :cond_4
    move v12, v8

    .line 1156
    .local v12, "sampleSizesPresent":Z
    :goto_2
    and-int/lit16 v13, v3, 0x400

    if-eqz v13, :cond_5

    const/4 v13, 0x1

    goto :goto_3

    :cond_5
    move v13, v8

    .line 1157
    .local v13, "sampleFlagsPresent":Z
    :goto_3
    and-int/lit16 v14, v3, 0x800

    if-eqz v14, :cond_6

    const/4 v14, 0x1

    goto :goto_4

    :cond_6
    move v14, v8

    .line 1162
    .local v14, "sampleCompositionTimeOffsetsPresent":Z
    :goto_4
    const-wide/16 v15, 0x0

    .line 1165
    .local v15, "edtsOffset":J
    invoke-static {v4}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->isEdtsListDurationForEntireMediaTimeline(Landroidx/media3/extractor/mp4/Track;)Z

    move-result v17

    if-eqz v17, :cond_7

    .line 1166
    iget-object v9, v4, Landroidx/media3/extractor/mp4/Track;->editListMediaTimes:[J

    invoke-static {v9}, Landroidx/media3/common/util/Util;->castNonNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [J

    aget-wide v15, v9, v8

    .line 1169
    :cond_7
    iget-object v9, v5, Landroidx/media3/extractor/mp4/TrackFragment;->sampleSizeTable:[I

    .line 1170
    .local v9, "sampleSizeTable":[I
    iget-object v8, v5, Landroidx/media3/extractor/mp4/TrackFragment;->samplePresentationTimesUs:[J

    .line 1171
    .local v8, "samplePresentationTimesUs":[J
    move/from16 v18, v1

    .end local v1    # "fullAtom":I
    .local v18, "fullAtom":I
    iget-object v1, v5, Landroidx/media3/extractor/mp4/TrackFragment;->sampleIsSyncFrameTable:[Z

    .line 1173
    .local v1, "sampleIsSyncFrameTable":[Z
    iget v2, v4, Landroidx/media3/extractor/mp4/Track;->type:I

    move/from16 v19, v3

    .end local v3    # "atomFlags":I
    .local v19, "atomFlags":I
    const/4 v3, 0x2

    if-ne v2, v3, :cond_8

    and-int/lit8 v2, p2, 0x1

    if-eqz v2, :cond_8

    const/4 v2, 0x1

    goto :goto_5

    :cond_8
    const/4 v2, 0x0

    .line 1177
    .local v2, "workaroundEveryVideoFrameIsSyncFrame":Z
    :goto_5
    iget-object v3, v5, Landroidx/media3/extractor/mp4/TrackFragment;->trunLength:[I

    aget v3, v3, p1

    add-int v3, p4, v3

    .line 1178
    .local v3, "trackRunEnd":I
    move-object/from16 v26, v1

    move/from16 v27, v2

    .end local v1    # "sampleIsSyncFrameTable":[Z
    .end local v2    # "workaroundEveryVideoFrameIsSyncFrame":Z
    .local v26, "sampleIsSyncFrameTable":[Z
    .local v27, "workaroundEveryVideoFrameIsSyncFrame":Z
    iget-wide v1, v4, Landroidx/media3/extractor/mp4/Track;->timescale:J

    .line 1179
    .local v1, "timescale":J
    move-object/from16 v29, v9

    move/from16 v28, v10

    .end local v9    # "sampleSizeTable":[I
    .end local v10    # "firstSampleFlags":I
    .local v28, "firstSampleFlags":I
    .local v29, "sampleSizeTable":[I
    iget-wide v9, v5, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTime:J

    .line 1180
    .local v9, "cumulativeTime":J
    move/from16 v20, p4

    move-object/from16 v30, v4

    move/from16 v4, v20

    .local v4, "i":I
    .local v30, "track":Landroidx/media3/extractor/mp4/Track;
    :goto_6
    if-ge v4, v3, :cond_11

    .line 1183
    if-eqz v11, :cond_9

    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v20

    move/from16 v31, v11

    goto :goto_7

    :cond_9
    move/from16 v31, v11

    .end local v11    # "sampleDurationsPresent":Z
    .local v31, "sampleDurationsPresent":Z
    iget v11, v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;->duration:I

    move/from16 v20, v11

    :goto_7
    invoke-static/range {v20 .. v20}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->checkNonNegative(I)I

    move-result v11

    .line 1185
    .local v11, "sampleDuration":I
    if-eqz v12, :cond_a

    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v20

    move/from16 v32, v12

    goto :goto_8

    :cond_a
    move/from16 v32, v12

    .end local v12    # "sampleSizesPresent":Z
    .local v32, "sampleSizesPresent":Z
    iget v12, v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;->size:I

    move/from16 v20, v12

    :goto_8
    invoke-static/range {v20 .. v20}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->checkNonNegative(I)I

    move-result v12

    .line 1187
    .local v12, "sampleSize":I
    if-eqz v13, :cond_b

    .line 1188
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v20

    move/from16 v33, v7

    goto :goto_9

    .line 1189
    :cond_b
    if-nez v4, :cond_c

    if-eqz v7, :cond_c

    move/from16 v33, v7

    move/from16 v20, v28

    goto :goto_9

    :cond_c
    move/from16 v33, v7

    .end local v7    # "firstSampleFlagsPresent":Z
    .local v33, "firstSampleFlagsPresent":Z
    iget v7, v6, Landroidx/media3/extractor/mp4/DefaultSampleValues;->flags:I

    move/from16 v20, v7

    :goto_9
    move/from16 v7, v20

    .line 1190
    .local v7, "sampleFlags":I
    const/16 v20, 0x0

    .line 1191
    .local v20, "sampleCompositionTimeOffset":I
    if-eqz v14, :cond_d

    .line 1197
    invoke-virtual/range {p3 .. p3}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v20

    move-object/from16 v34, v6

    move/from16 v6, v20

    goto :goto_a

    .line 1191
    :cond_d
    move-object/from16 v34, v6

    move/from16 v6, v20

    .line 1199
    .end local v20    # "sampleCompositionTimeOffset":I
    .local v6, "sampleCompositionTimeOffset":I
    .local v34, "defaultSampleValues":Landroidx/media3/extractor/mp4/DefaultSampleValues;
    :goto_a
    move/from16 v35, v13

    move/from16 v36, v14

    .end local v13    # "sampleFlagsPresent":Z
    .end local v14    # "sampleCompositionTimeOffsetsPresent":Z
    .local v35, "sampleFlagsPresent":Z
    .local v36, "sampleCompositionTimeOffsetsPresent":Z
    int-to-long v13, v6

    add-long/2addr v13, v9

    sub-long/2addr v13, v15

    .line 1200
    .local v13, "samplePresentationTime":J
    const-wide/32 v22, 0xf4240

    .line 1201
    move-wide/from16 v20, v13

    move-wide/from16 v24, v1

    invoke-static/range {v20 .. v25}, Landroidx/media3/common/util/Util;->scaleLargeTimestamp(JJJ)J

    move-result-wide v20

    aput-wide v20, v8, v4

    .line 1202
    move-wide/from16 v20, v1

    .end local v1    # "timescale":J
    .local v20, "timescale":J
    iget-boolean v1, v5, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTimeIncludesMoov:Z

    if-nez v1, :cond_e

    .line 1203
    aget-wide v1, v8, v4

    move/from16 v22, v6

    .end local v6    # "sampleCompositionTimeOffset":I
    .local v22, "sampleCompositionTimeOffset":I
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    move-wide/from16 v23, v13

    .end local v13    # "samplePresentationTime":J
    .local v23, "samplePresentationTime":J
    iget-wide v13, v6, Landroidx/media3/extractor/mp4/TrackSampleTable;->durationUs:J

    add-long/2addr v1, v13

    aput-wide v1, v8, v4

    goto :goto_b

    .line 1202
    .end local v22    # "sampleCompositionTimeOffset":I
    .end local v23    # "samplePresentationTime":J
    .restart local v6    # "sampleCompositionTimeOffset":I
    .restart local v13    # "samplePresentationTime":J
    :cond_e
    move/from16 v22, v6

    move-wide/from16 v23, v13

    .line 1205
    .end local v6    # "sampleCompositionTimeOffset":I
    .end local v13    # "samplePresentationTime":J
    .restart local v22    # "sampleCompositionTimeOffset":I
    .restart local v23    # "samplePresentationTime":J
    :goto_b
    aput v12, v29, v4

    .line 1206
    shr-int/lit8 v1, v7, 0x10

    const/4 v2, 0x1

    and-int/2addr v1, v2

    if-nez v1, :cond_10

    if-eqz v27, :cond_f

    if-nez v4, :cond_10

    :cond_f
    move v1, v2

    goto :goto_c

    :cond_10
    const/4 v1, 0x0

    :goto_c
    aput-boolean v1, v26, v4

    .line 1208
    int-to-long v13, v11

    add-long/2addr v9, v13

    .line 1180
    .end local v7    # "sampleFlags":I
    .end local v11    # "sampleDuration":I
    .end local v12    # "sampleSize":I
    .end local v22    # "sampleCompositionTimeOffset":I
    .end local v23    # "samplePresentationTime":J
    add-int/lit8 v4, v4, 0x1

    move-wide/from16 v1, v20

    move/from16 v11, v31

    move/from16 v12, v32

    move/from16 v7, v33

    move-object/from16 v6, v34

    move/from16 v13, v35

    move/from16 v14, v36

    goto/16 :goto_6

    .line 1210
    .end local v4    # "i":I
    .end local v20    # "timescale":J
    .end local v31    # "sampleDurationsPresent":Z
    .end local v32    # "sampleSizesPresent":Z
    .end local v33    # "firstSampleFlagsPresent":Z
    .end local v34    # "defaultSampleValues":Landroidx/media3/extractor/mp4/DefaultSampleValues;
    .end local v35    # "sampleFlagsPresent":Z
    .end local v36    # "sampleCompositionTimeOffsetsPresent":Z
    .restart local v1    # "timescale":J
    .local v6, "defaultSampleValues":Landroidx/media3/extractor/mp4/DefaultSampleValues;
    .local v7, "firstSampleFlagsPresent":Z
    .local v11, "sampleDurationsPresent":Z
    .local v12, "sampleSizesPresent":Z
    .local v13, "sampleFlagsPresent":Z
    .restart local v14    # "sampleCompositionTimeOffsetsPresent":Z
    :cond_11
    iput-wide v9, v5, Landroidx/media3/extractor/mp4/TrackFragment;->nextFragmentDecodeTime:J

    .line 1211
    return v3
.end method

.method private static parseTruns(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;I)V
    .locals 11
    .param p0, "traf"    # Landroidx/media3/extractor/mp4/Atom$ContainerAtom;
    .param p1, "trackBundle"    # Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 928
    const/4 v0, 0x0

    .line 929
    .local v0, "trunCount":I
    const/4 v1, 0x0

    .line 930
    .local v1, "totalSampleCount":I
    iget-object v2, p0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->leafChildren:Ljava/util/List;

    .line 931
    .local v2, "leafChildren":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/extractor/mp4/Atom$LeafAtom;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    .line 932
    .local v3, "leafChildrenSize":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    const v5, 0x7472756e

    if-ge v4, v3, :cond_1

    .line 933
    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 934
    .local v6, "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v7, v6, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    if-ne v7, v5, :cond_0

    .line 935
    iget-object v5, v6, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 936
    .local v5, "trunData":Landroidx/media3/common/util/ParsableByteArray;
    const/16 v7, 0xc

    invoke-virtual {v5, v7}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 937
    invoke-virtual {v5}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedIntToInt()I

    move-result v7

    .line 938
    .local v7, "trunSampleCount":I
    if-lez v7, :cond_0

    .line 939
    add-int/2addr v1, v7

    .line 940
    add-int/lit8 v0, v0, 0x1

    .line 932
    .end local v5    # "trunData":Landroidx/media3/common/util/ParsableByteArray;
    .end local v6    # "atom":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v7    # "trunSampleCount":I
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 944
    .end local v4    # "i":I
    :cond_1
    const/4 v4, 0x0

    iput v4, p1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentTrackRunIndex:I

    .line 945
    iput v4, p1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentSampleInTrackRun:I

    .line 946
    iput v4, p1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentSampleIndex:I

    .line 947
    iget-object v4, p1, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    invoke-virtual {v4, v0, v1}, Landroidx/media3/extractor/mp4/TrackFragment;->initTables(II)V

    .line 949
    const/4 v4, 0x0

    .line 950
    .local v4, "trunIndex":I
    const/4 v6, 0x0

    .line 951
    .local v6, "trunStartPosition":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    if-ge v7, v3, :cond_3

    .line 952
    invoke-interface {v2, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    .line 953
    .local v8, "trun":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    iget v9, v8, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->type:I

    if-ne v9, v5, :cond_2

    .line 954
    add-int/lit8 v9, v4, 0x1

    .end local v4    # "trunIndex":I
    .local v9, "trunIndex":I
    iget-object v10, v8, Landroidx/media3/extractor/mp4/Atom$LeafAtom;->data:Landroidx/media3/common/util/ParsableByteArray;

    .line 955
    invoke-static {p1, v4, p2, v10, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseTrun(Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;IILandroidx/media3/common/util/ParsableByteArray;I)I

    move-result v4

    move v6, v4

    move v4, v9

    .line 951
    .end local v8    # "trun":Landroidx/media3/extractor/mp4/Atom$LeafAtom;
    .end local v9    # "trunIndex":I
    .restart local v4    # "trunIndex":I
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 958
    .end local v7    # "i":I
    :cond_3
    return-void
.end method

.method private static parseUuid(Landroidx/media3/common/util/ParsableByteArray;Landroidx/media3/extractor/mp4/TrackFragment;[B)V
    .locals 2
    .param p0, "uuid"    # Landroidx/media3/common/util/ParsableByteArray;
    .param p1, "out"    # Landroidx/media3/extractor/mp4/TrackFragment;
    .param p2, "extendedTypeScratch"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 1225
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1226
    const/4 v0, 0x0

    const/16 v1, 0x10

    invoke-virtual {p0, p2, v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->readBytes([BII)V

    .line 1229
    sget-object v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE:[B

    invoke-static {p2, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1230
    return-void

    .line 1236
    :cond_0
    invoke-static {p0, v1, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parseSenc(Landroidx/media3/common/util/ParsableByteArray;ILandroidx/media3/extractor/mp4/TrackFragment;)V

    .line 1237
    return-void
.end method

.method private processAtomEnded(J)V
    .locals 2
    .param p1, "atomEndPosition"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 584
    nop

    :goto_0
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    iget-wide v0, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->endPosition:J

    cmp-long v0, v0, p1

    if-nez v0, :cond_0

    .line 585
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    invoke-direct {p0, v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->onContainerAtomRead(Landroidx/media3/extractor/mp4/Atom$ContainerAtom;)V

    goto :goto_0

    .line 587
    :cond_0
    invoke-direct {p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->enterReadingAtomHeaderState()V

    .line 588
    return-void
.end method

.method private readAtomHeader(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 11
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 476
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    const/16 v1, 0x8

    const/4 v2, 0x0

    const/4 v3, 0x1

    if-nez v0, :cond_1

    .line 478
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    invoke-interface {p1, v0, v2, v1, v3}, Landroidx/media3/extractor/ExtractorInput;->readFully([BIIZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 479
    return v2

    .line 481
    :cond_0
    iput v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    .line 482
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 483
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedInt()J

    move-result-wide v4

    iput-wide v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    .line 484
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v0

    iput v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    .line 487
    :cond_1
    iget-wide v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    const-wide/16 v6, 0x1

    cmp-long v0, v4, v6

    if-nez v0, :cond_2

    .line 489
    const/16 v0, 0x8

    .line 490
    .local v0, "headerBytesRemaining":I
    iget-object v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v4

    invoke-interface {p1, v4, v1, v0}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 491
    iget v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    add-int/2addr v4, v0

    iput v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    .line 492
    iget-object v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedLongToLong()J

    move-result-wide v4

    iput-wide v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    .end local v0    # "headerBytesRemaining":I
    goto :goto_0

    .line 493
    :cond_2
    const-wide/16 v6, 0x0

    cmp-long v0, v4, v6

    if-nez v0, :cond_4

    .line 496
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v4

    .line 497
    .local v4, "endPosition":J
    const-wide/16 v6, -0x1

    cmp-long v0, v4, v6

    if-nez v0, :cond_3

    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 498
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v0}, Ljava/util/ArrayDeque;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    iget-wide v4, v0, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;->endPosition:J

    .line 500
    :cond_3
    cmp-long v0, v4, v6

    if-eqz v0, :cond_5

    .line 501
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v6

    sub-long v6, v4, v6

    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    int-to-long v8, v0

    add-long/2addr v6, v8

    iput-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    goto :goto_1

    .line 493
    .end local v4    # "endPosition":J
    :cond_4
    :goto_0
    nop

    .line 505
    :cond_5
    :goto_1
    iget-wide v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    int-to-long v6, v0

    cmp-long v0, v4, v6

    if-ltz v0, :cond_10

    .line 510
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v4

    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    int-to-long v6, v0

    sub-long/2addr v4, v6

    .line 511
    .local v4, "atomPosition":J
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    const v6, 0x6d646174

    const v7, 0x6d6f6f66

    if-eq v0, v7, :cond_6

    if-ne v0, v6, :cond_7

    .line 512
    :cond_6
    iget-boolean v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->haveOutputSeekMap:Z

    if-nez v0, :cond_7

    .line 514
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v8, Landroidx/media3/extractor/SeekMap$Unseekable;

    iget-wide v9, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->durationUs:J

    invoke-direct {v8, v9, v10, v4, v5}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(JJ)V

    invoke-interface {v0, v8}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 515
    iput-boolean v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->haveOutputSeekMap:Z

    .line 519
    :cond_7
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    if-ne v0, v7, :cond_8

    .line 521
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v0

    .line 522
    .local v0, "trackCount":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_2
    if-ge v7, v0, :cond_8

    .line 523
    iget-object v8, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v8, v7}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget-object v8, v8, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    .line 524
    .local v8, "fragment":Landroidx/media3/extractor/mp4/TrackFragment;
    iput-wide v4, v8, Landroidx/media3/extractor/mp4/TrackFragment;->atomPosition:J

    .line 525
    iput-wide v4, v8, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    .line 526
    iput-wide v4, v8, Landroidx/media3/extractor/mp4/TrackFragment;->dataPosition:J

    .line 522
    .end local v8    # "fragment":Landroidx/media3/extractor/mp4/TrackFragment;
    add-int/lit8 v7, v7, 0x1

    goto :goto_2

    .line 530
    .end local v0    # "trackCount":I
    .end local v7    # "i":I
    :cond_8
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    const/4 v7, 0x0

    if-ne v0, v6, :cond_9

    .line 531
    iput-object v7, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 532
    iget-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    add-long/2addr v0, v4

    iput-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->endOfMdatPosition:J

    .line 533
    const/4 v0, 0x2

    iput v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 534
    return v3

    .line 537
    :cond_9
    invoke-static {v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->shouldParseContainerAtom(I)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 538
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v0

    iget-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    add-long/2addr v0, v6

    const-wide/16 v6, 0x8

    sub-long/2addr v0, v6

    .line 539
    .local v0, "endPosition":J
    iget-object v2, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    new-instance v6, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;

    iget v7, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    invoke-direct {v6, v7, v0, v1}, Landroidx/media3/extractor/mp4/Atom$ContainerAtom;-><init>(IJ)V

    invoke-virtual {v2, v6}, Ljava/util/ArrayDeque;->push(Ljava/lang/Object;)V

    .line 540
    iget-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    iget v2, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    int-to-long v8, v2

    cmp-long v2, v6, v8

    if-nez v2, :cond_a

    .line 541
    invoke-direct {p0, v0, v1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->processAtomEnded(J)V

    goto :goto_3

    .line 544
    :cond_a
    invoke-direct {p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->enterReadingAtomHeaderState()V

    .line 546
    .end local v0    # "endPosition":J
    :goto_3
    goto :goto_4

    :cond_b
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    invoke-static {v0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->shouldParseLeafAtom(I)Z

    move-result v0

    const-wide/32 v8, 0x7fffffff

    if-eqz v0, :cond_e

    .line 547
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    if-ne v0, v1, :cond_d

    .line 551
    iget-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    cmp-long v0, v6, v8

    if-gtz v0, :cond_c

    .line 555
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    iget-wide v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    long-to-int v6, v6

    invoke-direct {v0, v6}, Landroidx/media3/common/util/ParsableByteArray;-><init>(I)V

    .line 556
    .local v0, "atomData":Landroidx/media3/common/util/ParsableByteArray;
    iget-object v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeader:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v7

    invoke-static {v6, v2, v7, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 557
    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomData:Landroidx/media3/common/util/ParsableByteArray;

    .line 558
    iput v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 559
    .end local v0    # "atomData":Landroidx/media3/common/util/ParsableByteArray;
    goto :goto_4

    .line 552
    :cond_c
    const-string v0, "Leaf atom with length > 2147483647 (unsupported)."

    invoke-static {v0}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 548
    :cond_d
    const-string v0, "Leaf atom defines extended atom size (unsupported)."

    invoke-static {v0}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 560
    :cond_e
    iget-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    cmp-long v0, v0, v8

    if-gtz v0, :cond_f

    .line 564
    iput-object v7, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomData:Landroidx/media3/common/util/ParsableByteArray;

    .line 565
    iput v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 568
    :goto_4
    return v3

    .line 561
    :cond_f
    const-string v0, "Skipping atom with length > 2147483647 (unsupported)."

    invoke-static {v0}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0

    .line 506
    .end local v4    # "atomPosition":J
    :cond_10
    const-string v0, "Atom size less than header length (unsupported)."

    invoke-static {v0}, Landroidx/media3/common/ParserException;->createForUnsupportedContainerFeature(Ljava/lang/String;)Landroidx/media3/common/ParserException;

    move-result-object v0

    throw v0
.end method

.method private readAtomPayload(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 5
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 572
    iget-wide v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomSize:J

    long-to-int v0, v0

    iget v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomHeaderBytesRead:I

    sub-int/2addr v0, v1

    .line 573
    .local v0, "atomPayloadSize":I
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomData:Landroidx/media3/common/util/ParsableByteArray;

    .line 574
    .local v1, "atomData":Landroidx/media3/common/util/ParsableByteArray;
    if-eqz v1, :cond_0

    .line 575
    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    const/16 v3, 0x8

    invoke-interface {p1, v2, v3, v0}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 576
    new-instance v2, Landroidx/media3/extractor/mp4/Atom$LeafAtom;

    iget v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->atomType:I

    invoke-direct {v2, v3, v1}, Landroidx/media3/extractor/mp4/Atom$LeafAtom;-><init>(ILandroidx/media3/common/util/ParsableByteArray;)V

    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v3

    invoke-direct {p0, v2, v3, v4}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->onLeafAtomRead(Landroidx/media3/extractor/mp4/Atom$LeafAtom;J)V

    goto :goto_0

    .line 578
    :cond_0
    invoke-interface {p1, v0}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 580
    :goto_0
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->processAtomEnded(J)V

    .line 581
    return-void
.end method

.method private readEncryptionData(Landroidx/media3/extractor/ExtractorInput;)V
    .locals 8
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1423
    const/4 v0, 0x0

    .line 1424
    .local v0, "nextTrackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    const-wide v1, 0x7fffffffffffffffL

    .line 1425
    .local v1, "nextDataOffset":J
    iget-object v3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v3}, Landroid/util/SparseArray;->size()I

    move-result v3

    .line 1426
    .local v3, "trackBundlesSize":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v3, :cond_1

    .line 1427
    iget-object v5, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v5, v4}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget-object v5, v5, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    .line 1428
    .local v5, "trackFragment":Landroidx/media3/extractor/mp4/TrackFragment;
    iget-boolean v6, v5, Landroidx/media3/extractor/mp4/TrackFragment;->sampleEncryptionDataNeedsFill:Z

    if-eqz v6, :cond_0

    iget-wide v6, v5, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    cmp-long v6, v6, v1

    if-gez v6, :cond_0

    .line 1430
    iget-wide v1, v5, Landroidx/media3/extractor/mp4/TrackFragment;->auxiliaryDataPosition:J

    .line 1431
    iget-object v6, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v6, v4}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v6

    move-object v0, v6

    check-cast v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1426
    .end local v5    # "trackFragment":Landroidx/media3/extractor/mp4/TrackFragment;
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 1434
    .end local v4    # "i":I
    :cond_1
    if-nez v0, :cond_2

    .line 1435
    const/4 v4, 0x3

    iput v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 1436
    return-void

    .line 1438
    :cond_2
    invoke-interface {p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v4

    sub-long v4, v1, v4

    long-to-int v4, v4

    .line 1439
    .local v4, "bytesToSkip":I
    if-ltz v4, :cond_3

    .line 1443
    invoke-interface {p1, v4}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 1444
    iget-object v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->fragment:Landroidx/media3/extractor/mp4/TrackFragment;

    invoke-virtual {v5, p1}, Landroidx/media3/extractor/mp4/TrackFragment;->fillEncryptionData(Landroidx/media3/extractor/ExtractorInput;)V

    .line 1445
    return-void

    .line 1440
    :cond_3
    const-string v5, "Offset to encryption data was negative."

    const/4 v6, 0x0

    invoke-static {v5, v6}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v5

    throw v5
.end method

.method private readSample(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 18
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 1463
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    iget-object v2, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1464
    .local v2, "trackBundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    const/4 v3, 0x0

    const/4 v4, 0x0

    if-nez v2, :cond_3

    .line 1465
    iget-object v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-static {v5}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->getNextTrackBundle(Landroid/util/SparseArray;)Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    move-result-object v2

    .line 1466
    if-nez v2, :cond_1

    .line 1469
    iget-wide v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->endOfMdatPosition:J

    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v7

    sub-long/2addr v5, v7

    long-to-int v5, v5

    .line 1470
    .local v5, "bytesToSkip":I
    if-ltz v5, :cond_0

    .line 1474
    invoke-interface {v1, v5}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 1475
    invoke-direct/range {p0 .. p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->enterReadingAtomHeaderState()V

    .line 1476
    return v4

    .line 1471
    :cond_0
    const-string v4, "Offset to end of mdat was negative."

    invoke-static {v4, v3}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 1479
    .end local v5    # "bytesToSkip":I
    :cond_1
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getCurrentSampleOffset()J

    move-result-wide v5

    .line 1481
    .local v5, "nextDataPosition":J
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v7

    sub-long v7, v5, v7

    long-to-int v7, v7

    .line 1482
    .local v7, "bytesToSkip":I
    if-gez v7, :cond_2

    .line 1484
    const-string v8, "FragmentedMp4Extractor"

    const-string v9, "Ignoring negative offset to sample data."

    invoke-static {v8, v9}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1485
    const/4 v7, 0x0

    .line 1487
    :cond_2
    invoke-interface {v1, v7}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 1488
    iput-object v2, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1490
    .end local v5    # "nextDataPosition":J
    .end local v7    # "bytesToSkip":I
    :cond_3
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    const/4 v6, 0x3

    const/4 v7, 0x4

    const/4 v8, 0x1

    if-ne v5, v6, :cond_8

    .line 1491
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getCurrentSampleSize()I

    move-result v5

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1493
    iget v5, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->currentSampleIndex:I

    iget v9, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->firstSampleToOutputIndex:I

    if-ge v5, v9, :cond_5

    .line 1494
    iget v4, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    invoke-interface {v1, v4}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 1495
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->skipSampleEncryptionData()V

    .line 1496
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->next()Z

    move-result v4

    if-nez v4, :cond_4

    .line 1497
    iput-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1499
    :cond_4
    iput v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 1500
    return v8

    .line 1503
    :cond_5
    iget-object v5, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v5, v5, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    iget v5, v5, Landroidx/media3/extractor/mp4/Track;->sampleTransformation:I

    if-ne v5, v8, :cond_6

    .line 1505
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    const/16 v9, 0x8

    sub-int/2addr v5, v9

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1506
    invoke-interface {v1, v9}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 1509
    :cond_6
    iget-object v5, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v5, v5, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    iget-object v5, v5, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget-object v5, v5, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    const-string v9, "audio/ac4"

    invoke-virtual {v9, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1511
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1512
    const/4 v9, 0x7

    invoke-virtual {v2, v5, v9}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->outputSampleEncryptionData(II)I

    move-result v5

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    .line 1513
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    iget-object v10, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-static {v5, v10}, Landroidx/media3/extractor/Ac4Util;->getAc4SampleHeader(ILandroidx/media3/common/util/ParsableByteArray;)V

    .line 1514
    iget-object v5, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->output:Landroidx/media3/extractor/TrackOutput;

    iget-object v10, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->scratch:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v5, v10, v9}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 1515
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    add-int/2addr v5, v9

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    goto :goto_0

    .line 1517
    :cond_7
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1518
    invoke-virtual {v2, v5, v4}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->outputSampleEncryptionData(II)I

    move-result v5

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    .line 1520
    :goto_0
    iget v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    iget v9, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    add-int/2addr v5, v9

    iput v5, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1521
    iput v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 1522
    iput v4, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    .line 1525
    :cond_8
    iget-object v5, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->moovSampleTable:Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v5, v5, Landroidx/media3/extractor/mp4/TrackSampleTable;->track:Landroidx/media3/extractor/mp4/Track;

    .line 1526
    .local v5, "track":Landroidx/media3/extractor/mp4/Track;
    iget-object v15, v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->output:Landroidx/media3/extractor/TrackOutput;

    .line 1527
    .local v15, "output":Landroidx/media3/extractor/TrackOutput;
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getCurrentSamplePresentationTimeUs()J

    move-result-wide v9

    .line 1528
    .local v9, "sampleTimeUs":J
    iget-object v11, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->timestampAdjuster:Landroidx/media3/common/util/TimestampAdjuster;

    if-eqz v11, :cond_9

    .line 1529
    invoke-virtual {v11, v9, v10}, Landroidx/media3/common/util/TimestampAdjuster;->adjustSampleTimestamp(J)J

    move-result-wide v9

    move-wide v13, v9

    goto :goto_1

    .line 1528
    :cond_9
    move-wide v13, v9

    .line 1531
    .end local v9    # "sampleTimeUs":J
    .local v13, "sampleTimeUs":J
    :goto_1
    iget v9, v5, Landroidx/media3/extractor/mp4/Track;->nalUnitLengthFieldLength:I

    if-eqz v9, :cond_f

    .line 1534
    iget-object v9, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v9}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v9

    .line 1535
    .local v9, "nalPrefixData":[B
    aput-byte v4, v9, v4

    .line 1536
    aput-byte v4, v9, v8

    .line 1537
    const/4 v10, 0x2

    aput-byte v4, v9, v10

    .line 1538
    iget v10, v5, Landroidx/media3/extractor/mp4/Track;->nalUnitLengthFieldLength:I

    add-int/2addr v10, v8

    .line 1539
    .local v10, "nalUnitPrefixLength":I
    iget v11, v5, Landroidx/media3/extractor/mp4/Track;->nalUnitLengthFieldLength:I

    rsub-int/lit8 v11, v11, 0x4

    .line 1543
    .local v11, "nalUnitLengthFieldLengthDiff":I
    :goto_2
    iget v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    iget v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    if-ge v12, v6, :cond_e

    .line 1544
    iget v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    if-nez v6, :cond_c

    .line 1546
    invoke-interface {v1, v9, v11, v10}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 1547
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1548
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v6

    .line 1549
    .local v6, "nalLengthInt":I
    if-lt v6, v8, :cond_b

    .line 1553
    add-int/lit8 v12, v6, -0x1

    iput v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    .line 1555
    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v12, v4}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1556
    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalStartCode:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v15, v12, v7}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 1558
    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalPrefix:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v15, v12, v8}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 1559
    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    array-length v12, v12

    if-lez v12, :cond_a

    iget-object v12, v5, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget-object v12, v12, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    aget-byte v8, v9, v7

    .line 1561
    invoke-static {v12, v8}, Landroidx/media3/container/NalUnitUtil;->isNalUnitSei(Ljava/lang/String;B)Z

    move-result v8

    if-eqz v8, :cond_a

    const/4 v8, 0x1

    goto :goto_3

    :cond_a
    move v8, v4

    :goto_3
    iput-boolean v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->processSeiNalUnitPayload:Z

    .line 1562
    iget v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    add-int/lit8 v8, v8, 0x5

    iput v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    .line 1563
    iget v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    add-int/2addr v8, v11

    iput v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    .line 1564
    .end local v6    # "nalLengthInt":I
    const/4 v6, 0x3

    const/4 v8, 0x1

    goto :goto_2

    .line 1550
    .restart local v6    # "nalLengthInt":I
    :cond_b
    const-string v4, "Invalid NAL length"

    invoke-static {v4, v3}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v3

    throw v3

    .line 1566
    .end local v6    # "nalLengthInt":I
    :cond_c
    iget-boolean v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->processSeiNalUnitPayload:Z

    if-eqz v8, :cond_d

    .line 1568
    iget-object v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v8, v6}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 1569
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v6

    iget v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    invoke-interface {v1, v6, v4, v8}, Landroidx/media3/extractor/ExtractorInput;->readFully([BII)V

    .line 1570
    iget-object v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    iget v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    invoke-interface {v15, v6, v8}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 1571
    iget v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    .line 1573
    .local v6, "writtenBytes":I
    iget-object v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 1574
    invoke-virtual {v8}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v8

    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v12}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v12

    invoke-static {v8, v12}, Landroidx/media3/container/NalUnitUtil;->unescapeStream([BI)I

    move-result v8

    .line 1576
    .local v8, "unescapedLength":I
    iget-object v12, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    iget-object v7, v5, Landroidx/media3/extractor/mp4/Track;->format:Landroidx/media3/common/Format;

    iget-object v7, v7, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    const-string/jumbo v3, "video/hevc"

    invoke-virtual {v3, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    invoke-virtual {v12, v3}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 1577
    iget-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v3, v8}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 1578
    iget-object v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->nalBuffer:Landroidx/media3/common/util/ParsableByteArray;

    iget-object v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->ceaTrackOutputs:[Landroidx/media3/extractor/TrackOutput;

    invoke-static {v13, v14, v3, v7}, Landroidx/media3/extractor/CeaUtil;->consume(JLandroidx/media3/common/util/ParsableByteArray;[Landroidx/media3/extractor/TrackOutput;)V

    .line 1579
    .end local v8    # "unescapedLength":I
    goto :goto_4

    .line 1581
    .end local v6    # "writtenBytes":I
    :cond_d
    invoke-interface {v15, v1, v6, v4}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/DataReader;IZ)I

    move-result v6

    .line 1583
    .restart local v6    # "writtenBytes":I
    :goto_4
    iget v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    add-int/2addr v3, v6

    iput v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    .line 1584
    iget v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    sub-int/2addr v3, v6

    iput v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleCurrentNalBytesRemaining:I

    .line 1585
    .end local v6    # "writtenBytes":I
    const/4 v3, 0x0

    const/4 v6, 0x3

    const/4 v7, 0x4

    const/4 v8, 0x1

    goto/16 :goto_2

    .line 1587
    .end local v9    # "nalPrefixData":[B
    .end local v10    # "nalUnitPrefixLength":I
    .end local v11    # "nalUnitLengthFieldLengthDiff":I
    :cond_e
    goto :goto_6

    .line 1588
    :cond_f
    :goto_5
    iget v3, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    iget v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    if-ge v3, v6, :cond_10

    .line 1589
    sub-int/2addr v6, v3

    invoke-interface {v15, v1, v6, v4}, Landroidx/media3/extractor/TrackOutput;->sampleData(Landroidx/media3/common/DataReader;IZ)I

    move-result v3

    .line 1590
    .local v3, "writtenBytes":I
    iget v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    add-int/2addr v6, v3

    iput v6, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleBytesWritten:I

    .line 1591
    .end local v3    # "writtenBytes":I
    goto :goto_5

    .line 1594
    :cond_10
    :goto_6
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getCurrentSampleFlags()I

    move-result v3

    .line 1597
    .local v3, "sampleFlags":I
    const/4 v4, 0x0

    .line 1598
    .local v4, "cryptoData":Landroidx/media3/extractor/TrackOutput$CryptoData;
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->getEncryptionBoxIfEncrypted()Landroidx/media3/extractor/mp4/TrackEncryptionBox;

    move-result-object v6

    .line 1599
    .local v6, "encryptionBox":Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    if-eqz v6, :cond_11

    .line 1600
    iget-object v4, v6, Landroidx/media3/extractor/mp4/TrackEncryptionBox;->cryptoData:Landroidx/media3/extractor/TrackOutput$CryptoData;

    .line 1603
    :cond_11
    iget v7, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sampleSize:I

    const/4 v8, 0x0

    move-object v9, v15

    move-wide v10, v13

    move v12, v3

    move-object/from16 v16, v5

    move-object/from16 v17, v6

    move-wide v5, v13

    .end local v6    # "encryptionBox":Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    .end local v13    # "sampleTimeUs":J
    .local v5, "sampleTimeUs":J
    .local v16, "track":Landroidx/media3/extractor/mp4/Track;
    .local v17, "encryptionBox":Landroidx/media3/extractor/mp4/TrackEncryptionBox;
    move v13, v7

    move v14, v8

    move-object v7, v15

    .end local v15    # "output":Landroidx/media3/extractor/TrackOutput;
    .local v7, "output":Landroidx/media3/extractor/TrackOutput;
    move-object v15, v4

    invoke-interface/range {v9 .. v15}, Landroidx/media3/extractor/TrackOutput;->sampleMetadata(JIIILandroidx/media3/extractor/TrackOutput$CryptoData;)V

    .line 1606
    invoke-direct {v0, v5, v6}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->outputPendingMetadataSamples(J)V

    .line 1607
    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->next()Z

    move-result v8

    if-nez v8, :cond_12

    .line 1608
    const/4 v8, 0x0

    iput-object v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->currentTrackBundle:Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    .line 1610
    :cond_12
    const/4 v8, 0x3

    iput v8, v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    .line 1611
    const/4 v8, 0x1

    return v8
.end method

.method private static shouldParseContainerAtom(I)Z
    .locals 1
    .param p0, "atom"    # I

    .line 1729
    const v0, 0x6d6f6f76

    if-eq p0, v0, :cond_1

    const v0, 0x7472616b

    if-eq p0, v0, :cond_1

    const v0, 0x6d646961

    if-eq p0, v0, :cond_1

    const v0, 0x6d696e66

    if-eq p0, v0, :cond_1

    const v0, 0x7374626c

    if-eq p0, v0, :cond_1

    const v0, 0x6d6f6f66

    if-eq p0, v0, :cond_1

    const v0, 0x74726166

    if-eq p0, v0, :cond_1

    const v0, 0x6d766578

    if-eq p0, v0, :cond_1

    const v0, 0x65647473

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method private static shouldParseLeafAtom(I)Z
    .locals 1
    .param p0, "atom"    # I

    .line 1697
    const v0, 0x68646c72    # 4.3148E24f

    if-eq p0, v0, :cond_1

    const v0, 0x6d646864

    if-eq p0, v0, :cond_1

    const v0, 0x6d766864

    if-eq p0, v0, :cond_1

    const v0, 0x73696478

    if-eq p0, v0, :cond_1

    const v0, 0x73747364

    if-eq p0, v0, :cond_1

    const v0, 0x73747473

    if-eq p0, v0, :cond_1

    const v0, 0x63747473

    if-eq p0, v0, :cond_1

    const v0, 0x73747363

    if-eq p0, v0, :cond_1

    const v0, 0x7374737a

    if-eq p0, v0, :cond_1

    const v0, 0x73747a32

    if-eq p0, v0, :cond_1

    const v0, 0x7374636f

    if-eq p0, v0, :cond_1

    const v0, 0x636f3634

    if-eq p0, v0, :cond_1

    const v0, 0x73747373

    if-eq p0, v0, :cond_1

    const v0, 0x74666474

    if-eq p0, v0, :cond_1

    const v0, 0x74666864

    if-eq p0, v0, :cond_1

    const v0, 0x746b6864

    if-eq p0, v0, :cond_1

    const v0, 0x74726578

    if-eq p0, v0, :cond_1

    const v0, 0x7472756e

    if-eq p0, v0, :cond_1

    const v0, 0x70737368    # 3.013775E29f

    if-eq p0, v0, :cond_1

    const v0, 0x7361697a

    if-eq p0, v0, :cond_1

    const v0, 0x7361696f

    if-eq p0, v0, :cond_1

    const v0, 0x73656e63

    if-eq p0, v0, :cond_1

    const v0, 0x75756964

    if-eq p0, v0, :cond_1

    const v0, 0x73626770

    if-eq p0, v0, :cond_1

    const v0, 0x73677064

    if-eq p0, v0, :cond_1

    const v0, 0x656c7374

    if-eq p0, v0, :cond_1

    const v0, 0x6d656864

    if-eq p0, v0, :cond_1

    const v0, 0x656d7367

    if-ne p0, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 13
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 401
    nop

    .line 402
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->flags:I

    and-int/lit8 v0, v0, 0x20

    if-nez v0, :cond_0

    .line 403
    new-instance v0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;

    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v0, p1, v1}, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;-><init>(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    goto :goto_0

    .line 404
    :cond_0
    move-object v0, p1

    :goto_0
    iput-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    .line 405
    invoke-direct {p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->enterReadingAtomHeaderState()V

    .line 406
    invoke-direct {p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->initExtraTracks()V

    .line 407
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    if-eqz v0, :cond_1

    .line 408
    new-instance v0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    iget v1, v1, Landroidx/media3/extractor/mp4/Track;->type:I

    .line 410
    const/4 v2, 0x0

    invoke-interface {p1, v2, v1}, Landroidx/media3/extractor/ExtractorOutput;->track(II)Landroidx/media3/extractor/TrackOutput;

    move-result-object v1

    new-instance v12, Landroidx/media3/extractor/mp4/TrackSampleTable;

    iget-object v4, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->sideloadedTrack:Landroidx/media3/extractor/mp4/Track;

    new-array v5, v2, [J

    new-array v6, v2, [I

    const/4 v7, 0x0

    new-array v8, v2, [J

    new-array v9, v2, [I

    const-wide/16 v10, 0x0

    move-object v3, v12

    invoke-direct/range {v3 .. v11}, Landroidx/media3/extractor/mp4/TrackSampleTable;-><init>(Landroidx/media3/extractor/mp4/Track;[J[II[J[IJ)V

    new-instance v3, Landroidx/media3/extractor/mp4/DefaultSampleValues;

    invoke-direct {v3, v2, v2, v2, v2}, Landroidx/media3/extractor/mp4/DefaultSampleValues;-><init>(IIII)V

    invoke-direct {v0, v1, v12, v3}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;-><init>(Landroidx/media3/extractor/TrackOutput;Landroidx/media3/extractor/mp4/TrackSampleTable;Landroidx/media3/extractor/mp4/DefaultSampleValues;)V

    .line 424
    .local v0, "bundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v1, v2, v0}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 425
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->extractorOutput:Landroidx/media3/extractor/ExtractorOutput;

    invoke-interface {v1}, Landroidx/media3/extractor/ExtractorOutput;->endTracks()V

    .line 427
    .end local v0    # "bundle":Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;
    :cond_1
    return-void
.end method

.method protected modifyTrack(Landroidx/media3/extractor/mp4/Track;)Landroidx/media3/extractor/mp4/Track;
    .locals 0
    .param p1, "track"    # Landroidx/media3/extractor/mp4/Track;

    .line 673
    return-object p1
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 1
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 450
    nop

    :cond_0
    :goto_0
    iget v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->parserState:I

    packed-switch v0, :pswitch_data_0

    .line 463
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->readSample(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 464
    const/4 v0, 0x0

    return v0

    .line 460
    :pswitch_0
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->readEncryptionData(Landroidx/media3/extractor/ExtractorInput;)V

    .line 461
    goto :goto_0

    .line 457
    :pswitch_1
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->readAtomPayload(Landroidx/media3/extractor/ExtractorInput;)V

    .line 458
    goto :goto_0

    .line 452
    :pswitch_2
    invoke-direct {p0, p1}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->readAtomHeader(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 453
    const/4 v0, -0x1

    return v0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public release()V
    .locals 0

    .line 445
    return-void
.end method

.method public seek(JJ)V
    .locals 3
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 431
    iget-object v0, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v0

    .line 432
    .local v0, "trackCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 433
    iget-object v2, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->trackBundles:Landroid/util/SparseArray;

    invoke-virtual {v2, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;

    invoke-virtual {v2}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor$TrackBundle;->resetFragmentInfo()V

    .line 432
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 435
    .end local v1    # "i":I
    :cond_0
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleInfos:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->clear()V

    .line 436
    const/4 v1, 0x0

    iput v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingMetadataSampleBytes:I

    .line 437
    iput-wide p3, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->pendingSeekTimeUs:J

    .line 438
    iget-object v1, p0, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->containerAtoms:Ljava/util/ArrayDeque;

    invoke-virtual {v1}, Ljava/util/ArrayDeque;->clear()V

    .line 439
    invoke-direct {p0}, Landroidx/media3/extractor/mp4/FragmentedMp4Extractor;->enterReadingAtomHeaderState()V

    .line 440
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 1
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 396
    invoke-static {p1}, Landroidx/media3/extractor/mp4/Sniffer;->sniffFragmented(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v0

    return v0
.end method
