.class final Landroidx/media3/exoplayer/audio/AudioCapabilities$Api33;
.super Ljava/lang/Object;
.source "AudioCapabilities.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/AudioCapabilities;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api33"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 650
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getCapabilitiesInternalForDirectPlayback(Landroid/media/AudioManager;Landroidx/media3/common/AudioAttributes;)Landroidx/media3/exoplayer/audio/AudioCapabilities;
    .locals 4
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "audioAttributes"    # Landroidx/media3/common/AudioAttributes;

    .line 655
    nop

    .line 657
    invoke-virtual {p1}, Landroidx/media3/common/AudioAttributes;->getAudioAttributesV21()Landroidx/media3/common/AudioAttributes$AudioAttributesV21;

    move-result-object v0

    iget-object v0, v0, Landroidx/media3/common/AudioAttributes$AudioAttributesV21;->audioAttributes:Landroid/media/AudioAttributes;

    .line 656
    invoke-virtual {p0, v0}, Landroid/media/AudioManager;->getDirectProfilesForAttributes(Landroid/media/AudioAttributes;)Ljava/util/List;

    move-result-object v0

    .line 658
    .local v0, "directAudioProfiles":Ljava/util/List;, "Ljava/util/List<Landroid/media/AudioProfile;>;"
    new-instance v1, Landroidx/media3/exoplayer/audio/AudioCapabilities;

    invoke-static {v0}, Landroidx/media3/exoplayer/audio/AudioCapabilities;->access$000(Ljava/util/List;)Lcom/google/common/collect/ImmutableList;

    move-result-object v2

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Landroidx/media3/exoplayer/audio/AudioCapabilities;-><init>(Ljava/util/List;Landroidx/media3/exoplayer/audio/AudioCapabilities$1;)V

    return-object v1
.end method

.method public static getDefaultRoutedDeviceForAttributes(Landroid/media/AudioManager;Landroidx/media3/common/AudioAttributes;)Landroidx/media3/exoplayer/audio/AudioDeviceInfoApi23;
    .locals 3
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "audioAttributes"    # Landroidx/media3/common/AudioAttributes;

    .line 667
    nop

    .line 668
    const/4 v0, 0x0

    :try_start_0
    invoke-static {p0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioManager;

    .line 670
    invoke-virtual {p1}, Landroidx/media3/common/AudioAttributes;->getAudioAttributesV21()Landroidx/media3/common/AudioAttributes$AudioAttributesV21;

    move-result-object v2

    iget-object v2, v2, Landroidx/media3/common/AudioAttributes$AudioAttributesV21;->audioAttributes:Landroid/media/AudioAttributes;

    .line 669
    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getAudioDevicesForAttributes(Landroid/media/AudioAttributes;)Ljava/util/List;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 676
    .local v1, "audioDevices":Ljava/util/List;, "Ljava/util/List<Landroid/media/AudioDeviceInfo;>;"
    nop

    .line 677
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 679
    return-object v0

    .line 683
    :cond_0
    new-instance v0, Landroidx/media3/exoplayer/audio/AudioDeviceInfoApi23;

    const/4 v2, 0x0

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/media/AudioDeviceInfo;

    invoke-direct {v0, v2}, Landroidx/media3/exoplayer/audio/AudioDeviceInfoApi23;-><init>(Landroid/media/AudioDeviceInfo;)V

    return-object v0

    .line 671
    .end local v1    # "audioDevices":Ljava/util/List;, "Ljava/util/List<Landroid/media/AudioDeviceInfo;>;"
    :catch_0
    move-exception v1

    .line 675
    .local v1, "e":Ljava/lang/RuntimeException;
    return-object v0
.end method
