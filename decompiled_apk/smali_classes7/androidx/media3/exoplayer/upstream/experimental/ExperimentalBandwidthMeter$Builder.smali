.class public final Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
.super Ljava/lang/Object;
.source "ExperimentalBandwidthMeter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private bandwidthEstimator:Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;

.field private final context:Landroid/content/Context;

.field private initialBitrateEstimates:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private resetOnNetworkTypeChange:Z

.field private timeToFirstByteEstimator:Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .line 138
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 140
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->context:Landroid/content/Context;

    .line 141
    invoke-static {p1}, Landroidx/media3/common/util/Util;->getCountryCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->getInitialBitrateEstimatesForCountry(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->initialBitrateEstimates:Ljava/util/Map;

    .line 142
    new-instance v0, Landroidx/media3/exoplayer/upstream/experimental/PercentileTimeToFirstByteEstimator;

    const/16 v1, 0x14

    const/high16 v2, 0x3f000000    # 0.5f

    invoke-direct {v0, v1, v2}, Landroidx/media3/exoplayer/upstream/experimental/PercentileTimeToFirstByteEstimator;-><init>(IF)V

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->timeToFirstByteEstimator:Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;

    .line 146
    new-instance v0, Landroidx/media3/exoplayer/upstream/experimental/SplitParallelSampleBandwidthEstimator$Builder;

    invoke-direct {v0}, Landroidx/media3/exoplayer/upstream/experimental/SplitParallelSampleBandwidthEstimator$Builder;-><init>()V

    invoke-virtual {v0}, Landroidx/media3/exoplayer/upstream/experimental/SplitParallelSampleBandwidthEstimator$Builder;->build()Landroidx/media3/exoplayer/upstream/experimental/SplitParallelSampleBandwidthEstimator;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->bandwidthEstimator:Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;

    .line 147
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->resetOnNetworkTypeChange:Z

    .line 148
    return-void
.end method

.method private static getInitialBitrateEstimatesForCountry(Ljava/lang/String;)Ljava/util/Map;
    .locals 8
    .param p0, "countryCode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .line 249
    invoke-static {p0}, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->access$100(Ljava/lang/String;)[I

    move-result-object v0

    .line 250
    .local v0, "groupIndices":[I
    new-instance v1, Ljava/util/HashMap;

    const/16 v2, 0x8

    invoke-direct {v1, v2}, Ljava/util/HashMap;-><init>(I)V

    .line 251
    .local v1, "result":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Ljava/lang/Long;>;"
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    const-wide/32 v4, 0xf4240

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 252
    nop

    .line 253
    const/4 v3, 0x2

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    sget-object v5, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI:Lcom/google/common/collect/ImmutableList;

    aget v6, v0, v2

    .line 254
    invoke-virtual {v5, v6}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Long;

    .line 252
    invoke-interface {v1, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 255
    nop

    .line 256
    const/4 v4, 0x3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    sget-object v6, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_2G:Lcom/google/common/collect/ImmutableList;

    const/4 v7, 0x1

    aget v7, v0, v7

    .line 257
    invoke-virtual {v6, v7}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Long;

    .line 255
    invoke-interface {v1, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 258
    nop

    .line 259
    const/4 v5, 0x4

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    sget-object v7, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_3G:Lcom/google/common/collect/ImmutableList;

    aget v3, v0, v3

    .line 260
    invoke-virtual {v7, v3}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    .line 258
    invoke-interface {v1, v6, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    nop

    .line 262
    const/4 v3, 0x5

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    sget-object v7, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_4G:Lcom/google/common/collect/ImmutableList;

    aget v4, v0, v4

    .line 263
    invoke-virtual {v7, v4}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Long;

    .line 261
    invoke-interface {v1, v6, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 264
    nop

    .line 265
    const/16 v4, 0xa

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    sget-object v6, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA:Lcom/google/common/collect/ImmutableList;

    aget v5, v0, v5

    .line 266
    invoke-virtual {v6, v5}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Long;

    .line 264
    invoke-interface {v1, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 267
    nop

    .line 268
    const/16 v4, 0x9

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    sget-object v5, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_SA:Lcom/google/common/collect/ImmutableList;

    aget v3, v0, v3

    .line 269
    invoke-virtual {v5, v3}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Long;

    .line 267
    invoke-interface {v1, v4, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 271
    nop

    .line 272
    const/4 v3, 0x7

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    sget-object v4, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;->DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI:Lcom/google/common/collect/ImmutableList;

    aget v2, v0, v2

    .line 273
    invoke-virtual {v4, v2}, Lcom/google/common/collect/ImmutableList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Long;

    .line 271
    invoke-interface {v1, v3, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 274
    return-object v1
.end method


# virtual methods
.method public build()Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;
    .locals 8

    .line 240
    new-instance v7, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;

    iget-object v1, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->context:Landroid/content/Context;

    iget-object v2, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->initialBitrateEstimates:Ljava/util/Map;

    iget-object v3, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->timeToFirstByteEstimator:Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;

    iget-object v4, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->bandwidthEstimator:Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;

    iget-boolean v5, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->resetOnNetworkTypeChange:Z

    const/4 v6, 0x0

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter;-><init>(Landroid/content/Context;Ljava/util/Map;Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;ZLandroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$1;)V

    return-object v7
.end method

.method public setBandwidthEstimator(Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 0
    .param p1, "bandwidthEstimator"    # Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;

    .line 218
    iput-object p1, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->bandwidthEstimator:Landroidx/media3/exoplayer/upstream/experimental/BandwidthEstimator;

    .line 219
    return-object p0
.end method

.method public setInitialBitrateEstimate(IJ)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 3
    .param p1, "networkType"    # I
    .param p2, "initialBitrateEstimate"    # J

    .line 176
    iget-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->initialBitrateEstimates:Ljava/util/Map;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    return-object p0
.end method

.method public setInitialBitrateEstimate(J)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 3
    .param p1, "initialBitrateEstimate"    # J

    .line 159
    iget-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->initialBitrateEstimates:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 160
    .local v1, "networkType":Ljava/lang/Integer;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {p0, v2, p1, p2}, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->setInitialBitrateEstimate(IJ)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;

    .line 161
    .end local v1    # "networkType":Ljava/lang/Integer;
    goto :goto_0

    .line 162
    :cond_0
    return-object p0
.end method

.method public setInitialBitrateEstimate(Ljava/lang/String;)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 1
    .param p1, "countryCode"    # Ljava/lang/String;

    .line 190
    nop

    .line 191
    invoke-static {p1}, Lcom/google/common/base/Ascii;->toUpperCase(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->getInitialBitrateEstimatesForCountry(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->initialBitrateEstimates:Ljava/util/Map;

    .line 192
    return-object p0
.end method

.method public setResetOnNetworkTypeChange(Z)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 0
    .param p1, "resetOnNetworkTypeChange"    # Z

    .line 230
    iput-boolean p1, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->resetOnNetworkTypeChange:Z

    .line 231
    return-object p0
.end method

.method public setTimeToFirstByteEstimator(Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;)Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;
    .locals 0
    .param p1, "timeToFirstByteEstimator"    # Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;

    .line 207
    iput-object p1, p0, Landroidx/media3/exoplayer/upstream/experimental/ExperimentalBandwidthMeter$Builder;->timeToFirstByteEstimator:Landroidx/media3/exoplayer/upstream/TimeToFirstByteEstimator;

    .line 208
    return-object p0
.end method
