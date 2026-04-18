.class final Landroidx/media3/ui/SubtitlePainter;
.super Ljava/lang/Object;
.source "SubtitlePainter.java"


# static fields
.field private static final INNER_PADDING_RATIO:F = 0.125f

.field private static final TAG:Ljava/lang/String; = "SubtitlePainter"


# instance fields
.field private backgroundColor:I

.field private final bitmapPaint:Landroid/graphics/Paint;

.field private bitmapRect:Landroid/graphics/Rect;

.field private bottomPaddingFraction:F

.field private cueBitmap:Landroid/graphics/Bitmap;

.field private cueBitmapHeight:F

.field private cueLine:F

.field private cueLineAnchor:I

.field private cueLineType:I

.field private cuePosition:F

.field private cuePositionAnchor:I

.field private cueSize:F

.field private cueText:Ljava/lang/CharSequence;

.field private cueTextAlignment:Landroid/text/Layout$Alignment;

.field private cueTextSizePx:F

.field private defaultTextSizePx:F

.field private edgeColor:I

.field private edgeLayout:Landroid/text/StaticLayout;

.field private edgeType:I

.field private foregroundColor:I

.field private final outlineWidth:F

.field private parentBottom:I

.field private parentLeft:I

.field private parentRight:I

.field private parentTop:I

.field private final shadowOffset:F

.field private final shadowRadius:F

.field private final spacingAdd:F

.field private final spacingMult:F

.field private textLayout:Landroid/text/StaticLayout;

.field private textLeft:I

.field private textPaddingX:I

.field private final textPaint:Landroid/text/TextPaint;

.field private textTop:I

.field private windowColor:I

.field private final windowPaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    const v0, 0x1010217

    const v1, 0x1010218

    filled-new-array {v0, v1}, [I

    move-result-object v0

    .line 100
    .local v0, "viewAttr":[I
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v0, v2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 101
    .local v1, "styledAttributes":Landroid/content/res/TypedArray;
    invoke-virtual {v1, v2, v2}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->spacingAdd:F

    .line 102
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v3, 0x1

    invoke-virtual {v1, v3, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v2

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->spacingMult:F

    .line 103
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 105
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 106
    .local v2, "resources":Landroid/content/res/Resources;
    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    .line 107
    .local v4, "displayMetrics":Landroid/util/DisplayMetrics;
    iget v5, v4, Landroid/util/DisplayMetrics;->densityDpi:I

    int-to-float v5, v5

    const/high16 v6, 0x40000000    # 2.0f

    mul-float/2addr v5, v6

    const/high16 v6, 0x43200000    # 160.0f

    div-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 108
    .local v5, "twoDpInPx":I
    int-to-float v6, v5

    iput v6, p0, Landroidx/media3/ui/SubtitlePainter;->outlineWidth:F

    .line 109
    int-to-float v6, v5

    iput v6, p0, Landroidx/media3/ui/SubtitlePainter;->shadowRadius:F

    .line 110
    int-to-float v6, v5

    iput v6, p0, Landroidx/media3/ui/SubtitlePainter;->shadowOffset:F

    .line 112
    new-instance v6, Landroid/text/TextPaint;

    invoke-direct {v6}, Landroid/text/TextPaint;-><init>()V

    iput-object v6, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    .line 113
    invoke-virtual {v6, v3}, Landroid/text/TextPaint;->setAntiAlias(Z)V

    .line 114
    invoke-virtual {v6, v3}, Landroid/text/TextPaint;->setSubpixelText(Z)V

    .line 116
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    iput-object v6, p0, Landroidx/media3/ui/SubtitlePainter;->windowPaint:Landroid/graphics/Paint;

    .line 117
    invoke-virtual {v6, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 118
    sget-object v7, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 120
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    iput-object v6, p0, Landroidx/media3/ui/SubtitlePainter;->bitmapPaint:Landroid/graphics/Paint;

    .line 121
    invoke-virtual {v6, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 122
    invoke-virtual {v6, v3}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 123
    return-void
.end method

.method private static areCharSequencesEqual(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    .locals 1
    .param p0, "first"    # Ljava/lang/CharSequence;
    .param p1, "second"    # Ljava/lang/CharSequence;

    .line 471
    if-eq p0, p1, :cond_1

    if-eqz p0, :cond_0

    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

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

.method private drawBitmapLayout(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "cueBitmap",
            "bitmapRect"
        }
    .end annotation

    .line 458
    iget-object v0, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    iget-object v1, p0, Landroidx/media3/ui/SubtitlePainter;->bitmapRect:Landroid/graphics/Rect;

    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->bitmapPaint:Landroid/graphics/Paint;

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v3, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 459
    return-void
.end method

.method private drawLayout(Landroid/graphics/Canvas;Z)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "isTextCue"    # Z

    .line 397
    if-eqz p2, :cond_0

    .line 398
    invoke-direct {p0, p1}, Landroidx/media3/ui/SubtitlePainter;->drawTextLayout(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 400
    :cond_0
    iget-object v0, p0, Landroidx/media3/ui/SubtitlePainter;->bitmapRect:Landroid/graphics/Rect;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 401
    iget-object v0, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    invoke-static {v0}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 402
    invoke-direct {p0, p1}, Landroidx/media3/ui/SubtitlePainter;->drawBitmapLayout(Landroid/graphics/Canvas;)V

    .line 404
    :goto_0
    return-void
.end method

.method private drawTextLayout(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 407
    iget-object v0, p0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    .line 408
    .local v0, "textLayout":Landroid/text/StaticLayout;
    iget-object v1, p0, Landroidx/media3/ui/SubtitlePainter;->edgeLayout:Landroid/text/StaticLayout;

    .line 409
    .local v1, "edgeLayout":Landroid/text/StaticLayout;
    if-eqz v0, :cond_9

    if-nez v1, :cond_0

    goto/16 :goto_3

    .line 414
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    move-result v2

    .line 415
    .local v2, "saveCount":I
    iget v3, p0, Landroidx/media3/ui/SubtitlePainter;->textLeft:I

    int-to-float v3, v3

    iget v4, p0, Landroidx/media3/ui/SubtitlePainter;->textTop:I

    int-to-float v4, v4

    invoke-virtual {p1, v3, v4}, Landroid/graphics/Canvas;->translate(FF)V

    .line 417
    iget v3, p0, Landroidx/media3/ui/SubtitlePainter;->windowColor:I

    invoke-static {v3}, Landroid/graphics/Color;->alpha(I)I

    move-result v3

    if-lez v3, :cond_1

    .line 418
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->windowPaint:Landroid/graphics/Paint;

    iget v4, p0, Landroidx/media3/ui/SubtitlePainter;->windowColor:I

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 419
    iget v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaddingX:I

    neg-int v3, v3

    int-to-float v5, v3

    const/4 v6, 0x0

    .line 422
    invoke-virtual {v0}, Landroid/text/StaticLayout;->getWidth()I

    move-result v3

    iget v4, p0, Landroidx/media3/ui/SubtitlePainter;->textPaddingX:I

    add-int/2addr v3, v4

    int-to-float v7, v3

    .line 423
    invoke-virtual {v0}, Landroid/text/StaticLayout;->getHeight()I

    move-result v3

    int-to-float v8, v3

    iget-object v9, p0, Landroidx/media3/ui/SubtitlePainter;->windowPaint:Landroid/graphics/Paint;

    .line 419
    move-object v4, p1

    invoke-virtual/range {v4 .. v9}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 427
    :cond_1
    iget v3, p0, Landroidx/media3/ui/SubtitlePainter;->edgeType:I

    const/4 v4, 0x0

    const/4 v5, 0x1

    if-ne v3, v5, :cond_2

    .line 428
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    sget-object v5, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 429
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v5, p0, Landroidx/media3/ui/SubtitlePainter;->outlineWidth:F

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setStrokeWidth(F)V

    .line 430
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v5, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setColor(I)V

    .line 431
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    sget-object v5, Landroid/graphics/Paint$Style;->FILL_AND_STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 432
    invoke-virtual {v1, p1}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    goto :goto_2

    .line 433
    :cond_2
    const/4 v6, 0x2

    if-ne v3, v6, :cond_3

    .line 434
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v5, p0, Landroidx/media3/ui/SubtitlePainter;->shadowRadius:F

    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->shadowOffset:F

    iget v7, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    invoke-virtual {v3, v5, v6, v6, v7}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    goto :goto_2

    .line 435
    :cond_3
    const/4 v6, 0x3

    if-eq v3, v6, :cond_4

    const/4 v7, 0x4

    if-ne v3, v7, :cond_8

    .line 437
    :cond_4
    if-ne v3, v6, :cond_5

    goto :goto_0

    :cond_5
    move v5, v4

    :goto_0
    move v3, v5

    .line 438
    .local v3, "raised":Z
    const/4 v5, -0x1

    if-eqz v3, :cond_6

    move v6, v5

    goto :goto_1

    :cond_6
    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    .line 439
    .local v6, "colorUp":I
    :goto_1
    if-eqz v3, :cond_7

    iget v5, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    .line 440
    .local v5, "colorDown":I
    :cond_7
    iget v7, p0, Landroidx/media3/ui/SubtitlePainter;->shadowRadius:F

    const/high16 v8, 0x40000000    # 2.0f

    div-float/2addr v7, v8

    .line 441
    .local v7, "offset":F
    iget-object v8, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v9, p0, Landroidx/media3/ui/SubtitlePainter;->foregroundColor:I

    invoke-virtual {v8, v9}, Landroid/text/TextPaint;->setColor(I)V

    .line 442
    iget-object v8, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    sget-object v9, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v8, v9}, Landroid/text/TextPaint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 443
    iget-object v8, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v9, p0, Landroidx/media3/ui/SubtitlePainter;->shadowRadius:F

    neg-float v10, v7

    neg-float v11, v7

    invoke-virtual {v8, v9, v10, v11, v6}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 444
    invoke-virtual {v1, p1}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    .line 445
    iget-object v8, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v9, p0, Landroidx/media3/ui/SubtitlePainter;->shadowRadius:F

    invoke-virtual {v8, v9, v7, v7, v5}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 448
    .end local v3    # "raised":Z
    .end local v5    # "colorDown":I
    .end local v6    # "colorUp":I
    .end local v7    # "offset":F
    :cond_8
    :goto_2
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v5, p0, Landroidx/media3/ui/SubtitlePainter;->foregroundColor:I

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setColor(I)V

    .line 449
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    sget-object v5, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v3, v5}, Landroid/text/TextPaint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 450
    invoke-virtual {v0, p1}, Landroid/text/StaticLayout;->draw(Landroid/graphics/Canvas;)V

    .line 451
    iget-object v3, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    const/4 v5, 0x0

    invoke-virtual {v3, v5, v5, v5, v4}, Landroid/text/TextPaint;->setShadowLayer(FFFI)V

    .line 453
    invoke-virtual {p1, v2}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 454
    return-void

    .line 411
    .end local v2    # "saveCount":I
    :cond_9
    :goto_3
    return-void
.end method

.method private setupBitmapLayout()V
    .locals 12
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "cueBitmap"
        }
    .end annotation

    .line 373
    iget-object v0, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    .line 374
    .local v0, "cueBitmap":Landroid/graphics/Bitmap;
    iget v1, p0, Landroidx/media3/ui/SubtitlePainter;->parentRight:I

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    sub-int/2addr v1, v2

    .line 375
    .local v1, "parentWidth":I
    iget v3, p0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    iget v4, p0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    sub-int/2addr v3, v4

    .line 376
    .local v3, "parentHeight":I
    int-to-float v2, v2

    int-to-float v5, v1

    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->cuePosition:F

    mul-float/2addr v5, v6

    add-float/2addr v2, v5

    .line 377
    .local v2, "anchorX":F
    int-to-float v4, v4

    int-to-float v5, v3

    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->cueLine:F

    mul-float/2addr v5, v6

    add-float/2addr v4, v5

    .line 378
    .local v4, "anchorY":F
    int-to-float v5, v1

    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->cueSize:F

    mul-float/2addr v5, v6

    invoke-static {v5}, Ljava/lang/Math;->round(F)I

    move-result v5

    .line 380
    .local v5, "width":I
    iget v6, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmapHeight:F

    const v7, -0x800001

    cmpl-float v7, v6, v7

    if-eqz v7, :cond_0

    .line 381
    int-to-float v7, v3

    mul-float/2addr v7, v6

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v6

    goto :goto_0

    .line 382
    :cond_0
    int-to-float v6, v5

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v7

    int-to-float v7, v7

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v8

    int-to-float v8, v8

    div-float/2addr v7, v8

    mul-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v6

    :goto_0
    nop

    .line 385
    .local v6, "height":I
    iget v7, p0, Landroidx/media3/ui/SubtitlePainter;->cuePositionAnchor:I

    const/4 v8, 0x1

    const/4 v9, 0x2

    if-ne v7, v9, :cond_1

    .line 386
    int-to-float v7, v5

    sub-float v7, v2, v7

    goto :goto_1

    .line 387
    :cond_1
    if-ne v7, v8, :cond_2

    div-int/lit8 v7, v5, 0x2

    int-to-float v7, v7

    sub-float v7, v2, v7

    goto :goto_1

    :cond_2
    move v7, v2

    .line 384
    :goto_1
    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    .line 390
    .local v7, "x":I
    iget v10, p0, Landroidx/media3/ui/SubtitlePainter;->cueLineAnchor:I

    if-ne v10, v9, :cond_3

    .line 391
    int-to-float v8, v6

    sub-float v8, v4, v8

    goto :goto_2

    .line 392
    :cond_3
    if-ne v10, v8, :cond_4

    div-int/lit8 v8, v6, 0x2

    int-to-float v8, v8

    sub-float v8, v4, v8

    goto :goto_2

    :cond_4
    move v8, v4

    .line 389
    :goto_2
    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v8

    .line 393
    .local v8, "y":I
    new-instance v9, Landroid/graphics/Rect;

    add-int v10, v7, v5

    add-int v11, v8, v6

    invoke-direct {v9, v7, v8, v10, v11}, Landroid/graphics/Rect;-><init>(IIII)V

    iput-object v9, p0, Landroidx/media3/ui/SubtitlePainter;->bitmapRect:Landroid/graphics/Rect;

    .line 394
    return-void
.end method

.method private setupTextLayout()V
    .locals 32
    .annotation runtime Lorg/checkerframework/checker/nullness/qual/RequiresNonNull;
        value = {
            "cueText"
        }
    .end annotation

    .line 230
    move-object/from16 v0, p0

    iget-object v1, v0, Landroidx/media3/ui/SubtitlePainter;->cueText:Ljava/lang/CharSequence;

    instance-of v2, v1, Landroid/text/SpannableStringBuilder;

    if-eqz v2, :cond_0

    .line 231
    check-cast v1, Landroid/text/SpannableStringBuilder;

    goto :goto_0

    .line 232
    :cond_0
    new-instance v1, Landroid/text/SpannableStringBuilder;

    iget-object v2, v0, Landroidx/media3/ui/SubtitlePainter;->cueText:Ljava/lang/CharSequence;

    invoke-direct {v1, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    :goto_0
    nop

    .line 233
    .local v1, "cueText":Landroid/text/SpannableStringBuilder;
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->parentRight:I

    iget v3, v0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    sub-int v15, v2, v3

    .line 234
    .local v15, "parentWidth":I
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    iget v3, v0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    sub-int v14, v2, v3

    .line 236
    .local v14, "parentHeight":I
    iget-object v2, v0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v3, v0, Landroidx/media3/ui/SubtitlePainter;->defaultTextSizePx:F

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTextSize(F)V

    .line 237
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->defaultTextSizePx:F

    const/high16 v3, 0x3e000000    # 0.125f

    mul-float/2addr v2, v3

    const/high16 v3, 0x3f000000    # 0.5f

    add-float/2addr v2, v3

    float-to-int v13, v2

    .line 239
    .local v13, "textPaddingX":I
    mul-int/lit8 v2, v13, 0x2

    sub-int v2, v15, v2

    .line 240
    .local v2, "availableWidth":I
    iget v3, v0, Landroidx/media3/ui/SubtitlePainter;->cueSize:F

    const v10, -0x800001

    cmpl-float v4, v3, v10

    if-eqz v4, :cond_1

    .line 241
    int-to-float v4, v2

    mul-float/2addr v4, v3

    float-to-int v2, v4

    move v12, v2

    goto :goto_1

    .line 240
    :cond_1
    move v12, v2

    .line 243
    .end local v2    # "availableWidth":I
    .local v12, "availableWidth":I
    :goto_1
    const-string v11, "SubtitlePainter"

    if-gtz v12, :cond_2

    .line 244
    const-string v2, "Skipped drawing subtitle cue (insufficient space)"

    invoke-static {v11, v2}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    return-void

    .line 248
    :cond_2
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->cueTextSizePx:F

    const/16 v16, 0x0

    cmpl-float v2, v2, v16

    const/high16 v3, 0xff0000

    const/4 v9, 0x0

    if-lez v2, :cond_3

    .line 250
    new-instance v2, Landroid/text/style/AbsoluteSizeSpan;

    iget v4, v0, Landroidx/media3/ui/SubtitlePainter;->cueTextSizePx:F

    float-to-int v4, v4

    invoke-direct {v2, v4}, Landroid/text/style/AbsoluteSizeSpan;-><init>(I)V

    .line 253
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    .line 250
    invoke-virtual {v1, v2, v9, v4, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 258
    :cond_3
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v1}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    move-object v8, v2

    .line 259
    .local v8, "cueTextEdge":Landroid/text/SpannableStringBuilder;
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->edgeType:I

    const/4 v7, 0x1

    if-ne v2, v7, :cond_4

    .line 260
    nop

    .line 261
    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    const-class v4, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual {v8, v9, v2, v4}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Landroid/text/style/ForegroundColorSpan;

    .line 262
    .local v2, "foregroundColorSpans":[Landroid/text/style/ForegroundColorSpan;
    array-length v4, v2

    move v5, v9

    :goto_2
    if-ge v5, v4, :cond_4

    aget-object v6, v2, v5

    .line 263
    .local v6, "foregroundColorSpan":Landroid/text/style/ForegroundColorSpan;
    invoke-virtual {v8, v6}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 262
    .end local v6    # "foregroundColorSpan":Landroid/text/style/ForegroundColorSpan;
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 271
    .end local v2    # "foregroundColorSpans":[Landroid/text/style/ForegroundColorSpan;
    :cond_4
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->backgroundColor:I

    invoke-static {v2}, Landroid/graphics/Color;->alpha(I)I

    move-result v2

    const/4 v5, 0x2

    if-lez v2, :cond_7

    .line 272
    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->edgeType:I

    if-eqz v2, :cond_6

    if-ne v2, v5, :cond_5

    goto :goto_3

    .line 277
    :cond_5
    new-instance v2, Landroid/text/style/BackgroundColorSpan;

    iget v4, v0, Landroidx/media3/ui/SubtitlePainter;->backgroundColor:I

    invoke-direct {v2, v4}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    .line 280
    invoke-virtual {v8}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    .line 277
    invoke-virtual {v8, v2, v9, v4, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_4

    .line 274
    :cond_6
    :goto_3
    new-instance v2, Landroid/text/style/BackgroundColorSpan;

    iget v4, v0, Landroidx/media3/ui/SubtitlePainter;->backgroundColor:I

    invoke-direct {v2, v4}, Landroid/text/style/BackgroundColorSpan;-><init>(I)V

    .line 275
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    .line 274
    invoke-virtual {v1, v2, v9, v4, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 285
    :cond_7
    :goto_4
    iget-object v2, v0, Landroidx/media3/ui/SubtitlePainter;->cueTextAlignment:Landroid/text/Layout$Alignment;

    if-nez v2, :cond_8

    sget-object v2, Landroid/text/Layout$Alignment;->ALIGN_CENTER:Landroid/text/Layout$Alignment;

    :cond_8
    move-object v6, v2

    .line 286
    .local v6, "textAlignment":Landroid/text/Layout$Alignment;
    new-instance v4, Landroid/text/StaticLayout;

    iget-object v3, v0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v2, v0, Landroidx/media3/ui/SubtitlePainter;->spacingMult:F

    iget v9, v0, Landroidx/media3/ui/SubtitlePainter;->spacingAdd:F

    const/16 v18, 0x1

    move/from16 v19, v2

    move-object v2, v4

    move-object/from16 v20, v3

    move-object v3, v1

    move-object v10, v4

    move-object/from16 v4, v20

    move-object/from16 v25, v1

    move v1, v5

    .end local v1    # "cueText":Landroid/text/SpannableStringBuilder;
    .local v25, "cueText":Landroid/text/SpannableStringBuilder;
    move v5, v12

    move/from16 v7, v19

    move-object/from16 v27, v8

    .end local v8    # "cueTextEdge":Landroid/text/SpannableStringBuilder;
    .local v27, "cueTextEdge":Landroid/text/SpannableStringBuilder;
    move v8, v9

    move/from16 v9, v18

    invoke-direct/range {v2 .. v9}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    iput-object v10, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    .line 289
    invoke-virtual {v10}, Landroid/text/StaticLayout;->getHeight()I

    move-result v2

    .line 290
    .local v2, "textHeight":I
    const/4 v3, 0x0

    .line 291
    .local v3, "textWidth":I
    iget-object v4, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v4}, Landroid/text/StaticLayout;->getLineCount()I

    move-result v4

    .line 292
    .local v4, "lineCount":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_5
    if-ge v5, v4, :cond_9

    .line 293
    iget-object v7, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v7, v5}, Landroid/text/StaticLayout;->getLineWidth(I)F

    move-result v7

    float-to-double v7, v7

    invoke-static {v7, v8}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v7

    double-to-int v7, v7

    invoke-static {v7, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 292
    add-int/lit8 v5, v5, 0x1

    goto :goto_5

    .line 295
    .end local v5    # "i":I
    :cond_9
    iget v5, v0, Landroidx/media3/ui/SubtitlePainter;->cueSize:F

    const v7, -0x800001

    cmpl-float v5, v5, v7

    if-eqz v5, :cond_a

    if-ge v3, v12, :cond_a

    .line 296
    move v3, v12

    .line 298
    :cond_a
    mul-int/lit8 v5, v13, 0x2

    add-int/2addr v3, v5

    .line 302
    iget v5, v0, Landroidx/media3/ui/SubtitlePainter;->cuePosition:F

    const v7, -0x800001

    cmpl-float v8, v5, v7

    if-eqz v8, :cond_b

    .line 303
    int-to-float v7, v15

    mul-float/2addr v7, v5

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v5

    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    add-int/2addr v5, v7

    .line 304
    .local v5, "anchorPosition":I
    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->cuePositionAnchor:I

    packed-switch v8, :pswitch_data_0

    .line 314
    move v8, v5

    .local v8, "textLeft":I
    goto :goto_6

    .line 306
    .end local v8    # "textLeft":I
    :pswitch_0
    sub-int v8, v5, v3

    .line 307
    .restart local v8    # "textLeft":I
    goto :goto_6

    .line 309
    .end local v8    # "textLeft":I
    :pswitch_1
    mul-int/lit8 v8, v5, 0x2

    sub-int/2addr v8, v3

    div-int/2addr v8, v1

    .line 310
    .restart local v8    # "textLeft":I
    nop

    .line 317
    :goto_6
    invoke-static {v8, v7}, Ljava/lang/Math;->max(II)I

    move-result v7

    .line 318
    .end local v8    # "textLeft":I
    .local v7, "textLeft":I
    add-int v8, v7, v3

    iget v9, v0, Landroidx/media3/ui/SubtitlePainter;->parentRight:I

    invoke-static {v8, v9}, Ljava/lang/Math;->min(II)I

    move-result v5

    .line 319
    .local v5, "textRight":I
    move v10, v7

    goto :goto_7

    .line 320
    .end local v5    # "textRight":I
    .end local v7    # "textLeft":I
    :cond_b
    sub-int v5, v15, v3

    div-int/2addr v5, v1

    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    add-int/2addr v7, v5

    .line 321
    .restart local v7    # "textLeft":I
    add-int v5, v7, v3

    move v10, v7

    .line 324
    .end local v7    # "textLeft":I
    .restart local v5    # "textRight":I
    .local v10, "textLeft":I
    :goto_7
    sub-int v3, v5, v10

    .line 325
    if-gtz v3, :cond_c

    .line 326
    const-string v1, "Skipped drawing subtitle cue (invalid horizontal positioning)"

    invoke-static {v11, v1}, Landroidx/media3/common/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    return-void

    .line 331
    :cond_c
    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->cueLine:F

    const v8, -0x800001

    cmpl-float v8, v7, v8

    if-eqz v8, :cond_12

    .line 332
    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->cueLineType:I

    if-nez v8, :cond_f

    .line 333
    int-to-float v8, v14

    mul-float/2addr v8, v7

    invoke-static {v8}, Ljava/lang/Math;->round(F)I

    move-result v7

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    add-int/2addr v7, v8

    .line 335
    .local v7, "anchorPosition":I
    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->cueLineAnchor:I

    if-ne v8, v1, :cond_d

    .line 336
    sub-int v1, v7, v2

    goto :goto_8

    .line 337
    :cond_d
    const/4 v9, 0x1

    if-ne v8, v9, :cond_e

    .line 338
    mul-int/lit8 v8, v7, 0x2

    sub-int/2addr v8, v2

    div-int/lit8 v1, v8, 0x2

    goto :goto_8

    .line 339
    :cond_e
    move v1, v7

    :goto_8
    nop

    .line 340
    .end local v7    # "anchorPosition":I
    .local v1, "textTop":I
    goto :goto_9

    .line 342
    .end local v1    # "textTop":I
    :cond_f
    iget-object v1, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    const/4 v7, 0x0

    invoke-virtual {v1, v7}, Landroid/text/StaticLayout;->getLineBottom(I)I

    move-result v1

    iget-object v8, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    invoke-virtual {v8, v7}, Landroid/text/StaticLayout;->getLineTop(I)I

    move-result v7

    sub-int/2addr v1, v7

    .line 343
    .local v1, "firstLineHeight":I
    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->cueLine:F

    cmpl-float v8, v7, v16

    if-ltz v8, :cond_10

    .line 344
    int-to-float v8, v1

    mul-float/2addr v7, v8

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    add-int/2addr v7, v8

    move v1, v7

    .local v7, "textTop":I
    goto :goto_9

    .line 346
    .end local v7    # "textTop":I
    :cond_10
    const/high16 v8, 0x3f800000    # 1.0f

    add-float/2addr v7, v8

    int-to-float v8, v1

    mul-float/2addr v7, v8

    invoke-static {v7}, Ljava/lang/Math;->round(F)I

    move-result v7

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    add-int/2addr v7, v8

    sub-int/2addr v7, v2

    move v1, v7

    .line 350
    .local v1, "textTop":I
    :goto_9
    add-int v7, v1, v2

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    if-le v7, v8, :cond_11

    .line 351
    sub-int v1, v8, v2

    goto :goto_a

    .line 352
    :cond_11
    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    if-ge v1, v7, :cond_13

    .line 353
    iget v1, v0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    goto :goto_a

    .line 356
    .end local v1    # "textTop":I
    :cond_12
    iget v1, v0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    sub-int/2addr v1, v2

    int-to-float v7, v14

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->bottomPaddingFraction:F

    mul-float/2addr v7, v8

    float-to-int v7, v7

    sub-int/2addr v1, v7

    .line 360
    .restart local v1    # "textTop":I
    :cond_13
    :goto_a
    new-instance v11, Landroid/text/StaticLayout;

    iget-object v9, v0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v8, v0, Landroidx/media3/ui/SubtitlePainter;->spacingMult:F

    iget v7, v0, Landroidx/media3/ui/SubtitlePainter;->spacingAdd:F

    const/16 v16, 0x1

    move/from16 v17, v7

    move-object v7, v11

    move/from16 v18, v8

    move-object/from16 v8, v25

    move/from16 v29, v10

    .end local v10    # "textLeft":I
    .local v29, "textLeft":I
    move v10, v3

    move-object/from16 v30, v11

    move-object v11, v6

    move/from16 v26, v12

    .end local v12    # "availableWidth":I
    .local v26, "availableWidth":I
    move/from16 v12, v18

    move/from16 v28, v2

    move v2, v13

    .end local v13    # "textPaddingX":I
    .local v2, "textPaddingX":I
    .local v28, "textHeight":I
    move/from16 v13, v17

    move/from16 v31, v14

    .end local v14    # "parentHeight":I
    .local v31, "parentHeight":I
    move/from16 v14, v16

    invoke-direct/range {v7 .. v14}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    move-object/from16 v7, v30

    iput-object v7, v0, Landroidx/media3/ui/SubtitlePainter;->textLayout:Landroid/text/StaticLayout;

    .line 363
    new-instance v7, Landroid/text/StaticLayout;

    iget-object v8, v0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget v9, v0, Landroidx/media3/ui/SubtitlePainter;->spacingMult:F

    iget v10, v0, Landroidx/media3/ui/SubtitlePainter;->spacingAdd:F

    const/16 v24, 0x1

    move-object/from16 v17, v7

    move-object/from16 v18, v27

    move-object/from16 v19, v8

    move/from16 v20, v3

    move-object/from16 v21, v6

    move/from16 v22, v9

    move/from16 v23, v10

    invoke-direct/range {v17 .. v24}, Landroid/text/StaticLayout;-><init>(Ljava/lang/CharSequence;Landroid/text/TextPaint;ILandroid/text/Layout$Alignment;FFZ)V

    iput-object v7, v0, Landroidx/media3/ui/SubtitlePainter;->edgeLayout:Landroid/text/StaticLayout;

    .line 366
    move/from16 v7, v29

    .end local v29    # "textLeft":I
    .local v7, "textLeft":I
    iput v7, v0, Landroidx/media3/ui/SubtitlePainter;->textLeft:I

    .line 367
    iput v1, v0, Landroidx/media3/ui/SubtitlePainter;->textTop:I

    .line 368
    iput v2, v0, Landroidx/media3/ui/SubtitlePainter;->textPaddingX:I

    .line 369
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public draw(Landroidx/media3/common/text/Cue;Landroidx/media3/ui/CaptionStyleCompat;FFFLandroid/graphics/Canvas;IIII)V
    .locals 4
    .param p1, "cue"    # Landroidx/media3/common/text/Cue;
    .param p2, "style"    # Landroidx/media3/ui/CaptionStyleCompat;
    .param p3, "defaultTextSizePx"    # F
    .param p4, "cueTextSizePx"    # F
    .param p5, "bottomPaddingFraction"    # F
    .param p6, "canvas"    # Landroid/graphics/Canvas;
    .param p7, "cueBoxLeft"    # I
    .param p8, "cueBoxTop"    # I
    .param p9, "cueBoxRight"    # I
    .param p10, "cueBoxBottom"    # I

    .line 156
    iget-object v0, p1, Landroidx/media3/common/text/Cue;->bitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 157
    .local v0, "isTextCue":Z
    :goto_0
    const/high16 v1, -0x1000000

    .line 158
    .local v1, "windowColor":I
    if-eqz v0, :cond_3

    .line 159
    iget-object v2, p1, Landroidx/media3/common/text/Cue;->text:Ljava/lang/CharSequence;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 161
    return-void

    .line 163
    :cond_1
    iget-boolean v2, p1, Landroidx/media3/common/text/Cue;->windowColorSet:Z

    if-eqz v2, :cond_2

    iget v2, p1, Landroidx/media3/common/text/Cue;->windowColor:I

    goto :goto_1

    :cond_2
    iget v2, p2, Landroidx/media3/ui/CaptionStyleCompat;->windowColor:I

    :goto_1
    move v1, v2

    .line 165
    :cond_3
    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueText:Ljava/lang/CharSequence;

    iget-object v3, p1, Landroidx/media3/common/text/Cue;->text:Ljava/lang/CharSequence;

    invoke-static {v2, v3}, Landroidx/media3/ui/SubtitlePainter;->areCharSequencesEqual(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueTextAlignment:Landroid/text/Layout$Alignment;

    iget-object v3, p1, Landroidx/media3/common/text/Cue;->textAlignment:Landroid/text/Layout$Alignment;

    .line 166
    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    iget-object v3, p1, Landroidx/media3/common/text/Cue;->bitmap:Landroid/graphics/Bitmap;

    if-ne v2, v3, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLine:F

    iget v3, p1, Landroidx/media3/common/text/Cue;->line:F

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLineType:I

    iget v3, p1, Landroidx/media3/common/text/Cue;->lineType:I

    if-ne v2, v3, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLineAnchor:I

    .line 170
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, p1, Landroidx/media3/common/text/Cue;->lineAnchor:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cuePosition:F

    iget v3, p1, Landroidx/media3/common/text/Cue;->position:F

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cuePositionAnchor:I

    .line 172
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget v3, p1, Landroidx/media3/common/text/Cue;->positionAnchor:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueSize:F

    iget v3, p1, Landroidx/media3/common/text/Cue;->size:F

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmapHeight:F

    iget v3, p1, Landroidx/media3/common/text/Cue;->bitmapHeight:F

    cmpl-float v2, v2, v3

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->foregroundColor:I

    iget v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->foregroundColor:I

    if-ne v2, v3, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->backgroundColor:I

    iget v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->backgroundColor:I

    if-ne v2, v3, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->windowColor:I

    if-ne v2, v1, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->edgeType:I

    iget v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->edgeType:I

    if-ne v2, v3, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    iget v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    if-ne v2, v3, :cond_4

    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    .line 180
    invoke-virtual {v2}, Landroid/text/TextPaint;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    iget-object v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->typeface:Landroid/graphics/Typeface;

    invoke-static {v2, v3}, Landroidx/media3/common/util/Util;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->defaultTextSizePx:F

    cmpl-float v2, v2, p3

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueTextSizePx:F

    cmpl-float v2, v2, p4

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->bottomPaddingFraction:F

    cmpl-float v2, v2, p5

    if-nez v2, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    if-ne v2, p7, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    if-ne v2, p8, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->parentRight:I

    if-ne v2, p9, :cond_4

    iget v2, p0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    if-ne v2, p10, :cond_4

    .line 189
    invoke-direct {p0, p6, v0}, Landroidx/media3/ui/SubtitlePainter;->drawLayout(Landroid/graphics/Canvas;Z)V

    .line 190
    return-void

    .line 193
    :cond_4
    iget-object v2, p1, Landroidx/media3/common/text/Cue;->text:Ljava/lang/CharSequence;

    iput-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueText:Ljava/lang/CharSequence;

    .line 194
    iget-object v2, p1, Landroidx/media3/common/text/Cue;->textAlignment:Landroid/text/Layout$Alignment;

    iput-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueTextAlignment:Landroid/text/Layout$Alignment;

    .line 195
    iget-object v2, p1, Landroidx/media3/common/text/Cue;->bitmap:Landroid/graphics/Bitmap;

    iput-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    .line 196
    iget v2, p1, Landroidx/media3/common/text/Cue;->line:F

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLine:F

    .line 197
    iget v2, p1, Landroidx/media3/common/text/Cue;->lineType:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLineType:I

    .line 198
    iget v2, p1, Landroidx/media3/common/text/Cue;->lineAnchor:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueLineAnchor:I

    .line 199
    iget v2, p1, Landroidx/media3/common/text/Cue;->position:F

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cuePosition:F

    .line 200
    iget v2, p1, Landroidx/media3/common/text/Cue;->positionAnchor:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cuePositionAnchor:I

    .line 201
    iget v2, p1, Landroidx/media3/common/text/Cue;->size:F

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueSize:F

    .line 202
    iget v2, p1, Landroidx/media3/common/text/Cue;->bitmapHeight:F

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmapHeight:F

    .line 203
    iget v2, p2, Landroidx/media3/ui/CaptionStyleCompat;->foregroundColor:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->foregroundColor:I

    .line 204
    iget v2, p2, Landroidx/media3/ui/CaptionStyleCompat;->backgroundColor:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->backgroundColor:I

    .line 205
    iput v1, p0, Landroidx/media3/ui/SubtitlePainter;->windowColor:I

    .line 206
    iget v2, p2, Landroidx/media3/ui/CaptionStyleCompat;->edgeType:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->edgeType:I

    .line 207
    iget v2, p2, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    iput v2, p0, Landroidx/media3/ui/SubtitlePainter;->edgeColor:I

    .line 208
    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->textPaint:Landroid/text/TextPaint;

    iget-object v3, p2, Landroidx/media3/ui/CaptionStyleCompat;->typeface:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/text/TextPaint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 209
    iput p3, p0, Landroidx/media3/ui/SubtitlePainter;->defaultTextSizePx:F

    .line 210
    iput p4, p0, Landroidx/media3/ui/SubtitlePainter;->cueTextSizePx:F

    .line 211
    iput p5, p0, Landroidx/media3/ui/SubtitlePainter;->bottomPaddingFraction:F

    .line 212
    iput p7, p0, Landroidx/media3/ui/SubtitlePainter;->parentLeft:I

    .line 213
    iput p8, p0, Landroidx/media3/ui/SubtitlePainter;->parentTop:I

    .line 214
    iput p9, p0, Landroidx/media3/ui/SubtitlePainter;->parentRight:I

    .line 215
    iput p10, p0, Landroidx/media3/ui/SubtitlePainter;->parentBottom:I

    .line 217
    if-eqz v0, :cond_5

    .line 218
    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueText:Ljava/lang/CharSequence;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    invoke-direct {p0}, Landroidx/media3/ui/SubtitlePainter;->setupTextLayout()V

    goto :goto_2

    .line 221
    :cond_5
    iget-object v2, p0, Landroidx/media3/ui/SubtitlePainter;->cueBitmap:Landroid/graphics/Bitmap;

    invoke-static {v2}, Landroidx/media3/common/util/Assertions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    invoke-direct {p0}, Landroidx/media3/ui/SubtitlePainter;->setupBitmapLayout()V

    .line 224
    :goto_2
    invoke-direct {p0, p6, v0}, Landroidx/media3/ui/SubtitlePainter;->drawLayout(Landroid/graphics/Canvas;Z)V

    .line 225
    return-void
.end method
