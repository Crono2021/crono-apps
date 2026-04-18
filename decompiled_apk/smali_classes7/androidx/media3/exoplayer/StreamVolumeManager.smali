.class final Landroidx/media3/exoplayer/StreamVolumeManager;
.super Ljava/lang/Object;
.source "StreamVolumeManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/StreamVolumeManager$Listener;,
        Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "StreamVolumeManager"

.field private static final VOLUME_CHANGED_ACTION:Ljava/lang/String; = "android.media.VOLUME_CHANGED_ACTION"


# instance fields
.field private final applicationContext:Landroid/content/Context;

.field private final audioManager:Landroid/media/AudioManager;

.field private final eventHandler:Landroid/os/Handler;

.field private final listener:Landroidx/media3/exoplayer/StreamVolumeManager$Listener;

.field private muted:Z

.field private receiver:Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;

.field private streamType:I

.field private volume:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Handler;Landroidx/media3/exoplayer/StreamVolumeManager$Listener;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "eventHandler"    # Landroid/os/Handler;
    .param p3, "listener"    # Landroidx/media3/exoplayer/StreamVolumeManager$Listener;

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->applicationContext:Landroid/content/Context;

    .line 62
    iput-object p2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->eventHandler:Landroid/os/Handler;

    .line 63
    iput-object p3, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->listener:Landroidx/media3/exoplayer/StreamVolumeManager$Listener;

    .line 64
    nop

    .line 66
    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioManager;

    .line 65
    invoke-static {v1}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/media/AudioManager;

    iput-object v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    .line 68
    const/4 v2, 0x3

    iput v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    .line 69
    invoke-static {v1, v2}, Landroidx/media3/exoplayer/StreamVolumeManager;->getVolumeFromManager(Landroid/media/AudioManager;I)I

    move-result v2

    iput v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    .line 70
    iget v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-static {v1, v2}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMutedFromManager(Landroid/media/AudioManager;I)Z

    move-result v1

    iput-boolean v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->muted:Z

    .line 72
    new-instance v1, Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;-><init>(Landroidx/media3/exoplayer/StreamVolumeManager;Landroidx/media3/exoplayer/StreamVolumeManager$1;)V

    .line 73
    .local v1, "receiver":Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;
    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.media.VOLUME_CHANGED_ACTION"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 75
    .local v2, "filter":Landroid/content/IntentFilter;
    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 76
    iput-object v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->receiver:Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 79
    goto :goto_0

    .line 77
    :catch_0
    move-exception v0

    .line 78
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v3, "StreamVolumeManager"

    const-string v4, "Error registering stream volume receiver"

    invoke-static {v3, v4, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 80
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :goto_0
    return-void
.end method

.method static synthetic access$100(Landroidx/media3/exoplayer/StreamVolumeManager;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/StreamVolumeManager;

    .line 31
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->eventHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$200(Landroidx/media3/exoplayer/StreamVolumeManager;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/StreamVolumeManager;

    .line 31
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    return-void
.end method

.method private static getMutedFromManager(Landroid/media/AudioManager;I)Z
    .locals 2
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "streamType"    # I

    .line 213
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 214
    invoke-virtual {p0, p1}, Landroid/media/AudioManager;->isStreamMute(I)Z

    move-result v0

    return v0

    .line 216
    :cond_0
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/StreamVolumeManager;->getVolumeFromManager(Landroid/media/AudioManager;I)I

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static getVolumeFromManager(Landroid/media/AudioManager;I)I
    .locals 3
    .param p0, "audioManager"    # Landroid/media/AudioManager;
    .param p1, "streamType"    # I

    .line 204
    :try_start_0
    invoke-virtual {p0, p1}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    return v0

    .line 205
    :catch_0
    move-exception v0

    .line 206
    .local v0, "e":Ljava/lang/RuntimeException;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Could not retrieve stream volume for stream type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "StreamVolumeManager"

    invoke-static {v2, v1, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 207
    invoke-virtual {p0, p1}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v1

    return v1
.end method

.method private updateVolumeAndNotifyIfChanged()V
    .locals 3

    .line 191
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/StreamVolumeManager;->getVolumeFromManager(Landroid/media/AudioManager;I)I

    move-result v0

    .line 192
    .local v0, "newVolume":I
    iget-object v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-static {v1, v2}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMutedFromManager(Landroid/media/AudioManager;I)Z

    move-result v1

    .line 193
    .local v1, "newMuted":Z
    iget v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    if-ne v2, v0, :cond_0

    iget-boolean v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->muted:Z

    if-eq v2, v1, :cond_1

    .line 194
    :cond_0
    iput v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    .line 195
    iput-boolean v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->muted:Z

    .line 196
    iget-object v2, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->listener:Landroidx/media3/exoplayer/StreamVolumeManager$Listener;

    invoke-interface {v2, v0, v1}, Landroidx/media3/exoplayer/StreamVolumeManager$Listener;->onStreamVolumeChanged(IZ)V

    .line 198
    :cond_1
    return-void
.end method


# virtual methods
.method public decreaseVolume(I)V
    .locals 3
    .param p1, "flags"    # I

    .line 155
    iget v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    invoke-virtual {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMinVolume()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 156
    return-void

    .line 158
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2, p1}, Landroid/media/AudioManager;->adjustStreamVolume(III)V

    .line 159
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    .line 160
    return-void
.end method

.method public getMaxVolume()I
    .locals 2

    .line 106
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v0

    return v0
.end method

.method public getMinVolume()I
    .locals 2

    .line 98
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x1c

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamMinVolume(I)I

    move-result v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public getVolume()I
    .locals 1

    .line 111
    iget v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    return v0
.end method

.method public increaseVolume(I)V
    .locals 3
    .param p1, "flags"    # I

    .line 141
    iget v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->volume:I

    invoke-virtual {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMaxVolume()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 142
    return-void

    .line 144
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2, p1}, Landroid/media/AudioManager;->adjustStreamVolume(III)V

    .line 145
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    .line 146
    return-void
.end method

.method public isMuted()Z
    .locals 1

    .line 116
    iget-boolean v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->muted:Z

    return v0
.end method

.method public release()V
    .locals 3

    .line 180
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->receiver:Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;

    if-eqz v0, :cond_0

    .line 182
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->applicationContext:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 185
    goto :goto_0

    .line 183
    :catch_0
    move-exception v0

    .line 184
    .local v0, "e":Ljava/lang/RuntimeException;
    const-string v1, "StreamVolumeManager"

    const-string v2, "Error unregistering stream volume receiver"

    invoke-static {v1, v2, v0}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 186
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->receiver:Landroidx/media3/exoplayer/StreamVolumeManager$VolumeChangeReceiver;

    .line 188
    :cond_0
    return-void
.end method

.method public setMuted(ZI)V
    .locals 3
    .param p1, "muted"    # Z
    .param p2, "flags"    # I

    .line 169
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_1

    .line 170
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    .line 171
    if-eqz p1, :cond_0

    const/16 v2, -0x64

    goto :goto_0

    :cond_0
    const/16 v2, 0x64

    .line 170
    :goto_0
    invoke-virtual {v0, v1, v2, p2}, Landroid/media/AudioManager;->adjustStreamVolume(III)V

    goto :goto_1

    .line 173
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-virtual {v0, v1, p1}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 175
    :goto_1
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    .line 176
    return-void
.end method

.method public setStreamType(I)V
    .locals 1
    .param p1, "streamType"    # I

    .line 84
    iget v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    if-ne v0, p1, :cond_0

    .line 85
    return-void

    .line 87
    :cond_0
    iput p1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    .line 89
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    .line 90
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->listener:Landroidx/media3/exoplayer/StreamVolumeManager$Listener;

    invoke-interface {v0, p1}, Landroidx/media3/exoplayer/StreamVolumeManager$Listener;->onStreamTypeChanged(I)V

    .line 91
    return-void
.end method

.method public setVolume(II)V
    .locals 2
    .param p1, "volume"    # I
    .param p2, "flags"    # I

    .line 127
    invoke-virtual {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMinVolume()I

    move-result v0

    if-lt p1, v0, :cond_1

    invoke-virtual {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->getMaxVolume()I

    move-result v0

    if-le p1, v0, :cond_0

    goto :goto_0

    .line 130
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->audioManager:Landroid/media/AudioManager;

    iget v1, p0, Landroidx/media3/exoplayer/StreamVolumeManager;->streamType:I

    invoke-virtual {v0, v1, p1, p2}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 131
    invoke-direct {p0}, Landroidx/media3/exoplayer/StreamVolumeManager;->updateVolumeAndNotifyIfChanged()V

    .line 132
    return-void

    .line 128
    :cond_1
    :goto_0
    return-void
.end method
