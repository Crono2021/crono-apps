.class public final Landroidx/media3/extractor/ts/TsExtractor;
.super Ljava/lang/Object;
.source "TsExtractor.java"

# interfaces
.implements Landroidx/media3/extractor/Extractor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/extractor/ts/TsExtractor$PatReader;,
        Landroidx/media3/extractor/ts/TsExtractor$PmtReader;,
        Landroidx/media3/extractor/ts/TsExtractor$Flags;,
        Landroidx/media3/extractor/ts/TsExtractor$Mode;
    }
.end annotation


# static fields
.field private static final AC3_FORMAT_IDENTIFIER:J = 0x41432d33L

.field private static final AC4_FORMAT_IDENTIFIER:J = 0x41432d34L

.field private static final BUFFER_SIZE:I = 0x24b8

.field public static final DEFAULT_TIMESTAMP_SEARCH_BYTES:I = 0x1b8a0

.field private static final E_AC3_FORMAT_IDENTIFIER:J = 0x45414333L

.field public static final FACTORY:Landroidx/media3/extractor/ExtractorsFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field public static final FLAG_EMIT_RAW_SUBTITLE_DATA:I = 0x1

.field private static final HEVC_FORMAT_IDENTIFIER:J = 0x48455643L

.field private static final MAX_PID_PLUS_ONE:I = 0x2000

.field public static final MODE_HLS:I = 0x2

.field public static final MODE_MULTI_PMT:I = 0x0

.field public static final MODE_SINGLE_PMT:I = 0x1

.field private static final SNIFF_TS_PACKET_COUNT:I = 0x5

.field public static final TS_PACKET_SIZE:I = 0xbc

.field private static final TS_PAT_PID:I = 0x0

.field public static final TS_STREAM_TYPE_AAC_ADTS:I = 0xf

.field public static final TS_STREAM_TYPE_AAC_LATM:I = 0x11

.field public static final TS_STREAM_TYPE_AC3:I = 0x81

.field public static final TS_STREAM_TYPE_AC4:I = 0xac

.field public static final TS_STREAM_TYPE_AIT:I = 0x101

.field public static final TS_STREAM_TYPE_DC2_H262:I = 0x80

.field public static final TS_STREAM_TYPE_DTS:I = 0x8a

.field public static final TS_STREAM_TYPE_DTS_HD:I = 0x88

.field public static final TS_STREAM_TYPE_DTS_UHD:I = 0x8b

.field public static final TS_STREAM_TYPE_DVBSUBS:I = 0x59

.field public static final TS_STREAM_TYPE_E_AC3:I = 0x87

.field public static final TS_STREAM_TYPE_H262:I = 0x2

.field public static final TS_STREAM_TYPE_H263:I = 0x10

.field public static final TS_STREAM_TYPE_H264:I = 0x1b

.field public static final TS_STREAM_TYPE_H265:I = 0x24

.field public static final TS_STREAM_TYPE_HDMV_DTS:I = 0x82

.field public static final TS_STREAM_TYPE_ID3:I = 0x15

.field public static final TS_STREAM_TYPE_MPA:I = 0x3

.field public static final TS_STREAM_TYPE_MPA_LSF:I = 0x4

.field public static final TS_STREAM_TYPE_SPLICE_INFO:I = 0x86

.field public static final TS_SYNC_BYTE:I = 0x47


# instance fields
.field private bytesSinceLastSync:I

.field private final continuityCounters:Landroid/util/SparseIntArray;

.field private final durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

.field private final extractorFlags:I

.field private hasOutputSeekMap:Z

.field private id3Reader:Landroidx/media3/extractor/ts/TsPayloadReader;

.field private final mode:I

.field private output:Landroidx/media3/extractor/ExtractorOutput;

.field private final payloadReaderFactory:Landroidx/media3/extractor/ts/TsPayloadReader$Factory;

.field private pcrPid:I

.field private pendingSeekToStart:Z

.field private remainingPmts:I

.field private final subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

.field private final timestampAdjusters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/common/util/TimestampAdjuster;",
            ">;"
        }
    .end annotation
.end field

.field private final timestampSearchBytes:I

.field private final trackIds:Landroid/util/SparseBooleanArray;

.field private final trackPids:Landroid/util/SparseBooleanArray;

.field private tracksEnded:Z

.field private tsBinarySearchSeeker:Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

.field private final tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

.field private final tsPayloadReaders:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroidx/media3/extractor/ts/TsPayloadReader;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 116
    new-instance v0, Landroidx/media3/extractor/ts/TsExtractor$$ExternalSyntheticLambda1;

    invoke-direct {v0}, Landroidx/media3/extractor/ts/TsExtractor$$ExternalSyntheticLambda1;-><init>()V

    sput-object v0, Landroidx/media3/extractor/ts/TsExtractor;->FACTORY:Landroidx/media3/extractor/ExtractorsFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 7
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 190
    const/4 v1, 0x1

    const/4 v2, 0x1

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    new-instance v4, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v5, 0x0

    invoke-direct {v4, v5, v6}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v5, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    const/4 v0, 0x0

    invoke-direct {v5, v0}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(I)V

    const v6, 0x1b8a0

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 197
    return-void
.end method

.method public constructor <init>(I)V
    .locals 7
    .param p1, "defaultTsPayloadReaderFlags"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 238
    const/4 v1, 0x1

    const/4 v2, 0x1

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    new-instance v4, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v5, 0x0

    invoke-direct {v4, v5, v6}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v5, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    invoke-direct {v5, p1}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(I)V

    const v6, 0x1b8a0

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 245
    return-void
.end method

.method public constructor <init>(III)V
    .locals 7
    .param p1, "mode"    # I
    .param p2, "defaultTsPayloadReaderFlags"    # I
    .param p3, "timestampSearchBytes"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 256
    const/4 v2, 0x1

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    new-instance v4, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v0, 0x0

    invoke-direct {v4, v0, v1}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v5, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    invoke-direct {v5, p2}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(I)V

    move-object v0, p0

    move v1, p1

    move v6, p3

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 263
    return-void
.end method

.method public constructor <init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V
    .locals 3
    .param p1, "mode"    # I
    .param p2, "extractorFlags"    # I
    .param p3, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;
    .param p4, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p5, "payloadReaderFactory"    # Landroidx/media3/extractor/ts/TsPayloadReader$Factory;
    .param p6, "timestampSearchBytes"    # I

    .line 327
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 328
    invoke-static {p5}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/extractor/ts/TsPayloadReader$Factory;

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->payloadReaderFactory:Landroidx/media3/extractor/ts/TsPayloadReader$Factory;

    .line 329
    iput p6, p0, Landroidx/media3/extractor/ts/TsExtractor;->timestampSearchBytes:I

    .line 330
    iput p1, p0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    .line 331
    iput p2, p0, Landroidx/media3/extractor/ts/TsExtractor;->extractorFlags:I

    .line 332
    iput-object p3, p0, Landroidx/media3/extractor/ts/TsExtractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 333
    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    goto :goto_0

    .line 336
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->timestampAdjusters:Ljava/util/List;

    .line 337
    invoke-interface {v0, p4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 334
    :cond_1
    :goto_0
    invoke-static {p4}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->timestampAdjusters:Ljava/util/List;

    .line 339
    :goto_1
    new-instance v0, Landroidx/media3/common/util/ParsableByteArray;

    const/16 v1, 0x24b8

    new-array v1, v1, [B

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/media3/common/util/ParsableByteArray;-><init>([BI)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 340
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackIds:Landroid/util/SparseBooleanArray;

    .line 341
    new-instance v0, Landroid/util/SparseBooleanArray;

    invoke-direct {v0}, Landroid/util/SparseBooleanArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackPids:Landroid/util/SparseBooleanArray;

    .line 342
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    .line 343
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->continuityCounters:Landroid/util/SparseIntArray;

    .line 344
    new-instance v0, Landroidx/media3/extractor/ts/TsDurationReader;

    invoke-direct {v0, p6}, Landroidx/media3/extractor/ts/TsDurationReader;-><init>(I)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    .line 345
    sget-object v0, Landroidx/media3/extractor/ExtractorOutput;->PLACEHOLDER:Landroidx/media3/extractor/ExtractorOutput;

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    .line 346
    const/4 v0, -0x1

    iput v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->pcrPid:I

    .line 347
    invoke-direct {p0}, Landroidx/media3/extractor/ts/TsExtractor;->resetPayloadReaders()V

    .line 348
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;)V
    .locals 7
    .param p1, "mode"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p3, "payloadReaderFactory"    # Landroidx/media3/extractor/ts/TsPayloadReader$Factory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 274
    const/4 v2, 0x1

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    const v6, 0x1b8a0

    move-object v0, p0

    move v1, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 281
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V
    .locals 7
    .param p1, "mode"    # I
    .param p2, "timestampAdjuster"    # Landroidx/media3/common/util/TimestampAdjuster;
    .param p3, "payloadReaderFactory"    # Landroidx/media3/extractor/ts/TsPayloadReader$Factory;
    .param p4, "timestampSearchBytes"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 293
    const/4 v2, 0x1

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    move-object v0, p0

    move v1, p1

    move-object v4, p2

    move-object v5, p3

    move v6, p4

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 300
    return-void
.end method

.method public constructor <init>(ILandroidx/media3/extractor/text/SubtitleParser$Factory;)V
    .locals 7
    .param p1, "extractorFlags"    # I
    .param p2, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 223
    const/4 v1, 0x1

    new-instance v4, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v2, 0x0

    invoke-direct {v4, v2, v3}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v5, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    const/4 v0, 0x0

    invoke-direct {v5, v0}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(I)V

    const v6, 0x1b8a0

    move-object v0, p0

    move v2, p1

    move-object v3, p2

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 230
    return-void
.end method

.method public constructor <init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V
    .locals 7
    .param p1, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 206
    const/4 v1, 0x1

    const/4 v2, 0x0

    new-instance v4, Landroidx/media3/common/util/TimestampAdjuster;

    const-wide/16 v5, 0x0

    invoke-direct {v4, v5, v6}, Landroidx/media3/common/util/TimestampAdjuster;-><init>(J)V

    new-instance v5, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;

    const/4 v0, 0x0

    invoke-direct {v5, v0}, Landroidx/media3/extractor/ts/DefaultTsPayloadReaderFactory;-><init>(I)V

    const v6, 0x1b8a0

    move-object v0, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v6}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(IILandroidx/media3/extractor/text/SubtitleParser$Factory;Landroidx/media3/common/util/TimestampAdjuster;Landroidx/media3/extractor/ts/TsPayloadReader$Factory;I)V

    .line 213
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/extractor/ts/TsExtractor;)Landroid/util/SparseArray;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/media3/extractor/ts/TsExtractor;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->remainingPmts:I

    return v0
.end method

.method static synthetic access$1000(Landroidx/media3/extractor/ts/TsExtractor;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    return v0
.end method

.method static synthetic access$1002(Landroidx/media3/extractor/ts/TsExtractor;Z)Z
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;
    .param p1, "x1"    # Z

    .line 62
    iput-boolean p1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    return p1
.end method

.method static synthetic access$102(Landroidx/media3/extractor/ts/TsExtractor;I)I
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;
    .param p1, "x1"    # I

    .line 62
    iput p1, p0, Landroidx/media3/extractor/ts/TsExtractor;->remainingPmts:I

    return p1
.end method

.method static synthetic access$108(Landroidx/media3/extractor/ts/TsExtractor;)I
    .locals 2
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->remainingPmts:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->remainingPmts:I

    return v0
.end method

.method static synthetic access$200(Landroidx/media3/extractor/ts/TsExtractor;)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    return v0
.end method

.method static synthetic access$300(Landroidx/media3/extractor/ts/TsExtractor;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->timestampAdjusters:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$402(Landroidx/media3/extractor/ts/TsExtractor;I)I
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;
    .param p1, "x1"    # I

    .line 62
    iput p1, p0, Landroidx/media3/extractor/ts/TsExtractor;->pcrPid:I

    return p1
.end method

.method static synthetic access$500(Landroidx/media3/extractor/ts/TsExtractor;)Landroidx/media3/extractor/ts/TsPayloadReader;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->id3Reader:Landroidx/media3/extractor/ts/TsPayloadReader;

    return-object v0
.end method

.method static synthetic access$502(Landroidx/media3/extractor/ts/TsExtractor;Landroidx/media3/extractor/ts/TsPayloadReader;)Landroidx/media3/extractor/ts/TsPayloadReader;
    .locals 0
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;
    .param p1, "x1"    # Landroidx/media3/extractor/ts/TsPayloadReader;

    .line 62
    iput-object p1, p0, Landroidx/media3/extractor/ts/TsExtractor;->id3Reader:Landroidx/media3/extractor/ts/TsPayloadReader;

    return-object p1
.end method

.method static synthetic access$600(Landroidx/media3/extractor/ts/TsExtractor;)Landroidx/media3/extractor/ts/TsPayloadReader$Factory;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->payloadReaderFactory:Landroidx/media3/extractor/ts/TsPayloadReader$Factory;

    return-object v0
.end method

.method static synthetic access$700(Landroidx/media3/extractor/ts/TsExtractor;)Landroidx/media3/extractor/ExtractorOutput;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    return-object v0
.end method

.method static synthetic access$800(Landroidx/media3/extractor/ts/TsExtractor;)Landroid/util/SparseBooleanArray;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackIds:Landroid/util/SparseBooleanArray;

    return-object v0
.end method

.method static synthetic access$900(Landroidx/media3/extractor/ts/TsExtractor;)Landroid/util/SparseBooleanArray;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/ts/TsExtractor;

    .line 62
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackPids:Landroid/util/SparseBooleanArray;

    return-object v0
.end method

.method private fillBufferWithAtLeastOnePacket(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 7
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 546
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 548
    .local v0, "data":[B
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v1

    rsub-int v1, v1, 0x24b8

    const/4 v2, 0x0

    const/16 v3, 0xbc

    if-ge v1, v3, :cond_1

    .line 549
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v1

    .line 550
    .local v1, "bytesLeft":I
    if-lez v1, :cond_0

    .line 551
    iget-object v4, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v4

    invoke-static {v0, v4, v0, v2, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 553
    :cond_0
    iget-object v4, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4, v0, v1}, Landroidx/media3/common/util/ParsableByteArray;->reset([BI)V

    .line 556
    .end local v1    # "bytesLeft":I
    :cond_1
    :goto_0
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->bytesLeft()I

    move-result v1

    if-ge v1, v3, :cond_3

    .line 557
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v1

    .line 558
    .local v1, "limit":I
    rsub-int v4, v1, 0x24b8

    invoke-interface {p1, v0, v1, v4}, Landroidx/media3/extractor/ExtractorInput;->read([BII)I

    move-result v4

    .line 559
    .local v4, "read":I
    const/4 v5, -0x1

    if-ne v4, v5, :cond_2

    .line 560
    return v2

    .line 562
    :cond_2
    iget-object v5, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    add-int v6, v1, v4

    invoke-virtual {v5, v6}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 563
    .end local v1    # "limit":I
    .end local v4    # "read":I
    goto :goto_0

    .line 564
    :cond_3
    const/4 v1, 0x1

    return v1
.end method

.method private findEndOfFirstTsPacketInBuffer()I
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/common/ParserException;
        }
    .end annotation

    .line 574
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getPosition()I

    move-result v0

    .line 575
    .local v0, "searchStart":I
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v1}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v1

    .line 576
    .local v1, "limit":I
    iget-object v2, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    .line 577
    invoke-virtual {v2}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v2

    invoke-static {v2, v0, v1}, Landroidx/media3/extractor/ts/TsUtil;->findSyncBytePosition([BII)I

    move-result v2

    .line 580
    .local v2, "syncBytePosition":I
    iget-object v3, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v3, v2}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 581
    add-int/lit16 v3, v2, 0xbc

    .line 582
    .local v3, "endOfPacket":I
    if-le v3, v1, :cond_1

    .line 583
    iget v4, p0, Landroidx/media3/extractor/ts/TsExtractor;->bytesSinceLastSync:I

    sub-int v5, v2, v0

    add-int/2addr v4, v5

    iput v4, p0, Landroidx/media3/extractor/ts/TsExtractor;->bytesSinceLastSync:I

    .line 584
    iget v5, p0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    const/4 v6, 0x2

    if-ne v5, v6, :cond_2

    const/16 v5, 0x178

    if-gt v4, v5, :cond_0

    goto :goto_0

    .line 585
    :cond_0
    const-string v4, "Cannot find sync byte. Most likely not a Transport Stream."

    const/4 v5, 0x0

    invoke-static {v4, v5}, Landroidx/media3/common/ParserException;->createForMalformedContainer(Ljava/lang/String;Ljava/lang/Throwable;)Landroidx/media3/common/ParserException;

    move-result-object v4

    throw v4

    .line 590
    :cond_1
    const/4 v4, 0x0

    iput v4, p0, Landroidx/media3/extractor/ts/TsExtractor;->bytesSinceLastSync:I

    .line 592
    :cond_2
    :goto_0
    return v3
.end method

.method static synthetic lambda$newFactory$0(Landroidx/media3/extractor/text/SubtitleParser$Factory;)[Landroidx/media3/extractor/Extractor;
    .locals 3
    .param p0, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 69
    const/4 v0, 0x1

    new-array v0, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v1, Landroidx/media3/extractor/ts/TsExtractor;

    invoke-direct {v1, p0}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    const/4 v2, 0x0

    aput-object v1, v0, v2

    return-object v0
.end method

.method static synthetic lambda$static$1()[Landroidx/media3/extractor/Extractor;
    .locals 4

    .line 118
    const/4 v0, 0x1

    new-array v1, v0, [Landroidx/media3/extractor/Extractor;

    new-instance v2, Landroidx/media3/extractor/ts/TsExtractor;

    sget-object v3, Landroidx/media3/extractor/text/SubtitleParser$Factory;->UNSUPPORTED:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v2, v0, v3}, Landroidx/media3/extractor/ts/TsExtractor;-><init>(ILandroidx/media3/extractor/text/SubtitleParser$Factory;)V

    const/4 v0, 0x0

    aput-object v2, v1, v0

    return-object v1
.end method

.method private maybeOutputSeekMap(J)V
    .locals 9
    .param p1, "inputLength"    # J

    .line 528
    iget-boolean v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->hasOutputSeekMap:Z

    if-nez v0, :cond_1

    .line 529
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->hasOutputSeekMap:Z

    .line 530
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/TsDurationReader;->getDurationUs()J

    move-result-wide v0

    const-wide v2, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 531
    new-instance v0, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    .line 533
    invoke-virtual {v1}, Landroidx/media3/extractor/ts/TsDurationReader;->getPcrTimestampAdjuster()Landroidx/media3/common/util/TimestampAdjuster;

    move-result-object v2

    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    .line 534
    invoke-virtual {v1}, Landroidx/media3/extractor/ts/TsDurationReader;->getDurationUs()J

    move-result-wide v3

    iget v7, p0, Landroidx/media3/extractor/ts/TsExtractor;->pcrPid:I

    iget v8, p0, Landroidx/media3/extractor/ts/TsExtractor;->timestampSearchBytes:I

    move-object v1, v0

    move-wide v5, p1

    invoke-direct/range {v1 .. v8}, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;-><init>(Landroidx/media3/common/util/TimestampAdjuster;JJII)V

    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsBinarySearchSeeker:Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

    .line 538
    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    invoke-virtual {v0}, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;->getSeekMap()Landroidx/media3/extractor/SeekMap;

    move-result-object v0

    invoke-interface {v1, v0}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    goto :goto_0

    .line 540
    :cond_0
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    new-instance v1, Landroidx/media3/extractor/SeekMap$Unseekable;

    iget-object v2, p0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    invoke-virtual {v2}, Landroidx/media3/extractor/ts/TsDurationReader;->getDurationUs()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Landroidx/media3/extractor/SeekMap$Unseekable;-><init>(J)V

    invoke-interface {v0, v1}, Landroidx/media3/extractor/ExtractorOutput;->seekMap(Landroidx/media3/extractor/SeekMap;)V

    .line 543
    :cond_1
    :goto_0
    return-void
.end method

.method public static newFactory(Landroidx/media3/extractor/text/SubtitleParser$Factory;)Landroidx/media3/extractor/ExtractorsFactory;
    .locals 1
    .param p0, "subtitleParserFactory"    # Landroidx/media3/extractor/text/SubtitleParser$Factory;

    .line 69
    new-instance v0, Landroidx/media3/extractor/ts/TsExtractor$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Landroidx/media3/extractor/ts/TsExtractor$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    return-object v0
.end method

.method private resetPayloadReaders()V
    .locals 6

    .line 602
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackIds:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->clear()V

    .line 603
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 604
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->payloadReaderFactory:Landroidx/media3/extractor/ts/TsPayloadReader$Factory;

    .line 605
    invoke-interface {v0}, Landroidx/media3/extractor/ts/TsPayloadReader$Factory;->createInitialPayloadReaders()Landroid/util/SparseArray;

    move-result-object v0

    .line 606
    .local v0, "initialPayloadReaders":Landroid/util/SparseArray;, "Landroid/util/SparseArray<Landroidx/media3/extractor/ts/TsPayloadReader;>;"
    invoke-virtual {v0}, Landroid/util/SparseArray;->size()I

    move-result v1

    .line 607
    .local v1, "initialPayloadReadersSize":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 608
    iget-object v3, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v4

    invoke-virtual {v0, v2}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/ts/TsPayloadReader;

    invoke-virtual {v3, v4, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 607
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 610
    .end local v2    # "i":I
    :cond_0
    iget-object v2, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    new-instance v3, Landroidx/media3/extractor/ts/SectionReader;

    new-instance v4, Landroidx/media3/extractor/ts/TsExtractor$PatReader;

    invoke-direct {v4, p0}, Landroidx/media3/extractor/ts/TsExtractor$PatReader;-><init>(Landroidx/media3/extractor/ts/TsExtractor;)V

    invoke-direct {v3, v4}, Landroidx/media3/extractor/ts/SectionReader;-><init>(Landroidx/media3/extractor/ts/SectionPayloadReader;)V

    const/4 v4, 0x0

    invoke-virtual {v2, v4, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 611
    const/4 v2, 0x0

    iput-object v2, p0, Landroidx/media3/extractor/ts/TsExtractor;->id3Reader:Landroidx/media3/extractor/ts/TsPayloadReader;

    .line 612
    return-void
.end method

.method private shouldConsumePacketPayload(I)Z
    .locals 2
    .param p1, "packetPid"    # I

    .line 596
    iget v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    iget-boolean v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->trackPids:Landroid/util/SparseBooleanArray;

    .line 598
    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v1, 0x1

    .line 596
    :cond_1
    return v1
.end method


# virtual methods
.method public init(Landroidx/media3/extractor/ExtractorOutput;)V
    .locals 2
    .param p1, "output"    # Landroidx/media3/extractor/ExtractorOutput;

    .line 375
    nop

    .line 376
    iget v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->extractorFlags:I

    and-int/lit8 v0, v0, 0x1

    if-nez v0, :cond_0

    .line 377
    new-instance v0, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;

    iget-object v1, p0, Landroidx/media3/extractor/ts/TsExtractor;->subtitleParserFactory:Landroidx/media3/extractor/text/SubtitleParser$Factory;

    invoke-direct {v0, p1, v1}, Landroidx/media3/extractor/text/SubtitleTranscodingExtractorOutput;-><init>(Landroidx/media3/extractor/ExtractorOutput;Landroidx/media3/extractor/text/SubtitleParser$Factory;)V

    goto :goto_0

    .line 378
    :cond_0
    move-object v0, p1

    :goto_0
    iput-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->output:Landroidx/media3/extractor/ExtractorOutput;

    .line 379
    return-void
.end method

.method public read(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I
    .locals 17
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .param p2, "seekPosition"    # Landroidx/media3/extractor/PositionHolder;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 426
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getLength()J

    move-result-wide v3

    .line 427
    .local v3, "inputLength":J
    iget-boolean v5, v0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    const-wide/16 v6, -0x1

    const/4 v8, 0x2

    const/4 v9, 0x1

    const/4 v10, 0x0

    if-eqz v5, :cond_3

    .line 428
    cmp-long v5, v3, v6

    if-eqz v5, :cond_0

    iget v5, v0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    if-eq v5, v8, :cond_0

    move v5, v9

    goto :goto_0

    :cond_0
    move v5, v10

    .line 429
    .local v5, "canReadDuration":Z
    :goto_0
    if-eqz v5, :cond_1

    iget-object v11, v0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    invoke-virtual {v11}, Landroidx/media3/extractor/ts/TsDurationReader;->isDurationReadFinished()Z

    move-result v11

    if-nez v11, :cond_1

    .line 430
    iget-object v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->durationReader:Landroidx/media3/extractor/ts/TsDurationReader;

    iget v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->pcrPid:I

    invoke-virtual {v6, v1, v2, v7}, Landroidx/media3/extractor/ts/TsDurationReader;->readDuration(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;I)I

    move-result v6

    return v6

    .line 432
    :cond_1
    invoke-direct {v0, v3, v4}, Landroidx/media3/extractor/ts/TsExtractor;->maybeOutputSeekMap(J)V

    .line 434
    iget-boolean v11, v0, Landroidx/media3/extractor/ts/TsExtractor;->pendingSeekToStart:Z

    if-eqz v11, :cond_2

    .line 435
    iput-boolean v10, v0, Landroidx/media3/extractor/ts/TsExtractor;->pendingSeekToStart:Z

    .line 436
    const-wide/16 v11, 0x0

    invoke-virtual {v0, v11, v12, v11, v12}, Landroidx/media3/extractor/ts/TsExtractor;->seek(JJ)V

    .line 437
    invoke-interface/range {p1 .. p1}, Landroidx/media3/extractor/ExtractorInput;->getPosition()J

    move-result-wide v13

    cmp-long v13, v13, v11

    if-eqz v13, :cond_2

    .line 438
    iput-wide v11, v2, Landroidx/media3/extractor/PositionHolder;->position:J

    .line 439
    return v9

    .line 443
    :cond_2
    iget-object v11, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsBinarySearchSeeker:Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

    if-eqz v11, :cond_3

    invoke-virtual {v11}, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;->isSeeking()Z

    move-result v11

    if-eqz v11, :cond_3

    .line 444
    iget-object v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsBinarySearchSeeker:Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

    invoke-virtual {v6, v1, v2}, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;->handlePendingSeek(Landroidx/media3/extractor/ExtractorInput;Landroidx/media3/extractor/PositionHolder;)I

    move-result v6

    return v6

    .line 448
    .end local v5    # "canReadDuration":Z
    :cond_3
    invoke-direct/range {p0 .. p1}, Landroidx/media3/extractor/ts/TsExtractor;->fillBufferWithAtLeastOnePacket(Landroidx/media3/extractor/ExtractorInput;)Z

    move-result v5

    if-nez v5, :cond_4

    .line 449
    const/4 v5, -0x1

    return v5

    .line 452
    :cond_4
    invoke-direct/range {p0 .. p0}, Landroidx/media3/extractor/ts/TsExtractor;->findEndOfFirstTsPacketInBuffer()I

    move-result v5

    .line 453
    .local v5, "endOfPacket":I
    iget-object v11, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v11}, Landroidx/media3/common/util/ParsableByteArray;->limit()I

    move-result v11

    .line 454
    .local v11, "limit":I
    if-le v5, v11, :cond_5

    .line 455
    return v10

    .line 458
    :cond_5
    const/4 v12, 0x0

    .line 461
    .local v12, "packetHeaderFlags":I
    iget-object v13, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v13}, Landroidx/media3/common/util/ParsableByteArray;->readInt()I

    move-result v13

    .line 462
    .local v13, "tsPacketHeader":I
    const/high16 v14, 0x800000

    and-int/2addr v14, v13

    if-eqz v14, :cond_6

    .line 464
    iget-object v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 465
    return v10

    .line 467
    :cond_6
    const/high16 v14, 0x400000

    and-int/2addr v14, v13

    if-eqz v14, :cond_7

    move v14, v9

    goto :goto_1

    :cond_7
    move v14, v10

    :goto_1
    or-int/2addr v12, v14

    .line 469
    const v14, 0x1fff00

    and-int/2addr v14, v13

    shr-int/lit8 v14, v14, 0x8

    .line 471
    .local v14, "pid":I
    and-int/lit8 v15, v13, 0x20

    if-eqz v15, :cond_8

    move v15, v9

    goto :goto_2

    :cond_8
    move v15, v10

    .line 472
    .local v15, "adaptationFieldExists":Z
    :goto_2
    and-int/lit8 v16, v13, 0x10

    if-eqz v16, :cond_9

    move/from16 v16, v9

    goto :goto_3

    :cond_9
    move/from16 v16, v10

    .line 474
    .local v16, "payloadExists":Z
    :goto_3
    if-eqz v16, :cond_a

    iget-object v9, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v9, v14}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/media3/extractor/ts/TsPayloadReader;

    goto :goto_4

    :cond_a
    const/4 v9, 0x0

    .line 475
    .local v9, "payloadReader":Landroidx/media3/extractor/ts/TsPayloadReader;
    :goto_4
    if-nez v9, :cond_b

    .line 476
    iget-object v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 477
    return v10

    .line 481
    :cond_b
    iget v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    if-eq v6, v8, :cond_d

    .line 482
    and-int/lit8 v6, v13, 0xf

    .line 483
    .local v6, "continuityCounter":I
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->continuityCounters:Landroid/util/SparseIntArray;

    add-int/lit8 v8, v6, -0x1

    invoke-virtual {v7, v14, v8}, Landroid/util/SparseIntArray;->get(II)I

    move-result v7

    .line 484
    .local v7, "previousCounter":I
    iget-object v8, v0, Landroidx/media3/extractor/ts/TsExtractor;->continuityCounters:Landroid/util/SparseIntArray;

    invoke-virtual {v8, v14, v6}, Landroid/util/SparseIntArray;->put(II)V

    .line 485
    if-ne v7, v6, :cond_c

    .line 487
    iget-object v8, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v8, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 488
    return v10

    .line 489
    :cond_c
    add-int/lit8 v8, v7, 0x1

    and-int/lit8 v8, v8, 0xf

    if-eq v6, v8, :cond_d

    .line 491
    invoke-interface {v9}, Landroidx/media3/extractor/ts/TsPayloadReader;->seek()V

    .line 496
    .end local v6    # "continuityCounter":I
    .end local v7    # "previousCounter":I
    :cond_d
    if-eqz v15, :cond_f

    .line 497
    iget-object v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v6}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v6

    .line 498
    .local v6, "adaptationFieldLength":I
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7}, Landroidx/media3/common/util/ParsableByteArray;->readUnsignedByte()I

    move-result v7

    .line 500
    .local v7, "adaptationFieldFlags":I
    nop

    .line 501
    and-int/lit8 v8, v7, 0x40

    if-eqz v8, :cond_e

    .line 502
    const/4 v8, 0x2

    goto :goto_5

    .line 503
    :cond_e
    move v8, v10

    :goto_5
    or-int/2addr v12, v8

    .line 504
    iget-object v8, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    add-int/lit8 v10, v6, -0x1

    invoke-virtual {v8, v10}, Landroidx/media3/common/util/ParsableByteArray;->skipBytes(I)V

    .line 508
    .end local v6    # "adaptationFieldLength":I
    .end local v7    # "adaptationFieldFlags":I
    :cond_f
    iget-boolean v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    .line 509
    .local v6, "wereTracksEnded":Z
    invoke-direct {v0, v14}, Landroidx/media3/extractor/ts/TsExtractor;->shouldConsumePacketPayload(I)Z

    move-result v7

    if-eqz v7, :cond_10

    .line 510
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7, v5}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 511
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-interface {v9, v7, v12}, Landroidx/media3/extractor/ts/TsPayloadReader;->consume(Landroidx/media3/common/util/ParsableByteArray;I)V

    .line 512
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7, v11}, Landroidx/media3/common/util/ParsableByteArray;->setLimit(I)V

    .line 514
    :cond_10
    iget v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    const/4 v8, 0x2

    if-eq v7, v8, :cond_11

    if-nez v6, :cond_11

    iget-boolean v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tracksEnded:Z

    if-eqz v7, :cond_11

    const-wide/16 v7, -0x1

    cmp-long v7, v3, v7

    if-eqz v7, :cond_11

    .line 518
    const/4 v7, 0x1

    iput-boolean v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->pendingSeekToStart:Z

    .line 521
    :cond_11
    iget-object v7, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v7, v5}, Landroidx/media3/common/util/ParsableByteArray;->setPosition(I)V

    .line 522
    const/4 v7, 0x0

    return v7
.end method

.method public release()V
    .locals 0

    .line 421
    return-void
.end method

.method public seek(JJ)V
    .locals 16
    .param p1, "position"    # J
    .param p3, "timeUs"    # J

    .line 383
    move-object/from16 v0, p0

    move-wide/from16 v1, p3

    iget v3, v0, Landroidx/media3/extractor/ts/TsExtractor;->mode:I

    const/4 v4, 0x2

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eq v3, v4, :cond_0

    move v3, v5

    goto :goto_0

    :cond_0
    move v3, v6

    :goto_0
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 384
    iget-object v3, v0, Landroidx/media3/extractor/ts/TsExtractor;->timestampAdjusters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    .line 385
    .local v3, "timestampAdjustersCount":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    const-wide/16 v7, 0x0

    if-ge v4, v3, :cond_5

    .line 386
    iget-object v9, v0, Landroidx/media3/extractor/ts/TsExtractor;->timestampAdjusters:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroidx/media3/common/util/TimestampAdjuster;

    .line 392
    .local v9, "timestampAdjuster":Landroidx/media3/common/util/TimestampAdjuster;
    invoke-virtual {v9}, Landroidx/media3/common/util/TimestampAdjuster;->getTimestampOffsetUs()J

    move-result-wide v10

    const-wide v12, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v10, v10, v12

    if-nez v10, :cond_1

    move v10, v5

    goto :goto_2

    :cond_1
    move v10, v6

    .line 393
    .local v10, "resetTimestampAdjuster":Z
    :goto_2
    if-nez v10, :cond_3

    .line 394
    invoke-virtual {v9}, Landroidx/media3/common/util/TimestampAdjuster;->getFirstSampleTimestampUs()J

    move-result-wide v14

    .line 398
    .local v14, "adjusterFirstSampleTimestampUs":J
    cmp-long v11, v14, v12

    if-eqz v11, :cond_2

    cmp-long v7, v14, v7

    if-eqz v7, :cond_2

    cmp-long v7, v14, v1

    if-eqz v7, :cond_2

    move v7, v5

    goto :goto_3

    :cond_2
    move v7, v6

    :goto_3
    move v10, v7

    .line 403
    .end local v14    # "adjusterFirstSampleTimestampUs":J
    :cond_3
    if-eqz v10, :cond_4

    .line 404
    invoke-virtual {v9, v1, v2}, Landroidx/media3/common/util/TimestampAdjuster;->reset(J)V

    .line 385
    .end local v9    # "timestampAdjuster":Landroidx/media3/common/util/TimestampAdjuster;
    .end local v10    # "resetTimestampAdjuster":Z
    :cond_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 407
    .end local v4    # "i":I
    :cond_5
    cmp-long v4, v1, v7

    if-eqz v4, :cond_6

    iget-object v4, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsBinarySearchSeeker:Landroidx/media3/extractor/ts/TsBinarySearchSeeker;

    if-eqz v4, :cond_6

    .line 408
    invoke-virtual {v4, v1, v2}, Landroidx/media3/extractor/ts/TsBinarySearchSeeker;->setSeekTargetUs(J)V

    .line 410
    :cond_6
    iget-object v4, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v4, v6}, Landroidx/media3/common/util/ParsableByteArray;->reset(I)V

    .line 411
    iget-object v4, v0, Landroidx/media3/extractor/ts/TsExtractor;->continuityCounters:Landroid/util/SparseIntArray;

    invoke-virtual {v4}, Landroid/util/SparseIntArray;->clear()V

    .line 412
    const/4 v4, 0x0

    .restart local v4    # "i":I
    :goto_4
    iget-object v5, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v5}, Landroid/util/SparseArray;->size()I

    move-result v5

    if-ge v4, v5, :cond_7

    .line 413
    iget-object v5, v0, Landroidx/media3/extractor/ts/TsExtractor;->tsPayloadReaders:Landroid/util/SparseArray;

    invoke-virtual {v5, v4}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/extractor/ts/TsPayloadReader;

    invoke-interface {v5}, Landroidx/media3/extractor/ts/TsPayloadReader;->seek()V

    .line 412
    add-int/lit8 v4, v4, 0x1

    goto :goto_4

    .line 415
    .end local v4    # "i":I
    :cond_7
    iput v6, v0, Landroidx/media3/extractor/ts/TsExtractor;->bytesSinceLastSync:I

    .line 416
    return-void
.end method

.method public sniff(Landroidx/media3/extractor/ExtractorInput;)Z
    .locals 7
    .param p1, "input"    # Landroidx/media3/extractor/ExtractorInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 354
    iget-object v0, p0, Landroidx/media3/extractor/ts/TsExtractor;->tsPacketBuffer:Landroidx/media3/common/util/ParsableByteArray;

    invoke-virtual {v0}, Landroidx/media3/common/util/ParsableByteArray;->getData()[B

    move-result-object v0

    .line 355
    .local v0, "buffer":[B
    const/16 v1, 0x3ac

    const/4 v2, 0x0

    invoke-interface {p1, v0, v2, v1}, Landroidx/media3/extractor/ExtractorInput;->peekFully([BII)V

    .line 356
    const/4 v1, 0x0

    .local v1, "startPosCandidate":I
    :goto_0
    const/16 v3, 0xbc

    if-ge v1, v3, :cond_3

    .line 358
    const/4 v3, 0x1

    .line 359
    .local v3, "isSyncBytePatternCorrect":Z
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_1
    const/4 v5, 0x5

    if-ge v4, v5, :cond_1

    .line 360
    mul-int/lit16 v5, v4, 0xbc

    add-int/2addr v5, v1

    aget-byte v5, v0, v5

    const/16 v6, 0x47

    if-eq v5, v6, :cond_0

    .line 361
    const/4 v3, 0x0

    .line 362
    goto :goto_2

    .line 359
    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 365
    .end local v4    # "i":I
    :cond_1
    :goto_2
    if-eqz v3, :cond_2

    .line 366
    invoke-interface {p1, v1}, Landroidx/media3/extractor/ExtractorInput;->skipFully(I)V

    .line 367
    const/4 v2, 0x1

    return v2

    .line 356
    .end local v3    # "isSyncBytePatternCorrect":Z
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 370
    .end local v1    # "startPosCandidate":I
    :cond_3
    return v2
.end method
