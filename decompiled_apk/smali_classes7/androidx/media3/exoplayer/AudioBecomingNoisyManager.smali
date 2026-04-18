.class final Landroidx/media3/exoplayer/AudioBecomingNoisyManager;
.super Ljava/lang/Object;
.source "AudioBecomingNoisyManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;,
        Landroidx/media3/exoplayer/AudioBecomingNoisyManager$EventListener;
    }
.end annotation


# instance fields
.field private final context:Landroid/content/Context;

.field private final receiver:Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;

.field private receiverRegistered:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Handler;Landroidx/media3/exoplayer/AudioBecomingNoisyManager$EventListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "eventHandler"    # Landroid/os/Handler;
    .param p3, "listener"    # Landroidx/media3/exoplayer/AudioBecomingNoisyManager$EventListener;

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->context:Landroid/content/Context;

    .line 37
    new-instance v0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;

    invoke-direct {v0, p0, p2, p3}, Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;-><init>(Landroidx/media3/exoplayer/AudioBecomingNoisyManager;Landroid/os/Handler;Landroidx/media3/exoplayer/AudioBecomingNoisyManager$EventListener;)V

    iput-object v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiver:Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;

    .line 38
    return-void
.end method

.method static synthetic access$000(Landroidx/media3/exoplayer/AudioBecomingNoisyManager;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/AudioBecomingNoisyManager;

    .line 25
    iget-boolean v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiverRegistered:Z

    return v0
.end method


# virtual methods
.method public setEnabled(Z)V
    .locals 4
    .param p1, "enabled"    # Z

    .line 48
    if-eqz p1, :cond_0

    iget-boolean v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiverRegistered:Z

    if-nez v0, :cond_0

    .line 49
    iget-object v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->context:Landroid/content/Context;

    iget-object v1, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiver:Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "android.media.AUDIO_BECOMING_NOISY"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 51
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiverRegistered:Z

    goto :goto_0

    .line 52
    :cond_0
    if-nez p1, :cond_1

    iget-boolean v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiverRegistered:Z

    if-eqz v0, :cond_1

    .line 53
    iget-object v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->context:Landroid/content/Context;

    iget-object v1, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiver:Landroidx/media3/exoplayer/AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;

    invoke-virtual {v0, v1}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/exoplayer/AudioBecomingNoisyManager;->receiverRegistered:Z

    .line 56
    :cond_1
    :goto_0
    return-void
.end method
