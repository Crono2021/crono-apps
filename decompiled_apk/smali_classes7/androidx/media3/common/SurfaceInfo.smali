.class public final Landroidx/media3/common/SurfaceInfo;
.super Ljava/lang/Object;
.source "SurfaceInfo.java"


# instance fields
.field public final height:I

.field public final orientationDegrees:I

.field public final surface:Landroid/view/Surface;

.field public final width:I


# direct methods
.method public constructor <init>(Landroid/view/Surface;II)V
    .locals 1
    .param p1, "surface"    # Landroid/view/Surface;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .line 46
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Landroidx/media3/common/SurfaceInfo;-><init>(Landroid/view/Surface;III)V

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/view/Surface;III)V
    .locals 2
    .param p1, "surface"    # Landroid/view/Surface;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "orientationDegrees"    # I

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    if-eqz p4, :cond_1

    const/16 v0, 0x5a

    if-eq p4, v0, :cond_1

    const/16 v0, 0xb4

    if-eq p4, v0, :cond_1

    const/16 v0, 0x10e

    if-ne p4, v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    const-string/jumbo v1, "orientationDegrees must be 0, 90, 180, or 270"

    invoke-static {v0, v1}, Landroidx/media3/common/util/Assertions;->checkArgument(ZLjava/lang/Object;)V

    .line 57
    iput-object p1, p0, Landroidx/media3/common/SurfaceInfo;->surface:Landroid/view/Surface;

    .line 58
    iput p2, p0, Landroidx/media3/common/SurfaceInfo;->width:I

    .line 59
    iput p3, p0, Landroidx/media3/common/SurfaceInfo;->height:I

    .line 60
    iput p4, p0, Landroidx/media3/common/SurfaceInfo;->orientationDegrees:I

    .line 61
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .line 65
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 66
    return v0

    .line 68
    :cond_0
    instance-of v1, p1, Landroidx/media3/common/SurfaceInfo;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    .line 69
    return v2

    .line 71
    :cond_1
    move-object v1, p1

    check-cast v1, Landroidx/media3/common/SurfaceInfo;

    .line 72
    .local v1, "that":Landroidx/media3/common/SurfaceInfo;
    iget v3, p0, Landroidx/media3/common/SurfaceInfo;->width:I

    iget v4, v1, Landroidx/media3/common/SurfaceInfo;->width:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/common/SurfaceInfo;->height:I

    iget v4, v1, Landroidx/media3/common/SurfaceInfo;->height:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/common/SurfaceInfo;->orientationDegrees:I

    iget v4, v1, Landroidx/media3/common/SurfaceInfo;->orientationDegrees:I

    if-ne v3, v4, :cond_2

    iget-object v3, p0, Landroidx/media3/common/SurfaceInfo;->surface:Landroid/view/Surface;

    iget-object v4, v1, Landroidx/media3/common/SurfaceInfo;->surface:Landroid/view/Surface;

    .line 75
    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    goto :goto_0

    :cond_2
    move v0, v2

    .line 72
    :goto_0
    return v0
.end method

.method public hashCode()I
    .locals 3

    .line 80
    iget-object v0, p0, Landroidx/media3/common/SurfaceInfo;->surface:Landroid/view/Surface;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 81
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/common/SurfaceInfo;->width:I

    add-int/2addr v1, v2

    .line 82
    .end local v0    # "result":I
    .local v1, "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget v2, p0, Landroidx/media3/common/SurfaceInfo;->height:I

    add-int/2addr v0, v2

    .line 83
    .end local v1    # "result":I
    .restart local v0    # "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/common/SurfaceInfo;->orientationDegrees:I

    add-int/2addr v1, v2

    .line 84
    .end local v0    # "result":I
    .restart local v1    # "result":I
    return v1
.end method
