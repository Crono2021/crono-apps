.class final Landroidx/media3/exoplayer/ExoPlayerImpl$Api23;
.super Ljava/lang/Object;
.source "ExoPlayerImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/ExoPlayerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api23"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 3404
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isSuitableAudioOutputPresentInAudioDeviceInfoList(Landroid/content/Context;[Landroid/media/AudioDeviceInfo;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "audioDeviceInfos"    # [Landroid/media/AudioDeviceInfo;

    .line 3409
    invoke-static {p0}, Landroidx/media3/common/util/Util;->isWear(Landroid/content/Context;)Z

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_0

    .line 3410
    return v1

    .line 3412
    :cond_0
    array-length v0, p1

    const/4 v2, 0x0

    move v3, v2

    :goto_0
    if-ge v3, v0, :cond_8

    aget-object v4, p1, v3

    .line 3413
    .local v4, "device":Landroid/media/AudioDeviceInfo;
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v6, 0x8

    if-eq v5, v6, :cond_7

    .line 3414
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/4 v6, 0x5

    if-eq v5, v6, :cond_7

    .line 3415
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/4 v6, 0x6

    if-eq v5, v6, :cond_7

    .line 3416
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v6, 0xb

    if-eq v5, v6, :cond_7

    .line 3417
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/4 v6, 0x4

    if-eq v5, v6, :cond_7

    .line 3418
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/4 v6, 0x3

    if-ne v5, v6, :cond_1

    goto :goto_1

    .line 3421
    :cond_1
    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v6, 0x1a

    if-lt v5, v6, :cond_2

    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v7, 0x16

    if-ne v5, v7, :cond_2

    .line 3422
    return v1

    .line 3424
    :cond_2
    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v7, 0x1c

    if-lt v5, v7, :cond_3

    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v7, 0x17

    if-ne v5, v7, :cond_3

    .line 3425
    return v1

    .line 3427
    :cond_3
    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v7, 0x1f

    if-lt v5, v7, :cond_5

    .line 3428
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    if-eq v5, v6, :cond_4

    .line 3429
    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v6, 0x1b

    if-ne v5, v6, :cond_5

    .line 3430
    :cond_4
    return v1

    .line 3432
    :cond_5
    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v6, 0x21

    if-lt v5, v6, :cond_6

    invoke-virtual {v4}, Landroid/media/AudioDeviceInfo;->getType()I

    move-result v5

    const/16 v6, 0x1e

    if-ne v5, v6, :cond_6

    .line 3433
    return v1

    .line 3412
    .end local v4    # "device":Landroid/media/AudioDeviceInfo;
    :cond_6
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 3419
    .restart local v4    # "device":Landroid/media/AudioDeviceInfo;
    :cond_7
    :goto_1
    return v1

    .line 3436
    .end local v4    # "device":Landroid/media/AudioDeviceInfo;
    :cond_8
    return v2
.end method

.method public static registerAudioDeviceCallback(Landroid/media/AudioManager;Landroid/media/AudioDeviceCallback;Landroid/os/Handler;)V
    .locals 0
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "audioDeviceCallback"    # Landroid/media/AudioDeviceCallback;
    .param p2, "handler"    # Landroid/os/Handler;

    .line 3442
    invoke-virtual {p0, p1, p2}, Landroid/media/AudioManager;->registerAudioDeviceCallback(Landroid/media/AudioDeviceCallback;Landroid/os/Handler;)V

    .line 3443
    return-void
.end method
