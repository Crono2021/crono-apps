.class final Landroidx/media3/ui/WebViewSubtitleOutput;
.super Landroid/widget/FrameLayout;
.source "WebViewSubtitleOutput.java"

# interfaces
.implements Landroidx/media3/ui/SubtitleView$Output;


# static fields
.field private static final CSS_LINE_HEIGHT:F = 1.2f

.field private static final DEFAULT_BACKGROUND_CSS_CLASS:Ljava/lang/String; = "default_bg"


# instance fields
.field private bottomPaddingFraction:F

.field private final canvasSubtitleOutput:Landroidx/media3/ui/CanvasSubtitleOutput;

.field private defaultTextSize:F

.field private defaultTextSizeType:I

.field private style:Landroidx/media3/ui/CaptionStyleCompat;

.field private textCues:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Landroidx/media3/common/text/Cue;",
            ">;"
        }
    .end annotation
.end field

.field private final webView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 75
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroidx/media3/ui/WebViewSubtitleOutput;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 79
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 81
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    .line 82
    sget-object v0, Landroidx/media3/ui/CaptionStyleCompat;->DEFAULT:Landroidx/media3/ui/CaptionStyleCompat;

    iput-object v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    .line 83
    const v0, 0x3d5a511a    # 0.0533f

    iput v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSize:F

    .line 84
    const/4 v0, 0x0

    iput v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSizeType:I

    .line 85
    const v1, 0x3da3d70a    # 0.08f

    iput v1, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->bottomPaddingFraction:F

    .line 87
    new-instance v1, Landroidx/media3/ui/CanvasSubtitleOutput;

    invoke-direct {v1, p1, p2}, Landroidx/media3/ui/CanvasSubtitleOutput;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v1, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->canvasSubtitleOutput:Landroidx/media3/ui/CanvasSubtitleOutput;

    .line 88
    new-instance v2, Landroidx/media3/ui/WebViewSubtitleOutput$1;

    invoke-direct {v2, p0, p1, p2}, Landroidx/media3/ui/WebViewSubtitleOutput$1;-><init>(Landroidx/media3/ui/WebViewSubtitleOutput;Landroid/content/Context;Landroid/util/AttributeSet;)V

    iput-object v2, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->webView:Landroid/webkit/WebView;

    .line 104
    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 106
    invoke-virtual {p0, v1}, Landroidx/media3/ui/WebViewSubtitleOutput;->addView(Landroid/view/View;)V

    .line 107
    invoke-virtual {p0, v2}, Landroidx/media3/ui/WebViewSubtitleOutput;->addView(Landroid/view/View;)V

    .line 108
    return-void
.end method

.method private static anchorTypeToTranslatePercent(I)I
    .locals 1
    .param p0, "anchorType"    # I

    .line 426
    packed-switch p0, :pswitch_data_0

    .line 434
    const/4 v0, 0x0

    return v0

    .line 428
    :pswitch_0
    const/16 v0, -0x64

    return v0

    .line 430
    :pswitch_1
    const/16 v0, -0x32

    return v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static convertAlignmentToCss(Landroid/text/Layout$Alignment;)Ljava/lang/String;
    .locals 3
    .param p0, "alignment"    # Landroid/text/Layout$Alignment;

    .line 403
    const-string v0, "center"

    if-nez p0, :cond_0

    .line 404
    return-object v0

    .line 406
    :cond_0
    sget-object v1, Landroidx/media3/ui/WebViewSubtitleOutput$2;->$SwitchMap$android$text$Layout$Alignment:[I

    invoke-virtual {p0}, Landroid/text/Layout$Alignment;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 413
    return-object v0

    .line 410
    :pswitch_0
    const-string v0, "end"

    return-object v0

    .line 408
    :pswitch_1
    const-string v0, "start"

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static convertCaptionStyleToCssTextShadow(Landroidx/media3/ui/CaptionStyleCompat;)Ljava/lang/String;
    .locals 2
    .param p0, "style"    # Landroidx/media3/ui/CaptionStyleCompat;

    .line 369
    iget v0, p0, Landroidx/media3/ui/CaptionStyleCompat;->edgeType:I

    packed-switch v0, :pswitch_data_0

    .line 386
    const-string v0, "unset"

    return-object v0

    .line 371
    :pswitch_0
    iget v0, p0, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    .line 372
    invoke-static {v0}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v0

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    .line 371
    const-string v1, "-0.05em -0.05em 0.15em %s"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 382
    :pswitch_1
    iget v0, p0, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    .line 383
    invoke-static {v0}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v0

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    .line 382
    const-string v1, "0.06em 0.08em 0.15em %s"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 374
    :pswitch_2
    iget v0, p0, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    invoke-static {v0}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v0

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    const-string v1, "0.1em 0.12em 0.15em %s"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 378
    :pswitch_3
    iget v0, p0, Landroidx/media3/ui/CaptionStyleCompat;->edgeColor:I

    .line 380
    invoke-static {v0}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v0

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    .line 378
    const-string v1, "1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s"

    invoke-static {v1, v0}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private convertTextSizeToCss(IF)Ljava/lang/String;
    .locals 4
    .param p1, "type"    # I
    .param p2, "size"    # F

    .line 358
    nop

    .line 360
    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getHeight()I

    move-result v0

    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getHeight()I

    move-result v1

    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getPaddingTop()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getPaddingBottom()I

    move-result v2

    sub-int/2addr v1, v2

    .line 359
    invoke-static {p1, p2, v0, v1}, Landroidx/media3/ui/SubtitleViewUtils;->resolveTextSize(IFII)F

    move-result v0

    .line 361
    .local v0, "sizePx":F
    const v1, -0x800001

    cmpl-float v1, v0, v1

    if-nez v1, :cond_0

    .line 362
    const-string v1, "unset"

    return-object v1

    .line 364
    :cond_0
    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    div-float v1, v0, v1

    .line 365
    .local v1, "sizeDp":F
    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    filled-new-array {v2}, [Ljava/lang/Object;

    move-result-object v2

    const-string v3, "%.2fpx"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static convertVerticalTypeToCss(I)Ljava/lang/String;
    .locals 1
    .param p0, "verticalType"    # I

    .line 391
    packed-switch p0, :pswitch_data_0

    .line 398
    const-string v0, "horizontal-tb"

    return-object v0

    .line 393
    :pswitch_0
    const-string v0, "vertical-lr"

    return-object v0

    .line 395
    :pswitch_1
    const-string v0, "vertical-rl"

    return-object v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method private static getBlockShearTransformFunction(Landroidx/media3/common/text/Cue;)Ljava/lang/String;
    .locals 3
    .param p0, "cue"    # Landroidx/media3/common/text/Cue;

    .line 338
    iget v0, p0, Landroidx/media3/common/text/Cue;->shearDegrees:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_2

    .line 340
    iget v0, p0, Landroidx/media3/common/text/Cue;->verticalType:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_1

    iget v0, p0, Landroidx/media3/common/text/Cue;->verticalType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    goto :goto_0

    .line 342
    :cond_0
    const-string v0, "skewX"

    goto :goto_1

    .line 341
    :cond_1
    :goto_0
    const-string v0, "skewY"

    .line 342
    :goto_1
    nop

    .line 343
    .local v0, "direction":Ljava/lang/String;
    iget v1, p0, Landroidx/media3/common/text/Cue;->shearDegrees:F

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    filled-new-array {v0, v1}, [Ljava/lang/Object;

    move-result-object v1

    const-string v2, "%s(%.2fdeg)"

    invoke-static {v2, v1}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 345
    .end local v0    # "direction":Ljava/lang/String;
    :cond_2
    const-string v0, ""

    return-object v0
.end method

.method private updateWebView()V
    .locals 39

    .line 166
    move-object/from16 v0, p0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 167
    .local v1, "html":Ljava/lang/StringBuilder;
    iget-object v2, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    iget v2, v2, Landroidx/media3/ui/CaptionStyleCompat;->foregroundColor:I

    .line 181
    invoke-static {v2}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v2

    iget v3, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSizeType:I

    iget v4, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSize:F

    .line 182
    invoke-direct {v0, v3, v4}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertTextSizeToCss(IF)Ljava/lang/String;

    move-result-object v3

    .line 183
    const v4, 0x3f99999a    # 1.2f

    invoke-static {v4}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    iget-object v6, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    .line 184
    invoke-static {v6}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertCaptionStyleToCssTextShadow(Landroidx/media3/ui/CaptionStyleCompat;)Ljava/lang/String;

    move-result-object v6

    filled-new-array {v2, v3, v5, v6}, [Ljava/lang/Object;

    move-result-object v2

    .line 168
    const-string v3, "<body><div style=\'-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;\'>"

    invoke-static {v3, v2}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 167
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 186
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 187
    .local v2, "cssRuleSets":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    nop

    .line 188
    const-string v3, "default_bg"

    invoke-static {v3}, Landroidx/media3/ui/HtmlUtils;->cssAllClassDescendantsSelector(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    iget v6, v6, Landroidx/media3/ui/CaptionStyleCompat;->backgroundColor:I

    .line 189
    invoke-static {v6}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v6

    filled-new-array {v6}, [Ljava/lang/Object;

    move-result-object v6

    const-string v7, "background-color:%s;"

    invoke-static {v7, v6}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 187
    invoke-interface {v2, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 190
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    iget-object v6, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    const/4 v8, 0x1

    if-ge v5, v6, :cond_f

    .line 191
    iget-object v6, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    invoke-interface {v6, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroidx/media3/common/text/Cue;

    .line 192
    .local v6, "cue":Landroidx/media3/common/text/Cue;
    iget v9, v6, Landroidx/media3/common/text/Cue;->position:F

    const v10, -0x800001

    cmpl-float v9, v9, v10

    const/high16 v11, 0x42c80000    # 100.0f

    if-eqz v9, :cond_0

    iget v9, v6, Landroidx/media3/common/text/Cue;->position:F

    mul-float/2addr v9, v11

    goto :goto_1

    :cond_0
    const/high16 v9, 0x42480000    # 50.0f

    .line 193
    .local v9, "positionPercent":F
    :goto_1
    iget v12, v6, Landroidx/media3/common/text/Cue;->positionAnchor:I

    invoke-static {v12}, Landroidx/media3/ui/WebViewSubtitleOutput;->anchorTypeToTranslatePercent(I)I

    move-result v12

    .line 196
    .local v12, "positionAnchorTranslatePercent":I
    const/4 v13, 0x0

    .line 197
    .local v13, "lineMeasuredFromEnd":Z
    const/4 v14, 0x0

    .line 198
    .local v14, "lineAnchorTranslatePercent":I
    iget v15, v6, Landroidx/media3/common/text/Cue;->line:F

    cmpl-float v15, v15, v10

    const/high16 v16, 0x3f800000    # 1.0f

    const-string v7, "%.2f%%"

    if-eqz v15, :cond_3

    .line 199
    iget v15, v6, Landroidx/media3/common/text/Cue;->lineType:I

    packed-switch v15, :pswitch_data_0

    .line 211
    iget v10, v6, Landroidx/media3/common/text/Cue;->line:F

    mul-float/2addr v10, v11

    invoke-static {v10}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    filled-new-array {v10}, [Ljava/lang/Object;

    move-result-object v10

    invoke-static {v7, v10}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .line 214
    .local v10, "lineValue":Ljava/lang/String;
    iget v15, v6, Landroidx/media3/common/text/Cue;->verticalType:I

    if-ne v15, v8, :cond_2

    .line 215
    iget v15, v6, Landroidx/media3/common/text/Cue;->lineAnchor:I

    invoke-static {v15}, Landroidx/media3/ui/WebViewSubtitleOutput;->anchorTypeToTranslatePercent(I)I

    move-result v15

    neg-int v15, v15

    goto :goto_2

    .line 201
    .end local v10    # "lineValue":Ljava/lang/String;
    :pswitch_0
    iget v15, v6, Landroidx/media3/common/text/Cue;->line:F

    const/16 v17, 0x0

    cmpl-float v15, v15, v17

    const-string v10, "%.2fem"

    if-ltz v15, :cond_1

    .line 202
    iget v15, v6, Landroidx/media3/common/text/Cue;->line:F

    mul-float/2addr v15, v4

    invoke-static {v15}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v15

    filled-new-array {v15}, [Ljava/lang/Object;

    move-result-object v15

    invoke-static {v10, v15}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .restart local v10    # "lineValue":Ljava/lang/String;
    goto :goto_3

    .line 204
    .end local v10    # "lineValue":Ljava/lang/String;
    :cond_1
    iget v15, v6, Landroidx/media3/common/text/Cue;->line:F

    neg-float v15, v15

    sub-float v15, v15, v16

    mul-float/2addr v15, v4

    invoke-static {v15}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v15

    filled-new-array {v15}, [Ljava/lang/Object;

    move-result-object v15

    invoke-static {v10, v15}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .line 205
    .restart local v10    # "lineValue":Ljava/lang/String;
    const/4 v13, 0x1

    .line 207
    goto :goto_3

    .line 216
    :cond_2
    iget v15, v6, Landroidx/media3/common/text/Cue;->lineAnchor:I

    invoke-static {v15}, Landroidx/media3/ui/WebViewSubtitleOutput;->anchorTypeToTranslatePercent(I)I

    move-result v15

    :goto_2
    move v14, v15

    goto :goto_3

    .line 219
    .end local v10    # "lineValue":Ljava/lang/String;
    :cond_3
    iget v10, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->bottomPaddingFraction:F

    sub-float v16, v16, v10

    mul-float v16, v16, v11

    invoke-static/range {v16 .. v16}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v10

    filled-new-array {v10}, [Ljava/lang/Object;

    move-result-object v10

    invoke-static {v7, v10}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    .line 220
    .restart local v10    # "lineValue":Ljava/lang/String;
    const/16 v14, -0x64

    .line 224
    :goto_3
    iget v15, v6, Landroidx/media3/common/text/Cue;->size:F

    const v16, -0x800001

    cmpl-float v15, v15, v16

    if-eqz v15, :cond_4

    .line 225
    iget v15, v6, Landroidx/media3/common/text/Cue;->size:F

    mul-float/2addr v15, v11

    invoke-static {v15}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v11

    filled-new-array {v11}, [Ljava/lang/Object;

    move-result-object v11

    invoke-static {v7, v11}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v24, v7

    goto :goto_4

    .line 226
    :cond_4
    const-string v7, "fit-content"

    move-object/from16 v24, v7

    :goto_4
    nop

    .line 228
    .local v24, "size":Ljava/lang/String;
    iget-object v7, v6, Landroidx/media3/common/text/Cue;->textAlignment:Landroid/text/Layout$Alignment;

    invoke-static {v7}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertAlignmentToCss(Landroid/text/Layout$Alignment;)Ljava/lang/String;

    move-result-object v7

    .line 229
    .local v7, "textAlign":Ljava/lang/String;
    iget v11, v6, Landroidx/media3/common/text/Cue;->verticalType:I

    invoke-static {v11}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertVerticalTypeToCss(I)Ljava/lang/String;

    move-result-object v11

    .line 230
    .local v11, "writingMode":Ljava/lang/String;
    iget v15, v6, Landroidx/media3/common/text/Cue;->textSizeType:I

    iget v4, v6, Landroidx/media3/common/text/Cue;->textSize:F

    invoke-direct {v0, v15, v4}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertTextSizeToCss(IF)Ljava/lang/String;

    move-result-object v4

    .line 232
    .local v4, "cueTextSizeCssPx":Ljava/lang/String;
    iget-boolean v15, v6, Landroidx/media3/common/text/Cue;->windowColorSet:Z

    if-eqz v15, :cond_5

    iget v15, v6, Landroidx/media3/common/text/Cue;->windowColor:I

    goto :goto_5

    :cond_5
    iget-object v15, v0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    iget v15, v15, Landroidx/media3/ui/CaptionStyleCompat;->windowColor:I

    :goto_5
    invoke-static {v15}, Landroidx/media3/ui/HtmlUtils;->toCssRgba(I)Ljava/lang/String;

    move-result-object v15

    .line 236
    .local v15, "windowCssColor":Ljava/lang/String;
    iget v8, v6, Landroidx/media3/common/text/Cue;->verticalType:I

    const-string v18, "left"

    const-string v19, "right"

    packed-switch v8, :pswitch_data_1

    .line 247
    if-eqz v13, :cond_8

    const-string v8, "bottom"

    goto :goto_7

    .line 238
    :pswitch_1
    if-eqz v13, :cond_6

    move-object/from16 v18, v19

    :cond_6
    move-object/from16 v8, v18

    .line 239
    .local v8, "lineProperty":Ljava/lang/String;
    const-string v18, "top"

    .line 240
    .local v18, "positionProperty":Ljava/lang/String;
    move-object/from16 v32, v18

    goto :goto_8

    .line 242
    .end local v8    # "lineProperty":Ljava/lang/String;
    .end local v18    # "positionProperty":Ljava/lang/String;
    :pswitch_2
    if-eqz v13, :cond_7

    goto :goto_6

    :cond_7
    move-object/from16 v18, v19

    :goto_6
    move-object/from16 v8, v18

    .line 243
    .restart local v8    # "lineProperty":Ljava/lang/String;
    const-string v18, "top"

    .line 244
    .restart local v18    # "positionProperty":Ljava/lang/String;
    move-object/from16 v32, v18

    goto :goto_8

    .line 247
    .end local v8    # "lineProperty":Ljava/lang/String;
    .end local v18    # "positionProperty":Ljava/lang/String;
    :cond_8
    const-string v8, "top"

    .line 248
    .restart local v8    # "lineProperty":Ljava/lang/String;
    :goto_7
    const-string v18, "left"

    move-object/from16 v32, v18

    .line 254
    .local v32, "positionProperty":Ljava/lang/String;
    :goto_8
    move/from16 v33, v13

    .end local v13    # "lineMeasuredFromEnd":Z
    .local v33, "lineMeasuredFromEnd":Z
    iget v13, v6, Landroidx/media3/common/text/Cue;->verticalType:I

    const/4 v0, 0x2

    if-eq v13, v0, :cond_a

    iget v0, v6, Landroidx/media3/common/text/Cue;->verticalType:I

    const/4 v13, 0x1

    if-ne v0, v13, :cond_9

    goto :goto_9

    .line 259
    :cond_9
    const-string v0, "width"

    .line 260
    .local v0, "sizeProperty":Ljava/lang/String;
    move v13, v12

    .line 261
    .local v13, "horizontalTranslatePercent":I
    move/from16 v18, v14

    move/from16 v34, v18

    .local v18, "verticalTranslatePercent":I
    goto :goto_a

    .line 255
    .end local v0    # "sizeProperty":Ljava/lang/String;
    .end local v13    # "horizontalTranslatePercent":I
    .end local v18    # "verticalTranslatePercent":I
    :cond_a
    :goto_9
    const-string v0, "height"

    .line 256
    .restart local v0    # "sizeProperty":Ljava/lang/String;
    move v13, v14

    .line 257
    .restart local v13    # "horizontalTranslatePercent":I
    move/from16 v18, v12

    move/from16 v34, v18

    .line 264
    .local v34, "verticalTranslatePercent":I
    :goto_a
    move/from16 v35, v12

    .end local v12    # "positionAnchorTranslatePercent":I
    .local v35, "positionAnchorTranslatePercent":I
    iget-object v12, v6, Landroidx/media3/common/text/Cue;->text:Ljava/lang/CharSequence;

    .line 266
    invoke-virtual/range {p0 .. p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->getContext()Landroid/content/Context;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    move/from16 v36, v14

    .end local v14    # "lineAnchorTranslatePercent":I
    .local v36, "lineAnchorTranslatePercent":I
    invoke-virtual/range {v18 .. v18}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v14

    iget v14, v14, Landroid/util/DisplayMetrics;->density:F

    .line 265
    invoke-static {v12, v14}, Landroidx/media3/ui/SpannedToHtmlConverter;->convert(Ljava/lang/CharSequence;F)Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;

    move-result-object v12

    .line 267
    .local v12, "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v14

    :goto_b
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_d

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    move-object/from16 v19, v14

    move-object/from16 v14, v18

    check-cast v14, Ljava/lang/String;

    .line 269
    .local v14, "cssSelector":Ljava/lang/String;
    nop

    .line 270
    invoke-interface {v2, v14}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    move-object/from16 v37, v12

    .end local v12    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .local v37, "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    move-object/from16 v12, v18

    check-cast v12, Ljava/lang/String;

    invoke-interface {v2, v14, v12}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/lang/String;

    .line 271
    .local v12, "previousCssDeclarationBlock":Ljava/lang/String;
    if-eqz v12, :cond_c

    .line 273
    move-object/from16 v38, v3

    invoke-interface {v2, v14}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v12, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_b

    goto :goto_c

    :cond_b
    const/4 v3, 0x0

    goto :goto_d

    .line 271
    :cond_c
    move-object/from16 v38, v3

    .line 273
    :goto_c
    const/4 v3, 0x1

    .line 271
    :goto_d
    invoke-static {v3}, Landroidx/media3/common/util/Assertions;->checkState(Z)V

    .line 274
    .end local v12    # "previousCssDeclarationBlock":Ljava/lang/String;
    .end local v14    # "cssSelector":Ljava/lang/String;
    move-object/from16 v14, v19

    move-object/from16 v12, v37

    move-object/from16 v3, v38

    goto :goto_b

    .line 276
    .end local v37    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .local v12, "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    :cond_d
    move-object/from16 v38, v3

    move-object/from16 v37, v12

    .line 291
    .end local v12    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .restart local v37    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    .line 293
    invoke-static {v9}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v20

    .line 302
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    .line 303
    invoke-static/range {v34 .. v34}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v30

    .line 304
    invoke-static {v6}, Landroidx/media3/ui/WebViewSubtitleOutput;->getBlockShearTransformFunction(Landroidx/media3/common/text/Cue;)Ljava/lang/String;

    move-result-object v31

    move-object/from16 v19, v32

    move-object/from16 v21, v8

    move-object/from16 v22, v10

    move-object/from16 v23, v0

    move-object/from16 v25, v7

    move-object/from16 v26, v11

    move-object/from16 v27, v4

    move-object/from16 v28, v15

    filled-new-array/range {v18 .. v31}, [Ljava/lang/Object;

    move-result-object v3

    .line 277
    const-string v12, "<div style=\'position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;\'>"

    invoke-static {v12, v3}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 276
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    filled-new-array/range {v38 .. v38}, [Ljava/lang/Object;

    move-result-object v12

    .line 305
    const-string v14, "<span class=\'%s\'>"

    invoke-static {v14, v12}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 307
    iget-object v3, v6, Landroidx/media3/common/text/Cue;->multiRowAlignment:Landroid/text/Layout$Alignment;

    const-string v12, "</span>"

    if-eqz v3, :cond_e

    .line 308
    iget-object v3, v6, Landroidx/media3/common/text/Cue;->multiRowAlignment:Landroid/text/Layout$Alignment;

    .line 311
    invoke-static {v3}, Landroidx/media3/ui/WebViewSubtitleOutput;->convertAlignmentToCss(Landroid/text/Layout$Alignment;)Ljava/lang/String;

    move-result-object v3

    filled-new-array {v3}, [Ljava/lang/Object;

    move-result-object v3

    .line 309
    const-string v14, "<span style=\'display:inline-block; text-align:%s;\'>"

    invoke-static {v14, v3}, Landroidx/media3/common/util/Util;->formatInvariant(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 308
    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v18, v0

    move-object/from16 v14, v37

    .end local v0    # "sizeProperty":Ljava/lang/String;
    .end local v37    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .local v14, "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .local v18, "sizeProperty":Ljava/lang/String;
    iget-object v0, v14, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;->html:Ljava/lang/String;

    .line 312
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 313
    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_e

    .line 315
    .end local v14    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .end local v18    # "sizeProperty":Ljava/lang/String;
    .restart local v0    # "sizeProperty":Ljava/lang/String;
    .restart local v37    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    :cond_e
    move-object/from16 v18, v0

    move-object/from16 v14, v37

    .end local v0    # "sizeProperty":Ljava/lang/String;
    .end local v37    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .restart local v14    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .restart local v18    # "sizeProperty":Ljava/lang/String;
    iget-object v0, v14, Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;->html:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 318
    :goto_e
    invoke-virtual {v1, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "</div>"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 190
    .end local v4    # "cueTextSizeCssPx":Ljava/lang/String;
    .end local v6    # "cue":Landroidx/media3/common/text/Cue;
    .end local v7    # "textAlign":Ljava/lang/String;
    .end local v8    # "lineProperty":Ljava/lang/String;
    .end local v9    # "positionPercent":F
    .end local v10    # "lineValue":Ljava/lang/String;
    .end local v11    # "writingMode":Ljava/lang/String;
    .end local v13    # "horizontalTranslatePercent":I
    .end local v14    # "htmlAndCss":Landroidx/media3/ui/SpannedToHtmlConverter$HtmlAndCss;
    .end local v15    # "windowCssColor":Ljava/lang/String;
    .end local v18    # "sizeProperty":Ljava/lang/String;
    .end local v24    # "size":Ljava/lang/String;
    .end local v32    # "positionProperty":Ljava/lang/String;
    .end local v33    # "lineMeasuredFromEnd":Z
    .end local v34    # "verticalTranslatePercent":I
    .end local v35    # "positionAnchorTranslatePercent":I
    .end local v36    # "lineAnchorTranslatePercent":I
    add-int/lit8 v5, v5, 0x1

    const v4, 0x3f99999a    # 1.2f

    move-object/from16 v0, p0

    move-object/from16 v3, v38

    goto/16 :goto_0

    .line 321
    .end local v5    # "i":I
    :cond_f
    const-string v0, "</div></body></html>"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 323
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 324
    .local v0, "htmlHead":Ljava/lang/StringBuilder;
    const-string v3, "<html><head><style>"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 325
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_f
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_10

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 326
    .local v4, "cssSelector":Ljava/lang/String;
    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "{"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "}"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 327
    .end local v4    # "cssSelector":Ljava/lang/String;
    goto :goto_f

    .line 328
    :cond_10
    const-string v3, "</style></head>"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 329
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v4, v3}, Ljava/lang/StringBuilder;->insert(ILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 331
    move-object/from16 v3, p0

    iget-object v4, v3, Landroidx/media3/ui/WebViewSubtitleOutput;->webView:Landroid/webkit/WebView;

    .line 332
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    sget-object v6, Lcom/google/common/base/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v5, v6}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v5, v6}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v5

    .line 331
    const-string v6, "text/html"

    const-string v7, "base64"

    invoke-virtual {v4, v5, v6, v7}, Landroid/webkit/WebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .line 162
    iget-object v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 163
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 1
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .line 147
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 148
    if-eqz p1, :cond_0

    iget-object v0, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 151
    invoke-direct {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->updateWebView()V

    .line 153
    :cond_0
    return-void
.end method

.method public update(Ljava/util/List;Landroidx/media3/ui/CaptionStyleCompat;FIF)V
    .locals 8
    .param p2, "style"    # Landroidx/media3/ui/CaptionStyleCompat;
    .param p3, "textSize"    # F
    .param p4, "textSizeType"    # I
    .param p5, "bottomPaddingFraction"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroidx/media3/common/text/Cue;",
            ">;",
            "Landroidx/media3/ui/CaptionStyleCompat;",
            "FIF)V"
        }
    .end annotation

    .line 117
    .local p1, "cues":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    iput-object p2, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->style:Landroidx/media3/ui/CaptionStyleCompat;

    .line 118
    iput p3, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSize:F

    .line 119
    iput p4, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->defaultTextSizeType:I

    .line 120
    iput p5, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->bottomPaddingFraction:F

    .line 122
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 123
    .local v0, "bitmapCues":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v7, v1

    .line 124
    .local v7, "textCues":Ljava/util/List;, "Ljava/util/List<Landroidx/media3/common/text/Cue;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 125
    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroidx/media3/common/text/Cue;

    .line 126
    .local v2, "cue":Landroidx/media3/common/text/Cue;
    iget-object v3, v2, Landroidx/media3/common/text/Cue;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v3, :cond_0

    .line 127
    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 129
    :cond_0
    invoke-interface {v7, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 124
    .end local v2    # "cue":Landroidx/media3/common/text/Cue;
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 133
    .end local v1    # "i":I
    :cond_1
    iget-object v1, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v7}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 134
    :cond_2
    iput-object v7, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->textCues:Ljava/util/List;

    .line 138
    invoke-direct {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->updateWebView()V

    .line 140
    :cond_3
    iget-object v1, p0, Landroidx/media3/ui/WebViewSubtitleOutput;->canvasSubtitleOutput:Landroidx/media3/ui/CanvasSubtitleOutput;

    move-object v2, v0

    move-object v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-virtual/range {v1 .. v6}, Landroidx/media3/ui/CanvasSubtitleOutput;->update(Ljava/util/List;Landroidx/media3/ui/CaptionStyleCompat;FIF)V

    .line 142
    invoke-virtual {p0}, Landroidx/media3/ui/WebViewSubtitleOutput;->invalidate()V

    .line 143
    return-void
.end method
