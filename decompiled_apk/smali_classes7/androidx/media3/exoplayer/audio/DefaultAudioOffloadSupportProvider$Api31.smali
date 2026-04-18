.class final Landroidx/media3/exoplayer/audio/DefaultAudioOffloadSupportProvider$Api31;
.super Ljava/lang/Object;
.source "DefaultAudioOffloadSupportProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/DefaultAudioOffloadSupportProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api31"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 158
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getOffloadedPlaybackSupport(Landroid/media/AudioFormat;Landroid/media/AudioAttributes;Z)Landroidx/media3/exoplayer/audio/AudioOffloadSupport;
    .locals 5
    .param p0, "audioFormat"    # Landroid/media/AudioFormat;
    .param p1, "audioAttributes"    # Landroid/media/AudioAttributes;
    .param p2, "isOffloadVariableRateSupported"    # Z

    .line 165
    nop

    .line 166
    invoke-static {p0, p1}, Landroid/media/AudioManager;->getPlaybackOffloadSupport(Landroid/media/AudioFormat;Landroid/media/AudioAttributes;)I

    move-result v0

    .line 167
    .local v0, "playbackOffloadSupport":I
    if-nez v0, :cond_0

    .line 168
    sget-object v1, Landroidx/media3/exoplayer/audio/AudioOffloadSupport;->DEFAULT_UNSUPPORTED:Landroidx/media3/exoplayer/audio/AudioOffloadSupport;

    return-object v1

    .line 170
    :cond_0
    new-instance v1, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;

    invoke-direct {v1}, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;-><init>()V

    .line 173
    .local v1, "audioOffloadSupport":Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;
    sget v2, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v3, 0x20

    const/4 v4, 0x1

    if-le v2, v3, :cond_1

    const/4 v2, 0x2

    if-ne v0, v2, :cond_1

    move v2, v4

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    .line 176
    .local v2, "isGaplessSupported":Z
    :goto_0
    nop

    .line 177
    invoke-virtual {v1, v4}, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;->setIsFormatSupported(Z)Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;

    move-result-object v3

    .line 178
    invoke-virtual {v3, v2}, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;->setIsGaplessSupported(Z)Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;

    move-result-object v3

    .line 179
    invoke-virtual {v3, p2}, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;->setIsSpeedChangeSupported(Z)Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;

    move-result-object v3

    .line 180
    invoke-virtual {v3}, Landroidx/media3/exoplayer/audio/AudioOffloadSupport$Builder;->build()Landroidx/media3/exoplayer/audio/AudioOffloadSupport;

    move-result-object v3

    .line 176
    return-object v3
.end method
