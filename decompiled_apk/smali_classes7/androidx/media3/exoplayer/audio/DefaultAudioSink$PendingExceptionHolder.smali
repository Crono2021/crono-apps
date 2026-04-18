.class final Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;
.super Ljava/lang/Object;
.source "DefaultAudioSink.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/audio/DefaultAudioSink;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "PendingExceptionHolder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Exception;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private pendingException:Ljava/lang/Exception;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private throwDeadlineMs:J

.field private final throwDelayMs:J


# direct methods
.method public constructor <init>(J)V
    .locals 0
    .param p1, "throwDelayMs"    # J

    .line 2313
    .local p0, "this":Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;, "Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2314
    iput-wide p1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->throwDelayMs:J

    .line 2315
    return-void
.end method


# virtual methods
.method public clear()V
    .locals 1

    .line 2335
    .local p0, "this":Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;, "Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder<TT;>;"
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->pendingException:Ljava/lang/Exception;

    .line 2336
    return-void
.end method

.method public throwExceptionIfDeadlineIsReached(Ljava/lang/Exception;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V^TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 2318
    .local p0, "this":Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;, "Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder<TT;>;"
    .local p1, "exception":Ljava/lang/Exception;, "TT;"
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 2319
    .local v0, "nowMs":J
    iget-object v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->pendingException:Ljava/lang/Exception;

    if-nez v2, :cond_0

    .line 2320
    iput-object p1, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->pendingException:Ljava/lang/Exception;

    .line 2321
    iget-wide v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->throwDelayMs:J

    add-long/2addr v2, v0

    iput-wide v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->throwDeadlineMs:J

    .line 2323
    :cond_0
    iget-wide v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->throwDeadlineMs:J

    cmp-long v2, v0, v2

    if-ltz v2, :cond_2

    .line 2324
    iget-object v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->pendingException:Ljava/lang/Exception;

    if-eq v2, p1, :cond_1

    .line 2326
    invoke-virtual {v2, p1}, Ljava/lang/Exception;->addSuppressed(Ljava/lang/Throwable;)V

    .line 2328
    :cond_1
    iget-object v2, p0, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->pendingException:Ljava/lang/Exception;

    .line 2329
    .local v2, "pendingException":Ljava/lang/Exception;, "TT;"
    invoke-virtual {p0}, Landroidx/media3/exoplayer/audio/DefaultAudioSink$PendingExceptionHolder;->clear()V

    .line 2330
    throw v2

    .line 2332
    .end local v2    # "pendingException":Ljava/lang/Exception;, "TT;"
    :cond_2
    return-void
.end method
