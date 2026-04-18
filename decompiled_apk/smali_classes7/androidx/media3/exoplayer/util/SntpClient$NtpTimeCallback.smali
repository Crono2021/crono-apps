.class final Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;
.super Ljava/lang/Object;
.source "SntpClient.java"

# interfaces
.implements Landroidx/media3/exoplayer/upstream/Loader$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/util/SntpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "NtpTimeCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroidx/media3/exoplayer/upstream/Loader$Callback<",
        "Landroidx/media3/exoplayer/upstream/Loader$Loadable;",
        ">;"
    }
.end annotation


# instance fields
.field private final callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;


# direct methods
.method public constructor <init>(Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;)V
    .locals 0
    .param p1, "callback"    # Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    .line 313
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 314
    iput-object p1, p0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;->callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    .line 315
    return-void
.end method


# virtual methods
.method public onLoadCanceled(Landroidx/media3/exoplayer/upstream/Loader$Loadable;JJZ)V
    .locals 0
    .param p1, "loadable"    # Landroidx/media3/exoplayer/upstream/Loader$Loadable;
    .param p2, "elapsedRealtimeMs"    # J
    .param p4, "loadDurationMs"    # J
    .param p6, "released"    # Z

    .line 334
    return-void
.end method

.method public onLoadCompleted(Landroidx/media3/exoplayer/upstream/Loader$Loadable;JJ)V
    .locals 3
    .param p1, "loadable"    # Landroidx/media3/exoplayer/upstream/Loader$Loadable;
    .param p2, "elapsedRealtimeMs"    # J
    .param p4, "loadDurationMs"    # J

    .line 319
    iget-object v0, p0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;->callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    if-eqz v0, :cond_1

    .line 320
    invoke-static {}, Landroidx/media3/exoplayer/util/SntpClient;->isInitialized()Z

    move-result v0

    if-nez v0, :cond_0

    .line 323
    iget-object v0, p0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;->callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    new-instance v1, Ljava/io/IOException;

    new-instance v2, Ljava/util/ConcurrentModificationException;

    invoke-direct {v2}, Ljava/util/ConcurrentModificationException;-><init>()V

    invoke-direct {v1, v2}, Ljava/io/IOException;-><init>(Ljava/lang/Throwable;)V

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;->onInitializationFailed(Ljava/io/IOException;)V

    goto :goto_0

    .line 325
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;->callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    invoke-interface {v0}, Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;->onInitialized()V

    .line 328
    :cond_1
    :goto_0
    return-void
.end method

.method public onLoadError(Landroidx/media3/exoplayer/upstream/Loader$Loadable;JJLjava/io/IOException;I)Landroidx/media3/exoplayer/upstream/Loader$LoadErrorAction;
    .locals 1
    .param p1, "loadable"    # Landroidx/media3/exoplayer/upstream/Loader$Loadable;
    .param p2, "elapsedRealtimeMs"    # J
    .param p4, "loadDurationMs"    # J
    .param p6, "error"    # Ljava/io/IOException;
    .param p7, "errorCount"    # I

    .line 343
    iget-object v0, p0, Landroidx/media3/exoplayer/util/SntpClient$NtpTimeCallback;->callback:Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;

    if-eqz v0, :cond_0

    .line 344
    invoke-interface {v0, p6}, Landroidx/media3/exoplayer/util/SntpClient$InitializationCallback;->onInitializationFailed(Ljava/io/IOException;)V

    .line 346
    :cond_0
    sget-object v0, Landroidx/media3/exoplayer/upstream/Loader;->DONT_RETRY:Landroidx/media3/exoplayer/upstream/Loader$LoadErrorAction;

    return-object v0
.end method
