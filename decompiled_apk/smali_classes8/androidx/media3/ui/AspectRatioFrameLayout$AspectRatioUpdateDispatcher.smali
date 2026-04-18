.class final Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;
.super Ljava/lang/Object;
.source "AspectRatioFrameLayout.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/ui/AspectRatioFrameLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "AspectRatioUpdateDispatcher"
.end annotation


# instance fields
.field private aspectRatioMismatch:Z

.field private isScheduled:Z

.field private naturalAspectRatio:F

.field private targetAspectRatio:F

.field final synthetic this$0:Landroidx/media3/ui/AspectRatioFrameLayout;


# direct methods
.method private constructor <init>(Landroidx/media3/ui/AspectRatioFrameLayout;)V
    .locals 0

    .line 217
    iput-object p1, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->this$0:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/ui/AspectRatioFrameLayout;Landroidx/media3/ui/AspectRatioFrameLayout$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/ui/AspectRatioFrameLayout;
    .param p2, "x1"    # Landroidx/media3/ui/AspectRatioFrameLayout$1;

    .line 217
    invoke-direct {p0, p1}, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;-><init>(Landroidx/media3/ui/AspectRatioFrameLayout;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 238
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->isScheduled:Z

    .line 239
    iget-object v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->this$0:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-static {v0}, Landroidx/media3/ui/AspectRatioFrameLayout;->access$100(Landroidx/media3/ui/AspectRatioFrameLayout;)Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;

    move-result-object v0

    if-nez v0, :cond_0

    .line 240
    return-void

    .line 242
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->this$0:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-static {v0}, Landroidx/media3/ui/AspectRatioFrameLayout;->access$100(Landroidx/media3/ui/AspectRatioFrameLayout;)Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;

    move-result-object v0

    iget v1, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->targetAspectRatio:F

    iget v2, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->naturalAspectRatio:F

    iget-boolean v3, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->aspectRatioMismatch:Z

    invoke-interface {v0, v1, v2, v3}, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioListener;->onAspectRatioUpdated(FFZ)V

    .line 244
    return-void
.end method

.method public scheduleUpdate(FFZ)V
    .locals 1
    .param p1, "targetAspectRatio"    # F
    .param p2, "naturalAspectRatio"    # F
    .param p3, "aspectRatioMismatch"    # Z

    .line 226
    iput p1, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->targetAspectRatio:F

    .line 227
    iput p2, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->naturalAspectRatio:F

    .line 228
    iput-boolean p3, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->aspectRatioMismatch:Z

    .line 230
    iget-boolean v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->isScheduled:Z

    if-nez v0, :cond_0

    .line 231
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->isScheduled:Z

    .line 232
    iget-object v0, p0, Landroidx/media3/ui/AspectRatioFrameLayout$AspectRatioUpdateDispatcher;->this$0:Landroidx/media3/ui/AspectRatioFrameLayout;

    invoke-virtual {v0, p0}, Landroidx/media3/ui/AspectRatioFrameLayout;->post(Ljava/lang/Runnable;)Z

    .line 234
    :cond_0
    return-void
.end method
