.class public final Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
.super Ljava/lang/Object;
.source "CmcdData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private bufferLengthMs:J

.field private customDataList:Lcom/google/common/collect/ImmutableList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/ImmutableList<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private deadlineMs:J

.field private measuredThroughputInKbps:J

.field private nextObjectRequest:Ljava/lang/String;

.field private nextRangeRequest:Ljava/lang/String;

.field private startup:Z


# direct methods
.method public constructor <init>()V
    .locals 4

    .line 594
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 595
    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    iput-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->bufferLengthMs:J

    .line 596
    const-wide/32 v2, -0x7fffffff

    iput-wide v2, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->measuredThroughputInKbps:J

    .line 597
    iput-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->deadlineMs:J

    .line 598
    invoke-static {}, Lcom/google/common/collect/ImmutableList;->of()Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->customDataList:Lcom/google/common/collect/ImmutableList;

    .line 599
    return-void
.end method

.method static synthetic access$1000(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->deadlineMs:J

    return-wide v0
.end method

.method static synthetic access$1100(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-boolean v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->startup:Z

    return v0
.end method

.method static synthetic access$1200(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->nextObjectRequest:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1300(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->nextRangeRequest:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1400(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)Lcom/google/common/collect/ImmutableList;
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->customDataList:Lcom/google/common/collect/ImmutableList;

    return-object v0
.end method

.method static synthetic access$800(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->bufferLengthMs:J

    return-wide v0
.end method

.method static synthetic access$900(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;)J
    .locals 2
    .param p0, "x0"    # Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;

    .line 584
    iget-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->measuredThroughputInKbps:J

    return-wide v0
.end method


# virtual methods
.method public build()Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest;
    .locals 2

    .line 677
    new-instance v0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest;-><init>(Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;Landroidx/media3/exoplayer/upstream/CmcdData$1;)V

    return-object v0
.end method

.method public setBufferLengthMs(J)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 4
    .param p1, "bufferLengthMs"    # J

    .line 610
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_1

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 611
    const-wide/16 v0, 0x32

    add-long/2addr v0, p1

    const-wide/16 v2, 0x64

    div-long/2addr v0, v2

    mul-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->bufferLengthMs:J

    .line 612
    return-object p0
.end method

.method public setCustomDataList(Ljava/util/List;)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Ljava/lang/String;",
            ">;)",
            "Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;"
        }
    .end annotation

    .line 672
    .local p1, "customDataList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {p1}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->customDataList:Lcom/google/common/collect/ImmutableList;

    .line 673
    return-object p0
.end method

.method public setDeadlineMs(J)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 4
    .param p1, "deadlineMs"    # J

    .line 640
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_1

    const-wide v0, -0x7fffffffffffffffL    # -4.9E-324

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 641
    const-wide/16 v0, 0x32

    add-long/2addr v0, p1

    const-wide/16 v2, 0x64

    div-long/2addr v0, v2

    mul-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->deadlineMs:J

    .line 642
    return-object p0
.end method

.method public setMeasuredThroughputInKbps(J)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 4
    .param p1, "measuredThroughputInKbps"    # J

    .line 624
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_1

    const-wide/32 v0, -0x7fffffff

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkArgument(Z)V

    .line 626
    const-wide/16 v0, 0x32

    add-long/2addr v0, p1

    const-wide/16 v2, 0x64

    div-long/2addr v0, v2

    mul-long/2addr v0, v2

    iput-wide v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->measuredThroughputInKbps:J

    .line 628
    return-object p0
.end method

.method public setNextObjectRequest(Ljava/lang/String;)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 1
    .param p1, "nextObjectRequest"    # Ljava/lang/String;

    .line 658
    if-nez p1, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-static {p1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->nextObjectRequest:Ljava/lang/String;

    .line 659
    return-object p0
.end method

.method public setNextRangeRequest(Ljava/lang/String;)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 0
    .param p1, "nextRangeRequest"    # Ljava/lang/String;

    .line 665
    iput-object p1, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->nextRangeRequest:Ljava/lang/String;

    .line 666
    return-object p0
.end method

.method public setStartup(Z)Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;
    .locals 0
    .param p1, "startup"    # Z

    .line 648
    iput-boolean p1, p0, Landroidx/media3/exoplayer/upstream/CmcdData$CmcdRequest$Builder;->startup:Z

    .line 649
    return-object p0
.end method
