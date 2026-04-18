.class public final Landroidx/media3/common/ColorInfo;
.super Ljava/lang/Object;
.source "ColorInfo.java"

# interfaces
.implements Landroidx/media3/common/Bundleable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/ColorInfo$Builder;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroidx/media3/common/Bundleable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/media3/common/Bundleable$Creator<",
            "Landroidx/media3/common/ColorInfo;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field private static final FIELD_CHROMA_BITDEPTH:Ljava/lang/String;

.field private static final FIELD_COLOR_RANGE:Ljava/lang/String;

.field private static final FIELD_COLOR_SPACE:Ljava/lang/String;

.field private static final FIELD_COLOR_TRANSFER:Ljava/lang/String;

.field private static final FIELD_HDR_STATIC_INFO:Ljava/lang/String;

.field private static final FIELD_LUMA_BITDEPTH:Ljava/lang/String;

.field public static final SDR_BT709_LIMITED:Landroidx/media3/common/ColorInfo;

.field public static final SRGB_BT709_FULL:Landroidx/media3/common/ColorInfo;


# instance fields
.field public final chromaBitdepth:I

.field public final colorRange:I

.field public final colorSpace:I

.field public final colorTransfer:I

.field private hashCode:I

.field public final hdrStaticInfo:[B

.field public final lumaBitdepth:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 158
    new-instance v0, Landroidx/media3/common/ColorInfo$Builder;

    invoke-direct {v0}, Landroidx/media3/common/ColorInfo$Builder;-><init>()V

    .line 160
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroidx/media3/common/ColorInfo$Builder;->setColorSpace(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 161
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroidx/media3/common/ColorInfo$Builder;->setColorRange(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 162
    const/4 v3, 0x3

    invoke-virtual {v0, v3}, Landroidx/media3/common/ColorInfo$Builder;->setColorTransfer(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 163
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->SDR_BT709_LIMITED:Landroidx/media3/common/ColorInfo;

    .line 169
    new-instance v0, Landroidx/media3/common/ColorInfo$Builder;

    invoke-direct {v0}, Landroidx/media3/common/ColorInfo$Builder;-><init>()V

    .line 171
    invoke-virtual {v0, v1}, Landroidx/media3/common/ColorInfo$Builder;->setColorSpace(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 172
    invoke-virtual {v0, v1}, Landroidx/media3/common/ColorInfo$Builder;->setColorRange(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 173
    invoke-virtual {v0, v2}, Landroidx/media3/common/ColorInfo$Builder;->setColorTransfer(I)Landroidx/media3/common/ColorInfo$Builder;

    move-result-object v0

    .line 174
    invoke-virtual {v0}, Landroidx/media3/common/ColorInfo$Builder;->build()Landroidx/media3/common/ColorInfo;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->SRGB_BT709_FULL:Landroidx/media3/common/ColorInfo;

    .line 466
    const/4 v0, 0x0

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_SPACE:Ljava/lang/String;

    .line 467
    invoke-static {v1}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_RANGE:Ljava/lang/String;

    .line 468
    invoke-static {v2}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_TRANSFER:Ljava/lang/String;

    .line 469
    invoke-static {v3}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_HDR_STATIC_INFO:Ljava/lang/String;

    .line 470
    const/4 v0, 0x4

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_LUMA_BITDEPTH:Ljava/lang/String;

    .line 471
    const/4 v0, 0x5

    invoke-static {v0}, Landroidx/media3/common/util/Util;->intToStringMaxRadix(I)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Landroidx/media3/common/ColorInfo;->FIELD_CHROMA_BITDEPTH:Ljava/lang/String;

    .line 490
    new-instance v0, Landroidx/media3/common/ColorInfo$$ExternalSyntheticLambda0;

    invoke-direct {v0}, Landroidx/media3/common/ColorInfo$$ExternalSyntheticLambda0;-><init>()V

    sput-object v0, Landroidx/media3/common/ColorInfo;->CREATOR:Landroidx/media3/common/Bundleable$Creator;

    return-void
.end method

.method private constructor <init>(III[BII)V
    .locals 0
    .param p1, "colorSpace"    # I
    .param p2, "colorRange"    # I
    .param p3, "colorTransfer"    # I
    .param p4, "hdrStaticInfo"    # [B
    .param p5, "lumaBitdepth"    # I
    .param p6, "chromaBitdepth"    # I

    .line 294
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 295
    iput p1, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    .line 296
    iput p2, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    .line 297
    iput p3, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    .line 298
    iput-object p4, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    .line 299
    iput p5, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    .line 300
    iput p6, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    .line 301
    return-void
.end method

.method synthetic constructor <init>(III[BIILandroidx/media3/common/ColorInfo$1;)V
    .locals 0
    .param p1, "x0"    # I
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # [B
    .param p5, "x4"    # I
    .param p6, "x5"    # I
    .param p7, "x6"    # Landroidx/media3/common/ColorInfo$1;

    .line 34
    invoke-direct/range {p0 .. p6}, Landroidx/media3/common/ColorInfo;-><init>(III[BII)V

    return-void
.end method

.method private static chromaBitdepthToString(I)Ljava/lang/String;
    .locals 2
    .param p0, "val"    # I

    .line 409
    const/4 v0, -0x1

    if-eq p0, v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bit Chroma"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const-string v0, "NA"

    :goto_0
    return-object v0
.end method

.method private static colorRangeToString(I)Ljava/lang/String;
    .locals 1
    .param p0, "colorRange"    # I

    .line 452
    packed-switch p0, :pswitch_data_0

    .line 460
    :pswitch_0
    const-string v0, "Undefined color range"

    return-object v0

    .line 456
    :pswitch_1
    const-string v0, "Limited range"

    return-object v0

    .line 458
    :pswitch_2
    const-string v0, "Full range"

    return-object v0

    .line 454
    :pswitch_3
    const-string v0, "Unset color range"

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private static colorSpaceToString(I)Ljava/lang/String;
    .locals 1
    .param p0, "colorSpace"    # I

    .line 414
    sparse-switch p0, :sswitch_data_0

    .line 424
    const-string v0, "Undefined color space"

    return-object v0

    .line 422
    :sswitch_0
    const-string v0, "BT2020"

    return-object v0

    .line 418
    :sswitch_1
    const-string v0, "BT601"

    return-object v0

    .line 420
    :sswitch_2
    const-string v0, "BT709"

    return-object v0

    .line 416
    :sswitch_3
    const-string v0, "Unset color space"

    return-object v0

    :sswitch_data_0
    .sparse-switch
        -0x1 -> :sswitch_3
        0x1 -> :sswitch_2
        0x2 -> :sswitch_1
        0x6 -> :sswitch_0
    .end sparse-switch
.end method

.method private static colorTransferToString(I)Ljava/lang/String;
    .locals 1
    .param p0, "colorTransfer"    # I

    .line 430
    packed-switch p0, :pswitch_data_0

    .line 446
    :pswitch_0
    const-string v0, "Undefined color transfer"

    return-object v0

    .line 440
    :pswitch_1
    const-string v0, "Gamma 2.2"

    return-object v0

    .line 444
    :pswitch_2
    const-string v0, "HLG"

    return-object v0

    .line 442
    :pswitch_3
    const-string v0, "ST2084 PQ"

    return-object v0

    .line 436
    :pswitch_4
    const-string v0, "SDR SMPTE 170M"

    return-object v0

    .line 438
    :pswitch_5
    const-string/jumbo v0, "sRGB"

    return-object v0

    .line 434
    :pswitch_6
    const-string v0, "Linear"

    return-object v0

    .line 432
    :pswitch_7
    const-string v0, "Unset color transfer"

    return-object v0

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_7
        :pswitch_0
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static fromBundle(Landroid/os/Bundle;)Landroidx/media3/common/ColorInfo;
    .locals 9
    .param p0, "bundle"    # Landroid/os/Bundle;

    .line 494
    new-instance v7, Landroidx/media3/common/ColorInfo;

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_SPACE:Ljava/lang/String;

    .line 495
    const/4 v1, -0x1

    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_RANGE:Ljava/lang/String;

    .line 496
    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_TRANSFER:Ljava/lang/String;

    .line 497
    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v4

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_HDR_STATIC_INFO:Ljava/lang/String;

    .line 498
    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getByteArray(Ljava/lang/String;)[B

    move-result-object v5

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_LUMA_BITDEPTH:Ljava/lang/String;

    .line 499
    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v6

    sget-object v0, Landroidx/media3/common/ColorInfo;->FIELD_CHROMA_BITDEPTH:Ljava/lang/String;

    .line 500
    invoke-virtual {p0, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v8

    move-object v0, v7

    move v1, v2

    move v2, v3

    move v3, v4

    move-object v4, v5

    move v5, v6

    move v6, v8

    invoke-direct/range {v0 .. v6}, Landroidx/media3/common/ColorInfo;-><init>(III[BII)V

    .line 494
    return-object v7
.end method

.method public static isEquivalentToAssumedSdrDefault(Landroidx/media3/common/ColorInfo;)Z
    .locals 4
    .param p0, "colorInfo"    # Landroidx/media3/common/ColorInfo;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/EnsuresNonNullIf;
        expression = {
            "#1"
        }
        result = false
    .end annotation

    .line 189
    const/4 v0, 0x1

    if-nez p0, :cond_0

    .line 190
    return v0

    .line 192
    :cond_0
    iget v1, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    const/4 v2, 0x2

    const/4 v3, -0x1

    if-eq v1, v3, :cond_1

    if-eq v1, v0, :cond_1

    if-ne v1, v2, :cond_6

    :cond_1
    iget v1, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    if-eq v1, v3, :cond_2

    if-ne v1, v2, :cond_6

    :cond_2
    iget v1, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    if-eq v1, v3, :cond_3

    const/4 v2, 0x3

    if-ne v1, v2, :cond_6

    :cond_3
    iget-object v1, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    if-nez v1, :cond_6

    iget v1, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    const/16 v2, 0x8

    if-eq v1, v3, :cond_4

    if-ne v1, v2, :cond_6

    :cond_4
    iget v1, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    if-eq v1, v3, :cond_5

    if-ne v1, v2, :cond_6

    :cond_5
    goto :goto_0

    :cond_6
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static isTransferHdr(Landroidx/media3/common/ColorInfo;)Z
    .locals 2
    .param p0, "colorInfo"    # Landroidx/media3/common/ColorInfo;

    .line 259
    if-eqz p0, :cond_1

    iget v0, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    const/4 v1, 0x7

    if-eq v0, v1, :cond_0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public static isoColorPrimariesToColorSpace(I)I
    .locals 1
    .param p0, "isoColorPrimaries"    # I
    .annotation runtime Lorg/checkerframework/dataflow/qual/Pure;
    .end annotation

    .line 211
    packed-switch p0, :pswitch_data_0

    .line 222
    :pswitch_0
    const/4 v0, -0x1

    return v0

    .line 220
    :pswitch_1
    const/4 v0, 0x6

    return v0

    .line 218
    :pswitch_2
    const/4 v0, 0x2

    return v0

    .line 213
    :pswitch_3
    const/4 v0, 0x1

    return v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public static isoTransferCharacteristicsToColorTransfer(I)I
    .locals 1
    .param p0, "isoTransferCharacteristics"    # I
    .annotation runtime Lorg/checkerframework/dataflow/qual/Pure;
    .end annotation

    .line 234
    sparse-switch p0, :sswitch_data_0

    .line 248
    const/4 v0, -0x1

    return v0

    .line 246
    :sswitch_0
    const/4 v0, 0x7

    return v0

    .line 244
    :sswitch_1
    const/4 v0, 0x6

    return v0

    .line 242
    :sswitch_2
    const/4 v0, 0x2

    return v0

    .line 240
    :sswitch_3
    const/16 v0, 0xa

    return v0

    .line 238
    :sswitch_4
    const/4 v0, 0x3

    return v0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_4
        0x4 -> :sswitch_3
        0x6 -> :sswitch_4
        0x7 -> :sswitch_4
        0xd -> :sswitch_2
        0x10 -> :sswitch_1
        0x12 -> :sswitch_0
    .end sparse-switch
.end method

.method private static lumaBitdepthToString(I)Ljava/lang/String;
    .locals 2
    .param p0, "val"    # I

    .line 405
    const/4 v0, -0x1

    if-eq p0, v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "bit Luma"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const-string v0, "NA"

    :goto_0
    return-object v0
.end method


# virtual methods
.method public buildUpon()Landroidx/media3/common/ColorInfo$Builder;
    .locals 2

    .line 305
    new-instance v0, Landroidx/media3/common/ColorInfo$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Landroidx/media3/common/ColorInfo$Builder;-><init>(Landroidx/media3/common/ColorInfo;Landroidx/media3/common/ColorInfo$1;)V

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .line 357
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 358
    return v0

    .line 360
    :cond_0
    const/4 v1, 0x0

    if-eqz p1, :cond_3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_1

    goto :goto_1

    .line 363
    :cond_1
    move-object v2, p1

    check-cast v2, Landroidx/media3/common/ColorInfo;

    .line 364
    .local v2, "other":Landroidx/media3/common/ColorInfo;
    iget v3, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    iget v4, v2, Landroidx/media3/common/ColorInfo;->colorSpace:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    iget v4, v2, Landroidx/media3/common/ColorInfo;->colorRange:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    iget v4, v2, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    if-ne v3, v4, :cond_2

    iget-object v3, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    iget-object v4, v2, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    .line 367
    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    iget v4, v2, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    if-ne v3, v4, :cond_2

    iget v3, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    iget v4, v2, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    if-ne v3, v4, :cond_2

    goto :goto_0

    :cond_2
    move v0, v1

    .line 364
    :goto_0
    return v0

    .line 361
    .end local v2    # "other":Landroidx/media3/common/ColorInfo;
    :cond_3
    :goto_1
    return v1
.end method

.method public hashCode()I
    .locals 3

    .line 374
    iget v0, p0, Landroidx/media3/common/ColorInfo;->hashCode:I

    if-nez v0, :cond_0

    .line 375
    const/16 v0, 0x11

    .line 376
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    add-int/2addr v1, v2

    .line 377
    .end local v0    # "result":I
    .local v1, "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    add-int/2addr v0, v2

    .line 378
    .end local v1    # "result":I
    .restart local v0    # "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    add-int/2addr v1, v2

    .line 379
    .end local v0    # "result":I
    .restart local v1    # "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget-object v2, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    invoke-static {v2}, Ljava/util/Arrays;->hashCode([B)I

    move-result v2

    add-int/2addr v0, v2

    .line 380
    .end local v1    # "result":I
    .restart local v0    # "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    add-int/2addr v1, v2

    .line 381
    .end local v0    # "result":I
    .restart local v1    # "result":I
    mul-int/lit8 v0, v1, 0x1f

    iget v2, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    add-int/2addr v0, v2

    .line 382
    .end local v1    # "result":I
    .restart local v0    # "result":I
    iput v0, p0, Landroidx/media3/common/ColorInfo;->hashCode:I

    .line 384
    .end local v0    # "result":I
    :cond_0
    iget v0, p0, Landroidx/media3/common/ColorInfo;->hashCode:I

    return v0
.end method

.method public isBitdepthValid()Z
    .locals 2

    .line 323
    iget v0, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget v0, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isDataSpaceValid()Z
    .locals 2

    .line 332
    iget v0, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    iget v0, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    if-eq v0, v1, :cond_0

    iget v0, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isValid()Z
    .locals 1

    .line 314
    invoke-virtual {p0}, Landroidx/media3/common/ColorInfo;->isBitdepthValid()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Landroidx/media3/common/ColorInfo;->isDataSpaceValid()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public toBundle()Landroid/os/Bundle;
    .locals 3

    .line 475
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 476
    .local v0, "bundle":Landroid/os/Bundle;
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_SPACE:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 477
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_RANGE:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 478
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_COLOR_TRANSFER:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 479
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_HDR_STATIC_INFO:Ljava/lang/String;

    iget-object v2, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putByteArray(Ljava/lang/String;[B)V

    .line 480
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_LUMA_BITDEPTH:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 481
    sget-object v1, Landroidx/media3/common/ColorInfo;->FIELD_CHROMA_BITDEPTH:Ljava/lang/String;

    iget v2, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 482
    return-object v0
.end method

.method public toLogString()Ljava/lang/String;
    .locals 4

    .line 344
    invoke-virtual {p0}, Landroidx/media3/common/ColorInfo;->isDataSpaceValid()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 345
    iget v0, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    .line 347
    invoke-static {v0}, Landroidx/media3/common/ColorInfo;->colorSpaceToString(I)Ljava/lang/String;

    move-result-object v0

    iget v1, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    .line 348
    invoke-static {v1}, Landroidx/media3/common/ColorInfo;->colorRangeToString(I)Ljava/lang/String;

    move-result-object v1

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    .line 349
    invoke-static {v2}, Landroidx/media3/common/ColorInfo;->colorTransferToString(I)Ljava/lang/String;

    move-result-object v2

    filled-new-array {v0, v1, v2}, [Ljava/lang/Object;

    move-result-object v0

    .line 345
    const-string v1, "%s/%s/%s"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 350
    :cond_0
    const-string v0, "NA/NA/NA"

    :goto_0
    nop

    .line 351
    .local v0, "dataspaceString":Ljava/lang/String;
    invoke-virtual {p0}, Landroidx/media3/common/ColorInfo;->isBitdepthValid()Z

    move-result v1

    const-string v2, "/"

    if-eqz v1, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v3, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v3, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    :cond_1
    const-string v1, "NA/NA"

    .line 352
    .local v1, "bitdepthsString":Ljava/lang/String;
    :goto_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .line 389
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ColorInfo("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/media3/common/ColorInfo;->colorSpace:I

    .line 390
    invoke-static {v1}, Landroidx/media3/common/ColorInfo;->colorSpaceToString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorRange:I

    .line 392
    invoke-static {v2}, Landroidx/media3/common/ColorInfo;->colorRangeToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p0, Landroidx/media3/common/ColorInfo;->colorTransfer:I

    .line 394
    invoke-static {v2}, Landroidx/media3/common/ColorInfo;->colorTransferToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Landroidx/media3/common/ColorInfo;->hdrStaticInfo:[B

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v2, p0, Landroidx/media3/common/ColorInfo;->lumaBitdepth:I

    .line 398
    invoke-static {v2}, Landroidx/media3/common/ColorInfo;->lumaBitdepthToString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroidx/media3/common/ColorInfo;->chromaBitdepth:I

    .line 400
    invoke-static {v1}, Landroidx/media3/common/ColorInfo;->chromaBitdepthToString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 389
    return-object v0
.end method
