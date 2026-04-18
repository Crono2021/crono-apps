.class public Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;
.super Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;
.source "DefaultTrackSelector.java"

# interfaces
.implements Landroidx/media3/exoplayer/RendererCapabilities$Listener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ParametersBuilder;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ImageTrackInfo;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TextTrackInfo;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$AudioTrackInfo;,
        Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$VideoTrackInfo;
    }
.end annotation


# static fields
.field private static final AUDIO_CHANNEL_COUNT_CONSTRAINTS_WARN_MESSAGE:Ljava/lang/String; = "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument."

.field private static final FORMAT_VALUE_ORDERING:Lcom/google/common/collect/Ordering;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/Ordering<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private static final FRACTION_TO_CONSIDER_FULLSCREEN:F = 0.98f

.field private static final NO_ORDER:Lcom/google/common/collect/Ordering;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/Ordering<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field protected static final SELECTION_ELIGIBILITY_ADAPTIVE:I = 0x2

.field protected static final SELECTION_ELIGIBILITY_FIXED:I = 0x1

.field protected static final SELECTION_ELIGIBILITY_NO:I = 0x0

.field private static final TAG:Ljava/lang/String; = "DefaultTrackSelector"


# instance fields
.field private audioAttributes:Landroidx/media3/common/AudioAttributes;

.field public final context:Landroid/content/Context;

.field private final deviceIsTV:Z

.field private final lock:Ljava/lang/Object;

.field private parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

.field private spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

.field private final trackSelectionFactory:Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;


# direct methods
.method public static synthetic $r8$lambda$38UNzDaPpwu3YUyf5lUz7V9eZlE(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;Landroidx/media3/common/Format;)Z
    .locals 0

    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->isAudioFormatWithinAudioChannelCountConstraints(Landroidx/media3/common/Format;)Z

    move-result p0

    return p0
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 2362
    new-instance v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda10;

    invoke-direct {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda10;-><init>()V

    .line 2363
    invoke-static {v0}, Lcom/google/common/collect/Ordering;->from(Ljava/util/Comparator;)Lcom/google/common/collect/Ordering;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->FORMAT_VALUE_ORDERING:Lcom/google/common/collect/Ordering;

    .line 2370
    new-instance v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda1;

    invoke-direct {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda1;-><init>()V

    invoke-static {v0}, Lcom/google/common/collect/Ordering;->from(Ljava/util/Comparator;)Lcom/google/common/collect/Ordering;

    move-result-object v0

    sput-object v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->NO_ORDER:Lcom/google/common/collect/Ordering;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 2391
    new-instance v0, Landroidx/media3/exoplayer/trackselection/AdaptiveTrackSelection$Factory;

    invoke-direct {v0}, Landroidx/media3/exoplayer/trackselection/AdaptiveTrackSelection$Factory;-><init>()V

    invoke-direct {p0, p1, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;-><init>(Landroid/content/Context;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V

    .line 2392
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/common/TrackSelectionParameters;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "parameters"    # Landroidx/media3/common/TrackSelectionParameters;

    .line 2407
    new-instance v0, Landroidx/media3/exoplayer/trackselection/AdaptiveTrackSelection$Factory;

    invoke-direct {v0}, Landroidx/media3/exoplayer/trackselection/AdaptiveTrackSelection$Factory;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;-><init>(Landroid/content/Context;Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V

    .line 2408
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "parameters"    # Landroidx/media3/common/TrackSelectionParameters;
    .param p3, "trackSelectionFactory"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;

    .line 2431
    invoke-direct {p0, p2, p3, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;-><init>(Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;Landroid/content/Context;)V

    .line 2432
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "trackSelectionFactory"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;

    .line 2399
    invoke-static {p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->getDefaults(Landroid/content/Context;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;-><init>(Landroid/content/Context;Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V

    .line 2400
    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;)V
    .locals 1
    .param p1, "parameters"    # Landroidx/media3/common/TrackSelectionParameters;
    .param p2, "trackSelectionFactory"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 2419
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;-><init>(Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;Landroid/content/Context;)V

    .line 2420
    return-void
.end method

.method private constructor <init>(Landroidx/media3/common/TrackSelectionParameters;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;Landroid/content/Context;)V
    .locals 2
    .param p1, "parameters"    # Landroidx/media3/common/TrackSelectionParameters;
    .param p2, "trackSelectionFactory"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;
    .param p3, "context"    # Landroid/content/Context;

    .line 2447
    invoke-direct {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;-><init>()V

    .line 2448
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    .line 2449
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->context:Landroid/content/Context;

    .line 2450
    iput-object p2, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->trackSelectionFactory:Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;

    .line 2451
    instance-of v0, p1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    if-eqz v0, :cond_1

    .line 2452
    move-object v0, p1

    check-cast v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    goto :goto_2

    .line 2455
    :cond_1
    if-nez p3, :cond_2

    sget-object v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->DEFAULT_WITHOUT_CONTEXT:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    goto :goto_1

    :cond_2
    invoke-static {p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->getDefaults(Landroid/content/Context;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    .line 2456
    .local v0, "defaultParameters":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    :goto_1
    invoke-virtual {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->buildUpon()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    move-result-object v1

    invoke-virtual {v1, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->set(Landroidx/media3/common/TrackSelectionParameters;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->build()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v1

    iput-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    .line 2458
    .end local v0    # "defaultParameters":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    :goto_2
    sget-object v0, Landroidx/media3/common/AudioAttributes;->DEFAULT:Landroidx/media3/common/AudioAttributes;

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->audioAttributes:Landroidx/media3/common/AudioAttributes;

    .line 2459
    if-eqz p3, :cond_3

    invoke-static {p3}, Landroidx/media3/common/util/Util;->isTv(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    goto :goto_3

    :cond_3
    const/4 v0, 0x0

    :goto_3
    iput-boolean v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->deviceIsTV:Z

    .line 2460
    if-nez v0, :cond_4

    if-eqz p3, :cond_4

    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x20

    if-lt v0, v1, :cond_4

    .line 2461
    invoke-static {p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->tryCreateInstance(Landroid/content/Context;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    .line 2463
    :cond_4
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    iget-boolean v0, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->constrainAudioChannelCountToDeviceCapabilities:Z

    if-eqz v0, :cond_5

    if-nez p3, :cond_5

    .line 2464
    const-string v0, "DefaultTrackSelector"

    const-string v1, "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument."

    invoke-static {v0, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2466
    :cond_5
    return-void
.end method

.method static synthetic access$4100(Landroidx/media3/common/TrackGroup;IIZ)I
    .locals 1
    .param p0, "x0"    # Landroidx/media3/common/TrackGroup;
    .param p1, "x1"    # I
    .param p2, "x2"    # I
    .param p3, "x3"    # Z

    .line 122
    invoke-static {p0, p1, p2, p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getMaxVideoPixelsToRetainForViewport(Landroidx/media3/common/TrackGroup;IIZ)I

    move-result v0

    return v0
.end method

.method static synthetic access$4200(II)I
    .locals 1
    .param p0, "x0"    # I
    .param p1, "x1"    # I

    .line 122
    invoke-static {p0, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getRoleFlagMatchScore(II)I

    move-result v0

    return v0
.end method

.method static synthetic access$4300(Ljava/lang/String;)I
    .locals 1
    .param p0, "x0"    # Ljava/lang/String;

    .line 122
    invoke-static {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getVideoCodecPreferenceScore(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method static synthetic access$4400()Lcom/google/common/collect/Ordering;
    .locals 1

    .line 122
    sget-object v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->FORMAT_VALUE_ORDERING:Lcom/google/common/collect/Ordering;

    return-object v0
.end method

.method static synthetic access$4500()Lcom/google/common/collect/Ordering;
    .locals 1

    .line 122
    sget-object v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->NO_ORDER:Lcom/google/common/collect/Ordering;

    return-object v0
.end method

.method static synthetic access$4600(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;ILandroidx/media3/common/Format;)Z
    .locals 1
    .param p0, "x0"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/media3/common/Format;

    .line 122
    invoke-static {p0, p1, p2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->rendererSupportsOffload(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;ILandroidx/media3/common/Format;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$4700(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;)V
    .locals 0
    .param p0, "x0"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;

    .line 122
    invoke-direct {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->maybeInvalidateForAudioChannelCountConstraints()V

    return-void
.end method

.method private static applyLegacyRendererOverrides(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;)V
    .locals 8
    .param p0, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p1, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p2, "outDefinitions"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    .line 3127
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v0

    .line 3128
    .local v0, "rendererCount":I
    const/4 v1, 0x0

    .local v1, "rendererIndex":I
    :goto_0
    if-ge v1, v0, :cond_2

    .line 3129
    invoke-virtual {p0, v1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v2

    .line 3130
    .local v2, "trackGroups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    invoke-virtual {p1, v1, v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->hasSelectionOverride(ILandroidx/media3/exoplayer/source/TrackGroupArray;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 3131
    goto :goto_2

    .line 3134
    :cond_0
    invoke-virtual {p1, v1, v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->getSelectionOverride(ILandroidx/media3/exoplayer/source/TrackGroupArray;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;

    move-result-object v3

    .line 3136
    .local v3, "override":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;
    if-eqz v3, :cond_1

    iget-object v4, v3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;->tracks:[I

    array-length v4, v4

    if-eqz v4, :cond_1

    .line 3137
    new-instance v4, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    iget v5, v3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;->groupIndex:I

    .line 3139
    invoke-virtual {v2, v5}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v5

    iget-object v6, v3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;->tracks:[I

    iget v7, v3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;->type:I

    invoke-direct {v4, v5, v6, v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;-><init>(Landroidx/media3/common/TrackGroup;[II)V

    .local v4, "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    goto :goto_1

    .line 3141
    .end local v4    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :cond_1
    const/4 v4, 0x0

    .line 3143
    .restart local v4    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :goto_1
    aput-object v4, p2, v1

    .line 3128
    .end local v2    # "trackGroups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .end local v3    # "override":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SelectionOverride;
    .end local v4    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 3145
    .end local v1    # "rendererIndex":I
    :cond_2
    return-void
.end method

.method private static applyTrackSelectionOverrides(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;Landroidx/media3/common/TrackSelectionParameters;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;)V
    .locals 8
    .param p0, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p1, "params"    # Landroidx/media3/common/TrackSelectionParameters;
    .param p2, "outDefinitions"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    .line 3063
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v0

    .line 3066
    .local v0, "rendererCount":I
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 3067
    .local v1, "overridesByType":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Landroidx/media3/common/TrackSelectionOverride;>;"
    const/4 v2, 0x0

    .local v2, "rendererIndex":I
    :goto_0
    if-ge v2, v0, :cond_0

    .line 3068
    nop

    .line 3069
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v3

    .line 3068
    invoke-static {v3, p1, v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->collectTrackSelectionOverrides(Landroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/common/TrackSelectionParameters;Ljava/util/Map;)V

    .line 3067
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 3071
    .end local v2    # "rendererIndex":I
    :cond_0
    nop

    .line 3072
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getUnmappedTrackGroups()Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v2

    .line 3071
    invoke-static {v2, p1, v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->collectTrackSelectionOverrides(Landroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/common/TrackSelectionParameters;Ljava/util/Map;)V

    .line 3075
    const/4 v2, 0x0

    .restart local v2    # "rendererIndex":I
    :goto_1
    if-ge v2, v0, :cond_3

    .line 3076
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v3

    .line 3077
    .local v3, "trackType":I
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/common/TrackSelectionOverride;

    .line 3078
    .local v4, "overrideForType":Landroidx/media3/common/TrackSelectionOverride;
    if-nez v4, :cond_1

    .line 3079
    goto :goto_3

    .line 3084
    :cond_1
    iget-object v5, v4, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v5}, Lcom/google/common/collect/ImmutableList;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_2

    .line 3085
    invoke-virtual {p0, v2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v5

    iget-object v6, v4, Landroidx/media3/common/TrackSelectionOverride;->mediaTrackGroup:Landroidx/media3/common/TrackGroup;

    invoke-virtual {v5, v6}, Landroidx/media3/exoplayer/source/TrackGroupArray;->indexOf(Landroidx/media3/common/TrackGroup;)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_2

    .line 3087
    new-instance v5, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    iget-object v6, v4, Landroidx/media3/common/TrackSelectionOverride;->mediaTrackGroup:Landroidx/media3/common/TrackGroup;

    iget-object v7, v4, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    .line 3089
    invoke-static {v7}, Lcom/google/common/primitives/Ints;->toArray(Ljava/util/Collection;)[I

    move-result-object v7

    invoke-direct {v5, v6, v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;-><init>(Landroidx/media3/common/TrackGroup;[I)V

    .local v5, "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    goto :goto_2

    .line 3091
    .end local v5    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :cond_2
    const/4 v5, 0x0

    .line 3093
    .restart local v5    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :goto_2
    aput-object v5, p2, v2

    .line 3075
    .end local v3    # "trackType":I
    .end local v4    # "overrideForType":Landroidx/media3/common/TrackSelectionOverride;
    .end local v5    # "selection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    :goto_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 3095
    .end local v2    # "rendererIndex":I
    :cond_3
    return-void
.end method

.method private static collectTrackSelectionOverrides(Landroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/common/TrackSelectionParameters;Ljava/util/Map;)V
    .locals 5
    .param p0, "trackGroups"    # Landroidx/media3/exoplayer/source/TrackGroupArray;
    .param p1, "params"    # Landroidx/media3/common/TrackSelectionParameters;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/source/TrackGroupArray;",
            "Landroidx/media3/common/TrackSelectionParameters;",
            "Ljava/util/Map<",
            "Ljava/lang/Integer;",
            "Landroidx/media3/common/TrackSelectionOverride;",
            ">;)V"
        }
    .end annotation

    .line 3107
    .local p2, "overridesByType":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Integer;Landroidx/media3/common/TrackSelectionOverride;>;"
    const/4 v0, 0x0

    .local v0, "trackGroupIndex":I
    :goto_0
    iget v1, p0, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    if-ge v0, v1, :cond_3

    .line 3108
    invoke-virtual {p0, v0}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v1

    .line 3109
    .local v1, "trackGroup":Landroidx/media3/common/TrackGroup;
    iget-object v2, p1, Landroidx/media3/common/TrackSelectionParameters;->overrides:Lcom/google/common/collect/ImmutableMap;

    invoke-virtual {v2, v1}, Lcom/google/common/collect/ImmutableMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/TrackSelectionOverride;

    .line 3110
    .local v2, "override":Landroidx/media3/common/TrackSelectionOverride;
    if-nez v2, :cond_0

    .line 3111
    goto :goto_1

    .line 3113
    :cond_0
    invoke-virtual {v2}, Landroidx/media3/common/TrackSelectionOverride;->getType()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {p2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroidx/media3/common/TrackSelectionOverride;

    .line 3115
    .local v3, "existingOverride":Landroidx/media3/common/TrackSelectionOverride;
    if-eqz v3, :cond_1

    iget-object v4, v3, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    .line 3116
    invoke-virtual {v4}, Lcom/google/common/collect/ImmutableList;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_2

    iget-object v4, v2, Landroidx/media3/common/TrackSelectionOverride;->trackIndices:Lcom/google/common/collect/ImmutableList;

    invoke-virtual {v4}, Lcom/google/common/collect/ImmutableList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 3117
    :cond_1
    invoke-virtual {v2}, Landroidx/media3/common/TrackSelectionOverride;->getType()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {p2, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3107
    .end local v1    # "trackGroup":Landroidx/media3/common/TrackGroup;
    .end local v2    # "override":Landroidx/media3/common/TrackSelectionOverride;
    .end local v3    # "existingOverride":Landroidx/media3/common/TrackSelectionOverride;
    :cond_2
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 3120
    .end local v0    # "trackGroupIndex":I
    :cond_3
    return-void
.end method

.method protected static getFormatLanguageScore(Landroidx/media3/common/Format;Ljava/lang/String;Z)I
    .locals 5
    .param p0, "format"    # Landroidx/media3/common/Format;
    .param p1, "language"    # Ljava/lang/String;
    .param p2, "allowUndeterminedFormatLanguage"    # Z

    .line 3367
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Landroidx/media3/common/Format;->language:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3369
    const/4 v0, 0x4

    return v0

    .line 3371
    :cond_0
    invoke-static {p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->normalizeUndeterminedLanguageToNull(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 3372
    iget-object v0, p0, Landroidx/media3/common/Format;->language:Ljava/lang/String;

    invoke-static {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->normalizeUndeterminedLanguageToNull(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3373
    .local v0, "formatLanguage":Ljava/lang/String;
    const/4 v1, 0x0

    if-eqz v0, :cond_5

    if-nez p1, :cond_1

    goto :goto_1

    .line 3377
    :cond_1
    invoke-virtual {v0, p1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_4

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    goto :goto_0

    .line 3381
    :cond_2
    const-string v2, "-"

    invoke-static {v0, v2}, Landroidx/media3/common/util/Util;->splitAtFirst(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    aget-object v3, v3, v1

    .line 3382
    .local v3, "formatMainLanguage":Ljava/lang/String;
    invoke-static {p1, v2}, Landroidx/media3/common/util/Util;->splitAtFirst(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    aget-object v2, v2, v1

    .line 3383
    .local v2, "queryMainLanguage":Ljava/lang/String;
    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 3385
    const/4 v1, 0x2

    return v1

    .line 3387
    :cond_3
    return v1

    .line 3379
    .end local v2    # "queryMainLanguage":Ljava/lang/String;
    .end local v3    # "formatMainLanguage":Ljava/lang/String;
    :cond_4
    :goto_0
    const/4 v1, 0x3

    return v1

    .line 3375
    :cond_5
    :goto_1
    if-eqz p2, :cond_6

    if-nez v0, :cond_6

    const/4 v1, 0x1

    :cond_6
    return v1
.end method

.method private static getMaxVideoPixelsToRetainForViewport(Landroidx/media3/common/TrackGroup;IIZ)I
    .locals 8
    .param p0, "group"    # Landroidx/media3/common/TrackGroup;
    .param p1, "viewportWidth"    # I
    .param p2, "viewportHeight"    # I
    .param p3, "orientationMayChange"    # Z

    .line 3392
    const v0, 0x7fffffff

    if-eq p1, v0, :cond_3

    if-ne p2, v0, :cond_0

    goto :goto_1

    .line 3395
    :cond_0
    const v0, 0x7fffffff

    .line 3396
    .local v0, "maxVideoPixelsToRetain":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget v2, p0, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v1, v2, :cond_2

    .line 3397
    invoke-virtual {p0, v1}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v2

    .line 3400
    .local v2, "format":Landroidx/media3/common/Format;
    iget v3, v2, Landroidx/media3/common/Format;->width:I

    if-lez v3, :cond_1

    iget v3, v2, Landroidx/media3/common/Format;->height:I

    if-lez v3, :cond_1

    .line 3401
    iget v3, v2, Landroidx/media3/common/Format;->width:I

    iget v4, v2, Landroidx/media3/common/Format;->height:I

    .line 3402
    invoke-static {p3, p1, p2, v3, v4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getMaxVideoSizeInViewport(ZIIII)Landroid/graphics/Point;

    move-result-object v3

    .line 3404
    .local v3, "maxVideoSizeInViewport":Landroid/graphics/Point;
    iget v4, v2, Landroidx/media3/common/Format;->width:I

    iget v5, v2, Landroidx/media3/common/Format;->height:I

    mul-int/2addr v4, v5

    .line 3405
    .local v4, "videoPixels":I
    iget v5, v2, Landroidx/media3/common/Format;->width:I

    iget v6, v3, Landroid/graphics/Point;->x:I

    int-to-float v6, v6

    const v7, 0x3f7ae148    # 0.98f

    mul-float/2addr v6, v7

    float-to-int v6, v6

    if-lt v5, v6, :cond_1

    iget v5, v2, Landroidx/media3/common/Format;->height:I

    iget v6, v3, Landroid/graphics/Point;->y:I

    int-to-float v6, v6

    mul-float/2addr v6, v7

    float-to-int v6, v6

    if-lt v5, v6, :cond_1

    if-ge v4, v0, :cond_1

    .line 3408
    move v0, v4

    .line 3396
    .end local v2    # "format":Landroidx/media3/common/Format;
    .end local v3    # "maxVideoSizeInViewport":Landroid/graphics/Point;
    .end local v4    # "videoPixels":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 3412
    .end local v1    # "i":I
    :cond_2
    return v0

    .line 3393
    .end local v0    # "maxVideoPixelsToRetain":I
    :cond_3
    :goto_1
    return v0
.end method

.method private static getMaxVideoSizeInViewport(ZIIII)Landroid/graphics/Point;
    .locals 3
    .param p0, "orientationMayChange"    # Z
    .param p1, "viewportWidth"    # I
    .param p2, "viewportHeight"    # I
    .param p3, "videoWidth"    # I
    .param p4, "videoHeight"    # I

    .line 3425
    if-eqz p0, :cond_2

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-le p3, p4, :cond_0

    move v2, v0

    goto :goto_0

    :cond_0
    move v2, v1

    :goto_0
    if-le p1, p2, :cond_1

    goto :goto_1

    :cond_1
    move v0, v1

    :goto_1
    if-eq v2, v0, :cond_2

    .line 3427
    move v0, p1

    .line 3428
    .local v0, "tempViewportWidth":I
    move p1, p2

    .line 3429
    move p2, v0

    .line 3432
    .end local v0    # "tempViewportWidth":I
    :cond_2
    mul-int v0, p3, p2

    mul-int v1, p4, p1

    if-lt v0, v1, :cond_3

    .line 3434
    new-instance v0, Landroid/graphics/Point;

    mul-int v1, p1, p4

    invoke-static {v1, p3}, Landroidx/media3/common/util/Util;->ceilDivide(II)I

    move-result v1

    invoke-direct {v0, p1, v1}, Landroid/graphics/Point;-><init>(II)V

    return-object v0

    .line 3437
    :cond_3
    new-instance v0, Landroid/graphics/Point;

    mul-int v1, p2, p3

    invoke-static {v1, p4}, Landroidx/media3/common/util/Util;->ceilDivide(II)I

    move-result v1

    invoke-direct {v0, v1, p2}, Landroid/graphics/Point;-><init>(II)V

    return-object v0
.end method

.method private static getRoleFlagMatchScore(II)I
    .locals 1
    .param p0, "trackRoleFlags"    # I
    .param p1, "preferredRoleFlags"    # I

    .line 3442
    if-eqz p0, :cond_0

    if-ne p0, p1, :cond_0

    .line 3444
    const v0, 0x7fffffff

    return v0

    .line 3446
    :cond_0
    and-int v0, p0, p1

    invoke-static {v0}, Ljava/lang/Integer;->bitCount(I)I

    move-result v0

    return v0
.end method

.method private static getVideoCodecPreferenceScore(Ljava/lang/String;)I
    .locals 6
    .param p0, "mimeType"    # Ljava/lang/String;

    .line 3454
    const/4 v0, 0x0

    if-nez p0, :cond_0

    .line 3455
    return v0

    .line 3457
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v1

    const/4 v2, 0x1

    const/4 v3, 0x2

    const/4 v4, 0x3

    const/4 v5, 0x4

    sparse-switch v1, :sswitch_data_0

    :cond_1
    goto :goto_0

    :sswitch_0
    const-string/jumbo v1, "video/x-vnd.on2.vp9"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v4

    goto :goto_1

    :sswitch_1
    const-string/jumbo v1, "video/avc"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v5

    goto :goto_1

    :sswitch_2
    const-string/jumbo v1, "video/hevc"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v3

    goto :goto_1

    :sswitch_3
    const-string/jumbo v1, "video/av01"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v2

    goto :goto_1

    :sswitch_4
    const-string/jumbo v1, "video/dolby-vision"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    move v1, v0

    goto :goto_1

    :goto_0
    const/4 v1, -0x1

    :goto_1
    packed-switch v1, :pswitch_data_0

    .line 3469
    return v0

    .line 3467
    :pswitch_0
    return v2

    .line 3465
    :pswitch_1
    return v3

    .line 3463
    :pswitch_2
    return v4

    .line 3461
    :pswitch_3
    return v5

    .line 3459
    :pswitch_4
    const/4 v0, 0x5

    return v0

    :sswitch_data_0
    .sparse-switch
        -0x6e5534ef -> :sswitch_4
        -0x631b55f6 -> :sswitch_3
        -0x63185e82 -> :sswitch_2
        0x4f62373a -> :sswitch_1
        0x5f50bed9 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private isAudioFormatWithinAudioChannelCountConstraints(Landroidx/media3/common/Format;)Z
    .locals 3
    .param p1, "format"    # Landroidx/media3/common/Format;

    .line 2844
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 2845
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    iget-boolean v1, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->constrainAudioChannelCountToDeviceCapabilities:Z

    if-eqz v1, :cond_2

    iget-boolean v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->deviceIsTV:Z

    if-nez v1, :cond_2

    iget v1, p1, Landroidx/media3/common/Format;->channelCount:I

    const/4 v2, 0x2

    if-le v1, v2, :cond_2

    .line 2848
    invoke-static {p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->isDolbyAudio(Landroidx/media3/common/Format;)Z

    move-result v1

    const/16 v2, 0x20

    if-eqz v1, :cond_0

    sget v1, Landroidx/media3/common/util/Util;->SDK_INT:I

    if-lt v1, v2, :cond_2

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    if-eqz v1, :cond_2

    .line 2851
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->isSpatializationSupported()Z

    move-result v1

    if-eqz v1, :cond_2

    :cond_0
    sget v1, Landroidx/media3/common/util/Util;->SDK_INT:I

    if-lt v1, v2, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    if-eqz v1, :cond_1

    .line 2854
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->isSpatializationSupported()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    .line 2855
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    .line 2856
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->isEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    iget-object v2, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->audioAttributes:Landroidx/media3/common/AudioAttributes;

    .line 2857
    invoke-virtual {v1, v2, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->canBeSpatialized(Landroidx/media3/common/AudioAttributes;Landroidx/media3/common/Format;)Z

    move-result v1

    if-eqz v1, :cond_1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    goto :goto_1

    :cond_2
    :goto_0
    const/4 v1, 0x1

    :goto_1
    monitor-exit v0

    .line 2845
    return v1

    .line 2858
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private static isDolbyAudio(Landroidx/media3/common/Format;)Z
    .locals 4
    .param p0, "format"    # Landroidx/media3/common/Format;

    .line 3474
    iget-object v0, p0, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 3475
    return v1

    .line 3477
    :cond_0
    iget-object v0, p0, Landroidx/media3/common/Format;->sampleMimeType:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v2

    const/4 v3, 0x1

    sparse-switch v2, :sswitch_data_0

    :cond_1
    goto :goto_0

    :sswitch_0
    const-string v2, "audio/eac3"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v3

    goto :goto_1

    :sswitch_1
    const-string v2, "audio/ac4"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x3

    goto :goto_1

    :sswitch_2
    const-string v2, "audio/ac3"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    goto :goto_1

    :sswitch_3
    const-string v2, "audio/eac3-joc"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x2

    goto :goto_1

    :goto_0
    const/4 v0, -0x1

    :goto_1
    packed-switch v0, :pswitch_data_0

    .line 3484
    return v1

    .line 3482
    :pswitch_0
    return v3

    nop

    :sswitch_data_0
    .sparse-switch
        -0x7e929daa -> :sswitch_3
        0xb269698 -> :sswitch_2
        0xb269699 -> :sswitch_1
        0x59ae0c65 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method protected static isSupported(IZ)Z
    .locals 2
    .param p0, "formatSupport"    # I
    .param p1, "allowExceedsCapabilities"    # Z

    .line 3335
    invoke-static {p0}, Landroidx/media3/exoplayer/RendererCapabilities;->getFormatSupport(I)I

    move-result v0

    .line 3336
    .local v0, "maskedSupport":I
    const/4 v1, 0x4

    if-eq v0, v1, :cond_1

    if-eqz p1, :cond_0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v1, 0x1

    :goto_1
    return v1
.end method

.method static synthetic lambda$selectImageTrack$5(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;ILandroidx/media3/common/TrackGroup;[I)Ljava/util/List;
    .locals 1
    .param p0, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "rendererIndex"    # I
    .param p2, "group"    # Landroidx/media3/common/TrackGroup;
    .param p3, "support"    # [I

    .line 2925
    invoke-static {p1, p2, p0, p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ImageTrackInfo;->createForTrackGroup(ILandroidx/media3/common/TrackGroup;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[I)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic lambda$selectTextTrack$4(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Ljava/lang/String;ILandroidx/media3/common/TrackGroup;[I)Ljava/util/List;
    .locals 1
    .param p0, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "selectedAudioLanguage"    # Ljava/lang/String;
    .param p2, "rendererIndex"    # I
    .param p3, "group"    # Landroidx/media3/common/TrackGroup;
    .param p4, "support"    # [I

    .line 2892
    invoke-static {p2, p3, p0, p4, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TextTrackInfo;->createForTrackGroup(ILandroidx/media3/common/TrackGroup;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[ILjava/lang/String;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic lambda$selectVideoTrack$2(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[IILandroidx/media3/common/TrackGroup;[I)Ljava/util/List;
    .locals 1
    .param p0, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "mixedMimeTypeSupports"    # [I
    .param p2, "rendererIndex"    # I
    .param p3, "group"    # Landroidx/media3/common/TrackGroup;
    .param p4, "support"    # [I

    .line 2773
    aget v0, p1, p2

    invoke-static {p2, p3, p0, p4, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$VideoTrackInfo;->createForTrackGroup(ILandroidx/media3/common/TrackGroup;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[II)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic lambda$static$0(Ljava/lang/Integer;Ljava/lang/Integer;)I
    .locals 2
    .param p0, "first"    # Ljava/lang/Integer;
    .param p1, "second"    # Ljava/lang/Integer;

    .line 2365
    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 2366
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v1, :cond_2

    const/4 v1, 0x0

    goto :goto_0

    .line 2367
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v1, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    sub-int v1, v0, v1

    .line 2365
    :cond_2
    :goto_0
    return v1
.end method

.method static synthetic lambda$static$1(Ljava/lang/Integer;Ljava/lang/Integer;)I
    .locals 1
    .param p0, "first"    # Ljava/lang/Integer;
    .param p1, "second"    # Ljava/lang/Integer;

    .line 2370
    const/4 v0, 0x0

    return v0
.end method

.method private static maybeConfigureRendererForOffload(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)V
    .locals 9
    .param p0, "parameters"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "rendererConfigurations"    # [Landroidx/media3/exoplayer/RendererConfiguration;
    .param p4, "trackSelections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 3253
    const/4 v0, -0x1

    .line 3254
    .local v0, "audioRendererIndex":I
    const/4 v1, 0x0

    .line 3255
    .local v1, "audioRenderersSupportingOffload":I
    const/4 v2, 0x0

    .line 3256
    .local v2, "hasNonAudioRendererWithSelectedTracks":Z
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v4

    const/4 v5, 0x0

    const/4 v6, 0x1

    if-ge v3, v4, :cond_2

    .line 3257
    invoke-virtual {p1, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v4

    .line 3258
    .local v4, "rendererType":I
    aget-object v7, p4, v3

    .line 3259
    .local v7, "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    if-eq v4, v6, :cond_0

    if-eqz v7, :cond_0

    .line 3260
    const/4 v2, 0x1

    .line 3261
    goto :goto_1

    .line 3263
    :cond_0
    if-ne v4, v6, :cond_1

    if-eqz v7, :cond_1

    .line 3265
    invoke-interface {v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->length()I

    move-result v8

    if-ne v8, v6, :cond_1

    .line 3266
    nop

    .line 3267
    invoke-virtual {p1, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v6

    invoke-interface {v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v8

    invoke-virtual {v6, v8}, Landroidx/media3/exoplayer/source/TrackGroupArray;->indexOf(Landroidx/media3/common/TrackGroup;)I

    move-result v6

    .line 3269
    .local v6, "trackGroupIndex":I
    aget-object v8, p2, v3

    aget-object v8, v8, v6

    .line 3270
    invoke-interface {v7, v5}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getIndexInTrackGroup(I)I

    move-result v5

    aget v5, v8, v5

    .line 3271
    .local v5, "trackFormatSupport":I
    nop

    .line 3272
    invoke-interface {v7}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getSelectedFormat()Landroidx/media3/common/Format;

    move-result-object v8

    .line 3271
    invoke-static {p0, v5, v8}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->rendererSupportsOffload(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;ILandroidx/media3/common/Format;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 3273
    move v0, v3

    .line 3274
    add-int/lit8 v1, v1, 0x1

    .line 3256
    .end local v4    # "rendererType":I
    .end local v5    # "trackFormatSupport":I
    .end local v6    # "trackGroupIndex":I
    .end local v7    # "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 3278
    .end local v3    # "i":I
    :cond_2
    :goto_1
    if-nez v2, :cond_5

    if-ne v1, v6, :cond_5

    .line 3279
    new-instance v3, Landroidx/media3/exoplayer/RendererConfiguration;

    .line 3281
    iget-object v4, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget-boolean v4, v4, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->isGaplessSupportRequired:Z

    if-eqz v4, :cond_3

    .line 3282
    move v4, v6

    goto :goto_2

    .line 3283
    :cond_3
    const/4 v4, 0x2

    :goto_2
    aget-object v7, p3, v0

    if-eqz v7, :cond_4

    aget-object v7, p3, v0

    iget-boolean v7, v7, Landroidx/media3/exoplayer/RendererConfiguration;->tunneling:Z

    if-eqz v7, :cond_4

    move v5, v6

    :cond_4
    invoke-direct {v3, v4, v5}, Landroidx/media3/exoplayer/RendererConfiguration;-><init>(IZ)V

    .line 3286
    .local v3, "offloadRendererConfiguration":Landroidx/media3/exoplayer/RendererConfiguration;
    aput-object v3, p3, v0

    .line 3288
    .end local v3    # "offloadRendererConfiguration":Landroidx/media3/exoplayer/RendererConfiguration;
    :cond_5
    return-void
.end method

.method private static maybeConfigureRenderersForTunneling(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)V
    .locals 10
    .param p0, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p1, "rendererFormatSupports"    # [[[I
    .param p2, "rendererConfigurations"    # [Landroidx/media3/exoplayer/RendererConfiguration;
    .param p3, "trackSelections"    # [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 3166
    const/4 v0, -0x1

    .line 3167
    .local v0, "tunnelingAudioRendererIndex":I
    const/4 v1, -0x1

    .line 3168
    .local v1, "tunnelingVideoRendererIndex":I
    const/4 v2, 0x1

    .line 3169
    .local v2, "enableTunneling":Z
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v4

    const/4 v5, -0x1

    const/4 v6, 0x1

    if-ge v3, v4, :cond_5

    .line 3170
    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v4

    .line 3171
    .local v4, "rendererType":I
    aget-object v7, p3, v3

    .line 3172
    .local v7, "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    if-eq v4, v6, :cond_0

    const/4 v8, 0x2

    if-ne v4, v8, :cond_4

    :cond_0
    if-eqz v7, :cond_4

    .line 3174
    aget-object v8, p1, v3

    .line 3175
    invoke-virtual {p0, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v9

    .line 3174
    invoke-static {v8, v9, v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->rendererSupportsTunneling([[ILandroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 3176
    if-ne v4, v6, :cond_2

    .line 3177
    if-eq v0, v5, :cond_1

    .line 3178
    const/4 v2, 0x0

    .line 3179
    goto :goto_2

    .line 3181
    :cond_1
    move v0, v3

    goto :goto_1

    .line 3184
    :cond_2
    if-eq v1, v5, :cond_3

    .line 3185
    const/4 v2, 0x0

    .line 3186
    goto :goto_2

    .line 3188
    :cond_3
    move v1, v3

    .line 3169
    .end local v4    # "rendererType":I
    .end local v7    # "trackSelection":Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    :cond_4
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 3194
    .end local v3    # "i":I
    :cond_5
    :goto_2
    const/4 v3, 0x0

    if-eq v0, v5, :cond_6

    if-eq v1, v5, :cond_6

    move v4, v6

    goto :goto_3

    :cond_6
    move v4, v3

    :goto_3
    and-int/2addr v2, v4

    .line 3195
    if-eqz v2, :cond_7

    .line 3196
    new-instance v4, Landroidx/media3/exoplayer/RendererConfiguration;

    invoke-direct {v4, v3, v6}, Landroidx/media3/exoplayer/RendererConfiguration;-><init>(IZ)V

    move-object v3, v4

    .line 3198
    .local v3, "tunnelingRendererConfiguration":Landroidx/media3/exoplayer/RendererConfiguration;
    aput-object v3, p2, v0

    .line 3199
    aput-object v3, p2, v1

    .line 3201
    .end local v3    # "tunnelingRendererConfiguration":Landroidx/media3/exoplayer/RendererConfiguration;
    :cond_7
    return-void
.end method

.method private maybeInvalidateForAudioChannelCountConstraints()V
    .locals 3

    .line 3034
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 3035
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    iget-boolean v1, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->constrainAudioChannelCountToDeviceCapabilities:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->deviceIsTV:Z

    if-nez v1, :cond_0

    sget v1, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v2, 0x20

    if-lt v1, v2, :cond_0

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    if-eqz v1, :cond_0

    .line 3040
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->isSpatializationSupported()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 3041
    .local v1, "shouldInvalidate":Z
    :goto_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3042
    if-eqz v1, :cond_1

    .line 3043
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->invalidate()V

    .line 3045
    :cond_1
    return-void

    .line 3041
    .end local v1    # "shouldInvalidate":Z
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method private maybeInvalidateForRendererCapabilitiesChange(Landroidx/media3/exoplayer/Renderer;)V
    .locals 2
    .param p1, "renderer"    # Landroidx/media3/exoplayer/Renderer;

    .line 3049
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 3050
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    iget-boolean v1, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->allowInvalidateSelectionsOnRendererCapabilitiesChange:Z

    .line 3051
    .local v1, "shouldInvalidate":Z
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 3052
    if-eqz v1, :cond_0

    .line 3053
    invoke-virtual {p0, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->invalidateForRendererCapabilitiesChange(Landroidx/media3/exoplayer/Renderer;)V

    .line 3055
    :cond_0
    return-void

    .line 3051
    .end local v1    # "shouldInvalidate":Z
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method protected static normalizeUndeterminedLanguageToNull(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "language"    # Ljava/lang/String;

    .line 3348
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string/jumbo v0, "und"

    invoke-static {p0, v0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 3350
    :cond_0
    move-object v0, p0

    goto :goto_1

    .line 3349
    :cond_1
    :goto_0
    const/4 v0, 0x0

    .line 3348
    :goto_1
    return-object v0
.end method

.method private static rendererSupportsOffload(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;ILandroidx/media3/common/Format;)Z
    .locals 4
    .param p0, "parameters"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p1, "formatSupport"    # I
    .param p2, "format"    # Landroidx/media3/common/Format;

    .line 3300
    invoke-static {p1}, Landroidx/media3/exoplayer/RendererCapabilities;->getAudioOffloadSupport(I)I

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 3301
    return v1

    .line 3303
    :cond_0
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget-boolean v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->isSpeedChangeSupportRequired:Z

    if-eqz v0, :cond_1

    .line 3304
    invoke-static {p1}, Landroidx/media3/exoplayer/RendererCapabilities;->getAudioOffloadSupport(I)I

    move-result v0

    and-int/lit16 v0, v0, 0x800

    if-nez v0, :cond_1

    .line 3307
    return v1

    .line 3310
    :cond_1
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget-boolean v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->isGaplessSupportRequired:Z

    const/4 v2, 0x1

    if-eqz v0, :cond_7

    .line 3311
    iget v0, p2, Landroidx/media3/common/Format;->encoderDelay:I

    if-nez v0, :cond_3

    iget v0, p2, Landroidx/media3/common/Format;->encoderPadding:I

    if-eqz v0, :cond_2

    goto :goto_0

    :cond_2
    move v0, v1

    goto :goto_1

    :cond_3
    :goto_0
    move v0, v2

    .line 3312
    .local v0, "isGapless":Z
    :goto_1
    nop

    .line 3313
    invoke-static {p1}, Landroidx/media3/exoplayer/RendererCapabilities;->getAudioOffloadSupport(I)I

    move-result v3

    and-int/lit16 v3, v3, 0x400

    if-eqz v3, :cond_4

    move v3, v2

    goto :goto_2

    :cond_4
    move v3, v1

    .line 3316
    .local v3, "isGaplessSupported":Z
    :goto_2
    if-eqz v0, :cond_5

    if-eqz v3, :cond_6

    :cond_5
    move v1, v2

    :cond_6
    return v1

    .line 3318
    .end local v0    # "isGapless":Z
    .end local v3    # "isGaplessSupported":Z
    :cond_7
    return v2
.end method

.method private static rendererSupportsTunneling([[ILandroidx/media3/exoplayer/source/TrackGroupArray;Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)Z
    .locals 6
    .param p0, "formatSupport"    # [[I
    .param p1, "trackGroups"    # Landroidx/media3/exoplayer/source/TrackGroupArray;
    .param p2, "selection"    # Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    .line 3216
    const/4 v0, 0x0

    if-nez p2, :cond_0

    .line 3217
    return v0

    .line 3219
    :cond_0
    invoke-interface {p2}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getTrackGroup()Landroidx/media3/common/TrackGroup;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/source/TrackGroupArray;->indexOf(Landroidx/media3/common/TrackGroup;)I

    move-result v1

    .line 3220
    .local v1, "trackGroupIndex":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {p2}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->length()I

    move-result v3

    if-ge v2, v3, :cond_2

    .line 3222
    aget-object v3, p0, v1

    invoke-interface {p2, v2}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;->getIndexInTrackGroup(I)I

    move-result v4

    aget v3, v3, v4

    .line 3223
    .local v3, "trackFormatSupport":I
    invoke-static {v3}, Landroidx/media3/exoplayer/RendererCapabilities;->getTunnelingSupport(I)I

    move-result v4

    const/16 v5, 0x20

    if-eq v4, v5, :cond_1

    .line 3225
    return v0

    .line 3220
    .end local v3    # "trackFormatSupport":I
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 3228
    .end local v2    # "i":I
    :cond_2
    const/4 v0, 0x1

    return v0
.end method

.method private selectTracksForType(ILandroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;Ljava/util/Comparator;)Landroid/util/Pair;
    .locals 19
    .param p1, "trackType"    # I
    .param p2, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p3, "formatSupport"    # [[[I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo<",
            "TT;>;>(I",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory<",
            "TT;>;",
            "Ljava/util/Comparator<",
            "Ljava/util/List<",
            "TT;>;>;)",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .line 2981
    .local p4, "trackInfoFactory":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;, "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory<TT;>;"
    .local p5, "selectionComparator":Ljava/util/Comparator;, "Ljava/util/Comparator<Ljava/util/List<TT;>;>;"
    move-object/from16 v0, p2

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 2982
    .local v1, "possibleSelections":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/List<TT;>;>;"
    invoke-virtual/range {p2 .. p2}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v2

    .line 2983
    .local v2, "rendererCount":I
    const/4 v3, 0x0

    .local v3, "rendererIndex":I
    :goto_0
    if-ge v3, v2, :cond_9

    .line 2984
    invoke-virtual {v0, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v4

    move/from16 v5, p1

    if-ne v5, v4, :cond_8

    .line 2985
    invoke-virtual {v0, v3}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v4

    .line 2986
    .local v4, "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    const/4 v6, 0x0

    .local v6, "groupIndex":I
    :goto_1
    iget v7, v4, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    if-ge v6, v7, :cond_7

    .line 2987
    invoke-virtual {v4, v6}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v7

    .line 2988
    .local v7, "trackGroup":Landroidx/media3/common/TrackGroup;
    aget-object v8, p3, v3

    aget-object v8, v8, v6

    .line 2989
    .local v8, "groupSupport":[I
    move-object/from16 v9, p4

    invoke-interface {v9, v3, v7, v8}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;->create(ILandroidx/media3/common/TrackGroup;[I)Ljava/util/List;

    move-result-object v10

    .line 2990
    .local v10, "trackInfos":Ljava/util/List;, "Ljava/util/List<TT;>;"
    iget v11, v7, Landroidx/media3/common/TrackGroup;->length:I

    new-array v11, v11, [Z

    .line 2991
    .local v11, "usedTrackInSelection":[Z
    const/4 v12, 0x0

    .local v12, "trackIndex":I
    :goto_2
    iget v13, v7, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v12, v13, :cond_6

    .line 2992
    invoke-interface {v10, v12}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;

    .line 2993
    .local v13, "trackInfo":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;, "TT;"
    invoke-virtual {v13}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->getSelectionEligibility()I

    move-result v14

    .line 2994
    .local v14, "eligibility":I
    aget-boolean v15, v11, v12

    if-nez v15, :cond_5

    if-nez v14, :cond_0

    .line 2995
    move/from16 v17, v2

    move-object/from16 v18, v4

    goto :goto_6

    .line 2998
    :cond_0
    const/4 v15, 0x1

    if-ne v14, v15, :cond_1

    .line 2999
    invoke-static {v13}, Lcom/google/common/collect/ImmutableList;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;

    move-result-object v15

    move/from16 v17, v2

    move-object/from16 v18, v4

    .local v15, "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    goto :goto_5

    .line 3001
    .end local v15    # "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :cond_1
    new-instance v16, Ljava/util/ArrayList;

    invoke-direct/range {v16 .. v16}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v17, v16

    .line 3002
    .local v17, "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move-object/from16 v15, v17

    .end local v17    # "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .restart local v15    # "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v15, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3003
    add-int/lit8 v17, v12, 0x1

    move/from16 v0, v17

    .local v0, "i":I
    :goto_3
    move/from16 v17, v2

    .end local v2    # "rendererCount":I
    .local v17, "rendererCount":I
    iget v2, v7, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v0, v2, :cond_4

    .line 3004
    invoke-interface {v10, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;

    .line 3005
    .local v2, "otherTrackInfo":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;, "TT;"
    move-object/from16 v18, v4

    .end local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .local v18, "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    invoke-virtual {v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->getSelectionEligibility()I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_3

    .line 3006
    invoke-virtual {v13, v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->isCompatibleForAdaptationWith(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 3007
    invoke-interface {v15, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3008
    const/4 v4, 0x1

    aput-boolean v4, v11, v0

    goto :goto_4

    .line 3006
    :cond_2
    const/4 v4, 0x1

    goto :goto_4

    .line 3005
    :cond_3
    const/4 v4, 0x1

    .line 3003
    .end local v2    # "otherTrackInfo":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;, "TT;"
    :goto_4
    add-int/lit8 v0, v0, 0x1

    move/from16 v5, p1

    move/from16 v2, v17

    move-object/from16 v4, v18

    goto :goto_3

    .end local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :cond_4
    move-object/from16 v18, v4

    .line 3013
    .end local v0    # "i":I
    .end local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :goto_5
    invoke-virtual {v1, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 2994
    .end local v15    # "selection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v17    # "rendererCount":I
    .end local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .local v2, "rendererCount":I
    .restart local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :cond_5
    move/from16 v17, v2

    move-object/from16 v18, v4

    .line 2991
    .end local v2    # "rendererCount":I
    .end local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .end local v13    # "trackInfo":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;, "TT;"
    .end local v14    # "eligibility":I
    .restart local v17    # "rendererCount":I
    .restart local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :goto_6
    add-int/lit8 v12, v12, 0x1

    move/from16 v5, p1

    move-object/from16 v0, p2

    move/from16 v2, v17

    move-object/from16 v4, v18

    goto :goto_2

    .end local v17    # "rendererCount":I
    .end local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v2    # "rendererCount":I
    .restart local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :cond_6
    move/from16 v17, v2

    move-object/from16 v18, v4

    .line 2986
    .end local v2    # "rendererCount":I
    .end local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .end local v7    # "trackGroup":Landroidx/media3/common/TrackGroup;
    .end local v8    # "groupSupport":[I
    .end local v10    # "trackInfos":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v11    # "usedTrackInSelection":[Z
    .end local v12    # "trackIndex":I
    .restart local v17    # "rendererCount":I
    .restart local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    add-int/lit8 v6, v6, 0x1

    move/from16 v5, p1

    move-object/from16 v0, p2

    goto/16 :goto_1

    .end local v17    # "rendererCount":I
    .end local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v2    # "rendererCount":I
    .restart local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    :cond_7
    move-object/from16 v9, p4

    move/from16 v17, v2

    move-object/from16 v18, v4

    .end local v2    # "rendererCount":I
    .end local v4    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v17    # "rendererCount":I
    .restart local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    goto :goto_7

    .line 2984
    .end local v6    # "groupIndex":I
    .end local v17    # "rendererCount":I
    .end local v18    # "groups":Landroidx/media3/exoplayer/source/TrackGroupArray;
    .restart local v2    # "rendererCount":I
    :cond_8
    move-object/from16 v9, p4

    move/from16 v17, v2

    .line 2983
    .end local v2    # "rendererCount":I
    .restart local v17    # "rendererCount":I
    :goto_7
    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p2

    move/from16 v2, v17

    goto/16 :goto_0

    .end local v17    # "rendererCount":I
    .restart local v2    # "rendererCount":I
    :cond_9
    move-object/from16 v9, p4

    move/from16 v17, v2

    .line 3018
    .end local v2    # "rendererCount":I
    .end local v3    # "rendererIndex":I
    .restart local v17    # "rendererCount":I
    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 3019
    const/4 v0, 0x0

    return-object v0

    .line 3021
    :cond_a
    move-object/from16 v0, p5

    invoke-static {v1, v0}, Ljava/util/Collections;->max(Ljava/util/Collection;Ljava/util/Comparator;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 3022
    .local v2, "bestSelection":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    new-array v3, v3, [I

    .line 3023
    .local v3, "trackIndices":[I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_8
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v5

    if-ge v4, v5, :cond_b

    .line 3024
    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;

    iget v5, v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->trackIndex:I

    aput v5, v3, v4

    .line 3023
    add-int/lit8 v4, v4, 0x1

    goto :goto_8

    .line 3026
    .end local v4    # "i":I
    :cond_b
    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;

    .line 3027
    .local v4, "firstTrackInfo":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;, "TT;"
    new-instance v5, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    iget-object v6, v4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->trackGroup:Landroidx/media3/common/TrackGroup;

    invoke-direct {v5, v6, v3}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;-><init>(Landroidx/media3/common/TrackGroup;[I)V

    iget v6, v4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo;->rendererIndex:I

    .line 3029
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    .line 3027
    invoke-static {v5, v6}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v5

    return-object v5
.end method

.method private setParametersInternal(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V
    .locals 3
    .param p1, "parameters"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    .line 2541
    invoke-static {p1}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2543
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 2544
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    invoke-virtual {v1, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 2545
    .local v1, "parametersChanged":Z
    :goto_0
    iput-object p1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    .line 2546
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2548
    if-eqz v1, :cond_2

    .line 2549
    iget-boolean v0, p1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->constrainAudioChannelCountToDeviceCapabilities:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->context:Landroid/content/Context;

    if-nez v0, :cond_1

    .line 2550
    const-string v0, "DefaultTrackSelector"

    const-string v2, "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument."

    invoke-static {v0, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2552
    :cond_1
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->invalidate()V

    .line 2554
    :cond_2
    return-void

    .line 2546
    .end local v1    # "parametersChanged":Z
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method


# virtual methods
.method public buildUponParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;
    .locals 1

    .line 2532
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->buildUpon()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getParameters()Landroidx/media3/common/TrackSelectionParameters;
    .locals 1

    .line 121
    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    return-object v0
.end method

.method public getParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .locals 2

    .line 2480
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 2481
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    monitor-exit v0

    return-object v1

    .line 2482
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getRendererCapabilitiesListener()Landroidx/media3/exoplayer/RendererCapabilities$Listener;
    .locals 0

    .line 2559
    return-object p0
.end method

.method public isSetParametersSupported()Z
    .locals 1

    .line 2487
    const/4 v0, 0x1

    return v0
.end method

.method synthetic lambda$selectAudioTrack$3$androidx-media3-exoplayer-trackselection-DefaultTrackSelector(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Z[IILandroidx/media3/common/TrackGroup;[I)Ljava/util/List;
    .locals 7
    .param p1, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p2, "hasVideoRendererWithMappedTracksFinal"    # Z
    .param p3, "rendererMixedMimeTypeAdaptationSupports"    # [I
    .param p4, "rendererIndex"    # I
    .param p5, "group"    # Landroidx/media3/common/TrackGroup;
    .param p6, "support"    # [I

    .line 2815
    new-instance v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda5;

    invoke-direct {v5, p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda5;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;)V

    aget v6, p3, p4

    move v0, p4

    move-object v1, p5

    move-object v2, p1

    move-object v3, p6

    move v4, p2

    invoke-static/range {v0 .. v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$AudioTrackInfo;->createForTrackGroup(ILandroidx/media3/common/TrackGroup;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[IZLcom/google/common/base/Predicate;I)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    return-object v0
.end method

.method public onRendererCapabilitiesChanged(Landroidx/media3/exoplayer/Renderer;)V
    .locals 0
    .param p1, "renderer"    # Landroidx/media3/exoplayer/Renderer;

    .line 2566
    invoke-direct {p0, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->maybeInvalidateForRendererCapabilitiesChange(Landroidx/media3/exoplayer/Renderer;)V

    .line 2567
    return-void
.end method

.method public release()V
    .locals 3

    .line 2470
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 2471
    :try_start_0
    sget v1, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v2, 0x20

    if-lt v1, v2, :cond_0

    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    if-eqz v1, :cond_0

    .line 2472
    invoke-virtual {v1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->release()V

    .line 2474
    :cond_0
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2475
    invoke-super {p0}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector;->release()V

    .line 2476
    return-void

    .line 2474
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method protected selectAllTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    .locals 11
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "rendererMixedMimeTypeAdaptationSupports"    # [I
    .param p4, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2681
    invoke-virtual {p1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v0

    .line 2682
    .local v0, "rendererCount":I
    new-array v1, v0, [Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    .line 2686
    .local v1, "definitions":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    nop

    .line 2687
    invoke-virtual {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectVideoTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;

    move-result-object v2

    .line 2695
    .local v2, "selectedVideo":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;Ljava/lang/Integer;>;"
    iget-boolean v3, p4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->isPrioritizeImageOverVideoEnabled:Z

    const/4 v4, 0x0

    if-nez v3, :cond_1

    if-nez v2, :cond_0

    goto :goto_0

    .line 2697
    :cond_0
    move-object v3, v4

    goto :goto_1

    .line 2696
    :cond_1
    :goto_0
    invoke-virtual {p0, p1, p2, p4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectImageTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;

    move-result-object v3

    .line 2697
    :goto_1
    nop

    .line 2699
    .local v3, "selectedImage":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;Ljava/lang/Integer;>;"
    if-eqz v3, :cond_2

    .line 2700
    iget-object v5, v3, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iget-object v6, v3, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v6, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    aput-object v6, v1, v5

    goto :goto_2

    .line 2701
    :cond_2
    if-eqz v2, :cond_3

    .line 2702
    iget-object v5, v2, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    iget-object v6, v2, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v6, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    aput-object v6, v1, v5

    .line 2706
    :cond_3
    :goto_2
    nop

    .line 2707
    invoke-virtual {p0, p1, p2, p3, p4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectAudioTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;

    move-result-object v5

    .line 2712
    .local v5, "selectedAudio":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;Ljava/lang/Integer;>;"
    if-eqz v5, :cond_4

    .line 2713
    iget-object v6, v5, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    iget-object v7, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v7, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    aput-object v7, v1, v6

    .line 2718
    :cond_4
    if-nez v5, :cond_5

    .line 2719
    goto :goto_3

    .line 2720
    :cond_5
    iget-object v4, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v4, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    iget-object v4, v4, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;->group:Landroidx/media3/common/TrackGroup;

    iget-object v6, v5, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v6, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    iget-object v6, v6, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;->tracks:[I

    const/4 v7, 0x0

    aget v6, v6, v7

    invoke-virtual {v4, v6}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v4

    iget-object v4, v4, Landroidx/media3/common/Format;->language:Ljava/lang/String;

    :goto_3
    nop

    .line 2722
    .local v4, "selectedAudioLanguage":Ljava/lang/String;
    nop

    .line 2723
    invoke-virtual {p0, p1, p2, p4, v4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectTextTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Ljava/lang/String;)Landroid/util/Pair;

    move-result-object v6

    .line 2724
    .local v6, "selectedText":Landroid/util/Pair;, "Landroid/util/Pair<Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;Ljava/lang/Integer;>;"
    if-eqz v6, :cond_6

    .line 2725
    iget-object v7, v6, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    iget-object v8, v6, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v8, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    aput-object v8, v1, v7

    .line 2728
    :cond_6
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_4
    if-ge v7, v0, :cond_8

    .line 2729
    invoke-virtual {p1, v7}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v8

    .line 2730
    .local v8, "trackType":I
    const/4 v9, 0x2

    if-eq v8, v9, :cond_7

    const/4 v9, 0x1

    if-eq v8, v9, :cond_7

    const/4 v9, 0x3

    if-eq v8, v9, :cond_7

    const/4 v9, 0x4

    if-eq v8, v9, :cond_7

    .line 2734
    nop

    .line 2736
    invoke-virtual {p1, v7}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v9

    aget-object v10, p2, v7

    .line 2735
    invoke-virtual {p0, v8, v9, v10, p4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectOtherTrack(ILandroidx/media3/exoplayer/source/TrackGroupArray;[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    move-result-object v9

    aput-object v9, v1, v7

    .line 2728
    .end local v8    # "trackType":I
    :cond_7
    add-int/lit8 v7, v7, 0x1

    goto :goto_4

    .line 2739
    .end local v7    # "i":I
    :cond_8
    return-object v1
.end method

.method protected selectAudioTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;
    .locals 8
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "rendererMixedMimeTypeAdaptationSupports"    # [I
    .param p4, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I[I",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;",
            ")",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2801
    const/4 v0, 0x0

    .line 2802
    .local v0, "hasVideoRendererWithMappedTracks":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 2803
    const/4 v2, 0x2

    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 2804
    invoke-virtual {p1, v1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getTrackGroups(I)Landroidx/media3/exoplayer/source/TrackGroupArray;

    move-result-object v2

    iget v2, v2, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    if-lez v2, :cond_0

    .line 2805
    const/4 v0, 0x1

    .line 2806
    goto :goto_1

    .line 2802
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2809
    .end local v1    # "i":I
    :cond_1
    :goto_1
    move v1, v0

    .line 2810
    .local v1, "hasVideoRendererWithMappedTracksFinal":Z
    const/4 v3, 0x1

    new-instance v6, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda0;

    invoke-direct {v6, p0, p4, v1, p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda0;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Z[I)V

    new-instance v7, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda2;

    invoke-direct {v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda2;-><init>()V

    move-object v2, p0

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v2 .. v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectTracksForType(ILandroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;Ljava/util/Comparator;)Landroid/util/Pair;

    move-result-object v2

    return-object v2
.end method

.method protected selectImageTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;
    .locals 7
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;",
            ")",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2917
    iget-object v0, p3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->audioOffloadMode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 2918
    const/4 v0, 0x0

    return-object v0

    .line 2920
    :cond_0
    const/4 v2, 0x4

    new-instance v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda8;

    invoke-direct {v5, p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda8;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V

    new-instance v6, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda9;

    invoke-direct {v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda9;-><init>()V

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectTracksForType(ILandroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;Ljava/util/Comparator;)Landroid/util/Pair;

    move-result-object v0

    return-object v0
.end method

.method protected selectOtherTrack(ILandroidx/media3/exoplayer/source/TrackGroupArray;[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    .locals 11
    .param p1, "trackType"    # I
    .param p2, "groups"    # Landroidx/media3/exoplayer/source/TrackGroupArray;
    .param p3, "formatSupport"    # [[I
    .param p4, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2947
    iget-object v0, p4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->audioOffloadMode:I

    const/4 v1, 0x2

    const/4 v2, 0x0

    if-ne v0, v1, :cond_0

    .line 2948
    return-object v2

    .line 2950
    :cond_0
    const/4 v0, 0x0

    .line 2951
    .local v0, "selectedGroup":Landroidx/media3/common/TrackGroup;
    const/4 v1, 0x0

    .line 2952
    .local v1, "selectedTrackIndex":I
    const/4 v3, 0x0

    .line 2953
    .local v3, "selectedTrackScore":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;
    const/4 v4, 0x0

    .local v4, "groupIndex":I
    :goto_0
    iget v5, p2, Landroidx/media3/exoplayer/source/TrackGroupArray;->length:I

    if-ge v4, v5, :cond_4

    .line 2954
    invoke-virtual {p2, v4}, Landroidx/media3/exoplayer/source/TrackGroupArray;->get(I)Landroidx/media3/common/TrackGroup;

    move-result-object v5

    .line 2955
    .local v5, "trackGroup":Landroidx/media3/common/TrackGroup;
    aget-object v6, p3, v4

    .line 2956
    .local v6, "trackFormatSupport":[I
    const/4 v7, 0x0

    .local v7, "trackIndex":I
    :goto_1
    iget v8, v5, Landroidx/media3/common/TrackGroup;->length:I

    if-ge v7, v8, :cond_3

    .line 2957
    aget v8, v6, v7

    iget-boolean v9, p4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->exceedRendererCapabilitiesIfNecessary:Z

    invoke-static {v8, v9}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->isSupported(IZ)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 2959
    invoke-virtual {v5, v7}, Landroidx/media3/common/TrackGroup;->getFormat(I)Landroidx/media3/common/Format;

    move-result-object v8

    .line 2960
    .local v8, "format":Landroidx/media3/common/Format;
    new-instance v9, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;

    aget v10, v6, v7

    invoke-direct {v9, v8, v10}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;-><init>(Landroidx/media3/common/Format;I)V

    .line 2961
    .local v9, "trackScore":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;
    if-eqz v3, :cond_1

    invoke-virtual {v9, v3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;->compareTo(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;)I

    move-result v10

    if-lez v10, :cond_2

    .line 2962
    :cond_1
    move-object v0, v5

    .line 2963
    move v1, v7

    .line 2964
    move-object v3, v9

    .line 2956
    .end local v8    # "format":Landroidx/media3/common/Format;
    .end local v9    # "trackScore":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$OtherTrackScore;
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 2953
    .end local v5    # "trackGroup":Landroidx/media3/common/TrackGroup;
    .end local v6    # "trackFormatSupport":[I
    .end local v7    # "trackIndex":I
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 2969
    .end local v4    # "groupIndex":I
    :cond_4
    if-nez v0, :cond_5

    .line 2970
    goto :goto_2

    .line 2971
    :cond_5
    new-instance v2, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    filled-new-array {v1}, [I

    move-result-object v4

    invoke-direct {v2, v0, v4}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;-><init>(Landroidx/media3/common/TrackGroup;[I)V

    .line 2969
    :goto_2
    return-object v2
.end method

.method protected selectTextTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Ljava/lang/String;)Landroid/util/Pair;
    .locals 7
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .param p4, "selectedAudioLanguage"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;",
            "Ljava/lang/String;",
            ")",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2884
    iget-object v0, p3, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->audioOffloadMode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 2885
    const/4 v0, 0x0

    return-object v0

    .line 2887
    :cond_0
    const/4 v2, 0x3

    new-instance v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda6;

    invoke-direct {v5, p3, p4}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda6;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Ljava/lang/String;)V

    new-instance v6, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda7;

    invoke-direct {v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda7;-><init>()V

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectTracksForType(ILandroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;Ljava/util/Comparator;)Landroid/util/Pair;

    move-result-object v0

    return-object v0
.end method

.method protected final selectTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/Timeline;)Landroid/util/Pair;
    .locals 17
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "rendererMixedMimeTypeAdaptationSupport"    # [I
    .param p4, "mediaPeriodId"    # Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;
    .param p5, "timeline"    # Landroidx/media3/common/Timeline;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I[I",
            "Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;",
            "Landroidx/media3/common/Timeline;",
            ")",
            "Landroid/util/Pair<",
            "[",
            "Landroidx/media3/exoplayer/RendererConfiguration;",
            "[",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2581
    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    iget-object v4, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v4

    .line 2582
    :try_start_0
    iget-object v0, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->parameters:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    .line 2583
    .local v0, "parameters":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    iget-boolean v5, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->constrainAudioChannelCountToDeviceCapabilities:Z

    if-eqz v5, :cond_0

    sget v5, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v6, 0x20

    if-lt v5, v6, :cond_0

    iget-object v5, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->spatializer:Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;

    if-eqz v5, :cond_0

    .line 2588
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v6

    invoke-static {v6}, Landroidx/media3/common/util/Assertions;->checkStateNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/os/Looper;

    invoke-virtual {v5, v1, v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$SpatializerWrapperV32;->ensureInitialized(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;Landroid/os/Looper;)V

    .line 2590
    :cond_0
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2591
    invoke-virtual/range {p1 .. p1}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererCount()I

    move-result v4

    .line 2592
    .local v4, "rendererCount":I
    nop

    .line 2593
    move-object/from16 v5, p3

    invoke-virtual {v1, v2, v3, v5, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectAllTracks(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;

    move-result-object v6

    .line 2599
    .local v6, "definitions":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    invoke-static {v2, v0, v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->applyTrackSelectionOverrides(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;Landroidx/media3/common/TrackSelectionParameters;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;)V

    .line 2600
    invoke-static {v2, v0, v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->applyLegacyRendererOverrides(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;)V

    .line 2603
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    const/4 v8, 0x0

    if-ge v7, v4, :cond_3

    .line 2604
    invoke-virtual {v2, v7}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v9

    .line 2605
    .local v9, "rendererType":I
    invoke-virtual {v0, v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->getRendererDisabled(I)Z

    move-result v10

    if-nez v10, :cond_1

    iget-object v10, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->disabledTrackTypes:Lcom/google/common/collect/ImmutableSet;

    .line 2606
    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v10, v11}, Lcom/google/common/collect/ImmutableSet;->contains(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 2607
    :cond_1
    aput-object v8, v6, v7

    .line 2603
    .end local v9    # "rendererType":I
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 2612
    .end local v7    # "i":I
    :cond_3
    iget-object v7, v1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->trackSelectionFactory:Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;

    .line 2614
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getBandwidthMeter()Landroidx/media3/exoplayer/upstream/BandwidthMeter;

    move-result-object v9

    .line 2613
    move-object/from16 v10, p4

    move-object/from16 v11, p5

    invoke-interface {v7, v6, v9, v10, v11}, Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Factory;->createTrackSelections([Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;Landroidx/media3/exoplayer/upstream/BandwidthMeter;Landroidx/media3/exoplayer/source/MediaSource$MediaPeriodId;Landroidx/media3/common/Timeline;)[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;

    move-result-object v7

    .line 2619
    .local v7, "rendererTrackSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    new-array v9, v4, [Landroidx/media3/exoplayer/RendererConfiguration;

    .line 2620
    .local v9, "rendererConfigurations":[Landroidx/media3/exoplayer/RendererConfiguration;
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    if-ge v12, v4, :cond_9

    .line 2621
    invoke-virtual {v2, v12}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v13

    .line 2622
    .local v13, "rendererType":I
    nop

    .line 2623
    invoke-virtual {v0, v12}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->getRendererDisabled(I)Z

    move-result v14

    const/16 v16, 0x1

    if-nez v14, :cond_5

    iget-object v14, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->disabledTrackTypes:Lcom/google/common/collect/ImmutableSet;

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v14, v8}, Lcom/google/common/collect/ImmutableSet;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    goto :goto_2

    :cond_4
    const/4 v8, 0x0

    goto :goto_3

    :cond_5
    :goto_2
    move/from16 v8, v16

    .line 2624
    .local v8, "forceRendererDisabled":Z
    :goto_3
    if-nez v8, :cond_7

    .line 2626
    invoke-virtual {v2, v12}, Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;->getRendererType(I)I

    move-result v14

    const/4 v15, -0x2

    if-eq v14, v15, :cond_6

    aget-object v14, v7, v12

    if-eqz v14, :cond_7

    :cond_6
    move/from16 v15, v16

    goto :goto_4

    :cond_7
    const/4 v15, 0x0

    :goto_4
    move v14, v15

    .line 2628
    .local v14, "rendererEnabled":Z
    if-eqz v14, :cond_8

    sget-object v15, Landroidx/media3/exoplayer/RendererConfiguration;->DEFAULT:Landroidx/media3/exoplayer/RendererConfiguration;

    goto :goto_5

    :cond_8
    const/4 v15, 0x0

    :goto_5
    aput-object v15, v9, v12

    .line 2620
    .end local v8    # "forceRendererDisabled":Z
    .end local v13    # "rendererType":I
    .end local v14    # "rendererEnabled":Z
    add-int/lit8 v12, v12, 0x1

    const/4 v8, 0x0

    goto :goto_1

    .line 2632
    .end local v12    # "i":I
    :cond_9
    iget-boolean v8, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->tunnelingEnabled:Z

    if-eqz v8, :cond_a

    .line 2633
    invoke-static {v2, v3, v9, v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->maybeConfigureRenderersForTunneling(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)V

    .line 2638
    :cond_a
    iget-object v8, v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget v8, v8, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->audioOffloadMode:I

    if-eqz v8, :cond_b

    .line 2639
    invoke-static {v0, v2, v3, v9, v7}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->maybeConfigureRendererForOffload(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[Landroidx/media3/exoplayer/RendererConfiguration;[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;)V

    .line 2647
    :cond_b
    invoke-static {v9, v7}, Landroid/util/Pair;->create(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;

    move-result-object v8

    return-object v8

    .line 2590
    .end local v0    # "parameters":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .end local v4    # "rendererCount":I
    .end local v6    # "definitions":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;
    .end local v7    # "rendererTrackSelections":[Landroidx/media3/exoplayer/trackselection/ExoTrackSelection;
    .end local v9    # "rendererConfigurations":[Landroidx/media3/exoplayer/RendererConfiguration;
    :catchall_0
    move-exception v0

    move-object/from16 v5, p3

    move-object/from16 v10, p4

    move-object/from16 v11, p5

    :goto_6
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v0

    :catchall_1
    move-exception v0

    goto :goto_6
.end method

.method protected selectVideoTrack(Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[I[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)Landroid/util/Pair;
    .locals 7
    .param p1, "mappedTrackInfo"    # Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;
    .param p2, "rendererFormatSupports"    # [[[I
    .param p3, "mixedMimeTypeSupports"    # [I
    .param p4, "params"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;",
            "[[[I[I",
            "Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;",
            ")",
            "Landroid/util/Pair<",
            "Landroidx/media3/exoplayer/trackselection/ExoTrackSelection$Definition;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/media3/exoplayer/ExoPlaybackException;
        }
    .end annotation

    .line 2765
    iget-object v0, p4, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;->audioOffloadPreferences:Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;

    iget v0, v0, Landroidx/media3/common/TrackSelectionParameters$AudioOffloadPreferences;->audioOffloadMode:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 2766
    const/4 v0, 0x0

    return-object v0

    .line 2768
    :cond_0
    const/4 v2, 0x2

    new-instance v5, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda3;

    invoke-direct {v5, p4, p3}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda3;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;[I)V

    new-instance v6, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda4;

    invoke-direct {v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$$ExternalSyntheticLambda4;-><init>()V

    move-object v1, p0

    move-object v3, p1

    move-object v4, p2

    invoke-direct/range {v1 .. v6}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->selectTracksForType(ILandroidx/media3/exoplayer/trackselection/MappingTrackSelector$MappedTrackInfo;[[[ILandroidx/media3/exoplayer/trackselection/DefaultTrackSelector$TrackInfo$Factory;Ljava/util/Comparator;)Landroid/util/Pair;

    move-result-object v0

    return-object v0
.end method

.method public setAudioAttributes(Landroidx/media3/common/AudioAttributes;)V
    .locals 2
    .param p1, "audioAttributes"    # Landroidx/media3/common/AudioAttributes;

    .line 2503
    iget-object v0, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->lock:Ljava/lang/Object;

    monitor-enter v0

    .line 2504
    :try_start_0
    iget-object v1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->audioAttributes:Landroidx/media3/common/AudioAttributes;

    invoke-virtual {v1, p1}, Landroidx/media3/common/AudioAttributes;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    .line 2505
    .local v1, "audioAttributesChanged":Z
    :goto_0
    iput-object p1, p0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->audioAttributes:Landroidx/media3/common/AudioAttributes;

    .line 2506
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2507
    if-eqz v1, :cond_1

    .line 2508
    invoke-direct {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->maybeInvalidateForAudioChannelCountConstraints()V

    .line 2510
    :cond_1
    return-void

    .line 2506
    .end local v1    # "audioAttributesChanged":Z
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public setParameters(Landroidx/media3/common/TrackSelectionParameters;)V
    .locals 3
    .param p1, "parameters"    # Landroidx/media3/common/TrackSelectionParameters;

    .line 2492
    instance-of v0, p1, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    if-eqz v0, :cond_0

    .line 2493
    move-object v0, p1

    check-cast v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->setParametersInternal(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V

    .line 2496
    :cond_0
    new-instance v0, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    invoke-virtual {p0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->getParameters()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;-><init>(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$1;)V

    invoke-virtual {v0, p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->set(Landroidx/media3/common/TrackSelectionParameters;)Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->build()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    .line 2497
    .local v0, "mergedParameters":Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;
    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->setParametersInternal(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V

    .line 2498
    return-void
.end method

.method public setParameters(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;)V
    .locals 1
    .param p1, "parametersBuilder"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;

    .line 2527
    invoke-virtual {p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters$Builder;->build()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->setParametersInternal(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V

    .line 2528
    return-void
.end method

.method public setParameters(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ParametersBuilder;)V
    .locals 1
    .param p1, "parametersBuilder"    # Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ParametersBuilder;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 2518
    invoke-virtual {p1}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$ParametersBuilder;->build()Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector;->setParametersInternal(Landroidx/media3/exoplayer/trackselection/DefaultTrackSelector$Parameters;)V

    .line 2519
    return-void
.end method
