.class public final Landroidx/media3/exoplayer/source/SilenceMediaSource;
.super Landroidx/media3/exoplayer/source/BaseMediaSource;
.source "SilenceMediaSource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceMediaPeriod;,
        Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceSampleStream;,
        Landroidx/media3/exoplayer/source/SilenceMediaSource$Factory;
    }
.end annotation


# static fields
.field private static final CHANNEL_COUNT:I = 0x2

.field private static final FORMAT:Landroidx/media3/common/Format;

.field public static final MEDIA_ID:Ljava/lang/String; = "SilenceMediaSource"

.field private static final MEDIA_ITEM:Landroidx/media3/common/MediaItem;

.field private static final PCM_ENCODING:I = 0x2

.field private static final SAMPLE_RATE_HZ:I = 0xac44

.field private static final SILENCE_SAMPLE:[B


# instance fields
.field private final durationUs:J

.field private mediaItem:Landroidx/media3/common/MediaItem;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 96
    new-instance v0, Landroidx/media3/common/Format$Builder;

    invoke-direct {v0}, Landroidx/media3/common/Format$Builder;-><init>()V

    .line 98
    const-string v1, "audio/raw"

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setSampleMimeType(Ljava/lang/String;)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 99
    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setChannelCount(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 100
    const v2, 0xac44

    invoke-virtual {v0, v2}, Landroidx/media3/common/Format$Builder;->setSampleRate(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 101
    invoke-virtual {v0, v1}, Landroidx/media3/common/Format$Builder;->setPcmEncoding(I)Landroidx/media3/common/Format$Builder;

    move-result-object v0

    .line 102
    invoke-virtual {v0}, Landroidx/media3/common/Format$Builder;->build()Landroidx/media3/common/Format;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->FORMAT:Landroidx/media3/common/Format;

    .line 103
    new-instance v2, Landroidx/media3/common/MediaItem$Builder;

    invoke-direct {v2}, Landroidx/media3/common/MediaItem$Builder;-><init>()V

    .line 105
    const-string v3, "SilenceMediaSource"

    invoke-virtual {v2, v3}, Landroidx/media3/common/MediaItem$Builder;->setMediaId(Ljava/lang/String;)Landroidx/media3/common/MediaItem$Builder;

    move-result-object v2

    sget-object v3, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    .line 106
    invoke-virtual {v2, v3}, Landroidx/media3/common/MediaItem$Builder;->setUri(Landroid/net/Uri;)Landroidx/media3/common/MediaItem$Builder;

    move-result-object v2

    iget-object v0, v0, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    .line 107
    invoke-virtual {v2, v0}, Landroidx/media3/common/MediaItem$Builder;->setMimeType(Ljava/lang/String;)Landroidx/media3/common/MediaItem$Builder;

    move-result-object v0

    .line 108
    invoke-virtual {v0}, Landroidx/media3/common/MediaItem$Builder;->build()Landroidx/media3/common/MediaItem;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    .line 109
    nop

    .line 110
    invoke-static {v1, v1}, Landroidx/media3/common/util/Util;->getPcmFrameSize(II)I

    move-result v0

    mul-int/lit16 v0, v0, 0x400

    new-array v0, v0, [B

    sput-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->SILENCE_SAMPLE:[B

    .line 109
    return-void
.end method

.method public constructor <init>(J)V
    .locals 1
    .param p1, "durationUs"    # J

    .line 123
    sget-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/exoplayer/source/SilenceMediaSource;-><init>(JLandroidx/media3/common/MediaItem;)V

    .line 124
    return-void
.end method

.method private constructor <init>(JLandroidx/media3/common/MediaItem;)V
    .locals 2
    .param p1, "durationUs"    # J
    .param p3, "mediaItem"    # Landroidx/media3/common/MediaItem;

    .line 132
    invoke-direct {p0}, Landroidx/media3/exoplayer/source/BaseMediaSource;-><init>()V

    .line 133
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 134
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->durationUs:J

    .line 135
    iput-object p3, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->mediaItem:Landroidx/media3/common/MediaItem;

    .line 136
    return-void
.end method

.method synthetic constructor <init>(JLandroidx/media3/common/MediaItem;Landroidx/media3/exoplayer/source/SilenceMediaSource$1;)V
    .locals 0
    .param p1, "x0"    # J
    .param p3, "x1"    # Landroidx/media3/common/MediaItem;
    .param p4, "x2"    # Landroidx/media3/exoplayer/source/SilenceMediaSource$1;

    .line 46
    invoke-direct {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/SilenceMediaSource;-><init>(JLandroidx/media3/common/MediaItem;)V

    return-void
.end method

.method static synthetic access$000()Landroidx/media3/common/MediaItem;
    .locals 1

    .line 46
    sget-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->MEDIA_ITEM:Landroidx/media3/common/MediaItem;

    return-object v0
.end method

.method static synthetic access$200()Landroidx/media3/common/Format;
    .locals 1

    .line 46
    sget-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->FORMAT:Landroidx/media3/common/Format;

    return-object v0
.end method

.method static synthetic access$300(J)J
    .locals 2
    .param p0, "x0"    # J

    .line 46
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->getAudioByteCount(J)J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$400(J)J
    .locals 2
    .param p0, "x0"    # J

    .line 46
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->getAudioPositionUs(J)J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$500()[B
    .locals 1

    .line 46
    sget-object v0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->SILENCE_SAMPLE:[B

    return-object v0
.end method

.method private static getAudioByteCount(J)J
    .locals 4
    .param p0, "durationUs"    # J

    .line 339
    const-wide/32 v0, 0xac44

    mul-long/2addr v0, p0

    const-wide/32 v2, 0xf4240

    div-long/2addr v0, v2

    .line 340
    .local v0, "audioSampleCount":J
    const/4 v2, 0x2

    invoke-static {v2, v2}, Landroidx/media3/common/util/Util;->getPcmFrameSize(II)I

    move-result v2

    int-to-long v2, v2

    mul-long/2addr v2, v0

    return-wide v2
.end method

.method private static getAudioPositionUs(J)J
    .locals 6
    .param p0, "bytes"    # J

    .line 344
    const/4 v0, 0x2

    invoke-static {v0, v0}, Landroidx/media3/common/util/Util;->getPcmFrameSize(II)I

    move-result v0

    int-to-long v0, v0

    div-long v0, p0, v0

    .line 345
    .local v0, "audioSampleCount":J
    const-wide/32 v2, 0xf4240

    mul-long/2addr v2, v0

    const-wide/32 v4, 0xac44

    div-long/2addr v2, v4

    return-wide v2
.end method


# virtual methods
.method public canUpdateMediaItem(Landroidx/media3/common/MediaItem;)Z
    .locals 1
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;

    .line 168
    const/4 v0, 0x1

    return v0
.end method

.method public createPeriod(Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/exoplayer/upstream/Allocator;J)Landroidx/media3/exoplayer/source/MediaPeriod;
    .locals 3
    .param p1, "id"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p2, "allocator"    # Landroidx/media3/exoplayer/upstream/Allocator;
    .param p3, "startPositionUs"    # J

    .line 155
    new-instance v0, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceMediaPeriod;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->durationUs:J

    invoke-direct {v0, v1, v2}, Landroidx/media3/exoplayer/source/SilenceMediaSource$SilenceMediaPeriod;-><init>(J)V

    return-object v0
.end method

.method public declared-synchronized getMediaItem()Landroidx/media3/common/MediaItem;
    .locals 1

    monitor-enter p0

    .line 163
    :try_start_0
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->mediaItem:Landroidx/media3/common/MediaItem;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 163
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SilenceMediaSource;
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public maybeThrowSourceInfoRefreshError()V
    .locals 0

    .line 151
    return-void
.end method

.method protected prepareSourceInternal(Landroidx/media3/datasource/TransferListener;)V
    .locals 9
    .param p1, "mediaTransferListener"    # Landroidx/media3/datasource/TransferListener;

    .line 140
    new-instance v8, Landroidx/media3/exoplayer/source/SinglePeriodTimeline;

    iget-wide v1, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->durationUs:J

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 147
    invoke-virtual {p0}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->getMediaItem()Landroidx/media3/common/MediaItem;

    move-result-object v7

    move-object v0, v8

    invoke-direct/range {v0 .. v7}, Landroidx/media3/exoplayer/source/SinglePeriodTimeline;-><init>(JZZZLjava/lang/Object;Landroidx/media3/common/MediaItem;)V

    .line 140
    invoke-virtual {p0, v8}, Landroidx/media3/exoplayer/source/SilenceMediaSource;->refreshSourceInfo(Landroidx/media3/common/Timeline;)V

    .line 148
    return-void
.end method

.method public releasePeriod(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 0
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 159
    return-void
.end method

.method protected releaseSourceInternal()V
    .locals 0

    .line 177
    return-void
.end method

.method public declared-synchronized updateMediaItem(Landroidx/media3/common/MediaItem;)V
    .locals 0
    .param p1, "mediaItem"    # Landroidx/media3/common/MediaItem;

    monitor-enter p0

    .line 173
    :try_start_0
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SilenceMediaSource;->mediaItem:Landroidx/media3/common/MediaItem;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 174
    monitor-exit p0

    return-void

    .line 172
    .end local p0    # "this":Landroidx/media3/exoplayer/source/SilenceMediaSource;
    .end local p1    # "mediaItem":Landroidx/media3/common/MediaItem;
    :catchall_0
    move-exception p1

    monitor-exit p0

    throw p1
.end method
