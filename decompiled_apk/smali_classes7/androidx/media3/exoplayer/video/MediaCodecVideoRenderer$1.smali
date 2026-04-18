.class Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;
.super Ljava/lang/Object;
.source "MediaCodecVideoRenderer.java"

# interfaces
.implements Landroidx/media3/exoplayer/video/VideoSink$Listener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->onReadyToInitializeCodec(Landroidx/media3/common/Format;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;


# direct methods
.method constructor <init>(Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;)V
    .locals 0
    .param p1, "this$0"    # Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    .line 1079
    iput-object p1, p0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;->this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroidx/media3/exoplayer/video/VideoSink;Landroidx/media3/exoplayer/video/VideoSink$VideoSinkException;)V
    .locals 3
    .param p1, "videoSink"    # Landroidx/media3/exoplayer/video/VideoSink;
    .param p2, "videoSinkException"    # Landroidx/media3/exoplayer/video/VideoSink$VideoSinkException;

    .line 1102
    iget-object v0, p0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;->this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    iget-object v1, p2, Landroidx/media3/exoplayer/video/VideoSink$VideoSinkException;->format:Landroidx/media3/common/Format;

    .line 1103
    const/16 v2, 0x1b59

    invoke-static {v0, p2, v1, v2}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->access$200(Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;Ljava/lang/Throwable;Landroidx/media3/common/Format;I)Landroidx/media3/exoplayer/ExoPlaybackException;

    move-result-object v1

    .line 1102
    invoke-static {v0, v1}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->access$300(Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;Landroidx/media3/exoplayer/ExoPlaybackException;)V

    .line 1107
    return-void
.end method

.method public onFirstFrameRendered(Landroidx/media3/exoplayer/video/VideoSink;)V
    .locals 1
    .param p1, "videoSink"    # Landroidx/media3/exoplayer/video/VideoSink;

    .line 1082
    iget-object v0, p0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;->this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    invoke-static {v0}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->access$000(Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;)Landroid/view/Surface;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1083
    iget-object v0, p0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;->this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    invoke-static {v0}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->access$100(Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;)V

    .line 1084
    return-void
.end method

.method public onFrameDropped(Landroidx/media3/exoplayer/video/VideoSink;)V
    .locals 3
    .param p1, "videoSink"    # Landroidx/media3/exoplayer/video/VideoSink;

    .line 1088
    iget-object v0, p0, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$1;->this$0:Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;->updateDroppedBufferCounters(II)V

    .line 1090
    return-void
.end method

.method public onVideoSizeChanged(Landroidx/media3/exoplayer/video/VideoSink;Landroidx/media3/common/VideoSize;)V
    .locals 0
    .param p1, "videoSink"    # Landroidx/media3/exoplayer/video/VideoSink;
    .param p2, "videoSize"    # Landroidx/media3/common/VideoSize;

    .line 1097
    return-void
.end method
