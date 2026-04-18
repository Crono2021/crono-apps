.class public final Landroidx/media3/common/FrameInfo$Builder;
.super Ljava/lang/Object;
.source "FrameInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/common/FrameInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation


# instance fields
.field private colorInfo:Landroidx/media3/common/ColorInfo;

.field private height:I

.field private offsetToAddUs:J

.field private pixelWidthHeightRatio:F

.field private width:I


# direct methods
.method public constructor <init>(Landroidx/media3/common/ColorInfo;II)V
    .locals 1
    .param p1, "colorInfo"    # Landroidx/media3/common/ColorInfo;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Landroidx/media3/common/FrameInfo$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    .line 45
    iput p2, p0, Landroidx/media3/common/FrameInfo$Builder;->width:I

    .line 46
    iput p3, p0, Landroidx/media3/common/FrameInfo$Builder;->height:I

    .line 47
    const/high16 v0, 0x3f800000    # 1.0f

    iput v0, p0, Landroidx/media3/common/FrameInfo$Builder;->pixelWidthHeightRatio:F

    .line 48
    return-void
.end method

.method public constructor <init>(Landroidx/media3/common/FrameInfo;)V
    .locals 2
    .param p1, "frameInfo"    # Landroidx/media3/common/FrameInfo;

    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    iget-object v0, p1, Landroidx/media3/common/FrameInfo;->colorInfo:Landroidx/media3/common/ColorInfo;

    iput-object v0, p0, Landroidx/media3/common/FrameInfo$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    .line 53
    iget v0, p1, Landroidx/media3/common/FrameInfo;->width:I

    iput v0, p0, Landroidx/media3/common/FrameInfo$Builder;->width:I

    .line 54
    iget v0, p1, Landroidx/media3/common/FrameInfo;->height:I

    iput v0, p0, Landroidx/media3/common/FrameInfo$Builder;->height:I

    .line 55
    iget v0, p1, Landroidx/media3/common/FrameInfo;->pixelWidthHeightRatio:F

    iput v0, p0, Landroidx/media3/common/FrameInfo$Builder;->pixelWidthHeightRatio:F

    .line 56
    iget-wide v0, p1, Landroidx/media3/common/FrameInfo;->offsetToAddUs:J

    iput-wide v0, p0, Landroidx/media3/common/FrameInfo$Builder;->offsetToAddUs:J

    .line 57
    return-void
.end method


# virtual methods
.method public build()Landroidx/media3/common/FrameInfo;
    .locals 9

    .line 105
    new-instance v8, Landroidx/media3/common/FrameInfo;

    iget-object v1, p0, Landroidx/media3/common/FrameInfo$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    iget v2, p0, Landroidx/media3/common/FrameInfo$Builder;->width:I

    iget v3, p0, Landroidx/media3/common/FrameInfo$Builder;->height:I

    iget v4, p0, Landroidx/media3/common/FrameInfo$Builder;->pixelWidthHeightRatio:F

    iget-wide v5, p0, Landroidx/media3/common/FrameInfo$Builder;->offsetToAddUs:J

    const/4 v7, 0x0

    move-object v0, v8

    invoke-direct/range {v0 .. v7}, Landroidx/media3/common/FrameInfo;-><init>(Landroidx/media3/common/ColorInfo;IIFJLandroidx/media3/common/FrameInfo$1;)V

    return-object v8
.end method

.method public setColorInfo(Landroidx/media3/common/ColorInfo;)Landroidx/media3/common/FrameInfo$Builder;
    .locals 0
    .param p1, "colorInfo"    # Landroidx/media3/common/ColorInfo;

    .line 62
    iput-object p1, p0, Landroidx/media3/common/FrameInfo$Builder;->colorInfo:Landroidx/media3/common/ColorInfo;

    .line 63
    return-object p0
.end method

.method public setHeight(I)Landroidx/media3/common/FrameInfo$Builder;
    .locals 0
    .param p1, "height"    # I

    .line 76
    iput p1, p0, Landroidx/media3/common/FrameInfo$Builder;->height:I

    .line 77
    return-object p0
.end method

.method public setOffsetToAddUs(J)Landroidx/media3/common/FrameInfo$Builder;
    .locals 0
    .param p1, "offsetToAddUs"    # J

    .line 99
    iput-wide p1, p0, Landroidx/media3/common/FrameInfo$Builder;->offsetToAddUs:J

    .line 100
    return-object p0
.end method

.method public setPixelWidthHeightRatio(F)Landroidx/media3/common/FrameInfo$Builder;
    .locals 0
    .param p1, "pixelWidthHeightRatio"    # F

    .line 87
    iput p1, p0, Landroidx/media3/common/FrameInfo$Builder;->pixelWidthHeightRatio:F

    .line 88
    return-object p0
.end method

.method public setWidth(I)Landroidx/media3/common/FrameInfo$Builder;
    .locals 0
    .param p1, "width"    # I

    .line 69
    iput p1, p0, Landroidx/media3/common/FrameInfo$Builder;->width:I

    .line 70
    return-object p0
.end method
