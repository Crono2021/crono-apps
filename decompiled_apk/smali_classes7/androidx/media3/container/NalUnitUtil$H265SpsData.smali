.class public final Landroidx/media3/container/NalUnitUtil$H265SpsData;
.super Ljava/lang/Object;
.source "NalUnitUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/media3/container/NalUnitUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "H265SpsData"
.end annotation


# instance fields
.field public final bitDepthChromaMinus8:I

.field public final bitDepthLumaMinus8:I

.field public final chromaFormatIdc:I

.field public final colorRange:I

.field public final colorSpace:I

.field public final colorTransfer:I

.field public final constraintBytes:[I

.field public final generalLevelIdc:I

.field public final generalProfileCompatibilityFlags:I

.field public final generalProfileIdc:I

.field public final generalProfileSpace:I

.field public final generalTierFlag:Z

.field public final height:I

.field public final pixelWidthHeightRatio:F

.field public final seqParameterSetId:I

.field public final width:I


# direct methods
.method public constructor <init>(IZIIIII[IIIIIFIII)V
    .locals 16
    .param p1, "generalProfileSpace"    # I
    .param p2, "generalTierFlag"    # Z
    .param p3, "generalProfileIdc"    # I
    .param p4, "generalProfileCompatibilityFlags"    # I
    .param p5, "chromaFormatIdc"    # I
    .param p6, "bitDepthLumaMinus8"    # I
    .param p7, "bitDepthChromaMinus8"    # I
    .param p8, "constraintBytes"    # [I
    .param p9, "generalLevelIdc"    # I
    .param p10, "seqParameterSetId"    # I
    .param p11, "width"    # I
    .param p12, "height"    # I
    .param p13, "pixelWidthHeightRatio"    # F
    .param p14, "colorSpace"    # I
    .param p15, "colorRange"    # I
    .param p16, "colorTransfer"    # I

    .line 162
    move-object/from16 v0, p0

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 163
    move/from16 v1, p1

    iput v1, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->generalProfileSpace:I

    .line 164
    move/from16 v2, p2

    iput-boolean v2, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->generalTierFlag:Z

    .line 165
    move/from16 v3, p3

    iput v3, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->generalProfileIdc:I

    .line 166
    move/from16 v4, p4

    iput v4, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->generalProfileCompatibilityFlags:I

    .line 167
    move/from16 v5, p5

    iput v5, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->chromaFormatIdc:I

    .line 168
    move/from16 v6, p6

    iput v6, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->bitDepthLumaMinus8:I

    .line 169
    move/from16 v7, p7

    iput v7, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->bitDepthChromaMinus8:I

    .line 170
    move-object/from16 v8, p8

    iput-object v8, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->constraintBytes:[I

    .line 171
    move/from16 v9, p9

    iput v9, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->generalLevelIdc:I

    .line 172
    move/from16 v10, p10

    iput v10, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->seqParameterSetId:I

    .line 173
    move/from16 v11, p11

    iput v11, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->width:I

    .line 174
    move/from16 v12, p12

    iput v12, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->height:I

    .line 175
    move/from16 v13, p13

    iput v13, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->pixelWidthHeightRatio:F

    .line 176
    move/from16 v14, p14

    iput v14, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->colorSpace:I

    .line 177
    move/from16 v15, p15

    iput v15, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->colorRange:I

    .line 178
    move/from16 v1, p16

    iput v1, v0, Landroidx/media3/container/NalUnitUtil$H265SpsData;->colorTransfer:I

    .line 179
    return-void
.end method
