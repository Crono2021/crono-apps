.class final Landroidx/media3/exoplayer/audio/DefaultAudioSink$MediaPositionParameters;
.super Ljava/lang/Object;
.source "DefaultAudioSink.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/DefaultAudioSink;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "MediaPositionParameters"
.end annotation


# instance fields
.field public final audioTrackPositionUs:J

.field public final mediaTimeUs:J

.field public final playbackParameters:Landroidx/media3/common/PlaybackParameters;


# direct methods
.method private constructor <init>(Landroidx/media3/common/PlaybackParameters;JJ)V
    .locals 0
    .param p1, "playbackParameters"    # Landroidx/media3/common/PlaybackParameters;
    .param p2, "mediaTimeUs"    # J
    .param p4, "audioTrackPositionUs"    # J

    .line 2011
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2012
    iput-object p1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$MediaPositionParameters;->playbackParameters:Landroidx/media3/common/PlaybackParameters;

    .line 2013
    iput-wide p2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$MediaPositionParameters;->mediaTimeUs:J

    .line 2014
    iput-wide p4, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$MediaPositionParameters;->audioTrackPositionUs:J

    .line 2015
    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/common/PlaybackParameters;JJLandroidx/media3/exoplayer/audio/DefaultAudioSink$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/common/PlaybackParameters;
    .param p2, "x1"    # J
    .param p4, "x2"    # J
    .param p6, "x3"    # Landroidx/media3/exoplayer/audio/DefaultAudioSink$1;

    .line 1999
    invoke-direct/range {p0 .. p5}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$MediaPositionParameters;-><init>(Landroidx/media3/common/PlaybackParameters;JJ)V

    return-void
.end method
