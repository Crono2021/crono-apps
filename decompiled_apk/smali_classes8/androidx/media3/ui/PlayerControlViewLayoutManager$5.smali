.class Landroidx/media3/ui/PlayerControlViewLayoutManager$5;
.super Landroid/animation/AnimatorListenerAdapter;
.source "PlayerControlViewLayoutManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroidx/media3/ui/PlayerControlViewLayoutManager;-><init>(Landroidx/media3/ui/PlayerControlView;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

.field final synthetic val$playerControlView:Landroidx/media3/ui/PlayerControlView;


# direct methods
.method constructor <init>(Landroidx/media3/ui/PlayerControlViewLayoutManager;Landroidx/media3/ui/PlayerControlView;)V
    .locals 0
    .param p1, "this$0"    # Landroidx/media3/ui/PlayerControlViewLayoutManager;

    .line 250
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    iput-object p2, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->val$playerControlView:Landroidx/media3/ui/PlayerControlView;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 258
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$500(Landroidx/media3/ui/PlayerControlViewLayoutManager;I)V

    .line 259
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$600(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 260
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->val$playerControlView:Landroidx/media3/ui/PlayerControlView;

    iget-object v1, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$700(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroidx/media3/ui/PlayerControlView;->post(Ljava/lang/Runnable;)Z

    .line 261
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$602(Landroidx/media3/ui/PlayerControlViewLayoutManager;Z)Z

    .line 263
    :cond_0
    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 2
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 253
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$5;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$500(Landroidx/media3/ui/PlayerControlViewLayoutManager;I)V

    .line 254
    return-void
.end method
