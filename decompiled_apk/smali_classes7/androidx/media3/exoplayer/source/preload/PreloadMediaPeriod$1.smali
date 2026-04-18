.class Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;
.super Ljava/lang/Object;
.source "PreloadMediaPeriod.java"

# interfaces
.implements Landroidx/media3/exoplayer/source/MediaPeriod$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->prepareInternal(J)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;


# direct methods
.method constructor <init>(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;)V
    .locals 0
    .param p1, "this$0"    # Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    .line 77
    iput-object p1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 2
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 80
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->access$000(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;)Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V

    .line 81
    return-void
.end method

.method public bridge synthetic onContinueLoadingRequested(Landroidx/media3/exoplayer/source/SequenceableLoader;)V
    .locals 0

    .line 77
    check-cast p1, Landroidx/media3/exoplayer/source/MediaPeriod;

    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->onContinueLoadingRequested(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    return-void
.end method

.method public onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V
    .locals 2
    .param p1, "mediaPeriod"    # Landroidx/media3/exoplayer/source/MediaPeriod;

    .line 85
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->access$102(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;Z)Z

    .line 86
    iget-object v0, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    invoke-static {v0}, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;->access$000(Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;)Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;

    iget-object v1, p0, Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod$1;->this$0:Landroidx/media3/exoplayer/source/preload/PreloadMediaPeriod;

    invoke-interface {v0, v1}, Landroidx/media3/exoplayer/source/MediaPeriod$Callback;->onPrepared(Landroidx/media3/exoplayer/source/MediaPeriod;)V

    .line 87
    return-void
.end method
