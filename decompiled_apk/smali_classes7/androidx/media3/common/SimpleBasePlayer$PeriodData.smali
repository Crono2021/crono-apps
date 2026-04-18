.class public final Landroidx/media3/common/SimpleBasePlayer$PeriodData;
.super Ljava/lang/Object;
.source "SimpleBasePlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/SimpleBasePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1c
    name = "PeriodData"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;
    }
.end annotation


# instance fields
.field public final adPlaybackState:Landroidx/media3/common/AdPlaybackState;

.field public final durationUs:J

.field public final isPlaceholder:Z

.field public final uid:Ljava/lang/Object;


# direct methods
.method private constructor <init>(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)V
    .locals 2
    .param p1, "builder"    # Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;

    .line 1935
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1936
    invoke-static {p1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;->access$6500(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->uid:Ljava/lang/Object;

    .line 1937
    invoke-static {p1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;->access$6600(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)J

    move-result-wide v0

    iput-wide v0, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->durationUs:J

    .line 1938
    invoke-static {p1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;->access$6700(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)Landroidx/media3/common/AdPlaybackState;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->adPlaybackState:Landroidx/media3/common/AdPlaybackState;

    .line 1939
    invoke-static {p1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;->access$6800(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)Z

    move-result v0

    iput-boolean v0, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->isPlaceholder:Z

    .line 1940
    return-void
.end method

.method synthetic constructor <init>(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;Landroidx/media3/common/SimpleBasePlayer$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;
    .param p2, "x1"    # Landroidx/media3/common/SimpleBasePlayer$1;

    .line 1824
    invoke-direct {p0, p1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData;-><init>(Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;)V

    return-void
.end method


# virtual methods
.method public buildUpon()Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;
    .locals 2

    .line 1944
    new-instance v0, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroidx/media3/common/SimpleBasePlayer$PeriodData$Builder;-><init>(Landroidx/media3/common/SimpleBasePlayer$PeriodData;Landroidx/media3/common/SimpleBasePlayer$1;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .line 1949
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 1950
    return v0

    .line 1952
    :cond_0
    instance-of v1, p1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    .line 1953
    return v2

    .line 1955
    :cond_1
    move-object v1, p1

    check-cast v1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;

    .line 1956
    .local v1, "periodData":Landroidx/media3/common/SimpleBasePlayer$PeriodData;
    iget-object v3, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->uid:Ljava/lang/Object;

    iget-object v4, v1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->uid:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-wide v3, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->durationUs:J

    iget-wide v5, v1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->durationUs:J

    cmp-long v3, v3, v5

    if-nez v3, :cond_2

    iget-object v3, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->adPlaybackState:Landroidx/media3/common/AdPlaybackState;

    iget-object v4, v1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->adPlaybackState:Landroidx/media3/common/AdPlaybackState;

    .line 1958
    invoke-virtual {v3, v4}, Landroidx/media3/common/AdPlaybackState;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget-boolean v3, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->isPlaceholder:Z

    iget-boolean v4, v1, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->isPlaceholder:Z

    if-ne v3, v4, :cond_2

    goto :goto_0

    :cond_2
    move v0, v2

    .line 1956
    :goto_0
    return v0
.end method

.method public hashCode()I
    .locals 6

    .line 1964
    const/4 v0, 0x7

    .line 1965
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->uid:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 1966
    .end local v0    # "result":I
    .local v1, "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget-wide v2, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->durationUs:J

    const/16 v4, 0x20

    ushr-long v4, v2, v4

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int/2addr v0, v2

    .line 1967
    .end local v1    # "result":I
    .restart local v0    # "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->adPlaybackState:Landroidx/media3/common/AdPlaybackState;

    invoke-virtual {v2}, Landroidx/media3/common/AdPlaybackState;->hashCode()I

    move-result v2

    add-int/2addr v1, v2

    .line 1968
    .end local v0    # "result":I
    .restart local v1    # "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget-boolean v2, p0, Landroidx/media3/common/SimpleBasePlayer$PeriodData;->isPlaceholder:Z

    add-int/2addr v0, v2

    .line 1969
    .end local v1    # "result":I
    .restart local v0    # "result":I
    return v0
.end method
