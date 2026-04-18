.class Landroidx/media3/ui/PlayerControlViewLayoutManager$2;
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


# direct methods
.method constructor <init>(Landroidx/media3/ui/PlayerControlViewLayoutManager;)V
    .locals 0
    .param p1, "this$0"    # Landroidx/media3/ui/PlayerControlViewLayoutManager;

    .line 178
    iput-object p1, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 3
    .param p1, "animation"    # Landroid/animation/Animator;

    .line 181
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$200(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$200(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 184
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$300(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/ViewGroup;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 185
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$300(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 187
    :cond_1
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$400(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/ViewGroup;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 188
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$400(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v2, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v2}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$100(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_0

    :cond_2
    const/4 v1, 0x4

    :goto_0
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 190
    :cond_3
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$000(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/View;

    move-result-object v0

    instance-of v0, v0, Landroidx/media3/ui/DefaultTimeBar;

    if-eqz v0, :cond_4

    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$100(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 191
    iget-object v0, p0, Landroidx/media3/ui/PlayerControlViewLayoutManager$2;->this$0:Landroidx/media3/ui/PlayerControlViewLayoutManager;

    invoke-static {v0}, Landroidx/media3/ui/PlayerControlViewLayoutManager;->access$000(Landroidx/media3/ui/PlayerControlViewLayoutManager;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/media3/ui/DefaultTimeBar;

    const-wide/16 v1, 0xfa

    invoke-virtual {v0, v1, v2}, Landroidx/media3/ui/DefaultTimeBar;->showScrubber(J)V

    .line 193
    :cond_4
    return-void
.end method
