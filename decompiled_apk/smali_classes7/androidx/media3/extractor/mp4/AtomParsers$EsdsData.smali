.class final Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;
.super Ljava/lang/Object;
.source "AtomParsers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/extractor/mp4/AtomParsers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "EsdsData"
.end annotation


# instance fields
.field private final bitrate:J

.field private final initializationData:[B

.field private final mimeType:Ljava/lang/String;

.field private final peakBitrate:J


# direct methods
.method public constructor <init>(Ljava/lang/String;[BJJ)V
    .locals 0
    .param p1, "mimeType"    # Ljava/lang/String;
    .param p2, "initializationData"    # [B
    .param p3, "bitrate"    # J
    .param p5, "peakBitrate"    # J

    .line 2215
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2216
    iput-object p1, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->mimeType:Ljava/lang/String;

    .line 2217
    iput-object p2, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->initializationData:[B

    .line 2218
    iput-wide p3, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->bitrate:J

    .line 2219
    iput-wide p5, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->peakBitrate:J

    .line 2220
    return-void
.end method

.method static synthetic access$300(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    .line 2205
    iget-object v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->mimeType:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)[B
    .locals 1
    .param p0, "x0"    # Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    .line 2205
    iget-object v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->initializationData:[B

    return-object v0
.end method

.method static synthetic access$500(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    .line 2205
    iget-wide v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->peakBitrate:J

    return-wide v0
.end method

.method static synthetic access$600(Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;

    .line 2205
    iget-wide v0, p0, Landroidx/media3/extractor/mp4/AtomParsers$EsdsData;->bitrate:J

    return-wide v0
.end method
