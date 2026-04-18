.class final Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer$Api26;
.super Ljava/lang/Object;
.source "MediaCodecVideoRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/exoplayer/video/MediaCodecVideoRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "Api26"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 599
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static doesDisplaySupportDolbyVision(Landroid/content/Context;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .line 602
    const/4 v0, 0x0

    .line 603
    .local v0, "supportsDolbyVision":Z
    nop

    .line 604
    const-string v1, "display"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/hardware/display/DisplayManager;

    .line 606
    .local v1, "displayManager":Landroid/hardware/display/DisplayManager;
    const/4 v2, 0x0

    if-eqz v1, :cond_0

    invoke-virtual {v1, v2}, Landroid/hardware/display/DisplayManager;->getDisplay(I)Landroid/view/Display;

    move-result-object v3

    goto :goto_0

    :cond_0
    const/4 v3, 0x0

    .line 607
    .local v3, "display":Landroid/view/Display;
    :goto_0
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Landroid/view/Display;->isHdr()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 608
    invoke-virtual {v3}, Landroid/view/Display;->getHdrCapabilities()Landroid/view/Display$HdrCapabilities;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/Display$HdrCapabilities;->getSupportedHdrTypes()[I

    move-result-object v4

    .line 609
    .local v4, "supportedHdrTypes":[I
    array-length v5, v4

    :goto_1
    if-ge v2, v5, :cond_2

    aget v6, v4, v2

    .line 610
    .local v6, "hdrType":I
    const/4 v7, 0x1

    if-ne v6, v7, :cond_1

    .line 611
    const/4 v0, 0x1

    .line 612
    goto :goto_2

    .line 609
    .end local v6    # "hdrType":I
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 616
    .end local v4    # "supportedHdrTypes":[I
    :cond_2
    :goto_2
    return v0
.end method
