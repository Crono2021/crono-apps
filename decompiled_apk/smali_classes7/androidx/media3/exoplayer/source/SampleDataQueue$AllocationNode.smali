.class final Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
.super Ljava/lang/Object;
.source "SampleDataQueue.java"

# interfaces
.implements Landroidx/media3/exoplayer/upstream/Allocator$AllocationNode;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/source/SampleDataQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "AllocationNode"
.end annotation


# instance fields
.field public allocation:Landroidx/media3/exoplayer/upstream/Allocation;

.field public endPosition:J

.field public next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

.field public startPosition:J


# direct methods
.method public constructor <init>(JI)V
    .locals 0
    .param p1, "startPosition"    # J
    .param p3, "allocationLength"    # I

    .line 486
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 487
    invoke-virtual {p0, p1, p2, p3}, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->reset(JI)V

    .line 488
    return-void
.end method


# virtual methods
.method public clear()Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    .locals 2

    .line 530
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    .line 531
    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 532
    .local v1, "temp":Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;
    iput-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 533
    return-object v1
.end method

.method public getAllocation()Landroidx/media3/exoplayer/upstream/Allocation;
    .locals 1

    .line 540
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/media3/exoplayer/upstream/Allocation;

    return-object v0
.end method

.method public initialize(Landroidx/media3/exoplayer/upstream/Allocation;Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;)V
    .locals 0
    .param p1, "allocation"    # Landroidx/media3/exoplayer/upstream/Allocation;
    .param p2, "next"    # Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 509
    iput-object p1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    .line 510
    iput-object p2, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    .line 511
    return-void
.end method

.method public next()Landroidx/media3/exoplayer/upstream/Allocator$AllocationNode;
    .locals 2

    .line 546
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->next:Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;

    if-eqz v0, :cond_1

    iget-object v1, v0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    if-nez v1, :cond_0

    goto :goto_0

    .line 549
    :cond_0
    return-object v0

    .line 547
    :cond_1
    :goto_0
    const/4 v0, 0x0

    return-object v0
.end method

.method public reset(JI)V
    .locals 2
    .param p1, "startPosition"    # J
    .param p3, "allocationLength"    # I

    .line 497
    iget-object v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 498
    iput-wide p1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->startPosition:J

    .line 499
    int-to-long v0, p3

    add-long/2addr v0, p1

    iput-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->endPosition:J

    .line 500
    return-void
.end method

.method public translateOffset(J)I
    .locals 2
    .param p1, "absolutePosition"    # J

    .line 521
    iget-wide v0, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->startPosition:J

    sub-long v0, p1, v0

    long-to-int v0, v0

    iget-object v1, p0, Landroidx/media3/exoplayer/source/SampleDataQueue$AllocationNode;->allocation:Landroidx/media3/exoplayer/upstream/Allocation;

    iget v1, v1, Landroidx/media3/exoplayer/upstream/Allocation;->offset:I

    add-int/2addr v0, v1

    return v0
.end method
