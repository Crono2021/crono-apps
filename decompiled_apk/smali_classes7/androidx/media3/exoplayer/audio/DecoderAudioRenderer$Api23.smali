.class final Landroidx/media3/exoplayer/audio/DecoderAudioRenderer$Api23;
.super Ljava/lang/Object;
.source "DecoderAudioRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/DecoderAudioRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api23"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 894
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setAudioSinkPreferredDevice(Landroidx/media3/exoplayer/audio/AudioSink;Ljava/lang/Object;)V
    .locals 1
    .param p0, "audioSink"    # Landroidx/media3/exoplayer/audio/AudioSink;
    .param p1, "messagePayload"    # Ljava/lang/Object;

    .line 899
    move-object v0, p1

    check-cast v0, Landroid/media/AudioDeviceInfo;

    .line 900
    .local v0, "audioDeviceInfo":Landroid/media/AudioDeviceInfo;
    invoke-interface {p0, v0}, Landroidx/media3/exoplayer/audio/AudioSink;->setPreferredDevice(Landroid/media/AudioDeviceInfo;)V

    .line 901
    return-void
.end method
